package com.baidu.tieba.faceshop;

import android.app.Application;
import android.content.Context;
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.base.e {
    private az a;
    private String b;
    private int c;
    private int d;
    private float e;

    public ay(Context context) {
        super(context);
        this.c = 0;
        this.d = 0;
        Application d = com.baidu.tieba.ai.c().d();
        this.c = com.baidu.adp.lib.util.j.b(d);
        this.d = com.baidu.adp.lib.util.j.c(d);
        this.e = d.getResources().getDisplayMetrics().density;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a() {
        if (this.a == null) {
            this.a = new az(this, null);
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
            return true;
        }
        return true;
    }
}
