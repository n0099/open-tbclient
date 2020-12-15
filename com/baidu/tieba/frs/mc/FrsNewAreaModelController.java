package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes22.dex */
public class FrsNewAreaModelController extends BdBaseModel implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.m> {
    private String iSP;
    private FrsViewData iSv;
    private long iym;
    private long iyn;
    private long iyo;
    private long iyp;
    private FrsNetModel<FrsNewAreaFragment> jqm;
    private FrsRequestData jqn;
    private com.baidu.tieba.tbadkCore.f jqo;
    private String jqp;
    private int jrG;
    private FrsNewAreaFragment jsr;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsNewAreaModelController(FrsNewAreaFragment frsNewAreaFragment) {
        super(frsNewAreaFragment.getPageContext());
        this.iSP = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.jqp = null;
        this.jrG = -1;
        this.iym = 0L;
        this.iyn = 0L;
        this.iyo = 0L;
        this.iyp = 0L;
        this.jsr = frsNewAreaFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cID() {
        this.jqm.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.iSP = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.iSP)) {
            this.iSP = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.jqn = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            Bm(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            Bm(6);
        } else {
            Bm(2);
        }
        this.iSv = new FrsViewData();
        this.jqn.gt("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.iSP));
        this.jqn.gt("client_type", "2");
        this.jqm = new FrsNetModel<>(this.jsr.getPageContext(), this.jqn);
        this.jqm.a(this);
        this.jqm.setUniqueId(this.jsr.getUniqueId());
        if (this.iSP != null && this.iSP.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.iSP);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean cIE() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jqn), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void Bh(int i) {
        if (!this.jqm.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jqn), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.jsr != null && this.jsr.isAdded() && this.jsr.getPageContext() != null) {
            this.jsr.iUB.zJ(i);
            this.jqm.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.iSP);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(0);
            frsRequestData.setCid(0);
            com.baidu.tieba.frs.f.j.a(this.jrG, frsRequestData);
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.jsr.getPageContext().getPageActivity());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.jsr.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = av.btX().btY() ? 2 : 1;
            frsRequestData.setScrW(equipmentWidth);
            frsRequestData.setScrH(equipmentHeight);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.jqp);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.iTe != 0) {
                frsRequestData.setCtime((int) FrsFragment.iTe);
            }
            if (FrsFragment.iTf != 0) {
                frsRequestData.setDataSize((int) FrsFragment.iTf);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.setNetError(FrsFragment.mNetError);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            cIG();
        }
    }

    private boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.m mVar) {
        this.iSv.receiveData(mVar);
        this.iSv.frsCurrentTabId = 503;
        if (frsRequestData != null) {
            this.jqn = frsRequestData;
            this.mPn = this.jqn.getPn();
            this.iSP = this.jqn.getKw();
            this.jsr.Lv(this.iSP);
            this.jsr.setFrom(this.mFrom);
            this.jsr.setPn(this.mPn);
            this.jsr.setFlag(this.mFlag);
        }
        this.jsr.iUB.a(this.mType, false, this.jqo);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iCW = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.njx = mvcSocketResponsedMessage.getDownSize();
            this.jqo = fVar;
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
            fVar.iCW = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.njx = mvcHttpResponsedMessage.getDownSize();
            this.jqo = fVar;
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

    public void cCE() {
        if (this.iSv != null && this.iSv.getForum() != null && this.iSv.getForum().getBannerListData() != null) {
            String lastIds = this.iSv.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.jqp = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData cIF() {
        return this.iSv;
    }

    private void cIG() {
        this.iym = System.currentTimeMillis();
        this.jqm.loadData();
    }

    public long cwm() {
        return this.iyp;
    }

    public long cwn() {
        return this.iyn;
    }

    public long cwo() {
        return this.iyo;
    }

    public long cwp() {
        return this.iym;
    }

    public boolean isLoading() {
        return this.jqm.isLoading();
    }

    public void loadData() {
        cIE();
    }

    public boolean cIH() {
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

    public void Bm(int i) {
        this.jrG = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dQv();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dQw();
        }
    }

    public int cJj() {
        return this.jrG;
    }

    public void ap(by byVar) {
        if (byVar != null && this.iSv != null && this.iSv.getThreadList() != null) {
            if (y.isEmpty(this.iSv.getThreadList())) {
                this.iSv.getThreadList().add(byVar);
            } else {
                this.iSv.getThreadList().add(0, byVar);
            }
            this.jsr.e(this.iSv);
        }
    }
}
