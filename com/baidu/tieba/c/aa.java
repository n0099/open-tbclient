package com.baidu.tieba.c;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.a.c {
    private ab e = null;
    private String f = null;

    public boolean b(String str) {
        this.f = str;
        return d();
    }

    protected boolean d() {
        if (this.e != null) {
            this.e.cancel();
        }
        this.e = new ab(this, this.f);
        this.e.execute(new Object[0]);
        return true;
    }

    public boolean e() {
        if (this.e != null) {
            this.e.cancel();
            return true;
        }
        return true;
    }
}
