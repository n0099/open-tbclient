package com.baidu.tieba.frs.e;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.performanceLog.aa;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.by;
import com.baidu.tieba.frs.cw;
import com.baidu.tieba.frs.cz;
import com.baidu.tieba.frs.db;
import com.baidu.tieba.frs.dg;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.dn;
import com.baidu.tieba.frs.dq;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.tbadkCore.util.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> implements NetModel.b<m, n>, dg {
    private long aCs;
    private String acU;
    private long bHu;
    private long bHv;
    private long bHw;
    private long bHx;
    private String bPf;
    private p bPq;
    private FrsActivity bWH;
    private ArrayList<v> bZL;
    private c<FrsActivity> bZM;
    e.a bZO;
    private String bZP;
    private boolean bZR;
    private boolean bZS;
    private m ccE;
    private boolean ccF;
    private String ccG;
    private int ccH;
    private int ccI;
    private int ccJ;
    private dn ccK;
    private boolean ccL;
    public boolean ccM;
    public boolean ccN;
    private SparseArray<dn> ccO;
    private db ccP;
    private boolean ccQ;
    private dh ccR;
    private dh ccS;
    private ArrayList<v> ccT;
    private String ccU;
    private int ccV;
    private int mFlag;
    private String mPageType;
    private int mPn;
    private int mSortType;
    private String mSource;
    private int mType;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bPf = null;
        this.mType = 3;
        this.mPn = 1;
        this.acU = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.ccG = null;
        this.bZP = null;
        this.ccH = 1;
        this.ccI = 0;
        this.ccJ = 0;
        this.ccL = false;
        this.ccM = true;
        this.ccN = true;
        this.ccO = new SparseArray<>();
        this.ccQ = false;
        this.ccR = new b(this);
        this.aCs = 0L;
        this.bZR = false;
        this.bZS = false;
        this.ccV = 2;
        this.bHu = 0L;
        this.bHv = 0L;
        this.bHw = 0L;
        this.bHx = 0L;
        this.bWH = frsActivity;
        L(frsActivity);
    }

    private void L(FrsActivity frsActivity) {
        this.ccP = new db();
        this.ccP.aYu = frsActivity.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.ccP));
        this.ccP.a(this.ccR);
    }

    public void onActivityDestroy() {
        this.bZM.cancelLoadData();
    }

    public void d(Bundle bundle) {
        if (bundle != null) {
            this.bPf = bundle.getString("name");
            this.acU = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.ccU = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.ccF = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.bPf)) {
            this.bPf = "";
        }
        if (TextUtils.isEmpty(this.acU)) {
            this.acU = "";
        }
        if (TextUtils.isEmpty(this.ccU)) {
            this.ccU = "";
        }
        this.mSource = this.acU;
        this.ccE = new m();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            this.ccE.setSortType(1);
            this.mSortType = 1;
            hU(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            this.ccE.setSortType(2);
            this.mSortType = 2;
            hU(6);
        } else {
            this.ccE.setSortType(-1);
            this.mSortType = -1;
        }
        this.ccE.setIsGood(0);
        this.bPq = new p();
        this.bZM = new c<>(this.bWH.getPageContext(), this.ccE);
        this.bZM.a(this);
        this.bZM.setUniqueId(getUniqueId());
        if (this.bPf != null && this.bPf.length() > 0) {
            if (this.acU == null || this.acU.length() <= 0) {
                this.acU = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.bPf);
        bundle.putString("from", this.acU);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean Op() {
        if (this.ccH != 1) {
            io(1);
            return true;
        } else if (this.bZM.Fd()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.bWH.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            m mVar = (m) m.objectWithJson(m.jsonWithObject(this.ccE), m.class);
            mVar.setPn(mVar.getPn() + 1);
            mVar.setSortType(this.mSortType);
            a(mVar, 1);
            return true;
        }
    }

    public void B(int i, boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            this.ccQ = true;
        }
        if (this.bPq != null && this.bPq.bhv() != null) {
            this.bPq.bhv().clear();
        }
        m mVar = (m) m.objectWithJson(m.jsonWithObject(this.ccE), m.class);
        mVar.setPn(1);
        this.ccH = b(this.ccH, mVar);
        if (this.ccH == 1) {
            if (!this.bZM.Fd()) {
                a(mVar, i);
                return;
            }
            return;
        }
        if (this.ccK == null) {
            this.ccK = new dn();
            this.ccK.pn = 1;
            this.ccK.forumName = this.bPf;
            if (this.bPq != null && this.bPq.aLP() != null) {
                this.ccK.forumId = this.bPq.aLP().getId();
            }
        }
        io(i);
    }

    public void il(int i) {
        if (this.ccH != 1) {
            io(4);
        } else if (!this.bZM.Fd()) {
            m mVar = (m) m.objectWithJson(m.jsonWithObject(this.ccE), m.class);
            mVar.setPn(i);
            mVar.setSortType(this.mSortType);
            a(mVar, 4);
        }
    }

    private void a(m mVar, int i) {
        boolean z = true;
        this.bWH.bPW.hP(i);
        this.bZM.a(mVar);
        this.mType = i;
        mVar.setKw(this.bPf);
        if (l.oG().oM()) {
            mVar.setRn(35);
        } else {
            mVar.setRn(50);
        }
        mVar.setWithGroup(1);
        mVar.setCid(0);
        int K = k.K(this.bWH.getPageContext().getPageActivity());
        int L = k.L(this.bWH.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = bb.vk().vm() ? 2 : 1;
        mVar.setScrW(K);
        mVar.setScrH(L);
        mVar.setScrDip(f);
        mVar.setqType(i2);
        mVar.setLastId(this.bZP);
        mVar.setYuelaouLocate(this.ccU);
        mVar.setLastClickTid(com.baidu.adp.lib.h.b.c(s.He(), 0L));
        if (this.mSource != null) {
            mVar.setStType(this.mSource);
            if (this.mSource.equalsIgnoreCase("sidebar")) {
                mVar.setStType(this.ccG);
            }
        }
        if (FrsActivity.bPu != 0) {
            mVar.setCtime((int) FrsActivity.bPu);
        }
        if (FrsActivity.bPv != 0) {
            mVar.setDataSize((int) FrsActivity.bPv);
        }
        if (FrsActivity.bPw != 0) {
            mVar.setNetError(FrsActivity.bPw);
        }
        if (mVar.getPn() != 1 || ((!this.mPageType.equals("normal_page") && !this.mPageType.equals("frs_page") && !this.mPageType.equals("book_page")) || this.mType != 3)) {
            z = false;
        }
        mVar.setUpdateType(this.mType);
        mVar.setNeedCache(z);
        if (!z) {
            adW();
            return;
        }
        adW();
        new C0056a(this, z, d.bgZ().e(this.bPf, mVar.bhc(), mVar.getIsGood(), this.ccE.getCategoryId())).execute(new Object[0]);
    }

    protected boolean a(m mVar, n nVar) {
        if (this.ccM) {
            this.ccH = nVar.bhz();
        }
        if (aeS()) {
            this.ccV = 7;
        }
        this.bPq.d(nVar);
        this.bZL = new ArrayList<>();
        if (com.baidu.tieba.frs.i.p.i(this.bPq)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.i.p.j(this.bPq)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        if (mVar != null) {
            this.ccE = mVar;
            this.mPn = this.ccE.getPn();
            this.bPf = this.ccE.getKw();
            this.bWH.jJ(this.bPf);
            this.bWH.setFrom(this.acU);
            this.bWH.setPn(this.mPn);
            this.bWH.setFlag(this.mFlag);
        }
        if (this.bPq.getThreadList() != null) {
            this.bZL.addAll(this.bPq.getThreadList());
        }
        if (this.ccH != 1 && this.ccM) {
            this.bWH.bPW.a(7, false, this.bZO);
        } else {
            this.bWH.bPW.a(this.mType, false, this.bZO);
        }
        this.mSource = null;
        if (this.ccQ) {
            aeV();
            this.ccQ = false;
        }
        this.ccM = false;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<n, ?> mvcSocketResponsedMessage, MvcSocketMessage<m, n> mvcSocketMessage, MvcNetMessage<m, n> mvcNetMessage) {
        n nVar;
        e.a aVar = new e.a();
        aVar.fpA = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.fpB = mvcSocketResponsedMessage.getDownSize();
        this.bZO = aVar;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
            nVar = null;
        } else {
            nVar = mvcSocketResponsedMessage.getData();
            r3 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && nVar != null && a(r3, nVar)) {
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
        this.bWH.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<n, ?> mvcSocketResponsedMessage, MvcSocketMessage<m, n> mvcSocketMessage, MvcNetMessage<m, n> mvcNetMessage) {
        m mVar;
        m mVar2 = null;
        if (!this.bZS) {
            this.bZS = true;
            if (this.bWH.bPW != null) {
                a(1000, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
            }
        }
        long j = 0;
        if (mvcSocketMessage != null) {
            j = mvcSocketMessage.getClientLogID();
            mVar2 = mvcSocketMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            mVar = mvcNetMessage.getRequestData();
        } else {
            mVar = mVar2;
        }
        int error = mvcSocketResponsedMessage.getError();
        String errorString = mvcSocketResponsedMessage.getErrorString();
        if (error != 0) {
            int cmd = mvcSocketResponsedMessage.getCmd();
            Object[] objArr = new Object[4];
            objArr[0] = "kw";
            objArr[1] = mVar != null ? mVar.getKw() : null;
            objArr[2] = "seq_id";
            objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
            com.baidu.tbadk.core.log.b.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<n> mvcHttpResponsedMessage, MvcHttpMessage<m, n> mvcHttpMessage, MvcNetMessage<m, n> mvcNetMessage) {
        n nVar;
        e.a aVar = new e.a();
        aVar.fpA = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.fpB = mvcHttpResponsedMessage.getDownSize();
        this.bZO = aVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            nVar = null;
        } else {
            nVar = mvcHttpResponsedMessage.getData();
            r3 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && nVar != null && a(r3, nVar)) {
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
        this.bWH.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    @Override // com.baidu.adp.base.e
    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        super.registerListener(i, aVar);
    }

    private void b(MvcHttpResponsedMessage<n> mvcHttpResponsedMessage, MvcHttpMessage<m, n> mvcHttpMessage, MvcNetMessage<m, n> mvcNetMessage) {
        m mVar;
        m mVar2 = null;
        long j = 0;
        if (mvcHttpMessage != null) {
            j = mvcHttpMessage.getClientLogID();
            mVar2 = mvcHttpMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            mVar = mvcNetMessage.getRequestData();
        } else {
            mVar = mVar2;
        }
        int error = mvcHttpResponsedMessage.getError();
        String errorString = mvcHttpResponsedMessage.getErrorString();
        if (error != 0) {
            int cmd = mvcHttpResponsedMessage.getCmd();
            Object[] objArr = new Object[2];
            objArr[0] = "kw";
            objArr[1] = mVar != null ? mVar.getKw() : null;
            com.baidu.tbadk.core.log.b.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
        if (!this.bZS) {
            this.bZS = true;
            if (this.bWH.bPW != null) {
                a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            }
        }
    }

    public void aaK() {
        if (this.bPq != null && this.bPq.aLP() != null && this.bPq.aLP().getBannerListData() != null) {
            String lastIds = this.bPq.aLP().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.bZP = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.Gp().Gq()) {
            this.aCs = System.currentTimeMillis() - this.bWH.QZ;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v(i, z, responsedMessage, this.bWH.aCj, this.bWH.createTime, this.bWH.aCr, false, this.aCs);
            this.bWH.createTime = 0L;
            this.bWH.aCj = 0L;
            if (vVar != null) {
                vVar.Gk();
            }
        }
    }

    public String aeH() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public p adV() {
        return this.bPq;
    }

    public e.a aeI() {
        return this.bZO;
    }

    private void adW() {
        this.bHu = System.currentTimeMillis();
        this.bZM.Fa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(n nVar) {
        this.bWH.bPW.b(nVar);
        this.ccN = false;
        this.bPq.d(nVar);
        this.bZL = new ArrayList<>();
        if (this.bPq.getThreadList() != null) {
            this.bZL.addAll(this.bPq.getThreadList());
        }
        if (com.baidu.tieba.frs.i.p.i(this.bPq)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.i.p.j(this.bPq)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    public boolean aeJ() {
        return this.ccV == 5;
    }

    /* renamed from: com.baidu.tieba.frs.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0056a extends BdAsyncTask<Object, n, Void> {
        private String ccX;
        private a ccY;
        private boolean needCache;

        public C0056a(a aVar, boolean z, String str) {
            this.ccX = null;
            this.ccX = str;
            this.ccY = aVar;
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
            if (this.needCache && d.bgZ().qF(this.ccX)) {
                if (!d.bgZ().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.ccX)) {
                    d.bgZ().getResponseData().aLP().getSignData().is_signed = 0;
                }
                n responseData = d.bgZ().getResponseData();
                if (responseData.bhB() != null && !StringUtils.isNull(responseData.bhB().getBookId(), true) && !responseData.bhB().getBookId().equals("0") && responseData.bhB().px() == 3 && (g = com.baidu.adp.lib.h.b.g(responseData.bhB().getBookId(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
                    responseData.h(Integer.valueOf(((Integer) runTask.getData()).intValue()));
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
        public void onProgressUpdate(n... nVarArr) {
            super.onProgressUpdate(nVarArr);
            this.ccY.c(nVarArr.length > 0 ? nVarArr[0] : null);
        }
    }

    public long XJ() {
        return this.bHx;
    }

    public long XK() {
        return this.bHv;
    }

    public long XL() {
        return this.bHw;
    }

    public long XM() {
        return this.bHu;
    }

    public boolean Fd() {
        return this.bZM.Fd();
    }

    public int aeK() {
        return this.ccJ;
    }

    private void aeL() {
        if (this.ccT == null) {
            this.ccT = new ArrayList<>();
        }
        if (this.ccT.size() == 0) {
            this.ccT.add(new cw());
        }
    }

    @Override // com.baidu.tieba.frs.dg
    public void a(int i, int i2, dn dnVar) {
        this.ccH = b(i, null);
        if (dnVar == null && (dnVar = am(i, i2)) == null) {
            if (i != 1 && k.gD() && this.ccS != null) {
                dq dqVar = new dq();
                dqVar.hasMore = false;
                dqVar.pn = 1;
                dqVar.forumName = this.bPf;
                dqVar.bTI = false;
                if (this.bPq != null && this.bPq.aLP() != null) {
                    dqVar.forumId = this.bPq.aLP().getId();
                }
                aeL();
                this.bPq.aA(this.ccT);
                this.ccS.a(i, i2, dqVar, this.ccT);
            }
            dnVar = new dn();
            dnVar.pn = -1;
        }
        if (this.bPq != null && this.bPq.aLP() != null) {
            dnVar.forumId = this.bPq.aLP().getId();
        }
        dnVar.forumName = this.bPf;
        if (cz.acl().hV(1) != null && this.ccH == 1) {
            this.ccE.setCategoryId(i2);
        }
        this.ccI = i2;
        this.ccK = dnVar;
        b(i, i2, dnVar);
        io(5);
    }

    @Override // com.baidu.tieba.frs.dg
    public void a(dh dhVar) {
        this.ccS = dhVar;
        this.ccP.a(this.ccR);
    }

    private void io(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.ccK != null) {
                    this.ccK.pn++;
                    break;
                }
                break;
            case 2:
                if (this.ccK != null) {
                    dn dnVar = this.ccK;
                    dnVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.ccK != null) {
                    this.ccK.pn = -1;
                    break;
                }
                break;
        }
        if (this.ccH == 1) {
            if (this.ccJ == this.ccI) {
                ArrayList<v> arrayList = new ArrayList<>();
                if (this.bZL != null) {
                    arrayList.addAll(this.bZL);
                }
                this.bPq.aA(arrayList);
                if (this.ccS != null) {
                    this.ccS.a(this.ccH, this.ccI, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.ccJ = this.ccI;
            return;
        }
        dg hW = this.ccP.hW(this.ccH);
        if (hW != null) {
            this.ccL = true;
            hW.a(this.ccH, this.ccI, this.ccK);
            return;
        }
        if (this.bPq != null && this.bPq.getThreadList() != null) {
            this.bPq.getThreadList().clear();
        }
        this.ccS.a(this.ccH, this.ccI, null, null);
    }

    public boolean hasMore() {
        if ((this.ccK instanceof dq) && ((dq) this.ccK).errCode == 0) {
            return ((dq) this.ccK).hasMore;
        }
        return true;
    }

    private int al(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, dn dnVar) {
        this.ccO.put(al(i, i2), dnVar);
    }

    public dn am(int i, int i2) {
        return this.ccO.get(al(i, i2));
    }

    @Override // com.baidu.tieba.frs.dg
    public void init() {
        this.ccP.init();
    }

    @Override // com.baidu.tieba.frs.dg
    public void aaf() {
        this.ccP.destory();
        this.ccP.clear();
    }

    public int aeM() {
        return this.ccH;
    }

    public boolean aeN() {
        return 1 == this.ccH || 2 == this.ccH;
    }

    @Override // com.baidu.adp.base.e
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(ah ahVar) {
        if (ahVar != null && !StringUtils.isNull(ahVar.getId()) && this.bZL != null) {
            if (this.ccH == 1) {
                this.bPq.a(ahVar);
            }
            int aeO = aeO();
            if (this.bZL != null && this.bZL.size() > 0) {
                int size = this.bZL.size();
                for (int i = 0; i < size; i++) {
                    v vVar = this.bZL.get(i);
                    if ((vVar instanceof bg) && ahVar.getId().equals(((bg) vVar).getId())) {
                        return;
                    }
                }
            }
            if (ahVar.getThreadType() == 33) {
                aq aqVar = new aq();
                aqVar.a(ahVar, -1);
                aqVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.bZL.add(aeO, aqVar);
                    return;
                }
                return;
            }
            this.bZL.add(aeO, ahVar);
        }
    }

    public int aeO() {
        if (this.bZL == null || this.bZL.size() <= 0) {
            return 0;
        }
        Iterator<v> it = this.bZL.iterator();
        int i = 0;
        while (it.hasNext()) {
            v next = it.next();
            if (next instanceof bg) {
                if (((bg) next).rx() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public boolean aeP() {
        return this.ccL;
    }

    public void aeQ() {
        by byVar = new by();
        if (this.ccJ == 0) {
            byVar.hU(this.ccV);
        }
        if (this.bPq.getThreadList() != null) {
            this.bPq.getThreadList().clear();
            this.bPq.getThreadList().add(byVar);
        }
        if (this.bZL != null) {
            this.bZL.clear();
            this.bZL.add(byVar);
        }
    }

    public void hU(int i) {
        this.ccV = i;
    }

    public int acf() {
        return this.ccV;
    }

    public boolean aeR() {
        return this.ccF;
    }

    public boolean aeS() {
        return this.mSortType == 3;
    }

    public void ip(int i) {
        switch (i) {
            case 2:
                this.mSortType = 0;
                break;
            case 3:
                this.mSortType = 1;
                break;
            case 4:
            case 5:
            default:
                this.mSortType = -1;
                break;
            case 6:
                this.mSortType = 2;
                break;
            case 7:
                this.mSortType = 3;
                break;
        }
        if (7 == i) {
            t.bkc();
        } else {
            t.bkd();
        }
    }

    public int aeT() {
        return this.mSortType;
    }

    private int b(int i, m mVar) {
        if ((i == 1 || i == 2) && this.bWH.abf() != null) {
            return this.bWH.abf().a(this.ccV, mVar);
        }
        return i;
    }

    public int aeU() {
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.acU)) {
            return 3;
        }
        if (!FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.acU)) {
            return 0;
        }
        return 6;
    }

    public void aeV() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.bPq != null && this.bPq.aLP() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.h.b.c(this.bPq.aLP().getId(), 0L));
        }
        this.bWH.sendMessage(requestIncrForumAccessCountNetMessage);
    }
}
