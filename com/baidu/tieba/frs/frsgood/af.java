package com.baidu.tieba.frs.frsgood;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ax;
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
public class af extends com.baidu.adp.base.e<FrsGoodActivity> implements NetModel.b<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> {
    private long aAL;
    private com.baidu.tieba.tbadkCore.d.b aXf;
    private long aXg;
    private long aXh;
    private long aXi;
    private long aXj;
    private String aer;
    private com.baidu.tieba.tbadkCore.o bfF;
    private String bfv;
    private int bfw;
    private com.baidu.tieba.tbadkCore.l bnA;
    private d.a bnB;
    private String bnC;
    private int bnD;
    private boolean bnE;
    private boolean bnF;
    private FrsGoodActivity bnx;
    private ArrayList<com.baidu.adp.widget.ListView.u> bny;
    private com.baidu.tieba.frs.mc.c<FrsGoodActivity> bnz;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public af(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.bfv = null;
        this.mType = 3;
        this.mPn = 1;
        this.aer = null;
        this.bfw = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.bnC = null;
        this.bnD = 0;
        this.aXf = null;
        this.aAL = 0L;
        this.bnE = false;
        this.bnF = false;
        this.aXg = 0L;
        this.aXh = 0L;
        this.aXi = 0L;
        this.aXj = 0L;
        this.bnx = frsGoodActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        if (this.aXf != null) {
            this.aXf.destory();
        }
        this.bnz.cancelLoadData();
    }

