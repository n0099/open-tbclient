package com.baidu.tieba.frs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.a.a.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.InjectPlugin.a.b;
import com.baidu.tieba.frs.d.m;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class r extends BaseFragment implements a.InterfaceC0000a, BdListView.e, f.c, UserIconBox.b, VoiceManager.c, b, bw, bz, com.baidu.tieba.frs.mc.y, com.baidu.tieba.recapp.u {
    private com.baidu.tbadk.util.s aJs;
    private com.baidu.adp.lib.e.b<TbImageView> amv;
    private com.baidu.tieba.frs.entelechy.b.a bNZ;
    private com.baidu.tieba.frs.mc.s bOA;
    private com.baidu.tieba.frs.mc.b bOB;
    private com.baidu.tieba.frs.smartsort.c bOC;
    private com.baidu.tieba.frs.mc.d bOD;
    private ca bOE;
    private com.baidu.tieba.frs.entelechy.b.b bOG;
    private com.baidu.tbadk.h.a bOH;
    private com.baidu.tieba.frs.e.a bOI;
    private com.baidu.tieba.frs.mc.l bOJ;
    private com.baidu.tieba.frs.mc.h bOK;
    private com.baidu.tieba.frs.e.ag bOL;
    private com.baidu.tieba.frs.mc.a bOM;
    private as bON;
    public com.baidu.tieba.frs.e.f bOO;
    private com.baidu.tieba.frs.mc.p bOP;
    private Intent bOQ;
    private int bOR;
    private View.OnTouchListener bOS;
    private boolean bOd;
    public com.baidu.tbadk.core.data.bk bOe;
    private com.baidu.tieba.tbadkCore.data.e bOj;
    private VoiceManager bOm;
    private m.a bOu;
    private FrsModelController bOw;
    private com.baidu.tieba.frs.e.u bOx;
    private com.baidu.tieba.frs.view.k bOy;
    private com.baidu.tieba.frs.entelechy.b.d bOz;
    private boolean bPe;
    public View mRootView;
    private static boolean isNeedRefreshOnResume = false;
    public static boolean bOc = false;
    public static volatile long bOo = 0;
    public static volatile long bOp = 0;
    public static volatile int bOq = 0;
    public boolean bOa = false;
    private boolean bOb = false;
    public String bOf = null;
    public String ahf = null;
    public int mFlag = 0;
    private boolean bOg = false;
    private boolean bOh = false;
    private String mThreadId = null;
    private String forumId = null;
    private int bNW = 0;
    private boolean bOi = false;
    private boolean bOk = false;
    private boolean bOl = false;
    private at bOn = null;
    public final com.baidu.tbadk.core.data.bk aSs = null;
    private com.baidu.tieba.tbadkCore.n bNT = new com.baidu.tieba.tbadkCore.n();
    public long bGR = -1;
    public long aGK = 0;
    public long aGC = 0;
    public long createTime = 0;
    public long VD = -1;
    private boolean bOr = false;
    private boolean bOs = false;
    public com.baidu.tbadk.j.e bOt = null;
    private boolean bOv = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> bOF = new SparseArray<>();
    private boolean bAr = true;
    private final CustomMessageListener bOT = new s(this, CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED);
    private final by bOU = new ae(this);
    private bx bOV = new aj(this);
    private CustomMessageListener bOW = new ak(this, CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT);
    private CustomMessageListener bOX = new al(this, CmdConfigCustom.CMD_FRS_TAB_LIVE_START);
    private final CustomMessageListener bOY = new am(this, CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB);
    private final CustomMessageListener bOZ = new an(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private final CustomMessageListener bPa = new ao(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    public final com.baidu.tieba.tbadkCore.p bPb = new ap(this);
    private final CustomMessageListener bPc = new t(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private final CustomMessageListener mMemListener = new u(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private final com.baidu.tieba.frs.mc.x bPd = new v(this);
    public final View.OnTouchListener aJt = new w(this);
    private final CustomMessageListener bPf = new x(this, CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE);
    private final CustomMessageListener bPg = new y(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);
    public final View.OnClickListener bPh = new z(this);
    private final AbsListView.OnScrollListener bPi = new aa(this);
    private final n bPj = new ab(this);
    private final NoNetworkView.a bNr = new ad(this);
    private final CustomMessageListener bPk = new af(this, 0);
    private com.baidu.adp.widget.ListView.w bPl = new a(this, null);
    private by bPm = new ag(this);

    public com.baidu.tieba.frs.entelechy.b.b YQ() {
        return this.bOG;
    }

    public com.baidu.adp.widget.ListView.w YR() {
        return this.bPl;
    }

    public com.baidu.tieba.frs.mc.l YS() {
        return this.bOJ;
    }

    public com.baidu.tieba.frs.smartsort.c YT() {
        return this.bOC;
    }

    @Override // com.baidu.tieba.frs.mc.y
    public FrsModelController YU() {
        return this.bOw;
    }

    @Override // com.baidu.tieba.frs.mc.y
    public com.baidu.tieba.frs.mc.h YV() {
        return this.bOK;
    }

    @Override // com.baidu.tieba.frs.mc.y
    public com.baidu.tieba.frs.e.u YW() {
        return this.bOx;
    }

    public com.baidu.tieba.frs.entelechy.b.d YX() {
        return this.bOz;
    }

    public ca YY() {
        return this.bOE;
    }

    @Override // com.baidu.tieba.frs.mc.y
    public at YZ() {
        return this.bOn;
    }

    @Override // com.baidu.tieba.frs.bz
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.bz
    public String getForumName() {
        return this.bOf;
    }

    public void setForumName(String str) {
        this.bOf = str;
    }

    public void setFrom(String str) {
        this.ahf = str;
    }

    public String getFrom() {
        return this.ahf;
    }

    public void setFlag(int i) {
        this.mFlag = i;
    }

    @Override // com.baidu.tieba.recapp.u
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.u
    public com.baidu.adp.widget.ListView.a k(BdUniqueId bdUniqueId) {
        return c.YE().b(getPageContext(), bdUniqueId, getUniqueId());
    }

    @Override // com.baidu.tieba.recapp.u
    public int getPageNum() {
        if (this.bOK == null) {
            return 1;
        }
        return this.bOK.getPn();
    }

    public int getPn() {
        if (this.bOK == null) {
            return 1;
        }
        return this.bOK.getPn();
    }

    public void setPn(int i) {
        if (this.bOK != null) {
            this.bOK.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.bOK != null) {
            this.bOK.setHasMore(i);
        }
    }

    public int Za() {
        if (this.bOK == null) {
            return -1;
        }
        return this.bOK.Za();
    }

    public boolean Zb() {
        return this.bOl;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar, boolean z) {
        if (aVar == null) {
            showNetRefreshView(this.bOn.ZP(), TbadkCoreApplication.m9getInst().getString(w.l.error_unkown_try_again), true);
        } else if (aVar.frm) {
            if (340001 == aVar.errorCode) {
                showNetRefreshViewNoClick(this.bOn.ZP(), TbadkCoreApplication.m9getInst().getString(w.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
            } else {
                showNetRefreshView(this.bOn.ZP(), TbadkCoreApplication.m9getInst().getString(w.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
            }
        } else if (340001 == aVar.errorCode) {
            showNetRefreshViewNoClick(this.bOn.ZP(), aVar.errorMsg, true);
        } else {
            showNetRefreshView(this.bOn.ZP(), aVar.errorMsg, true);
        }
        if (Zt()) {
            setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds280));
        } else {
            setNetRefreshViewEmotionDefMarginTop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zc() {
        hideLoadingView(this.bOn.ZP());
        this.bOn.ci(false);
        this.bOn.ZK();
        if (this.bOn.Zz() instanceof com.baidu.tieba.frs.tab.i) {
            ((com.baidu.tieba.frs.tab.i) this.bOn.Zz()).acw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zd() {
        if (Za() == 0 && com.baidu.tbadk.core.util.x.r(this.bNT.beW())) {
            if (com.baidu.tbadk.core.util.x.r(this.bNT.getThreadList())) {
                this.bOn.UA();
                return;
            } else {
                this.bOn.JO();
                return;
            }
        }
        this.bOn.ZS();
    }

    public void a(ErrorData errorData) {
        Zc();
        this.bOn.ZE();
        d.a abN = this.bOw.abN();
        boolean r = com.baidu.tbadk.core.util.x.r(this.bNT.getThreadList());
        if (abN != null && r) {
            if (r) {
                if (this.bOw.abO() != 0) {
                    this.bOw.abU();
                    this.bOn.ZE();
                } else {
                    a(abN, false);
                }
                this.bOn.n(this.bNT.bfP(), false);
                return;
            } else if (abN.frm) {
                this.bOn.n(true, false);
                showToast(getPageContext().getResources().getString(w.l.net_error_text, abN.errorMsg, Integer.valueOf(abN.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(abN, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ze() {
        if (this.bNT == null || this.bNT.aHE() != null) {
            this.bOn.ZN();
        } else if (this.bNT.aHE().getYuleData() != null && this.bNT.aHE().getYuleData().sV()) {
            TiebaStatic.log("c10852");
            this.bOn.a(this.bNT.aHE().getYuleData().sW());
        } else {
            this.bOn.ZN();
        }
    }

    private void dI(boolean z) {
        if (this.bOw != null && this.bNT != null && this.bOn != null && z) {
            if (!this.bOw.acb() && this.bOw.abQ() == 1) {
                if (!this.bOw.abZ()) {
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.bNT.bfJ();
                        this.bNT.bfG();
                    }
                    this.bNT.bfH();
                    this.bNT.bfI();
                }
                boolean z2 = false;
                if (this.bOn.ZO().l(com.baidu.tieba.card.data.p.bxM)) {
                    z2 = this.bNT.bfL();
                }
                if (!z2) {
                    this.bNT.bfK();
                }
                if (TbadkCoreApplication.m9getInst().isRecAppExist()) {
                    this.bNT.D(getPageContext());
                }
                if (!this.bOn.ZO().l(com.baidu.tbadk.core.data.bk.Xw)) {
                    this.bNT.bfD();
                }
                this.bNT.bfM();
                this.bNT.bfN();
            }
            this.bNT.bfE();
            this.bNT.bfB();
        }
    }

    public boolean Zf() {
        if (this.bOz != null && this.bOn != null) {
            this.bOz.b(this.bOn.getListView());
        }
        if (this.bOx != null && this.bOw != null) {
            this.bOx.a(this.bOw.abM(), this.bNT);
        }
        boolean z = false;
        if (this.bNT != null) {
            z = this.bNT.bfQ();
        }
        dJ(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI(int i) {
        cd cdVar = null;
        Zf();
        Zo();
        try {
            if (this.bNT != null) {
                this.bOn.a((ArrayList<com.baidu.adp.widget.ListView.v>) null, this.bNT);
                this.bOx.iD(1);
                this.bOn.ZH();
                this.bOz.a(this.bOn.getListView(), this.bNT, this.bOw.abW());
                com.baidu.tieba.frs.tab.j a2 = a(this.bOz.aaN(), this.bNT.bfl());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    cdVar = new cd();
                    cdVar.bRh = a2.url;
                    cdVar.stType = a2.name;
                }
                this.bOw.a(this.bNT.bfl(), 0, cdVar);
                this.bOz.dY(false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private com.baidu.tieba.frs.tab.j a(TabData tabData, int i) {
        if (i < 0 || tabData == null || tabData.size() <= 0) {
            return null;
        }
        Iterator it = tabData.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.j jVar = (com.baidu.tieba.frs.tab.j) it.next();
            if (jVar != null && jVar.bZw == i) {
                return jVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z, boolean z2) {
        try {
            if (this.bNT != null && this.bOz != null && this.bOw != null) {
                if (!this.bOn.ZO().l(com.baidu.tbadk.core.data.bk.Xw)) {
                    this.bNT.bfD();
                }
                if (this.bNT.aHE() != null) {
                    this.bOf = this.bNT.aHE().getName();
                    this.forumId = this.bNT.aHE().getId();
                }
                if (this.bNT.bfQ()) {
                    this.bOz.a(this.bOn.getListView(), this.bNT, this.bOw.abW());
                }
                if (z) {
                    dI(true);
                } else {
                    dI(this.bOv);
                }
                Zf();
                if (this.bOG != null) {
                    this.bOG.a(this.bOx, this.bNT);
                }
                if (this.bNT.qB() != null) {
                    setHasMore(this.bNT.qB().qx());
                }
                ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bOK.a(z2, true, this.bNT.getThreadList(), null);
                if (a2 != null) {
                    this.bNT.ay(a2);
                }
                if (this.bOw.abQ() == 1) {
                    Zk();
                }
                this.bNW = this.bNT.abS();
                if (this.bOj != null) {
                    this.bOi = true;
                    this.bOj.rM(this.bNW);
                    com.baidu.tieba.frs.d.a.a(getPageContext(), this.bNT.aHE(), this.bNT.getThreadList(), this.bOi, getPn());
                }
                if (this.bOI != null) {
                    this.bOI.ch(this.bOw.acb());
                    this.bOI.ah(this.bOz.aaO());
                }
                Zc();
                this.bOn.n(true, false);
                if (this.bOb) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_FRS_DATA_RECEIVE, this.bOf));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.l lVar) {
        try {
            if (!this.bOr && lVar != null && this.bNT != null) {
                this.bNT.d(lVar);
                m(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void dJ(boolean z) {
        if (this.bOw != null) {
            e(z, this.bOw.abM());
        } else {
            e(z, "normal_page");
        }
    }

    private void e(boolean z, String str) {
        dK("frs_page".equals(str));
        if (this.bOG != null) {
            this.bOG.a(z, this.bOz, this.bOx, this.bOn, this.bNT);
        }
    }

    public void dK(boolean z) {
        if (this.bOL != null) {
            this.bOL.a(this.bOn, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(w.j.frs_activity, viewGroup, false);
            this.bNZ = new com.baidu.tieba.frs.entelechy.b();
            this.bOG = this.bNZ.aal();
            this.bOx = new com.baidu.tieba.frs.e.u(this, this.bNZ);
            this.bOz = this.bNZ.w(this);
            Intent intent = this.bOQ != null ? this.bOQ : getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.bOb = true;
            }
            this.bOn = new at(this, this.bPh, this.bNZ, this.bOb);
            this.bOn.setHeaderViewHeight(this.bOR);
        } else if (this.mRootView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = this.bOQ != null ? this.bOQ : getActivity().getIntent();
        this.bGR = System.currentTimeMillis();
        if (intent != null) {
            this.bOk = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.bGR = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            J(intent);
        }
        this.VD = System.currentTimeMillis();
        this.aGC = this.VD - this.bGR;
        this.bOj = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.ftJ);
        this.bOw = new FrsModelController(this, this.bPb);
        this.bOw.a(this.bOU);
        this.bOw.init();
        if (intent != null) {
            this.bOw.f(intent.getExtras());
        } else if (bundle != null) {
            this.bOw.f(bundle);
        } else {
            this.bOw.f(null);
        }
        this.bOz.af(this.bOn.ZP());
        if (intent != null) {
            this.bOx.h(intent.getExtras());
        } else if (bundle != null) {
            this.bOx.h(bundle);
        } else {
            this.bOx.h((Bundle) null);
        }
        this.bOm = getVoiceManager();
        this.bON = new as(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!Zt()) {
            this.bOE = new ca(getActivity(), this.bOn, this.bOx);
            this.bOE.dU(true);
        }
        this.bOm = getVoiceManager();
        if (this.bOm != null) {
            this.bOm.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.v();
        this.bOK = new com.baidu.tieba.frs.mc.h(this, this.bPd);
        this.bOC = new com.baidu.tieba.frs.smartsort.c(this);
        this.bOL = new com.baidu.tieba.frs.e.ag(this);
        this.createTime = System.currentTimeMillis() - this.VD;
        this.bOI = new com.baidu.tieba.frs.e.a(getPageContext(), this.bOw.abY());
        this.bOD = new com.baidu.tieba.frs.mc.d(this);
        this.bOJ = new com.baidu.tieba.frs.mc.l(this);
        this.bOA = new com.baidu.tieba.frs.mc.s(this);
        this.bOB = new com.baidu.tieba.frs.mc.b(this);
        this.bOM = new com.baidu.tieba.frs.mc.a(this);
        this.bOO = new com.baidu.tieba.frs.e.f(this);
        this.bOP = new com.baidu.tieba.frs.mc.p(this, getUniqueId());
        registerListener(this.mMemListener);
        registerListener(this.bPa);
        registerListener(this.bPf);
        registerListener(this.bOZ);
        registerListener(this.bPc);
        registerListener(this.bOW);
        registerListener(this.bOX);
        registerListener(this.bOY);
        registerListener(this.bOT);
        this.bOn.dP(false);
        if (!Zt()) {
            showLoadingView(this.bOn.ZP(), true);
            this.bOw.o(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.bw
    public void Zg() {
        if (isAdded() && this.bAr && !isLoadingViewAttached()) {
            showLoadingView(this.bOn.ZP(), true);
        }
    }

    @Override // com.baidu.tieba.frs.bw
    public void Zh() {
        if (isAdded() && this.bAr && isLoadingViewAttached()) {
            hideLoadingView(this.bOn.ZP());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (Zt()) {
            showLoadingView(this.bOn.ZP(), true);
            this.bOn.hL(TbadkCoreApplication.m9getInst().getMainTabBottomBarHeight());
            this.bOw.o(3, true);
            getListView().setSelection(0);
        }
    }

    @Override // com.baidu.tieba.frs.bw
    public void setHeaderViewHeight(int i) {
        this.bOR = i;
        if (this.bOn != null) {
            this.bOn.setHeaderViewHeight(this.bOR);
        }
    }

    @Override // com.baidu.tieba.frs.bw
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.t tVar) {
        if (tVar != null) {
            this.aJs = tVar.GB();
            this.bOS = tVar.GC();
        }
    }

    @Override // com.baidu.tieba.frs.bw
    public void Xb() {
        if (this.aJs != null) {
            this.aJs.ce(true);
        }
    }

    private void J(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.d.m.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
                getActivity().finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.bOf = data.getQueryParameter("name");
            this.ahf = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.bOf)) {
                intent.putExtra("name", this.bOf);
            }
            if (!StringUtils.isNull(this.ahf)) {
                intent.putExtra("from", this.ahf);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.bOf)) {
            this.bOf = com.baidu.tieba.frs.d.p.L(intent);
            if (!StringUtils.isNull(this.bOf)) {
                intent.putExtra("name", this.bOf);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.bOm = getVoiceManager();
        if (this.bOm != null) {
            this.bOm.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bPk);
        if (bundle != null) {
            this.bOf = bundle.getString("name");
            this.ahf = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                this.bOf = intent.getStringExtra("name");
                this.ahf = intent.getStringExtra("from");
                this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.ahf)) {
            FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.ahf);
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.bPk);
        }
        this.bOx.h(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bOm != null) {
            this.bOm.onDestory(getPageContext());
        }
        this.bOm = null;
        com.baidu.tieba.card.ca.To().dc(false);
        if (this.bNT != null && this.bNT.aHE() != null) {
            bt.aad().aP(com.baidu.adp.lib.g.b.c(this.bNT.aHE().getId(), 0L));
        }
        if (this.bOn != null) {
            com.baidu.tieba.frs.d.o.a(this.bOn, this.bNT, getForumId(), false, null);
            this.bOn.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.bOt != null) {
                this.bOt.onDestroy();
            }
            this.bOn.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.bOw.onActivityDestroy();
        this.bOx.onActivityDestroy();
        if (this.bOu != null) {
            this.bOu.cancel(true);
            this.bOu = null;
        }
        if (this.bOw != null) {
            this.bOw.ML();
        }
        if (this.bOE != null) {
            this.bOE.GA();
        }
        if (this.bOH != null) {
            this.bOH.destory();
        }
        if (this.bOI != null) {
            this.bOI.destory();
        }
        if (this.bOC != null) {
            this.bOC.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.aYU().aYW();
        com.baidu.tieba.frs.d.q.acz();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.bOf);
        bundle.putString("from", this.ahf);
        this.bOw.onSaveInstanceState(bundle);
        if (this.bOm != null) {
            this.bOm.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.bOM != null) {
            this.bOM.onActivityResult(i, i2, intent);
        }
    }

    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bOH == null) {
                this.bOH = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.bOH.ao(updateAttentionMessage.getData().toUid, getForumId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bOn != null) {
            this.bOn.ZE();
            this.bOn.onResume();
            com.baidu.tieba.frs.d.p.k(this.bOn);
        }
        this.bOz.a(this.bOV);
        this.bOA.ef(true);
        this.bOv = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.bOn.startPullRefresh();
        } else if (bOc) {
            bOc = false;
            this.bOn.startPullRefresh();
        } else {
            if (this.bOm != null) {
                this.bOm.onResume(getPageContext());
            }
            this.bOn.dQ(false);
            registerListener(this.bPg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        refresh();
    }

    @Override // com.baidu.tieba.frs.bw
    public void K(Intent intent) {
        this.bOQ = intent;
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.bOf = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.ahf = intent.getStringExtra("from");
            }
            this.bOh = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.bOh) {
                Zi();
            }
        }
    }

    private void Zi() {
        this.bOn.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.d.p.a(getPageContext(), getActivity().getIntent(), this.ahf);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.bOn.setTitle(this.bOf);
        } else {
            this.bOn.setTitle("");
            this.mFlag = 1;
        }
        this.bOx.d(this.bOn.getListView());
        this.bOn.setOnAdapterItemClickListener(this.bPl);
        this.bOn.setOnScrollListener(this.bPi);
        this.bOn.h(this.bNr);
        this.bOn.ZO().a(this.bPj);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bOn.onChangeSkinType(i);
        this.bOx.iC(i);
        this.bOz.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.f.c
    public void lB() {
    }

    @Override // com.baidu.adp.widget.f.c
    public void lC() {
    }

    public void hJ(int i) {
        if (!this.mIsLogin) {
            if (this.bNT != null && this.bNT.ql() != null) {
                this.bNT.ql().setIfpost(1);
            }
            if (i == 0) {
                bg.aL(getActivity());
            }
        } else if (this.bNT != null) {
            if (i == 0) {
                if (!this.bOd) {
                    com.baidu.tieba.frs.d.q.b(this, 0);
                    return;
                }
                TiebaStatic.log("c10152");
                com.baidu.tieba.frs.d.q.b(this, 4);
                return;
            }
            this.bOn.ZG();
        }
    }

    public void refresh() {
        ch(3);
    }

    public void ch(int i) {
        this.bOr = false;
        Zo();
        if (this.bOn.Kq() != null) {
            this.bOn.Kq().ajv();
        }
        this.bOw.o(i, true);
    }

    private void Zj() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.k.fT().f(new ai(this));
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zk() {
        Zo();
        try {
            if (this.bNT != null) {
                this.bOn.Kn();
                this.bOn.dM(this.bOw.abR());
                if (com.baidu.tieba.frs.e.u.i(this.bNT) && !com.baidu.tieba.frs.e.u.h(this.bNT)) {
                    this.bOn.ZT();
                }
                if (this.bNT.aHE() != null) {
                    this.bOf = this.bNT.aHE().getName();
                    this.forumId = this.bNT.aHE().getId();
                }
                if (this.bNT.qB() != null) {
                    setHasMore(this.bNT.qB().qx());
                }
                this.bOn.setTitle(this.bOf);
                this.bOn.setForumName(this.bOf);
                TbadkCoreApplication.m9getInst().setDefaultBubble(this.bNT.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(this.bNT.getUserData().getBimg_end_time());
                Zj();
                Zl();
                ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bNT.getThreadList();
                if (threadList != null) {
                    this.bOn.a(threadList, this.bNT);
                    com.baidu.tieba.frs.d.c.j(this.bOn);
                    this.bOx.iD(getPageNum());
                    this.bOx.f(this.bNT);
                    this.bOz.a(this.bOn.getListView(), this.bNT, this.bOw.abW());
                    this.bOn.ZH();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void Zl() {
        if (this.bNT != null) {
            if (this.bNT.aHS() == 1) {
                this.bOn.ZO().setFromCDN(true);
            } else {
                this.bOn.ZO().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bOA.ef(false);
        this.bOv = false;
        this.bOn.onPause();
        if (this.bOm != null) {
            this.bOm.onPause(getPageContext());
        }
        this.bOn.dQ(true);
        if (this.bOI != null) {
            this.bOI.acC();
        }
        MessageManager.getInstance().unRegisterListener(this.bPg);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.ca.To().dc(false);
        if (this.bNT != null && this.bNT.aHE() != null) {
            com.baidu.tbadk.distribute.a.Cc().a(getPageContext().getPageActivity(), "frs", this.bNT.aHE().getId(), 0L);
        }
        if (this.bOm != null) {
            this.bOm.onStop(getPageContext());
        }
        com.baidu.tieba.frs.d.p.c(getListView());
        this.bOx.onActivityStop();
        com.baidu.tbadk.util.u.GE();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.bOn == null) {
            return false;
        }
        return this.bOn.ZD();
    }

    public boolean Zm() {
        if (this.bOy == null) {
            return false;
        }
        return this.bOy.isShowing();
    }

    @Override // com.baidu.tieba.recapp.u
    public TbPageContext<?> xD() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.u
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Cc().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.u
    public void Zn() {
        YU().Zn();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bOm == null) {
            this.bOm = VoiceManager.instance();
        }
        return this.bOm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.bOn == null) {
            return null;
        }
        return this.bOn.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void Zo() {
        if (this.bOm != null) {
            this.bOm.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wG() {
        if (this.amv == null) {
            this.amv = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.amv;
    }

    public void Zp() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a implements com.baidu.adp.widget.ListView.w {
        private a() {
        }

        /* synthetic */ a(r rVar, a aVar) {
            this();
        }

        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
            boolean z;
            String str;
            if (bdUniqueId != null) {
                if (bdUniqueId == bf.bQA) {
                    if (r.this.bOn != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11752").aa("fid", r.this.forumId).aa("obj_locate", "1"));
                        r.this.bOn.startPullRefresh();
                    }
                } else if (vVar != null && (vVar instanceof com.baidu.tbadk.core.data.bk)) {
                    com.baidu.tbadk.core.data.bk bkVar = (com.baidu.tbadk.core.data.bk) vVar;
                    if (bkVar.sj() == null || bkVar.sj().getGroup_id() == 0 || bg.aN(r.this.getActivity())) {
                        if ((bkVar.sc() != 1 && bkVar.sc() != 2) || bg.aN(r.this.getActivity())) {
                            if (bkVar.rL() != null) {
                                if (bg.aN(r.this.getActivity())) {
                                    String postUrl = bkVar.rL().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hB()) {
                                        com.baidu.tbadk.browser.f.T(r.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bkVar.su() != null) {
                                com.baidu.tbadk.core.data.n su = bkVar.su();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(r.this.getPageContext().getPageActivity(), su.getCartoonId(), su.getChapterId(), 2)));
                            } else if (bkVar.getThreadType() == 47 && bkVar.ru() == 1 && !com.baidu.tbadk.core.util.au.isEmpty(bkVar.rF())) {
                                com.baidu.tbadk.browser.f.S(r.this.getPageContext().getPageActivity(), bkVar.rF());
                            } else {
                                com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.qi(bkVar.getId())) {
                                    readThreadHistory.qh(bkVar.getId());
                                }
                                String rF = bkVar.rF();
                                if (rF == null || rF.equals("")) {
                                    z = false;
                                } else {
                                    new Thread(new aq(this, rF)).start();
                                    z = true;
                                }
                                String tid = bkVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bkVar.ru() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.bb vB = com.baidu.tbadk.core.util.bb.vB();
                                    TbPageContext<BaseFragmentActivity> pageContext = r.this.getPageContext();
                                    String[] strArr = new String[3];
                                    strArr[0] = tid;
                                    strArr[1] = "";
                                    vB.c(pageContext, strArr);
                                } else if (bkVar.getThreadType() == 33 || (bkVar instanceof com.baidu.tbadk.core.data.ax)) {
                                    if (bkVar.getThreadType() == 33) {
                                        str = "c10245";
                                    } else {
                                        str = "c10180";
                                    }
                                    if (r.this.bOw.abQ() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.as(str).aa("fid", r.this.forumId));
                                    com.baidu.tieba.frs.d.p.c(r.this, bkVar);
                                    if (r.this.bNT != null && r.this.bNT.aHE() != null) {
                                        com.baidu.tieba.frs.c.a aVar = new com.baidu.tieba.frs.c.a();
                                        aVar.bYR = r.this.bNT.frQ == 1;
                                        aVar.bYT = r.this.bNT.aHE().getId();
                                        aVar.bYS = r.this.YU().abW();
                                        com.baidu.tieba.frs.c.b.acs().a(aVar, bkVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        bkVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == com.baidu.tbadk.core.data.bk.YC.getId()) {
                                        com.baidu.tieba.frs.d.o.a(bkVar.rh());
                                        com.baidu.tieba.frs.d.p.b(r.this, bkVar);
                                        return;
                                    }
                                    com.baidu.tieba.frs.d.p.a(r.this, bkVar, i, z);
                                    com.baidu.tieba.frs.d.o.a(r.this, r.this.bNT, bkVar);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.k.hB()) {
            hideNetRefreshView(this.bOn.ZP());
            showLoadingView(this.bOn.ZP(), true);
            this.bOn.dP(false);
            this.bOn.startPullRefresh();
        }
    }

    public com.baidu.tieba.tbadkCore.n Zq() {
        return this.bNT;
    }

    public boolean Zr() {
        return this.bOn.Zr();
    }

    public void N(Object obj) {
        if (this.bOD != null && this.bOD.bXP != null) {
            this.bOD.bXP.g(obj);
        }
    }

    public void O(Object obj) {
        if (this.bOD != null && this.bOD.bXQ != null) {
            this.bOD.bXQ.g(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void ln() {
        if (!com.baidu.adp.lib.util.k.hB()) {
            this.bOn.UA();
        } else if (this.bOw.abQ() == 1) {
            JK();
            Zs();
        } else if (this.bOw.hasMore()) {
            Zs();
        }
    }

    public void iR(String str) {
        JK();
        showToast(str);
    }

    public void E(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        JK();
        if (!com.baidu.tbadk.core.util.x.r(arrayList)) {
            if (!this.bOw.acb() && TbadkCoreApplication.m9getInst().isRecAppExist() && this.bOw.abQ() == 1) {
                this.bNT.a(getPageContext(), arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bOK.a(false, false, arrayList, this.bOj);
            if (a2 != null) {
                this.bNT.ay(a2);
                this.bOn.a(a2, this.bNT);
            }
            if (this.bOw != null) {
                com.baidu.tieba.frs.c.b.a(this.bNT, this.bOw.abW(), 2);
            }
        }
    }

    private void JK() {
        if (Za() == 1 || this.bOK.aq(this.bNT.beW())) {
            this.bOn.ZS();
        } else if (com.baidu.tbadk.core.util.x.r(this.bNT.getThreadList())) {
            this.bOn.UA();
        } else {
            this.bOn.JO();
        }
    }

    @Override // com.baidu.tieba.frs.mc.y
    public void Zs() {
        if (this.bOK != null) {
            this.bOK.a(this.bOf, this.forumId, this.bNT);
        }
    }

    public void PS() {
        if (!com.baidu.tbadk.core.util.ae.d(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ap.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return Zt() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!Zt()) {
            return super.getCurrentPageSourceKeyList();
        }
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(com.baidu.tbadk.core.util.x.c(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
            return arrayList;
        }
        return arrayList;
    }

    @Override // com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.d.p.a(this, i, strArr, iArr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    public void dL(boolean z) {
        if (this.bOE != null) {
            this.bOE.dU(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.bOF.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fA(int i) {
        return this.bOF.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.bON.b(bVar);
    }

    public boolean Zt() {
        return this.bOb;
    }

    @Override // com.baidu.tieba.frs.bw
    public void Zu() {
        if (this.bOn != null) {
            Xb();
            this.bOn.getListView().setSelection(0);
            this.bOn.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.frs.bw
    public ForumWriteData Zv() {
        if (this.bNT == null || this.bNT.aHE() == null) {
            return null;
        }
        ForumData aHE = this.bNT.aHE();
        ForumWriteData forumWriteData = new ForumWriteData(aHE.getId(), aHE.getName(), aHE.getPrefixData(), this.bNT.ql());
        forumWriteData.setForumLevel(aHE.getUser_level());
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.bw
    public void ww() {
        changeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }
}
