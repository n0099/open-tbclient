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
    private long aJM;
    private String aiO;
    private int cBt;
    private FrsRequestData cDY;
    private final com.baidu.tieba.tbadkCore.k cDZ;
    private boolean cEa;
    private int cEb;
    private int cEc;
    private an cEd;
    private boolean cEe;
    private SparseArray<an> cEf;
    private aa cEg;
    private ak cEh;
    private ArrayList<com.baidu.adp.widget.ListView.f> cEi;
    private String cEj;
    private int cEk;
    private int cEl;
    private boolean cEm;
    private String cEn;
    private final SparseArray<Boolean> cEo;
    private ak cEp;
    private long cdA;
    private long cdB;
    private long cdC;
    private long cdz;
    private com.baidu.tieba.tbadkCore.i cpA;
    private String cpO;
    private final com.baidu.tieba.frs.f cws;
    private ArrayList<com.baidu.adp.widget.ListView.f> czQ;
    private FrsNetModel<com.baidu.tieba.frs.f> czR;
    private d.a czT;
    private String czU;
    private boolean czX;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean jD(int i) {
        return this.cEo.get(i, false).booleanValue();
    }

    public void p(int i, boolean z) {
        this.cEo.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.f fVar, com.baidu.tieba.tbadkCore.k kVar) {
        super(fVar.getPageContext());
        this.cpO = null;
        this.mType = 3;
        this.mPn = 1;
        this.aiO = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.czU = null;
        this.cBt = 1;
        this.cEb = 0;
        this.cEc = 0;
        this.cEe = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.cEf = new SparseArray<>();
        this.aJM = 0L;
        this.czX = false;
        this.cEk = -1;
        this.cEl = -1;
        this.cEn = null;
        this.cEo = new SparseArray<>();
        this.cEp = new ak() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ak
            public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
                FrsModelController.this.cEe = false;
                if (i == FrsModelController.this.cBt && FrsModelController.this.cEh != null) {
                    FrsModelController.this.cEd = aqVar;
                    FrsModelController.this.b(i, i2, aqVar);
                    ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.cpA.aA(arrayList2);
                    if ((i == 1 || i == 5) && !FrsModelController.this.ald()) {
                        FrsModelController.this.cpA.bru();
                        FrsModelController.this.cpA.brv();
                    }
                    FrsModelController.this.cEh.a(i, i2, aqVar, arrayList);
                }
            }
        };
        this.cdz = 0L;
        this.cdA = 0L;
        this.cdB = 0L;
        this.cdC = 0L;
        if (fVar == null || kVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.cws = fVar;
        this.cDZ = kVar;
        z(this.cws);
    }

    private void z(com.baidu.tieba.frs.f fVar) {
        this.cEg = new aa();
        this.cEg.aOu = fVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.cEg));
        this.cEg.a(this.cEp);
    }

    public void onActivityDestroy() {
        this.czR.cancelLoadData();
    }

    public void i(Bundle bundle) {
        if (bundle != null) {
            this.cpO = bundle.getString("name");
            this.aiO = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.cEj = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.cEa = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.cpO)) {
            this.cpO = "";
        }
        if (TextUtils.isEmpty(this.aiO)) {
            this.aiO = "";
        }
        if (TextUtils.isEmpty(this.cEj)) {
            this.cEj = "";
        }
        this.mSource = this.aiO;
        this.cDY = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            jF(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            jF(6);
        } else {
            com.baidu.tieba.frs.smartsort.f kW = com.baidu.tieba.frs.smartsort.d.alp().kW(this.cpO);
            if (kW != null) {
                jF(kW.cEY);
            } else {
                jF(-1);
            }
        }
        this.cDY.setSortType(OE());
        if (this.cEk == 5) {
            this.cDY.setIsGood(1);
        } else {
            this.cDY.setIsGood(0);
        }
        this.cpA = new com.baidu.tieba.tbadkCore.i();
        this.czR = new FrsNetModel<>(this.cws.getPageContext(), this.cDY);
        this.czR.a(this);
        this.czR.setUniqueId(this.cws.getUniqueId());
        if (this.cpO != null && this.cpO.length() > 0) {
            if (this.aiO == null || this.aiO.length() <= 0) {
                this.aiO = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.cpO);
        bundle.putString("from", this.aiO);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean Zv() {
        if (this.cBt != 1) {
            jE(1);
            return true;
        } else if (this.czR.xa()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cDY), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(OE());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void q(int i, boolean z) {
        if (this.cpA != null && this.cpA.bqT() != null) {
            this.cpA.bqT().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cDY), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.cBt = c(this.cBt, frsRequestData);
        if (this.cBt == 1) {
            if (!this.czR.xa()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.cEd == null) {
            this.cEd = new an();
            this.cEd.pn = 1;
            this.cEd.forumName = this.cpO;
            if (this.cpA != null && this.cpA.aPg() != null) {
                this.cEd.forumId = this.cpA.aPg().getId();
            }
        }
        jE(i);
    }

    public void ju(int i) {
        if (this.cBt != 1) {
            jE(4);
        } else if (!this.czR.xa()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cDY), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(OE());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.cDZ.iT(i);
        this.czR.a(frsRequestData);
        this.mType = i;
        frsRequestData.rS(this.cws.aht() ? "1" : "2");
        if (this.cEm) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.g.g.jT(this.cEl)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.cEm = false;
        frsRequestData.setKw(this.cpO);
        if (com.baidu.tbadk.core.h.oS().oY()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ae = com.baidu.adp.lib.util.k.ae(TbadkCoreApplication.getInst());
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst());
        float ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst());
        int i2 = com.baidu.tbadk.core.util.an.vO().vQ() ? 2 : 1;
        frsRequestData.setScrW(ae);
        frsRequestData.setScrH(af);
        frsRequestData.setScrDip(ag);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.czU);
        frsRequestData.setYuelaouLocate(this.cEj);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(s.Hq(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.f.cpX != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.f.cpX);
        }
        if (com.baidu.tieba.frs.f.cpY != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.f.cpY);
        }
        if (com.baidu.tieba.frs.f.cpZ != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.f.cpZ);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.g.g.a(this.cEk, frsRequestData);
        b(i, frsRequestData);
        a(this.cpO, frsRequestData);
        if (!jD(this.cEk)) {
            String d = com.baidu.tieba.tbadkCore.c.bqv().d(this.cpO, frsRequestData.OE(), frsRequestData.getIsGood(), this.cDY.getCategoryId());
            this.cEn = d;
            new a(this, true, d).execute(new Object[0]);
        }
        ake();
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
        if (gVar == null || gVar.aPg() == null || am.isEmpty(gVar.aPg().getName())) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.cBt = gVar.bqX();
        }
        this.cpA.e(gVar);
        d(this.cpA);
        this.czQ = new ArrayList<>();
        if (frsRequestData != null) {
            this.cDY = frsRequestData;
            this.mPn = this.cDY.getPn();
            this.cpO = this.cDY.getKw();
            this.cws.setForumName(this.cpO);
            this.cws.setFrom(this.aiO);
            this.cws.setPn(this.mPn);
            this.cws.setFlag(this.mFlag);
        }
        if (this.cpA.getThreadList() != null) {
            this.czQ.addAll(this.cpA.getThreadList());
        }
        if (this.cBt != 1 && this.isNetFirstLoad) {
            this.cDZ.a(7, false, this.czT);
        } else {
            this.cDZ.a(this.mType, false, this.czT);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.cDY)) {
            ale();
        }
        this.isNetFirstLoad = false;
        if (gVar.aPg() == null || TextUtils.isEmpty(gVar.aPg().getName()) || frsRequestData == null || r.bho().bhi() == null) {
            return true;
        }
        r.bho().bhi().g(gVar.aPg().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.g, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.g gVar;
        d.a aVar = new d.a();
        aVar.ggc = com.baidu.adp.lib.util.i.hi() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.ggd = mvcSocketResponsedMessage.getDownSize();
        this.czT = aVar;
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
        this.cws.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.g, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.czX) {
            this.czX = true;
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
        aVar.ggc = com.baidu.adp.lib.util.i.hi() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.ggd = mvcHttpResponsedMessage.getDownSize();
        this.czT = aVar;
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
        this.cws.a(errorData);
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
        if (!this.czX) {
            this.czX = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void ahm() {
        if (this.cpA != null && this.cpA.aPg() != null && this.cpA.aPg().getBannerListData() != null) {
            String lastIds = this.cpA.aPg().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.czU = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.l.r.Gx().Gy()) {
            this.aJM = System.currentTimeMillis() - this.cws.Wo;
            m mVar = new m(i, z, responsedMessage, this.cws.aJD, this.cws.createTime, this.cws.aJL, false, this.aJM);
            this.cws.createTime = 0L;
            this.cws.aJD = 0L;
            if (mVar != null) {
                mVar.Gs();
            }
        }
    }

    public FrsRequestData akO() {
        return this.cDY;
    }

    public String akP() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.cpO;
    }

    public int getPn() {
        return this.mPn;
    }

    public com.baidu.tieba.tbadkCore.i akd() {
        return this.cpA;
    }

    public d.a akQ() {
        return this.czT;
    }

    private void ake() {
        this.cdz = System.currentTimeMillis();
        this.czR.Fu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.g gVar) {
        this.isCacheFirstLoad = false;
        this.cpA.e(gVar);
        d(this.cpA);
        this.czQ = new ArrayList<>();
        if (this.cpA.getThreadList() != null) {
            this.czQ.addAll(this.cpA.getThreadList());
        }
        this.cDZ.b(gVar);
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
        private String cEt;
        private FrsModelController cEu;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.cEt = null;
            this.cEt = str;
            this.cEu = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bqv().rQ(this.cEt)) {
                if (!com.baidu.tieba.tbadkCore.c.bqv().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.cEt)) {
                    com.baidu.tieba.tbadkCore.c.bqv().getResponseData().aPg().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.g responseData = com.baidu.tieba.tbadkCore.c.bqv().getResponseData();
                if (responseData.bqZ() != null && !StringUtils.isNull(responseData.bqZ().pK(), true) && !responseData.bqZ().pK().equals("0") && responseData.bqZ().pL() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bqZ().pK(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
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
            if (this.cEu != null && gVarArr != null) {
                this.cEu.d(gVarArr.length > 0 ? gVarArr[0] : null);
                this.cEu.p(this.cEu.cEk, true);
            }
        }
    }

    public long adr() {
        return this.cdC;
    }

    public long ads() {
        return this.cdA;
    }

    public long adt() {
        return this.cdB;
    }

    public long adu() {
        return this.cdz;
    }

    public boolean xa() {
        return this.czR.xa();
    }

    public int akR() {
        return this.cEc;
    }

    private void akS() {
        if (this.cEi == null) {
            this.cEi = new ArrayList<>();
        }
        if (this.cEi.size() == 0) {
            this.cEi.add(new v());
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, an anVar) {
        this.cBt = c(i, null);
        if (anVar == null && (anVar = aE(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.k.hz() && this.cEh != null) {
                aq aqVar = new aq();
                aqVar.hasMore = false;
                aqVar.pn = 1;
                aqVar.forumName = this.cpO;
                aqVar.ctf = false;
                if (this.cpA != null && this.cpA.aPg() != null) {
                    aqVar.forumId = this.cpA.aPg().getId();
                }
                akS();
                this.cpA.aA(this.cEi);
                this.cEh.a(i, i2, aqVar, this.cEi);
            }
            anVar = new an();
            anVar.pn = -1;
        }
        if (this.cpA != null && this.cpA.aPg() != null) {
            anVar.forumId = this.cpA.aPg().getId();
        }
        anVar.forumName = this.cpO;
        if (y.aid().iZ(1) != null && this.cBt == 1) {
            this.cDY.setCategoryId(i2);
        }
        this.cEb = i2;
        this.cEd = anVar;
        b(i, i2, anVar);
        jE(5);
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(ak akVar) {
        this.cEh = akVar;
        this.cEg.a(this.cEp);
    }

    private void jE(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.cEd != null) {
                    this.cEd.pn++;
                    break;
                }
                break;
            case 2:
                if (this.cEd != null) {
                    an anVar = this.cEd;
                    anVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.cEd != null) {
                    this.cEd.pn = -1;
                    break;
                }
                break;
        }
        if (this.cBt == 1) {
            if (this.cEc == this.cEb) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                if (this.czQ != null) {
                    arrayList.addAll(this.czQ);
                }
                this.cpA.aA(arrayList);
                if (this.cEh != null) {
                    this.cEh.a(this.cBt, this.cEb, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.cEc = this.cEb;
            return;
        }
        ai ja = this.cEg.ja(this.cBt);
        if (ja != null) {
            this.cEe = true;
            ja.a(this.cBt, this.cEb, this.cEd);
            return;
        }
        if (this.cpA != null && this.cpA.getThreadList() != null) {
            this.cpA.getThreadList().clear();
        }
        this.cEh.a(this.cBt, this.cEb, null, null);
    }

    public boolean hasMore() {
        if ((this.cEd instanceof aq) && ((aq) this.cEd).errCode == 0) {
            return ((aq) this.cEd).hasMore;
        }
        return true;
    }

    private int aD(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, an anVar) {
        this.cEf.put(aD(i, i2), anVar);
    }

    public an aE(int i, int i2) {
        return this.cEf.get(aD(i, i2));
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        this.cEg.init();
    }

    @Override // com.baidu.tieba.frs.ai
    public void OQ() {
        this.cEg.destory();
        this.cEg.clear();
    }

    public int akT() {
        return this.cBt;
    }

    public boolean akU() {
        return 1 == this.cBt;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(ao aoVar) {
        if (aoVar != null && !StringUtils.isNull(aoVar.getId()) && this.czQ != null) {
            if (this.cBt == 1) {
                this.cpA.a(aoVar);
            }
            int akV = akV();
            if (this.czQ != null && this.czQ.size() > 0) {
                int size = this.czQ.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.f fVar = this.czQ.get(i);
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
                    this.czQ.add(akV, axVar);
                    return;
                }
                return;
            }
            this.czQ.add(akV, aoVar);
        }
    }

    public int akV() {
        int i = 0;
        if (this.czQ == null || this.czQ.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.czQ.iterator();
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

    public boolean akW() {
        return this.cEe;
    }

    public void akX() {
        com.baidu.tieba.frs.k kVar = new com.baidu.tieba.frs.k();
        if (this.cEc == 0) {
            kVar.iY(this.cEk);
        }
        if (this.cpA.getThreadList() != null) {
            this.cpA.getThreadList().clear();
            this.cpA.getThreadList().add(kVar);
        }
        if (this.czQ != null) {
            this.czQ.clear();
            this.czQ.add(kVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> akY() {
        return this.czQ;
    }

    public void jF(int i) {
        this.cEk = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.g.btv();
        } else {
            com.baidu.tieba.tbadkCore.util.g.btw();
        }
    }

    public void jG(int i) {
        this.cEl = i;
    }

    public void fj(boolean z) {
        this.cEm = z;
    }

    public int akZ() {
        return this.cEk;
    }

    public int OE() {
        return com.baidu.tieba.frs.g.g.jT(this.cEk);
    }

    public boolean ala() {
        return this.cEa;
    }

    public boolean alb() {
        return this.cEk == 5;
    }

    public boolean alc() {
        return this.cDY != null && this.cDY.getLoadType() == 1;
    }

    public boolean ald() {
        return this.cEk == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.cws.agP() != null) {
            return this.cws.agP().a(this.cEk, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bj.Yq.get() && r.bho().bhi() != null) {
            int X = r.bho().bhi().X(str, false);
            int Y = r.bho().bhi().Y(str, false);
            if (frsRequestData.getLoadType() == 1) {
                X++;
            } else if (frsRequestData.getLoadType() == 2) {
                Y++;
            }
            frsRequestData.setRefreshCount(X);
            frsRequestData.setLoadCount(Y);
        }
    }

    public void ale() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.cpA != null && this.cpA.aPg() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.cpA.aPg().getId(), 0L));
        }
        this.cws.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void kQ(final String str) {
        u.a(new t<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bqv().ce(FrsModelController.this.cEn, str);
                return null;
            }
        }, null);
    }

    public void kR(final String str) {
        u.a(new t<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bqv().cf(FrsModelController.this.cEn, str);
                return null;
            }
        }, null);
    }
}
