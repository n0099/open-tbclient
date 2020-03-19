package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bj;
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
    private long fXo;
    private long fXp;
    private long fXq;
    private long fXr;
    private FrsNetModel<FrsNewAreaFragment> gGP;
    private FrsRequestData gGQ;
    private com.baidu.tieba.tbadkCore.f gGR;
    private String gGS;
    private int gIk;
    private FrsNewAreaFragment gJa;
    private FrsViewData goJ;
    private String gpb;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsNewAreaModelController(FrsNewAreaFragment frsNewAreaFragment) {
        super(frsNewAreaFragment.getPageContext());
        this.gpb = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.gGS = null;
        this.gIk = -1;
        this.fXo = 0L;
        this.fXp = 0L;
        this.fXq = 0L;
        this.fXr = 0L;
        this.gJa = frsNewAreaFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiL() {
        this.gGP.cancelLoadData();
    }

    public void ad(Bundle bundle) {
        if (bundle != null) {
            this.gpb = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.gpb)) {
            this.gpb = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.gGQ = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            tT(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            tT(6);
        } else {
            tT(2);
        }
        this.goJ = new FrsViewData();
        this.gGQ.ez("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.gpb));
        this.gGQ.ez("client_type", "2");
        this.gGP = new FrsNetModel<>(this.gJa.getPageContext(), this.gGQ);
        this.gGP.a(this);
        this.gGP.setUniqueId(this.gJa.getUniqueId());
        if (this.gpb != null && this.gpb.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.gpb);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean bIY() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gGQ), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void tP(int i) {
        if (!this.gGP.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gGQ), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.gJa != null && this.gJa.isAdded() && this.gJa.getPageContext() != null) {
            this.gJa.gqw.sI(i);
            this.gGP.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.gpb);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(0);
            frsRequestData.setCid(0);
            com.baidu.tieba.frs.f.g.a(this.gIk, frsRequestData);
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.gJa.getPageContext().getPageActivity());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.gJa.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ar.aGH().aGI() ? 2 : 1;
            frsRequestData.setScrW(equipmentWidth);
            frsRequestData.setScrH(equipmentHeight);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.gGS);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.gpp != 0) {
                frsRequestData.setCtime((int) FrsFragment.gpp);
            }
            if (FrsFragment.gpq != 0) {
                frsRequestData.setDataSize((int) FrsFragment.gpq);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.setNetError(FrsFragment.mNetError);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            bJa();
        }
    }

    private boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.m mVar) {
        this.goJ.receiveData(mVar);
        this.goJ.frsCurrentTabId = 503;
        if (frsRequestData != null) {
            this.gGQ = frsRequestData;
            this.mPn = this.gGQ.getPn();
            this.gpb = this.gGQ.getKw();
            this.gJa.BA(this.gpb);
            this.gJa.setFrom(this.mFrom);
            this.gJa.setPn(this.mPn);
            this.gJa.setFlag(this.mFlag);
        }
        this.gJa.gqw.a(this.mType, false, this.gGR);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.gak = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.kfX = mvcSocketResponsedMessage.getDownSize();
            this.gGR = fVar;
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
            fVar.gak = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.kfX = mvcHttpResponsedMessage.getDownSize();
            this.gGR = fVar;
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

    public void bEt() {
        if (this.goJ != null && this.goJ.getForum() != null && this.goJ.getForum().getBannerListData() != null) {
            String lastIds = this.goJ.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.gGS = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData bIZ() {
        return this.goJ;
    }

    private void bJa() {
        this.fXo = System.currentTimeMillis();
        this.gGP.loadData();
    }

    public long byT() {
        return this.fXr;
    }

    public long byU() {
        return this.fXp;
    }

    public long byV() {
        return this.fXq;
    }

    public long byW() {
        return this.fXo;
    }

    public boolean isLoading() {
        return this.gGP.isLoading();
    }

    public void loadData() {
        bIY();
    }

    public boolean bJb() {
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

    public void tT(int i) {
        this.gIk = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cMv();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cMw();
        }
    }

    public int bJD() {
        return this.gIk;
    }

    public void am(bj bjVar) {
        if (bjVar != null && this.goJ != null && this.goJ.getThreadList() != null) {
            if (v.isEmpty(this.goJ.getThreadList())) {
                this.goJ.getThreadList().add(bjVar);
            } else {
                this.goJ.getThreadList().add(0, bjVar);
            }
            this.gJa.e(this.goJ);
        }
    }
}
