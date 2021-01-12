package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes2.dex */
public class FrsNewAreaModelController extends BdBaseModel implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.m> {
    private long iFS;
    private long iFT;
    private long iFU;
    private long iFV;
    private FrsNewAreaFragment jAg;
    private FrsViewData jaa;
    private String jat;
    private FrsNetModel<FrsNewAreaFragment> jyc;
    private FrsRequestData jyd;
    private com.baidu.tieba.tbadkCore.f jye;
    private String jyf;
    private int jzw;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsNewAreaModelController(FrsNewAreaFragment frsNewAreaFragment) {
        super(frsNewAreaFragment.getPageContext());
        this.jat = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.jyf = null;
        this.jzw = -1;
        this.iFS = 0L;
        this.iFT = 0L;
        this.iFU = 0L;
        this.iFV = 0L;
        this.jAg = frsNewAreaFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cHM() {
        this.jyc.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.jat = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.jat)) {
            this.jat = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.jyd = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            zS(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            zS(6);
        } else {
            zS(2);
        }
        this.jaa = new FrsViewData();
        this.jyd.gp("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.jat));
        this.jyd.gp("client_type", "2");
        this.jyc = new FrsNetModel<>(this.jAg.getPageContext(), this.jyd);
        this.jyc.a(this);
        this.jyc.setUniqueId(this.jAg.getUniqueId());
        if (this.jat != null && this.jat.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.jat);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean cHN() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jyd), FrsRequestData.class);
        frsRequestData.setPn(1);
        a(frsRequestData, 3);
        return true;
    }

    public void zN(int i) {
        if (!this.jyc.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jyd), FrsRequestData.class);
            frsRequestData.setPn(i);
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.jAg != null && this.jAg.isAdded() && this.jAg.getPageContext() != null) {
            this.jAg.jcg.yq(i);
            this.jyc.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.jat);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(0);
            frsRequestData.setCid(0);
            com.baidu.tieba.frs.d.j.a(this.jzw, frsRequestData);
            if (com.baidu.tbadk.a.d.bjf()) {
                com.baidu.tieba.frs.d.j.a(com.baidu.tbadk.a.b.a.bjp(), frsRequestData);
                frsRequestData.Jf(com.baidu.tieba.frs.d.j.Aj(com.baidu.tbadk.a.b.a.bjp()));
            }
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.jAg.getPageContext().getPageActivity());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.jAg.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = au.bsy().bsz() ? 2 : 1;
            frsRequestData.setScrW(equipmentWidth);
            frsRequestData.setScrH(equipmentHeight);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.jyf);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.jaI != 0) {
                frsRequestData.setCtime((int) FrsFragment.jaI);
            }
            if (FrsFragment.jaJ != 0) {
                frsRequestData.setDataSize((int) FrsFragment.jaJ);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.setNetError(FrsFragment.mNetError);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            cHP();
        }
    }

    private boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.m mVar) {
        this.jaa.receiveData(mVar);
        this.jaa.frsCurrentTabId = 503;
        if (frsRequestData != null) {
            this.jyd = frsRequestData;
            this.mPn = this.jyd.getPn();
            this.jat = this.jyd.getKw();
            this.jAg.Kk(this.jat);
            this.jAg.setFrom(this.mFrom);
            this.jAg.setPn(this.mPn);
            this.jAg.setFlag(this.mFlag);
        }
        this.jAg.jcg.a(this.mType, false, this.jye);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iKB = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.nkx = mvcSocketResponsedMessage.getDownSize();
            this.jye = fVar;
            FrsRequestData frsRequestData2 = null;
            com.baidu.tieba.tbadkCore.m data = mvcSocketResponsedMessage.getData();
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
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcHttpResponsedMessage != null) {
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iKB = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.nkx = mvcHttpResponsedMessage.getDownSize();
            this.jye = fVar;
            FrsRequestData frsRequestData2 = null;
            com.baidu.tieba.tbadkCore.m data = mvcHttpResponsedMessage.getData();
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

    public void cBH() {
        if (this.jaa != null && this.jaa.getForum() != null && this.jaa.getForum().getBannerListData() != null) {
            String lastIds = this.jaa.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.jyf = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData cHO() {
        return this.jaa;
    }

    private void cHP() {
        this.iFS = System.currentTimeMillis();
        this.jyc.loadData();
    }

    public long cvo() {
        return this.iFV;
    }

    public long cvp() {
        return this.iFT;
    }

    public long cvq() {
        return this.iFU;
    }

    public long cvr() {
        return this.iFS;
    }

    public boolean isLoading() {
        return this.jyc.isLoading();
    }

    public void loadData() {
        cHN();
    }

    public boolean cHQ() {
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

    public void zS(int i) {
        this.jzw = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dMA();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dMB();
        }
    }

    public int cIs() {
        return this.jzw;
    }

    public void ap(bz bzVar) {
        if (bzVar != null && this.jaa != null && this.jaa.getThreadList() != null) {
            if (x.isEmpty(this.jaa.getThreadList())) {
                this.jaa.getThreadList().add(bzVar);
            } else {
                this.jaa.getThreadList().add(0, bzVar);
            }
            this.jAg.e(this.jaa);
        }
    }
}
