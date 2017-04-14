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
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.j.aa;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.frs.by;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.cl;
import com.baidu.tieba.frs.co;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FrsModelController extends BdBaseModel<FrsActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.l>, cd {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long aGF;
    private String ahM;
    private long bFl;
    private long bFm;
    private long bFn;
    private long bFo;
    private com.baidu.tieba.tbadkCore.n bME;
    private String bMu;
    private final FrsActivity bST;
    private ArrayList<com.baidu.adp.widget.ListView.v> bWa;
    private FrsNetModel<FrsActivity> bWb;
    private d.a bWd;
    private String bWe;
    private boolean bWh;
    private FrsRequestData bXN;
    private final com.baidu.tieba.tbadkCore.p bXO;
    private boolean bXP;
    private int bXQ;
    private int bXR;
    private int bXS;
    private cl bXT;
    private boolean bXU;
    private SparseArray<cl> bXV;
    private by bXW;
    private ce bXX;
    private ArrayList<com.baidu.adp.widget.ListView.v> bXY;
    private String bXZ;
    private int bYa;
    private String bYb;
    private final SparseArray<Boolean> bYc;
    private ce bYd;
    private int buQ;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mPageType;
    private String mSource;
    private int mType;

    public boolean io(int i) {
        return this.bYc.get(i, false).booleanValue();
    }

    public void o(int i, boolean z) {
        this.bYc.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.p pVar) {
        super(frsActivity.getPageContext());
        this.bMu = null;
        this.mType = 3;
        this.buQ = 1;
        this.ahM = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.bWe = null;
        this.bXQ = 1;
        this.bXR = 0;
        this.bXS = 0;
        this.bXU = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.bXV = new SparseArray<>();
        this.aGF = 0L;
        this.bWh = false;
        this.bYa = -1;
        this.bYb = null;
        this.bYc = new SparseArray<>();
        this.bYd = new i(this);
        this.bFl = 0L;
        this.bFm = 0L;
        this.bFn = 0L;
        this.bFo = 0L;
        if (frsActivity == null || pVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.bST = frsActivity;
        this.bXO = pVar;
        D(frsActivity);
    }

    private void D(FrsActivity frsActivity) {
        this.bXW = new by();
        this.bXW.baI = frsActivity.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.bXW));
        this.bXW.a(this.bYd);
    }

    public void onActivityDestroy() {
        this.bWb.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.bMu = bundle.getString("name");
            this.ahM = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.bXZ = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.bXP = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.bMu)) {
            this.bMu = "";
        }
        if (TextUtils.isEmpty(this.ahM)) {
            this.ahM = "";
        }
        if (TextUtils.isEmpty(this.bXZ)) {
            this.bXZ = "";
        }
        this.mSource = this.ahM;
        this.bXN = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            iq(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            iq(6);
        } else {
            com.baidu.tieba.frs.smartsort.h iU = com.baidu.tieba.frs.smartsort.e.adl().iU(this.bMu);
            if (iU != null) {
                iq(iU.bYL);
            } else {
                iq(-1);
            }
        }
        this.bXN.setSortType(acS());
        if (this.bYa == 5) {
            this.bXN.setIsGood(1);
        } else {
            this.bXN.setIsGood(0);
        }
        this.bME = new com.baidu.tieba.tbadkCore.n();
        this.bWb = new FrsNetModel<>(this.bST.getPageContext(), this.bXN);
        this.bWb.a(this);
        this.bWb.setUniqueId(getUniqueId());
        if (this.bMu != null && this.bMu.length() > 0) {
            if (this.ahM == null || this.ahM.length() <= 0) {
                this.ahM = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.bMu);
        bundle.putString("from", this.ahM);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean Up() {
        if (this.bXQ != 1) {
            ip(1);
            return true;
        } else if (this.bWb.xj()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.bST.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.bXN), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(acS());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void p(int i, boolean z) {
        if (this.bME != null && this.bME.bgD() != null) {
            this.bME.bgD().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.bXN), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bXQ = b(this.bXQ, frsRequestData);
        if (this.bXQ == 1) {
            if (!this.bWb.xj()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.bXT == null) {
            this.bXT = new cl();
            this.bXT.pn = 1;
            this.bXT.forumName = this.bMu;
            if (this.bME != null && this.bME.aJw() != null) {
                this.bXT.forumId = this.bME.aJw().getId();
            }
        }
        ip(i);
    }

    public void im(int i) {
        if (this.bXQ != 1) {
            ip(4);
        } else if (!this.bWb.xj()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.bXN), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(acS());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.bXO.hN(i);
        this.bWb.a(frsRequestData);
        this.mType = i;
        frsRequestData.setKw(this.bMu);
        if (com.baidu.tbadk.core.q.po().pu()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int af = com.baidu.adp.lib.util.k.af(this.bST.getPageContext().getPageActivity());
        int ag = com.baidu.adp.lib.util.k.ag(this.bST.getPageContext().getPageActivity());
        float ah = com.baidu.adp.lib.util.k.ah(this.bST.getPageContext().getPageActivity());
        int i2 = av.wa().wc() ? 2 : 1;
        frsRequestData.setScrW(af);
        frsRequestData.setScrH(ag);
        frsRequestData.setScrDip(ah);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.bWe);
        frsRequestData.setYuelaouLocate(this.bXZ);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(com.baidu.tbadk.util.r.Hs(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsActivity.bMG != 0) {
            frsRequestData.setCtime((int) FrsActivity.bMG);
        }
        if (FrsActivity.bMH != 0) {
            frsRequestData.setDataSize((int) FrsActivity.bMH);
        }
        if (FrsActivity.bMI != 0) {
            frsRequestData.setNetError(FrsActivity.bMI);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.smartsort.d.c(i, frsRequestData);
        a(this.bMu, frsRequestData);
        com.baidu.tieba.frs.f.r.a(this.bYa, frsRequestData);
        if (!io(this.bYa)) {
            String g = com.baidu.tieba.tbadkCore.c.bgh().g(this.bMu, frsRequestData.acS(), frsRequestData.getIsGood(), this.bXN.getCategoryId());
            this.bYb = g;
            new a(this, true, g).execute(new Object[0]);
        }
        acz();
    }

    protected boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.l lVar) {
        if (this.isNetFirstLoad) {
            this.bXQ = lVar.bgH();
        }
        this.bME.d(lVar);
        e(this.bME);
        this.bWa = new ArrayList<>();
        if (frsRequestData != null) {
            this.bXN = frsRequestData;
            this.buQ = this.bXN.getPn();
            this.bMu = this.bXN.getKw();
            this.bST.setForumName(this.bMu);
            this.bST.setFrom(this.ahM);
            this.bST.setPn(this.buQ);
            this.bST.setFlag(this.mFlag);
        }
        if (this.bME.getThreadList() != null) {
            this.bWa.addAll(this.bME.getThreadList());
        }
        if (this.bXQ != 1 && this.isNetFirstLoad) {
            this.bXO.a(7, false, this.bWd);
        } else {
            this.bXO.a(this.mType, false, this.bWd);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.d.b(this.bXN)) {
            acX();
        }
        this.isNetFirstLoad = false;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        d.a aVar = new d.a();
        aVar.fsS = com.baidu.adp.lib.util.i.hj() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.fsT = mvcSocketResponsedMessage.getDownSize();
        this.bWd = aVar;
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
        this.bST.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData;
        FrsRequestData frsRequestData2 = null;
        if (!this.bWh) {
            this.bWh = true;
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
            com.baidu.tbadk.core.e.a.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.l> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        d.a aVar = new d.a();
        aVar.fsS = com.baidu.adp.lib.util.i.hj() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.fsT = mvcHttpResponsedMessage.getDownSize();
        this.bWd = aVar;
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
        this.bST.a(errorData);
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
            com.baidu.tbadk.core.e.a.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
        if (!this.bWh) {
            this.bWh = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void Zo() {
        if (this.bME != null && this.bME.aJw() != null && this.bME.aJw().getBannerListData() != null) {
            String lastIds = this.bME.aJw().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.bWe = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.GG().GH()) {
            this.aGF = System.currentTimeMillis() - this.bST.Wi;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v(i, z, responsedMessage, this.bST.aGw, this.bST.createTime, this.bST.aGE, false, this.aGF);
            this.bST.createTime = 0L;
            this.bST.aGw = 0L;
            if (vVar != null) {
                vVar.GB();
            }
        }
    }

    public String acH() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.bMu;
    }

    public com.baidu.tieba.tbadkCore.n acy() {
        return this.bME;
    }

    public d.a acI() {
        return this.bWd;
    }

    private void acz() {
        this.bFl = System.currentTimeMillis();
        this.bWb.FC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.l lVar) {
        this.isCacheFirstLoad = false;
        this.bME.d(lVar);
        e(this.bME);
        this.bWa = new ArrayList<>();
        if (this.bME.getThreadList() != null) {
            this.bWa.addAll(this.bME.getThreadList());
        }
        this.bXO.b(lVar);
    }

    private void e(com.baidu.tieba.tbadkCore.n nVar) {
        if (com.baidu.tieba.frs.g.u.k(nVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.g.u.l(nVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.l, Void> {
        private String aRJ;
        private FrsModelController bYh;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.aRJ = null;
            this.aRJ = str;
            this.bYh = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bgh().pL(this.aRJ)) {
                if (!com.baidu.tieba.tbadkCore.c.bgh().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.aRJ)) {
                    com.baidu.tieba.tbadkCore.c.bgh().getResponseData().aJw().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.l responseData = com.baidu.tieba.tbadkCore.c.bgh().getResponseData();
                if (responseData.bgJ() != null && !StringUtils.isNull(responseData.bgJ().getBookId(), true) && !responseData.bgJ().getBookId().equals("0") && responseData.bgJ().qk() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bgJ().getBookId(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
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
            if (this.bYh != null && lVarArr != null) {
                this.bYh.c(lVarArr.length > 0 ? lVarArr[0] : null);
                this.bYh.o(this.bYh.bYa, true);
            }
        }
    }

    public long Wg() {
        return this.bFo;
    }

    public long Wh() {
        return this.bFm;
    }

    public long Wi() {
        return this.bFn;
    }

    public long Wj() {
        return this.bFl;
    }

    public boolean xj() {
        return this.bWb.xj();
    }

    public int acJ() {
        return this.bXS;
    }

    private void acK() {
        if (this.bXY == null) {
            this.bXY = new ArrayList<>();
        }
        if (this.bXY.size() == 0) {
            this.bXY.add(new bt());
        }
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(int i, int i2, cl clVar) {
        this.bXQ = b(i, null);
        if (clVar == null && (clVar = am(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.k.hA() && this.bXX != null) {
                co coVar = new co();
                coVar.hasMore = false;
                coVar.pn = 1;
                coVar.forumName = this.bMu;
                coVar.bQj = false;
                if (this.bME != null && this.bME.aJw() != null) {
                    coVar.forumId = this.bME.aJw().getId();
                }
                acK();
                this.bME.ax(this.bXY);
                this.bXX.a(i, i2, coVar, this.bXY);
            }
            clVar = new cl();
            clVar.pn = -1;
        }
        if (this.bME != null && this.bME.aJw() != null) {
            clVar.forumId = this.bME.aJw().getId();
        }
        clVar.forumName = this.bMu;
        if (bw.aaB().hU(1) != null && this.bXQ == 1) {
            this.bXN.setCategoryId(i2);
        }
        this.bXR = i2;
        this.bXT = clVar;
        b(i, i2, clVar);
        ip(5);
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(ce ceVar) {
        this.bXX = ceVar;
        this.bXW.a(this.bYd);
    }

    private void ip(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.bXT != null) {
                    this.bXT.pn++;
                    break;
                }
                break;
            case 2:
                if (this.bXT != null) {
                    cl clVar = this.bXT;
                    clVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.bXT != null) {
                    this.bXT.pn = -1;
                    break;
                }
                break;
        }
        if (this.bXQ == 1) {
            if (this.bXS == this.bXR) {
                ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
                if (this.bWa != null) {
                    arrayList.addAll(this.bWa);
                }
                this.bME.ax(arrayList);
                if (this.bXX != null) {
                    this.bXX.a(this.bXQ, this.bXR, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.bXS = this.bXR;
            return;
        }
        cd hV = this.bXW.hV(this.bXQ);
        if (hV != null) {
            this.bXU = true;
            hV.a(this.bXQ, this.bXR, this.bXT);
            return;
        }
        if (this.bME != null && this.bME.getThreadList() != null) {
            this.bME.getThreadList().clear();
        }
        this.bXX.a(this.bXQ, this.bXR, null, null);
    }

    public boolean hasMore() {
        if ((this.bXT instanceof co) && ((co) this.bXT).errCode == 0) {
            return ((co) this.bXT).hasMore;
        }
        return true;
    }

    private int al(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, cl clVar) {
        this.bXV.put(al(i, i2), clVar);
    }

    public cl am(int i, int i2) {
        return this.bXV.get(al(i, i2));
    }

    @Override // com.baidu.tieba.frs.cd
    public void init() {
        this.bXW.init();
    }

    @Override // com.baidu.tieba.frs.cd
    public void Np() {
        this.bXW.destory();
        this.bXW.clear();
    }

    public int acL() {
        return this.bXQ;
    }

    public boolean acM() {
        return 1 == this.bXQ;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(am amVar) {
        if (amVar != null && !StringUtils.isNull(amVar.getId()) && this.bWa != null) {
            if (this.bXQ == 1) {
                this.bME.a(amVar);
            }
            int acN = acN();
            if (this.bWa != null && this.bWa.size() > 0) {
                int size = this.bWa.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.v vVar = this.bWa.get(i);
                    if ((vVar instanceof bi) && amVar.getId().equals(((bi) vVar).getId())) {
                        return;
                    }
                }
            }
            if (amVar.getThreadType() == 33) {
                com.baidu.tbadk.core.data.av avVar = new com.baidu.tbadk.core.data.av();
                avVar.a(amVar, -1);
                avVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.bWa.add(acN, avVar);
                    return;
                }
                return;
            }
            this.bWa.add(acN, amVar);
        }
    }

    public int acN() {
        if (this.bWa == null || this.bWa.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.bWa.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next instanceof bi) {
                if (((bi) next).sk() != 0) {
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

    public boolean acO() {
        return this.bXU;
    }

    public void acP() {
        bg bgVar = new bg();
        if (this.bXS == 0) {
            bgVar.hT(this.bYa);
        }
        if (this.bME.getThreadList() != null) {
            this.bME.getThreadList().clear();
            this.bME.getThreadList().add(bgVar);
        }
        if (this.bWa != null) {
            this.bWa.clear();
            this.bWa.add(bgVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> acQ() {
        return this.bWa;
    }

    public void iq(int i) {
        this.bYa = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.s.bjk();
        } else {
            com.baidu.tieba.tbadkCore.util.s.bjl();
        }
    }

    public int acR() {
        return this.bYa;
    }

    public int acS() {
        return com.baidu.tieba.frs.f.r.iC(this.bYa);
    }

    public boolean acT() {
        return this.bXP;
    }

    public boolean acU() {
        return this.bYa == 5;
    }

    public boolean acV() {
        return this.bXN != null && this.bXN.getLoadType() == 1;
    }

    public boolean acW() {
        return this.bYa == 7;
    }

    private int b(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.bST.YO() != null) {
            return this.bST.YO().a(this.bYa, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bi.Yh.get()) {
            int pe = com.baidu.tieba.recapp.v.aZP().aZM().pe(str);
            int pf = com.baidu.tieba.recapp.v.aZP().aZM().pf(str);
            if (frsRequestData.getLoadType() == 1) {
                pe++;
            } else {
                pf++;
            }
            frsRequestData.rF(pe);
            frsRequestData.rE(pf);
        }
    }

    public void acX() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.bME != null && this.bME.aJw() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.bME.aJw().getId(), 0L));
        }
        this.bST.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void iO(String str) {
        com.baidu.tbadk.util.t.a(new j(this, str), null);
    }

    public void iP(String str) {
        com.baidu.tbadk.util.t.a(new k(this, str), null);
    }
}
