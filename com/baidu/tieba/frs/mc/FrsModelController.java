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
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.frs.w;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.q;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.m>, ah {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long dEi;
    private long fXo;
    private long fXp;
    private long fXq;
    private long fXr;
    private int gBc;
    private FrsNetModel<FrsFragment> gGP;
    private com.baidu.tieba.tbadkCore.f gGR;
    private String gGS;
    private final FrsFragment gHP;
    private ArrayList<com.baidu.adp.widget.ListView.m> gHU;
    private FrsRequestData gHV;
    private final q gHW;
    private boolean gHX;
    private int gHY;
    private long gHZ;
    private int gIa;
    private int gIb;
    private ao gIc;
    private boolean gId;
    private SparseArray<ao> gIe;
    private aa gIf;
    private ak gIg;
    private ArrayList<com.baidu.adp.widget.ListView.m> gIh;
    private boolean gIi;
    private String gIj;
    private int gIk;
    private int gIl;
    private int gIm;
    private boolean gIn;
    private String gIo;
    private final SparseArray<Boolean> gIp;
    private boolean gIq;
    private boolean gIr;
    private n gIs;
    private m gIt;
    private ak gIu;
    private FrsViewData goJ;
    private String gpb;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean tS(int i) {
        return this.gIp.get(i, false).booleanValue();
    }

    public void E(int i, boolean z) {
        this.gIp.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, q qVar) {
        super(frsFragment.getPageContext());
        this.gpb = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.gHY = 0;
        this.mSource = null;
        this.gGS = null;
        this.gHZ = 0L;
        this.gBc = 1;
        this.gIa = 0;
        this.gIb = 0;
        this.gId = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.gIe = new SparseArray<>();
        this.dEi = 0L;
        this.gIi = false;
        this.gIk = -1;
        this.gIl = -1;
        this.gIm = -1;
        this.gIo = null;
        this.gIp = new SparseArray<>();
        this.gIs = new n();
        this.gIt = new m();
        this.gIu = new ak() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ak
            public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
                FrsModelController.this.gId = false;
                if (i == FrsModelController.this.gBc && FrsModelController.this.gIg != null) {
                    FrsModelController.this.gIc = arVar;
                    FrsModelController.this.b(i, i2, arVar);
                    ArrayList<com.baidu.adp.widget.ListView.m> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.goJ.setThreadList(arrayList2);
                    FrsModelController.this.gIg.a(i, i2, arVar, arrayList);
                }
            }
        };
        this.fXo = 0L;
        this.fXp = 0L;
        this.fXq = 0L;
        this.fXr = 0L;
        if (qVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.gHP = frsFragment;
        this.gHW = qVar;
        N(this.gHP);
    }

    private void N(FrsFragment frsFragment) {
        this.gIf = new aa();
        this.gIf.dBK = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.gIf));
        this.gIf.a(this.gIu);
    }

    public void aiL() {
        Looper.myQueue().removeIdleHandler(this.gIs);
        Looper.myQueue().removeIdleHandler(this.gIt);
        this.gGP.cancelLoadData();
    }

    public void ad(Bundle bundle) {
        if (bundle != null) {
            this.gpb = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.gIj = bundle.getString("yuelaou_locate");
            this.gHX = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.gHY = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.gHZ = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.gHP.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.gpb)) {
            this.gpb = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.gIj)) {
            this.gIj = "";
        }
        this.mSource = this.mFrom;
        bJr();
        this.goJ = new FrsViewData();
        this.gHV.ez("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.gpb));
        this.gHV.ez("client_type", "2");
        if (this.gGP == null) {
            this.gGP = new FrsNetModel<>(this.gHP.getPageContext(), this.gHV);
        }
        this.gGP.a(this);
        this.gGP.setUniqueId(this.gHP.getPageContext().getUniqueId());
        if (this.gpb != null && this.gpb.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.gpb);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void bJr() {
        AccountData currentAccountObj;
        this.gHV = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            tT(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            tT(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            this.gIm = com.baidu.tieba.frs.f.g.BM("1~" + str + this.gpb);
            tT(this.gIk);
        }
        this.gHV.setSortType(getSortType());
        if (this.gIk == 5) {
            this.gHV.setIsGood(1);
        } else {
            this.gHV.setIsGood(0);
        }
    }

    public boolean bvV() {
        if (this.gBc != 1) {
            tO(1);
            return true;
        } else if (this.gGP.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gHV), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void F(int i, boolean z) {
        this.gHP.gpo = System.currentTimeMillis();
        if (this.goJ != null && this.goJ.getLikeFeedForumDataList() != null) {
            this.goJ.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gHV), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.gBc = c(this.gBc, frsRequestData);
        if (this.gBc == 1) {
            if (!this.gGP.isLoading()) {
                frsRequestData.setCallFrom(this.gHY);
                a(frsRequestData, i, z ? false : true);
                this.gHY = 0;
                return;
            }
            return;
        }
        if (this.gIc == null) {
            this.gIc = new ao();
            this.gIc.pn = 1;
            this.gIc.forumName = this.gpb;
            if (this.goJ != null && this.goJ.getForum() != null) {
                this.gIc.forumId = this.goJ.getForum().getId();
            }
        }
        tO(i);
    }

    public void tP(int i) {
        if (this.gBc != 1) {
            tO(4);
        } else if (!this.gGP.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.gHV), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.gHP.lm(z);
        this.gHW.sI(i);
        this.gGP.a(frsRequestData);
        this.mType = i;
        frsRequestData.IS(this.gHP.bEC() ? "1" : "2");
        if (this.gIn) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.ul(this.gIl)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.gIn = false;
        frsRequestData.setKw(this.gpb);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = com.baidu.tbadk.core.util.ar.aGH().aGI() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.gGS);
        frsRequestData.setYuelaouLocate(this.gIj);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(com.baidu.tbadk.util.aa.aSv(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.Cz(bJs());
        if (FrsFragment.gpp != 0) {
            frsRequestData.setCtime((int) FrsFragment.gpp);
        }
        if (FrsFragment.gpq != 0) {
            frsRequestData.setDataSize((int) FrsFragment.gpq);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.eE(this.gHZ);
        if (this.gHZ != 0) {
            this.gHZ = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.gIk, frsRequestData);
        int ul = com.baidu.tieba.frs.f.g.ul(this.gIm);
        b(i, frsRequestData);
        a(this.gpb, frsRequestData);
        if (!tS(this.gIm) && !this.gHP.gpc && !this.gIq) {
            String e = com.baidu.tieba.tbadkCore.e.cKw().e("1~" + this.gpb, ul, frsRequestData.getIsGood(), this.gHV.getCategoryId());
            this.gIo = e;
            new a(this, true, e).execute(new Object[0]);
        }
        this.gIr = bJv();
        this.gIq = false;
    }

    private int bJs() {
        return (this.gHP == null || !(this.gHP.mHeadLineDefaultNavTabId == -1 || this.gHP.mHeadLineDefaultNavTabId == this.gBc)) ? 0 : 1;
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
            this.gHP.dEe = mVar.getDataParseTime();
        }
        tT(com.baidu.tieba.frs.f.g.um(mVar.getSortType()));
        E(com.baidu.tieba.frs.f.g.um(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.gBc = mVar.getFrsDefaultTabId();
        }
        this.goJ.receiveData(mVar);
        d(this.goJ);
        this.gHU = new ArrayList<>();
        if (frsRequestData != null) {
            this.gHV = frsRequestData;
            this.mPn = this.gHV.getPn();
            this.gpb = this.gHV.getKw();
            this.gHP.setForumName(this.gpb);
            this.gHP.setFrom(this.mFrom);
            this.gHP.setPn(this.mPn);
            this.gHP.setFlag(this.mFlag);
        }
        if (this.goJ.getThreadList() != null) {
            this.gHU.addAll(this.goJ.getThreadList());
        }
        if (this.gBc != 1 && this.isNetFirstLoad) {
            this.gHW.a(7, false, this.gGR);
        } else {
            this.gHW.a(this.mType, false, this.gGR);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.gHV)) {
            bJI();
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() != null && !TextUtils.isEmpty(mVar.getForum().getName()) && frsRequestData != null && r.cCQ().cCK() != null) {
            r.cCQ().cCK().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        com.baidu.tieba.frs.a.bDd().lg(this.gBc == 301);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        if (mvcSocketResponsedMessage != null) {
            this.gIs.f(this);
            this.gIs.a(mvcSocketResponsedMessage);
            this.gIs.a(mvcSocketMessage);
            this.gIs.a(mvcNetMessage);
            Looper.myQueue().addIdleHandler(this.gIs);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.gak = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.kfX = mvcSocketResponsedMessage.getDownSize();
            this.gGR = fVar;
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
                this.gHP.a(errorData);
            }
        }
    }

    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.gIi) {
            this.gIi = true;
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
            this.gIt.f(this);
            this.gIt.a(mvcHttpResponsedMessage);
            this.gIt.a(mvcHttpMessage);
            this.gIt.a(mvcNetMessage);
            Looper.myQueue().addIdleHandler(this.gIt);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.gak = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.kfX = mvcHttpResponsedMessage.getDownSize();
            this.gGR = fVar;
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
                this.gHP.a(errorData);
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
        if (!this.gIi) {
            this.gIi = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bEt() {
        if (this.goJ != null && this.goJ.getForum() != null && this.goJ.getForum().getBannerListData() != null) {
            String lastIds = this.goJ.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.gGS = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aRq().aRr()) {
            this.dEi = System.currentTimeMillis() - this.gHP.fWb;
            this.gHP.dEh = System.currentTimeMillis() - this.gHP.gpn;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, this.gHP.dDX, this.gHP.createTime, this.gHP.dEh, false, this.gHP.dDY, this.gHP.dEe, this.dEi);
            this.gHP.createTime = 0L;
            this.gHP.dDX = 0L;
            com.baidu.tieba.frs.f.h.a(this, this.gHP.fWb);
            this.gHP.fWb = -1L;
            iVar.aRn();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.aRq().aRr()) {
            this.dEi = System.currentTimeMillis() - this.gHP.gpo;
            this.gHP.dEh = System.currentTimeMillis() - this.gHP.gpn;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1000, z, responsedMessage, this.gHP.dDX, this.gHP.createTime, this.gHP.dEh, false, this.gHP.dDY, this.gHP.dEe, this.dEi);
            if (this.mType == 4) {
                iVar.dEq = this.dEi;
                iVar.gU(true);
            } else if (this.mType == 3) {
                iVar.dEr = this.dEi;
                iVar.gU(false);
            }
        }
    }

    public FrsRequestData bJt() {
        return this.gHV;
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

    public FrsViewData bIZ() {
        return this.goJ;
    }

    public com.baidu.tieba.tbadkCore.f bJu() {
        return this.gGR;
    }

    private boolean bJv() {
        this.fXo = System.currentTimeMillis();
        return this.gGP.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.goJ.receiveData(mVar);
        d(this.goJ);
        this.gHU = new ArrayList<>();
        if (this.goJ.getThreadList() != null) {
            this.gHU.addAll(this.goJ.getThreadList());
        }
        this.gHW.c(mVar);
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
        private String gIy;
        private FrsModelController gIz;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.gIy = null;
            this.gIy = str;
            this.gIz = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.cKw().IQ(this.gIy)) {
                if (!com.baidu.tieba.tbadkCore.e.cKw().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.gIy)) {
                    com.baidu.tieba.tbadkCore.e.cKw().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.cKw().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().aAC(), true) && !responseData.getBookInfo().aAC().equals("0") && responseData.getBookInfo().aAD() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().aAC(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.gIz != null && mVarArr != null) {
                this.gIz.h(mVarArr.length > 0 ? mVarArr[0] : null);
                this.gIz.E(this.gIz.gIk, true);
            }
        }
    }

    public long byT() {
        return this.fXr;
    }

    public long byU() {
        return this.fXp;
    }

    public long byV() {
        return this.fXq;
    }

    public long byW() {
        return this.fXo;
    }

    public boolean isLoading() {
        return this.gGP.isLoading();
    }

    public int bJw() {
        return this.gIb;
    }

    private void bJx() {
        if (this.gIh == null) {
            this.gIh = new ArrayList<>();
        }
        if (this.gIh.size() == 0) {
            this.gIh.add(new w());
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void a(int i, int i2, ao aoVar) {
        this.gBc = c(i, null);
        if (aoVar == null && (aoVar = bR(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.gIg != null) {
                ar arVar = new ar();
                arVar.hasMore = false;
                arVar.pn = 1;
                arVar.forumName = this.gpb;
                arVar.gtk = false;
                if (this.goJ != null && this.goJ.getForum() != null) {
                    arVar.forumId = this.goJ.getForum().getId();
                }
                bJx();
                this.goJ.setThreadList(this.gIh);
                this.gIg.a(i, i2, arVar, this.gIh);
            }
            aoVar = new ao();
            aoVar.pn = -1;
        }
        if (this.goJ != null && this.goJ.getForum() != null) {
            aoVar.forumId = this.goJ.getForum().getId();
        }
        aoVar.forumName = this.gpb;
        if (y.bFO().ta(1) != null && this.gBc == 1) {
            this.gHV.setCategoryId(i2);
        }
        this.gIa = i2;
        this.gIc = aoVar;
        b(i, i2, aoVar);
        tO(5);
    }

    @Override // com.baidu.tieba.frs.ah
    public void a(ak akVar) {
        this.gIg = akVar;
        this.gIf.a(this.gIu);
    }

    private void tO(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.gIc != null) {
                    this.gIc.pn++;
                    break;
                }
                break;
            case 2:
                if (this.gIc != null) {
                    ao aoVar = this.gIc;
                    aoVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.gIc != null) {
                    this.gIc.pn = -1;
                    break;
                }
                break;
        }
        if (this.gBc == 1) {
            if (this.gIb == this.gIa) {
                ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
                if (this.gHU != null) {
                    arrayList.addAll(this.gHU);
                }
                this.goJ.setThreadList(arrayList);
                if (this.gIg != null) {
                    this.gIg.a(this.gBc, this.gIa, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.gIb = this.gIa;
            return;
        }
        ah tb = this.gIf.tb(this.gBc);
        if (tb != null) {
            this.gId = true;
            tb.a(this.gBc, this.gIa, this.gIc);
            return;
        }
        if (this.goJ != null && this.goJ.getThreadList() != null) {
            this.goJ.getThreadList().clear();
        }
        this.gIg.a(this.gBc, this.gIa, null, null);
    }

    public boolean hasMore() {
        if ((this.gIc instanceof ar) && ((ar) this.gIc).errCode == 0) {
            return ((ar) this.gIc).hasMore;
        }
        return true;
    }

    private int bQ(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ao aoVar) {
        this.gIe.put(bQ(i, i2), aoVar);
    }

    public ao bR(int i, int i2) {
        return this.gIe.get(bQ(i, i2));
    }

    @Override // com.baidu.tieba.frs.ah
    public void init() {
        this.gIf.init();
    }

    @Override // com.baidu.tieba.frs.ah
    public void bhc() {
        this.gIf.destory();
        this.gIf.clear();
    }

    public int bJy() {
        return this.gBc;
    }

    public boolean bJz() {
        return 1 == this.gBc;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(am amVar) {
        if (amVar != null && !StringUtils.isNull(amVar.getId()) && !v.isEmpty(this.gHU)) {
            if (this.gBc == 1) {
                this.goJ.addMyNewThread(amVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<com.baidu.adp.widget.ListView.m> it = this.gHU.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if ((next instanceof bi) && amVar.getId().equals(((bi) next).cRt.getId())) {
                    return;
                }
            }
            this.gHU.add(topThreadSize, amVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.gHU == null || this.gHU.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.m> it = this.gHU.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.m next = it.next();
                if (!(next instanceof bi)) {
                    i = i2;
                } else if (((bi) next).cRt.aCm() != 0) {
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

    public boolean bJA() {
        return this.gId;
    }

    public void bJB() {
        o oVar = new o();
        if (this.gIb == 0) {
            oVar.sT(this.gIk);
        }
        if (this.goJ.getThreadList() != null) {
            this.goJ.getThreadList().clear();
            this.goJ.getThreadList().add(oVar);
        }
        if (this.gHU != null) {
            this.gHU.clear();
            this.gHU.add(oVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> bJC() {
        return this.gHU;
    }

    public void tT(int i) {
        AccountData currentAccountObj;
        this.gIk = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.f.g.aC("1~" + str + this.gpb, this.gIk);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.cMv();
        } else {
            com.baidu.tieba.tbadkCore.util.e.cMw();
        }
    }

    public void tU(int i) {
        this.gIl = i;
    }

    public void md(boolean z) {
        this.gIn = z;
    }

    public int bJD() {
        return this.gIk;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.ul(this.gIk);
    }

    public boolean bJE() {
        return this.gHX;
    }

    public boolean bJF() {
        return this.gIk == 5;
    }

    public boolean bJG() {
        return this.gHV != null && this.gHV.getLoadType() == 1;
    }

    public boolean bJH() {
        return this.gIk == 7 || (!this.gIr && this.gIm == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.gHP.bDP() != null) {
            return this.gHP.bDP().a(this.gIk, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bj.cSc.get() && r.cCQ().cCK() != null) {
            int ax = r.cCQ().cCK().ax(str, false);
            int ay = r.cCQ().cCK().ay(str, false);
            if (frsRequestData.getLoadType() == 1) {
                ax++;
            } else if (frsRequestData.getLoadType() == 2) {
                ay++;
            }
            frsRequestData.setRefreshCount(ax);
            frsRequestData.setLoadCount(ay);
        }
    }

    public void bJI() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.goJ != null && this.goJ.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.goJ.getForum().getId(), 0L));
        }
        this.gHP.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void BD(final String str) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.cKw().ew(FrsModelController.this.gIo, str);
                return null;
            }
        }, null);
    }

    public void BE(final String str) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.cKw().ex(FrsModelController.this.gIo, str);
                return null;
            }
        }, null);
    }

    public void BF(final String str) {
        ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.cKw().ey(FrsModelController.this.gIo, str);
                return null;
            }
        }, null);
    }

    public void me(boolean z) {
        this.gIq = z;
    }
}
