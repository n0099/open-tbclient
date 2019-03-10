package com.baidu.tieba.VideoCache;

import android.os.StatFs;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes4.dex */
public class m {
    private static final String TAG = m.class.getSimpleName();

    public static long qz(String str) {
        long j;
        long j2 = 0;
        long qA = qA(str);
        if (str == null || str.isEmpty()) {
            j = 0;
        } else {
            File file = new File(i.cLR + str);
            if (file == null || !file.exists() || !file.isDirectory()) {
                return 0L;
            }
            File file2 = new File(file.getAbsolutePath() + "/completed");
            j = (file2 == null || !file2.exists()) ? 0L : file2.length();
            File file3 = new File(file.getAbsolutePath() + "/completed.temp");
            if (file3 != null && file3.exists()) {
                j2 = file3.length();
            }
        }
        return j + j2 + qA;
    }

    public static long qA(String str) {
        File file;
        File file2;
        File[] listFiles;
        long j = 0;
        if (str != null && !str.isEmpty() && (file = new File(i.cLR + str)) != null && file.exists() && file.isDirectory() && (file2 = new File(file.getAbsolutePath() + "/segments")) != null && file2.exists() && file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length != 0) {
            for (File file3 : listFiles) {
                if (file3 != null && file3.exists()) {
                    j += file3.length();
                }
            }
        }
        return j;
    }

    public static long avT() {
        StatFs statFs = new StatFs(TbadkCoreApplication.getInst().getCacheDir().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static synchronized long o(File file) {
        long j;
        synchronized (m.class) {
            j = 0;
            if (file != null) {
                if (file.exists()) {
                    j = file.length();
                }
            }
        }
        return j;
    }

    public static void O(File file) {
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
                    O(file2);
                }
                file.delete();
            }
        }
    }

    public static String qB(String str) {
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
