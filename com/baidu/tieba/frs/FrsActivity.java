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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FrsActivity extends BaseActivity<FrsActivity> implements a.InterfaceC0000a, BdListView.e, f.c, UserIconBox.b, VoiceManager.c, b, cd, com.baidu.tieba.frs.mc.t, com.baidu.tieba.recapp.m {
    private com.baidu.adp.lib.e.b<TbImageView> agy;
    private com.baidu.tieba.tbadkCore.data.e bFB;
    private VoiceManager bFE;
    private bo bFH;
    private q.a bFO;
    private FrsModelController bFQ;
    private com.baidu.tieba.frs.f.u bFR;
    private com.baidu.tieba.frs.f.am bFS;
    private com.baidu.tieba.frs.f.ad bFT;
    private com.baidu.tieba.frs.view.q bFU;
    private com.baidu.tieba.frs.entelechy.b.d bFV;
    private com.baidu.tieba.frs.mc.n bFW;
    private com.baidu.tieba.frs.mc.b bFX;
    private com.baidu.tieba.frs.smartsort.c bFY;
    private com.baidu.tieba.frs.mc.d bFZ;
    private com.baidu.tieba.frs.entelechy.b.a bFr;
    private boolean bFu;
    public com.baidu.tbadk.core.data.bh bFv;
    private com.baidu.tieba.frs.headvideo.b bGa;
    private ce bGb;
    private com.baidu.tieba.frs.entelechy.b.b bGd;
    private com.baidu.tbadk.e.a bGe;
    private com.baidu.tieba.frs.f.a bGf;
    private com.baidu.tieba.frs.f.aq bGg;
    private com.baidu.tieba.frs.mc.j bGh;
    private com.baidu.tieba.frs.mc.h bGi;
    private com.baidu.tieba.frs.f.af bGj;
    private com.baidu.tieba.frs.mc.a bGk;
    private aw bGl;
    public com.baidu.tieba.frs.f.f bGm;
    private static final int bFp = (com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst()) - com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.f.ds100)) - com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.f.ds90);
    private static final int bFq = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.f.ds300);
    private static boolean isNeedRefreshOnResume = false;
    public static boolean bFt = false;
    public static volatile long bFI = 0;
    public static volatile long bFJ = 0;
    public static volatile int bFK = 0;
    public boolean bFs = false;
    public String bFw = null;
    public String aci = null;
    public int mFlag = 0;
    private boolean bFx = false;
    private boolean bFy = false;
    private String mThreadId = null;
    private String forumId = null;
    private int bFz = 0;
    private boolean bFA = false;
    private boolean bFC = false;
    private boolean bFD = false;
    private ax bFF = null;
    public final com.baidu.tbadk.core.data.bh aLS = null;
    private com.baidu.tieba.tbadkCore.n bFG = new com.baidu.tieba.tbadkCore.n();
    public long bxH = -1;
    public long aAX = 0;
    public long aAP = 0;
    public long createTime = 0;
    public long QG = -1;
    private boolean bFL = false;
    private boolean bFM = false;
    public com.baidu.tbadk.performanceLog.e bFN = null;
    private boolean bFP = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> bGc = new SparseArray<>();
    private boolean brg = true;
    private final CustomMessageListener bGn = new d(this, CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED);
    private final cc bGo = new o(this);
    private cb bGp = new aa(this);
    private CustomMessageListener bGq = new ab(this, CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT);
    private CustomMessageListener bGr = new ac(this, CmdConfigCustom.CMD_FRS_TAB_LIVE_START);
    private final CustomMessageListener bGs = new ad(this, CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB);
    private final CustomMessageListener bGt = new ae(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    public final CustomMessageListener bGu = new af(this, CmdConfigCustom.MSG_NEW);
    private final CustomMessageListener bGv = new ag(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    public final com.baidu.tieba.tbadkCore.p bGw = new e(this);
    private final CustomMessageListener bGx = new f(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private final CustomMessageListener mMemListener = new g(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private CustomMessageListener bGy = new h(this, CmdConfigCustom.CMD_DRIFTING_BOTTLE_CLEAR_MESSAGE);
    private final com.baidu.tieba.frs.mc.s bGz = new i(this);
    public final View.OnTouchListener aIu = new j(this);
    private final CustomMessageListener bGA = new k(this, CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE);
    private final CustomMessageListener bGB = new l(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);
    private final com.baidu.adp.framework.listener.a bGC = new m(this, CmdConfigHttp.CMD_SET_COMMON_FORUM_STATE, 309365);
    public final View.OnClickListener bGD = new n(this);
    private final AbsListView.OnScrollListener bGE = new p(this);
    private final com.baidu.tbadk.util.e<Boolean> bGF = new q(this);
    private final ar bGG = new r(this);
    private final NoNetworkView.a bEW = new t(this);
    private final CustomMessageListener bGH = new u(this, 0);
    private com.baidu.adp.widget.ListView.w bGI = new a(this, null);
    private com.baidu.adp.widget.ListView.x bGJ = new v(this);
    private cc bGK = new w(this);

    public com.baidu.tieba.frs.f.aq Xr() {
        return this.bGg;
    }

    public com.baidu.tieba.frs.entelechy.b.b Xs() {
        return this.bGd;
    }

    public com.baidu.adp.widget.ListView.w Xt() {
        return this.bGI;
    }

    public com.baidu.adp.widget.ListView.x Xu() {
        return this.bGJ;
    }

    public com.baidu.tieba.frs.mc.j Xv() {
        return this.bGh;
    }

    public com.baidu.tieba.frs.headvideo.b Xw() {
        return this.bGa;
    }

    public com.baidu.tieba.frs.smartsort.c Xx() {
        return this.bFY;
    }

    @Override // com.baidu.tieba.frs.mc.t
    public FrsModelController Xy() {
        return this.bFQ;
    }

    public com.baidu.tieba.frs.f.ad Xz() {
        return this.bFT;
    }

    public com.baidu.tieba.frs.f.am XA() {
        return this.bFS;
    }

    public com.baidu.tieba.frs.mc.h XB() {
        return this.bGi;
    }

    @Override // com.baidu.tieba.frs.mc.t
    public com.baidu.tieba.frs.f.u XC() {
        return this.bFR;
    }

    public com.baidu.tieba.frs.entelechy.b.d XD() {
        return this.bFV;
    }

    public ce XE() {
        return this.bGb;
    }

    @Override // com.baidu.tieba.frs.mc.t
    public ax XF() {
        return this.bFF;
    }

    @Override // com.baidu.tieba.frs.cd
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.cd
    public String getForumName() {
        return this.bFw;
    }

    public void setForumName(String str) {
        this.bFw = str;
    }

    public void setFrom(String str) {
        this.aci = str;
    }

    public String getFrom() {
        return this.aci;
    }

    public void setFlag(int i) {
        this.mFlag = i;
    }

    @Override // com.baidu.tieba.recapp.m
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.m
    public com.baidu.adp.widget.ListView.a k(BdUniqueId bdUniqueId) {
        return c.Xq().b(this, bdUniqueId);
    }

    @Override // com.baidu.tieba.recapp.m
    public int getPageNum() {
        if (this.bGi == null) {
            return 1;
        }
        return this.bGi.getPn();
    }

    public int getPn() {
        if (this.bGi == null) {
            return 1;
        }
        return this.bGi.getPn();
    }

    public void setPn(int i) {
        if (this.bGi != null) {
            this.bGi.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.bGi != null) {
            this.bGi.setHasMore(i);
        }
    }

    public int XG() {
        if (this.bGi == null) {
            return -1;
        }
        return this.bGi.XG();
    }

    public boolean XH() {
        return this.bFD;
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
        if (this.bFF.Yr() != null && !z) {
            this.bFF.Yr().setVisibility(8);
        }
        if (this.bFF.Yu() != null && !z) {
            this.bFF.Yu().setVisibility(8);
        }
        if (this.bFT != null) {
            this.bFT.dX(false);
        }
        if (aVar == null) {
            showNetRefreshView(this.bFF.YI(), getPageContext().getString(r.l.error_unkown_try_again), true);
        } else if (aVar.fmJ) {
            if (340001 == aVar.errorCode) {
                showNetRefreshViewNoClick(this.bFF.YI(), getPageContext().getResources().getString(r.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
            } else {
                showNetRefreshView(this.bFF.YI(), getPageContext().getResources().getString(r.l.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
            }
        } else if (340001 == aVar.errorCode) {
            showNetRefreshViewNoClick(this.bFF.YI(), aVar.errorMsg, true);
        } else {
            showNetRefreshView(this.bFF.YI(), aVar.errorMsg, true);
        }
        setNetRefreshViewEmotionDefMarginTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XI() {
        hideLoadingView(this.bFF.YI());
        this.bFF.cf(false);
        this.bFF.YD();
        if (this.bFF.Yn() instanceof com.baidu.tieba.frs.tab.h) {
            ((com.baidu.tieba.frs.tab.h) this.bFF.Yn()).acA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XJ() {
        if (XG() == 0 && com.baidu.tbadk.core.util.w.s(this.bFG.bfR())) {
            if (com.baidu.tbadk.core.util.w.s(this.bFG.getThreadList())) {
                this.bFF.SI();
                return;
            } else {
                this.bFF.Jv();
                return;
            }
        }
        this.bFF.YL();
    }

    public void a(ErrorData errorData) {
        boolean z = true;
        XI();
        this.bFF.Yy();
        d.a abR = this.bFQ.abR();
        boolean s = com.baidu.tbadk.core.util.w.s(this.bFG.getThreadList());
        if (abR != null && s) {
            if (s) {
                if (this.bFQ.abS() != 0) {
                    this.bFQ.abY();
                    this.bFF.Yy();
                } else {
                    a(abR, false);
                }
                ax axVar = this.bFF;
                if (!this.bFG.bgS() && !XM()) {
                    z = false;
                }
                axVar.o(z, false);
                return;
            } else if (abR.fmJ) {
                this.bFF.o(true, false);
                showToast(getPageContext().getResources().getString(r.l.net_error_text, abR.errorMsg, Integer.valueOf(abR.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(abR, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XK() {
        if (this.bFG == null || this.bFG.aJY() != null) {
            this.bFF.YG();
        } else if (this.bFG.aJY().getYuleData() != null && this.bFG.aJY().getYuleData().sN()) {
            TiebaStatic.log("c10852");
            this.bFF.a(this.bFG.aJY().getYuleData().sO());
        } else {
            this.bFF.YG();
        }
    }

    private void dv(boolean z) {
        if (this.bFQ != null && this.bFG != null && this.bFF != null && z) {
            if (!this.bFQ.acf() && this.bFQ.abU() == 1) {
                if (this.bFF.YH().l(com.baidu.tieba.tbadkCore.ag.foQ)) {
                    this.bFG.bgF();
                }
                if (!this.bFQ.acd()) {
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.bFG.bgL();
                        this.bFG.bgK();
                        this.bFG.bgH();
                    }
                    this.bFG.bgI();
                    this.bFG.bgJ();
                }
                boolean z2 = false;
                if (this.bFF.YH().l(com.baidu.tieba.card.data.r.boJ)) {
                    z2 = this.bFG.bgO();
                }
                if (!z2) {
                    this.bFG.bgN();
                }
                if (TbadkCoreApplication.m9getInst().isRecAppExist()) {
                    this.bFG.g(this);
                }
                if (!this.bFF.YH().l(com.baidu.tbadk.core.data.bh.SA)) {
                    this.bFG.bgC();
                }
                this.bFG.bgP();
                this.bFG.bgQ();
            }
            this.bFG.bgD();
            this.bFG.bgA();
            this.bFG.bgE();
        }
    }

    public boolean XL() {
        if (this.bFV != null && this.bFF != null && !XM()) {
            this.bFV.b(this.bFF.Iv());
        }
        if (this.bFR != null && this.bFQ != null) {
            this.bFR.a(this.bFQ.abQ(), this.bFG);
        }
        boolean z = false;
        if (this.bFG != null) {
            z = this.bFG.bgT();
        }
        dw(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hM(int i) {
        cj cjVar = null;
        XL();
        XU();
        try {
            if (this.bFG != null) {
                this.bFF.a(null, this.bFG);
                this.bFR.iH(1);
                this.bFF.YB();
                this.bFV.a(this.bFF.Iv(), this.bFG, this.bFQ.aca());
                com.baidu.tieba.frs.tab.i a2 = a(this.bFV.aaf(), this.bFG.bgh());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    cjVar = new cj();
                    cjVar.bJi = a2.url;
                    cjVar.stType = a2.name;
                }
                this.bFQ.a(this.bFG.bgh(), 0, cjVar);
                this.bFV.dW(false);
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
            if (iVar != null && iVar.bTA == i) {
                return iVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, boolean z2) {
        try {
            if (this.bFG != null && this.bFV != null && this.bFQ != null) {
                if (!this.bFF.YH().l(com.baidu.tbadk.core.data.bh.SA)) {
                    this.bFG.bgC();
                }
                if (this.bFG.aJY() != null) {
                    this.bFw = this.bFG.aJY().getName();
                    this.forumId = this.bFG.aJY().getId();
                }
                if (z) {
                    dv(true);
                } else {
                    dv(this.bFP);
                }
                XL();
                if (this.bFG.bgT()) {
                    this.bFV.a(this.bFF.Iv(), this.bFG, this.bFQ.aca());
                }
                if (this.bGd != null) {
                    this.bGd.a(this.bFR, this.bFG);
                }
                if (this.bFG.getPage() != null) {
                    setHasMore(this.bFG.getPage().qx());
                }
                ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bGi.a(z2, true, this.bFG.getThreadList(), null);
                if (a2 != null) {
                    this.bFG.ax(a2);
                }
                if (this.bFQ.abU() == 1) {
                    XP();
                }
                this.bFz = this.bFG.abW();
                if (this.bFB != null) {
                    this.bFA = true;
                    this.bFB.rR(this.bFz);
                    com.baidu.tieba.frs.utils.a.a(getPageContext(), this.bFG.aJY(), this.bFG.getThreadList(), this.bFA, getPn());
                }
                if (this.bGf != null) {
                    this.bGf.ce(this.bFQ.acf());
                    this.bGf.an(this.bFV.aag());
                }
                XI();
                if (this.bFG.aJY() != null) {
                    this.bFS.dO(this.bFG.aJY().isLike() == 1);
                }
                if (this.bFF.Yr() != null && this.mIsLogin) {
                    this.bFF.Yr().setVisibility(0);
                }
                if (this.bFT != null && this.mIsLogin) {
                    this.bFT.dX(true);
                }
                if (this.bFT != null && !this.bFT.aaq()) {
                    this.bFF.dB(this.bFQ.abV());
                }
                if (this.bFG.aJY().isIs_forbidden() == 1) {
                    this.bFS.dP(false);
                } else {
                    this.bFS.dP(true);
                }
                this.bFS.em(this.bFG.bfK() == 1);
                this.bFF.o(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.l lVar) {
        try {
            if (!this.bFL && lVar != null && this.bFG != null) {
                this.bFG.d(lVar);
                n(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void dw(boolean z) {
        if (this.bFQ != null) {
            g(z, this.bFQ.abQ());
        } else {
            g(z, "normal_page");
        }
    }

    private void g(boolean z, String str) {
        if (!XM()) {
            dx("frs_page".equals(str));
        }
        if (this.bGd != null) {
            this.bGd.a(z, this.bFV, this.bFR, this.bFF, this.bFG);
        }
    }

    @Override // com.baidu.tieba.frs.mc.t
    public boolean XM() {
        return this.bGg != null && this.bGg.XM();
    }

    public void dx(boolean z) {
        if (this.bGj != null) {
            this.bGj.a(this.bFF, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        this.bxH = System.currentTimeMillis();
        if (intent != null) {
            this.bFC = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.bxH = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            j(intent);
        }
        this.QG = System.currentTimeMillis();
        this.aAP = this.QG - this.bxH;
        super.onCreate(bundle);
        this.bFB = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.fpj);
        this.bFQ = new FrsModelController(this, this.bGw);
        this.bFQ.a(this.bGo);
        this.bFQ.init();
        if (getIntent() != null) {
            this.bFQ.d(getIntent().getExtras());
        } else if (bundle != null) {
            this.bFQ.d(bundle);
        } else {
            this.bFQ.d((Bundle) null);
        }
        this.bFr = new com.baidu.tieba.frs.entelechy.i();
        this.bGd = this.bFr.ZE();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(r.j.frs_activity, (ViewGroup) null);
        this.bFT = new com.baidu.tieba.frs.f.ad(this, this.bFr.ZD());
        this.bFS = new com.baidu.tieba.frs.f.am(this);
        this.bFT.a(getPageContext().getPageActivity(), inflate, this.bFS.adj());
        this.bFR = new com.baidu.tieba.frs.f.u(this, this.bFr);
        this.bFV = this.bFr.C(this);
        this.bFF = new ax(this, this.bGD, this.bFr);
        this.bFR.a(this.bFF.JX());
        this.bGg = new com.baidu.tieba.frs.f.aq(this, this.bFF, this.bFV, this.bFR);
        this.bFV.aj(this.bFF.YI());
        if (getIntent() != null) {
            this.bFR.g(getIntent().getExtras());
        } else if (bundle != null) {
            this.bFR.g(bundle);
        } else {
            this.bFR.g((Bundle) null);
        }
        this.bFE = getVoiceManager();
        this.bFE.onCreate(getPageContext());
        this.bGl = new aw(getPageContext(), this);
        initUI();
        initData(bundle);
        this.bGb = new ce(getActivity(), this.bFF, this.bFR);
        this.bGb.a(this.bGF);
        this.bGb.dL(true);
        new com.baidu.tieba.frs.mc.q();
        this.bGi = new com.baidu.tieba.frs.mc.h(this, this.bGz);
        this.bFY = new com.baidu.tieba.frs.smartsort.c(this);
        this.bGj = new com.baidu.tieba.frs.f.af(this);
        addGlobalLayoutListener();
        this.createTime = System.currentTimeMillis() - this.QG;
        this.bGf = new com.baidu.tieba.frs.f.a(getPageContext(), this.bFQ.acc());
        this.bGa = new com.baidu.tieba.frs.headvideo.b(this.bFR);
        this.bFZ = new com.baidu.tieba.frs.mc.d(this);
        this.bGh = new com.baidu.tieba.frs.mc.j(this);
        this.bFW = new com.baidu.tieba.frs.mc.n(this);
        this.bFX = new com.baidu.tieba.frs.mc.b(this);
        this.bGk = new com.baidu.tieba.frs.mc.a(this);
        this.bGm = new com.baidu.tieba.frs.f.f(this);
        registerListener(this.mMemListener);
        registerListener(this.bGu);
        registerListener(this.bGv);
        registerListener(this.bGA);
        registerListener(this.bGt);
        registerListener(this.bGx);
        registerListener(this.bGq);
        registerListener(this.bGr);
        registerListener(this.bGs);
        registerListener(this.bGC);
        registerListener(this.bGn);
        registerListener(this.bGy);
        showLoadingView(this.bFF.YI(), true);
        this.bFF.dE(false);
        this.bFQ.p(3, true);
    }

    private void j(Intent intent) {
        if (intent != null) {
            if (!com.baidu.tieba.frs.utils.q.a(this, getForumName(), "from", intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
                finish();
                return;
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            this.bFw = data.getQueryParameter("name");
            this.aci = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.bFw)) {
                intent.putExtra("name", this.bFw);
            }
            if (!StringUtils.isNull(this.aci)) {
                intent.putExtra("from", this.aci);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.bFw)) {
            this.bFw = com.baidu.tieba.frs.utils.t.k(intent);
            if (!StringUtils.isNull(this.bFw)) {
                intent.putExtra("name", this.bFw);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.bFE = getVoiceManager();
        this.bFE.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bGH);
        if (bundle != null) {
            this.bFw = bundle.getString("name");
            this.aci = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bFw = intent.getStringExtra("name");
                this.aci = intent.getStringExtra("from");
                this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.aci) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aci)) {
            setSwipeBackEnabled(false);
        }
        this.bFH = new bo(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            XN();
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.bGH);
        }
        this.bFR.g(bundle);
    }

    public void XN() {
        if (this.bFH != null && this.bFF != null) {
            if (FrsActivityStatic.bGR || FrsActivityStatic.bGS) {
                this.bFH.aR(com.baidu.tbadk.coreExtra.messageCenter.a.yt().getMsgReplyme());
                this.bFH.aQ(com.baidu.tbadk.coreExtra.messageCenter.a.yt().getMsgAtme());
                this.bFH.aT(com.baidu.tbadk.coreExtra.messageCenter.a.yt().yA());
                this.bFH.aS(com.baidu.tbadk.coreExtra.messageCenter.a.yt().getMsgChat());
                this.bFF.a(this.bFH);
                this.bFS.a(this.bFH);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.card.cc.Rx().cN(false);
        if (this.bFG != null && this.bFG.aJY() != null) {
            by.Zg().aV(com.baidu.adp.lib.g.b.c(this.bFG.aJY().getId(), 0L));
        }
        if (this.bFF != null) {
            com.baidu.tieba.frs.utils.s.a(this.bFF, this.bFG, getForumId(), false, null);
            this.bFF.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.bFN != null) {
                this.bFN.onDestroy();
            }
            this.bFF.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.bFQ.onActivityDestroy();
        this.bFR.onActivityDestroy();
        this.bFE = getVoiceManager();
        this.bFE.onDestory(getPageContext());
        if (this.bFO != null) {
            this.bFO.cancel(true);
            this.bFO = null;
        }
        if (this.bFQ != null) {
            this.bFQ.Me();
        }
        if (this.bFS != null) {
            this.bFS.destroy();
        }
        if (this.bGb != null) {
            this.bGb.VK();
        }
        if (this.bGe != null) {
            this.bGe.destory();
        }
        if (this.bGf != null) {
            this.bGf.destory();
        }
        if (this.bGg != null) {
            this.bGg.onDestroy();
        }
        if (this.bFY != null) {
            this.bFY.onDestroy();
        }
        com.baidu.tieba.recapp.c.a.bad().baf();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.bFw);
        bundle.putString("from", this.aci);
        this.bFQ.onSaveInstanceState(bundle);
        this.bFE = getVoiceManager();
        if (this.bFE != null) {
            this.bFE.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.bGk != null) {
            this.bGk.onActivityResult(i, i2, intent);
        }
    }

    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bGe == null) {
                this.bGe = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bGe.aq(updateAttentionMessage.getData().toUid, getForumId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bFF != null) {
            this.bFF.Yy();
            this.bFF.onResume();
            com.baidu.tieba.frs.utils.t.l(this.bFF);
        }
        this.bFV.a(this.bGp);
        this.bFW.eh(true);
        this.bFP = true;
        if (this.bGa != null) {
            this.bGa.eg(false);
        }
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.bFF.startPullRefresh();
        } else if (bFt) {
            bFt = false;
            this.bFF.startPullRefresh();
        } else {
            this.bFE = getVoiceManager();
            this.bFE.onResume(getPageContext());
            this.bFF.dH(false);
            registerListener(this.bGB);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.bFF.dF(z);
        this.bFT.dX(z);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.bFw = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.aci = intent.getStringExtra("from");
            }
            this.bFy = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.bFy) {
                dy(intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false));
            }
        }
    }

    private void dy(boolean z) {
        this.bFF.startPullRefresh();
        this.bFT.dZ(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        com.baidu.tieba.frs.utils.t.a(this, getIntent(), this.aci);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.bFF.setTitle(this.bFw);
        } else {
            this.bFF.setTitle("");
            this.mFlag = 1;
        }
        this.bFR.d(this.bFF.Iv());
        this.bFF.setOnAdapterItemClickListener(this.bGI);
        this.bFF.setOnAdapterItemLongClickListener(this.bGJ);
        this.bFF.setOnScrollListener(this.bGE);
        this.bFF.h(this.bEW);
        this.bFF.YH().a(this.bGG);
        if (!this.mIsLogin) {
            this.bFF.dF(false);
            this.bFT.dX(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bFF.onChangeSkinType(i);
        this.bFS.a(getPageContext(), i);
        this.bFR.a(getPageContext(), i);
        this.bFV.onChangeSkinType(i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.adp.widget.f.c
    public void kV() {
        setSwipeBackEnabled(true);
        this.bFT.dX(true);
    }

    @Override // com.baidu.adp.widget.f.c
    public void kW() {
        setSwipeBackEnabled(false);
        this.bFT.dX(false);
    }

    public void hN(int i) {
        if (!this.mIsLogin) {
            if (this.bFG != null && this.bFG.qm() != null) {
                this.bFG.qm().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.bFG != null) {
            if (i == 0) {
                if (!this.bFu) {
                    com.baidu.tieba.frs.utils.u.b(this, 0);
                    return;
                }
                TiebaStatic.log("c10152");
                com.baidu.tieba.frs.utils.u.b(this, 4);
                return;
            }
            this.bFF.YA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(com.baidu.tbadk.core.data.bh bhVar) {
        boolean z = bhVar == null || bhVar.sl();
        this.bFF.a(new y(this, bhVar));
        this.bFF.b(bhVar, z);
    }

    public void refresh() {
        ck(3);
    }

    public void ck(int i) {
        this.bFL = false;
        XU();
        if (this.bFF.JX() != null) {
            this.bFF.JX().amY();
        }
        this.bFQ.p(i, true);
    }

    private void XO() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.k.eF().f(new z(this));
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XP() {
        XU();
        try {
            if (this.bFG != null) {
                this.bFF.JU();
                if (this.bFT != null && !this.bFT.aaq()) {
                    this.bFF.dB(this.bFQ.abV());
                }
                if (!XM() && com.baidu.tieba.frs.f.u.l(this.bFG) && !com.baidu.tieba.frs.f.u.k(this.bFG)) {
                    this.bFF.YN();
                }
                if (this.bFG.aJY() != null) {
                    this.bFw = this.bFG.aJY().getName();
                    this.forumId = this.bFG.aJY().getId();
                }
                if (this.bFG.getPage() != null) {
                    setHasMore(this.bFG.getPage().qx());
                }
                this.bFF.setTitle(this.bFw);
                this.bFF.setForumName(this.bFw);
                TbadkCoreApplication.m9getInst().setDefaultBubble(this.bFG.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(this.bFG.getUserData().getBimg_end_time());
                XO();
                XQ();
                ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bFG.getThreadList();
                if (threadList != null) {
                    this.bFF.a(threadList, this.bFG);
                    com.baidu.tieba.frs.utils.e.k(this.bFF);
                    this.bFR.iH(getPageNum());
                    this.bFR.h(this.bFG);
                    this.bFV.a(this.bFF.Iv(), this.bFG, this.bFQ.aca());
                    this.bFF.YB();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void XQ() {
        if (this.bFG != null) {
            if (this.bFG.aKk() == 1) {
                this.bFF.YH().setFromCDN(true);
            } else {
                this.bFF.YH().setFromCDN(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bFW.eh(false);
        this.bFP = false;
        this.bFF.onPause();
        this.bFE = getVoiceManager();
        this.bFE.onPause(getPageContext());
        this.bFF.dH(true);
        if (this.bGf != null) {
            this.bGf.acD();
        }
        if (this.bGa != null) {
            this.bGa.eg(true);
        }
        MessageManager.getInstance().unRegisterListener(this.bGB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tieba.card.cc.Rx().cN(false);
        if (this.bFG != null && this.bFG.aJY() != null) {
            com.baidu.tbadk.distribute.a.Cg().b(getPageContext().getPageActivity(), "frs", this.bFG.aJY().getId(), 0L);
        }
        this.bFE = getVoiceManager();
        if (this.bFE != null) {
            this.bFE.onStop(getPageContext());
        }
        com.baidu.tieba.frs.utils.t.d(getListView());
        this.bFR.onActivityStop();
        com.baidu.tbadk.util.r.Gv();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.bFx) {
            if (i == 4) {
                if (this.bFT.aaq()) {
                    this.bFT.dY(true);
                    if (this.bFS.adk().Zp()) {
                        this.bFS.adk().dQ(false);
                        refresh();
                        return true;
                    }
                    return true;
                } else if (XM()) {
                    this.bGg.adt();
                    return true;
                } else if (this.bFF.Yx()) {
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

    public boolean XR() {
        if (this.bFU == null) {
            return false;
        }
        return this.bFU.isShowing();
    }

    public void XS() {
        this.bFO = com.baidu.tieba.frs.utils.q.b(this, this.bFw);
    }

    @Override // com.baidu.tieba.recapp.m
    public BaseActivity<?> getContext() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.m
    public void a(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.Cg().a(cVar, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.m
    public void XT() {
        Xy().XT();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bFE == null) {
            this.bFE = VoiceManager.instance();
        }
        return this.bFE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.bFF == null) {
            return null;
        }
        return this.bFF.Iv();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void XU() {
        this.bFE = getVoiceManager();
        this.bFE.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wA() {
        if (this.agy == null) {
            this.agy = UserIconBox.h(getPageContext().getPageActivity(), 8);
        }
        return this.agy;
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
            if (this.bFH != null) {
                this.bFH.aR(msgReplyme);
                this.bFH.aQ(msgAtme);
                this.bFH.aU(msgOfficialMerge);
                this.bFH.aS(msgChat);
                this.bFH.aT(msgStrangerChat);
                this.bFF.a(this.bFH);
                this.bFS.a(this.bFH);
            }
        }
    }

    public void XV() {
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
                if (bdUniqueId == bj.bIu) {
                    if (FrsActivity.this.bFF != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11752").ab("fid", FrsActivity.this.forumId).ab("obj_locate", "1"));
                        FrsActivity.this.bFF.startPullRefresh();
                    }
                } else if (vVar != null && (vVar instanceof com.baidu.tbadk.core.data.bh)) {
                    com.baidu.tbadk.core.data.bh bhVar = (com.baidu.tbadk.core.data.bh) vVar;
                    if (bhVar.sg() == null || bhVar.sg().getGroup_id() == 0 || FrsActivity.this.checkUpIsLogin()) {
                        if ((bhVar.rZ() != 1 && bhVar.rZ() != 2) || FrsActivity.this.checkUpIsLogin()) {
                            if (bhVar.rJ() != null) {
                                if (FrsActivity.this.checkUpIsLogin()) {
                                    String postUrl = bhVar.rJ().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.gB()) {
                                        com.baidu.tbadk.browser.f.v(FrsActivity.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (bhVar.sr() != null) {
                                com.baidu.tbadk.core.data.o sr = bhVar.sr();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsActivity.this.getPageContext().getPageActivity(), sr.getCartoonId(), sr.getChapterId(), 2)));
                            } else if (bhVar.getThreadType() == 47 && bhVar.rs() == 1 && !com.baidu.tbadk.core.util.at.isEmpty(bhVar.rD())) {
                                com.baidu.tbadk.browser.f.u(FrsActivity.this.getPageContext().getPageActivity(), bhVar.rD());
                            } else {
                                com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.qP(bhVar.getId())) {
                                    readThreadHistory.qO(bhVar.getId());
                                }
                                boolean z = false;
                                String rD = bhVar.rD();
                                if (rD != null && !rD.equals("")) {
                                    z = true;
                                    new Thread(new ah(this, rD)).start();
                                }
                                String tid = bhVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (bhVar.rs() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.ba vt = com.baidu.tbadk.core.util.ba.vt();
                                    TbPageContext<?> pageContext = FrsActivity.this.getPageContext();
                                    String[] strArr = new String[3];
                                    strArr[0] = tid;
                                    strArr[1] = "";
                                    vt.c(pageContext, strArr);
                                    return;
                                }
                                boolean z2 = false;
                                if (bhVar instanceof com.baidu.tbadk.core.data.aa) {
                                    z2 = true;
                                    TiebaStatic.log("c10769");
                                }
                                if (bhVar.getThreadType() == 33 || (bhVar instanceof com.baidu.tbadk.core.data.av)) {
                                    if (!z2) {
                                        if (bhVar.getThreadType() == 33) {
                                            str = "c10245";
                                        } else {
                                            str = "c10180";
                                        }
                                        if (FrsActivity.this.bFQ.abU() == 5) {
                                            str = "c10387";
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar(str).ab("fid", FrsActivity.this.forumId));
                                    }
                                    com.baidu.tieba.frs.utils.t.d(FrsActivity.this, bhVar);
                                    if (FrsActivity.this.bFG != null && FrsActivity.this.bFG.aJY() != null) {
                                        com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                                        aVar.bSZ = FrsActivity.this.bFG.fnk == 1;
                                        aVar.bTb = FrsActivity.this.bFG.aJY().getId();
                                        aVar.bTa = FrsActivity.this.Xy().aca();
                                        com.baidu.tieba.frs.e.b.acx().a(aVar, bhVar, 1);
                                        return;
                                    }
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    bhVar.setId(tid.substring(3));
                                }
                                if (!z2 && FrsActivity.this.bFQ.abU() == 2) {
                                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c10077");
                                    arVar.s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, FrsActivity.this.bFQ.abU());
                                    arVar.ab("tid", bhVar.getId());
                                    arVar.ab("fid", FrsActivity.this.getForumId());
                                    TiebaStatic.log(arVar);
                                }
                                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.bh.TH.getId()) {
                                    com.baidu.tieba.frs.utils.s.a(bhVar.rg());
                                    com.baidu.tieba.frs.utils.t.c(FrsActivity.this, bhVar);
                                    return;
                                }
                                com.baidu.tieba.frs.utils.t.a(FrsActivity.this, bhVar, i, z);
                                com.baidu.tieba.frs.utils.s.a(FrsActivity.this, FrsActivity.this.bFG, bhVar);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.k.gB()) {
            hideNetRefreshView(this.bFF.YI());
            showLoadingView(this.bFF.YI(), true);
            this.bFF.dE(false);
            this.bFF.startPullRefresh();
        }
    }

    public com.baidu.tieba.tbadkCore.n XW() {
        return this.bFG;
    }

    public boolean XX() {
        return this.bFF.XX();
    }

    public void XY() {
        FrsActivityStatic.bGR = false;
        FrsActivityStatic.bGS = false;
        XN();
    }

    public void O(Object obj) {
        if (this.bFZ != null && this.bFZ.bSb != null) {
            this.bFZ.bSb.g(obj);
        }
    }

    public void P(Object obj) {
        if (this.bFZ != null && this.bFZ.bSc != null) {
            this.bFZ.bSc.g(obj);
        }
    }

    public void XZ() {
        this.bFR.XZ();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kp() {
        if (!com.baidu.adp.lib.util.k.gB()) {
            this.bFF.SI();
        } else if (this.bFQ.abU() == 1) {
            Jr();
            Ya();
        } else if (this.bFQ.hasMore()) {
            Ya();
        }
    }

    public void iP(String str) {
        Jr();
        showToast(str);
    }

    public void F(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        Jr();
        if (!com.baidu.tbadk.core.util.w.s(arrayList)) {
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bGi.a(false, false, arrayList, this.bFB);
            if (a2 != null) {
                this.bFG.ax(a2);
                this.bFF.a(a2, this.bFG);
            }
            if (this.bFQ != null) {
                com.baidu.tieba.frs.e.b.a(this.bFG, this.bFQ.aca(), 2);
            }
        }
    }

    private void Jr() {
        if (XG() == 1 || this.bGi.aw(this.bFG.bfR())) {
            this.bFF.YL();
        } else if (com.baidu.tbadk.core.util.w.s(this.bFG.getThreadList())) {
            this.bFF.SI();
        } else {
            this.bFF.Jv();
        }
    }

    public void Ya() {
        if (this.bGi != null) {
            this.bGi.a(this.bFw, this.forumId, this.bFG);
        }
    }

    public boolean Yb() {
        return this.bFS.adk().Zp();
    }

    public void dz(boolean z) {
        this.bFS.adk().dQ(z);
    }

    public void Ot() {
        if (!com.baidu.tbadk.core.util.ad.d(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ao.c(getPageContext());
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

    public void Yc() {
        if (this.bGf != null) {
            this.bGf.acD();
        }
    }

    public void dA(boolean z) {
        if (this.bGg != null) {
            this.bGg.dA(z);
        }
        if (this.bGb != null) {
            this.bGb.dL(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.bGc.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fG(int i) {
        return this.bGc.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.a aVar) {
        this.bGl.b(aVar);
    }
}
