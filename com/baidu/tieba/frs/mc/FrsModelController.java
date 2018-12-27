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
    private int bNp;
    private long bfZ;
    private String dKJ;
    private l dKt;
    private long drY;
    private long drZ;
    private long dsa;
    private long dsb;
    private FrsNetModel<FrsFragment> ebH;
    private d.a ebJ;
    private String ebK;
    private final FrsFragment ecG;
    private ArrayList<com.baidu.adp.widget.ListView.h> ecL;
    private FrsRequestData ecM;
    private final n ecN;
    private boolean ecO;
    private int ecP;
    private int ecQ;
    private int ecR;
    private ao ecS;
    private boolean ecT;
    private SparseArray<ao> ecU;
    private aa ecV;
    private al ecW;
    private ArrayList<com.baidu.adp.widget.ListView.h> ecX;
    private boolean ecY;
    private String ecZ;
    private int eda;
    private int edb;
    private boolean edc;
    private String edd;
    private final SparseArray<Boolean> ede;
    private al edf;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean nn(int i) {
        return this.ede.get(i, false).booleanValue();
    }

    public void q(int i, boolean z) {
        this.ede.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.dKJ = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.ecP = 0;
        this.mSource = null;
        this.ebK = null;
        this.bNp = 1;
        this.ecQ = 0;
        this.ecR = 0;
        this.ecT = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.ecU = new SparseArray<>();
        this.bfZ = 0L;
        this.ecY = false;
        this.eda = -1;
        this.edb = -1;
        this.edd = null;
        this.ede = new SparseArray<>();
        this.edf = new al() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.al
            public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
                FrsModelController.this.ecT = false;
                if (i == FrsModelController.this.bNp && FrsModelController.this.ecW != null) {
                    FrsModelController.this.ecS = arVar;
                    FrsModelController.this.b(i, i2, arVar);
                    ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.dKt.ay(arrayList2);
                    FrsModelController.this.ecW.a(i, i2, arVar, arrayList);
                }
            }
        };
        this.drY = 0L;
        this.drZ = 0L;
        this.dsa = 0L;
        this.dsb = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.ecG = frsFragment;
        this.ecN = nVar;
        E(this.ecG);
    }

    private void E(FrsFragment frsFragment) {
        this.ecV = new aa();
        this.ecV.bdH = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.ecV));
        this.ecV.a(this.edf);
    }

    public void onActivityDestroy() {
        this.ebH.cancelLoadData();
    }

    public void p(Bundle bundle) {
        if (bundle != null) {
            this.dKJ = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.ecZ = bundle.getString("yuelaou_locate");
            this.ecO = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.ecP = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
        }
        if (TextUtils.isEmpty(this.dKJ)) {
            this.dKJ = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.ecZ)) {
            this.ecZ = "";
        }
        this.mSource = this.mFrom;
        aGW();
        this.dKt = new l();
        this.ebH = new FrsNetModel<>(this.ecG.getPageContext(), this.ecM);
        this.ebH.a(this);
        this.ebH.setUniqueId(this.ecG.getPageContext().getUniqueId());
        if (this.dKJ != null && this.dKJ.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dKJ);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void aGW() {
        this.ecM = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            no(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            no(6);
        } else {
            no(com.baidu.tieba.frs.f.g.oO(this.dKJ));
        }
        this.ecM.setSortType(acb());
        if (this.eda == 5) {
            this.ecM.setIsGood(1);
        } else {
            this.ecM.setIsGood(0);
        }
    }

    public boolean arC() {
        if (this.bNp != 1) {
            nj(1);
            return true;
        } else if (this.ebH.Fi()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.ecM), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(acb());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void r(int i, boolean z) {
        this.ecG.dKS = System.currentTimeMillis();
        if (this.dKt != null && this.dKt.bCt() != null) {
            this.dKt.bCt().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.ecM), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bNp = c(this.bNp, frsRequestData);
        if (this.bNp == 1) {
            if (!this.ebH.Fi()) {
                frsRequestData.setCallFrom(this.ecP);
                a(frsRequestData, i, z ? false : true);
                this.ecP = 0;
                return;
            }
            return;
        }
        if (this.ecS == null) {
            this.ecS = new ao();
            this.ecS.pn = 1;
            this.ecS.forumName = this.dKJ;
            if (this.dKt != null && this.dKt.bgT() != null) {
                this.ecS.forumId = this.dKt.bgT().getId();
            }
        }
        nj(i);
    }

    public void nk(int i) {
        if (this.bNp != 1) {
            nj(4);
        } else if (!this.ebH.Fi()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.ecM), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(acb());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.ecG.gu(z);
        this.ecN.ml(i);
        this.ebH.a(frsRequestData);
        this.mType = i;
        frsRequestData.vt(this.ecG.aBQ() ? "1" : "2");
        if (this.edc) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.nE(this.edb)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.edc = false;
        frsRequestData.setKw(this.dKJ);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst());
        float aR = com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
        int i2 = aq.DR().DT() ? 2 : 1;
        frsRequestData.setScrW(aO);
        frsRequestData.setScrH(aQ);
        frsRequestData.setScrDip(aR);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.ebK);
        frsRequestData.setYuelaouLocate(this.ecZ);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.d(v.Qh(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.dKT != 0) {
            frsRequestData.setCtime((int) FrsFragment.dKT);
        }
        if (FrsFragment.dKU != 0) {
            frsRequestData.setDataSize((int) FrsFragment.dKU);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.g.a(this.eda, frsRequestData);
        b(i, frsRequestData);
        a(this.dKJ, frsRequestData);
        if (!nn(this.eda) && !this.ecG.dKK) {
            String d = com.baidu.tieba.tbadkCore.c.bBU().d(this.dKJ, frsRequestData.acb(), frsRequestData.getIsGood(), this.ecM.getCategoryId());
            this.edd = d;
            new a(this, true, d).execute(new Object[0]);
        }
        aGC();
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
        if (iVar == null || iVar.bgT() == null || (com.baidu.tbadk.core.util.ao.isEmpty(iVar.bgT().getName()) && 340001 != iVar.dRQ)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bNp = iVar.bCx();
        }
        this.dKt.g(iVar);
        f(this.dKt);
        this.ecL = new ArrayList<>();
        if (frsRequestData != null) {
            this.ecM = frsRequestData;
            this.mPn = this.ecM.getPn();
            this.dKJ = this.ecM.getKw();
            this.ecG.setForumName(this.dKJ);
            this.ecG.setFrom(this.mFrom);
            this.ecG.setPn(this.mPn);
            this.ecG.setFlag(this.mFlag);
        }
        if (this.dKt.getThreadList() != null) {
            this.ecL.addAll(this.dKt.getThreadList());
        }
        if (this.bNp != 1 && this.isNetFirstLoad) {
            this.ecN.a(7, false, this.ebJ);
        } else {
            this.ecN.a(this.mType, false, this.ebJ);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.ecM)) {
            aHm();
        }
        this.isNetFirstLoad = false;
        if (iVar.bgT() == null || TextUtils.isEmpty(iVar.bgT().getName()) || frsRequestData == null || r.bvk().bve() == null) {
            return true;
        }
        r.bvk().bve().f(iVar.bgT().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.hlc = com.baidu.adp.lib.util.j.kV() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.hld = mvcSocketResponsedMessage.getDownSize();
        this.ebJ = aVar;
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
        this.ecG.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.ecY) {
            this.ecY = true;
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
        aVar.hlc = com.baidu.adp.lib.util.j.kV() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.hld = mvcHttpResponsedMessage.getDownSize();
        this.ebJ = aVar;
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
        this.ecG.a(errorData);
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
        if (!this.ecY) {
            this.ecY = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void aBL() {
        if (this.dKt != null && this.dKt.bgT() != null && this.dKt.bgT().getBannerListData() != null) {
            String lastIds = this.dKt.bgT().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.ebK = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.Pl().Pm()) {
            this.bfZ = System.currentTimeMillis() - this.ecG.beginTime;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(i, z, responsedMessage, this.ecG.bfQ, this.ecG.createTime, this.ecG.bfY, false, this.bfZ);
            this.ecG.createTime = 0L;
            this.ecG.bfQ = 0L;
            if (iVar != null) {
                iVar.Pi();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.Pl().Pm()) {
            this.bfZ = System.currentTimeMillis() - this.ecG.dKS;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(1000, z, responsedMessage, this.ecG.bfQ, this.ecG.createTime, this.ecG.bfY, false, this.bfZ);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.bgh = this.bfZ;
                    iVar.cL(true);
                } else if (this.mType == 3) {
                    iVar.bgi = this.bfZ;
                    iVar.cL(false);
                }
            }
        }
    }

    public FrsRequestData aGX() {
        return this.ecM;
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

    public l aGB() {
        return this.dKt;
    }

    public d.a aGY() {
        return this.ebJ;
    }

    private void aGC() {
        this.drY = System.currentTimeMillis();
        this.ebH.Ox();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.dKt.g(iVar);
        f(this.dKt);
        this.ecL = new ArrayList<>();
        if (this.dKt.getThreadList() != null) {
            this.ecL.addAll(this.dKt.getThreadList());
        }
        this.ecN.b(iVar);
    }

    private void f(l lVar) {
        if (com.baidu.tieba.frs.vc.f.k(lVar)) {
            this.mPageType = "book_page";
        } else if (lVar.bDc()) {
            this.mPageType = "brand_page";
        } else if (com.baidu.tieba.frs.vc.f.l(lVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.i, Void> {
        private String edj;
        private FrsModelController edk;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.edj = null;
            this.edj = str;
            this.edk = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bBU().vr(this.edj)) {
                if (!com.baidu.tieba.tbadkCore.c.bBU().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.edj)) {
                    com.baidu.tieba.tbadkCore.c.bBU().getResponseData().bgT().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.i responseData = com.baidu.tieba.tbadkCore.c.bBU().getResponseData();
                responseData.ns(false);
                if (responseData.bCz() != null && !StringUtils.isNull(responseData.bCz().yl(), true) && !responseData.bCz().yl().equals("0") && responseData.bCz().ym() == 3 && (l = com.baidu.adp.lib.g.b.l(responseData.bCz().yl(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(l))) != null) {
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
            if (this.edk != null && iVarArr != null) {
                this.edk.f(iVarArr.length > 0 ? iVarArr[0] : null);
                this.edk.q(this.edk.eda, true);
            }
        }
    }

    public long awm() {
        return this.dsb;
    }

    public long awn() {
        return this.drZ;
    }

    public long awo() {
        return this.dsa;
    }

    public long awp() {
        return this.drY;
    }

    public boolean Fi() {
        return this.ebH.Fi();
    }

    public int aGZ() {
        return this.ecR;
    }

    private void aHa() {
        if (this.ecX == null) {
            this.ecX = new ArrayList<>();
        }
        if (this.ecX.size() == 0) {
            this.ecX.add(new com.baidu.tieba.frs.v());
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        this.bNp = c(i, null);
        if (aoVar == null && (aoVar = aX(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.ll() && this.ecW != null) {
                ar arVar = new ar();
                arVar.hasMore = false;
                arVar.pn = 1;
                arVar.forumName = this.dKJ;
                arVar.dOG = false;
                if (this.dKt != null && this.dKt.bgT() != null) {
                    arVar.forumId = this.dKt.bgT().getId();
                }
                aHa();
                this.dKt.ay(this.ecX);
                this.ecW.a(i, i2, arVar, this.ecX);
            }
            aoVar = new ao();
            aoVar.pn = -1;
        }
        if (this.dKt != null && this.dKt.bgT() != null) {
            aoVar.forumId = this.dKt.bgT().getId();
        }
        aoVar.forumName = this.dKJ;
        if (y.aDg().mA(1) != null && this.bNp == 1) {
            this.ecM.setCategoryId(i2);
        }
        this.ecQ = i2;
        this.ecS = aoVar;
        b(i, i2, aoVar);
        nj(5);
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.ecW = alVar;
        this.ecV.a(this.edf);
    }

    private void nj(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.ecS != null) {
                    this.ecS.pn++;
                    break;
                }
                break;
            case 2:
                if (this.ecS != null) {
                    ao aoVar = this.ecS;
                    aoVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.ecS != null) {
                    this.ecS.pn = -1;
                    break;
                }
                break;
        }
        if (this.bNp == 1) {
            if (this.ecR == this.ecQ) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                if (this.ecL != null) {
                    arrayList.addAll(this.ecL);
                }
                this.dKt.ay(arrayList);
                if (this.ecW != null) {
                    this.ecW.a(this.bNp, this.ecQ, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.ecR = this.ecQ;
            return;
        }
        ai mB = this.ecV.mB(this.bNp);
        if (mB != null) {
            this.ecT = true;
            mB.a(this.bNp, this.ecQ, this.ecS);
            return;
        }
        if (this.dKt != null && this.dKt.getThreadList() != null) {
            this.dKt.getThreadList().clear();
        }
        this.ecW.a(this.bNp, this.ecQ, null, null);
    }

    public boolean hasMore() {
        if ((this.ecS instanceof ar) && ((ar) this.ecS).errCode == 0) {
            return ((ar) this.ecS).hasMore;
        }
        return true;
    }

    private int aW(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ao aoVar) {
        this.ecU.put(aW(i, i2), aoVar);
    }

    public ao aX(int i, int i2) {
        return this.ecU.get(aW(i, i2));
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        this.ecV.init();
    }

    @Override // com.baidu.tieba.frs.ai
    public void acn() {
        this.ecV.destory();
        this.ecV.clear();
    }

    public int aHb() {
        return this.bNp;
    }

    public boolean aHc() {
        return 1 == this.bNp;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(com.baidu.tbadk.core.data.ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && !com.baidu.tbadk.core.util.v.I(this.ecL)) {
            if (this.bNp == 1) {
                this.dKt.a(aiVar);
            }
            int aHd = aHd();
            Iterator<com.baidu.adp.widget.ListView.h> it = this.ecL.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if ((next instanceof bb) && aiVar.getId().equals(((bb) next).getId())) {
                    return;
                }
            }
            this.ecL.add(aHd, aiVar);
        }
    }

    public int aHd() {
        int i = 0;
        if (this.ecL == null || this.ecL.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.ecL.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (!(next instanceof bb)) {
                    i = i2;
                } else if (((bb) next).zB() != 0) {
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

    public boolean aHe() {
        return this.ecT;
    }

    public void aHf() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.ecR == 0) {
            mVar.mv(this.eda);
        }
        if (this.dKt.getThreadList() != null) {
            this.dKt.getThreadList().clear();
            this.dKt.getThreadList().add(mVar);
        }
        if (this.ecL != null) {
            this.ecL.clear();
            this.ecL.add(mVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aHg() {
        return this.ecL;
    }

    public void no(int i) {
        this.eda = i;
        com.baidu.tieba.frs.f.g.af(this.dKJ, this.eda);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.bFg();
        } else {
            com.baidu.tieba.tbadkCore.util.e.bFh();
        }
    }

    public void np(int i) {
        this.edb = i;
    }

    public void ho(boolean z) {
        this.edc = z;
    }

    public int aHh() {
        return this.eda;
    }

    public int acb() {
        return com.baidu.tieba.frs.f.g.nE(this.eda);
    }

    public boolean aHi() {
        return this.ecO;
    }

    public boolean aHj() {
        return this.eda == 5;
    }

    public boolean aHk() {
        return this.ecM != null && this.ecM.getLoadType() == 1;
    }

    public boolean aHl() {
        return this.eda == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.ecG.aBo() != null) {
            return this.ecG.aBo().a(this.eda, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bb.ats.get() && r.bvk().bve() != null) {
            int aa = r.bvk().bve().aa(str, false);
            int ab = r.bvk().bve().ab(str, false);
            if (frsRequestData.getLoadType() == 1) {
                aa++;
            } else if (frsRequestData.getLoadType() == 2) {
                ab++;
            }
            frsRequestData.setRefreshCount(aa);
            frsRequestData.setLoadCount(ab);
        }
    }

    public void aHm() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.dKt != null && this.dKt.bgT() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.d(this.dKt.bgT().getId(), 0L));
        }
        this.ecG.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void oE(final String str) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bBU().cH(FrsModelController.this.edd, str);
                return null;
            }
        }, null);
    }

    public void oF(final String str) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bBU().cI(FrsModelController.this.edd, str);
                return null;
            }
        }, null);
    }

    public void oG(final String str) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bBU().cJ(FrsModelController.this.edd, str);
                return null;
            }
        }, null);
    }
}
