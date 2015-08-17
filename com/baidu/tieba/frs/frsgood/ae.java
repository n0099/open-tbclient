package com.baidu.tieba.frs.frsgood;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.e<FrsGoodActivity> implements NetModel.b<com.baidu.tieba.tbadkCore.k, com.baidu.tieba.tbadkCore.l> {
    private com.baidu.tieba.tbadkCore.e.a aMS;
    private long aMT;
    private long aMU;
    private long aMV;
    private long aMW;
    private String aUq;
    private int aUr;
    private com.baidu.tieba.tbadkCore.n aUy;
    private FrsGoodActivity aZA;
    private ArrayList<com.baidu.adp.widget.ListView.u> aZB;
    private com.baidu.tieba.frs.b.c<FrsGoodActivity> aZC;
    private com.baidu.tieba.tbadkCore.k aZD;
    private d.a aZE;
    private String aZF;
    private String aZG;
    private int aZH;
    private boolean aZI;
    private boolean aZJ;
    private long axr;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private int mType;

    public ae(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.aUq = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.aUr = 0;
        this.mPageType = "normal_page";
        this.aZF = null;
        this.aZG = null;
        this.aZH = 0;
        this.aMS = null;
        this.axr = 0L;
        this.aZI = false;
        this.aZJ = false;
        this.aMT = 0L;
        this.aMU = 0L;
        this.aMV = 0L;
        this.aMW = 0L;
        this.aZA = frsGoodActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        if (this.aMS != null) {
            this.aMS.destory();
        }
        this.aZC.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.aUq = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aUr = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.aUq)) {
            this.aUq = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.aZF = this.mFrom;
        this.aZD = new com.baidu.tieba.tbadkCore.k();
        this.aUy = new com.baidu.tieba.tbadkCore.n();
        this.aZC = new com.baidu.tieba.frs.b.c<>(this.aZA.getPageContext(), this.aZD);
        this.aZC.a(this);
        this.aZC.setUniqueId(getUniqueId());
        if (this.aUq != null && this.aUq.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.aUq);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.aUr);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean bz(boolean z) {
        if (this.aZC.isLoading()) {
            return false;
        }
        com.baidu.tieba.tbadkCore.k kVar = (com.baidu.tieba.tbadkCore.k) com.baidu.tieba.tbadkCore.k.objectWithJson(com.baidu.tieba.tbadkCore.k.jsonWithObject(this.aZD), com.baidu.tieba.tbadkCore.k.class);
        kVar.setPn(1);
        a(kVar, 3);
        return true;
    }

    public void fw(int i) {
        if (!this.aZC.isLoading()) {
            com.baidu.tieba.tbadkCore.k kVar = (com.baidu.tieba.tbadkCore.k) com.baidu.tieba.tbadkCore.k.objectWithJson(com.baidu.tieba.tbadkCore.k.jsonWithObject(this.aZD), com.baidu.tieba.tbadkCore.k.class);
            kVar.setPn(i);
            a(kVar, 4);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.k kVar, int i) {
        this.aZA.aUV.fg(i);
        this.aZC.a(kVar);
        this.mType = i;
        kVar.setKw(this.aUq);
        if (com.baidu.tbadk.core.m.rd().rh()) {
            kVar.setRn(35);
        } else {
            kVar.setRn(50);
        }
        kVar.setWithGroup(1);
        kVar.setIsGood(1);
        kVar.setCid(this.aZH);
        int K = com.baidu.adp.lib.util.k.K(this.aZA.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.aZA.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = ar.uE().uG() ? 2 : 1;
        kVar.setScrW(K);
        kVar.setScrH(L);
        kVar.setScrDip(f);
        kVar.setqType(i2);
        kVar.setLastId(this.aZG);
        if (this.aZF != null) {
            kVar.setStType(this.aZF);
        }
        if (FrsActivity.aUD != 0) {
            kVar.setCtime((int) FrsActivity.aUD);
        }
        if (FrsActivity.aUE != 0) {
            kVar.setDataSize((int) FrsActivity.aUE);
        }
        if (FrsActivity.aUF != 0) {
            kVar.setNetError(FrsActivity.aUF);
        }
        kVar.setUpdateType(this.mType);
        kVar.setNeedCache(false);
        if (this.aMS == null) {
            this.aMS = new com.baidu.tieba.tbadkCore.e.a("frsStat");
            this.aMS.start();
        }
        MT();
    }

    protected boolean a(com.baidu.tieba.tbadkCore.k kVar, com.baidu.tieba.tbadkCore.l lVar) {
        this.aUy.d(lVar);
        this.aZB = this.aUy.getThreadList();
        this.mPageType = "good_page";
        if (kVar != null) {
            this.aZD = kVar;
            this.mPn = this.aZD.getPn();
            this.aUq = this.aZD.getKw();
            this.aZA.gD(this.aUq);
            this.aZA.setFrom(this.mFrom);
            this.aZA.setPn(this.mPn);
            this.aZA.setFlag(this.aUr);
        }
        this.aZA.aUV.a(this.mType, false, this.aZE);
        this.aZF = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.tbadkCore.k, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.k, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.k kVar;
        com.baidu.tieba.tbadkCore.k kVar2;
        com.baidu.tieba.tbadkCore.k kVar3;
        d.a aVar = new d.a();
        aVar.cGF = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = !mvcSocketResponsedMessage.hasError();
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.cGG = mvcSocketResponsedMessage.getDownSize();
        this.aZE = aVar;
        com.baidu.tieba.tbadkCore.k kVar4 = null;
        com.baidu.tieba.tbadkCore.l lVar = null;
        if (mvcSocketResponsedMessage == null) {
            kVar = null;
        } else {
            lVar = mvcSocketResponsedMessage.getData();
            if (mvcSocketMessage != null) {
                kVar4 = mvcSocketMessage.getRequestData();
            }
            kVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : kVar4;
        }
        a(kVar, lVar);
        if (mvcSocketResponsedMessage != null) {
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
        }
        MR();
        if (this.aMS != null) {
            this.aMS.a(false, aVar.isSuccess, aVar.errorCode, aVar.errorMsg, aVar.cGG);
            this.aMS = null;
        }
        if (!this.aZJ) {
            this.aZJ = true;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.eq(1000);
            tVar.axw = false;
            tVar.isSuccess = aVar.isSuccess;
            tVar.axl = mvcSocketResponsedMessage.performanceData.qy;
            tVar.axm = mvcSocketResponsedMessage.performanceData.qz;
            tVar.axn = mvcSocketResponsedMessage.performanceData.qA;
            tVar.axo = mvcSocketResponsedMessage.performanceData.qB;
            tVar.axp = mvcSocketResponsedMessage.performanceData.qC;
            tVar.axu = aVar.cGG;
            tVar.axv = 0L;
            if (this.aZA.aUV != null) {
                e(tVar);
            }
        }
        long j = 0;
        if (mvcSocketMessage != null) {
            j = mvcSocketMessage.getClientLogID();
            kVar2 = mvcSocketMessage.getRequestData();
        } else {
            kVar2 = kVar;
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            kVar3 = mvcNetMessage.getRequestData();
        } else {
            kVar3 = kVar2;
        }
        int error = mvcSocketResponsedMessage.getError();
        String errorString = mvcSocketResponsedMessage.getErrorString();
        int cmd = mvcSocketResponsedMessage.getCmd();
        Object[] objArr = new Object[2];
        objArr[0] = "kw";
        objArr[1] = kVar3 != null ? kVar3.getKw() : null;
        com.baidu.tbadk.core.log.b.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.l> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tieba.tbadkCore.k, com.baidu.tieba.tbadkCore.l> mvcHttpMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.k, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.k kVar;
        com.baidu.tieba.tbadkCore.k kVar2;
        com.baidu.tieba.tbadkCore.k kVar3;
        d.a aVar = new d.a();
        aVar.cGF = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = !mvcHttpResponsedMessage.hasError();
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.cGG = mvcHttpResponsedMessage.getDownSize();
        this.aZE = aVar;
        com.baidu.tieba.tbadkCore.k kVar4 = null;
        com.baidu.tieba.tbadkCore.l lVar = null;
        if (mvcHttpResponsedMessage == null) {
            kVar = null;
        } else {
            lVar = mvcHttpResponsedMessage.getData();
            if (mvcHttpMessage != null) {
                kVar4 = mvcHttpMessage.getRequestData();
            }
            kVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : kVar4;
        }
        a(kVar, lVar);
        if (mvcHttpResponsedMessage != null) {
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
        }
        MR();
        if (this.aMS != null) {
            this.aMS.a(true, aVar.isSuccess, aVar.errorCode, aVar.errorMsg, aVar.cGG);
            this.aMS = null;
        }
        if (!this.aZJ) {
            this.aZJ = true;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.eq(1000);
            tVar.axw = true;
            tVar.isSuccess = aVar.isSuccess;
            tVar.axl = mvcHttpResponsedMessage.performanceData.qy;
            tVar.axm = mvcHttpResponsedMessage.performanceData.qz;
            tVar.axn = mvcHttpResponsedMessage.performanceData.qA;
            tVar.axo = mvcHttpResponsedMessage.performanceData.qB;
            tVar.axp = mvcHttpResponsedMessage.performanceData.qC;
            tVar.axu = 0L;
            tVar.axv = aVar.cGG;
            if (this.aZA.aUV != null) {
                e(tVar);
            }
        }
        long j = 0;
        if (mvcHttpMessage != null) {
            j = mvcHttpMessage.getClientLogID();
            kVar2 = mvcHttpMessage.getRequestData();
        } else {
            kVar2 = kVar;
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            kVar3 = mvcNetMessage.getRequestData();
        } else {
            kVar3 = kVar2;
        }
        int error = mvcHttpResponsedMessage.getError();
        String errorString = mvcHttpResponsedMessage.getErrorString();
        int cmd = mvcHttpResponsedMessage.getCmd();
        Object[] objArr = new Object[2];
        objArr[0] = "kw";
        objArr[1] = kVar3 != null ? kVar3.getKw() : null;
        com.baidu.tbadk.core.log.b.a("frs", j, cmd, "http_resp", error, errorString, objArr);
    }

    public void MR() {
        if (!this.aZI) {
            this.aZI = true;
            this.axr = System.currentTimeMillis() - this.aZA.aUC;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.eq(1000);
            tVar.axk = this.aZA.createTime;
            tVar.axr = this.axr;
            tVar.DY();
        }
    }

    public void e(com.baidu.tbadk.performanceLog.t tVar) {
        if (tVar != null) {
            tVar.axk = this.aZA.createTime;
            this.aZA.createTime = 0L;
            tVar.axq = this.aZA.axq;
            tVar.axr = this.axr == 0 ? System.currentTimeMillis() - this.aZA.aUC : this.axr;
            tVar.DZ();
        }
    }

    public int getType() {
        return this.mType;
    }

    public com.baidu.tieba.tbadkCore.n MS() {
        return this.aUy;
    }

    private void MT() {
        this.aMT = System.currentTimeMillis();
        this.aZC.CV();
    }

    public long IN() {
        return this.aMW;
    }

    public long IO() {
        return this.aMU;
    }

    public long IP() {
        return this.aMV;
    }

    public long IQ() {
        return this.aMT;
    }

    public boolean isLoading() {
        return this.aZC.isLoading();
    }

    public void eX(int i) {
        this.aZH = i;
        bz(true);
    }

    public boolean MU() {
        return this.aZH < 100;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
