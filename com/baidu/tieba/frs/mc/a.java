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
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.frs.ea;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.frs.ef;
import com.baidu.tieba.frs.et;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ew;
import com.baidu.tieba.frs.ey;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> implements NetModel.b<m, n>, et {
    private com.baidu.tieba.tbadkCore.d.a aRc;
    private long aRd;
    private long aRe;
    private long aRf;
    private long aRg;
    private String aZi;
    private int aZj;
    private p aZs;
    private long ayt;
    private ArrayList<u> bgK;
    private c<FrsActivity> bgL;
    private m bgM;
    e.a bgN;
    private String bgO;
    private boolean bgQ;
    private boolean bgR;
    private FrsActivity bhN;
    private long bhO;
    private boolean bhP;
    private String bhQ;
    private int bhR;
    private int bhS;
    private int bhT;
    private ew bhU;
    private boolean bhV;
    private SparseArray<ew> bhW;
    private ef bhX;
    private eu bhY;
    private eu bhZ;
    private ArrayList<u> bia;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.aZi = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.aZj = 0;
        this.bhO = 0L;
        this.bhP = false;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.bhQ = null;
        this.bgO = null;
        this.bhR = 1;
        this.bhS = 0;
        this.bhT = 0;
        this.bhV = false;
        this.bhW = new SparseArray<>();
        this.bhY = new b(this);
        this.aRc = null;
        this.ayt = 0L;
        this.bgQ = false;
        this.bgR = false;
        this.aRd = 0L;
        this.aRe = 0L;
        this.aRf = 0L;
        this.aRg = 0L;
        this.bhN = frsActivity;
        B(frsActivity);
    }

    private void B(FrsActivity frsActivity) {
        this.bhX = new ef();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.bhX));
        this.bhX.a(this.bhY);
    }

    public void onActivityDestroy() {
        if (this.aRc != null) {
            this.aRc.destory();
        }
        this.bgL.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.aZi = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aZj = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.bhP = bundle.getBoolean(FrsActivityConfig.GOOD, false);
        }
        if (TextUtils.isEmpty(this.aZi)) {
            this.aZi = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.bgM = new m();
        this.aZs = new p();
        this.bgL = new c<>(this.bhN.getPageContext(), this.bgM);
        this.bgL.a(this);
        this.bgL.setUniqueId(getUniqueId());
        if (this.aZi != null && this.aZi.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.aZi);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.aZj);
        bundle.putBoolean(FrsActivityConfig.GOOD, this.bhP);
    }

    public boolean oY() {
        return bO(true);
    }

    public boolean Iz() {
        if (this.bhR != 1) {
            gr(1);
            return true;
        } else if (this.bgL.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.bhN.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            m mVar = (m) m.objectWithJson(m.jsonWithObject(this.bgM), m.class);
            mVar.setPn(mVar.getPn() + 1);
            a(mVar, 1);
            return true;
        }
    }

    public boolean bO(boolean z) {
        return j(3, z);
    }

    public boolean j(int i, boolean z) {
        if (this.aZs != null && this.aZs.aBT() != null) {
            this.aZs.aBT().clear();
        }
        if (this.bhR != 1) {
            gr(i);
            return true;
        } else if (this.bgL.isLoading()) {
            return false;
        } else {
            m mVar = (m) m.objectWithJson(m.jsonWithObject(this.bgM), m.class);
            mVar.setPn(1);
            a(mVar, i);
            return true;
        }
    }

    public void gp(int i) {
        if (this.bhR != 1) {
            gr(4);
        } else if (!this.bgL.isLoading()) {
            m mVar = (m) m.objectWithJson(m.jsonWithObject(this.bgM), m.class);
            mVar.setPn(i);
            a(mVar, 4);
        }
    }

    public boolean OU() {
        if (this.bgL.isLoading()) {
            return false;
        }
        this.bhP = false;
        this.mPn = 1;
        return bO(true);
    }

    public boolean gq(int i) {
        if (this.bgL.isLoading()) {
            return false;
        }
        this.bhP = true;
        this.bhO = i;
        this.mPn = 1;
        return bO(true);
    }

    public boolean ax(String str, String str2) {
        if (this.bgL.isLoading() || str2 == null) {
            return false;
        }
        this.mSource = "sidebar";
        this.bhQ = str;
        this.bhP = false;
        this.aZi = str2;
        return bO(true);
    }

    private void a(m mVar, int i) {
        boolean z = true;
        this.bhN.aZP.fX(i);
        this.bgL.a(mVar);
        this.mType = i;
        mVar.setKw(this.aZi);
        if (com.baidu.tbadk.core.m.rh().rn()) {
            mVar.setRn(35);
        } else {
            mVar.setRn(50);
        }
        mVar.setWithGroup(1);
        if (this.bhP) {
            mVar.setIsGood(1);
            mVar.setCid((int) this.bhO);
        } else {
            mVar.setIsGood(0);
            mVar.setCid(0);
        }
        int K = k.K(this.bhN.getPageContext().getPageActivity());
        int L = k.L(this.bhN.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = ay.vq().vs() ? 2 : 1;
        mVar.setScrW(K);
        mVar.setScrH(L);
        mVar.setScrDip(f);
        mVar.setqType(i2);
        mVar.setLastId(this.bgO);
        if (this.mSource != null) {
            mVar.setStType(this.mSource);
            if (this.mSource.equalsIgnoreCase("sidebar")) {
                mVar.setStType(this.bhQ);
            }
        }
        if (FrsActivity.aZw != 0) {
            mVar.setCtime((int) FrsActivity.aZw);
        }
        if (FrsActivity.aZx != 0) {
            mVar.setDataSize((int) FrsActivity.aZx);
        }
        if (FrsActivity.aZy != 0) {
            mVar.setNetError(FrsActivity.aZy);
        }
        if (mVar.getPn() != 1 || ((!this.mPageType.equals("normal_page") && !this.mPageType.equals("frs_page")) || this.mType != 3 || this.bhP)) {
            z = false;
        }
        mVar.setUpdateType(this.mType);
        mVar.setNeedCache(z);
        if (!z) {
            OI();
        } else {
            OI();
            new C0061a(this, z, d.aBA().ai(this.aZi, this.bgM.getCategoryId())).execute(new Object[0]);
        }
        if (this.aRc == null) {
            this.aRc = new com.baidu.tieba.tbadkCore.d.a("frsStat");
            this.aRc.start();
        }
    }

    protected boolean a(m mVar, n nVar) {
        if (this.bhR == 1) {
            this.aZs.d(nVar);
            this.bgK = new ArrayList<>();
            if (this.aZs.aBC().aBW() == 1) {
                this.mPageType = "frs_page";
            } else {
                this.mPageType = "normal_page";
            }
            if (this.bhP) {
                this.mPageType = "good_page";
            }
            if (mVar != null) {
                this.bgM = mVar;
                this.mPn = this.bgM.getPn();
                this.aZi = this.bgM.getKw();
                this.bhN.hg(this.aZi);
                this.bhN.setFrom(this.mFrom);
                this.bhN.setPn(this.mPn);
                this.bhN.setFlag(this.aZj);
            }
            this.bhN.aZP.a(this.mType, false, this.bgN);
            if (this.aZs.getThreadList() != null) {
                this.bgK.addAll(this.aZs.getThreadList());
            }
            this.mSource = null;
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<n, ?> mvcSocketResponsedMessage, MvcSocketMessage<m, n> mvcSocketMessage, MvcNetMessage<m, n> mvcNetMessage) {
        n nVar;
        e.a aVar = new e.a();
        aVar.dwT = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.dwU = mvcSocketResponsedMessage.getDownSize();
        this.bgN = aVar;
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
        this.bhN.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<n, ?> mvcSocketResponsedMessage, MvcSocketMessage<m, n> mvcSocketMessage, MvcNetMessage<m, n> mvcNetMessage) {
        m mVar;
        m mVar2;
        OG();
        if (this.aRc != null) {
            this.aRc.a(false, this.bgN.isSuccess, this.bgN.errorCode, this.bgN.errorMsg, this.bgN.dwU);
            this.aRc = null;
        }
        if (!this.bgR) {
            this.bgR = true;
            t tVar = new t();
            tVar.eL(1000);
            tVar.ayy = false;
            tVar.isSuccess = this.bgN.isSuccess;
            tVar.ayn = mvcSocketResponsedMessage.performanceData.qx;
            tVar.ayo = mvcSocketResponsedMessage.performanceData.qy;
            tVar.ayp = mvcSocketResponsedMessage.performanceData.qz;
            tVar.ayq = mvcSocketResponsedMessage.performanceData.qA;
            tVar.ayr = mvcSocketResponsedMessage.performanceData.qB;
            tVar.ayw = this.bgN.dwU;
            tVar.errCode = this.bgN.errorCode;
            tVar.ayx = 0L;
            if (this.bhN.aZP != null) {
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
        aVar.dwT = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.dwU = mvcHttpResponsedMessage.getDownSize();
        this.bgN = aVar;
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
        this.bhN.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    private void b(MvcHttpResponsedMessage<n> mvcHttpResponsedMessage, MvcHttpMessage<m, n> mvcHttpMessage, MvcNetMessage<m, n> mvcNetMessage) {
        m mVar;
        m mVar2;
        OG();
        if (this.aRc != null) {
            this.aRc.a(true, this.bgN.isSuccess, this.bgN.errorCode, this.bgN.errorMsg, this.bgN.dwU);
            this.aRc = null;
        }
        if (!this.bgR) {
            this.bgR = true;
            t tVar = new t();
            tVar.eL(1000);
            tVar.ayy = true;
            tVar.isSuccess = this.bgN.isSuccess;
            tVar.ayn = mvcHttpResponsedMessage.performanceData.qx;
            tVar.ayo = mvcHttpResponsedMessage.performanceData.qy;
            tVar.ayp = mvcHttpResponsedMessage.performanceData.qz;
            tVar.ayq = mvcHttpResponsedMessage.performanceData.qA;
            tVar.ayr = mvcHttpResponsedMessage.performanceData.qB;
            tVar.ayw = 0L;
            tVar.ayx = this.bgN.dwU;
            tVar.socketErrNo = mvcHttpResponsedMessage.performanceData.qC;
            tVar.errCode = this.bgN.errorCode;
            if (this.bhN.aZP != null) {
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

    public void OV() {
        if (this.aZs != null && this.aZs.ajy() != null && this.aZs.ajy().getBannerListData() != null) {
            String lastIds = this.aZs.ajy().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.bgO = lastIds;
            }
        }
    }

    public void OG() {
        if (!this.bgQ) {
            this.bgQ = true;
            this.ayt = System.currentTimeMillis() - this.bhN.Vp;
            t tVar = new t();
            tVar.eL(1000);
            tVar.aym = this.bhN.createTime;
            tVar.ayt = this.ayt;
            tVar.EM();
        }
    }

    public void e(t tVar) {
        if (tVar != null) {
            tVar.aym = this.bhN.createTime;
            this.bhN.createTime = 0L;
            tVar.ays = this.bhN.ays;
            tVar.ayt = this.ayt == 0 ? System.currentTimeMillis() - this.bhN.Vp : this.ayt;
            tVar.EN();
        }
    }

    public String OW() {
        return this.mPageType;
    }

    public boolean OX() {
        return this.bhP;
    }

    public int getType() {
        return this.mType;
    }

    public p OH() {
        return this.aZs;
    }

    public e.a OY() {
        return this.bgN;
    }

    private void OI() {
        this.aRd = System.currentTimeMillis();
        this.bgL.DJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(n nVar) {
        this.bhN.aZP.b(nVar);
        this.aZs.d(nVar);
        this.bgK = new ArrayList<>();
        if (this.aZs.getThreadList() != null) {
            this.bgK.addAll(this.aZs.getThreadList());
        }
        if (this.aZs.aBC().aBW() == 1) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        if (this.bhP) {
            this.mPageType = "good_page";
        }
    }

    /* renamed from: com.baidu.tieba.frs.mc.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0061a extends BdAsyncTask<Object, n, Void> {
        private String bic;
        private a bie;
        private boolean needCache;

        public C0061a(a aVar, boolean z, String str) {
            this.bic = null;
            this.bic = str;
            this.bie = aVar;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            if (this.needCache && d.aBA().mi(this.bic)) {
                if (!d.aBA().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.bic)) {
                    d.aBA().getResponseData().ajy().getSignData().setIsSigned(0);
                }
                publishProgress(d.aBA().getResponseData());
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
            this.bie.c(nVarArr.length > 0 ? nVarArr[0] : null);
        }
    }

    public long Kb() {
        return this.aRg;
    }

    public long Kc() {
        return this.aRe;
    }

    public long Kd() {
        return this.aRf;
    }

    public long Ke() {
        return this.aRd;
    }

    public boolean isLoading() {
        return this.bgL.isLoading();
    }

    public int OZ() {
        return this.bhT;
    }

    private void Pa() {
        if (this.bia == null) {
            this.bia = new ArrayList<>();
        }
        if (this.bia.size() == 0) {
            this.bia.add(new ea());
        }
    }

    @Override // com.baidu.tieba.frs.et
    public void a(int i, int i2, ew ewVar) {
        if (ewVar == null && (ewVar = ab(i, i2)) == null) {
            if (i != 1 && k.jg() && this.bhZ != null) {
                ey eyVar = new ey();
                eyVar.hasMore = false;
                eyVar.pn = 1;
                eyVar.forumName = this.aZi;
                eyVar.bfs = false;
                if (this.aZs != null && this.aZs.ajy() != null) {
                    eyVar.forumId = this.aZs.ajy().getId();
                }
                Pa();
                this.aZs.am(this.bia);
                this.bhZ.a(i, i2, eyVar, this.bia);
            }
            ewVar = new ew();
            ewVar.pn = -1;
        }
        if (this.aZs != null && this.aZs.ajy() != null) {
            ewVar.forumId = this.aZs.ajy().getId();
        }
        ewVar.forumName = this.aZi;
        if (ed.Oe().gj(1) != null && i == 1) {
            this.bgM.setCategoryId(i2);
        }
        this.bhR = i;
        this.bhS = i2;
        this.bhU = ewVar;
        b(i, i2, ewVar);
        gr(5);
    }

    @Override // com.baidu.tieba.frs.et
    public void a(eu euVar) {
        this.bhZ = euVar;
        this.bhX.a(this.bhY);
    }

    private void gr(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.bhU != null) {
                    this.bhU.pn++;
                    break;
                }
                break;
            case 2:
                if (this.bhU != null) {
                    ew ewVar = this.bhU;
                    ewVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.bhU != null) {
                    this.bhU.pn = -1;
                    break;
                }
                break;
        }
        if (this.bhR == 1) {
            if (this.bhT == this.bhS) {
                ArrayList<u> arrayList = new ArrayList<>();
                if (this.bgK != null) {
                    arrayList.addAll(this.bgK);
                }
                this.aZs.am(arrayList);
                if (this.bhZ != null) {
                    this.bhZ.a(this.bhR, this.bhS, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.bhT = this.bhS;
            return;
        }
        et gk = this.bhX.gk(this.bhR);
        if (gk != null) {
            this.bhV = true;
            gk.a(this.bhR, this.bhS, this.bhU);
            return;
        }
        if (this.aZs != null && this.aZs.getThreadList() != null) {
            this.aZs.getThreadList().clear();
        }
        this.bhZ.a(this.bhR, this.bhS, null, null);
    }

    public boolean hasMore() {
        if ((this.bhU instanceof ey) && ((ey) this.bhU).errCode == 0) {
            return ((ey) this.bhU).hasMore;
        }
        return true;
    }

    private int aa(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ew ewVar) {
        this.bhW.put(aa(i, i2), ewVar);
    }

    public ew ab(int i, int i2) {
        return this.bhW.get(aa(i, i2));
    }

    @Override // com.baidu.tieba.frs.et
    public void init() {
        this.bhX.init();
    }

    @Override // com.baidu.tieba.frs.et
    public void Mf() {
        this.bhX.destory();
        this.bhX.clear();
    }

    public int Pb() {
        return this.bhR;
    }

    public int Pc() {
        return this.bhS;
    }

    public ew Pd() {
        return this.bhU;
    }

    public void a(o oVar) {
        if (oVar != null && !StringUtils.isNull(oVar.getId()) && this.bgK != null) {
            if (this.bhR == 1) {
                this.aZs.a(oVar);
            }
            int Pe = Pe();
            if (this.bgK != null && this.bgK.size() > 0) {
                int size = this.bgK.size();
                for (int i = 0; i < size; i++) {
                    u uVar = this.bgK.get(i);
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
                    this.bgK.add(Pe, wVar);
                    return;
                }
                return;
            }
            this.bgK.add(Pe, oVar);
        }
    }

    public int Pe() {
        if (this.bgK == null || this.bgK.size() <= 0) {
            return 0;
        }
        Iterator<u> it = this.bgK.iterator();
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

    public boolean Pf() {
        return this.bhV;
    }

    public void Pg() {
        ct ctVar = new ct();
        if (this.aZs.getThreadList() != null) {
            this.aZs.getThreadList().clear();
            this.aZs.getThreadList().add(ctVar);
        }
        if (this.bgK != null) {
            this.bgK.clear();
            this.bgK.add(ctVar);
        }
    }
}
