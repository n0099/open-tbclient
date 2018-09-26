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
/* loaded from: classes2.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.i>, ai {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long aXj;
    private int bAe;
    private long cZl;
    private long cZm;
    private long cZn;
    private long cZo;
    private FrsNetModel<FrsFragment> dJl;
    private String dJn;
    private ArrayList<com.baidu.adp.widget.ListView.h> dKA;
    private boolean dKB;
    private String dKC;
    private int dKD;
    private int dKE;
    private boolean dKF;
    private String dKG;
    private final SparseArray<Boolean> dKH;
    private al dKI;
    private final FrsFragment dKj;
    private ArrayList<com.baidu.adp.widget.ListView.h> dKo;
    private FrsRequestData dKp;
    private final n dKq;
    private boolean dKr;
    private int dKs;
    private int dKt;
    private int dKu;
    private ao dKv;
    private boolean dKw;
    private SparseArray<ao> dKx;
    private aa dKy;
    private al dKz;
    private l drN;
    private String dsd;
    private d.a dzw;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean lU(int i) {
        return this.dKH.get(i, false).booleanValue();
    }

    public void q(int i, boolean z) {
        this.dKH.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.dsd = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.dKs = 0;
        this.mSource = null;
        this.dJn = null;
        this.bAe = 1;
        this.dKt = 0;
        this.dKu = 0;
        this.dKw = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.dKx = new SparseArray<>();
        this.aXj = 0L;
        this.dKB = false;
        this.dKD = -1;
        this.dKE = -1;
        this.dKG = null;
        this.dKH = new SparseArray<>();
        this.dKI = new al() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.al
            public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
                FrsModelController.this.dKw = false;
                if (i == FrsModelController.this.bAe && FrsModelController.this.dKz != null) {
                    FrsModelController.this.dKv = arVar;
                    FrsModelController.this.b(i, i2, arVar);
                    ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.drN.ay(arrayList2);
                    FrsModelController.this.dKz.a(i, i2, arVar, arrayList);
                }
            }
        };
        this.cZl = 0L;
        this.cZm = 0L;
        this.cZn = 0L;
        this.cZo = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.dKj = frsFragment;
        this.dKq = nVar;
        D(this.dKj);
    }

    private void D(FrsFragment frsFragment) {
        this.dKy = new aa();
        this.dKy.aUU = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.dKy));
        this.dKy.a(this.dKI);
    }

    public void onActivityDestroy() {
        this.dJl.cancelLoadData();
    }

    public void i(Bundle bundle) {
        if (bundle != null) {
            this.dsd = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dKC = bundle.getString("yuelaou_locate");
            this.dKr = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.dKs = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
        }
        if (TextUtils.isEmpty(this.dsd)) {
            this.dsd = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.dKC)) {
            this.dKC = "";
        }
        this.mSource = this.mFrom;
        aBG();
        this.drN = new l();
        this.dJl = new FrsNetModel<>(this.dKj.getPageContext(), this.dKp);
        this.dJl.a(this);
        this.dJl.setUniqueId(this.dKj.getUniqueId());
        if (this.dsd != null && this.dsd.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dsd);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void aBG() {
        this.dKp = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            lV(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            lV(6);
        } else {
            lV(com.baidu.tieba.frs.f.g.nH(this.dsd));
        }
        this.dKp.setSortType(Xb());
        if (this.dKD == 5) {
            this.dKp.setIsGood(1);
        } else {
            this.dKp.setIsGood(0);
        }
    }

    public boolean alZ() {
        if (this.bAe != 1) {
            lQ(1);
            return true;
        } else if (this.dJl.BO()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dKp), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(Xb());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void r(int i, boolean z) {
        this.dKj.dsm = System.currentTimeMillis();
        if (this.drN != null && this.drN.bwX() != null) {
            this.drN.bwX().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dKp), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bAe = c(this.bAe, frsRequestData);
        if (this.bAe == 1) {
            if (!this.dJl.BO()) {
                frsRequestData.setCallFrom(this.dKs);
                a(frsRequestData, i, z ? false : true);
                this.dKs = 0;
                return;
            }
            return;
        }
        if (this.dKv == null) {
            this.dKv = new ao();
            this.dKv.pn = 1;
            this.dKv.forumName = this.dsd;
            if (this.drN != null && this.drN.bbH() != null) {
                this.dKv.forumId = this.drN.bbH().getId();
            }
        }
        lQ(i);
    }

    public void lR(int i) {
        if (this.bAe != 1) {
            lQ(4);
        } else if (!this.dJl.BO()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dKp), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(Xb());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.dKj.fO(z);
        this.dKq.kS(i);
        this.dJl.a(frsRequestData);
        this.mType = i;
        frsRequestData.uj(this.dKj.awx() ? "1" : "2");
        if (this.dKF) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.ml(this.dKE)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.dKF = false;
        frsRequestData.setKw(this.dsd);
        if (com.baidu.tbadk.core.i.uj().un()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst());
        float aR = com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
        int i2 = aq.Az().AB() ? 2 : 1;
        frsRequestData.setScrW(aO);
        frsRequestData.setScrH(aQ);
        frsRequestData.setScrDip(aR);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.dJn);
        frsRequestData.setYuelaouLocate(this.dKC);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.d(v.MS(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.dsn != 0) {
            frsRequestData.setCtime((int) FrsFragment.dsn);
        }
        if (FrsFragment.dso != 0) {
            frsRequestData.setDataSize((int) FrsFragment.dso);
        }
        if (FrsFragment.dsp != 0) {
            frsRequestData.setNetError(FrsFragment.dsp);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.g.a(this.dKD, frsRequestData);
        b(i, frsRequestData);
        a(this.dsd, frsRequestData);
        if (!lU(this.dKD) && !this.dKj.dse) {
            String d = com.baidu.tieba.tbadkCore.c.bwy().d(this.dsd, frsRequestData.Xb(), frsRequestData.getIsGood(), this.dKp.getCategoryId());
            this.dKG = d;
            new a(this, true, d).execute(new Object[0]);
        }
        aBm();
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
        if (iVar == null || iVar.bbH() == null || (com.baidu.tbadk.core.util.ao.isEmpty(iVar.bbH().getName()) && 340001 != iVar.dzx)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bAe = iVar.bxb();
        }
        this.drN.e(iVar);
        e(this.drN);
        this.dKo = new ArrayList<>();
        if (frsRequestData != null) {
            this.dKp = frsRequestData;
            this.mPn = this.dKp.getPn();
            this.dsd = this.dKp.getKw();
            this.dKj.setForumName(this.dsd);
            this.dKj.setFrom(this.mFrom);
            this.dKj.setPn(this.mPn);
            this.dKj.setFlag(this.mFlag);
        }
        if (this.drN.getThreadList() != null) {
            this.dKo.addAll(this.drN.getThreadList());
        }
        if (this.bAe != 1 && this.isNetFirstLoad) {
            this.dKq.a(7, false, this.dzw);
        } else {
            this.dKq.a(this.mType, false, this.dzw);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.dKp)) {
            aBW();
        }
        this.isNetFirstLoad = false;
        if (iVar.bbH() == null || TextUtils.isEmpty(iVar.bbH().getName()) || frsRequestData == null || r.bpV().bpP() == null) {
            return true;
        }
        r.bpV().bpP().f(iVar.bbH().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.gSe = com.baidu.adp.lib.util.j.kK() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gSf = mvcSocketResponsedMessage.getDownSize();
        this.dzw = aVar;
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
        this.dKj.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dKB) {
            this.dKB = true;
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
        aVar.gSe = com.baidu.adp.lib.util.j.kK() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gSf = mvcHttpResponsedMessage.getDownSize();
        this.dzw = aVar;
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
        this.dKj.a(errorData);
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
        if (!this.dKB) {
            this.dKB = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void aws() {
        if (this.drN != null && this.drN.bbH() != null && this.drN.bbH().getBannerListData() != null) {
            String lastIds = this.drN.bbH().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dJn = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.LZ().Ma()) {
            this.aXj = System.currentTimeMillis() - this.dKj.beginTime;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(i, z, responsedMessage, this.dKj.aXa, this.dKj.createTime, this.dKj.aXi, false, this.aXj);
            this.dKj.createTime = 0L;
            this.dKj.aXa = 0L;
            if (iVar != null) {
                iVar.LW();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.LZ().Ma()) {
            this.aXj = System.currentTimeMillis() - this.dKj.dsm;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(1000, z, responsedMessage, this.dKj.aXa, this.dKj.createTime, this.dKj.aXi, false, this.aXj);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.aXr = this.aXj;
                    iVar.ck(true);
                } else if (this.mType == 3) {
                    iVar.aXs = this.aXj;
                    iVar.ck(false);
                }
            }
        }
    }

    public FrsRequestData aBH() {
        return this.dKp;
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

    public l aBl() {
        return this.drN;
    }

    public d.a aBI() {
        return this.dzw;
    }

    private void aBm() {
        this.cZl = System.currentTimeMillis();
        this.dJl.Ll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.drN.e(iVar);
        e(this.drN);
        this.dKo = new ArrayList<>();
        if (this.drN.getThreadList() != null) {
            this.dKo.addAll(this.drN.getThreadList());
        }
        this.dKq.b(iVar);
    }

    private void e(l lVar) {
        if (com.baidu.tieba.frs.vc.f.j(lVar)) {
            this.mPageType = "book_page";
        } else if (lVar.bxG()) {
            this.mPageType = "brand_page";
        } else if (com.baidu.tieba.frs.vc.f.k(lVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.i, Void> {
        private String dKM;
        private FrsModelController dKN;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.dKM = null;
            this.dKM = str;
            this.dKN = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bwy().uh(this.dKM)) {
                if (!com.baidu.tieba.tbadkCore.c.bwy().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.dKM)) {
                    com.baidu.tieba.tbadkCore.c.bwy().getResponseData().bbH().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.i responseData = com.baidu.tieba.tbadkCore.c.bwy().getResponseData();
                responseData.mL(false);
                if (responseData.bxd() != null && !StringUtils.isNull(responseData.bxd().uP(), true) && !responseData.bxd().uP().equals("0") && responseData.bxd().uQ() == 3 && (l = com.baidu.adp.lib.g.b.l(responseData.bxd().uP(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(l))) != null) {
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
            if (this.dKN != null && iVarArr != null) {
                this.dKN.d(iVarArr.length > 0 ? iVarArr[0] : null);
                this.dKN.q(this.dKN.dKD, true);
            }
        }
    }

    public long aqR() {
        return this.cZo;
    }

    public long aqS() {
        return this.cZm;
    }

    public long aqT() {
        return this.cZn;
    }

    public long aqU() {
        return this.cZl;
    }

    public boolean BO() {
        return this.dJl.BO();
    }

    public int aBJ() {
        return this.dKu;
    }

    private void aBK() {
        if (this.dKA == null) {
            this.dKA = new ArrayList<>();
        }
        if (this.dKA.size() == 0) {
            this.dKA.add(new com.baidu.tieba.frs.v());
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        this.bAe = c(i, null);
        if (aoVar == null && (aoVar = aR(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.lb() && this.dKz != null) {
                ar arVar = new ar();
                arVar.hasMore = false;
                arVar.pn = 1;
                arVar.forumName = this.dsd;
                arVar.dwc = false;
                if (this.drN != null && this.drN.bbH() != null) {
                    arVar.forumId = this.drN.bbH().getId();
                }
                aBK();
                this.drN.ay(this.dKA);
                this.dKz.a(i, i2, arVar, this.dKA);
            }
            aoVar = new ao();
            aoVar.pn = -1;
        }
        if (this.drN != null && this.drN.bbH() != null) {
            aoVar.forumId = this.drN.bbH().getId();
        }
        aoVar.forumName = this.dsd;
        if (y.axO().lh(1) != null && this.bAe == 1) {
            this.dKp.setCategoryId(i2);
        }
        this.dKt = i2;
        this.dKv = aoVar;
        b(i, i2, aoVar);
        lQ(5);
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.dKz = alVar;
        this.dKy.a(this.dKI);
    }

    private void lQ(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.dKv != null) {
                    this.dKv.pn++;
                    break;
                }
                break;
            case 2:
                if (this.dKv != null) {
                    ao aoVar = this.dKv;
                    aoVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.dKv != null) {
                    this.dKv.pn = -1;
                    break;
                }
                break;
        }
        if (this.bAe == 1) {
            if (this.dKu == this.dKt) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                if (this.dKo != null) {
                    arrayList.addAll(this.dKo);
                }
                this.drN.ay(arrayList);
                if (this.dKz != null) {
                    this.dKz.a(this.bAe, this.dKt, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.dKu = this.dKt;
            return;
        }
        ai li = this.dKy.li(this.bAe);
        if (li != null) {
            this.dKw = true;
            li.a(this.bAe, this.dKt, this.dKv);
            return;
        }
        if (this.drN != null && this.drN.getThreadList() != null) {
            this.drN.getThreadList().clear();
        }
        this.dKz.a(this.bAe, this.dKt, null, null);
    }

    public boolean hasMore() {
        if ((this.dKv instanceof ar) && ((ar) this.dKv).errCode == 0) {
            return ((ar) this.dKv).hasMore;
        }
        return true;
    }

    private int aQ(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ao aoVar) {
        this.dKx.put(aQ(i, i2), aoVar);
    }

    public ao aR(int i, int i2) {
        return this.dKx.get(aQ(i, i2));
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        this.dKy.init();
    }

    @Override // com.baidu.tieba.frs.ai
    public void Xn() {
        this.dKy.destory();
        this.dKy.clear();
    }

    public int aBL() {
        return this.bAe;
    }

    public boolean aBM() {
        return 1 == this.bAe;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(com.baidu.tbadk.core.data.ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && !com.baidu.tbadk.core.util.v.z(this.dKo)) {
            if (this.bAe == 1) {
                this.drN.a(aiVar);
            }
            int aBN = aBN();
            Iterator<com.baidu.adp.widget.ListView.h> it = this.dKo.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if ((next instanceof bb) && aiVar.getId().equals(((bb) next).getId())) {
                    return;
                }
            }
            this.dKo.add(aBN, aiVar);
        }
    }

    public int aBN() {
        int i = 0;
        if (this.dKo == null || this.dKo.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.dKo.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (!(next instanceof bb)) {
                    i = i2;
                } else if (((bb) next).wh() != 0) {
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

    public boolean aBO() {
        return this.dKw;
    }

    public void aBP() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.dKu == 0) {
            mVar.lc(this.dKD);
        }
        if (this.drN.getThreadList() != null) {
            this.drN.getThreadList().clear();
            this.drN.getThreadList().add(mVar);
        }
        if (this.dKo != null) {
            this.dKo.clear();
            this.dKo.add(mVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aBQ() {
        return this.dKo;
    }

    public void lV(int i) {
        this.dKD = i;
        com.baidu.tieba.frs.f.g.Z(this.dsd, this.dKD);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.bzK();
        } else {
            com.baidu.tieba.tbadkCore.util.e.bzL();
        }
    }

    public void lW(int i) {
        this.dKE = i;
    }

    public void gH(boolean z) {
        this.dKF = z;
    }

    public int aBR() {
        return this.dKD;
    }

    public int Xb() {
        return com.baidu.tieba.frs.f.g.ml(this.dKD);
    }

    public boolean aBS() {
        return this.dKr;
    }

    public boolean aBT() {
        return this.dKD == 5;
    }

    public boolean aBU() {
        return this.dKp != null && this.dKp.getLoadType() == 1;
    }

    public boolean aBV() {
        return this.dKD == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.dKj.avV() != null) {
            return this.dKj.avV().a(this.dKD, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bb.akj.get() && r.bpV().bpP() != null) {
            int R = r.bpV().bpP().R(str, false);
            int S = r.bpV().bpP().S(str, false);
            if (frsRequestData.getLoadType() == 1) {
                R++;
            } else if (frsRequestData.getLoadType() == 2) {
                S++;
            }
            frsRequestData.setRefreshCount(R);
            frsRequestData.setLoadCount(S);
        }
    }

    public void aBW() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.drN != null && this.drN.bbH() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.d(this.drN.bbH().getId(), 0L));
        }
        this.dKj.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void nx(final String str) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bwy().cr(FrsModelController.this.dKG, str);
                return null;
            }
        }, null);
    }

    public void ny(final String str) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bwy().cs(FrsModelController.this.dKG, str);
                return null;
            }
        }, null);
    }

    public void nz(final String str) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bwy().ct(FrsModelController.this.dKG, str);
                return null;
            }
        }, null);
    }
}
