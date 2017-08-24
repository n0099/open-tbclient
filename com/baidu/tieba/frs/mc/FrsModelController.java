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
    private long aKl;
    private String ajv;
    private long bZL;
    private long bZM;
    private long bZN;
    private long bZO;
    private String cjD;
    private com.baidu.tieba.tbadkCore.i cjo;
    private final com.baidu.tieba.frs.f coV;
    private boolean csC;
    private ArrayList<com.baidu.adp.widget.ListView.f> csv;
    private FrsNetModel<com.baidu.tieba.frs.f> csw;
    private d.a csy;
    private String csz;
    private int ctX;
    private FrsRequestData cwG;
    private final com.baidu.tieba.tbadkCore.k cwH;
    private boolean cwI;
    private int cwJ;
    private int cwK;
    private an cwL;
    private boolean cwM;
    private SparseArray<an> cwN;
    private aa cwO;
    private ak cwP;
    private ArrayList<com.baidu.adp.widget.ListView.f> cwQ;
    private String cwR;
    private int cwS;
    private int cwT;
    private boolean cwU;
    private String cwV;
    private final SparseArray<Boolean> cwW;
    private ak cwX;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean jn(int i) {
        return this.cwW.get(i, false).booleanValue();
    }

    public void q(int i, boolean z) {
        this.cwW.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.f fVar, com.baidu.tieba.tbadkCore.k kVar) {
        super(fVar.getPageContext());
        this.cjD = null;
        this.mType = 3;
        this.mPn = 1;
        this.ajv = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.csz = null;
        this.ctX = 1;
        this.cwJ = 0;
        this.cwK = 0;
        this.cwM = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.cwN = new SparseArray<>();
        this.aKl = 0L;
        this.csC = false;
        this.cwS = -1;
        this.cwT = -1;
        this.cwV = null;
        this.cwW = new SparseArray<>();
        this.cwX = new ak() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ak
            public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
                FrsModelController.this.cwM = false;
                if (i == FrsModelController.this.ctX && FrsModelController.this.cwP != null) {
                    FrsModelController.this.cwL = aqVar;
                    FrsModelController.this.b(i, i2, aqVar);
                    ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.cjo.aB(arrayList2);
                    if ((i == 1 || i == 5) && !FrsModelController.this.ajj()) {
                        FrsModelController.this.cjo.brU();
                        FrsModelController.this.cjo.brV();
                    }
                    FrsModelController.this.cwP.a(i, i2, aqVar, arrayList);
                }
            }
        };
        this.bZL = 0L;
        this.bZM = 0L;
        this.bZN = 0L;
        this.bZO = 0L;
        if (fVar == null || kVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.coV = fVar;
        this.cwH = kVar;
        A(this.coV);
    }

    private void A(com.baidu.tieba.frs.f fVar) {
        this.cwO = new aa();
        this.cwO.aOO = fVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.cwO));
        this.cwO.a(this.cwX);
    }

    public void onActivityDestroy() {
        this.csw.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.cjD = bundle.getString("name");
            this.ajv = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.cwR = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.cwI = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.cjD)) {
            this.cjD = "";
        }
        if (TextUtils.isEmpty(this.ajv)) {
            this.ajv = "";
        }
        if (TextUtils.isEmpty(this.cwR)) {
            this.cwR = "";
        }
        this.mSource = this.ajv;
        this.cwG = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            jp(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            jp(6);
        } else {
            com.baidu.tieba.frs.smartsort.f kE = com.baidu.tieba.frs.smartsort.d.ajv().kE(this.cjD);
            if (kE != null) {
                jp(kE.cxD);
            } else {
                jp(-1);
            }
        }
        this.cwG.setSortType(Om());
        if (this.cwS == 5) {
            this.cwG.setIsGood(1);
        } else {
            this.cwG.setIsGood(0);
        }
        this.cjo = new com.baidu.tieba.tbadkCore.i();
        this.csw = new FrsNetModel<>(this.coV.getPageContext(), this.cwG);
        this.csw.a(this);
        this.csw.setUniqueId(this.coV.getUniqueId());
        if (this.cjD != null && this.cjD.length() > 0) {
            if (this.ajv == null || this.ajv.length() <= 0) {
                this.ajv = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.cjD);
        bundle.putString("from", this.ajv);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean Yh() {
        if (this.ctX != 1) {
            jo(1);
            return true;
        } else if (this.csw.xc()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cwG), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(Om());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void r(int i, boolean z) {
        if (this.cjo != null && this.cjo.brt() != null) {
            this.cjo.brt().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cwG), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.ctX = c(this.ctX, frsRequestData);
        if (this.ctX == 1) {
            if (!this.csw.xc()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.cwL == null) {
            this.cwL = new an();
            this.cwL.pn = 1;
            this.cwL.forumName = this.cjD;
            if (this.cjo != null && this.cjo.aPJ() != null) {
                this.cwL.forumId = this.cjo.aPJ().getId();
            }
        }
        jo(i);
    }

    public void je(int i) {
        if (this.ctX != 1) {
            jo(4);
        } else if (!this.csw.xc()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cwG), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(Om());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.cwH.iF(i);
        this.csw.a(frsRequestData);
        this.mType = i;
        frsRequestData.rV(this.coV.afK() ? "1" : "2");
        if (this.cwU) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.jD(this.cwT)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.cwU = false;
        frsRequestData.setKw(this.cjD);
        if (com.baidu.tbadk.core.h.oY().pe()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst());
        int ah = com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst());
        float ai = com.baidu.adp.lib.util.k.ai(TbadkCoreApplication.getInst());
        int i2 = am.vR().vT() ? 2 : 1;
        frsRequestData.setScrW(ag);
        frsRequestData.setScrH(ah);
        frsRequestData.setScrDip(ai);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.csz);
        frsRequestData.setYuelaouLocate(this.cwR);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.d(s.Hr(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.f.cjM != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.f.cjM);
        }
        if (com.baidu.tieba.frs.f.cjN != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.f.cjN);
        }
        if (com.baidu.tieba.frs.f.cjO != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.f.cjO);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.g.a(this.cwS, frsRequestData);
        b(i, frsRequestData);
        a(this.cjD, frsRequestData);
        if (!jn(this.cwS)) {
            String g = com.baidu.tieba.tbadkCore.c.bqV().g(this.cjD, frsRequestData.Om(), frsRequestData.getIsGood(), this.cwG.getCategoryId());
            this.cwV = g;
            new a(this, true, g).execute(new Object[0]);
        }
        aih();
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
        if (gVar == null || gVar.aPJ() == null || StringUtils.isNull(gVar.aPJ().getName())) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.ctX = gVar.brx();
        }
        this.cjo.e(gVar);
        d(this.cjo);
        this.csv = new ArrayList<>();
        if (frsRequestData != null) {
            this.cwG = frsRequestData;
            this.mPn = this.cwG.getPn();
            this.cjD = this.cwG.getKw();
            this.coV.setForumName(this.cjD);
            this.coV.setFrom(this.ajv);
            this.coV.setPn(this.mPn);
            this.coV.setFlag(this.mFlag);
        }
        if (this.cjo.getThreadList() != null) {
            this.csv.addAll(this.cjo.getThreadList());
        }
        if (this.ctX != 1 && this.isNetFirstLoad) {
            this.cwH.a(7, false, this.csy);
        } else {
            this.cwH.a(this.mType, false, this.csy);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.cwG)) {
            ajk();
        }
        this.isNetFirstLoad = false;
        if (gVar.aPJ() == null || TextUtils.isEmpty(gVar.aPJ().getName()) || frsRequestData == null || r.big().bic() == null) {
            return true;
        }
        r.big().bic().g(gVar.aPJ().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.g, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.g gVar;
        d.a aVar = new d.a();
        aVar.ggG = com.baidu.adp.lib.util.i.hr() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.ggH = mvcSocketResponsedMessage.getDownSize();
        this.csy = aVar;
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
        this.coV.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.g, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.csC) {
            this.csC = true;
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
        aVar.ggG = com.baidu.adp.lib.util.i.hr() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.ggH = mvcHttpResponsedMessage.getDownSize();
        this.csy = aVar;
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
        this.coV.a(errorData);
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
        if (!this.csC) {
            this.csC = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void afD() {
        if (this.cjo != null && this.cjo.aPJ() != null && this.cjo.aPJ().getBannerListData() != null) {
            String lastIds = this.cjo.aPJ().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.csz = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.l.r.Gz().GA()) {
            this.aKl = System.currentTimeMillis() - this.coV.Xf;
            m mVar = new m(i, z, responsedMessage, this.coV.aKc, this.coV.createTime, this.coV.aKk, false, this.aKl);
            this.coV.createTime = 0L;
            this.coV.aKc = 0L;
            if (mVar != null) {
                mVar.Gu();
            }
        }
    }

    public FrsRequestData aiU() {
        return this.cwG;
    }

    public String aiV() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.cjD;
    }

    public int getPn() {
        return this.mPn;
    }

    public com.baidu.tieba.tbadkCore.i aig() {
        return this.cjo;
    }

    public d.a aiW() {
        return this.csy;
    }

    private void aih() {
        this.bZL = System.currentTimeMillis();
        this.csw.Fw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.g gVar) {
        this.isCacheFirstLoad = false;
        this.cjo.e(gVar);
        d(this.cjo);
        this.csv = new ArrayList<>();
        if (this.cjo.getThreadList() != null) {
            this.csv.addAll(this.cjo.getThreadList());
        }
        this.cwH.b(gVar);
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
        private FrsModelController cxb;
        private String mm;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.mm = null;
            this.mm = str;
            this.cxb = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bqV().rT(this.mm)) {
                if (!com.baidu.tieba.tbadkCore.c.bqV().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.mm)) {
                    com.baidu.tieba.tbadkCore.c.bqV().getResponseData().aPJ().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.g responseData = com.baidu.tieba.tbadkCore.c.bqV().getResponseData();
                if (responseData.brz() != null && !StringUtils.isNull(responseData.brz().getBookId(), true) && !responseData.brz().getBookId().equals("0") && responseData.brz().pQ() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.brz().getBookId(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
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
            if (this.cxb != null && gVarArr != null) {
                this.cxb.d(gVarArr.length > 0 ? gVarArr[0] : null);
                this.cxb.q(this.cxb.cwS, true);
            }
        }
    }

    public long acg() {
        return this.bZO;
    }

    public long ach() {
        return this.bZM;
    }

    public long aci() {
        return this.bZN;
    }

    public long acj() {
        return this.bZL;
    }

    public boolean xc() {
        return this.csw.xc();
    }

    public int aiX() {
        return this.cwK;
    }

    private void aiY() {
        if (this.cwQ == null) {
            this.cwQ = new ArrayList<>();
        }
        if (this.cwQ.size() == 0) {
            this.cwQ.add(new v());
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, an anVar) {
        this.ctX = c(i, null);
        if (anVar == null && (anVar = aB(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.k.hI() && this.cwP != null) {
                aq aqVar = new aq();
                aqVar.hasMore = false;
                aqVar.pn = 1;
                aqVar.forumName = this.cjD;
                aqVar.cmT = false;
                if (this.cjo != null && this.cjo.aPJ() != null) {
                    aqVar.forumId = this.cjo.aPJ().getId();
                }
                aiY();
                this.cjo.aB(this.cwQ);
                this.cwP.a(i, i2, aqVar, this.cwQ);
            }
            anVar = new an();
            anVar.pn = -1;
        }
        if (this.cjo != null && this.cjo.aPJ() != null) {
            anVar.forumId = this.cjo.aPJ().getId();
        }
        anVar.forumName = this.cjD;
        if (y.agu().iL(1) != null && this.ctX == 1) {
            this.cwG.setCategoryId(i2);
        }
        this.cwJ = i2;
        this.cwL = anVar;
        b(i, i2, anVar);
        jo(5);
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(ak akVar) {
        this.cwP = akVar;
        this.cwO.a(this.cwX);
    }

    private void jo(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.cwL != null) {
                    this.cwL.pn++;
                    break;
                }
                break;
            case 2:
                if (this.cwL != null) {
                    an anVar = this.cwL;
                    anVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.cwL != null) {
                    this.cwL.pn = -1;
                    break;
                }
                break;
        }
        if (this.ctX == 1) {
            if (this.cwK == this.cwJ) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                if (this.csv != null) {
                    arrayList.addAll(this.csv);
                }
                this.cjo.aB(arrayList);
                if (this.cwP != null) {
                    this.cwP.a(this.ctX, this.cwJ, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.cwK = this.cwJ;
            return;
        }
        ai iM = this.cwO.iM(this.ctX);
        if (iM != null) {
            this.cwM = true;
            iM.a(this.ctX, this.cwJ, this.cwL);
            return;
        }
        if (this.cjo != null && this.cjo.getThreadList() != null) {
            this.cjo.getThreadList().clear();
        }
        this.cwP.a(this.ctX, this.cwJ, null, null);
    }

    public boolean hasMore() {
        if ((this.cwL instanceof aq) && ((aq) this.cwL).errCode == 0) {
            return ((aq) this.cwL).hasMore;
        }
        return true;
    }

    private int aA(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, an anVar) {
        this.cwN.put(aA(i, i2), anVar);
    }

    public an aB(int i, int i2) {
        return this.cwN.get(aA(i, i2));
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        this.cwO.init();
    }

    @Override // com.baidu.tieba.frs.ai
    public void Ox() {
        this.cwO.destory();
        this.cwO.clear();
    }

    public int aiZ() {
        return this.ctX;
    }

    public boolean aja() {
        return 1 == this.ctX;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(ao aoVar) {
        if (aoVar != null && !StringUtils.isNull(aoVar.getId()) && this.csv != null) {
            if (this.ctX == 1) {
                this.cjo.a(aoVar);
            }
            int ajb = ajb();
            if (this.csv != null && this.csv.size() > 0) {
                int size = this.csv.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.f fVar = this.csv.get(i);
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
                    this.csv.add(ajb, axVar);
                    return;
                }
                return;
            }
            this.csv.add(ajb, aoVar);
        }
    }

    public int ajb() {
        int i = 0;
        if (this.csv == null || this.csv.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.csv.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (!(next instanceof bl)) {
                    i = i2;
                } else if (((bl) next).rB() != 0) {
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

    public boolean ajc() {
        return this.cwM;
    }

    public void ajd() {
        com.baidu.tieba.frs.k kVar = new com.baidu.tieba.frs.k();
        if (this.cwK == 0) {
            kVar.iK(this.cwS);
        }
        if (this.cjo.getThreadList() != null) {
            this.cjo.getThreadList().clear();
            this.cjo.getThreadList().add(kVar);
        }
        if (this.csv != null) {
            this.csv.clear();
            this.csv.add(kVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aje() {
        return this.csv;
    }

    public void jp(int i) {
        this.cwS = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.g.btV();
        } else {
            com.baidu.tieba.tbadkCore.util.g.btW();
        }
    }

    public void jq(int i) {
        this.cwT = i;
    }

    public void fa(boolean z) {
        this.cwU = z;
    }

    public int ajf() {
        return this.cwS;
    }

    public int Om() {
        return com.baidu.tieba.frs.f.g.jD(this.cwS);
    }

    public boolean ajg() {
        return this.cwI;
    }

    public boolean ajh() {
        return this.cwS == 5;
    }

    public boolean aji() {
        return this.cwG != null && this.cwG.getLoadType() == 1;
    }

    public boolean ajj() {
        return this.cwS == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.coV.afg() != null) {
            return this.coV.afg().a(this.cwS, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bl.Zm.get() && r.big().bic() != null) {
            int W = r.big().bic().W(str, false);
            int X = r.big().bic().X(str, false);
            if (frsRequestData.getLoadType() == 1) {
                W++;
            } else if (frsRequestData.getLoadType() == 2) {
                X++;
            }
            frsRequestData.setRefreshCount(W);
            frsRequestData.setLoadCount(X);
        }
    }

    public void ajk() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.cjo != null && this.cjo.aPJ() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.d(this.cjo.aPJ().getId(), 0L));
        }
        this.coV.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void ky(final String str) {
        u.a(new t<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bqV().cf(FrsModelController.this.cwV, str);
                return null;
            }
        }, null);
    }

    public void kz(final String str) {
        u.a(new t<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bqV().cg(FrsModelController.this.cwV, str);
                return null;
            }
        }, null);
    }
}
