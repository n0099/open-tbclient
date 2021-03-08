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
    private boolean eYn;
    private long fKV;
    private long iNA;
    private long iNB;
    private long iNy;
    private long iNz;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private com.baidu.tieba.tbadkCore.f jFG;
    private String jFH;
    private final FrsFragment jGE;
    private ArrayList<com.baidu.adp.widget.ListView.n> jGJ;
    private FrsRequestData jGK;
    private FrsNetModel jGL;
    private final s jGM;
    private boolean jGN;
    private long jGO;
    private int jGP;
    private int jGQ;
    private ax jGR;
    private boolean jGS;
    private SparseArray<ax> jGT;
    private ae jGU;
    private ar jGV;
    private ArrayList<com.baidu.adp.widget.ListView.n> jGW;
    private String jGX;
    private int jGY;
    private int jGZ;
    private int jHa;
    private boolean jHb;
    private String jHc;
    private final SparseArray<Boolean> jHd;
    private boolean jHe;
    private n jHf;
    private m jHg;
    private ar jHh;
    private FrsViewData jhD;
    private String jhW;
    private int jzz;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSchemeUrl;
    private String mSource;
    private int mType;

    public boolean Ab(int i) {
        return this.jHd.get(i, false).booleanValue();
    }

    public void R(int i, boolean z) {
        this.jHd.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, s sVar) {
        super(frsFragment.getPageContext());
        this.jhW = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSchemeUrl = "";
        this.mSource = null;
        this.jFH = null;
        this.jGO = 0L;
        this.jzz = 1;
        this.jGP = 0;
        this.jGQ = 0;
        this.jGS = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.jGT = new SparseArray<>();
        this.fKV = 0L;
        this.eYn = false;
        this.jGY = -1;
        this.jGZ = -1;
        this.jHa = -1;
        this.jHc = null;
        this.jHd = new SparseArray<>();
        this.jHf = new n();
        this.jHg = new m();
        this.jHh = new ar() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ar
            public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
                FrsModelController.this.jGS = false;
                if (i == FrsModelController.this.jzz && FrsModelController.this.jGV != null) {
                    FrsModelController.this.jGR = baVar;
                    FrsModelController.this.b(i, i2, baVar);
                    ArrayList<com.baidu.adp.widget.ListView.n> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.jhD.setThreadList(arrayList2);
                    FrsModelController.this.jGV.a(i, i2, baVar, arrayList);
                }
            }
        };
        this.iNy = 0L;
        this.iNz = 0L;
        this.iNA = 0L;
        this.iNB = 0L;
        if (sVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.jGE = frsFragment;
        this.jGM = sVar;
        if (this.jGE.getActivity() instanceof FrsActivity) {
            this.jGL = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.jGE.getActivity()).getUniqueId().getId());
        }
        if (this.jGL != null) {
            if (this.jGL.getResponsedMessage() == null) {
                this.jGL.a(this);
            }
            this.jGK = this.jGL.cKa();
        }
        Z(this.jGE);
    }

    private void Z(FrsFragment frsFragment) {
        this.jGU = new ae();
        this.jGU.fIy = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.jGU));
        this.jGU.a(this.jHh);
    }

    public void cJm() {
        Looper.myQueue().removeIdleHandler(this.jHf);
        Looper.myQueue().removeIdleHandler(this.jHg);
        this.jGL.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.jhW = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.jGX = bundle.getString("yuelaou_locate");
            this.jGN = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.jGE.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.jhW)) {
            this.jhW = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.jGX)) {
            this.jGX = "";
        }
        this.mSource = this.mFrom;
        cJG();
        if (this.jhD == null) {
            this.jhD = new FrsViewData();
        }
        if (this.jGL == null || this.jGK == null || this.jGK.bDo() == null || this.jGK.bDo().isEmpty() || this.jGK.bDo().containsKey(null) || this.jGK.bDo().containsValue(null)) {
            ar(bundle);
        }
        if (this.jhW != null && this.jhW.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    private void ar(Bundle bundle) {
        int i;
        this.jGK = new FrsRequestData();
        this.jGK.setSortType(com.baidu.tieba.frs.d.j.Au(this.jGY));
        if (this.jGY == 5) {
            this.jGK.setIsGood(1);
        } else {
            this.jGK.setIsGood(0);
        }
        this.jGK.gx("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.jhW));
        this.jGK.gx("client_type", "2");
        this.jGK.setPn(1);
        if (bundle != null) {
            this.jGK.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
            this.jGK.hG(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
        }
        this.jGK.Tm("2");
        this.jGK.setObjSource("-2");
        this.jGK.setKw(this.jhW);
        this.jGK.setWithGroup(1);
        this.jGK.setCid(0);
        this.jGK.setScrW(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        this.jGK.setScrH(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        this.jGK.setScrDip(com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        this.jGK.setqType(av.bsV().bsW() ? 2 : 1);
        this.jGK.setSchemeUrl(this.mSchemeUrl);
        this.jGK.setLastId(null);
        this.jGK.setYuelaouLocate(this.jGX);
        this.jGK.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ab.bFL(), 0L));
        this.jGK.setStType(this.mFrom);
        this.jGK.JC(1);
        this.jGK.setNeedCache(true);
        this.jGK.setUpdateType(3);
        this.jGK.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jhD == null ? null : this.jhD.getThreadList(), true));
        com.baidu.tieba.frs.d.j.a(this.jGY, this.jGK);
        this.jGK.setLoadType(1);
        if (cb.eSB.get() && com.baidu.tieba.recapp.s.dDB().dDv() != null) {
            int ba = com.baidu.tieba.recapp.s.dDB().dDv().ba(this.jhW, false);
            int bb = com.baidu.tieba.recapp.s.dDB().dDv().bb(this.jhW, false);
            if (this.jGK.getLoadType() == 1) {
                i = ba + 1;
            } else if (this.jGK.getLoadType() == 2) {
                bb++;
                i = ba;
            } else {
                i = ba;
            }
            this.jGK.setRefreshCount(i);
            this.jGK.setLoadCount(bb);
        }
        this.jGL = new FrsNetModel(null, this.jGK);
        this.jGL.setUniqueId(((FrsActivity) this.jGE.getActivity()).getUniqueId());
        this.jGL.a(this);
        this.jGL.loadData();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.jhW);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void cJG() {
        AccountData currentAccountObj;
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            Ad(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            Ad(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            this.jHa = com.baidu.tieba.frs.d.j.Lq("1~" + str + this.jhW);
            Ad(this.jGY);
        }
    }

    public boolean cts() {
        if (this.jzz != 1) {
            zX(1);
            return true;
        } else if (this.jGL.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jGK), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 1, false);
            return true;
        }
    }

    public void S(int i, boolean z) {
        if (this.jGK != null) {
            this.jGE.jil = System.currentTimeMillis();
            if (this.jhD != null && this.jhD.getLikeFeedForumDataList() != null) {
                this.jhD.getLikeFeedForumDataList().clear();
            }
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jGK), FrsRequestData.class);
            frsRequestData.setPn(1);
            this.jzz = c(this.jzz, frsRequestData);
            if (this.jzz == 1) {
                if (!this.jGL.isLoading()) {
                    frsRequestData.setCallFrom(0);
                    b(frsRequestData, i, z ? false : true);
                    return;
                }
                return;
            }
            if (this.jGR == null) {
                this.jGR = new ax();
                this.jGR.pn = 1;
                this.jGR.forumName = this.jhW;
                if (this.jhD != null && this.jhD.getForum() != null) {
                    this.jGR.forumId = this.jhD.getForum().getId();
                }
            }
            zX(i);
        }
    }

    public void T(int i, boolean z) {
        this.jGE.jil = System.currentTimeMillis();
        if (this.jhD != null && this.jhD.getLikeFeedForumDataList() != null) {
            this.jhD.getLikeFeedForumDataList().clear();
        }
        this.jzz = c(this.jzz, this.jGK);
        this.jGK.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jhD == null ? null : this.jhD.getThreadList(), true));
        if (this.jzz == 1) {
            a(this.jGK, i, !z);
            return;
        }
        if (this.jGR == null) {
            this.jGR = new ax();
            this.jGR.pn = 1;
            this.jGR.forumName = this.jhW;
            if (this.jhD != null && this.jhD.getForum() != null) {
                this.jGR.forumId = this.jhD.getForum().getId();
            }
        }
        zX(i);
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.jGE.qw(z);
        this.jGM.yB(i);
        if (this.jGL.cKb() && (this.jGL.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
            a((MvcHttpResponsedMessage) this.jGL.getResponsedMessage(), (MvcHttpMessage) this.jGL.cKc(), this.jGL.cKd());
        } else if (this.jGL.cKb() && (this.jGL.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
            a((MvcSocketResponsedMessage) this.jGL.getResponsedMessage(), (MvcSocketMessage) this.jGL.cKc(), this.jGL.cKd());
        } else {
            int Au = com.baidu.tieba.frs.d.j.Au(this.jHa);
            if (!Ab(this.jHa) && !this.jGE.jhX && !this.jHe) {
                String f = com.baidu.tieba.tbadkCore.e.dMI().f("1~" + this.jhW, Au, frsRequestData.getIsGood(), this.jGK.getCategoryId());
                this.jHc = f;
                new a(this, true, f).execute(new Object[0]);
            }
            this.jHe = false;
        }
        this.jGL.a(this);
    }

    public void Ac(int i) {
        if (this.jzz != 1) {
            zX(4);
        } else if (!this.jGL.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jGK), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 4, false);
        }
    }

    private void b(FrsRequestData frsRequestData, int i, boolean z) {
        boolean z2;
        this.mType = i;
        this.jGE.qw(z);
        this.jGM.yB(i);
        this.jGL.a(frsRequestData);
        frsRequestData.Tm(this.jGE.cDp() ? "1" : "2");
        if (this.jHb) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.d.j.Au(this.jGZ)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.jHb = false;
        frsRequestData.setKw(this.jhW);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = av.bsV().bsW() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setSchemeUrl(this.mSchemeUrl);
        frsRequestData.setLastId(this.jFH);
        frsRequestData.setYuelaouLocate(this.jGX);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ab.bFL(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.JC(cJH());
        if (FrsFragment.jim != 0) {
            frsRequestData.setCtime((int) FrsFragment.jim);
        }
        if (FrsFragment.jin != 0) {
            frsRequestData.setDataSize((int) FrsFragment.jin);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        if (frsRequestData.getPn() == 1 || this.mType == 3) {
            frsRequestData.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jhD == null ? null : this.jhD.getThreadList(), true));
            z2 = true;
        } else {
            frsRequestData.setAdFloorInfo(com.baidu.tieba.recapp.a.y(this.jhD != null ? this.jhD.getThreadList() : null, false));
            z2 = false;
        }
        frsRequestData.setNeedCache(z2);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.hG(this.jGO);
        com.baidu.tieba.frs.d.j.a(this.jGY, frsRequestData);
        int Au = com.baidu.tieba.frs.d.j.Au(this.jHa);
        b(i, frsRequestData);
        a(this.jhW, frsRequestData);
        if (!Ab(this.jHa) && !this.jGE.jhX && !this.jHe) {
            String f = com.baidu.tieba.tbadkCore.e.dMI().f("1~" + this.jhW, Au, frsRequestData.getIsGood(), this.jGK.getCategoryId());
            this.jHc = f;
            new a(this, true, f).execute(new Object[0]);
        }
        cJK();
        this.jHe = false;
    }

    private int cJH() {
        return (this.jGE == null || !(this.jGE.mHeadLineDefaultNavTabId == -1 || this.jGE.mHeadLineDefaultNavTabId == this.jzz)) ? 0 : 1;
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
            this.jGE.fKR = mVar.getDataParseTime();
        }
        Ad(com.baidu.tieba.frs.d.j.Av(mVar.getSortType()));
        R(com.baidu.tieba.frs.d.j.Av(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.jzz = mVar.getFrsDefaultTabId();
        }
        this.jhD.receiveData(mVar);
        d(this.jhD);
        this.jGJ = new ArrayList<>();
        if (frsRequestData != null) {
            this.jGK = frsRequestData;
            this.mPn = this.jGK.getPn();
            this.jhW = this.jGK.getKw();
            this.jGE.setForumName(this.jhW);
            this.jGE.setFrom(this.mFrom);
            this.jGE.setPn(this.mPn);
            this.jGE.setFlag(this.mFlag);
        }
        if (this.jhD.getThreadList() != null) {
            this.jGJ.addAll(this.jhD.getThreadList());
        }
        if (this.jzz != 1 && this.isNetFirstLoad) {
            this.jGM.a(7, false, this.jFG);
        } else {
            this.jGM.a(this.mType, false, this.jFG);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.jGK)) {
            cJY();
        }
        if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jhD.getForum()));
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() != null && !TextUtils.isEmpty(mVar.getForum().getName()) && frsRequestData != null && com.baidu.tieba.recapp.s.dDB().dDv() != null) {
            com.baidu.tieba.recapp.s.dDB().dDv().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        if (StringUtils.isNull(mVar.getUserData().getAppealThreadPopover())) {
            return true;
        }
        this.jGE.aI(TbadkCoreApplication.getCurrentAccount(), mVar.getForum().getId(), mVar.getUserData().getAppealThreadPopover());
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        FrsRequestData requestData;
        if (mvcSocketResponsedMessage != null) {
            this.jHf.g(this);
            this.jHf.a(mvcSocketResponsedMessage);
            this.jHf.a(mvcSocketMessage);
            this.jHf.a(mvcNetMessage);
            this.jHf.a(this.jGM);
            Looper.myQueue().addIdleHandler(this.jHf);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iSg = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.nwK = mvcSocketResponsedMessage.getDownSize();
            this.jFG = fVar;
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
                this.jGE.a(errorData);
            }
        }
    }

    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.eYn) {
            this.eYn = true;
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
            this.jHg.g(this);
            this.jHg.a(mvcHttpResponsedMessage);
            this.jHg.a(mvcHttpMessage);
            this.jHg.a(mvcNetMessage);
            this.jHg.a(this.jGM);
            Looper.myQueue().addIdleHandler(this.jHg);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iSg = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.nwK = mvcHttpResponsedMessage.getDownSize();
            this.jFG = fVar;
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
                this.jGE.a(errorData);
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
        if (!this.eYn) {
            this.eYn = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void cDg() {
        if (this.jhD != null && this.jhD.getForum() != null && this.jhD.getForum().getBannerListData() != null) {
            String lastIds = this.jhD.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.jFH = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.k.bEk().isSmallFlow()) {
            this.fKV = System.currentTimeMillis() - this.jGE.iKN;
            this.jGE.fKU = System.currentTimeMillis() - this.jGE.jik;
            com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(i, z, responsedMessage, this.jGE.fKL, this.jGE.createTime, this.jGE.fKU, false, this.jGE.fKM, this.jGE.fKR, this.fKV);
            this.jGE.createTime = 0L;
            this.jGE.fKL = 0L;
            com.baidu.tieba.frs.d.k.a(this, this.jGE.iKN);
            this.jGE.iKN = -1L;
            hVar.bEh();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.k.bEk().isSmallFlow()) {
            this.fKV = System.currentTimeMillis() - this.jGE.jil;
            this.jGE.fKU = System.currentTimeMillis() - this.jGE.jik;
            com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(1000, z, responsedMessage, this.jGE.fKL, this.jGE.createTime, this.jGE.fKU, false, this.jGE.fKM, this.jGE.fKR, this.fKV);
            if (this.mType == 4) {
                hVar.fLd = this.fKV;
                hVar.lm(true);
            } else if (this.mType == 3) {
                hVar.fLe = this.fKV;
                hVar.lm(false);
            }
        }
    }

    public FrsRequestData cJI() {
        return this.jGK;
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

    public FrsViewData cJo() {
        return this.jhD;
    }

    public com.baidu.tieba.tbadkCore.f cJJ() {
        return this.jFG;
    }

    private boolean cJK() {
        this.iNy = System.currentTimeMillis();
        return this.jGL.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.jhD.receiveData(mVar);
        d(this.jhD);
        this.jGJ = new ArrayList<>();
        if (this.jhD.getThreadList() != null) {
            this.jGJ.addAll(this.jhD.getThreadList());
        }
        this.jGM.c(mVar);
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
        private FrsModelController jHk;
        private String mCacheKey;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.mCacheKey = null;
            this.mCacheKey = str;
            this.jHk = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.dMI().Tk(this.mCacheKey)) {
                if (!com.baidu.tieba.tbadkCore.e.dMI().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.mCacheKey)) {
                    com.baidu.tieba.tbadkCore.e.dMI().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.dMI().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().blV(), true) && !responseData.getBookInfo().blV().equals("0") && responseData.getBookInfo().blW() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().blV(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.jHk != null && mVarArr != null) {
                this.jHk.f(mVarArr.length > 0 ? mVarArr[0] : null);
                this.jHk.R(this.jHk.jGY, true);
            } else if (this.jHk != null && !this.jHk.jGL.cKb()) {
                if (this.jHk.jGL.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                    this.jHk.a((MvcHttpResponsedMessage) this.jHk.jGL.getResponsedMessage(), (MvcHttpMessage) this.jHk.jGL.cKc(), this.jHk.jGL.cKd());
                }
                if (this.jHk.jGL.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                    this.jHk.a((MvcSocketResponsedMessage) this.jHk.jGL.getResponsedMessage(), (MvcSocketMessage) this.jHk.jGL.cKc(), this.jHk.jGL.cKd());
                }
            }
        }
    }

    public long cwN() {
        return this.iNB;
    }

    public long cwO() {
        return this.iNz;
    }

    public long cwP() {
        return this.iNA;
    }

    public long cwQ() {
        return this.iNy;
    }

    public boolean isLoading() {
        return this.jGL.isLoading();
    }

    public int cJL() {
        return this.jGQ;
    }

    private void cJM() {
        if (this.jGW == null) {
            this.jGW = new ArrayList<>();
        }
        if (this.jGW.size() == 0) {
            this.jGW.add(new aa());
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void a(int i, int i2, ax axVar) {
        this.jzz = c(i, null);
        if (axVar == null && (axVar = cA(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.jGV != null) {
                ba baVar = new ba();
                baVar.hasMore = false;
                baVar.pn = 1;
                baVar.forumName = this.jhW;
                baVar.jnf = false;
                if (this.jhD != null && this.jhD.getForum() != null) {
                    baVar.forumId = this.jhD.getForum().getId();
                }
                cJM();
                this.jhD.setThreadList(this.jGW);
                this.jGV.a(i, i2, baVar, this.jGW);
            }
            axVar = new ax();
            axVar.pn = -1;
        }
        if (this.jhD != null && this.jhD.getForum() != null) {
            axVar.forumId = this.jhD.getForum().getId();
        }
        axVar.forumName = this.jhW;
        if (ac.cEL().yY(1) != null && this.jzz == 1) {
            this.jGK.setCategoryId(i2);
        }
        this.jGP = i2;
        this.jGR = axVar;
        b(i, i2, axVar);
        zX(5);
    }

    @Override // com.baidu.tieba.frs.an
    public void a(ar arVar) {
        this.jGV = arVar;
        this.jGU.a(this.jHh);
    }

    private void zX(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.jGR != null) {
                    this.jGR.pn++;
                    break;
                }
                break;
            case 2:
                if (this.jGR != null) {
                    ax axVar = this.jGR;
                    axVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.jGR != null) {
                    this.jGR.pn = -1;
                    break;
                }
                break;
        }
        if (this.jzz == 1) {
            if (this.jGQ == this.jGP) {
                ArrayList<com.baidu.adp.widget.ListView.n> arrayList = new ArrayList<>();
                if (this.jGJ != null) {
                    arrayList.addAll(this.jGJ);
                }
                this.jhD.setThreadList(arrayList);
                if (this.jGV != null) {
                    this.jGV.a(this.jzz, this.jGP, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.jGQ = this.jGP;
            return;
        }
        an yZ = this.jGU.yZ(this.jzz);
        if (yZ != null) {
            this.jGS = true;
            yZ.a(this.jzz, this.jGP, this.jGR);
            return;
        }
        if (this.jhD != null && this.jhD.getThreadList() != null) {
            this.jhD.getThreadList().clear();
        }
        this.jGV.a(this.jzz, this.jGP, null, null);
    }

    public boolean hasMore() {
        if ((this.jGR instanceof ba) && ((ba) this.jGR).errCode == 0) {
            return ((ba) this.jGR).hasMore;
        }
        return true;
    }

    private int cz(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ax axVar) {
        this.jGT.put(cz(i, i2), axVar);
    }

    public ax cA(int i, int i2) {
        return this.jGT.get(cz(i, i2));
    }

    @Override // com.baidu.tieba.frs.an
    public void init() {
        this.jGU.init();
    }

    @Override // com.baidu.tieba.frs.an
    public void bZa() {
        this.jGU.destory();
        this.jGU.clear();
    }

    public int cJN() {
        return this.jzz;
    }

    public boolean cJO() {
        return 1 == this.jzz;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(aw awVar) {
        if (awVar != null && !StringUtils.isNull(awVar.getId()) && !y.isEmpty(this.jGJ)) {
            if (this.jzz == 1) {
                this.jhD.addMyNewThread(awVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<com.baidu.adp.widget.ListView.n> it = this.jGJ.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.n next = it.next();
                if ((next instanceof ca) && awVar.getId().equals(((ca) next).eLr.getId())) {
                    return;
                }
            }
            this.jGJ.add(topThreadSize, awVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.jGJ == null || this.jGJ.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.n> it = this.jGJ.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.n next = it.next();
                if (!(next instanceof ca)) {
                    i = i2;
                } else if (((ca) next).eLr.bnN() != 0) {
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

    public boolean cJP() {
        return this.jGS;
    }

    public void cJQ() {
        com.baidu.tieba.frs.s sVar = new com.baidu.tieba.frs.s();
        if (this.jGQ == 0) {
            sVar.yQ(this.jGY);
        }
        if (this.jhD.getThreadList() != null) {
            this.jhD.getThreadList().clear();
            this.jhD.getThreadList().add(sVar);
        }
        if (this.jGJ != null) {
            this.jGJ.clear();
            this.jGJ.add(sVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cJR() {
        return this.jGJ;
    }

    public void Ad(int i) {
        AccountData currentAccountObj;
        this.jGY = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.d.j.bb("1~" + str + this.jhW, this.jGY);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dPc();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dPd();
        }
    }

    public void Ae(int i) {
        this.jGZ = i;
    }

    public void rt(boolean z) {
        this.jHb = z;
    }

    public int cJS() {
        return this.jGY;
    }

    public int cJT() {
        return this.jHa;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.d.j.Au(this.jGY);
    }

    public boolean cJU() {
        return this.jGN;
    }

    public boolean cJV() {
        return this.jGY == 5;
    }

    public boolean cJW() {
        return this.jGK != null && this.jGK.getLoadType() == 1;
    }

    public boolean cJX() {
        return this.jGY == 7 || (!this.jGL.cKb() && this.jHa == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.jGE.cCy() != null) {
            return this.jGE.cCy().a(this.jGY, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (cb.eSB.get() && com.baidu.tieba.recapp.s.dDB().dDv() != null) {
            int ba = com.baidu.tieba.recapp.s.dDB().dDv().ba(str, false);
            int bb = com.baidu.tieba.recapp.s.dDB().dDv().bb(str, false);
            if (frsRequestData.getLoadType() == 1) {
                ba++;
            } else if (frsRequestData.getLoadType() == 2) {
                bb++;
            }
            frsRequestData.setRefreshCount(ba);
            frsRequestData.setLoadCount(bb);
        }
    }

    public void cJY() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.jhD != null && this.jhD.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.jhD.getForum().getId(), 0L));
        }
        this.jGE.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void Lj(final String str) {
        af.a(new com.baidu.tbadk.util.ae<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ae
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dMI().gu(FrsModelController.this.jHc, str);
                return null;
            }
        }, null);
    }

    public void Lk(final String str) {
        af.a(new com.baidu.tbadk.util.ae<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ae
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dMI().gv(FrsModelController.this.jHc, str);
                return null;
            }
        }, null);
    }

    public void Ll(final String str) {
        af.a(new com.baidu.tbadk.util.ae<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ae
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dMI().gw(FrsModelController.this.jHc, str);
                return null;
            }
        }, null);
    }

    public void ru(boolean z) {
        this.jHe = z;
    }
}
