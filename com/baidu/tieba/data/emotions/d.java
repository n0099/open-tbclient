package com.baidu.tieba.data.emotions;

import android.graphics.Bitmap;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.r;
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
public final class d {
    public static String a(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        return String.valueOf(z ? "d_" : "s_") + hashCode;
    }

    public static boolean a(String str, String str2, InputStream inputStream) {
        return af.a(new StringBuilder(".emotions/").append(str).toString(), str2, inputStream) != null;
    }

    public static Bitmap a(String str, String str2) {
        return af.c(".emotions/" + str, str2);
    }

    public static com.baidu.adp.widget.ImageView.b b(String str, String str2) {
        File file = new File(af.a + "/" + com.baidu.tieba.data.i.k() + "/.emotions/" + str + "/", str2);
        if (file.exists()) {
            if (!UtilHelper.a(1024)) {
                Bitmap a = a(str, str2);
                if (a != null) {
                    return new com.baidu.adp.widget.ImageView.b(a, false, str2);
                }
                return null;
            }
            return com.baidu.adp.gif.b.a().a(file.getAbsolutePath());
        }
        return null;
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
        String str4 = af.a + "/" + com.baidu.tieba.data.i.k() + "/.emotions/" + str + "/";
        File file = new File(str4, str2);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(str4, str3);
        if (file2.exists()) {
            if (file2.delete() && file.renameTo(file2)) {
                return true;
            }
            return af.e(file.getAbsolutePath(), file2.getAbsolutePath());
        } else if (file.renameTo(file2)) {
            return true;
        } else {
            return af.e(file.getAbsolutePath(), file2.getAbsolutePath());
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
                        com.baidu.adp.lib.util.e.e("zip file name:" + name);
                        a(str, name, zipInputStream);
                    } else {
                        com.baidu.adp.lib.util.e.e("zip file dir:" + nextEntry.getName());
                    }
                } catch (Throwable th) {
                    th = th;
                    r.a((InputStream) zipInputStream);
                    throw th;
                }
            }
            zipInputStream.close();
            r.a((InputStream) zipInputStream);
            byte[] d = af.d(".emotions/" + str, "map.txt");
            if (d == null) {
                throw new FileNotFoundException("map.txt file not exsit!");
            }
            String str2 = new String(d, "UTF-8");
            LinkedList linkedList = new LinkedList();
            for (String str3 : str2.split(IOUtils.LINE_SEPARATOR_UNIX)) {
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
