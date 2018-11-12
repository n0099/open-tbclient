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
    private l dBg;
    private String dBw;
    private boolean dRX;
    private FrsGoodFragment dSn;
    private FrsNetModel<FrsGoodFragment> dSo;
    private FrsRequestData dSp;
    private d.a dSq;
    private String dSr;
    private int dSs;
    private long diF;
    private long diG;
    private long diH;
    private long diI;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.dBw = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.dSr = null;
        this.dSs = 0;
        this.dRX = false;
        this.diF = 0L;
        this.diG = 0L;
        this.diH = 0L;
        this.diI = 0L;
        this.dSn = frsGoodFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.dSo.cancelLoadData();
    }

    public void m(Bundle bundle) {
        if (bundle != null) {
            this.dBw = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dRX = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        }
        if (TextUtils.isEmpty(this.dBw)) {
            this.dBw = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.dSp = new FrsRequestData();
        this.dBg = new l();
        this.dSo = new FrsNetModel<>(this.dSn.getPageContext(), this.dSp);
        this.dSo.a(this);
        this.dSo.setUniqueId(getUniqueId());
        if (this.dBw != null && this.dBw.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dBw);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.dRX);
    }

    public boolean aDZ() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dSp), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void mH(int i) {
        if (!this.dSo.Ee()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dSp), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.dSn != null && this.dSn.isAdded() && this.dSn.getPageContext() != null) {
            this.dSn.dCL.lI(i);
            this.dSo.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.dBw);
            if (com.baidu.tbadk.core.i.wA().wE()) {
                frsRequestData.setRn(35);
            } else {
                frsRequestData.setRn(50);
            }
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.uK(this.dRX ? 1 : 0);
            if (this.dRX) {
                frsRequestData.setRn(50);
                frsRequestData.uL(50);
                frsRequestData.setIsGood(0);
            }
            frsRequestData.setCid(this.dSs);
            int aO = com.baidu.adp.lib.util.l.aO(this.dSn.getPageContext().getPageActivity());
            int aQ = com.baidu.adp.lib.util.l.aQ(this.dSn.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = aq.CN().CP() ? 2 : 1;
            frsRequestData.setScrW(aO);
            frsRequestData.setScrH(aQ);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.dSr);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.dBG != 0) {
                frsRequestData.setCtime((int) FrsFragment.dBG);
            }
            if (FrsFragment.dBH != 0) {
                frsRequestData.setDataSize((int) FrsFragment.dBH);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.setNetError(FrsFragment.mNetError);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            aEb();
        }
    }

    private boolean a(FrsRequestData frsRequestData, i iVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.dSs) {
            this.dBg.g(iVar);
            this.dBg.hdf = this.dRX ? 303 : 301;
            if (frsRequestData != null) {
                this.dSp = frsRequestData;
                this.mPn = this.dSp.getPn();
                this.dBw = this.dSp.getKw();
                this.dSn.nZ(this.dBw);
                this.dSn.setFrom(this.mFrom);
                this.dSn.setPn(this.mPn);
                this.dSn.setFlag(this.mFlag);
            }
            this.dSn.dCL.a(this.mType, false, this.dSq);
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
            aVar.haY = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            aVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            aVar.errorCode = mvcSocketResponsedMessage.getError();
            aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            aVar.haZ = mvcSocketResponsedMessage.getDownSize();
            this.dSq = aVar;
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
            aVar.haY = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            aVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            aVar.errorCode = mvcHttpResponsedMessage.getError();
            aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            aVar.haZ = mvcHttpResponsedMessage.getDownSize();
            this.dSq = aVar;
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

    public void azm() {
        if (this.dBg != null && this.dBg.ber() != null && this.dBg.ber().getBannerListData() != null) {
            String lastIds = this.dBg.ber().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dSr = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public l aEa() {
        return this.dBg;
    }

    private void aEb() {
        this.diF = System.currentTimeMillis();
        this.dSo.Ns();
    }

    public long atM() {
        return this.diI;
    }

    public long atN() {
        return this.diG;
    }

    public long atO() {
        return this.diH;
    }

    public long atP() {
        return this.diF;
    }

    public boolean Ee() {
        return this.dSo.Ee();
    }

    public void id(int i) {
        this.dSs = i;
        aDZ();
    }

    public boolean aEc() {
        return this.dSs < 100;
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
