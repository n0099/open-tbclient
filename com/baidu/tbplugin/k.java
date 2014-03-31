package com.baidu.tbplugin;

import android.annotation.SuppressLint;
import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.apache.commons.io.FileUtils;
/* loaded from: classes.dex */
public final class k {
    public static final String a;
    public static final String b;
    static final List<String> c;
    private static k f;
    private boolean d;
    private Executor e;
    private Map<String, Object> g = new HashMap();
    private f h;
    private final File i;
    private final File j;
    private final File k;
    private final File l;
    private final File m;
    private final e n;
    private Context o;

    static {
        String substring = System.getProperty("os.arch", "arm").substring(0, 3);
        if (substring.equals("i68")) {
            substring = "x86";
        }
        a = substring;
        b = "/plugins/" + a;
        c = new ArrayList();
    }

    @SuppressLint({"SdCardPath"})
    private k(Context context) {
        this.o = context;
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            filesDir = new File("/data/data/" + context.getPackageName() + "/files/");
            try {
                if (!filesDir.exists()) {
                    FileUtils.forceMkdir(filesDir);
                }
            } catch (IOException e) {
                g.a(context, String.valueOf(filesDir.getAbsolutePath()) + " directory create failed");
            }
        }
        String absolutePath = filesDir.getAbsolutePath();
        this.l = new File(String.valueOf(absolutePath) + "/plugins/");
        if (!this.l.exists()) {
            try {
                FileUtils.forceMkdir(this.l);
            } catch (IOException e2) {
                g.a(context, String.valueOf(this.l.getAbsolutePath()) + " plugins directory create failed");
            }
        }
        this.i = new File(String.valueOf(absolutePath) + "/plugins/libs/");
        if (!this.i.exists()) {
            try {
                FileUtils.forceMkdir(this.i);
            } catch (IOException e3) {
                g.a(context, String.valueOf(this.i.getAbsolutePath()) + " directory create failed");
            }
        }
        this.j = new File(String.valueOf(absolutePath) + b);
        if (!this.j.exists()) {
            try {
                FileUtils.forceMkdir(this.j);
            } catch (IOException e4) {
                g.a(context, String.valueOf(this.j.getAbsolutePath()) + " directory create failed");
            }
        }
        this.k = new File(String.valueOf(absolutePath) + "/plugins/resources/");
        if (!this.k.exists()) {
            try {
                FileUtils.forceMkdir(this.k);
            } catch (IOException e5) {
                g.a(context, String.valueOf(this.k.getAbsolutePath()) + " directory create failed");
            }
        }
        this.m = new File(String.valueOf(absolutePath) + "/plugins/optimised/");
        if (!this.m.exists()) {
            try {
                FileUtils.forceMkdir(this.m);
            } catch (IOException e6) {
                g.a(context, String.valueOf(this.m.getAbsolutePath()) + " directory create failed");
            }
        }
        this.h = new j();
        this.n = new e(context);
        this.e = Executors.newSingleThreadExecutor();
    }

    public static void a(Context context) {
        f = new k(context);
    }

    public static k a() {
        return f;
    }

    private <P> P c(Class<P> cls) {
        if (cls == null) {
            return null;
        }
        com.baidu.tbplugin.a.a aVar = (com.baidu.tbplugin.a.a) cls.getAnnotation(com.baidu.tbplugin.a.a.class);
        if (aVar != null) {
            try {
                return (P) this.n.b().loadClass(aVar.b()).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                Context context = this.o;
                String str = String.valueOf(cls.getName()) + " Nested Exception: " + e.getMessage();
                com.baidu.adp.lib.stats.g.a().a("plugin", "load", 1, "failed", str);
                com.baidu.adp.lib.util.f.b("Plugin load failed: " + str);
            }
        }
        return null;
    }

    public final <P> P a(Class<P> cls) {
        if (!this.d) {
            h();
        }
        com.baidu.tbplugin.a.c cVar = (com.baidu.tbplugin.a.c) cls.getAnnotation(com.baidu.tbplugin.a.c.class);
        if (cVar != null) {
            P p = (P) this.g.get(cVar.a());
            if (p == null) {
                com.baidu.adp.lib.util.f.b("Plugin not found: " + cls.getName());
                return p;
            }
            return p;
        }
        com.baidu.adp.lib.util.f.b("Plugin not found: " + cls.getName());
        return null;
    }

    public final <P> void b(Class<P> cls) {
        com.baidu.tbplugin.a.c cVar = (com.baidu.tbplugin.a.c) cls.getAnnotation(com.baidu.tbplugin.a.c.class);
        for (Object obj : this.g.values()) {
            if (obj.getClass().equals(cls)) {
                this.g.remove(cVar.a());
                return;
            }
        }
    }

    public static void a(String str) {
        c.add(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File b() {
        if (!this.i.exists()) {
            try {
                FileUtils.forceMkdir(this.i);
            } catch (IOException e) {
                g.a(this.o, String.valueOf(this.i.getAbsolutePath()) + " directory created failed");
            }
        }
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File c() {
        if (!this.k.exists()) {
            try {
                FileUtils.forceMkdir(this.k);
            } catch (IOException e) {
                g.a(this.o, String.valueOf(this.k.getAbsolutePath()) + " directory created failed");
            }
        }
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File d() {
        if (!this.j.exists()) {
            try {
                FileUtils.forceMkdir(this.j);
            } catch (IOException e) {
                g.a(this.o, String.valueOf(this.j.getAbsolutePath()) + " directory created failed");
            }
        }
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File e() {
        if (!this.l.exists()) {
            try {
                FileUtils.forceMkdir(this.l);
            } catch (IOException e) {
                g.a(this.o, String.valueOf(this.l.getAbsolutePath()) + " directory created failed");
            }
        }
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File f() {
        if (!this.m.exists()) {
            try {
                FileUtils.forceMkdir(this.m);
            } catch (IOException e) {
                g.a(this.o, String.valueOf(this.m.getAbsolutePath()) + " directory created failed");
            }
        }
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Executor g() {
        return this.e;
    }

    public final synchronized void h() {
        this.n.a();
        for (Class<?> cls : this.h.a(3)) {
            com.baidu.tbplugin.a.c cVar = (com.baidu.tbplugin.a.c) cls.getAnnotation(com.baidu.tbplugin.a.c.class);
            Object c2 = c(cls);
            if (c2 != null) {
                this.g.put(cVar.a(), c2);
            }
        }
        this.d = true;
    }

    public final e i() {
        return this.n;
    }
}
