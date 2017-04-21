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
    private long aGH;
    private String ahN;
    private long bHC;
    private long bHD;
    private long bHE;
    private long bHF;
    private String bOL;
    private com.baidu.tieba.tbadkCore.n bOV;
    private final FrsActivity bVk;
    private ArrayList<com.baidu.adp.widget.ListView.v> bYr;
    private FrsNetModel<FrsActivity> bYs;
    private d.a bYu;
    private String bYv;
    private boolean bYy;
    private int bxh;
    private FrsRequestData cae;
    private final com.baidu.tieba.tbadkCore.p caf;
    private boolean cag;
    private int cah;
    private int cai;
    private int caj;
    private cl cak;
    private boolean cal;
    private SparseArray<cl> cam;
    private by can;
    private ce cao;
    private ArrayList<com.baidu.adp.widget.ListView.v> cap;
    private String caq;
    private int car;
    private String cas;
    private final SparseArray<Boolean> cat;
    private ce cau;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mPageType;
    private String mSource;
    private int mType;

    public boolean iu(int i) {
        return this.cat.get(i, false).booleanValue();
    }

    public void o(int i, boolean z) {
        this.cat.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.p pVar) {
        super(frsActivity.getPageContext());
        this.bOL = null;
        this.mType = 3;
        this.bxh = 1;
        this.ahN = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.bYv = null;
        this.cah = 1;
        this.cai = 0;
        this.caj = 0;
        this.cal = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.cam = new SparseArray<>();
        this.aGH = 0L;
        this.bYy = false;
        this.car = -1;
        this.cas = null;
        this.cat = new SparseArray<>();
        this.cau = new i(this);
        this.bHC = 0L;
        this.bHD = 0L;
        this.bHE = 0L;
        this.bHF = 0L;
        if (frsActivity == null || pVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.bVk = frsActivity;
        this.caf = pVar;
        D(frsActivity);
    }

    private void D(FrsActivity frsActivity) {
        this.can = new by();
        this.can.bbE = frsActivity.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.can));
        this.can.a(this.cau);
    }

    public void onActivityDestroy() {
        this.bYs.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.bOL = bundle.getString("name");
            this.ahN = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.caq = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.cag = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.bOL)) {
            this.bOL = "";
        }
        if (TextUtils.isEmpty(this.ahN)) {
            this.ahN = "";
        }
        if (TextUtils.isEmpty(this.caq)) {
            this.caq = "";
        }
        this.mSource = this.ahN;
        this.cae = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            iw(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            iw(6);
        } else {
            com.baidu.tieba.frs.smartsort.h iV = com.baidu.tieba.frs.smartsort.e.aem().iV(this.bOL);
            if (iV != null) {
                iw(iV.cbc);
            } else {
                iw(-1);
            }
        }
        this.cae.setSortType(adT());
        if (this.car == 5) {
            this.cae.setIsGood(1);
        } else {
            this.cae.setIsGood(0);
        }
        this.bOV = new com.baidu.tieba.tbadkCore.n();
        this.bYs = new FrsNetModel<>(this.bVk.getPageContext(), this.cae);
        this.bYs.a(this);
        this.bYs.setUniqueId(getUniqueId());
        if (this.bOL != null && this.bOL.length() > 0) {
            if (this.ahN == null || this.ahN.length() <= 0) {
                this.ahN = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.bOL);
        bundle.putString("from", this.ahN);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean Vq() {
        if (this.cah != 1) {
            iv(1);
            return true;
        } else if (this.bYs.xj()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.bVk.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cae), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(adT());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void p(int i, boolean z) {
        if (this.bOV != null && this.bOV.bhF() != null) {
            this.bOV.bhF().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cae), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.cah = b(this.cah, frsRequestData);
        if (this.cah == 1) {
            if (!this.bYs.xj()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.cak == null) {
            this.cak = new cl();
            this.cak.pn = 1;
            this.cak.forumName = this.bOL;
            if (this.bOV != null && this.bOV.aKx() != null) {
                this.cak.forumId = this.bOV.aKx().getId();
            }
        }
        iv(i);
    }

    public void is(int i) {
        if (this.cah != 1) {
            iv(4);
        } else if (!this.bYs.xj()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cae), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(adT());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.caf.hT(i);
        this.bYs.a(frsRequestData);
        this.mType = i;
        frsRequestData.setKw(this.bOL);
        if (com.baidu.tbadk.core.q.po().pu()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int af = com.baidu.adp.lib.util.k.af(this.bVk.getPageContext().getPageActivity());
        int ag = com.baidu.adp.lib.util.k.ag(this.bVk.getPageContext().getPageActivity());
        float ah = com.baidu.adp.lib.util.k.ah(this.bVk.getPageContext().getPageActivity());
        int i2 = av.wa().wc() ? 2 : 1;
        frsRequestData.setScrW(af);
        frsRequestData.setScrH(ag);
        frsRequestData.setScrDip(ah);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.bYv);
        frsRequestData.setYuelaouLocate(this.caq);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(com.baidu.tbadk.util.r.Hs(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsActivity.bOX != 0) {
            frsRequestData.setCtime((int) FrsActivity.bOX);
        }
        if (FrsActivity.bOY != 0) {
            frsRequestData.setDataSize((int) FrsActivity.bOY);
        }
        if (FrsActivity.bOZ != 0) {
            frsRequestData.setNetError(FrsActivity.bOZ);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.smartsort.d.c(i, frsRequestData);
        a(this.bOL, frsRequestData);
        com.baidu.tieba.frs.f.r.a(this.car, frsRequestData);
        if (!iu(this.car)) {
            String g = com.baidu.tieba.tbadkCore.c.bhj().g(this.bOL, frsRequestData.adT(), frsRequestData.getIsGood(), this.cae.getCategoryId());
            this.cas = g;
            new a(this, true, g).execute(new Object[0]);
        }
        adA();
    }

    protected boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.l lVar) {
        if (this.isNetFirstLoad) {
            this.cah = lVar.bhJ();
        }
        this.bOV.d(lVar);
        e(this.bOV);
        this.bYr = new ArrayList<>();
        if (frsRequestData != null) {
            this.cae = frsRequestData;
            this.bxh = this.cae.getPn();
            this.bOL = this.cae.getKw();
            this.bVk.setForumName(this.bOL);
            this.bVk.setFrom(this.ahN);
            this.bVk.setPn(this.bxh);
            this.bVk.setFlag(this.mFlag);
        }
        if (this.bOV.getThreadList() != null) {
            this.bYr.addAll(this.bOV.getThreadList());
        }
        if (this.cah != 1 && this.isNetFirstLoad) {
            this.caf.a(7, false, this.bYu);
        } else {
            this.caf.a(this.mType, false, this.bYu);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.d.b(this.cae)) {
            adY();
        }
        this.isNetFirstLoad = false;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        d.a aVar = new d.a();
        aVar.fvj = com.baidu.adp.lib.util.i.hk() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.fvk = mvcSocketResponsedMessage.getDownSize();
        this.bYu = aVar;
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
        this.bVk.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData;
        FrsRequestData frsRequestData2 = null;
        if (!this.bYy) {
            this.bYy = true;
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
        aVar.fvj = com.baidu.adp.lib.util.i.hk() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.fvk = mvcHttpResponsedMessage.getDownSize();
        this.bYu = aVar;
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
        this.bVk.a(errorData);
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
        if (!this.bYy) {
            this.bYy = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void aap() {
        if (this.bOV != null && this.bOV.aKx() != null && this.bOV.aKx().getBannerListData() != null) {
            String lastIds = this.bOV.aKx().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.bYv = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.GG().GH()) {
            this.aGH = System.currentTimeMillis() - this.bVk.Wk;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v(i, z, responsedMessage, this.bVk.aGy, this.bVk.createTime, this.bVk.aGG, false, this.aGH);
            this.bVk.createTime = 0L;
            this.bVk.aGy = 0L;
            if (vVar != null) {
                vVar.GB();
            }
        }
    }

    public String adI() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.bOL;
    }

    public com.baidu.tieba.tbadkCore.n adz() {
        return this.bOV;
    }

    public d.a adJ() {
        return this.bYu;
    }

    private void adA() {
        this.bHC = System.currentTimeMillis();
        this.bYs.FC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.l lVar) {
        this.isCacheFirstLoad = false;
        this.bOV.d(lVar);
        e(this.bOV);
        this.bYr = new ArrayList<>();
        if (this.bOV.getThreadList() != null) {
            this.bYr.addAll(this.bOV.getThreadList());
        }
        this.caf.b(lVar);
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
        private String aRL;
        private FrsModelController cay;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.aRL = null;
            this.aRL = str;
            this.cay = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bhj().pM(this.aRL)) {
                if (!com.baidu.tieba.tbadkCore.c.bhj().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.aRL)) {
                    com.baidu.tieba.tbadkCore.c.bhj().getResponseData().aKx().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.l responseData = com.baidu.tieba.tbadkCore.c.bhj().getResponseData();
                if (responseData.bhL() != null && !StringUtils.isNull(responseData.bhL().getBookId(), true) && !responseData.bhL().getBookId().equals("0") && responseData.bhL().qk() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bhL().getBookId(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
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
            if (this.cay != null && lVarArr != null) {
                this.cay.c(lVarArr.length > 0 ? lVarArr[0] : null);
                this.cay.o(this.cay.car, true);
            }
        }
    }

    public long Xh() {
        return this.bHF;
    }

    public long Xi() {
        return this.bHD;
    }

    public long Xj() {
        return this.bHE;
    }

    public long Xk() {
        return this.bHC;
    }

    public boolean xj() {
        return this.bYs.xj();
    }

    public int adK() {
        return this.caj;
    }

    private void adL() {
        if (this.cap == null) {
            this.cap = new ArrayList<>();
        }
        if (this.cap.size() == 0) {
            this.cap.add(new bt());
        }
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(int i, int i2, cl clVar) {
        this.cah = b(i, null);
        if (clVar == null && (clVar = am(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.k.hB() && this.cao != null) {
                co coVar = new co();
                coVar.hasMore = false;
                coVar.pn = 1;
                coVar.forumName = this.bOL;
                coVar.bSA = false;
                if (this.bOV != null && this.bOV.aKx() != null) {
                    coVar.forumId = this.bOV.aKx().getId();
                }
                adL();
                this.bOV.ax(this.cap);
                this.cao.a(i, i2, coVar, this.cap);
            }
            clVar = new cl();
            clVar.pn = -1;
        }
        if (this.bOV != null && this.bOV.aKx() != null) {
            clVar.forumId = this.bOV.aKx().getId();
        }
        clVar.forumName = this.bOL;
        if (bw.abC().ia(1) != null && this.cah == 1) {
            this.cae.setCategoryId(i2);
        }
        this.cai = i2;
        this.cak = clVar;
        b(i, i2, clVar);
        iv(5);
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(ce ceVar) {
        this.cao = ceVar;
        this.can.a(this.cau);
    }

    private void iv(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.cak != null) {
                    this.cak.pn++;
                    break;
                }
                break;
            case 2:
                if (this.cak != null) {
                    cl clVar = this.cak;
                    clVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.cak != null) {
                    this.cak.pn = -1;
                    break;
                }
                break;
        }
        if (this.cah == 1) {
            if (this.caj == this.cai) {
                ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
                if (this.bYr != null) {
                    arrayList.addAll(this.bYr);
                }
                this.bOV.ax(arrayList);
                if (this.cao != null) {
                    this.cao.a(this.cah, this.cai, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.caj = this.cai;
            return;
        }
        cd ib = this.can.ib(this.cah);
        if (ib != null) {
            this.cal = true;
            ib.a(this.cah, this.cai, this.cak);
            return;
        }
        if (this.bOV != null && this.bOV.getThreadList() != null) {
            this.bOV.getThreadList().clear();
        }
        this.cao.a(this.cah, this.cai, null, null);
    }

    public boolean hasMore() {
        if ((this.cak instanceof co) && ((co) this.cak).errCode == 0) {
            return ((co) this.cak).hasMore;
        }
        return true;
    }

    private int al(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, cl clVar) {
        this.cam.put(al(i, i2), clVar);
    }

    public cl am(int i, int i2) {
        return this.cam.get(al(i, i2));
    }

    @Override // com.baidu.tieba.frs.cd
    public void init() {
        this.can.init();
    }

    @Override // com.baidu.tieba.frs.cd
    public void Nx() {
        this.can.destory();
        this.can.clear();
    }

    public int adM() {
        return this.cah;
    }

    public boolean adN() {
        return 1 == this.cah;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(am amVar) {
        if (amVar != null && !StringUtils.isNull(amVar.getId()) && this.bYr != null) {
            if (this.cah == 1) {
                this.bOV.a(amVar);
            }
            int adO = adO();
            if (this.bYr != null && this.bYr.size() > 0) {
                int size = this.bYr.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.v vVar = this.bYr.get(i);
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
                    this.bYr.add(adO, avVar);
                    return;
                }
                return;
            }
            this.bYr.add(adO, amVar);
        }
    }

    public int adO() {
        if (this.bYr == null || this.bYr.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.bYr.iterator();
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

    public boolean adP() {
        return this.cal;
    }

    public void adQ() {
        bg bgVar = new bg();
        if (this.caj == 0) {
            bgVar.hZ(this.car);
        }
        if (this.bOV.getThreadList() != null) {
            this.bOV.getThreadList().clear();
            this.bOV.getThreadList().add(bgVar);
        }
        if (this.bYr != null) {
            this.bYr.clear();
            this.bYr.add(bgVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> adR() {
        return this.bYr;
    }

    public void iw(int i) {
        this.car = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.s.bkl();
        } else {
            com.baidu.tieba.tbadkCore.util.s.bkm();
        }
    }

    public int adS() {
        return this.car;
    }

    public int adT() {
        return com.baidu.tieba.frs.f.r.iI(this.car);
    }

    public boolean adU() {
        return this.cag;
    }

    public boolean adV() {
        return this.car == 5;
    }

    public boolean adW() {
        return this.cae != null && this.cae.getLoadType() == 1;
    }

    public boolean adX() {
        return this.car == 7;
    }

    private int b(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.bVk.ZP() != null) {
            return this.bVk.ZP().a(this.car, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bi.Yi.get()) {
            int pf = com.baidu.tieba.recapp.v.baQ().baN().pf(str);
            int pg = com.baidu.tieba.recapp.v.baQ().baN().pg(str);
            if (frsRequestData.getLoadType() == 1) {
                pf++;
            } else {
                pg++;
            }
            frsRequestData.rL(pf);
            frsRequestData.rK(pg);
        }
    }

    public void adY() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.bOV != null && this.bOV.aKx() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.bOV.aKx().getId(), 0L));
        }
        this.bVk.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void iP(String str) {
        com.baidu.tbadk.util.t.a(new j(this, str), null);
    }

    public void iQ(String str) {
        com.baidu.tbadk.util.t.a(new k(this, str), null);
    }
}
