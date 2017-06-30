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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.ay;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.frs.bo;
import com.baidu.tieba.frs.br;
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.frs.bz;
import com.baidu.tieba.frs.ca;
import com.baidu.tieba.frs.cf;
import com.baidu.tieba.frs.ci;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.l>, bz {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long aHM;
    private String ahE;
    private long bTE;
    private long bTF;
    private long bTG;
    private long bTH;
    private final com.baidu.tieba.frs.r cbE;
    private com.baidu.tieba.tbadkCore.n cbN;
    private String ccb;
    private ArrayList<com.baidu.adp.widget.ListView.v> ckC;
    private FrsNetModel<com.baidu.tieba.frs.r> ckD;
    private d.a ckF;
    private String ckG;
    private boolean ckJ;
    private SparseArray<cf> cmA;
    private bt cmB;
    private ca cmC;
    private ArrayList<com.baidu.adp.widget.ListView.v> cmD;
    private String cmE;
    private int cmF;
    private int cmG;
    private boolean cmH;
    private String cmI;
    private final SparseArray<Boolean> cmJ;
    private ca cmK;
    private FrsRequestData cms;
    private final com.baidu.tieba.tbadkCore.p cmt;
    private boolean cmu;
    private int cmv;
    private int cmw;
    private int cmx;
    private cf cmy;
    private boolean cmz;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean iU(int i) {
        return this.cmJ.get(i, false).booleanValue();
    }

    public void o(int i, boolean z) {
        this.cmJ.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.r rVar, com.baidu.tieba.tbadkCore.p pVar) {
        super(rVar.getPageContext());
        this.ccb = null;
        this.mType = 3;
        this.mPn = 1;
        this.ahE = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.ckG = null;
        this.cmv = 1;
        this.cmw = 0;
        this.cmx = 0;
        this.cmz = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.cmA = new SparseArray<>();
        this.aHM = 0L;
        this.ckJ = false;
        this.cmF = -1;
        this.cmG = -1;
        this.cmI = null;
        this.cmJ = new SparseArray<>();
        this.cmK = new i(this);
        this.bTE = 0L;
        this.bTF = 0L;
        this.bTG = 0L;
        this.bTH = 0L;
        if (rVar == null || pVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.cbE = rVar;
        this.cmt = pVar;
        x(this.cbE);
    }

    private void x(com.baidu.tieba.frs.r rVar) {
        this.cmB = new bt();
        this.cmB.aMp = rVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.cmB));
        this.cmB.a(this.cmK);
    }

    public void onActivityDestroy() {
        this.ckD.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.ccb = bundle.getString("name");
            this.ahE = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.cmE = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.cmu = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.ccb)) {
            this.ccb = "";
        }
        if (TextUtils.isEmpty(this.ahE)) {
            this.ahE = "";
        }
        if (TextUtils.isEmpty(this.cmE)) {
            this.cmE = "";
        }
        this.mSource = this.ahE;
        this.cms = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            iW(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            iW(6);
        } else {
            com.baidu.tieba.frs.smartsort.h kh = com.baidu.tieba.frs.smartsort.e.ahk().kh(this.ccb);
            if (kh != null) {
                iW(kh.cnq);
            } else {
                iW(-1);
            }
        }
        this.cms.setSortType(agU());
        if (this.cmF == 5) {
            this.cms.setIsGood(1);
        } else {
            this.cms.setIsGood(0);
        }
        this.cbN = new com.baidu.tieba.tbadkCore.n();
        this.ckD = new FrsNetModel<>(this.cbE.getPageContext(), this.cms);
        this.ckD.a(this);
        this.ckD.setUniqueId(this.cbE.getUniqueId());
        if (this.ccb != null && this.ccb.length() > 0) {
            if (this.ahE == null || this.ahE.length() <= 0) {
                this.ahE = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.ccb);
        bundle.putString("from", this.ahE);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean Xc() {
        if (this.cmv != 1) {
            iV(1);
            return true;
        } else if (this.ckD.wI()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.cbE.getActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cms), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(agU());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void p(int i, boolean z) {
        if (this.cbN != null && this.cbN.bkQ() != null) {
            this.cbN.bkQ().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cms), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.cmv = c(this.cmv, frsRequestData);
        if (this.cmv == 1) {
            if (!this.ckD.wI()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.cmy == null) {
            this.cmy = new cf();
            this.cmy.pn = 1;
            this.cmy.forumName = this.ccb;
            if (this.cbN != null && this.cbN.aMt() != null) {
                this.cmy.forumId = this.cbN.aMt().getId();
            }
        }
        iV(i);
    }

    public void iS(int i) {
        if (this.cmv != 1) {
            iV(4);
        } else if (!this.ckD.wI()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cms), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(agU());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.cmt.iu(i);
        this.ckD.a(frsRequestData);
        this.mType = i;
        frsRequestData.qY(this.cbE.aem() ? "1" : "2");
        if (this.cmH) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.e.n.jk(this.cmG)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.cmH = false;
        frsRequestData.setKw(this.ccb);
        if (com.baidu.tbadk.core.r.oK().oQ()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int af = com.baidu.adp.lib.util.k.af(this.cbE.getActivity());
        int ag = com.baidu.adp.lib.util.k.ag(this.cbE.getActivity());
        float ah = com.baidu.adp.lib.util.k.ah(this.cbE.getActivity());
        int i2 = ax.vA().vC() ? 2 : 1;
        frsRequestData.setScrW(af);
        frsRequestData.setScrH(ag);
        frsRequestData.setScrDip(ah);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.ckG);
        frsRequestData.setYuelaouLocate(this.cmE);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(com.baidu.tbadk.util.v.GU(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.r.cck != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.r.cck);
        }
        if (com.baidu.tieba.frs.r.ccl != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.r.ccl);
        }
        if (com.baidu.tieba.frs.r.ccm != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.r.ccm);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.e.n.a(this.cmF, frsRequestData);
        b(i, frsRequestData);
        a(this.ccb, frsRequestData);
        if (!iU(this.cmF)) {
            String g = com.baidu.tieba.tbadkCore.c.bkt().g(this.ccb, frsRequestData.agU(), frsRequestData.getIsGood(), this.cms.getCategoryId());
            this.cmI = g;
            new a(this, true, g).execute(new Object[0]);
        }
        agD();
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

    protected boolean a(FrsRequestData frsRequestData, com.baidu.tieba.tbadkCore.l lVar) {
        if (lVar == null || lVar.aMt() == null || StringUtils.isNull(lVar.aMt().getName())) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.cmv = lVar.bkU();
        }
        this.cbN.d(lVar);
        d(this.cbN);
        this.ckC = new ArrayList<>();
        if (frsRequestData != null) {
            this.cms = frsRequestData;
            this.mPn = this.cms.getPn();
            this.ccb = this.cms.getKw();
            this.cbE.setForumName(this.ccb);
            this.cbE.setFrom(this.ahE);
            this.cbE.setPn(this.mPn);
            this.cbE.setFlag(this.mFlag);
        }
        if (this.cbN.getThreadList() != null) {
            this.ckC.addAll(this.cbN.getThreadList());
        }
        if (this.cmv != 1 && this.isNetFirstLoad) {
            this.cmt.a(7, false, this.ckF);
        } else {
            this.cmt.a(this.mType, false, this.ckF);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.d.b(this.cms)) {
            agZ();
        }
        this.isNetFirstLoad = false;
        if (lVar.aMt() == null || TextUtils.isEmpty(lVar.aMt().getName()) || frsRequestData == null || com.baidu.tieba.recapp.aa.bdU().bdQ() == null) {
            return true;
        }
        com.baidu.tieba.recapp.aa.bdU().bdQ().g(lVar.aMt().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        d.a aVar = new d.a();
        aVar.fJh = com.baidu.adp.lib.util.i.hj() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.fJi = mvcSocketResponsedMessage.getDownSize();
        this.ckF = aVar;
        if (mvcSocketResponsedMessage == null || mvcSocketResponsedMessage.hasError()) {
            lVar = null;
        } else {
            lVar = mvcSocketResponsedMessage.getData();
            r3 = mvcSocketMessage != null ? mvcSocketMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && lVar != null && a(r3, lVar)) {
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
        this.cbE.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData;
        FrsRequestData frsRequestData2 = null;
        if (!this.ckJ) {
            this.ckJ = true;
            a(1000, false, (ResponsedMessage<?>) mvcSocketResponsedMessage);
        }
        long j = 0;
        if (mvcSocketMessage != null) {
            j = mvcSocketMessage.getClientLogID();
            frsRequestData2 = mvcSocketMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            frsRequestData = mvcNetMessage.getRequestData();
        } else {
            frsRequestData = frsRequestData2;
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
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.l> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        d.a aVar = new d.a();
        aVar.fJh = com.baidu.adp.lib.util.i.hj() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.fJi = mvcHttpResponsedMessage.getDownSize();
        this.ckF = aVar;
        if (mvcHttpResponsedMessage == null || mvcHttpResponsedMessage.hasError()) {
            lVar = null;
        } else {
            lVar = mvcHttpResponsedMessage.getData();
            r3 = mvcHttpMessage != null ? mvcHttpMessage.getRequestData() : null;
            if (mvcNetMessage != null) {
                r3 = mvcNetMessage.getRequestData();
            }
        }
        if (r3 != null && lVar != null && a(r3, lVar)) {
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
        this.cbE.a(errorData);
        b(mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(int i, com.baidu.adp.framework.listener.a aVar) {
        super.registerListener(i, aVar);
    }

    private void b(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.l> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData;
        FrsRequestData frsRequestData2 = null;
        long j = 0;
        if (mvcHttpMessage != null) {
            j = mvcHttpMessage.getClientLogID();
            frsRequestData2 = mvcHttpMessage.getRequestData();
        }
        if (mvcNetMessage != null) {
            j = mvcNetMessage.getLogID();
            frsRequestData = mvcNetMessage.getRequestData();
        } else {
            frsRequestData = frsRequestData2;
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
        if (!this.ckJ) {
            this.ckJ = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void aeh() {
        if (this.cbN != null && this.cbN.aMt() != null && this.cbN.aMt().getBannerListData() != null) {
            String lastIds = this.cbN.aMt().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.ckG = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (com.baidu.tbadk.j.aa.Gb().Gc()) {
            this.aHM = System.currentTimeMillis() - this.cbE.Vq;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v(i, z, responsedMessage, this.cbE.aHD, this.cbE.createTime, this.cbE.aHL, false, this.aHM);
            this.cbE.createTime = 0L;
            this.cbE.aHD = 0L;
            if (vVar != null) {
                vVar.FW();
            }
        }
    }

    public FrsRequestData agI() {
        return this.cms;
    }

    public String agJ() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.ccb;
    }

    public com.baidu.tieba.tbadkCore.n agC() {
        return this.cbN;
    }

    public d.a agK() {
        return this.ckF;
    }

    private void agD() {
        this.bTE = System.currentTimeMillis();
        this.ckD.EX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.l lVar) {
        this.isCacheFirstLoad = false;
        this.cbN.d(lVar);
        d(this.cbN);
        this.ckC = new ArrayList<>();
        if (this.cbN.getThreadList() != null) {
            this.ckC.addAll(this.cbN.getThreadList());
        }
        this.cmt.b(lVar);
    }

    private void d(com.baidu.tieba.tbadkCore.n nVar) {
        if (com.baidu.tieba.frs.f.m.h(nVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.f.m.i(nVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.l, Void> {
        private String cmO;
        private FrsModelController cmP;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.cmO = null;
            this.cmO = str;
            this.cmP = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bkt().qW(this.cmO)) {
                if (!com.baidu.tieba.tbadkCore.c.bkt().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.cmO)) {
                    com.baidu.tieba.tbadkCore.c.bkt().getResponseData().aMt().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.l responseData = com.baidu.tieba.tbadkCore.c.bkt().getResponseData();
                if (responseData.bkW() != null && !StringUtils.isNull(responseData.bkW().getBookId(), true) && !responseData.bkW().getBookId().equals("0") && responseData.bkW().pC() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bkW().getBookId(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
                    responseData.h(Integer.valueOf(((Integer) runTask.getData()).intValue()));
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
        public void onProgressUpdate(com.baidu.tieba.tbadkCore.l... lVarArr) {
            super.onProgressUpdate(lVarArr);
            if (this.cmP != null && lVarArr != null) {
                this.cmP.c(lVarArr.length > 0 ? lVarArr[0] : null);
                this.cmP.o(this.cmP.cmF, true);
            }
        }
    }

    public long aaY() {
        return this.bTH;
    }

    public long aaZ() {
        return this.bTF;
    }

    public long aba() {
        return this.bTG;
    }

    public long abb() {
        return this.bTE;
    }

    public boolean wI() {
        return this.ckD.wI();
    }

    public int agL() {
        return this.cmx;
    }

    private void agM() {
        if (this.cmD == null) {
            this.cmD = new ArrayList<>();
        }
        if (this.cmD.size() == 0) {
            this.cmD.add(new bo());
        }
    }

    @Override // com.baidu.tieba.frs.bz
    public void a(int i, int i2, cf cfVar) {
        this.cmv = c(i, null);
        if (cfVar == null && (cfVar = at(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.k.hA() && this.cmC != null) {
                ci ciVar = new ci();
                ciVar.hasMore = false;
                ciVar.pn = 1;
                ciVar.forumName = this.ccb;
                ciVar.cfj = false;
                if (this.cbN != null && this.cbN.aMt() != null) {
                    ciVar.forumId = this.cbN.aMt().getId();
                }
                agM();
                this.cbN.az(this.cmD);
                this.cmC.a(i, i2, ciVar, this.cmD);
            }
            cfVar = new cf();
            cfVar.pn = -1;
        }
        if (this.cbN != null && this.cbN.aMt() != null) {
            cfVar.forumId = this.cbN.aMt().getId();
        }
        cfVar.forumName = this.ccb;
        if (br.aeU().iA(1) != null && this.cmv == 1) {
            this.cms.setCategoryId(i2);
        }
        this.cmw = i2;
        this.cmy = cfVar;
        b(i, i2, cfVar);
        iV(5);
    }

    @Override // com.baidu.tieba.frs.bz
    public void a(ca caVar) {
        this.cmC = caVar;
        this.cmB.a(this.cmK);
    }

    private void iV(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.cmy != null) {
                    this.cmy.pn++;
                    break;
                }
                break;
            case 2:
                if (this.cmy != null) {
                    cf cfVar = this.cmy;
                    cfVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.cmy != null) {
                    this.cmy.pn = -1;
                    break;
                }
                break;
        }
        if (this.cmv == 1) {
            if (this.cmx == this.cmw) {
                ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
                if (this.ckC != null) {
                    arrayList.addAll(this.ckC);
                }
                this.cbN.az(arrayList);
                if (this.cmC != null) {
                    this.cmC.a(this.cmv, this.cmw, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.cmx = this.cmw;
            return;
        }
        bz iB = this.cmB.iB(this.cmv);
        if (iB != null) {
            this.cmz = true;
            iB.a(this.cmv, this.cmw, this.cmy);
            return;
        }
        if (this.cbN != null && this.cbN.getThreadList() != null) {
            this.cbN.getThreadList().clear();
        }
        this.cmC.a(this.cmv, this.cmw, null, null);
    }

    public boolean hasMore() {
        if ((this.cmy instanceof ci) && ((ci) this.cmy).errCode == 0) {
            return ((ci) this.cmy).hasMore;
        }
        return true;
    }

    private int as(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, cf cfVar) {
        this.cmA.put(as(i, i2), cfVar);
    }

    public cf at(int i, int i2) {
        return this.cmA.get(as(i, i2));
    }

    @Override // com.baidu.tieba.frs.bz
    public void init() {
        this.cmB.init();
    }

    @Override // com.baidu.tieba.frs.bz
    public void Og() {
        this.cmB.destory();
        this.cmB.clear();
    }

    public int agN() {
        return this.cmv;
    }

    public boolean agO() {
        return 1 == this.cmv;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(ap apVar) {
        if (apVar != null && !StringUtils.isNull(apVar.getId()) && this.ckC != null) {
            if (this.cmv == 1) {
                this.cbN.a(apVar);
            }
            int agP = agP();
            if (this.ckC != null && this.ckC.size() > 0) {
                int size = this.ckC.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.v vVar = this.ckC.get(i);
                    if ((vVar instanceof bm) && apVar.getId().equals(((bm) vVar).getId())) {
                        return;
                    }
                }
            }
            if (apVar.getThreadType() == 33) {
                ay ayVar = new ay();
                ayVar.a(apVar, -1);
                ayVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.ckC.add(agP, ayVar);
                    return;
                }
                return;
            }
            this.ckC.add(agP, apVar);
        }
    }

    public int agP() {
        if (this.ckC == null || this.ckC.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.ckC.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next instanceof bm) {
                if (((bm) next).rm() != 0) {
                    i++;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public boolean agQ() {
        return this.cmz;
    }

    public void agR() {
        bc bcVar = new bc();
        if (this.cmx == 0) {
            bcVar.iz(this.cmF);
        }
        if (this.cbN.getThreadList() != null) {
            this.cbN.getThreadList().clear();
            this.cbN.getThreadList().add(bcVar);
        }
        if (this.ckC != null) {
            this.ckC.clear();
            this.ckC.add(bcVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> agS() {
        return this.ckC;
    }

    public void iW(int i) {
        this.cmF = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.s.bnq();
        } else {
            com.baidu.tieba.tbadkCore.util.s.bnr();
        }
    }

    public void iX(int i) {
        this.cmG = i;
    }

    public void eM(boolean z) {
        this.cmH = z;
    }

    public int agT() {
        return this.cmF;
    }

    public int agU() {
        return com.baidu.tieba.frs.e.n.jk(this.cmF);
    }

    public boolean agV() {
        return this.cmu;
    }

    public boolean agW() {
        return this.cmF == 5;
    }

    public boolean agX() {
        return this.cms != null && this.cms.getLoadType() == 1;
    }

    public boolean agY() {
        return this.cmF == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.cbE.adL() != null) {
            return this.cbE.adL().a(this.cmF, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bm.Xw.get() && com.baidu.tieba.recapp.aa.bdU().bdQ() != null) {
            int T = com.baidu.tieba.recapp.aa.bdU().bdQ().T(str, false);
            int U = com.baidu.tieba.recapp.aa.bdU().bdQ().U(str, false);
            if (frsRequestData.getLoadType() == 1) {
                T++;
            } else if (frsRequestData.getLoadType() == 2) {
                U++;
            }
            frsRequestData.setRefreshCount(T);
            frsRequestData.setLoadCount(U);
        }
    }

    public void agZ() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.cbN != null && this.cbN.aMt() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.cbN.aMt().getId(), 0L));
        }
        this.cbE.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void kb(String str) {
        com.baidu.tbadk.util.x.a(new j(this, str), null);
    }

    public void kc(String str) {
        com.baidu.tbadk.util.x.a(new k(this, str), null);
    }
}
