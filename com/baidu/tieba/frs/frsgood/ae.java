package com.baidu.tieba.frs.frsgood;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.e<FrsGoodActivity> implements NetModel.b<com.baidu.tieba.tbadkCore.m, com.baidu.tieba.tbadkCore.n> {
    private com.baidu.tieba.tbadkCore.d.a aRc;
    private long aRd;
    private long aRe;
    private long aRf;
    private long aRg;
    private String aZi;
    private int aZj;
    private com.baidu.tieba.tbadkCore.p aZs;
    private long ayt;
    private FrsGoodActivity bgJ;
    private ArrayList<com.baidu.adp.widget.ListView.u> bgK;
    private com.baidu.tieba.frs.mc.c<FrsGoodActivity> bgL;
    private com.baidu.tieba.tbadkCore.m bgM;
    private e.a bgN;
    private String bgO;
    private int bgP;
    private boolean bgQ;
    private boolean bgR;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public ae(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.aZi = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.aZj = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.bgO = null;
        this.bgP = 0;
        this.aRc = null;
        this.ayt = 0L;
        this.bgQ = false;
        this.bgR = false;
        this.aRd = 0L;
        this.aRe = 0L;
        this.aRf = 0L;
        this.aRg = 0L;
        this.bgJ = frsGoodActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        if (this.aRc != null) {
            this.aRc.destory();
        }
        this.bgL.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.aZi = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aZj = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.aZi)) {
            this.aZi = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.bgM = new com.baidu.tieba.tbadkCore.m();
        this.aZs = new com.baidu.tieba.tbadkCore.p();
        this.bgL = new com.baidu.tieba.frs.mc.c<>(this.bgJ.getPageContext(), this.bgM);
        this.bgL.a(this);
        this.bgL.setUniqueId(getUniqueId());
        if (this.aZi != null && this.aZi.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.aZi);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.aZj);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean bO(boolean z) {
        if (this.bgL.isLoading()) {
            return false;
        }
        com.baidu.tieba.tbadkCore.m mVar = (com.baidu.tieba.tbadkCore.m) com.baidu.tieba.tbadkCore.m.objectWithJson(com.baidu.tieba.tbadkCore.m.jsonWithObject(this.bgM), com.baidu.tieba.tbadkCore.m.class);
        mVar.setPn(1);
        a(mVar, 3);
        return true;
    }

    public void gp(int i) {
        if (!this.bgL.isLoading()) {
            com.baidu.tieba.tbadkCore.m mVar = (com.baidu.tieba.tbadkCore.m) com.baidu.tieba.tbadkCore.m.objectWithJson(com.baidu.tieba.tbadkCore.m.jsonWithObject(this.bgM), com.baidu.tieba.tbadkCore.m.class);
            mVar.setPn(i);
            a(mVar, 4);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.m mVar, int i) {
        this.bgJ.aZP.fX(i);
        this.bgL.a(mVar);
        this.mType = i;
        mVar.setKw(this.aZi);
        if (com.baidu.tbadk.core.m.rh().rn()) {
            mVar.setRn(35);
        } else {
            mVar.setRn(50);
        }
        mVar.setWithGroup(1);
        mVar.setIsGood(1);
        mVar.setCid(this.bgP);
        int K = com.baidu.adp.lib.util.k.K(this.bgJ.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.bgJ.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = ay.vq().vs() ? 2 : 1;
        mVar.setScrW(K);
        mVar.setScrH(L);
        mVar.setScrDip(f);
        mVar.setqType(i2);
        mVar.setLastId(this.bgO);
        if (this.mSource != null) {
            mVar.setStType(this.mSource);
        }
        if (FrsActivity.aZw != 0) {
            mVar.setCtime((int) FrsActivity.aZw);
        }
        if (FrsActivity.aZx != 0) {
            mVar.setDataSize((int) FrsActivity.aZx);
        }
        if (FrsActivity.aZy != 0) {
            mVar.setNetError(FrsActivity.aZy);
        }
        mVar.setUpdateType(this.mType);
        mVar.setNeedCache(false);
        if (this.aRc == null) {
            this.aRc = new com.baidu.tieba.tbadkCore.d.a("frsStat");
            this.aRc.start();
        }
        OI();
    }

    protected boolean a(com.baidu.tieba.tbadkCore.m mVar, com.baidu.tieba.tbadkCore.n nVar) {
        this.aZs.d(nVar);
        this.bgK = this.aZs.getThreadList();
        this.mPageType = "good_page";
        if (mVar != null) {
            this.bgM = mVar;
            this.mPn = this.bgM.getPn();
            this.aZi = this.bgM.getKw();
            this.bgJ.hg(this.aZi);
            this.bgJ.setFrom(this.mFrom);
            this.bgJ.setPn(this.mPn);
            this.bgJ.setFlag(this.aZj);
        }
        this.bgJ.aZP.a(this.mType, false, this.bgN);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.n, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.tbadkCore.m, com.baidu.tieba.tbadkCore.n> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.m, com.baidu.tieba.tbadkCore.n> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m mVar;
        com.baidu.tieba.tbadkCore.m mVar2;
        com.baidu.tieba.tbadkCore.m mVar3;
        e.a aVar = new e.a();
        aVar.dwT = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = !mvcSocketResponsedMessage.hasError();
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.dwU = mvcSocketResponsedMessage.getDownSize();
        this.bgN = aVar;
        com.baidu.tieba.tbadkCore.m mVar4 = null;
        com.baidu.tieba.tbadkCore.n nVar = null;
        if (mvcSocketResponsedMessage == null) {
            mVar = null;
        } else {
            nVar = mvcSocketResponsedMessage.getData();
            if (mvcSocketMessage != null) {
                mVar4 = mvcSocketMessage.getRequestData();
            }
            mVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : mVar4;
        }
        a(mVar, nVar);
        if (mvcSocketResponsedMessage != null) {
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
        }
        OG();
        if (this.aRc != null) {
            this.aRc.a(false, aVar.isSuccess, aVar.errorCode, aVar.errorMsg, aVar.dwU);
            this.aRc = null;
        }
        if (!this.bgR) {
            this.bgR = true;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.eL(1000);
            tVar.ayy = false;
            tVar.isSuccess = aVar.isSuccess;
            tVar.ayn = mvcSocketResponsedMessage.performanceData.qx;
            tVar.ayo = mvcSocketResponsedMessage.performanceData.qy;
            tVar.ayp = mvcSocketResponsedMessage.performanceData.qz;
            tVar.ayq = mvcSocketResponsedMessage.performanceData.qA;
            tVar.ayr = mvcSocketResponsedMessage.performanceData.qB;
            tVar.ayw = aVar.dwU;
            tVar.ayx = 0L;
            tVar.errCode = aVar.errorCode;
            if (this.bgJ.aZP != null) {
                e(tVar);
            }
        }
        long j = 0;
        if (mvcSocketMessage != null) {
            j = mvcSocketMessage.getClientLogID();
            mVar2 = mvcSocketMessage.getRequestData();
        } else {
            mVar2 = mVar;
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            mVar3 = mvcNetMessage.getRequestData();
        } else {
            mVar3 = mVar2;
        }
        int error = mvcSocketResponsedMessage.getError();
        String errorString = mvcSocketResponsedMessage.getErrorString();
        int cmd = mvcSocketResponsedMessage.getCmd();
        Object[] objArr = new Object[2];
        objArr[0] = "kw";
        objArr[1] = mVar3 != null ? mVar3.getKw() : null;
        com.baidu.tbadk.core.log.b.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.n> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tieba.tbadkCore.m, com.baidu.tieba.tbadkCore.n> mvcHttpMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.m, com.baidu.tieba.tbadkCore.n> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m mVar;
        com.baidu.tieba.tbadkCore.m mVar2;
        com.baidu.tieba.tbadkCore.m mVar3;
        e.a aVar = new e.a();
        aVar.dwT = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = !mvcHttpResponsedMessage.hasError();
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.dwU = mvcHttpResponsedMessage.getDownSize();
        this.bgN = aVar;
        com.baidu.tieba.tbadkCore.m mVar4 = null;
        com.baidu.tieba.tbadkCore.n nVar = null;
        if (mvcHttpResponsedMessage == null) {
            mVar = null;
        } else {
            nVar = mvcHttpResponsedMessage.getData();
            if (mvcHttpMessage != null) {
                mVar4 = mvcHttpMessage.getRequestData();
            }
            mVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : mVar4;
        }
        a(mVar, nVar);
        if (mvcHttpResponsedMessage != null) {
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
        }
        OG();
        if (this.aRc != null) {
            this.aRc.a(true, aVar.isSuccess, aVar.errorCode, aVar.errorMsg, aVar.dwU);
            this.aRc = null;
        }
        if (!this.bgR) {
            this.bgR = true;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.eL(1000);
            tVar.ayy = true;
            tVar.isSuccess = aVar.isSuccess;
            tVar.ayn = mvcHttpResponsedMessage.performanceData.qx;
            tVar.ayo = mvcHttpResponsedMessage.performanceData.qy;
            tVar.ayp = mvcHttpResponsedMessage.performanceData.qz;
            tVar.ayq = mvcHttpResponsedMessage.performanceData.qA;
            tVar.ayr = mvcHttpResponsedMessage.performanceData.qB;
            tVar.ayw = 0L;
            tVar.ayx = aVar.dwU;
            tVar.socketErrNo = mvcHttpResponsedMessage.performanceData.qC;
            tVar.errCode = aVar.errorCode;
            if (this.bgJ.aZP != null) {
                e(tVar);
            }
        }
        long j = 0;
        if (mvcHttpMessage != null) {
            j = mvcHttpMessage.getClientLogID();
            mVar2 = mvcHttpMessage.getRequestData();
        } else {
            mVar2 = mVar;
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            mVar3 = mvcNetMessage.getRequestData();
        } else {
            mVar3 = mVar2;
        }
        int error = mvcHttpResponsedMessage.getError();
        String errorString = mvcHttpResponsedMessage.getErrorString();
        int cmd = mvcHttpResponsedMessage.getCmd();
        Object[] objArr = new Object[2];
        objArr[0] = "kw";
        objArr[1] = mVar3 != null ? mVar3.getKw() : null;
        com.baidu.tbadk.core.log.b.a("frs", j, cmd, "http_resp", error, errorString, objArr);
    }

    public void OG() {
        if (!this.bgQ) {
            this.bgQ = true;
            this.ayt = System.currentTimeMillis() - this.bgJ.Vp;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.eL(1000);
            tVar.aym = this.bgJ.createTime;
            tVar.ayt = this.ayt;
            tVar.EM();
        }
    }

    public void e(com.baidu.tbadk.performanceLog.t tVar) {
        if (tVar != null) {
            tVar.aym = this.bgJ.createTime;
            this.bgJ.createTime = 0L;
            tVar.ays = this.bgJ.ays;
            tVar.ayt = this.ayt == 0 ? System.currentTimeMillis() - this.bgJ.Vp : this.ayt;
            tVar.EN();
        }
    }

    public int getType() {
        return this.mType;
    }

    public com.baidu.tieba.tbadkCore.p OH() {
        return this.aZs;
    }

    private void OI() {
        this.aRd = System.currentTimeMillis();
        this.bgL.DJ();
    }

    public long Kb() {
        return this.aRg;
    }

    public long Kc() {
        return this.aRe;
    }

    public long Kd() {
        return this.aRf;
    }

    public long Ke() {
        return this.aRd;
    }

    public boolean isLoading() {
        return this.bgL.isLoading();
    }

    public void fL(int i) {
        this.bgP = i;
        bO(true);
    }

    public boolean OJ() {
        return this.bgP < 100;
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
