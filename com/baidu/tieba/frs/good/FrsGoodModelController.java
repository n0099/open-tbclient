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
    private long fWt;
    private long fWu;
    private long fWv;
    private long fWw;
    private FrsGoodFragment gFE;
    private FrsNetModel<FrsGoodFragment> gFF;
    private FrsRequestData gFG;
    private e.b gFH;
    private String gFI;
    private int gFJ;
    private FrsViewData gnM;
    private String goe;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.goe = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.gFI = null;
        this.gFJ = 0;
        this.fWt = 0L;
        this.fWu = 0L;
        this.fWv = 0L;
        this.fWw = 0L;
        this.gFE = frsGoodFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiI() {
        this.gFF.cancelLoadData();
    }

    public void ad(Bundle bundle) {
        if (bundle != null) {
            this.goe = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.goe)) {
            this.goe = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.gFG = new FrsRequestData();
        this.gnM = new FrsViewData();
        this.gFG.eB("forum_name", k.getUrlEncode(this.goe));
        this.gFG.eB("client_type", "2");
        this.gFF = new FrsNetModel<>(this.gFE.getPageContext(), this.gFG);
        this.gFF.a(this);
        this.gFF.setUniqueId(this.gFE.getUniqueId());
        if (this.goe != null && this.goe.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.goe);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean bIL() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gFG), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void tK(int i) {
        if (!this.gFF.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gFG), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.gFE != null && this.gFE.isAdded() && this.gFE.getPageContext() != null) {
            this.gFE.gpz.sG(i);
            this.gFF.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.goe);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.Cq(0);
            frsRequestData.setCid(this.gFJ);
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.gFE.getPageContext().getPageActivity());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.gFE.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ar.aGD().aGE() ? 2 : 1;
            frsRequestData.setScrW(equipmentWidth);
            frsRequestData.setScrH(equipmentHeight);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.gFI);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.gos != 0) {
                frsRequestData.setCtime((int) FrsFragment.gos);
            }
            if (FrsFragment.got != 0) {
                frsRequestData.setDataSize((int) FrsFragment.got);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.setNetError(FrsFragment.mNetError);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            bIN();
        }
    }

    private boolean a(FrsRequestData frsRequestData, l lVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.gFJ) {
            this.gnM.receiveData(lVar);
            this.gnM.frsCurrentTabId = 301;
            if (frsRequestData != null) {
                this.gFG = frsRequestData;
                this.mPn = this.gFG.getPn();
                this.goe = this.gFG.getKw();
                this.gFE.Bz(this.goe);
                this.gFE.setFrom(this.mFrom);
                this.gFE.setPn(this.mPn);
                this.gFE.setFlag(this.mFlag);
            }
            this.gFE.gpz.a(this.mType, false, this.gFH);
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
            bVar.fZp = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.kei = mvcSocketResponsedMessage.getDownSize();
            this.gFH = bVar;
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
            bVar.fZp = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.kei = mvcHttpResponsedMessage.getDownSize();
            this.gFH = bVar;
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

    public void bEj() {
        if (this.gnM != null && this.gnM.getForum() != null && this.gnM.getForum().getBannerListData() != null) {
            String lastIds = this.gnM.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.gFI = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData bIM() {
        return this.gnM;
    }

    private void bIN() {
        this.fWt = System.currentTimeMillis();
        this.gFF.loadData();
    }

    public long byM() {
        return this.fWw;
    }

    public long byN() {
        return this.fWu;
    }

    public long byO() {
        return this.fWv;
    }

    public long byP() {
        return this.fWt;
    }

    public boolean isLoading() {
        return this.gFF.isLoading();
    }

    public void oF(int i) {
        this.gFJ = i;
        bIL();
    }

    public boolean bIO() {
        return this.gFJ < 100;
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
