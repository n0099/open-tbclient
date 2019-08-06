package com.baidu.tieba.frs.good;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes4.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.b<FrsRequestData, l> {
    private long eYL;
    private long eYM;
    private long eYN;
    private long eYO;
    private FrsGoodFragment fLP;
    private FrsNetModel<FrsGoodFragment> fLQ;
    private FrsRequestData fLR;
    private e.b fLS;
    private String fLT;
    private int fLU;
    private boolean fLu;
    private FrsViewData ftR;
    private String fug;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.fug = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.fLT = null;
        this.fLU = 0;
        this.fLu = false;
        this.eYL = 0L;
        this.eYM = 0L;
        this.eYN = 0L;
        this.eYO = 0L;
        this.fLP = frsGoodFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aFQ() {
        this.fLQ.cancelLoadData();
    }

    public void K(Bundle bundle) {
        if (bundle != null) {
            this.fug = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fLu = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        }
        if (TextUtils.isEmpty(this.fug)) {
            this.fug = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.fLR = new FrsRequestData();
        this.ftR = new FrsViewData();
        this.fLR.ek("forum_name", k.bi(this.fug));
        this.fLR.ek("client_type", "2");
        this.fLQ = new FrsNetModel<>(this.fLP.getPageContext(), this.fLR);
        this.fLQ.a(this);
        this.fLQ.setUniqueId(this.fLP.getUniqueId());
        if (this.fug != null && this.fug.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.fug);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.fLu);
    }

    public boolean bqW() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fLR), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void sx(int i) {
        if (!this.fLQ.pP()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fLR), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.fLP != null && this.fLP.isAdded() && this.fLP.getPageContext() != null) {
            this.fLP.fvH.ru(i);
            this.fLQ.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.fug);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.AY(this.fLu ? 1 : 0);
            if (this.fLu) {
                frsRequestData.setRn(50);
                frsRequestData.AZ(50);
                frsRequestData.setIsGood(0);
            }
            frsRequestData.setCid(this.fLU);
            int af = com.baidu.adp.lib.util.l.af(this.fLP.getPageContext().getPageActivity());
            int ah = com.baidu.adp.lib.util.l.ah(this.fLP.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = as.ajq().ajs() ? 2 : 1;
            frsRequestData.setScrW(af);
            frsRequestData.setScrH(ah);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.fLT);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.fuu != 0) {
                frsRequestData.setCtime((int) FrsFragment.fuu);
            }
            if (FrsFragment.fuv != 0) {
                frsRequestData.setDataSize((int) FrsFragment.fuv);
            }
            if (FrsFragment.fuw != 0) {
                frsRequestData.setNetError(FrsFragment.fuw);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            bqY();
        }
    }

    private boolean a(FrsRequestData frsRequestData, l lVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.fLU) {
            this.ftR.receiveData(lVar);
            this.ftR.frsCurrentTabId = this.fLu ? 303 : 301;
            if (frsRequestData != null) {
                this.fLR = frsRequestData;
                this.mPn = this.fLR.getPn();
                this.fug = this.fLR.getKw();
                this.fLP.xt(this.fug);
                this.fLP.setFrom(this.mFrom);
                this.fLP.setPn(this.mPn);
                this.fLP.setFlag(this.mFlag);
            }
            this.fLP.fvH.a(this.mType, false, this.fLS);
            this.mSource = null;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, l> mvcSocketMessage, MvcNetMessage<FrsRequestData, l> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            e.b bVar = new e.b();
            bVar.fcf = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.jdR = mvcSocketResponsedMessage.getDownSize();
            this.fLS = bVar;
            FrsRequestData frsRequestData2 = null;
            l data = mvcSocketResponsedMessage.getData();
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
            com.baidu.tbadk.core.e.a.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<l> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, l> mvcHttpMessage, MvcNetMessage<FrsRequestData, l> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcHttpResponsedMessage != null) {
            e.b bVar = new e.b();
            bVar.fcf = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.jdR = mvcHttpResponsedMessage.getDownSize();
            this.fLS = bVar;
            FrsRequestData frsRequestData2 = null;
            l data = mvcHttpResponsedMessage.getData();
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
            com.baidu.tbadk.core.e.a.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
    }

    public void bms() {
        if (this.ftR != null && this.ftR.getForum() != null && this.ftR.getForum().getBannerListData() != null) {
            String lastIds = this.ftR.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fLT = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData bqX() {
        return this.ftR;
    }

    private void bqY() {
        this.eYL = System.currentTimeMillis();
        this.fLQ.auF();
    }

    public long bgm() {
        return this.eYO;
    }

    public long bgn() {
        return this.eYM;
    }

    public long bgo() {
        return this.eYN;
    }

    public long bgp() {
        return this.eYL;
    }

    public boolean pP() {
        return this.fLQ.pP();
    }

    public void nd(int i) {
        this.fLU = i;
        bqW();
    }

    public boolean bqZ() {
        return this.fLU < 100;
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
