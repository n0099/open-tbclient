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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.k.m;
import com.baidu.tbadk.k.r;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.i>, ak {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private int bXw;
    private long byo;
    private final com.baidu.tieba.frs.i dKN;
    private ArrayList<com.baidu.adp.widget.ListView.i> dKQ;
    private FrsRequestData dKR;
    private final n dKS;
    private boolean dKT;
    private int dKU;
    private int dKV;
    private aq dKW;
    private boolean dKX;
    private SparseArray<aq> dKY;
    private ac dKZ;
    private FrsNetModel<com.baidu.tieba.frs.i> dKd;
    private d.a dKf;
    private String dKg;
    private an dLa;
    private ArrayList<com.baidu.adp.widget.ListView.i> dLb;
    private boolean dLc;
    private String dLd;
    private int dLe;
    private int dLf;
    private boolean dLg;
    private String dLh;
    private final SparseArray<Boolean> dLi;
    private an dLj;
    private long dis;
    private long dit;
    private long diu;
    private long div;
    private String dwA;
    private l dwm;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean nD(int i) {
        return this.dLi.get(i, false).booleanValue();
    }

    public void A(int i, boolean z) {
        this.dLi.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.i iVar, n nVar) {
        super(iVar.getPageContext());
        this.dwA = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.dKg = null;
        this.bXw = 1;
        this.dKU = 0;
        this.dKV = 0;
        this.dKX = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.dKY = new SparseArray<>();
        this.byo = 0L;
        this.dLc = false;
        this.dLe = -1;
        this.dLf = -1;
        this.dLh = null;
        this.dLi = new SparseArray<>();
        this.dLj = new an() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.an
            public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
                FrsModelController.this.dKX = false;
                if (i == FrsModelController.this.bXw && FrsModelController.this.dLa != null) {
                    FrsModelController.this.dKW = atVar;
                    FrsModelController.this.b(i, i2, atVar);
                    ArrayList<com.baidu.adp.widget.ListView.i> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.dwm.az(arrayList2);
                    if ((i == 1 || i == 5) && !FrsModelController.this.axr()) {
                        FrsModelController.this.dwm.bBb();
                        FrsModelController.this.dwm.bBc();
                    }
                    FrsModelController.this.dLa.a(i, i2, atVar, arrayList);
                }
            }
        };
        this.dis = 0L;
        this.dit = 0L;
        this.diu = 0L;
        this.div = 0L;
        if (iVar == null || nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.dKN = iVar;
        this.dKS = nVar;
        y(this.dKN);
    }

    private void y(com.baidu.tieba.frs.i iVar) {
        this.dKZ = new ac();
        this.dKZ.bGo = iVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.dKZ));
        this.dKZ.a(this.dLj);
    }

    public void onActivityDestroy() {
        this.dKd.cancelLoadData();
    }

    public void k(Bundle bundle) {
        if (bundle != null) {
            this.dwA = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dLd = bundle.getString("yuelaou_locate");
            this.dKT = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.dwA)) {
            this.dwA = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.dLd)) {
            this.dLd = "";
        }
        this.mSource = this.mFrom;
        this.dKR = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            nE(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            nE(6);
        } else {
            com.baidu.tieba.frs.smartsort.f lN = com.baidu.tieba.frs.smartsort.d.axC().lN(this.dwA);
            if (lN != null) {
                nE(lN.dLU);
            } else {
                nE(-1);
            }
        }
        this.dKR.setSortType(XR());
        if (this.dLe == 5) {
            this.dKR.setIsGood(1);
        } else {
            this.dKR.setIsGood(0);
        }
        this.dwm = new l();
        this.dKd = new FrsNetModel<>(this.dKN.getPageContext(), this.dKR);
        this.dKd.a(this);
        this.dKd.setUniqueId(this.dKN.getUniqueId());
        if (this.dwA != null && this.dwA.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dwA);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean akW() {
        if (this.bXw != 1) {
            nA(1);
            return true;
        } else if (this.dKd.DY()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dKR), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(XR());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void B(int i, boolean z) {
        if (this.dwm != null && this.dwm.bAw() != null) {
            this.dwm.bAw().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dKR), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bXw = c(this.bXw, frsRequestData);
        if (this.bXw == 1) {
            if (!this.dKd.DY()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.dKW == null) {
            this.dKW = new aq();
            this.dKW.pn = 1;
            this.dKW.forumName = this.dwA;
            if (this.dwm != null && this.dwm.aYy() != null) {
                this.dKW.forumId = this.dwm.aYy().getId();
            }
        }
        nA(i);
    }

    public void nB(int i) {
        if (this.bXw != 1) {
            nA(4);
        } else if (!this.dKd.DY()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dKR), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(XR());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.dKS.mQ(i);
        this.dKd.a(frsRequestData);
        this.mType = i;
        frsRequestData.sQ(this.dKN.atq() ? "1" : "2");
        if (this.dLg) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.e.f.nJ(this.dLf)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.dLg = false;
        frsRequestData.setKw(this.dwA);
        if (com.baidu.tbadk.core.i.wB().wH()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ao = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst());
        int aq = com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst());
        float ar = com.baidu.adp.lib.util.l.ar(TbadkCoreApplication.getInst());
        int i2 = com.baidu.tbadk.core.util.an.CS().CU() ? 2 : 1;
        frsRequestData.setScrW(ao);
        frsRequestData.setScrH(aq);
        frsRequestData.setScrDip(ar);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.dKg);
        frsRequestData.setYuelaouLocate(this.dLd);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(t.OS(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.i.dwI != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.i.dwI);
        }
        if (com.baidu.tieba.frs.i.dwJ != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.i.dwJ);
        }
        if (com.baidu.tieba.frs.i.dwK != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.i.dwK);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.e.f.a(this.dLe, frsRequestData);
        b(i, frsRequestData);
        a(this.dwA, frsRequestData);
        if (!nD(this.dLe)) {
            String d = com.baidu.tieba.tbadkCore.c.bzX().d(this.dwA, frsRequestData.XR(), frsRequestData.getIsGood(), this.dKR.getCategoryId());
            this.dLh = d;
            new a(this, true, d).execute(new Object[0]);
        }
        awO();
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

    protected boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.i iVar) {
        if (iVar == null || iVar.aYy() == null || (am.isEmpty(iVar.aYy().getName()) && 340001 != iVar.hgZ)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bXw = iVar.bAA();
        }
        this.dwm.e(iVar);
        d(this.dwm);
        this.dKQ = new ArrayList<>();
        if (frsRequestData != null) {
            this.dKR = frsRequestData;
            this.mPn = this.dKR.getPn();
            this.dwA = this.dKR.getKw();
            this.dKN.setForumName(this.dwA);
            this.dKN.setFrom(this.mFrom);
            this.dKN.setPn(this.mPn);
            this.dKN.setFlag(this.mFlag);
        }
        if (this.dwm.getThreadList() != null) {
            this.dKQ.addAll(this.dwm.getThreadList());
        }
        if (this.bXw != 1 && this.isNetFirstLoad) {
            this.dKS.a(7, false, this.dKf);
        } else {
            this.dKS.a(this.mType, false, this.dKf);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.dKR)) {
            axs();
        }
        this.isNetFirstLoad = false;
        if (iVar.aYy() == null || TextUtils.isEmpty(iVar.aYy().getName()) || frsRequestData == null || q.bty().bts() == null) {
            return true;
        }
        q.bty().bts().f(iVar.aYy().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.hfv = com.baidu.adp.lib.util.j.oI() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.hfw = mvcSocketResponsedMessage.getDownSize();
        this.dKf = aVar;
        if (mvcSocketResponsedMessage == null || (mvcSocketResponsedMessage.hasError() && 340001 != mvcSocketResponsedMessage.getError())) {
            iVar = null;
        } else {
            iVar = mvcSocketResponsedMessage.getData();
            r3 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && iVar != null && a(r3, iVar)) {
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
        this.dKN.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dLc) {
            this.dLc = true;
            a(1000, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
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
            objArr[2] = "seq_id";
            objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
            com.baidu.tbadk.core.d.a.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.i> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.hfv = com.baidu.adp.lib.util.j.oI() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.hfw = mvcHttpResponsedMessage.getDownSize();
        this.dKf = aVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            iVar = null;
        } else {
            iVar = mvcHttpResponsedMessage.getData();
            r3 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && iVar != null && a(r3, iVar)) {
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
        this.dKN.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        super.registerListener(i, aVar);
    }

    private void b(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.i> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
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
        if (!this.dLc) {
            this.dLc = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void atj() {
        if (this.dwm != null && this.dwm.aYy() != null && this.dwm.aYy().getBannerListData() != null) {
            String lastIds = this.dwm.aYy().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dKg = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (r.Oa().Ob()) {
            this.byo = System.currentTimeMillis() - this.dKN.beginTime;
            m mVar = new m(i, z, responsedMessage, this.dKN.byf, this.dKN.createTime, this.dKN.byn, false, this.byo);
            this.dKN.createTime = 0L;
            this.dKN.byf = 0L;
            if (mVar != null) {
                mVar.NV();
            }
        }
    }

    public FrsRequestData axc() {
        return this.dKR;
    }

    public String axd() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.dwA;
    }

    public int getPn() {
        return this.mPn;
    }

    public l awN() {
        return this.dwm;
    }

    public d.a axe() {
        return this.dKf;
    }

    private void awO() {
        this.dis = System.currentTimeMillis();
        this.dKd.Na();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.dwm.e(iVar);
        d(this.dwm);
        this.dKQ = new ArrayList<>();
        if (this.dwm.getThreadList() != null) {
            this.dKQ.addAll(this.dwm.getThreadList());
        }
        this.dKS.b(iVar);
    }

    private void d(l lVar) {
        if (com.baidu.tieba.frs.f.f.h(lVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.f.f.i(lVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.i, Void> {
        private String dLn;
        private FrsModelController dLo;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.dLn = null;
            this.dLn = str;
            this.dLo = frsModelController;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            int h;
            CustomResponsedMessage runTask;
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bzX().sO(this.dLn)) {
                if (!com.baidu.tieba.tbadkCore.c.bzX().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.dLn)) {
                    com.baidu.tieba.tbadkCore.c.bzX().getResponseData().aYy().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.i responseData = com.baidu.tieba.tbadkCore.c.bzX().getResponseData();
                if (responseData.bAC() != null && !StringUtils.isNull(responseData.bAC().xn(), true) && !responseData.bAC().xn().equals("0") && responseData.bAC().xo() == 3 && (h = com.baidu.adp.lib.g.b.h(responseData.bAC().xn(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(h))) != null) {
                    responseData.j(Integer.valueOf(((Integer) runTask.getData()).intValue()));
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
        public void onProgressUpdate(com.baidu.tieba.tbadkCore.i... iVarArr) {
            super.onProgressUpdate(iVarArr);
            if (this.dLo != null && iVarArr != null) {
                this.dLo.d(iVarArr.length > 0 ? iVarArr[0] : null);
                this.dLo.A(this.dLo.dLe, true);
            }
        }
    }

    public long aoQ() {
        return this.div;
    }

    public long aoR() {
        return this.dit;
    }

    public long aoS() {
        return this.diu;
    }

    public long aoT() {
        return this.dis;
    }

    public boolean DY() {
        return this.dKd.DY();
    }

    public int axf() {
        return this.dKV;
    }

    private void axg() {
        if (this.dLb == null) {
            this.dLb = new ArrayList<>();
        }
        if (this.dLb.size() == 0) {
            this.dLb.add(new x());
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, aq aqVar) {
        this.bXw = c(i, null);
        if (aqVar == null && (aqVar = bJ(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.oZ() && this.dLa != null) {
                at atVar = new at();
                atVar.hasMore = false;
                atVar.pn = 1;
                atVar.forumName = this.dwA;
                atVar.dzJ = false;
                if (this.dwm != null && this.dwm.aYy() != null) {
                    atVar.forumId = this.dwm.aYy().getId();
                }
                axg();
                this.dwm.az(this.dLb);
                this.dLa.a(i, i2, atVar, this.dLb);
            }
            aqVar = new aq();
            aqVar.pn = -1;
        }
        if (this.dwm != null && this.dwm.aYy() != null) {
            aqVar.forumId = this.dwm.aYy().getId();
        }
        aqVar.forumName = this.dwA;
        if (aa.auf().mW(1) != null && this.bXw == 1) {
            this.dKR.setCategoryId(i2);
        }
        this.dKU = i2;
        this.dKW = aqVar;
        b(i, i2, aqVar);
        nA(5);
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(an anVar) {
        this.dLa = anVar;
        this.dKZ.a(this.dLj);
    }

    private void nA(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.dKW != null) {
                    this.dKW.pn++;
                    break;
                }
                break;
            case 2:
                if (this.dKW != null) {
                    aq aqVar = this.dKW;
                    aqVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.dKW != null) {
                    this.dKW.pn = -1;
                    break;
                }
                break;
        }
        if (this.bXw == 1) {
            if (this.dKV == this.dKU) {
                ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
                if (this.dKQ != null) {
                    arrayList.addAll(this.dKQ);
                }
                this.dwm.az(arrayList);
                if (this.dLa != null) {
                    this.dLa.a(this.bXw, this.dKU, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.dKV = this.dKU;
            return;
        }
        ak mX = this.dKZ.mX(this.bXw);
        if (mX != null) {
            this.dKX = true;
            mX.a(this.bXw, this.dKU, this.dKW);
            return;
        }
        if (this.dwm != null && this.dwm.getThreadList() != null) {
            this.dwm.getThreadList().clear();
        }
        this.dLa.a(this.bXw, this.dKU, null, null);
    }

    public boolean hasMore() {
        if ((this.dKW instanceof at) && ((at) this.dKW).errCode == 0) {
            return ((at) this.dKW).hasMore;
        }
        return true;
    }

    private int bI(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, aq aqVar) {
        this.dKY.put(bI(i, i2), aqVar);
    }

    public aq bJ(int i, int i2) {
        return this.dKY.get(bI(i, i2));
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        this.dKZ.init();
    }

    @Override // com.baidu.tieba.frs.ak
    public void Yi() {
        this.dKZ.destory();
        this.dKZ.clear();
    }

    public int axh() {
        return this.bXw;
    }

    public boolean axi() {
        return 1 == this.bXw;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(aj ajVar) {
        if (ajVar != null && !StringUtils.isNull(ajVar.getId()) && this.dKQ != null) {
            if (this.bXw == 1) {
                this.dwm.a(ajVar);
            }
            int axj = axj();
            if (this.dKQ != null && this.dKQ.size() > 0) {
                int size = this.dKQ.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.i iVar = this.dKQ.get(i);
                    if ((iVar instanceof be) && ajVar.getId().equals(((be) iVar).getId())) {
                        return;
                    }
                }
            }
            if (ajVar.getThreadType() == 33) {
                as asVar = new as();
                asVar.a(ajVar, -1);
                asVar.setPost_num(1);
                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.dKQ.add(axj, asVar);
                    return;
                }
                return;
            }
            this.dKQ.add(axj, ajVar);
        }
    }

    public int axj() {
        int i = 0;
        if (this.dKQ == null || this.dKQ.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.i> it = this.dKQ.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.i next = it.next();
                if (!(next instanceof be)) {
                    i = i2;
                } else if (((be) next).yS() != 0) {
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

    public boolean axk() {
        return this.dKX;
    }

    public void axl() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.dKV == 0) {
            mVar.mV(this.dLe);
        }
        if (this.dwm.getThreadList() != null) {
            this.dwm.getThreadList().clear();
            this.dwm.getThreadList().add(mVar);
        }
        if (this.dKQ != null) {
            this.dKQ.clear();
            this.dKQ.add(mVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> axm() {
        return this.dKQ;
    }

    public void nE(int i) {
        this.dLe = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.f.bDj();
        } else {
            com.baidu.tieba.tbadkCore.util.f.bDk();
        }
    }

    public void nF(int i) {
        this.dLf = i;
    }

    public void fY(boolean z) {
        this.dLg = z;
    }

    public int axn() {
        return this.dLe;
    }

    public int XR() {
        return com.baidu.tieba.frs.e.f.nJ(this.dLe);
    }

    public boolean axo() {
        return this.dKT;
    }

    public boolean axp() {
        return this.dLe == 5;
    }

    public boolean axq() {
        return this.dKR != null && this.dKR.getLoadType() == 1;
    }

    public boolean axr() {
        return this.dLe == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.dKN.asM() != null) {
            return this.dKN.asM().a(this.dLe, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (be.aNm.get() && q.bty().bts() != null) {
            int W = q.bty().bts().W(str, false);
            int X = q.bty().bts().X(str, false);
            if (frsRequestData.getLoadType() == 1) {
                W++;
            } else if (frsRequestData.getLoadType() == 2) {
                X++;
            }
            frsRequestData.setRefreshCount(W);
            frsRequestData.setLoadCount(X);
        }
    }

    public void axs() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.dwm != null && this.dwm.aYy() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.dwm.aYy().getId(), 0L));
        }
        this.dKN.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void lF(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bzX().cc(FrsModelController.this.dLh, str);
                return null;
            }
        }, null);
    }

    public void lG(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bzX().cd(FrsModelController.this.dLh, str);
                return null;
            }
        }, null);
    }

    public void lH(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bzX().ce(FrsModelController.this.dLh, str);
                return null;
            }
        }, null);
    }
}
