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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.p;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.l>, af {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long cAd;
    private int dmE;
    private long eYL;
    private long eYM;
    private long eYN;
    private long eYO;
    private FrsNetModel<FrsFragment> fLQ;
    private e.b fLS;
    private String fLT;
    private final FrsFragment fMP;
    private ArrayList<m> fMU;
    private FrsRequestData fMV;
    private final p fMW;
    private boolean fMX;
    private int fMY;
    private long fMZ;
    private int fNa;
    private int fNb;
    private am fNc;
    private boolean fNd;
    private SparseArray<am> fNe;
    private y fNf;
    private ai fNg;
    private ArrayList<m> fNh;
    private boolean fNi;
    private String fNj;
    private int fNk;
    private int fNl;
    private boolean fNm;
    private String fNn;
    private final SparseArray<Boolean> fNo;
    private ai fNp;
    private FrsViewData ftR;
    private String fug;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean sz(int i) {
        return this.fNo.get(i, false).booleanValue();
    }

    public void E(int i, boolean z) {
        this.fNo.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, p pVar) {
        super(frsFragment.getPageContext());
        this.fug = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.fMY = 0;
        this.mSource = null;
        this.fLT = null;
        this.fMZ = 0L;
        this.dmE = 1;
        this.fNa = 0;
        this.fNb = 0;
        this.fNd = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.fNe = new SparseArray<>();
        this.cAd = 0L;
        this.fNi = false;
        this.fNk = -1;
        this.fNl = -1;
        this.fNn = null;
        this.fNo = new SparseArray<>();
        this.fNp = new ai() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ai
            public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
                FrsModelController.this.fNd = false;
                if (i == FrsModelController.this.dmE && FrsModelController.this.fNg != null) {
                    FrsModelController.this.fNc = apVar;
                    FrsModelController.this.b(i, i2, apVar);
                    ArrayList<m> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.ftR.setThreadList(arrayList2);
                    FrsModelController.this.fNg.a(i, i2, apVar, arrayList);
                }
            }
        };
        this.eYL = 0L;
        this.eYM = 0L;
        this.eYN = 0L;
        this.eYO = 0L;
        if (pVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.fMP = frsFragment;
        this.fMW = pVar;
        M(this.fMP);
    }

    private void M(FrsFragment frsFragment) {
        this.fNf = new y();
        this.fNf.cxE = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.fNf));
        this.fNf.a(this.fNp);
    }

    public void aFQ() {
        this.fLQ.cancelLoadData();
    }

    public void K(Bundle bundle) {
        if (bundle != null) {
            this.fug = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fNj = bundle.getString("yuelaou_locate");
            this.fMX = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.fMY = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.fMZ = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.fMP.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.fug)) {
            this.fug = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.fNj)) {
            this.fNj = "";
        }
        this.mSource = this.mFrom;
        brp();
        this.ftR = new FrsViewData();
        this.fMV.ek("forum_name", com.baidu.adp.lib.util.k.bi(this.fug));
        this.fMV.ek("client_type", "2");
        if (this.fLQ == null) {
            this.fLQ = new FrsNetModel<>(this.fMP.getPageContext(), this.fMV);
        }
        this.fLQ.a(this);
        this.fLQ.setUniqueId(this.fMP.getPageContext().getUniqueId());
        if (this.fug != null && this.fug.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.fug);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void brp() {
        AccountData currentAccountObj;
        this.fMV = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            sA(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            sA(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            sA(com.baidu.tieba.frs.f.g.xG("1~" + str + this.fug));
        }
        this.fMV.setSortType(getSortType());
        if (this.fNk == 5) {
            this.fMV.setIsGood(1);
        } else {
            this.fMV.setIsGood(0);
        }
    }

    public boolean bbc() {
        if (this.dmE != 1) {
            sw(1);
            return true;
        } else if (this.fLQ.pP()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fMV), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void F(int i, boolean z) {
        this.fMP.fut = System.currentTimeMillis();
        if (this.ftR != null && this.ftR.getLikeFeedForumDataList() != null) {
            this.ftR.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fMV), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.dmE = c(this.dmE, frsRequestData);
        if (this.dmE == 1) {
            if (!this.fLQ.pP()) {
                frsRequestData.setCallFrom(this.fMY);
                a(frsRequestData, i, z ? false : true);
                this.fMY = 0;
                return;
            }
            return;
        }
        if (this.fNc == null) {
            this.fNc = new am();
            this.fNc.pn = 1;
            this.fNc.forumName = this.fug;
            if (this.ftR != null && this.ftR.getForum() != null) {
                this.fNc.forumId = this.ftR.getForum().getId();
            }
        }
        sw(i);
    }

    public void sx(int i) {
        if (this.dmE != 1) {
            sw(4);
        } else if (!this.fLQ.pP()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fMV), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.fMP.jO(z);
        this.fMW.ru(i);
        this.fLQ.a(frsRequestData);
        this.mType = i;
        frsRequestData.EA(this.fMP.bmA() ? "1" : "2");
        if (this.fNm) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.sR(this.fNl)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.fNm = false;
        frsRequestData.setKw(this.fug);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        float ai = com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
        int i2 = as.ajq().ajs() ? 2 : 1;
        frsRequestData.setScrW(af);
        frsRequestData.setScrH(ah);
        frsRequestData.setScrDip(ai);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.fLT);
        frsRequestData.setYuelaouLocate(this.fNj);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(com.baidu.tbadk.util.y.awA(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.fuu != 0) {
            frsRequestData.setCtime((int) FrsFragment.fuu);
        }
        if (FrsFragment.fuv != 0) {
            frsRequestData.setDataSize((int) FrsFragment.fuv);
        }
        if (FrsFragment.fuw != 0) {
            frsRequestData.setNetError(FrsFragment.fuw);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.ex(this.fMZ);
        if (this.fMZ != 0) {
            this.fMZ = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.fNk, frsRequestData);
        b(i, frsRequestData);
        a(this.fug, frsRequestData);
        if (!sz(this.fNk) && !this.fMP.fuh) {
            String c = com.baidu.tieba.tbadkCore.d.coH().c("1~" + this.fug, frsRequestData.getSortType(), frsRequestData.getIsGood(), this.fMV.getCategoryId());
            this.fNn = c;
            new a(this, true, c).execute(new Object[0]);
        }
        bqY();
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
        if (lVar == null || lVar.getForum() == null || (aq.isEmpty(lVar.getForum().getName()) && 340001 != lVar.mErrorNo)) {
            return false;
        }
        sA(com.baidu.tieba.frs.f.g.sS(lVar.getSortType()));
        E(com.baidu.tieba.frs.f.g.sS(lVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.dmE = lVar.getFrsDefaultTabId();
        }
        this.ftR.receiveData(lVar);
        d(this.ftR);
        this.fMU = new ArrayList<>();
        if (frsRequestData != null) {
            this.fMV = frsRequestData;
            this.mPn = this.fMV.getPn();
            this.fug = this.fMV.getKw();
            this.fMP.setForumName(this.fug);
            this.fMP.setFrom(this.mFrom);
            this.fMP.setPn(this.mPn);
            this.fMP.setFlag(this.mFlag);
        }
        if (this.ftR.getThreadList() != null) {
            this.fMU.addAll(this.ftR.getThreadList());
        }
        if (this.dmE != 1 && this.isNetFirstLoad) {
            this.fMW.a(7, false, this.fLS);
        } else {
            this.fMW.a(this.mType, false, this.fLS);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.fMV)) {
            brE();
        }
        this.isNetFirstLoad = false;
        if (lVar.getForum() != null && !TextUtils.isEmpty(lVar.getForum().getName()) && frsRequestData != null && r.chV().chP() != null) {
            r.chV().chP().g(lVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        com.baidu.tieba.frs.a.blf().jJ(this.dmE == 301);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        e.b bVar = new e.b();
        bVar.fcf = com.baidu.adp.lib.util.j.kc() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcSocketResponsedMessage.getError();
        bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        bVar.jdR = mvcSocketResponsedMessage.getDownSize();
        this.fLS = bVar;
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
        this.fMP.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.fNi) {
            this.fNi = true;
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
            objArr[2] = "seq_id";
            objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
            com.baidu.tbadk.core.e.a.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.l> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        e.b bVar = new e.b();
        bVar.fcf = com.baidu.adp.lib.util.j.kc() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcHttpResponsedMessage.getError();
        bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        bVar.jdR = mvcHttpResponsedMessage.getDownSize();
        this.fLS = bVar;
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
        this.fMP.a(errorData);
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
            com.baidu.tbadk.core.e.a.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
        if (!this.fNi) {
            this.fNi = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bms() {
        if (this.ftR != null && this.ftR.getForum() != null && this.ftR.getForum().getBannerListData() != null) {
            String lastIds = this.ftR.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fLT = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.avv().avw()) {
            this.cAd = System.currentTimeMillis() - this.fMP.beginTime;
            com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(i, z, responsedMessage, this.fMP.czU, this.fMP.createTime, this.fMP.cAc, false, this.cAd);
            this.fMP.createTime = 0L;
            this.fMP.czU = 0L;
            if (iVar != null) {
                iVar.avs();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.avv().avw()) {
            this.cAd = System.currentTimeMillis() - this.fMP.fut;
            com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(1000, z, responsedMessage, this.fMP.czU, this.fMP.createTime, this.fMP.cAc, false, this.cAd);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.cAl = this.cAd;
                    iVar.fE(true);
                } else if (this.mType == 3) {
                    iVar.cAm = this.cAd;
                    iVar.fE(false);
                }
            }
        }
    }

    public FrsRequestData brq() {
        return this.fMV;
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

    public FrsViewData bqX() {
        return this.ftR;
    }

    public e.b brr() {
        return this.fLS;
    }

    private void bqY() {
        this.eYL = System.currentTimeMillis();
        this.fLQ.auF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.tieba.tbadkCore.l lVar) {
        this.isCacheFirstLoad = false;
        this.ftR.receiveData(lVar);
        d(this.ftR);
        this.fMU = new ArrayList<>();
        if (this.ftR.getThreadList() != null) {
            this.fMU.addAll(this.ftR.getThreadList());
        }
        this.fMW.c(lVar);
    }

    private void d(FrsViewData frsViewData) {
        if (com.baidu.tieba.frs.vc.f.k(frsViewData)) {
            this.mPageType = "book_page";
        } else if (frsViewData.getIsBrandForum()) {
            this.mPageType = "brand_page";
        } else if (com.baidu.tieba.frs.vc.f.l(frsViewData)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.l, Void> {
        private String fNt;
        private FrsModelController fNu;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.fNt = null;
            this.fNt = str;
            this.fNu = frsModelController;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            int f;
            CustomResponsedMessage runTask;
            if (this.needCache && com.baidu.tieba.tbadkCore.d.coH().Ey(this.fNt)) {
                if (!com.baidu.tieba.tbadkCore.d.coH().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.fNt)) {
                    com.baidu.tieba.tbadkCore.d.coH().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.l responseData = com.baidu.tieba.tbadkCore.d.coH().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().acO(), true) && !responseData.getBookInfo().acO().equals("0") && responseData.getBookInfo().acP() == 3 && (f = com.baidu.adp.lib.g.b.f(responseData.getBookInfo().acO(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(f))) != null) {
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
            if (this.fNu != null && lVarArr != null) {
                this.fNu.g(lVarArr.length > 0 ? lVarArr[0] : null);
                this.fNu.E(this.fNu.fNk, true);
            }
        }
    }

    public long bgm() {
        return this.eYO;
    }

    public long bgn() {
        return this.eYM;
    }

    public long bgo() {
        return this.eYN;
    }

    public long bgp() {
        return this.eYL;
    }

    public boolean pP() {
        return this.fLQ.pP();
    }

    public int brs() {
        return this.fNb;
    }

    private void brt() {
        if (this.fNh == null) {
            this.fNh = new ArrayList<>();
        }
        if (this.fNh.size() == 0) {
            this.fNh.add(new u());
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, int i2, am amVar) {
        this.dmE = c(i, null);
        if (amVar == null && (amVar = bE(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.kt() && this.fNg != null) {
                ap apVar = new ap();
                apVar.hasMore = false;
                apVar.pn = 1;
                apVar.forumName = this.fug;
                apVar.fyA = false;
                if (this.ftR != null && this.ftR.getForum() != null) {
                    apVar.forumId = this.ftR.getForum().getId();
                }
                brt();
                this.ftR.setThreadList(this.fNh);
                this.fNg.a(i, i2, apVar, this.fNh);
            }
            amVar = new am();
            amVar.pn = -1;
        }
        if (this.ftR != null && this.ftR.getForum() != null) {
            amVar.forumId = this.ftR.getForum().getId();
        }
        amVar.forumName = this.fug;
        if (w.bnN().rM(1) != null && this.dmE == 1) {
            this.fMV.setCategoryId(i2);
        }
        this.fNa = i2;
        this.fNc = amVar;
        b(i, i2, amVar);
        sw(5);
    }

    @Override // com.baidu.tieba.frs.af
    public void a(ai aiVar) {
        this.fNg = aiVar;
        this.fNf.a(this.fNp);
    }

    private void sw(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.fNc != null) {
                    this.fNc.pn++;
                    break;
                }
                break;
            case 2:
                if (this.fNc != null) {
                    am amVar = this.fNc;
                    amVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.fNc != null) {
                    this.fNc.pn = -1;
                    break;
                }
                break;
        }
        if (this.dmE == 1) {
            if (this.fNb == this.fNa) {
                ArrayList<m> arrayList = new ArrayList<>();
                if (this.fMU != null) {
                    arrayList.addAll(this.fMU);
                }
                this.ftR.setThreadList(arrayList);
                if (this.fNg != null) {
                    this.fNg.a(this.dmE, this.fNa, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.fNb = this.fNa;
            return;
        }
        af rN = this.fNf.rN(this.dmE);
        if (rN != null) {
            this.fNd = true;
            rN.a(this.dmE, this.fNa, this.fNc);
            return;
        }
        if (this.ftR != null && this.ftR.getThreadList() != null) {
            this.ftR.getThreadList().clear();
        }
        this.fNg.a(this.dmE, this.fNa, null, null);
    }

    public boolean hasMore() {
        if ((this.fNc instanceof ap) && ((ap) this.fNc).errCode == 0) {
            return ((ap) this.fNc).hasMore;
        }
        return true;
    }

    private int bD(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, am amVar) {
        this.fNe.put(bD(i, i2), amVar);
    }

    public am bE(int i, int i2) {
        return this.fNe.get(bD(i, i2));
    }

    @Override // com.baidu.tieba.frs.af
    public void init() {
        this.fNf.init();
    }

    @Override // com.baidu.tieba.frs.af
    public void aLz() {
        this.fNf.destory();
        this.fNf.clear();
    }

    public int bru() {
        return this.dmE;
    }

    public boolean brv() {
        return 1 == this.dmE;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(ak akVar) {
        if (akVar != null && !StringUtils.isNull(akVar.getId()) && !v.aa(this.fMU)) {
            if (this.dmE == 1) {
                this.ftR.addMyNewThread(akVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<m> it = this.fMU.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if ((next instanceof bg) && akVar.getId().equals(((bg) next).threadData.getId())) {
                    return;
                }
            }
            this.fMU.add(topThreadSize, akVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.fMU == null || this.fMU.size() <= 0) {
            return 0;
        }
        Iterator<m> it = this.fMU.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                m next = it.next();
                if (!(next instanceof bg)) {
                    i = i2;
                } else if (((bg) next).threadData.aet() != 0) {
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

    public boolean brw() {
        return this.fNd;
    }

    public void brx() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.fNb == 0) {
            mVar.rF(this.fNk);
        }
        if (this.ftR.getThreadList() != null) {
            this.ftR.getThreadList().clear();
            this.ftR.getThreadList().add(mVar);
        }
        if (this.fMU != null) {
            this.fMU.clear();
            this.fMU.add(mVar);
        }
    }

    public ArrayList<m> bry() {
        return this.fMU;
    }

    public void sA(int i) {
        AccountData currentAccountObj;
        this.fNk = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
        }
        com.baidu.tieba.frs.f.g.ax("1~" + str + this.fug, this.fNk);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cqJ();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cqK();
        }
    }

    public void sB(int i) {
        this.fNl = i;
    }

    public void kJ(boolean z) {
        this.fNm = z;
    }

    public int brz() {
        return this.fNk;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.sR(this.fNk);
    }

    public boolean brA() {
        return this.fMX;
    }

    public boolean brB() {
        return this.fNk == 5;
    }

    public boolean brC() {
        return this.fMV != null && this.fMV.getLoadType() == 1;
    }

    public boolean brD() {
        return this.fNk == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.fMP.blP() != null) {
            return this.fMP.blP().a(this.fNk, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bh.bJO.get() && r.chV().chP() != null) {
            int ax = r.chV().chP().ax(str, false);
            int ay = r.chV().chP().ay(str, false);
            if (frsRequestData.getLoadType() == 1) {
                ax++;
            } else if (frsRequestData.getLoadType() == 2) {
                ay++;
            }
            frsRequestData.setRefreshCount(ax);
            frsRequestData.setLoadCount(ay);
        }
    }

    public void brE() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.ftR != null && this.ftR.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.ftR.getForum().getId(), 0L));
        }
        this.fMP.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void xx(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.coH().eh(FrsModelController.this.fNn, str);
                return null;
            }
        }, null);
    }

    public void xy(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.coH().ei(FrsModelController.this.fNn, str);
                return null;
            }
        }, null);
    }

    public void xz(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.coH().ej(FrsModelController.this.fNn, str);
                return null;
            }
        }, null);
    }
}
