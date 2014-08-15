package com.baidu.tbadk.pluginArch;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g {
    private ClassLoader a;
    private ClassLoader b;
    private LinkedList<File> c = new LinkedList<>();
    private LinkedList<File> d = new LinkedList<>();
    private Context e;
    private boolean f;

    public g(Context context) {
        this.e = context;
        this.b = this.e.getClassLoader();
    }

    public void a(File file) {
        this.c.add(file);
        if (this.f) {
            b();
            a();
        }
    }

    public void b(File file) {
        this.d.add(file);
        if (this.f) {
            b();
            a();
        }
    }

    public synchronized void a() {
        String str;
        String str2;
        if (!this.f) {
            StringBuilder sb = new StringBuilder();
            Iterator<File> it = this.c.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getAbsolutePath());
                sb.append(File.pathSeparator);
            }
            if (sb.length() <= 0) {
                str = "";
            } else {
                str = sb.substring(0, sb.length() - 1);
            }
            StringBuilder sb2 = new StringBuilder();
            Iterator<File> it2 = this.d.iterator();
            while (it2.hasNext()) {
                File next = it2.next();
                File[] listFiles = next.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    sb2.append(next);
                    sb2.append(File.pathSeparator);
                }
            }
            if (sb2.length() <= 0) {
                str2 = "";
            } else {
                str2 = sb2.substring(0, sb2.length() - 1);
            }
            this.a = new DexClassLoader(str, m.a().getAbsolutePath(), str2, this.e.getClassLoader());
            a(this.e, this.a);
            this.f = true;
        }
    }

    public synchronized void b() {
        this.a = null;
        a(this.e, this.b);
        this.f = false;
    }

    private void a(Context context, ClassLoader classLoader) {
        Object obj;
        try {
            if (Build.VERSION.SDK_INT <= 7) {
                obj = a(Class.forName("android.app.ApplicationContext"), "mPackageInfo").get(context.getApplicationContext());
            } else {
                obj = a(Class.forName("android.app.ContextImpl"), "mPackageInfo").get(a(ContextWrapper.class, "mBase").get(context.getApplicationContext()));
            }
            a(obj.getClass(), "mClassLoader").set(obj, classLoader);
            t.a("plugin_dexloader");
        } catch (IllegalAccessException e) {
            BdLog.e("IllegalAccessException");
            this.f = false;
            t.a("plugin_dexloader", e.getMessage(), null);
        } catch (IllegalArgumentException e2) {
            BdLog.e("IllegalArgumentException");
            this.f = false;
            t.a("plugin_dexloader", e2.getMessage(), null);
        } catch (Throwable th) {
            BdLog.e("Throwable " + th.getMessage());
            this.f = false;
            t.a("plugin_dexloader", th.getMessage(), null);
        }
    }

    public ClassLoader c() {
        return this.a;
    }

    private Field a(Class<?> cls, String str) {
        Field[] declaredFields;
        for (Field field : cls.getDeclaredFields()) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            if (field.getName().equals(str)) {
                return field;
            }
        }
        return null;
    }
}
