package com.baidu.tieba.c;
/* loaded from: classes.dex */
public class al extends com.baidu.adp.a.c {
    private com.baidu.tieba.a.an f;
    private am e = null;
    private boolean g = false;

    public al(com.baidu.tieba.a.an anVar) {
        this.f = null;
        this.f = anVar;
        if (this.f == null) {
            this.f = new com.baidu.tieba.a.an();
        }
    }

    public void a(com.baidu.tieba.a.an anVar) {
        this.f = anVar;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public boolean d() {
        return this.g;
    }

    public void e() {
        if (this.e == null) {
            this.e = new am(this, null);
            this.e.execute(new String[0]);
        }
    }

    public com.baidu.tieba.a.an f() {
        return this.f;
    }
}
