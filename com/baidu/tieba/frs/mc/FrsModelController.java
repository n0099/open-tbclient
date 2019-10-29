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
    private long cMi;
    private int fHe;
    private FrsNetModel<FrsFragment> fMY;
    private final FrsFragment fNY;
    private e.b fNa;
    private String fNb;
    private ArrayList<m> fOd;
    private FrsRequestData fOe;
    private final p fOf;
    private boolean fOg;
    private int fOh;
    private long fOi;
    private int fOj;
    private int fOk;
    private am fOl;
    private boolean fOm;
    private SparseArray<am> fOn;
    private y fOo;
    private ai fOp;
    private ArrayList<m> fOq;
    private boolean fOr;
    private String fOs;
    private int fOt;
    private int fOu;
    private boolean fOv;
    private String fOw;
    private final SparseArray<Boolean> fOx;
    private ai fOy;
    private long fdc;
    private long fdd;
    private long fde;
    private long fdf;
    private FrsViewData fuR;
    private String fvg;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean rw(int i) {
        return this.fOx.get(i, false).booleanValue();
    }

    public void D(int i, boolean z) {
        this.fOx.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, p pVar) {
        super(frsFragment.getPageContext());
        this.fvg = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.fOh = 0;
        this.mSource = null;
        this.fNb = null;
        this.fOi = 0L;
        this.fHe = 1;
        this.fOj = 0;
        this.fOk = 0;
        this.fOm = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.fOn = new SparseArray<>();
        this.cMi = 0L;
        this.fOr = false;
        this.fOt = -1;
        this.fOu = -1;
        this.fOw = null;
        this.fOx = new SparseArray<>();
        this.fOy = new ai() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ai
            public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
                FrsModelController.this.fOm = false;
                if (i == FrsModelController.this.fHe && FrsModelController.this.fOp != null) {
                    FrsModelController.this.fOl = apVar;
                    FrsModelController.this.b(i, i2, apVar);
                    ArrayList<m> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.fuR.setThreadList(arrayList2);
                    FrsModelController.this.fOp.a(i, i2, apVar, arrayList);
                }
            }
        };
        this.fdc = 0L;
        this.fdd = 0L;
        this.fde = 0L;
        this.fdf = 0L;
        if (pVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.fNY = frsFragment;
        this.fOf = pVar;
        M(this.fNY);
    }

    private void M(FrsFragment frsFragment) {
        this.fOo = new y();
        this.fOo.cKf = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.fOo));
        this.fOo.a(this.fOy);
    }

    public void aGH() {
        this.fMY.cancelLoadData();
    }

    public void K(Bundle bundle) {
        if (bundle != null) {
            this.fvg = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fOs = bundle.getString("yuelaou_locate");
            this.fOg = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.fOh = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.fOi = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.fNY.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.fvg)) {
            this.fvg = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.fOs)) {
            this.fOs = "";
        }
        this.mSource = this.mFrom;
        bpe();
        this.fuR = new FrsViewData();
        this.fOe.dX("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.fvg));
        this.fOe.dX("client_type", "2");
        if (this.fMY == null) {
            this.fMY = new FrsNetModel<>(this.fNY.getPageContext(), this.fOe);
        }
        this.fMY.a(this);
        this.fMY.setUniqueId(this.fNY.getPageContext().getUniqueId());
        if (this.fvg != null && this.fvg.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.fvg);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void bpe() {
        AccountData currentAccountObj;
        this.fOe = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            rx(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            rx(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            rx(com.baidu.tieba.frs.f.g.wx("1~" + str + this.fvg));
        }
        this.fOe.setSortType(getSortType());
        if (this.fOt == 5) {
            this.fOe.setIsGood(1);
        } else {
            this.fOe.setIsGood(0);
        }
    }

    public boolean bbL() {
        if (this.fHe != 1) {
            rt(1);
            return true;
        } else if (this.fMY.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fOe), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void E(int i, boolean z) {
        this.fNY.fvt = System.currentTimeMillis();
        if (this.fuR != null && this.fuR.getLikeFeedForumDataList() != null) {
            this.fuR.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fOe), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.fHe = c(this.fHe, frsRequestData);
        if (this.fHe == 1) {
            if (!this.fMY.isLoading()) {
                frsRequestData.setCallFrom(this.fOh);
                a(frsRequestData, i, z ? false : true);
                this.fOh = 0;
                return;
            }
            return;
        }
        if (this.fOl == null) {
            this.fOl = new am();
            this.fOl.pn = 1;
            this.fOl.forumName = this.fvg;
            if (this.fuR != null && this.fuR.getForum() != null) {
                this.fOl.forumId = this.fuR.getForum().getId();
            }
        }
        rt(i);
    }

    public void ru(int i) {
        if (this.fHe != 1) {
            rt(4);
        } else if (!this.fMY.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fOe), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.fNY.jF(z);
        this.fOf.qq(i);
        this.fMY.a(frsRequestData);
        this.mType = i;
        frsRequestData.DF(this.fNY.bkr() ? "1" : "2");
        if (this.fOv) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.rP(this.fOu)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.fOv = false;
        frsRequestData.setKw(this.fvg);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = ar.amO().isFrsShowBigImage() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.fNb);
        frsRequestData.setYuelaouLocate(this.fOs);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.toLong(x.axP(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.zJ(bpf());
        if (FrsFragment.fvu != 0) {
            frsRequestData.setCtime((int) FrsFragment.fvu);
        }
        if (FrsFragment.fvv != 0) {
            frsRequestData.setDataSize((int) FrsFragment.fvv);
        }
        if (FrsFragment.fvw != 0) {
            frsRequestData.setNetError(FrsFragment.fvw);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.dU(this.fOi);
        if (this.fOi != 0) {
            this.fOi = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.fOt, frsRequestData);
        b(i, frsRequestData);
        a(this.fvg, frsRequestData);
        if (!rw(this.fOt) && !this.fNY.fvh) {
            String e = com.baidu.tieba.tbadkCore.d.cnl().e("1~" + this.fvg, frsRequestData.getSortType(), frsRequestData.getIsGood(), this.fOe.getCategoryId());
            this.fOw = e;
            new a(this, true, e).execute(new Object[0]);
        }
        boN();
    }

    private int bpf() {
        return (this.fNY == null || !(this.fNY.mHeadLineDefaultNavTabId == -1 || this.fNY.mHeadLineDefaultNavTabId == this.fHe)) ? 0 : 1;
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
        rx(com.baidu.tieba.frs.f.g.rQ(lVar.getSortType()));
        D(com.baidu.tieba.frs.f.g.rQ(lVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.fHe = lVar.getFrsDefaultTabId();
        }
        this.fuR.receiveData(lVar);
        d(this.fuR);
        this.fOd = new ArrayList<>();
        if (frsRequestData != null) {
            this.fOe = frsRequestData;
            this.mPn = this.fOe.getPn();
            this.fvg = this.fOe.getKw();
            this.fNY.setForumName(this.fvg);
            this.fNY.setFrom(this.mFrom);
            this.fNY.setPn(this.mPn);
            this.fNY.setFlag(this.mFlag);
        }
        if (this.fuR.getThreadList() != null) {
            this.fOd.addAll(this.fuR.getThreadList());
        }
        if (this.fHe != 1 && this.isNetFirstLoad) {
            this.fOf.a(7, false, this.fNa);
        } else {
            this.fOf.a(this.mType, false, this.fNa);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.fOe)) {
            bpu();
        }
        this.isNetFirstLoad = false;
        if (lVar.getForum() != null && !TextUtils.isEmpty(lVar.getForum().getName()) && frsRequestData != null && r.cfL().cfF() != null) {
            r.cfL().cfF().f(lVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        com.baidu.tieba.frs.a.biW().jA(this.fHe == 301);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        e.b bVar = new e.b();
        bVar.fgr = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcSocketResponsedMessage.getError();
        bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        bVar.jgd = mvcSocketResponsedMessage.getDownSize();
        this.fNa = bVar;
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
        this.fNY.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.fOr) {
            this.fOr = true;
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
        bVar.fgr = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcHttpResponsedMessage.getError();
        bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        bVar.jgd = mvcHttpResponsedMessage.getDownSize();
        this.fNa = bVar;
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
        this.fNY.a(errorData);
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
        if (!this.fOr) {
            this.fOr = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bkj() {
        if (this.fuR != null && this.fuR.getForum() != null && this.fuR.getForum().getBannerListData() != null) {
            String lastIds = this.fuR.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fNb = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.awN().awO()) {
            this.cMi = System.currentTimeMillis() - this.fNY.beginTime;
            com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(i, z, responsedMessage, this.fNY.cLZ, this.fNY.createTime, this.fNY.cMh, false, this.cMi);
            this.fNY.createTime = 0L;
            this.fNY.cLZ = 0L;
            if (iVar != null) {
                iVar.awK();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.awN().awO()) {
            this.cMi = System.currentTimeMillis() - this.fNY.fvt;
            com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(1000, z, responsedMessage, this.fNY.cLZ, this.fNY.createTime, this.fNY.cMh, false, this.cMi);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.cMq = this.cMi;
                    iVar.fw(true);
                } else if (this.mType == 3) {
                    iVar.cMr = this.cMi;
                    iVar.fw(false);
                }
            }
        }
    }

    public FrsRequestData bpg() {
        return this.fOe;
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

    public FrsViewData boM() {
        return this.fuR;
    }

    public e.b bph() {
        return this.fNa;
    }

    private void boN() {
        this.fdc = System.currentTimeMillis();
        this.fMY.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.tieba.tbadkCore.l lVar) {
        this.isCacheFirstLoad = false;
        this.fuR.receiveData(lVar);
        d(this.fuR);
        this.fOd = new ArrayList<>();
        if (this.fuR.getThreadList() != null) {
            this.fOd.addAll(this.fuR.getThreadList());
        }
        this.fOf.c(lVar);
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
        private String fOC;
        private FrsModelController fOD;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.fOC = null;
            this.fOC = str;
            this.fOD = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.d.cnl().DD(this.fOC)) {
                if (!com.baidu.tieba.tbadkCore.d.cnl().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.fOC)) {
                    com.baidu.tieba.tbadkCore.d.cnl().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.l responseData = com.baidu.tieba.tbadkCore.d.cnl().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().agY(), true) && !responseData.getBookInfo().agY().equals("0") && responseData.getBookInfo().agZ() == 3 && (i = com.baidu.adp.lib.g.b.toInt(responseData.getBookInfo().agY(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.fOD != null && lVarArr != null) {
                this.fOD.g(lVarArr.length > 0 ? lVarArr[0] : null);
                this.fOD.D(this.fOD.fOt, true);
            }
        }
    }

    public long beL() {
        return this.fdf;
    }

    public long beM() {
        return this.fdd;
    }

    public long beN() {
        return this.fde;
    }

    public long beO() {
        return this.fdc;
    }

    public boolean isLoading() {
        return this.fMY.isLoading();
    }

    public int bpi() {
        return this.fOk;
    }

    private void bpj() {
        if (this.fOq == null) {
            this.fOq = new ArrayList<>();
        }
        if (this.fOq.size() == 0) {
            this.fOq.add(new u());
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, int i2, am amVar) {
        this.fHe = c(i, null);
        if (amVar == null && (amVar = bA(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.fOp != null) {
                ap apVar = new ap();
                apVar.hasMore = false;
                apVar.pn = 1;
                apVar.forumName = this.fvg;
                apVar.fzB = false;
                if (this.fuR != null && this.fuR.getForum() != null) {
                    apVar.forumId = this.fuR.getForum().getId();
                }
                bpj();
                this.fuR.setThreadList(this.fOq);
                this.fOp.a(i, i2, apVar, this.fOq);
            }
            amVar = new am();
            amVar.pn = -1;
        }
        if (this.fuR != null && this.fuR.getForum() != null) {
            amVar.forumId = this.fuR.getForum().getId();
        }
        amVar.forumName = this.fvg;
        if (w.blC().qI(1) != null && this.fHe == 1) {
            this.fOe.setCategoryId(i2);
        }
        this.fOj = i2;
        this.fOl = amVar;
        b(i, i2, amVar);
        rt(5);
    }

    @Override // com.baidu.tieba.frs.af
    public void a(ai aiVar) {
        this.fOp = aiVar;
        this.fOo.a(this.fOy);
    }

    private void rt(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.fOl != null) {
                    this.fOl.pn++;
                    break;
                }
                break;
            case 2:
                if (this.fOl != null) {
                    am amVar = this.fOl;
                    amVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.fOl != null) {
                    this.fOl.pn = -1;
                    break;
                }
                break;
        }
        if (this.fHe == 1) {
            if (this.fOk == this.fOj) {
                ArrayList<m> arrayList = new ArrayList<>();
                if (this.fOd != null) {
                    arrayList.addAll(this.fOd);
                }
                this.fuR.setThreadList(arrayList);
                if (this.fOp != null) {
                    this.fOp.a(this.fHe, this.fOj, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.fOk = this.fOj;
            return;
        }
        af qJ = this.fOo.qJ(this.fHe);
        if (qJ != null) {
            this.fOm = true;
            qJ.a(this.fHe, this.fOj, this.fOl);
            return;
        }
        if (this.fuR != null && this.fuR.getThreadList() != null) {
            this.fuR.getThreadList().clear();
        }
        this.fOp.a(this.fHe, this.fOj, null, null);
    }

    public boolean hasMore() {
        if ((this.fOl instanceof ap) && ((ap) this.fOl).errCode == 0) {
            return ((ap) this.fOl).hasMore;
        }
        return true;
    }

    private int bz(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, am amVar) {
        this.fOn.put(bz(i, i2), amVar);
    }

    public am bA(int i, int i2) {
        return this.fOn.get(bz(i, i2));
    }

    @Override // com.baidu.tieba.frs.af
    public void init() {
        this.fOo.init();
    }

    @Override // com.baidu.tieba.frs.af
    public void aMM() {
        this.fOo.destory();
        this.fOo.clear();
    }

    public int bpk() {
        return this.fHe;
    }

    public boolean bpl() {
        return 1 == this.fHe;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(ak akVar) {
        if (akVar != null && !StringUtils.isNull(akVar.getId()) && !v.isEmpty(this.fOd)) {
            if (this.fHe == 1) {
                this.fuR.addMyNewThread(akVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<m> it = this.fOd.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if ((next instanceof bg) && akVar.getId().equals(((bg) next).cbq.getId())) {
                    return;
                }
            }
            this.fOd.add(topThreadSize, akVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.fOd == null || this.fOd.size() <= 0) {
            return 0;
        }
        Iterator<m> it = this.fOd.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                m next = it.next();
                if (!(next instanceof bg)) {
                    i = i2;
                } else if (((bg) next).cbq.aiB() != 0) {
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

    public boolean bpm() {
        return this.fOm;
    }

    public void bpn() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.fOk == 0) {
            mVar.qB(this.fOt);
        }
        if (this.fuR.getThreadList() != null) {
            this.fuR.getThreadList().clear();
            this.fuR.getThreadList().add(mVar);
        }
        if (this.fOd != null) {
            this.fOd.clear();
            this.fOd.add(mVar);
        }
    }

    public ArrayList<m> bpo() {
        return this.fOd;
    }

    public void rx(int i) {
        AccountData currentAccountObj;
        this.fOt = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
        }
        com.baidu.tieba.frs.f.g.au("1~" + str + this.fvg, this.fOt);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cpq();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cpr();
        }
    }

    public void ry(int i) {
        this.fOu = i;
    }

    public void kz(boolean z) {
        this.fOv = z;
    }

    public int bpp() {
        return this.fOt;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.rP(this.fOt);
    }

    public boolean bpq() {
        return this.fOg;
    }

    public boolean bpr() {
        return this.fOt == 5;
    }

    public boolean bps() {
        return this.fOe != null && this.fOe.getLoadType() == 1;
    }

    public boolean bpt() {
        return this.fOt == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.fNY.bjG() != null) {
            return this.fNY.bjG().a(this.fOt, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bh.cbU.get() && r.cfL().cfF() != null) {
            int as = r.cfL().cfF().as(str, false);
            int at = r.cfL().cfF().at(str, false);
            if (frsRequestData.getLoadType() == 1) {
                as++;
            } else if (frsRequestData.getLoadType() == 2) {
                at++;
            }
            frsRequestData.setRefreshCount(as);
            frsRequestData.setLoadCount(at);
        }
    }

    public void bpu() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.fuR != null && this.fuR.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.toLong(this.fuR.getForum().getId(), 0L));
        }
        this.fNY.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void wo(final String str) {
        z.a(new com.baidu.tbadk.util.y<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cnl().dU(FrsModelController.this.fOw, str);
                return null;
            }
        }, null);
    }

    public void wp(final String str) {
        z.a(new com.baidu.tbadk.util.y<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cnl().dV(FrsModelController.this.fOw, str);
                return null;
            }
        }, null);
    }

    public void wq(final String str) {
        z.a(new com.baidu.tbadk.util.y<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.y
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cnl().dW(FrsModelController.this.fOw, str);
                return null;
            }
        }, null);
    }
}
