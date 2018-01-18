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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.k.m;
import com.baidu.tbadk.k.r;
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
import com.baidu.tieba.recapp.q;
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
    private int bXD;
    private long byx;
    private l dAN;
    private String dBb;
    private FrsNetModel<com.baidu.tieba.frs.i> dOF;
    private d.a dOH;
    private String dOI;
    private SparseArray<aq> dPA;
    private ac dPB;
    private an dPC;
    private ArrayList<com.baidu.adp.widget.ListView.i> dPD;
    private boolean dPE;
    private String dPF;
    private int dPG;
    private int dPH;
    private boolean dPI;
    private String dPJ;
    private final SparseArray<Boolean> dPK;
    private an dPL;
    private final com.baidu.tieba.frs.i dPp;
    private ArrayList<com.baidu.adp.widget.ListView.i> dPs;
    private FrsRequestData dPt;
    private final n dPu;
    private boolean dPv;
    private int dPw;
    private int dPx;
    private aq dPy;
    private boolean dPz;
    private long dmT;
    private long dmU;
    private long dmV;
    private long dmW;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean nG(int i) {
        return this.dPK.get(i, false).booleanValue();
    }

    public void A(int i, boolean z) {
        this.dPK.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.i iVar, n nVar) {
        super(iVar.getPageContext());
        this.dBb = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.dOI = null;
        this.bXD = 1;
        this.dPw = 0;
        this.dPx = 0;
        this.dPz = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.dPA = new SparseArray<>();
        this.byx = 0L;
        this.dPE = false;
        this.dPG = -1;
        this.dPH = -1;
        this.dPJ = null;
        this.dPK = new SparseArray<>();
        this.dPL = new an() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.an
            public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
                FrsModelController.this.dPz = false;
                if (i == FrsModelController.this.bXD && FrsModelController.this.dPC != null) {
                    FrsModelController.this.dPy = atVar;
                    FrsModelController.this.b(i, i2, atVar);
                    ArrayList<com.baidu.adp.widget.ListView.i> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.dAN.at(arrayList2);
                    if ((i == 1 || i == 5) && !FrsModelController.this.ayu()) {
                        FrsModelController.this.dAN.bux();
                        FrsModelController.this.dAN.buy();
                    }
                    FrsModelController.this.dPC.a(i, i2, atVar, arrayList);
                }
            }
        };
        this.dmT = 0L;
        this.dmU = 0L;
        this.dmV = 0L;
        this.dmW = 0L;
        if (iVar == null || nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.dPp = iVar;
        this.dPu = nVar;
        y(this.dPp);
    }

    private void y(com.baidu.tieba.frs.i iVar) {
        this.dPB = new ac();
        this.dPB.bGw = iVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.dPB));
        this.dPB.a(this.dPL);
    }

    public void onActivityDestroy() {
        this.dOF.cancelLoadData();
    }

    public void k(Bundle bundle) {
        if (bundle != null) {
            this.dBb = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dPF = bundle.getString("yuelaou_locate");
            this.dPv = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.dBb)) {
            this.dBb = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.dPF)) {
            this.dPF = "";
        }
        this.mSource = this.mFrom;
        this.dPt = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            nH(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            nH(6);
        } else {
            com.baidu.tieba.frs.smartsort.f lV = com.baidu.tieba.frs.smartsort.d.ayF().lV(this.dBb);
            if (lV != null) {
                nH(lV.dQw);
            } else {
                nH(-1);
            }
        }
        this.dPt.setSortType(XF());
        if (this.dPG == 5) {
            this.dPt.setIsGood(1);
        } else {
            this.dPt.setIsGood(0);
        }
        this.dAN = new l();
        this.dOF = new FrsNetModel<>(this.dPp.getPageContext(), this.dPt);
        this.dOF.a(this);
        this.dOF.setUniqueId(this.dPp.getUniqueId());
        if (this.dBb != null && this.dBb.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dBb);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean alZ() {
        if (this.bXD != 1) {
            nD(1);
            return true;
        } else if (this.dOF.DP()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dPt), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(XF());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void B(int i, boolean z) {
        if (this.dAN != null && this.dAN.btS() != null) {
            this.dAN.btS().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dPt), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bXD = c(this.bXD, frsRequestData);
        if (this.bXD == 1) {
            if (!this.dOF.DP()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.dPy == null) {
            this.dPy = new aq();
            this.dPy.pn = 1;
            this.dPy.forumName = this.dBb;
            if (this.dAN != null && this.dAN.aYE() != null) {
                this.dPy.forumId = this.dAN.aYE().getId();
            }
        }
        nD(i);
    }

    public void nE(int i) {
        if (this.bXD != 1) {
            nD(4);
        } else if (!this.dOF.DP()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dPt), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(XF());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.dPu.mT(i);
        this.dOF.a(frsRequestData);
        this.mType = i;
        frsRequestData.sj(this.dPp.aut() ? "1" : "2");
        if (this.dPI) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.e.f.nM(this.dPH)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.dPI = false;
        frsRequestData.setKw(this.dBb);
        if (com.baidu.tbadk.core.i.wA().wG()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ao = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst());
        int aq = com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst());
        float ar = com.baidu.adp.lib.util.l.ar(TbadkCoreApplication.getInst());
        int i2 = com.baidu.tbadk.core.util.an.CJ().CL() ? 2 : 1;
        frsRequestData.setScrW(ao);
        frsRequestData.setScrH(aq);
        frsRequestData.setScrDip(ar);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.dOI);
        frsRequestData.setYuelaouLocate(this.dPF);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(t.OG(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.i.dBj != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.i.dBj);
        }
        if (com.baidu.tieba.frs.i.dBk != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.i.dBk);
        }
        if (com.baidu.tieba.frs.i.dBl != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.i.dBl);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.e.f.a(this.dPG, frsRequestData);
        b(i, frsRequestData);
        a(this.dBb, frsRequestData);
        if (!nG(this.dPG)) {
            String d = com.baidu.tieba.tbadkCore.c.btt().d(this.dBb, frsRequestData.XF(), frsRequestData.getIsGood(), this.dPt.getCategoryId());
            this.dPJ = d;
            new a(this, true, d).execute(new Object[0]);
        }
        axR();
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
        if (iVar == null || iVar.aYE() == null || (am.isEmpty(iVar.aYE().getName()) && 340001 != iVar.gWz)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bXD = iVar.btW();
        }
        this.dAN.e(iVar);
        d(this.dAN);
        this.dPs = new ArrayList<>();
        if (frsRequestData != null) {
            this.dPt = frsRequestData;
            this.mPn = this.dPt.getPn();
            this.dBb = this.dPt.getKw();
            this.dPp.setForumName(this.dBb);
            this.dPp.setFrom(this.mFrom);
            this.dPp.setPn(this.mPn);
            this.dPp.setFlag(this.mFlag);
        }
        if (this.dAN.getThreadList() != null) {
            this.dPs.addAll(this.dAN.getThreadList());
        }
        if (this.bXD != 1 && this.isNetFirstLoad) {
            this.dPu.a(7, false, this.dOH);
        } else {
            this.dPu.a(this.mType, false, this.dOH);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.dPt)) {
            ayv();
        }
        this.isNetFirstLoad = false;
        if (iVar.aYE() == null || TextUtils.isEmpty(iVar.aYE().getName()) || frsRequestData == null || q.bmR().bmL() == null) {
            return true;
        }
        q.bmR().bmL().f(iVar.aYE().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.gUV = com.baidu.adp.lib.util.j.oI() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gUW = mvcSocketResponsedMessage.getDownSize();
        this.dOH = aVar;
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
        this.dPp.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dPE) {
            this.dPE = true;
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
        aVar.gUV = com.baidu.adp.lib.util.j.oI() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gUW = mvcHttpResponsedMessage.getDownSize();
        this.dOH = aVar;
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
        this.dPp.a(errorData);
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
        if (!this.dPE) {
            this.dPE = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void aum() {
        if (this.dAN != null && this.dAN.aYE() != null && this.dAN.aYE().getBannerListData() != null) {
            String lastIds = this.dAN.aYE().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dOI = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (r.NO().NP()) {
            this.byx = System.currentTimeMillis() - this.dPp.beginTime;
            m mVar = new m(i, z, responsedMessage, this.dPp.byo, this.dPp.createTime, this.dPp.byw, false, this.byx);
            this.dPp.createTime = 0L;
            this.dPp.byo = 0L;
            if (mVar != null) {
                mVar.NJ();
            }
        }
    }

    public FrsRequestData ayf() {
        return this.dPt;
    }

    public String ayg() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.dBb;
    }

    public int getPn() {
        return this.mPn;
    }

    public l axQ() {
        return this.dAN;
    }

    public d.a ayh() {
        return this.dOH;
    }

    private void axR() {
        this.dmT = System.currentTimeMillis();
        this.dOF.MO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.dAN.e(iVar);
        d(this.dAN);
        this.dPs = new ArrayList<>();
        if (this.dAN.getThreadList() != null) {
            this.dPs.addAll(this.dAN.getThreadList());
        }
        this.dPu.b(iVar);
    }

    private void d(l lVar) {
        if (com.baidu.tieba.frs.f.f.h(lVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.f.f.i(lVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.i, Void> {
        private String dPP;
        private FrsModelController dPQ;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.dPP = null;
            this.dPP = str;
            this.dPQ = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.btt().sh(this.dPP)) {
                if (!com.baidu.tieba.tbadkCore.c.btt().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.dPP)) {
                    com.baidu.tieba.tbadkCore.c.btt().getResponseData().aYE().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.i responseData = com.baidu.tieba.tbadkCore.c.btt().getResponseData();
                if (responseData.btY() != null && !StringUtils.isNull(responseData.btY().xm(), true) && !responseData.btY().xm().equals("0") && responseData.btY().xn() == 3 && (h = com.baidu.adp.lib.g.b.h(responseData.btY().xm(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(h))) != null) {
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
            if (this.dPQ != null && iVarArr != null) {
                this.dPQ.d(iVarArr.length > 0 ? iVarArr[0] : null);
                this.dPQ.A(this.dPQ.dPG, true);
            }
        }
    }

    public long apT() {
        return this.dmW;
    }

    public long apU() {
        return this.dmU;
    }

    public long apV() {
        return this.dmV;
    }

    public long apW() {
        return this.dmT;
    }

    public boolean DP() {
        return this.dOF.DP();
    }

    public int ayi() {
        return this.dPx;
    }

    private void ayj() {
        if (this.dPD == null) {
            this.dPD = new ArrayList<>();
        }
        if (this.dPD.size() == 0) {
            this.dPD.add(new x());
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, aq aqVar) {
        this.bXD = c(i, null);
        if (aqVar == null && (aqVar = bJ(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.oZ() && this.dPC != null) {
                at atVar = new at();
                atVar.hasMore = false;
                atVar.pn = 1;
                atVar.forumName = this.dBb;
                atVar.dEk = false;
                if (this.dAN != null && this.dAN.aYE() != null) {
                    atVar.forumId = this.dAN.aYE().getId();
                }
                ayj();
                this.dAN.at(this.dPD);
                this.dPC.a(i, i2, atVar, this.dPD);
            }
            aqVar = new aq();
            aqVar.pn = -1;
        }
        if (this.dAN != null && this.dAN.aYE() != null) {
            aqVar.forumId = this.dAN.aYE().getId();
        }
        aqVar.forumName = this.dBb;
        if (aa.avi().mZ(1) != null && this.bXD == 1) {
            this.dPt.setCategoryId(i2);
        }
        this.dPw = i2;
        this.dPy = aqVar;
        b(i, i2, aqVar);
        nD(5);
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(an anVar) {
        this.dPC = anVar;
        this.dPB.a(this.dPL);
    }

    private void nD(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.dPy != null) {
                    this.dPy.pn++;
                    break;
                }
                break;
            case 2:
                if (this.dPy != null) {
                    aq aqVar = this.dPy;
                    aqVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.dPy != null) {
                    this.dPy.pn = -1;
                    break;
                }
                break;
        }
        if (this.bXD == 1) {
            if (this.dPx == this.dPw) {
                ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
                if (this.dPs != null) {
                    arrayList.addAll(this.dPs);
                }
                this.dAN.at(arrayList);
                if (this.dPC != null) {
                    this.dPC.a(this.bXD, this.dPw, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.dPx = this.dPw;
            return;
        }
        ak na = this.dPB.na(this.bXD);
        if (na != null) {
            this.dPz = true;
            na.a(this.bXD, this.dPw, this.dPy);
            return;
        }
        if (this.dAN != null && this.dAN.getThreadList() != null) {
            this.dAN.getThreadList().clear();
        }
        this.dPC.a(this.bXD, this.dPw, null, null);
    }

    public boolean hasMore() {
        if ((this.dPy instanceof at) && ((at) this.dPy).errCode == 0) {
            return ((at) this.dPy).hasMore;
        }
        return true;
    }

    private int bI(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, aq aqVar) {
        this.dPA.put(bI(i, i2), aqVar);
    }

    public aq bJ(int i, int i2) {
        return this.dPA.get(bI(i, i2));
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        this.dPB.init();
    }

    @Override // com.baidu.tieba.frs.ak
    public void XW() {
        this.dPB.destory();
        this.dPB.clear();
    }

    public int ayk() {
        return this.bXD;
    }

    public boolean ayl() {
        return 1 == this.bXD;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.dPs != null) {
            if (this.bXD == 1) {
                this.dAN.a(aiVar);
            }
            int aym = aym();
            if (this.dPs != null && this.dPs.size() > 0) {
                int size = this.dPs.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.i iVar = this.dPs.get(i);
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
                    this.dPs.add(aym, arVar);
                    return;
                }
                return;
            }
            this.dPs.add(aym, aiVar);
        }
    }

    public int aym() {
        int i = 0;
        if (this.dPs == null || this.dPs.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.i> it = this.dPs.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.i next = it.next();
                if (!(next instanceof bd)) {
                    i = i2;
                } else if (((bd) next).yN() != 0) {
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

    public boolean ayn() {
        return this.dPz;
    }

    public void ayo() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.dPx == 0) {
            mVar.mY(this.dPG);
        }
        if (this.dAN.getThreadList() != null) {
            this.dAN.getThreadList().clear();
            this.dAN.getThreadList().add(mVar);
        }
        if (this.dPs != null) {
            this.dPs.clear();
            this.dPs.add(mVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> ayp() {
        return this.dPs;
    }

    public void nH(int i) {
        this.dPG = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.f.bwG();
        } else {
            com.baidu.tieba.tbadkCore.util.f.bwH();
        }
    }

    public void nI(int i) {
        this.dPH = i;
    }

    public void gc(boolean z) {
        this.dPI = z;
    }

    public int ayq() {
        return this.dPG;
    }

    public int XF() {
        return com.baidu.tieba.frs.e.f.nM(this.dPG);
    }

    public boolean ayr() {
        return this.dPv;
    }

    public boolean ays() {
        return this.dPG == 5;
    }

    public boolean ayt() {
        return this.dPt != null && this.dPt.getLoadType() == 1;
    }

    public boolean ayu() {
        return this.dPG == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.dPp.atP() != null) {
            return this.dPp.atP().a(this.dPG, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bd.aNi.get() && q.bmR().bmL() != null) {
            int W = q.bmR().bmL().W(str, false);
            int X = q.bmR().bmL().X(str, false);
            if (frsRequestData.getLoadType() == 1) {
                W++;
            } else if (frsRequestData.getLoadType() == 2) {
                X++;
            }
            frsRequestData.setRefreshCount(W);
            frsRequestData.setLoadCount(X);
        }
    }

    public void ayv() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.dAN != null && this.dAN.aYE() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.dAN.aYE().getId(), 0L));
        }
        this.dPp.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void lN(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.btt().bY(FrsModelController.this.dPJ, str);
                return null;
            }
        }, null);
    }

    public void lO(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.btt().bZ(FrsModelController.this.dPJ, str);
                return null;
            }
        }, null);
    }

    public void lP(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.btt().ca(FrsModelController.this.dPJ, str);
                return null;
            }
        }, null);
    }
}
