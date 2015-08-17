package com.baidu.tieba.frs.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.m;
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
import com.baidu.tieba.frs.cp;
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.frs.db;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.de;
import com.baidu.tieba.frs.df;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> implements NetModel.b<k, l>, db {
    private com.baidu.tieba.tbadkCore.e.a aMS;
    private long aMT;
    private long aMU;
    private long aMV;
    private long aMW;
    private String aUq;
    private int aUr;
    private n aUy;
    private ArrayList<u> aZB;
    private c<FrsActivity> aZC;
    private k aZD;
    d.a aZE;
    private String aZF;
    private String aZG;
    private int aZH;
    private boolean aZI;
    private boolean aZJ;
    private long axr;
    private SparseArray<de> baA;
    private ct baB;
    private dc baC;
    private dc baD;
    private ArrayList<u> baE;
    private FrsActivity bat;
    private long bau;
    private boolean bav;
    private String baw;
    private int bax;
    private de bay;
    private boolean baz;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private int mType;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.aUq = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.aUr = 0;
        this.bau = 0L;
        this.bav = false;
        this.mPageType = "normal_page";
        this.aZF = null;
        this.baw = null;
        this.aZG = null;
        this.aZH = 1;
        this.bax = 0;
        this.baz = false;
        this.baA = new SparseArray<>();
        this.baC = new b(this);
        this.aMS = null;
        this.axr = 0L;
        this.aZI = false;
        this.aZJ = false;
        this.aMT = 0L;
        this.aMU = 0L;
        this.aMV = 0L;
        this.aMW = 0L;
        this.bat = frsActivity;
        v(frsActivity);
    }

    private void v(FrsActivity frsActivity) {
        this.baB = new ct();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.baB));
        this.baB.a(this.baC);
    }

    public void onActivityDestroy() {
        if (this.aMS != null) {
            this.aMS.destory();
        }
        this.aZC.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.aUq = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aUr = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.bav = bundle.getBoolean(FrsActivityConfig.GOOD, false);
        }
        if (TextUtils.isEmpty(this.aUq)) {
            this.aUq = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.aZF = this.mFrom;
        this.aZD = new k();
        this.aUy = new n();
        this.aZC = new c<>(this.bat.getPageContext(), this.aZD);
        this.aZC.a(this);
        this.aZC.setUniqueId(getUniqueId());
        if (this.aUq != null && this.aUq.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.aUq);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.aUr);
        bundle.putBoolean(FrsActivityConfig.GOOD, this.bav);
    }

    public boolean oT() {
        return bz(true);
    }

    public boolean HF() {
        if (this.aZH != 1) {
            fy(1);
            return true;
        } else if (this.aZC.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.bat.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            k kVar = (k) k.objectWithJson(k.jsonWithObject(this.aZD), k.class);
            kVar.setPn(kVar.getPn() + 1);
            a(kVar, 1);
            return true;
        }
    }

    public boolean bz(boolean z) {
        if (this.aZH != 1) {
            fy(3);
            return true;
        } else if (this.aZC.isLoading()) {
            return false;
        } else {
            k kVar = (k) k.objectWithJson(k.jsonWithObject(this.aZD), k.class);
            kVar.setPn(1);
            a(kVar, 3);
            return true;
        }
    }

    public void fw(int i) {
        if (this.aZH != 1) {
            fy(4);
        } else if (!this.aZC.isLoading()) {
            k kVar = (k) k.objectWithJson(k.jsonWithObject(this.aZD), k.class);
            kVar.setPn(i);
            a(kVar, 4);
        }
    }

    public boolean Na() {
        if (this.aZC.isLoading()) {
            return false;
        }
        this.bav = false;
        this.mPn = 1;
        return bz(true);
    }

    public boolean fx(int i) {
        if (this.aZC.isLoading()) {
            return false;
        }
        this.bav = true;
        this.bau = i;
        this.mPn = 1;
        return bz(true);
    }

    public boolean av(String str, String str2) {
        if (this.aZC.isLoading() || str2 == null) {
            return false;
        }
        this.aZF = "sidebar";
        this.baw = str;
        this.bav = false;
        this.aUq = str2;
        return bz(true);
    }

    private void a(k kVar, int i) {
        boolean z = true;
        this.bat.aUV.fg(i);
        this.aZC.a(kVar);
        this.mType = i;
        kVar.setKw(this.aUq);
        if (m.rd().rh()) {
            kVar.setRn(35);
        } else {
            kVar.setRn(50);
        }
        kVar.setWithGroup(1);
        if (this.bav) {
            kVar.setIsGood(1);
            kVar.setCid((int) this.bau);
        } else {
            kVar.setIsGood(0);
            kVar.setCid(0);
        }
        int K = com.baidu.adp.lib.util.k.K(this.bat.getPageContext().getPageActivity());
        int L = com.baidu.adp.lib.util.k.L(this.bat.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = ar.uE().uG() ? 2 : 1;
        kVar.setScrW(K);
        kVar.setScrH(L);
        kVar.setScrDip(f);
        kVar.setqType(i2);
        kVar.setLastId(this.aZG);
        if (this.aZF != null) {
            kVar.setStType(this.aZF);
            if (this.aZF.equalsIgnoreCase("sidebar")) {
                kVar.setStType(this.baw);
            }
        }
        if (FrsActivity.aUD != 0) {
            kVar.setCtime((int) FrsActivity.aUD);
        }
        if (FrsActivity.aUE != 0) {
            kVar.setDataSize((int) FrsActivity.aUE);
        }
        if (FrsActivity.aUF != 0) {
            kVar.setNetError(FrsActivity.aUF);
        }
        if (kVar.getPn() != 1 || ((!this.mPageType.equals("normal_page") && !this.mPageType.equals("frs_page")) || this.mType != 3 || this.bav)) {
            z = false;
        }
        kVar.setUpdateType(this.mType);
        kVar.setNeedCache(z);
        new C0056a(this, z, this.aUq).execute(new Object[0]);
        if (this.aMS == null) {
            this.aMS = new com.baidu.tieba.tbadkCore.e.a("frsStat");
            this.aMS.start();
        }
    }

    protected boolean a(k kVar, l lVar) {
        if (this.aZH == 1) {
            this.aUy.d(lVar);
            this.aZB = new ArrayList<>();
            if (this.aUy.getThreadList() != null) {
                this.aZB.addAll(this.aUy.getThreadList());
            }
            if (this.aUy.aoR().apd() == 1) {
                this.mPageType = "frs_page";
            } else {
                this.mPageType = "normal_page";
            }
            if (this.bav) {
                this.mPageType = "good_page";
            }
            if (kVar != null) {
                this.aZD = kVar;
                this.mPn = this.aZD.getPn();
                this.aUq = this.aZD.getKw();
                this.bat.gD(this.aUq);
                this.bat.setFrom(this.mFrom);
                this.bat.setPn(this.mPn);
                this.bat.setFlag(this.aUr);
            }
            this.bat.aUV.a(this.mType, false, this.aZE);
            this.aZF = null;
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<l, ?> mvcSocketResponsedMessage, MvcSocketMessage<k, l> mvcSocketMessage, MvcNetMessage<k, l> mvcNetMessage) {
        l lVar;
        d.a aVar = new d.a();
        aVar.cGF = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.cGG = mvcSocketResponsedMessage.getDownSize();
        this.aZE = aVar;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
            lVar = null;
        } else {
            lVar = mvcSocketResponsedMessage.getData();
            r3 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && lVar != null && a(r3, lVar)) {
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
        this.bat.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<l, ?> mvcSocketResponsedMessage, MvcSocketMessage<k, l> mvcSocketMessage, MvcNetMessage<k, l> mvcNetMessage) {
        k kVar;
        k kVar2;
        MR();
        if (this.aMS != null) {
            this.aMS.a(false, this.aZE.isSuccess, this.aZE.errorCode, this.aZE.errorMsg, this.aZE.cGG);
            this.aMS = null;
        }
        if (!this.aZJ) {
            this.aZJ = true;
            t tVar = new t();
            tVar.eq(1000);
            tVar.axw = false;
            tVar.isSuccess = this.aZE.isSuccess;
            tVar.axl = mvcSocketResponsedMessage.performanceData.qy;
            tVar.axm = mvcSocketResponsedMessage.performanceData.qz;
            tVar.axn = mvcSocketResponsedMessage.performanceData.qA;
            tVar.axo = mvcSocketResponsedMessage.performanceData.qB;
            tVar.axp = mvcSocketResponsedMessage.performanceData.qC;
            tVar.axu = this.aZE.cGG;
            tVar.axv = 0L;
            if (this.bat.aUV != null) {
                e(tVar);
            }
        }
        long j = 0;
        if (mvcSocketMessage == null) {
            kVar = null;
        } else {
            j = mvcSocketMessage.getClientLogID();
            kVar = mvcSocketMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            kVar2 = mvcNetMessage.getRequestData();
        } else {
            kVar2 = kVar;
        }
        int error = mvcSocketResponsedMessage.getError();
        String errorString = mvcSocketResponsedMessage.getErrorString();
        int cmd = mvcSocketResponsedMessage.getCmd();
        Object[] objArr = new Object[2];
        objArr[0] = "kw";
        objArr[1] = kVar2 != null ? kVar2.getKw() : null;
        com.baidu.tbadk.core.log.b.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<l> mvcHttpResponsedMessage, MvcHttpMessage<k, l> mvcHttpMessage, MvcNetMessage<k, l> mvcNetMessage) {
        l lVar;
        d.a aVar = new d.a();
        aVar.cGF = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.cGG = mvcHttpResponsedMessage.getDownSize();
        this.aZE = aVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            lVar = null;
        } else {
            lVar = mvcHttpResponsedMessage.getData();
            r3 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && lVar != null && a(r3, lVar)) {
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
        this.bat.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    private void b(MvcHttpResponsedMessage<l> mvcHttpResponsedMessage, MvcHttpMessage<k, l> mvcHttpMessage, MvcNetMessage<k, l> mvcNetMessage) {
        k kVar;
        k kVar2;
        MR();
        if (this.aMS != null) {
            this.aMS.a(true, this.aZE.isSuccess, this.aZE.errorCode, this.aZE.errorMsg, this.aZE.cGG);
            this.aMS = null;
        }
        if (!this.aZJ) {
            this.aZJ = true;
            t tVar = new t();
            tVar.eq(1000);
            tVar.axw = true;
            tVar.isSuccess = this.aZE.isSuccess;
            tVar.axl = mvcHttpResponsedMessage.performanceData.qy;
            tVar.axm = mvcHttpResponsedMessage.performanceData.qz;
            tVar.axn = mvcHttpResponsedMessage.performanceData.qA;
            tVar.axo = mvcHttpResponsedMessage.performanceData.qB;
            tVar.axp = mvcHttpResponsedMessage.performanceData.qC;
            tVar.axu = 0L;
            tVar.axv = this.aZE.cGG;
            if (this.bat.aUV != null) {
                e(tVar);
            }
        }
        long j = 0;
        if (mvcHttpMessage == null) {
            kVar = null;
        } else {
            j = mvcHttpMessage.getClientLogID();
            kVar = mvcHttpMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            kVar2 = mvcNetMessage.getRequestData();
        } else {
            kVar2 = kVar;
        }
        int error = mvcHttpResponsedMessage.getError();
        String errorString = mvcHttpResponsedMessage.getErrorString();
        int cmd = mvcHttpResponsedMessage.getCmd();
        Object[] objArr = new Object[2];
        objArr[0] = "kw";
        objArr[1] = kVar2 != null ? kVar2.getKw() : null;
        com.baidu.tbadk.core.log.b.a("frs", j, cmd, "http_resp", error, errorString, objArr);
    }

    public void Nb() {
        if (this.aUy != null && this.aUy.acG() != null && this.aUy.acG().getBannerListData() != null) {
            String lastIds = this.aUy.acG().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.aZG = lastIds;
            }
        }
    }

    public void MR() {
        if (!this.aZI) {
            this.aZI = true;
            this.axr = System.currentTimeMillis() - this.bat.aUC;
            t tVar = new t();
            tVar.eq(1000);
            tVar.axk = this.bat.createTime;
            tVar.axr = this.axr;
            tVar.DY();
        }
    }

    public void e(t tVar) {
        if (tVar != null) {
            tVar.axk = this.bat.createTime;
            this.bat.createTime = 0L;
            tVar.axq = this.bat.axq;
            tVar.axr = this.axr == 0 ? System.currentTimeMillis() - this.bat.aUC : this.axr;
            tVar.DZ();
        }
    }

    public String Nc() {
        return this.mPageType;
    }

    public boolean Nd() {
        return this.bav;
    }

    public int getType() {
        return this.mType;
    }

    public n MS() {
        return this.aUy;
    }

    public d.a Ne() {
        return this.aZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MT() {
        this.aMT = System.currentTimeMillis();
        this.aZC.CV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(l lVar) {
        this.bat.aUV.b(lVar);
        this.aUy.d(lVar);
        this.aZB = new ArrayList<>();
        if (this.aUy.getThreadList() != null) {
            this.aZB.addAll(this.aUy.getThreadList());
        }
        if (this.aUy.aoR().apd() == 1) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        if (this.bav) {
            this.mPageType = "good_page";
        }
    }

    /* renamed from: com.baidu.tieba.frs.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0056a extends BdAsyncTask<Object, l, Void> {
        private a baG;
        private String mName;
        private boolean needCache;

        public C0056a(a aVar, boolean z, String str) {
            this.mName = null;
            this.mName = str;
            this.baG = aVar;
            this.needCache = z;
            setSelfExecute(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            if (this.needCache && com.baidu.tieba.tbadkCore.c.aoQ().kk(this.mName)) {
                if (!com.baidu.tieba.tbadkCore.c.aoQ().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.mName)) {
                    com.baidu.tieba.tbadkCore.c.aoQ().getResponseData().acG().getSignData().setIsSigned(0);
                }
                publishProgress(com.baidu.tieba.tbadkCore.c.aoQ().getResponseData());
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(l... lVarArr) {
            super.onProgressUpdate(lVarArr);
            this.baG.c(lVarArr.length > 0 ? lVarArr[0] : null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r2) {
            super.onPostExecute(r2);
            this.baG.MT();
        }
    }

    public long IN() {
        return this.aMW;
    }

    public long IO() {
        return this.aMU;
    }

    public long IP() {
        return this.aMV;
    }

    public long IQ() {
        return this.aMT;
    }

    public boolean isLoading() {
        return this.aZC.isLoading();
    }

    private void Nf() {
        if (this.baE == null) {
            this.baE = new ArrayList<>();
        }
        if (this.baE.size() == 0) {
            this.baE.add(new cp());
        }
    }

    @Override // com.baidu.tieba.frs.db
    public void a(int i, int i2, de deVar) {
        if (deVar == null && (deVar = X(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.k.jf() && this.baD != null) {
                df dfVar = new df();
                dfVar.hasMore = false;
                dfVar.pn = 1;
                dfVar.forumName = this.aUq;
                dfVar.aYJ = false;
                if (this.aUy != null && this.aUy.acG() != null) {
                    dfVar.forumId = this.aUy.acG().getId();
                }
                Nf();
                this.aUy.X(this.baE);
                this.baD.a(i, i2, dfVar, this.baE);
            }
            deVar = new de();
            deVar.pn = -1;
        }
        if (this.aUy != null && this.aUy.acG() != null) {
            deVar.forumId = this.aUy.acG().getId();
        }
        deVar.forumName = this.aUq;
        this.aZH = i;
        this.bax = i2;
        this.bay = deVar;
        b(i, i2, deVar);
        fy(5);
    }

    @Override // com.baidu.tieba.frs.db
    public void a(dc dcVar) {
        this.baD = dcVar;
        this.baB.a(this.baC);
    }

    private void fy(int i) {
        switch (i) {
            case 1:
            case 4:
                if (this.bay != null) {
                    this.bay.pn++;
                    break;
                }
                break;
            case 2:
                if (this.bay != null) {
                    de deVar = this.bay;
                    deVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.bay != null) {
                    this.bay.pn = -1;
                    break;
                }
                break;
        }
        if (this.aZH == 1) {
            ArrayList<u> arrayList = new ArrayList<>();
            if (this.aZB != null) {
                arrayList.addAll(this.aZB);
            }
            this.aUy.X(arrayList);
            if (this.baD != null) {
                this.baD.a(this.aZH, this.bax, null, arrayList);
                return;
            }
            return;
        }
        db ft = this.baB.ft(this.aZH);
        if (ft != null) {
            this.baz = true;
            ft.a(this.aZH, this.bax, this.bay);
            return;
        }
        if (this.aUy != null && this.aUy.getThreadList() != null) {
            this.aUy.getThreadList().clear();
        }
        this.baD.a(this.aZH, this.bax, null, null);
    }

    public boolean hasMore() {
        if (this.bay == null || !(this.bay instanceof df)) {
            return true;
        }
        return ((df) this.bay).hasMore;
    }

    private int W(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, de deVar) {
        this.baA.put(W(i, i2), deVar);
    }

    public de X(int i, int i2) {
        return this.baA.get(W(i, i2));
    }

    @Override // com.baidu.tieba.frs.db
    public void init() {
        this.baB.init();
    }

    @Override // com.baidu.tieba.frs.db
    public void KL() {
        this.baB.destory();
        this.baB.clear();
    }

    public int Ng() {
        return this.aZH;
    }

    public int Nh() {
        return this.bax;
    }

    public de Ni() {
        return this.bay;
    }

    public void a(com.baidu.tbadk.core.data.n nVar) {
        if (nVar != null && !StringUtils.isNull(nVar.getId()) && this.aZB != null) {
            if (this.aZH == 1) {
                this.aUy.a(nVar);
            }
            int Nj = Nj();
            if (this.aZB != null && this.aZB.size() > 0) {
                int size = this.aZB.size();
                for (int i = 0; i < size; i++) {
                    u uVar = this.aZB.get(i);
                    if (uVar instanceof com.baidu.tbadk.core.data.l) {
                        Nj++;
                    }
                    if ((uVar instanceof v) && nVar.getId().equals(((v) uVar).getId())) {
                        return;
                    }
                }
            }
            this.aZB.add(Nj, nVar);
        }
    }

    public int Nj() {
        if (this.aZB == null || this.aZB.size() <= 0) {
            return 0;
        }
        Iterator<u> it = this.aZB.iterator();
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
        return this.baz;
    }
}
