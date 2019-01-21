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
    private int bOc;
    private long bgL;
    private l dLd;
    private String dLt;
    private long dsI;
    private long dsJ;
    private long dsK;
    private long dsL;
    private FrsNetModel<FrsFragment> eco;
    private d.a ecq;
    private String ecr;
    private boolean edA;
    private SparseArray<ao> edB;
    private aa edC;
    private al edD;
    private ArrayList<com.baidu.adp.widget.ListView.h> edE;
    private boolean edF;
    private String edG;
    private int edH;
    private int edI;
    private boolean edJ;
    private String edK;
    private final SparseArray<Boolean> edL;
    private al edM;
    private final FrsFragment edn;
    private ArrayList<com.baidu.adp.widget.ListView.h> eds;
    private FrsRequestData edt;
    private final n edu;
    private boolean edv;
    private int edw;
    private int edx;
    private int edy;
    private ao edz;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean no(int i) {
        return this.edL.get(i, false).booleanValue();
    }

    public void q(int i, boolean z) {
        this.edL.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.dLt = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.edw = 0;
        this.mSource = null;
        this.ecr = null;
        this.bOc = 1;
        this.edx = 0;
        this.edy = 0;
        this.edA = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.edB = new SparseArray<>();
        this.bgL = 0L;
        this.edF = false;
        this.edH = -1;
        this.edI = -1;
        this.edK = null;
        this.edL = new SparseArray<>();
        this.edM = new al() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.al
            public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
                FrsModelController.this.edA = false;
                if (i == FrsModelController.this.bOc && FrsModelController.this.edD != null) {
                    FrsModelController.this.edz = arVar;
                    FrsModelController.this.b(i, i2, arVar);
                    ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.dLd.ay(arrayList2);
                    FrsModelController.this.edD.a(i, i2, arVar, arrayList);
                }
            }
        };
        this.dsI = 0L;
        this.dsJ = 0L;
        this.dsK = 0L;
        this.dsL = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.edn = frsFragment;
        this.edu = nVar;
        E(this.edn);
    }

    private void E(FrsFragment frsFragment) {
        this.edC = new aa();
        this.edC.beu = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.edC));
        this.edC.a(this.edM);
    }

    public void onActivityDestroy() {
        this.eco.cancelLoadData();
    }

    public void p(Bundle bundle) {
        if (bundle != null) {
            this.dLt = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.edG = bundle.getString("yuelaou_locate");
            this.edv = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.edw = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
        }
        if (TextUtils.isEmpty(this.dLt)) {
            this.dLt = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.edG)) {
            this.edG = "";
        }
        this.mSource = this.mFrom;
        aHt();
        this.dLd = new l();
        this.edt.cL("forum_name", k.bx(this.dLt));
        this.edt.cL("client_type", "2");
        this.eco = new FrsNetModel<>(this.edn.getPageContext(), this.edt);
        this.eco.a(this);
        this.eco.setUniqueId(this.edn.getPageContext().getUniqueId());
        if (this.dLt != null && this.dLt.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dLt);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void aHt() {
        this.edt = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            np(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            np(6);
        } else {
            np(com.baidu.tieba.frs.f.g.pe(this.dLt));
        }
        this.edt.setSortType(acy());
        if (this.edH == 5) {
            this.edt.setIsGood(1);
        } else {
            this.edt.setIsGood(0);
        }
    }

    public boolean asa() {
        if (this.bOc != 1) {
            nk(1);
            return true;
        } else if (this.eco.Fv()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.edt), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(acy());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void r(int i, boolean z) {
        this.edn.dLC = System.currentTimeMillis();
        if (this.dLd != null && this.dLd.bDc() != null) {
            this.dLd.bDc().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.edt), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bOc = c(this.bOc, frsRequestData);
        if (this.bOc == 1) {
            if (!this.eco.Fv()) {
                frsRequestData.setCallFrom(this.edw);
                a(frsRequestData, i, z ? false : true);
                this.edw = 0;
                return;
            }
            return;
        }
        if (this.edz == null) {
            this.edz = new ao();
            this.edz.pn = 1;
            this.edz.forumName = this.dLt;
            if (this.dLd != null && this.dLd.bhx() != null) {
                this.edz.forumId = this.dLd.bhx().getId();
            }
        }
        nk(i);
    }

    public void nl(int i) {
        if (this.bOc != 1) {
            nk(4);
        } else if (!this.eco.Fv()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.edt), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(acy());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.edn.gx(z);
        this.edu.mm(i);
        this.eco.a(frsRequestData);
        this.mType = i;
        frsRequestData.vJ(this.edn.aCn() ? "1" : "2");
        if (this.edJ) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.nF(this.edI)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.edJ = false;
        frsRequestData.setKw(this.dLt);
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
        frsRequestData.setLastId(this.ecr);
        frsRequestData.setYuelaouLocate(this.edG);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.d(w.QC(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.dLD != 0) {
            frsRequestData.setCtime((int) FrsFragment.dLD);
        }
        if (FrsFragment.dLE != 0) {
            frsRequestData.setDataSize((int) FrsFragment.dLE);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.g.a(this.edH, frsRequestData);
        b(i, frsRequestData);
        a(this.dLt, frsRequestData);
        if (!no(this.edH) && !this.edn.dLu) {
            String d = com.baidu.tieba.tbadkCore.c.bCD().d(this.dLt, frsRequestData.acy(), frsRequestData.getIsGood(), this.edt.getCategoryId());
            this.edK = d;
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
        if (iVar == null || iVar.bhx() == null || (com.baidu.tbadk.core.util.ao.isEmpty(iVar.bhx().getName()) && 340001 != iVar.dSA)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bOc = iVar.bDg();
        }
        this.dLd.g(iVar);
        f(this.dLd);
        this.eds = new ArrayList<>();
        if (frsRequestData != null) {
            this.edt = frsRequestData;
            this.mPn = this.edt.getPn();
            this.dLt = this.edt.getKw();
            this.edn.setForumName(this.dLt);
            this.edn.setFrom(this.mFrom);
            this.edn.setPn(this.mPn);
            this.edn.setFlag(this.mFlag);
        }
        if (this.dLd.getThreadList() != null) {
            this.eds.addAll(this.dLd.getThreadList());
        }
        if (this.bOc != 1 && this.isNetFirstLoad) {
            this.edu.a(7, false, this.ecq);
        } else {
            this.edu.a(this.mType, false, this.ecq);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.edt)) {
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
        aVar.hmh = com.baidu.adp.lib.util.j.kV() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.hmi = mvcSocketResponsedMessage.getDownSize();
        this.ecq = aVar;
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
        this.edn.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.edF) {
            this.edF = true;
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
        aVar.hmh = com.baidu.adp.lib.util.j.kV() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.hmi = mvcHttpResponsedMessage.getDownSize();
        this.ecq = aVar;
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
        this.edn.a(errorData);
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
        if (!this.edF) {
            this.edF = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void aCi() {
        if (this.dLd != null && this.dLd.bhx() != null && this.dLd.bhx().getBannerListData() != null) {
            String lastIds = this.dLd.bhx().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.ecr = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.PD().PE()) {
            this.bgL = System.currentTimeMillis() - this.edn.beginTime;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(i, z, responsedMessage, this.edn.bgC, this.edn.createTime, this.edn.bgK, false, this.bgL);
            this.edn.createTime = 0L;
            this.edn.bgC = 0L;
            if (iVar != null) {
                iVar.PA();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.PD().PE()) {
            this.bgL = System.currentTimeMillis() - this.edn.dLC;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(1000, z, responsedMessage, this.edn.bgC, this.edn.createTime, this.edn.bgK, false, this.bgL);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.bgT = this.bgL;
                    iVar.cO(true);
                } else if (this.mType == 3) {
                    iVar.bgU = this.bgL;
                    iVar.cO(false);
                }
            }
        }
    }

    public FrsRequestData aHu() {
        return this.edt;
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
        return this.dLd;
    }

    public d.a aHv() {
        return this.ecq;
    }

    private void aGZ() {
        this.dsI = System.currentTimeMillis();
        this.eco.OP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.dLd.g(iVar);
        f(this.dLd);
        this.eds = new ArrayList<>();
        if (this.dLd.getThreadList() != null) {
            this.eds.addAll(this.dLd.getThreadList());
        }
        this.edu.b(iVar);
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
        private String edQ;
        private FrsModelController edR;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.edQ = null;
            this.edQ = str;
            this.edR = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bCD().vH(this.edQ)) {
                if (!com.baidu.tieba.tbadkCore.c.bCD().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.edQ)) {
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
            if (this.edR != null && iVarArr != null) {
                this.edR.f(iVarArr.length > 0 ? iVarArr[0] : null);
                this.edR.q(this.edR.edH, true);
            }
        }
    }

    public long awJ() {
        return this.dsL;
    }

    public long awK() {
        return this.dsJ;
    }

    public long awL() {
        return this.dsK;
    }

    public long awM() {
        return this.dsI;
    }

    public boolean Fv() {
        return this.eco.Fv();
    }

    public int aHw() {
        return this.edy;
    }

    private void aHx() {
        if (this.edE == null) {
            this.edE = new ArrayList<>();
        }
        if (this.edE.size() == 0) {
            this.edE.add(new v());
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        this.bOc = c(i, null);
        if (aoVar == null && (aoVar = aX(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.ll() && this.edD != null) {
                ar arVar = new ar();
                arVar.hasMore = false;
                arVar.pn = 1;
                arVar.forumName = this.dLt;
                arVar.dPq = false;
                if (this.dLd != null && this.dLd.bhx() != null) {
                    arVar.forumId = this.dLd.bhx().getId();
                }
                aHx();
                this.dLd.ay(this.edE);
                this.edD.a(i, i2, arVar, this.edE);
            }
            aoVar = new ao();
            aoVar.pn = -1;
        }
        if (this.dLd != null && this.dLd.bhx() != null) {
            aoVar.forumId = this.dLd.bhx().getId();
        }
        aoVar.forumName = this.dLt;
        if (y.aDD().mB(1) != null && this.bOc == 1) {
            this.edt.setCategoryId(i2);
        }
        this.edx = i2;
        this.edz = aoVar;
        b(i, i2, aoVar);
        nk(5);
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.edD = alVar;
        this.edC.a(this.edM);
    }

    private void nk(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.edz != null) {
                    this.edz.pn++;
                    break;
                }
                break;
            case 2:
                if (this.edz != null) {
                    ao aoVar = this.edz;
                    aoVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.edz != null) {
                    this.edz.pn = -1;
                    break;
                }
                break;
        }
        if (this.bOc == 1) {
            if (this.edy == this.edx) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                if (this.eds != null) {
                    arrayList.addAll(this.eds);
                }
                this.dLd.ay(arrayList);
                if (this.edD != null) {
                    this.edD.a(this.bOc, this.edx, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.edy = this.edx;
            return;
        }
        ai mC = this.edC.mC(this.bOc);
        if (mC != null) {
            this.edA = true;
            mC.a(this.bOc, this.edx, this.edz);
            return;
        }
        if (this.dLd != null && this.dLd.getThreadList() != null) {
            this.dLd.getThreadList().clear();
        }
        this.edD.a(this.bOc, this.edx, null, null);
    }

    public boolean hasMore() {
        if ((this.edz instanceof ar) && ((ar) this.edz).errCode == 0) {
            return ((ar) this.edz).hasMore;
        }
        return true;
    }

    private int aW(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ao aoVar) {
        this.edB.put(aW(i, i2), aoVar);
    }

    public ao aX(int i, int i2) {
        return this.edB.get(aW(i, i2));
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        this.edC.init();
    }

    @Override // com.baidu.tieba.frs.ai
    public void acK() {
        this.edC.destory();
        this.edC.clear();
    }

    public int aHy() {
        return this.bOc;
    }

    public boolean aHz() {
        return 1 == this.bOc;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(com.baidu.tbadk.core.data.ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && !com.baidu.tbadk.core.util.v.I(this.eds)) {
            if (this.bOc == 1) {
                this.dLd.a(aiVar);
            }
            int aHA = aHA();
            Iterator<com.baidu.adp.widget.ListView.h> it = this.eds.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if ((next instanceof bb) && aiVar.getId().equals(((bb) next).getId())) {
                    return;
                }
            }
            this.eds.add(aHA, aiVar);
        }
    }

    public int aHA() {
        int i = 0;
        if (this.eds == null || this.eds.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.eds.iterator();
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
        return this.edA;
    }

    public void aHC() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.edy == 0) {
            mVar.mw(this.edH);
        }
        if (this.dLd.getThreadList() != null) {
            this.dLd.getThreadList().clear();
            this.dLd.getThreadList().add(mVar);
        }
        if (this.eds != null) {
            this.eds.clear();
            this.eds.add(mVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aHD() {
        return this.eds;
    }

    public void np(int i) {
        this.edH = i;
        com.baidu.tieba.frs.f.g.af(this.dLt, this.edH);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.bFP();
        } else {
            com.baidu.tieba.tbadkCore.util.e.bFQ();
        }
    }

    public void nq(int i) {
        this.edI = i;
    }

    public void hr(boolean z) {
        this.edJ = z;
    }

    public int aHE() {
        return this.edH;
    }

    public int acy() {
        return com.baidu.tieba.frs.f.g.nF(this.edH);
    }

    public boolean aHF() {
        return this.edv;
    }

    public boolean aHG() {
        return this.edH == 5;
    }

    public boolean aHH() {
        return this.edt != null && this.edt.getLoadType() == 1;
    }

    public boolean aHI() {
        return this.edH == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.edn.aBL() != null) {
            return this.edn.aBL().a(this.edH, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bb.atV.get() && r.bvT().bvN() != null) {
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
        if (this.dLd != null && this.dLd.bhx() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.d(this.dLd.bhx().getId(), 0L));
        }
        this.edn.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void oU(final String str) {
        com.baidu.tbadk.util.y.a(new x<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.x
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bCD().cI(FrsModelController.this.edK, str);
                return null;
            }
        }, null);
    }

    public void oV(final String str) {
        com.baidu.tbadk.util.y.a(new x<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.x
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bCD().cJ(FrsModelController.this.edK, str);
                return null;
            }
        }, null);
    }

    public void oW(final String str) {
        com.baidu.tbadk.util.y.a(new x<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.x
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bCD().cK(FrsModelController.this.edK, str);
                return null;
            }
        }, null);
    }
}
