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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.acrossForum.AcrossForumViewData;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.utils.r;
import com.baidu.tieba.r;
import com.baidu.tieba.recapp.b;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FrsActivity extends BaseActivity<FrsActivity> implements a.InterfaceC0000a, BdListView.e, f.c, UserIconBox.b, VoiceManager.c, cg, b {
    private com.baidu.adp.lib.f.b<TbImageView> ahK;
    private com.baidu.tieba.frs.entelechy.b.a bRI;
    private boolean bRL;
    public com.baidu.tbadk.core.data.bk bRM;
    private com.baidu.tieba.tbadkCore.data.f bRS;
    private String bRT;
    private VoiceManager bRV;
    private br bRY;
    private com.baidu.tieba.frs.j.ai bSA;
    private com.baidu.tieba.frs.e.k bSB;
    private com.baidu.tieba.frs.e.h bSC;
    private com.baidu.tieba.frs.j.y bSD;
    private com.baidu.tieba.frs.e.a bSE;
    private com.baidu.tieba.frs.acrossForum.c bSF;
    private r.a bSf;
    private com.baidu.tieba.frs.e.i bSh;
    private com.baidu.tieba.frs.j.n bSi;
    private com.baidu.tieba.frs.j.af bSj;
    private com.baidu.tieba.frs.j.w bSk;
    private com.baidu.tieba.frs.view.q bSl;
    private com.baidu.tieba.frs.entelechy.b.d bSm;
    private com.baidu.tieba.frs.e.p bSn;
    private com.baidu.tieba.frs.e.b bSo;
    private com.baidu.tieba.frs.g.d bSp;
    private com.baidu.tieba.frs.e.d bSq;
    private com.baidu.tieba.frs.headvideo.b bSr;
    private ch bSs;
    private com.baidu.tieba.frs.entelechy.b.b bSu;
    private com.baidu.tieba.frs.ecomm.a bSv;
    private com.baidu.tbadk.e.a bSw;
    private com.baidu.tieba.frs.j.a bSx;
    private com.baidu.tieba.frs.acrossForum.j bSy;
    private AcrossForumViewData bSz;
    private com.baidu.tbadk.core.view.a bsc;
    private static final int bRG = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst()) - com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds100)) - com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds90);
    private static final int bRH = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds300);
    private static boolean isNeedRefreshOnResume = false;
    public static boolean bRK = false;
    public static volatile long bRZ = 0;
    public static volatile long bSa = 0;
    public static volatile int bSb = 0;
    public boolean bRJ = false;
    public String bRN = null;
    public String adE = null;
    public int mFlag = 0;
    private boolean bRO = false;
    private boolean bRP = false;
    private String mThreadId = null;
    private String forumId = null;
    private int bRQ = 0;
    private boolean bRR = false;
    private boolean bRU = false;
    private au bRW = null;
    public final com.baidu.tbadk.core.data.bk aNA = null;
    private com.baidu.tieba.tbadkCore.p bRX = new com.baidu.tieba.tbadkCore.p();
    public long bJR = -1;
    public long aCL = 0;
    public long aCD = 0;
    public long createTime = 0;
    public long RA = -1;
    private boolean bSc = false;
    private boolean bSd = false;
    public com.baidu.tbadk.performanceLog.e bSe = null;
    private boolean bSg = true;
    private boolean bSt = true;
    private final CustomMessageListener bSG = new d(this, CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED);
    private final cf bSH = new p(this);
    private ce bSI = new x(this);
    private final CustomMessageListener bSJ = new y(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private final CustomMessageListener aXH = new z(this, CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND);
    public final CustomMessageListener bSK = new aa(this, CmdConfigCustom.MSG_NEW);
    private final CustomMessageListener bSL = new ab(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    public final com.baidu.tieba.tbadkCore.r bSM = new ac(this);
    private final CustomMessageListener bSN = new ad(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private final CustomMessageListener mMemListener = new e(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private final com.baidu.tieba.frs.e.t bSO = new f(this);
    public final View.OnTouchListener aKw = new g(this);
    private final CustomMessageListener bSP = new h(this, CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE);
    private final CustomMessageListener bSQ = new i(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);
    private final com.baidu.adp.framework.listener.a bSR = new j(this, CmdConfigHttp.CMD_SET_COMMON_FORUM_STATE, 309365);
    public final View.OnClickListener bSS = new k(this);
    private final AbsListView.OnScrollListener bST = new l(this);
    private final com.baidu.tbadk.util.e<Boolean> bSU = new m(this);
    private final ao bSV = new n(this);
    private final NoNetworkView.a aTn = new q(this);
    private final CustomMessageListener bSW = new r(this, 0);
    private com.baidu.adp.widget.ListView.w bSX = new a(this, null);
    private com.baidu.adp.widget.ListView.x bSY = new s(this);
    private cf bSZ = new t(this);

    public com.baidu.tieba.frs.j.ai abL() {
        return this.bSA;
    }

    public com.baidu.tieba.frs.entelechy.b.b abM() {
        return this.bSu;
    }

    public com.baidu.adp.widget.ListView.w abN() {
        return this.bSX;
    }

    public com.baidu.adp.widget.ListView.x abO() {
        return this.bSY;
    }

    public com.baidu.tieba.frs.e.k abP() {
        return this.bSB;
    }

    public com.baidu.tieba.frs.headvideo.b abQ() {
        return this.bSr;
    }

    public com.baidu.tieba.frs.g.d abR() {
        return this.bSp;
    }

    public com.baidu.tieba.frs.e.i abS() {
        return this.bSh;
    }

    public com.baidu.tieba.frs.j.w abT() {
        return this.bSk;
    }

    public com.baidu.tieba.frs.j.af abU() {
        return this.bSj;
    }

    public com.baidu.tieba.frs.e.h abV() {
        return this.bSC;
    }

    public com.baidu.tieba.frs.j.n abW() {
        return this.bSi;
    }

    public com.baidu.tieba.frs.entelechy.b.d abX() {
        return this.bSm;
    }

    public ch abY() {
        return this.bSs;
    }

    public au abZ() {
        return this.bRW;
    }

    @Override // com.baidu.tieba.frs.cg
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.cg
    public String getForumName() {
        return this.bRN;
    }

    public void setForumName(String str) {
        this.bRN = str;
    }

    public String aca() {
        return this.bRT;
    }

    public void jT(String str) {
        this.bRT = str;
    }

    public void setFrom(String str) {
        this.adE = str;
    }

    public String getFrom() {
        return this.adE;
    }

    public void setFlag(int i) {
        this.mFlag = i;
    }

    @Override // com.baidu.tieba.recapp.b
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.b
    public int getPageNum() {
        if (this.bSC == null) {
            return 1;
        }
        return this.bSC.getPn();
    }

    public int getPn() {
        if (this.bSC == null) {
            return 1;
        }
        return this.bSC.getPn();
    }

    public void setPn(int i) {
        if (this.bSC != null) {
            this.bSC.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.bSC != null) {
            this.bSC.setHasMore(i);
        }
    }

    public int acb() {
        if (this.bSC == null) {
            return -1;
        }
        return this.bSC.acb();
    }

    public boolean acc() {
        return this.bRU;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    public void aI(boolean z) {
        if (this.bsc != null) {
            this.bsc.aI(z);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.a aVar, boolean z) {
        if (this.bRW.acP() != null && !z) {
            this.bRW.acP().setVisibility(8);
        }
        if (this.bSk != null) {
            this.bSk.ei(false);
        }
        if (aVar == null) {
            showNetRefreshView(this.bRW.adf(), getPageContext().getString(r.j.error_unkown_try_again), true);
        } else if (aVar.fzn) {
            if (340001 == aVar.errorCode) {
                showNetRefreshViewNoClick(this.bRW.adf(), getPageContext().getResources().getString(r.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
            } else {
                showNetRefreshView(this.bRW.adf(), getPageContext().getResources().getString(r.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
            }
        } else if (340001 == aVar.errorCode) {
            showNetRefreshViewNoClick(this.bRW.adf(), aVar.errorMsg, true);
        } else {
            showNetRefreshView(this.bRW.adf(), aVar.errorMsg, true);
        }
        setNetRefreshViewEmotionDefMarginTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acd() {
        hideLoadingView(this.bRW.adf());
        this.bRW.dO(false);
        this.bRW.ada();
        if (this.bRW.acJ() instanceof com.baidu.tieba.frs.tab.h) {
            ((com.baidu.tieba.frs.tab.h) this.bRW.acJ()).agY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ace() {
        if (acb() == 0 && com.baidu.tbadk.core.util.x.t(this.bRX.bkn())) {
            if (com.baidu.tbadk.core.util.x.t(this.bRX.getThreadList())) {
                this.bRW.adj();
                return;
            } else {
                this.bRW.JM();
                return;
            }
        }
        this.bRW.adi();
    }

    public void a(ErrorData errorData) {
        boolean z = true;
        acd();
        this.bRW.acT();
        e.a agp = this.bSh.agp();
        boolean t = com.baidu.tbadk.core.util.x.t(this.bRX.getThreadList());
        if (agp != null && t) {
            if (t) {
                if (this.bSh.agq() != 0) {
                    this.bSh.agw();
                    this.bRW.acT();
                } else {
                    a(agp, false);
                }
                au auVar = this.bRW;
                if (!this.bRX.blo() && !ach()) {
                    z = false;
                }
                auVar.n(z, false);
                return;
            } else if (agp.fzn) {
                this.bRW.n(true, false);
                showToast(getPageContext().getResources().getString(r.j.net_error_text, agp.errorMsg, Integer.valueOf(agp.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(agp, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acf() {
        if (this.bRX == null || this.bRX.aOk() != null) {
            this.bRW.add();
        } else if (this.bRX.aOk().getYuleData() != null && this.bRX.aOk().getYuleData().ti()) {
            TiebaStatic.log("c10852");
            this.bRW.a(this.bRX.aOk().getYuleData().tj());
        } else {
            this.bRW.add();
        }
    }

    private void dG(boolean z) {
        if (this.bSh != null && this.bRX != null && this.bRW != null && z) {
            if (!this.bSh.agD() && this.bSh.ags() == 1) {
                if (this.bRW.ade().k(com.baidu.tieba.tbadkCore.ak.fBq)) {
                    this.bRX.bla();
                }
                this.bRX.blh();
                if (!this.bSh.agA()) {
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.bRX.blg();
                        this.bRX.blf();
                        this.bRX.blc();
                    }
                    this.bRX.bld();
                    this.bRX.ble();
                }
                boolean z2 = false;
                if (this.bRW.ade().k(com.baidu.tieba.card.data.q.bfz)) {
                    z2 = this.bRX.blk();
                }
                if (!z2) {
                    this.bRX.blj();
                }
                if (TbadkCoreApplication.m9getInst().isRecAppExist()) {
                    this.bRX.bq(getPageContext().getPageActivity());
                }
                this.bRX.bll();
                this.bRX.blm();
            }
            this.bRX.bkY();
            this.bRX.bkV();
            this.bRX.bkZ();
        }
    }

    public boolean acg() {
        if (this.bSm != null && this.bRW != null && !ach()) {
            this.bSm.u(this.bRW.acW());
        }
        if (this.bSi != null && this.bSh != null) {
            this.bSi.a(this.bSh.ago(), this.bRX);
        }
        boolean z = false;
        if (this.bRX != null) {
            z = this.bRX.blp();
        }
        dH(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hQ(int i) {
        cm cmVar = null;
        acg();
        acp();
        try {
            if (this.bRX != null) {
                this.bRW.a((ArrayList<com.baidu.adp.widget.ListView.v>) null, this.bRX);
                this.bSi.iK(1);
                this.bRW.acX();
                this.bSm.a(this.bRW.acW(), this.bRX, this.bSh.agx());
                com.baidu.tieba.frs.tab.i a2 = a(this.bSm.aeI(), this.bRX.bkD());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    cmVar = new cm();
                    cmVar.bVI = a2.url;
                    cmVar.stType = a2.name;
                }
                this.bSh.a(this.bRX.bkD(), 0, cmVar);
                this.bSm.eh(false);
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
            if (iVar != null && iVar.chD == i) {
                return iVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z, boolean z2) {
        try {
            if (this.bRX != null && this.bSm != null && this.bSh != null) {
                if (this.bRX.aOk() != null) {
                    this.bRN = this.bRX.aOk().getName();
                    this.forumId = this.bRX.aOk().getId();
                }
                if (z) {
                    dG(true);
                } else {
                    dG(this.bSg);
                }
                acg();
                if (this.bRX.blp()) {
                    this.bSm.a(this.bRW.acW(), this.bRX, this.bSh.agx());
                }
                if (this.bSu != null) {
                    this.bSu.a(this.bSi, this.bRX);
                }
                if (this.bRX.getPage() != null) {
                    setHasMore(this.bRX.getPage().qD());
                }
                ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bSC.a(z2, true, this.bRX.getThreadList(), null);
                if (a2 != null) {
                    this.bRX.aD(a2);
                }
                if (this.bSh.ags() == 1) {
                    ack();
                }
                this.bRQ = this.bRX.agu();
                if (this.bRS != null) {
                    this.bRR = true;
                    this.bRS.sb(this.bRQ);
                    com.baidu.tieba.frs.utils.a.a(this.bRX.aOk(), this.bRX.getThreadList(), this.bRR, getPn());
                }
                if (this.bSx != null) {
                    this.bSx.eu(this.bSh.agD());
                    this.bSx.ai(this.bSm.aeJ());
                }
                acd();
                if (this.bRX.aOk() != null) {
                    this.bSj.ex(this.bRX.aOk().isLike() == 1);
                }
                if (this.bRW.acP() != null && this.mIsLogin) {
                    this.bRW.acP().setVisibility(0);
                }
                if (this.bSk != null && this.mIsLogin) {
                    this.bSk.ei(true);
                }
                if (this.bSk != null && !this.bSk.aeT()) {
                    if (this.bSh.ags() == 1) {
                        this.bRW.dM(true);
                    } else {
                        this.bRW.dM(false);
                    }
                }
                if (this.bRX.aOk().isIs_forbidden() == 1) {
                    this.bSj.ez(false);
                } else {
                    this.bSj.ez(true);
                }
                this.bRW.n(true, false);
                this.bSj.ey(this.bRX.bkg() == 1);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.n nVar) {
        try {
            if (!this.bSc && nVar != null && this.bRX != null) {
                this.bRX.d(nVar);
                m(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void dH(boolean z) {
        if (this.bSh != null) {
            g(z, this.bSh.ago());
        } else {
            g(z, "normal_page");
        }
    }

    private void g(boolean z, String str) {
        if (!ach()) {
            if (this.bSz == null) {
                dI("frs_page".equals(str));
            } else {
                dI(true);
            }
        }
        if (this.bSu != null) {
            this.bSu.a(z, this.bSm, this.bSi, this.bRW, this.bRX);
        }
    }

    public boolean ach() {
        return this.bSA != null && this.bSA.ach();
    }

    public void dI(boolean z) {
        if (this.bSD != null) {
            this.bSD.b(this.bRW, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bJR = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            j(intent);
        } else {
            this.bJR = System.currentTimeMillis();
        }
        this.RA = System.currentTimeMillis();
        this.aCD = this.RA - this.bJR;
        if (!com.baidu.tieba.frs.utils.r.a(this, getForumName(), "from", getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.RA;
            return;
        }
        super.onCreate(bundle);
        this.bRS = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.fBQ);
        this.bSh = new com.baidu.tieba.frs.e.i(this, this.bSM);
        this.bSh.a(this.bSH);
        this.bSh.init();
        if (getIntent() != null) {
            this.bSh.d(getIntent().getExtras());
        } else if (bundle != null) {
            this.bSh.d(bundle);
        } else {
            this.bSh.d((Bundle) null);
        }
        this.bRI = new com.baidu.tieba.frs.entelechy.i();
        this.bSu = this.bRI.aeh();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(r.h.frs_activity, (ViewGroup) null);
        this.bSk = new com.baidu.tieba.frs.j.w(this, this.bRI.aeg());
        this.bSj = new com.baidu.tieba.frs.j.af(this);
        this.bSk.a(getPageContext().getPageActivity(), inflate, this.bSj.ahF().getView());
        this.bSi = new com.baidu.tieba.frs.j.n(this, this.bRI);
        this.bSm = this.bRI.C(this);
        this.bRW = new au(this, this.bSS, this.bRI);
        this.bSi.a(this.bRW.Kp());
        this.bSA = new com.baidu.tieba.frs.j.ai(this, this.bRW, this.bSm, this.bSi);
        this.bSm.ae(this.bRW.adf());
        if (getIntent() != null) {
            this.bSi.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.bSi.f(bundle);
        } else {
            this.bSi.f((Bundle) null);
        }
        this.bRV = getVoiceManager();
        this.bRV.onCreate(getPageContext());
        initUI();
        initData(bundle);
        this.bSs = new ch(getActivity(), this.bRW, this.bSi);
        this.bSs.a(this.bSU);
        this.bSs.dW(true);
        new com.baidu.tieba.frs.e.r();
        this.bSC = new com.baidu.tieba.frs.e.h(this, this.bSO);
        this.bSp = new com.baidu.tieba.frs.g.d(this);
        this.bSD = new com.baidu.tieba.frs.j.y(this);
        addGlobalLayoutListener();
        this.createTime = System.currentTimeMillis() - this.RA;
        this.bSF = new com.baidu.tieba.frs.acrossForum.c(this, this.bSz);
        if (this.bSz != null) {
            this.bSi.b(this.bSz);
            this.bSy = new com.baidu.tieba.frs.acrossForum.j(getPageContext(), this.bSA, this.bSi, this.bRX);
            this.bSs.a(this.bSy.adU());
            com.baidu.tieba.frs.acrossForum.a.adR().jY("across_sign");
        }
        this.bSx = new com.baidu.tieba.frs.j.a(getPageContext(), this.bSh.agz());
        this.bSr = new com.baidu.tieba.frs.headvideo.b(this.bSi);
        this.bSq = new com.baidu.tieba.frs.e.d(this);
        this.bSB = new com.baidu.tieba.frs.e.k(this);
        this.bSn = new com.baidu.tieba.frs.e.p(this);
        this.bSo = new com.baidu.tieba.frs.e.b(this);
        this.bSE = new com.baidu.tieba.frs.e.a(this);
        this.bSE.b(this.bSz);
        registerListener(this.mMemListener);
        registerListener(this.bSK);
        registerListener(this.aXH);
        registerListener(this.bSL);
        registerListener(this.bSP);
        registerListener(this.bSJ);
        registerListener(this.bSN);
        registerListener(this.bSR);
        registerListener(this.bSG);
        showLoadingView(this.bRW.adf(), true);
        this.bRW.dQ(false);
        this.bSh.D(3, true);
    }

    private void j(Intent intent) {
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.bRN = data.getQueryParameter("name");
            this.adE = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.bRN)) {
                intent.putExtra("name", this.bRN);
            }
            if (!StringUtils.isNull(this.adE)) {
                intent.putExtra("from", this.adE);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.bRN)) {
            this.bRN = com.baidu.tieba.frs.utils.u.k(intent);
            if (!StringUtils.isNull(this.bRN)) {
                intent.putExtra("name", this.bRN);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.bRV = getVoiceManager();
        this.bRV.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bSW);
        if (bundle != null) {
            this.bRN = bundle.getString("name");
            this.adE = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
            try {
                this.bSz = (AcrossForumViewData) bundle.getSerializable(FrsActivityConfig.ACROSS_FROUM_DATA);
            } catch (Exception e) {
            }
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bRN = intent.getStringExtra("name");
                this.adE = intent.getStringExtra("from");
                this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
                try {
                    this.bSz = (AcrossForumViewData) intent.getSerializableExtra(FrsActivityConfig.ACROSS_FROUM_DATA);
                } catch (Exception e2) {
                }
            }
        }
        if (!TextUtils.isEmpty(this.adE) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.adE)) {
            setSwipeBackEnabled(false);
        }
        this.bRY = new br(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            aci();
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.bSW);
        }
        this.bSi.f(bundle);
    }

    public void aci() {
        if (this.bRY != null && this.bRW != null) {
            if (FrsActivityStatic.bTg || FrsActivityStatic.bTh) {
                this.bRY.bi(com.baidu.tbadk.coreExtra.messageCenter.a.yK().getMsgReplyme());
                this.bRY.bh(com.baidu.tbadk.coreExtra.messageCenter.a.yK().getMsgAtme());
                this.bRY.bk(com.baidu.tbadk.coreExtra.messageCenter.a.yK().yR());
                this.bRY.bj(com.baidu.tbadk.coreExtra.messageCenter.a.yK().getMsgChat());
                this.bRW.a(this.bRY);
                this.bSj.a(this.bRY);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.card.bx.Pl().cx(false);
        if (this.bRX != null && this.bRX.aOk() != null) {
            cb.adG().bm(com.baidu.adp.lib.h.b.c(this.bRX.aOk().getId(), 0L));
        }
        if (this.bRW != null) {
            com.baidu.tieba.frs.utils.t.a(this.bRW, this.bRX, getForumId(), false, (com.baidu.tbadk.core.data.bk) null);
            this.bRW.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.bSe != null) {
                this.bSe.onDestroy();
            }
            this.bRW.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.bSh.onActivityDestroy();
        this.bSi.onActivityDestroy();
        this.bRV = getVoiceManager();
        this.bRV.onDestory(getPageContext());
        if (this.bSf != null) {
            this.bSf.cancel(true);
            this.bSf = null;
        }
        if (this.bSh != null) {
            this.bSh.abv();
        }
        if (this.bSj != null) {
            this.bSj.destroy();
        }
        if (this.bSs != null) {
            this.bSs.aac();
        }
        if (this.bSw != null) {
            this.bSw.destory();
        }
        if (this.bSx != null) {
            this.bSx.destory();
        }
        if (this.bSA != null) {
            this.bSA.onDestroy();
        }
        if (this.bSp != null) {
            this.bSp.onDestroy();
        }
        if (this.bSy != null) {
            this.bSy.onDestory();
        }
        com.baidu.tieba.recapp.c.a.beA().beC();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.bRN);
        bundle.putString("from", this.adE);
        this.bSh.onSaveInstanceState(bundle);
        this.bRV = getVoiceManager();
        if (this.bRV != null) {
            this.bRV.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.bSE != null) {
            this.bSE.onActivityResult(i, i2, intent);
        }
    }

    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bSw == null) {
                this.bSw = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bSw.aq(updateAttentionMessage.getData().toUid, getForumId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bRW != null) {
            this.bRW.acT();
            this.bRW.onResume();
            com.baidu.tieba.frs.utils.u.q(this.bRW);
        }
        this.bSm.a(this.bSI);
        this.bSn.es(true);
        this.bSg = true;
        if (this.bSr != null) {
            this.bSr.er(false);
        }
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.bRW.kv();
        } else if (bRK) {
            bRK = false;
            this.bRW.kv();
        } else {
            this.bRV = getVoiceManager();
            this.bRV.onResume(getPageContext());
            this.bRW.dT(false);
            registerListener(this.bSQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.bRW.dR(z);
        this.bSk.ei(z);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.bRN = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.adE = intent.getStringExtra("from");
            }
            this.bRP = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.bRP) {
                dJ(intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false));
            }
        }
    }

    private void dJ(boolean z) {
        this.bRW.kv();
        this.bSk.ek(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        com.baidu.tieba.frs.utils.u.a(this, getIntent(), this.adE);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.bRW.setTitle(this.bRN);
        } else {
            this.bRW.setTitle("");
            this.mFlag = 1;
        }
        this.bSi.c(this.bRW.acW());
        this.bRW.a(this.bSX);
        this.bRW.a(this.bSY);
        this.bRW.setOnScrollListener(this.bST);
        this.bRW.g(this.aTn);
        this.bRW.ade().a(this.bSV);
        if (!this.mIsLogin) {
            this.bRW.dR(false);
            this.bSk.ei(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bRW.onChangeSkinType(i);
        this.bSj.a(getPageContext(), i);
        this.bSi.a(getPageContext(), i);
        this.bSm.onChangeSkinType(i);
        changeSwipeSkinType(i);
        if (this.bSy != null) {
            this.bSy.tB();
        }
    }

    @Override // com.baidu.adp.widget.f.c
    public void ld() {
        setSwipeBackEnabled(true);
        this.bSk.ei(true);
    }

    @Override // com.baidu.adp.widget.f.c
    public void le() {
        setSwipeBackEnabled(false);
        this.bSk.ei(false);
    }

    public void hR(int i) {
        if (!this.mIsLogin) {
            if (this.bRX != null && this.bRX.qs() != null) {
                this.bRX.qs().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.bRX != null) {
            if (i == 0) {
                if (!this.bRL) {
                    com.baidu.tieba.frs.utils.w.b(this, 0);
                    return;
                }
                TiebaStatic.log("c10152");
                com.baidu.tieba.frs.utils.w.b(this, 4);
                return;
            }
            this.bRW.acV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.baidu.tbadk.core.data.bk bkVar) {
        boolean z = bkVar == null || bkVar.sE();
        this.bRW.a(new v(this, bkVar));
        this.bRW.b(bkVar, z);
    }

    public void refresh() {
        cj(3);
    }

    public void cj(int i) {
        this.bSc = false;
        acp();
        if (this.bRW.Kp() != null) {
            this.bRW.Kp().aro();
        }
        this.bSh.D(i, true);
    }

    private void acj() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.h.k.eH().f(new w(this));
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ack() {
        acp();
        try {
            if (this.bRX != null) {
                this.bRW.Km();
                this.bSF.aaf();
                if (this.bSy != null) {
                    this.bSy.c(this.bRX);
                }
                if (this.bSk != null && !this.bSk.aeT()) {
                    if (this.bSh.ags() == 1) {
                        this.bRW.dM(true);
                    } else {
                        this.bRW.dM(false);
                    }
                }
                if (!ach() && com.baidu.tieba.frs.j.n.m(this.bRX) && !com.baidu.tieba.frs.j.n.l(this.bRX)) {
                    this.bRW.ado();
                }
                if (this.bRX.aOk() != null) {
                    this.bRN = this.bRX.aOk().getName();
                    this.forumId = this.bRX.aOk().getId();
                }
                if (this.bRX.getPage() != null) {
                    setHasMore(this.bRX.getPage().qD());
                }
                this.bRW.setTitle(this.bRN);
                this.bRW.setForumName(this.bRN);
                TbadkCoreApplication.m9getInst().setDefaultBubble(this.bRX.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(this.bRX.getUserData().getBimg_end_time());
                acj();
                acl();
                ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bRX.getThreadList();
                if (threadList != null) {
                    this.bRW.a(threadList, this.bRX);
                    com.baidu.tieba.frs.utils.e.p(this.bRW);
                    this.bSi.iK(getPageNum());
                    this.bSi.i(this.bRX);
                    this.bSm.a(this.bRW.acW(), this.bRX, this.bSh.agx());
                    this.bRW.acX();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void acl() {
        if (this.bRX != null) {
            if (this.bRX.aOu() == 1) {
                this.bRW.ade().setFromCDN(true);
            } else {
                this.bRW.ade().setFromCDN(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bSn.es(false);
        this.bSg = false;
        this.bRW.onPause();
        this.bRV = getVoiceManager();
        this.bRV.onPause(getPageContext());
        this.bRW.dT(true);
        if (this.bSx != null) {
            this.bSx.ahb();
        }
        if (this.bSr != null) {
            this.bSr.er(true);
        }
        MessageManager.getInstance().unRegisterListener(this.bSQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.bx.Pl().cx(false);
        if (this.bRX != null && this.bRX.aOk() != null) {
            com.baidu.tbadk.distribute.a.Cx().b(getPageContext().getPageActivity(), "frs", this.bRX.aOk().getId(), 0L);
        }
        this.bRV = getVoiceManager();
        if (this.bRV != null) {
            this.bRV.onStop(getPageContext());
        }
        com.baidu.tieba.frs.utils.u.d(getListView());
        this.bSi.onActivityStop();
        com.baidu.tbadk.util.r.Hh();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.bRO) {
            if (i == 4) {
                if (this.bSk.aeT()) {
                    this.bSk.ej(true);
                    if (this.bSj.ahF().adM()) {
                        this.bSj.ahF().eb(false);
                        refresh();
                        return true;
                    }
                    return true;
                } else if (ach()) {
                    this.bSA.ahN();
                    return true;
                } else if (this.bRW.acS()) {
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

    public boolean acm() {
        if (this.bSl == null) {
            return false;
        }
        return this.bSl.isShowing();
    }

    public void acn() {
        this.bSf = com.baidu.tieba.frs.utils.r.b(this, this.bRN);
    }

    @Override // com.baidu.tieba.recapp.b
    public BaseActivity<?> getContext() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.b
    public void a(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.Cx().a(cVar, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.b
    public void aco() {
        abS().aco();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bRV == null) {
            this.bRV = VoiceManager.instance();
        }
        return this.bRV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: PW */
    public BdListView getListView() {
        if (this.bRW == null) {
            return null;
        }
        return this.bRW.acW();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void acp() {
        this.bRV = getVoiceManager();
        this.bRV.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> wS() {
        if (this.ahK == null) {
            this.ahK = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.ahK;
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
            if (this.bRY != null) {
                this.bRY.bi(msgReplyme);
                this.bRY.bh(msgAtme);
                this.bRY.bl(msgOfficialMerge);
                this.bRY.bj(msgChat);
                this.bRY.bk(msgStrangerChat);
                this.bRW.a(this.bRY);
                this.bSj.a(this.bRY);
            }
        }
    }

    public void acq() {
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
                if (bdUniqueId == bi.bUO) {
                    if (FrsActivity.this.bRW != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11752").ab("fid", FrsActivity.this.forumId).ab("obj_locate", "1"));
                        FrsActivity.this.bRW.kv();
                    }
                } else if (vVar != null && (vVar instanceof com.baidu.tbadk.core.data.bk)) {
                    com.baidu.tbadk.core.data.bk bkVar = (com.baidu.tbadk.core.data.bk) vVar;
                    if (bkVar.sz() == null || bkVar.sz().getGroup_id() == 0 || FrsActivity.this.checkUpIsLogin()) {
                        if ((bkVar.ss() != 1 && bkVar.ss() != 2) || FrsActivity.this.checkUpIsLogin()) {
                            if (bkVar.sb() != null) {
                                if (FrsActivity.this.checkUpIsLogin()) {
                                    String postUrl = bkVar.sb().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.gD()) {
                                        com.baidu.tbadk.browser.f.v(FrsActivity.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bkVar.sK() != null) {
                                com.baidu.tbadk.core.data.n sK = bkVar.sK();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsActivity.this.getPageContext().getPageActivity(), sK.getCartoonId(), sK.getChapterId(), 2)));
                            } else if (bkVar.getThreadType() == 47 && bkVar.rL() == 1 && !com.baidu.tbadk.core.util.ax.isEmpty(bkVar.rV())) {
                                com.baidu.tbadk.browser.f.u(FrsActivity.this.getPageContext().getPageActivity(), bkVar.rV());
                            } else {
                                com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.rP(bkVar.getId())) {
                                    readThreadHistory.rO(bkVar.getId());
                                }
                                boolean z = false;
                                String rV = bkVar.rV();
                                if (rV != null && !rV.equals("")) {
                                    z = true;
                                    new Thread(new ae(this, rV)).start();
                                }
                                String tid = bkVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bkVar.rL() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.bf vP = com.baidu.tbadk.core.util.bf.vP();
                                    TbPageContext<?> pageContext = FrsActivity.this.getPageContext();
                                    String[] strArr = new String[3];
                                    strArr[0] = tid;
                                    strArr[1] = "";
                                    vP.c(pageContext, strArr);
                                    return;
                                }
                                boolean z2 = false;
                                if (bkVar instanceof com.baidu.tbadk.core.data.aa) {
                                    z2 = true;
                                    TiebaStatic.log("c10769");
                                }
                                if (bkVar.getThreadType() == 33 || (bkVar instanceof com.baidu.tbadk.core.data.av)) {
                                    if (!z2) {
                                        if (bkVar.getThreadType() == 33) {
                                            str = "c10245";
                                        } else {
                                            str = "c10180";
                                        }
                                        if (FrsActivity.this.bSh.ags() == 5) {
                                            str = "c10387";
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.av(str).ab("fid", FrsActivity.this.forumId));
                                    }
                                    com.baidu.tieba.frs.utils.u.d(FrsActivity.this, bkVar);
                                    if (FrsActivity.this.bRX != null && FrsActivity.this.bRX.aOk() != null) {
                                        com.baidu.tieba.frs.h.a aVar = new com.baidu.tieba.frs.h.a();
                                        aVar.chc = FrsActivity.this.bRX.fzN == 1;
                                        aVar.che = FrsActivity.this.bRX.aOk().getId();
                                        aVar.chd = FrsActivity.this.abS().agx();
                                        com.baidu.tieba.frs.h.b.agV().a(aVar, bkVar, 1);
                                        return;
                                    }
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bkVar.setId(tid.substring(3));
                                }
                                if (!z2 && FrsActivity.this.bSh.ags() == 2) {
                                    com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10077");
                                    avVar.s("obj_source", FrsActivity.this.bSh.ags());
                                    avVar.ab("tid", bkVar.getId());
                                    avVar.ab("fid", FrsActivity.this.getForumId());
                                    TiebaStatic.log(avVar);
                                }
                                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.bk.UW.getId()) {
                                    com.baidu.tieba.frs.utils.t.a(bkVar.rz());
                                    com.baidu.tieba.frs.utils.u.c(FrsActivity.this, bkVar);
                                    return;
                                }
                                com.baidu.tieba.frs.utils.u.a(FrsActivity.this, bkVar, i, z);
                                com.baidu.tieba.frs.utils.t.a(FrsActivity.this, FrsActivity.this.bRX, bkVar);
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
            hideNetRefreshView(this.bRW.adf());
            showLoadingView(this.bRW.adf(), true);
            this.bRW.dQ(false);
            this.bRW.kv();
        }
    }

    public com.baidu.tieba.tbadkCore.p acr() {
        return this.bRX;
    }

    public boolean acs() {
        return this.bRW.acs();
    }

    public void act() {
        FrsActivityStatic.bTg = false;
        FrsActivityStatic.bTh = false;
        aci();
    }

    public void K(Object obj) {
        if (this.bSq != null && this.bSq.cgd != null) {
            this.bSq.cgd.g(obj);
        }
    }

    public void L(Object obj) {
        if (this.bSq != null && this.bSq.cge != null) {
            this.bSq.cge.g(obj);
        }
    }

    public void acu() {
        this.bSi.acu();
    }

    public com.baidu.tieba.frs.ecomm.a acv() {
        if (this.bSv == null) {
            this.bSv = com.baidu.tieba.frs.utils.u.F(this);
        }
        return this.bSv;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        if (!com.baidu.adp.lib.util.k.gD()) {
            this.bRW.adj();
        } else if (this.bSh.ags() == 1) {
            JI();
            acw();
        } else if (this.bSh.hasMore()) {
            acw();
        }
    }

    public void jU(String str) {
        JI();
        showToast(str);
    }

    public void M(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        JI();
        if (!com.baidu.tbadk.core.util.x.t(arrayList)) {
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bSC.a(false, false, arrayList, this.bRS);
            if (a2 != null) {
                this.bRX.aD(a2);
                this.bRW.a(a2, this.bRX);
            }
            if (this.bSh != null) {
                com.baidu.tieba.frs.h.b.a(this.bRX, this.bSh.agx(), 2);
            }
        }
    }

    private void JI() {
        if (acb() == 1 || this.bSC.aA(this.bRX.bkn())) {
            this.bRW.adi();
        } else if (com.baidu.tbadk.core.util.x.t(this.bRX.getThreadList())) {
            this.bRW.adj();
        } else {
            this.bRW.JM();
        }
    }

    public void acw() {
        if (this.bSC != null) {
            this.bSC.a(this.bRN, this.forumId, this.bRX);
        }
    }

    public boolean acx() {
        return this.bSj.ahF().adM();
    }

    public void dK(boolean z) {
        this.bSj.ahF().eb(z);
    }

    public void acy() {
        if (!com.baidu.tbadk.core.util.ae.d(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.as.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a006";
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.baidu.tieba.frs.utils.u.a(this, i, strArr, iArr);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    public void acz() {
        if (this.bSx != null) {
            this.bSx.ahb();
        }
    }

    public void jV(String str) {
        if (this.bsc == null) {
            this.bsc = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.bsc.dY(str);
        this.bsc.aI(true);
    }

    public void dL(boolean z) {
        if (this.bSA != null) {
            this.bSA.dL(z);
        }
        if (this.bSs != null) {
            this.bSs.dW(z);
        }
    }
}
