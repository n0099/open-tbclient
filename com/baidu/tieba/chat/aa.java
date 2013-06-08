package com.baidu.tieba.chat;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.a.c {
    private com.baidu.tieba.a.a.e e = null;
    private ab f = null;
    private ac g = null;
    private com.baidu.tieba.a.a.f h;

    public aa() {
        this.h = null;
        this.h = com.baidu.tieba.a.a.f.a();
    }

    public void a(ac acVar) {
        this.g = acVar;
    }

    public void a(com.baidu.tieba.a.a.e eVar) {
        this.e = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d() {
        if (this.e != null && this.f == null) {
            this.f = new ab(this);
            this.f.execute(new Object[0]);
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.f != null) {
            this.f.cancel();
            return false;
        }
        return false;
    }
}
