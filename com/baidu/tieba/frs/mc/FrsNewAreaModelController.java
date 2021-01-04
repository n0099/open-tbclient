package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.au;
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
/* loaded from: classes2.dex */
public class FrsNewAreaModelController extends BdBaseModel implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.m> {
    private long iKA;
    private long iKB;
    private long iKC;
    private long iKz;
    private FrsNetModel<FrsNewAreaFragment> jCI;
    private FrsRequestData jCJ;
    private com.baidu.tieba.tbadkCore.f jCK;
    private String jCL;
    private FrsNewAreaFragment jEM;
    private int jEc;
    private FrsViewData jeH;
    private String jfa;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsNewAreaModelController(FrsNewAreaFragment frsNewAreaFragment) {
        super(frsNewAreaFragment.getPageContext());
        this.jfa = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.jCL = null;
        this.jEc = -1;
        this.iKz = 0L;
        this.iKA = 0L;
        this.iKB = 0L;
        this.iKC = 0L;
        this.jEM = frsNewAreaFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cLD() {
        this.jCI.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.jfa = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.jfa)) {
            this.jfa = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.jCJ = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            By(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            By(6);
        } else {
            By(2);
        }
        this.jeH = new FrsViewData();
        this.jCJ.gq("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.jfa));
        this.jCJ.gq("client_type", "2");
        this.jCI = new FrsNetModel<>(this.jEM.getPageContext(), this.jCJ);
        this.jCI.a(this);
        this.jCI.setUniqueId(this.jEM.getUniqueId());
        if (this.jfa != null && this.jfa.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.jfa);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean cLE() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jCJ), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void Bt(int i) {
        if (!this.jCI.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jCJ), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.jEM != null && this.jEM.isAdded() && this.jEM.getPageContext() != null) {
            this.jEM.jgN.zW(i);
            this.jCI.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.jfa);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(0);
            frsRequestData.setCid(0);
            com.baidu.tieba.frs.d.j.a(this.jEc, frsRequestData);
            if (com.baidu.tbadk.a.d.bmY()) {
                com.baidu.tieba.frs.d.j.a(com.baidu.tbadk.a.b.a.bni(), frsRequestData);
                frsRequestData.KM(com.baidu.tieba.frs.d.j.BP(com.baidu.tbadk.a.b.a.bni()));
            }
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.jEM.getPageContext().getPageActivity());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.jEM.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = au.bwr().bws() ? 2 : 1;
            frsRequestData.setScrW(equipmentWidth);
            frsRequestData.setScrH(equipmentHeight);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.jCL);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.jfp != 0) {
                frsRequestData.setCtime((int) FrsFragment.jfp);
            }
            if (FrsFragment.jfq != 0) {
                frsRequestData.setDataSize((int) FrsFragment.jfq);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.setNetError(FrsFragment.mNetError);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            cLG();
        }
    }

    private boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.m mVar) {
        this.jeH.receiveData(mVar);
        this.jeH.frsCurrentTabId = 503;
        if (frsRequestData != null) {
            this.jCJ = frsRequestData;
            this.mPn = this.jCJ.getPn();
            this.jfa = this.jCJ.getKw();
            this.jEM.Lv(this.jfa);
            this.jEM.setFrom(this.mFrom);
            this.jEM.setPn(this.mPn);
            this.jEM.setFlag(this.mFlag);
        }
        this.jEM.jgN.a(this.mType, false, this.jCK);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iPi = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.npe = mvcSocketResponsedMessage.getDownSize();
            this.jCK = fVar;
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
            fVar.iPi = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.npe = mvcHttpResponsedMessage.getDownSize();
            this.jCK = fVar;
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

    public void cFy() {
        if (this.jeH != null && this.jeH.getForum() != null && this.jeH.getForum().getBannerListData() != null) {
            String lastIds = this.jeH.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.jCL = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData cLF() {
        return this.jeH;
    }

    private void cLG() {
        this.iKz = System.currentTimeMillis();
        this.jCI.loadData();
    }

    public long czf() {
        return this.iKC;
    }

    public long czg() {
        return this.iKA;
    }

    public long czh() {
        return this.iKB;
    }

    public long czi() {
        return this.iKz;
    }

    public boolean isLoading() {
        return this.jCI.isLoading();
    }

    public void loadData() {
        cLE();
    }

    public boolean cLH() {
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

    public void By(int i) {
        this.jEc = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dQr();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dQs();
        }
    }

    public int cMj() {
        return this.jEc;
    }

    public void ap(bz bzVar) {
        if (bzVar != null && this.jeH != null && this.jeH.getThreadList() != null) {
            if (x.isEmpty(this.jeH.getThreadList())) {
                this.jeH.getThreadList().add(bzVar);
            } else {
                this.jeH.getThreadList().add(0, bzVar);
            }
            this.jEM.e(this.jeH);
        }
    }
}
