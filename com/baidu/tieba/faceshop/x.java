package com.baidu.tieba.faceshop;

import android.content.Context;
/* loaded from: classes.dex */
public class x extends com.baidu.adp.base.e {
    private z asR;
    private y asS;
    private int asT;

    public x(Context context) {
        super(context);
        this.asT = 3;
        this.asR = null;
        this.asS = null;
    }

    public void eO(String str) {
        if (this.asR == null) {
            this.asR = new z(this, null);
            this.asR.setPriority(3);
            this.asR.execute(str);
        }
    }

    public void eP(String str) {
        if (this.asS == null) {
            this.asS = new y(this, null);
            this.asS.setPriority(3);
            this.asS.execute(str);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.asR != null) {
            this.asR.cancel();
            return true;
        }
        return true;
    }
}
