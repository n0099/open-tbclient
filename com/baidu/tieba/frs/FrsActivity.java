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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
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
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.utils.q;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FrsActivity extends BaseActivity<FrsActivity> implements a.InterfaceC0000a, BdListView.e, f.c, UserIconBox.b, VoiceManager.c, b, cd, com.baidu.tieba.frs.mc.w, com.baidu.tieba.recapp.o {
    private com.baidu.adp.lib.e.b<TbImageView> alR;
    private boolean bMC;
    public com.baidu.tbadk.core.data.bj bMD;
    private com.baidu.tieba.tbadkCore.data.e bMJ;
    private VoiceManager bMM;
    private bo bMP;
    private q.a bMW;
    private FrsModelController bMY;
    private com.baidu.tieba.frs.f.u bMZ;
    private com.baidu.tieba.frs.entelechy.b.a bMz;
    private com.baidu.tieba.frs.f.ao bNa;
    private com.baidu.tieba.frs.f.ad bNb;
    private com.baidu.tieba.frs.view.q bNc;
    private com.baidu.tieba.frs.entelechy.b.d bNd;
    private com.baidu.tieba.frs.mc.q bNe;
    private com.baidu.tieba.frs.mc.b bNf;
    private com.baidu.tieba.frs.smartsort.c bNg;
    private com.baidu.tieba.frs.mc.d bNh;
    private com.baidu.tieba.frs.headvideo.b bNi;
    private ce bNj;
    private com.baidu.tieba.frs.entelechy.b.b bNl;
    private com.baidu.tbadk.e.a bNm;
    private com.baidu.tieba.frs.f.a bNn;
    private com.baidu.tieba.frs.f.as bNo;
    private com.baidu.tieba.frs.mc.k bNp;
    private com.baidu.tieba.frs.mc.h bNq;
    private com.baidu.tieba.frs.f.ah bNr;
    private com.baidu.tieba.frs.mc.a bNs;
    private aw bNt;
    public com.baidu.tieba.frs.f.f bNu;
    private com.baidu.tieba.frs.mc.o bNv;
    private static final int bMx = (com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst()) - com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds100)) - com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds90);
    private static final int bMy = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds300);
    private static boolean isNeedRefreshOnResume = false;
    public static boolean bMB = false;
    public static volatile long bMQ = 0;
    public static volatile long bMR = 0;
    public static volatile int bMS = 0;
    public boolean bMA = false;
    public String bME = null;
    public String ahy = null;
    public int mFlag = 0;
    private boolean bMF = false;
    private boolean bMG = false;
    private String mThreadId = null;
    private String forumId = null;
    private int bMH = 0;
    private boolean bMI = false;
    private boolean bMK = false;
    private boolean bML = false;
    private ax bMN = null;
    public final com.baidu.tbadk.core.data.bj aRF = null;
    private com.baidu.tieba.tbadkCore.n bMO = new com.baidu.tieba.tbadkCore.n();
    public long bEN = -1;
    public long aGp = 0;
    public long aGh = 0;
    public long createTime = 0;
    public long VT = -1;
    private boolean bMT = false;
    private boolean bMU = false;
    public com.baidu.tbadk.performanceLog.e bMV = null;
    private boolean bMX = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> bNk = new SparseArray<>();
    private boolean byg = true;
    private final CustomMessageListener bNw = new d(this, CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED);
    private final cc bNx = new o(this);
    private cb bNy = new aa(this);
    private CustomMessageListener bNz = new ab(this, CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT);
    private CustomMessageListener bNA = new ac(this, CmdConfigCustom.CMD_FRS_TAB_LIVE_START);
    private final CustomMessageListener bNB = new ad(this, CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB);
    private final CustomMessageListener bNC = new ae(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    public final CustomMessageListener bND = new af(this, CmdConfigCustom.MSG_NEW);
    private final CustomMessageListener bNE = new ag(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    public final com.baidu.tieba.tbadkCore.p bNF = new e(this);
    private final CustomMessageListener bNG = new f(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private final CustomMessageListener mMemListener = new g(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private CustomMessageListener bNH = new h(this, CmdConfigCustom.CMD_DRIFTING_BOTTLE_CLEAR_MESSAGE);
    private final com.baidu.tieba.frs.mc.v bNI = new i(this);
    public final View.OnTouchListener aNR = new j(this);
    private final CustomMessageListener bNJ = new k(this, CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE);
    private final CustomMessageListener bNK = new l(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);
    private final com.baidu.adp.framework.listener.a bNL = new m(this, CmdConfigHttp.CMD_SET_COMMON_FORUM_STATE, 309365);
    public final View.OnClickListener bNM = new n(this);
    private final AbsListView.OnScrollListener bNN = new p(this);
    private final com.baidu.tbadk.util.e<Boolean> bNO = new q(this);
    private final ar bNP = new r(this);
    private final NoNetworkView.a bMe = new t(this);
    private final CustomMessageListener bNQ = new u(this, 0);
    private com.baidu.adp.widget.ListView.w bNR = new a(this, null);
    private com.baidu.adp.widget.ListView.x bNS = new v(this);
    private cc bNT = new w(this);

    public com.baidu.tieba.frs.f.as Yq() {
        return this.bNo;
    }

    public com.baidu.tieba.frs.entelechy.b.b Yr() {
        return this.bNl;
    }

    public com.baidu.adp.widget.ListView.w Ys() {
        return this.bNR;
    }

    public com.baidu.adp.widget.ListView.x Yt() {
        return this.bNS;
    }

    public com.baidu.tieba.frs.mc.k Yu() {
        return this.bNp;
    }

    public com.baidu.tieba.frs.headvideo.b Yv() {
        return this.bNi;
    }

    public com.baidu.tieba.frs.smartsort.c Yw() {
        return this.bNg;
    }

    @Override // com.baidu.tieba.frs.mc.w
    public FrsModelController Yx() {
        return this.bMY;
    }

    public com.baidu.tieba.frs.f.ad Yy() {
        return this.bNb;
    }

    public com.baidu.tieba.frs.f.ao Yz() {
        return this.bNa;
    }

    public com.baidu.tieba.frs.mc.h YA() {
        return this.bNq;
    }

    @Override // com.baidu.tieba.frs.mc.w
    public com.baidu.tieba.frs.f.u YB() {
        return this.bMZ;
    }

    public com.baidu.tieba.frs.entelechy.b.d YC() {
        return this.bNd;
    }

    public ce YD() {
        return this.bNj;
    }

    @Override // com.baidu.tieba.frs.mc.w
    public ax YE() {
        return this.bMN;
    }

    @Override // com.baidu.tieba.frs.cd
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.cd
    public String getForumName() {
        return this.bME;
    }

    public void setForumName(String str) {
        this.bME = str;
    }

    public void setFrom(String str) {
        this.ahy = str;
    }

    public String getFrom() {
        return this.ahy;
    }

    public void setFlag(int i) {
        this.mFlag = i;
    }

    @Override // com.baidu.tieba.recapp.o
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.o
    public com.baidu.adp.widget.ListView.a k(BdUniqueId bdUniqueId) {
        return c.Yp().b(this, bdUniqueId);
    }

    @Override // com.baidu.tieba.recapp.o
    public int getPageNum() {
        if (this.bNq == null) {
            return 1;
        }
        return this.bNq.getPn();
    }

    public int getPn() {
        if (this.bNq == null) {
            return 1;
        }
        return this.bNq.getPn();
    }

    public void setPn(int i) {
        if (this.bNq != null) {
            this.bNq.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.bNq != null) {
            this.bNq.setHasMore(i);
        }
    }

    public int YF() {
        if (this.bNq == null) {
            return -1;
        }
        return this.bNq.YF();
    }

    public boolean YG() {
        return this.bML;
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
        if (this.bMN.Zq() != null && !z) {
            this.bMN.Zq().setVisibility(8);
        }
        if (this.bMN.Zt() != null && !z) {
            this.bMN.Zt().setVisibility(8);
        }
        if (this.bNb != null) {
            this.bNb.dX(false);
        }
        if (aVar == null) {
            showNetRefreshView(this.bMN.ZH(), getPageContext().getString(w.l.error_unkown_try_again), true);
        } else if (aVar.frg) {
            if (340001 == aVar.errorCode) {
                showNetRefreshViewNoClick(this.bMN.ZH(), getPageContext().getResources().getString(w.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
            } else {
                showNetRefreshView(this.bMN.ZH(), getPageContext().getResources().getString(w.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
            }
        } else if (340001 == aVar.errorCode) {
            showNetRefreshViewNoClick(this.bMN.ZH(), aVar.errorMsg, true);
        } else {
            showNetRefreshView(this.bMN.ZH(), aVar.errorMsg, true);
        }
        setNetRefreshViewEmotionDefMarginTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YH() {
        hideLoadingView(this.bMN.ZH());
        this.bMN.ce(false);
        this.bMN.ZC();
        if (this.bMN.Zm() instanceof com.baidu.tieba.frs.tab.h) {
            ((com.baidu.tieba.frs.tab.h) this.bMN.Zm()).ady();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YI() {
        if (YF() == 0 && com.baidu.tbadk.core.util.x.q(this.bMO.bfE())) {
            if (com.baidu.tbadk.core.util.x.q(this.bMO.getThreadList())) {
                this.bMN.TI();
                return;
            } else {
                this.bMN.Ka();
                return;
            }
        }
        this.bMN.ZK();
    }

    public void a(ErrorData errorData) {
        boolean z = true;
        YH();
        this.bMN.Zx();
        d.a acO = this.bMY.acO();
        boolean q = com.baidu.tbadk.core.util.x.q(this.bMO.getThreadList());
        if (acO != null && q) {
            if (q) {
                if (this.bMY.acP() != 0) {
                    this.bMY.acV();
                    this.bMN.Zx();
                } else {
                    a(acO, false);
                }
                ax axVar = this.bMN;
                if (!this.bMO.bgF() && !YL()) {
                    z = false;
                }
                axVar.n(z, false);
                return;
            } else if (acO.frg) {
                this.bMN.n(true, false);
                showToast(getPageContext().getResources().getString(w.l.net_error_text, acO.errorMsg, Integer.valueOf(acO.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(acO, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YJ() {
        if (this.bMO == null || this.bMO.aJp() != null) {
            this.bMN.ZF();
        } else if (this.bMO.aJp().getYuleData() != null && this.bMO.aJp().getYuleData().tk()) {
            TiebaStatic.log("c10852");
            this.bMN.a(this.bMO.aJp().getYuleData().tl());
        } else {
            this.bMN.ZF();
        }
    }

    private void dv(boolean z) {
        if (this.bMY != null && this.bMO != null && this.bMN != null && z) {
            if (!this.bMY.adc() && this.bMY.acR() == 1) {
                if (this.bMN.ZG().l(com.baidu.tieba.tbadkCore.af.ftm)) {
                    this.bMO.bgs();
                }
                if (!this.bMY.ada()) {
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.bMO.bgy();
                        this.bMO.bgx();
                        this.bMO.bgu();
                    }
                    this.bMO.bgv();
                    this.bMO.bgw();
                }
                boolean z2 = false;
                if (this.bMN.ZG().l(com.baidu.tieba.card.data.r.bvE)) {
                    z2 = this.bMO.bgB();
                }
                if (!z2) {
                    this.bMO.bgA();
                }
                if (TbadkCoreApplication.m9getInst().isRecAppExist()) {
                    this.bMO.g(this);
                }
                if (!this.bMN.ZG().l(com.baidu.tbadk.core.data.bj.XN)) {
                    this.bMO.bgp();
                }
                this.bMO.bgC();
                this.bMO.bgD();
            }
            this.bMO.bgq();
            this.bMO.bgn();
            this.bMO.bgr();
        }
    }

    public boolean YK() {
        if (this.bNd != null && this.bMN != null && !YL()) {
            this.bNd.b(this.bMN.getListView());
        }
        if (this.bMZ != null && this.bMY != null) {
            this.bMZ.a(this.bMY.acN(), this.bMO);
        }
        boolean z = false;
        if (this.bMO != null) {
            z = this.bMO.bgG();
        }
        dw(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hI(int i) {
        cj cjVar = null;
        YK();
        YT();
        try {
            if (this.bMO != null) {
                this.bMN.a(null, this.bMO);
                this.bMZ.iD(1);
                this.bMN.ZA();
                this.bNd.a(this.bMN.getListView(), this.bMO, this.bMY.acX());
                com.baidu.tieba.frs.tab.i a2 = a(this.bNd.abc(), this.bMO.bfU());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    cjVar = new cj();
                    cjVar.bQr = a2.url;
                    cjVar.stType = a2.name;
                }
                this.bMY.a(this.bMO.bfU(), 0, cjVar);
                this.bNd.dW(false);
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
            if (iVar != null && iVar.caM == i) {
                return iVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z, boolean z2) {
        try {
            if (this.bMO != null && this.bNd != null && this.bMY != null) {
                if (!this.bMN.ZG().l(com.baidu.tbadk.core.data.bj.XN)) {
                    this.bMO.bgp();
                }
                if (this.bMO.aJp() != null) {
                    this.bME = this.bMO.aJp().getName();
                    this.forumId = this.bMO.aJp().getId();
                }
                if (this.bMO.bgG()) {
                    this.bNd.a(this.bMN.getListView(), this.bMO, this.bMY.acX());
                }
                if (z) {
                    dv(true);
                } else {
                    dv(this.bMX);
                }
                YK();
                if (this.bNl != null) {
                    this.bNl.a(this.bMZ, this.bMO);
                }
                if (this.bMO.getPage() != null) {
                    setHasMore(this.bMO.getPage().qQ());
                }
                ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bNq.a(z2, true, this.bMO.getThreadList(), null);
                if (a2 != null) {
                    this.bMO.ax(a2);
                }
                if (this.bMY.acR() == 1) {
                    YO();
                }
                this.bMH = this.bMO.acT();
                if (this.bMJ != null) {
                    this.bMI = true;
                    this.bMJ.rQ(this.bMH);
                    com.baidu.tieba.frs.utils.a.a(getPageContext(), this.bMO.aJp(), this.bMO.getThreadList(), this.bMI, getPn());
                }
                if (this.bNn != null) {
                    this.bNn.cd(this.bMY.adc());
                    this.bNn.al(this.bNd.abd());
                }
                YH();
                if (this.bMO.aJp() != null) {
                    this.bNa.dO(this.bMO.aJp().isLike() == 1);
                }
                if (this.bMN.Zq() != null && this.mIsLogin) {
                    this.bMN.Zq().setVisibility(0);
                }
                if (this.bNb != null && this.mIsLogin) {
                    this.bNb.dX(true);
                }
                if (this.bNb != null && !this.bNb.abn()) {
                    this.bMN.dB(this.bMY.acS());
                }
                if (this.bMO.aJp().isIs_forbidden() == 1) {
                    this.bNa.dP(false);
                } else {
                    this.bNa.dP(true);
                }
                this.bNa.em(this.bMO.bfx() == 1);
                this.bMN.n(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.l lVar) {
        try {
            if (!this.bMT && lVar != null && this.bMO != null) {
                this.bMO.d(lVar);
                m(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void dw(boolean z) {
        if (this.bMY != null) {
            g(z, this.bMY.acN());
        } else {
            g(z, "normal_page");
        }
    }

    private void g(boolean z, String str) {
        if (!YL()) {
            dx("frs_page".equals(str));
        }
        if (this.bNl != null) {
            this.bNl.a(z, this.bNd, this.bMZ, this.bMN, this.bMO);
        }
    }

    @Override // com.baidu.tieba.frs.mc.w
    public boolean YL() {
        return this.bNo != null && this.bNo.YL();
    }

    public void dx(boolean z) {
        if (this.bNr != null) {
            this.bNr.a(this.bMN, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        this.bEN = System.currentTimeMillis();
        if (intent != null) {
            this.bMK = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.bEN = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            H(intent);
        }
        this.VT = System.currentTimeMillis();
        this.aGh = this.VT - this.bEN;
        super.onCreate(bundle);
        this.bMJ = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.ftF);
        this.bMY = new FrsModelController(this, this.bNF);
        this.bMY.a(this.bNx);
        this.bMY.init();
        if (getIntent() != null) {
            this.bMY.e(getIntent().getExtras());
        } else if (bundle != null) {
            this.bMY.e(bundle);
        } else {
            this.bMY.e((Bundle) null);
        }
        this.bMz = new com.baidu.tieba.frs.entelechy.i();
        this.bNl = this.bMz.aaB();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(w.j.frs_activity, (ViewGroup) null);
        this.bNb = new com.baidu.tieba.frs.f.ad(this, this.bMz.aaA());
        this.bNa = new com.baidu.tieba.frs.f.ao(this);
        this.bNb.a(getPageContext().getPageActivity(), inflate, this.bNa.aej());
        this.bMZ = new com.baidu.tieba.frs.f.u(this, this.bMz);
        this.bNd = this.bMz.C(this);
        this.bMN = new ax(this, this.bNM, this.bMz);
        this.bMZ.a(this.bMN.KC());
        this.bNo = new com.baidu.tieba.frs.f.as(this, this.bMN, this.bNd, this.bMZ);
        this.bNd.ah(this.bMN.ZH());
        if (getIntent() != null) {
            this.bMZ.g(getIntent().getExtras());
        } else if (bundle != null) {
            this.bMZ.g(bundle);
        } else {
            this.bMZ.g((Bundle) null);
        }
        this.bMM = getVoiceManager();
        this.bMM.onCreate(getPageContext());
        this.bNt = new aw(getPageContext(), this);
        initUI();
        initData(bundle);
        this.bNj = new ce(getActivity(), this.bMN, this.bMZ);
        this.bNj.a(this.bNO);
        this.bNj.dL(true);
        new com.baidu.tieba.frs.mc.t();
        this.bNq = new com.baidu.tieba.frs.mc.h(this, this.bNI);
        this.bNg = new com.baidu.tieba.frs.smartsort.c(this);
        this.bNr = new com.baidu.tieba.frs.f.ah(this);
        addGlobalLayoutListener();
        this.createTime = System.currentTimeMillis() - this.VT;
        this.bNn = new com.baidu.tieba.frs.f.a(getPageContext(), this.bMY.acZ());
        this.bNi = new com.baidu.tieba.frs.headvideo.b(this.bMZ);
        this.bNh = new com.baidu.tieba.frs.mc.d(this);
        this.bNp = new com.baidu.tieba.frs.mc.k(this);
        this.bNe = new com.baidu.tieba.frs.mc.q(this);
        this.bNf = new com.baidu.tieba.frs.mc.b(this);
        this.bNs = new com.baidu.tieba.frs.mc.a(this);
        this.bNu = new com.baidu.tieba.frs.f.f(this);
        this.bNv = new com.baidu.tieba.frs.mc.o(getPageContext(), this);
        registerListener(this.mMemListener);
        registerListener(this.bND);
        registerListener(this.bNE);
        registerListener(this.bNJ);
        registerListener(this.bNC);
        registerListener(this.bNG);
        registerListener(this.bNz);
        registerListener(this.bNA);
        registerListener(this.bNB);
        registerListener(this.bNL);
        registerListener(this.bNw);
        registerListener(this.bNH);
        showLoadingView(this.bMN.ZH(), true);
        this.bMN.dE(false);
        this.bMY.p(3, true);
    }

    private void H(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.utils.q.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
                finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.bME = data.getQueryParameter("name");
            this.ahy = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.bME)) {
                intent.putExtra("name", this.bME);
            }
            if (!StringUtils.isNull(this.ahy)) {
                intent.putExtra("from", this.ahy);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.bME)) {
            this.bME = com.baidu.tieba.frs.utils.t.I(intent);
            if (!StringUtils.isNull(this.bME)) {
                intent.putExtra("name", this.bME);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.bMM = getVoiceManager();
        this.bMM.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bNQ);
        if (bundle != null) {
            this.bME = bundle.getString("name");
            this.ahy = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bME = intent.getStringExtra("name");
                this.ahy = intent.getStringExtra("from");
                this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.ahy) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.ahy)) {
            setSwipeBackEnabled(false);
        }
        this.bMP = new bo(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            YM();
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.bNQ);
        }
        this.bMZ.g(bundle);
    }

    public void YM() {
        if (this.bMP != null && this.bMN != null) {
            if (FrsActivityStatic.bOa || FrsActivityStatic.bOb) {
                this.bMP.aR(com.baidu.tbadk.coreExtra.messageCenter.a.yK().getMsgReplyme());
                this.bMP.aQ(com.baidu.tbadk.coreExtra.messageCenter.a.yK().getMsgAtme());
                this.bMP.aT(com.baidu.tbadk.coreExtra.messageCenter.a.yK().yR());
                this.bMP.aS(com.baidu.tbadk.coreExtra.messageCenter.a.yK().getMsgChat());
                this.bMN.a(this.bMP);
                this.bNa.a(this.bMP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.card.cc.Sv().cN(false);
        if (this.bMO != null && this.bMO.aJp() != null) {
            by.aaf().aV(com.baidu.adp.lib.g.b.c(this.bMO.aJp().getId(), 0L));
        }
        if (this.bMN != null) {
            com.baidu.tieba.frs.utils.s.a(this.bMN, this.bMO, getForumId(), false, null);
            this.bMN.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.bMV != null) {
                this.bMV.onDestroy();
            }
            this.bMN.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.bMY.onActivityDestroy();
        this.bMZ.onActivityDestroy();
        this.bMM = getVoiceManager();
        this.bMM.onDestory(getPageContext());
        if (this.bMW != null) {
            this.bMW.cancel(true);
            this.bMW = null;
        }
        if (this.bMY != null) {
            this.bMY.MQ();
        }
        if (this.bNa != null) {
            this.bNa.destroy();
        }
        if (this.bNj != null) {
            this.bNj.WI();
        }
        if (this.bNm != null) {
            this.bNm.destory();
        }
        if (this.bNn != null) {
            this.bNn.destory();
        }
        if (this.bNo != null) {
            this.bNo.onDestroy();
        }
        if (this.bNg != null) {
            this.bNg.onDestroy();
        }
        com.baidu.tieba.recapp.c.a.aZL().aZN();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.bME);
        bundle.putString("from", this.ahy);
        this.bMY.onSaveInstanceState(bundle);
        this.bMM = getVoiceManager();
        if (this.bMM != null) {
            this.bMM.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.bNs != null) {
            this.bNs.onActivityResult(i, i2, intent);
        }
    }

    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bNm == null) {
                this.bNm = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bNm.an(updateAttentionMessage.getData().toUid, getForumId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bMN != null) {
            this.bMN.Zx();
            this.bMN.onResume();
            com.baidu.tieba.frs.utils.t.l(this.bMN);
        }
        this.bNd.a(this.bNy);
        this.bNe.eh(true);
        this.bMX = true;
        if (this.bNi != null) {
            this.bNi.eg(false);
        }
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.bMN.startPullRefresh();
        } else if (bMB) {
            bMB = false;
            this.bMN.startPullRefresh();
        } else {
            this.bMM = getVoiceManager();
            this.bMM.onResume(getPageContext());
            this.bMN.dH(false);
            registerListener(this.bNK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.bMN.dF(z);
        this.bNb.dX(z);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.bME = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.ahy = intent.getStringExtra("from");
            }
            this.bMG = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.bMG) {
                dy(intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false));
            }
        }
    }

    private void dy(boolean z) {
        this.bMN.startPullRefresh();
        this.bNb.dZ(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        com.baidu.tieba.frs.utils.t.a(this, getIntent(), this.ahy);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.bMN.setTitle(this.bME);
        } else {
            this.bMN.setTitle("");
            this.mFlag = 1;
        }
        this.bMZ.d(this.bMN.getListView());
        this.bMN.setOnAdapterItemClickListener(this.bNR);
        this.bMN.setOnAdapterItemLongClickListener(this.bNS);
        this.bMN.setOnScrollListener(this.bNN);
        this.bMN.h(this.bMe);
        this.bMN.ZG().a(this.bNP);
        if (!this.mIsLogin) {
            this.bMN.dF(false);
            this.bNb.dX(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bMN.onChangeSkinType(i);
        this.bNa.b(getPageContext(), i);
        this.bMZ.b(getPageContext(), i);
        this.bNd.onChangeSkinType(i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.adp.widget.f.c
    public void lP() {
        setSwipeBackEnabled(true);
        this.bNb.dX(true);
    }

    @Override // com.baidu.adp.widget.f.c
    public void lQ() {
        setSwipeBackEnabled(false);
        this.bNb.dX(false);
    }

    public void hJ(int i) {
        if (!this.mIsLogin) {
            if (this.bMO != null && this.bMO.qE() != null) {
                this.bMO.qE().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.bMO != null) {
            if (i == 0) {
                if (!this.bMC) {
                    com.baidu.tieba.frs.utils.u.b(this, 0);
                    return;
                }
                TiebaStatic.log("c10152");
                com.baidu.tieba.frs.utils.u.b(this, 4);
                return;
            }
            this.bMN.Zz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(com.baidu.tbadk.core.data.bj bjVar) {
        boolean z = bjVar == null || bjVar.sG();
        this.bMN.a(new y(this, bjVar));
        this.bMN.b(bjVar, z);
    }

    public void refresh() {
        cg(3);
    }

    public void cg(int i) {
        this.bMT = false;
        YT();
        if (this.bMN.KC() != null) {
            this.bMN.KC().alL();
        }
        this.bMY.p(i, true);
    }

    private void YN() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.k.fN().f(new z(this));
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YO() {
        YT();
        try {
            if (this.bMO != null) {
                this.bMN.Kz();
                if (this.bNb != null && !this.bNb.abn()) {
                    this.bMN.dB(this.bMY.acS());
                }
                if (!YL() && com.baidu.tieba.frs.f.u.l(this.bMO) && !com.baidu.tieba.frs.f.u.k(this.bMO)) {
                    this.bMN.ZM();
                }
                if (this.bMO.aJp() != null) {
                    this.bME = this.bMO.aJp().getName();
                    this.forumId = this.bMO.aJp().getId();
                }
                if (this.bMO.getPage() != null) {
                    setHasMore(this.bMO.getPage().qQ());
                }
                this.bMN.setTitle(this.bME);
                this.bMN.setForumName(this.bME);
                TbadkCoreApplication.m9getInst().setDefaultBubble(this.bMO.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(this.bMO.getUserData().getBimg_end_time());
                YN();
                YP();
                ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bMO.getThreadList();
                if (threadList != null) {
                    this.bMN.a(threadList, this.bMO);
                    com.baidu.tieba.frs.utils.e.k(this.bMN);
                    this.bMZ.iD(getPageNum());
                    this.bMZ.h(this.bMO);
                    this.bNd.a(this.bMN.getListView(), this.bMO, this.bMY.acX());
                    this.bMN.ZA();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void YP() {
        if (this.bMO != null) {
            if (this.bMO.aJB() == 1) {
                this.bMN.ZG().setFromCDN(true);
            } else {
                this.bMN.ZG().setFromCDN(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bNe.eh(false);
        this.bMX = false;
        this.bMN.onPause();
        this.bMM = getVoiceManager();
        this.bMM.onPause(getPageContext());
        this.bMN.dH(true);
        if (this.bNn != null) {
            this.bNn.adD();
        }
        if (this.bNi != null) {
            this.bNi.eg(true);
        }
        MessageManager.getInstance().unRegisterListener(this.bNK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.cc.Sv().cN(false);
        if (this.bMO != null && this.bMO.aJp() != null) {
            com.baidu.tbadk.distribute.a.Cz().b(getPageContext().getPageActivity(), "frs", this.bMO.aJp().getId(), 0L);
        }
        this.bMM = getVoiceManager();
        if (this.bMM != null) {
            this.bMM.onStop(getPageContext());
        }
        com.baidu.tieba.frs.utils.t.d(getListView());
        this.bMZ.onActivityStop();
        com.baidu.tbadk.util.r.GU();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.bMF) {
            if (i == 4) {
                if (this.bNb.abn()) {
                    this.bNb.dY(true);
                    if (this.bNa.aek().aan()) {
                        this.bNa.aek().dQ(false);
                        refresh();
                        return true;
                    }
                    return true;
                } else if (YL()) {
                    this.bNo.aet();
                    return true;
                } else if (this.bMN.Zw()) {
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

    public boolean YQ() {
        if (this.bNc == null) {
            return false;
        }
        return this.bNc.isShowing();
    }

    public void YR() {
        this.bMW = com.baidu.tieba.frs.utils.q.b(this, this.bME);
    }

    @Override // com.baidu.tieba.recapp.o
    public BaseActivity<?> getContext() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.o
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.Cz().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.o
    public void YS() {
        Yx().YS();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bMM == null) {
            this.bMM = VoiceManager.instance();
        }
        return this.bMM;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.bMN == null) {
            return null;
        }
        return this.bMN.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void YT() {
        this.bMM = getVoiceManager();
        this.bMM.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wX() {
        if (this.alR == null) {
            this.alR = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.alR;
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
            if (this.bMP != null) {
                this.bMP.aR(msgReplyme);
                this.bMP.aQ(msgAtme);
                this.bMP.aU(msgOfficialMerge);
                this.bMP.aS(msgChat);
                this.bMP.aT(msgStrangerChat);
                this.bMN.a(this.bMP);
                this.bNa.a(this.bMP);
            }
        }
    }

    public void YU() {
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
                if (bdUniqueId == bj.bPD) {
                    if (FrsActivity.this.bMN != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11752").Z("fid", FrsActivity.this.forumId).Z("obj_locate", "1"));
                        FrsActivity.this.bMN.startPullRefresh();
                    }
                } else if (vVar != null && (vVar instanceof com.baidu.tbadk.core.data.bj)) {
                    com.baidu.tbadk.core.data.bj bjVar = (com.baidu.tbadk.core.data.bj) vVar;
                    if (bjVar.sB() == null || bjVar.sB().getGroup_id() == 0 || FrsActivity.this.checkUpIsLogin()) {
                        if ((bjVar.su() != 1 && bjVar.su() != 2) || FrsActivity.this.checkUpIsLogin()) {
                            if (bjVar.sd() != null) {
                                if (FrsActivity.this.checkUpIsLogin()) {
                                    String postUrl = bjVar.sd().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hv()) {
                                        com.baidu.tbadk.browser.f.P(FrsActivity.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bjVar.sM() != null) {
                                com.baidu.tbadk.core.data.n sM = bjVar.sM();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsActivity.this.getPageContext().getPageActivity(), sM.getCartoonId(), sM.getChapterId(), 2)));
                            } else if (bjVar.getThreadType() == 47 && bjVar.rM() == 1 && !com.baidu.tbadk.core.util.au.isEmpty(bjVar.rX())) {
                                com.baidu.tbadk.browser.f.O(FrsActivity.this.getPageContext().getPageActivity(), bjVar.rX());
                            } else {
                                com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.pX(bjVar.getId())) {
                                    readThreadHistory.pW(bjVar.getId());
                                }
                                boolean z = false;
                                String rX = bjVar.rX();
                                if (rX != null && !rX.equals("")) {
                                    z = true;
                                    new Thread(new ah(this, rX)).start();
                                }
                                String tid = bjVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bjVar.rM() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.bb vQ = com.baidu.tbadk.core.util.bb.vQ();
                                    TbPageContext<?> pageContext = FrsActivity.this.getPageContext();
                                    String[] strArr = new String[3];
                                    strArr[0] = tid;
                                    strArr[1] = "";
                                    vQ.c(pageContext, strArr);
                                    return;
                                }
                                boolean z2 = false;
                                if (bjVar instanceof com.baidu.tbadk.core.data.ab) {
                                    z2 = true;
                                    TiebaStatic.log("c10769");
                                }
                                if (bjVar.getThreadType() == 33 || (bjVar instanceof com.baidu.tbadk.core.data.ax)) {
                                    if (!z2) {
                                        if (bjVar.getThreadType() == 33) {
                                            str = "c10245";
                                        } else {
                                            str = "c10180";
                                        }
                                        if (FrsActivity.this.bMY.acR() == 5) {
                                            str = "c10387";
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.as(str).Z("fid", FrsActivity.this.forumId));
                                    }
                                    com.baidu.tieba.frs.utils.t.d(FrsActivity.this, bjVar);
                                    if (FrsActivity.this.bMO != null && FrsActivity.this.bMO.aJp() != null) {
                                        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                                        aVar.cal = FrsActivity.this.bMO.frI == 1;
                                        aVar.can = FrsActivity.this.bMO.aJp().getId();
                                        aVar.cam = FrsActivity.this.Yx().acX();
                                        com.baidu.tieba.frs.e.b.adv().a(aVar, bjVar, 1);
                                        return;
                                    }
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bjVar.setId(tid.substring(3));
                                }
                                if (!z2 && FrsActivity.this.bMY.acR() == 2) {
                                    com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10077");
                                    asVar.s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, FrsActivity.this.bMY.acR());
                                    asVar.Z("tid", bjVar.getId());
                                    asVar.Z("fid", FrsActivity.this.getForumId());
                                    TiebaStatic.log(asVar);
                                }
                                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.bj.YT.getId()) {
                                    com.baidu.tieba.frs.utils.s.a(bjVar.rz());
                                    com.baidu.tieba.frs.utils.t.c(FrsActivity.this, bjVar);
                                    return;
                                }
                                com.baidu.tieba.frs.utils.t.a(FrsActivity.this, bjVar, i, z);
                                com.baidu.tieba.frs.utils.s.a(FrsActivity.this, FrsActivity.this.bMO, bjVar);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.k.hv()) {
            hideNetRefreshView(this.bMN.ZH());
            showLoadingView(this.bMN.ZH(), true);
            this.bMN.dE(false);
            this.bMN.startPullRefresh();
        }
    }

    public com.baidu.tieba.tbadkCore.n YV() {
        return this.bMO;
    }

    public boolean YW() {
        return this.bMN.YW();
    }

    public void YX() {
        FrsActivityStatic.bOa = false;
        FrsActivityStatic.bOb = false;
        YM();
    }

    public void O(Object obj) {
        if (this.bNh != null && this.bNh.bZj != null) {
            this.bNh.bZj.g(obj);
        }
    }

    public void P(Object obj) {
        if (this.bNh != null && this.bNh.bZk != null) {
            this.bNh.bZk.g(obj);
        }
    }

    public void YY() {
        this.bMZ.YY();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void lj() {
        if (!com.baidu.adp.lib.util.k.hv()) {
            this.bMN.TI();
        } else if (this.bMY.acR() == 1) {
            JW();
            YZ();
        } else if (this.bMY.hasMore()) {
            YZ();
        }
    }

    public void iF(String str) {
        JW();
        showToast(str);
    }

    public void E(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        JW();
        if (!com.baidu.tbadk.core.util.x.q(arrayList)) {
            if (!this.bMY.adc() && TbadkCoreApplication.m9getInst().isRecAppExist() && this.bMY.acR() == 1) {
                this.bMO.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bNq.a(false, false, arrayList, this.bMJ);
            if (a2 != null) {
                this.bMO.ax(a2);
                this.bMN.a(a2, this.bMO);
            }
            if (this.bMY != null) {
                com.baidu.tieba.frs.e.b.a(this.bMO, this.bMY.acX(), 2);
            }
        }
    }

    private void JW() {
        if (YF() == 1 || this.bNq.at(this.bMO.bfE())) {
            this.bMN.ZK();
        } else if (com.baidu.tbadk.core.util.x.q(this.bMO.getThreadList())) {
            this.bMN.TI();
        } else {
            this.bMN.Ka();
        }
    }

    @Override // com.baidu.tieba.frs.mc.w
    public void YZ() {
        if (this.bNq != null) {
            this.bNq.a(this.bME, this.forumId, this.bMO);
        }
    }

    public boolean Za() {
        return this.bNa.aek().aan();
    }

    public void dz(boolean z) {
        this.bNa.aek().dQ(z);
    }

    public void Pn() {
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
        com.baidu.tieba.frs.utils.t.a(this, i, strArr, iArr);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    public void Zb() {
        if (this.bNn != null) {
            this.bNn.adD();
        }
    }

    public void dA(boolean z) {
        if (this.bNo != null) {
            this.bNo.dA(z);
        }
        if (this.bNj != null) {
            this.bNj.dL(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.bNk.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fA(int i) {
        return this.bNk.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.a aVar) {
        this.bNt.b(aVar);
    }
}
