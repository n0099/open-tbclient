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
    private long eDB;
    private long eDC;
    private long eDD;
    private long eDE;
    private FrsViewData eYi;
    private String eYx;
    private FrsNetModel<FrsNewAreaFragment> fpG;
    private FrsRequestData fpH;
    private e.b fpI;
    private String fpJ;
    private int fqZ;
    private FrsNewAreaFragment frJ;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsNewAreaModelController(FrsNewAreaFragment frsNewAreaFragment) {
        super(frsNewAreaFragment.getPageContext());
        this.eYx = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.fpJ = null;
        this.fqZ = -1;
        this.eDB = 0L;
        this.eDC = 0L;
        this.eDD = 0L;
        this.eDE = 0L;
        this.frJ = frsNewAreaFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.fpG.cancelLoadData();
    }

    public void J(Bundle bundle) {
        AccountData currentAccountObj;
        if (bundle != null) {
            this.eYx = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.eYx)) {
            this.eYx = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.fpH = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            qY(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            qY(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + "~";
            }
            qY(com.baidu.tieba.frs.f.g.vJ("503~" + str + this.eYx));
        }
        this.eYi = new FrsViewData();
        this.fpH.dV("forum_name", com.baidu.adp.lib.util.k.bx(this.eYx));
        this.fpH.dV("client_type", "2");
        this.fpG = new FrsNetModel<>(this.frJ.getPageContext(), this.fpH);
        this.fpG.a(this);
        this.fpG.setUniqueId(this.frJ.getUniqueId());
        if (this.eYx != null && this.eYx.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.eYx);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean bhl() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fpH), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void qV(int i) {
        if (!this.fpG.qz()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fpH), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.frJ != null && this.frJ.isAdded() && this.frJ.getPageContext() != null) {
            this.frJ.eZV.pT(i);
            this.fpG.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.eYx);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(0);
            frsRequestData.setCid(0);
            com.baidu.tieba.frs.f.g.a(this.fqZ, frsRequestData);
            int aO = com.baidu.adp.lib.util.l.aO(this.frJ.getPageContext().getPageActivity());
            int aQ = com.baidu.adp.lib.util.l.aQ(this.frJ.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ar.adm().ado() ? 2 : 1;
            frsRequestData.setScrW(aO);
            frsRequestData.setScrH(aQ);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.fpJ);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.eYL != 0) {
                frsRequestData.setCtime((int) FrsFragment.eYL);
            }
            if (FrsFragment.eYM != 0) {
                frsRequestData.setDataSize((int) FrsFragment.eYM);
            }
            if (FrsFragment.eYN != 0) {
                frsRequestData.setNetError(FrsFragment.eYN);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            bhn();
        }
    }

    private boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.j jVar) {
        this.eYi.receiveData(jVar);
        this.eYi.frsCurrentTabId = 503;
        if (frsRequestData != null) {
            this.fpH = frsRequestData;
            this.mPn = this.fpH.getPn();
            this.eYx = this.fpH.getKw();
            this.frJ.vv(this.eYx);
            this.frJ.setFrom(this.mFrom);
            this.frJ.setPn(this.mPn);
            this.frJ.setFlag(this.mFlag);
        }
        this.frJ.eZV.a(this.mType, false, this.fpI);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            e.b bVar = new e.b();
            bVar.iDB = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.iDC = mvcSocketResponsedMessage.getDownSize();
            this.fpI = bVar;
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
            bVar.iDB = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.iDC = mvcHttpResponsedMessage.getDownSize();
            this.fpI = bVar;
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

    public void bcJ() {
        if (this.eYi != null && this.eYi.getForum() != null && this.eYi.getForum().getBannerListData() != null) {
            String lastIds = this.eYi.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fpJ = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData bhm() {
        return this.eYi;
    }

    private void bhn() {
        this.eDB = System.currentTimeMillis();
        this.fpG.aor();
    }

    public long aWP() {
        return this.eDE;
    }

    public long aWQ() {
        return this.eDC;
    }

    public long aWR() {
        return this.eDD;
    }

    public long aWS() {
        return this.eDB;
    }

    public boolean qz() {
        return this.fpG.qz();
    }

    public void loadData() {
        bhl();
    }

    public boolean bho() {
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

    public void qY(int i) {
        AccountData currentAccountObj;
        this.fqZ = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + "~";
        }
        com.baidu.tieba.frs.f.g.aA("503~" + str + this.eYx, this.fqZ);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cfn();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cfo();
        }
    }

    public int bhN() {
        return this.fqZ;
    }

    public void ac(bg bgVar) {
        if (bgVar != null && this.eYi != null && this.eYi.getThreadList() != null) {
            if (v.T(this.eYi.getThreadList())) {
                this.eYi.getThreadList().add(bgVar);
            } else {
                this.eYi.getThreadList().add(0, bgVar);
            }
            this.frJ.e(this.eYi);
        }
    }
}
