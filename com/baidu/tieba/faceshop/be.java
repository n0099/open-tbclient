package com.baidu.tieba.faceshop;

import android.app.Application;
/* loaded from: classes.dex */
public class be extends com.baidu.adp.base.b {
    private bf a;
    private String b;
    private int c;
    private int d;
    private float e;

    public be() {
        this.c = 0;
        this.d = 0;
        Application d = com.baidu.tieba.ai.c().d();
        this.c = com.baidu.adp.lib.util.k.b(d);
        this.d = com.baidu.adp.lib.util.k.c(d);
        this.e = d.getResources().getDisplayMetrics().density;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a() {
        if (this.a == null) {
            this.a = new bf(this, null);
            this.a.setPriority(3);
            this.a.execute(new Object[0]);
        }
    }

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return true;
        }
        return true;
    }
}
