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
import com.baidu.tbadk.core.data.bl;
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
    private long aKj;
    private String ajt;
    private long bYY;
    private long bYZ;
    private long bZa;
    private long bZb;
    private com.baidu.tieba.tbadkCore.i ciB;
    private String ciP;

    /* renamed from: com  reason: collision with root package name */
    private final com.baidu.tieba.frs.f f3com;
    private ArrayList<com.baidu.adp.widget.ListView.f> crO;
    private FrsNetModel<com.baidu.tieba.frs.f> crP;
    private d.a crR;
    private String crS;
    private boolean crV;
    private FrsRequestData cuC;
    private final com.baidu.tieba.tbadkCore.k cuD;
    private boolean cuE;
    private int cuF;
    private int cuG;
    private int cuH;
    private an cuI;
    private boolean cuJ;
    private SparseArray<an> cuK;
    private aa cuL;
    private ak cuM;
    private ArrayList<com.baidu.adp.widget.ListView.f> cuN;
    private String cuO;
    private int cuP;
    private int cuQ;
    private boolean cuR;
    private String cuS;
    private final SparseArray<Boolean> cuT;
    private ak cuU;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean jd(int i) {
        return this.cuT.get(i, false).booleanValue();
    }

    public void q(int i, boolean z) {
        this.cuT.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.f fVar, com.baidu.tieba.tbadkCore.k kVar) {
        super(fVar.getPageContext());
        this.ciP = null;
        this.mType = 3;
        this.mPn = 1;
        this.ajt = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.crS = null;
        this.cuF = 1;
        this.cuG = 0;
        this.cuH = 0;
        this.cuJ = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.cuK = new SparseArray<>();
        this.aKj = 0L;
        this.crV = false;
        this.cuP = -1;
        this.cuQ = -1;
        this.cuS = null;
        this.cuT = new SparseArray<>();
        this.cuU = new ak() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ak
            public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
                FrsModelController.this.cuJ = false;
                if (i == FrsModelController.this.cuF && FrsModelController.this.cuM != null) {
                    FrsModelController.this.cuI = aqVar;
                    FrsModelController.this.b(i, i2, aqVar);
                    ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.ciB.aB(arrayList2);
                    if ((i == 1 || i == 5) && !FrsModelController.this.aiI()) {
                        FrsModelController.this.ciB.brt();
                        FrsModelController.this.ciB.bru();
                    }
                    FrsModelController.this.cuM.a(i, i2, aqVar, arrayList);
                }
            }
        };
        this.bYY = 0L;
        this.bYZ = 0L;
        this.bZa = 0L;
        this.bZb = 0L;
        if (fVar == null || kVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.f3com = fVar;
        this.cuD = kVar;
        A(this.f3com);
    }

    private void A(com.baidu.tieba.frs.f fVar) {
        this.cuL = new aa();
        this.cuL.aOM = fVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.cuL));
        this.cuL.a(this.cuU);
    }

    public void onActivityDestroy() {
        this.crP.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.ciP = bundle.getString("name");
            this.ajt = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.cuO = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.cuE = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.ciP)) {
            this.ciP = "";
        }
        if (TextUtils.isEmpty(this.ajt)) {
            this.ajt = "";
        }
        if (TextUtils.isEmpty(this.cuO)) {
            this.cuO = "";
        }
        this.mSource = this.ajt;
        this.cuC = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            jf(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            jf(6);
        } else {
            com.baidu.tieba.frs.smartsort.f kx = com.baidu.tieba.frs.smartsort.d.aiU().kx(this.ciP);
            if (kx != null) {
                jf(kx.cvA);
            } else {
                jf(-1);
            }
        }
        this.cuC.setSortType(Om());
        if (this.cuP == 5) {
            this.cuC.setIsGood(1);
        } else {
            this.cuC.setIsGood(0);
        }
        this.ciB = new com.baidu.tieba.tbadkCore.i();
        this.crP = new FrsNetModel<>(this.f3com.getPageContext(), this.cuC);
        this.crP.a(this);
        this.crP.setUniqueId(this.f3com.getUniqueId());
        if (this.ciP != null && this.ciP.length() > 0) {
            if (this.ajt == null || this.ajt.length() <= 0) {
                this.ajt = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.ciP);
        bundle.putString("from", this.ajt);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean XP() {
        if (this.cuF != 1) {
            je(1);
            return true;
        } else if (this.crP.xc()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.f3com.getActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cuC), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(Om());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void r(int i, boolean z) {
        if (this.ciB != null && this.ciB.bqS() != null) {
            this.ciB.bqS().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cuC), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.cuF = c(this.cuF, frsRequestData);
        if (this.cuF == 1) {
            if (!this.crP.xc()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.cuI == null) {
            this.cuI = new an();
            this.cuI.pn = 1;
            this.cuI.forumName = this.ciP;
            if (this.ciB != null && this.ciB.aPh() != null) {
                this.cuI.forumId = this.ciB.aPh().getId();
            }
        }
        je(i);
    }

    public void jc(int i) {
        if (this.cuF != 1) {
            je(4);
        } else if (!this.crP.xc()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cuC), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(Om());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.cuD.iD(i);
        this.crP.a(frsRequestData);
        this.mType = i;
        frsRequestData.rO(this.f3com.aft() ? "1" : "2");
        if (this.cuR) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.jt(this.cuQ)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.cuR = false;
        frsRequestData.setKw(this.ciP);
        if (com.baidu.tbadk.core.h.oX().pd()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ag = com.baidu.adp.lib.util.k.ag(this.f3com.getActivity());
        int ah = com.baidu.adp.lib.util.k.ah(this.f3com.getActivity());
        float ai = com.baidu.adp.lib.util.k.ai(this.f3com.getActivity());
        int i2 = am.vQ().vS() ? 2 : 1;
        frsRequestData.setScrW(ag);
        frsRequestData.setScrH(ah);
        frsRequestData.setScrDip(ai);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.crS);
        frsRequestData.setYuelaouLocate(this.cuO);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.d(s.Hr(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.f.ciY != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.f.ciY);
        }
        if (com.baidu.tieba.frs.f.ciZ != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.f.ciZ);
        }
        if (com.baidu.tieba.frs.f.cja != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.f.cja);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.g.a(this.cuP, frsRequestData);
        b(i, frsRequestData);
        a(this.ciP, frsRequestData);
        if (!jd(this.cuP)) {
            String g = com.baidu.tieba.tbadkCore.c.bqu().g(this.ciP, frsRequestData.Om(), frsRequestData.getIsGood(), this.cuC.getCategoryId());
            this.cuS = g;
            new a(this, true, g).execute(new Object[0]);
        }
        ahT();
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
        if (gVar == null || gVar.aPh() == null || StringUtils.isNull(gVar.aPh().getName())) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.cuF = gVar.bqW();
        }
        this.ciB.e(gVar);
        d(this.ciB);
        this.crO = new ArrayList<>();
        if (frsRequestData != null) {
            this.cuC = frsRequestData;
            this.mPn = this.cuC.getPn();
            this.ciP = this.cuC.getKw();
            this.f3com.setForumName(this.ciP);
            this.f3com.setFrom(this.ajt);
            this.f3com.setPn(this.mPn);
            this.f3com.setFlag(this.mFlag);
        }
        if (this.ciB.getThreadList() != null) {
            this.crO.addAll(this.ciB.getThreadList());
        }
        if (this.cuF != 1 && this.isNetFirstLoad) {
            this.cuD.a(7, false, this.crR);
        } else {
            this.cuD.a(this.mType, false, this.crR);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.cuC)) {
            aiJ();
        }
        this.isNetFirstLoad = false;
        if (gVar.aPh() == null || TextUtils.isEmpty(gVar.aPh().getName()) || frsRequestData == null || r.bhF().bhB() == null) {
            return true;
        }
        r.bhF().bhB().g(gVar.aPh().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.g, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.g gVar;
        d.a aVar = new d.a();
        aVar.geO = com.baidu.adp.lib.util.i.hr() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.geP = mvcSocketResponsedMessage.getDownSize();
        this.crR = aVar;
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
        this.f3com.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.g, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.crV) {
            this.crV = true;
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
        aVar.geO = com.baidu.adp.lib.util.i.hr() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.geP = mvcHttpResponsedMessage.getDownSize();
        this.crR = aVar;
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
        this.f3com.a(errorData);
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
        if (!this.crV) {
            this.crV = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void afn() {
        if (this.ciB != null && this.ciB.aPh() != null && this.ciB.aPh().getBannerListData() != null) {
            String lastIds = this.ciB.aPh().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.crS = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.l.r.Gz().GA()) {
            this.aKj = System.currentTimeMillis() - this.f3com.Xc;
            m mVar = new m(i, z, responsedMessage, this.f3com.aKa, this.f3com.createTime, this.f3com.aKi, false, this.aKj);
            this.f3com.createTime = 0L;
            this.f3com.aKa = 0L;
            if (mVar != null) {
                mVar.Gu();
            }
        }
    }

    public FrsRequestData ait() {
        return this.cuC;
    }

    public String aiu() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.ciP;
    }

    public int getPn() {
        return this.mPn;
    }

    public com.baidu.tieba.tbadkCore.i ahS() {
        return this.ciB;
    }

    public d.a aiv() {
        return this.crR;
    }

    private void ahT() {
        this.bYY = System.currentTimeMillis();
        this.crP.Fw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.g gVar) {
        this.isCacheFirstLoad = false;
        this.ciB.e(gVar);
        d(this.ciB);
        this.crO = new ArrayList<>();
        if (this.ciB.getThreadList() != null) {
            this.crO.addAll(this.ciB.getThreadList());
        }
        this.cuD.b(gVar);
    }

    private void d(com.baidu.tieba.tbadkCore.i iVar) {
        if (com.baidu.tieba.frs.g.f.h(iVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.g.f.i(iVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.g, Void> {
        private FrsModelController cuY;
        private String mm;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.mm = null;
            this.mm = str;
            this.cuY = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bqu().rM(this.mm)) {
                if (!com.baidu.tieba.tbadkCore.c.bqu().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.mm)) {
                    com.baidu.tieba.tbadkCore.c.bqu().getResponseData().aPh().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.g responseData = com.baidu.tieba.tbadkCore.c.bqu().getResponseData();
                if (responseData.bqY() != null && !StringUtils.isNull(responseData.bqY().getBookId(), true) && !responseData.bqY().getBookId().equals("0") && responseData.bqY().pP() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bqY().getBookId(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
                    responseData.i(Integer.valueOf(((Integer) runTask.getData()).intValue()));
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
            if (this.cuY != null && gVarArr != null) {
                this.cuY.d(gVarArr.length > 0 ? gVarArr[0] : null);
                this.cuY.q(this.cuY.cuP, true);
            }
        }
    }

    public long abP() {
        return this.bZb;
    }

    public long abQ() {
        return this.bYZ;
    }

    public long abR() {
        return this.bZa;
    }

    public long abS() {
        return this.bYY;
    }

    public boolean xc() {
        return this.crP.xc();
    }

    public int aiw() {
        return this.cuH;
    }

    private void aix() {
        if (this.cuN == null) {
            this.cuN = new ArrayList<>();
        }
        if (this.cuN.size() == 0) {
            this.cuN.add(new v());
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, an anVar) {
        this.cuF = c(i, null);
        if (anVar == null && (anVar = at(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.k.hI() && this.cuM != null) {
                aq aqVar = new aq();
                aqVar.hasMore = false;
                aqVar.pn = 1;
                aqVar.forumName = this.ciP;
                aqVar.cmh = false;
                if (this.ciB != null && this.ciB.aPh() != null) {
                    aqVar.forumId = this.ciB.aPh().getId();
                }
                aix();
                this.ciB.aB(this.cuN);
                this.cuM.a(i, i2, aqVar, this.cuN);
            }
            anVar = new an();
            anVar.pn = -1;
        }
        if (this.ciB != null && this.ciB.aPh() != null) {
            anVar.forumId = this.ciB.aPh().getId();
        }
        anVar.forumName = this.ciP;
        if (y.agf().iJ(1) != null && this.cuF == 1) {
            this.cuC.setCategoryId(i2);
        }
        this.cuG = i2;
        this.cuI = anVar;
        b(i, i2, anVar);
        je(5);
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(ak akVar) {
        this.cuM = akVar;
        this.cuL.a(this.cuU);
    }

    private void je(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.cuI != null) {
                    this.cuI.pn++;
                    break;
                }
                break;
            case 2:
                if (this.cuI != null) {
                    an anVar = this.cuI;
                    anVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.cuI != null) {
                    this.cuI.pn = -1;
                    break;
                }
                break;
        }
        if (this.cuF == 1) {
            if (this.cuH == this.cuG) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                if (this.crO != null) {
                    arrayList.addAll(this.crO);
                }
                this.ciB.aB(arrayList);
                if (this.cuM != null) {
                    this.cuM.a(this.cuF, this.cuG, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.cuH = this.cuG;
            return;
        }
        ai iK = this.cuL.iK(this.cuF);
        if (iK != null) {
            this.cuJ = true;
            iK.a(this.cuF, this.cuG, this.cuI);
            return;
        }
        if (this.ciB != null && this.ciB.getThreadList() != null) {
            this.ciB.getThreadList().clear();
        }
        this.cuM.a(this.cuF, this.cuG, null, null);
    }

    public boolean hasMore() {
        if ((this.cuI instanceof aq) && ((aq) this.cuI).errCode == 0) {
            return ((aq) this.cuI).hasMore;
        }
        return true;
    }

    private int as(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, an anVar) {
        this.cuK.put(as(i, i2), anVar);
    }

    public an at(int i, int i2) {
        return this.cuK.get(as(i, i2));
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        this.cuL.init();
    }

    @Override // com.baidu.tieba.frs.ai
    public void Ox() {
        this.cuL.destory();
        this.cuL.clear();
    }

    public int aiy() {
        return this.cuF;
    }

    public boolean aiz() {
        return 1 == this.cuF;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(ao aoVar) {
        if (aoVar != null && !StringUtils.isNull(aoVar.getId()) && this.crO != null) {
            if (this.cuF == 1) {
                this.ciB.a(aoVar);
            }
            int aiA = aiA();
            if (this.crO != null && this.crO.size() > 0) {
                int size = this.crO.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.f fVar = this.crO.get(i);
                    if ((fVar instanceof bl) && aoVar.getId().equals(((bl) fVar).getId())) {
                        return;
                    }
                }
            }
            if (aoVar.getThreadType() == 33) {
                ax axVar = new ax();
                axVar.a(aoVar, -1);
                axVar.setPost_num(1);
                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.crO.add(aiA, axVar);
                    return;
                }
                return;
            }
            this.crO.add(aiA, aoVar);
        }
    }

    public int aiA() {
        int i = 0;
        if (this.crO == null || this.crO.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.crO.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (!(next instanceof bl)) {
                    i = i2;
                } else if (((bl) next).rA() != 0) {
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

    public boolean aiB() {
        return this.cuJ;
    }

    public void aiC() {
        com.baidu.tieba.frs.k kVar = new com.baidu.tieba.frs.k();
        if (this.cuH == 0) {
            kVar.iI(this.cuP);
        }
        if (this.ciB.getThreadList() != null) {
            this.ciB.getThreadList().clear();
            this.ciB.getThreadList().add(kVar);
        }
        if (this.crO != null) {
            this.crO.clear();
            this.crO.add(kVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aiD() {
        return this.crO;
    }

    public void jf(int i) {
        this.cuP = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.g.btu();
        } else {
            com.baidu.tieba.tbadkCore.util.g.btv();
        }
    }

    public void jg(int i) {
        this.cuQ = i;
    }

    public void eX(boolean z) {
        this.cuR = z;
    }

    public int aiE() {
        return this.cuP;
    }

    public int Om() {
        return com.baidu.tieba.frs.f.g.jt(this.cuP);
    }

    public boolean aiF() {
        return this.cuE;
    }

    public boolean aiG() {
        return this.cuP == 5;
    }

    public boolean aiH() {
        return this.cuC != null && this.cuC.getLoadType() == 1;
    }

    public boolean aiI() {
        return this.cuP == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.f3com.aeQ() != null) {
            return this.f3com.aeQ().a(this.cuP, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bl.Zj.get() && r.bhF().bhB() != null) {
            int V = r.bhF().bhB().V(str, false);
            int W = r.bhF().bhB().W(str, false);
            if (frsRequestData.getLoadType() == 1) {
                V++;
            } else if (frsRequestData.getLoadType() == 2) {
                W++;
            }
            frsRequestData.setRefreshCount(V);
            frsRequestData.setLoadCount(W);
        }
    }

    public void aiJ() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.ciB != null && this.ciB.aPh() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.d(this.ciB.aPh().getId(), 0L));
        }
        this.f3com.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void kr(final String str) {
        u.a(new t<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bqu().cc(FrsModelController.this.cuS, str);
                return null;
            }
        }, null);
    }

    public void ks(final String str) {
        u.a(new t<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bqu().cd(FrsModelController.this.cuS, str);
                return null;
            }
        }, null);
    }
}
