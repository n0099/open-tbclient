package com.baidu.tieba.frs.frsgood;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.az;
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
    private long aBC;
    private String adH;
    private long bbP;
    private long bbQ;
    private long bbR;
    private long bbS;
    private String bkf;
    private int bkg;
    private com.baidu.tieba.tbadkCore.o bkq;
    private int bsA;
    private boolean bsB;
    private boolean bsC;
    private FrsGoodActivity bsu;
    private ArrayList<com.baidu.adp.widget.ListView.u> bsv;
    private com.baidu.tieba.frs.mc.c<FrsGoodActivity> bsw;
    private com.baidu.tieba.tbadkCore.l bsx;
    private d.a bsy;
    private String bsz;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public af(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.bkf = null;
        this.mType = 3;
        this.mPn = 1;
        this.adH = null;
        this.bkg = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.bsz = null;
        this.bsA = 0;
        this.aBC = 0L;
        this.bsB = false;
        this.bsC = false;
        this.bbP = 0L;
        this.bbQ = 0L;
        this.bbR = 0L;
        this.bbS = 0L;
        this.bsu = frsGoodActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.bsw.cancelLoadData();
    }

    public void c(Bundle bundle) {
        if (bundle != null) {
            this.bkf = bundle.getString("name");
            this.adH = bundle.getString("from");
            this.bkg = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.bkf)) {
            this.bkf = "";
        }
        if (TextUtils.isEmpty(this.adH)) {
            this.adH = "";
        }
        this.mSource = this.adH;
        this.bsx = new com.baidu.tieba.tbadkCore.l();
        this.bkq = new com.baidu.tieba.tbadkCore.o();
        this.bsw = new com.baidu.tieba.frs.mc.c<>(this.bsu.getPageContext(), this.bsx);
        this.bsw.a(this);
        this.bsw.setUniqueId(getUniqueId());
        if (this.bkf != null && this.bkf.length() > 0) {
            if (this.adH == null || this.adH.length() <= 0) {
                this.adH = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.bkf);
        bundle.putString("from", this.adH);
        bundle.putInt(FrsActivityConfig.FLAG, this.bkg);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean ce(boolean z) {
        if (this.bsw.isLoading()) {
            return false;
        }
        com.baidu.tieba.tbadkCore.l lVar = (com.baidu.tieba.tbadkCore.l) com.baidu.tieba.tbadkCore.l.objectWithJson(com.baidu.tieba.tbadkCore.l.jsonWithObject(this.bsx), com.baidu.tieba.tbadkCore.l.class);
        lVar.setPn(1);
        a(lVar, 3);
        return true;
    }

    public void gW(int i) {
        if (!this.bsw.isLoading()) {
            com.baidu.tieba.tbadkCore.l lVar = (com.baidu.tieba.tbadkCore.l) com.baidu.tieba.tbadkCore.l.objectWithJson(com.baidu.tieba.tbadkCore.l.jsonWithObject(this.bsx), com.baidu.tieba.tbadkCore.l.class);
            lVar.setPn(i);
            a(lVar, 4);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.l lVar, int i) {
        this.bsu.bkP.gG(i);
        this.bsw.a(lVar);
        this.mType = i;
        lVar.setKw(this.bkf);
        if (com.baidu.tbadk.core.l.qE().qK()) {
            lVar.setRn(35);
        } else {
            lVar.setRn(50);
        }
        lVar.setWithGroup(1);
        lVar.setIsGood(1);
        lVar.setCid(this.bsA);
        int B = com.baidu.adp.lib.util.k.B(this.bsu.getPageContext().getPageActivity());
        int C = com.baidu.adp.lib.util.k.C(this.bsu.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = az.wz().wB() ? 2 : 1;
        lVar.setScrW(B);
        lVar.setScrH(C);
        lVar.setScrDip(f);
        lVar.setqType(i2);
        lVar.setLastId(this.bsz);
        if (this.mSource != null) {
            lVar.setStType(this.mSource);
        }
        if (FrsActivity.bku != 0) {
            lVar.setCtime((int) FrsActivity.bku);
        }
        if (FrsActivity.bkv != 0) {
            lVar.setDataSize((int) FrsActivity.bkv);
        }
        if (FrsActivity.bkw != 0) {
            lVar.setNetError(FrsActivity.bkw);
        }
        lVar.setUpdateType(this.mType);
        lVar.setNeedCache(false);
        SQ();
    }

    protected boolean a(com.baidu.tieba.tbadkCore.l lVar, com.baidu.tieba.tbadkCore.m mVar) {
        this.bkq.d(mVar);
        this.bsv = this.bkq.getThreadList();
        this.mPageType = "good_page";
        if (lVar != null) {
            this.bsx = lVar;
            this.mPn = this.bsx.getPn();
            this.bkf = this.bsx.getKw();
            this.bsu.hI(this.bkf);
            this.bsu.setFrom(this.adH);
            this.bsu.setPn(this.mPn);
            this.bsu.setFlag(this.bkg);
        }
        this.bsu.bkP.a(this.mType, false, this.bsy);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        long j;
        com.baidu.tieba.tbadkCore.l lVar2;
        d.a aVar = new d.a();
        aVar.emO = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = !mvcSocketResponsedMessage.hasError();
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.emP = mvcSocketResponsedMessage.getDownSize();
        this.bsy = aVar;
        com.baidu.tieba.tbadkCore.l lVar3 = null;
        com.baidu.tieba.tbadkCore.m mVar = null;
        if (mvcSocketResponsedMessage != null) {
            mVar = mvcSocketResponsedMessage.getData();
            if (mvcSocketMessage != null) {
                lVar3 = mvcSocketMessage.getRequestData();
            }
            if (mvcNetMessage != null) {
                lVar3 = mvcNetMessage.getRequestData();
            }
        }
        a(lVar3, mVar);
        if (mvcSocketResponsedMessage != null) {
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
        }
        if (mvcSocketMessage == null) {
            lVar = lVar3;
            j = 0;
        } else {
            j = mvcSocketMessage.getClientLogID();
            lVar = mvcSocketMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            lVar2 = mvcNetMessage.getRequestData();
        } else {
            lVar2 = lVar;
        }
        int error = mvcSocketResponsedMessage.getError();
        String errorString = mvcSocketResponsedMessage.getErrorString();
        int cmd = mvcSocketResponsedMessage.getCmd();
        Object[] objArr = new Object[4];
        objArr[0] = "kw";
        objArr[1] = lVar2 != null ? lVar2.getKw() : null;
        objArr[2] = "seq_id";
        objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
        com.baidu.tbadk.core.log.b.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcHttpMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        long j;
        com.baidu.tieba.tbadkCore.l lVar2;
        d.a aVar = new d.a();
        aVar.emO = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = !mvcHttpResponsedMessage.hasError();
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.emP = mvcHttpResponsedMessage.getDownSize();
        this.bsy = aVar;
        com.baidu.tieba.tbadkCore.l lVar3 = null;
        com.baidu.tieba.tbadkCore.m mVar = null;
        if (mvcHttpResponsedMessage != null) {
            mVar = mvcHttpResponsedMessage.getData();
            if (mvcHttpMessage != null) {
                lVar3 = mvcHttpMessage.getRequestData();
            }
            if (mvcNetMessage != null) {
                lVar3 = mvcNetMessage.getRequestData();
            }
        }
        a(lVar3, mVar);
        if (mvcHttpResponsedMessage != null) {
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
        }
        if (mvcHttpMessage == null) {
            lVar = lVar3;
            j = 0;
        } else {
            j = mvcHttpMessage.getClientLogID();
            lVar = mvcHttpMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            lVar2 = mvcNetMessage.getRequestData();
        } else {
            lVar2 = lVar;
        }
        int error = mvcHttpResponsedMessage.getError();
        String errorString = mvcHttpResponsedMessage.getErrorString();
        int cmd = mvcHttpResponsedMessage.getCmd();
        Object[] objArr = new Object[2];
        objArr[0] = "kw";
        objArr[1] = lVar2 != null ? lVar2.getKw() : null;
        com.baidu.tbadk.core.log.b.a("frs", j, cmd, "http_resp", error, errorString, objArr);
    }

    public int getType() {
        return this.mType;
    }

    public com.baidu.tieba.tbadkCore.o SP() {
        return this.bkq;
    }

    private void SQ() {
        this.bbP = System.currentTimeMillis();
        this.bsw.FG();
    }

    public long NZ() {
        return this.bbS;
    }

    public long Oa() {
        return this.bbQ;
    }

    public long Ob() {
        return this.bbR;
    }

    public long Oc() {
        return this.bbP;
    }

    public boolean isLoading() {
        return this.bsw.isLoading();
    }

    public void gv(int i) {
        this.bsA = i;
        ce(true);
    }

    public boolean SR() {
        return this.bsA < 100;
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
