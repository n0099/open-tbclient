package com.baidu.tieba.faceshop;

import android.app.Application;
/* loaded from: classes.dex */
public final class bd extends com.baidu.adp.a.e {
    private be a;
    private String b;
    private int c;
    private int d;
    private float e;

    public bd() {
        this.c = 0;
        this.d = 0;
        com.baidu.tieba.p.c();
        Application d = com.baidu.tieba.p.d();
        this.c = com.baidu.adp.lib.util.i.b(d);
        this.d = com.baidu.adp.lib.util.i.c(d);
        this.e = d.getResources().getDisplayMetrics().density;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void a() {
        if (this.a == null) {
            this.a = new be(this, (byte) 0);
            this.a.setPriority(3);
            this.a.execute(new Object[0]);
        }
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return true;
        }
        return true;
    }
}
