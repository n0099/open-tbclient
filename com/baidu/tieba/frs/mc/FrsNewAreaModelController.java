package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
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
    private long iNA;
    private long iNB;
    private long iNy;
    private long iNz;
    private FrsNetModel<FrsNewAreaFragment> jFE;
    private FrsRequestData jFF;
    private com.baidu.tieba.tbadkCore.f jFG;
    private String jFH;
    private int jGY;
    private FrsNewAreaFragment jHH;
    private FrsViewData jhD;
    private String jhW;
    private int mFlag;
    private String mFrom;
    private int mPn;
    private String mSource;
    private int mType;

    public FrsNewAreaModelController(FrsNewAreaFragment frsNewAreaFragment) {
        super(frsNewAreaFragment.getPageContext());
        this.jhW = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mSource = null;
        this.jFH = null;
        this.jGY = -1;
        this.iNy = 0L;
        this.iNz = 0L;
        this.iNA = 0L;
        this.iNB = 0L;
        this.jHH = frsNewAreaFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cJm() {
        this.jFE.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.jhW = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        }
        if (TextUtils.isEmpty(this.jhW)) {
            this.jhW = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.jFF = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            Ad(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            Ad(6);
        } else {
            Ad(2);
        }
        this.jhD = new FrsViewData();
        this.jFF.gx("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.jhW));
        this.jFF.gx("client_type", "2");
        this.jFF.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jhD == null ? null : this.jhD.getThreadList(), true));
        this.jFE = new FrsNetModel<>(this.jHH.getPageContext(), this.jFF);
        this.jFE.a(this);
        this.jFE.setUniqueId(this.jHH.getUniqueId());
        if (this.jhW != null && this.jhW.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.jhW);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
        bundle.putBoolean(FrsActivityConfig.GOOD, true);
    }

    public boolean cJn() {
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jFF), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.jFF.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jhD == null ? null : this.jhD.getThreadList(), true));
        a(frsRequestData, 3);
        return true;
    }

    public void Ac(int i) {
        if (!this.jFE.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jFF), FrsRequestData.class);
            frsRequestData.setPn(i);
            this.jFF.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jhD == null ? null : this.jhD.getThreadList(), false));
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        if (this.jHH != null && this.jHH.isAdded() && this.jHH.getPageContext() != null) {
            this.jHH.jjK.yB(i);
            this.jFE.a(frsRequestData);
            this.mType = i;
            frsRequestData.setKw(this.jhW);
            frsRequestData.setWithGroup(1);
            frsRequestData.setIsGood(0);
            frsRequestData.setCid(0);
            com.baidu.tieba.frs.d.j.a(this.jGY, frsRequestData);
            if (com.baidu.tbadk.a.d.bjt()) {
                com.baidu.tieba.frs.d.j.a(com.baidu.tbadk.a.b.a.bjM(), frsRequestData);
                frsRequestData.JD(com.baidu.tieba.frs.d.j.Au(com.baidu.tbadk.a.b.a.bjM()));
            }
            int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.jHH.getPageContext().getPageActivity());
            int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(this.jHH.getPageContext().getPageActivity());
            float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = av.bsV().bsW() ? 2 : 1;
            frsRequestData.setScrW(equipmentWidth);
            frsRequestData.setScrH(equipmentHeight);
            frsRequestData.setScrDip(f);
            frsRequestData.setqType(i2);
            frsRequestData.setLastId(this.jFH);
            if (this.mSource != null) {
                frsRequestData.setStType(this.mSource);
            }
            if (FrsFragment.jim != 0) {
                frsRequestData.setCtime((int) FrsFragment.jim);
            }
            if (FrsFragment.jin != 0) {
                frsRequestData.setDataSize((int) FrsFragment.jin);
            }
            if (FrsFragment.mNetError != 0) {
                frsRequestData.setNetError(FrsFragment.mNetError);
            }
            frsRequestData.setUpdateType(this.mType);
            frsRequestData.setNeedCache(false);
            cJp();
        }
    }

    private boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.m mVar) {
        this.jhD.receiveData(mVar);
        this.jhD.frsCurrentTabId = 503;
        if (frsRequestData != null) {
            this.jFF = frsRequestData;
            this.mPn = this.jFF.getPn();
            this.jhW = this.jFF.getKw();
            this.jHH.Lf(this.jhW);
            this.jHH.setFrom(this.mFrom);
            this.jHH.setPn(this.mPn);
            this.jHH.setFlag(this.mFlag);
        }
        this.jHH.jjK.a(this.mType, false, this.jFG);
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData;
        if (mvcSocketResponsedMessage != null) {
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iSg = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcSocketResponsedMessage.hasError();
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.nwK = mvcSocketResponsedMessage.getDownSize();
            this.jFG = fVar;
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
            fVar.iSg = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
            fVar.isSuccess = !mvcHttpResponsedMessage.hasError();
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.nwK = mvcHttpResponsedMessage.getDownSize();
            this.jFG = fVar;
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

    public void cDg() {
        if (this.jhD != null && this.jhD.getForum() != null && this.jhD.getForum().getBannerListData() != null) {
            String lastIds = this.jhD.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.jFH = lastIds;
            }
        }
    }

    public int getType() {
        return this.mType;
    }

    public FrsViewData cJo() {
        return this.jhD;
    }

    private void cJp() {
        this.iNy = System.currentTimeMillis();
        this.jFE.loadData();
    }

    public long cwN() {
        return this.iNB;
    }

    public long cwO() {
        return this.iNz;
    }

    public long cwP() {
        return this.iNA;
    }

    public long cwQ() {
        return this.iNy;
    }

    public boolean isLoading() {
        return this.jFE.isLoading();
    }

    public void loadData() {
        cJn();
    }

    public boolean cJq() {
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

    public void Ad(int i) {
        this.jGY = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dPc();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dPd();
        }
    }

    public int cJS() {
        return this.jGY;
    }

    public void aq(cb cbVar) {
        if (cbVar != null && this.jhD != null && this.jhD.getThreadList() != null) {
            if (y.isEmpty(this.jhD.getThreadList())) {
                this.jhD.getThreadList().add(cbVar);
            } else {
                this.jhD.getThreadList().add(0, cbVar);
            }
            this.jHH.e(this.jhD);
        }
    }
}
