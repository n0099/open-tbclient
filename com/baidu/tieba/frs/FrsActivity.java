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
    private com.baidu.adp.lib.f.b<TbImageView> aeH;
    private com.baidu.tbadk.core.data.be bDA;
    private com.baidu.tieba.tbadkCore.data.f bDG;
    private String bDH;
    private cx bDN;
    private com.baidu.adp.lib.f.b<TbImageView> bDP;
    private a bDV;
    private com.baidu.tieba.frs.f.a bDX;
    private com.baidu.tieba.frs.j.p bDY;
    private com.baidu.tieba.frs.j.aa bDZ;
    private com.baidu.tbadk.core.data.be bDs;
    private boolean bDt;
    private String bDu;
    private com.baidu.tieba.frs.entelechy.b.a bDw;
    private boolean bDz;
    VoiceManager bEE;
    private com.baidu.tieba.frs.j.y bEa;
    private com.baidu.tieba.frs.view.p bEb;
    private com.baidu.tieba.frs.entelechy.b.d bEc;
    private com.baidu.tieba.frs.headvideo.c bEd;
    private com.baidu.tieba.d.c bEe;
    private Cdo bEf;
    private com.baidu.tieba.frs.loadmore.a bEg;
    private com.baidu.tieba.frs.entelechy.b.b bEi;
    private com.baidu.tieba.frs.ecomm.a bEj;
    private com.baidu.tbadk.e.a bEk;
    private com.baidu.tieba.frs.j.a bEl;
    private com.baidu.tbadk.core.view.b bdy;
    public static String bDp = "speed_icon_show";
    private static final int bDq = (com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m10getInst()) - TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds100)) - TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds90);
    private static final int bDr = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds300);
    public static boolean bDy = false;
    public static volatile long bDQ = 0;
    public static volatile long bDR = 0;
    public static volatile int bDS = 0;
    private static boolean isNeedRefreshOnResume = false;
    private boolean bDv = false;
    public boolean bDx = false;
    public String bDB = null;
    public String aaf = null;
    public int mFlag = 0;
    private int mPn = 1;
    private boolean bDC = false;
    private boolean bDD = false;
    private String mThreadId = null;
    private String forumId = null;
    private int bDE = 0;
    private boolean bDF = false;
    private boolean bDI = false;
    private boolean bDJ = false;
    private bq bDK = null;
    private final com.baidu.tbadk.core.data.be bDL = null;
    private com.baidu.tieba.tbadkCore.p bDM = new com.baidu.tieba.tbadkCore.p();
    private com.baidu.tbadk.core.data.be bDO = null;
    public long bvA = -1;
    public long azk = 0;
    public long azc = 0;
    public long createTime = 0;
    public long Om = -1;
    private boolean bDT = false;
    public com.baidu.tbadk.performanceLog.e bDU = null;
    private boolean bDW = true;
    private int bEh = -1;
    private dm bEm = new d(this);
    private dl bEn = new o(this);
    private CustomMessageListener aeF = new aa(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener bBR = new ak(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
    private CustomMessageListener bEo = new ao(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private CustomMessageListener aPs = new ap(this, CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND);
    public final CustomMessageListener bEp = new aq(this, CmdConfigCustom.MSG_NEW);
    private CustomMessageListener bEq = new ar(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    private boolean bEr = false;
    public final com.baidu.tieba.tbadkCore.s bEs = new as(this);
    private final CustomMessageListener LT = new e(this, CmdConfigCustom.CMD_REFRESH);
    private final CustomMessageListener mMemListener = new f(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private CustomMessageListener bEt = new g(this, CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS);
    public View.OnTouchListener aGS = new h(this);
    private c.InterfaceC0055c aZA = new i(this);
    private CustomMessageListener bEu = new j(this, CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE);
    private final com.baidu.adp.framework.listener.a bEv = new k(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    private final com.baidu.adp.framework.listener.a bEw = new l(this, CmdConfigHttp.CMD_SET_COMMON_FORUM_STATE, 309365);
    private t.b ado = new m(this);
    private t.d adr = new n(this);
    private t.a adq = new p(this);
    private final BdExpandListView.a bEx = new q(this);
    public final View.OnClickListener bEy = new r(this);
    private final AbsListView.OnScrollListener bEz = new s(this);
    private final ba bEA = new u(this);
    private final com.baidu.tieba.tbadkCore.aj bEB = new com.baidu.tieba.tbadkCore.aj(getPageContext(), new v(this));
    private CustomMessageListener bcm = new w(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private final View.OnClickListener bEC = new x(this);
    private final View.OnClickListener bED = new y(this);
    private final NoNetworkView.a bCV = new z(this);
    private final CustomMessageListener bEF = new ab(this, 0);
    private com.baidu.adp.widget.ListView.w bEG = new b();
    private com.baidu.adp.widget.ListView.x bEH = new ac(this);
    public final com.baidu.adp.base.g bEI = new ad(this);
    public final com.baidu.adp.base.g bEJ = new ae(this);
    private dm bEK = new af(this);

    @Override // com.baidu.tieba.frs.dn
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.dn
    public String getForumName() {
        return this.bDB;
    }

    public com.baidu.tieba.frs.headvideo.c VA() {
        return this.bEd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.z zVar) {
        if (zVar != null) {
            boolean z = zVar.isLike() == 1;
            if (this.bDK != null && this.bDM != null && this.bDM.aGX() != null && zVar.beF() != null) {
                if (zVar.beF().equals(this.bDM.aGX().getId())) {
                    this.bDM.aGX().setLike(zVar.isLike());
                    if (!StringUtils.isNULL(zVar.getLevelName())) {
                        this.bDM.aGX().setLevelName(zVar.getLevelName());
                    }
                    if (zVar.getUserLevel() >= 0) {
                        this.bDM.aGX().setUser_level(zVar.getUserLevel());
                    }
                    if (z) {
                        this.bDY.a(this.bDM, false);
                        this.bDZ.dL(true);
                        TbadkCoreApplication.m10getInst().addLikeForum(this.bDB);
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.bdv().N(this.bDB, false);
                    this.bDM.aGX().setLike(0);
                    this.bDY.aaJ();
                    this.bDZ.dL(false);
                    TbadkCoreApplication.m10getInst().delLikeForum(this.bDB);
                    return;
                }
                if (zVar.isLike() == 1) {
                    this.bDM.pZ(zVar.beF());
                    this.bDY.f(this.bDM);
                    this.bEc.a(this.bDK.getListView(), this.bDM, this.bDX.aaj());
                }
                if (this.bDM.aGX().getBannerListData() != null) {
                    this.bDM.aGX().getBannerListData().setFeedForumLiked(zVar.beF(), zVar.isLike());
                }
                this.bDK.WC();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m10getInst().isGpuOpen();
    }

    public void a(ErrorData errorData) {
        this.bDK.dj(false);
        this.bDK.WC();
        hideLoadingView(this.bDK.getRootView());
        this.bDK.dk(false);
        this.bDK.WI();
        if (!this.bDJ) {
            e.a ZX = VY().ZX();
            if (!this.bDv) {
                if (ZX != null) {
                    if (this.bDX.ZZ() != 0) {
                        this.bDX.aaf();
                        this.bDK.WC();
                    } else {
                        if (ZX.fhI) {
                            if (340001 == ZX.errorCode) {
                                showNetRefreshViewNoClick(this.bDK.getRootView(), getPageContext().getResources().getString(u.j.net_error_text, ZX.errorMsg, Integer.valueOf(ZX.errorCode)), true);
                            } else {
                                showNetRefreshView(this.bDK.getRootView(), getPageContext().getResources().getString(u.j.net_error_text, ZX.errorMsg, Integer.valueOf(ZX.errorCode)), true);
                            }
                        } else if (340001 == ZX.errorCode) {
                            showNetRefreshViewNoClick(this.bDK.getRootView(), ZX.errorMsg, true);
                        } else {
                            showNetRefreshView(this.bDK.getRootView(), ZX.errorMsg, true);
                        }
                        setNetRefreshViewEmotionDefMarginTop();
                        if (this.bDK.Wy() != null) {
                            this.bDK.Wy().setVisibility(8);
                        }
                        if (this.bEa != null) {
                            this.bEa.dA(false);
                        }
                    }
                    this.bDK.j(false, false);
                }
            } else if (ZX != null && ZX.fhI) {
                this.bDK.j(true, false);
                showToast(getPageContext().getResources().getString(u.j.net_error_text, ZX.errorMsg, Integer.valueOf(ZX.errorCode)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean VB() {
        if (this.bEc != null && this.bDK != null) {
            this.bEc.u(this.bDK.getListView());
        }
        if (this.bDY != null && VY() != null) {
            this.bDY.a(VY().KP(), this.bDM);
        }
        boolean z = false;
        if (this.bDM != null) {
            z = this.bDM.bey();
        }
        dd(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hi(int i) {
        ds dsVar = null;
        VB();
        VR();
        try {
            if (this.bDM != null) {
                this.bDK.a(null, 1, this.bDM, 0);
                this.bDY.hX(1);
                this.bDK.WF();
                this.bEc.a(this.bDK.getListView(), this.bDM, this.bDX.aaj());
                com.baidu.tieba.frs.tab.i a2 = a(this.bEc.Yv(), this.bDM.bdV());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    dsVar = new ds();
                    dsVar.bID = a2.url;
                    dsVar.stType = a2.name;
                }
                this.bDX.a(this.bDM.bdV(), 0, dsVar);
                this.bEc.dz(false);
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
            if (iVar != null && iVar.bwu == i) {
                return iVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.n nVar) {
        int bdV;
        if (!this.bEr && nVar != null) {
            try {
                if (this.bDM != null) {
                    this.bDM.d(nVar);
                    VL();
                    this.bEh = this.bDM.getPage().pn();
                    this.bEc.u(this.bDK.getListView());
                    boolean bey = this.bDM.bey();
                    this.bDY.g(com.baidu.tieba.frs.j.p.h(this.bDM), this.bDM.getUserData().getIsMem(), this.bDM.aGX().isLike());
                    dd(bey);
                    if (this.bEi != null) {
                        this.bEi.a(this.bDY, this.bDM);
                    }
                    this.bDK.Mb();
                    this.bDB = this.bDM.aGX().getName();
                    this.forumId = this.bDM.aGX().getId();
                    this.bDK.setTitle(this.bDB);
                    VJ();
                    this.bDM.bel();
                    if (this.bDK.WN().k(com.baidu.tieba.tbadkCore.am.fjD)) {
                        this.bDM.bem();
                    }
                    if (!this.bDX.aah()) {
                        this.bDM.bes();
                    }
                    if (!VY().ZY()) {
                        if (TbadkCoreApplication.m10getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) && !this.bDX.aah()) {
                            this.bDM.ber();
                            this.bDM.beq();
                            this.bDM.beo();
                        }
                        if (!this.bDX.aah()) {
                            this.bDM.bep();
                        }
                    }
                    if (!((!this.bDK.WN().k(com.baidu.tieba.card.a.q.aWG) || this.bDX.aah()) ? false : this.bDM.bev()) && !this.bDX.aah()) {
                        this.bDM.beu();
                    }
                    if (TbadkCoreApplication.m10getInst().isRecAppExist()) {
                        this.bDM.aS(getPageContext().getPageActivity());
                    }
                    this.bDM.bek();
                    com.baidu.tbadk.core.data.bh top_notice_data = this.bDM.aGX().getTop_notice_data();
                    if (top_notice_data != null && top_notice_data.getTitle() != null) {
                        com.baidu.tbadk.core.data.be beVar = new com.baidu.tbadk.core.data.be();
                        beVar.setTitle(top_notice_data.getTitle());
                        beVar.bI(2);
                        beVar.cr(top_notice_data.rE());
                        beVar.rd();
                        this.bDM.v(beVar);
                    }
                    this.bDM.bew();
                    if (this.bDX.bRH && (bdV = nVar.bdV()) != 1) {
                        this.bDv = true;
                        hi(bdV);
                        return;
                    }
                    ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bDM.getThreadList();
                    if (threadList != null) {
                        ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bEg.a(true, threadList);
                        if (a2 != null) {
                            this.bDM.aB(a2);
                        }
                        this.bDK.a(threadList, this.mPn, this.bDM, this.bDM.getPage().pn());
                        VS();
                        this.bDY.hX(this.mPn);
                        this.bDY.f(this.bDM);
                        this.bEc.a(this.bDK.getListView(), this.bDM, this.bDX.aaj());
                        this.bDK.WF();
                    }
                    this.bDE = this.bDM.aad();
                    if (this.bDG != null) {
                        this.bDF = true;
                        this.bDG.qT(this.bDE);
                    }
                    hideLoadingView(this.bDK.getRootView());
                    if (this.bDK.Wy() != null && this.mIsLogin) {
                        this.bDK.Wy().setVisibility(0);
                    }
                    if (this.bEa != null && this.mIsLogin) {
                        this.bEa.dA(true);
                    }
                    if (this.bEa != null && !this.bEa.isMenuShowing()) {
                        this.bDK.dh(true);
                    }
                    this.bDK.dk(false);
                    if (this.bDM.aGX().isIs_forbidden() == 1) {
                        this.bDZ.dN(false);
                    } else {
                        this.bDZ.dN(true);
                    }
                    this.bDZ.dM(this.bDM.bdz() == 1);
                    this.bDv = true;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void dd(boolean z) {
        if (this.bEi != null) {
            this.bEi.a(z, this.bEc, this.bDY, this.bDK, this.bDM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        bDp = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (intent != null) {
            this.bvA = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (intent.getData() != null) {
                Uri data = intent.getData();
                this.bDB = data.getQueryParameter("name");
                this.aaf = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.bDB)) {
                    intent.putExtra("name", this.bDB);
                }
                if (!StringUtils.isNull(this.aaf)) {
                    intent.putExtra("from", this.aaf);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.bDB)) {
                this.bDB = k(intent);
                if (!StringUtils.isNull(this.bDB)) {
                    intent.putExtra("name", this.bDB);
                }
            }
        } else {
            this.bvA = System.currentTimeMillis();
        }
        this.Om = System.currentTimeMillis();
        this.azc = this.Om - this.bvA;
        if (!de(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.Om;
            return;
        }
        super.onCreate(bundle);
        this.bDX = new com.baidu.tieba.frs.f.a(this);
        this.bDX.a(this.bEm);
        this.bDX.init();
        if (getIntent() != null) {
            this.bDX.d(getIntent().getExtras());
        } else if (bundle != null) {
            this.bDX.d(bundle);
        } else {
            this.bDX.d(null);
        }
        VY().B(3, true);
        this.bDw = new com.baidu.tieba.frs.entelechy.d();
        this.bEi = this.bDw.XT();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(u.h.frs_activity, (ViewGroup) null);
        this.bEa = new com.baidu.tieba.frs.j.y(this, this.bDw.XS());
        this.bDZ = new com.baidu.tieba.frs.j.aa(this);
        this.bEa.a(getPageContext().getPageActivity(), inflate, this.bDZ.aaT().getView());
        this.bDY = new com.baidu.tieba.frs.j.p(this, this.bDw);
        this.bEc = this.bDw.N(this);
        this.bDK = new bq(this, this.bEy, this.bDw);
        this.bDY.a(this.bDK.Ij());
        this.bEc.ae(this.bDK.getRootView());
        if (getIntent() != null) {
            this.bDY.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.bDY.f(bundle);
        } else {
            this.bDY.f((Bundle) null);
        }
        this.bEE = getVoiceManager();
        this.bEE.onCreate(getPageContext());
        initUI();
        initData(bundle);
        this.bDK.setForumName(this.bDB);
        this.bEB.setUniqueId(getUniqueId());
        this.bEB.registerListener();
        addGlobalLayoutListener();
        VF();
        VE();
        VD();
        registerListener(this.LT);
        registerListener(this.mMemListener);
        registerListener(this.bEp);
        registerListener(this.aeF);
        registerListener(this.aPs);
        registerListener(this.bBR);
        registerListener(this.bEq);
        registerListener(this.bEt);
        registerListener(this.bEu);
        registerListener(this.bcm);
        registerListener(this.bEo);
        this.bEv.bn().setSelfListener(true);
        this.bEv.bm().setSelfListener(true);
        this.bEv.setTag(getUniqueId());
        registerListener(this.bEv);
        registerListener(this.bEw);
        this.bEg = new com.baidu.tieba.frs.loadmore.a(this);
        this.bEg.registerListener();
        this.bDG = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.fke);
        this.createTime = System.currentTimeMillis() - this.Om;
        if (this.bDK != null) {
            showLoadingView(this.bDK.getRootView(), true);
            this.bDK.dl(false);
        }
        this.bEf = new Cdo(getActivity(), this.bDK, this.bDY);
        this.bEf.dr(true);
        this.bEe = new com.baidu.tieba.d.c(getActivity());
        this.bEe.a(this.aZA);
        this.bEl = new com.baidu.tieba.frs.j.a(getPageContext(), this.bDX.aag());
        this.bEd = new com.baidu.tieba.frs.headvideo.c(this, this.bDK.getRootView(), this.bDY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VC() {
        com.baidu.tbadk.data.e eVar = new com.baidu.tbadk.data.e();
        if (this.bDM != null && this.bDM.aGX() != null) {
            eVar.setForumId(com.baidu.adp.lib.h.b.c(this.bDM.aGX().getId(), 0L));
            eVar.eX(this.bDM.aGX().getName());
            eVar.eY(this.bDM.aGX().getImage_url());
            eVar.ea(this.bDM.aGX().getSigned() ? 1 : 0);
            eVar.dZ(this.bDM.aGX().getUser_level());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_SET_COMMON_ACCESS_FORUM, eVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
        } else if (this.bDM != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null && this.bDK != null) {
            com.baidu.tbadk.core.data.ag agVar = new com.baidu.tbadk.core.data.ag();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(getMyPostResIdl.data.thread_info.author);
            a(metaData, getMyPostResIdl.data.user_info, getMyPostResIdl.data.thread_info.twzhibo_info);
            metaData.setPortrait(TbadkCoreApplication.getCurrentPortrait());
            String userId = metaData.getUserId();
            if (userId != null && !userId.equals("0")) {
                hashMap.put(metaData.getUserId(), metaData);
            }
            agVar.setUserMap(hashMap);
            agVar.a(getMyPostResIdl.data.thread_info);
            this.bDX.a(agVar);
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bEg.a(true, this.bDM.getThreadList());
            if (a2 != null) {
                this.bDM.aB(a2);
                this.bDM.bek();
                this.bDK.a(a2, this.mPn, this.bDM, this.bEh);
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

    private void VD() {
        com.baidu.tbadk.task.b a2 = com.baidu.tieba.tbadkCore.a.a.a(309360, ResponseIncrForumAccessCountSocketMessage.class, false, false);
        a2.setResponsedClass(ResponseIncrForumAccessCountSocketMessage.class);
        a2.j(true);
        a2.k(false);
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

    private void VE() {
        com.baidu.tbadk.task.b a2 = com.baidu.tieba.tbadkCore.a.a.a(309365, ResponseSetCommForumStateSocketMessage.class, false, false);
        a2.setResponsedClass(ResponseSetCommForumStateSocketMessage.class);
        a2.j(true);
        a2.k(false);
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

    private void VF() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MY_POST, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_MY_POST + "?cmd=303111");
        tbHttpMessageTask.setResponsedClass(GetMyPostHttpResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(303111);
        bVar.setResponsedClass(GetMyPostSocketResponseMessage.class);
        bVar.j(true);
        bVar.k(false);
        bVar.a(SocketMessageTask.DupLicateMode.NONE);
        messageManager.registerTask(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.bEE = getVoiceManager();
        this.bEE.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bEF);
        if (bundle != null) {
            this.bDB = bundle.getString("name");
            this.aaf = bundle.getString("from");
            this.mFlag = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bDB = intent.getStringExtra("name");
                this.aaf = intent.getStringExtra("from");
                this.mFlag = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.aaf) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aaf)) {
            setSwipeBackEnabled(false);
        }
        this.bDN = new cx(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            VG();
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.bEF);
        }
        this.bDY.f(bundle);
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

    public void VG() {
        if (this.bDN != null && this.bDK != null) {
            if (FrsActivityStatic.bEX || FrsActivityStatic.bEY) {
                this.bDN.aN(com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgReplyme());
                this.bDN.aM(com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgAtme());
                this.bDN.aP(com.baidu.tbadk.coreExtra.messageCenter.a.xn().xu());
                this.bDN.aO(com.baidu.tbadk.coreExtra.messageCenter.a.xn().getMsgChat());
                this.bDK.a(this.bDN);
                this.bDZ.a(this.bDN);
            }
        }
    }

    private boolean de(boolean z) {
        if (z && com.baidu.tieba.frs.utils.a.H(TbadkCoreApplication.m10getInst().getApplicationContext(), getClass().getName())) {
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
        com.baidu.tieba.card.bw.Lf().cm(false);
        if (this.bDM != null && this.bDM.aGX() != null) {
            dh.Xq().aR(com.baidu.adp.lib.h.b.c(this.bDM.aGX().getId(), 0L));
        }
        if (this.bDK != null) {
            this.bDK.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.bDU != null) {
                this.bDU.onDestroy();
            }
            this.bDK.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.bDX.onActivityDestroy();
        this.bDY.onActivityDestroy();
        this.bEE = getVoiceManager();
        this.bEE.onDestory(getPageContext());
        if (this.bDV != null) {
            this.bDV.cancel(true);
            this.bDV = null;
        }
        if (this.bDX != null) {
            this.bDX.Vk();
        }
        if (this.bDZ != null) {
            this.bDZ.destroy();
        }
        if (this.bEf != null) {
            this.bEf.Xz();
        }
        if (this.bEk != null) {
            this.bEk.destory();
        }
        if (this.bEl != null) {
            this.bEl.destory();
        }
        if (this.bEd != null) {
            this.bEd.onDestroy();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.bDB);
        bundle.putString("from", this.aaf);
        this.bDX.onSaveInstanceState(bundle);
        this.bEE = getVoiceManager();
        if (this.bEE != null) {
            this.bEE.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.be qb;
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    hj(0);
                    return;
                case 11002:
                    this.bDY.kS();
                    return;
                case 11011:
                    e(this.bDL);
                    return;
                case 11012:
                    f(this.bDO);
                    return;
                case 11014:
                    this.bDY.aaQ();
                    return;
                case 11016:
                    this.bDK.WE();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    this.bDY.VX();
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
                    this.bDK.WN().notifyDataSetChanged();
                    if (this.bDY != null) {
                        this.bDY.XQ();
                    }
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (qb = this.bDM.qb(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            qb.bJ(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            qb.rd();
                            bV(6);
                            return;
                        } else if (intExtra == 0) {
                            this.bDM.w(qb);
                            this.bDK.WF();
                            if (com.baidu.tieba.tbadkCore.d.bdv() != null) {
                                com.baidu.tieba.tbadkCore.d.bdv().N(this.bDB, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    VO();
                    return;
                case 23003:
                    if (intent != null && this.bDM != null) {
                        cp.a(this, this.bDM, intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    cp.a(this, this.bDM, intent);
                    return;
                case 23013:
                    VP();
                    return;
                case 23019:
                    VQ();
                    return;
                case 24002:
                    if (intent != null) {
                        int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                        int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                        int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                        int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                        if (intExtra2 == com.baidu.adp.lib.h.b.g(this.forumId, 0)) {
                            this.bDY.q(intExtra3, intExtra4, intExtra5);
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
                if (this.bDM.getUserData() != null) {
                    i = this.bDM.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), 0, this.bDM.aGX().getId(), this.bDB, null, null, 0, this.bDM.pc(), 13003, false, false, null, false, false, null, null, this.bDM.aGX().getPrefixData(), i);
                if (dd.Xo().hs(1) != null) {
                    writeActivityConfig.setCategroyId(this.bDX.ZZ());
                }
                boolean Fk = com.baidu.tbadk.plugins.g.Fk();
                if (!this.bDM.getUserData().canPostHi()) {
                    Fk = false;
                }
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.TOGETHERHI_SHOW, Fk);
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.TOGETHERHI_DATA, stringExtra);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostWriteCallBackData postWriteCallBackData) {
        if (this.bDX != null) {
            if (this.bDX.Xi() == 2 || this.bDX.Xi() == 3) {
                int ZZ = this.bDX.ZZ();
                if (dd.Xo().hs(1) == null) {
                    ZZ = 0;
                }
                if (ZZ == 0 && postWriteCallBackData != null) {
                    long c = com.baidu.adp.lib.h.b.c(postWriteCallBackData.getPostId(), 0L);
                    long c2 = com.baidu.adp.lib.h.b.c(postWriteCallBackData.getThreadId(), 0L);
                    long c3 = com.baidu.adp.lib.h.b.c(this.forumId, 0L);
                    if (c != 0 && c2 != 0 && c3 != 0) {
                        com.baidu.adp.lib.h.h.dL().postDelayed(new ah(this, c2, c, c3), 1000L);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bDK != null) {
            this.bDK.WC();
            try {
                if ("OPPO".equals(Build.MANUFACTURER) && this.bDK.Wu() != null) {
                    Method declaredMethod = AbsListView.class.getDeclaredMethod("trackMotionScroll", Integer.TYPE, Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.bDK.getListView(), 500, 10);
                }
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
        this.bEc.a(this.bEn);
        this.bDt = true;
        this.bDW = true;
        if (this.bEd != null) {
            this.bEd.dI(false);
        }
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.bDK.jA();
        } else if (bDy) {
            bDy = false;
            this.bDK.jA();
        } else {
            this.bEE = getVoiceManager();
            this.bEE.onResume(getPageContext());
            this.bDK.dn(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        this.bDK.dm(z);
        this.bEa.dA(z);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.bDB = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.aaf = intent.getStringExtra("from");
            }
            this.bDD = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.bDD) {
                df(intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false));
            }
        }
    }

    private void df(boolean z) {
        this.bDK.jA();
        this.bEa.showContent(z);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aaf)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            } else {
                com.baidu.tbadk.core.d.b.d(getPageContext().getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aaf)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        } else {
            com.baidu.tbadk.core.d.b.d(getPageContext().getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aaf)) {
            finish();
        }
    }

    private void initUI() {
        this.bDK.WN().m(this.bEC);
        this.bDK.WN().n(this.bED);
        if (this.mFlag == 0) {
            this.bDK.setTitle(this.bDB);
        } else {
            this.bDK.setTitle("");
            this.mFlag = 1;
        }
        this.bDY.c(this.bDK.getListView());
        this.bDK.a(this.bEG);
        this.bDK.a(this.bEH);
        this.bDK.setOnScrollListener(this.bEz);
        this.bDK.a(this.bEx);
        this.bDK.g(this.bCV);
        this.bDK.WN().a(this.bEA);
        if (!this.mIsLogin) {
            this.bDK.dm(false);
            this.bEa.dA(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.bDK.onChangeSkinType(i);
        this.bDZ.a(getPageContext(), i);
        this.bDY.a(getPageContext(), i);
        this.bEc.onChangeSkinType(i);
        changeSwipeSkinType(i);
        if (this.bEd != null) {
            this.bEd.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> VH() {
        if (this.bDP == null) {
            this.bDP = FrsCommonImageLayout.o(getPageContext().getPageActivity(), 12);
        }
        return this.bDP;
    }

    @Override // com.baidu.adp.widget.f.b
    public void kf() {
        setSwipeBackEnabled(true);
        this.bEa.dA(true);
    }

    @Override // com.baidu.adp.widget.f.b
    public void kg() {
        setSwipeBackEnabled(false);
        this.bEa.dA(false);
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
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                FrsActivity.this.showToast(u.j.shortcut_has_add);
            } else {
                FrsActivity.this.iZ(this.name);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iZ(String str) {
        Intent J;
        if (str != null && (J = com.baidu.tieba.frs.utils.a.J(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(u.j.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", J);
            BarImageView aaP = this.bDY.aaP();
            if (aaP != null && aaP.getBdImage() != null && aaP.getBdImage().ja() != null) {
                Bitmap ja = aaP.getBdImage().ja();
                Float valueOf = Float.valueOf(getResources().getDisplayMetrics().density);
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.d.eY().a(com.baidu.adp.lib.util.d.eY().resizeBitmap(ja, valueOf.intValue() * 48), valueOf.intValue() * 6));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), u.f.icon));
            }
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    private void hj(int i) {
        if (!this.mIsLogin) {
            if (this.bDM != null && this.bDM.pc() != null) {
                this.bDM.pc().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.bDM != null) {
            if (i == 0) {
                if (!this.bDz) {
                    hk(0);
                    return;
                }
                TiebaStatic.log("c10152");
                hk(4);
                return;
            }
            this.bDK.WE();
        }
    }

    private void hk(int i) {
        int i2 = i == 4 ? 7 : i;
        int i3 = 0;
        if (this.bDM.getUserData() != null) {
            i3 = this.bDM.getUserData().getIsMem();
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), i2, this.bDM.aGX().getId(), this.bDB, null, null, 0, this.bDM.pc(), 13003, false, false, null, false, false, null, null, this.bDM.aGX().getPrefixData(), i3);
        if (dd.Xo().hs(1) != null) {
            writeActivityConfig.setCategroyId(this.bDX.ZZ());
        }
        boolean Fk = com.baidu.tbadk.plugins.g.Fk();
        if (!this.bDM.getUserData().canPostHi()) {
            Fk = false;
        }
        writeActivityConfig.getIntent().putExtra(WriteActivityConfig.TOGETHERHI_SHOW, Fk);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    public void VI() {
        int i = 0;
        if (this.bDM.getUserData() != null) {
            i = this.bDM.getUserData().getIsMem();
        }
        EcommProductListActivityConfig ecommProductListActivityConfig = new EcommProductListActivityConfig(getPageContext().getPageActivity(), 7, this.bDM.aGX().getId(), this.bDB, null, null, 0, this.bDM.pc(), 13003, false, false, null, false, false, null, null, this.bDM.aGX().getPrefixData(), i, "");
        ecommProductListActivityConfig.addEcommAddress(this.bDH);
        if (dd.Xo().hs(1) != null) {
            ecommProductListActivityConfig.setCategroyId(this.bDX.ZZ());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, ecommProductListActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.be beVar) {
        boolean rl = beVar == null ? true : beVar.rl();
        this.bDK.a(new ai(this, beVar));
        this.bDK.a(beVar, rl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tbadk.core.data.be beVar) {
        boolean rl = beVar == null ? true : beVar.rl();
        if (this.mThreadId != null) {
            if (!rl) {
                PbActivityConfig createFromThreadCfg = new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(beVar, this.bDB, null, 18003, true, true, this.bDI);
                createFromThreadCfg.setVideo_source("frs");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                return;
            }
            PbActivityConfig createFromThreadCfg2 = new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(beVar, this.bDB, null, 18003, false, false, this.bDI);
            createFromThreadCfg2.setVideo_source("frs");
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.core.data.be beVar) {
        if (this.mThreadId != null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(beVar, this.bDB, null, 18003, false, false, this.bDI);
            createFromThreadCfg.setVideo_source("frs");
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }

    public void refresh() {
        bV(3);
    }

    public void bV(int i) {
        this.bEr = false;
        this.bDv = false;
        this.bDJ = false;
        VR();
        VY().B(i, true);
    }

    private void VJ() {
        switch (this.mFlag) {
            case 1:
                com.baidu.adp.lib.h.k.dM().f(new aj(this));
                break;
        }
        this.mFlag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VK() {
        VR();
        try {
            if (this.bDM != null) {
                this.bDK.Mb();
                this.bDK.Wt();
                if (this.bEa != null && !this.bEa.isMenuShowing()) {
                    this.bDK.dh(true);
                }
                if (com.baidu.tieba.frs.j.p.h(this.bDM)) {
                    this.bDK.WY();
                }
                this.bDB = this.bDM.aGX().getName();
                this.forumId = this.bDM.aGX().getId();
                this.bDK.setTitle(this.bDB);
                TbadkCoreApplication.m10getInst().setDefaultBubble(this.bDM.getUserData().getBimg_url());
                TbadkCoreApplication.m10getInst().setDefaultBubbleEndTime(this.bDM.getUserData().getBimg_end_time());
                VJ();
                ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bDM.getThreadList();
                if (threadList != null) {
                    this.bDK.a(threadList, this.mPn, this.bDM, this.bDM.getPage().pn());
                    VS();
                    this.bDY.hX(this.mPn);
                    this.bDY.f(this.bDM);
                    this.bEc.a(this.bDK.getListView(), this.bDM, this.bDX.aaj());
                    this.bDK.WF();
                    VL();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void VL() {
        if (this.bDM != null) {
            if (this.bDM.aHg() == 1) {
                this.bDK.WN().setFromCDN(true);
            } else {
                this.bDK.WN().setFromCDN(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.bDt = false;
        this.bDW = false;
        this.bDK.onPause();
        this.bEE = getVoiceManager();
        this.bEE.onPause(getPageContext());
        this.bDK.dn(true);
        if (this.bEl != null) {
            this.bEl.aas();
        }
        if (this.bEd != null) {
            this.bEd.dI(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Object d;
        super.onStop();
        com.baidu.tieba.card.bw.Lf().cm(false);
        if (this.bDM != null && this.bDM.aGX() != null) {
            com.baidu.tbadk.distribute.a.AU().b(getPageContext().getPageActivity(), "frs", this.bDM.aGX().getId(), 0L);
        }
        this.bEE = getVoiceManager();
        if (this.bEE != null) {
            this.bEE.onStop(getPageContext());
        }
        BdListView listView = getListView();
        if (listView != null && (d = com.baidu.adp.lib.a.a.a.d(listView, "mRecycler")) != null) {
            com.baidu.adp.lib.a.a.a.a("clear", d, d.getClass());
        }
        this.bDY.onActivityStop();
        com.baidu.tbadk.util.s.FL();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.bDC) {
            if (i == 4) {
                if (this.bEa.isMenuShowing()) {
                    this.bEa.dB(true);
                    if (this.bDZ.aaT().XI()) {
                        this.bDZ.aaT().dv(false);
                        refresh();
                        return true;
                    }
                    return true;
                } else if (this.bDK.WB()) {
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
            if (!com.baidu.adp.lib.util.i.fe()) {
                showToast(u.j.neterror);
            } else if (bVar.om()) {
                com.baidu.tbadk.core.util.bi.us().a(getPageContext(), new String[]{bVar.MH}, true);
            } else if (bVar.ol()) {
                if (com.baidu.adp.lib.util.i.fq() && !com.baidu.adp.lib.util.i.fr()) {
                    trim = getPageContext().getString(u.j.frs_network_tips);
                } else if (TextUtils.isEmpty(bVar.MU.Nf.trim())) {
                    trim = getPageContext().getString(u.j.confirm_download_app);
                } else {
                    trim = bVar.MU.Nf.trim();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cz(trim);
                aVar.a(u.j.alert_yes_button, new al(this, bVar, z, i));
                aVar.b(u.j.alert_no_button, new am(this));
                aVar.b(getPageContext()).rS();
            }
        }
    }

    public boolean d(com.baidu.tbadk.core.data.b bVar, int i) {
        if (bVar == null) {
            return false;
        }
        if (!bVar.ok()) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), u.j.pb_app_error);
            return false;
        } else if (!com.baidu.tieba.tbadkCore.al.s(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), u.j.write_external_storage_permission_denied_fun_disable);
            return false;
        } else {
            boolean a2 = com.baidu.tieba.tbadkCore.al.a(getPageContext().getPageActivity(), bVar, i);
            if (a2) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", bVar.MK);
            }
            return a2;
        }
    }

    public boolean VM() {
        if (this.bEb == null) {
            return false;
        }
        return this.bEb.isShowing();
    }

    public void VN() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
        this.bDV = new a(this.bDB);
        this.bDV.setSelfExecute(true);
        this.bDV.execute(new String[0]);
    }

    public void VO() {
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.bDM.aGX().getId(), true, true, true);
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.AU().a(getPageContext().getPageActivity(), bVar, str, "frs", this.bDM.aGX().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.AU().a(bVar, this.forumId, 0L, "FRS", str, this.mPn);
    }

    public int getPn() {
        return this.mPn;
    }

    public void VP() {
        if (checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10177").ab("fid", this.forumId));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(getPageContext().getPageActivity(), String.valueOf(getForumId()), false, 0)));
        }
    }

    public void VQ() {
        if (checkUpIsLogin() && this.bDA != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(getPageContext().getPageActivity()).createConfig(String.valueOf(getForumId()), this.bDA.getTid(), 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hl(int i) {
        ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bDM.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.be) {
                    com.baidu.tbadk.core.data.be beVar = (com.baidu.tbadk.core.data.be) next;
                    if (beVar == this.bDs) {
                        c(beVar, i);
                        this.bDs = null;
                        break;
                    } else if (beVar.getId() != null && beVar.getId().equals(this.bDu)) {
                        c(beVar, i);
                        this.bDu = null;
                        break;
                    }
                }
            }
            this.bDK.WN().a(threadList, this.bDM);
            this.bDK.WN().notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tbadk.core.data.be beVar, int i) {
        if (i == 1) {
            PraiseData qp = beVar.qp();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (qp == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    beVar.a(praiseData);
                    return;
                }
                beVar.qp().getUser().add(0, metaData);
                beVar.qp().setNum(beVar.qp().getNum() + 1);
                beVar.qp().setIsLike(i);
            }
        } else if (beVar.qp() != null) {
            beVar.qp().setIsLike(i);
            beVar.qp().setNum(beVar.qp().getNum() - 1);
            ArrayList<MetaData> user = beVar.qp().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        beVar.qp().getUser().remove(next);
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
            if (this.bEk == null) {
                this.bEk = new com.baidu.tbadk.e.a(getPageContext());
            }
            this.bEk.ap(updateAttentionMessage.getData().toUid, getForumId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.tbadk.core.data.be beVar;
        ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bDM.getThreadList();
        if (threadList != null && updateAttentionMessage != null && updateAttentionMessage.getData() != null) {
            MetaData metaData = new MetaData();
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            MetaData metaData2 = metaData;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.be) && (beVar = (com.baidu.tbadk.core.data.be) next) != null && beVar.getAuthor() != null && beVar.getAuthor().getUserId() != null && beVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid) && !beVar.getAuthor().equals(metaData2)) {
                    a(beVar, updateAttentionMessage);
                    metaData2 = beVar.getAuthor();
                }
            }
        }
    }

    private void a(com.baidu.tbadk.core.data.be beVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        int i2;
        if (beVar != null && beVar.getAuthor() != null && beVar.getAuthor().getUserId() != null && beVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = beVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
                i2 = 1;
            } else {
                i = fansNum - 1;
                i2 = 0;
            }
            beVar.getAuthor().setFansNum(i);
            if (beVar.getAuthor().getGodUserData() != null) {
                beVar.getAuthor().getGodUserData().setFollowed(i2);
                beVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bEE == null) {
            this.bEE = VoiceManager.instance();
        }
        return this.bEE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: LN */
    public BdListView getListView() {
        if (this.bDK == null) {
            return null;
        }
        return this.bDK.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void VR() {
        this.bEE = getVoiceManager();
        this.bEE.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vA() {
        if (this.bDK == null) {
            return 0;
        }
        return this.bDK.WJ();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> vB() {
        if (this.aeH == null) {
            this.aeH = UserIconBox.e(getPageContext().getPageActivity(), 8);
        }
        return this.aeH;
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
            if (this.bDN != null) {
                this.bDN.aN(msgReplyme);
                this.bDN.aM(msgAtme);
                this.bDN.aQ(msgOfficialMerge);
                this.bDN.aO(msgChat);
                this.bDN.aP(msgStrangerChat);
                this.bDK.a(this.bDN);
                this.bDZ.a(this.bDN);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.bDM != null && this.bDK != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
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
                this.bDK.WC();
            }
        }
    }

    private void VS() {
        HashMap<Integer, com.baidu.tbadk.core.data.be> Yl;
        if (this.bDK != null && this.bDK.WN() != null && (Yl = this.bDK.WN().Yl()) != null) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.be> entry : Yl.entrySet()) {
                com.baidu.tbadk.core.data.be value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.b)) {
                    arrayList.add((com.baidu.tbadk.core.data.b) value);
                }
            }
            com.baidu.tbadk.download.b.Ba().o(arrayList);
        }
    }

    public void VT() {
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

        /* JADX DEBUG: Multi-variable search result rejected for r2v41, resolved type: com.baidu.tieba.frs.FrsActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
            PhotoLiveActivityConfig oa;
            PbActivityConfig createFromThreadCfg;
            if (bdUniqueId != null) {
                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Mw.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Mx.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.My.getId()) {
                    if (vVar == null || !(vVar instanceof com.baidu.tbadk.core.data.b)) {
                        return;
                    }
                    FrsActivity.this.a((com.baidu.tbadk.core.data.b) vVar, i, view.findViewById(u.g.frs_app_download), (AppDownloadView) view.findViewById(u.g.frs_app_download_view));
                } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.ab.fjp.getId()) {
                    if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Mz.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.MA.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.MB.getId()) {
                        if (vVar != null && (vVar instanceof com.baidu.tbadk.core.data.b)) {
                            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) vVar;
                            if (!bVar.ol()) {
                                if (!bVar.om()) {
                                    return;
                                }
                                FrsActivity.this.b(bVar);
                                return;
                            }
                            FrsActivity.this.a(bVar, i, view.findViewById(u.g.frs_app_download), (AppDownloadView) view.findViewById(u.g.frs_app_download_view));
                        }
                    } else if (vVar != null && (vVar instanceof com.baidu.tbadk.core.data.be)) {
                        com.baidu.tbadk.core.data.be beVar = (com.baidu.tbadk.core.data.be) vVar;
                        if (beVar.rf() == null || beVar.rf().getGroup_id() == 0 || FrsActivity.this.checkUpIsLogin()) {
                            if ((beVar.qZ() != 1 && beVar.qZ() != 2) || FrsActivity.this.checkUpIsLogin()) {
                                if (beVar.qI() != null) {
                                    if (FrsActivity.this.checkUpIsLogin()) {
                                        String postUrl = beVar.qI().getPostUrl();
                                        if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.fH()) {
                                            com.baidu.tbadk.browser.f.v(FrsActivity.this.getActivity(), postUrl);
                                        }
                                    }
                                } else if (beVar.rr() != null) {
                                    com.baidu.tbadk.core.data.m rr = beVar.rr();
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsActivity.this.getPageContext().getPageActivity(), rr.getCartoonId(), rr.getChapterId(), 2)));
                                } else if (beVar.getThreadType() == 47 && beVar.qt() == 1 && !com.baidu.tbadk.core.util.ba.isEmpty(beVar.qC())) {
                                    com.baidu.tbadk.browser.f.u(FrsActivity.this.getPageContext().getPageActivity(), beVar.qC());
                                } else {
                                    com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m10getInst().getReadThreadHistory();
                                    if (readThreadHistory != null && !readThreadHistory.qv(beVar.getId())) {
                                        readThreadHistory.qu(beVar.getId());
                                    }
                                    boolean z = false;
                                    String qC = beVar.qC();
                                    if (qC != null && !qC.equals("")) {
                                        z = true;
                                        new Thread(new at(this, qC)).start();
                                    }
                                    String tid = beVar.getTid();
                                    if (tid == null) {
                                        tid = "";
                                    }
                                    if (beVar.qt() == 2 && !tid.startsWith("pb:")) {
                                        com.baidu.tbadk.core.util.bi us = com.baidu.tbadk.core.util.bi.us();
                                        TbPageContext<?> pageContext = FrsActivity.this.getPageContext();
                                        String[] strArr = new String[3];
                                        strArr[0] = tid;
                                        strArr[1] = "";
                                        us.c(pageContext, strArr);
                                        return;
                                    }
                                    boolean z2 = false;
                                    if (beVar instanceof com.baidu.tbadk.core.data.v) {
                                        z2 = true;
                                        TiebaStatic.log("c10769");
                                    }
                                    if (beVar.getThreadType() == 33 || (beVar instanceof com.baidu.tbadk.core.data.ap)) {
                                        if (!z2) {
                                            String str = beVar.getThreadType() == 33 ? "c10245" : "c10180";
                                            if (FrsActivity.this.bDX.aab() == 5) {
                                                str = "c10387";
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ay(str).ab("fid", FrsActivity.this.forumId));
                                        }
                                        if (beVar.qQ() > 0 && com.baidu.tieba.tbadkCore.util.t.bgD()) {
                                            oa = new PhotoLiveActivityConfig.a(FrsActivity.this.getPageContext().getPageActivity(), beVar.getTid()).cj("from_frs").bs(18003).ch(String.valueOf(beVar.qQ())).oa();
                                        } else {
                                            oa = new PhotoLiveActivityConfig.a(FrsActivity.this.getPageContext().getPageActivity(), beVar.getTid()).cj("from_frs").bs(18003).oa();
                                        }
                                        FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, oa));
                                        if (FrsActivity.this.bDM != null && FrsActivity.this.bDM.aGX() != null) {
                                            com.baidu.tieba.frs.h.a aVar = new com.baidu.tieba.frs.h.a();
                                            aVar.bRX = FrsActivity.this.bDM.fig == 1;
                                            aVar.bRZ = FrsActivity.this.bDM.aGX().getId();
                                            aVar.bRY = FrsActivity.this.VY().Xi();
                                            com.baidu.tieba.frs.h.b.aam().a(aVar, beVar, 1);
                                            return;
                                        }
                                        return;
                                    }
                                    if (tid.startsWith("pb:")) {
                                        beVar.setId(tid.substring(3));
                                    }
                                    if (!z2 && FrsActivity.this.bDX.aab() == 2) {
                                        com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c10077");
                                        ayVar.s("obj_source", FrsActivity.this.bDX.aab());
                                        ayVar.ab("tid", beVar.getId());
                                        ayVar.ab("fid", FrsActivity.this.getForumId());
                                        TiebaStatic.log(ayVar);
                                    }
                                    if (bdUniqueId.getId() == com.baidu.tbadk.core.data.be.RF.getId() && beVar.qX() == 2 && beVar.qh() != null) {
                                        String ow = beVar.qh().ow();
                                        if (StringUtils.isNull(ow)) {
                                            ow = beVar.qh().getTaskId();
                                        }
                                        com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", beVar.qh().getForumId(), beVar.qh().getForumName(), beVar.qh().getThreadId(), "tieba.baidu.com/p/" + beVar.qh().getThreadId(), ow);
                                        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
                                            FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(FrsActivity.this.getPageContext().getPageActivity()).createNormalCfg(beVar.qh().getThreadId(), beVar.qh().getTaskId(), beVar.qh().getForumId(), beVar.qh().getForumName(), beVar.qt(), beVar.qu())));
                                            return;
                                        }
                                    }
                                    com.baidu.tbadk.core.util.ay ab = new com.baidu.tbadk.core.util.ay("c10806").s("obj_locate", 3).ab("tid", beVar.getId());
                                    if (beVar.getAuthor() != null && beVar.getAuthor().getGodInfo() != null) {
                                        TiebaStatic.log(ab);
                                    }
                                    if (FrsActivity.this.bDM != null && FrsActivity.this.bDM.aGX() != null) {
                                        com.baidu.tieba.frs.h.a aVar2 = new com.baidu.tieba.frs.h.a();
                                        aVar2.bRX = FrsActivity.this.bDM.fig == 1;
                                        aVar2.bRZ = FrsActivity.this.bDM.aGX().getId();
                                        aVar2.bRY = FrsActivity.this.VY().Xi();
                                        com.baidu.tieba.frs.h.b.aam().a(aVar2, beVar, 1);
                                    }
                                    if (beVar.qQ() > 0 && com.baidu.tieba.tbadkCore.util.t.bgD()) {
                                        createFromThreadCfg = new PbActivityConfig(FrsActivity.this.getPageContext().getPageActivity()).createHistoryCfg(beVar.getTid(), String.valueOf(beVar.qQ()), false, true, null);
                                    } else {
                                        createFromThreadCfg = new PbActivityConfig(FrsActivity.this.getPageContext().getPageActivity()).createFromThreadCfg(beVar, FrsActivity.this.bDB, null, 18003, true, false, z);
                                    }
                                    if (i == 4) {
                                        createFromThreadCfg.setVideo_source("floor5");
                                    } else {
                                        createFromThreadCfg.setVideo_source("frs");
                                    }
                                    FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
                                    if (beVar.RO != null) {
                                        com.baidu.tbadk.core.util.ay ayVar2 = new com.baidu.tbadk.core.util.ay("c11430");
                                        ayVar2.ab("tid", beVar.getTid());
                                        ayVar2.ab("obj_id", new StringBuilder(String.valueOf(beVar.RO.productId)).toString());
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
            DownloadData downloadData = new DownloadData(bVar.MK);
            downloadData.setUrl(bVar.MI);
            downloadData.setName(bVar.MF);
            downloadData.setPosition(i);
            downloadData.setNotifyId(com.baidu.adp.lib.h.b.g(bVar.ME, 0));
            switch (AppDownloadView.b(downloadData)) {
                case 3:
                    com.baidu.tieba.frs.utils.a.G(getPageContext().getPageActivity(), bVar.MK);
                    break;
                case 6:
                case 7:
                    if (com.baidu.adp.lib.util.i.fq() && !com.baidu.adp.lib.util.i.fr()) {
                        a(bVar, i, true);
                        break;
                    } else if (bVar.om()) {
                        com.baidu.tbadk.core.util.bi.us().a(getPageContext(), new String[]{bVar.MH}, true);
                        break;
                    } else if (bVar.ol() && d(bVar, i)) {
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
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", bVar.MK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.b bVar) {
        if (bVar != null) {
            a(bVar, true, this.mPn);
            com.baidu.tbadk.core.util.bi.us().a(getPageContext(), new String[]{bVar.MH}, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.k.fH()) {
            hideNetRefreshView(this.bDK.getRootView());
            showLoadingView(this.bDK.getRootView(), true);
            this.bDK.dl(false);
            this.bDK.jA();
        }
    }

    public com.baidu.tieba.tbadkCore.p VU() {
        return this.bDM;
    }

    public boolean VV() {
        return this.bDK.VV();
    }

    public void VW() {
        FrsActivityStatic.bEX = false;
        FrsActivityStatic.bEY = false;
        VG();
    }

    public void VX() {
        this.bDY.VX();
    }

    public com.baidu.tieba.frs.f.a VY() {
        return this.bDX;
    }

    public bq VZ() {
        return this.bDK;
    }

    public void ja(String str) {
        this.bDB = str;
    }

    public void setFrom(String str) {
        this.aaf = str;
    }

    public String getFrom() {
        return this.aaf;
    }

    public void setFlag(int i) {
        this.mFlag = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    public com.baidu.tieba.frs.j.y Wa() {
        return this.bEa;
    }

    public com.baidu.tieba.frs.ecomm.a Wb() {
        if (this.bEj == null) {
            this.bEj = new com.baidu.tieba.frs.ecomm.a(this);
            this.bEj.a(new an(this));
        }
        return this.bEj;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jC() {
        if (!com.baidu.adp.lib.util.k.fH()) {
            this.bDK.WT();
        } else if (this.bDX.aab() == 1) {
            Wc();
            Wd();
        } else if (this.bDX.hasMore()) {
            Wd();
        }
    }

    public void jb(String str) {
        Wc();
        showToast(str);
    }

    public void L(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        Wc();
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bEg.a(false, arrayList, this.bDG);
            if (a2 != null) {
                this.bDM.aB(a2);
                this.bDK.a(a2, this.mPn, this.bDM, 0);
            }
            if (VY() != null) {
                com.baidu.tieba.frs.h.b.a(this.bDM, VY().Xi(), 2);
            }
        }
    }

    private void Wc() {
        if (this.bEh == 0 && !this.bEg.ax(this.bDM.bdG())) {
            if (this.bDM.getThreadList() == null || this.bDM.getThreadList().size() == 0) {
                this.bDK.WT();
                return;
            } else {
                this.bDK.WS();
                return;
            }
        }
        this.bDK.WR();
    }

    public void Wd() {
        if (this.bDX.aab() == 1) {
            if (!this.bEg.axe && !this.bDX.DJ()) {
                if (this.bEg.ax(this.bDM.bdG())) {
                    this.bDK.a(this.bEg.Ze(), this.mPn, this.bDM, 0);
                    this.bEg.setSortType(this.bDX.aai());
                    this.bEg.a(com.baidu.adp.lib.h.b.c(this.forumId, 0L), this.bDM.bdG(), this.bDB, this.mPn);
                } else if (this.bEh != 0) {
                    this.bDK.a(this.bEg.Ze(), this.mPn, this.bDM, 0);
                    this.mPn++;
                    this.bDX.hI(this.mPn);
                    this.bEg.bOg = false;
                    this.bEg.bOh = 0;
                }
            }
        } else if (!this.bDX.aae()) {
            this.bDX.LK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.b bVar, boolean z, int i) {
        a(bVar, z ? "area_click" : "btn_click");
        b(bVar, "click");
        com.baidu.tieba.recapp.report.b.aYc().a(com.baidu.tieba.recapp.report.e.a(bVar, "click", i));
    }

    public boolean We() {
        return this.bDZ.aaT().XI();
    }

    public void dg(boolean z) {
        this.bDZ.aaT().dv(z);
    }

    public void Wf() {
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

    public com.baidu.adp.widget.ListView.w Wg() {
        return this.bEG;
    }

    public com.baidu.adp.widget.ListView.x Wh() {
        return this.bEH;
    }

    public com.baidu.tieba.frs.entelechy.b.b Wi() {
        return this.bEi;
    }

    public bq Wj() {
        return this.bDK;
    }

    public void Wk() {
        if (this.bEl != null) {
            this.bEl.aas();
        }
    }

    public void jc(String str) {
        if (this.bdy == null) {
            this.bdy = new com.baidu.tbadk.core.view.b(getPageContext());
        }
        this.bdy.dR(str);
        this.bdy.aE(true);
    }
}
