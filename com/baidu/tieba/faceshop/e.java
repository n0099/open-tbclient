package com.baidu.tieba.faceshop;

import android.graphics.Bitmap;
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
public final class e {
    public static boolean a(String str, String str2, InputStream inputStream) {
        return com.baidu.tbadk.core.util.w.a(new StringBuilder(".emotions/").append(str).toString(), str2, inputStream) != null;
    }

    public static boolean a(String str) {
        com.baidu.tbadk.editortool.ac.a();
        Bitmap c = com.baidu.tbadk.editortool.ac.c(str, "panel.png");
        if (c == null) {
            return false;
        }
        c.recycle();
        return true;
    }

    public static boolean a(String str, String str2, String str3) {
        String str4 = com.baidu.tbadk.core.util.w.a + "/" + com.baidu.tbadk.core.data.n.f() + "/.emotions/" + str + "/";
        File file = new File(str4, str2);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(str4, str3);
        if (file2.exists()) {
            if (file2.delete() && file.renameTo(file2)) {
                return true;
            }
            return com.baidu.tbadk.core.util.w.f(file.getAbsolutePath(), file2.getAbsolutePath());
        } else if (file.renameTo(file2)) {
            return true;
        } else {
            return com.baidu.tbadk.core.util.w.f(file.getAbsolutePath(), file2.getAbsolutePath());
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
                        com.baidu.adp.lib.util.f.e("zip file name:" + name);
                        a(str, name, zipInputStream);
                    } else {
                        com.baidu.adp.lib.util.f.e("zip file dir:" + nextEntry.getName());
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.tbadk.core.util.l.a((InputStream) zipInputStream);
                    throw th;
                }
            }
            zipInputStream.close();
            com.baidu.tbadk.core.util.l.a((InputStream) zipInputStream);
            byte[] e = com.baidu.tbadk.core.util.w.e(".emotions/" + str, "map.txt");
            if (e == null) {
                throw new FileNotFoundException("map.txt file not exsit!");
            }
            String str2 = new String(e, "UTF-8");
            LinkedList linkedList = new LinkedList();
            for (String str3 : str2.split(IOUtils.LINE_SEPARATOR_UNIX)) {
                String trim = str3.trim();
                if (trim.startsWith("#(")) {
                    String[] split = trim.split("=");
                    if (split.length == 2) {
                        String trim2 = split[0].trim();
                        String trim3 = split[1].trim();
                        com.baidu.tbadk.editortool.ac.a();
                        a(str, "s_" + trim3 + ".png", com.baidu.tbadk.editortool.ac.a(trim2, false));
                        com.baidu.tbadk.editortool.ac.a();
                        a(str, "d_" + trim3 + ".gif", com.baidu.tbadk.editortool.ac.a(trim2, true));
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
