package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.o;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.performanceLog.t;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cw;
import com.baidu.tieba.frs.ea;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.frs.ef;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ev;
import com.baidu.tieba.frs.ex;
import com.baidu.tieba.frs.ey;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> implements NetModel.b<m, n>, eu {
    private com.baidu.tieba.tbadkCore.d.a aUT;
    private long aUU;
    private long aUV;
    private long aUW;
    private long aUX;
    private long azW;
    private String bde;
    private int bdf;
    private p bdo;
    private ArrayList<u> bkB;
    private c<FrsActivity> bkC;
    private m bkD;
    e.a bkE;
    private String bkF;
    private boolean bkH;
    private boolean bkI;
    private FrsActivity blE;
    private long blF;
    private boolean blG;
    private String blH;
    private int blI;
    private int blJ;
    private int blK;
    private ex blL;
    private boolean blM;
    private SparseArray<ex> blN;
    private ef blO;
    private ev blP;
    private ev blQ;
    private ArrayList<u> blR;
    private String blS;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bde = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.bdf = 0;
        this.blF = 0L;
        this.blG = false;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.blH = null;
        this.bkF = null;
        this.blI = 1;
        this.blJ = 0;
        this.blK = 0;
        this.blM = false;
        this.blN = new SparseArray<>();
        this.blP = new b(this);
        this.aUT = null;
        this.azW = 0L;
        this.bkH = false;
        this.bkI = false;
        this.aUU = 0L;
        this.aUV = 0L;
        this.aUW = 0L;
        this.aUX = 0L;
        this.blE = frsActivity;
        C(frsActivity);
    }

    private void C(FrsActivity frsActivity) {
        this.blO = new ef();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.blO));
        this.blO.a(this.blP);
    }

    public void onActivityDestroy() {
        if (this.aUT != null) {
            this.aUT.destory();
        }
        this.bkC.cancelLoadData();
    }

    public void b(Bundle bundle) {
        if (bundle != null) {
            this.bde = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.bdf = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.blG = bundle.getBoolean(FrsActivityConfig.GOOD, false);
            this.blS = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
        }
        if (TextUtils.isEmpty(this.bde)) {
            this.bde = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.blS)) {
            this.blS = "";
        }
        this.mSource = this.mFrom;
        this.bkD = new m();
        this.bdo = new p();
        this.bkC = new c<>(this.blE.getPageContext(), this.bkD);
        this.bkC.a(this);
        this.bkC.setUniqueId(getUniqueId());
        if (this.bde != null && this.bde.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.bde);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.bdf);
        bundle.putBoolean(FrsActivityConfig.GOOD, this.blG);
    }

    public boolean ow() {
        return bP(true);
    }

    public boolean IR() {
        if (this.blI != 1) {
            gk(1);
            return true;
        } else if (this.bkC.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.blE.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            m mVar = (m) m.objectWithJson(m.jsonWithObject(this.bkD), m.class);
            mVar.setPn(mVar.getPn() + 1);
            a(mVar, 1);
            return true;
        }
    }

    public boolean bP(boolean z) {
        return j(3, z);
    }

    public boolean j(int i, boolean z) {
        if (this.bdo != null && this.bdo.aEb() != null) {
            this.bdo.aEb().clear();
        }
        if (this.blI != 1) {
            gk(i);
            return true;
        } else if (this.bkC.isLoading()) {
            return false;
        } else {
            m mVar = (m) m.objectWithJson(m.jsonWithObject(this.bkD), m.class);
            mVar.setPn(1);
            a(mVar, i);
            return true;
        }
    }

    public void gi(int i) {
        if (this.blI != 1) {
            gk(4);
        } else if (!this.bkC.isLoading()) {
            m mVar = (m) m.objectWithJson(m.jsonWithObject(this.bkD), m.class);
            mVar.setPn(i);
            a(mVar, 4);
        }
    }

    public boolean Pm() {
        if (this.bkC.isLoading()) {
            return false;
        }
        this.blG = false;
        this.mPn = 1;
        return bP(true);
    }

    public boolean gj(int i) {
        if (this.bkC.isLoading()) {
            return false;
        }
        this.blG = true;
        this.blF = i;
        this.mPn = 1;
        return bP(true);
    }

    public boolean av(String str, String str2) {
        if (this.bkC.isLoading() || str2 == null) {
            return false;
        }
        this.mSource = "sidebar";
        this.blH = str;
        this.blG = false;
        this.bde = str2;
        return bP(true);
    }

    private void a(m mVar, int i) {
        boolean z = true;
        this.blE.bdL.fS(i);
        this.bkC.a(mVar);
        this.mType = i;
        mVar.setKw(this.bde);
        if (com.baidu.tbadk.core.m.qQ().qW()) {
            mVar.setRn(35);
        } else {
            mVar.setRn(50);
        }
        mVar.setWithGroup(1);
        if (this.blG) {
            mVar.setIsGood(1);
            mVar.setCid((int) this.blF);
        } else {
            mVar.setIsGood(0);
            mVar.setCid(0);
        }
        int K = k.K(this.blE.getPageContext().getPageActivity());
        int L = k.L(this.blE.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = ay.va().vc() ? 2 : 1;
        mVar.setScrW(K);
        mVar.setScrH(L);
        mVar.setScrDip(f);
        mVar.setqType(i2);
        mVar.setLastId(this.bkF);
        mVar.setYuelaouLocate(this.blS);
        if (this.mSource != null) {
            mVar.setStType(this.mSource);
            if (this.mSource.equalsIgnoreCase("sidebar")) {
                mVar.setStType(this.blH);
            }
        }
        if (FrsActivity.bds != 0) {
            mVar.setCtime((int) FrsActivity.bds);
        }
        if (FrsActivity.bdt != 0) {
            mVar.setDataSize((int) FrsActivity.bdt);
        }
        if (FrsActivity.bdu != 0) {
            mVar.setNetError(FrsActivity.bdu);
        }
        if (mVar.getPn() != 1 || ((!this.mPageType.equals("normal_page") && !this.mPageType.equals("frs_page")) || this.mType != 3 || this.blG)) {
            z = false;
        }
        mVar.setUpdateType(this.mType);
        mVar.setNeedCache(z);
        if (!z) {
            Pa();
        } else {
            Pa();
            new C0059a(this, z, d.aDI().aj(this.bde, this.bkD.getCategoryId())).execute(new Object[0]);
        }
        if (this.aUT == null) {
            this.aUT = new com.baidu.tieba.tbadkCore.d.a("frsStat");
            this.aUT.start();
        }
    }

    protected boolean a(m mVar, n nVar) {
        if (this.blI == 1) {
            this.bdo.d(nVar);
            this.bkB = new ArrayList<>();
            if (this.bdo.aDK().aEe() == 1) {
                this.mPageType = "frs_page";
            } else {
                this.mPageType = "normal_page";
            }
            if (this.blG) {
                this.mPageType = "good_page";
            }
            if (mVar != null) {
                this.bkD = mVar;
                this.mPn = this.bkD.getPn();
                this.bde = this.bkD.getKw();
                this.blE.hs(this.bde);
                this.blE.setFrom(this.mFrom);
                this.blE.setPn(this.mPn);
                this.blE.setFlag(this.bdf);
            }
            this.blE.bdL.a(this.mType, false, this.bkE);
            if (this.bdo.getThreadList() != null) {
                this.bkB.addAll(this.bdo.getThreadList());
            }
            this.mSource = null;
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<n, ?> mvcSocketResponsedMessage, MvcSocketMessage<m, n> mvcSocketMessage, MvcNetMessage<m, n> mvcNetMessage) {
        n nVar;
        e.a aVar = new e.a();
        aVar.dEt = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.dEu = mvcSocketResponsedMessage.getDownSize();
        this.bkE = aVar;
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
        this.blE.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<n, ?> mvcSocketResponsedMessage, MvcSocketMessage<m, n> mvcSocketMessage, MvcNetMessage<m, n> mvcNetMessage) {
        m mVar;
        m mVar2;
        OY();
        if (this.aUT != null) {
            this.aUT.a(false, this.bkE.isSuccess, this.bkE.errorCode, this.bkE.errorMsg, this.bkE.dEu);
            this.aUT = null;
        }
        if (!this.bkI) {
            this.bkI = true;
            t tVar = new t();
            tVar.eF(1000);
            tVar.aAb = false;
            tVar.isSuccess = this.bkE.isSuccess;
            tVar.azQ = mvcSocketResponsedMessage.performanceData.qx;
            tVar.azR = mvcSocketResponsedMessage.performanceData.qy;
            tVar.azS = mvcSocketResponsedMessage.performanceData.qz;
            tVar.azT = mvcSocketResponsedMessage.performanceData.qA;
            tVar.azU = mvcSocketResponsedMessage.performanceData.qB;
            tVar.azZ = this.bkE.dEu;
            tVar.errCode = this.bkE.errorCode;
            tVar.aAa = 0L;
            if (this.blE.bdL != null) {
                e(tVar);
            }
        }
        long j = 0;
        if (mvcSocketMessage == null) {
            mVar = null;
        } else {
            j = mvcSocketMessage.getClientLogID();
            mVar = mvcSocketMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            mVar2 = mvcNetMessage.getRequestData();
        } else {
            mVar2 = mVar;
        }
        int error = mvcSocketResponsedMessage.getError();
        String errorString = mvcSocketResponsedMessage.getErrorString();
        if (error != 0) {
            int cmd = mvcSocketResponsedMessage.getCmd();
            Object[] objArr = new Object[2];
            objArr[0] = "kw";
            objArr[1] = mVar2 != null ? mVar2.getKw() : null;
            com.baidu.tbadk.core.log.b.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<n> mvcHttpResponsedMessage, MvcHttpMessage<m, n> mvcHttpMessage, MvcNetMessage<m, n> mvcNetMessage) {
        n nVar;
        e.a aVar = new e.a();
        aVar.dEt = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.dEu = mvcHttpResponsedMessage.getDownSize();
        this.bkE = aVar;
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
        this.blE.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    private void b(MvcHttpResponsedMessage<n> mvcHttpResponsedMessage, MvcHttpMessage<m, n> mvcHttpMessage, MvcNetMessage<m, n> mvcNetMessage) {
        m mVar;
        m mVar2;
        OY();
        if (this.aUT != null) {
            this.aUT.a(true, this.bkE.isSuccess, this.bkE.errorCode, this.bkE.errorMsg, this.bkE.dEu);
            this.aUT = null;
        }
        if (!this.bkI) {
            this.bkI = true;
            t tVar = new t();
            tVar.eF(1000);
            tVar.aAb = true;
            tVar.isSuccess = this.bkE.isSuccess;
            tVar.azQ = mvcHttpResponsedMessage.performanceData.qx;
            tVar.azR = mvcHttpResponsedMessage.performanceData.qy;
            tVar.azS = mvcHttpResponsedMessage.performanceData.qz;
            tVar.azT = mvcHttpResponsedMessage.performanceData.qA;
            tVar.azU = mvcHttpResponsedMessage.performanceData.qB;
            tVar.azZ = 0L;
            tVar.aAa = this.bkE.dEu;
            tVar.socketErrNo = mvcHttpResponsedMessage.performanceData.qC;
            tVar.socketCostTime = mvcHttpResponsedMessage.performanceData.qD;
            tVar.errCode = this.bkE.errorCode;
            if (this.blE.bdL != null) {
                e(tVar);
            }
        }
        long j = 0;
        if (mvcHttpMessage == null) {
            mVar = null;
        } else {
            j = mvcHttpMessage.getClientLogID();
            mVar = mvcHttpMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            mVar2 = mvcNetMessage.getRequestData();
        } else {
            mVar2 = mVar;
        }
        int error = mvcHttpResponsedMessage.getError();
        String errorString = mvcHttpResponsedMessage.getErrorString();
        if (error != 0) {
            int cmd = mvcHttpResponsedMessage.getCmd();
            Object[] objArr = new Object[2];
            objArr[0] = "kw";
            objArr[1] = mVar2 != null ? mVar2.getKw() : null;
            com.baidu.tbadk.core.log.b.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
    }

    public void Pn() {
        if (this.bdo != null && this.bdo.akG() != null && this.bdo.akG().getBannerListData() != null) {
            String lastIds = this.bdo.akG().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.bkF = lastIds;
            }
        }
    }

    public void OY() {
        if (!this.bkH) {
            this.bkH = true;
            this.azW = System.currentTimeMillis() - this.blE.VP;
            t tVar = new t();
            tVar.eF(1000);
            tVar.azP = this.blE.createTime;
            tVar.azW = this.azW;
            tVar.EB();
        }
    }

    public void e(t tVar) {
        if (tVar != null) {
            tVar.azP = this.blE.createTime;
            this.blE.createTime = 0L;
            tVar.azV = this.blE.azV;
            tVar.azW = this.azW == 0 ? System.currentTimeMillis() - this.blE.VP : this.azW;
            tVar.EC();
        }
    }

    public String Po() {
        return this.mPageType;
    }

    public boolean Pp() {
        return this.blG;
    }

    public int getType() {
        return this.mType;
    }

    public p OZ() {
        return this.bdo;
    }

    public e.a Pq() {
        return this.bkE;
    }

    private void Pa() {
        this.aUU = System.currentTimeMillis();
        this.bkC.Dy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(n nVar) {
        this.blE.bdL.b(nVar);
        this.bdo.d(nVar);
        this.bkB = new ArrayList<>();
        if (this.bdo.getThreadList() != null) {
            this.bkB.addAll(this.bdo.getThreadList());
        }
        if (this.bdo.aDK().aEe() == 1) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        if (this.blG) {
            this.mPageType = "good_page";
        }
    }

    /* renamed from: com.baidu.tieba.frs.mc.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0059a extends BdAsyncTask<Object, n, Void> {
        private String blU;
        private a blV;
        private boolean needCache;

        public C0059a(a aVar, boolean z, String str) {
            this.blU = null;
            this.blU = str;
            this.blV = aVar;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            if (this.needCache && d.aDI().mg(this.blU)) {
                if (!d.aDI().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.blU)) {
                    d.aDI().getResponseData().akG().getSignData().setIsSigned(0);
                }
                publishProgress(d.aDI().getResponseData());
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
            this.blV.c(nVarArr.length > 0 ? nVarArr[0] : null);
        }
    }

    public long Ku() {
        return this.aUX;
    }

    public long Kv() {
        return this.aUV;
    }

    public long Kw() {
        return this.aUW;
    }

    public long Kx() {
        return this.aUU;
    }

    public boolean isLoading() {
        return this.bkC.isLoading();
    }

    public int Pr() {
        return this.blK;
    }

    private void Ps() {
        if (this.blR == null) {
            this.blR = new ArrayList<>();
        }
        if (this.blR.size() == 0) {
            this.blR.add(new ea());
        }
    }

    @Override // com.baidu.tieba.frs.eu
    public void a(int i, int i2, ex exVar) {
        if (exVar == null && (exVar = ab(i, i2)) == null) {
            if (i != 1 && k.jh() && this.blQ != null) {
                ey eyVar = new ey();
                eyVar.hasMore = false;
                eyVar.pn = 1;
                eyVar.forumName = this.bde;
                eyVar.bjk = false;
                if (this.bdo != null && this.bdo.akG() != null) {
                    eyVar.forumId = this.bdo.akG().getId();
                }
                Ps();
                this.bdo.am(this.blR);
                this.blQ.a(i, i2, eyVar, this.blR);
            }
            exVar = new ex();
            exVar.pn = -1;
        }
        if (this.bdo != null && this.bdo.akG() != null) {
            exVar.forumId = this.bdo.akG().getId();
        }
        exVar.forumName = this.bde;
        if (ed.Ox().gc(1) != null && i == 1) {
            this.bkD.setCategoryId(i2);
        }
        this.blI = i;
        this.blJ = i2;
        this.blL = exVar;
        b(i, i2, exVar);
        gk(5);
    }

    @Override // com.baidu.tieba.frs.eu
    public void a(ev evVar) {
        this.blQ = evVar;
        this.blO.a(this.blP);
    }

    private void gk(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.blL != null) {
                    this.blL.pn++;
                    break;
                }
                break;
            case 2:
                if (this.blL != null) {
                    ex exVar = this.blL;
                    exVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.blL != null) {
                    this.blL.pn = -1;
                    break;
                }
                break;
        }
        if (this.blI == 1) {
            if (this.blK == this.blJ) {
                ArrayList<u> arrayList = new ArrayList<>();
                if (this.bkB != null) {
                    arrayList.addAll(this.bkB);
                }
                this.bdo.am(arrayList);
                if (this.blQ != null) {
                    this.blQ.a(this.blI, this.blJ, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.blK = this.blJ;
            return;
        }
        eu gd = this.blO.gd(this.blI);
        if (gd != null) {
            this.blM = true;
            gd.a(this.blI, this.blJ, this.blL);
            return;
        }
        if (this.bdo != null && this.bdo.getThreadList() != null) {
            this.bdo.getThreadList().clear();
        }
        this.blQ.a(this.blI, this.blJ, null, null);
    }

    public boolean hasMore() {
        if ((this.blL instanceof ey) && ((ey) this.blL).errCode == 0) {
            return ((ey) this.blL).hasMore;
        }
        return true;
    }

    private int aa(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ex exVar) {
        this.blN.put(aa(i, i2), exVar);
    }

    public ex ab(int i, int i2) {
        return this.blN.get(aa(i, i2));
    }

    @Override // com.baidu.tieba.frs.eu
    public void init() {
        this.blO.init();
    }

    @Override // com.baidu.tieba.frs.eu
    public void My() {
        this.blO.destory();
        this.blO.clear();
    }

    public int Pt() {
        return this.blI;
    }

    public int Pu() {
        return this.blJ;
    }

    public ex Pv() {
        return this.blL;
    }

    public void a(o oVar) {
        if (oVar != null && !StringUtils.isNull(oVar.getId()) && this.bkB != null) {
            if (this.blI == 1) {
                this.bdo.a(oVar);
            }
            int Pw = Pw();
            if (this.bkB != null && this.bkB.size() > 0) {
                int size = this.bkB.size();
                for (int i = 0; i < size; i++) {
                    u uVar = this.bkB.get(i);
                    if ((uVar instanceof z) && oVar.getId().equals(((z) uVar).getId())) {
                        return;
                    }
                }
            }
            if (oVar.getThreadType() == 33) {
                w wVar = new w();
                wVar.a(oVar, -1);
                wVar.setPost_num(1);
                if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.bkB.add(Pw, wVar);
                    return;
                }
                return;
            }
            this.bkB.add(Pw, oVar);
        }
    }

    public int Pw() {
        if (this.bkB == null || this.bkB.size() <= 0) {
            return 0;
        }
        Iterator<u> it = this.bkB.iterator();
        int i = 0;
        while (it.hasNext()) {
            u next = it.next();
            if (next instanceof z) {
                if (((z) next).getIs_top() != 0) {
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

    public boolean Px() {
        return this.blM;
    }

    public void Py() {
        cw cwVar = new cw();
        if (this.bdo.getThreadList() != null) {
            this.bdo.getThreadList().clear();
            this.bdo.getThreadList().add(cwVar);
        }
        if (this.bkB != null) {
            this.bkB.clear();
            this.bkB.add(cwVar);
        }
    }
}
