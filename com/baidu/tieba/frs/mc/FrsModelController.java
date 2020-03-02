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
    private long dDF;
    private long fWt;
    private long fWu;
    private long fWv;
    private long fWw;
    private FrsNetModel<FrsFragment> gFF;
    private e.b gFH;
    private String gFI;
    private final FrsFragment gGF;
    private ArrayList<m> gGK;
    private FrsRequestData gGL;
    private final p gGM;
    private boolean gGN;
    private int gGO;
    private long gGP;
    private int gGQ;
    private int gGR;
    private an gGS;
    private boolean gGT;
    private SparseArray<an> gGU;
    private z gGV;
    private aj gGW;
    private ArrayList<m> gGX;
    private boolean gGY;
    private String gGZ;
    private int gHa;
    private int gHb;
    private boolean gHc;
    private String gHd;
    private final SparseArray<Boolean> gHe;
    private aj gHf;
    private FrsViewData gnM;
    private String goe;
    private int gzS;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean tM(int i) {
        return this.gHe.get(i, false).booleanValue();
    }

    public void E(int i, boolean z) {
        this.gHe.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, p pVar) {
        super(frsFragment.getPageContext());
        this.goe = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.gGO = 0;
        this.mSource = null;
        this.gFI = null;
        this.gGP = 0L;
        this.gzS = 1;
        this.gGQ = 0;
        this.gGR = 0;
        this.gGT = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.gGU = new SparseArray<>();
        this.dDF = 0L;
        this.gGY = false;
        this.gHa = -1;
        this.gHb = -1;
        this.gHd = null;
        this.gHe = new SparseArray<>();
        this.gHf = new aj() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.aj
            public void a(int i, int i2, aq aqVar, ArrayList<m> arrayList) {
                FrsModelController.this.gGT = false;
                if (i == FrsModelController.this.gzS && FrsModelController.this.gGW != null) {
                    FrsModelController.this.gGS = aqVar;
                    FrsModelController.this.b(i, i2, aqVar);
                    ArrayList<m> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.gnM.setThreadList(arrayList2);
                    FrsModelController.this.gGW.a(i, i2, aqVar, arrayList);
                }
            }
        };
        this.fWt = 0L;
        this.fWu = 0L;
        this.fWv = 0L;
        this.fWw = 0L;
        if (pVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.gGF = frsFragment;
        this.gGM = pVar;
        M(this.gGF);
    }

    private void M(FrsFragment frsFragment) {
        this.gGV = new z();
        this.gGV.dBk = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.gGV));
        this.gGV.a(this.gHf);
    }

    public void aiI() {
        this.gFF.cancelLoadData();
    }

    public void ad(Bundle bundle) {
        if (bundle != null) {
            this.goe = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.gGZ = bundle.getString("yuelaou_locate");
            this.gGN = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.gGO = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.gGP = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.gGF.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.goe)) {
            this.goe = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.gGZ)) {
            this.gGZ = "";
        }
        this.mSource = this.mFrom;
        bJe();
        this.gnM = new FrsViewData();
        this.gGL.eB("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.goe));
        this.gGL.eB("client_type", "2");
        if (this.gFF == null) {
            this.gFF = new FrsNetModel<>(this.gGF.getPageContext(), this.gGL);
        }
        this.gFF.a(this);
        this.gFF.setUniqueId(this.gGF.getPageContext().getUniqueId());
        if (this.goe != null && this.goe.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.goe);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void bJe() {
        AccountData currentAccountObj;
        this.gGL = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            tN(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            tN(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            tN(com.baidu.tieba.frs.f.g.BM("1~" + str + this.goe));
        }
        this.gGL.setSortType(getSortType());
        if (this.gHa == 5) {
            this.gGL.setIsGood(1);
        } else {
            this.gGL.setIsGood(0);
        }
    }

    public boolean bvP() {
        if (this.gzS != 1) {
            tJ(1);
            return true;
        } else if (this.gFF.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gGL), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void F(int i, boolean z) {
        this.gGF.gor = System.currentTimeMillis();
        if (this.gnM != null && this.gnM.getLikeFeedForumDataList() != null) {
            this.gnM.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gGL), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.gzS = c(this.gzS, frsRequestData);
        if (this.gzS == 1) {
            if (!this.gFF.isLoading()) {
                frsRequestData.setCallFrom(this.gGO);
                a(frsRequestData, i, z ? false : true);
                this.gGO = 0;
                return;
            }
            return;
        }
        if (this.gGS == null) {
            this.gGS = new an();
            this.gGS.pn = 1;
            this.gGS.forumName = this.goe;
            if (this.gnM != null && this.gnM.getForum() != null) {
                this.gGS.forumId = this.gnM.getForum().getId();
            }
        }
        tJ(i);
    }

    public void tK(int i) {
        if (this.gzS != 1) {
            tJ(4);
        } else if (!this.gFF.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gGL), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.gGF.lg(z);
        this.gGM.sG(i);
        this.gFF.a(frsRequestData);
        this.mType = i;
        frsRequestData.IS(this.gGF.bEs() ? "1" : "2");
        if (this.gHc) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.uf(this.gHb)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.gHc = false;
        frsRequestData.setKw(this.goe);
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
        frsRequestData.setLastId(this.gFI);
        frsRequestData.setYuelaouLocate(this.gGZ);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(aa.aSq(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.Cr(bJf());
        if (FrsFragment.gos != 0) {
            frsRequestData.setCtime((int) FrsFragment.gos);
        }
        if (FrsFragment.got != 0) {
            frsRequestData.setDataSize((int) FrsFragment.got);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.eD(this.gGP);
        if (this.gGP != 0) {
            this.gGP = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.gHa, frsRequestData);
        b(i, frsRequestData);
        a(this.goe, frsRequestData);
        if (!tM(this.gHa) && !this.gGF.gof) {
            String e = com.baidu.tieba.tbadkCore.d.cKb().e("1~" + this.goe, frsRequestData.getSortType(), frsRequestData.getIsGood(), this.gGL.getCategoryId());
            this.gHd = e;
            new a(this, true, e).execute(new Object[0]);
        }
        bIN();
    }

    private int bJf() {
        return (this.gGF == null || !(this.gGF.mHeadLineDefaultNavTabId == -1 || this.gGF.mHeadLineDefaultNavTabId == this.gzS)) ? 0 : 1;
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
            this.gzS = lVar.getFrsDefaultTabId();
        }
        this.gnM.receiveData(lVar);
        d(this.gnM);
        this.gGK = new ArrayList<>();
        if (frsRequestData != null) {
            this.gGL = frsRequestData;
            this.mPn = this.gGL.getPn();
            this.goe = this.gGL.getKw();
            this.gGF.setForumName(this.goe);
            this.gGF.setFrom(this.mFrom);
            this.gGF.setPn(this.mPn);
            this.gGF.setFlag(this.mFlag);
        }
        if (this.gnM.getThreadList() != null) {
            this.gGK.addAll(this.gnM.getThreadList());
        }
        if (this.gzS != 1 && this.isNetFirstLoad) {
            this.gGM.a(7, false, this.gFH);
        } else {
            this.gGM.a(this.mType, false, this.gFH);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.gGL)) {
            bJu();
        }
        this.isNetFirstLoad = false;
        if (lVar.getForum() != null && !TextUtils.isEmpty(lVar.getForum().getName()) && frsRequestData != null && r.cCv().cCp() != null) {
            r.cCv().cCp().g(lVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        com.baidu.tieba.frs.a.bCV().lb(this.gzS == 301);
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
            bVar.fZp = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            bVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            bVar.errorCode = mvcSocketResponsedMessage.getError();
            bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            bVar.kei = mvcSocketResponsedMessage.getDownSize();
            this.gFH = bVar;
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
                this.gGF.a(errorData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.gGY) {
            this.gGY = true;
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
            bVar.fZp = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            bVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            bVar.errorCode = mvcHttpResponsedMessage.getError();
            bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            bVar.kei = mvcHttpResponsedMessage.getDownSize();
            this.gFH = bVar;
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
                this.gGF.a(errorData);
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
        if (!this.gGY) {
            this.gGY = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bEj() {
        if (this.gnM != null && this.gnM.getForum() != null && this.gnM.getForum().getBannerListData() != null) {
            String lastIds = this.gnM.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.gFI = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aRl().aRm()) {
            this.dDF = System.currentTimeMillis() - this.gGF.fVg;
            this.gGF.dDE = System.currentTimeMillis() - this.gGF.goq;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, this.gGF.dDw, this.gGF.createTime, this.gGF.dDE, false, this.dDF);
            this.gGF.createTime = 0L;
            this.gGF.dDw = 0L;
            com.baidu.tieba.frs.f.h.a(this, this.gGF.fVg);
            this.gGF.fVg = -1L;
            iVar.aRi();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aRl().aRm()) {
            this.dDF = System.currentTimeMillis() - this.gGF.gor;
            this.gGF.dDE = System.currentTimeMillis() - this.gGF.goq;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1000, z, responsedMessage, this.gGF.dDw, this.gGF.createTime, this.gGF.dDE, false, this.dDF);
            if (this.mType == 4) {
                iVar.dDN = this.dDF;
                iVar.gT(true);
            } else if (this.mType == 3) {
                iVar.dDO = this.dDF;
                iVar.gT(false);
            }
        }
    }

    public FrsRequestData bJg() {
        return this.gGL;
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

    public FrsViewData bIM() {
        return this.gnM;
    }

    public e.b bJh() {
        return this.gFH;
    }

    private void bIN() {
        this.fWt = System.currentTimeMillis();
        this.gFF.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.tieba.tbadkCore.l lVar) {
        this.isCacheFirstLoad = false;
        this.gnM.receiveData(lVar);
        d(this.gnM);
        this.gGK = new ArrayList<>();
        if (this.gnM.getThreadList() != null) {
            this.gGK.addAll(this.gnM.getThreadList());
        }
        this.gGM.c(lVar);
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
        private String gHo;
        private FrsModelController gHp;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.gHo = null;
            this.gHo = str;
            this.gHp = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.d.cKb().IQ(this.gHo)) {
                if (!com.baidu.tieba.tbadkCore.d.cKb().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.gHo)) {
                    com.baidu.tieba.tbadkCore.d.cKb().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.l responseData = com.baidu.tieba.tbadkCore.d.cKb().getResponseData();
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
            if (this.gHp != null && lVarArr != null) {
                this.gHp.g(lVarArr.length > 0 ? lVarArr[0] : null);
                this.gHp.E(this.gHp.gHa, true);
            }
        }
    }

    public long byM() {
        return this.fWw;
    }

    public long byN() {
        return this.fWu;
    }

    public long byO() {
        return this.fWv;
    }

    public long byP() {
        return this.fWt;
    }

    public boolean isLoading() {
        return this.gFF.isLoading();
    }

    public int bJi() {
        return this.gGR;
    }

    private void bJj() {
        if (this.gGX == null) {
            this.gGX = new ArrayList<>();
        }
        if (this.gGX.size() == 0) {
            this.gGX.add(new v());
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(int i, int i2, an anVar) {
        this.gzS = c(i, null);
        if (anVar == null && (anVar = bQ(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.gGW != null) {
                aq aqVar = new aq();
                aqVar.hasMore = false;
                aqVar.pn = 1;
                aqVar.forumName = this.goe;
                aqVar.gst = false;
                if (this.gnM != null && this.gnM.getForum() != null) {
                    aqVar.forumId = this.gnM.getForum().getId();
                }
                bJj();
                this.gnM.setThreadList(this.gGX);
                this.gGW.a(i, i2, aqVar, this.gGX);
            }
            anVar = new an();
            anVar.pn = -1;
        }
        if (this.gnM != null && this.gnM.getForum() != null) {
            anVar.forumId = this.gnM.getForum().getId();
        }
        anVar.forumName = this.goe;
        if (x.bFD().sY(1) != null && this.gzS == 1) {
            this.gGL.setCategoryId(i2);
        }
        this.gGQ = i2;
        this.gGS = anVar;
        b(i, i2, anVar);
        tJ(5);
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(aj ajVar) {
        this.gGW = ajVar;
        this.gGV.a(this.gHf);
    }

    private void tJ(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.gGS != null) {
                    this.gGS.pn++;
                    break;
                }
                break;
            case 2:
                if (this.gGS != null) {
                    an anVar = this.gGS;
                    anVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.gGS != null) {
                    this.gGS.pn = -1;
                    break;
                }
                break;
        }
        if (this.gzS == 1) {
            if (this.gGR == this.gGQ) {
                ArrayList<m> arrayList = new ArrayList<>();
                if (this.gGK != null) {
                    arrayList.addAll(this.gGK);
                }
                this.gnM.setThreadList(arrayList);
                if (this.gGW != null) {
                    this.gGW.a(this.gzS, this.gGQ, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.gGR = this.gGQ;
            return;
        }
        ag sZ = this.gGV.sZ(this.gzS);
        if (sZ != null) {
            this.gGT = true;
            sZ.a(this.gzS, this.gGQ, this.gGS);
            return;
        }
        if (this.gnM != null && this.gnM.getThreadList() != null) {
            this.gnM.getThreadList().clear();
        }
        this.gGW.a(this.gzS, this.gGQ, null, null);
    }

    public boolean hasMore() {
        if ((this.gGS instanceof aq) && ((aq) this.gGS).errCode == 0) {
            return ((aq) this.gGS).hasMore;
        }
        return true;
    }

    private int bP(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, an anVar) {
        this.gGU.put(bP(i, i2), anVar);
    }

    public an bQ(int i, int i2) {
        return this.gGU.get(bP(i, i2));
    }

    @Override // com.baidu.tieba.frs.ag
    public void init() {
        this.gGV.init();
    }

    @Override // com.baidu.tieba.frs.ag
    public void bgW() {
        this.gGV.destory();
        this.gGV.clear();
    }

    public int bJk() {
        return this.gzS;
    }

    public boolean bJl() {
        return 1 == this.gzS;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(am amVar) {
        if (amVar != null && !StringUtils.isNull(amVar.getId()) && !com.baidu.tbadk.core.util.v.isEmpty(this.gGK)) {
            if (this.gzS == 1) {
                this.gnM.addMyNewThread(amVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<m> it = this.gGK.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if ((next instanceof bi) && amVar.getId().equals(((bi) next).cRf.getId())) {
                    return;
                }
            }
            this.gGK.add(topThreadSize, amVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.gGK == null || this.gGK.size() <= 0) {
            return 0;
        }
        Iterator<m> it = this.gGK.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                m next = it.next();
                if (!(next instanceof bi)) {
                    i = i2;
                } else if (((bi) next).cRf.aCj() != 0) {
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

    public boolean bJm() {
        return this.gGT;
    }

    public void bJn() {
        n nVar = new n();
        if (this.gGR == 0) {
            nVar.sR(this.gHa);
        }
        if (this.gnM.getThreadList() != null) {
            this.gnM.getThreadList().clear();
            this.gnM.getThreadList().add(nVar);
        }
        if (this.gGK != null) {
            this.gGK.clear();
            this.gGK.add(nVar);
        }
    }

    public ArrayList<m> bJo() {
        return this.gGK;
    }

    public void tN(int i) {
        AccountData currentAccountObj;
        this.gHa = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
        }
        com.baidu.tieba.frs.f.g.aC("1~" + str + this.goe, this.gHa);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cMa();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cMb();
        }
    }

    public void tO(int i) {
        this.gHb = i;
    }

    public void lY(boolean z) {
        this.gHc = z;
    }

    public int bJp() {
        return this.gHa;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.uf(this.gHa);
    }

    public boolean bJq() {
        return this.gGN;
    }

    public boolean bJr() {
        return this.gHa == 5;
    }

    public boolean bJs() {
        return this.gGL != null && this.gGL.getLoadType() == 1;
    }

    public boolean bJt() {
        return this.gHa == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.gGF.bDG() != null) {
            return this.gGF.bDG().a(this.gHa, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bj.cRO.get() && r.cCv().cCp() != null) {
            int ax = r.cCv().cCp().ax(str, false);
            int ay = r.cCv().cCp().ay(str, false);
            if (frsRequestData.getLoadType() == 1) {
                ax++;
            } else if (frsRequestData.getLoadType() == 2) {
                ay++;
            }
            frsRequestData.setRefreshCount(ax);
            frsRequestData.setLoadCount(ay);
        }
    }

    public void bJu() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.gnM != null && this.gnM.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.gnM.getForum().getId(), 0L));
        }
        this.gGF.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void BD(final String str) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cKb().ey(FrsModelController.this.gHd, str);
                return null;
            }
        }, null);
    }

    public void BE(final String str) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.5
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cKb().ez(FrsModelController.this.gHd, str);
                return null;
            }
        }, null);
    }

    public void BF(final String str) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.6
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cKb().eA(FrsModelController.this.gHd, str);
                return null;
            }
        }, null);
    }
}
