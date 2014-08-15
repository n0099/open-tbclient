package com.baidu.tieba.faceshop;

import android.content.Context;
/* loaded from: classes.dex */
public class x extends com.baidu.adp.base.e {
    private z a;
    private y b;
    private int c;

    public x(Context context) {
        super(context);
        this.c = 3;
        this.a = null;
        this.b = null;
    }

    public void a(String str) {
        if (this.a == null) {
            this.a = new z(this, null);
            this.a.setPriority(3);
            this.a.execute(str);
        }
    }

    public void b(String str) {
        if (this.b == null) {
            this.b = new y(this, null);
            this.b.setPriority(3);
            this.b.execute(str);
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
