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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
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
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.m;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.h>, aj {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long aKt;
    private int bkg;
    private k cGG;
    private String cGT;
    private final com.baidu.tieba.frs.f cOm;
    private ArrayList<com.baidu.adp.widget.ListView.f> cRQ;
    private FrsNetModel<com.baidu.tieba.frs.f> cRR;
    private d.a cRT;
    private String cRU;
    private boolean cRX;
    private FrsRequestData cXB;
    private final m cXC;
    private boolean cXD;
    private int cXE;
    private int cXF;
    private ao cXG;
    private boolean cXH;
    private SparseArray<ao> cXI;
    private ab cXJ;
    private al cXK;
    private ArrayList<com.baidu.adp.widget.ListView.f> cXL;
    private String cXM;
    private int cXN;
    private int cXO;
    private boolean cXP;
    private String cXQ;
    private final SparseArray<Boolean> cXR;
    private al cXS;
    private long ctI;
    private long ctJ;
    private long ctK;
    private long ctL;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean kE(int i) {
        return this.cXR.get(i, false).booleanValue();
    }

    public void o(int i, boolean z) {
        this.cXR.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.f fVar, m mVar) {
        super(fVar.getPageContext());
        this.cGT = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.cRU = null;
        this.bkg = 1;
        this.cXE = 0;
        this.cXF = 0;
        this.cXH = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.cXI = new SparseArray<>();
        this.aKt = 0L;
        this.cRX = false;
        this.cXN = -1;
        this.cXO = -1;
        this.cXQ = null;
        this.cXR = new SparseArray<>();
        this.cXS = new al() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.al
            public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
                FrsModelController.this.cXH = false;
                if (i == FrsModelController.this.bkg && FrsModelController.this.cXK != null) {
                    FrsModelController.this.cXG = arVar;
                    FrsModelController.this.b(i, i2, arVar);
                    ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.cGG.az(arrayList2);
                    if ((i == 1 || i == 5) && !FrsModelController.this.apW()) {
                        FrsModelController.this.cGG.bvh();
                        FrsModelController.this.cGG.bvi();
                    }
                    FrsModelController.this.cXK.a(i, i2, arVar, arrayList);
                }
            }
        };
        this.ctI = 0L;
        this.ctJ = 0L;
        this.ctK = 0L;
        this.ctL = 0L;
        if (fVar == null || mVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.cOm = fVar;
        this.cXC = mVar;
        A(this.cOm);
    }

    private void A(com.baidu.tieba.frs.f fVar) {
        this.cXJ = new ab();
        this.cXJ.aSv = fVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.cXJ));
        this.cXJ.a(this.cXS);
    }

    public void onActivityDestroy() {
        this.cRR.cancelLoadData();
    }

    public void h(Bundle bundle) {
        if (bundle != null) {
            this.cGT = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.cXM = bundle.getString("yuelaou_locate");
            this.cXD = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.cGT)) {
            this.cGT = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.cXM)) {
            this.cXM = "";
        }
        this.mSource = this.mFrom;
        this.cXB = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            kG(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            kG(6);
        } else {
            com.baidu.tieba.frs.smartsort.f lE = com.baidu.tieba.frs.smartsort.d.aqi().lE(this.cGT);
            if (lE != null) {
                kG(lE.cYB);
            } else {
                kG(-1);
            }
        }
        this.cXB.setSortType(Qt());
        if (this.cXN == 5) {
            this.cXB.setIsGood(1);
        } else {
            this.cXB.setIsGood(0);
        }
        this.cGG = new k();
        this.cRR = new FrsNetModel<>(this.cOm.getPageContext(), this.cXB);
        this.cRR.a(this);
        this.cRR.setUniqueId(this.cOm.getUniqueId());
        if (this.cGT != null && this.cGT.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.cGT);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean adh() {
        if (this.bkg != 1) {
            kF(1);
            return true;
        } else if (this.cRR.wC()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cXB), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(Qt());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void p(int i, boolean z) {
        if (this.cGG != null && this.cGG.buD() != null) {
            this.cGG.buD().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cXB), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bkg = c(this.bkg, frsRequestData);
        if (this.bkg == 1) {
            if (!this.cRR.wC()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.cXG == null) {
            this.cXG = new ao();
            this.cXG.pn = 1;
            this.cXG.forumName = this.cGT;
            if (this.cGG != null && this.cGG.aRf() != null) {
                this.cXG.forumId = this.cGG.aRf().getId();
            }
        }
        kF(i);
    }

    public void kq(int i) {
        if (this.bkg != 1) {
            kF(4);
        } else if (!this.cRR.wC()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cXB), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(Qt());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.cXC.jN(i);
        this.cRR.a(frsRequestData);
        this.mType = i;
        frsRequestData.sL(this.cOm.aly() ? "1" : "2");
        if (this.cXP) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.f.kU(this.cXO)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.cXP = false;
        frsRequestData.setKw(this.cGT);
        if (com.baidu.tbadk.core.h.pa().pg()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ac = l.ac(TbadkCoreApplication.getInst());
        int ae = l.ae(TbadkCoreApplication.getInst());
        float af = l.af(TbadkCoreApplication.getInst());
        int i2 = an.vv().vx() ? 2 : 1;
        frsRequestData.setScrW(ac);
        frsRequestData.setScrH(ae);
        frsRequestData.setScrDip(af);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.cRU);
        frsRequestData.setYuelaouLocate(this.cXM);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(t.Hs(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.f.cHb != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.f.cHb);
        }
        if (com.baidu.tieba.frs.f.cHc != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.f.cHc);
        }
        if (com.baidu.tieba.frs.f.cHd != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.f.cHd);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.f.a(this.cXN, frsRequestData);
        b(i, frsRequestData);
        a(this.cGT, frsRequestData);
        if (!kE(this.cXN)) {
            String d = com.baidu.tieba.tbadkCore.c.bue().d(this.cGT, frsRequestData.Qt(), frsRequestData.getIsGood(), this.cXB.getCategoryId());
            this.cXQ = d;
            new a(this, true, d).execute(new Object[0]);
        }
        aoA();
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

    protected boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.h hVar) {
        if (hVar == null || hVar.aRf() == null || am.isEmpty(hVar.aRf().getName())) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bkg = hVar.buH();
        }
        this.cGG.e(hVar);
        d(this.cGG);
        this.cRQ = new ArrayList<>();
        if (frsRequestData != null) {
            this.cXB = frsRequestData;
            this.mPn = this.cXB.getPn();
            this.cGT = this.cXB.getKw();
            this.cOm.setForumName(this.cGT);
            this.cOm.setFrom(this.mFrom);
            this.cOm.setPn(this.mPn);
            this.cOm.setFlag(this.mFlag);
        }
        if (this.cGG.getThreadList() != null) {
            this.cRQ.addAll(this.cGG.getThreadList());
        }
        if (this.bkg != 1 && this.isNetFirstLoad) {
            this.cXC.a(7, false, this.cRT);
        } else {
            this.cXC.a(this.mType, false, this.cRT);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.cXB)) {
            apX();
        }
        this.isNetFirstLoad = false;
        if (hVar.aRf() == null || TextUtils.isEmpty(hVar.aRf().getName()) || frsRequestData == null || q.bll().blf() == null) {
            return true;
        }
        q.bll().blf().f(hVar.aRf().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.h, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.h> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.h> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.h hVar;
        d.a aVar = new d.a();
        aVar.gvY = com.baidu.adp.lib.util.j.hh() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gvZ = mvcSocketResponsedMessage.getDownSize();
        this.cRT = aVar;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
            hVar = null;
        } else {
            hVar = mvcSocketResponsedMessage.getData();
            r3 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && hVar != null && a(r3, hVar)) {
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
        this.cOm.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.h, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.h> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.h> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.cRX) {
            this.cRX = true;
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
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.h> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.h> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.h> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.h hVar;
        d.a aVar = new d.a();
        aVar.gvY = com.baidu.adp.lib.util.j.hh() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gvZ = mvcHttpResponsedMessage.getDownSize();
        this.cRT = aVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            hVar = null;
        } else {
            hVar = mvcHttpResponsedMessage.getData();
            r3 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && hVar != null && a(r3, hVar)) {
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
        this.cOm.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        super.registerListener(i, aVar);
    }

    private void b(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.h> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.h> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.h> mvcNetMessage) {
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
        if (!this.cRX) {
            this.cRX = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void alr() {
        if (this.cGG != null && this.cGG.aRf() != null && this.cGG.aRf().getBannerListData() != null) {
            String lastIds = this.cGG.aRf().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.cRU = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (r.GA().GB()) {
            this.aKt = System.currentTimeMillis() - this.cOm.beginTime;
            com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m(i, z, responsedMessage, this.cOm.aKk, this.cOm.createTime, this.cOm.aKs, false, this.aKt);
            this.cOm.createTime = 0L;
            this.cOm.aKk = 0L;
            if (mVar != null) {
                mVar.Gv();
            }
        }
    }

    public FrsRequestData apH() {
        return this.cXB;
    }

    public String apI() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.cGT;
    }

    public int getPn() {
        return this.mPn;
    }

    public k aoz() {
        return this.cGG;
    }

    public d.a apJ() {
        return this.cRT;
    }

    private void aoA() {
        this.ctI = System.currentTimeMillis();
        this.cRR.Fy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.h hVar) {
        this.isCacheFirstLoad = false;
        this.cGG.e(hVar);
        d(this.cGG);
        this.cRQ = new ArrayList<>();
        if (this.cGG.getThreadList() != null) {
            this.cRQ.addAll(this.cGG.getThreadList());
        }
        this.cXC.b(hVar);
    }

    private void d(k kVar) {
        if (com.baidu.tieba.frs.g.f.h(kVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.g.f.i(kVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.h, Void> {
        private String cXW;
        private FrsModelController cXX;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.cXW = null;
            this.cXW = str;
            this.cXX = frsModelController;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            int g;
            CustomResponsedMessage runTask;
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bue().sJ(this.cXW)) {
                if (!com.baidu.tieba.tbadkCore.c.bue().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.cXW)) {
                    com.baidu.tieba.tbadkCore.c.bue().getResponseData().aRf().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.h responseData = com.baidu.tieba.tbadkCore.c.bue().getResponseData();
                if (responseData.buJ() != null && !StringUtils.isNull(responseData.buJ().pM(), true) && !responseData.buJ().pM().equals("0") && responseData.buJ().pN() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.buJ().pM(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
                    responseData.k(Integer.valueOf(((Integer) runTask.getData()).intValue()));
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
        public void onProgressUpdate(com.baidu.tieba.tbadkCore.h... hVarArr) {
            super.onProgressUpdate(hVarArr);
            if (this.cXX != null && hVarArr != null) {
                this.cXX.d(hVarArr.length > 0 ? hVarArr[0] : null);
                this.cXX.o(this.cXX.cXN, true);
            }
        }
    }

    public long ahi() {
        return this.ctL;
    }

    public long ahj() {
        return this.ctJ;
    }

    public long ahk() {
        return this.ctK;
    }

    public long ahl() {
        return this.ctI;
    }

    public boolean wC() {
        return this.cRR.wC();
    }

    public int apK() {
        return this.cXF;
    }

    private void apL() {
        if (this.cXL == null) {
            this.cXL = new ArrayList<>();
        }
        if (this.cXL.size() == 0) {
            this.cXL.add(new w());
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void a(int i, int i2, ao aoVar) {
        this.bkg = c(i, null);
        if (aoVar == null && (aoVar = aK(i, i2)) == null) {
            if (i != 1 && l.hy() && this.cXK != null) {
                ar arVar = new ar();
                arVar.hasMore = false;
                arVar.pn = 1;
                arVar.forumName = this.cGT;
                arVar.cKq = false;
                if (this.cGG != null && this.cGG.aRf() != null) {
                    arVar.forumId = this.cGG.aRf().getId();
                }
                apL();
                this.cGG.az(this.cXL);
                this.cXK.a(i, i2, arVar, this.cXL);
            }
            aoVar = new ao();
            aoVar.pn = -1;
        }
        if (this.cGG != null && this.cGG.aRf() != null) {
            aoVar.forumId = this.cGG.aRf().getId();
        }
        aoVar.forumName = this.cGT;
        if (z.amo().jT(1) != null && this.bkg == 1) {
            this.cXB.setCategoryId(i2);
        }
        this.cXE = i2;
        this.cXG = aoVar;
        b(i, i2, aoVar);
        kF(5);
    }

    @Override // com.baidu.tieba.frs.aj
    public void a(al alVar) {
        this.cXK = alVar;
        this.cXJ.a(this.cXS);
    }

    private void kF(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.cXG != null) {
                    this.cXG.pn++;
                    break;
                }
                break;
            case 2:
                if (this.cXG != null) {
                    ao aoVar = this.cXG;
                    aoVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.cXG != null) {
                    this.cXG.pn = -1;
                    break;
                }
                break;
        }
        if (this.bkg == 1) {
            if (this.cXF == this.cXE) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                if (this.cRQ != null) {
                    arrayList.addAll(this.cRQ);
                }
                this.cGG.az(arrayList);
                if (this.cXK != null) {
                    this.cXK.a(this.bkg, this.cXE, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.cXF = this.cXE;
            return;
        }
        aj jU = this.cXJ.jU(this.bkg);
        if (jU != null) {
            this.cXH = true;
            jU.a(this.bkg, this.cXE, this.cXG);
            return;
        }
        if (this.cGG != null && this.cGG.getThreadList() != null) {
            this.cGG.getThreadList().clear();
        }
        this.cXK.a(this.bkg, this.cXE, null, null);
    }

    public boolean hasMore() {
        if ((this.cXG instanceof ar) && ((ar) this.cXG).errCode == 0) {
            return ((ar) this.cXG).hasMore;
        }
        return true;
    }

    private int aJ(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ao aoVar) {
        this.cXI.put(aJ(i, i2), aoVar);
    }

    public ao aK(int i, int i2) {
        return this.cXI.get(aJ(i, i2));
    }

    @Override // com.baidu.tieba.frs.aj
    public void init() {
        this.cXJ.init();
    }

    @Override // com.baidu.tieba.frs.aj
    public void QJ() {
        this.cXJ.destory();
        this.cXJ.clear();
    }

    public int apM() {
        return this.bkg;
    }

    public boolean apN() {
        return 1 == this.bkg;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.cRQ != null) {
            if (this.bkg == 1) {
                this.cGG.a(aiVar);
            }
            int apO = apO();
            if (this.cRQ != null && this.cRQ.size() > 0) {
                int size = this.cRQ.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.f fVar = this.cRQ.get(i);
                    if ((fVar instanceof bd) && aiVar.getId().equals(((bd) fVar).getId())) {
                        return;
                    }
                }
            }
            if (aiVar.getThreadType() == 33) {
                com.baidu.tbadk.core.data.ar arVar = new com.baidu.tbadk.core.data.ar();
                arVar.a(aiVar, -1);
                arVar.setPost_num(1);
                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.cRQ.add(apO, arVar);
                    return;
                }
                return;
            }
            this.cRQ.add(apO, aiVar);
        }
    }

    public int apO() {
        int i = 0;
        if (this.cRQ == null || this.cRQ.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.cRQ.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (!(next instanceof bd)) {
                    i = i2;
                } else if (((bd) next).rs() != 0) {
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

    public boolean apP() {
        return this.cXH;
    }

    public void apQ() {
        com.baidu.tieba.frs.k kVar = new com.baidu.tieba.frs.k();
        if (this.cXF == 0) {
            kVar.jS(this.cXN);
        }
        if (this.cGG.getThreadList() != null) {
            this.cGG.getThreadList().clear();
            this.cGG.getThreadList().add(kVar);
        }
        if (this.cRQ != null) {
            this.cRQ.clear();
            this.cRQ.add(kVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> apR() {
        return this.cRQ;
    }

    public void kG(int i) {
        this.cXN = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.f.bxm();
        } else {
            com.baidu.tieba.tbadkCore.util.f.bxn();
        }
    }

    public void kH(int i) {
        this.cXO = i;
    }

    public void fx(boolean z) {
        this.cXP = z;
    }

    public int apS() {
        return this.cXN;
    }

    public int Qt() {
        return com.baidu.tieba.frs.f.f.kU(this.cXN);
    }

    public boolean apT() {
        return this.cXD;
    }

    public boolean apU() {
        return this.cXN == 5;
    }

    public boolean apV() {
        return this.cXB != null && this.cXB.getLoadType() == 1;
    }

    public boolean apW() {
        return this.cXN == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.cOm.akV() != null) {
            return this.cOm.akV().a(this.cXN, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bd.YQ.get() && q.bll().blf() != null) {
            int U = q.bll().blf().U(str, false);
            int V = q.bll().blf().V(str, false);
            if (frsRequestData.getLoadType() == 1) {
                U++;
            } else if (frsRequestData.getLoadType() == 2) {
                V++;
            }
            frsRequestData.setRefreshCount(U);
            frsRequestData.setLoadCount(V);
        }
    }

    public void apX() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.cGG != null && this.cGG.aRf() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.cGG.aRf().getId(), 0L));
        }
        this.cOm.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void lx(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bue().cb(FrsModelController.this.cXQ, str);
                return null;
            }
        }, null);
    }

    public void ly(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bue().cc(FrsModelController.this.cXQ, str);
                return null;
            }
        }, null);
    }
}
