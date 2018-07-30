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
    private int bun;
    private long cTA;
    private long cTB;
    private long cTy;
    private long cTz;
    private String dCA;
    private FrsNetModel<FrsFragment> dCy;
    private ArrayList<com.baidu.adp.widget.ListView.h> dDB;
    private FrsRequestData dDC;
    private final n dDD;
    private boolean dDE;
    private int dDF;
    private int dDG;
    private int dDH;
    private ao dDI;
    private boolean dDJ;
    private SparseArray<ao> dDK;
    private aa dDL;
    private al dDM;
    private ArrayList<com.baidu.adp.widget.ListView.h> dDN;
    private boolean dDO;
    private String dDP;
    private int dDQ;
    private int dDR;
    private boolean dDS;
    private String dDT;
    private final SparseArray<Boolean> dDU;
    private al dDV;
    private final FrsFragment dDw;
    private l dlS;
    private String dmi;
    private d.a dsT;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean ls(int i) {
        return this.dDU.get(i, false).booleanValue();
    }

    public void p(int i, boolean z) {
        this.dDU.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.dmi = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.dDF = 0;
        this.mSource = null;
        this.dCA = null;
        this.bun = 1;
        this.dDG = 0;
        this.dDH = 0;
        this.dDJ = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.dDK = new SparseArray<>();
        this.aTU = 0L;
        this.dDO = false;
        this.dDQ = -1;
        this.dDR = -1;
        this.dDT = null;
        this.dDU = new SparseArray<>();
        this.dDV = new al() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.al
            public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
                FrsModelController.this.dDJ = false;
                if (i == FrsModelController.this.bun && FrsModelController.this.dDM != null) {
                    FrsModelController.this.dDI = arVar;
                    FrsModelController.this.b(i, i2, arVar);
                    ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.dlS.ax(arrayList2);
                    FrsModelController.this.dDM.a(i, i2, arVar, arrayList);
                }
            }
        };
        this.cTy = 0L;
        this.cTz = 0L;
        this.cTA = 0L;
        this.cTB = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.dDw = frsFragment;
        this.dDD = nVar;
        C(this.dDw);
    }

    private void C(FrsFragment frsFragment) {
        this.dDL = new aa();
        this.dDL.aRF = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.dDL));
        this.dDL.a(this.dDV);
    }

    public void onActivityDestroy() {
        this.dCy.cancelLoadData();
    }

    public void i(Bundle bundle) {
        if (bundle != null) {
            this.dmi = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dDP = bundle.getString("yuelaou_locate");
            this.dDE = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.dDF = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
        }
        if (TextUtils.isEmpty(this.dmi)) {
            this.dmi = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.dDP)) {
            this.dDP = "";
        }
        this.mSource = this.mFrom;
        this.dDC = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            lt(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            lt(6);
        } else {
            lt(com.baidu.tieba.frs.f.g.na(this.dmi));
        }
        this.dDC.setSortType(Vk());
        if (this.dDQ == 5) {
            this.dDC.setIsGood(1);
        } else {
            this.dDC.setIsGood(0);
        }
        this.dlS = new l();
        this.dCy = new FrsNetModel<>(this.dDw.getPageContext(), this.dDC);
        this.dCy.a(this);
        this.dCy.setUniqueId(this.dDw.getUniqueId());
        if (this.dmi != null && this.dmi.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dmi);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean akm() {
        if (this.bun != 1) {
            lo(1);
            return true;
        } else if (this.dCy.AE()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dDC), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(Vk());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void q(int i, boolean z) {
        this.dDw.dmr = System.currentTimeMillis();
        if (this.dlS != null && this.dlS.buq() != null) {
            this.dlS.buq().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dDC), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bun = c(this.bun, frsRequestData);
        if (this.bun == 1) {
            if (!this.dCy.AE()) {
                frsRequestData.setCallFrom(this.dDF);
                a(frsRequestData, i, z ? false : true);
                this.dDF = 0;
                return;
            }
            return;
        }
        if (this.dDI == null) {
            this.dDI = new ao();
            this.dDI.pn = 1;
            this.dDI.forumName = this.dmi;
            if (this.dlS != null && this.dlS.aZl() != null) {
                this.dDI.forumId = this.dlS.aZl().getId();
            }
        }
        lo(i);
    }

    public void lp(int i) {
        if (this.bun != 1) {
            lo(4);
        } else if (!this.dCy.AE()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dDC), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(Vk());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.dDw.fx(z);
        this.dDD.ku(i);
        this.dCy.a(frsRequestData);
        this.mType = i;
        frsRequestData.ty(this.dDw.auF() ? "1" : "2");
        if (this.dDS) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.lJ(this.dDR)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.dDS = false;
        frsRequestData.setKw(this.dmi);
        if (com.baidu.tbadk.core.i.te().tk()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        int aj = com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst());
        float ak = com.baidu.adp.lib.util.l.ak(TbadkCoreApplication.getInst());
        int i2 = com.baidu.tbadk.core.util.ar.zw().zy() ? 2 : 1;
        frsRequestData.setScrW(ah);
        frsRequestData.setScrH(aj);
        frsRequestData.setScrDip(ak);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.dCA);
        frsRequestData.setYuelaouLocate(this.dDP);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(t.Lw(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.dms != 0) {
            frsRequestData.setCtime((int) FrsFragment.dms);
        }
        if (FrsFragment.dmt != 0) {
            frsRequestData.setDataSize((int) FrsFragment.dmt);
        }
        if (FrsFragment.dmu != 0) {
            frsRequestData.setNetError(FrsFragment.dmu);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.g.a(this.dDQ, frsRequestData);
        b(i, frsRequestData);
        a(this.dmi, frsRequestData);
        if (!ls(this.dDQ) && !this.dDw.dmj) {
            String c = com.baidu.tieba.tbadkCore.c.btR().c(this.dmi, frsRequestData.Vk(), frsRequestData.getIsGood(), this.dDC.getCategoryId());
            this.dDT = c;
            new a(this, true, c).execute(new Object[0]);
        }
        azg();
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
        if (iVar == null || iVar.aZl() == null || (ap.isEmpty(iVar.aZl().getName()) && 340001 != iVar.dsU)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bun = iVar.buu();
        }
        this.dlS.e(iVar);
        e(this.dlS);
        this.dDB = new ArrayList<>();
        if (frsRequestData != null) {
            this.dDC = frsRequestData;
            this.mPn = this.dDC.getPn();
            this.dmi = this.dDC.getKw();
            this.dDw.setForumName(this.dmi);
            this.dDw.setFrom(this.mFrom);
            this.dDw.setPn(this.mPn);
            this.dDw.setFlag(this.mFlag);
        }
        if (this.dlS.getThreadList() != null) {
            this.dDB.addAll(this.dlS.getThreadList());
        }
        if (this.bun != 1 && this.isNetFirstLoad) {
            this.dDD.a(7, false, this.dsT);
        } else {
            this.dDD.a(this.mType, false, this.dsT);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.dDC)) {
            azQ();
        }
        this.isNetFirstLoad = false;
        if (iVar.aZl() == null || TextUtils.isEmpty(iVar.aZl().getName()) || frsRequestData == null || r.bnn().bnh() == null) {
            return true;
        }
        r.bnn().bnh().f(iVar.aZl().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.gKB = com.baidu.adp.lib.util.j.jE() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gKC = mvcSocketResponsedMessage.getDownSize();
        this.dsT = aVar;
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
        this.dDw.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dDO) {
            this.dDO = true;
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
        aVar.gKB = com.baidu.adp.lib.util.j.jE() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gKC = mvcHttpResponsedMessage.getDownSize();
        this.dsT = aVar;
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
        this.dDw.a(errorData);
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
        if (!this.dDO) {
            this.dDO = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void auA() {
        if (this.dlS != null && this.dlS.aZl() != null && this.dlS.aZl().getBannerListData() != null) {
            String lastIds = this.dlS.aZl().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dCA = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.KF().KG()) {
            this.aTU = System.currentTimeMillis() - this.dDw.beginTime;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(i, z, responsedMessage, this.dDw.aTL, this.dDw.createTime, this.dDw.aTT, false, this.aTU);
            this.dDw.createTime = 0L;
            this.dDw.aTL = 0L;
            if (iVar != null) {
                iVar.KC();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.KF().KG()) {
            this.aTU = System.currentTimeMillis() - this.dDw.dmr;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(1000, z, responsedMessage, this.dDw.aTL, this.dDw.createTime, this.dDw.aTT, false, this.aTU);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.aUc = this.aTU;
                    iVar.bX(true);
                } else if (this.mType == 3) {
                    iVar.aUd = this.aTU;
                    iVar.bX(false);
                }
            }
        }
    }

    public FrsRequestData azA() {
        return this.dDC;
    }

    public String azB() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.dmi;
    }

    public int getPn() {
        return this.mPn;
    }

    public l azf() {
        return this.dlS;
    }

    public d.a azC() {
        return this.dsT;
    }

    private void azg() {
        this.cTy = System.currentTimeMillis();
        this.dCy.JR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.dlS.e(iVar);
        e(this.dlS);
        this.dDB = new ArrayList<>();
        if (this.dlS.getThreadList() != null) {
            this.dDB.addAll(this.dlS.getThreadList());
        }
        this.dDD.b(iVar);
    }

    private void e(l lVar) {
        if (com.baidu.tieba.frs.vc.f.j(lVar)) {
            this.mPageType = "book_page";
        } else if (lVar.buZ()) {
            this.mPageType = "brand_page";
        } else if (com.baidu.tieba.frs.vc.f.k(lVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.i, Void> {
        private String dDZ;
        private FrsModelController dEa;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.dDZ = null;
            this.dDZ = str;
            this.dEa = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.btR().tw(this.dDZ)) {
                if (!com.baidu.tieba.tbadkCore.c.btR().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.dDZ)) {
                    com.baidu.tieba.tbadkCore.c.btR().getResponseData().aZl().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.i responseData = com.baidu.tieba.tbadkCore.c.btR().getResponseData();
                responseData.mo(false);
                if (responseData.buw() != null && !StringUtils.isNull(responseData.buw().tN(), true) && !responseData.buw().tN().equals("0") && responseData.buw().tO() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.buw().tN(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(g))) != null) {
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
            if (this.dEa != null && iVarArr != null) {
                this.dEa.d(iVarArr.length > 0 ? iVarArr[0] : null);
                this.dEa.p(this.dEa.dDQ, true);
            }
        }
    }

    public long apc() {
        return this.cTB;
    }

    public long apd() {
        return this.cTz;
    }

    public long ape() {
        return this.cTA;
    }

    public long apf() {
        return this.cTy;
    }

    public boolean AE() {
        return this.dCy.AE();
    }

    public int azD() {
        return this.dDH;
    }

    private void azE() {
        if (this.dDN == null) {
            this.dDN = new ArrayList<>();
        }
        if (this.dDN.size() == 0) {
            this.dDN.add(new v());
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        this.bun = c(i, null);
        if (aoVar == null && (aoVar = aN(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.jV() && this.dDM != null) {
                ar arVar = new ar();
                arVar.hasMore = false;
                arVar.pn = 1;
                arVar.forumName = this.dmi;
                arVar.dpQ = false;
                if (this.dlS != null && this.dlS.aZl() != null) {
                    arVar.forumId = this.dlS.aZl().getId();
                }
                azE();
                this.dlS.ax(this.dDN);
                this.dDM.a(i, i2, arVar, this.dDN);
            }
            aoVar = new ao();
            aoVar.pn = -1;
        }
        if (this.dlS != null && this.dlS.aZl() != null) {
            aoVar.forumId = this.dlS.aZl().getId();
        }
        aoVar.forumName = this.dmi;
        if (y.avI().kF(1) != null && this.bun == 1) {
            this.dDC.setCategoryId(i2);
        }
        this.dDG = i2;
        this.dDI = aoVar;
        b(i, i2, aoVar);
        lo(5);
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.dDM = alVar;
        this.dDL.a(this.dDV);
    }

    private void lo(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.dDI != null) {
                    this.dDI.pn++;
                    break;
                }
                break;
            case 2:
                if (this.dDI != null) {
                    ao aoVar = this.dDI;
                    aoVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.dDI != null) {
                    this.dDI.pn = -1;
                    break;
                }
                break;
        }
        if (this.bun == 1) {
            if (this.dDH == this.dDG) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                if (this.dDB != null) {
                    arrayList.addAll(this.dDB);
                }
                this.dlS.ax(arrayList);
                if (this.dDM != null) {
                    this.dDM.a(this.bun, this.dDG, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.dDH = this.dDG;
            return;
        }
        ai kG = this.dDL.kG(this.bun);
        if (kG != null) {
            this.dDJ = true;
            kG.a(this.bun, this.dDG, this.dDI);
            return;
        }
        if (this.dlS != null && this.dlS.getThreadList() != null) {
            this.dlS.getThreadList().clear();
        }
        this.dDM.a(this.bun, this.dDG, null, null);
    }

    public boolean hasMore() {
        if ((this.dDI instanceof ar) && ((ar) this.dDI).errCode == 0) {
            return ((ar) this.dDI).hasMore;
        }
        return true;
    }

    private int aM(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ao aoVar) {
        this.dDK.put(aM(i, i2), aoVar);
    }

    public ao aN(int i, int i2) {
        return this.dDK.get(aM(i, i2));
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        this.dDL.init();
    }

    @Override // com.baidu.tieba.frs.ai
    public void Vx() {
        this.dDL.destory();
        this.dDL.clear();
    }

    public int azF() {
        return this.bun;
    }

    public boolean azG() {
        return 1 == this.bun;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(com.baidu.tbadk.core.data.ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && !w.z(this.dDB)) {
            if (this.bun == 1) {
                this.dlS.a(aiVar);
            }
            int azH = azH();
            Iterator<com.baidu.adp.widget.ListView.h> it = this.dDB.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if ((next instanceof bb) && aiVar.getId().equals(((bb) next).getId())) {
                    return;
                }
            }
            this.dDB.add(azH, aiVar);
        }
    }

    public int azH() {
        int i = 0;
        if (this.dDB == null || this.dDB.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.dDB.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (!(next instanceof bb)) {
                    i = i2;
                } else if (((bb) next).vf() != 0) {
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

    public boolean azI() {
        return this.dDJ;
    }

    public void azJ() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.dDH == 0) {
            mVar.kE(this.dDQ);
        }
        if (this.dlS.getThreadList() != null) {
            this.dlS.getThreadList().clear();
            this.dlS.getThreadList().add(mVar);
        }
        if (this.dDB != null) {
            this.dDB.clear();
            this.dDB.add(mVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> azK() {
        return this.dDB;
    }

    public void lt(int i) {
        this.dDQ = i;
        com.baidu.tieba.frs.f.g.U(this.dmi, this.dDQ);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.bxf();
        } else {
            com.baidu.tieba.tbadkCore.util.e.bxg();
        }
    }

    public void lu(int i) {
        this.dDR = i;
    }

    public void gl(boolean z) {
        this.dDS = z;
    }

    public int azL() {
        return this.dDQ;
    }

    public int Vk() {
        return com.baidu.tieba.frs.f.g.lJ(this.dDQ);
    }

    public boolean azM() {
        return this.dDE;
    }

    public boolean azN() {
        return this.dDQ == 5;
    }

    public boolean azO() {
        return this.dDC != null && this.dDC.getLoadType() == 1;
    }

    public boolean azP() {
        return this.dDQ == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.dDw.aud() != null) {
            return this.dDw.aud().a(this.dDQ, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bb.ahJ.get() && r.bnn().bnh() != null) {
            int Q = r.bnn().bnh().Q(str, false);
            int R = r.bnn().bnh().R(str, false);
            if (frsRequestData.getLoadType() == 1) {
                Q++;
            } else if (frsRequestData.getLoadType() == 2) {
                R++;
            }
            frsRequestData.setRefreshCount(Q);
            frsRequestData.setLoadCount(R);
        }
    }

    public void azQ() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.dlS != null && this.dlS.aZl() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.dlS.aZl().getId(), 0L));
        }
        this.dDw.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void mS(final String str) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.btR().ch(FrsModelController.this.dDT, str);
                return null;
            }
        }, null);
    }

    public void mT(final String str) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.btR().ci(FrsModelController.this.dDT, str);
                return null;
            }
        }, null);
    }

    public void mU(final String str) {
        com.baidu.tbadk.util.v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.btR().cj(FrsModelController.this.dDT, str);
                return null;
            }
        }, null);
    }
}
