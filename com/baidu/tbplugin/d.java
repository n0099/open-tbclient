package com.baidu.tbplugin;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import dalvik.system.DexClassLoader;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d {
    private ClassLoader a;
    private Context b;
    private boolean c;

    public d(Context context) {
        this.b = context;
    }

    public final synchronized void a() {
        boolean z = this.c;
        String str = "";
        File[] listFiles = f.a().listFiles();
        if (listFiles != null && listFiles.length != 0) {
            StringBuilder sb = new StringBuilder();
            for (File file : listFiles) {
                sb.append(file.getAbsolutePath());
                sb.append(File.pathSeparator);
            }
            str = sb.substring(0, sb.length() - 1);
        }
        this.a = new DexClassLoader(str, f.e().getAbsolutePath(), f.c().getAbsolutePath(), this.b.getClassLoader());
        Context context = this.b;
        ClassLoader classLoader = this.a;
        try {
            Object obj = Build.VERSION.SDK_INT <= 7 ? f.a(Class.forName("android.app.ApplicationContext"), "mPackageInfo").get(context.getApplicationContext()) : f.a(Class.forName("android.app.ContextImpl"), "mPackageInfo").get(f.a(ContextWrapper.class, "mBase").get(context.getApplicationContext()));
            f.a(obj.getClass(), "mClassLoader").set(obj, classLoader);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            com.baidu.adp.lib.util.e.b("IllegalAccessException");
            this.c = false;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            com.baidu.adp.lib.util.e.b("IllegalArgumentException");
            this.c = false;
        } catch (Throwable th) {
            com.baidu.adp.lib.util.e.b("Throwable " + th.getMessage());
            this.c = false;
        }
    }

    public final ClassLoader b() {
        return this.a;
    }
}
