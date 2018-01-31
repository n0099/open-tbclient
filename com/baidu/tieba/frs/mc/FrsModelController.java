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
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.k.m;
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
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.recapp.q;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.i>, ak {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private int bXL;
    private long byG;
    private l dBi;
    private String dBw;
    private final com.baidu.tieba.frs.i dPK;
    private ArrayList<com.baidu.adp.widget.ListView.i> dPN;
    private FrsRequestData dPO;
    private final n dPP;
    private boolean dPQ;
    private int dPR;
    private int dPS;
    private aq dPT;
    private boolean dPU;
    private SparseArray<aq> dPV;
    private ac dPW;
    private an dPX;
    private ArrayList<com.baidu.adp.widget.ListView.i> dPY;
    private boolean dPZ;
    private FrsNetModel<com.baidu.tieba.frs.i> dPa;
    private d.a dPc;
    private String dPd;
    private String dQa;
    private int dQb;
    private int dQc;
    private boolean dQd;
    private String dQe;
    private final SparseArray<Boolean> dQf;
    private an dQg;
    private long dno;
    private long dnp;
    private long dnq;
    private long dnr;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean nG(int i) {
        return this.dQf.get(i, false).booleanValue();
    }

    public void A(int i, boolean z) {
        this.dQf.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.i iVar, n nVar) {
        super(iVar.getPageContext());
        this.dBw = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.dPd = null;
        this.bXL = 1;
        this.dPR = 0;
        this.dPS = 0;
        this.dPU = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.dPV = new SparseArray<>();
        this.byG = 0L;
        this.dPZ = false;
        this.dQb = -1;
        this.dQc = -1;
        this.dQe = null;
        this.dQf = new SparseArray<>();
        this.dQg = new an() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.an
            public void a(int i, int i2, at atVar, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
                FrsModelController.this.dPU = false;
                if (i == FrsModelController.this.bXL && FrsModelController.this.dPX != null) {
                    FrsModelController.this.dPT = atVar;
                    FrsModelController.this.b(i, i2, atVar);
                    ArrayList<com.baidu.adp.widget.ListView.i> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.dBi.at(arrayList2);
                    if ((i == 1 || i == 5) && !FrsModelController.this.ayz()) {
                        FrsModelController.this.dBi.buz();
                        FrsModelController.this.dBi.buA();
                    }
                    FrsModelController.this.dPX.a(i, i2, atVar, arrayList);
                }
            }
        };
        this.dno = 0L;
        this.dnp = 0L;
        this.dnq = 0L;
        this.dnr = 0L;
        if (iVar == null || nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.dPK = iVar;
        this.dPP = nVar;
        y(this.dPK);
    }

    private void y(com.baidu.tieba.frs.i iVar) {
        this.dPW = new ac();
        this.dPW.bGE = iVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.dPW));
        this.dPW.a(this.dQg);
    }

    public void onActivityDestroy() {
        this.dPa.cancelLoadData();
    }

    public void k(Bundle bundle) {
        if (bundle != null) {
            this.dBw = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dQa = bundle.getString("yuelaou_locate");
            this.dPQ = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.dBw)) {
            this.dBw = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.dQa)) {
            this.dQa = "";
        }
        this.mSource = this.mFrom;
        this.dPO = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            nH(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            nH(6);
        } else {
            com.baidu.tieba.frs.smartsort.f mc = com.baidu.tieba.frs.smartsort.d.ayK().mc(this.dBw);
            if (mc != null) {
                nH(mc.dQR);
            } else {
                nH(-1);
            }
        }
        this.dPO.setSortType(XH());
        if (this.dQb == 5) {
            this.dPO.setIsGood(1);
        } else {
            this.dPO.setIsGood(0);
        }
        this.dBi = new l();
        this.dPa = new FrsNetModel<>(this.dPK.getPageContext(), this.dPO);
        this.dPa.a(this);
        this.dPa.setUniqueId(this.dPK.getUniqueId());
        if (this.dBw != null && this.dBw.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dBw);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean ame() {
        if (this.bXL != 1) {
            nD(1);
            return true;
        } else if (this.dPa.DR()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dPO), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(XH());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void B(int i, boolean z) {
        if (this.dBi != null && this.dBi.btU() != null) {
            this.dBi.btU().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dPO), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bXL = c(this.bXL, frsRequestData);
        if (this.bXL == 1) {
            if (!this.dPa.DR()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.dPT == null) {
            this.dPT = new aq();
            this.dPT.pn = 1;
            this.dPT.forumName = this.dBw;
            if (this.dBi != null && this.dBi.aYJ() != null) {
                this.dPT.forumId = this.dBi.aYJ().getId();
            }
        }
        nD(i);
    }

    public void nE(int i) {
        if (this.bXL != 1) {
            nD(4);
        } else if (!this.dPa.DR()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dPO), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(XH());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.dPP.mT(i);
        this.dPa.a(frsRequestData);
        this.mType = i;
        frsRequestData.sq(this.dPK.auy() ? "1" : "2");
        if (this.dQd) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.e.f.nM(this.dQc)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.dQd = false;
        frsRequestData.setKw(this.dBw);
        if (com.baidu.tbadk.core.i.wB().wH()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ao = com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst());
        int aq = com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst());
        float ar = com.baidu.adp.lib.util.l.ar(TbadkCoreApplication.getInst());
        int i2 = com.baidu.tbadk.core.util.an.CK().CM() ? 2 : 1;
        frsRequestData.setScrW(ao);
        frsRequestData.setScrH(aq);
        frsRequestData.setScrDip(ar);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.dPd);
        frsRequestData.setYuelaouLocate(this.dQa);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(t.OI(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.i.dBE != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.i.dBE);
        }
        if (com.baidu.tieba.frs.i.dBF != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.i.dBF);
        }
        if (com.baidu.tieba.frs.i.dBG != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.i.dBG);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.e.f.a(this.dQb, frsRequestData);
        b(i, frsRequestData);
        a(this.dBw, frsRequestData);
        if (!nG(this.dQb)) {
            String d = com.baidu.tieba.tbadkCore.c.btv().d(this.dBw, frsRequestData.XH(), frsRequestData.getIsGood(), this.dPO.getCategoryId());
            this.dQe = d;
            new a(this, true, d).execute(new Object[0]);
        }
        axW();
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
        if (iVar == null || iVar.aYJ() == null || (am.isEmpty(iVar.aYJ().getName()) && 340001 != iVar.gWT)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bXL = iVar.btY();
        }
        this.dBi.e(iVar);
        d(this.dBi);
        this.dPN = new ArrayList<>();
        if (frsRequestData != null) {
            this.dPO = frsRequestData;
            this.mPn = this.dPO.getPn();
            this.dBw = this.dPO.getKw();
            this.dPK.setForumName(this.dBw);
            this.dPK.setFrom(this.mFrom);
            this.dPK.setPn(this.mPn);
            this.dPK.setFlag(this.mFlag);
        }
        if (this.dBi.getThreadList() != null) {
            this.dPN.addAll(this.dBi.getThreadList());
        }
        if (this.bXL != 1 && this.isNetFirstLoad) {
            this.dPP.a(7, false, this.dPc);
        } else {
            this.dPP.a(this.mType, false, this.dPc);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.dPO)) {
            ayA();
        }
        this.isNetFirstLoad = false;
        if (iVar.aYJ() == null || TextUtils.isEmpty(iVar.aYJ().getName()) || frsRequestData == null || q.bmS().bmM() == null) {
            return true;
        }
        q.bmS().bmM().f(iVar.aYJ().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.gVp = com.baidu.adp.lib.util.j.oJ() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gVq = mvcSocketResponsedMessage.getDownSize();
        this.dPc = aVar;
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
        this.dPK.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dPZ) {
            this.dPZ = true;
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
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.i> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.gVp = com.baidu.adp.lib.util.j.oJ() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gVq = mvcHttpResponsedMessage.getDownSize();
        this.dPc = aVar;
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
        this.dPK.a(errorData);
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
        if (!this.dPZ) {
            this.dPZ = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void aur() {
        if (this.dBi != null && this.dBi.aYJ() != null && this.dBi.aYJ().getBannerListData() != null) {
            String lastIds = this.dBi.aYJ().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dPd = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (r.NQ().NR()) {
            this.byG = System.currentTimeMillis() - this.dPK.beginTime;
            m mVar = new m(i, z, responsedMessage, this.dPK.byx, this.dPK.createTime, this.dPK.byF, false, this.byG);
            this.dPK.createTime = 0L;
            this.dPK.byx = 0L;
            if (mVar != null) {
                mVar.NL();
            }
        }
    }

    public FrsRequestData ayk() {
        return this.dPO;
    }

    public String ayl() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.dBw;
    }

    public int getPn() {
        return this.mPn;
    }

    public l axV() {
        return this.dBi;
    }

    public d.a aym() {
        return this.dPc;
    }

    private void axW() {
        this.dno = System.currentTimeMillis();
        this.dPa.MQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.dBi.e(iVar);
        d(this.dBi);
        this.dPN = new ArrayList<>();
        if (this.dBi.getThreadList() != null) {
            this.dPN.addAll(this.dBi.getThreadList());
        }
        this.dPP.b(iVar);
    }

    private void d(l lVar) {
        if (com.baidu.tieba.frs.f.f.h(lVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.f.f.i(lVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.i, Void> {
        private String dQk;
        private FrsModelController dQl;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.dQk = null;
            this.dQk = str;
            this.dQl = frsModelController;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            int h;
            CustomResponsedMessage runTask;
            if (this.needCache && com.baidu.tieba.tbadkCore.c.btv().so(this.dQk)) {
                if (!com.baidu.tieba.tbadkCore.c.btv().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.dQk)) {
                    com.baidu.tieba.tbadkCore.c.btv().getResponseData().aYJ().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.i responseData = com.baidu.tieba.tbadkCore.c.btv().getResponseData();
                if (responseData.bua() != null && !StringUtils.isNull(responseData.bua().xn(), true) && !responseData.bua().xn().equals("0") && responseData.bua().xo() == 3 && (h = com.baidu.adp.lib.g.b.h(responseData.bua().xn(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(h))) != null) {
                    responseData.j(Integer.valueOf(((Integer) runTask.getData()).intValue()));
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
            if (this.dQl != null && iVarArr != null) {
                this.dQl.d(iVarArr.length > 0 ? iVarArr[0] : null);
                this.dQl.A(this.dQl.dQb, true);
            }
        }
    }

    public long apY() {
        return this.dnr;
    }

    public long apZ() {
        return this.dnp;
    }

    public long aqa() {
        return this.dnq;
    }

    public long aqb() {
        return this.dno;
    }

    public boolean DR() {
        return this.dPa.DR();
    }

    public int ayn() {
        return this.dPS;
    }

    private void ayo() {
        if (this.dPY == null) {
            this.dPY = new ArrayList<>();
        }
        if (this.dPY.size() == 0) {
            this.dPY.add(new x());
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, aq aqVar) {
        this.bXL = c(i, null);
        if (aqVar == null && (aqVar = bJ(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.pa() && this.dPX != null) {
                at atVar = new at();
                atVar.hasMore = false;
                atVar.pn = 1;
                atVar.forumName = this.dBw;
                atVar.dEF = false;
                if (this.dBi != null && this.dBi.aYJ() != null) {
                    atVar.forumId = this.dBi.aYJ().getId();
                }
                ayo();
                this.dBi.at(this.dPY);
                this.dPX.a(i, i2, atVar, this.dPY);
            }
            aqVar = new aq();
            aqVar.pn = -1;
        }
        if (this.dBi != null && this.dBi.aYJ() != null) {
            aqVar.forumId = this.dBi.aYJ().getId();
        }
        aqVar.forumName = this.dBw;
        if (aa.avn().mZ(1) != null && this.bXL == 1) {
            this.dPO.setCategoryId(i2);
        }
        this.dPR = i2;
        this.dPT = aqVar;
        b(i, i2, aqVar);
        nD(5);
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(an anVar) {
        this.dPX = anVar;
        this.dPW.a(this.dQg);
    }

    private void nD(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.dPT != null) {
                    this.dPT.pn++;
                    break;
                }
                break;
            case 2:
                if (this.dPT != null) {
                    aq aqVar = this.dPT;
                    aqVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.dPT != null) {
                    this.dPT.pn = -1;
                    break;
                }
                break;
        }
        if (this.bXL == 1) {
            if (this.dPS == this.dPR) {
                ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
                if (this.dPN != null) {
                    arrayList.addAll(this.dPN);
                }
                this.dBi.at(arrayList);
                if (this.dPX != null) {
                    this.dPX.a(this.bXL, this.dPR, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.dPS = this.dPR;
            return;
        }
        ak na = this.dPW.na(this.bXL);
        if (na != null) {
            this.dPU = true;
            na.a(this.bXL, this.dPR, this.dPT);
            return;
        }
        if (this.dBi != null && this.dBi.getThreadList() != null) {
            this.dBi.getThreadList().clear();
        }
        this.dPX.a(this.bXL, this.dPR, null, null);
    }

    public boolean hasMore() {
        if ((this.dPT instanceof at) && ((at) this.dPT).errCode == 0) {
            return ((at) this.dPT).hasMore;
        }
        return true;
    }

    private int bI(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, aq aqVar) {
        this.dPV.put(bI(i, i2), aqVar);
    }

    public aq bJ(int i, int i2) {
        return this.dPV.get(bI(i, i2));
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        this.dPW.init();
    }

    @Override // com.baidu.tieba.frs.ak
    public void XY() {
        this.dPW.destory();
        this.dPW.clear();
    }

    public int ayp() {
        return this.bXL;
    }

    public boolean ayq() {
        return 1 == this.bXL;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && this.dPN != null) {
            if (this.bXL == 1) {
                this.dBi.a(aiVar);
            }
            int ayr = ayr();
            if (this.dPN != null && this.dPN.size() > 0) {
                int size = this.dPN.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.i iVar = this.dPN.get(i);
                    if ((iVar instanceof bd) && aiVar.getId().equals(((bd) iVar).getId())) {
                        return;
                    }
                }
            }
            if (aiVar.getThreadType() == 33) {
                ar arVar = new ar();
                arVar.a(aiVar, -1);
                arVar.setPost_num(1);
                if (true == TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.dPN.add(ayr, arVar);
                    return;
                }
                return;
            }
            this.dPN.add(ayr, aiVar);
        }
    }

    public int ayr() {
        int i = 0;
        if (this.dPN == null || this.dPN.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.i> it = this.dPN.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.i next = it.next();
                if (!(next instanceof bd)) {
                    i = i2;
                } else if (((bd) next).yO() != 0) {
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

    public boolean ays() {
        return this.dPU;
    }

    public void ayt() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.dPS == 0) {
            mVar.mY(this.dQb);
        }
        if (this.dBi.getThreadList() != null) {
            this.dBi.getThreadList().clear();
            this.dBi.getThreadList().add(mVar);
        }
        if (this.dPN != null) {
            this.dPN.clear();
            this.dPN.add(mVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> ayu() {
        return this.dPN;
    }

    public void nH(int i) {
        this.dQb = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.f.bwI();
        } else {
            com.baidu.tieba.tbadkCore.util.f.bwJ();
        }
    }

    public void nI(int i) {
        this.dQc = i;
    }

    public void ge(boolean z) {
        this.dQd = z;
    }

    public int ayv() {
        return this.dQb;
    }

    public int XH() {
        return com.baidu.tieba.frs.e.f.nM(this.dQb);
    }

    public boolean ayw() {
        return this.dPQ;
    }

    public boolean ayx() {
        return this.dQb == 5;
    }

    public boolean ayy() {
        return this.dPO != null && this.dPO.getLoadType() == 1;
    }

    public boolean ayz() {
        return this.dQb == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.dPK.atU() != null) {
            return this.dPK.atU().a(this.dQb, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bd.aNl.get() && q.bmS().bmM() != null) {
            int W = q.bmS().bmM().W(str, false);
            int X = q.bmS().bmM().X(str, false);
            if (frsRequestData.getLoadType() == 1) {
                W++;
            } else if (frsRequestData.getLoadType() == 2) {
                X++;
            }
            frsRequestData.setRefreshCount(W);
            frsRequestData.setLoadCount(X);
        }
    }

    public void ayA() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.dBi != null && this.dBi.aYJ() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.dBi.aYJ().getId(), 0L));
        }
        this.dPK.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void lU(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.btv().bX(FrsModelController.this.dQe, str);
                return null;
            }
        }, null);
    }

    public void lV(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.btv().bY(FrsModelController.this.dQe, str);
                return null;
            }
        }, null);
    }

    public void lW(final String str) {
        v.a(new u<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.u
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.btv().bZ(FrsModelController.this.dQe, str);
                return null;
            }
        }, null);
    }
}
