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
    private int dad;
    private long eDP;
    private long eDQ;
    private long eDR;
    private long eDS;
    private String eYK;
    private FrsViewData eYv;
    private FrsNetModel<FrsFragment> fpU;
    private e.b fpW;
    private String fpX;
    private final FrsFragment fqS;
    private ArrayList<m> fqX;
    private FrsRequestData fqY;
    private final n fqZ;
    private boolean fra;
    private int frb;
    private long frc;
    private int frd;
    private int fre;
    private am frf;
    private boolean frg;
    private SparseArray<am> frh;
    private y fri;
    private ai frj;
    private ArrayList<m> frk;
    private boolean frl;
    private String frm;
    private int frn;
    private int fro;
    private boolean frp;
    private String frq;
    private final SparseArray<Boolean> frr;
    private ai frt;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean rb(int i) {
        return this.frr.get(i, false).booleanValue();
    }

    public void x(int i, boolean z) {
        this.frr.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.eYK = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.frb = 0;
        this.mSource = null;
        this.fpX = null;
        this.frc = 0L;
        this.dad = 1;
        this.frd = 0;
        this.fre = 0;
        this.frg = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.frh = new SparseArray<>();
        this.cqw = 0L;
        this.frl = false;
        this.frn = -1;
        this.fro = -1;
        this.frq = null;
        this.frr = new SparseArray<>();
        this.frt = new ai() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ai
            public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
                FrsModelController.this.frg = false;
                if (i == FrsModelController.this.dad && FrsModelController.this.frj != null) {
                    FrsModelController.this.frf = apVar;
                    FrsModelController.this.b(i, i2, apVar);
                    ArrayList<m> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.eYv.setThreadList(arrayList2);
                    FrsModelController.this.frj.a(i, i2, apVar, arrayList);
                }
            }
        };
        this.eDP = 0L;
        this.eDQ = 0L;
        this.eDR = 0L;
        this.eDS = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.fqS = frsFragment;
        this.fqZ = nVar;
        M(this.fqS);
    }

    private void M(FrsFragment frsFragment) {
        this.fri = new y();
        this.fri.cnX = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.fri));
        this.fri.a(this.frt);
    }

    public void onActivityDestroy() {
        this.fpU.cancelLoadData();
    }

    public void J(Bundle bundle) {
        if (bundle != null) {
            this.eYK = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.frm = bundle.getString("yuelaou_locate");
            this.fra = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.frb = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.frc = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.fqS.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.eYK)) {
            this.eYK = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.frm)) {
            this.frm = "";
        }
        this.mSource = this.mFrom;
        bhF();
        this.eYv = new FrsViewData();
        this.fqY.dU("forum_name", com.baidu.adp.lib.util.k.bx(this.eYK));
        this.fqY.dU("client_type", "2");
        if (this.fpU == null) {
            this.fpU = new FrsNetModel<>(this.fqS.getPageContext(), this.fqY);
        }
        this.fpU.a(this);
        this.fpU.setUniqueId(this.fqS.getPageContext().getUniqueId());
        if (this.eYK != null && this.eYK.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.eYK);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void bhF() {
        AccountData currentAccountObj;
        this.fqY = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            rc(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            rc(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + "~";
            }
            rc(com.baidu.tieba.frs.f.g.vK("1~" + str + this.eYK));
        }
        this.fqY.setSortType(getSortType());
        if (this.frn == 5) {
            this.fqY.setIsGood(1);
        } else {
            this.fqY.setIsGood(0);
        }
    }

    public boolean aRR() {
        if (this.dad != 1) {
            qY(1);
            return true;
        } else if (this.fpU.qz()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fqY), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void y(int i, boolean z) {
        this.fqS.eYX = System.currentTimeMillis();
        if (this.eYv != null && this.eYv.getLikeFeedForumDataList() != null) {
            this.eYv.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fqY), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.dad = c(this.dad, frsRequestData);
        if (this.dad == 1) {
            if (!this.fpU.qz()) {
                frsRequestData.setCallFrom(this.frb);
                a(frsRequestData, i, z ? false : true);
                this.frb = 0;
                return;
            }
            return;
        }
        if (this.frf == null) {
            this.frf = new am();
            this.frf.pn = 1;
            this.frf.forumName = this.eYK;
            if (this.eYv != null && this.eYv.getForum() != null) {
                this.frf.forumId = this.eYv.getForum().getId();
            }
        }
        qY(i);
    }

    public void qZ(int i) {
        if (this.dad != 1) {
            qY(4);
        } else if (!this.fpU.qz()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fqY), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.fqS.iU(z);
        this.fqZ.pX(i);
        this.fpU.a(frsRequestData);
        this.mType = i;
        frsRequestData.Cp(this.fqS.bcT() ? "1" : "2");
        if (this.frp) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.rt(this.fro)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.frp = false;
        frsRequestData.setKw(this.eYK);
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
        frsRequestData.setLastId(this.fpX);
        frsRequestData.setYuelaouLocate(this.frm);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.d(com.baidu.tbadk.util.y.aqn(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.eYY != 0) {
            frsRequestData.setCtime((int) FrsFragment.eYY);
        }
        if (FrsFragment.eYZ != 0) {
            frsRequestData.setDataSize((int) FrsFragment.eYZ);
        }
        if (FrsFragment.eZa != 0) {
            frsRequestData.setNetError(FrsFragment.eZa);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.dP(this.frc);
        if (this.frc != 0) {
            this.frc = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.frn, frsRequestData);
        b(i, frsRequestData);
        a(this.eYK, frsRequestData);
        if (!rb(this.frn) && !this.fqS.eYL) {
            String d = com.baidu.tieba.tbadkCore.d.cdu().d("1~" + this.eYK, frsRequestData.getSortType(), frsRequestData.getIsGood(), this.fqY.getCategoryId());
            this.frq = d;
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
            this.dad = jVar.getFrsDefaultTabId();
        }
        this.eYv.receiveData(jVar);
        d(this.eYv);
        this.fqX = new ArrayList<>();
        if (frsRequestData != null) {
            this.fqY = frsRequestData;
            this.mPn = this.fqY.getPn();
            this.eYK = this.fqY.getKw();
            this.fqS.setForumName(this.eYK);
            this.fqS.setFrom(this.mFrom);
            this.fqS.setPn(this.mPn);
            this.fqS.setFlag(this.mFlag);
        }
        if (this.eYv.getThreadList() != null) {
            this.fqX.addAll(this.eYv.getThreadList());
        }
        if (this.dad != 1 && this.isNetFirstLoad) {
            this.fqZ.a(7, false, this.fpW);
        } else {
            this.fqZ.a(this.mType, false, this.fpW);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.fqY)) {
            bhU();
        }
        this.isNetFirstLoad = false;
        if (jVar.getForum() == null || TextUtils.isEmpty(jVar.getForum().getName()) || frsRequestData == null || r.bWJ().bWD() == null) {
            return true;
        }
        r.bWJ().bWD().g(jVar.getForum().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.j jVar;
        e.b bVar = new e.b();
        bVar.iDQ = com.baidu.adp.lib.util.j.kY() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcSocketResponsedMessage.getError();
        bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        bVar.iDR = mvcSocketResponsedMessage.getDownSize();
        this.fpW = bVar;
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
        this.fqS.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.frl) {
            this.frl = true;
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
        bVar.iDQ = com.baidu.adp.lib.util.j.kY() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcHttpResponsedMessage.getError();
        bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        bVar.iDR = mvcHttpResponsedMessage.getDownSize();
        this.fpW = bVar;
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
        this.fqS.a(errorData);
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
        if (!this.frl) {
            this.frl = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bcL() {
        if (this.eYv != null && this.eYv.getForum() != null && this.eYv.getForum().getBannerListData() != null) {
            String lastIds = this.eYv.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fpX = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.o.m.apk().apl()) {
            this.cqw = System.currentTimeMillis() - this.fqS.beginTime;
            com.baidu.tbadk.o.i iVar = new com.baidu.tbadk.o.i(i, z, responsedMessage, this.fqS.cqn, this.fqS.createTime, this.fqS.cqv, false, this.cqw);
            this.fqS.createTime = 0L;
            this.fqS.cqn = 0L;
            if (iVar != null) {
                iVar.apg();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.o.m.apk().apl()) {
            this.cqw = System.currentTimeMillis() - this.fqS.eYX;
            com.baidu.tbadk.o.i iVar = new com.baidu.tbadk.o.i(1000, z, responsedMessage, this.fqS.cqn, this.fqS.createTime, this.fqS.cqv, false, this.cqw);
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
        return this.fqY;
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
        return this.eYv;
    }

    public e.b bhH() {
        return this.fpW;
    }

    private void bhp() {
        this.eDP = System.currentTimeMillis();
        this.fpU.aou();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.tbadkCore.j jVar) {
        this.isCacheFirstLoad = false;
        this.eYv.receiveData(jVar);
        d(this.eYv);
        this.fqX = new ArrayList<>();
        if (this.eYv.getThreadList() != null) {
            this.fqX.addAll(this.eYv.getThreadList());
        }
        this.fqZ.b(jVar);
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
        private String frx;
        private FrsModelController fry;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.frx = null;
            this.frx = str;
            this.fry = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.d.cdu().Cn(this.frx)) {
                if (!com.baidu.tieba.tbadkCore.d.cdu().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.frx)) {
                    com.baidu.tieba.tbadkCore.d.cdu().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.j responseData = com.baidu.tieba.tbadkCore.d.cdu().getResponseData();
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
            if (this.fry != null && jVarArr != null) {
                this.fry.f(jVarArr.length > 0 ? jVarArr[0] : null);
                this.fry.x(this.fry.frn, true);
            }
        }
    }

    public long aWR() {
        return this.eDS;
    }

    public long aWS() {
        return this.eDQ;
    }

    public long aWT() {
        return this.eDR;
    }

    public long aWU() {
        return this.eDP;
    }

    public boolean qz() {
        return this.fpU.qz();
    }

    public int bhI() {
        return this.fre;
    }

    private void bhJ() {
        if (this.frk == null) {
            this.frk = new ArrayList<>();
        }
        if (this.frk.size() == 0) {
            this.frk.add(new u());
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, int i2, am amVar) {
        this.dad = c(i, null);
        if (amVar == null && (amVar = bs(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.lo() && this.frj != null) {
                ap apVar = new ap();
                apVar.hasMore = false;
                apVar.pn = 1;
                apVar.forumName = this.eYK;
                apVar.fdd = false;
                if (this.eYv != null && this.eYv.getForum() != null) {
                    apVar.forumId = this.eYv.getForum().getId();
                }
                bhJ();
                this.eYv.setThreadList(this.frk);
                this.frj.a(i, i2, apVar, this.frk);
            }
            amVar = new am();
            amVar.pn = -1;
        }
        if (this.eYv != null && this.eYv.getForum() != null) {
            amVar.forumId = this.eYv.getForum().getId();
        }
        amVar.forumName = this.eYK;
        if (w.bej().qp(1) != null && this.dad == 1) {
            this.fqY.setCategoryId(i2);
        }
        this.frd = i2;
        this.frf = amVar;
        b(i, i2, amVar);
        qY(5);
    }

    @Override // com.baidu.tieba.frs.af
    public void a(ai aiVar) {
        this.frj = aiVar;
        this.fri.a(this.frt);
    }

    private void qY(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.frf != null) {
                    this.frf.pn++;
                    break;
                }
                break;
            case 2:
                if (this.frf != null) {
                    am amVar = this.frf;
                    amVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.frf != null) {
                    this.frf.pn = -1;
                    break;
                }
                break;
        }
        if (this.dad == 1) {
            if (this.fre == this.frd) {
                ArrayList<m> arrayList = new ArrayList<>();
                if (this.fqX != null) {
                    arrayList.addAll(this.fqX);
                }
                this.eYv.setThreadList(arrayList);
                if (this.frj != null) {
                    this.frj.a(this.dad, this.frd, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.fre = this.frd;
            return;
        }
        af qq = this.fri.qq(this.dad);
        if (qq != null) {
            this.frg = true;
            qq.a(this.dad, this.frd, this.frf);
            return;
        }
        if (this.eYv != null && this.eYv.getThreadList() != null) {
            this.eYv.getThreadList().clear();
        }
        this.frj.a(this.dad, this.frd, null, null);
    }

    public boolean hasMore() {
        if ((this.frf instanceof ap) && ((ap) this.frf).errCode == 0) {
            return ((ap) this.frf).hasMore;
        }
        return true;
    }

    private int br(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, am amVar) {
        this.frh.put(br(i, i2), amVar);
    }

    public am bs(int i, int i2) {
        return this.frh.get(br(i, i2));
    }

    @Override // com.baidu.tieba.frs.af
    public void init() {
        this.fri.init();
    }

    @Override // com.baidu.tieba.frs.af
    public void aDF() {
        this.fri.destory();
        this.fri.clear();
    }

    public int bhK() {
        return this.dad;
    }

    public boolean bhL() {
        return 1 == this.dad;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(ak akVar) {
        if (akVar != null && !StringUtils.isNull(akVar.getId()) && !v.T(this.fqX)) {
            if (this.dad == 1) {
                this.eYv.addMyNewThread(akVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<m> it = this.fqX.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if ((next instanceof bf) && akVar.getId().equals(((bf) next).threadData.getId())) {
                    return;
                }
            }
            this.fqX.add(topThreadSize, akVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.fqX == null || this.fqX.size() <= 0) {
            return 0;
        }
        Iterator<m> it = this.fqX.iterator();
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
        return this.frg;
    }

    public void bhN() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.fre == 0) {
            mVar.qi(this.frn);
        }
        if (this.eYv.getThreadList() != null) {
            this.eYv.getThreadList().clear();
            this.eYv.getThreadList().add(mVar);
        }
        if (this.fqX != null) {
            this.fqX.clear();
            this.fqX.add(mVar);
        }
    }

    public ArrayList<m> bhO() {
        return this.fqX;
    }

    public void rc(int i) {
        AccountData currentAccountObj;
        this.frn = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + "~";
        }
        com.baidu.tieba.frs.f.g.aA("1~" + str + this.eYK, this.frn);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cfr();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cfs();
        }
    }

    public void rd(int i) {
        this.fro = i;
    }

    public void jM(boolean z) {
        this.frp = z;
    }

    public int bhP() {
        return this.frn;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.rt(this.frn);
    }

    public boolean bhQ() {
        return this.fra;
    }

    public boolean bhR() {
        return this.frn == 5;
    }

    public boolean bhS() {
        return this.fqY != null && this.fqY.getLoadType() == 1;
    }

    public boolean bhT() {
        return this.frn == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.fqS.bcl() != null) {
            return this.fqS.bcl().a(this.frn, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bg.bBo.get() && r.bWJ().bWD() != null) {
            int ar = r.bWJ().bWD().ar(str, false);
            int as = r.bWJ().bWD().as(str, false);
            if (frsRequestData.getLoadType() == 1) {
                ar++;
            } else if (frsRequestData.getLoadType() == 2) {
                as++;
            }
            frsRequestData.setRefreshCount(ar);
            frsRequestData.setLoadCount(as);
        }
    }

    public void bhU() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.eYv != null && this.eYv.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.d(this.eYv.getForum().getId(), 0L));
        }
        this.fqS.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void vx(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cdu().dR(FrsModelController.this.frq, str);
                return null;
            }
        }, null);
    }

    public void vy(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cdu().dS(FrsModelController.this.frq, str);
                return null;
            }
        }, null);
    }

    public void vz(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cdu().dT(FrsModelController.this.frq, str);
                return null;
            }
        }, null);
    }
}
