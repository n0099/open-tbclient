package com.baidu.tieba.faceshop;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class e {
    public static String a(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode + ".bak";
    }

    public static boolean a(String str, String str2, InputStream inputStream) {
        return com.baidu.tbadk.core.util.x.a(new StringBuilder(".emotions/").append(str).toString(), str2, inputStream) != null;
    }

    public static byte[] a(String str, String str2) {
        return com.baidu.tbadk.core.util.x.e(".emotions/" + str, str2);
    }

    public static boolean a(String str) {
        Bitmap c = com.baidu.tbadk.editortool.ac.a().c(str, "panel.png");
        if (c == null) {
            return false;
        }
        c.recycle();
        return true;
    }

    public static boolean a(String str, String str2, String str3) {
        String str4 = com.baidu.tbadk.core.util.x.a + "/" + TbConfig.getTempDirName() + "/.emotions/" + str + "/";
        File file = new File(str4, str2);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(str4, str3);
        if (file2.exists()) {
            if (file2.delete() && file.renameTo(file2)) {
                return true;
            }
            return com.baidu.tbadk.core.util.x.f(file.getAbsolutePath(), file2.getAbsolutePath());
        } else if (file.renameTo(file2)) {
            return true;
        } else {
            return com.baidu.tbadk.core.util.x.f(file.getAbsolutePath(), file2.getAbsolutePath());
        }
    }

    public static List<String> a(String str, InputStream inputStream) {
        ZipInputStream zipInputStream;
        try {
            zipInputStream = new ZipInputStream(new BufferedInputStream(inputStream));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    } else if (!nextEntry.isDirectory()) {
                        String name = nextEntry.getName();
                        BdLog.d("zip file name:" + name);
                        a(str, name, zipInputStream);
                    } else {
                        BdLog.d("zip file dir:" + nextEntry.getName());
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.tbadk.core.util.m.a((InputStream) zipInputStream);
                    throw th;
                }
            }
            zipInputStream.close();
            com.baidu.tbadk.core.util.m.a((InputStream) zipInputStream);
            byte[] a = a(str, "map.txt");
            if (a == null) {
                throw new FileNotFoundException("map.txt file not exsit!");
            }
            String str2 = new String(a, "UTF-8");
            LinkedList linkedList = new LinkedList();
            for (String str3 : str2.split(IOUtils.LINE_SEPARATOR_UNIX)) {
                String trim = str3.trim();
                if (trim.startsWith("#(")) {
                    String[] split = trim.split("=");
                    if (split.length == 2) {
                        String trim2 = split[0].trim();
                        String trim3 = split[1].trim();
                        a(str, "s_" + trim3 + ".png", com.baidu.tbadk.editortool.ac.a().a(trim2, false));
                        a(str, "d_" + trim3 + ".gif", com.baidu.tbadk.editortool.ac.a().a(trim2, true));
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
