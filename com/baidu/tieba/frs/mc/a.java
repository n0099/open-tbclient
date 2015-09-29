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
import com.baidu.tbadk.core.data.s;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.performanceLog.t;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.dk;
import com.baidu.tieba.frs.dn;
import com.baidu.tieba.frs.ea;
import com.baidu.tieba.frs.eb;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.ee;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> implements NetModel.b<l, m>, ea {
    private com.baidu.tieba.tbadkCore.e.a aMa;
    private long aMb;
    private long aMc;
    private long aMd;
    private long aMe;
    private String aTB;
    private int aTC;
    private o aTL;
    private ArrayList<u> aZN;
    private c<FrsActivity> aZO;
    private l aZP;
    e.a aZQ;
    private String aZR;
    private int aZS;
    private boolean aZT;
    private boolean aZU;
    private long axy;
    private FrsActivity baG;
    private long baH;
    private boolean baI;
    private String baJ;
    private int baK;
    private ec baL;
    private boolean baM;
    private SparseArray<ec> baN;
    private dn baO;
    private eb baP;
    private eb baQ;
    private ArrayList<u> baR;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.aTB = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.aTC = 0;
        this.baH = 0L;
        this.baI = false;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.baJ = null;
        this.aZR = null;
        this.aZS = 1;
        this.baK = 0;
        this.baM = false;
        this.baN = new SparseArray<>();
        this.baP = new b(this);
        this.aMa = null;
        this.axy = 0L;
        this.aZT = false;
        this.aZU = false;
        this.aMb = 0L;
        this.aMc = 0L;
        this.aMd = 0L;
        this.aMe = 0L;
        this.baG = frsActivity;
        B(frsActivity);
    }

    private void B(FrsActivity frsActivity) {
        this.baO = new dn();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.baO));
        this.baO.a(this.baP);
    }

    public void onActivityDestroy() {
        if (this.aMa != null) {
            this.aMa.destory();
        }
        this.aZO.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.aTB = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aTC = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.baI = bundle.getBoolean(FrsActivityConfig.GOOD, false);
        }
        if (TextUtils.isEmpty(this.aTB)) {
            this.aTB = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.aZP = new l();
        this.aTL = new o();
        this.aZO = new c<>(this.baG.getPageContext(), this.aZP);
        this.aZO.a(this);
        this.aZO.setUniqueId(getUniqueId());
        if (this.aTB != null && this.aTB.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.aTB);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.aTC);
        bundle.putBoolean(FrsActivityConfig.GOOD, this.baI);
    }

    public boolean oR() {
        return bB(true);
    }

    public boolean Hn() {
        if (this.aZS != 1) {
            fM(1);
            return true;
        } else if (this.aZO.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.baG.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.aZP), l.class);
            lVar.setPn(lVar.getPn() + 1);
            a(lVar, 1);
            return true;
        }
    }

    public boolean bB(boolean z) {
        if (this.aZS != 1) {
            fM(3);
            return true;
        } else if (this.aZO.isLoading()) {
            return false;
        } else {
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.aZP), l.class);
            lVar.setPn(1);
            a(lVar, 3);
            return true;
        }
    }

    public void fK(int i) {
        if (this.aZS != 1) {
            fM(4);
        } else if (!this.aZO.isLoading()) {
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.aZP), l.class);
            lVar.setPn(i);
            a(lVar, 4);
        }
    }

    public boolean Na() {
        if (this.aZO.isLoading()) {
            return false;
        }
        this.baI = false;
        this.mPn = 1;
        return bB(true);
    }

    public boolean fL(int i) {
        if (this.aZO.isLoading()) {
            return false;
        }
        this.baI = true;
        this.baH = i;
        this.mPn = 1;
        return bB(true);
    }

    public boolean av(String str, String str2) {
        if (this.aZO.isLoading() || str2 == null) {
            return false;
        }
        this.mSource = "sidebar";
        this.baJ = str;
        this.baI = false;
        this.aTB = str2;
        return bB(true);
    }

    private void a(l lVar, int i) {
        boolean z = true;
        this.baG.aUj.ft(i);
        this.aZO.a(lVar);
        this.mType = i;
        lVar.setKw(this.aTB);
        if (com.baidu.tbadk.core.m.qX().rb()) {
            lVar.setRn(35);
        } else {
            lVar.setRn(50);
        }
        lVar.setWithGroup(1);
        if (this.baI) {
            lVar.setIsGood(1);
            lVar.setCid((int) this.baH);
        } else {
            lVar.setIsGood(0);
            lVar.setCid(0);
        }
        int K = k.K(this.baG.getPageContext().getPageActivity());
        int L = k.L(this.baG.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = as.uI().uK() ? 2 : 1;
        lVar.setScrW(K);
        lVar.setScrH(L);
        lVar.setScrDip(f);
        lVar.setqType(i2);
        lVar.setLastId(this.aZR);
        if (this.mSource != null) {
            lVar.setStType(this.mSource);
            if (this.mSource.equalsIgnoreCase("sidebar")) {
                lVar.setStType(this.baJ);
            }
        }
        if (FrsActivity.aTQ != 0) {
            lVar.setCtime((int) FrsActivity.aTQ);
        }
        if (FrsActivity.aTR != 0) {
            lVar.setDataSize((int) FrsActivity.aTR);
        }
        if (FrsActivity.aTS != 0) {
            lVar.setNetError(FrsActivity.aTS);
        }
        if (lVar.getPn() != 1 || ((!this.mPageType.equals("normal_page") && !this.mPageType.equals("frs_page")) || this.mType != 3 || this.baI)) {
            z = false;
        }
        lVar.setUpdateType(this.mType);
        lVar.setNeedCache(z);
        if (!z) {
            MS();
        } else {
            MS();
            new C0055a(this, z, this.aTB).execute(new Object[0]);
        }
        if (this.aMa == null) {
            this.aMa = new com.baidu.tieba.tbadkCore.e.a("frsStat");
            this.aMa.start();
        }
    }

    protected boolean a(l lVar, m mVar) {
        if (this.aZS == 1) {
            this.aTL.d(mVar);
            this.aZN = new ArrayList<>();
            if (this.aTL.getThreadList() != null) {
                this.aZN.addAll(this.aTL.getThreadList());
            }
            if (this.aTL.avo().avE() == 1) {
                this.mPageType = "frs_page";
            } else {
                this.mPageType = "normal_page";
            }
            if (this.baI) {
                this.mPageType = "good_page";
            }
            if (lVar != null) {
                this.aZP = lVar;
                this.mPn = this.aZP.getPn();
                this.aTB = this.aZP.getKw();
                this.baG.gN(this.aTB);
                this.baG.setFrom(this.mFrom);
                this.baG.setPn(this.mPn);
                this.baG.setFlag(this.aTC);
            }
            this.baG.aUj.a(this.mType, false, this.aZQ);
            this.mSource = null;
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        e.a aVar = new e.a();
        aVar.cWu = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.cWv = mvcSocketResponsedMessage.getDownSize();
        this.aZQ = aVar;
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
        this.baG.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        l lVar;
        l lVar2;
        MQ();
        if (this.aMa != null) {
            this.aMa.a(false, this.aZQ.isSuccess, this.aZQ.errorCode, this.aZQ.errorMsg, this.aZQ.cWv);
            this.aMa = null;
        }
        if (!this.aZU) {
            this.aZU = true;
            t tVar = new t();
            tVar.ez(1000);
            tVar.axD = false;
            tVar.isSuccess = this.aZQ.isSuccess;
            tVar.axs = mvcSocketResponsedMessage.performanceData.qw;
            tVar.axt = mvcSocketResponsedMessage.performanceData.qx;
            tVar.axu = mvcSocketResponsedMessage.performanceData.qy;
            tVar.axv = mvcSocketResponsedMessage.performanceData.qz;
            tVar.axw = mvcSocketResponsedMessage.performanceData.qA;
            tVar.axB = this.aZQ.cWv;
            tVar.axC = 0L;
            if (this.baG.aUj != null) {
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
        aVar.cWu = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.cWv = mvcHttpResponsedMessage.getDownSize();
        this.aZQ = aVar;
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
        this.baG.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    private void b(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        l lVar;
        l lVar2;
        MQ();
        if (this.aMa != null) {
            this.aMa.a(true, this.aZQ.isSuccess, this.aZQ.errorCode, this.aZQ.errorMsg, this.aZQ.cWv);
            this.aMa = null;
        }
        if (!this.aZU) {
            this.aZU = true;
            t tVar = new t();
            tVar.ez(1000);
            tVar.axD = true;
            tVar.isSuccess = this.aZQ.isSuccess;
            tVar.axs = mvcHttpResponsedMessage.performanceData.qw;
            tVar.axt = mvcHttpResponsedMessage.performanceData.qx;
            tVar.axu = mvcHttpResponsedMessage.performanceData.qy;
            tVar.axv = mvcHttpResponsedMessage.performanceData.qz;
            tVar.axw = mvcHttpResponsedMessage.performanceData.qA;
            tVar.axB = 0L;
            tVar.axC = this.aZQ.cWv;
            if (this.baG.aUj != null) {
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

    public void Nb() {
        if (this.aTL != null && this.aTL.aeN() != null && this.aTL.aeN().getBannerListData() != null) {
            String lastIds = this.aTL.aeN().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.aZR = lastIds;
            }
        }
    }

    public void MQ() {
        if (!this.aZT) {
            this.aZT = true;
            this.axy = System.currentTimeMillis() - this.baG.aTP;
            t tVar = new t();
            tVar.ez(1000);
            tVar.axr = this.baG.createTime;
            tVar.axy = this.axy;
            tVar.DV();
        }
    }

    public void e(t tVar) {
        if (tVar != null) {
            tVar.axr = this.baG.createTime;
            this.baG.createTime = 0L;
            tVar.axx = this.baG.axx;
            tVar.axy = this.axy == 0 ? System.currentTimeMillis() - this.baG.aTP : this.axy;
            tVar.DW();
        }
    }

    public String Nc() {
        return this.mPageType;
    }

    public boolean Nd() {
        return this.baI;
    }

    public int getType() {
        return this.mType;
    }

    public o MR() {
        return this.aTL;
    }

    public e.a Ne() {
        return this.aZQ;
    }

    private void MS() {
        this.aMb = System.currentTimeMillis();
        this.aZO.CS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(m mVar) {
        this.baG.aUj.b(mVar);
        this.aTL.d(mVar);
        this.aZN = new ArrayList<>();
        if (this.aTL.getThreadList() != null) {
            this.aZN.addAll(this.aTL.getThreadList());
        }
        if (this.aTL.avo().avE() == 1) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        if (this.baI) {
            this.mPageType = "good_page";
        }
    }

    /* renamed from: com.baidu.tieba.frs.mc.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0055a extends BdAsyncTask<Object, m, Void> {
        private a baT;
        private String mName;
        private boolean needCache;

        public C0055a(a aVar, boolean z, String str) {
            this.mName = null;
            this.mName = str;
            this.baT = aVar;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            if (this.needCache && d.avn().ln(this.mName)) {
                if (!d.avn().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.mName)) {
                    d.avn().getResponseData().aeN().getSignData().setIsSigned(0);
                }
                publishProgress(d.avn().getResponseData());
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
            this.baT.c(mVarArr.length > 0 ? mVarArr[0] : null);
        }
    }

    public long Ix() {
        return this.aMe;
    }

    public long Iy() {
        return this.aMc;
    }

    public long Iz() {
        return this.aMd;
    }

    public long IA() {
        return this.aMb;
    }

    public boolean isLoading() {
        return this.aZO.isLoading();
    }

    private void Nf() {
        if (this.baR == null) {
            this.baR = new ArrayList<>();
        }
        if (this.baR.size() == 0) {
            this.baR.add(new dk());
        }
    }

    @Override // com.baidu.tieba.frs.ea
    public void a(int i, int i2, ec ecVar) {
        if (ecVar == null && (ecVar = X(i, i2)) == null) {
            if (i != 1 && k.jd() && this.baQ != null) {
                ee eeVar = new ee();
                eeVar.hasMore = false;
                eeVar.pn = 1;
                eeVar.forumName = this.aTB;
                eeVar.aYQ = false;
                if (this.aTL != null && this.aTL.aeN() != null) {
                    eeVar.forumId = this.aTL.aeN().getId();
                }
                Nf();
                this.aTL.af(this.baR);
                this.baQ.a(i, i2, eeVar, this.baR);
            }
            ecVar = new ec();
            ecVar.pn = -1;
        }
        if (this.aTL != null && this.aTL.aeN() != null) {
            ecVar.forumId = this.aTL.aeN().getId();
        }
        ecVar.forumName = this.aTB;
        this.aZS = i;
        this.baK = i2;
        this.baL = ecVar;
        b(i, i2, ecVar);
        fM(5);
    }

    @Override // com.baidu.tieba.frs.ea
    public void a(eb ebVar) {
        this.baQ = ebVar;
        this.baO.a(this.baP);
    }

    private void fM(int i) {
        switch (i) {
            case 1:
            case 4:
                if (this.baL != null) {
                    this.baL.pn++;
                    break;
                }
                break;
            case 2:
                if (this.baL != null) {
                    ec ecVar = this.baL;
                    ecVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.baL != null) {
                    this.baL.pn = -1;
                    break;
                }
                break;
        }
        if (this.aZS == 1) {
            ArrayList<u> arrayList = new ArrayList<>();
            if (this.aZN != null) {
                arrayList.addAll(this.aZN);
            }
            this.aTL.af(arrayList);
            if (this.baQ != null) {
                this.baQ.a(this.aZS, this.baK, null, arrayList);
                return;
            }
            return;
        }
        ea fG = this.baO.fG(this.aZS);
        if (fG != null) {
            this.baM = true;
            fG.a(this.aZS, this.baK, this.baL);
            return;
        }
        if (this.aTL != null && this.aTL.getThreadList() != null) {
            this.aTL.getThreadList().clear();
        }
        this.baQ.a(this.aZS, this.baK, null, null);
    }

    public boolean hasMore() {
        if ((this.baL instanceof ee) && ((ee) this.baL).errCode == 0) {
            return ((ee) this.baL).hasMore;
        }
        return true;
    }

    private int W(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ec ecVar) {
        this.baN.put(W(i, i2), ecVar);
    }

    public ec X(int i, int i2) {
        return this.baN.get(W(i, i2));
    }

    @Override // com.baidu.tieba.frs.ea
    public void init() {
        this.baO.init();
    }

    @Override // com.baidu.tieba.frs.ea
    public void Ku() {
        this.baO.destory();
        this.baO.clear();
    }

    public int Ng() {
        return this.aZS;
    }

    public int Nh() {
        return this.baK;
    }

    public ec Ni() {
        return this.baL;
    }

    public void a(com.baidu.tbadk.core.data.l lVar) {
        if (lVar != null && !StringUtils.isNull(lVar.getId()) && this.aZN != null) {
            if (this.aZS == 1) {
                this.aTL.a(lVar);
            }
            int Nj = Nj();
            if (this.aZN != null && this.aZN.size() > 0) {
                int size = this.aZN.size();
                for (int i = 0; i < size; i++) {
                    u uVar = this.aZN.get(i);
                    if ((uVar instanceof v) && lVar.getId().equals(((v) uVar).getId())) {
                        return;
                    }
                }
            }
            if (lVar.sq() == 33) {
                s sVar = new s();
                sVar.a(lVar, -1);
                sVar.setPost_num(1);
                if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.aZN.add(Nj, sVar);
                    return;
                }
                return;
            }
            this.aZN.add(Nj, lVar);
        }
    }

    public int Nj() {
        if (this.aZN == null || this.aZN.size() <= 0) {
            return 0;
        }
        Iterator<u> it = this.aZN.iterator();
        int i = 0;
        while (it.hasNext()) {
            u next = it.next();
            if (next instanceof v) {
                if (((v) next).getIs_top() != 0) {
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

    public boolean Nk() {
        return this.baM;
    }
}
