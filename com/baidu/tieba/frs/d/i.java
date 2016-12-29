package com.baidu.tieba.frs.d;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.performanceLog.aa;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.frs.by;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.cl;
import com.baidu.tieba.frs.co;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.e<FrsActivity> implements NetModel.b<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m>, cd {
    private long aCg;
    private String acW;
    private final FrsActivity bFI;
    private ArrayList<v> bIM;
    private o<FrsActivity> bIN;
    private d.a bIP;
    private String bIQ;
    private boolean bIS;
    private boolean bIT;
    private com.baidu.tieba.tbadkCore.l bLR;
    private final com.baidu.tieba.tbadkCore.q bLS;
    private boolean bLT;
    private int bLU;
    private int bLV;
    private int bLW;
    private cl bLX;
    private boolean bLY;
    public boolean bLZ;
    public boolean bMa;
    private SparseArray<cl> bMb;
    private by bMc;
    private ce bMd;
    private ArrayList<v> bMe;
    private String bMf;
    private int bMg;
    private final SparseArray<Boolean> bMh;
    private ce bMi;
    private long bqA;
    private long bqB;
    private long bqC;
    private long bqz;
    private String bxY;
    private com.baidu.tieba.tbadkCore.o byh;
    private int mFlag;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean hE(int i) {
        return this.bMh.get(i, false).booleanValue();
    }

    public void p(int i, boolean z) {
        this.bMh.put(i, Boolean.valueOf(z));
    }

    public i(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.q qVar) {
        super(frsActivity.getPageContext());
        this.bxY = null;
        this.mType = 3;
        this.mPn = 1;
        this.acW = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.bIQ = null;
        this.bLU = 1;
        this.bLV = 0;
        this.bLW = 0;
        this.bLY = false;
        this.bLZ = true;
        this.bMa = true;
        this.bMb = new SparseArray<>();
        this.aCg = 0L;
        this.bIS = false;
        this.bIT = false;
        this.bMg = -1;
        this.bMh = new SparseArray<>();
        this.bMi = new j(this);
        this.bqz = 0L;
        this.bqA = 0L;
        this.bqB = 0L;
        this.bqC = 0L;
        if (frsActivity == null || qVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.bFI = frsActivity;
        this.bLS = qVar;
        C(frsActivity);
    }

    private void C(FrsActivity frsActivity) {
        this.bMc = new by();
        this.bMc.bbl = frsActivity.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.bMc));
        this.bMc.a(this.bMi);
    }

    public void onActivityDestroy() {
        this.bIN.cancelLoadData();
    }

    public void d(Bundle bundle) {
        if (bundle != null) {
            this.bxY = bundle.getString("name");
            this.acW = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.bMf = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.bLT = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.bxY)) {
            this.bxY = "";
        }
        if (TextUtils.isEmpty(this.acW)) {
            this.acW = "";
        }
        if (TextUtils.isEmpty(this.bMf)) {
            this.bMf = "";
        }
        this.mSource = this.acW;
        this.bLR = new com.baidu.tieba.tbadkCore.l();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            hG(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            hG(6);
        } else {
            com.baidu.tieba.frs.f.i iL = com.baidu.tieba.frs.f.f.abm().iL(this.bxY);
            if (iL != null) {
                hG(iL.bMK);
            } else {
                hG(-1);
            }
        }
        this.bLR.setSortType(aaV());
        if (this.bMg == 5) {
            this.bLR.setIsGood(1);
        } else {
            this.bLR.setIsGood(0);
        }
        this.byh = new com.baidu.tieba.tbadkCore.o();
        this.bIN = new o<>(this.bFI.getPageContext(), this.bLR);
        this.bIN.a(this);
        this.bIN.setUniqueId(getUniqueId());
        if (this.bxY != null && this.bxY.length() > 0) {
            if (this.acW == null || this.acW.length() <= 0) {
                this.acW = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.bxY);
        bundle.putString("from", this.acW);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean Pt() {
        if (this.bLU != 1) {
            hF(1);
            return true;
        } else if (this.bIN.wv()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.bFI.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            com.baidu.tieba.tbadkCore.l lVar = (com.baidu.tieba.tbadkCore.l) com.baidu.tieba.tbadkCore.l.objectWithJson(com.baidu.tieba.tbadkCore.l.jsonWithObject(this.bLR), com.baidu.tieba.tbadkCore.l.class);
            lVar.setPn(lVar.getPn() + 1);
            lVar.setSortType(aaV());
            a(lVar, 1);
            return true;
        }
    }

    public void q(int i, boolean z) {
        if (this.byh != null && this.byh.bep() != null) {
            this.byh.bep().clear();
        }
        com.baidu.tieba.tbadkCore.l lVar = (com.baidu.tieba.tbadkCore.l) com.baidu.tieba.tbadkCore.l.objectWithJson(com.baidu.tieba.tbadkCore.l.jsonWithObject(this.bLR), com.baidu.tieba.tbadkCore.l.class);
        lVar.setPn(1);
        this.bLU = b(this.bLU, lVar);
        if (this.bLU == 1) {
            if (!this.bIN.wv()) {
                a(lVar, i);
                return;
            }
            return;
        }
        if (this.bLX == null) {
            this.bLX = new cl();
            this.bLX.pn = 1;
            this.bLX.forumName = this.bxY;
            if (this.byh != null && this.byh.aIk() != null) {
                this.bLX.forumId = this.byh.aIk().getId();
            }
        }
        hF(i);
    }

    public void hA(int i) {
        if (this.bLU != 1) {
            hF(4);
        } else if (!this.bIN.wv()) {
            com.baidu.tieba.tbadkCore.l lVar = (com.baidu.tieba.tbadkCore.l) com.baidu.tieba.tbadkCore.l.objectWithJson(com.baidu.tieba.tbadkCore.l.jsonWithObject(this.bLR), com.baidu.tieba.tbadkCore.l.class);
            lVar.setPn(i);
            lVar.setSortType(aaV());
            a(lVar, 4);
        }
    }

    private void a(com.baidu.tieba.tbadkCore.l lVar, int i) {
        this.bLS.hc(i);
        this.bIN.a(lVar);
        this.mType = i;
        lVar.setKw(this.bxY);
        if (com.baidu.tbadk.core.l.oJ().oP()) {
            lVar.setRn(35);
        } else {
            lVar.setRn(50);
        }
        lVar.setWithGroup(1);
        lVar.setCid(0);
        int I = com.baidu.adp.lib.util.k.I(this.bFI.getPageContext().getPageActivity());
        int J = com.baidu.adp.lib.util.k.J(this.bFI.getPageContext().getPageActivity());
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int i2 = aw.vm().vo() ? 2 : 1;
        lVar.setScrW(I);
        lVar.setScrH(J);
        lVar.setScrDip(f);
        lVar.setqType(i2);
        lVar.setLastId(this.bIQ);
        lVar.setYuelaouLocate(this.bMf);
        lVar.setLastClickTid(com.baidu.adp.lib.h.b.c(com.baidu.tbadk.util.r.GC(), 0L));
        if (this.mSource != null) {
            lVar.setStType(this.mSource);
            if (this.mSource.equalsIgnoreCase("sidebar")) {
                lVar.setStType(null);
            }
        }
        if (FrsActivity.byj != 0) {
            lVar.setCtime((int) FrsActivity.byj);
        }
        if (FrsActivity.byk != 0) {
            lVar.setDataSize((int) FrsActivity.byk);
        }
        if (FrsActivity.byl != 0) {
            lVar.setNetError(FrsActivity.byl);
        }
        lVar.setNeedCache(lVar.getPn() == 1 && this.mType == 3);
        lVar.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.e.c(i, lVar);
        a(this.bxY, lVar);
        com.baidu.tieba.frs.utils.r.a(this.bMg, lVar);
        if (!hE(this.bMg)) {
            new a(this, true, com.baidu.tieba.tbadkCore.c.bdT().e(this.bxY, lVar.aaV(), lVar.getIsGood(), this.bLR.getCategoryId())).execute(new Object[0]);
        }
        aaa();
    }

    protected boolean a(com.baidu.tieba.tbadkCore.l lVar, com.baidu.tieba.tbadkCore.m mVar) {
        if (this.bLZ) {
            this.bLU = mVar.bet();
        }
        this.byh.d(mVar);
        f(this.byh);
        this.bIM = new ArrayList<>();
        if (lVar != null) {
            this.bLR = lVar;
            this.mPn = this.bLR.getPn();
            this.bxY = this.bLR.getKw();
            this.bFI.setForumName(this.bxY);
            this.bFI.setFrom(this.acW);
            this.bFI.setPn(this.mPn);
            this.bFI.setFlag(this.mFlag);
        }
        if (this.byh.getThreadList() != null) {
            this.bIM.addAll(this.byh.getThreadList());
        }
        if (this.bLU != 1 && this.bLZ) {
            this.bLS.a(7, false, this.bIP);
        } else {
            this.bLS.a(this.mType, false, this.bIP);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.f.e.b(this.bLR)) {
            aba();
        }
        this.bLZ = false;
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m mVar;
        d.a aVar = new d.a();
        aVar.fdo = com.baidu.adp.lib.util.i.gm() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.fdp = mvcSocketResponsedMessage.getDownSize();
        this.bIP = aVar;
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
        this.bFI.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        com.baidu.tieba.tbadkCore.l lVar2 = null;
        if (!this.bIT) {
            this.bIT = true;
            a(1000, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
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
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcHttpMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m mVar;
        d.a aVar = new d.a();
        aVar.fdo = com.baidu.adp.lib.util.i.gm() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.fdp = mvcHttpResponsedMessage.getDownSize();
        this.bIP = aVar;
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
        this.bFI.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    @Override // com.baidu.adp.base.e
    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        super.registerListener(i, aVar);
    }

    private void b(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage, MvcHttpMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcHttpMessage, MvcNetMessage<com.baidu.tieba.tbadkCore.l, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        com.baidu.tieba.tbadkCore.l lVar2 = null;
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
        if (!this.bIT) {
            this.bIT = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void WC() {
        if (this.byh != null && this.byh.aIk() != null && this.byh.aIk().getBannerListData() != null) {
            String lastIds = this.byh.aIk().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.bIQ = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.FU().FV()) {
            this.aCg = System.currentTimeMillis() - this.bFI.Rx;
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v(i, z, responsedMessage, this.bFI.aBX, this.bFI.createTime, this.bFI.aCf, false, this.aCg);
            this.bFI.createTime = 0L;
            this.bFI.aBX = 0L;
            if (vVar != null) {
                vVar.FP();
            }
        }
    }

    public String aaK() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.bxY;
    }

    public com.baidu.tieba.tbadkCore.o ZZ() {
        return this.byh;
    }

    public d.a aaL() {
        return this.bIP;
    }

    private void aaa() {
        this.bqz = System.currentTimeMillis();
        this.bIN.EN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.m mVar) {
        this.bMa = false;
        this.byh.d(mVar);
        f(this.byh);
        this.bIM = new ArrayList<>();
        if (this.byh.getThreadList() != null) {
            this.bIM.addAll(this.byh.getThreadList());
        }
        this.bLS.b(mVar);
    }

    private void f(com.baidu.tieba.tbadkCore.o oVar) {
        if (com.baidu.tieba.frs.h.s.l(oVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.h.s.m(oVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.m, Void> {
        private String aMH;
        private i bMk;
        private boolean needCache;

        public a(i iVar, boolean z, String str) {
            this.aMH = null;
            this.aMH = str;
            this.bMk = iVar;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            int g;
            CustomResponsedMessage runTask;
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bdT().pR(this.aMH)) {
                if (!com.baidu.tieba.tbadkCore.c.bdT().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.aMH)) {
                    com.baidu.tieba.tbadkCore.c.bdT().getResponseData().aIk().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.c.bdT().getResponseData();
                if (responseData.bev() != null && !StringUtils.isNull(responseData.bev().getBookId(), true) && !responseData.bev().getBookId().equals("0") && responseData.bev().pB() == 3 && (g = com.baidu.adp.lib.h.b.g(responseData.bev().getBookId(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
                    responseData.g(Integer.valueOf(((Integer) runTask.getData()).intValue()));
                }
                publishProgress(responseData);
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(com.baidu.tieba.tbadkCore.m... mVarArr) {
            super.onProgressUpdate(mVarArr);
            if (this.bMk != null && mVarArr != null) {
                this.bMk.c(mVarArr.length > 0 ? mVarArr[0] : null);
                this.bMk.p(this.bMk.bMg, true);
            }
        }
    }

    public long Tr() {
        return this.bqC;
    }

    public long Ts() {
        return this.bqA;
    }

    public long Tt() {
        return this.bqB;
    }

    public long Tu() {
        return this.bqz;
    }

    public boolean wv() {
        return this.bIN.wv();
    }

    public int aaM() {
        return this.bLW;
    }

    private void aaN() {
        if (this.bMe == null) {
            this.bMe = new ArrayList<>();
        }
        if (this.bMe.size() == 0) {
            this.bMe.add(new bt());
        }
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(int i, int i2, cl clVar) {
        this.bLU = b(i, null);
        if (clVar == null && (clVar = aj(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.k.gD() && this.bMd != null) {
                co coVar = new co();
                coVar.hasMore = false;
                coVar.pn = 1;
                coVar.forumName = this.bxY;
                coVar.bBT = false;
                if (this.byh != null && this.byh.aIk() != null) {
                    coVar.forumId = this.byh.aIk().getId();
                }
                aaN();
                this.byh.at(this.bMe);
                this.bMd.a(i, i2, coVar, this.bMe);
            }
            clVar = new cl();
            clVar.pn = -1;
        }
        if (this.byh != null && this.byh.aIk() != null) {
            clVar.forumId = this.byh.aIk().getId();
        }
        clVar.forumName = this.bxY;
        if (bw.XX().hj(1) != null && this.bLU == 1) {
            this.bLR.setCategoryId(i2);
        }
        this.bLV = i2;
        this.bLX = clVar;
        b(i, i2, clVar);
        hF(5);
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(ce ceVar) {
        this.bMd = ceVar;
        this.bMc.a(this.bMi);
    }

    private void hF(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.bLX != null) {
                    this.bLX.pn++;
                    break;
                }
                break;
            case 2:
                if (this.bLX != null) {
                    cl clVar = this.bLX;
                    clVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.bLX != null) {
                    this.bLX.pn = -1;
                    break;
                }
                break;
        }
        if (this.bLU == 1) {
            if (this.bLW == this.bLV) {
                ArrayList<v> arrayList = new ArrayList<>();
                if (this.bIM != null) {
                    arrayList.addAll(this.bIM);
                }
                this.byh.at(arrayList);
                if (this.bMd != null) {
                    this.bMd.a(this.bLU, this.bLV, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.bLW = this.bLV;
            return;
        }
        cd hk = this.bMc.hk(this.bLU);
        if (hk != null) {
            this.bLY = true;
            hk.a(this.bLU, this.bLV, this.bLX);
            return;
        }
        if (this.byh != null && this.byh.getThreadList() != null) {
            this.byh.getThreadList().clear();
        }
        this.bMd.a(this.bLU, this.bLV, null, null);
    }

    public boolean hasMore() {
        if ((this.bLX instanceof co) && ((co) this.bLX).errCode == 0) {
            return ((co) this.bLX).hasMore;
        }
        return true;
    }

    private int ai(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, cl clVar) {
        this.bMb.put(ai(i, i2), clVar);
    }

    public cl aj(int i, int i2) {
        return this.bMb.get(ai(i, i2));
    }

    @Override // com.baidu.tieba.frs.cd
    public void init() {
        this.bMc.init();
    }

    @Override // com.baidu.tieba.frs.cd
    public void VI() {
        this.bMc.destory();
        this.bMc.clear();
    }

    public int aaO() {
        return this.bLU;
    }

    public boolean aaP() {
        return 1 == this.bLU || 2 == this.bLU;
    }

    @Override // com.baidu.adp.base.e
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(ak akVar) {
        if (akVar != null && !StringUtils.isNull(akVar.getId()) && this.bIM != null) {
            if (this.bLU == 1) {
                this.byh.a(akVar);
            }
            int aaQ = aaQ();
            if (this.bIM != null && this.bIM.size() > 0) {
                int size = this.bIM.size();
                for (int i = 0; i < size; i++) {
                    v vVar = this.bIM.get(i);
                    if ((vVar instanceof bg) && akVar.getId().equals(((bg) vVar).getId())) {
                        return;
                    }
                }
            }
            if (akVar.getThreadType() == 33) {
                at atVar = new at();
                atVar.a(akVar, -1);
                atVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.bIM.add(aaQ, atVar);
                    return;
                }
                return;
            }
            this.bIM.add(aaQ, akVar);
        }
    }

    public int aaQ() {
        if (this.bIM == null || this.bIM.size() <= 0) {
            return 0;
        }
        Iterator<v> it = this.bIM.iterator();
        int i = 0;
        while (it.hasNext()) {
            v next = it.next();
            if (next instanceof bg) {
                if (((bg) next).rA() != 0) {
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

    public boolean aaR() {
        return this.bLY;
    }

    public void aaS() {
        com.baidu.tieba.frs.bg bgVar = new com.baidu.tieba.frs.bg();
        if (this.bLW == 0) {
            bgVar.hi(this.bMg);
        }
        if (this.byh.getThreadList() != null) {
            this.byh.getThreadList().clear();
            this.byh.getThreadList().add(bgVar);
        }
        if (this.bIM != null) {
            this.bIM.clear();
            this.bIM.add(bgVar);
        }
    }

    public ArrayList<v> aaT() {
        return this.bIM;
    }

    public void hG(int i) {
        this.bMg = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.s.bgY();
        } else {
            com.baidu.tieba.tbadkCore.util.s.bgZ();
        }
    }

    public int aaU() {
        return this.bMg;
    }

    public int aaV() {
        return com.baidu.tieba.frs.utils.r.hS(this.bMg);
    }

    public boolean aaW() {
        return this.bLT;
    }

    public boolean aaX() {
        return this.bMg == 5;
    }

    public boolean aaY() {
        return this.bLR != null && this.bLR.getLoadType() == 1;
    }

    public boolean aaZ() {
        return this.bMg == 7;
    }

    private int b(int i, com.baidu.tieba.tbadkCore.l lVar) {
        if ((i == 1 || i == 2) && this.bFI.Wb() != null) {
            return this.bFI.Wb().a(this.bMg, lVar);
        }
        return i;
    }

    private void a(String str, com.baidu.tieba.tbadkCore.l lVar) {
        if (bg.Ts.get()) {
            int pv = com.baidu.tieba.recapp.j.aYf().aYe().pv(str);
            int pw = com.baidu.tieba.recapp.j.aYf().aYe().pw(str);
            if (lVar.getLoadType() == 1) {
                pv++;
            } else {
                pw++;
            }
            lVar.qW(pv);
            lVar.qV(pw);
        }
    }

    public void aba() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.byh != null && this.byh.aIk() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.h.b.c(this.byh.aIk().getId(), 0L));
        }
        this.bFI.sendMessage(requestIncrForumAccessCountNetMessage);
    }
}
