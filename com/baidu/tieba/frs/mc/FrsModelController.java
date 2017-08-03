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
    private long aIU;
    private String aia;
    private long bXS;
    private long bXT;
    private long bXU;
    private long bXV;
    private String chI;
    private com.baidu.tieba.tbadkCore.i chu;
    private final com.baidu.tieba.frs.f cna;
    private ArrayList<com.baidu.adp.widget.ListView.f> cqC;
    private FrsNetModel<com.baidu.tieba.frs.f> cqD;
    private d.a cqF;
    private String cqG;
    private boolean cqJ;
    private ak ctA;
    private FrsRequestData cti;
    private final com.baidu.tieba.tbadkCore.k ctj;
    private boolean ctk;
    private int ctl;
    private int ctm;
    private int ctn;
    private an cto;
    private boolean ctp;
    private SparseArray<an> ctq;
    private aa ctr;
    private ak cts;
    private ArrayList<com.baidu.adp.widget.ListView.f> ctt;
    private String ctu;
    private int ctv;
    private int ctw;
    private boolean ctx;
    private String cty;
    private final SparseArray<Boolean> ctz;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean jd(int i) {
        return this.ctz.get(i, false).booleanValue();
    }

    public void p(int i, boolean z) {
        this.ctz.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.f fVar, com.baidu.tieba.tbadkCore.k kVar) {
        super(fVar.getPageContext());
        this.chI = null;
        this.mType = 3;
        this.mPn = 1;
        this.aia = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.cqG = null;
        this.ctl = 1;
        this.ctm = 0;
        this.ctn = 0;
        this.ctp = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.ctq = new SparseArray<>();
        this.aIU = 0L;
        this.cqJ = false;
        this.ctv = -1;
        this.ctw = -1;
        this.cty = null;
        this.ctz = new SparseArray<>();
        this.ctA = new ak() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ak
            public void a(int i, int i2, aq aqVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
                FrsModelController.this.ctp = false;
                if (i == FrsModelController.this.ctl && FrsModelController.this.cts != null) {
                    FrsModelController.this.cto = aqVar;
                    FrsModelController.this.b(i, i2, aqVar);
                    ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.chu.aB(arrayList2);
                    if ((i == 1 || i == 5) && !FrsModelController.this.aiw()) {
                        FrsModelController.this.chu.brm();
                        FrsModelController.this.chu.brn();
                    }
                    FrsModelController.this.cts.a(i, i2, aqVar, arrayList);
                }
            }
        };
        this.bXS = 0L;
        this.bXT = 0L;
        this.bXU = 0L;
        this.bXV = 0L;
        if (fVar == null || kVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.cna = fVar;
        this.ctj = kVar;
        A(this.cna);
    }

    private void A(com.baidu.tieba.frs.f fVar) {
        this.ctr = new aa();
        this.ctr.aNy = fVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.ctr));
        this.ctr.a(this.ctA);
    }

    public void onActivityDestroy() {
        this.cqD.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.chI = bundle.getString("name");
            this.aia = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.ctu = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.ctk = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.chI)) {
            this.chI = "";
        }
        if (TextUtils.isEmpty(this.aia)) {
            this.aia = "";
        }
        if (TextUtils.isEmpty(this.ctu)) {
            this.ctu = "";
        }
        this.mSource = this.aia;
        this.cti = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            jf(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            jf(6);
        } else {
            com.baidu.tieba.frs.smartsort.f kt = com.baidu.tieba.frs.smartsort.d.aiI().kt(this.chI);
            if (kt != null) {
                jf(kt.cui);
            } else {
                jf(-1);
            }
        }
        this.cti.setSortType(Oh());
        if (this.ctv == 5) {
            this.cti.setIsGood(1);
        } else {
            this.cti.setIsGood(0);
        }
        this.chu = new com.baidu.tieba.tbadkCore.i();
        this.cqD = new FrsNetModel<>(this.cna.getPageContext(), this.cti);
        this.cqD.a(this);
        this.cqD.setUniqueId(this.cna.getUniqueId());
        if (this.chI != null && this.chI.length() > 0) {
            if (this.aia == null || this.aia.length() <= 0) {
                this.aia = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.chI);
        bundle.putString("from", this.aia);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean XK() {
        if (this.ctl != 1) {
            je(1);
            return true;
        } else if (this.cqD.wT()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cti), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(Oh());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void q(int i, boolean z) {
        if (this.chu != null && this.chu.bqL() != null) {
            this.chu.bqL().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cti), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.ctl = c(this.ctl, frsRequestData);
        if (this.ctl == 1) {
            if (!this.cqD.wT()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.cto == null) {
            this.cto = new an();
            this.cto.pn = 1;
            this.cto.forumName = this.chI;
            if (this.chu != null && this.chu.aOW() != null) {
                this.cto.forumId = this.chu.aOW().getId();
            }
        }
        je(i);
    }

    public void jc(int i) {
        if (this.ctl != 1) {
            je(4);
        } else if (!this.cqD.wT()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cti), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(Oh());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.ctj.iD(i);
        this.cqD.a(frsRequestData);
        this.mType = i;
        frsRequestData.rJ(this.cna.afo() ? "1" : "2");
        if (this.ctx) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.g.g.jt(this.ctw)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.ctx = false;
        frsRequestData.setKw(this.chI);
        if (com.baidu.tbadk.core.h.oN().oT()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst());
        float ah = com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst());
        int i2 = am.vG().vI() ? 2 : 1;
        frsRequestData.setScrW(af);
        frsRequestData.setScrH(ag);
        frsRequestData.setScrDip(ah);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.cqG);
        frsRequestData.setYuelaouLocate(this.ctu);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(s.Hj(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.f.chR != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.f.chR);
        }
        if (com.baidu.tieba.frs.f.chS != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.f.chS);
        }
        if (com.baidu.tieba.frs.f.chT != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.f.chT);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.g.g.a(this.ctv, frsRequestData);
        b(i, frsRequestData);
        a(this.chI, frsRequestData);
        if (!jd(this.ctv)) {
            String g = com.baidu.tieba.tbadkCore.c.bqn().g(this.chI, frsRequestData.Oh(), frsRequestData.getIsGood(), this.cti.getCategoryId());
            this.cty = g;
            new a(this, true, g).execute(new Object[0]);
        }
        ahL();
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
        if (gVar == null || gVar.aOW() == null || StringUtils.isNull(gVar.aOW().getName())) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.ctl = gVar.bqP();
        }
        this.chu.e(gVar);
        d(this.chu);
        this.cqC = new ArrayList<>();
        if (frsRequestData != null) {
            this.cti = frsRequestData;
            this.mPn = this.cti.getPn();
            this.chI = this.cti.getKw();
            this.cna.setForumName(this.chI);
            this.cna.setFrom(this.aia);
            this.cna.setPn(this.mPn);
            this.cna.setFlag(this.mFlag);
        }
        if (this.chu.getThreadList() != null) {
            this.cqC.addAll(this.chu.getThreadList());
        }
        if (this.ctl != 1 && this.isNetFirstLoad) {
            this.ctj.a(7, false, this.cqF);
        } else {
            this.ctj.a(this.mType, false, this.cqF);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.cti)) {
            aix();
        }
        this.isNetFirstLoad = false;
        if (gVar.aOW() == null || TextUtils.isEmpty(gVar.aOW().getName()) || frsRequestData == null || r.bhv().bhr() == null) {
            return true;
        }
        r.bhv().bhr().g(gVar.aOW().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.g, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.g gVar;
        d.a aVar = new d.a();
        aVar.gdD = com.baidu.adp.lib.util.i.hh() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gdE = mvcSocketResponsedMessage.getDownSize();
        this.cqF = aVar;
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
        this.cna.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.g, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.g> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.cqJ) {
            this.cqJ = true;
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
        aVar.gdD = com.baidu.adp.lib.util.i.hh() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gdE = mvcHttpResponsedMessage.getDownSize();
        this.cqF = aVar;
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
        this.cna.a(errorData);
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
        if (!this.cqJ) {
            this.cqJ = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void afi() {
        if (this.chu != null && this.chu.aOW() != null && this.chu.aOW().getBannerListData() != null) {
            String lastIds = this.chu.aOW().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.cqG = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.l.r.Gr().Gs()) {
            this.aIU = System.currentTimeMillis() - this.cna.VG;
            m mVar = new m(i, z, responsedMessage, this.cna.aIL, this.cna.createTime, this.cna.aIT, false, this.aIU);
            this.cna.createTime = 0L;
            this.cna.aIL = 0L;
            if (mVar != null) {
                mVar.Gm();
            }
        }
    }

    public FrsRequestData aih() {
        return this.cti;
    }

    public String aii() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.chI;
    }

    public int getPn() {
        return this.mPn;
    }

    public com.baidu.tieba.tbadkCore.i ahK() {
        return this.chu;
    }

    public d.a aij() {
        return this.cqF;
    }

    private void ahL() {
        this.bXS = System.currentTimeMillis();
        this.cqD.Fo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.g gVar) {
        this.isCacheFirstLoad = false;
        this.chu.e(gVar);
        d(this.chu);
        this.cqC = new ArrayList<>();
        if (this.chu.getThreadList() != null) {
            this.cqC.addAll(this.chu.getThreadList());
        }
        this.ctj.b(gVar);
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
        private String ctE;
        private FrsModelController ctF;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.ctE = null;
            this.ctE = str;
            this.ctF = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bqn().rH(this.ctE)) {
                if (!com.baidu.tieba.tbadkCore.c.bqn().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.ctE)) {
                    com.baidu.tieba.tbadkCore.c.bqn().getResponseData().aOW().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.g responseData = com.baidu.tieba.tbadkCore.c.bqn().getResponseData();
                if (responseData.bqR() != null && !StringUtils.isNull(responseData.bqR().getBookId(), true) && !responseData.bqR().getBookId().equals("0") && responseData.bqR().pF() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bqR().getBookId(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
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
            if (this.ctF != null && gVarArr != null) {
                this.ctF.d(gVarArr.length > 0 ? gVarArr[0] : null);
                this.ctF.p(this.ctF.ctv, true);
            }
        }
    }

    public long abK() {
        return this.bXV;
    }

    public long abL() {
        return this.bXT;
    }

    public long abM() {
        return this.bXU;
    }

    public long abN() {
        return this.bXS;
    }

    public boolean wT() {
        return this.cqD.wT();
    }

    public int aik() {
        return this.ctn;
    }

    private void ail() {
        if (this.ctt == null) {
            this.ctt = new ArrayList<>();
        }
        if (this.ctt.size() == 0) {
            this.ctt.add(new v());
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, an anVar) {
        this.ctl = c(i, null);
        if (anVar == null && (anVar = as(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.k.hy() && this.cts != null) {
                aq aqVar = new aq();
                aqVar.hasMore = false;
                aqVar.pn = 1;
                aqVar.forumName = this.chI;
                aqVar.ckY = false;
                if (this.chu != null && this.chu.aOW() != null) {
                    aqVar.forumId = this.chu.aOW().getId();
                }
                ail();
                this.chu.aB(this.ctt);
                this.cts.a(i, i2, aqVar, this.ctt);
            }
            anVar = new an();
            anVar.pn = -1;
        }
        if (this.chu != null && this.chu.aOW() != null) {
            anVar.forumId = this.chu.aOW().getId();
        }
        anVar.forumName = this.chI;
        if (y.afY().iJ(1) != null && this.ctl == 1) {
            this.cti.setCategoryId(i2);
        }
        this.ctm = i2;
        this.cto = anVar;
        b(i, i2, anVar);
        je(5);
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(ak akVar) {
        this.cts = akVar;
        this.ctr.a(this.ctA);
    }

    private void je(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.cto != null) {
                    this.cto.pn++;
                    break;
                }
                break;
            case 2:
                if (this.cto != null) {
                    an anVar = this.cto;
                    anVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.cto != null) {
                    this.cto.pn = -1;
                    break;
                }
                break;
        }
        if (this.ctl == 1) {
            if (this.ctn == this.ctm) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                if (this.cqC != null) {
                    arrayList.addAll(this.cqC);
                }
                this.chu.aB(arrayList);
                if (this.cts != null) {
                    this.cts.a(this.ctl, this.ctm, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.ctn = this.ctm;
            return;
        }
        ai iK = this.ctr.iK(this.ctl);
        if (iK != null) {
            this.ctp = true;
            iK.a(this.ctl, this.ctm, this.cto);
            return;
        }
        if (this.chu != null && this.chu.getThreadList() != null) {
            this.chu.getThreadList().clear();
        }
        this.cts.a(this.ctl, this.ctm, null, null);
    }

    public boolean hasMore() {
        if ((this.cto instanceof aq) && ((aq) this.cto).errCode == 0) {
            return ((aq) this.cto).hasMore;
        }
        return true;
    }

    private int ar(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, an anVar) {
        this.ctq.put(ar(i, i2), anVar);
    }

    public an as(int i, int i2) {
        return this.ctq.get(ar(i, i2));
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        this.ctr.init();
    }

    @Override // com.baidu.tieba.frs.ai
    public void Os() {
        this.ctr.destory();
        this.ctr.clear();
    }

    public int aim() {
        return this.ctl;
    }

    public boolean ain() {
        return 1 == this.ctl;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(ao aoVar) {
        if (aoVar != null && !StringUtils.isNull(aoVar.getId()) && this.cqC != null) {
            if (this.ctl == 1) {
                this.chu.a(aoVar);
            }
            int aio = aio();
            if (this.cqC != null && this.cqC.size() > 0) {
                int size = this.cqC.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.f fVar = this.cqC.get(i);
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
                    this.cqC.add(aio, axVar);
                    return;
                }
                return;
            }
            this.cqC.add(aio, aoVar);
        }
    }

    public int aio() {
        int i = 0;
        if (this.cqC == null || this.cqC.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.cqC.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (!(next instanceof bl)) {
                    i = i2;
                } else if (((bl) next).rq() != 0) {
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

    public boolean aip() {
        return this.ctp;
    }

    public void aiq() {
        com.baidu.tieba.frs.k kVar = new com.baidu.tieba.frs.k();
        if (this.ctn == 0) {
            kVar.iI(this.ctv);
        }
        if (this.chu.getThreadList() != null) {
            this.chu.getThreadList().clear();
            this.chu.getThreadList().add(kVar);
        }
        if (this.cqC != null) {
            this.cqC.clear();
            this.cqC.add(kVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> air() {
        return this.cqC;
    }

    public void jf(int i) {
        this.ctv = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.g.btn();
        } else {
            com.baidu.tieba.tbadkCore.util.g.bto();
        }
    }

    public void jg(int i) {
        this.ctw = i;
    }

    public void eX(boolean z) {
        this.ctx = z;
    }

    public int ais() {
        return this.ctv;
    }

    public int Oh() {
        return com.baidu.tieba.frs.g.g.jt(this.ctv);
    }

    public boolean ait() {
        return this.ctk;
    }

    public boolean aiu() {
        return this.ctv == 5;
    }

    public boolean aiv() {
        return this.cti != null && this.cti.getLoadType() == 1;
    }

    public boolean aiw() {
        return this.ctv == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.cna.aeL() != null) {
            return this.cna.aeL().a(this.ctv, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bl.XN.get() && r.bhv().bhr() != null) {
            int W = r.bhv().bhr().W(str, false);
            int X = r.bhv().bhr().X(str, false);
            if (frsRequestData.getLoadType() == 1) {
                W++;
            } else if (frsRequestData.getLoadType() == 2) {
                X++;
            }
            frsRequestData.setRefreshCount(W);
            frsRequestData.setLoadCount(X);
        }
    }

    public void aix() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.chu != null && this.chu.aOW() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.chu.aOW().getId(), 0L));
        }
        this.cna.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void kn(final String str) {
        u.a(new t<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bqn().cc(FrsModelController.this.cty, str);
                return null;
            }
        }, null);
    }

    public void ko(final String str) {
        u.a(new t<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.t
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bqn().cd(FrsModelController.this.cty, str);
                return null;
            }
        }, null);
    }
}
