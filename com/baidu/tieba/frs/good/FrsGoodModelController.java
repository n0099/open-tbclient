package com.baidu.tieba.frs.good;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ar;
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
    private long eTw;
    private long eTx;
    private long eTy;
    private long eTz;
    private boolean fFI;
    private FrsGoodFragment fGd;
    private FrsNetModel<FrsGoodFragment> fGe;
    private FrsRequestData fGf;
    private e.b fGg;
    private String fGh;
    private int fGi;
    private String foI;
    private FrsViewData fot;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(FrsGoodFragment frsGoodFragment) {
        super(frsGoodFragment.getPageContext());
        this.foI = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.fGh = null;
        this.fGi = 0;
        this.fFI = false;
        this.eTw = 0L;
        this.eTx = 0L;
        this.eTy = 0L;
        this.eTz = 0L;
        this.fGd = frsGoodFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.fGe.cancelLoadData();
    }

    public void K(Bundle bundle) {
        if (bundle != null) {
            this.foI = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fFI = bundle.getBoolean(FrsActivityConfig.IS_SELECTION, false);
        }
        if (TextUtils.isEmpty(this.foI)) {
            this.foI = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.fGf = new FrsRequestData();
        this.fot = new FrsViewData();
        this.fGf.ej("forum_name", k.bh(this.foI));
        this.fGf.ej("client_type", "2");
        this.fGe = new FrsNetModel<>(this.fGd.getPageContext(), this.fGf);
        this.fGe.a(this);
        this.fGe.setUniqueId(this.fGd.getUniqueId());
        if (this.foI != null && this.foI.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.foI);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
        bundle.putBoolean(FrsActivityConfig.IS_SELECTION, this.fFI);
    }

    public boolean boI() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fGf), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void sd(int i) {
        if (!this.fGe.pu()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fGf), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.fGd != null && this.fGd.isAdded() && this.fGd.getPageContext() != null) {
            this.fGd.fqk.ra(i);
            this.fGe.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.foI);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.Aq(this.fFI ? 1 : 0);
            if (this.fFI) {
                frsRequestData.setRn(50);
                frsRequestData.Ar(50);
                frsRequestData.setIsGood(0);
            }
            frsRequestData.setCid(this.fGi);
            int af = l.af(this.fGd.getPageContext().getPageActivity());
            int ah = l.ah(this.fGd.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ar.ail().ain() ? 2 : 1;
            frsRequestData.setScrW(af);
            frsRequestData.setScrH(ah);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.fGh);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.foW != 0) {
                frsRequestData.setCtime((int) FrsFragment.foW);
            }
            if (FrsFragment.foX != 0) {
                frsRequestData.setDataSize((int) FrsFragment.foX);
            }
            if (FrsFragment.foY != 0) {
                frsRequestData.setNetError(FrsFragment.foY);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            boK();
        }
    }

    private boolean a(FrsRequestData frsRequestData, j jVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.fGi) {
            this.fot.receiveData(jVar);
            this.fot.frsCurrentTabId = this.fFI ? 303 : 301;
            if (frsRequestData != null) {
                this.fGf = frsRequestData;
                this.mPn = this.fGf.getPn();
                this.foI = this.fGf.getKw();
                this.fGd.wN(this.foI);
                this.fGd.setFrom(this.mFrom);
                this.fGd.setPn(this.mPn);
                this.fGd.setFlag(this.mFlag);
            }
            this.fGd.fqk.a(this.mType, false, this.fGg);
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
            bVar.eWF = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.iWv = mvcSocketResponsedMessage.getDownSize();
            this.fGg = bVar;
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
            com.baidu.tbadk.core.d.a.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<j> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, j> mvcHttpMessage, MvcNetMessage<FrsRequestData, j> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcHttpResponsedMessage != null) {
            e.b bVar = new e.b();
            bVar.eWF = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.iWv = mvcHttpResponsedMessage.getDownSize();
            this.fGg = bVar;
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
            com.baidu.tbadk.core.d.a.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
    }

    public void bkg() {
        if (this.fot != null && this.fot.getForum() != null && this.fot.getForum().getBannerListData() != null) {
            String lastIds = this.fot.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fGh = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData boJ() {
        return this.fot;
    }

    private void boK() {
        this.eTw = System.currentTimeMillis();
        this.fGe.atv();
    }

    public long beg() {
        return this.eTz;
    }

    public long beh() {
        return this.eTx;
    }

    public long bei() {
        return this.eTy;
    }

    public long bej() {
        return this.eTw;
    }

    public boolean pu() {
        return this.fGe.pu();
    }

    public void mV(int i) {
        this.fGi = i;
        boI();
    }

    public boolean boL() {
        return this.fGi < 100;
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
