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
/* loaded from: classes2.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.b<FrsRequestData, m> {
    private long iLP;
    private long iLQ;
    private long iLR;
    private long iLS;
    private FrsGoodFragment jDU;
    private FrsNetModel<FrsGoodFragment> jDV;
    private FrsRequestData jDW;
    private f jDX;
    private String jDY;
    private int jDZ;
    private FrsViewData jfU;
    private String jgn;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.jgn = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.jDY = null;
        this.jDZ = 0;
        this.iLP = 0L;
        this.iLQ = 0L;
        this.iLR = 0L;
        this.iLS = 0L;
        this.jDU = frsGoodFragment;
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
        this.jfU = new FrsViewData();
        this.jDW.gx("forum_name", k.getUrlEncode(this.jgn));
        this.jDW.gx("client_type", "2");
        this.jDV = new FrsNetModel<>(this.jDU.getPageContext(), this.jDW);
        this.jDV.a(this);
        this.jDV.setUniqueId(this.jDU.getUniqueId());
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
        frsRequestData.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jfU == null ? null : this.jfU.getThreadList(), true));
        a(frsRequestData, 3);
        return true;
    }

    public void bB(int i, String str) {
        if (!this.jDV.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jDW), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setAdFloorInfo(str);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.jDU != null && this.jDU.isAdded() && this.jDU.getPageContext() != null) {
            this.jDU.jia.yA(i);
            this.jDV.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.jgn);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.Jx(0);
            frsRequestData.setCid(this.jDZ);
            int equipmentWidth = l.getEquipmentWidth(this.jDU.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(this.jDU.getPageContext().getPageActivity());
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

    private boolean a(FrsRequestData frsRequestData, m mVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.jDZ) {
            this.jfU.receiveData(mVar);
            this.jfU.frsCurrentTabId = 301;
            if (frsRequestData != null) {
                this.jDW = frsRequestData;
                this.mPn = this.jDW.getPn();
                this.jgn = this.jDW.getKw();
                this.jDU.KW(this.jgn);
                this.jDU.setFrom(this.mFrom);
                this.jDU.setPn(this.mPn);
                this.jDU.setFlag(this.mFlag);
            }
            this.jDU.jia.a(this.mType, false, this.jDX);
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
            fVar.iQx = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.nuG = mvcSocketResponsedMessage.getDownSize();
            this.jDX = fVar;
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
            fVar.iQx = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.nuG = mvcHttpResponsedMessage.getDownSize();
            this.jDX = fVar;
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

    public void loadData(int i) {
        this.jDZ = i;
        cJh();
    }

    public boolean cJk() {
        return this.jDZ < 100;
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
