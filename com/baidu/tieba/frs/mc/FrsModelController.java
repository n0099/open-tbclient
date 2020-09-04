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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.ab;
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
/* loaded from: classes16.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.m>, ar {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long eRY;
    private boolean ego;
    private String hSN;
    private FrsViewData hSt;
    private long hyi;
    private long hyj;
    private long hyk;
    private long hyl;
    private int ihC;
    private com.baidu.tieba.tbadkCore.f inu;
    private String inv;
    private final r ioA;
    private boolean ioB;
    private long ioC;
    private int ioD;
    private int ioE;
    private ba ioF;
    private boolean ioG;
    private SparseArray<ba> ioH;
    private ai ioI;
    private av ioJ;
    private ArrayList<q> ioK;
    private String ioL;
    private int ioM;
    private int ioN;
    private int ioO;
    private boolean ioP;
    private String ioQ;
    private final SparseArray<Boolean> ioR;
    private boolean ioS;
    private n ioT;
    private m ioU;
    private av ioV;
    private final FrsFragment ios;
    private ArrayList<q> iox;
    private FrsRequestData ioy;
    private FrsNetModel ioz;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSchemeUrl;
    private String mSource;
    private int mType;

    public boolean yo(int i) {
        return this.ioR.get(i, false).booleanValue();
    }

    public void P(int i, boolean z) {
        this.ioR.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, r rVar) {
        super(frsFragment.getPageContext());
        this.hSN = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSchemeUrl = "";
        this.mSource = null;
        this.inv = null;
        this.ioC = 0L;
        this.ihC = 1;
        this.ioD = 0;
        this.ioE = 0;
        this.ioG = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.ioH = new SparseArray<>();
        this.eRY = 0L;
        this.ego = false;
        this.ioM = -1;
        this.ioN = -1;
        this.ioO = -1;
        this.ioQ = null;
        this.ioR = new SparseArray<>();
        this.ioT = new n();
        this.ioU = new m();
        this.ioV = new av() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.av
            public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
                FrsModelController.this.ioG = false;
                if (i == FrsModelController.this.ihC && FrsModelController.this.ioJ != null) {
                    FrsModelController.this.ioF = bdVar;
                    FrsModelController.this.b(i, i2, bdVar);
                    ArrayList<q> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.hSt.setThreadList(arrayList2);
                    FrsModelController.this.ioJ.a(i, i2, bdVar, arrayList);
                }
            }
        };
        this.hyi = 0L;
        this.hyj = 0L;
        this.hyk = 0L;
        this.hyl = 0L;
        if (rVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.ios = frsFragment;
        this.ioA = rVar;
        if (this.ios.getActivity() instanceof FrsActivity) {
            this.ioz = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.ios.getActivity()).getUniqueId().getId());
        }
        if (this.ioz != null) {
            if (this.ioz.getResponsedMessage() == null) {
                this.ioz.a(this);
            }
            this.ioy = this.ioz.csf();
        }
        aa(this.ios);
    }

    private void aa(FrsFragment frsFragment) {
        this.ioI = new ai();
        this.ioI.ePz = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.ioI));
        this.ioI.a(this.ioV);
    }

    public void crr() {
        Looper.myQueue().removeIdleHandler(this.ioT);
        Looper.myQueue().removeIdleHandler(this.ioU);
        this.ioz.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.hSN = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.ioL = bundle.getString("yuelaou_locate");
            this.ioB = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.ios.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.hSN)) {
            this.hSN = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.ioL)) {
            this.ioL = "";
        }
        this.mSource = this.mFrom;
        crL();
        this.hSt = new FrsViewData();
        if (this.ioz == null || this.ioy == null || this.ioy.btt() == null || this.ioy.btt().isEmpty() || this.ioy.btt().containsKey(null) || this.ioy.btt().containsValue(null)) {
            ap(bundle);
        }
        if (this.hSN != null && this.hSN.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    private void ap(Bundle bundle) {
        int i;
        this.ioy = new FrsRequestData();
        this.ioy.setSortType(com.baidu.tieba.frs.f.g.yG(this.ioM));
        if (this.ioM == 5) {
            this.ioy.setIsGood(1);
        } else {
            this.ioy.setIsGood(0);
        }
        this.ioy.fQ("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.hSN));
        this.ioy.fQ("client_type", "2");
        this.ioy.setPn(1);
        if (bundle != null) {
            this.ioy.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
            this.ioy.fV(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
        }
        this.ioy.QD("2");
        this.ioy.setObjSource("-2");
        this.ioy.setKw(this.hSN);
        this.ioy.setWithGroup(1);
        this.ioy.setCid(0);
        this.ioy.setScrW(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        this.ioy.setScrH(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        this.ioy.setScrDip(com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        this.ioy.setqType(au.bjr().bjs() ? 2 : 1);
        this.ioy.setSchemeUrl(this.mSchemeUrl);
        this.ioy.setLastId(null);
        this.ioy.setYuelaouLocate(this.ioL);
        this.ioy.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ab.bvJ(), 0L));
        this.ioy.setStType(this.mFrom);
        this.ioy.HK(1);
        this.ioy.setNeedCache(true);
        this.ioy.setUpdateType(3);
        com.baidu.tieba.frs.f.g.a(this.ioM, this.ioy);
        this.ioy.setLoadType(1);
        if (bw.ebH.get() && com.baidu.tieba.recapp.r.dnk().dne() != null) {
            int aT = com.baidu.tieba.recapp.r.dnk().dne().aT(this.hSN, false);
            int aU = com.baidu.tieba.recapp.r.dnk().dne().aU(this.hSN, false);
            if (this.ioy.getLoadType() == 1) {
                i = aT + 1;
            } else if (this.ioy.getLoadType() == 2) {
                aU++;
                i = aT;
            } else {
                i = aT;
            }
            this.ioy.setRefreshCount(i);
            this.ioy.setLoadCount(aU);
        }
        this.ioz = new FrsNetModel(null, this.ioy);
        this.ioz.setUniqueId(((FrsActivity) this.ios.getActivity()).getUniqueId());
        this.ioz.a(this);
        this.ioz.loadData();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.hSN);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void crL() {
        AccountData currentAccountObj;
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            yp(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            yp(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            this.ioO = com.baidu.tieba.frs.f.g.IX("1~" + str + this.hSN);
            yp(this.ioM);
        }
    }

    public boolean ccJ() {
        if (this.ihC != 1) {
            yj(1);
            return true;
        } else if (this.ioz.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.ioy), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 1, false);
            return true;
        }
    }

    public void Q(int i, boolean z) {
        if (this.ioy != null) {
            this.ios.hTb = System.currentTimeMillis();
            if (this.hSt != null && this.hSt.getLikeFeedForumDataList() != null) {
                this.hSt.getLikeFeedForumDataList().clear();
            }
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.ioy), FrsRequestData.class);
            frsRequestData.setPn(1);
            this.ihC = c(this.ihC, frsRequestData);
            if (this.ihC == 1) {
                if (!this.ioz.isLoading()) {
                    frsRequestData.setCallFrom(0);
                    b(frsRequestData, i, z ? false : true);
                    return;
                }
                return;
            }
            if (this.ioF == null) {
                this.ioF = new ba();
                this.ioF.pn = 1;
                this.ioF.forumName = this.hSN;
                if (this.hSt != null && this.hSt.getForum() != null) {
                    this.ioF.forumId = this.hSt.getForum().getId();
                }
            }
            yj(i);
        }
    }

    public void R(int i, boolean z) {
        this.ios.hTb = System.currentTimeMillis();
        if (this.hSt != null && this.hSt.getLikeFeedForumDataList() != null) {
            this.hSt.getLikeFeedForumDataList().clear();
        }
        this.ihC = c(this.ihC, this.ioy);
        if (this.ihC == 1) {
            a(this.ioy, i, z ? false : true);
            return;
        }
        if (this.ioF == null) {
            this.ioF = new ba();
            this.ioF.pn = 1;
            this.ioF.forumName = this.hSN;
            if (this.hSt != null && this.hSt.getForum() != null) {
                this.ioF.forumId = this.hSt.getForum().getId();
            }
        }
        yj(i);
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.ios.oh(z);
        this.ioA.wV(i);
        if (this.ioz.csg() && (this.ioz.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
            a((MvcHttpResponsedMessage) this.ioz.getResponsedMessage(), (MvcHttpMessage) this.ioz.csh(), this.ioz.csi());
        } else if (this.ioz.csg() && (this.ioz.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
            a((MvcSocketResponsedMessage) this.ioz.getResponsedMessage(), (MvcSocketMessage) this.ioz.csh(), this.ioz.csi());
        } else {
            int yG = com.baidu.tieba.frs.f.g.yG(this.ioO);
            if (!yo(this.ioO) && !this.ios.hSO && !this.ioS) {
                String f = com.baidu.tieba.tbadkCore.e.dvK().f("1~" + this.hSN, yG, frsRequestData.getIsGood(), this.ioy.getCategoryId());
                this.ioQ = f;
                new a(this, true, f).execute(new Object[0]);
            }
            this.ioS = false;
        }
        this.ioz.a(this);
    }

    public void yk(int i) {
        if (this.ihC != 1) {
            yj(4);
        } else if (!this.ioz.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.ioy), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 4, false);
        }
    }

    private void b(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.ios.oh(z);
        this.ioA.wV(i);
        this.ioz.a(frsRequestData);
        frsRequestData.QD(this.ios.cmA() ? "1" : "2");
        if (this.ioP) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.yG(this.ioN)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.ioP = false;
        frsRequestData.setKw(this.hSN);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = au.bjr().bjs() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setSchemeUrl(this.mSchemeUrl);
        frsRequestData.setLastId(this.inv);
        frsRequestData.setYuelaouLocate(this.ioL);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ab.bvJ(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.HK(crM());
        if (FrsFragment.hTc != 0) {
            frsRequestData.setCtime((int) FrsFragment.hTc);
        }
        if (FrsFragment.hTd != 0) {
            frsRequestData.setDataSize((int) FrsFragment.hTd);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.fV(this.ioC);
        com.baidu.tieba.frs.f.g.a(this.ioM, frsRequestData);
        int yG = com.baidu.tieba.frs.f.g.yG(this.ioO);
        b(i, frsRequestData);
        a(this.hSN, frsRequestData);
        if (!yo(this.ioO) && !this.ios.hSO && !this.ioS) {
            String f = com.baidu.tieba.tbadkCore.e.dvK().f("1~" + this.hSN, yG, frsRequestData.getIsGood(), this.ioy.getCategoryId());
            this.ioQ = f;
            new a(this, true, f).execute(new Object[0]);
        }
        crP();
        this.ioS = false;
    }

    private int crM() {
        return (this.ios == null || !(this.ios.mHeadLineDefaultNavTabId == -1 || this.ios.mHeadLineDefaultNavTabId == this.ihC)) ? 0 : 1;
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
            this.ios.eRU = mVar.getDataParseTime();
        }
        yp(com.baidu.tieba.frs.f.g.yH(mVar.getSortType()));
        P(com.baidu.tieba.frs.f.g.yH(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.ihC = mVar.getFrsDefaultTabId();
        }
        this.hSt.receiveData(mVar);
        d(this.hSt);
        this.iox = new ArrayList<>();
        if (frsRequestData != null) {
            this.ioy = frsRequestData;
            this.mPn = this.ioy.getPn();
            this.hSN = this.ioy.getKw();
            this.ios.setForumName(this.hSN);
            this.ios.setFrom(this.mFrom);
            this.ios.setPn(this.mPn);
            this.ios.setFlag(this.mFlag);
        }
        if (this.hSt.getThreadList() != null) {
            this.iox.addAll(this.hSt.getThreadList());
        }
        if (this.ihC != 1 && this.isNetFirstLoad) {
            this.ioA.a(7, false, this.inu);
        } else {
            this.ioA.a(this.mType, false, this.inu);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.ioy)) {
            csd();
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() == null || TextUtils.isEmpty(mVar.getForum().getName()) || frsRequestData == null || com.baidu.tieba.recapp.r.dnk().dne() == null) {
            return true;
        }
        com.baidu.tieba.recapp.r.dnk().dne().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        if (mvcSocketResponsedMessage != null) {
            this.ioT.f(this);
            this.ioT.a(mvcSocketResponsedMessage);
            this.ioT.a(mvcSocketMessage);
            this.ioT.a(mvcNetMessage);
            this.ioT.a(this.ioA);
            Looper.myQueue().addIdleHandler(this.ioT);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.hCS = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.mcP = mvcSocketResponsedMessage.getDownSize();
            this.inu = fVar;
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
                this.ios.a(errorData);
            }
        }
    }

    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.ego) {
            this.ego = true;
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
            this.ioU.f(this);
            this.ioU.a(mvcHttpResponsedMessage);
            this.ioU.a(mvcHttpMessage);
            this.ioU.a(mvcNetMessage);
            this.ioU.a(this.ioA);
            Looper.myQueue().addIdleHandler(this.ioU);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.hCS = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.mcP = mvcHttpResponsedMessage.getDownSize();
            this.inu = fVar;
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
                this.ios.a(errorData);
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
        if (!this.ego) {
            this.ego = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void cmr() {
        if (this.hSt != null && this.hSt.getForum() != null && this.hSt.getForum().getBannerListData() != null) {
            String lastIds = this.hSt.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.inv = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.buo().bup()) {
            this.eRY = System.currentTimeMillis() - this.ios.hvt;
            this.ios.eRX = System.currentTimeMillis() - this.ios.hTa;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, this.ios.eRN, this.ios.createTime, this.ios.eRX, false, this.ios.eRO, this.ios.eRU, this.eRY);
            this.ios.createTime = 0L;
            this.ios.eRN = 0L;
            com.baidu.tieba.frs.f.h.a(this, this.ios.hvt);
            this.ios.hvt = -1L;
            iVar.bul();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.buo().bup()) {
            this.eRY = System.currentTimeMillis() - this.ios.hTb;
            this.ios.eRX = System.currentTimeMillis() - this.ios.hTa;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1000, z, responsedMessage, this.ios.eRN, this.ios.createTime, this.ios.eRX, false, this.ios.eRO, this.ios.eRU, this.eRY);
            if (this.mType == 4) {
                iVar.eSg = this.eRY;
                iVar.jC(true);
            } else if (this.mType == 3) {
                iVar.eSh = this.eRY;
                iVar.jC(false);
            }
        }
    }

    public FrsRequestData crN() {
        return this.ioy;
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

    public FrsViewData crt() {
        return this.hSt;
    }

    public com.baidu.tieba.tbadkCore.f crO() {
        return this.inu;
    }

    private boolean crP() {
        this.hyi = System.currentTimeMillis();
        return this.ioz.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.hSt.receiveData(mVar);
        d(this.hSt);
        this.iox = new ArrayList<>();
        if (this.hSt.getThreadList() != null) {
            this.iox.addAll(this.hSt.getThreadList());
        }
        this.ioA.c(mVar);
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
        private String bso;
        private FrsModelController ioZ;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.bso = null;
            this.bso = str;
            this.ioZ = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.dvK().QB(this.bso)) {
                if (!com.baidu.tieba.tbadkCore.e.dvK().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.bso)) {
                    com.baidu.tieba.tbadkCore.e.dvK().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.dvK().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().bcK(), true) && !responseData.getBookInfo().bcK().equals("0") && responseData.getBookInfo().bcL() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().bcK(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.ioZ != null && mVarArr != null) {
                this.ioZ.e(mVarArr.length > 0 ? mVarArr[0] : null);
                this.ioZ.P(this.ioZ.ioM, true);
            }
        }
    }

    public long cfY() {
        return this.hyl;
    }

    public long cfZ() {
        return this.hyj;
    }

    public long cga() {
        return this.hyk;
    }

    public long cgb() {
        return this.hyi;
    }

    public boolean isLoading() {
        return this.ioz.isLoading();
    }

    public int crQ() {
        return this.ioE;
    }

    private void crR() {
        if (this.ioK == null) {
            this.ioK = new ArrayList<>();
        }
        if (this.ioK.size() == 0) {
            this.ioK.add(new ae());
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(int i, int i2, ba baVar) {
        this.ihC = c(i, null);
        if (baVar == null && (baVar = ct(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.ioJ != null) {
                bd bdVar = new bd();
                bdVar.hasMore = false;
                bdVar.pn = 1;
                bdVar.forumName = this.hSN;
                bdVar.hXU = false;
                if (this.hSt != null && this.hSt.getForum() != null) {
                    bdVar.forumId = this.hSt.getForum().getId();
                }
                crR();
                this.hSt.setThreadList(this.ioK);
                this.ioJ.a(i, i2, bdVar, this.ioK);
            }
            baVar = new ba();
            baVar.pn = -1;
        }
        if (this.hSt != null && this.hSt.getForum() != null) {
            baVar.forumId = this.hSt.getForum().getId();
        }
        baVar.forumName = this.hSN;
        if (ag.cnV().xt(1) != null && this.ihC == 1) {
            this.ioy.setCategoryId(i2);
        }
        this.ioD = i2;
        this.ioF = baVar;
        b(i, i2, baVar);
        yj(5);
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(av avVar) {
        this.ioJ = avVar;
        this.ioI.a(this.ioV);
    }

    private void yj(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.ioF != null) {
                    this.ioF.pn++;
                    break;
                }
                break;
            case 2:
                if (this.ioF != null) {
                    ba baVar = this.ioF;
                    baVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.ioF != null) {
                    this.ioF.pn = -1;
                    break;
                }
                break;
        }
        if (this.ihC == 1) {
            if (this.ioE == this.ioD) {
                ArrayList<q> arrayList = new ArrayList<>();
                if (this.iox != null) {
                    arrayList.addAll(this.iox);
                }
                this.hSt.setThreadList(arrayList);
                if (this.ioJ != null) {
                    this.ioJ.a(this.ihC, this.ioD, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.ioE = this.ioD;
            return;
        }
        ar xu = this.ioI.xu(this.ihC);
        if (xu != null) {
            this.ioG = true;
            xu.a(this.ihC, this.ioD, this.ioF);
            return;
        }
        if (this.hSt != null && this.hSt.getThreadList() != null) {
            this.hSt.getThreadList().clear();
        }
        this.ioJ.a(this.ihC, this.ioD, null, null);
    }

    public boolean hasMore() {
        if ((this.ioF instanceof bd) && ((bd) this.ioF).errCode == 0) {
            return ((bd) this.ioF).hasMore;
        }
        return true;
    }

    private int cs(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ba baVar) {
        this.ioH.put(cs(i, i2), baVar);
    }

    public ba ct(int i, int i2) {
        return this.ioH.get(cs(i, i2));
    }

    @Override // com.baidu.tieba.frs.ar
    public void init() {
        this.ioI.init();
    }

    @Override // com.baidu.tieba.frs.ar
    public void bLP() {
        this.ioI.destory();
        this.ioI.clear();
    }

    public int crS() {
        return this.ihC;
    }

    public boolean crT() {
        return 1 == this.ihC;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(as asVar) {
        if (asVar != null && !StringUtils.isNull(asVar.getId()) && !y.isEmpty(this.iox)) {
            if (this.ihC == 1) {
                this.hSt.addMyNewThread(asVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<q> it = this.iox.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if ((next instanceof bv) && asVar.getId().equals(((bv) next).dUW.getId())) {
                    return;
                }
            }
            this.iox.add(topThreadSize, asVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.iox == null || this.iox.size() <= 0) {
            return 0;
        }
        Iterator<q> it = this.iox.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                q next = it.next();
                if (!(next instanceof bv)) {
                    i = i2;
                } else if (((bv) next).dUW.bez() != 0) {
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

    public boolean crU() {
        return this.ioG;
    }

    public void crV() {
        s sVar = new s();
        if (this.ioE == 0) {
            sVar.xl(this.ioM);
        }
        if (this.hSt.getThreadList() != null) {
            this.hSt.getThreadList().clear();
            this.hSt.getThreadList().add(sVar);
        }
        if (this.iox != null) {
            this.iox.clear();
            this.iox.add(sVar);
        }
    }

    public ArrayList<q> crW() {
        return this.iox;
    }

    public void yp(int i) {
        AccountData currentAccountObj;
        this.ioM = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.f.g.aO("1~" + str + this.hSN, this.ioM);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dxO();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dxP();
        }
    }

    public void yq(int i) {
        this.ioN = i;
    }

    public void oZ(boolean z) {
        this.ioP = z;
    }

    public int crX() {
        return this.ioM;
    }

    public int crY() {
        return this.ioO;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.yG(this.ioM);
    }

    public boolean crZ() {
        return this.ioB;
    }

    public boolean csa() {
        return this.ioM == 5;
    }

    public boolean csb() {
        return this.ioy != null && this.ioy.getLoadType() == 1;
    }

    public boolean csc() {
        return this.ioM == 7 || (!this.ioz.csg() && this.ioO == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.ios.clK() != null) {
            return this.ios.clK().a(this.ioM, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bw.ebH.get() && com.baidu.tieba.recapp.r.dnk().dne() != null) {
            int aT = com.baidu.tieba.recapp.r.dnk().dne().aT(str, false);
            int aU = com.baidu.tieba.recapp.r.dnk().dne().aU(str, false);
            if (frsRequestData.getLoadType() == 1) {
                aT++;
            } else if (frsRequestData.getLoadType() == 2) {
                aU++;
            }
            frsRequestData.setRefreshCount(aT);
            frsRequestData.setLoadCount(aU);
        }
    }

    public void csd() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.hSt != null && this.hSt.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.hSt.getForum().getId(), 0L));
        }
        this.ios.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void IQ(final String str) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dvK().fN(FrsModelController.this.ioQ, str);
                return null;
            }
        }, null);
    }

    public void IR(final String str) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dvK().fO(FrsModelController.this.ioQ, str);
                return null;
            }
        }, null);
    }

    public void IS(final String str) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dvK().fP(FrsModelController.this.ioQ, str);
                return null;
            }
        }, null);
    }

    public void pa(boolean z) {
        this.ioS = z;
    }
}
