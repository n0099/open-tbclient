package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class bo extends com.baidu.adp.base.e {
    private String aok;
    private int ats;
    private int att;
    private float atu;
    private bp auH;
    private FaceShopData aup;
    private boolean mHasMore;
    private int mPage;

    public bo(Context context) {
        super(context);
        this.auH = null;
        this.ats = 0;
        this.att = 0;
        this.aup = null;
        this.mHasMore = false;
        this.mPage = 0;
        TbadkApplication m251getInst = TbadkApplication.m251getInst();
        this.ats = com.baidu.adp.lib.util.m.n(m251getInst);
        this.att = com.baidu.adp.lib.util.m.o(m251getInst);
        this.atu = m251getInst.getResources().getDisplayMetrics().density;
    }

    public FaceShopData Dy() {
        return this.aup;
    }

    public boolean getHasMore() {
        return this.mHasMore;
    }

    public void eV(String str) {
        this.aok = str;
    }

    public void ey(int i) {
        if (this.auH == null) {
            this.auH = new bp(this, null);
            this.auH.setPriority(3);
            this.auH.execute(Integer.valueOf(i));
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.auH != null) {
            this.auH.cancel();
            return true;
        }
        return true;
    }
}
