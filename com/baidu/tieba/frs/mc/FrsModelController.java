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
/* loaded from: classes9.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.l>, ag {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long dDS;
    private long fWG;
    private long fWH;
    private long fWI;
    private long fWJ;
    private int gAe;
    private FrsNetModel<FrsFragment> gFR;
    private e.b gFT;
    private String gFU;
    private final FrsFragment gGR;
    private ArrayList<m> gGW;
    private FrsRequestData gGX;
    private final p gGY;
    private boolean gGZ;
    private int gHa;
    private long gHb;
    private int gHc;
    private int gHd;
    private an gHe;
    private boolean gHf;
    private SparseArray<an> gHg;
    private z gHh;
    private aj gHi;
    private ArrayList<m> gHj;
    private boolean gHk;
    private String gHl;
    private int gHm;
    private int gHn;
    private boolean gHo;
    private String gHp;
    private final SparseArray<Boolean> gHq;
    private aj gHr;
    private FrsViewData gnZ;
    private String gor;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean tM(int i) {
        return this.gHq.get(i, false).booleanValue();
    }

    public void E(int i, boolean z) {
        this.gHq.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, p pVar) {
        super(frsFragment.getPageContext());
        this.gor = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.gHa = 0;
        this.mSource = null;
        this.gFU = null;
        this.gHb = 0L;
        this.gAe = 1;
        this.gHc = 0;
        this.gHd = 0;
        this.gHf = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.gHg = new SparseArray<>();
        this.dDS = 0L;
        this.gHk = false;
        this.gHm = -1;
        this.gHn = -1;
        this.gHp = null;
        this.gHq = new SparseArray<>();
        this.gHr = new aj() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.aj
            public void a(int i, int i2, aq aqVar, ArrayList<m> arrayList) {
                FrsModelController.this.gHf = false;
                if (i == FrsModelController.this.gAe && FrsModelController.this.gHi != null) {
                    FrsModelController.this.gHe = aqVar;
                    FrsModelController.this.b(i, i2, aqVar);
                    ArrayList<m> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.gnZ.setThreadList(arrayList2);
                    FrsModelController.this.gHi.a(i, i2, aqVar, arrayList);
                }
            }
        };
        this.fWG = 0L;
        this.fWH = 0L;
        this.fWI = 0L;
        this.fWJ = 0L;
        if (pVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.gGR = frsFragment;
        this.gGY = pVar;
        M(this.gGR);
    }

    private void M(FrsFragment frsFragment) {
        this.gHh = new z();
        this.gHh.dBx = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.gHh));
        this.gHh.a(this.gHr);
    }

    public void aiI() {
        this.gFR.cancelLoadData();
    }

    public void ad(Bundle bundle) {
        if (bundle != null) {
            this.gor = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.gHl = bundle.getString("yuelaou_locate");
            this.gGZ = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.gHa = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.gHb = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.gGR.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.gor)) {
            this.gor = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.gHl)) {
            this.gHl = "";
        }
        this.mSource = this.mFrom;
        bJf();
        this.gnZ = new FrsViewData();
        this.gGX.eB("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.gor));
        this.gGX.eB("client_type", "2");
        if (this.gFR == null) {
            this.gFR = new FrsNetModel<>(this.gGR.getPageContext(), this.gGX);
        }
        this.gFR.a(this);
        this.gFR.setUniqueId(this.gGR.getPageContext().getUniqueId());
        if (this.gor != null && this.gor.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.gor);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void bJf() {
        AccountData currentAccountObj;
        this.gGX = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            tN(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            tN(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            tN(com.baidu.tieba.frs.f.g.BN("1~" + str + this.gor));
        }
        this.gGX.setSortType(getSortType());
        if (this.gHm == 5) {
            this.gGX.setIsGood(1);
        } else {
            this.gGX.setIsGood(0);
        }
    }

    public boolean bvQ() {
        if (this.gAe != 1) {
            tJ(1);
            return true;
        } else if (this.gFR.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gGX), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void F(int i, boolean z) {
        this.gGR.goE = System.currentTimeMillis();
        if (this.gnZ != null && this.gnZ.getLikeFeedForumDataList() != null) {
            this.gnZ.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gGX), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.gAe = c(this.gAe, frsRequestData);
        if (this.gAe == 1) {
            if (!this.gFR.isLoading()) {
                frsRequestData.setCallFrom(this.gHa);
                a(frsRequestData, i, z ? false : true);
                this.gHa = 0;
                return;
            }
            return;
        }
        if (this.gHe == null) {
            this.gHe = new an();
            this.gHe.pn = 1;
            this.gHe.forumName = this.gor;
            if (this.gnZ != null && this.gnZ.getForum() != null) {
                this.gHe.forumId = this.gnZ.getForum().getId();
            }
        }
        tJ(i);
    }

    public void tK(int i) {
        if (this.gAe != 1) {
            tJ(4);
        } else if (!this.gFR.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gGX), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.gGR.lg(z);
        this.gGY.sG(i);
        this.gFR.a(frsRequestData);
        this.mType = i;
        frsRequestData.IT(this.gGR.bEt() ? "1" : "2");
        if (this.gHo) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.uf(this.gHn)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.gHo = false;
        frsRequestData.setKw(this.gor);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = ar.aGD().aGE() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.gFU);
        frsRequestData.setYuelaouLocate(this.gHl);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(aa.aSr(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.Cr(bJg());
        if (FrsFragment.goF != 0) {
            frsRequestData.setCtime((int) FrsFragment.goF);
        }
        if (FrsFragment.goG != 0) {
            frsRequestData.setDataSize((int) FrsFragment.goG);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.eD(this.gHb);
        if (this.gHb != 0) {
            this.gHb = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.gHm, frsRequestData);
        b(i, frsRequestData);
        a(this.gor, frsRequestData);
        if (!tM(this.gHm) && !this.gGR.gos) {
            String e = com.baidu.tieba.tbadkCore.d.cKc().e("1~" + this.gor, frsRequestData.getSortType(), frsRequestData.getIsGood(), this.gGX.getCategoryId());
            this.gHp = e;
            new a(this, true, e).execute(new Object[0]);
        }
        bIO();
    }

    private int bJg() {
        return (this.gGR == null || !(this.gGR.mHeadLineDefaultNavTabId == -1 || this.gGR.mHeadLineDefaultNavTabId == this.gAe)) ? 0 : 1;
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
        tN(com.baidu.tieba.frs.f.g.ug(lVar.getSortType()));
        E(com.baidu.tieba.frs.f.g.ug(lVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.gAe = lVar.getFrsDefaultTabId();
        }
        this.gnZ.receiveData(lVar);
        d(this.gnZ);
        this.gGW = new ArrayList<>();
        if (frsRequestData != null) {
            this.gGX = frsRequestData;
            this.mPn = this.gGX.getPn();
            this.gor = this.gGX.getKw();
            this.gGR.setForumName(this.gor);
            this.gGR.setFrom(this.mFrom);
            this.gGR.setPn(this.mPn);
            this.gGR.setFlag(this.mFlag);
        }
        if (this.gnZ.getThreadList() != null) {
            this.gGW.addAll(this.gnZ.getThreadList());
        }
        if (this.gAe != 1 && this.isNetFirstLoad) {
            this.gGY.a(7, false, this.gFT);
        } else {
            this.gGY.a(this.mType, false, this.gFT);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.gGX)) {
            bJv();
        }
        this.isNetFirstLoad = false;
        if (lVar.getForum() != null && !TextUtils.isEmpty(lVar.getForum().getName()) && frsRequestData != null && r.cCw().cCq() != null) {
            r.cCw().cCq().g(lVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        com.baidu.tieba.frs.a.bCW().lb(this.gAe == 301);
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
            bVar.fZC = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            bVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.keu = mvcSocketResponsedMessage.getDownSize();
            this.gFT = bVar;
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
                this.gGR.a(errorData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.gHk) {
            this.gHk = true;
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
            bVar.fZC = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            bVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.keu = mvcHttpResponsedMessage.getDownSize();
            this.gFT = bVar;
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
                this.gGR.a(errorData);
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
        if (!this.gHk) {
            this.gHk = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bEk() {
        if (this.gnZ != null && this.gnZ.getForum() != null && this.gnZ.getForum().getBannerListData() != null) {
            String lastIds = this.gnZ.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.gFU = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aRm().aRn()) {
            this.dDS = System.currentTimeMillis() - this.gGR.fVt;
            this.gGR.dDR = System.currentTimeMillis() - this.gGR.goD;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, this.gGR.dDJ, this.gGR.createTime, this.gGR.dDR, false, this.dDS);
            this.gGR.createTime = 0L;
            this.gGR.dDJ = 0L;
            com.baidu.tieba.frs.f.h.a(this, this.gGR.fVt);
            this.gGR.fVt = -1L;
            iVar.aRj();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aRm().aRn()) {
            this.dDS = System.currentTimeMillis() - this.gGR.goE;
            this.gGR.dDR = System.currentTimeMillis() - this.gGR.goD;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1000, z, responsedMessage, this.gGR.dDJ, this.gGR.createTime, this.gGR.dDR, false, this.dDS);
            if (this.mType == 4) {
                iVar.dEa = this.dDS;
                iVar.gT(true);
            } else if (this.mType == 3) {
                iVar.dEb = this.dDS;
                iVar.gT(false);
            }
        }
    }

    public FrsRequestData bJh() {
        return this.gGX;
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

    public FrsViewData bIN() {
        return this.gnZ;
    }

    public e.b bJi() {
        return this.gFT;
    }

    private void bIO() {
        this.fWG = System.currentTimeMillis();
        this.gFR.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.tieba.tbadkCore.l lVar) {
        this.isCacheFirstLoad = false;
        this.gnZ.receiveData(lVar);
        d(this.gnZ);
        this.gGW = new ArrayList<>();
        if (this.gnZ.getThreadList() != null) {
            this.gGW.addAll(this.gnZ.getThreadList());
        }
        this.gGY.c(lVar);
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

    /* loaded from: classes9.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.l, Void> {
        private String gHA;
        private FrsModelController gHB;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.gHA = null;
            this.gHA = str;
            this.gHB = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.d.cKc().IR(this.gHA)) {
                if (!com.baidu.tieba.tbadkCore.d.cKc().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.gHA)) {
                    com.baidu.tieba.tbadkCore.d.cKc().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.l responseData = com.baidu.tieba.tbadkCore.d.cKc().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().aAz(), true) && !responseData.getBookInfo().aAz().equals("0") && responseData.getBookInfo().aAA() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().aAz(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.gHB != null && lVarArr != null) {
                this.gHB.g(lVarArr.length > 0 ? lVarArr[0] : null);
                this.gHB.E(this.gHB.gHm, true);
            }
        }
    }

    public long byN() {
        return this.fWJ;
    }

    public long byO() {
        return this.fWH;
    }

    public long byP() {
        return this.fWI;
    }

    public long byQ() {
        return this.fWG;
    }

    public boolean isLoading() {
        return this.gFR.isLoading();
    }

    public int bJj() {
        return this.gHd;
    }

    private void bJk() {
        if (this.gHj == null) {
            this.gHj = new ArrayList<>();
        }
        if (this.gHj.size() == 0) {
            this.gHj.add(new v());
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(int i, int i2, an anVar) {
        this.gAe = c(i, null);
        if (anVar == null && (anVar = bQ(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.gHi != null) {
                aq aqVar = new aq();
                aqVar.hasMore = false;
                aqVar.pn = 1;
                aqVar.forumName = this.gor;
                aqVar.gsG = false;
                if (this.gnZ != null && this.gnZ.getForum() != null) {
                    aqVar.forumId = this.gnZ.getForum().getId();
                }
                bJk();
                this.gnZ.setThreadList(this.gHj);
                this.gHi.a(i, i2, aqVar, this.gHj);
            }
            anVar = new an();
            anVar.pn = -1;
        }
        if (this.gnZ != null && this.gnZ.getForum() != null) {
            anVar.forumId = this.gnZ.getForum().getId();
        }
        anVar.forumName = this.gor;
        if (x.bFE().sY(1) != null && this.gAe == 1) {
            this.gGX.setCategoryId(i2);
        }
        this.gHc = i2;
        this.gHe = anVar;
        b(i, i2, anVar);
        tJ(5);
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(aj ajVar) {
        this.gHi = ajVar;
        this.gHh.a(this.gHr);
    }

    private void tJ(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.gHe != null) {
                    this.gHe.pn++;
                    break;
                }
                break;
            case 2:
                if (this.gHe != null) {
                    an anVar = this.gHe;
                    anVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.gHe != null) {
                    this.gHe.pn = -1;
                    break;
                }
                break;
        }
        if (this.gAe == 1) {
            if (this.gHd == this.gHc) {
                ArrayList<m> arrayList = new ArrayList<>();
                if (this.gGW != null) {
                    arrayList.addAll(this.gGW);
                }
                this.gnZ.setThreadList(arrayList);
                if (this.gHi != null) {
                    this.gHi.a(this.gAe, this.gHc, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.gHd = this.gHc;
            return;
        }
        ag sZ = this.gHh.sZ(this.gAe);
        if (sZ != null) {
            this.gHf = true;
            sZ.a(this.gAe, this.gHc, this.gHe);
            return;
        }
        if (this.gnZ != null && this.gnZ.getThreadList() != null) {
            this.gnZ.getThreadList().clear();
        }
        this.gHi.a(this.gAe, this.gHc, null, null);
    }

    public boolean hasMore() {
        if ((this.gHe instanceof aq) && ((aq) this.gHe).errCode == 0) {
            return ((aq) this.gHe).hasMore;
        }
        return true;
    }

    private int bP(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, an anVar) {
        this.gHg.put(bP(i, i2), anVar);
    }

    public an bQ(int i, int i2) {
        return this.gHg.get(bP(i, i2));
    }

    @Override // com.baidu.tieba.frs.ag
    public void init() {
        this.gHh.init();
    }

    @Override // com.baidu.tieba.frs.ag
    public void bgX() {
        this.gHh.destory();
        this.gHh.clear();
    }

    public int bJl() {
        return this.gAe;
    }

    public boolean bJm() {
        return 1 == this.gAe;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(am amVar) {
        if (amVar != null && !StringUtils.isNull(amVar.getId()) && !com.baidu.tbadk.core.util.v.isEmpty(this.gGW)) {
            if (this.gAe == 1) {
                this.gnZ.addMyNewThread(amVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<m> it = this.gGW.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if ((next instanceof bi) && amVar.getId().equals(((bi) next).cRg.getId())) {
                    return;
                }
            }
            this.gGW.add(topThreadSize, amVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.gGW == null || this.gGW.size() <= 0) {
            return 0;
        }
        Iterator<m> it = this.gGW.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                m next = it.next();
                if (!(next instanceof bi)) {
                    i = i2;
                } else if (((bi) next).cRg.aCj() != 0) {
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

    public boolean bJn() {
        return this.gHf;
    }

    public void bJo() {
        n nVar = new n();
        if (this.gHd == 0) {
            nVar.sR(this.gHm);
        }
        if (this.gnZ.getThreadList() != null) {
            this.gnZ.getThreadList().clear();
            this.gnZ.getThreadList().add(nVar);
        }
        if (this.gGW != null) {
            this.gGW.clear();
            this.gGW.add(nVar);
        }
    }

    public ArrayList<m> bJp() {
        return this.gGW;
    }

    public void tN(int i) {
        AccountData currentAccountObj;
        this.gHm = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
        }
        com.baidu.tieba.frs.f.g.aC("1~" + str + this.gor, this.gHm);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cMb();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cMc();
        }
    }

    public void tO(int i) {
        this.gHn = i;
    }

    public void lY(boolean z) {
        this.gHo = z;
    }

    public int bJq() {
        return this.gHm;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.uf(this.gHm);
    }

    public boolean bJr() {
        return this.gGZ;
    }

    public boolean bJs() {
        return this.gHm == 5;
    }

    public boolean bJt() {
        return this.gGX != null && this.gGX.getLoadType() == 1;
    }

    public boolean bJu() {
        return this.gHm == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.gGR.bDH() != null) {
            return this.gGR.bDH().a(this.gHm, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bj.cRP.get() && r.cCw().cCq() != null) {
            int ax = r.cCw().cCq().ax(str, false);
            int ay = r.cCw().cCq().ay(str, false);
            if (frsRequestData.getLoadType() == 1) {
                ax++;
            } else if (frsRequestData.getLoadType() == 2) {
                ay++;
            }
            frsRequestData.setRefreshCount(ax);
            frsRequestData.setLoadCount(ay);
        }
    }

    public void bJv() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.gnZ != null && this.gnZ.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.gnZ.getForum().getId(), 0L));
        }
        this.gGR.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void BE(final String str) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cKc().ey(FrsModelController.this.gHp, str);
                return null;
            }
        }, null);
    }

    public void BF(final String str) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.5
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cKc().ez(FrsModelController.this.gHp, str);
                return null;
            }
        }, null);
    }

    public void BG(final String str) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.6
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cKc().eA(FrsModelController.this.gHp, str);
                return null;
            }
        }, null);
    }
}
