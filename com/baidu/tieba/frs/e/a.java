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
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
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
    private long aBV;
    private String adg;
    private long bHB;
    private long bHC;
    private long bHD;
    private long bHE;
    private String bOZ;
    private p bPk;
    private FrsActivity bWH;
    private ArrayList<v> bZI;
    private c<FrsActivity> bZJ;
    e.a bZL;
    private String bZM;
    private boolean bZO;
    private boolean bZP;
    private m ccE;
    private boolean ccF;
    private int ccG;
    private int ccH;
    private int ccI;
    private dn ccJ;
    private boolean ccK;
    public boolean ccL;
    public boolean ccM;
    private SparseArray<dn> ccN;
    private db ccO;
    private boolean ccP;
    private dh ccQ;
    private dh ccR;
    private ArrayList<v> ccS;
    private String ccT;
    private int ccU;
    private int mFlag;
    private String mPageType;
    private int mPn;
    private int mSortType;
    private String mSource;
    private int mType;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bOZ = null;
        this.mType = 3;
        this.mPn = 1;
        this.adg = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.bZM = null;
        this.ccG = 1;
        this.ccH = 0;
        this.ccI = 0;
        this.ccK = false;
        this.ccL = true;
        this.ccM = true;
        this.ccN = new SparseArray<>();
        this.ccP = false;
        this.ccQ = new b(this);
        this.aBV = 0L;
        this.bZO = false;
        this.bZP = false;
        this.ccU = 2;
        this.bHB = 0L;
        this.bHC = 0L;
        this.bHD = 0L;
        this.bHE = 0L;
        this.bWH = frsActivity;
        N(frsActivity);
    }

    private void N(FrsActivity frsActivity) {
        this.ccO = new db();
        this.ccO.aYW = frsActivity.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.ccO));
        this.ccO.a(this.ccQ);
    }

    public void onActivityDestroy() {
        this.bZJ.cancelLoadData();
    }

    public void d(Bundle bundle) {
        if (bundle != null) {
            this.bOZ = bundle.getString("name");
            this.adg = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.ccT = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.ccF = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.bOZ)) {
            this.bOZ = "";
        }
        if (TextUtils.isEmpty(this.adg)) {
            this.adg = "";
        }
        if (TextUtils.isEmpty(this.ccT)) {
            this.ccT = "";
        }
        this.mSource = this.adg;
        this.ccE = new m();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            this.ccE.setSortType(1);
            this.mSortType = 1;
            hY(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            this.ccE.setSortType(2);
            this.mSortType = 2;
            hY(6);
        } else {
            this.ccE.setSortType(-1);
            this.mSortType = -1;
        }
        this.ccE.setIsGood(0);
        this.bPk = new p();
        this.bZJ = new c<>(this.bWH.getPageContext(), this.ccE);
        this.bZJ.a(this);
        this.bZJ.setUniqueId(getUniqueId());
        if (this.bOZ != null && this.bOZ.length() > 0) {
            if (this.adg == null || this.adg.length() <= 0) {
                this.adg = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.bOZ);
        bundle.putString("from", this.adg);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean OR() {
        if (this.ccG != 1) {
            it(1);
            return true;
        } else if (this.bZJ.wG()) {
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
            this.ccP = true;
        }
        if (this.bPk != null && this.bPk.bie() != null) {
            this.bPk.bie().clear();
        }
        m mVar = (m) m.objectWithJson(m.jsonWithObject(this.ccE), m.class);
        mVar.setPn(1);
        this.ccG = b(this.ccG, mVar);
        if (this.ccG == 1) {
            if (!this.bZJ.wG()) {
                a(mVar, i);
                return;
            }
            return;
        }
        if (this.ccJ == null) {
            this.ccJ = new dn();
            this.ccJ.pn = 1;
            this.ccJ.forumName = this.bOZ;
            if (this.bPk != null && this.bPk.aMr() != null) {
                this.ccJ.forumId = this.bPk.aMr().getId();
            }
        }
        it(i);
    }

    public void ip(int i) {
        if (this.ccG != 1) {
            it(4);
        } else if (!this.bZJ.wG()) {
            m mVar = (m) m.objectWithJson(m.jsonWithObject(this.ccE), m.class);
            mVar.setPn(i);
            mVar.setSortType(this.mSortType);
            a(mVar, 4);
        }
    }

    private void a(m mVar, int i) {
        boolean z = true;
        this.bWH.bPP.hT(i);
        this.bZJ.a(mVar);
        this.mType = i;
        mVar.setKw(this.bOZ);
        if (l.oH().oN()) {
            mVar.setRn(35);
        } else {
            mVar.setRn(50);
        }
        mVar.setWithGroup(1);
        mVar.setCid(0);
        int K = k.K(this.bWH.getPageContext().getPageActivity());
        int L = k.L(this.bWH.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = ba.vy().vA() ? 2 : 1;
        mVar.setScrW(K);
        mVar.setScrH(L);
        mVar.setScrDip(f);
        mVar.setqType(i2);
        mVar.setLastId(this.bZM);
        mVar.setYuelaouLocate(this.ccT);
        mVar.setLastClickTid(com.baidu.adp.lib.h.b.c(s.Hd(), 0L));
        if (this.mSource != null) {
            mVar.setStType(this.mSource);
            if (this.mSource.equalsIgnoreCase("sidebar")) {
                mVar.setStType(null);
            }
        }
        if (FrsActivity.bPm != 0) {
            mVar.setCtime((int) FrsActivity.bPm);
        }
        if (FrsActivity.bPn != 0) {
            mVar.setDataSize((int) FrsActivity.bPn);
        }
        if (FrsActivity.bPo != 0) {
            mVar.setNetError(FrsActivity.bPo);
        }
        if (mVar.getPn() != 1 || ((!this.mPageType.equals("normal_page") && !this.mPageType.equals("frs_page") && !this.mPageType.equals("book_page")) || this.mType != 3)) {
            z = false;
        }
        mVar.setUpdateType(this.mType);
        mVar.setNeedCache(z);
        if (!z) {
            ael();
            return;
        }
        ael();
        new C0060a(this, z, d.bhH().e(this.bOZ, mVar.bhK(), mVar.getIsGood(), this.ccE.getCategoryId())).execute(new Object[0]);
    }

    protected boolean a(m mVar, n nVar) {
        if (this.ccL) {
            this.ccG = nVar.bii();
        }
        if (afg()) {
            this.ccU = 7;
        }
        this.bPk.d(nVar);
        this.bZI = new ArrayList<>();
        if (com.baidu.tieba.frs.i.p.i(this.bPk)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.i.p.j(this.bPk)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        if (mVar != null) {
            this.ccE = mVar;
            this.mPn = this.ccE.getPn();
            this.bOZ = this.ccE.getKw();
            this.bWH.jQ(this.bOZ);
            this.bWH.setFrom(this.adg);
            this.bWH.setPn(this.mPn);
            this.bWH.setFlag(this.mFlag);
        }
        if (this.bPk.getThreadList() != null) {
            this.bZI.addAll(this.bPk.getThreadList());
        }
        if (this.ccG != 1 && this.ccL) {
            this.bWH.bPP.a(7, false, this.bZL);
        } else {
            this.bWH.bPP.a(this.mType, false, this.bZL);
        }
        this.mSource = null;
        if (this.ccP) {
            afj();
            this.ccP = false;
        }
        this.ccL = false;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<n, ?> mvcSocketResponsedMessage, MvcSocketMessage<m, n> mvcSocketMessage, MvcNetMessage<m, n> mvcNetMessage) {
        n nVar;
        e.a aVar = new e.a();
        aVar.fsg = i.gm() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.fsh = mvcSocketResponsedMessage.getDownSize();
        this.bZL = aVar;
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
        if (!this.bZP) {
            this.bZP = true;
            if (this.bWH.bPP != null) {
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
        aVar.fsg = i.gm() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.fsh = mvcHttpResponsedMessage.getDownSize();
        this.bZL = aVar;
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
        if (!this.bZP) {
            this.bZP = true;
            if (this.bWH.bPP != null) {
                a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            }
        }
    }

    public void aaY() {
        if (this.bPk != null && this.bPk.aMr() != null && this.bPk.aMr().getBannerListData() != null) {
            String lastIds = this.bPk.aMr().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.bZM = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.Go().Gp()) {
            this.aBV = System.currentTimeMillis() - this.bWH.Rf;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v(i, z, responsedMessage, this.bWH.aBM, this.bWH.createTime, this.bWH.aBU, false, this.aBV);
            this.bWH.createTime = 0L;
            this.bWH.aBM = 0L;
            if (vVar != null) {
                vVar.Gj();
            }
        }
    }

    public String aeV() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public p aek() {
        return this.bPk;
    }

    public e.a aeW() {
        return this.bZL;
    }

    private void ael() {
        this.bHB = System.currentTimeMillis();
        this.bZJ.Fa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(n nVar) {
        this.bWH.bPP.b(nVar);
        this.ccM = false;
        this.bPk.d(nVar);
        this.bZI = new ArrayList<>();
        if (this.bPk.getThreadList() != null) {
            this.bZI.addAll(this.bPk.getThreadList());
        }
        if (com.baidu.tieba.frs.i.p.i(this.bPk)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.i.p.j(this.bPk)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    public boolean aeX() {
        return this.ccU == 5;
    }

    /* renamed from: com.baidu.tieba.frs.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0060a extends BdAsyncTask<Object, n, Void> {
        private String aMd;
        private a ccW;
        private boolean needCache;

        public C0060a(a aVar, boolean z, String str) {
            this.aMd = null;
            this.aMd = str;
            this.ccW = aVar;
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
            if (this.needCache && d.bhH().qT(this.aMd)) {
                if (!d.bhH().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.aMd)) {
                    d.bhH().getResponseData().aMr().getSignData().is_signed = 0;
                }
                n responseData = d.bhH().getResponseData();
                if (responseData.bik() != null && !StringUtils.isNull(responseData.bik().getBookId(), true) && !responseData.bik().getBookId().equals("0") && responseData.bik().py() == 3 && (g = com.baidu.adp.lib.h.b.g(responseData.bik().getBookId(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
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
            this.ccW.c(nVarArr.length > 0 ? nVarArr[0] : null);
        }
    }

    public long Yc() {
        return this.bHE;
    }

    public long Yd() {
        return this.bHC;
    }

    public long Ye() {
        return this.bHD;
    }

    public long Yf() {
        return this.bHB;
    }

    public boolean wG() {
        return this.bZJ.wG();
    }

    public int aeY() {
        return this.ccI;
    }

    private void aeZ() {
        if (this.ccS == null) {
            this.ccS = new ArrayList<>();
        }
        if (this.ccS.size() == 0) {
            this.ccS.add(new cw());
        }
    }

    @Override // com.baidu.tieba.frs.dg
    public void a(int i, int i2, dn dnVar) {
        this.ccG = b(i, null);
        if (dnVar == null && (dnVar = an(i, i2)) == null) {
            if (i != 1 && k.gD() && this.ccR != null) {
                dq dqVar = new dq();
                dqVar.hasMore = false;
                dqVar.pn = 1;
                dqVar.forumName = this.bOZ;
                dqVar.bTB = false;
                if (this.bPk != null && this.bPk.aMr() != null) {
                    dqVar.forumId = this.bPk.aMr().getId();
                }
                aeZ();
                this.bPk.aA(this.ccS);
                this.ccR.a(i, i2, dqVar, this.ccS);
            }
            dnVar = new dn();
            dnVar.pn = -1;
        }
        if (this.bPk != null && this.bPk.aMr() != null) {
            dnVar.forumId = this.bPk.aMr().getId();
        }
        dnVar.forumName = this.bOZ;
        if (cz.acy().hZ(1) != null && this.ccG == 1) {
            this.ccE.setCategoryId(i2);
        }
        this.ccH = i2;
        this.ccJ = dnVar;
        b(i, i2, dnVar);
        it(5);
    }

    @Override // com.baidu.tieba.frs.dg
    public void a(dh dhVar) {
        this.ccR = dhVar;
        this.ccO.a(this.ccQ);
    }

    private void it(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.ccJ != null) {
                    this.ccJ.pn++;
                    break;
                }
                break;
            case 2:
                if (this.ccJ != null) {
                    dn dnVar = this.ccJ;
                    dnVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.ccJ != null) {
                    this.ccJ.pn = -1;
                    break;
                }
                break;
        }
        if (this.ccG == 1) {
            if (this.ccI == this.ccH) {
                ArrayList<v> arrayList = new ArrayList<>();
                if (this.bZI != null) {
                    arrayList.addAll(this.bZI);
                }
                this.bPk.aA(arrayList);
                if (this.ccR != null) {
                    this.ccR.a(this.ccG, this.ccH, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.ccI = this.ccH;
            return;
        }
        dg ia = this.ccO.ia(this.ccG);
        if (ia != null) {
            this.ccK = true;
            ia.a(this.ccG, this.ccH, this.ccJ);
            return;
        }
        if (this.bPk != null && this.bPk.getThreadList() != null) {
            this.bPk.getThreadList().clear();
        }
        this.ccR.a(this.ccG, this.ccH, null, null);
    }

    public boolean hasMore() {
        if ((this.ccJ instanceof dq) && ((dq) this.ccJ).errCode == 0) {
            return ((dq) this.ccJ).hasMore;
        }
        return true;
    }

    private int am(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, dn dnVar) {
        this.ccN.put(am(i, i2), dnVar);
    }

    public dn an(int i, int i2) {
        return this.ccN.get(am(i, i2));
    }

    @Override // com.baidu.tieba.frs.dg
    public void init() {
        this.ccO.init();
    }

    @Override // com.baidu.tieba.frs.dg
    public void aat() {
        this.ccO.destory();
        this.ccO.clear();
    }

    public int afa() {
        return this.ccG;
    }

    public boolean afb() {
        return 1 == this.ccG || 2 == this.ccG;
    }

    @Override // com.baidu.adp.base.e
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(aj ajVar) {
        if (ajVar != null && !StringUtils.isNull(ajVar.getId()) && this.bZI != null) {
            if (this.ccG == 1) {
                this.bPk.a(ajVar);
            }
            int afc = afc();
            if (this.bZI != null && this.bZI.size() > 0) {
                int size = this.bZI.size();
                for (int i = 0; i < size; i++) {
                    v vVar = this.bZI.get(i);
                    if ((vVar instanceof bi) && ajVar.getId().equals(((bi) vVar).getId())) {
                        return;
                    }
                }
            }
            if (ajVar.getThreadType() == 33) {
                as asVar = new as();
                asVar.a(ajVar, -1);
                asVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.bZI.add(afc, asVar);
                    return;
                }
                return;
            }
            this.bZI.add(afc, ajVar);
        }
    }

    public int afc() {
        if (this.bZI == null || this.bZI.size() <= 0) {
            return 0;
        }
        Iterator<v> it = this.bZI.iterator();
        int i = 0;
        while (it.hasNext()) {
            v next = it.next();
            if (next instanceof bi) {
                if (((bi) next).rJ() != 0) {
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

    public boolean afd() {
        return this.ccK;
    }

    public void afe() {
        by byVar = new by();
        if (this.ccI == 0) {
            byVar.hY(this.ccU);
        }
        if (this.bPk.getThreadList() != null) {
            this.bPk.getThreadList().clear();
            this.bPk.getThreadList().add(byVar);
        }
        if (this.bZI != null) {
            this.bZI.clear();
            this.bZI.add(byVar);
        }
    }

    public void hY(int i) {
        this.ccU = i;
    }

    public int acs() {
        return this.ccU;
    }

    public boolean aff() {
        return this.ccF;
    }

    public boolean afg() {
        return this.mSortType == 3;
    }

    public void iu(int i) {
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
            t.bkO();
        } else {
            t.bkP();
        }
    }

    public int afh() {
        return this.mSortType;
    }

    private int b(int i, m mVar) {
        if ((i == 1 || i == 2) && this.bWH.abr() != null) {
            return this.bWH.abr().a(this.ccU, mVar);
        }
        return i;
    }

    public int afi() {
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.adg)) {
            return 3;
        }
        if (!FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.adg)) {
            return 0;
        }
        return 6;
    }

    public void afj() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.bPk != null && this.bPk.aMr() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.h.b.c(this.bPk.aMr().getId(), 0L));
        }
        this.bWH.sendMessage(requestIncrForumAccessCountNetMessage);
    }
}
