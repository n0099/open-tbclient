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
    private long iLB;
    private long iLC;
    private long iLD;
    private long iLE;
    private FrsNetModel<FrsNewAreaFragment> jDH;
    private FrsRequestData jDI;
    private com.baidu.tieba.tbadkCore.f jDJ;
    private String jDK;
    private FrsNewAreaFragment jFK;
    private int jFb;
    private FrsViewData jfG;
    private String jfZ;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsNewAreaModelController(FrsNewAreaFragment frsNewAreaFragment) {
        super(frsNewAreaFragment.getPageContext());
        this.jfZ = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.jDK = null;
        this.jFb = -1;
        this.iLB = 0L;
        this.iLC = 0L;
        this.iLD = 0L;
        this.iLE = 0L;
        this.jFK = frsNewAreaFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cIZ() {
        this.jDH.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.jfZ = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.jfZ)) {
            this.jfZ = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.jDI = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            Ac(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            Ac(6);
        } else {
            Ac(2);
        }
        this.jfG = new FrsViewData();
        this.jDI.gv("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.jfZ));
        this.jDI.gv("client_type", "2");
        this.jDI.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jfG == null ? null : this.jfG.getThreadList(), true));
        this.jDH = new FrsNetModel<>(this.jFK.getPageContext(), this.jDI);
        this.jDH.a(this);
        this.jDH.setUniqueId(this.jFK.getUniqueId());
        if (this.jfZ != null && this.jfZ.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.jfZ);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean cJa() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jDI), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.jDI.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jfG == null ? null : this.jfG.getThreadList(), true));
        a(frsRequestData, 3);
        return true;
    }

    public void Ab(int i) {
        if (!this.jDH.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jDI), FrsRequestData.class);
            frsRequestData.setPn(i);
            this.jDI.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jfG == null ? null : this.jfG.getThreadList(), false));
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.jFK != null && this.jFK.isAdded() && this.jFK.getPageContext() != null) {
            this.jFK.jhM.yA(i);
            this.jDH.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.jfZ);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(0);
            frsRequestData.setCid(0);
            com.baidu.tieba.frs.d.j.a(this.jFb, frsRequestData);
            if (com.baidu.tbadk.a.d.bjr()) {
                com.baidu.tieba.frs.d.j.a(com.baidu.tbadk.a.b.a.bjK(), frsRequestData);
                frsRequestData.Jz(com.baidu.tieba.frs.d.j.At(com.baidu.tbadk.a.b.a.bjK()));
            }
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.jFK.getPageContext().getPageActivity());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.jFK.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = av.bsS().bsT() ? 2 : 1;
            frsRequestData.setScrW(equipmentWidth);
            frsRequestData.setScrH(equipmentHeight);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.jDK);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.jgo != 0) {
                frsRequestData.setCtime((int) FrsFragment.jgo);
            }
            if (FrsFragment.jgp != 0) {
                frsRequestData.setDataSize((int) FrsFragment.jgp);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.setNetError(FrsFragment.mNetError);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            cJc();
        }
    }

    private boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.m mVar) {
        this.jfG.receiveData(mVar);
        this.jfG.frsCurrentTabId = 503;
        if (frsRequestData != null) {
            this.jDI = frsRequestData;
            this.mPn = this.jDI.getPn();
            this.jfZ = this.jDI.getKw();
            this.jFK.KV(this.jfZ);
            this.jFK.setFrom(this.mFrom);
            this.jFK.setPn(this.mPn);
            this.jFK.setFlag(this.mFlag);
        }
        this.jFK.jhM.a(this.mType, false, this.jDJ);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iQj = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.nuf = mvcSocketResponsedMessage.getDownSize();
            this.jDJ = fVar;
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
            fVar.iQj = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.nuf = mvcHttpResponsedMessage.getDownSize();
            this.jDJ = fVar;
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

    public void cCT() {
        if (this.jfG != null && this.jfG.getForum() != null && this.jfG.getForum().getBannerListData() != null) {
            String lastIds = this.jfG.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.jDK = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData cJb() {
        return this.jfG;
    }

    private void cJc() {
        this.iLB = System.currentTimeMillis();
        this.jDH.loadData();
    }

    public long cwA() {
        return this.iLE;
    }

    public long cwB() {
        return this.iLC;
    }

    public long cwC() {
        return this.iLD;
    }

    public long cwD() {
        return this.iLB;
    }

    public boolean isLoading() {
        return this.jDH.isLoading();
    }

    public void loadData() {
        cJa();
    }

    public boolean cJd() {
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
        this.jFb = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dOL();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dOM();
        }
    }

    public int cJF() {
        return this.jFb;
    }

    public void aq(cb cbVar) {
        if (cbVar != null && this.jfG != null && this.jfG.getThreadList() != null) {
            if (y.isEmpty(this.jfG.getThreadList())) {
                this.jfG.getThreadList().add(cbVar);
            } else {
                this.jfG.getThreadList().add(0, cbVar);
            }
            this.jFK.e(this.jfG);
        }
    }
}
