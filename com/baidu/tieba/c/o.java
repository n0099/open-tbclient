package com.baidu.tieba.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.zeus.NotificationProxy;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class o {
    public static final File a = Environment.getExternalStorageDirectory();

    public static boolean a() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public static String b() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals(Environment.MEDIA_REMOVED)) {
            return TiebaApplication.b().getString(R.string.error_no_sdcard);
        }
        if (externalStorageState.equals(Environment.MEDIA_UNMOUNTED) || externalStorageState.equals(Environment.MEDIA_UNMOUNTABLE)) {
            return TiebaApplication.b().getString(R.string.error_sd_unmount);
        }
        if (externalStorageState.equals(Environment.MEDIA_SHARED)) {
            return TiebaApplication.b().getString(R.string.error_sd_shared);
        }
        return TiebaApplication.b().getString(R.string.error_sd_error);
    }

    public static boolean a(String str) {
        if (a()) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    return file.mkdir();
                } catch (Exception e) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean c() {
        return a(a + "/tieba/");
    }

    public static boolean b(String str) {
        if (a()) {
            try {
                return new File(new StringBuilder().append(a).append("/").append("tieba").append("/").append(str).toString()).exists();
            } catch (Exception e) {
                af.b("FileHelper", "CheckFile", "error = " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean a(String str, String str2) {
        if (a()) {
            try {
                return new File(new StringBuilder().append(a).append("/").append("tieba").append("/").append(str).append("/").append(str2).toString()).exists();
            } catch (Exception e) {
                af.b("FileHelper", "CheckFile", "error = " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static File c(String str) {
        if (c()) {
            File file = new File(a + "/tieba/" + str);
            try {
                if (file.exists()) {
                    return file;
                }
                return null;
            } catch (SecurityException e) {
                af.b("FileHelper", "GetFile", "error = " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File d(String str) {
        if (!c()) {
            return null;
        }
        return new File(a + "/tieba/" + str);
    }

    public static File e(String str) {
        if (c()) {
            File file = new File(a + "/tieba/" + str);
            try {
                if (!file.exists() || file.delete()) {
                    if (file.createNewFile()) {
                        return file;
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                af.b("FileHelper", "CreateFile", "error = " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File f(String str) {
        if (c()) {
            File file = new File(a + "/tieba/" + str);
            try {
                if (file.exists()) {
                    return file;
                }
                if (file.createNewFile()) {
                    return file;
                }
                return null;
            } catch (Exception e) {
                af.b("FileHelper", "CreateFile", "error = " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [323=4, 324=4, 326=4, 327=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x00bd */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(String str, String str2) {
        FileInputStream fileInputStream;
        IOException e;
        boolean z;
        FileNotFoundException e2;
        FileInputStream fileInputStream2 = null;
        ?? sb = new StringBuilder(String.valueOf(str != null ? a + "/tieba/" + str + "/" : a + "/tieba/"));
        try {
            try {
                fileInputStream = new FileInputStream(new File(sb.append(str2).toString()));
                try {
                    byte[] bArr = new byte[7];
                    z = fileInputStream.read(bArr, 0, 6) == 6 ? ah.a(bArr) : false;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (FileNotFoundException e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            return z;
                        } catch (IOException e5) {
                            e = e5;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                }
                            }
                            return z;
                        }
                    } else {
                        fileInputStream2 = fileInputStream;
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e8) {
                    e2 = e8;
                    z = false;
                } catch (IOException e9) {
                    e = e9;
                    z = false;
                }
            } catch (Throwable th) {
                th = th;
                if (sb != 0) {
                    try {
                        sb.close();
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e11) {
            fileInputStream = null;
            e2 = e11;
            z = false;
        } catch (IOException e12) {
            fileInputStream = null;
            e = e12;
            z = false;
        } catch (Throwable th2) {
            th = th2;
            sb = 0;
            if (sb != 0) {
            }
            throw th;
        }
        return z;
    }

    public static String a(String str, String str2, Bitmap bitmap, int i) {
        String str3;
        if (str != null) {
            str3 = a + "/tieba/" + str + "/";
        } else {
            str3 = a + "/tieba/";
        }
        if (!a(str3) || bitmap == null) {
            return null;
        }
        File file = new File(String.valueOf(str3) + str2);
        try {
            if ((!file.exists() || file.delete()) && file.createNewFile()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getPath();
            }
            return null;
        } catch (Exception e) {
            af.b("FileHelper", "SaveFile", e.getMessage());
            return null;
        }
    }

    public static Bitmap c(String str, String str2) {
        String str3;
        if (str != null) {
            str3 = a + "/tieba/" + str + "/";
        } else {
            str3 = a + "/tieba/";
        }
        return BitmapFactory.decodeFile(String.valueOf(str3) + str2);
    }

    public static String a(String str, byte[] bArr) {
        return a(null, str, bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [418=4, 419=4, 421=4, 422=4] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2, byte[] bArr) {
        String str3;
        FileOutputStream fileOutputStream;
        if (!a(str != null ? a + "/tieba/" + str + "/" : a + "/tieba/") || bArr == null || str2 == null) {
            return null;
        }
        File file = new File(String.valueOf(str3) + str2);
        FileOutputStream fileOutputStream2 = null;
        try {
            if ((file.exists() && !file.delete()) || !file.createNewFile()) {
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e) {
                        af.b("FileHelper", "SaveFile", "error = " + e.getMessage());
                    }
                }
                return null;
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                try {
                    fileOutputStream.write(bArr, 0, bArr.length);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    FileOutputStream fileOutputStream3 = null;
                    String path = file.getPath();
                    if (0 != 0) {
                        try {
                            fileOutputStream3.close();
                            return path;
                        } catch (Exception e2) {
                            af.b("FileHelper", "SaveFile", "error = " + e2.getMessage());
                            return path;
                        }
                    }
                    return path;
                } catch (IOException e3) {
                    e = e3;
                    af.b("FileHelper", "SaveFile", "error = " + e.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e4) {
                            af.b("FileHelper", "SaveFile", "error = " + e4.getMessage());
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e5) {
                        af.b("FileHelper", "SaveFile", "error = " + e5.getMessage());
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    public static byte[] d(String str, String str2) {
        String str3;
        if (!c() || str2 == null) {
            return null;
        }
        if (str != null) {
            str3 = a + "/tieba/" + str + "/";
        } else {
            str3 = a + "/tieba/";
        }
        File file = new File(String.valueOf(str3) + str2);
        try {
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(NotificationProxy.MAX_URL_LENGTH);
                byte[] bArr = new byte[NotificationProxy.MAX_URL_LENGTH];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, NotificationProxy.MAX_URL_LENGTH);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return byteArrayOutputStream.toByteArray();
            }
            return null;
        } catch (IOException e) {
            af.b("FileHelper", "GetFileData", "error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [485=4, 486=4, 488=4, 489=4, 492=4, 493=4, 495=4, 496=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x00ce */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:63:0x0129 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:69:0x0132 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:76:0x004e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.String] */
    public static boolean e(String str, String str2) {
        File file;
        File file2;
        FileInputStream fileInputStream = null;
        fileInputStream = 0;
        fileInputStream = 0;
        r2 = null;
        FileInputStream fileInputStream2 = null;
        fileInputStream = null;
        InputStream inputStream = null;
        ?? r1 = 0;
        String str3 = a + "/tieba/" + str2;
        try {
            try {
                file = new File(a + "/tieba/" + str);
                file2 = new File(str3);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
            r1 = 0;
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
        }
        if (!file.exists()) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    af.b("FileHelper", "CopyFile", e2.toString());
                }
            }
            if (0 != 0) {
                try {
                    r1.close();
                } catch (Exception e3) {
                    af.b("FileHelper", "CopyFile", e3.toString());
                }
            }
            return false;
        }
        FileInputStream fileInputStream3 = new FileInputStream(file);
        try {
            r1 = new FileOutputStream(file2);
        } catch (Exception e4) {
            e = e4;
            r1 = 0;
            fileInputStream2 = fileInputStream3;
        } catch (Throwable th3) {
            th = th3;
            r1 = 0;
            fileInputStream = fileInputStream3;
        }
        try {
            byte[] bArr = new byte[NotificationProxy.MAX_URL_LENGTH];
            while (true) {
                int read = fileInputStream3.read(bArr);
                if (read <= 0) {
                    break;
                }
                r1.write(bArr, 0, read);
            }
            fileInputStream3.close();
            InputStream inputStream2 = null;
            try {
                r1.close();
                r1 = 0;
                r1 = 0;
                if (0 != 0) {
                    try {
                        inputStream2.close();
                    } catch (Exception e5) {
                        af.b("FileHelper", "CopyFile", e5.toString());
                    }
                }
                if (0 != 0) {
                    try {
                        r1.close();
                    } catch (Exception e6) {
                        r1 = "FileHelper";
                        fileInputStream = "CopyFile";
                        af.b("FileHelper", "CopyFile", e6.toString());
                    }
                }
            } catch (Exception e7) {
                e = e7;
                af.b("FileHelper", "CopyFile", e.toString());
                fileInputStream = fileInputStream2;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                        fileInputStream = fileInputStream2;
                    } catch (Exception e8) {
                        af.b("FileHelper", "CopyFile", e8.toString());
                        fileInputStream = "FileHelper";
                    }
                }
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (Exception e9) {
                        r1 = "FileHelper";
                        fileInputStream = "CopyFile";
                        af.b("FileHelper", "CopyFile", e9.toString());
                    }
                }
                return false;
            }
        } catch (Exception e10) {
            e = e10;
            fileInputStream2 = fileInputStream3;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = fileInputStream3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e11) {
                    af.b("FileHelper", "CopyFile", e11.toString());
                }
            }
            if (r1 != 0) {
                try {
                    r1.close();
                } catch (Exception e12) {
                    af.b("FileHelper", "CopyFile", e12.toString());
                }
            }
            throw th;
        }
        return false;
    }

    public static InputStream g(String str) {
        return a(c(str));
    }

    public static InputStream a(File file) {
        if (file != null) {
            try {
                return new FileInputStream(file);
            } catch (Exception e) {
                af.b("FileHelper", "GetStreamFromFile", "error = " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static boolean h(String str) {
        if (c()) {
            File file = new File(a + "/tieba/" + str);
            try {
                if (file.exists()) {
                    return file.delete();
                }
                return false;
            } catch (Exception e) {
                af.b("FileHelper", "DelFile", "error = " + e.getMessage());
                return false;
            }
        }
        return false;
    }
}
