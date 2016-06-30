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
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.az;
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
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> implements NetModel.b<m, n>, dl {
    private String Zw;
    private long ayv;
    private p bCF;
    private String bCu;
    private FrsActivity bJR;
    private ArrayList<v> bMJ;
    private c<FrsActivity> bMK;
    e.a bMM;
    private String bMN;
    private boolean bMP;
    private boolean bMQ;
    private m bPL;
    private boolean bPM;
    private String bPN;
    private int bPO;
    private int bPP;
    private int bPQ;
    private ds bPR;
    private boolean bPS;
    public boolean bPT;
    public boolean bPU;
    private SparseArray<ds> bPV;
    private df bPW;
    private boolean bPX;
    private dm bPY;
    private dm bPZ;
    private ArrayList<v> bQa;
    private String bQb;
    private int bQc;
    private long btS;
    private long btT;
    private long btU;
    private long btV;
    private int mFlag;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bCu = null;
        this.mType = 3;
        this.mPn = 1;
        this.Zw = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.bPN = null;
        this.bMN = null;
        this.bPO = 1;
        this.bPP = 0;
        this.bPQ = 0;
        this.bPS = false;
        this.bPT = true;
        this.bPU = true;
        this.bPV = new SparseArray<>();
        this.bPX = false;
        this.bPY = new b(this);
        this.ayv = 0L;
        this.bMP = false;
        this.bMQ = false;
        this.bQc = 2;
        this.btS = 0L;
        this.btT = 0L;
        this.btU = 0L;
        this.btV = 0L;
        this.bJR = frsActivity;
        O(frsActivity);
    }

    private void O(FrsActivity frsActivity) {
        this.bPW = new df();
        this.bPW.aSq = frsActivity.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.bPW));
        this.bPW.a(this.bPY);
    }

    public void onActivityDestroy() {
        this.bMK.cancelLoadData();
    }

    public void d(Bundle bundle) {
        if (bundle != null) {
            this.bCu = bundle.getString("name");
            this.Zw = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.bQb = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.bPM = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.bCu)) {
            this.bCu = "";
        }
        if (TextUtils.isEmpty(this.Zw)) {
            this.Zw = "";
        }
        if (TextUtils.isEmpty(this.bQb)) {
            this.bQb = "";
        }
        this.mSource = this.Zw;
        this.bPL = new m();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            this.bPL.qq(1);
            hs(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            this.bPL.qq(2);
            hs(6);
        } else {
            this.bPL.qq(0);
        }
        this.bPL.setIsGood(0);
        this.bCF = new p();
        this.bMK = new c<>(this.bJR.getPageContext(), this.bPL);
        this.bMK.a(this);
        this.bMK.setUniqueId(getUniqueId());
        if (this.bCu != null && this.bCu.length() > 0) {
            if (this.Zw == null || this.Zw.length() <= 0) {
                this.Zw = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.bCu);
        bundle.putString("from", this.Zw);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean LL() {
        if (this.bPO != 1) {
            hL(1);
            return true;
        } else if (this.bMK.DK()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.bJR.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            m mVar = (m) m.objectWithJson(m.jsonWithObject(this.bPL), m.class);
            mVar.setPn(mVar.getPn() + 1);
            a(mVar, 1);
            return true;
        }
    }

    public void A(int i, boolean z) {
        if (TbadkCoreApplication.isLogin()) {
            this.bPX = true;
        }
        if (this.bCF != null && this.bCF.baD() != null) {
            this.bCF.baD().clear();
        }
        m mVar = (m) m.objectWithJson(m.jsonWithObject(this.bPL), m.class);
        mVar.setPn(1);
        this.bPO = b(this.bPO, mVar);
        if (this.bPO == 1) {
            if (!this.bMK.DK()) {
                a(mVar, i);
                return;
            }
            return;
        }
        if (this.bPR == null) {
            this.bPR = new ds();
            this.bPR.pn = 1;
            this.bPR.forumName = this.bCu;
            if (this.bCF != null && this.bCF.aDN() != null) {
                this.bPR.forumId = this.bCF.aDN().getId();
            }
        }
        hL(i);
    }

    public void hI(int i) {
        if (this.bPO != 1) {
            hL(4);
        } else if (!this.bMK.DK()) {
            m mVar = (m) m.objectWithJson(m.jsonWithObject(this.bPL), m.class);
            mVar.setPn(i);
            a(mVar, 4);
        }
    }

    private void a(m mVar, int i) {
        boolean z = true;
        this.bJR.bDl.hm(i);
        this.bMK.a(mVar);
        this.mType = i;
        mVar.setKw(this.bCu);
        if (l.nW().oc()) {
            mVar.setRn(35);
        } else {
            mVar.setRn(50);
        }
        mVar.setWithGroup(1);
        mVar.setCid(0);
        int A = k.A(this.bJR.getPageContext().getPageActivity());
        int B = k.B(this.bJR.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = bb.uf().uh() ? 2 : 1;
        mVar.setScrW(A);
        mVar.setScrH(B);
        mVar.setScrDip(f);
        mVar.setqType(i2);
        mVar.setLastId(this.bMN);
        mVar.setYuelaouLocate(this.bQb);
        if (this.mSource != null) {
            mVar.setStType(this.mSource);
            if (this.mSource.equalsIgnoreCase("sidebar")) {
                mVar.setStType(this.bPN);
            }
        }
        if (FrsActivity.bCJ != 0) {
            mVar.setCtime((int) FrsActivity.bCJ);
        }
        if (FrsActivity.bCK != 0) {
            mVar.setDataSize((int) FrsActivity.bCK);
        }
        if (FrsActivity.bCL != 0) {
            mVar.setNetError(FrsActivity.bCL);
        }
        if (mVar.getPn() != 1 || ((!this.mPageType.equals("normal_page") && !this.mPageType.equals("frs_page")) || this.mType != 3)) {
            z = false;
        }
        mVar.setUpdateType(this.mType);
        mVar.setNeedCache(z);
        if (!z) {
            YP();
            return;
        }
        YP();
        new C0057a(this, z, d.bah().d(this.bCu, mVar.bak(), mVar.getIsGood(), this.bPL.getCategoryId())).execute(new Object[0]);
    }

    protected boolean a(m mVar, n nVar) {
        if (this.bPT) {
            this.bPO = nVar.baH();
        }
        this.bPT = false;
        this.bCF.d(nVar);
        this.bMJ = new ArrayList<>();
        if (com.baidu.tieba.frs.i.p.h(this.bCF)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        if (mVar != null) {
            this.bPL = mVar;
            this.mPn = this.bPL.getPn();
            this.bCu = this.bPL.getKw();
            this.bJR.iU(this.bCu);
            this.bJR.setFrom(this.Zw);
            this.bJR.setPn(this.mPn);
            this.bJR.setFlag(this.mFlag);
        }
        if (this.bCF.getThreadList() != null) {
            this.bMJ.addAll(this.bCF.getThreadList());
        }
        if (this.bPO != 1) {
            this.bJR.bDl.a(7, false, this.bMM);
        } else {
            this.bJR.bDl.a(this.mType, false, this.bMM);
        }
        this.mSource = null;
        if (this.bPX) {
            ZL();
            this.bPX = false;
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<n, ?> mvcSocketResponsedMessage, MvcSocketMessage<m, n> mvcSocketMessage, MvcNetMessage<m, n> mvcNetMessage) {
        n nVar;
        e.a aVar = new e.a();
        aVar.eUM = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.eUN = mvcSocketResponsedMessage.getDownSize();
        this.bMM = aVar;
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
        this.bJR.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<n, ?> mvcSocketResponsedMessage, MvcSocketMessage<m, n> mvcSocketMessage, MvcNetMessage<m, n> mvcNetMessage) {
        m mVar;
        m mVar2 = null;
        if (!this.bMQ) {
            this.bMQ = true;
            if (this.bJR.bDl != null) {
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
        aVar.eUM = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.eUN = mvcHttpResponsedMessage.getDownSize();
        this.bMM = aVar;
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
        this.bJR.a(errorData);
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
        if (!this.bMQ) {
            this.bMQ = true;
            if (this.bJR.bDl != null) {
                a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            }
        }
    }

    public void WZ() {
        if (this.bCF != null && this.bCF.aDN() != null && this.bCF.aDN().getBannerListData() != null) {
            String lastIds = this.bCF.aDN().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.bMN = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.EW().EX()) {
            this.ayv = System.currentTimeMillis() - this.bJR.Od;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v(i, z, responsedMessage, this.bJR.aym, this.bJR.createTime, this.bJR.ayu, false, this.ayv);
            this.bJR.createTime = 0L;
            this.bJR.aym = 0L;
            if (vVar != null) {
                vVar.ER();
            }
        }
    }

    public String KQ() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public p YO() {
        return this.bCF;
    }

    public e.a ZB() {
        return this.bMM;
    }

    private void YP() {
        this.btS = System.currentTimeMillis();
        this.bMK.DH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(n nVar) {
        this.bJR.bDl.b(nVar);
        this.bPU = false;
        this.bCF.d(nVar);
        this.bMJ = new ArrayList<>();
        if (this.bCF.getThreadList() != null) {
            this.bMJ.addAll(this.bCF.getThreadList());
        }
        if (com.baidu.tieba.frs.i.p.h(this.bCF)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    public boolean ZC() {
        return this.bQc == 5;
    }

    /* renamed from: com.baidu.tieba.frs.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0057a extends BdAsyncTask<Object, n, Void> {
        private String bQe;
        private a bQf;
        private boolean needCache;

        public C0057a(a aVar, boolean z, String str) {
            this.bQe = null;
            this.bQe = str;
            this.bQf = aVar;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            if (this.needCache && d.bah().pl(this.bQe)) {
                if (!d.bah().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.bQe)) {
                    d.bah().getResponseData().aDN().getSignData().is_signed = 0;
                }
                publishProgress(d.bah().getResponseData());
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
            this.bQf.c(nVarArr.length > 0 ? nVarArr[0] : null);
        }
    }

    public long Sq() {
        return this.btV;
    }

    public long Sr() {
        return this.btT;
    }

    public long Ss() {
        return this.btU;
    }

    public long St() {
        return this.btS;
    }

    public boolean DK() {
        return this.bMK.DK();
    }

    public int ZD() {
        return this.bPQ;
    }

    private void ZE() {
        if (this.bQa == null) {
            this.bQa = new ArrayList<>();
        }
        if (this.bQa.size() == 0) {
            this.bQa.add(new da());
        }
    }

    @Override // com.baidu.tieba.frs.dl
    public void a(int i, int i2, ds dsVar) {
        this.bPO = b(i, null);
        if (dsVar == null && (dsVar = ag(i, i2)) == null) {
            if (i != 1 && k.fI() && this.bPZ != null) {
                dv dvVar = new dv();
                dvVar.hasMore = false;
                dvVar.pn = 1;
                dvVar.forumName = this.bCu;
                dvVar.bHk = false;
                if (this.bCF != null && this.bCF.aDN() != null) {
                    dvVar.forumId = this.bCF.aDN().getId();
                }
                ZE();
                this.bCF.ay(this.bQa);
                this.bPZ.a(i, i2, dvVar, this.bQa);
            }
            dsVar = new ds();
            dsVar.pn = -1;
        }
        if (this.bCF != null && this.bCF.aDN() != null) {
            dsVar.forumId = this.bCF.aDN().getId();
        }
        dsVar.forumName = this.bCu;
        if (dd.WW().ht(1) != null && this.bPO == 1) {
            this.bPL.setCategoryId(i2);
        }
        this.bPP = i2;
        this.bPR = dsVar;
        b(i, i2, dsVar);
        hL(5);
    }

    @Override // com.baidu.tieba.frs.dl
    public void a(dm dmVar) {
        this.bPZ = dmVar;
        this.bPW.a(this.bPY);
    }

    private void hL(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.bPR != null) {
                    this.bPR.pn++;
                    break;
                }
                break;
            case 2:
                if (this.bPR != null) {
                    ds dsVar = this.bPR;
                    dsVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.bPR != null) {
                    this.bPR.pn = -1;
                    break;
                }
                break;
        }
        if (this.bPO == 1) {
            if (this.bPQ == this.bPP) {
                ArrayList<v> arrayList = new ArrayList<>();
                if (this.bMJ != null) {
                    arrayList.addAll(this.bMJ);
                }
                this.bCF.ay(arrayList);
                if (this.bPZ != null) {
                    this.bPZ.a(this.bPO, this.bPP, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.bPQ = this.bPP;
            return;
        }
        dl hu = this.bPW.hu(this.bPO);
        if (hu != null) {
            this.bPS = true;
            hu.a(this.bPO, this.bPP, this.bPR);
            return;
        }
        if (this.bCF != null && this.bCF.getThreadList() != null) {
            this.bCF.getThreadList().clear();
        }
        this.bPZ.a(this.bPO, this.bPP, null, null);
    }

    public boolean hasMore() {
        if ((this.bPR instanceof dv) && ((dv) this.bPR).errCode == 0) {
            return ((dv) this.bPR).hasMore;
        }
        return true;
    }

    private int af(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ds dsVar) {
        this.bPV.put(af(i, i2), dsVar);
    }

    public ds ag(int i, int i2) {
        return this.bPV.get(af(i, i2));
    }

    @Override // com.baidu.tieba.frs.dl
    public void init() {
        this.bPW.init();
    }

    @Override // com.baidu.tieba.frs.dl
    public void UC() {
        this.bPW.destory();
        this.bPW.clear();
    }

    public int ZF() {
        return this.bPO;
    }

    @Override // com.baidu.adp.base.e
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(ad adVar) {
        if (adVar != null && !StringUtils.isNull(adVar.getId()) && this.bMJ != null) {
            if (this.bPO == 1) {
                this.bCF.a(adVar);
            }
            int ZG = ZG();
            if (this.bMJ != null && this.bMJ.size() > 0) {
                int size = this.bMJ.size();
                for (int i = 0; i < size; i++) {
                    v vVar = this.bMJ.get(i);
                    if ((vVar instanceof az) && adVar.getId().equals(((az) vVar).getId())) {
                        return;
                    }
                }
            }
            if (adVar.getThreadType() == 33) {
                aj ajVar = new aj();
                ajVar.a(adVar, -1);
                ajVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.bMJ.add(ZG, ajVar);
                    return;
                }
                return;
            }
            this.bMJ.add(ZG, adVar);
        }
    }

    public int ZG() {
        if (this.bMJ == null || this.bMJ.size() <= 0) {
            return 0;
        }
        Iterator<v> it = this.bMJ.iterator();
        int i = 0;
        while (it.hasNext()) {
            v next = it.next();
            if (next instanceof az) {
                if (((az) next).getIs_top() != 0) {
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

    public boolean ZH() {
        return this.bPS;
    }

    public void ZI() {
        cc ccVar = new cc();
        if (this.bPQ == 0) {
            ccVar.hs(this.bQc);
        }
        if (this.bCF.getThreadList() != null) {
            this.bCF.getThreadList().clear();
            this.bCF.getThreadList().add(ccVar);
        }
        if (this.bMJ != null) {
            this.bMJ.clear();
            this.bMJ.add(ccVar);
        }
    }

    public void hs(int i) {
        this.bQc = i;
    }

    public int WQ() {
        return this.bQc;
    }

    public boolean ZJ() {
        return this.bPM;
    }

    private int b(int i, m mVar) {
        if ((i == 1 || i == 2) && this.bJR.VP() != null) {
            return this.bJR.VP().a(this.bQc, mVar);
        }
        return i;
    }

    public int ZK() {
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.Zw)) {
            return 3;
        }
        if (!FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.Zw)) {
            return 0;
        }
        return 6;
    }

    public void ZL() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.bCF != null && this.bCF.aDN() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.h.b.c(this.bCF.aDN().getId(), 0L));
        }
        this.bJR.sendMessage(requestIncrForumAccessCountNetMessage);
    }
}
