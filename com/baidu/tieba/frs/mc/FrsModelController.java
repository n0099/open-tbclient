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
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.l.m;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.i>, ai {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private int bIM;
    private long bbJ;
    private String dAf;
    private d.a dHw;
    private FrsNetModel<FrsFragment> dRj;
    private String dRl;
    private int dSA;
    private int dSB;
    private boolean dSC;
    private String dSD;
    private final SparseArray<Boolean> dSE;
    private al dSF;
    private final FrsFragment dSg;
    private ArrayList<com.baidu.adp.widget.ListView.h> dSl;
    private FrsRequestData dSm;
    private final n dSn;
    private boolean dSo;
    private int dSp;
    private int dSq;
    private int dSr;
    private ao dSs;
    private boolean dSt;
    private SparseArray<ao> dSu;
    private aa dSv;
    private al dSw;
    private ArrayList<com.baidu.adp.widget.ListView.h> dSx;
    private boolean dSy;
    private String dSz;
    private long dhA;
    private long dhB;
    private long dhC;
    private long dhD;
    private l dzP;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean ms(int i) {
        return this.dSE.get(i, false).booleanValue();
    }

    public void q(int i, boolean z) {
        this.dSE.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.dAf = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.dSp = 0;
        this.mSource = null;
        this.dRl = null;
        this.bIM = 1;
        this.dSq = 0;
        this.dSr = 0;
        this.dSt = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.dSu = new SparseArray<>();
        this.bbJ = 0L;
        this.dSy = false;
        this.dSA = -1;
        this.dSB = -1;
        this.dSD = null;
        this.dSE = new SparseArray<>();
        this.dSF = new al() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.al
            public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
                FrsModelController.this.dSt = false;
                if (i == FrsModelController.this.bIM && FrsModelController.this.dSw != null) {
                    FrsModelController.this.dSs = arVar;
                    FrsModelController.this.b(i, i2, arVar);
                    ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.dzP.ay(arrayList2);
                    FrsModelController.this.dSw.a(i, i2, arVar, arrayList);
                }
            }
        };
        this.dhA = 0L;
        this.dhB = 0L;
        this.dhC = 0L;
        this.dhD = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.dSg = frsFragment;
        this.dSn = nVar;
        D(this.dSg);
    }

    private void D(FrsFragment frsFragment) {
        this.dSv = new aa();
        this.dSv.aZt = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.dSv));
        this.dSv.a(this.dSF);
    }

    public void onActivityDestroy() {
        this.dRj.cancelLoadData();
    }

    public void j(Bundle bundle) {
        if (bundle != null) {
            this.dAf = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dSz = bundle.getString("yuelaou_locate");
            this.dSo = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.dSp = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
        }
        if (TextUtils.isEmpty(this.dAf)) {
            this.dAf = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.dSz)) {
            this.dSz = "";
        }
        this.mSource = this.mFrom;
        aEZ();
        this.dzP = new l();
        this.dRj = new FrsNetModel<>(this.dSg.getPageContext(), this.dSm);
        this.dRj.a(this);
        this.dRj.setUniqueId(this.dSg.getUniqueId());
        if (this.dAf != null && this.dAf.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dAf);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void aEZ() {
        this.dSm = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            mt(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            mt(6);
        } else {
            mt(com.baidu.tieba.frs.f.g.ok(this.dAf));
        }
        this.dSm.setSortType(aaJ());
        if (this.dSA == 5) {
            this.dSm.setIsGood(1);
        } else {
            this.dSm.setIsGood(0);
        }
    }

    public boolean apA() {
        if (this.bIM != 1) {
            mo(1);
            return true;
        } else if (this.dRj.DU()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dSm), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(aaJ());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void r(int i, boolean z) {
        this.dSg.dAo = System.currentTimeMillis();
        if (this.dzP != null && this.dzP.bAm() != null) {
            this.dzP.bAm().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dSm), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bIM = c(this.bIM, frsRequestData);
        if (this.bIM == 1) {
            if (!this.dRj.DU()) {
                frsRequestData.setCallFrom(this.dSp);
                a(frsRequestData, i, z ? false : true);
                this.dSp = 0;
                return;
            }
            return;
        }
        if (this.dSs == null) {
            this.dSs = new ao();
            this.dSs.pn = 1;
            this.dSs.forumName = this.dAf;
            if (this.dzP != null && this.dzP.beT() != null) {
                this.dSs.forumId = this.dzP.beT().getId();
            }
        }
        mo(i);
    }

    public void mp(int i) {
        if (this.bIM != 1) {
            mo(4);
        } else if (!this.dRj.DU()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dSm), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(aaJ());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.dSg.gg(z);
        this.dSn.lq(i);
        this.dRj.a(frsRequestData);
        this.mType = i;
        frsRequestData.uL(this.dSg.azU() ? "1" : "2");
        if (this.dSC) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.mJ(this.dSB)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.dSC = false;
        frsRequestData.setKw(this.dAf);
        if (com.baidu.tbadk.core.i.ws().ww()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst());
        float aR = com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
        int i2 = aq.CG().CI() ? 2 : 1;
        frsRequestData.setScrW(aO);
        frsRequestData.setScrH(aQ);
        frsRequestData.setScrDip(aR);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.dRl);
        frsRequestData.setYuelaouLocate(this.dSz);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.d(v.OQ(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.dAp != 0) {
            frsRequestData.setCtime((int) FrsFragment.dAp);
        }
        if (FrsFragment.dAq != 0) {
            frsRequestData.setDataSize((int) FrsFragment.dAq);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.g.a(this.dSA, frsRequestData);
        b(i, frsRequestData);
        a(this.dAf, frsRequestData);
        if (!ms(this.dSA) && !this.dSg.dAg) {
            String d = com.baidu.tieba.tbadkCore.c.bzN().d(this.dAf, frsRequestData.aaJ(), frsRequestData.getIsGood(), this.dSm.getCategoryId());
            this.dSD = d;
            new a(this, true, d).execute(new Object[0]);
        }
        aEF();
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
        if (iVar == null || iVar.beT() == null || (com.baidu.tbadk.core.util.ao.isEmpty(iVar.beT().getName()) && 340001 != iVar.dHx)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bIM = iVar.bAq();
        }
        this.dzP.f(iVar);
        e(this.dzP);
        this.dSl = new ArrayList<>();
        if (frsRequestData != null) {
            this.dSm = frsRequestData;
            this.mPn = this.dSm.getPn();
            this.dAf = this.dSm.getKw();
            this.dSg.setForumName(this.dAf);
            this.dSg.setFrom(this.mFrom);
            this.dSg.setPn(this.mPn);
            this.dSg.setFlag(this.mFlag);
        }
        if (this.dzP.getThreadList() != null) {
            this.dSl.addAll(this.dzP.getThreadList());
        }
        if (this.bIM != 1 && this.isNetFirstLoad) {
            this.dSn.a(7, false, this.dHw);
        } else {
            this.dSn.a(this.mType, false, this.dHw);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.dSm)) {
            aFp();
        }
        this.isNetFirstLoad = false;
        if (iVar.beT() == null || TextUtils.isEmpty(iVar.beT().getName()) || frsRequestData == null || r.btk().bte() == null) {
            return true;
        }
        r.btk().bte().f(iVar.beT().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.gZA = com.baidu.adp.lib.util.j.kX() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gZB = mvcSocketResponsedMessage.getDownSize();
        this.dHw = aVar;
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
        this.dSg.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dSy) {
            this.dSy = true;
            a(1000, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        }
        a(false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
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
        aVar.gZA = com.baidu.adp.lib.util.j.kX() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gZB = mvcHttpResponsedMessage.getDownSize();
        this.dHw = aVar;
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
        this.dSg.a(errorData);
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
        if (!this.dSy) {
            this.dSy = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void azP() {
        if (this.dzP != null && this.dzP.beT() != null && this.dzP.beT().getBannerListData() != null) {
            String lastIds = this.dzP.beT().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dRl = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.NX().NY()) {
            this.bbJ = System.currentTimeMillis() - this.dSg.beginTime;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(i, z, responsedMessage, this.dSg.bbA, this.dSg.createTime, this.dSg.bbI, false, this.bbJ);
            this.dSg.createTime = 0L;
            this.dSg.bbA = 0L;
            if (iVar != null) {
                iVar.NU();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.NX().NY()) {
            this.bbJ = System.currentTimeMillis() - this.dSg.dAo;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(1000, z, responsedMessage, this.dSg.bbA, this.dSg.createTime, this.dSg.bbI, false, this.bbJ);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.bbR = this.bbJ;
                    iVar.ct(true);
                } else if (this.mType == 3) {
                    iVar.bbS = this.bbJ;
                    iVar.ct(false);
                }
            }
        }
    }

    public FrsRequestData aFa() {
        return this.dSm;
    }

    public String getPageType() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public int getPn() {
        return this.mPn;
    }

    public l aEE() {
        return this.dzP;
    }

    public d.a aFb() {
        return this.dHw;
    }

    private void aEF() {
        this.dhA = System.currentTimeMillis();
        this.dRj.Nj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.dzP.f(iVar);
        e(this.dzP);
        this.dSl = new ArrayList<>();
        if (this.dzP.getThreadList() != null) {
            this.dSl.addAll(this.dzP.getThreadList());
        }
        this.dSn.b(iVar);
    }

    private void e(l lVar) {
        if (com.baidu.tieba.frs.vc.f.j(lVar)) {
            this.mPageType = "book_page";
        } else if (lVar.bAV()) {
            this.mPageType = "brand_page";
        } else if (com.baidu.tieba.frs.vc.f.k(lVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.i, Void> {
        private String dSJ;
        private FrsModelController dSK;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.dSJ = null;
            this.dSJ = str;
            this.dSK = frsModelController;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            int l;
            CustomResponsedMessage runTask;
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bzN().uJ(this.dSJ)) {
                if (!com.baidu.tieba.tbadkCore.c.bzN().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.dSJ)) {
                    com.baidu.tieba.tbadkCore.c.bzN().getResponseData().beT().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.i responseData = com.baidu.tieba.tbadkCore.c.bzN().getResponseData();
                responseData.nc(false);
                if (responseData.bAs() != null && !StringUtils.isNull(responseData.bAs().wY(), true) && !responseData.bAs().wY().equals("0") && responseData.bAs().wZ() == 3 && (l = com.baidu.adp.lib.g.b.l(responseData.bAs().wY(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(l))) != null) {
                    responseData.q(Integer.valueOf(((Integer) runTask.getData()).intValue()));
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
            if (this.dSK != null && iVarArr != null) {
                this.dSK.e(iVarArr.length > 0 ? iVarArr[0] : null);
                this.dSK.q(this.dSK.dSA, true);
            }
        }
    }

    public long auo() {
        return this.dhD;
    }

    public long aup() {
        return this.dhB;
    }

    public long auq() {
        return this.dhC;
    }

    public long aur() {
        return this.dhA;
    }

    public boolean DU() {
        return this.dRj.DU();
    }

    public int aFc() {
        return this.dSr;
    }

    private void aFd() {
        if (this.dSx == null) {
            this.dSx = new ArrayList<>();
        }
        if (this.dSx.size() == 0) {
            this.dSx.add(new com.baidu.tieba.frs.v());
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        this.bIM = c(i, null);
        if (aoVar == null && (aoVar = aU(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.lo() && this.dSw != null) {
                ar arVar = new ar();
                arVar.hasMore = false;
                arVar.pn = 1;
                arVar.forumName = this.dAf;
                arVar.dEd = false;
                if (this.dzP != null && this.dzP.beT() != null) {
                    arVar.forumId = this.dzP.beT().getId();
                }
                aFd();
                this.dzP.ay(this.dSx);
                this.dSw.a(i, i2, arVar, this.dSx);
            }
            aoVar = new ao();
            aoVar.pn = -1;
        }
        if (this.dzP != null && this.dzP.beT() != null) {
            aoVar.forumId = this.dzP.beT().getId();
        }
        aoVar.forumName = this.dAf;
        if (y.aBk().lF(1) != null && this.bIM == 1) {
            this.dSm.setCategoryId(i2);
        }
        this.dSq = i2;
        this.dSs = aoVar;
        b(i, i2, aoVar);
        mo(5);
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.dSw = alVar;
        this.dSv.a(this.dSF);
    }

    private void mo(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.dSs != null) {
                    this.dSs.pn++;
                    break;
                }
                break;
            case 2:
                if (this.dSs != null) {
                    ao aoVar = this.dSs;
                    aoVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.dSs != null) {
                    this.dSs.pn = -1;
                    break;
                }
                break;
        }
        if (this.bIM == 1) {
            if (this.dSr == this.dSq) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                if (this.dSl != null) {
                    arrayList.addAll(this.dSl);
                }
                this.dzP.ay(arrayList);
                if (this.dSw != null) {
                    this.dSw.a(this.bIM, this.dSq, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.dSr = this.dSq;
            return;
        }
        ai lG = this.dSv.lG(this.bIM);
        if (lG != null) {
            this.dSt = true;
            lG.a(this.bIM, this.dSq, this.dSs);
            return;
        }
        if (this.dzP != null && this.dzP.getThreadList() != null) {
            this.dzP.getThreadList().clear();
        }
        this.dSw.a(this.bIM, this.dSq, null, null);
    }

    public boolean hasMore() {
        if ((this.dSs instanceof ar) && ((ar) this.dSs).errCode == 0) {
            return ((ar) this.dSs).hasMore;
        }
        return true;
    }

    private int aT(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ao aoVar) {
        this.dSu.put(aT(i, i2), aoVar);
    }

    public ao aU(int i, int i2) {
        return this.dSu.get(aT(i, i2));
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        this.dSv.init();
    }

    @Override // com.baidu.tieba.frs.ai
    public void aaV() {
        this.dSv.destory();
        this.dSv.clear();
    }

    public int aFe() {
        return this.bIM;
    }

    public boolean aFf() {
        return 1 == this.bIM;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(com.baidu.tbadk.core.data.ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && !com.baidu.tbadk.core.util.v.J(this.dSl)) {
            if (this.bIM == 1) {
                this.dzP.a(aiVar);
            }
            int aFg = aFg();
            Iterator<com.baidu.adp.widget.ListView.h> it = this.dSl.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if ((next instanceof bb) && aiVar.getId().equals(((bb) next).getId())) {
                    return;
                }
            }
            this.dSl.add(aFg, aiVar);
        }
    }

    public int aFg() {
        int i = 0;
        if (this.dSl == null || this.dSl.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.dSl.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (!(next instanceof bb)) {
                    i = i2;
                } else if (((bb) next).yq() != 0) {
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

    public boolean aFh() {
        return this.dSt;
    }

    public void aFi() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.dSr == 0) {
            mVar.lA(this.dSA);
        }
        if (this.dzP.getThreadList() != null) {
            this.dzP.getThreadList().clear();
            this.dzP.getThreadList().add(mVar);
        }
        if (this.dSl != null) {
            this.dSl.clear();
            this.dSl.add(mVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aFj() {
        return this.dSl;
    }

    public void mt(int i) {
        this.dSA = i;
        com.baidu.tieba.frs.f.g.ad(this.dAf, this.dSA);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.bCZ();
        } else {
            com.baidu.tieba.tbadkCore.util.e.bDa();
        }
    }

    public void mu(int i) {
        this.dSB = i;
    }

    public void gZ(boolean z) {
        this.dSC = z;
    }

    public int aFk() {
        return this.dSA;
    }

    public int aaJ() {
        return com.baidu.tieba.frs.f.g.mJ(this.dSA);
    }

    public boolean aFl() {
        return this.dSo;
    }

    public boolean aFm() {
        return this.dSA == 5;
    }

    public boolean aFn() {
        return this.dSm != null && this.dSm.getLoadType() == 1;
    }

    public boolean aFo() {
        return this.dSA == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.dSg.azs() != null) {
            return this.dSg.azs().a(this.dSA, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bb.ape.get() && r.btk().bte() != null) {
            int Y = r.btk().bte().Y(str, false);
            int Z = r.btk().bte().Z(str, false);
            if (frsRequestData.getLoadType() == 1) {
                Y++;
            } else if (frsRequestData.getLoadType() == 2) {
                Z++;
            }
            frsRequestData.setRefreshCount(Y);
            frsRequestData.setLoadCount(Z);
        }
    }

    public void aFp() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.dzP != null && this.dzP.beT() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.d(this.dzP.beT().getId(), 0L));
        }
        this.dSg.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void nZ(final String str) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bzN().cC(FrsModelController.this.dSD, str);
                return null;
            }
        }, null);
    }

    public void oa(final String str) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bzN().cD(FrsModelController.this.dSD, str);
                return null;
            }
        }, null);
    }

    public void ob(final String str) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bzN().cE(FrsModelController.this.dSD, str);
                return null;
            }
        }, null);
    }
}
