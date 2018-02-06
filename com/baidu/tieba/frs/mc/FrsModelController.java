package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.k.p;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.i>, ak {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long bAK;
    private int bZU;
    private l dEb;
    private String dEq;
    private final com.baidu.tieba.frs.i dSV;
    private ArrayList<com.baidu.adp.widget.ListView.i> dSY;
    private FrsRequestData dSZ;
    private FrsNetModel<com.baidu.tieba.frs.i> dSd;
    private d.a dSf;
    private String dSg;
    private final n dTa;
    private boolean dTb;
    private int dTc;
    private int dTd;
    private aq dTe;
    private boolean dTf;
    private SparseArray<aq> dTg;
    private ac dTh;
    private an dTi;
    private ArrayList<com.baidu.adp.widget.ListView.i> dTj;
    private boolean dTk;
    private String dTl;
    private int dTm;
    private int dTn;
    private boolean dTo;
    private String dTp;
    private final SparseArray<Boolean> dTq;
    private an dTr;
    private long dqi;
    private long dqj;
    private long dqk;
    private long dql;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean nG(int i) {
        return this.dTq.get(i, false).booleanValue();
    }

    public void F(int i, boolean z) {
        this.dTq.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.i iVar, n nVar) {
        super(iVar.getPageContext());
        this.dEq = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.dSg = null;
        this.bZU = 1;
        this.dTc = 0;
        this.dTd = 0;
        this.dTf = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.dTg = new SparseArray<>();
        this.bAK = 0L;
        this.dTk = false;
        this.dTm = -1;
        this.dTn = -1;
        this.dTp = null;
        this.dTq = new SparseArray<>();
        this.dTr = new an() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.an
            public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
                FrsModelController.this.dTf = false;
                if (i == FrsModelController.this.bZU && FrsModelController.this.dTi != null) {
                    FrsModelController.this.dTe = atVar;
                    FrsModelController.this.b(i, i2, atVar);
                    ArrayList<com.baidu.adp.widget.ListView.i> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.dEb.au(arrayList2);
                    if ((i == 1 || i == 5) && !FrsModelController.this.azB()) {
                        FrsModelController.this.dEb.bvO();
                        FrsModelController.this.dEb.bvP();
                    }
                    FrsModelController.this.dTi.a(i, i2, atVar, arrayList);
                }
            }
        };
        this.dqi = 0L;
        this.dqj = 0L;
        this.dqk = 0L;
        this.dql = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.dSV = iVar;
        this.dTa = nVar;
        y(this.dSV);
    }

    private void y(com.baidu.tieba.frs.i iVar) {
        this.dTh = new ac();
        this.dTh.bII = iVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.dTh));
        this.dTh.a(this.dTr);
    }

    public void onActivityDestroy() {
        this.dSd.cancelLoadData();
    }

    public void l(Bundle bundle) {
        if (bundle != null) {
            this.dEq = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dTl = bundle.getString("yuelaou_locate");
            this.dTb = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.dEq)) {
            this.dEq = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.dTl)) {
            this.dTl = "";
        }
        this.mSource = this.mFrom;
        this.dSZ = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            nH(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            nH(6);
        } else {
            com.baidu.tieba.frs.smartsort.f mo = com.baidu.tieba.frs.smartsort.d.azM().mo(this.dEq);
            if (mo != null) {
                nH(mo.dUd);
            } else {
                nH(-1);
            }
        }
        this.dSZ.setSortType(YM());
        if (this.dTm == 5) {
            this.dSZ.setIsGood(1);
        } else {
            this.dSZ.setIsGood(0);
        }
        this.dEb = new l();
        this.dSd = new FrsNetModel<>(this.dSV.getPageContext(), this.dSZ);
        this.dSd.a(this);
        this.dSd.setUniqueId(this.dSV.getUniqueId());
        if (this.dEq != null && this.dEq.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dEq);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean amN() {
        if (this.bZU != 1) {
            nC(1);
            return true;
        } else if (this.dSd.El()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dSZ), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(YM());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void G(int i, boolean z) {
        if (this.dEb != null && this.dEb.bvj() != null) {
            this.dEb.bvj().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dSZ), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bZU = c(this.bZU, frsRequestData);
        if (this.bZU == 1) {
            if (!this.dSd.El()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.dTe == null) {
            this.dTe = new aq();
            this.dTe.pn = 1;
            this.dTe.forumName = this.dEq;
            if (this.dEb != null && this.dEb.bas() != null) {
                this.dTe.forumId = this.dEb.bas().getId();
            }
        }
        nC(i);
    }

    public void nD(int i) {
        if (this.bZU != 1) {
            nC(4);
        } else if (!this.dSd.El()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dSZ), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(YM());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.dTa.mQ(i);
        this.dSd.a(frsRequestData);
        this.mType = i;
        frsRequestData.sz(this.dSV.avn() ? "1" : "2");
        if (this.dTo) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.f.nM(this.dTn)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.dTo = false;
        frsRequestData.setKw(this.dEq);
        if (com.baidu.tbadk.core.i.xo().xu()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ao = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst());
        int aq = com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst());
        float ar = com.baidu.adp.lib.util.l.ar(TbadkCoreApplication.getInst());
        int i2 = ao.De().Dg() ? 2 : 1;
        frsRequestData.setScrW(ao);
        frsRequestData.setScrH(aq);
        frsRequestData.setScrDip(ar);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.dSg);
        frsRequestData.setYuelaouLocate(this.dTl);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(t.Pn(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.i.dEy != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.i.dEy);
        }
        if (com.baidu.tieba.frs.i.dEz != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.i.dEz);
        }
        if (com.baidu.tieba.frs.i.dEA != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.i.dEA);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.f.a(this.dTm, frsRequestData);
        b(i, frsRequestData);
        a(this.dEq, frsRequestData);
        if (!nG(this.dTm)) {
            String d = com.baidu.tieba.tbadkCore.c.buI().d(this.dEq, frsRequestData.YM(), frsRequestData.getIsGood(), this.dSZ.getCategoryId());
            this.dTp = d;
            new a(this, true, d).execute(new Object[0]);
        }
        ayW();
    }

    private void b(int i, FrsRequestData frsRequestData) {
        if (frsRequestData != null) {
            switch (i) {
                case 3:
                    frsRequestData.setLoadType(1);
                    return;
                case 4:
                    frsRequestData.setLoadType(2);
                    return;
                default:
                    return;
            }
        }
    }

    protected boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.i iVar) {
        if (iVar == null || iVar.bas() == null || (am.isEmpty(iVar.bas().getName()) && 340001 != iVar.gZm)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bZU = iVar.bvn();
        }
        this.dEb.e(iVar);
        d(this.dEb);
        this.dSY = new ArrayList<>();
        if (frsRequestData != null) {
            this.dSZ = frsRequestData;
            this.mPn = this.dSZ.getPn();
            this.dEq = this.dSZ.getKw();
            this.dSV.setForumName(this.dEq);
            this.dSV.setFrom(this.mFrom);
            this.dSV.setPn(this.mPn);
            this.dSV.setFlag(this.mFlag);
        }
        if (this.dEb.getThreadList() != null) {
            this.dSY.addAll(this.dEb.getThreadList());
        }
        if (this.bZU != 1 && this.isNetFirstLoad) {
            this.dTa.a(7, false, this.dSf);
        } else {
            this.dTa.a(this.mType, false, this.dSf);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.dSZ)) {
            azC();
        }
        this.isNetFirstLoad = false;
        if (iVar.bas() == null || TextUtils.isEmpty(iVar.bas().getName()) || frsRequestData == null || r.bof().bnZ() == null) {
            return true;
        }
        r.bof().bnZ().f(iVar.bas().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.gXI = com.baidu.adp.lib.util.j.oJ() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gXJ = mvcSocketResponsedMessage.getDownSize();
        this.dSf = aVar;
        if (mvcSocketResponsedMessage == null || (mvcSocketResponsedMessage.hasError() && 340001 != mvcSocketResponsedMessage.getError())) {
            iVar = null;
        } else {
            iVar = mvcSocketResponsedMessage.getData();
            r3 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && iVar != null && a(r3, iVar)) {
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
        this.dSV.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dTk) {
            this.dTk = true;
            a(1000, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        }
        long j = 0;
        if (mvcSocketMessage != null) {
            j = mvcSocketMessage.getClientLogID();
            frsRequestData = mvcSocketMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            frsRequestData = mvcNetMessage.getRequestData();
        }
        int error = mvcSocketResponsedMessage.getError();
        String errorString = mvcSocketResponsedMessage.getErrorString();
        if (error != 0) {
            int cmd = mvcSocketResponsedMessage.getCmd();
            Object[] objArr = new Object[4];
            objArr[0] = "kw";
            objArr[1] = frsRequestData != null ? frsRequestData.getKw() : null;
            objArr[2] = "seq_id";
            objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
            com.baidu.tbadk.core.d.a.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.i> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.gXI = com.baidu.adp.lib.util.j.oJ() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gXJ = mvcHttpResponsedMessage.getDownSize();
        this.dSf = aVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            iVar = null;
        } else {
            iVar = mvcHttpResponsedMessage.getData();
            r3 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && iVar != null && a(r3, iVar)) {
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
        this.dSV.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        super.registerListener(i, aVar);
    }

    private void b(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.i> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        long j = 0;
        if (mvcHttpMessage != null) {
            j = mvcHttpMessage.getClientLogID();
            frsRequestData = mvcHttpMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            frsRequestData = mvcNetMessage.getRequestData();
        }
        int error = mvcHttpResponsedMessage.getError();
        String errorString = mvcHttpResponsedMessage.getErrorString();
        if (error != 0) {
            int cmd = mvcHttpResponsedMessage.getCmd();
            Object[] objArr = new Object[2];
            objArr[0] = "kw";
            objArr[1] = frsRequestData != null ? frsRequestData.getKw() : null;
            com.baidu.tbadk.core.d.a.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
        if (!this.dTk) {
            this.dTk = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void avh() {
        if (this.dEb != null && this.dEb.bas() != null && this.dEb.bas().getBannerListData() != null) {
            String lastIds = this.dEb.bas().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dSg = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (p.Ow().Ox()) {
            this.bAK = System.currentTimeMillis() - this.dSV.beginTime;
            com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l(i, z, responsedMessage, this.dSV.bAB, this.dSV.createTime, this.dSV.bAJ, false, this.bAK);
            this.dSV.createTime = 0L;
            this.dSV.bAB = 0L;
            if (lVar != null) {
                lVar.Or();
            }
        }
    }

    public FrsRequestData azm() {
        return this.dSZ;
    }

    public String azn() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.dEq;
    }

    public int getPn() {
        return this.mPn;
    }

    public l ayV() {
        return this.dEb;
    }

    public d.a azo() {
        return this.dSf;
    }

    private void ayW() {
        this.dqi = System.currentTimeMillis();
        this.dSd.Nw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.dEb.e(iVar);
        d(this.dEb);
        this.dSY = new ArrayList<>();
        if (this.dEb.getThreadList() != null) {
            this.dSY.addAll(this.dEb.getThreadList());
        }
        this.dTa.b(iVar);
    }

    private void d(l lVar) {
        if (com.baidu.tieba.frs.g.f.h(lVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.g.f.i(lVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.i, Void> {
        private String dTv;
        private FrsModelController dTw;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.dTv = null;
            this.dTv = str;
            this.dTw = frsModelController;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            int h;
            CustomResponsedMessage runTask;
            if (this.needCache && com.baidu.tieba.tbadkCore.c.buI().sx(this.dTv)) {
                if (!com.baidu.tieba.tbadkCore.c.buI().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.dTv)) {
                    com.baidu.tieba.tbadkCore.c.buI().getResponseData().bas().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.i responseData = com.baidu.tieba.tbadkCore.c.buI().getResponseData();
                if (responseData.bvp() != null && !StringUtils.isNull(responseData.bvp().xT(), true) && !responseData.bvp().xT().equals("0") && responseData.bvp().xU() == 3 && (h = com.baidu.adp.lib.g.b.h(responseData.bvp().xT(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(h))) != null) {
                    responseData.j(Integer.valueOf(((Integer) runTask.getData()).intValue()));
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
        public void onProgressUpdate(com.baidu.tieba.tbadkCore.i... iVarArr) {
            super.onProgressUpdate(iVarArr);
            if (this.dTw != null && iVarArr != null) {
                this.dTw.d(iVarArr.length > 0 ? iVarArr[0] : null);
                this.dTw.F(this.dTw.dTm, true);
            }
        }
    }

    public long aqO() {
        return this.dql;
    }

    public long aqP() {
        return this.dqj;
    }

    public long aqQ() {
        return this.dqk;
    }

    public long aqR() {
        return this.dqi;
    }

    public boolean El() {
        return this.dSd.El();
    }

    public int azp() {
        return this.dTd;
    }

    private void azq() {
        if (this.dTj == null) {
            this.dTj = new ArrayList<>();
        }
        if (this.dTj.size() == 0) {
            this.dTj.add(new x());
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, aq aqVar) {
        this.bZU = c(i, null);
        if (aqVar == null && (aqVar = bH(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.pa() && this.dTi != null) {
                at atVar = new at();
                atVar.hasMore = false;
                atVar.pn = 1;
                atVar.forumName = this.dEq;
                atVar.dHJ = false;
                if (this.dEb != null && this.dEb.bas() != null) {
                    atVar.forumId = this.dEb.bas().getId();
                }
                azq();
                this.dEb.au(this.dTj);
                this.dTi.a(i, i2, atVar, this.dTj);
            }
            aqVar = new aq();
            aqVar.pn = -1;
        }
        if (this.dEb != null && this.dEb.bas() != null) {
            aqVar.forumId = this.dEb.bas().getId();
        }
        aqVar.forumName = this.dEq;
        if (aa.awl().mX(1) != null && this.bZU == 1) {
            this.dSZ.setCategoryId(i2);
        }
        this.dTc = i2;
        this.dTe = aqVar;
        b(i, i2, aqVar);
        nC(5);
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(an anVar) {
        this.dTi = anVar;
        this.dTh.a(this.dTr);
    }

    private void nC(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.dTe != null) {
                    this.dTe.pn++;
                    break;
                }
                break;
            case 2:
                if (this.dTe != null) {
                    aq aqVar = this.dTe;
                    aqVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.dTe != null) {
                    this.dTe.pn = -1;
                    break;
                }
                break;
        }
        if (this.bZU == 1) {
            if (this.dTd == this.dTc) {
                ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
                if (this.dSY != null) {
                    arrayList.addAll(this.dSY);
                }
                this.dEb.au(arrayList);
                if (this.dTi != null) {
                    this.dTi.a(this.bZU, this.dTc, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.dTd = this.dTc;
            return;
        }
        ak mY = this.dTh.mY(this.bZU);
        if (mY != null) {
            this.dTf = true;
            mY.a(this.bZU, this.dTc, this.dTe);
            return;
        }
        if (this.dEb != null && this.dEb.getThreadList() != null) {
            this.dEb.getThreadList().clear();
        }
        this.dTi.a(this.bZU, this.dTc, null, null);
    }

    public boolean hasMore() {
        if ((this.dTe instanceof at) && ((at) this.dTe).errCode == 0) {
            return ((at) this.dTe).hasMore;
        }
        return true;
    }

    private int bG(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, aq aqVar) {
        this.dTg.put(bG(i, i2), aqVar);
    }

    public aq bH(int i, int i2) {
        return this.dTg.get(bG(i, i2));
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        this.dTh.init();
    }

    @Override // com.baidu.tieba.frs.ak
    public void Za() {
        this.dTh.destory();
        this.dTh.clear();
    }

    public int azr() {
        return this.bZU;
    }

    public boolean azs() {
        return 1 == this.bZU;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.dSY != null) {
            if (this.bZU == 1) {
                this.dEb.a(aiVar);
            }
            int azt = azt();
            if (this.dSY != null && this.dSY.size() > 0) {
                int size = this.dSY.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.i iVar = this.dSY.get(i);
                    if ((iVar instanceof bd) && aiVar.getId().equals(((bd) iVar).getId())) {
                        return;
                    }
                }
            }
            if (aiVar.getThreadType() == 33) {
                ar arVar = new ar();
                arVar.a(aiVar, -1);
                arVar.setPost_num(1);
                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.dSY.add(azt, arVar);
                    return;
                }
                return;
            }
            this.dSY.add(azt, aiVar);
        }
    }

    public int azt() {
        int i = 0;
        if (this.dSY == null || this.dSY.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.i> it = this.dSY.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.i next = it.next();
                if (!(next instanceof bd)) {
                    i = i2;
                } else if (((bd) next).zi() != 0) {
                    i = i2 + 1;
                } else {
                    return i2;
                }
            } else {
                return i2;
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean azu() {
        return this.dTf;
    }

    public void azv() {
        m mVar = new m();
        if (this.dTd == 0) {
            mVar.mW(this.dTm);
        }
        if (this.dEb.getThreadList() != null) {
            this.dEb.getThreadList().clear();
            this.dEb.getThreadList().add(mVar);
        }
        if (this.dSY != null) {
            this.dSY.clear();
            this.dSY.add(mVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> azw() {
        return this.dSY;
    }

    public void nH(int i) {
        this.dTm = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.f.bxR();
        } else {
            com.baidu.tieba.tbadkCore.util.f.bxS();
        }
    }

    public void nI(int i) {
        this.dTn = i;
    }

    public void go(boolean z) {
        this.dTo = z;
    }

    public int azx() {
        return this.dTm;
    }

    public int YM() {
        return com.baidu.tieba.frs.f.f.nM(this.dTm);
    }

    public boolean azy() {
        return this.dTb;
    }

    public boolean azz() {
        return this.dTm == 5;
    }

    public boolean azA() {
        return this.dSZ != null && this.dSZ.getLoadType() == 1;
    }

    public boolean azB() {
        return this.dTm == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.dSV.auK() != null) {
            return this.dSV.auK().a(this.dTm, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bd.aOE.get() && r.bof().bnZ() != null) {
            int V = r.bof().bnZ().V(str, false);
            int W = r.bof().bnZ().W(str, false);
            if (frsRequestData.getLoadType() == 1) {
                V++;
            } else if (frsRequestData.getLoadType() == 2) {
                W++;
            }
            frsRequestData.setRefreshCount(V);
            frsRequestData.setLoadCount(W);
        }
    }

    public void azC() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.dEb != null && this.dEb.bas() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.dEb.bas().getId(), 0L));
        }
        this.dSV.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void mg(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.buI().bZ(FrsModelController.this.dTp, str);
                return null;
            }
        }, null);
    }

    public void mh(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.buI().ca(FrsModelController.this.dTp, str);
                return null;
            }
        }, null);
    }

    public void mi(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.buI().cb(FrsModelController.this.dTp, str);
                return null;
            }
        }, null);
    }
}
