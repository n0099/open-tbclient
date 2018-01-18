package com.baidu.tieba.frs.good;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.i;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes2.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.b<FrsRequestData, i> {
    private l dAN;
    private String dBb;
    private b dOE;
    private FrsNetModel<b> dOF;
    private FrsRequestData dOG;
    private d.a dOH;
    private String dOI;
    private int dOJ;
    private long dmT;
    private long dmU;
    private long dmV;
    private long dmW;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(b bVar) {
        super(bVar.getPageContext());
        this.dBb = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.dOI = null;
        this.dOJ = 0;
        this.dmT = 0L;
        this.dmU = 0L;
        this.dmV = 0L;
        this.dmW = 0L;
        this.dOE = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.dOF.cancelLoadData();
    }

    public void k(Bundle bundle) {
        if (bundle != null) {
            this.dBb = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.dBb)) {
            this.dBb = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.dOG = new FrsRequestData();
        this.dAN = new l();
        this.dOF = new FrsNetModel<>(this.dOE.getPageContext(), this.dOG);
        this.dOF.a(this);
        this.dOF.setUniqueId(getUniqueId());
        if (this.dBb != null && this.dBb.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dBb);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean eP(boolean z) {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dOG), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void nE(int i) {
        if (!this.dOF.DP()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dOG), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.dOE != null && this.dOE.isAdded() && this.dOE.getPageContext() != null) {
            this.dOE.dCe.mT(i);
            this.dOF.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.dBb);
            if (com.baidu.tbadk.core.i.wA().wG()) {
                frsRequestData.setRn(35);
            } else {
                frsRequestData.setRn(50);
            }
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.setCid(this.dOJ);
            int ao = com.baidu.adp.lib.util.l.ao(this.dOE.getPageContext().getPageActivity());
            int aq = com.baidu.adp.lib.util.l.aq(this.dOE.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = an.CJ().CL() ? 2 : 1;
            frsRequestData.setScrW(ao);
            frsRequestData.setScrH(aq);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.dOI);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (com.baidu.tieba.frs.i.dBj != 0) {
                frsRequestData.setCtime((int) com.baidu.tieba.frs.i.dBj);
            }
            if (com.baidu.tieba.frs.i.dBk != 0) {
                frsRequestData.setDataSize((int) com.baidu.tieba.frs.i.dBk);
            }
            if (com.baidu.tieba.frs.i.dBl != 0) {
                frsRequestData.setNetError(com.baidu.tieba.frs.i.dBl);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            axR();
        }
    }

    private boolean a(FrsRequestData frsRequestData, i iVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.dOJ) {
            this.dAN.e(iVar);
            if (frsRequestData != null) {
                this.dOG = frsRequestData;
                this.mPn = this.dOG.getPn();
                this.dBb = this.dOG.getKw();
                this.dOE.lM(this.dBb);
                this.dOE.setFrom(this.mFrom);
                this.dOE.setPn(this.mPn);
                this.dOE.setFlag(this.mFlag);
            }
            this.dOE.dCe.a(this.mType, false, this.dOH);
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
            aVar.gUV = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            aVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            aVar.errorCode = mvcSocketResponsedMessage.getError();
            aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            aVar.gUW = mvcSocketResponsedMessage.getDownSize();
            this.dOH = aVar;
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
            aVar.gUV = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            aVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            aVar.errorCode = mvcHttpResponsedMessage.getError();
            aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            aVar.gUW = mvcHttpResponsedMessage.getDownSize();
            this.dOH = aVar;
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

    public void aum() {
        if (this.dAN != null && this.dAN.aYE() != null && this.dAN.aYE().getBannerListData() != null) {
            String lastIds = this.dAN.aYE().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dOI = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public l axQ() {
        return this.dAN;
    }

    private void axR() {
        this.dmT = System.currentTimeMillis();
        this.dOF.MO();
    }

    public long apT() {
        return this.dmW;
    }

    public long apU() {
        return this.dmU;
    }

    public long apV() {
        return this.dmV;
    }

    public long apW() {
        return this.dmT;
    }

    public boolean DP() {
        return this.dOF.DP();
    }

    public void my(int i) {
        this.dOJ = i;
        eP(true);
    }

    public boolean axS() {
        return this.dOJ < 100;
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
