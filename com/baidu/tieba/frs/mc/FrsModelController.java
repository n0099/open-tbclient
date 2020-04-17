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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
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
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.ab;
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
    private long edP;
    private long gDS;
    private long gDT;
    private long gDU;
    private long gDV;
    private FrsViewData gXO;
    private String gYi;
    private int hky;
    private FrsNetModel<FrsFragment> hqi;
    private com.baidu.tieba.tbadkCore.f hqk;
    private String hql;
    private ArrayList<com.baidu.adp.widget.ListView.m> hrA;
    private boolean hrB;
    private String hrC;
    private int hrD;
    private int hrE;
    private int hrF;
    private boolean hrG;
    private String hrH;
    private final SparseArray<Boolean> hrI;
    private boolean hrJ;
    private boolean hrK;
    private n hrL;
    private m hrM;
    private ao hrN;
    private final FrsFragment hri;
    private ArrayList<com.baidu.adp.widget.ListView.m> hrn;
    private FrsRequestData hro;
    private final q hrp;
    private boolean hrq;
    private int hrr;
    private long hrs;
    private int hrt;
    private int hru;
    private as hrv;
    private boolean hrw;
    private SparseArray<as> hrx;
    private ad hry;
    private ao hrz;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSchemeUrl;
    private String mSource;
    private int mType;

    public boolean uq(int i) {
        return this.hrI.get(i, false).booleanValue();
    }

    public void I(int i, boolean z) {
        this.hrI.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, q qVar) {
        super(frsFragment.getPageContext());
        this.gYi = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.hrr = 0;
        this.mSchemeUrl = "";
        this.mSource = null;
        this.hql = null;
        this.hrs = 0L;
        this.hky = 1;
        this.hrt = 0;
        this.hru = 0;
        this.hrw = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.hrx = new SparseArray<>();
        this.edP = 0L;
        this.hrB = false;
        this.hrD = -1;
        this.hrE = -1;
        this.hrF = -1;
        this.hrH = null;
        this.hrI = new SparseArray<>();
        this.hrL = new n();
        this.hrM = new m();
        this.hrN = new ao() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ao
            public void a(int i, int i2, av avVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
                FrsModelController.this.hrw = false;
                if (i == FrsModelController.this.hky && FrsModelController.this.hrz != null) {
                    FrsModelController.this.hrv = avVar;
                    FrsModelController.this.b(i, i2, avVar);
                    ArrayList<com.baidu.adp.widget.ListView.m> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.gXO.setThreadList(arrayList2);
                    FrsModelController.this.hrz.a(i, i2, avVar, arrayList);
                }
            }
        };
        this.gDS = 0L;
        this.gDT = 0L;
        this.gDU = 0L;
        this.gDV = 0L;
        if (qVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.hri = frsFragment;
        this.hrp = qVar;
        M(this.hri);
    }

    private void M(FrsFragment frsFragment) {
        this.hry = new ad();
        this.hry.ebv = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.hry));
        this.hry.a(this.hrN);
    }

    public void aqT() {
        Looper.myQueue().removeIdleHandler(this.hrL);
        Looper.myQueue().removeIdleHandler(this.hrM);
        this.hqi.cancelLoadData();
    }

    public void ad(Bundle bundle) {
        if (bundle != null) {
            this.gYi = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.hrC = bundle.getString("yuelaou_locate");
            this.hrq = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.hrr = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.hrs = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.hri.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.gYi)) {
            this.gYi = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.hrC)) {
            this.hrC = "";
        }
        this.mSource = this.mFrom;
        bTO();
        this.gXO = new FrsViewData();
        this.hro.eO("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.gYi));
        this.hro.eO("client_type", "2");
        if (this.hqi == null) {
            this.hqi = new FrsNetModel<>(this.hri.getPageContext(), this.hro);
        }
        this.hqi.a(this);
        this.hqi.setUniqueId(this.hri.getPageContext().getUniqueId());
        if (this.gYi != null && this.gYi.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.gYi);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void bTO() {
        AccountData currentAccountObj;
        this.hro = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            ur(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            ur(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            this.hrF = com.baidu.tieba.frs.f.g.Dv("1~" + str + this.gYi);
            ur(this.hrD);
        }
        this.hro.setSortType(getSortType());
        if (this.hrD == 5) {
            this.hro.setIsGood(1);
        } else {
            this.hro.setIsGood(0);
        }
    }

    public boolean bFG() {
        if (this.hky != 1) {
            um(1);
            return true;
        } else if (this.hqi.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.hro), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void J(int i, boolean z) {
        this.hri.gYv = System.currentTimeMillis();
        if (this.gXO != null && this.gXO.getLikeFeedForumDataList() != null) {
            this.gXO.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.hro), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.hky = c(this.hky, frsRequestData);
        if (this.hky == 1) {
            if (!this.hqi.isLoading()) {
                frsRequestData.setCallFrom(this.hrr);
                a(frsRequestData, i, z ? false : true);
                this.hrr = 0;
                return;
            }
            return;
        }
        if (this.hrv == null) {
            this.hrv = new as();
            this.hrv.pn = 1;
            this.hrv.forumName = this.gYi;
            if (this.gXO != null && this.gXO.getForum() != null) {
                this.hrv.forumId = this.gXO.getForum().getId();
            }
        }
        um(i);
    }

    public void un(int i) {
        if (this.hky != 1) {
            um(4);
        } else if (!this.hqi.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.hro), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.hri.mq(z);
        this.hrp.tf(i);
        this.hqi.a(frsRequestData);
        this.mType = i;
        frsRequestData.KC(this.hri.bPb() ? "1" : "2");
        if (this.hrG) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.uI(this.hrE)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.hrG = false;
        frsRequestData.setKw(this.gYi);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = ar.aOV().aOW() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setSchemeUrl(this.mSchemeUrl);
        frsRequestData.setLastId(this.hql);
        frsRequestData.setYuelaouLocate(this.hrC);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(aa.baE(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.Dd(bTP());
        if (FrsFragment.gYw != 0) {
            frsRequestData.setCtime((int) FrsFragment.gYw);
        }
        if (FrsFragment.gYx != 0) {
            frsRequestData.setDataSize((int) FrsFragment.gYx);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.fq(this.hrs);
        if (this.hrs != 0) {
            this.hrs = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.hrD, frsRequestData);
        int uI = com.baidu.tieba.frs.f.g.uI(this.hrF);
        b(i, frsRequestData);
        a(this.gYi, frsRequestData);
        if (!uq(this.hrF) && !this.hri.gYj && !this.hrJ) {
            String e = com.baidu.tieba.tbadkCore.e.cVs().e("1~" + this.gYi, uI, frsRequestData.getIsGood(), this.hro.getCategoryId());
            this.hrH = e;
            new a(this, true, e).execute(new Object[0]);
        }
        this.hrK = bTS();
        this.hrJ = false;
    }

    private int bTP() {
        return (this.hri == null || !(this.hri.mHeadLineDefaultNavTabId == -1 || this.hri.mHeadLineDefaultNavTabId == this.hky)) ? 0 : 1;
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
            this.hri.edL = mVar.getDataParseTime();
        }
        ur(com.baidu.tieba.frs.f.g.uJ(mVar.getSortType()));
        I(com.baidu.tieba.frs.f.g.uJ(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.hky = mVar.getFrsDefaultTabId();
        }
        this.gXO.receiveData(mVar);
        d(this.gXO);
        this.hrn = new ArrayList<>();
        if (frsRequestData != null) {
            this.hro = frsRequestData;
            this.mPn = this.hro.getPn();
            this.gYi = this.hro.getKw();
            this.hri.setForumName(this.gYi);
            this.hri.setFrom(this.mFrom);
            this.hri.setPn(this.mPn);
            this.hri.setFlag(this.mFlag);
        }
        if (this.gXO.getThreadList() != null) {
            this.hrn.addAll(this.gXO.getThreadList());
        }
        if (this.hky != 1 && this.isNetFirstLoad) {
            this.hrp.a(7, false, this.hqk);
        } else {
            this.hrp.a(this.mType, false, this.hqk);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.hro)) {
            bUf();
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() == null || TextUtils.isEmpty(mVar.getForum().getName()) || frsRequestData == null || com.baidu.tieba.recapp.q.cNo().cNi() == null) {
            return true;
        }
        com.baidu.tieba.recapp.q.cNo().cNi().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        if (mvcSocketResponsedMessage != null) {
            this.hrL.f(this);
            this.hrL.a(mvcSocketResponsedMessage);
            this.hrL.a(mvcSocketMessage);
            this.hrL.a(mvcNetMessage);
            Looper.myQueue().addIdleHandler(this.hrL);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.gIu = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.kQc = mvcSocketResponsedMessage.getDownSize();
            this.hqk = fVar;
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
                this.hri.a(errorData);
            }
        }
    }

    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.hrB) {
            this.hrB = true;
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
            this.hrM.f(this);
            this.hrM.a(mvcHttpResponsedMessage);
            this.hrM.a(mvcHttpMessage);
            this.hrM.a(mvcNetMessage);
            Looper.myQueue().addIdleHandler(this.hrM);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.gIu = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.kQc = mvcHttpResponsedMessage.getDownSize();
            this.hqk = fVar;
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
                this.hri.a(errorData);
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
        if (!this.hrB) {
            this.hrB = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bOS() {
        if (this.gXO != null && this.gXO.getForum() != null && this.gXO.getForum().getBannerListData() != null) {
            String lastIds = this.gXO.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.hql = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aZA().aZB()) {
            this.edP = System.currentTimeMillis() - this.hri.gAV;
            this.hri.edO = System.currentTimeMillis() - this.hri.gYu;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, this.hri.edE, this.hri.createTime, this.hri.edO, false, this.hri.edF, this.hri.edL, this.edP);
            this.hri.createTime = 0L;
            this.hri.edE = 0L;
            com.baidu.tieba.frs.f.h.a(this, this.hri.gAV);
            this.hri.gAV = -1L;
            iVar.aZx();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aZA().aZB()) {
            this.edP = System.currentTimeMillis() - this.hri.gYv;
            this.hri.edO = System.currentTimeMillis() - this.hri.gYu;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1000, z, responsedMessage, this.hri.edE, this.hri.createTime, this.hri.edO, false, this.hri.edF, this.hri.edL, this.edP);
            if (this.mType == 4) {
                iVar.edX = this.edP;
                iVar.hS(true);
            } else if (this.mType == 3) {
                iVar.edY = this.edP;
                iVar.hS(false);
            }
        }
    }

    public FrsRequestData bTQ() {
        return this.hro;
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

    public FrsViewData bTw() {
        return this.gXO;
    }

    public com.baidu.tieba.tbadkCore.f bTR() {
        return this.hqk;
    }

    private boolean bTS() {
        this.gDS = System.currentTimeMillis();
        return this.hqi.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.gXO.receiveData(mVar);
        d(this.gXO);
        this.hrn = new ArrayList<>();
        if (this.gXO.getThreadList() != null) {
            this.hrn.addAll(this.gXO.getThreadList());
        }
        this.hrp.c(mVar);
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
        private String aZD;
        private FrsModelController hrR;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.aZD = null;
            this.aZD = str;
            this.hrR = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.cVs().KA(this.aZD)) {
                if (!com.baidu.tieba.tbadkCore.e.cVs().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.aZD)) {
                    com.baidu.tieba.tbadkCore.e.cVs().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.cVs().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().aIP(), true) && !responseData.getBookInfo().aIP().equals("0") && responseData.getBookInfo().aIQ() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().aIP(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.hrR != null && mVarArr != null) {
                this.hrR.e(mVarArr.length > 0 ? mVarArr[0] : null);
                this.hrR.I(this.hrR.hrD, true);
            }
        }
    }

    public long bIV() {
        return this.gDV;
    }

    public long bIW() {
        return this.gDT;
    }

    public long bIX() {
        return this.gDU;
    }

    public long bIY() {
        return this.gDS;
    }

    public boolean isLoading() {
        return this.hqi.isLoading();
    }

    public int bTT() {
        return this.hru;
    }

    private void bTU() {
        if (this.hrA == null) {
            this.hrA = new ArrayList<>();
        }
        if (this.hrA.size() == 0) {
            this.hrA.add(new z());
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, as asVar) {
        this.hky = c(i, null);
        if (asVar == null && (asVar = bX(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.hrz != null) {
                av avVar = new av();
                avVar.hasMore = false;
                avVar.pn = 1;
                avVar.forumName = this.gYi;
                avVar.hcv = false;
                if (this.gXO != null && this.gXO.getForum() != null) {
                    avVar.forumId = this.gXO.getForum().getId();
                }
                bTU();
                this.gXO.setThreadList(this.hrA);
                this.hrz.a(i, i2, avVar, this.hrA);
            }
            asVar = new as();
            asVar.pn = -1;
        }
        if (this.gXO != null && this.gXO.getForum() != null) {
            asVar.forumId = this.gXO.getForum().getId();
        }
        asVar.forumName = this.gYi;
        if (ab.bQq().ty(1) != null && this.hky == 1) {
            this.hro.setCategoryId(i2);
        }
        this.hrt = i2;
        this.hrv = asVar;
        b(i, i2, asVar);
        um(5);
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(ao aoVar) {
        this.hrz = aoVar;
        this.hry.a(this.hrN);
    }

    private void um(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.hrv != null) {
                    this.hrv.pn++;
                    break;
                }
                break;
            case 2:
                if (this.hrv != null) {
                    as asVar = this.hrv;
                    asVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.hrv != null) {
                    this.hrv.pn = -1;
                    break;
                }
                break;
        }
        if (this.hky == 1) {
            if (this.hru == this.hrt) {
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
                if (this.hrn != null) {
                    arrayList.addAll(this.hrn);
                }
                this.gXO.setThreadList(arrayList);
                if (this.hrz != null) {
                    this.hrz.a(this.hky, this.hrt, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.hru = this.hrt;
            return;
        }
        ak tz = this.hry.tz(this.hky);
        if (tz != null) {
            this.hrw = true;
            tz.a(this.hky, this.hrt, this.hrv);
            return;
        }
        if (this.gXO != null && this.gXO.getThreadList() != null) {
            this.gXO.getThreadList().clear();
        }
        this.hrz.a(this.hky, this.hrt, null, null);
    }

    public boolean hasMore() {
        if ((this.hrv instanceof av) && ((av) this.hrv).errCode == 0) {
            return ((av) this.hrv).hasMore;
        }
        return true;
    }

    private int bW(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, as asVar) {
        this.hrx.put(bW(i, i2), asVar);
    }

    public as bX(int i, int i2) {
        return this.hrx.get(bW(i, i2));
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        this.hry.init();
    }

    @Override // com.baidu.tieba.frs.ak
    public void bqt() {
        this.hry.destory();
        this.hry.clear();
    }

    public int bTV() {
        return this.hky;
    }

    public boolean bTW() {
        return 1 == this.hky;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(am amVar) {
        if (amVar != null && !StringUtils.isNull(amVar.getId()) && !v.isEmpty(this.hrn)) {
            if (this.hky == 1) {
                this.gXO.addMyNewThread(amVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<com.baidu.adp.widget.ListView.m> it = this.hrn.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if ((next instanceof bi) && amVar.getId().equals(((bi) next).dqA.getId())) {
                    return;
                }
            }
            this.hrn.add(topThreadSize, amVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.hrn == null || this.hrn.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.m> it = this.hrn.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (!(next instanceof bi)) {
                    i = i2;
                } else if (((bi) next).dqA.aKz() != 0) {
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

    public boolean bTX() {
        return this.hrw;
    }

    public void bTY() {
        p pVar = new p();
        if (this.hru == 0) {
            pVar.ts(this.hrD);
        }
        if (this.gXO.getThreadList() != null) {
            this.gXO.getThreadList().clear();
            this.gXO.getThreadList().add(pVar);
        }
        if (this.hrn != null) {
            this.hrn.clear();
            this.hrn.add(pVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> bTZ() {
        return this.hrn;
    }

    public void ur(int i) {
        AccountData currentAccountObj;
        this.hrD = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.f.g.aM("1~" + str + this.gYi, this.hrD);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cXr();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cXs();
        }
    }

    public void us(int i) {
        this.hrE = i;
    }

    public void nh(boolean z) {
        this.hrG = z;
    }

    public int bUa() {
        return this.hrD;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.uI(this.hrD);
    }

    public boolean bUb() {
        return this.hrq;
    }

    public boolean bUc() {
        return this.hrD == 5;
    }

    public boolean bUd() {
        return this.hro != null && this.hro.getLoadType() == 1;
    }

    public boolean bUe() {
        return this.hrD == 7 || (!this.hrK && this.hrF == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.hri.bOo() != null) {
            return this.hri.bOo().a(this.hrD, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bj.drk.get() && com.baidu.tieba.recapp.q.cNo().cNi() != null) {
            int aD = com.baidu.tieba.recapp.q.cNo().cNi().aD(str, false);
            int aE = com.baidu.tieba.recapp.q.cNo().cNi().aE(str, false);
            if (frsRequestData.getLoadType() == 1) {
                aD++;
            } else if (frsRequestData.getLoadType() == 2) {
                aE++;
            }
            frsRequestData.setRefreshCount(aD);
            frsRequestData.setLoadCount(aE);
        }
    }

    public void bUf() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.gXO != null && this.gXO.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.gXO.getForum().getId(), 0L));
        }
        this.hri.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void Do(final String str) {
        ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.cVs().eL(FrsModelController.this.hrH, str);
                return null;
            }
        }, null);
    }

    public void Dp(final String str) {
        ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.cVs().eM(FrsModelController.this.hrH, str);
                return null;
            }
        }, null);
    }

    public void Dq(final String str) {
        ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.cVs().eN(FrsModelController.this.hrH, str);
                return null;
            }
        }, null);
    }

    public void ni(boolean z) {
        this.hrJ = z;
    }
}
