package com.baidu.tieba.frs.mc;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.k.r;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.m;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.h>, ak {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long aKx;
    private int bkh;
    private k cGO;
    private String cHb;
    private final com.baidu.tieba.frs.g cOx;
    private ArrayList<com.baidu.adp.widget.ListView.f> cSb;
    private FrsNetModel<com.baidu.tieba.frs.g> cSc;
    private d.a cSe;
    private String cSf;
    private boolean cSi;
    private FrsRequestData cXM;
    private final m cXN;
    private boolean cXO;
    private int cXP;
    private int cXQ;
    private ap cXR;
    private boolean cXS;
    private SparseArray<ap> cXT;
    private ac cXU;
    private am cXV;
    private ArrayList<com.baidu.adp.widget.ListView.f> cXW;
    private String cXX;
    private int cXY;
    private int cXZ;
    private boolean cYa;
    private String cYb;
    private final SparseArray<Boolean> cYc;
    private am cYd;
    private long ctR;
    private long ctS;
    private long ctT;
    private long ctU;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean kG(int i) {
        return this.cYc.get(i, false).booleanValue();
    }

    public void o(int i, boolean z) {
        this.cYc.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.g gVar, m mVar) {
        super(gVar.getPageContext());
        this.cHb = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.cSf = null;
        this.bkh = 1;
        this.cXP = 0;
        this.cXQ = 0;
        this.cXS = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.cXT = new SparseArray<>();
        this.aKx = 0L;
        this.cSi = false;
        this.cXY = -1;
        this.cXZ = -1;
        this.cYb = null;
        this.cYc = new SparseArray<>();
        this.cYd = new am() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.am
            public void a(int i, int i2, as asVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
                FrsModelController.this.cXS = false;
                if (i == FrsModelController.this.bkh && FrsModelController.this.cXV != null) {
                    FrsModelController.this.cXR = asVar;
                    FrsModelController.this.b(i, i2, asVar);
                    ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.cGO.aA(arrayList2);
                    if ((i == 1 || i == 5) && !FrsModelController.this.aqf()) {
                        FrsModelController.this.cGO.bvO();
                        FrsModelController.this.cGO.bvP();
                    }
                    FrsModelController.this.cXV.a(i, i2, asVar, arrayList);
                }
            }
        };
        this.ctR = 0L;
        this.ctS = 0L;
        this.ctT = 0L;
        this.ctU = 0L;
        if (gVar == null || mVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.cOx = gVar;
        this.cXN = mVar;
        A(this.cOx);
    }

    private void A(com.baidu.tieba.frs.g gVar) {
        this.cXU = new ac();
        this.cXU.aSy = gVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.cXU));
        this.cXU.a(this.cYd);
    }

    public void onActivityDestroy() {
        this.cSc.cancelLoadData();
    }

    public void h(Bundle bundle) {
        if (bundle != null) {
            this.cHb = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.cXX = bundle.getString("yuelaou_locate");
            this.cXO = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.cHb)) {
            this.cHb = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.cXX)) {
            this.cXX = "";
        }
        this.mSource = this.mFrom;
        this.cXM = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            kI(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            kI(6);
        } else {
            com.baidu.tieba.frs.smartsort.f lD = com.baidu.tieba.frs.smartsort.d.aqr().lD(this.cHb);
            if (lD != null) {
                kI(lD.cYN);
            } else {
                kI(-1);
            }
        }
        this.cXM.setSortType(Qt());
        if (this.cXY == 5) {
            this.cXM.setIsGood(1);
        } else {
            this.cXM.setIsGood(0);
        }
        this.cGO = new k();
        this.cSc = new FrsNetModel<>(this.cOx.getPageContext(), this.cXM);
        this.cSc.a(this);
        this.cSc.setUniqueId(this.cOx.getUniqueId());
        if (this.cHb != null && this.cHb.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.cHb);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean adr() {
        if (this.bkh != 1) {
            kH(1);
            return true;
        } else if (this.cSc.wA()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cXM), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(Qt());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void p(int i, boolean z) {
        if (this.cGO != null && this.cGO.bvk() != null) {
            this.cGO.bvk().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cXM), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bkh = c(this.bkh, frsRequestData);
        if (this.bkh == 1) {
            if (!this.cSc.wA()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.cXR == null) {
            this.cXR = new ap();
            this.cXR.pn = 1;
            this.cXR.forumName = this.cHb;
            if (this.cGO != null && this.cGO.aRo() != null) {
                this.cXR.forumId = this.cGO.aRo().getId();
            }
        }
        kH(i);
    }

    public void ks(int i) {
        if (this.bkh != 1) {
            kH(4);
        } else if (!this.cSc.wA()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cXM), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(Qt());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.cXN.jP(i);
        this.cSc.a(frsRequestData);
        this.mType = i;
        frsRequestData.sQ(this.cOx.alH() ? "1" : "2");
        if (this.cYa) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.f.kW(this.cXZ)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.cYa = false;
        frsRequestData.setKw(this.cHb);
        if (com.baidu.tbadk.core.h.oY().pe()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ac = l.ac(TbadkCoreApplication.getInst());
        int ae = l.ae(TbadkCoreApplication.getInst());
        float af = l.af(TbadkCoreApplication.getInst());
        int i2 = an.vs().vu() ? 2 : 1;
        frsRequestData.setScrW(ac);
        frsRequestData.setScrH(ae);
        frsRequestData.setScrDip(af);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.cSf);
        frsRequestData.setYuelaouLocate(this.cXX);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(t.Ht(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.g.cHj != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.g.cHj);
        }
        if (com.baidu.tieba.frs.g.cHk != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.g.cHk);
        }
        if (com.baidu.tieba.frs.g.cHl != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.g.cHl);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.f.a(this.cXY, frsRequestData);
        b(i, frsRequestData);
        a(this.cHb, frsRequestData);
        if (!kG(this.cXY)) {
            String d = com.baidu.tieba.tbadkCore.c.buK().d(this.cHb, frsRequestData.Qt(), frsRequestData.getIsGood(), this.cXM.getCategoryId());
            this.cYb = d;
            new a(this, true, d).execute(new Object[0]);
        }
        aoJ();
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

    protected boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.h hVar) {
        if (hVar == null || hVar.aRo() == null || (com.baidu.tbadk.core.util.am.isEmpty(hVar.aRo().getName()) && 340001 != hVar.gAi)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bkh = hVar.bvo();
        }
        this.cGO.e(hVar);
        e(this.cGO);
        this.cSb = new ArrayList<>();
        if (frsRequestData != null) {
            this.cXM = frsRequestData;
            this.mPn = this.cXM.getPn();
            this.cHb = this.cXM.getKw();
            this.cOx.setForumName(this.cHb);
            this.cOx.setFrom(this.mFrom);
            this.cOx.setPn(this.mPn);
            this.cOx.setFlag(this.mFlag);
        }
        if (this.cGO.getThreadList() != null) {
            this.cSb.addAll(this.cGO.getThreadList());
        }
        if (this.bkh != 1 && this.isNetFirstLoad) {
            this.cXN.a(7, false, this.cSe);
        } else {
            this.cXN.a(this.mType, false, this.cSe);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.cXM)) {
            aqg();
        }
        this.isNetFirstLoad = false;
        if (hVar.aRo() == null || TextUtils.isEmpty(hVar.aRo().getName()) || frsRequestData == null || q.blR().blL() == null) {
            return true;
        }
        q.blR().blL().f(hVar.aRo().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.h, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.h> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.h> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.h hVar;
        d.a aVar = new d.a();
        aVar.gyG = com.baidu.adp.lib.util.j.hh() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gyH = mvcSocketResponsedMessage.getDownSize();
        this.cSe = aVar;
        if (mvcSocketResponsedMessage == null || (mvcSocketResponsedMessage.hasError() && 340001 != mvcSocketResponsedMessage.getError())) {
            hVar = null;
        } else {
            hVar = mvcSocketResponsedMessage.getData();
            r3 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && hVar != null && a(r3, hVar)) {
            b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
            return;
        }
        if (mvcSocketResponsedMessage != null) {
            this.mErrorCode = mvcSocketResponsedMessage.getError();
            this.mErrorString = mvcSocketResponsedMessage.getErrorString();
        }
        ErrorData errorData = new ErrorData();
        errorData.setError_code(this.mErrorCode);
        errorData.setError_msg(this.mErrorString);
        this.cOx.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.h, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.h> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.h> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.cSi) {
            this.cSi = true;
            a(1000, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
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
            objArr[2] = "seq_id";
            objArr[3] = Long.valueOf(mvcSocketResponsedMessage.sequenceID);
            com.baidu.tbadk.core.d.a.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.h> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.h> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.h> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.h hVar;
        d.a aVar = new d.a();
        aVar.gyG = com.baidu.adp.lib.util.j.hh() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gyH = mvcHttpResponsedMessage.getDownSize();
        this.cSe = aVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            hVar = null;
        } else {
            hVar = mvcHttpResponsedMessage.getData();
            r3 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && hVar != null && a(r3, hVar)) {
            b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
            return;
        }
        if (mvcHttpResponsedMessage != null) {
            this.mErrorCode = mvcHttpResponsedMessage.getError();
            this.mErrorString = mvcHttpResponsedMessage.getErrorString();
        }
        ErrorData errorData = new ErrorData();
        errorData.setError_code(this.mErrorCode);
        errorData.setError_msg(this.mErrorString);
        this.cOx.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        super.registerListener(i, aVar);
    }

    private void b(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.h> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.h> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.h> mvcNetMessage) {
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
        if (!this.cSi) {
            this.cSi = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void alB() {
        if (this.cGO != null && this.cGO.aRo() != null && this.cGO.aRo().getBannerListData() != null) {
            String lastIds = this.cGO.aRo().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.cSf = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (r.GB().GC()) {
            this.aKx = System.currentTimeMillis() - this.cOx.beginTime;
            com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m(i, z, responsedMessage, this.cOx.aKo, this.cOx.createTime, this.cOx.aKw, false, this.aKx);
            this.cOx.createTime = 0L;
            this.cOx.aKo = 0L;
            if (mVar != null) {
                mVar.Gw();
            }
        }
    }

    public FrsRequestData apQ() {
        return this.cXM;
    }

    public String apR() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.cHb;
    }

    public int getPn() {
        return this.mPn;
    }

    public k aoI() {
        return this.cGO;
    }

    public d.a apS() {
        return this.cSe;
    }

    private void aoJ() {
        this.ctR = System.currentTimeMillis();
        this.cSc.Fz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.h hVar) {
        this.isCacheFirstLoad = false;
        this.cGO.e(hVar);
        e(this.cGO);
        this.cSb = new ArrayList<>();
        if (this.cGO.getThreadList() != null) {
            this.cSb.addAll(this.cGO.getThreadList());
        }
        this.cXN.b(hVar);
    }

    private void e(k kVar) {
        if (com.baidu.tieba.frs.g.f.i(kVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.g.f.j(kVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.h, Void> {
        private String cYh;
        private FrsModelController cYi;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.cYh = null;
            this.cYh = str;
            this.cYi = frsModelController;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            int g;
            CustomResponsedMessage runTask;
            if (this.needCache && com.baidu.tieba.tbadkCore.c.buK().sO(this.cYh)) {
                if (!com.baidu.tieba.tbadkCore.c.buK().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.cYh)) {
                    com.baidu.tieba.tbadkCore.c.buK().getResponseData().aRo().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.h responseData = com.baidu.tieba.tbadkCore.c.buK().getResponseData();
                if (responseData.bvq() != null && !StringUtils.isNull(responseData.bvq().pK(), true) && !responseData.bvq().pK().equals("0") && responseData.bvq().pL() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bvq().pK(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
                    responseData.k(Integer.valueOf(((Integer) runTask.getData()).intValue()));
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
        public void onProgressUpdate(com.baidu.tieba.tbadkCore.h... hVarArr) {
            super.onProgressUpdate(hVarArr);
            if (this.cYi != null && hVarArr != null) {
                this.cYi.d(hVarArr.length > 0 ? hVarArr[0] : null);
                this.cYi.o(this.cYi.cXY, true);
            }
        }
    }

    public long ahq() {
        return this.ctU;
    }

    public long ahr() {
        return this.ctS;
    }

    public long ahs() {
        return this.ctT;
    }

    public long aht() {
        return this.ctR;
    }

    public boolean wA() {
        return this.cSc.wA();
    }

    public int apT() {
        return this.cXQ;
    }

    private void apU() {
        if (this.cXW == null) {
            this.cXW = new ArrayList<>();
        }
        if (this.cXW.size() == 0) {
            this.cXW.add(new x());
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, ap apVar) {
        this.bkh = c(i, null);
        if (apVar == null && (apVar = aL(i, i2)) == null) {
            if (i != 1 && l.hy() && this.cXV != null) {
                as asVar = new as();
                asVar.hasMore = false;
                asVar.pn = 1;
                asVar.forumName = this.cHb;
                asVar.cKA = false;
                if (this.cGO != null && this.cGO.aRo() != null) {
                    asVar.forumId = this.cGO.aRo().getId();
                }
                apU();
                this.cGO.aA(this.cXW);
                this.cXV.a(i, i2, asVar, this.cXW);
            }
            apVar = new ap();
            apVar.pn = -1;
        }
        if (this.cGO != null && this.cGO.aRo() != null) {
            apVar.forumId = this.cGO.aRo().getId();
        }
        apVar.forumName = this.cHb;
        if (aa.amx().jV(1) != null && this.bkh == 1) {
            this.cXM.setCategoryId(i2);
        }
        this.cXP = i2;
        this.cXR = apVar;
        b(i, i2, apVar);
        kH(5);
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(am amVar) {
        this.cXV = amVar;
        this.cXU.a(this.cYd);
    }

    private void kH(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.cXR != null) {
                    this.cXR.pn++;
                    break;
                }
                break;
            case 2:
                if (this.cXR != null) {
                    ap apVar = this.cXR;
                    apVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.cXR != null) {
                    this.cXR.pn = -1;
                    break;
                }
                break;
        }
        if (this.bkh == 1) {
            if (this.cXQ == this.cXP) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                if (this.cSb != null) {
                    arrayList.addAll(this.cSb);
                }
                this.cGO.aA(arrayList);
                if (this.cXV != null) {
                    this.cXV.a(this.bkh, this.cXP, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.cXQ = this.cXP;
            return;
        }
        ak jW = this.cXU.jW(this.bkh);
        if (jW != null) {
            this.cXS = true;
            jW.a(this.bkh, this.cXP, this.cXR);
            return;
        }
        if (this.cGO != null && this.cGO.getThreadList() != null) {
            this.cGO.getThreadList().clear();
        }
        this.cXV.a(this.bkh, this.cXP, null, null);
    }

    public boolean hasMore() {
        if ((this.cXR instanceof as) && ((as) this.cXR).errCode == 0) {
            return ((as) this.cXR).hasMore;
        }
        return true;
    }

    private int aK(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ap apVar) {
        this.cXT.put(aK(i, i2), apVar);
    }

    public ap aL(int i, int i2) {
        return this.cXT.get(aK(i, i2));
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        this.cXU.init();
    }

    @Override // com.baidu.tieba.frs.ak
    public void QJ() {
        this.cXU.destory();
        this.cXU.clear();
    }

    public int apV() {
        return this.bkh;
    }

    public boolean apW() {
        return 1 == this.bkh;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.cSb != null) {
            if (this.bkh == 1) {
                this.cGO.a(aiVar);
            }
            int apX = apX();
            if (this.cSb != null && this.cSb.size() > 0) {
                int size = this.cSb.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.f fVar = this.cSb.get(i);
                    if ((fVar instanceof bd) && aiVar.getId().equals(((bd) fVar).getId())) {
                        return;
                    }
                }
            }
            if (aiVar.getThreadType() == 33) {
                ar arVar = new ar();
                arVar.a(aiVar, -1);
                arVar.setPost_num(1);
                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.cSb.add(apX, arVar);
                    return;
                }
                return;
            }
            this.cSb.add(apX, aiVar);
        }
    }

    public int apX() {
        int i = 0;
        if (this.cSb == null || this.cSb.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.cSb.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.f next = it.next();
                if (!(next instanceof bd)) {
                    i = i2;
                } else if (((bd) next).rq() != 0) {
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

    public boolean apY() {
        return this.cXS;
    }

    public void apZ() {
        com.baidu.tieba.frs.l lVar = new com.baidu.tieba.frs.l();
        if (this.cXQ == 0) {
            lVar.jU(this.cXY);
        }
        if (this.cGO.getThreadList() != null) {
            this.cGO.getThreadList().clear();
            this.cGO.getThreadList().add(lVar);
        }
        if (this.cSb != null) {
            this.cSb.clear();
            this.cSb.add(lVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aqa() {
        return this.cSb;
    }

    public void kI(int i) {
        this.cXY = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.f.bxT();
        } else {
            com.baidu.tieba.tbadkCore.util.f.bxU();
        }
    }

    public void kJ(int i) {
        this.cXZ = i;
    }

    public void fy(boolean z) {
        this.cYa = z;
    }

    public int aqb() {
        return this.cXY;
    }

    public int Qt() {
        return com.baidu.tieba.frs.f.f.kW(this.cXY);
    }

    public boolean aqc() {
        return this.cXO;
    }

    public boolean aqd() {
        return this.cXY == 5;
    }

    public boolean aqe() {
        return this.cXM != null && this.cXM.getLoadType() == 1;
    }

    public boolean aqf() {
        return this.cXY == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.cOx.alf() != null) {
            return this.cOx.alf().a(this.cXY, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bd.YK.get() && q.blR().blL() != null) {
            int V = q.blR().blL().V(str, false);
            int W = q.blR().blL().W(str, false);
            if (frsRequestData.getLoadType() == 1) {
                V++;
            } else if (frsRequestData.getLoadType() == 2) {
                W++;
            }
            frsRequestData.setRefreshCount(V);
            frsRequestData.setLoadCount(W);
        }
    }

    public void aqg() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.cGO != null && this.cGO.aRo() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.cGO.aRo().getId(), 0L));
        }
        this.cOx.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void lw(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.buK().cc(FrsModelController.this.cYb, str);
                return null;
            }
        }, null);
    }

    public void lx(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.buK().cd(FrsModelController.this.cYb, str);
                return null;
            }
        }, null);
    }
}
