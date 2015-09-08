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
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.e<FrsGoodActivity> implements NetModel.b<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> {
    private com.baidu.tieba.tbadkCore.e.a aNf;
    private long aNg;
    private long aNh;
    private long aNi;
    private long aNj;
    private String aUF;
    private int aUG;
    private com.baidu.tieba.tbadkCore.o aUN;
    private FrsGoodActivity aZT;
    private ArrayList<com.baidu.adp.widget.ListView.u> aZU;
    private com.baidu.tieba.frs.b.c<FrsGoodActivity> aZV;
    private com.baidu.tieba.tbadkCore.l aZW;
    private e.a aZX;
    private String aZY;
    private int aZZ;
    private long ayZ;
    private boolean baa;
    private boolean bab;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public ae(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.aUF = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.aUG = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.aZY = null;
        this.aZZ = 0;
        this.aNf = null;
        this.ayZ = 0L;
        this.baa = false;
        this.bab = false;
        this.aNg = 0L;
        this.aNh = 0L;
        this.aNi = 0L;
        this.aNj = 0L;
        this.aZT = frsGoodActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        if (this.aNf != null) {
            this.aNf.destory();
        }
        this.aZV.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.aUF = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aUG = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.aUF)) {
            this.aUF = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.aZW = new com.baidu.tieba.tbadkCore.l();
        this.aUN = new com.baidu.tieba.tbadkCore.o();
        this.aZV = new com.baidu.tieba.frs.b.c<>(this.aZT.getPageContext(), this.aZW);
        this.aZV.a(this);
        this.aZV.setUniqueId(getUniqueId());
        if (this.aUF != null && this.aUF.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.aUF);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.aUG);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean bE(boolean z) {
        if (this.aZV.isLoading()) {
            return false;
        }
        com.baidu.tieba.tbadkCore.l lVar = (com.baidu.tieba.tbadkCore.l) com.baidu.tieba.tbadkCore.l.objectWithJson(com.baidu.tieba.tbadkCore.l.jsonWithObject(this.aZW), com.baidu.tieba.tbadkCore.l.class);
        lVar.setPn(1);
        a(lVar, 3);
        return true;
    }

    public void fF(int i) {
        if (!this.aZV.isLoading()) {
            com.baidu.tieba.tbadkCore.l lVar = (com.baidu.tieba.tbadkCore.l) com.baidu.tieba.tbadkCore.l.objectWithJson(com.baidu.tieba.tbadkCore.l.jsonWithObject(this.aZW), com.baidu.tieba.tbadkCore.l.class);
            lVar.setPn(i);
            a(lVar, 4);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.l lVar, int i) {
        this.aZT.aVj.fo(i);
        this.aZV.a(lVar);
        this.mType = i;
        lVar.setKw(this.aUF);
        if (com.baidu.tbadk.core.m.rb().rf()) {
            lVar.setRn(35);
        } else {
            lVar.setRn(50);
        }
        lVar.setWithGroup(1);
        lVar.setIsGood(1);
        lVar.setCid(this.aZZ);
        int K = com.baidu.adp.lib.util.k.K(this.aZT.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.aZT.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = ar.uK().uM() ? 2 : 1;
        lVar.setScrW(K);
        lVar.setScrH(L);
        lVar.setScrDip(f);
        lVar.setqType(i2);
        lVar.setLastId(this.aZY);
        if (this.mSource != null) {
            lVar.setStType(this.mSource);
        }
        if (FrsActivity.aUS != 0) {
            lVar.setCtime((int) FrsActivity.aUS);
        }
        if (FrsActivity.aUT != 0) {
            lVar.setDataSize((int) FrsActivity.aUT);
        }
        if (FrsActivity.aUU != 0) {
            lVar.setNetError(FrsActivity.aUU);
        }
        lVar.setUpdateType(this.mType);
        lVar.setNeedCache(false);
        if (this.aNf == null) {
            this.aNf = new com.baidu.tieba.tbadkCore.e.a("frsStat");
            this.aNf.start();
        }
        MT();
    }

    protected boolean a(com.baidu.tieba.tbadkCore.l lVar, com.baidu.tieba.tbadkCore.m mVar) {
        this.aUN.d(mVar);
        this.aZU = this.aUN.getThreadList();
        this.mPageType = "good_page";
        if (lVar != null) {
            this.aZW = lVar;
            this.mPn = this.aZW.getPn();
            this.aUF = this.aZW.getKw();
            this.aZT.gK(this.aUF);
            this.aZT.setFrom(this.mFrom);
            this.aZT.setPn(this.mPn);
            this.aZT.setFlag(this.aUG);
        }
        this.aZT.aVj.a(this.mType, false, this.aZX);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        com.baidu.tieba.tbadkCore.l lVar2;
        com.baidu.tieba.tbadkCore.l lVar3;
        e.a aVar = new e.a();
        aVar.cPd = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = !mvcSocketResponsedMessage.hasError();
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.cPe = mvcSocketResponsedMessage.getDownSize();
        this.aZX = aVar;
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
        MR();
        if (this.aNf != null) {
            this.aNf.a(false, aVar.isSuccess, aVar.errorCode, aVar.errorMsg, aVar.cPe);
            this.aNf = null;
        }
        if (!this.bab) {
            this.bab = true;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ey(1000);
            tVar.aze = false;
            tVar.isSuccess = aVar.isSuccess;
            tVar.ayT = mvcSocketResponsedMessage.performanceData.qw;
            tVar.ayU = mvcSocketResponsedMessage.performanceData.qx;
            tVar.ayV = mvcSocketResponsedMessage.performanceData.qy;
            tVar.ayW = mvcSocketResponsedMessage.performanceData.qz;
            tVar.ayX = mvcSocketResponsedMessage.performanceData.qA;
            tVar.azc = aVar.cPe;
            tVar.azd = 0L;
            if (this.aZT.aVj != null) {
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
        aVar.cPd = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = !mvcHttpResponsedMessage.hasError();
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.cPe = mvcHttpResponsedMessage.getDownSize();
        this.aZX = aVar;
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
        MR();
        if (this.aNf != null) {
            this.aNf.a(true, aVar.isSuccess, aVar.errorCode, aVar.errorMsg, aVar.cPe);
            this.aNf = null;
        }
        if (!this.bab) {
            this.bab = true;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ey(1000);
            tVar.aze = true;
            tVar.isSuccess = aVar.isSuccess;
            tVar.ayT = mvcHttpResponsedMessage.performanceData.qw;
            tVar.ayU = mvcHttpResponsedMessage.performanceData.qx;
            tVar.ayV = mvcHttpResponsedMessage.performanceData.qy;
            tVar.ayW = mvcHttpResponsedMessage.performanceData.qz;
            tVar.ayX = mvcHttpResponsedMessage.performanceData.qA;
            tVar.azc = 0L;
            tVar.azd = aVar.cPe;
            if (this.aZT.aVj != null) {
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

    public void MR() {
        if (!this.baa) {
            this.baa = true;
            this.ayZ = System.currentTimeMillis() - this.aZT.aUR;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ey(1000);
            tVar.ayS = this.aZT.createTime;
            tVar.ayZ = this.ayZ;
            tVar.Ei();
        }
    }

    public void e(com.baidu.tbadk.performanceLog.t tVar) {
        if (tVar != null) {
            tVar.ayS = this.aZT.createTime;
            this.aZT.createTime = 0L;
            tVar.ayY = this.aZT.ayY;
            tVar.ayZ = this.ayZ == 0 ? System.currentTimeMillis() - this.aZT.aUR : this.ayZ;
            tVar.Ej();
        }
    }

    public int getType() {
        return this.mType;
    }

    public com.baidu.tieba.tbadkCore.o MS() {
        return this.aUN;
    }

    private void MT() {
        this.aNg = System.currentTimeMillis();
        this.aZV.Df();
    }

    public long IB() {
        return this.aNj;
    }

    public long IC() {
        return this.aNh;
    }

    public long ID() {
        return this.aNi;
    }

    public long IE() {
        return this.aNg;
    }

    public boolean isLoading() {
        return this.aZV.isLoading();
    }

    public void fe(int i) {
        this.aZZ = i;
        bE(true);
    }

    public boolean MU() {
        return this.aZZ < 100;
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
