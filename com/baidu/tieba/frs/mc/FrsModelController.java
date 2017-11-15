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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.l.m;
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
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.g>, aj {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long aJS;
    private String aiB;
    private final com.baidu.tieba.frs.f cFg;
    private ArrayList<com.baidu.adp.widget.ListView.f> cIF;
    private FrsNetModel<com.baidu.tieba.frs.f> cIG;
    private d.a cII;
    private String cIJ;
    private boolean cIM;
    private int cKj;
    private boolean cOA;
    private String cOB;
    private final SparseArray<Boolean> cOC;
    private al cOD;
    private FrsRequestData cOm;
    private final l cOn;
    private boolean cOo;
    private int cOp;
    private int cOq;
    private ao cOr;
    private boolean cOs;
    private SparseArray<ao> cOt;
    private ab cOu;
    private al cOv;
    private ArrayList<com.baidu.adp.widget.ListView.f> cOw;
    private String cOx;
    private int cOy;
    private int cOz;
    private long clc;
    private long cld;
    private long cle;
    private long clf;
    private com.baidu.tieba.tbadkCore.j cxA;
    private String cxN;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean kg(int i) {
        return this.cOC.get(i, false).booleanValue();
    }

    public void p(int i, boolean z) {
        this.cOC.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.f fVar, l lVar) {
        super(fVar.getPageContext());
        this.cxN = null;
        this.mType = 3;
        this.mPn = 1;
        this.aiB = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.cIJ = null;
        this.cKj = 1;
        this.cOp = 0;
        this.cOq = 0;
        this.cOs = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.cOt = new SparseArray<>();
        this.aJS = 0L;
        this.cIM = false;
        this.cOy = -1;
        this.cOz = -1;
        this.cOB = null;
        this.cOC = new SparseArray<>();
        this.cOD = new al() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.al
            public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
                FrsModelController.this.cOs = false;
                if (i == FrsModelController.this.cKj && FrsModelController.this.cOv != null) {
                    FrsModelController.this.cOr = arVar;
                    FrsModelController.this.b(i, i2, arVar);
                    ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.cxA.az(arrayList2);
                    if ((i == 1 || i == 5) && !FrsModelController.this.aoc()) {
                        FrsModelController.this.cxA.btA();
                        FrsModelController.this.cxA.btB();
                    }
                    FrsModelController.this.cOv.a(i, i2, arVar, arrayList);
                }
            }
        };
        this.clc = 0L;
        this.cld = 0L;
        this.cle = 0L;
        this.clf = 0L;
        if (fVar == null || lVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.cFg = fVar;
        this.cOn = lVar;
        A(this.cFg);
    }

    private void A(com.baidu.tieba.frs.f fVar) {
        this.cOu = new ab();
        this.cOu.aPy = fVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.cOu));
        this.cOu.a(this.cOD);
    }

    public void onActivityDestroy() {
        this.cIG.cancelLoadData();
    }

    public void h(Bundle bundle) {
        if (bundle != null) {
            this.cxN = bundle.getString("name");
            this.aiB = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.cOx = bundle.getString("yuelaou_locate");
            this.cOo = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.cxN)) {
            this.cxN = "";
        }
        if (TextUtils.isEmpty(this.aiB)) {
            this.aiB = "";
        }
        if (TextUtils.isEmpty(this.cOx)) {
            this.cOx = "";
        }
        this.mSource = this.aiB;
        this.cOm = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            ki(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            ki(6);
        } else {
            com.baidu.tieba.frs.smartsort.f lv = com.baidu.tieba.frs.smartsort.d.aoo().lv(this.cxN);
            if (lv != null) {
                ki(lv.cPm);
            } else {
                ki(-1);
            }
        }
        this.cOm.setSortType(Pj());
        if (this.cOy == 5) {
            this.cOm.setIsGood(1);
        } else {
            this.cOm.setIsGood(0);
        }
        this.cxA = new com.baidu.tieba.tbadkCore.j();
        this.cIG = new FrsNetModel<>(this.cFg.getPageContext(), this.cOm);
        this.cIG.a(this);
        this.cIG.setUniqueId(this.cFg.getUniqueId());
        if (this.cxN != null && this.cxN.length() > 0) {
            if (this.aiB == null || this.aiB.length() <= 0) {
                this.aiB = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.cxN);
        bundle.putString("from", this.aiB);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean aby() {
        if (this.cKj != 1) {
            kh(1);
            return true;
        } else if (this.cIG.wz()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cOm), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(Pj());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void q(int i, boolean z) {
        if (this.cxA != null && this.cxA.bsX() != null) {
            this.cxA.bsX().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cOm), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.cKj = c(this.cKj, frsRequestData);
        if (this.cKj == 1) {
            if (!this.cIG.wz()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.cOr == null) {
            this.cOr = new ao();
            this.cOr.pn = 1;
            this.cOr.forumName = this.cxN;
            if (this.cxA != null && this.cxA.aPU() != null) {
                this.cOr.forumId = this.cxA.aPU().getId();
            }
        }
        kh(i);
    }

    public void jS(int i) {
        if (this.cKj != 1) {
            kh(4);
        } else if (!this.cIG.wz()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cOm), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(Pj());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.cOn.jp(i);
        this.cIG.a(frsRequestData);
        this.mType = i;
        frsRequestData.sp(this.cFg.ajE() ? "1" : "2");
        if (this.cOA) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.kw(this.cOz)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.cOA = false;
        frsRequestData.setKw(this.cxN);
        if (com.baidu.tbadk.core.h.oT().oZ()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ac = com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst());
        int ae = com.baidu.adp.lib.util.l.ae(TbadkCoreApplication.getInst());
        float af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
        int i2 = an.vs().vu() ? 2 : 1;
        frsRequestData.setScrW(ac);
        frsRequestData.setScrH(ae);
        frsRequestData.setScrDip(af);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.cIJ);
        frsRequestData.setYuelaouLocate(this.cOx);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(t.Hl(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.f.cxV != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.f.cxV);
        }
        if (com.baidu.tieba.frs.f.cxW != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.f.cxW);
        }
        if (com.baidu.tieba.frs.f.cxX != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.f.cxX);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.g.a(this.cOy, frsRequestData);
        b(i, frsRequestData);
        a(this.cxN, frsRequestData);
        if (!kg(this.cOy)) {
            String d = com.baidu.tieba.tbadkCore.c.bsx().d(this.cxN, frsRequestData.Pj(), frsRequestData.getIsGood(), this.cOm.getCategoryId());
            this.cOB = d;
            new a(this, true, d).execute(new Object[0]);
        }
        amE();
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

    protected boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.g gVar) {
        if (gVar == null || gVar.aPU() == null || am.isEmpty(gVar.aPU().getName())) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.cKj = gVar.btb();
        }
        this.cxA.e(gVar);
        d(this.cxA);
        this.cIF = new ArrayList<>();
        if (frsRequestData != null) {
            this.cOm = frsRequestData;
            this.mPn = this.cOm.getPn();
            this.cxN = this.cOm.getKw();
            this.cFg.setForumName(this.cxN);
            this.cFg.setFrom(this.aiB);
            this.cFg.setPn(this.mPn);
            this.cFg.setFlag(this.mFlag);
        }
        if (this.cxA.getThreadList() != null) {
            this.cIF.addAll(this.cxA.getThreadList());
        }
        if (this.cKj != 1 && this.isNetFirstLoad) {
            this.cOn.a(7, false, this.cII);
        } else {
            this.cOn.a(this.mType, false, this.cII);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.cOm)) {
            aod();
        }
        this.isNetFirstLoad = false;
        if (gVar.aPU() == null || TextUtils.isEmpty(gVar.aPU().getName()) || frsRequestData == null || r.bjl().bjf() == null) {
            return true;
        }
        r.bjl().bjf().f(gVar.aPU().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.g, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.g gVar;
        d.a aVar = new d.a();
        aVar.gni = com.baidu.adp.lib.util.j.hh() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gnj = mvcSocketResponsedMessage.getDownSize();
        this.cII = aVar;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
            gVar = null;
        } else {
            gVar = mvcSocketResponsedMessage.getData();
            r3 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && gVar != null && a(r3, gVar)) {
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
        this.cFg.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.g, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.cIM) {
            this.cIM = true;
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
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.g> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.g gVar;
        d.a aVar = new d.a();
        aVar.gni = com.baidu.adp.lib.util.j.hh() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gnj = mvcHttpResponsedMessage.getDownSize();
        this.cII = aVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            gVar = null;
        } else {
            gVar = mvcHttpResponsedMessage.getData();
            r3 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && gVar != null && a(r3, gVar)) {
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
        this.cFg.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        super.registerListener(i, aVar);
    }

    private void b(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.g> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
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
        if (!this.cIM) {
            this.cIM = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void ajx() {
        if (this.cxA != null && this.cxA.aPU() != null && this.cxA.aPU().getBannerListData() != null) {
            String lastIds = this.cxA.aPU().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.cIJ = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.l.r.Gt().Gu()) {
            this.aJS = System.currentTimeMillis() - this.cFg.WI;
            m mVar = new m(i, z, responsedMessage, this.cFg.aJJ, this.cFg.createTime, this.cFg.aJR, false, this.aJS);
            this.cFg.createTime = 0L;
            this.cFg.aJJ = 0L;
            if (mVar != null) {
                mVar.Go();
            }
        }
    }

    public FrsRequestData anN() {
        return this.cOm;
    }

    public String anO() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.cxN;
    }

    public int getPn() {
        return this.mPn;
    }

    public com.baidu.tieba.tbadkCore.j amD() {
        return this.cxA;
    }

    public d.a anP() {
        return this.cII;
    }

    private void amE() {
        this.clc = System.currentTimeMillis();
        this.cIG.Fr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.g gVar) {
        this.isCacheFirstLoad = false;
        this.cxA.e(gVar);
        d(this.cxA);
        this.cIF = new ArrayList<>();
        if (this.cxA.getThreadList() != null) {
            this.cIF.addAll(this.cxA.getThreadList());
        }
        this.cOn.b(gVar);
    }

    private void d(com.baidu.tieba.tbadkCore.j jVar) {
        if (com.baidu.tieba.frs.g.f.h(jVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.g.f.i(jVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.g, Void> {
        private String cOH;
        private FrsModelController cOI;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.cOH = null;
            this.cOH = str;
            this.cOI = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bsx().sn(this.cOH)) {
                if (!com.baidu.tieba.tbadkCore.c.bsx().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.cOH)) {
                    com.baidu.tieba.tbadkCore.c.bsx().getResponseData().aPU().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.g responseData = com.baidu.tieba.tbadkCore.c.bsx().getResponseData();
                if (responseData.btd() != null && !StringUtils.isNull(responseData.btd().pJ(), true) && !responseData.btd().pJ().equals("0") && responseData.btd().pK() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.btd().pJ(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
                    responseData.j(Integer.valueOf(((Integer) runTask.getData()).intValue()));
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
        public void onProgressUpdate(com.baidu.tieba.tbadkCore.g... gVarArr) {
            super.onProgressUpdate(gVarArr);
            if (this.cOI != null && gVarArr != null) {
                this.cOI.d(gVarArr.length > 0 ? gVarArr[0] : null);
                this.cOI.p(this.cOI.cOy, true);
            }
        }
    }

    public long afw() {
        return this.clf;
    }

    public long afx() {
        return this.cld;
    }

    public long afy() {
        return this.cle;
    }

    public long afz() {
        return this.clc;
    }

    public boolean wz() {
        return this.cIG.wz();
    }

    public int anQ() {
        return this.cOq;
    }

    private void anR() {
        if (this.cOw == null) {
            this.cOw = new ArrayList<>();
        }
        if (this.cOw.size() == 0) {
            this.cOw.add(new w());
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void a(int i, int i2, ao aoVar) {
        this.cKj = c(i, null);
        if (aoVar == null && (aoVar = aK(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.hy() && this.cOv != null) {
                ar arVar = new ar();
                arVar.hasMore = false;
                arVar.pn = 1;
                arVar.forumName = this.cxN;
                arVar.cBm = false;
                if (this.cxA != null && this.cxA.aPU() != null) {
                    arVar.forumId = this.cxA.aPU().getId();
                }
                anR();
                this.cxA.az(this.cOw);
                this.cOv.a(i, i2, arVar, this.cOw);
            }
            aoVar = new ao();
            aoVar.pn = -1;
        }
        if (this.cxA != null && this.cxA.aPU() != null) {
            aoVar.forumId = this.cxA.aPU().getId();
        }
        aoVar.forumName = this.cxN;
        if (z.aks().jv(1) != null && this.cKj == 1) {
            this.cOm.setCategoryId(i2);
        }
        this.cOp = i2;
        this.cOr = aoVar;
        b(i, i2, aoVar);
        kh(5);
    }

    @Override // com.baidu.tieba.frs.aj
    public void a(al alVar) {
        this.cOv = alVar;
        this.cOu.a(this.cOD);
    }

    private void kh(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.cOr != null) {
                    this.cOr.pn++;
                    break;
                }
                break;
            case 2:
                if (this.cOr != null) {
                    ao aoVar = this.cOr;
                    aoVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.cOr != null) {
                    this.cOr.pn = -1;
                    break;
                }
                break;
        }
        if (this.cKj == 1) {
            if (this.cOq == this.cOp) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                if (this.cIF != null) {
                    arrayList.addAll(this.cIF);
                }
                this.cxA.az(arrayList);
                if (this.cOv != null) {
                    this.cOv.a(this.cKj, this.cOp, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.cOq = this.cOp;
            return;
        }
        aj jw = this.cOu.jw(this.cKj);
        if (jw != null) {
            this.cOs = true;
            jw.a(this.cKj, this.cOp, this.cOr);
            return;
        }
        if (this.cxA != null && this.cxA.getThreadList() != null) {
            this.cxA.getThreadList().clear();
        }
        this.cOv.a(this.cKj, this.cOp, null, null);
    }

    public boolean hasMore() {
        if ((this.cOr instanceof ar) && ((ar) this.cOr).errCode == 0) {
            return ((ar) this.cOr).hasMore;
        }
        return true;
    }

    private int aJ(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ao aoVar) {
        this.cOt.put(aJ(i, i2), aoVar);
    }

    public ao aK(int i, int i2) {
        return this.cOt.get(aJ(i, i2));
    }

    @Override // com.baidu.tieba.frs.aj
    public void init() {
        this.cOu.init();
    }

    @Override // com.baidu.tieba.frs.aj
    public void PA() {
        this.cOu.destory();
        this.cOu.clear();
    }

    public int anS() {
        return this.cKj;
    }

    public boolean anT() {
        return 1 == this.cKj;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(com.baidu.tbadk.core.data.am amVar) {
        if (amVar != null && !StringUtils.isNull(amVar.getId()) && this.cIF != null) {
            if (this.cKj == 1) {
                this.cxA.a(amVar);
            }
            int anU = anU();
            if (this.cIF != null && this.cIF.size() > 0) {
                int size = this.cIF.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.f fVar = this.cIF.get(i);
                    if ((fVar instanceof bh) && amVar.getId().equals(((bh) fVar).getId())) {
                        return;
                    }
                }
            }
            if (amVar.getThreadType() == 33) {
                av avVar = new av();
                avVar.a(amVar, -1);
                avVar.setPost_num(1);
                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.cIF.add(anU, avVar);
                    return;
                }
                return;
            }
            this.cIF.add(anU, amVar);
        }
    }

    public int anU() {
        int i = 0;
        if (this.cIF == null || this.cIF.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.cIF.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (!(next instanceof bh)) {
                    i = i2;
                } else if (((bh) next).ro() != 0) {
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

    public boolean anV() {
        return this.cOs;
    }

    public void anW() {
        k kVar = new k();
        if (this.cOq == 0) {
            kVar.ju(this.cOy);
        }
        if (this.cxA.getThreadList() != null) {
            this.cxA.getThreadList().clear();
            this.cxA.getThreadList().add(kVar);
        }
        if (this.cIF != null) {
            this.cIF.clear();
            this.cIF.add(kVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> anX() {
        return this.cIF;
    }

    public void ki(int i) {
        this.cOy = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.f.bvC();
        } else {
            com.baidu.tieba.tbadkCore.util.f.bvD();
        }
    }

    public void kj(int i) {
        this.cOz = i;
    }

    public void fg(boolean z) {
        this.cOA = z;
    }

    public int anY() {
        return this.cOy;
    }

    public int Pj() {
        return com.baidu.tieba.frs.f.g.kw(this.cOy);
    }

    public boolean anZ() {
        return this.cOo;
    }

    public boolean aoa() {
        return this.cOy == 5;
    }

    public boolean aob() {
        return this.cOm != null && this.cOm.getLoadType() == 1;
    }

    public boolean aoc() {
        return this.cOy == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.cFg.ajb() != null) {
            return this.cFg.ajb().a(this.cOy, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bh.Yx.get() && r.bjl().bjf() != null) {
            int S = r.bjl().bjf().S(str, false);
            int T = r.bjl().bjf().T(str, false);
            if (frsRequestData.getLoadType() == 1) {
                S++;
            } else if (frsRequestData.getLoadType() == 2) {
                T++;
            }
            frsRequestData.setRefreshCount(S);
            frsRequestData.setLoadCount(T);
        }
    }

    public void aod() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.cxA != null && this.cxA.aPU() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.cxA.aPU().getId(), 0L));
        }
        this.cFg.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void lo(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bsx().bZ(FrsModelController.this.cOB, str);
                return null;
            }
        }, null);
    }

    public void lp(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bsx().ca(FrsModelController.this.cOB, str);
                return null;
            }
        }, null);
    }
}
