package com.baidu.tbplugin;

import android.content.Context;
import com.baidu.tbplugin.plugins.BdBrowserDelegate;
import com.baidu.tbplugin.plugins.MotuPlugin;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
/* loaded from: classes.dex */
public class j {
    public static final String a = f.f();
    public static final String b = "/plugins/" + a;
    static final List<Class<?>> c = new ArrayList();
    private static j e;
    private boolean d;
    private Map<String, Object> f = new HashMap();
    private e g;
    private final File h;
    private final File i;
    private final File j;
    private final File k;
    private final File l;
    private final d m;
    private final Context n;

    static {
        c.add(BdBrowserDelegate.class);
        c.add(MotuPlugin.class);
    }

    private j(Context context) {
        this.n = context;
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            filesDir = new File("/data/data/" + context.getPackageName() + "/files/");
            try {
                if (!filesDir.exists()) {
                    FileUtils.forceMkdir(filesDir);
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        String absolutePath = filesDir.getAbsolutePath();
        this.k = new File(String.valueOf(absolutePath) + "/plugins/");
        if (!this.k.exists()) {
            this.k.mkdirs();
        }
        this.h = new File(String.valueOf(absolutePath) + "/plugins/libs/");
        if (!this.h.exists()) {
            this.h.mkdirs();
        }
        this.i = new File(String.valueOf(absolutePath) + b);
        if (!this.i.exists()) {
            this.i.mkdirs();
        }
        this.j = new File(String.valueOf(absolutePath) + "/plugins/resources/");
        if (!this.j.exists()) {
            this.j.mkdirs();
        }
        this.l = new File(String.valueOf(absolutePath) + "/plugins/optimised/");
        if (!this.l.exists()) {
            this.l.mkdirs();
        }
        this.g = new i(context);
        this.m = new d(context);
    }

    private void i() {
        for (Class<?> cls : this.g.a(3)) {
            com.baidu.tbplugin.a.a aVar = (com.baidu.tbplugin.a.a) f.a(cls, com.baidu.tbplugin.a.a.class);
            com.baidu.tbplugin.a.c cVar = (com.baidu.tbplugin.a.c) f.a(cls, com.baidu.tbplugin.a.c.class);
            if (aVar != null) {
                try {
                    this.f.put(cVar.a(), this.m.b().loadClass(aVar.b()).getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                } catch (InstantiationException e4) {
                    e4.printStackTrace();
                } catch (NoSuchMethodException e5) {
                    e5.printStackTrace();
                } catch (NullPointerException e6) {
                    e6.printStackTrace();
                } catch (InvocationTargetException e7) {
                    e7.printStackTrace();
                }
            }
        }
    }

    public static void a(Context context) {
        e = new j(context);
    }

    public static j a() {
        return e;
    }

    public <P> P a(Class<P> cls) {
        if (!this.d) {
            h();
        }
        com.baidu.tbplugin.a.c cVar = (com.baidu.tbplugin.a.c) f.a((Class<?>) cls, (Class<Annotation>) com.baidu.tbplugin.a.c.class);
        if (cVar != null) {
            return (P) this.f.get(cVar.a());
        }
        return null;
    }

    public e b() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File c() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File d() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File e() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File f() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File g() {
        return this.l;
    }

    public synchronized void h() {
        this.m.a();
        i();
        this.d = true;
    }
}
