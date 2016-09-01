package com.baidu.tieba.frs;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.f;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EcommProductListActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveHeadlineActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e.a;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.BdExpandListView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class FrsActivity extends BaseActivity<FrsActivity> implements a.InterfaceC0000a, BdListView.e, f.b, UserIconBox.b, VoiceManager.c, di, com.baidu.tieba.recapp.b, FrsCommonImageLayout.c {
    public static String bOT = "speed_icon_show";
    private static final int bOU = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds90);
    private static final int bOV = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds300);
    public static boolean bPc = false;
    public static volatile long bPu = 0;
    public static volatile long bPv = 0;
    public static volatile int bPw = 0;
    private static boolean isNeedRefreshOnResume = false;
    private com.baidu.adp.lib.f.b<TbImageView> ahC;
    private com.baidu.tbadk.core.data.bg bOW;
    private boolean bOX;
    private String bOY;
    private com.baidu.tieba.frs.e.a bPB;
    private com.baidu.tieba.frs.i.p bPC;
    private com.baidu.tieba.frs.i.aa bPD;
    private com.baidu.tieba.frs.i.y bPE;
    private com.baidu.tieba.frs.view.p bPF;
    private com.baidu.tieba.frs.entelechy.b.d bPG;
    private com.baidu.tieba.frs.headvideo.c bPH;
    private com.baidu.tieba.e.c bPI;
    private dj bPJ;
    private com.baidu.tieba.frs.loadmore.a bPK;
    private com.baidu.tieba.frs.entelechy.b.b bPM;
    private com.baidu.tieba.frs.ecomm.a bPN;
    private com.baidu.tbadk.f.a bPO;
    private com.baidu.tieba.frs.i.a bPP;
    private com.baidu.tieba.frs.entelechy.b.a bPa;
    private boolean bPd;
    private com.baidu.tbadk.core.data.bg bPe;
    private com.baidu.tieba.tbadkCore.data.f bPk;
    private String bPl;
    private ct bPr;
    private com.baidu.adp.lib.f.b<TbImageView> bPt;
    private a bPz;
    VoiceManager bQi;
    private com.baidu.tbadk.core.view.a boU;
    private boolean bOZ = false;
    public boolean bPb = false;
    public String bPf = null;
    public String acU = null;
    public int mFlag = 0;
    private int mPn = 1;
    private boolean bPg = false;
    private boolean bPh = false;
    private String mThreadId = null;
    private String forumId = null;
    private int bPi = 0;
    private boolean bPj = false;
    private boolean bPm = false;
    private boolean bPn = false;
    private bm bPo = null;
    private final com.baidu.tbadk.core.data.bg bPp = null;
    private com.baidu.tieba.tbadkCore.p bPq = new com.baidu.tieba.tbadkCore.p();
    private com.baidu.tbadk.core.data.bg bPs = null;
    public long bGO = -1;
    public long aCr = 0;
    public long aCj = 0;
    public long createTime = 0;
    public long QZ = -1;
    private boolean bPx = false;
    public com.baidu.tbadk.performanceLog.e bPy = null;
    private boolean bPA = true;
    private int bPL = -1;
    private dh bPQ = new d(this);
    private dg bPR = new o(this);
    private CustomMessageListener ahA = new ab(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener bNu = new al(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
    private CustomMessageListener bPS = new ao(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private CustomMessageListener aUM = new ap(this, CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND);
    public final CustomMessageListener bPT = new aq(this, CmdConfigCustom.MSG_NEW);
    private CustomMessageListener bPU = new ar(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    private boolean bPV = false;
    public final com.baidu.tieba.tbadkCore.r bPW = new as(this);
    private final CustomMessageListener Oh = new e(this, CmdConfigCustom.CMD_REFRESH);
    CustomMessageListener bPX = new f(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private final CustomMessageListener mMemListener = new g(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private CustomMessageListener bPY = new h(this, CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS);
    public View.OnTouchListener aKe = new i(this);
    private a.InterfaceC0055a aQg = new j(this);
    private CustomMessageListener bPZ = new k(this, CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE);
    private final CustomMessageListener bQa = new l(this, CmdConfigCustom.CMD_JUDGE_TO_HOTTOPIC_FROM_FRS);
    private final com.baidu.adp.framework.listener.a bQb = new m(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    private final com.baidu.adp.framework.listener.a bQc = new n(this, CmdConfigHttp.CMD_SET_COMMON_FORUM_STATE, 309365);
    private t.b agd = new p(this);
    private t.c agg = new q(this);
    private t.a agf = new r(this);
    private final BdExpandListView.a bQd = new s(this);
    public final View.OnClickListener bQe = new t(this);
    private final AbsListView.OnScrollListener bQf = new u(this);
    private final ba bQg = new w(this);
    private final com.baidu.tieba.tbadkCore.ai bQh = new com.baidu.tieba.tbadkCore.ai(getPageContext(), new y(this));
    private CustomMessageListener bnI = new z(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private final NoNetworkView.a bOz = new aa(this);
    private final CustomMessageListener bQj = new ac(this, 0);
    private com.baidu.adp.widget.ListView.w bQk = new b();
    private com.baidu.adp.widget.ListView.x bQl = new ad(this);
    public final com.baidu.adp.base.g bQm = new ae(this);
    public final com.baidu.adp.base.g bQn = new af(this);
    private dh bQo = new ag(this);

    @Override // com.baidu.tieba.frs.di
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.di
    public String getForumName() {
        return this.bPf;
    }

    public com.baidu.tieba.frs.headvideo.c aav() {
        return this.bPH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.y yVar) {
        if (yVar != null) {
            boolean z = yVar.isLike() == 1;
            if (this.bPo != null && this.bPq != null && this.bPq.aLP() != null && yVar.aaL() != null) {
                if (yVar.aaL().equals(this.bPq.aLP().getId())) {
                    this.bPq.aLP().setLike(yVar.isLike());
                    if (!StringUtils.isNULL(yVar.getLevelName())) {
                        this.bPq.aLP().setLevelName(yVar.getLevelName());
                    }
                    if (yVar.getUserLevel() >= 0) {
                        this.bPq.aLP().setUser_level(yVar.getUserLevel());
                    }
                    if (z) {
                        this.bPC.a(this.bPq, false);
                        this.bPD.eh(true);
                        TbadkCoreApplication.m9getInst().addLikeForum(this.bPf);
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.bgZ().R(this.bPf, false);
                    this.bPq.aLP().setLike(0);
                    this.bPC.afu();
                    this.bPD.eh(false);
                    TbadkCoreApplication.m9getInst().delLikeForum(this.bPf);
                    return;
                }
                if (yVar.isLike() == 1) {
                    this.bPq.qJ(yVar.aaL());
                    this.bPC.f(this.bPq);
                    this.bPG.a(this.bPo.getListView(), this.bPq, this.bPB.aeU());
                }
                if (this.bPq.aLP().getBannerListData() != null) {
                    this.bPq.aLP().getBannerListData().setFeedForumLiked(yVar.aaL(), yVar.isLike());
                }
                this.bPo.aby();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    public void a(ErrorData errorData) {
        this.bPo.dH(false);
        this.bPo.aby();
        hideLoadingView(this.bPo.getRootView());
        this.bPo.dI(false);
        this.bPo.abE();
        if (!this.bPn) {
            e.a aeI = aaV().aeI();
            if (!this.bOZ) {
                if (aeI != null) {
                    if (this.bPB.aeK() != 0) {
                        this.bPB.aeQ();
                        this.bPo.aby();
                    } else {
                        if (aeI.fpA) {
                            if (340001 == aeI.errorCode) {
                                showNetRefreshViewNoClick(this.bPo.getRootView(), getPageContext().getResources().getString(t.j.net_error_text, aeI.errorMsg, Integer.valueOf(aeI.errorCode)), true);
                            } else {
                                showNetRefreshView(this.bPo.getRootView(), getPageContext().getResources().getString(t.j.net_error_text, aeI.errorMsg, Integer.valueOf(aeI.errorCode)), true);
                            }
                        } else if (340001 == aeI.errorCode) {
                            showNetRefreshViewNoClick(this.bPo.getRootView(), aeI.errorMsg, true);
                        } else {
                            showNetRefreshView(this.bPo.getRootView(), aeI.errorMsg, true);
                        }
                        setNetRefreshViewEmotionDefMarginTop();
                        if (this.bPo.abu() != null) {
                            this.bPo.abu().setVisibility(8);
                        }
                        if (this.bPE != null) {
                            this.bPE.dW(false);
                        }
                    }
                    this.bPo.n(false, false);
                }
            } else if (aeI != null && aeI.fpA) {
                this.bPo.n(true, false);
                showToast(getPageContext().getResources().getString(t.j.net_error_text, aeI.errorMsg, Integer.valueOf(aeI.errorCode)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aaw() {
        if (this.bPG != null && this.bPo != null) {
            this.bPG.u(this.bPo.getListView());
        }
        if (this.bPC != null && aaV() != null) {
            this.bPC.a(aaV().aeH(), this.bPq);
        }
        boolean z = false;
        if (this.bPq != null) {
            z = this.bPq.bie();
        }
        dA(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hL(int i) {
        dn dnVar = null;
        aaw();
        aaO();
        try {
            if (this.bPq != null) {
                this.bPo.a(null, 1, this.bPq, 0);
                this.bPC.iz(1);
                this.bPo.abB();
                this.bPG.a(this.bPo.getListView(), this.bPq, this.bPB.aeU());
                com.baidu.tieba.frs.tab.i a2 = a(this.bPG.adh(), this.bPq.bhz());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    dnVar = new dn();
                    dnVar.bTF = a2.url;
                    dnVar.stType = a2.name;
                }
                this.bPB.a(this.bPq.bhz(), 0, dnVar);
                this.bPG.dV(false);
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
            if (iVar != null && iVar.bHI == i) {
                return iVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.n nVar) {
        int bhz;
        if (!this.bPV && nVar != null) {
            try {
                if (this.bPq != null) {
                    this.bPq.d(nVar);
                    aaG();
                    this.bPL = this.bPq.getPage().qq();
                    boolean bie = this.bPq.bie();
                    String str = "normal_page";
                    if (com.baidu.tieba.frs.i.p.i(this.bPq)) {
                        str = "book_page";
                    } else if (com.baidu.tieba.frs.i.p.j(this.bPq)) {
                        str = "frs_page";
                    }
                    this.bPG.u(this.bPo.getListView());
                    this.bPC.e(str, this.bPq.getUserData().getIsMem(), this.bPq.aLP().isLike());
                    dA(bie);
                    if (this.bPM != null) {
                        this.bPM.a(this.bPC, this.bPq);
                    }
                    this.bPo.OG();
                    this.bPf = this.bPq.aLP().getName();
                    this.forumId = this.bPq.aLP().getId();
                    this.bPo.setTitle(this.bPf);
                    aaE();
                    this.bPq.bhR();
                    if (this.bPo.abJ().k(com.baidu.tieba.tbadkCore.al.frw)) {
                        this.bPq.bhS();
                    }
                    if (!this.bPB.aeS()) {
                        this.bPq.bhY();
                    }
                    if (!aaV().aeJ()) {
                        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) && !this.bPB.aeS()) {
                            this.bPq.bhX();
                            this.bPq.bhW();
                            this.bPq.bhU();
                        }
                        if (!this.bPB.aeS()) {
                            this.bPq.bhV();
                        }
                    }
                    if (!((!this.bPo.abJ().k(com.baidu.tieba.card.data.q.bci) || this.bPB.aeS()) ? false : this.bPq.bib()) && !this.bPB.aeS()) {
                        this.bPq.bia();
                    }
                    if (TbadkCoreApplication.m9getInst().isRecAppExist()) {
                        this.bPq.bf(getPageContext().getPageActivity());
                    }
                    this.bPq.bhQ();
                    com.baidu.tbadk.core.data.bl top_notice_data = this.bPq.aLP().getTop_notice_data();
                    if (top_notice_data != null && top_notice_data.getTitle() != null) {
                        com.baidu.tbadk.core.data.bg bgVar = new com.baidu.tbadk.core.data.bg();
                        bgVar.setTitle(top_notice_data.getTitle());
                        bgVar.bV(2);
                        bgVar.cs(top_notice_data.sJ());
                        bgVar.si();
                        this.bPq.v(bgVar);
                    }
                    this.bPq.bic();
                    if (this.bPB.ccN && (bhz = nVar.bhz()) != 1) {
                        this.bOZ = true;
                        hL(bhz);
                        return;
                    }
                    ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bPq.getThreadList();
                    if (threadList != null) {
                        ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bPK.a(true, threadList);
                        if (a2 != null) {
                            this.bPq.aA(a2);
                        }
                        this.bPo.a(threadList, this.mPn, this.bPq, this.bPq.getPage().qq());
                        aaP();
                        this.bPC.iz(this.mPn);
                        this.bPC.f(this.bPq);
                        this.bPG.a(this.bPo.getListView(), this.bPq, this.bPB.aeU());
                        this.bPo.abB();
                    }
                    this.bPi = this.bPq.aeO();
                    if (this.bPk != null) {
                        this.bPj = true;
                        this.bPk.ru(this.bPi);
                    }
                    hideLoadingView(this.bPo.getRootView());
                    if (this.bPo.abu() != null && this.mIsLogin) {
                        this.bPo.abu().setVisibility(0);
                    }
                    if (this.bPE != null && this.mIsLogin) {
                        this.bPE.dW(true);
                    }
                    if (this.bPE != null && !this.bPE.isMenuShowing()) {
                        this.bPo.dF(true);
                    }
                    this.bPo.dI(false);
                    if (this.bPq.aLP().isIs_forbidden() == 1) {
                        this.bPD.ej(false);
                    } else {
                        this.bPD.ej(true);
                    }
                    this.bPD.ei(this.bPq.bhd() == 1);
                    this.bOZ = true;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void dA(boolean z) {
        if (aaV() != null) {
            dB("frs_page".equals(aaV().aeH()));
        }
        if (this.bPM != null) {
            this.bPM.a(z, this.bPG, this.bPC, this.bPo, this.bPq);
        }
    }

    private void dB(boolean z) {
        if (this.bPo != null) {
            if (z) {
                this.bPo.abX();
                this.bPo.a(this.agd);
                this.bPo.a(this.agg);
                this.bPo.a(this.agf);
                return;
            }
            this.bPo.abY();
            this.bPo.a(this.bQd);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        bOT = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (intent != null) {
            this.bGO = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (intent.getData() != null) {
                Uri data = intent.getData();
                this.bPf = data.getQueryParameter("name");
                this.acU = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.bPf)) {
                    intent.putExtra("name", this.bPf);
                }
                if (!StringUtils.isNull(this.acU)) {
                    intent.putExtra("from", this.acU);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.bPf)) {
                this.bPf = k(intent);
                if (!StringUtils.isNull(this.bPf)) {
                    intent.putExtra("name", this.bPf);
                }
            }
        } else {
            this.bGO = System.currentTimeMillis();
        }
        this.QZ = System.currentTimeMillis();
        this.aCj = this.QZ - this.bGO;
        if (!dC(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.QZ;
            return;
        }
        super.onCreate(bundle);
        this.bPB = new com.baidu.tieba.frs.e.a(this);
        this.bPB.a(this.bPQ);
        this.bPB.init();
        if (getIntent() != null) {
            this.bPB.d(getIntent().getExtras());
        } else if (bundle != null) {
            this.bPB.d(bundle);
        } else {
            this.bPB.d(null);
        }
        aaV().B(3, true);
        this.bPa = new com.baidu.tieba.frs.entelechy.i();
        this.bPM = this.bPa.acI();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.frs_activity, (ViewGroup) null);
        this.bPE = new com.baidu.tieba.frs.i.y(this, this.bPa.acH());
        this.bPD = new com.baidu.tieba.frs.i.aa(this);
        this.bPE.a(getPageContext().getPageActivity(), inflate, this.bPD.afE().getView());
        this.bPC = new com.baidu.tieba.frs.i.p(this, this.bPa);
        this.bPG = this.bPa.K(this);
        this.bPo = new bm(this, this.bQe, this.bPa);
        this.bPC.a(this.bPo.Ki());
        this.bPG.ae(this.bPo.getRootView());
        if (getIntent() != null) {
            this.bPC.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.bPC.f(bundle);
        } else {
            this.bPC.f((Bundle) null);
        }
        this.bQi = getVoiceManager();
        this.bQi.onCreate(getPageContext());
        initUI();
        initData(bundle);
        this.bPo.setForumName(this.bPf);
        this.bQh.setUniqueId(getUniqueId());
        this.bQh.registerListener();
        addGlobalLayoutListener();
        aaA();
        aaz();
        aay();
        registerListener(this.Oh);
        registerListener(this.bQa);
        registerListener(this.mMemListener);
        registerListener(this.bPT);
        registerListener(this.ahA);
        registerListener(this.aUM);
        registerListener(this.bNu);
        registerListener(this.bPU);
        registerListener(this.bPY);
        registerListener(this.bPZ);
        registerListener(this.bnI);
        registerListener(this.bPS);
        registerListener(this.bPX);
        this.bQb.ci().setSelfListener(true);
        this.bQb.ch().setSelfListener(true);
        this.bQb.setTag(getUniqueId());
        registerListener(this.bQb);
        registerListener(this.bQc);
        this.bPK = new com.baidu.tieba.frs.loadmore.a(this);
        this.bPK.registerListener();
        this.bPk = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.frY);
        this.createTime = System.currentTimeMillis() - this.QZ;
        if (this.bPo != null) {
            showLoadingView(this.bPo.getRootView(), true);
            this.bPo.dJ(false);
        }
        this.bPJ = new dj(getActivity(), this.bPo, this.bPC);
        this.bPJ.dO(true);
        this.bPI = new com.baidu.tieba.e.c(getActivity());
        this.bPI.a(this.aQg);
        this.bPP = new com.baidu.tieba.frs.i.a(getPageContext(), this.bPB.aeR());
        this.bPH = new com.baidu.tieba.frs.headvideo.c(this, this.bPo.getRootView(), this.bPC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aax() {
        com.baidu.tbadk.data.e eVar = new com.baidu.tbadk.data.e();
        if (this.bPq != null && this.bPq.aLP() != null) {
            eVar.setForumId(com.baidu.adp.lib.h.b.c(this.bPq.aLP().getId(), 0L));
            eVar.fa(this.bPq.aLP().getName());
            eVar.fb(this.bPq.aLP().getImage_url());
            eVar.eo(this.bPq.aLP().getSigned() ? 1 : 0);
            eVar.en(this.bPq.aLP().getUser_level());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_SET_COMMON_ACCESS_FORUM, eVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
        } else if (this.bPq != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null && this.bPo != null) {
            com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(getMyPostResIdl.data.thread_info.author);
            a(metaData, getMyPostResIdl.data.user_info, getMyPostResIdl.data.thread_info.twzhibo_info);
            metaData.setPortrait(TbadkCoreApplication.getCurrentPortrait());
            String userId = metaData.getUserId();
            if (userId != null && !userId.equals("0")) {
                hashMap.put(metaData.getUserId(), metaData);
            }
            ahVar.setUserMap(hashMap);
            ahVar.a(getMyPostResIdl.data.thread_info);
            this.bPB.a(ahVar);
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bPK.a(true, this.bPq.getThreadList());
            if (a2 != null) {
                this.bPq.aA(a2);
                this.bPq.bhQ();
                this.bPo.a(a2, this.mPn, this.bPq, this.bPL);
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0008: IGET  (r1v0 java.lang.Long A[REMOVE]) = (r4v0 tbclient.GetMyPost.User_Info) tbclient.GetMyPost.User_Info.id java.lang.Long)] */
    private void a(MetaData metaData, User_Info user_Info, ZhiBoInfoTW zhiBoInfoTW) {
        if (user_Info != null) {
            metaData.setUserId(new StringBuilder().append(user_Info.id).toString());
            metaData.setGender(user_Info.gender.intValue());
            metaData.setType(user_Info.type.intValue());
            metaData.setUserName(user_Info.name);
            metaData.setName_show(user_Info.name_show);
            metaData.setPortrait(user_Info.portrait);
            metaData.setGodInfo(user_Info.god_data);
            metaData.getGodUserData().parserProtobuf(user_Info.god_data);
            metaData.setFansNum(user_Info.fans_num.intValue());
            if (zhiBoInfoTW != null && zhiBoInfoTW.user != null) {
                String str = zhiBoInfoTW.user.fans_nickname;
                if (StringUtils.isNull(str)) {
                    str = getPageContext().getResources().getString(t.j.fans_default_name);
                }
                metaData.setFansNickName(str);
            }
        }
    }

    private void aay() {
        com.baidu.tbadk.task.b a2 = com.baidu.tieba.tbadkCore.a.a.a(309360, ResponseIncrForumAccessCountSocketMessage.class, false, false);
        a2.setResponsedClass(ResponseIncrForumAccessCountSocketMessage.class);
        a2.l(true);
        a2.m(false);
        a2.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(a2);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_INCREASE_FORUM_ACCESS_COUNT, com.baidu.tieba.tbadkCore.a.a.aG(TbConfig.INCR_FORUM_ACCESS_ACOUNT, 309360));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ResponseIncrForumAccessCountHttpMessage.class);
        tbHttpMessageTask.setIsImm(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void aaz() {
        com.baidu.tbadk.task.b a2 = com.baidu.tieba.tbadkCore.a.a.a(309365, ResponseSetCommForumStateSocketMessage.class, false, false);
        a2.setResponsedClass(ResponseSetCommForumStateSocketMessage.class);
        a2.l(true);
        a2.m(false);
        a2.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(a2);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SET_COMMON_FORUM_STATE, com.baidu.tieba.tbadkCore.a.a.aG(TbConfig.SET_COMMON_FORUM_STATE, 309365));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ResponseSetCommForumStateHttpMessage.class);
        tbHttpMessageTask.setIsImm(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void aaA() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MY_POST, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_MY_POST + "?cmd=303111");
        tbHttpMessageTask.setResponsedClass(GetMyPostHttpResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(303111);
        bVar.setResponsedClass(GetMyPostSocketResponseMessage.class);
        bVar.l(true);
        bVar.m(false);
        bVar.a(SocketMessageTask.DupLicateMode.NONE);
        messageManager.registerTask(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.bQi = getVoiceManager();
        this.bQi.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bQj);
        if (bundle != null) {
            this.bPf = bundle.getString("name");
            this.acU = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bPf = intent.getStringExtra("name");
                this.acU = intent.getStringExtra("from");
                this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.acU) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.acU)) {
            setSwipeBackEnabled(false);
        }
        this.bPr = new ct(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            aaB();
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.bQj);
        }
        this.bPC.f(bundle);
    }

    private String k(Intent intent) {
        int indexOf;
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (!StringUtils.isNull(dataString) && dataString.startsWith("tbfrs://")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10320").s("obj_locate", 2).s("obj_type", 1));
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (StringUtils.isNull(decode) || (indexOf = decode.indexOf("kw=")) < 0 || (length = indexOf + "kw=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public void aaB() {
        if (this.bPr != null && this.bPo != null) {
            if (FrsActivityStatic.bQB || FrsActivityStatic.bQC) {
                this.bPr.bj(com.baidu.tbadk.coreExtra.messageCenter.a.yA().getMsgReplyme());
                this.bPr.bi(com.baidu.tbadk.coreExtra.messageCenter.a.yA().getMsgAtme());
                this.bPr.bl(com.baidu.tbadk.coreExtra.messageCenter.a.yA().yH());
                this.bPr.bk(com.baidu.tbadk.coreExtra.messageCenter.a.yA().getMsgChat());
                this.bPo.a(this.bPr);
                this.bPD.a(this.bPr);
            }
        }
    }

    private boolean dC(boolean z) {
        if (z && com.baidu.tieba.frs.utils.a.I(TbadkCoreApplication.m9getInst().getApplicationContext(), getClass().getName())) {
            Intent intent = new Intent();
            intent.putExtra("class", 2);
            intent.putExtra(ImageViewerConfig.FORUM_NAME, getIntent().getStringExtra("name"));
            intent.putExtra("from", "short_cut");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LogoActivityConfig(getPageContext().getPageActivity(), intent)));
            finish();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tieba.card.cd.NI().cs(false);
        if (this.bPq != null && this.bPq.aLP() != null) {
            dd.acn().bn(com.baidu.adp.lib.h.b.c(this.bPq.aLP().getId(), 0L));
        }
        if (this.bPo != null) {
            this.bPo.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.bPy != null) {
                this.bPy.onDestroy();
            }
            this.bPo.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.bPB.onActivityDestroy();
        this.bPC.onActivityDestroy();
        this.bQi = getVoiceManager();
        this.bQi.onDestory(getPageContext());
        if (this.bPz != null) {
            this.bPz.cancel(true);
            this.bPz = null;
        }
        if (this.bPB != null) {
            this.bPB.aaf();
        }
        if (this.bPD != null) {
            this.bPD.destroy();
        }
        if (this.bPJ != null) {
            this.bPJ.aco();
        }
        if (this.bPO != null) {
            this.bPO.destory();
        }
        if (this.bPP != null) {
            this.bPP.destory();
        }
        if (this.bPH != null) {
            this.bPH.onDestroy();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.bPf);
        bundle.putString("from", this.acU);
        this.bPB.onSaveInstanceState(bundle);
        this.bQi = getVoiceManager();
        if (this.bQi != null) {
            this.bQi.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.bg qL;
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    hM(0);
                    return;
                case 11002:
                    this.bPC.lN();
                    return;
                case 11011:
                    e(this.bPp);
                    return;
                case 11012:
                    f(this.bPs);
                    return;
                case 11014:
                    this.bPC.afB();
                    return;
                case 11016:
                    this.bPo.abA();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    this.bPC.aaU();
                    return;
                case 12016:
                    l(intent);
                    return;
                case 13003:
                    if (intent != null) {
                        try {
                            postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                        } catch (Exception e) {
                            postWriteCallBackData = null;
                        }
                        a(postWriteCallBackData);
                        return;
                    }
                    return;
                case 18003:
                    this.bPo.abJ().notifyDataSetChanged();
                    if (this.bPC != null) {
                        this.bPC.acF();
                    }
                    int intExtra = intent.getIntExtra("type", -1);
                    if (intExtra == 4) {
                        ci(6);
                        return;
                    }
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (qL = this.bPq.qL(stringExtra)) != null) {
                        if (intExtra == 2) {
                            qL.bW(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            qL.si();
                            return;
                        } else if (intExtra == 0) {
                            this.bPq.w(qL);
                            this.bPo.abB();
                            if (com.baidu.tieba.tbadkCore.d.bgZ() != null) {
                                com.baidu.tieba.tbadkCore.d.bgZ().R(this.bPf, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    aaJ();
                    return;
                case 23003:
                    if (intent != null && this.bPq != null) {
                        cl.a(this, this.bPq, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    cl.a(this, this.bPq, intent);
                    return;
                case 23013:
                    aaM();
                    return;
                case 23019:
                    aaN();
                    return;
                case 24002:
                    if (intent != null) {
                        int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                        int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                        int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                        int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                        if (intExtra2 == com.baidu.adp.lib.h.b.g(this.forumId, 0)) {
                            this.bPC.r(intExtra3, intExtra4, intExtra5);
                            return;
                        }
                        return;
                    }
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12003:
                default:
                    return;
            }
        }
    }

    private void l(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(WriteActivityConfig.TOGETHERHI_DATA);
            if (!TextUtils.isEmpty(stringExtra)) {
                int i = 0;
                if (this.bPq.getUserData() != null) {
                    i = this.bPq.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), 0, this.bPq.aLP().getId(), this.bPf, null, null, 0, this.bPq.qf(), 13003, false, false, null, false, false, null, null, this.bPq.aLP().getPrefixData(), i);
                if (cz.acl().hV(1) != null) {
                    writeActivityConfig.setCategroyId(this.bPB.aeK());
                }
                boolean GE = com.baidu.tbadk.plugins.g.GE();
                if (!this.bPq.getUserData().canPostHi()) {
                    GE = false;
                }
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.TOGETHERHI_SHOW, GE);
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.TOGETHERHI_DATA, stringExtra);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostWriteCallBackData postWriteCallBackData) {
        if (this.bPB != null) {
            if (this.bPB.acf() == 2 || this.bPB.acf() == 3) {
                int aeK = this.bPB.aeK();
                if (cz.acl().hV(1) == null) {
                    aeK = 0;
                }
                if (aeK == 0 && postWriteCallBackData != null) {
                    long c = com.baidu.adp.lib.h.b.c(postWriteCallBackData.getPostId(), 0L);
                    long c2 = com.baidu.adp.lib.h.b.c(postWriteCallBackData.getThreadId(), 0L);
                    long c3 = com.baidu.adp.lib.h.b.c(this.forumId, 0L);
                    if (c != 0 && c2 != 0 && c3 != 0) {
                        com.baidu.adp.lib.h.h.eG().postDelayed(new ai(this, c2, c, c3), 1000L);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bPo != null) {
            this.bPo.aby();
            try {
                if ("OPPO".equals(Build.MANUFACTURER) && this.bPo.abr() != null) {
                    Method declaredMethod = AbsListView.class.getDeclaredMethod("trackMotionScroll", Integer.TYPE, Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.bPo.getListView(), 500, 10);
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
        this.bPG.a(this.bPR);
        this.bOX = true;
        this.bPA = true;
        if (this.bPH != null) {
            this.bPH.ee(false);
        }
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.bPo.kv();
        } else if (bPc) {
            bPc = false;
            this.bPo.kv();
        } else {
            this.bQi = getVoiceManager();
            this.bQi.onResume(getPageContext());
            this.bPo.dL(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.bPo.dK(z);
        this.bPE.dW(z);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.bPf = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.acU = intent.getStringExtra("from");
            }
            this.bPh = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.bPh) {
                dD(intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false));
            }
        }
    }

    private void dD(boolean z) {
        this.bPo.kv();
        this.bPE.showContent(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.acU)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            } else {
                com.baidu.tbadk.core.d.b.f(getPageContext().getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.acU)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        } else {
            com.baidu.tbadk.core.d.b.f(getPageContext().getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.acU)) {
            finish();
        }
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.bPo.setTitle(this.bPf);
        } else {
            this.bPo.setTitle("");
            this.mFlag = 1;
        }
        this.bPC.c(this.bPo.getListView());
        this.bPo.a(this.bQk);
        this.bPo.a(this.bQl);
        this.bPo.setOnScrollListener(this.bQf);
        this.bPo.a(this.bQd);
        this.bPo.g(this.bOz);
        this.bPo.abJ().a(this.bQg);
        if (!this.mIsLogin) {
            this.bPo.dK(false);
            this.bPE.dW(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.bPo.onChangeSkinType(i);
        this.bPD.a(getPageContext(), i);
        this.bPC.a(getPageContext(), i);
        this.bPG.onChangeSkinType(i);
        changeSwipeSkinType(i);
        if (this.bPH != null) {
            this.bPH.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> aaC() {
        if (this.bPt == null) {
            this.bPt = FrsCommonImageLayout.p(getPageContext().getPageActivity(), 12);
        }
        return this.bPt;
    }

    @Override // com.baidu.adp.widget.f.b
    public void la() {
        setSwipeBackEnabled(true);
        this.bPE.dW(true);
    }

    @Override // com.baidu.adp.widget.f.b
    public void lb() {
        setSwipeBackEnabled(false);
        this.bPE.dW(false);
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<String, Integer, Boolean> {
        private final String name;

        public a(String str) {
            this.name = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(com.baidu.tieba.frs.utils.a.J(FrsActivity.this.getPageContext().getPageActivity(), this.name));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                FrsActivity.this.showToast(t.j.shortcut_has_add);
            } else {
                FrsActivity.this.jI(this.name);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jI(String str) {
        Intent K;
        if (str != null && (K = com.baidu.tieba.frs.utils.a.K(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(t.j.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", K);
            BarImageView afA = this.bPC.afA();
            if (afA != null && afA.getBdImage() != null && afA.getBdImage().jV() != null) {
                Bitmap jV = afA.getBdImage().jV();
                Float valueOf = Float.valueOf(getResources().getDisplayMetrics().density);
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.d.fT().a(com.baidu.adp.lib.util.d.fT().resizeBitmap(jV, valueOf.intValue() * 48), valueOf.intValue() * 6));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), t.f.icon));
            }
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    private void hM(int i) {
        if (!this.mIsLogin) {
            if (this.bPq != null && this.bPq.qf() != null) {
                this.bPq.qf().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.bPq != null) {
            if (i == 0) {
                if (!this.bPd) {
                    hN(0);
                    return;
                }
                TiebaStatic.log("c10152");
                hN(4);
                return;
            }
            this.bPo.abA();
        }
    }

    private void hN(int i) {
        int i2 = i == 4 ? 7 : i;
        int i3 = 0;
        if (this.bPq.getUserData() != null) {
            i3 = this.bPq.getUserData().getIsMem();
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), i2, this.bPq.aLP().getId(), this.bPf, null, null, 0, this.bPq.qf(), 13003, false, false, null, false, false, null, null, this.bPq.aLP().getPrefixData(), i3);
        if (cz.acl().hV(1) != null) {
            writeActivityConfig.setCategroyId(this.bPB.aeK());
        }
        boolean GE = com.baidu.tbadk.plugins.g.GE();
        if (!this.bPq.getUserData().canPostHi()) {
            GE = false;
        }
        writeActivityConfig.getIntent().putExtra(WriteActivityConfig.TOGETHERHI_SHOW, GE);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    public void aaD() {
        int i = 0;
        if (this.bPq.getUserData() != null) {
            i = this.bPq.getUserData().getIsMem();
        }
        EcommProductListActivityConfig ecommProductListActivityConfig = new EcommProductListActivityConfig(getPageContext().getPageActivity(), 7, this.bPq.aLP().getId(), this.bPf, null, null, 0, this.bPq.qf(), 13003, false, false, null, false, false, null, null, this.bPq.aLP().getPrefixData(), i, "");
        ecommProductListActivityConfig.addEcommAddress(this.bPl);
        if (cz.acl().hV(1) != null) {
            ecommProductListActivityConfig.setCategroyId(this.bPB.aeK());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, ecommProductListActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.bg bgVar) {
        boolean sq = bgVar == null ? true : bgVar.sq();
        this.bPo.a(new aj(this, bgVar));
        this.bPo.a(bgVar, sq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tbadk.core.data.bg bgVar) {
        boolean sq = bgVar == null ? true : bgVar.sq();
        if (this.mThreadId != null) {
            if (!sq) {
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(bgVar, this.bPf, null, 18003, true, true, this.bPm);
                createFromThreadCfg.setVideo_source("frs");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg2 = new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(bgVar, this.bPf, null, 18003, false, false, this.bPm);
            createFromThreadCfg2.setVideo_source("frs");
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.core.data.bg bgVar) {
        if (this.mThreadId != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(bgVar, this.bPf, null, 18003, false, false, this.bPm);
            createFromThreadCfg.setVideo_source("frs");
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void refresh() {
        ci(3);
    }

    public void ci(int i) {
        this.bPV = false;
        this.bOZ = false;
        this.bPn = false;
        aaO();
        aaV().B(i, true);
    }

    private void aaE() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.h.k.eH().f(new ak(this));
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaF() {
        aaO();
        try {
            if (this.bPq != null) {
                this.bPo.OG();
                this.bPo.abq();
                if (this.bPE != null && !this.bPE.isMenuShowing()) {
                    this.bPo.dF(true);
                }
                if (com.baidu.tieba.frs.i.p.j(this.bPq) && !com.baidu.tieba.frs.i.p.i(this.bPq)) {
                    this.bPo.abU();
                }
                this.bPf = this.bPq.aLP().getName();
                this.forumId = this.bPq.aLP().getId();
                this.bPo.setTitle(this.bPf);
                TbadkCoreApplication.m9getInst().setDefaultBubble(this.bPq.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(this.bPq.getUserData().getBimg_end_time());
                aaE();
                ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bPq.getThreadList();
                if (threadList != null) {
                    this.bPo.a(threadList, this.mPn, this.bPq, this.bPq.getPage().qq());
                    aaP();
                    this.bPC.iz(this.mPn);
                    this.bPC.f(this.bPq);
                    this.bPG.a(this.bPo.getListView(), this.bPq, this.bPB.aeU());
                    this.bPo.abB();
                    aaG();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aaG() {
        if (this.bPq != null) {
            if (this.bPq.aLY() == 1) {
                this.bPo.abJ().setFromCDN(true);
            } else {
                this.bPo.abJ().setFromCDN(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bOX = false;
        this.bPA = false;
        this.bPo.onPause();
        this.bQi = getVoiceManager();
        this.bQi.onPause(getPageContext());
        this.bPo.dL(true);
        if (this.bPP != null) {
            this.bPP.afd();
        }
        if (this.bPH != null) {
            this.bPH.ee(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Object d;
        super.onStop();
        com.baidu.tieba.card.cd.NI().cs(false);
        if (this.bPq != null && this.bPq.aLP() != null) {
            com.baidu.tbadk.distribute.a.Cp().b(getPageContext().getPageActivity(), "frs", this.bPq.aLP().getId(), 0L);
        }
        this.bQi = getVoiceManager();
        if (this.bQi != null) {
            this.bQi.onStop(getPageContext());
        }
        BdListView listView = getListView();
        if (listView != null && (d = com.baidu.adp.lib.a.a.a.d(listView, "mRecycler")) != null) {
            com.baidu.adp.lib.a.a.a.a("clear", d, d.getClass());
        }
        this.bPC.onActivityStop();
        com.baidu.tbadk.util.s.Hf();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.bPg) {
            if (i == 4) {
                if (this.bPE.isMenuShowing()) {
                    this.bPE.dX(true);
                    if (this.bPD.afE().act()) {
                        this.bPD.afE().dR(false);
                        refresh();
                        return true;
                    }
                    return true;
                } else if (this.bPo.abx()) {
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

    public boolean aaH() {
        if (this.bPF == null) {
            return false;
        }
        return this.bPF.isShowing();
    }

    public void aaI() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
        this.bPz = new a(this.bPf);
        this.bPz.setSelfExecute(true);
        this.bPz.execute(new String[0]);
    }

    public void aaJ() {
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.bPq.aLP().getId(), true, true, true);
    }

    @Override // com.baidu.tieba.recapp.b
    public BaseActivity<?> getContext() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.b
    public void a(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Cp().a(getPageContext().getPageActivity(), bVar, str, "frs", this.bPq.aLP().getId(), 0L);
    }

    @Override // com.baidu.tieba.recapp.b
    public void b(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Cp().a(bVar, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.b
    public void aaK() {
        aaV().aaK();
    }

    @Override // com.baidu.tieba.recapp.b
    public String aaL() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.b
    public int getPageNum() {
        return this.mPn;
    }

    public int getPn() {
        return this.mPn;
    }

    public void aaM() {
        if (checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10177").ab("fid", this.forumId));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(getPageContext().getPageActivity(), String.valueOf(getForumId()), false, 0)));
        }
    }

    public void aaN() {
        if (checkUpIsLogin() && this.bPe != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(getPageContext().getPageActivity()).createConfig(String.valueOf(getForumId()), this.bPe.getTid(), 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(int i) {
        ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bPq.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.bg) {
                    com.baidu.tbadk.core.data.bg bgVar = (com.baidu.tbadk.core.data.bg) next;
                    if (bgVar == this.bOW) {
                        c(bgVar, i);
                        this.bOW = null;
                        break;
                    } else if (bgVar.getId() != null && bgVar.getId().equals(this.bOY)) {
                        c(bgVar, i);
                        this.bOY = null;
                        break;
                    }
                }
            }
            this.bPo.abJ().a(threadList, this.bPq);
            this.bPo.abJ().notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tbadk.core.data.bg bgVar, int i) {
        if (i == 1) {
            PraiseData rt = bgVar.rt();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (rt == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bgVar.a(praiseData);
                    return;
                }
                bgVar.rt().getUser().add(0, metaData);
                bgVar.rt().setNum(bgVar.rt().getNum() + 1);
                bgVar.rt().setIsLike(i);
            }
        } else if (bgVar.rt() != null) {
            bgVar.rt().setIsLike(i);
            bgVar.rt().setNum(bgVar.rt().getNum() - 1);
            ArrayList<MetaData> user = bgVar.rt().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bgVar.rt().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bPO == null) {
                this.bPO = new com.baidu.tbadk.f.a(getPageContext());
            }
            this.bPO.ap(updateAttentionMessage.getData().toUid, getForumId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.tbadk.core.data.bg bgVar;
        ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bPq.getThreadList();
        if (threadList != null && updateAttentionMessage != null && updateAttentionMessage.getData() != null) {
            MetaData metaData = new MetaData();
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            MetaData metaData2 = metaData;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.bg) && (bgVar = (com.baidu.tbadk.core.data.bg) next) != null && bgVar.getAuthor() != null && bgVar.getAuthor().getUserId() != null && bgVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid) && !bgVar.getAuthor().equals(metaData2)) {
                    a(bgVar, updateAttentionMessage);
                    metaData2 = bgVar.getAuthor();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.bg bgVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        int i2;
        if (bgVar != null && bgVar.getAuthor() != null && bgVar.getAuthor().getUserId() != null && bgVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = bgVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
                i2 = 1;
            } else {
                i = fansNum - 1;
                i2 = 0;
            }
            bgVar.getAuthor().setFansNum(i);
            if (bgVar.getAuthor().getGodUserData() != null) {
                bgVar.getAuthor().getGodUserData().setFollowed(i2);
                bgVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bQi == null) {
            this.bQi = VoiceManager.instance();
        }
        return this.bQi;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: Os */
    public BdListView getListView() {
        if (this.bPo == null) {
            return null;
        }
        return this.bPo.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void aaO() {
        this.bQi = getVoiceManager();
        this.bQi.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int wE() {
        if (this.bPo == null) {
            return 0;
        }
        return this.bPo.abF();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> wF() {
        if (this.ahC == null) {
            this.ahC = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.ahC;
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
            if (this.bPr != null) {
                this.bPr.bj(msgReplyme);
                this.bPr.bi(msgAtme);
                this.bPr.bm(msgOfficialMerge);
                this.bPr.bk(msgChat);
                this.bPr.bl(msgStrangerChat);
                this.bPo.a(this.bPr);
                this.bPD.a(this.bPr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.bPq != null && this.bPo != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
            Iterator<DownloadData> it = data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().getStatus() == 0) {
                    z = true;
                    break;
                }
            }
            if (z) {
                com.baidu.adp.lib.h.h.eG().postDelayed(new am(this), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }

    private void aaP() {
        HashMap<Integer, com.baidu.tbadk.core.data.bg> acX;
        if (this.bPo != null && this.bPo.abJ() != null && (acX = this.bPo.abJ().acX()) != null) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.bg> entry : acX.entrySet()) {
                com.baidu.tbadk.core.data.bg value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.b)) {
                    arrayList.add((com.baidu.tbadk.core.data.b) value);
                }
            }
            com.baidu.tieba.recapp.b.a.bbr().o(arrayList);
        }
    }

    public void aaQ() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.b(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    /* loaded from: classes.dex */
    class b implements com.baidu.adp.widget.ListView.w {
        b() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v39, resolved type: com.baidu.tieba.frs.FrsActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
            PhotoLiveActivityConfig oW;
            PbActivityConfig createFromThreadCfg;
            if (bdUniqueId != null && vVar != null && (vVar instanceof com.baidu.tbadk.core.data.bg)) {
                com.baidu.tbadk.core.data.bg bgVar = (com.baidu.tbadk.core.data.bg) vVar;
                if (bgVar.sl() == null || bgVar.sl().getGroup_id() == 0 || FrsActivity.this.checkUpIsLogin()) {
                    if ((bgVar.se() != 1 && bgVar.se() != 2) || FrsActivity.this.checkUpIsLogin()) {
                        if (bgVar.rN() != null) {
                            if (FrsActivity.this.checkUpIsLogin()) {
                                String postUrl = bgVar.rN().getPostUrl();
                                if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.gD()) {
                                    com.baidu.tbadk.browser.f.v(FrsActivity.this.getActivity(), postUrl);
                                }
                            }
                        } else if (bgVar.sw() != null) {
                            com.baidu.tbadk.core.data.m sw = bgVar.sw();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsActivity.this.getPageContext().getPageActivity(), sw.getCartoonId(), sw.getChapterId(), 2)));
                        } else if (bgVar.getThreadType() == 47 && bgVar.rx() == 1 && !com.baidu.tbadk.core.util.ba.isEmpty(bgVar.rH())) {
                            com.baidu.tbadk.browser.f.u(FrsActivity.this.getPageContext().getPageActivity(), bgVar.rH());
                        } else {
                            com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.rf(bgVar.getId())) {
                                readThreadHistory.re(bgVar.getId());
                            }
                            boolean z = false;
                            String rH = bgVar.rH();
                            if (rH != null && !rH.equals("")) {
                                z = true;
                                new Thread(new at(this, rH)).start();
                            }
                            String tid = bgVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (bgVar.rx() == 2 && !tid.startsWith("pb:")) {
                                com.baidu.tbadk.core.util.bi vx = com.baidu.tbadk.core.util.bi.vx();
                                TbPageContext<?> pageContext = FrsActivity.this.getPageContext();
                                String[] strArr = new String[3];
                                strArr[0] = tid;
                                strArr[1] = "";
                                vx.c(pageContext, strArr);
                                return;
                            }
                            boolean z2 = false;
                            if (bgVar instanceof com.baidu.tbadk.core.data.w) {
                                z2 = true;
                                TiebaStatic.log("c10769");
                            }
                            if (bgVar.getThreadType() == 33 || (bgVar instanceof com.baidu.tbadk.core.data.ar)) {
                                if (!z2) {
                                    String str = bgVar.getThreadType() == 33 ? "c10245" : "c10180";
                                    if (FrsActivity.this.bPB.aeM() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ay(str).ab("fid", FrsActivity.this.forumId));
                                }
                                if (bgVar.rV() > 0 && com.baidu.tieba.tbadkCore.util.t.bke()) {
                                    oW = new PhotoLiveActivityConfig.a(FrsActivity.this.getPageContext().getPageActivity(), bgVar.getTid()).ck("from_frs").bF(18003).ci(String.valueOf(bgVar.rV())).oW();
                                } else {
                                    oW = new PhotoLiveActivityConfig.a(FrsActivity.this.getPageContext().getPageActivity(), bgVar.getTid()).ck("from_frs").bF(18003).oW();
                                }
                                FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, oW));
                                if (FrsActivity.this.bPq != null && FrsActivity.this.bPq.aLP() != null) {
                                    com.baidu.tieba.frs.g.a aVar = new com.baidu.tieba.frs.g.a();
                                    aVar.cdd = FrsActivity.this.bPq.fpX == 1;
                                    aVar.cdf = FrsActivity.this.bPq.aLP().getId();
                                    aVar.cde = FrsActivity.this.aaV().acf();
                                    com.baidu.tieba.frs.g.b.aeX().a(aVar, bgVar, 1);
                                    return;
                                }
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                bgVar.setId(tid.substring(3));
                            }
                            if (!z2 && FrsActivity.this.bPB.aeM() == 2) {
                                com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c10077");
                                ayVar.s("obj_source", FrsActivity.this.bPB.aeM());
                                ayVar.ab("tid", bgVar.getId());
                                ayVar.ab("fid", FrsActivity.this.getForumId());
                                TiebaStatic.log(ayVar);
                            }
                            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.bg.Uo.getId() && bgVar.sc() == 2 && bgVar.rl() != null) {
                                String ps = bgVar.rl().ps();
                                if (StringUtils.isNull(ps)) {
                                    ps = bgVar.rl().getTaskId();
                                }
                                com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bgVar.rl().getForumId(), bgVar.rl().getForumName(), bgVar.rl().getThreadId(), "tieba.baidu.com/p/" + bgVar.rl().getThreadId(), ps);
                                if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
                                    FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(FrsActivity.this.getPageContext().getPageActivity()).createNormalCfg(bgVar.rl().getThreadId(), bgVar.rl().getTaskId(), bgVar.rl().getForumId(), bgVar.rl().getForumName(), bgVar.rx(), bgVar.ry())));
                                    return;
                                }
                            }
                            com.baidu.tbadk.core.util.ay ab = new com.baidu.tbadk.core.util.ay("c10806").s("obj_locate", 3).ab("tid", bgVar.getId());
                            if (bgVar.getAuthor() != null && bgVar.getAuthor().getGodInfo() != null) {
                                TiebaStatic.log(ab);
                            }
                            if (FrsActivity.this.bPq != null && FrsActivity.this.bPq.aLP() != null) {
                                com.baidu.tieba.frs.g.a aVar2 = new com.baidu.tieba.frs.g.a();
                                aVar2.cdd = FrsActivity.this.bPq.fpX == 1;
                                aVar2.cdf = FrsActivity.this.bPq.aLP().getId();
                                aVar2.cde = FrsActivity.this.aaV().acf();
                                com.baidu.tieba.frs.g.b.aeX().a(aVar2, bgVar, 1);
                            }
                            if (bgVar.rV() > 0 && com.baidu.tieba.tbadkCore.util.t.bke()) {
                                createFromThreadCfg = new PbActivityConfig(FrsActivity.this.getPageContext().getPageActivity()).createHistoryCfg(bgVar.getTid(), String.valueOf(bgVar.rV()), false, true, null);
                            } else {
                                createFromThreadCfg = new PbActivityConfig(FrsActivity.this.getPageContext().getPageActivity()).createFromThreadCfg(bgVar, FrsActivity.this.bPf, null, 18003, true, false, z);
                            }
                            if (i == 4) {
                                createFromThreadCfg.setVideo_source("floor5");
                            } else {
                                createFromThreadCfg.setVideo_source("frs");
                            }
                            FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                            if (bgVar.Uw != null) {
                                com.baidu.tbadk.core.util.ay ayVar2 = new com.baidu.tbadk.core.util.ay("c11430");
                                ayVar2.ab("tid", bgVar.getTid());
                                ayVar2.ab("obj_id", new StringBuilder(String.valueOf(bgVar.Uw.productId)).toString());
                                if (ayVar2 != null) {
                                    TiebaStatic.log(ayVar2);
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
        if (com.baidu.adp.lib.util.k.gD()) {
            hideNetRefreshView(this.bPo.getRootView());
            showLoadingView(this.bPo.getRootView(), true);
            this.bPo.dJ(false);
            this.bPo.kv();
        }
    }

    public com.baidu.tieba.tbadkCore.p aaR() {
        return this.bPq;
    }

    public boolean aaS() {
        return this.bPo.aaS();
    }

    public void aaT() {
        FrsActivityStatic.bQB = false;
        FrsActivityStatic.bQC = false;
        aaB();
    }

    public void aaU() {
        this.bPC.aaU();
    }

    public com.baidu.tieba.frs.e.a aaV() {
        return this.bPB;
    }

    public bm aaW() {
        return this.bPo;
    }

    public void jJ(String str) {
        this.bPf = str;
    }

    public void setFrom(String str) {
        this.acU = str;
    }

    public String getFrom() {
        return this.acU;
    }

    public void setFlag(int i) {
        this.mFlag = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    public com.baidu.tieba.frs.i.y aaX() {
        return this.bPE;
    }

    public com.baidu.tieba.frs.ecomm.a aaY() {
        if (this.bPN == null) {
            this.bPN = new com.baidu.tieba.frs.ecomm.a(this);
            this.bPN.a(new an(this));
        }
        return this.bPN;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        if (!com.baidu.adp.lib.util.k.gD()) {
            this.bPo.abP();
        } else if (this.bPB.aeM() == 1) {
            aaZ();
            aba();
        } else if (this.bPB.hasMore()) {
            aba();
        }
    }

    public void jK(String str) {
        aaZ();
        showToast(str);
    }

    public void L(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        aaZ();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bPK.a(false, arrayList, this.bPk);
            if (a2 != null) {
                this.bPq.aA(a2);
                this.bPo.a(a2, this.mPn, this.bPq, 0);
            }
            if (aaV() != null) {
                com.baidu.tieba.frs.g.b.a(this.bPq, aaV().acf(), 2);
            }
        }
    }

    private void aaZ() {
        if (this.bPL == 0 && !this.bPK.az(this.bPq.bhk())) {
            if (this.bPq.getThreadList() == null || this.bPq.getThreadList().size() == 0) {
                this.bPo.abP();
                return;
            } else {
                this.bPo.abO();
                return;
            }
        }
        this.bPo.abN();
    }

    public void aba() {
        if (this.bPB.aeM() == 1) {
            if (!this.bPK.aAl && !this.bPB.Fd()) {
                if (this.bPK.az(this.bPq.bhk())) {
                    this.bPo.a(this.bPK.adQ(), this.mPn, this.bPq, 0);
                    this.bPK.setSortType(this.bPB.aeT());
                    this.bPK.a(com.baidu.adp.lib.h.b.c(this.forumId, 0L), this.bPq.bhk(), this.bPf, this.mPn);
                } else if (this.bPL != 0) {
                    this.bPo.a(this.bPK.adQ(), this.mPn, this.bPq, 0);
                    this.mPn++;
                    this.bPB.il(this.mPn);
                    this.bPK.bZy = false;
                    this.bPK.bZz = 0;
                }
            }
        } else if (!this.bPB.aeP()) {
            this.bPB.Op();
        }
    }

    public boolean abb() {
        return this.bPD.afE().act();
    }

    public void dE(boolean z) {
        this.bPD.afE().dR(z);
    }

    public void abc() {
        if (!com.baidu.tbadk.core.util.ag.d(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.au.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a006";
    }

    @Override // android.app.Activity, com.baidu.a.a.a.InterfaceC0000a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ag.aa(getApplicationContext())) {
                com.baidu.tbadk.core.util.au.c(getPageContext());
            } else {
                showToast(t.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ag.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(t.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    public com.baidu.adp.widget.ListView.w abd() {
        return this.bQk;
    }

    public com.baidu.adp.widget.ListView.x abe() {
        return this.bQl;
    }

    public com.baidu.tieba.frs.entelechy.b.b abf() {
        return this.bPM;
    }

    public bm abg() {
        return this.bPo;
    }

    public void abh() {
        if (this.bPP != null) {
            this.bPP.afd();
        }
    }

    public void jL(String str) {
        if (this.boU == null) {
            this.boU = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.boU.dT(str);
        this.boU.aF(true);
    }
}
