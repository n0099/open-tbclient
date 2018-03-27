package com.baidu.tieba.frs.good;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.i;
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
import com.baidu.tieba.tbadkCore.j;
import com.baidu.tieba.tbadkCore.m;
/* loaded from: classes2.dex */
public class FrsGoodModelController extends BdBaseModel implements NetModel.b<FrsRequestData, j> {
    private m dDS;
    private String dEh;
    private b dRV;
    private FrsNetModel<b> dRW;
    private FrsRequestData dRX;
    private d.a dRY;
    private String dRZ;
    private int dSa;
    private long dpZ;
    private long dqa;
    private long dqb;
    private long dqc;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsGoodModelController(b bVar) {
        super(bVar.getPageContext());
        this.dEh = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.dRZ = null;
        this.dSa = 0;
        this.dpZ = 0L;
        this.dqa = 0L;
        this.dqb = 0L;
        this.dqc = 0L;
        this.dRV = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityDestroy() {
        this.dRW.cancelLoadData();
    }

    public void l(Bundle bundle) {
        if (bundle != null) {
            this.dEh = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.dEh)) {
            this.dEh = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.dRX = new FrsRequestData();
        this.dDS = new m();
        this.dRW = new FrsNetModel<>(this.dRV.getPageContext(), this.dRX);
        this.dRW.a(this);
        this.dRW.setUniqueId(getUniqueId());
        if (this.dEh != null && this.dEh.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dEh);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean eY(boolean z) {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dRX), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void nD(int i) {
        if (!this.dRW.El()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dRX), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.dRV != null && this.dRV.isAdded() && this.dRV.getPageContext() != null) {
            this.dRV.dFp.mQ(i);
            this.dRW.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.dEh);
            if (i.xo().xu()) {
                frsRequestData.setRn(35);
            } else {
                frsRequestData.setRn(50);
            }
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(1);
            frsRequestData.setCid(this.dSa);
            int ao = l.ao(this.dRV.getPageContext().getPageActivity());
            int aq = l.aq(this.dRV.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ao.De().Dg() ? 2 : 1;
            frsRequestData.setScrW(ao);
            frsRequestData.setScrH(aq);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.dRZ);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (com.baidu.tieba.frs.i.dEp != 0) {
                frsRequestData.setCtime((int) com.baidu.tieba.frs.i.dEp);
            }
            if (com.baidu.tieba.frs.i.dEq != 0) {
                frsRequestData.setDataSize((int) com.baidu.tieba.frs.i.dEq);
            }
            if (com.baidu.tieba.frs.i.dEr != 0) {
                frsRequestData.setNetError(com.baidu.tieba.frs.i.dEr);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            ayX();
        }
    }

    private boolean a(FrsRequestData frsRequestData, j jVar) {
        if (frsRequestData == null || frsRequestData.getCid() == this.dSa) {
            this.dDS.e(jVar);
            if (frsRequestData != null) {
                this.dRX = frsRequestData;
                this.mPn = this.dRX.getPn();
                this.dEh = this.dRX.getKw();
                this.dRV.mf(this.dEh);
                this.dRV.setFrom(this.mFrom);
                this.dRV.setPn(this.mPn);
                this.dRV.setFlag(this.mFlag);
            }
            this.dRV.dFp.a(this.mType, false, this.dRY);
            this.mSource = null;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, j> mvcSocketMessage, MvcNetMessage<FrsRequestData, j> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            d.a aVar = new d.a();
            aVar.gXJ = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            aVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            aVar.errorCode = mvcSocketResponsedMessage.getError();
            aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            aVar.gXK = mvcSocketResponsedMessage.getDownSize();
            this.dRY = aVar;
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
            d.a aVar = new d.a();
            aVar.gXJ = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            aVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            aVar.errorCode = mvcHttpResponsedMessage.getError();
            aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            aVar.gXK = mvcHttpResponsedMessage.getDownSize();
            this.dRY = aVar;
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

    public void avh() {
        if (this.dDS != null && this.dDS.bas() != null && this.dDS.bas().getBannerListData() != null) {
            String lastIds = this.dDS.bas().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dRZ = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public m ayW() {
        return this.dDS;
    }

    private void ayX() {
        this.dpZ = System.currentTimeMillis();
        this.dRW.Nw();
    }

    public long aqO() {
        return this.dqc;
    }

    public long aqP() {
        return this.dqa;
    }

    public long aqQ() {
        return this.dqb;
    }

    public long aqR() {
        return this.dpZ;
    }

    public boolean El() {
        return this.dRW.El();
    }

    public void jI(int i) {
        this.dSa = i;
        eY(true);
    }

    public boolean ayY() {
        return this.dSa < 100;
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
