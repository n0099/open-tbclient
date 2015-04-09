package com.baidu.tieba.frs.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.n;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.q;
import com.baidu.tbadk.performanceLog.aa;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.h;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.d.b<t, u> {
    private String Wu;
    private com.baidu.tieba.tbadkCore.e.a aDq;
    private long aDr;
    private long aDs;
    private long aDt;
    private long aDu;
    private String aIS;
    private int aIT;
    private int aIU;
    private w aJd;
    private boolean aNA;
    private boolean aNB;
    h aNC;
    private FrsActivity aNs;
    private c<FrsActivity> aNt;
    private t aNu;
    private long aNv;
    private boolean aNw;
    private String aNx;
    private String aNy;
    private String aNz;
    private long apC;
    private String mPageType;
    private int mType;

    public a(FrsActivity frsActivity) {
        super(frsActivity);
        this.aIS = null;
        this.mType = 3;
        this.aIU = 1;
        this.Wu = null;
        this.aIT = 0;
        this.aNv = 0L;
        this.aNw = false;
        this.mPageType = "normal_page";
        this.aNx = null;
        this.aNy = null;
        this.aNz = null;
        this.aDq = null;
        this.apC = 0L;
        this.aNA = false;
        this.aNB = false;
        this.aDr = 0L;
        this.aDs = 0L;
        this.aDt = 0L;
        this.aDu = 0L;
        this.aNs = frsActivity;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.aIS = bundle.getString("name");
            this.Wu = bundle.getString("from");
            this.aIT = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.aNw = bundle.getBoolean(FrsActivityConfig.GOOD, false);
        }
        if (TextUtils.isEmpty(this.aIS)) {
            this.aIS = "";
        }
        if (TextUtils.isEmpty(this.Wu)) {
            this.Wu = "";
        }
        this.aNx = this.Wu;
        this.aNu = new t();
        this.aJd = new w();
        this.aNt = new c<>(this.aNs.getPageContext(), this.aNu);
        this.aNt.a((q) this);
        this.aNt.setUniqueId(getUniqueId());
        if (this.aIS != null && this.aIS.length() > 0) {
            if (this.Wu == null || this.Wu.length() <= 0) {
                this.Wu = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aIS);
        bundle.putString("from", this.Wu);
        bundle.putInt(FrsActivityConfig.FLAG, this.aIT);
        bundle.putBoolean(FrsActivityConfig.GOOD, this.aNw);
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean ow() {
        return aU(true);
    }

    @Override // com.baidu.tbadk.mvc.d.b
    public boolean AN() {
        if (!this.aNt.isLoading() && this.aNu.getPn() > 1) {
            t tVar = (t) t.objectWithJson(t.jsonWithObject(this.aNu), t.class);
            tVar.setPn(this.aNu.getPn() - 1);
            a(tVar, 2);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.d.d
    public boolean AO() {
        if (this.aNt.isLoading()) {
            return false;
        }
        TiebaStatic.eventStat(this.aNs.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
        t tVar = (t) t.objectWithJson(t.jsonWithObject(this.aNu), t.class);
        tVar.setPn(tVar.getPn() + 1);
        a(tVar, 1);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.e
    public boolean aU(boolean z) {
        if (this.aNt.isLoading()) {
            return false;
        }
        t tVar = (t) t.objectWithJson(t.jsonWithObject(this.aNu), t.class);
        tVar.setPn(1);
        a(tVar, 3);
        return true;
    }

    public void eQ(int i) {
        if (!this.aNt.isLoading()) {
            t tVar = (t) t.objectWithJson(t.jsonWithObject(this.aNu), t.class);
            tVar.setPn(i);
            a(tVar, 4);
        }
    }

    public boolean KN() {
        if (this.aNt.isLoading()) {
            return false;
        }
        this.aNw = false;
        this.aIU = 1;
        return aU(true);
    }

    public boolean eR(int i) {
        if (this.aNt.isLoading()) {
            return false;
        }
        this.aNw = true;
        this.aNv = i;
        this.aIU = 1;
        return aU(true);
    }

    public boolean aq(String str, String str2) {
        if (this.aNt.isLoading() || str2 == null) {
            return false;
        }
        this.aNx = "sidebar";
        this.aNy = str;
        this.aNw = false;
        this.aIS = str2;
        return aU(true);
    }

    private void a(t tVar, int i) {
        boolean z = true;
        this.aNs.aJz.eG(i);
        this.aNt.a(tVar);
        this.mType = i;
        tVar.setKw(this.aIS);
        if (n.px().pB()) {
            tVar.setRn(35);
        } else {
            tVar.setRn(50);
        }
        tVar.setWithGroup(1);
        if (this.aNw) {
            tVar.setIsGood(1);
            tVar.setCid((int) this.aNv);
        } else {
            tVar.setIsGood(0);
            tVar.setCid(0);
        }
        int M = com.baidu.adp.lib.util.n.M(this.aNs.getPageContext().getPageActivity());
        int N = com.baidu.adp.lib.util.n.N(this.aNs.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = be.sY().ta() ? 2 : 1;
        tVar.setScrW(M);
        tVar.setScrH(N);
        tVar.setScrDip(f);
        tVar.setqType(i2);
        tVar.setLastId(this.aNz);
        if (this.aNx != null) {
            tVar.setStType(this.aNx);
            if (this.aNx.equalsIgnoreCase("sidebar")) {
                tVar.setStType(this.aNy);
            }
        }
        if (FrsActivity.aJj != 0) {
            tVar.setCtime((int) FrsActivity.aJj);
        }
        if (FrsActivity.aJk != 0) {
            tVar.setDataSize((int) FrsActivity.aJk);
        }
        if (FrsActivity.aJl != 0) {
            tVar.setNetError(FrsActivity.aJl);
        }
        if (tVar.getPn() != 1 || ((!this.mPageType.equals("normal_page") && !this.mPageType.equals("frs_page")) || this.mType != 3 || this.aNw)) {
            z = false;
        }
        tVar.setUpdateType(this.mType);
        tVar.setNeedCache(z);
        new b(this, z, this.aIS).execute(new Object[0]);
        if (this.aDq == null) {
            this.aDq = new com.baidu.tieba.tbadkCore.e.a("frsStat");
            this.aDq.start();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(t tVar, u uVar) {
        this.aJd.d(uVar);
        if (this.aJd.akF().akO() == 1) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        if (this.aNw) {
            this.mPageType = "good_page";
        }
        if (tVar != null) {
            this.aNu = tVar;
            this.aIU = this.aNu.getPn();
            this.aIS = this.aNu.getKw();
            this.aNs.fL(this.aIS);
            this.aNs.setFrom(this.Wu);
            this.aNs.setPn(this.aIU);
            this.aNs.setFlag(this.aIT);
        }
        this.aNs.aJz.a(this.mType, false, this.aNC);
        this.aNx = null;
        return super.a((a) tVar, (t) uVar);
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.model.s
    public void a(MvcSocketResponsedMessage<u, ?> mvcSocketResponsedMessage, MvcSocketMessage<t, u> mvcSocketMessage, MvcNetMessage<t, u> mvcNetMessage) {
        h hVar = new h();
        hVar.ckH = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        hVar.isSuccess = !mvcSocketResponsedMessage.hasError();
        hVar.errorCode = mvcSocketResponsedMessage.getError();
        hVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        hVar.ckI = mvcSocketResponsedMessage.getDownSize();
        this.aNC = hVar;
        super.a(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
        KP();
        if (this.aDq != null) {
            this.aDq.a(false, hVar.isSuccess, hVar.errorCode, hVar.errorMsg, hVar.ckI);
            this.aDq = null;
        }
        if (!this.aNB) {
            this.aNB = true;
            aa aaVar = new aa();
            aaVar.eb(1000);
            aaVar.apH = false;
            aaVar.isSuccess = hVar.isSuccess;
            aaVar.apw = mvcSocketResponsedMessage.performanceData.qt;
            aaVar.apx = mvcSocketResponsedMessage.performanceData.qu;
            aaVar.apy = mvcSocketResponsedMessage.performanceData.qv;
            aaVar.apz = mvcSocketResponsedMessage.performanceData.qw;
            aaVar.apA = mvcSocketResponsedMessage.performanceData.qx;
            aaVar.apF = hVar.ckI;
            aaVar.apG = 0L;
            if (this.aNs.aJz != null) {
                e(aaVar);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.model.r
    public void a(MvcHttpResponsedMessage<u> mvcHttpResponsedMessage, MvcHttpMessage<t, u> mvcHttpMessage, MvcNetMessage<t, u> mvcNetMessage) {
        h hVar = new h();
        hVar.ckH = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        hVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        hVar.errorCode = mvcHttpResponsedMessage.getError();
        hVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        hVar.ckI = mvcHttpResponsedMessage.getDownSize();
        this.aNC = hVar;
        super.a(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
        KP();
        if (this.aDq != null) {
            this.aDq.a(true, hVar.isSuccess, hVar.errorCode, hVar.errorMsg, hVar.ckI);
            this.aDq = null;
        }
        if (!this.aNB) {
            this.aNB = true;
            aa aaVar = new aa();
            aaVar.eb(1000);
            aaVar.apH = true;
            aaVar.isSuccess = hVar.isSuccess;
            aaVar.apw = mvcHttpResponsedMessage.performanceData.qt;
            aaVar.apx = mvcHttpResponsedMessage.performanceData.qu;
            aaVar.apy = mvcHttpResponsedMessage.performanceData.qv;
            aaVar.apz = mvcHttpResponsedMessage.performanceData.qw;
            aaVar.apA = mvcHttpResponsedMessage.performanceData.qx;
            aaVar.apF = 0L;
            aaVar.apG = hVar.ckI;
            if (this.aNs.aJz != null) {
                e(aaVar);
            }
        }
    }

    public void KO() {
        if (this.aJd != null && this.aJd.Za() != null && this.aJd.Za().getBannerListData() != null) {
            String pV = this.aJd.Za().getBannerListData().pV();
            if (!TextUtils.isEmpty(pV)) {
                this.aNz = pV;
            }
        }
    }

    public void KP() {
        if (!this.aNA) {
            this.aNA = true;
            this.apC = System.currentTimeMillis() - this.aNs.aJi;
            aa aaVar = new aa();
            aaVar.eb(1000);
            aaVar.apt = this.aNs.aJq;
            aaVar.apv = this.aNs.createTime;
            aaVar.apC = this.apC;
            aaVar.CK();
        }
    }

    public void e(aa aaVar) {
        if (aaVar != null) {
            aaVar.apv = this.aNs.createTime;
            this.aNs.createTime = 0L;
            aaVar.apt = this.aNs.aJq;
            aaVar.apB = this.aNs.apB;
            aaVar.apC = this.apC == 0 ? System.currentTimeMillis() - this.aNs.aJi : this.apC;
            aaVar.CL();
        }
    }

    public String KQ() {
        return this.mPageType;
    }

    public boolean KR() {
        return this.aNw;
    }

    public int getType() {
        return this.mType;
    }

    public w KS() {
        return this.aJd;
    }

    public h KT() {
        return this.aNC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KU() {
        this.aDr = System.currentTimeMillis();
        this.aNt.AZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(u uVar) {
        this.aNs.aJz.b(uVar);
    }

    public long GX() {
        return this.aDu;
    }

    public long GY() {
        return this.aDs;
    }

    public long GZ() {
        return this.aDt;
    }

    public long Ha() {
        return this.aDr;
    }

    public boolean isLoading() {
        return this.aNt.isLoading();
    }
}
