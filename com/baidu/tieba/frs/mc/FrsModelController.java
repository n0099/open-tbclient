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
    private long eUO;
    private boolean eiD;
    private long hFk;
    private long hFl;
    private long hFm;
    private long hFn;
    private String hZN;
    private FrsViewData hZt;
    private int ioE;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private com.baidu.tieba.tbadkCore.f iuK;
    private String iuL;
    private final FrsFragment ivI;
    private ArrayList<q> ivN;
    private FrsRequestData ivO;
    private FrsNetModel ivP;
    private final r ivQ;
    private boolean ivR;
    private long ivS;
    private int ivT;
    private int ivU;
    private ba ivV;
    private boolean ivW;
    private SparseArray<ba> ivX;
    private ai ivY;
    private av ivZ;
    private ArrayList<q> iwa;
    private String iwb;
    private int iwc;
    private int iwd;
    private int iwe;
    private boolean iwf;
    private String iwg;
    private final SparseArray<Boolean> iwh;
    private boolean iwi;
    private n iwj;
    private m iwk;
    private av iwl;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSchemeUrl;
    private String mSource;
    private int mType;

    public boolean yN(int i) {
        return this.iwh.get(i, false).booleanValue();
    }

    public void P(int i, boolean z) {
        this.iwh.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, r rVar) {
        super(frsFragment.getPageContext());
        this.hZN = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSchemeUrl = "";
        this.mSource = null;
        this.iuL = null;
        this.ivS = 0L;
        this.ioE = 1;
        this.ivT = 0;
        this.ivU = 0;
        this.ivW = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.ivX = new SparseArray<>();
        this.eUO = 0L;
        this.eiD = false;
        this.iwc = -1;
        this.iwd = -1;
        this.iwe = -1;
        this.iwg = null;
        this.iwh = new SparseArray<>();
        this.iwj = new n();
        this.iwk = new m();
        this.iwl = new av() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.av
            public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
                FrsModelController.this.ivW = false;
                if (i == FrsModelController.this.ioE && FrsModelController.this.ivZ != null) {
                    FrsModelController.this.ivV = bdVar;
                    FrsModelController.this.b(i, i2, bdVar);
                    ArrayList<q> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.hZt.setThreadList(arrayList2);
                    FrsModelController.this.ivZ.a(i, i2, bdVar, arrayList);
                }
            }
        };
        this.hFk = 0L;
        this.hFl = 0L;
        this.hFm = 0L;
        this.hFn = 0L;
        if (rVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.ivI = frsFragment;
        this.ivQ = rVar;
        if (this.ivI.getActivity() instanceof FrsActivity) {
            this.ivP = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.ivI.getActivity()).getUniqueId().getId());
        }
        if (this.ivP != null) {
            if (this.ivP.getResponsedMessage() == null) {
                this.ivP.a(this);
            }
            this.ivO = this.ivP.cvu();
        }
        aa(this.ivI);
    }

    private void aa(FrsFragment frsFragment) {
        this.ivY = new ai();
        this.ivY.eSq = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.ivY));
        this.ivY.a(this.iwl);
    }

    public void cuG() {
        Looper.myQueue().removeIdleHandler(this.iwj);
        Looper.myQueue().removeIdleHandler(this.iwk);
        this.ivP.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.hZN = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.iwb = bundle.getString("yuelaou_locate");
            this.ivR = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.ivI.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.hZN)) {
            this.hZN = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.iwb)) {
            this.iwb = "";
        }
        this.mSource = this.mFrom;
        cva();
        this.hZt = new FrsViewData();
        if (this.ivP == null || this.ivO == null || this.ivO.bux() == null || this.ivO.bux().isEmpty() || this.ivO.bux().containsKey(null) || this.ivO.bux().containsValue(null)) {
            ap(bundle);
        }
        if (this.hZN != null && this.hZN.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    private void ap(Bundle bundle) {
        int i;
        this.ivO = new FrsRequestData();
        this.ivO.setSortType(com.baidu.tieba.frs.f.i.zf(this.iwc));
        if (this.iwc == 5) {
            this.ivO.setIsGood(1);
        } else {
            this.ivO.setIsGood(0);
        }
        this.ivO.gc("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.hZN));
        this.ivO.gc("client_type", "2");
        this.ivO.setPn(1);
        if (bundle != null) {
            this.ivO.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
            this.ivO.gj(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
        }
        this.ivO.Rd("2");
        this.ivO.setObjSource("-2");
        this.ivO.setKw(this.hZN);
        this.ivO.setWithGroup(1);
        this.ivO.setCid(0);
        this.ivO.setScrW(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        this.ivO.setScrH(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        this.ivO.setScrDip(com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        this.ivO.setqType(au.bkm().bkn() ? 2 : 1);
        this.ivO.setSchemeUrl(this.mSchemeUrl);
        this.ivO.setLastId(null);
        this.ivO.setYuelaouLocate(this.iwb);
        this.ivO.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ac.bwS(), 0L));
        this.ivO.setStType(this.mFrom);
        this.ivO.In(1);
        this.ivO.setNeedCache(true);
        this.ivO.setUpdateType(3);
        com.baidu.tieba.frs.f.i.a(this.iwc, this.ivO);
        this.ivO.setLoadType(1);
        if (bw.edR.get() && com.baidu.tieba.recapp.r.dqU().dqO() != null) {
            int aT = com.baidu.tieba.recapp.r.dqU().dqO().aT(this.hZN, false);
            int aU = com.baidu.tieba.recapp.r.dqU().dqO().aU(this.hZN, false);
            if (this.ivO.getLoadType() == 1) {
                i = aT + 1;
            } else if (this.ivO.getLoadType() == 2) {
                aU++;
                i = aT;
            } else {
                i = aT;
            }
            this.ivO.setRefreshCount(i);
            this.ivO.setLoadCount(aU);
        }
        this.ivP = new FrsNetModel(null, this.ivO);
        this.ivP.setUniqueId(((FrsActivity) this.ivI.getActivity()).getUniqueId());
        this.ivP.a(this);
        this.ivP.loadData();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.hZN);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void cva() {
        AccountData currentAccountObj;
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            yO(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            yO(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            this.iwe = com.baidu.tieba.frs.f.i.Jv("1~" + str + this.hZN);
            yO(this.iwc);
        }
    }

    public boolean cfY() {
        if (this.ioE != 1) {
            yI(1);
            return true;
        } else if (this.ivP.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.ivO), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 1, false);
            return true;
        }
    }

    public void Q(int i, boolean z) {
        if (this.ivO != null) {
            this.ivI.iab = System.currentTimeMillis();
            if (this.hZt != null && this.hZt.getLikeFeedForumDataList() != null) {
                this.hZt.getLikeFeedForumDataList().clear();
            }
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.ivO), FrsRequestData.class);
            frsRequestData.setPn(1);
            this.ioE = c(this.ioE, frsRequestData);
            if (this.ioE == 1) {
                if (!this.ivP.isLoading()) {
                    frsRequestData.setCallFrom(0);
                    b(frsRequestData, i, z ? false : true);
                    return;
                }
                return;
            }
            if (this.ivV == null) {
                this.ivV = new ba();
                this.ivV.pn = 1;
                this.ivV.forumName = this.hZN;
                if (this.hZt != null && this.hZt.getForum() != null) {
                    this.ivV.forumId = this.hZt.getForum().getId();
                }
            }
            yI(i);
        }
    }

    public void R(int i, boolean z) {
        this.ivI.iab = System.currentTimeMillis();
        if (this.hZt != null && this.hZt.getLikeFeedForumDataList() != null) {
            this.hZt.getLikeFeedForumDataList().clear();
        }
        this.ioE = c(this.ioE, this.ivO);
        if (this.ioE == 1) {
            a(this.ivO, i, z ? false : true);
            return;
        }
        if (this.ivV == null) {
            this.ivV = new ba();
            this.ivV.pn = 1;
            this.ivV.forumName = this.hZN;
            if (this.hZt != null && this.hZt.getForum() != null) {
                this.ivV.forumId = this.hZt.getForum().getId();
            }
        }
        yI(i);
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.ivI.on(z);
        this.ivQ.xu(i);
        if (this.ivP.cvv() && (this.ivP.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
            a((MvcHttpResponsedMessage) this.ivP.getResponsedMessage(), (MvcHttpMessage) this.ivP.cvw(), this.ivP.cvx());
        } else if (this.ivP.cvv() && (this.ivP.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
            a((MvcSocketResponsedMessage) this.ivP.getResponsedMessage(), (MvcSocketMessage) this.ivP.cvw(), this.ivP.cvx());
        } else {
            int zf = com.baidu.tieba.frs.f.i.zf(this.iwe);
            if (!yN(this.iwe) && !this.ivI.hZO && !this.iwi) {
                String f = com.baidu.tieba.tbadkCore.e.dzD().f("1~" + this.hZN, zf, frsRequestData.getIsGood(), this.ivO.getCategoryId());
                this.iwg = f;
                new a(this, true, f).execute(new Object[0]);
            }
            this.iwi = false;
        }
        this.ivP.a(this);
    }

    public void yJ(int i) {
        if (this.ioE != 1) {
            yI(4);
        } else if (!this.ivP.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.ivO), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 4, false);
        }
    }

    private void b(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.ivI.on(z);
        this.ivQ.xu(i);
        this.ivP.a(frsRequestData);
        frsRequestData.Rd(this.ivI.cpM() ? "1" : "2");
        if (this.iwf) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.i.zf(this.iwd)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.iwf = false;
        frsRequestData.setKw(this.hZN);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = au.bkm().bkn() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setSchemeUrl(this.mSchemeUrl);
        frsRequestData.setLastId(this.iuL);
        frsRequestData.setYuelaouLocate(this.iwb);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ac.bwS(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.In(cvb());
        if (FrsFragment.iac != 0) {
            frsRequestData.setCtime((int) FrsFragment.iac);
        }
        if (FrsFragment.iad != 0) {
            frsRequestData.setDataSize((int) FrsFragment.iad);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.gj(this.ivS);
        com.baidu.tieba.frs.f.i.a(this.iwc, frsRequestData);
        int zf = com.baidu.tieba.frs.f.i.zf(this.iwe);
        b(i, frsRequestData);
        a(this.hZN, frsRequestData);
        if (!yN(this.iwe) && !this.ivI.hZO && !this.iwi) {
            String f = com.baidu.tieba.tbadkCore.e.dzD().f("1~" + this.hZN, zf, frsRequestData.getIsGood(), this.ivO.getCategoryId());
            this.iwg = f;
            new a(this, true, f).execute(new Object[0]);
        }
        cve();
        this.iwi = false;
    }

    private int cvb() {
        return (this.ivI == null || !(this.ivI.mHeadLineDefaultNavTabId == -1 || this.ivI.mHeadLineDefaultNavTabId == this.ioE)) ? 0 : 1;
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
            this.ivI.eUK = mVar.getDataParseTime();
        }
        yO(com.baidu.tieba.frs.f.i.zg(mVar.getSortType()));
        P(com.baidu.tieba.frs.f.i.zg(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.ioE = mVar.getFrsDefaultTabId();
        }
        this.hZt.receiveData(mVar);
        d(this.hZt);
        this.ivN = new ArrayList<>();
        if (frsRequestData != null) {
            this.ivO = frsRequestData;
            this.mPn = this.ivO.getPn();
            this.hZN = this.ivO.getKw();
            this.ivI.setForumName(this.hZN);
            this.ivI.setFrom(this.mFrom);
            this.ivI.setPn(this.mPn);
            this.ivI.setFlag(this.mFlag);
        }
        if (this.hZt.getThreadList() != null) {
            this.ivN.addAll(this.hZt.getThreadList());
        }
        if (this.ioE != 1 && this.isNetFirstLoad) {
            this.ivQ.a(7, false, this.iuK);
        } else {
            this.ivQ.a(this.mType, false, this.iuK);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.ivO)) {
            cvs();
        }
        if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.hZt.getForum()));
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() == null || TextUtils.isEmpty(mVar.getForum().getName()) || frsRequestData == null || com.baidu.tieba.recapp.r.dqU().dqO() == null) {
            return true;
        }
        com.baidu.tieba.recapp.r.dqU().dqO().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        if (mvcSocketResponsedMessage != null) {
            this.iwj.g(this);
            this.iwj.a(mvcSocketResponsedMessage);
            this.iwj.a(mvcSocketMessage);
            this.iwj.a(mvcNetMessage);
            this.iwj.a(this.ivQ);
            Looper.myQueue().addIdleHandler(this.iwj);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.hJU = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.mmp = mvcSocketResponsedMessage.getDownSize();
            this.iuK = fVar;
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
                this.ivI.a(errorData);
            }
        }
    }

    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.eiD) {
            this.eiD = true;
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
            this.iwk.g(this);
            this.iwk.a(mvcHttpResponsedMessage);
            this.iwk.a(mvcHttpMessage);
            this.iwk.a(mvcNetMessage);
            this.iwk.a(this.ivQ);
            Looper.myQueue().addIdleHandler(this.iwk);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.hJU = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.mmp = mvcHttpResponsedMessage.getDownSize();
            this.iuK = fVar;
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
                this.ivI.a(errorData);
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
        if (!this.eiD) {
            this.eiD = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void cpD() {
        if (this.hZt != null && this.hZt.getForum() != null && this.hZt.getForum().getBannerListData() != null) {
            String lastIds = this.hZt.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.iuL = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.bvs().bvt()) {
            this.eUO = System.currentTimeMillis() - this.ivI.hCy;
            this.ivI.eUN = System.currentTimeMillis() - this.ivI.iaa;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, this.ivI.eUE, this.ivI.createTime, this.ivI.eUN, false, this.ivI.eUF, this.ivI.eUK, this.eUO);
            this.ivI.createTime = 0L;
            this.ivI.eUE = 0L;
            com.baidu.tieba.frs.f.j.a(this, this.ivI.hCy);
            this.ivI.hCy = -1L;
            iVar.bvp();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.bvs().bvt()) {
            this.eUO = System.currentTimeMillis() - this.ivI.iab;
            this.ivI.eUN = System.currentTimeMillis() - this.ivI.iaa;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1000, z, responsedMessage, this.ivI.eUE, this.ivI.createTime, this.ivI.eUN, false, this.ivI.eUF, this.ivI.eUK, this.eUO);
            if (this.mType == 4) {
                iVar.eUW = this.eUO;
                iVar.jD(true);
            } else if (this.mType == 3) {
                iVar.eUX = this.eUO;
                iVar.jD(false);
            }
        }
    }

    public FrsRequestData cvc() {
        return this.ivO;
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

    public FrsViewData cuI() {
        return this.hZt;
    }

    public com.baidu.tieba.tbadkCore.f cvd() {
        return this.iuK;
    }

    private boolean cve() {
        this.hFk = System.currentTimeMillis();
        return this.ivP.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.hZt.receiveData(mVar);
        d(this.hZt);
        this.ivN = new ArrayList<>();
        if (this.hZt.getThreadList() != null) {
            this.ivN.addAll(this.hZt.getThreadList());
        }
        this.ivQ.c(mVar);
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

    /* loaded from: classes21.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.m, Void> {
        private String bvD;
        private FrsModelController iwp;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.bvD = null;
            this.bvD = str;
            this.iwp = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.dzD().Rb(this.bvD)) {
                if (!com.baidu.tieba.tbadkCore.e.dzD().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.bvD)) {
                    com.baidu.tieba.tbadkCore.e.dzD().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.dzD().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().bdE(), true) && !responseData.getBookInfo().bdE().equals("0") && responseData.getBookInfo().bdF() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().bdE(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.iwp != null && mVarArr != null) {
                this.iwp.e(mVarArr.length > 0 ? mVarArr[0] : null);
                this.iwp.P(this.iwp.iwc, true);
            } else if (this.iwp != null && !this.iwp.ivP.cvv()) {
                if (this.iwp.ivP.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                    this.iwp.a((MvcHttpResponsedMessage) this.iwp.ivP.getResponsedMessage(), (MvcHttpMessage) this.iwp.ivP.cvw(), this.iwp.ivP.cvx());
                }
                if (this.iwp.ivP.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                    this.iwp.a((MvcSocketResponsedMessage) this.iwp.ivP.getResponsedMessage(), (MvcSocketMessage) this.iwp.ivP.cvw(), this.iwp.ivP.cvx());
                }
            }
        }
    }

    public long cjp() {
        return this.hFn;
    }

    public long cjq() {
        return this.hFl;
    }

    public long cjr() {
        return this.hFm;
    }

    public long cjs() {
        return this.hFk;
    }

    public boolean isLoading() {
        return this.ivP.isLoading();
    }

    public int cvf() {
        return this.ivU;
    }

    private void cvg() {
        if (this.iwa == null) {
            this.iwa = new ArrayList<>();
        }
        if (this.iwa.size() == 0) {
            this.iwa.add(new ae());
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(int i, int i2, ba baVar) {
        this.ioE = c(i, null);
        if (baVar == null && (baVar = cw(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.ivZ != null) {
                bd bdVar = new bd();
                bdVar.hasMore = false;
                bdVar.pn = 1;
                bdVar.forumName = this.hZN;
                bdVar.ieY = false;
                if (this.hZt != null && this.hZt.getForum() != null) {
                    bdVar.forumId = this.hZt.getForum().getId();
                }
                cvg();
                this.hZt.setThreadList(this.iwa);
                this.ivZ.a(i, i2, bdVar, this.iwa);
            }
            baVar = new ba();
            baVar.pn = -1;
        }
        if (this.hZt != null && this.hZt.getForum() != null) {
            baVar.forumId = this.hZt.getForum().getId();
        }
        baVar.forumName = this.hZN;
        if (ag.cri().xS(1) != null && this.ioE == 1) {
            this.ivO.setCategoryId(i2);
        }
        this.ivT = i2;
        this.ivV = baVar;
        b(i, i2, baVar);
        yI(5);
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(av avVar) {
        this.ivZ = avVar;
        this.ivY.a(this.iwl);
    }

    private void yI(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.ivV != null) {
                    this.ivV.pn++;
                    break;
                }
                break;
            case 2:
                if (this.ivV != null) {
                    ba baVar = this.ivV;
                    baVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.ivV != null) {
                    this.ivV.pn = -1;
                    break;
                }
                break;
        }
        if (this.ioE == 1) {
            if (this.ivU == this.ivT) {
                ArrayList<q> arrayList = new ArrayList<>();
                if (this.ivN != null) {
                    arrayList.addAll(this.ivN);
                }
                this.hZt.setThreadList(arrayList);
                if (this.ivZ != null) {
                    this.ivZ.a(this.ioE, this.ivT, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.ivU = this.ivT;
            return;
        }
        ar xT = this.ivY.xT(this.ioE);
        if (xT != null) {
            this.ivW = true;
            xT.a(this.ioE, this.ivT, this.ivV);
            return;
        }
        if (this.hZt != null && this.hZt.getThreadList() != null) {
            this.hZt.getThreadList().clear();
        }
        this.ivZ.a(this.ioE, this.ivT, null, null);
    }

    public boolean hasMore() {
        if ((this.ivV instanceof bd) && ((bd) this.ivV).errCode == 0) {
            return ((bd) this.ivV).hasMore;
        }
        return true;
    }

    private int cv(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ba baVar) {
        this.ivX.put(cv(i, i2), baVar);
    }

    public ba cw(int i, int i2) {
        return this.ivX.get(cv(i, i2));
    }

    @Override // com.baidu.tieba.frs.ar
    public void init() {
        this.ivY.init();
    }

    @Override // com.baidu.tieba.frs.ar
    public void bMZ() {
        this.ivY.destory();
        this.ivY.clear();
    }

    public int cvh() {
        return this.ioE;
    }

    public boolean cvi() {
        return 1 == this.ioE;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(as asVar) {
        if (asVar != null && !StringUtils.isNull(asVar.getId()) && !y.isEmpty(this.ivN)) {
            if (this.ioE == 1) {
                this.hZt.addMyNewThread(asVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<q> it = this.ivN.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if ((next instanceof bv) && asVar.getId().equals(((bv) next).dXg.getId())) {
                    return;
                }
            }
            this.ivN.add(topThreadSize, asVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.ivN == null || this.ivN.size() <= 0) {
            return 0;
        }
        Iterator<q> it = this.ivN.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                q next = it.next();
                if (!(next instanceof bv)) {
                    i = i2;
                } else if (((bv) next).dXg.bft() != 0) {
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

    public boolean cvj() {
        return this.ivW;
    }

    public void cvk() {
        s sVar = new s();
        if (this.ivU == 0) {
            sVar.xK(this.iwc);
        }
        if (this.hZt.getThreadList() != null) {
            this.hZt.getThreadList().clear();
            this.hZt.getThreadList().add(sVar);
        }
        if (this.ivN != null) {
            this.ivN.clear();
            this.ivN.add(sVar);
        }
    }

    public ArrayList<q> cvl() {
        return this.ivN;
    }

    public void yO(int i) {
        AccountData currentAccountObj;
        this.iwc = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.f.i.aO("1~" + str + this.hZN, this.iwc);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dBH();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dBI();
        }
    }

    public void yP(int i) {
        this.iwd = i;
    }

    public void pf(boolean z) {
        this.iwf = z;
    }

    public int cvm() {
        return this.iwc;
    }

    public int cvn() {
        return this.iwe;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.i.zf(this.iwc);
    }

    public boolean cvo() {
        return this.ivR;
    }

    public boolean cvp() {
        return this.iwc == 5;
    }

    public boolean cvq() {
        return this.ivO != null && this.ivO.getLoadType() == 1;
    }

    public boolean cvr() {
        return this.iwc == 7 || (!this.ivP.cvv() && this.iwe == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.ivI.coW() != null) {
            return this.ivI.coW().a(this.iwc, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bw.edR.get() && com.baidu.tieba.recapp.r.dqU().dqO() != null) {
            int aT = com.baidu.tieba.recapp.r.dqU().dqO().aT(str, false);
            int aU = com.baidu.tieba.recapp.r.dqU().dqO().aU(str, false);
            if (frsRequestData.getLoadType() == 1) {
                aT++;
            } else if (frsRequestData.getLoadType() == 2) {
                aU++;
            }
            frsRequestData.setRefreshCount(aT);
            frsRequestData.setLoadCount(aU);
        }
    }

    public void cvs() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.hZt != null && this.hZt.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.hZt.getForum().getId(), 0L));
        }
        this.ivI.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void Jo(final String str) {
        com.baidu.tbadk.util.ae.a(new ad<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dzD().fZ(FrsModelController.this.iwg, str);
                return null;
            }
        }, null);
    }

    public void Jp(final String str) {
        com.baidu.tbadk.util.ae.a(new ad<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dzD().ga(FrsModelController.this.iwg, str);
                return null;
            }
        }, null);
    }

    public void Jq(final String str) {
        com.baidu.tbadk.util.ae.a(new ad<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dzD().gb(FrsModelController.this.iwg, str);
                return null;
            }
        }, null);
    }

    public void pg(boolean z) {
        this.iwi = z;
    }
}
