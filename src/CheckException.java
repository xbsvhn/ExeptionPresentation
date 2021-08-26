import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckException{
    FileReader f = new FileReader("abc");

    public CheckException() throws FileNotFoundException {
    }
}

class Main {
    public static void main(String[] args) {
        try {
            BufferedReader fileInput = null;
            FileReader file = new FileReader("C:\\test\\a.txt");
            fileInput = new BufferedReader(file);

            // Print first 3 lines of file "C:\test\a.txt"
            for (int counter = 0; counter < 3; counter++)
                System.out.println(fileInput.readLine());

            fileInput.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }catch (IOException e){
            System.out.println("File not found nhé");
            e.printStackTrace();
        }
    }
}

class TestTryCatch1 {
    public static void main(String args[]) {
        int data = 50 / 0;  // ném ra ngoại lê ở đây
        System.out.println("rest of the code...");
    }
}

class TestTryCatch2 {
    public static void main(String args[]) {
        try {
            int data = 50 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
        System.out.println("rest of the code...");
    }
}


class TestException {
    public static void main(String args[]) {
        try {
            try {
                System.out.println("Thuc hien phep chia");
                int b = 39 / 0;
            } catch (ArithmeticException e) {
                System.out.println(e);
            }

            try {
                int a[] = new int[5];
                a[5] = 4;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
            }

            System.out.println("khoi lenh khac");
        } catch (Exception e) {
            System.out.println("xy ly ngoai le");
        }

        System.out.println("tiep tuc chuong trinh..");
    }
}

class TestFinallyBlock {
    public static void main(String args[]) {
        try {
            int data = 25 / 5;
            System.out.println(data);
        } catch (NullPointerException e) {
            System.out.println(e);
        } finally {
            System.out.println("finally block is always executed");
        }
        System.out.println("rest of the code...");
    }
}

class TestFinallyBlock1 {
    public static void main(String args[]) {
        try {
            int data = 25 / 0;
            System.out.println(data);
        } catch (NullPointerException e) {
            System.out.println(e);
        } finally {
            System.out.println("finally block is always executed");
        }
        System.out.println("rest of the code...");
    }
}

class TestFinallyBlock2 {
    public static void main(String args[]) {
        try {
            int data = 25 / 0;
            System.out.println(data);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            System.out.println("finally block is always executed");
        }
        System.out.println("rest of the code...");
    }
}

class TestFinallyBlock3 {
    public static void main(String args[]) {
        try {
            int data = 25;
            if (data % 2 != 0) {
                System.out.println(data + " is odd number");
                return;
            }
        } catch (ArithmeticException e) {
            System.out.println(e);
        } finally {
            System.out.println("finally block is always executed");
        }
        System.out.println("rest of the code...");
    }
}

class TestThrow2 {
    static void validate(int age) {
        try {
            if (age < 18)
                throw new ArithmeticException("not valid");
            else
                System.out.println("welcome");
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String args[]) {
        validate(13);
        System.out.println("rest of the code...");
    }
}

class TestThrows1 {
    void m() throws IOException {
        throw new IOException("Loi thiet bi");// checked exception
    }

    void n() throws IOException {
        m();
    }

    void p() {
        try {
            n();
        } catch (Exception e) {
            System.out.println("ngoai le duoc xu ly");
        }
    }

    public static void main(String args[]) {
        TestThrows1 obj = new TestThrows1();
        obj.p();
        System.out.println("luong binh thuong...");
    }
}

//Trong trường hợp bạn khai báo throws ngoại lệ, nếu ngoại lệ không xảy ra, code sẽ được thực hiện tốt.
class M {
    void method() throws IOException {
        System.out.println("Thiet bi dang hoat dong tot");
    }
}

class TestThrows2 {
    public static void main(String args[]) throws IOException {
        M m = new M();
        m.method();
        System.out.println("Luong binh thuong...");
    }
}

// Trong trường hợp bạn khai báo throws ngoại lệ, nếu ngoại lệ xảy ra
// một ngoại lệ sẽ được ném ra tại runtime vì throws nên không xử lý ngoại đó
class M1 {
    void method() throws IOException {
        throw new IOException("Thiet bi");
    }
}

class TestThrows21 {
    public static void main(String args[]) throws IOException {
        M1 m = new M1();
        m.method();
        System.out.println("Luong binh thuong...");
    }
}

/*
class Parent {
    void msg() {
        System.out.println("parent");
    }
}
class ExceptionChildExample extends Parent {
    void msg() throws ArithmeticException{ //IOException { // không thể khai báo ném ra ngoại lệ checked
        System.out.println("TestExceptionChild");
    }

    public static void main(String args[]) {
        Parent p = new ExceptionChildExample();
        p.msg();
    }
}
*/

class Parent {
    void msg() throws Exception {
        System.out.println("parent");
    }
}
class ExceptionChildExample extends Parent {
    // Exception Exception is not compatible with throws clause in Parent.msg()
    void msg() throws IOException {
        // Không thể khai báo ném ra ngoại lệ cha
        throw new IOException("Nhap sai");
    }

    public static void main(String args[])  {
        ExceptionChildExample p = new ExceptionChildExample();
        try {
            p.msg();
        } catch (IOException e) {
        }
    }
}


//Custom Exeption
class InvalidAgeException extends Exception {
    InvalidAgeException(String s) {
        super(s);
    }
}
class CustomExceptionExample {

    static void validate(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("not valid");
        } else {
            System.out.println("welcome to vote");
        }
    }

    public static void main(String args[]) {
        try {
            validate(13);
        } catch (Exception m) {
            System.out.println("Exception occured: " + m);
        }

        System.out.println("rest of the code...");
    }
}