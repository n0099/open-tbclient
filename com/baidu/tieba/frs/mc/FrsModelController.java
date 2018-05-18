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
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
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
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.i>, ag {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long aKX;
    private int bkb;
    private long cJH;
    private long cJI;
    private long cJJ;
    private long cJK;
    private l cXS;
    private String cYh;
    private d.a ddH;
    private FrsNetModel<FrsFragment> dni;
    private String dnk;
    private boolean doA;
    private String doB;
    private final SparseArray<Boolean> doC;
    private aj doD;
    private final FrsFragment dof;
    private ArrayList<com.baidu.adp.widget.ListView.h> dok;
    private FrsRequestData dol;
    private final n dom;
    private boolean don;
    private int doo;
    private int dop;
    private am doq;
    private boolean dor;
    private SparseArray<am> dos;
    private y dot;
    private aj dou;
    private ArrayList<com.baidu.adp.widget.ListView.h> dov;
    private boolean dow;
    private String dox;
    private int doy;
    private int doz;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean kT(int i) {
        return this.doC.get(i, false).booleanValue();
    }

    public void r(int i, boolean z) {
        this.doC.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.cYh = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.dnk = null;
        this.bkb = 1;
        this.doo = 0;
        this.dop = 0;
        this.dor = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.dos = new SparseArray<>();
        this.aKX = 0L;
        this.dow = false;
        this.doy = -1;
        this.doz = -1;
        this.doB = null;
        this.doC = new SparseArray<>();
        this.doD = new aj() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.aj
            public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
                FrsModelController.this.dor = false;
                if (i == FrsModelController.this.bkb && FrsModelController.this.dou != null) {
                    FrsModelController.this.doq = apVar;
                    FrsModelController.this.b(i, i2, apVar);
                    ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.cXS.av(arrayList2);
                    FrsModelController.this.dou.a(i, i2, apVar, arrayList);
                }
            }
        };
        this.cJH = 0L;
        this.cJI = 0L;
        this.cJJ = 0L;
        this.cJK = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.dof = frsFragment;
        this.dom = nVar;
        y(this.dof);
    }

    private void y(FrsFragment frsFragment) {
        this.dot = new y();
        this.dot.aTs = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.dot));
        this.dot.a(this.doD);
    }

    public void onActivityDestroy() {
        this.dni.cancelLoadData();
    }

    public void i(Bundle bundle) {
        if (bundle != null) {
            this.cYh = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dox = bundle.getString("yuelaou_locate");
            this.don = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.cYh)) {
            this.cYh = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.dox)) {
            this.dox = "";
        }
        this.mSource = this.mFrom;
        this.dol = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            kU(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            kU(6);
        } else {
            com.baidu.tieba.frs.smartsort.f mt = com.baidu.tieba.frs.smartsort.d.auC().mt(this.cYh);
            if (mt != null) {
                kU(mt.dpq);
            } else {
                kU(-1);
            }
        }
        this.dol.setSortType(Ri());
        if (this.doy == 5) {
            this.dol.setIsGood(1);
        } else {
            this.dol.setIsGood(0);
        }
        this.cXS = new l();
        this.dni = new FrsNetModel<>(this.dof.getPageContext(), this.dol);
        this.dni.a(this);
        this.dni.setUniqueId(this.dof.getUniqueId());
        if (this.cYh != null && this.cYh.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.cYh);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean agL() {
        if (this.bkb != 1) {
            kP(1);
            return true;
        } else if (this.dni.wW()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dol), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(Ri());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void t(int i, boolean z) {
        if (this.cXS != null && this.cXS.bqm() != null) {
            this.cXS.bqm().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dol), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bkb = c(this.bkb, frsRequestData);
        if (this.bkb == 1) {
            if (!this.dni.wW()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.doq == null) {
            this.doq = new am();
            this.doq.pn = 1;
            this.doq.forumName = this.cYh;
            if (this.cXS != null && this.cXS.aVq() != null) {
                this.doq.forumId = this.cXS.aVq().getId();
            }
        }
        kP(i);
    }

    public void kQ(int i) {
        if (this.bkb != 1) {
            kP(4);
        } else if (!this.dni.wW()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dol), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(Ri());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.dom.kc(i);
        this.dni.a(frsRequestData);
        this.mType = i;
        frsRequestData.sK(this.dof.apF() ? "1" : "2");
        if (this.doA) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.f.lk(this.doz)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.doA = false;
        frsRequestData.setKw(this.cYh);
        if (com.baidu.tbadk.core.i.pX().qd()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        float ai = com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
        int i2 = com.baidu.tbadk.core.util.ap.vP().vR() ? 2 : 1;
        frsRequestData.setScrW(af);
        frsRequestData.setScrH(ah);
        frsRequestData.setScrDip(ai);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.dnk);
        frsRequestData.setYuelaouLocate(this.dox);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(t.HN(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.cYp != 0) {
            frsRequestData.setCtime((int) FrsFragment.cYp);
        }
        if (FrsFragment.cYq != 0) {
            frsRequestData.setDataSize((int) FrsFragment.cYq);
        }
        if (FrsFragment.cYr != 0) {
            frsRequestData.setNetError(FrsFragment.cYr);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.f.a(this.doy, frsRequestData);
        b(i, frsRequestData);
        a(this.cYh, frsRequestData);
        if (!kT(this.doy)) {
            String d = com.baidu.tieba.tbadkCore.c.bpO().d(this.cYh, frsRequestData.Ri(), frsRequestData.getIsGood(), this.dol.getCategoryId());
            this.doB = d;
            new a(this, true, d).execute(new Object[0]);
        }
        atJ();
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
        if (iVar == null || iVar.aVq() == null || (an.isEmpty(iVar.aVq().getName()) && 340001 != iVar.ddI)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bkb = iVar.bqq();
        }
        this.cXS.e(iVar);
        d(this.cXS);
        this.dok = new ArrayList<>();
        if (frsRequestData != null) {
            this.dol = frsRequestData;
            this.mPn = this.dol.getPn();
            this.cYh = this.dol.getKw();
            this.dof.setForumName(this.cYh);
            this.dof.setFrom(this.mFrom);
            this.dof.setPn(this.mPn);
            this.dof.setFlag(this.mFlag);
        }
        if (this.cXS.getThreadList() != null) {
            this.dok.addAll(this.cXS.getThreadList());
        }
        if (this.bkb != 1 && this.isNetFirstLoad) {
            this.dom.a(7, false, this.ddH);
        } else {
            this.dom.a(this.mType, false, this.ddH);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.dol)) {
            aur();
        }
        this.isNetFirstLoad = false;
        if (iVar.aVq() == null || TextUtils.isEmpty(iVar.aVq().getName()) || frsRequestData == null || r.bjk().bje() == null) {
            return true;
        }
        r.bjk().bje().f(iVar.aVq().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.guo = com.baidu.adp.lib.util.j.gP() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gup = mvcSocketResponsedMessage.getDownSize();
        this.ddH = aVar;
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
        this.dof.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dow) {
            this.dow = true;
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
        aVar.guo = com.baidu.adp.lib.util.j.gP() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gup = mvcHttpResponsedMessage.getDownSize();
        this.ddH = aVar;
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
        this.dof.a(errorData);
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
        if (!this.dow) {
            this.dow = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void apA() {
        if (this.cXS != null && this.cXS.aVq() != null && this.cXS.aVq().getBannerListData() != null) {
            String lastIds = this.cXS.aVq().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dnk = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (p.GY().GZ()) {
            this.aKX = System.currentTimeMillis() - this.dof.beginTime;
            com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l(i, z, responsedMessage, this.dof.aKO, this.dof.createTime, this.dof.aKW, false, this.aKX);
            this.dof.createTime = 0L;
            this.dof.aKO = 0L;
            if (lVar != null) {
                lVar.GR();
            }
        }
    }

    public FrsRequestData aub() {
        return this.dol;
    }

    public String auc() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.cYh;
    }

    public int getPn() {
        return this.mPn;
    }

    public l atI() {
        return this.cXS;
    }

    public d.a aud() {
        return this.ddH;
    }

    private void atJ() {
        this.cJH = System.currentTimeMillis();
        this.dni.FW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.cXS.e(iVar);
        d(this.cXS);
        this.dok = new ArrayList<>();
        if (this.cXS.getThreadList() != null) {
            this.dok.addAll(this.cXS.getThreadList());
        }
        this.dom.b(iVar);
    }

    private void d(l lVar) {
        if (com.baidu.tieba.frs.vc.f.h(lVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.vc.f.i(lVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.i, Void> {
        private String doH;
        private FrsModelController doI;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.doH = null;
            this.doH = str;
            this.doI = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bpO().sI(this.doH)) {
                if (!com.baidu.tieba.tbadkCore.c.bpO().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.doH)) {
                    com.baidu.tieba.tbadkCore.c.bpO().getResponseData().aVq().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.i responseData = com.baidu.tieba.tbadkCore.c.bpO().getResponseData();
                responseData.mm(false);
                if (responseData.bqs() != null && !StringUtils.isNull(responseData.bqs().qz(), true) && !responseData.bqs().qz().equals("0") && responseData.bqs().getBookType() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bqs().qz(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(g))) != null) {
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
        public void onProgressUpdate(com.baidu.tieba.tbadkCore.i... iVarArr) {
            super.onProgressUpdate(iVarArr);
            if (this.doI != null && iVarArr != null) {
                this.doI.d(iVarArr.length > 0 ? iVarArr[0] : null);
                this.doI.r(this.doI.doy, true);
            }
        }
    }

    public long alc() {
        return this.cJK;
    }

    public long ald() {
        return this.cJI;
    }

    public long ale() {
        return this.cJJ;
    }

    public long alf() {
        return this.cJH;
    }

    public boolean wW() {
        return this.dni.wW();
    }

    public int aue() {
        return this.dop;
    }

    private void auf() {
        if (this.dov == null) {
            this.dov = new ArrayList<>();
        }
        if (this.dov.size() == 0) {
            this.dov.add(new com.baidu.tieba.frs.t());
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(int i, int i2, am amVar) {
        this.bkb = c(i, null);
        if (amVar == null && (amVar = aJ(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.hg() && this.dou != null) {
                ap apVar = new ap();
                apVar.hasMore = false;
                apVar.pn = 1;
                apVar.forumName = this.cYh;
                apVar.dbB = false;
                if (this.cXS != null && this.cXS.aVq() != null) {
                    apVar.forumId = this.cXS.aVq().getId();
                }
                auf();
                this.cXS.av(this.dov);
                this.dou.a(i, i2, apVar, this.dov);
            }
            amVar = new am();
            amVar.pn = -1;
        }
        if (this.cXS != null && this.cXS.aVq() != null) {
            amVar.forumId = this.cXS.aVq().getId();
        }
        amVar.forumName = this.cYh;
        if (w.aqE().kj(1) != null && this.bkb == 1) {
            this.dol.setCategoryId(i2);
        }
        this.doo = i2;
        this.doq = amVar;
        b(i, i2, amVar);
        kP(5);
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(aj ajVar) {
        this.dou = ajVar;
        this.dot.a(this.doD);
    }

    private void kP(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.doq != null) {
                    this.doq.pn++;
                    break;
                }
                break;
            case 2:
                if (this.doq != null) {
                    am amVar = this.doq;
                    amVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.doq != null) {
                    this.doq.pn = -1;
                    break;
                }
                break;
        }
        if (this.bkb == 1) {
            if (this.dop == this.doo) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                if (this.dok != null) {
                    arrayList.addAll(this.dok);
                }
                this.cXS.av(arrayList);
                if (this.dou != null) {
                    this.dou.a(this.bkb, this.doo, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.dop = this.doo;
            return;
        }
        ag kk = this.dot.kk(this.bkb);
        if (kk != null) {
            this.dor = true;
            kk.a(this.bkb, this.doo, this.doq);
            return;
        }
        if (this.cXS != null && this.cXS.getThreadList() != null) {
            this.cXS.getThreadList().clear();
        }
        this.dou.a(this.bkb, this.doo, null, null);
    }

    public boolean hasMore() {
        if ((this.doq instanceof ap) && ((ap) this.doq).errCode == 0) {
            return ((ap) this.doq).hasMore;
        }
        return true;
    }

    private int aI(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, am amVar) {
        this.dos.put(aI(i, i2), amVar);
    }

    public am aJ(int i, int i2) {
        return this.dos.get(aI(i, i2));
    }

    @Override // com.baidu.tieba.frs.ag
    public void init() {
        this.dot.init();
    }

    @Override // com.baidu.tieba.frs.ag
    public void Rv() {
        this.dot.destory();
        this.dot.clear();
    }

    public int aug() {
        return this.bkb;
    }

    public boolean auh() {
        return 1 == this.bkb;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(com.baidu.tbadk.core.data.aj ajVar) {
        if (ajVar != null && !StringUtils.isNull(ajVar.getId()) && this.dok != null) {
            if (this.bkb == 1) {
                this.cXS.a(ajVar);
            }
            int aui = aui();
            if (this.dok != null && this.dok.size() > 0) {
                int size = this.dok.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.h hVar = this.dok.get(i);
                    if ((hVar instanceof bd) && ajVar.getId().equals(((bd) hVar).getId())) {
                        return;
                    }
                }
            }
            this.dok.add(aui, ajVar);
        }
    }

    public int aui() {
        int i = 0;
        if (this.dok == null || this.dok.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.dok.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (!(next instanceof bd)) {
                    i = i2;
                } else if (((bd) next).rK() != 0) {
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

    public boolean auj() {
        return this.dor;
    }

    public void auk() {
        k kVar = new k();
        if (this.dop == 0) {
            kVar.ki(this.doy);
        }
        if (this.cXS.getThreadList() != null) {
            this.cXS.getThreadList().clear();
            this.cXS.getThreadList().add(kVar);
        }
        if (this.dok != null) {
            this.dok.clear();
            this.dok.add(kVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aul() {
        return this.dok;
    }

    public void kU(int i) {
        this.doy = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.bsT();
        } else {
            com.baidu.tieba.tbadkCore.util.e.bsU();
        }
    }

    public void kV(int i) {
        this.doz = i;
    }

    public void fT(boolean z) {
        this.doA = z;
    }

    public int aum() {
        return this.doy;
    }

    public int Ri() {
        return com.baidu.tieba.frs.f.f.lk(this.doy);
    }

    public boolean aun() {
        return this.don;
    }

    public boolean auo() {
        return this.doy == 5;
    }

    public boolean aup() {
        return this.dol != null && this.dol.getLoadType() == 1;
    }

    public boolean auq() {
        return this.doy == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.dof.apc() != null) {
            return this.dof.apc().a(this.doy, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bd.ZS.get() && r.bjk().bje() != null) {
            int Q = r.bjk().bje().Q(str, false);
            int R = r.bjk().bje().R(str, false);
            if (frsRequestData.getLoadType() == 1) {
                Q++;
            } else if (frsRequestData.getLoadType() == 2) {
                R++;
            }
            frsRequestData.setRefreshCount(Q);
            frsRequestData.setLoadCount(R);
        }
    }

    public void aur() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.cXS != null && this.cXS.aVq() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.cXS.aVq().getId(), 0L));
        }
        this.dof.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void ml(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bpO().bY(FrsModelController.this.doB, str);
                return null;
            }
        }, null);
    }

    public void mm(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bpO().bZ(FrsModelController.this.doB, str);
                return null;
            }
        }, null);
    }

    public void mn(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bpO().ca(FrsModelController.this.doB, str);
                return null;
            }
        }, null);
    }
}
