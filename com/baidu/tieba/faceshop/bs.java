package com.baidu.tieba.faceshop;

import android.content.Context;
/* loaded from: classes.dex */
public final class bs extends com.baidu.adp.a.e {
    private String d;
    private int f;
    private int g;
    private float h;
    private bt b = null;
    private FaceShopData a = null;
    private boolean e = false;
    private int c = 0;

    public bs() {
        this.f = 0;
        this.g = 0;
        com.baidu.tieba.r.c();
        Context e = com.baidu.tieba.r.e();
        this.f = com.baidu.adp.lib.util.i.b(e);
        this.g = com.baidu.adp.lib.util.i.c(e);
        this.h = e.getResources().getDisplayMetrics().density;
    }

    public final FaceShopData a() {
        return this.a;
    }

    public final boolean b() {
        return this.e;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(int i) {
        if (this.b == null) {
            this.b = new bt(this, (byte) 0);
            this.b.setPriority(3);
            this.b.execute(Integer.valueOf(i));
        }
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        if (this.b != null) {
            this.b.cancel();
            return true;
        }
        return true;
    }
}
