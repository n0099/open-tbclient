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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.z;
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
    private boolean eZj;
    private long fLR;
    private long iKA;
    private long iKB;
    private long iKC;
    private long iKz;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private com.baidu.tieba.tbadkCore.f jCK;
    private String jCL;
    private final FrsFragment jDI;
    private ArrayList<com.baidu.adp.widget.ListView.n> jDN;
    private FrsRequestData jDO;
    private FrsNetModel jDP;
    private final s jDQ;
    private boolean jDR;
    private long jDS;
    private int jDT;
    private int jDU;
    private ax jDV;
    private boolean jDW;
    private SparseArray<ax> jDX;
    private ae jDY;
    private ar jDZ;
    private ArrayList<com.baidu.adp.widget.ListView.n> jEa;
    private String jEb;
    private int jEc;
    private int jEd;
    private int jEe;
    private boolean jEf;
    private String jEg;
    private final SparseArray<Boolean> jEh;
    private boolean jEi;
    private n jEj;
    private m jEk;
    private ar jEl;
    private FrsViewData jeH;
    private String jfa;
    private int jwC;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSchemeUrl;
    private String mSource;
    private int mType;

    public boolean Bx(int i) {
        return this.jEh.get(i, false).booleanValue();
    }

    public void R(int i, boolean z) {
        this.jEh.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, s sVar) {
        super(frsFragment.getPageContext());
        this.jfa = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSchemeUrl = "";
        this.mSource = null;
        this.jCL = null;
        this.jDS = 0L;
        this.jwC = 1;
        this.jDT = 0;
        this.jDU = 0;
        this.jDW = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.jDX = new SparseArray<>();
        this.fLR = 0L;
        this.eZj = false;
        this.jEc = -1;
        this.jEd = -1;
        this.jEe = -1;
        this.jEg = null;
        this.jEh = new SparseArray<>();
        this.jEj = new n();
        this.jEk = new m();
        this.jEl = new ar() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ar
            public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
                FrsModelController.this.jDW = false;
                if (i == FrsModelController.this.jwC && FrsModelController.this.jDZ != null) {
                    FrsModelController.this.jDV = baVar;
                    FrsModelController.this.b(i, i2, baVar);
                    ArrayList<com.baidu.adp.widget.ListView.n> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.jeH.setThreadList(arrayList2);
                    FrsModelController.this.jDZ.a(i, i2, baVar, arrayList);
                }
            }
        };
        this.iKz = 0L;
        this.iKA = 0L;
        this.iKB = 0L;
        this.iKC = 0L;
        if (sVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.jDI = frsFragment;
        this.jDQ = sVar;
        if (this.jDI.getActivity() instanceof FrsActivity) {
            this.jDP = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.jDI.getActivity()).getUniqueId().getId());
        }
        if (this.jDP != null) {
            if (this.jDP.getResponsedMessage() == null) {
                this.jDP.a(this);
            }
            this.jDO = this.jDP.cMr();
        }
        Z(this.jDI);
    }

    private void Z(FrsFragment frsFragment) {
        this.jDY = new ae();
        this.jDY.fJu = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.jDY));
        this.jDY.a(this.jEl);
    }

    public void cLD() {
        Looper.myQueue().removeIdleHandler(this.jEj);
        Looper.myQueue().removeIdleHandler(this.jEk);
        this.jDP.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.jfa = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.jEb = bundle.getString("yuelaou_locate");
            this.jDR = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.jDI.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.jfa)) {
            this.jfa = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.jEb)) {
            this.jEb = "";
        }
        this.mSource = this.mFrom;
        cLX();
        if (this.jeH == null) {
            this.jeH = new FrsViewData();
        }
        if (this.jDP == null || this.jDO == null || this.jDO.bGL() == null || this.jDO.bGL().isEmpty() || this.jDO.bGL().containsKey(null) || this.jDO.bGL().containsValue(null)) {
            ar(bundle);
        }
        if (this.jfa != null && this.jfa.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    private void ar(Bundle bundle) {
        int i;
        this.jDO = new FrsRequestData();
        this.jDO.setSortType(com.baidu.tieba.frs.d.j.BP(this.jEc));
        if (this.jEc == 5) {
            this.jDO.setIsGood(1);
        } else {
            this.jDO.setIsGood(0);
        }
        this.jDO.gq("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.jfa));
        this.jDO.gq("client_type", "2");
        this.jDO.setPn(1);
        if (bundle != null) {
            this.jDO.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
            this.jDO.hB(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
        }
        this.jDO.Tf("2");
        this.jDO.setObjSource("-2");
        this.jDO.setKw(this.jfa);
        this.jDO.setWithGroup(1);
        this.jDO.setCid(0);
        this.jDO.setScrW(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        this.jDO.setScrH(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        this.jDO.setScrDip(com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        this.jDO.setqType(au.bwr().bws() ? 2 : 1);
        this.jDO.setSchemeUrl(this.mSchemeUrl);
        this.jDO.setLastId(null);
        this.jDO.setYuelaouLocate(this.jEb);
        this.jDO.setLastClickTid(com.baidu.adp.lib.f.b.toLong(z.bJf(), 0L));
        this.jDO.setStType(this.mFrom);
        this.jDO.KL(1);
        this.jDO.setNeedCache(true);
        this.jDO.setUpdateType(3);
        com.baidu.tieba.frs.d.j.a(this.jEc, this.jDO);
        this.jDO.setLoadType(1);
        if (bz.eTz.get() && r.dEV().dEP() != null) {
            int ba = r.dEV().dEP().ba(this.jfa, false);
            int bb = r.dEV().dEP().bb(this.jfa, false);
            if (this.jDO.getLoadType() == 1) {
                i = ba + 1;
            } else if (this.jDO.getLoadType() == 2) {
                bb++;
                i = ba;
            } else {
                i = ba;
            }
            this.jDO.setRefreshCount(i);
            this.jDO.setLoadCount(bb);
        }
        this.jDP = new FrsNetModel(null, this.jDO);
        this.jDP.setUniqueId(((FrsActivity) this.jDI.getActivity()).getUniqueId());
        this.jDP.a(this);
        this.jDP.loadData();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.jfa);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void cLX() {
        AccountData currentAccountObj;
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            By(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            By(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            this.jEe = com.baidu.tieba.frs.d.j.LG("1~" + str + this.jfa);
            By(this.jEc);
        }
    }

    public boolean cvK() {
        if (this.jwC != 1) {
            Bs(1);
            return true;
        } else if (this.jDP.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jDO), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 1, false);
            return true;
        }
    }

    public void S(int i, boolean z) {
        if (this.jDO != null) {
            this.jDI.jfo = System.currentTimeMillis();
            if (this.jeH != null && this.jeH.getLikeFeedForumDataList() != null) {
                this.jeH.getLikeFeedForumDataList().clear();
            }
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jDO), FrsRequestData.class);
            frsRequestData.setPn(1);
            this.jwC = c(this.jwC, frsRequestData);
            if (this.jwC == 1) {
                if (!this.jDP.isLoading()) {
                    frsRequestData.setCallFrom(0);
                    b(frsRequestData, i, z ? false : true);
                    return;
                }
                return;
            }
            if (this.jDV == null) {
                this.jDV = new ax();
                this.jDV.pn = 1;
                this.jDV.forumName = this.jfa;
                if (this.jeH != null && this.jeH.getForum() != null) {
                    this.jDV.forumId = this.jeH.getForum().getId();
                }
            }
            Bs(i);
        }
    }

    public void T(int i, boolean z) {
        this.jDI.jfo = System.currentTimeMillis();
        if (this.jeH != null && this.jeH.getLikeFeedForumDataList() != null) {
            this.jeH.getLikeFeedForumDataList().clear();
        }
        this.jwC = c(this.jwC, this.jDO);
        if (this.jwC == 1) {
            a(this.jDO, i, z ? false : true);
            return;
        }
        if (this.jDV == null) {
            this.jDV = new ax();
            this.jDV.pn = 1;
            this.jDV.forumName = this.jfa;
            if (this.jeH != null && this.jeH.getForum() != null) {
                this.jDV.forumId = this.jeH.getForum().getId();
            }
        }
        Bs(i);
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.jDI.qq(z);
        this.jDQ.zW(i);
        if (this.jDP.cMs() && (this.jDP.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
            a((MvcHttpResponsedMessage) this.jDP.getResponsedMessage(), (MvcHttpMessage) this.jDP.cMt(), this.jDP.cMu());
        } else if (this.jDP.cMs() && (this.jDP.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
            a((MvcSocketResponsedMessage) this.jDP.getResponsedMessage(), (MvcSocketMessage) this.jDP.cMt(), this.jDP.cMu());
        } else {
            int BP = com.baidu.tieba.frs.d.j.BP(this.jEe);
            if (!Bx(this.jEe) && !this.jDI.jfb && !this.jEi) {
                String f = com.baidu.tieba.tbadkCore.e.dNY().f("1~" + this.jfa, BP, frsRequestData.getIsGood(), this.jDO.getCategoryId());
                this.jEg = f;
                new a(this, true, f).execute(new Object[0]);
            }
            this.jEi = false;
        }
        this.jDP.a(this);
    }

    public void Bt(int i) {
        if (this.jwC != 1) {
            Bs(4);
        } else if (!this.jDP.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jDO), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 4, false);
        }
    }

    private void b(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.jDI.qq(z);
        this.jDQ.zW(i);
        this.jDP.a(frsRequestData);
        frsRequestData.Tf(this.jDI.cFH() ? "1" : "2");
        if (this.jEf) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.d.j.BP(this.jEd)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.jEf = false;
        frsRequestData.setKw(this.jfa);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = au.bwr().bws() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setSchemeUrl(this.mSchemeUrl);
        frsRequestData.setLastId(this.jCL);
        frsRequestData.setYuelaouLocate(this.jEb);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(z.bJf(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.KL(cLY());
        if (FrsFragment.jfp != 0) {
            frsRequestData.setCtime((int) FrsFragment.jfp);
        }
        if (FrsFragment.jfq != 0) {
            frsRequestData.setDataSize((int) FrsFragment.jfq);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.hB(this.jDS);
        com.baidu.tieba.frs.d.j.a(this.jEc, frsRequestData);
        int BP = com.baidu.tieba.frs.d.j.BP(this.jEe);
        b(i, frsRequestData);
        a(this.jfa, frsRequestData);
        if (!Bx(this.jEe) && !this.jDI.jfb && !this.jEi) {
            String f = com.baidu.tieba.tbadkCore.e.dNY().f("1~" + this.jfa, BP, frsRequestData.getIsGood(), this.jDO.getCategoryId());
            this.jEg = f;
            new a(this, true, f).execute(new Object[0]);
        }
        cMb();
        this.jEi = false;
    }

    private int cLY() {
        return (this.jDI == null || !(this.jDI.mHeadLineDefaultNavTabId == -1 || this.jDI.mHeadLineDefaultNavTabId == this.jwC)) ? 0 : 1;
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
        if (mVar == null || mVar.getForum() == null || (at.isEmpty(mVar.getForum().getName()) && 340001 != mVar.mErrorNo)) {
            return false;
        }
        if (mVar.getDataParseTime() > 0) {
            this.jDI.fLN = mVar.getDataParseTime();
        }
        By(com.baidu.tieba.frs.d.j.BQ(mVar.getSortType()));
        R(com.baidu.tieba.frs.d.j.BQ(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.jwC = mVar.getFrsDefaultTabId();
        }
        this.jeH.receiveData(mVar);
        d(this.jeH);
        this.jDN = new ArrayList<>();
        if (frsRequestData != null) {
            this.jDO = frsRequestData;
            this.mPn = this.jDO.getPn();
            this.jfa = this.jDO.getKw();
            this.jDI.setForumName(this.jfa);
            this.jDI.setFrom(this.mFrom);
            this.jDI.setPn(this.mPn);
            this.jDI.setFlag(this.mFlag);
        }
        if (this.jeH.getThreadList() != null) {
            this.jDN.addAll(this.jeH.getThreadList());
        }
        if (this.jwC != 1 && this.isNetFirstLoad) {
            this.jDQ.a(7, false, this.jCK);
        } else {
            this.jDQ.a(this.mType, false, this.jCK);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.jDO)) {
            cMp();
        }
        if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jeH.getForum()));
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() != null && !TextUtils.isEmpty(mVar.getForum().getName()) && frsRequestData != null && r.dEV().dEP() != null) {
            r.dEV().dEP().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        if (StringUtils.isNull(mVar.getUserData().getAppealThreadPopover())) {
            return true;
        }
        this.jDI.aI(TbadkCoreApplication.getCurrentAccount(), mVar.getForum().getId(), mVar.getUserData().getAppealThreadPopover());
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        FrsRequestData requestData;
        if (mvcSocketResponsedMessage != null) {
            this.jEj.g(this);
            this.jEj.a(mvcSocketResponsedMessage);
            this.jEj.a(mvcSocketMessage);
            this.jEj.a(mvcNetMessage);
            this.jEj.a(this.jDQ);
            Looper.myQueue().addIdleHandler(this.jEj);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iPi = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.npe = mvcSocketResponsedMessage.getDownSize();
            this.jCK = fVar;
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
                this.jDI.a(errorData);
            }
        }
    }

    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.eZj) {
            this.eZj = true;
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
            this.jEk.g(this);
            this.jEk.a(mvcHttpResponsedMessage);
            this.jEk.a(mvcHttpMessage);
            this.jEk.a(mvcNetMessage);
            this.jEk.a(this.jDQ);
            Looper.myQueue().addIdleHandler(this.jEk);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iPi = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.npe = mvcHttpResponsedMessage.getDownSize();
            this.jCK = fVar;
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
                this.jDI.a(errorData);
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
        if (!this.eZj) {
            this.eZj = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void cFy() {
        if (this.jeH != null && this.jeH.getForum() != null && this.jeH.getForum().getBannerListData() != null) {
            String lastIds = this.jeH.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.jCL = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.k.bHF().isSmallFlow()) {
            this.fLR = System.currentTimeMillis() - this.jDI.iHN;
            this.jDI.fLQ = System.currentTimeMillis() - this.jDI.jfn;
            com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(i, z, responsedMessage, this.jDI.fLH, this.jDI.createTime, this.jDI.fLQ, false, this.jDI.fLI, this.jDI.fLN, this.fLR);
            this.jDI.createTime = 0L;
            this.jDI.fLH = 0L;
            com.baidu.tieba.frs.d.k.a(this, this.jDI.iHN);
            this.jDI.iHN = -1L;
            hVar.bHC();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.k.bHF().isSmallFlow()) {
            this.fLR = System.currentTimeMillis() - this.jDI.jfo;
            this.jDI.fLQ = System.currentTimeMillis() - this.jDI.jfn;
            com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(1000, z, responsedMessage, this.jDI.fLH, this.jDI.createTime, this.jDI.fLQ, false, this.jDI.fLI, this.jDI.fLN, this.fLR);
            if (this.mType == 4) {
                hVar.fLZ = this.fLR;
                hVar.ln(true);
            } else if (this.mType == 3) {
                hVar.fMa = this.fLR;
                hVar.ln(false);
            }
        }
    }

    public FrsRequestData cLZ() {
        return this.jDO;
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

    public FrsViewData cLF() {
        return this.jeH;
    }

    public com.baidu.tieba.tbadkCore.f cMa() {
        return this.jCK;
    }

    private boolean cMb() {
        this.iKz = System.currentTimeMillis();
        return this.jDP.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.jeH.receiveData(mVar);
        d(this.jeH);
        this.jDN = new ArrayList<>();
        if (this.jeH.getThreadList() != null) {
            this.jDN.addAll(this.jeH.getThreadList());
        }
        this.jDQ.c(mVar);
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
        private FrsModelController jEp;
        private String mCacheKey;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.mCacheKey = null;
            this.mCacheKey = str;
            this.jEp = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.dNY().Td(this.mCacheKey)) {
                if (!com.baidu.tieba.tbadkCore.e.dNY().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.mCacheKey)) {
                    com.baidu.tieba.tbadkCore.e.dNY().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.dNY().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().bpu(), true) && !responseData.getBookInfo().bpu().equals("0") && responseData.getBookInfo().bpv() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().bpu(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.jEp != null && mVarArr != null) {
                this.jEp.f(mVarArr.length > 0 ? mVarArr[0] : null);
                this.jEp.R(this.jEp.jEc, true);
            } else if (this.jEp != null && !this.jEp.jDP.cMs()) {
                if (this.jEp.jDP.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                    this.jEp.a((MvcHttpResponsedMessage) this.jEp.jDP.getResponsedMessage(), (MvcHttpMessage) this.jEp.jDP.cMt(), this.jEp.jDP.cMu());
                }
                if (this.jEp.jDP.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                    this.jEp.a((MvcSocketResponsedMessage) this.jEp.jDP.getResponsedMessage(), (MvcSocketMessage) this.jEp.jDP.cMt(), this.jEp.jDP.cMu());
                }
            }
        }
    }

    public long czf() {
        return this.iKC;
    }

    public long czg() {
        return this.iKA;
    }

    public long czh() {
        return this.iKB;
    }

    public long czi() {
        return this.iKz;
    }

    public boolean isLoading() {
        return this.jDP.isLoading();
    }

    public int cMc() {
        return this.jDU;
    }

    private void cMd() {
        if (this.jEa == null) {
            this.jEa = new ArrayList<>();
        }
        if (this.jEa.size() == 0) {
            this.jEa.add(new aa());
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void a(int i, int i2, ax axVar) {
        this.jwC = c(i, null);
        if (axVar == null && (axVar = cC(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.jDZ != null) {
                ba baVar = new ba();
                baVar.hasMore = false;
                baVar.pn = 1;
                baVar.forumName = this.jfa;
                baVar.jkh = false;
                if (this.jeH != null && this.jeH.getForum() != null) {
                    baVar.forumId = this.jeH.getForum().getId();
                }
                cMd();
                this.jeH.setThreadList(this.jEa);
                this.jDZ.a(i, i2, baVar, this.jEa);
            }
            axVar = new ax();
            axVar.pn = -1;
        }
        if (this.jeH != null && this.jeH.getForum() != null) {
            axVar.forumId = this.jeH.getForum().getId();
        }
        axVar.forumName = this.jfa;
        if (ac.cHd().At(1) != null && this.jwC == 1) {
            this.jDO.setCategoryId(i2);
        }
        this.jDT = i2;
        this.jDV = axVar;
        b(i, i2, axVar);
        Bs(5);
    }

    @Override // com.baidu.tieba.frs.an
    public void a(ar arVar) {
        this.jDZ = arVar;
        this.jDY.a(this.jEl);
    }

    private void Bs(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.jDV != null) {
                    this.jDV.pn++;
                    break;
                }
                break;
            case 2:
                if (this.jDV != null) {
                    ax axVar = this.jDV;
                    axVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.jDV != null) {
                    this.jDV.pn = -1;
                    break;
                }
                break;
        }
        if (this.jwC == 1) {
            if (this.jDU == this.jDT) {
                ArrayList<com.baidu.adp.widget.ListView.n> arrayList = new ArrayList<>();
                if (this.jDN != null) {
                    arrayList.addAll(this.jDN);
                }
                this.jeH.setThreadList(arrayList);
                if (this.jDZ != null) {
                    this.jDZ.a(this.jwC, this.jDT, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.jDU = this.jDT;
            return;
        }
        an Au = this.jDY.Au(this.jwC);
        if (Au != null) {
            this.jDW = true;
            Au.a(this.jwC, this.jDT, this.jDV);
            return;
        }
        if (this.jeH != null && this.jeH.getThreadList() != null) {
            this.jeH.getThreadList().clear();
        }
        this.jDZ.a(this.jwC, this.jDT, null, null);
    }

    public boolean hasMore() {
        if ((this.jDV instanceof ba) && ((ba) this.jDV).errCode == 0) {
            return ((ba) this.jDV).hasMore;
        }
        return true;
    }

    private int cB(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ax axVar) {
        this.jDX.put(cB(i, i2), axVar);
    }

    public ax cC(int i, int i2) {
        return this.jDX.get(cB(i, i2));
    }

    @Override // com.baidu.tieba.frs.an
    public void init() {
        this.jDY.init();
    }

    @Override // com.baidu.tieba.frs.an
    public void cbG() {
        this.jDY.destory();
        this.jDY.clear();
    }

    public int cMe() {
        return this.jwC;
    }

    public boolean cMf() {
        return 1 == this.jwC;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(com.baidu.tbadk.core.data.au auVar) {
        if (auVar != null && !StringUtils.isNull(auVar.getId()) && !x.isEmpty(this.jDN)) {
            if (this.jwC == 1) {
                this.jeH.addMyNewThread(auVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<com.baidu.adp.widget.ListView.n> it = this.jDN.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.n next = it.next();
                if ((next instanceof by) && auVar.getId().equals(((by) next).eMv.getId())) {
                    return;
                }
            }
            this.jDN.add(topThreadSize, auVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.jDN == null || this.jDN.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.n> it = this.jDN.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.n next = it.next();
                if (!(next instanceof by)) {
                    i = i2;
                } else if (((by) next).eMv.brl() != 0) {
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

    public boolean cMg() {
        return this.jDW;
    }

    public void cMh() {
        com.baidu.tieba.frs.s sVar = new com.baidu.tieba.frs.s();
        if (this.jDU == 0) {
            sVar.Al(this.jEc);
        }
        if (this.jeH.getThreadList() != null) {
            this.jeH.getThreadList().clear();
            this.jeH.getThreadList().add(sVar);
        }
        if (this.jDN != null) {
            this.jDN.clear();
            this.jDN.add(sVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cMi() {
        return this.jDN;
    }

    public void By(int i) {
        AccountData currentAccountObj;
        this.jEc = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.d.j.ba("1~" + str + this.jfa, this.jEc);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dQr();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dQs();
        }
    }

    public void Bz(int i) {
        this.jEd = i;
    }

    public void rn(boolean z) {
        this.jEf = z;
    }

    public int cMj() {
        return this.jEc;
    }

    public int cMk() {
        return this.jEe;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.d.j.BP(this.jEc);
    }

    public boolean cMl() {
        return this.jDR;
    }

    public boolean cMm() {
        return this.jEc == 5;
    }

    public boolean cMn() {
        return this.jDO != null && this.jDO.getLoadType() == 1;
    }

    public boolean cMo() {
        return this.jEc == 7 || (!this.jDP.cMs() && this.jEe == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.jDI.cEQ() != null) {
            return this.jDI.cEQ().a(this.jEc, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bz.eTz.get() && r.dEV().dEP() != null) {
            int ba = r.dEV().dEP().ba(str, false);
            int bb = r.dEV().dEP().bb(str, false);
            if (frsRequestData.getLoadType() == 1) {
                ba++;
            } else if (frsRequestData.getLoadType() == 2) {
                bb++;
            }
            frsRequestData.setRefreshCount(ba);
            frsRequestData.setLoadCount(bb);
        }
    }

    public void cMp() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.jeH != null && this.jeH.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.jeH.getForum().getId(), 0L));
        }
        this.jDI.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void Lz(final String str) {
        com.baidu.tbadk.util.ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dNY().gn(FrsModelController.this.jEg, str);
                return null;
            }
        }, null);
    }

    public void LA(final String str) {
        com.baidu.tbadk.util.ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dNY().go(FrsModelController.this.jEg, str);
                return null;
            }
        }, null);
    }

    public void LB(final String str) {
        com.baidu.tbadk.util.ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dNY().gp(FrsModelController.this.jEg, str);
                return null;
            }
        }, null);
    }

    public void ro(boolean z) {
        this.jEi = z;
    }
}
