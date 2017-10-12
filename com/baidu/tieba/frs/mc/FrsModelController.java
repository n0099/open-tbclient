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
    private long aJn;
    private String aiq;
    private ArrayList<com.baidu.adp.widget.ListView.f> cAJ;
    private FrsNetModel<com.baidu.tieba.frs.f> cAK;
    private d.a cAM;
    private String cAN;
    private boolean cAQ;
    private int cCm;
    private FrsRequestData cER;
    private final k cES;
    private boolean cET;
    private int cEU;
    private int cEV;
    private ao cEW;
    private boolean cEX;
    private SparseArray<ao> cEY;
    private ab cEZ;
    private al cFa;
    private ArrayList<com.baidu.adp.widget.ListView.f> cFb;
    private String cFc;
    private int cFd;
    private int cFe;
    private boolean cFf;
    private String cFg;
    private final SparseArray<Boolean> cFh;
    private al cFi;
    private long cdA;
    private long cdB;
    private long cdC;
    private long cdD;
    private com.baidu.tieba.tbadkCore.i cpZ;
    private String cqm;
    private final com.baidu.tieba.frs.f cxi;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean jL(int i) {
        return this.cFh.get(i, false).booleanValue();
    }

    public void n(int i, boolean z) {
        this.cFh.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.f fVar, k kVar) {
        super(fVar.getPageContext());
        this.cqm = null;
        this.mType = 3;
        this.mPn = 1;
        this.aiq = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.cAN = null;
        this.cCm = 1;
        this.cEU = 0;
        this.cEV = 0;
        this.cEX = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.cEY = new SparseArray<>();
        this.aJn = 0L;
        this.cAQ = false;
        this.cFd = -1;
        this.cFe = -1;
        this.cFg = null;
        this.cFh = new SparseArray<>();
        this.cFi = new al() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.al
            public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
                FrsModelController.this.cEX = false;
                if (i == FrsModelController.this.cCm && FrsModelController.this.cFa != null) {
                    FrsModelController.this.cEW = arVar;
                    FrsModelController.this.b(i, i2, arVar);
                    ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.cpZ.az(arrayList2);
                    if ((i == 1 || i == 5) && !FrsModelController.this.alh()) {
                        FrsModelController.this.cpZ.bqq();
                        FrsModelController.this.cpZ.bqr();
                    }
                    FrsModelController.this.cFa.a(i, i2, arVar, arrayList);
                }
            }
        };
        this.cdA = 0L;
        this.cdB = 0L;
        this.cdC = 0L;
        this.cdD = 0L;
        if (fVar == null || kVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.cxi = fVar;
        this.cES = kVar;
        A(this.cxi);
    }

    private void A(com.baidu.tieba.frs.f fVar) {
        this.cEZ = new ab();
        this.cEZ.aPx = fVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.cEZ));
        this.cEZ.a(this.cFi);
    }

    public void onActivityDestroy() {
        this.cAK.cancelLoadData();
    }

    public void i(Bundle bundle) {
        if (bundle != null) {
            this.cqm = bundle.getString("name");
            this.aiq = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.cFc = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.cET = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.cqm)) {
            this.cqm = "";
        }
        if (TextUtils.isEmpty(this.aiq)) {
            this.aiq = "";
        }
        if (TextUtils.isEmpty(this.cFc)) {
            this.cFc = "";
        }
        this.mSource = this.aiq;
        this.cER = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            jN(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            jN(6);
        } else {
            com.baidu.tieba.frs.smartsort.f kT = com.baidu.tieba.frs.smartsort.d.alt().kT(this.cqm);
            if (kT != null) {
                jN(kT.cFR);
            } else {
                jN(-1);
            }
        }
        this.cER.setSortType(OZ());
        if (this.cFd == 5) {
            this.cER.setIsGood(1);
        } else {
            this.cER.setIsGood(0);
        }
        this.cpZ = new com.baidu.tieba.tbadkCore.i();
        this.cAK = new FrsNetModel<>(this.cxi.getPageContext(), this.cER);
        this.cAK.a(this);
        this.cAK.setUniqueId(this.cxi.getUniqueId());
        if (this.cqm != null && this.cqm.length() > 0) {
            if (this.aiq == null || this.aiq.length() <= 0) {
                this.aiq = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.cqm);
        bundle.putString("from", this.aiq);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean Zg() {
        if (this.cCm != 1) {
            jM(1);
            return true;
        } else if (this.cAK.wz()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cER), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(OZ());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void o(int i, boolean z) {
        if (this.cpZ != null && this.cpZ.bpP() != null) {
            this.cpZ.bpP().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cER), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.cCm = c(this.cCm, frsRequestData);
        if (this.cCm == 1) {
            if (!this.cAK.wz()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.cEW == null) {
            this.cEW = new ao();
            this.cEW.pn = 1;
            this.cEW.forumName = this.cqm;
            if (this.cpZ != null && this.cpZ.aMZ() != null) {
                this.cEW.forumId = this.cpZ.aMZ().getId();
            }
        }
        jM(i);
    }

    public void jC(int i) {
        if (this.cCm != 1) {
            jM(4);
        } else if (!this.cAK.wz()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cER), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(OZ());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.cES.jb(i);
        this.cAK.a(frsRequestData);
        this.mType = i;
        frsRequestData.rC(this.cxi.ahn() ? "1" : "2");
        if (this.cFf) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.g.g.kb(this.cFe)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.cFf = false;
        frsRequestData.setKw(this.cqm);
        if (com.baidu.tbadk.core.h.oT().oZ()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ad = l.ad(TbadkCoreApplication.getInst());
        int af = l.af(TbadkCoreApplication.getInst());
        float ag = l.ag(TbadkCoreApplication.getInst());
        int i2 = an.vs().vu() ? 2 : 1;
        frsRequestData.setScrW(ad);
        frsRequestData.setScrH(af);
        frsRequestData.setScrDip(ag);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.cAN);
        frsRequestData.setYuelaouLocate(this.cFc);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(r.GU(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.f.cqu != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.f.cqu);
        }
        if (com.baidu.tieba.frs.f.cqv != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.f.cqv);
        }
        if (com.baidu.tieba.frs.f.cqw != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.f.cqw);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.g.g.a(this.cFd, frsRequestData);
        b(i, frsRequestData);
        a(this.cqm, frsRequestData);
        if (!jL(this.cFd)) {
            String d = com.baidu.tieba.tbadkCore.c.bpp().d(this.cqm, frsRequestData.OZ(), frsRequestData.getIsGood(), this.cER.getCategoryId());
            this.cFg = d;
            new a(this, true, d).execute(new Object[0]);
        }
        aki();
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
        if (gVar == null || gVar.aMZ() == null || am.isEmpty(gVar.aMZ().getName())) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.cCm = gVar.bpT();
        }
        this.cpZ.e(gVar);
        d(this.cpZ);
        this.cAJ = new ArrayList<>();
        if (frsRequestData != null) {
            this.cER = frsRequestData;
            this.mPn = this.cER.getPn();
            this.cqm = this.cER.getKw();
            this.cxi.setForumName(this.cqm);
            this.cxi.setFrom(this.aiq);
            this.cxi.setPn(this.mPn);
            this.cxi.setFlag(this.mFlag);
        }
        if (this.cpZ.getThreadList() != null) {
            this.cAJ.addAll(this.cpZ.getThreadList());
        }
        if (this.cCm != 1 && this.isNetFirstLoad) {
            this.cES.a(7, false, this.cAM);
        } else {
            this.cES.a(this.mType, false, this.cAM);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.cER)) {
            ali();
        }
        this.isNetFirstLoad = false;
        if (gVar.aMZ() == null || TextUtils.isEmpty(gVar.aMZ().getName()) || frsRequestData == null || com.baidu.tieba.recapp.r.bfT().bfN() == null) {
            return true;
        }
        com.baidu.tieba.recapp.r.bfT().bfN().g(gVar.aMZ().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.g, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.g gVar;
        d.a aVar = new d.a();
        aVar.gdI = com.baidu.adp.lib.util.j.hh() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gdJ = mvcSocketResponsedMessage.getDownSize();
        this.cAM = aVar;
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
        this.cxi.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.g, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.cAQ) {
            this.cAQ = true;
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
        aVar.gdI = com.baidu.adp.lib.util.j.hh() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gdJ = mvcHttpResponsedMessage.getDownSize();
        this.cAM = aVar;
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
        this.cxi.a(errorData);
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
        if (!this.cAQ) {
            this.cAQ = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void ahg() {
        if (this.cpZ != null && this.cpZ.aMZ() != null && this.cpZ.aMZ().getBannerListData() != null) {
            String lastIds = this.cpZ.aMZ().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.cAN = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.k.r.Gc().Gd()) {
            this.aJn = System.currentTimeMillis() - this.cxi.WC;
            m mVar = new m(i, z, responsedMessage, this.cxi.aJe, this.cxi.createTime, this.cxi.aJm, false, this.aJn);
            this.cxi.createTime = 0L;
            this.cxi.aJe = 0L;
            if (mVar != null) {
                mVar.FX();
            }
        }
    }

    public FrsRequestData akS() {
        return this.cER;
    }

    public String akT() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.cqm;
    }

    public int getPn() {
        return this.mPn;
    }

    public com.baidu.tieba.tbadkCore.i akh() {
        return this.cpZ;
    }

    public d.a akU() {
        return this.cAM;
    }

    private void aki() {
        this.cdA = System.currentTimeMillis();
        this.cAK.EZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.g gVar) {
        this.isCacheFirstLoad = false;
        this.cpZ.e(gVar);
        d(this.cpZ);
        this.cAJ = new ArrayList<>();
        if (this.cpZ.getThreadList() != null) {
            this.cAJ.addAll(this.cpZ.getThreadList());
        }
        this.cES.b(gVar);
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
        private String cFm;
        private FrsModelController cFn;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.cFm = null;
            this.cFm = str;
            this.cFn = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bpp().rA(this.cFm)) {
                if (!com.baidu.tieba.tbadkCore.c.bpp().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.cFm)) {
                    com.baidu.tieba.tbadkCore.c.bpp().getResponseData().aMZ().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.g responseData = com.baidu.tieba.tbadkCore.c.bpp().getResponseData();
                if (responseData.bpV() != null && !StringUtils.isNull(responseData.bpV().pL(), true) && !responseData.bpV().pL().equals("0") && responseData.bpV().pM() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bpV().pL(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
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
            if (this.cFn != null && gVarArr != null) {
                this.cFn.d(gVarArr.length > 0 ? gVarArr[0] : null);
                this.cFn.n(this.cFn.cFd, true);
            }
        }
    }

    public long ade() {
        return this.cdD;
    }

    public long adf() {
        return this.cdB;
    }

    public long adg() {
        return this.cdC;
    }

    public long adh() {
        return this.cdA;
    }

    public boolean wz() {
        return this.cAK.wz();
    }

    public int akV() {
        return this.cEV;
    }

    private void akW() {
        if (this.cFb == null) {
            this.cFb = new ArrayList<>();
        }
        if (this.cFb.size() == 0) {
            this.cFb.add(new w());
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void a(int i, int i2, ao aoVar) {
        this.cCm = c(i, null);
        if (aoVar == null && (aoVar = aJ(i, i2)) == null) {
            if (i != 1 && l.hy() && this.cFa != null) {
                ar arVar = new ar();
                arVar.hasMore = false;
                arVar.pn = 1;
                arVar.forumName = this.cqm;
                arVar.ctK = false;
                if (this.cpZ != null && this.cpZ.aMZ() != null) {
                    arVar.forumId = this.cpZ.aMZ().getId();
                }
                akW();
                this.cpZ.az(this.cFb);
                this.cFa.a(i, i2, arVar, this.cFb);
            }
            aoVar = new ao();
            aoVar.pn = -1;
        }
        if (this.cpZ != null && this.cpZ.aMZ() != null) {
            aoVar.forumId = this.cpZ.aMZ().getId();
        }
        aoVar.forumName = this.cqm;
        if (z.aib().jh(1) != null && this.cCm == 1) {
            this.cER.setCategoryId(i2);
        }
        this.cEU = i2;
        this.cEW = aoVar;
        b(i, i2, aoVar);
        jM(5);
    }

    @Override // com.baidu.tieba.frs.aj
    public void a(al alVar) {
        this.cFa = alVar;
        this.cEZ.a(this.cFi);
    }

    private void jM(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.cEW != null) {
                    this.cEW.pn++;
                    break;
                }
                break;
            case 2:
                if (this.cEW != null) {
                    ao aoVar = this.cEW;
                    aoVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.cEW != null) {
                    this.cEW.pn = -1;
                    break;
                }
                break;
        }
        if (this.cCm == 1) {
            if (this.cEV == this.cEU) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                if (this.cAJ != null) {
                    arrayList.addAll(this.cAJ);
                }
                this.cpZ.az(arrayList);
                if (this.cFa != null) {
                    this.cFa.a(this.cCm, this.cEU, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.cEV = this.cEU;
            return;
        }
        aj ji = this.cEZ.ji(this.cCm);
        if (ji != null) {
            this.cEX = true;
            ji.a(this.cCm, this.cEU, this.cEW);
            return;
        }
        if (this.cpZ != null && this.cpZ.getThreadList() != null) {
            this.cpZ.getThreadList().clear();
        }
        this.cFa.a(this.cCm, this.cEU, null, null);
    }

    public boolean hasMore() {
        if ((this.cEW instanceof ar) && ((ar) this.cEW).errCode == 0) {
            return ((ar) this.cEW).hasMore;
        }
        return true;
    }

    private int aI(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ao aoVar) {
        this.cEY.put(aI(i, i2), aoVar);
    }

    public ao aJ(int i, int i2) {
        return this.cEY.get(aI(i, i2));
    }

    @Override // com.baidu.tieba.frs.aj
    public void init() {
        this.cEZ.init();
    }

    @Override // com.baidu.tieba.frs.aj
    public void Pl() {
        this.cEZ.destory();
        this.cEZ.clear();
    }

    public int akX() {
        return this.cCm;
    }

    public boolean akY() {
        return 1 == this.cCm;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(com.baidu.tbadk.core.data.am amVar) {
        if (amVar != null && !StringUtils.isNull(amVar.getId()) && this.cAJ != null) {
            if (this.cCm == 1) {
                this.cpZ.a(amVar);
            }
            int akZ = akZ();
            if (this.cAJ != null && this.cAJ.size() > 0) {
                int size = this.cAJ.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.f fVar = this.cAJ.get(i);
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
                    this.cAJ.add(akZ, avVar);
                    return;
                }
                return;
            }
            this.cAJ.add(akZ, amVar);
        }
    }

    public int akZ() {
        int i = 0;
        if (this.cAJ == null || this.cAJ.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.cAJ.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (!(next instanceof bh)) {
                    i = i2;
                } else if (((bh) next).rq() != 0) {
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

    public boolean ala() {
        return this.cEX;
    }

    public void alb() {
        com.baidu.tieba.frs.k kVar = new com.baidu.tieba.frs.k();
        if (this.cEV == 0) {
            kVar.jg(this.cFd);
        }
        if (this.cpZ.getThreadList() != null) {
            this.cpZ.getThreadList().clear();
            this.cpZ.getThreadList().add(kVar);
        }
        if (this.cAJ != null) {
            this.cAJ.clear();
            this.cAJ.add(kVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> alc() {
        return this.cAJ;
    }

    public void jN(int i) {
        this.cFd = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.f.bst();
        } else {
            com.baidu.tieba.tbadkCore.util.f.bsu();
        }
    }

    public void jO(int i) {
        this.cFe = i;
    }

    public void fd(boolean z) {
        this.cFf = z;
    }

    public int ald() {
        return this.cFd;
    }

    public int OZ() {
        return com.baidu.tieba.frs.g.g.kb(this.cFd);
    }

    public boolean ale() {
        return this.cET;
    }

    public boolean alf() {
        return this.cFd == 5;
    }

    public boolean alg() {
        return this.cER != null && this.cER.getLoadType() == 1;
    }

    public boolean alh() {
        return this.cFd == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.cxi.agL() != null) {
            return this.cxi.agL().a(this.cFd, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bh.Yr.get() && com.baidu.tieba.recapp.r.bfT().bfN() != null) {
            int U = com.baidu.tieba.recapp.r.bfT().bfN().U(str, false);
            int V = com.baidu.tieba.recapp.r.bfT().bfN().V(str, false);
            if (frsRequestData.getLoadType() == 1) {
                U++;
            } else if (frsRequestData.getLoadType() == 2) {
                V++;
            }
            frsRequestData.setRefreshCount(U);
            frsRequestData.setLoadCount(V);
        }
    }

    public void ali() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.cpZ != null && this.cpZ.aMZ() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.cpZ.aMZ().getId(), 0L));
        }
        this.cxi.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void kM(final String str) {
        t.a(new s<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.s
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bpp().bZ(FrsModelController.this.cFg, str);
                return null;
            }
        }, null);
    }

    public void kN(final String str) {
        t.a(new s<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.s
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bpp().ca(FrsModelController.this.cFg, str);
                return null;
            }
        }, null);
    }
}
