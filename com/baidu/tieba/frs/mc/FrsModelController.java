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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.k.m;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.w;
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
    private long aTT;
    private int btG;
    private long cQL;
    private long cQM;
    private long cQN;
    private long cQO;
    private final FrsFragment dAK;
    private ArrayList<com.baidu.adp.widget.ListView.h> dAP;
    private FrsRequestData dAQ;
    private final n dAR;
    private boolean dAS;
    private int dAT;
    private int dAU;
    private int dAV;
    private ao dAW;
    private boolean dAX;
    private SparseArray<ao> dAY;
    private aa dAZ;
    private al dBa;
    private ArrayList<com.baidu.adp.widget.ListView.h> dBb;
    private boolean dBc;
    private String dBd;
    private int dBe;
    private int dBf;
    private boolean dBg;
    private String dBh;
    private final SparseArray<Boolean> dBi;
    private al dBj;
    private l djc;
    private String djs;
    private d.a dqg;
    private FrsNetModel<FrsFragment> dzM;
    private String dzO;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean lh(int i) {
        return this.dBi.get(i, false).booleanValue();
    }

    public void q(int i, boolean z) {
        this.dBi.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.djs = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.dAT = 0;
        this.mSource = null;
        this.dzO = null;
        this.btG = 1;
        this.dAU = 0;
        this.dAV = 0;
        this.dAX = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.dAY = new SparseArray<>();
        this.aTT = 0L;
        this.dBc = false;
        this.dBe = -1;
        this.dBf = -1;
        this.dBh = null;
        this.dBi = new SparseArray<>();
        this.dBj = new al() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.al
            public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
                FrsModelController.this.dAX = false;
                if (i == FrsModelController.this.btG && FrsModelController.this.dBa != null) {
                    FrsModelController.this.dAW = arVar;
                    FrsModelController.this.b(i, i2, arVar);
                    ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.djc.az(arrayList2);
                    FrsModelController.this.dBa.a(i, i2, arVar, arrayList);
                }
            }
        };
        this.cQL = 0L;
        this.cQM = 0L;
        this.cQN = 0L;
        this.cQO = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.dAK = frsFragment;
        this.dAR = nVar;
        B(this.dAK);
    }

    private void B(FrsFragment frsFragment) {
        this.dAZ = new aa();
        this.dAZ.aRF = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.dAZ));
        this.dAZ.a(this.dBj);
    }

    public void onActivityDestroy() {
        this.dzM.cancelLoadData();
    }

    public void i(Bundle bundle) {
        if (bundle != null) {
            this.djs = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.dBd = bundle.getString("yuelaou_locate");
            this.dAS = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.dAT = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
        }
        if (TextUtils.isEmpty(this.djs)) {
            this.djs = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.dBd)) {
            this.dBd = "";
        }
        this.mSource = this.mFrom;
        this.dAQ = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            li(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            li(6);
        } else {
            li(com.baidu.tieba.frs.f.g.nb(this.djs));
        }
        this.dAQ.setSortType(Vb());
        if (this.dBe == 5) {
            this.dAQ.setIsGood(1);
        } else {
            this.dAQ.setIsGood(0);
        }
        this.djc = new l();
        this.dzM = new FrsNetModel<>(this.dAK.getPageContext(), this.dAQ);
        this.dzM.a(this);
        this.dzM.setUniqueId(this.dAK.getUniqueId());
        if (this.djs != null && this.djs.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.djs);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean ajN() {
        if (this.btG != 1) {
            ld(1);
            return true;
        } else if (this.dzM.AO()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dAQ), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(Vb());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void r(int i, boolean z) {
        this.dAK.djB = System.currentTimeMillis();
        if (this.djc != null && this.djc.bvM() != null) {
            this.djc.bvM().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dAQ), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.btG = c(this.btG, frsRequestData);
        if (this.btG == 1) {
            if (!this.dzM.AO()) {
                frsRequestData.setCallFrom(this.dAT);
                a(frsRequestData, i);
                this.dAT = 0;
                return;
            }
            return;
        }
        if (this.dAW == null) {
            this.dAW = new ao();
            this.dAW.pn = 1;
            this.dAW.forumName = this.djs;
            if (this.djc != null && this.djc.baT() != null) {
                this.dAW.forumId = this.djc.baT().getId();
            }
        }
        ld(i);
    }

    public void le(int i) {
        if (this.btG != 1) {
            ld(4);
        } else if (!this.dzM.AO()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dAQ), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(Vb());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.dAR.kj(i);
        this.dzM.a(frsRequestData);
        this.mType = i;
        frsRequestData.tA(this.dAK.aub() ? "1" : "2");
        if (this.dBg) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.ly(this.dBf)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.dBg = false;
        frsRequestData.setKw(this.djs);
        if (com.baidu.tbadk.core.i.tt().tz()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int ah = com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst());
        int aj = com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst());
        float ak = com.baidu.adp.lib.util.l.ak(TbadkCoreApplication.getInst());
        int i2 = com.baidu.tbadk.core.util.ar.zF().zH() ? 2 : 1;
        frsRequestData.setScrW(ah);
        frsRequestData.setScrH(aj);
        frsRequestData.setScrDip(ak);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.dzO);
        frsRequestData.setYuelaouLocate(this.dBd);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(u.LB(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.djC != 0) {
            frsRequestData.setCtime((int) FrsFragment.djC);
        }
        if (FrsFragment.djD != 0) {
            frsRequestData.setDataSize((int) FrsFragment.djD);
        }
        if (FrsFragment.djE != 0) {
            frsRequestData.setNetError(FrsFragment.djE);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.g.a(this.dBe, frsRequestData);
        b(i, frsRequestData);
        a(this.djs, frsRequestData);
        if (!lh(this.dBe) && !this.dAK.djt) {
            String d = com.baidu.tieba.tbadkCore.c.bvo().d(this.djs, frsRequestData.Vb(), frsRequestData.getIsGood(), this.dAQ.getCategoryId());
            this.dBh = d;
            new a(this, true, d).execute(new Object[0]);
        }
        ayB();
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
        if (iVar == null || iVar.baT() == null || (ap.isEmpty(iVar.baT().getName()) && 340001 != iVar.dqh)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.btG = iVar.bvQ();
        }
        this.djc.e(iVar);
        e(this.djc);
        this.dAP = new ArrayList<>();
        if (frsRequestData != null) {
            this.dAQ = frsRequestData;
            this.mPn = this.dAQ.getPn();
            this.djs = this.dAQ.getKw();
            this.dAK.setForumName(this.djs);
            this.dAK.setFrom(this.mFrom);
            this.dAK.setPn(this.mPn);
            this.dAK.setFlag(this.mFlag);
        }
        if (this.djc.getThreadList() != null) {
            this.dAP.addAll(this.djc.getThreadList());
        }
        if (this.btG != 1 && this.isNetFirstLoad) {
            this.dAR.a(7, false, this.dqg);
        } else {
            this.dAR.a(this.mType, false, this.dqg);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.dAQ)) {
            azk();
        }
        this.isNetFirstLoad = false;
        if (iVar.baT() == null || TextUtils.isEmpty(iVar.baT().getName()) || frsRequestData == null || r.boJ().boD() == null) {
            return true;
        }
        r.boJ().boD().f(iVar.baT().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.gJF = com.baidu.adp.lib.util.j.jD() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.gJG = mvcSocketResponsedMessage.getDownSize();
        this.dqg = aVar;
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
        this.dAK.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.dBc) {
            this.dBc = true;
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
        aVar.gJF = com.baidu.adp.lib.util.j.jD() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.gJG = mvcHttpResponsedMessage.getDownSize();
        this.dqg = aVar;
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
        this.dAK.a(errorData);
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
        if (!this.dBc) {
            this.dBc = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void atW() {
        if (this.djc != null && this.djc.baT() != null && this.djc.baT().getBannerListData() != null) {
            String lastIds = this.djc.baT().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dzO = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.KK().KL()) {
            this.aTT = System.currentTimeMillis() - this.dAK.beginTime;
            com.baidu.tbadk.k.i iVar = new com.baidu.tbadk.k.i(i, z, responsedMessage, this.dAK.aTK, this.dAK.createTime, this.dAK.aTS, false, this.aTT);
            this.dAK.createTime = 0L;
            this.dAK.aTK = 0L;
            if (iVar != null) {
                iVar.KH();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.KK().KL()) {
            this.aTT = System.currentTimeMillis() - this.dAK.djB;
            com.baidu.tbadk.k.i iVar = new com.baidu.tbadk.k.i(1000, z, responsedMessage, this.dAK.aTK, this.dAK.createTime, this.dAK.aTS, false, this.aTT);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.aUb = this.aTT;
                    iVar.bZ(true);
                } else if (this.mType == 3) {
                    iVar.aUc = this.aTT;
                    iVar.bZ(false);
                }
            }
        }
    }

    public FrsRequestData ayU() {
        return this.dAQ;
    }

    public String ayV() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.djs;
    }

    public int getPn() {
        return this.mPn;
    }

    public l ayA() {
        return this.djc;
    }

    public d.a ayW() {
        return this.dqg;
    }

    private void ayB() {
        this.cQL = System.currentTimeMillis();
        this.dzM.JW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.djc.e(iVar);
        e(this.djc);
        this.dAP = new ArrayList<>();
        if (this.djc.getThreadList() != null) {
            this.dAP.addAll(this.djc.getThreadList());
        }
        this.dAR.b(iVar);
    }

    private void e(l lVar) {
        if (com.baidu.tieba.frs.vc.f.j(lVar)) {
            this.mPageType = "book_page";
        } else if (lVar.bwv()) {
            this.mPageType = "brand_page";
        } else if (com.baidu.tieba.frs.vc.f.k(lVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.i, Void> {
        private String dBn;
        private FrsModelController dBo;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.dBn = null;
            this.dBn = str;
            this.dBo = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bvo().ty(this.dBn)) {
                if (!com.baidu.tieba.tbadkCore.c.bvo().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.dBn)) {
                    com.baidu.tieba.tbadkCore.c.bvo().getResponseData().baT().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.i responseData = com.baidu.tieba.tbadkCore.c.bvo().getResponseData();
                responseData.mD(false);
                if (responseData.bvS() != null && !StringUtils.isNull(responseData.bvS().ub(), true) && !responseData.bvS().ub().equals("0") && responseData.bvS().getBookType() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bvS().ub(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(g))) != null) {
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
            if (this.dBo != null && iVarArr != null) {
                this.dBo.d(iVarArr.length > 0 ? iVarArr[0] : null);
                this.dBo.q(this.dBo.dBe, true);
            }
        }
    }

    public long aoC() {
        return this.cQO;
    }

    public long aoD() {
        return this.cQM;
    }

    public long aoE() {
        return this.cQN;
    }

    public long aoF() {
        return this.cQL;
    }

    public boolean AO() {
        return this.dzM.AO();
    }

    public int ayX() {
        return this.dAV;
    }

    private void ayY() {
        if (this.dBb == null) {
            this.dBb = new ArrayList<>();
        }
        if (this.dBb.size() == 0) {
            this.dBb.add(new v());
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        this.btG = c(i, null);
        if (aoVar == null && (aoVar = aK(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.jU() && this.dBa != null) {
                ar arVar = new ar();
                arVar.hasMore = false;
                arVar.pn = 1;
                arVar.forumName = this.djs;
                arVar.dmY = false;
                if (this.djc != null && this.djc.baT() != null) {
                    arVar.forumId = this.djc.baT().getId();
                }
                ayY();
                this.djc.az(this.dBb);
                this.dBa.a(i, i2, arVar, this.dBb);
            }
            aoVar = new ao();
            aoVar.pn = -1;
        }
        if (this.djc != null && this.djc.baT() != null) {
            aoVar.forumId = this.djc.baT().getId();
        }
        aoVar.forumName = this.djs;
        if (y.avd().ku(1) != null && this.btG == 1) {
            this.dAQ.setCategoryId(i2);
        }
        this.dAU = i2;
        this.dAW = aoVar;
        b(i, i2, aoVar);
        ld(5);
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.dBa = alVar;
        this.dAZ.a(this.dBj);
    }

    private void ld(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.dAW != null) {
                    this.dAW.pn++;
                    break;
                }
                break;
            case 2:
                if (this.dAW != null) {
                    ao aoVar = this.dAW;
                    aoVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.dAW != null) {
                    this.dAW.pn = -1;
                    break;
                }
                break;
        }
        if (this.btG == 1) {
            if (this.dAV == this.dAU) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                if (this.dAP != null) {
                    arrayList.addAll(this.dAP);
                }
                this.djc.az(arrayList);
                if (this.dBa != null) {
                    this.dBa.a(this.btG, this.dAU, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.dAV = this.dAU;
            return;
        }
        ai kv = this.dAZ.kv(this.btG);
        if (kv != null) {
            this.dAX = true;
            kv.a(this.btG, this.dAU, this.dAW);
            return;
        }
        if (this.djc != null && this.djc.getThreadList() != null) {
            this.djc.getThreadList().clear();
        }
        this.dBa.a(this.btG, this.dAU, null, null);
    }

    public boolean hasMore() {
        if ((this.dAW instanceof ar) && ((ar) this.dAW).errCode == 0) {
            return ((ar) this.dAW).hasMore;
        }
        return true;
    }

    private int aJ(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ao aoVar) {
        this.dAY.put(aJ(i, i2), aoVar);
    }

    public ao aK(int i, int i2) {
        return this.dAY.get(aJ(i, i2));
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        this.dAZ.init();
    }

    @Override // com.baidu.tieba.frs.ai
    public void Vo() {
        this.dAZ.destory();
        this.dAZ.clear();
    }

    public int ayZ() {
        return this.btG;
    }

    public boolean aza() {
        return 1 == this.btG;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(aj ajVar) {
        if (ajVar != null && !StringUtils.isNull(ajVar.getId()) && this.dAP != null) {
            if (this.btG == 1) {
                this.djc.a(ajVar);
            }
            int azb = azb();
            if (this.dAP != null && this.dAP.size() > 0) {
                int size = this.dAP.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.h hVar = this.dAP.get(i);
                    if ((hVar instanceof bc) && ajVar.getId().equals(((bc) hVar).getId())) {
                        return;
                    }
                }
            }
            this.dAP.add(azb, ajVar);
        }
    }

    public int azb() {
        int i = 0;
        if (this.dAP == null || this.dAP.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.dAP.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (!(next instanceof bc)) {
                    i = i2;
                } else if (((bc) next).vr() != 0) {
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

    public boolean azc() {
        return this.dAX;
    }

    public void azd() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.dAV == 0) {
            mVar.kt(this.dBe);
        }
        if (this.djc.getThreadList() != null) {
            this.djc.getThreadList().clear();
            this.djc.getThreadList().add(mVar);
        }
        if (this.dAP != null) {
            this.dAP.clear();
            this.dAP.add(mVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aze() {
        return this.dAP;
    }

    public void li(int i) {
        this.dBe = i;
        com.baidu.tieba.frs.f.g.Y(this.djs, this.dBe);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.byC();
        } else {
            com.baidu.tieba.tbadkCore.util.e.byD();
        }
    }

    public void lj(int i) {
        this.dBf = i;
    }

    public void gj(boolean z) {
        this.dBg = z;
    }

    public int azf() {
        return this.dBe;
    }

    public int Vb() {
        return com.baidu.tieba.frs.f.g.ly(this.dBe);
    }

    public boolean azg() {
        return this.dAS;
    }

    public boolean azh() {
        return this.dBe == 5;
    }

    public boolean azi() {
        return this.dAQ != null && this.dAQ.getLoadType() == 1;
    }

    public boolean azj() {
        return this.dBe == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.dAK.atz() != null) {
            return this.dAK.atz().a(this.dBe, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bc.ain.get() && r.boJ().boD() != null) {
            int R = r.boJ().boD().R(str, false);
            int S = r.boJ().boD().S(str, false);
            if (frsRequestData.getLoadType() == 1) {
                R++;
            } else if (frsRequestData.getLoadType() == 2) {
                S++;
            }
            frsRequestData.setRefreshCount(R);
            frsRequestData.setLoadCount(S);
        }
    }

    public void azk() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.djc != null && this.djc.baT() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.djc.baT().getId(), 0L));
        }
        this.dAK.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void mT(final String str) {
        w.a(new com.baidu.tbadk.util.v<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.v
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bvo().ck(FrsModelController.this.dBh, str);
                return null;
            }
        }, null);
    }

    public void mU(final String str) {
        w.a(new com.baidu.tbadk.util.v<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.v
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bvo().cl(FrsModelController.this.dBh, str);
                return null;
            }
        }, null);
    }

    public void mV(final String str) {
        w.a(new com.baidu.tbadk.util.v<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.v
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bvo().cm(FrsModelController.this.dBh, str);
                return null;
            }
        }, null);
    }
}
