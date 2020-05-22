package com.baidu.tieba.ala.alaar.sticker.b;

import android.os.Environment;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
/* loaded from: classes3.dex */
public class c {
    private static String TAG = "FileUtils";

    public static final String getFileFullName(String str) {
        return str.substring(str.lastIndexOf("/") + 1, str.length());
    }

    public static boolean copyFile(String str, String str2) throws IOException {
        return g(new FileInputStream(str), str2);
    }

    public static boolean g(InputStream inputStream, String str) throws IOException {
        int i = 0;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            byte[] bArr = new byte[1444];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                i += read;
                fileOutputStream.write(bArr, 0, read);
            }
            return true;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void deleteFileOrDir(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    int length = listFiles.length;
                    for (int i = 0; i < length; i++) {
                        if (listFiles[i].isFile()) {
                            listFiles[i].delete();
                        } else {
                            deleteFileOrDir(listFiles[i]);
                        }
                    }
                }
                file.delete();
            }
        } catch (Exception e) {
            a.e(TAG, e.getMessage());
        }
    }

    public static void k(File file, File file2) throws ZipException, IOException {
        if (!file2.exists()) {
            file2.mkdirs();
        }
        String absolutePath = file2.getAbsolutePath();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            String name = nextElement.getName();
            if (!"./".equals(name) && !".".equals(name) && !name.endsWith("/")) {
                InputStream inputStream = zipFile.getInputStream(nextElement);
                File file3 = new File(absolutePath + File.separator + name);
                if (!file3.exists()) {
                    File parentFile = file3.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    file3.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                byte[] bArr = new byte[10240];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                inputStream.close();
                fileOutputStream.close();
            }
        }
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str) || !checkFile(str)) {
            return false;
        }
        return deleteFile(new File(str));
    }

    public static boolean deleteFile(File file) {
        try {
            return file.delete();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkFile(String str) {
        if (!checkSD() || StringUtils.isNull(str)) {
            return false;
        }
        try {
            return new File(str).exists();
        } catch (Exception e) {
            a.e("TAG", e.toString());
            return false;
        }
    }

    public static boolean checkSD() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean a(File[] fileArr, File file) {
        boolean z;
        boolean z2 = true;
        if (fileArr != null && fileArr.length != 0 && file != null) {
            try {
                if (!file.exists()) {
                    file.mkdirs();
                }
                int length = fileArr.length;
                int i = 0;
                while (i < length) {
                    File file2 = fileArr[i];
                    if (file2 != null && file2.exists()) {
                        z = copyFile(file2.getAbsolutePath(), new File(file, file2.getName()).getAbsolutePath());
                        if (!z) {
                            i++;
                            z2 = z;
                        }
                    }
                    z = z2;
                    i++;
                    z2 = z;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z2;
    }
}
