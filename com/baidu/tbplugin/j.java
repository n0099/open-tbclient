package com.baidu.tbplugin;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.tbplugin.plugins.BdBrowserDelegate;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.apache.commons.io.FileUtils;
/* loaded from: classes.dex */
public final class j {
    public static final String a = f.f();
    public static final String b = "/plugins/" + a;
    static final List<Class<?>> c;
    private static j f;
    private boolean d;
    private Executor e;
    private Map<String, Object> g = new HashMap();
    private e h;
    private final File i;
    private final File j;
    private final File k;
    private final File l;
    private final File m;
    private final d n;

    static {
        ArrayList arrayList = new ArrayList();
        c = arrayList;
        arrayList.add(BdBrowserDelegate.class);
    }

    @SuppressLint({"SdCardPath"})
    private j(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            filesDir = new File("/data/data/" + context.getPackageName() + "/files/");
            try {
                if (!filesDir.exists()) {
                    FileUtils.forceMkdir(filesDir);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String absolutePath = filesDir.getAbsolutePath();
        this.l = new File(String.valueOf(absolutePath) + "/plugins/");
        if (!this.l.exists()) {
            this.l.mkdirs();
        }
        this.i = new File(String.valueOf(absolutePath) + "/plugins/libs/");
        if (!this.i.exists()) {
            this.i.mkdirs();
        }
        this.j = new File(String.valueOf(absolutePath) + b);
        if (!this.j.exists()) {
            this.j.mkdirs();
        }
        this.k = new File(String.valueOf(absolutePath) + "/plugins/resources/");
        if (!this.k.exists()) {
            this.k.mkdirs();
        }
        this.m = new File(String.valueOf(absolutePath) + "/plugins/optimised/");
        if (!this.m.exists()) {
            this.m.mkdirs();
        }
        this.h = new i();
        this.n = new d(context);
        this.e = Executors.newSingleThreadExecutor();
    }

    public static void a(Context context) {
        f = new j(context);
    }

    public static j a() {
        return f;
    }

    private <P> P c(Class<P> cls) {
        com.baidu.tbplugin.a.a aVar = (com.baidu.tbplugin.a.a) f.a((Class<?>) cls, (Class<Annotation>) com.baidu.tbplugin.a.a.class);
        if (aVar != null) {
            try {
                return (P) this.n.b().loadClass(aVar.b()).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (NullPointerException e5) {
                e5.printStackTrace();
            } catch (InvocationTargetException e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }

    public final <P> P a(Class<P> cls) {
        if (!this.d) {
            i();
        }
        com.baidu.tbplugin.a.c cVar = (com.baidu.tbplugin.a.c) f.a((Class<?>) cls, (Class<Annotation>) com.baidu.tbplugin.a.c.class);
        if (cVar != null) {
            return (P) this.g.get(cVar.a());
        }
        return null;
    }

    public final <P> void b(Class<P> cls) {
        com.baidu.tbplugin.a.c cVar = (com.baidu.tbplugin.a.c) f.a((Class<?>) cls, (Class<Annotation>) com.baidu.tbplugin.a.c.class);
        for (Object obj : this.g.values()) {
            if (obj.getClass().equals(cls)) {
                this.g.remove(cVar.a());
                return;
            }
        }
    }

    public final e b() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File c() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File d() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File e() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File f() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File g() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Executor h() {
        return this.e;
    }

    private synchronized void i() {
        this.n.a();
        for (Class<?> cls : this.h.a(3)) {
            this.g.put(((com.baidu.tbplugin.a.c) f.a(cls, com.baidu.tbplugin.a.c.class)).a(), c(cls));
        }
        this.d = true;
    }
}
