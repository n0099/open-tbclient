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
/* loaded from: classes7.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.b<FrsRequestData, l> {
    private long fTZ;
    private long fUa;
    private long fUb;
    private long fUc;
    private FrsGoodFragment gDD;
    private FrsNetModel<FrsGoodFragment> gDE;
    private FrsRequestData gDF;
    private e.b gDG;
    private String gDH;
    private int gDI;
    private boolean gDk;
    private FrsViewData glJ;
    private String gmb;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.gmb = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.gDH = null;
        this.gDI = 0;
        this.gDk = false;
        this.fTZ = 0L;
        this.fUa = 0L;
        this.fUb = 0L;
        this.fUc = 0L;
        this.gDD = frsGoodFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ags() {
        this.gDE.cancelLoadData();
    }

    public void ad(Bundle bundle) {
        if (bundle != null) {
            this.gmb = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.gDk = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        }
        if (TextUtils.isEmpty(this.gmb)) {
            this.gmb = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.gDF = new FrsRequestData();
        this.glJ = new FrsViewData();
        this.gDF.es("forum_name", k.getUrlEncode(this.gmb));
        this.gDF.es("client_type", "2");
        this.gDE = new FrsNetModel<>(this.gDD.getPageContext(), this.gDF);
        this.gDE.a(this);
        this.gDE.setUniqueId(this.gDD.getUniqueId());
        if (this.gmb != null && this.gmb.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.gmb);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.gDk);
    }

    public boolean bHi() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gDF), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void tE(int i) {
        if (!this.gDE.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gDF), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.gDD != null && this.gDD.isAdded() && this.gDD.getPageContext() != null) {
            this.gDD.gnw.sA(i);
            this.gDE.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.gmb);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.Cj(this.gDk ? 1 : 0);
            if (this.gDk) {
                frsRequestData.setRn(50);
                frsRequestData.Cl(50);
                frsRequestData.setIsGood(0);
            }
            frsRequestData.setCid(this.gDI);
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.gDD.getPageContext().getPageActivity());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.gDD.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ar.aEq().aEr() ? 2 : 1;
            frsRequestData.setScrW(equipmentWidth);
            frsRequestData.setScrH(equipmentHeight);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.gDH);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.gmp != 0) {
                frsRequestData.setCtime((int) FrsFragment.gmp);
            }
            if (FrsFragment.gmq != 0) {
                frsRequestData.setDataSize((int) FrsFragment.gmq);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.setNetError(FrsFragment.mNetError);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            bHk();
        }
    }

    private boolean a(FrsRequestData frsRequestData, l lVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.gDI) {
            this.glJ.receiveData(lVar);
            this.glJ.frsCurrentTabId = this.gDk ? 303 : 301;
            if (frsRequestData != null) {
                this.gDF = frsRequestData;
                this.mPn = this.gDF.getPn();
                this.gmb = this.gDF.getKw();
                this.gDD.Bj(this.gmb);
                this.gDD.setFrom(this.mFrom);
                this.gDD.setPn(this.mPn);
                this.gDD.setFlag(this.mFlag);
            }
            this.gDD.gnw.a(this.mType, false, this.gDG);
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
            bVar.fXn = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.kdh = mvcSocketResponsedMessage.getDownSize();
            this.gDG = bVar;
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
            bVar.fXn = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.kdh = mvcHttpResponsedMessage.getDownSize();
            this.gDG = bVar;
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

    public void bCE() {
        if (this.glJ != null && this.glJ.getForum() != null && this.glJ.getForum().getBannerListData() != null) {
            String lastIds = this.glJ.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.gDH = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData bHj() {
        return this.glJ;
    }

    private void bHk() {
        this.fTZ = System.currentTimeMillis();
        this.gDE.loadData();
    }

    public long bxf() {
        return this.fUc;
    }

    public long bxg() {
        return this.fUa;
    }

    public long bxh() {
        return this.fUb;
    }

    public long bxi() {
        return this.fTZ;
    }

    public boolean isLoading() {
        return this.gDE.isLoading();
    }

    public void oo(int i) {
        this.gDI = i;
        bHi();
    }

    public boolean bHl() {
        return this.gDI < 100;
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
