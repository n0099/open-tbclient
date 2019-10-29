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
/* loaded from: classes4.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.b<FrsRequestData, l> {
    private boolean fMC;
    private FrsGoodFragment fMX;
    private FrsNetModel<FrsGoodFragment> fMY;
    private FrsRequestData fMZ;
    private e.b fNa;
    private String fNb;
    private int fNc;
    private long fdc;
    private long fdd;
    private long fde;
    private long fdf;
    private FrsViewData fuR;
    private String fvg;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.fvg = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.fNb = null;
        this.fNc = 0;
        this.fMC = false;
        this.fdc = 0L;
        this.fdd = 0L;
        this.fde = 0L;
        this.fdf = 0L;
        this.fMX = frsGoodFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aGH() {
        this.fMY.cancelLoadData();
    }

    public void K(Bundle bundle) {
        if (bundle != null) {
            this.fvg = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fMC = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        }
        if (TextUtils.isEmpty(this.fvg)) {
            this.fvg = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.fMZ = new FrsRequestData();
        this.fuR = new FrsViewData();
        this.fMZ.dX("forum_name", k.getUrlEncode(this.fvg));
        this.fMZ.dX("client_type", "2");
        this.fMY = new FrsNetModel<>(this.fMX.getPageContext(), this.fMZ);
        this.fMY.a(this);
        this.fMY.setUniqueId(this.fMX.getUniqueId());
        if (this.fvg != null && this.fvg.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.fvg);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.fMC);
    }

    public boolean boL() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fMZ), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void ru(int i) {
        if (!this.fMY.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fMZ), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.fMX != null && this.fMX.isAdded() && this.fMX.getPageContext() != null) {
            this.fMX.fwI.qq(i);
            this.fMY.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.fvg);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.zI(this.fMC ? 1 : 0);
            if (this.fMC) {
                frsRequestData.setRn(50);
                frsRequestData.zK(50);
                frsRequestData.setIsGood(0);
            }
            frsRequestData.setCid(this.fNc);
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.fMX.getPageContext().getPageActivity());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.fMX.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ar.amO().isFrsShowBigImage() ? 2 : 1;
            frsRequestData.setScrW(equipmentWidth);
            frsRequestData.setScrH(equipmentHeight);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.fNb);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.fvu != 0) {
                frsRequestData.setCtime((int) FrsFragment.fvu);
            }
            if (FrsFragment.fvv != 0) {
                frsRequestData.setDataSize((int) FrsFragment.fvv);
            }
            if (FrsFragment.fvw != 0) {
                frsRequestData.setNetError(FrsFragment.fvw);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            boN();
        }
    }

    private boolean a(FrsRequestData frsRequestData, l lVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.fNc) {
            this.fuR.receiveData(lVar);
            this.fuR.frsCurrentTabId = this.fMC ? 303 : 301;
            if (frsRequestData != null) {
                this.fMZ = frsRequestData;
                this.mPn = this.fMZ.getPn();
                this.fvg = this.fMZ.getKw();
                this.fMX.wk(this.fvg);
                this.fMX.setFrom(this.mFrom);
                this.fMX.setPn(this.mPn);
                this.fMX.setFlag(this.mFlag);
            }
            this.fMX.fwI.a(this.mType, false, this.fNa);
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
            bVar.fgr = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.jgd = mvcSocketResponsedMessage.getDownSize();
            this.fNa = bVar;
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
            com.baidu.tbadk.core.e.a.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<l> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, l> mvcHttpMessage, MvcNetMessage<FrsRequestData, l> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcHttpResponsedMessage != null) {
            e.b bVar = new e.b();
            bVar.fgr = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.jgd = mvcHttpResponsedMessage.getDownSize();
            this.fNa = bVar;
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
            com.baidu.tbadk.core.e.a.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
    }

    public void bkj() {
        if (this.fuR != null && this.fuR.getForum() != null && this.fuR.getForum().getBannerListData() != null) {
            String lastIds = this.fuR.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fNb = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData boM() {
        return this.fuR;
    }

    private void boN() {
        this.fdc = System.currentTimeMillis();
        this.fMY.loadData();
    }

    public long beL() {
        return this.fdf;
    }

    public long beM() {
        return this.fdd;
    }

    public long beN() {
        return this.fde;
    }

    public long beO() {
        return this.fdc;
    }

    public boolean isLoading() {
        return this.fMY.isLoading();
    }

    public void mg(int i) {
        this.fNc = i;
        boL();
    }

    public boolean boO() {
        return this.fNc < 100;
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
