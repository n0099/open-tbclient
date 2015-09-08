package com.baidu.tieba.frs.b;

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
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.performanceLog.t;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cv;
import com.baidu.tieba.frs.cz;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.di;
import com.baidu.tieba.frs.dj;
import com.baidu.tieba.frs.dl;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> implements NetModel.b<l, m>, dh {
    private com.baidu.tieba.tbadkCore.e.a aNf;
    private long aNg;
    private long aNh;
    private long aNi;
    private long aNj;
    private String aUF;
    private int aUG;
    private o aUN;
    private ArrayList<u> aZU;
    private c<FrsActivity> aZV;
    private l aZW;
    e.a aZX;
    private String aZY;
    private int aZZ;
    private long ayZ;
    private FrsActivity baN;
    private long baO;
    private boolean baP;
    private String baQ;
    private int baR;
    private dj baS;
    private boolean baT;
    private SparseArray<dj> baU;
    private cz baV;
    private di baW;
    private di baX;
    private ArrayList<u> baY;
    private boolean baa;
    private boolean bab;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.aUF = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.aUG = 0;
        this.baO = 0L;
        this.baP = false;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.baQ = null;
        this.aZY = null;
        this.aZZ = 1;
        this.baR = 0;
        this.baT = false;
        this.baU = new SparseArray<>();
        this.baW = new b(this);
        this.aNf = null;
        this.ayZ = 0L;
        this.baa = false;
        this.bab = false;
        this.aNg = 0L;
        this.aNh = 0L;
        this.aNi = 0L;
        this.aNj = 0L;
        this.baN = frsActivity;
        x(frsActivity);
    }

    private void x(FrsActivity frsActivity) {
        this.baV = new cz();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.baV));
        this.baV.a(this.baW);
    }

    public void onActivityDestroy() {
        if (this.aNf != null) {
            this.aNf.destory();
        }
        this.aZV.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.aUF = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aUG = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.baP = bundle.getBoolean(FrsActivityConfig.GOOD, false);
        }
        if (TextUtils.isEmpty(this.aUF)) {
            this.aUF = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.aZW = new l();
        this.aUN = new o();
        this.aZV = new c<>(this.baN.getPageContext(), this.aZW);
        this.aZV.a(this);
        this.aZV.setUniqueId(getUniqueId());
        if (this.aUF != null && this.aUF.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.aUF);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.aUG);
        bundle.putBoolean(FrsActivityConfig.GOOD, this.baP);
    }

    public boolean oQ() {
        return bE(true);
    }

    public boolean Ht() {
        if (this.aZZ != 1) {
            fH(1);
            return true;
        } else if (this.aZV.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.baN.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.aZW), l.class);
            lVar.setPn(lVar.getPn() + 1);
            a(lVar, 1);
            return true;
        }
    }

    public boolean bE(boolean z) {
        if (this.aZZ != 1) {
            fH(3);
            return true;
        } else if (this.aZV.isLoading()) {
            return false;
        } else {
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.aZW), l.class);
            lVar.setPn(1);
            a(lVar, 3);
            return true;
        }
    }

    public void fF(int i) {
        if (this.aZZ != 1) {
            fH(4);
        } else if (!this.aZV.isLoading()) {
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.aZW), l.class);
            lVar.setPn(i);
            a(lVar, 4);
        }
    }

    public boolean Nb() {
        if (this.aZV.isLoading()) {
            return false;
        }
        this.baP = false;
        this.mPn = 1;
        return bE(true);
    }

    public boolean fG(int i) {
        if (this.aZV.isLoading()) {
            return false;
        }
        this.baP = true;
        this.baO = i;
        this.mPn = 1;
        return bE(true);
    }

    public boolean aw(String str, String str2) {
        if (this.aZV.isLoading() || str2 == null) {
            return false;
        }
        this.mSource = "sidebar";
        this.baQ = str;
        this.baP = false;
        this.aUF = str2;
        return bE(true);
    }

    private void a(l lVar, int i) {
        boolean z = true;
        this.baN.aVj.fo(i);
        this.aZV.a(lVar);
        this.mType = i;
        lVar.setKw(this.aUF);
        if (com.baidu.tbadk.core.m.rb().rf()) {
            lVar.setRn(35);
        } else {
            lVar.setRn(50);
        }
        lVar.setWithGroup(1);
        if (this.baP) {
            lVar.setIsGood(1);
            lVar.setCid((int) this.baO);
        } else {
            lVar.setIsGood(0);
            lVar.setCid(0);
        }
        int K = k.K(this.baN.getPageContext().getPageActivity());
        int L = k.L(this.baN.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = ar.uK().uM() ? 2 : 1;
        lVar.setScrW(K);
        lVar.setScrH(L);
        lVar.setScrDip(f);
        lVar.setqType(i2);
        lVar.setLastId(this.aZY);
        if (this.mSource != null) {
            lVar.setStType(this.mSource);
            if (this.mSource.equalsIgnoreCase("sidebar")) {
                lVar.setStType(this.baQ);
            }
        }
        if (FrsActivity.aUS != 0) {
            lVar.setCtime((int) FrsActivity.aUS);
        }
        if (FrsActivity.aUT != 0) {
            lVar.setDataSize((int) FrsActivity.aUT);
        }
        if (FrsActivity.aUU != 0) {
            lVar.setNetError(FrsActivity.aUU);
        }
        if (lVar.getPn() != 1 || ((!this.mPageType.equals("normal_page") && !this.mPageType.equals("frs_page")) || this.mType != 3 || this.baP)) {
            z = false;
        }
        lVar.setUpdateType(this.mType);
        lVar.setNeedCache(z);
        new C0056a(this, z, this.aUF).execute(new Object[0]);
        if (this.aNf == null) {
            this.aNf = new com.baidu.tieba.tbadkCore.e.a("frsStat");
            this.aNf.start();
        }
    }

    protected boolean a(l lVar, m mVar) {
        if (this.aZZ == 1) {
            this.aUN.d(mVar);
            this.aZU = new ArrayList<>();
            if (this.aUN.getThreadList() != null) {
                this.aZU.addAll(this.aUN.getThreadList());
            }
            if (this.aUN.asY().ato() == 1) {
                this.mPageType = "frs_page";
            } else {
                this.mPageType = "normal_page";
            }
            if (this.baP) {
                this.mPageType = "good_page";
            }
            if (lVar != null) {
                this.aZW = lVar;
                this.mPn = this.aZW.getPn();
                this.aUF = this.aZW.getKw();
                this.baN.gK(this.aUF);
                this.baN.setFrom(this.mFrom);
                this.baN.setPn(this.mPn);
                this.baN.setFlag(this.aUG);
            }
            this.baN.aVj.a(this.mType, false, this.aZX);
            this.mSource = null;
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        e.a aVar = new e.a();
        aVar.cPd = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.cPe = mvcSocketResponsedMessage.getDownSize();
        this.aZX = aVar;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
            mVar = null;
        } else {
            mVar = mvcSocketResponsedMessage.getData();
            r3 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && mVar != null && a(r3, mVar)) {
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
        this.baN.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        l lVar;
        l lVar2;
        MR();
        if (this.aNf != null) {
            this.aNf.a(false, this.aZX.isSuccess, this.aZX.errorCode, this.aZX.errorMsg, this.aZX.cPe);
            this.aNf = null;
        }
        if (!this.bab) {
            this.bab = true;
            t tVar = new t();
            tVar.ey(1000);
            tVar.aze = false;
            tVar.isSuccess = this.aZX.isSuccess;
            tVar.ayT = mvcSocketResponsedMessage.performanceData.qw;
            tVar.ayU = mvcSocketResponsedMessage.performanceData.qx;
            tVar.ayV = mvcSocketResponsedMessage.performanceData.qy;
            tVar.ayW = mvcSocketResponsedMessage.performanceData.qz;
            tVar.ayX = mvcSocketResponsedMessage.performanceData.qA;
            tVar.azc = this.aZX.cPe;
            tVar.azd = 0L;
            if (this.baN.aVj != null) {
                e(tVar);
            }
        }
        long j = 0;
        if (mvcSocketMessage == null) {
            lVar = null;
        } else {
            j = mvcSocketMessage.getClientLogID();
            lVar = mvcSocketMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            lVar2 = mvcNetMessage.getRequestData();
        } else {
            lVar2 = lVar;
        }
        int error = mvcSocketResponsedMessage.getError();
        String errorString = mvcSocketResponsedMessage.getErrorString();
        int cmd = mvcSocketResponsedMessage.getCmd();
        Object[] objArr = new Object[2];
        objArr[0] = "kw";
        objArr[1] = lVar2 != null ? lVar2.getKw() : null;
        com.baidu.tbadk.core.log.b.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        e.a aVar = new e.a();
        aVar.cPd = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.cPe = mvcHttpResponsedMessage.getDownSize();
        this.aZX = aVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            mVar = null;
        } else {
            mVar = mvcHttpResponsedMessage.getData();
            r3 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && mVar != null && a(r3, mVar)) {
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
        this.baN.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    private void b(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        l lVar;
        l lVar2;
        MR();
        if (this.aNf != null) {
            this.aNf.a(true, this.aZX.isSuccess, this.aZX.errorCode, this.aZX.errorMsg, this.aZX.cPe);
            this.aNf = null;
        }
        if (!this.bab) {
            this.bab = true;
            t tVar = new t();
            tVar.ey(1000);
            tVar.aze = true;
            tVar.isSuccess = this.aZX.isSuccess;
            tVar.ayT = mvcHttpResponsedMessage.performanceData.qw;
            tVar.ayU = mvcHttpResponsedMessage.performanceData.qx;
            tVar.ayV = mvcHttpResponsedMessage.performanceData.qy;
            tVar.ayW = mvcHttpResponsedMessage.performanceData.qz;
            tVar.ayX = mvcHttpResponsedMessage.performanceData.qA;
            tVar.azc = 0L;
            tVar.azd = this.aZX.cPe;
            if (this.baN.aVj != null) {
                e(tVar);
            }
        }
        long j = 0;
        if (mvcHttpMessage == null) {
            lVar = null;
        } else {
            j = mvcHttpMessage.getClientLogID();
            lVar = mvcHttpMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            lVar2 = mvcNetMessage.getRequestData();
        } else {
            lVar2 = lVar;
        }
        int error = mvcHttpResponsedMessage.getError();
        String errorString = mvcHttpResponsedMessage.getErrorString();
        int cmd = mvcHttpResponsedMessage.getCmd();
        Object[] objArr = new Object[2];
        objArr[0] = "kw";
        objArr[1] = lVar2 != null ? lVar2.getKw() : null;
        com.baidu.tbadk.core.log.b.a("frs", j, cmd, "http_resp", error, errorString, objArr);
    }

    public void Nc() {
        if (this.aUN != null && this.aUN.acP() != null && this.aUN.acP().getBannerListData() != null) {
            String lastIds = this.aUN.acP().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.aZY = lastIds;
            }
        }
    }

    public void MR() {
        if (!this.baa) {
            this.baa = true;
            this.ayZ = System.currentTimeMillis() - this.baN.aUR;
            t tVar = new t();
            tVar.ey(1000);
            tVar.ayS = this.baN.createTime;
            tVar.ayZ = this.ayZ;
            tVar.Ei();
        }
    }

    public void e(t tVar) {
        if (tVar != null) {
            tVar.ayS = this.baN.createTime;
            this.baN.createTime = 0L;
            tVar.ayY = this.baN.ayY;
            tVar.ayZ = this.ayZ == 0 ? System.currentTimeMillis() - this.baN.aUR : this.ayZ;
            tVar.Ej();
        }
    }

    public String Nd() {
        return this.mPageType;
    }

    public boolean Ne() {
        return this.baP;
    }

    public int getType() {
        return this.mType;
    }

    public o MS() {
        return this.aUN;
    }

    public e.a Nf() {
        return this.aZX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MT() {
        this.aNg = System.currentTimeMillis();
        this.aZV.Df();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(m mVar) {
        this.baN.aVj.b(mVar);
        this.aUN.d(mVar);
        this.aZU = new ArrayList<>();
        if (this.aUN.getThreadList() != null) {
            this.aZU.addAll(this.aUN.getThreadList());
        }
        if (this.aUN.asY().ato() == 1) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        if (this.baP) {
            this.mPageType = "good_page";
        }
    }

    /* renamed from: com.baidu.tieba.frs.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0056a extends BdAsyncTask<Object, m, Void> {
        private a bba;
        private String mName;
        private boolean needCache;

        public C0056a(a aVar, boolean z, String str) {
            this.mName = null;
            this.mName = str;
            this.bba = aVar;
            this.needCache = z;
            setSelfExecute(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            if (this.needCache && d.asX().kP(this.mName)) {
                if (!d.asX().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.mName)) {
                    d.asX().getResponseData().acP().getSignData().setIsSigned(0);
                }
                publishProgress(d.asX().getResponseData());
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(m... mVarArr) {
            super.onProgressUpdate(mVarArr);
            this.bba.c(mVarArr.length > 0 ? mVarArr[0] : null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r2) {
            super.onPostExecute(r2);
            this.bba.MT();
        }
    }

    public long IB() {
        return this.aNj;
    }

    public long IC() {
        return this.aNh;
    }

    public long ID() {
        return this.aNi;
    }

    public long IE() {
        return this.aNg;
    }

    public boolean isLoading() {
        return this.aZV.isLoading();
    }

    private void Ng() {
        if (this.baY == null) {
            this.baY = new ArrayList<>();
        }
        if (this.baY.size() == 0) {
            this.baY.add(new cv());
        }
    }

    @Override // com.baidu.tieba.frs.dh
    public void a(int i, int i2, dj djVar) {
        if (djVar == null && (djVar = X(i, i2)) == null) {
            if (i != 1 && k.jc() && this.baX != null) {
                dl dlVar = new dl();
                dlVar.hasMore = false;
                dlVar.pn = 1;
                dlVar.forumName = this.aUF;
                dlVar.aZb = false;
                if (this.aUN != null && this.aUN.acP() != null) {
                    dlVar.forumId = this.aUN.acP().getId();
                }
                Ng();
                this.aUN.ad(this.baY);
                this.baX.a(i, i2, dlVar, this.baY);
            }
            djVar = new dj();
            djVar.pn = -1;
        }
        if (this.aUN != null && this.aUN.acP() != null) {
            djVar.forumId = this.aUN.acP().getId();
        }
        djVar.forumName = this.aUF;
        this.aZZ = i;
        this.baR = i2;
        this.baS = djVar;
        b(i, i2, djVar);
        fH(5);
    }

    @Override // com.baidu.tieba.frs.dh
    public void a(di diVar) {
        this.baX = diVar;
        this.baV.a(this.baW);
    }

    private void fH(int i) {
        switch (i) {
            case 1:
            case 4:
                if (this.baS != null) {
                    this.baS.pn++;
                    break;
                }
                break;
            case 2:
                if (this.baS != null) {
                    dj djVar = this.baS;
                    djVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.baS != null) {
                    this.baS.pn = -1;
                    break;
                }
                break;
        }
        if (this.aZZ == 1) {
            ArrayList<u> arrayList = new ArrayList<>();
            if (this.aZU != null) {
                arrayList.addAll(this.aZU);
            }
            this.aUN.ad(arrayList);
            if (this.baX != null) {
                this.baX.a(this.aZZ, this.baR, null, arrayList);
                return;
            }
            return;
        }
        dh fB = this.baV.fB(this.aZZ);
        if (fB != null) {
            this.baT = true;
            fB.a(this.aZZ, this.baR, this.baS);
            return;
        }
        if (this.aUN != null && this.aUN.getThreadList() != null) {
            this.aUN.getThreadList().clear();
        }
        this.baX.a(this.aZZ, this.baR, null, null);
    }

    public boolean hasMore() {
        if (this.baS == null || !(this.baS instanceof dl)) {
            return true;
        }
        return ((dl) this.baS).hasMore;
    }

    private int W(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, dj djVar) {
        this.baU.put(W(i, i2), djVar);
    }

    public dj X(int i, int i2) {
        return this.baU.get(W(i, i2));
    }

    @Override // com.baidu.tieba.frs.dh
    public void init() {
        this.baV.init();
    }

    @Override // com.baidu.tieba.frs.dh
    public void Kz() {
        this.baV.destory();
        this.baV.clear();
    }

    public int Nh() {
        return this.aZZ;
    }

    public int Ni() {
        return this.baR;
    }

    public dj Nj() {
        return this.baS;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null && !StringUtils.isNull(mVar.getId()) && this.aZU != null) {
            if (this.aZZ == 1) {
                this.aUN.a(mVar);
            }
            int Nk = Nk();
            if (this.aZU != null && this.aZU.size() > 0) {
                int size = this.aZU.size();
                for (int i = 0; i < size; i++) {
                    u uVar = this.aZU.get(i);
                    if ((uVar instanceof x) && mVar.getId().equals(((x) uVar).getId())) {
                        return;
                    }
                }
            }
            if (mVar.sv() == 33) {
                com.baidu.tbadk.core.data.t tVar = new com.baidu.tbadk.core.data.t();
                tVar.a(mVar);
                tVar.setPost_num(1);
                if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.aZU.add(Nk, tVar);
                    return;
                }
                return;
            }
            this.aZU.add(Nk, mVar);
        }
    }

    public int Nk() {
        if (this.aZU == null || this.aZU.size() <= 0) {
            return 0;
        }
        Iterator<u> it = this.aZU.iterator();
        int i = 0;
        while (it.hasNext()) {
            u next = it.next();
            if (next instanceof x) {
                if (((x) next).getIs_top() != 0) {
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

    public boolean Nl() {
        return this.baT;
    }
}
