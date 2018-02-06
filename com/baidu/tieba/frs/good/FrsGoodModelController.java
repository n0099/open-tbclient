package com.baidu.tieba.frs.good;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.i;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes2.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.b<FrsRequestData, i> {
    private l dEb;
    private String dEq;
    private b dSc;
    private FrsNetModel<b> dSd;
    private FrsRequestData dSe;
    private d.a dSf;
    private String dSg;
    private int dSh;
    private long dqi;
    private long dqj;
    private long dqk;
    private long dql;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(b bVar) {
        super(bVar.getPageContext());
        this.dEq = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.dSg = null;
        this.dSh = 0;
        this.dqi = 0L;
        this.dqj = 0L;
        this.dqk = 0L;
        this.dql = 0L;
        this.dSc = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.dSd.cancelLoadData();
    }

    public void l(Bundle bundle) {
        if (bundle != null) {
            this.dEq = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.dEq)) {
            this.dEq = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.dSe = new FrsRequestData();
        this.dEb = new l();
        this.dSd = new FrsNetModel<>(this.dSc.getPageContext(), this.dSe);
        this.dSd.a(this);
        this.dSd.setUniqueId(getUniqueId());
        if (this.dEq != null && this.dEq.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dEq);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean eY(boolean z) {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dSe), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void nD(int i) {
        if (!this.dSd.El()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dSe), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.dSc != null && this.dSc.isAdded() && this.dSc.getPageContext() != null) {
            this.dSc.dFx.mQ(i);
            this.dSd.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.dEq);
            if (com.baidu.tbadk.core.i.xo().xu()) {
                frsRequestData.setRn(35);
            } else {
                frsRequestData.setRn(50);
            }
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.setCid(this.dSh);
            int ao = com.baidu.adp.lib.util.l.ao(this.dSc.getPageContext().getPageActivity());
            int aq = com.baidu.adp.lib.util.l.aq(this.dSc.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ao.De().Dg() ? 2 : 1;
            frsRequestData.setScrW(ao);
            frsRequestData.setScrH(aq);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.dSg);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (com.baidu.tieba.frs.i.dEy != 0) {
                frsRequestData.setCtime((int) com.baidu.tieba.frs.i.dEy);
            }
            if (com.baidu.tieba.frs.i.dEz != 0) {
                frsRequestData.setDataSize((int) com.baidu.tieba.frs.i.dEz);
            }
            if (com.baidu.tieba.frs.i.dEA != 0) {
                frsRequestData.setNetError(com.baidu.tieba.frs.i.dEA);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            ayW();
        }
    }

    private boolean a(FrsRequestData frsRequestData, i iVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.dSh) {
            this.dEb.e(iVar);
            if (frsRequestData != null) {
                this.dSe = frsRequestData;
                this.mPn = this.dSe.getPn();
                this.dEq = this.dSe.getKw();
                this.dSc.mf(this.dEq);
                this.dSc.setFrom(this.mFrom);
                this.dSc.setPn(this.mPn);
                this.dSc.setFlag(this.mFlag);
            }
            this.dSc.dFx.a(this.mType, false, this.dSf);
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
            aVar.gXI = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            aVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            aVar.errorCode = mvcSocketResponsedMessage.getError();
            aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            aVar.gXJ = mvcSocketResponsedMessage.getDownSize();
            this.dSf = aVar;
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
            aVar.gXI = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            aVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            aVar.errorCode = mvcHttpResponsedMessage.getError();
            aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            aVar.gXJ = mvcHttpResponsedMessage.getDownSize();
            this.dSf = aVar;
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

    public void avh() {
        if (this.dEb != null && this.dEb.bas() != null && this.dEb.bas().getBannerListData() != null) {
            String lastIds = this.dEb.bas().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dSg = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public l ayV() {
        return this.dEb;
    }

    private void ayW() {
        this.dqi = System.currentTimeMillis();
        this.dSd.Nw();
    }

    public long aqO() {
        return this.dql;
    }

    public long aqP() {
        return this.dqj;
    }

    public long aqQ() {
        return this.dqk;
    }

    public long aqR() {
        return this.dqi;
    }

    public boolean El() {
        return this.dSd.El();
    }

    public void jI(int i) {
        this.dSh = i;
        eY(true);
    }

    public boolean ayX() {
        return this.dSh < 100;
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
