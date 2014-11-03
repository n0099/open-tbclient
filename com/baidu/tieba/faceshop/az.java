package com.baidu.tieba.faceshop;

import android.app.Application;
import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class az extends com.baidu.adp.base.e {
    private String aot;
    private int atB;
    private int atC;
    private float atD;
    private ba aur;

    public az(Context context) {
        super(context);
        this.atB = 0;
        this.atC = 0;
        Application app = TbadkApplication.m251getInst().getApp();
        this.atB = com.baidu.adp.lib.util.m.n(app);
        this.atC = com.baidu.adp.lib.util.m.o(app);
        this.atD = app.getResources().getDisplayMetrics().density;
    }

    public void setStType(String str) {
        this.aot = str;
    }

    public void yj() {
        if (this.aur == null) {
            this.aur = new ba(this, null);
            this.aur.setPriority(3);
            this.aur.execute(new Object[0]);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.aur != null) {
            this.aur.cancel();
            return true;
        }
        return true;
    }
}
