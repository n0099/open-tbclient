package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes9.dex */
public class FrsNewAreaModelController extends BdBaseModel implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.m> {
    private long gSS;
    private long gST;
    private long gSU;
    private long gSV;
    private FrsNetModel<FrsNewAreaFragment> hFP;
    private FrsRequestData hFQ;
    private com.baidu.tieba.tbadkCore.f hFR;
    private String hFS;
    private FrsNewAreaFragment hHX;
    private int hHk;
    private FrsViewData hmR;
    private String hnl;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsNewAreaModelController(FrsNewAreaFragment frsNewAreaFragment) {
        super(frsNewAreaFragment.getPageContext());
        this.hnl = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.hFS = null;
        this.hHk = -1;
        this.gSS = 0L;
        this.gST = 0L;
        this.gSU = 0L;
        this.gSV = 0L;
        this.hHX = frsNewAreaFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bZX() {
        this.hFP.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.hnl = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.hnl)) {
            this.hnl = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.hFQ = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            uZ(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            uZ(6);
        } else {
            uZ(2);
        }
        this.hmR = new FrsViewData();
        this.hFQ.fp("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.hnl));
        this.hFQ.fp("client_type", "2");
        this.hFP = new FrsNetModel<>(this.hHX.getPageContext(), this.hFQ);
        this.hFP.a(this);
        this.hFP.setUniqueId(this.hHX.getUniqueId());
        if (this.hnl != null && this.hnl.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.hnl);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean bZY() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.hFQ), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void uU(int i) {
        if (!this.hFP.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.hFQ), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.hHX != null && this.hHX.isAdded() && this.hHX.getPageContext() != null) {
            this.hHX.hoI.tM(i);
            this.hFP.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.hnl);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(0);
            frsRequestData.setCid(0);
            com.baidu.tieba.frs.f.g.a(this.hHk, frsRequestData);
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.hHX.getPageContext().getPageActivity());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.hHX.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ar.aUX().aUY() ? 2 : 1;
            frsRequestData.setScrW(equipmentWidth);
            frsRequestData.setScrH(equipmentHeight);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.hFS);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.hnz != 0) {
                frsRequestData.setCtime((int) FrsFragment.hnz);
            }
            if (FrsFragment.hnA != 0) {
                frsRequestData.setDataSize((int) FrsFragment.hnA);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.setNetError(FrsFragment.mNetError);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            caa();
        }
    }

    private boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.m mVar) {
        this.hmR.receiveData(mVar);
        this.hmR.frsCurrentTabId = 503;
        if (frsRequestData != null) {
            this.hFQ = frsRequestData;
            this.mPn = this.hFQ.getPn();
            this.hnl = this.hFQ.getKw();
            this.hHX.EW(this.hnl);
            this.hHX.setFrom(this.mFrom);
            this.hHX.setPn(this.mPn);
            this.hHX.setFlag(this.mFlag);
        }
        this.hHX.hoI.a(this.mType, false, this.hFR);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.gXw = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.ljF = mvcSocketResponsedMessage.getDownSize();
            this.hFR = fVar;
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
            fVar.gXw = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.ljF = mvcHttpResponsedMessage.getDownSize();
            this.hFR = fVar;
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

    public void bVo() {
        if (this.hmR != null && this.hmR.getForum() != null && this.hmR.getForum().getBannerListData() != null) {
            String lastIds = this.hmR.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.hFS = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData bZZ() {
        return this.hmR;
    }

    private void caa() {
        this.gSS = System.currentTimeMillis();
        this.hFP.loadData();
    }

    public long bPp() {
        return this.gSV;
    }

    public long bPq() {
        return this.gST;
    }

    public long bPr() {
        return this.gSU;
    }

    public long bPs() {
        return this.gSS;
    }

    public boolean isLoading() {
        return this.hFP.isLoading();
    }

    public void loadData() {
        bZY();
    }

    public boolean cab() {
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

    public void uZ(int i) {
        this.hHk = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.deS();
        } else {
            com.baidu.tieba.tbadkCore.util.e.deT();
        }
    }

    public int caD() {
        return this.hHk;
    }

    public void ap(bk bkVar) {
        if (bkVar != null && this.hmR != null && this.hmR.getThreadList() != null) {
            if (v.isEmpty(this.hmR.getThreadList())) {
                this.hmR.getThreadList().add(bkVar);
            } else {
                this.hmR.getThreadList().add(0, bkVar);
            }
            this.hHX.e(this.hmR);
        }
    }
}
