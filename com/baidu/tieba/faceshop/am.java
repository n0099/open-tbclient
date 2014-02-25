package com.baidu.tieba.faceshop;

import android.app.Application;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class am extends com.baidu.adp.a.d {
    private an a;
    private String b;
    private int c;
    private int d;
    private float e;

    public am() {
        this.c = 0;
        this.d = 0;
        Application b = TiebaApplication.g().b();
        this.c = BdUtilHelper.b(b);
        this.d = BdUtilHelper.c(b);
        this.e = b.getResources().getDisplayMetrics().density;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a() {
        if (this.a == null) {
            this.a = new an(this, null);
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
