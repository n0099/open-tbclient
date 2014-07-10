package com.baidu.tieba.faceshop;

import android.content.Context;
/* loaded from: classes.dex */
public class br extends com.baidu.adp.base.e {
    private String d;
    private int f;
    private int g;
    private float h;
    private bs b = null;
    private FaceShopData a = null;
    private boolean e = false;
    private int c = 0;

    public br() {
        this.f = 0;
        this.g = 0;
        Context e = com.baidu.tieba.ai.c().e();
        this.f = com.baidu.adp.lib.util.j.b(e);
        this.g = com.baidu.adp.lib.util.j.c(e);
        this.h = e.getResources().getDisplayMetrics().density;
    }

    public FaceShopData a() {
        return this.a;
    }

    public boolean b() {
        return this.e;
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(int i) {
        if (this.b == null) {
            this.b = new bs(this, null);
            this.b.setPriority(3);
            this.b.execute(Integer.valueOf(i));
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.b != null) {
            this.b.cancel();
            return true;
        }
        return true;
    }
}
