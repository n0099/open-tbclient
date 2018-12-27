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
    private String dKJ;
    private l dKt;
    private long drY;
    private long drZ;
    private long dsa;
    private long dsb;
    private FrsGoodFragment ebG;
    private FrsNetModel<FrsGoodFragment> ebH;
    private FrsRequestData ebI;
    private d.a ebJ;
    private String ebK;
    private int ebL;
    private boolean ebq;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.dKJ = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.ebK = null;
        this.ebL = 0;
        this.ebq = false;
        this.drY = 0L;
        this.drZ = 0L;
        this.dsa = 0L;
        this.dsb = 0L;
        this.ebG = frsGoodFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.ebH.cancelLoadData();
    }

    public void p(Bundle bundle) {
        if (bundle != null) {
            this.dKJ = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.ebq = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        }
        if (TextUtils.isEmpty(this.dKJ)) {
            this.dKJ = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.ebI = new FrsRequestData();
        this.dKt = new l();
        this.ebH = new FrsNetModel<>(this.ebG.getPageContext(), this.ebI);
        this.ebH.a(this);
        this.ebH.setUniqueId(this.ebG.getUniqueId());
        if (this.dKJ != null && this.dKJ.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dKJ);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.ebq);
    }

    public boolean aGA() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.ebI), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void nk(int i) {
        if (!this.ebH.Fi()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.ebI), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.ebG != null && this.ebG.isAdded() && this.ebG.getPageContext() != null) {
            this.ebG.dLY.ml(i);
            this.ebH.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.dKJ);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.vt(this.ebq ? 1 : 0);
            if (this.ebq) {
                frsRequestData.setRn(50);
                frsRequestData.vu(50);
                frsRequestData.setIsGood(0);
            }
            frsRequestData.setCid(this.ebL);
            int aO = com.baidu.adp.lib.util.l.aO(this.ebG.getPageContext().getPageActivity());
            int aQ = com.baidu.adp.lib.util.l.aQ(this.ebG.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = aq.DR().DT() ? 2 : 1;
            frsRequestData.setScrW(aO);
            frsRequestData.setScrH(aQ);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.ebK);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.dKT != 0) {
                frsRequestData.setCtime((int) FrsFragment.dKT);
            }
            if (FrsFragment.dKU != 0) {
                frsRequestData.setDataSize((int) FrsFragment.dKU);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.setNetError(FrsFragment.mNetError);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            aGC();
        }
    }

    private boolean a(FrsRequestData frsRequestData, i iVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.ebL) {
            this.dKt.g(iVar);
            this.dKt.hnk = this.ebq ? 303 : 301;
            if (frsRequestData != null) {
                this.ebI = frsRequestData;
                this.mPn = this.ebI.getPn();
                this.dKJ = this.ebI.getKw();
                this.ebG.oD(this.dKJ);
                this.ebG.setFrom(this.mFrom);
                this.ebG.setPn(this.mPn);
                this.ebG.setFlag(this.mFlag);
            }
            this.ebG.dLY.a(this.mType, false, this.ebJ);
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
            aVar.hlc = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            aVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            aVar.errorCode = mvcSocketResponsedMessage.getError();
            aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            aVar.hld = mvcSocketResponsedMessage.getDownSize();
            this.ebJ = aVar;
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
            aVar.hlc = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            aVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            aVar.errorCode = mvcHttpResponsedMessage.getError();
            aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            aVar.hld = mvcHttpResponsedMessage.getDownSize();
            this.ebJ = aVar;
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

    public void aBL() {
        if (this.dKt != null && this.dKt.bgT() != null && this.dKt.bgT().getBannerListData() != null) {
            String lastIds = this.dKt.bgT().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.ebK = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public l aGB() {
        return this.dKt;
    }

    private void aGC() {
        this.drY = System.currentTimeMillis();
        this.ebH.Ox();
    }

    public long awm() {
        return this.dsb;
    }

    public long awn() {
        return this.drZ;
    }

    public long awo() {
        return this.dsa;
    }

    public long awp() {
        return this.drY;
    }

    public boolean Fi() {
        return this.ebH.Fi();
    }

    public void is(int i) {
        this.ebL = i;
        aGA();
    }

    public boolean aGD() {
        return this.ebL < 100;
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
