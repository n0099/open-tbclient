package com.baidu.tieba.frs.good;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.i;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes6.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.b<FrsRequestData, i> {
    private String dAf;
    private d.a dHw;
    private boolean dQS;
    private FrsGoodFragment dRh;
    private FrsNetModel<FrsGoodFragment> dRi;
    private FrsRequestData dRj;
    private String dRk;
    private int dRl;
    private long dhA;
    private long dhB;
    private long dhC;
    private long dhD;
    private l dzP;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.dAf = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.dRk = null;
        this.dRl = 0;
        this.dQS = false;
        this.dhA = 0L;
        this.dhB = 0L;
        this.dhC = 0L;
        this.dhD = 0L;
        this.dRh = frsGoodFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.dRi.cancelLoadData();
    }

    public void j(Bundle bundle) {
        if (bundle != null) {
            this.dAf = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dQS = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        }
        if (TextUtils.isEmpty(this.dAf)) {
            this.dAf = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.dRj = new FrsRequestData();
        this.dzP = new l();
        this.dRi = new FrsNetModel<>(this.dRh.getPageContext(), this.dRj);
        this.dRi.a(this);
        this.dRi.setUniqueId(getUniqueId());
        if (this.dAf != null && this.dAf.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dAf);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.dQS);
    }

    public boolean aCc() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dRj), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void mp(int i) {
        if (!this.dRi.DU()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dRj), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.dRh != null && this.dRh.isAdded() && this.dRh.getPageContext() != null) {
            this.dRh.dBu.lq(i);
            this.dRi.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.dAf);
            if (com.baidu.tbadk.core.i.ws().ww()) {
                frsRequestData.setRn(35);
            } else {
                frsRequestData.setRn(50);
            }
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.ur(this.dQS ? 1 : 0);
            if (this.dQS) {
                frsRequestData.setRn(50);
                frsRequestData.us(50);
                frsRequestData.setIsGood(0);
            }
            frsRequestData.setCid(this.dRl);
            int aO = com.baidu.adp.lib.util.l.aO(this.dRh.getPageContext().getPageActivity());
            int aQ = com.baidu.adp.lib.util.l.aQ(this.dRh.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = aq.CG().CI() ? 2 : 1;
            frsRequestData.setScrW(aO);
            frsRequestData.setScrH(aQ);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.dRk);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.dAp != 0) {
                frsRequestData.setCtime((int) FrsFragment.dAp);
            }
            if (FrsFragment.dAq != 0) {
                frsRequestData.setDataSize((int) FrsFragment.dAq);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.setNetError(FrsFragment.mNetError);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            aEF();
        }
    }

    private boolean a(FrsRequestData frsRequestData, i iVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.dRl) {
            this.dzP.e(iVar);
            this.dzP.hbH = this.dQS ? 303 : 301;
            if (frsRequestData != null) {
                this.dRj = frsRequestData;
                this.mPn = this.dRj.getPn();
                this.dAf = this.dRj.getKw();
                this.dRh.nY(this.dAf);
                this.dRh.setFrom(this.mFrom);
                this.dRh.setPn(this.mPn);
                this.dRh.setFlag(this.mFlag);
            }
            this.dRh.dBu.a(this.mType, false, this.dHw);
            this.mSource = null;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, i> mvcSocketMessage, MvcNetMessage<FrsRequestData, i> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            d.a aVar = new d.a();
            aVar.gZz = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            aVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            aVar.errorCode = mvcSocketResponsedMessage.getError();
            aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            aVar.gZA = mvcSocketResponsedMessage.getDownSize();
            this.dHw = aVar;
            FrsRequestData frsRequestData2 = null;
            i data = mvcSocketResponsedMessage.getData();
            if (mvcSocketMessage != null) {
                frsRequestData2 = mvcSocketMessage.getRequestData();
            }
            if (mvcNetMessage != null) {
                frsRequestData2 = mvcNetMessage.getRequestData();
            }
            a(frsRequestData2, data);
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
            long j = 0;
            if (mvcSocketMessage != null) {
                j = mvcSocketMessage.getClientLogID();
                frsRequestData = mvcSocketMessage.getRequestData();
            } else {
                frsRequestData = frsRequestData2;
            }
            if (mvcNetMessage != null) {
                j = mvcNetMessage.getLogID();
                frsRequestData = mvcNetMessage.getRequestData();
            }
            int error = mvcSocketResponsedMessage.getError();
            String errorString = mvcSocketResponsedMessage.getErrorString();
            int cmd = mvcSocketResponsedMessage.getCmd();
            Object[] objArr = new Object[4];
            objArr[0] = "kw";
            objArr[1] = frsRequestData != null ? frsRequestData.getKw() : null;
            objArr[2] = "seq_id";
            objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
            com.baidu.tbadk.core.d.a.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<i> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, i> mvcHttpMessage, MvcNetMessage<FrsRequestData, i> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcHttpResponsedMessage != null) {
            d.a aVar = new d.a();
            aVar.gZz = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            aVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            aVar.errorCode = mvcHttpResponsedMessage.getError();
            aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            aVar.gZA = mvcHttpResponsedMessage.getDownSize();
            this.dHw = aVar;
            FrsRequestData frsRequestData2 = null;
            i data = mvcHttpResponsedMessage.getData();
            if (mvcHttpMessage != null) {
                frsRequestData2 = mvcHttpMessage.getRequestData();
            }
            if (mvcNetMessage != null) {
                frsRequestData2 = mvcNetMessage.getRequestData();
            }
            a(frsRequestData2, data);
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
            long j = 0;
            if (mvcHttpMessage != null) {
                j = mvcHttpMessage.getClientLogID();
                frsRequestData = mvcHttpMessage.getRequestData();
            } else {
                frsRequestData = frsRequestData2;
            }
            if (mvcNetMessage != null) {
                j = mvcNetMessage.getLogID();
                frsRequestData = mvcNetMessage.getRequestData();
            }
            int error = mvcHttpResponsedMessage.getError();
            String errorString = mvcHttpResponsedMessage.getErrorString();
            int cmd = mvcHttpResponsedMessage.getCmd();
            Object[] objArr = new Object[2];
            objArr[0] = "kw";
            objArr[1] = frsRequestData != null ? frsRequestData.getKw() : null;
            com.baidu.tbadk.core.d.a.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
    }

    public void azO() {
        if (this.dzP != null && this.dzP.beT() != null && this.dzP.beT().getBannerListData() != null) {
            String lastIds = this.dzP.beT().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dRk = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public l aEE() {
        return this.dzP;
    }

    private void aEF() {
        this.dhA = System.currentTimeMillis();
        this.dRi.Nj();
    }

    public long aun() {
        return this.dhD;
    }

    public long auo() {
        return this.dhB;
    }

    public long aup() {
        return this.dhC;
    }

    public long auq() {
        return this.dhA;
    }

    public boolean DU() {
        return this.dRi.DU();
    }

    public void hQ(int i) {
        this.dRl = i;
        aCc();
    }

    public boolean aEG() {
        return this.dRl < 100;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
