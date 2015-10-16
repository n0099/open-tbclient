package com.baidu.tieba.frs.frsgood;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.at;
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
    private com.baidu.tieba.tbadkCore.e.a aMl;
    private long aMm;
    private long aMn;
    private long aMo;
    private long aMp;
    private String aTM;
    private int aTN;
    private com.baidu.tieba.tbadkCore.o aTW;
    private FrsGoodActivity aZX;
    private ArrayList<com.baidu.adp.widget.ListView.u> aZY;
    private com.baidu.tieba.frs.mc.c<FrsGoodActivity> aZZ;
    private long axz;
    private com.baidu.tieba.tbadkCore.l baa;
    private e.a bab;
    private String bac;
    private int bad;
    private boolean bae;
    private boolean baf;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public ae(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.aTM = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.aTN = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.bac = null;
        this.bad = 0;
        this.aMl = null;
        this.axz = 0L;
        this.bae = false;
        this.baf = false;
        this.aMm = 0L;
        this.aMn = 0L;
        this.aMo = 0L;
        this.aMp = 0L;
        this.aZX = frsGoodActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        if (this.aMl != null) {
            this.aMl.destory();
        }
        this.aZZ.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.aTM = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aTN = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.aTM)) {
            this.aTM = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.baa = new com.baidu.tieba.tbadkCore.l();
        this.aTW = new com.baidu.tieba.tbadkCore.o();
        this.aZZ = new com.baidu.tieba.frs.mc.c<>(this.aZX.getPageContext(), this.baa);
        this.aZZ.a(this);
        this.aZZ.setUniqueId(getUniqueId());
        if (this.aTM != null && this.aTM.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.aTM);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.aTN);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean bB(boolean z) {
        if (this.aZZ.isLoading()) {
            return false;
        }
        com.baidu.tieba.tbadkCore.l lVar = (com.baidu.tieba.tbadkCore.l) com.baidu.tieba.tbadkCore.l.objectWithJson(com.baidu.tieba.tbadkCore.l.jsonWithObject(this.baa), com.baidu.tieba.tbadkCore.l.class);
        lVar.setPn(1);
        a(lVar, 3);
        return true;
    }

    public void fK(int i) {
        if (!this.aZZ.isLoading()) {
            com.baidu.tieba.tbadkCore.l lVar = (com.baidu.tieba.tbadkCore.l) com.baidu.tieba.tbadkCore.l.objectWithJson(com.baidu.tieba.tbadkCore.l.jsonWithObject(this.baa), com.baidu.tieba.tbadkCore.l.class);
            lVar.setPn(i);
            a(lVar, 4);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.l lVar, int i) {
        this.aZX.aUu.ft(i);
        this.aZZ.a(lVar);
        this.mType = i;
        lVar.setKw(this.aTM);
        if (com.baidu.tbadk.core.m.qX().rb()) {
            lVar.setRn(35);
        } else {
            lVar.setRn(50);
        }
        lVar.setWithGroup(1);
        lVar.setIsGood(1);
        lVar.setCid(this.bad);
        int K = com.baidu.adp.lib.util.k.K(this.aZX.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.aZX.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = at.uJ().uL() ? 2 : 1;
        lVar.setScrW(K);
        lVar.setScrH(L);
        lVar.setScrDip(f);
        lVar.setqType(i2);
        lVar.setLastId(this.bac);
        if (this.mSource != null) {
            lVar.setStType(this.mSource);
        }
        if (FrsActivity.aUb != 0) {
            lVar.setCtime((int) FrsActivity.aUb);
        }
        if (FrsActivity.aUc != 0) {
            lVar.setDataSize((int) FrsActivity.aUc);
        }
        if (FrsActivity.aUd != 0) {
            lVar.setNetError(FrsActivity.aUd);
        }
        lVar.setUpdateType(this.mType);
        lVar.setNeedCache(false);
        if (this.aMl == null) {
            this.aMl = new com.baidu.tieba.tbadkCore.e.a("frsStat");
            this.aMl.start();
        }
        MS();
    }

    protected boolean a(com.baidu.tieba.tbadkCore.l lVar, com.baidu.tieba.tbadkCore.m mVar) {
        this.aTW.d(mVar);
        this.aZY = this.aTW.getThreadList();
        this.mPageType = "good_page";
        if (lVar != null) {
            this.baa = lVar;
            this.mPn = this.baa.getPn();
            this.aTM = this.baa.getKw();
            this.aZX.gN(this.aTM);
            this.aZX.setFrom(this.mFrom);
            this.aZX.setPn(this.mPn);
            this.aZX.setFlag(this.aTN);
        }
        this.aZX.aUu.a(this.mType, false, this.bab);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        com.baidu.tieba.tbadkCore.l lVar2;
        com.baidu.tieba.tbadkCore.l lVar3;
        e.a aVar = new e.a();
        aVar.cWT = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = !mvcSocketResponsedMessage.hasError();
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.cWU = mvcSocketResponsedMessage.getDownSize();
        this.bab = aVar;
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
        if (this.aMl != null) {
            this.aMl.a(false, aVar.isSuccess, aVar.errorCode, aVar.errorMsg, aVar.cWU);
            this.aMl = null;
        }
        if (!this.baf) {
            this.baf = true;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ez(1000);
            tVar.axE = false;
            tVar.isSuccess = aVar.isSuccess;
            tVar.axt = mvcSocketResponsedMessage.performanceData.qw;
            tVar.axu = mvcSocketResponsedMessage.performanceData.qx;
            tVar.axv = mvcSocketResponsedMessage.performanceData.qy;
            tVar.axw = mvcSocketResponsedMessage.performanceData.qz;
            tVar.axx = mvcSocketResponsedMessage.performanceData.qA;
            tVar.axC = aVar.cWU;
            tVar.axD = 0L;
            if (this.aZX.aUu != null) {
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
        aVar.cWT = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = !mvcHttpResponsedMessage.hasError();
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.cWU = mvcHttpResponsedMessage.getDownSize();
        this.bab = aVar;
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
        if (this.aMl != null) {
            this.aMl.a(true, aVar.isSuccess, aVar.errorCode, aVar.errorMsg, aVar.cWU);
            this.aMl = null;
        }
        if (!this.baf) {
            this.baf = true;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ez(1000);
            tVar.axE = true;
            tVar.isSuccess = aVar.isSuccess;
            tVar.axt = mvcHttpResponsedMessage.performanceData.qw;
            tVar.axu = mvcHttpResponsedMessage.performanceData.qx;
            tVar.axv = mvcHttpResponsedMessage.performanceData.qy;
            tVar.axw = mvcHttpResponsedMessage.performanceData.qz;
            tVar.axx = mvcHttpResponsedMessage.performanceData.qA;
            tVar.axC = 0L;
            tVar.axD = aVar.cWU;
            if (this.aZX.aUu != null) {
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
        if (!this.bae) {
            this.bae = true;
            this.axz = System.currentTimeMillis() - this.aZX.aUa;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ez(1000);
            tVar.axs = this.aZX.createTime;
            tVar.axz = this.axz;
            tVar.DV();
        }
    }

    public void e(com.baidu.tbadk.performanceLog.t tVar) {
        if (tVar != null) {
            tVar.axs = this.aZX.createTime;
            this.aZX.createTime = 0L;
            tVar.axy = this.aZX.axy;
            tVar.axz = this.axz == 0 ? System.currentTimeMillis() - this.aZX.aUa : this.axz;
            tVar.DW();
        }
    }

    public int getType() {
        return this.mType;
    }

    public com.baidu.tieba.tbadkCore.o MR() {
        return this.aTW;
    }

    private void MS() {
        this.aMm = System.currentTimeMillis();
        this.aZZ.CS();
    }

    public long Ix() {
        return this.aMp;
    }

    public long Iy() {
        return this.aMn;
    }

    public long Iz() {
        return this.aMo;
    }

    public long IA() {
        return this.aMm;
    }

    public boolean isLoading() {
        return this.aZZ.isLoading();
    }

    public void fj(int i) {
        this.bad = i;
        bB(true);
    }

    public boolean MT() {
        return this.bad < 100;
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
