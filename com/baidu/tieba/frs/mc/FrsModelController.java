package com.baidu.tieba.frs.mc;

import android.os.Bundle;
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
/* loaded from: classes6.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.l>, ag {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long dzu;
    private long fQP;
    private long fQQ;
    private long fQR;
    private long fQS;
    private FrsNetModel<FrsFragment> gAu;
    private e.b gAw;
    private String gAx;
    private FrsRequestData gBA;
    private final p gBB;
    private boolean gBC;
    private int gBD;
    private long gBE;
    private int gBF;
    private int gBG;
    private an gBH;
    private boolean gBI;
    private SparseArray<an> gBJ;
    private z gBK;
    private aj gBL;
    private ArrayList<m> gBM;
    private boolean gBN;
    private String gBO;
    private int gBP;
    private int gBQ;
    private boolean gBR;
    private String gBS;
    private final SparseArray<Boolean> gBT;
    private aj gBU;
    private final FrsFragment gBu;
    private ArrayList<m> gBz;
    private FrsViewData giA;
    private String giS;
    private int guG;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean tB(int i) {
        return this.gBT.get(i, false).booleanValue();
    }

    public void F(int i, boolean z) {
        this.gBT.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, p pVar) {
        super(frsFragment.getPageContext());
        this.giS = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.gBD = 0;
        this.mSource = null;
        this.gAx = null;
        this.gBE = 0L;
        this.guG = 1;
        this.gBF = 0;
        this.gBG = 0;
        this.gBI = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.gBJ = new SparseArray<>();
        this.dzu = 0L;
        this.gBN = false;
        this.gBP = -1;
        this.gBQ = -1;
        this.gBS = null;
        this.gBT = new SparseArray<>();
        this.gBU = new aj() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.aj
            public void a(int i, int i2, aq aqVar, ArrayList<m> arrayList) {
                FrsModelController.this.gBI = false;
                if (i == FrsModelController.this.guG && FrsModelController.this.gBL != null) {
                    FrsModelController.this.gBH = aqVar;
                    FrsModelController.this.b(i, i2, aqVar);
                    ArrayList<m> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.giA.setThreadList(arrayList2);
                    FrsModelController.this.gBL.a(i, i2, aqVar, arrayList);
                }
            }
        };
        this.fQP = 0L;
        this.fQQ = 0L;
        this.fQR = 0L;
        this.fQS = 0L;
        if (pVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.gBu = frsFragment;
        this.gBB = pVar;
        O(this.gBu);
    }

    private void O(FrsFragment frsFragment) {
        this.gBK = new z();
        this.gBK.dwY = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.gBK));
        this.gBK.a(this.gBU);
    }

    public void afZ() {
        this.gAu.cancelLoadData();
    }

    public void ad(Bundle bundle) {
        if (bundle != null) {
            this.giS = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.gBO = bundle.getString("yuelaou_locate");
            this.gBC = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.gBD = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.gBE = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.gBu.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.giS)) {
            this.giS = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.gBO)) {
            this.gBO = "";
        }
        this.mSource = this.mFrom;
        bGy();
        this.giA = new FrsViewData();
        this.gBA.eq("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.giS));
        this.gBA.eq("client_type", "2");
        if (this.gAu == null) {
            this.gAu = new FrsNetModel<>(this.gBu.getPageContext(), this.gBA);
        }
        this.gAu.a(this);
        this.gAu.setUniqueId(this.gBu.getPageContext().getUniqueId());
        if (this.giS != null && this.giS.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.giS);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void bGy() {
        AccountData currentAccountObj;
        this.gBA = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            tC(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            tC(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            tC(com.baidu.tieba.frs.f.g.Bm("1~" + str + this.giS));
        }
        this.gBA.setSortType(getSortType());
        if (this.gBP == 5) {
            this.gBA.setIsGood(1);
        } else {
            this.gBA.setIsGood(0);
        }
    }

    public boolean bth() {
        if (this.guG != 1) {
            ty(1);
            return true;
        } else if (this.gAu.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gBA), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void G(int i, boolean z) {
        this.gBu.gje = System.currentTimeMillis();
        if (this.giA != null && this.giA.getLikeFeedForumDataList() != null) {
            this.giA.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gBA), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.guG = c(this.guG, frsRequestData);
        if (this.guG == 1) {
            if (!this.gAu.isLoading()) {
                frsRequestData.setCallFrom(this.gBD);
                a(frsRequestData, i, z ? false : true);
                this.gBD = 0;
                return;
            }
            return;
        }
        if (this.gBH == null) {
            this.gBH = new an();
            this.gBH.pn = 1;
            this.gBH.forumName = this.giS;
            if (this.giA != null && this.giA.getForum() != null) {
                this.gBH.forumId = this.giA.getForum().getId();
            }
        }
        ty(i);
    }

    public void tz(int i) {
        if (this.guG != 1) {
            ty(4);
        } else if (!this.gAu.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gBA), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.gBu.kR(z);
        this.gBB.sv(i);
        this.gAu.a(frsRequestData);
        this.mType = i;
        frsRequestData.Iu(this.gBu.bBL() ? "1" : "2");
        if (this.gBR) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.tU(this.gBQ)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.gBR = false;
        frsRequestData.setKw(this.giS);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = ar.aDX().aDY() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.gAx);
        frsRequestData.setYuelaouLocate(this.gBO);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(aa.aPE(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.Cf(bGz());
        if (FrsFragment.gjf != 0) {
            frsRequestData.setCtime((int) FrsFragment.gjf);
        }
        if (FrsFragment.gjg != 0) {
            frsRequestData.setDataSize((int) FrsFragment.gjg);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.eA(this.gBE);
        if (this.gBE != 0) {
            this.gBE = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.gBP, frsRequestData);
        b(i, frsRequestData);
        a(this.giS, frsRequestData);
        if (!tB(this.gBP) && !this.gBu.giT) {
            String e = com.baidu.tieba.tbadkCore.d.cHp().e("1~" + this.giS, frsRequestData.getSortType(), frsRequestData.getIsGood(), this.gBA.getCategoryId());
            this.gBS = e;
            new a(this, true, e).execute(new Object[0]);
        }
        bGi();
    }

    private int bGz() {
        return (this.gBu == null || !(this.gBu.mHeadLineDefaultNavTabId == -1 || this.gBu.mHeadLineDefaultNavTabId == this.guG)) ? 0 : 1;
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
        tC(com.baidu.tieba.frs.f.g.tV(lVar.getSortType()));
        F(com.baidu.tieba.frs.f.g.tV(lVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.guG = lVar.getFrsDefaultTabId();
        }
        this.giA.receiveData(lVar);
        d(this.giA);
        this.gBz = new ArrayList<>();
        if (frsRequestData != null) {
            this.gBA = frsRequestData;
            this.mPn = this.gBA.getPn();
            this.giS = this.gBA.getKw();
            this.gBu.setForumName(this.giS);
            this.gBu.setFrom(this.mFrom);
            this.gBu.setPn(this.mPn);
            this.gBu.setFlag(this.mFlag);
        }
        if (this.giA.getThreadList() != null) {
            this.gBz.addAll(this.giA.getThreadList());
        }
        if (this.guG != 1 && this.isNetFirstLoad) {
            this.gBB.a(7, false, this.gAw);
        } else {
            this.gBB.a(this.mType, false, this.gAw);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.gBA)) {
            bGO();
        }
        this.isNetFirstLoad = false;
        if (lVar.getForum() != null && !TextUtils.isEmpty(lVar.getForum().getName()) && frsRequestData != null && r.czO().czI() != null) {
            r.czO().czI().g(lVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        com.baidu.tieba.frs.a.bAp().kM(this.guG == 301);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        e.b bVar = new e.b();
        bVar.fUe = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcSocketResponsedMessage.getError();
        bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        bVar.jZz = mvcSocketResponsedMessage.getDownSize();
        this.gAw = bVar;
        if (mvcSocketResponsedMessage == null || (mvcSocketResponsedMessage.hasError() && 340001 != mvcSocketResponsedMessage.getError())) {
            lVar = null;
        } else {
            lVar = mvcSocketResponsedMessage.getData();
            r3 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && lVar != null && a(r3, lVar)) {
            b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
            return;
        }
        if (mvcSocketResponsedMessage != null) {
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
        }
        ErrorData errorData = new ErrorData();
        errorData.setError_code(this.mErrorCode);
        errorData.setError_msg(this.mErrorString);
        this.gBu.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.gBN) {
            this.gBN = true;
            a(1000, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        }
        a(false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
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
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.l> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        e.b bVar = new e.b();
        bVar.fUe = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcHttpResponsedMessage.getError();
        bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        bVar.jZz = mvcHttpResponsedMessage.getDownSize();
        this.gAw = bVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            lVar = null;
        } else {
            lVar = mvcHttpResponsedMessage.getData();
            r3 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && lVar != null && a(r3, lVar)) {
            b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
            return;
        }
        if (mvcHttpResponsedMessage != null) {
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
        }
        ErrorData errorData = new ErrorData();
        errorData.setError_code(this.mErrorCode);
        errorData.setError_msg(this.mErrorString);
        this.gBu.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        super.registerListener(i, aVar);
    }

    private void b(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.l> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
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
        if (!this.gBN) {
            this.gBN = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bBC() {
        if (this.giA != null && this.giA.getForum() != null && this.giA.getForum().getBannerListData() != null) {
            String lastIds = this.giA.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.gAx = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aOA().aOB()) {
            this.dzu = System.currentTimeMillis() - this.gBu.beginTime;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, this.gBu.dzl, this.gBu.createTime, this.gBu.dzt, false, this.dzu);
            this.gBu.createTime = 0L;
            this.gBu.dzl = 0L;
            if (iVar != null) {
                iVar.aOx();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aOA().aOB()) {
            this.dzu = System.currentTimeMillis() - this.gBu.gje;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1000, z, responsedMessage, this.gBu.dzl, this.gBu.createTime, this.gBu.dzt, false, this.dzu);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.dzC = this.dzu;
                    iVar.gH(true);
                } else if (this.mType == 3) {
                    iVar.dzD = this.dzu;
                    iVar.gH(false);
                }
            }
        }
    }

    public FrsRequestData bGA() {
        return this.gBA;
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

    public FrsViewData bGh() {
        return this.giA;
    }

    public e.b bGB() {
        return this.gAw;
    }

    private void bGi() {
        this.fQP = System.currentTimeMillis();
        this.gAu.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.tieba.tbadkCore.l lVar) {
        this.isCacheFirstLoad = false;
        this.giA.receiveData(lVar);
        d(this.giA);
        this.gBz = new ArrayList<>();
        if (this.giA.getThreadList() != null) {
            this.gBz.addAll(this.giA.getThreadList());
        }
        this.gBB.c(lVar);
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

    /* loaded from: classes6.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.l, Void> {
        private String gBY;
        private FrsModelController gBZ;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.gBY = null;
            this.gBY = str;
            this.gBZ = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.d.cHp().Is(this.gBY)) {
                if (!com.baidu.tieba.tbadkCore.d.cHp().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.gBY)) {
                    com.baidu.tieba.tbadkCore.d.cHp().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.l responseData = com.baidu.tieba.tbadkCore.d.cHp().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().axQ(), true) && !responseData.getBookInfo().axQ().equals("0") && responseData.getBookInfo().axR() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().axQ(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.gBZ != null && lVarArr != null) {
                this.gBZ.g(lVarArr.length > 0 ? lVarArr[0] : null);
                this.gBZ.F(this.gBZ.gBP, true);
            }
        }
    }

    public long bwd() {
        return this.fQS;
    }

    public long bwe() {
        return this.fQQ;
    }

    public long bwf() {
        return this.fQR;
    }

    public long bwg() {
        return this.fQP;
    }

    public boolean isLoading() {
        return this.gAu.isLoading();
    }

    public int bGC() {
        return this.gBG;
    }

    private void bGD() {
        if (this.gBM == null) {
            this.gBM = new ArrayList<>();
        }
        if (this.gBM.size() == 0) {
            this.gBM.add(new v());
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(int i, int i2, an anVar) {
        this.guG = c(i, null);
        if (anVar == null && (anVar = bQ(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.gBL != null) {
                aq aqVar = new aq();
                aqVar.hasMore = false;
                aqVar.pn = 1;
                aqVar.forumName = this.giS;
                aqVar.gnh = false;
                if (this.giA != null && this.giA.getForum() != null) {
                    aqVar.forumId = this.giA.getForum().getId();
                }
                bGD();
                this.giA.setThreadList(this.gBM);
                this.gBL.a(i, i2, aqVar, this.gBM);
            }
            anVar = new an();
            anVar.pn = -1;
        }
        if (this.giA != null && this.giA.getForum() != null) {
            anVar.forumId = this.giA.getForum().getId();
        }
        anVar.forumName = this.giS;
        if (x.bCW().sN(1) != null && this.guG == 1) {
            this.gBA.setCategoryId(i2);
        }
        this.gBF = i2;
        this.gBH = anVar;
        b(i, i2, anVar);
        ty(5);
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(aj ajVar) {
        this.gBL = ajVar;
        this.gBK.a(this.gBU);
    }

    private void ty(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.gBH != null) {
                    this.gBH.pn++;
                    break;
                }
                break;
            case 2:
                if (this.gBH != null) {
                    an anVar = this.gBH;
                    anVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.gBH != null) {
                    this.gBH.pn = -1;
                    break;
                }
                break;
        }
        if (this.guG == 1) {
            if (this.gBG == this.gBF) {
                ArrayList<m> arrayList = new ArrayList<>();
                if (this.gBz != null) {
                    arrayList.addAll(this.gBz);
                }
                this.giA.setThreadList(arrayList);
                if (this.gBL != null) {
                    this.gBL.a(this.guG, this.gBF, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.gBG = this.gBF;
            return;
        }
        ag sO = this.gBK.sO(this.guG);
        if (sO != null) {
            this.gBI = true;
            sO.a(this.guG, this.gBF, this.gBH);
            return;
        }
        if (this.giA != null && this.giA.getThreadList() != null) {
            this.giA.getThreadList().clear();
        }
        this.gBL.a(this.guG, this.gBF, null, null);
    }

    public boolean hasMore() {
        if ((this.gBH instanceof aq) && ((aq) this.gBH).errCode == 0) {
            return ((aq) this.gBH).hasMore;
        }
        return true;
    }

    private int bP(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, an anVar) {
        this.gBJ.put(bP(i, i2), anVar);
    }

    public an bQ(int i, int i2) {
        return this.gBJ.get(bP(i, i2));
    }

    @Override // com.baidu.tieba.frs.ag
    public void init() {
        this.gBK.init();
    }

    @Override // com.baidu.tieba.frs.ag
    public void bep() {
        this.gBK.destory();
        this.gBK.clear();
    }

    public int bGE() {
        return this.guG;
    }

    public boolean bGF() {
        return 1 == this.guG;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(am amVar) {
        if (amVar != null && !StringUtils.isNull(amVar.getId()) && !com.baidu.tbadk.core.util.v.isEmpty(this.gBz)) {
            if (this.guG == 1) {
                this.giA.addMyNewThread(amVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<m> it = this.gBz.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if ((next instanceof bi) && amVar.getId().equals(((bi) next).cMR.getId())) {
                    return;
                }
            }
            this.gBz.add(topThreadSize, amVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.gBz == null || this.gBz.size() <= 0) {
            return 0;
        }
        Iterator<m> it = this.gBz.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                m next = it.next();
                if (!(next instanceof bi)) {
                    i = i2;
                } else if (((bi) next).cMR.azz() != 0) {
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

    public boolean bGG() {
        return this.gBI;
    }

    public void bGH() {
        n nVar = new n();
        if (this.gBG == 0) {
            nVar.sG(this.gBP);
        }
        if (this.giA.getThreadList() != null) {
            this.giA.getThreadList().clear();
            this.giA.getThreadList().add(nVar);
        }
        if (this.gBz != null) {
            this.gBz.clear();
            this.gBz.add(nVar);
        }
    }

    public ArrayList<m> bGI() {
        return this.gBz;
    }

    public void tC(int i) {
        AccountData currentAccountObj;
        this.gBP = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
        }
        com.baidu.tieba.frs.f.g.aD("1~" + str + this.giS, this.gBP);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cJu();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cJv();
        }
    }

    public void tD(int i) {
        this.gBQ = i;
    }

    public void lL(boolean z) {
        this.gBR = z;
    }

    public int bGJ() {
        return this.gBP;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.tU(this.gBP);
    }

    public boolean bGK() {
        return this.gBC;
    }

    public boolean bGL() {
        return this.gBP == 5;
    }

    public boolean bGM() {
        return this.gBA != null && this.gBA.getLoadType() == 1;
    }

    public boolean bGN() {
        return this.gBP == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.gBu.bAZ() != null) {
            return this.gBu.bAZ().a(this.gBP, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bj.cNA.get() && r.czO().czI() != null) {
            int ax = r.czO().czI().ax(str, false);
            int ay = r.czO().czI().ay(str, false);
            if (frsRequestData.getLoadType() == 1) {
                ax++;
            } else if (frsRequestData.getLoadType() == 2) {
                ay++;
            }
            frsRequestData.setRefreshCount(ax);
            frsRequestData.setLoadCount(ay);
        }
    }

    public void bGO() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.giA != null && this.giA.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.giA.getForum().getId(), 0L));
        }
        this.gBu.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void Bd(final String str) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cHp().en(FrsModelController.this.gBS, str);
                return null;
            }
        }, null);
    }

    public void Be(final String str) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cHp().eo(FrsModelController.this.gBS, str);
                return null;
            }
        }, null);
    }

    public void Bf(final String str) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cHp().ep(FrsModelController.this.gBS, str);
                return null;
            }
        }, null);
    }
}
