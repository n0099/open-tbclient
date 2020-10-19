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
    private boolean euL;
    private long fgX;
    private long hUf;
    private long hUg;
    private long hUh;
    private long hUi;
    private int iDx;
    private com.baidu.tieba.tbadkCore.f iJD;
    private String iJE;
    private final FrsFragment iKB;
    private ArrayList<q> iKG;
    private FrsRequestData iKH;
    private FrsNetModel iKI;
    private final r iKJ;
    private boolean iKK;
    private long iKL;
    private int iKM;
    private int iKN;
    private ba iKO;
    private boolean iKP;
    private SparseArray<ba> iKQ;
    private ai iKR;
    private av iKS;
    private ArrayList<q> iKT;
    private String iKU;
    private int iKV;
    private int iKW;
    private int iKX;
    private boolean iKY;
    private String iKZ;
    private final SparseArray<Boolean> iLa;
    private boolean iLb;
    private n iLc;
    private m iLd;
    private av iLe;
    private String ioO;
    private FrsViewData iou;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSchemeUrl;
    private String mSource;
    private int mType;

    public boolean zt(int i) {
        return this.iLa.get(i, false).booleanValue();
    }

    public void R(int i, boolean z) {
        this.iLa.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, r rVar) {
        super(frsFragment.getPageContext());
        this.ioO = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSchemeUrl = "";
        this.mSource = null;
        this.iJE = null;
        this.iKL = 0L;
        this.iDx = 1;
        this.iKM = 0;
        this.iKN = 0;
        this.iKP = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.iKQ = new SparseArray<>();
        this.fgX = 0L;
        this.euL = false;
        this.iKV = -1;
        this.iKW = -1;
        this.iKX = -1;
        this.iKZ = null;
        this.iLa = new SparseArray<>();
        this.iLc = new n();
        this.iLd = new m();
        this.iLe = new av() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.av
            public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
                FrsModelController.this.iKP = false;
                if (i == FrsModelController.this.iDx && FrsModelController.this.iKS != null) {
                    FrsModelController.this.iKO = bdVar;
                    FrsModelController.this.b(i, i2, bdVar);
                    ArrayList<q> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.iou.setThreadList(arrayList2);
                    FrsModelController.this.iKS.a(i, i2, bdVar, arrayList);
                }
            }
        };
        this.hUf = 0L;
        this.hUg = 0L;
        this.hUh = 0L;
        this.hUi = 0L;
        if (rVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.iKB = frsFragment;
        this.iKJ = rVar;
        if (this.iKB.getActivity() instanceof FrsActivity) {
            this.iKI = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.iKB.getActivity()).getUniqueId().getId());
        }
        if (this.iKI != null) {
            if (this.iKI.getResponsedMessage() == null) {
                this.iKI.a(this);
            }
            this.iKH = this.iKI.cyR();
        }
        aa(this.iKB);
    }

    private void aa(FrsFragment frsFragment) {
        this.iKR = new ai();
        this.iKR.fey = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.iKR));
        this.iKR.a(this.iLe);
    }

    public void cyd() {
        Looper.myQueue().removeIdleHandler(this.iLc);
        Looper.myQueue().removeIdleHandler(this.iLd);
        this.iKI.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.ioO = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.iKU = bundle.getString("yuelaou_locate");
            this.iKK = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.iKB.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.ioO)) {
            this.ioO = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.iKU)) {
            this.iKU = "";
        }
        this.mSource = this.mFrom;
        cyx();
        this.iou = new FrsViewData();
        if (this.iKI == null || this.iKH == null || this.iKH.bxh() == null || this.iKH.bxh().isEmpty() || this.iKH.bxh().containsKey(null) || this.iKH.bxh().containsValue(null)) {
            ap(bundle);
        }
        if (this.ioO != null && this.ioO.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    private void ap(Bundle bundle) {
        int i;
        this.iKH = new FrsRequestData();
        this.iKH.setSortType(com.baidu.tieba.frs.f.i.zL(this.iKV));
        if (this.iKV == 5) {
            this.iKH.setIsGood(1);
        } else {
            this.iKH.setIsGood(0);
        }
        this.iKH.gj("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.ioO));
        this.iKH.gj("client_type", "2");
        this.iKH.setPn(1);
        if (bundle != null) {
            this.iKH.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
            this.iKH.gB(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
        }
        this.iKH.RR("2");
        this.iKH.setObjSource("-2");
        this.iKH.setKw(this.ioO);
        this.iKH.setWithGroup(1);
        this.iKH.setCid(0);
        this.iKH.setScrW(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        this.iKH.setScrH(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        this.iKH.setScrDip(com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        this.iKH.setqType(au.bmV().bmW() ? 2 : 1);
        this.iKH.setSchemeUrl(this.mSchemeUrl);
        this.iKH.setLastId(null);
        this.iKH.setYuelaouLocate(this.iKU);
        this.iKH.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ac.bzC(), 0L));
        this.iKH.setStType(this.mFrom);
        this.iKH.IT(1);
        this.iKH.setNeedCache(true);
        this.iKH.setUpdateType(3);
        com.baidu.tieba.frs.f.i.a(this.iKV, this.iKH);
        this.iKH.setLoadType(1);
        if (bw.epW.get() && com.baidu.tieba.recapp.r.duF().duz() != null) {
            int aX = com.baidu.tieba.recapp.r.duF().duz().aX(this.ioO, false);
            int aY = com.baidu.tieba.recapp.r.duF().duz().aY(this.ioO, false);
            if (this.iKH.getLoadType() == 1) {
                i = aX + 1;
            } else if (this.iKH.getLoadType() == 2) {
                aY++;
                i = aX;
            } else {
                i = aX;
            }
            this.iKH.setRefreshCount(i);
            this.iKH.setLoadCount(aY);
        }
        this.iKI = new FrsNetModel(null, this.iKH);
        this.iKI.setUniqueId(((FrsActivity) this.iKB.getActivity()).getUniqueId());
        this.iKI.a(this);
        this.iKI.loadData();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.ioO);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void cyx() {
        AccountData currentAccountObj;
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            zu(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            zu(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            this.iKX = com.baidu.tieba.frs.f.i.Ki("1~" + str + this.ioO);
            zu(this.iKV);
        }
    }

    public boolean cju() {
        if (this.iDx != 1) {
            zo(1);
            return true;
        } else if (this.iKI.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.iKH), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 1, false);
            return true;
        }
    }

    public void S(int i, boolean z) {
        if (this.iKH != null) {
            this.iKB.ipc = System.currentTimeMillis();
            if (this.iou != null && this.iou.getLikeFeedForumDataList() != null) {
                this.iou.getLikeFeedForumDataList().clear();
            }
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.iKH), FrsRequestData.class);
            frsRequestData.setPn(1);
            this.iDx = c(this.iDx, frsRequestData);
            if (this.iDx == 1) {
                if (!this.iKI.isLoading()) {
                    frsRequestData.setCallFrom(0);
                    b(frsRequestData, i, z ? false : true);
                    return;
                }
                return;
            }
            if (this.iKO == null) {
                this.iKO = new ba();
                this.iKO.pn = 1;
                this.iKO.forumName = this.ioO;
                if (this.iou != null && this.iou.getForum() != null) {
                    this.iKO.forumId = this.iou.getForum().getId();
                }
            }
            zo(i);
        }
    }

    public void T(int i, boolean z) {
        this.iKB.ipc = System.currentTimeMillis();
        if (this.iou != null && this.iou.getLikeFeedForumDataList() != null) {
            this.iou.getLikeFeedForumDataList().clear();
        }
        this.iDx = c(this.iDx, this.iKH);
        if (this.iDx == 1) {
            a(this.iKH, i, z ? false : true);
            return;
        }
        if (this.iKO == null) {
            this.iKO = new ba();
            this.iKO.pn = 1;
            this.iKO.forumName = this.ioO;
            if (this.iou != null && this.iou.getForum() != null) {
                this.iKO.forumId = this.iou.getForum().getId();
            }
        }
        zo(i);
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.iKB.oS(z);
        this.iKJ.ya(i);
        if (this.iKI.cyS() && (this.iKI.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
            a((MvcHttpResponsedMessage) this.iKI.getResponsedMessage(), (MvcHttpMessage) this.iKI.cyT(), this.iKI.cyU());
        } else if (this.iKI.cyS() && (this.iKI.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
            a((MvcSocketResponsedMessage) this.iKI.getResponsedMessage(), (MvcSocketMessage) this.iKI.cyT(), this.iKI.cyU());
        } else {
            int zL = com.baidu.tieba.frs.f.i.zL(this.iKX);
            if (!zt(this.iKX) && !this.iKB.ioP && !this.iLb) {
                String f = com.baidu.tieba.tbadkCore.e.dDo().f("1~" + this.ioO, zL, frsRequestData.getIsGood(), this.iKH.getCategoryId());
                this.iKZ = f;
                new a(this, true, f).execute(new Object[0]);
            }
            this.iLb = false;
        }
        this.iKI.a(this);
    }

    public void zp(int i) {
        if (this.iDx != 1) {
            zo(4);
        } else if (!this.iKI.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.iKH), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 4, false);
        }
    }

    private void b(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.iKB.oS(z);
        this.iKJ.ya(i);
        this.iKI.a(frsRequestData);
        frsRequestData.RR(this.iKB.ctk() ? "1" : "2");
        if (this.iKY) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.i.zL(this.iKW)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.iKY = false;
        frsRequestData.setKw(this.ioO);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = au.bmV().bmW() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setSchemeUrl(this.mSchemeUrl);
        frsRequestData.setLastId(this.iJE);
        frsRequestData.setYuelaouLocate(this.iKU);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ac.bzC(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.IT(cyy());
        if (FrsFragment.ipd != 0) {
            frsRequestData.setCtime((int) FrsFragment.ipd);
        }
        if (FrsFragment.ipe != 0) {
            frsRequestData.setDataSize((int) FrsFragment.ipe);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.gB(this.iKL);
        com.baidu.tieba.frs.f.i.a(this.iKV, frsRequestData);
        int zL = com.baidu.tieba.frs.f.i.zL(this.iKX);
        b(i, frsRequestData);
        a(this.ioO, frsRequestData);
        if (!zt(this.iKX) && !this.iKB.ioP && !this.iLb) {
            String f = com.baidu.tieba.tbadkCore.e.dDo().f("1~" + this.ioO, zL, frsRequestData.getIsGood(), this.iKH.getCategoryId());
            this.iKZ = f;
            new a(this, true, f).execute(new Object[0]);
        }
        cyB();
        this.iLb = false;
    }

    private int cyy() {
        return (this.iKB == null || !(this.iKB.mHeadLineDefaultNavTabId == -1 || this.iKB.mHeadLineDefaultNavTabId == this.iDx)) ? 0 : 1;
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
            this.iKB.fgT = mVar.getDataParseTime();
        }
        zu(com.baidu.tieba.frs.f.i.zM(mVar.getSortType()));
        R(com.baidu.tieba.frs.f.i.zM(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.iDx = mVar.getFrsDefaultTabId();
        }
        this.iou.receiveData(mVar);
        d(this.iou);
        this.iKG = new ArrayList<>();
        if (frsRequestData != null) {
            this.iKH = frsRequestData;
            this.mPn = this.iKH.getPn();
            this.ioO = this.iKH.getKw();
            this.iKB.setForumName(this.ioO);
            this.iKB.setFrom(this.mFrom);
            this.iKB.setPn(this.mPn);
            this.iKB.setFlag(this.mFlag);
        }
        if (this.iou.getThreadList() != null) {
            this.iKG.addAll(this.iou.getThreadList());
        }
        if (this.iDx != 1 && this.isNetFirstLoad) {
            this.iKJ.a(7, false, this.iJD);
        } else {
            this.iKJ.a(this.mType, false, this.iJD);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.iKH)) {
            cyP();
        }
        if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iou.getForum()));
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() == null || TextUtils.isEmpty(mVar.getForum().getName()) || frsRequestData == null || com.baidu.tieba.recapp.r.duF().duz() == null) {
            return true;
        }
        com.baidu.tieba.recapp.r.duF().duz().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        if (mvcSocketResponsedMessage != null) {
            this.iLc.g(this);
            this.iLc.a(mvcSocketResponsedMessage);
            this.iLc.a(mvcSocketMessage);
            this.iLc.a(mvcNetMessage);
            this.iLc.a(this.iKJ);
            Looper.myQueue().addIdleHandler(this.iLc);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.hYP = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.mBR = mvcSocketResponsedMessage.getDownSize();
            this.iJD = fVar;
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
                this.iKB.a(errorData);
            }
        }
    }

    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.euL) {
            this.euL = true;
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
            this.iLd.g(this);
            this.iLd.a(mvcHttpResponsedMessage);
            this.iLd.a(mvcHttpMessage);
            this.iLd.a(mvcNetMessage);
            this.iLd.a(this.iKJ);
            Looper.myQueue().addIdleHandler(this.iLd);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.hYP = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.mBR = mvcHttpResponsedMessage.getDownSize();
            this.iJD = fVar;
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
                this.iKB.a(errorData);
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
        if (!this.euL) {
            this.euL = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void ctb() {
        if (this.iou != null && this.iou.getForum() != null && this.iou.getForum().getBannerListData() != null) {
            String lastIds = this.iou.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.iJE = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.byc().byd()) {
            this.fgX = System.currentTimeMillis() - this.iKB.hRt;
            this.iKB.fgW = System.currentTimeMillis() - this.iKB.ipb;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, this.iKB.fgM, this.iKB.createTime, this.iKB.fgW, false, this.iKB.fgN, this.iKB.fgT, this.fgX);
            this.iKB.createTime = 0L;
            this.iKB.fgM = 0L;
            com.baidu.tieba.frs.f.j.a(this, this.iKB.hRt);
            this.iKB.hRt = -1L;
            iVar.bxZ();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.byc().byd()) {
            this.fgX = System.currentTimeMillis() - this.iKB.ipc;
            this.iKB.fgW = System.currentTimeMillis() - this.iKB.ipb;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1000, z, responsedMessage, this.iKB.fgM, this.iKB.createTime, this.iKB.fgW, false, this.iKB.fgN, this.iKB.fgT, this.fgX);
            if (this.mType == 4) {
                iVar.fhf = this.fgX;
                iVar.kb(true);
            } else if (this.mType == 3) {
                iVar.fhg = this.fgX;
                iVar.kb(false);
            }
        }
    }

    public FrsRequestData cyz() {
        return this.iKH;
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

    public FrsViewData cyf() {
        return this.iou;
    }

    public com.baidu.tieba.tbadkCore.f cyA() {
        return this.iJD;
    }

    private boolean cyB() {
        this.hUf = System.currentTimeMillis();
        return this.iKI.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.iou.receiveData(mVar);
        d(this.iou);
        this.iKG = new ArrayList<>();
        if (this.iou.getThreadList() != null) {
            this.iKG.addAll(this.iou.getThreadList());
        }
        this.iKJ.c(mVar);
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
        private String bCg;
        private FrsModelController iLi;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.bCg = null;
            this.bCg = str;
            this.iLi = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.dDo().RP(this.bCg)) {
                if (!com.baidu.tieba.tbadkCore.e.dDo().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.bCg)) {
                    com.baidu.tieba.tbadkCore.e.dDo().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.dDo().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().bgn(), true) && !responseData.getBookInfo().bgn().equals("0") && responseData.getBookInfo().bgo() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().bgn(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.iLi != null && mVarArr != null) {
                this.iLi.e(mVarArr.length > 0 ? mVarArr[0] : null);
                this.iLi.R(this.iLi.iKV, true);
            } else if (this.iLi != null && !this.iLi.iKI.cyS()) {
                if (this.iLi.iKI.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                    this.iLi.a((MvcHttpResponsedMessage) this.iLi.iKI.getResponsedMessage(), (MvcHttpMessage) this.iLi.iKI.cyT(), this.iLi.iKI.cyU());
                }
                if (this.iLi.iKI.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                    this.iLi.a((MvcSocketResponsedMessage) this.iLi.iKI.getResponsedMessage(), (MvcSocketMessage) this.iLi.iKI.cyT(), this.iLi.iKI.cyU());
                }
            }
        }
    }

    public long cmL() {
        return this.hUi;
    }

    public long cmM() {
        return this.hUg;
    }

    public long cmN() {
        return this.hUh;
    }

    public long cmO() {
        return this.hUf;
    }

    public boolean isLoading() {
        return this.iKI.isLoading();
    }

    public int cyC() {
        return this.iKN;
    }

    private void cyD() {
        if (this.iKT == null) {
            this.iKT = new ArrayList<>();
        }
        if (this.iKT.size() == 0) {
            this.iKT.add(new ae());
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(int i, int i2, ba baVar) {
        this.iDx = c(i, null);
        if (baVar == null && (baVar = cw(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.iKS != null) {
                bd bdVar = new bd();
                bdVar.hasMore = false;
                bdVar.pn = 1;
                bdVar.forumName = this.ioO;
                bdVar.itV = false;
                if (this.iou != null && this.iou.getForum() != null) {
                    bdVar.forumId = this.iou.getForum().getId();
                }
                cyD();
                this.iou.setThreadList(this.iKT);
                this.iKS.a(i, i2, bdVar, this.iKT);
            }
            baVar = new ba();
            baVar.pn = -1;
        }
        if (this.iou != null && this.iou.getForum() != null) {
            baVar.forumId = this.iou.getForum().getId();
        }
        baVar.forumName = this.ioO;
        if (ag.cuG().yy(1) != null && this.iDx == 1) {
            this.iKH.setCategoryId(i2);
        }
        this.iKM = i2;
        this.iKO = baVar;
        b(i, i2, baVar);
        zo(5);
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(av avVar) {
        this.iKS = avVar;
        this.iKR.a(this.iLe);
    }

    private void zo(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.iKO != null) {
                    this.iKO.pn++;
                    break;
                }
                break;
            case 2:
                if (this.iKO != null) {
                    ba baVar = this.iKO;
                    baVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.iKO != null) {
                    this.iKO.pn = -1;
                    break;
                }
                break;
        }
        if (this.iDx == 1) {
            if (this.iKN == this.iKM) {
                ArrayList<q> arrayList = new ArrayList<>();
                if (this.iKG != null) {
                    arrayList.addAll(this.iKG);
                }
                this.iou.setThreadList(arrayList);
                if (this.iKS != null) {
                    this.iKS.a(this.iDx, this.iKM, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.iKN = this.iKM;
            return;
        }
        ar yz = this.iKR.yz(this.iDx);
        if (yz != null) {
            this.iKP = true;
            yz.a(this.iDx, this.iKM, this.iKO);
            return;
        }
        if (this.iou != null && this.iou.getThreadList() != null) {
            this.iou.getThreadList().clear();
        }
        this.iKS.a(this.iDx, this.iKM, null, null);
    }

    public boolean hasMore() {
        if ((this.iKO instanceof bd) && ((bd) this.iKO).errCode == 0) {
            return ((bd) this.iKO).hasMore;
        }
        return true;
    }

    private int cv(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ba baVar) {
        this.iKQ.put(cv(i, i2), baVar);
    }

    public ba cw(int i, int i2) {
        return this.iKQ.get(cv(i, i2));
    }

    @Override // com.baidu.tieba.frs.ar
    public void init() {
        this.iKR.init();
    }

    @Override // com.baidu.tieba.frs.ar
    public void bQq() {
        this.iKR.destory();
        this.iKR.clear();
    }

    public int cyE() {
        return this.iDx;
    }

    public boolean cyF() {
        return 1 == this.iDx;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(as asVar) {
        if (asVar != null && !StringUtils.isNull(asVar.getId()) && !y.isEmpty(this.iKG)) {
            if (this.iDx == 1) {
                this.iou.addMyNewThread(asVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<q> it = this.iKG.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if ((next instanceof bv) && asVar.getId().equals(((bv) next).eji.getId())) {
                    return;
                }
            }
            this.iKG.add(topThreadSize, asVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.iKG == null || this.iKG.size() <= 0) {
            return 0;
        }
        Iterator<q> it = this.iKG.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                q next = it.next();
                if (!(next instanceof bv)) {
                    i = i2;
                } else if (((bv) next).eji.bic() != 0) {
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

    public boolean cyG() {
        return this.iKP;
    }

    public void cyH() {
        s sVar = new s();
        if (this.iKN == 0) {
            sVar.yq(this.iKV);
        }
        if (this.iou.getThreadList() != null) {
            this.iou.getThreadList().clear();
            this.iou.getThreadList().add(sVar);
        }
        if (this.iKG != null) {
            this.iKG.clear();
            this.iKG.add(sVar);
        }
    }

    public ArrayList<q> cyI() {
        return this.iKG;
    }

    public void zu(int i) {
        AccountData currentAccountObj;
        this.iKV = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.f.i.aP("1~" + str + this.ioO, this.iKV);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dFt();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dFu();
        }
    }

    public void zv(int i) {
        this.iKW = i;
    }

    public void pK(boolean z) {
        this.iKY = z;
    }

    public int cyJ() {
        return this.iKV;
    }

    public int cyK() {
        return this.iKX;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.i.zL(this.iKV);
    }

    public boolean cyL() {
        return this.iKK;
    }

    public boolean cyM() {
        return this.iKV == 5;
    }

    public boolean cyN() {
        return this.iKH != null && this.iKH.getLoadType() == 1;
    }

    public boolean cyO() {
        return this.iKV == 7 || (!this.iKI.cyS() && this.iKX == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.iKB.csu() != null) {
            return this.iKB.csu().a(this.iKV, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bw.epW.get() && com.baidu.tieba.recapp.r.duF().duz() != null) {
            int aX = com.baidu.tieba.recapp.r.duF().duz().aX(str, false);
            int aY = com.baidu.tieba.recapp.r.duF().duz().aY(str, false);
            if (frsRequestData.getLoadType() == 1) {
                aX++;
            } else if (frsRequestData.getLoadType() == 2) {
                aY++;
            }
            frsRequestData.setRefreshCount(aX);
            frsRequestData.setLoadCount(aY);
        }
    }

    public void cyP() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.iou != null && this.iou.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.iou.getForum().getId(), 0L));
        }
        this.iKB.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void Kb(final String str) {
        com.baidu.tbadk.util.ae.a(new ad<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dDo().gg(FrsModelController.this.iKZ, str);
                return null;
            }
        }, null);
    }

    public void Kc(final String str) {
        com.baidu.tbadk.util.ae.a(new ad<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dDo().gh(FrsModelController.this.iKZ, str);
                return null;
            }
        }, null);
    }

    public void Kd(final String str) {
        com.baidu.tbadk.util.ae.a(new ad<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dDo().gi(FrsModelController.this.iKZ, str);
                return null;
            }
        }, null);
    }

    public void pL(boolean z) {
        this.iLb = z;
    }
}
