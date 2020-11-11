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
    private boolean eIZ;
    private long fvr;
    private FrsViewData iGN;
    private String iHh;
    private int iVQ;
    private long imD;
    private long imE;
    private long imF;
    private long imG;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private com.baidu.tieba.tbadkCore.f jbW;
    private String jbX;
    private final FrsFragment jcU;
    private ArrayList<q> jcZ;
    private FrsRequestData jda;
    private FrsNetModel jdb;
    private final r jdc;
    private boolean jdd;
    private long jde;
    private int jdf;
    private int jdg;
    private ba jdh;
    private boolean jdi;
    private SparseArray<ba> jdj;
    private ai jdk;
    private av jdl;
    private ArrayList<q> jdm;
    private String jdn;
    private int jdo;
    private int jdp;
    private int jdq;
    private boolean jdr;
    private String jds;
    private final SparseArray<Boolean> jdt;
    private boolean jdu;
    private n jdv;
    private m jdw;
    private av jdx;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSchemeUrl;
    private String mSource;
    private int mType;

    public boolean zZ(int i) {
        return this.jdt.get(i, false).booleanValue();
    }

    public void R(int i, boolean z) {
        this.jdt.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, r rVar) {
        super(frsFragment.getPageContext());
        this.iHh = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSchemeUrl = "";
        this.mSource = null;
        this.jbX = null;
        this.jde = 0L;
        this.iVQ = 1;
        this.jdf = 0;
        this.jdg = 0;
        this.jdi = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.jdj = new SparseArray<>();
        this.fvr = 0L;
        this.eIZ = false;
        this.jdo = -1;
        this.jdp = -1;
        this.jdq = -1;
        this.jds = null;
        this.jdt = new SparseArray<>();
        this.jdv = new n();
        this.jdw = new m();
        this.jdx = new av() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.av
            public void a(int i, int i2, bd bdVar, ArrayList<q> arrayList) {
                FrsModelController.this.jdi = false;
                if (i == FrsModelController.this.iVQ && FrsModelController.this.jdl != null) {
                    FrsModelController.this.jdh = bdVar;
                    FrsModelController.this.b(i, i2, bdVar);
                    ArrayList<q> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.iGN.setThreadList(arrayList2);
                    FrsModelController.this.jdl.a(i, i2, bdVar, arrayList);
                }
            }
        };
        this.imD = 0L;
        this.imE = 0L;
        this.imF = 0L;
        this.imG = 0L;
        if (rVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.jcU = frsFragment;
        this.jdc = rVar;
        if (this.jcU.getActivity() instanceof FrsActivity) {
            this.jdb = TbadkCoreApplication.getInst().getFrsModeArray().get(((FrsActivity) this.jcU.getActivity()).getUniqueId().getId());
        }
        if (this.jdb != null) {
            if (this.jdb.getResponsedMessage() == null) {
                this.jdb.a(this);
            }
            this.jda = this.jdb.cEz();
        }
        aa(this.jcU);
    }

    private void aa(FrsFragment frsFragment) {
        this.jdk = new ai();
        this.jdk.fsQ = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.jdk));
        this.jdk.a(this.jdx);
    }

    public void cDL() {
        Looper.myQueue().removeIdleHandler(this.jdv);
        Looper.myQueue().removeIdleHandler(this.jdw);
        this.jdb.cancelLoadData();
    }

    public void aj(Bundle bundle) {
        if (bundle != null) {
            this.iHh = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.jdn = bundle.getString("yuelaou_locate");
            this.jdd = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.jcU.getActivity().getIntent().putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L);
        }
        if (TextUtils.isEmpty(this.iHh)) {
            this.iHh = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.jdn)) {
            this.jdn = "";
        }
        this.mSource = this.mFrom;
        cEf();
        this.iGN = new FrsViewData();
        if (this.jdb == null || this.jda == null || this.jda.bBz() == null || this.jda.bBz().isEmpty() || this.jda.bBz().containsKey(null) || this.jda.bBz().containsValue(null)) {
            ap(bundle);
        }
        if (this.iHh != null && this.iHh.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = "tb_forumlist";
            }
        }
    }

    private void ap(Bundle bundle) {
        int i;
        this.jda = new FrsRequestData();
        this.jda.setSortType(com.baidu.tieba.frs.f.i.Ar(this.jdo));
        if (this.jdo == 5) {
            this.jda.setIsGood(1);
        } else {
            this.jda.setIsGood(0);
        }
        this.jda.go("forum_name", com.baidu.adp.lib.util.k.getUrlEncode(this.iHh));
        this.jda.go("client_type", "2");
        this.jda.setPn(1);
        if (bundle != null) {
            this.jda.setCallFrom(bundle.getInt(FrsActivityConfig.FRS_CALL_FROM));
            this.jda.gY(bundle.getLong(FrsActivityConfig.FRS_HOT_THREAD_ID, 0L));
        }
        this.jda.SH("2");
        this.jda.setObjSource("-2");
        this.jda.setKw(this.iHh);
        this.jda.setWithGroup(1);
        this.jda.setCid(0);
        this.jda.setScrW(com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        this.jda.setScrH(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        this.jda.setScrDip(com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        this.jda.setqType(au.bro().brp() ? 2 : 1);
        this.jda.setSchemeUrl(this.mSchemeUrl);
        this.jda.setLastId(null);
        this.jda.setYuelaouLocate(this.jdn);
        this.jda.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ac.bDU(), 0L));
        this.jda.setStType(this.mFrom);
        this.jda.Jy(1);
        this.jda.setNeedCache(true);
        this.jda.setUpdateType(3);
        com.baidu.tieba.frs.f.i.a(this.jdo, this.jda);
        this.jda.setLoadType(1);
        if (bw.eEm.get() && com.baidu.tieba.recapp.r.dAo().dAi() != null) {
            int aZ = com.baidu.tieba.recapp.r.dAo().dAi().aZ(this.iHh, false);
            int ba = com.baidu.tieba.recapp.r.dAo().dAi().ba(this.iHh, false);
            if (this.jda.getLoadType() == 1) {
                i = aZ + 1;
            } else if (this.jda.getLoadType() == 2) {
                ba++;
                i = aZ;
            } else {
                i = aZ;
            }
            this.jda.setRefreshCount(i);
            this.jda.setLoadCount(ba);
        }
        this.jdb = new FrsNetModel(null, this.jda);
        this.jdb.setUniqueId(((FrsActivity) this.jcU.getActivity()).getUniqueId());
        this.jdb.a(this);
        this.jdb.loadData();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.iHh);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public void setSchemeUrl(String str) {
        this.mSchemeUrl = str;
    }

    private void cEf() {
        AccountData currentAccountObj;
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            Aa(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            Aa(6);
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            this.jdq = com.baidu.tieba.frs.f.i.KY("1~" + str + this.iHh);
            Aa(this.jdo);
        }
    }

    public boolean cpc() {
        if (this.iVQ != 1) {
            zU(1);
            return true;
        } else if (this.jdb.isLoading()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jda), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 1, false);
            return true;
        }
    }

    public void S(int i, boolean z) {
        if (this.jda != null) {
            this.jcU.iHv = System.currentTimeMillis();
            if (this.iGN != null && this.iGN.getLikeFeedForumDataList() != null) {
                this.iGN.getLikeFeedForumDataList().clear();
            }
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jda), FrsRequestData.class);
            frsRequestData.setPn(1);
            this.iVQ = c(this.iVQ, frsRequestData);
            if (this.iVQ == 1) {
                if (!this.jdb.isLoading()) {
                    frsRequestData.setCallFrom(0);
                    b(frsRequestData, i, z ? false : true);
                    return;
                }
                return;
            }
            if (this.jdh == null) {
                this.jdh = new ba();
                this.jdh.pn = 1;
                this.jdh.forumName = this.iHh;
                if (this.iGN != null && this.iGN.getForum() != null) {
                    this.jdh.forumId = this.iGN.getForum().getId();
                }
            }
            zU(i);
        }
    }

    public void T(int i, boolean z) {
        this.jcU.iHv = System.currentTimeMillis();
        if (this.iGN != null && this.iGN.getLikeFeedForumDataList() != null) {
            this.iGN.getLikeFeedForumDataList().clear();
        }
        this.iVQ = c(this.iVQ, this.jda);
        if (this.iVQ == 1) {
            a(this.jda, i, z ? false : true);
            return;
        }
        if (this.jdh == null) {
            this.jdh = new ba();
            this.jdh.pn = 1;
            this.jdh.forumName = this.iHh;
            if (this.iGN != null && this.iGN.getForum() != null) {
                this.jdh.forumId = this.iGN.getForum().getId();
            }
        }
        zU(i);
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.jcU.pt(z);
        this.jdc.yG(i);
        if (this.jdb.cEA() && (this.jdb.getResponsedMessage() instanceof MvcHttpResponsedMessage)) {
            a((MvcHttpResponsedMessage) this.jdb.getResponsedMessage(), (MvcHttpMessage) this.jdb.cEB(), this.jdb.cEC());
        } else if (this.jdb.cEA() && (this.jdb.getResponsedMessage() instanceof MvcSocketResponsedMessage)) {
            a((MvcSocketResponsedMessage) this.jdb.getResponsedMessage(), (MvcSocketMessage) this.jdb.cEB(), this.jdb.cEC());
        } else {
            int Ar = com.baidu.tieba.frs.f.i.Ar(this.jdq);
            if (!zZ(this.jdq) && !this.jcU.iHi && !this.jdu) {
                String f = com.baidu.tieba.tbadkCore.e.dIY().f("1~" + this.iHh, Ar, frsRequestData.getIsGood(), this.jda.getCategoryId());
                this.jds = f;
                new a(this, true, f).execute(new Object[0]);
            }
            this.jdu = false;
        }
        this.jdb.a(this);
    }

    public void zV(int i) {
        if (this.iVQ != 1) {
            zU(4);
        } else if (!this.jdb.isLoading()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.jda), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(getSortType());
            b(frsRequestData, 4, false);
        }
    }

    private void b(FrsRequestData frsRequestData, int i, boolean z) {
        this.mType = i;
        this.jcU.pt(z);
        this.jdc.yG(i);
        this.jdb.a(frsRequestData);
        frsRequestData.SH(this.jcU.cyS() ? "1" : "2");
        if (this.jdr) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.i.Ar(this.jdp)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.jdr = false;
        frsRequestData.setKw(this.iHh);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst());
        float equipmentDensity = com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
        int i2 = au.bro().brp() ? 2 : 1;
        frsRequestData.setScrW(equipmentWidth);
        frsRequestData.setScrH(equipmentHeight);
        frsRequestData.setScrDip(equipmentDensity);
        frsRequestData.setqType(i2);
        frsRequestData.setSchemeUrl(this.mSchemeUrl);
        frsRequestData.setLastId(this.jbX);
        frsRequestData.setYuelaouLocate(this.jdn);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.f.b.toLong(ac.bDU(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        frsRequestData.Jy(cEg());
        if (FrsFragment.iHw != 0) {
            frsRequestData.setCtime((int) FrsFragment.iHw);
        }
        if (FrsFragment.iHx != 0) {
            frsRequestData.setDataSize((int) FrsFragment.iHx);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        frsRequestData.gY(this.jde);
        com.baidu.tieba.frs.f.i.a(this.jdo, frsRequestData);
        int Ar = com.baidu.tieba.frs.f.i.Ar(this.jdq);
        b(i, frsRequestData);
        a(this.iHh, frsRequestData);
        if (!zZ(this.jdq) && !this.jcU.iHi && !this.jdu) {
            String f = com.baidu.tieba.tbadkCore.e.dIY().f("1~" + this.iHh, Ar, frsRequestData.getIsGood(), this.jda.getCategoryId());
            this.jds = f;
            new a(this, true, f).execute(new Object[0]);
        }
        cEj();
        this.jdu = false;
    }

    private int cEg() {
        return (this.jcU == null || !(this.jcU.mHeadLineDefaultNavTabId == -1 || this.jcU.mHeadLineDefaultNavTabId == this.iVQ)) ? 0 : 1;
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
            this.jcU.fvn = mVar.getDataParseTime();
        }
        Aa(com.baidu.tieba.frs.f.i.As(mVar.getSortType()));
        R(com.baidu.tieba.frs.f.i.As(mVar.getSortType()), true);
        if (this.isNetFirstLoad) {
            this.iVQ = mVar.getFrsDefaultTabId();
        }
        this.iGN.receiveData(mVar);
        d(this.iGN);
        this.jcZ = new ArrayList<>();
        if (frsRequestData != null) {
            this.jda = frsRequestData;
            this.mPn = this.jda.getPn();
            this.iHh = this.jda.getKw();
            this.jcU.setForumName(this.iHh);
            this.jcU.setFrom(this.mFrom);
            this.jcU.setPn(this.mPn);
            this.jcU.setFlag(this.mFlag);
        }
        if (this.iGN.getThreadList() != null) {
            this.jcZ.addAll(this.iGN.getThreadList());
        }
        if (this.iVQ != 1 && this.isNetFirstLoad) {
            this.jdc.a(7, false, this.jbW);
        } else {
            this.jdc.a(this.mType, false, this.jbW);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.b.b(this.jda)) {
            cEx();
        }
        if (!this.isNetFirstLoad && frsRequestData != null && frsRequestData.getUpdateType() == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921498, this.iGN.getForum()));
        }
        this.isNetFirstLoad = false;
        if (mVar.getForum() == null || TextUtils.isEmpty(mVar.getForum().getName()) || frsRequestData == null || com.baidu.tieba.recapp.r.dAo().dAi() == null) {
            return true;
        }
        com.baidu.tieba.recapp.r.dAo().dAi().f(mVar.getForum().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.m data;
        if (mvcSocketResponsedMessage != null) {
            this.jdv.g(this);
            this.jdv.a(mvcSocketResponsedMessage);
            this.jdv.a(mvcSocketMessage);
            this.jdv.a(mvcNetMessage);
            this.jdv.a(this.jdc);
            Looper.myQueue().addIdleHandler(this.jdv);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iro = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcSocketResponsedMessage.getError();
            fVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
            fVar.mUE = mvcSocketResponsedMessage.getDownSize();
            this.jbW = fVar;
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
                this.jcU.a(errorData);
            }
        }
    }

    public void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.m, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.m> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.eIZ) {
            this.eIZ = true;
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
            this.jdw.g(this);
            this.jdw.a(mvcHttpResponsedMessage);
            this.jdw.a(mvcHttpMessage);
            this.jdw.a(mvcNetMessage);
            this.jdw.a(this.jdc);
            Looper.myQueue().addIdleHandler(this.jdw);
            com.baidu.tieba.tbadkCore.f fVar = new com.baidu.tieba.tbadkCore.f();
            fVar.iro = com.baidu.adp.lib.util.j.isNetWorkAvailable() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
            fVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
            fVar.errorCode = mvcHttpResponsedMessage.getError();
            fVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
            fVar.mUE = mvcHttpResponsedMessage.getDownSize();
            this.jbW = fVar;
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
                this.jcU.a(errorData);
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
        if (!this.eIZ) {
            this.eIZ = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
            return;
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void cyJ() {
        if (this.iGN != null && this.iGN.getForum() != null && this.iGN.getForum().getBannerListData() != null) {
            String lastIds = this.iGN.getForum().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.jbX = lastIds;
            }
        }
    }

    private void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.bCu().bCv()) {
            this.fvr = System.currentTimeMillis() - this.jcU.ijR;
            this.jcU.fvq = System.currentTimeMillis() - this.jcU.iHu;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(i, z, responsedMessage, this.jcU.fvg, this.jcU.createTime, this.jcU.fvq, false, this.jcU.fvh, this.jcU.fvn, this.fvr);
            this.jcU.createTime = 0L;
            this.jcU.fvg = 0L;
            com.baidu.tieba.frs.f.j.a(this, this.jcU.ijR);
            this.jcU.ijR = -1L;
            iVar.bCr();
        }
    }

    private void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.n.m.bCu().bCv()) {
            this.fvr = System.currentTimeMillis() - this.jcU.iHv;
            this.jcU.fvq = System.currentTimeMillis() - this.jcU.iHu;
            com.baidu.tbadk.n.i iVar = new com.baidu.tbadk.n.i(1000, z, responsedMessage, this.jcU.fvg, this.jcU.createTime, this.jcU.fvq, false, this.jcU.fvh, this.jcU.fvn, this.fvr);
            if (this.mType == 4) {
                iVar.fvz = this.fvr;
                iVar.kx(true);
            } else if (this.mType == 3) {
                iVar.fvA = this.fvr;
                iVar.kx(false);
            }
        }
    }

    public FrsRequestData cEh() {
        return this.jda;
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

    public FrsViewData cDN() {
        return this.iGN;
    }

    public com.baidu.tieba.tbadkCore.f cEi() {
        return this.jbW;
    }

    private boolean cEj() {
        this.imD = System.currentTimeMillis();
        return this.jdb.loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.tbadkCore.m mVar) {
        this.isCacheFirstLoad = false;
        this.iGN.receiveData(mVar);
        d(this.iGN);
        this.jcZ = new ArrayList<>();
        if (this.iGN.getThreadList() != null) {
            this.jcZ.addAll(this.iGN.getThreadList());
        }
        this.jdc.c(mVar);
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
        private String bKI;
        private FrsModelController jdB;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.bKI = null;
            this.bKI = str;
            this.jdB = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.e.dIY().SF(this.bKI)) {
                if (!com.baidu.tieba.tbadkCore.e.dIY().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.bKI)) {
                    com.baidu.tieba.tbadkCore.e.dIY().getResponseData().getForum().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.m responseData = com.baidu.tieba.tbadkCore.e.dIY().getResponseData();
                responseData.setIsShowRedTip(false);
                if (responseData.getBookInfo() != null && !StringUtils.isNull(responseData.getBookInfo().bkG(), true) && !responseData.getBookInfo().bkG().equals("0") && responseData.getBookInfo().bkH() == 3 && (i = com.baidu.adp.lib.f.b.toInt(responseData.getBookInfo().bkG(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(i))) != null) {
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
            if (this.jdB != null && mVarArr != null) {
                this.jdB.e(mVarArr.length > 0 ? mVarArr[0] : null);
                this.jdB.R(this.jdB.jdo, true);
            } else if (this.jdB != null && !this.jdB.jdb.cEA()) {
                if (this.jdB.jdb.getResponsedMessage() instanceof MvcHttpResponsedMessage) {
                    this.jdB.a((MvcHttpResponsedMessage) this.jdB.jdb.getResponsedMessage(), (MvcHttpMessage) this.jdB.jdb.cEB(), this.jdB.jdb.cEC());
                }
                if (this.jdB.jdb.getResponsedMessage() instanceof MvcSocketResponsedMessage) {
                    this.jdB.a((MvcSocketResponsedMessage) this.jdB.jdb.getResponsedMessage(), (MvcSocketMessage) this.jdB.jdb.cEB(), this.jdB.jdb.cEC());
                }
            }
        }
    }

    public long cst() {
        return this.imG;
    }

    public long csu() {
        return this.imE;
    }

    public long csv() {
        return this.imF;
    }

    public long csw() {
        return this.imD;
    }

    public boolean isLoading() {
        return this.jdb.isLoading();
    }

    public int cEk() {
        return this.jdg;
    }

    private void cEl() {
        if (this.jdm == null) {
            this.jdm = new ArrayList<>();
        }
        if (this.jdm.size() == 0) {
            this.jdm.add(new ae());
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(int i, int i2, ba baVar) {
        this.iVQ = c(i, null);
        if (baVar == null && (baVar = cA(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.isNetOk() && this.jdl != null) {
                bd bdVar = new bd();
                bdVar.hasMore = false;
                bdVar.pn = 1;
                bdVar.forumName = this.iHh;
                bdVar.iMo = false;
                if (this.iGN != null && this.iGN.getForum() != null) {
                    bdVar.forumId = this.iGN.getForum().getId();
                }
                cEl();
                this.iGN.setThreadList(this.jdm);
                this.jdl.a(i, i2, bdVar, this.jdm);
            }
            baVar = new ba();
            baVar.pn = -1;
        }
        if (this.iGN != null && this.iGN.getForum() != null) {
            baVar.forumId = this.iGN.getForum().getId();
        }
        baVar.forumName = this.iHh;
        if (ag.cAo().ze(1) != null && this.iVQ == 1) {
            this.jda.setCategoryId(i2);
        }
        this.jdf = i2;
        this.jdh = baVar;
        b(i, i2, baVar);
        zU(5);
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(av avVar) {
        this.jdl = avVar;
        this.jdk.a(this.jdx);
    }

    private void zU(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.jdh != null) {
                    this.jdh.pn++;
                    break;
                }
                break;
            case 2:
                if (this.jdh != null) {
                    ba baVar = this.jdh;
                    baVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.jdh != null) {
                    this.jdh.pn = -1;
                    break;
                }
                break;
        }
        if (this.iVQ == 1) {
            if (this.jdg == this.jdf) {
                ArrayList<q> arrayList = new ArrayList<>();
                if (this.jcZ != null) {
                    arrayList.addAll(this.jcZ);
                }
                this.iGN.setThreadList(arrayList);
                if (this.jdl != null) {
                    this.jdl.a(this.iVQ, this.jdf, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.jdg = this.jdf;
            return;
        }
        ar zf = this.jdk.zf(this.iVQ);
        if (zf != null) {
            this.jdi = true;
            zf.a(this.iVQ, this.jdf, this.jdh);
            return;
        }
        if (this.iGN != null && this.iGN.getThreadList() != null) {
            this.iGN.getThreadList().clear();
        }
        this.jdl.a(this.iVQ, this.jdf, null, null);
    }

    public boolean hasMore() {
        if ((this.jdh instanceof bd) && ((bd) this.jdh).errCode == 0) {
            return ((bd) this.jdh).hasMore;
        }
        return true;
    }

    private int cz(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ba baVar) {
        this.jdj.put(cz(i, i2), baVar);
    }

    public ba cA(int i, int i2) {
        return this.jdj.get(cz(i, i2));
    }

    @Override // com.baidu.tieba.frs.ar
    public void init() {
        this.jdk.init();
    }

    @Override // com.baidu.tieba.frs.ar
    public void bVV() {
        this.jdk.destory();
        this.jdk.clear();
    }

    public int cEm() {
        return this.iVQ;
    }

    public boolean cEn() {
        return 1 == this.iVQ;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void addMyNewThread(as asVar) {
        if (asVar != null && !StringUtils.isNull(asVar.getId()) && !y.isEmpty(this.jcZ)) {
            if (this.iVQ == 1) {
                this.iGN.addMyNewThread(asVar);
            }
            int topThreadSize = getTopThreadSize();
            Iterator<q> it = this.jcZ.iterator();
            while (it.hasNext()) {
                q next = it.next();
                if ((next instanceof bv) && asVar.getId().equals(((bv) next).exA.getId())) {
                    return;
                }
            }
            this.jcZ.add(topThreadSize, asVar);
        }
    }

    public int getTopThreadSize() {
        int i = 0;
        if (this.jcZ == null || this.jcZ.size() <= 0) {
            return 0;
        }
        Iterator<q> it = this.jcZ.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                q next = it.next();
                if (!(next instanceof bv)) {
                    i = i2;
                } else if (((bv) next).exA.bmv() != 0) {
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

    public boolean cEo() {
        return this.jdi;
    }

    public void cEp() {
        s sVar = new s();
        if (this.jdg == 0) {
            sVar.yW(this.jdo);
        }
        if (this.iGN.getThreadList() != null) {
            this.iGN.getThreadList().clear();
            this.iGN.getThreadList().add(sVar);
        }
        if (this.jcZ != null) {
            this.jcZ.clear();
            this.jcZ.add(sVar);
        }
    }

    public ArrayList<q> cEq() {
        return this.jcZ;
    }

    public void Aa(int i) {
        AccountData currentAccountObj;
        this.jdo = i;
        if (i != -1) {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            com.baidu.tieba.frs.f.i.aS("1~" + str + this.iHh, this.jdo);
        }
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.dLd();
        } else {
            com.baidu.tieba.tbadkCore.util.e.dLe();
        }
    }

    public void Ab(int i) {
        this.jdp = i;
    }

    public void ql(boolean z) {
        this.jdr = z;
    }

    public int cEr() {
        return this.jdo;
    }

    public int cEs() {
        return this.jdq;
    }

    public int getSortType() {
        return com.baidu.tieba.frs.f.i.Ar(this.jdo);
    }

    public boolean cEt() {
        return this.jdd;
    }

    public boolean cEu() {
        return this.jdo == 5;
    }

    public boolean cEv() {
        return this.jda != null && this.jda.getLoadType() == 1;
    }

    public boolean cEw() {
        return this.jdo == 7 || (!this.jdb.cEA() && this.jdq == 7);
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.jcU.cyc() != null) {
            return this.jcU.cyc().a(this.jdo, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bw.eEm.get() && com.baidu.tieba.recapp.r.dAo().dAi() != null) {
            int aZ = com.baidu.tieba.recapp.r.dAo().dAi().aZ(str, false);
            int ba = com.baidu.tieba.recapp.r.dAo().dAi().ba(str, false);
            if (frsRequestData.getLoadType() == 1) {
                aZ++;
            } else if (frsRequestData.getLoadType() == 2) {
                ba++;
            }
            frsRequestData.setRefreshCount(aZ);
            frsRequestData.setLoadCount(ba);
        }
    }

    public void cEx() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.iGN != null && this.iGN.getForum() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.iGN.getForum().getId(), 0L));
        }
        this.jcU.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void KR(final String str) {
        com.baidu.tbadk.util.ae.a(new ad<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dIY().gl(FrsModelController.this.jds, str);
                return null;
            }
        }, null);
    }

    public void KS(final String str) {
        com.baidu.tbadk.util.ae.a(new ad<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dIY().gm(FrsModelController.this.jds, str);
                return null;
            }
        }, null);
    }

    public void KT(final String str) {
        com.baidu.tbadk.util.ae.a(new ad<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.ad
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.e.dIY().gn(FrsModelController.this.jds, str);
                return null;
            }
        }, null);
    }

    public void qm(boolean z) {
        this.jdu = z;
    }
}
