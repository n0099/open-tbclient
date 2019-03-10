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
    private long eDT;
    private long eDU;
    private long eDV;
    private long eDW;
    private String eYL;
    private FrsViewData eYw;
    private boolean fpA;
    private FrsGoodFragment fpU;
    private FrsNetModel<FrsGoodFragment> fpV;
    private FrsRequestData fpW;
    private e.b fpX;
    private String fpY;
    private int fpZ;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.eYL = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.fpY = null;
        this.fpZ = 0;
        this.fpA = false;
        this.eDT = 0L;
        this.eDU = 0L;
        this.eDV = 0L;
        this.eDW = 0L;
        this.fpU = frsGoodFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.fpV.cancelLoadData();
    }

    public void J(Bundle bundle) {
        if (bundle != null) {
            this.eYL = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fpA = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        }
        if (TextUtils.isEmpty(this.eYL)) {
            this.eYL = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.fpW = new FrsRequestData();
        this.eYw = new FrsViewData();
        this.fpW.dV("forum_name", k.bx(this.eYL));
        this.fpW.dV("client_type", "2");
        this.fpV = new FrsNetModel<>(this.fpU.getPageContext(), this.fpW);
        this.fpV.a(this);
        this.fpV.setUniqueId(this.fpU.getUniqueId());
        if (this.eYL != null && this.eYL.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.eYL);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.fpA);
    }

    public boolean bho() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fpW), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void qZ(int i) {
        if (!this.fpV.qz()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fpW), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.fpU != null && this.fpU.isAdded() && this.fpU.getPageContext() != null) {
            this.fpU.faj.pX(i);
            this.fpV.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.eYL);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.zm(this.fpA ? 1 : 0);
            if (this.fpA) {
                frsRequestData.setRn(50);
                frsRequestData.zn(50);
                frsRequestData.setIsGood(0);
            }
            frsRequestData.setCid(this.fpZ);
            int aO = l.aO(this.fpU.getPageContext().getPageActivity());
            int aQ = l.aQ(this.fpU.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ar.adp().adr() ? 2 : 1;
            frsRequestData.setScrW(aO);
            frsRequestData.setScrH(aQ);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.fpY);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.eYZ != 0) {
                frsRequestData.setCtime((int) FrsFragment.eYZ);
            }
            if (FrsFragment.eZa != 0) {
                frsRequestData.setDataSize((int) FrsFragment.eZa);
            }
            if (FrsFragment.eZb != 0) {
                frsRequestData.setNetError(FrsFragment.eZb);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            bhq();
        }
    }

    private boolean a(FrsRequestData frsRequestData, j jVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.fpZ) {
            this.eYw.receiveData(jVar);
            this.eYw.frsCurrentTabId = this.fpA ? 303 : 301;
            if (frsRequestData != null) {
                this.fpW = frsRequestData;
                this.mPn = this.fpW.getPn();
                this.eYL = this.fpW.getKw();
                this.fpU.vy(this.eYL);
                this.fpU.setFrom(this.mFrom);
                this.fpU.setPn(this.mPn);
                this.fpU.setFlag(this.mFlag);
            }
            this.eYw.switchThreadDataToThreadCardInfo();
            this.fpU.faj.a(this.mType, false, this.fpX);
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
            bVar.iDY = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.iDZ = mvcSocketResponsedMessage.getDownSize();
            this.fpX = bVar;
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
            bVar.iDY = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.iDZ = mvcHttpResponsedMessage.getDownSize();
            this.fpX = bVar;
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

    public void bcM() {
        if (this.eYw != null && this.eYw.getForum() != null && this.eYw.getForum().getBannerListData() != null) {
            String lastIds = this.eYw.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fpY = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData bhp() {
        return this.eYw;
    }

    private void bhq() {
        this.eDT = System.currentTimeMillis();
        this.fpV.aov();
    }

    public long aWS() {
        return this.eDW;
    }

    public long aWT() {
        return this.eDU;
    }

    public long aWU() {
        return this.eDV;
    }

    public long aWV() {
        return this.eDT;
    }

    public boolean qz() {
        return this.fpV.qz();
    }

    public void mf(int i) {
        this.fpZ = i;
        bho();
    }

    public boolean bhr() {
        return this.fpZ < 100;
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
