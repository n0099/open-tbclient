package com.baidu.tieba.faceshop;

import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.a.d {
    private int c;
    private int d;
    private float e;
    private FacePackageDownloadData b = null;
    private ad a = null;

    public ac() {
        this.c = 0;
        this.d = 0;
        TiebaApplication g = TiebaApplication.g();
        this.c = com.baidu.adp.lib.h.g.b(g);
        this.d = com.baidu.adp.lib.h.g.c(g);
        this.e = g.getResources().getDisplayMetrics().density;
    }

    public void a(String str) {
        if (this.a == null) {
            this.a = new ad(this, str);
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
            return false;
        }
        return false;
    }
}
