package com.baidu.tieba.frs.good;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.at;
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
/* loaded from: classes16.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.b<FrsRequestData, m> {
    private FrsViewData hEX;
    private String hFr;
    private FrsGoodFragment hZa;
    private FrsNetModel<FrsGoodFragment> hZb;
    private FrsRequestData hZc;
    private f hZd;
    private String hZe;
    private int hZf;
    private long hll;
    private long hlm;
    private long hln;
    private long hlo;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.hFr = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.hZe = null;
        this.hZf = 0;
        this.hll = 0L;
        this.hlm = 0L;
        this.hln = 0L;
        this.hlo = 0L;
        this.hZa = frsGoodFragment;
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
        this.hEX = new FrsViewData();
        this.hZc.fy("forum_name", k.getUrlEncode(this.hFr));
        this.hZc.fy("client_type", "2");
        this.hZb = new FrsNetModel<>(this.hZa.getPageContext(), this.hZc);
        this.hZb.a(this);
        this.hZb.setUniqueId(this.hZa.getUniqueId());
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
        if (this.hZa != null && this.hZa.isAdded() && this.hZa.getPageContext() != null) {
            this.hZa.hHd.uG(i);
            this.hZb.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.hFr);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.Fm(0);
            frsRequestData.setCid(this.hZf);
            int equipmentWidth = l.getEquipmentWidth(this.hZa.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(this.hZa.getPageContext().getPageActivity());
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

    private boolean a(FrsRequestData frsRequestData, m mVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.hZf) {
            this.hEX.receiveData(mVar);
            this.hEX.frsCurrentTabId = 301;
            if (frsRequestData != null) {
                this.hZc = frsRequestData;
                this.mPn = this.hZc.getPn();
                this.hFr = this.hZc.getKw();
                this.hZa.Gj(this.hFr);
                this.hZa.setFrom(this.mFrom);
                this.hZa.setPn(this.mPn);
                this.hZa.setFlag(this.mFlag);
            }
            this.hZa.hHd.a(this.mType, false, this.hZd);
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
            fVar.hpV = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.lKP = mvcSocketResponsedMessage.getDownSize();
            this.hZd = fVar;
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
            fVar.hpV = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.lKP = mvcHttpResponsedMessage.getDownSize();
            this.hZd = fVar;
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

    public void qr(int i) {
        this.hZf = i;
        cgM();
    }

    public boolean cgP() {
        return this.hZf < 100;
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
