package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public final class ac extends com.baidu.adp.a.d {
    private int c;
    private int d;
    private float e;
    private FacePackageDownloadData b = null;
    private ad a = null;

    public ac() {
        this.c = 0;
        this.d = 0;
        Context c = TiebaApplication.g().c();
        this.c = BdUtilHelper.b(c);
        this.d = BdUtilHelper.c(c);
        this.e = c.getResources().getDisplayMetrics().density;
    }

    public final void a(String str) {
        if (this.a == null) {
            this.a = new ad(this, str);
            this.a.setPriority(3);
            this.a.execute(new Object[0]);
        }
    }

    @Override // com.baidu.adp.a.d
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public final boolean cancelLoadData() {
        if (this.a != null) {
            this.a.cancel();
            return false;
        }
        return false;
    }
}
