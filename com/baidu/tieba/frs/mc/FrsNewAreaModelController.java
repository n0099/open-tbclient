package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.av;
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
/* loaded from: classes2.dex */
public class FrsNewAreaModelController extends BdBaseModel implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.m> {
    private long iLP;
    private long iLQ;
    private long iLR;
    private long iLS;
    private FrsNetModel<FrsNewAreaFragment> jDV;
    private FrsRequestData jDW;
    private com.baidu.tieba.tbadkCore.f jDX;
    private String jDY;
    private FrsNewAreaFragment jFY;
    private int jFp;
    private FrsViewData jfU;
    private String jgn;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsNewAreaModelController(FrsNewAreaFragment frsNewAreaFragment) {
        super(frsNewAreaFragment.getPageContext());
        this.jgn = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.jDY = null;
        this.jFp = -1;
        this.iLP = 0L;
        this.iLQ = 0L;
        this.iLR = 0L;
        this.iLS = 0L;
        this.jFY = frsNewAreaFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cJg() {
        this.jDV.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.jgn = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.jgn)) {
            this.jgn = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.jDW = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            Ac(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            Ac(6);
        } else {
            Ac(2);
        }
        this.jfU = new FrsViewData();
        this.jDW.gx("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.jgn));
        this.jDW.gx("client_type", "2");
        this.jDW.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jfU == null ? null : this.jfU.getThreadList(), true));
        this.jDV = new FrsNetModel<>(this.jFY.getPageContext(), this.jDW);
        this.jDV.a(this);
        this.jDV.setUniqueId(this.jFY.getUniqueId());
        if (this.jgn != null && this.jgn.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.jgn);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean cJh() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jDW), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.jDW.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jfU == null ? null : this.jfU.getThreadList(), true));
        a(frsRequestData, 3);
        return true;
    }

    public void Ab(int i) {
        if (!this.jDV.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jDW), FrsRequestData.class);
            frsRequestData.setPn(i);
            this.jDW.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jfU == null ? null : this.jfU.getThreadList(), false));
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.jFY != null && this.jFY.isAdded() && this.jFY.getPageContext() != null) {
            this.jFY.jia.yA(i);
            this.jDV.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.jgn);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(0);
            frsRequestData.setCid(0);
            com.baidu.tieba.frs.d.j.a(this.jFp, frsRequestData);
            if (com.baidu.tbadk.a.d.bjr()) {
                com.baidu.tieba.frs.d.j.a(com.baidu.tbadk.a.b.a.bjK(), frsRequestData);
                frsRequestData.Jz(com.baidu.tieba.frs.d.j.At(com.baidu.tbadk.a.b.a.bjK()));
            }
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.jFY.getPageContext().getPageActivity());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.jFY.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = av.bsS().bsT() ? 2 : 1;
            frsRequestData.setScrW(equipmentWidth);
            frsRequestData.setScrH(equipmentHeight);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.jDY);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.jgC != 0) {
                frsRequestData.setCtime((int) FrsFragment.jgC);
            }
            if (FrsFragment.jgD != 0) {
                frsRequestData.setDataSize((int) FrsFragment.jgD);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.setNetError(FrsFragment.mNetError);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            cJj();
        }
    }

    private boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.m mVar) {
        this.jfU.receiveData(mVar);
        this.jfU.frsCurrentTabId = 503;
        if (frsRequestData != null) {
            this.jDW = frsRequestData;
            this.mPn = this.jDW.getPn();
            this.jgn = this.jDW.getKw();
            this.jFY.KW(this.jgn);
            this.jFY.setFrom(this.mFrom);
            this.jFY.setPn(this.mPn);
            this.jFY.setFlag(this.mFlag);
        }
        this.jFY.jia.a(this.mType, false, this.jDX);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iQx = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.nuG = mvcSocketResponsedMessage.getDownSize();
            this.jDX = fVar;
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
            fVar.iQx = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.nuG = mvcHttpResponsedMessage.getDownSize();
            this.jDX = fVar;
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

    public void cDa() {
        if (this.jfU != null && this.jfU.getForum() != null && this.jfU.getForum().getBannerListData() != null) {
            String lastIds = this.jfU.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.jDY = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData cJi() {
        return this.jfU;
    }

    private void cJj() {
        this.iLP = System.currentTimeMillis();
        this.jDV.loadData();
    }

    public long cwH() {
        return this.iLS;
    }

    public long cwI() {
        return this.iLQ;
    }

    public long cwJ() {
        return this.iLR;
    }

    public long cwK() {
        return this.iLP;
    }

    public boolean isLoading() {
        return this.jDV.isLoading();
    }

    public void loadData() {
        cJh();
    }

    public boolean cJk() {
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

    public void Ac(int i) {
        this.jFp = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dOT();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dOU();
        }
    }

    public int cJM() {
        return this.jFp;
    }

    public void aq(cb cbVar) {
        if (cbVar != null && this.jfU != null && this.jfU.getThreadList() != null) {
            if (y.isEmpty(this.jfU.getThreadList())) {
                this.jfU.getThreadList().add(cbVar);
            } else {
                this.jfU.getThreadList().add(0, cbVar);
            }
            this.jFY.e(this.jfU);
        }
    }
}
