package com.baidu.tieba.c;
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.a.c {
    private com.baidu.tieba.a.af f;
    private boolean e = false;
    private al g = null;
    private am h = null;

    public ak() {
        this.f = null;
        this.f = new com.baidu.tieba.a.af();
    }

    public boolean d() {
        return this.e;
    }

    public void a(am amVar) {
        this.h = amVar;
    }

    public void a(com.baidu.tieba.a.af afVar) {
        this.f = afVar;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public String e() {
        if (this.f != null) {
            return this.f.g();
        }
        return null;
    }

    public void f() {
        if (this.g != null) {
            this.g.cancel();
        }
        this.g = new al(this, true);
        this.g.setPriority(3);
        this.g.execute(new Boolean[0]);
    }

    public void g() {
        if (this.g != null) {
            this.g.cancel();
        }
        this.g = new al(this, false);
        this.g.setPriority(3);
        this.g.execute(new Boolean[0]);
    }

    public boolean h() {
        if (this.g != null) {
            this.g.cancel();
            return false;
        }
        return false;
    }
}
