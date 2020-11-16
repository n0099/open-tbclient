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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.r;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes21.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.m>, ar {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private boolean eHZ;
    private long fuB;
    private FrsViewData iHB;
    private String iHV;
    private int iWC;
    private long inr;

    /* renamed from: int  reason: not valid java name */
    private long f5int;
    private long inu;
    private long inv;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private com.baidu.tieba.tbadkCore.f jcJ;
    private String jcK;
    private final FrsFragment jdH;
    private ArrayList<q> jdM;
    private FrsRequestData jdN;
    private FrsNetModel jdO;
    private final r jdP;
    private boolean jdQ;
    private long jdR;
    private int jdS;
    private int jdT;
    private ba jdU;
    private boolean jdV;
    private SparseArray<ba> jdW;
    private ai jdX;
    private av jdY;
    private ArrayList<q> jdZ;
    private String jea;
    private int jeb;
    private int jec;
    private int jed;
    private boolean jee;
    private String jef;
    private final SparseArray<Boolean> jeg;
    private boolean jeh;
    private n jei;
    private m jej;
    private av jek;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSchemeUrl;
    private String mSource;
    private int mType;

    public boolean Ax(int i) {
        return this.jeg.get(i, false).booleanValue();
    }

    public void R(int i, boolean z) {
        this.jeg.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, r rVar) {
        super(frsFragment.getPageContext());
        this.iHV = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSchemeUrl = "";
        this.mSource = null;
        this.jcK = null;
        this.jdR = 0L;
        this.iWC = 1;
        this.jdS = 0;
        this.jdT = 0;
        this.jdV = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.jdW = new SparseArray<>();
        this.fuB = 0L;
        this.eHZ = false;
        this.jeb = -1;
        this.jec = -1;
        this.jed = -1;
        this.jef = null;
        this.jeg = new SparseArray<>();
        this.jei = new n();
        this.jej = new m();
        this.jek = new av() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.av
            public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
                FrsModelController.this.jdV = false;
                if (i == FrsModelController.this.iWC && FrsModelController.this.jdY != null) {
                    FrsModelController.this.jdU = bdVar;
                    FrsModelController.this.b(i, i2, bdVar);
                    ArrayList<q> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.iHB.setThreadList(arrayList2);
                    FrsModelController.this.jdY.a(i, i2, bdVar, arrayList);
                }
            }
        };
        this.inr = 0L;
        this.f5int = 0L;
        this.inu = 0L;
        this.inv = 0L;
        if (rVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.jdH = frsFragment;
        this.jdP = rVar;
        if (this.jdH.getActivity() instanceof FrsActivity) {
            this.jdO = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.jdH.getActivity()).getUniqueId().getId());
        }
        if (this.jdO != null) {
            if (this.jdO.getResponsedMessage() == null) {
                this.jdO.a(this);
            }
            this.jdN = this.jdO.cEd();
        }
        aa(this.jdH);
    }

    private void aa(FrsFragment frsFragment) {
        this.jdX = new ai();
        this.jdX.fsa = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.jdX));
        this.jdX.a(this.jek);
    }

    public void cDp() {
        Looper.myQueue().removeIdleHandler(this.jei);
        Looper.myQueue().removeIdleHandler(this.jej);
        this.jdO.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.iHV = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.jea = bundle.getString("yuelaou_locate");
            this.jdQ = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.jdH.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.iHV)) {
            this.iHV = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.jea)) {
            this.jea = "";
        }
        this.mSource = this.mFrom;
        cDJ();
        this.iHB = new FrsViewData();
        if (this.jdO == null || this.jdN == null || this.jdN.bAP() == null || this.jdN.bAP().isEmpty() || this.jdN.bAP().containsKey(null) || this.jdN.bAP().containsValue(null)) {
            ap(bundle);
        }
        if (this.iHV != null && this.iHV.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    private void ap(Bundle bundle) {
        int i;
        this.jdN = new FrsRequestData();
        this.jdN.setSortType(com.baidu.tieba.frs.f.i.AP(this.jeb));
        if (this.jeb == 5) {
            this.jdN.setIsGood(1);
        } else {
            this.jdN.setIsGood(0);
        }
        this.jdN.go("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.iHV));
        this.jdN.go("client_type", "2");
        this.jdN.setPn(1);
        if (bundle != null) {
            this.jdN.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
            this.jdN.hb(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
        }
        this.jdN.Si("2");
        this.jdN.setObjSource("-2");
        this.jdN.setKw(this.iHV);
        this.jdN.setWithGroup(1);
        this.jdN.setCid(0);
        this.jdN.setScrW(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        this.jdN.setScrH(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        this.jdN.setScrDip(com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        this.jdN.setqType(com.baidu.tbadk.core.util.av.bqC().bqD() ? 2 : 1);
        this.jdN.setSchemeUrl(this.mSchemeUrl);
        this.jdN.setLastId(null);
        this.jdN.setYuelaouLocate(this.jea);
        this.jdN.setLastClickTid(com.baidu.adp.lib.f.b.toLong(aa.bDl(), 0L));
        this.jdN.setStType(this.mFrom);
        this.jdN.Ka(1);
        this.jdN.setNeedCache(true);
        this.jdN.setUpdateType(3);
        com.baidu.tieba.frs.f.i.a(this.jeb, this.jdN);
        this.jdN.setLoadType(1);
        if (bx.eCE.get() && com.baidu.tieba.recapp.q.dzO().dzI() != null) {
            int aZ = com.baidu.tieba.recapp.q.dzO().dzI().aZ(this.iHV, false);
            int ba = com.baidu.tieba.recapp.q.dzO().dzI().ba(this.iHV, false);
            if (this.jdN.getLoadType() == 1) {
                i = aZ + 1;
            } else if (this.jdN.getLoadType() == 2) {
                ba++;
                i = aZ;
            } else {
                i = aZ;
            }
            this.jdN.setRefreshCount(i);
            this.jdN.setLoadCount(ba);
        }
        this.jdO = new FrsNetModel(null, this.jdN);
        this.jdO.setUniqueId(((FrsActivity) this.jdH.getActivity()).getUniqueId());
        this.jdO.a(this);
        this.jdO.loadData();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.iHV);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void cDJ() {
        AccountData currentAccountObj;
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            Ay(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            Ay(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            this.jed = com.baidu.tieba.frs.f.i.Kz("1~" + str + this.iHV);
            Ay(this.jeb);
        }
    }

    public boolean coD() {
        if (this.iWC != 1) {
            As(1);
            return true;
        } else if (this.jdO.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jdN), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 1, false);
            return true;
        }
    }

    public void S(int i, boolean z) {
        if (this.jdN != null) {
            this.jdH.iIj = System.currentTimeMillis();
            if (this.iHB != null && this.iHB.getLikeFeedForumDataList() != null) {
                this.iHB.getLikeFeedForumDataList().clear();
            }
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jdN), FrsRequestData.class);
            frsRequestData.setPn(1);
            this.iWC = c(this.iWC, frsRequestData);
            if (this.iWC == 1) {
                if (!this.jdO.isLoading()) {
                    frsRequestData.setCallFrom(0);
                    b(frsRequestData, i, z ? false : true);
                    return;
                }
                return;
            }
            if (this.jdU == null) {
                this.jdU = new ba();
                this.jdU.pn = 1;
                this.jdU.forumName = this.iHV;
                if (this.iHB != null && this.iHB.getForum() != null) {
                    this.jdU.forumId = this.iHB.getForum().getId();
                }
            }
            As(i);
        }
    }

    public void T(int i, boolean z) {
        this.jdH.iIj = System.currentTimeMillis();
        if (this.iHB != null && this.iHB.getLikeFeedForumDataList() != null) {
            this.iHB.getLikeFeedForumDataList().clear();
        }
        this.iWC = c(this.iWC, this.jdN);
        if (this.iWC == 1) {
            a(this.jdN, i, z ? false : true);
            return;
        }
        if (this.jdU == null) {
            this.jdU = new ba();
            this.jdU.pn = 1;
            this.jdU.forumName = this.iHV;
            if (this.iHB != null && this.iHB.getForum() != null) {
                this.jdU.forumId = this.iHB.getForum().getId();
            }
        }
        As(i);
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.jdH.pw(z);
        this.jdP.ze(i);
        if (this.jdO.cEe() && (this.jdO.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
            a((MvcHttpResponsedMessage) this.jdO.getResponsedMessage(), (MvcHttpMessage) this.jdO.cEf(), this.jdO.cEg());
        } else if (this.jdO.cEe() && (this.jdO.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
            a((MvcSocketResponsedMessage) this.jdO.getResponsedMessage(), (MvcSocketMessage) this.jdO.cEf(), this.jdO.cEg());
        } else {
            int AP = com.baidu.tieba.frs.f.i.AP(this.jed);
            if (!Ax(this.jed) && !this.jdH.iHW && !this.jeh) {
                String f = com.baidu.tieba.tbadkCore.e.dIP().f("1~" + this.iHV, AP, frsRequestData.getIsGood(), this.jdN.getCategoryId());
                this.jef = f;
                new a(this, true, f).execute(new Object[0]);
            }
            this.jeh = false;
        }
        this.jdO.a(this);
    }

    public void At(int i) {
        if (this.iWC != 1) {
            As(4);
        } else if (!this.jdO.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jdN), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 4, false);
        }
    }

    private void b(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.jdH.pw(z);
        this.jdP.ze(i);
        this.jdO.a(frsRequestData);
        frsRequestData.Si(this.jdH.cyv() ? "1" : "2");
        if (this.jee) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.i.AP(this.jec)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.jee = false;
        frsRequestData.setKw(this.iHV);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = com.baidu.tbadk.core.util.av.bqC().bqD() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setSchemeUrl(this.mSchemeUrl);
        frsRequestData.setLastId(this.jcK);
        frsRequestData.setYuelaouLocate(this.jea);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(aa.bDl(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.Ka(cDK());
        if (FrsFragment.iIk != 0) {
            frsRequestData.setCtime((int) FrsFragment.iIk);
        }
        if (FrsFragment.iIl != 0) {
            frsRequestData.setDataSize((int) FrsFragment.iIl);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.hb(this.jdR);
        com.baidu.tieba.frs.f.i.a(this.jeb, frsRequestData);
        int AP = com.baidu.tieba.frs.f.i.AP(this.jed);
        b(i, frsRequestData);
        a(this.iHV, frsRequestData);
        if (!Ax(this.jed) && !this.jdH.iHW && !this.jeh) {
            String f = com.baidu.tieba.tbadkCore.e.dIP().f("1~" + this.iHV, AP, frsRequestData.getIsGood(), this.jdN.getCategoryId());
            this.jef = f;
            new a(this, true, f).execute(new Object[0]);
        }
        cDN();
        this.jeh = false;
    }

    private int cDK() {
        return (this.jdH == null || !(this.jdH.mHeadLineDefaultNavTabId == -1 || this.jdH.mHeadLineDefaultNavTabId == this.iWC)) ? 0 : 1;
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
            this.jdH.fux = mVar.getDataParseTime();
        }
        Ay(com.baidu.tieba.frs.f.i.AQ(mVar.getSortType()));
        R(com.baidu.tieba.frs.f.i.AQ(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.iWC = mVar.getFrsDefaultTabId();
        }
        this.iHB.receiveData(mVar);
        d(this.iHB);
        this.jdM = new ArrayList<>();
        if (frsRequestData != null) {
            this.jdN = frsRequestData;
            this.mPn = this.jdN.getPn();
            this.iHV = this.jdN.getKw();
            this.jdH.setForumName(this.iHV);
            this.jdH.setFrom(this.mFrom);
            this.jdH.setPn(this.mPn);
            this.jdH.setFlag(this.mFlag);
        }
        if (this.iHB.getThreadList() != null) {
            this.jdM.addAll(this.iHB.getThreadList());
        }
        if (this.iWC != 1 && this.isNetFirstLoad) {
            this.jdP.a(7, false, this.jcJ);
        } else {
            this.jdP.a(this.mType, false, this.jcJ);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.jdN)) {
            cEb();
        }
        if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iHB.getForum()));
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() == null || TextUtils.isEmpty(mVar.getForum().getName()) || frsRequestData == null || com.baidu.tieba.recapp.q.dzO().dzI() == null) {
            return true;
        }
        com.baidu.tieba.recapp.q.dzO().dzI().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        if (mvcSocketResponsedMessage != null) {
            this.jei.g(this);
            this.jei.a(mvcSocketResponsedMessage);
            this.jei.a(mvcSocketMessage);
            this.jei.a(mvcNetMessage);
            this.jei.a(this.jdP);
            Looper.myQueue().addIdleHandler(this.jei);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.isc = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.mVx = mvcSocketResponsedMessage.getDownSize();
            this.jcJ = fVar;
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
                this.jdH.a(errorData);
            }
        }
    }

    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.eHZ) {
            this.eHZ = true;
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
            this.jej.g(this);
            this.jej.a(mvcHttpResponsedMessage);
            this.jej.a(mvcHttpMessage);
            this.jej.a(mvcNetMessage);
            this.jej.a(this.jdP);
            Looper.myQueue().addIdleHandler(this.jej);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.isc = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.mVx = mvcHttpResponsedMessage.getDownSize();
            this.jcJ = fVar;
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
                this.jdH.a(errorData);
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
        if (!this.eHZ) {
            this.eHZ = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void cym() {
        if (this.iHB != null && this.iHB.getForum() != null && this.iHB.getForum().getBannerListData() != null) {
            String lastIds = this.iHB.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.jcK = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.bBK().isSmallFlow()) {
            this.fuB = System.currentTimeMillis() - this.jdH.ikF;
            this.jdH.fuA = System.currentTimeMillis() - this.jdH.iIi;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, this.jdH.fuq, this.jdH.createTime, this.jdH.fuA, false, this.jdH.fur, this.jdH.fux, this.fuB);
            this.jdH.createTime = 0L;
            this.jdH.fuq = 0L;
            com.baidu.tieba.frs.f.j.a(this, this.jdH.ikF);
            this.jdH.ikF = -1L;
            iVar.bBH();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.bBK().isSmallFlow()) {
            this.fuB = System.currentTimeMillis() - this.jdH.iIj;
            this.jdH.fuA = System.currentTimeMillis() - this.jdH.iIi;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1000, z, responsedMessage, this.jdH.fuq, this.jdH.createTime, this.jdH.fuA, false, this.jdH.fur, this.jdH.fux, this.fuB);
            if (this.mType == 4) {
                iVar.fuJ = this.fuB;
                iVar.ky(true);
            } else if (this.mType == 3) {
                iVar.fuK = this.fuB;
                iVar.ky(false);
            }
        }
    }

    public FrsRequestData cDL() {
        return this.jdN;
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

    public FrsViewData cDr() {
        return this.iHB;
    }

    public com.baidu.tieba.tbadkCore.f cDM() {
        return this.jcJ;
    }

    private boolean cDN() {
        this.inr = System.currentTimeMillis();
        return this.jdO.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.iHB.receiveData(mVar);
        d(this.iHB);
        this.jdM = new ArrayList<>();
        if (this.iHB.getThreadList() != null) {
            this.jdM.addAll(this.iHB.getThreadList());
        }
        this.jdP.c(mVar);
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

    /* loaded from: classes21.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.m, Void> {
        private String bIX;
        private FrsModelController jeo;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.bIX = null;
            this.bIX = str;
            this.jeo = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.dIP().Sg(this.bIX)) {
                if (!com.baidu.tieba.tbadkCore.e.dIP().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.bIX)) {
                    com.baidu.tieba.tbadkCore.e.dIP().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.dIP().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().bjI(), true) && !responseData.getBookInfo().bjI().equals("0") && responseData.getBookInfo().bjJ() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().bjI(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.jeo != null && mVarArr != null) {
                this.jeo.e(mVarArr.length > 0 ? mVarArr[0] : null);
                this.jeo.R(this.jeo.jeb, true);
            } else if (this.jeo != null && !this.jeo.jdO.cEe()) {
                if (this.jeo.jdO.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                    this.jeo.a((MvcHttpResponsedMessage) this.jeo.jdO.getResponsedMessage(), (MvcHttpMessage) this.jeo.jdO.cEf(), this.jeo.jdO.cEg());
                }
                if (this.jeo.jdO.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                    this.jeo.a((MvcSocketResponsedMessage) this.jeo.jdO.getResponsedMessage(), (MvcSocketMessage) this.jeo.jdO.cEf(), this.jeo.jdO.cEg());
                }
            }
        }
    }

    public long crW() {
        return this.inv;
    }

    public long crX() {
        return this.f5int;
    }

    public long crY() {
        return this.inu;
    }

    public long crZ() {
        return this.inr;
    }

    public boolean isLoading() {
        return this.jdO.isLoading();
    }

    public int cDO() {
        return this.jdT;
    }

    private void cDP() {
        if (this.jdZ == null) {
            this.jdZ = new ArrayList<>();
        }
        if (this.jdZ.size() == 0) {
            this.jdZ.add(new ae());
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(int i, int i2, ba baVar) {
        this.iWC = c(i, null);
        if (baVar == null && (baVar = cA(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.jdY != null) {
                bd bdVar = new bd();
                bdVar.hasMore = false;
                bdVar.pn = 1;
                bdVar.forumName = this.iHV;
                bdVar.iNb = false;
                if (this.iHB != null && this.iHB.getForum() != null) {
                    bdVar.forumId = this.iHB.getForum().getId();
                }
                cDP();
                this.iHB.setThreadList(this.jdZ);
                this.jdY.a(i, i2, bdVar, this.jdZ);
            }
            baVar = new ba();
            baVar.pn = -1;
        }
        if (this.iHB != null && this.iHB.getForum() != null) {
            baVar.forumId = this.iHB.getForum().getId();
        }
        baVar.forumName = this.iHV;
        if (ag.czR().zC(1) != null && this.iWC == 1) {
            this.jdN.setCategoryId(i2);
        }
        this.jdS = i2;
        this.jdU = baVar;
        b(i, i2, baVar);
        As(5);
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(av avVar) {
        this.jdY = avVar;
        this.jdX.a(this.jek);
    }

    private void As(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.jdU != null) {
                    this.jdU.pn++;
                    break;
                }
                break;
            case 2:
                if (this.jdU != null) {
                    ba baVar = this.jdU;
                    baVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.jdU != null) {
                    this.jdU.pn = -1;
                    break;
                }
                break;
        }
        if (this.iWC == 1) {
            if (this.jdT == this.jdS) {
                ArrayList<q> arrayList = new ArrayList<>();
                if (this.jdM != null) {
                    arrayList.addAll(this.jdM);
                }
                this.iHB.setThreadList(arrayList);
                if (this.jdY != null) {
                    this.jdY.a(this.iWC, this.jdS, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.jdT = this.jdS;
            return;
        }
        ar zD = this.jdX.zD(this.iWC);
        if (zD != null) {
            this.jdV = true;
            zD.a(this.iWC, this.jdS, this.jdU);
            return;
        }
        if (this.iHB != null && this.iHB.getThreadList() != null) {
            this.iHB.getThreadList().clear();
        }
        this.jdY.a(this.iWC, this.jdS, null, null);
    }

    public boolean hasMore() {
        if ((this.jdU instanceof bd) && ((bd) this.jdU).errCode == 0) {
            return ((bd) this.jdU).hasMore;
        }
        return true;
    }

    private int cz(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ba baVar) {
        this.jdW.put(cz(i, i2), baVar);
    }

    public ba cA(int i, int i2) {
        return this.jdW.get(cz(i, i2));
    }

    @Override // com.baidu.tieba.frs.ar
    public void init() {
        this.jdX.init();
    }

    @Override // com.baidu.tieba.frs.ar
    public void bVo() {
        this.jdX.destory();
        this.jdX.clear();
    }

    public int cDQ() {
        return this.iWC;
    }

    public boolean cDR() {
        return 1 == this.iWC;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(at atVar) {
        if (atVar != null && !StringUtils.isNull(atVar.getId()) && !y.isEmpty(this.jdM)) {
            if (this.iWC == 1) {
                this.iHB.addMyNewThread(atVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<q> it = this.jdM.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if ((next instanceof bw) && atVar.getId().equals(((bw) next).evQ.getId())) {
                    return;
                }
            }
            this.jdM.add(topThreadSize, atVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.jdM == null || this.jdM.size() <= 0) {
            return 0;
        }
        Iterator<q> it = this.jdM.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                q next = it.next();
                if (!(next instanceof bw)) {
                    i = i2;
                } else if (((bw) next).evQ.blx() != 0) {
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

    public boolean cDS() {
        return this.jdV;
    }

    public void cDT() {
        s sVar = new s();
        if (this.jdT == 0) {
            sVar.zu(this.jeb);
        }
        if (this.iHB.getThreadList() != null) {
            this.iHB.getThreadList().clear();
            this.iHB.getThreadList().add(sVar);
        }
        if (this.jdM != null) {
            this.jdM.clear();
            this.jdM.add(sVar);
        }
    }

    public ArrayList<q> cDU() {
        return this.jdM;
    }

    public void Ay(int i) {
        AccountData currentAccountObj;
        this.jeb = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.f.i.aR("1~" + str + this.iHV, this.jeb);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dLc();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dLd();
        }
    }

    public void Az(int i) {
        this.jec = i;
    }

    public void qo(boolean z) {
        this.jee = z;
    }

    public int cDV() {
        return this.jeb;
    }

    public int cDW() {
        return this.jed;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.i.AP(this.jeb);
    }

    public boolean cDX() {
        return this.jdQ;
    }

    public boolean cDY() {
        return this.jeb == 5;
    }

    public boolean cDZ() {
        return this.jdN != null && this.jdN.getLoadType() == 1;
    }

    public boolean cEa() {
        return this.jeb == 7 || (!this.jdO.cEe() && this.jed == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.jdH.cxF() != null) {
            return this.jdH.cxF().a(this.jeb, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bx.eCE.get() && com.baidu.tieba.recapp.q.dzO().dzI() != null) {
            int aZ = com.baidu.tieba.recapp.q.dzO().dzI().aZ(str, false);
            int ba = com.baidu.tieba.recapp.q.dzO().dzI().ba(str, false);
            if (frsRequestData.getLoadType() == 1) {
                aZ++;
            } else if (frsRequestData.getLoadType() == 2) {
                ba++;
            }
            frsRequestData.setRefreshCount(aZ);
            frsRequestData.setLoadCount(ba);
        }
    }

    public void cEb() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.iHB != null && this.iHB.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.iHB.getForum().getId(), 0L));
        }
        this.jdH.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void Ks(final String str) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dIP().gl(FrsModelController.this.jef, str);
                return null;
            }
        }, null);
    }

    public void Kt(final String str) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dIP().gm(FrsModelController.this.jef, str);
                return null;
            }
        }, null);
    }

    public void Ku(final String str) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dIP().gn(FrsModelController.this.jef, str);
                return null;
            }
        }, null);
    }

    public void qp(boolean z) {
        this.jeh = z;
    }
}
