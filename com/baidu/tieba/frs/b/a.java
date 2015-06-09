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
    private com.baidu.tieba.tbadkCore.e.a aFt;
    private long aFu;
    private long aFv;
    private long aFw;
    private long aFx;
    private String aLc;
    private int aLd;
    private int aLe;
    private w aLm;
    private FrsActivity aPF;
    private c<FrsActivity> aPG;
    private t aPH;
    private long aPI;
    private boolean aPJ;
    private String aPK;
    private String aPL;
    private String aPM;
    private boolean aPN;
    private boolean aPO;
    h aPP;
    private long aqE;
    private String mFrom;
    private String mPageType;
    private int mType;

    public a(FrsActivity frsActivity) {
        super(frsActivity);
        this.aLc = null;
        this.mType = 3;
        this.aLe = 1;
        this.mFrom = null;
        this.aLd = 0;
        this.aPI = 0L;
        this.aPJ = false;
        this.mPageType = "normal_page";
        this.aPK = null;
        this.aPL = null;
        this.aPM = null;
        this.aFt = null;
        this.aqE = 0L;
        this.aPN = false;
        this.aPO = false;
        this.aFu = 0L;
        this.aFv = 0L;
        this.aFw = 0L;
        this.aFx = 0L;
        this.aPF = frsActivity;
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.aLc = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aLd = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.aPJ = bundle.getBoolean(FrsActivityConfig.GOOD, false);
        }
        if (TextUtils.isEmpty(this.aLc)) {
            this.aLc = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.aPK = this.mFrom;
        this.aPH = new t();
        this.aLm = new w();
        this.aPG = new c<>(this.aPF.getPageContext(), this.aPH);
        this.aPG.a((q) this);
        this.aPG.setUniqueId(getUniqueId());
        if (this.aLc != null && this.aLc.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.b, com.baidu.tbadk.mvc.core.a
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aLc);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.aLd);
        bundle.putBoolean(FrsActivityConfig.GOOD, this.aPJ);
    }

    @Override // com.baidu.tbadk.mvc.d.a
    public boolean oM() {
        return bb(true);
    }

    @Override // com.baidu.tbadk.mvc.d.b
    public boolean BA() {
        if (!this.aPG.isLoading() && this.aPH.getPn() > 1) {
            t tVar = (t) t.objectWithJson(t.jsonWithObject(this.aPH), t.class);
            tVar.setPn(this.aPH.getPn() - 1);
            a(tVar, 2);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.d.d
    public boolean BB() {
        if (this.aPG.isLoading()) {
            return false;
        }
        TiebaStatic.eventStat(this.aPF.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
        t tVar = (t) t.objectWithJson(t.jsonWithObject(this.aPH), t.class);
        tVar.setPn(tVar.getPn() + 1);
        a(tVar, 1);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.d.e
    public boolean bb(boolean z) {
        if (this.aPG.isLoading()) {
            return false;
        }
        t tVar = (t) t.objectWithJson(t.jsonWithObject(this.aPH), t.class);
        tVar.setPn(1);
        a(tVar, 3);
        return true;
    }

    public void fe(int i) {
        if (!this.aPG.isLoading()) {
            t tVar = (t) t.objectWithJson(t.jsonWithObject(this.aPH), t.class);
            tVar.setPn(i);
            a(tVar, 4);
        }
    }

    public boolean LT() {
        if (this.aPG.isLoading()) {
            return false;
        }
        this.aPJ = false;
        this.aLe = 1;
        return bb(true);
    }

    public boolean ff(int i) {
        if (this.aPG.isLoading()) {
            return false;
        }
        this.aPJ = true;
        this.aPI = i;
        this.aLe = 1;
        return bb(true);
    }

    public boolean av(String str, String str2) {
        if (this.aPG.isLoading() || str2 == null) {
            return false;
        }
        this.aPK = "sidebar";
        this.aPL = str;
        this.aPJ = false;
        this.aLc = str2;
        return bb(true);
    }

    private void a(t tVar, int i) {
        boolean z = true;
        this.aPF.aLH.eU(i);
        this.aPG.a(tVar);
        this.mType = i;
        tVar.setKw(this.aLc);
        if (n.qc().qg()) {
            tVar.setRn(35);
        } else {
            tVar.setRn(50);
        }
        tVar.setWithGroup(1);
        if (this.aPJ) {
            tVar.setIsGood(1);
            tVar.setCid((int) this.aPI);
        } else {
            tVar.setIsGood(0);
            tVar.setCid(0);
        }
        int M = com.baidu.adp.lib.util.n.M(this.aPF.getPageContext().getPageActivity());
        int N = com.baidu.adp.lib.util.n.N(this.aPF.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = bc.tB().tD() ? 2 : 1;
        tVar.setScrW(M);
        tVar.setScrH(N);
        tVar.setScrDip(f);
        tVar.setqType(i2);
        tVar.setLastId(this.aPM);
        if (this.aPK != null) {
            tVar.setStType(this.aPK);
            if (this.aPK.equalsIgnoreCase("sidebar")) {
                tVar.setStType(this.aPL);
            }
        }
        if (FrsActivity.aLs != 0) {
            tVar.setCtime((int) FrsActivity.aLs);
        }
        if (FrsActivity.aLt != 0) {
            tVar.setDataSize((int) FrsActivity.aLt);
        }
        if (FrsActivity.aLu != 0) {
            tVar.setNetError(FrsActivity.aLu);
        }
        if (tVar.getPn() != 1 || ((!this.mPageType.equals("normal_page") && !this.mPageType.equals("frs_page")) || this.mType != 3 || this.aPJ)) {
            z = false;
        }
        tVar.setUpdateType(this.mType);
        tVar.setNeedCache(z);
        new b(this, z, this.aLc).execute(new Object[0]);
        if (this.aFt == null) {
            this.aFt = new com.baidu.tieba.tbadkCore.e.a("frsStat");
            this.aFt.start();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.d.a
    public boolean a(t tVar, u uVar) {
        this.aLm.d(uVar);
        if (this.aLm.amq().amA() == 1) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        if (this.aPJ) {
            this.mPageType = "good_page";
        }
        if (tVar != null) {
            this.aPH = tVar;
            this.aLe = this.aPH.getPn();
            this.aLc = this.aPH.getKw();
            this.aPF.gl(this.aLc);
            this.aPF.setFrom(this.mFrom);
            this.aPF.setPn(this.aLe);
            this.aPF.setFlag(this.aLd);
        }
        this.aPF.aLH.a(this.mType, false, this.aPP);
        this.aPK = null;
        return super.a((a) tVar, (t) uVar);
    }

    @Override // com.baidu.tbadk.mvc.d.a, com.baidu.tbadk.mvc.model.s
    public void a(MvcSocketResponsedMessage<u, ?> mvcSocketResponsedMessage, MvcSocketMessage<t, u> mvcSocketMessage, MvcNetMessage<t, u> mvcNetMessage) {
        t tVar;
        h hVar = new h();
        hVar.coI = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        hVar.isSuccess = !mvcSocketResponsedMessage.hasError();
        hVar.errorCode = mvcSocketResponsedMessage.getError();
        hVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        hVar.coJ = mvcSocketResponsedMessage.getDownSize();
        this.aPP = hVar;
        super.a(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
        LV();
        if (this.aFt != null) {
            this.aFt.a(false, hVar.isSuccess, hVar.errorCode, hVar.errorMsg, hVar.coJ);
            this.aFt = null;
        }
        if (!this.aPO) {
            this.aPO = true;
            aa aaVar = new aa();
            aaVar.el(1000);
            aaVar.aqJ = false;
            aaVar.isSuccess = hVar.isSuccess;
            aaVar.aqy = mvcSocketResponsedMessage.performanceData.qx;
            aaVar.aqz = mvcSocketResponsedMessage.performanceData.qy;
            aaVar.aqA = mvcSocketResponsedMessage.performanceData.qz;
            aaVar.aqB = mvcSocketResponsedMessage.performanceData.qA;
            aaVar.aqC = mvcSocketResponsedMessage.performanceData.qB;
            aaVar.aqH = hVar.coJ;
            aaVar.aqI = 0L;
            if (this.aPF.aLH != null) {
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
        hVar.coI = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        hVar.isSuccess = !mvcHttpResponsedMessage.hasError();
        hVar.errorCode = mvcHttpResponsedMessage.getError();
        hVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        hVar.coJ = mvcHttpResponsedMessage.getDownSize();
        this.aPP = hVar;
        super.a(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
        LV();
        if (this.aFt != null) {
            this.aFt.a(true, hVar.isSuccess, hVar.errorCode, hVar.errorMsg, hVar.coJ);
            this.aFt = null;
        }
        if (!this.aPO) {
            this.aPO = true;
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
            aaVar.aqI = hVar.coJ;
            if (this.aPF.aLH != null) {
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

    public void LU() {
        if (this.aLm != null && this.aLm.aas() != null && this.aLm.aas().getBannerListData() != null) {
            String qB = this.aLm.aas().getBannerListData().qB();
            if (!TextUtils.isEmpty(qB)) {
                this.aPM = qB;
            }
        }
    }

    public void LV() {
        if (!this.aPN) {
            this.aPN = true;
            this.aqE = System.currentTimeMillis() - this.aPF.aLr;
            aa aaVar = new aa();
            aaVar.el(1000);
            aaVar.aqx = this.aPF.createTime;
            aaVar.aqE = this.aqE;
            aaVar.Dw();
        }
    }

    public void e(aa aaVar) {
        if (aaVar != null) {
            aaVar.aqx = this.aPF.createTime;
            this.aPF.createTime = 0L;
            aaVar.aqD = this.aPF.aqD;
            aaVar.aqE = this.aqE == 0 ? System.currentTimeMillis() - this.aPF.aLr : this.aqE;
            aaVar.Dx();
        }
    }

    public String LW() {
        return this.mPageType;
    }

    public boolean LX() {
        return this.aPJ;
    }

    public int getType() {
        return this.mType;
    }

    public w LY() {
        return this.aLm;
    }

    public h LZ() {
        return this.aPP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ma() {
        this.aFu = System.currentTimeMillis();
        this.aPG.BM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(u uVar) {
        this.aPF.aLH.b(uVar);
    }

    public long Ia() {
        return this.aFx;
    }

    public long Ib() {
        return this.aFv;
    }

    public long Ic() {
        return this.aFw;
    }

    public long Id() {
        return this.aFu;
    }

    public boolean isLoading() {
        return this.aPG.isLoading();
    }
}
