package com.baidu.tieba.frs.f;

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
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.be;
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
import com.baidu.tieba.frs.cc;
import com.baidu.tieba.frs.da;
import com.baidu.tieba.frs.dd;
import com.baidu.tieba.frs.df;
import com.baidu.tieba.frs.dl;
import com.baidu.tieba.frs.dm;
import com.baidu.tieba.frs.ds;
import com.baidu.tieba.frs.dv;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.tbadkCore.util.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> implements NetModel.b<m, n>, dl {
    private String aaf;
    private long azl;
    private String bDB;
    private p bDM;
    private FrsActivity bLx;
    private boolean bOA;
    private ArrayList<v> bOt;
    private c<FrsActivity> bOu;
    e.a bOw;
    private String bOx;
    private boolean bOz;
    private String bRA;
    private int bRB;
    private int bRC;
    private int bRD;
    private ds bRE;
    private boolean bRF;
    public boolean bRG;
    public boolean bRH;
    private SparseArray<ds> bRI;
    private df bRJ;
    private boolean bRK;
    private dm bRL;
    private dm bRM;
    private ArrayList<v> bRN;
    private String bRO;
    private int bRP;
    private m bRy;
    private boolean bRz;
    private long bwg;
    private long bwh;
    private long bwi;
    private long bwj;
    private int mFlag;
    private String mPageType;
    private int mPn;
    private int mSortType;
    private String mSource;
    private int mType;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bDB = null;
        this.mType = 3;
        this.mPn = 1;
        this.aaf = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.bRA = null;
        this.bOx = null;
        this.bRB = 1;
        this.bRC = 0;
        this.bRD = 0;
        this.bRF = false;
        this.bRG = true;
        this.bRH = true;
        this.bRI = new SparseArray<>();
        this.bRK = false;
        this.bRL = new b(this);
        this.azl = 0L;
        this.bOz = false;
        this.bOA = false;
        this.bRP = 2;
        this.bwg = 0L;
        this.bwh = 0L;
        this.bwi = 0L;
        this.bwj = 0L;
        this.bLx = frsActivity;
        O(frsActivity);
    }

    private void O(FrsActivity frsActivity) {
        this.bRJ = new df();
        this.bRJ.aTm = frsActivity.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.bRJ));
        this.bRJ.a(this.bRL);
    }

    public void onActivityDestroy() {
        this.bOu.cancelLoadData();
    }

    public void d(Bundle bundle) {
        if (bundle != null) {
            this.bDB = bundle.getString("name");
            this.aaf = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.bRO = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.bRz = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.bDB)) {
            this.bDB = "";
        }
        if (TextUtils.isEmpty(this.aaf)) {
            this.aaf = "";
        }
        if (TextUtils.isEmpty(this.bRO)) {
            this.bRO = "";
        }
        this.mSource = this.aaf;
        this.bRy = new m();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            this.bRy.setSortType(1);
            this.mSortType = 1;
            hr(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            this.bRy.setSortType(2);
            this.mSortType = 2;
            hr(6);
        } else {
            this.bRy.setSortType(-1);
            this.mSortType = -1;
        }
        this.bRy.setIsGood(0);
        this.bDM = new p();
        this.bOu = new c<>(this.bLx.getPageContext(), this.bRy);
        this.bOu.a(this);
        this.bOu.setUniqueId(getUniqueId());
        if (this.bDB != null && this.bDB.length() > 0) {
            if (this.aaf == null || this.aaf.length() <= 0) {
                this.aaf = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.bDB);
        bundle.putString("from", this.aaf);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean LK() {
        if (this.bRB != 1) {
            hL(1);
            return true;
        } else if (this.bOu.DJ()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.bLx.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            m mVar = (m) m.objectWithJson(m.jsonWithObject(this.bRy), m.class);
            mVar.setPn(mVar.getPn() + 1);
            mVar.setSortType(this.mSortType);
            a(mVar, 1);
            return true;
        }
    }

    public void B(int i, boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            this.bRK = true;
        }
        if (this.bDM != null && this.bDM.bdR() != null) {
            this.bDM.bdR().clear();
        }
        m mVar = (m) m.objectWithJson(m.jsonWithObject(this.bRy), m.class);
        mVar.setPn(1);
        this.bRB = b(this.bRB, mVar);
        if (this.bRB == 1) {
            if (!this.bOu.DJ()) {
                a(mVar, i);
                return;
            }
            return;
        }
        if (this.bRE == null) {
            this.bRE = new ds();
            this.bRE.pn = 1;
            this.bRE.forumName = this.bDB;
            if (this.bDM != null && this.bDM.aGX() != null) {
                this.bRE.forumId = this.bDM.aGX().getId();
            }
        }
        hL(i);
    }

    public void hI(int i) {
        if (this.bRB != 1) {
            hL(4);
        } else if (!this.bOu.DJ()) {
            m mVar = (m) m.objectWithJson(m.jsonWithObject(this.bRy), m.class);
            mVar.setPn(i);
            mVar.setSortType(this.mSortType);
            a(mVar, 4);
        }
    }

    private void a(m mVar, int i) {
        boolean z = true;
        this.bLx.bEs.hm(i);
        this.bOu.a(mVar);
        this.mType = i;
        mVar.setKw(this.bDB);
        if (l.nL().nR()) {
            mVar.setRn(35);
        } else {
            mVar.setRn(50);
        }
        mVar.setWithGroup(1);
        mVar.setCid(0);
        int A = k.A(this.bLx.getPageContext().getPageActivity());
        int B = k.B(this.bLx.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m10getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = bb.ue().ug() ? 2 : 1;
        mVar.setScrW(A);
        mVar.setScrH(B);
        mVar.setScrDip(f);
        mVar.setqType(i2);
        mVar.setLastId(this.bOx);
        mVar.setYuelaouLocate(this.bRO);
        mVar.setLastClickTid(com.baidu.adp.lib.h.b.c(s.FK(), 0L));
        if (this.mSource != null) {
            mVar.setStType(this.mSource);
            if (this.mSource.equalsIgnoreCase("sidebar")) {
                mVar.setStType(this.bRA);
            }
        }
        if (FrsActivity.bDQ != 0) {
            mVar.setCtime((int) FrsActivity.bDQ);
        }
        if (FrsActivity.bDR != 0) {
            mVar.setDataSize((int) FrsActivity.bDR);
        }
        if (FrsActivity.bDS != 0) {
            mVar.setNetError(FrsActivity.bDS);
        }
        if (mVar.getPn() != 1 || ((!this.mPageType.equals("normal_page") && !this.mPageType.equals("frs_page")) || this.mType != 3)) {
            z = false;
        }
        mVar.setUpdateType(this.mType);
        mVar.setNeedCache(z);
        if (!z) {
            Zk();
            return;
        }
        Zk();
        new C0058a(this, z, d.bdv().e(this.bDB, mVar.bdy(), mVar.getIsGood(), this.bRy.getCategoryId())).execute(new Object[0]);
    }

    protected boolean a(m mVar, n nVar) {
        if (this.bRG) {
            this.bRB = nVar.bdV();
        }
        if (aah()) {
            this.bRP = 7;
        }
        this.bDM.d(nVar);
        this.bOt = new ArrayList<>();
        if (com.baidu.tieba.frs.j.p.h(this.bDM)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        if (mVar != null) {
            this.bRy = mVar;
            this.mPn = this.bRy.getPn();
            this.bDB = this.bRy.getKw();
            this.bLx.ja(this.bDB);
            this.bLx.setFrom(this.aaf);
            this.bLx.setPn(this.mPn);
            this.bLx.setFlag(this.mFlag);
        }
        if (this.bDM.getThreadList() != null) {
            this.bOt.addAll(this.bDM.getThreadList());
        }
        if (this.bRB != 1 && this.bRG) {
            this.bLx.bEs.a(7, false, this.bOw);
        } else {
            this.bLx.bEs.a(this.mType, false, this.bOw);
        }
        this.mSource = null;
        if (this.bRK) {
            aak();
            this.bRK = false;
        }
        this.bRG = false;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<n, ?> mvcSocketResponsedMessage, MvcSocketMessage<m, n> mvcSocketMessage, MvcNetMessage<m, n> mvcNetMessage) {
        n nVar;
        e.a aVar = new e.a();
        aVar.fhI = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.fhJ = mvcSocketResponsedMessage.getDownSize();
        this.bOw = aVar;
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
        this.bLx.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<n, ?> mvcSocketResponsedMessage, MvcSocketMessage<m, n> mvcSocketMessage, MvcNetMessage<m, n> mvcNetMessage) {
        m mVar;
        m mVar2 = null;
        if (!this.bOA) {
            this.bOA = true;
            if (this.bLx.bEs != null) {
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
        aVar.fhI = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.fhJ = mvcHttpResponsedMessage.getDownSize();
        this.bOw = aVar;
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
        this.bLx.a(errorData);
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
        if (!this.bOA) {
            this.bOA = true;
            if (this.bLx.bEs != null) {
                a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            }
        }
    }

    public void Xr() {
        if (this.bDM != null && this.bDM.aGX() != null && this.bDM.aGX().getBannerListData() != null) {
            String lastIds = this.bDM.aGX().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.bOx = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.EV().EW()) {
            this.azl = System.currentTimeMillis() - this.bLx.Om;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v(i, z, responsedMessage, this.bLx.azc, this.bLx.createTime, this.bLx.azk, false, this.azl);
            this.bLx.createTime = 0L;
            this.bLx.azc = 0L;
            if (vVar != null) {
                vVar.EQ();
            }
        }
    }

    public String KP() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public p Zj() {
        return this.bDM;
    }

    public e.a ZX() {
        return this.bOw;
    }

    private void Zk() {
        this.bwg = System.currentTimeMillis();
        this.bOu.DG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(n nVar) {
        this.bLx.bEs.b(nVar);
        this.bRH = false;
        this.bDM.d(nVar);
        this.bOt = new ArrayList<>();
        if (this.bDM.getThreadList() != null) {
            this.bOt.addAll(this.bDM.getThreadList());
        }
        if (com.baidu.tieba.frs.j.p.h(this.bDM)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    public boolean ZY() {
        return this.bRP == 5;
    }

    /* renamed from: com.baidu.tieba.frs.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0058a extends BdAsyncTask<Object, n, Void> {
        private String bRR;
        private a bRS;
        private boolean needCache;

        public C0058a(a aVar, boolean z, String str) {
            this.bRR = null;
            this.bRR = str;
            this.bRS = aVar;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            if (this.needCache && d.bdv().pV(this.bRR)) {
                if (!d.bdv().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.bRR)) {
                    d.bdv().getResponseData().aGX().getSignData().is_signed = 0;
                }
                publishProgress(d.bdv().getResponseData());
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
            this.bRS.c(nVarArr.length > 0 ? nVarArr[0] : null);
        }
    }

    public long SY() {
        return this.bwj;
    }

    public long SZ() {
        return this.bwh;
    }

    public long Ta() {
        return this.bwi;
    }

    public long Tb() {
        return this.bwg;
    }

    public boolean DJ() {
        return this.bOu.DJ();
    }

    public int ZZ() {
        return this.bRD;
    }

    private void aaa() {
        if (this.bRN == null) {
            this.bRN = new ArrayList<>();
        }
        if (this.bRN.size() == 0) {
            this.bRN.add(new da());
        }
    }

    @Override // com.baidu.tieba.frs.dl
    public void a(int i, int i2, ds dsVar) {
        this.bRB = b(i, null);
        if (dsVar == null && (dsVar = ah(i, i2)) == null) {
            if (i != 1 && k.fH() && this.bRM != null) {
                dv dvVar = new dv();
                dvVar.hasMore = false;
                dvVar.pn = 1;
                dvVar.forumName = this.bDB;
                dvVar.bIG = false;
                if (this.bDM != null && this.bDM.aGX() != null) {
                    dvVar.forumId = this.bDM.aGX().getId();
                }
                aaa();
                this.bDM.aB(this.bRN);
                this.bRM.a(i, i2, dvVar, this.bRN);
            }
            dsVar = new ds();
            dsVar.pn = -1;
        }
        if (this.bDM != null && this.bDM.aGX() != null) {
            dsVar.forumId = this.bDM.aGX().getId();
        }
        dsVar.forumName = this.bDB;
        if (dd.Xo().hs(1) != null && this.bRB == 1) {
            this.bRy.setCategoryId(i2);
        }
        this.bRC = i2;
        this.bRE = dsVar;
        b(i, i2, dsVar);
        hL(5);
    }

    @Override // com.baidu.tieba.frs.dl
    public void a(dm dmVar) {
        this.bRM = dmVar;
        this.bRJ.a(this.bRL);
    }

    private void hL(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.bRE != null) {
                    this.bRE.pn++;
                    break;
                }
                break;
            case 2:
                if (this.bRE != null) {
                    ds dsVar = this.bRE;
                    dsVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.bRE != null) {
                    this.bRE.pn = -1;
                    break;
                }
                break;
        }
        if (this.bRB == 1) {
            if (this.bRD == this.bRC) {
                ArrayList<v> arrayList = new ArrayList<>();
                if (this.bOt != null) {
                    arrayList.addAll(this.bOt);
                }
                this.bDM.aB(arrayList);
                if (this.bRM != null) {
                    this.bRM.a(this.bRB, this.bRC, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.bRD = this.bRC;
            return;
        }
        dl ht = this.bRJ.ht(this.bRB);
        if (ht != null) {
            this.bRF = true;
            ht.a(this.bRB, this.bRC, this.bRE);
            return;
        }
        if (this.bDM != null && this.bDM.getThreadList() != null) {
            this.bDM.getThreadList().clear();
        }
        this.bRM.a(this.bRB, this.bRC, null, null);
    }

    public boolean hasMore() {
        if ((this.bRE instanceof dv) && ((dv) this.bRE).errCode == 0) {
            return ((dv) this.bRE).hasMore;
        }
        return true;
    }

    private int ag(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ds dsVar) {
        this.bRI.put(ag(i, i2), dsVar);
    }

    public ds ah(int i, int i2) {
        return this.bRI.get(ag(i, i2));
    }

    @Override // com.baidu.tieba.frs.dl
    public void init() {
        this.bRJ.init();
    }

    @Override // com.baidu.tieba.frs.dl
    public void Vk() {
        this.bRJ.destory();
        this.bRJ.clear();
    }

    public int aab() {
        return this.bRB;
    }

    public boolean aac() {
        return 1 == this.bRB || 2 == this.bRB;
    }

    @Override // com.baidu.adp.base.e
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(ag agVar) {
        if (agVar != null && !StringUtils.isNull(agVar.getId()) && this.bOt != null) {
            if (this.bRB == 1) {
                this.bDM.a(agVar);
            }
            int aad = aad();
            if (this.bOt != null && this.bOt.size() > 0) {
                int size = this.bOt.size();
                for (int i = 0; i < size; i++) {
                    v vVar = this.bOt.get(i);
                    if ((vVar instanceof be) && agVar.getId().equals(((be) vVar).getId())) {
                        return;
                    }
                }
            }
            if (agVar.getThreadType() == 33) {
                ao aoVar = new ao();
                aoVar.a(agVar, -1);
                aoVar.setPost_num(1);
                if (TbadkCoreApplication.m10getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.bOt.add(aad, aoVar);
                    return;
                }
                return;
            }
            this.bOt.add(aad, agVar);
        }
    }

    public int aad() {
        if (this.bOt == null || this.bOt.size() <= 0) {
            return 0;
        }
        Iterator<v> it = this.bOt.iterator();
        int i = 0;
        while (it.hasNext()) {
            v next = it.next();
            if (next instanceof be) {
                if (((be) next).qt() != 0) {
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

    public boolean aae() {
        return this.bRF;
    }

    public void aaf() {
        cc ccVar = new cc();
        if (this.bRD == 0) {
            ccVar.hr(this.bRP);
        }
        if (this.bDM.getThreadList() != null) {
            this.bDM.getThreadList().clear();
            this.bDM.getThreadList().add(ccVar);
        }
        if (this.bOt != null) {
            this.bOt.clear();
            this.bOt.add(ccVar);
        }
    }

    public void hr(int i) {
        this.bRP = i;
    }

    public int Xi() {
        return this.bRP;
    }

    public boolean aag() {
        return this.bRz;
    }

    public boolean aah() {
        return this.mSortType == 3;
    }

    public void hM(int i) {
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
            t.bgB();
        } else {
            t.bgC();
        }
    }

    public int aai() {
        return this.mSortType;
    }

    private int b(int i, m mVar) {
        if ((i == 1 || i == 2) && this.bLx.Wi() != null) {
            return this.bLx.Wi().a(this.bRP, mVar);
        }
        return i;
    }

    public int aaj() {
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.aaf)) {
            return 3;
        }
        if (!FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.aaf)) {
            return 0;
        }
        return 6;
    }

    public void aak() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.bDM != null && this.bDM.aGX() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.h.b.c(this.bDM.aGX().getId(), 0L));
        }
        this.bLx.sendMessage(requestIncrForumAccessCountNetMessage);
    }
}
