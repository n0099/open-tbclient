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
    private long fWr;
    private long fWs;
    private long fWt;
    private long fWu;
    private FrsGoodFragment gFC;
    private FrsNetModel<FrsGoodFragment> gFD;
    private FrsRequestData gFE;
    private e.b gFF;
    private String gFG;
    private int gFH;
    private FrsViewData gnK;
    private String goc;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.goc = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.gFG = null;
        this.gFH = 0;
        this.fWr = 0L;
        this.fWs = 0L;
        this.fWt = 0L;
        this.fWu = 0L;
        this.gFC = frsGoodFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiG() {
        this.gFD.cancelLoadData();
    }

    public void ad(Bundle bundle) {
        if (bundle != null) {
            this.goc = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.goc)) {
            this.goc = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.gFE = new FrsRequestData();
        this.gnK = new FrsViewData();
        this.gFE.eB("forum_name", k.getUrlEncode(this.goc));
        this.gFE.eB("client_type", "2");
        this.gFD = new FrsNetModel<>(this.gFC.getPageContext(), this.gFE);
        this.gFD.a(this);
        this.gFD.setUniqueId(this.gFC.getUniqueId());
        if (this.goc != null && this.goc.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.goc);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean bIJ() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gFE), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void tK(int i) {
        if (!this.gFD.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gFE), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.gFC != null && this.gFC.isAdded() && this.gFC.getPageContext() != null) {
            this.gFC.gpx.sG(i);
            this.gFD.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.goc);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.Cq(0);
            frsRequestData.setCid(this.gFH);
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.gFC.getPageContext().getPageActivity());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.gFC.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ar.aGB().aGC() ? 2 : 1;
            frsRequestData.setScrW(equipmentWidth);
            frsRequestData.setScrH(equipmentHeight);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.gFG);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.goq != 0) {
                frsRequestData.setCtime((int) FrsFragment.goq);
            }
            if (FrsFragment.gor != 0) {
                frsRequestData.setDataSize((int) FrsFragment.gor);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.setNetError(FrsFragment.mNetError);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            bIL();
        }
    }

    private boolean a(FrsRequestData frsRequestData, l lVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.gFH) {
            this.gnK.receiveData(lVar);
            this.gnK.frsCurrentTabId = 301;
            if (frsRequestData != null) {
                this.gFE = frsRequestData;
                this.mPn = this.gFE.getPn();
                this.goc = this.gFE.getKw();
                this.gFC.Bz(this.goc);
                this.gFC.setFrom(this.mFrom);
                this.gFC.setPn(this.mPn);
                this.gFC.setFlag(this.mFlag);
            }
            this.gFC.gpx.a(this.mType, false, this.gFF);
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
            bVar.fZn = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.keg = mvcSocketResponsedMessage.getDownSize();
            this.gFF = bVar;
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
            bVar.fZn = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.keg = mvcHttpResponsedMessage.getDownSize();
            this.gFF = bVar;
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

    public void bEh() {
        if (this.gnK != null && this.gnK.getForum() != null && this.gnK.getForum().getBannerListData() != null) {
            String lastIds = this.gnK.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.gFG = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData bIK() {
        return this.gnK;
    }

    private void bIL() {
        this.fWr = System.currentTimeMillis();
        this.gFD.loadData();
    }

    public long byK() {
        return this.fWu;
    }

    public long byL() {
        return this.fWs;
    }

    public long byM() {
        return this.fWt;
    }

    public long byN() {
        return this.fWr;
    }

    public boolean isLoading() {
        return this.gFD.isLoading();
    }

    public void oF(int i) {
        this.gFH = i;
        bIJ();
    }

    public boolean bIM() {
        return this.gFH < 100;
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
