package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.base.e {
    private aq atW;
    private FacePackageDownloadData atX;
    private int ats;
    private int att;
    private float atu;

    public ap(Context context) {
        super(context);
        this.atX = null;
        this.ats = 0;
        this.att = 0;
        this.atW = null;
        TbadkApplication m251getInst = TbadkApplication.m251getInst();
        this.ats = com.baidu.adp.lib.util.m.n(m251getInst);
        this.att = com.baidu.adp.lib.util.m.o(m251getInst);
        this.atu = m251getInst.getResources().getDisplayMetrics().density;
    }

    public void eU(String str) {
        if (this.atW == null) {
            this.atW = new aq(this, str);
            this.atW.setPriority(3);
            this.atW.execute(new Object[0]);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.atW != null) {
            this.atW.cancel();
            return false;
        }
        return false;
    }
}
