package com.baidu.tbplugin;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import dalvik.system.DexClassLoader;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e {
    private ClassLoader a;
    private Context b;
    private boolean c;

    public e(Context context) {
        this.b = context;
    }

    public final synchronized void a() {
        boolean z = this.c;
        String str = "";
        File[] listFiles = k.a().b().listFiles();
        if (listFiles != null && listFiles.length != 0) {
            StringBuilder sb = new StringBuilder();
            for (File file : listFiles) {
                sb.append(file.getAbsolutePath());
                sb.append(File.pathSeparator);
            }
            str = sb.substring(0, sb.length() - 1);
        }
        try {
            this.a = new DexClassLoader(str, k.a().f().getAbsolutePath(), k.a().d().getAbsolutePath(), this.b.getClassLoader());
        } catch (Exception e) {
            g.a(this.b, "ClassLoader initial failed: Nested Exception: " + e.getMessage());
        }
        Context context = this.b;
        ClassLoader classLoader = this.a;
        try {
            try {
                Object obj = Build.VERSION.SDK_INT <= 7 ? g.a(Class.forName("android.app.ApplicationContext"), "mPackageInfo").get(context.getApplicationContext()) : g.a(Class.forName("android.app.ContextImpl"), "mPackageInfo").get(g.a(ContextWrapper.class, "mBase").get(context.getApplicationContext()));
                g.a(obj.getClass(), "mClassLoader").set(obj, classLoader);
            } catch (IllegalArgumentException e2) {
                com.baidu.adp.lib.util.f.b("IllegalArgumentException");
                this.c = false;
            }
        } catch (IllegalAccessException e3) {
            com.baidu.adp.lib.util.f.b("IllegalAccessException");
            this.c = false;
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b("Throwable " + th.getMessage());
            this.c = false;
        }
    }

    public final ClassLoader b() {
        return this.a;
    }
}
