package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.base.e {
    private int atB;
    private int atC;
    private float atD;
    private aq auf;
    private FacePackageDownloadData aug;

    public ap(Context context) {
        super(context);
        this.aug = null;
        this.atB = 0;
        this.atC = 0;
        this.auf = null;
        TbadkApplication m251getInst = TbadkApplication.m251getInst();
        this.atB = com.baidu.adp.lib.util.m.n(m251getInst);
        this.atC = com.baidu.adp.lib.util.m.o(m251getInst);
        this.atD = m251getInst.getResources().getDisplayMetrics().density;
    }

    public void eU(String str) {
        if (this.auf == null) {
            this.auf = new aq(this, str);
            this.auf.setPriority(3);
            this.auf.execute(new Object[0]);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.auf != null) {
            this.auf.cancel();
            return false;
        }
        return false;
    }
}
