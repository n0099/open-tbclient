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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
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
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.j>, af {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long czW;
    private int dmx;
    private long eYA;
    private long eYx;
    private long eYy;
    private long eYz;
    private FrsNetModel<FrsFragment> fLc;
    private e.b fLe;
    private String fLf;
    private final SparseArray<Boolean> fMA;
    private ai fMB;
    private final FrsFragment fMb;
    private ArrayList<m> fMg;
    private FrsRequestData fMh;
    private final n fMi;
    private boolean fMj;
    private int fMk;
    private long fMl;
    private int fMm;
    private int fMn;
    private am fMo;
    private boolean fMp;
    private SparseArray<am> fMq;
    private y fMr;
    private ai fMs;
    private ArrayList<m> fMt;
    private boolean fMu;
    private String fMv;
    private int fMw;
    private int fMx;
    private boolean fMy;
    private String fMz;
    private String ftH;
    private FrsViewData fts;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean sx(int i) {
        return this.fMA.get(i, false).booleanValue();
    }

    public void E(int i, boolean z) {
        this.fMA.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.ftH = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.fMk = 0;
        this.mSource = null;
        this.fLf = null;
        this.fMl = 0L;
        this.dmx = 1;
        this.fMm = 0;
        this.fMn = 0;
        this.fMp = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.fMq = new SparseArray<>();
        this.czW = 0L;
        this.fMu = false;
        this.fMw = -1;
        this.fMx = -1;
        this.fMz = null;
        this.fMA = new SparseArray<>();
        this.fMB = new ai() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ai
            public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
                FrsModelController.this.fMp = false;
                if (i == FrsModelController.this.dmx && FrsModelController.this.fMs != null) {
                    FrsModelController.this.fMo = apVar;
                    FrsModelController.this.b(i, i2, apVar);
                    ArrayList<m> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.fts.setThreadList(arrayList2);
                    FrsModelController.this.fMs.a(i, i2, apVar, arrayList);
                }
            }
        };
        this.eYx = 0L;
        this.eYy = 0L;
        this.eYz = 0L;
        this.eYA = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.fMb = frsFragment;
        this.fMi = nVar;
        M(this.fMb);
    }

    private void M(FrsFragment frsFragment) {
        this.fMr = new y();
        this.fMr.cxx = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.fMr));
        this.fMr.a(this.fMB);
    }

    public void aFO() {
        this.fLc.cancelLoadData();
    }

    public void K(Bundle bundle) {
        if (bundle != null) {
            this.ftH = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fMv = bundle.getString("yuelaou_locate");
            this.fMj = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.fMk = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.fMl = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.fMb.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.ftH)) {
            this.ftH = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.fMv)) {
            this.fMv = "";
        }
        this.mSource = this.mFrom;
        brc();
        this.fts = new FrsViewData();
        this.fMh.ek("forum_name", com.baidu.adp.lib.util.k.bi(this.ftH));
        this.fMh.ek("client_type", "2");
        if (this.fLc == null) {
            this.fLc = new FrsNetModel<>(this.fMb.getPageContext(), this.fMh);
        }
        this.fLc.a(this);
        this.fLc.setUniqueId(this.fMb.getPageContext().getUniqueId());
        if (this.ftH != null && this.ftH.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.ftH);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void brc() {
        AccountData currentAccountObj;
        this.fMh = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            sy(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            sy(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            sy(com.baidu.tieba.frs.f.g.xF("1~" + str + this.ftH));
        }
        this.fMh.setSortType(getSortType());
        if (this.fMw == 5) {
            this.fMh.setIsGood(1);
        } else {
            this.fMh.setIsGood(0);
        }
    }

    public boolean bba() {
        if (this.dmx != 1) {
            su(1);
            return true;
        } else if (this.fLc.pP()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fMh), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void F(int i, boolean z) {
        this.fMb.ftU = System.currentTimeMillis();
        if (this.fts != null && this.fts.getLikeFeedForumDataList() != null) {
            this.fts.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fMh), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.dmx = c(this.dmx, frsRequestData);
        if (this.dmx == 1) {
            if (!this.fLc.pP()) {
                frsRequestData.setCallFrom(this.fMk);
                a(frsRequestData, i, z ? false : true);
                this.fMk = 0;
                return;
            }
            return;
        }
        if (this.fMo == null) {
            this.fMo = new am();
            this.fMo.pn = 1;
            this.fMo.forumName = this.ftH;
            if (this.fts != null && this.fts.getForum() != null) {
                this.fMo.forumId = this.fts.getForum().getId();
            }
        }
        su(i);
    }

    public void sv(int i) {
        if (this.dmx != 1) {
            su(4);
        } else if (!this.fLc.pP()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fMh), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.fMb.jO(z);
        this.fMi.rs(i);
        this.fLc.a(frsRequestData);
        this.mType = i;
        frsRequestData.Ez(this.fMb.bmq() ? "1" : "2");
        if (this.fMy) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.sP(this.fMx)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.fMy = false;
        frsRequestData.setKw(this.ftH);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        float ai = com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
        int i2 = as.ajo().ajq() ? 2 : 1;
        frsRequestData.setScrW(af);
        frsRequestData.setScrH(ah);
        frsRequestData.setScrDip(ai);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.fLf);
        frsRequestData.setYuelaouLocate(this.fMv);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(com.baidu.tbadk.util.y.awy(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.ftV != 0) {
            frsRequestData.setCtime((int) FrsFragment.ftV);
        }
        if (FrsFragment.ftW != 0) {
            frsRequestData.setDataSize((int) FrsFragment.ftW);
        }
        if (FrsFragment.ftX != 0) {
            frsRequestData.setNetError(FrsFragment.ftX);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.ex(this.fMl);
        if (this.fMl != 0) {
            this.fMl = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.fMw, frsRequestData);
        b(i, frsRequestData);
        a(this.ftH, frsRequestData);
        if (!sx(this.fMw) && !this.fMb.ftI) {
            String c = com.baidu.tieba.tbadkCore.d.cop().c("1~" + this.ftH, frsRequestData.getSortType(), frsRequestData.getIsGood(), this.fMh.getCategoryId());
            this.fMz = c;
            new a(this, true, c).execute(new Object[0]);
        }
        bqL();
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
        if (jVar == null || jVar.getForum() == null || (aq.isEmpty(jVar.getForum().getName()) && 340001 != jVar.mErrorNo)) {
            return false;
        }
        sy(com.baidu.tieba.frs.f.g.sQ(jVar.getSortType()));
        E(com.baidu.tieba.frs.f.g.sQ(jVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.dmx = jVar.getFrsDefaultTabId();
        }
        this.fts.receiveData(jVar);
        d(this.fts);
        this.fMg = new ArrayList<>();
        if (frsRequestData != null) {
            this.fMh = frsRequestData;
            this.mPn = this.fMh.getPn();
            this.ftH = this.fMh.getKw();
            this.fMb.setForumName(this.ftH);
            this.fMb.setFrom(this.mFrom);
            this.fMb.setPn(this.mPn);
            this.fMb.setFlag(this.mFlag);
        }
        if (this.fts.getThreadList() != null) {
            this.fMg.addAll(this.fts.getThreadList());
        }
        if (this.dmx != 1 && this.isNetFirstLoad) {
            this.fMi.a(7, false, this.fLe);
        } else {
            this.fMi.a(this.mType, false, this.fLe);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.fMh)) {
            brr();
        }
        this.isNetFirstLoad = false;
        if (jVar.getForum() != null && !TextUtils.isEmpty(jVar.getForum().getName()) && frsRequestData != null && r.chD().chx() != null) {
            r.chD().chx().g(jVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        com.baidu.tieba.frs.a.bkY().jJ(this.dmx == 301);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.j jVar;
        e.b bVar = new e.b();
        bVar.fbG = com.baidu.adp.lib.util.j.kc() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcSocketResponsedMessage.getError();
        bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        bVar.jcN = mvcSocketResponsedMessage.getDownSize();
        this.fLe = bVar;
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
        this.fMb.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.fMu) {
            this.fMu = true;
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
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.j> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.j jVar;
        e.b bVar = new e.b();
        bVar.fbG = com.baidu.adp.lib.util.j.kc() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcHttpResponsedMessage.getError();
        bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        bVar.jcN = mvcHttpResponsedMessage.getDownSize();
        this.fLe = bVar;
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
        this.fMb.a(errorData);
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
            com.baidu.tbadk.core.e.a.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
        if (!this.fMu) {
            this.fMu = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bmi() {
        if (this.fts != null && this.fts.getForum() != null && this.fts.getForum().getBannerListData() != null) {
            String lastIds = this.fts.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fLf = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.avt().avu()) {
            this.czW = System.currentTimeMillis() - this.fMb.beginTime;
            com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(i, z, responsedMessage, this.fMb.czN, this.fMb.createTime, this.fMb.czV, false, this.czW);
            this.fMb.createTime = 0L;
            this.fMb.czN = 0L;
            if (iVar != null) {
                iVar.avq();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.avt().avu()) {
            this.czW = System.currentTimeMillis() - this.fMb.ftU;
            com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(1000, z, responsedMessage, this.fMb.czN, this.fMb.createTime, this.fMb.czV, false, this.czW);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.cAe = this.czW;
                    iVar.fE(true);
                } else if (this.mType == 3) {
                    iVar.cAf = this.czW;
                    iVar.fE(false);
                }
            }
        }
    }

    public FrsRequestData brd() {
        return this.fMh;
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

    public FrsViewData bqK() {
        return this.fts;
    }

    public e.b bre() {
        return this.fLe;
    }

    private void bqL() {
        this.eYx = System.currentTimeMillis();
        this.fLc.auD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.tbadkCore.j jVar) {
        this.isCacheFirstLoad = false;
        this.fts.receiveData(jVar);
        d(this.fts);
        this.fMg = new ArrayList<>();
        if (this.fts.getThreadList() != null) {
            this.fMg.addAll(this.fts.getThreadList());
        }
        this.fMi.b(jVar);
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
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.j, Void> {
        private String fMF;
        private FrsModelController fMG;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.fMF = null;
            this.fMF = str;
            this.fMG = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.d.cop().Ex(this.fMF)) {
                if (!com.baidu.tieba.tbadkCore.d.cop().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.fMF)) {
                    com.baidu.tieba.tbadkCore.d.cop().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.j responseData = com.baidu.tieba.tbadkCore.d.cop().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().acN(), true) && !responseData.getBookInfo().acN().equals("0") && responseData.getBookInfo().acO() == 3 && (f = com.baidu.adp.lib.g.b.f(responseData.getBookInfo().acN(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(f))) != null) {
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
            if (this.fMG != null && jVarArr != null) {
                this.fMG.f(jVarArr.length > 0 ? jVarArr[0] : null);
                this.fMG.E(this.fMG.fMw, true);
            }
        }
    }

    public long bgj() {
        return this.eYA;
    }

    public long bgk() {
        return this.eYy;
    }

    public long bgl() {
        return this.eYz;
    }

    public long bgm() {
        return this.eYx;
    }

    public boolean pP() {
        return this.fLc.pP();
    }

    public int brf() {
        return this.fMn;
    }

    private void brg() {
        if (this.fMt == null) {
            this.fMt = new ArrayList<>();
        }
        if (this.fMt.size() == 0) {
            this.fMt.add(new u());
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, int i2, am amVar) {
        this.dmx = c(i, null);
        if (amVar == null && (amVar = bE(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.kt() && this.fMs != null) {
                ap apVar = new ap();
                apVar.hasMore = false;
                apVar.pn = 1;
                apVar.forumName = this.ftH;
                apVar.fyb = false;
                if (this.fts != null && this.fts.getForum() != null) {
                    apVar.forumId = this.fts.getForum().getId();
                }
                brg();
                this.fts.setThreadList(this.fMt);
                this.fMs.a(i, i2, apVar, this.fMt);
            }
            amVar = new am();
            amVar.pn = -1;
        }
        if (this.fts != null && this.fts.getForum() != null) {
            amVar.forumId = this.fts.getForum().getId();
        }
        amVar.forumName = this.ftH;
        if (w.bnD().rK(1) != null && this.dmx == 1) {
            this.fMh.setCategoryId(i2);
        }
        this.fMm = i2;
        this.fMo = amVar;
        b(i, i2, amVar);
        su(5);
    }

    @Override // com.baidu.tieba.frs.af
    public void a(ai aiVar) {
        this.fMs = aiVar;
        this.fMr.a(this.fMB);
    }

    private void su(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.fMo != null) {
                    this.fMo.pn++;
                    break;
                }
                break;
            case 2:
                if (this.fMo != null) {
                    am amVar = this.fMo;
                    amVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.fMo != null) {
                    this.fMo.pn = -1;
                    break;
                }
                break;
        }
        if (this.dmx == 1) {
            if (this.fMn == this.fMm) {
                ArrayList<m> arrayList = new ArrayList<>();
                if (this.fMg != null) {
                    arrayList.addAll(this.fMg);
                }
                this.fts.setThreadList(arrayList);
                if (this.fMs != null) {
                    this.fMs.a(this.dmx, this.fMm, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.fMn = this.fMm;
            return;
        }
        af rL = this.fMr.rL(this.dmx);
        if (rL != null) {
            this.fMp = true;
            rL.a(this.dmx, this.fMm, this.fMo);
            return;
        }
        if (this.fts != null && this.fts.getThreadList() != null) {
            this.fts.getThreadList().clear();
        }
        this.fMs.a(this.dmx, this.fMm, null, null);
    }

    public boolean hasMore() {
        if ((this.fMo instanceof ap) && ((ap) this.fMo).errCode == 0) {
            return ((ap) this.fMo).hasMore;
        }
        return true;
    }

    private int bD(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, am amVar) {
        this.fMq.put(bD(i, i2), amVar);
    }

    public am bE(int i, int i2) {
        return this.fMq.get(bD(i, i2));
    }

    @Override // com.baidu.tieba.frs.af
    public void init() {
        this.fMr.init();
    }

    @Override // com.baidu.tieba.frs.af
    public void aLx() {
        this.fMr.destory();
        this.fMr.clear();
    }

    public int brh() {
        return this.dmx;
    }

    public boolean bri() {
        return 1 == this.dmx;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(ak akVar) {
        if (akVar != null && !StringUtils.isNull(akVar.getId()) && !v.aa(this.fMg)) {
            if (this.dmx == 1) {
                this.fts.addMyNewThread(akVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<m> it = this.fMg.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if ((next instanceof bf) && akVar.getId().equals(((bf) next).threadData.getId())) {
                    return;
                }
            }
            this.fMg.add(topThreadSize, akVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.fMg == null || this.fMg.size() <= 0) {
            return 0;
        }
        Iterator<m> it = this.fMg.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                m next = it.next();
                if (!(next instanceof bf)) {
                    i = i2;
                } else if (((bf) next).threadData.aes() != 0) {
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

    public boolean brj() {
        return this.fMp;
    }

    public void brk() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.fMn == 0) {
            mVar.rD(this.fMw);
        }
        if (this.fts.getThreadList() != null) {
            this.fts.getThreadList().clear();
            this.fts.getThreadList().add(mVar);
        }
        if (this.fMg != null) {
            this.fMg.clear();
            this.fMg.add(mVar);
        }
    }

    public ArrayList<m> brl() {
        return this.fMg;
    }

    public void sy(int i) {
        AccountData currentAccountObj;
        this.fMw = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
        }
        com.baidu.tieba.frs.f.g.ax("1~" + str + this.ftH, this.fMw);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cqn();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cqo();
        }
    }

    public void sz(int i) {
        this.fMx = i;
    }

    public void kJ(boolean z) {
        this.fMy = z;
    }

    public int brm() {
        return this.fMw;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.sP(this.fMw);
    }

    public boolean brn() {
        return this.fMj;
    }

    public boolean bro() {
        return this.fMw == 5;
    }

    public boolean brp() {
        return this.fMh != null && this.fMh.getLoadType() == 1;
    }

    public boolean brq() {
        return this.fMw == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.fMb.blI() != null) {
            return this.fMb.blI().a(this.fMw, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bg.bJJ.get() && r.chD().chx() != null) {
            int ax = r.chD().chx().ax(str, false);
            int ay = r.chD().chx().ay(str, false);
            if (frsRequestData.getLoadType() == 1) {
                ax++;
            } else if (frsRequestData.getLoadType() == 2) {
                ay++;
            }
            frsRequestData.setRefreshCount(ax);
            frsRequestData.setLoadCount(ay);
        }
    }

    public void brr() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.fts != null && this.fts.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.fts.getForum().getId(), 0L));
        }
        this.fMb.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void xw(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cop().eh(FrsModelController.this.fMz, str);
                return null;
            }
        }, null);
    }

    public void xx(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cop().ei(FrsModelController.this.fMz, str);
                return null;
            }
        }, null);
    }

    public void xy(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.cop().ej(FrsModelController.this.fMz, str);
                return null;
            }
        }, null);
    }
}
