package com.baidu.tieba.faceshop;

import android.app.Application;
import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class az extends com.baidu.adp.base.e {
    private String aok;
    private int ats;
    private int att;
    private float atu;
    private ba aui;

    public az(Context context) {
        super(context);
        this.ats = 0;
        this.att = 0;
        Application app = TbadkApplication.m251getInst().getApp();
        this.ats = com.baidu.adp.lib.util.m.n(app);
        this.att = com.baidu.adp.lib.util.m.o(app);
        this.atu = app.getResources().getDisplayMetrics().density;
    }

    public void setStType(String str) {
        this.aok = str;
    }

    public void yh() {
        if (this.aui == null) {
            this.aui = new ba(this, null);
            this.aui.setPriority(3);
            this.aui.execute(new Object[0]);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.aui != null) {
            this.aui.cancel();
            return true;
        }
        return true;
    }
}
