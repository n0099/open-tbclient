package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.p;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.l>, ag {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long dzC;
    private long fTZ;
    private long fUa;
    private long fUb;
    private long fUc;
    private FrsNetModel<FrsFragment> gDE;
    private e.b gDG;
    private String gDH;
    private final FrsFragment gEE;
    private ArrayList<m> gEJ;
    private FrsRequestData gEK;
    private final p gEL;
    private boolean gEM;
    private int gEN;
    private long gEO;
    private int gEP;
    private int gEQ;
    private an gER;
    private boolean gES;
    private SparseArray<an> gET;
    private z gEU;
    private aj gEV;
    private ArrayList<m> gEW;
    private boolean gEX;
    private String gEY;
    private int gEZ;
    private int gFa;
    private boolean gFb;
    private String gFc;
    private final SparseArray<Boolean> gFd;
    private aj gFe;
    private FrsViewData glJ;
    private String gmb;
    private int gxQ;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean tG(int i) {
        return this.gFd.get(i, false).booleanValue();
    }

    public void F(int i, boolean z) {
        this.gFd.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, p pVar) {
        super(frsFragment.getPageContext());
        this.gmb = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.gEN = 0;
        this.mSource = null;
        this.gDH = null;
        this.gEO = 0L;
        this.gxQ = 1;
        this.gEP = 0;
        this.gEQ = 0;
        this.gES = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.gET = new SparseArray<>();
        this.dzC = 0L;
        this.gEX = false;
        this.gEZ = -1;
        this.gFa = -1;
        this.gFc = null;
        this.gFd = new SparseArray<>();
        this.gFe = new aj() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.aj
            public void a(int i, int i2, aq aqVar, ArrayList<m> arrayList) {
                FrsModelController.this.gES = false;
                if (i == FrsModelController.this.gxQ && FrsModelController.this.gEV != null) {
                    FrsModelController.this.gER = aqVar;
                    FrsModelController.this.b(i, i2, aqVar);
                    ArrayList<m> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.glJ.setThreadList(arrayList2);
                    FrsModelController.this.gEV.a(i, i2, aqVar, arrayList);
                }
            }
        };
        this.fTZ = 0L;
        this.fUa = 0L;
        this.fUb = 0L;
        this.fUc = 0L;
        if (pVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.gEE = frsFragment;
        this.gEL = pVar;
        N(this.gEE);
    }

    private void N(FrsFragment frsFragment) {
        this.gEU = new z();
        this.gEU.dxg = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.gEU));
        this.gEU.a(this.gFe);
    }

    public void ags() {
        this.gDE.cancelLoadData();
    }

    public void ad(Bundle bundle) {
        if (bundle != null) {
            this.gmb = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.gEY = bundle.getString("yuelaou_locate");
            this.gEM = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.gEN = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.gEO = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.gEE.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.gmb)) {
            this.gmb = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.gEY)) {
            this.gEY = "";
        }
        this.mSource = this.mFrom;
        bHA();
        this.glJ = new FrsViewData();
        this.gEK.es("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.gmb));
        this.gEK.es("client_type", "2");
        if (this.gDE == null) {
            this.gDE = new FrsNetModel<>(this.gEE.getPageContext(), this.gEK);
        }
        this.gDE.a(this);
        this.gDE.setUniqueId(this.gEE.getPageContext().getUniqueId());
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
    }

    private void bHA() {
        AccountData currentAccountObj;
        this.gEK = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            tH(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            tH(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            tH(com.baidu.tieba.frs.f.g.Bw("1~" + str + this.gmb));
        }
        this.gEK.setSortType(getSortType());
        if (this.gEZ == 5) {
            this.gEK.setIsGood(1);
        } else {
            this.gEK.setIsGood(0);
        }
    }

    public boolean buj() {
        if (this.gxQ != 1) {
            tD(1);
            return true;
        } else if (this.gDE.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gEK), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void G(int i, boolean z) {
        this.gEE.gmo = System.currentTimeMillis();
        if (this.glJ != null && this.glJ.getLikeFeedForumDataList() != null) {
            this.glJ.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gEK), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.gxQ = c(this.gxQ, frsRequestData);
        if (this.gxQ == 1) {
            if (!this.gDE.isLoading()) {
                frsRequestData.setCallFrom(this.gEN);
                a(frsRequestData, i, z ? false : true);
                this.gEN = 0;
                return;
            }
            return;
        }
        if (this.gER == null) {
            this.gER = new an();
            this.gER.pn = 1;
            this.gER.forumName = this.gmb;
            if (this.glJ != null && this.glJ.getForum() != null) {
                this.gER.forumId = this.glJ.getForum().getId();
            }
        }
        tD(i);
    }

    public void tE(int i) {
        if (this.gxQ != 1) {
            tD(4);
        } else if (!this.gDE.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gEK), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.gEE.lc(z);
        this.gEL.sA(i);
        this.gDE.a(frsRequestData);
        this.mType = i;
        frsRequestData.IE(this.gEE.bCN() ? "1" : "2");
        if (this.gFb) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.tZ(this.gFa)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.gFb = false;
        frsRequestData.setKw(this.gmb);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = ar.aEq().aEr() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.gDH);
        frsRequestData.setYuelaouLocate(this.gEY);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(aa.aPX(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.Ck(bHB());
        if (FrsFragment.gmp != 0) {
            frsRequestData.setCtime((int) FrsFragment.gmp);
        }
        if (FrsFragment.gmq != 0) {
            frsRequestData.setDataSize((int) FrsFragment.gmq);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.eF(this.gEO);
        if (this.gEO != 0) {
            this.gEO = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.gEZ, frsRequestData);
        b(i, frsRequestData);
        a(this.gmb, frsRequestData);
        if (!tG(this.gEZ) && !this.gEE.gmc) {
            String e = com.baidu.tieba.tbadkCore.d.cIt().e("1~" + this.gmb, frsRequestData.getSortType(), frsRequestData.getIsGood(), this.gEK.getCategoryId());
            this.gFc = e;
            new a(this, true, e).execute(new Object[0]);
        }
        bHk();
    }

    private int bHB() {
        return (this.gEE == null || !(this.gEE.mHeadLineDefaultNavTabId == -1 || this.gEE.mHeadLineDefaultNavTabId == this.gxQ)) ? 0 : 1;
    }

    private void b(int i, FrsRequestData frsRequestData) {
        if (frsRequestData != null) {
            switch (i) {
                case 3:
                    frsRequestData.setLoadType(1);
                    return;
                case 4:
                    frsRequestData.setLoadType(2);
                    return;
                default:
                    return;
            }
        }
    }

    protected boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar == null || lVar.getForum() == null || (com.baidu.tbadk.core.util.aq.isEmpty(lVar.getForum().getName()) && 340001 != lVar.mErrorNo)) {
            return false;
        }
        tH(com.baidu.tieba.frs.f.g.ua(lVar.getSortType()));
        F(com.baidu.tieba.frs.f.g.ua(lVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.gxQ = lVar.getFrsDefaultTabId();
        }
        this.glJ.receiveData(lVar);
        d(this.glJ);
        this.gEJ = new ArrayList<>();
        if (frsRequestData != null) {
            this.gEK = frsRequestData;
            this.mPn = this.gEK.getPn();
            this.gmb = this.gEK.getKw();
            this.gEE.setForumName(this.gmb);
            this.gEE.setFrom(this.mFrom);
            this.gEE.setPn(this.mPn);
            this.gEE.setFlag(this.mFlag);
        }
        if (this.glJ.getThreadList() != null) {
            this.gEJ.addAll(this.glJ.getThreadList());
        }
        if (this.gxQ != 1 && this.isNetFirstLoad) {
            this.gEL.a(7, false, this.gDG);
        } else {
            this.gEL.a(this.mType, false, this.gDG);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.gEK)) {
            bHQ();
        }
        this.isNetFirstLoad = false;
        if (lVar.getForum() != null && !TextUtils.isEmpty(lVar.getForum().getName()) && frsRequestData != null && r.cAV().cAP() != null) {
            r.cAV().cAP().g(lVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        com.baidu.tieba.frs.a.bBr().kX(this.gxQ == 301);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(final MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, final MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, final MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l data;
        if (mvcSocketResponsedMessage != null) {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    FrsModelController.this.b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
                    return false;
                }
            });
            e.b bVar = new e.b();
            bVar.fXn = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            bVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.kdc = mvcSocketResponsedMessage.getDownSize();
            this.gDG = bVar;
            if (!mvcSocketResponsedMessage.hasError() || 340001 == mvcSocketResponsedMessage.getError()) {
                data = mvcSocketResponsedMessage.getData();
                r3 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
                if (mvcNetMessage != null) {
                    r3 = mvcNetMessage.getRequestData();
                }
            } else {
                data = null;
            }
            if (r3 == null || data == null || !a(r3, data)) {
                ErrorData errorData = new ErrorData();
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                this.gEE.a(errorData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.gEX) {
            this.gEX = true;
            a(1000, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        } else {
            a(false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        }
        long j = 0;
        if (mvcSocketMessage != null) {
            j = mvcSocketMessage.getClientLogID();
            frsRequestData = mvcSocketMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            frsRequestData = mvcNetMessage.getRequestData();
        }
        int error = mvcSocketResponsedMessage.getError();
        String errorString = mvcSocketResponsedMessage.getErrorString();
        if (error != 0) {
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
    public void a(final MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.l> mvcHttpResponsedMessage, final MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcHttpMessage, final MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        FrsRequestData frsRequestData;
        if (mvcHttpResponsedMessage != null) {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    FrsModelController.this.b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
                    return false;
                }
            });
            e.b bVar = new e.b();
            bVar.fXn = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            bVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.kdc = mvcHttpResponsedMessage.getDownSize();
            this.gDG = bVar;
            if (mvcHttpResponsedMessage.hasError()) {
                lVar = null;
                frsRequestData = null;
            } else {
                lVar = mvcHttpResponsedMessage.getData();
                frsRequestData = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
                if (mvcNetMessage != null) {
                    frsRequestData = mvcNetMessage.getRequestData();
                }
            }
            if (frsRequestData == null || lVar == null || !a(frsRequestData, lVar)) {
                ErrorData errorData = new ErrorData();
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                this.gEE.a(errorData);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        super.registerListener(i, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.l> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        long j = 0;
        if (mvcHttpMessage != null) {
            j = mvcHttpMessage.getClientLogID();
            frsRequestData = mvcHttpMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            frsRequestData = mvcNetMessage.getRequestData();
        }
        int error = mvcHttpResponsedMessage.getError();
        String errorString = mvcHttpResponsedMessage.getErrorString();
        if (error != 0) {
            int cmd = mvcHttpResponsedMessage.getCmd();
            Object[] objArr = new Object[2];
            objArr[0] = "kw";
            objArr[1] = frsRequestData != null ? frsRequestData.getKw() : null;
            com.baidu.tbadk.core.d.a.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
        if (!this.gEX) {
            this.gEX = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bCE() {
        if (this.glJ != null && this.glJ.getForum() != null && this.glJ.getForum().getBannerListData() != null) {
            String lastIds = this.glJ.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.gDH = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aOT().aOU()) {
            this.dzC = System.currentTimeMillis() - this.gEE.fSK;
            this.gEE.dzB = System.currentTimeMillis() - this.gEE.gmn;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, this.gEE.dzt, this.gEE.createTime, this.gEE.dzB, false, this.dzC);
            this.gEE.createTime = 0L;
            this.gEE.dzt = 0L;
            com.baidu.tieba.frs.f.h.a(this, this.gEE.fSK);
            this.gEE.fSK = -1L;
            iVar.aOQ();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aOT().aOU()) {
            this.dzC = System.currentTimeMillis() - this.gEE.gmo;
            this.gEE.dzB = System.currentTimeMillis() - this.gEE.gmn;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1000, z, responsedMessage, this.gEE.dzt, this.gEE.createTime, this.gEE.dzB, false, this.dzC);
            if (this.mType == 4) {
                iVar.dzK = this.dzC;
                iVar.gM(true);
            } else if (this.mType == 3) {
                iVar.dzL = this.dzC;
                iVar.gM(false);
            }
        }
    }

    public FrsRequestData bHC() {
        return this.gEK;
    }

    public String getPageType() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public int getPn() {
        return this.mPn;
    }

    public FrsViewData bHj() {
        return this.glJ;
    }

    public e.b bHD() {
        return this.gDG;
    }

    private void bHk() {
        this.fTZ = System.currentTimeMillis();
        this.gDE.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.tieba.tbadkCore.l lVar) {
        this.isCacheFirstLoad = false;
        this.glJ.receiveData(lVar);
        d(this.glJ);
        this.gEJ = new ArrayList<>();
        if (this.glJ.getThreadList() != null) {
            this.gEJ.addAll(this.glJ.getThreadList());
        }
        this.gEL.c(lVar);
    }

    private void d(FrsViewData frsViewData) {
        if (com.baidu.tieba.frs.vc.h.k(frsViewData)) {
            this.mPageType = "book_page";
        } else if (frsViewData.getIsBrandForum()) {
            this.mPageType = "brand_page";
        } else if (com.baidu.tieba.frs.vc.h.l(frsViewData)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes7.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.l, Void> {
        private String gFn;
        private FrsModelController gFo;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.gFn = null;
            this.gFn = str;
            this.gFo = frsModelController;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            int i;
            CustomResponsedMessage runTask;
            if (this.needCache && com.baidu.tieba.tbadkCore.d.cIt().IC(this.gFn)) {
                if (!com.baidu.tieba.tbadkCore.d.cIt().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.gFn)) {
                    com.baidu.tieba.tbadkCore.d.cIt().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.l responseData = com.baidu.tieba.tbadkCore.d.cIt().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().ayj(), true) && !responseData.getBookInfo().ayj().equals("0") && responseData.getBookInfo().ayk() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().ayj(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
                    responseData.setMangaReadRecordChapterId(Integer.valueOf(((Integer) runTask.getData()).intValue()));
                }
                publishProgress(responseData);
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(com.baidu.tieba.tbadkCore.l... lVarArr) {
            super.onProgressUpdate(lVarArr);
            if (this.gFo != null && lVarArr != null) {
                this.gFo.g(lVarArr.length > 0 ? lVarArr[0] : null);
                this.gFo.F(this.gFo.gEZ, true);
            }
        }
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

    public int bHE() {
        return this.gEQ;
    }

    private void bHF() {
        if (this.gEW == null) {
            this.gEW = new ArrayList<>();
        }
        if (this.gEW.size() == 0) {
            this.gEW.add(new v());
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(int i, int i2, an anVar) {
        this.gxQ = c(i, null);
        if (anVar == null && (anVar = bP(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.gEV != null) {
                aq aqVar = new aq();
                aqVar.hasMore = false;
                aqVar.pn = 1;
                aqVar.forumName = this.gmb;
                aqVar.gqq = false;
                if (this.glJ != null && this.glJ.getForum() != null) {
                    aqVar.forumId = this.glJ.getForum().getId();
                }
                bHF();
                this.glJ.setThreadList(this.gEW);
                this.gEV.a(i, i2, aqVar, this.gEW);
            }
            anVar = new an();
            anVar.pn = -1;
        }
        if (this.glJ != null && this.glJ.getForum() != null) {
            anVar.forumId = this.glJ.getForum().getId();
        }
        anVar.forumName = this.gmb;
        if (x.bDY().sS(1) != null && this.gxQ == 1) {
            this.gEK.setCategoryId(i2);
        }
        this.gEP = i2;
        this.gER = anVar;
        b(i, i2, anVar);
        tD(5);
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(aj ajVar) {
        this.gEV = ajVar;
        this.gEU.a(this.gFe);
    }

    private void tD(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.gER != null) {
                    this.gER.pn++;
                    break;
                }
                break;
            case 2:
                if (this.gER != null) {
                    an anVar = this.gER;
                    anVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.gER != null) {
                    this.gER.pn = -1;
                    break;
                }
                break;
        }
        if (this.gxQ == 1) {
            if (this.gEQ == this.gEP) {
                ArrayList<m> arrayList = new ArrayList<>();
                if (this.gEJ != null) {
                    arrayList.addAll(this.gEJ);
                }
                this.glJ.setThreadList(arrayList);
                if (this.gEV != null) {
                    this.gEV.a(this.gxQ, this.gEP, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.gEQ = this.gEP;
            return;
        }
        ag sT = this.gEU.sT(this.gxQ);
        if (sT != null) {
            this.gES = true;
            sT.a(this.gxQ, this.gEP, this.gER);
            return;
        }
        if (this.glJ != null && this.glJ.getThreadList() != null) {
            this.glJ.getThreadList().clear();
        }
        this.gEV.a(this.gxQ, this.gEP, null, null);
    }

    public boolean hasMore() {
        if ((this.gER instanceof aq) && ((aq) this.gER).errCode == 0) {
            return ((aq) this.gER).hasMore;
        }
        return true;
    }

    private int bO(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, an anVar) {
        this.gET.put(bO(i, i2), anVar);
    }

    public an bP(int i, int i2) {
        return this.gET.get(bO(i, i2));
    }

    @Override // com.baidu.tieba.frs.ag
    public void init() {
        this.gEU.init();
    }

    @Override // com.baidu.tieba.frs.ag
    public void beK() {
        this.gEU.destory();
        this.gEU.clear();
    }

    public int bHG() {
        return this.gxQ;
    }

    public boolean bHH() {
        return 1 == this.gxQ;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(am amVar) {
        if (amVar != null && !StringUtils.isNull(amVar.getId()) && !com.baidu.tbadk.core.util.v.isEmpty(this.gEJ)) {
            if (this.gxQ == 1) {
                this.glJ.addMyNewThread(amVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<m> it = this.gEJ.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if ((next instanceof bi) && amVar.getId().equals(((bi) next).cNb.getId())) {
                    return;
                }
            }
            this.gEJ.add(topThreadSize, amVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.gEJ == null || this.gEJ.size() <= 0) {
            return 0;
        }
        Iterator<m> it = this.gEJ.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                m next = it.next();
                if (!(next instanceof bi)) {
                    i = i2;
                } else if (((bi) next).cNb.azS() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean bHI() {
        return this.gES;
    }

    public void bHJ() {
        n nVar = new n();
        if (this.gEQ == 0) {
            nVar.sL(this.gEZ);
        }
        if (this.glJ.getThreadList() != null) {
            this.glJ.getThreadList().clear();
            this.glJ.getThreadList().add(nVar);
        }
        if (this.gEJ != null) {
            this.gEJ.clear();
            this.gEJ.add(nVar);
        }
    }

    public ArrayList<m> bHK() {
        return this.gEJ;
    }

    public void tH(int i) {
        AccountData currentAccountObj;
        this.gEZ = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
        }
        com.baidu.tieba.frs.f.g.aE("1~" + str + this.gmb, this.gEZ);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cKy();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cKz();
        }
    }

    public void tI(int i) {
        this.gFa = i;
    }

    public void lW(boolean z) {
        this.gFb = z;
    }

    public int bHL() {
        return this.gEZ;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.tZ(this.gEZ);
    }

    public boolean bHM() {
        return this.gEM;
    }

    public boolean bHN() {
        return this.gEZ == 5;
    }

    public boolean bHO() {
        return this.gEK != null && this.gEK.getLoadType() == 1;
    }

    public boolean bHP() {
        return this.gEZ == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.gEE.bCb() != null) {
            return this.gEE.bCb().a(this.gEZ, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bj.cNK.get() && r.cAV().cAP() != null) {
            int ax = r.cAV().cAP().ax(str, false);
            int ay = r.cAV().cAP().ay(str, false);
            if (frsRequestData.getLoadType() == 1) {
                ax++;
            } else if (frsRequestData.getLoadType() == 2) {
                ay++;
            }
            frsRequestData.setRefreshCount(ax);
            frsRequestData.setLoadCount(ay);
        }
    }

    public void bHQ() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.glJ != null && this.glJ.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.glJ.getForum().getId(), 0L));
        }
        this.gEE.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void Bn(final String str) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cIt().ep(FrsModelController.this.gFc, str);
                return null;
            }
        }, null);
    }

    public void Bo(final String str) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.5
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cIt().eq(FrsModelController.this.gFc, str);
                return null;
            }
        }, null);
    }

    public void Bp(final String str) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.6
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cIt().er(FrsModelController.this.gFc, str);
                return null;
            }
        }, null);
    }
}
