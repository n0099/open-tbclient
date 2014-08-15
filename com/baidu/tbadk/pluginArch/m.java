package com.baidu.tbadk.pluginArch;

import android.annotation.SuppressLint;
import android.content.Context;
import java.io.File;
import java.io.IOException;
/* loaded from: classes.dex */
public class m {
    public static final String a = o.c();
    private static String b = null;

    @SuppressLint({"SdCardPath"})
    private static String c() {
        if (b == null) {
            Context context = d.a().a;
            File filesDir = context.getFilesDir();
            if (filesDir == null) {
                filesDir = new File(context.getFilesDir().getAbsolutePath());
                try {
                    if (!filesDir.exists()) {
                        com.baidu.adp.lib.util.commonsio.a.e(filesDir);
                    }
                } catch (IOException e) {
                }
            }
            b = filesDir.getAbsolutePath();
        }
        return b;
    }

    public static File a(String str) {
        return f(str);
    }

    public static File b(String str) {
        return f(str);
    }

    public static File c(String str) {
        File file = new File(String.valueOf(e(str).getAbsolutePath()) + "/so/" + a);
        if (!file.exists()) {
            try {
                com.baidu.adp.lib.util.commonsio.a.e(file);
            } catch (IOException e) {
            }
        }
        return file;
    }

    public static File d(String str) {
        if (str == null) {
            return null;
        }
        return new File(String.valueOf(e(str).getAbsolutePath()) + "/plugin.xml");
    }

    public static File e(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(String.valueOf(c()) + "/pluginsEX/" + str);
        if (!file.exists()) {
            try {
                com.baidu.adp.lib.util.commonsio.a.e(file);
                return file;
            } catch (IOException e) {
                return file;
            }
        }
        return file;
    }

    public static File f(String str) {
        if (str == null) {
            return null;
        }
        return new File(String.valueOf(e(str).getAbsolutePath()) + "/" + str + ".apk");
    }

    public static File a() {
        File file = new File(String.valueOf(c()) + "/pluginsEX/optimised/");
        if (!file.exists()) {
            try {
                com.baidu.adp.lib.util.commonsio.a.e(file);
            } catch (IOException e) {
            }
        }
        return file;
    }

    public static File g(String str) {
        File file = new File(String.valueOf(c()) + "/pluginsEX/download/", str);
        if (!file.exists()) {
            try {
                com.baidu.adp.lib.util.commonsio.a.e(file);
            } catch (IOException e) {
            }
        }
        return file;
    }

    public static File b() {
        return new File(String.valueOf(c()) + "/pluginsEX/InstallConfig.xml");
    }

    public static File h(String str) {
        File e = e(str);
        if (e != null) {
            return new File(e, "EnableConfig.xml");
        }
        return null;
    }
}
