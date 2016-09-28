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
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d.a;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.d.a;
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
public class FrsActivity extends BaseActivity<FrsActivity> implements a.InterfaceC0000a, BdListView.e, f.b, UserIconBox.b, VoiceManager.c, di, com.baidu.tieba.recapp.b {
    public static String bON = "speed_icon_show";
    private static final int bOO = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds90);
    private static final int bOP = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds300);
    public static boolean bOW = false;
    public static volatile long bPm = 0;
    public static volatile long bPn = 0;
    public static volatile int bPo = 0;
    private static boolean isNeedRefreshOnResume = false;
    private com.baidu.adp.lib.f.b<TbImageView> ahk;
    private com.baidu.tbadk.core.data.bi bOQ;
    private boolean bOR;
    private String bOS;
    private com.baidu.tieba.frs.entelechy.b.a bOU;
    private boolean bOX;
    private com.baidu.tbadk.core.data.bi bOY;
    private com.baidu.tieba.d.c bPA;
    private dj bPB;
    private com.baidu.tieba.frs.loadmore.a bPC;
    private com.baidu.tieba.frs.entelechy.b.b bPF;
    private com.baidu.tieba.frs.ecomm.a bPG;
    private com.baidu.tbadk.e.a bPH;
    private com.baidu.tieba.frs.i.a bPI;
    private com.baidu.tieba.tbadkCore.data.f bPe;
    private String bPf;
    private ct bPl;
    private a bPr;
    private com.baidu.tieba.frs.e.a bPt;
    private com.baidu.tieba.frs.i.p bPu;
    private com.baidu.tieba.frs.i.aa bPv;
    private com.baidu.tieba.frs.i.y bPw;
    private com.baidu.tieba.frs.view.p bPx;
    private com.baidu.tieba.frs.entelechy.b.d bPy;
    private com.baidu.tieba.frs.headvideo.c bPz;
    VoiceManager bQb;
    private com.baidu.tbadk.core.view.a bph;
    private boolean bOT = false;
    public boolean bOV = false;
    public String bOZ = null;
    public String adg = null;
    public int mFlag = 0;
    private int mPn = 1;
    private boolean bPa = false;
    private boolean bPb = false;
    private String mThreadId = null;
    private String forumId = null;
    private int bPc = 0;
    private boolean bPd = false;
    private boolean bPg = false;
    private boolean bPh = false;
    private bm bPi = null;
    private final com.baidu.tbadk.core.data.bi bPj = null;
    private com.baidu.tieba.tbadkCore.p bPk = new com.baidu.tieba.tbadkCore.p();
    private com.baidu.tbadk.core.data.bi aLV = null;
    public long bGX = -1;
    public long aBU = 0;
    public long aBM = 0;
    public long createTime = 0;
    public long Rf = -1;
    private boolean bPp = false;
    public com.baidu.tbadk.performanceLog.e bPq = null;
    private boolean bPs = true;
    private int bPD = -1;
    private boolean bPE = true;
    private dh bPJ = new d(this);
    private dg bPK = new o(this);
    private CustomMessageListener ahi = new ab(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener bNr = new an(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
    private CustomMessageListener bPL = new ao(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private CustomMessageListener aVv = new ap(this, CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND);
    public final CustomMessageListener bPM = new aq(this, CmdConfigCustom.MSG_NEW);
    private CustomMessageListener bPN = new ar(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    private boolean bPO = false;
    public final com.baidu.tieba.tbadkCore.r bPP = new as(this);
    private final CustomMessageListener Oi = new e(this, CmdConfigCustom.CMD_REFRESH);
    CustomMessageListener bPQ = new f(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
    private final CustomMessageListener mMemListener = new g(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private CustomMessageListener bPR = new h(this, CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS);
    public View.OnTouchListener aJD = new i(this);
    private a.InterfaceC0058a aMy = new j(this);
    private CustomMessageListener bPS = new k(this, CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE);
    private final CustomMessageListener bPT = new l(this, CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY);
    private final com.baidu.adp.framework.listener.a bPU = new m(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    private final com.baidu.adp.framework.listener.a bPV = new n(this, CmdConfigHttp.CMD_SET_COMMON_FORUM_STATE, 309365);
    private y.b agD = new p(this);
    private y.c agF = new q(this);
    private y.a agE = new r(this);
    private final BdExpandListView.a bPW = new s(this);
    public final View.OnClickListener bPX = new t(this);
    private final AbsListView.OnScrollListener bPY = new u(this);
    private final ba bPZ = new w(this);
    private final com.baidu.tieba.tbadkCore.ai bQa = new com.baidu.tieba.tbadkCore.ai(getPageContext(), new y(this));
    private CustomMessageListener bnV = new z(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private final NoNetworkView.a aRn = new aa(this);
    private final CustomMessageListener bQc = new ac(this, 0);
    private com.baidu.adp.widget.ListView.w bQd = new b();
    private com.baidu.adp.widget.ListView.x bQe = new ad(this);
    public final com.baidu.adp.base.g bQf = new ae(this);
    public final com.baidu.adp.base.g bQg = new af(this);
    private dh bQh = new ag(this);

    @Override // com.baidu.tieba.frs.di
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.di
    public String getForumName() {
        return this.bOZ;
    }

    public com.baidu.tieba.frs.headvideo.c aaJ() {
        return this.bPz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.y yVar) {
        if (yVar != null) {
            boolean z = yVar.isLike() == 1;
            if (this.bPi != null && this.bPk != null && this.bPk.aMr() != null && yVar.getFid() != null) {
                if (yVar.getFid().equals(this.bPk.aMr().getId())) {
                    this.bPk.aMr().setLike(yVar.isLike());
                    if (!StringUtils.isNULL(yVar.getLevelName())) {
                        this.bPk.aMr().setLevelName(yVar.getLevelName());
                    }
                    if (yVar.getUserLevel() >= 0) {
                        this.bPk.aMr().setUser_level(yVar.getUserLevel());
                    }
                    if (z) {
                        this.bPu.a(this.bPk, false);
                        this.bPv.ei(true);
                        TbadkCoreApplication.m9getInst().addLikeForum(this.bOZ);
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.bhH().R(this.bOZ, false);
                    this.bPk.aMr().setLike(0);
                    this.bPu.afI();
                    this.bPv.ei(false);
                    TbadkCoreApplication.m9getInst().delLikeForum(this.bOZ);
                    return;
                }
                if (yVar.isLike() == 1) {
                    this.bPk.qX(yVar.getFid());
                    this.bPu.f(this.bPk);
                    this.bPy.a(this.bPi.abN(), this.bPk, this.bPt.afi());
                }
                if (this.bPk.aMr().getBannerListData() != null) {
                    this.bPk.aMr().getBannerListData().setFeedForumLiked(yVar.getFid(), yVar.isLike());
                }
                this.bPi.abK();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    public void a(ErrorData errorData) {
        this.bPi.dI(false);
        this.bPi.abK();
        hideLoadingView(this.bPi.getRootView());
        this.bPi.dJ(false);
        this.bPi.abR();
        if (!this.bPh) {
            e.a aeW = abi().aeW();
            if (!this.bOT) {
                if (aeW != null) {
                    if (this.bPt.aeY() != 0) {
                        this.bPt.afe();
                        this.bPi.abK();
                    } else {
                        if (aeW.fsg) {
                            if (340001 == aeW.errorCode) {
                                showNetRefreshViewNoClick(this.bPi.getRootView(), getPageContext().getResources().getString(r.j.net_error_text, aeW.errorMsg, Integer.valueOf(aeW.errorCode)), true);
                            } else {
                                showNetRefreshView(this.bPi.getRootView(), getPageContext().getResources().getString(r.j.net_error_text, aeW.errorMsg, Integer.valueOf(aeW.errorCode)), true);
                            }
                        } else if (340001 == aeW.errorCode) {
                            showNetRefreshViewNoClick(this.bPi.getRootView(), aeW.errorMsg, true);
                        } else {
                            showNetRefreshView(this.bPi.getRootView(), aeW.errorMsg, true);
                        }
                        setNetRefreshViewEmotionDefMarginTop();
                        if (this.bPi.abG() != null) {
                            this.bPi.abG().setVisibility(8);
                        }
                        if (this.bPw != null) {
                            this.bPw.dX(false);
                        }
                    }
                    this.bPi.n(false, false);
                }
            } else if (aeW != null && aeW.fsg) {
                this.bPi.n(true, false);
                showToast(getPageContext().getResources().getString(r.j.net_error_text, aeW.errorMsg, Integer.valueOf(aeW.errorCode)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aaK() {
        if (this.bPy != null && this.bPi != null) {
            this.bPy.u(this.bPi.abN());
        }
        if (this.bPu != null && abi() != null) {
            this.bPu.a(abi().aeV(), this.bPk);
        }
        boolean z = false;
        if (this.bPk != null) {
            z = this.bPk.biP();
        }
        dB(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hP(int i) {
        dn dnVar = null;
        aaK();
        abb();
        try {
            if (this.bPk != null) {
                this.bPi.a(null, 1, this.bPk, 0);
                this.bPu.iE(1);
                this.bPi.abO();
                this.bPy.a(this.bPi.abN(), this.bPk, this.bPt.afi());
                com.baidu.tieba.frs.tab.i a2 = a(this.bPy.adv(), this.bPk.bii());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    dnVar = new dn();
                    dnVar.bTy = a2.url;
                    dnVar.stType = a2.name;
                }
                this.bPt.a(this.bPk.bii(), 0, dnVar);
                this.bPy.dW(false);
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
            if (iVar != null && iVar.cdC == i) {
                return iVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.n nVar) {
        int bii;
        if (!this.bPO && nVar != null) {
            try {
                if (this.bPk != null) {
                    this.bPk.d(nVar);
                    aaU();
                    this.bPD = this.bPk.getPage().qB();
                    boolean biP = this.bPk.biP();
                    String str = "normal_page";
                    if (com.baidu.tieba.frs.i.p.i(this.bPk)) {
                        str = "book_page";
                    } else if (com.baidu.tieba.frs.i.p.j(this.bPk)) {
                        str = "frs_page";
                    }
                    this.bPy.u(this.bPi.abN());
                    this.bPu.e(str, this.bPk.getUserData().getIsMem(), this.bPk.aMr().isLike());
                    dB(biP);
                    if (this.bPF != null) {
                        this.bPF.a(this.bPu, this.bPk);
                    }
                    this.bPi.JK();
                    this.bOZ = this.bPk.aMr().getName();
                    this.forumId = this.bPk.aMr().getId();
                    this.bPi.setTitle(this.bOZ);
                    aaS();
                    this.bPk.biB();
                    if (this.bPi.abW().k(com.baidu.tieba.tbadkCore.al.fud)) {
                        this.bPk.biC();
                    }
                    if (!this.bPt.afg()) {
                        this.bPk.biI();
                    }
                    if (!abi().aeX()) {
                        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) && !this.bPt.afg()) {
                            this.bPk.biH();
                            this.bPk.biG();
                            this.bPk.biE();
                        }
                        if (!this.bPt.afg()) {
                            this.bPk.biF();
                        }
                    }
                    if (!((!this.bPi.abW().k(com.baidu.tieba.card.data.q.bcA) || this.bPt.afg()) ? false : this.bPk.biL()) && !this.bPt.afg()) {
                        this.bPk.biK();
                    }
                    if (TbadkCoreApplication.m9getInst().isRecAppExist()) {
                        this.bPk.bc(getPageContext().getPageActivity());
                    }
                    this.bPk.biA();
                    com.baidu.tbadk.core.data.bn top_notice_data = this.bPk.aMr().getTop_notice_data();
                    if (top_notice_data != null && top_notice_data.getTitle() != null) {
                        com.baidu.tbadk.core.data.bi biVar = new com.baidu.tbadk.core.data.bi();
                        biVar.setTitle(top_notice_data.getTitle());
                        biVar.bV(2);
                        biVar.cu(top_notice_data.sY());
                        biVar.su();
                        this.bPk.v(biVar);
                    }
                    this.bPk.biM();
                    if (this.bPt.ccM && (bii = nVar.bii()) != 1) {
                        this.bOT = true;
                        hP(bii);
                        return;
                    }
                    ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bPk.getThreadList();
                    if (threadList != null) {
                        ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bPC.a(true, threadList);
                        if (a2 != null) {
                            this.bPk.aA(a2);
                        }
                        this.bPi.a(threadList, this.mPn, this.bPk, this.bPk.getPage().qB());
                        abc();
                        this.bPu.iE(this.mPn);
                        this.bPu.f(this.bPk);
                        this.bPy.a(this.bPi.abN(), this.bPk, this.bPt.afi());
                        this.bPi.abO();
                    }
                    this.bPc = this.bPk.afc();
                    if (this.bPe != null) {
                        this.bPd = true;
                        this.bPe.rI(this.bPc);
                    }
                    hideLoadingView(this.bPi.getRootView());
                    if (this.bPi.abG() != null && this.mIsLogin) {
                        this.bPi.abG().setVisibility(0);
                    }
                    if (this.bPw != null && this.mIsLogin) {
                        this.bPw.dX(true);
                    }
                    if (this.bPw != null && !this.bPw.isMenuShowing()) {
                        this.bPi.dG(true);
                    }
                    this.bPi.dJ(false);
                    if (this.bPk.aMr().isIs_forbidden() == 1) {
                        this.bPv.ek(false);
                    } else {
                        this.bPv.ek(true);
                    }
                    this.bPv.ej(this.bPk.bhL() == 1);
                    this.bOT = true;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void dB(boolean z) {
        if (abi() != null) {
            dC("frs_page".equals(abi().aeV()));
        }
        if (this.bPF != null) {
            this.bPF.a(z, this.bPy, this.bPu, this.bPi, this.bPk);
        }
    }

    private void dC(boolean z) {
        if (this.bPi != null) {
            if (z) {
                this.bPi.ack();
                this.bPi.a(this.agD);
                this.bPi.a(this.agF);
                this.bPi.a(this.agE);
                return;
            }
            this.bPi.acl();
            this.bPi.a(this.bPW);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        bON = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (intent != null) {
            this.bGX = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (intent.getData() != null) {
                Uri data = intent.getData();
                this.bOZ = data.getQueryParameter("name");
                this.adg = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.bOZ)) {
                    intent.putExtra("name", this.bOZ);
                }
                if (!StringUtils.isNull(this.adg)) {
                    intent.putExtra("from", this.adg);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.bOZ)) {
                this.bOZ = k(intent);
                if (!StringUtils.isNull(this.bOZ)) {
                    intent.putExtra("name", this.bOZ);
                }
            }
        } else {
            this.bGX = System.currentTimeMillis();
        }
        this.Rf = System.currentTimeMillis();
        this.aBM = this.Rf - this.bGX;
        if (!dD(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.Rf;
            return;
        }
        super.onCreate(bundle);
        this.bPt = new com.baidu.tieba.frs.e.a(this);
        this.bPt.a(this.bPJ);
        this.bPt.init();
        if (getIntent() != null) {
            this.bPt.d(getIntent().getExtras());
        } else if (bundle != null) {
            this.bPt.d(bundle);
        } else {
            this.bPt.d(null);
        }
        abi().B(3, true);
        this.bOU = new com.baidu.tieba.frs.entelechy.i();
        this.bPF = this.bOU.acU();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(r.h.frs_activity, (ViewGroup) null);
        this.bPw = new com.baidu.tieba.frs.i.y(this, this.bOU.acT());
        this.bPv = new com.baidu.tieba.frs.i.aa(this);
        this.bPw.a(getPageContext().getPageActivity(), inflate, this.bPv.afS().getView());
        this.bPu = new com.baidu.tieba.frs.i.p(this, this.bOU);
        this.bPy = this.bOU.M(this);
        this.bPi = new bm(this, this.bPX, this.bOU);
        this.bPu.a(this.bPi.JP());
        this.bPy.ad(this.bPi.getRootView());
        if (getIntent() != null) {
            this.bPu.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.bPu.f(bundle);
        } else {
            this.bPu.f((Bundle) null);
        }
        this.bQb = getVoiceManager();
        this.bQb.onCreate(getPageContext());
        initUI();
        initData(bundle);
        this.bPi.setForumName(this.bOZ);
        this.bQa.setUniqueId(getUniqueId());
        this.bQa.registerListener();
        addGlobalLayoutListener();
        aaO();
        aaN();
        aaM();
        registerListener(this.Oi);
        registerListener(this.mMemListener);
        registerListener(this.bPM);
        registerListener(this.ahi);
        registerListener(this.aVv);
        registerListener(this.bNr);
        registerListener(this.bPN);
        registerListener(this.bPR);
        registerListener(this.bPS);
        registerListener(this.bnV);
        registerListener(this.bPL);
        registerListener(this.bPQ);
        this.bPU.ci().setSelfListener(true);
        this.bPU.ch().setSelfListener(true);
        this.bPU.setTag(getUniqueId());
        registerListener(this.bPU);
        registerListener(this.bPV);
        this.bPC = new com.baidu.tieba.frs.loadmore.a(this);
        this.bPC.registerListener();
        this.bPe = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.fuE);
        this.createTime = System.currentTimeMillis() - this.Rf;
        if (this.bPi != null) {
            showLoadingView(this.bPi.getRootView(), true);
            this.bPi.dK(false);
        }
        this.bPB = new dj(getActivity(), this.bPi, this.bPu);
        this.bPB.dP(true);
        this.bPA = new com.baidu.tieba.d.c(getActivity());
        this.bPA.a(this.aMy);
        this.bPI = new com.baidu.tieba.frs.i.a(getPageContext(), this.bPt.aff());
        this.bPz = new com.baidu.tieba.frs.headvideo.c(this, this.bPi.getRootView(), this.bPu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaL() {
        com.baidu.tbadk.data.e eVar = new com.baidu.tbadk.data.e();
        if (this.bPk != null && this.bPk.aMr() != null) {
            eVar.setForumId(com.baidu.adp.lib.h.b.c(this.bPk.aMr().getId(), 0L));
            eVar.fd(this.bPk.aMr().getName());
            eVar.fe(this.bPk.aMr().getImage_url());
            eVar.eo(this.bPk.aMr().getSigned() ? 1 : 0);
            eVar.en(this.bPk.aMr().getUser_level());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_SET_COMMON_ACCESS_FORUM, eVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
        } else if (this.bPk != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null && this.bPi != null) {
            com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(getMyPostResIdl.data.thread_info.author);
            a(metaData, getMyPostResIdl.data.user_info, getMyPostResIdl.data.thread_info.twzhibo_info);
            metaData.setPortrait(TbadkCoreApplication.getCurrentPortrait());
            String userId = metaData.getUserId();
            if (userId != null && !userId.equals("0")) {
                hashMap.put(metaData.getUserId(), metaData);
            }
            ajVar.setUserMap(hashMap);
            ajVar.a(getMyPostResIdl.data.thread_info);
            this.bPt.a(ajVar);
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bPC.a(true, this.bPk.getThreadList());
            if (a2 != null) {
                this.bPk.aA(a2);
                this.bPk.biA();
                this.bPi.a(a2, this.mPn, this.bPk, this.bPD);
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
                    str = getPageContext().getResources().getString(r.j.fans_default_name);
                }
                metaData.setFansNickName(str);
            }
        }
    }

    private void aaM() {
        com.baidu.tbadk.task.b a2 = com.baidu.tieba.tbadkCore.a.a.a(309360, ResponseIncrForumAccessCountSocketMessage.class, false, false);
        a2.setResponsedClass(ResponseIncrForumAccessCountSocketMessage.class);
        a2.l(true);
        a2.m(false);
        a2.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(a2);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_INCREASE_FORUM_ACCESS_COUNT, com.baidu.tieba.tbadkCore.a.a.aF(TbConfig.INCR_FORUM_ACCESS_ACOUNT, 309360));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ResponseIncrForumAccessCountHttpMessage.class);
        tbHttpMessageTask.setIsImm(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void aaN() {
        com.baidu.tbadk.task.b a2 = com.baidu.tieba.tbadkCore.a.a.a(309365, ResponseSetCommForumStateSocketMessage.class, false, false);
        a2.setResponsedClass(ResponseSetCommForumStateSocketMessage.class);
        a2.l(true);
        a2.m(false);
        a2.a(SocketMessageTask.DupLicateMode.NONE);
        MessageManager.getInstance().registerTask(a2);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SET_COMMON_FORUM_STATE, com.baidu.tieba.tbadkCore.a.a.aF(TbConfig.SET_COMMON_FORUM_STATE, 309365));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(ResponseSetCommForumStateHttpMessage.class);
        tbHttpMessageTask.setIsImm(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void aaO() {
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
        this.bQb = getVoiceManager();
        this.bQb.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bQc);
        if (bundle != null) {
            this.bOZ = bundle.getString("name");
            this.adg = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bOZ = intent.getStringExtra("name");
                this.adg = intent.getStringExtra("from");
                this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.adg) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.adg)) {
            setSwipeBackEnabled(false);
        }
        this.bPl = new ct(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            aaP();
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.bQc);
        }
        this.bPu.f(bundle);
    }

    private String k(Intent intent) {
        int indexOf;
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (!StringUtils.isNull(dataString) && dataString.startsWith("tbfrs://")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c10320").s("obj_locate", 2).s("obj_type", 1));
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (StringUtils.isNull(decode) || (indexOf = decode.indexOf("kw=")) < 0 || (length = indexOf + "kw=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public void aaP() {
        if (this.bPl != null && this.bPi != null) {
            if (FrsActivityStatic.bQu || FrsActivityStatic.bQv) {
                this.bPl.bj(com.baidu.tbadk.coreExtra.messageCenter.a.yD().getMsgReplyme());
                this.bPl.bi(com.baidu.tbadk.coreExtra.messageCenter.a.yD().getMsgAtme());
                this.bPl.bl(com.baidu.tbadk.coreExtra.messageCenter.a.yD().yK());
                this.bPl.bk(com.baidu.tbadk.coreExtra.messageCenter.a.yD().getMsgChat());
                this.bPi.a(this.bPl);
                this.bPv.a(this.bPl);
            }
        }
    }

    private boolean dD(boolean z) {
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
        com.baidu.tieba.card.cb.Oj().cs(false);
        if (this.bPk != null && this.bPk.aMr() != null) {
            dd.acA().bn(com.baidu.adp.lib.h.b.c(this.bPk.aMr().getId(), 0L));
        }
        if (this.bPi != null) {
            aaQ();
            this.bPi.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.bPq != null) {
                this.bPq.onDestroy();
            }
            this.bPi.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.bPt.onActivityDestroy();
        this.bPu.onActivityDestroy();
        this.bQb = getVoiceManager();
        this.bQb.onDestory(getPageContext());
        if (this.bPr != null) {
            this.bPr.cancel(true);
            this.bPr = null;
        }
        if (this.bPt != null) {
            this.bPt.aat();
        }
        if (this.bPv != null) {
            this.bPv.destroy();
        }
        if (this.bPB != null) {
            this.bPB.Za();
        }
        if (this.bPH != null) {
            this.bPH.destory();
        }
        if (this.bPI != null) {
            this.bPI.destory();
        }
        if (this.bPz != null) {
            this.bPz.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaQ() {
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        if (adAdSense != null && adAdSense.xB()) {
            com.baidu.tieba.frs.entelechy.a.af abW = this.bPi.abW();
            List<com.baidu.adp.widget.ListView.v> datas = abW != null ? abW.getDatas() : null;
            if (datas != null) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (com.baidu.adp.widget.ListView.v vVar : datas) {
                    if (vVar instanceof com.baidu.tbadk.core.data.bi) {
                        com.baidu.tbadk.core.data.bi biVar = (com.baidu.tbadk.core.data.bi) vVar;
                        i++;
                        if (biVar.Ue == 1 && !TextUtils.isEmpty(biVar.getTid())) {
                            biVar.Ue = 2;
                            a.b bVar = new a.b();
                            bVar.aPH = biVar.getTid();
                            bVar.bbO = i;
                            arrayList.add(bVar);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    com.baidu.tieba.recapp.g.sendFRS(this.bPk.aMr().getFirst_class(), this.bPk.aMr().getSecond_class(), getForumId(), arrayList, adAdSense.xC());
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.bOZ);
        bundle.putString("from", this.adg);
        this.bPt.onSaveInstanceState(bundle);
        this.bQb = getVoiceManager();
        if (this.bQb != null) {
            this.bQb.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.bi qZ;
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    hQ(0);
                    return;
                case 11002:
                    this.bPu.lN();
                    return;
                case 11011:
                    f(this.bPj);
                    return;
                case 11012:
                    g(this.aLV);
                    return;
                case 11014:
                    this.bPu.afP();
                    return;
                case 11016:
                    this.bPi.abM();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    this.bPu.abh();
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
                    this.bPi.abW().notifyDataSetChanged();
                    if (this.bPu != null) {
                        this.bPu.acR();
                    }
                    int intExtra = intent.getIntExtra("type", -1);
                    if (intExtra == 4) {
                        ci(6);
                        return;
                    }
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (qZ = this.bPk.qZ(stringExtra)) != null) {
                        if (intExtra == 2) {
                            qZ.bW(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            qZ.su();
                            return;
                        } else if (intExtra == 0) {
                            this.bPk.w(qZ);
                            this.bPi.abO();
                            if (com.baidu.tieba.tbadkCore.d.bhH() != null) {
                                com.baidu.tieba.tbadkCore.d.bhH().R(this.bOZ, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    aaX();
                    return;
                case 23003:
                    if (intent != null && this.bPk != null) {
                        cl.a(this, this.bPk, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    cl.a(this, this.bPk, intent);
                    return;
                case 23013:
                    aaZ();
                    return;
                case 23019:
                    aba();
                    return;
                case 24002:
                    if (intent != null) {
                        int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                        int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                        int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                        int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                        if (intExtra2 == com.baidu.adp.lib.h.b.g(this.forumId, 0)) {
                            this.bPu.t(intExtra3, intExtra4, intExtra5);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostWriteCallBackData postWriteCallBackData) {
        if (this.bPt != null) {
            if (this.bPt.acs() == 2 || this.bPt.acs() == 3) {
                int aeY = this.bPt.aeY();
                if (cz.acy().hZ(1) == null) {
                    aeY = 0;
                }
                if (aeY == 0 && postWriteCallBackData != null) {
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
        if (this.bPi != null) {
            this.bPi.abK();
            try {
                if ("OPPO".equals(Build.MANUFACTURER) && this.bPi.abD() != null) {
                    Method declaredMethod = AbsListView.class.getDeclaredMethod("trackMotionScroll", Integer.TYPE, Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.bPi.abN(), 500, 10);
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
        this.bPy.a(this.bPK);
        this.bOR = true;
        this.bPs = true;
        if (this.bPz != null) {
            this.bPz.ef(false);
        }
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.bPi.kv();
        } else if (bOW) {
            bOW = false;
            this.bPi.kv();
        } else {
            this.bQb = getVoiceManager();
            this.bQb.onResume(getPageContext());
            this.bPi.dM(false);
            registerListener(this.bPT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.bPi.dL(z);
        this.bPw.dX(z);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.bOZ = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.adg = intent.getStringExtra("from");
            }
            this.bPb = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.bPb) {
                dE(intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false));
            }
        }
    }

    private void dE(boolean z) {
        this.bPi.kv();
        this.bPw.showContent(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.adg)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            } else {
                com.baidu.tbadk.core.d.b.f(getPageContext().getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.adg)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        } else {
            com.baidu.tbadk.core.d.b.f(getPageContext().getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.adg)) {
            finish();
        }
    }

    private void initUI() {
        if (this.mFlag == 0) {
            this.bPi.setTitle(this.bOZ);
        } else {
            this.bPi.setTitle("");
            this.mFlag = 1;
        }
        this.bPu.c(this.bPi.abN());
        this.bPi.a(this.bQd);
        this.bPi.a(this.bQe);
        this.bPi.setOnScrollListener(this.bPY);
        this.bPi.a(this.bPW);
        this.bPi.g(this.aRn);
        this.bPi.abW().a(this.bPZ);
        if (!this.mIsLogin) {
            this.bPi.dL(false);
            this.bPw.dX(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bPi.onChangeSkinType(i);
        this.bPv.a(getPageContext(), i);
        this.bPu.a(getPageContext(), i);
        this.bPy.onChangeSkinType(i);
        changeSwipeSkinType(i);
        if (this.bPz != null) {
            this.bPz.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.adp.widget.f.b
    public void la() {
        setSwipeBackEnabled(true);
        this.bPw.dX(true);
    }

    @Override // com.baidu.adp.widget.f.b
    public void lb() {
        setSwipeBackEnabled(false);
        this.bPw.dX(false);
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
                FrsActivity.this.showToast(r.j.shortcut_has_add);
            } else {
                FrsActivity.this.jP(this.name);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jP(String str) {
        Intent K;
        if (str != null && (K = com.baidu.tieba.frs.utils.a.K(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(r.j.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", K);
            BarImageView afO = this.bPu.afO();
            if (afO != null && afO.getBdImage() != null && afO.getBdImage().jV() != null) {
                Bitmap jV = afO.getBdImage().jV();
                Float valueOf = Float.valueOf(getResources().getDisplayMetrics().density);
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.d.fT().a(com.baidu.adp.lib.util.d.fT().resizeBitmap(jV, valueOf.intValue() * 48), valueOf.intValue() * 6));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), r.f.icon));
            }
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    private void hQ(int i) {
        if (!this.mIsLogin) {
            if (this.bPk != null && this.bPk.qq() != null) {
                this.bPk.qq().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.bPk != null) {
            if (i == 0) {
                if (!this.bOX) {
                    hR(0);
                    return;
                }
                TiebaStatic.log("c10152");
                hR(4);
                return;
            }
            this.bPi.abM();
        }
    }

    private void hR(int i) {
        int i2 = i == 4 ? 7 : i;
        int i3 = 0;
        if (this.bPk.getUserData() != null) {
            i3 = this.bPk.getUserData().getIsMem();
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), i2, this.bPk.aMr().getId(), this.bOZ, null, null, 0, this.bPk.qq(), 13003, false, false, null, false, false, null, null, this.bPk.aMr().getPrefixData(), i3);
        if (cz.acy().hZ(1) != null) {
            writeActivityConfig.setCategroyId(this.bPt.aeY());
        }
        boolean GD = com.baidu.tbadk.plugins.k.GD();
        if (!this.bPk.getUserData().canPostHi()) {
            GD = false;
        }
        writeActivityConfig.getIntent().putExtra(WriteActivityConfig.TOGETHERHI_SHOW, GD);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    public void aaR() {
        int i = 0;
        if (this.bPk.getUserData() != null) {
            i = this.bPk.getUserData().getIsMem();
        }
        EcommProductListActivityConfig ecommProductListActivityConfig = new EcommProductListActivityConfig(getPageContext().getPageActivity(), 7, this.bPk.aMr().getId(), this.bOZ, null, null, 0, this.bPk.qq(), 13003, false, false, null, false, false, null, null, this.bPk.aMr().getPrefixData(), i, "");
        ecommProductListActivityConfig.addEcommAddress(this.bPf);
        if (cz.acy().hZ(1) != null) {
            ecommProductListActivityConfig.setCategroyId(this.bPt.aeY());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, ecommProductListActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tbadk.core.data.bi biVar) {
        boolean z = biVar == null || biVar.sC();
        this.bPi.a(new aj(this, biVar));
        this.bPi.c(biVar, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.core.data.bi biVar) {
        boolean z = biVar == null || biVar.sC();
        if (this.mThreadId != null) {
            if (!z) {
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(biVar, this.bOZ, null, 18003, true, true, this.bPg);
                createFromThreadCfg.setVideo_source("frs");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg2 = new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(biVar, this.bOZ, null, 18003, false, false, this.bPg);
            createFromThreadCfg2.setVideo_source("frs");
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.tbadk.core.data.bi biVar) {
        if (this.mThreadId != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(biVar, this.bOZ, null, 18003, false, false, this.bPg);
            createFromThreadCfg.setVideo_source("frs");
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void refresh() {
        ci(3);
    }

    public void ci(int i) {
        this.bPO = false;
        this.bOT = false;
        this.bPh = false;
        abb();
        abi().B(i, true);
    }

    private void aaS() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.h.k.eH().f(new ak(this));
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaT() {
        abb();
        try {
            if (this.bPk != null) {
                this.bPi.JK();
                this.bPi.abC();
                if (this.bPw != null && !this.bPw.isMenuShowing()) {
                    this.bPi.dG(true);
                }
                if (com.baidu.tieba.frs.i.p.j(this.bPk) && !com.baidu.tieba.frs.i.p.i(this.bPk)) {
                    this.bPi.ach();
                }
                this.bOZ = this.bPk.aMr().getName();
                this.forumId = this.bPk.aMr().getId();
                this.bPi.setTitle(this.bOZ);
                TbadkCoreApplication.m9getInst().setDefaultBubble(this.bPk.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(this.bPk.getUserData().getBimg_end_time());
                aaS();
                ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bPk.getThreadList();
                if (threadList != null) {
                    this.bPi.a(threadList, this.mPn, this.bPk, this.bPk.getPage().qB());
                    abc();
                    this.bPu.iE(this.mPn);
                    this.bPu.f(this.bPk);
                    this.bPy.a(this.bPi.abN(), this.bPk, this.bPt.afi());
                    this.bPi.abO();
                    aaU();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void aaU() {
        if (this.bPk != null) {
            if (this.bPk.aMA() == 1) {
                this.bPi.abW().setFromCDN(true);
            } else {
                this.bPi.abW().setFromCDN(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bOR = false;
        this.bPs = false;
        this.bPi.onPause();
        this.bQb = getVoiceManager();
        this.bQb.onPause(getPageContext());
        this.bPi.dM(true);
        if (this.bPI != null) {
            this.bPI.afr();
        }
        if (this.bPz != null) {
            this.bPz.ef(true);
        }
        MessageManager.getInstance().unRegisterListener(this.bPT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Object d;
        super.onStop();
        com.baidu.tieba.card.cb.Oj().cs(false);
        if (this.bPk != null && this.bPk.aMr() != null) {
            com.baidu.tbadk.distribute.a.Cp().b(getPageContext().getPageActivity(), "frs", this.bPk.aMr().getId(), 0L);
        }
        this.bQb = getVoiceManager();
        if (this.bQb != null) {
            this.bQb.onStop(getPageContext());
        }
        BdListView listView = getListView();
        if (listView != null && (d = com.baidu.adp.lib.a.a.a.d(listView, "mRecycler")) != null) {
            com.baidu.adp.lib.a.a.a.a("clear", d, d.getClass());
        }
        this.bPu.onActivityStop();
        com.baidu.tbadk.util.s.He();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.bPa) {
            if (i == 4) {
                if (this.bPw.isMenuShowing()) {
                    this.bPw.dY(true);
                    if (this.bPv.afS().acF()) {
                        this.bPv.afS().dS(false);
                        refresh();
                        return true;
                    }
                    return true;
                } else if (this.bPi.abJ()) {
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

    public boolean aaV() {
        if (this.bPx == null) {
            return false;
        }
        return this.bPx.isShowing();
    }

    public void aaW() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
        this.bPr = new a(this.bOZ);
        this.bPr.setSelfExecute(true);
        this.bPr.execute(new String[0]);
    }

    public void aaX() {
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.bPk.aMr().getId(), true, true, true);
    }

    @Override // com.baidu.tieba.recapp.b
    public BaseActivity<?> getContext() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.b
    public void a(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Cp().a(getPageContext().getPageActivity(), bVar, str, "frs", this.bPk.aMr().getId(), 0L);
    }

    @Override // com.baidu.tieba.recapp.b
    public void b(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Cp().a(bVar, this.forumId, 0L, "FRS", str, this.mPn);
    }

    @Override // com.baidu.tieba.recapp.b
    public void aaY() {
        abi().aaY();
    }

    @Override // com.baidu.tieba.recapp.b
    public String getFid() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.recapp.b
    public int getPageNum() {
        return this.mPn;
    }

    public int getPn() {
        return this.mPn;
    }

    public void aaZ() {
        if (checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c10177").ab("fid", this.forumId));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(getPageContext().getPageActivity(), String.valueOf(getForumId()), false, 0)));
        }
    }

    public void aba() {
        if (checkUpIsLogin() && this.bOY != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(getPageContext().getPageActivity()).createConfig(String.valueOf(getForumId()), this.bOY.getTid(), 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hS(int i) {
        ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bPk.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.bi) {
                    com.baidu.tbadk.core.data.bi biVar = (com.baidu.tbadk.core.data.bi) next;
                    if (biVar == this.bOQ) {
                        c(biVar, i);
                        this.bOQ = null;
                        break;
                    } else if (biVar.getId() != null && biVar.getId().equals(this.bOS)) {
                        c(biVar, i);
                        this.bOS = null;
                        break;
                    }
                }
            }
            this.bPi.abW().a(threadList, this.bPk);
            this.bPi.abW().notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tbadk.core.data.bi biVar, int i) {
        if (i == 1) {
            PraiseData rF = biVar.rF();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (rF == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    biVar.a(praiseData);
                    return;
                }
                biVar.rF().getUser().add(0, metaData);
                biVar.rF().setNum(biVar.rF().getNum() + 1);
                biVar.rF().setIsLike(i);
            }
        } else if (biVar.rF() != null) {
            biVar.rF().setIsLike(i);
            biVar.rF().setNum(biVar.rF().getNum() - 1);
            ArrayList<MetaData> user = biVar.rF().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        biVar.rF().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.getData() != null && updateAttentionMessage.getData().akE && !StringUtils.isNull(updateAttentionMessage.getData().showMsg, true) && updateAttentionMessage.getData().akC && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            showToast(updateAttentionMessage.getData().showMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        Message<?> message;
        if (updateAttentionMessage != null && updateAttentionMessage.isAttention() && updateAttentionMessage.isGod() && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(getUniqueId())) {
            if (this.bPH == null) {
                this.bPH = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bPH.ap(updateAttentionMessage.getData().toUid, getForumId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UpdateAttentionMessage updateAttentionMessage) {
        ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bPk.getThreadList();
        if (threadList != null && updateAttentionMessage != null && updateAttentionMessage.getData() != null) {
            MetaData metaData = new MetaData();
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            MetaData metaData2 = metaData;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.bi) {
                    com.baidu.tbadk.core.data.bi biVar = (com.baidu.tbadk.core.data.bi) next;
                    if (biVar.getAuthor() != null && biVar.getAuthor().getUserId() != null && biVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid) && !biVar.getAuthor().equals(metaData2)) {
                        a(biVar, updateAttentionMessage);
                        metaData2 = biVar.getAuthor();
                    }
                }
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.bi biVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        int i2;
        if (biVar != null && biVar.getAuthor() != null && biVar.getAuthor().getUserId() != null && biVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = biVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
                i2 = 1;
            } else {
                i = fansNum - 1;
                i2 = 0;
            }
            biVar.getAuthor().setFansNum(i);
            if (biVar.getAuthor().getGodUserData() != null) {
                biVar.getAuthor().getGodUserData().setFollowed(i2);
                biVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bQb == null) {
            this.bQb = VoiceManager.instance();
        }
        return this.bQb;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: OU */
    public BdListView getListView() {
        if (this.bPi == null) {
            return null;
        }
        return this.bPi.abN();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void abb() {
        this.bQb = getVoiceManager();
        this.bQb.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int wN() {
        if (this.bPi == null) {
            return 0;
        }
        return this.bPi.abS();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> wO() {
        if (this.ahk == null) {
            this.ahk = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.ahk;
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
            if (this.bPl != null) {
                this.bPl.bj(msgReplyme);
                this.bPl.bi(msgAtme);
                this.bPl.bm(msgOfficialMerge);
                this.bPl.bk(msgChat);
                this.bPl.bl(msgStrangerChat);
                this.bPi.a(this.bPl);
                this.bPv.a(this.bPl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.bPk != null && this.bPi != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                com.baidu.adp.lib.h.h.eG().postDelayed(new al(this), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }

    private void abc() {
        HashMap<Integer, com.baidu.tbadk.core.data.bi> adl;
        if (this.bPi != null && this.bPi.abW() != null && (adl = this.bPi.abW().adl()) != null) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.bi> entry : adl.entrySet()) {
                com.baidu.tbadk.core.data.bi value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.b)) {
                    arrayList.add((com.baidu.tbadk.core.data.b) value);
                }
            }
            com.baidu.tieba.recapp.b.a.bbX().o(arrayList);
        }
    }

    public void abd() {
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
            PhotoLiveActivityConfig oX;
            PbActivityConfig createFromThreadCfg;
            if (bdUniqueId != null && vVar != null && (vVar instanceof com.baidu.tbadk.core.data.bi)) {
                com.baidu.tbadk.core.data.bi biVar = (com.baidu.tbadk.core.data.bi) vVar;
                if (biVar.sx() == null || biVar.sx().getGroup_id() == 0 || FrsActivity.this.checkUpIsLogin()) {
                    if ((biVar.sq() != 1 && biVar.sq() != 2) || FrsActivity.this.checkUpIsLogin()) {
                        if (biVar.rZ() != null) {
                            if (FrsActivity.this.checkUpIsLogin()) {
                                String postUrl = biVar.rZ().getPostUrl();
                                if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.gD()) {
                                    com.baidu.tbadk.browser.f.v(FrsActivity.this.getActivity(), postUrl);
                                }
                            }
                        } else if (biVar.sI() != null) {
                            com.baidu.tbadk.core.data.m sI = biVar.sI();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsActivity.this.getPageContext().getPageActivity(), sI.getCartoonId(), sI.getChapterId(), 2)));
                        } else if (biVar.getThreadType() == 47 && biVar.rJ() == 1 && !com.baidu.tbadk.core.util.az.isEmpty(biVar.rT())) {
                            com.baidu.tbadk.browser.f.u(FrsActivity.this.getPageContext().getPageActivity(), biVar.rT());
                        } else {
                            com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                            if (readThreadHistory != null && !readThreadHistory.ru(biVar.getId())) {
                                readThreadHistory.rt(biVar.getId());
                            }
                            boolean z = false;
                            String rT = biVar.rT();
                            if (rT != null && !rT.equals("")) {
                                z = true;
                                new Thread(new at(this, rT)).start();
                            }
                            String tid = biVar.getTid();
                            if (tid == null) {
                                tid = "";
                            }
                            if (biVar.rJ() == 2 && !tid.startsWith("pb:")) {
                                com.baidu.tbadk.core.util.bh vL = com.baidu.tbadk.core.util.bh.vL();
                                TbPageContext<?> pageContext = FrsActivity.this.getPageContext();
                                String[] strArr = new String[3];
                                strArr[0] = tid;
                                strArr[1] = "";
                                vL.c(pageContext, strArr);
                                return;
                            }
                            boolean z2 = false;
                            if (biVar instanceof com.baidu.tbadk.core.data.y) {
                                z2 = true;
                                TiebaStatic.log("c10769");
                            }
                            if (biVar.getThreadType() == 33 || (biVar instanceof com.baidu.tbadk.core.data.at)) {
                                if (!z2) {
                                    String str = biVar.getThreadType() == 33 ? "c10245" : "c10180";
                                    if (FrsActivity.this.bPt.afa() == 5) {
                                        str = "c10387";
                                    }
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ax(str).ab("fid", FrsActivity.this.forumId));
                                }
                                if (biVar.sh() > 0 && com.baidu.tieba.tbadkCore.util.t.bkQ()) {
                                    oX = new PhotoLiveActivityConfig.a(FrsActivity.this.getPageContext().getPageActivity(), biVar.getTid()).ck("from_frs").bF(18003).ci(String.valueOf(biVar.sh())).oX();
                                } else {
                                    oX = new PhotoLiveActivityConfig.a(FrsActivity.this.getPageContext().getPageActivity(), biVar.getTid()).ck("from_frs").bF(18003).oX();
                                }
                                FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, oX));
                                if (FrsActivity.this.bPk != null && FrsActivity.this.bPk.aMr() != null) {
                                    com.baidu.tieba.frs.g.a aVar = new com.baidu.tieba.frs.g.a();
                                    aVar.cdb = FrsActivity.this.bPk.fsD == 1;
                                    aVar.cdd = FrsActivity.this.bPk.aMr().getId();
                                    aVar.cdc = FrsActivity.this.abi().acs();
                                    com.baidu.tieba.frs.g.b.afl().a(aVar, biVar, 1);
                                    return;
                                }
                                return;
                            }
                            if (tid.startsWith("pb:")) {
                                biVar.setId(tid.substring(3));
                            }
                            if (!z2 && FrsActivity.this.bPt.afa() == 2) {
                                com.baidu.tbadk.core.util.ax axVar = new com.baidu.tbadk.core.util.ax("c10077");
                                axVar.s("obj_source", FrsActivity.this.bPt.afa());
                                axVar.ab("tid", biVar.getId());
                                axVar.ab("fid", FrsActivity.this.getForumId());
                                TiebaStatic.log(axVar);
                            }
                            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.bi.Uy.getId() && biVar.so() == 2 && biVar.rx() != null) {
                                String pt = biVar.rx().pt();
                                if (StringUtils.isNull(pt)) {
                                    pt = biVar.rx().getTaskId();
                                }
                                com.baidu.tieba.tbadkCore.d.a.b("frs", "CLICK", biVar.rx().getForumId(), biVar.rx().getForumName(), biVar.rx().getThreadId(), "tieba.baidu.com/p/" + biVar.rx().getThreadId(), pt);
                                if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
                                    FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(FrsActivity.this.getPageContext().getPageActivity()).createNormalCfg(biVar.rx().getThreadId(), biVar.rx().getTaskId(), biVar.rx().getForumId(), biVar.rx().getForumName(), biVar.rJ(), biVar.rK())));
                                    return;
                                }
                            }
                            com.baidu.tbadk.core.util.ax ab = new com.baidu.tbadk.core.util.ax("c10806").s("obj_locate", 3).ab("tid", biVar.getId());
                            if (biVar.getAuthor() != null && biVar.getAuthor().getGodInfo() != null) {
                                TiebaStatic.log(ab);
                            }
                            if (FrsActivity.this.bPk != null && FrsActivity.this.bPk.aMr() != null) {
                                com.baidu.tieba.frs.g.a aVar2 = new com.baidu.tieba.frs.g.a();
                                aVar2.cdb = FrsActivity.this.bPk.fsD == 1;
                                aVar2.cdd = FrsActivity.this.bPk.aMr().getId();
                                aVar2.cdc = FrsActivity.this.abi().acs();
                                com.baidu.tieba.frs.g.b.afl().a(aVar2, biVar, 1);
                            }
                            if (biVar.sh() > 0 && com.baidu.tieba.tbadkCore.util.t.bkQ()) {
                                createFromThreadCfg = new PbActivityConfig(FrsActivity.this.getPageContext().getPageActivity()).createHistoryCfg(biVar.getTid(), String.valueOf(biVar.sh()), false, true, null);
                            } else {
                                createFromThreadCfg = new PbActivityConfig(FrsActivity.this.getPageContext().getPageActivity()).createFromThreadCfg(biVar, FrsActivity.this.bOZ, null, 18003, true, false, z);
                            }
                            if (i == 4) {
                                createFromThreadCfg.setVideo_source("floor5");
                            } else {
                                createFromThreadCfg.setVideo_source("frs");
                            }
                            FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                            if (biVar.UH != null) {
                                com.baidu.tbadk.core.util.ax axVar2 = new com.baidu.tbadk.core.util.ax("c11430");
                                axVar2.ab("tid", biVar.getTid());
                                axVar2.ab("obj_id", new StringBuilder(String.valueOf(biVar.UH.productId)).toString());
                                TiebaStatic.log(axVar2);
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
            hideNetRefreshView(this.bPi.getRootView());
            showLoadingView(this.bPi.getRootView(), true);
            this.bPi.dK(false);
            this.bPi.kv();
        }
    }

    public com.baidu.tieba.tbadkCore.p abe() {
        return this.bPk;
    }

    public boolean abf() {
        return this.bPi.abf();
    }

    public void abg() {
        FrsActivityStatic.bQu = false;
        FrsActivityStatic.bQv = false;
        aaP();
    }

    public void abh() {
        this.bPu.abh();
    }

    public com.baidu.tieba.frs.e.a abi() {
        return this.bPt;
    }

    public bm abj() {
        return this.bPi;
    }

    public void jQ(String str) {
        this.bOZ = str;
    }

    public void setFrom(String str) {
        this.adg = str;
    }

    public String getFrom() {
        return this.adg;
    }

    public void setFlag(int i) {
        this.mFlag = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    public com.baidu.tieba.frs.i.y abk() {
        return this.bPw;
    }

    public com.baidu.tieba.frs.ecomm.a abl() {
        if (this.bPG == null) {
            this.bPG = new com.baidu.tieba.frs.ecomm.a(this);
            this.bPG.a(new am(this));
        }
        return this.bPG;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        if (!com.baidu.adp.lib.util.k.gD()) {
            this.bPi.acc();
        } else if (this.bPt.afa() == 1) {
            JG();
            abm();
        } else if (this.bPt.hasMore()) {
            abm();
        }
    }

    public void jR(String str) {
        JG();
        showToast(str);
    }

    public void L(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        JG();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bPC.a(false, arrayList, this.bPe);
            if (a2 != null) {
                this.bPk.aA(a2);
                this.bPi.a(a2, this.mPn, this.bPk, 0);
            }
            if (abi() != null) {
                com.baidu.tieba.frs.g.b.a(this.bPk, abi().acs(), 2);
            }
        }
    }

    private void JG() {
        if (this.bPD == 0 && !this.bPC.az(this.bPk.bhS())) {
            if (this.bPk.getThreadList() == null || this.bPk.getThreadList().size() == 0) {
                this.bPi.acc();
                return;
            } else {
                this.bPi.acb();
                return;
            }
        }
        this.bPi.aca();
    }

    public void abm() {
        if (this.bPt.afa() == 1) {
            if (!this.bPC.azO && !this.bPt.wG()) {
                if (this.bPC.az(this.bPk.bhS())) {
                    this.bPi.a(this.bPC.aef(), this.mPn, this.bPk, 0);
                    this.bPC.setSortType(this.bPt.afh());
                    this.bPC.a(com.baidu.adp.lib.h.b.c(this.forumId, 0L), this.bPk.bhS(), this.bOZ, this.mPn);
                } else if (this.bPD != 0) {
                    this.bPi.a(this.bPC.aef(), this.mPn, this.bPk, 0);
                    this.mPn++;
                    this.bPt.ip(this.mPn);
                    this.bPC.bZv = false;
                    this.bPC.bZw = 0;
                }
            }
        } else if (!this.bPt.afd()) {
            this.bPt.OR();
        }
    }

    public boolean abn() {
        return this.bPv.afS().acF();
    }

    public void dF(boolean z) {
        this.bPv.afS().dS(z);
    }

    public void abo() {
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
                showToast(r.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ag.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(r.j.sdcard_permission_denied_advert_for_camera);
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

    public com.baidu.adp.widget.ListView.w abp() {
        return this.bQd;
    }

    public com.baidu.adp.widget.ListView.x abq() {
        return this.bQe;
    }

    public com.baidu.tieba.frs.entelechy.b.b abr() {
        return this.bPF;
    }

    public bm abs() {
        return this.bPi;
    }

    public void abt() {
        if (this.bPI != null) {
            this.bPI.afr();
        }
    }

    public void jS(String str) {
        if (this.bph == null) {
            this.bph = new com.baidu.tbadk.core.view.a(getPageContext());
        }
        this.bph.dW(str);
        this.bph.aF(true);
    }
}
