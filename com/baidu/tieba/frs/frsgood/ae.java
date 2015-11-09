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
    private com.baidu.tieba.tbadkCore.e.a aMt;
    private long aMu;
    private long aMv;
    private long aMw;
    private long aMx;
    private String aTU;
    private int aTV;
    private com.baidu.tieba.tbadkCore.o aUe;
    private long awo;
    private FrsGoodActivity baq;
    private ArrayList<com.baidu.adp.widget.ListView.u> bas;
    private com.baidu.tieba.frs.mc.c<FrsGoodActivity> bat;
    private com.baidu.tieba.tbadkCore.l bau;
    private e.a bav;
    private String baw;
    private int bax;
    private boolean bay;
    private boolean baz;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public ae(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.aTU = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.aTV = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.baw = null;
        this.bax = 0;
        this.aMt = null;
        this.awo = 0L;
        this.bay = false;
        this.baz = false;
        this.aMu = 0L;
        this.aMv = 0L;
        this.aMw = 0L;
        this.aMx = 0L;
        this.baq = frsGoodActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        if (this.aMt != null) {
            this.aMt.destory();
        }
        this.bat.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.aTU = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aTV = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.aTU)) {
            this.aTU = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.bau = new com.baidu.tieba.tbadkCore.l();
        this.aUe = new com.baidu.tieba.tbadkCore.o();
        this.bat = new com.baidu.tieba.frs.mc.c<>(this.baq.getPageContext(), this.bau);
        this.bat.a(this);
        this.bat.setUniqueId(getUniqueId());
        if (this.aTU != null && this.aTU.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.aTU);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.aTV);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean bD(boolean z) {
        if (this.bat.isLoading()) {
            return false;
        }
        com.baidu.tieba.tbadkCore.l lVar = (com.baidu.tieba.tbadkCore.l) com.baidu.tieba.tbadkCore.l.objectWithJson(com.baidu.tieba.tbadkCore.l.jsonWithObject(this.bau), com.baidu.tieba.tbadkCore.l.class);
        lVar.setPn(1);
        a(lVar, 3);
        return true;
    }

    public void fT(int i) {
        if (!this.bat.isLoading()) {
            com.baidu.tieba.tbadkCore.l lVar = (com.baidu.tieba.tbadkCore.l) com.baidu.tieba.tbadkCore.l.objectWithJson(com.baidu.tieba.tbadkCore.l.jsonWithObject(this.bau), com.baidu.tieba.tbadkCore.l.class);
            lVar.setPn(i);
            a(lVar, 4);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.l lVar, int i) {
        this.baq.aUC.fB(i);
        this.bat.a(lVar);
        this.mType = i;
        lVar.setKw(this.aTU);
        if (com.baidu.tbadk.core.m.qV().qZ()) {
            lVar.setRn(35);
        } else {
            lVar.setRn(50);
        }
        lVar.setWithGroup(1);
        lVar.setIsGood(1);
        lVar.setCid(this.bax);
        int K = com.baidu.adp.lib.util.k.K(this.baq.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.baq.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = at.uK().uM() ? 2 : 1;
        lVar.setScrW(K);
        lVar.setScrH(L);
        lVar.setScrDip(f);
        lVar.setqType(i2);
        lVar.setLastId(this.baw);
        if (this.mSource != null) {
            lVar.setStType(this.mSource);
        }
        if (FrsActivity.aUj != 0) {
            lVar.setCtime((int) FrsActivity.aUj);
        }
        if (FrsActivity.aUk != 0) {
            lVar.setDataSize((int) FrsActivity.aUk);
        }
        if (FrsActivity.aUl != 0) {
            lVar.setNetError(FrsActivity.aUl);
        }
        lVar.setUpdateType(this.mType);
        lVar.setNeedCache(false);
        if (this.aMt == null) {
            this.aMt = new com.baidu.tieba.tbadkCore.e.a("frsStat");
            this.aMt.start();
        }
        Ng();
    }

    protected boolean a(com.baidu.tieba.tbadkCore.l lVar, com.baidu.tieba.tbadkCore.m mVar) {
        this.aUe.d(mVar);
        this.bas = this.aUe.getThreadList();
        this.mPageType = "good_page";
        if (lVar != null) {
            this.bau = lVar;
            this.mPn = this.bau.getPn();
            this.aTU = this.bau.getKw();
            this.baq.gP(this.aTU);
            this.baq.setFrom(this.mFrom);
            this.baq.setPn(this.mPn);
            this.baq.setFlag(this.aTV);
        }
        this.baq.aUC.a(this.mType, false, this.bav);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        com.baidu.tieba.tbadkCore.l lVar2;
        com.baidu.tieba.tbadkCore.l lVar3;
        e.a aVar = new e.a();
        aVar.cYp = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = !mvcSocketResponsedMessage.hasError();
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.cYq = mvcSocketResponsedMessage.getDownSize();
        this.bav = aVar;
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
        Ne();
        if (this.aMt != null) {
            this.aMt.a(false, aVar.isSuccess, aVar.errorCode, aVar.errorMsg, aVar.cYq);
            this.aMt = null;
        }
        if (!this.baz) {
            this.baz = true;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ex(1000);
            tVar.awt = false;
            tVar.isSuccess = aVar.isSuccess;
            tVar.awi = mvcSocketResponsedMessage.performanceData.qw;
            tVar.awj = mvcSocketResponsedMessage.performanceData.qx;
            tVar.awk = mvcSocketResponsedMessage.performanceData.qy;
            tVar.awl = mvcSocketResponsedMessage.performanceData.qz;
            tVar.awm = mvcSocketResponsedMessage.performanceData.qA;
            tVar.awr = aVar.cYq;
            tVar.aws = 0L;
            if (this.baq.aUC != null) {
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
        aVar.cYp = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = !mvcHttpResponsedMessage.hasError();
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.cYq = mvcHttpResponsedMessage.getDownSize();
        this.bav = aVar;
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
        Ne();
        if (this.aMt != null) {
            this.aMt.a(true, aVar.isSuccess, aVar.errorCode, aVar.errorMsg, aVar.cYq);
            this.aMt = null;
        }
        if (!this.baz) {
            this.baz = true;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ex(1000);
            tVar.awt = true;
            tVar.isSuccess = aVar.isSuccess;
            tVar.awi = mvcHttpResponsedMessage.performanceData.qw;
            tVar.awj = mvcHttpResponsedMessage.performanceData.qx;
            tVar.awk = mvcHttpResponsedMessage.performanceData.qy;
            tVar.awl = mvcHttpResponsedMessage.performanceData.qz;
            tVar.awm = mvcHttpResponsedMessage.performanceData.qA;
            tVar.awr = 0L;
            tVar.aws = aVar.cYq;
            if (this.baq.aUC != null) {
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

    public void Ne() {
        if (!this.bay) {
            this.bay = true;
            this.awo = System.currentTimeMillis() - this.baq.aUi;
            com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
            tVar.ex(1000);
            tVar.awh = this.baq.createTime;
            tVar.awo = this.awo;
            tVar.DL();
        }
    }

    public void e(com.baidu.tbadk.performanceLog.t tVar) {
        if (tVar != null) {
            tVar.awh = this.baq.createTime;
            this.baq.createTime = 0L;
            tVar.awn = this.baq.awn;
            tVar.awo = this.awo == 0 ? System.currentTimeMillis() - this.baq.aUi : this.awo;
            tVar.DM();
        }
    }

    public int getType() {
        return this.mType;
    }

    public com.baidu.tieba.tbadkCore.o Nf() {
        return this.aUe;
    }

    private void Ng() {
        this.aMu = System.currentTimeMillis();
        this.bat.CI();
    }

    public long IJ() {
        return this.aMx;
    }

    public long IK() {
        return this.aMv;
    }

    public long IL() {
        return this.aMw;
    }

    public long IM() {
        return this.aMu;
    }

    public boolean isLoading() {
        return this.bat.isLoading();
    }

    public void fr(int i) {
        this.bax = i;
        bD(true);
    }

    public boolean Nh() {
        return this.bax < 100;
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
