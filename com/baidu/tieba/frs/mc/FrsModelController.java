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
    private long cIA;
    private long cIB;
    private long cIy;
    private long cIz;
    private l cWL;
    private String cXa;
    private d.a dcz;
    private final FrsFragment dmW;
    private FrsNetModel<FrsFragment> dmb;
    private String dmd;
    private ArrayList<com.baidu.adp.widget.ListView.h> dnb;
    private FrsRequestData dnc;
    private final n dnd;
    private boolean dne;
    private int dnf;
    private int dng;
    private am dnh;
    private boolean dni;
    private SparseArray<am> dnj;
    private y dnk;
    private aj dnl;
    private ArrayList<com.baidu.adp.widget.ListView.h> dnm;
    private boolean dnn;
    private String dno;
    private int dnp;
    private int dnq;
    private boolean dnr;
    private String dnt;
    private final SparseArray<Boolean> dnu;
    private aj dnv;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean kU(int i) {
        return this.dnu.get(i, false).booleanValue();
    }

    public void r(int i, boolean z) {
        this.dnu.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.cXa = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.dmd = null;
        this.bjL = 1;
        this.dnf = 0;
        this.dng = 0;
        this.dni = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.dnj = new SparseArray<>();
        this.aKW = 0L;
        this.dnn = false;
        this.dnp = -1;
        this.dnq = -1;
        this.dnt = null;
        this.dnu = new SparseArray<>();
        this.dnv = new aj() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.aj
            public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
                FrsModelController.this.dni = false;
                if (i == FrsModelController.this.bjL && FrsModelController.this.dnl != null) {
                    FrsModelController.this.dnh = apVar;
                    FrsModelController.this.b(i, i2, apVar);
                    ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.cWL.av(arrayList2);
                    FrsModelController.this.dnl.a(i, i2, apVar, arrayList);
                }
            }
        };
        this.cIy = 0L;
        this.cIz = 0L;
        this.cIA = 0L;
        this.cIB = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.dmW = frsFragment;
        this.dnd = nVar;
        y(this.dmW);
    }

    private void y(FrsFragment frsFragment) {
        this.dnk = new y();
        this.dnk.aTr = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.dnk));
        this.dnk.a(this.dnv);
    }

    public void onActivityDestroy() {
        this.dmb.cancelLoadData();
    }

    public void i(Bundle bundle) {
        if (bundle != null) {
            this.cXa = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dno = bundle.getString("yuelaou_locate");
            this.dne = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.cXa)) {
            this.cXa = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.dno)) {
            this.dno = "";
        }
        this.mSource = this.mFrom;
        this.dnc = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            kV(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            kV(6);
        } else {
            com.baidu.tieba.frs.smartsort.f mq = com.baidu.tieba.frs.smartsort.d.auC().mq(this.cXa);
            if (mq != null) {
                kV(mq.doi);
            } else {
                kV(-1);
            }
        }
        this.dnc.setSortType(Rl());
        if (this.dnp == 5) {
            this.dnc.setIsGood(1);
        } else {
            this.dnc.setIsGood(0);
        }
        this.cWL = new l();
        this.dmb = new FrsNetModel<>(this.dmW.getPageContext(), this.dnc);
        this.dmb.a(this);
        this.dmb.setUniqueId(this.dmW.getUniqueId());
        if (this.cXa != null && this.cXa.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.cXa);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean agL() {
        if (this.bjL != 1) {
            kQ(1);
            return true;
        } else if (this.dmb.wX()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dnc), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(Rl());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void t(int i, boolean z) {
        if (this.cWL != null && this.cWL.bqo() != null) {
            this.cWL.bqo().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dnc), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bjL = c(this.bjL, frsRequestData);
        if (this.bjL == 1) {
            if (!this.dmb.wX()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.dnh == null) {
            this.dnh = new am();
            this.dnh.pn = 1;
            this.dnh.forumName = this.cXa;
            if (this.cWL != null && this.cWL.aVq() != null) {
                this.dnh.forumId = this.cWL.aVq().getId();
            }
        }
        kQ(i);
    }

    public void kR(int i) {
        if (this.bjL != 1) {
            kQ(4);
        } else if (!this.dmb.wX()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dnc), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(Rl());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.dnd.kd(i);
        this.dmb.a(frsRequestData);
        this.mType = i;
        frsRequestData.sH(this.dmW.apG() ? "1" : "2");
        if (this.dnr) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.f.ll(this.dnq)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.dnr = false;
        frsRequestData.setKw(this.cXa);
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
        frsRequestData.setLastId(this.dmd);
        frsRequestData.setYuelaouLocate(this.dno);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(t.HP(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.cXi != 0) {
            frsRequestData.setCtime((int) FrsFragment.cXi);
        }
        if (FrsFragment.cXj != 0) {
            frsRequestData.setDataSize((int) FrsFragment.cXj);
        }
        if (FrsFragment.cXk != 0) {
            frsRequestData.setNetError(FrsFragment.cXk);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.f.a(this.dnp, frsRequestData);
        b(i, frsRequestData);
        a(this.cXa, frsRequestData);
        if (!kU(this.dnp)) {
            String d = com.baidu.tieba.tbadkCore.c.bpQ().d(this.cXa, frsRequestData.Rl(), frsRequestData.getIsGood(), this.dnc.getCategoryId());
            this.dnt = d;
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
        if (iVar == null || iVar.aVq() == null || (an.isEmpty(iVar.aVq().getName()) && 340001 != iVar.dcA)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bjL = iVar.bqs();
        }
        this.cWL.e(iVar);
        d(this.cWL);
        this.dnb = new ArrayList<>();
        if (frsRequestData != null) {
            this.dnc = frsRequestData;
            this.mPn = this.dnc.getPn();
            this.cXa = this.dnc.getKw();
            this.dmW.setForumName(this.cXa);
            this.dmW.setFrom(this.mFrom);
            this.dmW.setPn(this.mPn);
            this.dmW.setFlag(this.mFlag);
        }
        if (this.cWL.getThreadList() != null) {
            this.dnb.addAll(this.cWL.getThreadList());
        }
        if (this.bjL != 1 && this.isNetFirstLoad) {
            this.dnd.a(7, false, this.dcz);
        } else {
            this.dnd.a(this.mType, false, this.dcz);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.dnc)) {
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
        aVar.gtk = com.baidu.adp.lib.util.j.gP() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gtl = mvcSocketResponsedMessage.getDownSize();
        this.dcz = aVar;
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
        this.dmW.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dnn) {
            this.dnn = true;
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
        aVar.gtk = com.baidu.adp.lib.util.j.gP() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gtl = mvcHttpResponsedMessage.getDownSize();
        this.dcz = aVar;
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
        this.dmW.a(errorData);
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
        if (!this.dnn) {
            this.dnn = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void apB() {
        if (this.cWL != null && this.cWL.aVq() != null && this.cWL.aVq().getBannerListData() != null) {
            String lastIds = this.cWL.aVq().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dmd = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (p.Ha().Hb()) {
            this.aKW = System.currentTimeMillis() - this.dmW.beginTime;
            com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l(i, z, responsedMessage, this.dmW.aKN, this.dmW.createTime, this.dmW.aKV, false, this.aKW);
            this.dmW.createTime = 0L;
            this.dmW.aKN = 0L;
            if (lVar != null) {
                lVar.GT();
            }
        }
    }

    public FrsRequestData auc() {
        return this.dnc;
    }

    public String aud() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.cXa;
    }

    public int getPn() {
        return this.mPn;
    }

    public l atJ() {
        return this.cWL;
    }

    public d.a aue() {
        return this.dcz;
    }

    private void atK() {
        this.cIy = System.currentTimeMillis();
        this.dmb.FY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.cWL.e(iVar);
        d(this.cWL);
        this.dnb = new ArrayList<>();
        if (this.cWL.getThreadList() != null) {
            this.dnb.addAll(this.cWL.getThreadList());
        }
        this.dnd.b(iVar);
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
        private FrsModelController dnA;
        private String dnz;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.dnz = null;
            this.dnz = str;
            this.dnA = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bpQ().sF(this.dnz)) {
                if (!com.baidu.tieba.tbadkCore.c.bpQ().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.dnz)) {
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
            if (this.dnA != null && iVarArr != null) {
                this.dnA.d(iVarArr.length > 0 ? iVarArr[0] : null);
                this.dnA.r(this.dnA.dnp, true);
            }
        }
    }

    public long alc() {
        return this.cIB;
    }

    public long ald() {
        return this.cIz;
    }

    public long ale() {
        return this.cIA;
    }

    public long alf() {
        return this.cIy;
    }

    public boolean wX() {
        return this.dmb.wX();
    }

    public int auf() {
        return this.dng;
    }

    private void aug() {
        if (this.dnm == null) {
            this.dnm = new ArrayList<>();
        }
        if (this.dnm.size() == 0) {
            this.dnm.add(new com.baidu.tieba.frs.t());
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(int i, int i2, am amVar) {
        this.bjL = c(i, null);
        if (amVar == null && (amVar = aJ(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.hg() && this.dnl != null) {
                ap apVar = new ap();
                apVar.hasMore = false;
                apVar.pn = 1;
                apVar.forumName = this.cXa;
                apVar.das = false;
                if (this.cWL != null && this.cWL.aVq() != null) {
                    apVar.forumId = this.cWL.aVq().getId();
                }
                aug();
                this.cWL.av(this.dnm);
                this.dnl.a(i, i2, apVar, this.dnm);
            }
            amVar = new am();
            amVar.pn = -1;
        }
        if (this.cWL != null && this.cWL.aVq() != null) {
            amVar.forumId = this.cWL.aVq().getId();
        }
        amVar.forumName = this.cXa;
        if (w.aqF().kk(1) != null && this.bjL == 1) {
            this.dnc.setCategoryId(i2);
        }
        this.dnf = i2;
        this.dnh = amVar;
        b(i, i2, amVar);
        kQ(5);
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(aj ajVar) {
        this.dnl = ajVar;
        this.dnk.a(this.dnv);
    }

    private void kQ(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.dnh != null) {
                    this.dnh.pn++;
                    break;
                }
                break;
            case 2:
                if (this.dnh != null) {
                    am amVar = this.dnh;
                    amVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.dnh != null) {
                    this.dnh.pn = -1;
                    break;
                }
                break;
        }
        if (this.bjL == 1) {
            if (this.dng == this.dnf) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                if (this.dnb != null) {
                    arrayList.addAll(this.dnb);
                }
                this.cWL.av(arrayList);
                if (this.dnl != null) {
                    this.dnl.a(this.bjL, this.dnf, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.dng = this.dnf;
            return;
        }
        ag kl = this.dnk.kl(this.bjL);
        if (kl != null) {
            this.dni = true;
            kl.a(this.bjL, this.dnf, this.dnh);
            return;
        }
        if (this.cWL != null && this.cWL.getThreadList() != null) {
            this.cWL.getThreadList().clear();
        }
        this.dnl.a(this.bjL, this.dnf, null, null);
    }

    public boolean hasMore() {
        if ((this.dnh instanceof ap) && ((ap) this.dnh).errCode == 0) {
            return ((ap) this.dnh).hasMore;
        }
        return true;
    }

    private int aI(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, am amVar) {
        this.dnj.put(aI(i, i2), amVar);
    }

    public am aJ(int i, int i2) {
        return this.dnj.get(aI(i, i2));
    }

    @Override // com.baidu.tieba.frs.ag
    public void init() {
        this.dnk.init();
    }

    @Override // com.baidu.tieba.frs.ag
    public void Ry() {
        this.dnk.destory();
        this.dnk.clear();
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
        if (ajVar != null && !StringUtils.isNull(ajVar.getId()) && this.dnb != null) {
            if (this.bjL == 1) {
                this.cWL.a(ajVar);
            }
            int auj = auj();
            if (this.dnb != null && this.dnb.size() > 0) {
                int size = this.dnb.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.h hVar = this.dnb.get(i);
                    if ((hVar instanceof bd) && ajVar.getId().equals(((bd) hVar).getId())) {
                        return;
                    }
                }
            }
            this.dnb.add(auj, ajVar);
        }
    }

    public int auj() {
        int i = 0;
        if (this.dnb == null || this.dnb.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.dnb.iterator();
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
        return this.dni;
    }

    public void aul() {
        k kVar = new k();
        if (this.dng == 0) {
            kVar.kj(this.dnp);
        }
        if (this.cWL.getThreadList() != null) {
            this.cWL.getThreadList().clear();
            this.cWL.getThreadList().add(kVar);
        }
        if (this.dnb != null) {
            this.dnb.clear();
            this.dnb.add(kVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aum() {
        return this.dnb;
    }

    public void kV(int i) {
        this.dnp = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.f.bsV();
        } else {
            com.baidu.tieba.tbadkCore.util.f.bsW();
        }
    }

    public void kW(int i) {
        this.dnq = i;
    }

    public void fS(boolean z) {
        this.dnr = z;
    }

    public int aun() {
        return this.dnp;
    }

    public int Rl() {
        return com.baidu.tieba.frs.f.f.ll(this.dnp);
    }

    public boolean auo() {
        return this.dne;
    }

    public boolean aup() {
        return this.dnp == 5;
    }

    public boolean auq() {
        return this.dnc != null && this.dnc.getLoadType() == 1;
    }

    public boolean aur() {
        return this.dnp == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.dmW.apd() != null) {
            return this.dmW.apd().a(this.dnp, frsRequestData);
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
        if (this.cWL != null && this.cWL.aVq() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.cWL.aVq().getId(), 0L));
        }
        this.dmW.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void mi(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bpQ().bY(FrsModelController.this.dnt, str);
                return null;
            }
        }, null);
    }

    public void mj(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bpQ().bZ(FrsModelController.this.dnt, str);
                return null;
            }
        }, null);
    }

    public void mk(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bpQ().ca(FrsModelController.this.dnt, str);
                return null;
            }
        }, null);
    }
}
