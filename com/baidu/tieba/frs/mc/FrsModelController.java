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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.s;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes22.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.m>, aq {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private boolean ePk;
    private long fCm;
    private String iSN;
    private FrsViewData iSt;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private long iyk;
    private long iyl;
    private long iym;
    private long iyn;
    private int jkb;
    private com.baidu.tieba.tbadkCore.f jqm;
    private String jqn;
    private ah jrA;
    private au jrB;
    private ArrayList<q> jrC;
    private String jrD;
    private int jrE;
    private int jrF;
    private int jrG;
    private boolean jrH;
    private String jrI;
    private final SparseArray<Boolean> jrJ;
    private boolean jrK;
    private n jrL;
    private m jrM;
    private au jrN;
    private final FrsFragment jrk;
    private ArrayList<q> jrp;
    private FrsRequestData jrq;
    private FrsNetModel jrr;
    private final s jrs;
    private boolean jrt;
    private long jru;
    private int jrv;
    private int jrw;
    private ba jrx;
    private boolean jry;
    private SparseArray<ba> jrz;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSchemeUrl;
    private String mSource;
    private int mType;

    public boolean Bl(int i) {
        return this.jrJ.get(i, false).booleanValue();
    }

    public void R(int i, boolean z) {
        this.jrJ.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, s sVar) {
        super(frsFragment.getPageContext());
        this.iSN = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSchemeUrl = "";
        this.mSource = null;
        this.jqn = null;
        this.jru = 0L;
        this.jkb = 1;
        this.jrv = 0;
        this.jrw = 0;
        this.jry = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.jrz = new SparseArray<>();
        this.fCm = 0L;
        this.ePk = false;
        this.jrE = -1;
        this.jrF = -1;
        this.jrG = -1;
        this.jrI = null;
        this.jrJ = new SparseArray<>();
        this.jrL = new n();
        this.jrM = new m();
        this.jrN = new au() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.au
            public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
                FrsModelController.this.jry = false;
                if (i == FrsModelController.this.jkb && FrsModelController.this.jrB != null) {
                    FrsModelController.this.jrx = bdVar;
                    FrsModelController.this.b(i, i2, bdVar);
                    ArrayList<q> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.iSt.setThreadList(arrayList2);
                    FrsModelController.this.jrB.a(i, i2, bdVar, arrayList);
                }
            }
        };
        this.iyk = 0L;
        this.iyl = 0L;
        this.iym = 0L;
        this.iyn = 0L;
        if (sVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.jrk = frsFragment;
        this.jrs = sVar;
        if (this.jrk.getActivity() instanceof FrsActivity) {
            this.jrr = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.jrk.getActivity()).getUniqueId().getId());
        }
        if (this.jrr != null) {
            if (this.jrr.getResponsedMessage() == null) {
                this.jrr.a(this);
            }
            this.jrq = this.jrr.cJq();
        }
        Z(this.jrk);
    }

    private void Z(FrsFragment frsFragment) {
        this.jrA = new ah();
        this.jrA.fzO = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.jrA));
        this.jrA.a(this.jrN);
    }

    public void cIC() {
        Looper.myQueue().removeIdleHandler(this.jrL);
        Looper.myQueue().removeIdleHandler(this.jrM);
        this.jrr.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.iSN = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.jrD = bundle.getString("yuelaou_locate");
            this.jrt = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.jrk.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.iSN)) {
            this.iSN = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.jrD)) {
            this.jrD = "";
        }
        this.mSource = this.mFrom;
        cIW();
        this.iSt = new FrsViewData();
        if (this.jrr == null || this.jrq == null || this.jrq.bEr() == null || this.jrq.bEr().isEmpty() || this.jrq.bEr().containsKey(null) || this.jrq.bEr().containsValue(null)) {
            ar(bundle);
        }
        if (this.iSN != null && this.iSN.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    private void ar(Bundle bundle) {
        int i;
        this.jrq = new FrsRequestData();
        this.jrq.setSortType(com.baidu.tieba.frs.f.j.BD(this.jrE));
        if (this.jrE == 5) {
            this.jrq.setIsGood(1);
        } else {
            this.jrq.setIsGood(0);
        }
        this.jrq.gt("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.iSN));
        this.jrq.gt("client_type", "2");
        this.jrq.setPn(1);
        if (bundle != null) {
            this.jrq.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
            this.jrq.hG(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
        }
        this.jrq.Tw("2");
        this.jrq.setObjSource("-2");
        this.jrq.setKw(this.iSN);
        this.jrq.setWithGroup(1);
        this.jrq.setCid(0);
        this.jrq.setScrW(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        this.jrq.setScrH(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        this.jrq.setScrDip(com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        this.jrq.setqType(av.btX().btY() ? 2 : 1);
        this.jrq.setSchemeUrl(this.mSchemeUrl);
        this.jrq.setLastId(null);
        this.jrq.setYuelaouLocate(this.jrD);
        this.jrq.setLastClickTid(com.baidu.adp.lib.f.b.toLong(aa.bGM(), 0L));
        this.jrq.setStType(this.mFrom);
        this.jrq.KQ(1);
        this.jrq.setNeedCache(true);
        this.jrq.setUpdateType(3);
        com.baidu.tieba.frs.f.j.a(this.jrE, this.jrq);
        this.jrq.setLoadType(1);
        if (by.eJG.get() && r.dFf().dEZ() != null) {
            int ba = r.dFf().dEZ().ba(this.iSN, false);
            int bb = r.dFf().dEZ().bb(this.iSN, false);
            if (this.jrq.getLoadType() == 1) {
                i = ba + 1;
            } else if (this.jrq.getLoadType() == 2) {
                bb++;
                i = ba;
            } else {
                i = ba;
            }
            this.jrq.setRefreshCount(i);
            this.jrq.setLoadCount(bb);
        }
        this.jrr = new FrsNetModel(null, this.jrq);
        this.jrr.setUniqueId(((FrsActivity) this.jrk.getActivity()).getUniqueId());
        this.jrr.a(this);
        this.jrr.loadData();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.iSN);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void cIW() {
        AccountData currentAccountObj;
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            Bm(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            Bm(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            this.jrG = com.baidu.tieba.frs.f.j.LG("1~" + str + this.iSN);
            Bm(this.jrE);
        }
    }

    public boolean csQ() {
        if (this.jkb != 1) {
            Bg(1);
            return true;
        } else if (this.jrr.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jrq), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 1, false);
            return true;
        }
    }

    public void S(int i, boolean z) {
        if (this.jrq != null) {
            this.jrk.iTb = System.currentTimeMillis();
            if (this.iSt != null && this.iSt.getLikeFeedForumDataList() != null) {
                this.iSt.getLikeFeedForumDataList().clear();
            }
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jrq), FrsRequestData.class);
            frsRequestData.setPn(1);
            this.jkb = c(this.jkb, frsRequestData);
            if (this.jkb == 1) {
                if (!this.jrr.isLoading()) {
                    frsRequestData.setCallFrom(0);
                    b(frsRequestData, i, z ? false : true);
                    return;
                }
                return;
            }
            if (this.jrx == null) {
                this.jrx = new ba();
                this.jrx.pn = 1;
                this.jrx.forumName = this.iSN;
                if (this.iSt != null && this.iSt.getForum() != null) {
                    this.jrx.forumId = this.iSt.getForum().getId();
                }
            }
            Bg(i);
        }
    }

    public void T(int i, boolean z) {
        this.jrk.iTb = System.currentTimeMillis();
        if (this.iSt != null && this.iSt.getLikeFeedForumDataList() != null) {
            this.iSt.getLikeFeedForumDataList().clear();
        }
        this.jkb = c(this.jkb, this.jrq);
        if (this.jkb == 1) {
            a(this.jrq, i, z ? false : true);
            return;
        }
        if (this.jrx == null) {
            this.jrx = new ba();
            this.jrx.pn = 1;
            this.jrx.forumName = this.iSN;
            if (this.iSt != null && this.iSt.getForum() != null) {
                this.jrx.forumId = this.iSt.getForum().getId();
            }
        }
        Bg(i);
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.jrk.pT(z);
        this.jrs.zJ(i);
        if (this.jrr.cJr() && (this.jrr.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
            a((MvcHttpResponsedMessage) this.jrr.getResponsedMessage(), (MvcHttpMessage) this.jrr.cJs(), this.jrr.cJt());
        } else if (this.jrr.cJr() && (this.jrr.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
            a((MvcSocketResponsedMessage) this.jrr.getResponsedMessage(), (MvcSocketMessage) this.jrr.cJs(), this.jrr.cJt());
        } else {
            int BD = com.baidu.tieba.frs.f.j.BD(this.jrG);
            if (!Bl(this.jrG) && !this.jrk.iSO && !this.jrK) {
                String f = com.baidu.tieba.tbadkCore.e.dOf().f("1~" + this.iSN, BD, frsRequestData.getIsGood(), this.jrq.getCategoryId());
                this.jrI = f;
                new a(this, true, f).execute(new Object[0]);
            }
            this.jrK = false;
        }
        this.jrr.a(this);
    }

    public void Bh(int i) {
        if (this.jkb != 1) {
            Bg(4);
        } else if (!this.jrr.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jrq), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 4, false);
        }
    }

    private void b(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.jrk.pT(z);
        this.jrs.zJ(i);
        this.jrr.a(frsRequestData);
        frsRequestData.Tw(this.jrk.cCM() ? "1" : "2");
        if (this.jrH) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.j.BD(this.jrF)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.jrH = false;
        frsRequestData.setKw(this.iSN);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = av.btX().btY() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setSchemeUrl(this.mSchemeUrl);
        frsRequestData.setLastId(this.jqn);
        frsRequestData.setYuelaouLocate(this.jrD);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(aa.bGM(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.KQ(cIX());
        if (FrsFragment.iTc != 0) {
            frsRequestData.setCtime((int) FrsFragment.iTc);
        }
        if (FrsFragment.iTd != 0) {
            frsRequestData.setDataSize((int) FrsFragment.iTd);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.hG(this.jru);
        com.baidu.tieba.frs.f.j.a(this.jrE, frsRequestData);
        int BD = com.baidu.tieba.frs.f.j.BD(this.jrG);
        b(i, frsRequestData);
        a(this.iSN, frsRequestData);
        if (!Bl(this.jrG) && !this.jrk.iSO && !this.jrK) {
            String f = com.baidu.tieba.tbadkCore.e.dOf().f("1~" + this.iSN, BD, frsRequestData.getIsGood(), this.jrq.getCategoryId());
            this.jrI = f;
            new a(this, true, f).execute(new Object[0]);
        }
        cJa();
        this.jrK = false;
    }

    private int cIX() {
        return (this.jrk == null || !(this.jrk.mHeadLineDefaultNavTabId == -1 || this.jrk.mHeadLineDefaultNavTabId == this.jkb)) ? 0 : 1;
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
        if (mVar == null || mVar.getForum() == null || (com.baidu.tbadk.core.util.au.isEmpty(mVar.getForum().getName()) && 340001 != mVar.mErrorNo)) {
            return false;
        }
        if (mVar.getDataParseTime() > 0) {
            this.jrk.fCi = mVar.getDataParseTime();
        }
        Bm(com.baidu.tieba.frs.f.j.BE(mVar.getSortType()));
        R(com.baidu.tieba.frs.f.j.BE(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.jkb = mVar.getFrsDefaultTabId();
        }
        this.iSt.receiveData(mVar);
        d(this.iSt);
        this.jrp = new ArrayList<>();
        if (frsRequestData != null) {
            this.jrq = frsRequestData;
            this.mPn = this.jrq.getPn();
            this.iSN = this.jrq.getKw();
            this.jrk.setForumName(this.iSN);
            this.jrk.setFrom(this.mFrom);
            this.jrk.setPn(this.mPn);
            this.jrk.setFlag(this.mFlag);
        }
        if (this.iSt.getThreadList() != null) {
            this.jrp.addAll(this.iSt.getThreadList());
        }
        if (this.jkb != 1 && this.isNetFirstLoad) {
            this.jrs.a(7, false, this.jqm);
        } else {
            this.jrs.a(this.mType, false, this.jqm);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.jrq)) {
            cJo();
        }
        if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iSt.getForum()));
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() != null && !TextUtils.isEmpty(mVar.getForum().getName()) && frsRequestData != null && r.dFf().dEZ() != null) {
            r.dFf().dEZ().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        if (StringUtils.isNull(mVar.getUserData().getAppealThreadPopover())) {
            return true;
        }
        this.jrk.aF(TbadkCoreApplication.getCurrentAccount(), mVar.getForum().getId(), mVar.getUserData().getAppealThreadPopover());
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        if (mvcSocketResponsedMessage != null) {
            this.jrL.g(this);
            this.jrL.a(mvcSocketResponsedMessage);
            this.jrL.a(mvcSocketMessage);
            this.jrL.a(mvcNetMessage);
            this.jrL.a(this.jrs);
            Looper.myQueue().addIdleHandler(this.jrL);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iCU = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.njv = mvcSocketResponsedMessage.getDownSize();
            this.jqm = fVar;
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
                this.jrk.a(errorData);
            }
        }
    }

    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.ePk) {
            this.ePk = true;
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
            this.jrM.g(this);
            this.jrM.a(mvcHttpResponsedMessage);
            this.jrM.a(mvcHttpMessage);
            this.jrM.a(mvcNetMessage);
            this.jrM.a(this.jrs);
            Looper.myQueue().addIdleHandler(this.jrM);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iCU = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.njv = mvcHttpResponsedMessage.getDownSize();
            this.jqm = fVar;
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
                this.jrk.a(errorData);
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
        if (!this.ePk) {
            this.ePk = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void cCD() {
        if (this.iSt != null && this.iSt.getForum() != null && this.iSt.getForum().getBannerListData() != null) {
            String lastIds = this.iSt.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.jqn = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.l.bFl().isSmallFlow()) {
            this.fCm = System.currentTimeMillis() - this.jrk.ivy;
            this.jrk.fCl = System.currentTimeMillis() - this.jrk.iTa;
            com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(i, z, responsedMessage, this.jrk.fCb, this.jrk.createTime, this.jrk.fCl, false, this.jrk.fCc, this.jrk.fCi, this.fCm);
            this.jrk.createTime = 0L;
            this.jrk.fCb = 0L;
            com.baidu.tieba.frs.f.k.a(this, this.jrk.ivy);
            this.jrk.ivy = -1L;
            hVar.bFi();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.l.bFl().isSmallFlow()) {
            this.fCm = System.currentTimeMillis() - this.jrk.iTb;
            this.jrk.fCl = System.currentTimeMillis() - this.jrk.iTa;
            com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(1000, z, responsedMessage, this.jrk.fCb, this.jrk.createTime, this.jrk.fCl, false, this.jrk.fCc, this.jrk.fCi, this.fCm);
            if (this.mType == 4) {
                hVar.fCu = this.fCm;
                hVar.kR(true);
            } else if (this.mType == 3) {
                hVar.fCv = this.fCm;
                hVar.kR(false);
            }
        }
    }

    public FrsRequestData cIY() {
        return this.jrq;
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

    public FrsViewData cIE() {
        return this.iSt;
    }

    public com.baidu.tieba.tbadkCore.f cIZ() {
        return this.jqm;
    }

    private boolean cJa() {
        this.iyk = System.currentTimeMillis();
        return this.jrr.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.iSt.receiveData(mVar);
        d(this.iSt);
        this.jrp = new ArrayList<>();
        if (this.iSt.getThreadList() != null) {
            this.jrp.addAll(this.iSt.getThreadList());
        }
        this.jrs.c(mVar);
    }

    private void d(FrsViewData frsViewData) {
        if (com.baidu.tieba.frs.vc.h.m(frsViewData)) {
            this.mPageType = "book_page";
        } else if (frsViewData.getIsBrandForum()) {
            this.mPageType = "brand_page";
        } else if (com.baidu.tieba.frs.vc.h.n(frsViewData)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes22.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.m, Void> {
        private String bOf;
        private FrsModelController jrR;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.bOf = null;
            this.bOf = str;
            this.jrR = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.dOf().Tu(this.bOf)) {
                if (!com.baidu.tieba.tbadkCore.e.dOf().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.bOf)) {
                    com.baidu.tieba.tbadkCore.e.dOf().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.dOf().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().bmV(), true) && !responseData.getBookInfo().bmV().equals("0") && responseData.getBookInfo().bmW() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().bmV(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
                    responseData.setMangaReadRecordChapterId(Integer.valueOf(((Integer) runTask.getData()).intValue()));
                }
                publishProgress(responseData);
            } else {
                publishProgress(null);
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(com.baidu.tieba.tbadkCore.m... mVarArr) {
            super.onProgressUpdate(mVarArr);
            if (this.jrR != null && mVarArr != null) {
                this.jrR.e(mVarArr.length > 0 ? mVarArr[0] : null);
                this.jrR.R(this.jrR.jrE, true);
            } else if (this.jrR != null && !this.jrR.jrr.cJr()) {
                if (this.jrR.jrr.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                    this.jrR.a((MvcHttpResponsedMessage) this.jrR.jrr.getResponsedMessage(), (MvcHttpMessage) this.jrR.jrr.cJs(), this.jrR.jrr.cJt());
                }
                if (this.jrR.jrr.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                    this.jrR.a((MvcSocketResponsedMessage) this.jrR.jrr.getResponsedMessage(), (MvcSocketMessage) this.jrR.jrr.cJs(), this.jrR.jrr.cJt());
                }
            }
        }
    }

    public long cwl() {
        return this.iyn;
    }

    public long cwm() {
        return this.iyl;
    }

    public long cwn() {
        return this.iym;
    }

    public long cwo() {
        return this.iyk;
    }

    public boolean isLoading() {
        return this.jrr.isLoading();
    }

    public int cJb() {
        return this.jrw;
    }

    private void cJc() {
        if (this.jrC == null) {
            this.jrC = new ArrayList<>();
        }
        if (this.jrC.size() == 0) {
            this.jrC.add(new ad());
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void a(int i, int i2, ba baVar) {
        this.jkb = c(i, null);
        if (baVar == null && (baVar = cF(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.jrB != null) {
                bd bdVar = new bd();
                bdVar.hasMore = false;
                bdVar.pn = 1;
                bdVar.forumName = this.iSN;
                bdVar.iXS = false;
                if (this.iSt != null && this.iSt.getForum() != null) {
                    bdVar.forumId = this.iSt.getForum().getId();
                }
                cJc();
                this.iSt.setThreadList(this.jrC);
                this.jrB.a(i, i2, bdVar, this.jrC);
            }
            baVar = new ba();
            baVar.pn = -1;
        }
        if (this.iSt != null && this.iSt.getForum() != null) {
            baVar.forumId = this.iSt.getForum().getId();
        }
        baVar.forumName = this.iSN;
        if (af.cEh().Ah(1) != null && this.jkb == 1) {
            this.jrq.setCategoryId(i2);
        }
        this.jrv = i2;
        this.jrx = baVar;
        b(i, i2, baVar);
        Bg(5);
    }

    @Override // com.baidu.tieba.frs.aq
    public void a(au auVar) {
        this.jrB = auVar;
        this.jrA.a(this.jrN);
    }

    private void Bg(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.jrx != null) {
                    this.jrx.pn++;
                    break;
                }
                break;
            case 2:
                if (this.jrx != null) {
                    ba baVar = this.jrx;
                    baVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.jrx != null) {
                    this.jrx.pn = -1;
                    break;
                }
                break;
        }
        if (this.jkb == 1) {
            if (this.jrw == this.jrv) {
                ArrayList<q> arrayList = new ArrayList<>();
                if (this.jrp != null) {
                    arrayList.addAll(this.jrp);
                }
                this.iSt.setThreadList(arrayList);
                if (this.jrB != null) {
                    this.jrB.a(this.jkb, this.jrv, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.jrw = this.jrv;
            return;
        }
        aq Ai = this.jrA.Ai(this.jkb);
        if (Ai != null) {
            this.jry = true;
            Ai.a(this.jkb, this.jrv, this.jrx);
            return;
        }
        if (this.iSt != null && this.iSt.getThreadList() != null) {
            this.iSt.getThreadList().clear();
        }
        this.jrB.a(this.jkb, this.jrv, null, null);
    }

    public boolean hasMore() {
        if ((this.jrx instanceof bd) && ((bd) this.jrx).errCode == 0) {
            return ((bd) this.jrx).hasMore;
        }
        return true;
    }

    private int cE(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ba baVar) {
        this.jrz.put(cE(i, i2), baVar);
    }

    public ba cF(int i, int i2) {
        return this.jrz.get(cE(i, i2));
    }

    @Override // com.baidu.tieba.frs.aq
    public void init() {
        this.jrA.init();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bYY() {
        this.jrA.destory();
        this.jrA.clear();
    }

    public int cJd() {
        return this.jkb;
    }

    public boolean cJe() {
        return 1 == this.jkb;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(com.baidu.tbadk.core.data.au auVar) {
        if (auVar != null && !StringUtils.isNull(auVar.getId()) && !y.isEmpty(this.jrp)) {
            if (this.jkb == 1) {
                this.iSt.addMyNewThread(auVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<q> it = this.jrp.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if ((next instanceof bx) && auVar.getId().equals(((bx) next).eCR.getId())) {
                    return;
                }
            }
            this.jrp.add(topThreadSize, auVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.jrp == null || this.jrp.size() <= 0) {
            return 0;
        }
        Iterator<q> it = this.jrp.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                q next = it.next();
                if (!(next instanceof bx)) {
                    i = i2;
                } else if (((bx) next).eCR.boK() != 0) {
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

    public boolean cJf() {
        return this.jry;
    }

    public void cJg() {
        com.baidu.tieba.frs.s sVar = new com.baidu.tieba.frs.s();
        if (this.jrw == 0) {
            sVar.zZ(this.jrE);
        }
        if (this.iSt.getThreadList() != null) {
            this.iSt.getThreadList().clear();
            this.iSt.getThreadList().add(sVar);
        }
        if (this.jrp != null) {
            this.jrp.clear();
            this.jrp.add(sVar);
        }
    }

    public ArrayList<q> cJh() {
        return this.jrp;
    }

    public void Bm(int i) {
        AccountData currentAccountObj;
        this.jrE = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.f.j.aS("1~" + str + this.iSN, this.jrE);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dQu();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dQv();
        }
    }

    public void Bn(int i) {
        this.jrF = i;
    }

    public void qP(boolean z) {
        this.jrH = z;
    }

    public int cJi() {
        return this.jrE;
    }

    public int cJj() {
        return this.jrG;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.j.BD(this.jrE);
    }

    public boolean cJk() {
        return this.jrt;
    }

    public boolean cJl() {
        return this.jrE == 5;
    }

    public boolean cJm() {
        return this.jrq != null && this.jrq.getLoadType() == 1;
    }

    public boolean cJn() {
        return this.jrE == 7 || (!this.jrr.cJr() && this.jrG == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.jrk.cBV() != null) {
            return this.jrk.cBV().a(this.jrE, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (by.eJG.get() && r.dFf().dEZ() != null) {
            int ba = r.dFf().dEZ().ba(str, false);
            int bb = r.dFf().dEZ().bb(str, false);
            if (frsRequestData.getLoadType() == 1) {
                ba++;
            } else if (frsRequestData.getLoadType() == 2) {
                bb++;
            }
            frsRequestData.setRefreshCount(ba);
            frsRequestData.setLoadCount(bb);
        }
    }

    public void cJo() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.iSt != null && this.iSt.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.iSt.getForum().getId(), 0L));
        }
        this.jrk.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void Lz(final String str) {
        com.baidu.tbadk.util.ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dOf().gq(FrsModelController.this.jrI, str);
                return null;
            }
        }, null);
    }

    public void LA(final String str) {
        com.baidu.tbadk.util.ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dOf().gr(FrsModelController.this.jrI, str);
                return null;
            }
        }, null);
    }

    public void LB(final String str) {
        com.baidu.tbadk.util.ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dOf().gs(FrsModelController.this.jrI, str);
                return null;
            }
        }, null);
    }

    public void qQ(boolean z) {
        this.jrK = z;
    }
}
