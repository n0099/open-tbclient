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
    private long dDE;
    private long fWr;
    private long fWs;
    private long fWt;
    private long fWu;
    private FrsNetModel<FrsFragment> gFD;
    private e.b gFF;
    private String gFG;
    private final FrsFragment gGD;
    private ArrayList<m> gGI;
    private FrsRequestData gGJ;
    private final p gGK;
    private boolean gGL;
    private int gGM;
    private long gGN;
    private int gGO;
    private int gGP;
    private an gGQ;
    private boolean gGR;
    private SparseArray<an> gGS;
    private z gGT;
    private aj gGU;
    private ArrayList<m> gGV;
    private boolean gGW;
    private String gGX;
    private int gGY;
    private int gGZ;
    private boolean gHa;
    private String gHb;
    private final SparseArray<Boolean> gHc;
    private aj gHd;
    private FrsViewData gnK;
    private String goc;
    private int gzQ;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean tM(int i) {
        return this.gHc.get(i, false).booleanValue();
    }

    public void E(int i, boolean z) {
        this.gHc.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, p pVar) {
        super(frsFragment.getPageContext());
        this.goc = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.gGM = 0;
        this.mSource = null;
        this.gFG = null;
        this.gGN = 0L;
        this.gzQ = 1;
        this.gGO = 0;
        this.gGP = 0;
        this.gGR = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.gGS = new SparseArray<>();
        this.dDE = 0L;
        this.gGW = false;
        this.gGY = -1;
        this.gGZ = -1;
        this.gHb = null;
        this.gHc = new SparseArray<>();
        this.gHd = new aj() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.aj
            public void a(int i, int i2, aq aqVar, ArrayList<m> arrayList) {
                FrsModelController.this.gGR = false;
                if (i == FrsModelController.this.gzQ && FrsModelController.this.gGU != null) {
                    FrsModelController.this.gGQ = aqVar;
                    FrsModelController.this.b(i, i2, aqVar);
                    ArrayList<m> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.gnK.setThreadList(arrayList2);
                    FrsModelController.this.gGU.a(i, i2, aqVar, arrayList);
                }
            }
        };
        this.fWr = 0L;
        this.fWs = 0L;
        this.fWt = 0L;
        this.fWu = 0L;
        if (pVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.gGD = frsFragment;
        this.gGK = pVar;
        M(this.gGD);
    }

    private void M(FrsFragment frsFragment) {
        this.gGT = new z();
        this.gGT.dBj = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.gGT));
        this.gGT.a(this.gHd);
    }

    public void aiG() {
        this.gFD.cancelLoadData();
    }

    public void ad(Bundle bundle) {
        if (bundle != null) {
            this.goc = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.gGX = bundle.getString("yuelaou_locate");
            this.gGL = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.gGM = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.gGN = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.gGD.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.goc)) {
            this.goc = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.gGX)) {
            this.gGX = "";
        }
        this.mSource = this.mFrom;
        bJc();
        this.gnK = new FrsViewData();
        this.gGJ.eB("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.goc));
        this.gGJ.eB("client_type", "2");
        if (this.gFD == null) {
            this.gFD = new FrsNetModel<>(this.gGD.getPageContext(), this.gGJ);
        }
        this.gFD.a(this);
        this.gFD.setUniqueId(this.gGD.getPageContext().getUniqueId());
        if (this.goc != null && this.goc.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.goc);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void bJc() {
        AccountData currentAccountObj;
        this.gGJ = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            tN(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            tN(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            tN(com.baidu.tieba.frs.f.g.BM("1~" + str + this.goc));
        }
        this.gGJ.setSortType(getSortType());
        if (this.gGY == 5) {
            this.gGJ.setIsGood(1);
        } else {
            this.gGJ.setIsGood(0);
        }
    }

    public boolean bvN() {
        if (this.gzQ != 1) {
            tJ(1);
            return true;
        } else if (this.gFD.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gGJ), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void F(int i, boolean z) {
        this.gGD.gop = System.currentTimeMillis();
        if (this.gnK != null && this.gnK.getLikeFeedForumDataList() != null) {
            this.gnK.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gGJ), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.gzQ = c(this.gzQ, frsRequestData);
        if (this.gzQ == 1) {
            if (!this.gFD.isLoading()) {
                frsRequestData.setCallFrom(this.gGM);
                a(frsRequestData, i, z ? false : true);
                this.gGM = 0;
                return;
            }
            return;
        }
        if (this.gGQ == null) {
            this.gGQ = new an();
            this.gGQ.pn = 1;
            this.gGQ.forumName = this.goc;
            if (this.gnK != null && this.gnK.getForum() != null) {
                this.gGQ.forumId = this.gnK.getForum().getId();
            }
        }
        tJ(i);
    }

    public void tK(int i) {
        if (this.gzQ != 1) {
            tJ(4);
        } else if (!this.gFD.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gGJ), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.gGD.lg(z);
        this.gGK.sG(i);
        this.gFD.a(frsRequestData);
        this.mType = i;
        frsRequestData.IS(this.gGD.bEq() ? "1" : "2");
        if (this.gHa) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.uf(this.gGZ)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.gHa = false;
        frsRequestData.setKw(this.goc);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = ar.aGB().aGC() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.gFG);
        frsRequestData.setYuelaouLocate(this.gGX);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(aa.aSo(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.Cr(bJd());
        if (FrsFragment.goq != 0) {
            frsRequestData.setCtime((int) FrsFragment.goq);
        }
        if (FrsFragment.gor != 0) {
            frsRequestData.setDataSize((int) FrsFragment.gor);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.eD(this.gGN);
        if (this.gGN != 0) {
            this.gGN = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.gGY, frsRequestData);
        b(i, frsRequestData);
        a(this.goc, frsRequestData);
        if (!tM(this.gGY) && !this.gGD.god) {
            String e = com.baidu.tieba.tbadkCore.d.cJZ().e("1~" + this.goc, frsRequestData.getSortType(), frsRequestData.getIsGood(), this.gGJ.getCategoryId());
            this.gHb = e;
            new a(this, true, e).execute(new Object[0]);
        }
        bIL();
    }

    private int bJd() {
        return (this.gGD == null || !(this.gGD.mHeadLineDefaultNavTabId == -1 || this.gGD.mHeadLineDefaultNavTabId == this.gzQ)) ? 0 : 1;
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
            this.gzQ = lVar.getFrsDefaultTabId();
        }
        this.gnK.receiveData(lVar);
        d(this.gnK);
        this.gGI = new ArrayList<>();
        if (frsRequestData != null) {
            this.gGJ = frsRequestData;
            this.mPn = this.gGJ.getPn();
            this.goc = this.gGJ.getKw();
            this.gGD.setForumName(this.goc);
            this.gGD.setFrom(this.mFrom);
            this.gGD.setPn(this.mPn);
            this.gGD.setFlag(this.mFlag);
        }
        if (this.gnK.getThreadList() != null) {
            this.gGI.addAll(this.gnK.getThreadList());
        }
        if (this.gzQ != 1 && this.isNetFirstLoad) {
            this.gGK.a(7, false, this.gFF);
        } else {
            this.gGK.a(this.mType, false, this.gFF);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.gGJ)) {
            bJs();
        }
        this.isNetFirstLoad = false;
        if (lVar.getForum() != null && !TextUtils.isEmpty(lVar.getForum().getName()) && frsRequestData != null && r.cCt().cCn() != null) {
            r.cCt().cCn().g(lVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        com.baidu.tieba.frs.a.bCT().lb(this.gzQ == 301);
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
            bVar.fZn = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            bVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.keg = mvcSocketResponsedMessage.getDownSize();
            this.gFF = bVar;
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
                this.gGD.a(errorData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.gGW) {
            this.gGW = true;
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
            bVar.fZn = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            bVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.keg = mvcHttpResponsedMessage.getDownSize();
            this.gFF = bVar;
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
                this.gGD.a(errorData);
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
        if (!this.gGW) {
            this.gGW = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bEh() {
        if (this.gnK != null && this.gnK.getForum() != null && this.gnK.getForum().getBannerListData() != null) {
            String lastIds = this.gnK.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.gFG = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aRj().aRk()) {
            this.dDE = System.currentTimeMillis() - this.gGD.fVe;
            this.gGD.dDD = System.currentTimeMillis() - this.gGD.goo;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, this.gGD.dDv, this.gGD.createTime, this.gGD.dDD, false, this.dDE);
            this.gGD.createTime = 0L;
            this.gGD.dDv = 0L;
            com.baidu.tieba.frs.f.h.a(this, this.gGD.fVe);
            this.gGD.fVe = -1L;
            iVar.aRg();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aRj().aRk()) {
            this.dDE = System.currentTimeMillis() - this.gGD.gop;
            this.gGD.dDD = System.currentTimeMillis() - this.gGD.goo;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1000, z, responsedMessage, this.gGD.dDv, this.gGD.createTime, this.gGD.dDD, false, this.dDE);
            if (this.mType == 4) {
                iVar.dDM = this.dDE;
                iVar.gT(true);
            } else if (this.mType == 3) {
                iVar.dDN = this.dDE;
                iVar.gT(false);
            }
        }
    }

    public FrsRequestData bJe() {
        return this.gGJ;
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

    public FrsViewData bIK() {
        return this.gnK;
    }

    public e.b bJf() {
        return this.gFF;
    }

    private void bIL() {
        this.fWr = System.currentTimeMillis();
        this.gFD.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.tieba.tbadkCore.l lVar) {
        this.isCacheFirstLoad = false;
        this.gnK.receiveData(lVar);
        d(this.gnK);
        this.gGI = new ArrayList<>();
        if (this.gnK.getThreadList() != null) {
            this.gGI.addAll(this.gnK.getThreadList());
        }
        this.gGK.c(lVar);
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
        private String gHm;
        private FrsModelController gHn;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.gHm = null;
            this.gHm = str;
            this.gHn = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.d.cJZ().IQ(this.gHm)) {
                if (!com.baidu.tieba.tbadkCore.d.cJZ().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.gHm)) {
                    com.baidu.tieba.tbadkCore.d.cJZ().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.l responseData = com.baidu.tieba.tbadkCore.d.cJZ().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().aAx(), true) && !responseData.getBookInfo().aAx().equals("0") && responseData.getBookInfo().aAy() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().aAx(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.gHn != null && lVarArr != null) {
                this.gHn.g(lVarArr.length > 0 ? lVarArr[0] : null);
                this.gHn.E(this.gHn.gGY, true);
            }
        }
    }

    public long byK() {
        return this.fWu;
    }

    public long byL() {
        return this.fWs;
    }

    public long byM() {
        return this.fWt;
    }

    public long byN() {
        return this.fWr;
    }

    public boolean isLoading() {
        return this.gFD.isLoading();
    }

    public int bJg() {
        return this.gGP;
    }

    private void bJh() {
        if (this.gGV == null) {
            this.gGV = new ArrayList<>();
        }
        if (this.gGV.size() == 0) {
            this.gGV.add(new v());
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(int i, int i2, an anVar) {
        this.gzQ = c(i, null);
        if (anVar == null && (anVar = bQ(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.gGU != null) {
                aq aqVar = new aq();
                aqVar.hasMore = false;
                aqVar.pn = 1;
                aqVar.forumName = this.goc;
                aqVar.gsr = false;
                if (this.gnK != null && this.gnK.getForum() != null) {
                    aqVar.forumId = this.gnK.getForum().getId();
                }
                bJh();
                this.gnK.setThreadList(this.gGV);
                this.gGU.a(i, i2, aqVar, this.gGV);
            }
            anVar = new an();
            anVar.pn = -1;
        }
        if (this.gnK != null && this.gnK.getForum() != null) {
            anVar.forumId = this.gnK.getForum().getId();
        }
        anVar.forumName = this.goc;
        if (x.bFB().sY(1) != null && this.gzQ == 1) {
            this.gGJ.setCategoryId(i2);
        }
        this.gGO = i2;
        this.gGQ = anVar;
        b(i, i2, anVar);
        tJ(5);
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(aj ajVar) {
        this.gGU = ajVar;
        this.gGT.a(this.gHd);
    }

    private void tJ(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.gGQ != null) {
                    this.gGQ.pn++;
                    break;
                }
                break;
            case 2:
                if (this.gGQ != null) {
                    an anVar = this.gGQ;
                    anVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.gGQ != null) {
                    this.gGQ.pn = -1;
                    break;
                }
                break;
        }
        if (this.gzQ == 1) {
            if (this.gGP == this.gGO) {
                ArrayList<m> arrayList = new ArrayList<>();
                if (this.gGI != null) {
                    arrayList.addAll(this.gGI);
                }
                this.gnK.setThreadList(arrayList);
                if (this.gGU != null) {
                    this.gGU.a(this.gzQ, this.gGO, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.gGP = this.gGO;
            return;
        }
        ag sZ = this.gGT.sZ(this.gzQ);
        if (sZ != null) {
            this.gGR = true;
            sZ.a(this.gzQ, this.gGO, this.gGQ);
            return;
        }
        if (this.gnK != null && this.gnK.getThreadList() != null) {
            this.gnK.getThreadList().clear();
        }
        this.gGU.a(this.gzQ, this.gGO, null, null);
    }

    public boolean hasMore() {
        if ((this.gGQ instanceof aq) && ((aq) this.gGQ).errCode == 0) {
            return ((aq) this.gGQ).hasMore;
        }
        return true;
    }

    private int bP(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, an anVar) {
        this.gGS.put(bP(i, i2), anVar);
    }

    public an bQ(int i, int i2) {
        return this.gGS.get(bP(i, i2));
    }

    @Override // com.baidu.tieba.frs.ag
    public void init() {
        this.gGT.init();
    }

    @Override // com.baidu.tieba.frs.ag
    public void bgU() {
        this.gGT.destory();
        this.gGT.clear();
    }

    public int bJi() {
        return this.gzQ;
    }

    public boolean bJj() {
        return 1 == this.gzQ;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(am amVar) {
        if (amVar != null && !StringUtils.isNull(amVar.getId()) && !com.baidu.tbadk.core.util.v.isEmpty(this.gGI)) {
            if (this.gzQ == 1) {
                this.gnK.addMyNewThread(amVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<m> it = this.gGI.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if ((next instanceof bi) && amVar.getId().equals(((bi) next).cRe.getId())) {
                    return;
                }
            }
            this.gGI.add(topThreadSize, amVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.gGI == null || this.gGI.size() <= 0) {
            return 0;
        }
        Iterator<m> it = this.gGI.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                m next = it.next();
                if (!(next instanceof bi)) {
                    i = i2;
                } else if (((bi) next).cRe.aCh() != 0) {
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

    public boolean bJk() {
        return this.gGR;
    }

    public void bJl() {
        n nVar = new n();
        if (this.gGP == 0) {
            nVar.sR(this.gGY);
        }
        if (this.gnK.getThreadList() != null) {
            this.gnK.getThreadList().clear();
            this.gnK.getThreadList().add(nVar);
        }
        if (this.gGI != null) {
            this.gGI.clear();
            this.gGI.add(nVar);
        }
    }

    public ArrayList<m> bJm() {
        return this.gGI;
    }

    public void tN(int i) {
        AccountData currentAccountObj;
        this.gGY = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
        }
        com.baidu.tieba.frs.f.g.aC("1~" + str + this.goc, this.gGY);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cLY();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cLZ();
        }
    }

    public void tO(int i) {
        this.gGZ = i;
    }

    public void lY(boolean z) {
        this.gHa = z;
    }

    public int bJn() {
        return this.gGY;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.uf(this.gGY);
    }

    public boolean bJo() {
        return this.gGL;
    }

    public boolean bJp() {
        return this.gGY == 5;
    }

    public boolean bJq() {
        return this.gGJ != null && this.gGJ.getLoadType() == 1;
    }

    public boolean bJr() {
        return this.gGY == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.gGD.bDE() != null) {
            return this.gGD.bDE().a(this.gGY, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bj.cRN.get() && r.cCt().cCn() != null) {
            int ax = r.cCt().cCn().ax(str, false);
            int ay = r.cCt().cCn().ay(str, false);
            if (frsRequestData.getLoadType() == 1) {
                ax++;
            } else if (frsRequestData.getLoadType() == 2) {
                ay++;
            }
            frsRequestData.setRefreshCount(ax);
            frsRequestData.setLoadCount(ay);
        }
    }

    public void bJs() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.gnK != null && this.gnK.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.gnK.getForum().getId(), 0L));
        }
        this.gGD.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void BD(final String str) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cJZ().ey(FrsModelController.this.gHb, str);
                return null;
            }
        }, null);
    }

    public void BE(final String str) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.5
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cJZ().ez(FrsModelController.this.gHb, str);
                return null;
            }
        }, null);
    }

    public void BF(final String str) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.6
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cJZ().eA(FrsModelController.this.gHb, str);
                return null;
            }
        }, null);
    }
}
