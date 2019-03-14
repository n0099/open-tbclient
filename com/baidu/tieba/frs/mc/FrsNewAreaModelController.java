package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.bg;
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
import com.baidu.tieba.tbadkCore.e;
/* loaded from: classes4.dex */
public class FrsNewAreaModelController extends BdBaseModel implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.j> {
    private long eDP;
    private long eDQ;
    private long eDR;
    private long eDS;
    private String eYK;
    private FrsViewData eYv;
    private FrsNetModel<FrsNewAreaFragment> fpU;
    private FrsRequestData fpV;
    private e.b fpW;
    private String fpX;
    private FrsNewAreaFragment frX;
    private int frn;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsNewAreaModelController(FrsNewAreaFragment frsNewAreaFragment) {
        super(frsNewAreaFragment.getPageContext());
        this.eYK = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.fpX = null;
        this.frn = -1;
        this.eDP = 0L;
        this.eDQ = 0L;
        this.eDR = 0L;
        this.eDS = 0L;
        this.frX = frsNewAreaFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.fpU.cancelLoadData();
    }

    public void J(Bundle bundle) {
        AccountData currentAccountObj;
        if (bundle != null) {
            this.eYK = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.eYK)) {
            this.eYK = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.fpV = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            rc(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            rc(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + "~";
            }
            rc(com.baidu.tieba.frs.f.g.vK("503~" + str + this.eYK));
        }
        this.eYv = new FrsViewData();
        this.fpV.dU("forum_name", com.baidu.adp.lib.util.k.bx(this.eYK));
        this.fpV.dU("client_type", "2");
        this.fpU = new FrsNetModel<>(this.frX.getPageContext(), this.fpV);
        this.fpU.a(this);
        this.fpU.setUniqueId(this.frX.getUniqueId());
        if (this.eYK != null && this.eYK.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.eYK);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean bhn() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fpV), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void qZ(int i) {
        if (!this.fpU.qz()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fpV), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.frX != null && this.frX.isAdded() && this.frX.getPageContext() != null) {
            this.frX.fai.pX(i);
            this.fpU.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.eYK);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(0);
            frsRequestData.setCid(0);
            com.baidu.tieba.frs.f.g.a(this.frn, frsRequestData);
            int aO = com.baidu.adp.lib.util.l.aO(this.frX.getPageContext().getPageActivity());
            int aQ = com.baidu.adp.lib.util.l.aQ(this.frX.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ar.adp().adr() ? 2 : 1;
            frsRequestData.setScrW(aO);
            frsRequestData.setScrH(aQ);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.fpX);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.eYY != 0) {
                frsRequestData.setCtime((int) FrsFragment.eYY);
            }
            if (FrsFragment.eYZ != 0) {
                frsRequestData.setDataSize((int) FrsFragment.eYZ);
            }
            if (FrsFragment.eZa != 0) {
                frsRequestData.setNetError(FrsFragment.eZa);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            bhp();
        }
    }

    private boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.j jVar) {
        this.eYv.receiveData(jVar);
        this.eYv.frsCurrentTabId = 503;
        if (frsRequestData != null) {
            this.fpV = frsRequestData;
            this.mPn = this.fpV.getPn();
            this.eYK = this.fpV.getKw();
            this.frX.vw(this.eYK);
            this.frX.setFrom(this.mFrom);
            this.frX.setPn(this.mPn);
            this.frX.setFlag(this.mFlag);
        }
        this.frX.fai.a(this.mType, false, this.fpW);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            e.b bVar = new e.b();
            bVar.iDQ = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.iDR = mvcSocketResponsedMessage.getDownSize();
            this.fpW = bVar;
            FrsRequestData frsRequestData2 = null;
            com.baidu.tieba.tbadkCore.j data = mvcSocketResponsedMessage.getData();
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
            objArr[2] = "seq_id";
            objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
            com.baidu.tbadk.core.d.a.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.j> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcHttpResponsedMessage != null) {
            e.b bVar = new e.b();
            bVar.iDQ = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.iDR = mvcHttpResponsedMessage.getDownSize();
            this.fpW = bVar;
            FrsRequestData frsRequestData2 = null;
            com.baidu.tieba.tbadkCore.j data = mvcHttpResponsedMessage.getData();
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

    public void bcL() {
        if (this.eYv != null && this.eYv.getForum() != null && this.eYv.getForum().getBannerListData() != null) {
            String lastIds = this.eYv.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fpX = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData bho() {
        return this.eYv;
    }

    private void bhp() {
        this.eDP = System.currentTimeMillis();
        this.fpU.aou();
    }

    public long aWR() {
        return this.eDS;
    }

    public long aWS() {
        return this.eDQ;
    }

    public long aWT() {
        return this.eDR;
    }

    public long aWU() {
        return this.eDP;
    }

    public boolean qz() {
        return this.fpU.qz();
    }

    public void loadData() {
        bhn();
    }

    public boolean bhq() {
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

    public void rc(int i) {
        AccountData currentAccountObj;
        this.frn = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + "~";
        }
        com.baidu.tieba.frs.f.g.aA("503~" + str + this.eYK, this.frn);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cfr();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cfs();
        }
    }

    public int bhP() {
        return this.frn;
    }

    public void ad(bg bgVar) {
        if (bgVar != null && this.eYv != null && this.eYv.getThreadList() != null) {
            if (v.T(this.eYv.getThreadList())) {
                this.eYv.getThreadList().add(bgVar);
            } else {
                this.eYv.getThreadList().add(0, bgVar);
            }
            this.frX.e(this.eYv);
        }
    }
}
