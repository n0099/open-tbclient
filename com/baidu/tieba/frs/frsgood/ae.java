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
    private com.baidu.tieba.tbadkCore.d.a aUT;
    private long aUU;
    private long aUV;
    private long aUW;
    private long aUX;
    private long azW;
    private String bde;
    private int bdf;
    private com.baidu.tieba.tbadkCore.p bdo;
    private FrsGoodActivity bkA;
    private ArrayList<com.baidu.adp.widget.ListView.u> bkB;
    private com.baidu.tieba.frs.mc.c<FrsGoodActivity> bkC;
    private com.baidu.tieba.tbadkCore.m bkD;
    private e.a bkE;
    private String bkF;
    private int bkG;
    private boolean bkH;
    private boolean bkI;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public ae(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.bde = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.bdf = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.bkF = null;
        this.bkG = 0;
        this.aUT = null;
        this.azW = 0L;
        this.bkH = false;
        this.bkI = false;
        this.aUU = 0L;
        this.aUV = 0L;
        this.aUW = 0L;
        this.aUX = 0L;
        this.bkA = frsGoodActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        if (this.aUT != null) {
            this.aUT.destory();
        }
        this.bkC.cancelLoadData();
    }

    public void b(Bundle bundle) {
        if (bundle != null) {
            this.bde = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.bdf = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.bde)) {
            this.bde = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.bkD = new com.baidu.tieba.tbadkCore.m();
        this.bdo = new com.baidu.tieba.tbadkCore.p();
        this.bkC = new com.baidu.tieba.frs.mc.c<>(this.bkA.getPageContext(), this.bkD);
        this.bkC.a(this);
        this.bkC.setUniqueId(getUniqueId());
        if (this.bde != null && this.bde.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.bde);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.bdf);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean bP(boolean z) {
        if (this.bkC.isLoading()) {
            return false;
        }
        com.baidu.tieba.tbadkCore.m mVar = (com.baidu.tieba.tbadkCore.m) com.baidu.tieba.tbadkCore.m.objectWithJson(com.baidu.tieba.tbadkCore.m.jsonWithObject(this.bkD), com.baidu.tieba.tbadkCore.m.class);
        mVar.setPn(1);
        a(mVar, 3);
        return true;
    }

    public void gi(int i) {
        if (!this.bkC.isLoading()) {
            com.baidu.tieba.tbadkCore.m mVar = (com.baidu.tieba.tbadkCore.m) com.baidu.tieba.tbadkCore.m.objectWithJson(com.baidu.tieba.tbadkCore.m.jsonWithObject(this.bkD), com.baidu.tieba.tbadkCore.m.class);
            mVar.setPn(i);
            a(mVar, 4);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.m mVar, int i) {
        this.bkA.bdL.fS(i);
        this.bkC.a(mVar);
        this.mType = i;
        mVar.setKw(this.bde);
        if (com.baidu.tbadk.core.m.qQ().qW()) {
            mVar.setRn(35);
        } else {
            mVar.setRn(50);
        }
        mVar.setWithGroup(1);
        mVar.setIsGood(1);
        mVar.setCid(this.bkG);
        int K = com.baidu.adp.lib.util.k.K(this.bkA.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.bkA.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = ay.va().vc() ? 2 : 1;
        mVar.setScrW(K);
        mVar.setScrH(L);
        mVar.setScrDip(f);
        mVar.setqType(i2);
        mVar.setLastId(this.bkF);
        if (this.mSource != null) {
            mVar.setStType(this.mSource);
        }
        if (FrsActivity.bds != 0) {
            mVar.setCtime((int) FrsActivity.bds);
        }
        if (FrsActivity.bdt != 0) {
            mVar.setDataSize((int) FrsActivity.bdt);
        }
        if (FrsActivity.bdu != 0) {
            mVar.setNetError(FrsActivity.bdu);
        }
        mVar.setUpdateType(this.mType);
        mVar.setNeedCache(false);
        if (this.aUT == null) {
            this.aUT = new com.baidu.tieba.tbadkCore.d.a("frsStat");
            this.aUT.start();
        }
        Pa();
    }

    protected boolean a(com.baidu.tieba.tbadkCore.m mVar, com.baidu.tieba.tbadkCore.n nVar) {
        this.bdo.d(nVar);
        this.bkB = this.bdo.getThreadList();
        this.mPageType = "good_page";
        if (mVar != null) {
            this.bkD = mVar;
            this.mPn = this.bkD.getPn();
            this.bde = this.bkD.getKw();
            this.bkA.hs(this.bde);
            this.bkA.setFrom(this.mFrom);
            this.bkA.setPn(this.mPn);
            this.bkA.setFlag(this.bdf);
        }
        this.bkA.bdL.a(this.mType, false, this.bkE);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.n, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.tbadkCore.m, com.baidu.tieba.tbadkCore.n> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.m, com.baidu.tieba.tbadkCore.n> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m mVar;
        com.baidu.tieba.tbadkCore.m mVar2;
        com.baidu.tieba.tbadkCore.m mVar3;
        e.a aVar = new e.a();
        aVar.dEt = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = !mvcSocketResponsedMessage.hasError();
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.dEu = mvcSocketResponsedMessage.getDownSize();
        this.bkE = aVar;
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
        OY();
        if (this.aUT != null) {
            this.aUT.a(false, aVar.isSuccess, aVar.errorCode, aVar.errorMsg, aVar.dEu);
            this.aUT = null;
        }
        if (!this.bkI) {
            this.bkI = true;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.eF(1000);
            tVar.aAb = false;
            tVar.isSuccess = aVar.isSuccess;
            tVar.azQ = mvcSocketResponsedMessage.performanceData.qx;
            tVar.azR = mvcSocketResponsedMessage.performanceData.qy;
            tVar.azS = mvcSocketResponsedMessage.performanceData.qz;
            tVar.azT = mvcSocketResponsedMessage.performanceData.qA;
            tVar.azU = mvcSocketResponsedMessage.performanceData.qB;
            tVar.azZ = aVar.dEu;
            tVar.aAa = 0L;
            tVar.errCode = aVar.errorCode;
            if (this.bkA.bdL != null) {
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
        aVar.dEt = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = !mvcHttpResponsedMessage.hasError();
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.dEu = mvcHttpResponsedMessage.getDownSize();
        this.bkE = aVar;
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
        OY();
        if (this.aUT != null) {
            this.aUT.a(true, aVar.isSuccess, aVar.errorCode, aVar.errorMsg, aVar.dEu);
            this.aUT = null;
        }
        if (!this.bkI) {
            this.bkI = true;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.eF(1000);
            tVar.aAb = true;
            tVar.isSuccess = aVar.isSuccess;
            tVar.azQ = mvcHttpResponsedMessage.performanceData.qx;
            tVar.azR = mvcHttpResponsedMessage.performanceData.qy;
            tVar.azS = mvcHttpResponsedMessage.performanceData.qz;
            tVar.azT = mvcHttpResponsedMessage.performanceData.qA;
            tVar.azU = mvcHttpResponsedMessage.performanceData.qB;
            tVar.azZ = 0L;
            tVar.aAa = aVar.dEu;
            tVar.socketErrNo = mvcHttpResponsedMessage.performanceData.qC;
            tVar.socketCostTime = mvcHttpResponsedMessage.performanceData.qD;
            tVar.errCode = aVar.errorCode;
            if (this.bkA.bdL != null) {
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

    public void OY() {
        if (!this.bkH) {
            this.bkH = true;
            this.azW = System.currentTimeMillis() - this.bkA.VP;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.eF(1000);
            tVar.azP = this.bkA.createTime;
            tVar.azW = this.azW;
            tVar.EB();
        }
    }

    public void e(com.baidu.tbadk.performanceLog.t tVar) {
        if (tVar != null) {
            tVar.azP = this.bkA.createTime;
            this.bkA.createTime = 0L;
            tVar.azV = this.bkA.azV;
            tVar.azW = this.azW == 0 ? System.currentTimeMillis() - this.bkA.VP : this.azW;
            tVar.EC();
        }
    }

    public int getType() {
        return this.mType;
    }

    public com.baidu.tieba.tbadkCore.p OZ() {
        return this.bdo;
    }

    private void Pa() {
        this.aUU = System.currentTimeMillis();
        this.bkC.Dy();
    }

    public long Ku() {
        return this.aUX;
    }

    public long Kv() {
        return this.aUV;
    }

    public long Kw() {
        return this.aUW;
    }

    public long Kx() {
        return this.aUU;
    }

    public boolean isLoading() {
        return this.bkC.isLoading();
    }

    public void fG(int i) {
        this.bkG = i;
        bP(true);
    }

    public boolean Pb() {
        return this.bkG < 100;
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
