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
    private long gSH;
    private long gSI;
    private long gSJ;
    private long gSK;
    private FrsNetModel<FrsFragment> hFc;
    private com.baidu.tieba.tbadkCore.f hFe;
    private String hFf;
    private boolean hGA;
    private String hGB;
    private final SparseArray<Boolean> hGC;
    private boolean hGD;
    private boolean hGE;
    private n hGF;
    private m hGG;
    private ao hGH;
    private final FrsFragment hGd;
    private ArrayList<o> hGi;
    private FrsRequestData hGj;
    private final q hGk;
    private boolean hGl;
    private int hGm;
    private long hGn;
    private int hGo;
    private int hGp;
    private as hGq;
    private boolean hGr;
    private SparseArray<as> hGs;
    private ad hGt;
    private ao hGu;
    private ArrayList<o> hGv;
    private String hGw;
    private int hGx;
    private int hGy;
    private int hGz;
    private FrsViewData hmG;
    private String hna;
    private int hzs;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSchemeUrl;
    private String mSource;
    private int mType;

    public boolean uW(int i) {
        return this.hGC.get(i, false).booleanValue();
    }

    public void L(int i, boolean z) {
        this.hGC.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, q qVar) {
        super(frsFragment.getPageContext());
        this.hna = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.hGm = 0;
        this.mSchemeUrl = "";
        this.mSource = null;
        this.hFf = null;
        this.hGn = 0L;
        this.hzs = 1;
        this.hGo = 0;
        this.hGp = 0;
        this.hGr = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.hGs = new SparseArray<>();
        this.esh = 0L;
        this.dJC = false;
        this.hGx = -1;
        this.hGy = -1;
        this.hGz = -1;
        this.hGB = null;
        this.hGC = new SparseArray<>();
        this.hGF = new n();
        this.hGG = new m();
        this.hGH = new ao() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ao
            public void a(int i, int i2, av avVar, ArrayList<o> arrayList) {
                FrsModelController.this.hGr = false;
                if (i == FrsModelController.this.hzs && FrsModelController.this.hGu != null) {
                    FrsModelController.this.hGq = avVar;
                    FrsModelController.this.b(i, i2, avVar);
                    ArrayList<o> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.hmG.setThreadList(arrayList2);
                    FrsModelController.this.hGu.a(i, i2, avVar, arrayList);
                }
            }
        };
        this.gSH = 0L;
        this.gSI = 0L;
        this.gSJ = 0L;
        this.gSK = 0L;
        if (qVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.hGd = frsFragment;
        this.hGk = qVar;
        O(this.hGd);
    }

    private void O(FrsFragment frsFragment) {
        this.hGt = new ad();
        this.hGt.epM = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.hGt));
        this.hGt.a(this.hGH);
    }

    public void bZP() {
        Looper.myQueue().removeIdleHandler(this.hGF);
        Looper.myQueue().removeIdleHandler(this.hGG);
        this.hFc.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.hna = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.hGw = bundle.getString("yuelaou_locate");
            this.hGl = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.hGm = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
            this.hGn = bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
            this.hGd.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.hna)) {
            this.hna = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.hGw)) {
            this.hGw = "";
        }
        this.mSource = this.mFrom;
        caj();
        this.hmG = new FrsViewData();
        this.hGj.fp("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.hna));
        this.hGj.fp("client_type", "2");
        if (this.hFc == null) {
            this.hFc = new FrsNetModel<>(this.hGd.getPageContext(), this.hGj);
        }
        this.hFc.a(this);
        this.hFc.setUniqueId(this.hGd.getPageContext().getUniqueId());
        if (this.hna != null && this.hna.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.hna);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void caj() {
        AccountData currentAccountObj;
        this.hGj = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            uX(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            uX(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            this.hGz = com.baidu.tieba.frs.f.g.Fh("1~" + str + this.hna);
            uX(this.hGx);
        }
        this.hGj.setSortType(getSortType());
        if (this.hGx == 5) {
            this.hGj.setIsGood(1);
        } else {
            this.hGj.setIsGood(0);
        }
    }

    public boolean bLY() {
        if (this.hzs != 1) {
            uR(1);
            return true;
        } else if (this.hFc.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.hGj), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void M(int i, boolean z) {
        this.hGd.hnn = System.currentTimeMillis();
        if (this.hmG != null && this.hmG.getLikeFeedForumDataList() != null) {
            this.hmG.getLikeFeedForumDataList().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.hGj), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.hzs = c(this.hzs, frsRequestData);
        if (this.hzs == 1) {
            if (!this.hFc.isLoading()) {
                frsRequestData.setCallFrom(this.hGm);
                a(frsRequestData, i, z ? false : true);
                this.hGm = 0;
                return;
            }
            return;
        }
        if (this.hGq == null) {
            this.hGq = new as();
            this.hGq.pn = 1;
            this.hGq.forumName = this.hna;
            if (this.hmG != null && this.hmG.getForum() != null) {
                this.hGq.forumId = this.hmG.getForum().getId();
            }
        }
        uR(i);
    }

    public void uS(int i) {
        if (this.hzs != 1) {
            uR(4);
        } else if (!this.hFc.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.hGj), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.hGd.mL(z);
        this.hGk.tK(i);
        this.hFc.a(frsRequestData);
        this.mType = i;
        frsRequestData.Mr(this.hGd.bVv() ? "1" : "2");
        if (this.hGA) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.vo(this.hGy)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.hGA = false;
        frsRequestData.setKw(this.hna);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = ar.aUW().aUX() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setSchemeUrl(this.mSchemeUrl);
        frsRequestData.setLastId(this.hFf);
        frsRequestData.setYuelaouLocate(this.hGw);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ab.bgN(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.DN(cak());
        if (FrsFragment.hno != 0) {
            frsRequestData.setCtime((int) FrsFragment.hno);
        }
        if (FrsFragment.hnp != 0) {
            frsRequestData.setDataSize((int) FrsFragment.hnp);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.fq(this.hGn);
        if (this.hGn != 0) {
            this.hGn = 0L;
        }
        com.baidu.tieba.frs.f.g.a(this.hGx, frsRequestData);
        int vo = com.baidu.tieba.frs.f.g.vo(this.hGz);
        b(i, frsRequestData);
        a(this.hna, frsRequestData);
        if (!uW(this.hGz) && !this.hGd.hnb && !this.hGD) {
            String e = com.baidu.tieba.tbadkCore.e.dcu().e("1~" + this.hna, vo, frsRequestData.getIsGood(), this.hGj.getCategoryId());
            this.hGB = e;
            new a(this, true, e).execute(new Object[0]);
        }
        this.hGE = can();
        this.hGD = false;
    }

    private int cak() {
        return (this.hGd == null || !(this.hGd.mHeadLineDefaultNavTabId == -1 || this.hGd.mHeadLineDefaultNavTabId == this.hzs)) ? 0 : 1;
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
            this.hGd.esd = mVar.getDataParseTime();
        }
        uX(com.baidu.tieba.frs.f.g.vp(mVar.getSortType()));
        L(com.baidu.tieba.frs.f.g.vp(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.hzs = mVar.getFrsDefaultTabId();
        }
        this.hmG.receiveData(mVar);
        d(this.hmG);
        this.hGi = new ArrayList<>();
        if (frsRequestData != null) {
            this.hGj = frsRequestData;
            this.mPn = this.hGj.getPn();
            this.hna = this.hGj.getKw();
            this.hGd.setForumName(this.hna);
            this.hGd.setFrom(this.mFrom);
            this.hGd.setPn(this.mPn);
            this.hGd.setFlag(this.mFlag);
        }
        if (this.hmG.getThreadList() != null) {
            this.hGi.addAll(this.hmG.getThreadList());
        }
        if (this.hzs != 1 && this.isNetFirstLoad) {
            this.hGk.a(7, false, this.hFe);
        } else {
            this.hGk.a(this.mType, false, this.hFe);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.hGj)) {
            caB();
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() == null || TextUtils.isEmpty(mVar.getForum().getName()) || frsRequestData == null || com.baidu.tieba.recapp.q.cUm().cUg() == null) {
            return true;
        }
        com.baidu.tieba.recapp.q.cUm().cUg().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        if (mvcSocketResponsedMessage != null) {
            this.hGF.f(this);
            this.hGF.a(mvcSocketResponsedMessage);
            this.hGF.a(mvcSocketMessage);
            this.hGF.a(mvcNetMessage);
            Looper.myQueue().addIdleHandler(this.hGF);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.gXl = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.liw = mvcSocketResponsedMessage.getDownSize();
            this.hFe = fVar;
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
                this.hGd.a(errorData);
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
            this.hGG.f(this);
            this.hGG.a(mvcHttpResponsedMessage);
            this.hGG.a(mvcHttpMessage);
            this.hGG.a(mvcNetMessage);
            Looper.myQueue().addIdleHandler(this.hGG);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.gXl = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.liw = mvcHttpResponsedMessage.getDownSize();
            this.hFe = fVar;
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
                this.hGd.a(errorData);
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

    public void bVm() {
        if (this.hmG != null && this.hmG.getForum() != null && this.hmG.getForum().getBannerListData() != null) {
            String lastIds = this.hmG.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.hFf = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.bfI().bfJ()) {
            this.esh = System.currentTimeMillis() - this.hGd.gPK;
            this.hGd.esg = System.currentTimeMillis() - this.hGd.hnm;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, this.hGd.erW, this.hGd.createTime, this.hGd.esg, false, this.hGd.erX, this.hGd.esd, this.esh);
            this.hGd.createTime = 0L;
            this.hGd.erW = 0L;
            com.baidu.tieba.frs.f.h.a(this, this.hGd.gPK);
            this.hGd.gPK = -1L;
            iVar.bfF();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.bfI().bfJ()) {
            this.esh = System.currentTimeMillis() - this.hGd.hnn;
            this.hGd.esg = System.currentTimeMillis() - this.hGd.hnm;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1000, z, responsedMessage, this.hGd.erW, this.hGd.createTime, this.hGd.esg, false, this.hGd.erX, this.hGd.esd, this.esh);
            if (this.mType == 4) {
                iVar.esp = this.esh;
                iVar.io(true);
            } else if (this.mType == 3) {
                iVar.esq = this.esh;
                iVar.io(false);
            }
        }
    }

    public FrsRequestData cal() {
        return this.hGj;
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

    public FrsViewData bZR() {
        return this.hmG;
    }

    public com.baidu.tieba.tbadkCore.f cam() {
        return this.hFe;
    }

    private boolean can() {
        this.gSH = System.currentTimeMillis();
        return this.hFc.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.hmG.receiveData(mVar);
        d(this.hmG);
        this.hGi = new ArrayList<>();
        if (this.hmG.getThreadList() != null) {
            this.hGi.addAll(this.hmG.getThreadList());
        }
        this.hGk.c(mVar);
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
        private FrsModelController hGL;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.bhf = null;
            this.bhf = str;
            this.hGL = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.dcu().Mp(this.bhf)) {
                if (!com.baidu.tieba.tbadkCore.e.dcu().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.bhf)) {
                    com.baidu.tieba.tbadkCore.e.dcu().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.dcu().getResponseData();
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
            if (this.hGL != null && mVarArr != null) {
                this.hGL.e(mVarArr.length > 0 ? mVarArr[0] : null);
                this.hGL.L(this.hGL.hGx, true);
            }
        }
    }

    public long bPn() {
        return this.gSK;
    }

    public long bPo() {
        return this.gSI;
    }

    public long bPp() {
        return this.gSJ;
    }

    public long bPq() {
        return this.gSH;
    }

    public boolean isLoading() {
        return this.hFc.isLoading();
    }

    public int cao() {
        return this.hGp;
    }

    private void cap() {
        if (this.hGv == null) {
            this.hGv = new ArrayList<>();
        }
        if (this.hGv.size() == 0) {
            this.hGv.add(new z());
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, as asVar) {
        this.hzs = c(i, null);
        if (asVar == null && (asVar = cc(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.hGu != null) {
                av avVar = new av();
                avVar.hasMore = false;
                avVar.pn = 1;
                avVar.forumName = this.hna;
                avVar.hrp = false;
                if (this.hmG != null && this.hmG.getForum() != null) {
                    avVar.forumId = this.hmG.getForum().getId();
                }
                cap();
                this.hmG.setThreadList(this.hGv);
                this.hGu.a(i, i2, avVar, this.hGv);
            }
            asVar = new as();
            asVar.pn = -1;
        }
        if (this.hmG != null && this.hmG.getForum() != null) {
            asVar.forumId = this.hmG.getForum().getId();
        }
        asVar.forumName = this.hna;
        if (com.baidu.tieba.frs.ab.bWL().ud(1) != null && this.hzs == 1) {
            this.hGj.setCategoryId(i2);
        }
        this.hGo = i2;
        this.hGq = asVar;
        b(i, i2, asVar);
        uR(5);
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(ao aoVar) {
        this.hGu = aoVar;
        this.hGt.a(this.hGH);
    }

    private void uR(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.hGq != null) {
                    this.hGq.pn++;
                    break;
                }
                break;
            case 2:
                if (this.hGq != null) {
                    as asVar = this.hGq;
                    asVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.hGq != null) {
                    this.hGq.pn = -1;
                    break;
                }
                break;
        }
        if (this.hzs == 1) {
            if (this.hGp == this.hGo) {
                ArrayList<o> arrayList = new ArrayList<>();
                if (this.hGi != null) {
                    arrayList.addAll(this.hGi);
                }
                this.hmG.setThreadList(arrayList);
                if (this.hGu != null) {
                    this.hGu.a(this.hzs, this.hGo, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.hGp = this.hGo;
            return;
        }
        ak ue = this.hGt.ue(this.hzs);
        if (ue != null) {
            this.hGr = true;
            ue.a(this.hzs, this.hGo, this.hGq);
            return;
        }
        if (this.hmG != null && this.hmG.getThreadList() != null) {
            this.hmG.getThreadList().clear();
        }
        this.hGu.a(this.hzs, this.hGo, null, null);
    }

    public boolean hasMore() {
        if ((this.hGq instanceof av) && ((av) this.hGq).errCode == 0) {
            return ((av) this.hGq).hasMore;
        }
        return true;
    }

    private int cb(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, as asVar) {
        this.hGs.put(cb(i, i2), asVar);
    }

    public as cc(int i, int i2) {
        return this.hGs.get(cb(i, i2));
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        this.hGt.init();
    }

    @Override // com.baidu.tieba.frs.ak
    public void bwi() {
        this.hGt.destory();
        this.hGt.clear();
    }

    public int caq() {
        return this.hzs;
    }

    public boolean car() {
        return 1 == this.hzs;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(al alVar) {
        if (alVar != null && !StringUtils.isNull(alVar.getId()) && !v.isEmpty(this.hGi)) {
            if (this.hzs == 1) {
                this.hmG.addMyNewThread(alVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<o> it = this.hGi.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if ((next instanceof bj) && alVar.getId().equals(((bj) next).dEA.getId())) {
                    return;
                }
            }
            this.hGi.add(topThreadSize, alVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.hGi == null || this.hGi.size() <= 0) {
            return 0;
        }
        Iterator<o> it = this.hGi.iterator();
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

    public boolean cas() {
        return this.hGr;
    }

    public void cat() {
        p pVar = new p();
        if (this.hGp == 0) {
            pVar.tX(this.hGx);
        }
        if (this.hmG.getThreadList() != null) {
            this.hmG.getThreadList().clear();
            this.hmG.getThreadList().add(pVar);
        }
        if (this.hGi != null) {
            this.hGi.clear();
            this.hGi.add(pVar);
        }
    }

    public ArrayList<o> cau() {
        return this.hGi;
    }

    public void uX(int i) {
        AccountData currentAccountObj;
        this.hGx = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.f.g.aN("1~" + str + this.hna, this.hGx);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.deD();
        } else {
            com.baidu.tieba.tbadkCore.util.e.deE();
        }
    }

    public void uY(int i) {
        this.hGy = i;
    }

    public void nC(boolean z) {
        this.hGA = z;
    }

    public int cav() {
        return this.hGx;
    }

    public int caw() {
        return this.hGz;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.vo(this.hGx);
    }

    public boolean cax() {
        return this.hGl;
    }

    public boolean cay() {
        return this.hGx == 5;
    }

    public boolean caz() {
        return this.hGj != null && this.hGj.getLoadType() == 1;
    }

    public boolean caA() {
        return this.hGx == 7 || (!this.hGE && this.hGz == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.hGd.bUI() != null) {
            return this.hGd.bUI().a(this.hGx, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bk.dFk.get() && com.baidu.tieba.recapp.q.cUm().cUg() != null) {
            int aQ = com.baidu.tieba.recapp.q.cUm().cUg().aQ(str, false);
            int aR = com.baidu.tieba.recapp.q.cUm().cUg().aR(str, false);
            if (frsRequestData.getLoadType() == 1) {
                aQ++;
            } else if (frsRequestData.getLoadType() == 2) {
                aR++;
            }
            frsRequestData.setRefreshCount(aQ);
            frsRequestData.setLoadCount(aR);
        }
    }

    public void caB() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.hmG != null && this.hmG.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.hmG.getForum().getId(), 0L));
        }
        this.hGd.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void Fa(final String str) {
        com.baidu.tbadk.util.ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dcu().fm(FrsModelController.this.hGB, str);
                return null;
            }
        }, null);
    }

    public void Fb(final String str) {
        com.baidu.tbadk.util.ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dcu().fn(FrsModelController.this.hGB, str);
                return null;
            }
        }, null);
    }

    public void Fc(final String str) {
        com.baidu.tbadk.util.ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dcu().fo(FrsModelController.this.hGB, str);
                return null;
            }
        }, null);
    }

    public void nD(boolean z) {
        this.hGD = z;
    }
}
