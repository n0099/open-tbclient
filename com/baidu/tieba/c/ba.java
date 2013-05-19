package com.baidu.tieba.c;
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.a.c {
    private bc e = null;
    private com.baidu.tieba.a.bh f = null;
    private bb g = null;
    private boolean h = false;

    public void a(boolean z) {
        this.h = z;
    }

    public void a(bb bbVar) {
        this.g = bbVar;
    }

    public void a(com.baidu.tieba.a.bh bhVar) {
        this.f = bhVar;
    }

    public com.baidu.tieba.a.bh d() {
        return this.f;
    }

    public boolean e() {
        if (this.f == null) {
            return false;
        }
        if (this.e != null) {
            this.e.cancel();
        }
        this.e = new bc(this, null);
        this.e.setPriority(3);
        this.e.execute(new Integer[0]);
        return true;
    }

    public boolean f() {
        return false;
    }
}
