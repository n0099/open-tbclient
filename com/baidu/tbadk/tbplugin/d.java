package com.baidu.tbadk.tbplugin;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
import dalvik.system.DexClassLoader;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d {
    private ClassLoader a;
    private ClassLoader b;
    private Context c;
    private boolean d;

    public d(Context context) {
        this.c = context;
        this.b = this.c.getClassLoader();
    }

    public synchronized void a() {
        if (!this.d) {
            String str = "";
            File[] listFiles = i.a().listFiles();
            if (listFiles != null && listFiles.length != 0) {
                StringBuilder sb = new StringBuilder();
                for (File file : listFiles) {
                    sb.append(file.getAbsolutePath());
                    sb.append(File.pathSeparator);
                }
                str = sb.substring(0, sb.length() - 1);
            }
            try {
                this.a = new DexClassLoader(str, i.e().getAbsolutePath(), i.c().getAbsolutePath(), this.c.getClassLoader());
            } catch (Exception e) {
                i.b(this.c, "ClassLoader initial failed: Nested Exception: " + e.getMessage());
            }
            a(this.c, this.a);
        }
    }

    public synchronized void b() {
        this.a = null;
        a(this.c, this.b);
        this.d = false;
    }

    private void a(Context context, ClassLoader classLoader) {
        Object obj;
        try {
            if (Build.VERSION.SDK_INT <= 7) {
                obj = i.a(Class.forName("android.app.ApplicationContext"), "mPackageInfo").get(context.getApplicationContext());
            } else {
                obj = i.a(Class.forName("android.app.ContextImpl"), "mPackageInfo").get(i.a(ContextWrapper.class, "mBase").get(context.getApplicationContext()));
            }
            i.a(obj.getClass(), "mClassLoader").set(obj, classLoader);
        } catch (IllegalAccessException e) {
            BdLog.e("IllegalAccessException");
            this.d = false;
        } catch (IllegalArgumentException e2) {
            BdLog.e("IllegalArgumentException");
            this.d = false;
        } catch (Throwable th) {
            BdLog.e("Throwable " + th.getMessage());
            this.d = false;
        }
    }

    public ClassLoader c() {
        return this.a;
    }
}
