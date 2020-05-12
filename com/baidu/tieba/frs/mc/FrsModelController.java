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
    private long edU;
    private long gDY;
    private long gDZ;
    private long gEa;
    private long gEb;
    private FrsViewData gXU;
    private String gYo;
    private int hkE;
    private FrsNetModel<FrsFragment> hqo;
    private com.baidu.tieba.tbadkCore.f hqq;
    private String hqr;
    private int hrA;
    private as hrB;
    private boolean hrC;
    private SparseArray<as> hrD;
    private ad hrE;
    private ao hrF;
    private ArrayList<com.baidu.adp.widget.ListView.m> hrG;
    private boolean hrH;
    private String hrI;
    private int hrJ;
    private int hrK;
    private int hrL;
    private boolean hrM;
    private String hrN;
    private final SparseArray<Boolean> hrO;
    private boolean hrP;
    private boolean hrQ;
    private n hrR;
    private m hrS;
    private ao hrT;
    private final FrsFragment hro;
    private ArrayList<com.baidu.adp.widget.ListView.m> hrt;
    private FrsRequestData hru;
    private final q hrv;
    private boolean hrw;
    private int hrx;
    private long hry;
    private int hrz;
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
        return this.hrO.get(i, false).booleanValue();
    }

    public void I(int i, boolean z) {
        this.hrO.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, q qVar) {
        super(frsFragment.getPageContext());
        this.gYo = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.hrx = 0;
        this.mSchemeUrl = "";
        this.mSource = null;
        this.hqr = null;
        this.hry = 0L;
        this.hkE = 1;
        this.hrz = 0;
        this.hrA = 0;
        this.hrC = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.hrD = new SparseArray<>();
        this.edU = 0L;
        this.hrH = false;
        this.hrJ = -1;
        this.hrK = -1;
        this.hrL = -1;
        this.hrN = null;
        this.hrO = new SparseArray<>();
        this.hrR = new n();
        this.hrS = new m();
        this.hrT = new ao() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ao
            public void a(int i, int i2, av avVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
                FrsModelController.this.hrC = false;
                if (i == FrsModelController.this.hkE && FrsModelController.this.hrF != null) {
                    FrsModelController.this.hrB = avVar;
                    FrsModelController.this.b(i, i2, avVar);
                    ArrayList<com.baidu.adp.widget.ListView.m> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.gXU.setThreadList(arrayList2);
                    FrsModelController.this.hrF.a(i, i2, avVar, arrayList);
                }
            }
        };
        this.gDY = 0L;
        this.gDZ = 0L;
        this.gEa = 0L;
        this.gEb = 0L;
        if (qVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.hro = frsFragment;
        this.hrv = qVar;
        M(this.hro);
    }

    private void M(FrsFragment frsFragment) {
        this.hrE = new ad();
        this.hrE.ebA = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.hrE));
        this.hrE.a(this.hrT);
    }

    public void aqS() {
        Looper.myQueue().removeIdleHandler(this.hrR);
        Looper.myQueue().removeIdleHandler(this.hrS);
        this.hqo.cancelLoadData();
    }

    public void ad(Bundle bundle) {
        if (bundle != null) {
            this.gYo = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.hrI = bundle.getString("yuelaou_locate");
            this.hrw = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.hrx = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.hry = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.hro.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.gYo)) {
            this.gYo = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.hrI)) {
            this.hrI = "";
        }
        this.mSource = this.mFrom;
        bTN();
        this.gXU = new FrsViewData();
        this.hru.eO("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.gYo));
        this.hru.eO("client_type", "2");
        if (this.hqo == null) {
            this.hqo = new FrsNetModel<>(this.hro.getPageContext(), this.hru);
        }
        this.hqo.a(this);
        this.hqo.setUniqueId(this.hro.getPageContext().getUniqueId());
        if (this.gYo != null && this.gYo.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.gYo);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void bTN() {
        AccountData currentAccountObj;
        this.hru = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            ur(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            ur(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            this.hrL = com.baidu.tieba.frs.f.g.Dy("1~" + str + this.gYo);
            ur(this.hrJ);
        }
        this.hru.setSortType(getSortType());
        if (this.hrJ == 5) {
            this.hru.setIsGood(1);
        } else {
            this.hru.setIsGood(0);
        }
    }

    public boolean bFF() {
        if (this.hkE != 1) {
            um(1);
            return true;
        } else if (this.hqo.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.hru), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void J(int i, boolean z) {
        this.hro.gYB = System.currentTimeMillis();
        if (this.gXU != null && this.gXU.getLikeFeedForumDataList() != null) {
            this.gXU.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.hru), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.hkE = c(this.hkE, frsRequestData);
        if (this.hkE == 1) {
            if (!this.hqo.isLoading()) {
                frsRequestData.setCallFrom(this.hrx);
                a(frsRequestData, i, z ? false : true);
                this.hrx = 0;
                return;
            }
            return;
        }
        if (this.hrB == null) {
            this.hrB = new as();
            this.hrB.pn = 1;
            this.hrB.forumName = this.gYo;
            if (this.gXU != null && this.gXU.getForum() != null) {
                this.hrB.forumId = this.gXU.getForum().getId();
            }
        }
        um(i);
    }

    public void un(int i) {
        if (this.hkE != 1) {
            um(4);
        } else if (!this.hqo.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.hru), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.hro.mq(z);
        this.hrv.tf(i);
        this.hqo.a(frsRequestData);
        this.mType = i;
        frsRequestData.KF(this.hro.bPa() ? "1" : "2");
        if (this.hrM) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.uI(this.hrK)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.hrM = false;
        frsRequestData.setKw(this.gYo);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = ar.aOS().aOT() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setSchemeUrl(this.mSchemeUrl);
        frsRequestData.setLastId(this.hqr);
        frsRequestData.setYuelaouLocate(this.hrI);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(aa.baC(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.Dd(bTO());
        if (FrsFragment.gYC != 0) {
            frsRequestData.setCtime((int) FrsFragment.gYC);
        }
        if (FrsFragment.gYD != 0) {
            frsRequestData.setDataSize((int) FrsFragment.gYD);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.fq(this.hry);
        if (this.hry != 0) {
            this.hry = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.hrJ, frsRequestData);
        int uI = com.baidu.tieba.frs.f.g.uI(this.hrL);
        b(i, frsRequestData);
        a(this.gYo, frsRequestData);
        if (!uq(this.hrL) && !this.hro.gYp && !this.hrP) {
            String e = com.baidu.tieba.tbadkCore.e.cVq().e("1~" + this.gYo, uI, frsRequestData.getIsGood(), this.hru.getCategoryId());
            this.hrN = e;
            new a(this, true, e).execute(new Object[0]);
        }
        this.hrQ = bTR();
        this.hrP = false;
    }

    private int bTO() {
        return (this.hro == null || !(this.hro.mHeadLineDefaultNavTabId == -1 || this.hro.mHeadLineDefaultNavTabId == this.hkE)) ? 0 : 1;
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
            this.hro.edQ = mVar.getDataParseTime();
        }
        ur(com.baidu.tieba.frs.f.g.uJ(mVar.getSortType()));
        I(com.baidu.tieba.frs.f.g.uJ(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.hkE = mVar.getFrsDefaultTabId();
        }
        this.gXU.receiveData(mVar);
        d(this.gXU);
        this.hrt = new ArrayList<>();
        if (frsRequestData != null) {
            this.hru = frsRequestData;
            this.mPn = this.hru.getPn();
            this.gYo = this.hru.getKw();
            this.hro.setForumName(this.gYo);
            this.hro.setFrom(this.mFrom);
            this.hro.setPn(this.mPn);
            this.hro.setFlag(this.mFlag);
        }
        if (this.gXU.getThreadList() != null) {
            this.hrt.addAll(this.gXU.getThreadList());
        }
        if (this.hkE != 1 && this.isNetFirstLoad) {
            this.hrv.a(7, false, this.hqq);
        } else {
            this.hrv.a(this.mType, false, this.hqq);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.hru)) {
            bUe();
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() == null || TextUtils.isEmpty(mVar.getForum().getName()) || frsRequestData == null || com.baidu.tieba.recapp.q.cNm().cNg() == null) {
            return true;
        }
        com.baidu.tieba.recapp.q.cNm().cNg().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        if (mvcSocketResponsedMessage != null) {
            this.hrR.f(this);
            this.hrR.a(mvcSocketResponsedMessage);
            this.hrR.a(mvcSocketMessage);
            this.hrR.a(mvcNetMessage);
            Looper.myQueue().addIdleHandler(this.hrR);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.gIA = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.kQg = mvcSocketResponsedMessage.getDownSize();
            this.hqq = fVar;
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
                this.hro.a(errorData);
            }
        }
    }

    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.hrH) {
            this.hrH = true;
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
            this.hrS.f(this);
            this.hrS.a(mvcHttpResponsedMessage);
            this.hrS.a(mvcHttpMessage);
            this.hrS.a(mvcNetMessage);
            Looper.myQueue().addIdleHandler(this.hrS);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.gIA = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.kQg = mvcHttpResponsedMessage.getDownSize();
            this.hqq = fVar;
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
                this.hro.a(errorData);
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
        if (!this.hrH) {
            this.hrH = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bOR() {
        if (this.gXU != null && this.gXU.getForum() != null && this.gXU.getForum().getBannerListData() != null) {
            String lastIds = this.gXU.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.hqr = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aZy().aZz()) {
            this.edU = System.currentTimeMillis() - this.hro.gBb;
            this.hro.edT = System.currentTimeMillis() - this.hro.gYA;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, this.hro.edJ, this.hro.createTime, this.hro.edT, false, this.hro.edK, this.hro.edQ, this.edU);
            this.hro.createTime = 0L;
            this.hro.edJ = 0L;
            com.baidu.tieba.frs.f.h.a(this, this.hro.gBb);
            this.hro.gBb = -1L;
            iVar.aZv();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aZy().aZz()) {
            this.edU = System.currentTimeMillis() - this.hro.gYB;
            this.hro.edT = System.currentTimeMillis() - this.hro.gYA;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1000, z, responsedMessage, this.hro.edJ, this.hro.createTime, this.hro.edT, false, this.hro.edK, this.hro.edQ, this.edU);
            if (this.mType == 4) {
                iVar.eec = this.edU;
                iVar.hS(true);
            } else if (this.mType == 3) {
                iVar.eed = this.edU;
                iVar.hS(false);
            }
        }
    }

    public FrsRequestData bTP() {
        return this.hru;
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

    public FrsViewData bTv() {
        return this.gXU;
    }

    public com.baidu.tieba.tbadkCore.f bTQ() {
        return this.hqq;
    }

    private boolean bTR() {
        this.gDY = System.currentTimeMillis();
        return this.hqo.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.gXU.receiveData(mVar);
        d(this.gXU);
        this.hrt = new ArrayList<>();
        if (this.gXU.getThreadList() != null) {
            this.hrt.addAll(this.gXU.getThreadList());
        }
        this.hrv.c(mVar);
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
        private String aZI;
        private FrsModelController hrX;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.aZI = null;
            this.aZI = str;
            this.hrX = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.cVq().KD(this.aZI)) {
                if (!com.baidu.tieba.tbadkCore.e.cVq().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.aZI)) {
                    com.baidu.tieba.tbadkCore.e.cVq().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.cVq().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().aIN(), true) && !responseData.getBookInfo().aIN().equals("0") && responseData.getBookInfo().aIO() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().aIN(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.hrX != null && mVarArr != null) {
                this.hrX.e(mVarArr.length > 0 ? mVarArr[0] : null);
                this.hrX.I(this.hrX.hrJ, true);
            }
        }
    }

    public long bIU() {
        return this.gEb;
    }

    public long bIV() {
        return this.gDZ;
    }

    public long bIW() {
        return this.gEa;
    }

    public long bIX() {
        return this.gDY;
    }

    public boolean isLoading() {
        return this.hqo.isLoading();
    }

    public int bTS() {
        return this.hrA;
    }

    private void bTT() {
        if (this.hrG == null) {
            this.hrG = new ArrayList<>();
        }
        if (this.hrG.size() == 0) {
            this.hrG.add(new z());
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, as asVar) {
        this.hkE = c(i, null);
        if (asVar == null && (asVar = bX(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.hrF != null) {
                av avVar = new av();
                avVar.hasMore = false;
                avVar.pn = 1;
                avVar.forumName = this.gYo;
                avVar.hcB = false;
                if (this.gXU != null && this.gXU.getForum() != null) {
                    avVar.forumId = this.gXU.getForum().getId();
                }
                bTT();
                this.gXU.setThreadList(this.hrG);
                this.hrF.a(i, i2, avVar, this.hrG);
            }
            asVar = new as();
            asVar.pn = -1;
        }
        if (this.gXU != null && this.gXU.getForum() != null) {
            asVar.forumId = this.gXU.getForum().getId();
        }
        asVar.forumName = this.gYo;
        if (ab.bQp().ty(1) != null && this.hkE == 1) {
            this.hru.setCategoryId(i2);
        }
        this.hrz = i2;
        this.hrB = asVar;
        b(i, i2, asVar);
        um(5);
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(ao aoVar) {
        this.hrF = aoVar;
        this.hrE.a(this.hrT);
    }

    private void um(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.hrB != null) {
                    this.hrB.pn++;
                    break;
                }
                break;
            case 2:
                if (this.hrB != null) {
                    as asVar = this.hrB;
                    asVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.hrB != null) {
                    this.hrB.pn = -1;
                    break;
                }
                break;
        }
        if (this.hkE == 1) {
            if (this.hrA == this.hrz) {
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
                if (this.hrt != null) {
                    arrayList.addAll(this.hrt);
                }
                this.gXU.setThreadList(arrayList);
                if (this.hrF != null) {
                    this.hrF.a(this.hkE, this.hrz, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.hrA = this.hrz;
            return;
        }
        ak tz = this.hrE.tz(this.hkE);
        if (tz != null) {
            this.hrC = true;
            tz.a(this.hkE, this.hrz, this.hrB);
            return;
        }
        if (this.gXU != null && this.gXU.getThreadList() != null) {
            this.gXU.getThreadList().clear();
        }
        this.hrF.a(this.hkE, this.hrz, null, null);
    }

    public boolean hasMore() {
        if ((this.hrB instanceof av) && ((av) this.hrB).errCode == 0) {
            return ((av) this.hrB).hasMore;
        }
        return true;
    }

    private int bW(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, as asVar) {
        this.hrD.put(bW(i, i2), asVar);
    }

    public as bX(int i, int i2) {
        return this.hrD.get(bW(i, i2));
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        this.hrE.init();
    }

    @Override // com.baidu.tieba.frs.ak
    public void bqr() {
        this.hrE.destory();
        this.hrE.clear();
    }

    public int bTU() {
        return this.hkE;
    }

    public boolean bTV() {
        return 1 == this.hkE;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(am amVar) {
        if (amVar != null && !StringUtils.isNull(amVar.getId()) && !v.isEmpty(this.hrt)) {
            if (this.hkE == 1) {
                this.gXU.addMyNewThread(amVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<com.baidu.adp.widget.ListView.m> it = this.hrt.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if ((next instanceof bi) && amVar.getId().equals(((bi) next).dqE.getId())) {
                    return;
                }
            }
            this.hrt.add(topThreadSize, amVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.hrt == null || this.hrt.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.m> it = this.hrt.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (!(next instanceof bi)) {
                    i = i2;
                } else if (((bi) next).dqE.aKx() != 0) {
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

    public boolean bTW() {
        return this.hrC;
    }

    public void bTX() {
        p pVar = new p();
        if (this.hrA == 0) {
            pVar.ts(this.hrJ);
        }
        if (this.gXU.getThreadList() != null) {
            this.gXU.getThreadList().clear();
            this.gXU.getThreadList().add(pVar);
        }
        if (this.hrt != null) {
            this.hrt.clear();
            this.hrt.add(pVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> bTY() {
        return this.hrt;
    }

    public void ur(int i) {
        AccountData currentAccountObj;
        this.hrJ = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.f.g.aM("1~" + str + this.gYo, this.hrJ);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cXp();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cXq();
        }
    }

    public void us(int i) {
        this.hrK = i;
    }

    public void nh(boolean z) {
        this.hrM = z;
    }

    public int bTZ() {
        return this.hrJ;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.uI(this.hrJ);
    }

    public boolean bUa() {
        return this.hrw;
    }

    public boolean bUb() {
        return this.hrJ == 5;
    }

    public boolean bUc() {
        return this.hru != null && this.hru.getLoadType() == 1;
    }

    public boolean bUd() {
        return this.hrJ == 7 || (!this.hrQ && this.hrL == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.hro.bOn() != null) {
            return this.hro.bOn().a(this.hrJ, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bj.dro.get() && com.baidu.tieba.recapp.q.cNm().cNg() != null) {
            int aD = com.baidu.tieba.recapp.q.cNm().cNg().aD(str, false);
            int aE = com.baidu.tieba.recapp.q.cNm().cNg().aE(str, false);
            if (frsRequestData.getLoadType() == 1) {
                aD++;
            } else if (frsRequestData.getLoadType() == 2) {
                aE++;
            }
            frsRequestData.setRefreshCount(aD);
            frsRequestData.setLoadCount(aE);
        }
    }

    public void bUe() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.gXU != null && this.gXU.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.gXU.getForum().getId(), 0L));
        }
        this.hro.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void Dr(final String str) {
        ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.cVq().eL(FrsModelController.this.hrN, str);
                return null;
            }
        }, null);
    }

    public void Ds(final String str) {
        ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.cVq().eM(FrsModelController.this.hrN, str);
                return null;
            }
        }, null);
    }

    public void Dt(final String str) {
        ac.a(new com.baidu.tbadk.util.ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.cVq().eN(FrsModelController.this.hrN, str);
                return null;
            }
        }, null);
    }

    public void ni(boolean z) {
        this.hrP = z;
    }
}
