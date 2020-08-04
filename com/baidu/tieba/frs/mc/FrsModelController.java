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
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.ay;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes16.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.m>, ap {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private boolean dWK;
    private long eHo;
    private FrsViewData hEX;
    private String hFr;
    private int hTo;
    private com.baidu.tieba.tbadkCore.f hZf;
    private String hZg;
    private long hll;
    private long hlm;
    private long hln;
    private long hlo;
    private int iaA;
    private boolean iaB;
    private String iaC;
    private final SparseArray<Boolean> iaD;
    private boolean iaE;
    private n iaF;
    private m iaG;
    private at iaH;
    private final FrsFragment iae;
    private ArrayList<q> iaj;
    private FrsRequestData iak;
    private FrsNetModel ial;
    private final com.baidu.tieba.tbadkCore.q iam;
    private boolean ian;
    private long iao;
    private int iap;
    private int iaq;
    private ay iar;
    private boolean ias;
    private SparseArray<ay> iat;
    private ag iau;
    private at iav;
    private ArrayList<q> iaw;
    private String iax;
    private int iay;
    private int iaz;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSchemeUrl;
    private String mSource;
    private int mType;

    public boolean vV(int i) {
        return this.iaD.get(i, false).booleanValue();
    }

    public void N(int i, boolean z) {
        this.iaD.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, com.baidu.tieba.tbadkCore.q qVar) {
        super(frsFragment.getPageContext());
        this.hFr = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSchemeUrl = "";
        this.mSource = null;
        this.hZg = null;
        this.iao = 0L;
        this.hTo = 1;
        this.iap = 0;
        this.iaq = 0;
        this.ias = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.iat = new SparseArray<>();
        this.eHo = 0L;
        this.dWK = false;
        this.iay = -1;
        this.iaz = -1;
        this.iaA = -1;
        this.iaC = null;
        this.iaD = new SparseArray<>();
        this.iaF = new n();
        this.iaG = new m();
        this.iaH = new at() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.at
            public void a(int i, int i2, bb bbVar, ArrayList<q> arrayList) {
                FrsModelController.this.ias = false;
                if (i == FrsModelController.this.hTo && FrsModelController.this.iav != null) {
                    FrsModelController.this.iar = bbVar;
                    FrsModelController.this.b(i, i2, bbVar);
                    ArrayList<q> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.hEX.setThreadList(arrayList2);
                    FrsModelController.this.iav.a(i, i2, bbVar, arrayList);
                }
            }
        };
        this.hll = 0L;
        this.hlm = 0L;
        this.hln = 0L;
        this.hlo = 0L;
        if (qVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.iae = frsFragment;
        this.iam = qVar;
        if (this.iae.getActivity() instanceof FrsActivity) {
            this.ial = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.iae.getActivity()).getUniqueId().getId());
        }
        if (this.ial != null) {
            if (this.ial.chB() == null) {
                this.ial.a(this);
            }
            this.iak = this.ial.chz();
        }
        Z(this.iae);
    }

    private void Z(FrsFragment frsFragment) {
        this.iau = new ag();
        this.iau.eEU = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.iau));
        this.iau.a(this.iaH);
    }

    public void cgL() {
        Looper.myQueue().removeIdleHandler(this.iaF);
        Looper.myQueue().removeIdleHandler(this.iaG);
        this.ial.cancelLoadData();
    }

    public void ak(Bundle bundle) {
        if (bundle != null) {
            this.hFr = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.iax = bundle.getString("yuelaou_locate");
            this.ian = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.iae.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.hFr)) {
            this.hFr = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.iax)) {
            this.iax = "";
        }
        this.mSource = this.mFrom;
        chf();
        this.hEX = new FrsViewData();
        if (this.ial == null || this.iak == null || this.iak.bkG() == null || this.iak.bkG().isEmpty() || this.iak.bkG().containsKey(null) || this.iak.bkG().containsValue(null)) {
            aq(bundle);
        }
        if (this.hFr != null && this.hFr.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    private void aq(Bundle bundle) {
        int i;
        this.iak = new FrsRequestData();
        this.iak.setSortType(com.baidu.tieba.frs.f.g.wn(this.iay));
        if (this.iay == 5) {
            this.iak.setIsGood(1);
        } else {
            this.iak.setIsGood(0);
        }
        this.iak.fy("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.hFr));
        this.iak.fy("client_type", "2");
        this.iak.setPn(1);
        if (bundle != null) {
            this.iak.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
            this.iak.fH(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
        }
        this.iak.NC("2");
        this.iak.setObjSource("-2");
        this.iak.setKw(this.hFr);
        this.iak.setWithGroup(1);
        this.iak.setCid(0);
        this.iak.setScrW(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        this.iak.setScrH(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        this.iak.setScrDip(com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        this.iak.setqType(com.baidu.tbadk.core.util.at.baS().baT() ? 2 : 1);
        this.iak.setSchemeUrl(this.mSchemeUrl);
        this.iak.setLastId(null);
        this.iak.setYuelaouLocate(this.iax);
        this.iak.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ab.bmV(), 0L));
        this.iak.setStType(this.mFrom);
        this.iak.Fn(1);
        this.iak.setNeedCache(true);
        this.iak.setUpdateType(3);
        com.baidu.tieba.frs.f.g.a(this.iay, this.iak);
        this.iak.setLoadType(1);
        if (bv.dSh.get() && r.dca().dbU() != null) {
            int aP = r.dca().dbU().aP(this.hFr, false);
            int aQ = r.dca().dbU().aQ(this.hFr, false);
            if (this.iak.getLoadType() == 1) {
                i = aP + 1;
            } else if (this.iak.getLoadType() == 2) {
                aQ++;
                i = aP;
            } else {
                i = aP;
            }
            this.iak.setRefreshCount(i);
            this.iak.setLoadCount(aQ);
        }
        this.ial = new FrsNetModel(null, this.iak);
        this.ial.setUniqueId(((FrsActivity) this.iae.getActivity()).getUniqueId());
        this.ial.a(this);
        this.ial.loadData();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.hFr);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void chf() {
        AccountData currentAccountObj;
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            vW(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            vW(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            this.iaA = com.baidu.tieba.frs.f.g.Gu("1~" + str + this.hFr);
            vW(this.iay);
        }
    }

    public boolean bSw() {
        if (this.hTo != 1) {
            vQ(1);
            return true;
        } else if (this.ial.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.iak), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 1, false);
            return true;
        }
    }

    public void O(int i, boolean z) {
        if (this.iak != null) {
            this.iae.hFF = System.currentTimeMillis();
            if (this.hEX != null && this.hEX.getLikeFeedForumDataList() != null) {
                this.hEX.getLikeFeedForumDataList().clear();
            }
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.iak), FrsRequestData.class);
            frsRequestData.setPn(1);
            this.hTo = c(this.hTo, frsRequestData);
            if (this.hTo == 1) {
                if (!this.ial.isLoading()) {
                    frsRequestData.setCallFrom(0);
                    b(frsRequestData, i, z ? false : true);
                    return;
                }
                return;
            }
            if (this.iar == null) {
                this.iar = new ay();
                this.iar.pn = 1;
                this.iar.forumName = this.hFr;
                if (this.hEX != null && this.hEX.getForum() != null) {
                    this.iar.forumId = this.hEX.getForum().getId();
                }
            }
            vQ(i);
        }
    }

    public void P(int i, boolean z) {
        this.iae.hFF = System.currentTimeMillis();
        if (this.hEX != null && this.hEX.getLikeFeedForumDataList() != null) {
            this.hEX.getLikeFeedForumDataList().clear();
        }
        this.hTo = c(this.hTo, this.iak);
        if (this.hTo == 1) {
            a(this.iak, i, z ? false : true);
            return;
        }
        if (this.iar == null) {
            this.iar = new ay();
            this.iar.pn = 1;
            this.iar.forumName = this.hFr;
            if (this.hEX != null && this.hEX.getForum() != null) {
                this.iar.forumId = this.hEX.getForum().getId();
            }
        }
        vQ(i);
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.iae.nB(z);
        this.iam.uG(i);
        if (this.ial.chA() && (this.ial.chB() instanceof MvcHttpResponsedMessage)) {
            a((MvcHttpResponsedMessage) this.ial.chB(), (MvcHttpMessage) this.ial.chC(), this.ial.chD());
        } else if (this.ial.chA() && (this.ial.chB() instanceof MvcSocketResponsedMessage)) {
            a((MvcSocketResponsedMessage) this.ial.chB(), (MvcSocketMessage) this.ial.chC(), this.ial.chD());
        } else {
            int wn = com.baidu.tieba.frs.f.g.wn(this.iaA);
            if (!vV(this.iaA) && !this.iae.hFs && !this.iaE) {
                String e = com.baidu.tieba.tbadkCore.e.dki().e("1~" + this.hFr, wn, frsRequestData.getIsGood(), this.iak.getCategoryId());
                this.iaC = e;
                new a(this, true, e).execute(new Object[0]);
            }
            this.iaE = false;
        }
        this.ial.a(this);
    }

    public void vR(int i) {
        if (this.hTo != 1) {
            vQ(4);
        } else if (!this.ial.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.iak), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 4, false);
        }
    }

    private void b(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.iae.nB(z);
        this.iam.uG(i);
        this.ial.a(frsRequestData);
        frsRequestData.NC(this.iae.ccc() ? "1" : "2");
        if (this.iaB) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.wn(this.iaz)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.iaB = false;
        frsRequestData.setKw(this.hFr);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = com.baidu.tbadk.core.util.at.baS().baT() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setSchemeUrl(this.mSchemeUrl);
        frsRequestData.setLastId(this.hZg);
        frsRequestData.setYuelaouLocate(this.iax);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ab.bmV(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.Fn(chg());
        if (FrsFragment.hFG != 0) {
            frsRequestData.setCtime((int) FrsFragment.hFG);
        }
        if (FrsFragment.hFH != 0) {
            frsRequestData.setDataSize((int) FrsFragment.hFH);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.fH(this.iao);
        com.baidu.tieba.frs.f.g.a(this.iay, frsRequestData);
        int wn = com.baidu.tieba.frs.f.g.wn(this.iaA);
        b(i, frsRequestData);
        a(this.hFr, frsRequestData);
        if (!vV(this.iaA) && !this.iae.hFs && !this.iaE) {
            String e = com.baidu.tieba.tbadkCore.e.dki().e("1~" + this.hFr, wn, frsRequestData.getIsGood(), this.iak.getCategoryId());
            this.iaC = e;
            new a(this, true, e).execute(new Object[0]);
        }
        chj();
        this.iaE = false;
    }

    private int chg() {
        return (this.iae == null || !(this.iae.mHeadLineDefaultNavTabId == -1 || this.iae.mHeadLineDefaultNavTabId == this.hTo)) ? 0 : 1;
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
        if (mVar == null || mVar.getForum() == null || (as.isEmpty(mVar.getForum().getName()) && 340001 != mVar.mErrorNo)) {
            return false;
        }
        if (mVar.getDataParseTime() > 0) {
            this.iae.eHk = mVar.getDataParseTime();
        }
        vW(com.baidu.tieba.frs.f.g.wo(mVar.getSortType()));
        N(com.baidu.tieba.frs.f.g.wo(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.hTo = mVar.getFrsDefaultTabId();
        }
        this.hEX.receiveData(mVar);
        d(this.hEX);
        this.iaj = new ArrayList<>();
        if (frsRequestData != null) {
            this.iak = frsRequestData;
            this.mPn = this.iak.getPn();
            this.hFr = this.iak.getKw();
            this.iae.setForumName(this.hFr);
            this.iae.setFrom(this.mFrom);
            this.iae.setPn(this.mPn);
            this.iae.setFlag(this.mFlag);
        }
        if (this.hEX.getThreadList() != null) {
            this.iaj.addAll(this.hEX.getThreadList());
        }
        if (this.hTo != 1 && this.isNetFirstLoad) {
            this.iam.a(7, false, this.hZf);
        } else {
            this.iam.a(this.mType, false, this.hZf);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.iak)) {
            chx();
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() == null || TextUtils.isEmpty(mVar.getForum().getName()) || frsRequestData == null || r.dca().dbU() == null) {
            return true;
        }
        r.dca().dbU().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        if (mvcSocketResponsedMessage != null) {
            this.iaF.f(this);
            this.iaF.a(mvcSocketResponsedMessage);
            this.iaF.a(mvcSocketMessage);
            this.iaF.a(mvcNetMessage);
            this.iaF.a(this.iam);
            Looper.myQueue().addIdleHandler(this.iaF);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.hpV = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.lKR = mvcSocketResponsedMessage.getDownSize();
            this.hZf = fVar;
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
                this.iae.a(errorData);
            }
        }
    }

    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dWK) {
            this.dWK = true;
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
            this.iaG.f(this);
            this.iaG.a(mvcHttpResponsedMessage);
            this.iaG.a(mvcHttpMessage);
            this.iaG.a(mvcNetMessage);
            this.iaG.a(this.iam);
            Looper.myQueue().addIdleHandler(this.iaG);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.hpV = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.lKR = mvcHttpResponsedMessage.getDownSize();
            this.hZf = fVar;
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
                this.iae.a(errorData);
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
        if (!this.dWK) {
            this.dWK = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void cbT() {
        if (this.hEX != null && this.hEX.getForum() != null && this.hEX.getForum().getBannerListData() != null) {
            String lastIds = this.hEX.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.hZg = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.blA().blB()) {
            this.eHo = System.currentTimeMillis() - this.iae.hio;
            this.iae.eHn = System.currentTimeMillis() - this.iae.hFE;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, this.iae.eHd, this.iae.createTime, this.iae.eHn, false, this.iae.eHe, this.iae.eHk, this.eHo);
            this.iae.createTime = 0L;
            this.iae.eHd = 0L;
            com.baidu.tieba.frs.f.h.a(this, this.iae.hio);
            this.iae.hio = -1L;
            iVar.blx();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.blA().blB()) {
            this.eHo = System.currentTimeMillis() - this.iae.hFF;
            this.iae.eHn = System.currentTimeMillis() - this.iae.hFE;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1000, z, responsedMessage, this.iae.eHd, this.iae.createTime, this.iae.eHn, false, this.iae.eHe, this.iae.eHk, this.eHo);
            if (this.mType == 4) {
                iVar.eHw = this.eHo;
                iVar.jc(true);
            } else if (this.mType == 3) {
                iVar.eHx = this.eHo;
                iVar.jc(false);
            }
        }
    }

    public FrsRequestData chh() {
        return this.iak;
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

    public FrsViewData cgN() {
        return this.hEX;
    }

    public com.baidu.tieba.tbadkCore.f chi() {
        return this.hZf;
    }

    private boolean chj() {
        this.hll = System.currentTimeMillis();
        return this.ial.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.hEX.receiveData(mVar);
        d(this.hEX);
        this.iaj = new ArrayList<>();
        if (this.hEX.getThreadList() != null) {
            this.iaj.addAll(this.hEX.getThreadList());
        }
        this.iam.c(mVar);
    }

    private void d(FrsViewData frsViewData) {
        if (com.baidu.tieba.frs.vc.h.l(frsViewData)) {
            this.mPageType = "book_page";
        } else if (frsViewData.getIsBrandForum()) {
            this.mPageType = "brand_page";
        } else if (com.baidu.tieba.frs.vc.h.m(frsViewData)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes16.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.m, Void> {
        private String bmG;
        private FrsModelController iaL;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.bmG = null;
            this.bmG = str;
            this.iaL = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.dki().NA(this.bmG)) {
                if (!com.baidu.tieba.tbadkCore.e.dki().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.bmG)) {
                    com.baidu.tieba.tbadkCore.e.dki().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.dki().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().aUr(), true) && !responseData.getBookInfo().aUr().equals("0") && responseData.getBookInfo().aUs() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().aUr(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.iaL != null && mVarArr != null) {
                this.iaL.e(mVarArr.length > 0 ? mVarArr[0] : null);
                this.iaL.N(this.iaL.iay, true);
            }
        }
    }

    public long bVK() {
        return this.hlo;
    }

    public long bVL() {
        return this.hlm;
    }

    public long bVM() {
        return this.hln;
    }

    public long bVN() {
        return this.hll;
    }

    public boolean isLoading() {
        return this.ial.isLoading();
    }

    public int chk() {
        return this.iaq;
    }

    private void chl() {
        if (this.iaw == null) {
            this.iaw = new ArrayList<>();
        }
        if (this.iaw.size() == 0) {
            this.iaw.add(new ac());
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void a(int i, int i2, ay ayVar) {
        this.hTo = c(i, null);
        if (ayVar == null && (ayVar = cl(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.iav != null) {
                bb bbVar = new bb();
                bbVar.hasMore = false;
                bbVar.pn = 1;
                bbVar.forumName = this.hFr;
                bbVar.hKp = false;
                if (this.hEX != null && this.hEX.getForum() != null) {
                    bbVar.forumId = this.hEX.getForum().getId();
                }
                chl();
                this.hEX.setThreadList(this.iaw);
                this.iav.a(i, i2, bbVar, this.iaw);
            }
            ayVar = new ay();
            ayVar.pn = -1;
        }
        if (this.hEX != null && this.hEX.getForum() != null) {
            ayVar.forumId = this.hEX.getForum().getId();
        }
        ayVar.forumName = this.hFr;
        if (ae.cdv().vc(1) != null && this.hTo == 1) {
            this.iak.setCategoryId(i2);
        }
        this.iap = i2;
        this.iar = ayVar;
        b(i, i2, ayVar);
        vQ(5);
    }

    @Override // com.baidu.tieba.frs.ap
    public void a(at atVar) {
        this.iav = atVar;
        this.iau.a(this.iaH);
    }

    private void vQ(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.iar != null) {
                    this.iar.pn++;
                    break;
                }
                break;
            case 2:
                if (this.iar != null) {
                    ay ayVar = this.iar;
                    ayVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.iar != null) {
                    this.iar.pn = -1;
                    break;
                }
                break;
        }
        if (this.hTo == 1) {
            if (this.iaq == this.iap) {
                ArrayList<q> arrayList = new ArrayList<>();
                if (this.iaj != null) {
                    arrayList.addAll(this.iaj);
                }
                this.hEX.setThreadList(arrayList);
                if (this.iav != null) {
                    this.iav.a(this.hTo, this.iap, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.iaq = this.iap;
            return;
        }
        ap vd = this.iau.vd(this.hTo);
        if (vd != null) {
            this.ias = true;
            vd.a(this.hTo, this.iap, this.iar);
            return;
        }
        if (this.hEX != null && this.hEX.getThreadList() != null) {
            this.hEX.getThreadList().clear();
        }
        this.iav.a(this.hTo, this.iap, null, null);
    }

    public boolean hasMore() {
        if ((this.iar instanceof bb) && ((bb) this.iar).errCode == 0) {
            return ((bb) this.iar).hasMore;
        }
        return true;
    }

    private int ck(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ay ayVar) {
        this.iat.put(ck(i, i2), ayVar);
    }

    public ay cl(int i, int i2) {
        return this.iat.get(ck(i, i2));
    }

    @Override // com.baidu.tieba.frs.ap
    public void init() {
        this.iau.init();
    }

    @Override // com.baidu.tieba.frs.ap
    public void bCu() {
        this.iau.destory();
        this.iau.clear();
    }

    public int chm() {
        return this.hTo;
    }

    public boolean chn() {
        return 1 == this.hTo;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(ar arVar) {
        if (arVar != null && !StringUtils.isNull(arVar.getId()) && !x.isEmpty(this.iaj)) {
            if (this.hTo == 1) {
                this.hEX.addMyNewThread(arVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<q> it = this.iaj.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if ((next instanceof bu) && arVar.getId().equals(((bu) next).dLK.getId())) {
                    return;
                }
            }
            this.iaj.add(topThreadSize, arVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.iaj == null || this.iaj.size() <= 0) {
            return 0;
        }
        Iterator<q> it = this.iaj.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                q next = it.next();
                if (!(next instanceof bu)) {
                    i = i2;
                } else if (((bu) next).dLK.aWg() != 0) {
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

    public boolean cho() {
        return this.ias;
    }

    public void chp() {
        com.baidu.tieba.frs.r rVar = new com.baidu.tieba.frs.r();
        if (this.iaq == 0) {
            rVar.uW(this.iay);
        }
        if (this.hEX.getThreadList() != null) {
            this.hEX.getThreadList().clear();
            this.hEX.getThreadList().add(rVar);
        }
        if (this.iaj != null) {
            this.iaj.clear();
            this.iaj.add(rVar);
        }
    }

    public ArrayList<q> chq() {
        return this.iaj;
    }

    public void vW(int i) {
        AccountData currentAccountObj;
        this.iay = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.f.g.aL("1~" + str + this.hFr, this.iay);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dmo();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dmp();
        }
    }

    public void vX(int i) {
        this.iaz = i;
    }

    public void ot(boolean z) {
        this.iaB = z;
    }

    public int chr() {
        return this.iay;
    }

    public int chs() {
        return this.iaA;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.wn(this.iay);
    }

    public boolean cht() {
        return this.ian;
    }

    public boolean chu() {
        return this.iay == 5;
    }

    public boolean chv() {
        return this.iak != null && this.iak.getLoadType() == 1;
    }

    public boolean chw() {
        return this.iay == 7 || (!this.ial.chA() && this.iaA == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.iae.cbn() != null) {
            return this.iae.cbn().a(this.iay, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bv.dSh.get() && r.dca().dbU() != null) {
            int aP = r.dca().dbU().aP(str, false);
            int aQ = r.dca().dbU().aQ(str, false);
            if (frsRequestData.getLoadType() == 1) {
                aP++;
            } else if (frsRequestData.getLoadType() == 2) {
                aQ++;
            }
            frsRequestData.setRefreshCount(aP);
            frsRequestData.setLoadCount(aQ);
        }
    }

    public void chx() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.hEX != null && this.hEX.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.hEX.getForum().getId(), 0L));
        }
        this.iae.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void Gn(final String str) {
        ad.a(new com.baidu.tbadk.util.ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dki().fv(FrsModelController.this.iaC, str);
                return null;
            }
        }, null);
    }

    public void Go(final String str) {
        ad.a(new com.baidu.tbadk.util.ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dki().fw(FrsModelController.this.iaC, str);
                return null;
            }
        }, null);
    }

    public void Gp(final String str) {
        ad.a(new com.baidu.tbadk.util.ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dki().fx(FrsModelController.this.iaC, str);
                return null;
            }
        }, null);
    }

    public void ou(boolean z) {
        this.iaE = z;
    }
}
