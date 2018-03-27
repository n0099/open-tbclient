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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tieba.frs.x;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.j>, ak {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long bAA;
    private int bZL;
    private m dDS;
    private String dEh;
    private FrsNetModel<com.baidu.tieba.frs.i> dRW;
    private d.a dRY;
    private String dRZ;
    private final com.baidu.tieba.frs.i dSO;
    private ArrayList<com.baidu.adp.widget.ListView.i> dSR;
    private FrsRequestData dSS;
    private final o dST;
    private boolean dSU;
    private int dSV;
    private int dSW;
    private aq dSX;
    private boolean dSY;
    private SparseArray<aq> dSZ;
    private ac dTa;
    private an dTb;
    private ArrayList<com.baidu.adp.widget.ListView.i> dTc;
    private boolean dTd;
    private String dTe;
    private int dTf;
    private int dTg;
    private boolean dTh;
    private String dTi;
    private final SparseArray<Boolean> dTj;
    private an dTk;
    private long dpZ;
    private long dqa;
    private long dqb;
    private long dqc;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean nG(int i) {
        return this.dTj.get(i, false).booleanValue();
    }

    public void F(int i, boolean z) {
        this.dTj.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.i iVar, o oVar) {
        super(iVar.getPageContext());
        this.dEh = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.dRZ = null;
        this.bZL = 1;
        this.dSV = 0;
        this.dSW = 0;
        this.dSY = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.dSZ = new SparseArray<>();
        this.bAA = 0L;
        this.dTd = false;
        this.dTf = -1;
        this.dTg = -1;
        this.dTi = null;
        this.dTj = new SparseArray<>();
        this.dTk = new an() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.an
            public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
                FrsModelController.this.dSY = false;
                if (i == FrsModelController.this.bZL && FrsModelController.this.dTb != null) {
                    FrsModelController.this.dSX = atVar;
                    FrsModelController.this.b(i, i2, atVar);
                    ArrayList<com.baidu.adp.widget.ListView.i> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.dDS.au(arrayList2);
                    if ((i == 1 || i == 5) && !FrsModelController.this.azC()) {
                        FrsModelController.this.dDS.bvS();
                        FrsModelController.this.dDS.bvT();
                    }
                    FrsModelController.this.dTb.a(i, i2, atVar, arrayList);
                }
            }
        };
        this.dpZ = 0L;
        this.dqa = 0L;
        this.dqb = 0L;
        this.dqc = 0L;
        if (oVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.dSO = iVar;
        this.dST = oVar;
        y(this.dSO);
    }

    private void y(com.baidu.tieba.frs.i iVar) {
        this.dTa = new ac();
        this.dTa.bIy = iVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.dTa));
        this.dTa.a(this.dTk);
    }

    public void onActivityDestroy() {
        this.dRW.cancelLoadData();
    }

    public void l(Bundle bundle) {
        if (bundle != null) {
            this.dEh = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dTe = bundle.getString("yuelaou_locate");
            this.dSU = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.dEh)) {
            this.dEh = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.dTe)) {
            this.dTe = "";
        }
        this.mSource = this.mFrom;
        this.dSS = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            nH(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            nH(6);
        } else {
            com.baidu.tieba.frs.smartsort.f mo = com.baidu.tieba.frs.smartsort.d.azN().mo(this.dEh);
            if (mo != null) {
                nH(mo.dTW);
            } else {
                nH(-1);
            }
        }
        this.dSS.setSortType(YM());
        if (this.dTf == 5) {
            this.dSS.setIsGood(1);
        } else {
            this.dSS.setIsGood(0);
        }
        this.dDS = new m();
        this.dRW = new FrsNetModel<>(this.dSO.getPageContext(), this.dSS);
        this.dRW.a(this);
        this.dRW.setUniqueId(this.dSO.getUniqueId());
        if (this.dEh != null && this.dEh.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dEh);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean amN() {
        if (this.bZL != 1) {
            nC(1);
            return true;
        } else if (this.dRW.El()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dSS), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(YM());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void G(int i, boolean z) {
        if (this.dDS != null && this.dDS.bvl() != null) {
            this.dDS.bvl().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dSS), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bZL = c(this.bZL, frsRequestData);
        if (this.bZL == 1) {
            if (!this.dRW.El()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.dSX == null) {
            this.dSX = new aq();
            this.dSX.pn = 1;
            this.dSX.forumName = this.dEh;
            if (this.dDS != null && this.dDS.bas() != null) {
                this.dSX.forumId = this.dDS.bas().getId();
            }
        }
        nC(i);
    }

    public void nD(int i) {
        if (this.bZL != 1) {
            nC(4);
        } else if (!this.dRW.El()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dSS), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(YM());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.dST.mQ(i);
        this.dRW.a(frsRequestData);
        this.mType = i;
        frsRequestData.sz(this.dSO.avn() ? "1" : "2");
        if (this.dTh) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.f.nM(this.dTg)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.dTh = false;
        frsRequestData.setKw(this.dEh);
        if (com.baidu.tbadk.core.i.xo().xu()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ao = l.ao(TbadkCoreApplication.getInst());
        int aq = l.aq(TbadkCoreApplication.getInst());
        float ar = l.ar(TbadkCoreApplication.getInst());
        int i2 = ao.De().Dg() ? 2 : 1;
        frsRequestData.setScrW(ao);
        frsRequestData.setScrH(aq);
        frsRequestData.setScrDip(ar);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.dRZ);
        frsRequestData.setYuelaouLocate(this.dTe);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(t.Pn(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.i.dEp != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.i.dEp);
        }
        if (com.baidu.tieba.frs.i.dEq != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.i.dEq);
        }
        if (com.baidu.tieba.frs.i.dEr != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.i.dEr);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.f.a(this.dTf, frsRequestData);
        b(i, frsRequestData);
        a(this.dEh, frsRequestData);
        if (!nG(this.dTf)) {
            String d = com.baidu.tieba.tbadkCore.c.buI().d(this.dEh, frsRequestData.YM(), frsRequestData.getIsGood(), this.dSS.getCategoryId());
            this.dTi = d;
            new a(this, true, d).execute(new Object[0]);
        }
        ayX();
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

    protected boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.j jVar) {
        if (jVar == null || jVar.bas() == null || (am.isEmpty(jVar.bas().getName()) && 340001 != jVar.gZs)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bZL = jVar.bvp();
        }
        this.dDS.e(jVar);
        d(this.dDS);
        this.dSR = new ArrayList<>();
        if (frsRequestData != null) {
            this.dSS = frsRequestData;
            this.mPn = this.dSS.getPn();
            this.dEh = this.dSS.getKw();
            this.dSO.setForumName(this.dEh);
            this.dSO.setFrom(this.mFrom);
            this.dSO.setPn(this.mPn);
            this.dSO.setFlag(this.mFlag);
        }
        if (this.dDS.getThreadList() != null) {
            this.dSR.addAll(this.dDS.getThreadList());
        }
        if (this.bZL != 1 && this.isNetFirstLoad) {
            this.dST.a(7, false, this.dRY);
        } else {
            this.dST.a(this.mType, false, this.dRY);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.dSS)) {
            azD();
        }
        this.isNetFirstLoad = false;
        if (jVar.bas() == null || TextUtils.isEmpty(jVar.bas().getName()) || frsRequestData == null || r.bof().bnZ() == null) {
            return true;
        }
        r.bof().bnZ().f(jVar.bas().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.j jVar;
        d.a aVar = new d.a();
        aVar.gXJ = com.baidu.adp.lib.util.j.oJ() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gXK = mvcSocketResponsedMessage.getDownSize();
        this.dRY = aVar;
        if (mvcSocketResponsedMessage == null || (mvcSocketResponsedMessage.hasError() && 340001 != mvcSocketResponsedMessage.getError())) {
            jVar = null;
        } else {
            jVar = mvcSocketResponsedMessage.getData();
            r3 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && jVar != null && a(r3, jVar)) {
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
        this.dSO.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dTd) {
            this.dTd = true;
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
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.j> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.j jVar;
        d.a aVar = new d.a();
        aVar.gXJ = com.baidu.adp.lib.util.j.oJ() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gXK = mvcHttpResponsedMessage.getDownSize();
        this.dRY = aVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            jVar = null;
        } else {
            jVar = mvcHttpResponsedMessage.getData();
            r3 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && jVar != null && a(r3, jVar)) {
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
        this.dSO.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        super.registerListener(i, aVar);
    }

    private void b(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.j> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
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
        if (!this.dTd) {
            this.dTd = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void avh() {
        if (this.dDS != null && this.dDS.bas() != null && this.dDS.bas().getBannerListData() != null) {
            String lastIds = this.dDS.bas().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dRZ = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (p.Ow().Ox()) {
            this.bAA = System.currentTimeMillis() - this.dSO.beginTime;
            com.baidu.tbadk.k.l lVar = new com.baidu.tbadk.k.l(i, z, responsedMessage, this.dSO.bAr, this.dSO.createTime, this.dSO.bAz, false, this.bAA);
            this.dSO.createTime = 0L;
            this.dSO.bAr = 0L;
            if (lVar != null) {
                lVar.Or();
            }
        }
    }

    public FrsRequestData azn() {
        return this.dSS;
    }

    public String azo() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.dEh;
    }

    public int getPn() {
        return this.mPn;
    }

    public m ayW() {
        return this.dDS;
    }

    public d.a azp() {
        return this.dRY;
    }

    private void ayX() {
        this.dpZ = System.currentTimeMillis();
        this.dRW.Nw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.j jVar) {
        this.isCacheFirstLoad = false;
        this.dDS.e(jVar);
        d(this.dDS);
        this.dSR = new ArrayList<>();
        if (this.dDS.getThreadList() != null) {
            this.dSR.addAll(this.dDS.getThreadList());
        }
        this.dST.b(jVar);
    }

    private void d(m mVar) {
        if (com.baidu.tieba.frs.g.f.h(mVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.g.f.i(mVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.j, Void> {
        private String dTo;
        private FrsModelController dTp;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.dTo = null;
            this.dTo = str;
            this.dTp = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.buI().sx(this.dTo)) {
                if (!com.baidu.tieba.tbadkCore.c.buI().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.dTo)) {
                    com.baidu.tieba.tbadkCore.c.buI().getResponseData().bas().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.j responseData = com.baidu.tieba.tbadkCore.c.buI().getResponseData();
                if (responseData.bvr() != null && !StringUtils.isNull(responseData.bvr().xT(), true) && !responseData.bvr().xT().equals("0") && responseData.bvr().xU() == 3 && (h = com.baidu.adp.lib.g.b.h(responseData.bvr().xT(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(h))) != null) {
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
        public void onProgressUpdate(com.baidu.tieba.tbadkCore.j... jVarArr) {
            super.onProgressUpdate(jVarArr);
            if (this.dTp != null && jVarArr != null) {
                this.dTp.d(jVarArr.length > 0 ? jVarArr[0] : null);
                this.dTp.F(this.dTp.dTf, true);
            }
        }
    }

    public long aqO() {
        return this.dqc;
    }

    public long aqP() {
        return this.dqa;
    }

    public long aqQ() {
        return this.dqb;
    }

    public long aqR() {
        return this.dpZ;
    }

    public boolean El() {
        return this.dRW.El();
    }

    public int azq() {
        return this.dSW;
    }

    private void azr() {
        if (this.dTc == null) {
            this.dTc = new ArrayList<>();
        }
        if (this.dTc.size() == 0) {
            this.dTc.add(new x());
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, aq aqVar) {
        this.bZL = c(i, null);
        if (aqVar == null && (aqVar = bH(i, i2)) == null) {
            if (i != 1 && l.pa() && this.dTb != null) {
                at atVar = new at();
                atVar.hasMore = false;
                atVar.pn = 1;
                atVar.forumName = this.dEh;
                atVar.dHC = false;
                if (this.dDS != null && this.dDS.bas() != null) {
                    atVar.forumId = this.dDS.bas().getId();
                }
                azr();
                this.dDS.au(this.dTc);
                this.dTb.a(i, i2, atVar, this.dTc);
            }
            aqVar = new aq();
            aqVar.pn = -1;
        }
        if (this.dDS != null && this.dDS.bas() != null) {
            aqVar.forumId = this.dDS.bas().getId();
        }
        aqVar.forumName = this.dEh;
        if (aa.awm().mX(1) != null && this.bZL == 1) {
            this.dSS.setCategoryId(i2);
        }
        this.dSV = i2;
        this.dSX = aqVar;
        b(i, i2, aqVar);
        nC(5);
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(an anVar) {
        this.dTb = anVar;
        this.dTa.a(this.dTk);
    }

    private void nC(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.dSX != null) {
                    this.dSX.pn++;
                    break;
                }
                break;
            case 2:
                if (this.dSX != null) {
                    aq aqVar = this.dSX;
                    aqVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.dSX != null) {
                    this.dSX.pn = -1;
                    break;
                }
                break;
        }
        if (this.bZL == 1) {
            if (this.dSW == this.dSV) {
                ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
                if (this.dSR != null) {
                    arrayList.addAll(this.dSR);
                }
                this.dDS.au(arrayList);
                if (this.dTb != null) {
                    this.dTb.a(this.bZL, this.dSV, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.dSW = this.dSV;
            return;
        }
        ak mY = this.dTa.mY(this.bZL);
        if (mY != null) {
            this.dSY = true;
            mY.a(this.bZL, this.dSV, this.dSX);
            return;
        }
        if (this.dDS != null && this.dDS.getThreadList() != null) {
            this.dDS.getThreadList().clear();
        }
        this.dTb.a(this.bZL, this.dSV, null, null);
    }

    public boolean hasMore() {
        if ((this.dSX instanceof at) && ((at) this.dSX).errCode == 0) {
            return ((at) this.dSX).hasMore;
        }
        return true;
    }

    private int bG(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, aq aqVar) {
        this.dSZ.put(bG(i, i2), aqVar);
    }

    public aq bH(int i, int i2) {
        return this.dSZ.get(bG(i, i2));
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        this.dTa.init();
    }

    @Override // com.baidu.tieba.frs.ak
    public void Za() {
        this.dTa.destory();
        this.dTa.clear();
    }

    public int azs() {
        return this.bZL;
    }

    public boolean azt() {
        return 1 == this.bZL;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.dSR != null) {
            if (this.bZL == 1) {
                this.dDS.a(aiVar);
            }
            int azu = azu();
            if (this.dSR != null && this.dSR.size() > 0) {
                int size = this.dSR.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.i iVar = this.dSR.get(i);
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
                    this.dSR.add(azu, arVar);
                    return;
                }
                return;
            }
            this.dSR.add(azu, aiVar);
        }
    }

    public int azu() {
        int i = 0;
        if (this.dSR == null || this.dSR.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.i> it = this.dSR.iterator();
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

    public boolean azv() {
        return this.dSY;
    }

    public void azw() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.dSW == 0) {
            mVar.mW(this.dTf);
        }
        if (this.dDS.getThreadList() != null) {
            this.dDS.getThreadList().clear();
            this.dDS.getThreadList().add(mVar);
        }
        if (this.dSR != null) {
            this.dSR.clear();
            this.dSR.add(mVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> azx() {
        return this.dSR;
    }

    public void nH(int i) {
        this.dTf = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.f.bxV();
        } else {
            com.baidu.tieba.tbadkCore.util.f.bxW();
        }
    }

    public void nI(int i) {
        this.dTg = i;
    }

    public void gq(boolean z) {
        this.dTh = z;
    }

    public int azy() {
        return this.dTf;
    }

    public int YM() {
        return com.baidu.tieba.frs.f.f.nM(this.dTf);
    }

    public boolean azz() {
        return this.dSU;
    }

    public boolean azA() {
        return this.dTf == 5;
    }

    public boolean azB() {
        return this.dSS != null && this.dSS.getLoadType() == 1;
    }

    public boolean azC() {
        return this.dTf == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.dSO.auK() != null) {
            return this.dSO.auK().a(this.dTf, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bd.aOu.get() && r.bof().bnZ() != null) {
            int U = r.bof().bnZ().U(str, false);
            int V = r.bof().bnZ().V(str, false);
            if (frsRequestData.getLoadType() == 1) {
                U++;
            } else if (frsRequestData.getLoadType() == 2) {
                V++;
            }
            frsRequestData.setRefreshCount(U);
            frsRequestData.setLoadCount(V);
        }
    }

    public void azD() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.dDS != null && this.dDS.bas() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.dDS.bas().getId(), 0L));
        }
        this.dSO.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void mg(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.buI().bZ(FrsModelController.this.dTi, str);
                return null;
            }
        }, null);
    }

    public void mh(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.buI().ca(FrsModelController.this.dTi, str);
                return null;
            }
        }, null);
    }

    public void mi(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.buI().cb(FrsModelController.this.dTi, str);
                return null;
            }
        }, null);
    }
}
