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
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.x;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.p;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.l>, af {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long cAZ;
    private int dor;
    private FrsNetModel<FrsFragment> fNF;
    private e.b fNH;
    private String fNI;
    private final FrsFragment fOE;
    private ArrayList<m> fOJ;
    private FrsRequestData fOK;
    private final p fOL;
    private boolean fOM;
    private int fON;
    private long fOO;
    private int fOP;
    private int fOQ;
    private am fOR;
    private boolean fOS;
    private SparseArray<am> fOT;
    private y fOU;
    private ai fOV;
    private ArrayList<m> fOW;
    private boolean fOX;
    private String fOY;
    private int fOZ;
    private int fPa;
    private boolean fPb;
    private String fPc;
    private final SparseArray<Boolean> fPd;
    private ai fPe;
    private long far;
    private long fas;
    private long fat;
    private long fau;
    private FrsViewData fvE;
    private String fvT;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean sD(int i) {
        return this.fPd.get(i, false).booleanValue();
    }

    public void F(int i, boolean z) {
        this.fPd.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, p pVar) {
        super(frsFragment.getPageContext());
        this.fvT = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.fON = 0;
        this.mSource = null;
        this.fNI = null;
        this.fOO = 0L;
        this.dor = 1;
        this.fOP = 0;
        this.fOQ = 0;
        this.fOS = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.fOT = new SparseArray<>();
        this.cAZ = 0L;
        this.fOX = false;
        this.fOZ = -1;
        this.fPa = -1;
        this.fPc = null;
        this.fPd = new SparseArray<>();
        this.fPe = new ai() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ai
            public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
                FrsModelController.this.fOS = false;
                if (i == FrsModelController.this.dor && FrsModelController.this.fOV != null) {
                    FrsModelController.this.fOR = apVar;
                    FrsModelController.this.b(i, i2, apVar);
                    ArrayList<m> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.fvE.setThreadList(arrayList2);
                    FrsModelController.this.fOV.a(i, i2, apVar, arrayList);
                }
            }
        };
        this.far = 0L;
        this.fas = 0L;
        this.fat = 0L;
        this.fau = 0L;
        if (pVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.fOE = frsFragment;
        this.fOL = pVar;
        M(this.fOE);
    }

    private void M(FrsFragment frsFragment) {
        this.fOU = new y();
        this.fOU.cyA = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.fOU));
        this.fOU.a(this.fPe);
    }

    public void aGu() {
        this.fNF.cancelLoadData();
    }

    public void K(Bundle bundle) {
        if (bundle != null) {
            this.fvT = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fOY = bundle.getString("yuelaou_locate");
            this.fOM = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.fON = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.fOO = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.fOE.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.fvT)) {
            this.fvT = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.fOY)) {
            this.fOY = "";
        }
        this.mSource = this.mFrom;
        bsa();
        this.fvE = new FrsViewData();
        this.fOK.el("forum_name", com.baidu.adp.lib.util.k.bi(this.fvT));
        this.fOK.el("client_type", "2");
        if (this.fNF == null) {
            this.fNF = new FrsNetModel<>(this.fOE.getPageContext(), this.fOK);
        }
        this.fNF.a(this);
        this.fNF.setUniqueId(this.fOE.getPageContext().getUniqueId());
        if (this.fvT != null && this.fvT.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.fvT);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void bsa() {
        AccountData currentAccountObj;
        this.fOK = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            sE(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            sE(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            sE(com.baidu.tieba.frs.f.g.yf("1~" + str + this.fvT));
        }
        this.fOK.setSortType(getSortType());
        if (this.fOZ == 5) {
            this.fOK.setIsGood(1);
        } else {
            this.fOK.setIsGood(0);
        }
    }

    public boolean bbG() {
        if (this.dor != 1) {
            sA(1);
            return true;
        } else if (this.fNF.pQ()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fOK), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void G(int i, boolean z) {
        this.fOE.fwg = System.currentTimeMillis();
        if (this.fvE != null && this.fvE.getLikeFeedForumDataList() != null) {
            this.fvE.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fOK), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.dor = c(this.dor, frsRequestData);
        if (this.dor == 1) {
            if (!this.fNF.pQ()) {
                frsRequestData.setCallFrom(this.fON);
                a(frsRequestData, i, z ? false : true);
                this.fON = 0;
                return;
            }
            return;
        }
        if (this.fOR == null) {
            this.fOR = new am();
            this.fOR.pn = 1;
            this.fOR.forumName = this.fvT;
            if (this.fvE != null && this.fvE.getForum() != null) {
                this.fOR.forumId = this.fvE.getForum().getId();
            }
        }
        sA(i);
    }

    public void sB(int i) {
        if (this.dor != 1) {
            sA(4);
        } else if (!this.fNF.pQ()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fOK), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.fOE.jR(z);
        this.fOL.rx(i);
        this.fNF.a(frsRequestData);
        this.mType = i;
        frsRequestData.Fa(this.fOE.bnl() ? "1" : "2");
        if (this.fPb) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.sV(this.fPa)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.fPb = false;
        frsRequestData.setKw(this.fvT);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        float ai = com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
        int i2 = ar.ajw().ajy() ? 2 : 1;
        frsRequestData.setScrW(af);
        frsRequestData.setScrH(ah);
        frsRequestData.setScrDip(ai);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.fNI);
        frsRequestData.setYuelaouLocate(this.fOY);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.e(x.awM(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.Bc(bsb());
        if (FrsFragment.fwh != 0) {
            frsRequestData.setCtime((int) FrsFragment.fwh);
        }
        if (FrsFragment.fwi != 0) {
            frsRequestData.setDataSize((int) FrsFragment.fwi);
        }
        if (FrsFragment.fwj != 0) {
            frsRequestData.setNetError(FrsFragment.fwj);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.eA(this.fOO);
        if (this.fOO != 0) {
            this.fOO = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.fOZ, frsRequestData);
        b(i, frsRequestData);
        a(this.fvT, frsRequestData);
        if (!sD(this.fOZ) && !this.fOE.fvU) {
            String c = com.baidu.tieba.tbadkCore.d.cpu().c("1~" + this.fvT, frsRequestData.getSortType(), frsRequestData.getIsGood(), this.fOK.getCategoryId());
            this.fPc = c;
            new a(this, true, c).execute(new Object[0]);
        }
        brJ();
    }

    private int bsb() {
        return (this.fOE == null || !(this.fOE.mHeadLineDefaultNavTabId == -1 || this.fOE.mHeadLineDefaultNavTabId == this.dor)) ? 0 : 1;
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

    protected boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar == null || lVar.getForum() == null || (aq.isEmpty(lVar.getForum().getName()) && 340001 != lVar.mErrorNo)) {
            return false;
        }
        sE(com.baidu.tieba.frs.f.g.sW(lVar.getSortType()));
        F(com.baidu.tieba.frs.f.g.sW(lVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.dor = lVar.getFrsDefaultTabId();
        }
        this.fvE.receiveData(lVar);
        d(this.fvE);
        this.fOJ = new ArrayList<>();
        if (frsRequestData != null) {
            this.fOK = frsRequestData;
            this.mPn = this.fOK.getPn();
            this.fvT = this.fOK.getKw();
            this.fOE.setForumName(this.fvT);
            this.fOE.setFrom(this.mFrom);
            this.fOE.setPn(this.mPn);
            this.fOE.setFlag(this.mFlag);
        }
        if (this.fvE.getThreadList() != null) {
            this.fOJ.addAll(this.fvE.getThreadList());
        }
        if (this.dor != 1 && this.isNetFirstLoad) {
            this.fOL.a(7, false, this.fNH);
        } else {
            this.fOL.a(this.mType, false, this.fNH);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.fOK)) {
            bsq();
        }
        this.isNetFirstLoad = false;
        if (lVar.getForum() != null && !TextUtils.isEmpty(lVar.getForum().getName()) && frsRequestData != null && r.ciJ().ciD() != null) {
            r.ciJ().ciD().g(lVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        com.baidu.tieba.frs.a.blQ().jM(this.dor == 301);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        e.b bVar = new e.b();
        bVar.fdH = com.baidu.adp.lib.util.j.kc() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcSocketResponsedMessage.getError();
        bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        bVar.jgm = mvcSocketResponsedMessage.getDownSize();
        this.fNH = bVar;
        if (mvcSocketResponsedMessage == null || (mvcSocketResponsedMessage.hasError() && 340001 != mvcSocketResponsedMessage.getError())) {
            lVar = null;
        } else {
            lVar = mvcSocketResponsedMessage.getData();
            r3 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && lVar != null && a(r3, lVar)) {
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
        this.fOE.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.fOX) {
            this.fOX = true;
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
            com.baidu.tbadk.core.e.a.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.l> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        e.b bVar = new e.b();
        bVar.fdH = com.baidu.adp.lib.util.j.kc() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcHttpResponsedMessage.getError();
        bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        bVar.jgm = mvcHttpResponsedMessage.getDownSize();
        this.fNH = bVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            lVar = null;
        } else {
            lVar = mvcHttpResponsedMessage.getData();
            r3 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && lVar != null && a(r3, lVar)) {
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
        this.fOE.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        super.registerListener(i, aVar);
    }

    private void b(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.l> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
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
            com.baidu.tbadk.core.e.a.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
        if (!this.fOX) {
            this.fOX = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bnd() {
        if (this.fvE != null && this.fvE.getForum() != null && this.fvE.getForum().getBannerListData() != null) {
            String lastIds = this.fvE.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fNI = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.avH().avI()) {
            this.cAZ = System.currentTimeMillis() - this.fOE.beginTime;
            com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(i, z, responsedMessage, this.fOE.cAQ, this.fOE.createTime, this.fOE.cAY, false, this.cAZ);
            this.fOE.createTime = 0L;
            this.fOE.cAQ = 0L;
            if (iVar != null) {
                iVar.avE();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.avH().avI()) {
            this.cAZ = System.currentTimeMillis() - this.fOE.fwg;
            com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(1000, z, responsedMessage, this.fOE.cAQ, this.fOE.createTime, this.fOE.cAY, false, this.cAZ);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.cBh = this.cAZ;
                    iVar.fH(true);
                } else if (this.mType == 3) {
                    iVar.cBi = this.cAZ;
                    iVar.fH(false);
                }
            }
        }
    }

    public FrsRequestData bsc() {
        return this.fOK;
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

    public FrsViewData brI() {
        return this.fvE;
    }

    public e.b bsd() {
        return this.fNH;
    }

    private void brJ() {
        this.far = System.currentTimeMillis();
        this.fNF.auR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.tieba.tbadkCore.l lVar) {
        this.isCacheFirstLoad = false;
        this.fvE.receiveData(lVar);
        d(this.fvE);
        this.fOJ = new ArrayList<>();
        if (this.fvE.getThreadList() != null) {
            this.fOJ.addAll(this.fvE.getThreadList());
        }
        this.fOL.c(lVar);
    }

    private void d(FrsViewData frsViewData) {
        if (com.baidu.tieba.frs.vc.f.k(frsViewData)) {
            this.mPageType = "book_page";
        } else if (frsViewData.getIsBrandForum()) {
            this.mPageType = "brand_page";
        } else if (com.baidu.tieba.frs.vc.f.l(frsViewData)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.l, Void> {
        private String fPi;
        private FrsModelController fPj;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.fPi = null;
            this.fPi = str;
            this.fPj = frsModelController;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            int f;
            CustomResponsedMessage runTask;
            if (this.needCache && com.baidu.tieba.tbadkCore.d.cpu().EY(this.fPi)) {
                if (!com.baidu.tieba.tbadkCore.d.cpu().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.fPi)) {
                    com.baidu.tieba.tbadkCore.d.cpu().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.l responseData = com.baidu.tieba.tbadkCore.d.cpu().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().acS(), true) && !responseData.getBookInfo().acS().equals("0") && responseData.getBookInfo().acT() == 3 && (f = com.baidu.adp.lib.g.b.f(responseData.getBookInfo().acS(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(f))) != null) {
                    responseData.setMangaReadRecordChapterId(Integer.valueOf(((Integer) runTask.getData()).intValue()));
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
        public void onProgressUpdate(com.baidu.tieba.tbadkCore.l... lVarArr) {
            super.onProgressUpdate(lVarArr);
            if (this.fPj != null && lVarArr != null) {
                this.fPj.g(lVarArr.length > 0 ? lVarArr[0] : null);
                this.fPj.F(this.fPj.fOZ, true);
            }
        }
    }

    public long bgS() {
        return this.fau;
    }

    public long bgT() {
        return this.fas;
    }

    public long bgU() {
        return this.fat;
    }

    public long bgV() {
        return this.far;
    }

    public boolean pQ() {
        return this.fNF.pQ();
    }

    public int bse() {
        return this.fOQ;
    }

    private void bsf() {
        if (this.fOW == null) {
            this.fOW = new ArrayList<>();
        }
        if (this.fOW.size() == 0) {
            this.fOW.add(new u());
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, int i2, am amVar) {
        this.dor = c(i, null);
        if (amVar == null && (amVar = bE(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.kt() && this.fOV != null) {
                ap apVar = new ap();
                apVar.hasMore = false;
                apVar.pn = 1;
                apVar.forumName = this.fvT;
                apVar.fAn = false;
                if (this.fvE != null && this.fvE.getForum() != null) {
                    apVar.forumId = this.fvE.getForum().getId();
                }
                bsf();
                this.fvE.setThreadList(this.fOW);
                this.fOV.a(i, i2, apVar, this.fOW);
            }
            amVar = new am();
            amVar.pn = -1;
        }
        if (this.fvE != null && this.fvE.getForum() != null) {
            amVar.forumId = this.fvE.getForum().getId();
        }
        amVar.forumName = this.fvT;
        if (w.boy().rP(1) != null && this.dor == 1) {
            this.fOK.setCategoryId(i2);
        }
        this.fOP = i2;
        this.fOR = amVar;
        b(i, i2, amVar);
        sA(5);
    }

    @Override // com.baidu.tieba.frs.af
    public void a(ai aiVar) {
        this.fOV = aiVar;
        this.fOU.a(this.fPe);
    }

    private void sA(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.fOR != null) {
                    this.fOR.pn++;
                    break;
                }
                break;
            case 2:
                if (this.fOR != null) {
                    am amVar = this.fOR;
                    amVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.fOR != null) {
                    this.fOR.pn = -1;
                    break;
                }
                break;
        }
        if (this.dor == 1) {
            if (this.fOQ == this.fOP) {
                ArrayList<m> arrayList = new ArrayList<>();
                if (this.fOJ != null) {
                    arrayList.addAll(this.fOJ);
                }
                this.fvE.setThreadList(arrayList);
                if (this.fOV != null) {
                    this.fOV.a(this.dor, this.fOP, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.fOQ = this.fOP;
            return;
        }
        af rQ = this.fOU.rQ(this.dor);
        if (rQ != null) {
            this.fOS = true;
            rQ.a(this.dor, this.fOP, this.fOR);
            return;
        }
        if (this.fvE != null && this.fvE.getThreadList() != null) {
            this.fvE.getThreadList().clear();
        }
        this.fOV.a(this.dor, this.fOP, null, null);
    }

    public boolean hasMore() {
        if ((this.fOR instanceof ap) && ((ap) this.fOR).errCode == 0) {
            return ((ap) this.fOR).hasMore;
        }
        return true;
    }

    private int bD(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, am amVar) {
        this.fOT.put(bD(i, i2), amVar);
    }

    public am bE(int i, int i2) {
        return this.fOT.get(bD(i, i2));
    }

    @Override // com.baidu.tieba.frs.af
    public void init() {
        this.fOU.init();
    }

    @Override // com.baidu.tieba.frs.af
    public void aMd() {
        this.fOU.destory();
        this.fOU.clear();
    }

    public int bsg() {
        return this.dor;
    }

    public boolean bsh() {
        return 1 == this.dor;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(ak akVar) {
        if (akVar != null && !StringUtils.isNull(akVar.getId()) && !v.aa(this.fOJ)) {
            if (this.dor == 1) {
                this.fvE.addMyNewThread(akVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<m> it = this.fOJ.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if ((next instanceof bg) && akVar.getId().equals(((bg) next).threadData.getId())) {
                    return;
                }
            }
            this.fOJ.add(topThreadSize, akVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.fOJ == null || this.fOJ.size() <= 0) {
            return 0;
        }
        Iterator<m> it = this.fOJ.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                m next = it.next();
                if (!(next instanceof bg)) {
                    i = i2;
                } else if (((bg) next).threadData.aex() != 0) {
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

    public boolean bsi() {
        return this.fOS;
    }

    public void bsj() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.fOQ == 0) {
            mVar.rI(this.fOZ);
        }
        if (this.fvE.getThreadList() != null) {
            this.fvE.getThreadList().clear();
            this.fvE.getThreadList().add(mVar);
        }
        if (this.fOJ != null) {
            this.fOJ.clear();
            this.fOJ.add(mVar);
        }
    }

    public ArrayList<m> bsk() {
        return this.fOJ;
    }

    public void sE(int i) {
        AccountData currentAccountObj;
        this.fOZ = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
        }
        com.baidu.tieba.frs.f.g.az("1~" + str + this.fvT, this.fOZ);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.crx();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cry();
        }
    }

    public void sF(int i) {
        this.fPa = i;
    }

    public void kM(boolean z) {
        this.fPb = z;
    }

    public int bsl() {
        return this.fOZ;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.sV(this.fOZ);
    }

    public boolean bsm() {
        return this.fOM;
    }

    public boolean bsn() {
        return this.fOZ == 5;
    }

    public boolean bso() {
        return this.fOK != null && this.fOK.getLoadType() == 1;
    }

    public boolean bsp() {
        return this.fOZ == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.fOE.bmA() != null) {
            return this.fOE.bmA().a(this.fOZ, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bh.bKm.get() && r.ciJ().ciD() != null) {
            int ax = r.ciJ().ciD().ax(str, false);
            int ay = r.ciJ().ciD().ay(str, false);
            if (frsRequestData.getLoadType() == 1) {
                ax++;
            } else if (frsRequestData.getLoadType() == 2) {
                ay++;
            }
            frsRequestData.setRefreshCount(ax);
            frsRequestData.setLoadCount(ay);
        }
    }

    public void bsq() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.fvE != null && this.fvE.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.e(this.fvE.getForum().getId(), 0L));
        }
        this.fOE.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void xW(final String str) {
        z.a(new com.baidu.tbadk.util.y<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cpu().ei(FrsModelController.this.fPc, str);
                return null;
            }
        }, null);
    }

    public void xX(final String str) {
        z.a(new com.baidu.tbadk.util.y<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cpu().ej(FrsModelController.this.fPc, str);
                return null;
            }
        }, null);
    }

    public void xY(final String str) {
        z.a(new com.baidu.tbadk.util.y<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cpu().ek(FrsModelController.this.fPc, str);
                return null;
            }
        }, null);
    }
}
