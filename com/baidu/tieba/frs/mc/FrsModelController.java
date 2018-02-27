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
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.k.p;
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
import com.baidu.tieba.frs.m;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.recapp.r;
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
    private long bAx;
    private int bZI;
    private l dDP;
    private String dEe;
    private FrsNetModel<com.baidu.tieba.frs.i> dRR;
    private d.a dRT;
    private String dRU;
    private final com.baidu.tieba.frs.i dSJ;
    private ArrayList<com.baidu.adp.widget.ListView.i> dSM;
    private FrsRequestData dSN;
    private final n dSO;
    private boolean dSP;
    private int dSQ;
    private int dSR;
    private aq dSS;
    private boolean dST;
    private SparseArray<aq> dSU;
    private ac dSV;
    private an dSW;
    private ArrayList<com.baidu.adp.widget.ListView.i> dSX;
    private boolean dSY;
    private String dSZ;
    private int dTa;
    private int dTb;
    private boolean dTc;
    private String dTd;
    private final SparseArray<Boolean> dTe;
    private an dTf;
    private long dpW;
    private long dpX;
    private long dpY;
    private long dpZ;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean nG(int i) {
        return this.dTe.get(i, false).booleanValue();
    }

    public void F(int i, boolean z) {
        this.dTe.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.i iVar, n nVar) {
        super(iVar.getPageContext());
        this.dEe = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.dRU = null;
        this.bZI = 1;
        this.dSQ = 0;
        this.dSR = 0;
        this.dST = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.dSU = new SparseArray<>();
        this.bAx = 0L;
        this.dSY = false;
        this.dTa = -1;
        this.dTb = -1;
        this.dTd = null;
        this.dTe = new SparseArray<>();
        this.dTf = new an() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.an
            public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
                FrsModelController.this.dST = false;
                if (i == FrsModelController.this.bZI && FrsModelController.this.dSW != null) {
                    FrsModelController.this.dSS = atVar;
                    FrsModelController.this.b(i, i2, atVar);
                    ArrayList<com.baidu.adp.widget.ListView.i> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.dDP.au(arrayList2);
                    if ((i == 1 || i == 5) && !FrsModelController.this.azA()) {
                        FrsModelController.this.dDP.bvN();
                        FrsModelController.this.dDP.bvO();
                    }
                    FrsModelController.this.dSW.a(i, i2, atVar, arrayList);
                }
            }
        };
        this.dpW = 0L;
        this.dpX = 0L;
        this.dpY = 0L;
        this.dpZ = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.dSJ = iVar;
        this.dSO = nVar;
        y(this.dSJ);
    }

    private void y(com.baidu.tieba.frs.i iVar) {
        this.dSV = new ac();
        this.dSV.bIv = iVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.dSV));
        this.dSV.a(this.dTf);
    }

    public void onActivityDestroy() {
        this.dRR.cancelLoadData();
    }

    public void l(Bundle bundle) {
        if (bundle != null) {
            this.dEe = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dSZ = bundle.getString("yuelaou_locate");
            this.dSP = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.dEe)) {
            this.dEe = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.dSZ)) {
            this.dSZ = "";
        }
        this.mSource = this.mFrom;
        this.dSN = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            nH(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            nH(6);
        } else {
            com.baidu.tieba.frs.smartsort.f mo = com.baidu.tieba.frs.smartsort.d.azL().mo(this.dEe);
            if (mo != null) {
                nH(mo.dTR);
            } else {
                nH(-1);
            }
        }
        this.dSN.setSortType(YL());
        if (this.dTa == 5) {
            this.dSN.setIsGood(1);
        } else {
            this.dSN.setIsGood(0);
        }
        this.dDP = new l();
        this.dRR = new FrsNetModel<>(this.dSJ.getPageContext(), this.dSN);
        this.dRR.a(this);
        this.dRR.setUniqueId(this.dSJ.getUniqueId());
        if (this.dEe != null && this.dEe.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dEe);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean amM() {
        if (this.bZI != 1) {
            nC(1);
            return true;
        } else if (this.dRR.Ek()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dSN), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(YL());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void G(int i, boolean z) {
        if (this.dDP != null && this.dDP.bvi() != null) {
            this.dDP.bvi().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dSN), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bZI = c(this.bZI, frsRequestData);
        if (this.bZI == 1) {
            if (!this.dRR.Ek()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.dSS == null) {
            this.dSS = new aq();
            this.dSS.pn = 1;
            this.dSS.forumName = this.dEe;
            if (this.dDP != null && this.dDP.bar() != null) {
                this.dSS.forumId = this.dDP.bar().getId();
            }
        }
        nC(i);
    }

    public void nD(int i) {
        if (this.bZI != 1) {
            nC(4);
        } else if (!this.dRR.Ek()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dSN), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(YL());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.dSO.mQ(i);
        this.dRR.a(frsRequestData);
        this.mType = i;
        frsRequestData.sz(this.dSJ.avm() ? "1" : "2");
        if (this.dTc) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.f.nM(this.dTb)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.dTc = false;
        frsRequestData.setKw(this.dEe);
        if (com.baidu.tbadk.core.i.xo().xu()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ao = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst());
        int aq = com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst());
        float ar = com.baidu.adp.lib.util.l.ar(TbadkCoreApplication.getInst());
        int i2 = ao.Dd().Df() ? 2 : 1;
        frsRequestData.setScrW(ao);
        frsRequestData.setScrH(aq);
        frsRequestData.setScrDip(ar);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.dRU);
        frsRequestData.setYuelaouLocate(this.dSZ);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(t.Pm(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.i.dEm != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.i.dEm);
        }
        if (com.baidu.tieba.frs.i.dEn != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.i.dEn);
        }
        if (com.baidu.tieba.frs.i.dEo != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.i.dEo);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.f.a(this.dTa, frsRequestData);
        b(i, frsRequestData);
        a(this.dEe, frsRequestData);
        if (!nG(this.dTa)) {
            String d = com.baidu.tieba.tbadkCore.c.buH().d(this.dEe, frsRequestData.YL(), frsRequestData.getIsGood(), this.dSN.getCategoryId());
            this.dTd = d;
            new a(this, true, d).execute(new Object[0]);
        }
        ayV();
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
        if (iVar == null || iVar.bar() == null || (am.isEmpty(iVar.bar().getName()) && 340001 != iVar.gYX)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bZI = iVar.bvm();
        }
        this.dDP.e(iVar);
        d(this.dDP);
        this.dSM = new ArrayList<>();
        if (frsRequestData != null) {
            this.dSN = frsRequestData;
            this.mPn = this.dSN.getPn();
            this.dEe = this.dSN.getKw();
            this.dSJ.setForumName(this.dEe);
            this.dSJ.setFrom(this.mFrom);
            this.dSJ.setPn(this.mPn);
            this.dSJ.setFlag(this.mFlag);
        }
        if (this.dDP.getThreadList() != null) {
            this.dSM.addAll(this.dDP.getThreadList());
        }
        if (this.bZI != 1 && this.isNetFirstLoad) {
            this.dSO.a(7, false, this.dRT);
        } else {
            this.dSO.a(this.mType, false, this.dRT);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.dSN)) {
            azB();
        }
        this.isNetFirstLoad = false;
        if (iVar.bar() == null || TextUtils.isEmpty(iVar.bar().getName()) || frsRequestData == null || r.boe().bnY() == null) {
            return true;
        }
        r.boe().bnY().f(iVar.bar().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.gXt = com.baidu.adp.lib.util.j.oJ() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gXu = mvcSocketResponsedMessage.getDownSize();
        this.dRT = aVar;
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
        this.dSJ.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dSY) {
            this.dSY = true;
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
        aVar.gXt = com.baidu.adp.lib.util.j.oJ() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gXu = mvcHttpResponsedMessage.getDownSize();
        this.dRT = aVar;
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
        this.dSJ.a(errorData);
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
        if (!this.dSY) {
            this.dSY = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void avg() {
        if (this.dDP != null && this.dDP.bar() != null && this.dDP.bar().getBannerListData() != null) {
            String lastIds = this.dDP.bar().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dRU = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (p.Ov().Ow()) {
            this.bAx = System.currentTimeMillis() - this.dSJ.beginTime;
            com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l(i, z, responsedMessage, this.dSJ.bAo, this.dSJ.createTime, this.dSJ.bAw, false, this.bAx);
            this.dSJ.createTime = 0L;
            this.dSJ.bAo = 0L;
            if (lVar != null) {
                lVar.Oq();
            }
        }
    }

    public FrsRequestData azl() {
        return this.dSN;
    }

    public String azm() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.dEe;
    }

    public int getPn() {
        return this.mPn;
    }

    public l ayU() {
        return this.dDP;
    }

    public d.a azn() {
        return this.dRT;
    }

    private void ayV() {
        this.dpW = System.currentTimeMillis();
        this.dRR.Nv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.dDP.e(iVar);
        d(this.dDP);
        this.dSM = new ArrayList<>();
        if (this.dDP.getThreadList() != null) {
            this.dSM.addAll(this.dDP.getThreadList());
        }
        this.dSO.b(iVar);
    }

    private void d(l lVar) {
        if (com.baidu.tieba.frs.g.f.h(lVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.g.f.i(lVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.i, Void> {
        private String dTj;
        private FrsModelController dTk;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.dTj = null;
            this.dTj = str;
            this.dTk = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.buH().sx(this.dTj)) {
                if (!com.baidu.tieba.tbadkCore.c.buH().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.dTj)) {
                    com.baidu.tieba.tbadkCore.c.buH().getResponseData().bar().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.i responseData = com.baidu.tieba.tbadkCore.c.buH().getResponseData();
                if (responseData.bvo() != null && !StringUtils.isNull(responseData.bvo().xT(), true) && !responseData.bvo().xT().equals("0") && responseData.bvo().xU() == 3 && (h = com.baidu.adp.lib.g.b.h(responseData.bvo().xT(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(h))) != null) {
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
            if (this.dTk != null && iVarArr != null) {
                this.dTk.d(iVarArr.length > 0 ? iVarArr[0] : null);
                this.dTk.F(this.dTk.dTa, true);
            }
        }
    }

    public long aqN() {
        return this.dpZ;
    }

    public long aqO() {
        return this.dpX;
    }

    public long aqP() {
        return this.dpY;
    }

    public long aqQ() {
        return this.dpW;
    }

    public boolean Ek() {
        return this.dRR.Ek();
    }

    public int azo() {
        return this.dSR;
    }

    private void azp() {
        if (this.dSX == null) {
            this.dSX = new ArrayList<>();
        }
        if (this.dSX.size() == 0) {
            this.dSX.add(new x());
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, aq aqVar) {
        this.bZI = c(i, null);
        if (aqVar == null && (aqVar = bH(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.pa() && this.dSW != null) {
                at atVar = new at();
                atVar.hasMore = false;
                atVar.pn = 1;
                atVar.forumName = this.dEe;
                atVar.dHx = false;
                if (this.dDP != null && this.dDP.bar() != null) {
                    atVar.forumId = this.dDP.bar().getId();
                }
                azp();
                this.dDP.au(this.dSX);
                this.dSW.a(i, i2, atVar, this.dSX);
            }
            aqVar = new aq();
            aqVar.pn = -1;
        }
        if (this.dDP != null && this.dDP.bar() != null) {
            aqVar.forumId = this.dDP.bar().getId();
        }
        aqVar.forumName = this.dEe;
        if (aa.awk().mX(1) != null && this.bZI == 1) {
            this.dSN.setCategoryId(i2);
        }
        this.dSQ = i2;
        this.dSS = aqVar;
        b(i, i2, aqVar);
        nC(5);
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(an anVar) {
        this.dSW = anVar;
        this.dSV.a(this.dTf);
    }

    private void nC(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.dSS != null) {
                    this.dSS.pn++;
                    break;
                }
                break;
            case 2:
                if (this.dSS != null) {
                    aq aqVar = this.dSS;
                    aqVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.dSS != null) {
                    this.dSS.pn = -1;
                    break;
                }
                break;
        }
        if (this.bZI == 1) {
            if (this.dSR == this.dSQ) {
                ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
                if (this.dSM != null) {
                    arrayList.addAll(this.dSM);
                }
                this.dDP.au(arrayList);
                if (this.dSW != null) {
                    this.dSW.a(this.bZI, this.dSQ, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.dSR = this.dSQ;
            return;
        }
        ak mY = this.dSV.mY(this.bZI);
        if (mY != null) {
            this.dST = true;
            mY.a(this.bZI, this.dSQ, this.dSS);
            return;
        }
        if (this.dDP != null && this.dDP.getThreadList() != null) {
            this.dDP.getThreadList().clear();
        }
        this.dSW.a(this.bZI, this.dSQ, null, null);
    }

    public boolean hasMore() {
        if ((this.dSS instanceof at) && ((at) this.dSS).errCode == 0) {
            return ((at) this.dSS).hasMore;
        }
        return true;
    }

    private int bG(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, aq aqVar) {
        this.dSU.put(bG(i, i2), aqVar);
    }

    public aq bH(int i, int i2) {
        return this.dSU.get(bG(i, i2));
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        this.dSV.init();
    }

    @Override // com.baidu.tieba.frs.ak
    public void YZ() {
        this.dSV.destory();
        this.dSV.clear();
    }

    public int azq() {
        return this.bZI;
    }

    public boolean azr() {
        return 1 == this.bZI;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.dSM != null) {
            if (this.bZI == 1) {
                this.dDP.a(aiVar);
            }
            int azs = azs();
            if (this.dSM != null && this.dSM.size() > 0) {
                int size = this.dSM.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.i iVar = this.dSM.get(i);
                    if ((iVar instanceof bd) && aiVar.getId().equals(((bd) iVar).getId())) {
                        return;
                    }
                }
            }
            if (aiVar.getThreadType() == 33) {
                ar arVar = new ar();
                arVar.a(aiVar, -1);
                arVar.setPost_num(1);
                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.dSM.add(azs, arVar);
                    return;
                }
                return;
            }
            this.dSM.add(azs, aiVar);
        }
    }

    public int azs() {
        int i = 0;
        if (this.dSM == null || this.dSM.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.i> it = this.dSM.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.i next = it.next();
                if (!(next instanceof bd)) {
                    i = i2;
                } else if (((bd) next).zi() != 0) {
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

    public boolean azt() {
        return this.dST;
    }

    public void azu() {
        m mVar = new m();
        if (this.dSR == 0) {
            mVar.mW(this.dTa);
        }
        if (this.dDP.getThreadList() != null) {
            this.dDP.getThreadList().clear();
            this.dDP.getThreadList().add(mVar);
        }
        if (this.dSM != null) {
            this.dSM.clear();
            this.dSM.add(mVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> azv() {
        return this.dSM;
    }

    public void nH(int i) {
        this.dTa = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.f.bxQ();
        } else {
            com.baidu.tieba.tbadkCore.util.f.bxR();
        }
    }

    public void nI(int i) {
        this.dTb = i;
    }

    public void go(boolean z) {
        this.dTc = z;
    }

    public int azw() {
        return this.dTa;
    }

    public int YL() {
        return com.baidu.tieba.frs.f.f.nM(this.dTa);
    }

    public boolean azx() {
        return this.dSP;
    }

    public boolean azy() {
        return this.dTa == 5;
    }

    public boolean azz() {
        return this.dSN != null && this.dSN.getLoadType() == 1;
    }

    public boolean azA() {
        return this.dTa == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.dSJ.auJ() != null) {
            return this.dSJ.auJ().a(this.dTa, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bd.aOt.get() && r.boe().bnY() != null) {
            int U = r.boe().bnY().U(str, false);
            int V = r.boe().bnY().V(str, false);
            if (frsRequestData.getLoadType() == 1) {
                U++;
            } else if (frsRequestData.getLoadType() == 2) {
                V++;
            }
            frsRequestData.setRefreshCount(U);
            frsRequestData.setLoadCount(V);
        }
    }

    public void azB() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.dDP != null && this.dDP.bar() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.dDP.bar().getId(), 0L));
        }
        this.dSJ.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void mg(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.buH().bZ(FrsModelController.this.dTd, str);
                return null;
            }
        }, null);
    }

    public void mh(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.buH().ca(FrsModelController.this.dTd, str);
                return null;
            }
        }, null);
    }

    public void mi(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.buH().cb(FrsModelController.this.dTd, str);
                return null;
            }
        }, null);
    }
}
