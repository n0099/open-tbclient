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
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
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
import com.baidu.tieba.frs.f.u;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FrsModelController extends BdBaseModel<FrsActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.l>, cb {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long aAY;
    private String aci;
    private com.baidu.tieba.tbadkCore.n bFG;
    private String bFw;
    private final FrsActivity bLZ;
    private ArrayList<v> bPe;
    private FrsNetModel<FrsActivity> bPf;
    private d.a bPh;
    private String bPi;
    private boolean bPl;
    private FrsRequestData bSg;
    private final com.baidu.tieba.tbadkCore.p bSh;
    private boolean bSi;
    private int bSj;
    private int bSk;
    private int bSl;
    private cj bSm;
    private boolean bSn;
    private SparseArray<cj> bSo;
    private bw bSp;
    private cc bSq;
    private ArrayList<v> bSr;
    private String bSs;
    private int bSt;
    private final SparseArray<Boolean> bSu;
    private cc bSv;
    private long bym;
    private long byn;
    private long byo;
    private long byp;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean ir(int i) {
        return this.bSu.get(i, false).booleanValue();
    }

    public void o(int i, boolean z) {
        this.bSu.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.p pVar) {
        super(frsActivity.getPageContext());
        this.bFw = null;
        this.mType = 3;
        this.mPn = 1;
        this.aci = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.bPi = null;
        this.bSj = 1;
        this.bSk = 0;
        this.bSl = 0;
        this.bSn = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.bSo = new SparseArray<>();
        this.aAY = 0L;
        this.bPl = false;
        this.bSt = -1;
        this.bSu = new SparseArray<>();
        this.bSv = new i(this);
        this.bym = 0L;
        this.byn = 0L;
        this.byo = 0L;
        this.byp = 0L;
        if (frsActivity == null || pVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.bLZ = frsActivity;
        this.bSh = pVar;
        D(frsActivity);
    }

    private void D(FrsActivity frsActivity) {
        this.bSp = new bw();
        this.bSp.aUC = frsActivity.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.bSp));
        this.bSp.a(this.bSv);
    }

    public void onActivityDestroy() {
        this.bPf.cancelLoadData();
    }

    public void d(Bundle bundle) {
        if (bundle != null) {
            this.bFw = bundle.getString("name");
            this.aci = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.bSs = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.bSi = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.bFw)) {
            this.bFw = "";
        }
        if (TextUtils.isEmpty(this.aci)) {
            this.aci = "";
        }
        if (TextUtils.isEmpty(this.bSs)) {
            this.bSs = "";
        }
        this.mSource = this.aci;
        this.bSg = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            it(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            it(6);
        } else {
            com.baidu.tieba.frs.smartsort.h iY = com.baidu.tieba.frs.smartsort.e.act().iY(this.bFw);
            if (iY != null) {
                it(iY.bSY);
            } else {
                it(-1);
            }
        }
        this.bSg.setSortType(acb());
        if (this.bSt == 5) {
            this.bSg.setIsGood(1);
        } else {
            this.bSg.setIsGood(0);
        }
        this.bFG = new com.baidu.tieba.tbadkCore.n();
        this.bPf = new FrsNetModel<>(this.bLZ.getPageContext(), this.bSg);
        this.bPf.a(this);
        this.bPf.setUniqueId(getUniqueId());
        if (this.bFw != null && this.bFw.length() > 0) {
            if (this.aci == null || this.aci.length() <= 0) {
                this.aci = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.bFw);
        bundle.putString("from", this.aci);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean SQ() {
        if (this.bSj != 1) {
            is(1);
            return true;
        } else if (this.bPf.wq()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.bLZ.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.bSg), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(acb());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void p(int i, boolean z) {
        if (this.bFG != null && this.bFG.bgd() != null) {
            this.bFG.bgd().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.bSg), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bSj = b(this.bSj, frsRequestData);
        if (this.bSj == 1) {
            if (!this.bPf.wq()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.bSm == null) {
            this.bSm = new cj();
            this.bSm.pn = 1;
            this.bSm.forumName = this.bFw;
            if (this.bFG != null && this.bFG.aJY() != null) {
                this.bSm.forumId = this.bFG.aJY().getId();
            }
        }
        is(i);
    }

    public void in(int i) {
        if (this.bSj != 1) {
            is(4);
        } else if (!this.bPf.wq()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.bSg), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(acb());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.bSh.hO(i);
        this.bPf.a(frsRequestData);
        this.mType = i;
        frsRequestData.setKw(this.bFw);
        if (com.baidu.tbadk.core.l.oC().oI()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int I = com.baidu.adp.lib.util.k.I(this.bLZ.getPageContext().getPageActivity());
        int J = com.baidu.adp.lib.util.k.J(this.bLZ.getPageContext().getPageActivity());
        float K = com.baidu.adp.lib.util.k.K(this.bLZ.getPageContext().getPageActivity());
        int i2 = au.vg().vi() ? 2 : 1;
        frsRequestData.setScrW(I);
        frsRequestData.setScrH(J);
        frsRequestData.setScrDip(K);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.bPi);
        frsRequestData.setYuelaouLocate(this.bSs);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(com.baidu.tbadk.util.r.Gu(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsActivity.bFI != 0) {
            frsRequestData.setCtime((int) FrsActivity.bFI);
        }
        if (FrsActivity.bFJ != 0) {
            frsRequestData.setDataSize((int) FrsActivity.bFJ);
        }
        if (FrsActivity.bFK != 0) {
            frsRequestData.setNetError(FrsActivity.bFK);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.smartsort.d.c(i, frsRequestData);
        a(this.bFw, frsRequestData);
        com.baidu.tieba.frs.utils.r.a(this.bSt, frsRequestData);
        if (!ir(this.bSt)) {
            new a(this, true, com.baidu.tieba.tbadkCore.c.bfG().e(this.bFw, frsRequestData.acb(), frsRequestData.getIsGood(), this.bSg.getCategoryId())).execute(new Object[0]);
        }
        abg();
    }

    protected boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.l lVar) {
        if (this.isNetFirstLoad) {
            this.bSj = lVar.bgh();
        }
        this.bFG.d(lVar);
        e(this.bFG);
        this.bPe = new ArrayList<>();
        if (frsRequestData != null) {
            this.bSg = frsRequestData;
            this.mPn = this.bSg.getPn();
            this.bFw = this.bSg.getKw();
            this.bLZ.setForumName(this.bFw);
            this.bLZ.setFrom(this.aci);
            this.bLZ.setPn(this.mPn);
            this.bLZ.setFlag(this.mFlag);
        }
        if (this.bFG.getThreadList() != null) {
            this.bPe.addAll(this.bFG.getThreadList());
        }
        if (this.bSj != 1 && this.isNetFirstLoad) {
            this.bSh.a(7, false, this.bPh);
        } else {
            this.bSh.a(this.mType, false, this.bPh);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.d.b(this.bSg)) {
            acg();
        }
        this.isNetFirstLoad = false;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        d.a aVar = new d.a();
        aVar.fmJ = com.baidu.adp.lib.util.i.gk() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.fmK = mvcSocketResponsedMessage.getDownSize();
        this.bPh = aVar;
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
        this.bLZ.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData;
        FrsRequestData frsRequestData2 = null;
        if (!this.bPl) {
            this.bPl = true;
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
        aVar.fmJ = com.baidu.adp.lib.util.i.gk() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.fmK = mvcHttpResponsedMessage.getDownSize();
        this.bPh = aVar;
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
        this.bLZ.a(errorData);
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
        if (!this.bPl) {
            this.bPl = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void XT() {
        if (this.bFG != null && this.bFG.aJY() != null && this.bFG.aJY().getBannerListData() != null) {
            String lastIds = this.bFG.aJY().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.bPi = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.FO().FP()) {
            this.aAY = System.currentTimeMillis() - this.bLZ.QG;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v(i, z, responsedMessage, this.bLZ.aAP, this.bLZ.createTime, this.bLZ.aAX, false, this.aAY);
            this.bLZ.createTime = 0L;
            this.bLZ.aAP = 0L;
            if (vVar != null) {
                vVar.FJ();
            }
        }
    }

    public String abQ() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.bFw;
    }

    public com.baidu.tieba.tbadkCore.n abf() {
        return this.bFG;
    }

    public d.a abR() {
        return this.bPh;
    }

    private void abg() {
        this.bym = System.currentTimeMillis();
        this.bPf.EH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.l lVar) {
        this.isCacheFirstLoad = false;
        this.bFG.d(lVar);
        e(this.bFG);
        this.bPe = new ArrayList<>();
        if (this.bFG.getThreadList() != null) {
            this.bPe.addAll(this.bFG.getThreadList());
        }
        this.bSh.b(lVar);
    }

    private void e(com.baidu.tieba.tbadkCore.n nVar) {
        if (u.k(nVar)) {
            this.mPageType = "book_page";
        } else if (u.l(nVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.l, Void> {
        private String aLI;
        private FrsModelController bSx;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.aLI = null;
            this.aLI = str;
            this.bSx = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bfG().ql(this.aLI)) {
                if (!com.baidu.tieba.tbadkCore.c.bfG().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.aLI)) {
                    com.baidu.tieba.tbadkCore.c.bfG().getResponseData().aJY().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.l responseData = com.baidu.tieba.tbadkCore.c.bfG().getResponseData();
                if (responseData.bgj() != null && !StringUtils.isNull(responseData.bgj().getBookId(), true) && !responseData.bgj().getBookId().equals("0") && responseData.bgj().pu() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bgj().getBookId(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
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
            if (this.bSx != null && lVarArr != null) {
                this.bSx.c(lVarArr.length > 0 ? lVarArr[0] : null);
                this.bSx.o(this.bSx.bSt, true);
            }
        }
    }

    public long UK() {
        return this.byp;
    }

    public long UL() {
        return this.byn;
    }

    public long UM() {
        return this.byo;
    }

    public long UN() {
        return this.bym;
    }

    public boolean wq() {
        return this.bPf.wq();
    }

    public int abS() {
        return this.bSl;
    }

    private void abT() {
        if (this.bSr == null) {
            this.bSr = new ArrayList<>();
        }
        if (this.bSr.size() == 0) {
            this.bSr.add(new br());
        }
    }

    @Override // com.baidu.tieba.frs.cb
    public void a(int i, int i2, cj cjVar) {
        this.bSj = b(i, null);
        if (cjVar == null && (cjVar = ai(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.k.gB() && this.bSq != null) {
                cm cmVar = new cm();
                cmVar.hasMore = false;
                cmVar.pn = 1;
                cmVar.forumName = this.bFw;
                cmVar.bJl = false;
                if (this.bFG != null && this.bFG.aJY() != null) {
                    cmVar.forumId = this.bFG.aJY().getId();
                }
                abT();
                this.bFG.ax(this.bSr);
                this.bSq.a(i, i2, cmVar, this.bSr);
            }
            cjVar = new cj();
            cjVar.pn = -1;
        }
        if (this.bFG != null && this.bFG.aJY() != null) {
            cjVar.forumId = this.bFG.aJY().getId();
        }
        cjVar.forumName = this.bFw;
        if (bu.Ze().hV(1) != null && this.bSj == 1) {
            this.bSg.setCategoryId(i2);
        }
        this.bSk = i2;
        this.bSm = cjVar;
        b(i, i2, cjVar);
        is(5);
    }

    @Override // com.baidu.tieba.frs.cb
    public void a(cc ccVar) {
        this.bSq = ccVar;
        this.bSp.a(this.bSv);
    }

    private void is(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.bSm != null) {
                    this.bSm.pn++;
                    break;
                }
                break;
            case 2:
                if (this.bSm != null) {
                    cj cjVar = this.bSm;
                    cjVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.bSm != null) {
                    this.bSm.pn = -1;
                    break;
                }
                break;
        }
        if (this.bSj == 1) {
            if (this.bSl == this.bSk) {
                ArrayList<v> arrayList = new ArrayList<>();
                if (this.bPe != null) {
                    arrayList.addAll(this.bPe);
                }
                this.bFG.ax(arrayList);
                if (this.bSq != null) {
                    this.bSq.a(this.bSj, this.bSk, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.bSl = this.bSk;
            return;
        }
        cb hW = this.bSp.hW(this.bSj);
        if (hW != null) {
            this.bSn = true;
            hW.a(this.bSj, this.bSk, this.bSm);
            return;
        }
        if (this.bFG != null && this.bFG.getThreadList() != null) {
            this.bFG.getThreadList().clear();
        }
        this.bSq.a(this.bSj, this.bSk, null, null);
    }

    public boolean hasMore() {
        if ((this.bSm instanceof cm) && ((cm) this.bSm).errCode == 0) {
            return ((cm) this.bSm).hasMore;
        }
        return true;
    }

    private int ah(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, cj cjVar) {
        this.bSo.put(ah(i, i2), cjVar);
    }

    public cj ai(int i, int i2) {
        return this.bSo.get(ah(i, i2));
    }

    @Override // com.baidu.tieba.frs.cb
    public void init() {
        this.bSp.init();
    }

    @Override // com.baidu.tieba.frs.cb
    public void Me() {
        this.bSp.destory();
        this.bSp.clear();
    }

    public int abU() {
        return this.bSj;
    }

    public boolean abV() {
        return 1 == this.bSj || 2 == this.bSj;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(al alVar) {
        if (alVar != null && !StringUtils.isNull(alVar.getId()) && this.bPe != null) {
            if (this.bSj == 1) {
                this.bFG.a(alVar);
            }
            int abW = abW();
            if (this.bPe != null && this.bPe.size() > 0) {
                int size = this.bPe.size();
                for (int i = 0; i < size; i++) {
                    v vVar = this.bPe.get(i);
                    if ((vVar instanceof bh) && alVar.getId().equals(((bh) vVar).getId())) {
                        return;
                    }
                }
            }
            if (alVar.getThreadType() == 33) {
                com.baidu.tbadk.core.data.au auVar = new com.baidu.tbadk.core.data.au();
                auVar.a(alVar, -1);
                auVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.bPe.add(abW, auVar);
                    return;
                }
                return;
            }
            this.bPe.add(abW, alVar);
        }
    }

    public int abW() {
        if (this.bPe == null || this.bPe.size() <= 0) {
            return 0;
        }
        Iterator<v> it = this.bPe.iterator();
        int i = 0;
        while (it.hasNext()) {
            v next = it.next();
            if (next instanceof bh) {
                if (((bh) next).rs() != 0) {
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

    public boolean abX() {
        return this.bSn;
    }

    public void abY() {
        be beVar = new be();
        if (this.bSl == 0) {
            beVar.hU(this.bSt);
        }
        if (this.bFG.getThreadList() != null) {
            this.bFG.getThreadList().clear();
            this.bFG.getThreadList().add(beVar);
        }
        if (this.bPe != null) {
            this.bPe.clear();
            this.bPe.add(beVar);
        }
    }

    public ArrayList<v> abZ() {
        return this.bPe;
    }

    public void it(int i) {
        this.bSt = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.s.biJ();
        } else {
            com.baidu.tieba.tbadkCore.util.s.biK();
        }
    }

    public int aca() {
        return this.bSt;
    }

    public int acb() {
        return com.baidu.tieba.frs.utils.r.iF(this.bSt);
    }

    public boolean acc() {
        return this.bSi;
    }

    public boolean acd() {
        return this.bSt == 5;
    }

    public boolean ace() {
        return this.bSg != null && this.bSg.getLoadType() == 1;
    }

    public boolean acf() {
        return this.bSt == 7;
    }

    private int b(int i, FrsRequestData frsRequestData) {
        if ((i == 1 || i == 2) && this.bLZ.Xs() != null) {
            return this.bLZ.Xs().a(this.bSt, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bh.SE.get()) {
            int pP = com.baidu.tieba.recapp.p.aZV().aZU().pP(str);
            int pQ = com.baidu.tieba.recapp.p.aZV().aZU().pQ(str);
            if (frsRequestData.getLoadType() == 1) {
                pP++;
            } else {
                pQ++;
            }
            frsRequestData.rI(pP);
            frsRequestData.rH(pQ);
        }
    }

    public void acg() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.bFG != null && this.bFG.aJY() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.bFG.aJY().getId(), 0L));
        }
        this.bLZ.sendMessage(requestIncrForumAccessCountNetMessage);
    }
}
