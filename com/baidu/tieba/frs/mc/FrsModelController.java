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
    private boolean eUy;
    private long fHk;
    private long iFS;
    private long iFT;
    private long iFU;
    private long iFV;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private FrsViewData jaa;
    private String jat;
    private int jrW;
    private com.baidu.tieba.tbadkCore.f jye;
    private String jyf;
    private String jzA;
    private final SparseArray<Boolean> jzB;
    private boolean jzC;
    private n jzD;
    private m jzE;
    private ar jzF;
    private final FrsFragment jzc;
    private ArrayList<com.baidu.adp.widget.ListView.n> jzh;
    private FrsRequestData jzi;
    private FrsNetModel jzj;
    private final s jzk;
    private boolean jzl;
    private long jzm;
    private int jzn;
    private int jzo;
    private ax jzp;
    private boolean jzq;
    private SparseArray<ax> jzr;
    private ae jzs;
    private ar jzt;
    private ArrayList<com.baidu.adp.widget.ListView.n> jzu;
    private String jzv;
    private int jzw;
    private int jzx;
    private int jzy;
    private boolean jzz;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSchemeUrl;
    private String mSource;
    private int mType;

    public boolean zR(int i) {
        return this.jzB.get(i, false).booleanValue();
    }

    public void R(int i, boolean z) {
        this.jzB.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, s sVar) {
        super(frsFragment.getPageContext());
        this.jat = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSchemeUrl = "";
        this.mSource = null;
        this.jyf = null;
        this.jzm = 0L;
        this.jrW = 1;
        this.jzn = 0;
        this.jzo = 0;
        this.jzq = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.jzr = new SparseArray<>();
        this.fHk = 0L;
        this.eUy = false;
        this.jzw = -1;
        this.jzx = -1;
        this.jzy = -1;
        this.jzA = null;
        this.jzB = new SparseArray<>();
        this.jzD = new n();
        this.jzE = new m();
        this.jzF = new ar() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.ar
            public void a(int i, int i2, ba baVar, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
                FrsModelController.this.jzq = false;
                if (i == FrsModelController.this.jrW && FrsModelController.this.jzt != null) {
                    FrsModelController.this.jzp = baVar;
                    FrsModelController.this.b(i, i2, baVar);
                    ArrayList<com.baidu.adp.widget.ListView.n> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.jaa.setThreadList(arrayList2);
                    FrsModelController.this.jzt.a(i, i2, baVar, arrayList);
                }
            }
        };
        this.iFS = 0L;
        this.iFT = 0L;
        this.iFU = 0L;
        this.iFV = 0L;
        if (sVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.jzc = frsFragment;
        this.jzk = sVar;
        if (this.jzc.getActivity() instanceof FrsActivity) {
            this.jzj = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.jzc.getActivity()).getUniqueId().getId());
        }
        if (this.jzj != null) {
            if (this.jzj.getResponsedMessage() == null) {
                this.jzj.a(this);
            }
            this.jzi = this.jzj.cIA();
        }
        Z(this.jzc);
    }

    private void Z(FrsFragment frsFragment) {
        this.jzs = new ae();
        this.jzs.fEN = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.jzs));
        this.jzs.a(this.jzF);
    }

    public void cHM() {
        Looper.myQueue().removeIdleHandler(this.jzD);
        Looper.myQueue().removeIdleHandler(this.jzE);
        this.jzj.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.jat = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.jzv = bundle.getString("yuelaou_locate");
            this.jzl = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.jzc.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.jat)) {
            this.jat = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.jzv)) {
            this.jzv = "";
        }
        this.mSource = this.mFrom;
        cIg();
        if (this.jaa == null) {
            this.jaa = new FrsViewData();
        }
        if (this.jzj == null || this.jzi == null || this.jzi.bCT() == null || this.jzi.bCT().isEmpty() || this.jzi.bCT().containsKey(null) || this.jzi.bCT().containsValue(null)) {
            ar(bundle);
        }
        if (this.jat != null && this.jat.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    private void ar(Bundle bundle) {
        int i;
        this.jzi = new FrsRequestData();
        this.jzi.setSortType(com.baidu.tieba.frs.d.j.Aj(this.jzw));
        if (this.jzw == 5) {
            this.jzi.setIsGood(1);
        } else {
            this.jzi.setIsGood(0);
        }
        this.jzi.gp("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.jat));
        this.jzi.gp("client_type", "2");
        this.jzi.setPn(1);
        if (bundle != null) {
            this.jzi.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
            this.jzi.hB(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
        }
        this.jzi.RW("2");
        this.jzi.setObjSource("-2");
        this.jzi.setKw(this.jat);
        this.jzi.setWithGroup(1);
        this.jzi.setCid(0);
        this.jzi.setScrW(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        this.jzi.setScrH(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        this.jzi.setScrDip(com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        this.jzi.setqType(au.bsy().bsz() ? 2 : 1);
        this.jzi.setSchemeUrl(this.mSchemeUrl);
        this.jzi.setLastId(null);
        this.jzi.setYuelaouLocate(this.jzv);
        this.jzi.setLastClickTid(com.baidu.adp.lib.f.b.toLong(z.bFo(), 0L));
        this.jzi.setStType(this.mFrom);
        this.jzi.Je(1);
        this.jzi.setNeedCache(true);
        this.jzi.setUpdateType(3);
        com.baidu.tieba.frs.d.j.a(this.jzw, this.jzi);
        this.jzi.setLoadType(1);
        if (bz.eOO.get() && r.dBe().dAY() != null) {
            int ba = r.dBe().dAY().ba(this.jat, false);
            int bb = r.dBe().dAY().bb(this.jat, false);
            if (this.jzi.getLoadType() == 1) {
                i = ba + 1;
            } else if (this.jzi.getLoadType() == 2) {
                bb++;
                i = ba;
            } else {
                i = ba;
            }
            this.jzi.setRefreshCount(i);
            this.jzi.setLoadCount(bb);
        }
        this.jzj = new FrsNetModel(null, this.jzi);
        this.jzj.setUniqueId(((FrsActivity) this.jzc.getActivity()).getUniqueId());
        this.jzj.a(this);
        this.jzj.loadData();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.jat);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void cIg() {
        AccountData currentAccountObj;
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            zS(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            zS(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            this.jzy = com.baidu.tieba.frs.d.j.Kv("1~" + str + this.jat);
            zS(this.jzw);
        }
    }

    public boolean crT() {
        if (this.jrW != 1) {
            zM(1);
            return true;
        } else if (this.jzj.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jzi), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 1, false);
            return true;
        }
    }

    public void S(int i, boolean z) {
        if (this.jzi != null) {
            this.jzc.jaH = System.currentTimeMillis();
            if (this.jaa != null && this.jaa.getLikeFeedForumDataList() != null) {
                this.jaa.getLikeFeedForumDataList().clear();
            }
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jzi), FrsRequestData.class);
            frsRequestData.setPn(1);
            this.jrW = c(this.jrW, frsRequestData);
            if (this.jrW == 1) {
                if (!this.jzj.isLoading()) {
                    frsRequestData.setCallFrom(0);
                    b(frsRequestData, i, z ? false : true);
                    return;
                }
                return;
            }
            if (this.jzp == null) {
                this.jzp = new ax();
                this.jzp.pn = 1;
                this.jzp.forumName = this.jat;
                if (this.jaa != null && this.jaa.getForum() != null) {
                    this.jzp.forumId = this.jaa.getForum().getId();
                }
            }
            zM(i);
        }
    }

    public void T(int i, boolean z) {
        this.jzc.jaH = System.currentTimeMillis();
        if (this.jaa != null && this.jaa.getLikeFeedForumDataList() != null) {
            this.jaa.getLikeFeedForumDataList().clear();
        }
        this.jrW = c(this.jrW, this.jzi);
        if (this.jrW == 1) {
            a(this.jzi, i, z ? false : true);
            return;
        }
        if (this.jzp == null) {
            this.jzp = new ax();
            this.jzp.pn = 1;
            this.jzp.forumName = this.jat;
            if (this.jaa != null && this.jaa.getForum() != null) {
                this.jzp.forumId = this.jaa.getForum().getId();
            }
        }
        zM(i);
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.jzc.qm(z);
        this.jzk.yq(i);
        if (this.jzj.cIB() && (this.jzj.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
            a((MvcHttpResponsedMessage) this.jzj.getResponsedMessage(), (MvcHttpMessage) this.jzj.cIC(), this.jzj.cID());
        } else if (this.jzj.cIB() && (this.jzj.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
            a((MvcSocketResponsedMessage) this.jzj.getResponsedMessage(), (MvcSocketMessage) this.jzj.cIC(), this.jzj.cID());
        } else {
            int Aj = com.baidu.tieba.frs.d.j.Aj(this.jzy);
            if (!zR(this.jzy) && !this.jzc.jau && !this.jzC) {
                String f = com.baidu.tieba.tbadkCore.e.dKh().f("1~" + this.jat, Aj, frsRequestData.getIsGood(), this.jzi.getCategoryId());
                this.jzA = f;
                new a(this, true, f).execute(new Object[0]);
            }
            this.jzC = false;
        }
        this.jzj.a(this);
    }

    public void zN(int i) {
        if (this.jrW != 1) {
            zM(4);
        } else if (!this.jzj.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jzi), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 4, false);
        }
    }

    private void b(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.jzc.qm(z);
        this.jzk.yq(i);
        this.jzj.a(frsRequestData);
        frsRequestData.RW(this.jzc.cBQ() ? "1" : "2");
        if (this.jzz) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.d.j.Aj(this.jzx)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.jzz = false;
        frsRequestData.setKw(this.jat);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = au.bsy().bsz() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setSchemeUrl(this.mSchemeUrl);
        frsRequestData.setLastId(this.jyf);
        frsRequestData.setYuelaouLocate(this.jzv);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(z.bFo(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.Je(cIh());
        if (FrsFragment.jaI != 0) {
            frsRequestData.setCtime((int) FrsFragment.jaI);
        }
        if (FrsFragment.jaJ != 0) {
            frsRequestData.setDataSize((int) FrsFragment.jaJ);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.hB(this.jzm);
        com.baidu.tieba.frs.d.j.a(this.jzw, frsRequestData);
        int Aj = com.baidu.tieba.frs.d.j.Aj(this.jzy);
        b(i, frsRequestData);
        a(this.jat, frsRequestData);
        if (!zR(this.jzy) && !this.jzc.jau && !this.jzC) {
            String f = com.baidu.tieba.tbadkCore.e.dKh().f("1~" + this.jat, Aj, frsRequestData.getIsGood(), this.jzi.getCategoryId());
            this.jzA = f;
            new a(this, true, f).execute(new Object[0]);
        }
        cIk();
        this.jzC = false;
    }

    private int cIh() {
        return (this.jzc == null || !(this.jzc.mHeadLineDefaultNavTabId == -1 || this.jzc.mHeadLineDefaultNavTabId == this.jrW)) ? 0 : 1;
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
            this.jzc.fHg = mVar.getDataParseTime();
        }
        zS(com.baidu.tieba.frs.d.j.Ak(mVar.getSortType()));
        R(com.baidu.tieba.frs.d.j.Ak(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.jrW = mVar.getFrsDefaultTabId();
        }
        this.jaa.receiveData(mVar);
        d(this.jaa);
        this.jzh = new ArrayList<>();
        if (frsRequestData != null) {
            this.jzi = frsRequestData;
            this.mPn = this.jzi.getPn();
            this.jat = this.jzi.getKw();
            this.jzc.setForumName(this.jat);
            this.jzc.setFrom(this.mFrom);
            this.jzc.setPn(this.mPn);
            this.jzc.setFlag(this.mFlag);
        }
        if (this.jaa.getThreadList() != null) {
            this.jzh.addAll(this.jaa.getThreadList());
        }
        if (this.jrW != 1 && this.isNetFirstLoad) {
            this.jzk.a(7, false, this.jye);
        } else {
            this.jzk.a(this.mType, false, this.jye);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.jzi)) {
            cIy();
        }
        if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.jaa.getForum()));
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() != null && !TextUtils.isEmpty(mVar.getForum().getName()) && frsRequestData != null && r.dBe().dAY() != null) {
            r.dBe().dAY().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        }
        if (StringUtils.isNull(mVar.getUserData().getAppealThreadPopover())) {
            return true;
        }
        this.jzc.aH(TbadkCoreApplication.getCurrentAccount(), mVar.getForum().getId(), mVar.getUserData().getAppealThreadPopover());
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        FrsRequestData requestData;
        if (mvcSocketResponsedMessage != null) {
            this.jzD.g(this);
            this.jzD.a(mvcSocketResponsedMessage);
            this.jzD.a(mvcSocketMessage);
            this.jzD.a(mvcNetMessage);
            this.jzD.a(this.jzk);
            Looper.myQueue().addIdleHandler(this.jzD);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iKB = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.nkx = mvcSocketResponsedMessage.getDownSize();
            this.jye = fVar;
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
                this.jzc.a(errorData);
            }
        }
    }

    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.eUy) {
            this.eUy = true;
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
            this.jzE.g(this);
            this.jzE.a(mvcHttpResponsedMessage);
            this.jzE.a(mvcHttpMessage);
            this.jzE.a(mvcNetMessage);
            this.jzE.a(this.jzk);
            Looper.myQueue().addIdleHandler(this.jzE);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iKB = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.nkx = mvcHttpResponsedMessage.getDownSize();
            this.jye = fVar;
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
                this.jzc.a(errorData);
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
        if (!this.eUy) {
            this.eUy = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void cBH() {
        if (this.jaa != null && this.jaa.getForum() != null && this.jaa.getForum().getBannerListData() != null) {
            String lastIds = this.jaa.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.jyf = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.k.bDO().isSmallFlow()) {
            this.fHk = System.currentTimeMillis() - this.jzc.iDg;
            this.jzc.fHj = System.currentTimeMillis() - this.jzc.jaG;
            com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(i, z, responsedMessage, this.jzc.fHa, this.jzc.createTime, this.jzc.fHj, false, this.jzc.fHb, this.jzc.fHg, this.fHk);
            this.jzc.createTime = 0L;
            this.jzc.fHa = 0L;
            com.baidu.tieba.frs.d.k.a(this, this.jzc.iDg);
            this.jzc.iDg = -1L;
            hVar.bDL();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.k.bDO().isSmallFlow()) {
            this.fHk = System.currentTimeMillis() - this.jzc.jaH;
            this.jzc.fHj = System.currentTimeMillis() - this.jzc.jaG;
            com.baidu.tbadk.n.h hVar = new com.baidu.tbadk.n.h(1000, z, responsedMessage, this.jzc.fHa, this.jzc.createTime, this.jzc.fHj, false, this.jzc.fHb, this.jzc.fHg, this.fHk);
            if (this.mType == 4) {
                hVar.fHs = this.fHk;
                hVar.lj(true);
            } else if (this.mType == 3) {
                hVar.fHt = this.fHk;
                hVar.lj(false);
            }
        }
    }

    public FrsRequestData cIi() {
        return this.jzi;
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

    public FrsViewData cHO() {
        return this.jaa;
    }

    public com.baidu.tieba.tbadkCore.f cIj() {
        return this.jye;
    }

    private boolean cIk() {
        this.iFS = System.currentTimeMillis();
        return this.jzj.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.jaa.receiveData(mVar);
        d(this.jaa);
        this.jzh = new ArrayList<>();
        if (this.jaa.getThreadList() != null) {
            this.jzh.addAll(this.jaa.getThreadList());
        }
        this.jzk.c(mVar);
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
        private FrsModelController jzJ;
        private String mCacheKey;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.mCacheKey = null;
            this.mCacheKey = str;
            this.jzJ = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.dKh().RU(this.mCacheKey)) {
                if (!com.baidu.tieba.tbadkCore.e.dKh().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.mCacheKey)) {
                    com.baidu.tieba.tbadkCore.e.dKh().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.dKh().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().blB(), true) && !responseData.getBookInfo().blB().equals("0") && responseData.getBookInfo().blC() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().blB(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.jzJ != null && mVarArr != null) {
                this.jzJ.f(mVarArr.length > 0 ? mVarArr[0] : null);
                this.jzJ.R(this.jzJ.jzw, true);
            } else if (this.jzJ != null && !this.jzJ.jzj.cIB()) {
                if (this.jzJ.jzj.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                    this.jzJ.a((MvcHttpResponsedMessage) this.jzJ.jzj.getResponsedMessage(), (MvcHttpMessage) this.jzJ.jzj.cIC(), this.jzJ.jzj.cID());
                }
                if (this.jzJ.jzj.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                    this.jzJ.a((MvcSocketResponsedMessage) this.jzJ.jzj.getResponsedMessage(), (MvcSocketMessage) this.jzJ.jzj.cIC(), this.jzJ.jzj.cID());
                }
            }
        }
    }

    public long cvo() {
        return this.iFV;
    }

    public long cvp() {
        return this.iFT;
    }

    public long cvq() {
        return this.iFU;
    }

    public long cvr() {
        return this.iFS;
    }

    public boolean isLoading() {
        return this.jzj.isLoading();
    }

    public int cIl() {
        return this.jzo;
    }

    private void cIm() {
        if (this.jzu == null) {
            this.jzu = new ArrayList<>();
        }
        if (this.jzu.size() == 0) {
            this.jzu.add(new aa());
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void a(int i, int i2, ax axVar) {
        this.jrW = c(i, null);
        if (axVar == null && (axVar = cC(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.jzt != null) {
                ba baVar = new ba();
                baVar.hasMore = false;
                baVar.pn = 1;
                baVar.forumName = this.jat;
                baVar.jfA = false;
                if (this.jaa != null && this.jaa.getForum() != null) {
                    baVar.forumId = this.jaa.getForum().getId();
                }
                cIm();
                this.jaa.setThreadList(this.jzu);
                this.jzt.a(i, i2, baVar, this.jzu);
            }
            axVar = new ax();
            axVar.pn = -1;
        }
        if (this.jaa != null && this.jaa.getForum() != null) {
            axVar.forumId = this.jaa.getForum().getId();
        }
        axVar.forumName = this.jat;
        if (ac.cDm().yN(1) != null && this.jrW == 1) {
            this.jzi.setCategoryId(i2);
        }
        this.jzn = i2;
        this.jzp = axVar;
        b(i, i2, axVar);
        zM(5);
    }

    @Override // com.baidu.tieba.frs.an
    public void a(ar arVar) {
        this.jzt = arVar;
        this.jzs.a(this.jzF);
    }

    private void zM(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.jzp != null) {
                    this.jzp.pn++;
                    break;
                }
                break;
            case 2:
                if (this.jzp != null) {
                    ax axVar = this.jzp;
                    axVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.jzp != null) {
                    this.jzp.pn = -1;
                    break;
                }
                break;
        }
        if (this.jrW == 1) {
            if (this.jzo == this.jzn) {
                ArrayList<com.baidu.adp.widget.ListView.n> arrayList = new ArrayList<>();
                if (this.jzh != null) {
                    arrayList.addAll(this.jzh);
                }
                this.jaa.setThreadList(arrayList);
                if (this.jzt != null) {
                    this.jzt.a(this.jrW, this.jzn, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.jzo = this.jzn;
            return;
        }
        an yO = this.jzs.yO(this.jrW);
        if (yO != null) {
            this.jzq = true;
            yO.a(this.jrW, this.jzn, this.jzp);
            return;
        }
        if (this.jaa != null && this.jaa.getThreadList() != null) {
            this.jaa.getThreadList().clear();
        }
        this.jzt.a(this.jrW, this.jzn, null, null);
    }

    public boolean hasMore() {
        if ((this.jzp instanceof ba) && ((ba) this.jzp).errCode == 0) {
            return ((ba) this.jzp).hasMore;
        }
        return true;
    }

    private int cB(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ax axVar) {
        this.jzr.put(cB(i, i2), axVar);
    }

    public ax cC(int i, int i2) {
        return this.jzr.get(cB(i, i2));
    }

    @Override // com.baidu.tieba.frs.an
    public void init() {
        this.jzs.init();
    }

    @Override // com.baidu.tieba.frs.an
    public void bXP() {
        this.jzs.destory();
        this.jzs.clear();
    }

    public int cIn() {
        return this.jrW;
    }

    public boolean cIo() {
        return 1 == this.jrW;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(com.baidu.tbadk.core.data.au auVar) {
        if (auVar != null && !StringUtils.isNull(auVar.getId()) && !x.isEmpty(this.jzh)) {
            if (this.jrW == 1) {
                this.jaa.addMyNewThread(auVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<com.baidu.adp.widget.ListView.n> it = this.jzh.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.n next = it.next();
                if ((next instanceof by) && auVar.getId().equals(((by) next).eHK.getId())) {
                    return;
                }
            }
            this.jzh.add(topThreadSize, auVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.jzh == null || this.jzh.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.n> it = this.jzh.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.n next = it.next();
                if (!(next instanceof by)) {
                    i = i2;
                } else if (((by) next).eHK.bns() != 0) {
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

    public boolean cIp() {
        return this.jzq;
    }

    public void cIq() {
        com.baidu.tieba.frs.s sVar = new com.baidu.tieba.frs.s();
        if (this.jzo == 0) {
            sVar.yF(this.jzw);
        }
        if (this.jaa.getThreadList() != null) {
            this.jaa.getThreadList().clear();
            this.jaa.getThreadList().add(sVar);
        }
        if (this.jzh != null) {
            this.jzh.clear();
            this.jzh.add(sVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cIr() {
        return this.jzh;
    }

    public void zS(int i) {
        AccountData currentAccountObj;
        this.jzw = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.d.j.ba("1~" + str + this.jat, this.jzw);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dMA();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dMB();
        }
    }

    public void zT(int i) {
        this.jzx = i;
    }

    public void rj(boolean z) {
        this.jzz = z;
    }

    public int cIs() {
        return this.jzw;
    }

    public int cIt() {
        return this.jzy;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.d.j.Aj(this.jzw);
    }

    public boolean cIu() {
        return this.jzl;
    }

    public boolean cIv() {
        return this.jzw == 5;
    }

    public boolean cIw() {
        return this.jzi != null && this.jzi.getLoadType() == 1;
    }

    public boolean cIx() {
        return this.jzw == 7 || (!this.jzj.cIB() && this.jzy == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.jzc.cAZ() != null) {
            return this.jzc.cAZ().a(this.jzw, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bz.eOO.get() && r.dBe().dAY() != null) {
            int ba = r.dBe().dAY().ba(str, false);
            int bb = r.dBe().dAY().bb(str, false);
            if (frsRequestData.getLoadType() == 1) {
                ba++;
            } else if (frsRequestData.getLoadType() == 2) {
                bb++;
            }
            frsRequestData.setRefreshCount(ba);
            frsRequestData.setLoadCount(bb);
        }
    }

    public void cIy() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.jaa != null && this.jaa.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.jaa.getForum().getId(), 0L));
        }
        this.jzc.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void Ko(final String str) {
        com.baidu.tbadk.util.ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dKh().gm(FrsModelController.this.jzA, str);
                return null;
            }
        }, null);
    }

    public void Kp(final String str) {
        com.baidu.tbadk.util.ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dKh().gn(FrsModelController.this.jzA, str);
                return null;
            }
        }, null);
    }

    public void Kq(final String str) {
        com.baidu.tbadk.util.ac.a(new ab<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ab
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dKh().go(FrsModelController.this.jzA, str);
                return null;
            }
        }, null);
    }

    public void rk(boolean z) {
        this.jzC = z;
    }
}
