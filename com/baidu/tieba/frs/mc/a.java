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
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.dk;
import com.baidu.tieba.frs.dn;
import com.baidu.tieba.frs.dp;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.frs.ee;
import com.baidu.tieba.frs.eg;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> implements NetModel.b<l, m>, ec {
    private com.baidu.tieba.tbadkCore.e.a aMt;
    private long aMu;
    private long aMv;
    private long aMw;
    private long aMx;
    private String aTU;
    private int aTV;
    private o aUe;
    private long awo;
    private ArrayList<u> bas;
    private c<FrsActivity> bat;
    private l bau;
    e.a bav;
    private String baw;
    private boolean bay;
    private boolean baz;
    private FrsActivity bbk;
    private long bbl;
    private boolean bbm;
    private String bbn;
    private int bbo;
    private int bbp;
    private int bbq;
    private ee bbr;
    private boolean bbs;
    private SparseArray<ee> bbt;
    private dp bbu;
    private ed bbv;
    private ed bbw;
    private ArrayList<u> bbx;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.aTU = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.aTV = 0;
        this.bbl = 0L;
        this.bbm = false;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.bbn = null;
        this.baw = null;
        this.bbo = 1;
        this.bbp = 0;
        this.bbq = 0;
        this.bbs = false;
        this.bbt = new SparseArray<>();
        this.bbv = new b(this);
        this.aMt = null;
        this.awo = 0L;
        this.bay = false;
        this.baz = false;
        this.aMu = 0L;
        this.aMv = 0L;
        this.aMw = 0L;
        this.aMx = 0L;
        this.bbk = frsActivity;
        B(frsActivity);
    }

    private void B(FrsActivity frsActivity) {
        this.bbu = new dp();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.bbu));
        this.bbu.a(this.bbv);
    }

    public void onActivityDestroy() {
        if (this.aMt != null) {
            this.aMt.destory();
        }
        this.bat.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.aTU = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aTV = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.bbm = bundle.getBoolean(FrsActivityConfig.GOOD, false);
        }
        if (TextUtils.isEmpty(this.aTU)) {
            this.aTU = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        this.mSource = this.mFrom;
        this.bau = new l();
        this.aUe = new o();
        this.bat = new c<>(this.bbk.getPageContext(), this.bau);
        this.bat.a(this);
        this.bat.setUniqueId(getUniqueId());
        if (this.aTU != null && this.aTU.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.aTU);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.aTV);
        bundle.putBoolean(FrsActivityConfig.GOOD, this.bbm);
    }

    public boolean oS() {
        return bD(true);
    }

    public boolean Hg() {
        if (this.bbo != 1) {
            fV(1);
            return true;
        } else if (this.bat.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.bbk.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.bau), l.class);
            lVar.setPn(lVar.getPn() + 1);
            a(lVar, 1);
            return true;
        }
    }

    public boolean bD(boolean z) {
        if (this.bbo != 1) {
            fV(3);
            return true;
        } else if (this.bat.isLoading()) {
            return false;
        } else {
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.bau), l.class);
            lVar.setPn(1);
            a(lVar, 3);
            return true;
        }
    }

    public void fT(int i) {
        if (this.bbo != 1) {
            fV(4);
        } else if (!this.bat.isLoading()) {
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.bau), l.class);
            lVar.setPn(i);
            a(lVar, 4);
        }
    }

    public boolean No() {
        if (this.bat.isLoading()) {
            return false;
        }
        this.bbm = false;
        this.mPn = 1;
        return bD(true);
    }

    public boolean fU(int i) {
        if (this.bat.isLoading()) {
            return false;
        }
        this.bbm = true;
        this.bbl = i;
        this.mPn = 1;
        return bD(true);
    }

    public boolean au(String str, String str2) {
        if (this.bat.isLoading() || str2 == null) {
            return false;
        }
        this.mSource = "sidebar";
        this.bbn = str;
        this.bbm = false;
        this.aTU = str2;
        return bD(true);
    }

    private void a(l lVar, int i) {
        boolean z = true;
        this.bbk.aUC.fB(i);
        this.bat.a(lVar);
        this.mType = i;
        lVar.setKw(this.aTU);
        if (com.baidu.tbadk.core.m.qV().qZ()) {
            lVar.setRn(35);
        } else {
            lVar.setRn(50);
        }
        lVar.setWithGroup(1);
        if (this.bbm) {
            lVar.setIsGood(1);
            lVar.setCid((int) this.bbl);
        } else {
            lVar.setIsGood(0);
            lVar.setCid(0);
        }
        int K = k.K(this.bbk.getPageContext().getPageActivity());
        int L = k.L(this.bbk.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = at.uK().uM() ? 2 : 1;
        lVar.setScrW(K);
        lVar.setScrH(L);
        lVar.setScrDip(f);
        lVar.setqType(i2);
        lVar.setLastId(this.baw);
        if (this.mSource != null) {
            lVar.setStType(this.mSource);
            if (this.mSource.equalsIgnoreCase("sidebar")) {
                lVar.setStType(this.bbn);
            }
        }
        if (FrsActivity.aUj != 0) {
            lVar.setCtime((int) FrsActivity.aUj);
        }
        if (FrsActivity.aUk != 0) {
            lVar.setDataSize((int) FrsActivity.aUk);
        }
        if (FrsActivity.aUl != 0) {
            lVar.setNetError(FrsActivity.aUl);
        }
        if (lVar.getPn() != 1 || ((!this.mPageType.equals("normal_page") && !this.mPageType.equals("frs_page")) || this.mType != 3 || this.bbm)) {
            z = false;
        }
        lVar.setUpdateType(this.mType);
        lVar.setNeedCache(z);
        if (!z) {
            Ng();
        } else {
            Ng();
            new C0055a(this, z, d.avW().ad(this.aTU, this.bau.getCategoryId())).execute(new Object[0]);
        }
        if (this.aMt == null) {
            this.aMt = new com.baidu.tieba.tbadkCore.e.a("frsStat");
            this.aMt.start();
        }
    }

    protected boolean a(l lVar, m mVar) {
        if (this.bbo == 1) {
            this.aUe.d(mVar);
            this.bas = new ArrayList<>();
            if (this.aUe.avX().awo() == 1) {
                this.mPageType = "frs_page";
            } else {
                this.mPageType = "normal_page";
            }
            if (this.bbm) {
                this.mPageType = "good_page";
            }
            if (lVar != null) {
                this.bau = lVar;
                this.mPn = this.bau.getPn();
                this.aTU = this.bau.getKw();
                this.bbk.gP(this.aTU);
                this.bbk.setFrom(this.mFrom);
                this.bbk.setPn(this.mPn);
                this.bbk.setFlag(this.aTV);
            }
            this.bbk.aUC.a(this.mType, false, this.bav);
            if (this.aUe.getThreadList() != null) {
                this.bas.addAll(this.aUe.getThreadList());
            }
            this.mSource = null;
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        e.a aVar = new e.a();
        aVar.cYp = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.cYq = mvcSocketResponsedMessage.getDownSize();
        this.bav = aVar;
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
        this.bbk.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        l lVar;
        l lVar2;
        Ne();
        if (this.aMt != null) {
            this.aMt.a(false, this.bav.isSuccess, this.bav.errorCode, this.bav.errorMsg, this.bav.cYq);
            this.aMt = null;
        }
        if (!this.baz) {
            this.baz = true;
            t tVar = new t();
            tVar.ex(1000);
            tVar.awt = false;
            tVar.isSuccess = this.bav.isSuccess;
            tVar.awi = mvcSocketResponsedMessage.performanceData.qw;
            tVar.awj = mvcSocketResponsedMessage.performanceData.qx;
            tVar.awk = mvcSocketResponsedMessage.performanceData.qy;
            tVar.awl = mvcSocketResponsedMessage.performanceData.qz;
            tVar.awm = mvcSocketResponsedMessage.performanceData.qA;
            tVar.awr = this.bav.cYq;
            tVar.aws = 0L;
            if (this.bbk.aUC != null) {
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
        aVar.cYp = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.cYq = mvcHttpResponsedMessage.getDownSize();
        this.bav = aVar;
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
        this.bbk.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    private void b(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        l lVar;
        l lVar2;
        Ne();
        if (this.aMt != null) {
            this.aMt.a(true, this.bav.isSuccess, this.bav.errorCode, this.bav.errorMsg, this.bav.cYq);
            this.aMt = null;
        }
        if (!this.baz) {
            this.baz = true;
            t tVar = new t();
            tVar.ex(1000);
            tVar.awt = true;
            tVar.isSuccess = this.bav.isSuccess;
            tVar.awi = mvcHttpResponsedMessage.performanceData.qw;
            tVar.awj = mvcHttpResponsedMessage.performanceData.qx;
            tVar.awk = mvcHttpResponsedMessage.performanceData.qy;
            tVar.awl = mvcHttpResponsedMessage.performanceData.qz;
            tVar.awm = mvcHttpResponsedMessage.performanceData.qA;
            tVar.awr = 0L;
            tVar.aws = this.bav.cYq;
            if (this.bbk.aUC != null) {
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

    public void Np() {
        if (this.aUe != null && this.aUe.afg() != null && this.aUe.afg().getBannerListData() != null) {
            String lastIds = this.aUe.afg().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.baw = lastIds;
            }
        }
    }

    public void Ne() {
        if (!this.bay) {
            this.bay = true;
            this.awo = System.currentTimeMillis() - this.bbk.aUi;
            t tVar = new t();
            tVar.ex(1000);
            tVar.awh = this.bbk.createTime;
            tVar.awo = this.awo;
            tVar.DL();
        }
    }

    public void e(t tVar) {
        if (tVar != null) {
            tVar.awh = this.bbk.createTime;
            this.bbk.createTime = 0L;
            tVar.awn = this.bbk.awn;
            tVar.awo = this.awo == 0 ? System.currentTimeMillis() - this.bbk.aUi : this.awo;
            tVar.DM();
        }
    }

    public String Nq() {
        return this.mPageType;
    }

    public boolean Nr() {
        return this.bbm;
    }

    public int getType() {
        return this.mType;
    }

    public o Nf() {
        return this.aUe;
    }

    public e.a Ns() {
        return this.bav;
    }

    private void Ng() {
        this.aMu = System.currentTimeMillis();
        this.bat.CI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(m mVar) {
        this.bbk.aUC.b(mVar);
        this.aUe.d(mVar);
        this.bas = new ArrayList<>();
        if (this.aUe.getThreadList() != null) {
            this.bas.addAll(this.aUe.getThreadList());
        }
        if (this.aUe.avX().awo() == 1) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        if (this.bbm) {
            this.mPageType = "good_page";
        }
    }

    /* renamed from: com.baidu.tieba.frs.mc.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0055a extends BdAsyncTask<Object, m, Void> {
        private a bbA;
        private String bbz;
        private boolean needCache;

        public C0055a(a aVar, boolean z, String str) {
            this.bbz = null;
            this.bbz = str;
            this.bbA = aVar;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            if (this.needCache && d.avW().lu(this.bbz)) {
                if (!d.avW().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.bbz)) {
                    d.avW().getResponseData().afg().getSignData().setIsSigned(0);
                }
                publishProgress(d.avW().getResponseData());
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
            this.bbA.c(mVarArr.length > 0 ? mVarArr[0] : null);
        }
    }

    public long IJ() {
        return this.aMx;
    }

    public long IK() {
        return this.aMv;
    }

    public long IL() {
        return this.aMw;
    }

    public long IM() {
        return this.aMu;
    }

    public boolean isLoading() {
        return this.bat.isLoading();
    }

    public int Nt() {
        return this.bbq;
    }

    private void Nu() {
        if (this.bbx == null) {
            this.bbx = new ArrayList<>();
        }
        if (this.bbx.size() == 0) {
            this.bbx.add(new dk());
        }
    }

    @Override // com.baidu.tieba.frs.ec
    public void a(int i, int i2, ee eeVar) {
        if (eeVar == null && (eeVar = Z(i, i2)) == null) {
            if (i != 1 && k.je() && this.bbw != null) {
                eg egVar = new eg();
                egVar.hasMore = false;
                egVar.pn = 1;
                egVar.forumName = this.aTU;
                egVar.aZn = false;
                if (this.aUe != null && this.aUe.afg() != null) {
                    egVar.forumId = this.aUe.afg().getId();
                }
                Nu();
                this.aUe.af(this.bbx);
                this.bbw.a(i, i2, egVar, this.bbx);
            }
            eeVar = new ee();
            eeVar.pn = -1;
        }
        if (this.aUe != null && this.aUe.afg() != null) {
            eeVar.forumId = this.aUe.afg().getId();
        }
        eeVar.forumName = this.aTU;
        if (dn.MH().fN(1) != null && i == 1) {
            this.bau.setCategoryId(i2);
        }
        this.bbo = i;
        this.bbp = i2;
        this.bbr = eeVar;
        b(i, i2, eeVar);
        fV(5);
    }

    @Override // com.baidu.tieba.frs.ec
    public void a(ed edVar) {
        this.bbw = edVar;
        this.bbu.a(this.bbv);
    }

    private void fV(int i) {
        switch (i) {
            case 1:
            case 4:
                if (this.bbr != null) {
                    this.bbr.pn++;
                    break;
                }
                break;
            case 2:
                if (this.bbr != null) {
                    ee eeVar = this.bbr;
                    eeVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.bbr != null) {
                    this.bbr.pn = -1;
                    break;
                }
                break;
        }
        if (this.bbo == 1) {
            if (this.bbq == this.bbp) {
                ArrayList<u> arrayList = new ArrayList<>();
                if (this.bas != null) {
                    arrayList.addAll(this.bas);
                }
                this.aUe.af(arrayList);
                if (this.bbw != null) {
                    this.bbw.a(this.bbo, this.bbp, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.bbq = this.bbp;
            return;
        }
        ec fO = this.bbu.fO(this.bbo);
        if (fO != null) {
            this.bbs = true;
            fO.a(this.bbo, this.bbp, this.bbr);
            return;
        }
        if (this.aUe != null && this.aUe.getThreadList() != null) {
            this.aUe.getThreadList().clear();
        }
        this.bbw.a(this.bbo, this.bbp, null, null);
    }

    public boolean hasMore() {
        if ((this.bbr instanceof eg) && ((eg) this.bbr).errCode == 0) {
            return ((eg) this.bbr).hasMore;
        }
        return true;
    }

    private int Y(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ee eeVar) {
        this.bbt.put(Y(i, i2), eeVar);
    }

    public ee Z(int i, int i2) {
        return this.bbt.get(Y(i, i2));
    }

    @Override // com.baidu.tieba.frs.ec
    public void init() {
        this.bbu.init();
    }

    @Override // com.baidu.tieba.frs.ec
    public void KG() {
        this.bbu.destory();
        this.bbu.clear();
    }

    public int Nv() {
        return this.bbo;
    }

    public int Nw() {
        return this.bbp;
    }

    public ee Nx() {
        return this.bbr;
    }

    public void a(com.baidu.tbadk.core.data.m mVar) {
        if (mVar != null && !StringUtils.isNull(mVar.getId()) && this.bas != null) {
            if (this.bbo == 1) {
                this.aUe.a(mVar);
            }
            int Ny = Ny();
            if (this.bas != null && this.bas.size() > 0) {
                int size = this.bas.size();
                for (int i = 0; i < size; i++) {
                    u uVar = this.bas.get(i);
                    if ((uVar instanceof w) && mVar.getId().equals(((w) uVar).getId())) {
                        return;
                    }
                }
            }
            if (mVar.sq() == 33) {
                com.baidu.tbadk.core.data.t tVar = new com.baidu.tbadk.core.data.t();
                tVar.a(mVar, -1);
                tVar.setPost_num(1);
                if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.bas.add(Ny, tVar);
                    return;
                }
                return;
            }
            this.bas.add(Ny, mVar);
        }
    }

    public int Ny() {
        if (this.bas == null || this.bas.size() <= 0) {
            return 0;
        }
        Iterator<u> it = this.bas.iterator();
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

    public boolean Nz() {
        return this.bbs;
    }

    public void NA() {
        cd cdVar = new cd();
        if (this.aUe.getThreadList() != null) {
            this.aUe.getThreadList().clear();
            this.aUe.getThreadList().add(cdVar);
        }
        if (this.bas != null) {
            this.bas.clear();
            this.bas.add(cdVar);
        }
    }
}
