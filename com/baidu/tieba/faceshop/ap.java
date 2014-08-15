package com.baidu.tieba.faceshop;

import android.content.Context;
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.base.e {
    private aq a;
    private FacePackageDownloadData b;
    private int c;
    private int d;
    private float e;

    public ap(Context context) {
        super(context);
        this.b = null;
        this.c = 0;
        this.d = 0;
        this.a = null;
        Context e = com.baidu.tieba.ai.c().e();
        this.c = com.baidu.adp.lib.util.j.b(e);
        this.d = com.baidu.adp.lib.util.j.c(e);
        this.e = e.getResources().getDisplayMetrics().density;
    }

    public void a(String str) {
        if (this.a == null) {
            this.a = new aq(this, str);
            this.a.setPriority(3);
            this.a.execute(new Object[0]);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return false;
        }
        return false;
    }
}
