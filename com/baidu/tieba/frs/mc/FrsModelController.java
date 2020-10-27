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
/* loaded from: classes22.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.m>, ar {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private boolean eDk;
    private long fpx;
    private FrsViewData iAQ;
    private String iBk;
    private int iPT;
    private com.baidu.tieba.tbadkCore.f iVZ;
    private final FrsFragment iWX;
    private String iWa;
    private av iXA;
    private ArrayList<q> iXc;
    private FrsRequestData iXd;
    private FrsNetModel iXe;
    private final r iXf;
    private boolean iXg;
    private long iXh;
    private int iXi;
    private int iXj;
    private ba iXk;
    private boolean iXl;
    private SparseArray<ba> iXm;
    private ai iXn;
    private av iXo;
    private ArrayList<q> iXp;
    private String iXq;
    private int iXr;
    private int iXs;
    private int iXt;
    private boolean iXu;
    private String iXv;
    private final SparseArray<Boolean> iXw;
    private boolean iXx;
    private n iXy;
    private m iXz;
    private long igF;
    private long igG;
    private long igH;
    private long igI;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSchemeUrl;
    private String mSource;
    private int mType;

    public boolean zM(int i) {
        return this.iXw.get(i, false).booleanValue();
    }

    public void R(int i, boolean z) {
        this.iXw.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, r rVar) {
        super(frsFragment.getPageContext());
        this.iBk = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSchemeUrl = "";
        this.mSource = null;
        this.iWa = null;
        this.iXh = 0L;
        this.iPT = 1;
        this.iXi = 0;
        this.iXj = 0;
        this.iXl = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.iXm = new SparseArray<>();
        this.fpx = 0L;
        this.eDk = false;
        this.iXr = -1;
        this.iXs = -1;
        this.iXt = -1;
        this.iXv = null;
        this.iXw = new SparseArray<>();
        this.iXy = new n();
        this.iXz = new m();
        this.iXA = new av() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.av
            public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
                FrsModelController.this.iXl = false;
                if (i == FrsModelController.this.iPT && FrsModelController.this.iXo != null) {
                    FrsModelController.this.iXk = bdVar;
                    FrsModelController.this.b(i, i2, bdVar);
                    ArrayList<q> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.iAQ.setThreadList(arrayList2);
                    FrsModelController.this.iXo.a(i, i2, bdVar, arrayList);
                }
            }
        };
        this.igF = 0L;
        this.igG = 0L;
        this.igH = 0L;
        this.igI = 0L;
        if (rVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.iWX = frsFragment;
        this.iXf = rVar;
        if (this.iWX.getActivity() instanceof FrsActivity) {
            this.iXe = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.iWX.getActivity()).getUniqueId().getId());
        }
        if (this.iXe != null) {
            if (this.iXe.getResponsedMessage() == null) {
                this.iXe.a(this);
            }
            this.iXd = this.iXe.cBY();
        }
        aa(this.iWX);
    }

    private void aa(FrsFragment frsFragment) {
        this.iXn = new ai();
        this.iXn.fmX = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.iXn));
        this.iXn.a(this.iXA);
    }

    public void cBk() {
        Looper.myQueue().removeIdleHandler(this.iXy);
        Looper.myQueue().removeIdleHandler(this.iXz);
        this.iXe.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.iBk = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.iXq = bundle.getString("yuelaou_locate");
            this.iXg = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.iWX.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.iBk)) {
            this.iBk = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.iXq)) {
            this.iXq = "";
        }
        this.mSource = this.mFrom;
        cBE();
        this.iAQ = new FrsViewData();
        if (this.iXe == null || this.iXd == null || this.iXd.bza() == null || this.iXd.bza().isEmpty() || this.iXd.bza().containsKey(null) || this.iXd.bza().containsValue(null)) {
            ap(bundle);
        }
        if (this.iBk != null && this.iBk.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    private void ap(Bundle bundle) {
        int i;
        this.iXd = new FrsRequestData();
        this.iXd.setSortType(com.baidu.tieba.frs.f.i.Ae(this.iXr));
        if (this.iXr == 5) {
            this.iXd.setIsGood(1);
        } else {
            this.iXd.setIsGood(0);
        }
        this.iXd.go("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.iBk));
        this.iXd.go("client_type", "2");
        this.iXd.setPn(1);
        if (bundle != null) {
            this.iXd.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
            this.iXd.gC(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
        }
        this.iXd.Sq("2");
        this.iXd.setObjSource("-2");
        this.iXd.setKw(this.iBk);
        this.iXd.setWithGroup(1);
        this.iXd.setCid(0);
        this.iXd.setScrW(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        this.iXd.setScrH(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        this.iXd.setScrDip(com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        this.iXd.setqType(au.boO().boP() ? 2 : 1);
        this.iXd.setSchemeUrl(this.mSchemeUrl);
        this.iXd.setLastId(null);
        this.iXd.setYuelaouLocate(this.iXq);
        this.iXd.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ac.bBv(), 0L));
        this.iXd.setStType(this.mFrom);
        this.iXd.Jl(1);
        this.iXd.setNeedCache(true);
        this.iXd.setUpdateType(3);
        com.baidu.tieba.frs.f.i.a(this.iXr, this.iXd);
        this.iXd.setLoadType(1);
        if (bw.eyx.get() && com.baidu.tieba.recapp.r.dxM().dxG() != null) {
            int aZ = com.baidu.tieba.recapp.r.dxM().dxG().aZ(this.iBk, false);
            int ba = com.baidu.tieba.recapp.r.dxM().dxG().ba(this.iBk, false);
            if (this.iXd.getLoadType() == 1) {
                i = aZ + 1;
            } else if (this.iXd.getLoadType() == 2) {
                ba++;
                i = aZ;
            } else {
                i = aZ;
            }
            this.iXd.setRefreshCount(i);
            this.iXd.setLoadCount(ba);
        }
        this.iXe = new FrsNetModel(null, this.iXd);
        this.iXe.setUniqueId(((FrsActivity) this.iWX.getActivity()).getUniqueId());
        this.iXe.a(this);
        this.iXe.loadData();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.iBk);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void cBE() {
        AccountData currentAccountObj;
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            zN(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            zN(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            this.iXt = com.baidu.tieba.frs.f.i.KH("1~" + str + this.iBk);
            zN(this.iXr);
        }
    }

    public boolean cmB() {
        if (this.iPT != 1) {
            zH(1);
            return true;
        } else if (this.iXe.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.iXd), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 1, false);
            return true;
        }
    }

    public void S(int i, boolean z) {
        if (this.iXd != null) {
            this.iWX.iBy = System.currentTimeMillis();
            if (this.iAQ != null && this.iAQ.getLikeFeedForumDataList() != null) {
                this.iAQ.getLikeFeedForumDataList().clear();
            }
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.iXd), FrsRequestData.class);
            frsRequestData.setPn(1);
            this.iPT = c(this.iPT, frsRequestData);
            if (this.iPT == 1) {
                if (!this.iXe.isLoading()) {
                    frsRequestData.setCallFrom(0);
                    b(frsRequestData, i, z ? false : true);
                    return;
                }
                return;
            }
            if (this.iXk == null) {
                this.iXk = new ba();
                this.iXk.pn = 1;
                this.iXk.forumName = this.iBk;
                if (this.iAQ != null && this.iAQ.getForum() != null) {
                    this.iXk.forumId = this.iAQ.getForum().getId();
                }
            }
            zH(i);
        }
    }

    public void T(int i, boolean z) {
        this.iWX.iBy = System.currentTimeMillis();
        if (this.iAQ != null && this.iAQ.getLikeFeedForumDataList() != null) {
            this.iAQ.getLikeFeedForumDataList().clear();
        }
        this.iPT = c(this.iPT, this.iXd);
        if (this.iPT == 1) {
            a(this.iXd, i, z ? false : true);
            return;
        }
        if (this.iXk == null) {
            this.iXk = new ba();
            this.iXk.pn = 1;
            this.iXk.forumName = this.iBk;
            if (this.iAQ != null && this.iAQ.getForum() != null) {
                this.iXk.forumId = this.iAQ.getForum().getId();
            }
        }
        zH(i);
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.iWX.pk(z);
        this.iXf.yt(i);
        if (this.iXe.cBZ() && (this.iXe.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
            a((MvcHttpResponsedMessage) this.iXe.getResponsedMessage(), (MvcHttpMessage) this.iXe.cCa(), this.iXe.cCb());
        } else if (this.iXe.cBZ() && (this.iXe.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
            a((MvcSocketResponsedMessage) this.iXe.getResponsedMessage(), (MvcSocketMessage) this.iXe.cCa(), this.iXe.cCb());
        } else {
            int Ae = com.baidu.tieba.frs.f.i.Ae(this.iXt);
            if (!zM(this.iXt) && !this.iWX.iBl && !this.iXx) {
                String f = com.baidu.tieba.tbadkCore.e.dGw().f("1~" + this.iBk, Ae, frsRequestData.getIsGood(), this.iXd.getCategoryId());
                this.iXv = f;
                new a(this, true, f).execute(new Object[0]);
            }
            this.iXx = false;
        }
        this.iXe.a(this);
    }

    public void zI(int i) {
        if (this.iPT != 1) {
            zH(4);
        } else if (!this.iXe.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.iXd), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 4, false);
        }
    }

    private void b(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.iWX.pk(z);
        this.iXf.yt(i);
        this.iXe.a(frsRequestData);
        frsRequestData.Sq(this.iWX.cwr() ? "1" : "2");
        if (this.iXu) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.i.Ae(this.iXs)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.iXu = false;
        frsRequestData.setKw(this.iBk);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = au.boO().boP() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setSchemeUrl(this.mSchemeUrl);
        frsRequestData.setLastId(this.iWa);
        frsRequestData.setYuelaouLocate(this.iXq);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ac.bBv(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.Jl(cBF());
        if (FrsFragment.iBz != 0) {
            frsRequestData.setCtime((int) FrsFragment.iBz);
        }
        if (FrsFragment.iBA != 0) {
            frsRequestData.setDataSize((int) FrsFragment.iBA);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.gC(this.iXh);
        com.baidu.tieba.frs.f.i.a(this.iXr, frsRequestData);
        int Ae = com.baidu.tieba.frs.f.i.Ae(this.iXt);
        b(i, frsRequestData);
        a(this.iBk, frsRequestData);
        if (!zM(this.iXt) && !this.iWX.iBl && !this.iXx) {
            String f = com.baidu.tieba.tbadkCore.e.dGw().f("1~" + this.iBk, Ae, frsRequestData.getIsGood(), this.iXd.getCategoryId());
            this.iXv = f;
            new a(this, true, f).execute(new Object[0]);
        }
        cBI();
        this.iXx = false;
    }

    private int cBF() {
        return (this.iWX == null || !(this.iWX.mHeadLineDefaultNavTabId == -1 || this.iWX.mHeadLineDefaultNavTabId == this.iPT)) ? 0 : 1;
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
            this.iWX.fpt = mVar.getDataParseTime();
        }
        zN(com.baidu.tieba.frs.f.i.Af(mVar.getSortType()));
        R(com.baidu.tieba.frs.f.i.Af(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.iPT = mVar.getFrsDefaultTabId();
        }
        this.iAQ.receiveData(mVar);
        d(this.iAQ);
        this.iXc = new ArrayList<>();
        if (frsRequestData != null) {
            this.iXd = frsRequestData;
            this.mPn = this.iXd.getPn();
            this.iBk = this.iXd.getKw();
            this.iWX.setForumName(this.iBk);
            this.iWX.setFrom(this.mFrom);
            this.iWX.setPn(this.mPn);
            this.iWX.setFlag(this.mFlag);
        }
        if (this.iAQ.getThreadList() != null) {
            this.iXc.addAll(this.iAQ.getThreadList());
        }
        if (this.iPT != 1 && this.isNetFirstLoad) {
            this.iXf.a(7, false, this.iVZ);
        } else {
            this.iXf.a(this.mType, false, this.iVZ);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.iXd)) {
            cBW();
        }
        if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iAQ.getForum()));
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() == null || TextUtils.isEmpty(mVar.getForum().getName()) || frsRequestData == null || com.baidu.tieba.recapp.r.dxM().dxG() == null) {
            return true;
        }
        com.baidu.tieba.recapp.r.dxM().dxG().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        if (mvcSocketResponsedMessage != null) {
            this.iXy.g(this);
            this.iXy.a(mvcSocketResponsedMessage);
            this.iXy.a(mvcSocketMessage);
            this.iXy.a(mvcNetMessage);
            this.iXy.a(this.iXf);
            Looper.myQueue().addIdleHandler(this.iXy);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.ilp = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.mOA = mvcSocketResponsedMessage.getDownSize();
            this.iVZ = fVar;
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
                this.iWX.a(errorData);
            }
        }
    }

    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.eDk) {
            this.eDk = true;
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
            this.iXz.g(this);
            this.iXz.a(mvcHttpResponsedMessage);
            this.iXz.a(mvcHttpMessage);
            this.iXz.a(mvcNetMessage);
            this.iXz.a(this.iXf);
            Looper.myQueue().addIdleHandler(this.iXz);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.ilp = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.mOA = mvcHttpResponsedMessage.getDownSize();
            this.iVZ = fVar;
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
                this.iWX.a(errorData);
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
        if (!this.eDk) {
            this.eDk = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void cwi() {
        if (this.iAQ != null && this.iAQ.getForum() != null && this.iAQ.getForum().getBannerListData() != null) {
            String lastIds = this.iAQ.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.iWa = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.bzV().bzW()) {
            this.fpx = System.currentTimeMillis() - this.iWX.idU;
            this.iWX.fpw = System.currentTimeMillis() - this.iWX.iBx;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, this.iWX.fpl, this.iWX.createTime, this.iWX.fpw, false, this.iWX.fpm, this.iWX.fpt, this.fpx);
            this.iWX.createTime = 0L;
            this.iWX.fpl = 0L;
            com.baidu.tieba.frs.f.j.a(this, this.iWX.idU);
            this.iWX.idU = -1L;
            iVar.bzS();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.bzV().bzW()) {
            this.fpx = System.currentTimeMillis() - this.iWX.iBy;
            this.iWX.fpw = System.currentTimeMillis() - this.iWX.iBx;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1000, z, responsedMessage, this.iWX.fpl, this.iWX.createTime, this.iWX.fpw, false, this.iWX.fpm, this.iWX.fpt, this.fpx);
            if (this.mType == 4) {
                iVar.fpF = this.fpx;
                iVar.ko(true);
            } else if (this.mType == 3) {
                iVar.fpG = this.fpx;
                iVar.ko(false);
            }
        }
    }

    public FrsRequestData cBG() {
        return this.iXd;
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

    public FrsViewData cBm() {
        return this.iAQ;
    }

    public com.baidu.tieba.tbadkCore.f cBH() {
        return this.iVZ;
    }

    private boolean cBI() {
        this.igF = System.currentTimeMillis();
        return this.iXe.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.iAQ.receiveData(mVar);
        d(this.iAQ);
        this.iXc = new ArrayList<>();
        if (this.iAQ.getThreadList() != null) {
            this.iXc.addAll(this.iAQ.getThreadList());
        }
        this.iXf.c(mVar);
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

    /* loaded from: classes22.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.m, Void> {
        private String bFc;
        private FrsModelController iXE;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.bFc = null;
            this.bFc = str;
            this.iXE = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.dGw().So(this.bFc)) {
                if (!com.baidu.tieba.tbadkCore.e.dGw().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.bFc)) {
                    com.baidu.tieba.tbadkCore.e.dGw().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.dGw().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().big(), true) && !responseData.getBookInfo().big().equals("0") && responseData.getBookInfo().bih() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().big(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.iXE != null && mVarArr != null) {
                this.iXE.e(mVarArr.length > 0 ? mVarArr[0] : null);
                this.iXE.R(this.iXE.iXr, true);
            } else if (this.iXE != null && !this.iXE.iXe.cBZ()) {
                if (this.iXE.iXe.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                    this.iXE.a((MvcHttpResponsedMessage) this.iXE.iXe.getResponsedMessage(), (MvcHttpMessage) this.iXE.iXe.cCa(), this.iXE.iXe.cCb());
                }
                if (this.iXE.iXe.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                    this.iXE.a((MvcSocketResponsedMessage) this.iXE.iXe.getResponsedMessage(), (MvcSocketMessage) this.iXE.iXe.cCa(), this.iXE.iXe.cCb());
                }
            }
        }
    }

    public long cpS() {
        return this.igI;
    }

    public long cpT() {
        return this.igG;
    }

    public long cpU() {
        return this.igH;
    }

    public long cpV() {
        return this.igF;
    }

    public boolean isLoading() {
        return this.iXe.isLoading();
    }

    public int cBJ() {
        return this.iXj;
    }

    private void cBK() {
        if (this.iXp == null) {
            this.iXp = new ArrayList<>();
        }
        if (this.iXp.size() == 0) {
            this.iXp.add(new ae());
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(int i, int i2, ba baVar) {
        this.iPT = c(i, null);
        if (baVar == null && (baVar = cy(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.iXo != null) {
                bd bdVar = new bd();
                bdVar.hasMore = false;
                bdVar.pn = 1;
                bdVar.forumName = this.iBk;
                bdVar.iGr = false;
                if (this.iAQ != null && this.iAQ.getForum() != null) {
                    bdVar.forumId = this.iAQ.getForum().getId();
                }
                cBK();
                this.iAQ.setThreadList(this.iXp);
                this.iXo.a(i, i2, bdVar, this.iXp);
            }
            baVar = new ba();
            baVar.pn = -1;
        }
        if (this.iAQ != null && this.iAQ.getForum() != null) {
            baVar.forumId = this.iAQ.getForum().getId();
        }
        baVar.forumName = this.iBk;
        if (ag.cxN().yR(1) != null && this.iPT == 1) {
            this.iXd.setCategoryId(i2);
        }
        this.iXi = i2;
        this.iXk = baVar;
        b(i, i2, baVar);
        zH(5);
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(av avVar) {
        this.iXo = avVar;
        this.iXn.a(this.iXA);
    }

    private void zH(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.iXk != null) {
                    this.iXk.pn++;
                    break;
                }
                break;
            case 2:
                if (this.iXk != null) {
                    ba baVar = this.iXk;
                    baVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.iXk != null) {
                    this.iXk.pn = -1;
                    break;
                }
                break;
        }
        if (this.iPT == 1) {
            if (this.iXj == this.iXi) {
                ArrayList<q> arrayList = new ArrayList<>();
                if (this.iXc != null) {
                    arrayList.addAll(this.iXc);
                }
                this.iAQ.setThreadList(arrayList);
                if (this.iXo != null) {
                    this.iXo.a(this.iPT, this.iXi, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.iXj = this.iXi;
            return;
        }
        ar yS = this.iXn.yS(this.iPT);
        if (yS != null) {
            this.iXl = true;
            yS.a(this.iPT, this.iXi, this.iXk);
            return;
        }
        if (this.iAQ != null && this.iAQ.getThreadList() != null) {
            this.iAQ.getThreadList().clear();
        }
        this.iXo.a(this.iPT, this.iXi, null, null);
    }

    public boolean hasMore() {
        if ((this.iXk instanceof bd) && ((bd) this.iXk).errCode == 0) {
            return ((bd) this.iXk).hasMore;
        }
        return true;
    }

    private int cx(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ba baVar) {
        this.iXm.put(cx(i, i2), baVar);
    }

    public ba cy(int i, int i2) {
        return this.iXm.get(cx(i, i2));
    }

    @Override // com.baidu.tieba.frs.ar
    public void init() {
        this.iXn.init();
    }

    @Override // com.baidu.tieba.frs.ar
    public void bTn() {
        this.iXn.destory();
        this.iXn.clear();
    }

    public int cBL() {
        return this.iPT;
    }

    public boolean cBM() {
        return 1 == this.iPT;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(as asVar) {
        if (asVar != null && !StringUtils.isNull(asVar.getId()) && !y.isEmpty(this.iXc)) {
            if (this.iPT == 1) {
                this.iAQ.addMyNewThread(asVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<q> it = this.iXc.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if ((next instanceof bv) && asVar.getId().equals(((bv) next).erH.getId())) {
                    return;
                }
            }
            this.iXc.add(topThreadSize, asVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.iXc == null || this.iXc.size() <= 0) {
            return 0;
        }
        Iterator<q> it = this.iXc.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                q next = it.next();
                if (!(next instanceof bv)) {
                    i = i2;
                } else if (((bv) next).erH.bjV() != 0) {
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

    public boolean cBN() {
        return this.iXl;
    }

    public void cBO() {
        s sVar = new s();
        if (this.iXj == 0) {
            sVar.yJ(this.iXr);
        }
        if (this.iAQ.getThreadList() != null) {
            this.iAQ.getThreadList().clear();
            this.iAQ.getThreadList().add(sVar);
        }
        if (this.iXc != null) {
            this.iXc.clear();
            this.iXc.add(sVar);
        }
    }

    public ArrayList<q> cBP() {
        return this.iXc;
    }

    public void zN(int i) {
        AccountData currentAccountObj;
        this.iXr = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.f.i.aQ("1~" + str + this.iBk, this.iXr);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dIB();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dIC();
        }
    }

    public void zO(int i) {
        this.iXs = i;
    }

    public void qc(boolean z) {
        this.iXu = z;
    }

    public int cBQ() {
        return this.iXr;
    }

    public int cBR() {
        return this.iXt;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.i.Ae(this.iXr);
    }

    public boolean cBS() {
        return this.iXg;
    }

    public boolean cBT() {
        return this.iXr == 5;
    }

    public boolean cBU() {
        return this.iXd != null && this.iXd.getLoadType() == 1;
    }

    public boolean cBV() {
        return this.iXr == 7 || (!this.iXe.cBZ() && this.iXt == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.iWX.cvB() != null) {
            return this.iWX.cvB().a(this.iXr, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bw.eyx.get() && com.baidu.tieba.recapp.r.dxM().dxG() != null) {
            int aZ = com.baidu.tieba.recapp.r.dxM().dxG().aZ(str, false);
            int ba = com.baidu.tieba.recapp.r.dxM().dxG().ba(str, false);
            if (frsRequestData.getLoadType() == 1) {
                aZ++;
            } else if (frsRequestData.getLoadType() == 2) {
                ba++;
            }
            frsRequestData.setRefreshCount(aZ);
            frsRequestData.setLoadCount(ba);
        }
    }

    public void cBW() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.iAQ != null && this.iAQ.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.iAQ.getForum().getId(), 0L));
        }
        this.iWX.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void KA(final String str) {
        com.baidu.tbadk.util.ae.a(new ad<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dGw().gl(FrsModelController.this.iXv, str);
                return null;
            }
        }, null);
    }

    public void KB(final String str) {
        com.baidu.tbadk.util.ae.a(new ad<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dGw().gm(FrsModelController.this.iXv, str);
                return null;
            }
        }, null);
    }

    public void KC(final String str) {
        com.baidu.tbadk.util.ae.a(new ad<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dGw().gn(FrsModelController.this.iXv, str);
                return null;
            }
        }, null);
    }

    public void qd(boolean z) {
        this.iXx = z;
    }
}
