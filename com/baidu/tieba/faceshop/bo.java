package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class bo extends com.baidu.adp.base.e {
    private String aot;
    private int atB;
    private int atC;
    private float atD;
    private bp auQ;
    private FaceShopData auy;
    private boolean mHasMore;
    private int mPage;

    public bo(Context context) {
        super(context);
        this.auQ = null;
        this.atB = 0;
        this.atC = 0;
        this.auy = null;
        this.mHasMore = false;
        this.mPage = 0;
        TbadkApplication m251getInst = TbadkApplication.m251getInst();
        this.atB = com.baidu.adp.lib.util.m.n(m251getInst);
        this.atC = com.baidu.adp.lib.util.m.o(m251getInst);
        this.atD = m251getInst.getResources().getDisplayMetrics().density;
    }

    public FaceShopData DA() {
        return this.auy;
    }

    public boolean getHasMore() {
        return this.mHasMore;
    }

    public void eV(String str) {
        this.aot = str;
    }

    public void ey(int i) {
        if (this.auQ == null) {
            this.auQ = new bp(this, null);
            this.auQ.setPriority(3);
            this.auQ.execute(Integer.valueOf(i));
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.auQ != null) {
            this.auQ.cancel();
            return true;
        }
        return true;
    }
}
