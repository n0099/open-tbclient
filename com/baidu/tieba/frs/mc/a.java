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
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
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
    private com.baidu.tieba.tbadkCore.e.a aMl;
    private long aMm;
    private long aMn;
    private long aMo;
    private long aMp;
    private String aTM;
    private int aTN;
    private o aTW;
    private ArrayList<u> aZY;
    private c<FrsActivity> aZZ;
    private long axz;
    private FrsActivity baR;
    private long baS;
    private boolean baT;
    private String baU;
    private int baV;
    private ec baW;
    private boolean baX;
    private SparseArray<ec> baY;
    private dn baZ;
    private l baa;
    e.a bab;
    private String bac;
    private int bad;
    private boolean bae;
    private boolean baf;
    private eb bba;
    private eb bbb;
    private ArrayList<u> bbc;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.aTM = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.aTN = 0;
        this.baS = 0L;
        this.baT = false;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.baU = null;
        this.bac = null;
        this.bad = 1;
        this.baV = 0;
        this.baX = false;
        this.baY = new SparseArray<>();
        this.bba = new b(this);
        this.aMl = null;
        this.axz = 0L;
        this.bae = false;
        this.baf = false;
        this.aMm = 0L;
        this.aMn = 0L;
        this.aMo = 0L;
        this.aMp = 0L;
        this.baR = frsActivity;
        B(frsActivity);
    }

    private void B(FrsActivity frsActivity) {
        this.baZ = new dn();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.baZ));
        this.baZ.a(this.bba);
    }

    public void onActivityDestroy() {
        if (this.aMl != null) {
            this.aMl.destory();
        }
        this.aZZ.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.aTM = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aTN = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.baT = bundle.getBoolean(FrsActivityConfig.GOOD, false);
        }
        if (TextUtils.isEmpty(this.aTM)) {
            this.aTM = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.baa = new l();
        this.aTW = new o();
        this.aZZ = new c<>(this.baR.getPageContext(), this.baa);
        this.aZZ.a(this);
        this.aZZ.setUniqueId(getUniqueId());
        if (this.aTM != null && this.aTM.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.aTM);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.aTN);
        bundle.putBoolean(FrsActivityConfig.GOOD, this.baT);
    }

    public boolean oR() {
        return bB(true);
    }

    public boolean Hj() {
        if (this.bad != 1) {
            fM(1);
            return true;
        } else if (this.aZZ.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.baR.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.baa), l.class);
            lVar.setPn(lVar.getPn() + 1);
            a(lVar, 1);
            return true;
        }
    }

    public boolean bB(boolean z) {
        if (this.bad != 1) {
            fM(3);
            return true;
        } else if (this.aZZ.isLoading()) {
            return false;
        } else {
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.baa), l.class);
            lVar.setPn(1);
            a(lVar, 3);
            return true;
        }
    }

    public void fK(int i) {
        if (this.bad != 1) {
            fM(4);
        } else if (!this.aZZ.isLoading()) {
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.baa), l.class);
            lVar.setPn(i);
            a(lVar, 4);
        }
    }

    public boolean MW() {
        if (this.aZZ.isLoading()) {
            return false;
        }
        this.baT = false;
        this.mPn = 1;
        return bB(true);
    }

    public boolean fL(int i) {
        if (this.aZZ.isLoading()) {
            return false;
        }
        this.baT = true;
        this.baS = i;
        this.mPn = 1;
        return bB(true);
    }

    public boolean av(String str, String str2) {
        if (this.aZZ.isLoading() || str2 == null) {
            return false;
        }
        this.mSource = "sidebar";
        this.baU = str;
        this.baT = false;
        this.aTM = str2;
        return bB(true);
    }

    private void a(l lVar, int i) {
        boolean z = true;
        this.baR.aUu.ft(i);
        this.aZZ.a(lVar);
        this.mType = i;
        lVar.setKw(this.aTM);
        if (com.baidu.tbadk.core.m.qU().qY()) {
            lVar.setRn(35);
        } else {
            lVar.setRn(50);
        }
        lVar.setWithGroup(1);
        if (this.baT) {
            lVar.setIsGood(1);
            lVar.setCid((int) this.baS);
        } else {
            lVar.setIsGood(0);
            lVar.setCid(0);
        }
        int K = k.K(this.baR.getPageContext().getPageActivity());
        int L = k.L(this.baR.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = at.uG().uI() ? 2 : 1;
        lVar.setScrW(K);
        lVar.setScrH(L);
        lVar.setScrDip(f);
        lVar.setqType(i2);
        lVar.setLastId(this.bac);
        if (this.mSource != null) {
            lVar.setStType(this.mSource);
            if (this.mSource.equalsIgnoreCase("sidebar")) {
                lVar.setStType(this.baU);
            }
        }
        if (FrsActivity.aUb != 0) {
            lVar.setCtime((int) FrsActivity.aUb);
        }
        if (FrsActivity.aUc != 0) {
            lVar.setDataSize((int) FrsActivity.aUc);
        }
        if (FrsActivity.aUd != 0) {
            lVar.setNetError(FrsActivity.aUd);
        }
        if (lVar.getPn() != 1 || ((!this.mPageType.equals("normal_page") && !this.mPageType.equals("frs_page")) || this.mType != 3 || this.baT)) {
            z = false;
        }
        lVar.setUpdateType(this.mType);
        lVar.setNeedCache(z);
        if (!z) {
            MO();
        } else {
            MO();
            new C0055a(this, z, this.aTM).execute(new Object[0]);
        }
        if (this.aMl == null) {
            this.aMl = new com.baidu.tieba.tbadkCore.e.a("frsStat");
            this.aMl.start();
        }
    }

    protected boolean a(l lVar, m mVar) {
        if (this.bad == 1) {
            this.aTW.d(mVar);
            this.aZY = new ArrayList<>();
            if (this.aTW.getThreadList() != null) {
                this.aZY.addAll(this.aTW.getThreadList());
            }
            if (this.aTW.avq().avG() == 1) {
                this.mPageType = "frs_page";
            } else {
                this.mPageType = "normal_page";
            }
            if (this.baT) {
                this.mPageType = "good_page";
            }
            if (lVar != null) {
                this.baa = lVar;
                this.mPn = this.baa.getPn();
                this.aTM = this.baa.getKw();
                this.baR.gN(this.aTM);
                this.baR.setFrom(this.mFrom);
                this.baR.setPn(this.mPn);
                this.baR.setFlag(this.aTN);
            }
            this.baR.aUu.a(this.mType, false, this.bab);
            this.mSource = null;
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        e.a aVar = new e.a();
        aVar.cWT = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.cWU = mvcSocketResponsedMessage.getDownSize();
        this.bab = aVar;
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
        this.baR.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        l lVar;
        l lVar2;
        MM();
        if (this.aMl != null) {
            this.aMl.a(false, this.bab.isSuccess, this.bab.errorCode, this.bab.errorMsg, this.bab.cWU);
            this.aMl = null;
        }
        if (!this.baf) {
            this.baf = true;
            t tVar = new t();
            tVar.ez(1000);
            tVar.axE = false;
            tVar.isSuccess = this.bab.isSuccess;
            tVar.axt = mvcSocketResponsedMessage.performanceData.qw;
            tVar.axu = mvcSocketResponsedMessage.performanceData.qx;
            tVar.axv = mvcSocketResponsedMessage.performanceData.qy;
            tVar.axw = mvcSocketResponsedMessage.performanceData.qz;
            tVar.axx = mvcSocketResponsedMessage.performanceData.qA;
            tVar.axC = this.bab.cWU;
            tVar.axD = 0L;
            if (this.baR.aUu != null) {
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
        aVar.cWT = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.cWU = mvcHttpResponsedMessage.getDownSize();
        this.bab = aVar;
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
        this.baR.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    private void b(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        l lVar;
        l lVar2;
        MM();
        if (this.aMl != null) {
            this.aMl.a(true, this.bab.isSuccess, this.bab.errorCode, this.bab.errorMsg, this.bab.cWU);
            this.aMl = null;
        }
        if (!this.baf) {
            this.baf = true;
            t tVar = new t();
            tVar.ez(1000);
            tVar.axE = true;
            tVar.isSuccess = this.bab.isSuccess;
            tVar.axt = mvcHttpResponsedMessage.performanceData.qw;
            tVar.axu = mvcHttpResponsedMessage.performanceData.qx;
            tVar.axv = mvcHttpResponsedMessage.performanceData.qy;
            tVar.axw = mvcHttpResponsedMessage.performanceData.qz;
            tVar.axx = mvcHttpResponsedMessage.performanceData.qA;
            tVar.axC = 0L;
            tVar.axD = this.bab.cWU;
            if (this.baR.aUu != null) {
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

    public void MX() {
        if (this.aTW != null && this.aTW.aeJ() != null && this.aTW.aeJ().getBannerListData() != null) {
            String lastIds = this.aTW.aeJ().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.bac = lastIds;
            }
        }
    }

    public void MM() {
        if (!this.bae) {
            this.bae = true;
            this.axz = System.currentTimeMillis() - this.baR.aUa;
            t tVar = new t();
            tVar.ez(1000);
            tVar.axs = this.baR.createTime;
            tVar.axz = this.axz;
            tVar.DS();
        }
    }

    public void e(t tVar) {
        if (tVar != null) {
            tVar.axs = this.baR.createTime;
            this.baR.createTime = 0L;
            tVar.axy = this.baR.axy;
            tVar.axz = this.axz == 0 ? System.currentTimeMillis() - this.baR.aUa : this.axz;
            tVar.DT();
        }
    }

    public String MY() {
        return this.mPageType;
    }

    public boolean MZ() {
        return this.baT;
    }

    public int getType() {
        return this.mType;
    }

    public o MN() {
        return this.aTW;
    }

    public e.a Na() {
        return this.bab;
    }

    private void MO() {
        this.aMm = System.currentTimeMillis();
        this.aZZ.CP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(m mVar) {
        this.baR.aUu.b(mVar);
        this.aTW.d(mVar);
        this.aZY = new ArrayList<>();
        if (this.aTW.getThreadList() != null) {
            this.aZY.addAll(this.aTW.getThreadList());
        }
        if (this.aTW.avq().avG() == 1) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        if (this.baT) {
            this.mPageType = "good_page";
        }
    }

    /* renamed from: com.baidu.tieba.frs.mc.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0055a extends BdAsyncTask<Object, m, Void> {
        private a bbe;
        private String mName;
        private boolean needCache;

        public C0055a(a aVar, boolean z, String str) {
            this.mName = null;
            this.mName = str;
            this.bbe = aVar;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            if (this.needCache && d.avp().lq(this.mName)) {
                if (!d.avp().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.mName)) {
                    d.avp().getResponseData().aeJ().getSignData().setIsSigned(0);
                }
                publishProgress(d.avp().getResponseData());
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
            this.bbe.c(mVarArr.length > 0 ? mVarArr[0] : null);
        }
    }

    public long It() {
        return this.aMp;
    }

    public long Iu() {
        return this.aMn;
    }

    public long Iv() {
        return this.aMo;
    }

    public long Iw() {
        return this.aMm;
    }

    public boolean isLoading() {
        return this.aZZ.isLoading();
    }

    private void Nb() {
        if (this.bbc == null) {
            this.bbc = new ArrayList<>();
        }
        if (this.bbc.size() == 0) {
            this.bbc.add(new dk());
        }
    }

    @Override // com.baidu.tieba.frs.ea
    public void a(int i, int i2, ec ecVar) {
        if (ecVar == null && (ecVar = X(i, i2)) == null) {
            if (i != 1 && k.jd() && this.bbb != null) {
                ee eeVar = new ee();
                eeVar.hasMore = false;
                eeVar.pn = 1;
                eeVar.forumName = this.aTM;
                eeVar.aZb = false;
                if (this.aTW != null && this.aTW.aeJ() != null) {
                    eeVar.forumId = this.aTW.aeJ().getId();
                }
                Nb();
                this.aTW.af(this.bbc);
                this.bbb.a(i, i2, eeVar, this.bbc);
            }
            ecVar = new ec();
            ecVar.pn = -1;
        }
        if (this.aTW != null && this.aTW.aeJ() != null) {
            ecVar.forumId = this.aTW.aeJ().getId();
        }
        ecVar.forumName = this.aTM;
        this.bad = i;
        this.baV = i2;
        this.baW = ecVar;
        b(i, i2, ecVar);
        fM(5);
    }

    @Override // com.baidu.tieba.frs.ea
    public void a(eb ebVar) {
        this.bbb = ebVar;
        this.baZ.a(this.bba);
    }

    private void fM(int i) {
        switch (i) {
            case 1:
            case 4:
                if (this.baW != null) {
                    this.baW.pn++;
                    break;
                }
                break;
            case 2:
                if (this.baW != null) {
                    ec ecVar = this.baW;
                    ecVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.baW != null) {
                    this.baW.pn = -1;
                    break;
                }
                break;
        }
        if (this.bad == 1) {
            ArrayList<u> arrayList = new ArrayList<>();
            if (this.aZY != null) {
                arrayList.addAll(this.aZY);
            }
            this.aTW.af(arrayList);
            if (this.bbb != null) {
                this.bbb.a(this.bad, this.baV, null, arrayList);
                return;
            }
            return;
        }
        ea fG = this.baZ.fG(this.bad);
        if (fG != null) {
            this.baX = true;
            fG.a(this.bad, this.baV, this.baW);
            return;
        }
        if (this.aTW != null && this.aTW.getThreadList() != null) {
            this.aTW.getThreadList().clear();
        }
        this.bbb.a(this.bad, this.baV, null, null);
    }

    public boolean hasMore() {
        if ((this.baW instanceof ee) && ((ee) this.baW).errCode == 0) {
            return ((ee) this.baW).hasMore;
        }
        return true;
    }

    private int W(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ec ecVar) {
        this.baY.put(W(i, i2), ecVar);
    }

    public ec X(int i, int i2) {
        return this.baY.get(W(i, i2));
    }

    @Override // com.baidu.tieba.frs.ea
    public void init() {
        this.baZ.init();
    }

    @Override // com.baidu.tieba.frs.ea
    public void Kq() {
        this.baZ.destory();
        this.baZ.clear();
    }

    public int Nc() {
        return this.bad;
    }

    public int Nd() {
        return this.baV;
    }

    public ec Ne() {
        return this.baW;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null && !StringUtils.isNull(mVar.getId()) && this.aZY != null) {
            if (this.bad == 1) {
                this.aTW.a(mVar);
            }
            int Nf = Nf();
            if (this.aZY != null && this.aZY.size() > 0) {
                int size = this.aZY.size();
                for (int i = 0; i < size; i++) {
                    u uVar = this.aZY.get(i);
                    if ((uVar instanceof w) && mVar.getId().equals(((w) uVar).getId())) {
                        return;
                    }
                }
            }
            if (mVar.sn() == 33) {
                com.baidu.tbadk.core.data.t tVar = new com.baidu.tbadk.core.data.t();
                tVar.a(mVar, -1);
                tVar.setPost_num(1);
                if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.aZY.add(Nf, tVar);
                    return;
                }
                return;
            }
            this.aZY.add(Nf, mVar);
        }
    }

    public int Nf() {
        if (this.aZY == null || this.aZY.size() <= 0) {
            return 0;
        }
        Iterator<u> it = this.aZY.iterator();
        int i = 0;
        while (it.hasNext()) {
            u next = it.next();
            if (next instanceof w) {
                if (((w) next).getIs_top() != 0) {
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

    public boolean Ng() {
        return this.baX;
    }
}
