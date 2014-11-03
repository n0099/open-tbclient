package com.baidu.tieba.faceshop;

import android.graphics.Bitmap;
import com.baidu.tbadk.TbConfig;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class e {
    public static boolean b(String str, String str2, InputStream inputStream) {
        return com.baidu.tbadk.core.util.s.a(new StringBuilder(".emotions/").append(str).toString(), str2, inputStream) != null;
    }

    public static byte[] ad(String str, String str2) {
        return com.baidu.tbadk.core.util.s.L(".emotions/" + str, str2);
    }

    public static boolean eK(String str) {
        Bitmap U = com.baidu.tbadk.editortool.aa.rB().U(str, "panel.png");
        if (U == null) {
            return false;
        }
        U.recycle();
        return true;
    }

    public static boolean k(String str, String str2, String str3) {
        String str4 = com.baidu.tbadk.core.util.s.mI + "/" + TbConfig.getTempDirName() + "/.emotions/" + str + "/";
        File file = new File(str4, str2);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(str4, str3);
        if (file2.exists()) {
            if (file2.delete() && file.renameTo(file2)) {
                return true;
            }
            return com.baidu.tbadk.core.util.s.M(file.getAbsolutePath(), file2.getAbsolutePath());
        } else if (file.renameTo(file2)) {
            return true;
        } else {
            return com.baidu.tbadk.core.util.s.M(file.getAbsolutePath(), file2.getAbsolutePath());
        }
    }

    public static List<String> b(String str, InputStream inputStream) {
        ZipInputStream zipInputStream;
        try {
            zipInputStream = new ZipInputStream(new BufferedInputStream(inputStream));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    } else if (!nextEntry.isDirectory()) {
                        b(str, nextEntry.getName(), zipInputStream);
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.util.p.a((InputStream) zipInputStream);
                    throw th;
                }
            }
            zipInputStream.close();
            com.baidu.adp.lib.util.p.a((InputStream) zipInputStream);
            byte[] ad = ad(str, "map.txt");
            if (ad == null) {
                throw new FileNotFoundException("map.txt file not exsit!");
            }
            String str2 = new String(ad, "UTF-8");
            LinkedList linkedList = new LinkedList();
            for (String str3 : str2.split("\n")) {
                String trim = str3.trim();
                if (trim.startsWith("#(")) {
                    String[] split = trim.split("=");
                    if (split.length == 2) {
                        String trim2 = split[0].trim();
                        String trim3 = split[1].trim();
                        k(str, "s_" + trim3 + ".png", com.baidu.tbadk.editortool.aa.rB().m(trim2, false));
                        k(str, "d_" + trim3 + ".gif", com.baidu.tbadk.editortool.aa.rB().m(trim2, true));
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
}
