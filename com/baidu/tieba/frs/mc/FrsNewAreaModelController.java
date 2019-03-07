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
    private long eDT;
    private long eDU;
    private long eDV;
    private long eDW;
    private String eYL;
    private FrsViewData eYw;
    private FrsNetModel<FrsNewAreaFragment> fpV;
    private FrsRequestData fpW;
    private e.b fpX;
    private String fpY;
    private FrsNewAreaFragment frY;
    private int fro;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsNewAreaModelController(FrsNewAreaFragment frsNewAreaFragment) {
        super(frsNewAreaFragment.getPageContext());
        this.eYL = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.fpY = null;
        this.fro = -1;
        this.eDT = 0L;
        this.eDU = 0L;
        this.eDV = 0L;
        this.eDW = 0L;
        this.frY = frsNewAreaFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.fpV.cancelLoadData();
    }

    public void J(Bundle bundle) {
        AccountData currentAccountObj;
        if (bundle != null) {
            this.eYL = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.eYL)) {
            this.eYL = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.fpW = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            rc(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            rc(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + "~";
            }
            rc(com.baidu.tieba.frs.f.g.vL("503~" + str + this.eYL));
        }
        this.eYw = new FrsViewData();
        this.fpW.dV("forum_name", com.baidu.adp.lib.util.k.bx(this.eYL));
        this.fpW.dV("client_type", "2");
        this.fpV = new FrsNetModel<>(this.frY.getPageContext(), this.fpW);
        this.fpV.a(this);
        this.fpV.setUniqueId(this.frY.getUniqueId());
        if (this.eYL != null && this.eYL.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.eYL);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean bhn() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fpW), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void qZ(int i) {
        if (!this.fpV.qz()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fpW), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.frY != null && this.frY.isAdded() && this.frY.getPageContext() != null) {
            this.frY.faj.pX(i);
            this.fpV.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.eYL);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(0);
            frsRequestData.setCid(0);
            com.baidu.tieba.frs.f.g.a(this.fro, frsRequestData);
            int aO = com.baidu.adp.lib.util.l.aO(this.frY.getPageContext().getPageActivity());
            int aQ = com.baidu.adp.lib.util.l.aQ(this.frY.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ar.adp().adr() ? 2 : 1;
            frsRequestData.setScrW(aO);
            frsRequestData.setScrH(aQ);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.fpY);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.eYZ != 0) {
                frsRequestData.setCtime((int) FrsFragment.eYZ);
            }
            if (FrsFragment.eZa != 0) {
                frsRequestData.setDataSize((int) FrsFragment.eZa);
            }
            if (FrsFragment.eZb != 0) {
                frsRequestData.setNetError(FrsFragment.eZb);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            bhp();
        }
    }

    private boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.j jVar) {
        this.eYw.receiveData(jVar);
        this.eYw.frsCurrentTabId = 503;
        if (frsRequestData != null) {
            this.fpW = frsRequestData;
            this.mPn = this.fpW.getPn();
            this.eYL = this.fpW.getKw();
            this.frY.vx(this.eYL);
            this.frY.setFrom(this.mFrom);
            this.frY.setPn(this.mPn);
            this.frY.setFlag(this.mFlag);
        }
        this.frY.faj.a(this.mType, false, this.fpX);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            e.b bVar = new e.b();
            bVar.iDX = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.iDY = mvcSocketResponsedMessage.getDownSize();
            this.fpX = bVar;
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
            bVar.iDX = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.iDY = mvcHttpResponsedMessage.getDownSize();
            this.fpX = bVar;
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
        if (this.eYw != null && this.eYw.getForum() != null && this.eYw.getForum().getBannerListData() != null) {
            String lastIds = this.eYw.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fpY = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData bho() {
        return this.eYw;
    }

    private void bhp() {
        this.eDT = System.currentTimeMillis();
        this.fpV.aov();
    }

    public long aWR() {
        return this.eDW;
    }

    public long aWS() {
        return this.eDU;
    }

    public long aWT() {
        return this.eDV;
    }

    public long aWU() {
        return this.eDT;
    }

    public boolean qz() {
        return this.fpV.qz();
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
        this.fro = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + "~";
        }
        com.baidu.tieba.frs.f.g.aA("503~" + str + this.eYL, this.fro);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cfo();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cfp();
        }
    }

    public int bhP() {
        return this.fro;
    }

    public void ad(bg bgVar) {
        if (bgVar != null && this.eYw != null && this.eYw.getThreadList() != null) {
            if (v.T(this.eYw.getThreadList())) {
                this.eYw.getThreadList().add(bgVar);
            } else {
                this.eYw.getThreadList().add(0, bgVar);
            }
            this.frY.e(this.eYw);
        }
    }
}
