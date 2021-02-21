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
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.s;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.m>, an {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private boolean eWO;
    private long fJv;
    private long iLP;
    private long iLQ;
    private long iLR;
    private long iLS;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private com.baidu.tieba.tbadkCore.f jDX;
    private String jDY;
    private final FrsFragment jEV;
    private ArrayList<com.baidu.adp.widget.ListView.n> jFa;
    private FrsRequestData jFb;
    private FrsNetModel jFc;
    private final s jFd;
    private boolean jFe;
    private long jFf;
    private int jFg;
    private int jFh;
    private ax jFi;
    private boolean jFj;
    private SparseArray<ax> jFk;
    private ae jFl;
    private ar jFm;
    private ArrayList<com.baidu.adp.widget.ListView.n> jFn;
    private String jFo;
    private int jFp;
    private int jFq;
    private int jFr;
    private boolean jFs;
    private String jFt;
    private final SparseArray<Boolean> jFu;
    private boolean jFv;
    private n jFw;
    private m jFx;
    private ar jFy;
    private FrsViewData jfU;
    private String jgn;
    private int jxQ;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSchemeUrl;
    private String mSource;
    private int mType;

    public boolean Aa(int i) {
        return this.jFu.get(i, false).booleanValue();
    }

    public void R(int i, boolean z) {
        this.jFu.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, s sVar) {
        super(frsFragment.getPageContext());
        this.jgn = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSchemeUrl = "";
        this.mSource = null;
        this.jDY = null;
        this.jFf = 0L;
        this.jxQ = 1;
        this.jFg = 0;
        this.jFh = 0;
        this.jFj = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.jFk = new SparseArray<>();
        this.fJv = 0L;
        this.eWO = false;
        this.jFp = -1;
        this.jFq = -1;
        this.jFr = -1;
        this.jFt = null;
        this.jFu = new SparseArray<>();
        this.jFw = new n();
        this.jFx = new m();
        this.jFy = new ar() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ar
            public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
                FrsModelController.this.jFj = false;
                if (i == FrsModelController.this.jxQ && FrsModelController.this.jFm != null) {
                    FrsModelController.this.jFi = baVar;
                    FrsModelController.this.b(i, i2, baVar);
                    ArrayList<com.baidu.adp.widget.ListView.n> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.jfU.setThreadList(arrayList2);
                    FrsModelController.this.jFm.a(i, i2, baVar, arrayList);
                }
            }
        };
        this.iLP = 0L;
        this.iLQ = 0L;
        this.iLR = 0L;
        this.iLS = 0L;
        if (sVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.jEV = frsFragment;
        this.jFd = sVar;
        if (this.jEV.getActivity() instanceof FrsActivity) {
            this.jFc = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.jEV.getActivity()).getUniqueId().getId());
        }
        if (this.jFc != null) {
            if (this.jFc.getResponsedMessage() == null) {
                this.jFc.a(this);
            }
            this.jFb = this.jFc.cJU();
        }
        Z(this.jEV);
    }

    private void Z(FrsFragment frsFragment) {
        this.jFl = new ae();
        this.jFl.fGZ = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.jFl));
        this.jFl.a(this.jFy);
    }

    public void cJg() {
        Looper.myQueue().removeIdleHandler(this.jFw);
        Looper.myQueue().removeIdleHandler(this.jFx);
        this.jFc.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.jgn = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.jFo = bundle.getString("yuelaou_locate");
            this.jFe = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.jEV.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.jgn)) {
            this.jgn = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.jFo)) {
            this.jFo = "";
        }
        this.mSource = this.mFrom;
        cJA();
        if (this.jfU == null) {
            this.jfU = new FrsViewData();
        }
        if (this.jFc == null || this.jFb == null || this.jFb.bDl() == null || this.jFb.bDl().isEmpty() || this.jFb.bDl().containsKey(null) || this.jFb.bDl().containsValue(null)) {
            ar(bundle);
        }
        if (this.jgn != null && this.jgn.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    private void ar(Bundle bundle) {
        int i;
        this.jFb = new FrsRequestData();
        this.jFb.setSortType(com.baidu.tieba.frs.d.j.At(this.jFp));
        if (this.jFp == 5) {
            this.jFb.setIsGood(1);
        } else {
            this.jFb.setIsGood(0);
        }
        this.jFb.gx("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.jgn));
        this.jFb.gx("client_type", "2");
        this.jFb.setPn(1);
        if (bundle != null) {
            this.jFb.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
            this.jFb.hG(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
        }
        this.jFb.Tg("2");
        this.jFb.setObjSource("-2");
        this.jFb.setKw(this.jgn);
        this.jFb.setWithGroup(1);
        this.jFb.setCid(0);
        this.jFb.setScrW(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        this.jFb.setScrH(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        this.jFb.setScrDip(com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        this.jFb.setqType(av.bsS().bsT() ? 2 : 1);
        this.jFb.setSchemeUrl(this.mSchemeUrl);
        this.jFb.setLastId(null);
        this.jFb.setYuelaouLocate(this.jFo);
        this.jFb.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ab.bFH(), 0L));
        this.jFb.setStType(this.mFrom);
        this.jFb.Jy(1);
        this.jFb.setNeedCache(true);
        this.jFb.setUpdateType(3);
        this.jFb.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jfU == null ? null : this.jfU.getThreadList(), true));
        com.baidu.tieba.frs.d.j.a(this.jFp, this.jFb);
        this.jFb.setLoadType(1);
        if (cb.eRa.get() && com.baidu.tieba.recapp.s.dDt().dDn() != null) {
            int ba = com.baidu.tieba.recapp.s.dDt().dDn().ba(this.jgn, false);
            int bb = com.baidu.tieba.recapp.s.dDt().dDn().bb(this.jgn, false);
            if (this.jFb.getLoadType() == 1) {
                i = ba + 1;
            } else if (this.jFb.getLoadType() == 2) {
                bb++;
                i = ba;
            } else {
                i = ba;
            }
            this.jFb.setRefreshCount(i);
            this.jFb.setLoadCount(bb);
        }
        this.jFc = new FrsNetModel(null, this.jFb);
        this.jFc.setUniqueId(((FrsActivity) this.jEV.getActivity()).getUniqueId());
        this.jFc.a(this);
        this.jFc.loadData();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.jgn);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void cJA() {
        AccountData currentAccountObj;
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            Ac(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            Ac(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            this.jFr = com.baidu.tieba.frs.d.j.Lh("1~" + str + this.jgn);
            Ac(this.jFp);
        }
    }

    public boolean ctm() {
        if (this.jxQ != 1) {
            zW(1);
            return true;
        } else if (this.jFc.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jFb), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 1, false);
            return true;
        }
    }

    public void S(int i, boolean z) {
        if (this.jFb != null) {
            this.jEV.jgB = System.currentTimeMillis();
            if (this.jfU != null && this.jfU.getLikeFeedForumDataList() != null) {
                this.jfU.getLikeFeedForumDataList().clear();
            }
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jFb), FrsRequestData.class);
            frsRequestData.setPn(1);
            this.jxQ = c(this.jxQ, frsRequestData);
            if (this.jxQ == 1) {
                if (!this.jFc.isLoading()) {
                    frsRequestData.setCallFrom(0);
                    b(frsRequestData, i, z ? false : true);
                    return;
                }
                return;
            }
            if (this.jFi == null) {
                this.jFi = new ax();
                this.jFi.pn = 1;
                this.jFi.forumName = this.jgn;
                if (this.jfU != null && this.jfU.getForum() != null) {
                    this.jFi.forumId = this.jfU.getForum().getId();
                }
            }
            zW(i);
        }
    }

    public void T(int i, boolean z) {
        this.jEV.jgB = System.currentTimeMillis();
        if (this.jfU != null && this.jfU.getLikeFeedForumDataList() != null) {
            this.jfU.getLikeFeedForumDataList().clear();
        }
        this.jxQ = c(this.jxQ, this.jFb);
        this.jFb.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jfU == null ? null : this.jfU.getThreadList(), true));
        if (this.jxQ == 1) {
            a(this.jFb, i, !z);
            return;
        }
        if (this.jFi == null) {
            this.jFi = new ax();
            this.jFi.pn = 1;
            this.jFi.forumName = this.jgn;
            if (this.jfU != null && this.jfU.getForum() != null) {
                this.jFi.forumId = this.jfU.getForum().getId();
            }
        }
        zW(i);
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.jEV.qw(z);
        this.jFd.yA(i);
        if (this.jFc.cJV() && (this.jFc.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
            a((MvcHttpResponsedMessage) this.jFc.getResponsedMessage(), (MvcHttpMessage) this.jFc.cJW(), this.jFc.cJX());
        } else if (this.jFc.cJV() && (this.jFc.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
            a((MvcSocketResponsedMessage) this.jFc.getResponsedMessage(), (MvcSocketMessage) this.jFc.cJW(), this.jFc.cJX());
        } else {
            int At = com.baidu.tieba.frs.d.j.At(this.jFr);
            if (!Aa(this.jFr) && !this.jEV.jgo && !this.jFv) {
                String f = com.baidu.tieba.tbadkCore.e.dMA().f("1~" + this.jgn, At, frsRequestData.getIsGood(), this.jFb.getCategoryId());
                this.jFt = f;
                new a(this, true, f).execute(new Object[0]);
            }
            this.jFv = false;
        }
        this.jFc.a(this);
    }

    public void Ab(int i) {
        if (this.jxQ != 1) {
            zW(4);
        } else if (!this.jFc.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jFb), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 4, false);
        }
    }

    private void b(FrsRequestData frsRequestData, int i, boolean z) {
        boolean z2;
        this.mType = i;
        this.jEV.qw(z);
        this.jFd.yA(i);
        this.jFc.a(frsRequestData);
        frsRequestData.Tg(this.jEV.cDj() ? "1" : "2");
        if (this.jFs) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.d.j.At(this.jFq)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.jFs = false;
        frsRequestData.setKw(this.jgn);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = av.bsS().bsT() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setSchemeUrl(this.mSchemeUrl);
        frsRequestData.setLastId(this.jDY);
        frsRequestData.setYuelaouLocate(this.jFo);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ab.bFH(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.Jy(cJB());
        if (FrsFragment.jgC != 0) {
            frsRequestData.setCtime((int) FrsFragment.jgC);
        }
        if (FrsFragment.jgD != 0) {
            frsRequestData.setDataSize((int) FrsFragment.jgD);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        if (frsRequestData.getPn() == 1 || this.mType == 3) {
            frsRequestData.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jfU == null ? null : this.jfU.getThreadList(), true));
            z2 = true;
        } else {
            frsRequestData.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jfU != null ? this.jfU.getThreadList() : null, false));
            z2 = false;
        }
        frsRequestData.setNeedCache(z2);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.hG(this.jFf);
        com.baidu.tieba.frs.d.j.a(this.jFp, frsRequestData);
        int At = com.baidu.tieba.frs.d.j.At(this.jFr);
        b(i, frsRequestData);
        a(this.jgn, frsRequestData);
        if (!Aa(this.jFr) && !this.jEV.jgo && !this.jFv) {
            String f = com.baidu.tieba.tbadkCore.e.dMA().f("1~" + this.jgn, At, frsRequestData.getIsGood(), this.jFb.getCategoryId());
            this.jFt = f;
            new a(this, true, f).execute(new Object[0]);
        }
        cJE();
        this.jFv = false;
    }

    private int cJB() {
        return (this.jEV == null || !(this.jEV.mHeadLineDefaultNavTabId == -1 || this.jEV.mHeadLineDefaultNavTabId == this.jxQ)) ? 0 : 1;
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
        if (mVar == null || mVar.getForum() == null || (au.isEmpty(mVar.getForum().getName()) && 340001 != mVar.mErrorNo)) {
            return false;
        }
        if (mVar.getDataParseTime() > 0) {
            this.jEV.fJr = mVar.getDataParseTime();
        }
        Ac(com.baidu.tieba.frs.d.j.Au(mVar.getSortType()));
        R(com.baidu.tieba.frs.d.j.Au(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.jxQ = mVar.getFrsDefaultTabId();
        }
        this.jfU.receiveData(mVar);
        d(this.jfU);
        this.jFa = new ArrayList<>();
        if (frsRequestData != null) {
            this.jFb = frsRequestData;
            this.mPn = this.jFb.getPn();
            this.jgn = this.jFb.getKw();
            this.jEV.setForumName(this.jgn);
            this.jEV.setFrom(this.mFrom);
            this.jEV.setPn(this.mPn);
            this.jEV.setFlag(this.mFlag);
        }
        if (this.jfU.getThreadList() != null) {
            this.jFa.addAll(this.jfU.getThreadList());
        }
        if (this.jxQ != 1 && this.isNetFirstLoad) {
            this.jFd.a(7, false, this.jDX);
        } else {
            this.jFd.a(this.mType, false, this.jDX);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.jFb)) {
            cJS();
        }
        if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jfU.getForum()));
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() != null && !TextUtils.isEmpty(mVar.getForum().getName()) && frsRequestData != null && com.baidu.tieba.recapp.s.dDt().dDn() != null) {
            com.baidu.tieba.recapp.s.dDt().dDn().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        if (StringUtils.isNull(mVar.getUserData().getAppealThreadPopover())) {
            return true;
        }
        this.jEV.aI(TbadkCoreApplication.getCurrentAccount(), mVar.getForum().getId(), mVar.getUserData().getAppealThreadPopover());
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        FrsRequestData requestData;
        if (mvcSocketResponsedMessage != null) {
            this.jFw.g(this);
            this.jFw.a(mvcSocketResponsedMessage);
            this.jFw.a(mvcSocketMessage);
            this.jFw.a(mvcNetMessage);
            this.jFw.a(this.jFd);
            Looper.myQueue().addIdleHandler(this.jFw);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iQx = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.nuG = mvcSocketResponsedMessage.getDownSize();
            this.jDX = fVar;
            if (!mvcSocketResponsedMessage.hasError() || 340001 == mvcSocketResponsedMessage.getError()) {
                data = mvcSocketResponsedMessage.getData();
                requestData = mvcNetMessage != null ? mvcNetMessage.getRequestData() : mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            } else {
                data = null;
                requestData = null;
            }
            if (requestData == null || data == null || !a(requestData, data)) {
                ErrorData errorData = new ErrorData();
                this.mErrorCode = mvcSocketResponsedMessage.getError();
                this.mErrorString = mvcSocketResponsedMessage.getErrorString();
                errorData.setError_code(this.mErrorCode);
                errorData.setError_msg(this.mErrorString);
                this.jEV.a(errorData);
            }
        }
    }

    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.eWO) {
            this.eWO = true;
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
            this.jFx.g(this);
            this.jFx.a(mvcHttpResponsedMessage);
            this.jFx.a(mvcHttpMessage);
            this.jFx.a(mvcNetMessage);
            this.jFx.a(this.jFd);
            Looper.myQueue().addIdleHandler(this.jFx);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iQx = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.nuG = mvcHttpResponsedMessage.getDownSize();
            this.jDX = fVar;
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
                this.jEV.a(errorData);
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
        if (!this.eWO) {
            this.eWO = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void cDa() {
        if (this.jfU != null && this.jfU.getForum() != null && this.jfU.getForum().getBannerListData() != null) {
            String lastIds = this.jfU.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.jDY = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.k.bEg().isSmallFlow()) {
            this.fJv = System.currentTimeMillis() - this.jEV.iJe;
            this.jEV.fJu = System.currentTimeMillis() - this.jEV.jgA;
            com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(i, z, responsedMessage, this.jEV.fJl, this.jEV.createTime, this.jEV.fJu, false, this.jEV.fJm, this.jEV.fJr, this.fJv);
            this.jEV.createTime = 0L;
            this.jEV.fJl = 0L;
            com.baidu.tieba.frs.d.k.a(this, this.jEV.iJe);
            this.jEV.iJe = -1L;
            hVar.bEd();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.k.bEg().isSmallFlow()) {
            this.fJv = System.currentTimeMillis() - this.jEV.jgB;
            this.jEV.fJu = System.currentTimeMillis() - this.jEV.jgA;
            com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(1000, z, responsedMessage, this.jEV.fJl, this.jEV.createTime, this.jEV.fJu, false, this.jEV.fJm, this.jEV.fJr, this.fJv);
            if (this.mType == 4) {
                hVar.fJD = this.fJv;
                hVar.lm(true);
            } else if (this.mType == 3) {
                hVar.fJE = this.fJv;
                hVar.lm(false);
            }
        }
    }

    public FrsRequestData cJC() {
        return this.jFb;
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

    public FrsViewData cJi() {
        return this.jfU;
    }

    public com.baidu.tieba.tbadkCore.f cJD() {
        return this.jDX;
    }

    private boolean cJE() {
        this.iLP = System.currentTimeMillis();
        return this.jFc.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.jfU.receiveData(mVar);
        d(this.jfU);
        this.jFa = new ArrayList<>();
        if (this.jfU.getThreadList() != null) {
            this.jFa.addAll(this.jfU.getThreadList());
        }
        this.jFd.c(mVar);
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

    /* loaded from: classes2.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.m, Void> {
        private FrsModelController jFB;
        private String mCacheKey;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.mCacheKey = null;
            this.mCacheKey = str;
            this.jFB = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.dMA().Te(this.mCacheKey)) {
                if (!com.baidu.tieba.tbadkCore.e.dMA().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.mCacheKey)) {
                    com.baidu.tieba.tbadkCore.e.dMA().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.dMA().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().blT(), true) && !responseData.getBookInfo().blT().equals("0") && responseData.getBookInfo().blU() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().blT(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.jFB != null && mVarArr != null) {
                this.jFB.f(mVarArr.length > 0 ? mVarArr[0] : null);
                this.jFB.R(this.jFB.jFp, true);
            } else if (this.jFB != null && !this.jFB.jFc.cJV()) {
                if (this.jFB.jFc.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                    this.jFB.a((MvcHttpResponsedMessage) this.jFB.jFc.getResponsedMessage(), (MvcHttpMessage) this.jFB.jFc.cJW(), this.jFB.jFc.cJX());
                }
                if (this.jFB.jFc.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                    this.jFB.a((MvcSocketResponsedMessage) this.jFB.jFc.getResponsedMessage(), (MvcSocketMessage) this.jFB.jFc.cJW(), this.jFB.jFc.cJX());
                }
            }
        }
    }

    public long cwH() {
        return this.iLS;
    }

    public long cwI() {
        return this.iLQ;
    }

    public long cwJ() {
        return this.iLR;
    }

    public long cwK() {
        return this.iLP;
    }

    public boolean isLoading() {
        return this.jFc.isLoading();
    }

    public int cJF() {
        return this.jFh;
    }

    private void cJG() {
        if (this.jFn == null) {
            this.jFn = new ArrayList<>();
        }
        if (this.jFn.size() == 0) {
            this.jFn.add(new aa());
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void a(int i, int i2, ax axVar) {
        this.jxQ = c(i, null);
        if (axVar == null && (axVar = cA(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.jFm != null) {
                ba baVar = new ba();
                baVar.hasMore = false;
                baVar.pn = 1;
                baVar.forumName = this.jgn;
                baVar.jlv = false;
                if (this.jfU != null && this.jfU.getForum() != null) {
                    baVar.forumId = this.jfU.getForum().getId();
                }
                cJG();
                this.jfU.setThreadList(this.jFn);
                this.jFm.a(i, i2, baVar, this.jFn);
            }
            axVar = new ax();
            axVar.pn = -1;
        }
        if (this.jfU != null && this.jfU.getForum() != null) {
            axVar.forumId = this.jfU.getForum().getId();
        }
        axVar.forumName = this.jgn;
        if (ac.cEF().yX(1) != null && this.jxQ == 1) {
            this.jFb.setCategoryId(i2);
        }
        this.jFg = i2;
        this.jFi = axVar;
        b(i, i2, axVar);
        zW(5);
    }

    @Override // com.baidu.tieba.frs.an
    public void a(ar arVar) {
        this.jFm = arVar;
        this.jFl.a(this.jFy);
    }

    private void zW(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.jFi != null) {
                    this.jFi.pn++;
                    break;
                }
                break;
            case 2:
                if (this.jFi != null) {
                    ax axVar = this.jFi;
                    axVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.jFi != null) {
                    this.jFi.pn = -1;
                    break;
                }
                break;
        }
        if (this.jxQ == 1) {
            if (this.jFh == this.jFg) {
                ArrayList<com.baidu.adp.widget.ListView.n> arrayList = new ArrayList<>();
                if (this.jFa != null) {
                    arrayList.addAll(this.jFa);
                }
                this.jfU.setThreadList(arrayList);
                if (this.jFm != null) {
                    this.jFm.a(this.jxQ, this.jFg, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.jFh = this.jFg;
            return;
        }
        an yY = this.jFl.yY(this.jxQ);
        if (yY != null) {
            this.jFj = true;
            yY.a(this.jxQ, this.jFg, this.jFi);
            return;
        }
        if (this.jfU != null && this.jfU.getThreadList() != null) {
            this.jfU.getThreadList().clear();
        }
        this.jFm.a(this.jxQ, this.jFg, null, null);
    }

    public boolean hasMore() {
        if ((this.jFi instanceof ba) && ((ba) this.jFi).errCode == 0) {
            return ((ba) this.jFi).hasMore;
        }
        return true;
    }

    private int cz(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ax axVar) {
        this.jFk.put(cz(i, i2), axVar);
    }

    public ax cA(int i, int i2) {
        return this.jFk.get(cz(i, i2));
    }

    @Override // com.baidu.tieba.frs.an
    public void init() {
        this.jFl.init();
    }

    @Override // com.baidu.tieba.frs.an
    public void bYU() {
        this.jFl.destory();
        this.jFl.clear();
    }

    public int cJH() {
        return this.jxQ;
    }

    public boolean cJI() {
        return 1 == this.jxQ;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(aw awVar) {
        if (awVar != null && !StringUtils.isNull(awVar.getId()) && !y.isEmpty(this.jFa)) {
            if (this.jxQ == 1) {
                this.jfU.addMyNewThread(awVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<com.baidu.adp.widget.ListView.n> it = this.jFa.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.n next = it.next();
                if ((next instanceof ca) && awVar.getId().equals(((ca) next).eJQ.getId())) {
                    return;
                }
            }
            this.jFa.add(topThreadSize, awVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.jFa == null || this.jFa.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.n> it = this.jFa.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.n next = it.next();
                if (!(next instanceof ca)) {
                    i = i2;
                } else if (((ca) next).eJQ.bnL() != 0) {
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

    public boolean cJJ() {
        return this.jFj;
    }

    public void cJK() {
        com.baidu.tieba.frs.s sVar = new com.baidu.tieba.frs.s();
        if (this.jFh == 0) {
            sVar.yP(this.jFp);
        }
        if (this.jfU.getThreadList() != null) {
            this.jfU.getThreadList().clear();
            this.jfU.getThreadList().add(sVar);
        }
        if (this.jFa != null) {
            this.jFa.clear();
            this.jFa.add(sVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cJL() {
        return this.jFa;
    }

    public void Ac(int i) {
        AccountData currentAccountObj;
        this.jFp = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.d.j.ba("1~" + str + this.jgn, this.jFp);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dOT();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dOU();
        }
    }

    public void Ad(int i) {
        this.jFq = i;
    }

    public void rt(boolean z) {
        this.jFs = z;
    }

    public int cJM() {
        return this.jFp;
    }

    public int cJN() {
        return this.jFr;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.d.j.At(this.jFp);
    }

    public boolean cJO() {
        return this.jFe;
    }

    public boolean cJP() {
        return this.jFp == 5;
    }

    public boolean cJQ() {
        return this.jFb != null && this.jFb.getLoadType() == 1;
    }

    public boolean cJR() {
        return this.jFp == 7 || (!this.jFc.cJV() && this.jFr == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.jEV.cCs() != null) {
            return this.jEV.cCs().a(this.jFp, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (cb.eRa.get() && com.baidu.tieba.recapp.s.dDt().dDn() != null) {
            int ba = com.baidu.tieba.recapp.s.dDt().dDn().ba(str, false);
            int bb = com.baidu.tieba.recapp.s.dDt().dDn().bb(str, false);
            if (frsRequestData.getLoadType() == 1) {
                ba++;
            } else if (frsRequestData.getLoadType() == 2) {
                bb++;
            }
            frsRequestData.setRefreshCount(ba);
            frsRequestData.setLoadCount(bb);
        }
    }

    public void cJS() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.jfU != null && this.jfU.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.jfU.getForum().getId(), 0L));
        }
        this.jEV.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void La(final String str) {
        af.a(new com.baidu.tbadk.util.ae<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ae
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dMA().gu(FrsModelController.this.jFt, str);
                return null;
            }
        }, null);
    }

    public void Lb(final String str) {
        af.a(new com.baidu.tbadk.util.ae<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ae
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dMA().gv(FrsModelController.this.jFt, str);
                return null;
            }
        }, null);
    }

    public void Lc(final String str) {
        af.a(new com.baidu.tbadk.util.ae<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ae
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dMA().gw(FrsModelController.this.jFt, str);
                return null;
            }
        }, null);
    }

    public void ru(boolean z) {
        this.jFv = z;
    }
}
