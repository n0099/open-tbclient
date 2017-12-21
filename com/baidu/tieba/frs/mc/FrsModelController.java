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
    private long aKA;
    private int bkl;
    private k cGS;
    private String cHf;
    private final com.baidu.tieba.frs.g cOB;
    private ArrayList<com.baidu.adp.widget.ListView.f> cSf;
    private FrsNetModel<com.baidu.tieba.frs.g> cSg;
    private d.a cSi;
    private String cSj;
    private boolean cSm;
    private FrsRequestData cXQ;
    private final m cXR;
    private boolean cXS;
    private int cXT;
    private int cXU;
    private ap cXV;
    private boolean cXW;
    private SparseArray<ap> cXX;
    private ac cXY;
    private am cXZ;
    private ArrayList<com.baidu.adp.widget.ListView.f> cYa;
    private String cYb;
    private int cYc;
    private int cYd;
    private boolean cYe;
    private String cYf;
    private final SparseArray<Boolean> cYg;
    private am cYh;
    private long ctV;
    private long ctW;
    private long ctX;
    private long ctY;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean kG(int i) {
        return this.cYg.get(i, false).booleanValue();
    }

    public void o(int i, boolean z) {
        this.cYg.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.g gVar, m mVar) {
        super(gVar.getPageContext());
        this.cHf = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.cSj = null;
        this.bkl = 1;
        this.cXT = 0;
        this.cXU = 0;
        this.cXW = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.cXX = new SparseArray<>();
        this.aKA = 0L;
        this.cSm = false;
        this.cYc = -1;
        this.cYd = -1;
        this.cYf = null;
        this.cYg = new SparseArray<>();
        this.cYh = new am() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.am
            public void a(int i, int i2, as asVar, ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
                FrsModelController.this.cXW = false;
                if (i == FrsModelController.this.bkl && FrsModelController.this.cXZ != null) {
                    FrsModelController.this.cXV = asVar;
                    FrsModelController.this.b(i, i2, asVar);
                    ArrayList<com.baidu.adp.widget.ListView.f> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.cGS.aA(arrayList2);
                    if ((i == 1 || i == 5) && !FrsModelController.this.aqf()) {
                        FrsModelController.this.cGS.bvO();
                        FrsModelController.this.cGS.bvP();
                    }
                    FrsModelController.this.cXZ.a(i, i2, asVar, arrayList);
                }
            }
        };
        this.ctV = 0L;
        this.ctW = 0L;
        this.ctX = 0L;
        this.ctY = 0L;
        if (gVar == null || mVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.cOB = gVar;
        this.cXR = mVar;
        A(this.cOB);
    }

    private void A(com.baidu.tieba.frs.g gVar) {
        this.cXY = new ac();
        this.cXY.aSB = gVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.cXY));
        this.cXY.a(this.cYh);
    }

    public void onActivityDestroy() {
        this.cSg.cancelLoadData();
    }

    public void h(Bundle bundle) {
        if (bundle != null) {
            this.cHf = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.cYb = bundle.getString("yuelaou_locate");
            this.cXS = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.cHf)) {
            this.cHf = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.cYb)) {
            this.cYb = "";
        }
        this.mSource = this.mFrom;
        this.cXQ = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            kI(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            kI(6);
        } else {
            com.baidu.tieba.frs.smartsort.f lD = com.baidu.tieba.frs.smartsort.d.aqr().lD(this.cHf);
            if (lD != null) {
                kI(lD.cYR);
            } else {
                kI(-1);
            }
        }
        this.cXQ.setSortType(Qt());
        if (this.cYc == 5) {
            this.cXQ.setIsGood(1);
        } else {
            this.cXQ.setIsGood(0);
        }
        this.cGS = new k();
        this.cSg = new FrsNetModel<>(this.cOB.getPageContext(), this.cXQ);
        this.cSg.a(this);
        this.cSg.setUniqueId(this.cOB.getUniqueId());
        if (this.cHf != null && this.cHf.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.cHf);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean adq() {
        if (this.bkl != 1) {
            kH(1);
            return true;
        } else if (this.cSg.wA()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cXQ), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(Qt());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void p(int i, boolean z) {
        if (this.cGS != null && this.cGS.bvk() != null) {
            this.cGS.bvk().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cXQ), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bkl = c(this.bkl, frsRequestData);
        if (this.bkl == 1) {
            if (!this.cSg.wA()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.cXV == null) {
            this.cXV = new ap();
            this.cXV.pn = 1;
            this.cXV.forumName = this.cHf;
            if (this.cGS != null && this.cGS.aRo() != null) {
                this.cXV.forumId = this.cGS.aRo().getId();
            }
        }
        kH(i);
    }

    public void ks(int i) {
        if (this.bkl != 1) {
            kH(4);
        } else if (!this.cSg.wA()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cXQ), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(Qt());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.cXR.jP(i);
        this.cSg.a(frsRequestData);
        this.mType = i;
        frsRequestData.sQ(this.cOB.alH() ? "1" : "2");
        if (this.cYe) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.f.kW(this.cYd)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.cYe = false;
        frsRequestData.setKw(this.cHf);
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
        frsRequestData.setLastId(this.cSj);
        frsRequestData.setYuelaouLocate(this.cYb);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(t.Ht(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.g.cHn != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.g.cHn);
        }
        if (com.baidu.tieba.frs.g.cHo != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.g.cHo);
        }
        if (com.baidu.tieba.frs.g.cHp != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.g.cHp);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.f.a(this.cYc, frsRequestData);
        b(i, frsRequestData);
        a(this.cHf, frsRequestData);
        if (!kG(this.cYc)) {
            String d = com.baidu.tieba.tbadkCore.c.buK().d(this.cHf, frsRequestData.Qt(), frsRequestData.getIsGood(), this.cXQ.getCategoryId());
            this.cYf = d;
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
        if (hVar == null || hVar.aRo() == null || (com.baidu.tbadk.core.util.am.isEmpty(hVar.aRo().getName()) && 340001 != hVar.gAn)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bkl = hVar.bvo();
        }
        this.cGS.e(hVar);
        e(this.cGS);
        this.cSf = new ArrayList<>();
        if (frsRequestData != null) {
            this.cXQ = frsRequestData;
            this.mPn = this.cXQ.getPn();
            this.cHf = this.cXQ.getKw();
            this.cOB.setForumName(this.cHf);
            this.cOB.setFrom(this.mFrom);
            this.cOB.setPn(this.mPn);
            this.cOB.setFlag(this.mFlag);
        }
        if (this.cGS.getThreadList() != null) {
            this.cSf.addAll(this.cGS.getThreadList());
        }
        if (this.bkl != 1 && this.isNetFirstLoad) {
            this.cXR.a(7, false, this.cSi);
        } else {
            this.cXR.a(this.mType, false, this.cSi);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.cXQ)) {
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
        aVar.gyL = com.baidu.adp.lib.util.j.hh() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gyM = mvcSocketResponsedMessage.getDownSize();
        this.cSi = aVar;
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
        this.cOB.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.h, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.h> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.h> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.cSm) {
            this.cSm = true;
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
        aVar.gyL = com.baidu.adp.lib.util.j.hh() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gyM = mvcHttpResponsedMessage.getDownSize();
        this.cSi = aVar;
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
        this.cOB.a(errorData);
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
        if (!this.cSm) {
            this.cSm = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void alA() {
        if (this.cGS != null && this.cGS.aRo() != null && this.cGS.aRo().getBannerListData() != null) {
            String lastIds = this.cGS.aRo().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.cSj = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (r.GB().GC()) {
            this.aKA = System.currentTimeMillis() - this.cOB.beginTime;
            com.baidu.tbadk.k.m mVar = new com.baidu.tbadk.k.m(i, z, responsedMessage, this.cOB.aKr, this.cOB.createTime, this.cOB.aKz, false, this.aKA);
            this.cOB.createTime = 0L;
            this.cOB.aKr = 0L;
            if (mVar != null) {
                mVar.Gw();
            }
        }
    }

    public FrsRequestData apQ() {
        return this.cXQ;
    }

    public String apR() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.cHf;
    }

    public int getPn() {
        return this.mPn;
    }

    public k aoI() {
        return this.cGS;
    }

    public d.a apS() {
        return this.cSi;
    }

    private void aoJ() {
        this.ctV = System.currentTimeMillis();
        this.cSg.Fz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.h hVar) {
        this.isCacheFirstLoad = false;
        this.cGS.e(hVar);
        e(this.cGS);
        this.cSf = new ArrayList<>();
        if (this.cGS.getThreadList() != null) {
            this.cSf.addAll(this.cGS.getThreadList());
        }
        this.cXR.b(hVar);
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
        private String cYl;
        private FrsModelController cYm;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.cYl = null;
            this.cYl = str;
            this.cYm = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.buK().sO(this.cYl)) {
                if (!com.baidu.tieba.tbadkCore.c.buK().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.cYl)) {
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
            if (this.cYm != null && hVarArr != null) {
                this.cYm.d(hVarArr.length > 0 ? hVarArr[0] : null);
                this.cYm.o(this.cYm.cYc, true);
            }
        }
    }

    public long ahp() {
        return this.ctY;
    }

    public long ahq() {
        return this.ctW;
    }

    public long ahr() {
        return this.ctX;
    }

    public long ahs() {
        return this.ctV;
    }

    public boolean wA() {
        return this.cSg.wA();
    }

    public int apT() {
        return this.cXU;
    }

    private void apU() {
        if (this.cYa == null) {
            this.cYa = new ArrayList<>();
        }
        if (this.cYa.size() == 0) {
            this.cYa.add(new x());
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, ap apVar) {
        this.bkl = c(i, null);
        if (apVar == null && (apVar = aL(i, i2)) == null) {
            if (i != 1 && l.hy() && this.cXZ != null) {
                as asVar = new as();
                asVar.hasMore = false;
                asVar.pn = 1;
                asVar.forumName = this.cHf;
                asVar.cKE = false;
                if (this.cGS != null && this.cGS.aRo() != null) {
                    asVar.forumId = this.cGS.aRo().getId();
                }
                apU();
                this.cGS.aA(this.cYa);
                this.cXZ.a(i, i2, asVar, this.cYa);
            }
            apVar = new ap();
            apVar.pn = -1;
        }
        if (this.cGS != null && this.cGS.aRo() != null) {
            apVar.forumId = this.cGS.aRo().getId();
        }
        apVar.forumName = this.cHf;
        if (aa.amx().jV(1) != null && this.bkl == 1) {
            this.cXQ.setCategoryId(i2);
        }
        this.cXT = i2;
        this.cXV = apVar;
        b(i, i2, apVar);
        kH(5);
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(am amVar) {
        this.cXZ = amVar;
        this.cXY.a(this.cYh);
    }

    private void kH(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.cXV != null) {
                    this.cXV.pn++;
                    break;
                }
                break;
            case 2:
                if (this.cXV != null) {
                    ap apVar = this.cXV;
                    apVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.cXV != null) {
                    this.cXV.pn = -1;
                    break;
                }
                break;
        }
        if (this.bkl == 1) {
            if (this.cXU == this.cXT) {
                ArrayList<com.baidu.adp.widget.ListView.f> arrayList = new ArrayList<>();
                if (this.cSf != null) {
                    arrayList.addAll(this.cSf);
                }
                this.cGS.aA(arrayList);
                if (this.cXZ != null) {
                    this.cXZ.a(this.bkl, this.cXT, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.cXU = this.cXT;
            return;
        }
        ak jW = this.cXY.jW(this.bkl);
        if (jW != null) {
            this.cXW = true;
            jW.a(this.bkl, this.cXT, this.cXV);
            return;
        }
        if (this.cGS != null && this.cGS.getThreadList() != null) {
            this.cGS.getThreadList().clear();
        }
        this.cXZ.a(this.bkl, this.cXT, null, null);
    }

    public boolean hasMore() {
        if ((this.cXV instanceof as) && ((as) this.cXV).errCode == 0) {
            return ((as) this.cXV).hasMore;
        }
        return true;
    }

    private int aK(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ap apVar) {
        this.cXX.put(aK(i, i2), apVar);
    }

    public ap aL(int i, int i2) {
        return this.cXX.get(aK(i, i2));
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        this.cXY.init();
    }

    @Override // com.baidu.tieba.frs.ak
    public void QJ() {
        this.cXY.destory();
        this.cXY.clear();
    }

    public int apV() {
        return this.bkl;
    }

    public boolean apW() {
        return 1 == this.bkl;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.cSf != null) {
            if (this.bkl == 1) {
                this.cGS.a(aiVar);
            }
            int apX = apX();
            if (this.cSf != null && this.cSf.size() > 0) {
                int size = this.cSf.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.f fVar = this.cSf.get(i);
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
                    this.cSf.add(apX, arVar);
                    return;
                }
                return;
            }
            this.cSf.add(apX, aiVar);
        }
    }

    public int apX() {
        int i = 0;
        if (this.cSf == null || this.cSf.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.f> it = this.cSf.iterator();
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
        return this.cXW;
    }

    public void apZ() {
        com.baidu.tieba.frs.l lVar = new com.baidu.tieba.frs.l();
        if (this.cXU == 0) {
            lVar.jU(this.cYc);
        }
        if (this.cGS.getThreadList() != null) {
            this.cGS.getThreadList().clear();
            this.cGS.getThreadList().add(lVar);
        }
        if (this.cSf != null) {
            this.cSf.clear();
            this.cSf.add(lVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aqa() {
        return this.cSf;
    }

    public void kI(int i) {
        this.cYc = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.f.bxT();
        } else {
            com.baidu.tieba.tbadkCore.util.f.bxU();
        }
    }

    public void kJ(int i) {
        this.cYd = i;
    }

    public void fy(boolean z) {
        this.cYe = z;
    }

    public int aqb() {
        return this.cYc;
    }

    public int Qt() {
        return com.baidu.tieba.frs.f.f.kW(this.cYc);
    }

    public boolean aqc() {
        return this.cXS;
    }

    public boolean aqd() {
        return this.cYc == 5;
    }

    public boolean aqe() {
        return this.cXQ != null && this.cXQ.getLoadType() == 1;
    }

    public boolean aqf() {
        return this.cYc == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.cOB.ale() != null) {
            return this.cOB.ale().a(this.cYc, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bd.YN.get() && q.blR().blL() != null) {
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
        if (this.cGS != null && this.cGS.aRo() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.cGS.aRo().getId(), 0L));
        }
        this.cOB.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void lw(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.buK().cc(FrsModelController.this.cYf, str);
                return null;
            }
        }, null);
    }

    public void lx(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.buK().cd(FrsModelController.this.cYf, str);
                return null;
            }
        }, null);
    }
}
