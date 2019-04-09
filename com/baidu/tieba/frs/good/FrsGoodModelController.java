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
    private long eDB;
    private long eDC;
    private long eDD;
    private long eDE;
    private FrsViewData eYi;
    private String eYx;
    private FrsGoodFragment fpF;
    private FrsNetModel<FrsGoodFragment> fpG;
    private FrsRequestData fpH;
    private e.b fpI;
    private String fpJ;
    private int fpK;
    private boolean fpk;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.eYx = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.fpJ = null;
        this.fpK = 0;
        this.fpk = false;
        this.eDB = 0L;
        this.eDC = 0L;
        this.eDD = 0L;
        this.eDE = 0L;
        this.fpF = frsGoodFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.fpG.cancelLoadData();
    }

    public void J(Bundle bundle) {
        if (bundle != null) {
            this.eYx = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fpk = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        }
        if (TextUtils.isEmpty(this.eYx)) {
            this.eYx = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.fpH = new FrsRequestData();
        this.eYi = new FrsViewData();
        this.fpH.dV("forum_name", k.bx(this.eYx));
        this.fpH.dV("client_type", "2");
        this.fpG = new FrsNetModel<>(this.fpF.getPageContext(), this.fpH);
        this.fpG.a(this);
        this.fpG.setUniqueId(this.fpF.getUniqueId());
        if (this.eYx != null && this.eYx.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.eYx);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.fpk);
    }

    public boolean bhl() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fpH), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void qV(int i) {
        if (!this.fpG.qz()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fpH), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.fpF != null && this.fpF.isAdded() && this.fpF.getPageContext() != null) {
            this.fpF.eZV.pT(i);
            this.fpG.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.eYx);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.zi(this.fpk ? 1 : 0);
            if (this.fpk) {
                frsRequestData.setRn(50);
                frsRequestData.zj(50);
                frsRequestData.setIsGood(0);
            }
            frsRequestData.setCid(this.fpK);
            int aO = l.aO(this.fpF.getPageContext().getPageActivity());
            int aQ = l.aQ(this.fpF.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ar.adm().ado() ? 2 : 1;
            frsRequestData.setScrW(aO);
            frsRequestData.setScrH(aQ);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.fpJ);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.eYL != 0) {
                frsRequestData.setCtime((int) FrsFragment.eYL);
            }
            if (FrsFragment.eYM != 0) {
                frsRequestData.setDataSize((int) FrsFragment.eYM);
            }
            if (FrsFragment.eYN != 0) {
                frsRequestData.setNetError(FrsFragment.eYN);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            bhn();
        }
    }

    private boolean a(FrsRequestData frsRequestData, j jVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.fpK) {
            this.eYi.receiveData(jVar);
            this.eYi.frsCurrentTabId = this.fpk ? 303 : 301;
            if (frsRequestData != null) {
                this.fpH = frsRequestData;
                this.mPn = this.fpH.getPn();
                this.eYx = this.fpH.getKw();
                this.fpF.vv(this.eYx);
                this.fpF.setFrom(this.mFrom);
                this.fpF.setPn(this.mPn);
                this.fpF.setFlag(this.mFlag);
            }
            this.eYi.switchThreadDataToThreadCardInfo();
            this.fpF.eZV.a(this.mType, false, this.fpI);
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
            bVar.iDB = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.iDC = mvcSocketResponsedMessage.getDownSize();
            this.fpI = bVar;
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
            bVar.iDB = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.iDC = mvcHttpResponsedMessage.getDownSize();
            this.fpI = bVar;
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

    public void bcJ() {
        if (this.eYi != null && this.eYi.getForum() != null && this.eYi.getForum().getBannerListData() != null) {
            String lastIds = this.eYi.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fpJ = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData bhm() {
        return this.eYi;
    }

    private void bhn() {
        this.eDB = System.currentTimeMillis();
        this.fpG.aor();
    }

    public long aWP() {
        return this.eDE;
    }

    public long aWQ() {
        return this.eDC;
    }

    public long aWR() {
        return this.eDD;
    }

    public long aWS() {
        return this.eDB;
    }

    public boolean qz() {
        return this.fpG.qz();
    }

    public void me(int i) {
        this.fpK = i;
        bhl();
    }

    public boolean bho() {
        return this.fpK < 100;
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
