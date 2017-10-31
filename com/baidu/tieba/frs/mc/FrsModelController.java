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
    private long aJK;
    private String aiB;
    private final com.baidu.tieba.frs.f cEN;
    private ArrayList<com.baidu.adp.widget.ListView.f> cIm;
    private FrsNetModel<com.baidu.tieba.frs.f> cIn;
    private d.a cIp;
    private String cIq;
    private boolean cIt;
    private int cJQ;
    private FrsRequestData cNS;
    private final l cNT;
    private boolean cNU;
    private int cNV;
    private int cNW;
    private ao cNX;
    private boolean cNY;
    private SparseArray<ao> cNZ;
    private ab cOa;
    private al cOb;
    private ArrayList<com.baidu.adp.widget.ListView.f> cOc;
    private String cOd;
    private int cOe;
    private int cOf;
    private boolean cOg;
    private String cOh;
    private final SparseArray<Boolean> cOi;
    private al cOj;
    private long ckJ;
    private long ckK;
    private long ckL;
    private long ckM;
    private com.baidu.tieba.tbadkCore.j cxh;
    private String cxu;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean kg(int i) {
        return this.cOi.get(i, false).booleanValue();
    }

    public void o(int i, boolean z) {
        this.cOi.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.f fVar, l lVar) {
        super(fVar.getPageContext());
        this.cxu = null;
        this.mType = 3;
        this.mPn = 1;
        this.aiB = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.cIq = null;
        this.cJQ = 1;
        this.cNV = 0;
        this.cNW = 0;
        this.cNY = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.cNZ = new SparseArray<>();
        this.aJK = 0L;
        this.cIt = false;
        this.cOe = -1;
        this.cOf = -1;
        this.cOh = null;
        this.cOi = new SparseArray<>();
        this.cOj = new al() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.al
            public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
                FrsModelController.this.cNY = false;
                if (i == FrsModelController.this.cJQ && FrsModelController.this.cOb != null) {
                    FrsModelController.this.cNX = arVar;
                    FrsModelController.this.b(i, i2, arVar);
                    ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.cxh.az(arrayList2);
                    if ((i == 1 || i == 5) && !FrsModelController.this.anN()) {
                        FrsModelController.this.cxh.bto();
                        FrsModelController.this.cxh.btp();
                    }
                    FrsModelController.this.cOb.a(i, i2, arVar, arrayList);
                }
            }
        };
        this.ckJ = 0L;
        this.ckK = 0L;
        this.ckL = 0L;
        this.ckM = 0L;
        if (fVar == null || lVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.cEN = fVar;
        this.cNT = lVar;
        A(this.cEN);
    }

    private void A(com.baidu.tieba.frs.f fVar) {
        this.cOa = new ab();
        this.cOa.aPq = fVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.cOa));
        this.cOa.a(this.cOj);
    }

    public void onActivityDestroy() {
        this.cIn.cancelLoadData();
    }

    public void h(Bundle bundle) {
        if (bundle != null) {
            this.cxu = bundle.getString("name");
            this.aiB = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.cOd = bundle.getString("yuelaou_locate");
            this.cNU = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.cxu)) {
            this.cxu = "";
        }
        if (TextUtils.isEmpty(this.aiB)) {
            this.aiB = "";
        }
        if (TextUtils.isEmpty(this.cOd)) {
            this.cOd = "";
        }
        this.mSource = this.aiB;
        this.cNS = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            ki(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            ki(6);
        } else {
            com.baidu.tieba.frs.smartsort.f lt = com.baidu.tieba.frs.smartsort.d.anZ().lt(this.cxu);
            if (lt != null) {
                ki(lt.cOS);
            } else {
                ki(-1);
            }
        }
        this.cNS.setSortType(OY());
        if (this.cOe == 5) {
            this.cNS.setIsGood(1);
        } else {
            this.cNS.setIsGood(0);
        }
        this.cxh = new com.baidu.tieba.tbadkCore.j();
        this.cIn = new FrsNetModel<>(this.cEN.getPageContext(), this.cNS);
        this.cIn.a(this);
        this.cIn.setUniqueId(this.cEN.getUniqueId());
        if (this.cxu != null && this.cxu.length() > 0) {
            if (this.aiB == null || this.aiB.length() <= 0) {
                this.aiB = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.cxu);
        bundle.putString("from", this.aiB);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean abm() {
        if (this.cJQ != 1) {
            kh(1);
            return true;
        } else if (this.cIn.wz()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cNS), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(OY());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void p(int i, boolean z) {
        if (this.cxh != null && this.cxh.bsM() != null) {
            this.cxh.bsM().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cNS), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.cJQ = c(this.cJQ, frsRequestData);
        if (this.cJQ == 1) {
            if (!this.cIn.wz()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.cNX == null) {
            this.cNX = new ao();
            this.cNX.pn = 1;
            this.cNX.forumName = this.cxu;
            if (this.cxh != null && this.cxh.aPM() != null) {
                this.cNX.forumId = this.cxh.aPM().getId();
            }
        }
        kh(i);
    }

    public void jT(int i) {
        if (this.cJQ != 1) {
            kh(4);
        } else if (!this.cIn.wz()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cNS), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(OY());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.cNT.jq(i);
        this.cIn.a(frsRequestData);
        this.mType = i;
        frsRequestData.sj(this.cEN.ajq() ? "1" : "2");
        if (this.cOg) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.kw(this.cOf)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.cOg = false;
        frsRequestData.setKw(this.cxu);
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
        frsRequestData.setLastId(this.cIq);
        frsRequestData.setYuelaouLocate(this.cOd);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(t.Ha(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.f.cxC != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.f.cxC);
        }
        if (com.baidu.tieba.frs.f.cxD != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.f.cxD);
        }
        if (com.baidu.tieba.frs.f.cxE != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.f.cxE);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.g.a(this.cOe, frsRequestData);
        b(i, frsRequestData);
        a(this.cxu, frsRequestData);
        if (!kg(this.cOe)) {
            String d = com.baidu.tieba.tbadkCore.c.bsm().d(this.cxu, frsRequestData.OY(), frsRequestData.getIsGood(), this.cNS.getCategoryId());
            this.cOh = d;
            new a(this, true, d).execute(new Object[0]);
        }
        amq();
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
        if (gVar == null || gVar.aPM() == null || am.isEmpty(gVar.aPM().getName())) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.cJQ = gVar.bsQ();
        }
        this.cxh.e(gVar);
        d(this.cxh);
        this.cIm = new ArrayList<>();
        if (frsRequestData != null) {
            this.cNS = frsRequestData;
            this.mPn = this.cNS.getPn();
            this.cxu = this.cNS.getKw();
            this.cEN.setForumName(this.cxu);
            this.cEN.setFrom(this.aiB);
            this.cEN.setPn(this.mPn);
            this.cEN.setFlag(this.mFlag);
        }
        if (this.cxh.getThreadList() != null) {
            this.cIm.addAll(this.cxh.getThreadList());
        }
        if (this.cJQ != 1 && this.isNetFirstLoad) {
            this.cNT.a(7, false, this.cIp);
        } else {
            this.cNT.a(this.mType, false, this.cIp);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.cNS)) {
            anO();
        }
        this.isNetFirstLoad = false;
        if (gVar.aPM() == null || TextUtils.isEmpty(gVar.aPM().getName()) || frsRequestData == null || r.bja().biU() == null) {
            return true;
        }
        r.bja().biU().f(gVar.aPM().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.g, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.g gVar;
        d.a aVar = new d.a();
        aVar.gmg = com.baidu.adp.lib.util.j.hh() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gmh = mvcSocketResponsedMessage.getDownSize();
        this.cIp = aVar;
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
        this.cEN.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.g, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.cIt) {
            this.cIt = true;
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
        aVar.gmg = com.baidu.adp.lib.util.j.hh() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gmh = mvcHttpResponsedMessage.getDownSize();
        this.cIp = aVar;
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
        this.cEN.a(errorData);
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
        if (!this.cIt) {
            this.cIt = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void ajj() {
        if (this.cxh != null && this.cxh.aPM() != null && this.cxh.aPM().getBannerListData() != null) {
            String lastIds = this.cxh.aPM().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.cIq = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.l.r.Gi().Gj()) {
            this.aJK = System.currentTimeMillis() - this.cEN.WI;
            m mVar = new m(i, z, responsedMessage, this.cEN.aJB, this.cEN.createTime, this.cEN.aJJ, false, this.aJK);
            this.cEN.createTime = 0L;
            this.cEN.aJB = 0L;
            if (mVar != null) {
                mVar.Gd();
            }
        }
    }

    public FrsRequestData any() {
        return this.cNS;
    }

    public String anz() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.cxu;
    }

    public int getPn() {
        return this.mPn;
    }

    public com.baidu.tieba.tbadkCore.j amp() {
        return this.cxh;
    }

    public d.a anA() {
        return this.cIp;
    }

    private void amq() {
        this.ckJ = System.currentTimeMillis();
        this.cIn.Ff();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.g gVar) {
        this.isCacheFirstLoad = false;
        this.cxh.e(gVar);
        d(this.cxh);
        this.cIm = new ArrayList<>();
        if (this.cxh.getThreadList() != null) {
            this.cIm.addAll(this.cxh.getThreadList());
        }
        this.cNT.b(gVar);
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
        private String cOn;
        private FrsModelController cOo;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.cOn = null;
            this.cOn = str;
            this.cOo = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bsm().sh(this.cOn)) {
                if (!com.baidu.tieba.tbadkCore.c.bsm().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.cOn)) {
                    com.baidu.tieba.tbadkCore.c.bsm().getResponseData().aPM().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.g responseData = com.baidu.tieba.tbadkCore.c.bsm().getResponseData();
                if (responseData.bsS() != null && !StringUtils.isNull(responseData.bsS().pJ(), true) && !responseData.bsS().pJ().equals("0") && responseData.bsS().pK() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bsS().pJ(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
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
            if (this.cOo != null && gVarArr != null) {
                this.cOo.d(gVarArr.length > 0 ? gVarArr[0] : null);
                this.cOo.o(this.cOo.cOe, true);
            }
        }
    }

    public long afi() {
        return this.ckM;
    }

    public long afj() {
        return this.ckK;
    }

    public long afk() {
        return this.ckL;
    }

    public long afl() {
        return this.ckJ;
    }

    public boolean wz() {
        return this.cIn.wz();
    }

    public int anB() {
        return this.cNW;
    }

    private void anC() {
        if (this.cOc == null) {
            this.cOc = new ArrayList<>();
        }
        if (this.cOc.size() == 0) {
            this.cOc.add(new w());
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void a(int i, int i2, ao aoVar) {
        this.cJQ = c(i, null);
        if (aoVar == null && (aoVar = aK(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.hy() && this.cOb != null) {
                ar arVar = new ar();
                arVar.hasMore = false;
                arVar.pn = 1;
                arVar.forumName = this.cxu;
                arVar.cAT = false;
                if (this.cxh != null && this.cxh.aPM() != null) {
                    arVar.forumId = this.cxh.aPM().getId();
                }
                anC();
                this.cxh.az(this.cOc);
                this.cOb.a(i, i2, arVar, this.cOc);
            }
            aoVar = new ao();
            aoVar.pn = -1;
        }
        if (this.cxh != null && this.cxh.aPM() != null) {
            aoVar.forumId = this.cxh.aPM().getId();
        }
        aoVar.forumName = this.cxu;
        if (z.ake().jw(1) != null && this.cJQ == 1) {
            this.cNS.setCategoryId(i2);
        }
        this.cNV = i2;
        this.cNX = aoVar;
        b(i, i2, aoVar);
        kh(5);
    }

    @Override // com.baidu.tieba.frs.aj
    public void a(al alVar) {
        this.cOb = alVar;
        this.cOa.a(this.cOj);
    }

    private void kh(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.cNX != null) {
                    this.cNX.pn++;
                    break;
                }
                break;
            case 2:
                if (this.cNX != null) {
                    ao aoVar = this.cNX;
                    aoVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.cNX != null) {
                    this.cNX.pn = -1;
                    break;
                }
                break;
        }
        if (this.cJQ == 1) {
            if (this.cNW == this.cNV) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                if (this.cIm != null) {
                    arrayList.addAll(this.cIm);
                }
                this.cxh.az(arrayList);
                if (this.cOb != null) {
                    this.cOb.a(this.cJQ, this.cNV, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.cNW = this.cNV;
            return;
        }
        aj jx = this.cOa.jx(this.cJQ);
        if (jx != null) {
            this.cNY = true;
            jx.a(this.cJQ, this.cNV, this.cNX);
            return;
        }
        if (this.cxh != null && this.cxh.getThreadList() != null) {
            this.cxh.getThreadList().clear();
        }
        this.cOb.a(this.cJQ, this.cNV, null, null);
    }

    public boolean hasMore() {
        if ((this.cNX instanceof ar) && ((ar) this.cNX).errCode == 0) {
            return ((ar) this.cNX).hasMore;
        }
        return true;
    }

    private int aJ(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ao aoVar) {
        this.cNZ.put(aJ(i, i2), aoVar);
    }

    public ao aK(int i, int i2) {
        return this.cNZ.get(aJ(i, i2));
    }

    @Override // com.baidu.tieba.frs.aj
    public void init() {
        this.cOa.init();
    }

    @Override // com.baidu.tieba.frs.aj
    public void Pp() {
        this.cOa.destory();
        this.cOa.clear();
    }

    public int anD() {
        return this.cJQ;
    }

    public boolean anE() {
        return 1 == this.cJQ;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(com.baidu.tbadk.core.data.am amVar) {
        if (amVar != null && !StringUtils.isNull(amVar.getId()) && this.cIm != null) {
            if (this.cJQ == 1) {
                this.cxh.a(amVar);
            }
            int anF = anF();
            if (this.cIm != null && this.cIm.size() > 0) {
                int size = this.cIm.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.f fVar = this.cIm.get(i);
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
                    this.cIm.add(anF, avVar);
                    return;
                }
                return;
            }
            this.cIm.add(anF, amVar);
        }
    }

    public int anF() {
        int i = 0;
        if (this.cIm == null || this.cIm.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.cIm.iterator();
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

    public boolean anG() {
        return this.cNY;
    }

    public void anH() {
        k kVar = new k();
        if (this.cNW == 0) {
            kVar.jv(this.cOe);
        }
        if (this.cxh.getThreadList() != null) {
            this.cxh.getThreadList().clear();
            this.cxh.getThreadList().add(kVar);
        }
        if (this.cIm != null) {
            this.cIm.clear();
            this.cIm.add(kVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> anI() {
        return this.cIm;
    }

    public void ki(int i) {
        this.cOe = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.f.bvq();
        } else {
            com.baidu.tieba.tbadkCore.util.f.bvr();
        }
    }

    public void kj(int i) {
        this.cOf = i;
    }

    public void fb(boolean z) {
        this.cOg = z;
    }

    public int anJ() {
        return this.cOe;
    }

    public int OY() {
        return com.baidu.tieba.frs.f.g.kw(this.cOe);
    }

    public boolean anK() {
        return this.cNU;
    }

    public boolean anL() {
        return this.cOe == 5;
    }

    public boolean anM() {
        return this.cNS != null && this.cNS.getLoadType() == 1;
    }

    public boolean anN() {
        return this.cOe == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.cEN.aiN() != null) {
            return this.cEN.aiN().a(this.cOe, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bh.Yx.get() && r.bja().biU() != null) {
            int S = r.bja().biU().S(str, false);
            int T = r.bja().biU().T(str, false);
            if (frsRequestData.getLoadType() == 1) {
                S++;
            } else if (frsRequestData.getLoadType() == 2) {
                T++;
            }
            frsRequestData.setRefreshCount(S);
            frsRequestData.setLoadCount(T);
        }
    }

    public void anO() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.cxh != null && this.cxh.aPM() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.cxh.aPM().getId(), 0L));
        }
        this.cEN.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void lm(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bsm().bV(FrsModelController.this.cOh, str);
                return null;
            }
        }, null);
    }

    public void ln(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bsm().bW(FrsModelController.this.cOh, str);
                return null;
            }
        }, null);
    }
}
