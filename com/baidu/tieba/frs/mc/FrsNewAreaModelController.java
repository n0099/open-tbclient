package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.bj;
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
/* loaded from: classes7.dex */
public class FrsNewAreaModelController extends BdBaseModel implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.l> {
    private long fTZ;
    private long fUa;
    private long fUb;
    private long fUc;
    private FrsNetModel<FrsNewAreaFragment> gDE;
    private FrsRequestData gDF;
    private e.b gDG;
    private String gDH;
    private int gEZ;
    private FrsNewAreaFragment gFO;
    private FrsViewData glJ;
    private String gmb;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsNewAreaModelController(FrsNewAreaFragment frsNewAreaFragment) {
        super(frsNewAreaFragment.getPageContext());
        this.gmb = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.gDH = null;
        this.gEZ = -1;
        this.fTZ = 0L;
        this.fUa = 0L;
        this.fUb = 0L;
        this.fUc = 0L;
        this.gFO = frsNewAreaFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ags() {
        this.gDE.cancelLoadData();
    }

    public void ad(Bundle bundle) {
        AccountData currentAccountObj;
        if (bundle != null) {
            this.gmb = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.gmb)) {
            this.gmb = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.gDF = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            tH(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            tH(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            tH(com.baidu.tieba.frs.f.g.Bw("503~" + str + this.gmb));
        }
        this.glJ = new FrsViewData();
        this.gDF.es("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.gmb));
        this.gDF.es("client_type", "2");
        this.gDE = new FrsNetModel<>(this.gFO.getPageContext(), this.gDF);
        this.gDE.a(this);
        this.gDE.setUniqueId(this.gFO.getUniqueId());
        if (this.gmb != null && this.gmb.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.gmb);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean bHi() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gDF), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void tE(int i) {
        if (!this.gDE.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gDF), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.gFO != null && this.gFO.isAdded() && this.gFO.getPageContext() != null) {
            this.gFO.gnw.sA(i);
            this.gDE.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.gmb);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(0);
            frsRequestData.setCid(0);
            com.baidu.tieba.frs.f.g.a(this.gEZ, frsRequestData);
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.gFO.getPageContext().getPageActivity());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.gFO.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = ar.aEq().aEr() ? 2 : 1;
            frsRequestData.setScrW(equipmentWidth);
            frsRequestData.setScrH(equipmentHeight);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.gDH);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.gmp != 0) {
                frsRequestData.setCtime((int) FrsFragment.gmp);
            }
            if (FrsFragment.gmq != 0) {
                frsRequestData.setDataSize((int) FrsFragment.gmq);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.setNetError(FrsFragment.mNetError);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            bHk();
        }
    }

    private boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.l lVar) {
        this.glJ.receiveData(lVar);
        this.glJ.frsCurrentTabId = 503;
        if (frsRequestData != null) {
            this.gDF = frsRequestData;
            this.mPn = this.gDF.getPn();
            this.gmb = this.gDF.getKw();
            this.gFO.Bj(this.gmb);
            this.gFO.setFrom(this.mFrom);
            this.gFO.setPn(this.mPn);
            this.gFO.setFlag(this.mFlag);
        }
        this.gFO.gnw.a(this.mType, false, this.gDG);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            e.b bVar = new e.b();
            bVar.fXn = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.kdh = mvcSocketResponsedMessage.getDownSize();
            this.gDG = bVar;
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
            objArr[2] = BdStatsConstant.StatsKey.SEQUENCEID;
            objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
            com.baidu.tbadk.core.d.a.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.l> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcHttpResponsedMessage != null) {
            e.b bVar = new e.b();
            bVar.fXn = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            bVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.kdh = mvcHttpResponsedMessage.getDownSize();
            this.gDG = bVar;
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
            com.baidu.tbadk.core.d.a.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
    }

    public void bCE() {
        if (this.glJ != null && this.glJ.getForum() != null && this.glJ.getForum().getBannerListData() != null) {
            String lastIds = this.glJ.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.gDH = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData bHj() {
        return this.glJ;
    }

    private void bHk() {
        this.fTZ = System.currentTimeMillis();
        this.gDE.loadData();
    }

    public long bxf() {
        return this.fUc;
    }

    public long bxg() {
        return this.fUa;
    }

    public long bxh() {
        return this.fUb;
    }

    public long bxi() {
        return this.fTZ;
    }

    public boolean isLoading() {
        return this.gDE.isLoading();
    }

    public void loadData() {
        bHi();
    }

    public boolean bHl() {
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

    public void tH(int i) {
        AccountData currentAccountObj;
        this.gEZ = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
        }
        com.baidu.tieba.frs.f.g.aE("503~" + str + this.gmb, this.gEZ);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cKA();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cKB();
        }
    }

    public int bHL() {
        return this.gEZ;
    }

    public void ak(bj bjVar) {
        if (bjVar != null && this.glJ != null && this.glJ.getThreadList() != null) {
            if (v.isEmpty(this.glJ.getThreadList())) {
                this.glJ.getThreadList().add(bjVar);
            } else {
                this.glJ.getThreadList().add(0, bjVar);
            }
            this.gFO.e(this.glJ);
        }
    }
}
