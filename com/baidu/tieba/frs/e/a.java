package com.baidu.tieba.frs.e;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.dd;
import com.baidu.tieba.frs.ek;
import com.baidu.tieba.frs.en;
import com.baidu.tieba.frs.ep;
import com.baidu.tieba.frs.fg;
import com.baidu.tieba.frs.fi;
import com.baidu.tieba.frs.fo;
import com.baidu.tieba.frs.fq;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> implements NetModel.b<l, m>, fg {
    private String Zf;
    private long aXY;
    private long aXZ;
    private long aYa;
    private long aYb;
    private long axF;
    private String bgf;
    private int bgg;
    private o bgq;
    private FrsActivity bpj;
    private ArrayList<v> brc;
    private c<FrsActivity> brd;
    d.a brf;
    private String brg;
    private boolean bri;
    private boolean brj;
    private l bsi;
    private String bsj;
    private int bsk;
    private int bsl;
    private int bsm;
    private fo bsn;
    private boolean bso;
    public boolean bsp;
    public boolean bsq;
    private SparseArray<fo> bsr;
    private ep bss;
    private fi bst;
    private fi bsu;
    private ArrayList<v> bsv;
    private String bsw;
    private int bsx;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bgf = null;
        this.mType = 3;
        this.mPn = 1;
        this.Zf = null;
        this.bgg = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.bsj = null;
        this.brg = null;
        this.bsk = 1;
        this.bsl = 0;
        this.bsm = 0;
        this.bso = false;
        this.bsp = true;
        this.bsq = true;
        this.bsr = new SparseArray<>();
        this.bst = new b(this);
        this.axF = 0L;
        this.bri = false;
        this.brj = false;
        this.bsx = 2;
        this.aXY = 0L;
        this.aXZ = 0L;
        this.aYa = 0L;
        this.aYb = 0L;
        this.bpj = frsActivity;
        M(frsActivity);
    }

    private void M(FrsActivity frsActivity) {
        this.bss = new ep();
        this.bss.aOT = frsActivity.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.bss));
        this.bss.a(this.bst);
    }

    public void onActivityDestroy() {
        this.brd.cancelLoadData();
    }

    public void c(Bundle bundle) {
        if (bundle != null) {
            this.bgf = bundle.getString("name");
            this.Zf = bundle.getString("from");
            this.bgg = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.bsw = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
        }
        if (TextUtils.isEmpty(this.bgf)) {
            this.bgf = "";
        }
        if (TextUtils.isEmpty(this.Zf)) {
            this.Zf = "";
        }
        if (TextUtils.isEmpty(this.bsw)) {
            this.bsw = "";
        }
        this.mSource = this.Zf;
        this.bsi = new l();
        this.bsi.pb(0);
        this.bsi.setIsGood(0);
        this.bgq = new o();
        this.brd = new c<>(this.bpj.getPageContext(), this.bsi);
        this.brd.a(this);
        this.brd.setUniqueId(getUniqueId());
        if (this.bgf != null && this.bgf.length() > 0) {
            if (this.Zf == null || this.Zf.length() <= 0) {
                this.Zf = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.bgf);
        bundle.putString("from", this.Zf);
        bundle.putInt(FrsActivityConfig.FLAG, this.bgg);
    }

    public boolean KO() {
        if (this.bsk != 1) {
            gF(1);
            return true;
        } else if (this.brd.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.bpj.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.bsi), l.class);
            lVar.setPn(lVar.getPn() + 1);
            a(lVar, 1);
            return true;
        }
    }

    public void m(int i, boolean z) {
        if (this.bgq != null && this.bgq.aSt() != null) {
            this.bgq.aSt().clear();
        }
        l lVar = (l) l.objectWithJson(l.jsonWithObject(this.bsi), l.class);
        lVar.setPn(1);
        this.bsk = b(this.bsk, lVar);
        if (this.bsk == 1) {
            if (!this.brd.isLoading()) {
                a(lVar, i);
                return;
            }
            return;
        }
        if (this.bsn == null) {
            this.bsn = new fo();
            this.bsn.pn = 1;
            this.bsn.forumName = this.bgf;
            if (this.bgq != null && this.bgq.avD() != null) {
                this.bsn.forumId = this.bgq.avD().getId();
            }
        }
        gF(i);
    }

    public void gE(int i) {
        if (this.bsk != 1) {
            gF(4);
        } else if (!this.brd.isLoading()) {
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.bsi), l.class);
            lVar.setPn(i);
            a(lVar, 4);
        }
    }

    private void a(l lVar, int i) {
        boolean z = true;
        this.bpj.bgU.gl(i);
        this.brd.a(lVar);
        this.mType = i;
        lVar.setKw(this.bgf);
        if (com.baidu.tbadk.core.l.ob().oh()) {
            lVar.setRn(35);
        } else {
            lVar.setRn(50);
        }
        lVar.setWithGroup(1);
        lVar.setCid(0);
        int B = k.B(this.bpj.getPageContext().getPageActivity());
        int C = k.C(this.bpj.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m11getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = az.ug().ui() ? 2 : 1;
        lVar.setScrW(B);
        lVar.setScrH(C);
        lVar.setScrDip(f);
        lVar.setqType(i2);
        lVar.setLastId(this.brg);
        lVar.setYuelaouLocate(this.bsw);
        if (this.mSource != null) {
            lVar.setStType(this.mSource);
            if (this.mSource.equalsIgnoreCase("sidebar")) {
                lVar.setStType(this.bsj);
            }
        }
        if (FrsActivity.bgv != 0) {
            lVar.setCtime((int) FrsActivity.bgv);
        }
        if (FrsActivity.bgw != 0) {
            lVar.setDataSize((int) FrsActivity.bgw);
        }
        if (FrsActivity.bgx != 0) {
            lVar.setNetError(FrsActivity.bgx);
        }
        if (lVar.getPn() != 1 || ((!this.mPageType.equals("normal_page") && !this.mPageType.equals("frs_page")) || this.mType != 3)) {
            z = false;
        }
        lVar.setUpdateType(this.mType);
        lVar.setNeedCache(z);
        if (!z) {
            Td();
            return;
        }
        Td();
        new C0055a(this, z, com.baidu.tieba.tbadkCore.c.aRZ().d(this.bgf, lVar.aSc(), lVar.getIsGood(), this.bsi.getCategoryId())).execute(new Object[0]);
    }

    protected boolean a(l lVar, m mVar) {
        if (this.bsp) {
            this.bsk = mVar.aSx();
        }
        this.bsp = false;
        this.bgq.d(mVar);
        this.brc = new ArrayList<>();
        if (com.baidu.tieba.frs.h.m.g(this.bgq)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        if (lVar != null) {
            this.bsi = lVar;
            this.mPn = this.bsi.getPn();
            this.bgf = this.bsi.getKw();
            this.bpj.hJ(this.bgf);
            this.bpj.setFrom(this.Zf);
            this.bpj.setPn(this.mPn);
            this.bpj.setFlag(this.bgg);
        }
        if (this.bgq.getThreadList() != null) {
            this.brc.addAll(this.bgq.getThreadList());
        }
        if (this.bsk != 1) {
            this.bpj.bgU.a(7, false, this.brf);
        } else {
            this.bpj.bgU.a(this.mType, false, this.brf);
        }
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        d.a aVar = new d.a();
        aVar.eqd = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.eqe = mvcSocketResponsedMessage.getDownSize();
        this.brf = aVar;
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
        this.bpj.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        l lVar;
        l lVar2 = null;
        if (!this.brj) {
            this.brj = true;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.eL(1000);
            vVar.axK = false;
            vVar.isSuccess = this.brf.isSuccess;
            vVar.axy = mvcSocketResponsedMessage.performanceData.gv;
            vVar.axz = mvcSocketResponsedMessage.performanceData.gw;
            vVar.axA = mvcSocketResponsedMessage.performanceData.gx;
            vVar.eD = mvcSocketResponsedMessage.performanceData.gy;
            vVar.eE = mvcSocketResponsedMessage.performanceData.gz;
            vVar.axB = mvcSocketResponsedMessage.performanceData.gA;
            vVar.axC = mvcSocketResponsedMessage.performanceData.gB;
            vVar.axD = mvcSocketResponsedMessage.performanceData.gC;
            vVar.axD += mvcSocketResponsedMessage.getProcessTime() - mvcSocketResponsedMessage.getStartTime();
            vVar.axI = this.brf.eqe;
            vVar.errCode = this.brf.errorCode;
            vVar.axJ = 0L;
            vVar.sequenceID = mvcSocketResponsedMessage.sequenceID;
            if (this.bpj.bgU != null) {
                d(vVar);
            }
        }
        long j = 0;
        if (mvcSocketMessage != null) {
            j = mvcSocketMessage.getClientLogID();
            lVar2 = mvcSocketMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            lVar = mvcNetMessage.getRequestData();
        } else {
            lVar = lVar2;
        }
        int error = mvcSocketResponsedMessage.getError();
        String errorString = mvcSocketResponsedMessage.getErrorString();
        if (error != 0) {
            int cmd = mvcSocketResponsedMessage.getCmd();
            Object[] objArr = new Object[4];
            objArr[0] = "kw";
            objArr[1] = lVar != null ? lVar.getKw() : null;
            objArr[2] = "seq_id";
            objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
            com.baidu.tbadk.core.log.b.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        d.a aVar = new d.a();
        aVar.eqd = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.eqe = mvcHttpResponsedMessage.getDownSize();
        this.brf = aVar;
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
        this.bpj.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    private void b(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        l lVar;
        l lVar2 = null;
        long j = 0;
        if (mvcHttpMessage != null) {
            j = mvcHttpMessage.getClientLogID();
            lVar2 = mvcHttpMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            lVar = mvcNetMessage.getRequestData();
        } else {
            lVar = lVar2;
        }
        int error = mvcHttpResponsedMessage.getError();
        String errorString = mvcHttpResponsedMessage.getErrorString();
        if (error != 0) {
            int cmd = mvcHttpResponsedMessage.getCmd();
            Object[] objArr = new Object[2];
            objArr[0] = "kw";
            objArr[1] = lVar != null ? lVar.getKw() : null;
            com.baidu.tbadk.core.log.b.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
        if (!this.brj) {
            this.brj = true;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.eL(1000);
            vVar.axK = true;
            vVar.isSuccess = this.brf.isSuccess;
            vVar.axy = mvcHttpResponsedMessage.performanceData.gv;
            vVar.axz = mvcHttpResponsedMessage.performanceData.gw;
            vVar.axA = mvcHttpResponsedMessage.performanceData.gx;
            vVar.eD = mvcHttpResponsedMessage.performanceData.gy;
            vVar.eE = mvcHttpResponsedMessage.performanceData.gz;
            vVar.axB = mvcHttpResponsedMessage.performanceData.gA;
            vVar.axC = mvcHttpResponsedMessage.performanceData.gB;
            vVar.axD = mvcHttpResponsedMessage.performanceData.gC;
            vVar.axD += mvcHttpResponsedMessage.getProcessTime() - mvcHttpResponsedMessage.getStartTime();
            vVar.axL = mvcHttpResponsedMessage.performanceData.gF;
            vVar.axM = mvcHttpResponsedMessage.performanceData.gG;
            vVar.axI = 0L;
            vVar.axJ = this.brf.eqe;
            vVar.socketErrNo = mvcHttpResponsedMessage.performanceData.gD;
            vVar.socketCostTime = mvcHttpResponsedMessage.performanceData.gE;
            vVar.errCode = this.brf.errorCode;
            vVar.axO = j;
            if (this.bpj.bgU != null) {
                d(vVar);
            }
        }
    }

    public void RF() {
        if (this.bgq != null && this.bgq.avD() != null && this.bgq.avD().getBannerListData() != null) {
            String lastIds = this.bgq.avD().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.brg = lastIds;
            }
        }
    }

    public void d(com.baidu.tbadk.performanceLog.v vVar) {
        if (vVar != null) {
            vVar.axw = this.bpj.axw;
            vVar.axx = this.bpj.createTime;
            this.bpj.axw = 0L;
            this.bpj.createTime = 0L;
            vVar.axE = this.bpj.axE;
            vVar.axF = vVar.axF == 0 ? System.currentTimeMillis() - this.bpj.Oe : vVar.axF;
            vVar.EI();
        }
    }

    public String JR() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public o Tc() {
        return this.bgq;
    }

    public d.a Tp() {
        return this.brf;
    }

    private void Td() {
        this.aXY = System.currentTimeMillis();
        this.brd.Dz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(m mVar) {
        this.bpj.bgU.b(mVar);
        this.bsq = false;
        this.bgq.d(mVar);
        this.brc = new ArrayList<>();
        if (this.bgq.getThreadList() != null) {
            this.brc.addAll(this.bgq.getThreadList());
        }
        if (com.baidu.tieba.frs.h.m.g(this.bgq)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    public boolean Tq() {
        return this.bsx == 5;
    }

    /* renamed from: com.baidu.tieba.frs.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0055a extends BdAsyncTask<Object, m, Void> {
        private a bsA;
        private String bsz;
        private boolean needCache;

        public C0055a(a aVar, boolean z, String str) {
            this.bsz = null;
            this.bsz = str;
            this.bsA = aVar;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            if (this.needCache && com.baidu.tieba.tbadkCore.c.aRZ().nG(this.bsz)) {
                if (!com.baidu.tieba.tbadkCore.c.aRZ().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.bsz)) {
                    com.baidu.tieba.tbadkCore.c.aRZ().getResponseData().avD().getSignData().setIsSigned(0);
                }
                publishProgress(com.baidu.tieba.tbadkCore.c.aRZ().getResponseData());
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
            this.bsA.c(mVarArr.length > 0 ? mVarArr[0] : null);
        }
    }

    public long MO() {
        return this.aYb;
    }

    public long MP() {
        return this.aXZ;
    }

    public long MQ() {
        return this.aYa;
    }

    public long MR() {
        return this.aXY;
    }

    public boolean isLoading() {
        return this.brd.isLoading();
    }

    public int Tr() {
        return this.bsm;
    }

    private void Ts() {
        if (this.bsv == null) {
            this.bsv = new ArrayList<>();
        }
        if (this.bsv.size() == 0) {
            this.bsv.add(new ek());
        }
    }

    @Override // com.baidu.tieba.frs.fg
    public void a(int i, int i2, fo foVar) {
        this.bsk = b(i, null);
        if (foVar == null && (foVar = Y(i, i2)) == null) {
            if (i != 1 && k.fH() && this.bsu != null) {
                fq fqVar = new fq();
                fqVar.hasMore = false;
                fqVar.pn = 1;
                fqVar.forumName = this.bgf;
                fqVar.bmV = false;
                if (this.bgq != null && this.bgq.avD() != null) {
                    fqVar.forumId = this.bgq.avD().getId();
                }
                Ts();
                this.bgq.an(this.bsv);
                this.bsu.a(i, i2, fqVar, this.bsv);
            }
            foVar = new fo();
            foVar.pn = -1;
        }
        if (this.bgq != null && this.bgq.avD() != null) {
            foVar.forumId = this.bgq.avD().getId();
        }
        foVar.forumName = this.bgf;
        if (en.RC().gs(1) != null && this.bsk == 1) {
            this.bsi.setCategoryId(i2);
        }
        this.bsl = i2;
        this.bsn = foVar;
        b(i, i2, foVar);
        gF(5);
    }

    @Override // com.baidu.tieba.frs.fg
    public void a(fi fiVar) {
        this.bsu = fiVar;
        this.bss.a(this.bst);
    }

    private void gF(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.bsn != null) {
                    this.bsn.pn++;
                    break;
                }
                break;
            case 2:
                if (this.bsn != null) {
                    fo foVar = this.bsn;
                    foVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.bsn != null) {
                    this.bsn.pn = -1;
                    break;
                }
                break;
        }
        if (this.bsk == 1) {
            if (this.bsm == this.bsl) {
                ArrayList<v> arrayList = new ArrayList<>();
                if (this.brc != null) {
                    arrayList.addAll(this.brc);
                }
                this.bgq.an(arrayList);
                if (this.bsu != null) {
                    this.bsu.a(this.bsk, this.bsl, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.bsm = this.bsl;
            return;
        }
        fg gt = this.bss.gt(this.bsk);
        if (gt != null) {
            this.bso = true;
            gt.a(this.bsk, this.bsl, this.bsn);
            return;
        }
        if (this.bgq != null && this.bgq.getThreadList() != null) {
            this.bgq.getThreadList().clear();
        }
        this.bsu.a(this.bsk, this.bsl, null, null);
    }

    public boolean hasMore() {
        if ((this.bsn instanceof fq) && ((fq) this.bsn).errCode == 0) {
            return ((fq) this.bsn).hasMore;
        }
        return true;
    }

    private int X(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, fo foVar) {
        this.bsr.put(X(i, i2), foVar);
    }

    public fo Y(int i, int i2) {
        return this.bsr.get(X(i, i2));
    }

    @Override // com.baidu.tieba.frs.fg
    public void init() {
        this.bss.init();
    }

    @Override // com.baidu.tieba.frs.fg
    public void Pa() {
        this.bss.destory();
        this.bss.clear();
    }

    public int Tt() {
        return this.bsk;
    }

    public void a(ab abVar) {
        if (abVar != null && !StringUtils.isNull(abVar.getId()) && this.brc != null) {
            if (this.bsk == 1) {
                this.bgq.a(abVar);
            }
            int Tu = Tu();
            if (this.brc != null && this.brc.size() > 0) {
                int size = this.brc.size();
                for (int i = 0; i < size; i++) {
                    v vVar = this.brc.get(i);
                    if ((vVar instanceof ax) && abVar.getId().equals(((ax) vVar).getId())) {
                        return;
                    }
                }
            }
            if (abVar.getThreadType() == 33) {
                ag agVar = new ag();
                agVar.a(abVar, -1);
                agVar.setPost_num(1);
                if (TbadkCoreApplication.m11getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.brc.add(Tu, agVar);
                    return;
                }
                return;
            }
            this.brc.add(Tu, abVar);
        }
    }

    public int Tu() {
        if (this.brc == null || this.brc.size() <= 0) {
            return 0;
        }
        Iterator<v> it = this.brc.iterator();
        int i = 0;
        while (it.hasNext()) {
            v next = it.next();
            if (next instanceof ax) {
                if (((ax) next).getIs_top() != 0) {
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

    public boolean Tv() {
        return this.bso;
    }

    public void Tw() {
        dd ddVar = new dd();
        if (this.bgq.getThreadList() != null) {
            this.bgq.getThreadList().clear();
            this.bgq.getThreadList().add(ddVar);
        }
        if (this.brc != null) {
            this.brc.clear();
            this.brc.add(ddVar);
        }
    }

    public void gG(int i) {
        this.bsx = i;
    }

    public int Tx() {
        return this.bsx;
    }

    private int b(int i, l lVar) {
        if ((i == 1 || i == 2) && this.bpj.Qm() != null) {
            return this.bpj.Qm().a(this.bsx, lVar);
        }
        return i;
    }
}
