package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
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
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.q;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.m>, ak {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private boolean dJC;
    private long esh;
    private long gSS;
    private long gST;
    private long gSU;
    private long gSV;
    private int hAf;
    private FrsNetModel<FrsFragment> hFP;
    private com.baidu.tieba.tbadkCore.f hFR;
    private String hFS;
    private final FrsFragment hGQ;
    private ArrayList<o> hGV;
    private FrsRequestData hGW;
    private final q hGX;
    private boolean hGY;
    private int hGZ;
    private long hHa;
    private int hHb;
    private int hHc;
    private as hHd;
    private boolean hHe;
    private SparseArray<as> hHf;
    private ad hHg;
    private ao hHh;
    private ArrayList<o> hHi;
    private String hHj;
    private int hHk;
    private int hHl;
    private int hHm;
    private boolean hHn;
    private String hHo;
    private final SparseArray<Boolean> hHp;
    private boolean hHq;
    private boolean hHr;
    private n hHs;
    private m hHt;
    private ao hHu;
    private FrsViewData hmR;
    private String hnl;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSchemeUrl;
    private String mSource;
    private int mType;

    public boolean uY(int i) {
        return this.hHp.get(i, false).booleanValue();
    }

    public void L(int i, boolean z) {
        this.hHp.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, q qVar) {
        super(frsFragment.getPageContext());
        this.hnl = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.hGZ = 0;
        this.mSchemeUrl = "";
        this.mSource = null;
        this.hFS = null;
        this.hHa = 0L;
        this.hAf = 1;
        this.hHb = 0;
        this.hHc = 0;
        this.hHe = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.hHf = new SparseArray<>();
        this.esh = 0L;
        this.dJC = false;
        this.hHk = -1;
        this.hHl = -1;
        this.hHm = -1;
        this.hHo = null;
        this.hHp = new SparseArray<>();
        this.hHs = new n();
        this.hHt = new m();
        this.hHu = new ao() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ao
            public void a(int i, int i2, av avVar, ArrayList<o> arrayList) {
                FrsModelController.this.hHe = false;
                if (i == FrsModelController.this.hAf && FrsModelController.this.hHh != null) {
                    FrsModelController.this.hHd = avVar;
                    FrsModelController.this.b(i, i2, avVar);
                    ArrayList<o> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.hmR.setThreadList(arrayList2);
                    FrsModelController.this.hHh.a(i, i2, avVar, arrayList);
                }
            }
        };
        this.gSS = 0L;
        this.gST = 0L;
        this.gSU = 0L;
        this.gSV = 0L;
        if (qVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.hGQ = frsFragment;
        this.hGX = qVar;
        O(this.hGQ);
    }

    private void O(FrsFragment frsFragment) {
        this.hHg = new ad();
        this.hHg.epM = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.hHg));
        this.hHg.a(this.hHu);
    }

    public void bZX() {
        Looper.myQueue().removeIdleHandler(this.hHs);
        Looper.myQueue().removeIdleHandler(this.hHt);
        this.hFP.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.hnl = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.hHj = bundle.getString("yuelaou_locate");
            this.hGY = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.hGZ = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.hHa = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.hGQ.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.hnl)) {
            this.hnl = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.hHj)) {
            this.hHj = "";
        }
        this.mSource = this.mFrom;
        car();
        this.hmR = new FrsViewData();
        this.hGW.fp("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.hnl));
        this.hGW.fp("client_type", "2");
        if (this.hFP == null) {
            this.hFP = new FrsNetModel<>(this.hGQ.getPageContext(), this.hGW);
        }
        this.hFP.a(this);
        this.hFP.setUniqueId(this.hGQ.getPageContext().getUniqueId());
        if (this.hnl != null && this.hnl.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.hnl);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void car() {
        AccountData currentAccountObj;
        this.hGW = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            uZ(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            uZ(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            this.hHm = com.baidu.tieba.frs.f.g.Fh("1~" + str + this.hnl);
            uZ(this.hHk);
        }
        this.hGW.setSortType(getSortType());
        if (this.hHk == 5) {
            this.hGW.setIsGood(1);
        } else {
            this.hGW.setIsGood(0);
        }
    }

    public boolean bMa() {
        if (this.hAf != 1) {
            uT(1);
            return true;
        } else if (this.hFP.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.hGW), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void M(int i, boolean z) {
        this.hGQ.hny = System.currentTimeMillis();
        if (this.hmR != null && this.hmR.getLikeFeedForumDataList() != null) {
            this.hmR.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.hGW), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.hAf = c(this.hAf, frsRequestData);
        if (this.hAf == 1) {
            if (!this.hFP.isLoading()) {
                frsRequestData.setCallFrom(this.hGZ);
                a(frsRequestData, i, z ? false : true);
                this.hGZ = 0;
                return;
            }
            return;
        }
        if (this.hHd == null) {
            this.hHd = new as();
            this.hHd.pn = 1;
            this.hHd.forumName = this.hnl;
            if (this.hmR != null && this.hmR.getForum() != null) {
                this.hHd.forumId = this.hmR.getForum().getId();
            }
        }
        uT(i);
    }

    public void uU(int i) {
        if (this.hAf != 1) {
            uT(4);
        } else if (!this.hFP.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.hGW), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.hGQ.mL(z);
        this.hGX.tM(i);
        this.hFP.a(frsRequestData);
        this.mType = i;
        frsRequestData.Ms(this.hGQ.bVx() ? "1" : "2");
        if (this.hHn) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.vq(this.hHl)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.hHn = false;
        frsRequestData.setKw(this.hnl);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = ar.aUX().aUY() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setSchemeUrl(this.mSchemeUrl);
        frsRequestData.setLastId(this.hFS);
        frsRequestData.setYuelaouLocate(this.hHj);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ab.bgO(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.DP(cas());
        if (FrsFragment.hnz != 0) {
            frsRequestData.setCtime((int) FrsFragment.hnz);
        }
        if (FrsFragment.hnA != 0) {
            frsRequestData.setDataSize((int) FrsFragment.hnA);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.fq(this.hHa);
        if (this.hHa != 0) {
            this.hHa = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.hHk, frsRequestData);
        int vq = com.baidu.tieba.frs.f.g.vq(this.hHm);
        b(i, frsRequestData);
        a(this.hnl, frsRequestData);
        if (!uY(this.hHm) && !this.hGQ.hnm && !this.hHq) {
            String e = com.baidu.tieba.tbadkCore.e.dcJ().e("1~" + this.hnl, vq, frsRequestData.getIsGood(), this.hGW.getCategoryId());
            this.hHo = e;
            new a(this, true, e).execute(new Object[0]);
        }
        this.hHr = cav();
        this.hHq = false;
    }

    private int cas() {
        return (this.hGQ == null || !(this.hGQ.mHeadLineDefaultNavTabId == -1 || this.hGQ.mHeadLineDefaultNavTabId == this.hAf)) ? 0 : 1;
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

    protected boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar == null || mVar.getForum() == null || (aq.isEmpty(mVar.getForum().getName()) && 340001 != mVar.mErrorNo)) {
            return false;
        }
        if (mVar.getDataParseTime() > 0) {
            this.hGQ.esd = mVar.getDataParseTime();
        }
        uZ(com.baidu.tieba.frs.f.g.vr(mVar.getSortType()));
        L(com.baidu.tieba.frs.f.g.vr(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.hAf = mVar.getFrsDefaultTabId();
        }
        this.hmR.receiveData(mVar);
        d(this.hmR);
        this.hGV = new ArrayList<>();
        if (frsRequestData != null) {
            this.hGW = frsRequestData;
            this.mPn = this.hGW.getPn();
            this.hnl = this.hGW.getKw();
            this.hGQ.setForumName(this.hnl);
            this.hGQ.setFrom(this.mFrom);
            this.hGQ.setPn(this.mPn);
            this.hGQ.setFlag(this.mFlag);
        }
        if (this.hmR.getThreadList() != null) {
            this.hGV.addAll(this.hmR.getThreadList());
        }
        if (this.hAf != 1 && this.isNetFirstLoad) {
            this.hGX.a(7, false, this.hFR);
        } else {
            this.hGX.a(this.mType, false, this.hFR);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.hGW)) {
            caJ();
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() == null || TextUtils.isEmpty(mVar.getForum().getName()) || frsRequestData == null || com.baidu.tieba.recapp.q.cUC().cUw() == null) {
            return true;
        }
        com.baidu.tieba.recapp.q.cUC().cUw().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        if (mvcSocketResponsedMessage != null) {
            this.hHs.f(this);
            this.hHs.a(mvcSocketResponsedMessage);
            this.hHs.a(mvcSocketMessage);
            this.hHs.a(mvcNetMessage);
            Looper.myQueue().addIdleHandler(this.hHs);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.gXw = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.ljF = mvcSocketResponsedMessage.getDownSize();
            this.hFR = fVar;
            if (!mvcSocketResponsedMessage.hasError() || 340001 == mvcSocketResponsedMessage.getError()) {
                data = mvcSocketResponsedMessage.getData();
                r3 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
                if (mvcNetMessage != null) {
                    r3 = mvcNetMessage.getRequestData();
                }
            } else {
                data = null;
            }
            if (r3 == null || data == null || !a(r3, data)) {
                ErrorData errorData = new ErrorData();
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                this.hGQ.a(errorData);
            }
        }
    }

    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dJC) {
            this.dJC = true;
            a(1000, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        } else {
            a(false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
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
            objArr[2] = BdStatsConstant.StatsKey.SEQUENCEID;
            objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
            com.baidu.tbadk.core.d.a.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m mVar;
        FrsRequestData frsRequestData;
        if (mvcHttpResponsedMessage != null) {
            this.hHt.f(this);
            this.hHt.a(mvcHttpResponsedMessage);
            this.hHt.a(mvcHttpMessage);
            this.hHt.a(mvcNetMessage);
            Looper.myQueue().addIdleHandler(this.hHt);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.gXw = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.ljF = mvcHttpResponsedMessage.getDownSize();
            this.hFR = fVar;
            if (mvcHttpResponsedMessage.hasError()) {
                mVar = null;
                frsRequestData = null;
            } else {
                mVar = mvcHttpResponsedMessage.getData();
                frsRequestData = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
                if (mvcNetMessage != null) {
                    frsRequestData = mvcNetMessage.getRequestData();
                }
            }
            if (frsRequestData == null || mVar == null || !a(frsRequestData, mVar)) {
                ErrorData errorData = new ErrorData();
                this.mErrorCode = mvcHttpResponsedMessage.getError();
                this.mErrorString = mvcHttpResponsedMessage.getErrorString();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                this.hGQ.a(errorData);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        super.registerListener(i, aVar);
    }

    public void b(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.m> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
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
        if (!this.dJC) {
            this.dJC = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bVo() {
        if (this.hmR != null && this.hmR.getForum() != null && this.hmR.getForum().getBannerListData() != null) {
            String lastIds = this.hmR.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.hFS = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.bfJ().bfK()) {
            this.esh = System.currentTimeMillis() - this.hGQ.gPV;
            this.hGQ.esg = System.currentTimeMillis() - this.hGQ.hnx;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, this.hGQ.erW, this.hGQ.createTime, this.hGQ.esg, false, this.hGQ.erX, this.hGQ.esd, this.esh);
            this.hGQ.createTime = 0L;
            this.hGQ.erW = 0L;
            com.baidu.tieba.frs.f.h.a(this, this.hGQ.gPV);
            this.hGQ.gPV = -1L;
            iVar.bfG();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.bfJ().bfK()) {
            this.esh = System.currentTimeMillis() - this.hGQ.hny;
            this.hGQ.esg = System.currentTimeMillis() - this.hGQ.hnx;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1000, z, responsedMessage, this.hGQ.erW, this.hGQ.createTime, this.hGQ.esg, false, this.hGQ.erX, this.hGQ.esd, this.esh);
            if (this.mType == 4) {
                iVar.esp = this.esh;
                iVar.io(true);
            } else if (this.mType == 3) {
                iVar.esq = this.esh;
                iVar.io(false);
            }
        }
    }

    public FrsRequestData cat() {
        return this.hGW;
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

    public FrsViewData bZZ() {
        return this.hmR;
    }

    public com.baidu.tieba.tbadkCore.f cau() {
        return this.hFR;
    }

    private boolean cav() {
        this.gSS = System.currentTimeMillis();
        return this.hFP.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.hmR.receiveData(mVar);
        d(this.hmR);
        this.hGV = new ArrayList<>();
        if (this.hmR.getThreadList() != null) {
            this.hGV.addAll(this.hmR.getThreadList());
        }
        this.hGX.c(mVar);
    }

    private void d(FrsViewData frsViewData) {
        if (com.baidu.tieba.frs.vc.h.k(frsViewData)) {
            this.mPageType = "book_page";
        } else if (frsViewData.getIsBrandForum()) {
            this.mPageType = "brand_page";
        } else if (com.baidu.tieba.frs.vc.h.l(frsViewData)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes9.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.m, Void> {
        private String bhf;
        private FrsModelController hHy;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.bhf = null;
            this.bhf = str;
            this.hHy = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.dcJ().Mq(this.bhf)) {
                if (!com.baidu.tieba.tbadkCore.e.dcJ().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.bhf)) {
                    com.baidu.tieba.tbadkCore.e.dcJ().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.dcJ().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().aOI(), true) && !responseData.getBookInfo().aOI().equals("0") && responseData.getBookInfo().aOJ() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().aOI(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
        public void onProgressUpdate(com.baidu.tieba.tbadkCore.m... mVarArr) {
            super.onProgressUpdate(mVarArr);
            if (this.hHy != null && mVarArr != null) {
                this.hHy.e(mVarArr.length > 0 ? mVarArr[0] : null);
                this.hHy.L(this.hHy.hHk, true);
            }
        }
    }

    public long bPp() {
        return this.gSV;
    }

    public long bPq() {
        return this.gST;
    }

    public long bPr() {
        return this.gSU;
    }

    public long bPs() {
        return this.gSS;
    }

    public boolean isLoading() {
        return this.hFP.isLoading();
    }

    public int caw() {
        return this.hHc;
    }

    private void cax() {
        if (this.hHi == null) {
            this.hHi = new ArrayList<>();
        }
        if (this.hHi.size() == 0) {
            this.hHi.add(new z());
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, as asVar) {
        this.hAf = c(i, null);
        if (asVar == null && (asVar = cc(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.hHh != null) {
                av avVar = new av();
                avVar.hasMore = false;
                avVar.pn = 1;
                avVar.forumName = this.hnl;
                avVar.hrA = false;
                if (this.hmR != null && this.hmR.getForum() != null) {
                    avVar.forumId = this.hmR.getForum().getId();
                }
                cax();
                this.hmR.setThreadList(this.hHi);
                this.hHh.a(i, i2, avVar, this.hHi);
            }
            asVar = new as();
            asVar.pn = -1;
        }
        if (this.hmR != null && this.hmR.getForum() != null) {
            asVar.forumId = this.hmR.getForum().getId();
        }
        asVar.forumName = this.hnl;
        if (com.baidu.tieba.frs.ab.bWN().uf(1) != null && this.hAf == 1) {
            this.hGW.setCategoryId(i2);
        }
        this.hHb = i2;
        this.hHd = asVar;
        b(i, i2, asVar);
        uT(5);
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(ao aoVar) {
        this.hHh = aoVar;
        this.hHg.a(this.hHu);
    }

    private void uT(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.hHd != null) {
                    this.hHd.pn++;
                    break;
                }
                break;
            case 2:
                if (this.hHd != null) {
                    as asVar = this.hHd;
                    asVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.hHd != null) {
                    this.hHd.pn = -1;
                    break;
                }
                break;
        }
        if (this.hAf == 1) {
            if (this.hHc == this.hHb) {
                ArrayList<o> arrayList = new ArrayList<>();
                if (this.hGV != null) {
                    arrayList.addAll(this.hGV);
                }
                this.hmR.setThreadList(arrayList);
                if (this.hHh != null) {
                    this.hHh.a(this.hAf, this.hHb, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.hHc = this.hHb;
            return;
        }
        ak ug = this.hHg.ug(this.hAf);
        if (ug != null) {
            this.hHe = true;
            ug.a(this.hAf, this.hHb, this.hHd);
            return;
        }
        if (this.hmR != null && this.hmR.getThreadList() != null) {
            this.hmR.getThreadList().clear();
        }
        this.hHh.a(this.hAf, this.hHb, null, null);
    }

    public boolean hasMore() {
        if ((this.hHd instanceof av) && ((av) this.hHd).errCode == 0) {
            return ((av) this.hHd).hasMore;
        }
        return true;
    }

    private int cb(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, as asVar) {
        this.hHf.put(cb(i, i2), asVar);
    }

    public as cc(int i, int i2) {
        return this.hHf.get(cb(i, i2));
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        this.hHg.init();
    }

    @Override // com.baidu.tieba.frs.ak
    public void bwk() {
        this.hHg.destory();
        this.hHg.clear();
    }

    public int cay() {
        return this.hAf;
    }

    public boolean caz() {
        return 1 == this.hAf;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(al alVar) {
        if (alVar != null && !StringUtils.isNull(alVar.getId()) && !v.isEmpty(this.hGV)) {
            if (this.hAf == 1) {
                this.hmR.addMyNewThread(alVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<o> it = this.hGV.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if ((next instanceof bj) && alVar.getId().equals(((bj) next).dEA.getId())) {
                    return;
                }
            }
            this.hGV.add(topThreadSize, alVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.hGV == null || this.hGV.size() <= 0) {
            return 0;
        }
        Iterator<o> it = this.hGV.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                o next = it.next();
                if (!(next instanceof bj)) {
                    i = i2;
                } else if (((bj) next).dEA.aQs() != 0) {
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

    public boolean caA() {
        return this.hHe;
    }

    public void caB() {
        p pVar = new p();
        if (this.hHc == 0) {
            pVar.tZ(this.hHk);
        }
        if (this.hmR.getThreadList() != null) {
            this.hmR.getThreadList().clear();
            this.hmR.getThreadList().add(pVar);
        }
        if (this.hGV != null) {
            this.hGV.clear();
            this.hGV.add(pVar);
        }
    }

    public ArrayList<o> caC() {
        return this.hGV;
    }

    public void uZ(int i) {
        AccountData currentAccountObj;
        this.hHk = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.f.g.aN("1~" + str + this.hnl, this.hHk);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.deS();
        } else {
            com.baidu.tieba.tbadkCore.util.e.deT();
        }
    }

    public void va(int i) {
        this.hHl = i;
    }

    public void nC(boolean z) {
        this.hHn = z;
    }

    public int caD() {
        return this.hHk;
    }

    public int caE() {
        return this.hHm;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.vq(this.hHk);
    }

    public boolean caF() {
        return this.hGY;
    }

    public boolean caG() {
        return this.hHk == 5;
    }

    public boolean caH() {
        return this.hGW != null && this.hGW.getLoadType() == 1;
    }

    public boolean caI() {
        return this.hHk == 7 || (!this.hHr && this.hHm == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.hGQ.bUK() != null) {
            return this.hGQ.bUK().a(this.hHk, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bk.dFk.get() && com.baidu.tieba.recapp.q.cUC().cUw() != null) {
            int aQ = com.baidu.tieba.recapp.q.cUC().cUw().aQ(str, false);
            int aR = com.baidu.tieba.recapp.q.cUC().cUw().aR(str, false);
            if (frsRequestData.getLoadType() == 1) {
                aQ++;
            } else if (frsRequestData.getLoadType() == 2) {
                aR++;
            }
            frsRequestData.setRefreshCount(aQ);
            frsRequestData.setLoadCount(aR);
        }
    }

    public void caJ() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.hmR != null && this.hmR.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.hmR.getForum().getId(), 0L));
        }
        this.hGQ.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void Fa(final String str) {
        com.baidu.tbadk.util.ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dcJ().fm(FrsModelController.this.hHo, str);
                return null;
            }
        }, null);
    }

    public void Fb(final String str) {
        com.baidu.tbadk.util.ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dcJ().fn(FrsModelController.this.hHo, str);
                return null;
            }
        }, null);
    }

    public void Fc(final String str) {
        com.baidu.tbadk.util.ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dcJ().fo(FrsModelController.this.hHo, str);
                return null;
            }
        }, null);
    }

    public void nD(boolean z) {
        this.hHq = z;
    }
}
