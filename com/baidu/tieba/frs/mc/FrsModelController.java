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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.l.m;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.g>, ai {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long aJP;
    private String aiP;
    private int cAB;
    private FrsRequestData cDg;
    private final com.baidu.tieba.tbadkCore.k cDh;
    private boolean cDi;
    private int cDj;
    private int cDk;
    private an cDl;
    private boolean cDm;
    private SparseArray<an> cDn;
    private aa cDo;
    private ak cDp;
    private ArrayList<com.baidu.adp.widget.ListView.f> cDq;
    private String cDr;
    private int cDs;
    private int cDt;
    private boolean cDu;
    private String cDv;
    private final SparseArray<Boolean> cDw;
    private ak cDx;
    private long ccH;
    private long ccI;
    private long ccJ;
    private long ccK;
    private com.baidu.tieba.tbadkCore.i coI;
    private String coW;
    private final com.baidu.tieba.frs.f cvA;
    private ArrayList<com.baidu.adp.widget.ListView.f> cyY;
    private FrsNetModel<com.baidu.tieba.frs.f> cyZ;
    private d.a czb;
    private String czc;
    private boolean czf;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean jB(int i) {
        return this.cDw.get(i, false).booleanValue();
    }

    public void p(int i, boolean z) {
        this.cDw.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.f fVar, com.baidu.tieba.tbadkCore.k kVar) {
        super(fVar.getPageContext());
        this.coW = null;
        this.mType = 3;
        this.mPn = 1;
        this.aiP = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.czc = null;
        this.cAB = 1;
        this.cDj = 0;
        this.cDk = 0;
        this.cDm = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.cDn = new SparseArray<>();
        this.aJP = 0L;
        this.czf = false;
        this.cDs = -1;
        this.cDt = -1;
        this.cDv = null;
        this.cDw = new SparseArray<>();
        this.cDx = new ak() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ak
            public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
                FrsModelController.this.cDm = false;
                if (i == FrsModelController.this.cAB && FrsModelController.this.cDp != null) {
                    FrsModelController.this.cDl = aqVar;
                    FrsModelController.this.b(i, i2, aqVar);
                    ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.coI.aA(arrayList2);
                    if ((i == 1 || i == 5) && !FrsModelController.this.akS()) {
                        FrsModelController.this.coI.brj();
                        FrsModelController.this.coI.brk();
                    }
                    FrsModelController.this.cDp.a(i, i2, aqVar, arrayList);
                }
            }
        };
        this.ccH = 0L;
        this.ccI = 0L;
        this.ccJ = 0L;
        this.ccK = 0L;
        if (fVar == null || kVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.cvA = fVar;
        this.cDh = kVar;
        z(this.cvA);
    }

    private void z(com.baidu.tieba.frs.f fVar) {
        this.cDo = new aa();
        this.cDo.aOx = fVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.cDo));
        this.cDo.a(this.cDx);
    }

    public void onActivityDestroy() {
        this.cyZ.cancelLoadData();
    }

    public void i(Bundle bundle) {
        if (bundle != null) {
            this.coW = bundle.getString("name");
            this.aiP = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.cDr = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.cDi = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.coW)) {
            this.coW = "";
        }
        if (TextUtils.isEmpty(this.aiP)) {
            this.aiP = "";
        }
        if (TextUtils.isEmpty(this.cDr)) {
            this.cDr = "";
        }
        this.mSource = this.aiP;
        this.cDg = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            jD(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            jD(6);
        } else {
            com.baidu.tieba.frs.smartsort.f kU = com.baidu.tieba.frs.smartsort.d.ale().kU(this.coW);
            if (kU != null) {
                jD(kU.cEg);
            } else {
                jD(-1);
            }
        }
        this.cDg.setSortType(OC());
        if (this.cDs == 5) {
            this.cDg.setIsGood(1);
        } else {
            this.cDg.setIsGood(0);
        }
        this.coI = new com.baidu.tieba.tbadkCore.i();
        this.cyZ = new FrsNetModel<>(this.cvA.getPageContext(), this.cDg);
        this.cyZ.a(this);
        this.cyZ.setUniqueId(this.cvA.getUniqueId());
        if (this.coW != null && this.coW.length() > 0) {
            if (this.aiP == null || this.aiP.length() <= 0) {
                this.aiP = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.coW);
        bundle.putString("from", this.aiP);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean Zk() {
        if (this.cAB != 1) {
            jC(1);
            return true;
        } else if (this.cyZ.xa()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cDg), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(OC());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void q(int i, boolean z) {
        if (this.coI != null && this.coI.bqI() != null) {
            this.coI.bqI().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cDg), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.cAB = c(this.cAB, frsRequestData);
        if (this.cAB == 1) {
            if (!this.cyZ.xa()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.cDl == null) {
            this.cDl = new an();
            this.cDl.pn = 1;
            this.cDl.forumName = this.coW;
            if (this.coI != null && this.coI.aOV() != null) {
                this.cDl.forumId = this.coI.aOV().getId();
            }
        }
        jC(i);
    }

    public void js(int i) {
        if (this.cAB != 1) {
            jC(4);
        } else if (!this.cyZ.xa()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cDg), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(OC());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.cDh.iR(i);
        this.cyZ.a(frsRequestData);
        this.mType = i;
        frsRequestData.rQ(this.cvA.ahi() ? "1" : "2");
        if (this.cDu) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.g.g.jR(this.cDt)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.cDu = false;
        frsRequestData.setKw(this.coW);
        if (com.baidu.tbadk.core.h.oS().oY()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ad = com.baidu.adp.lib.util.k.ad(TbadkCoreApplication.getInst());
        int ae = com.baidu.adp.lib.util.k.ae(TbadkCoreApplication.getInst());
        float af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst());
        int i2 = com.baidu.tbadk.core.util.an.vO().vQ() ? 2 : 1;
        frsRequestData.setScrW(ad);
        frsRequestData.setScrH(ae);
        frsRequestData.setScrDip(af);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.czc);
        frsRequestData.setYuelaouLocate(this.cDr);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(s.Hq(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.f.cpf != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.f.cpf);
        }
        if (com.baidu.tieba.frs.f.cpg != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.f.cpg);
        }
        if (com.baidu.tieba.frs.f.cph != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.f.cph);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.g.g.a(this.cDs, frsRequestData);
        b(i, frsRequestData);
        a(this.coW, frsRequestData);
        if (!jB(this.cDs)) {
            String d = com.baidu.tieba.tbadkCore.c.bqk().d(this.coW, frsRequestData.OC(), frsRequestData.getIsGood(), this.cDg.getCategoryId());
            this.cDv = d;
            new a(this, true, d).execute(new Object[0]);
        }
        ajT();
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
        if (gVar == null || gVar.aOV() == null || am.isEmpty(gVar.aOV().getName())) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.cAB = gVar.bqM();
        }
        this.coI.e(gVar);
        d(this.coI);
        this.cyY = new ArrayList<>();
        if (frsRequestData != null) {
            this.cDg = frsRequestData;
            this.mPn = this.cDg.getPn();
            this.coW = this.cDg.getKw();
            this.cvA.setForumName(this.coW);
            this.cvA.setFrom(this.aiP);
            this.cvA.setPn(this.mPn);
            this.cvA.setFlag(this.mFlag);
        }
        if (this.coI.getThreadList() != null) {
            this.cyY.addAll(this.coI.getThreadList());
        }
        if (this.cAB != 1 && this.isNetFirstLoad) {
            this.cDh.a(7, false, this.czb);
        } else {
            this.cDh.a(this.mType, false, this.czb);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.cDg)) {
            akT();
        }
        this.isNetFirstLoad = false;
        if (gVar.aOV() == null || TextUtils.isEmpty(gVar.aOV().getName()) || frsRequestData == null || r.bhd().bgX() == null) {
            return true;
        }
        r.bhd().bgX().g(gVar.aOV().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.g, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.g gVar;
        d.a aVar = new d.a();
        aVar.gfi = com.baidu.adp.lib.util.i.hi() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gfj = mvcSocketResponsedMessage.getDownSize();
        this.czb = aVar;
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
        this.cvA.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.g, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.czf) {
            this.czf = true;
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
        aVar.gfi = com.baidu.adp.lib.util.i.hi() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gfj = mvcHttpResponsedMessage.getDownSize();
        this.czb = aVar;
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
        this.cvA.a(errorData);
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
        if (!this.czf) {
            this.czf = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void ahb() {
        if (this.coI != null && this.coI.aOV() != null && this.coI.aOV().getBannerListData() != null) {
            String lastIds = this.coI.aOV().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.czc = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.l.r.Gx().Gy()) {
            this.aJP = System.currentTimeMillis() - this.cvA.Wo;
            m mVar = new m(i, z, responsedMessage, this.cvA.aJG, this.cvA.createTime, this.cvA.aJO, false, this.aJP);
            this.cvA.createTime = 0L;
            this.cvA.aJG = 0L;
            if (mVar != null) {
                mVar.Gs();
            }
        }
    }

    public FrsRequestData akD() {
        return this.cDg;
    }

    public String akE() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.coW;
    }

    public int getPn() {
        return this.mPn;
    }

    public com.baidu.tieba.tbadkCore.i ajS() {
        return this.coI;
    }

    public d.a akF() {
        return this.czb;
    }

    private void ajT() {
        this.ccH = System.currentTimeMillis();
        this.cyZ.Fu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.g gVar) {
        this.isCacheFirstLoad = false;
        this.coI.e(gVar);
        d(this.coI);
        this.cyY = new ArrayList<>();
        if (this.coI.getThreadList() != null) {
            this.cyY.addAll(this.coI.getThreadList());
        }
        this.cDh.b(gVar);
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
        private String cDB;
        private FrsModelController cDC;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.cDB = null;
            this.cDB = str;
            this.cDC = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bqk().rO(this.cDB)) {
                if (!com.baidu.tieba.tbadkCore.c.bqk().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.cDB)) {
                    com.baidu.tieba.tbadkCore.c.bqk().getResponseData().aOV().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.g responseData = com.baidu.tieba.tbadkCore.c.bqk().getResponseData();
                if (responseData.bqO() != null && !StringUtils.isNull(responseData.bqO().pK(), true) && !responseData.bqO().pK().equals("0") && responseData.bqO().pL() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bqO().pK(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
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
            if (this.cDC != null && gVarArr != null) {
                this.cDC.d(gVarArr.length > 0 ? gVarArr[0] : null);
                this.cDC.p(this.cDC.cDs, true);
            }
        }
    }

    public long adg() {
        return this.ccK;
    }

    public long adh() {
        return this.ccI;
    }

    public long adi() {
        return this.ccJ;
    }

    public long adj() {
        return this.ccH;
    }

    public boolean xa() {
        return this.cyZ.xa();
    }

    public int akG() {
        return this.cDk;
    }

    private void akH() {
        if (this.cDq == null) {
            this.cDq = new ArrayList<>();
        }
        if (this.cDq.size() == 0) {
            this.cDq.add(new v());
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, an anVar) {
        this.cAB = c(i, null);
        if (anVar == null && (anVar = aA(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.k.hz() && this.cDp != null) {
                aq aqVar = new aq();
                aqVar.hasMore = false;
                aqVar.pn = 1;
                aqVar.forumName = this.coW;
                aqVar.csn = false;
                if (this.coI != null && this.coI.aOV() != null) {
                    aqVar.forumId = this.coI.aOV().getId();
                }
                akH();
                this.coI.aA(this.cDq);
                this.cDp.a(i, i2, aqVar, this.cDq);
            }
            anVar = new an();
            anVar.pn = -1;
        }
        if (this.coI != null && this.coI.aOV() != null) {
            anVar.forumId = this.coI.aOV().getId();
        }
        anVar.forumName = this.coW;
        if (y.ahS().iX(1) != null && this.cAB == 1) {
            this.cDg.setCategoryId(i2);
        }
        this.cDj = i2;
        this.cDl = anVar;
        b(i, i2, anVar);
        jC(5);
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(ak akVar) {
        this.cDp = akVar;
        this.cDo.a(this.cDx);
    }

    private void jC(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.cDl != null) {
                    this.cDl.pn++;
                    break;
                }
                break;
            case 2:
                if (this.cDl != null) {
                    an anVar = this.cDl;
                    anVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.cDl != null) {
                    this.cDl.pn = -1;
                    break;
                }
                break;
        }
        if (this.cAB == 1) {
            if (this.cDk == this.cDj) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                if (this.cyY != null) {
                    arrayList.addAll(this.cyY);
                }
                this.coI.aA(arrayList);
                if (this.cDp != null) {
                    this.cDp.a(this.cAB, this.cDj, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.cDk = this.cDj;
            return;
        }
        ai iY = this.cDo.iY(this.cAB);
        if (iY != null) {
            this.cDm = true;
            iY.a(this.cAB, this.cDj, this.cDl);
            return;
        }
        if (this.coI != null && this.coI.getThreadList() != null) {
            this.coI.getThreadList().clear();
        }
        this.cDp.a(this.cAB, this.cDj, null, null);
    }

    public boolean hasMore() {
        if ((this.cDl instanceof aq) && ((aq) this.cDl).errCode == 0) {
            return ((aq) this.cDl).hasMore;
        }
        return true;
    }

    private int az(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, an anVar) {
        this.cDn.put(az(i, i2), anVar);
    }

    public an aA(int i, int i2) {
        return this.cDn.get(az(i, i2));
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        this.cDo.init();
    }

    @Override // com.baidu.tieba.frs.ai
    public void OO() {
        this.cDo.destory();
        this.cDo.clear();
    }

    public int akI() {
        return this.cAB;
    }

    public boolean akJ() {
        return 1 == this.cAB;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(ao aoVar) {
        if (aoVar != null && !StringUtils.isNull(aoVar.getId()) && this.cyY != null) {
            if (this.cAB == 1) {
                this.coI.a(aoVar);
            }
            int akK = akK();
            if (this.cyY != null && this.cyY.size() > 0) {
                int size = this.cyY.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.f fVar = this.cyY.get(i);
                    if ((fVar instanceof bj) && aoVar.getId().equals(((bj) fVar).getId())) {
                        return;
                    }
                }
            }
            if (aoVar.getThreadType() == 33) {
                ax axVar = new ax();
                axVar.a(aoVar, -1);
                axVar.setPost_num(1);
                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.cyY.add(akK, axVar);
                    return;
                }
                return;
            }
            this.cyY.add(akK, aoVar);
        }
    }

    public int akK() {
        int i = 0;
        if (this.cyY == null || this.cyY.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.cyY.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (!(next instanceof bj)) {
                    i = i2;
                } else if (((bj) next).rw() != 0) {
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

    public boolean akL() {
        return this.cDm;
    }

    public void akM() {
        com.baidu.tieba.frs.k kVar = new com.baidu.tieba.frs.k();
        if (this.cDk == 0) {
            kVar.iW(this.cDs);
        }
        if (this.coI.getThreadList() != null) {
            this.coI.getThreadList().clear();
            this.coI.getThreadList().add(kVar);
        }
        if (this.cyY != null) {
            this.cyY.clear();
            this.cyY.add(kVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> akN() {
        return this.cyY;
    }

    public void jD(int i) {
        this.cDs = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.g.btk();
        } else {
            com.baidu.tieba.tbadkCore.util.g.btl();
        }
    }

    public void jE(int i) {
        this.cDt = i;
    }

    public void fi(boolean z) {
        this.cDu = z;
    }

    public int akO() {
        return this.cDs;
    }

    public int OC() {
        return com.baidu.tieba.frs.g.g.jR(this.cDs);
    }

    public boolean akP() {
        return this.cDi;
    }

    public boolean akQ() {
        return this.cDs == 5;
    }

    public boolean akR() {
        return this.cDg != null && this.cDg.getLoadType() == 1;
    }

    public boolean akS() {
        return this.cDs == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.cvA.agE() != null) {
            return this.cvA.agE().a(this.cDs, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bj.Yq.get() && r.bhd().bgX() != null) {
            int X = r.bhd().bgX().X(str, false);
            int Y = r.bhd().bgX().Y(str, false);
            if (frsRequestData.getLoadType() == 1) {
                X++;
            } else if (frsRequestData.getLoadType() == 2) {
                Y++;
            }
            frsRequestData.setRefreshCount(X);
            frsRequestData.setLoadCount(Y);
        }
    }

    public void akT() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.coI != null && this.coI.aOV() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.coI.aOV().getId(), 0L));
        }
        this.cvA.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void kO(final String str) {
        u.a(new t<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bqk().ce(FrsModelController.this.cDv, str);
                return null;
            }
        }, null);
    }

    public void kP(final String str) {
        u.a(new t<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bqk().cf(FrsModelController.this.cDv, str);
                return null;
            }
        }, null);
    }
}
