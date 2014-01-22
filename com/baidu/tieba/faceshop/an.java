package com.baidu.tieba.faceshop;

import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class an extends com.baidu.adp.a.d {
    private ap a;
    private String b;
    private int c;
    private int d;
    private float e;

    public an() {
        this.c = 0;
        this.d = 0;
        TiebaApplication h = TiebaApplication.h();
        this.c = com.baidu.adp.lib.g.g.b(h);
        this.d = com.baidu.adp.lib.g.g.c(h);
        this.e = h.getResources().getDisplayMetrics().density;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a() {
        if (this.a == null) {
            this.a = new ap(this);
            this.a.setPriority(3);
            this.a.execute(new Object[0]);
        }
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return true;
        }
        return true;
    }
}
