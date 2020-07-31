package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes16.dex */
public class FrsNewAreaModelController extends BdBaseModel implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.m> {
    private FrsViewData hEX;
    private String hFr;
    private FrsNetModel<FrsNewAreaFragment> hZb;
    private FrsRequestData hZc;
    private com.baidu.tieba.tbadkCore.f hZd;
    private String hZe;
    private long hll;
    private long hlm;
    private long hln;
    private long hlo;
    private int iaw;
    private FrsNewAreaFragment ibi;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsNewAreaModelController(FrsNewAreaFragment frsNewAreaFragment) {
        super(frsNewAreaFragment.getPageContext());
        this.hFr = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.hZe = null;
        this.iaw = -1;
        this.hll = 0L;
        this.hlm = 0L;
        this.hln = 0L;
        this.hlo = 0L;
        this.ibi = frsNewAreaFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cgL() {
        this.hZb.cancelLoadData();
    }

    public void ak(Bundle bundle) {
        if (bundle != null) {
            this.hFr = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.hFr)) {
            this.hFr = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.hZc = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            vW(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            vW(6);
        } else {
            vW(2);
        }
        this.hEX = new FrsViewData();
        this.hZc.fy("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.hFr));
        this.hZc.fy("client_type", "2");
        this.hZb = new FrsNetModel<>(this.ibi.getPageContext(), this.hZc);
        this.hZb.a(this);
        this.hZb.setUniqueId(this.ibi.getUniqueId());
        if (this.hFr != null && this.hFr.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.hFr);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean cgM() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.hZc), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void vR(int i) {
        if (!this.hZb.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.hZc), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.ibi != null && this.ibi.isAdded() && this.ibi.getPageContext() != null) {
            this.ibi.hHd.uG(i);
            this.hZb.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.hFr);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(0);
            frsRequestData.setCid(0);
            com.baidu.tieba.frs.f.g.a(this.iaw, frsRequestData);
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.ibi.getPageContext().getPageActivity());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.ibi.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = at.baS().baT() ? 2 : 1;
            frsRequestData.setScrW(equipmentWidth);
            frsRequestData.setScrH(equipmentHeight);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.hZe);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.hFG != 0) {
                frsRequestData.setCtime((int) FrsFragment.hFG);
            }
            if (FrsFragment.hFH != 0) {
                frsRequestData.setDataSize((int) FrsFragment.hFH);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.setNetError(FrsFragment.mNetError);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            cgO();
        }
    }

    private boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.m mVar) {
        this.hEX.receiveData(mVar);
        this.hEX.frsCurrentTabId = 503;
        if (frsRequestData != null) {
            this.hZc = frsRequestData;
            this.mPn = this.hZc.getPn();
            this.hFr = this.hZc.getKw();
            this.ibi.Gj(this.hFr);
            this.ibi.setFrom(this.mFrom);
            this.ibi.setPn(this.mPn);
            this.ibi.setFlag(this.mFlag);
        }
        this.ibi.hHd.a(this.mType, false, this.hZd);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.hpV = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.lKP = mvcSocketResponsedMessage.getDownSize();
            this.hZd = fVar;
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
            fVar.hpV = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.lKP = mvcHttpResponsedMessage.getDownSize();
            this.hZd = fVar;
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

    public void cbT() {
        if (this.hEX != null && this.hEX.getForum() != null && this.hEX.getForum().getBannerListData() != null) {
            String lastIds = this.hEX.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.hZe = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData cgN() {
        return this.hEX;
    }

    private void cgO() {
        this.hll = System.currentTimeMillis();
        this.hZb.loadData();
    }

    public long bVK() {
        return this.hlo;
    }

    public long bVL() {
        return this.hlm;
    }

    public long bVM() {
        return this.hln;
    }

    public long bVN() {
        return this.hll;
    }

    public boolean isLoading() {
        return this.hZb.isLoading();
    }

    public void loadData() {
        cgM();
    }

    public boolean cgP() {
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

    public void vW(int i) {
        this.iaw = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dmn();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dmo();
        }
    }

    public int chr() {
        return this.iaw;
    }

    public void am(bv bvVar) {
        if (bvVar != null && this.hEX != null && this.hEX.getThreadList() != null) {
            if (x.isEmpty(this.hEX.getThreadList())) {
                this.hEX.getThreadList().add(bvVar);
            } else {
                this.hEX.getThreadList().add(0, bvVar);
            }
            this.ibi.e(this.hEX);
        }
    }
}
