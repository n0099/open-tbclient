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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.w;
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
import com.baidu.tieba.frs.r;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.m>, ap {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private boolean dQs;
    private long eAZ;
    private int hNn;
    private com.baidu.tieba.tbadkCore.f hTe;
    private String hTf;
    private boolean hUA;
    private String hUB;
    private final SparseArray<Boolean> hUC;
    private boolean hUD;
    private n hUE;
    private m hUF;
    private at hUG;
    private final FrsFragment hUd;
    private ArrayList<q> hUi;
    private FrsRequestData hUj;
    private FrsNetModel hUk;
    private final com.baidu.tieba.tbadkCore.q hUl;
    private boolean hUm;
    private long hUn;
    private int hUo;
    private int hUp;
    private ay hUq;
    private boolean hUr;
    private SparseArray<ay> hUs;
    private ag hUt;
    private at hUu;
    private ArrayList<q> hUv;
    private String hUw;
    private int hUx;
    private int hUy;
    private int hUz;
    private long hfB;
    private long hfC;
    private long hfD;
    private long hfE;
    private String hzC;
    private FrsViewData hzi;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSchemeUrl;
    private String mSource;
    private int mType;

    public boolean vD(int i) {
        return this.hUC.get(i, false).booleanValue();
    }

    public void N(int i, boolean z) {
        this.hUC.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, com.baidu.tieba.tbadkCore.q qVar) {
        super(frsFragment.getPageContext());
        this.hzC = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSchemeUrl = "";
        this.mSource = null;
        this.hTf = null;
        this.hUn = 0L;
        this.hNn = 1;
        this.hUo = 0;
        this.hUp = 0;
        this.hUr = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.hUs = new SparseArray<>();
        this.eAZ = 0L;
        this.dQs = false;
        this.hUx = -1;
        this.hUy = -1;
        this.hUz = -1;
        this.hUB = null;
        this.hUC = new SparseArray<>();
        this.hUE = new n();
        this.hUF = new m();
        this.hUG = new at() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.at
            public void a(int i, int i2, bb bbVar, ArrayList<q> arrayList) {
                FrsModelController.this.hUr = false;
                if (i == FrsModelController.this.hNn && FrsModelController.this.hUu != null) {
                    FrsModelController.this.hUq = bbVar;
                    FrsModelController.this.b(i, i2, bbVar);
                    ArrayList<q> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.hzi.setThreadList(arrayList2);
                    FrsModelController.this.hUu.a(i, i2, bbVar, arrayList);
                }
            }
        };
        this.hfB = 0L;
        this.hfC = 0L;
        this.hfD = 0L;
        this.hfE = 0L;
        if (qVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.hUd = frsFragment;
        this.hUl = qVar;
        if (this.hUd.getActivity() instanceof FrsActivity) {
            this.hUk = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.hUd.getActivity()).getUniqueId().getId());
        }
        if (this.hUk != null) {
            if (this.hUk.ceb() == null) {
                this.hUk.a(this);
            }
            this.hUj = this.hUk.cdZ();
        }
        V(this.hUd);
    }

    private void V(FrsFragment frsFragment) {
        this.hUt = new ag();
        this.hUt.eyE = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.hUt));
        this.hUt.a(this.hUG);
    }

    public void cdl() {
        Looper.myQueue().removeIdleHandler(this.hUE);
        Looper.myQueue().removeIdleHandler(this.hUF);
        this.hUk.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.hzC = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.hUw = bundle.getString("yuelaou_locate");
            this.hUm = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.hUd.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.hzC)) {
            this.hzC = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.hUw)) {
            this.hUw = "";
        }
        this.mSource = this.mFrom;
        cdF();
        this.hzi = new FrsViewData();
        if (this.hUk == null || this.hUj == null || this.hUj.bgV() == null || this.hUj.bgV().isEmpty() || this.hUj.bgV().containsKey(null) || this.hUj.bgV().containsValue(null)) {
            ap(bundle);
        }
        if (this.hzC != null && this.hzC.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    private void ap(Bundle bundle) {
        int i;
        this.hUj = new FrsRequestData();
        this.hUj.setSortType(com.baidu.tieba.frs.f.g.vV(this.hUx));
        if (this.hUx == 5) {
            this.hUj.setIsGood(1);
        } else {
            this.hUj.setIsGood(0);
        }
        this.hUj.fw("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.hzC));
        this.hUj.fw("client_type", "2");
        this.hUj.setPn(1);
        if (bundle != null) {
            this.hUj.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
            this.hUj.fu(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
        }
        this.hUj.MU("2");
        this.hUj.setObjSource("-2");
        this.hUj.setKw(this.hzC);
        this.hUj.setWithGroup(1);
        this.hUj.setCid(0);
        this.hUj.setScrW(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        this.hUj.setScrH(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        this.hUj.setScrDip(com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        this.hUj.setqType(as.aWR().aWS() ? 2 : 1);
        this.hUj.setSchemeUrl(this.mSchemeUrl);
        this.hUj.setLastId(null);
        this.hUj.setYuelaouLocate(this.hUw);
        this.hUj.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ab.bjb(), 0L));
        this.hUj.setStType(this.mFrom);
        this.hUj.ER(1);
        this.hUj.setNeedCache(true);
        this.hUj.setUpdateType(3);
        com.baidu.tieba.frs.f.g.a(this.hUx, this.hUj);
        this.hUj.setLoadType(1);
        if (bu.dLW.get() && com.baidu.tieba.recapp.q.cYS().cYM() != null) {
            int aS = com.baidu.tieba.recapp.q.cYS().cYM().aS(this.hzC, false);
            int aT = com.baidu.tieba.recapp.q.cYS().cYM().aT(this.hzC, false);
            if (this.hUj.getLoadType() == 1) {
                i = aS + 1;
            } else if (this.hUj.getLoadType() == 2) {
                aT++;
                i = aS;
            } else {
                i = aS;
            }
            this.hUj.setRefreshCount(i);
            this.hUj.setLoadCount(aT);
        }
        this.hUk = new FrsNetModel(null, this.hUj);
        this.hUk.setUniqueId(((FrsActivity) this.hUd.getActivity()).getUniqueId());
        this.hUk.a(this);
        this.hUk.loadData();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.hzC);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void cdF() {
        AccountData currentAccountObj;
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            vE(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            vE(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            this.hUz = com.baidu.tieba.frs.f.g.FI("1~" + str + this.hzC);
            vE(this.hUx);
        }
    }

    public boolean bPk() {
        if (this.hNn != 1) {
            vy(1);
            return true;
        } else if (this.hUk.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.hUj), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 1, false);
            return true;
        }
    }

    public void O(int i, boolean z) {
        if (this.hUj != null) {
            this.hUd.hzQ = System.currentTimeMillis();
            if (this.hzi != null && this.hzi.getLikeFeedForumDataList() != null) {
                this.hzi.getLikeFeedForumDataList().clear();
            }
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.hUj), FrsRequestData.class);
            frsRequestData.setPn(1);
            this.hNn = c(this.hNn, frsRequestData);
            if (this.hNn == 1) {
                if (!this.hUk.isLoading()) {
                    frsRequestData.setCallFrom(0);
                    b(frsRequestData, i, z ? false : true);
                    return;
                }
                return;
            }
            if (this.hUq == null) {
                this.hUq = new ay();
                this.hUq.pn = 1;
                this.hUq.forumName = this.hzC;
                if (this.hzi != null && this.hzi.getForum() != null) {
                    this.hUq.forumId = this.hzi.getForum().getId();
                }
            }
            vy(i);
        }
    }

    public void P(int i, boolean z) {
        this.hUd.hzQ = System.currentTimeMillis();
        if (this.hzi != null && this.hzi.getLikeFeedForumDataList() != null) {
            this.hzi.getLikeFeedForumDataList().clear();
        }
        this.hNn = c(this.hNn, this.hUj);
        if (this.hNn == 1) {
            a(this.hUj, i, z ? false : true);
            return;
        }
        if (this.hUq == null) {
            this.hUq = new ay();
            this.hUq.pn = 1;
            this.hUq.forumName = this.hzC;
            if (this.hzi != null && this.hzi.getForum() != null) {
                this.hUq.forumId = this.hzi.getForum().getId();
            }
        }
        vy(i);
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.hUd.mW(z);
        this.hUl.uo(i);
        if (this.hUk.cea() && (this.hUk.ceb() instanceof MvcHttpResponsedMessage)) {
            a((MvcHttpResponsedMessage) this.hUk.ceb(), (MvcHttpMessage) this.hUk.cec(), this.hUk.ced());
        } else if (this.hUk.cea() && (this.hUk.ceb() instanceof MvcSocketResponsedMessage)) {
            a((MvcSocketResponsedMessage) this.hUk.ceb(), (MvcSocketMessage) this.hUk.cec(), this.hUk.ced());
        } else {
            int vV = com.baidu.tieba.frs.f.g.vV(this.hUz);
            if (!vD(this.hUz) && !this.hUd.hzD && !this.hUD) {
                String e = com.baidu.tieba.tbadkCore.e.dgY().e("1~" + this.hzC, vV, frsRequestData.getIsGood(), this.hUj.getCategoryId());
                this.hUB = e;
                new a(this, true, e).execute(new Object[0]);
            }
            this.hUD = false;
        }
        this.hUk.a(this);
    }

    public void vz(int i) {
        if (this.hNn != 1) {
            vy(4);
        } else if (!this.hUk.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.hUj), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 4, false);
        }
    }

    private void b(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.hUd.mW(z);
        this.hUl.uo(i);
        this.hUk.a(frsRequestData);
        frsRequestData.MU(this.hUd.bYE() ? "1" : "2");
        if (this.hUA) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.vV(this.hUy)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.hUA = false;
        frsRequestData.setKw(this.hzC);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = as.aWR().aWS() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setSchemeUrl(this.mSchemeUrl);
        frsRequestData.setLastId(this.hTf);
        frsRequestData.setYuelaouLocate(this.hUw);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ab.bjb(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.ER(cdG());
        if (FrsFragment.hzR != 0) {
            frsRequestData.setCtime((int) FrsFragment.hzR);
        }
        if (FrsFragment.hzS != 0) {
            frsRequestData.setDataSize((int) FrsFragment.hzS);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.fu(this.hUn);
        com.baidu.tieba.frs.f.g.a(this.hUx, frsRequestData);
        int vV = com.baidu.tieba.frs.f.g.vV(this.hUz);
        b(i, frsRequestData);
        a(this.hzC, frsRequestData);
        if (!vD(this.hUz) && !this.hUd.hzD && !this.hUD) {
            String e = com.baidu.tieba.tbadkCore.e.dgY().e("1~" + this.hzC, vV, frsRequestData.getIsGood(), this.hUj.getCategoryId());
            this.hUB = e;
            new a(this, true, e).execute(new Object[0]);
        }
        cdJ();
        this.hUD = false;
    }

    private int cdG() {
        return (this.hUd == null || !(this.hUd.mHeadLineDefaultNavTabId == -1 || this.hUd.mHeadLineDefaultNavTabId == this.hNn)) ? 0 : 1;
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
        if (mVar == null || mVar.getForum() == null || (ar.isEmpty(mVar.getForum().getName()) && 340001 != mVar.mErrorNo)) {
            return false;
        }
        if (mVar.getDataParseTime() > 0) {
            this.hUd.eAV = mVar.getDataParseTime();
        }
        vE(com.baidu.tieba.frs.f.g.vW(mVar.getSortType()));
        N(com.baidu.tieba.frs.f.g.vW(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.hNn = mVar.getFrsDefaultTabId();
        }
        this.hzi.receiveData(mVar);
        d(this.hzi);
        this.hUi = new ArrayList<>();
        if (frsRequestData != null) {
            this.hUj = frsRequestData;
            this.mPn = this.hUj.getPn();
            this.hzC = this.hUj.getKw();
            this.hUd.setForumName(this.hzC);
            this.hUd.setFrom(this.mFrom);
            this.hUd.setPn(this.mPn);
            this.hUd.setFlag(this.mFlag);
        }
        if (this.hzi.getThreadList() != null) {
            this.hUi.addAll(this.hzi.getThreadList());
        }
        if (this.hNn != 1 && this.isNetFirstLoad) {
            this.hUl.a(7, false, this.hTe);
        } else {
            this.hUl.a(this.mType, false, this.hTe);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.hUj)) {
            cdX();
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() == null || TextUtils.isEmpty(mVar.getForum().getName()) || frsRequestData == null || com.baidu.tieba.recapp.q.cYS().cYM() == null) {
            return true;
        }
        com.baidu.tieba.recapp.q.cYS().cYM().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        if (mvcSocketResponsedMessage != null) {
            this.hUE.f(this);
            this.hUE.a(mvcSocketResponsedMessage);
            this.hUE.a(mvcSocketMessage);
            this.hUE.a(mvcNetMessage);
            this.hUE.a(this.hUl);
            Looper.myQueue().addIdleHandler(this.hUE);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.hkm = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.lDA = mvcSocketResponsedMessage.getDownSize();
            this.hTe = fVar;
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
                this.hUd.a(errorData);
            }
        }
    }

    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dQs) {
            this.dQs = true;
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
            this.hUF.f(this);
            this.hUF.a(mvcHttpResponsedMessage);
            this.hUF.a(mvcHttpMessage);
            this.hUF.a(mvcNetMessage);
            this.hUF.a(this.hUl);
            Looper.myQueue().addIdleHandler(this.hUF);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.hkm = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.lDA = mvcHttpResponsedMessage.getDownSize();
            this.hTe = fVar;
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
                this.hUd.a(errorData);
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
        if (!this.dQs) {
            this.dQs = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void bYv() {
        if (this.hzi != null && this.hzi.getForum() != null && this.hzi.getForum().getBannerListData() != null) {
            String lastIds = this.hzi.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.hTf = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.bhP().bhQ()) {
            this.eAZ = System.currentTimeMillis() - this.hUd.hcE;
            this.hUd.eAY = System.currentTimeMillis() - this.hUd.hzP;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, this.hUd.eAO, this.hUd.createTime, this.hUd.eAY, false, this.hUd.eAP, this.hUd.eAV, this.eAZ);
            this.hUd.createTime = 0L;
            this.hUd.eAO = 0L;
            com.baidu.tieba.frs.f.h.a(this, this.hUd.hcE);
            this.hUd.hcE = -1L;
            iVar.bhM();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.bhP().bhQ()) {
            this.eAZ = System.currentTimeMillis() - this.hUd.hzQ;
            this.hUd.eAY = System.currentTimeMillis() - this.hUd.hzP;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1000, z, responsedMessage, this.hUd.eAO, this.hUd.createTime, this.hUd.eAY, false, this.hUd.eAP, this.hUd.eAV, this.eAZ);
            if (this.mType == 4) {
                iVar.eBh = this.eAZ;
                iVar.ix(true);
            } else if (this.mType == 3) {
                iVar.eBi = this.eAZ;
                iVar.ix(false);
            }
        }
    }

    public FrsRequestData cdH() {
        return this.hUj;
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

    public FrsViewData cdn() {
        return this.hzi;
    }

    public com.baidu.tieba.tbadkCore.f cdI() {
        return this.hTe;
    }

    private boolean cdJ() {
        this.hfB = System.currentTimeMillis();
        return this.hUk.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.hzi.receiveData(mVar);
        d(this.hzi);
        this.hUi = new ArrayList<>();
        if (this.hzi.getThreadList() != null) {
            this.hUi.addAll(this.hzi.getThreadList());
        }
        this.hUl.c(mVar);
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

    /* loaded from: classes9.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.m, Void> {
        private String bml;
        private FrsModelController hUK;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.bml = null;
            this.bml = str;
            this.hUK = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.dgY().MS(this.bml)) {
                if (!com.baidu.tieba.tbadkCore.e.dgY().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.bml)) {
                    com.baidu.tieba.tbadkCore.e.dgY().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.dgY().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().aQv(), true) && !responseData.getBookInfo().aQv().equals("0") && responseData.getBookInfo().aQw() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().aQv(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.hUK != null && mVarArr != null) {
                this.hUK.e(mVarArr.length > 0 ? mVarArr[0] : null);
                this.hUK.N(this.hUK.hUx, true);
            }
        }
    }

    public long bSs() {
        return this.hfE;
    }

    public long bSt() {
        return this.hfC;
    }

    public long bSu() {
        return this.hfD;
    }

    public long bSv() {
        return this.hfB;
    }

    public boolean isLoading() {
        return this.hUk.isLoading();
    }

    public int cdK() {
        return this.hUp;
    }

    private void cdL() {
        if (this.hUv == null) {
            this.hUv = new ArrayList<>();
        }
        if (this.hUv.size() == 0) {
            this.hUv.add(new ac());
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void a(int i, int i2, ay ayVar) {
        this.hNn = c(i, null);
        if (ayVar == null && (ayVar = ci(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.hUu != null) {
                bb bbVar = new bb();
                bbVar.hasMore = false;
                bbVar.pn = 1;
                bbVar.forumName = this.hzC;
                bbVar.hEr = false;
                if (this.hzi != null && this.hzi.getForum() != null) {
                    bbVar.forumId = this.hzi.getForum().getId();
                }
                cdL();
                this.hzi.setThreadList(this.hUv);
                this.hUu.a(i, i2, bbVar, this.hUv);
            }
            ayVar = new ay();
            ayVar.pn = -1;
        }
        if (this.hzi != null && this.hzi.getForum() != null) {
            ayVar.forumId = this.hzi.getForum().getId();
        }
        ayVar.forumName = this.hzC;
        if (ae.bZX().uK(1) != null && this.hNn == 1) {
            this.hUj.setCategoryId(i2);
        }
        this.hUo = i2;
        this.hUq = ayVar;
        b(i, i2, ayVar);
        vy(5);
    }

    @Override // com.baidu.tieba.frs.ap
    public void a(at atVar) {
        this.hUu = atVar;
        this.hUt.a(this.hUG);
    }

    private void vy(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.hUq != null) {
                    this.hUq.pn++;
                    break;
                }
                break;
            case 2:
                if (this.hUq != null) {
                    ay ayVar = this.hUq;
                    ayVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.hUq != null) {
                    this.hUq.pn = -1;
                    break;
                }
                break;
        }
        if (this.hNn == 1) {
            if (this.hUp == this.hUo) {
                ArrayList<q> arrayList = new ArrayList<>();
                if (this.hUi != null) {
                    arrayList.addAll(this.hUi);
                }
                this.hzi.setThreadList(arrayList);
                if (this.hUu != null) {
                    this.hUu.a(this.hNn, this.hUo, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.hUp = this.hUo;
            return;
        }
        ap uL = this.hUt.uL(this.hNn);
        if (uL != null) {
            this.hUr = true;
            uL.a(this.hNn, this.hUo, this.hUq);
            return;
        }
        if (this.hzi != null && this.hzi.getThreadList() != null) {
            this.hzi.getThreadList().clear();
        }
        this.hUu.a(this.hNn, this.hUo, null, null);
    }

    public boolean hasMore() {
        if ((this.hUq instanceof bb) && ((bb) this.hUq).errCode == 0) {
            return ((bb) this.hUq).hasMore;
        }
        return true;
    }

    private int ch(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ay ayVar) {
        this.hUs.put(ch(i, i2), ayVar);
    }

    public ay ci(int i, int i2) {
        return this.hUs.get(ch(i, i2));
    }

    @Override // com.baidu.tieba.frs.ap
    public void init() {
        this.hUt.init();
    }

    @Override // com.baidu.tieba.frs.ap
    public void bzf() {
        this.hUt.destory();
        this.hUt.clear();
    }

    public int cdM() {
        return this.hNn;
    }

    public boolean cdN() {
        return 1 == this.hNn;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(aq aqVar) {
        if (aqVar != null && !StringUtils.isNull(aqVar.getId()) && !w.isEmpty(this.hUi)) {
            if (this.hNn == 1) {
                this.hzi.addMyNewThread(aqVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<q> it = this.hUi.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if ((next instanceof bt) && aqVar.getId().equals(((bt) next).dLi.getId())) {
                    return;
                }
            }
            this.hUi.add(topThreadSize, aqVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.hUi == null || this.hUi.size() <= 0) {
            return 0;
        }
        Iterator<q> it = this.hUi.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                q next = it.next();
                if (!(next instanceof bt)) {
                    i = i2;
                } else if (((bt) next).dLi.aSk() != 0) {
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

    public boolean cdO() {
        return this.hUr;
    }

    public void cdP() {
        r rVar = new r();
        if (this.hUp == 0) {
            rVar.uE(this.hUx);
        }
        if (this.hzi.getThreadList() != null) {
            this.hzi.getThreadList().clear();
            this.hzi.getThreadList().add(rVar);
        }
        if (this.hUi != null) {
            this.hUi.clear();
            this.hUi.add(rVar);
        }
    }

    public ArrayList<q> cdQ() {
        return this.hUi;
    }

    public void vE(int i) {
        AccountData currentAccountObj;
        this.hUx = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.f.g.aM("1~" + str + this.hzC, this.hUx);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dje();
        } else {
            com.baidu.tieba.tbadkCore.util.e.djf();
        }
    }

    public void vF(int i) {
        this.hUy = i;
    }

    public void nO(boolean z) {
        this.hUA = z;
    }

    public int cdR() {
        return this.hUx;
    }

    public int cdS() {
        return this.hUz;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.vV(this.hUx);
    }

    public boolean cdT() {
        return this.hUm;
    }

    public boolean cdU() {
        return this.hUx == 5;
    }

    public boolean cdV() {
        return this.hUj != null && this.hUj.getLoadType() == 1;
    }

    public boolean cdW() {
        return this.hUx == 7 || (!this.hUk.cea() && this.hUz == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.hUd.bXQ() != null) {
            return this.hUd.bXQ().a(this.hUx, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bu.dLW.get() && com.baidu.tieba.recapp.q.cYS().cYM() != null) {
            int aS = com.baidu.tieba.recapp.q.cYS().cYM().aS(str, false);
            int aT = com.baidu.tieba.recapp.q.cYS().cYM().aT(str, false);
            if (frsRequestData.getLoadType() == 1) {
                aS++;
            } else if (frsRequestData.getLoadType() == 2) {
                aT++;
            }
            frsRequestData.setRefreshCount(aS);
            frsRequestData.setLoadCount(aT);
        }
    }

    public void cdX() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.hzi != null && this.hzi.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.hzi.getForum().getId(), 0L));
        }
        this.hUd.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void FB(final String str) {
        ad.a(new com.baidu.tbadk.util.ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dgY().ft(FrsModelController.this.hUB, str);
                return null;
            }
        }, null);
    }

    public void FC(final String str) {
        ad.a(new com.baidu.tbadk.util.ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dgY().fu(FrsModelController.this.hUB, str);
                return null;
            }
        }, null);
    }

    public void FD(final String str) {
        ad.a(new com.baidu.tbadk.util.ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dgY().fv(FrsModelController.this.hUB, str);
                return null;
            }
        }, null);
    }

    public void nP(boolean z) {
        this.hUD = z;
    }
}
