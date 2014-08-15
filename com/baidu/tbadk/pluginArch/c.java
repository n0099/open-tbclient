package com.baidu.tbadk.pluginArch;
/* loaded from: classes.dex */
public class c {
    private boolean a = false;
    private String b;
    private z c;

    public c(z zVar) {
        this.c = zVar;
        this.b = zVar.a;
    }

    public String a() {
        return this.b;
    }

    public boolean b() {
        if (d()) {
            return false;
        }
        if (!g()) {
            t.a("plugin_load", "load resources fail", this.b);
            return false;
        } else if (!h()) {
            t.a("plugin_load", "validate so lib fail", this.b);
            return false;
        } else {
            f();
            if (!i()) {
                t.a("plugin_load", "validate class fail", this.b);
                return false;
            }
            this.a = true;
            t.a("plugin_load");
            return true;
        }
    }

    private void f() {
        d.a().f().a(m.a(this.b));
        d.a().f().b(m.c(this.b));
    }

    private boolean g() {
        if (this.c.f == 0) {
            return x.a().a(this.b);
        }
        return true;
    }

    private boolean h() {
        return true;
    }

    public boolean c() {
        if (this.b == null) {
            return false;
        }
        return d.a().d(this.b);
    }

    public <P> P a(Class<P> cls) {
        if (!d() || cls == null || this.c.h == null) {
            return null;
        }
        try {
            P p = (P) d.a().f().c().loadClass(this.c.h).getConstructor(new Class[0]).newInstance(new Object[0]);
            t.a("plugin_getinst");
            return p;
        } catch (Exception e) {
            if (!j()) {
                t.a("plugin_getinst", "file not exist", this.b);
                return null;
            }
            t.a("plugin_getinst", e.getMessage(), this.b);
            return null;
        }
    }

    private boolean i() {
        Class<?> loadClass;
        if (this.c.g == null) {
            return false;
        }
        try {
            ClassLoader c = d.a().f().c();
            if (c == null || (loadClass = c.loadClass(this.c.h)) == null) {
                return false;
            }
            Class<?>[] interfaces = loadClass.getInterfaces();
            for (Class<?> cls : interfaces) {
                if (cls.getName().equals(this.c.g)) {
                    return true;
                }
            }
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public boolean d() {
        return this.a;
    }

    public int e() {
        if (this.c == null) {
            return -1;
        }
        return this.c.e;
    }

    private boolean j() {
        return this.b != null && m.f(this.b).exists() && m.d(this.b).exists();
    }
}
