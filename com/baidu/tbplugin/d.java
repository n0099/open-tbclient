package com.baidu.tbplugin;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private ClassLoader a;
    private Context b;
    private boolean c;
    private List<ClassLoader> d = new ArrayList();

    public d(Context context) {
        this.b = context;
    }

    public synchronized void a() {
        if (!this.c || c()) {
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
            com.baidu.adp.lib.util.f.d("load jars path: " + str);
            this.a = new DexClassLoader(str, f.e().getAbsolutePath(), f.c().getAbsolutePath(), this.b.getClassLoader());
            a(this.b, this.a);
            com.baidu.adp.lib.util.f.c("New ClassLoader initialized");
        }
    }

    private boolean c() {
        this.d.clear();
        return true;
    }

    private void a(Context context, ClassLoader classLoader) {
        Object obj;
        try {
            if (Build.VERSION.SDK_INT <= 7) {
                obj = f.a(Class.forName("android.app.ApplicationContext"), "mPackageInfo").get(context.getApplicationContext());
            } else {
                obj = f.a(Class.forName("android.app.ContextImpl"), "mPackageInfo").get(f.a(ContextWrapper.class, "mBase").get(context.getApplicationContext()));
            }
            f.a(obj.getClass(), "mClassLoader").set(obj, classLoader);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            com.baidu.adp.lib.util.f.b("IllegalAccessException");
            this.c = false;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            com.baidu.adp.lib.util.f.b("IllegalArgumentException");
            this.c = false;
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b("Throwable " + th.getMessage());
            this.c = false;
        }
    }

    public ClassLoader b() {
        return this.a;
    }
}
