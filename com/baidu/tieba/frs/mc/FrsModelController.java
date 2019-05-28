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
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.j>, af {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long cyF;
    private int dkP;
    private long eTw;
    private long eTx;
    private long eTy;
    private long eTz;
    private FrsNetModel<FrsFragment> fGd;
    private e.b fGf;
    private String fGg;
    private ai fHA;
    private final FrsFragment fHa;
    private ArrayList<m> fHf;
    private FrsRequestData fHg;
    private final n fHh;
    private boolean fHi;
    private int fHj;
    private long fHk;
    private int fHl;
    private int fHm;
    private am fHn;
    private boolean fHo;
    private SparseArray<am> fHp;
    private y fHq;
    private ai fHr;
    private ArrayList<m> fHs;
    private boolean fHt;
    private String fHu;
    private int fHv;
    private int fHw;
    private boolean fHx;
    private String fHy;
    private final SparseArray<Boolean> fHz;
    private String foI;
    private FrsViewData fot;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean sf(int i) {
        return this.fHz.get(i, false).booleanValue();
    }

    public void C(int i, boolean z) {
        this.fHz.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.foI = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.fHj = 0;
        this.mSource = null;
        this.fGg = null;
        this.fHk = 0L;
        this.dkP = 1;
        this.fHl = 0;
        this.fHm = 0;
        this.fHo = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.fHp = new SparseArray<>();
        this.cyF = 0L;
        this.fHt = false;
        this.fHv = -1;
        this.fHw = -1;
        this.fHy = null;
        this.fHz = new SparseArray<>();
        this.fHA = new ai() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ai
            public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
                FrsModelController.this.fHo = false;
                if (i == FrsModelController.this.dkP && FrsModelController.this.fHr != null) {
                    FrsModelController.this.fHn = apVar;
                    FrsModelController.this.b(i, i2, apVar);
                    ArrayList<m> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.fot.setThreadList(arrayList2);
                    FrsModelController.this.fHr.a(i, i2, apVar, arrayList);
                }
            }
        };
        this.eTw = 0L;
        this.eTx = 0L;
        this.eTy = 0L;
        this.eTz = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.fHa = frsFragment;
        this.fHh = nVar;
        M(this.fHa);
    }

    private void M(FrsFragment frsFragment) {
        this.fHq = new y();
        this.fHq.cwh = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.fHq));
        this.fHq.a(this.fHA);
    }

    public void onActivityDestroy() {
        this.fGd.cancelLoadData();
    }

    public void K(Bundle bundle) {
        if (bundle != null) {
            this.foI = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fHu = bundle.getString("yuelaou_locate");
            this.fHi = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.fHj = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.fHk = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.fHa.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.foI)) {
            this.foI = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.fHu)) {
            this.fHu = "";
        }
        this.mSource = this.mFrom;
        boZ();
        this.fot = new FrsViewData();
        this.fHg.ej("forum_name", com.baidu.adp.lib.util.k.bh(this.foI));
        this.fHg.ej("client_type", "2");
        if (this.fGd == null) {
            this.fGd = new FrsNetModel<>(this.fHa.getPageContext(), this.fHg);
        }
        this.fGd.a(this);
        this.fGd.setUniqueId(this.fHa.getPageContext().getUniqueId());
        if (this.foI != null && this.foI.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.foI);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void boZ() {
        AccountData currentAccountObj;
        this.fHg = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            sg(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            sg(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            sg(com.baidu.tieba.frs.f.g.wY("1~" + str + this.foI));
        }
        this.fHg.setSortType(getSortType());
        if (this.fHv == 5) {
            this.fHg.setIsGood(1);
        } else {
            this.fHg.setIsGood(0);
        }
    }

    public boolean aZb() {
        if (this.dkP != 1) {
            sc(1);
            return true;
        } else if (this.fGd.pu()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fHg), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void D(int i, boolean z) {
        this.fHa.foV = System.currentTimeMillis();
        if (this.fot != null && this.fot.getLikeFeedForumDataList() != null) {
            this.fot.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fHg), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.dkP = c(this.dkP, frsRequestData);
        if (this.dkP == 1) {
            if (!this.fGd.pu()) {
                frsRequestData.setCallFrom(this.fHj);
                a(frsRequestData, i, z ? false : true);
                this.fHj = 0;
                return;
            }
            return;
        }
        if (this.fHn == null) {
            this.fHn = new am();
            this.fHn.pn = 1;
            this.fHn.forumName = this.foI;
            if (this.fot != null && this.fot.getForum() != null) {
                this.fHn.forumId = this.fot.getForum().getId();
            }
        }
        sc(i);
    }

    public void sd(int i) {
        if (this.dkP != 1) {
            sc(4);
        } else if (!this.fGd.pu()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fHg), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.fHa.jE(z);
        this.fHh.ra(i);
        this.fGd.a(frsRequestData);
        this.mType = i;
        frsRequestData.DK(this.fHa.bko() ? "1" : "2");
        if (this.fHx) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.sx(this.fHw)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.fHx = false;
        frsRequestData.setKw(this.foI);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int af = com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst());
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        float ai = com.baidu.adp.lib.util.l.ai(TbadkCoreApplication.getInst());
        int i2 = ar.ail().ain() ? 2 : 1;
        frsRequestData.setScrW(af);
        frsRequestData.setScrH(ah);
        frsRequestData.setScrDip(ai);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.fGg);
        frsRequestData.setYuelaouLocate(this.fHu);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(com.baidu.tbadk.util.y.avp(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.foW != 0) {
            frsRequestData.setCtime((int) FrsFragment.foW);
        }
        if (FrsFragment.foX != 0) {
            frsRequestData.setDataSize((int) FrsFragment.foX);
        }
        if (FrsFragment.foY != 0) {
            frsRequestData.setNetError(FrsFragment.foY);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.en(this.fHk);
        if (this.fHk != 0) {
            this.fHk = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.fHv, frsRequestData);
        b(i, frsRequestData);
        a(this.foI, frsRequestData);
        if (!sf(this.fHv) && !this.fHa.foJ) {
            String c = com.baidu.tieba.tbadkCore.d.clw().c("1~" + this.foI, frsRequestData.getSortType(), frsRequestData.getIsGood(), this.fHg.getCategoryId());
            this.fHy = c;
            new a(this, true, c).execute(new Object[0]);
        }
        boJ();
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
        sg(com.baidu.tieba.frs.f.g.sy(jVar.getSortType()));
        C(com.baidu.tieba.frs.f.g.sy(jVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.dkP = jVar.getFrsDefaultTabId();
        }
        this.fot.receiveData(jVar);
        d(this.fot);
        this.fHf = new ArrayList<>();
        if (frsRequestData != null) {
            this.fHg = frsRequestData;
            this.mPn = this.fHg.getPn();
            this.foI = this.fHg.getKw();
            this.fHa.setForumName(this.foI);
            this.fHa.setFrom(this.mFrom);
            this.fHa.setPn(this.mPn);
            this.fHa.setFlag(this.mFlag);
        }
        if (this.fot.getThreadList() != null) {
            this.fHf.addAll(this.fot.getThreadList());
        }
        if (this.dkP != 1 && this.isNetFirstLoad) {
            this.fHh.a(7, false, this.fGf);
        } else {
            this.fHh.a(this.mType, false, this.fGf);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.fHg)) {
            bpo();
        }
        this.isNetFirstLoad = false;
        if (jVar.getForum() != null && !TextUtils.isEmpty(jVar.getForum().getName()) && frsRequestData != null && r.ceL().ceF() != null) {
            r.ceL().ceF().g(jVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        com.baidu.tieba.frs.a.biW().jz(this.dkP == 301);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.j jVar;
        e.b bVar = new e.b();
        bVar.eWF = com.baidu.adp.lib.util.j.jS() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcSocketResponsedMessage.getError();
        bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        bVar.iWr = mvcSocketResponsedMessage.getDownSize();
        this.fGf = bVar;
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
        this.fHa.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.fHt) {
            this.fHt = true;
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
        bVar.eWF = com.baidu.adp.lib.util.j.jS() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcHttpResponsedMessage.getError();
        bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        bVar.iWr = mvcHttpResponsedMessage.getDownSize();
        this.fGf = bVar;
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
        this.fHa.a(errorData);
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
        if (!this.fHt) {
            this.fHt = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bkg() {
        if (this.fot != null && this.fot.getForum() != null && this.fot.getForum().getBannerListData() != null) {
            String lastIds = this.fot.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fGg = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.auk().aul()) {
            this.cyF = System.currentTimeMillis() - this.fHa.beginTime;
            com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(i, z, responsedMessage, this.fHa.cyw, this.fHa.createTime, this.fHa.cyE, false, this.cyF);
            this.fHa.createTime = 0L;
            this.fHa.cyw = 0L;
            if (iVar != null) {
                iVar.auh();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.auk().aul()) {
            this.cyF = System.currentTimeMillis() - this.fHa.foV;
            com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(1000, z, responsedMessage, this.fHa.cyw, this.fHa.createTime, this.fHa.cyE, false, this.cyF);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.cyN = this.cyF;
                    iVar.fA(true);
                } else if (this.mType == 3) {
                    iVar.cyO = this.cyF;
                    iVar.fA(false);
                }
            }
        }
    }

    public FrsRequestData bpa() {
        return this.fHg;
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

    public FrsViewData boI() {
        return this.fot;
    }

    public e.b bpb() {
        return this.fGf;
    }

    private void boJ() {
        this.eTw = System.currentTimeMillis();
        this.fGd.atv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.tbadkCore.j jVar) {
        this.isCacheFirstLoad = false;
        this.fot.receiveData(jVar);
        d(this.fot);
        this.fHf = new ArrayList<>();
        if (this.fot.getThreadList() != null) {
            this.fHf.addAll(this.fot.getThreadList());
        }
        this.fHh.b(jVar);
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
        private String fHE;
        private FrsModelController fHF;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.fHE = null;
            this.fHE = str;
            this.fHF = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.d.clw().DI(this.fHE)) {
                if (!com.baidu.tieba.tbadkCore.d.clw().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.fHE)) {
                    com.baidu.tieba.tbadkCore.d.clw().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.j responseData = com.baidu.tieba.tbadkCore.d.clw().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().abL(), true) && !responseData.getBookInfo().abL().equals("0") && responseData.getBookInfo().abM() == 3 && (f = com.baidu.adp.lib.g.b.f(responseData.getBookInfo().abL(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(f))) != null) {
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
            if (this.fHF != null && jVarArr != null) {
                this.fHF.f(jVarArr.length > 0 ? jVarArr[0] : null);
                this.fHF.C(this.fHF.fHv, true);
            }
        }
    }

    public long beg() {
        return this.eTz;
    }

    public long beh() {
        return this.eTx;
    }

    public long bei() {
        return this.eTy;
    }

    public long bej() {
        return this.eTw;
    }

    public boolean pu() {
        return this.fGd.pu();
    }

    public int bpc() {
        return this.fHm;
    }

    private void bpd() {
        if (this.fHs == null) {
            this.fHs = new ArrayList<>();
        }
        if (this.fHs.size() == 0) {
            this.fHs.add(new u());
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, int i2, am amVar) {
        this.dkP = c(i, null);
        if (amVar == null && (amVar = bz(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.ki() && this.fHr != null) {
                ap apVar = new ap();
                apVar.hasMore = false;
                apVar.pn = 1;
                apVar.forumName = this.foI;
                apVar.ftf = false;
                if (this.fot != null && this.fot.getForum() != null) {
                    apVar.forumId = this.fot.getForum().getId();
                }
                bpd();
                this.fot.setThreadList(this.fHs);
                this.fHr.a(i, i2, apVar, this.fHs);
            }
            amVar = new am();
            amVar.pn = -1;
        }
        if (this.fot != null && this.fot.getForum() != null) {
            amVar.forumId = this.fot.getForum().getId();
        }
        amVar.forumName = this.foI;
        if (w.blC().rs(1) != null && this.dkP == 1) {
            this.fHg.setCategoryId(i2);
        }
        this.fHl = i2;
        this.fHn = amVar;
        b(i, i2, amVar);
        sc(5);
    }

    @Override // com.baidu.tieba.frs.af
    public void a(ai aiVar) {
        this.fHr = aiVar;
        this.fHq.a(this.fHA);
    }

    private void sc(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.fHn != null) {
                    this.fHn.pn++;
                    break;
                }
                break;
            case 2:
                if (this.fHn != null) {
                    am amVar = this.fHn;
                    amVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.fHn != null) {
                    this.fHn.pn = -1;
                    break;
                }
                break;
        }
        if (this.dkP == 1) {
            if (this.fHm == this.fHl) {
                ArrayList<m> arrayList = new ArrayList<>();
                if (this.fHf != null) {
                    arrayList.addAll(this.fHf);
                }
                this.fot.setThreadList(arrayList);
                if (this.fHr != null) {
                    this.fHr.a(this.dkP, this.fHl, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.fHm = this.fHl;
            return;
        }
        af rt = this.fHq.rt(this.dkP);
        if (rt != null) {
            this.fHo = true;
            rt.a(this.dkP, this.fHl, this.fHn);
            return;
        }
        if (this.fot != null && this.fot.getThreadList() != null) {
            this.fot.getThreadList().clear();
        }
        this.fHr.a(this.dkP, this.fHl, null, null);
    }

    public boolean hasMore() {
        if ((this.fHn instanceof ap) && ((ap) this.fHn).errCode == 0) {
            return ((ap) this.fHn).hasMore;
        }
        return true;
    }

    private int by(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, am amVar) {
        this.fHp.put(by(i, i2), amVar);
    }

    public am bz(int i, int i2) {
        return this.fHp.get(by(i, i2));
    }

    @Override // com.baidu.tieba.frs.af
    public void init() {
        this.fHq.init();
    }

    @Override // com.baidu.tieba.frs.af
    public void aJS() {
        this.fHq.destory();
        this.fHq.clear();
    }

    public int bpe() {
        return this.dkP;
    }

    public boolean bpf() {
        return 1 == this.dkP;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(ak akVar) {
        if (akVar != null && !StringUtils.isNull(akVar.getId()) && !v.aa(this.fHf)) {
            if (this.dkP == 1) {
                this.fot.addMyNewThread(akVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<m> it = this.fHf.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if ((next instanceof bf) && akVar.getId().equals(((bf) next).threadData.getId())) {
                    return;
                }
            }
            this.fHf.add(topThreadSize, akVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.fHf == null || this.fHf.size() <= 0) {
            return 0;
        }
        Iterator<m> it = this.fHf.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                m next = it.next();
                if (!(next instanceof bf)) {
                    i = i2;
                } else if (((bf) next).threadData.adq() != 0) {
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

    public boolean bpg() {
        return this.fHo;
    }

    public void bph() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.fHm == 0) {
            mVar.rl(this.fHv);
        }
        if (this.fot.getThreadList() != null) {
            this.fot.getThreadList().clear();
            this.fot.getThreadList().add(mVar);
        }
        if (this.fHf != null) {
            this.fHf.clear();
            this.fHf.add(mVar);
        }
    }

    public ArrayList<m> bpi() {
        return this.fHf;
    }

    public void sg(int i) {
        AccountData currentAccountObj;
        this.fHv = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
        }
        com.baidu.tieba.frs.f.g.aw("1~" + str + this.foI, this.fHv);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cnt();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cnu();
        }
    }

    public void sh(int i) {
        this.fHw = i;
    }

    public void ky(boolean z) {
        this.fHx = z;
    }

    public int bpj() {
        return this.fHv;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.sx(this.fHv);
    }

    public boolean bpk() {
        return this.fHi;
    }

    public boolean bpl() {
        return this.fHv == 5;
    }

    public boolean bpm() {
        return this.fHg != null && this.fHg.getLoadType() == 1;
    }

    public boolean bpn() {
        return this.fHv == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.fHa.bjG() != null) {
            return this.fHa.bjG().a(this.fHv, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bg.bII.get() && r.ceL().ceF() != null) {
            int at = r.ceL().ceF().at(str, false);
            int au = r.ceL().ceF().au(str, false);
            if (frsRequestData.getLoadType() == 1) {
                at++;
            } else if (frsRequestData.getLoadType() == 2) {
                au++;
            }
            frsRequestData.setRefreshCount(at);
            frsRequestData.setLoadCount(au);
        }
    }

    public void bpo() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.fot != null && this.fot.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.fot.getForum().getId(), 0L));
        }
        this.fHa.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void wP(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.clw().eg(FrsModelController.this.fHy, str);
                return null;
            }
        }, null);
    }

    public void wQ(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.clw().eh(FrsModelController.this.fHy, str);
                return null;
            }
        }, null);
    }

    public void wR(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.clw().ei(FrsModelController.this.fHy, str);
                return null;
            }
        }, null);
    }
}
