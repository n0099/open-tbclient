package com.baidu.tieba.faceshop;

import android.content.Context;
/* loaded from: classes.dex */
public class x extends com.baidu.adp.base.e {
    private z ata;
    private y atb;
    private int atc;

    public x(Context context) {
        super(context);
        this.atc = 3;
        this.ata = null;
        this.atb = null;
    }

    public void eO(String str) {
        if (this.ata == null) {
            this.ata = new z(this, null);
            this.ata.setPriority(3);
            this.ata.execute(str);
        }
    }

    public void eP(String str) {
        if (this.atb == null) {
            this.atb = new y(this, null);
            this.atb.setPriority(3);
            this.atb.execute(str);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.ata != null) {
            this.ata.cancel();
            return true;
        }
        return true;
    }
}
