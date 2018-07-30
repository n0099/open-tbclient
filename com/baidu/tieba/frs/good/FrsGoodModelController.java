package com.baidu.tieba.frs.good;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
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
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.i;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes2.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.b<FrsRequestData, i> {
    private long cTA;
    private long cTB;
    private long cTy;
    private long cTz;
    private String dCA;
    private int dCB;
    private boolean dCi;
    private FrsGoodFragment dCx;
    private FrsNetModel<FrsGoodFragment> dCy;
    private FrsRequestData dCz;
    private l dlS;
    private String dmi;
    private d.a dsT;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.dmi = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.dCA = null;
        this.dCB = 0;
        this.dCi = false;
        this.cTy = 0L;
        this.cTz = 0L;
        this.cTA = 0L;
        this.cTB = 0L;
        this.dCx = frsGoodFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.dCy.cancelLoadData();
    }

    public void i(Bundle bundle) {
        if (bundle != null) {
            this.dmi = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dCi = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        }
        if (TextUtils.isEmpty(this.dmi)) {
            this.dmi = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.dCz = new FrsRequestData();
        this.dlS = new l();
        this.dCy = new FrsNetModel<>(this.dCx.getPageContext(), this.dCz);
        this.dCy.a(this);
        this.dCy.setUniqueId(getUniqueId());
        if (this.dmi != null && this.dmi.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dmi);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.dCi);
    }

    public boolean aww() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dCz), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void lp(int i) {
        if (!this.dCy.AE()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dCz), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.dCx != null && this.dCx.isAdded() && this.dCx.getPageContext() != null) {
            this.dCx.dnx.ku(i);
            this.dCy.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.dmi);
            if (com.baidu.tbadk.core.i.te().tk()) {
                frsRequestData.setRn(35);
            } else {
                frsRequestData.setRn(50);
            }
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.tu(this.dCi ? 1 : 0);
            if (this.dCi) {
                frsRequestData.setRn(50);
                frsRequestData.tv(50);
                frsRequestData.setIsGood(0);
            }
            frsRequestData.setCid(this.dCB);
            int ah = com.baidu.adp.lib.util.l.ah(this.dCx.getPageContext().getPageActivity());
            int aj = com.baidu.adp.lib.util.l.aj(this.dCx.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ar.zw().zy() ? 2 : 1;
            frsRequestData.setScrW(ah);
            frsRequestData.setScrH(aj);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.dCA);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.dms != 0) {
                frsRequestData.setCtime((int) FrsFragment.dms);
            }
            if (FrsFragment.dmt != 0) {
                frsRequestData.setDataSize((int) FrsFragment.dmt);
            }
            if (FrsFragment.dmu != 0) {
                frsRequestData.setNetError(FrsFragment.dmu);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            azg();
        }
    }

    private boolean a(FrsRequestData frsRequestData, i iVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.dCB) {
            this.dlS.e(iVar);
            this.dlS.gMG = this.dCi ? 303 : 301;
            if (frsRequestData != null) {
                this.dCz = frsRequestData;
                this.mPn = this.dCz.getPn();
                this.dmi = this.dCz.getKw();
                this.dCx.mR(this.dmi);
                this.dCx.setFrom(this.mFrom);
                this.dCx.setPn(this.mPn);
                this.dCx.setFlag(this.mFlag);
            }
            this.dCx.dnx.a(this.mType, false, this.dsT);
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
            aVar.gKB = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            aVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            aVar.errorCode = mvcSocketResponsedMessage.getError();
            aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            aVar.gKC = mvcSocketResponsedMessage.getDownSize();
            this.dsT = aVar;
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
            aVar.gKB = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            aVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            aVar.errorCode = mvcHttpResponsedMessage.getError();
            aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            aVar.gKC = mvcHttpResponsedMessage.getDownSize();
            this.dsT = aVar;
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

    public void auA() {
        if (this.dlS != null && this.dlS.aZl() != null && this.dlS.aZl().getBannerListData() != null) {
            String lastIds = this.dlS.aZl().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dCA = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public l azf() {
        return this.dlS;
    }

    private void azg() {
        this.cTy = System.currentTimeMillis();
        this.dCy.JR();
    }

    public long apc() {
        return this.cTB;
    }

    public long apd() {
        return this.cTz;
    }

    public long ape() {
        return this.cTA;
    }

    public long apf() {
        return this.cTy;
    }

    public boolean AE() {
        return this.dCy.AE();
    }

    public void gT(int i) {
        this.dCB = i;
        aww();
    }

    public boolean azh() {
        return this.dCB < 100;
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
