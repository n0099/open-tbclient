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
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.InjectPlugin.a.b;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.frs.e.m;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class r extends BaseFragment implements a.InterfaceC0000a, BdListView.e, f.c, UserIconBox.b, VoiceManager.c, b, bx, ca, com.baidu.tieba.frs.mc.y, com.baidu.tieba.recapp.w {
    private com.baidu.tbadk.util.s aJf;
    private com.baidu.adp.lib.e.b<TbImageView> ams;
    private com.baidu.tieba.frs.entelechy.b.a bTM;
    private boolean bTQ;
    public com.baidu.tbadk.core.data.bl bTR;
    private com.baidu.tieba.tbadkCore.data.e bTW;
    private VoiceManager bTZ;
    private at bUA;
    public com.baidu.tieba.frs.f.f bUB;
    private com.baidu.tieba.frs.mc.p bUC;
    private Intent bUD;
    private int bUE;
    private View.OnTouchListener bUF;
    private boolean bUS;
    private m.a bUh;
    private FrsModelController bUj;
    private com.baidu.tieba.frs.f.u bUk;
    private com.baidu.tieba.frs.view.k bUl;
    private com.baidu.tieba.frs.entelechy.b.d bUm;
    private com.baidu.tieba.frs.mc.s bUn;
    private com.baidu.tieba.frs.mc.b bUo;
    private com.baidu.tieba.frs.smartsort.c bUp;
    private com.baidu.tieba.frs.mc.d bUq;
    private cb bUr;
    private com.baidu.tieba.frs.entelechy.b.b bUt;
    private com.baidu.tbadk.h.a bUu;
    private com.baidu.tieba.frs.f.a bUv;
    private com.baidu.tieba.frs.mc.l bUw;
    private com.baidu.tieba.frs.mc.h bUx;
    private com.baidu.tieba.frs.f.ag bUy;
    private com.baidu.tieba.frs.mc.a bUz;
    public View mRootView;
    private static boolean isNeedRefreshOnResume = false;
    public static boolean bTP = false;
    public static volatile long bUb = 0;
    public static volatile long bUc = 0;
    public static volatile int bUd = 0;
    public boolean bTN = false;
    private boolean bTO = false;
    public String bTS = null;
    public String agW = null;
    public int mFlag = 0;
    private boolean bTT = false;
    private boolean bTU = false;
    private String mThreadId = null;
    private String forumId = null;
    private int bTI = 0;
    private boolean bTV = false;
    private boolean bTX = false;
    private boolean bTY = false;
    private au bUa = null;
    public final com.baidu.tbadk.core.data.bl bbF = null;
    private com.baidu.tieba.tbadkCore.n bTF = new com.baidu.tieba.tbadkCore.n();
    public long bMF = -1;
    public long aGx = 0;
    public long aGp = 0;
    public long createTime = 0;
    public long Vq = -1;
    private boolean bUe = false;
    private boolean bUf = false;
    public com.baidu.tbadk.j.e bUg = null;
    private boolean bUi = true;
    private SparseArray<com.baidu.tieba.InjectPlugin.a.a> bUs = new SparseArray<>();
    private boolean bwA = true;
    private final CustomMessageListener bUG = new s(this, CmdConfigCustom.CMD_AD_FRS_THREAD_CLICKED);
    private CustomMessageListener bUH = new ae(this, CmdConfigCustom.CMD_CLOSE_GAME_RANK_CARD);
    private final bz bUI = new ak(this);
    private by bUJ = new al(this);
    private CustomMessageListener bUK = new am(this, CmdConfigCustom.CMD_UPDATE_FRS_LIVE_COUNT);
    private CustomMessageListener bUL = new an(this, CmdConfigCustom.CMD_FRS_TAB_LIVE_START);
    private final CustomMessageListener bUM = new ao(this, CmdConfigCustom.CMD_FRS_SELECT_ALA_LIVE_TAB);
    private final CustomMessageListener bUN = new ap(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private final CustomMessageListener bUO = new aq(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    public final com.baidu.tieba.tbadkCore.p bUP = new t(this);
    private final CustomMessageListener bUQ = new u(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private final CustomMessageListener mMemListener = new v(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private final com.baidu.tieba.frs.mc.x bUR = new w(this);
    public final View.OnTouchListener aJg = new x(this);
    private final CustomMessageListener bUT = new y(this, CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE);
    private final CustomMessageListener bUU = new z(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);
    public final View.OnClickListener bUV = new aa(this);
    private final AbsListView.OnScrollListener bUW = new ab(this);
    private final n bUX = new ac(this);
    private final NoNetworkView.a byu = new af(this);
    private final CustomMessageListener bUY = new ag(this, 0);
    private com.baidu.adp.widget.ListView.x bUZ = new a(this, null);
    private bz bVa = new ah(this);

    public com.baidu.tieba.frs.entelechy.b.b ZU() {
        return this.bUt;
    }

    public com.baidu.adp.widget.ListView.x ZV() {
        return this.bUZ;
    }

    public com.baidu.tieba.frs.mc.l ZW() {
        return this.bUw;
    }

    public com.baidu.tieba.frs.smartsort.c ZX() {
        return this.bUp;
    }

    @Override // com.baidu.tieba.frs.mc.y
    public FrsModelController ZY() {
        return this.bUj;
    }

    @Override // com.baidu.tieba.frs.mc.y
    public com.baidu.tieba.frs.mc.h ZZ() {
        return this.bUx;
    }

    @Override // com.baidu.tieba.frs.mc.y
    public com.baidu.tieba.frs.f.u aaa() {
        return this.bUk;
    }

    public com.baidu.tieba.frs.entelechy.b.d aab() {
        return this.bUm;
    }

    public cb aac() {
        return this.bUr;
    }

    @Override // com.baidu.tieba.frs.mc.y
    public au aad() {
        return this.bUa;
    }

    @Override // com.baidu.tieba.frs.ca
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.ca
    public String getForumName() {
        return this.bTS;
    }

    public void setForumName(String str) {
        this.bTS = str;
    }

    public void setFrom(String str) {
        this.agW = str;
    }

    public String getFrom() {
        return this.agW;
    }

    public void setFlag(int i) {
        this.mFlag = i;
    }

    @Override // com.baidu.tieba.recapp.w
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.w
    public int getPageNum() {
        if (this.bUx == null) {
            return 1;
        }
        return this.bUx.getPn();
    }

    public int getPn() {
        if (this.bUx == null) {
            return 1;
        }
        return this.bUx.getPn();
    }

    public void setPn(int i) {
        if (this.bUx != null) {
            this.bUx.setPn(i);
        }
    }

    public void setHasMore(int i) {
        if (this.bUx != null) {
            this.bUx.setHasMore(i);
        }
    }

    public int aae() {
        if (this.bUx == null) {
            return -1;
        }
        return this.bUx.aae();
    }

    public boolean aaf() {
        return this.bTY;
    }

    public String getThreadId() {
        return this.mThreadId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d.a aVar, boolean z) {
        if (aVar == null) {
            showNetRefreshView(this.bUa.TK(), TbadkCoreApplication.m9getInst().getString(w.l.error_unkown_try_again), true);
        } else if (aVar.fzd) {
            if (340001 == aVar.errorCode) {
                showNetRefreshViewNoClick(this.bUa.TK(), TbadkCoreApplication.m9getInst().getString(w.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
            } else {
                showNetRefreshView(this.bUa.TK(), TbadkCoreApplication.m9getInst().getString(w.l.net_error_text, new Object[]{aVar.errorMsg, Integer.valueOf(aVar.errorCode)}), true);
            }
        } else if (340001 == aVar.errorCode) {
            showNetRefreshViewNoClick(this.bUa.TK(), aVar.errorMsg, true);
        } else {
            showNetRefreshView(this.bUa.TK(), aVar.errorMsg, true);
        }
        if (aaw()) {
            setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds280));
        } else {
            setNetRefreshViewEmotionDefMarginTop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aag() {
        hideLoadingView(this.bUa.TK());
        this.bUa.cf(false);
        this.bUa.aaN();
        if (this.bUa.aaD() instanceof com.baidu.tieba.frs.tab.i) {
            ((com.baidu.tieba.frs.tab.i) this.bUa.aaD()).Tx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aah() {
        if (aae() == 0 && com.baidu.tbadk.core.util.x.r(this.bTF.bgr())) {
            if (com.baidu.tbadk.core.util.x.r(this.bTF.getThreadList())) {
                this.bUa.VD();
                return;
            } else {
                this.bUa.TY();
                return;
            }
        }
        this.bUa.TW();
    }

    public void a(ErrorData errorData) {
        aag();
        this.bUa.aaH();
        d.a acR = this.bUj.acR();
        boolean r = com.baidu.tbadk.core.util.x.r(this.bTF.getThreadList());
        if (acR != null && r) {
            if (r) {
                if (this.bUj.acS() != 0) {
                    this.bUj.acY();
                    this.bUa.aaH();
                } else {
                    a(acR, false);
                }
                this.bUa.q(this.bTF.bhm(), false);
                return;
            } else if (acR.fzd) {
                this.bUa.q(true, false);
                showToast(getPageContext().getResources().getString(w.l.net_error_text, acR.errorMsg, Integer.valueOf(acR.errorCode)));
                return;
            } else {
                return;
            }
        }
        a(acR, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aai() {
        if (this.bTF == null || this.bTF.aIz() != null) {
            this.bUa.aaQ();
        } else if (this.bTF.aIz().getYuleData() != null && this.bTF.aIz().getYuleData().sU()) {
            TiebaStatic.log("c10852");
            this.bUa.a(this.bTF.aIz().getYuleData().sV());
        } else {
            this.bUa.aaQ();
        }
    }

    private void o(boolean z, boolean z2) {
        if (this.bUj != null && this.bTF != null && this.bUa != null && z) {
            if (!this.bUj.adf() && this.bUj.acU() == 1) {
                if (!this.bUj.add()) {
                    if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.bTF.bhf();
                        this.bTF.bhc();
                    }
                    this.bTF.bhd();
                    this.bTF.bhe();
                }
                boolean z3 = false;
                if (this.bUa.aaR().k(com.baidu.tieba.card.data.p.bDI)) {
                    z3 = this.bTF.bhi();
                }
                if (!z3) {
                    this.bTF.bhg();
                }
                if (TbadkCoreApplication.m9getInst().isRecAppExist()) {
                    this.bTF.a(this);
                }
                if (!this.bUa.aaR().k(com.baidu.tbadk.core.data.bl.Xs)) {
                    this.bTF.bgZ();
                }
                this.bTF.bhj();
                this.bTF.bhk();
            }
            this.bTF.bha();
            this.bTF.bgX();
            if (this.bUa.aaR().k(com.baidu.tieba.g.b.coD)) {
                this.bTF.lq(z2);
            }
        }
    }

    public boolean aaj() {
        if (this.bUm != null && this.bUa != null) {
            this.bUm.b(this.bUa.getListView());
        }
        if (this.bUk != null && this.bUj != null) {
            this.bUk.a(this.bUj.acQ(), this.bTF);
        }
        boolean z = false;
        if (this.bTF != null) {
            z = this.bTF.bhn();
        }
        dZ(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ig(int i) {
        ce ceVar = null;
        aaj();
        aas();
        try {
            if (this.bTF != null) {
                this.bUa.a((ArrayList<com.baidu.adp.widget.ListView.v>) null, this.bTF);
                this.bUk.jb(1);
                this.bUa.aaK();
                this.bUm.a(this.bUa.getListView(), this.bTF, this.bUj.ada());
                com.baidu.tieba.frs.tab.j a2 = a(this.bUm.abR(), this.bTF.bgG());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    ceVar = new ce();
                    ceVar.bWX = a2.url;
                    ceVar.stType = a2.name;
                }
                this.bUj.a(this.bTF.bgG(), 0, ceVar);
                this.bUm.eo(false);
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
            if (jVar != null && jVar.cfI == i) {
                return jVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z, boolean z2) {
        try {
            if (this.bTF != null && this.bUm != null && this.bUj != null) {
                if (!this.bUa.aaR().k(com.baidu.tbadk.core.data.bl.Xs)) {
                    this.bTF.bgZ();
                }
                if (this.bTF.aIz() != null) {
                    this.bTS = this.bTF.aIz().getName();
                    this.forumId = this.bTF.aIz().getId();
                }
                if (this.bTF.bhn()) {
                    this.bUm.a(this.bUa.getListView(), this.bTF, this.bUj.ada());
                }
                if (z) {
                    o(true, z);
                } else {
                    o(this.bUi, z);
                }
                aaj();
                if (this.bUt != null) {
                    this.bUt.a(this.bUk, this.bTF);
                }
                if (this.bTF.qx() != null) {
                    setHasMore(this.bTF.qx().qt());
                }
                ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bUx.a(z2, true, this.bTF.getThreadList(), null);
                if (a2 != null) {
                    this.bTF.ay(a2);
                }
                if (this.bUj.acU() == 1) {
                    aao();
                }
                this.bTI = this.bTF.acW();
                if (this.bTW != null) {
                    this.bTV = true;
                    this.bTW.si(this.bTI);
                    com.baidu.tieba.frs.e.a.a(this, this.bTF.aIz(), this.bTF.getThreadList(), this.bTV, getPn());
                }
                if (this.bUv != null) {
                    this.bUv.ce(this.bUj.adf());
                    this.bUv.ah(this.bUm.abS());
                }
                aag();
                this.bUa.q(true, false);
                if (this.bTO) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAINTAB_FRS_DATA_RECEIVE, this.bTS));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.l lVar) {
        try {
            if (!this.bUe && lVar != null && this.bTF != null) {
                this.bTF.d(lVar);
                p(true, false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void dZ(boolean z) {
        if (this.bUj != null) {
            e(z, this.bUj.acQ());
        } else {
            e(z, "normal_page");
        }
    }

    private void e(boolean z, String str) {
        ea("frs_page".equals(str));
        if (this.bUt != null) {
            this.bUt.a(z, this.bUm, this.bUk, this.bUa, this.bTF);
        }
    }

    public void ea(boolean z) {
        if (this.bUy != null) {
            this.bUy.a(this.bUa, z);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate(w.j.frs_activity, viewGroup, false);
            this.bTM = new com.baidu.tieba.frs.entelechy.b();
            this.bUt = this.bTM.abn();
            this.bUk = new com.baidu.tieba.frs.f.u(this, this.bTM);
            this.bUm = this.bTM.w(this);
            Intent intent = this.bUD != null ? this.bUD : getActivity().getIntent();
            if (intent != null && "main_tab".equals(intent.getStringExtra("from"))) {
                this.bTO = true;
            }
            this.bUa = new au(this, this.bUV, this.bTM, this.bTO);
            this.bUa.setHeaderViewHeight(this.bUE);
        } else if (this.mRootView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Intent intent = this.bUD != null ? this.bUD : getActivity().getIntent();
        this.bMF = System.currentTimeMillis();
        if (intent != null) {
            this.bTX = intent.getBooleanExtra(FrsActivityConfig.ALA_IS_ONLIVING, false);
            this.bMF = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            J(intent);
        }
        this.Vq = System.currentTimeMillis();
        this.aGp = this.Vq - this.bMF;
        this.bTW = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.fBA);
        this.bUj = new FrsModelController(this, this.bUP);
        this.bUj.a(this.bUI);
        this.bUj.init();
        if (intent != null) {
            this.bUj.f(intent.getExtras());
        } else if (bundle != null) {
            this.bUj.f(bundle);
        } else {
            this.bUj.f(null);
        }
        this.bUm.af(this.bUa.TK());
        if (intent != null) {
            this.bUk.h(intent.getExtras());
        } else if (bundle != null) {
            this.bUk.h(bundle);
        } else {
            this.bUk.h((Bundle) null);
        }
        this.bTZ = getVoiceManager();
        this.bUA = new at(getPageContext(), this);
        initUI();
        initData(bundle);
        if (!aaw()) {
            this.bUr = new cb(getActivity(), this.bUa, this.bUk);
            this.bUr.ek(true);
        }
        this.bTZ = getVoiceManager();
        if (this.bTZ != null) {
            this.bTZ.onCreate(getPageContext());
        }
        new com.baidu.tieba.frs.mc.v();
        this.bUx = new com.baidu.tieba.frs.mc.h(this, this.bUR);
        this.bUp = new com.baidu.tieba.frs.smartsort.c(this);
        this.bUy = new com.baidu.tieba.frs.f.ag(this);
        this.createTime = System.currentTimeMillis() - this.Vq;
        this.bUv = new com.baidu.tieba.frs.f.a(getPageContext(), this.bUj.adc());
        this.bUq = new com.baidu.tieba.frs.mc.d(this);
        this.bUw = new com.baidu.tieba.frs.mc.l(this);
        this.bUn = new com.baidu.tieba.frs.mc.s(this);
        this.bUo = new com.baidu.tieba.frs.mc.b(this);
        this.bUz = new com.baidu.tieba.frs.mc.a(this);
        this.bUB = new com.baidu.tieba.frs.f.f(this);
        this.bUC = new com.baidu.tieba.frs.mc.p(this, getUniqueId());
        registerListener(this.mMemListener);
        registerListener(this.bUO);
        registerListener(this.bUT);
        registerListener(this.bUN);
        registerListener(this.bUQ);
        registerListener(this.bUK);
        registerListener(this.bUL);
        registerListener(this.bUM);
        registerListener(this.bUG);
        registerListener(this.bUH);
        this.bUa.ef(false);
        if (!aaw()) {
            showLoadingView(this.bUa.TK(), true);
            this.bUj.p(3, true);
        }
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tieba.frs.bx
    public void aak() {
        if (isAdded() && this.bwA && !isLoadingViewAttached()) {
            showLoadingView(this.bUa.TK(), true);
        }
    }

    @Override // com.baidu.tieba.frs.bx
    public void aal() {
        if (isAdded() && this.bwA && isLoadingViewAttached()) {
            hideLoadingView(this.bUa.TK());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (aaw()) {
            showLoadingView(this.bUa.TK(), true);
            this.bUa.ij(TbadkCoreApplication.m9getInst().getMainTabBottomBarHeight());
            this.bUj.p(3, true);
            getListView().setSelection(0);
        }
    }

    @Override // com.baidu.tieba.frs.bx
    public void setHeaderViewHeight(int i) {
        this.bUE = i;
        if (this.bUa != null) {
            this.bUa.setHeaderViewHeight(this.bUE);
        }
    }

    @Override // com.baidu.tieba.frs.bx
    public void setRecommendFrsNavigationAnimDispatcher(com.baidu.tbadk.util.t tVar) {
        if (tVar != null) {
            this.aJf = tVar.Gv();
            this.bUF = tVar.Gw();
        }
    }

    @Override // com.baidu.tieba.frs.bx
    public void Ye() {
        if (this.aJf != null) {
            this.aJf.cb(true);
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
            this.bTS = data.getQueryParameter("name");
            this.agW = data.getQueryParameter("from");
            if (!StringUtils.isNull(this.bTS)) {
                intent.putExtra("name", this.bTS);
            }
            if (!StringUtils.isNull(this.agW)) {
                intent.putExtra("from", this.agW);
            }
            TiebaStatic.log("c10105");
        }
        if (StringUtils.isNull(this.bTS)) {
            this.bTS = com.baidu.tieba.frs.e.p.L(intent);
            if (!StringUtils.isNull(this.bTS)) {
                intent.putExtra("name", this.bTS);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.bTZ = getVoiceManager();
        if (this.bTZ != null) {
            this.bTZ.onStart(getPageContext());
        }
    }

    private void initData(Bundle bundle) {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bUY);
        if (bundle != null) {
            this.bTS = bundle.getString("name");
            this.agW = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                this.bTS = intent.getStringExtra("name");
                this.agW = intent.getStringExtra("from");
                this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.agW)) {
            FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.agW);
        }
        if (this.mIsLogin) {
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.bUY);
        }
        this.bUk.h(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.bTZ != null) {
            this.bTZ.onDestory(getPageContext());
        }
        this.bTZ = null;
        cf.Uw().dt(false);
        if (this.bTF != null && this.bTF.aIz() != null) {
            bu.abf().aS(com.baidu.adp.lib.g.b.c(this.bTF.aIz().getId(), 0L));
        }
        if (this.bUa != null) {
            com.baidu.tieba.frs.e.o.a(this.bUa, this.bTF, getForumId(), false, null);
            this.bUa.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.bUg != null) {
                this.bUg.onDestroy();
            }
            this.bUa.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.bUj.onActivityDestroy();
        this.bUk.onActivityDestroy();
        if (this.bUh != null) {
            this.bUh.cancel(true);
            this.bUh = null;
        }
        if (this.bUj != null) {
            this.bUj.MT();
        }
        if (this.bUr != null) {
            this.bUr.Gu();
        }
        if (this.bUu != null) {
            this.bUu.destory();
        }
        if (this.bUv != null) {
            this.bUv.destory();
        }
        if (this.bUp != null) {
            this.bUp.onDestroy();
        }
        com.baidu.tieba.recapp.d.a.ban().bap();
        com.baidu.tieba.frs.e.q.adC();
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.bTS);
        bundle.putString("from", this.agW);
        this.bUj.onSaveInstanceState(bundle);
        if (this.bTZ != null) {
            this.bTZ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.bUz != null) {
            this.bUz.onActivityResult(i, i2, intent);
        }
    }

    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bUu == null) {
                this.bUu = new com.baidu.tbadk.h.a(getPageContext());
            }
            this.bUu.an(updateAttentionMessage.getData().toUid, getForumId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.bUa != null) {
            this.bUa.aaH();
            this.bUa.onResume();
        }
        this.bUm.a(this.bUJ);
        this.bUn.ev(true);
        this.bUi = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.bUa.startPullRefresh();
        } else if (bTP) {
            bTP = false;
            this.bUa.startPullRefresh();
        } else {
            if (this.bTZ != null) {
                this.bTZ.onResume(getPageContext());
            }
            this.bUa.eg(false);
            registerListener(this.bUU);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        refresh();
    }

    @Override // com.baidu.tieba.frs.bx
    public void K(Intent intent) {
        this.bUD = intent;
    }

    public void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.bTS = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.agW = intent.getStringExtra("from");
            }
            this.bTU = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.bTU) {
                aam();
            }
        }
    }

    private void aam() {
        this.bUa.startPullRefresh();
    }

    public void closeActivity() {
        com.baidu.tieba.frs.e.p.a(getPageContext(), getActivity().getIntent(), this.agW);
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.bUa.setTitle(this.bTS);
        } else {
            this.bUa.setTitle("");
            this.mFlag = 1;
        }
        this.bUk.d(this.bUa.getListView());
        this.bUa.setOnAdapterItemClickListener(this.bUZ);
        this.bUa.setOnScrollListener(this.bUW);
        this.bUa.c(this.byu);
        this.bUa.aaR().a(this.bUX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bUa.onChangeSkinType(i);
        this.bUk.ja(i);
        this.bUm.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.f.c
    public void lt() {
    }

    @Override // com.baidu.adp.widget.f.c
    public void lu() {
    }

    public void ih(int i) {
        if (!this.mIsLogin) {
            if (this.bTF != null && this.bTF.qh() != null) {
                this.bTF.qh().setIfpost(1);
            }
            if (i == 0) {
                bh.aL(getActivity());
            }
        } else if (this.bTF != null) {
            if (i == 0) {
                if (!this.bTQ) {
                    com.baidu.tieba.frs.e.q.b(this, 0);
                    return;
                }
                TiebaStatic.log("c10152");
                com.baidu.tieba.frs.e.q.b(this, 4);
                return;
            }
            this.bUa.aaJ();
        }
    }

    public void refresh() {
        ci(3);
    }

    public void ci(int i) {
        this.bUe = false;
        aas();
        if (this.bUa.aaC() != null) {
            this.bUa.aaC().akv();
        }
        this.bUj.p(i, true);
    }

    private void aan() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.g.k.fT().f(new aj(this));
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aao() {
        aas();
        try {
            if (this.bTF != null) {
                this.bUa.My();
                this.bUa.ec(this.bUj.acV());
                if (com.baidu.tieba.frs.f.u.i(this.bTF) && !com.baidu.tieba.frs.f.u.h(this.bTF)) {
                    this.bUa.aaV();
                }
                if (this.bTF.aIz() != null) {
                    this.bTS = this.bTF.aIz().getName();
                    this.forumId = this.bTF.aIz().getId();
                }
                if (this.bTF.qx() != null) {
                    setHasMore(this.bTF.qx().qt());
                }
                this.bUa.setTitle(this.bTS);
                this.bUa.setForumName(this.bTS);
                TbadkCoreApplication.m9getInst().setDefaultBubble(this.bTF.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(this.bTF.getUserData().getBimg_end_time());
                aan();
                aap();
                ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bTF.getThreadList();
                if (threadList != null) {
                    this.bUa.a(threadList, this.bTF);
                    com.baidu.tieba.frs.e.c.j(this.bUa);
                    this.bUk.jb(getPageNum());
                    this.bUk.f(this.bTF);
                    this.bUm.a(this.bUa.getListView(), this.bTF, this.bUj.ada());
                    this.bUa.aaK();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aap() {
        if (this.bTF != null) {
            if (this.bTF.aIN() == 1) {
                this.bUa.aaR().setFromCDN(true);
            } else {
                this.bUa.aaR().setFromCDN(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.bUn.ev(false);
        this.bUi = false;
        this.bUa.onPause();
        if (this.bTZ != null) {
            this.bTZ.onPause(getPageContext());
        }
        this.bUa.eg(true);
        if (this.bUv != null) {
            this.bUv.adF();
        }
        MessageManager.getInstance().unRegisterListener(this.bUU);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        cf.Uw().dt(false);
        if (this.bTF != null && this.bTF.aIz() != null) {
            com.baidu.tbadk.distribute.a.BW().a(getPageContext().getPageActivity(), "frs", this.bTF.aIz().getId(), 0L);
        }
        if (this.bTZ != null) {
            this.bTZ.onStop(getPageContext());
        }
        com.baidu.tieba.frs.e.p.c(getListView());
        this.bUk.onActivityStop();
        com.baidu.tbadk.util.u.Gy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.bUa == null) {
            return false;
        }
        return this.bUa.aaG();
    }

    public boolean aaq() {
        if (this.bUl == null) {
            return false;
        }
        return this.bUl.isShowing();
    }

    @Override // com.baidu.tieba.recapp.w
    public TbPageContext<?> xw() {
        return getPageContext();
    }

    @Override // com.baidu.tieba.recapp.w
    public void a(AdvertAppInfo advertAppInfo, String str) {
        com.baidu.tbadk.distribute.a.BW().a(advertAppInfo, this.forumId, 0L, "FRS", str, getPn());
    }

    @Override // com.baidu.tieba.recapp.w
    public void aar() {
        ZY().aar();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bTZ == null) {
            this.bTZ = VoiceManager.instance();
        }
        return this.bTZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.bUa == null) {
            return null;
        }
        return this.bUa.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void aas() {
        if (this.bTZ != null) {
            this.bTZ.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> wC() {
        if (this.ams == null) {
            this.ams = UserIconBox.j(getPageContext().getPageActivity(), 8);
        }
        return this.ams;
    }

    public void aat() {
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
                if (bdUniqueId == bg.bWr) {
                    if (r.this.bUa != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11752").Z("fid", r.this.forumId).Z("obj_locate", "1"));
                        r.this.bUa.startPullRefresh();
                    }
                } else if (vVar != null && (vVar instanceof com.baidu.tbadk.core.data.bl)) {
                    com.baidu.tbadk.core.data.bl blVar = (com.baidu.tbadk.core.data.bl) vVar;
                    if (blVar.sf() == null || blVar.sf().getGroup_id() == 0 || bh.aN(r.this.getActivity())) {
                        if ((blVar.rY() != 1 && blVar.rY() != 2) || bh.aN(r.this.getActivity())) {
                            if (blVar.rH() != null) {
                                if (bh.aN(r.this.getActivity())) {
                                    String postUrl = blVar.rH().getPostUrl();
                                    if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.hB()) {
                                        com.baidu.tbadk.browser.f.T(r.this.getActivity(), postUrl);
                                    }
                                }
                            } else if (blVar.sq() != null) {
                                com.baidu.tbadk.core.data.n sq = blVar.sq();
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(r.this.getPageContext().getPageActivity(), sq.getCartoonId(), sq.getChapterId(), 2)));
                            } else if (blVar.getThreadType() == 47 && blVar.rq() == 1 && !com.baidu.tbadk.core.util.au.isEmpty(blVar.rB())) {
                                com.baidu.tbadk.browser.f.S(r.this.getPageContext().getPageActivity(), blVar.rB());
                            } else {
                                com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.qw(blVar.getId())) {
                                    readThreadHistory.qv(blVar.getId());
                                }
                                String rB = blVar.rB();
                                if (rB == null || rB.equals("")) {
                                    z = false;
                                } else {
                                    new Thread(new ar(this, rB)).start();
                                    z = true;
                                }
                                String tid = blVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (blVar.rq() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.bb vy = com.baidu.tbadk.core.util.bb.vy();
                                    TbPageContext<BaseFragmentActivity> pageContext = r.this.getPageContext();
                                    String[] strArr = new String[3];
                                    strArr[0] = tid;
                                    strArr[1] = "";
                                    vy.c(pageContext, strArr);
                                } else if (blVar.getThreadType() == 33 || (blVar instanceof com.baidu.tbadk.core.data.ay)) {
                                    if (blVar.getThreadType() == 33) {
                                        str = "c10245";
                                    } else {
                                        str = "c10180";
                                    }
                                    if (r.this.bUj.acU() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.as(str).Z("fid", r.this.forumId));
                                    com.baidu.tieba.frs.e.p.c(r.this, blVar);
                                    if (r.this.bTF != null && r.this.bTF.aIz() != null) {
                                        com.baidu.tieba.frs.d.a aVar = new com.baidu.tieba.frs.d.a();
                                        aVar.cfc = r.this.bTF.fzF == 1;
                                        aVar.cfe = r.this.bTF.aIz().getId();
                                        aVar.cfd = r.this.ZY().ada();
                                        com.baidu.tieba.frs.d.b.adw().a(aVar, blVar, 1);
                                    }
                                } else {
                                    if (tid.startsWith("pb:")) {
                                        blVar.setId(tid.substring(3));
                                    }
                                    if (bdUniqueId.getId() == com.baidu.tbadk.core.data.bl.Yy.getId()) {
                                        com.baidu.tieba.frs.e.o.a(blVar.rd());
                                        com.baidu.tieba.frs.e.p.b(r.this, blVar);
                                        return;
                                    }
                                    com.baidu.tieba.frs.e.p.a(r.this, blVar, i, z);
                                    com.baidu.tieba.frs.e.o.a(r.this, r.this.bTF, blVar);
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
            hideNetRefreshView(this.bUa.TK());
            showLoadingView(this.bUa.TK(), true);
            this.bUa.ef(false);
            this.bUa.startPullRefresh();
        }
    }

    public com.baidu.tieba.tbadkCore.n aau() {
        return this.bTF;
    }

    public boolean aav() {
        return this.bUa.aav();
    }

    public void N(Object obj) {
        if (this.bUq != null && this.bUq.cea != null) {
            this.bUq.cea.g(obj);
        }
    }

    public void O(Object obj) {
        if (this.bUq != null && this.bUq.ceb != null) {
            this.bUq.ceb.g(obj);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.hB()) {
            this.bUa.VD();
        } else if (this.bUj.acU() == 1) {
            Mg();
            LS();
        } else if (this.bUj.hasMore()) {
            LS();
        }
    }

    public void iZ(String str) {
        Mg();
        showToast(str);
    }

    public void F(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        Mg();
        if (!com.baidu.tbadk.core.util.x.r(arrayList)) {
            if (!this.bUj.adf() && TbadkCoreApplication.m9getInst().isRecAppExist() && this.bUj.acU() == 1) {
                this.bTF.a(this, arrayList);
            }
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bUx.a(false, false, arrayList, this.bTW);
            if (a2 != null) {
                this.bTF.ay(a2);
                this.bUa.a(a2, this.bTF);
            }
            if (this.bUj != null) {
                com.baidu.tieba.frs.d.b.a(this.bTF, this.bUj.ada(), 2);
            }
        }
    }

    private void Mg() {
        if (aae() == 1 || this.bUx.aq(this.bTF.bgr())) {
            this.bUa.TW();
        } else if (com.baidu.tbadk.core.util.x.r(this.bTF.getThreadList())) {
            this.bUa.VD();
        } else {
            this.bUa.TY();
        }
    }

    @Override // com.baidu.tieba.frs.mc.y
    public void LS() {
        if (this.bUx != null) {
            this.bUx.a(this.bTS, this.forumId, this.bTF);
        }
    }

    public void Qe() {
        if (!com.baidu.tbadk.core.util.ae.d(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.ap.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return aaw() ? "a034" : "a006";
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getCurrentPageSourceKeyList() {
        ArrayList arrayList;
        if (!aaw()) {
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

    public void eb(boolean z) {
        if (this.bUr != null) {
            this.bUr.ek(z);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        this.bUs.put(i, aVar);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a fB(int i) {
        return this.bUs.get(i);
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        this.bUA.b(bVar);
    }

    public boolean aaw() {
        return this.bTO;
    }

    @Override // com.baidu.tieba.frs.bx
    public void aax() {
        if (this.bUa != null) {
            Ye();
            this.bUa.getListView().setSelection(0);
            this.bUa.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.frs.bx
    public ForumWriteData aay() {
        if (this.bTF == null || this.bTF.aIz() == null) {
            return null;
        }
        ForumData aIz = this.bTF.aIz();
        ForumWriteData forumWriteData = new ForumWriteData(aIz.getId(), aIz.getName(), aIz.getPrefixData(), this.bTF.qh());
        forumWriteData.setForumLevel(aIz.getUser_level());
        return forumWriteData;
    }

    @Override // com.baidu.tieba.frs.bx
    public void ws() {
        changeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    public void cv(boolean z) {
        if (this.bUa != null) {
            this.bUa.cv(z);
        }
    }
}
