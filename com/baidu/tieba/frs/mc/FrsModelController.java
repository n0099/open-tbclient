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
import com.baidu.adp.lib.util.k;
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
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.v;
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
    private int bOb;
    private long bgK;
    private l dLc;
    private String dLs;
    private long dsH;
    private long dsI;
    private long dsJ;
    private long dsK;
    private FrsNetModel<FrsFragment> ecn;
    private d.a ecp;
    private String ecq;
    private SparseArray<ao> edA;
    private aa edB;
    private al edC;
    private ArrayList<com.baidu.adp.widget.ListView.h> edD;
    private boolean edE;
    private String edF;
    private int edG;
    private int edH;
    private boolean edI;
    private String edJ;
    private final SparseArray<Boolean> edK;
    private al edL;
    private final FrsFragment edm;
    private ArrayList<com.baidu.adp.widget.ListView.h> edr;
    private FrsRequestData eds;
    private final n edt;
    private boolean edu;
    private int edv;
    private int edw;
    private int edx;
    private ao edy;
    private boolean edz;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean no(int i) {
        return this.edK.get(i, false).booleanValue();
    }

    public void q(int i, boolean z) {
        this.edK.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.dLs = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.edv = 0;
        this.mSource = null;
        this.ecq = null;
        this.bOb = 1;
        this.edw = 0;
        this.edx = 0;
        this.edz = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.edA = new SparseArray<>();
        this.bgK = 0L;
        this.edE = false;
        this.edG = -1;
        this.edH = -1;
        this.edJ = null;
        this.edK = new SparseArray<>();
        this.edL = new al() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.al
            public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
                FrsModelController.this.edz = false;
                if (i == FrsModelController.this.bOb && FrsModelController.this.edC != null) {
                    FrsModelController.this.edy = arVar;
                    FrsModelController.this.b(i, i2, arVar);
                    ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.dLc.ay(arrayList2);
                    FrsModelController.this.edC.a(i, i2, arVar, arrayList);
                }
            }
        };
        this.dsH = 0L;
        this.dsI = 0L;
        this.dsJ = 0L;
        this.dsK = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.edm = frsFragment;
        this.edt = nVar;
        E(this.edm);
    }

    private void E(FrsFragment frsFragment) {
        this.edB = new aa();
        this.edB.bes = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.edB));
        this.edB.a(this.edL);
    }

    public void onActivityDestroy() {
        this.ecn.cancelLoadData();
    }

    public void p(Bundle bundle) {
        if (bundle != null) {
            this.dLs = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.edF = bundle.getString("yuelaou_locate");
            this.edu = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.edv = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
        }
        if (TextUtils.isEmpty(this.dLs)) {
            this.dLs = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.edF)) {
            this.edF = "";
        }
        this.mSource = this.mFrom;
        aHt();
        this.dLc = new l();
        this.eds.cL("forum_name", k.bx(this.dLs));
        this.eds.cL("client_type", "2");
        this.ecn = new FrsNetModel<>(this.edm.getPageContext(), this.eds);
        this.ecn.a(this);
        this.ecn.setUniqueId(this.edm.getPageContext().getUniqueId());
        if (this.dLs != null && this.dLs.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dLs);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void aHt() {
        this.eds = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            np(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            np(6);
        } else {
            np(com.baidu.tieba.frs.f.g.pe(this.dLs));
        }
        this.eds.setSortType(acy());
        if (this.edG == 5) {
            this.eds.setIsGood(1);
        } else {
            this.eds.setIsGood(0);
        }
    }

    public boolean asa() {
        if (this.bOb != 1) {
            nk(1);
            return true;
        } else if (this.ecn.Fv()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.eds), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(acy());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void r(int i, boolean z) {
        this.edm.dLB = System.currentTimeMillis();
        if (this.dLc != null && this.dLc.bDc() != null) {
            this.dLc.bDc().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.eds), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bOb = c(this.bOb, frsRequestData);
        if (this.bOb == 1) {
            if (!this.ecn.Fv()) {
                frsRequestData.setCallFrom(this.edv);
                a(frsRequestData, i, z ? false : true);
                this.edv = 0;
                return;
            }
            return;
        }
        if (this.edy == null) {
            this.edy = new ao();
            this.edy.pn = 1;
            this.edy.forumName = this.dLs;
            if (this.dLc != null && this.dLc.bhx() != null) {
                this.edy.forumId = this.dLc.bhx().getId();
            }
        }
        nk(i);
    }

    public void nl(int i) {
        if (this.bOb != 1) {
            nk(4);
        } else if (!this.ecn.Fv()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.eds), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(acy());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.edm.gx(z);
        this.edt.mm(i);
        this.ecn.a(frsRequestData);
        this.mType = i;
        frsRequestData.vJ(this.edm.aCn() ? "1" : "2");
        if (this.edI) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.nF(this.edH)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.edI = false;
        frsRequestData.setKw(this.dLs);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst());
        float aR = com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
        int i2 = aq.Ee().Eg() ? 2 : 1;
        frsRequestData.setScrW(aO);
        frsRequestData.setScrH(aQ);
        frsRequestData.setScrDip(aR);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.ecq);
        frsRequestData.setYuelaouLocate(this.edF);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.d(w.QC(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.dLC != 0) {
            frsRequestData.setCtime((int) FrsFragment.dLC);
        }
        if (FrsFragment.dLD != 0) {
            frsRequestData.setDataSize((int) FrsFragment.dLD);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.g.a(this.edG, frsRequestData);
        b(i, frsRequestData);
        a(this.dLs, frsRequestData);
        if (!no(this.edG) && !this.edm.dLt) {
            String d = com.baidu.tieba.tbadkCore.c.bCD().d(this.dLs, frsRequestData.acy(), frsRequestData.getIsGood(), this.eds.getCategoryId());
            this.edJ = d;
            new a(this, true, d).execute(new Object[0]);
        }
        aGZ();
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
        if (iVar == null || iVar.bhx() == null || (com.baidu.tbadk.core.util.ao.isEmpty(iVar.bhx().getName()) && 340001 != iVar.dSz)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bOb = iVar.bDg();
        }
        this.dLc.g(iVar);
        f(this.dLc);
        this.edr = new ArrayList<>();
        if (frsRequestData != null) {
            this.eds = frsRequestData;
            this.mPn = this.eds.getPn();
            this.dLs = this.eds.getKw();
            this.edm.setForumName(this.dLs);
            this.edm.setFrom(this.mFrom);
            this.edm.setPn(this.mPn);
            this.edm.setFlag(this.mFlag);
        }
        if (this.dLc.getThreadList() != null) {
            this.edr.addAll(this.dLc.getThreadList());
        }
        if (this.bOb != 1 && this.isNetFirstLoad) {
            this.edt.a(7, false, this.ecp);
        } else {
            this.edt.a(this.mType, false, this.ecp);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.eds)) {
            aHJ();
        }
        this.isNetFirstLoad = false;
        if (iVar.bhx() == null || TextUtils.isEmpty(iVar.bhx().getName()) || frsRequestData == null || r.bvT().bvN() == null) {
            return true;
        }
        r.bvT().bvN().f(iVar.bhx().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.hmg = com.baidu.adp.lib.util.j.kV() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.hmh = mvcSocketResponsedMessage.getDownSize();
        this.ecp = aVar;
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
        this.edm.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.edE) {
            this.edE = true;
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
        aVar.hmg = com.baidu.adp.lib.util.j.kV() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.hmh = mvcHttpResponsedMessage.getDownSize();
        this.ecp = aVar;
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
        this.edm.a(errorData);
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
        if (!this.edE) {
            this.edE = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void aCi() {
        if (this.dLc != null && this.dLc.bhx() != null && this.dLc.bhx().getBannerListData() != null) {
            String lastIds = this.dLc.bhx().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.ecq = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.PD().PE()) {
            this.bgK = System.currentTimeMillis() - this.edm.beginTime;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(i, z, responsedMessage, this.edm.bgB, this.edm.createTime, this.edm.bgJ, false, this.bgK);
            this.edm.createTime = 0L;
            this.edm.bgB = 0L;
            if (iVar != null) {
                iVar.PA();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.PD().PE()) {
            this.bgK = System.currentTimeMillis() - this.edm.dLB;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(1000, z, responsedMessage, this.edm.bgB, this.edm.createTime, this.edm.bgJ, false, this.bgK);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.bgS = this.bgK;
                    iVar.cO(true);
                } else if (this.mType == 3) {
                    iVar.bgT = this.bgK;
                    iVar.cO(false);
                }
            }
        }
    }

    public FrsRequestData aHu() {
        return this.eds;
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

    public l aGY() {
        return this.dLc;
    }

    public d.a aHv() {
        return this.ecp;
    }

    private void aGZ() {
        this.dsH = System.currentTimeMillis();
        this.ecn.OP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.dLc.g(iVar);
        f(this.dLc);
        this.edr = new ArrayList<>();
        if (this.dLc.getThreadList() != null) {
            this.edr.addAll(this.dLc.getThreadList());
        }
        this.edt.b(iVar);
    }

    private void f(l lVar) {
        if (com.baidu.tieba.frs.vc.f.k(lVar)) {
            this.mPageType = "book_page";
        } else if (lVar.bDL()) {
            this.mPageType = "brand_page";
        } else if (com.baidu.tieba.frs.vc.f.l(lVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.i, Void> {
        private String edP;
        private FrsModelController edQ;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.edP = null;
            this.edP = str;
            this.edQ = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bCD().vH(this.edP)) {
                if (!com.baidu.tieba.tbadkCore.c.bCD().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.edP)) {
                    com.baidu.tieba.tbadkCore.c.bCD().getResponseData().bhx().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.i responseData = com.baidu.tieba.tbadkCore.c.bCD().getResponseData();
                responseData.nt(false);
                if (responseData.bDi() != null && !StringUtils.isNull(responseData.bDi().yy(), true) && !responseData.bDi().yy().equals("0") && responseData.bDi().yz() == 3 && (l = com.baidu.adp.lib.g.b.l(responseData.bDi().yy(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(l))) != null) {
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
            if (this.edQ != null && iVarArr != null) {
                this.edQ.f(iVarArr.length > 0 ? iVarArr[0] : null);
                this.edQ.q(this.edQ.edG, true);
            }
        }
    }

    public long awJ() {
        return this.dsK;
    }

    public long awK() {
        return this.dsI;
    }

    public long awL() {
        return this.dsJ;
    }

    public long awM() {
        return this.dsH;
    }

    public boolean Fv() {
        return this.ecn.Fv();
    }

    public int aHw() {
        return this.edx;
    }

    private void aHx() {
        if (this.edD == null) {
            this.edD = new ArrayList<>();
        }
        if (this.edD.size() == 0) {
            this.edD.add(new v());
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        this.bOb = c(i, null);
        if (aoVar == null && (aoVar = aX(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.ll() && this.edC != null) {
                ar arVar = new ar();
                arVar.hasMore = false;
                arVar.pn = 1;
                arVar.forumName = this.dLs;
                arVar.dPp = false;
                if (this.dLc != null && this.dLc.bhx() != null) {
                    arVar.forumId = this.dLc.bhx().getId();
                }
                aHx();
                this.dLc.ay(this.edD);
                this.edC.a(i, i2, arVar, this.edD);
            }
            aoVar = new ao();
            aoVar.pn = -1;
        }
        if (this.dLc != null && this.dLc.bhx() != null) {
            aoVar.forumId = this.dLc.bhx().getId();
        }
        aoVar.forumName = this.dLs;
        if (y.aDD().mB(1) != null && this.bOb == 1) {
            this.eds.setCategoryId(i2);
        }
        this.edw = i2;
        this.edy = aoVar;
        b(i, i2, aoVar);
        nk(5);
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.edC = alVar;
        this.edB.a(this.edL);
    }

    private void nk(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.edy != null) {
                    this.edy.pn++;
                    break;
                }
                break;
            case 2:
                if (this.edy != null) {
                    ao aoVar = this.edy;
                    aoVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.edy != null) {
                    this.edy.pn = -1;
                    break;
                }
                break;
        }
        if (this.bOb == 1) {
            if (this.edx == this.edw) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                if (this.edr != null) {
                    arrayList.addAll(this.edr);
                }
                this.dLc.ay(arrayList);
                if (this.edC != null) {
                    this.edC.a(this.bOb, this.edw, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.edx = this.edw;
            return;
        }
        ai mC = this.edB.mC(this.bOb);
        if (mC != null) {
            this.edz = true;
            mC.a(this.bOb, this.edw, this.edy);
            return;
        }
        if (this.dLc != null && this.dLc.getThreadList() != null) {
            this.dLc.getThreadList().clear();
        }
        this.edC.a(this.bOb, this.edw, null, null);
    }

    public boolean hasMore() {
        if ((this.edy instanceof ar) && ((ar) this.edy).errCode == 0) {
            return ((ar) this.edy).hasMore;
        }
        return true;
    }

    private int aW(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ao aoVar) {
        this.edA.put(aW(i, i2), aoVar);
    }

    public ao aX(int i, int i2) {
        return this.edA.get(aW(i, i2));
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        this.edB.init();
    }

    @Override // com.baidu.tieba.frs.ai
    public void acK() {
        this.edB.destory();
        this.edB.clear();
    }

    public int aHy() {
        return this.bOb;
    }

    public boolean aHz() {
        return 1 == this.bOb;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(com.baidu.tbadk.core.data.ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && !com.baidu.tbadk.core.util.v.I(this.edr)) {
            if (this.bOb == 1) {
                this.dLc.a(aiVar);
            }
            int aHA = aHA();
            Iterator<com.baidu.adp.widget.ListView.h> it = this.edr.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if ((next instanceof bb) && aiVar.getId().equals(((bb) next).getId())) {
                    return;
                }
            }
            this.edr.add(aHA, aiVar);
        }
    }

    public int aHA() {
        int i = 0;
        if (this.edr == null || this.edr.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.edr.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (!(next instanceof bb)) {
                    i = i2;
                } else if (((bb) next).zO() != 0) {
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

    public boolean aHB() {
        return this.edz;
    }

    public void aHC() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.edx == 0) {
            mVar.mw(this.edG);
        }
        if (this.dLc.getThreadList() != null) {
            this.dLc.getThreadList().clear();
            this.dLc.getThreadList().add(mVar);
        }
        if (this.edr != null) {
            this.edr.clear();
            this.edr.add(mVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aHD() {
        return this.edr;
    }

    public void np(int i) {
        this.edG = i;
        com.baidu.tieba.frs.f.g.af(this.dLs, this.edG);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.bFP();
        } else {
            com.baidu.tieba.tbadkCore.util.e.bFQ();
        }
    }

    public void nq(int i) {
        this.edH = i;
    }

    public void hr(boolean z) {
        this.edI = z;
    }

    public int aHE() {
        return this.edG;
    }

    public int acy() {
        return com.baidu.tieba.frs.f.g.nF(this.edG);
    }

    public boolean aHF() {
        return this.edu;
    }

    public boolean aHG() {
        return this.edG == 5;
    }

    public boolean aHH() {
        return this.eds != null && this.eds.getLoadType() == 1;
    }

    public boolean aHI() {
        return this.edG == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.edm.aBL() != null) {
            return this.edm.aBL().a(this.edG, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bb.atU.get() && r.bvT().bvN() != null) {
            int Z = r.bvT().bvN().Z(str, false);
            int aa = r.bvT().bvN().aa(str, false);
            if (frsRequestData.getLoadType() == 1) {
                Z++;
            } else if (frsRequestData.getLoadType() == 2) {
                aa++;
            }
            frsRequestData.setRefreshCount(Z);
            frsRequestData.setLoadCount(aa);
        }
    }

    public void aHJ() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.dLc != null && this.dLc.bhx() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.d(this.dLc.bhx().getId(), 0L));
        }
        this.edm.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void oU(final String str) {
        com.baidu.tbadk.util.y.a(new x<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.x
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bCD().cI(FrsModelController.this.edJ, str);
                return null;
            }
        }, null);
    }

    public void oV(final String str) {
        com.baidu.tbadk.util.y.a(new x<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.x
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bCD().cJ(FrsModelController.this.edJ, str);
                return null;
            }
        }, null);
    }

    public void oW(final String str) {
        com.baidu.tbadk.util.y.a(new x<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.x
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bCD().cK(FrsModelController.this.edJ, str);
                return null;
            }
        }, null);
    }
}
