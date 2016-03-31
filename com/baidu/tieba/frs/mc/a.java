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
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.performanceLog.v;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.di;
import com.baidu.tieba.frs.et;
import com.baidu.tieba.frs.ew;
import com.baidu.tieba.frs.ey;
import com.baidu.tieba.frs.fo;
import com.baidu.tieba.frs.fp;
import com.baidu.tieba.frs.fq;
import com.baidu.tieba.frs.fr;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> implements NetModel.b<l, m>, fo {
    private long aBC;
    private String adH;
    private long bbP;
    private long bbQ;
    private long bbR;
    private long bbS;
    private String bkf;
    private int bkg;
    private o bkq;
    private boolean bsB;
    private boolean bsC;
    private ArrayList<u> bsv;
    private c<FrsActivity> bsw;
    private l bsx;
    d.a bsy;
    private String bsz;
    private boolean btA;
    public boolean btB;
    public boolean btC;
    private SparseArray<fq> btD;
    private ey btE;
    private fp btF;
    private fp btG;
    private ArrayList<u> btH;
    private String btI;
    private FrsActivity bts;
    private long btt;
    private boolean btu;
    private String btv;
    private int btw;
    private int btx;
    private int bty;
    private fq btz;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bkf = null;
        this.mType = 3;
        this.mPn = 1;
        this.adH = null;
        this.bkg = 0;
        this.btt = 0L;
        this.btu = false;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.btv = null;
        this.bsz = null;
        this.btw = 1;
        this.btx = 0;
        this.bty = 0;
        this.btA = false;
        this.btB = true;
        this.btC = true;
        this.btD = new SparseArray<>();
        this.btF = new b(this);
        this.aBC = 0L;
        this.bsB = false;
        this.bsC = false;
        this.bbP = 0L;
        this.bbQ = 0L;
        this.bbR = 0L;
        this.bbS = 0L;
        this.bts = frsActivity;
        D(frsActivity);
    }

    private void D(FrsActivity frsActivity) {
        this.btE = new ey();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.btE));
        this.btE.a(this.btF);
    }

    public void onActivityDestroy() {
        this.bsw.cancelLoadData();
    }

    public void c(Bundle bundle) {
        if (bundle != null) {
            this.bkf = bundle.getString("name");
            this.adH = bundle.getString("from");
            this.bkg = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.btu = bundle.getBoolean(FrsActivityConfig.GOOD, false);
            this.btI = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
        }
        if (TextUtils.isEmpty(this.bkf)) {
            this.bkf = "";
        }
        if (TextUtils.isEmpty(this.adH)) {
            this.adH = "";
        }
        if (TextUtils.isEmpty(this.btI)) {
            this.btI = "";
        }
        this.mSource = this.adH;
        this.bsx = new l();
        this.bkq = new o();
        this.bsw = new c<>(this.bts.getPageContext(), this.bsx);
        this.bsw.a(this);
        this.bsw.setUniqueId(getUniqueId());
        if (this.bkf != null && this.bkf.length() > 0) {
            if (this.adH == null || this.adH.length() <= 0) {
                this.adH = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.bkf);
        bundle.putString("from", this.adH);
        bundle.putInt(FrsActivityConfig.FLAG, this.bkg);
        bundle.putBoolean(FrsActivityConfig.GOOD, this.btu);
    }

    public boolean oK() {
        return ce(true);
    }

    public boolean Md() {
        if (this.btw != 1) {
            gY(1);
            return true;
        } else if (this.bsw.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.bts.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.bsx), l.class);
            lVar.setPn(lVar.getPn() + 1);
            a(lVar, 1);
            return true;
        }
    }

    public boolean ce(boolean z) {
        return j(3, z);
    }

    public boolean j(int i, boolean z) {
        if (this.bkq != null && this.bkq.aRU() != null) {
            this.bkq.aRU().clear();
        }
        if (this.btw != 1) {
            gY(i);
            return true;
        } else if (this.bsw.isLoading()) {
            return false;
        } else {
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.bsx), l.class);
            lVar.setPn(1);
            a(lVar, i);
            return true;
        }
    }

    public void gW(int i) {
        if (this.btw != 1) {
            gY(4);
        } else if (!this.bsw.isLoading()) {
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.bsx), l.class);
            lVar.setPn(i);
            a(lVar, 4);
        }
    }

    public boolean Td() {
        if (this.bsw.isLoading()) {
            return false;
        }
        this.btu = false;
        this.mPn = 1;
        return ce(true);
    }

    public boolean gX(int i) {
        if (this.bsw.isLoading()) {
            return false;
        }
        this.btu = true;
        this.btt = i;
        this.mPn = 1;
        return ce(true);
    }

    public boolean aD(String str, String str2) {
        if (this.bsw.isLoading() || str2 == null) {
            return false;
        }
        this.mSource = "sidebar";
        this.btv = str;
        this.btu = false;
        this.bkf = str2;
        return ce(true);
    }

    private void a(l lVar, int i) {
        boolean z = true;
        this.bts.bkP.gG(i);
        this.bsw.a(lVar);
        this.mType = i;
        lVar.setKw(this.bkf);
        if (com.baidu.tbadk.core.l.qE().qK()) {
            lVar.setRn(35);
        } else {
            lVar.setRn(50);
        }
        lVar.setWithGroup(1);
        if (this.btu) {
            lVar.setIsGood(1);
            lVar.setCid((int) this.btt);
        } else {
            lVar.setIsGood(0);
            lVar.setCid(0);
        }
        int B = k.B(this.bts.getPageContext().getPageActivity());
        int C = k.C(this.bts.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = az.wz().wB() ? 2 : 1;
        lVar.setScrW(B);
        lVar.setScrH(C);
        lVar.setScrDip(f);
        lVar.setqType(i2);
        lVar.setLastId(this.bsz);
        lVar.setYuelaouLocate(this.btI);
        if (this.mSource != null) {
            lVar.setStType(this.mSource);
            if (this.mSource.equalsIgnoreCase("sidebar")) {
                lVar.setStType(this.btv);
            }
        }
        if (FrsActivity.bku != 0) {
            lVar.setCtime((int) FrsActivity.bku);
        }
        if (FrsActivity.bkv != 0) {
            lVar.setDataSize((int) FrsActivity.bkv);
        }
        if (FrsActivity.bkw != 0) {
            lVar.setNetError(FrsActivity.bkw);
        }
        if (lVar.getPn() != 1 || ((!this.mPageType.equals("normal_page") && !this.mPageType.equals("frs_page")) || this.mType != 3 || this.btu)) {
            z = false;
        }
        lVar.setUpdateType(this.mType);
        lVar.setNeedCache(z);
        if (!z) {
            SQ();
            return;
        }
        SQ();
        new C0062a(this, z, com.baidu.tieba.tbadkCore.c.aRC().at(this.bkf, this.bsx.getCategoryId())).execute(new Object[0]);
    }

    protected boolean a(l lVar, m mVar) {
        if (this.btB) {
            this.btw = mVar.aRY();
        }
        this.btB = false;
        this.bkq.d(mVar);
        this.bsv = new ArrayList<>();
        if (this.bkq.aRE().aSa() == 1) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        if (this.btu) {
            this.mPageType = "good_page";
        }
        if (lVar != null) {
            this.bsx = lVar;
            this.mPn = this.bsx.getPn();
            this.bkf = this.bsx.getKw();
            this.bts.hI(this.bkf);
            this.bts.setFrom(this.adH);
            this.bts.setPn(this.mPn);
            this.bts.setFlag(this.bkg);
        }
        if (this.bkq.getThreadList() != null) {
            this.bsv.addAll(this.bkq.getThreadList());
        }
        if (this.btw != 1) {
            this.bts.bkP.a(7, false, this.bsy);
        } else {
            this.bts.bkP.a(this.mType, false, this.bsy);
        }
        this.mSource = null;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        d.a aVar = new d.a();
        aVar.emO = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.emP = mvcSocketResponsedMessage.getDownSize();
        this.bsy = aVar;
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
        this.bts.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        l lVar;
        l lVar2 = null;
        if (!this.bsC) {
            this.bsC = true;
            v vVar = new v();
            vVar.fh(1000);
            vVar.aBH = false;
            vVar.isSuccess = this.bsy.isSuccess;
            vVar.aBv = mvcSocketResponsedMessage.performanceData.qH;
            vVar.aBw = mvcSocketResponsedMessage.performanceData.qI;
            vVar.aBx = mvcSocketResponsedMessage.performanceData.qJ;
            vVar.oL = mvcSocketResponsedMessage.performanceData.qK;
            vVar.oM = mvcSocketResponsedMessage.performanceData.qL;
            vVar.aBy = mvcSocketResponsedMessage.performanceData.qM;
            vVar.aBz = mvcSocketResponsedMessage.performanceData.qN;
            vVar.aBA = mvcSocketResponsedMessage.performanceData.qO;
            vVar.aBA += mvcSocketResponsedMessage.getProcessTime() - mvcSocketResponsedMessage.getStartTime();
            vVar.aBF = this.bsy.emP;
            vVar.errCode = this.bsy.errorCode;
            vVar.aBG = 0L;
            vVar.sequenceID = mvcSocketResponsedMessage.sequenceID;
            if (this.bts.bkP != null) {
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
        aVar.emO = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.emP = mvcHttpResponsedMessage.getDownSize();
        this.bsy = aVar;
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
        this.bts.a(errorData);
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
        if (!this.bsC) {
            this.bsC = true;
            v vVar = new v();
            vVar.fh(1000);
            vVar.aBH = true;
            vVar.isSuccess = this.bsy.isSuccess;
            vVar.aBv = mvcHttpResponsedMessage.performanceData.qH;
            vVar.aBw = mvcHttpResponsedMessage.performanceData.qI;
            vVar.aBx = mvcHttpResponsedMessage.performanceData.qJ;
            vVar.oL = mvcHttpResponsedMessage.performanceData.qK;
            vVar.oM = mvcHttpResponsedMessage.performanceData.qL;
            vVar.aBy = mvcHttpResponsedMessage.performanceData.qM;
            vVar.aBz = mvcHttpResponsedMessage.performanceData.qN;
            vVar.aBA = mvcHttpResponsedMessage.performanceData.qO;
            vVar.aBA += mvcHttpResponsedMessage.getProcessTime() - mvcHttpResponsedMessage.getStartTime();
            vVar.aBI = mvcHttpResponsedMessage.performanceData.qR;
            vVar.aBJ = mvcHttpResponsedMessage.performanceData.qS;
            vVar.aBF = 0L;
            vVar.aBG = this.bsy.emP;
            vVar.socketErrNo = mvcHttpResponsedMessage.performanceData.qP;
            vVar.socketCostTime = mvcHttpResponsedMessage.performanceData.qQ;
            vVar.errCode = this.bsy.errorCode;
            vVar.aBL = j;
            if (this.bts.bkP != null) {
                d(vVar);
            }
        }
    }

    public void Te() {
        if (this.bkq != null && this.bkq.avu() != null && this.bkq.avu().getBannerListData() != null) {
            String lastIds = this.bkq.avu().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.bsz = lastIds;
            }
        }
    }

    public void d(v vVar) {
        if (vVar != null) {
            vVar.aBt = this.bts.aBt;
            vVar.aBu = this.bts.createTime;
            this.bts.aBt = 0L;
            this.bts.createTime = 0L;
            vVar.aBB = this.bts.aBB;
            vVar.aBC = vVar.aBC == 0 ? System.currentTimeMillis() - this.bts.Tq : vVar.aBC;
            vVar.GP();
        }
    }

    public String Tf() {
        return this.mPageType;
    }

    public boolean Tg() {
        return this.btu;
    }

    public int getType() {
        return this.mType;
    }

    public o SP() {
        return this.bkq;
    }

    public d.a Th() {
        return this.bsy;
    }

    private void SQ() {
        this.bbP = System.currentTimeMillis();
        this.bsw.FG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(m mVar) {
        this.bts.bkP.b(mVar);
        this.btC = false;
        this.bkq.d(mVar);
        this.bsv = new ArrayList<>();
        if (this.bkq.getThreadList() != null) {
            this.bsv.addAll(this.bkq.getThreadList());
        }
        if (this.bkq.aRE().aSa() == 1) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        if (this.btu) {
            this.mPageType = "good_page";
        }
    }

    /* renamed from: com.baidu.tieba.frs.mc.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0062a extends BdAsyncTask<Object, m, Void> {
        private String btK;
        private a btL;
        private boolean needCache;

        public C0062a(a aVar, boolean z, String str) {
            this.btK = null;
            this.btK = str;
            this.btL = aVar;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            if (this.needCache && com.baidu.tieba.tbadkCore.c.aRC().nH(this.btK)) {
                if (!com.baidu.tieba.tbadkCore.c.aRC().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.btK)) {
                    com.baidu.tieba.tbadkCore.c.aRC().getResponseData().avu().getSignData().setIsSigned(0);
                }
                publishProgress(com.baidu.tieba.tbadkCore.c.aRC().getResponseData());
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
            this.btL.c(mVarArr.length > 0 ? mVarArr[0] : null);
        }
    }

    public long NZ() {
        return this.bbS;
    }

    public long Oa() {
        return this.bbQ;
    }

    public long Ob() {
        return this.bbR;
    }

    public long Oc() {
        return this.bbP;
    }

    public boolean isLoading() {
        return this.bsw.isLoading();
    }

    public int Ti() {
        return this.bty;
    }

    private void Tj() {
        if (this.btH == null) {
            this.btH = new ArrayList<>();
        }
        if (this.btH.size() == 0) {
            this.btH.add(new et());
        }
    }

    @Override // com.baidu.tieba.frs.fo
    public void a(int i, int i2, fq fqVar) {
        if (fqVar == null && (fqVar = Y(i, i2)) == null) {
            if (i != 1 && k.jw() && this.btG != null) {
                fr frVar = new fr();
                frVar.hasMore = false;
                frVar.pn = 1;
                frVar.forumName = this.bkf;
                frVar.bru = false;
                if (this.bkq != null && this.bkq.avu() != null) {
                    frVar.forumId = this.bkq.avu().getId();
                }
                Tj();
                this.bkq.ao(this.btH);
                this.btG.a(i, i2, frVar, this.btH);
            }
            fqVar = new fq();
            fqVar.pn = -1;
        }
        if (this.bkq != null && this.bkq.avu() != null) {
            fqVar.forumId = this.bkq.avu().getId();
        }
        fqVar.forumName = this.bkf;
        if (ew.St().gR(1) != null && i == 1) {
            this.bsx.setCategoryId(i2);
        }
        this.btw = i;
        this.btx = i2;
        this.btz = fqVar;
        b(i, i2, fqVar);
        gY(5);
    }

    @Override // com.baidu.tieba.frs.fo
    public void a(fp fpVar) {
        this.btG = fpVar;
        this.btE.a(this.btF);
    }

    private void gY(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.btz != null) {
                    this.btz.pn++;
                    break;
                }
                break;
            case 2:
                if (this.btz != null) {
                    fq fqVar = this.btz;
                    fqVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.btz != null) {
                    this.btz.pn = -1;
                    break;
                }
                break;
        }
        if (this.btw == 1) {
            if (this.bty == this.btx) {
                ArrayList<u> arrayList = new ArrayList<>();
                if (this.bsv != null) {
                    arrayList.addAll(this.bsv);
                }
                this.bkq.ao(arrayList);
                if (this.btG != null) {
                    this.btG.a(this.btw, this.btx, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.bty = this.btx;
            return;
        }
        fo gS = this.btE.gS(this.btw);
        if (gS != null) {
            this.btA = true;
            gS.a(this.btw, this.btx, this.btz);
            return;
        }
        if (this.bkq != null && this.bkq.getThreadList() != null) {
            this.bkq.getThreadList().clear();
        }
        this.btG.a(this.btw, this.btx, null, null);
    }

    public boolean hasMore() {
        if ((this.btz instanceof fr) && ((fr) this.btz).errCode == 0) {
            return ((fr) this.btz).hasMore;
        }
        return true;
    }

    private int X(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, fq fqVar) {
        this.btD.put(X(i, i2), fqVar);
    }

    public fq Y(int i, int i2) {
        return this.btD.get(X(i, i2));
    }

    @Override // com.baidu.tieba.frs.fo
    public void init() {
        this.btE.init();
    }

    @Override // com.baidu.tieba.frs.fo
    public void Qe() {
        this.btE.destory();
        this.btE.clear();
    }

    public int Tk() {
        return this.btw;
    }

    public int Tl() {
        return this.btx;
    }

    public fq Tm() {
        return this.btz;
    }

    public void a(aa aaVar) {
        if (aaVar != null && !StringUtils.isNull(aaVar.getId()) && this.bsv != null) {
            if (this.btw == 1) {
                this.bkq.a(aaVar);
            }
            int To = To();
            if (this.bsv != null && this.bsv.size() > 0) {
                int size = this.bsv.size();
                for (int i = 0; i < size; i++) {
                    u uVar = this.bsv.get(i);
                    if ((uVar instanceof as) && aaVar.getId().equals(((as) uVar).getId())) {
                        return;
                    }
                }
            }
            if (aaVar.getThreadType() == 33) {
                am amVar = new am();
                amVar.a(aaVar, -1);
                amVar.setPost_num(1);
                if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.bsv.add(To, amVar);
                    return;
                }
                return;
            }
            this.bsv.add(To, aaVar);
        }
    }

    public int To() {
        if (this.bsv == null || this.bsv.size() <= 0) {
            return 0;
        }
        Iterator<u> it = this.bsv.iterator();
        int i = 0;
        while (it.hasNext()) {
            u next = it.next();
            if (next instanceof as) {
                if (((as) next).getIs_top() != 0) {
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

    public boolean Tp() {
        return this.btA;
    }

    public void Tq() {
        di diVar = new di();
        if (this.bkq.getThreadList() != null) {
            this.bkq.getThreadList().clear();
            this.bkq.getThreadList().add(diVar);
        }
        if (this.bsv != null) {
            this.bsv.clear();
            this.bsv.add(diVar);
        }
    }
}
