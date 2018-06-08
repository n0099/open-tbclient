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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.k.m;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.i>, ag {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long aSX;
    private int bsf;
    private long cSN;
    private long cSO;
    private long cSP;
    private long cSQ;
    private l dhf;
    private String dhv;
    private d.a dmV;
    private FrsNetModel<FrsFragment> dwA;
    private String dwC;
    private ArrayList<com.baidu.adp.widget.ListView.h> dxB;
    private FrsRequestData dxC;
    private final n dxD;
    private boolean dxE;
    private int dxF;
    private int dxG;
    private am dxH;
    private boolean dxI;
    private SparseArray<am> dxJ;
    private y dxK;
    private aj dxL;
    private ArrayList<com.baidu.adp.widget.ListView.h> dxM;
    private boolean dxN;
    private String dxO;
    private int dxP;
    private int dxQ;
    private boolean dxR;
    private String dxS;
    private final SparseArray<Boolean> dxT;
    private aj dxU;
    private final FrsFragment dxw;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean la(int i) {
        return this.dxT.get(i, false).booleanValue();
    }

    public void r(int i, boolean z) {
        this.dxT.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.dhv = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.dwC = null;
        this.bsf = 1;
        this.dxF = 0;
        this.dxG = 0;
        this.dxI = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.dxJ = new SparseArray<>();
        this.aSX = 0L;
        this.dxN = false;
        this.dxP = -1;
        this.dxQ = -1;
        this.dxS = null;
        this.dxT = new SparseArray<>();
        this.dxU = new aj() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.aj
            public void a(int i, int i2, ap apVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
                FrsModelController.this.dxI = false;
                if (i == FrsModelController.this.bsf && FrsModelController.this.dxL != null) {
                    FrsModelController.this.dxH = apVar;
                    FrsModelController.this.b(i, i2, apVar);
                    ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.dhf.av(arrayList2);
                    FrsModelController.this.dxL.a(i, i2, apVar, arrayList);
                }
            }
        };
        this.cSN = 0L;
        this.cSO = 0L;
        this.cSP = 0L;
        this.cSQ = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.dxw = frsFragment;
        this.dxD = nVar;
        y(this.dxw);
    }

    private void y(FrsFragment frsFragment) {
        this.dxK = new y();
        this.dxK.aQJ = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.dxK));
        this.dxK.a(this.dxU);
    }

    public void onActivityDestroy() {
        this.dwA.cancelLoadData();
    }

    public void i(Bundle bundle) {
        if (bundle != null) {
            this.dhv = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dxO = bundle.getString("yuelaou_locate");
            this.dxE = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.dhv)) {
            this.dhv = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.dxO)) {
            this.dxO = "";
        }
        this.mSource = this.mFrom;
        this.dxC = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            lb(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            lb(6);
        } else {
            lb(com.baidu.tieba.frs.f.g.nb(this.dhv));
        }
        this.dxC.setSortType(UG());
        if (this.dxP == 5) {
            this.dxC.setIsGood(1);
        } else {
            this.dxC.setIsGood(0);
        }
        this.dhf = new l();
        this.dwA = new FrsNetModel<>(this.dxw.getPageContext(), this.dxC);
        this.dwA.a(this);
        this.dwA.setUniqueId(this.dxw.getUniqueId());
        if (this.dhv != null && this.dhv.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dhv);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean akt() {
        if (this.bsf != 1) {
            kW(1);
            return true;
        } else if (this.dwA.Ax()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dxC), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(UG());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void t(int i, boolean z) {
        this.dxw.dhD = System.currentTimeMillis();
        if (this.dhf != null && this.dhf.bvm() != null) {
            this.dhf.bvm().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dxC), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bsf = c(this.bsf, frsRequestData);
        if (this.bsf == 1) {
            if (!this.dwA.Ax()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.dxH == null) {
            this.dxH = new am();
            this.dxH.pn = 1;
            this.dxH.forumName = this.dhv;
            if (this.dhf != null && this.dhf.bam() != null) {
                this.dxH.forumId = this.dhf.bam().getId();
            }
        }
        kW(i);
    }

    public void kX(int i) {
        if (this.bsf != 1) {
            kW(4);
        } else if (!this.dwA.Ax()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dxC), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(UG());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.dxD.kf(i);
        this.dwA.a(frsRequestData);
        this.mType = i;
        frsRequestData.tB(this.dxw.atK() ? "1" : "2");
        if (this.dxR) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.lr(this.dxQ)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.dxR = false;
        frsRequestData.setKw(this.dhv);
        if (com.baidu.tbadk.core.i.tt().tz()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        int aj = com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst());
        float ak = com.baidu.adp.lib.util.l.ak(TbadkCoreApplication.getInst());
        int i2 = aq.zq().zs() ? 2 : 1;
        frsRequestData.setScrW(ah);
        frsRequestData.setScrH(aj);
        frsRequestData.setScrDip(ak);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.dwC);
        frsRequestData.setYuelaouLocate(this.dxO);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(u.Lj(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.dhE != 0) {
            frsRequestData.setCtime((int) FrsFragment.dhE);
        }
        if (FrsFragment.dhF != 0) {
            frsRequestData.setDataSize((int) FrsFragment.dhF);
        }
        if (FrsFragment.dhG != 0) {
            frsRequestData.setNetError(FrsFragment.dhG);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.g.a(this.dxP, frsRequestData);
        b(i, frsRequestData);
        a(this.dhv, frsRequestData);
        if (!la(this.dxP)) {
            String d = com.baidu.tieba.tbadkCore.c.buO().d(this.dhv, frsRequestData.UG(), frsRequestData.getIsGood(), this.dxC.getCategoryId());
            this.dxS = d;
            new a(this, true, d).execute(new Object[0]);
        }
        axW();
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
        if (iVar == null || iVar.bam() == null || (ao.isEmpty(iVar.bam().getName()) && 340001 != iVar.dmW)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bsf = iVar.bvq();
        }
        this.dhf.e(iVar);
        e(this.dhf);
        this.dxB = new ArrayList<>();
        if (frsRequestData != null) {
            this.dxC = frsRequestData;
            this.mPn = this.dxC.getPn();
            this.dhv = this.dxC.getKw();
            this.dxw.setForumName(this.dhv);
            this.dxw.setFrom(this.mFrom);
            this.dxw.setPn(this.mPn);
            this.dxw.setFlag(this.mFlag);
        }
        if (this.dhf.getThreadList() != null) {
            this.dxB.addAll(this.dhf.getThreadList());
        }
        if (this.bsf != 1 && this.isNetFirstLoad) {
            this.dxD.a(7, false, this.dmV);
        } else {
            this.dxD.a(this.mType, false, this.dmV);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.dxC)) {
            ayE();
        }
        this.isNetFirstLoad = false;
        if (iVar.bam() == null || TextUtils.isEmpty(iVar.bam().getName()) || frsRequestData == null || r.boj().bod() == null) {
            return true;
        }
        r.boj().bod().f(iVar.bam().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.gFM = com.baidu.adp.lib.util.j.jD() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gFN = mvcSocketResponsedMessage.getDownSize();
        this.dmV = aVar;
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
        this.dxw.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dxN) {
            this.dxN = true;
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
        aVar.gFM = com.baidu.adp.lib.util.j.jD() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gFN = mvcHttpResponsedMessage.getDownSize();
        this.dmV = aVar;
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
        this.dxw.a(errorData);
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
        if (!this.dxN) {
            this.dxN = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void atF() {
        if (this.dhf != null && this.dhf.bam() != null && this.dhf.bam().getBannerListData() != null) {
            String lastIds = this.dhf.bam().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dwC = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.Ks().Kt()) {
            this.aSX = System.currentTimeMillis() - this.dxw.beginTime;
            com.baidu.tbadk.k.i iVar = new com.baidu.tbadk.k.i(i, z, responsedMessage, this.dxw.aSO, this.dxw.createTime, this.dxw.aSW, false, this.aSX);
            this.dxw.createTime = 0L;
            this.dxw.aSO = 0L;
            if (iVar != null) {
                iVar.Kp();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.Ks().Kt()) {
            this.aSX = System.currentTimeMillis() - this.dxw.dhD;
            com.baidu.tbadk.k.i iVar = new com.baidu.tbadk.k.i(1000, z, responsedMessage, this.dxw.aSO, this.dxw.createTime, this.dxw.aSW, false, this.aSX);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.aTf = this.aSX;
                    iVar.bW(true);
                } else if (this.mType == 3) {
                    iVar.aTg = this.aSX;
                    iVar.bW(false);
                }
            }
        }
    }

    public FrsRequestData ayo() {
        return this.dxC;
    }

    public String ayp() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.dhv;
    }

    public int getPn() {
        return this.mPn;
    }

    public l axV() {
        return this.dhf;
    }

    public d.a ayq() {
        return this.dmV;
    }

    private void axW() {
        this.cSN = System.currentTimeMillis();
        this.dwA.JE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.dhf.e(iVar);
        e(this.dhf);
        this.dxB = new ArrayList<>();
        if (this.dhf.getThreadList() != null) {
            this.dxB.addAll(this.dhf.getThreadList());
        }
        this.dxD.b(iVar);
    }

    private void e(l lVar) {
        if (com.baidu.tieba.frs.vc.f.i(lVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.vc.f.j(lVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.i, Void> {
        private String dxY;
        private FrsModelController dxZ;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.dxY = null;
            this.dxY = str;
            this.dxZ = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.buO().tz(this.dxY)) {
                if (!com.baidu.tieba.tbadkCore.c.buO().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.dxY)) {
                    com.baidu.tieba.tbadkCore.c.buO().getResponseData().bam().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.i responseData = com.baidu.tieba.tbadkCore.c.buO().getResponseData();
                responseData.ms(false);
                if (responseData.bvs() != null && !StringUtils.isNull(responseData.bvs().tV(), true) && !responseData.bvs().tV().equals("0") && responseData.bvs().getBookType() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bvs().tV(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(g))) != null) {
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
            if (this.dxZ != null && iVarArr != null) {
                this.dxZ.d(iVarArr.length > 0 ? iVarArr[0] : null);
                this.dxZ.r(this.dxZ.dxP, true);
            }
        }
    }

    public long aph() {
        return this.cSQ;
    }

    public long apj() {
        return this.cSO;
    }

    public long apk() {
        return this.cSP;
    }

    public long apl() {
        return this.cSN;
    }

    public boolean Ax() {
        return this.dwA.Ax();
    }

    public int ayr() {
        return this.dxG;
    }

    private void ays() {
        if (this.dxM == null) {
            this.dxM = new ArrayList<>();
        }
        if (this.dxM.size() == 0) {
            this.dxM.add(new t());
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(int i, int i2, am amVar) {
        this.bsf = c(i, null);
        if (amVar == null && (amVar = aL(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.jU() && this.dxL != null) {
                ap apVar = new ap();
                apVar.hasMore = false;
                apVar.pn = 1;
                apVar.forumName = this.dhv;
                apVar.dkR = false;
                if (this.dhf != null && this.dhf.bam() != null) {
                    apVar.forumId = this.dhf.bam().getId();
                }
                ays();
                this.dhf.av(this.dxM);
                this.dxL.a(i, i2, apVar, this.dxM);
            }
            amVar = new am();
            amVar.pn = -1;
        }
        if (this.dhf != null && this.dhf.bam() != null) {
            amVar.forumId = this.dhf.bam().getId();
        }
        amVar.forumName = this.dhv;
        if (w.auJ().ko(1) != null && this.bsf == 1) {
            this.dxC.setCategoryId(i2);
        }
        this.dxF = i2;
        this.dxH = amVar;
        b(i, i2, amVar);
        kW(5);
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(aj ajVar) {
        this.dxL = ajVar;
        this.dxK.a(this.dxU);
    }

    private void kW(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.dxH != null) {
                    this.dxH.pn++;
                    break;
                }
                break;
            case 2:
                if (this.dxH != null) {
                    am amVar = this.dxH;
                    amVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.dxH != null) {
                    this.dxH.pn = -1;
                    break;
                }
                break;
        }
        if (this.bsf == 1) {
            if (this.dxG == this.dxF) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                if (this.dxB != null) {
                    arrayList.addAll(this.dxB);
                }
                this.dhf.av(arrayList);
                if (this.dxL != null) {
                    this.dxL.a(this.bsf, this.dxF, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.dxG = this.dxF;
            return;
        }
        ag kp = this.dxK.kp(this.bsf);
        if (kp != null) {
            this.dxI = true;
            kp.a(this.bsf, this.dxF, this.dxH);
            return;
        }
        if (this.dhf != null && this.dhf.getThreadList() != null) {
            this.dhf.getThreadList().clear();
        }
        this.dxL.a(this.bsf, this.dxF, null, null);
    }

    public boolean hasMore() {
        if ((this.dxH instanceof ap) && ((ap) this.dxH).errCode == 0) {
            return ((ap) this.dxH).hasMore;
        }
        return true;
    }

    private int aK(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, am amVar) {
        this.dxJ.put(aK(i, i2), amVar);
    }

    public am aL(int i, int i2) {
        return this.dxJ.get(aK(i, i2));
    }

    @Override // com.baidu.tieba.frs.ag
    public void init() {
        this.dxK.init();
    }

    @Override // com.baidu.tieba.frs.ag
    public void UT() {
        this.dxK.destory();
        this.dxK.clear();
    }

    public int ayt() {
        return this.bsf;
    }

    public boolean ayu() {
        return 1 == this.bsf;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(com.baidu.tbadk.core.data.aj ajVar) {
        if (ajVar != null && !StringUtils.isNull(ajVar.getId()) && this.dxB != null) {
            if (this.bsf == 1) {
                this.dhf.a(ajVar);
            }
            int ayv = ayv();
            if (this.dxB != null && this.dxB.size() > 0) {
                int size = this.dxB.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.h hVar = this.dxB.get(i);
                    if ((hVar instanceof bd) && ajVar.getId().equals(((bd) hVar).getId())) {
                        return;
                    }
                }
            }
            this.dxB.add(ayv, ajVar);
        }
    }

    public int ayv() {
        int i = 0;
        if (this.dxB == null || this.dxB.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.dxB.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (!(next instanceof bd)) {
                    i = i2;
                } else if (((bd) next).vh() != 0) {
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

    public boolean ayw() {
        return this.dxI;
    }

    public void ayx() {
        k kVar = new k();
        if (this.dxG == 0) {
            kVar.kn(this.dxP);
        }
        if (this.dhf.getThreadList() != null) {
            this.dhf.getThreadList().clear();
            this.dhf.getThreadList().add(kVar);
        }
        if (this.dxB != null) {
            this.dxB.clear();
            this.dxB.add(kVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> ayy() {
        return this.dxB;
    }

    public void lb(int i) {
        this.dxP = i;
        com.baidu.tieba.frs.f.g.Z(this.dhv, this.dxP);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.bxY();
        } else {
            com.baidu.tieba.tbadkCore.util.e.bxZ();
        }
    }

    public void lc(int i) {
        this.dxQ = i;
    }

    public void fZ(boolean z) {
        this.dxR = z;
    }

    public int ayz() {
        return this.dxP;
    }

    public int UG() {
        return com.baidu.tieba.frs.f.g.lr(this.dxP);
    }

    public boolean ayA() {
        return this.dxE;
    }

    public boolean ayB() {
        return this.dxP == 5;
    }

    public boolean ayC() {
        return this.dxC != null && this.dxC.getLoadType() == 1;
    }

    public boolean ayD() {
        return this.dxP == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.dxw.ati() != null) {
            return this.dxw.ati().a(this.dxP, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bd.ahU.get() && r.boj().bod() != null) {
            int Q = r.boj().bod().Q(str, false);
            int R = r.boj().bod().R(str, false);
            if (frsRequestData.getLoadType() == 1) {
                Q++;
            } else if (frsRequestData.getLoadType() == 2) {
                R++;
            }
            frsRequestData.setRefreshCount(Q);
            frsRequestData.setLoadCount(R);
        }
    }

    public void ayE() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.dhf != null && this.dhf.bam() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.dhf.bam().getId(), 0L));
        }
        this.dxw.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void mT(final String str) {
        com.baidu.tbadk.util.w.a(new v<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.v
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.buO().cg(FrsModelController.this.dxS, str);
                return null;
            }
        }, null);
    }

    public void mU(final String str) {
        com.baidu.tbadk.util.w.a(new v<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.v
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.buO().ch(FrsModelController.this.dxS, str);
                return null;
            }
        }, null);
    }

    public void mV(final String str) {
        com.baidu.tbadk.util.w.a(new v<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.v
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.buO().ci(FrsModelController.this.dxS, str);
                return null;
            }
        }, null);
    }
}
