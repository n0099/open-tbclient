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
    private String iSP;
    private FrsViewData iSv;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private long iym;
    private long iyn;
    private long iyo;
    private long iyp;
    private int jkd;
    private com.baidu.tieba.tbadkCore.f jqo;
    private String jqp;
    private boolean jrA;
    private SparseArray<ba> jrB;
    private ah jrC;
    private au jrD;
    private ArrayList<q> jrE;
    private String jrF;
    private int jrG;
    private int jrH;
    private int jrI;
    private boolean jrJ;
    private String jrK;
    private final SparseArray<Boolean> jrL;
    private boolean jrM;
    private n jrN;
    private m jrO;
    private au jrP;
    private final FrsFragment jrm;
    private ArrayList<q> jrr;
    private FrsRequestData jrs;
    private FrsNetModel jrt;
    private final s jru;
    private boolean jrv;
    private long jrw;
    private int jrx;
    private int jry;
    private ba jrz;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSchemeUrl;
    private String mSource;
    private int mType;

    public boolean Bl(int i) {
        return this.jrL.get(i, false).booleanValue();
    }

    public void R(int i, boolean z) {
        this.jrL.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, s sVar) {
        super(frsFragment.getPageContext());
        this.iSP = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSchemeUrl = "";
        this.mSource = null;
        this.jqp = null;
        this.jrw = 0L;
        this.jkd = 1;
        this.jrx = 0;
        this.jry = 0;
        this.jrA = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.jrB = new SparseArray<>();
        this.fCm = 0L;
        this.ePk = false;
        this.jrG = -1;
        this.jrH = -1;
        this.jrI = -1;
        this.jrK = null;
        this.jrL = new SparseArray<>();
        this.jrN = new n();
        this.jrO = new m();
        this.jrP = new au() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.au
            public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
                FrsModelController.this.jrA = false;
                if (i == FrsModelController.this.jkd && FrsModelController.this.jrD != null) {
                    FrsModelController.this.jrz = bdVar;
                    FrsModelController.this.b(i, i2, bdVar);
                    ArrayList<q> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.iSv.setThreadList(arrayList2);
                    FrsModelController.this.jrD.a(i, i2, bdVar, arrayList);
                }
            }
        };
        this.iym = 0L;
        this.iyn = 0L;
        this.iyo = 0L;
        this.iyp = 0L;
        if (sVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.jrm = frsFragment;
        this.jru = sVar;
        if (this.jrm.getActivity() instanceof FrsActivity) {
            this.jrt = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.jrm.getActivity()).getUniqueId().getId());
        }
        if (this.jrt != null) {
            if (this.jrt.getResponsedMessage() == null) {
                this.jrt.a(this);
            }
            this.jrs = this.jrt.cJr();
        }
        Z(this.jrm);
    }

    private void Z(FrsFragment frsFragment) {
        this.jrC = new ah();
        this.jrC.fzO = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.jrC));
        this.jrC.a(this.jrP);
    }

    public void cID() {
        Looper.myQueue().removeIdleHandler(this.jrN);
        Looper.myQueue().removeIdleHandler(this.jrO);
        this.jrt.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.iSP = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.jrF = bundle.getString("yuelaou_locate");
            this.jrv = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.jrm.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.iSP)) {
            this.iSP = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.jrF)) {
            this.jrF = "";
        }
        this.mSource = this.mFrom;
        cIX();
        this.iSv = new FrsViewData();
        if (this.jrt == null || this.jrs == null || this.jrs.bEr() == null || this.jrs.bEr().isEmpty() || this.jrs.bEr().containsKey(null) || this.jrs.bEr().containsValue(null)) {
            ar(bundle);
        }
        if (this.iSP != null && this.iSP.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    private void ar(Bundle bundle) {
        int i;
        this.jrs = new FrsRequestData();
        this.jrs.setSortType(com.baidu.tieba.frs.f.j.BD(this.jrG));
        if (this.jrG == 5) {
            this.jrs.setIsGood(1);
        } else {
            this.jrs.setIsGood(0);
        }
        this.jrs.gt("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.iSP));
        this.jrs.gt("client_type", "2");
        this.jrs.setPn(1);
        if (bundle != null) {
            this.jrs.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
            this.jrs.hG(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
        }
        this.jrs.Tw("2");
        this.jrs.setObjSource("-2");
        this.jrs.setKw(this.iSP);
        this.jrs.setWithGroup(1);
        this.jrs.setCid(0);
        this.jrs.setScrW(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        this.jrs.setScrH(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        this.jrs.setScrDip(com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        this.jrs.setqType(av.btX().btY() ? 2 : 1);
        this.jrs.setSchemeUrl(this.mSchemeUrl);
        this.jrs.setLastId(null);
        this.jrs.setYuelaouLocate(this.jrF);
        this.jrs.setLastClickTid(com.baidu.adp.lib.f.b.toLong(aa.bGM(), 0L));
        this.jrs.setStType(this.mFrom);
        this.jrs.KQ(1);
        this.jrs.setNeedCache(true);
        this.jrs.setUpdateType(3);
        com.baidu.tieba.frs.f.j.a(this.jrG, this.jrs);
        this.jrs.setLoadType(1);
        if (by.eJG.get() && r.dFg().dFa() != null) {
            int ba = r.dFg().dFa().ba(this.iSP, false);
            int bb = r.dFg().dFa().bb(this.iSP, false);
            if (this.jrs.getLoadType() == 1) {
                i = ba + 1;
            } else if (this.jrs.getLoadType() == 2) {
                bb++;
                i = ba;
            } else {
                i = ba;
            }
            this.jrs.setRefreshCount(i);
            this.jrs.setLoadCount(bb);
        }
        this.jrt = new FrsNetModel(null, this.jrs);
        this.jrt.setUniqueId(((FrsActivity) this.jrm.getActivity()).getUniqueId());
        this.jrt.a(this);
        this.jrt.loadData();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.iSP);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void cIX() {
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
            this.jrI = com.baidu.tieba.frs.f.j.LG("1~" + str + this.iSP);
            Bm(this.jrG);
        }
    }

    public boolean csR() {
        if (this.jkd != 1) {
            Bg(1);
            return true;
        } else if (this.jrt.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jrs), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 1, false);
            return true;
        }
    }

    public void S(int i, boolean z) {
        if (this.jrs != null) {
            this.jrm.iTd = System.currentTimeMillis();
            if (this.iSv != null && this.iSv.getLikeFeedForumDataList() != null) {
                this.iSv.getLikeFeedForumDataList().clear();
            }
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jrs), FrsRequestData.class);
            frsRequestData.setPn(1);
            this.jkd = c(this.jkd, frsRequestData);
            if (this.jkd == 1) {
                if (!this.jrt.isLoading()) {
                    frsRequestData.setCallFrom(0);
                    b(frsRequestData, i, z ? false : true);
                    return;
                }
                return;
            }
            if (this.jrz == null) {
                this.jrz = new ba();
                this.jrz.pn = 1;
                this.jrz.forumName = this.iSP;
                if (this.iSv != null && this.iSv.getForum() != null) {
                    this.jrz.forumId = this.iSv.getForum().getId();
                }
            }
            Bg(i);
        }
    }

    public void T(int i, boolean z) {
        this.jrm.iTd = System.currentTimeMillis();
        if (this.iSv != null && this.iSv.getLikeFeedForumDataList() != null) {
            this.iSv.getLikeFeedForumDataList().clear();
        }
        this.jkd = c(this.jkd, this.jrs);
        if (this.jkd == 1) {
            a(this.jrs, i, z ? false : true);
            return;
        }
        if (this.jrz == null) {
            this.jrz = new ba();
            this.jrz.pn = 1;
            this.jrz.forumName = this.iSP;
            if (this.iSv != null && this.iSv.getForum() != null) {
                this.jrz.forumId = this.iSv.getForum().getId();
            }
        }
        Bg(i);
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.jrm.pT(z);
        this.jru.zJ(i);
        if (this.jrt.cJs() && (this.jrt.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
            a((MvcHttpResponsedMessage) this.jrt.getResponsedMessage(), (MvcHttpMessage) this.jrt.cJt(), this.jrt.cJu());
        } else if (this.jrt.cJs() && (this.jrt.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
            a((MvcSocketResponsedMessage) this.jrt.getResponsedMessage(), (MvcSocketMessage) this.jrt.cJt(), this.jrt.cJu());
        } else {
            int BD = com.baidu.tieba.frs.f.j.BD(this.jrI);
            if (!Bl(this.jrI) && !this.jrm.iSQ && !this.jrM) {
                String f = com.baidu.tieba.tbadkCore.e.dOg().f("1~" + this.iSP, BD, frsRequestData.getIsGood(), this.jrs.getCategoryId());
                this.jrK = f;
                new a(this, true, f).execute(new Object[0]);
            }
            this.jrM = false;
        }
        this.jrt.a(this);
    }

    public void Bh(int i) {
        if (this.jkd != 1) {
            Bg(4);
        } else if (!this.jrt.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jrs), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 4, false);
        }
    }

    private void b(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.jrm.pT(z);
        this.jru.zJ(i);
        this.jrt.a(frsRequestData);
        frsRequestData.Tw(this.jrm.cCN() ? "1" : "2");
        if (this.jrJ) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.j.BD(this.jrH)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.jrJ = false;
        frsRequestData.setKw(this.iSP);
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
        frsRequestData.setLastId(this.jqp);
        frsRequestData.setYuelaouLocate(this.jrF);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(aa.bGM(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.KQ(cIY());
        if (FrsFragment.iTe != 0) {
            frsRequestData.setCtime((int) FrsFragment.iTe);
        }
        if (FrsFragment.iTf != 0) {
            frsRequestData.setDataSize((int) FrsFragment.iTf);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.hG(this.jrw);
        com.baidu.tieba.frs.f.j.a(this.jrG, frsRequestData);
        int BD = com.baidu.tieba.frs.f.j.BD(this.jrI);
        b(i, frsRequestData);
        a(this.iSP, frsRequestData);
        if (!Bl(this.jrI) && !this.jrm.iSQ && !this.jrM) {
            String f = com.baidu.tieba.tbadkCore.e.dOg().f("1~" + this.iSP, BD, frsRequestData.getIsGood(), this.jrs.getCategoryId());
            this.jrK = f;
            new a(this, true, f).execute(new Object[0]);
        }
        cJb();
        this.jrM = false;
    }

    private int cIY() {
        return (this.jrm == null || !(this.jrm.mHeadLineDefaultNavTabId == -1 || this.jrm.mHeadLineDefaultNavTabId == this.jkd)) ? 0 : 1;
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
            this.jrm.fCi = mVar.getDataParseTime();
        }
        Bm(com.baidu.tieba.frs.f.j.BE(mVar.getSortType()));
        R(com.baidu.tieba.frs.f.j.BE(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.jkd = mVar.getFrsDefaultTabId();
        }
        this.iSv.receiveData(mVar);
        d(this.iSv);
        this.jrr = new ArrayList<>();
        if (frsRequestData != null) {
            this.jrs = frsRequestData;
            this.mPn = this.jrs.getPn();
            this.iSP = this.jrs.getKw();
            this.jrm.setForumName(this.iSP);
            this.jrm.setFrom(this.mFrom);
            this.jrm.setPn(this.mPn);
            this.jrm.setFlag(this.mFlag);
        }
        if (this.iSv.getThreadList() != null) {
            this.jrr.addAll(this.iSv.getThreadList());
        }
        if (this.jkd != 1 && this.isNetFirstLoad) {
            this.jru.a(7, false, this.jqo);
        } else {
            this.jru.a(this.mType, false, this.jqo);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.jrs)) {
            cJp();
        }
        if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iSv.getForum()));
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() != null && !TextUtils.isEmpty(mVar.getForum().getName()) && frsRequestData != null && r.dFg().dFa() != null) {
            r.dFg().dFa().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        if (StringUtils.isNull(mVar.getUserData().getAppealThreadPopover())) {
            return true;
        }
        this.jrm.aF(TbadkCoreApplication.getCurrentAccount(), mVar.getForum().getId(), mVar.getUserData().getAppealThreadPopover());
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        if (mvcSocketResponsedMessage != null) {
            this.jrN.g(this);
            this.jrN.a(mvcSocketResponsedMessage);
            this.jrN.a(mvcSocketMessage);
            this.jrN.a(mvcNetMessage);
            this.jrN.a(this.jru);
            Looper.myQueue().addIdleHandler(this.jrN);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iCW = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.njx = mvcSocketResponsedMessage.getDownSize();
            this.jqo = fVar;
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
                this.jrm.a(errorData);
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
            this.jrO.g(this);
            this.jrO.a(mvcHttpResponsedMessage);
            this.jrO.a(mvcHttpMessage);
            this.jrO.a(mvcNetMessage);
            this.jrO.a(this.jru);
            Looper.myQueue().addIdleHandler(this.jrO);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iCW = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.njx = mvcHttpResponsedMessage.getDownSize();
            this.jqo = fVar;
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
                this.jrm.a(errorData);
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

    public void cCE() {
        if (this.iSv != null && this.iSv.getForum() != null && this.iSv.getForum().getBannerListData() != null) {
            String lastIds = this.iSv.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.jqp = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.l.bFl().isSmallFlow()) {
            this.fCm = System.currentTimeMillis() - this.jrm.ivA;
            this.jrm.fCl = System.currentTimeMillis() - this.jrm.iTc;
            com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(i, z, responsedMessage, this.jrm.fCb, this.jrm.createTime, this.jrm.fCl, false, this.jrm.fCc, this.jrm.fCi, this.fCm);
            this.jrm.createTime = 0L;
            this.jrm.fCb = 0L;
            com.baidu.tieba.frs.f.k.a(this, this.jrm.ivA);
            this.jrm.ivA = -1L;
            hVar.bFi();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.l.bFl().isSmallFlow()) {
            this.fCm = System.currentTimeMillis() - this.jrm.iTd;
            this.jrm.fCl = System.currentTimeMillis() - this.jrm.iTc;
            com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(1000, z, responsedMessage, this.jrm.fCb, this.jrm.createTime, this.jrm.fCl, false, this.jrm.fCc, this.jrm.fCi, this.fCm);
            if (this.mType == 4) {
                hVar.fCu = this.fCm;
                hVar.kR(true);
            } else if (this.mType == 3) {
                hVar.fCv = this.fCm;
                hVar.kR(false);
            }
        }
    }

    public FrsRequestData cIZ() {
        return this.jrs;
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

    public FrsViewData cIF() {
        return this.iSv;
    }

    public com.baidu.tieba.tbadkCore.f cJa() {
        return this.jqo;
    }

    private boolean cJb() {
        this.iym = System.currentTimeMillis();
        return this.jrt.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.iSv.receiveData(mVar);
        d(this.iSv);
        this.jrr = new ArrayList<>();
        if (this.iSv.getThreadList() != null) {
            this.jrr.addAll(this.iSv.getThreadList());
        }
        this.jru.c(mVar);
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
        private FrsModelController jrT;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.bOf = null;
            this.bOf = str;
            this.jrT = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.dOg().Tu(this.bOf)) {
                if (!com.baidu.tieba.tbadkCore.e.dOg().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.bOf)) {
                    com.baidu.tieba.tbadkCore.e.dOg().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.dOg().getResponseData();
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
            if (this.jrT != null && mVarArr != null) {
                this.jrT.e(mVarArr.length > 0 ? mVarArr[0] : null);
                this.jrT.R(this.jrT.jrG, true);
            } else if (this.jrT != null && !this.jrT.jrt.cJs()) {
                if (this.jrT.jrt.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                    this.jrT.a((MvcHttpResponsedMessage) this.jrT.jrt.getResponsedMessage(), (MvcHttpMessage) this.jrT.jrt.cJt(), this.jrT.jrt.cJu());
                }
                if (this.jrT.jrt.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                    this.jrT.a((MvcSocketResponsedMessage) this.jrT.jrt.getResponsedMessage(), (MvcSocketMessage) this.jrT.jrt.cJt(), this.jrT.jrt.cJu());
                }
            }
        }
    }

    public long cwm() {
        return this.iyp;
    }

    public long cwn() {
        return this.iyn;
    }

    public long cwo() {
        return this.iyo;
    }

    public long cwp() {
        return this.iym;
    }

    public boolean isLoading() {
        return this.jrt.isLoading();
    }

    public int cJc() {
        return this.jry;
    }

    private void cJd() {
        if (this.jrE == null) {
            this.jrE = new ArrayList<>();
        }
        if (this.jrE.size() == 0) {
            this.jrE.add(new ad());
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void a(int i, int i2, ba baVar) {
        this.jkd = c(i, null);
        if (baVar == null && (baVar = cF(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.jrD != null) {
                bd bdVar = new bd();
                bdVar.hasMore = false;
                bdVar.pn = 1;
                bdVar.forumName = this.iSP;
                bdVar.iXU = false;
                if (this.iSv != null && this.iSv.getForum() != null) {
                    bdVar.forumId = this.iSv.getForum().getId();
                }
                cJd();
                this.iSv.setThreadList(this.jrE);
                this.jrD.a(i, i2, bdVar, this.jrE);
            }
            baVar = new ba();
            baVar.pn = -1;
        }
        if (this.iSv != null && this.iSv.getForum() != null) {
            baVar.forumId = this.iSv.getForum().getId();
        }
        baVar.forumName = this.iSP;
        if (af.cEi().Ah(1) != null && this.jkd == 1) {
            this.jrs.setCategoryId(i2);
        }
        this.jrx = i2;
        this.jrz = baVar;
        b(i, i2, baVar);
        Bg(5);
    }

    @Override // com.baidu.tieba.frs.aq
    public void a(au auVar) {
        this.jrD = auVar;
        this.jrC.a(this.jrP);
    }

    private void Bg(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.jrz != null) {
                    this.jrz.pn++;
                    break;
                }
                break;
            case 2:
                if (this.jrz != null) {
                    ba baVar = this.jrz;
                    baVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.jrz != null) {
                    this.jrz.pn = -1;
                    break;
                }
                break;
        }
        if (this.jkd == 1) {
            if (this.jry == this.jrx) {
                ArrayList<q> arrayList = new ArrayList<>();
                if (this.jrr != null) {
                    arrayList.addAll(this.jrr);
                }
                this.iSv.setThreadList(arrayList);
                if (this.jrD != null) {
                    this.jrD.a(this.jkd, this.jrx, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.jry = this.jrx;
            return;
        }
        aq Ai = this.jrC.Ai(this.jkd);
        if (Ai != null) {
            this.jrA = true;
            Ai.a(this.jkd, this.jrx, this.jrz);
            return;
        }
        if (this.iSv != null && this.iSv.getThreadList() != null) {
            this.iSv.getThreadList().clear();
        }
        this.jrD.a(this.jkd, this.jrx, null, null);
    }

    public boolean hasMore() {
        if ((this.jrz instanceof bd) && ((bd) this.jrz).errCode == 0) {
            return ((bd) this.jrz).hasMore;
        }
        return true;
    }

    private int cE(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ba baVar) {
        this.jrB.put(cE(i, i2), baVar);
    }

    public ba cF(int i, int i2) {
        return this.jrB.get(cE(i, i2));
    }

    @Override // com.baidu.tieba.frs.aq
    public void init() {
        this.jrC.init();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bYZ() {
        this.jrC.destory();
        this.jrC.clear();
    }

    public int cJe() {
        return this.jkd;
    }

    public boolean cJf() {
        return 1 == this.jkd;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(com.baidu.tbadk.core.data.au auVar) {
        if (auVar != null && !StringUtils.isNull(auVar.getId()) && !y.isEmpty(this.jrr)) {
            if (this.jkd == 1) {
                this.iSv.addMyNewThread(auVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<q> it = this.jrr.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if ((next instanceof bx) && auVar.getId().equals(((bx) next).eCR.getId())) {
                    return;
                }
            }
            this.jrr.add(topThreadSize, auVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.jrr == null || this.jrr.size() <= 0) {
            return 0;
        }
        Iterator<q> it = this.jrr.iterator();
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

    public boolean cJg() {
        return this.jrA;
    }

    public void cJh() {
        com.baidu.tieba.frs.s sVar = new com.baidu.tieba.frs.s();
        if (this.jry == 0) {
            sVar.zZ(this.jrG);
        }
        if (this.iSv.getThreadList() != null) {
            this.iSv.getThreadList().clear();
            this.iSv.getThreadList().add(sVar);
        }
        if (this.jrr != null) {
            this.jrr.clear();
            this.jrr.add(sVar);
        }
    }

    public ArrayList<q> cJi() {
        return this.jrr;
    }

    public void Bm(int i) {
        AccountData currentAccountObj;
        this.jrG = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.f.j.aS("1~" + str + this.iSP, this.jrG);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dQv();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dQw();
        }
    }

    public void Bn(int i) {
        this.jrH = i;
    }

    public void qP(boolean z) {
        this.jrJ = z;
    }

    public int cJj() {
        return this.jrG;
    }

    public int cJk() {
        return this.jrI;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.j.BD(this.jrG);
    }

    public boolean cJl() {
        return this.jrv;
    }

    public boolean cJm() {
        return this.jrG == 5;
    }

    public boolean cJn() {
        return this.jrs != null && this.jrs.getLoadType() == 1;
    }

    public boolean cJo() {
        return this.jrG == 7 || (!this.jrt.cJs() && this.jrI == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.jrm.cBW() != null) {
            return this.jrm.cBW().a(this.jrG, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (by.eJG.get() && r.dFg().dFa() != null) {
            int ba = r.dFg().dFa().ba(str, false);
            int bb = r.dFg().dFa().bb(str, false);
            if (frsRequestData.getLoadType() == 1) {
                ba++;
            } else if (frsRequestData.getLoadType() == 2) {
                bb++;
            }
            frsRequestData.setRefreshCount(ba);
            frsRequestData.setLoadCount(bb);
        }
    }

    public void cJp() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.iSv != null && this.iSv.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.iSv.getForum().getId(), 0L));
        }
        this.jrm.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void Lz(final String str) {
        com.baidu.tbadk.util.ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dOg().gq(FrsModelController.this.jrK, str);
                return null;
            }
        }, null);
    }

    public void LA(final String str) {
        com.baidu.tbadk.util.ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dOg().gr(FrsModelController.this.jrK, str);
                return null;
            }
        }, null);
    }

    public void LB(final String str) {
        com.baidu.tbadk.util.ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dOg().gs(FrsModelController.this.jrK, str);
                return null;
            }
        }, null);
    }

    public void qQ(boolean z) {
        this.jrM = z;
    }
}
