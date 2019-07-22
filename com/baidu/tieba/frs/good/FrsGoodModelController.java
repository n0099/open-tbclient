package com.baidu.tieba.frs.good;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.as;
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
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.j;
/* loaded from: classes4.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.b<FrsRequestData, j> {
    private long eYA;
    private long eYx;
    private long eYy;
    private long eYz;
    private boolean fKG;
    private FrsGoodFragment fLb;
    private FrsNetModel<FrsGoodFragment> fLc;
    private FrsRequestData fLd;
    private e.b fLe;
    private String fLf;
    private int fLg;
    private String ftH;
    private FrsViewData fts;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.ftH = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.fLf = null;
        this.fLg = 0;
        this.fKG = false;
        this.eYx = 0L;
        this.eYy = 0L;
        this.eYz = 0L;
        this.eYA = 0L;
        this.fLb = frsGoodFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aFO() {
        this.fLc.cancelLoadData();
    }

    public void K(Bundle bundle) {
        if (bundle != null) {
            this.ftH = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fKG = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        }
        if (TextUtils.isEmpty(this.ftH)) {
            this.ftH = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.fLd = new FrsRequestData();
        this.fts = new FrsViewData();
        this.fLd.ek("forum_name", k.bi(this.ftH));
        this.fLd.ek("client_type", "2");
        this.fLc = new FrsNetModel<>(this.fLb.getPageContext(), this.fLd);
        this.fLc.a(this);
        this.fLc.setUniqueId(this.fLb.getUniqueId());
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
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.fKG);
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
        if (this.fLb != null && this.fLb.isAdded() && this.fLb.getPageContext() != null) {
            this.fLb.fvi.rs(i);
            this.fLc.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.ftH);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.AW(this.fKG ? 1 : 0);
            if (this.fKG) {
                frsRequestData.setRn(50);
                frsRequestData.AX(50);
                frsRequestData.setIsGood(0);
            }
            frsRequestData.setCid(this.fLg);
            int af = l.af(this.fLb.getPageContext().getPageActivity());
            int ah = l.ah(this.fLb.getPageContext().getPageActivity());
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

    private boolean a(FrsRequestData frsRequestData, j jVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.fLg) {
            this.fts.receiveData(jVar);
            this.fts.frsCurrentTabId = this.fKG ? 303 : 301;
            if (frsRequestData != null) {
                this.fLd = frsRequestData;
                this.mPn = this.fLd.getPn();
                this.ftH = this.fLd.getKw();
                this.fLb.xs(this.ftH);
                this.fLb.setFrom(this.mFrom);
                this.fLb.setPn(this.mPn);
                this.fLb.setFlag(this.mFlag);
            }
            this.fLb.fvi.a(this.mType, false, this.fLe);
            this.mSource = null;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, j> mvcSocketMessage, MvcNetMessage<FrsRequestData, j> mvcNetMessage) {
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
            j data = mvcSocketResponsedMessage.getData();
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
    public void a(MvcHttpResponsedMessage<j> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, j> mvcHttpMessage, MvcNetMessage<FrsRequestData, j> mvcNetMessage) {
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
            j data = mvcHttpResponsedMessage.getData();
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

    public void nc(int i) {
        this.fLg = i;
        bqJ();
    }

    public boolean bqM() {
        return this.fLg < 100;
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
