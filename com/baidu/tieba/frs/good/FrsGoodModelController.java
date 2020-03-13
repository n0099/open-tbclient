package com.baidu.tieba.frs.good;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.util.k;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
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
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes9.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.b<FrsRequestData, l> {
    private long fWG;
    private long fWH;
    private long fWI;
    private long fWJ;
    private FrsGoodFragment gFQ;
    private FrsNetModel<FrsGoodFragment> gFR;
    private FrsRequestData gFS;
    private e.b gFT;
    private String gFU;
    private int gFV;
    private FrsViewData gnZ;
    private String gor;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.gor = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.gFU = null;
        this.gFV = 0;
        this.fWG = 0L;
        this.fWH = 0L;
        this.fWI = 0L;
        this.fWJ = 0L;
        this.gFQ = frsGoodFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiI() {
        this.gFR.cancelLoadData();
    }

    public void ad(Bundle bundle) {
        if (bundle != null) {
            this.gor = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.gor)) {
            this.gor = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.gFS = new FrsRequestData();
        this.gnZ = new FrsViewData();
        this.gFS.eB("forum_name", k.getUrlEncode(this.gor));
        this.gFS.eB("client_type", "2");
        this.gFR = new FrsNetModel<>(this.gFQ.getPageContext(), this.gFS);
        this.gFR.a(this);
        this.gFR.setUniqueId(this.gFQ.getUniqueId());
        if (this.gor != null && this.gor.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.gor);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean bIM() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gFS), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void tK(int i) {
        if (!this.gFR.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gFS), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.gFQ != null && this.gFQ.isAdded() && this.gFQ.getPageContext() != null) {
            this.gFQ.gpM.sG(i);
            this.gFR.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.gor);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.Cq(0);
            frsRequestData.setCid(this.gFV);
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.gFQ.getPageContext().getPageActivity());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.gFQ.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ar.aGD().aGE() ? 2 : 1;
            frsRequestData.setScrW(equipmentWidth);
            frsRequestData.setScrH(equipmentHeight);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.gFU);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.goF != 0) {
                frsRequestData.setCtime((int) FrsFragment.goF);
            }
            if (FrsFragment.goG != 0) {
                frsRequestData.setDataSize((int) FrsFragment.goG);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.setNetError(FrsFragment.mNetError);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            bIO();
        }
    }

    private boolean a(FrsRequestData frsRequestData, l lVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.gFV) {
            this.gnZ.receiveData(lVar);
            this.gnZ.frsCurrentTabId = 301;
            if (frsRequestData != null) {
                this.gFS = frsRequestData;
                this.mPn = this.gFS.getPn();
                this.gor = this.gFS.getKw();
                this.gFQ.BA(this.gor);
                this.gFQ.setFrom(this.mFrom);
                this.gFQ.setPn(this.mPn);
                this.gFQ.setFlag(this.mFlag);
            }
            this.gFQ.gpM.a(this.mType, false, this.gFT);
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
            bVar.fZC = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.keu = mvcSocketResponsedMessage.getDownSize();
            this.gFT = bVar;
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
            objArr[2] = BdStatsConstant.StatsKey.SEQUENCEID;
            objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
            com.baidu.tbadk.core.d.a.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<l> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, l> mvcHttpMessage, MvcNetMessage<FrsRequestData, l> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcHttpResponsedMessage != null) {
            e.b bVar = new e.b();
            bVar.fZC = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.keu = mvcHttpResponsedMessage.getDownSize();
            this.gFT = bVar;
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
            com.baidu.tbadk.core.d.a.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
    }

    public void bEk() {
        if (this.gnZ != null && this.gnZ.getForum() != null && this.gnZ.getForum().getBannerListData() != null) {
            String lastIds = this.gnZ.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.gFU = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData bIN() {
        return this.gnZ;
    }

    private void bIO() {
        this.fWG = System.currentTimeMillis();
        this.gFR.loadData();
    }

    public long byN() {
        return this.fWJ;
    }

    public long byO() {
        return this.fWH;
    }

    public long byP() {
        return this.fWI;
    }

    public long byQ() {
        return this.fWG;
    }

    public boolean isLoading() {
        return this.gFR.isLoading();
    }

    public void oF(int i) {
        this.gFV = i;
        bIM();
    }

    public boolean bIP() {
        return this.gFV < 100;
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
