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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private long cLr;
    private int fGn;
    private FrsNetModel<FrsFragment> fMh;
    private e.b fMj;
    private String fMk;
    private boolean fNA;
    private String fNB;
    private int fNC;
    private int fND;
    private boolean fNE;
    private String fNF;
    private final SparseArray<Boolean> fNG;
    private ai fNH;
    private final FrsFragment fNh;
    private ArrayList<m> fNm;
    private FrsRequestData fNn;
    private final p fNo;
    private boolean fNp;
    private int fNq;
    private long fNr;
    private int fNs;
    private int fNt;
    private am fNu;
    private boolean fNv;
    private SparseArray<am> fNw;
    private y fNx;
    private ai fNy;
    private ArrayList<m> fNz;
    private long fcl;
    private long fcm;
    private long fcn;
    private long fco;
    private FrsViewData fua;
    private String fup;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean rv(int i) {
        return this.fNG.get(i, false).booleanValue();
    }

    public void D(int i, boolean z) {
        this.fNG.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, p pVar) {
        super(frsFragment.getPageContext());
        this.fup = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.fNq = 0;
        this.mSource = null;
        this.fMk = null;
        this.fNr = 0L;
        this.fGn = 1;
        this.fNs = 0;
        this.fNt = 0;
        this.fNv = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.fNw = new SparseArray<>();
        this.cLr = 0L;
        this.fNA = false;
        this.fNC = -1;
        this.fND = -1;
        this.fNF = null;
        this.fNG = new SparseArray<>();
        this.fNH = new ai() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ai
            public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
                FrsModelController.this.fNv = false;
                if (i == FrsModelController.this.fGn && FrsModelController.this.fNy != null) {
                    FrsModelController.this.fNu = apVar;
                    FrsModelController.this.b(i, i2, apVar);
                    ArrayList<m> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.fua.setThreadList(arrayList2);
                    FrsModelController.this.fNy.a(i, i2, apVar, arrayList);
                }
            }
        };
        this.fcl = 0L;
        this.fcm = 0L;
        this.fcn = 0L;
        this.fco = 0L;
        if (pVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.fNh = frsFragment;
        this.fNo = pVar;
        M(this.fNh);
    }

    private void M(FrsFragment frsFragment) {
        this.fNx = new y();
        this.fNx.cJo = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.fNx));
        this.fNx.a(this.fNH);
    }

    public void aGF() {
        this.fMh.cancelLoadData();
    }

    public void K(Bundle bundle) {
        if (bundle != null) {
            this.fup = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fNB = bundle.getString("yuelaou_locate");
            this.fNp = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.fNq = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.fNr = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.fNh.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.fup)) {
            this.fup = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.fNB)) {
            this.fNB = "";
        }
        this.mSource = this.mFrom;
        bpc();
        this.fua = new FrsViewData();
        this.fNn.dX("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.fup));
        this.fNn.dX("client_type", "2");
        if (this.fMh == null) {
            this.fMh = new FrsNetModel<>(this.fNh.getPageContext(), this.fNn);
        }
        this.fMh.a(this);
        this.fMh.setUniqueId(this.fNh.getPageContext().getUniqueId());
        if (this.fup != null && this.fup.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.fup);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void bpc() {
        AccountData currentAccountObj;
        this.fNn = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            rw(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            rw(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            rw(com.baidu.tieba.frs.f.g.wx("1~" + str + this.fup));
        }
        this.fNn.setSortType(getSortType());
        if (this.fNC == 5) {
            this.fNn.setIsGood(1);
        } else {
            this.fNn.setIsGood(0);
        }
    }

    public boolean bbJ() {
        if (this.fGn != 1) {
            rs(1);
            return true;
        } else if (this.fMh.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fNn), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void E(int i, boolean z) {
        this.fNh.fuC = System.currentTimeMillis();
        if (this.fua != null && this.fua.getLikeFeedForumDataList() != null) {
            this.fua.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fNn), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.fGn = c(this.fGn, frsRequestData);
        if (this.fGn == 1) {
            if (!this.fMh.isLoading()) {
                frsRequestData.setCallFrom(this.fNq);
                a(frsRequestData, i, z ? false : true);
                this.fNq = 0;
                return;
            }
            return;
        }
        if (this.fNu == null) {
            this.fNu = new am();
            this.fNu.pn = 1;
            this.fNu.forumName = this.fup;
            if (this.fua != null && this.fua.getForum() != null) {
                this.fNu.forumId = this.fua.getForum().getId();
            }
        }
        rs(i);
    }

    public void rt(int i) {
        if (this.fGn != 1) {
            rs(4);
        } else if (!this.fMh.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fNn), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.fNh.jF(z);
        this.fNo.qp(i);
        this.fMh.a(frsRequestData);
        this.mType = i;
        frsRequestData.DF(this.fNh.bkp() ? "1" : "2");
        if (this.fNE) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.rO(this.fND)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.fNE = false;
        frsRequestData.setKw(this.fup);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = ar.amM().isFrsShowBigImage() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.fMk);
        frsRequestData.setYuelaouLocate(this.fNB);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.toLong(x.axN(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.zI(bpd());
        if (FrsFragment.fuD != 0) {
            frsRequestData.setCtime((int) FrsFragment.fuD);
        }
        if (FrsFragment.fuE != 0) {
            frsRequestData.setDataSize((int) FrsFragment.fuE);
        }
        if (FrsFragment.fuF != 0) {
            frsRequestData.setNetError(FrsFragment.fuF);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.dT(this.fNr);
        if (this.fNr != 0) {
            this.fNr = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.fNC, frsRequestData);
        b(i, frsRequestData);
        a(this.fup, frsRequestData);
        if (!rv(this.fNC) && !this.fNh.fuq) {
            String e = com.baidu.tieba.tbadkCore.d.cnj().e("1~" + this.fup, frsRequestData.getSortType(), frsRequestData.getIsGood(), this.fNn.getCategoryId());
            this.fNF = e;
            new a(this, true, e).execute(new Object[0]);
        }
        boL();
    }

    private int bpd() {
        return (this.fNh == null || !(this.fNh.mHeadLineDefaultNavTabId == -1 || this.fNh.mHeadLineDefaultNavTabId == this.fGn)) ? 0 : 1;
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
        rw(com.baidu.tieba.frs.f.g.rP(lVar.getSortType()));
        D(com.baidu.tieba.frs.f.g.rP(lVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.fGn = lVar.getFrsDefaultTabId();
        }
        this.fua.receiveData(lVar);
        d(this.fua);
        this.fNm = new ArrayList<>();
        if (frsRequestData != null) {
            this.fNn = frsRequestData;
            this.mPn = this.fNn.getPn();
            this.fup = this.fNn.getKw();
            this.fNh.setForumName(this.fup);
            this.fNh.setFrom(this.mFrom);
            this.fNh.setPn(this.mPn);
            this.fNh.setFlag(this.mFlag);
        }
        if (this.fua.getThreadList() != null) {
            this.fNm.addAll(this.fua.getThreadList());
        }
        if (this.fGn != 1 && this.isNetFirstLoad) {
            this.fNo.a(7, false, this.fMj);
        } else {
            this.fNo.a(this.mType, false, this.fMj);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.fNn)) {
            bps();
        }
        this.isNetFirstLoad = false;
        if (lVar.getForum() != null && !TextUtils.isEmpty(lVar.getForum().getName()) && frsRequestData != null && r.cfJ().cfD() != null) {
            r.cfJ().cfD().f(lVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        com.baidu.tieba.frs.a.biU().jA(this.fGn == 301);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        e.b bVar = new e.b();
        bVar.ffA = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcSocketResponsedMessage.getError();
        bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        bVar.jfm = mvcSocketResponsedMessage.getDownSize();
        this.fMj = bVar;
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
        this.fNh.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.fNA) {
            this.fNA = true;
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
            objArr[2] = BdStatsConstant.StatsKey.SEQUENCEID;
            objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
            com.baidu.tbadk.core.e.a.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.l> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        e.b bVar = new e.b();
        bVar.ffA = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcHttpResponsedMessage.getError();
        bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        bVar.jfm = mvcHttpResponsedMessage.getDownSize();
        this.fMj = bVar;
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
        this.fNh.a(errorData);
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
        if (!this.fNA) {
            this.fNA = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bkh() {
        if (this.fua != null && this.fua.getForum() != null && this.fua.getForum().getBannerListData() != null) {
            String lastIds = this.fua.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fMk = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.awL().awM()) {
            this.cLr = System.currentTimeMillis() - this.fNh.beginTime;
            com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(i, z, responsedMessage, this.fNh.cLi, this.fNh.createTime, this.fNh.cLq, false, this.cLr);
            this.fNh.createTime = 0L;
            this.fNh.cLi = 0L;
            if (iVar != null) {
                iVar.awI();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.awL().awM()) {
            this.cLr = System.currentTimeMillis() - this.fNh.fuC;
            com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(1000, z, responsedMessage, this.fNh.cLi, this.fNh.createTime, this.fNh.cLq, false, this.cLr);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.cLz = this.cLr;
                    iVar.fw(true);
                } else if (this.mType == 3) {
                    iVar.cLA = this.cLr;
                    iVar.fw(false);
                }
            }
        }
    }

    public FrsRequestData bpe() {
        return this.fNn;
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

    public FrsViewData boK() {
        return this.fua;
    }

    public e.b bpf() {
        return this.fMj;
    }

    private void boL() {
        this.fcl = System.currentTimeMillis();
        this.fMh.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.tieba.tbadkCore.l lVar) {
        this.isCacheFirstLoad = false;
        this.fua.receiveData(lVar);
        d(this.fua);
        this.fNm = new ArrayList<>();
        if (this.fua.getThreadList() != null) {
            this.fNm.addAll(this.fua.getThreadList());
        }
        this.fNo.c(lVar);
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
        private String fNL;
        private FrsModelController fNM;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.fNL = null;
            this.fNL = str;
            this.fNM = frsModelController;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            int i;
            CustomResponsedMessage runTask;
            if (this.needCache && com.baidu.tieba.tbadkCore.d.cnj().DD(this.fNL)) {
                if (!com.baidu.tieba.tbadkCore.d.cnj().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.fNL)) {
                    com.baidu.tieba.tbadkCore.d.cnj().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.l responseData = com.baidu.tieba.tbadkCore.d.cnj().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().agW(), true) && !responseData.getBookInfo().agW().equals("0") && responseData.getBookInfo().agX() == 3 && (i = com.baidu.adp.lib.g.b.toInt(responseData.getBookInfo().agW(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.fNM != null && lVarArr != null) {
                this.fNM.g(lVarArr.length > 0 ? lVarArr[0] : null);
                this.fNM.D(this.fNM.fNC, true);
            }
        }
    }

    public long beJ() {
        return this.fco;
    }

    public long beK() {
        return this.fcm;
    }

    public long beL() {
        return this.fcn;
    }

    public long beM() {
        return this.fcl;
    }

    public boolean isLoading() {
        return this.fMh.isLoading();
    }

    public int bpg() {
        return this.fNt;
    }

    private void bph() {
        if (this.fNz == null) {
            this.fNz = new ArrayList<>();
        }
        if (this.fNz.size() == 0) {
            this.fNz.add(new u());
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, int i2, am amVar) {
        this.fGn = c(i, null);
        if (amVar == null && (amVar = by(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.fNy != null) {
                ap apVar = new ap();
                apVar.hasMore = false;
                apVar.pn = 1;
                apVar.forumName = this.fup;
                apVar.fyK = false;
                if (this.fua != null && this.fua.getForum() != null) {
                    apVar.forumId = this.fua.getForum().getId();
                }
                bph();
                this.fua.setThreadList(this.fNz);
                this.fNy.a(i, i2, apVar, this.fNz);
            }
            amVar = new am();
            amVar.pn = -1;
        }
        if (this.fua != null && this.fua.getForum() != null) {
            amVar.forumId = this.fua.getForum().getId();
        }
        amVar.forumName = this.fup;
        if (w.blA().qH(1) != null && this.fGn == 1) {
            this.fNn.setCategoryId(i2);
        }
        this.fNs = i2;
        this.fNu = amVar;
        b(i, i2, amVar);
        rs(5);
    }

    @Override // com.baidu.tieba.frs.af
    public void a(ai aiVar) {
        this.fNy = aiVar;
        this.fNx.a(this.fNH);
    }

    private void rs(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.fNu != null) {
                    this.fNu.pn++;
                    break;
                }
                break;
            case 2:
                if (this.fNu != null) {
                    am amVar = this.fNu;
                    amVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.fNu != null) {
                    this.fNu.pn = -1;
                    break;
                }
                break;
        }
        if (this.fGn == 1) {
            if (this.fNt == this.fNs) {
                ArrayList<m> arrayList = new ArrayList<>();
                if (this.fNm != null) {
                    arrayList.addAll(this.fNm);
                }
                this.fua.setThreadList(arrayList);
                if (this.fNy != null) {
                    this.fNy.a(this.fGn, this.fNs, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.fNt = this.fNs;
            return;
        }
        af qI = this.fNx.qI(this.fGn);
        if (qI != null) {
            this.fNv = true;
            qI.a(this.fGn, this.fNs, this.fNu);
            return;
        }
        if (this.fua != null && this.fua.getThreadList() != null) {
            this.fua.getThreadList().clear();
        }
        this.fNy.a(this.fGn, this.fNs, null, null);
    }

    public boolean hasMore() {
        if ((this.fNu instanceof ap) && ((ap) this.fNu).errCode == 0) {
            return ((ap) this.fNu).hasMore;
        }
        return true;
    }

    private int bx(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, am amVar) {
        this.fNw.put(bx(i, i2), amVar);
    }

    public am by(int i, int i2) {
        return this.fNw.get(bx(i, i2));
    }

    @Override // com.baidu.tieba.frs.af
    public void init() {
        this.fNx.init();
    }

    @Override // com.baidu.tieba.frs.af
    public void aMK() {
        this.fNx.destory();
        this.fNx.clear();
    }

    public int bpi() {
        return this.fGn;
    }

    public boolean bpj() {
        return 1 == this.fGn;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(ak akVar) {
        if (akVar != null && !StringUtils.isNull(akVar.getId()) && !v.isEmpty(this.fNm)) {
            if (this.fGn == 1) {
                this.fua.addMyNewThread(akVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<m> it = this.fNm.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if ((next instanceof bg) && akVar.getId().equals(((bg) next).caz.getId())) {
                    return;
                }
            }
            this.fNm.add(topThreadSize, akVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.fNm == null || this.fNm.size() <= 0) {
            return 0;
        }
        Iterator<m> it = this.fNm.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                m next = it.next();
                if (!(next instanceof bg)) {
                    i = i2;
                } else if (((bg) next).caz.aiz() != 0) {
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

    public boolean bpk() {
        return this.fNv;
    }

    public void bpl() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.fNt == 0) {
            mVar.qA(this.fNC);
        }
        if (this.fua.getThreadList() != null) {
            this.fua.getThreadList().clear();
            this.fua.getThreadList().add(mVar);
        }
        if (this.fNm != null) {
            this.fNm.clear();
            this.fNm.add(mVar);
        }
    }

    public ArrayList<m> bpm() {
        return this.fNm;
    }

    public void rw(int i) {
        AccountData currentAccountObj;
        this.fNC = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
        }
        com.baidu.tieba.frs.f.g.au("1~" + str + this.fup, this.fNC);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cpo();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cpp();
        }
    }

    public void rx(int i) {
        this.fND = i;
    }

    public void kz(boolean z) {
        this.fNE = z;
    }

    public int bpn() {
        return this.fNC;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.rO(this.fNC);
    }

    public boolean bpo() {
        return this.fNp;
    }

    public boolean bpp() {
        return this.fNC == 5;
    }

    public boolean bpq() {
        return this.fNn != null && this.fNn.getLoadType() == 1;
    }

    public boolean bpr() {
        return this.fNC == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.fNh.bjE() != null) {
            return this.fNh.bjE().a(this.fNC, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bh.cbd.get() && r.cfJ().cfD() != null) {
            int as = r.cfJ().cfD().as(str, false);
            int at = r.cfJ().cfD().at(str, false);
            if (frsRequestData.getLoadType() == 1) {
                as++;
            } else if (frsRequestData.getLoadType() == 2) {
                at++;
            }
            frsRequestData.setRefreshCount(as);
            frsRequestData.setLoadCount(at);
        }
    }

    public void bps() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.fua != null && this.fua.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.toLong(this.fua.getForum().getId(), 0L));
        }
        this.fNh.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void wo(final String str) {
        z.a(new com.baidu.tbadk.util.y<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cnj().dU(FrsModelController.this.fNF, str);
                return null;
            }
        }, null);
    }

    public void wp(final String str) {
        z.a(new com.baidu.tbadk.util.y<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cnj().dV(FrsModelController.this.fNF, str);
                return null;
            }
        }, null);
    }

    public void wq(final String str) {
        z.a(new com.baidu.tbadk.util.y<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cnj().dW(FrsModelController.this.fNF, str);
                return null;
            }
        }, null);
    }
}
