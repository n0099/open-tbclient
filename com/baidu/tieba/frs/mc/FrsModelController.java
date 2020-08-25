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
    private long eRU;
    private boolean egk;
    private String hSH;
    private FrsViewData hSn;
    private long hyc;
    private long hyd;
    private long hye;
    private long hyf;
    private int ihw;
    private com.baidu.tieba.tbadkCore.f inn;
    private String ino;
    private boolean ioA;
    private SparseArray<ba> ioB;
    private ai ioC;
    private av ioD;
    private ArrayList<q> ioE;
    private String ioF;
    private int ioG;
    private int ioH;
    private int ioI;
    private boolean ioJ;
    private String ioK;
    private final SparseArray<Boolean> ioL;
    private boolean ioM;
    private n ioN;
    private m ioO;
    private av ioP;
    private final FrsFragment iom;
    private ArrayList<q> ior;
    private FrsRequestData ios;
    private FrsNetModel iot;
    private final r iou;
    private boolean iov;
    private long iow;
    private int iox;
    private int ioy;
    private ba ioz;
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
        return this.ioL.get(i, false).booleanValue();
    }

    public void P(int i, boolean z) {
        this.ioL.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, r rVar) {
        super(frsFragment.getPageContext());
        this.hSH = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSchemeUrl = "";
        this.mSource = null;
        this.ino = null;
        this.iow = 0L;
        this.ihw = 1;
        this.iox = 0;
        this.ioy = 0;
        this.ioA = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.ioB = new SparseArray<>();
        this.eRU = 0L;
        this.egk = false;
        this.ioG = -1;
        this.ioH = -1;
        this.ioI = -1;
        this.ioK = null;
        this.ioL = new SparseArray<>();
        this.ioN = new n();
        this.ioO = new m();
        this.ioP = new av() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.av
            public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
                FrsModelController.this.ioA = false;
                if (i == FrsModelController.this.ihw && FrsModelController.this.ioD != null) {
                    FrsModelController.this.ioz = bdVar;
                    FrsModelController.this.b(i, i2, bdVar);
                    ArrayList<q> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.hSn.setThreadList(arrayList2);
                    FrsModelController.this.ioD.a(i, i2, bdVar, arrayList);
                }
            }
        };
        this.hyc = 0L;
        this.hyd = 0L;
        this.hye = 0L;
        this.hyf = 0L;
        if (rVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.iom = frsFragment;
        this.iou = rVar;
        if (this.iom.getActivity() instanceof FrsActivity) {
            this.iot = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.iom.getActivity()).getUniqueId().getId());
        }
        if (this.iot != null) {
            if (this.iot.getResponsedMessage() == null) {
                this.iot.a(this);
            }
            this.ios = this.iot.cse();
        }
        aa(this.iom);
    }

    private void aa(FrsFragment frsFragment) {
        this.ioC = new ai();
        this.ioC.ePv = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.ioC));
        this.ioC.a(this.ioP);
    }

    public void crq() {
        Looper.myQueue().removeIdleHandler(this.ioN);
        Looper.myQueue().removeIdleHandler(this.ioO);
        this.iot.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.hSH = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.ioF = bundle.getString("yuelaou_locate");
            this.iov = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.iom.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.hSH)) {
            this.hSH = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.ioF)) {
            this.ioF = "";
        }
        this.mSource = this.mFrom;
        crK();
        this.hSn = new FrsViewData();
        if (this.iot == null || this.ios == null || this.ios.bts() == null || this.ios.bts().isEmpty() || this.ios.bts().containsKey(null) || this.ios.bts().containsValue(null)) {
            ap(bundle);
        }
        if (this.hSH != null && this.hSH.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    private void ap(Bundle bundle) {
        int i;
        this.ios = new FrsRequestData();
        this.ios.setSortType(com.baidu.tieba.frs.f.g.yG(this.ioG));
        if (this.ioG == 5) {
            this.ios.setIsGood(1);
        } else {
            this.ios.setIsGood(0);
        }
        this.ios.fP("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.hSH));
        this.ios.fP("client_type", "2");
        this.ios.setPn(1);
        if (bundle != null) {
            this.ios.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
            this.ios.fT(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
        }
        this.ios.QD("2");
        this.ios.setObjSource("-2");
        this.ios.setKw(this.hSH);
        this.ios.setWithGroup(1);
        this.ios.setCid(0);
        this.ios.setScrW(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        this.ios.setScrH(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        this.ios.setScrDip(com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        this.ios.setqType(au.bjr().bjs() ? 2 : 1);
        this.ios.setSchemeUrl(this.mSchemeUrl);
        this.ios.setLastId(null);
        this.ios.setYuelaouLocate(this.ioF);
        this.ios.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ab.bvI(), 0L));
        this.ios.setStType(this.mFrom);
        this.ios.HK(1);
        this.ios.setNeedCache(true);
        this.ios.setUpdateType(3);
        com.baidu.tieba.frs.f.g.a(this.ioG, this.ios);
        this.ios.setLoadType(1);
        if (bw.ebD.get() && com.baidu.tieba.recapp.r.dnh().dnb() != null) {
            int aT = com.baidu.tieba.recapp.r.dnh().dnb().aT(this.hSH, false);
            int aU = com.baidu.tieba.recapp.r.dnh().dnb().aU(this.hSH, false);
            if (this.ios.getLoadType() == 1) {
                i = aT + 1;
            } else if (this.ios.getLoadType() == 2) {
                aU++;
                i = aT;
            } else {
                i = aT;
            }
            this.ios.setRefreshCount(i);
            this.ios.setLoadCount(aU);
        }
        this.iot = new FrsNetModel(null, this.ios);
        this.iot.setUniqueId(((FrsActivity) this.iom.getActivity()).getUniqueId());
        this.iot.a(this);
        this.iot.loadData();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.hSH);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void crK() {
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
            this.ioI = com.baidu.tieba.frs.f.g.IW("1~" + str + this.hSH);
            yp(this.ioG);
        }
    }

    public boolean ccI() {
        if (this.ihw != 1) {
            yj(1);
            return true;
        } else if (this.iot.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.ios), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 1, false);
            return true;
        }
    }

    public void Q(int i, boolean z) {
        if (this.ios != null) {
            this.iom.hSV = System.currentTimeMillis();
            if (this.hSn != null && this.hSn.getLikeFeedForumDataList() != null) {
                this.hSn.getLikeFeedForumDataList().clear();
            }
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.ios), FrsRequestData.class);
            frsRequestData.setPn(1);
            this.ihw = c(this.ihw, frsRequestData);
            if (this.ihw == 1) {
                if (!this.iot.isLoading()) {
                    frsRequestData.setCallFrom(0);
                    b(frsRequestData, i, z ? false : true);
                    return;
                }
                return;
            }
            if (this.ioz == null) {
                this.ioz = new ba();
                this.ioz.pn = 1;
                this.ioz.forumName = this.hSH;
                if (this.hSn != null && this.hSn.getForum() != null) {
                    this.ioz.forumId = this.hSn.getForum().getId();
                }
            }
            yj(i);
        }
    }

    public void R(int i, boolean z) {
        this.iom.hSV = System.currentTimeMillis();
        if (this.hSn != null && this.hSn.getLikeFeedForumDataList() != null) {
            this.hSn.getLikeFeedForumDataList().clear();
        }
        this.ihw = c(this.ihw, this.ios);
        if (this.ihw == 1) {
            a(this.ios, i, z ? false : true);
            return;
        }
        if (this.ioz == null) {
            this.ioz = new ba();
            this.ioz.pn = 1;
            this.ioz.forumName = this.hSH;
            if (this.hSn != null && this.hSn.getForum() != null) {
                this.ioz.forumId = this.hSn.getForum().getId();
            }
        }
        yj(i);
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.iom.of(z);
        this.iou.wV(i);
        if (this.iot.csf() && (this.iot.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
            a((MvcHttpResponsedMessage) this.iot.getResponsedMessage(), (MvcHttpMessage) this.iot.csg(), this.iot.csh());
        } else if (this.iot.csf() && (this.iot.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
            a((MvcSocketResponsedMessage) this.iot.getResponsedMessage(), (MvcSocketMessage) this.iot.csg(), this.iot.csh());
        } else {
            int yG = com.baidu.tieba.frs.f.g.yG(this.ioI);
            if (!yo(this.ioI) && !this.iom.hSI && !this.ioM) {
                String f = com.baidu.tieba.tbadkCore.e.dvF().f("1~" + this.hSH, yG, frsRequestData.getIsGood(), this.ios.getCategoryId());
                this.ioK = f;
                new a(this, true, f).execute(new Object[0]);
            }
            this.ioM = false;
        }
        this.iot.a(this);
    }

    public void yk(int i) {
        if (this.ihw != 1) {
            yj(4);
        } else if (!this.iot.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.ios), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 4, false);
        }
    }

    private void b(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.iom.of(z);
        this.iou.wV(i);
        this.iot.a(frsRequestData);
        frsRequestData.QD(this.iom.cmz() ? "1" : "2");
        if (this.ioJ) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.yG(this.ioH)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.ioJ = false;
        frsRequestData.setKw(this.hSH);
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
        frsRequestData.setLastId(this.ino);
        frsRequestData.setYuelaouLocate(this.ioF);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ab.bvI(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.HK(crL());
        if (FrsFragment.hSW != 0) {
            frsRequestData.setCtime((int) FrsFragment.hSW);
        }
        if (FrsFragment.hSX != 0) {
            frsRequestData.setDataSize((int) FrsFragment.hSX);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.fT(this.iow);
        com.baidu.tieba.frs.f.g.a(this.ioG, frsRequestData);
        int yG = com.baidu.tieba.frs.f.g.yG(this.ioI);
        b(i, frsRequestData);
        a(this.hSH, frsRequestData);
        if (!yo(this.ioI) && !this.iom.hSI && !this.ioM) {
            String f = com.baidu.tieba.tbadkCore.e.dvF().f("1~" + this.hSH, yG, frsRequestData.getIsGood(), this.ios.getCategoryId());
            this.ioK = f;
            new a(this, true, f).execute(new Object[0]);
        }
        crO();
        this.ioM = false;
    }

    private int crL() {
        return (this.iom == null || !(this.iom.mHeadLineDefaultNavTabId == -1 || this.iom.mHeadLineDefaultNavTabId == this.ihw)) ? 0 : 1;
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
            this.iom.eRQ = mVar.getDataParseTime();
        }
        yp(com.baidu.tieba.frs.f.g.yH(mVar.getSortType()));
        P(com.baidu.tieba.frs.f.g.yH(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.ihw = mVar.getFrsDefaultTabId();
        }
        this.hSn.receiveData(mVar);
        d(this.hSn);
        this.ior = new ArrayList<>();
        if (frsRequestData != null) {
            this.ios = frsRequestData;
            this.mPn = this.ios.getPn();
            this.hSH = this.ios.getKw();
            this.iom.setForumName(this.hSH);
            this.iom.setFrom(this.mFrom);
            this.iom.setPn(this.mPn);
            this.iom.setFlag(this.mFlag);
        }
        if (this.hSn.getThreadList() != null) {
            this.ior.addAll(this.hSn.getThreadList());
        }
        if (this.ihw != 1 && this.isNetFirstLoad) {
            this.iou.a(7, false, this.inn);
        } else {
            this.iou.a(this.mType, false, this.inn);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.ios)) {
            csc();
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() == null || TextUtils.isEmpty(mVar.getForum().getName()) || frsRequestData == null || com.baidu.tieba.recapp.r.dnh().dnb() == null) {
            return true;
        }
        com.baidu.tieba.recapp.r.dnh().dnb().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        if (mvcSocketResponsedMessage != null) {
            this.ioN.f(this);
            this.ioN.a(mvcSocketResponsedMessage);
            this.ioN.a(mvcSocketMessage);
            this.ioN.a(mvcNetMessage);
            this.ioN.a(this.iou);
            Looper.myQueue().addIdleHandler(this.ioN);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.hCM = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.mcA = mvcSocketResponsedMessage.getDownSize();
            this.inn = fVar;
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
                this.iom.a(errorData);
            }
        }
    }

    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.egk) {
            this.egk = true;
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
            this.ioO.f(this);
            this.ioO.a(mvcHttpResponsedMessage);
            this.ioO.a(mvcHttpMessage);
            this.ioO.a(mvcNetMessage);
            this.ioO.a(this.iou);
            Looper.myQueue().addIdleHandler(this.ioO);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.hCM = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.mcA = mvcHttpResponsedMessage.getDownSize();
            this.inn = fVar;
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
                this.iom.a(errorData);
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
        if (!this.egk) {
            this.egk = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void cmq() {
        if (this.hSn != null && this.hSn.getForum() != null && this.hSn.getForum().getBannerListData() != null) {
            String lastIds = this.hSn.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.ino = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.bun().buo()) {
            this.eRU = System.currentTimeMillis() - this.iom.hvn;
            this.iom.eRT = System.currentTimeMillis() - this.iom.hSU;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, this.iom.eRJ, this.iom.createTime, this.iom.eRT, false, this.iom.eRK, this.iom.eRQ, this.eRU);
            this.iom.createTime = 0L;
            this.iom.eRJ = 0L;
            com.baidu.tieba.frs.f.h.a(this, this.iom.hvn);
            this.iom.hvn = -1L;
            iVar.buk();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.bun().buo()) {
            this.eRU = System.currentTimeMillis() - this.iom.hSV;
            this.iom.eRT = System.currentTimeMillis() - this.iom.hSU;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1000, z, responsedMessage, this.iom.eRJ, this.iom.createTime, this.iom.eRT, false, this.iom.eRK, this.iom.eRQ, this.eRU);
            if (this.mType == 4) {
                iVar.eSc = this.eRU;
                iVar.jA(true);
            } else if (this.mType == 3) {
                iVar.eSd = this.eRU;
                iVar.jA(false);
            }
        }
    }

    public FrsRequestData crM() {
        return this.ios;
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

    public FrsViewData crs() {
        return this.hSn;
    }

    public com.baidu.tieba.tbadkCore.f crN() {
        return this.inn;
    }

    private boolean crO() {
        this.hyc = System.currentTimeMillis();
        return this.iot.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.hSn.receiveData(mVar);
        d(this.hSn);
        this.ior = new ArrayList<>();
        if (this.hSn.getThreadList() != null) {
            this.ior.addAll(this.hSn.getThreadList());
        }
        this.iou.c(mVar);
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
        private String bsl;
        private FrsModelController ioT;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.bsl = null;
            this.bsl = str;
            this.ioT = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.dvF().QB(this.bsl)) {
                if (!com.baidu.tieba.tbadkCore.e.dvF().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.bsl)) {
                    com.baidu.tieba.tbadkCore.e.dvF().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.dvF().getResponseData();
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
            if (this.ioT != null && mVarArr != null) {
                this.ioT.e(mVarArr.length > 0 ? mVarArr[0] : null);
                this.ioT.P(this.ioT.ioG, true);
            }
        }
    }

    public long cfX() {
        return this.hyf;
    }

    public long cfY() {
        return this.hyd;
    }

    public long cfZ() {
        return this.hye;
    }

    public long cga() {
        return this.hyc;
    }

    public boolean isLoading() {
        return this.iot.isLoading();
    }

    public int crP() {
        return this.ioy;
    }

    private void crQ() {
        if (this.ioE == null) {
            this.ioE = new ArrayList<>();
        }
        if (this.ioE.size() == 0) {
            this.ioE.add(new ae());
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(int i, int i2, ba baVar) {
        this.ihw = c(i, null);
        if (baVar == null && (baVar = ct(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.ioD != null) {
                bd bdVar = new bd();
                bdVar.hasMore = false;
                bdVar.pn = 1;
                bdVar.forumName = this.hSH;
                bdVar.hXO = false;
                if (this.hSn != null && this.hSn.getForum() != null) {
                    bdVar.forumId = this.hSn.getForum().getId();
                }
                crQ();
                this.hSn.setThreadList(this.ioE);
                this.ioD.a(i, i2, bdVar, this.ioE);
            }
            baVar = new ba();
            baVar.pn = -1;
        }
        if (this.hSn != null && this.hSn.getForum() != null) {
            baVar.forumId = this.hSn.getForum().getId();
        }
        baVar.forumName = this.hSH;
        if (ag.cnU().xt(1) != null && this.ihw == 1) {
            this.ios.setCategoryId(i2);
        }
        this.iox = i2;
        this.ioz = baVar;
        b(i, i2, baVar);
        yj(5);
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(av avVar) {
        this.ioD = avVar;
        this.ioC.a(this.ioP);
    }

    private void yj(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.ioz != null) {
                    this.ioz.pn++;
                    break;
                }
                break;
            case 2:
                if (this.ioz != null) {
                    ba baVar = this.ioz;
                    baVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.ioz != null) {
                    this.ioz.pn = -1;
                    break;
                }
                break;
        }
        if (this.ihw == 1) {
            if (this.ioy == this.iox) {
                ArrayList<q> arrayList = new ArrayList<>();
                if (this.ior != null) {
                    arrayList.addAll(this.ior);
                }
                this.hSn.setThreadList(arrayList);
                if (this.ioD != null) {
                    this.ioD.a(this.ihw, this.iox, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.ioy = this.iox;
            return;
        }
        ar xu = this.ioC.xu(this.ihw);
        if (xu != null) {
            this.ioA = true;
            xu.a(this.ihw, this.iox, this.ioz);
            return;
        }
        if (this.hSn != null && this.hSn.getThreadList() != null) {
            this.hSn.getThreadList().clear();
        }
        this.ioD.a(this.ihw, this.iox, null, null);
    }

    public boolean hasMore() {
        if ((this.ioz instanceof bd) && ((bd) this.ioz).errCode == 0) {
            return ((bd) this.ioz).hasMore;
        }
        return true;
    }

    private int cs(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ba baVar) {
        this.ioB.put(cs(i, i2), baVar);
    }

    public ba ct(int i, int i2) {
        return this.ioB.get(cs(i, i2));
    }

    @Override // com.baidu.tieba.frs.ar
    public void init() {
        this.ioC.init();
    }

    @Override // com.baidu.tieba.frs.ar
    public void bLO() {
        this.ioC.destory();
        this.ioC.clear();
    }

    public int crR() {
        return this.ihw;
    }

    public boolean crS() {
        return 1 == this.ihw;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(as asVar) {
        if (asVar != null && !StringUtils.isNull(asVar.getId()) && !y.isEmpty(this.ior)) {
            if (this.ihw == 1) {
                this.hSn.addMyNewThread(asVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<q> it = this.ior.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if ((next instanceof bv) && asVar.getId().equals(((bv) next).dUS.getId())) {
                    return;
                }
            }
            this.ior.add(topThreadSize, asVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.ior == null || this.ior.size() <= 0) {
            return 0;
        }
        Iterator<q> it = this.ior.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                q next = it.next();
                if (!(next instanceof bv)) {
                    i = i2;
                } else if (((bv) next).dUS.bez() != 0) {
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

    public boolean crT() {
        return this.ioA;
    }

    public void crU() {
        s sVar = new s();
        if (this.ioy == 0) {
            sVar.xl(this.ioG);
        }
        if (this.hSn.getThreadList() != null) {
            this.hSn.getThreadList().clear();
            this.hSn.getThreadList().add(sVar);
        }
        if (this.ior != null) {
            this.ior.clear();
            this.ior.add(sVar);
        }
    }

    public ArrayList<q> crV() {
        return this.ior;
    }

    public void yp(int i) {
        AccountData currentAccountObj;
        this.ioG = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.f.g.aO("1~" + str + this.hSH, this.ioG);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dxJ();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dxK();
        }
    }

    public void yq(int i) {
        this.ioH = i;
    }

    public void oX(boolean z) {
        this.ioJ = z;
    }

    public int crW() {
        return this.ioG;
    }

    public int crX() {
        return this.ioI;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.g.yG(this.ioG);
    }

    public boolean crY() {
        return this.iov;
    }

    public boolean crZ() {
        return this.ioG == 5;
    }

    public boolean csa() {
        return this.ios != null && this.ios.getLoadType() == 1;
    }

    public boolean csb() {
        return this.ioG == 7 || (!this.iot.csf() && this.ioI == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.iom.clJ() != null) {
            return this.iom.clJ().a(this.ioG, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bw.ebD.get() && com.baidu.tieba.recapp.r.dnh().dnb() != null) {
            int aT = com.baidu.tieba.recapp.r.dnh().dnb().aT(str, false);
            int aU = com.baidu.tieba.recapp.r.dnh().dnb().aU(str, false);
            if (frsRequestData.getLoadType() == 1) {
                aT++;
            } else if (frsRequestData.getLoadType() == 2) {
                aU++;
            }
            frsRequestData.setRefreshCount(aT);
            frsRequestData.setLoadCount(aU);
        }
    }

    public void csc() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.hSn != null && this.hSn.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.hSn.getForum().getId(), 0L));
        }
        this.iom.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void IP(final String str) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dvF().fM(FrsModelController.this.ioK, str);
                return null;
            }
        }, null);
    }

    public void IQ(final String str) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dvF().fN(FrsModelController.this.ioK, str);
                return null;
            }
        }, null);
    }

    public void IR(final String str) {
        ad.a(new ac<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ac
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dvF().fO(FrsModelController.this.ioK, str);
                return null;
            }
        }, null);
    }

    public void oY(boolean z) {
        this.ioM = z;
    }
}
