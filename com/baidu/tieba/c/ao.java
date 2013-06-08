package com.baidu.tieba.c;
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.a.c {
    private com.baidu.tieba.a.ao f;
    private ap e = null;
    private boolean g = false;

    public ao(com.baidu.tieba.a.ao aoVar) {
        this.f = null;
        this.f = aoVar;
        if (this.f == null) {
            this.f = new com.baidu.tieba.a.ao();
        }
    }

    public void a(com.baidu.tieba.a.ao aoVar) {
        this.f = aoVar;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public boolean d() {
        return this.g;
    }

    public void e() {
        if (this.e == null) {
            this.e = new ap(this, null);
            this.e.execute(new String[0]);
        }
    }

    public com.baidu.tieba.a.ao f() {
        return this.f;
    }
}
