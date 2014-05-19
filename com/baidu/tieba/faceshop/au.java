package com.baidu.tieba.faceshop;

import android.content.Context;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.base.d {
    private int c;
    private int d;
    private float e;
    private FacePackageDownloadData b = null;
    private av a = null;

    public au() {
        this.c = 0;
        this.d = 0;
        Context e = com.baidu.tieba.ad.c().e();
        this.c = com.baidu.adp.lib.util.h.b(e);
        this.d = com.baidu.adp.lib.util.h.c(e);
        this.e = e.getResources().getDisplayMetrics().density;
    }

    public void a(String str) {
        if (this.a == null) {
            this.a = new av(this, str);
            this.a.setPriority(3);
            this.a.execute(new Object[0]);
        }
    }

    @Override // com.baidu.adp.base.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.d
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return false;
        }
        return false;
    }
}
