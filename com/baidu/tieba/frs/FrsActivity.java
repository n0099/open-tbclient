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
    private com.baidu.tieba.frs.entelechy.b.a bOG;
    private boolean bOJ;
    public com.baidu.tbadk.core.data.bi bOK;
    private com.baidu.tieba.tbadkCore.data.e bOQ;
    private VoiceManager bOT;
    private bq bOW;
    public com.baidu.tieba.frs.g.f bPA;
    private com.baidu.tieba.frs.mc.p bPB;
    private q.a bPd;
    private FrsModelController bPf;
    private com.baidu.tieba.frs.g.u bPg;
    private com.baidu.tieba.frs.g.ao bPh;
    private com.baidu.tieba.frs.g.ad bPi;
    private com.baidu.tieba.frs.view.q bPj;
    private com.baidu.tieba.frs.entelechy.b.d bPk;
    private com.baidu.tieba.frs.mc.s bPl;
    private com.baidu.tieba.frs.mc.b bPm;
    private com.baidu.tieba.frs.smartsort.c bPn;
    private com.baidu.tieba.frs.mc.d bPo;
    private cg bPp;
    private com.baidu.tieba.frs.entelechy.b.b bPr;
    private com.baidu.tbadk.h.a bPs;
    private com.baidu.tieba.frs.g.a bPt;
    private com.baidu.tieba.frs.g.as bPu;
    private com.baidu.tieba.frs.mc.l bPv;
    private com.baidu.tieba.frs.mc.h bPw;
    private com.baidu.tieba.frs.g.ah bPx;
    private com.baidu.tieba.frs.mc.a bPy;
    private ay bPz;
    private static boolean isNeedRefreshOnResume = false;
    public static boolean bOI = false;
    public static volatile long bOX = 0;
    public static volatile long bOY = 0;
    public static volatile int bOZ = 0;
    public boolean bOH = false;
    public String bOL = null;
    public String ahN = null;
    public int mFlag = 0;
    private boolean bOM = false;
    private boolean bON = false;
    private String mThreadId = null;
    private String forumId = null;
    private int bOO = 0;
    private boolean bOP = false;
    private boolean bOR = false;
    private boolean bOS = false;
    private az bOU = null;
    public final com.baidu.tbadk.core.data.bi aRX = null;
    private com.baidu.tieba.tbadkCore.n bOV = new com.baidu.tieba.tbadkCore.n();
    public long bGX = -1;
    public long aGG = 0;
    public long aGy = 0;
    public long createTime = 0;
    public long Wk = -1;
    private boolean bPa = false;
    private boolean bPb = false;
    public com.baidu.tbadk.j.e bPc = null;
    private boolean bPe = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> bPq = new SparseArray<>();
    private boolean bAq = true;
    private final CustomMessageListener bPC = new d(this, CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED);
    private final ce bPD = new o(this);
    private cd bPE = new aa(this);
    private CustomMessageListener bPF = new ab(this, CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT);
    private CustomMessageListener bPG = new ac(this, CmdConfigCustom.CMD_FRS_TAB_LIVE_START);
    private final CustomMessageListener bPH = new ad(this, CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB);
    private final CustomMessageListener bPI = new ae(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    public final CustomMessageListener bPJ = new af(this, CmdConfigCustom.MSG_NEW);
    private final CustomMessageListener bPK = new ag(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    public final com.baidu.tieba.tbadkCore.p bPL = new e(this);
    private final CustomMessageListener bPM = new f(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private final CustomMessageListener mMemListener = new g(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private CustomMessageListener bPN = new h(this, CmdConfigCustom.CMD_DRIFTING_BOTTLE_CLEAR_MESSAGE);
    private final com.baidu.tieba.frs.mc.x bPO = new i(this);
    public final View.OnTouchListener aOj = new j(this);
    private final CustomMessageListener bPP = new k(this, CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE);
    private final CustomMessageListener bPQ = new l(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);
    private final com.baidu.adp.framework.listener.a bPR = new m(this, CmdConfigHttp.CMD_SET_COMMON_FORUM_STATE, 309365);
    public final View.OnClickListener bPS = new n(this);
    private final AbsListView.OnScrollListener bPT = new p(this);
    private final com.baidu.tbadk.util.e<Boolean> bPU = new q(this);
    private final at bPV = new r(this);
    private final NoNetworkView.a bOn = new t(this);
    private final CustomMessageListener bPW = new u(this, 0);
    private com.baidu.adp.widget.ListView.w bPX = new a(this, null);
    private com.baidu.adp.widget.ListView.x bPY = new v(this);
    private ce bPZ = new w(this);

    public com.baidu.tieba.frs.g.as ZO() {
        return this.bPu;
    }

    public com.baidu.tieba.frs.entelechy.b.b ZP() {
        return this.bPr;
    }

    public com.baidu.adp.widget.ListView.w ZQ() {
        return this.bPX;
    }

    public com.baidu.adp.widget.ListView.x ZR() {
        return this.bPY;
    }

    public com.baidu.tieba.frs.mc.l ZS() {
        return this.bPv;
    }

    public com.baidu.tieba.frs.smartsort.c ZT() {
        return this.bPn;
    }

    @Override // com.baidu.tieba.frs.mc.y
    public FrsModelController ZU() {
        return this.bPf;
    }

    public com.baidu.tieba.frs.g.ad ZV() {
        return this.bPi;
    }

    public com.baidu.tieba.frs.g.ao ZW() {
        return this.bPh;
    }

    @Override // com.baidu.tieba.frs.mc.y
    public com.baidu.tieba.frs.mc.h ZX() {
        return this.bPw;
    }

    @Override // com.baidu.tieba.frs.mc.y
    public com.baidu.tieba.frs.g.u ZY() {
        return this.bPg;
    }

    public com.baidu.tieba.frs.entelechy.b.d ZZ() {
        return this.bPk;
    }

    public cg aaa() {
        return this.bPp;
    }

    @Override // com.baidu.tieba.frs.mc.y
    public az aab() {
        return this.bOU;
    }

    @Override // com.baidu.tieba.frs.cf
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.cf
    public String getForumName() {
        return this.bOL;
    }

    public void setForumName(String str) {
        this.bOL = str;
    }

    public void setFrom(String str) {
        this.ahN = str;
    }

    public String getFrom() {
        return this.ahN;
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
        return c.ZN().b(this, bdUniqueId);
    }

    @Override // com.baidu.tieba.recapp.s
    public int getPageNum() {
        if (this.bPw == null) {
            return 1;
        }
        return this.bPw.getPn();
    }

    public int getPn() {
        if (this.bPw == null) {
            return 1;
        }
        return this.bPw.getPn();
    }

    public void setPn(int i) {
        if (this.bPw != null) {
            this.bPw.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.bPw != null) {
            this.bPw.setHasMore(i);
        }
    }

    public int aac() {
        if (this.bPw == null) {
            return -1;
        }
        return this.bPw.aac();
    }

    public boolean aad() {
        return this.bOS;
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
        if (this.bOU.aaP() != null && !z) {
            this.bOU.aaP().setVisibility(8);
        }
        if (this.bOU.aaS() != null && !z) {
            this.bOU.aaS().setVisibility(8);
        }
        if (this.bPi != null) {
            this.bPi.ej(false);
        }
        if (aVar == null) {
            showNetRefreshView(this.bOU.abg(), getPageContext().getString(w.l.error_unkown_try_again), true);
        } else if (aVar.fvj) {
            if (340001 == aVar.errorCode) {
                showNetRefreshViewNoClick(this.bOU.abg(), getPageContext().getResources().getString(w.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
            } else {
                showNetRefreshView(this.bOU.abg(), getPageContext().getResources().getString(w.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
            }
        } else if (340001 == aVar.errorCode) {
            showNetRefreshViewNoClick(this.bOU.abg(), aVar.errorMsg, true);
        } else {
            showNetRefreshView(this.bOU.abg(), aVar.errorMsg, true);
        }
        setNetRefreshViewEmotionDefMarginTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aae() {
        hideLoadingView(this.bOU.abg());
        this.bOU.cg(false);
        this.bOU.abb();
        if (this.bOU.aaL() instanceof com.baidu.tieba.frs.tab.h) {
            ((com.baidu.tieba.frs.tab.h) this.bOU.aaL()).aet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaf() {
        if (aac() == 0 && com.baidu.tbadk.core.util.x.q(this.bOV.bhu())) {
            if (com.baidu.tbadk.core.util.x.q(this.bOV.getThreadList())) {
                this.bOU.Vh();
                return;
            } else {
                this.bOU.KA();
                return;
            }
        }
        this.bOU.abj();
    }

    public void a(ErrorData errorData) {
        boolean z = true;
        aae();
        this.bOU.aaW();
        d.a adJ = this.bPf.adJ();
        boolean q = com.baidu.tbadk.core.util.x.q(this.bOV.getThreadList());
        if (adJ != null && q) {
            if (q) {
                if (this.bPf.adK() != 0) {
                    this.bPf.adQ();
                    this.bOU.aaW();
                } else {
                    a(adJ, false);
                }
                az azVar = this.bOU;
                if (!this.bOV.bir() && !aai()) {
                    z = false;
                }
                azVar.n(z, false);
                return;
            } else if (adJ.fvj) {
                this.bOU.n(true, false);
                showToast(getPageContext().getResources().getString(w.l.net_error_text, adJ.errorMsg, Integer.valueOf(adJ.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(adJ, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aag() {
        if (this.bOV == null || this.bOV.aKx() != null) {
            this.bOU.abe();
        } else if (this.bOV.aKx().getYuleData() != null && this.bOV.aKx().getYuleData().tI()) {
            TiebaStatic.log("c10852");
            this.bOU.a(this.bOV.aKx().getYuleData().tJ());
        } else {
            this.bOU.abe();
        }
    }

    private void dH(boolean z) {
        if (this.bPf != null && this.bOV != null && this.bOU != null && z) {
            if (!this.bPf.adX() && this.bPf.adM() == 1) {
                if (this.bOU.abf().l(com.baidu.tieba.tbadkCore.af.fxn)) {
                    this.bOV.big();
                }
                if (!this.bPf.adV()) {
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.bOV.bil();
                        this.bOV.bii();
                    }
                    this.bOV.bij();
                    this.bOV.bik();
                }
                boolean z2 = false;
                if (this.bOU.abf().l(com.baidu.tieba.card.data.r.bxO)) {
                    z2 = this.bOV.bin();
                }
                if (!z2) {
                    this.bOV.bim();
                }
                if (TbadkCoreApplication.m9getInst().isRecAppExist()) {
                    this.bOV.g(this);
                }
                if (!this.bOU.abf().l(com.baidu.tbadk.core.data.bi.Ye)) {
                    this.bOV.bid();
                }
                this.bOV.bio();
                this.bOV.bip();
            }
            this.bOV.bie();
            this.bOV.bib();
            this.bOV.bif();
        }
    }

    public boolean aah() {
        if (this.bPk != null && this.bOU != null && !aai()) {
            this.bPk.b(this.bOU.getListView());
        }
        if (this.bPg != null && this.bPf != null) {
            this.bPg.a(this.bPf.adI(), this.bOV);
        }
        boolean z = false;
        if (this.bOV != null) {
            z = this.bOV.bis();
        }
        dI(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hR(int i) {
        cl clVar = null;
        aah();
        aaq();
        try {
            if (this.bOV != null) {
                this.bOU.a(null, this.bOV);
                this.bPg.iK(1);
                this.bOU.aaZ();
                this.bPk.a(this.bOU.getListView(), this.bOV, this.bPf.adS());
                com.baidu.tieba.frs.tab.i a2 = a(this.bPk.acA(), this.bOV.bhJ());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    clVar = new cl();
                    clVar.bSx = a2.url;
                    clVar.stType = a2.name;
                }
                this.bPf.a(this.bOV.bhJ(), 0, clVar);
                this.bPk.ei(false);
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
            if (iVar != null && iVar.cbE == i) {
                return iVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z, boolean z2) {
        try {
            if (this.bOV != null && this.bPk != null && this.bPf != null) {
                if (!this.bOU.abf().l(com.baidu.tbadk.core.data.bi.Ye)) {
                    this.bOV.bid();
                }
                if (this.bOV.aKx() != null) {
                    this.bOL = this.bOV.aKx().getName();
                    this.forumId = this.bOV.aKx().getId();
                }
                if (this.bOV.bis()) {
                    this.bPk.a(this.bOU.getListView(), this.bOV, this.bPf.adS());
                }
                if (z) {
                    dH(true);
                } else {
                    dH(this.bPe);
                }
                aah();
                if (this.bPr != null) {
                    this.bPr.a(this.bPg, this.bOV);
                }
                if (this.bOV.rr() != null) {
                    setHasMore(this.bOV.rr().rn());
                }
                ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bPw.a(z2, true, this.bOV.getThreadList(), null);
                if (a2 != null) {
                    this.bOV.ax(a2);
                }
                if (this.bPf.adM() == 1) {
                    aal();
                }
                this.bOO = this.bOV.adO();
                if (this.bOQ != null) {
                    this.bOP = true;
                    this.bOQ.rU(this.bOO);
                    com.baidu.tieba.frs.f.a.a(getPageContext(), this.bOV.aKx(), this.bOV.getThreadList(), this.bOP, getPn());
                }
                if (this.bPt != null) {
                    this.bPt.cf(this.bPf.adX());
                    this.bPt.aj(this.bPk.acB());
                }
                aae();
                if (this.bOV.aKx() != null) {
                    this.bPh.ea(this.bOV.aKx().isLike() == 1);
                }
                if (this.bOU.aaP() != null && this.mIsLogin) {
                    this.bOU.aaP().setVisibility(0);
                }
                if (this.bPi != null && this.mIsLogin) {
                    this.bPi.ej(true);
                }
                if (this.bPi != null && !this.bPi.acL()) {
                    this.bOU.dN(this.bPf.adN());
                }
                if (this.bOV.aKx().isIs_forbidden() == 1) {
                    this.bPh.eb(false);
                } else {
                    this.bPh.eb(true);
                }
                this.bPh.ew(this.bOV.bhn() == 1);
                this.bOU.n(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.l lVar) {
        try {
            if (!this.bPa && lVar != null && this.bOV != null) {
                this.bOV.d(lVar);
                m(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void dI(boolean z) {
        if (this.bPf != null) {
            f(z, this.bPf.adI());
        } else {
            f(z, "normal_page");
        }
    }

    private void f(boolean z, String str) {
        if (!aai()) {
            dJ("frs_page".equals(str));
        }
        if (this.bPr != null) {
            this.bPr.a(z, this.bPk, this.bPg, this.bOU, this.bOV);
        }
    }

    @Override // com.baidu.tieba.frs.mc.y
    public boolean aai() {
        return this.bPu != null && this.bPu.aai();
    }

    public void dJ(boolean z) {
        if (this.bPx != null) {
            this.bPx.a(this.bOU, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        this.bGX = System.currentTimeMillis();
        if (intent != null) {
            this.bOR = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.bGX = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            I(intent);
        }
        this.Wk = System.currentTimeMillis();
        this.aGy = this.Wk - this.bGX;
        super.onCreate(bundle);
        this.bOQ = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.fxF);
        this.bPf = new FrsModelController(this, this.bPL);
        this.bPf.a(this.bPD);
        this.bPf.init();
        if (getIntent() != null) {
            this.bPf.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.bPf.f(bundle);
        } else {
            this.bPf.f(null);
        }
        this.bOG = new com.baidu.tieba.frs.entelechy.i();
        this.bPr = this.bOG.aca();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(w.j.frs_activity, (ViewGroup) null);
        this.bPi = new com.baidu.tieba.frs.g.ad(this, this.bOG.abZ());
        this.bPh = new com.baidu.tieba.frs.g.ao(this);
        this.bPi.a(getPageContext().getPageActivity(), inflate, this.bPh.aff());
        this.bPg = new com.baidu.tieba.frs.g.u(this, this.bOG);
        this.bPk = this.bOG.C(this);
        this.bOU = new az(this, this.bPS, this.bOG);
        this.bPu = new com.baidu.tieba.frs.g.as(this, this.bOU, this.bPk, this.bPg);
        this.bPk.ah(this.bOU.abg());
        if (getIntent() != null) {
            this.bPg.h(getIntent().getExtras());
        } else if (bundle != null) {
            this.bPg.h(bundle);
        } else {
            this.bPg.h((Bundle) null);
        }
        this.bOT = getVoiceManager();
        this.bOT.onCreate(getPageContext());
        this.bPz = new ay(getPageContext(), this);
        initUI();
        initData(bundle);
        this.bPp = new cg(getActivity(), this.bOU, this.bPg);
        this.bPp.a(this.bPU);
        this.bPp.dX(true);
        new com.baidu.tieba.frs.mc.v();
        this.bPw = new com.baidu.tieba.frs.mc.h(this, this.bPO);
        this.bPn = new com.baidu.tieba.frs.smartsort.c(this);
        this.bPx = new com.baidu.tieba.frs.g.ah(this);
        addGlobalLayoutListener();
        this.createTime = System.currentTimeMillis() - this.Wk;
        this.bPt = new com.baidu.tieba.frs.g.a(getPageContext(), this.bPf.adU());
        this.bPo = new com.baidu.tieba.frs.mc.d(this);
        this.bPv = new com.baidu.tieba.frs.mc.l(this);
        this.bPl = new com.baidu.tieba.frs.mc.s(this);
        this.bPm = new com.baidu.tieba.frs.mc.b(this);
        this.bPy = new com.baidu.tieba.frs.mc.a(this);
        this.bPA = new com.baidu.tieba.frs.g.f(this);
        this.bPB = new com.baidu.tieba.frs.mc.p(getPageContext(), this);
        registerListener(this.mMemListener);
        registerListener(this.bPJ);
        registerListener(this.bPK);
        registerListener(this.bPP);
        registerListener(this.bPI);
        registerListener(this.bPM);
        registerListener(this.bPF);
        registerListener(this.bPG);
        registerListener(this.bPH);
        registerListener(this.bPR);
        registerListener(this.bPC);
        registerListener(this.bPN);
        showLoadingView(this.bOU.abg(), true);
        this.bOU.dQ(false);
        this.bPf.p(3, true);
    }

    private void I(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.f.q.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
                finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.bOL = data.getQueryParameter("name");
            this.ahN = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.bOL)) {
                intent.putExtra("name", this.bOL);
            }
            if (!StringUtils.isNull(this.ahN)) {
                intent.putExtra("from", this.ahN);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.bOL)) {
            this.bOL = com.baidu.tieba.frs.f.t.J(intent);
            if (!StringUtils.isNull(this.bOL)) {
                intent.putExtra("name", this.bOL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.bOT = getVoiceManager();
        this.bOT.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bPW);
        if (bundle != null) {
            this.bOL = bundle.getString("name");
            this.ahN = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bOL = intent.getStringExtra("name");
                this.ahN = intent.getStringExtra("from");
                this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.ahN) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.ahN)) {
            setSwipeBackEnabled(false);
        }
        this.bOW = new bq(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            aaj();
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.bPW);
        }
        this.bPg.h(bundle);
    }

    public void aaj() {
        if (this.bOW != null && this.bOU != null) {
            if (FrsActivityStatic.bQg || FrsActivityStatic.bQh) {
                this.bOW.aR(com.baidu.tbadk.coreExtra.messageCenter.a.zj().getMsgReplyme());
                this.bOW.aQ(com.baidu.tbadk.coreExtra.messageCenter.a.zj().getMsgAtme());
                this.bOW.aT(com.baidu.tbadk.coreExtra.messageCenter.a.zj().zq());
                this.bOW.aS(com.baidu.tbadk.coreExtra.messageCenter.a.zj().getMsgChat());
                this.bOU.a(this.bOW);
                this.bPh.a(this.bOW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.card.cc.TV().cZ(false);
        if (this.bOV != null && this.bOV.aKx() != null) {
            ca.abE().aV(com.baidu.adp.lib.g.b.c(this.bOV.aKx().getId(), 0L));
        }
        if (this.bOU != null) {
            com.baidu.tieba.frs.f.s.a(this.bOU, this.bOV, getForumId(), false, null);
            this.bOU.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.bPc != null) {
                this.bPc.onDestroy();
            }
            this.bOU.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.bPf.onActivityDestroy();
        this.bPg.onActivityDestroy();
        this.bOT = getVoiceManager();
        this.bOT.onDestory(getPageContext());
        if (this.bPd != null) {
            this.bPd.cancel(true);
            this.bPd = null;
        }
        if (this.bPf != null) {
            this.bPf.Nx();
        }
        if (this.bPh != null) {
            this.bPh.destroy();
        }
        if (this.bPp != null) {
            this.bPp.Yh();
        }
        if (this.bPs != null) {
            this.bPs.destory();
        }
        if (this.bPt != null) {
            this.bPt.destory();
        }
        if (this.bPu != null) {
            this.bPu.onDestroy();
        }
        if (this.bPn != null) {
            this.bPn.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.bbv().bbx();
        com.baidu.tieba.frs.f.u.aew();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.bOL);
        bundle.putString("from", this.ahN);
        this.bPf.onSaveInstanceState(bundle);
        this.bOT = getVoiceManager();
        if (this.bOT != null) {
            this.bOT.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.bPy != null) {
            this.bPy.onActivityResult(i, i2, intent);
        }
    }

    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bPs == null) {
                this.bPs = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.bPs.ao(updateAttentionMessage.getData().toUid, getForumId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bOU != null) {
            this.bOU.aaW();
            this.bOU.onResume();
            com.baidu.tieba.frs.f.t.l(this.bOU);
        }
        this.bPk.a(this.bPE);
        this.bPl.er(true);
        this.bPe = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.bOU.startPullRefresh();
        } else if (bOI) {
            bOI = false;
            this.bOU.startPullRefresh();
        } else {
            this.bOT = getVoiceManager();
            this.bOT.onResume(getPageContext());
            this.bOU.dT(false);
            registerListener(this.bPQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.bOU.dR(z);
        this.bPi.ej(z);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.bOL = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.ahN = intent.getStringExtra("from");
            }
            this.bON = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.bON) {
                dK(intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false));
            }
        }
    }

    private void dK(boolean z) {
        this.bOU.startPullRefresh();
        this.bPi.el(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        com.baidu.tieba.frs.f.t.a(this, getIntent(), this.ahN);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.bOU.setTitle(this.bOL);
        } else {
            this.bOU.setTitle("");
            this.mFlag = 1;
        }
        this.bPg.d(this.bOU.getListView());
        this.bOU.setOnAdapterItemClickListener(this.bPX);
        this.bOU.setOnAdapterItemLongClickListener(this.bPY);
        this.bOU.setOnScrollListener(this.bPT);
        this.bOU.h(this.bOn);
        this.bOU.abf().a(this.bPV);
        if (!this.mIsLogin) {
            this.bOU.dR(false);
            this.bPi.ej(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bOU.onChangeSkinType(i);
        this.bPh.b(getPageContext(), i);
        this.bPg.b(getPageContext(), i);
        this.bPk.onChangeSkinType(i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.adp.widget.f.c
    public void lU() {
        setSwipeBackEnabled(true);
        this.bPi.ej(true);
    }

    @Override // com.baidu.adp.widget.f.c
    public void lV() {
        setSwipeBackEnabled(false);
        this.bPi.ej(false);
    }

    public void hS(int i) {
        if (!this.mIsLogin) {
            if (this.bOV != null && this.bOV.rb() != null) {
                this.bOV.rb().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.bOV != null) {
            if (i == 0) {
                if (!this.bOJ) {
                    com.baidu.tieba.frs.f.u.b(this, 0);
                    return;
                }
                TiebaStatic.log("c10152");
                com.baidu.tieba.frs.f.u.b(this, 4);
                return;
            }
            this.bOU.aaY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(com.baidu.tbadk.core.data.bi biVar) {
        boolean z = biVar == null || biVar.te();
        this.bOU.a(new y(this, biVar));
        this.bOU.b(biVar, z);
    }

    public void refresh() {
        cj(3);
    }

    public void cj(int i) {
        this.bPa = false;
        aaq();
        if (this.bOU.Lc() != null) {
            this.bOU.Lc().amG();
        }
        this.bPf.p(i, true);
    }

    private void aak() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.k.fT().f(new z(this));
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aal() {
        aaq();
        try {
            if (this.bOV != null) {
                this.bOU.KZ();
                if (this.bPi != null && !this.bPi.acL()) {
                    this.bOU.dN(this.bPf.adN());
                }
                if (!aai() && com.baidu.tieba.frs.g.u.l(this.bOV) && !com.baidu.tieba.frs.g.u.k(this.bOV)) {
                    this.bOU.abl();
                }
                if (this.bOV.aKx() != null) {
                    this.bOL = this.bOV.aKx().getName();
                    this.forumId = this.bOV.aKx().getId();
                }
                if (this.bOV.rr() != null) {
                    setHasMore(this.bOV.rr().rn());
                }
                this.bOU.setTitle(this.bOL);
                this.bOU.setForumName(this.bOL);
                TbadkCoreApplication.m9getInst().setDefaultBubble(this.bOV.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(this.bOV.getUserData().getBimg_end_time());
                aak();
                aam();
                ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bOV.getThreadList();
                if (threadList != null) {
                    this.bOU.a(threadList, this.bOV);
                    com.baidu.tieba.frs.f.e.k(this.bOU);
                    this.bPg.iK(getPageNum());
                    this.bPg.h(this.bOV);
                    this.bPk.a(this.bOU.getListView(), this.bOV, this.bPf.adS());
                    this.bOU.aaZ();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aam() {
        if (this.bOV != null) {
            if (this.bOV.aKJ() == 1) {
                this.bOU.abf().setFromCDN(true);
            } else {
                this.bOU.abf().setFromCDN(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bPl.er(false);
        this.bPe = false;
        this.bOU.onPause();
        this.bOT = getVoiceManager();
        this.bOT.onPause(getPageContext());
        this.bOU.dT(true);
        if (this.bPt != null) {
            this.bPt.aez();
        }
        MessageManager.getInstance().unRegisterListener(this.bPQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.cc.TV().cZ(false);
        if (this.bOV != null && this.bOV.aKx() != null) {
            com.baidu.tbadk.distribute.a.CX().a(getPageContext().getPageActivity(), "frs", this.bOV.aKx().getId(), 0L);
        }
        this.bOT = getVoiceManager();
        if (this.bOT != null) {
            this.bOT.onStop(getPageContext());
        }
        com.baidu.tieba.frs.f.t.d(getListView());
        this.bPg.onActivityStop();
        com.baidu.tbadk.util.r.Ht();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.bOM) {
            if (i == 4) {
                if (this.bPi.acL()) {
                    this.bPi.ek(true);
                    if (this.bPh.afg().abM()) {
                        this.bPh.afg().ec(false);
                        refresh();
                        return true;
                    }
                    return true;
                } else if (aai()) {
                    this.bPu.afp();
                    return true;
                } else if (this.bOU.aaV()) {
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

    public boolean aan() {
        if (this.bPj == null) {
            return false;
        }
        return this.bPj.isShowing();
    }

    public void aao() {
        this.bPd = com.baidu.tieba.frs.f.q.b(this, this.bOL);
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
    public void aap() {
        ZU().aap();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bOT == null) {
            this.bOT = VoiceManager.instance();
        }
        return this.bOT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.bOU == null) {
            return null;
        }
        return this.bOU.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void aaq() {
        this.bOT = getVoiceManager();
        this.bOT.stopPlay();
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
            if (this.bOW != null) {
                this.bOW.aR(msgReplyme);
                this.bOW.aQ(msgAtme);
                this.bOW.aU(msgOfficialMerge);
                this.bOW.aS(msgChat);
                this.bOW.aT(msgStrangerChat);
                this.bOU.a(this.bOW);
                this.bPh.a(this.bOW);
            }
        }
    }

    public void aar() {
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
                if (bdUniqueId == bl.bRJ) {
                    if (FrsActivity.this.bOU != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11752").aa("fid", FrsActivity.this.forumId).aa("obj_locate", "1"));
                        FrsActivity.this.bOU.startPullRefresh();
                    }
                } else if (vVar != null && (vVar instanceof com.baidu.tbadk.core.data.bi)) {
                    com.baidu.tbadk.core.data.bi biVar = (com.baidu.tbadk.core.data.bi) vVar;
                    if (biVar.sZ() == null || biVar.sZ().getGroup_id() == 0 || FrsActivity.this.checkUpIsLogin()) {
                        if ((biVar.sS() != 1 && biVar.sS() != 2) || FrsActivity.this.checkUpIsLogin()) {
                            if (biVar.sB() != null) {
                                if (FrsActivity.this.checkUpIsLogin()) {
                                    String postUrl = biVar.sB().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hB()) {
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
                                if (readThreadHistory != null && !readThreadHistory.qp(biVar.getId())) {
                                    readThreadHistory.qo(biVar.getId());
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
                                    if (FrsActivity.this.bPf.adM() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.as(str).aa("fid", FrsActivity.this.forumId));
                                    com.baidu.tieba.frs.f.t.d(FrsActivity.this, biVar);
                                    if (FrsActivity.this.bOV != null && FrsActivity.this.bOV.aKx() != null) {
                                        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                                        aVar.cbd = FrsActivity.this.bOV.fvK == 1;
                                        aVar.cbf = FrsActivity.this.bOV.aKx().getId();
                                        aVar.cbe = FrsActivity.this.ZU().adS();
                                        com.baidu.tieba.frs.e.b.aeq().a(aVar, biVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        biVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == com.baidu.tbadk.core.data.bi.Zk.getId()) {
                                        com.baidu.tieba.frs.f.s.a(biVar.rX());
                                        com.baidu.tieba.frs.f.t.c(FrsActivity.this, biVar);
                                        return;
                                    }
                                    com.baidu.tieba.frs.f.t.a(FrsActivity.this, biVar, i, z);
                                    com.baidu.tieba.frs.f.s.a(FrsActivity.this, FrsActivity.this.bOV, biVar);
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
        if (com.baidu.adp.lib.util.k.hB()) {
            hideNetRefreshView(this.bOU.abg());
            showLoadingView(this.bOU.abg(), true);
            this.bOU.dQ(false);
            this.bOU.startPullRefresh();
        }
    }

    public com.baidu.tieba.tbadkCore.n aas() {
        return this.bOV;
    }

    public boolean aat() {
        return this.bOU.aat();
    }

    public void aau() {
        FrsActivityStatic.bQg = false;
        FrsActivityStatic.bQh = false;
        aaj();
    }

    public void N(Object obj) {
        if (this.bPo != null && this.bPo.bZZ != null) {
            this.bPo.bZZ.g(obj);
        }
    }

    public void O(Object obj) {
        if (this.bPo != null && this.bPo.caa != null) {
            this.bPo.caa.g(obj);
        }
    }

    public void aav() {
        this.bPg.aav();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void lo() {
        if (!com.baidu.adp.lib.util.k.hB()) {
            this.bOU.Vh();
        } else if (this.bPf.adM() == 1) {
            Kw();
            aaw();
        } else if (this.bPf.hasMore()) {
            aaw();
        }
    }

    public void iK(String str) {
        Kw();
        showToast(str);
    }

    public void E(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        Kw();
        if (!com.baidu.tbadk.core.util.x.q(arrayList)) {
            if (!this.bPf.adX() && TbadkCoreApplication.m9getInst().isRecAppExist() && this.bPf.adM() == 1) {
                this.bOV.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bPw.a(false, false, arrayList, this.bOQ);
            if (a2 != null) {
                this.bOV.ax(a2);
                this.bOU.a(a2, this.bOV);
            }
            if (this.bPf != null) {
                com.baidu.tieba.frs.e.b.a(this.bOV, this.bPf.adS(), 2);
            }
        }
    }

    private void Kw() {
        if (aac() == 1 || this.bPw.au(this.bOV.bhu())) {
            this.bOU.abj();
        } else if (com.baidu.tbadk.core.util.x.q(this.bOV.getThreadList())) {
            this.bOU.Vh();
        } else {
            this.bOU.KA();
        }
    }

    @Override // com.baidu.tieba.frs.mc.y
    public void aaw() {
        if (this.bPw != null) {
            this.bPw.a(this.bOL, this.forumId, this.bOV);
        }
    }

    public boolean aax() {
        return this.bPh.afg().abM();
    }

    public void dL(boolean z) {
        this.bPh.afg().ec(z);
    }

    public void Qz() {
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

    public void aay() {
        if (this.bPt != null) {
            this.bPt.aez();
        }
    }

    public void dM(boolean z) {
        if (this.bPu != null) {
            this.bPu.dM(z);
        }
        if (this.bPp != null) {
            this.bPp.dX(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.bPq.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fD(int i) {
        return this.bPq.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.bPz.b(bVar);
    }
}
