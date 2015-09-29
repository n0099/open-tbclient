package com.baidu.tieba.frs.frsgood;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.as;
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
public class ae extends com.baidu.adp.base.e<FrsGoodActivity> implements NetModel.b<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> {
    private com.baidu.tieba.tbadkCore.e.a aMa;
    private long aMb;
    private long aMc;
    private long aMd;
    private long aMe;
    private String aTB;
    private int aTC;
    private com.baidu.tieba.tbadkCore.o aTL;
    private FrsGoodActivity aZM;
    private ArrayList<com.baidu.adp.widget.ListView.u> aZN;
    private com.baidu.tieba.frs.mc.c<FrsGoodActivity> aZO;
    private com.baidu.tieba.tbadkCore.l aZP;
    private e.a aZQ;
    private String aZR;
    private int aZS;
    private boolean aZT;
    private boolean aZU;
    private long axy;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public ae(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.aTB = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.aTC = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.aZR = null;
        this.aZS = 0;
        this.aMa = null;
        this.axy = 0L;
        this.aZT = false;
        this.aZU = false;
        this.aMb = 0L;
        this.aMc = 0L;
        this.aMd = 0L;
        this.aMe = 0L;
        this.aZM = frsGoodActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        if (this.aMa != null) {
            this.aMa.destory();
        }
        this.aZO.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.aTB = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aTC = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.aTB)) {
            this.aTB = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.aZP = new com.baidu.tieba.tbadkCore.l();
        this.aTL = new com.baidu.tieba.tbadkCore.o();
        this.aZO = new com.baidu.tieba.frs.mc.c<>(this.aZM.getPageContext(), this.aZP);
        this.aZO.a(this);
        this.aZO.setUniqueId(getUniqueId());
        if (this.aTB != null && this.aTB.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.aTB);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.aTC);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean bB(boolean z) {
        if (this.aZO.isLoading()) {
            return false;
        }
        com.baidu.tieba.tbadkCore.l lVar = (com.baidu.tieba.tbadkCore.l) com.baidu.tieba.tbadkCore.l.objectWithJson(com.baidu.tieba.tbadkCore.l.jsonWithObject(this.aZP), com.baidu.tieba.tbadkCore.l.class);
        lVar.setPn(1);
        a(lVar, 3);
        return true;
    }

    public void fK(int i) {
        if (!this.aZO.isLoading()) {
            com.baidu.tieba.tbadkCore.l lVar = (com.baidu.tieba.tbadkCore.l) com.baidu.tieba.tbadkCore.l.objectWithJson(com.baidu.tieba.tbadkCore.l.jsonWithObject(this.aZP), com.baidu.tieba.tbadkCore.l.class);
            lVar.setPn(i);
            a(lVar, 4);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.l lVar, int i) {
        this.aZM.aUj.ft(i);
        this.aZO.a(lVar);
        this.mType = i;
        lVar.setKw(this.aTB);
        if (com.baidu.tbadk.core.m.qX().rb()) {
            lVar.setRn(35);
        } else {
            lVar.setRn(50);
        }
        lVar.setWithGroup(1);
        lVar.setIsGood(1);
        lVar.setCid(this.aZS);
        int K = com.baidu.adp.lib.util.k.K(this.aZM.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.aZM.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = as.uI().uK() ? 2 : 1;
        lVar.setScrW(K);
        lVar.setScrH(L);
        lVar.setScrDip(f);
        lVar.setqType(i2);
        lVar.setLastId(this.aZR);
        if (this.mSource != null) {
            lVar.setStType(this.mSource);
        }
        if (FrsActivity.aTQ != 0) {
            lVar.setCtime((int) FrsActivity.aTQ);
        }
        if (FrsActivity.aTR != 0) {
            lVar.setDataSize((int) FrsActivity.aTR);
        }
        if (FrsActivity.aTS != 0) {
            lVar.setNetError(FrsActivity.aTS);
        }
        lVar.setUpdateType(this.mType);
        lVar.setNeedCache(false);
        if (this.aMa == null) {
            this.aMa = new com.baidu.tieba.tbadkCore.e.a("frsStat");
            this.aMa.start();
        }
        MS();
    }

    protected boolean a(com.baidu.tieba.tbadkCore.l lVar, com.baidu.tieba.tbadkCore.m mVar) {
        this.aTL.d(mVar);
        this.aZN = this.aTL.getThreadList();
        this.mPageType = "good_page";
        if (lVar != null) {
            this.aZP = lVar;
            this.mPn = this.aZP.getPn();
            this.aTB = this.aZP.getKw();
            this.aZM.gN(this.aTB);
            this.aZM.setFrom(this.mFrom);
            this.aZM.setPn(this.mPn);
            this.aZM.setFlag(this.aTC);
        }
        this.aZM.aUj.a(this.mType, false, this.aZQ);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        com.baidu.tieba.tbadkCore.l lVar2;
        com.baidu.tieba.tbadkCore.l lVar3;
        e.a aVar = new e.a();
        aVar.cWu = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = !mvcSocketResponsedMessage.hasError();
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.cWv = mvcSocketResponsedMessage.getDownSize();
        this.aZQ = aVar;
        com.baidu.tieba.tbadkCore.l lVar4 = null;
        com.baidu.tieba.tbadkCore.m mVar = null;
        if (mvcSocketResponsedMessage == null) {
            lVar = null;
        } else {
            mVar = mvcSocketResponsedMessage.getData();
            if (mvcSocketMessage != null) {
                lVar4 = mvcSocketMessage.getRequestData();
            }
            lVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : lVar4;
        }
        a(lVar, mVar);
        if (mvcSocketResponsedMessage != null) {
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
        }
        MQ();
        if (this.aMa != null) {
            this.aMa.a(false, aVar.isSuccess, aVar.errorCode, aVar.errorMsg, aVar.cWv);
            this.aMa = null;
        }
        if (!this.aZU) {
            this.aZU = true;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ez(1000);
            tVar.axD = false;
            tVar.isSuccess = aVar.isSuccess;
            tVar.axs = mvcSocketResponsedMessage.performanceData.qw;
            tVar.axt = mvcSocketResponsedMessage.performanceData.qx;
            tVar.axu = mvcSocketResponsedMessage.performanceData.qy;
            tVar.axv = mvcSocketResponsedMessage.performanceData.qz;
            tVar.axw = mvcSocketResponsedMessage.performanceData.qA;
            tVar.axB = aVar.cWv;
            tVar.axC = 0L;
            if (this.aZM.aUj != null) {
                e(tVar);
            }
        }
        long j = 0;
        if (mvcSocketMessage != null) {
            j = mvcSocketMessage.getClientLogID();
            lVar2 = mvcSocketMessage.getRequestData();
        } else {
            lVar2 = lVar;
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            lVar3 = mvcNetMessage.getRequestData();
        } else {
            lVar3 = lVar2;
        }
        int error = mvcSocketResponsedMessage.getError();
        String errorString = mvcSocketResponsedMessage.getErrorString();
        int cmd = mvcSocketResponsedMessage.getCmd();
        Object[] objArr = new Object[2];
        objArr[0] = "kw";
        objArr[1] = lVar3 != null ? lVar3.getKw() : null;
        com.baidu.tbadk.core.log.b.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcHttpMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        com.baidu.tieba.tbadkCore.l lVar2;
        com.baidu.tieba.tbadkCore.l lVar3;
        e.a aVar = new e.a();
        aVar.cWu = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = !mvcHttpResponsedMessage.hasError();
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.cWv = mvcHttpResponsedMessage.getDownSize();
        this.aZQ = aVar;
        com.baidu.tieba.tbadkCore.l lVar4 = null;
        com.baidu.tieba.tbadkCore.m mVar = null;
        if (mvcHttpResponsedMessage == null) {
            lVar = null;
        } else {
            mVar = mvcHttpResponsedMessage.getData();
            if (mvcHttpMessage != null) {
                lVar4 = mvcHttpMessage.getRequestData();
            }
            lVar = mvcNetMessage != null ? mvcNetMessage.getRequestData() : lVar4;
        }
        a(lVar, mVar);
        if (mvcHttpResponsedMessage != null) {
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
        }
        MQ();
        if (this.aMa != null) {
            this.aMa.a(true, aVar.isSuccess, aVar.errorCode, aVar.errorMsg, aVar.cWv);
            this.aMa = null;
        }
        if (!this.aZU) {
            this.aZU = true;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ez(1000);
            tVar.axD = true;
            tVar.isSuccess = aVar.isSuccess;
            tVar.axs = mvcHttpResponsedMessage.performanceData.qw;
            tVar.axt = mvcHttpResponsedMessage.performanceData.qx;
            tVar.axu = mvcHttpResponsedMessage.performanceData.qy;
            tVar.axv = mvcHttpResponsedMessage.performanceData.qz;
            tVar.axw = mvcHttpResponsedMessage.performanceData.qA;
            tVar.axB = 0L;
            tVar.axC = aVar.cWv;
            if (this.aZM.aUj != null) {
                e(tVar);
            }
        }
        long j = 0;
        if (mvcHttpMessage != null) {
            j = mvcHttpMessage.getClientLogID();
            lVar2 = mvcHttpMessage.getRequestData();
        } else {
            lVar2 = lVar;
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            lVar3 = mvcNetMessage.getRequestData();
        } else {
            lVar3 = lVar2;
        }
        int error = mvcHttpResponsedMessage.getError();
        String errorString = mvcHttpResponsedMessage.getErrorString();
        int cmd = mvcHttpResponsedMessage.getCmd();
        Object[] objArr = new Object[2];
        objArr[0] = "kw";
        objArr[1] = lVar3 != null ? lVar3.getKw() : null;
        com.baidu.tbadk.core.log.b.a("frs", j, cmd, "http_resp", error, errorString, objArr);
    }

    public void MQ() {
        if (!this.aZT) {
            this.aZT = true;
            this.axy = System.currentTimeMillis() - this.aZM.aTP;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ez(1000);
            tVar.axr = this.aZM.createTime;
            tVar.axy = this.axy;
            tVar.DV();
        }
    }

    public void e(com.baidu.tbadk.performanceLog.t tVar) {
        if (tVar != null) {
            tVar.axr = this.aZM.createTime;
            this.aZM.createTime = 0L;
            tVar.axx = this.aZM.axx;
            tVar.axy = this.axy == 0 ? System.currentTimeMillis() - this.aZM.aTP : this.axy;
            tVar.DW();
        }
    }

    public int getType() {
        return this.mType;
    }

    public com.baidu.tieba.tbadkCore.o MR() {
        return this.aTL;
    }

    private void MS() {
        this.aMb = System.currentTimeMillis();
        this.aZO.CS();
    }

    public long Ix() {
        return this.aMe;
    }

    public long Iy() {
        return this.aMc;
    }

    public long Iz() {
        return this.aMd;
    }

    public long IA() {
        return this.aMb;
    }

    public boolean isLoading() {
        return this.aZO.isLoading();
    }

    public void fj(int i) {
        this.aZS = i;
        bB(true);
    }

    public boolean MT() {
        return this.aZS < 100;
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
