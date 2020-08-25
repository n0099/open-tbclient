package com.baidu.tieba.frs.good;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.au;
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
    private String hSH;
    private FrsViewData hSn;
    private long hyc;
    private long hyd;
    private long hye;
    private long hyf;
    private FrsGoodFragment ink;
    private FrsNetModel<FrsGoodFragment> inl;
    private FrsRequestData inm;
    private f inn;
    private String ino;
    private int inp;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.hSH = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.ino = null;
        this.inp = 0;
        this.hyc = 0L;
        this.hyd = 0L;
        this.hye = 0L;
        this.hyf = 0L;
        this.ink = frsGoodFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void crq() {
        this.inl.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.hSH = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.hSH)) {
            this.hSH = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.inm = new FrsRequestData();
        this.hSn = new FrsViewData();
        this.inm.fP("forum_name", k.getUrlEncode(this.hSH));
        this.inm.fP("client_type", "2");
        this.inl = new FrsNetModel<>(this.ink.getPageContext(), this.inm);
        this.inl.a(this);
        this.inl.setUniqueId(this.ink.getUniqueId());
        if (this.hSH != null && this.hSH.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.hSH);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean crr() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.inm), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void yk(int i) {
        if (!this.inl.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.inm), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.ink != null && this.ink.isAdded() && this.ink.getPageContext() != null) {
            this.ink.hUt.wV(i);
            this.inl.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.hSH);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.HJ(0);
            frsRequestData.setCid(this.inp);
            int equipmentWidth = l.getEquipmentWidth(this.ink.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(this.ink.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = au.bjr().bjs() ? 2 : 1;
            frsRequestData.setScrW(equipmentWidth);
            frsRequestData.setScrH(equipmentHeight);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.ino);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.hSW != 0) {
                frsRequestData.setCtime((int) FrsFragment.hSW);
            }
            if (FrsFragment.hSX != 0) {
                frsRequestData.setDataSize((int) FrsFragment.hSX);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.setNetError(FrsFragment.mNetError);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            crt();
        }
    }

    private boolean a(FrsRequestData frsRequestData, m mVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.inp) {
            this.hSn.receiveData(mVar);
            this.hSn.frsCurrentTabId = 301;
            if (frsRequestData != null) {
                this.inm = frsRequestData;
                this.mPn = this.inm.getPn();
                this.hSH = this.inm.getKw();
                this.ink.IL(this.hSH);
                this.ink.setFrom(this.mFrom);
                this.ink.setPn(this.mPn);
                this.ink.setFlag(this.mFlag);
            }
            this.ink.hUt.a(this.mType, false, this.inn);
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
            fVar.hCM = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.mcA = mvcSocketResponsedMessage.getDownSize();
            this.inn = fVar;
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
            fVar.hCM = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.mcA = mvcHttpResponsedMessage.getDownSize();
            this.inn = fVar;
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

    public void cmq() {
        if (this.hSn != null && this.hSn.getForum() != null && this.hSn.getForum().getBannerListData() != null) {
            String lastIds = this.hSn.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.ino = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData crs() {
        return this.hSn;
    }

    private void crt() {
        this.hyc = System.currentTimeMillis();
        this.inl.loadData();
    }

    public long cfX() {
        return this.hyf;
    }

    public long cfY() {
        return this.hyd;
    }

    public long cfZ() {
        return this.hye;
    }

    public long cga() {
        return this.hyc;
    }

    public boolean isLoading() {
        return this.inl.isLoading();
    }

    public void sD(int i) {
        this.inp = i;
        crr();
    }

    public boolean cru() {
        return this.inp < 100;
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
