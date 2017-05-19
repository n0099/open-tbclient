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
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.bk;
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
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.bm;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.frs.br;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.frs.by;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.cg;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.l>, bx {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long aGL;
    private String ahf;
    private long bHn;
    private long bHo;
    private long bHp;
    private long bHq;
    private final com.baidu.tieba.frs.r bNK;
    private com.baidu.tieba.tbadkCore.n bNT;
    private String bOf;
    private ArrayList<com.baidu.adp.widget.ListView.v> bWr;
    private FrsNetModel<com.baidu.tieba.frs.r> bWs;
    private d.a bWu;
    private String bWv;
    private boolean bWy;
    private FrsRequestData bXU;
    private final com.baidu.tieba.tbadkCore.p bXV;
    private boolean bXW;
    private int bXX;
    private int bXY;
    private int bXZ;
    private cd bYa;
    private boolean bYb;
    private SparseArray<cd> bYc;
    private br bYd;
    private by bYe;
    private ArrayList<com.baidu.adp.widget.ListView.v> bYf;
    private String bYg;
    private int bYh;
    private int bYi;
    private boolean bYj;
    private String bYk;
    private final SparseArray<Boolean> bYl;
    private by bYm;
    private int bxg;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mPageType;
    private String mSource;
    private int mType;

    public boolean ik(int i) {
        return this.bYl.get(i, false).booleanValue();
    }

    public void n(int i, boolean z) {
        this.bYl.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.r rVar, com.baidu.tieba.tbadkCore.p pVar) {
        super(rVar.getPageContext());
        this.bOf = null;
        this.mType = 3;
        this.bxg = 1;
        this.ahf = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.bWv = null;
        this.bXX = 1;
        this.bXY = 0;
        this.bXZ = 0;
        this.bYb = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.bYc = new SparseArray<>();
        this.aGL = 0L;
        this.bWy = false;
        this.bYh = -1;
        this.bYi = -1;
        this.bYk = null;
        this.bYl = new SparseArray<>();
        this.bYm = new i(this);
        this.bHn = 0L;
        this.bHo = 0L;
        this.bHp = 0L;
        this.bHq = 0L;
        if (rVar == null || pVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.bNK = rVar;
        this.bXV = pVar;
        x(this.bNK);
    }

    private void x(com.baidu.tieba.frs.r rVar) {
        this.bYd = new br();
        this.bYd.aLk = rVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.bYd));
        this.bYd.a(this.bYm);
    }

    public void onActivityDestroy() {
        this.bWs.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.bOf = bundle.getString("name");
            this.ahf = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.bYg = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.bXW = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.bOf)) {
            this.bOf = "";
        }
        if (TextUtils.isEmpty(this.ahf)) {
            this.ahf = "";
        }
        if (TextUtils.isEmpty(this.bYg)) {
            this.bYg = "";
        }
        this.mSource = this.ahf;
        this.bXU = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            im(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            im(6);
        } else {
            com.baidu.tieba.frs.smartsort.h jc = com.baidu.tieba.frs.smartsort.e.aco().jc(this.bOf);
            if (jc != null) {
                im(jc.bYQ);
            } else {
                im(-1);
            }
        }
        this.bXU.setSortType(abX());
        if (this.bYh == 5) {
            this.bXU.setIsGood(1);
        } else {
            this.bXU.setIsGood(0);
        }
        this.bNT = new com.baidu.tieba.tbadkCore.n();
        this.bWs = new FrsNetModel<>(this.bNK.getPageContext(), this.bXU);
        this.bWs.a(this);
        this.bWs.setUniqueId(this.bNK.getUniqueId());
        if (this.bOf != null && this.bOf.length() > 0) {
            if (this.ahf == null || this.ahf.length() <= 0) {
                this.ahf = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.bOf);
        bundle.putString("from", this.ahf);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean UJ() {
        if (this.bXX != 1) {
            il(1);
            return true;
        } else if (this.bWs.wu()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.bNK.getActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.bXU), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(abX());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void o(int i, boolean z) {
        if (this.bNT != null && this.bNT.bfh() != null) {
            this.bNT.bfh().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.bXU), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bXX = b(this.bXX, frsRequestData);
        if (this.bXX == 1) {
            if (!this.bWs.wu()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.bYa == null) {
            this.bYa = new cd();
            this.bYa.pn = 1;
            this.bYa.forumName = this.bOf;
            if (this.bNT != null && this.bNT.aHE() != null) {
                this.bYa.forumId = this.bNT.aHE().getId();
            }
        }
        il(i);
    }

    public void ii(int i) {
        if (this.bXX != 1) {
            il(4);
        } else if (!this.bWs.wu()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.bXU), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(abX());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.bXV.hK(i);
        this.bWs.a(frsRequestData);
        this.mType = i;
        frsRequestData.pM(this.bNK.Zt() ? "1" : "2");
        if (this.bYj) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.d.n.iA(this.bYi)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.bYj = false;
        frsRequestData.setKw(this.bOf);
        if (com.baidu.tbadk.core.r.oV().pb()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int af = com.baidu.adp.lib.util.k.af(this.bNK.getActivity());
        int ag = com.baidu.adp.lib.util.k.ag(this.bNK.getActivity());
        float ah = com.baidu.adp.lib.util.k.ah(this.bNK.getActivity());
        int i2 = av.vo().vq() ? 2 : 1;
        frsRequestData.setScrW(af);
        frsRequestData.setScrH(ag);
        frsRequestData.setScrDip(ah);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.bWv);
        frsRequestData.setYuelaouLocate(this.bYg);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(com.baidu.tbadk.util.u.GD(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.r.bOo != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.r.bOo);
        }
        if (com.baidu.tieba.frs.r.bOp != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.r.bOp);
        }
        if (com.baidu.tieba.frs.r.bOq != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.r.bOq);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.smartsort.d.c(i, frsRequestData);
        a(this.bOf, frsRequestData);
        com.baidu.tieba.frs.d.n.a(this.bYh, frsRequestData);
        if (!ik(this.bYh)) {
            String g = com.baidu.tieba.tbadkCore.c.beL().g(this.bOf, frsRequestData.abX(), frsRequestData.getIsGood(), this.bXU.getCategoryId());
            this.bYk = g;
            new a(this, true, g).execute(new Object[0]);
        }
        abH();
    }

    protected boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar == null || lVar.aHE() == null || StringUtils.isNull(lVar.aHE().getName()) || lVar.aHE().getName().equals(this.bOf)) {
            if (this.isNetFirstLoad) {
                this.bXX = lVar.bfl();
            }
            this.bNT.d(lVar);
            d(this.bNT);
            this.bWr = new ArrayList<>();
            if (frsRequestData != null) {
                this.bXU = frsRequestData;
                this.bxg = this.bXU.getPn();
                this.bOf = this.bXU.getKw();
                this.bNK.setForumName(this.bOf);
                this.bNK.setFrom(this.ahf);
                this.bNK.setPn(this.bxg);
                this.bNK.setFlag(this.mFlag);
            }
            if (this.bNT.getThreadList() != null) {
                this.bWr.addAll(this.bNT.getThreadList());
            }
            if (this.bXX != 1 && this.isNetFirstLoad) {
                this.bXV.a(7, false, this.bWu);
            } else {
                this.bXV.a(this.mType, false, this.bWu);
            }
            this.mSource = null;
            if (com.baidu.tieba.frs.smartsort.d.b(this.bXU)) {
                acc();
            }
            this.isNetFirstLoad = false;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        d.a aVar = new d.a();
        aVar.frm = com.baidu.adp.lib.util.i.hk() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.frn = mvcSocketResponsedMessage.getDownSize();
        this.bWu = aVar;
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
        this.bNK.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData;
        FrsRequestData frsRequestData2 = null;
        if (!this.bWy) {
            this.bWy = true;
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
        aVar.frm = com.baidu.adp.lib.util.i.hk() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.frn = mvcHttpResponsedMessage.getDownSize();
        this.bWu = aVar;
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
        this.bNK.a(errorData);
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
        if (!this.bWy) {
            this.bWy = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void Zn() {
        if (this.bNT != null && this.bNT.aHE() != null && this.bNT.aHE().getBannerListData() != null) {
            String lastIds = this.bNT.aHE().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.bWv = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.FK().FL()) {
            this.aGL = System.currentTimeMillis() - this.bNK.VD;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v(i, z, responsedMessage, this.bNK.aGC, this.bNK.createTime, this.bNK.aGK, false, this.aGL);
            this.bNK.createTime = 0L;
            this.bNK.aGC = 0L;
            if (vVar != null) {
                vVar.FF();
            }
        }
    }

    public String abM() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.bOf;
    }

    public com.baidu.tieba.tbadkCore.n abG() {
        return this.bNT;
    }

    public d.a abN() {
        return this.bWu;
    }

    private void abH() {
        this.bHn = System.currentTimeMillis();
        this.bWs.EG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.l lVar) {
        this.isCacheFirstLoad = false;
        this.bNT.d(lVar);
        d(this.bNT);
        this.bWr = new ArrayList<>();
        if (this.bNT.getThreadList() != null) {
            this.bWr.addAll(this.bNT.getThreadList());
        }
        this.bXV.b(lVar);
    }

    private void d(com.baidu.tieba.tbadkCore.n nVar) {
        if (com.baidu.tieba.frs.e.u.h(nVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.e.u.i(nVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.l, Void> {
        private String aSg;
        private FrsModelController bYq;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.aSg = null;
            this.aSg = str;
            this.bYq = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.beL().pK(this.aSg)) {
                if (!com.baidu.tieba.tbadkCore.c.beL().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.aSg)) {
                    com.baidu.tieba.tbadkCore.c.beL().getResponseData().aHE().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.l responseData = com.baidu.tieba.tbadkCore.c.beL().getResponseData();
                if (responseData.bfn() != null && !StringUtils.isNull(responseData.bfn().getBookId(), true) && !responseData.bfn().getBookId().equals("0") && responseData.bfn().pN() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bfn().getBookId(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
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
            if (this.bYq != null && lVarArr != null) {
                this.bYq.c(lVarArr.length > 0 ? lVarArr[0] : null);
                this.bYq.n(this.bYq.bYh, true);
            }
        }
    }

    public long Wx() {
        return this.bHq;
    }

    public long Wy() {
        return this.bHo;
    }

    public long Wz() {
        return this.bHp;
    }

    public long WA() {
        return this.bHn;
    }

    public boolean wu() {
        return this.bWs.wu();
    }

    public int abO() {
        return this.bXZ;
    }

    private void abP() {
        if (this.bYf == null) {
            this.bYf = new ArrayList<>();
        }
        if (this.bYf.size() == 0) {
            this.bYf.add(new bm());
        }
    }

    @Override // com.baidu.tieba.frs.bx
    public void a(int i, int i2, cd cdVar) {
        this.bXX = b(i, null);
        if (cdVar == null && (cdVar = an(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.k.hB() && this.bYe != null) {
                cg cgVar = new cg();
                cgVar.hasMore = false;
                cgVar.pn = 1;
                cgVar.forumName = this.bOf;
                cgVar.bRk = false;
                if (this.bNT != null && this.bNT.aHE() != null) {
                    cgVar.forumId = this.bNT.aHE().getId();
                }
                abP();
                this.bNT.ay(this.bYf);
                this.bYe.a(i, i2, cgVar, this.bYf);
            }
            cdVar = new cd();
            cdVar.pn = -1;
        }
        if (this.bNT != null && this.bNT.aHE() != null) {
            cdVar.forumId = this.bNT.aHE().getId();
        }
        cdVar.forumName = this.bOf;
        if (bp.aab().hQ(1) != null && this.bXX == 1) {
            this.bXU.setCategoryId(i2);
        }
        this.bXY = i2;
        this.bYa = cdVar;
        b(i, i2, cdVar);
        il(5);
    }

    @Override // com.baidu.tieba.frs.bx
    public void a(by byVar) {
        this.bYe = byVar;
        this.bYd.a(this.bYm);
    }

    private void il(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.bYa != null) {
                    this.bYa.pn++;
                    break;
                }
                break;
            case 2:
                if (this.bYa != null) {
                    cd cdVar = this.bYa;
                    cdVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.bYa != null) {
                    this.bYa.pn = -1;
                    break;
                }
                break;
        }
        if (this.bXX == 1) {
            if (this.bXZ == this.bXY) {
                ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
                if (this.bWr != null) {
                    arrayList.addAll(this.bWr);
                }
                this.bNT.ay(arrayList);
                if (this.bYe != null) {
                    this.bYe.a(this.bXX, this.bXY, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.bXZ = this.bXY;
            return;
        }
        bx hR = this.bYd.hR(this.bXX);
        if (hR != null) {
            this.bYb = true;
            hR.a(this.bXX, this.bXY, this.bYa);
            return;
        }
        if (this.bNT != null && this.bNT.getThreadList() != null) {
            this.bNT.getThreadList().clear();
        }
        this.bYe.a(this.bXX, this.bXY, null, null);
    }

    public boolean hasMore() {
        if ((this.bYa instanceof cg) && ((cg) this.bYa).errCode == 0) {
            return ((cg) this.bYa).hasMore;
        }
        return true;
    }

    private int am(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, cd cdVar) {
        this.bYc.put(am(i, i2), cdVar);
    }

    public cd an(int i, int i2) {
        return this.bYc.get(am(i, i2));
    }

    @Override // com.baidu.tieba.frs.bx
    public void init() {
        this.bYd.init();
    }

    @Override // com.baidu.tieba.frs.bx
    public void ML() {
        this.bYd.destory();
        this.bYd.clear();
    }

    public int abQ() {
        return this.bXX;
    }

    public boolean abR() {
        return 1 == this.bXX;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(an anVar) {
        if (anVar != null && !StringUtils.isNull(anVar.getId()) && this.bWr != null) {
            if (this.bXX == 1) {
                this.bNT.a(anVar);
            }
            int abS = abS();
            if (this.bWr != null && this.bWr.size() > 0) {
                int size = this.bWr.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.v vVar = this.bWr.get(i);
                    if ((vVar instanceof bk) && anVar.getId().equals(((bk) vVar).getId())) {
                        return;
                    }
                }
            }
            if (anVar.getThreadType() == 33) {
                aw awVar = new aw();
                awVar.a(anVar, -1);
                awVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.bWr.add(abS, awVar);
                    return;
                }
                return;
            }
            this.bWr.add(abS, anVar);
        }
    }

    public int abS() {
        if (this.bWr == null || this.bWr.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.bWr.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next instanceof bk) {
                if (((bk) next).ru() != 0) {
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

    public boolean abT() {
        return this.bYb;
    }

    public void abU() {
        ba baVar = new ba();
        if (this.bXZ == 0) {
            baVar.hP(this.bYh);
        }
        if (this.bNT.getThreadList() != null) {
            this.bNT.getThreadList().clear();
            this.bNT.getThreadList().add(baVar);
        }
        if (this.bWr != null) {
            this.bWr.clear();
            this.bWr.add(baVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> abV() {
        return this.bWr;
    }

    public void im(int i) {
        this.bYh = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.s.bhI();
        } else {
            com.baidu.tieba.tbadkCore.util.s.bhJ();
        }
    }

    public void in(int i) {
        this.bYi = i;
    }

    public void ee(boolean z) {
        this.bYj = z;
    }

    public int abW() {
        return this.bYh;
    }

    public int abX() {
        return com.baidu.tieba.frs.d.n.iA(this.bYh);
    }

    public boolean abY() {
        return this.bXW;
    }

    public boolean abZ() {
        return this.bYh == 5;
    }

    public boolean aca() {
        return this.bXU != null && this.bXU.getLoadType() == 1;
    }

    public boolean acb() {
        return this.bYh == 7;
    }

    private int b(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.bNK.YQ() != null) {
            return this.bNK.YQ().a(this.bYh, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bk.XA.get()) {
            int pd = com.baidu.tieba.recapp.x.aYp().aYm().pd(str);
            int pe = com.baidu.tieba.recapp.x.aYp().aYm().pe(str);
            if (frsRequestData.getLoadType() == 1) {
                pd++;
            } else {
                pe++;
            }
            frsRequestData.rD(pd);
            frsRequestData.rC(pe);
        }
    }

    public void acc() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.bNT != null && this.bNT.aHE() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.bNT.aHE().getId(), 0L));
        }
        this.bNK.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void iW(String str) {
        com.baidu.tbadk.util.w.a(new j(this, str), null);
    }

    public void iX(String str) {
        com.baidu.tbadk.util.w.a(new k(this, str), null);
    }
}
