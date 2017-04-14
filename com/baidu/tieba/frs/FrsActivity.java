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
import com.baidu.tbadk.core.data.AdvertAppInfo;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.InjectPlugin.a.b;
import com.baidu.tieba.frs.f.q;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FrsActivity extends BaseActivity<FrsActivity> implements a.InterfaceC0000a, BdListView.e, f.c, UserIconBox.b, VoiceManager.c, b, cf, com.baidu.tieba.frs.mc.y, com.baidu.tieba.recapp.s {
    private com.baidu.adp.lib.e.b<TbImageView> amf;
    private VoiceManager bMC;
    private bq bMF;
    private q.a bMM;
    private FrsModelController bMO;
    private com.baidu.tieba.frs.g.u bMP;
    private com.baidu.tieba.frs.g.ao bMQ;
    private com.baidu.tieba.frs.g.ad bMR;
    private com.baidu.tieba.frs.view.q bMS;
    private com.baidu.tieba.frs.entelechy.b.d bMT;
    private com.baidu.tieba.frs.mc.s bMU;
    private com.baidu.tieba.frs.mc.b bMV;
    private com.baidu.tieba.frs.smartsort.c bMW;
    private com.baidu.tieba.frs.mc.d bMX;
    private cg bMY;
    private com.baidu.tieba.frs.entelechy.b.a bMp;
    private boolean bMs;
    public com.baidu.tbadk.core.data.bi bMt;
    private com.baidu.tieba.tbadkCore.data.e bMz;
    private com.baidu.tieba.frs.entelechy.b.b bNa;
    private com.baidu.tbadk.h.a bNb;
    private com.baidu.tieba.frs.g.a bNc;
    private com.baidu.tieba.frs.g.as bNd;
    private com.baidu.tieba.frs.mc.l bNe;
    private com.baidu.tieba.frs.mc.h bNf;
    private com.baidu.tieba.frs.g.ah bNg;
    private com.baidu.tieba.frs.mc.a bNh;
    private ay bNi;
    public com.baidu.tieba.frs.g.f bNj;
    private com.baidu.tieba.frs.mc.p bNk;
    private static boolean isNeedRefreshOnResume = false;
    public static boolean bMr = false;
    public static volatile long bMG = 0;
    public static volatile long bMH = 0;
    public static volatile int bMI = 0;
    public boolean bMq = false;
    public String bMu = null;
    public String ahM = null;
    public int mFlag = 0;
    private boolean bMv = false;
    private boolean bMw = false;
    private String mThreadId = null;
    private String forumId = null;
    private int bMx = 0;
    private boolean bMy = false;
    private boolean bMA = false;
    private boolean bMB = false;
    private az bMD = null;
    public final com.baidu.tbadk.core.data.bi aRV = null;
    private com.baidu.tieba.tbadkCore.n bME = new com.baidu.tieba.tbadkCore.n();
    public long bEG = -1;
    public long aGE = 0;
    public long aGw = 0;
    public long createTime = 0;
    public long Wi = -1;
    private boolean bMJ = false;
    private boolean bMK = false;
    public com.baidu.tbadk.j.e bML = null;
    private boolean bMN = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> bMZ = new SparseArray<>();
    private boolean bxZ = true;
    private final CustomMessageListener bNl = new d(this, CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED);
    private final ce bNm = new o(this);
    private cd bNn = new aa(this);
    private CustomMessageListener bNo = new ab(this, CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT);
    private CustomMessageListener bNp = new ac(this, CmdConfigCustom.CMD_FRS_TAB_LIVE_START);
    private final CustomMessageListener bNq = new ad(this, CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB);
    private final CustomMessageListener bNr = new ae(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    public final CustomMessageListener bNs = new af(this, CmdConfigCustom.MSG_NEW);
    private final CustomMessageListener bNt = new ag(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    public final com.baidu.tieba.tbadkCore.p bNu = new e(this);
    private final CustomMessageListener bNv = new f(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private final CustomMessageListener mMemListener = new g(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private CustomMessageListener bNw = new h(this, CmdConfigCustom.CMD_DRIFTING_BOTTLE_CLEAR_MESSAGE);
    private final com.baidu.tieba.frs.mc.x bNx = new i(this);
    public final View.OnTouchListener aOh = new j(this);
    private final CustomMessageListener bNy = new k(this, CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE);
    private final CustomMessageListener bNz = new l(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);
    private final com.baidu.adp.framework.listener.a bNA = new m(this, CmdConfigHttp.CMD_SET_COMMON_FORUM_STATE, 309365);
    public final View.OnClickListener bNB = new n(this);
    private final AbsListView.OnScrollListener bNC = new p(this);
    private final com.baidu.tbadk.util.e<Boolean> bND = new q(this);
    private final at bNE = new r(this);
    private final NoNetworkView.a bLW = new t(this);
    private final CustomMessageListener bNF = new u(this, 0);
    private com.baidu.adp.widget.ListView.w bNG = new a(this, null);
    private com.baidu.adp.widget.ListView.x bNH = new v(this);
    private ce bNI = new w(this);

    public com.baidu.tieba.frs.g.as YN() {
        return this.bNd;
    }

    public com.baidu.tieba.frs.entelechy.b.b YO() {
        return this.bNa;
    }

    public com.baidu.adp.widget.ListView.w YP() {
        return this.bNG;
    }

    public com.baidu.adp.widget.ListView.x YQ() {
        return this.bNH;
    }

    public com.baidu.tieba.frs.mc.l YR() {
        return this.bNe;
    }

    public com.baidu.tieba.frs.smartsort.c YS() {
        return this.bMW;
    }

    @Override // com.baidu.tieba.frs.mc.y
    public FrsModelController YT() {
        return this.bMO;
    }

    public com.baidu.tieba.frs.g.ad YU() {
        return this.bMR;
    }

    public com.baidu.tieba.frs.g.ao YV() {
        return this.bMQ;
    }

    @Override // com.baidu.tieba.frs.mc.y
    public com.baidu.tieba.frs.mc.h YW() {
        return this.bNf;
    }

    @Override // com.baidu.tieba.frs.mc.y
    public com.baidu.tieba.frs.g.u YX() {
        return this.bMP;
    }

    public com.baidu.tieba.frs.entelechy.b.d YY() {
        return this.bMT;
    }

    public cg YZ() {
        return this.bMY;
    }

    @Override // com.baidu.tieba.frs.mc.y
    public az Za() {
        return this.bMD;
    }

    @Override // com.baidu.tieba.frs.cf
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.cf
    public String getForumName() {
        return this.bMu;
    }

    public void setForumName(String str) {
        this.bMu = str;
    }

    public void setFrom(String str) {
        this.ahM = str;
    }

    public String getFrom() {
        return this.ahM;
    }

    public void setFlag(int i) {
        this.mFlag = i;
    }

    @Override // com.baidu.tieba.recapp.s
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.s
    public com.baidu.adp.widget.ListView.a k(BdUniqueId bdUniqueId) {
        return c.YM().b(this, bdUniqueId);
    }

    @Override // com.baidu.tieba.recapp.s
    public int getPageNum() {
        if (this.bNf == null) {
            return 1;
        }
        return this.bNf.getPn();
    }

    public int getPn() {
        if (this.bNf == null) {
            return 1;
        }
        return this.bNf.getPn();
    }

    public void setPn(int i) {
        if (this.bNf != null) {
            this.bNf.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.bNf != null) {
            this.bNf.setHasMore(i);
        }
    }

    public int Zb() {
        if (this.bNf == null) {
            return -1;
        }
        return this.bNf.Zb();
    }

    public boolean Zc() {
        return this.bMB;
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
        if (this.bMD.ZO() != null && !z) {
            this.bMD.ZO().setVisibility(8);
        }
        if (this.bMD.ZR() != null && !z) {
            this.bMD.ZR().setVisibility(8);
        }
        if (this.bMR != null) {
            this.bMR.dZ(false);
        }
        if (aVar == null) {
            showNetRefreshView(this.bMD.aaf(), getPageContext().getString(w.l.error_unkown_try_again), true);
        } else if (aVar.fsS) {
            if (340001 == aVar.errorCode) {
                showNetRefreshViewNoClick(this.bMD.aaf(), getPageContext().getResources().getString(w.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
            } else {
                showNetRefreshView(this.bMD.aaf(), getPageContext().getResources().getString(w.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
            }
        } else if (340001 == aVar.errorCode) {
            showNetRefreshViewNoClick(this.bMD.aaf(), aVar.errorMsg, true);
        } else {
            showNetRefreshView(this.bMD.aaf(), aVar.errorMsg, true);
        }
        setNetRefreshViewEmotionDefMarginTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zd() {
        hideLoadingView(this.bMD.aaf());
        this.bMD.cg(false);
        this.bMD.aaa();
        if (this.bMD.ZK() instanceof com.baidu.tieba.frs.tab.h) {
            ((com.baidu.tieba.frs.tab.h) this.bMD.ZK()).ads();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ze() {
        if (Zb() == 0 && com.baidu.tbadk.core.util.x.q(this.bME.bgs())) {
            if (com.baidu.tbadk.core.util.x.q(this.bME.getThreadList())) {
                this.bMD.Ug();
                return;
            } else {
                this.bMD.KA();
                return;
            }
        }
        this.bMD.aai();
    }

    public void a(ErrorData errorData) {
        boolean z = true;
        Zd();
        this.bMD.ZV();
        d.a acI = this.bMO.acI();
        boolean q = com.baidu.tbadk.core.util.x.q(this.bME.getThreadList());
        if (acI != null && q) {
            if (q) {
                if (this.bMO.acJ() != 0) {
                    this.bMO.acP();
                    this.bMD.ZV();
                } else {
                    a(acI, false);
                }
                az azVar = this.bMD;
                if (!this.bME.bhq() && !Zh()) {
                    z = false;
                }
                azVar.n(z, false);
                return;
            } else if (acI.fsS) {
                this.bMD.n(true, false);
                showToast(getPageContext().getResources().getString(w.l.net_error_text, acI.errorMsg, Integer.valueOf(acI.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(acI, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zf() {
        if (this.bME == null || this.bME.aJw() != null) {
            this.bMD.aad();
        } else if (this.bME.aJw().getYuleData() != null && this.bME.aJw().getYuleData().tI()) {
            TiebaStatic.log("c10852");
            this.bMD.a(this.bME.aJw().getYuleData().tJ());
        } else {
            this.bMD.aad();
        }
    }

    private void dx(boolean z) {
        if (this.bMO != null && this.bME != null && this.bMD != null && z) {
            if (!this.bMO.acW() && this.bMO.acL() == 1) {
                if (this.bMD.aae().l(com.baidu.tieba.tbadkCore.af.fuW)) {
                    this.bME.bhf();
                }
                if (!this.bMO.acU()) {
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.bME.bhk();
                        this.bME.bhh();
                    }
                    this.bME.bhi();
                    this.bME.bhj();
                }
                boolean z2 = false;
                if (this.bMD.aae().l(com.baidu.tieba.card.data.r.bvx)) {
                    z2 = this.bME.bhm();
                }
                if (!z2) {
                    this.bME.bhl();
                }
                if (TbadkCoreApplication.m9getInst().isRecAppExist()) {
                    this.bME.g(this);
                }
                if (!this.bMD.aae().l(com.baidu.tbadk.core.data.bi.Yd)) {
                    this.bME.bhc();
                }
                this.bME.bhn();
                this.bME.bho();
            }
            this.bME.bhd();
            this.bME.bha();
            this.bME.bhe();
        }
    }

    public boolean Zg() {
        if (this.bMT != null && this.bMD != null && !Zh()) {
            this.bMT.b(this.bMD.getListView());
        }
        if (this.bMP != null && this.bMO != null) {
            this.bMP.a(this.bMO.acH(), this.bME);
        }
        boolean z = false;
        if (this.bME != null) {
            z = this.bME.bhr();
        }
        dy(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hL(int i) {
        cl clVar = null;
        Zg();
        Zp();
        try {
            if (this.bME != null) {
                this.bMD.a(null, this.bME);
                this.bMP.iE(1);
                this.bMD.ZY();
                this.bMT.a(this.bMD.getListView(), this.bME, this.bMO.acR());
                com.baidu.tieba.frs.tab.i a2 = a(this.bMT.abz(), this.bME.bgH());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    clVar = new cl();
                    clVar.bQg = a2.url;
                    clVar.stType = a2.name;
                }
                this.bMO.a(this.bME.bgH(), 0, clVar);
                this.bMT.dY(false);
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
            if (iVar != null && iVar.bZn == i) {
                return iVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z, boolean z2) {
        try {
            if (this.bME != null && this.bMT != null && this.bMO != null) {
                if (!this.bMD.aae().l(com.baidu.tbadk.core.data.bi.Yd)) {
                    this.bME.bhc();
                }
                if (this.bME.aJw() != null) {
                    this.bMu = this.bME.aJw().getName();
                    this.forumId = this.bME.aJw().getId();
                }
                if (this.bME.bhr()) {
                    this.bMT.a(this.bMD.getListView(), this.bME, this.bMO.acR());
                }
                if (z) {
                    dx(true);
                } else {
                    dx(this.bMN);
                }
                Zg();
                if (this.bNa != null) {
                    this.bNa.a(this.bMP, this.bME);
                }
                if (this.bME.rr() != null) {
                    setHasMore(this.bME.rr().rn());
                }
                ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bNf.a(z2, true, this.bME.getThreadList(), null);
                if (a2 != null) {
                    this.bME.ax(a2);
                }
                if (this.bMO.acL() == 1) {
                    Zk();
                }
                this.bMx = this.bME.acN();
                if (this.bMz != null) {
                    this.bMy = true;
                    this.bMz.rO(this.bMx);
                    com.baidu.tieba.frs.f.a.a(getPageContext(), this.bME.aJw(), this.bME.getThreadList(), this.bMy, getPn());
                }
                if (this.bNc != null) {
                    this.bNc.cf(this.bMO.acW());
                    this.bNc.aj(this.bMT.abA());
                }
                Zd();
                if (this.bME.aJw() != null) {
                    this.bMQ.dQ(this.bME.aJw().isLike() == 1);
                }
                if (this.bMD.ZO() != null && this.mIsLogin) {
                    this.bMD.ZO().setVisibility(0);
                }
                if (this.bMR != null && this.mIsLogin) {
                    this.bMR.dZ(true);
                }
                if (this.bMR != null && !this.bMR.abK()) {
                    this.bMD.dD(this.bMO.acM());
                }
                if (this.bME.aJw().isIs_forbidden() == 1) {
                    this.bMQ.dR(false);
                } else {
                    this.bMQ.dR(true);
                }
                this.bMQ.em(this.bME.bgl() == 1);
                this.bMD.n(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.l lVar) {
        try {
            if (!this.bMJ && lVar != null && this.bME != null) {
                this.bME.d(lVar);
                m(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void dy(boolean z) {
        if (this.bMO != null) {
            f(z, this.bMO.acH());
        } else {
            f(z, "normal_page");
        }
    }

    private void f(boolean z, String str) {
        if (!Zh()) {
            dz("frs_page".equals(str));
        }
        if (this.bNa != null) {
            this.bNa.a(z, this.bMT, this.bMP, this.bMD, this.bME);
        }
    }

    @Override // com.baidu.tieba.frs.mc.y
    public boolean Zh() {
        return this.bNd != null && this.bNd.Zh();
    }

    public void dz(boolean z) {
        if (this.bNg != null) {
            this.bNg.a(this.bMD, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        this.bEG = System.currentTimeMillis();
        if (intent != null) {
            this.bMA = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.bEG = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            H(intent);
        }
        this.Wi = System.currentTimeMillis();
        this.aGw = this.Wi - this.bEG;
        super.onCreate(bundle);
        this.bMz = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.fvo);
        this.bMO = new FrsModelController(this, this.bNu);
        this.bMO.a(this.bNm);
        this.bMO.init();
        if (getIntent() != null) {
            this.bMO.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.bMO.f(bundle);
        } else {
            this.bMO.f(null);
        }
        this.bMp = new com.baidu.tieba.frs.entelechy.i();
        this.bNa = this.bMp.aaZ();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(w.j.frs_activity, (ViewGroup) null);
        this.bMR = new com.baidu.tieba.frs.g.ad(this, this.bMp.aaY());
        this.bMQ = new com.baidu.tieba.frs.g.ao(this);
        this.bMR.a(getPageContext().getPageActivity(), inflate, this.bMQ.aee());
        this.bMP = new com.baidu.tieba.frs.g.u(this, this.bMp);
        this.bMT = this.bMp.C(this);
        this.bMD = new az(this, this.bNB, this.bMp);
        this.bMP.a(this.bMD.Lc());
        this.bNd = new com.baidu.tieba.frs.g.as(this, this.bMD, this.bMT, this.bMP);
        this.bMT.ah(this.bMD.aaf());
        if (getIntent() != null) {
            this.bMP.h(getIntent().getExtras());
        } else if (bundle != null) {
            this.bMP.h(bundle);
        } else {
            this.bMP.h((Bundle) null);
        }
        this.bMC = getVoiceManager();
        this.bMC.onCreate(getPageContext());
        this.bNi = new ay(getPageContext(), this);
        initUI();
        initData(bundle);
        this.bMY = new cg(getActivity(), this.bMD, this.bMP);
        this.bMY.a(this.bND);
        this.bMY.dN(true);
        new com.baidu.tieba.frs.mc.v();
        this.bNf = new com.baidu.tieba.frs.mc.h(this, this.bNx);
        this.bMW = new com.baidu.tieba.frs.smartsort.c(this);
        this.bNg = new com.baidu.tieba.frs.g.ah(this);
        addGlobalLayoutListener();
        this.createTime = System.currentTimeMillis() - this.Wi;
        this.bNc = new com.baidu.tieba.frs.g.a(getPageContext(), this.bMO.acT());
        this.bMX = new com.baidu.tieba.frs.mc.d(this);
        this.bNe = new com.baidu.tieba.frs.mc.l(this);
        this.bMU = new com.baidu.tieba.frs.mc.s(this);
        this.bMV = new com.baidu.tieba.frs.mc.b(this);
        this.bNh = new com.baidu.tieba.frs.mc.a(this);
        this.bNj = new com.baidu.tieba.frs.g.f(this);
        this.bNk = new com.baidu.tieba.frs.mc.p(getPageContext(), this);
        registerListener(this.mMemListener);
        registerListener(this.bNs);
        registerListener(this.bNt);
        registerListener(this.bNy);
        registerListener(this.bNr);
        registerListener(this.bNv);
        registerListener(this.bNo);
        registerListener(this.bNp);
        registerListener(this.bNq);
        registerListener(this.bNA);
        registerListener(this.bNl);
        registerListener(this.bNw);
        showLoadingView(this.bMD.aaf(), true);
        this.bMD.dG(false);
        this.bMO.p(3, true);
    }

    private void H(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.f.q.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
                finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.bMu = data.getQueryParameter("name");
            this.ahM = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.bMu)) {
                intent.putExtra("name", this.bMu);
            }
            if (!StringUtils.isNull(this.ahM)) {
                intent.putExtra("from", this.ahM);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.bMu)) {
            this.bMu = com.baidu.tieba.frs.f.t.I(intent);
            if (!StringUtils.isNull(this.bMu)) {
                intent.putExtra("name", this.bMu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.bMC = getVoiceManager();
        this.bMC.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bNF);
        if (bundle != null) {
            this.bMu = bundle.getString("name");
            this.ahM = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bMu = intent.getStringExtra("name");
                this.ahM = intent.getStringExtra("from");
                this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.ahM) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.ahM)) {
            setSwipeBackEnabled(false);
        }
        this.bMF = new bq(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            Zi();
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.bNF);
        }
        this.bMP.h(bundle);
    }

    public void Zi() {
        if (this.bMF != null && this.bMD != null) {
            if (FrsActivityStatic.bNP || FrsActivityStatic.bNQ) {
                this.bMF.aR(com.baidu.tbadk.coreExtra.messageCenter.a.zj().getMsgReplyme());
                this.bMF.aQ(com.baidu.tbadk.coreExtra.messageCenter.a.zj().getMsgAtme());
                this.bMF.aT(com.baidu.tbadk.coreExtra.messageCenter.a.zj().zq());
                this.bMF.aS(com.baidu.tbadk.coreExtra.messageCenter.a.zj().getMsgChat());
                this.bMD.a(this.bMF);
                this.bMQ.a(this.bMF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.card.cc.ST().cP(false);
        if (this.bME != null && this.bME.aJw() != null) {
            ca.aaD().aV(com.baidu.adp.lib.g.b.c(this.bME.aJw().getId(), 0L));
        }
        if (this.bMD != null) {
            com.baidu.tieba.frs.f.s.a(this.bMD, this.bME, getForumId(), false, null);
            this.bMD.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.bML != null) {
                this.bML.onDestroy();
            }
            this.bMD.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.bMO.onActivityDestroy();
        this.bMP.onActivityDestroy();
        this.bMC = getVoiceManager();
        this.bMC.onDestory(getPageContext());
        if (this.bMM != null) {
            this.bMM.cancel(true);
            this.bMM = null;
        }
        if (this.bMO != null) {
            this.bMO.Np();
        }
        if (this.bMQ != null) {
            this.bMQ.destroy();
        }
        if (this.bMY != null) {
            this.bMY.Xg();
        }
        if (this.bNb != null) {
            this.bNb.destory();
        }
        if (this.bNc != null) {
            this.bNc.destory();
        }
        if (this.bNd != null) {
            this.bNd.onDestroy();
        }
        if (this.bMW != null) {
            this.bMW.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bau().baw();
        com.baidu.tieba.frs.f.u.adv();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.bMu);
        bundle.putString("from", this.ahM);
        this.bMO.onSaveInstanceState(bundle);
        this.bMC = getVoiceManager();
        if (this.bMC != null) {
            this.bMC.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.bNh != null) {
            this.bNh.onActivityResult(i, i2, intent);
        }
    }

    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bNb == null) {
                this.bNb = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.bNb.ao(updateAttentionMessage.getData().toUid, getForumId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bMD != null) {
            this.bMD.ZV();
            this.bMD.onResume();
            com.baidu.tieba.frs.f.t.l(this.bMD);
        }
        this.bMT.a(this.bNn);
        this.bMU.eh(true);
        this.bMN = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.bMD.startPullRefresh();
        } else if (bMr) {
            bMr = false;
            this.bMD.startPullRefresh();
        } else {
            this.bMC = getVoiceManager();
            this.bMC.onResume(getPageContext());
            this.bMD.dJ(false);
            registerListener(this.bNz);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.bMD.dH(z);
        this.bMR.dZ(z);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.bMu = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.ahM = intent.getStringExtra("from");
            }
            this.bMw = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.bMw) {
                dA(intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false));
            }
        }
    }

    private void dA(boolean z) {
        this.bMD.startPullRefresh();
        this.bMR.eb(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        com.baidu.tieba.frs.f.t.a(this, getIntent(), this.ahM);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.bMD.setTitle(this.bMu);
        } else {
            this.bMD.setTitle("");
            this.mFlag = 1;
        }
        this.bMP.d(this.bMD.getListView());
        this.bMD.setOnAdapterItemClickListener(this.bNG);
        this.bMD.setOnAdapterItemLongClickListener(this.bNH);
        this.bMD.setOnScrollListener(this.bNC);
        this.bMD.h(this.bLW);
        this.bMD.aae().a(this.bNE);
        if (!this.mIsLogin) {
            this.bMD.dH(false);
            this.bMR.dZ(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bMD.onChangeSkinType(i);
        this.bMQ.b(getPageContext(), i);
        this.bMP.b(getPageContext(), i);
        this.bMT.onChangeSkinType(i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.adp.widget.f.c
    public void lT() {
        setSwipeBackEnabled(true);
        this.bMR.dZ(true);
    }

    @Override // com.baidu.adp.widget.f.c
    public void lU() {
        setSwipeBackEnabled(false);
        this.bMR.dZ(false);
    }

    public void hM(int i) {
        if (!this.mIsLogin) {
            if (this.bME != null && this.bME.rb() != null) {
                this.bME.rb().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.bME != null) {
            if (i == 0) {
                if (!this.bMs) {
                    com.baidu.tieba.frs.f.u.b(this, 0);
                    return;
                }
                TiebaStatic.log("c10152");
                com.baidu.tieba.frs.f.u.b(this, 4);
                return;
            }
            this.bMD.ZX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(com.baidu.tbadk.core.data.bi biVar) {
        boolean z = biVar == null || biVar.te();
        this.bMD.a(new y(this, biVar));
        this.bMD.b(biVar, z);
    }

    public void refresh() {
        cj(3);
    }

    public void cj(int i) {
        this.bMJ = false;
        Zp();
        if (this.bMD.Lc() != null) {
            this.bMD.Lc().alF();
        }
        this.bMO.p(i, true);
    }

    private void Zj() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.k.fS().f(new z(this));
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zk() {
        Zp();
        try {
            if (this.bME != null) {
                this.bMD.KZ();
                if (this.bMR != null && !this.bMR.abK()) {
                    this.bMD.dD(this.bMO.acM());
                }
                if (!Zh() && com.baidu.tieba.frs.g.u.l(this.bME) && !com.baidu.tieba.frs.g.u.k(this.bME)) {
                    this.bMD.aak();
                }
                if (this.bME.aJw() != null) {
                    this.bMu = this.bME.aJw().getName();
                    this.forumId = this.bME.aJw().getId();
                }
                if (this.bME.rr() != null) {
                    setHasMore(this.bME.rr().rn());
                }
                this.bMD.setTitle(this.bMu);
                this.bMD.setForumName(this.bMu);
                TbadkCoreApplication.m9getInst().setDefaultBubble(this.bME.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(this.bME.getUserData().getBimg_end_time());
                Zj();
                Zl();
                ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bME.getThreadList();
                if (threadList != null) {
                    this.bMD.a(threadList, this.bME);
                    com.baidu.tieba.frs.f.e.k(this.bMD);
                    this.bMP.iE(getPageNum());
                    this.bMP.h(this.bME);
                    this.bMT.a(this.bMD.getListView(), this.bME, this.bMO.acR());
                    this.bMD.ZY();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void Zl() {
        if (this.bME != null) {
            if (this.bME.aJI() == 1) {
                this.bMD.aae().setFromCDN(true);
            } else {
                this.bMD.aae().setFromCDN(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bMU.eh(false);
        this.bMN = false;
        this.bMD.onPause();
        this.bMC = getVoiceManager();
        this.bMC.onPause(getPageContext());
        this.bMD.dJ(true);
        if (this.bNc != null) {
            this.bNc.ady();
        }
        MessageManager.getInstance().unRegisterListener(this.bNz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.cc.ST().cP(false);
        if (this.bME != null && this.bME.aJw() != null) {
            com.baidu.tbadk.distribute.a.CX().a(getPageContext().getPageActivity(), "frs", this.bME.aJw().getId(), 0L);
        }
        this.bMC = getVoiceManager();
        if (this.bMC != null) {
            this.bMC.onStop(getPageContext());
        }
        com.baidu.tieba.frs.f.t.d(getListView());
        this.bMP.onActivityStop();
        com.baidu.tbadk.util.r.Ht();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.bMv) {
            if (i == 4) {
                if (this.bMR.abK()) {
                    this.bMR.ea(true);
                    if (this.bMQ.aef().aaL()) {
                        this.bMQ.aef().dS(false);
                        refresh();
                        return true;
                    }
                    return true;
                } else if (Zh()) {
                    this.bNd.aeo();
                    return true;
                } else if (this.bMD.ZU()) {
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

    public boolean Zm() {
        if (this.bMS == null) {
            return false;
        }
        return this.bMS.isShowing();
    }

    public void Zn() {
        this.bMM = com.baidu.tieba.frs.f.q.b(this, this.bMu);
    }

    @Override // com.baidu.tieba.recapp.s
    public BaseActivity<?> getContext() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.s
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.CX().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.s
    public void Zo() {
        YT().Zo();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bMC == null) {
            this.bMC = VoiceManager.instance();
        }
        return this.bMC;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.bMD == null) {
            return null;
        }
        return this.bMD.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void Zp() {
        this.bMC = getVoiceManager();
        this.bMC.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xt() {
        if (this.amf == null) {
            this.amf = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.amf;
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
            if (this.bMF != null) {
                this.bMF.aR(msgReplyme);
                this.bMF.aQ(msgAtme);
                this.bMF.aU(msgOfficialMerge);
                this.bMF.aS(msgChat);
                this.bMF.aT(msgStrangerChat);
                this.bMD.a(this.bMF);
                this.bMQ.a(this.bMF);
            }
        }
    }

    public void Zq() {
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

        /* JADX DEBUG: Multi-variable search result rejected for r4v8, resolved type: com.baidu.tieba.frs.FrsActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
            boolean z;
            String str;
            if (bdUniqueId != null) {
                if (bdUniqueId == bl.bPs) {
                    if (FrsActivity.this.bMD != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11752").aa("fid", FrsActivity.this.forumId).aa("obj_locate", "1"));
                        FrsActivity.this.bMD.startPullRefresh();
                    }
                } else if (vVar != null && (vVar instanceof com.baidu.tbadk.core.data.bi)) {
                    com.baidu.tbadk.core.data.bi biVar = (com.baidu.tbadk.core.data.bi) vVar;
                    if (biVar.sZ() == null || biVar.sZ().getGroup_id() == 0 || FrsActivity.this.checkUpIsLogin()) {
                        if ((biVar.sS() != 1 && biVar.sS() != 2) || FrsActivity.this.checkUpIsLogin()) {
                            if (biVar.sB() != null) {
                                if (FrsActivity.this.checkUpIsLogin()) {
                                    String postUrl = biVar.sB().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hA()) {
                                        com.baidu.tbadk.browser.f.T(FrsActivity.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (biVar.tk() != null) {
                                com.baidu.tbadk.core.data.n tk = biVar.tk();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsActivity.this.getPageContext().getPageActivity(), tk.getCartoonId(), tk.getChapterId(), 2)));
                            } else if (biVar.getThreadType() == 47 && biVar.sk() == 1 && !com.baidu.tbadk.core.util.au.isEmpty(biVar.sv())) {
                                com.baidu.tbadk.browser.f.S(FrsActivity.this.getPageContext().getPageActivity(), biVar.sv());
                            } else {
                                com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.qo(biVar.getId())) {
                                    readThreadHistory.qn(biVar.getId());
                                }
                                String sv = biVar.sv();
                                if (sv == null || sv.equals("")) {
                                    z = false;
                                } else {
                                    new Thread(new ah(this, sv)).start();
                                    z = true;
                                }
                                String tid = biVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (biVar.sk() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.bb wn = com.baidu.tbadk.core.util.bb.wn();
                                    TbPageContext<?> pageContext = FrsActivity.this.getPageContext();
                                    String[] strArr = new String[3];
                                    strArr[0] = tid;
                                    strArr[1] = "";
                                    wn.c(pageContext, strArr);
                                } else if (biVar.getThreadType() == 33 || (biVar instanceof com.baidu.tbadk.core.data.aw)) {
                                    if (biVar.getThreadType() == 33) {
                                        str = "c10245";
                                    } else {
                                        str = "c10180";
                                    }
                                    if (FrsActivity.this.bMO.acL() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.as(str).aa("fid", FrsActivity.this.forumId));
                                    com.baidu.tieba.frs.f.t.d(FrsActivity.this, biVar);
                                    if (FrsActivity.this.bME != null && FrsActivity.this.bME.aJw() != null) {
                                        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                                        aVar.bYM = FrsActivity.this.bME.ftt == 1;
                                        aVar.bYO = FrsActivity.this.bME.aJw().getId();
                                        aVar.bYN = FrsActivity.this.YT().acR();
                                        com.baidu.tieba.frs.e.b.adp().a(aVar, biVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        biVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == com.baidu.tbadk.core.data.bi.Zj.getId()) {
                                        com.baidu.tieba.frs.f.s.a(biVar.rX());
                                        com.baidu.tieba.frs.f.t.c(FrsActivity.this, biVar);
                                        return;
                                    }
                                    com.baidu.tieba.frs.f.t.a(FrsActivity.this, biVar, i, z);
                                    com.baidu.tieba.frs.f.s.a(FrsActivity.this, FrsActivity.this.bME, biVar);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.k.hA()) {
            hideNetRefreshView(this.bMD.aaf());
            showLoadingView(this.bMD.aaf(), true);
            this.bMD.dG(false);
            this.bMD.startPullRefresh();
        }
    }

    public com.baidu.tieba.tbadkCore.n Zr() {
        return this.bME;
    }

    public boolean Zs() {
        return this.bMD.Zs();
    }

    public void Zt() {
        FrsActivityStatic.bNP = false;
        FrsActivityStatic.bNQ = false;
        Zi();
    }

    public void O(Object obj) {
        if (this.bMX != null && this.bMX.bXI != null) {
            this.bMX.bXI.g(obj);
        }
    }

    public void P(Object obj) {
        if (this.bMX != null && this.bMX.bXJ != null) {
            this.bMX.bXJ.g(obj);
        }
    }

    public void Zu() {
        this.bMP.Zu();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void ln() {
        if (!com.baidu.adp.lib.util.k.hA()) {
            this.bMD.Ug();
        } else if (this.bMO.acL() == 1) {
            Kw();
            Zv();
        } else if (this.bMO.hasMore()) {
            Zv();
        }
    }

    public void iJ(String str) {
        Kw();
        showToast(str);
    }

    public void E(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        Kw();
        if (!com.baidu.tbadk.core.util.x.q(arrayList)) {
            if (!this.bMO.acW() && TbadkCoreApplication.m9getInst().isRecAppExist() && this.bMO.acL() == 1) {
                this.bME.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bNf.a(false, false, arrayList, this.bMz);
            if (a2 != null) {
                this.bME.ax(a2);
                this.bMD.a(a2, this.bME);
            }
            if (this.bMO != null) {
                com.baidu.tieba.frs.e.b.a(this.bME, this.bMO.acR(), 2);
            }
        }
    }

    private void Kw() {
        if (Zb() == 1 || this.bNf.at(this.bME.bgs())) {
            this.bMD.aai();
        } else if (com.baidu.tbadk.core.util.x.q(this.bME.getThreadList())) {
            this.bMD.Ug();
        } else {
            this.bMD.KA();
        }
    }

    @Override // com.baidu.tieba.frs.mc.y
    public void Zv() {
        if (this.bNf != null) {
            this.bNf.a(this.bMu, this.forumId, this.bME);
        }
    }

    public boolean Zw() {
        return this.bMQ.aef().aaL();
    }

    public void dB(boolean z) {
        this.bMQ.aef().dS(z);
    }

    public void PL() {
        if (!com.baidu.tbadk.core.util.ae.d(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ap.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a006";
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.f.t.a(this, i, strArr, iArr);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    public void Zx() {
        if (this.bNc != null) {
            this.bNc.ady();
        }
    }

    public void dC(boolean z) {
        if (this.bNd != null) {
            this.bNd.dC(z);
        }
        if (this.bMY != null) {
            this.bMY.dN(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.bMZ.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fD(int i) {
        return this.bMZ.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.bNi.b(bVar);
    }
}
