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
import android.widget.TextView;
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
import com.baidu.tbadk.core.view.AppDownloadView;
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
import com.baidu.tieba.d.c;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.e;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.u;
import com.baidu.tieba.view.BdExpandListView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class FrsActivity extends BaseActivity<FrsActivity> implements a.InterfaceC0000a, BdListView.e, f.b, UserIconBox.b, VoiceManager.c, dn, FrsCommonImageLayout.c {
    private com.baidu.adp.lib.f.b<TbImageView> adT;
    private boolean bBf;
    private String bBg;
    VoiceManager bBm;
    private String bCA;
    private cx bCG;
    private com.baidu.adp.lib.f.b<TbImageView> bCI;
    private a bCO;
    private com.baidu.tieba.frs.f.a bCQ;
    private com.baidu.tieba.frs.i.p bCR;
    private com.baidu.tieba.frs.i.aa bCS;
    private com.baidu.tieba.frs.i.y bCT;
    private com.baidu.tieba.frs.view.p bCU;
    private com.baidu.tieba.frs.entelechy.b.d bCV;
    private com.baidu.tieba.frs.headvideo.c bCW;
    private com.baidu.tieba.d.c bCX;
    private Cdo bCY;
    private com.baidu.tieba.frs.loadmore.a bCZ;
    private com.baidu.tbadk.core.data.az bCn;
    private com.baidu.tieba.frs.entelechy.b.a bCp;
    private boolean bCs;
    private com.baidu.tbadk.core.data.az bCt;
    private com.baidu.tieba.tbadkCore.data.f bCz;
    private com.baidu.tieba.frs.entelechy.b.b bDb;
    private com.baidu.tieba.frs.ecomm.a bDc;
    private com.baidu.tbadk.e.a bDd;
    private com.baidu.tieba.frs.i.a bDe;
    private com.baidu.tbadk.core.view.b bcn;
    public static String bCk = "speed_icon_show";
    private static final int bCl = (com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds100)) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds90);
    private static final int bCm = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds300);
    public static boolean bCr = false;
    public static volatile long bCJ = 0;
    public static volatile long bCK = 0;
    public static volatile int bCL = 0;
    private static boolean isNeedRefreshOnResume = false;
    private boolean bCo = false;
    public boolean bCq = false;
    public String bCu = null;
    public String Zw = null;
    public int mFlag = 0;
    private int mPn = 1;
    private boolean bCv = false;
    private boolean bCw = false;
    private String mThreadId = null;
    private String forumId = null;
    private int bCx = 0;
    private boolean bCy = false;
    private boolean bCB = false;
    private boolean bCC = false;
    private bq bCD = null;
    private final com.baidu.tbadk.core.data.az bCE = null;
    private com.baidu.tieba.tbadkCore.p bCF = new com.baidu.tieba.tbadkCore.p();
    private com.baidu.tbadk.core.data.az bCH = null;
    public long btl = -1;
    public long ayu = 0;
    public long aym = 0;
    public long createTime = 0;
    public long Od = -1;
    private boolean bCM = false;
    public com.baidu.tbadk.performanceLog.e bCN = null;
    private boolean bCP = true;
    private int bDa = -1;
    private dm bDf = new d(this);
    private dl bDg = new o(this);
    private CustomMessageListener adR = new aa(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener bzD = new ak(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
    private CustomMessageListener bDh = new ao(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private CustomMessageListener aOy = new ap(this, CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND);
    public final CustomMessageListener bDi = new aq(this, CmdConfigCustom.MSG_NEW);
    private CustomMessageListener bDj = new ar(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    private boolean bDk = false;
    public final com.baidu.tieba.tbadkCore.s bDl = new as(this);
    private final CustomMessageListener LV = new e(this, CmdConfigCustom.CMD_REFRESH);
    private final CustomMessageListener mMemListener = new f(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private CustomMessageListener bDm = new g(this, CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS);
    public View.OnTouchListener aGb = new h(this);
    private c.InterfaceC0054c aYC = new i(this);
    private CustomMessageListener bDn = new j(this, CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE);
    private final com.baidu.adp.framework.listener.a bDo = new k(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    private final com.baidu.adp.framework.listener.a bDp = new l(this, CmdConfigHttp.CMD_SET_COMMON_FORUM_STATE, 309365);
    private t.b acD = new m(this);
    private t.d acG = new n(this);
    private t.a acF = new p(this);
    private final BdExpandListView.a bDq = new q(this);
    public final View.OnClickListener bDr = new r(this);
    private final AbsListView.OnScrollListener bBn = new s(this);
    private final ba bDs = new u(this);
    private final com.baidu.tieba.tbadkCore.aj bBp = new com.baidu.tieba.tbadkCore.aj(getPageContext(), new v(this));
    private CustomMessageListener bbo = new w(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private final View.OnClickListener bDt = new x(this);
    private final View.OnClickListener bDu = new y(this);
    private final NoNetworkView.a bAH = new z(this);
    private final CustomMessageListener bDv = new ab(this, 0);
    private com.baidu.adp.widget.ListView.w bDw = new b();
    private com.baidu.adp.widget.ListView.x bDx = new ac(this);
    public final com.baidu.adp.base.g bDy = new ad(this);
    public final com.baidu.adp.base.g bDz = new ae(this);
    private dm bDA = new af(this);

    @Override // com.baidu.tieba.frs.dn
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.dn
    public String getForumName() {
        return this.bCu;
    }

    public com.baidu.tieba.frs.headvideo.c Vk() {
        return this.bCW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.z zVar) {
        if (zVar != null) {
            boolean z = zVar.isLike() == 1;
            if (this.bCD != null && this.bCF != null && this.bCF.aDN() != null && zVar.getFid() != null) {
                if (zVar.getFid().equals(this.bCF.aDN().getId())) {
                    this.bCF.aDN().setLike(zVar.isLike());
                    if (!StringUtils.isNULL(zVar.getLevelName())) {
                        this.bCF.aDN().setLevelName(zVar.getLevelName());
                    }
                    if (zVar.getUserLevel() >= 0) {
                        this.bCF.aDN().setUser_level(zVar.getUserLevel());
                    }
                    if (z) {
                        this.bCR.a(this.bCF, false);
                        this.bCS.dL(true);
                        TbadkCoreApplication.m9getInst().addLikeForum(this.bCu);
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.bah().N(this.bCu, false);
                    this.bCF.aDN().setLike(0);
                    this.bCR.aah();
                    this.bCS.dL(false);
                    TbadkCoreApplication.m9getInst().delLikeForum(this.bCu);
                    return;
                }
                if (zVar.isLike() == 1) {
                    this.bCF.pp(zVar.getFid());
                    this.bCR.f(this.bCF);
                    this.bCV.a(this.bCD.getListView(), this.bCF, this.bCQ.ZK());
                }
                if (this.bCF.aDN().getBannerListData() != null) {
                    this.bCF.aDN().getBannerListData().setFeedForumLiked(zVar.getFid(), zVar.isLike());
                }
                this.bCD.Wl();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m9getInst().isGpuOpen();
    }

    public void a(ErrorData errorData) {
        this.bCD.dm(false);
        this.bCD.Wl();
        hideLoadingView(this.bCD.getRootView());
        this.bCD.dn(false);
        this.bCD.Wr();
        if (!this.bCC) {
            e.a ZB = VG().ZB();
            if (!this.bCo) {
                if (ZB != null) {
                    if (this.bCQ.ZD() != 0) {
                        this.bCQ.ZI();
                        this.bCD.Wl();
                    } else {
                        if (ZB.eUM) {
                            if (340001 == ZB.errorCode) {
                                showNetRefreshViewNoClick(this.bCD.getRootView(), getPageContext().getResources().getString(u.j.net_error_text, ZB.errorMsg, Integer.valueOf(ZB.errorCode)), true);
                            } else {
                                showNetRefreshView(this.bCD.getRootView(), getPageContext().getResources().getString(u.j.net_error_text, ZB.errorMsg, Integer.valueOf(ZB.errorCode)), true);
                            }
                        } else if (340001 == ZB.errorCode) {
                            showNetRefreshViewNoClick(this.bCD.getRootView(), ZB.errorMsg, true);
                        } else {
                            showNetRefreshView(this.bCD.getRootView(), ZB.errorMsg, true);
                        }
                        setNetRefreshViewEmotionDefMarginTop();
                        if (this.bCD.Wh() != null) {
                            this.bCD.Wh().setVisibility(8);
                        }
                        if (this.bCT != null) {
                            this.bCT.dC(false);
                        }
                    }
                    this.bCD.j(false, false);
                }
            } else if (ZB != null && ZB.eUM) {
                this.bCD.j(true, false);
                showToast(getPageContext().getResources().getString(u.j.net_error_text, ZB.errorMsg, Integer.valueOf(ZB.errorCode)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Vl() {
        if (this.bCV != null && this.bCD != null) {
            this.bCV.u(this.bCD.getListView());
        }
        if (this.bCR != null && VG() != null) {
            this.bCR.a(VG().KQ(), this.bCF);
        }
        boolean z = false;
        if (this.bCF != null) {
            z = this.bCF.bbk();
        }
        dg(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hj(int i) {
        ds dsVar = null;
        Vl();
        UR();
        try {
            if (this.bCF != null) {
                this.bCD.a(null, 1, this.bCF, 0);
                this.bCR.hW(1);
                this.bCD.Wo();
                this.bCV.a(this.bCD.getListView(), this.bCF, this.bCQ.ZK());
                com.baidu.tieba.frs.tab.i a2 = a(this.bCV.Yb(), this.bCF.baH());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    dsVar = new ds();
                    dsVar.bHh = a2.url;
                    dsVar.stType = a2.name;
                }
                this.bCQ.a(this.bCF.baH(), 0, dsVar);
                this.bCV.dB(false);
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
            if (iVar != null && iVar.bug == i) {
                return iVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.n nVar) {
        int baH;
        if (!this.bDk && nVar != null) {
            try {
                if (this.bCF != null) {
                    this.bCF.d(nVar);
                    Vu();
                    this.bDa = this.bCF.getPage().pE();
                    this.bCV.u(this.bCD.getListView());
                    boolean bbk = this.bCF.bbk();
                    this.bCR.f(com.baidu.tieba.frs.i.p.h(this.bCF), this.bCF.getUserData().getIsMem(), this.bCF.aDN().isLike());
                    dg(bbk);
                    if (this.bDb != null) {
                        this.bDb.a(this.bCR, this.bCF);
                    }
                    this.bCD.Mc();
                    this.bCu = this.bCF.aDN().getName();
                    this.forumId = this.bCF.aDN().getId();
                    this.bCD.setTitle(this.bCu);
                    Vs();
                    this.bCF.baX();
                    if (this.bCD.Ww().k(com.baidu.tieba.tbadkCore.am.eWB)) {
                        this.bCF.baY();
                    }
                    this.bCF.bbe();
                    if (!VG().ZC()) {
                        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            this.bCF.bbd();
                            this.bCF.bbc();
                            this.bCF.bba();
                        }
                        this.bCF.bbb();
                    }
                    if (!(this.bCD.Ww().k(com.baidu.tieba.card.a.q.aVI) ? this.bCF.bbh() : false)) {
                        this.bCF.bbg();
                    }
                    if (TbadkCoreApplication.m9getInst().isRecAppExist()) {
                        this.bCF.aS(getPageContext().getPageActivity());
                    }
                    this.bCF.baW();
                    com.baidu.tbadk.core.data.bc top_notice_data = this.bCF.aDN().getTop_notice_data();
                    if (top_notice_data != null && top_notice_data.getTitle() != null) {
                        com.baidu.tbadk.core.data.az azVar = new com.baidu.tbadk.core.data.az();
                        azVar.setTitle(top_notice_data.getTitle());
                        azVar.bI(2);
                        azVar.cr(top_notice_data.rF());
                        azVar.parser_title();
                        this.bCF.t(azVar);
                    }
                    this.bCF.bbi();
                    if (this.bCQ.bPU && (baH = nVar.baH()) != 1) {
                        this.bCo = true;
                        hj(baH);
                        return;
                    }
                    ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bCF.getThreadList();
                    if (threadList != null) {
                        ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bCZ.a(true, threadList);
                        if (a2 != null) {
                            this.bCF.ay(a2);
                        }
                        this.bCD.a(threadList, this.mPn, this.bCF, this.bCF.getPage().pE());
                        VA();
                        this.bCR.hW(this.mPn);
                        this.bCR.f(this.bCF);
                        this.bCV.a(this.bCD.getListView(), this.bCF, this.bCQ.ZK());
                        this.bCD.Wo();
                    }
                    this.bCx = this.bCF.ZG();
                    if (this.bCz != null) {
                        this.bCy = true;
                        this.bCz.qy(this.bCx);
                    }
                    hideLoadingView(this.bCD.getRootView());
                    if (this.bCD.Wh() != null && this.mIsLogin) {
                        this.bCD.Wh().setVisibility(0);
                    }
                    if (this.bCT != null && this.mIsLogin) {
                        this.bCT.dC(true);
                    }
                    if (this.bCT != null && !this.bCT.isMenuShowing()) {
                        this.bCD.dk(true);
                    }
                    this.bCD.dn(false);
                    if (this.bCF.aDN().isIs_forbidden() == 1) {
                        this.bCS.dN(false);
                    } else {
                        this.bCS.dN(true);
                    }
                    this.bCS.dM(this.bCF.bal() == 1);
                    this.bCo = true;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void dg(boolean z) {
        if (this.bDb != null) {
            this.bDb.a(z, this.bCV, this.bCR, this.bCD, this.bCF);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        bCk = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (intent != null) {
            this.btl = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (intent.getData() != null) {
                Uri data = intent.getData();
                this.bCu = data.getQueryParameter("name");
                this.Zw = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.bCu)) {
                    intent.putExtra("name", this.bCu);
                }
                if (!StringUtils.isNull(this.Zw)) {
                    intent.putExtra("from", this.Zw);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.bCu)) {
                this.bCu = j(intent);
                if (!StringUtils.isNull(this.bCu)) {
                    intent.putExtra("name", this.bCu);
                }
            }
        } else {
            this.btl = System.currentTimeMillis();
        }
        this.Od = System.currentTimeMillis();
        this.aym = this.Od - this.btl;
        if (!dh(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.Od;
            return;
        }
        super.onCreate(bundle);
        this.bCQ = new com.baidu.tieba.frs.f.a(this);
        this.bCQ.a(this.bDf);
        this.bCQ.init();
        if (getIntent() != null) {
            this.bCQ.d(getIntent().getExtras());
        } else if (bundle != null) {
            this.bCQ.d(bundle);
        } else {
            this.bCQ.d(null);
        }
        VG().A(3, true);
        this.bCp = new com.baidu.tieba.frs.entelechy.c();
        this.bDb = this.bCp.XA();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(u.h.frs_activity, (ViewGroup) null);
        this.bCT = new com.baidu.tieba.frs.i.y(this, this.bCp.Xz());
        this.bCS = new com.baidu.tieba.frs.i.aa(this);
        this.bCT.a(getPageContext().getPageActivity(), inflate, this.bCS.aar().getView());
        this.bCR = new com.baidu.tieba.frs.i.p(this, this.bCp);
        this.bCV = this.bCp.N(this);
        this.bCD = new bq(this, this.bDr, this.bCp);
        this.bCR.a(this.bCD.Il());
        this.bCV.ag(this.bCD.getRootView());
        if (getIntent() != null) {
            this.bCR.i(getIntent().getExtras());
        } else if (bundle != null) {
            this.bCR.i(bundle);
        } else {
            this.bCR.i((Bundle) null);
        }
        this.bBm = getVoiceManager();
        this.bBm.onCreate(getPageContext());
        nl();
        initData(bundle);
        this.bCD.setForumName(this.bCu);
        this.bBp.setUniqueId(getUniqueId());
        this.bBp.registerListener();
        addGlobalLayoutListener();
        Vp();
        Vo();
        Vn();
        registerListener(this.LV);
        registerListener(this.mMemListener);
        registerListener(this.bDi);
        registerListener(this.adR);
        registerListener(this.aOy);
        registerListener(this.bzD);
        registerListener(this.bDj);
        registerListener(this.bDm);
        registerListener(this.bDn);
        registerListener(this.bbo);
        registerListener(this.bDh);
        this.bDo.bo().setSelfListener(true);
        this.bDo.bn().setSelfListener(true);
        this.bDo.setTag(getUniqueId());
        registerListener(this.bDo);
        registerListener(this.bDp);
        this.bCZ = new com.baidu.tieba.frs.loadmore.a(this);
        this.bCZ.registerListener();
        this.bCz = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.eXc);
        this.createTime = System.currentTimeMillis() - this.Od;
        if (this.bCD != null) {
            showLoadingView(this.bCD.getRootView(), true);
            this.bCD.m12do(false);
        }
        this.bCY = new Cdo(getActivity(), this.bCD, this.bCR);
        this.bCY.du(true);
        this.bCX = new com.baidu.tieba.d.c(getActivity());
        this.bCX.a(this.aYC);
        this.bDe = new com.baidu.tieba.frs.i.a(getPageContext(), this.bCQ.ZJ());
        this.bCW = new com.baidu.tieba.frs.headvideo.c(this, this.bCD.getRootView(), this.bCR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vm() {
        com.baidu.tbadk.data.e eVar = new com.baidu.tbadk.data.e();
        if (this.bCF != null && this.bCF.aDN() != null) {
            eVar.setForumId(com.baidu.adp.lib.h.b.c(this.bCF.aDN().getId(), 0L));
            eVar.eZ(this.bCF.aDN().getName());
            eVar.fa(this.bCF.aDN().getImage_url());
            eVar.ea(this.bCF.aDN().getSigned() ? 1 : 0);
            eVar.dZ(this.bCF.aDN().getUser_level());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_SET_COMMON_ACCESS_FORUM, eVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
        } else if (this.bCF != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null && this.bCD != null) {
            com.baidu.tbadk.core.data.ad adVar = new com.baidu.tbadk.core.data.ad();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(getMyPostResIdl.data.thread_info.author);
            a(metaData, getMyPostResIdl.data.user_info, getMyPostResIdl.data.thread_info.twzhibo_info);
            metaData.setPortrait(TbadkCoreApplication.getCurrentPortrait());
            String userId = metaData.getUserId();
            if (userId != null && !userId.equals("0")) {
                hashMap.put(metaData.getUserId(), metaData);
            }
            adVar.setUserMap(hashMap);
            adVar.a(getMyPostResIdl.data.thread_info);
            this.bCQ.a(adVar);
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bCZ.a(true, this.bCF.getThreadList());
            if (a2 != null) {
                this.bCF.ay(a2);
                this.bCF.baW();
                this.bCD.a(a2, this.mPn, this.bCF, this.bDa);
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
                    str = getPageContext().getResources().getString(u.j.fans_default_name);
                }
                metaData.setFansNickName(str);
            }
        }
    }

    private void Vn() {
        com.baidu.tbadk.task.b a2 = com.baidu.tieba.tbadkCore.a.a.a(309360, ResponseIncrForumAccessCountSocketMessage.class, false, false);
        a2.setResponsedClass(ResponseIncrForumAccessCountSocketMessage.class);
        a2.h(true);
        a2.i(false);
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

    private void Vo() {
        com.baidu.tbadk.task.b a2 = com.baidu.tieba.tbadkCore.a.a.a(309365, ResponseSetCommForumStateSocketMessage.class, false, false);
        a2.setResponsedClass(ResponseSetCommForumStateSocketMessage.class);
        a2.h(true);
        a2.i(false);
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

    private void Vp() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MY_POST, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_MY_POST + "?cmd=303111");
        tbHttpMessageTask.setResponsedClass(GetMyPostHttpResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(303111);
        bVar.setResponsedClass(GetMyPostSocketResponseMessage.class);
        bVar.h(true);
        bVar.i(false);
        bVar.a(SocketMessageTask.DupLicateMode.NONE);
        messageManager.registerTask(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.bBm = getVoiceManager();
        this.bBm.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bDv);
        if (bundle != null) {
            this.bCu = bundle.getString("name");
            this.Zw = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bCu = intent.getStringExtra("name");
                this.Zw = intent.getStringExtra("from");
                this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.Zw) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.Zw)) {
            setSwipeBackEnabled(false);
        }
        this.bCG = new cx(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            Vq();
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.bDv);
        }
        this.bCR.i(bundle);
    }

    private String j(Intent intent) {
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

    public void Vq() {
        if (this.bCG != null && this.bCD != null) {
            if (FrsActivityStatic.bDN || FrsActivityStatic.bDO) {
                this.bCG.aS(com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgReplyme());
                this.bCG.aR(com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgAtme());
                this.bCG.aU(com.baidu.tbadk.coreExtra.messageCenter.a.xn().xu());
                this.bCG.aT(com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgChat());
                this.bCD.a(this.bCG);
                this.bCS.a(this.bCG);
            }
        }
    }

    private boolean dh(boolean z) {
        if (z && com.baidu.tieba.frs.utils.a.H(TbadkCoreApplication.m9getInst().getApplicationContext(), getClass().getName())) {
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
        if (this.bCF != null && this.bCF.aDN() != null) {
            dh.WY().aW(com.baidu.adp.lib.h.b.c(this.bCF.aDN().getId(), 0L));
        }
        if (this.bCD != null) {
            this.bCD.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.bCN != null) {
                this.bCN.onDestroy();
            }
            this.bCD.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.bCQ.onActivityDestroy();
        this.bCR.onActivityDestroy();
        this.bBm = getVoiceManager();
        this.bBm.onDestory(getPageContext());
        if (this.bCO != null) {
            this.bCO.cancel(true);
            this.bCO = null;
        }
        if (this.bCQ != null) {
            this.bCQ.UC();
        }
        if (this.bCS != null) {
            this.bCS.destroy();
        }
        if (this.bCY != null) {
            this.bCY.Xh();
        }
        if (this.bDd != null) {
            this.bDd.destory();
        }
        if (this.bDe != null) {
            this.bDe.destory();
        }
        if (this.bCW != null) {
            this.bCW.onDestroy();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.bCu);
        bundle.putString("from", this.Zw);
        this.bCQ.onSaveInstanceState(bundle);
        this.bBm = getVoiceManager();
        if (this.bBm != null) {
            this.bBm.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.az pr;
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    hk(0);
                    return;
                case 11002:
                    this.bCR.kW();
                    return;
                case 11011:
                    e(this.bCE);
                    return;
                case 11012:
                    f(this.bCH);
                    return;
                case 11014:
                    this.bCR.aao();
                    return;
                case 11016:
                    this.bCD.Wn();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    this.bCR.VF();
                    return;
                case 12016:
                    k(intent);
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
                    this.bCD.Ww().notifyDataSetChanged();
                    if (this.bCR != null) {
                        this.bCR.Xy();
                    }
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (pr = this.bCF.pr(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            pr.bJ(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            pr.parser_title();
                            bV(6);
                            return;
                        } else if (intExtra == 0) {
                            this.bCF.u(pr);
                            this.bCD.Wo();
                            if (com.baidu.tieba.tbadkCore.d.bah() != null) {
                                com.baidu.tieba.tbadkCore.d.bah().N(this.bCu, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    Vx();
                    return;
                case 23003:
                    if (intent != null && this.bCF != null) {
                        cp.a(this, this.bCF, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    cp.a(this, this.bCF, intent);
                    return;
                case 23013:
                    Vy();
                    return;
                case 23019:
                    Vz();
                    return;
                case 24002:
                    if (intent != null) {
                        int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                        int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                        int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                        int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                        if (intExtra2 == com.baidu.adp.lib.h.b.g(this.forumId, 0)) {
                            this.bCR.p(intExtra3, intExtra4, intExtra5);
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

    private void k(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(WriteActivityConfig.TOGETHERHI_DATA);
            if (!TextUtils.isEmpty(stringExtra)) {
                int i = 0;
                if (this.bCF.getUserData() != null) {
                    i = this.bCF.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), 0, this.bCF.aDN().getId(), this.bCu, null, null, 0, this.bCF.pt(), 13003, false, false, null, false, false, null, null, this.bCF.aDN().getPrefixData(), i);
                if (dd.WW().ht(1) != null) {
                    writeActivityConfig.setCategroyId(this.bCQ.ZD());
                }
                boolean Fj = com.baidu.tbadk.plugins.d.Fj();
                if (!this.bCF.getUserData().canPostHi()) {
                    Fj = false;
                }
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.TOGETHERHI_SHOW, Fj);
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.TOGETHERHI_DATA, stringExtra);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostWriteCallBackData postWriteCallBackData) {
        if (this.bCQ != null) {
            if (this.bCQ.WQ() == 2 || this.bCQ.WQ() == 3) {
                int ZD = this.bCQ.ZD();
                if (dd.WW().ht(1) == null) {
                    ZD = 0;
                }
                if (ZD == 0 && postWriteCallBackData != null) {
                    long c = com.baidu.adp.lib.h.b.c(postWriteCallBackData.getPostId(), 0L);
                    long c2 = com.baidu.adp.lib.h.b.c(postWriteCallBackData.getThreadId(), 0L);
                    long c3 = com.baidu.adp.lib.h.b.c(this.forumId, 0L);
                    if (c != 0 && c2 != 0 && c3 != 0) {
                        com.baidu.adp.lib.h.h.dM().postDelayed(new ah(this, c2, c, c3), 1000L);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bCD != null) {
            this.bCD.Wl();
            try {
                if ("OPPO".equals(Build.MANUFACTURER) && this.bCD.Wd() != null) {
                    Method declaredMethod = AbsListView.class.getDeclaredMethod("trackMotionScroll", Integer.TYPE, Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.bCD.getListView(), 500, 10);
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
        this.bCV.a(this.bDg);
        this.bBf = true;
        this.bCP = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.bCD.jB();
        } else if (bCr) {
            bCr = false;
            this.bCD.jB();
        } else {
            this.bBm = getVoiceManager();
            this.bBm.onResume(getPageContext());
            this.bCD.dq(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.bCD.dp(z);
        this.bCT.dC(z);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.bCu = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.Zw = intent.getStringExtra("from");
            }
            this.bCw = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.bCw) {
                di(intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false));
            }
        }
    }

    private void di(boolean z) {
        this.bCD.jB();
        this.bCT.showContent(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.Zw)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            } else {
                com.baidu.tbadk.core.d.b.d(getPageContext().getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.Zw)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        } else {
            com.baidu.tbadk.core.d.b.d(getPageContext().getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.Zw)) {
            finish();
        }
    }

    private void nl() {
        this.bCD.Ww().m(this.bDt);
        this.bCD.Ww().n(this.bDu);
        if (this.mFlag == 0) {
            this.bCD.setTitle(this.bCu);
        } else {
            this.bCD.setTitle("");
            this.mFlag = 1;
        }
        this.bCR.a(this.bCD.getListView());
        this.bCD.a(this.bDw);
        this.bCD.a(this.bDx);
        this.bCD.setOnScrollListener(this.bBn);
        this.bCD.a(this.bDq);
        this.bCD.g(this.bAH);
        this.bCD.Ww().a(this.bDs);
        if (!this.mIsLogin) {
            this.bCD.dp(false);
            this.bCT.dC(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.bCD.onChangeSkinType(i);
        this.bCS.a(getPageContext(), i);
        this.bCR.a(getPageContext(), i);
        this.bCV.onChangeSkinType(i);
        changeSwipeSkinType(i);
        if (this.bCW != null) {
            this.bCW.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> UV() {
        if (this.bCI == null) {
            this.bCI = FrsCommonImageLayout.o(getPageContext().getPageActivity(), 12);
        }
        return this.bCI;
    }

    @Override // com.baidu.adp.widget.f.b
    public void kj() {
        setSwipeBackEnabled(true);
        this.bCT.dC(true);
    }

    @Override // com.baidu.adp.widget.f.b
    public void kk() {
        setSwipeBackEnabled(false);
        this.bCT.dC(false);
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
            return Boolean.valueOf(com.baidu.tieba.frs.utils.a.I(FrsActivity.this.getPageContext().getPageActivity(), this.name));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                FrsActivity.this.showToast(u.j.shortcut_has_add);
            } else {
                FrsActivity.this.iT(this.name);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iT(String str) {
        Intent J;
        if (str != null && (J = com.baidu.tieba.frs.utils.a.J(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(u.j.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", J);
            BarImageView aan = this.bCR.aan();
            if (aan != null && aan.getBdImage() != null && aan.getBdImage().jb() != null) {
                Bitmap jb = aan.getBdImage().jb();
                Float valueOf = Float.valueOf(getResources().getDisplayMetrics().density);
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.d.eZ().a(com.baidu.adp.lib.util.d.eZ().resizeBitmap(jb, valueOf.intValue() * 48), valueOf.intValue() * 6));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), u.f.icon));
            }
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    private void hk(int i) {
        if (!this.mIsLogin) {
            if (this.bCF != null && this.bCF.pt() != null) {
                this.bCF.pt().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.bCF != null) {
            if (i == 0) {
                if (!this.bCs) {
                    hl(0);
                    return;
                }
                TiebaStatic.log("c10152");
                hl(4);
                return;
            }
            this.bCD.Wn();
        }
    }

    private void hl(int i) {
        int i2 = i == 4 ? 7 : i;
        int i3 = 0;
        if (this.bCF.getUserData() != null) {
            i3 = this.bCF.getUserData().getIsMem();
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), i2, this.bCF.aDN().getId(), this.bCu, null, null, 0, this.bCF.pt(), 13003, false, false, null, false, false, null, null, this.bCF.aDN().getPrefixData(), i3);
        if (dd.WW().ht(1) != null) {
            writeActivityConfig.setCategroyId(this.bCQ.ZD());
        }
        boolean Fj = com.baidu.tbadk.plugins.d.Fj();
        if (!this.bCF.getUserData().canPostHi()) {
            Fj = false;
        }
        writeActivityConfig.getIntent().putExtra(WriteActivityConfig.TOGETHERHI_SHOW, Fj);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    public void Vr() {
        int i = 0;
        if (this.bCF.getUserData() != null) {
            i = this.bCF.getUserData().getIsMem();
        }
        EcommProductListActivityConfig ecommProductListActivityConfig = new EcommProductListActivityConfig(getPageContext().getPageActivity(), 7, this.bCF.aDN().getId(), this.bCu, null, null, 0, this.bCF.pt(), 13003, false, false, null, false, false, null, null, this.bCF.aDN().getPrefixData(), i, "");
        ecommProductListActivityConfig.addEcommAddress(this.bCA);
        if (dd.WW().ht(1) != null) {
            ecommProductListActivityConfig.setCategroyId(this.bCQ.ZD());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, ecommProductListActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.az azVar) {
        boolean rn = azVar == null ? true : azVar.rn();
        this.bCD.a(new ai(this, azVar));
        this.bCD.a(azVar, rn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tbadk.core.data.az azVar) {
        boolean rn = azVar == null ? true : azVar.rn();
        if (this.mThreadId != null) {
            if (!rn) {
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(azVar, this.bCu, null, 18003, true, true, this.bCB);
                createFromThreadCfg.setVideo_source("frs");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg2 = new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(azVar, this.bCu, null, 18003, false, false, this.bCB);
            createFromThreadCfg2.setVideo_source("frs");
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.core.data.az azVar) {
        if (this.mThreadId != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(azVar, this.bCu, null, 18003, false, false, this.bCB);
            createFromThreadCfg.setVideo_source("frs");
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void refresh() {
        bV(3);
    }

    public void bV(int i) {
        this.bDk = false;
        this.bCo = false;
        this.bCC = false;
        UR();
        VG().A(i, true);
    }

    private void Vs() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.h.k.dN().c(new aj(this));
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vt() {
        UR();
        try {
            if (this.bCF != null) {
                this.bCD.Mc();
                this.bCD.Wc();
                if (this.bCT != null && !this.bCT.isMenuShowing()) {
                    this.bCD.dk(true);
                }
                if (com.baidu.tieba.frs.i.p.h(this.bCF)) {
                    this.bCD.WG();
                }
                this.bCu = this.bCF.aDN().getName();
                this.forumId = this.bCF.aDN().getId();
                this.bCD.setTitle(this.bCu);
                TbadkCoreApplication.m9getInst().setDefaultBubble(this.bCF.getUserData().getBimg_url());
                TbadkCoreApplication.m9getInst().setDefaultBubbleEndTime(this.bCF.getUserData().getBimg_end_time());
                Vs();
                ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bCF.getThreadList();
                if (threadList != null) {
                    this.bCD.a(threadList, this.mPn, this.bCF, this.bCF.getPage().pE());
                    VA();
                    this.bCR.hW(this.mPn);
                    this.bCR.f(this.bCF);
                    this.bCV.a(this.bCD.getListView(), this.bCF, this.bCQ.ZK());
                    this.bCD.Wo();
                    Vu();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void Vu() {
        if (this.bCF != null) {
            if (this.bCF.aDV() == 1) {
                this.bCD.Ww().setFromCDN(true);
            } else {
                this.bCD.Ww().setFromCDN(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bBf = false;
        this.bCP = false;
        this.bCD.onPause();
        this.bBm = getVoiceManager();
        this.bBm.onPause(getPageContext());
        this.bCD.dq(true);
        if (this.bDe != null) {
            this.bDe.ZQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Object c;
        super.onStop();
        if (this.bCF != null && this.bCF.aDN() != null) {
            com.baidu.tbadk.distribute.a.AU().b(getPageContext().getPageActivity(), "frs", this.bCF.aDN().getId(), 0L);
        }
        this.bBm = getVoiceManager();
        if (this.bBm != null) {
            this.bBm.onStop(getPageContext());
        }
        BdListView listView = getListView();
        if (listView != null && (c = com.baidu.adp.lib.a.a.a.c(listView, "mRecycler")) != null) {
            com.baidu.adp.lib.a.a.a.a("clear", c, c.getClass());
        }
        this.bCR.onActivityStop();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.bCv) {
            if (i == 4) {
                if (this.bCT.isMenuShowing()) {
                    this.bCT.dD(true);
                    if (this.bCS.aar().Xq()) {
                        this.bCS.aar().dy(false);
                        refresh();
                        return true;
                    }
                    return true;
                } else if (this.bCD.Wk()) {
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

    public void a(com.baidu.tbadk.core.data.b bVar, int i, boolean z) {
        String trim;
        if (bVar != null) {
            if (!com.baidu.adp.lib.util.i.ff()) {
                showToast(u.j.neterror);
            } else if (bVar.ox()) {
                com.baidu.tbadk.core.util.bi.us().a(getPageContext(), new String[]{bVar.MJ}, true);
            } else if (bVar.ow()) {
                if (com.baidu.adp.lib.util.i.fr() && !com.baidu.adp.lib.util.i.fs()) {
                    trim = getPageContext().getString(u.j.frs_network_tips);
                } else if (TextUtils.isEmpty(bVar.MW.Nh.trim())) {
                    trim = getPageContext().getString(u.j.confirm_download_app);
                } else {
                    trim = bVar.MW.Nh.trim();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cz(trim);
                aVar.a(u.j.alert_yes_button, new al(this, bVar, z, i));
                aVar.b(u.j.alert_no_button, new am(this));
                aVar.b(getPageContext()).rT();
            }
        }
    }

    public boolean d(com.baidu.tbadk.core.data.b bVar, int i) {
        if (bVar == null) {
            return false;
        }
        if (!bVar.ov()) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), u.j.pb_app_error);
            return false;
        } else if (!com.baidu.tieba.tbadkCore.al.s(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), u.j.write_external_storage_permission_denied_fun_disable);
            return false;
        } else {
            boolean a2 = com.baidu.tieba.tbadkCore.al.a(getPageContext().getPageActivity(), bVar, i);
            if (a2) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", bVar.MN);
            }
            return a2;
        }
    }

    public boolean Vv() {
        if (this.bCU == null) {
            return false;
        }
        return this.bCU.isShowing();
    }

    public void Vw() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
        this.bCO = new a(this.bCu);
        this.bCO.setSelfExecute(true);
        this.bCO.execute(new String[0]);
    }

    public void Vx() {
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.bCF.aDN().getId(), true, true, true);
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.AU().a(getPageContext().getPageActivity(), bVar, str, "frs", this.bCF.aDN().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.AU().a(bVar, this.forumId, 0L, "FRS", str, this.mPn);
    }

    public int getPn() {
        return this.mPn;
    }

    public void Vy() {
        if (checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10177").ab("fid", this.forumId));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(getPageContext().getPageActivity(), String.valueOf(getForumId()), false, 0)));
        }
    }

    public void Vz() {
        if (checkUpIsLogin() && this.bCt != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(getPageContext().getPageActivity()).createConfig(String.valueOf(getForumId()), this.bCt.getTid(), 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hi(int i) {
        ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bCF.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.az) {
                    com.baidu.tbadk.core.data.az azVar = (com.baidu.tbadk.core.data.az) next;
                    if (azVar == this.bCn) {
                        c(azVar, i);
                        this.bCn = null;
                        break;
                    } else if (azVar.getId() != null && azVar.getId().equals(this.bBg)) {
                        c(azVar, i);
                        this.bBg = null;
                        break;
                    }
                }
            }
            this.bCD.Ww().a(threadList, this.bCF);
            this.bCD.Ww().notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tbadk.core.data.az azVar, int i) {
        if (i == 1) {
            PraiseData praise = azVar.getPraise();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (praise == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    azVar.setPraise(praiseData);
                    return;
                }
                azVar.getPraise().getUser().add(0, metaData);
                azVar.getPraise().setNum(azVar.getPraise().getNum() + 1);
                azVar.getPraise().setIsLike(i);
            }
        } else if (azVar.getPraise() != null) {
            azVar.getPraise().setIsLike(i);
            azVar.getPraise().setNum(azVar.getPraise().getNum() - 1);
            ArrayList<MetaData> user = azVar.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        azVar.getPraise().getUser().remove(next);
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
            if (this.bDd == null) {
                this.bDd = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bDd.ap(updateAttentionMessage.getData().toUid, getForumId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.tbadk.core.data.az azVar;
        ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bCF.getThreadList();
        if (threadList != null && updateAttentionMessage != null && updateAttentionMessage.getData() != null) {
            MetaData metaData = new MetaData();
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            MetaData metaData2 = metaData;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.az) && (azVar = (com.baidu.tbadk.core.data.az) next) != null && azVar.getAuthor() != null && azVar.getAuthor().getUserId() != null && azVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid) && !azVar.getAuthor().equals(metaData2)) {
                    a(azVar, updateAttentionMessage);
                    metaData2 = azVar.getAuthor();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.az azVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        int i2;
        if (azVar != null && azVar.getAuthor() != null && azVar.getAuthor().getUserId() != null && azVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = azVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
                i2 = 1;
            } else {
                i = fansNum - 1;
                i2 = 0;
            }
            azVar.getAuthor().setFansNum(i);
            if (azVar.getAuthor().getGodUserData() != null) {
                azVar.getAuthor().getGodUserData().setFollowed(i2);
                azVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bBm == null) {
            this.bBm = VoiceManager.instance();
        }
        return this.bBm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: LO */
    public BdListView getListView() {
        if (this.bCD == null) {
            return null;
        }
        return this.bCD.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void UR() {
        this.bBm = getVoiceManager();
        this.bBm.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vA() {
        if (this.bCD == null) {
            return 0;
        }
        return this.bCD.Ws();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> vB() {
        if (this.adT == null) {
            this.adT = UserIconBox.e(getPageContext().getPageActivity(), 8);
        }
        return this.adT;
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
            if (this.bCG != null) {
                this.bCG.aS(msgReplyme);
                this.bCG.aR(msgAtme);
                this.bCG.aV(msgOfficialMerge);
                this.bCG.aT(msgChat);
                this.bCG.aU(msgStrangerChat);
                this.bCD.a(this.bCG);
                this.bCS.a(this.bCG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.bCF != null && this.bCD != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.bCD.Wl();
            }
        }
    }

    private void VA() {
        HashMap<Integer, com.baidu.tbadk.core.data.az> XS;
        if (this.bCD != null && this.bCD.Ww() != null && (XS = this.bCD.Ww().XS()) != null) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.az> entry : XS.entrySet()) {
                com.baidu.tbadk.core.data.az value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.b)) {
                    arrayList.add((com.baidu.tbadk.core.data.b) value);
                }
            }
            com.baidu.tbadk.download.b.Ba().n(arrayList);
        }
    }

    public void VB() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.a(getPageContext().getPageActivity(), getCurrentFocus());
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

        /* JADX DEBUG: Multi-variable search result rejected for r2v32, resolved type: com.baidu.tieba.frs.FrsActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.My.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Mz.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.MA.getId()) {
                    if (vVar == null || !(vVar instanceof com.baidu.tbadk.core.data.b)) {
                        return;
                    }
                    FrsActivity.this.a((com.baidu.tbadk.core.data.b) vVar, i, view.findViewById(u.g.frs_app_download), (AppDownloadView) view.findViewById(u.g.frs_app_download_view));
                } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.ab.eWn.getId()) {
                    if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.MB.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.MC.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.MD.getId()) {
                        if (vVar != null && (vVar instanceof com.baidu.tbadk.core.data.b)) {
                            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) vVar;
                            if (!bVar.ow()) {
                                if (!bVar.ox()) {
                                    return;
                                }
                                FrsActivity.this.b(bVar);
                                return;
                            }
                            FrsActivity.this.a(bVar, i, view.findViewById(u.g.frs_app_download), (AppDownloadView) view.findViewById(u.g.frs_app_download_view));
                        }
                    } else if (vVar != null && (vVar instanceof com.baidu.tbadk.core.data.az)) {
                        com.baidu.tbadk.core.data.az azVar = (com.baidu.tbadk.core.data.az) vVar;
                        if (azVar.getAnchorInfoData() == null || azVar.getAnchorInfoData().getGroup_id() == 0 || FrsActivity.this.checkUpIsLogin()) {
                            if ((azVar.rd() != 1 && azVar.rd() != 2) || FrsActivity.this.checkUpIsLogin()) {
                                if (azVar.qS() != null) {
                                    if (FrsActivity.this.checkUpIsLogin()) {
                                        String postUrl = azVar.qS().getPostUrl();
                                        if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.fI()) {
                                            com.baidu.tbadk.browser.f.v(FrsActivity.this.getActivity(), postUrl);
                                        }
                                    }
                                } else if (azVar.rs() != null) {
                                    com.baidu.tbadk.core.data.l rs = azVar.rs();
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsActivity.this.getPageContext().getPageActivity(), rs.getCartoonId(), rs.getChapterId(), 2)));
                                } else {
                                    com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m9getInst().getReadThreadHistory();
                                    if (readThreadHistory != null && !readThreadHistory.pL(azVar.getId())) {
                                        readThreadHistory.pK(azVar.getId());
                                    }
                                    boolean z = false;
                                    String qN = azVar.qN();
                                    if (qN != null && !qN.equals("")) {
                                        z = true;
                                        new Thread(new at(this, qN)).start();
                                    }
                                    String tid = azVar.getTid();
                                    if (tid == null) {
                                        tid = "";
                                    }
                                    if (azVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                                        com.baidu.tbadk.core.util.bi us = com.baidu.tbadk.core.util.bi.us();
                                        TbPageContext<?> pageContext = FrsActivity.this.getPageContext();
                                        String[] strArr = new String[3];
                                        strArr[0] = tid;
                                        strArr[1] = "";
                                        us.c(pageContext, strArr);
                                        return;
                                    }
                                    boolean z2 = false;
                                    if (azVar instanceof com.baidu.tbadk.core.data.t) {
                                        z2 = true;
                                        TiebaStatic.log("c10769");
                                    }
                                    if (azVar.getThreadType() == 33 || (azVar instanceof com.baidu.tbadk.core.data.ak)) {
                                        if (!z2) {
                                            String str = azVar.getThreadType() == 33 ? "c10245" : "c10180";
                                            if (FrsActivity.this.bCQ.ZF() == 5) {
                                                str = "c10387";
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ay(str).ab("fid", FrsActivity.this.forumId));
                                        }
                                        FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(FrsActivity.this.getPageContext().getPageActivity(), azVar.getTid()).ci("from_frs").bp(18003).ol()));
                                        return;
                                    }
                                    if (tid.startsWith("pb:")) {
                                        azVar.setId(tid.substring(3));
                                    }
                                    if (!z2 && FrsActivity.this.bCQ.ZF() == 2) {
                                        com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c10077");
                                        ayVar.s("obj_source", FrsActivity.this.bCQ.ZF());
                                        ayVar.ab("tid", azVar.getId());
                                        ayVar.ab("fid", FrsActivity.this.getForumId());
                                        TiebaStatic.log(ayVar);
                                    }
                                    if (bdUniqueId.getId() == com.baidu.tbadk.core.data.az.Rd.getId() && azVar.rb() == 2 && azVar.qy() != null) {
                                        String oH = azVar.qy().oH();
                                        if (StringUtils.isNull(oH)) {
                                            oH = azVar.qy().getTaskId();
                                        }
                                        com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", azVar.qy().getForumId(), azVar.qy().getForumName(), azVar.qy().getThreadId(), "tieba.baidu.com/p/" + azVar.qy().getThreadId(), oH);
                                        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
                                            FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(FrsActivity.this.getPageContext().getPageActivity()).createNormalCfg(azVar.qy().getThreadId(), azVar.qy().getTaskId(), azVar.qy().getForumId(), azVar.qy().getForumName(), azVar.getIs_top(), azVar.getIs_good())));
                                            return;
                                        }
                                    }
                                    com.baidu.tbadk.core.util.ay ab = new com.baidu.tbadk.core.util.ay("c10806").s("obj_locate", 3).ab("tid", azVar.getId());
                                    if (azVar.getAuthor() != null && azVar.getAuthor().getGodInfo() != null) {
                                        TiebaStatic.log(ab);
                                    }
                                    PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsActivity.this.getPageContext().getPageActivity()).createFromThreadCfg(azVar, FrsActivity.this.bCu, null, 18003, true, false, z);
                                    if (i == 4) {
                                        createFromThreadCfg.setVideo_source("floor5");
                                    } else {
                                        createFromThreadCfg.setVideo_source("frs");
                                    }
                                    FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                                    if (azVar.Rl != null) {
                                        com.baidu.tbadk.core.util.ay ayVar2 = new com.baidu.tbadk.core.util.ay("c11430");
                                        ayVar2.ab("tid", azVar.getTid());
                                        ayVar2.ab("obj_id", new StringBuilder(String.valueOf(azVar.Rl.productId)).toString());
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.b bVar, int i, View view, AppDownloadView appDownloadView) {
        if (bVar != null) {
            a(bVar, true, this.mPn);
            DownloadData downloadData = new DownloadData(bVar.MN);
            downloadData.setUrl(bVar.MK);
            downloadData.setName(bVar.MH);
            downloadData.setPosition(i);
            downloadData.setNotifyId(com.baidu.adp.lib.h.b.g(bVar.MG, 0));
            switch (AppDownloadView.b(downloadData)) {
                case 3:
                    com.baidu.tieba.frs.utils.a.G(getPageContext().getPageActivity(), bVar.MN);
                    break;
                case 6:
                case 7:
                    if (com.baidu.adp.lib.util.i.fr() && !com.baidu.adp.lib.util.i.fs()) {
                        a(bVar, i, true);
                        break;
                    } else if (bVar.ox()) {
                        com.baidu.tbadk.core.util.bi.us().a(getPageContext(), new String[]{bVar.MJ}, true);
                        break;
                    } else if (bVar.ow() && d(bVar, i)) {
                        if (appDownloadView != null) {
                            appDownloadView.setVisibility(0);
                        }
                        if (view instanceof TextView) {
                            ((TextView) view).setText(u.j.downloading2);
                        }
                        a(bVar, "area_download");
                        break;
                    }
                    break;
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", bVar.MN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.b bVar) {
        if (bVar != null) {
            a(bVar, true, this.mPn);
            com.baidu.tbadk.core.util.bi.us().a(getPageContext(), new String[]{bVar.MJ}, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.k.fI()) {
            hideNetRefreshView(this.bCD.getRootView());
            showLoadingView(this.bCD.getRootView(), true);
            this.bCD.m12do(false);
            this.bCD.jB();
        }
    }

    public com.baidu.tieba.tbadkCore.p VC() {
        return this.bCF;
    }

    public boolean VD() {
        return this.bCD.VD();
    }

    public void VE() {
        FrsActivityStatic.bDN = false;
        FrsActivityStatic.bDO = false;
        Vq();
    }

    public void VF() {
        this.bCR.VF();
    }

    public com.baidu.tieba.frs.f.a VG() {
        return this.bCQ;
    }

    public bq VH() {
        return this.bCD;
    }

    public void iU(String str) {
        this.bCu = str;
    }

    public void setFrom(String str) {
        this.Zw = str;
    }

    public String getFrom() {
        return this.Zw;
    }

    public void setFlag(int i) {
        this.mFlag = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    public com.baidu.tieba.frs.i.y VI() {
        return this.bCT;
    }

    public com.baidu.tieba.frs.ecomm.a VJ() {
        if (this.bDc == null) {
            this.bDc = new com.baidu.tieba.frs.ecomm.a(this);
            this.bDc.a(new an(this));
        }
        return this.bDc;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jD() {
        if (!com.baidu.adp.lib.util.k.fI()) {
            this.bCD.WC();
        } else if (this.bCQ.ZF() == 1) {
            VK();
            UU();
        } else if (this.bCQ.hasMore()) {
            UU();
        }
    }

    public void iV(String str) {
        VK();
        showToast(str);
    }

    public void K(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.v> a2;
        VK();
        if (arrayList != null && arrayList.size() != 0 && (a2 = this.bCZ.a(false, arrayList, this.bCz)) != null) {
            this.bCF.ay(a2);
            this.bCD.a(a2, this.mPn, this.bCF, 0);
        }
    }

    private void VK() {
        if (this.bDa == 0 && !this.bCZ.at(this.bCF.bas())) {
            if (this.bCF.getThreadList() == null || this.bCF.getThreadList().size() == 0) {
                this.bCD.WC();
                return;
            } else {
                this.bCD.WB();
                return;
            }
        }
        this.bCD.WA();
    }

    public void UU() {
        if (this.bCQ.ZF() == 1) {
            if (!this.bCZ.awp && !this.bCQ.DK()) {
                if (this.bCZ.at(this.bCF.bas())) {
                    this.bCD.a(this.bCZ.YJ(), this.mPn, this.bCF, 0);
                    this.bCZ.a(com.baidu.adp.lib.h.b.c(this.forumId, 0L), this.bCF.bas(), this.bCu, this.mPn);
                } else if (this.bDa != 0) {
                    this.bCD.a(this.bCZ.YJ(), this.mPn, this.bCF, 0);
                    this.mPn++;
                    this.bCQ.hI(this.mPn);
                    this.bCZ.bMw = false;
                    this.bCZ.bMx = 0;
                }
            }
        } else if (!this.bCQ.ZH()) {
            this.bCQ.LL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.b bVar, boolean z, int i) {
        a(bVar, z ? "area_click" : "btn_click");
        b(bVar, "click");
        com.baidu.tieba.recapp.report.b.aUO().a(com.baidu.tieba.recapp.report.e.a(bVar, "click", i));
    }

    public boolean VL() {
        return this.bCS.aar().Xq();
    }

    public void dj(boolean z) {
        this.bCS.aar().dy(z);
    }

    public void VM() {
        if (!com.baidu.tbadk.core.util.ag.c(getPageContext().getPageActivity(), 1)) {
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
            if (com.baidu.tbadk.core.util.ag.Q(getApplicationContext())) {
                com.baidu.tbadk.core.util.au.c(getPageContext());
            } else {
                showToast(u.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ag.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(u.j.sdcard_permission_denied_advert_for_camera);
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

    public com.baidu.adp.widget.ListView.w VN() {
        return this.bDw;
    }

    public com.baidu.adp.widget.ListView.x VO() {
        return this.bDx;
    }

    public com.baidu.tieba.frs.entelechy.b.b VP() {
        return this.bDb;
    }

    public bq VQ() {
        return this.bCD;
    }

    public void VR() {
        if (this.bDe != null) {
            this.bDe.ZQ();
        }
    }

    public void iW(String str) {
        if (this.bcn == null) {
            this.bcn = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.bcn.dS(str);
        this.bcn.aB(true);
    }
}