    public void c(Bundle bundle) {
        if (bundle != null) {
            this.bfv = bundle.getString("name");
            this.aer = bundle.getString("from");
            this.bfw = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.bfv)) {
            this.bfv = "";
        }
        if (TextUtils.isEmpty(this.aer)) {
            this.aer = "";
        }
        this.mSource = this.aer;
        this.bnA = new com.baidu.tieba.tbadkCore.l();
        this.bfF = new com.baidu.tieba.tbadkCore.o();
        this.bnz = new com.baidu.tieba.frs.mc.c<>(this.bnx.getPageContext(), this.bnA);
        this.bnz.a(this);
        this.bnz.setUniqueId(getUniqueId());
        if (this.bfv != null && this.bfv.length() > 0) {
            if (this.aer == null || this.aer.length() <= 0) {
                this.aer = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.bfv);
        bundle.putString("from", this.aer);
        bundle.putInt(FrsActivityConfig.FLAG, this.bfw);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean bU(boolean z) {
        if (this.bnz.isLoading()) {
            return false;
        }
        com.baidu.tieba.tbadkCore.l lVar = (com.baidu.tieba.tbadkCore.l) com.baidu.tieba.tbadkCore.l.objectWithJson(com.baidu.tieba.tbadkCore.l.jsonWithObject(this.bnA), com.baidu.tieba.tbadkCore.l.class);
        lVar.setPn(1);
        a(lVar, 3);
        return true;
    }

    public void gF(int i) {
        if (!this.bnz.isLoading()) {
            com.baidu.tieba.tbadkCore.l lVar = (com.baidu.tieba.tbadkCore.l) com.baidu.tieba.tbadkCore.l.objectWithJson(com.baidu.tieba.tbadkCore.l.jsonWithObject(this.bnA), com.baidu.tieba.tbadkCore.l.class);
            lVar.setPn(i);
            a(lVar, 4);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.l lVar, int i) {
        this.bnx.bgd.gp(i);
        this.bnz.a(lVar);
        this.mType = i;
        lVar.setKw(this.bfv);
        if (com.baidu.tbadk.core.l.rn().rt()) {
            lVar.setRn(35);
        } else {
            lVar.setRn(50);
        }
        lVar.setWithGroup(1);
        lVar.setIsGood(1);
        lVar.setCid(this.bnD);
        int K = com.baidu.adp.lib.util.k.K(this.bnx.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.bnx.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = ax.wg().wi() ? 2 : 1;
        lVar.setScrW(K);
        lVar.setScrH(L);
        lVar.setScrDip(f);
        lVar.setqType(i2);
        lVar.setLastId(this.bnC);
        if (this.mSource != null) {
            lVar.setStType(this.mSource);
        }
        if (FrsActivity.bfJ != 0) {
            lVar.setCtime((int) FrsActivity.bfJ);
        }
        if (FrsActivity.bfK != 0) {
            lVar.setDataSize((int) FrsActivity.bfK);
        }
        if (FrsActivity.bfL != 0) {
            lVar.setNetError(FrsActivity.bfL);
        }
        lVar.setUpdateType(this.mType);
        lVar.setNeedCache(false);
        if (this.aXf == null) {
            this.aXf = new com.baidu.tieba.tbadkCore.d.b("frsStat");
            this.aXf.start();
        }
        Rd();
    }

    protected boolean a(com.baidu.tieba.tbadkCore.l lVar, com.baidu.tieba.tbadkCore.m mVar) {
        this.bfF.d(mVar);
        this.bny = this.bfF.getThreadList();
        this.mPageType = "good_page";
        if (lVar != null) {
            this.bnA = lVar;
            this.mPn = this.bnA.getPn();
            this.bfv = this.bnA.getKw();
            this.bnx.hs(this.bfv);
            this.bnx.setFrom(this.aer);
            this.bnx.setPn(this.mPn);
            this.bnx.setFlag(this.bfw);
        }
        this.bnx.bgd.a(this.mType, false, this.bnB);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        com.baidu.tieba.tbadkCore.l lVar2;
        com.baidu.tieba.tbadkCore.l lVar3;
        d.a aVar = new d.a();
        aVar.dUo = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = !mvcSocketResponsedMessage.hasError();
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.dUp = mvcSocketResponsedMessage.getDownSize();
        this.bnB = aVar;
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
        Rb();
        if (this.aXf != null) {
            this.aXf.a(false, aVar.isSuccess, aVar.errorCode, aVar.errorMsg, aVar.dUp);
            this.aXf = null;
        }
        if (!this.bnF) {
            this.bnF = true;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.eZ(1000);
            vVar.aAQ = false;
            vVar.isSuccess = aVar.isSuccess;
            vVar.aAF = mvcSocketResponsedMessage.performanceData.qD;
            vVar.aAG = mvcSocketResponsedMessage.performanceData.qE;
            vVar.aAH = mvcSocketResponsedMessage.performanceData.qF;
            vVar.aAI = mvcSocketResponsedMessage.performanceData.qG;
            vVar.aAJ = mvcSocketResponsedMessage.performanceData.qH;
            vVar.aAO = aVar.dUp;
            vVar.aAP = 0L;
            vVar.errCode = aVar.errorCode;
            if (this.bnx.bgd != null) {
                e(vVar);
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
        d.a aVar = new d.a();
        aVar.dUo = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = !mvcHttpResponsedMessage.hasError();
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.dUp = mvcHttpResponsedMessage.getDownSize();
        this.bnB = aVar;
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
        Rb();
        if (this.aXf != null) {
            this.aXf.a(true, aVar.isSuccess, aVar.errorCode, aVar.errorMsg, aVar.dUp);
            this.aXf = null;
        }
        if (!this.bnF) {
            this.bnF = true;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.eZ(1000);
            vVar.aAQ = true;
            vVar.isSuccess = aVar.isSuccess;
            vVar.aAF = mvcHttpResponsedMessage.performanceData.qD;
            vVar.aAG = mvcHttpResponsedMessage.performanceData.qE;
            vVar.aAH = mvcHttpResponsedMessage.performanceData.qF;
            vVar.aAI = mvcHttpResponsedMessage.performanceData.qG;
            vVar.aAJ = mvcHttpResponsedMessage.performanceData.qH;
            vVar.aAO = 0L;
            vVar.aAP = aVar.dUp;
            vVar.socketErrNo = mvcHttpResponsedMessage.performanceData.qI;
            vVar.socketCostTime = mvcHttpResponsedMessage.performanceData.qJ;
            vVar.errCode = aVar.errorCode;
            if (this.bnx.bgd != null) {
                e(vVar);
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

    public void Rb() {
        if (!this.bnE) {
            this.bnE = true;
            this.aAL = System.currentTimeMillis() - this.bnx.VB;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.eZ(1000);
            vVar.aAE = this.bnx.createTime;
            vVar.aAL = this.aAL;
            vVar.FS();
        }
    }

    public void e(com.baidu.tbadk.performanceLog.v vVar) {
        if (vVar != null) {
            vVar.aAE = this.bnx.createTime;
            this.bnx.createTime = 0L;
            vVar.aAK = this.bnx.aAK;
            vVar.aAL = this.aAL == 0 ? System.currentTimeMillis() - this.bnx.VB : this.aAL;
            vVar.FT();
        }
    }

    public int getType() {
        return this.mType;
    }

    public com.baidu.tieba.tbadkCore.o Rc() {
        return this.bfF;
    }

    private void Rd() {
        this.aXg = System.currentTimeMillis();
        this.bnz.ET();
    }

    public long Ml() {
        return this.aXj;
    }

    public long Mm() {
        return this.aXh;
    }

    public long Mn() {
        return this.aXi;
    }

    public long Mo() {
        return this.aXg;
    }

    public boolean isLoading() {
        return this.bnz.isLoading();
    }

    public void gf(int i) {
        this.bnD = i;
        bU(true);
    }

    public boolean Re() {
        return this.bnD < 100;
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
