package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.as;
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
public class FrsNewAreaModelController extends BdBaseModel implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.j> {
    private long eYA;
    private long eYx;
    private long eYy;
    private long eYz;
    private FrsNetModel<FrsNewAreaFragment> fLc;
    private FrsRequestData fLd;
    private e.b fLe;
    private String fLf;
    private int fMw;
    private FrsNewAreaFragment fNf;
    private String ftH;
    private FrsViewData fts;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsNewAreaModelController(FrsNewAreaFragment frsNewAreaFragment) {
        super(frsNewAreaFragment.getPageContext());
        this.ftH = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.fLf = null;
        this.fMw = -1;
        this.eYx = 0L;
        this.eYy = 0L;
        this.eYz = 0L;
        this.eYA = 0L;
        this.fNf = frsNewAreaFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aFO() {
        this.fLc.cancelLoadData();
    }

    public void K(Bundle bundle) {
        AccountData currentAccountObj;
        if (bundle != null) {
            this.ftH = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.ftH)) {
            this.ftH = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.fLd = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            sy(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            sy(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            sy(com.baidu.tieba.frs.f.g.xF("503~" + str + this.ftH));
        }
        this.fts = new FrsViewData();
        this.fLd.ek("forum_name", com.baidu.adp.lib.util.k.bi(this.ftH));
        this.fLd.ek("client_type", "2");
        this.fLc = new FrsNetModel<>(this.fNf.getPageContext(), this.fLd);
        this.fLc.a(this);
        this.fLc.setUniqueId(this.fNf.getUniqueId());
        if (this.ftH != null && this.ftH.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.ftH);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean bqJ() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fLd), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void sv(int i) {
        if (!this.fLc.pP()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fLd), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.fNf != null && this.fNf.isAdded() && this.fNf.getPageContext() != null) {
            this.fNf.fvi.rs(i);
            this.fLc.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.ftH);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(0);
            frsRequestData.setCid(0);
            com.baidu.tieba.frs.f.g.a(this.fMw, frsRequestData);
            int af = com.baidu.adp.lib.util.l.af(this.fNf.getPageContext().getPageActivity());
            int ah = com.baidu.adp.lib.util.l.ah(this.fNf.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = as.ajo().ajq() ? 2 : 1;
            frsRequestData.setScrW(af);
            frsRequestData.setScrH(ah);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.fLf);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.ftV != 0) {
                frsRequestData.setCtime((int) FrsFragment.ftV);
            }
            if (FrsFragment.ftW != 0) {
                frsRequestData.setDataSize((int) FrsFragment.ftW);
            }
            if (FrsFragment.ftX != 0) {
                frsRequestData.setNetError(FrsFragment.ftX);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            bqL();
        }
    }

    private boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.j jVar) {
        this.fts.receiveData(jVar);
        this.fts.frsCurrentTabId = 503;
        if (frsRequestData != null) {
            this.fLd = frsRequestData;
            this.mPn = this.fLd.getPn();
            this.ftH = this.fLd.getKw();
            this.fNf.xs(this.ftH);
            this.fNf.setFrom(this.mFrom);
            this.fNf.setPn(this.mPn);
            this.fNf.setFlag(this.mFlag);
        }
        this.fNf.fvi.a(this.mType, false, this.fLe);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            e.b bVar = new e.b();
            bVar.fbG = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.jcN = mvcSocketResponsedMessage.getDownSize();
            this.fLe = bVar;
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
            com.baidu.tbadk.core.e.a.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.j> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcHttpResponsedMessage != null) {
            e.b bVar = new e.b();
            bVar.fbG = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.jcN = mvcHttpResponsedMessage.getDownSize();
            this.fLe = bVar;
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
            com.baidu.tbadk.core.e.a.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
    }

    public void bmi() {
        if (this.fts != null && this.fts.getForum() != null && this.fts.getForum().getBannerListData() != null) {
            String lastIds = this.fts.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fLf = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData bqK() {
        return this.fts;
    }

    private void bqL() {
        this.eYx = System.currentTimeMillis();
        this.fLc.auD();
    }

    public long bgj() {
        return this.eYA;
    }

    public long bgk() {
        return this.eYy;
    }

    public long bgl() {
        return this.eYz;
    }

    public long bgm() {
        return this.eYx;
    }

    public boolean pP() {
        return this.fLc.pP();
    }

    public void loadData() {
        bqJ();
    }

    public boolean bqM() {
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

    public void sy(int i) {
        AccountData currentAccountObj;
        this.fMw = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
        }
        com.baidu.tieba.frs.f.g.ax("503~" + str + this.ftH, this.fMw);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cqn();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cqo();
        }
    }

    public int brm() {
        return this.fMw;
    }

    public void ac(bg bgVar) {
        if (bgVar != null && this.fts != null && this.fts.getThreadList() != null) {
            if (v.aa(this.fts.getThreadList())) {
                this.fts.getThreadList().add(bgVar);
            } else {
                this.fts.getThreadList().add(0, bgVar);
            }
            this.fNf.e(this.fts);
        }
    }
}
