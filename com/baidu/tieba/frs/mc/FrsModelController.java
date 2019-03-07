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
    private long cqw;
    private int dah;
    private long eDT;
    private long eDU;
    private long eDV;
    private long eDW;
    private String eYL;
    private FrsViewData eYw;
    private FrsNetModel<FrsFragment> fpV;
    private e.b fpX;
    private String fpY;
    private final FrsFragment fqT;
    private ArrayList<m> fqY;
    private FrsRequestData fqZ;
    private final n fra;
    private boolean frb;
    private int frc;
    private long frd;
    private int fre;
    private int frf;
    private am frg;
    private boolean frh;
    private SparseArray<am> fri;
    private y frj;
    private ai frk;
    private ArrayList<m> frl;
    private boolean frm;
    private String frn;
    private int fro;
    private int frp;
    private boolean frq;
    private String frr;
    private final SparseArray<Boolean> frt;
    private ai fru;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean rb(int i) {
        return this.frt.get(i, false).booleanValue();
    }

    public void x(int i, boolean z) {
        this.frt.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.eYL = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.frc = 0;
        this.mSource = null;
        this.fpY = null;
        this.frd = 0L;
        this.dah = 1;
        this.fre = 0;
        this.frf = 0;
        this.frh = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.fri = new SparseArray<>();
        this.cqw = 0L;
        this.frm = false;
        this.fro = -1;
        this.frp = -1;
        this.frr = null;
        this.frt = new SparseArray<>();
        this.fru = new ai() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ai
            public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
                FrsModelController.this.frh = false;
                if (i == FrsModelController.this.dah && FrsModelController.this.frk != null) {
                    FrsModelController.this.frg = apVar;
                    FrsModelController.this.b(i, i2, apVar);
                    ArrayList<m> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.eYw.setThreadList(arrayList2);
                    FrsModelController.this.frk.a(i, i2, apVar, arrayList);
                }
            }
        };
        this.eDT = 0L;
        this.eDU = 0L;
        this.eDV = 0L;
        this.eDW = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.fqT = frsFragment;
        this.fra = nVar;
        M(this.fqT);
    }

    private void M(FrsFragment frsFragment) {
        this.frj = new y();
        this.frj.cnX = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.frj));
        this.frj.a(this.fru);
    }

    public void onActivityDestroy() {
        this.fpV.cancelLoadData();
    }

    public void J(Bundle bundle) {
        if (bundle != null) {
            this.eYL = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.frn = bundle.getString("yuelaou_locate");
            this.frb = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.frc = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.frd = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.fqT.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.eYL)) {
            this.eYL = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.frn)) {
            this.frn = "";
        }
        this.mSource = this.mFrom;
        bhF();
        this.eYw = new FrsViewData();
        this.fqZ.dV("forum_name", com.baidu.adp.lib.util.k.bx(this.eYL));
        this.fqZ.dV("client_type", "2");
        if (this.fpV == null) {
            this.fpV = new FrsNetModel<>(this.fqT.getPageContext(), this.fqZ);
        }
        this.fpV.a(this);
        this.fpV.setUniqueId(this.fqT.getPageContext().getUniqueId());
        if (this.eYL != null && this.eYL.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.eYL);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void bhF() {
        AccountData currentAccountObj;
        this.fqZ = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            rc(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            rc(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + "~";
            }
            rc(com.baidu.tieba.frs.f.g.vL("1~" + str + this.eYL));
        }
        this.fqZ.setSortType(getSortType());
        if (this.fro == 5) {
            this.fqZ.setIsGood(1);
        } else {
            this.fqZ.setIsGood(0);
        }
    }

    public boolean aRR() {
        if (this.dah != 1) {
            qY(1);
            return true;
        } else if (this.fpV.qz()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fqZ), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void y(int i, boolean z) {
        this.fqT.eYY = System.currentTimeMillis();
        if (this.eYw != null && this.eYw.getLikeFeedForumDataList() != null) {
            this.eYw.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fqZ), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.dah = c(this.dah, frsRequestData);
        if (this.dah == 1) {
            if (!this.fpV.qz()) {
                frsRequestData.setCallFrom(this.frc);
                a(frsRequestData, i, z ? false : true);
                this.frc = 0;
                return;
            }
            return;
        }
        if (this.frg == null) {
            this.frg = new am();
            this.frg.pn = 1;
            this.frg.forumName = this.eYL;
            if (this.eYw != null && this.eYw.getForum() != null) {
                this.frg.forumId = this.eYw.getForum().getId();
            }
        }
        qY(i);
    }

    public void qZ(int i) {
        if (this.dah != 1) {
            qY(4);
        } else if (!this.fpV.qz()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fqZ), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.fqT.iU(z);
        this.fra.pX(i);
        this.fpV.a(frsRequestData);
        this.mType = i;
        frsRequestData.Cq(this.fqT.bcT() ? "1" : "2");
        if (this.frq) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.rt(this.frp)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.frq = false;
        frsRequestData.setKw(this.eYL);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst());
        float aR = com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
        int i2 = ar.adp().adr() ? 2 : 1;
        frsRequestData.setScrW(aO);
        frsRequestData.setScrH(aQ);
        frsRequestData.setScrDip(aR);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.fpY);
        frsRequestData.setYuelaouLocate(this.frn);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.d(com.baidu.tbadk.util.y.aqn(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.eYZ != 0) {
            frsRequestData.setCtime((int) FrsFragment.eYZ);
        }
        if (FrsFragment.eZa != 0) {
            frsRequestData.setDataSize((int) FrsFragment.eZa);
        }
        if (FrsFragment.eZb != 0) {
            frsRequestData.setNetError(FrsFragment.eZb);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.dP(this.frd);
        if (this.frd != 0) {
            this.frd = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.fro, frsRequestData);
        b(i, frsRequestData);
        a(this.eYL, frsRequestData);
        if (!rb(this.fro) && !this.fqT.eYM) {
            String d = com.baidu.tieba.tbadkCore.d.cdr().d("1~" + this.eYL, frsRequestData.getSortType(), frsRequestData.getIsGood(), this.fqZ.getCategoryId());
            this.frr = d;
            new a(this, true, d).execute(new Object[0]);
        }
        bhp();
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
        rc(com.baidu.tieba.frs.f.g.ru(jVar.getSortType()));
        x(com.baidu.tieba.frs.f.g.ru(jVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.dah = jVar.getFrsDefaultTabId();
        }
        this.eYw.receiveData(jVar);
        d(this.eYw);
        this.fqY = new ArrayList<>();
        if (frsRequestData != null) {
            this.fqZ = frsRequestData;
            this.mPn = this.fqZ.getPn();
            this.eYL = this.fqZ.getKw();
            this.fqT.setForumName(this.eYL);
            this.fqT.setFrom(this.mFrom);
            this.fqT.setPn(this.mPn);
            this.fqT.setFlag(this.mFlag);
        }
        if (this.eYw.getThreadList() != null) {
            this.fqY.addAll(this.eYw.getThreadList());
        }
        if (this.dah != 1 && this.isNetFirstLoad) {
            this.fra.a(7, false, this.fpX);
        } else {
            this.fra.a(this.mType, false, this.fpX);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.fqZ)) {
            bhU();
        }
        this.isNetFirstLoad = false;
        if (jVar.getForum() == null || TextUtils.isEmpty(jVar.getForum().getName()) || frsRequestData == null || r.bWG().bWA() == null) {
            return true;
        }
        r.bWG().bWA().g(jVar.getForum().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.j jVar;
        e.b bVar = new e.b();
        bVar.iDX = com.baidu.adp.lib.util.j.kY() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcSocketResponsedMessage.getError();
        bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        bVar.iDY = mvcSocketResponsedMessage.getDownSize();
        this.fpX = bVar;
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
        this.fqT.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.frm) {
            this.frm = true;
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
        bVar.iDX = com.baidu.adp.lib.util.j.kY() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcHttpResponsedMessage.getError();
        bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        bVar.iDY = mvcHttpResponsedMessage.getDownSize();
        this.fpX = bVar;
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
        this.fqT.a(errorData);
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
        if (!this.frm) {
            this.frm = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bcL() {
        if (this.eYw != null && this.eYw.getForum() != null && this.eYw.getForum().getBannerListData() != null) {
            String lastIds = this.eYw.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fpY = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.o.m.apl().apm()) {
            this.cqw = System.currentTimeMillis() - this.fqT.beginTime;
            com.baidu.tbadk.o.i iVar = new com.baidu.tbadk.o.i(i, z, responsedMessage, this.fqT.cqn, this.fqT.createTime, this.fqT.cqv, false, this.cqw);
            this.fqT.createTime = 0L;
            this.fqT.cqn = 0L;
            if (iVar != null) {
                iVar.aph();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.o.m.apl().apm()) {
            this.cqw = System.currentTimeMillis() - this.fqT.eYY;
            com.baidu.tbadk.o.i iVar = new com.baidu.tbadk.o.i(1000, z, responsedMessage, this.fqT.cqn, this.fqT.createTime, this.fqT.cqv, false, this.cqw);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.cqE = this.cqw;
                    iVar.fe(true);
                } else if (this.mType == 3) {
                    iVar.cqF = this.cqw;
                    iVar.fe(false);
                }
            }
        }
    }

    public FrsRequestData bhG() {
        return this.fqZ;
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

    public FrsViewData bho() {
        return this.eYw;
    }

    public e.b bhH() {
        return this.fpX;
    }

    private void bhp() {
        this.eDT = System.currentTimeMillis();
        this.fpV.aov();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.tbadkCore.j jVar) {
        this.isCacheFirstLoad = false;
        this.eYw.receiveData(jVar);
        d(this.eYw);
        this.fqY = new ArrayList<>();
        if (this.eYw.getThreadList() != null) {
            this.fqY.addAll(this.eYw.getThreadList());
        }
        this.fra.b(jVar);
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
        private String fry;
        private FrsModelController frz;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.fry = null;
            this.fry = str;
            this.frz = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.d.cdr().Co(this.fry)) {
                if (!com.baidu.tieba.tbadkCore.d.cdr().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.fry)) {
                    com.baidu.tieba.tbadkCore.d.cdr().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.j responseData = com.baidu.tieba.tbadkCore.d.cdr().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().Xg(), true) && !responseData.getBookInfo().Xg().equals("0") && responseData.getBookInfo().Xh() == 3 && (l = com.baidu.adp.lib.g.b.l(responseData.getBookInfo().Xg(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(l))) != null) {
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
            if (this.frz != null && jVarArr != null) {
                this.frz.f(jVarArr.length > 0 ? jVarArr[0] : null);
                this.frz.x(this.frz.fro, true);
            }
        }
    }

    public long aWR() {
        return this.eDW;
    }

    public long aWS() {
        return this.eDU;
    }

    public long aWT() {
        return this.eDV;
    }

    public long aWU() {
        return this.eDT;
    }

    public boolean qz() {
        return this.fpV.qz();
    }

    public int bhI() {
        return this.frf;
    }

    private void bhJ() {
        if (this.frl == null) {
            this.frl = new ArrayList<>();
        }
        if (this.frl.size() == 0) {
            this.frl.add(new u());
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, int i2, am amVar) {
        this.dah = c(i, null);
        if (amVar == null && (amVar = bs(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.lo() && this.frk != null) {
                ap apVar = new ap();
                apVar.hasMore = false;
                apVar.pn = 1;
                apVar.forumName = this.eYL;
                apVar.fde = false;
                if (this.eYw != null && this.eYw.getForum() != null) {
                    apVar.forumId = this.eYw.getForum().getId();
                }
                bhJ();
                this.eYw.setThreadList(this.frl);
                this.frk.a(i, i2, apVar, this.frl);
            }
            amVar = new am();
            amVar.pn = -1;
        }
        if (this.eYw != null && this.eYw.getForum() != null) {
            amVar.forumId = this.eYw.getForum().getId();
        }
        amVar.forumName = this.eYL;
        if (w.bej().qp(1) != null && this.dah == 1) {
            this.fqZ.setCategoryId(i2);
        }
        this.fre = i2;
        this.frg = amVar;
        b(i, i2, amVar);
        qY(5);
    }

    @Override // com.baidu.tieba.frs.af
    public void a(ai aiVar) {
        this.frk = aiVar;
        this.frj.a(this.fru);
    }

    private void qY(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.frg != null) {
                    this.frg.pn++;
                    break;
                }
                break;
            case 2:
                if (this.frg != null) {
                    am amVar = this.frg;
                    amVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.frg != null) {
                    this.frg.pn = -1;
                    break;
                }
                break;
        }
        if (this.dah == 1) {
            if (this.frf == this.fre) {
                ArrayList<m> arrayList = new ArrayList<>();
                if (this.fqY != null) {
                    arrayList.addAll(this.fqY);
                }
                this.eYw.setThreadList(arrayList);
                if (this.frk != null) {
                    this.frk.a(this.dah, this.fre, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.frf = this.fre;
            return;
        }
        af qq = this.frj.qq(this.dah);
        if (qq != null) {
            this.frh = true;
            qq.a(this.dah, this.fre, this.frg);
            return;
        }
        if (this.eYw != null && this.eYw.getThreadList() != null) {
            this.eYw.getThreadList().clear();
        }
        this.frk.a(this.dah, this.fre, null, null);
    }

    public boolean hasMore() {
        if ((this.frg instanceof ap) && ((ap) this.frg).errCode == 0) {
            return ((ap) this.frg).hasMore;
        }
        return true;
    }

    private int br(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, am amVar) {
        this.fri.put(br(i, i2), amVar);
    }

    public am bs(int i, int i2) {
        return this.fri.get(br(i, i2));
    }

    @Override // com.baidu.tieba.frs.af
    public void init() {
        this.frj.init();
    }

    @Override // com.baidu.tieba.frs.af
    public void aDF() {
        this.frj.destory();
        this.frj.clear();
    }

    public int bhK() {
        return this.dah;
    }

    public boolean bhL() {
        return 1 == this.dah;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(ak akVar) {
        if (akVar != null && !StringUtils.isNull(akVar.getId()) && !v.T(this.fqY)) {
            if (this.dah == 1) {
                this.eYw.addMyNewThread(akVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<m> it = this.fqY.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if ((next instanceof bf) && akVar.getId().equals(((bf) next).threadData.getId())) {
                    return;
                }
            }
            this.fqY.add(topThreadSize, akVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.fqY == null || this.fqY.size() <= 0) {
            return 0;
        }
        Iterator<m> it = this.fqY.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                m next = it.next();
                if (!(next instanceof bf)) {
                    i = i2;
                } else if (((bf) next).threadData.YM() != 0) {
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

    public boolean bhM() {
        return this.frh;
    }

    public void bhN() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.frf == 0) {
            mVar.qi(this.fro);
        }
        if (this.eYw.getThreadList() != null) {
            this.eYw.getThreadList().clear();
            this.eYw.getThreadList().add(mVar);
        }
        if (this.fqY != null) {
            this.fqY.clear();
            this.fqY.add(mVar);
        }
    }

    public ArrayList<m> bhO() {
        return this.fqY;
    }

    public void rc(int i) {
        AccountData currentAccountObj;
        this.fro = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + "~";
        }
        com.baidu.tieba.frs.f.g.aA("1~" + str + this.eYL, this.fro);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cfo();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cfp();
        }
    }

    public void rd(int i) {
        this.frp = i;
    }

    public void jM(boolean z) {
        this.frq = z;
    }

    public int bhP() {
        return this.fro;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.rt(this.fro);
    }

    public boolean bhQ() {
        return this.frb;
    }

    public boolean bhR() {
        return this.fro == 5;
    }

    public boolean bhS() {
        return this.fqZ != null && this.fqZ.getLoadType() == 1;
    }

    public boolean bhT() {
        return this.fro == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.fqT.bcl() != null) {
            return this.fqT.bcl().a(this.fro, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bg.bBm.get() && r.bWG().bWA() != null) {
            int aq = r.bWG().bWA().aq(str, false);
            int ar = r.bWG().bWA().ar(str, false);
            if (frsRequestData.getLoadType() == 1) {
                aq++;
            } else if (frsRequestData.getLoadType() == 2) {
                ar++;
            }
            frsRequestData.setRefreshCount(aq);
            frsRequestData.setLoadCount(ar);
        }
    }

    public void bhU() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.eYw != null && this.eYw.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.d(this.eYw.getForum().getId(), 0L));
        }
        this.fqT.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void vy(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cdr().dS(FrsModelController.this.frr, str);
                return null;
            }
        }, null);
    }

    public void vz(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cdr().dT(FrsModelController.this.frr, str);
                return null;
            }
        }, null);
    }

    public void vA(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cdr().dU(FrsModelController.this.frr, str);
                return null;
            }
        }, null);
    }
}
