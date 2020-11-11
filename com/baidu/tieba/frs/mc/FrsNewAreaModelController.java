package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes22.dex */
public class FrsNewAreaModelController extends BdBaseModel implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.m> {
    private FrsViewData iGN;
    private String iHh;
    private long imD;
    private long imE;
    private long imF;
    private long imG;
    private FrsNetModel<FrsNewAreaFragment> jbU;
    private FrsRequestData jbV;
    private com.baidu.tieba.tbadkCore.f jbW;
    private String jbX;
    private FrsNewAreaFragment jdZ;
    private int jdo;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsNewAreaModelController(FrsNewAreaFragment frsNewAreaFragment) {
        super(frsNewAreaFragment.getPageContext());
        this.iHh = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.jbX = null;
        this.jdo = -1;
        this.imD = 0L;
        this.imE = 0L;
        this.imF = 0L;
        this.imG = 0L;
        this.jdZ = frsNewAreaFragment;
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
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            Aa(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            Aa(6);
        } else {
            Aa(2);
        }
        this.iGN = new FrsViewData();
        this.jbV.go("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.iHh));
        this.jbV.go("client_type", "2");
        this.jbU = new FrsNetModel<>(this.jdZ.getPageContext(), this.jbV);
        this.jbU.a(this);
        this.jbU.setUniqueId(this.jdZ.getUniqueId());
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
        if (this.jdZ != null && this.jdZ.isAdded() && this.jdZ.getPageContext() != null) {
            this.jdZ.iIT.yG(i);
            this.jbU.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.iHh);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(0);
            frsRequestData.setCid(0);
            com.baidu.tieba.frs.f.i.a(this.jdo, frsRequestData);
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.jdZ.getPageContext().getPageActivity());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.jdZ.getPageContext().getPageActivity());
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

    private boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.m mVar) {
        this.iGN.receiveData(mVar);
        this.iGN.frsCurrentTabId = 503;
        if (frsRequestData != null) {
            this.jbV = frsRequestData;
            this.mPn = this.jbV.getPn();
            this.iHh = this.jbV.getKw();
            this.jdZ.KN(this.iHh);
            this.jdZ.setFrom(this.mFrom);
            this.jdZ.setPn(this.mPn);
            this.jdZ.setFlag(this.mFlag);
        }
        this.jdZ.iIT.a(this.mType, false, this.jbW);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iro = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.mUE = mvcSocketResponsedMessage.getDownSize();
            this.jbW = fVar;
            FrsRequestData frsRequestData2 = null;
            com.baidu.tieba.tbadkCore.m data = mvcSocketResponsedMessage.getData();
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
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcHttpResponsedMessage != null) {
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iro = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.mUE = mvcHttpResponsedMessage.getDownSize();
            this.jbW = fVar;
            FrsRequestData frsRequestData2 = null;
            com.baidu.tieba.tbadkCore.m data = mvcHttpResponsedMessage.getData();
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

    public void loadData() {
        cDM();
    }

    public boolean cDP() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void Aa(int i) {
        this.jdo = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dLd();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dLe();
        }
    }

    public int cEr() {
        return this.jdo;
    }

    public void an(bw bwVar) {
        if (bwVar != null && this.iGN != null && this.iGN.getThreadList() != null) {
            if (y.isEmpty(this.iGN.getThreadList())) {
                this.iGN.getThreadList().add(bwVar);
            } else {
                this.iGN.getThreadList().add(0, bwVar);
            }
            this.jdZ.e(this.iGN);
        }
    }
}
