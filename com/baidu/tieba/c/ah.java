package com.baidu.tieba.c;
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.a.c {
    private com.baidu.tieba.a.af f;
    private boolean e = false;
    private ai g = null;
    private aj h = null;

    public ah() {
        this.f = null;
        this.f = new com.baidu.tieba.a.af();
    }

    public boolean d() {
        return this.e;
    }

    public void a(aj ajVar) {
        this.h = ajVar;
    }

    public void a(com.baidu.tieba.a.af afVar) {
        this.f = afVar;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void e() {
        if (this.g != null) {
            this.g.cancel();
        }
        this.g = new ai(this, true);
        this.g.setPriority(3);
        this.g.execute(new Boolean[0]);
    }

    public void f() {
        if (this.g != null) {
            this.g.cancel();
        }
        this.g = new ai(this, false);
        this.g.setPriority(3);
        this.g.execute(new Boolean[0]);
    }

    public boolean g() {
        if (this.g != null) {
            this.g.cancel();
            return false;
        }
        return false;
    }
}
