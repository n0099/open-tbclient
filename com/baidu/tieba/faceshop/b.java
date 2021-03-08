package com.baidu.tieba.faceshop;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes8.dex */
public class b {
    public static boolean a(String str, String str2, InputStream inputStream) {
        return com.baidu.tbadk.core.util.o.saveFile(new StringBuilder().append(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath()).append("/").append(new StringBuilder().append(".emotions/").append(str).toString()).append("/").append(str2).toString(), inputStream) != null;
    }

    public static byte[] eT(String str, String str2) {
        return com.baidu.tbadk.core.util.o.GetFileData(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + (".emotions/" + str) + "/" + str2);
    }

    public static boolean JH(String str) {
        Bitmap eQ = eQ(str, "panel.png");
        if (eQ == null) {
            return false;
        }
        eQ.recycle();
        return true;
    }

    public static boolean aF(String str, String str2, String str3) {
        String str4 = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.emotions/" + str + "/";
        File file = new File(str4, str2);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(str4, str3);
        if (file2.exists()) {
            if (file2.delete() && file.renameTo(file2)) {
                return true;
            }
            return com.baidu.tbadk.core.util.o.dO(file.getAbsolutePath(), file2.getAbsolutePath());
        } else if (file.renameTo(file2)) {
            return true;
        } else {
            return com.baidu.tbadk.core.util.o.dO(file.getAbsolutePath(), file2.getAbsolutePath());
        }
    }

    public static List<String> c(String str, InputStream inputStream) throws Exception {
        ZipInputStream zipInputStream;
        try {
            zipInputStream = new ZipInputStream(new BufferedInputStream(inputStream));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    } else if (!nextEntry.isDirectory()) {
                        a(str, nextEntry.getName(), zipInputStream);
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.n.close((InputStream) zipInputStream);
                    throw th;
                }
            }
            zipInputStream.close();
            com.baidu.adp.lib.util.n.close((InputStream) zipInputStream);
            byte[] eT = eT(str, "map.txt");
            if (eT == null) {
                throw new FileNotFoundException("map.txt file not exsit!");
            }
            String str2 = new String(eT, "UTF-8");
            LinkedList linkedList = new LinkedList();
            for (String str3 : str2.split("\n")) {
                String trim = str3.trim();
                if (trim.startsWith("#(")) {
                    String[] split = trim.split("=");
                    if (split.length == 2) {
                        String trim2 = split[0].trim();
                        String trim3 = split[1].trim();
                        aF(str, "s_" + trim3 + ".png", aM(trim2, false));
                        aF(str, "d_" + trim3 + ".gif", aM(trim2, true));
                        linkedList.add(trim2);
                    }
                }
            }
            return linkedList;
        } catch (Throwable th2) {
            th = th2;
            zipInputStream = null;
        }
    }

    public static String aM(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return (z ? "d_" : "s_") + hashCode;
    }

    public static String j(String str, boolean z, boolean z2) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        String str2 = (z ? "s_" : "d_") + hashCode;
        if (z2 && !z) {
            return str2 + ".gif";
        }
        return str2 + ".jpg";
    }

    public static Bitmap eQ(String str, String str2) {
        return com.baidu.tbadk.core.util.o.getImage(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + (".emotions/" + str) + "/" + str2);
    }
}
