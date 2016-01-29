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
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.s;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.performanceLog.v;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.dd;
import com.baidu.tieba.frs.el;
import com.baidu.tieba.frs.eo;
import com.baidu.tieba.frs.eq;
import com.baidu.tieba.frs.fe;
import com.baidu.tieba.frs.ff;
import com.baidu.tieba.frs.fh;
import com.baidu.tieba.frs.fi;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> implements NetModel.b<l, m>, fe {
    private long aAL;
    private com.baidu.tieba.tbadkCore.d.b aXf;
    private long aXg;
    private long aXh;
    private long aXi;
    private long aXj;
    private String aer;
    private o bfF;
    private String bfv;
    private int bfw;
    private l bnA;
    d.a bnB;
    private String bnC;
    private boolean bnE;
    private boolean bnF;
    private ArrayList<u> bny;
    private c<FrsActivity> bnz;
    private fh boA;
    private boolean boB;
    private SparseArray<fh> boC;
    private eq boD;
    private ff boE;
    private ff boF;
    private ArrayList<u> boG;
    private String boH;
    private FrsActivity bot;
    private long bou;
    private boolean bov;
    private String bow;
    private int box;
    private int boy;
    private int boz;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public a(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bfv = null;
        this.mType = 3;
        this.mPn = 1;
        this.aer = null;
        this.bfw = 0;
        this.bou = 0L;
        this.bov = false;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.bow = null;
        this.bnC = null;
        this.box = 1;
        this.boy = 0;
        this.boz = 0;
        this.boB = false;
        this.boC = new SparseArray<>();
        this.boE = new b(this);
        this.aXf = null;
        this.aAL = 0L;
        this.bnE = false;
        this.bnF = false;
        this.aXg = 0L;
        this.aXh = 0L;
        this.aXi = 0L;
        this.aXj = 0L;
        this.bot = frsActivity;
        C(frsActivity);
    }

    private void C(FrsActivity frsActivity) {
        this.boD = new eq();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.boD));
        this.boD.a(this.boE);
    }

    public void onActivityDestroy() {
        if (this.aXf != null) {
            this.aXf.destory();
        }
        this.bnz.cancelLoadData();
    }

    public void c(Bundle bundle) {
        if (bundle != null) {
            this.bfv = bundle.getString("name");
            this.aer = bundle.getString("from");
            this.bfw = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.bov = bundle.getBoolean(FrsActivityConfig.GOOD, false);
            this.boH = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
        }
        if (TextUtils.isEmpty(this.bfv)) {
            this.bfv = "";
        }
        if (TextUtils.isEmpty(this.aer)) {
            this.aer = "";
        }
        if (TextUtils.isEmpty(this.boH)) {
            this.boH = "";
        }
        this.mSource = this.aer;
        this.bnA = new l();
        this.bfF = new o();
        this.bnz = new c<>(this.bot.getPageContext(), this.bnA);
        this.bnz.a(this);
        this.bnz.setUniqueId(getUniqueId());
        if (this.bfv != null && this.bfv.length() > 0) {
            if (this.aer == null || this.aer.length() <= 0) {
                this.aer = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.bfv);
        bundle.putString("from", this.aer);
        bundle.putInt(FrsActivityConfig.FLAG, this.bfw);
        bundle.putBoolean(FrsActivityConfig.GOOD, this.bov);
    }

    public boolean oR() {
        return bU(true);
    }

    public boolean KJ() {
        if (this.box != 1) {
            gH(1);
            return true;
        } else if (this.bnz.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.bot.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.bnA), l.class);
            lVar.setPn(lVar.getPn() + 1);
            a(lVar, 1);
            return true;
        }
    }

    public boolean bU(boolean z) {
        return j(3, z);
    }

    public boolean j(int i, boolean z) {
        if (this.bfF != null && this.bfF.aLf() != null) {
            this.bfF.aLf().clear();
        }
        if (this.box != 1) {
            gH(i);
            return true;
        } else if (this.bnz.isLoading()) {
            return false;
        } else {
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.bnA), l.class);
            lVar.setPn(1);
            a(lVar, i);
            return true;
        }
    }

    public void gF(int i) {
        if (this.box != 1) {
            gH(4);
        } else if (!this.bnz.isLoading()) {
            l lVar = (l) l.objectWithJson(l.jsonWithObject(this.bnA), l.class);
            lVar.setPn(i);
            a(lVar, 4);
        }
    }

    public boolean Rq() {
        if (this.bnz.isLoading()) {
            return false;
        }
        this.bov = false;
        this.mPn = 1;
        return bU(true);
    }

    public boolean gG(int i) {
        if (this.bnz.isLoading()) {
            return false;
        }
        this.bov = true;
        this.bou = i;
        this.mPn = 1;
        return bU(true);
    }

    public boolean av(String str, String str2) {
        if (this.bnz.isLoading() || str2 == null) {
            return false;
        }
        this.mSource = "sidebar";
        this.bow = str;
        this.bov = false;
        this.bfv = str2;
        return bU(true);
    }

    private void a(l lVar, int i) {
        boolean z = true;
        this.bot.bgd.gp(i);
        this.bnz.a(lVar);
        this.mType = i;
        lVar.setKw(this.bfv);
        if (com.baidu.tbadk.core.l.rn().rt()) {
            lVar.setRn(35);
        } else {
            lVar.setRn(50);
        }
        lVar.setWithGroup(1);
        if (this.bov) {
            lVar.setIsGood(1);
            lVar.setCid((int) this.bou);
        } else {
            lVar.setIsGood(0);
            lVar.setCid(0);
        }
        int K = k.K(this.bot.getPageContext().getPageActivity());
        int L = k.L(this.bot.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = ax.wg().wi() ? 2 : 1;
        lVar.setScrW(K);
        lVar.setScrH(L);
        lVar.setScrDip(f);
        lVar.setqType(i2);
        lVar.setLastId(this.bnC);
        lVar.setYuelaouLocate(this.boH);
        if (this.mSource != null) {
            lVar.setStType(this.mSource);
            if (this.mSource.equalsIgnoreCase("sidebar")) {
                lVar.setStType(this.bow);
            }
        }
        if (FrsActivity.bfJ != 0) {
            lVar.setCtime((int) FrsActivity.bfJ);
        }
        if (FrsActivity.bfK != 0) {
            lVar.setDataSize((int) FrsActivity.bfK);
        }
        if (FrsActivity.bfL != 0) {
            lVar.setNetError(FrsActivity.bfL);
        }
        if (lVar.getPn() != 1 || ((!this.mPageType.equals("normal_page") && !this.mPageType.equals("frs_page")) || this.mType != 3 || this.bov)) {
            z = false;
        }
        lVar.setUpdateType(this.mType);
        lVar.setNeedCache(z);
        if (!z) {
            Rd();
        } else {
            Rd();
            new C0061a(this, z, com.baidu.tieba.tbadkCore.c.aKN().al(this.bfv, this.bnA.getCategoryId())).execute(new Object[0]);
        }
        if (this.aXf == null) {
            this.aXf = new com.baidu.tieba.tbadkCore.d.b("frsStat");
            this.aXf.start();
        }
    }

    protected boolean a(l lVar, m mVar) {
        if (this.box == 1) {
            this.bfF.d(mVar);
            this.bny = new ArrayList<>();
            if (this.bfF.aKP().aLi() == 1) {
                this.mPageType = "frs_page";
            } else {
                this.mPageType = "normal_page";
            }
            if (this.bov) {
                this.mPageType = "good_page";
            }
            if (lVar != null) {
                this.bnA = lVar;
                this.mPn = this.bnA.getPn();
                this.bfv = this.bnA.getKw();
                this.bot.hs(this.bfv);
                this.bot.setFrom(this.aer);
                this.bot.setPn(this.mPn);
                this.bot.setFlag(this.bfw);
            }
            this.bot.bgd.a(this.mType, false, this.bnB);
            if (this.bfF.getThreadList() != null) {
                this.bny.addAll(this.bfF.getThreadList());
            }
            this.mSource = null;
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        d.a aVar = new d.a();
        aVar.dUo = mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.dUp = mvcSocketResponsedMessage.getDownSize();
        this.bnB = aVar;
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
        this.bot.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<m, ?> mvcSocketResponsedMessage, MvcSocketMessage<l, m> mvcSocketMessage, MvcNetMessage<l, m> mvcNetMessage) {
        l lVar;
        l lVar2;
        Rb();
        if (this.aXf != null) {
            this.aXf.a(false, this.bnB.isSuccess, this.bnB.errorCode, this.bnB.errorMsg, this.bnB.dUp);
            this.aXf = null;
        }
        if (!this.bnF) {
            this.bnF = true;
            v vVar = new v();
            vVar.eZ(1000);
            vVar.aAQ = false;
            vVar.isSuccess = this.bnB.isSuccess;
            vVar.aAF = mvcSocketResponsedMessage.performanceData.qD;
            vVar.aAG = mvcSocketResponsedMessage.performanceData.qE;
            vVar.aAH = mvcSocketResponsedMessage.performanceData.qF;
            vVar.aAI = mvcSocketResponsedMessage.performanceData.qG;
            vVar.aAJ = mvcSocketResponsedMessage.performanceData.qH;
            vVar.aAO = this.bnB.dUp;
            vVar.errCode = this.bnB.errorCode;
            vVar.aAP = 0L;
            if (this.bot.bgd != null) {
                e(vVar);
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
        if (error != 0) {
            int cmd = mvcSocketResponsedMessage.getCmd();
            Object[] objArr = new Object[2];
            objArr[0] = "kw";
            objArr[1] = lVar2 != null ? lVar2.getKw() : null;
            com.baidu.tbadk.core.log.b.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        m mVar;
        d.a aVar = new d.a();
        aVar.dUo = mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10;
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.dUp = mvcHttpResponsedMessage.getDownSize();
        this.bnB = aVar;
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
        this.bot.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    private void b(MvcHttpResponsedMessage<m> mvcHttpResponsedMessage, MvcHttpMessage<l, m> mvcHttpMessage, MvcNetMessage<l, m> mvcNetMessage) {
        l lVar;
        l lVar2;
        Rb();
        if (this.aXf != null) {
            this.aXf.a(true, this.bnB.isSuccess, this.bnB.errorCode, this.bnB.errorMsg, this.bnB.dUp);
            this.aXf = null;
        }
        if (!this.bnF) {
            this.bnF = true;
            v vVar = new v();
            vVar.eZ(1000);
            vVar.aAQ = true;
            vVar.isSuccess = this.bnB.isSuccess;
            vVar.aAF = mvcHttpResponsedMessage.performanceData.qD;
            vVar.aAG = mvcHttpResponsedMessage.performanceData.qE;
            vVar.aAH = mvcHttpResponsedMessage.performanceData.qF;
            vVar.aAI = mvcHttpResponsedMessage.performanceData.qG;
            vVar.aAJ = mvcHttpResponsedMessage.performanceData.qH;
            vVar.aAO = 0L;
            vVar.aAP = this.bnB.dUp;
            vVar.socketErrNo = mvcHttpResponsedMessage.performanceData.qI;
            vVar.socketCostTime = mvcHttpResponsedMessage.performanceData.qJ;
            vVar.errCode = this.bnB.errorCode;
            if (this.bot.bgd != null) {
                e(vVar);
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
        if (error != 0) {
            int cmd = mvcHttpResponsedMessage.getCmd();
            Object[] objArr = new Object[2];
            objArr[0] = "kw";
            objArr[1] = lVar2 != null ? lVar2.getKw() : null;
            com.baidu.tbadk.core.log.b.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
    }

    public void Rr() {
        if (this.bfF != null && this.bfF.aoE() != null && this.bfF.aoE().getBannerListData() != null) {
            String lastIds = this.bfF.aoE().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.bnC = lastIds;
            }
        }
    }

    public void Rb() {
        if (!this.bnE) {
            this.bnE = true;
            this.aAL = System.currentTimeMillis() - this.bot.VB;
            v vVar = new v();
            vVar.eZ(1000);
            vVar.aAE = this.bot.createTime;
            vVar.aAL = this.aAL;
            vVar.FS();
        }
    }

    public void e(v vVar) {
        if (vVar != null) {
            vVar.aAE = this.bot.createTime;
            this.bot.createTime = 0L;
            vVar.aAK = this.bot.aAK;
            vVar.aAL = this.aAL == 0 ? System.currentTimeMillis() - this.bot.VB : this.aAL;
            vVar.FT();
        }
    }

    public String Rs() {
        return this.mPageType;
    }

    public boolean Rt() {
        return this.bov;
    }

    public int getType() {
        return this.mType;
    }

    public o Rc() {
        return this.bfF;
    }

    public d.a Ru() {
        return this.bnB;
    }

    private void Rd() {
        this.aXg = System.currentTimeMillis();
        this.bnz.ET();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(m mVar) {
        this.bot.bgd.b(mVar);
        this.bfF.d(mVar);
        this.bny = new ArrayList<>();
        if (this.bfF.getThreadList() != null) {
            this.bny.addAll(this.bfF.getThreadList());
        }
        if (this.bfF.aKP().aLi() == 1) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
        if (this.bov) {
            this.mPageType = "good_page";
        }
    }

    /* renamed from: com.baidu.tieba.frs.mc.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0061a extends BdAsyncTask<Object, m, Void> {
        private String boJ;
        private a boK;
        private boolean needCache;

        public C0061a(a aVar, boolean z, String str) {
            this.boJ = null;
            this.boJ = str;
            this.boK = aVar;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            if (this.needCache && com.baidu.tieba.tbadkCore.c.aKN().mw(this.boJ)) {
                if (!com.baidu.tieba.tbadkCore.c.aKN().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.boJ)) {
                    com.baidu.tieba.tbadkCore.c.aKN().getResponseData().aoE().getSignData().setIsSigned(0);
                }
                publishProgress(com.baidu.tieba.tbadkCore.c.aKN().getResponseData());
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
            this.boK.c(mVarArr.length > 0 ? mVarArr[0] : null);
        }
    }

    public long Ml() {
        return this.aXj;
    }

    public long Mm() {
        return this.aXh;
    }

    public long Mn() {
        return this.aXi;
    }

    public long Mo() {
        return this.aXg;
    }

    public boolean isLoading() {
        return this.bnz.isLoading();
    }

    public int Rv() {
        return this.boz;
    }

    private void Rw() {
        if (this.boG == null) {
            this.boG = new ArrayList<>();
        }
        if (this.boG.size() == 0) {
            this.boG.add(new el());
        }
    }

    @Override // com.baidu.tieba.frs.fe
    public void a(int i, int i2, fh fhVar) {
        if (fhVar == null && (fhVar = ab(i, i2)) == null) {
            if (i != 1 && k.jq() && this.boF != null) {
                fi fiVar = new fi();
                fiVar.hasMore = false;
                fiVar.pn = 1;
                fiVar.forumName = this.bfv;
                fiVar.bmf = false;
                if (this.bfF != null && this.bfF.aoE() != null) {
                    fiVar.forumId = this.bfF.aoE().getId();
                }
                Rw();
                this.bfF.an(this.boG);
                this.boF.a(i, i2, fiVar, this.boG);
            }
            fhVar = new fh();
            fhVar.pn = -1;
        }
        if (this.bfF != null && this.bfF.aoE() != null) {
            fhVar.forumId = this.bfF.aoE().getId();
        }
        fhVar.forumName = this.bfv;
        if (eo.Qz().gz(1) != null && i == 1) {
            this.bnA.setCategoryId(i2);
        }
        this.box = i;
        this.boy = i2;
        this.boA = fhVar;
        b(i, i2, fhVar);
        gH(5);
    }

    @Override // com.baidu.tieba.frs.fe
    public void a(ff ffVar) {
        this.boF = ffVar;
        this.boD.a(this.boE);
    }

    private void gH(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.boA != null) {
                    this.boA.pn++;
                    break;
                }
                break;
            case 2:
                if (this.boA != null) {
                    fh fhVar = this.boA;
                    fhVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.boA != null) {
                    this.boA.pn = -1;
                    break;
                }
                break;
        }
        if (this.box == 1) {
            if (this.boz == this.boy) {
                ArrayList<u> arrayList = new ArrayList<>();
                if (this.bny != null) {
                    arrayList.addAll(this.bny);
                }
                this.bfF.an(arrayList);
                if (this.boF != null) {
                    this.boF.a(this.box, this.boy, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.boz = this.boy;
            return;
        }
        fe gA = this.boD.gA(this.box);
        if (gA != null) {
            this.boB = true;
            gA.a(this.box, this.boy, this.boA);
            return;
        }
        if (this.bfF != null && this.bfF.getThreadList() != null) {
            this.bfF.getThreadList().clear();
        }
        this.boF.a(this.box, this.boy, null, null);
    }

    public boolean hasMore() {
        if ((this.boA instanceof fi) && ((fi) this.boA).errCode == 0) {
            return ((fi) this.boA).hasMore;
        }
        return true;
    }

    private int aa(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, fh fhVar) {
        this.boC.put(aa(i, i2), fhVar);
    }

    public fh ab(int i, int i2) {
        return this.boC.get(aa(i, i2));
    }

    @Override // com.baidu.tieba.frs.fe
    public void init() {
        this.boD.init();
    }

    @Override // com.baidu.tieba.frs.fe
    public void Op() {
        this.boD.destory();
        this.boD.clear();
    }

    public int Rx() {
        return this.box;
    }

    public int Ry() {
        return this.boy;
    }

    public fh Rz() {
        return this.boA;
    }

    public void a(s sVar) {
        if (sVar != null && !StringUtils.isNull(sVar.getId()) && this.bny != null) {
            if (this.box == 1) {
                this.bfF.a(sVar);
            }
            int RA = RA();
            if (this.bny != null && this.bny.size() > 0) {
                int size = this.bny.size();
                for (int i = 0; i < size; i++) {
                    u uVar = this.bny.get(i);
                    if ((uVar instanceof ah) && sVar.getId().equals(((ah) uVar).getId())) {
                        return;
                    }
                }
            }
            if (sVar.getThreadType() == 33) {
                ab abVar = new ab();
                abVar.a(sVar, -1);
                abVar.setPost_num(1);
                if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.bny.add(RA, abVar);
                    return;
                }
                return;
            }
            this.bny.add(RA, sVar);
        }
    }

    public int RA() {
        if (this.bny == null || this.bny.size() <= 0) {
            return 0;
        }
        Iterator<u> it = this.bny.iterator();
        int i = 0;
        while (it.hasNext()) {
            u next = it.next();
            if (next instanceof ah) {
                if (((ah) next).getIs_top() != 0) {
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

    public boolean RB() {
        return this.boB;
    }

    public void RC() {
        dd ddVar = new dd();
        if (this.bfF.getThreadList() != null) {
            this.bfF.getThreadList().clear();
            this.bfF.getThreadList().add(ddVar);
        }
        if (this.bny != null) {
            this.bny.clear();
            this.bny.add(ddVar);
        }
    }
}
