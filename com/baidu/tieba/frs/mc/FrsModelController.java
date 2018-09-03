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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.l.m;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.i>, ai {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long aTU;
    private int bup;
    private long cTu;
    private long cTv;
    private long cTw;
    private long cTx;
    private FrsNetModel<FrsFragment> dCv;
    private String dCx;
    private final n dDA;
    private boolean dDB;
    private int dDC;
    private int dDD;
    private int dDE;
    private ao dDF;
    private boolean dDG;
    private SparseArray<ao> dDH;
    private aa dDI;
    private al dDJ;
    private ArrayList<com.baidu.adp.widget.ListView.h> dDK;
    private boolean dDL;
    private String dDM;
    private int dDN;
    private int dDO;
    private boolean dDP;
    private String dDQ;
    private final SparseArray<Boolean> dDR;
    private al dDS;
    private final FrsFragment dDt;
    private ArrayList<com.baidu.adp.widget.ListView.h> dDy;
    private FrsRequestData dDz;
    private l dlQ;
    private String dmg;
    private d.a dsQ;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean ls(int i) {
        return this.dDR.get(i, false).booleanValue();
    }

    public void p(int i, boolean z) {
        this.dDR.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.dmg = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.dDC = 0;
        this.mSource = null;
        this.dCx = null;
        this.bup = 1;
        this.dDD = 0;
        this.dDE = 0;
        this.dDG = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.dDH = new SparseArray<>();
        this.aTU = 0L;
        this.dDL = false;
        this.dDN = -1;
        this.dDO = -1;
        this.dDQ = null;
        this.dDR = new SparseArray<>();
        this.dDS = new al() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.al
            public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
                FrsModelController.this.dDG = false;
                if (i == FrsModelController.this.bup && FrsModelController.this.dDJ != null) {
                    FrsModelController.this.dDF = arVar;
                    FrsModelController.this.b(i, i2, arVar);
                    ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.dlQ.ax(arrayList2);
                    FrsModelController.this.dDJ.a(i, i2, arVar, arrayList);
                }
            }
        };
        this.cTu = 0L;
        this.cTv = 0L;
        this.cTw = 0L;
        this.cTx = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.dDt = frsFragment;
        this.dDA = nVar;
        C(this.dDt);
    }

    private void C(FrsFragment frsFragment) {
        this.dDI = new aa();
        this.dDI.aRC = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.dDI));
        this.dDI.a(this.dDS);
    }

    public void onActivityDestroy() {
        this.dCv.cancelLoadData();
    }

    public void i(Bundle bundle) {
        if (bundle != null) {
            this.dmg = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dDM = bundle.getString("yuelaou_locate");
            this.dDB = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.dDC = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
        }
        if (TextUtils.isEmpty(this.dmg)) {
            this.dmg = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.dDM)) {
            this.dDM = "";
        }
        this.mSource = this.mFrom;
        this.dDz = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            lt(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            lt(6);
        } else {
            lt(com.baidu.tieba.frs.f.g.nc(this.dmg));
        }
        this.dDz.setSortType(Vo());
        if (this.dDN == 5) {
            this.dDz.setIsGood(1);
        } else {
            this.dDz.setIsGood(0);
        }
        this.dlQ = new l();
        this.dCv = new FrsNetModel<>(this.dDt.getPageContext(), this.dDz);
        this.dCv.a(this);
        this.dCv.setUniqueId(this.dDt.getUniqueId());
        if (this.dmg != null && this.dmg.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dmg);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean ako() {
        if (this.bup != 1) {
            lo(1);
            return true;
        } else if (this.dCv.AB()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dDz), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(Vo());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void q(int i, boolean z) {
        this.dDt.dmp = System.currentTimeMillis();
        if (this.dlQ != null && this.dlQ.bur() != null) {
            this.dlQ.bur().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dDz), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bup = c(this.bup, frsRequestData);
        if (this.bup == 1) {
            if (!this.dCv.AB()) {
                frsRequestData.setCallFrom(this.dDC);
                a(frsRequestData, i, z ? false : true);
                this.dDC = 0;
                return;
            }
            return;
        }
        if (this.dDF == null) {
            this.dDF = new ao();
            this.dDF.pn = 1;
            this.dDF.forumName = this.dmg;
            if (this.dlQ != null && this.dlQ.aZg() != null) {
                this.dDF.forumId = this.dlQ.aZg().getId();
            }
        }
        lo(i);
    }

    public void lp(int i) {
        if (this.bup != 1) {
            lo(4);
        } else if (!this.dCv.AB()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dDz), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(Vo());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.dDt.fx(z);
        this.dDA.kt(i);
        this.dCv.a(frsRequestData);
        this.mType = i;
        frsRequestData.tC(this.dDt.auE() ? "1" : "2");
        if (this.dDP) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.lJ(this.dDO)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.dDP = false;
        frsRequestData.setKw(this.dmg);
        if (com.baidu.tbadk.core.i.td().tj()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        int aj = com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst());
        float ak = com.baidu.adp.lib.util.l.ak(TbadkCoreApplication.getInst());
        int i2 = com.baidu.tbadk.core.util.ar.zu().zw() ? 2 : 1;
        frsRequestData.setScrW(ah);
        frsRequestData.setScrH(aj);
        frsRequestData.setScrDip(ak);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.dCx);
        frsRequestData.setYuelaouLocate(this.dDM);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(t.LA(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.dmq != 0) {
            frsRequestData.setCtime((int) FrsFragment.dmq);
        }
        if (FrsFragment.dmr != 0) {
            frsRequestData.setDataSize((int) FrsFragment.dmr);
        }
        if (FrsFragment.dms != 0) {
            frsRequestData.setNetError(FrsFragment.dms);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.g.a(this.dDN, frsRequestData);
        b(i, frsRequestData);
        a(this.dmg, frsRequestData);
        if (!ls(this.dDN) && !this.dDt.dmh) {
            String c = com.baidu.tieba.tbadkCore.c.btS().c(this.dmg, frsRequestData.Vo(), frsRequestData.getIsGood(), this.dDz.getCategoryId());
            this.dDQ = c;
            new a(this, true, c).execute(new Object[0]);
        }
        aze();
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

    protected boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.i iVar) {
        if (iVar == null || iVar.aZg() == null || (ap.isEmpty(iVar.aZg().getName()) && 340001 != iVar.dsR)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bup = iVar.buv();
        }
        this.dlQ.e(iVar);
        e(this.dlQ);
        this.dDy = new ArrayList<>();
        if (frsRequestData != null) {
            this.dDz = frsRequestData;
            this.mPn = this.dDz.getPn();
            this.dmg = this.dDz.getKw();
            this.dDt.setForumName(this.dmg);
            this.dDt.setFrom(this.mFrom);
            this.dDt.setPn(this.mPn);
            this.dDt.setFlag(this.mFlag);
        }
        if (this.dlQ.getThreadList() != null) {
            this.dDy.addAll(this.dlQ.getThreadList());
        }
        if (this.bup != 1 && this.isNetFirstLoad) {
            this.dDA.a(7, false, this.dsQ);
        } else {
            this.dDA.a(this.mType, false, this.dsQ);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.dDz)) {
            azN();
        }
        this.isNetFirstLoad = false;
        if (iVar.aZg() == null || TextUtils.isEmpty(iVar.aZg().getName()) || frsRequestData == null || r.bno().bni() == null) {
            return true;
        }
        r.bno().bni().f(iVar.aZg().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.gKD = com.baidu.adp.lib.util.j.jE() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gKE = mvcSocketResponsedMessage.getDownSize();
        this.dsQ = aVar;
        if (mvcSocketResponsedMessage == null || (mvcSocketResponsedMessage.hasError() && 340001 != mvcSocketResponsedMessage.getError())) {
            iVar = null;
        } else {
            iVar = mvcSocketResponsedMessage.getData();
            r3 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && iVar != null && a(r3, iVar)) {
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
        this.dDt.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dDL) {
            this.dDL = true;
            a(1000, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        }
        a(false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
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
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.i> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.gKD = com.baidu.adp.lib.util.j.jE() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gKE = mvcHttpResponsedMessage.getDownSize();
        this.dsQ = aVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            iVar = null;
        } else {
            iVar = mvcHttpResponsedMessage.getData();
            r3 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && iVar != null && a(r3, iVar)) {
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
        this.dDt.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        super.registerListener(i, aVar);
    }

    private void b(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.i> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
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
        if (!this.dDL) {
            this.dDL = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void auz() {
        if (this.dlQ != null && this.dlQ.aZg() != null && this.dlQ.aZg().getBannerListData() != null) {
            String lastIds = this.dlQ.aZg().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dCx = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.KJ().KK()) {
            this.aTU = System.currentTimeMillis() - this.dDt.beginTime;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(i, z, responsedMessage, this.dDt.aTL, this.dDt.createTime, this.dDt.aTT, false, this.aTU);
            this.dDt.createTime = 0L;
            this.dDt.aTL = 0L;
            if (iVar != null) {
                iVar.KG();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.KJ().KK()) {
            this.aTU = System.currentTimeMillis() - this.dDt.dmp;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(1000, z, responsedMessage, this.dDt.aTL, this.dDt.createTime, this.dDt.aTT, false, this.aTU);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.aUc = this.aTU;
                    iVar.bY(true);
                } else if (this.mType == 3) {
                    iVar.aUd = this.aTU;
                    iVar.bY(false);
                }
            }
        }
    }

    public FrsRequestData azy() {
        return this.dDz;
    }

    public String getPageType() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.dmg;
    }

    public int getPn() {
        return this.mPn;
    }

    public l azd() {
        return this.dlQ;
    }

    public d.a azz() {
        return this.dsQ;
    }

    private void aze() {
        this.cTu = System.currentTimeMillis();
        this.dCv.JV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.dlQ.e(iVar);
        e(this.dlQ);
        this.dDy = new ArrayList<>();
        if (this.dlQ.getThreadList() != null) {
            this.dDy.addAll(this.dlQ.getThreadList());
        }
        this.dDA.b(iVar);
    }

    private void e(l lVar) {
        if (com.baidu.tieba.frs.vc.f.j(lVar)) {
            this.mPageType = "book_page";
        } else if (lVar.bva()) {
            this.mPageType = "brand_page";
        } else if (com.baidu.tieba.frs.vc.f.k(lVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.i, Void> {
        private String dDW;
        private FrsModelController dDX;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.dDW = null;
            this.dDW = str;
            this.dDX = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.btS().tA(this.dDW)) {
                if (!com.baidu.tieba.tbadkCore.c.btS().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.dDW)) {
                    com.baidu.tieba.tbadkCore.c.btS().getResponseData().aZg().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.i responseData = com.baidu.tieba.tbadkCore.c.btS().getResponseData();
                responseData.mo(false);
                if (responseData.bux() != null && !StringUtils.isNull(responseData.bux().tM(), true) && !responseData.bux().tM().equals("0") && responseData.bux().tN() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bux().tM(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(g))) != null) {
                    responseData.q(Integer.valueOf(((Integer) runTask.getData()).intValue()));
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
        public void onProgressUpdate(com.baidu.tieba.tbadkCore.i... iVarArr) {
            super.onProgressUpdate(iVarArr);
            if (this.dDX != null && iVarArr != null) {
                this.dDX.d(iVarArr.length > 0 ? iVarArr[0] : null);
                this.dDX.p(this.dDX.dDN, true);
            }
        }
    }

    public long apc() {
        return this.cTx;
    }

    public long apd() {
        return this.cTv;
    }

    public long ape() {
        return this.cTw;
    }

    public long apf() {
        return this.cTu;
    }

    public boolean AB() {
        return this.dCv.AB();
    }

    public int azA() {
        return this.dDE;
    }

    private void azB() {
        if (this.dDK == null) {
            this.dDK = new ArrayList<>();
        }
        if (this.dDK.size() == 0) {
            this.dDK.add(new v());
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        this.bup = c(i, null);
        if (aoVar == null && (aoVar = aN(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.jV() && this.dDJ != null) {
                ar arVar = new ar();
                arVar.hasMore = false;
                arVar.pn = 1;
                arVar.forumName = this.dmg;
                arVar.dpO = false;
                if (this.dlQ != null && this.dlQ.aZg() != null) {
                    arVar.forumId = this.dlQ.aZg().getId();
                }
                azB();
                this.dlQ.ax(this.dDK);
                this.dDJ.a(i, i2, arVar, this.dDK);
            }
            aoVar = new ao();
            aoVar.pn = -1;
        }
        if (this.dlQ != null && this.dlQ.aZg() != null) {
            aoVar.forumId = this.dlQ.aZg().getId();
        }
        aoVar.forumName = this.dmg;
        if (y.avH().kE(1) != null && this.bup == 1) {
            this.dDz.setCategoryId(i2);
        }
        this.dDD = i2;
        this.dDF = aoVar;
        b(i, i2, aoVar);
        lo(5);
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.dDJ = alVar;
        this.dDI.a(this.dDS);
    }

    private void lo(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.dDF != null) {
                    this.dDF.pn++;
                    break;
                }
                break;
            case 2:
                if (this.dDF != null) {
                    ao aoVar = this.dDF;
                    aoVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.dDF != null) {
                    this.dDF.pn = -1;
                    break;
                }
                break;
        }
        if (this.bup == 1) {
            if (this.dDE == this.dDD) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                if (this.dDy != null) {
                    arrayList.addAll(this.dDy);
                }
                this.dlQ.ax(arrayList);
                if (this.dDJ != null) {
                    this.dDJ.a(this.bup, this.dDD, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.dDE = this.dDD;
            return;
        }
        ai kF = this.dDI.kF(this.bup);
        if (kF != null) {
            this.dDG = true;
            kF.a(this.bup, this.dDD, this.dDF);
            return;
        }
        if (this.dlQ != null && this.dlQ.getThreadList() != null) {
            this.dlQ.getThreadList().clear();
        }
        this.dDJ.a(this.bup, this.dDD, null, null);
    }

    public boolean hasMore() {
        if ((this.dDF instanceof ar) && ((ar) this.dDF).errCode == 0) {
            return ((ar) this.dDF).hasMore;
        }
        return true;
    }

    private int aM(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ao aoVar) {
        this.dDH.put(aM(i, i2), aoVar);
    }

    public ao aN(int i, int i2) {
        return this.dDH.get(aM(i, i2));
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        this.dDI.init();
    }

    @Override // com.baidu.tieba.frs.ai
    public void VA() {
        this.dDI.destory();
        this.dDI.clear();
    }

    public int azC() {
        return this.bup;
    }

    public boolean azD() {
        return 1 == this.bup;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(com.baidu.tbadk.core.data.ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && !w.z(this.dDy)) {
            if (this.bup == 1) {
                this.dlQ.a(aiVar);
            }
            int azE = azE();
            Iterator<com.baidu.adp.widget.ListView.h> it = this.dDy.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if ((next instanceof bb) && aiVar.getId().equals(((bb) next).getId())) {
                    return;
                }
            }
            this.dDy.add(azE, aiVar);
        }
    }

    public int azE() {
        int i = 0;
        if (this.dDy == null || this.dDy.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.dDy.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (!(next instanceof bb)) {
                    i = i2;
                } else if (((bb) next).ve() != 0) {
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

    public boolean azF() {
        return this.dDG;
    }

    public void azG() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.dDE == 0) {
            mVar.kD(this.dDN);
        }
        if (this.dlQ.getThreadList() != null) {
            this.dlQ.getThreadList().clear();
            this.dlQ.getThreadList().add(mVar);
        }
        if (this.dDy != null) {
            this.dDy.clear();
            this.dDy.add(mVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> azH() {
        return this.dDy;
    }

    public void lt(int i) {
        this.dDN = i;
        com.baidu.tieba.frs.f.g.U(this.dmg, this.dDN);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.bxg();
        } else {
            com.baidu.tieba.tbadkCore.util.e.bxh();
        }
    }

    public void lu(int i) {
        this.dDO = i;
    }

    public void gl(boolean z) {
        this.dDP = z;
    }

    public int azI() {
        return this.dDN;
    }

    public int Vo() {
        return com.baidu.tieba.frs.f.g.lJ(this.dDN);
    }

    public boolean azJ() {
        return this.dDB;
    }

    public boolean azK() {
        return this.dDN == 5;
    }

    public boolean azL() {
        return this.dDz != null && this.dDz.getLoadType() == 1;
    }

    public boolean azM() {
        return this.dDN == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.dDt.auc() != null) {
            return this.dDt.auc().a(this.dDN, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bb.ahJ.get() && r.bno().bni() != null) {
            int Q = r.bno().bni().Q(str, false);
            int R = r.bno().bni().R(str, false);
            if (frsRequestData.getLoadType() == 1) {
                Q++;
            } else if (frsRequestData.getLoadType() == 2) {
                R++;
            }
            frsRequestData.setRefreshCount(Q);
            frsRequestData.setLoadCount(R);
        }
    }

    public void azN() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.dlQ != null && this.dlQ.aZg() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.dlQ.aZg().getId(), 0L));
        }
        this.dDt.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void mU(final String str) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.btS().ch(FrsModelController.this.dDQ, str);
                return null;
            }
        }, null);
    }

    public void mV(final String str) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.btS().ci(FrsModelController.this.dDQ, str);
                return null;
            }
        }, null);
    }

    public void mW(final String str) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.btS().cj(FrsModelController.this.dDQ, str);
                return null;
            }
        }, null);
    }
}
