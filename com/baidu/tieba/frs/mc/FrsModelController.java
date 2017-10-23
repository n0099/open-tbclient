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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.k.m;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.k;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.g>, aj {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long aJa;
    private String aie;
    private d.a cAA;
    private String cAB;
    private boolean cAE;
    private ArrayList<com.baidu.adp.widget.ListView.f> cAx;
    private FrsNetModel<com.baidu.tieba.frs.f> cAy;
    private int cCa;
    private FrsRequestData cEF;
    private final k cEG;
    private boolean cEH;
    private int cEI;
    private int cEJ;
    private ao cEK;
    private boolean cEL;
    private SparseArray<ao> cEM;
    private ab cEN;
    private al cEO;
    private ArrayList<com.baidu.adp.widget.ListView.f> cEP;
    private String cEQ;
    private int cER;
    private int cES;
    private boolean cET;
    private String cEU;
    private final SparseArray<Boolean> cEV;
    private al cEW;
    private long cdo;
    private long cdp;
    private long cdq;
    private long cdr;
    private com.baidu.tieba.tbadkCore.i cpN;
    private String cqa;
    private final com.baidu.tieba.frs.f cwW;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean jK(int i) {
        return this.cEV.get(i, false).booleanValue();
    }

    public void n(int i, boolean z) {
        this.cEV.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.f fVar, k kVar) {
        super(fVar.getPageContext());
        this.cqa = null;
        this.mType = 3;
        this.mPn = 1;
        this.aie = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.cAB = null;
        this.cCa = 1;
        this.cEI = 0;
        this.cEJ = 0;
        this.cEL = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.cEM = new SparseArray<>();
        this.aJa = 0L;
        this.cAE = false;
        this.cER = -1;
        this.cES = -1;
        this.cEU = null;
        this.cEV = new SparseArray<>();
        this.cEW = new al() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.al
            public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
                FrsModelController.this.cEL = false;
                if (i == FrsModelController.this.cCa && FrsModelController.this.cEO != null) {
                    FrsModelController.this.cEK = arVar;
                    FrsModelController.this.b(i, i2, arVar);
                    ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.cpN.az(arrayList2);
                    if ((i == 1 || i == 5) && !FrsModelController.this.alc()) {
                        FrsModelController.this.cpN.bqj();
                        FrsModelController.this.cpN.bqk();
                    }
                    FrsModelController.this.cEO.a(i, i2, arVar, arrayList);
                }
            }
        };
        this.cdo = 0L;
        this.cdp = 0L;
        this.cdq = 0L;
        this.cdr = 0L;
        if (fVar == null || kVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.cwW = fVar;
        this.cEG = kVar;
        A(this.cwW);
    }

    private void A(com.baidu.tieba.frs.f fVar) {
        this.cEN = new ab();
        this.cEN.aPk = fVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.cEN));
        this.cEN.a(this.cEW);
    }

    public void onActivityDestroy() {
        this.cAy.cancelLoadData();
    }

    public void i(Bundle bundle) {
        if (bundle != null) {
            this.cqa = bundle.getString("name");
            this.aie = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.cEQ = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.cEH = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.cqa)) {
            this.cqa = "";
        }
        if (TextUtils.isEmpty(this.aie)) {
            this.aie = "";
        }
        if (TextUtils.isEmpty(this.cEQ)) {
            this.cEQ = "";
        }
        this.mSource = this.aie;
        this.cEF = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            jM(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            jM(6);
        } else {
            com.baidu.tieba.frs.smartsort.f kS = com.baidu.tieba.frs.smartsort.d.alo().kS(this.cqa);
            if (kS != null) {
                jM(kS.cFF);
            } else {
                jM(-1);
            }
        }
        this.cEF.setSortType(OT());
        if (this.cER == 5) {
            this.cEF.setIsGood(1);
        } else {
            this.cEF.setIsGood(0);
        }
        this.cpN = new com.baidu.tieba.tbadkCore.i();
        this.cAy = new FrsNetModel<>(this.cwW.getPageContext(), this.cEF);
        this.cAy.a(this);
        this.cAy.setUniqueId(this.cwW.getUniqueId());
        if (this.cqa != null && this.cqa.length() > 0) {
            if (this.aie == null || this.aie.length() <= 0) {
                this.aie = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.cqa);
        bundle.putString("from", this.aie);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean Zc() {
        if (this.cCa != 1) {
            jL(1);
            return true;
        } else if (this.cAy.ws()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cEF), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(OT());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void o(int i, boolean z) {
        if (this.cpN != null && this.cpN.bpI() != null) {
            this.cpN.bpI().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cEF), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.cCa = c(this.cCa, frsRequestData);
        if (this.cCa == 1) {
            if (!this.cAy.ws()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.cEK == null) {
            this.cEK = new ao();
            this.cEK.pn = 1;
            this.cEK.forumName = this.cqa;
            if (this.cpN != null && this.cpN.aMU() != null) {
                this.cEK.forumId = this.cpN.aMU().getId();
            }
        }
        jL(i);
    }

    public void jB(int i) {
        if (this.cCa != 1) {
            jL(4);
        } else if (!this.cAy.ws()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cEF), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(OT());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.cEG.ja(i);
        this.cAy.a(frsRequestData);
        this.mType = i;
        frsRequestData.rB(this.cwW.ahi() ? "1" : "2");
        if (this.cET) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.g.g.ka(this.cES)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.cET = false;
        frsRequestData.setKw(this.cqa);
        if (com.baidu.tbadk.core.h.oM().oS()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ad = l.ad(TbadkCoreApplication.getInst());
        int af = l.af(TbadkCoreApplication.getInst());
        float ag = l.ag(TbadkCoreApplication.getInst());
        int i2 = an.vl().vn() ? 2 : 1;
        frsRequestData.setScrW(ad);
        frsRequestData.setScrH(af);
        frsRequestData.setScrDip(ag);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.cAB);
        frsRequestData.setYuelaouLocate(this.cEQ);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(r.GO(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.f.cqi != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.f.cqi);
        }
        if (com.baidu.tieba.frs.f.cqj != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.f.cqj);
        }
        if (com.baidu.tieba.frs.f.cqk != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.f.cqk);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.g.g.a(this.cER, frsRequestData);
        b(i, frsRequestData);
        a(this.cqa, frsRequestData);
        if (!jK(this.cER)) {
            String d = com.baidu.tieba.tbadkCore.c.bpi().d(this.cqa, frsRequestData.OT(), frsRequestData.getIsGood(), this.cEF.getCategoryId());
            this.cEU = d;
            new a(this, true, d).execute(new Object[0]);
        }
        akd();
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
        if (gVar == null || gVar.aMU() == null || am.isEmpty(gVar.aMU().getName())) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.cCa = gVar.bpM();
        }
        this.cpN.e(gVar);
        d(this.cpN);
        this.cAx = new ArrayList<>();
        if (frsRequestData != null) {
            this.cEF = frsRequestData;
            this.mPn = this.cEF.getPn();
            this.cqa = this.cEF.getKw();
            this.cwW.setForumName(this.cqa);
            this.cwW.setFrom(this.aie);
            this.cwW.setPn(this.mPn);
            this.cwW.setFlag(this.mFlag);
        }
        if (this.cpN.getThreadList() != null) {
            this.cAx.addAll(this.cpN.getThreadList());
        }
        if (this.cCa != 1 && this.isNetFirstLoad) {
            this.cEG.a(7, false, this.cAA);
        } else {
            this.cEG.a(this.mType, false, this.cAA);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.cEF)) {
            ald();
        }
        this.isNetFirstLoad = false;
        if (gVar.aMU() == null || TextUtils.isEmpty(gVar.aMU().getName()) || frsRequestData == null || com.baidu.tieba.recapp.r.bfO().bfI() == null) {
            return true;
        }
        com.baidu.tieba.recapp.r.bfO().bfI().g(gVar.aMU().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.g, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.g gVar;
        d.a aVar = new d.a();
        aVar.gdu = com.baidu.adp.lib.util.j.hh() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gdv = mvcSocketResponsedMessage.getDownSize();
        this.cAA = aVar;
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
        this.cwW.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.g, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.cAE) {
            this.cAE = true;
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
        aVar.gdu = com.baidu.adp.lib.util.j.hh() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gdv = mvcHttpResponsedMessage.getDownSize();
        this.cAA = aVar;
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
        this.cwW.a(errorData);
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
        if (!this.cAE) {
            this.cAE = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void ahb() {
        if (this.cpN != null && this.cpN.aMU() != null && this.cpN.aMU().getBannerListData() != null) {
            String lastIds = this.cpN.aMU().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.cAB = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.k.r.FW().FX()) {
            this.aJa = System.currentTimeMillis() - this.cwW.Wq;
            m mVar = new m(i, z, responsedMessage, this.cwW.aIR, this.cwW.createTime, this.cwW.aIZ, false, this.aJa);
            this.cwW.createTime = 0L;
            this.cwW.aIR = 0L;
            if (mVar != null) {
                mVar.FR();
            }
        }
    }

    public FrsRequestData akN() {
        return this.cEF;
    }

    public String akO() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.cqa;
    }

    public int getPn() {
        return this.mPn;
    }

    public com.baidu.tieba.tbadkCore.i akc() {
        return this.cpN;
    }

    public d.a akP() {
        return this.cAA;
    }

    private void akd() {
        this.cdo = System.currentTimeMillis();
        this.cAy.ET();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.g gVar) {
        this.isCacheFirstLoad = false;
        this.cpN.e(gVar);
        d(this.cpN);
        this.cAx = new ArrayList<>();
        if (this.cpN.getThreadList() != null) {
            this.cAx.addAll(this.cpN.getThreadList());
        }
        this.cEG.b(gVar);
    }

    private void d(com.baidu.tieba.tbadkCore.i iVar) {
        if (com.baidu.tieba.frs.h.f.h(iVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.h.f.i(iVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.g, Void> {
        private String cFa;
        private FrsModelController cFb;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.cFa = null;
            this.cFa = str;
            this.cFb = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bpi().rz(this.cFa)) {
                if (!com.baidu.tieba.tbadkCore.c.bpi().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.cFa)) {
                    com.baidu.tieba.tbadkCore.c.bpi().getResponseData().aMU().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.g responseData = com.baidu.tieba.tbadkCore.c.bpi().getResponseData();
                if (responseData.bpO() != null && !StringUtils.isNull(responseData.bpO().pE(), true) && !responseData.bpO().pE().equals("0") && responseData.bpO().pF() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bpO().pE(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
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
            if (this.cFb != null && gVarArr != null) {
                this.cFb.d(gVarArr.length > 0 ? gVarArr[0] : null);
                this.cFb.n(this.cFb.cER, true);
            }
        }
    }

    public long ada() {
        return this.cdr;
    }

    public long adb() {
        return this.cdp;
    }

    public long adc() {
        return this.cdq;
    }

    public long add() {
        return this.cdo;
    }

    public boolean ws() {
        return this.cAy.ws();
    }

    public int akQ() {
        return this.cEJ;
    }

    private void akR() {
        if (this.cEP == null) {
            this.cEP = new ArrayList<>();
        }
        if (this.cEP.size() == 0) {
            this.cEP.add(new w());
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void a(int i, int i2, ao aoVar) {
        this.cCa = c(i, null);
        if (aoVar == null && (aoVar = aJ(i, i2)) == null) {
            if (i != 1 && l.hy() && this.cEO != null) {
                ar arVar = new ar();
                arVar.hasMore = false;
                arVar.pn = 1;
                arVar.forumName = this.cqa;
                arVar.cty = false;
                if (this.cpN != null && this.cpN.aMU() != null) {
                    arVar.forumId = this.cpN.aMU().getId();
                }
                akR();
                this.cpN.az(this.cEP);
                this.cEO.a(i, i2, arVar, this.cEP);
            }
            aoVar = new ao();
            aoVar.pn = -1;
        }
        if (this.cpN != null && this.cpN.aMU() != null) {
            aoVar.forumId = this.cpN.aMU().getId();
        }
        aoVar.forumName = this.cqa;
        if (z.ahW().jg(1) != null && this.cCa == 1) {
            this.cEF.setCategoryId(i2);
        }
        this.cEI = i2;
        this.cEK = aoVar;
        b(i, i2, aoVar);
        jL(5);
    }

    @Override // com.baidu.tieba.frs.aj
    public void a(al alVar) {
        this.cEO = alVar;
        this.cEN.a(this.cEW);
    }

    private void jL(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.cEK != null) {
                    this.cEK.pn++;
                    break;
                }
                break;
            case 2:
                if (this.cEK != null) {
                    ao aoVar = this.cEK;
                    aoVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.cEK != null) {
                    this.cEK.pn = -1;
                    break;
                }
                break;
        }
        if (this.cCa == 1) {
            if (this.cEJ == this.cEI) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                if (this.cAx != null) {
                    arrayList.addAll(this.cAx);
                }
                this.cpN.az(arrayList);
                if (this.cEO != null) {
                    this.cEO.a(this.cCa, this.cEI, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.cEJ = this.cEI;
            return;
        }
        aj jh = this.cEN.jh(this.cCa);
        if (jh != null) {
            this.cEL = true;
            jh.a(this.cCa, this.cEI, this.cEK);
            return;
        }
        if (this.cpN != null && this.cpN.getThreadList() != null) {
            this.cpN.getThreadList().clear();
        }
        this.cEO.a(this.cCa, this.cEI, null, null);
    }

    public boolean hasMore() {
        if ((this.cEK instanceof ar) && ((ar) this.cEK).errCode == 0) {
            return ((ar) this.cEK).hasMore;
        }
        return true;
    }

    private int aI(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ao aoVar) {
        this.cEM.put(aI(i, i2), aoVar);
    }

    public ao aJ(int i, int i2) {
        return this.cEM.get(aI(i, i2));
    }

    @Override // com.baidu.tieba.frs.aj
    public void init() {
        this.cEN.init();
    }

    @Override // com.baidu.tieba.frs.aj
    public void Pf() {
        this.cEN.destory();
        this.cEN.clear();
    }

    public int akS() {
        return this.cCa;
    }

    public boolean akT() {
        return 1 == this.cCa;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(com.baidu.tbadk.core.data.am amVar) {
        if (amVar != null && !StringUtils.isNull(amVar.getId()) && this.cAx != null) {
            if (this.cCa == 1) {
                this.cpN.a(amVar);
            }
            int akU = akU();
            if (this.cAx != null && this.cAx.size() > 0) {
                int size = this.cAx.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.f fVar = this.cAx.get(i);
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
                    this.cAx.add(akU, avVar);
                    return;
                }
                return;
            }
            this.cAx.add(akU, amVar);
        }
    }

    public int akU() {
        int i = 0;
        if (this.cAx == null || this.cAx.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.cAx.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (!(next instanceof bh)) {
                    i = i2;
                } else if (((bh) next).rj() != 0) {
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

    public boolean akV() {
        return this.cEL;
    }

    public void akW() {
        com.baidu.tieba.frs.k kVar = new com.baidu.tieba.frs.k();
        if (this.cEJ == 0) {
            kVar.jf(this.cER);
        }
        if (this.cpN.getThreadList() != null) {
            this.cpN.getThreadList().clear();
            this.cpN.getThreadList().add(kVar);
        }
        if (this.cAx != null) {
            this.cAx.clear();
            this.cAx.add(kVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> akX() {
        return this.cAx;
    }

    public void jM(int i) {
        this.cER = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.f.bsm();
        } else {
            com.baidu.tieba.tbadkCore.util.f.bsn();
        }
    }

    public void jN(int i) {
        this.cES = i;
    }

    public void fc(boolean z) {
        this.cET = z;
    }

    public int akY() {
        return this.cER;
    }

    public int OT() {
        return com.baidu.tieba.frs.g.g.ka(this.cER);
    }

    public boolean akZ() {
        return this.cEH;
    }

    public boolean ala() {
        return this.cER == 5;
    }

    public boolean alb() {
        return this.cEF != null && this.cEF.getLoadType() == 1;
    }

    public boolean alc() {
        return this.cER == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.cwW.agG() != null) {
            return this.cwW.agG().a(this.cER, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bh.Yf.get() && com.baidu.tieba.recapp.r.bfO().bfI() != null) {
            int U = com.baidu.tieba.recapp.r.bfO().bfI().U(str, false);
            int V = com.baidu.tieba.recapp.r.bfO().bfI().V(str, false);
            if (frsRequestData.getLoadType() == 1) {
                U++;
            } else if (frsRequestData.getLoadType() == 2) {
                V++;
            }
            frsRequestData.setRefreshCount(U);
            frsRequestData.setLoadCount(V);
        }
    }

    public void ald() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.cpN != null && this.cpN.aMU() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.cpN.aMU().getId(), 0L));
        }
        this.cwW.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void kL(final String str) {
        t.a(new s<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.s
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bpi().bY(FrsModelController.this.cEU, str);
                return null;
            }
        }, null);
    }

    public void kM(final String str) {
        t.a(new s<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.s
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bpi().bZ(FrsModelController.this.cEU, str);
                return null;
            }
        }, null);
    }
}
