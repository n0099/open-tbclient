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
    private long aKW;
    private int bjL;
    private long cIB;
    private long cIC;
    private long cID;
    private long cIE;
    private l cWO;
    private String cXd;
    private d.a dcC;
    private final FrsFragment dmZ;
    private FrsNetModel<FrsFragment> dme;
    private String dmg;
    private ArrayList<com.baidu.adp.widget.ListView.h> dne;
    private FrsRequestData dnf;
    private final n dng;
    private boolean dnh;
    private int dni;
    private int dnj;
    private am dnk;
    private boolean dnl;
    private SparseArray<am> dnm;
    private y dnn;
    private aj dno;
    private ArrayList<com.baidu.adp.widget.ListView.h> dnp;
    private boolean dnq;
    private String dnr;
    private int dnt;
    private int dnu;
    private boolean dnv;
    private String dnw;
    private final SparseArray<Boolean> dnx;
    private aj dny;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean kU(int i) {
        return this.dnx.get(i, false).booleanValue();
    }

    public void r(int i, boolean z) {
        this.dnx.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.cXd = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.dmg = null;
        this.bjL = 1;
        this.dni = 0;
        this.dnj = 0;
        this.dnl = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.dnm = new SparseArray<>();
        this.aKW = 0L;
        this.dnq = false;
        this.dnt = -1;
        this.dnu = -1;
        this.dnw = null;
        this.dnx = new SparseArray<>();
        this.dny = new aj() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.aj
            public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
                FrsModelController.this.dnl = false;
                if (i == FrsModelController.this.bjL && FrsModelController.this.dno != null) {
                    FrsModelController.this.dnk = apVar;
                    FrsModelController.this.b(i, i2, apVar);
                    ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.cWO.av(arrayList2);
                    FrsModelController.this.dno.a(i, i2, apVar, arrayList);
                }
            }
        };
        this.cIB = 0L;
        this.cIC = 0L;
        this.cID = 0L;
        this.cIE = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.dmZ = frsFragment;
        this.dng = nVar;
        y(this.dmZ);
    }

    private void y(FrsFragment frsFragment) {
        this.dnn = new y();
        this.dnn.aTr = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.dnn));
        this.dnn.a(this.dny);
    }

    public void onActivityDestroy() {
        this.dme.cancelLoadData();
    }

    public void i(Bundle bundle) {
        if (bundle != null) {
            this.cXd = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dnr = bundle.getString("yuelaou_locate");
            this.dnh = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.cXd)) {
            this.cXd = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.dnr)) {
            this.dnr = "";
        }
        this.mSource = this.mFrom;
        this.dnf = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            kV(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            kV(6);
        } else {
            com.baidu.tieba.frs.smartsort.f mq = com.baidu.tieba.frs.smartsort.d.auC().mq(this.cXd);
            if (mq != null) {
                kV(mq.dol);
            } else {
                kV(-1);
            }
        }
        this.dnf.setSortType(Rl());
        if (this.dnt == 5) {
            this.dnf.setIsGood(1);
        } else {
            this.dnf.setIsGood(0);
        }
        this.cWO = new l();
        this.dme = new FrsNetModel<>(this.dmZ.getPageContext(), this.dnf);
        this.dme.a(this);
        this.dme.setUniqueId(this.dmZ.getUniqueId());
        if (this.cXd != null && this.cXd.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.cXd);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean agL() {
        if (this.bjL != 1) {
            kQ(1);
            return true;
        } else if (this.dme.wX()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dnf), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(Rl());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void t(int i, boolean z) {
        if (this.cWO != null && this.cWO.bqo() != null) {
            this.cWO.bqo().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dnf), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bjL = c(this.bjL, frsRequestData);
        if (this.bjL == 1) {
            if (!this.dme.wX()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.dnk == null) {
            this.dnk = new am();
            this.dnk.pn = 1;
            this.dnk.forumName = this.cXd;
            if (this.cWO != null && this.cWO.aVq() != null) {
                this.dnk.forumId = this.cWO.aVq().getId();
            }
        }
        kQ(i);
    }

    public void kR(int i) {
        if (this.bjL != 1) {
            kQ(4);
        } else if (!this.dme.wX()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dnf), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(Rl());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.dng.kd(i);
        this.dme.a(frsRequestData);
        this.mType = i;
        frsRequestData.sH(this.dmZ.apG() ? "1" : "2");
        if (this.dnv) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.f.ll(this.dnu)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.dnv = false;
        frsRequestData.setKw(this.cXd);
        if (com.baidu.tbadk.core.i.pY().qe()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        float ai = com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
        int i2 = com.baidu.tbadk.core.util.ap.vQ().vS() ? 2 : 1;
        frsRequestData.setScrW(af);
        frsRequestData.setScrH(ah);
        frsRequestData.setScrDip(ai);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.dmg);
        frsRequestData.setYuelaouLocate(this.dnr);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(t.HP(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.cXl != 0) {
            frsRequestData.setCtime((int) FrsFragment.cXl);
        }
        if (FrsFragment.cXm != 0) {
            frsRequestData.setDataSize((int) FrsFragment.cXm);
        }
        if (FrsFragment.cXn != 0) {
            frsRequestData.setNetError(FrsFragment.cXn);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.f.a(this.dnt, frsRequestData);
        b(i, frsRequestData);
        a(this.cXd, frsRequestData);
        if (!kU(this.dnt)) {
            String d = com.baidu.tieba.tbadkCore.c.bpQ().d(this.cXd, frsRequestData.Rl(), frsRequestData.getIsGood(), this.dnf.getCategoryId());
            this.dnw = d;
            new a(this, true, d).execute(new Object[0]);
        }
        atK();
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
        if (iVar == null || iVar.aVq() == null || (an.isEmpty(iVar.aVq().getName()) && 340001 != iVar.dcD)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bjL = iVar.bqs();
        }
        this.cWO.e(iVar);
        d(this.cWO);
        this.dne = new ArrayList<>();
        if (frsRequestData != null) {
            this.dnf = frsRequestData;
            this.mPn = this.dnf.getPn();
            this.cXd = this.dnf.getKw();
            this.dmZ.setForumName(this.cXd);
            this.dmZ.setFrom(this.mFrom);
            this.dmZ.setPn(this.mPn);
            this.dmZ.setFlag(this.mFlag);
        }
        if (this.cWO.getThreadList() != null) {
            this.dne.addAll(this.cWO.getThreadList());
        }
        if (this.bjL != 1 && this.isNetFirstLoad) {
            this.dng.a(7, false, this.dcC);
        } else {
            this.dng.a(this.mType, false, this.dcC);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.dnf)) {
            aus();
        }
        this.isNetFirstLoad = false;
        if (iVar.aVq() == null || TextUtils.isEmpty(iVar.aVq().getName()) || frsRequestData == null || r.bjl().bjf() == null) {
            return true;
        }
        r.bjl().bjf().f(iVar.aVq().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.gtn = com.baidu.adp.lib.util.j.gP() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gto = mvcSocketResponsedMessage.getDownSize();
        this.dcC = aVar;
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
        this.dmZ.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dnq) {
            this.dnq = true;
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
        aVar.gtn = com.baidu.adp.lib.util.j.gP() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gto = mvcHttpResponsedMessage.getDownSize();
        this.dcC = aVar;
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
        this.dmZ.a(errorData);
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
        if (!this.dnq) {
            this.dnq = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void apB() {
        if (this.cWO != null && this.cWO.aVq() != null && this.cWO.aVq().getBannerListData() != null) {
            String lastIds = this.cWO.aVq().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dmg = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (p.Ha().Hb()) {
            this.aKW = System.currentTimeMillis() - this.dmZ.beginTime;
            com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l(i, z, responsedMessage, this.dmZ.aKN, this.dmZ.createTime, this.dmZ.aKV, false, this.aKW);
            this.dmZ.createTime = 0L;
            this.dmZ.aKN = 0L;
            if (lVar != null) {
                lVar.GT();
            }
        }
    }

    public FrsRequestData auc() {
        return this.dnf;
    }

    public String aud() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.cXd;
    }

    public int getPn() {
        return this.mPn;
    }

    public l atJ() {
        return this.cWO;
    }

    public d.a aue() {
        return this.dcC;
    }

    private void atK() {
        this.cIB = System.currentTimeMillis();
        this.dme.FY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.cWO.e(iVar);
        d(this.cWO);
        this.dne = new ArrayList<>();
        if (this.cWO.getThreadList() != null) {
            this.dne.addAll(this.cWO.getThreadList());
        }
        this.dng.b(iVar);
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
        private String dnC;
        private FrsModelController dnD;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.dnC = null;
            this.dnC = str;
            this.dnD = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bpQ().sF(this.dnC)) {
                if (!com.baidu.tieba.tbadkCore.c.bpQ().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.dnC)) {
                    com.baidu.tieba.tbadkCore.c.bpQ().getResponseData().aVq().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.i responseData = com.baidu.tieba.tbadkCore.c.bpQ().getResponseData();
                responseData.ml(false);
                if (responseData.bqu() != null && !StringUtils.isNull(responseData.bqu().qA(), true) && !responseData.bqu().qA().equals("0") && responseData.bqu().getBookType() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bqu().qA(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(g))) != null) {
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
            if (this.dnD != null && iVarArr != null) {
                this.dnD.d(iVarArr.length > 0 ? iVarArr[0] : null);
                this.dnD.r(this.dnD.dnt, true);
            }
        }
    }

    public long alc() {
        return this.cIE;
    }

    public long ald() {
        return this.cIC;
    }

    public long ale() {
        return this.cID;
    }

    public long alf() {
        return this.cIB;
    }

    public boolean wX() {
        return this.dme.wX();
    }

    public int auf() {
        return this.dnj;
    }

    private void aug() {
        if (this.dnp == null) {
            this.dnp = new ArrayList<>();
        }
        if (this.dnp.size() == 0) {
            this.dnp.add(new com.baidu.tieba.frs.t());
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(int i, int i2, am amVar) {
        this.bjL = c(i, null);
        if (amVar == null && (amVar = aK(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.hg() && this.dno != null) {
                ap apVar = new ap();
                apVar.hasMore = false;
                apVar.pn = 1;
                apVar.forumName = this.cXd;
                apVar.daw = false;
                if (this.cWO != null && this.cWO.aVq() != null) {
                    apVar.forumId = this.cWO.aVq().getId();
                }
                aug();
                this.cWO.av(this.dnp);
                this.dno.a(i, i2, apVar, this.dnp);
            }
            amVar = new am();
            amVar.pn = -1;
        }
        if (this.cWO != null && this.cWO.aVq() != null) {
            amVar.forumId = this.cWO.aVq().getId();
        }
        amVar.forumName = this.cXd;
        if (w.aqF().kk(1) != null && this.bjL == 1) {
            this.dnf.setCategoryId(i2);
        }
        this.dni = i2;
        this.dnk = amVar;
        b(i, i2, amVar);
        kQ(5);
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(aj ajVar) {
        this.dno = ajVar;
        this.dnn.a(this.dny);
    }

    private void kQ(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.dnk != null) {
                    this.dnk.pn++;
                    break;
                }
                break;
            case 2:
                if (this.dnk != null) {
                    am amVar = this.dnk;
                    amVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.dnk != null) {
                    this.dnk.pn = -1;
                    break;
                }
                break;
        }
        if (this.bjL == 1) {
            if (this.dnj == this.dni) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                if (this.dne != null) {
                    arrayList.addAll(this.dne);
                }
                this.cWO.av(arrayList);
                if (this.dno != null) {
                    this.dno.a(this.bjL, this.dni, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.dnj = this.dni;
            return;
        }
        ag kl = this.dnn.kl(this.bjL);
        if (kl != null) {
            this.dnl = true;
            kl.a(this.bjL, this.dni, this.dnk);
            return;
        }
        if (this.cWO != null && this.cWO.getThreadList() != null) {
            this.cWO.getThreadList().clear();
        }
        this.dno.a(this.bjL, this.dni, null, null);
    }

    public boolean hasMore() {
        if ((this.dnk instanceof ap) && ((ap) this.dnk).errCode == 0) {
            return ((ap) this.dnk).hasMore;
        }
        return true;
    }

    private int aJ(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, am amVar) {
        this.dnm.put(aJ(i, i2), amVar);
    }

    public am aK(int i, int i2) {
        return this.dnm.get(aJ(i, i2));
    }

    @Override // com.baidu.tieba.frs.ag
    public void init() {
        this.dnn.init();
    }

    @Override // com.baidu.tieba.frs.ag
    public void Ry() {
        this.dnn.destory();
        this.dnn.clear();
    }

    public int auh() {
        return this.bjL;
    }

    public boolean aui() {
        return 1 == this.bjL;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(com.baidu.tbadk.core.data.aj ajVar) {
        if (ajVar != null && !StringUtils.isNull(ajVar.getId()) && this.dne != null) {
            if (this.bjL == 1) {
                this.cWO.a(ajVar);
            }
            int auj = auj();
            if (this.dne != null && this.dne.size() > 0) {
                int size = this.dne.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.h hVar = this.dne.get(i);
                    if ((hVar instanceof bd) && ajVar.getId().equals(((bd) hVar).getId())) {
                        return;
                    }
                }
            }
            this.dne.add(auj, ajVar);
        }
    }

    public int auj() {
        int i = 0;
        if (this.dne == null || this.dne.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.dne.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (!(next instanceof bd)) {
                    i = i2;
                } else if (((bd) next).rL() != 0) {
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

    public boolean auk() {
        return this.dnl;
    }

    public void aul() {
        k kVar = new k();
        if (this.dnj == 0) {
            kVar.kj(this.dnt);
        }
        if (this.cWO.getThreadList() != null) {
            this.cWO.getThreadList().clear();
            this.cWO.getThreadList().add(kVar);
        }
        if (this.dne != null) {
            this.dne.clear();
            this.dne.add(kVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aum() {
        return this.dne;
    }

    public void kV(int i) {
        this.dnt = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.f.bsV();
        } else {
            com.baidu.tieba.tbadkCore.util.f.bsW();
        }
    }

    public void kW(int i) {
        this.dnu = i;
    }

    public void fS(boolean z) {
        this.dnv = z;
    }

    public int aun() {
        return this.dnt;
    }

    public int Rl() {
        return com.baidu.tieba.frs.f.f.ll(this.dnt);
    }

    public boolean auo() {
        return this.dnh;
    }

    public boolean aup() {
        return this.dnt == 5;
    }

    public boolean auq() {
        return this.dnf != null && this.dnf.getLoadType() == 1;
    }

    public boolean aur() {
        return this.dnt == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.dmZ.apd() != null) {
            return this.dmZ.apd().a(this.dnt, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bd.ZS.get() && r.bjl().bjf() != null) {
            int Q = r.bjl().bjf().Q(str, false);
            int R = r.bjl().bjf().R(str, false);
            if (frsRequestData.getLoadType() == 1) {
                Q++;
            } else if (frsRequestData.getLoadType() == 2) {
                R++;
            }
            frsRequestData.setRefreshCount(Q);
            frsRequestData.setLoadCount(R);
        }
    }

    public void aus() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.cWO != null && this.cWO.aVq() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.cWO.aVq().getId(), 0L));
        }
        this.dmZ.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void mi(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bpQ().bY(FrsModelController.this.dnw, str);
                return null;
            }
        }, null);
    }

    public void mj(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bpQ().bZ(FrsModelController.this.dnw, str);
                return null;
            }
        }, null);
    }

    public void mk(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bpQ().ca(FrsModelController.this.dnw, str);
                return null;
            }
        }, null);
    }
}
