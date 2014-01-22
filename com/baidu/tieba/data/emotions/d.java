package com.baidu.tieba.data.emotions;

import android.graphics.Bitmap;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ad;
import com.baidu.tieba.util.p;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class d {
    public static String a(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return (z ? "d_" : "s_") + hashCode;
    }

    public static boolean a(String str, String str2, InputStream inputStream) {
        return ad.a(new StringBuilder().append(".emotions/").append(str).toString(), str2, inputStream) != null;
    }

    public static Bitmap a(String str, String str2) {
        return ad.c(".emotions/" + str, str2);
    }

    public static com.baidu.adp.widget.ImageView.d b(String str, String str2) {
        File file = new File(ad.a + "/tieba/.emotions/" + str + "/", str2);
        if (file.exists()) {
            if (!UtilHelper.a(1024)) {
                Bitmap a = a(str, str2);
                if (a != null) {
                    return new com.baidu.adp.widget.ImageView.d(a, false, str2);
                }
                return null;
            }
            return com.baidu.adp.gif.b.a().a(file.getAbsolutePath());
        }
        return null;
    }

    public static byte[] c(String str, String str2) {
        return ad.d(".emotions/" + str, str2);
    }

    public static boolean a(String str) {
        Bitmap a = a(str, "panel.png");
        if (a == null) {
            return false;
        }
        a.recycle();
        return true;
    }

    public static boolean a(String str, String str2, String str3) {
        String str4 = ad.a + "/tieba/.emotions/" + str + "/";
        File file = new File(str4, str2);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(str4, str3);
        if (file2.exists()) {
            if (file2.delete() && file.renameTo(file2)) {
                return true;
            }
            return ad.e(file.getAbsolutePath(), file2.getAbsolutePath());
        } else if (file.renameTo(file2)) {
            return true;
        } else {
            return ad.e(file.getAbsolutePath(), file2.getAbsolutePath());
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
                        com.baidu.adp.lib.g.e.d("zip file name:" + name);
                        a(str, name, zipInputStream);
                    } else {
                        com.baidu.adp.lib.g.e.d("zip file dir:" + nextEntry.getName());
                    }
                } catch (Throwable th) {
                    th = th;
                    p.a((InputStream) zipInputStream);
                    throw th;
                }
            }
            zipInputStream.close();
            p.a((InputStream) zipInputStream);
            byte[] c = c(str, "map.txt");
            if (c == null) {
                throw new FileNotFoundException("map.txt file not exsit!");
            }
            String str2 = new String(c, "UTF-8");
            LinkedList linkedList = new LinkedList();
            for (String str3 : str2.split("\n")) {
                String trim = str3.trim();
                if (trim.startsWith("#(")) {
                    String[] split = trim.split("=");
                    if (split.length == 2) {
                        String trim2 = split[0].trim();
                        String trim3 = split[1].trim();
                        a(str, "s_" + trim3 + ".png", a(trim2, false));
                        a(str, "d_" + trim3 + ".gif", a(trim2, true));
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
