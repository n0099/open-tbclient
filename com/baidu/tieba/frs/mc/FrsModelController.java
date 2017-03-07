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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.performanceLog.aa;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.frs.br;
import com.baidu.tieba.frs.bu;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.frs.cb;
import com.baidu.tieba.frs.cc;
import com.baidu.tieba.frs.cj;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FrsModelController extends BdBaseModel<FrsActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.l>, cb {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long aGq;
    private String ahy;
    private long bFs;
    private long bFt;
    private long bFu;
    private long bFv;
    private String bME;
    private com.baidu.tieba.tbadkCore.n bMO;
    private final FrsActivity bTf;
    private ArrayList<com.baidu.adp.widget.ListView.v> bWm;
    private FrsNetModel<FrsActivity> bWn;
    private d.a bWp;
    private String bWq;
    private boolean bWt;
    private String bZA;
    private int bZB;
    private String bZC;
    private final SparseArray<Boolean> bZD;
    private cc bZE;
    private FrsRequestData bZo;
    private final com.baidu.tieba.tbadkCore.p bZp;
    private boolean bZq;
    private int bZr;
    private int bZs;
    private int bZt;
    private cj bZu;
    private boolean bZv;
    private SparseArray<cj> bZw;
    private bw bZx;
    private cc bZy;
    private ArrayList<com.baidu.adp.widget.ListView.v> bZz;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean in(int i) {
        return this.bZD.get(i, false).booleanValue();
    }

    public void o(int i, boolean z) {
        this.bZD.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.p pVar) {
        super(frsActivity.getPageContext());
        this.bME = null;
        this.mType = 3;
        this.mPn = 1;
        this.ahy = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.bWq = null;
        this.bZr = 1;
        this.bZs = 0;
        this.bZt = 0;
        this.bZv = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.bZw = new SparseArray<>();
        this.aGq = 0L;
        this.bWt = false;
        this.bZB = -1;
        this.bZC = null;
        this.bZD = new SparseArray<>();
        this.bZE = new i(this);
        this.bFs = 0L;
        this.bFt = 0L;
        this.bFu = 0L;
        this.bFv = 0L;
        if (frsActivity == null || pVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.bTf = frsActivity;
        this.bZp = pVar;
        D(frsActivity);
    }

    private void D(FrsActivity frsActivity) {
        this.bZx = new bw();
        this.bZx.baP = frsActivity.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.bZx));
        this.bZx.a(this.bZE);
    }

    public void onActivityDestroy() {
        this.bWn.cancelLoadData();
    }

    public void e(Bundle bundle) {
        if (bundle != null) {
            this.bME = bundle.getString("name");
            this.ahy = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.bZA = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.bZq = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.bME)) {
            this.bME = "";
        }
        if (TextUtils.isEmpty(this.ahy)) {
            this.ahy = "";
        }
        if (TextUtils.isEmpty(this.bZA)) {
            this.bZA = "";
        }
        this.mSource = this.ahy;
        this.bZo = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            ip(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            ip(6);
        } else {
            com.baidu.tieba.frs.smartsort.h iP = com.baidu.tieba.frs.smartsort.e.adr().iP(this.bME);
            if (iP != null) {
                ip(iP.cak);
            } else {
                ip(-1);
            }
        }
        this.bZo.setSortType(acY());
        if (this.bZB == 5) {
            this.bZo.setIsGood(1);
        } else {
            this.bZo.setIsGood(0);
        }
        this.bMO = new com.baidu.tieba.tbadkCore.n();
        this.bWn = new FrsNetModel<>(this.bTf.getPageContext(), this.bZo);
        this.bWn.a(this);
        this.bWn.setUniqueId(getUniqueId());
        if (this.bME != null && this.bME.length() > 0) {
            if (this.ahy == null || this.ahy.length() <= 0) {
                this.ahy = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.bME);
        bundle.putString("from", this.ahy);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean TR() {
        if (this.bZr != 1) {
            io(1);
            return true;
        } else if (this.bWn.wN()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.bTf.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.bZo), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(acY());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void p(int i, boolean z) {
        if (this.bMO != null && this.bMO.bfQ() != null) {
            this.bMO.bfQ().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.bZo), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bZr = b(this.bZr, frsRequestData);
        if (this.bZr == 1) {
            if (!this.bWn.wN()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.bZu == null) {
            this.bZu = new cj();
            this.bZu.pn = 1;
            this.bZu.forumName = this.bME;
            if (this.bMO != null && this.bMO.aJp() != null) {
                this.bZu.forumId = this.bMO.aJp().getId();
            }
        }
        io(i);
    }

    public void ij(int i) {
        if (this.bZr != 1) {
            io(4);
        } else if (!this.bWn.wN()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.bZo), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(acY());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.bZp.hK(i);
        this.bWn.a(frsRequestData);
        this.mType = i;
        frsRequestData.setKw(this.bME);
        if (com.baidu.tbadk.core.l.oQ().oW()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ag = com.baidu.adp.lib.util.k.ag(this.bTf.getPageContext().getPageActivity());
        int ah = com.baidu.adp.lib.util.k.ah(this.bTf.getPageContext().getPageActivity());
        float ai = com.baidu.adp.lib.util.k.ai(this.bTf.getPageContext().getPageActivity());
        int i2 = av.vD().vF() ? 2 : 1;
        frsRequestData.setScrW(ag);
        frsRequestData.setScrH(ah);
        frsRequestData.setScrDip(ai);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.bWq);
        frsRequestData.setYuelaouLocate(this.bZA);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(com.baidu.tbadk.util.r.GT(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsActivity.bMQ != 0) {
            frsRequestData.setCtime((int) FrsActivity.bMQ);
        }
        if (FrsActivity.bMR != 0) {
            frsRequestData.setDataSize((int) FrsActivity.bMR);
        }
        if (FrsActivity.bMS != 0) {
            frsRequestData.setNetError(FrsActivity.bMS);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.smartsort.d.c(i, frsRequestData);
        a(this.bME, frsRequestData);
        com.baidu.tieba.frs.utils.r.a(this.bZB, frsRequestData);
        if (!in(this.bZB)) {
            String e = com.baidu.tieba.tbadkCore.c.bft().e(this.bME, frsRequestData.acY(), frsRequestData.getIsGood(), this.bZo.getCategoryId());
            this.bZC = e;
            new a(this, true, e).execute(new Object[0]);
        }
        acd();
    }

    protected boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.l lVar) {
        if (this.isNetFirstLoad) {
            this.bZr = lVar.bfU();
        }
        this.bMO.d(lVar);
        e(this.bMO);
        this.bWm = new ArrayList<>();
        if (frsRequestData != null) {
            this.bZo = frsRequestData;
            this.mPn = this.bZo.getPn();
            this.bME = this.bZo.getKw();
            this.bTf.setForumName(this.bME);
            this.bTf.setFrom(this.ahy);
            this.bTf.setPn(this.mPn);
            this.bTf.setFlag(this.mFlag);
        }
        if (this.bMO.getThreadList() != null) {
            this.bWm.addAll(this.bMO.getThreadList());
        }
        if (this.bZr != 1 && this.isNetFirstLoad) {
            this.bZp.a(7, false, this.bWp);
        } else {
            this.bZp.a(this.mType, false, this.bWp);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.d.b(this.bZo)) {
            add();
        }
        this.isNetFirstLoad = false;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        d.a aVar = new d.a();
        aVar.frg = com.baidu.adp.lib.util.i.he() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.frh = mvcSocketResponsedMessage.getDownSize();
        this.bWp = aVar;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
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
        this.bTf.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData;
        FrsRequestData frsRequestData2 = null;
        if (!this.bWt) {
            this.bWt = true;
            a(1000, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        }
        long j = 0;
        if (mvcSocketMessage != null) {
            j = mvcSocketMessage.getClientLogID();
            frsRequestData2 = mvcSocketMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            frsRequestData = mvcNetMessage.getRequestData();
        } else {
            frsRequestData = frsRequestData2;
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
            com.baidu.tbadk.core.log.b.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.l> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        d.a aVar = new d.a();
        aVar.frg = com.baidu.adp.lib.util.i.he() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.frh = mvcHttpResponsedMessage.getDownSize();
        this.bWp = aVar;
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
        this.bTf.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        super.registerListener(i, aVar);
    }

    private void b(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.l> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData;
        FrsRequestData frsRequestData2 = null;
        long j = 0;
        if (mvcHttpMessage != null) {
            j = mvcHttpMessage.getClientLogID();
            frsRequestData2 = mvcHttpMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            frsRequestData = mvcNetMessage.getRequestData();
        } else {
            frsRequestData = frsRequestData2;
        }
        int error = mvcHttpResponsedMessage.getError();
        String errorString = mvcHttpResponsedMessage.getErrorString();
        if (error != 0) {
            int cmd = mvcHttpResponsedMessage.getCmd();
            Object[] objArr = new Object[2];
            objArr[0] = "kw";
            objArr[1] = frsRequestData != null ? frsRequestData.getKw() : null;
            com.baidu.tbadk.core.log.b.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
        if (!this.bWt) {
            this.bWt = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void YS() {
        if (this.bMO != null && this.bMO.aJp() != null && this.bMO.aJp().getBannerListData() != null) {
            String lastIds = this.bMO.aJp().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.bWq = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.Gi().Gj()) {
            this.aGq = System.currentTimeMillis() - this.bTf.VT;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v(i, z, responsedMessage, this.bTf.aGh, this.bTf.createTime, this.bTf.aGp, false, this.aGq);
            this.bTf.createTime = 0L;
            this.bTf.aGh = 0L;
            if (vVar != null) {
                vVar.Gd();
            }
        }
    }

    public String acN() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.bME;
    }

    public com.baidu.tieba.tbadkCore.n acc() {
        return this.bMO;
    }

    public d.a acO() {
        return this.bWp;
    }

    private void acd() {
        this.bFs = System.currentTimeMillis();
        this.bWn.Fe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.l lVar) {
        this.isCacheFirstLoad = false;
        this.bMO.d(lVar);
        e(this.bMO);
        this.bWm = new ArrayList<>();
        if (this.bMO.getThreadList() != null) {
            this.bWm.addAll(this.bMO.getThreadList());
        }
        this.bZp.b(lVar);
    }

    private void e(com.baidu.tieba.tbadkCore.n nVar) {
        if (com.baidu.tieba.frs.f.u.k(nVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.f.u.l(nVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.l, Void> {
        private String aRt;
        private FrsModelController bZH;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.aRt = null;
            this.aRt = str;
            this.bZH = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bft().pu(this.aRt)) {
                if (!com.baidu.tieba.tbadkCore.c.bft().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.aRt)) {
                    com.baidu.tieba.tbadkCore.c.bft().getResponseData().aJp().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.l responseData = com.baidu.tieba.tbadkCore.c.bft().getResponseData();
                if (responseData.bfW() != null && !StringUtils.isNull(responseData.bfW().getBookId(), true) && !responseData.bfW().getBookId().equals("0") && responseData.bfW().pM() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bfW().getBookId(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
                    responseData.d(Integer.valueOf(((Integer) runTask.getData()).intValue()));
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
            if (this.bZH != null && lVarArr != null) {
                this.bZH.c(lVarArr.length > 0 ? lVarArr[0] : null);
                this.bZH.o(this.bZH.bZB, true);
            }
        }
    }

    public long VI() {
        return this.bFv;
    }

    public long VJ() {
        return this.bFt;
    }

    public long VK() {
        return this.bFu;
    }

    public long VL() {
        return this.bFs;
    }

    public boolean wN() {
        return this.bWn.wN();
    }

    public int acP() {
        return this.bZt;
    }

    private void acQ() {
        if (this.bZz == null) {
            this.bZz = new ArrayList<>();
        }
        if (this.bZz.size() == 0) {
            this.bZz.add(new br());
        }
    }

    @Override // com.baidu.tieba.frs.cb
    public void a(int i, int i2, cj cjVar) {
        this.bZr = b(i, null);
        if (cjVar == null && (cjVar = ao(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.k.hv() && this.bZy != null) {
                cm cmVar = new cm();
                cmVar.hasMore = false;
                cmVar.pn = 1;
                cmVar.forumName = this.bME;
                cmVar.bQu = false;
                if (this.bMO != null && this.bMO.aJp() != null) {
                    cmVar.forumId = this.bMO.aJp().getId();
                }
                acQ();
                this.bMO.ax(this.bZz);
                this.bZy.a(i, i2, cmVar, this.bZz);
            }
            cjVar = new cj();
            cjVar.pn = -1;
        }
        if (this.bMO != null && this.bMO.aJp() != null) {
            cjVar.forumId = this.bMO.aJp().getId();
        }
        cjVar.forumName = this.bME;
        if (bu.aad().hR(1) != null && this.bZr == 1) {
            this.bZo.setCategoryId(i2);
        }
        this.bZs = i2;
        this.bZu = cjVar;
        b(i, i2, cjVar);
        io(5);
    }

    @Override // com.baidu.tieba.frs.cb
    public void a(cc ccVar) {
        this.bZy = ccVar;
        this.bZx.a(this.bZE);
    }

    private void io(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.bZu != null) {
                    this.bZu.pn++;
                    break;
                }
                break;
            case 2:
                if (this.bZu != null) {
                    cj cjVar = this.bZu;
                    cjVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.bZu != null) {
                    this.bZu.pn = -1;
                    break;
                }
                break;
        }
        if (this.bZr == 1) {
            if (this.bZt == this.bZs) {
                ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
                if (this.bWm != null) {
                    arrayList.addAll(this.bWm);
                }
                this.bMO.ax(arrayList);
                if (this.bZy != null) {
                    this.bZy.a(this.bZr, this.bZs, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.bZt = this.bZs;
            return;
        }
        cb hS = this.bZx.hS(this.bZr);
        if (hS != null) {
            this.bZv = true;
            hS.a(this.bZr, this.bZs, this.bZu);
            return;
        }
        if (this.bMO != null && this.bMO.getThreadList() != null) {
            this.bMO.getThreadList().clear();
        }
        this.bZy.a(this.bZr, this.bZs, null, null);
    }

    public boolean hasMore() {
        if ((this.bZu instanceof cm) && ((cm) this.bZu).errCode == 0) {
            return ((cm) this.bZu).hasMore;
        }
        return true;
    }

    private int an(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, cj cjVar) {
        this.bZw.put(an(i, i2), cjVar);
    }

    public cj ao(int i, int i2) {
        return this.bZw.get(an(i, i2));
    }

    @Override // com.baidu.tieba.frs.cb
    public void init() {
        this.bZx.init();
    }

    @Override // com.baidu.tieba.frs.cb
    public void MQ() {
        this.bZx.destory();
        this.bZx.clear();
    }

    public int acR() {
        return this.bZr;
    }

    public boolean acS() {
        return 1 == this.bZr || 2 == this.bZr;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(an anVar) {
        if (anVar != null && !StringUtils.isNull(anVar.getId()) && this.bWm != null) {
            if (this.bZr == 1) {
                this.bMO.a(anVar);
            }
            int acT = acT();
            if (this.bWm != null && this.bWm.size() > 0) {
                int size = this.bWm.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.v vVar = this.bWm.get(i);
                    if ((vVar instanceof bj) && anVar.getId().equals(((bj) vVar).getId())) {
                        return;
                    }
                }
            }
            if (anVar.getThreadType() == 33) {
                aw awVar = new aw();
                awVar.a(anVar, -1);
                awVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.bWm.add(acT, awVar);
                    return;
                }
                return;
            }
            this.bWm.add(acT, anVar);
        }
    }

    public int acT() {
        if (this.bWm == null || this.bWm.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.bWm.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next instanceof bj) {
                if (((bj) next).rM() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean acU() {
        return this.bZv;
    }

    public void acV() {
        be beVar = new be();
        if (this.bZt == 0) {
            beVar.hQ(this.bZB);
        }
        if (this.bMO.getThreadList() != null) {
            this.bMO.getThreadList().clear();
            this.bMO.getThreadList().add(beVar);
        }
        if (this.bWm != null) {
            this.bWm.clear();
            this.bWm.add(beVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> acW() {
        return this.bWm;
    }

    public void ip(int i) {
        this.bZB = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.s.biz();
        } else {
            com.baidu.tieba.tbadkCore.util.s.biA();
        }
    }

    public int acX() {
        return this.bZB;
    }

    public int acY() {
        return com.baidu.tieba.frs.utils.r.iB(this.bZB);
    }

    public boolean acZ() {
        return this.bZq;
    }

    public boolean ada() {
        return this.bZB == 5;
    }

    public boolean adb() {
        return this.bZo != null && this.bZo.getLoadType() == 1;
    }

    public boolean adc() {
        return this.bZB == 7;
    }

    private int b(int i, FrsRequestData frsRequestData) {
        if ((i == 1 || i == 2) && this.bTf.Yr() != null) {
            return this.bTf.Yr().a(this.bZB, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bj.XR.get()) {
            int oX = com.baidu.tieba.recapp.r.aZD().aZB().oX(str);
            int oY = com.baidu.tieba.recapp.r.aZD().aZB().oY(str);
            if (frsRequestData.getLoadType() == 1) {
                oX++;
            } else {
                oY++;
            }
            frsRequestData.rH(oX);
            frsRequestData.rG(oY);
        }
    }

    public void add() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.bMO != null && this.bMO.aJp() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.bMO.aJp().getId(), 0L));
        }
        this.bTf.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void iK(String str) {
        com.baidu.tbadk.util.t.a(new j(this, str), null);
    }
}
