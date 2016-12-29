package com.baidu.tieba.frs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.f;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.performanceLog.e;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.acrossForum.AcrossForumViewData;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.utils.q;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FrsActivity extends BaseActivity<FrsActivity> implements a.InterfaceC0000a, BdListView.e, f.c, UserIconBox.b, VoiceManager.c, cf, com.baidu.tieba.recapp.g {
    private com.baidu.adp.lib.f.b<TbImageView> ahl;
    private com.baidu.tieba.frs.entelechy.b.a bxT;
    private boolean bxW;
    public com.baidu.tbadk.core.data.bg bxX;
    private com.baidu.tieba.frs.d.d byA;
    private com.baidu.tieba.frs.headvideo.b byB;
    private cg byC;
    private com.baidu.tieba.frs.entelechy.b.b byE;
    private com.baidu.tbadk.e.a byF;
    private com.baidu.tieba.frs.h.a byG;
    private com.baidu.tieba.frs.acrossForum.j byH;
    private AcrossForumViewData byI;
    private com.baidu.tieba.frs.h.an byJ;
    private com.baidu.tieba.frs.d.k byK;
    private com.baidu.tieba.frs.d.h byL;
    private com.baidu.tieba.frs.h.ad byM;
    private com.baidu.tieba.frs.d.a byN;
    private com.baidu.tieba.frs.acrossForum.c byO;
    public com.baidu.tieba.frs.h.f byP;
    private com.baidu.tieba.tbadkCore.data.f byd;
    private VoiceManager byf;
    private bq byi;
    private q.a byp;
    private com.baidu.tieba.frs.d.i byr;
    private com.baidu.tieba.frs.h.s bys;
    private com.baidu.tieba.frs.h.ak byt;
    private com.baidu.tieba.frs.h.ab byu;
    private com.baidu.tieba.frs.view.q byv;
    private com.baidu.tieba.frs.entelechy.b.d byw;
    private com.baidu.tieba.frs.d.p byx;
    private com.baidu.tieba.frs.d.b byy;
    private com.baidu.tieba.frs.f.d byz;
    private static final int bxR = (com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst()) - com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds100)) - com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds90);
    private static final int bxS = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds300);
    private static boolean isNeedRefreshOnResume = false;
    public static boolean bxV = false;
    public static volatile long byj = 0;
    public static volatile long byk = 0;
    public static volatile int byl = 0;
    public boolean bxU = false;
    public String bxY = null;
    public String acW = null;
    public int mFlag = 0;
    private boolean bxZ = false;
    private boolean bya = false;
    private String mThreadId = null;
    private String forumId = null;
    private int byb = 0;
    private boolean byc = false;
    private boolean bye = false;
    private ax byg = null;
    public final com.baidu.tbadk.core.data.bg aMR = null;
    private com.baidu.tieba.tbadkCore.o byh = new com.baidu.tieba.tbadkCore.o();
    public long bpV = -1;
    public long aCf = 0;
    public long aBX = 0;
    public long createTime = 0;
    public long Rx = -1;
    private boolean bym = false;
    private boolean byn = false;
    public e byo = null;
    private boolean byq = true;
    private boolean byD = true;
    private final CustomMessageListener byQ = new h(this, CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED);
    private final ce byR = new t(this);
    private cd byS = new ab(this);
    private final CustomMessageListener byT = new ac(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    public final CustomMessageListener byU = new ad(this, CmdConfigCustom.MSG_NEW);
    private final CustomMessageListener byV = new ae(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    public final com.baidu.tieba.tbadkCore.q byW = new af(this);
    private final CustomMessageListener byX = new ag(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private final CustomMessageListener mMemListener = new ah(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private CustomMessageListener byY = new i(this, CmdConfigCustom.CMD_DRIFTING_BOTTLE_CLEAR_MESSAGE);
    private final com.baidu.tieba.frs.d.t byZ = new j(this);
    public final View.OnTouchListener aJN = new k(this);
    private final CustomMessageListener bza = new l(this, CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE);
    private final CustomMessageListener bzb = new m(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);
    private final com.baidu.adp.framework.listener.a bzc = new n(this, CmdConfigHttp.CMD_SET_COMMON_FORUM_STATE, 309365);
    public final View.OnClickListener bzd = new o(this);
    private final AbsListView.OnScrollListener bze = new p(this);
    private final com.baidu.tbadk.util.e<Boolean> bzf = new q(this);
    private final as bzg = new r(this);
    private final NoNetworkView.a aSE = new u(this);
    private final CustomMessageListener bzh = new v(this, 0);
    private com.baidu.adp.widget.ListView.w bzi = new a(this, null);
    private com.baidu.adp.widget.ListView.x bzj = new w(this);
    private ce bzk = new x(this);

    public com.baidu.tieba.frs.h.an Wa() {
        return this.byJ;
    }

    public com.baidu.tieba.frs.entelechy.b.b Wb() {
        return this.byE;
    }

    public com.baidu.adp.widget.ListView.w Wc() {
        return this.bzi;
    }

    public com.baidu.adp.widget.ListView.x Wd() {
        return this.bzj;
    }

    public com.baidu.tieba.frs.d.k We() {
        return this.byK;
    }

    public com.baidu.tieba.frs.headvideo.b Wf() {
        return this.byB;
    }

    public com.baidu.tieba.frs.f.d Wg() {
        return this.byz;
    }

    public com.baidu.tieba.frs.d.i Wh() {
        return this.byr;
    }

    public com.baidu.tieba.frs.h.ab Wi() {
        return this.byu;
    }

    public com.baidu.tieba.frs.h.ak Wj() {
        return this.byt;
    }

    public com.baidu.tieba.frs.d.h Wk() {
        return this.byL;
    }

    public com.baidu.tieba.frs.h.s Wl() {
        return this.bys;
    }

    public com.baidu.tieba.frs.entelechy.b.d Wm() {
        return this.byw;
    }

    public cg Wn() {
        return this.byC;
    }

    public ax Wo() {
        return this.byg;
    }

    @Override // com.baidu.tieba.frs.cf
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.cf
    public String getForumName() {
        return this.bxY;
    }

    public void setForumName(String str) {
        this.bxY = str;
    }

    public void setFrom(String str) {
        this.acW = str;
    }

    public String getFrom() {
        return this.acW;
    }

    public void setFlag(int i) {
        this.mFlag = i;
    }

    @Override // com.baidu.tieba.recapp.g
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.g
    public int getPageNum() {
        if (this.byL == null) {
            return 1;
        }
        return this.byL.getPn();
    }

    public int getPn() {
        if (this.byL == null) {
            return 1;
        }
        return this.byL.getPn();
    }

    public void setPn(int i) {
        if (this.byL != null) {
            this.byL.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.byL != null) {
            this.byL.setHasMore(i);
        }
    }

    public int Wp() {
        if (this.byL == null) {
            return -1;
        }
        return this.byL.Wp();
    }

    public boolean Wq() {
        return this.bye;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar, boolean z) {
        if (this.byg.Xc() != null && !z) {
            this.byg.Xc().setVisibility(8);
        }
        if (this.byg.Xf() != null && !z) {
            this.byg.Xf().setVisibility(8);
        }
        if (this.byu != null) {
            this.byu.dS(false);
        }
        if (aVar == null) {
            showNetRefreshView(this.byg.Xv(), getPageContext().getString(r.j.error_unkown_try_again), true);
        } else if (aVar.fdo) {
            if (340001 == aVar.errorCode) {
                showNetRefreshViewNoClick(this.byg.Xv(), getPageContext().getResources().getString(r.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
            } else {
                showNetRefreshView(this.byg.Xv(), getPageContext().getResources().getString(r.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
            }
        } else if (340001 == aVar.errorCode) {
            showNetRefreshViewNoClick(this.byg.Xv(), aVar.errorMsg, true);
        } else {
            showNetRefreshView(this.byg.Xv(), aVar.errorMsg, true);
        }
        setNetRefreshViewEmotionDefMarginTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wr() {
        hideLoadingView(this.byg.Xv());
        this.byg.dw(false);
        this.byg.Xq();
        if (this.byg.WW() instanceof com.baidu.tieba.frs.tab.h) {
            ((com.baidu.tieba.frs.tab.h) this.byg.WW()).abt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ws() {
        if (Wp() == 0 && com.baidu.tbadk.core.util.x.t(this.byh.bed())) {
            if (com.baidu.tbadk.core.util.x.t(this.byh.getThreadList())) {
                this.byg.Xz();
                return;
            } else {
                this.byg.Jh();
                return;
            }
        }
        this.byg.Xy();
    }

    public void a(ErrorData errorData) {
        boolean z = true;
        Wr();
        this.byg.Xj();
        d.a aaL = this.byr.aaL();
        boolean t = com.baidu.tbadk.core.util.x.t(this.byh.getThreadList());
        if (aaL != null && t) {
            if (t) {
                if (this.byr.aaM() != 0) {
                    this.byr.aaS();
                    this.byg.Xj();
                } else {
                    a(aaL, false);
                }
                ax axVar = this.byg;
                if (!this.byh.bfd() && !Wv()) {
                    z = false;
                }
                axVar.o(z, false);
                return;
            } else if (aaL.fdo) {
                this.byg.o(true, false);
                showToast(getPageContext().getResources().getString(r.j.net_error_text, aaL.errorMsg, Integer.valueOf(aaL.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(aaL, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wt() {
        if (this.byh == null || this.byh.aIk() != null) {
            this.byg.Xt();
        } else if (this.byh.aIk().getYuleData() != null && this.byh.aIk().getYuleData().sT()) {
            TiebaStatic.log("c10852");
            this.byg.a(this.byh.aIk().getYuleData().sU());
        } else {
            this.byg.Xt();
        }
    }

    /* renamed from: do  reason: not valid java name */
    private void m17do(boolean z) {
        if (this.byr != null && this.byh != null && this.byg != null && z) {
            if (!this.byr.aaZ() && this.byr.aaO() == 1) {
                if (this.byg.Xu().k(com.baidu.tieba.tbadkCore.aj.ffv)) {
                    this.byh.beQ();
                }
                if (!this.byr.aaX()) {
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.byh.beW();
                        this.byh.beV();
                        this.byh.beS();
                    }
                    this.byh.beT();
                    this.byh.beU();
                }
                boolean z2 = false;
                if (this.byg.Xu().k(com.baidu.tieba.card.data.q.beO)) {
                    z2 = this.byh.beZ();
                }
                if (!z2) {
                    this.byh.beY();
                }
                if (TbadkCoreApplication.m9getInst().isRecAppExist()) {
                    this.byh.bp(getPageContext().getPageActivity());
                }
                this.byh.bfa();
                this.byh.bfb();
            }
            this.byh.beO();
            this.byh.beM();
            this.byh.beP();
        }
    }

    public boolean Wu() {
        if (this.byw != null && this.byg != null && !Wv()) {
            this.byw.u(this.byg.Xm());
        }
        if (this.bys != null && this.byr != null) {
            this.bys.a(this.byr.aaK(), this.byh);
        }
        boolean z = false;
        if (this.byh != null) {
            z = this.byh.bfe();
        }
        dp(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ha(int i) {
        cl clVar = null;
        Wu();
        WD();
        try {
            if (this.byh != null) {
                this.byg.a((ArrayList<com.baidu.adp.widget.ListView.v>) null, this.byh);
                this.bys.hU(1);
                this.byg.Xn();
                this.byw.a(this.byg.Xm(), this.byh, this.byr.aaU());
                com.baidu.tieba.frs.tab.i a2 = a(this.byw.Zd(), this.byh.bet());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    clVar = new cl();
                    clVar.bBQ = a2.url;
                    clVar.stType = a2.name;
                }
                this.byr.a(this.byh.bet(), 0, clVar);
                this.byw.dR(false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private com.baidu.tieba.frs.tab.i a(TabData tabData, int i) {
        if (i < 0 || tabData == null || tabData.size() <= 0) {
            return null;
        }
        Iterator it = tabData.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.i iVar = (com.baidu.tieba.frs.tab.i) it.next();
            if (iVar != null && iVar.bNm == i) {
                return iVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, boolean z2) {
        try {
            if (this.byh != null && this.byw != null && this.byr != null) {
                if (this.byh.aIk() != null) {
                    this.bxY = this.byh.aIk().getName();
                    this.forumId = this.byh.aIk().getId();
                }
                if (z) {
                    m17do(true);
                } else {
                    m17do(this.byq);
                }
                Wu();
                if (this.byh.bfe()) {
                    this.byw.a(this.byg.Xm(), this.byh, this.byr.aaU());
                }
                if (this.byE != null) {
                    this.byE.a(this.bys, this.byh);
                }
                if (this.byh.getPage() != null) {
                    setHasMore(this.byh.getPage().qE());
                }
                ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.byL.a(z2, true, this.byh.getThreadList(), null);
                if (a2 != null) {
                    this.byh.at(a2);
                }
                if (this.byr.aaO() == 1) {
                    Wy();
                }
                this.byb = this.byh.aaQ();
                if (this.byd != null) {
                    this.byc = true;
                    this.byd.re(this.byb);
                    com.baidu.tieba.frs.utils.a.a(this.byh.aIk(), this.byh.getThreadList(), this.byc, getPn());
                }
                if (this.byG != null) {
                    this.byG.ee(this.byr.aaZ());
                    this.byG.ai(this.byw.Ze());
                }
                Wr();
                if (this.byh.aIk() != null) {
                    this.byt.eh(this.byh.aIk().isLike() == 1);
                }
                if (this.byg.Xc() != null && this.mIsLogin) {
                    this.byg.Xc().setVisibility(0);
                }
                if (this.byu != null && this.mIsLogin) {
                    this.byu.dS(true);
                }
                if (this.byu != null && !this.byu.Zo()) {
                    this.byg.du(this.byr.aaP());
                }
                if (this.byh.aIk().isIs_forbidden() == 1) {
                    this.byt.ej(false);
                } else {
                    this.byt.ej(true);
                }
                this.byg.o(true, false);
                this.byt.ei(this.byh.bdW() == 1);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.m mVar) {
        try {
            if (!this.bym && mVar != null && this.byh != null) {
                this.byh.d(mVar);
                n(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void dp(boolean z) {
        if (this.byr != null) {
            g(z, this.byr.aaK());
        } else {
            g(z, "normal_page");
        }
    }

    private void g(boolean z, String str) {
        if (!Wv()) {
            if (this.byI == null) {
                dq("frs_page".equals(str));
            } else {
                dq(true);
            }
        }
        if (this.byE != null) {
            this.byE.a(z, this.byw, this.bys, this.byg, this.byh);
        }
    }

    public boolean Wv() {
        return this.byJ != null && this.byJ.Wv();
    }

    public void dq(boolean z) {
        if (this.byM != null) {
            this.byM.b(this.byg, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bpV = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            j(intent);
        } else {
            this.bpV = System.currentTimeMillis();
        }
        this.Rx = System.currentTimeMillis();
        this.aBX = this.Rx - this.bpV;
        super.onCreate(bundle);
        this.byd = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.ffV);
        this.byr = new com.baidu.tieba.frs.d.i(this, this.byW);
        this.byr.a(this.byR);
        this.byr.init();
        if (getIntent() != null) {
            this.byr.d(getIntent().getExtras());
        } else if (bundle != null) {
            this.byr.d(bundle);
        } else {
            this.byr.d((Bundle) null);
        }
        this.bxT = new com.baidu.tieba.frs.entelechy.i();
        this.byE = this.bxT.YA();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(r.h.frs_activity, (ViewGroup) null);
        this.byu = new com.baidu.tieba.frs.h.ab(this, this.bxT.Yz());
        this.byt = new com.baidu.tieba.frs.h.ak(this);
        this.byu.a(getPageContext().getPageActivity(), inflate, this.byt.acc().getView());
        this.bys = new com.baidu.tieba.frs.h.s(this, this.bxT);
        this.byw = this.bxT.B(this);
        this.byg = new ax(this, this.bzd, this.bxT);
        this.bys.a(this.byg.JI());
        this.byJ = new com.baidu.tieba.frs.h.an(this, this.byg, this.byw, this.bys);
        this.byw.ae(this.byg.Xv());
        if (getIntent() != null) {
            this.bys.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.bys.f(bundle);
        } else {
            this.bys.f((Bundle) null);
        }
        this.byf = getVoiceManager();
        this.byf.onCreate(getPageContext());
        initUI();
        initData(bundle);
        this.byC = new cg(getActivity(), this.byg, this.bys);
        this.byC.a(this.bzf);
        this.byC.dF(true);
        new com.baidu.tieba.frs.d.r();
        this.byL = new com.baidu.tieba.frs.d.h(this, this.byZ);
        this.byz = new com.baidu.tieba.frs.f.d(this);
        this.byM = new com.baidu.tieba.frs.h.ad(this);
        addGlobalLayoutListener();
        this.createTime = System.currentTimeMillis() - this.Rx;
        this.byO = new com.baidu.tieba.frs.acrossForum.c(this, this.byI);
        if (this.byI != null) {
            this.bys.b(this.byI);
            this.byH = new com.baidu.tieba.frs.acrossForum.j(getPageContext(), this.byJ, this.bys, this.byh);
            this.byC.a(this.byH.Yo());
            com.baidu.tieba.frs.acrossForum.a.Yl().iD("across_sign");
        }
        this.byG = new com.baidu.tieba.frs.h.a(getPageContext(), this.byr.aaW());
        this.byB = new com.baidu.tieba.frs.headvideo.b(this.bys);
        this.byA = new com.baidu.tieba.frs.d.d(this);
        this.byK = new com.baidu.tieba.frs.d.k(this);
        this.byx = new com.baidu.tieba.frs.d.p(this);
        this.byy = new com.baidu.tieba.frs.d.b(this);
        this.byN = new com.baidu.tieba.frs.d.a(this);
        this.byN.b(this.byI);
        registerListener(this.mMemListener);
        registerListener(this.byU);
        registerListener(this.byV);
        registerListener(this.bza);
        registerListener(this.byT);
        registerListener(this.byX);
        registerListener(this.bzc);
        registerListener(this.byQ);
        registerListener(this.byY);
        showLoadingView(this.byg.Xv(), true);
        this.byg.dy(false);
        this.byr.q(3, true);
        this.byP = new com.baidu.tieba.frs.h.f(this);
    }

    private void j(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.utils.q.a(this, getForumName(), "from", getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
                finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.bxY = data.getQueryParameter("name");
            this.acW = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.bxY)) {
                intent.putExtra("name", this.bxY);
            }
            if (!StringUtils.isNull(this.acW)) {
                intent.putExtra("from", this.acW);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.bxY)) {
            this.bxY = com.baidu.tieba.frs.utils.t.k(intent);
            if (!StringUtils.isNull(this.bxY)) {
                intent.putExtra("name", this.bxY);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.byf = getVoiceManager();
        this.byf.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bzh);
        if (bundle != null) {
            this.bxY = bundle.getString("name");
            this.acW = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            try {
                this.byI = (AcrossForumViewData) bundle.getSerializable(FrsActivityConfig.ACROSS_FROUM_DATA);
            } catch (Exception e) {
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bxY = intent.getStringExtra("name");
                this.acW = intent.getStringExtra("from");
                this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
                try {
                    this.byI = (AcrossForumViewData) intent.getSerializableExtra(FrsActivityConfig.ACROSS_FROUM_DATA);
                } catch (Exception e2) {
                }
            }
        }
        if (!TextUtils.isEmpty(this.acW) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.acW)) {
            setSwipeBackEnabled(false);
        }
        this.byi = new bq(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            Ww();
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.bzh);
        }
        this.bys.f(bundle);
    }

    public void Ww() {
        if (this.byi != null && this.byg != null) {
            if (FrsActivityStatic.bzr || FrsActivityStatic.bzs) {
                this.byi.aV(com.baidu.tbadk.coreExtra.messageCenter.a.yy().getMsgReplyme());
                this.byi.aU(com.baidu.tbadk.coreExtra.messageCenter.a.yy().getMsgAtme());
                this.byi.aX(com.baidu.tbadk.coreExtra.messageCenter.a.yy().yF());
                this.byi.aW(com.baidu.tbadk.coreExtra.messageCenter.a.yy().getMsgChat());
                this.byg.a(this.byi);
                this.byt.a(this.byi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.card.bz.OH().cz(false);
        if (this.byh != null && this.byh.aIk() != null) {
            ca.XZ().aZ(com.baidu.adp.lib.h.b.c(this.byh.aIk().getId(), 0L));
        }
        if (this.byg != null) {
            com.baidu.tieba.frs.utils.s.a(this.byg, this.byh, getForumId(), false, null);
            this.byg.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.byo != null) {
                this.byo.onDestroy();
            }
            this.byg.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.byr.onActivityDestroy();
        this.bys.onActivityDestroy();
        this.byf = getVoiceManager();
        this.byf.onDestory(getPageContext());
        if (this.byp != null) {
            this.byp.cancel(true);
            this.byp = null;
        }
        if (this.byr != null) {
            this.byr.VI();
        }
        if (this.byt != null) {
            this.byt.destroy();
        }
        if (this.byC != null) {
            this.byC.Up();
        }
        if (this.byF != null) {
            this.byF.destory();
        }
        if (this.byG != null) {
            this.byG.destory();
        }
        if (this.byJ != null) {
            this.byJ.onDestroy();
        }
        if (this.byz != null) {
            this.byz.onDestroy();
        }
        if (this.byH != null) {
            this.byH.onDestory();
        }
        com.baidu.tieba.recapp.c.a.aYn().aYp();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.bxY);
        bundle.putString("from", this.acW);
        this.byr.onSaveInstanceState(bundle);
        this.byf = getVoiceManager();
        if (this.byf != null) {
            this.byf.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.byN != null) {
            this.byN.onActivityResult(i, i2, intent);
        }
    }

    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.byF == null) {
                this.byF = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.byF.aq(updateAttentionMessage.getData().toUid, getForumId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.byg != null) {
            this.byg.Xj();
            this.byg.onResume();
            com.baidu.tieba.frs.utils.t.q(this.byg);
        }
        this.byw.a(this.byS);
        this.byx.ec(true);
        this.byq = true;
        if (this.byB != null) {
            this.byB.eb(false);
        }
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.byg.kv();
        } else if (bxV) {
            bxV = false;
            this.byg.kv();
        } else {
            this.byf = getVoiceManager();
            this.byf.onResume(getPageContext());
            this.byg.dB(false);
            registerListener(this.bzb);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.byg.dz(z);
        this.byu.dS(z);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.bxY = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.acW = intent.getStringExtra("from");
            }
            this.bya = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.bya) {
                dr(intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false));
            }
        }
    }

    private void dr(boolean z) {
        this.byg.kv();
        this.byu.dU(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        com.baidu.tieba.frs.utils.t.a(this, getIntent(), this.acW);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.byg.setTitle(this.bxY);
        } else {
            this.byg.setTitle("");
            this.mFlag = 1;
        }
        this.bys.c(this.byg.Xm());
        this.byg.a(this.bzi);
        this.byg.a(this.bzj);
        this.byg.setOnScrollListener(this.bze);
        this.byg.g(this.aSE);
        this.byg.Xu().a(this.bzg);
        if (!this.mIsLogin) {
            this.byg.dz(false);
            this.byu.dS(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.byg.onChangeSkinType(i);
        this.byt.a(getPageContext(), i);
        this.bys.a(getPageContext(), i);
        this.byw.onChangeSkinType(i);
        changeSwipeSkinType(i);
        if (this.byH != null) {
            this.byH.tm();
        }
    }

    @Override // com.baidu.adp.widget.f.c
    public void ld() {
        setSwipeBackEnabled(true);
        this.byu.dS(true);
    }

    @Override // com.baidu.adp.widget.f.c
    public void le() {
        setSwipeBackEnabled(false);
        this.byu.dS(false);
    }

    public void hb(int i) {
        if (!this.mIsLogin) {
            if (this.byh != null && this.byh.qt() != null) {
                this.byh.qt().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.byh != null) {
            if (i == 0) {
                if (!this.bxW) {
                    com.baidu.tieba.frs.utils.u.b(this, 0);
                    return;
                }
                TiebaStatic.log("c10152");
                com.baidu.tieba.frs.utils.u.b(this, 4);
                return;
            }
            this.byg.Xl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(com.baidu.tbadk.core.data.bg bgVar) {
        boolean z = bgVar == null || bgVar.st();
        this.byg.a(new z(this, bgVar));
        this.byg.b(bgVar, z);
    }

    public void refresh() {
        cl(3);
    }

    public void cl(int i) {
        this.bym = false;
        WD();
        if (this.byg.JI() != null) {
            this.byg.JI().alQ();
        }
        this.byr.q(i, true);
    }

    private void Wx() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.h.k.eH().f(new aa(this));
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wy() {
        WD();
        try {
            if (this.byh != null) {
                this.byg.JF();
                this.byO.Us();
                if (this.byH != null) {
                    this.byH.c(this.byh);
                }
                if (this.byu != null && !this.byu.Zo()) {
                    this.byg.du(this.byr.aaP());
                }
                if (!Wv() && com.baidu.tieba.frs.h.s.m(this.byh) && !com.baidu.tieba.frs.h.s.l(this.byh)) {
                    this.byg.XE();
                }
                if (this.byh.aIk() != null) {
                    this.bxY = this.byh.aIk().getName();
                    this.forumId = this.byh.aIk().getId();
                }
                if (this.byh.getPage() != null) {
                    setHasMore(this.byh.getPage().qE());
                }
                this.byg.setTitle(this.bxY);
                this.byg.setForumName(this.bxY);
                TbadkCoreApplication.m9getInst().setDefaultBubble(this.byh.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(this.byh.getUserData().getBimg_end_time());
                Wx();
                Wz();
                ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.byh.getThreadList();
                if (threadList != null) {
                    this.byg.a(threadList, this.byh);
                    com.baidu.tieba.frs.utils.e.p(this.byg);
                    this.bys.hU(getPageNum());
                    this.bys.i(this.byh);
                    this.byw.a(this.byg.Xm(), this.byh, this.byr.aaU());
                    this.byg.Xn();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void Wz() {
        if (this.byh != null) {
            if (this.byh.aIv() == 1) {
                this.byg.Xu().setFromCDN(true);
            } else {
                this.byg.Xu().setFromCDN(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.byx.ec(false);
        this.byq = false;
        this.byg.onPause();
        this.byf = getVoiceManager();
        this.byf.onPause(getPageContext());
        this.byg.dB(true);
        if (this.byG != null) {
            this.byG.abw();
        }
        if (this.byB != null) {
            this.byB.eb(true);
        }
        MessageManager.getInstance().unRegisterListener(this.bzb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.bz.OH().cz(false);
        if (this.byh != null && this.byh.aIk() != null) {
            com.baidu.tbadk.distribute.a.Ck().b(getPageContext().getPageActivity(), "frs", this.byh.aIk().getId(), 0L);
        }
        this.byf = getVoiceManager();
        if (this.byf != null) {
            this.byf.onStop(getPageContext());
        }
        com.baidu.tieba.frs.utils.t.d(getListView());
        this.bys.onActivityStop();
        com.baidu.tbadk.util.r.GD();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.bxZ) {
            if (i == 4) {
                if (this.byu.Zo()) {
                    this.byu.dT(true);
                    if (this.byt.acc().Yg()) {
                        this.byt.acc().dK(false);
                        refresh();
                        return true;
                    }
                    return true;
                } else if (Wv()) {
                    this.byJ.ack();
                    return true;
                } else if (this.byg.Xi()) {
                    return true;
                } else {
                    closeActivity();
                    return true;
                }
            }
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public boolean WA() {
        if (this.byv == null) {
            return false;
        }
        return this.byv.isShowing();
    }

    public void WB() {
        this.byp = com.baidu.tieba.frs.utils.q.b(this, this.bxY);
    }

    @Override // com.baidu.tieba.recapp.g
    public BaseActivity<?> getContext() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.g
    public void a(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.Ck().a(cVar, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.g
    public void WC() {
        Wh().WC();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.byf == null) {
            this.byf = VoiceManager.instance();
        }
        return this.byf;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: Pv */
    public BdListView getListView() {
        if (this.byg == null) {
            return null;
        }
        return this.byg.Xm();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void WD() {
        this.byf = getVoiceManager();
        this.byf.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> wF() {
        if (this.ahl == null) {
            this.ahl = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.ahl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            int msgOfficialMerge = newsNotifyMessage.getMsgOfficialMerge();
            int msgStrangerChat = newsNotifyMessage.getMsgStrangerChat();
            if (this.byi != null) {
                this.byi.aV(msgReplyme);
                this.byi.aU(msgAtme);
                this.byi.aY(msgOfficialMerge);
                this.byi.aW(msgChat);
                this.byi.aX(msgStrangerChat);
                this.byg.a(this.byi);
                this.byt.a(this.byi);
            }
        }
    }

    public void WE() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class a implements com.baidu.adp.widget.ListView.w {
        private a() {
        }

        /* synthetic */ a(FrsActivity frsActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: com.baidu.tieba.frs.FrsActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
            String str;
            if (bdUniqueId != null) {
                if (bdUniqueId == bl.bBa) {
                    if (FrsActivity.this.byg != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11752").ab("fid", FrsActivity.this.forumId).ab("obj_locate", "1"));
                        FrsActivity.this.byg.kv();
                    }
                } else if (vVar != null && (vVar instanceof com.baidu.tbadk.core.data.bg)) {
                    com.baidu.tbadk.core.data.bg bgVar = (com.baidu.tbadk.core.data.bg) vVar;
                    if (bgVar.so() == null || bgVar.so().getGroup_id() == 0 || FrsActivity.this.checkUpIsLogin()) {
                        if ((bgVar.sh() != 1 && bgVar.sh() != 2) || FrsActivity.this.checkUpIsLogin()) {
                            if (bgVar.rS() != null) {
                                if (FrsActivity.this.checkUpIsLogin()) {
                                    String postUrl = bgVar.rS().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.gD()) {
                                        com.baidu.tbadk.browser.f.v(FrsActivity.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bgVar.sz() != null) {
                                com.baidu.tbadk.core.data.n sz = bgVar.sz();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsActivity.this.getPageContext().getPageActivity(), sz.getCartoonId(), sz.getChapterId(), 2)));
                            } else if (bgVar.getThreadType() == 47 && bgVar.rA() == 1 && !com.baidu.tbadk.core.util.av.isEmpty(bgVar.rM())) {
                                com.baidu.tbadk.browser.f.u(FrsActivity.this.getPageContext().getPageActivity(), bgVar.rM());
                            } else {
                                com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.qv(bgVar.getId())) {
                                    readThreadHistory.qu(bgVar.getId());
                                }
                                boolean z = false;
                                String rM = bgVar.rM();
                                if (rM != null && !rM.equals("")) {
                                    z = true;
                                    new Thread(new ai(this, rM)).start();
                                }
                                String tid = bgVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bgVar.rA() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.bc vz = com.baidu.tbadk.core.util.bc.vz();
                                    TbPageContext<?> pageContext = FrsActivity.this.getPageContext();
                                    String[] strArr = new String[3];
                                    strArr[0] = tid;
                                    strArr[1] = "";
                                    vz.c(pageContext, strArr);
                                    return;
                                }
                                boolean z2 = false;
                                if (bgVar instanceof com.baidu.tbadk.core.data.z) {
                                    z2 = true;
                                    TiebaStatic.log("c10769");
                                }
                                if (bgVar.getThreadType() == 33 || (bgVar instanceof com.baidu.tbadk.core.data.au)) {
                                    if (!z2) {
                                        if (bgVar.getThreadType() == 33) {
                                            str = "c10245";
                                        } else {
                                            str = "c10180";
                                        }
                                        if (FrsActivity.this.byr.aaO() == 5) {
                                            str = "c10387";
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.at(str).ab("fid", FrsActivity.this.forumId));
                                    }
                                    com.baidu.tieba.frs.utils.t.d(FrsActivity.this, bgVar);
                                    if (FrsActivity.this.byh != null && FrsActivity.this.byh.aIk() != null) {
                                        com.baidu.tieba.frs.g.a aVar = new com.baidu.tieba.frs.g.a();
                                        aVar.bML = FrsActivity.this.byh.fdP == 1;
                                        aVar.bMN = FrsActivity.this.byh.aIk().getId();
                                        aVar.bMM = FrsActivity.this.Wh().aaU();
                                        com.baidu.tieba.frs.g.b.abq().a(aVar, bgVar, 1);
                                        return;
                                    }
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bgVar.setId(tid.substring(3));
                                }
                                if (!z2 && FrsActivity.this.byr.aaO() == 2) {
                                    com.baidu.tbadk.core.util.at atVar = new com.baidu.tbadk.core.util.at("c10077");
                                    atVar.s("obj_source", FrsActivity.this.byr.aaO());
                                    atVar.ab("tid", bgVar.getId());
                                    atVar.ab("fid", FrsActivity.this.getForumId());
                                    TiebaStatic.log(atVar);
                                }
                                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.bg.Uu.getId()) {
                                    com.baidu.tieba.frs.utils.s.a(bgVar.ro());
                                    com.baidu.tieba.frs.utils.t.c(FrsActivity.this, bgVar);
                                    return;
                                }
                                com.baidu.tieba.frs.utils.t.a(FrsActivity.this, bgVar, i, z);
                                com.baidu.tieba.frs.utils.s.a(FrsActivity.this, FrsActivity.this.byh, bgVar);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.k.gD()) {
            hideNetRefreshView(this.byg.Xv());
            showLoadingView(this.byg.Xv(), true);
            this.byg.dy(false);
            this.byg.kv();
        }
    }

    public com.baidu.tieba.tbadkCore.o WF() {
        return this.byh;
    }

    public boolean WG() {
        return this.byg.WG();
    }

    public void WH() {
        FrsActivityStatic.bzr = false;
        FrsActivityStatic.bzs = false;
        Ww();
    }

    public void K(Object obj) {
        if (this.byA != null && this.byA.bLM != null) {
            this.byA.bLM.g(obj);
        }
    }

    public void L(Object obj) {
        if (this.byA != null && this.byA.bLN != null) {
            this.byA.bLN.g(obj);
        }
    }

    public void WI() {
        this.bys.WI();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        if (!com.baidu.adp.lib.util.k.gD()) {
            this.byg.Xz();
        } else if (this.byr.aaO() == 1) {
            Jd();
            WJ();
        } else if (this.byr.hasMore()) {
            WJ();
        }
    }

    public void iA(String str) {
        Jd();
        showToast(str);
    }

    public void D(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        Jd();
        if (!com.baidu.tbadk.core.util.x.t(arrayList)) {
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.byL.a(false, false, arrayList, this.byd);
            if (a2 != null) {
                this.byh.at(a2);
                this.byg.a(a2, this.byh);
            }
            if (this.byr != null) {
                com.baidu.tieba.frs.g.b.a(this.byh, this.byr.aaU(), 2);
            }
        }
    }

    private void Jd() {
        if (Wp() == 1 || this.byL.as(this.byh.bed())) {
            this.byg.Xy();
        } else if (com.baidu.tbadk.core.util.x.t(this.byh.getThreadList())) {
            this.byg.Xz();
        } else {
            this.byg.Jh();
        }
    }

    public void WJ() {
        if (this.byL != null) {
            this.byL.a(this.bxY, this.forumId, this.byh);
        }
    }

    public boolean WK() {
        return this.byt.acc().Yg();
    }

    public void ds(boolean z) {
        this.byt.acc().dK(z);
    }

    public void WL() {
        if (!com.baidu.tbadk.core.util.ae.d(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.aq.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a006";
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.utils.t.a(this, i, strArr, iArr);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    public void WM() {
        if (this.byG != null) {
            this.byG.abw();
        }
    }

    public void dt(boolean z) {
        if (this.byJ != null) {
            this.byJ.dt(z);
        }
        if (this.byC != null) {
            this.byC.dF(z);
        }
    }
}
