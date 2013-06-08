package com.baidu.tieba.c;
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.a.c {
    private bf e = null;
    private com.baidu.tieba.a.bi f = null;
    private be g = null;
    private boolean h = false;

    public void a(boolean z) {
        this.h = z;
    }

    public void a(be beVar) {
        this.g = beVar;
    }

    public void a(com.baidu.tieba.a.bi biVar) {
        this.f = biVar;
    }

    public com.baidu.tieba.a.bi d() {
        return this.f;
    }

    public boolean e() {
        if (this.f == null) {
            return false;
        }
        if (this.e == null) {
            this.e = new bf(this);
            this.e.execute(new Integer[0]);
        }
        return true;
    }

    public boolean f() {
        return false;
    }
}
