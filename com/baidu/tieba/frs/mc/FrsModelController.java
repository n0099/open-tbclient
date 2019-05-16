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
    private int dkO;
    private long eTv;
    private long eTw;
    private long eTx;
    private long eTy;
    private final FrsFragment fGZ;
    private FrsNetModel<FrsFragment> fGc;
    private e.b fGe;
    private String fGf;
    private ArrayList<m> fHe;
    private FrsRequestData fHf;
    private final n fHg;
    private boolean fHh;
    private int fHi;
    private long fHj;
    private int fHk;
    private int fHl;
    private am fHm;
    private boolean fHn;
    private SparseArray<am> fHo;
    private y fHp;
    private ai fHq;
    private ArrayList<m> fHr;
    private boolean fHs;
    private String fHt;
    private int fHu;
    private int fHv;
    private boolean fHw;
    private String fHx;
    private final SparseArray<Boolean> fHy;
    private ai fHz;
    private String foH;
    private FrsViewData fos;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean sf(int i) {
        return this.fHy.get(i, false).booleanValue();
    }

    public void C(int i, boolean z) {
        this.fHy.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.foH = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.fHi = 0;
        this.mSource = null;
        this.fGf = null;
        this.fHj = 0L;
        this.dkO = 1;
        this.fHk = 0;
        this.fHl = 0;
        this.fHn = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.fHo = new SparseArray<>();
        this.cyF = 0L;
        this.fHs = false;
        this.fHu = -1;
        this.fHv = -1;
        this.fHx = null;
        this.fHy = new SparseArray<>();
        this.fHz = new ai() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ai
            public void a(int i, int i2, ap apVar, ArrayList<m> arrayList) {
                FrsModelController.this.fHn = false;
                if (i == FrsModelController.this.dkO && FrsModelController.this.fHq != null) {
                    FrsModelController.this.fHm = apVar;
                    FrsModelController.this.b(i, i2, apVar);
                    ArrayList<m> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.fos.setThreadList(arrayList2);
                    FrsModelController.this.fHq.a(i, i2, apVar, arrayList);
                }
            }
        };
        this.eTv = 0L;
        this.eTw = 0L;
        this.eTx = 0L;
        this.eTy = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.fGZ = frsFragment;
        this.fHg = nVar;
        M(this.fGZ);
    }

    private void M(FrsFragment frsFragment) {
        this.fHp = new y();
        this.fHp.cwh = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.fHp));
        this.fHp.a(this.fHz);
    }

    public void onActivityDestroy() {
        this.fGc.cancelLoadData();
    }

    public void K(Bundle bundle) {
        if (bundle != null) {
            this.foH = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.fHt = bundle.getString("yuelaou_locate");
            this.fHh = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.fHi = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.fHj = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.fGZ.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.foH)) {
            this.foH = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.fHt)) {
            this.fHt = "";
        }
        this.mSource = this.mFrom;
        boW();
        this.fos = new FrsViewData();
        this.fHf.ej("forum_name", com.baidu.adp.lib.util.k.bh(this.foH));
        this.fHf.ej("client_type", "2");
        if (this.fGc == null) {
            this.fGc = new FrsNetModel<>(this.fGZ.getPageContext(), this.fHf);
        }
        this.fGc.a(this);
        this.fGc.setUniqueId(this.fGZ.getPageContext().getUniqueId());
        if (this.foH != null && this.foH.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.foH);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void boW() {
        AccountData currentAccountObj;
        this.fHf = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            sg(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            sg(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            sg(com.baidu.tieba.frs.f.g.wY("1~" + str + this.foH));
        }
        this.fHf.setSortType(getSortType());
        if (this.fHu == 5) {
            this.fHf.setIsGood(1);
        } else {
            this.fHf.setIsGood(0);
        }
    }

    public boolean aYY() {
        if (this.dkO != 1) {
            sc(1);
            return true;
        } else if (this.fGc.pu()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fHf), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void D(int i, boolean z) {
        this.fGZ.foU = System.currentTimeMillis();
        if (this.fos != null && this.fos.getLikeFeedForumDataList() != null) {
            this.fos.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fHf), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.dkO = c(this.dkO, frsRequestData);
        if (this.dkO == 1) {
            if (!this.fGc.pu()) {
                frsRequestData.setCallFrom(this.fHi);
                a(frsRequestData, i, z ? false : true);
                this.fHi = 0;
                return;
            }
            return;
        }
        if (this.fHm == null) {
            this.fHm = new am();
            this.fHm.pn = 1;
            this.fHm.forumName = this.foH;
            if (this.fos != null && this.fos.getForum() != null) {
                this.fHm.forumId = this.fos.getForum().getId();
            }
        }
        sc(i);
    }

    public void sd(int i) {
        if (this.dkO != 1) {
            sc(4);
        } else if (!this.fGc.pu()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.fHf), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.fGZ.jE(z);
        this.fHg.ra(i);
        this.fGc.a(frsRequestData);
        this.mType = i;
        frsRequestData.DK(this.fGZ.bkl() ? "1" : "2");
        if (this.fHw) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.sx(this.fHv)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.fHw = false;
        frsRequestData.setKw(this.foH);
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
        frsRequestData.setLastId(this.fGf);
        frsRequestData.setYuelaouLocate(this.fHt);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(com.baidu.tbadk.util.y.avp(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.foV != 0) {
            frsRequestData.setCtime((int) FrsFragment.foV);
        }
        if (FrsFragment.foW != 0) {
            frsRequestData.setDataSize((int) FrsFragment.foW);
        }
        if (FrsFragment.foX != 0) {
            frsRequestData.setNetError(FrsFragment.foX);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.en(this.fHj);
        if (this.fHj != 0) {
            this.fHj = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.fHu, frsRequestData);
        b(i, frsRequestData);
        a(this.foH, frsRequestData);
        if (!sf(this.fHu) && !this.fGZ.foI) {
            String c = com.baidu.tieba.tbadkCore.d.clu().c("1~" + this.foH, frsRequestData.getSortType(), frsRequestData.getIsGood(), this.fHf.getCategoryId());
            this.fHx = c;
            new a(this, true, c).execute(new Object[0]);
        }
        boG();
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
            this.dkO = jVar.getFrsDefaultTabId();
        }
        this.fos.receiveData(jVar);
        d(this.fos);
        this.fHe = new ArrayList<>();
        if (frsRequestData != null) {
            this.fHf = frsRequestData;
            this.mPn = this.fHf.getPn();
            this.foH = this.fHf.getKw();
            this.fGZ.setForumName(this.foH);
            this.fGZ.setFrom(this.mFrom);
            this.fGZ.setPn(this.mPn);
            this.fGZ.setFlag(this.mFlag);
        }
        if (this.fos.getThreadList() != null) {
            this.fHe.addAll(this.fos.getThreadList());
        }
        if (this.dkO != 1 && this.isNetFirstLoad) {
            this.fHg.a(7, false, this.fGe);
        } else {
            this.fHg.a(this.mType, false, this.fGe);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.fHf)) {
            bpl();
        }
        this.isNetFirstLoad = false;
        if (jVar.getForum() != null && !TextUtils.isEmpty(jVar.getForum().getName()) && frsRequestData != null && r.ceJ().ceD() != null) {
            r.ceJ().ceD().g(jVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        com.baidu.tieba.frs.a.biT().jz(this.dkO == 301);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.j jVar;
        e.b bVar = new e.b();
        bVar.eWE = com.baidu.adp.lib.util.j.jS() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcSocketResponsedMessage.getError();
        bVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        bVar.iWp = mvcSocketResponsedMessage.getDownSize();
        this.fGe = bVar;
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
        this.fGZ.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.j, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.j> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.fHs) {
            this.fHs = true;
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
        bVar.eWE = com.baidu.adp.lib.util.j.jS() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        bVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        bVar.errorCode = mvcHttpResponsedMessage.getError();
        bVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        bVar.iWp = mvcHttpResponsedMessage.getDownSize();
        this.fGe = bVar;
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
        this.fGZ.a(errorData);
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
        if (!this.fHs) {
            this.fHs = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bkd() {
        if (this.fos != null && this.fos.getForum() != null && this.fos.getForum().getBannerListData() != null) {
            String lastIds = this.fos.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.fGf = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.auk().aul()) {
            this.cyF = System.currentTimeMillis() - this.fGZ.beginTime;
            com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(i, z, responsedMessage, this.fGZ.cyw, this.fGZ.createTime, this.fGZ.cyE, false, this.cyF);
            this.fGZ.createTime = 0L;
            this.fGZ.cyw = 0L;
            if (iVar != null) {
                iVar.auh();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.p.m.auk().aul()) {
            this.cyF = System.currentTimeMillis() - this.fGZ.foU;
            com.baidu.tbadk.p.i iVar = new com.baidu.tbadk.p.i(1000, z, responsedMessage, this.fGZ.cyw, this.fGZ.createTime, this.fGZ.cyE, false, this.cyF);
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

    public FrsRequestData boX() {
        return this.fHf;
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

    public FrsViewData boF() {
        return this.fos;
    }

    public e.b boY() {
        return this.fGe;
    }

    private void boG() {
        this.eTv = System.currentTimeMillis();
        this.fGc.atv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.tbadkCore.j jVar) {
        this.isCacheFirstLoad = false;
        this.fos.receiveData(jVar);
        d(this.fos);
        this.fHe = new ArrayList<>();
        if (this.fos.getThreadList() != null) {
            this.fHe.addAll(this.fos.getThreadList());
        }
        this.fHg.b(jVar);
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
        private String fHD;
        private FrsModelController fHE;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.fHD = null;
            this.fHD = str;
            this.fHE = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.d.clu().DI(this.fHD)) {
                if (!com.baidu.tieba.tbadkCore.d.clu().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.fHD)) {
                    com.baidu.tieba.tbadkCore.d.clu().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.j responseData = com.baidu.tieba.tbadkCore.d.clu().getResponseData();
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
            if (this.fHE != null && jVarArr != null) {
                this.fHE.f(jVarArr.length > 0 ? jVarArr[0] : null);
                this.fHE.C(this.fHE.fHu, true);
            }
        }
    }

    public long bed() {
        return this.eTy;
    }

    public long bee() {
        return this.eTw;
    }

    public long bef() {
        return this.eTx;
    }

    public long beg() {
        return this.eTv;
    }

    public boolean pu() {
        return this.fGc.pu();
    }

    public int boZ() {
        return this.fHl;
    }

    private void bpa() {
        if (this.fHr == null) {
            this.fHr = new ArrayList<>();
        }
        if (this.fHr.size() == 0) {
            this.fHr.add(new u());
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, int i2, am amVar) {
        this.dkO = c(i, null);
        if (amVar == null && (amVar = bz(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.ki() && this.fHq != null) {
                ap apVar = new ap();
                apVar.hasMore = false;
                apVar.pn = 1;
                apVar.forumName = this.foH;
                apVar.fte = false;
                if (this.fos != null && this.fos.getForum() != null) {
                    apVar.forumId = this.fos.getForum().getId();
                }
                bpa();
                this.fos.setThreadList(this.fHr);
                this.fHq.a(i, i2, apVar, this.fHr);
            }
            amVar = new am();
            amVar.pn = -1;
        }
        if (this.fos != null && this.fos.getForum() != null) {
            amVar.forumId = this.fos.getForum().getId();
        }
        amVar.forumName = this.foH;
        if (w.blz().rs(1) != null && this.dkO == 1) {
            this.fHf.setCategoryId(i2);
        }
        this.fHk = i2;
        this.fHm = amVar;
        b(i, i2, amVar);
        sc(5);
    }

    @Override // com.baidu.tieba.frs.af
    public void a(ai aiVar) {
        this.fHq = aiVar;
        this.fHp.a(this.fHz);
    }

    private void sc(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.fHm != null) {
                    this.fHm.pn++;
                    break;
                }
                break;
            case 2:
                if (this.fHm != null) {
                    am amVar = this.fHm;
                    amVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.fHm != null) {
                    this.fHm.pn = -1;
                    break;
                }
                break;
        }
        if (this.dkO == 1) {
            if (this.fHl == this.fHk) {
                ArrayList<m> arrayList = new ArrayList<>();
                if (this.fHe != null) {
                    arrayList.addAll(this.fHe);
                }
                this.fos.setThreadList(arrayList);
                if (this.fHq != null) {
                    this.fHq.a(this.dkO, this.fHk, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.fHl = this.fHk;
            return;
        }
        af rt = this.fHp.rt(this.dkO);
        if (rt != null) {
            this.fHn = true;
            rt.a(this.dkO, this.fHk, this.fHm);
            return;
        }
        if (this.fos != null && this.fos.getThreadList() != null) {
            this.fos.getThreadList().clear();
        }
        this.fHq.a(this.dkO, this.fHk, null, null);
    }

    public boolean hasMore() {
        if ((this.fHm instanceof ap) && ((ap) this.fHm).errCode == 0) {
            return ((ap) this.fHm).hasMore;
        }
        return true;
    }

    private int by(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, am amVar) {
        this.fHo.put(by(i, i2), amVar);
    }

    public am bz(int i, int i2) {
        return this.fHo.get(by(i, i2));
    }

    @Override // com.baidu.tieba.frs.af
    public void init() {
        this.fHp.init();
    }

    @Override // com.baidu.tieba.frs.af
    public void aJP() {
        this.fHp.destory();
        this.fHp.clear();
    }

    public int bpb() {
        return this.dkO;
    }

    public boolean bpc() {
        return 1 == this.dkO;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(ak akVar) {
        if (akVar != null && !StringUtils.isNull(akVar.getId()) && !v.aa(this.fHe)) {
            if (this.dkO == 1) {
                this.fos.addMyNewThread(akVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<m> it = this.fHe.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if ((next instanceof bf) && akVar.getId().equals(((bf) next).threadData.getId())) {
                    return;
                }
            }
            this.fHe.add(topThreadSize, akVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.fHe == null || this.fHe.size() <= 0) {
            return 0;
        }
        Iterator<m> it = this.fHe.iterator();
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

    public boolean bpd() {
        return this.fHn;
    }

    public void bpe() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.fHl == 0) {
            mVar.rl(this.fHu);
        }
        if (this.fos.getThreadList() != null) {
            this.fos.getThreadList().clear();
            this.fos.getThreadList().add(mVar);
        }
        if (this.fHe != null) {
            this.fHe.clear();
            this.fHe.add(mVar);
        }
    }

    public ArrayList<m> bpf() {
        return this.fHe;
    }

    public void sg(int i) {
        AccountData currentAccountObj;
        this.fHu = i;
        String str = "";
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
        }
        com.baidu.tieba.frs.f.g.aw("1~" + str + this.foH, this.fHu);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cnr();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cns();
        }
    }

    public void sh(int i) {
        this.fHv = i;
    }

    public void ky(boolean z) {
        this.fHw = z;
    }

    public int bpg() {
        return this.fHu;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.sx(this.fHu);
    }

    public boolean bph() {
        return this.fHh;
    }

    public boolean bpi() {
        return this.fHu == 5;
    }

    public boolean bpj() {
        return this.fHf != null && this.fHf.getLoadType() == 1;
    }

    public boolean bpk() {
        return this.fHu == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.fGZ.bjD() != null) {
            return this.fGZ.bjD().a(this.fHu, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bg.bII.get() && r.ceJ().ceD() != null) {
            int at = r.ceJ().ceD().at(str, false);
            int au = r.ceJ().ceD().au(str, false);
            if (frsRequestData.getLoadType() == 1) {
                at++;
            } else if (frsRequestData.getLoadType() == 2) {
                au++;
            }
            frsRequestData.setRefreshCount(at);
            frsRequestData.setLoadCount(au);
        }
    }

    public void bpl() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.fos != null && this.fos.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.fos.getForum().getId(), 0L));
        }
        this.fGZ.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void wP(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.clu().eg(FrsModelController.this.fHx, str);
                return null;
            }
        }, null);
    }

    public void wQ(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.clu().eh(FrsModelController.this.fHx, str);
                return null;
            }
        }, null);
    }

    public void wR(final String str) {
        aa.a(new z<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.z
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.d.clu().ei(FrsModelController.this.fHx, str);
                return null;
            }
        }, null);
    }
}
