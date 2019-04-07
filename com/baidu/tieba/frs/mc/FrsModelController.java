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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.aa;
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
import com.baidu.tieba.tbadkCore.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.j>, af {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long cqy;
    private int dag;
    private long eDA;
    private long eDB;
    private long eDC;
    private long eDD;
    private FrsViewData eYh;
    private String eYw;
    private FrsNetModel<FrsFragment> fpG;
    private e.b fpI;
    private String fpJ;
    private final FrsFragment fqE;
    private ArrayList<m> fqJ;
    private FrsRequestData fqK;
    private final n fqL;
    private boolean fqM;
    private int fqN;
    private long fqO;
    private int fqP;
    private int fqQ;
    private am fqR;
    private boolean fqS;
    private SparseArray<am> fqT;
    private y fqU;
    private ai fqV;
    private ArrayList<m> fqW;
    private boolean fqX;
    private String fqY;
    private int fqZ;
    private int fra;
    private boolean frb;
    private String frc;
    private final SparseArray<Boolean> frd;
    private ai fre;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean qX(int i) {
        return this.frd.get(i, false).booleanValue();
    }

    public void x(int i, boolean z) {
        this.frd.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.eYw = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.fqN = 0;
        this.mSource = null;
        this.fpJ = null;
        this.fqO = 0L;
        this.dag = 1;
        this.fqP = 0;
        this.fqQ = 0;
        this.fqS = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.fqT = new SparseArray<>();
        this.cqy = 0L;
        this.fqX = false;
        this.fqZ = -1;
        this.fra = -1;
        this.frc = null;
        this.frd = new SparseArray<>();
        this.fre = new ai() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ai
            public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
                FrsModelController.this.fqS = false;
                if (i == FrsModelController.this.dag && FrsModelController.this.fqV != null) {
                    FrsModelController.this.fqR = apVar;
                    FrsModelController.this.b(i, i2, apVar);
                    ArrayList<m> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.eYh.setThreadList(arrayList2);
                    FrsModelController.this.fqV.a(i, i2, apVar, arrayList);
                }
            }
        };
        this.eDA = 0L;
        this.eDB = 0L;
        this.eDC = 0L;
        this.eDD = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.fqE = frsFragment;
        this.fqL = nVar;
        M(this.fqE);
    }

    private void M(FrsFragment frsFragment) {
        this.fqU = new y();
        this.fqU.cnZ = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.fqU));
        this.fqU.a(this.fre);
    }

    public void onActivityDestroy() {
        this.fpG.cancelLoadData();
    }

    public void J(Bundle bundle) {
        if (bundle != null) {
            this.eYw = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fqY = bundle.getString("yuelaou_locate");
            this.fqM = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.fqN = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.fqO = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.fqE.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.eYw)) {
            this.eYw = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.fqY)) {
            this.fqY = "";
        }
        this.mSource = this.mFrom;
        bhD();
        this.eYh = new FrsViewData();
        this.fqK.dV("forum_name", com.baidu.adp.lib.util.k.bx(this.eYw));
        this.fqK.dV("client_type", "2");
        if (this.fpG == null) {
            this.fpG = new FrsNetModel<>(this.fqE.getPageContext(), this.fqK);
        }
        this.fpG.a(this);
        this.fpG.setUniqueId(this.fqE.getPageContext().getUniqueId());
        if (this.eYw != null && this.eYw.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.eYw);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void bhD() {
        AccountData currentAccountObj;
        this.fqK = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            qY(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            qY(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + "~";
            }
            qY(com.baidu.tieba.frs.f.g.vJ("1~" + str + this.eYw));
        }
        this.fqK.setSortType(getSortType());
        if (this.fqZ == 5) {
            this.fqK.setIsGood(1);
        } else {
            this.fqK.setIsGood(0);
        }
    }

    public boolean aRP() {
        if (this.dag != 1) {
            qU(1);
            return true;
        } else if (this.fpG.qz()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fqK), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void y(int i, boolean z) {
        this.fqE.eYJ = System.currentTimeMillis();
        if (this.eYh != null && this.eYh.getLikeFeedForumDataList() != null) {
            this.eYh.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fqK), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.dag = c(this.dag, frsRequestData);
        if (this.dag == 1) {
            if (!this.fpG.qz()) {
                frsRequestData.setCallFrom(this.fqN);
                a(frsRequestData, i, z ? false : true);
                this.fqN = 0;
                return;
            }
            return;
        }
        if (this.fqR == null) {
            this.fqR = new am();
            this.fqR.pn = 1;
            this.fqR.forumName = this.eYw;
            if (this.eYh != null && this.eYh.getForum() != null) {
                this.fqR.forumId = this.eYh.getForum().getId();
            }
        }
        qU(i);
    }

    public void qV(int i) {
        if (this.dag != 1) {
            qU(4);
        } else if (!this.fpG.qz()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fqK), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.fqE.iU(z);
        this.fqL.pT(i);
        this.fpG.a(frsRequestData);
        this.mType = i;
        frsRequestData.Co(this.fqE.bcR() ? "1" : "2");
        if (this.frb) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.rp(this.fra)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.frb = false;
        frsRequestData.setKw(this.eYw);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst());
        float aR = com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
        int i2 = ar.adm().ado() ? 2 : 1;
        frsRequestData.setScrW(aO);
        frsRequestData.setScrH(aQ);
        frsRequestData.setScrDip(aR);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.fpJ);
        frsRequestData.setYuelaouLocate(this.fqY);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.d(com.baidu.tbadk.util.y.aqk(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.eYK != 0) {
            frsRequestData.setCtime((int) FrsFragment.eYK);
        }
        if (FrsFragment.eYL != 0) {
            frsRequestData.setDataSize((int) FrsFragment.eYL);
        }
        if (FrsFragment.eYM != 0) {
            frsRequestData.setNetError(FrsFragment.eYM);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.dP(this.fqO);
        if (this.fqO != 0) {
            this.fqO = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.fqZ, frsRequestData);
        b(i, frsRequestData);
        a(this.eYw, frsRequestData);
        if (!qX(this.fqZ) && !this.fqE.eYx) {
            String d = com.baidu.tieba.tbadkCore.d.cdq().d("1~" + this.eYw, frsRequestData.getSortType(), frsRequestData.getIsGood(), this.fqK.getCategoryId());
            this.frc = d;
            new a(this, true, d).execute(new Object[0]);
        }
        bhn();
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

    protected boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.j jVar) {
        if (jVar == null || jVar.getForum() == null || (com.baidu.tbadk.core.util.ap.isEmpty(jVar.getForum().getName()) && 340001 != jVar.mErrorNo)) {
            return false;
        }
        qY(com.baidu.tieba.frs.f.g.rq(jVar.getSortType()));
        x(com.baidu.tieba.frs.f.g.rq(jVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.dag = jVar.getFrsDefaultTabId();
        }
        this.eYh.receiveData(jVar);
        d(this.eYh);
        this.fqJ = new ArrayList<>();
        if (frsRequestData != null) {
            this.fqK = frsRequestData;
            this.mPn = this.fqK.getPn();
            this.eYw = this.fqK.getKw();
            this.fqE.setForumName(this.eYw);
            this.fqE.setFrom(this.mFrom);
            this.fqE.setPn(this.mPn);
            this.fqE.setFlag(this.mFlag);
        }
        if (this.eYh.getThreadList() != null) {
            this.fqJ.addAll(this.eYh.getThreadList());
        }
        if (this.dag != 1 && this.isNetFirstLoad) {
            this.fqL.a(7, false, this.fpI);
        } else {
            this.fqL.a(this.mType, false, this.fpI);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.fqK)) {
            bhS();
        }
        this.isNetFirstLoad = false;
        if (jVar.getForum() == null || TextUtils.isEmpty(jVar.getForum().getName()) || frsRequestData == null || r.bWF().bWz() == null) {
            return true;
        }
        r.bWF().bWz().g(jVar.getForum().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.j jVar;
        e.b bVar = new e.b();
        bVar.iDA = com.baidu.adp.lib.util.j.kY() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcSocketResponsedMessage.getError();
        bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        bVar.iDB = mvcSocketResponsedMessage.getDownSize();
        this.fpI = bVar;
        if (mvcSocketResponsedMessage == null || (mvcSocketResponsedMessage.hasError() && 340001 != mvcSocketResponsedMessage.getError())) {
            jVar = null;
        } else {
            jVar = mvcSocketResponsedMessage.getData();
            r3 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && jVar != null && a(r3, jVar)) {
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
        this.fqE.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.fqX) {
            this.fqX = true;
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
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.j> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.j jVar;
        e.b bVar = new e.b();
        bVar.iDA = com.baidu.adp.lib.util.j.kY() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcHttpResponsedMessage.getError();
        bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        bVar.iDB = mvcHttpResponsedMessage.getDownSize();
        this.fpI = bVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            jVar = null;
        } else {
            jVar = mvcHttpResponsedMessage.getData();
            r3 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && jVar != null && a(r3, jVar)) {
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
        this.fqE.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        super.registerListener(i, aVar);
    }

    private void b(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.j> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
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
        if (!this.fqX) {
            this.fqX = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bcJ() {
        if (this.eYh != null && this.eYh.getForum() != null && this.eYh.getForum().getBannerListData() != null) {
            String lastIds = this.eYh.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fpJ = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.o.m.apg().aph()) {
            this.cqy = System.currentTimeMillis() - this.fqE.beginTime;
            com.baidu.tbadk.o.i iVar = new com.baidu.tbadk.o.i(i, z, responsedMessage, this.fqE.cqp, this.fqE.createTime, this.fqE.cqx, false, this.cqy);
            this.fqE.createTime = 0L;
            this.fqE.cqp = 0L;
            if (iVar != null) {
                iVar.apd();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.o.m.apg().aph()) {
            this.cqy = System.currentTimeMillis() - this.fqE.eYJ;
            com.baidu.tbadk.o.i iVar = new com.baidu.tbadk.o.i(1000, z, responsedMessage, this.fqE.cqp, this.fqE.createTime, this.fqE.cqx, false, this.cqy);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.cqG = this.cqy;
                    iVar.fe(true);
                } else if (this.mType == 3) {
                    iVar.cqH = this.cqy;
                    iVar.fe(false);
                }
            }
        }
    }

    public FrsRequestData bhE() {
        return this.fqK;
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

    public FrsViewData bhm() {
        return this.eYh;
    }

    public e.b bhF() {
        return this.fpI;
    }

    private void bhn() {
        this.eDA = System.currentTimeMillis();
        this.fpG.aor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.tbadkCore.j jVar) {
        this.isCacheFirstLoad = false;
        this.eYh.receiveData(jVar);
        d(this.eYh);
        this.fqJ = new ArrayList<>();
        if (this.eYh.getThreadList() != null) {
            this.fqJ.addAll(this.eYh.getThreadList());
        }
        this.fqL.b(jVar);
    }

    private void d(FrsViewData frsViewData) {
        if (com.baidu.tieba.frs.vc.f.j(frsViewData)) {
            this.mPageType = "book_page";
        } else if (frsViewData.getIsBrandForum()) {
            this.mPageType = "brand_page";
        } else if (com.baidu.tieba.frs.vc.f.k(frsViewData)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.j, Void> {
        private String fri;
        private FrsModelController frj;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.fri = null;
            this.fri = str;
            this.frj = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.d.cdq().Cm(this.fri)) {
                if (!com.baidu.tieba.tbadkCore.d.cdq().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.fri)) {
                    com.baidu.tieba.tbadkCore.d.cdq().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.j responseData = com.baidu.tieba.tbadkCore.d.cdq().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().Xd(), true) && !responseData.getBookInfo().Xd().equals("0") && responseData.getBookInfo().Xe() == 3 && (l = com.baidu.adp.lib.g.b.l(responseData.getBookInfo().Xd(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(l))) != null) {
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
        public void onProgressUpdate(com.baidu.tieba.tbadkCore.j... jVarArr) {
            super.onProgressUpdate(jVarArr);
            if (this.frj != null && jVarArr != null) {
                this.frj.f(jVarArr.length > 0 ? jVarArr[0] : null);
                this.frj.x(this.frj.fqZ, true);
            }
        }
    }

    public long aWP() {
        return this.eDD;
    }

    public long aWQ() {
        return this.eDB;
    }

    public long aWR() {
        return this.eDC;
    }

    public long aWS() {
        return this.eDA;
    }

    public boolean qz() {
        return this.fpG.qz();
    }

    public int bhG() {
        return this.fqQ;
    }

    private void bhH() {
        if (this.fqW == null) {
            this.fqW = new ArrayList<>();
        }
        if (this.fqW.size() == 0) {
            this.fqW.add(new u());
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, int i2, am amVar) {
        this.dag = c(i, null);
        if (amVar == null && (amVar = bs(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.lo() && this.fqV != null) {
                ap apVar = new ap();
                apVar.hasMore = false;
                apVar.pn = 1;
                apVar.forumName = this.eYw;
                apVar.fcQ = false;
                if (this.eYh != null && this.eYh.getForum() != null) {
                    apVar.forumId = this.eYh.getForum().getId();
                }
                bhH();
                this.eYh.setThreadList(this.fqW);
                this.fqV.a(i, i2, apVar, this.fqW);
            }
            amVar = new am();
            amVar.pn = -1;
        }
        if (this.eYh != null && this.eYh.getForum() != null) {
            amVar.forumId = this.eYh.getForum().getId();
        }
        amVar.forumName = this.eYw;
        if (w.beh().ql(1) != null && this.dag == 1) {
            this.fqK.setCategoryId(i2);
        }
        this.fqP = i2;
        this.fqR = amVar;
        b(i, i2, amVar);
        qU(5);
    }

    @Override // com.baidu.tieba.frs.af
    public void a(ai aiVar) {
        this.fqV = aiVar;
        this.fqU.a(this.fre);
    }

    private void qU(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.fqR != null) {
                    this.fqR.pn++;
                    break;
                }
                break;
            case 2:
                if (this.fqR != null) {
                    am amVar = this.fqR;
                    amVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.fqR != null) {
                    this.fqR.pn = -1;
                    break;
                }
                break;
        }
        if (this.dag == 1) {
            if (this.fqQ == this.fqP) {
                ArrayList<m> arrayList = new ArrayList<>();
                if (this.fqJ != null) {
                    arrayList.addAll(this.fqJ);
                }
                this.eYh.setThreadList(arrayList);
                if (this.fqV != null) {
                    this.fqV.a(this.dag, this.fqP, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.fqQ = this.fqP;
            return;
        }
        af qm = this.fqU.qm(this.dag);
        if (qm != null) {
            this.fqS = true;
            qm.a(this.dag, this.fqP, this.fqR);
            return;
        }
        if (this.eYh != null && this.eYh.getThreadList() != null) {
            this.eYh.getThreadList().clear();
        }
        this.fqV.a(this.dag, this.fqP, null, null);
    }

    public boolean hasMore() {
        if ((this.fqR instanceof ap) && ((ap) this.fqR).errCode == 0) {
            return ((ap) this.fqR).hasMore;
        }
        return true;
    }

    private int br(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, am amVar) {
        this.fqT.put(br(i, i2), amVar);
    }

    public am bs(int i, int i2) {
        return this.fqT.get(br(i, i2));
    }

    @Override // com.baidu.tieba.frs.af
    public void init() {
        this.fqU.init();
    }

    @Override // com.baidu.tieba.frs.af
    public void aDC() {
        this.fqU.destory();
        this.fqU.clear();
    }

    public int bhI() {
        return this.dag;
    }

    public boolean bhJ() {
        return 1 == this.dag;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(ak akVar) {
        if (akVar != null && !StringUtils.isNull(akVar.getId()) && !v.T(this.fqJ)) {
            if (this.dag == 1) {
                this.eYh.addMyNewThread(akVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<m> it = this.fqJ.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if ((next instanceof bf) && akVar.getId().equals(((bf) next).threadData.getId())) {
                    return;
                }
            }
            this.fqJ.add(topThreadSize, akVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.fqJ == null || this.fqJ.size() <= 0) {
            return 0;
        }
        Iterator<m> it = this.fqJ.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                m next = it.next();
                if (!(next instanceof bf)) {
                    i = i2;
                } else if (((bf) next).threadData.YJ() != 0) {
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

    public boolean bhK() {
        return this.fqS;
    }

    public void bhL() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.fqQ == 0) {
            mVar.qe(this.fqZ);
        }
        if (this.eYh.getThreadList() != null) {
            this.eYh.getThreadList().clear();
            this.eYh.getThreadList().add(mVar);
        }
        if (this.fqJ != null) {
            this.fqJ.clear();
            this.fqJ.add(mVar);
        }
    }

    public ArrayList<m> bhM() {
        return this.fqJ;
    }

    public void qY(int i) {
        AccountData currentAccountObj;
        this.fqZ = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + "~";
        }
        com.baidu.tieba.frs.f.g.aA("1~" + str + this.eYw, this.fqZ);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cfn();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cfo();
        }
    }

    public void qZ(int i) {
        this.fra = i;
    }

    public void jM(boolean z) {
        this.frb = z;
    }

    public int bhN() {
        return this.fqZ;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.rp(this.fqZ);
    }

    public boolean bhO() {
        return this.fqM;
    }

    public boolean bhP() {
        return this.fqZ == 5;
    }

    public boolean bhQ() {
        return this.fqK != null && this.fqK.getLoadType() == 1;
    }

    public boolean bhR() {
        return this.fqZ == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.fqE.bcj() != null) {
            return this.fqE.bcj().a(this.fqZ, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bg.bBr.get() && r.bWF().bWz() != null) {
            int ar = r.bWF().bWz().ar(str, false);
            int as = r.bWF().bWz().as(str, false);
            if (frsRequestData.getLoadType() == 1) {
                ar++;
            } else if (frsRequestData.getLoadType() == 2) {
                as++;
            }
            frsRequestData.setRefreshCount(ar);
            frsRequestData.setLoadCount(as);
        }
    }

    public void bhS() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.eYh != null && this.eYh.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.d(this.eYh.getForum().getId(), 0L));
        }
        this.fqE.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void vw(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cdq().dS(FrsModelController.this.frc, str);
                return null;
            }
        }, null);
    }

    public void vx(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cdq().dT(FrsModelController.this.frc, str);
                return null;
            }
        }, null);
    }

    public void vy(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cdq().dU(FrsModelController.this.frc, str);
                return null;
            }
        }, null);
    }
}
