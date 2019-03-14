package com.baidu.tieba.frs.good;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ar;
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
import com.baidu.tieba.tbadkCore.j;
/* loaded from: classes4.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.b<FrsRequestData, j> {
    private long eDP;
    private long eDQ;
    private long eDR;
    private long eDS;
    private String eYK;
    private FrsViewData eYv;
    private FrsGoodFragment fpT;
    private FrsNetModel<FrsGoodFragment> fpU;
    private FrsRequestData fpV;
    private e.b fpW;
    private String fpX;
    private int fpY;
    private boolean fpz;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.eYK = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.fpX = null;
        this.fpY = 0;
        this.fpz = false;
        this.eDP = 0L;
        this.eDQ = 0L;
        this.eDR = 0L;
        this.eDS = 0L;
        this.fpT = frsGoodFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.fpU.cancelLoadData();
    }

    public void J(Bundle bundle) {
        if (bundle != null) {
            this.eYK = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fpz = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        }
        if (TextUtils.isEmpty(this.eYK)) {
            this.eYK = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.fpV = new FrsRequestData();
        this.eYv = new FrsViewData();
        this.fpV.dU("forum_name", k.bx(this.eYK));
        this.fpV.dU("client_type", "2");
        this.fpU = new FrsNetModel<>(this.fpT.getPageContext(), this.fpV);
        this.fpU.a(this);
        this.fpU.setUniqueId(this.fpT.getUniqueId());
        if (this.eYK != null && this.eYK.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.eYK);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.fpz);
    }

    public boolean bhn() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fpV), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void qZ(int i) {
        if (!this.fpU.qz()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fpV), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.fpT != null && this.fpT.isAdded() && this.fpT.getPageContext() != null) {
            this.fpT.fai.pX(i);
            this.fpU.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.eYK);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.zm(this.fpz ? 1 : 0);
            if (this.fpz) {
                frsRequestData.setRn(50);
                frsRequestData.zn(50);
                frsRequestData.setIsGood(0);
            }
            frsRequestData.setCid(this.fpY);
            int aO = l.aO(this.fpT.getPageContext().getPageActivity());
            int aQ = l.aQ(this.fpT.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ar.adp().adr() ? 2 : 1;
            frsRequestData.setScrW(aO);
            frsRequestData.setScrH(aQ);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.fpX);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.eYY != 0) {
                frsRequestData.setCtime((int) FrsFragment.eYY);
            }
            if (FrsFragment.eYZ != 0) {
                frsRequestData.setDataSize((int) FrsFragment.eYZ);
            }
            if (FrsFragment.eZa != 0) {
                frsRequestData.setNetError(FrsFragment.eZa);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            bhp();
        }
    }

    private boolean a(FrsRequestData frsRequestData, j jVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.fpY) {
            this.eYv.receiveData(jVar);
            this.eYv.frsCurrentTabId = this.fpz ? 303 : 301;
            if (frsRequestData != null) {
                this.fpV = frsRequestData;
                this.mPn = this.fpV.getPn();
                this.eYK = this.fpV.getKw();
                this.fpT.vw(this.eYK);
                this.fpT.setFrom(this.mFrom);
                this.fpT.setPn(this.mPn);
                this.fpT.setFlag(this.mFlag);
            }
            this.eYv.switchThreadDataToThreadCardInfo();
            this.fpT.fai.a(this.mType, false, this.fpW);
            this.mSource = null;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, j> mvcSocketMessage, MvcNetMessage<FrsRequestData, j> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            e.b bVar = new e.b();
            bVar.iDQ = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.iDR = mvcSocketResponsedMessage.getDownSize();
            this.fpW = bVar;
            FrsRequestData frsRequestData2 = null;
            j data = mvcSocketResponsedMessage.getData();
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
    public void a(MvcHttpResponsedMessage<j> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, j> mvcHttpMessage, MvcNetMessage<FrsRequestData, j> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcHttpResponsedMessage != null) {
            e.b bVar = new e.b();
            bVar.iDQ = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.iDR = mvcHttpResponsedMessage.getDownSize();
            this.fpW = bVar;
            FrsRequestData frsRequestData2 = null;
            j data = mvcHttpResponsedMessage.getData();
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

    public void bcL() {
        if (this.eYv != null && this.eYv.getForum() != null && this.eYv.getForum().getBannerListData() != null) {
            String lastIds = this.eYv.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fpX = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData bho() {
        return this.eYv;
    }

    private void bhp() {
        this.eDP = System.currentTimeMillis();
        this.fpU.aou();
    }

    public long aWR() {
        return this.eDS;
    }

    public long aWS() {
        return this.eDQ;
    }

    public long aWT() {
        return this.eDR;
    }

    public long aWU() {
        return this.eDP;
    }

    public boolean qz() {
        return this.fpU.qz();
    }

    public void mf(int i) {
        this.fpY = i;
        bhn();
    }

    public boolean bhq() {
        return this.fpY < 100;
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
