package com.baidu.tieba.frs.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.n;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
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
    private com.baidu.tieba.tbadkCore.e.a aFs;
    private long aFt;
    private long aFu;
    private long aFv;
    private long aFw;
    private String aLb;
    private int aLc;
    private int aLd;
    private w aLl;
    private FrsActivity aPE;
    private c<FrsActivity> aPF;
    private t aPG;
    private long aPH;
    private boolean aPI;
    private String aPJ;
    private String aPK;
    private String aPL;
    private boolean aPM;
    private boolean aPN;
    h aPO;
    private long aqE;
    private String mFrom;
    private String mPageType;
    private int mType;

    public a(FrsActivity frsActivity) {
        super(frsActivity);
        this.aLb = null;
        this.mType = 3;
        this.aLd = 1;
        this.mFrom = null;
        this.aLc = 0;
        this.aPH = 0L;
        this.aPI = false;
        this.mPageType = "normal_page";
        this.aPJ = null;
        this.aPK = null;
        this.aPL = null;
        this.aFs = null;
        this.aqE = 0L;
        this.aPM = false;
        this.aPN = false;
        this.aFt = 0L;
        this.aFu = 0L;
        this.aFv = 0L;
        this.aFw = 0L;
        this.aPE = frsActivity;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.aLb = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aLc = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.aPI = bundle.getBoolean(FrsActivityConfig.GOOD, false);
        }
        if (TextUtils.isEmpty(this.aLb)) {
            this.aLb = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.aPJ = this.mFrom;
        this.aPG = new t();
        this.aLl = new w();
        this.aPF = new c<>(this.aPE.getPageContext(), this.aPG);
        this.aPF.a((q) this);
        this.aPF.setUniqueId(getUniqueId());
        if (this.aLb != null && this.aLb.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aLb);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.aLc);
        bundle.putBoolean(FrsActivityConfig.GOOD, this.aPI);
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean oM() {
        return bb(true);
    }

    @Override // com.baidu.tbadk.mvc.d.b
    public boolean Bz() {
        if (!this.aPF.isLoading() && this.aPG.getPn() > 1) {
            t tVar = (t) t.objectWithJson(t.jsonWithObject(this.aPG), t.class);
            tVar.setPn(this.aPG.getPn() - 1);
            a(tVar, 2);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.d.d
    public boolean BA() {
        if (this.aPF.isLoading()) {
            return false;
        }
        TiebaStatic.eventStat(this.aPE.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
        t tVar = (t) t.objectWithJson(t.jsonWithObject(this.aPG), t.class);
        tVar.setPn(tVar.getPn() + 1);
        a(tVar, 1);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.e
    public boolean bb(boolean z) {
        if (this.aPF.isLoading()) {
            return false;
        }
        t tVar = (t) t.objectWithJson(t.jsonWithObject(this.aPG), t.class);
        tVar.setPn(1);
        a(tVar, 3);
        return true;
    }

    public void fe(int i) {
        if (!this.aPF.isLoading()) {
            t tVar = (t) t.objectWithJson(t.jsonWithObject(this.aPG), t.class);
            tVar.setPn(i);
            a(tVar, 4);
        }
    }

    public boolean LS() {
        if (this.aPF.isLoading()) {
            return false;
        }
        this.aPI = false;
        this.aLd = 1;
        return bb(true);
    }

    public boolean ff(int i) {
        if (this.aPF.isLoading()) {
            return false;
        }
        this.aPI = true;
        this.aPH = i;
        this.aLd = 1;
        return bb(true);
    }

    public boolean av(String str, String str2) {
        if (this.aPF.isLoading() || str2 == null) {
            return false;
        }
        this.aPJ = "sidebar";
        this.aPK = str;
        this.aPI = false;
        this.aLb = str2;
        return bb(true);
    }

    private void a(t tVar, int i) {
        boolean z = true;
        this.aPE.aLG.eU(i);
        this.aPF.a(tVar);
        this.mType = i;
        tVar.setKw(this.aLb);
        if (n.qc().qg()) {
            tVar.setRn(35);
        } else {
            tVar.setRn(50);
        }
        tVar.setWithGroup(1);
        if (this.aPI) {
            tVar.setIsGood(1);
            tVar.setCid((int) this.aPH);
        } else {
            tVar.setIsGood(0);
            tVar.setCid(0);
        }
        int M = com.baidu.adp.lib.util.n.M(this.aPE.getPageContext().getPageActivity());
        int N = com.baidu.adp.lib.util.n.N(this.aPE.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = bc.tB().tD() ? 2 : 1;
        tVar.setScrW(M);
        tVar.setScrH(N);
        tVar.setScrDip(f);
        tVar.setqType(i2);
        tVar.setLastId(this.aPL);
        if (this.aPJ != null) {
            tVar.setStType(this.aPJ);
            if (this.aPJ.equalsIgnoreCase("sidebar")) {
                tVar.setStType(this.aPK);
            }
        }
        if (FrsActivity.aLr != 0) {
            tVar.setCtime((int) FrsActivity.aLr);
        }
        if (FrsActivity.aLs != 0) {
            tVar.setDataSize((int) FrsActivity.aLs);
        }
        if (FrsActivity.aLt != 0) {
            tVar.setNetError(FrsActivity.aLt);
        }
        if (tVar.getPn() != 1 || ((!this.mPageType.equals("normal_page") && !this.mPageType.equals("frs_page")) || this.mType != 3 || this.aPI)) {
            z = false;
        }
        tVar.setUpdateType(this.mType);
        tVar.setNeedCache(z);
        new b(this, z, this.aLb).execute(new Object[0]);
        if (this.aFs == null) {
            this.aFs = new com.baidu.tieba.tbadkCore.e.a("frsStat");
            this.aFs.start();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(t tVar, u uVar) {
        this.aLl.d(uVar);
        if (this.aLl.amp().amz() == 1) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        if (this.aPI) {
            this.mPageType = "good_page";
        }
        if (tVar != null) {
            this.aPG = tVar;
            this.aLd = this.aPG.getPn();
            this.aLb = this.aPG.getKw();
            this.aPE.gl(this.aLb);
            this.aPE.setFrom(this.mFrom);
            this.aPE.setPn(this.aLd);
            this.aPE.setFlag(this.aLc);
        }
        this.aPE.aLG.a(this.mType, false, this.aPO);
        this.aPJ = null;
        return super.a((a) tVar, (t) uVar);
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.model.s
    public void a(MvcSocketResponsedMessage<u, ?> mvcSocketResponsedMessage, MvcSocketMessage<t, u> mvcSocketMessage, MvcNetMessage<t, u> mvcNetMessage) {
        t tVar;
        h hVar = new h();
        hVar.coH = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        hVar.isSuccess = !mvcSocketResponsedMessage.hasError();
        hVar.errorCode = mvcSocketResponsedMessage.getError();
        hVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        hVar.coI = mvcSocketResponsedMessage.getDownSize();
        this.aPO = hVar;
        super.a(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
        LU();
        if (this.aFs != null) {
            this.aFs.a(false, hVar.isSuccess, hVar.errorCode, hVar.errorMsg, hVar.coI);
            this.aFs = null;
        }
        if (!this.aPN) {
            this.aPN = true;
            aa aaVar = new aa();
            aaVar.el(1000);
            aaVar.aqJ = false;
            aaVar.isSuccess = hVar.isSuccess;
            aaVar.aqy = mvcSocketResponsedMessage.performanceData.qx;
            aaVar.aqz = mvcSocketResponsedMessage.performanceData.qy;
            aaVar.aqA = mvcSocketResponsedMessage.performanceData.qz;
            aaVar.aqB = mvcSocketResponsedMessage.performanceData.qA;
            aaVar.aqC = mvcSocketResponsedMessage.performanceData.qB;
            aaVar.aqH = hVar.coI;
            aaVar.aqI = 0L;
            if (this.aPE.aLG != null) {
                e(aaVar);
            }
        }
        long j = 0;
        t tVar2 = null;
        if (mvcSocketMessage != null) {
            j = mvcSocketMessage.getClientLogID();
            tVar2 = mvcSocketMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            tVar = mvcNetMessage.getRequestData();
        } else {
            tVar = tVar2;
        }
        int error = mvcSocketResponsedMessage.getError();
        String errorString = mvcSocketResponsedMessage.getErrorString();
        int cmd = mvcSocketResponsedMessage.getCmd();
        Object[] objArr = new Object[2];
        objArr[0] = "kw";
        objArr[1] = tVar != null ? tVar.getKw() : null;
        com.baidu.tbadk.core.log.b.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.model.r
    public void a(MvcHttpResponsedMessage<u> mvcHttpResponsedMessage, MvcHttpMessage<t, u> mvcHttpMessage, MvcNetMessage<t, u> mvcNetMessage) {
        t tVar;
        h hVar = new h();
        hVar.coH = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        hVar.isSuccess = !mvcHttpResponsedMessage.hasError();
        hVar.errorCode = mvcHttpResponsedMessage.getError();
        hVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        hVar.coI = mvcHttpResponsedMessage.getDownSize();
        this.aPO = hVar;
        super.a(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
        LU();
        if (this.aFs != null) {
            this.aFs.a(true, hVar.isSuccess, hVar.errorCode, hVar.errorMsg, hVar.coI);
            this.aFs = null;
        }
        if (!this.aPN) {
            this.aPN = true;
            aa aaVar = new aa();
            aaVar.el(1000);
            aaVar.aqJ = true;
            aaVar.isSuccess = hVar.isSuccess;
            aaVar.aqy = mvcHttpResponsedMessage.performanceData.qx;
            aaVar.aqz = mvcHttpResponsedMessage.performanceData.qy;
            aaVar.aqA = mvcHttpResponsedMessage.performanceData.qz;
            aaVar.aqB = mvcHttpResponsedMessage.performanceData.qA;
            aaVar.aqC = mvcHttpResponsedMessage.performanceData.qB;
            aaVar.aqH = 0L;
            aaVar.aqI = hVar.coI;
            if (this.aPE.aLG != null) {
                e(aaVar);
            }
        }
        long j = 0;
        t tVar2 = null;
        if (mvcHttpMessage != null) {
            j = mvcHttpMessage.getClientLogID();
            tVar2 = mvcHttpMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            tVar = mvcNetMessage.getRequestData();
        } else {
            tVar = tVar2;
        }
        int error = mvcHttpResponsedMessage.getError();
        String errorString = mvcHttpResponsedMessage.getErrorString();
        int cmd = mvcHttpResponsedMessage.getCmd();
        Object[] objArr = new Object[2];
        objArr[0] = "kw";
        objArr[1] = tVar != null ? tVar.getKw() : null;
        com.baidu.tbadk.core.log.b.a("frs", j, cmd, "http_resp", error, errorString, objArr);
    }

    public void LT() {
        if (this.aLl != null && this.aLl.aar() != null && this.aLl.aar().getBannerListData() != null) {
            String qB = this.aLl.aar().getBannerListData().qB();
            if (!TextUtils.isEmpty(qB)) {
                this.aPL = qB;
            }
        }
    }

    public void LU() {
        if (!this.aPM) {
            this.aPM = true;
            this.aqE = System.currentTimeMillis() - this.aPE.aLq;
            aa aaVar = new aa();
            aaVar.el(1000);
            aaVar.aqx = this.aPE.createTime;
            aaVar.aqE = this.aqE;
            aaVar.Dv();
        }
    }

    public void e(aa aaVar) {
        if (aaVar != null) {
            aaVar.aqx = this.aPE.createTime;
            this.aPE.createTime = 0L;
            aaVar.aqD = this.aPE.aqD;
            aaVar.aqE = this.aqE == 0 ? System.currentTimeMillis() - this.aPE.aLq : this.aqE;
            aaVar.Dw();
        }
    }

    public String LV() {
        return this.mPageType;
    }

    public boolean LW() {
        return this.aPI;
    }

    public int getType() {
        return this.mType;
    }

    public w LX() {
        return this.aLl;
    }

    public h LY() {
        return this.aPO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LZ() {
        this.aFt = System.currentTimeMillis();
        this.aPF.BL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(u uVar) {
        this.aPE.aLG.b(uVar);
    }

    public long HZ() {
        return this.aFw;
    }

    public long Ia() {
        return this.aFu;
    }

    public long Ib() {
        return this.aFv;
    }

    public long Ic() {
        return this.aFt;
    }

    public boolean isLoading() {
        return this.aPF.isLoading();
    }
}
