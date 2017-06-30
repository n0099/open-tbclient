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
import com.baidu.a.a.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.f;
import com.baidu.tbadk.KuangFloatingViewController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.InjectPlugin.a.b;
import com.baidu.tieba.frs.e.m;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class r extends BaseFragment implements a.InterfaceC0000a, BdListView.e, f.c, UserIconBox.b, VoiceManager.c, b, by, cb, com.baidu.tieba.frs.mc.ab, com.baidu.tieba.recapp.x {
    private com.baidu.tbadk.util.t aKu;
    private com.baidu.adp.lib.e.b<TbImageView> anq;
    private com.baidu.tieba.frs.entelechy.b.a cbV;
    private boolean cbZ;
    private com.baidu.tieba.frs.entelechy.b.b ccB;
    private com.baidu.tbadk.h.a ccC;
    private com.baidu.tieba.frs.f.a ccD;
    private com.baidu.tieba.frs.mc.l ccE;
    private com.baidu.tieba.frs.mc.h ccF;
    private com.baidu.tieba.frs.f.x ccG;
    private com.baidu.tieba.frs.mc.a ccH;
    private au ccI;
    public com.baidu.tieba.frs.f.f ccJ;
    private com.baidu.tieba.frs.mc.q ccK;
    private Intent ccL;
    private int ccM;
    private View.OnTouchListener ccN;
    private boolean ccO;
    public com.baidu.tbadk.core.data.bm cca;
    private com.baidu.tieba.tbadkCore.data.e ccf;
    private VoiceManager cci;
    private m.a ccq;
    private FrsModelController ccs;
    private com.baidu.tieba.frs.f.m cct;
    private com.baidu.tieba.frs.entelechy.b.d ccu;
    private com.baidu.tieba.frs.mc.v ccv;
    private com.baidu.tieba.frs.mc.b ccw;
    private com.baidu.tieba.frs.smartsort.c ccx;
    private com.baidu.tieba.frs.mc.d ccy;
    private cc ccz;
    private boolean cdb;
    public View mRootView;
    private static boolean isNeedRefreshOnResume = false;
    public static boolean cbY = false;
    public static volatile long cck = 0;
    public static volatile long ccl = 0;
    public static volatile int ccm = 0;
    public boolean cbW = false;
    private boolean cbX = false;
    public String ccb = null;
    public String ahE = null;
    public int mFlag = 0;
    private boolean ccc = false;
    private boolean ccd = false;
    private String mThreadId = null;
    private String forumId = null;
    private int cbQ = 0;
    private boolean cce = false;
    private boolean ccg = false;
    private boolean cch = false;
    private av ccj = null;
    public final com.baidu.tbadk.core.data.bm bdI = null;
    private com.baidu.tieba.tbadkCore.n cbN = new com.baidu.tieba.tbadkCore.n();
    public long bTh = -1;
    public long aHL = 0;
    public long aHD = 0;
    public long createTime = 0;
    public long Vq = -1;
    private boolean ccn = false;
    private boolean cco = false;
    public com.baidu.tbadk.j.e ccp = null;
    private boolean ccr = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> ccA = new SparseArray<>();
    private boolean bHe = true;
    private final CustomMessageListener ccP = new s(this, CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED);
    private CustomMessageListener ccQ = new ae(this, CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD);
    private final ca ccR = new al(this);
    private bz ccS = new am(this);
    private CustomMessageListener ccT = new an(this, CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT);
    private CustomMessageListener ccU = new ao(this, CmdConfigCustom.CMD_FRS_TAB_LIVE_START);
    private final CustomMessageListener ccV = new ap(this, CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB);
    private final CustomMessageListener ccW = new aq(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private final CustomMessageListener ccX = new ar(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    public final com.baidu.tieba.tbadkCore.p ccY = new t(this);
    private final CustomMessageListener ccZ = new u(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private final CustomMessageListener mMemListener = new v(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private final com.baidu.tieba.frs.mc.aa cda = new w(this);
    public final View.OnTouchListener aKv = new x(this);
    private final CustomMessageListener cdc = new y(this, CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE);
    private final CustomMessageListener cdd = new z(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);
    public final View.OnClickListener cde = new aa(this);
    private final AbsListView.OnScrollListener cdf = new ab(this);
    private final n cdg = new ac(this);
    private final NoNetworkView.a bzE = new af(this);
    private final CustomMessageListener cdh = new ag(this, 0);
    private com.baidu.adp.widget.ListView.x cdi = new a(this, null);
    private ca cdj = new ah(this);
    private CustomMessageListener cdk = new aj(this, CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED);

    public com.baidu.tieba.frs.entelechy.b.b adL() {
        return this.ccB;
    }

    public com.baidu.adp.widget.ListView.x adM() {
        return this.cdi;
    }

    public com.baidu.tieba.frs.mc.l adN() {
        return this.ccE;
    }

    public com.baidu.tieba.frs.smartsort.c adO() {
        return this.ccx;
    }

    @Override // com.baidu.tieba.frs.mc.ab
    public FrsModelController adP() {
        return this.ccs;
    }

    @Override // com.baidu.tieba.frs.mc.ab
    public com.baidu.tieba.frs.mc.h adQ() {
        return this.ccF;
    }

    @Override // com.baidu.tieba.frs.mc.ab
    public com.baidu.tieba.frs.f.m adR() {
        return this.cct;
    }

    public com.baidu.tieba.frs.entelechy.b.d adS() {
        return this.ccu;
    }

    public cc adT() {
        return this.ccz;
    }

    @Override // com.baidu.tieba.frs.mc.ab
    public av adU() {
        return this.ccj;
    }

    @Override // com.baidu.tieba.frs.cb
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.cb
    public String getForumName() {
        return this.ccb;
    }

    public void setForumName(String str) {
        this.ccb = str;
    }

    public void setFrom(String str) {
        this.ahE = str;
    }

    public String getFrom() {
        return this.ahE;
    }

    public void setFlag(int i) {
        this.mFlag = i;
    }

    @Override // com.baidu.tieba.recapp.x
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.x
    public int getPageNum() {
        if (this.ccF == null) {
            return 1;
        }
        return this.ccF.getPn();
    }

    public int getPn() {
        if (this.ccF == null) {
            return 1;
        }
        return this.ccF.getPn();
    }

    public void setPn(int i) {
        if (this.ccF != null) {
            this.ccF.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.ccF != null) {
            this.ccF.setHasMore(i);
        }
    }

    public int adV() {
        if (this.ccF == null) {
            return -1;
        }
        return this.ccF.adV();
    }

    public boolean adW() {
        return this.cch;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar, boolean z) {
        if (aVar == null) {
            showNetRefreshView(this.ccj.Vf(), TbadkCoreApplication.m9getInst().getString(w.l.error_unkown_try_again), true);
        } else if (aVar.fJh) {
            if (340001 == aVar.errorCode) {
                showNetRefreshViewNoClick(this.ccj.Vf(), TbadkCoreApplication.m9getInst().getString(w.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
            } else {
                showNetRefreshView(this.ccj.Vf(), TbadkCoreApplication.m9getInst().getString(w.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
            }
        } else if (340001 == aVar.errorCode) {
            showNetRefreshViewNoClick(this.ccj.Vf(), aVar.errorMsg, true);
        } else {
            showNetRefreshView(this.ccj.Vf(), aVar.errorMsg, true);
        }
        if (aem()) {
            setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds280));
        } else {
            setNetRefreshViewEmotionDefMarginTop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adX() {
        hideLoadingView(this.ccj.Vf());
        this.ccj.ch(false);
        this.ccj.aeE();
        if (this.ccj.aet() instanceof com.baidu.tieba.frs.tab.i) {
            ((com.baidu.tieba.frs.tab.i) this.ccj.aet()).ahs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adY() {
        if (adV() == 0 && com.baidu.tbadk.core.util.z.t(this.cbN.bkF())) {
            if (com.baidu.tbadk.core.util.z.t(this.cbN.getThreadList())) {
                this.ccj.WU();
                return;
            } else {
                this.ccj.Vn();
                return;
            }
        }
        this.ccj.Vl();
    }

    public void a(ErrorData errorData) {
        adX();
        this.ccj.aey();
        d.a agK = this.ccs.agK();
        boolean t = com.baidu.tbadk.core.util.z.t(this.cbN.getThreadList());
        if (agK != null && t) {
            if (t) {
                if (this.ccs.agL() != 0) {
                    this.ccs.agR();
                    this.ccj.aey();
                } else {
                    a(agK, false);
                }
                this.ccj.r(this.cbN.blA(), false);
                return;
            } else if (agK.fJh) {
                this.ccj.r(true, false);
                showToast(getPageContext().getResources().getString(w.l.net_error_text, agK.errorMsg, Integer.valueOf(agK.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(agK, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adZ() {
        if (this.cbN == null || this.cbN.aMt() != null) {
            this.ccj.aeH();
        } else if (this.cbN.aMt().getYuleData() != null && this.cbN.aMt().getYuleData().sS()) {
            TiebaStatic.log("c10852");
            this.ccj.a(this.cbN.aMt().getYuleData().sT());
        } else {
            this.ccj.aeH();
        }
    }

    private void p(boolean z, boolean z2) {
        if (this.ccs != null && this.cbN != null && this.ccj != null && z) {
            if (!this.ccs.agY() && this.ccs.agN() == 1) {
                if (!this.ccs.agW()) {
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.cbN.blt();
                        this.cbN.blq();
                    }
                    this.cbN.blr();
                    this.cbN.bls();
                }
                boolean z3 = false;
                if (this.ccj.aeI().k(com.baidu.tieba.card.data.p.bEB)) {
                    z3 = this.cbN.blw();
                }
                if (!z3) {
                    this.cbN.blu();
                }
                if (TbadkCoreApplication.m9getInst().isRecAppExist()) {
                    this.cbN.a(this);
                }
                if (!this.ccj.aeI().k(com.baidu.tbadk.core.data.bm.Xs)) {
                    this.cbN.bln();
                }
                this.cbN.blx();
                this.cbN.bly();
            }
            this.cbN.blo();
            this.cbN.bll();
            if (this.ccj.aeI().k(com.baidu.tieba.g.b.cws)) {
                this.cbN.lP(z2);
            }
        }
    }

    public boolean aea() {
        if (this.ccu != null && this.ccj != null) {
            this.ccu.b(this.ccj.getListView());
        }
        if (this.cct != null && this.ccs != null) {
            this.cct.a(this.ccs.agJ(), this.cbN);
        }
        boolean z = false;
        if (this.cbN != null) {
            z = this.cbN.blB();
        }
        er(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void is(int i) {
        cf cfVar = null;
        aea();
        aei();
        try {
            if (this.cbN != null) {
                this.ccj.a((ArrayList<com.baidu.adp.widget.ListView.v>) null, this.cbN);
                this.cct.jm(1);
                this.ccj.aeB();
                this.ccu.a(this.ccj.getListView(), this.cbN, this.ccs.agT());
                com.baidu.tieba.frs.tab.j a2 = a(this.ccu.afI(), this.cbN.bkU());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    cfVar = new cf();
                    cfVar.cfg = a2.url;
                    cfVar.stType = a2.name;
                }
                this.ccs.a(this.cbN.bkU(), 0, cfVar);
                this.ccu.eG(false);
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
            if (jVar != null && jVar.cnY == i) {
                return jVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z, boolean z2) {
        try {
            if (this.cbN != null && this.ccu != null && this.ccs != null) {
                if (!this.ccj.aeI().k(com.baidu.tbadk.core.data.bm.Xs)) {
                    this.cbN.bln();
                }
                if (this.cbN.aMt() != null) {
                    this.ccb = this.cbN.aMt().getName();
                    this.forumId = this.cbN.aMt().getId();
                }
                if (this.cbN.blB()) {
                    this.ccu.a(this.ccj.getListView(), this.cbN, this.ccs.agT());
                }
                if (z) {
                    p(true, z);
                } else {
                    p(this.ccr, z);
                }
                aea();
                if (this.ccB != null) {
                    this.ccB.a(this.cct, this.cbN);
                }
                if (this.cbN.qu() != null) {
                    setHasMore(this.cbN.qu().qq());
                }
                ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.ccF.a(z2, true, this.cbN.getThreadList(), null);
                if (a2 != null) {
                    this.cbN.az(a2);
                }
                if (this.ccs.agN() == 1) {
                    aef();
                }
                this.cbQ = this.cbN.agP();
                if (this.ccf != null) {
                    this.cce = true;
                    this.ccf.sB(this.cbQ);
                    com.baidu.tieba.frs.e.a.a(this, this.cbN.aMt(), this.cbN.getThreadList(), this.cce, getPn());
                }
                if (this.ccD != null) {
                    this.ccD.cg(this.ccs.agY());
                    this.ccD.aj(this.ccu.afJ());
                }
                adX();
                this.ccj.r(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.l lVar) {
        try {
            if (!this.ccn && lVar != null && this.cbN != null) {
                this.cbN.d(lVar);
                q(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void er(boolean z) {
        if (this.ccs != null) {
            e(z, this.ccs.agJ());
        } else {
            e(z, "normal_page");
        }
    }

    private void e(boolean z, String str) {
        es("frs_page".equals(str));
        if (this.ccB != null) {
            this.ccB.a(z, this.ccu, this.cct, this.ccj, this.cbN);
        }
    }

    public void es(boolean z) {
        if (this.ccG != null) {
            this.ccG.a(this.ccj, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(w.j.frs_activity, viewGroup, false);
            this.cbV = new com.baidu.tieba.frs.entelechy.b();
            this.ccB = this.cbV.afe();
            this.cct = new com.baidu.tieba.frs.f.m(this, this.cbV);
            this.ccu = this.cbV.w(this);
            Intent intent = this.ccL != null ? this.ccL : getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.cbX = true;
            }
            this.ccj = new av(this, this.cde, this.cbV, this.cbX);
            this.ccj.setHeaderViewHeight(this.ccM);
        } else if (this.mRootView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = this.ccL != null ? this.ccL : getActivity().getIntent();
        this.bTh = System.currentTimeMillis();
        if (intent != null) {
            this.ccg = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.bTh = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            J(intent);
        }
        this.Vq = System.currentTimeMillis();
        this.aHD = this.Vq - this.bTh;
        this.ccf = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.fLE);
        this.ccs = new FrsModelController(this, this.ccY);
        this.ccs.a(this.ccR);
        this.ccs.init();
        if (intent != null) {
            this.ccs.f(intent.getExtras());
        } else if (bundle != null) {
            this.ccs.f(bundle);
        } else {
            this.ccs.f(null);
        }
        this.ccu.ag(this.ccj.Vf());
        if (intent != null) {
            this.cct.h(intent.getExtras());
        } else if (bundle != null) {
            this.cct.h(bundle);
        } else {
            this.cct.h((Bundle) null);
        }
        this.cci = getVoiceManager();
        this.ccI = new au(getPageContext(), this);
        initUI();
        initData(bundle);
        if (this.ahE != null && this.ahE.equals("from_tieba_kuang")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c12264").r("obj_type", 1).Z(ImageViewerConfig.FORUM_NAME, this.ccs.getForumName()));
            KuangFloatingViewController.getInstance().showFloatingView();
        }
        if (!aem()) {
            this.ccz = new cc(getActivity(), this.ccj, this.cct);
            this.ccz.eC(true);
        }
        this.cci = getVoiceManager();
        if (this.cci != null) {
            this.cci.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.y();
        this.ccF = new com.baidu.tieba.frs.mc.h(this, this.cda);
        this.ccx = new com.baidu.tieba.frs.smartsort.c(this);
        this.ccG = new com.baidu.tieba.frs.f.x(this);
        this.createTime = System.currentTimeMillis() - this.Vq;
        this.ccD = new com.baidu.tieba.frs.f.a(getPageContext(), this.ccs.agV());
        this.ccy = new com.baidu.tieba.frs.mc.d(this);
        this.ccE = new com.baidu.tieba.frs.mc.l(this);
        this.ccv = new com.baidu.tieba.frs.mc.v(this);
        this.ccw = new com.baidu.tieba.frs.mc.b(this);
        this.ccH = new com.baidu.tieba.frs.mc.a(this);
        this.ccJ = new com.baidu.tieba.frs.f.f(this);
        this.ccK = new com.baidu.tieba.frs.mc.q(this, getUniqueId());
        registerListener(this.mMemListener);
        registerListener(this.ccX);
        registerListener(this.cdc);
        registerListener(this.ccW);
        registerListener(this.ccZ);
        registerListener(this.ccT);
        registerListener(this.ccU);
        registerListener(this.ccV);
        registerListener(this.ccP);
        registerListener(this.ccQ);
        registerListener(this.cdk);
        this.ccj.ex(false);
        if (!aem()) {
            showLoadingView(this.ccj.Vf(), true);
            this.ccs.p(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.by
    public void aeb() {
        if (isAdded() && this.bHe && !isLoadingViewAttached()) {
            showLoadingView(this.ccj.Vf(), true);
        }
    }

    @Override // com.baidu.tieba.frs.by
    public void aec() {
        if (isAdded() && this.bHe && isLoadingViewAttached()) {
            hideLoadingView(this.ccj.Vf());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (aem()) {
            showLoadingView(this.ccj.Vf(), true);
            this.ccj.iv(TbadkCoreApplication.m9getInst().getMainTabBottomBarHeight());
            this.ccs.p(3, true);
            getListView().setSelection(0);
        }
    }

    @Override // com.baidu.tieba.frs.by
    public void setHeaderViewHeight(int i) {
        this.ccM = i;
        if (this.ccj != null) {
            this.ccj.setHeaderViewHeight(this.ccM);
        }
    }

    @Override // com.baidu.tieba.frs.by
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.u uVar) {
        if (uVar != null) {
            this.aKu = uVar.GS();
            this.ccN = uVar.GT();
        }
    }

    @Override // com.baidu.tieba.frs.by
    public void showFloatingView() {
        if (this.aKu != null) {
            this.aKu.cd(true);
        }
    }

    private void J(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.e.m.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
                getActivity().finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.ccb = data.getQueryParameter("name");
            this.ahE = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.ccb)) {
                intent.putExtra("name", this.ccb);
            }
            if (!StringUtils.isNull(this.ahE)) {
                intent.putExtra("from", this.ahE);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.ccb)) {
            this.ccb = com.baidu.tieba.frs.e.p.L(intent);
            if (!StringUtils.isNull(this.ccb)) {
                intent.putExtra("name", this.ccb);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cci = getVoiceManager();
        if (this.cci != null) {
            this.cci.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.cdh);
        if (bundle != null) {
            this.ccb = bundle.getString("name");
            this.ahE = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                this.ccb = intent.getStringExtra("name");
                this.ahE = intent.getStringExtra("from");
                this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.ahE)) {
            FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.ahE);
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.cdh);
        }
        this.cct.h(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cdk);
        if (this.cci != null) {
            this.cci.onDestory(getPageContext());
        }
        this.cci = null;
        com.baidu.tieba.card.cf.VN().dv(false);
        if (this.cbN != null && this.cbN.aMt() != null) {
            bv.aeW().bg(com.baidu.adp.lib.g.b.c(this.cbN.aMt().getId(), 0L));
        }
        if (this.ccj != null) {
            com.baidu.tieba.frs.e.o.a(this.ccj, this.cbN, getForumId(), false, null);
            this.ccj.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.ccp != null) {
                this.ccp.onDestroy();
            }
            this.ccj.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.ccs.onActivityDestroy();
        this.cct.onActivityDestroy();
        if (this.ccq != null) {
            this.ccq.cancel(true);
            this.ccq = null;
        }
        if (this.ccs != null) {
            this.ccs.Og();
        }
        if (this.ccz != null) {
            this.ccz.GR();
        }
        if (this.ccC != null) {
            this.ccC.destory();
        }
        if (this.ccD != null) {
            this.ccD.destory();
        }
        if (this.ccx != null) {
            this.ccx.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bex().bez();
        com.baidu.tieba.frs.e.q.ahv();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.ccb);
        bundle.putString("from", this.ahE);
        this.ccs.onSaveInstanceState(bundle);
        if (this.cci != null) {
            this.cci.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.ccH != null) {
            this.ccH.onActivityResult(i, i2, intent);
        }
    }

    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.ccC == null) {
                this.ccC = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.ccC.an(updateAttentionMessage.getData().toUid, getForumId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ccj != null) {
            this.ccj.aey();
            this.ccj.onResume();
        }
        this.ccu.a(this.ccS);
        this.ccv.eN(true);
        this.ccr = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.ccj.startPullRefresh();
        } else if (cbY) {
            cbY = false;
            this.ccj.startPullRefresh();
        } else {
            if (this.cci != null) {
                this.cci.onResume(getPageContext());
            }
            this.ccj.ey(false);
            registerListener(this.cdd);
            if (this.ccO) {
                ci(6);
                this.ccO = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        refresh();
    }

    @Override // com.baidu.tieba.frs.by
    public void K(Intent intent) {
        this.ccL = intent;
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.ccb = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.ahE = intent.getStringExtra("from");
            }
            this.ccd = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.ccd) {
                aed();
            }
            if (this.ahE != null && this.ahE.equals("from_tieba_kuang")) {
                KuangFloatingViewController.getInstance().showFloatingView();
            }
        }
    }

    private void aed() {
        this.ccj.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.e.p.a(getPageContext(), getActivity().getIntent(), this.ahE);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.ccj.setTitle(this.ccb);
        } else {
            this.ccj.setTitle("");
            this.mFlag = 1;
        }
        this.cct.d(this.ccj.getListView());
        this.ccj.setOnAdapterItemClickListener(this.cdi);
        this.ccj.setOnScrollListener(this.cdf);
        this.ccj.c(this.bzE);
        this.ccj.aeI().a(this.cdg);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ccj.onChangeSkinType(i);
        this.cct.jl(i);
        this.ccu.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.f.c
    public void lr() {
    }

    @Override // com.baidu.adp.widget.f.c
    public void ls() {
    }

    public void it(int i) {
        if (!this.mIsLogin) {
            if (this.cbN != null && this.cbN.qe() != null) {
                this.cbN.qe().setIfpost(1);
            }
            if (i == 0) {
                bl.aM(getActivity());
            }
        } else if (this.cbN != null) {
            if (i == 0) {
                if (!this.cbZ) {
                    com.baidu.tieba.frs.e.q.b(this, 0);
                    return;
                }
                TiebaStatic.log("c10152");
                com.baidu.tieba.frs.e.q.b(this, 4);
                return;
            }
            this.ccj.aeA();
        }
    }

    public void refresh() {
        ci(3);
    }

    public void ci(int i) {
        this.ccn = false;
        aei();
        if (this.ccj.aes() != null) {
            this.ccj.aes().aog();
        }
        this.ccs.p(i, true);
    }

    private void aee() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.k.fS().f(new ak(this));
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aef() {
        aei();
        try {
            if (this.cbN != null) {
                this.ccj.Nq();
                this.ccj.eu(this.ccs.agO());
                if (com.baidu.tieba.frs.f.m.i(this.cbN) && !com.baidu.tieba.frs.f.m.h(this.cbN)) {
                    this.ccj.aeM();
                }
                if (this.cbN.aMt() != null) {
                    this.ccb = this.cbN.aMt().getName();
                    this.forumId = this.cbN.aMt().getId();
                }
                if (this.cbN.qu() != null) {
                    setHasMore(this.cbN.qu().qq());
                }
                this.ccj.setTitle(this.ccb);
                this.ccj.setForumName(this.ccb);
                TbadkCoreApplication.m9getInst().setDefaultBubble(this.cbN.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(this.cbN.getUserData().getBimg_end_time());
                aee();
                aeg();
                ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.cbN.getThreadList();
                if (threadList != null) {
                    this.ccj.a(threadList, this.cbN);
                    com.baidu.tieba.frs.e.c.j(this.ccj);
                    this.cct.jm(getPageNum());
                    this.cct.f(this.cbN);
                    this.ccu.a(this.ccj.getListView(), this.cbN, this.ccs.agT());
                    this.ccj.aeB();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aeg() {
        if (this.cbN != null) {
            if (this.cbN.aMH() == 1) {
                this.ccj.aeI().setFromCDN(true);
            } else {
                this.ccj.aeI().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ccv.eN(false);
        this.ccr = false;
        this.ccj.onPause();
        if (this.cci != null) {
            this.cci.onPause(getPageContext());
        }
        this.ccj.ey(true);
        if (this.ccD != null) {
            this.ccD.ahy();
        }
        MessageManager.getInstance().unRegisterListener(this.cdd);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.cf.VN().dv(false);
        if (this.cbN != null && this.cbN.aMt() != null) {
            com.baidu.tbadk.distribute.a.Cq().a(getPageContext().getPageActivity(), "frs", this.cbN.aMt().getId(), 0L);
        }
        if (this.cci != null) {
            this.cci.onStop(getPageContext());
        }
        com.baidu.tieba.frs.e.p.c(getListView());
        this.cct.onActivityStop();
        com.baidu.tbadk.util.v.GV();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.ccj == null) {
            return false;
        }
        return this.ccj.aex();
    }

    @Override // com.baidu.tieba.recapp.x
    public TbPageContext<?> xN() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.x
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Cq().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.x
    public void aeh() {
        adP().aeh();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cci == null) {
            this.cci = VoiceManager.instance();
        }
        return this.cci;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.ccj == null) {
            return null;
        }
        return this.ccj.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void aei() {
        if (this.cci != null) {
            this.cci.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wU() {
        if (this.anq == null) {
            this.anq = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.anq;
    }

    public void aej() {
        if (getFragmentActivity() != null && getFragmentActivity().getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.b(getFragmentActivity(), getFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.w onGetPreLoadListView() {
        return getListView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a implements com.baidu.adp.widget.ListView.x {
        private a() {
        }

        /* synthetic */ a(r rVar, a aVar) {
            this();
        }

        @Override // com.baidu.adp.widget.ListView.x
        public void a(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            String str;
            if (bdUniqueId != null) {
                if (bdUniqueId == bh.cez) {
                    if (r.this.ccj != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11752").Z("fid", r.this.forumId).Z("obj_locate", "1"));
                        r.this.ccj.startPullRefresh();
                    }
                } else if (vVar != null && (vVar instanceof com.baidu.tbadk.core.data.bm)) {
                    com.baidu.tbadk.core.data.bm bmVar = (com.baidu.tbadk.core.data.bm) vVar;
                    if (bmVar.sc() == null || bmVar.sc().getGroup_id() == 0 || bl.aN(r.this.getActivity())) {
                        if ((bmVar.rV() != 1 && bmVar.rV() != 2) || bl.aN(r.this.getActivity())) {
                            if (bmVar.rE() != null) {
                                if (bl.aN(r.this.getActivity())) {
                                    String postUrl = bmVar.rE().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hA()) {
                                        com.baidu.tbadk.browser.g.U(r.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bmVar.sn() != null) {
                                com.baidu.tbadk.core.data.o sn = bmVar.sn();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(r.this.getPageContext().getPageActivity(), sn.getCartoonId(), sn.getChapterId(), 2)));
                            } else if (bmVar.getThreadType() == 47 && bmVar.rm() == 1 && !com.baidu.tbadk.core.util.aw.isEmpty(bmVar.ry())) {
                                com.baidu.tbadk.browser.g.T(r.this.getPageContext().getPageActivity(), bmVar.ry());
                            } else {
                                com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.ru(bmVar.getId())) {
                                    readThreadHistory.rt(bmVar.getId());
                                }
                                String ry = bmVar.ry();
                                if (ry == null || ry.equals("")) {
                                    z = false;
                                } else {
                                    new Thread(new as(this, ry)).start();
                                    z = true;
                                }
                                String tid = bmVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bmVar.rm() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.be vP = com.baidu.tbadk.core.util.be.vP();
                                    TbPageContext<BaseFragmentActivity> pageContext = r.this.getPageContext();
                                    String[] strArr = new String[3];
                                    strArr[0] = tid;
                                    strArr[1] = "";
                                    vP.c(pageContext, strArr);
                                } else if (bmVar.getThreadType() == 33 || (bmVar instanceof com.baidu.tbadk.core.data.az)) {
                                    if (bmVar.getThreadType() == 33) {
                                        str = "c10245";
                                    } else {
                                        str = "c10180";
                                    }
                                    if (r.this.ccs.agN() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.au(str).Z("fid", r.this.forumId));
                                    com.baidu.tieba.frs.e.p.c(r.this, bmVar);
                                    if (r.this.cbN != null && r.this.cbN.aMt() != null) {
                                        com.baidu.tieba.frs.d.a aVar = new com.baidu.tieba.frs.d.a();
                                        aVar.cnr = r.this.cbN.fJJ == 1;
                                        aVar.cnu = r.this.cbN.aMt().getId();
                                        aVar.cns = r.this.adP().agT();
                                        com.baidu.tieba.frs.d.b.aho().a(aVar, bmVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        bmVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == com.baidu.tbadk.core.data.bm.Yz.getId()) {
                                        com.baidu.tieba.frs.e.o.a(bmVar.ra());
                                        com.baidu.tieba.frs.e.p.b(r.this, bmVar);
                                        return;
                                    }
                                    com.baidu.tieba.frs.e.p.a(r.this, bmVar, i, z);
                                    com.baidu.tieba.frs.e.o.a(r.this, r.this.cbN, bmVar);
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
        if (com.baidu.adp.lib.util.k.hA()) {
            hideNetRefreshView(this.ccj.Vf());
            showLoadingView(this.ccj.Vf(), true);
            this.ccj.ex(false);
            this.ccj.startPullRefresh();
        }
    }

    public com.baidu.tieba.tbadkCore.n aek() {
        return this.cbN;
    }

    public boolean ael() {
        return this.ccj.ael();
    }

    public void P(Object obj) {
        if (this.ccy != null && this.ccy.cmn != null) {
            this.ccy.cmn.g(obj);
        }
    }

    public void Q(Object obj) {
        if (this.ccy != null && this.ccy.cmo != null) {
            this.ccy.cmo.g(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.hA()) {
            this.ccj.WU();
        } else if (this.ccs.agN() == 1) {
            MX();
            MG();
        } else if (this.ccs.hasMore()) {
            MG();
        }
    }

    public void jW(String str) {
        MX();
        showToast(str);
    }

    public void G(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        MX();
        if (!com.baidu.tbadk.core.util.z.t(arrayList)) {
            if (!this.ccs.agY() && TbadkCoreApplication.m9getInst().isRecAppExist() && this.ccs.agN() == 1) {
                this.cbN.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.ccF.a(false, false, arrayList, this.ccf);
            if (a2 != null) {
                this.cbN.az(a2);
                this.ccj.a(a2, this.cbN);
            }
            if (this.ccs != null) {
                com.baidu.tieba.frs.d.b.a(this.cbN, this.ccs.agT(), 2);
            }
        }
    }

    private void MX() {
        if (adV() == 1 || this.ccF.az(this.cbN.bkF())) {
            this.ccj.Vl();
        } else if (com.baidu.tbadk.core.util.z.t(this.cbN.getThreadList())) {
            this.ccj.WU();
        } else {
            this.ccj.Vn();
        }
    }

    @Override // com.baidu.tieba.frs.mc.ab
    public void MG() {
        if (this.ccF != null) {
            this.ccF.a(this.ccb, this.forumId, this.cbN);
        }
    }

    public void RS() {
        if (!com.baidu.tbadk.core.util.ag.d(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ar.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return aem() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!aem()) {
            return super.getCurrentPageSourceKeyList();
        }
        if (super.getCurrentPageSourceKeyList() != null) {
            arrayList = new ArrayList(super.getCurrentPageSourceKeyList());
        } else {
            arrayList = new ArrayList();
        }
        if (!"a001".equals(com.baidu.tbadk.core.util.z.c(arrayList, arrayList.size() - 1))) {
            arrayList.add("a001");
            return arrayList;
        }
        return arrayList;
    }

    @Override // com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.e.p.a(this, i, strArr, iArr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    public void et(boolean z) {
        if (this.ccz != null) {
            this.ccz.eC(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.ccA.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fD(int i) {
        return this.ccA.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.ccI.b(bVar);
    }

    public boolean aem() {
        return this.cbX;
    }

    @Override // com.baidu.tieba.frs.by
    public void aen() {
        if (this.ccj != null) {
            showFloatingView();
            this.ccj.getListView().setSelection(0);
            this.ccj.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.frs.by
    public ForumWriteData aeo() {
        if (this.cbN == null || this.cbN.aMt() == null) {
            return null;
        }
        ForumData aMt = this.cbN.aMt();
        ForumWriteData forumWriteData = new ForumWriteData(aMt.getId(), aMt.getName(), aMt.getPrefixData(), this.cbN.qe());
        forumWriteData.setForumLevel(aMt.getUser_level());
        forumWriteData.setAvatar(this.cbN.aMt().getImage_url());
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.by
    public void wK() {
        changeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void cA(boolean z) {
        if (this.ccj != null) {
            this.ccj.cA(z);
        }
    }
}
