package com.baidu.tieba.faceshop;

import android.content.Context;
/* loaded from: classes.dex */
public final class at extends com.baidu.adp.a.e {
    private int c;
    private int d;
    private float e;
    private FacePackageDownloadData b = null;
    private au a = null;

    public at() {
        this.c = 0;
        this.d = 0;
        com.baidu.tieba.p.c();
        Context e = com.baidu.tieba.p.e();
        this.c = com.baidu.adp.lib.util.i.b(e);
        this.d = com.baidu.adp.lib.util.i.c(e);
        this.e = e.getResources().getDisplayMetrics().density;
    }

    public final void a(String str) {
        if (this.a == null) {
            this.a = new au(this, str);
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
            return false;
        }
        return false;
    }
}
