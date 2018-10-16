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
    private FrsNetModel<FrsFragment> dRi;
    private String dRk;
    private int dSA;
    private boolean dSB;
    private String dSC;
    private final SparseArray<Boolean> dSD;
    private al dSE;
    private final FrsFragment dSf;
    private ArrayList<com.baidu.adp.widget.ListView.h> dSk;
    private FrsRequestData dSl;
    private final n dSm;
    private boolean dSn;
    private int dSo;
    private int dSp;
    private int dSq;
    private ao dSr;
    private boolean dSs;
    private SparseArray<ao> dSt;
    private aa dSu;
    private al dSv;
    private ArrayList<com.baidu.adp.widget.ListView.h> dSw;
    private boolean dSx;
    private String dSy;
    private int dSz;
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
        return this.dSD.get(i, false).booleanValue();
    }

    public void q(int i, boolean z) {
        this.dSD.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.dAf = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.dSo = 0;
        this.mSource = null;
        this.dRk = null;
        this.bIM = 1;
        this.dSp = 0;
        this.dSq = 0;
        this.dSs = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.dSt = new SparseArray<>();
        this.bbJ = 0L;
        this.dSx = false;
        this.dSz = -1;
        this.dSA = -1;
        this.dSC = null;
        this.dSD = new SparseArray<>();
        this.dSE = new al() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.al
            public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
                FrsModelController.this.dSs = false;
                if (i == FrsModelController.this.bIM && FrsModelController.this.dSv != null) {
                    FrsModelController.this.dSr = arVar;
                    FrsModelController.this.b(i, i2, arVar);
                    ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.dzP.ay(arrayList2);
                    FrsModelController.this.dSv.a(i, i2, arVar, arrayList);
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
        this.dSf = frsFragment;
        this.dSm = nVar;
        D(this.dSf);
    }

    private void D(FrsFragment frsFragment) {
        this.dSu = new aa();
        this.dSu.aZt = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.dSu));
        this.dSu.a(this.dSE);
    }

    public void onActivityDestroy() {
        this.dRi.cancelLoadData();
    }

    public void j(Bundle bundle) {
        if (bundle != null) {
            this.dAf = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dSy = bundle.getString("yuelaou_locate");
            this.dSn = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.dSo = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
        }
        if (TextUtils.isEmpty(this.dAf)) {
            this.dAf = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.dSy)) {
            this.dSy = "";
        }
        this.mSource = this.mFrom;
        aEZ();
        this.dzP = new l();
        this.dRi = new FrsNetModel<>(this.dSf.getPageContext(), this.dSl);
        this.dRi.a(this);
        this.dRi.setUniqueId(this.dSf.getUniqueId());
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
        this.dSl = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            mt(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            mt(6);
        } else {
            mt(com.baidu.tieba.frs.f.g.ok(this.dAf));
        }
        this.dSl.setSortType(aaI());
        if (this.dSz == 5) {
            this.dSl.setIsGood(1);
        } else {
            this.dSl.setIsGood(0);
        }
    }

    public boolean apz() {
        if (this.bIM != 1) {
            mo(1);
            return true;
        } else if (this.dRi.DU()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dSl), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(aaI());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void r(int i, boolean z) {
        this.dSf.dAo = System.currentTimeMillis();
        if (this.dzP != null && this.dzP.bAm() != null) {
            this.dzP.bAm().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dSl), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bIM = c(this.bIM, frsRequestData);
        if (this.bIM == 1) {
            if (!this.dRi.DU()) {
                frsRequestData.setCallFrom(this.dSo);
                a(frsRequestData, i, z ? false : true);
                this.dSo = 0;
                return;
            }
            return;
        }
        if (this.dSr == null) {
            this.dSr = new ao();
            this.dSr.pn = 1;
            this.dSr.forumName = this.dAf;
            if (this.dzP != null && this.dzP.beT() != null) {
                this.dSr.forumId = this.dzP.beT().getId();
            }
        }
        mo(i);
    }

    public void mp(int i) {
        if (this.bIM != 1) {
            mo(4);
        } else if (!this.dRi.DU()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dSl), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(aaI());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.dSf.gg(z);
        this.dSm.lq(i);
        this.dRi.a(frsRequestData);
        this.mType = i;
        frsRequestData.uL(this.dSf.azT() ? "1" : "2");
        if (this.dSB) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.mJ(this.dSA)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.dSB = false;
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
        frsRequestData.setLastId(this.dRk);
        frsRequestData.setYuelaouLocate(this.dSy);
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
        com.baidu.tieba.frs.f.g.a(this.dSz, frsRequestData);
        b(i, frsRequestData);
        a(this.dAf, frsRequestData);
        if (!ms(this.dSz) && !this.dSf.dAg) {
            String d = com.baidu.tieba.tbadkCore.c.bzN().d(this.dAf, frsRequestData.aaI(), frsRequestData.getIsGood(), this.dSl.getCategoryId());
            this.dSC = d;
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
        this.dzP.e(iVar);
        e(this.dzP);
        this.dSk = new ArrayList<>();
        if (frsRequestData != null) {
            this.dSl = frsRequestData;
            this.mPn = this.dSl.getPn();
            this.dAf = this.dSl.getKw();
            this.dSf.setForumName(this.dAf);
            this.dSf.setFrom(this.mFrom);
            this.dSf.setPn(this.mPn);
            this.dSf.setFlag(this.mFlag);
        }
        if (this.dzP.getThreadList() != null) {
            this.dSk.addAll(this.dzP.getThreadList());
        }
        if (this.bIM != 1 && this.isNetFirstLoad) {
            this.dSm.a(7, false, this.dHw);
        } else {
            this.dSm.a(this.mType, false, this.dHw);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.dSl)) {
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
        aVar.gZz = com.baidu.adp.lib.util.j.kX() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gZA = mvcSocketResponsedMessage.getDownSize();
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
        this.dSf.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dSx) {
            this.dSx = true;
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
        aVar.gZz = com.baidu.adp.lib.util.j.kX() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gZA = mvcHttpResponsedMessage.getDownSize();
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
        this.dSf.a(errorData);
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
        if (!this.dSx) {
            this.dSx = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void azO() {
        if (this.dzP != null && this.dzP.beT() != null && this.dzP.beT().getBannerListData() != null) {
            String lastIds = this.dzP.beT().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dRk = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.NX().NY()) {
            this.bbJ = System.currentTimeMillis() - this.dSf.beginTime;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(i, z, responsedMessage, this.dSf.bbA, this.dSf.createTime, this.dSf.bbI, false, this.bbJ);
            this.dSf.createTime = 0L;
            this.dSf.bbA = 0L;
            if (iVar != null) {
                iVar.NU();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.NX().NY()) {
            this.bbJ = System.currentTimeMillis() - this.dSf.dAo;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(1000, z, responsedMessage, this.dSf.bbA, this.dSf.createTime, this.dSf.bbI, false, this.bbJ);
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
        return this.dSl;
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
        this.dRi.Nj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.dzP.e(iVar);
        e(this.dzP);
        this.dSk = new ArrayList<>();
        if (this.dzP.getThreadList() != null) {
            this.dSk.addAll(this.dzP.getThreadList());
        }
        this.dSm.b(iVar);
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
        private String dSI;
        private FrsModelController dSJ;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.dSI = null;
            this.dSI = str;
            this.dSJ = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bzN().uJ(this.dSI)) {
                if (!com.baidu.tieba.tbadkCore.c.bzN().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.dSI)) {
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
            if (this.dSJ != null && iVarArr != null) {
                this.dSJ.d(iVarArr.length > 0 ? iVarArr[0] : null);
                this.dSJ.q(this.dSJ.dSz, true);
            }
        }
    }

    public long aun() {
        return this.dhD;
    }

    public long auo() {
        return this.dhB;
    }

    public long aup() {
        return this.dhC;
    }

    public long auq() {
        return this.dhA;
    }

    public boolean DU() {
        return this.dRi.DU();
    }

    public int aFc() {
        return this.dSq;
    }

    private void aFd() {
        if (this.dSw == null) {
            this.dSw = new ArrayList<>();
        }
        if (this.dSw.size() == 0) {
            this.dSw.add(new com.baidu.tieba.frs.v());
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        this.bIM = c(i, null);
        if (aoVar == null && (aoVar = aU(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.lo() && this.dSv != null) {
                ar arVar = new ar();
                arVar.hasMore = false;
                arVar.pn = 1;
                arVar.forumName = this.dAf;
                arVar.dEd = false;
                if (this.dzP != null && this.dzP.beT() != null) {
                    arVar.forumId = this.dzP.beT().getId();
                }
                aFd();
                this.dzP.ay(this.dSw);
                this.dSv.a(i, i2, arVar, this.dSw);
            }
            aoVar = new ao();
            aoVar.pn = -1;
        }
        if (this.dzP != null && this.dzP.beT() != null) {
            aoVar.forumId = this.dzP.beT().getId();
        }
        aoVar.forumName = this.dAf;
        if (y.aBj().lF(1) != null && this.bIM == 1) {
            this.dSl.setCategoryId(i2);
        }
        this.dSp = i2;
        this.dSr = aoVar;
        b(i, i2, aoVar);
        mo(5);
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.dSv = alVar;
        this.dSu.a(this.dSE);
    }

    private void mo(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.dSr != null) {
                    this.dSr.pn++;
                    break;
                }
                break;
            case 2:
                if (this.dSr != null) {
                    ao aoVar = this.dSr;
                    aoVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.dSr != null) {
                    this.dSr.pn = -1;
                    break;
                }
                break;
        }
        if (this.bIM == 1) {
            if (this.dSq == this.dSp) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                if (this.dSk != null) {
                    arrayList.addAll(this.dSk);
                }
                this.dzP.ay(arrayList);
                if (this.dSv != null) {
                    this.dSv.a(this.bIM, this.dSp, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.dSq = this.dSp;
            return;
        }
        ai lG = this.dSu.lG(this.bIM);
        if (lG != null) {
            this.dSs = true;
            lG.a(this.bIM, this.dSp, this.dSr);
            return;
        }
        if (this.dzP != null && this.dzP.getThreadList() != null) {
            this.dzP.getThreadList().clear();
        }
        this.dSv.a(this.bIM, this.dSp, null, null);
    }

    public boolean hasMore() {
        if ((this.dSr instanceof ar) && ((ar) this.dSr).errCode == 0) {
            return ((ar) this.dSr).hasMore;
        }
        return true;
    }

    private int aT(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ao aoVar) {
        this.dSt.put(aT(i, i2), aoVar);
    }

    public ao aU(int i, int i2) {
        return this.dSt.get(aT(i, i2));
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        this.dSu.init();
    }

    @Override // com.baidu.tieba.frs.ai
    public void aaU() {
        this.dSu.destory();
        this.dSu.clear();
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
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && !com.baidu.tbadk.core.util.v.J(this.dSk)) {
            if (this.bIM == 1) {
                this.dzP.a(aiVar);
            }
            int aFg = aFg();
            Iterator<com.baidu.adp.widget.ListView.h> it = this.dSk.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if ((next instanceof bb) && aiVar.getId().equals(((bb) next).getId())) {
                    return;
                }
            }
            this.dSk.add(aFg, aiVar);
        }
    }

    public int aFg() {
        int i = 0;
        if (this.dSk == null || this.dSk.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.dSk.iterator();
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
        return this.dSs;
    }

    public void aFi() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.dSq == 0) {
            mVar.lA(this.dSz);
        }
        if (this.dzP.getThreadList() != null) {
            this.dzP.getThreadList().clear();
            this.dzP.getThreadList().add(mVar);
        }
        if (this.dSk != null) {
            this.dSk.clear();
            this.dSk.add(mVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aFj() {
        return this.dSk;
    }

    public void mt(int i) {
        this.dSz = i;
        com.baidu.tieba.frs.f.g.ad(this.dAf, this.dSz);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.bCZ();
        } else {
            com.baidu.tieba.tbadkCore.util.e.bDa();
        }
    }

    public void mu(int i) {
        this.dSA = i;
    }

    public void gZ(boolean z) {
        this.dSB = z;
    }

    public int aFk() {
        return this.dSz;
    }

    public int aaI() {
        return com.baidu.tieba.frs.f.g.mJ(this.dSz);
    }

    public boolean aFl() {
        return this.dSn;
    }

    public boolean aFm() {
        return this.dSz == 5;
    }

    public boolean aFn() {
        return this.dSl != null && this.dSl.getLoadType() == 1;
    }

    public boolean aFo() {
        return this.dSz == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.dSf.azr() != null) {
            return this.dSf.azr().a(this.dSz, frsRequestData);
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
        this.dSf.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void nZ(final String str) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bzN().cC(FrsModelController.this.dSC, str);
                return null;
            }
        }, null);
    }

    public void oa(final String str) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bzN().cD(FrsModelController.this.dSC, str);
                return null;
            }
        }, null);
    }

    public void ob(final String str) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bzN().cE(FrsModelController.this.dSC, str);
                return null;
            }
        }, null);
    }
}
