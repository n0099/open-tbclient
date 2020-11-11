package com.baidu.tieba.frs.good;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.au;
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
import com.baidu.tieba.tbadkCore.f;
import com.baidu.tieba.tbadkCore.m;
/* loaded from: classes22.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.b<FrsRequestData, m> {
    private FrsViewData iGN;
    private String iHh;
    private long imD;
    private long imE;
    private long imF;
    private long imG;
    private FrsGoodFragment jbT;
    private FrsNetModel<FrsGoodFragment> jbU;
    private FrsRequestData jbV;
    private f jbW;
    private String jbX;
    private int jbY;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.iHh = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.jbX = null;
        this.jbY = 0;
        this.imD = 0L;
        this.imE = 0L;
        this.imF = 0L;
        this.imG = 0L;
        this.jbT = frsGoodFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cDL() {
        this.jbU.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.iHh = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.iHh)) {
            this.iHh = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.jbV = new FrsRequestData();
        this.iGN = new FrsViewData();
        this.jbV.go("forum_name", k.getUrlEncode(this.iHh));
        this.jbV.go("client_type", "2");
        this.jbU = new FrsNetModel<>(this.jbT.getPageContext(), this.jbV);
        this.jbU.a(this);
        this.jbU.setUniqueId(this.jbT.getUniqueId());
        if (this.iHh != null && this.iHh.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.iHh);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean cDM() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jbV), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void zV(int i) {
        if (!this.jbU.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jbV), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.jbT != null && this.jbT.isAdded() && this.jbT.getPageContext() != null) {
            this.jbT.iIT.yG(i);
            this.jbU.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.iHh);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.Jx(0);
            frsRequestData.setCid(this.jbY);
            int equipmentWidth = l.getEquipmentWidth(this.jbT.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(this.jbT.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = au.bro().brp() ? 2 : 1;
            frsRequestData.setScrW(equipmentWidth);
            frsRequestData.setScrH(equipmentHeight);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.jbX);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.iHw != 0) {
                frsRequestData.setCtime((int) FrsFragment.iHw);
            }
            if (FrsFragment.iHx != 0) {
                frsRequestData.setDataSize((int) FrsFragment.iHx);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.setNetError(FrsFragment.mNetError);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            cDO();
        }
    }

    private boolean a(FrsRequestData frsRequestData, m mVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.jbY) {
            this.iGN.receiveData(mVar);
            this.iGN.frsCurrentTabId = 301;
            if (frsRequestData != null) {
                this.jbV = frsRequestData;
                this.mPn = this.jbV.getPn();
                this.iHh = this.jbV.getKw();
                this.jbT.KN(this.iHh);
                this.jbT.setFrom(this.mFrom);
                this.jbT.setPn(this.mPn);
                this.jbT.setFlag(this.mFlag);
            }
            this.jbT.iIT.a(this.mType, false, this.jbW);
            this.mSource = null;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, m> mvcSocketMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            f fVar = new f();
            fVar.iro = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.mUE = mvcSocketResponsedMessage.getDownSize();
            this.jbW = fVar;
            FrsRequestData frsRequestData2 = null;
            m data = mvcSocketResponsedMessage.getData();
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
    public void a(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, m> mvcHttpMessage, MvcNetMessage<FrsRequestData, m> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcHttpResponsedMessage != null) {
            f fVar = new f();
            fVar.iro = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.mUE = mvcHttpResponsedMessage.getDownSize();
            this.jbW = fVar;
            FrsRequestData frsRequestData2 = null;
            m data = mvcHttpResponsedMessage.getData();
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

    public void cyJ() {
        if (this.iGN != null && this.iGN.getForum() != null && this.iGN.getForum().getBannerListData() != null) {
            String lastIds = this.iGN.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.jbX = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData cDN() {
        return this.iGN;
    }

    private void cDO() {
        this.imD = System.currentTimeMillis();
        this.jbU.loadData();
    }

    public long cst() {
        return this.imG;
    }

    public long csu() {
        return this.imE;
    }

    public long csv() {
        return this.imF;
    }

    public long csw() {
        return this.imD;
    }

    public boolean isLoading() {
        return this.jbU.isLoading();
    }

    public void tW(int i) {
        this.jbY = i;
        cDM();
    }

    public boolean cDP() {
        return this.jbY < 100;
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
