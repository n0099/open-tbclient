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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.l.m;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.i>, ai {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private int bNm;
    private long bfW;
    private l dHF;
    private String dHV;
    private FrsNetModel<FrsFragment> dYQ;
    private d.a dYS;
    private String dYT;
    private final FrsFragment dZP;
    private ArrayList<com.baidu.adp.widget.ListView.h> dZU;
    private FrsRequestData dZV;
    private final n dZW;
    private boolean dZX;
    private int dZY;
    private int dZZ;
    private long dpi;
    private long dpj;
    private long dpk;
    private long dpl;
    private int eaa;
    private ao eab;
    private boolean eac;
    private SparseArray<ao> ead;
    private aa eae;
    private al eaf;
    private ArrayList<com.baidu.adp.widget.ListView.h> eag;
    private boolean eah;
    private String eai;
    private int eaj;
    private int eak;
    private boolean eal;
    private String eam;
    private final SparseArray<Boolean> ean;
    private al eao;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mFrom;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean na(int i) {
        return this.ean.get(i, false).booleanValue();
    }

    public void q(int i, boolean z) {
        this.ean.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(FrsFragment frsFragment, n nVar) {
        super(frsFragment.getPageContext());
        this.dHV = null;
        this.mType = 3;
        this.mPn = 1;
        this.mFrom = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.dZY = 0;
        this.mSource = null;
        this.dYT = null;
        this.bNm = 1;
        this.dZZ = 0;
        this.eaa = 0;
        this.eac = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.ead = new SparseArray<>();
        this.bfW = 0L;
        this.eah = false;
        this.eaj = -1;
        this.eak = -1;
        this.eam = null;
        this.ean = new SparseArray<>();
        this.eao = new al() { // from class: com.baidu.tieba.frs.mc.FrsModelController.1
            @Override // com.baidu.tieba.frs.al
            public void a(int i, int i2, ar arVar, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
                FrsModelController.this.eac = false;
                if (i == FrsModelController.this.bNm && FrsModelController.this.eaf != null) {
                    FrsModelController.this.eab = arVar;
                    FrsModelController.this.b(i, i2, arVar);
                    ArrayList<com.baidu.adp.widget.ListView.h> arrayList2 = new ArrayList<>();
                    if (arrayList != null) {
                        arrayList2.addAll(arrayList);
                    }
                    FrsModelController.this.dHF.ax(arrayList2);
                    FrsModelController.this.eaf.a(i, i2, arVar, arrayList);
                }
            }
        };
        this.dpi = 0L;
        this.dpj = 0L;
        this.dpk = 0L;
        this.dpl = 0L;
        if (nVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.dZP = frsFragment;
        this.dZW = nVar;
        E(this.dZP);
    }

    private void E(FrsFragment frsFragment) {
        this.eae = new aa();
        this.eae.bdE = frsFragment.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003011, this.eae));
        this.eae.a(this.eao);
    }

    public void onActivityDestroy() {
        this.dYQ.cancelLoadData();
    }

    public void p(Bundle bundle) {
        if (bundle != null) {
            this.dHV = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.eai = bundle.getString("yuelaou_locate");
            this.dZX = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
            this.dZY = bundle.getInt(FrsActivityConfig.FRS_CALL_FROM);
        }
        if (TextUtils.isEmpty(this.dHV)) {
            this.dHV = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        if (TextUtils.isEmpty(this.eai)) {
            this.eai = "";
        }
        this.mSource = this.mFrom;
        aGh();
        this.dHF = new l();
        this.dYQ = new FrsNetModel<>(this.dZP.getPageContext(), this.dZV);
        this.dYQ.a(this);
        this.dYQ.setUniqueId(this.dZP.getPageContext().getUniqueId());
        if (this.dHV != null && this.dHV.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.dHV);
        bundle.putString("from", this.mFrom);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    private void aGh() {
        this.dZV = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            nb(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            nb(6);
        } else {
            nb(com.baidu.tieba.frs.f.g.oL(this.dHV));
        }
        this.dZV.setSortType(abZ());
        if (this.eaj == 5) {
            this.dZV.setIsGood(1);
        } else {
            this.dZV.setIsGood(0);
        }
    }

    public boolean aqN() {
        if (this.bNm != 1) {
            mW(1);
            return true;
        } else if (this.dYQ.Fi()) {
            return false;
        } else {
            TiebaStatic.eventStat(TbadkCoreApplication.getInst(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dZV), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(abZ());
            a(frsRequestData, 1, false);
            return true;
        }
    }

    public void r(int i, boolean z) {
        this.dZP.dIe = System.currentTimeMillis();
        if (this.dHF != null && this.dHF.bBC() != null) {
            this.dHF.bBC().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dZV), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.bNm = c(this.bNm, frsRequestData);
        if (this.bNm == 1) {
            if (!this.dYQ.Fi()) {
                frsRequestData.setCallFrom(this.dZY);
                a(frsRequestData, i, z ? false : true);
                this.dZY = 0;
                return;
            }
            return;
        }
        if (this.eab == null) {
            this.eab = new ao();
            this.eab.pn = 1;
            this.eab.forumName = this.dHV;
            if (this.dHF != null && this.dHF.bgi() != null) {
                this.eab.forumId = this.dHF.bgi().getId();
            }
        }
        mW(i);
    }

    public void mX(int i) {
        if (this.bNm != 1) {
            mW(4);
        } else if (!this.dYQ.Fi()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.dZV), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(abZ());
            a(frsRequestData, 4, false);
        }
    }

    private void a(FrsRequestData frsRequestData, int i, boolean z) {
        this.dZP.gr(z);
        this.dZW.lY(i);
        this.dYQ.a(frsRequestData);
        this.mType = i;
        frsRequestData.vq(this.dZP.aBb() ? "1" : "2");
        if (this.eal) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.f.g.nr(this.eak)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.eal = false;
        frsRequestData.setKw(this.dHV);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int aO = com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst());
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst());
        float aR = com.baidu.adp.lib.util.l.aR(TbadkCoreApplication.getInst());
        int i2 = aq.DR().DT() ? 2 : 1;
        frsRequestData.setScrW(aO);
        frsRequestData.setScrH(aQ);
        frsRequestData.setScrDip(aR);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.dYT);
        frsRequestData.setYuelaouLocate(this.eai);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.d(v.Qf(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (FrsFragment.dIf != 0) {
            frsRequestData.setCtime((int) FrsFragment.dIf);
        }
        if (FrsFragment.dIg != 0) {
            frsRequestData.setDataSize((int) FrsFragment.dIg);
        }
        if (FrsFragment.mNetError != 0) {
            frsRequestData.setNetError(FrsFragment.mNetError);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 || this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.f.g.a(this.eaj, frsRequestData);
        b(i, frsRequestData);
        a(this.dHV, frsRequestData);
        if (!na(this.eaj) && !this.dZP.dHW) {
            String d = com.baidu.tieba.tbadkCore.c.bBd().d(this.dHV, frsRequestData.abZ(), frsRequestData.getIsGood(), this.dZV.getCategoryId());
            this.eam = d;
            new a(this, true, d).execute(new Object[0]);
        }
        aFN();
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
        if (iVar == null || iVar.bgi() == null || (com.baidu.tbadk.core.util.ao.isEmpty(iVar.bgi().getName()) && 340001 != iVar.dPc)) {
            return false;
        }
        if (this.isNetFirstLoad) {
            this.bNm = iVar.bBG();
        }
        this.dHF.g(iVar);
        f(this.dHF);
        this.dZU = new ArrayList<>();
        if (frsRequestData != null) {
            this.dZV = frsRequestData;
            this.mPn = this.dZV.getPn();
            this.dHV = this.dZV.getKw();
            this.dZP.setForumName(this.dHV);
            this.dZP.setFrom(this.mFrom);
            this.dZP.setPn(this.mPn);
            this.dZP.setFlag(this.mFlag);
        }
        if (this.dHF.getThreadList() != null) {
            this.dZU.addAll(this.dHF.getThreadList());
        }
        if (this.bNm != 1 && this.isNetFirstLoad) {
            this.dZW.a(7, false, this.dYS);
        } else {
            this.dZW.a(this.mType, false, this.dYS);
        }
        this.mSource = null;
        if (com.baidu.tieba.frs.smartsort.c.b(this.dZV)) {
            aGx();
        }
        this.isNetFirstLoad = false;
        if (iVar.bgi() == null || TextUtils.isEmpty(iVar.bgi().getName()) || frsRequestData == null || r.buz().but() == null) {
            return true;
        }
        r.buz().but().f(iVar.bgi().getName(), frsRequestData.getLoadType(), false);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.i iVar;
        d.a aVar = new d.a();
        aVar.hhQ = com.baidu.adp.lib.util.j.kV() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.hhR = mvcSocketResponsedMessage.getDownSize();
        this.dYS = aVar;
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
        this.dZP.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.i, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.i> mvcNetMessage) {
        FrsRequestData frsRequestData = null;
        if (!this.eah) {
            this.eah = true;
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
        aVar.hhQ = com.baidu.adp.lib.util.j.kV() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.hhR = mvcHttpResponsedMessage.getDownSize();
        this.dYS = aVar;
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
        this.dZP.a(errorData);
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
        if (!this.eah) {
            this.eah = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
        a(true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
    }

    public void aAW() {
        if (this.dHF != null && this.dHF.bgi() != null && this.dHF.bgi().getBannerListData() != null) {
            String lastIds = this.dHF.bgi().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.dYT = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.Pk().Pl()) {
            this.bfW = System.currentTimeMillis() - this.dZP.beginTime;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(i, z, responsedMessage, this.dZP.bfN, this.dZP.createTime, this.dZP.bfV, false, this.bfW);
            this.dZP.createTime = 0L;
            this.dZP.bfN = 0L;
            if (iVar != null) {
                iVar.Ph();
            }
        }
    }

    public void a(boolean z, ResponsedMessage<?> responsedMessage) {
        if (m.Pk().Pl()) {
            this.bfW = System.currentTimeMillis() - this.dZP.dIe;
            com.baidu.tbadk.l.i iVar = new com.baidu.tbadk.l.i(1000, z, responsedMessage, this.dZP.bfN, this.dZP.createTime, this.dZP.bfV, false, this.bfW);
            if (iVar != null) {
                if (this.mType == 4) {
                    iVar.bge = this.bfW;
                    iVar.cL(true);
                } else if (this.mType == 3) {
                    iVar.bgf = this.bfW;
                    iVar.cL(false);
                }
            }
        }
    }

    public FrsRequestData aGi() {
        return this.dZV;
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

    public l aFM() {
        return this.dHF;
    }

    public d.a aGj() {
        return this.dYS;
    }

    private void aFN() {
        this.dpi = System.currentTimeMillis();
        this.dYQ.Ow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.tbadkCore.i iVar) {
        this.isCacheFirstLoad = false;
        this.dHF.g(iVar);
        f(this.dHF);
        this.dZU = new ArrayList<>();
        if (this.dHF.getThreadList() != null) {
            this.dZU.addAll(this.dHF.getThreadList());
        }
        this.dZW.b(iVar);
    }

    private void f(l lVar) {
        if (com.baidu.tieba.frs.vc.f.k(lVar)) {
            this.mPageType = "book_page";
        } else if (lVar.bCl()) {
            this.mPageType = "brand_page";
        } else if (com.baidu.tieba.frs.vc.f.l(lVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.i, Void> {
        private String eas;
        private FrsModelController eat;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.eas = null;
            this.eas = str;
            this.eat = frsModelController;
            this.needCache = z;
            setSelfExecute(true);
            setPriority(4);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Object... objArr) {
            int l;
            CustomResponsedMessage runTask;
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bBd().vo(this.eas)) {
                if (!com.baidu.tieba.tbadkCore.c.bBd().isSameDay(TbadkCoreApplication.getCurrentAccount() + this.eas)) {
                    com.baidu.tieba.tbadkCore.c.bBd().getResponseData().bgi().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.i responseData = com.baidu.tieba.tbadkCore.c.bBd().getResponseData();
                responseData.np(false);
                if (responseData.bBI() != null && !StringUtils.isNull(responseData.bBI().yl(), true) && !responseData.bBI().yl().equals("0") && responseData.bBI().ym() == 3 && (l = com.baidu.adp.lib.g.b.l(responseData.bBI().yl(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(2001423, Integer.class, Long.valueOf(l))) != null) {
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
            if (this.eat != null && iVarArr != null) {
                this.eat.f(iVarArr.length > 0 ? iVarArr[0] : null);
                this.eat.q(this.eat.eaj, true);
            }
        }
    }

    public long avx() {
        return this.dpl;
    }

    public long avy() {
        return this.dpj;
    }

    public long avz() {
        return this.dpk;
    }

    public long avA() {
        return this.dpi;
    }

    public boolean Fi() {
        return this.dYQ.Fi();
    }

    public int aGk() {
        return this.eaa;
    }

    private void aGl() {
        if (this.eag == null) {
            this.eag = new ArrayList<>();
        }
        if (this.eag.size() == 0) {
            this.eag.add(new com.baidu.tieba.frs.v());
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        this.bNm = c(i, null);
        if (aoVar == null && (aoVar = aW(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.l.ll() && this.eaf != null) {
                ar arVar = new ar();
                arVar.hasMore = false;
                arVar.pn = 1;
                arVar.forumName = this.dHV;
                arVar.dLS = false;
                if (this.dHF != null && this.dHF.bgi() != null) {
                    arVar.forumId = this.dHF.bgi().getId();
                }
                aGl();
                this.dHF.ax(this.eag);
                this.eaf.a(i, i2, arVar, this.eag);
            }
            aoVar = new ao();
            aoVar.pn = -1;
        }
        if (this.dHF != null && this.dHF.bgi() != null) {
            aoVar.forumId = this.dHF.bgi().getId();
        }
        aoVar.forumName = this.dHV;
        if (y.aCr().mn(1) != null && this.bNm == 1) {
            this.dZV.setCategoryId(i2);
        }
        this.dZZ = i2;
        this.eab = aoVar;
        b(i, i2, aoVar);
        mW(5);
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.eaf = alVar;
        this.eae.a(this.eao);
    }

    private void mW(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.eab != null) {
                    this.eab.pn++;
                    break;
                }
                break;
            case 2:
                if (this.eab != null) {
                    ao aoVar = this.eab;
                    aoVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.eab != null) {
                    this.eab.pn = -1;
                    break;
                }
                break;
        }
        if (this.bNm == 1) {
            if (this.eaa == this.dZZ) {
                ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
                if (this.dZU != null) {
                    arrayList.addAll(this.dZU);
                }
                this.dHF.ax(arrayList);
                if (this.eaf != null) {
                    this.eaf.a(this.bNm, this.dZZ, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003003, null));
            }
            this.eaa = this.dZZ;
            return;
        }
        ai mo = this.eae.mo(this.bNm);
        if (mo != null) {
            this.eac = true;
            mo.a(this.bNm, this.dZZ, this.eab);
            return;
        }
        if (this.dHF != null && this.dHF.getThreadList() != null) {
            this.dHF.getThreadList().clear();
        }
        this.eaf.a(this.bNm, this.dZZ, null, null);
    }

    public boolean hasMore() {
        if ((this.eab instanceof ar) && ((ar) this.eab).errCode == 0) {
            return ((ar) this.eab).hasMore;
        }
        return true;
    }

    private int aV(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ao aoVar) {
        this.ead.put(aV(i, i2), aoVar);
    }

    public ao aW(int i, int i2) {
        return this.ead.get(aV(i, i2));
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        this.eae.init();
    }

    @Override // com.baidu.tieba.frs.ai
    public void acl() {
        this.eae.destory();
        this.eae.clear();
    }

    public int aGm() {
        return this.bNm;
    }

    public boolean aGn() {
        return 1 == this.bNm;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(com.baidu.tbadk.core.data.ai aiVar) {
        if (aiVar != null && !StringUtils.isNull(aiVar.getId()) && !com.baidu.tbadk.core.util.v.I(this.dZU)) {
            if (this.bNm == 1) {
                this.dHF.a(aiVar);
            }
            int aGo = aGo();
            Iterator<com.baidu.adp.widget.ListView.h> it = this.dZU.iterator();
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if ((next instanceof bb) && aiVar.getId().equals(((bb) next).getId())) {
                    return;
                }
            }
            this.dZU.add(aGo, aiVar);
        }
    }

    public int aGo() {
        int i = 0;
        if (this.dZU == null || this.dZU.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.h> it = this.dZU.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                com.baidu.adp.widget.ListView.h next = it.next();
                if (!(next instanceof bb)) {
                    i = i2;
                } else if (((bb) next).zB() != 0) {
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

    public boolean aGp() {
        return this.eac;
    }

    public void aGq() {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        if (this.eaa == 0) {
            mVar.mi(this.eaj);
        }
        if (this.dHF.getThreadList() != null) {
            this.dHF.getThreadList().clear();
            this.dHF.getThreadList().add(mVar);
        }
        if (this.dZU != null) {
            this.dZU.clear();
            this.dZU.add(mVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aGr() {
        return this.dZU;
    }

    public void nb(int i) {
        this.eaj = i;
        com.baidu.tieba.frs.f.g.ae(this.dHV, this.eaj);
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.e.bEp();
        } else {
            com.baidu.tieba.tbadkCore.util.e.bEq();
        }
    }

    public void nc(int i) {
        this.eak = i;
    }

    public void hl(boolean z) {
        this.eal = z;
    }

    public int aGs() {
        return this.eaj;
    }

    public int abZ() {
        return com.baidu.tieba.frs.f.g.nr(this.eaj);
    }

    public boolean aGt() {
        return this.dZX;
    }

    public boolean aGu() {
        return this.eaj == 5;
    }

    public boolean aGv() {
        return this.dZV != null && this.dZV.getLoadType() == 1;
    }

    public boolean aGw() {
        return this.eaj == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.dZP.aAz() != null) {
            return this.dZP.aAz().a(this.eaj, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bb.ats.get() && r.buz().but() != null) {
            int aa = r.buz().but().aa(str, false);
            int ab = r.buz().but().ab(str, false);
            if (frsRequestData.getLoadType() == 1) {
                aa++;
            } else if (frsRequestData.getLoadType() == 2) {
                ab++;
            }
            frsRequestData.setRefreshCount(aa);
            frsRequestData.setLoadCount(ab);
        }
    }

    public void aGx() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.dHF != null && this.dHF.bgi() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.d(this.dHF.bgi().getId(), 0L));
        }
        this.dZP.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void oB(final String str) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.2
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bBd().cH(FrsModelController.this.eam, str);
                return null;
            }
        }, null);
    }

    public void oC(final String str) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.3
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bBd().cI(FrsModelController.this.eam, str);
                return null;
            }
        }, null);
    }

    public void oD(final String str) {
        x.a(new w<Object>() { // from class: com.baidu.tieba.frs.mc.FrsModelController.4
            @Override // com.baidu.tbadk.util.w
            public Object doInBackground() {
                com.baidu.tieba.tbadkCore.c.bBd().cJ(FrsModelController.this.eam, str);
                return null;
            }
        }, null);
    }
}
