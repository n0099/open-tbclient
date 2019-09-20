package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.bh;
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
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes4.dex */
public class FrsNewAreaModelController extends BdBaseModel implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.l> {
    private FrsNetModel<FrsNewAreaFragment> fNF;
    private FrsRequestData fNG;
    private e.b fNH;
    private String fNI;
    private int fOZ;
    private FrsNewAreaFragment fPJ;
    private long far;
    private long fas;
    private long fat;
    private long fau;
    private FrsViewData fvE;
    private String fvT;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsNewAreaModelController(FrsNewAreaFragment frsNewAreaFragment) {
        super(frsNewAreaFragment.getPageContext());
        this.fvT = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.fNI = null;
        this.fOZ = -1;
        this.far = 0L;
        this.fas = 0L;
        this.fat = 0L;
        this.fau = 0L;
        this.fPJ = frsNewAreaFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aGu() {
        this.fNF.cancelLoadData();
    }

    public void K(Bundle bundle) {
        AccountData currentAccountObj;
        if (bundle != null) {
            this.fvT = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.fvT)) {
            this.fvT = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.fNG = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            sE(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            sE(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            sE(com.baidu.tieba.frs.f.g.yf("503~" + str + this.fvT));
        }
        this.fvE = new FrsViewData();
        this.fNG.el("forum_name", com.baidu.adp.lib.util.k.bi(this.fvT));
        this.fNG.el("client_type", "2");
        this.fNF = new FrsNetModel<>(this.fPJ.getPageContext(), this.fNG);
        this.fNF.a(this);
        this.fNF.setUniqueId(this.fPJ.getUniqueId());
        if (this.fvT != null && this.fvT.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.fvT);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean brH() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fNG), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void sB(int i) {
        if (!this.fNF.pQ()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fNG), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.fPJ != null && this.fPJ.isAdded() && this.fPJ.getPageContext() != null) {
            this.fPJ.fxu.rx(i);
            this.fNF.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.fvT);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(0);
            frsRequestData.setCid(0);
            com.baidu.tieba.frs.f.g.a(this.fOZ, frsRequestData);
            int af = com.baidu.adp.lib.util.l.af(this.fPJ.getPageContext().getPageActivity());
            int ah = com.baidu.adp.lib.util.l.ah(this.fPJ.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ar.ajw().ajy() ? 2 : 1;
            frsRequestData.setScrW(af);
            frsRequestData.setScrH(ah);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.fNI);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.fwh != 0) {
                frsRequestData.setCtime((int) FrsFragment.fwh);
            }
            if (FrsFragment.fwi != 0) {
                frsRequestData.setDataSize((int) FrsFragment.fwi);
            }
            if (FrsFragment.fwj != 0) {
                frsRequestData.setNetError(FrsFragment.fwj);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            brJ();
        }
    }

    private boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.l lVar) {
        this.fvE.receiveData(lVar);
        this.fvE.frsCurrentTabId = 503;
        if (frsRequestData != null) {
            this.fNG = frsRequestData;
            this.mPn = this.fNG.getPn();
            this.fvT = this.fNG.getKw();
            this.fPJ.xS(this.fvT);
            this.fPJ.setFrom(this.mFrom);
            this.fPJ.setPn(this.mPn);
            this.fPJ.setFlag(this.mFlag);
        }
        this.fPJ.fxu.a(this.mType, false, this.fNH);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            e.b bVar = new e.b();
            bVar.fdH = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.jgm = mvcSocketResponsedMessage.getDownSize();
            this.fNH = bVar;
            FrsRequestData frsRequestData2 = null;
            com.baidu.tieba.tbadkCore.l data = mvcSocketResponsedMessage.getData();
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
            com.baidu.tbadk.core.e.a.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.l> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcHttpResponsedMessage != null) {
            e.b bVar = new e.b();
            bVar.fdH = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.jgm = mvcHttpResponsedMessage.getDownSize();
            this.fNH = bVar;
            FrsRequestData frsRequestData2 = null;
            com.baidu.tieba.tbadkCore.l data = mvcHttpResponsedMessage.getData();
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
            com.baidu.tbadk.core.e.a.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
    }

    public void bnd() {
        if (this.fvE != null && this.fvE.getForum() != null && this.fvE.getForum().getBannerListData() != null) {
            String lastIds = this.fvE.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fNI = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData brI() {
        return this.fvE;
    }

    private void brJ() {
        this.far = System.currentTimeMillis();
        this.fNF.auR();
    }

    public long bgS() {
        return this.fau;
    }

    public long bgT() {
        return this.fas;
    }

    public long bgU() {
        return this.fat;
    }

    public long bgV() {
        return this.far;
    }

    public boolean pQ() {
        return this.fNF.pQ();
    }

    public void loadData() {
        brH();
    }

    public boolean brK() {
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

    public void sE(int i) {
        AccountData currentAccountObj;
        this.fOZ = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
        }
        com.baidu.tieba.frs.f.g.az("503~" + str + this.fvT, this.fOZ);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.crx();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cry();
        }
    }

    public int bsl() {
        return this.fOZ;
    }

    public void ae(bh bhVar) {
        if (bhVar != null && this.fvE != null && this.fvE.getThreadList() != null) {
            if (v.aa(this.fvE.getThreadList())) {
                this.fvE.getThreadList().add(bhVar);
            } else {
                this.fvE.getThreadList().add(0, bhVar);
            }
            this.fPJ.e(this.fvE);
        }
    }
}
