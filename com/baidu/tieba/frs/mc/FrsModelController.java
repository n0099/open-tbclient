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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.j.aa;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.RequestIncrForumAccessCountNetMessage;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.frs.bn;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.frs.bs;
import com.baidu.tieba.frs.by;
import com.baidu.tieba.frs.bz;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.ch;
import com.baidu.tieba.recapp.z;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FrsModelController extends BdBaseModel<BaseFragmentActivity> implements NetModel.b<FrsRequestData, com.baidu.tieba.tbadkCore.l>, by {
    public static final int TAB_ID_ALL_THREAD = 1;
    public static final int TAB_ID_LIVE = 5;
    private long aGy;
    private String agW;
    private long bNb;
    private long bNc;
    private long bNd;
    private long bNe;
    private com.baidu.tieba.tbadkCore.n bTF;
    private String bTS;
    private final com.baidu.tieba.frs.r bTw;
    private ArrayList<com.baidu.adp.widget.ListView.v> ccq;
    private FrsNetModel<com.baidu.tieba.frs.r> ccr;
    private d.a cct;
    private String ccu;
    private boolean ccx;
    private FrsRequestData cef;
    private final com.baidu.tieba.tbadkCore.p ceg;
    private boolean ceh;
    private int cei;
    private int cej;
    private int cek;
    private ce cel;
    private boolean cem;
    private SparseArray<ce> cen;
    private bs ceo;
    private bz cep;
    private ArrayList<com.baidu.adp.widget.ListView.v> ceq;
    private String cer;
    private int ces;
    private int cet;
    private boolean ceu;
    private String cev;
    private final SparseArray<Boolean> cew;
    private bz cex;
    public boolean isCacheFirstLoad;
    public boolean isNetFirstLoad;
    private int mFlag;
    private String mPageType;
    private int mPn;
    private String mSource;
    private int mType;

    public boolean iI(int i) {
        return this.cew.get(i, false).booleanValue();
    }

    public void o(int i, boolean z) {
        this.cew.put(i, Boolean.valueOf(z));
    }

    public FrsModelController(com.baidu.tieba.frs.r rVar, com.baidu.tieba.tbadkCore.p pVar) {
        super(rVar.getPageContext());
        this.bTS = null;
        this.mType = 3;
        this.mPn = 1;
        this.agW = null;
        this.mFlag = 0;
        this.mPageType = "normal_page";
        this.mSource = null;
        this.ccu = null;
        this.cei = 1;
        this.cej = 0;
        this.cek = 0;
        this.cem = false;
        this.isNetFirstLoad = true;
        this.isCacheFirstLoad = true;
        this.cen = new SparseArray<>();
        this.aGy = 0L;
        this.ccx = false;
        this.ces = -1;
        this.cet = -1;
        this.cev = null;
        this.cew = new SparseArray<>();
        this.cex = new i(this);
        this.bNb = 0L;
        this.bNc = 0L;
        this.bNd = 0L;
        this.bNe = 0L;
        if (rVar == null || pVar == null) {
            throw new NullPointerException("FrsActivity or IFrsResultCallback is NullPointerException");
        }
        this.bTw = rVar;
        this.ceg = pVar;
        x(this.bTw);
    }

    private void x(com.baidu.tieba.frs.r rVar) {
        this.ceo = new bs();
        this.ceo.aKZ = rVar.getUniqueId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_ADD_MODEL, this.ceo));
        this.ceo.a(this.cex);
    }

    public void onActivityDestroy() {
        this.ccr.cancelLoadData();
    }

    public void f(Bundle bundle) {
        if (bundle != null) {
            this.bTS = bundle.getString("name");
            this.agW = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            this.cer = bundle.getString(FrsActivityConfig.YUELAOU_LOCATE);
            this.ceh = bundle.getBoolean(FrsActivityConfig.FOLLOWED_HAS_NEW);
        }
        if (TextUtils.isEmpty(this.bTS)) {
            this.bTS = "";
        }
        if (TextUtils.isEmpty(this.agW)) {
            this.agW = "";
        }
        if (TextUtils.isEmpty(this.cer)) {
            this.cer = "";
        }
        this.mSource = this.agW;
        this.cef = new FrsRequestData();
        if (FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(this.mSource)) {
            iK(3);
        } else if (FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(this.mSource)) {
            iK(6);
        } else {
            com.baidu.tieba.frs.smartsort.h jk = com.baidu.tieba.frs.smartsort.e.ads().jk(this.bTS);
            if (jk != null) {
                iK(jk.cfb);
            } else {
                iK(-1);
            }
        }
        this.cef.setSortType(adb());
        if (this.ces == 5) {
            this.cef.setIsGood(1);
        } else {
            this.cef.setIsGood(0);
        }
        this.bTF = new com.baidu.tieba.tbadkCore.n();
        this.ccr = new FrsNetModel<>(this.bTw.getPageContext(), this.cef);
        this.ccr.a(this);
        this.ccr.setUniqueId(this.bTw.getUniqueId());
        if (this.bTS != null && this.bTS.length() > 0) {
            if (this.agW == null || this.agW.length() <= 0) {
                this.agW = FrsActivityConfig.FRS_FROM_LIKE;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.bTS);
        bundle.putString("from", this.agW);
        bundle.putInt(FrsActivityConfig.FLAG, this.mFlag);
    }

    public boolean VL() {
        if (this.cei != 1) {
            iJ(1);
            return true;
        } else if (this.ccr.wq()) {
            return false;
        } else {
            TiebaStatic.eventStat(this.bTw.getActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cef), FrsRequestData.class);
            frsRequestData.setPn(frsRequestData.getPn() + 1);
            frsRequestData.setSortType(adb());
            a(frsRequestData, 1);
            return true;
        }
    }

    public void p(int i, boolean z) {
        if (this.bTF != null && this.bTF.bgC() != null) {
            this.bTF.bgC().clear();
        }
        FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cef), FrsRequestData.class);
        frsRequestData.setPn(1);
        this.cei = c(this.cei, frsRequestData);
        if (this.cei == 1) {
            if (!this.ccr.wq()) {
                a(frsRequestData, i);
                return;
            }
            return;
        }
        if (this.cel == null) {
            this.cel = new ce();
            this.cel.pn = 1;
            this.cel.forumName = this.bTS;
            if (this.bTF != null && this.bTF.aIz() != null) {
                this.cel.forumId = this.bTF.aIz().getId();
            }
        }
        iJ(i);
    }

    public void iG(int i) {
        if (this.cei != 1) {
            iJ(4);
        } else if (!this.ccr.wq()) {
            FrsRequestData frsRequestData = (FrsRequestData) FrsRequestData.objectWithJson(FrsRequestData.jsonWithObject(this.cef), FrsRequestData.class);
            frsRequestData.setPn(i);
            frsRequestData.setSortType(adb());
            a(frsRequestData, 4);
        }
    }

    private void a(FrsRequestData frsRequestData, int i) {
        this.ceg.ii(i);
        this.ccr.a(frsRequestData);
        this.mType = i;
        frsRequestData.qa(this.bTw.aaw() ? "1" : "2");
        if (this.ceu) {
            frsRequestData.setObjSource(String.valueOf(com.baidu.tieba.frs.e.n.iY(this.cet)));
        } else {
            frsRequestData.setObjSource("-2");
        }
        this.ceu = false;
        frsRequestData.setKw(this.bTS);
        if (com.baidu.tbadk.core.r.oN().oT()) {
            frsRequestData.setRn(35);
        } else {
            frsRequestData.setRn(50);
        }
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        int af = com.baidu.adp.lib.util.k.af(this.bTw.getActivity());
        int ag = com.baidu.adp.lib.util.k.ag(this.bTw.getActivity());
        float ah = com.baidu.adp.lib.util.k.ah(this.bTw.getActivity());
        int i2 = av.vl().vn() ? 2 : 1;
        frsRequestData.setScrW(af);
        frsRequestData.setScrH(ag);
        frsRequestData.setScrDip(ah);
        frsRequestData.setqType(i2);
        frsRequestData.setLastId(this.ccu);
        frsRequestData.setYuelaouLocate(this.cer);
        frsRequestData.setLastClickTid(com.baidu.adp.lib.g.b.c(com.baidu.tbadk.util.u.Gx(), 0L));
        if (this.mSource != null) {
            frsRequestData.setStType(this.mSource);
            if ("sidebar".equalsIgnoreCase(this.mSource)) {
                frsRequestData.setStType(null);
            }
        }
        if (com.baidu.tieba.frs.r.bUb != 0) {
            frsRequestData.setCtime((int) com.baidu.tieba.frs.r.bUb);
        }
        if (com.baidu.tieba.frs.r.bUc != 0) {
            frsRequestData.setDataSize((int) com.baidu.tieba.frs.r.bUc);
        }
        if (com.baidu.tieba.frs.r.bUd != 0) {
            frsRequestData.setNetError(com.baidu.tieba.frs.r.bUd);
        }
        frsRequestData.setNeedCache(frsRequestData.getPn() == 1 && this.mType == 3);
        frsRequestData.setUpdateType(this.mType);
        com.baidu.tieba.frs.e.n.a(this.ces, frsRequestData);
        b(i, frsRequestData);
        a(this.bTS, frsRequestData);
        if (!iI(this.ces)) {
            String g = com.baidu.tieba.tbadkCore.c.bgf().g(this.bTS, frsRequestData.adb(), frsRequestData.getIsGood(), this.cef.getCategoryId());
            this.cev = g;
            new a(this, true, g).execute(new Object[0]);
        }
        acL();
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
        if (lVar == null || lVar.aIz() == null || StringUtils.isNull(lVar.aIz().getName()) || lVar.aIz().getName().equals(this.bTS)) {
            if (this.isNetFirstLoad) {
                this.cei = lVar.bgG();
            }
            this.bTF.d(lVar);
            d(this.bTF);
            this.ccq = new ArrayList<>();
            if (frsRequestData != null) {
                this.cef = frsRequestData;
                this.mPn = this.cef.getPn();
                this.bTS = this.cef.getKw();
                this.bTw.setForumName(this.bTS);
                this.bTw.setFrom(this.agW);
                this.bTw.setPn(this.mPn);
                this.bTw.setFlag(this.mFlag);
            }
            if (this.bTF.getThreadList() != null) {
                this.ccq.addAll(this.bTF.getThreadList());
            }
            if (this.cei != 1 && this.isNetFirstLoad) {
                this.ceg.a(7, false, this.cct);
            } else {
                this.ceg.a(this.mType, false, this.cct);
            }
            this.mSource = null;
            if (com.baidu.tieba.frs.smartsort.d.b(this.cef)) {
                adg();
            }
            this.isNetFirstLoad = false;
            if (lVar.aIz() != null && !TextUtils.isEmpty(lVar.aIz().getName()) && frsRequestData != null && z.aZK().aZG() != null) {
                z.aZK().aZG().g(lVar.aIz().getName(), frsRequestData.getLoadType(), false);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.d
    public void a(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        d.a aVar = new d.a();
        aVar.fzd = com.baidu.adp.lib.util.i.hk() && (mvcSocketResponsedMessage.getError() < -13 || mvcSocketResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcSocketResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcSocketResponsedMessage.getError();
        aVar.errorMsg = mvcSocketResponsedMessage.getErrorString();
        aVar.fze = mvcSocketResponsedMessage.getDownSize();
        this.cct = aVar;
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
        this.bTw.a(errorData);
        b(mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage);
    }

    private void b(MvcSocketResponsedMessage<com.baidu.tieba.tbadkCore.l, ?> mvcSocketResponsedMessage, MvcSocketMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcSocketMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        FrsRequestData frsRequestData;
        FrsRequestData frsRequestData2 = null;
        if (!this.ccx) {
            this.ccx = true;
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
            com.baidu.tbadk.core.e.a.a("frs", j, cmd, "socket_resp", error, errorString, objArr);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.c
    public void a(MvcHttpResponsedMessage<com.baidu.tieba.tbadkCore.l> mvcHttpResponsedMessage, MvcHttpMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcHttpMessage, MvcNetMessage<FrsRequestData, com.baidu.tieba.tbadkCore.l> mvcNetMessage) {
        com.baidu.tieba.tbadkCore.l lVar;
        d.a aVar = new d.a();
        aVar.fzd = com.baidu.adp.lib.util.i.hk() && (mvcHttpResponsedMessage.getError() < -13 || mvcHttpResponsedMessage.getError() > -10);
        aVar.isSuccess = mvcHttpResponsedMessage.hasError() ? false : true;
        aVar.errorCode = mvcHttpResponsedMessage.getError();
        aVar.errorMsg = mvcHttpResponsedMessage.getErrorString();
        aVar.fze = mvcHttpResponsedMessage.getDownSize();
        this.cct = aVar;
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
        this.bTw.a(errorData);
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
            com.baidu.tbadk.core.e.a.a("frs", j, cmd, "http_resp", error, errorString, objArr);
        }
        if (!this.ccx) {
            this.ccx = true;
            a(1000, true, (ResponsedMessage<?>) mvcHttpResponsedMessage);
        }
    }

    public void aar() {
        if (this.bTF != null && this.bTF.aIz() != null && this.bTF.aIz().getBannerListData() != null) {
            String lastIds = this.bTF.aIz().getBannerListData().getLastIds();
            if (!TextUtils.isEmpty(lastIds)) {
                this.ccu = lastIds;
            }
        }
    }

    public void a(int i, boolean z, ResponsedMessage<?> responsedMessage) {
        if (aa.FE().FF()) {
            this.aGy = System.currentTimeMillis() - this.bTw.Vq;
            com.baidu.tbadk.j.v vVar = new com.baidu.tbadk.j.v(i, z, responsedMessage, this.bTw.aGp, this.bTw.createTime, this.bTw.aGx, false, this.aGy);
            this.bTw.createTime = 0L;
            this.bTw.aGp = 0L;
            if (vVar != null) {
                vVar.Fz();
            }
        }
    }

    public String acQ() {
        return this.mPageType;
    }

    public int getType() {
        return this.mType;
    }

    public String getForumName() {
        return this.bTS;
    }

    public com.baidu.tieba.tbadkCore.n acK() {
        return this.bTF;
    }

    public d.a acR() {
        return this.cct;
    }

    private void acL() {
        this.bNb = System.currentTimeMillis();
        this.ccr.EA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.l lVar) {
        this.isCacheFirstLoad = false;
        this.bTF.d(lVar);
        d(this.bTF);
        this.ccq = new ArrayList<>();
        if (this.bTF.getThreadList() != null) {
            this.ccq.addAll(this.bTF.getThreadList());
        }
        this.ceg.b(lVar);
    }

    private void d(com.baidu.tieba.tbadkCore.n nVar) {
        if (com.baidu.tieba.frs.f.u.h(nVar)) {
            this.mPageType = "book_page";
        } else if (com.baidu.tieba.frs.f.u.i(nVar)) {
            this.mPageType = "frs_page";
        } else {
            this.mPageType = "normal_page";
        }
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<Object, com.baidu.tieba.tbadkCore.l, Void> {
        private String ceB;
        private FrsModelController ceC;
        private boolean needCache;

        public a(FrsModelController frsModelController, boolean z, String str) {
            this.ceB = null;
            this.ceB = str;
            this.ceC = frsModelController;
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
            if (this.needCache && com.baidu.tieba.tbadkCore.c.bgf().pY(this.ceB)) {
                if (!com.baidu.tieba.tbadkCore.c.bgf().isSameDay(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + this.ceB)) {
                    com.baidu.tieba.tbadkCore.c.bgf().getResponseData().aIz().getSignData().is_signed = 0;
                }
                com.baidu.tieba.tbadkCore.l responseData = com.baidu.tieba.tbadkCore.c.bgf().getResponseData();
                if (responseData.bgI() != null && !StringUtils.isNull(responseData.bgI().getBookId(), true) && !responseData.bgI().getBookId().equals("0") && responseData.bgI().pF() == 3 && (g = com.baidu.adp.lib.g.b.g(responseData.bgI().getBookId(), -1)) > 0 && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_MANGA_READ_RECORD, Integer.class, Long.valueOf(g))) != null) {
                    responseData.d(Integer.valueOf(((Integer) runTask.getData()).intValue()));
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
            if (this.ceC != null && lVarArr != null) {
                this.ceC.c(lVarArr.length > 0 ? lVarArr[0] : null);
                this.ceC.o(this.ceC.ces, true);
            }
        }
    }

    public long XA() {
        return this.bNe;
    }

    public long XB() {
        return this.bNc;
    }

    public long XC() {
        return this.bNd;
    }

    public long XD() {
        return this.bNb;
    }

    public boolean wq() {
        return this.ccr.wq();
    }

    public int acS() {
        return this.cek;
    }

    private void acT() {
        if (this.ceq == null) {
            this.ceq = new ArrayList<>();
        }
        if (this.ceq.size() == 0) {
            this.ceq.add(new bn());
        }
    }

    @Override // com.baidu.tieba.frs.by
    public void a(int i, int i2, ce ceVar) {
        this.cei = c(i, null);
        if (ceVar == null && (ceVar = an(i, i2)) == null) {
            if (i != 1 && com.baidu.adp.lib.util.k.hB() && this.cep != null) {
                ch chVar = new ch();
                chVar.hasMore = false;
                chVar.pn = 1;
                chVar.forumName = this.bTS;
                chVar.bXa = false;
                if (this.bTF != null && this.bTF.aIz() != null) {
                    chVar.forumId = this.bTF.aIz().getId();
                }
                acT();
                this.bTF.ay(this.ceq);
                this.cep.a(i, i2, chVar, this.ceq);
            }
            ceVar = new ce();
            ceVar.pn = -1;
        }
        if (this.bTF != null && this.bTF.aIz() != null) {
            ceVar.forumId = this.bTF.aIz().getId();
        }
        ceVar.forumName = this.bTS;
        if (bq.abd().io(1) != null && this.cei == 1) {
            this.cef.setCategoryId(i2);
        }
        this.cej = i2;
        this.cel = ceVar;
        b(i, i2, ceVar);
        iJ(5);
    }

    @Override // com.baidu.tieba.frs.by
    public void a(bz bzVar) {
        this.cep = bzVar;
        this.ceo.a(this.cex);
    }

    private void iJ(int i) {
        this.mType = i;
        switch (i) {
            case 1:
            case 4:
                if (this.cel != null) {
                    this.cel.pn++;
                    break;
                }
                break;
            case 2:
                if (this.cel != null) {
                    ce ceVar = this.cel;
                    ceVar.pn--;
                    break;
                }
                break;
            case 3:
                if (this.cel != null) {
                    this.cel.pn = -1;
                    break;
                }
                break;
        }
        if (this.cei == 1) {
            if (this.cek == this.cej) {
                ArrayList<com.baidu.adp.widget.ListView.v> arrayList = new ArrayList<>();
                if (this.ccq != null) {
                    arrayList.addAll(this.ccq);
                }
                this.bTF.ay(arrayList);
                if (this.cep != null) {
                    this.cep.a(this.cei, this.cej, null, arrayList);
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_REFRESH, null));
            }
            this.cek = this.cej;
            return;
        }
        by ip = this.ceo.ip(this.cei);
        if (ip != null) {
            this.cem = true;
            ip.a(this.cei, this.cej, this.cel);
            return;
        }
        if (this.bTF != null && this.bTF.getThreadList() != null) {
            this.bTF.getThreadList().clear();
        }
        this.cep.a(this.cei, this.cej, null, null);
    }

    public boolean hasMore() {
        if ((this.cel instanceof ch) && ((ch) this.cel).errCode == 0) {
            return ((ch) this.cel).hasMore;
        }
        return true;
    }

    private int am(int i, int i2) {
        return (i * 10) + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, ce ceVar) {
        this.cen.put(am(i, i2), ceVar);
    }

    public ce an(int i, int i2) {
        return this.cen.get(am(i, i2));
    }

    @Override // com.baidu.tieba.frs.by
    public void init() {
        this.ceo.init();
    }

    @Override // com.baidu.tieba.frs.by
    public void MT() {
        this.ceo.destory();
        this.ceo.clear();
    }

    public int acU() {
        return this.cei;
    }

    public boolean acV() {
        return 1 == this.cei;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void registerListener(MessageListener<?> messageListener) {
        super.registerListener(messageListener);
    }

    public void a(ao aoVar) {
        if (aoVar != null && !StringUtils.isNull(aoVar.getId()) && this.ccq != null) {
            if (this.cei == 1) {
                this.bTF.a(aoVar);
            }
            int acW = acW();
            if (this.ccq != null && this.ccq.size() > 0) {
                int size = this.ccq.size();
                for (int i = 0; i < size; i++) {
                    com.baidu.adp.widget.ListView.v vVar = this.ccq.get(i);
                    if ((vVar instanceof bl) && aoVar.getId().equals(((bl) vVar).getId())) {
                        return;
                    }
                }
            }
            if (aoVar.getThreadType() == 33) {
                ax axVar = new ax();
                axVar.a(aoVar, -1);
                axVar.setPost_num(1);
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.ccq.add(acW, axVar);
                    return;
                }
                return;
            }
            this.ccq.add(acW, aoVar);
        }
    }

    public int acW() {
        if (this.ccq == null || this.ccq.size() <= 0) {
            return 0;
        }
        Iterator<com.baidu.adp.widget.ListView.v> it = this.ccq.iterator();
        int i = 0;
        while (it.hasNext()) {
            com.baidu.adp.widget.ListView.v next = it.next();
            if (next instanceof bl) {
                if (((bl) next).rq() != 0) {
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

    public boolean acX() {
        return this.cem;
    }

    public void acY() {
        bb bbVar = new bb();
        if (this.cek == 0) {
            bbVar.in(this.ces);
        }
        if (this.bTF.getThreadList() != null) {
            this.bTF.getThreadList().clear();
            this.bTF.getThreadList().add(bbVar);
        }
        if (this.ccq != null) {
            this.ccq.clear();
            this.ccq.add(bbVar);
        }
    }

    public ArrayList<com.baidu.adp.widget.ListView.v> acZ() {
        return this.ccq;
    }

    public void iK(int i) {
        this.ces = i;
        if (7 == i) {
            com.baidu.tieba.tbadkCore.util.s.bjc();
        } else {
            com.baidu.tieba.tbadkCore.util.s.bjd();
        }
    }

    public void iL(int i) {
        this.cet = i;
    }

    public void eu(boolean z) {
        this.ceu = z;
    }

    public int ada() {
        return this.ces;
    }

    public int adb() {
        return com.baidu.tieba.frs.e.n.iY(this.ces);
    }

    public boolean adc() {
        return this.ceh;
    }

    public boolean add() {
        return this.ces == 5;
    }

    public boolean ade() {
        return this.cef != null && this.cef.getLoadType() == 1;
    }

    public boolean adf() {
        return this.ces == 7;
    }

    private int c(int i, FrsRequestData frsRequestData) {
        if (i == 1 && this.bTw.ZU() != null) {
            return this.bTw.ZU().a(this.ces, frsRequestData);
        }
        return i;
    }

    private void a(String str, FrsRequestData frsRequestData) {
        if (bl.Xw.get() && z.aZK().aZG() != null) {
            int O = z.aZK().aZG().O(str, false);
            int P = z.aZK().aZG().P(str, false);
            if (frsRequestData.getLoadType() == 1) {
                O++;
            } else if (frsRequestData.getLoadType() == 2) {
                P++;
            }
            frsRequestData.setRefreshCount(O);
            frsRequestData.setLoadCount(P);
        }
    }

    public void adg() {
        RequestIncrForumAccessCountNetMessage requestIncrForumAccessCountNetMessage = new RequestIncrForumAccessCountNetMessage();
        if (this.bTF != null && this.bTF.aIz() != null) {
            requestIncrForumAccessCountNetMessage.setForumId(com.baidu.adp.lib.g.b.c(this.bTF.aIz().getId(), 0L));
        }
        this.bTw.sendMessage(requestIncrForumAccessCountNetMessage);
    }

    public void je(String str) {
        com.baidu.tbadk.util.w.a(new j(this, str), null);
    }

    public void jf(String str) {
        com.baidu.tbadk.util.w.a(new k(this, str), null);
    }
}
