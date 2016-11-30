package com.baidu.tieba.frs.e;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.performanceLog.aa;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.bu;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.frs.bz;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.cf;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.frs.cp;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.e<FrsActivity> implements NetModel.b<com.baidu.tieba.tbadkCore.m, com.baidu.tieba.tbadkCore.n>, ce {
    private long aCM;
    private String adE;
    private long bKv;
    private long bKw;
    private long bKx;
    private long bKy;
    private String bRN;
    private com.baidu.tieba.tbadkCore.p bRX;
    private final FrsActivity bZY;
    private ArrayList<v> cdf;
    private o<FrsActivity> cdg;
    private e.a cdi;
    private String cdj;
    private boolean cdl;
    private boolean cdm;
    private com.baidu.tieba.tbadkCore.m cgi;
    private final com.baidu.tieba.tbadkCore.r cgj;
    private boolean cgk;
    private int cgl;
    private int cgm;
    private int cgn;
    private cm cgo;
    private boolean cgp;
    public boolean cgq;
    public boolean cgr;
    private SparseArray<cm> cgs;
    private bz cgt;
    private cf cgu;
    private ArrayList<v> cgv;
    private String cgw;
    private int cgx;
    private final SparseArray<Boolean> cgy;
    private cf cgz;
    private int mFlag;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean iu(int i) {
        return this.cgy.get(i, false).booleanValue();
    }

    public void C(int i, boolean z) {
        this.cgy.put(i, Boolean.valueOf(z));
    }

    public i(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.r rVar) {
        super(frsActivity.getPageContext());
        this.bRN = null;
        this.mType = 3;
        this.mPn = 1;
        this.adE = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.cdj = null;
        this.cgl = 1;
        this.cgm = 0;
        this.cgn = 0;
        this.cgp = false;
        this.cgq = true;
        this.cgr = true;
        this.cgs = new SparseArray<>();
        this.aCM = 0L;
        this.cdl = false;
        this.cdm = false;
        this.cgx = -1;
        this.cgy = new SparseArray<>();
        this.cgz = new j(this);
        this.bKv = 0L;
        this.bKw = 0L;
        this.bKx = 0L;
        this.bKy = 0L;
        if (frsActivity == null || rVar == null) {
            new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.bZY = frsActivity;
        this.cgj = rVar;
        D(frsActivity);
    }

    private void D(FrsActivity frsActivity) {
        this.cgt = new bz();
        this.cgt.bcf = frsActivity.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.cgt));
        this.cgt.a(this.cgz);
    }

    public void onActivityDestroy() {
        this.cdg.cancelLoadData();
    }

    public void d(Bundle bundle) {
        if (bundle != null) {
            this.bRN = bundle.getString("name");
            this.adE = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.cgw = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.cgk = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.bRN)) {
            this.bRN = "";
        }
        if (TextUtils.isEmpty(this.adE)) {
            this.adE = "";
        }
        if (TextUtils.isEmpty(this.cgw)) {
            this.cgw = "";
        }
        this.mSource = this.adE;
        this.cgi = new com.baidu.tieba.tbadkCore.m();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            iw(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            iw(6);
        } else {
            com.baidu.tieba.frs.g.i kh = com.baidu.tieba.frs.g.f.agR().kh(this.bRN);
            if (kh != null) {
                iw(kh.chb);
            } else {
                iw(-1);
            }
        }
        this.cgi.setSortType(agy());
        if (this.cgx == 5) {
            this.cgi.setIsGood(1);
        } else {
            this.cgi.setIsGood(0);
        }
        this.bRX = new com.baidu.tieba.tbadkCore.p();
        this.cdg = new o<>(this.bZY.getPageContext(), this.cgi);
        this.cdg.a(this);
        this.cdg.setUniqueId(getUniqueId());
        if (this.bRN != null && this.bRN.length() > 0) {
            if (this.adE == null || this.adE.length() <= 0) {
                this.adE = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.bRN);
        bundle.putString("from", this.adE);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean PU() {
        if (this.cgl != 1) {
            iv(1);
            return true;
        } else if (this.cdg.wL()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.bZY.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            com.baidu.tieba.tbadkCore.m mVar = (com.baidu.tieba.tbadkCore.m) com.baidu.tieba.tbadkCore.m.objectWithJson(com.baidu.tieba.tbadkCore.m.jsonWithObject(this.cgi), com.baidu.tieba.tbadkCore.m.class);
            mVar.setPn(mVar.getPn() + 1);
            mVar.setSortType(agy());
            a(mVar, 1);
            return true;
        }
    }

    public void D(int i, boolean z) {
        if (this.bRX != null && this.bRX.bkz() != null) {
            this.bRX.bkz().clear();
        }
        com.baidu.tieba.tbadkCore.m mVar = (com.baidu.tieba.tbadkCore.m) com.baidu.tieba.tbadkCore.m.objectWithJson(com.baidu.tieba.tbadkCore.m.jsonWithObject(this.cgi), com.baidu.tieba.tbadkCore.m.class);
        mVar.setPn(1);
        this.cgl = b(this.cgl, mVar);
        if (this.cgl == 1) {
            if (!this.cdg.wL()) {
                a(mVar, i);
                return;
            }
            return;
        }
        if (this.cgo == null) {
            this.cgo = new cm();
            this.cgo.pn = 1;
            this.cgo.forumName = this.bRN;
            if (this.bRX != null && this.bRX.aOk() != null) {
                this.cgo.forumId = this.bRX.aOk().getId();
            }
        }
        iv(i);
    }

    public void iq(int i) {
        if (this.cgl != 1) {
            iv(4);
        } else if (!this.cdg.wL()) {
            com.baidu.tieba.tbadkCore.m mVar = (com.baidu.tieba.tbadkCore.m) com.baidu.tieba.tbadkCore.m.objectWithJson(com.baidu.tieba.tbadkCore.m.jsonWithObject(this.cgi), com.baidu.tieba.tbadkCore.m.class);
            mVar.setPn(i);
            mVar.setSortType(agy());
            a(mVar, 4);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.m mVar, int i) {
        this.cgj.hS(i);
        this.cdg.a(mVar);
        this.mType = i;
        mVar.setKw(this.bRN);
        if (com.baidu.tbadk.core.l.oJ().oP()) {
            mVar.setRn(35);
        } else {
            mVar.setRn(50);
        }
        mVar.setWithGroup(1);
        mVar.setCid(0);
        int K = com.baidu.adp.lib.util.k.K(this.bZY.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.bZY.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = ay.vC().vE() ? 2 : 1;
        mVar.setScrW(K);
        mVar.setScrH(L);
        mVar.setScrDip(f);
        mVar.setqType(i2);
        mVar.setLastId(this.cdj);
        mVar.setYuelaouLocate(this.cgw);
        mVar.setLastClickTid(com.baidu.adp.lib.h.b.c(com.baidu.tbadk.util.r.Hg(), 0L));
        if (this.mSource != null) {
            mVar.setStType(this.mSource);
            if (this.mSource.equalsIgnoreCase("sidebar")) {
                mVar.setStType(null);
            }
        }
        if (FrsActivity.bRZ != 0) {
            mVar.setCtime((int) FrsActivity.bRZ);
        }
        if (FrsActivity.bSa != 0) {
            mVar.setDataSize((int) FrsActivity.bSa);
        }
        if (FrsActivity.bSb != 0) {
            mVar.setNetError(FrsActivity.bSb);
        }
        mVar.setNeedCache(mVar.getPn() == 1 && this.mType == 3);
        mVar.setUpdateType(this.mType);
        com.baidu.tieba.frs.g.e.c(i, mVar);
        com.baidu.tieba.frs.utils.s.a(this.cgx, mVar);
        if (!iu(this.cgx)) {
            new a(this, true, com.baidu.tieba.tbadkCore.d.bkd().e(this.bRN, mVar.agy(), mVar.getIsGood(), this.cgi.getCategoryId())).execute(new Object[0]);
        }
        afF();
    }

    protected boolean a(com.baidu.tieba.tbadkCore.m mVar, com.baidu.tieba.tbadkCore.n nVar) {
        if (this.cgq) {
            this.cgl = nVar.bkD();
        }
        this.bRX.d(nVar);
        f(this.bRX);
        this.cdf = new ArrayList<>();
        if (mVar != null) {
            this.cgi = mVar;
            this.mPn = this.cgi.getPn();
            this.bRN = this.cgi.getKw();
            this.bZY.setForumName(this.bRN);
            this.bZY.setFrom(this.adE);
            this.bZY.setPn(this.mPn);
            this.bZY.setFlag(this.mFlag);
        }
        if (this.bRX.getThreadList() != null) {
            this.cdf.addAll(this.bRX.getThreadList());
        }
        if (this.cgl != 1 && this.cgq) {
            this.cgj.a(7, false, this.cdi);
        } else {
            this.cgj.a(this.mType, false, this.cdi);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.g.e.b(this.cgi)) {
            agE();
        }
        this.cgq = false;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.n, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.tbadkCore.m, com.baidu.tieba.tbadkCore.n> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.m, com.baidu.tieba.tbadkCore.n> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.n nVar;
        e.a aVar = new e.a();
        aVar.fzn = com.baidu.adp.lib.util.i.gm() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.fzo = mvcSocketResponsedMessage.getDownSize();
        this.cdi = aVar;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
            nVar = null;
        } else {
            nVar = mvcSocketResponsedMessage.getData();
            r3 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && nVar != null && a(r3, nVar)) {
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
        this.bZY.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.n, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.tbadkCore.m, com.baidu.tieba.tbadkCore.n> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.m, com.baidu.tieba.tbadkCore.n> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m mVar;
        com.baidu.tieba.tbadkCore.m mVar2 = null;
        if (!this.cdm) {
            this.cdm = true;
            a(1000, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        }
        long j = 0;
        if (mvcSocketMessage != null) {
            j = mvcSocketMessage.getClientLogID();
            mVar2 = mvcSocketMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            mVar = mvcNetMessage.getRequestData();
        } else {
            mVar = mVar2;
        }
        int error = mvcSocketResponsedMessage.getError();
        String errorString = mvcSocketResponsedMessage.getErrorString();
        if (error != 0) {
            int cmd = mvcSocketResponsedMessage.getCmd();
            Object[] objArr = new Object[4];
            objArr[0] = "kw";
            objArr[1] = mVar != null ? mVar.getKw() : null;
            objArr[2] = "seq_id";
            objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
            com.baidu.tbadk.core.log.b.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.n> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tieba.tbadkCore.m, com.baidu.tieba.tbadkCore.n> mvcHttpMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.m, com.baidu.tieba.tbadkCore.n> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.n nVar;
        e.a aVar = new e.a();
        aVar.fzn = com.baidu.adp.lib.util.i.gm() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.fzo = mvcHttpResponsedMessage.getDownSize();
        this.cdi = aVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            nVar = null;
        } else {
            nVar = mvcHttpResponsedMessage.getData();
            r3 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && nVar != null && a(r3, nVar)) {
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
        this.bZY.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    @Override // com.baidu.adp.base.e
    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        super.registerListener(i, aVar);
    }

    private void b(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.n> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tieba.tbadkCore.m, com.baidu.tieba.tbadkCore.n> mvcHttpMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.m, com.baidu.tieba.tbadkCore.n> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m mVar;
        com.baidu.tieba.tbadkCore.m mVar2 = null;
        long j = 0;
        if (mvcHttpMessage != null) {
            j = mvcHttpMessage.getClientLogID();
            mVar2 = mvcHttpMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            mVar = mvcNetMessage.getRequestData();
        } else {
            mVar = mVar2;
        }
        int error = mvcHttpResponsedMessage.getError();
        String errorString = mvcHttpResponsedMessage.getErrorString();
        if (error != 0) {
            int cmd = mvcHttpResponsedMessage.getCmd();
            Object[] objArr = new Object[2];
            objArr[0] = "kw";
            objArr[1] = mVar != null ? mVar.getKw() : null;
            com.baidu.tbadk.core.log.b.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
        if (!this.cdm) {
            this.cdm = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void aco() {
        if (this.bRX != null && this.bRX.aOk() != null && this.bRX.aOk().getBannerListData() != null) {
            String lastIds = this.bRX.aOk().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.cdj = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.Gu().Gv()) {
            this.aCM = System.currentTimeMillis() - this.bZY.RA;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v(i, z, responsedMessage, this.bZY.aCD, this.bZY.createTime, this.bZY.aCL, false, this.aCM);
            this.bZY.createTime = 0L;
            this.bZY.aCD = 0L;
            if (vVar != null) {
                vVar.Gp();
            }
        }
    }

    public String ago() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.bRN;
    }

    public com.baidu.tieba.tbadkCore.p afE() {
        return this.bRX;
    }

    public e.a agp() {
        return this.cdi;
    }

    private void afF() {
        this.bKv = System.currentTimeMillis();
        this.cdg.Ff();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.n nVar) {
        this.cgr = false;
        this.bRX.d(nVar);
        f(this.bRX);
        this.cdf = new ArrayList<>();
        if (this.bRX.getThreadList() != null) {
            this.cdf.addAll(this.bRX.getThreadList());
        }
        this.cgj.b(nVar);
    }

    private void f(com.baidu.tieba.tbadkCore.p pVar) {
        if (com.baidu.tieba.frs.j.n.l(pVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.j.n.m(pVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.n, Void> {
        private String aNq;
        private i cgB;
        private boolean needCache;

        public a(i iVar, boolean z, String str) {
            this.aNq = null;
            this.aNq = str;
            this.cgB = iVar;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.d.bkd().rn(this.aNq)) {
                if (!com.baidu.tieba.tbadkCore.d.bkd().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.aNq)) {
                    com.baidu.tieba.tbadkCore.d.bkd().getResponseData().aOk().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.n responseData = com.baidu.tieba.tbadkCore.d.bkd().getResponseData();
                if (responseData.bkF() != null && !StringUtils.isNull(responseData.bkF().getBookId(), true) && !responseData.bkF().getBookId().equals("0") && responseData.bkF().pB() == 3 && (g = com.baidu.adp.lib.h.b.g(responseData.bkF().getBookId(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
                    responseData.h(Integer.valueOf(((Integer) runTask.getData()).intValue()));
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
        public void onProgressUpdate(com.baidu.tieba.tbadkCore.n... nVarArr) {
            super.onProgressUpdate(nVarArr);
            if (this.cgB != null && nVarArr != null) {
                this.cgB.c(nVarArr.length > 0 ? nVarArr[0] : null);
                this.cgB.C(this.cgB.cgx, true);
            }
        }
    }

    public long Ze() {
        return this.bKy;
    }

    public long Zf() {
        return this.bKw;
    }

    public long Zg() {
        return this.bKx;
    }

    public long Zh() {
        return this.bKv;
    }

    public boolean wL() {
        return this.cdg.wL();
    }

    public int agq() {
        return this.cgn;
    }

    private void agr() {
        if (this.cgv == null) {
            this.cgv = new ArrayList<>();
        }
        if (this.cgv.size() == 0) {
            this.cgv.add(new bu());
        }
    }

    @Override // com.baidu.tieba.frs.ce
    public void a(int i, int i2, cm cmVar) {
        this.cgl = b(i, null);
        if (cmVar == null && (cmVar = ao(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.k.gD() && this.cgu != null) {
                cp cpVar = new cp();
                cpVar.hasMore = false;
                cpVar.pn = 1;
                cpVar.forumName = this.bRN;
                cpVar.bVL = false;
                if (this.bRX != null && this.bRX.aOk() != null) {
                    cpVar.forumId = this.bRX.aOk().getId();
                }
                agr();
                this.bRX.aD(this.cgv);
                this.cgu.a(i, i2, cpVar, this.cgv);
            }
            cmVar = new cm();
            cmVar.pn = -1;
        }
        if (this.bRX != null && this.bRX.aOk() != null) {
            cmVar.forumId = this.bRX.aOk().getId();
        }
        cmVar.forumName = this.bRN;
        if (bx.adE().hY(1) != null && this.cgl == 1) {
            this.cgi.setCategoryId(i2);
        }
        this.cgm = i2;
        this.cgo = cmVar;
        b(i, i2, cmVar);
        iv(5);
    }

    @Override // com.baidu.tieba.frs.ce
    public void a(cf cfVar) {
        this.cgu = cfVar;
        this.cgt.a(this.cgz);
    }

    private void iv(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.cgo != null) {
                    this.cgo.pn++;
                    break;
                }
                break;
            case 2:
                if (this.cgo != null) {
                    cm cmVar = this.cgo;
                    cmVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.cgo != null) {
                    this.cgo.pn = -1;
                    break;
                }
                break;
        }
        if (this.cgl == 1) {
            if (this.cgn == this.cgm) {
                ArrayList<v> arrayList = new ArrayList<>();
                if (this.cdf != null) {
                    arrayList.addAll(this.cdf);
                }
                this.bRX.aD(arrayList);
                if (this.cgu != null) {
                    this.cgu.a(this.cgl, this.cgm, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.cgn = this.cgm;
            return;
        }
        ce hZ = this.cgt.hZ(this.cgl);
        if (hZ != null) {
            this.cgp = true;
            hZ.a(this.cgl, this.cgm, this.cgo);
            return;
        }
        if (this.bRX != null && this.bRX.getThreadList() != null) {
            this.bRX.getThreadList().clear();
        }
        this.cgu.a(this.cgl, this.cgm, null, null);
    }

    public boolean hasMore() {
        if ((this.cgo instanceof cp) && ((cp) this.cgo).errCode == 0) {
            return ((cp) this.cgo).hasMore;
        }
        return true;
    }

    private int an(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, cm cmVar) {
        this.cgs.put(an(i, i2), cmVar);
    }

    public cm ao(int i, int i2) {
        return this.cgs.get(an(i, i2));
    }

    @Override // com.baidu.tieba.frs.ce
    public void init() {
        this.cgt.init();
    }

    @Override // com.baidu.tieba.frs.ce
    public void abv() {
        this.cgt.destory();
        this.cgt.clear();
    }

    public int ags() {
        return this.cgl;
    }

    public boolean agt() {
        return 1 == this.cgl || 2 == this.cgl;
    }

    @Override // com.baidu.adp.base.e
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(al alVar) {
        if (alVar != null && !StringUtils.isNull(alVar.getId()) && this.cdf != null) {
            if (this.cgl == 1) {
                this.bRX.a(alVar);
            }
            int agu = agu();
            if (this.cdf != null && this.cdf.size() > 0) {
                int size = this.cdf.size();
                for (int i = 0; i < size; i++) {
                    v vVar = this.cdf.get(i);
                    if ((vVar instanceof bk) && alVar.getId().equals(((bk) vVar).getId())) {
                        return;
                    }
                }
            }
            if (alVar.getThreadType() == 33) {
                au auVar = new au();
                auVar.a(alVar, -1);
                auVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.cdf.add(agu, auVar);
                    return;
                }
                return;
            }
            this.cdf.add(agu, alVar);
        }
    }

    public int agu() {
        if (this.cdf == null || this.cdf.size() <= 0) {
            return 0;
        }
        Iterator<v> it = this.cdf.iterator();
        int i = 0;
        while (it.hasNext()) {
            v next = it.next();
            if (next instanceof bk) {
                if (((bk) next).rL() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public boolean agv() {
        return this.cgp;
    }

    public void agw() {
        bd bdVar = new bd();
        if (this.cgn == 0) {
            bdVar.hX(this.cgx);
        }
        if (this.bRX.getThreadList() != null) {
            this.bRX.getThreadList().clear();
            this.bRX.getThreadList().add(bdVar);
        }
        if (this.cdf != null) {
            this.cdf.clear();
            this.cdf.add(bdVar);
        }
    }

    public void iw(int i) {
        this.cgx = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.s.bne();
        } else {
            com.baidu.tieba.tbadkCore.util.s.bnf();
        }
    }

    public int agx() {
        return this.cgx;
    }

    public int agy() {
        return com.baidu.tieba.frs.utils.s.iI(this.cgx);
    }

    public boolean agz() {
        return this.cgk;
    }

    public boolean agA() {
        return this.cgx == 5;
    }

    public boolean agB() {
        return agD() && agC();
    }

    public boolean agC() {
        return this.cgi != null && this.cgi.getLoadType() == 1;
    }

    public boolean agD() {
        return this.cgx == 7;
    }

    private int b(int i, com.baidu.tieba.tbadkCore.m mVar) {
        if ((i == 1 || i == 2) && this.bZY.abM() != null) {
            return this.bZY.abM().a(this.cgx, mVar);
        }
        return i;
    }

    public void agE() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.bRX != null && this.bRX.aOk() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.h.b.c(this.bRX.aOk().getId(), 0L));
        }
        this.bZY.sendMessage(requestIncrForumAccessCountNetMessage);
    }
}
