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
    private int bJx;
    private long bcw;
    private l dBg;
    private String dBw;
    private FrsNetModel<FrsFragment> dSo;
    private d.a dSq;
    private String dSr;
    private SparseArray<ao> dTA;
    private aa dTB;
    private al dTC;
    private ArrayList<com.baidu.adp.widget.ListView.h> dTD;
    private boolean dTE;
    private String dTF;
    private int dTG;
    private int dTH;
    private boolean dTI;
    private String dTJ;
    private final SparseArray<Boolean> dTK;
    private al dTL;
    private final FrsFragment dTm;
    private ArrayList<com.baidu.adp.widget.ListView.h> dTr;
    private FrsRequestData dTs;
    private final n dTt;
    private boolean dTu;
    private int dTv;
    private int dTw;
    private int dTx;
    private ao dTy;
    private boolean dTz;
    private long diF;
    private long diG;
    private long diH;
    private long diI;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean mK(int i) {
        return this.dTK.get(i, false).booleanValue();
    }

    public void q(int i, boolean z) {
        this.dTK.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.dBw = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.dTv = 0;
        this.mSource = null;
        this.dSr = null;
        this.bJx = 1;
        this.dTw = 0;
        this.dTx = 0;
        this.dTz = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.dTA = new SparseArray<>();
        this.bcw = 0L;
        this.dTE = false;
        this.dTG = -1;
        this.dTH = -1;
        this.dTJ = null;
        this.dTK = new SparseArray<>();
        this.dTL = new al() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.al
            public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
                FrsModelController.this.dTz = false;
                if (i == FrsModelController.this.bJx && FrsModelController.this.dTC != null) {
                    FrsModelController.this.dTy = arVar;
                    FrsModelController.this.b(i, i2, arVar);
                    ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.dBg.ax(arrayList2);
                    FrsModelController.this.dTC.a(i, i2, arVar, arrayList);
                }
            }
        };
        this.diF = 0L;
        this.diG = 0L;
        this.diH = 0L;
        this.diI = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.dTm = frsFragment;
        this.dTt = nVar;
        D(this.dTm);
    }

    private void D(FrsFragment frsFragment) {
        this.dTB = new aa();
        this.dTB.bag = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.dTB));
        this.dTB.a(this.dTL);
    }

    public void onActivityDestroy() {
        this.dSo.cancelLoadData();
    }

    public void m(Bundle bundle) {
        if (bundle != null) {
            this.dBw = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dTF = bundle.getString("yuelaou_locate");
            this.dTu = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.dTv = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
        }
        if (TextUtils.isEmpty(this.dBw)) {
            this.dBw = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.dTF)) {
            this.dTF = "";
        }
        this.mSource = this.mFrom;
        aEv();
        this.dBg = new l();
        this.dSo = new FrsNetModel<>(this.dTm.getPageContext(), this.dTs);
        this.dSo.a(this);
        this.dSo.setUniqueId(this.dTm.getUniqueId());
        if (this.dBw != null && this.dBw.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dBw);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void aEv() {
        this.dTs = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            mL(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            mL(6);
        } else {
            mL(com.baidu.tieba.frs.f.g.ol(this.dBw));
        }
        this.dTs.setSortType(aaT());
        if (this.dTG == 5) {
            this.dTs.setIsGood(1);
        } else {
            this.dTs.setIsGood(0);
        }
    }

    public boolean apa() {
        if (this.bJx != 1) {
            mG(1);
            return true;
        } else if (this.dSo.Ee()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dTs), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(aaT());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void r(int i, boolean z) {
        this.dTm.dBF = System.currentTimeMillis();
        if (this.dBg != null && this.dBg.bzI() != null) {
            this.dBg.bzI().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dTs), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bJx = c(this.bJx, frsRequestData);
        if (this.bJx == 1) {
            if (!this.dSo.Ee()) {
                frsRequestData.setCallFrom(this.dTv);
                a(frsRequestData, i, z ? false : true);
                this.dTv = 0;
                return;
            }
            return;
        }
        if (this.dTy == null) {
            this.dTy = new ao();
            this.dTy.pn = 1;
            this.dTy.forumName = this.dBw;
            if (this.dBg != null && this.dBg.ber() != null) {
                this.dTy.forumId = this.dBg.ber().getId();
            }
        }
        mG(i);
    }

    public void mH(int i) {
        if (this.bJx != 1) {
            mG(4);
        } else if (!this.dSo.Ee()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dTs), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(aaT());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.dTm.gq(z);
        this.dTt.lI(i);
        this.dSo.a(frsRequestData);
        this.mType = i;
        frsRequestData.uP(this.dTm.azr() ? "1" : "2");
        if (this.dTI) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.nb(this.dTH)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.dTI = false;
        frsRequestData.setKw(this.dBw);
        if (com.baidu.tbadk.core.i.wA().wE()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst());
        float aR = com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
        int i2 = aq.CN().CP() ? 2 : 1;
        frsRequestData.setScrW(aO);
        frsRequestData.setScrH(aQ);
        frsRequestData.setScrDip(aR);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.dSr);
        frsRequestData.setYuelaouLocate(this.dTF);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.d(v.OZ(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.dBG != 0) {
            frsRequestData.setCtime((int) FrsFragment.dBG);
        }
        if (FrsFragment.dBH != 0) {
            frsRequestData.setDataSize((int) FrsFragment.dBH);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.g.a(this.dTG, frsRequestData);
        b(i, frsRequestData);
        a(this.dBw, frsRequestData);
        if (!mK(this.dTG) && !this.dTm.dBx) {
            String d = com.baidu.tieba.tbadkCore.c.bzj().d(this.dBw, frsRequestData.aaT(), frsRequestData.getIsGood(), this.dTs.getCategoryId());
            this.dTJ = d;
            new a(this, true, d).execute(new Object[0]);
        }
        aEb();
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
        if (iVar == null || iVar.ber() == null || (com.baidu.tbadk.core.util.ao.isEmpty(iVar.ber().getName()) && 340001 != iVar.dID)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bJx = iVar.bzM();
        }
        this.dBg.g(iVar);
        e(this.dBg);
        this.dTr = new ArrayList<>();
        if (frsRequestData != null) {
            this.dTs = frsRequestData;
            this.mPn = this.dTs.getPn();
            this.dBw = this.dTs.getKw();
            this.dTm.setForumName(this.dBw);
            this.dTm.setFrom(this.mFrom);
            this.dTm.setPn(this.mPn);
            this.dTm.setFlag(this.mFlag);
        }
        if (this.dBg.getThreadList() != null) {
            this.dTr.addAll(this.dBg.getThreadList());
        }
        if (this.bJx != 1 && this.isNetFirstLoad) {
            this.dTt.a(7, false, this.dSq);
        } else {
            this.dTt.a(this.mType, false, this.dSq);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.dTs)) {
            aEL();
        }
        this.isNetFirstLoad = false;
        if (iVar.ber() == null || TextUtils.isEmpty(iVar.ber().getName()) || frsRequestData == null || r.bsG().bsA() == null) {
            return true;
        }
        r.bsG().bsA().f(iVar.ber().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.haY = com.baidu.adp.lib.util.j.kV() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.haZ = mvcSocketResponsedMessage.getDownSize();
        this.dSq = aVar;
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
        this.dTm.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dTE) {
            this.dTE = true;
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
        aVar.haY = com.baidu.adp.lib.util.j.kV() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.haZ = mvcHttpResponsedMessage.getDownSize();
        this.dSq = aVar;
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
        this.dTm.a(errorData);
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
        if (!this.dTE) {
            this.dTE = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void azm() {
        if (this.dBg != null && this.dBg.ber() != null && this.dBg.ber().getBannerListData() != null) {
            String lastIds = this.dBg.ber().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dSr = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.Og().Oh()) {
            this.bcw = System.currentTimeMillis() - this.dTm.beginTime;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(i, z, responsedMessage, this.dTm.bcn, this.dTm.createTime, this.dTm.bcv, false, this.bcw);
            this.dTm.createTime = 0L;
            this.dTm.bcn = 0L;
            if (iVar != null) {
                iVar.Od();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.Og().Oh()) {
            this.bcw = System.currentTimeMillis() - this.dTm.dBF;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(1000, z, responsedMessage, this.dTm.bcn, this.dTm.createTime, this.dTm.bcv, false, this.bcw);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.bcE = this.bcw;
                    iVar.cK(true);
                } else if (this.mType == 3) {
                    iVar.bcF = this.bcw;
                    iVar.cK(false);
                }
            }
        }
    }

    public FrsRequestData aEw() {
        return this.dTs;
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

    public l aEa() {
        return this.dBg;
    }

    public d.a aEx() {
        return this.dSq;
    }

    private void aEb() {
        this.diF = System.currentTimeMillis();
        this.dSo.Ns();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.dBg.g(iVar);
        e(this.dBg);
        this.dTr = new ArrayList<>();
        if (this.dBg.getThreadList() != null) {
            this.dTr.addAll(this.dBg.getThreadList());
        }
        this.dTt.b(iVar);
    }

    private void e(l lVar) {
        if (com.baidu.tieba.frs.vc.f.j(lVar)) {
            this.mPageType = "book_page";
        } else if (lVar.bAr()) {
            this.mPageType = "brand_page";
        } else if (com.baidu.tieba.frs.vc.f.k(lVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.i, Void> {
        private String dTP;
        private FrsModelController dTQ;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.dTP = null;
            this.dTP = str;
            this.dTQ = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bzj().uN(this.dTP)) {
                if (!com.baidu.tieba.tbadkCore.c.bzj().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.dTP)) {
                    com.baidu.tieba.tbadkCore.c.bzj().getResponseData().ber().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.i responseData = com.baidu.tieba.tbadkCore.c.bzj().getResponseData();
                responseData.nn(false);
                if (responseData.bzO() != null && !StringUtils.isNull(responseData.bzO().xg(), true) && !responseData.bzO().xg().equals("0") && responseData.bzO().xh() == 3 && (l = com.baidu.adp.lib.g.b.l(responseData.bzO().xg(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(l))) != null) {
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
            if (this.dTQ != null && iVarArr != null) {
                this.dTQ.f(iVarArr.length > 0 ? iVarArr[0] : null);
                this.dTQ.q(this.dTQ.dTG, true);
            }
        }
    }

    public long atM() {
        return this.diI;
    }

    public long atN() {
        return this.diG;
    }

    public long atO() {
        return this.diH;
    }

    public long atP() {
        return this.diF;
    }

    public boolean Ee() {
        return this.dSo.Ee();
    }

    public int aEy() {
        return this.dTx;
    }

    private void aEz() {
        if (this.dTD == null) {
            this.dTD = new ArrayList<>();
        }
        if (this.dTD.size() == 0) {
            this.dTD.add(new com.baidu.tieba.frs.v());
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        this.bJx = c(i, null);
        if (aoVar == null && (aoVar = aW(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.lm() && this.dTC != null) {
                ar arVar = new ar();
                arVar.hasMore = false;
                arVar.pn = 1;
                arVar.forumName = this.dBw;
                arVar.dFt = false;
                if (this.dBg != null && this.dBg.ber() != null) {
                    arVar.forumId = this.dBg.ber().getId();
                }
                aEz();
                this.dBg.ax(this.dTD);
                this.dTC.a(i, i2, arVar, this.dTD);
            }
            aoVar = new ao();
            aoVar.pn = -1;
        }
        if (this.dBg != null && this.dBg.ber() != null) {
            aoVar.forumId = this.dBg.ber().getId();
        }
        aoVar.forumName = this.dBw;
        if (y.aAH().lX(1) != null && this.bJx == 1) {
            this.dTs.setCategoryId(i2);
        }
        this.dTw = i2;
        this.dTy = aoVar;
        b(i, i2, aoVar);
        mG(5);
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.dTC = alVar;
        this.dTB.a(this.dTL);
    }

    private void mG(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.dTy != null) {
                    this.dTy.pn++;
                    break;
                }
                break;
            case 2:
                if (this.dTy != null) {
                    ao aoVar = this.dTy;
                    aoVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.dTy != null) {
                    this.dTy.pn = -1;
                    break;
                }
                break;
        }
        if (this.bJx == 1) {
            if (this.dTx == this.dTw) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                if (this.dTr != null) {
                    arrayList.addAll(this.dTr);
                }
                this.dBg.ax(arrayList);
                if (this.dTC != null) {
                    this.dTC.a(this.bJx, this.dTw, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.dTx = this.dTw;
            return;
        }
        ai lY = this.dTB.lY(this.bJx);
        if (lY != null) {
            this.dTz = true;
            lY.a(this.bJx, this.dTw, this.dTy);
            return;
        }
        if (this.dBg != null && this.dBg.getThreadList() != null) {
            this.dBg.getThreadList().clear();
        }
        this.dTC.a(this.bJx, this.dTw, null, null);
    }

    public boolean hasMore() {
        if ((this.dTy instanceof ar) && ((ar) this.dTy).errCode == 0) {
            return ((ar) this.dTy).hasMore;
        }
        return true;
    }

    private int aV(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ao aoVar) {
        this.dTA.put(aV(i, i2), aoVar);
    }

    public ao aW(int i, int i2) {
        return this.dTA.get(aV(i, i2));
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        this.dTB.init();
    }

    @Override // com.baidu.tieba.frs.ai
    public void abf() {
        this.dTB.destory();
        this.dTB.clear();
    }

    public int aEA() {
        return this.bJx;
    }

    public boolean aEB() {
        return 1 == this.bJx;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(com.baidu.tbadk.core.data.ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && !com.baidu.tbadk.core.util.v.I(this.dTr)) {
            if (this.bJx == 1) {
                this.dBg.a(aiVar);
            }
            int aEC = aEC();
            Iterator<com.baidu.adp.widget.ListView.h> it = this.dTr.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if ((next instanceof bb) && aiVar.getId().equals(((bb) next).getId())) {
                    return;
                }
            }
            this.dTr.add(aEC, aiVar);
        }
    }

    public int aEC() {
        int i = 0;
        if (this.dTr == null || this.dTr.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.dTr.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (!(next instanceof bb)) {
                    i = i2;
                } else if (((bb) next).yx() != 0) {
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

    public boolean aED() {
        return this.dTz;
    }

    public void aEE() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.dTx == 0) {
            mVar.lS(this.dTG);
        }
        if (this.dBg.getThreadList() != null) {
            this.dBg.getThreadList().clear();
            this.dBg.getThreadList().add(mVar);
        }
        if (this.dTr != null) {
            this.dTr.clear();
            this.dTr.add(mVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aEF() {
        return this.dTr;
    }

    public void mL(int i) {
        this.dTG = i;
        com.baidu.tieba.frs.f.g.ad(this.dBw, this.dTG);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.bCu();
        } else {
            com.baidu.tieba.tbadkCore.util.e.bCv();
        }
    }

    public void mM(int i) {
        this.dTH = i;
    }

    public void hj(boolean z) {
        this.dTI = z;
    }

    public int aEG() {
        return this.dTG;
    }

    public int aaT() {
        return com.baidu.tieba.frs.f.g.nb(this.dTG);
    }

    public boolean aEH() {
        return this.dTu;
    }

    public boolean aEI() {
        return this.dTG == 5;
    }

    public boolean aEJ() {
        return this.dTs != null && this.dTs.getLoadType() == 1;
    }

    public boolean aEK() {
        return this.dTG == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.dTm.ayP() != null) {
            return this.dTm.ayP().a(this.dTG, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bb.apS.get() && r.bsG().bsA() != null) {
            int Y = r.bsG().bsA().Y(str, false);
            int Z = r.bsG().bsA().Z(str, false);
            if (frsRequestData.getLoadType() == 1) {
                Y++;
            } else if (frsRequestData.getLoadType() == 2) {
                Z++;
            }
            frsRequestData.setRefreshCount(Y);
            frsRequestData.setLoadCount(Z);
        }
    }

    public void aEL() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.dBg != null && this.dBg.ber() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.d(this.dBg.ber().getId(), 0L));
        }
        this.dTm.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void oa(final String str) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bzj().cC(FrsModelController.this.dTJ, str);
                return null;
            }
        }, null);
    }

    public void ob(final String str) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bzj().cD(FrsModelController.this.dTJ, str);
                return null;
            }
        }, null);
    }

    public void oc(final String str) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bzj().cE(FrsModelController.this.dTJ, str);
                return null;
            }
        }, null);
    }
}
