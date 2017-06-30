package com.baidu.tieba.VideoCache;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;
/* loaded from: classes2.dex */
public class o {
    private static final String TAG = o.class.getSimpleName();

    public static long hi(String str) {
        long j;
        long j2 = 0;
        long hj = hj(str);
        if (str == null || str.isEmpty()) {
            j = 0;
        } else {
            File file = new File(String.valueOf(j.aUm) + str);
            if (file == null || !file.exists() || !file.isDirectory()) {
                return 0L;
            }
            File file2 = new File(String.valueOf(file.getAbsolutePath()) + "/completed");
            j = (file2 == null || !file2.exists()) ? 0L : file2.length();
            File file3 = new File(String.valueOf(file.getAbsolutePath()) + "/completed.temp");
            if (file3 != null && file3.exists()) {
                j2 = file3.length();
            }
        }
        return j + j2 + hj;
    }

    public static long hj(String str) {
        File file;
        File file2;
        File[] listFiles;
        long j = 0;
        if (str != null && !str.isEmpty() && (file = new File(String.valueOf(j.aUm) + str)) != null && file.exists() && file.isDirectory() && (file2 = new File(String.valueOf(file.getAbsolutePath()) + "/segments")) != null && file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length != 0) {
            for (File file3 : listFiles) {
                if (file3 != null && file3.exists()) {
                    j += file3.length();
                }
            }
        }
        return j;
    }

    public static long Ks() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        }
        return 0L;
    }

    public static synchronized long getFileSize(File file) {
        long j;
        synchronized (o.class) {
            j = 0;
            if (file != null) {
                if (file.exists()) {
                    j = file.length();
                }
            }
        }
        return j;
    }

    public static void z(File file) {
        if (file != null) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    file.delete();
                    return;
                }
                for (File file2 : listFiles) {
                    z(file2);
                }
                file.delete();
            }
        }
    }

    public static String hk(String str) {
        if (str == null || !str.contains("/")) {
            return null;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (substring != null && substring.contains(".mp4")) {
            return substring.replace(".mp4", "");
        }
        return substring;
    }
}
