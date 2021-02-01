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
import com.baidu.tieba.recapp.r;
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
    private long iLB;
    private long iLC;
    private long iLD;
    private long iLE;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private com.baidu.tieba.tbadkCore.f jDJ;
    private String jDK;
    private final FrsFragment jEH;
    private ArrayList<com.baidu.adp.widget.ListView.n> jEM;
    private FrsRequestData jEN;
    private FrsNetModel jEO;
    private final s jEP;
    private boolean jEQ;
    private long jER;
    private int jES;
    private int jET;
    private ax jEU;
    private boolean jEV;
    private SparseArray<ax> jEW;
    private ae jEX;
    private ar jEY;
    private ArrayList<com.baidu.adp.widget.ListView.n> jEZ;
    private String jFa;
    private int jFb;
    private int jFc;
    private int jFd;
    private boolean jFe;
    private String jFf;
    private final SparseArray<Boolean> jFg;
    private boolean jFh;
    private n jFi;
    private m jFj;
    private ar jFk;
    private FrsViewData jfG;
    private String jfZ;
    private int jxC;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSchemeUrl;
    private String mSource;
    private int mType;

    public boolean Aa(int i) {
        return this.jFg.get(i, false).booleanValue();
    }

    public void R(int i, boolean z) {
        this.jFg.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, s sVar) {
        super(frsFragment.getPageContext());
        this.jfZ = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSchemeUrl = "";
        this.mSource = null;
        this.jDK = null;
        this.jER = 0L;
        this.jxC = 1;
        this.jES = 0;
        this.jET = 0;
        this.jEV = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.jEW = new SparseArray<>();
        this.fJv = 0L;
        this.eWO = false;
        this.jFb = -1;
        this.jFc = -1;
        this.jFd = -1;
        this.jFf = null;
        this.jFg = new SparseArray<>();
        this.jFi = new n();
        this.jFj = new m();
        this.jFk = new ar() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ar
            public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
                FrsModelController.this.jEV = false;
                if (i == FrsModelController.this.jxC && FrsModelController.this.jEY != null) {
                    FrsModelController.this.jEU = baVar;
                    FrsModelController.this.b(i, i2, baVar);
                    ArrayList<com.baidu.adp.widget.ListView.n> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.jfG.setThreadList(arrayList2);
                    FrsModelController.this.jEY.a(i, i2, baVar, arrayList);
                }
            }
        };
        this.iLB = 0L;
        this.iLC = 0L;
        this.iLD = 0L;
        this.iLE = 0L;
        if (sVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.jEH = frsFragment;
        this.jEP = sVar;
        if (this.jEH.getActivity() instanceof FrsActivity) {
            this.jEO = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.jEH.getActivity()).getUniqueId().getId());
        }
        if (this.jEO != null) {
            if (this.jEO.getResponsedMessage() == null) {
                this.jEO.a(this);
            }
            this.jEN = this.jEO.cJN();
        }
        Z(this.jEH);
    }

    private void Z(FrsFragment frsFragment) {
        this.jEX = new ae();
        this.jEX.fGZ = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.jEX));
        this.jEX.a(this.jFk);
    }

    public void cIZ() {
        Looper.myQueue().removeIdleHandler(this.jFi);
        Looper.myQueue().removeIdleHandler(this.jFj);
        this.jEO.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.jfZ = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.jFa = bundle.getString("yuelaou_locate");
            this.jEQ = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.jEH.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.jfZ)) {
            this.jfZ = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.jFa)) {
            this.jFa = "";
        }
        this.mSource = this.mFrom;
        cJt();
        if (this.jfG == null) {
            this.jfG = new FrsViewData();
        }
        if (this.jEO == null || this.jEN == null || this.jEN.bDl() == null || this.jEN.bDl().isEmpty() || this.jEN.bDl().containsKey(null) || this.jEN.bDl().containsValue(null)) {
            ar(bundle);
        }
        if (this.jfZ != null && this.jfZ.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    private void ar(Bundle bundle) {
        int i;
        this.jEN = new FrsRequestData();
        this.jEN.setSortType(com.baidu.tieba.frs.d.j.At(this.jFb));
        if (this.jFb == 5) {
            this.jEN.setIsGood(1);
        } else {
            this.jEN.setIsGood(0);
        }
        this.jEN.gv("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.jfZ));
        this.jEN.gv("client_type", "2");
        this.jEN.setPn(1);
        if (bundle != null) {
            this.jEN.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
            this.jEN.hG(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
        }
        this.jEN.SU("2");
        this.jEN.setObjSource("-2");
        this.jEN.setKw(this.jfZ);
        this.jEN.setWithGroup(1);
        this.jEN.setCid(0);
        this.jEN.setScrW(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        this.jEN.setScrH(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        this.jEN.setScrDip(com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        this.jEN.setqType(av.bsS().bsT() ? 2 : 1);
        this.jEN.setSchemeUrl(this.mSchemeUrl);
        this.jEN.setLastId(null);
        this.jEN.setYuelaouLocate(this.jFa);
        this.jEN.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ab.bFH(), 0L));
        this.jEN.setStType(this.mFrom);
        this.jEN.Jy(1);
        this.jEN.setNeedCache(true);
        this.jEN.setUpdateType(3);
        this.jEN.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jfG == null ? null : this.jfG.getThreadList(), true));
        com.baidu.tieba.frs.d.j.a(this.jFb, this.jEN);
        this.jEN.setLoadType(1);
        if (cb.eRa.get() && r.dDm().dDg() != null) {
            int ba = r.dDm().dDg().ba(this.jfZ, false);
            int bb = r.dDm().dDg().bb(this.jfZ, false);
            if (this.jEN.getLoadType() == 1) {
                i = ba + 1;
            } else if (this.jEN.getLoadType() == 2) {
                bb++;
                i = ba;
            } else {
                i = ba;
            }
            this.jEN.setRefreshCount(i);
            this.jEN.setLoadCount(bb);
        }
        this.jEO = new FrsNetModel(null, this.jEN);
        this.jEO.setUniqueId(((FrsActivity) this.jEH.getActivity()).getUniqueId());
        this.jEO.a(this);
        this.jEO.loadData();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.jfZ);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void cJt() {
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
            this.jFd = com.baidu.tieba.frs.d.j.Lg("1~" + str + this.jfZ);
            Ac(this.jFb);
        }
    }

    public boolean ctf() {
        if (this.jxC != 1) {
            zW(1);
            return true;
        } else if (this.jEO.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jEN), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 1, false);
            return true;
        }
    }

    public void S(int i, boolean z) {
        if (this.jEN != null) {
            this.jEH.jgn = System.currentTimeMillis();
            if (this.jfG != null && this.jfG.getLikeFeedForumDataList() != null) {
                this.jfG.getLikeFeedForumDataList().clear();
            }
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jEN), FrsRequestData.class);
            frsRequestData.setPn(1);
            this.jxC = c(this.jxC, frsRequestData);
            if (this.jxC == 1) {
                if (!this.jEO.isLoading()) {
                    frsRequestData.setCallFrom(0);
                    b(frsRequestData, i, z ? false : true);
                    return;
                }
                return;
            }
            if (this.jEU == null) {
                this.jEU = new ax();
                this.jEU.pn = 1;
                this.jEU.forumName = this.jfZ;
                if (this.jfG != null && this.jfG.getForum() != null) {
                    this.jEU.forumId = this.jfG.getForum().getId();
                }
            }
            zW(i);
        }
    }

    public void T(int i, boolean z) {
        this.jEH.jgn = System.currentTimeMillis();
        if (this.jfG != null && this.jfG.getLikeFeedForumDataList() != null) {
            this.jfG.getLikeFeedForumDataList().clear();
        }
        this.jxC = c(this.jxC, this.jEN);
        this.jEN.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jfG == null ? null : this.jfG.getThreadList(), true));
        if (this.jxC == 1) {
            a(this.jEN, i, !z);
            return;
        }
        if (this.jEU == null) {
            this.jEU = new ax();
            this.jEU.pn = 1;
            this.jEU.forumName = this.jfZ;
            if (this.jfG != null && this.jfG.getForum() != null) {
                this.jEU.forumId = this.jfG.getForum().getId();
            }
        }
        zW(i);
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.jEH.qw(z);
        this.jEP.yA(i);
        if (this.jEO.cJO() && (this.jEO.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
            a((MvcHttpResponsedMessage) this.jEO.getResponsedMessage(), (MvcHttpMessage) this.jEO.cJP(), this.jEO.cJQ());
        } else if (this.jEO.cJO() && (this.jEO.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
            a((MvcSocketResponsedMessage) this.jEO.getResponsedMessage(), (MvcSocketMessage) this.jEO.cJP(), this.jEO.cJQ());
        } else {
            int At = com.baidu.tieba.frs.d.j.At(this.jFd);
            if (!Aa(this.jFd) && !this.jEH.jga && !this.jFh) {
                String f = com.baidu.tieba.tbadkCore.e.dMs().f("1~" + this.jfZ, At, frsRequestData.getIsGood(), this.jEN.getCategoryId());
                this.jFf = f;
                new a(this, true, f).execute(new Object[0]);
            }
            this.jFh = false;
        }
        this.jEO.a(this);
    }

    public void Ab(int i) {
        if (this.jxC != 1) {
            zW(4);
        } else if (!this.jEO.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jEN), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 4, false);
        }
    }

    private void b(FrsRequestData frsRequestData, int i, boolean z) {
        boolean z2;
        this.mType = i;
        this.jEH.qw(z);
        this.jEP.yA(i);
        this.jEO.a(frsRequestData);
        frsRequestData.SU(this.jEH.cDc() ? "1" : "2");
        if (this.jFe) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.d.j.At(this.jFc)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.jFe = false;
        frsRequestData.setKw(this.jfZ);
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
        frsRequestData.setLastId(this.jDK);
        frsRequestData.setYuelaouLocate(this.jFa);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ab.bFH(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.Jy(cJu());
        if (FrsFragment.jgo != 0) {
            frsRequestData.setCtime((int) FrsFragment.jgo);
        }
        if (FrsFragment.jgp != 0) {
            frsRequestData.setDataSize((int) FrsFragment.jgp);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        if (frsRequestData.getPn() == 1 || this.mType == 3) {
            frsRequestData.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jfG == null ? null : this.jfG.getThreadList(), true));
            z2 = true;
        } else {
            frsRequestData.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jfG != null ? this.jfG.getThreadList() : null, false));
            z2 = false;
        }
        frsRequestData.setNeedCache(z2);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.hG(this.jER);
        com.baidu.tieba.frs.d.j.a(this.jFb, frsRequestData);
        int At = com.baidu.tieba.frs.d.j.At(this.jFd);
        b(i, frsRequestData);
        a(this.jfZ, frsRequestData);
        if (!Aa(this.jFd) && !this.jEH.jga && !this.jFh) {
            String f = com.baidu.tieba.tbadkCore.e.dMs().f("1~" + this.jfZ, At, frsRequestData.getIsGood(), this.jEN.getCategoryId());
            this.jFf = f;
            new a(this, true, f).execute(new Object[0]);
        }
        cJx();
        this.jFh = false;
    }

    private int cJu() {
        return (this.jEH == null || !(this.jEH.mHeadLineDefaultNavTabId == -1 || this.jEH.mHeadLineDefaultNavTabId == this.jxC)) ? 0 : 1;
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
            this.jEH.fJr = mVar.getDataParseTime();
        }
        Ac(com.baidu.tieba.frs.d.j.Au(mVar.getSortType()));
        R(com.baidu.tieba.frs.d.j.Au(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.jxC = mVar.getFrsDefaultTabId();
        }
        this.jfG.receiveData(mVar);
        d(this.jfG);
        this.jEM = new ArrayList<>();
        if (frsRequestData != null) {
            this.jEN = frsRequestData;
            this.mPn = this.jEN.getPn();
            this.jfZ = this.jEN.getKw();
            this.jEH.setForumName(this.jfZ);
            this.jEH.setFrom(this.mFrom);
            this.jEH.setPn(this.mPn);
            this.jEH.setFlag(this.mFlag);
        }
        if (this.jfG.getThreadList() != null) {
            this.jEM.addAll(this.jfG.getThreadList());
        }
        if (this.jxC != 1 && this.isNetFirstLoad) {
            this.jEP.a(7, false, this.jDJ);
        } else {
            this.jEP.a(this.mType, false, this.jDJ);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.jEN)) {
            cJL();
        }
        if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jfG.getForum()));
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() != null && !TextUtils.isEmpty(mVar.getForum().getName()) && frsRequestData != null && r.dDm().dDg() != null) {
            r.dDm().dDg().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        if (StringUtils.isNull(mVar.getUserData().getAppealThreadPopover())) {
            return true;
        }
        this.jEH.aI(TbadkCoreApplication.getCurrentAccount(), mVar.getForum().getId(), mVar.getUserData().getAppealThreadPopover());
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        FrsRequestData requestData;
        if (mvcSocketResponsedMessage != null) {
            this.jFi.g(this);
            this.jFi.a(mvcSocketResponsedMessage);
            this.jFi.a(mvcSocketMessage);
            this.jFi.a(mvcNetMessage);
            this.jFi.a(this.jEP);
            Looper.myQueue().addIdleHandler(this.jFi);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iQj = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.nuf = mvcSocketResponsedMessage.getDownSize();
            this.jDJ = fVar;
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
                this.jEH.a(errorData);
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
            this.jFj.g(this);
            this.jFj.a(mvcHttpResponsedMessage);
            this.jFj.a(mvcHttpMessage);
            this.jFj.a(mvcNetMessage);
            this.jFj.a(this.jEP);
            Looper.myQueue().addIdleHandler(this.jFj);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iQj = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.nuf = mvcHttpResponsedMessage.getDownSize();
            this.jDJ = fVar;
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
                this.jEH.a(errorData);
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

    public void cCT() {
        if (this.jfG != null && this.jfG.getForum() != null && this.jfG.getForum().getBannerListData() != null) {
            String lastIds = this.jfG.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.jDK = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.k.bEg().isSmallFlow()) {
            this.fJv = System.currentTimeMillis() - this.jEH.iIQ;
            this.jEH.fJu = System.currentTimeMillis() - this.jEH.jgm;
            com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(i, z, responsedMessage, this.jEH.fJl, this.jEH.createTime, this.jEH.fJu, false, this.jEH.fJm, this.jEH.fJr, this.fJv);
            this.jEH.createTime = 0L;
            this.jEH.fJl = 0L;
            com.baidu.tieba.frs.d.k.a(this, this.jEH.iIQ);
            this.jEH.iIQ = -1L;
            hVar.bEd();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.k.bEg().isSmallFlow()) {
            this.fJv = System.currentTimeMillis() - this.jEH.jgn;
            this.jEH.fJu = System.currentTimeMillis() - this.jEH.jgm;
            com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(1000, z, responsedMessage, this.jEH.fJl, this.jEH.createTime, this.jEH.fJu, false, this.jEH.fJm, this.jEH.fJr, this.fJv);
            if (this.mType == 4) {
                hVar.fJD = this.fJv;
                hVar.lm(true);
            } else if (this.mType == 3) {
                hVar.fJE = this.fJv;
                hVar.lm(false);
            }
        }
    }

    public FrsRequestData cJv() {
        return this.jEN;
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

    public FrsViewData cJb() {
        return this.jfG;
    }

    public com.baidu.tieba.tbadkCore.f cJw() {
        return this.jDJ;
    }

    private boolean cJx() {
        this.iLB = System.currentTimeMillis();
        return this.jEO.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.jfG.receiveData(mVar);
        d(this.jfG);
        this.jEM = new ArrayList<>();
        if (this.jfG.getThreadList() != null) {
            this.jEM.addAll(this.jfG.getThreadList());
        }
        this.jEP.c(mVar);
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
        private FrsModelController jFn;
        private String mCacheKey;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.mCacheKey = null;
            this.mCacheKey = str;
            this.jFn = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.dMs().SS(this.mCacheKey)) {
                if (!com.baidu.tieba.tbadkCore.e.dMs().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.mCacheKey)) {
                    com.baidu.tieba.tbadkCore.e.dMs().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.dMs().getResponseData();
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
            if (this.jFn != null && mVarArr != null) {
                this.jFn.f(mVarArr.length > 0 ? mVarArr[0] : null);
                this.jFn.R(this.jFn.jFb, true);
            } else if (this.jFn != null && !this.jFn.jEO.cJO()) {
                if (this.jFn.jEO.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                    this.jFn.a((MvcHttpResponsedMessage) this.jFn.jEO.getResponsedMessage(), (MvcHttpMessage) this.jFn.jEO.cJP(), this.jFn.jEO.cJQ());
                }
                if (this.jFn.jEO.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                    this.jFn.a((MvcSocketResponsedMessage) this.jFn.jEO.getResponsedMessage(), (MvcSocketMessage) this.jFn.jEO.cJP(), this.jFn.jEO.cJQ());
                }
            }
        }
    }

    public long cwA() {
        return this.iLE;
    }

    public long cwB() {
        return this.iLC;
    }

    public long cwC() {
        return this.iLD;
    }

    public long cwD() {
        return this.iLB;
    }

    public boolean isLoading() {
        return this.jEO.isLoading();
    }

    public int cJy() {
        return this.jET;
    }

    private void cJz() {
        if (this.jEZ == null) {
            this.jEZ = new ArrayList<>();
        }
        if (this.jEZ.size() == 0) {
            this.jEZ.add(new aa());
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void a(int i, int i2, ax axVar) {
        this.jxC = c(i, null);
        if (axVar == null && (axVar = cz(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.jEY != null) {
                ba baVar = new ba();
                baVar.hasMore = false;
                baVar.pn = 1;
                baVar.forumName = this.jfZ;
                baVar.jlh = false;
                if (this.jfG != null && this.jfG.getForum() != null) {
                    baVar.forumId = this.jfG.getForum().getId();
                }
                cJz();
                this.jfG.setThreadList(this.jEZ);
                this.jEY.a(i, i2, baVar, this.jEZ);
            }
            axVar = new ax();
            axVar.pn = -1;
        }
        if (this.jfG != null && this.jfG.getForum() != null) {
            axVar.forumId = this.jfG.getForum().getId();
        }
        axVar.forumName = this.jfZ;
        if (ac.cEy().yX(1) != null && this.jxC == 1) {
            this.jEN.setCategoryId(i2);
        }
        this.jES = i2;
        this.jEU = axVar;
        b(i, i2, axVar);
        zW(5);
    }

    @Override // com.baidu.tieba.frs.an
    public void a(ar arVar) {
        this.jEY = arVar;
        this.jEX.a(this.jFk);
    }

    private void zW(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.jEU != null) {
                    this.jEU.pn++;
                    break;
                }
                break;
            case 2:
                if (this.jEU != null) {
                    ax axVar = this.jEU;
                    axVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.jEU != null) {
                    this.jEU.pn = -1;
                    break;
                }
                break;
        }
        if (this.jxC == 1) {
            if (this.jET == this.jES) {
                ArrayList<com.baidu.adp.widget.ListView.n> arrayList = new ArrayList<>();
                if (this.jEM != null) {
                    arrayList.addAll(this.jEM);
                }
                this.jfG.setThreadList(arrayList);
                if (this.jEY != null) {
                    this.jEY.a(this.jxC, this.jES, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.jET = this.jES;
            return;
        }
        an yY = this.jEX.yY(this.jxC);
        if (yY != null) {
            this.jEV = true;
            yY.a(this.jxC, this.jES, this.jEU);
            return;
        }
        if (this.jfG != null && this.jfG.getThreadList() != null) {
            this.jfG.getThreadList().clear();
        }
        this.jEY.a(this.jxC, this.jES, null, null);
    }

    public boolean hasMore() {
        if ((this.jEU instanceof ba) && ((ba) this.jEU).errCode == 0) {
            return ((ba) this.jEU).hasMore;
        }
        return true;
    }

    private int cy(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ax axVar) {
        this.jEW.put(cy(i, i2), axVar);
    }

    public ax cz(int i, int i2) {
        return this.jEW.get(cy(i, i2));
    }

    @Override // com.baidu.tieba.frs.an
    public void init() {
        this.jEX.init();
    }

    @Override // com.baidu.tieba.frs.an
    public void bYN() {
        this.jEX.destory();
        this.jEX.clear();
    }

    public int cJA() {
        return this.jxC;
    }

    public boolean cJB() {
        return 1 == this.jxC;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(aw awVar) {
        if (awVar != null && !StringUtils.isNull(awVar.getId()) && !y.isEmpty(this.jEM)) {
            if (this.jxC == 1) {
                this.jfG.addMyNewThread(awVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<com.baidu.adp.widget.ListView.n> it = this.jEM.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.n next = it.next();
                if ((next instanceof ca) && awVar.getId().equals(((ca) next).eJQ.getId())) {
                    return;
                }
            }
            this.jEM.add(topThreadSize, awVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.jEM == null || this.jEM.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.n> it = this.jEM.iterator();
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

    public boolean cJC() {
        return this.jEV;
    }

    public void cJD() {
        com.baidu.tieba.frs.s sVar = new com.baidu.tieba.frs.s();
        if (this.jET == 0) {
            sVar.yP(this.jFb);
        }
        if (this.jfG.getThreadList() != null) {
            this.jfG.getThreadList().clear();
            this.jfG.getThreadList().add(sVar);
        }
        if (this.jEM != null) {
            this.jEM.clear();
            this.jEM.add(sVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cJE() {
        return this.jEM;
    }

    public void Ac(int i) {
        AccountData currentAccountObj;
        this.jFb = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.d.j.ba("1~" + str + this.jfZ, this.jFb);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dOL();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dOM();
        }
    }

    public void Ad(int i) {
        this.jFc = i;
    }

    public void rt(boolean z) {
        this.jFe = z;
    }

    public int cJF() {
        return this.jFb;
    }

    public int cJG() {
        return this.jFd;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.d.j.At(this.jFb);
    }

    public boolean cJH() {
        return this.jEQ;
    }

    public boolean cJI() {
        return this.jFb == 5;
    }

    public boolean cJJ() {
        return this.jEN != null && this.jEN.getLoadType() == 1;
    }

    public boolean cJK() {
        return this.jFb == 7 || (!this.jEO.cJO() && this.jFd == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.jEH.cCl() != null) {
            return this.jEH.cCl().a(this.jFb, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (cb.eRa.get() && r.dDm().dDg() != null) {
            int ba = r.dDm().dDg().ba(str, false);
            int bb = r.dDm().dDg().bb(str, false);
            if (frsRequestData.getLoadType() == 1) {
                ba++;
            } else if (frsRequestData.getLoadType() == 2) {
                bb++;
            }
            frsRequestData.setRefreshCount(ba);
            frsRequestData.setLoadCount(bb);
        }
    }

    public void cJL() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.jfG != null && this.jfG.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.jfG.getForum().getId(), 0L));
        }
        this.jEH.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void KZ(final String str) {
        af.a(new com.baidu.tbadk.util.ae<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ae
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dMs().gs(FrsModelController.this.jFf, str);
                return null;
            }
        }, null);
    }

    public void La(final String str) {
        af.a(new com.baidu.tbadk.util.ae<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ae
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dMs().gt(FrsModelController.this.jFf, str);
                return null;
            }
        }, null);
    }

    public void Lb(final String str) {
        af.a(new com.baidu.tbadk.util.ae<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ae
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dMs().gu(FrsModelController.this.jFf, str);
                return null;
            }
        }, null);
    }

    public void ru(boolean z) {
        this.jFh = z;
    }
}
