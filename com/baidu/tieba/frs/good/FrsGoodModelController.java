package com.baidu.tieba.frs.good;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.av;
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
    private String iSP;
    private FrsViewData iSv;
    private long iym;
    private long iyn;
    private long iyo;
    private long iyp;
    private FrsGoodFragment jql;
    private FrsNetModel<FrsGoodFragment> jqm;
    private FrsRequestData jqn;
    private f jqo;
    private String jqp;
    private int jqq;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.iSP = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.jqp = null;
        this.jqq = 0;
        this.iym = 0L;
        this.iyn = 0L;
        this.iyo = 0L;
        this.iyp = 0L;
        this.jql = frsGoodFragment;
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
        this.iSv = new FrsViewData();
        this.jqn.gt("forum_name", k.getUrlEncode(this.iSP));
        this.jqn.gt("client_type", "2");
        this.jqm = new FrsNetModel<>(this.jql.getPageContext(), this.jqn);
        this.jqm.a(this);
        this.jqm.setUniqueId(this.jql.getUniqueId());
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
        if (this.jql != null && this.jql.isAdded() && this.jql.getPageContext() != null) {
            this.jql.iUB.zJ(i);
            this.jqm.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.iSP);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.KP(0);
            frsRequestData.setCid(this.jqq);
            int equipmentWidth = l.getEquipmentWidth(this.jql.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(this.jql.getPageContext().getPageActivity());
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

    private boolean a(FrsRequestData frsRequestData, m mVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.jqq) {
            this.iSv.receiveData(mVar);
            this.iSv.frsCurrentTabId = 301;
            if (frsRequestData != null) {
                this.jqn = frsRequestData;
                this.mPn = this.jqn.getPn();
                this.iSP = this.jqn.getKw();
                this.jql.Lv(this.iSP);
                this.jql.setFrom(this.mFrom);
                this.jql.setPn(this.mPn);
                this.jql.setFlag(this.mFlag);
            }
            this.jql.iUB.a(this.mType, false, this.jqo);
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
            fVar.iCW = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.njx = mvcSocketResponsedMessage.getDownSize();
            this.jqo = fVar;
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
            fVar.iCW = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.njx = mvcHttpResponsedMessage.getDownSize();
            this.jqo = fVar;
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

    public void uY(int i) {
        this.jqq = i;
        cIE();
    }

    public boolean cIH() {
        return this.jqq < 100;
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
