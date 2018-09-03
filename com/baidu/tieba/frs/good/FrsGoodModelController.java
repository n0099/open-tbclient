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
    private long cTu;
    private long cTv;
    private long cTw;
    private long cTx;
    private boolean dCf;
    private FrsGoodFragment dCu;
    private FrsNetModel<FrsGoodFragment> dCv;
    private FrsRequestData dCw;
    private String dCx;
    private int dCy;
    private l dlQ;
    private String dmg;
    private d.a dsQ;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.dmg = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.dCx = null;
        this.dCy = 0;
        this.dCf = false;
        this.cTu = 0L;
        this.cTv = 0L;
        this.cTw = 0L;
        this.cTx = 0L;
        this.dCu = frsGoodFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.dCv.cancelLoadData();
    }

    public void i(Bundle bundle) {
        if (bundle != null) {
            this.dmg = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dCf = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        }
        if (TextUtils.isEmpty(this.dmg)) {
            this.dmg = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.dCw = new FrsRequestData();
        this.dlQ = new l();
        this.dCv = new FrsNetModel<>(this.dCu.getPageContext(), this.dCw);
        this.dCv.a(this);
        this.dCv.setUniqueId(getUniqueId());
        if (this.dmg != null && this.dmg.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dmg);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.dCf);
    }

    public boolean awv() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dCw), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void lp(int i) {
        if (!this.dCv.AB()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dCw), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.dCu != null && this.dCu.isAdded() && this.dCu.getPageContext() != null) {
            this.dCu.dnv.kt(i);
            this.dCv.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.dmg);
            if (com.baidu.tbadk.core.i.td().tj()) {
                frsRequestData.setRn(35);
            } else {
                frsRequestData.setRn(50);
            }
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.tu(this.dCf ? 1 : 0);
            if (this.dCf) {
                frsRequestData.setRn(50);
                frsRequestData.tv(50);
                frsRequestData.setIsGood(0);
            }
            frsRequestData.setCid(this.dCy);
            int ah = com.baidu.adp.lib.util.l.ah(this.dCu.getPageContext().getPageActivity());
            int aj = com.baidu.adp.lib.util.l.aj(this.dCu.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ar.zu().zw() ? 2 : 1;
            frsRequestData.setScrW(ah);
            frsRequestData.setScrH(aj);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.dCx);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.dmq != 0) {
                frsRequestData.setCtime((int) FrsFragment.dmq);
            }
            if (FrsFragment.dmr != 0) {
                frsRequestData.setDataSize((int) FrsFragment.dmr);
            }
            if (FrsFragment.dms != 0) {
                frsRequestData.setNetError(FrsFragment.dms);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            aze();
        }
    }

    private boolean a(FrsRequestData frsRequestData, i iVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.dCy) {
            this.dlQ.e(iVar);
            this.dlQ.gMI = this.dCf ? 303 : 301;
            if (frsRequestData != null) {
                this.dCw = frsRequestData;
                this.mPn = this.dCw.getPn();
                this.dmg = this.dCw.getKw();
                this.dCu.mT(this.dmg);
                this.dCu.setFrom(this.mFrom);
                this.dCu.setPn(this.mPn);
                this.dCu.setFlag(this.mFlag);
            }
            this.dCu.dnv.a(this.mType, false, this.dsQ);
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
            aVar.gKD = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            aVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            aVar.errorCode = mvcSocketResponsedMessage.getError();
            aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            aVar.gKE = mvcSocketResponsedMessage.getDownSize();
            this.dsQ = aVar;
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
            aVar.gKD = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            aVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            aVar.errorCode = mvcHttpResponsedMessage.getError();
            aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            aVar.gKE = mvcHttpResponsedMessage.getDownSize();
            this.dsQ = aVar;
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

    public void auz() {
        if (this.dlQ != null && this.dlQ.aZg() != null && this.dlQ.aZg().getBannerListData() != null) {
            String lastIds = this.dlQ.aZg().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dCx = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public l azd() {
        return this.dlQ;
    }

    private void aze() {
        this.cTu = System.currentTimeMillis();
        this.dCv.JV();
    }

    public long apc() {
        return this.cTx;
    }

    public long apd() {
        return this.cTv;
    }

    public long ape() {
        return this.cTw;
    }

    public long apf() {
        return this.cTu;
    }

    public boolean AB() {
        return this.dCv.AB();
    }

    public void gS(int i) {
        this.dCy = i;
        awv();
    }

    public boolean azf() {
        return this.dCy < 100;
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
