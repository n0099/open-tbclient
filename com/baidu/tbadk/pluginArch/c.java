package com.baidu.tbadk.pluginArch;
/* loaded from: classes.dex */
public class c {
    private boolean a = false;
    private String b;
    private aa c;

    public c(aa aaVar) {
        this.c = aaVar;
        this.b = aaVar.a;
    }

    public String a() {
        return this.b;
    }

    public boolean b() {
        if (i()) {
            return false;
        }
        if (!f()) {
            u.a("plugin_load", "load resources fail", this.b);
            return false;
        } else if (!g()) {
            u.a("plugin_load", "validate so lib fail", this.b);
            return false;
        } else {
            e();
            if (!h()) {
                u.a("plugin_load", "validate class fail", this.b);
                return false;
            }
            this.a = true;
            u.a("plugin_load");
            return true;
        }
    }

    private void e() {
        d.a().g().a(n.a(this.b));
        d.a().g().b(n.c(this.b));
    }

    private boolean f() {
        if (this.c.f == 0) {
            return y.a().a(this.b);
        }
        return true;
    }

    private boolean g() {
        return true;
    }

    public boolean c() {
        if (this.b == null) {
            return false;
        }
        return d.a().d(this.b);
    }

    public <P> P a(Class<P> cls) {
        if (!i() && !b()) {
            u.a("plugin_getinst", "plugin load fail", this.b);
            return null;
        } else if (cls != null) {
            if (this.c.h == null) {
                u.a("plugin_getinst", "xml class name is null", this.b);
                return null;
            }
            try {
                P p = (P) d.a().g().c().loadClass(this.c.h).getConstructor(new Class[0]).newInstance(new Object[0]);
                u.a("plugin_getinst");
                return p;
            } catch (Exception e) {
                if (!j()) {
                    u.a("plugin_getinst", "file not exist", this.b);
                    return null;
                }
                u.a("plugin_getinst", e.getMessage(), this.b);
                return null;
            }
        } else {
            return null;
        }
    }

    private boolean h() {
        Class<?> loadClass;
        if (this.c.g == null) {
            return false;
        }
        try {
            ClassLoader c = d.a().g().c();
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

    private boolean i() {
        return this.a;
    }

    public int d() {
        if (this.c == null) {
            return -1;
        }
        return this.c.e;
    }

    private boolean j() {
        return this.b != null && n.f(this.b).exists() && n.d(this.b).exists();
    }
}
