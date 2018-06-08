package com.baidu.tieba.frs.good;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.i;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes2.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.b<FrsRequestData, i> {
    private long cSN;
    private long cSO;
    private long cSP;
    private long cSQ;
    private l dhf;
    private String dhv;
    private d.a dmV;
    private FrsNetModel<FrsGoodFragment> dwA;
    private FrsRequestData dwB;
    private String dwC;
    private int dwD;
    private FrsGoodFragment dwz;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.dhv = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.dwC = null;
        this.dwD = 0;
        this.cSN = 0L;
        this.cSO = 0L;
        this.cSP = 0L;
        this.cSQ = 0L;
        this.dwz = frsGoodFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.dwA.cancelLoadData();
    }

    public void i(Bundle bundle) {
        if (bundle != null) {
            this.dhv = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.dhv)) {
            this.dhv = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.dwB = new FrsRequestData();
        this.dhf = new l();
        this.dwA = new FrsNetModel<>(this.dwz.getPageContext(), this.dwB);
        this.dwA.a(this);
        this.dwA.setUniqueId(getUniqueId());
        if (this.dhv != null && this.dhv.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dhv);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean avn() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dwB), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void kX(int i) {
        if (!this.dwA.Ax()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dwB), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.dwz != null && this.dwz.isAdded() && this.dwz.getPageContext() != null) {
            this.dwz.diG.kf(i);
            this.dwA.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.dhv);
            if (com.baidu.tbadk.core.i.tt().tz()) {
                frsRequestData.setRn(35);
            } else {
                frsRequestData.setRn(50);
            }
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.setCid(this.dwD);
            int ah = com.baidu.adp.lib.util.l.ah(this.dwz.getPageContext().getPageActivity());
            int aj = com.baidu.adp.lib.util.l.aj(this.dwz.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = aq.zq().zs() ? 2 : 1;
            frsRequestData.setScrW(ah);
            frsRequestData.setScrH(aj);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.dwC);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.dhE != 0) {
                frsRequestData.setCtime((int) FrsFragment.dhE);
            }
            if (FrsFragment.dhF != 0) {
                frsRequestData.setDataSize((int) FrsFragment.dhF);
            }
            if (FrsFragment.dhG != 0) {
                frsRequestData.setNetError(FrsFragment.dhG);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            axW();
        }
    }

    private boolean a(FrsRequestData frsRequestData, i iVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.dwD) {
            this.dhf.e(iVar);
            if (frsRequestData != null) {
                this.dwB = frsRequestData;
                this.mPn = this.dwB.getPn();
                this.dhv = this.dwB.getKw();
                this.dwz.mS(this.dhv);
                this.dwz.setFrom(this.mFrom);
                this.dwz.setPn(this.mPn);
                this.dwz.setFlag(this.mFlag);
            }
            this.dwz.diG.a(this.mType, false, this.dmV);
            this.mSource = null;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, i> mvcSocketMessage, MvcNetMessage<FrsRequestData, i> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            d.a aVar = new d.a();
            aVar.gFM = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            aVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            aVar.errorCode = mvcSocketResponsedMessage.getError();
            aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            aVar.gFN = mvcSocketResponsedMessage.getDownSize();
            this.dmV = aVar;
            FrsRequestData frsRequestData2 = null;
            i data = mvcSocketResponsedMessage.getData();
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
    public void a(MvcHttpResponsedMessage<i> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, i> mvcHttpMessage, MvcNetMessage<FrsRequestData, i> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcHttpResponsedMessage != null) {
            d.a aVar = new d.a();
            aVar.gFM = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            aVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            aVar.errorCode = mvcHttpResponsedMessage.getError();
            aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            aVar.gFN = mvcHttpResponsedMessage.getDownSize();
            this.dmV = aVar;
            FrsRequestData frsRequestData2 = null;
            i data = mvcHttpResponsedMessage.getData();
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

    public void atF() {
        if (this.dhf != null && this.dhf.bam() != null && this.dhf.bam().getBannerListData() != null) {
            String lastIds = this.dhf.bam().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dwC = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public l axV() {
        return this.dhf;
    }

    private void axW() {
        this.cSN = System.currentTimeMillis();
        this.dwA.JE();
    }

    public long aph() {
        return this.cSQ;
    }

    public long apj() {
        return this.cSO;
    }

    public long apk() {
        return this.cSP;
    }

    public long apl() {
        return this.cSN;
    }

    public boolean Ax() {
        return this.dwA.Ax();
    }

    public void gO(int i) {
        this.dwD = i;
        avn();
    }

    public boolean axX() {
        return this.dwD < 100;
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
