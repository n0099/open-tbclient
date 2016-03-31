package com.baidu.tieba.frs;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;
import com.baidu.a.a.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
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
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.fs;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class FrsActivity extends BaseActivity<FrsActivity> implements a.InterfaceC0000a, BdListView.e, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c {
    public static String bjW = "speed_icon_show";
    private static final int bjX = (com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds90);
    private static final int bjY = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds300);
    public static boolean bkc = false;
    public static volatile long bku = 0;
    public static volatile long bkv = 0;
    public static volatile int bkw = 0;
    private static boolean isNeedRefreshOnResume = false;
    private com.baidu.adp.lib.f.b<TbImageView> ahC;
    private boolean biT;
    private String biU;
    private com.baidu.tbadk.core.data.as bjZ;
    VoiceManager bja;
    private com.baidu.tieba.frs.mc.a bkB;
    private com.baidu.tieba.frs.c.o bkC;
    private com.baidu.tieba.frs.c.a bkD;
    private com.baidu.tieba.frs.c.l bkE;
    private com.baidu.tieba.frs.view.ac bkF;
    private com.baidu.tieba.frs.loadmore.a bkG;
    private boolean bkd;
    private com.baidu.tbadk.core.data.as bke;
    private com.baidu.tieba.tbadkCore.data.f bkl;
    private ei bkr;
    private com.baidu.adp.lib.f.b<TbImageView> bkt;
    private a bkz;
    private boolean bka = false;
    public boolean bkb = false;
    public String bkf = null;
    public String adH = null;
    public int bkg = 0;
    private int mPn = 1;
    private boolean bkh = false;
    private boolean bki = false;
    private String mThreadId = null;
    private String forumId = null;
    private int bkj = 0;
    private boolean bkk = false;
    private boolean bkm = false;
    private boolean bkn = false;
    private cs bko = null;
    private final com.baidu.tbadk.core.data.as bkp = null;
    private com.baidu.tieba.tbadkCore.o bkq = new com.baidu.tieba.tbadkCore.o();
    private com.baidu.tbadk.core.data.as bks = null;
    private boolean Km = false;
    public long bbg = -1;
    public long aBB = 0;
    public long aBt = 0;
    public long createTime = 0;
    public long Tq = -1;
    private boolean bkx = false;
    public com.baidu.tbadk.performanceLog.e bky = null;
    private boolean bkA = true;
    private int bkH = -1;
    private SparseArray<String> bkI = null;
    private fp bkJ = new com.baidu.tieba.frs.a(this);
    private fo bkK = new l(this);
    private CustomMessageListener ahA = new w(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener bhF = new ah(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
    private CustomMessageListener bkL = new ar(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private CustomMessageListener aOQ = new as(this, CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND);
    public final CustomMessageListener bkM = new at(this, CmdConfigCustom.MSG_NEW);
    private CustomMessageListener bkN = new au(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    private boolean bkO = false;
    public final com.baidu.tieba.tbadkCore.r bkP = new av(this);
    private final CustomMessageListener Rf = new com.baidu.tieba.frs.b(this, CmdConfigCustom.CMD_REFRESH);
    private final CustomMessageListener mMemListener = new com.baidu.tieba.frs.c(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private CustomMessageListener bkQ = new d(this, CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS);
    private CustomMessageListener bkR = new e(this, CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE);
    private CustomMessageListener bkS = new f(this, CmdConfigCustom.CMD_AD_KILLER_SUBMIT_SUCCESS);
    private final com.baidu.adp.framework.listener.a bkT = new g(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    private final s.a bkU = new h(this);
    private final BdListView.g IH = new i(this);
    public final View.OnClickListener bkV = new j(this);
    private final AbsListView.OnScrollListener bjb = new k(this);
    private final bj bkW = new m(this);
    private final com.baidu.tieba.tbadkCore.ae bjd = new com.baidu.tieba.tbadkCore.ae(getPageContext(), new n(this));
    private CustomMessageListener bkX = new o(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private final View.OnClickListener bkY = new p(this);
    private final View.OnClickListener bkZ = new b();
    private final View.OnClickListener bla = new q(this);
    public final AdapterView.OnItemClickListener blb = new r(this);
    private final NoNetworkView.a bit = new s(this);
    private final CustomMessageListener blc = new t(this, 0);
    private com.baidu.adp.widget.ListView.v bld = new c();
    private View.OnClickListener ble = new u(this);
    private View.OnClickListener blf = new v(this);
    private com.baidu.adp.widget.ListView.w blg = new x(this);
    private final SlidingMenu.OnOpenedListener blh = new y(this);
    public final com.baidu.adp.base.g bli = new z(this);
    public final com.baidu.adp.base.g blj = new aa(this);

    public String getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.bkf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.x xVar) {
        if (xVar != null) {
            boolean z = xVar.isLike() == 1;
            if (this.bko != null && this.bkq != null && this.bkq.avu() != null && xVar.getFid() != null) {
                if (xVar.getFid().equals(this.bkq.avu().getId())) {
                    this.bkq.avu().setLike(xVar.isLike());
                    if (!StringUtils.isNULL(xVar.getLevelName())) {
                        this.bkq.avu().setLevelName(xVar.getLevelName());
                    }
                    if (xVar.getUserLevel() >= 0) {
                        this.bkq.avu().setUser_level(xVar.getUserLevel());
                    }
                    if (z) {
                        this.bkD.a(this.bkq, false);
                        this.bkE.cN(true);
                        TbadkCoreApplication.m411getInst().addLikeForum(this.bkf);
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.aRC().J(this.bkf, false);
                    this.bkq.avu().setLike(0);
                    this.bkD.TD();
                    this.bkE.cN(false);
                    TbadkCoreApplication.m411getInst().delLikeForum(this.bkf);
                    return;
                }
                if (xVar.isLike() == 1) {
                    this.bkq.nL(xVar.getFid());
                    this.bkD.d(this.bkq);
                }
                if (this.bkq.avu().getBannerListData() != null) {
                    this.bkq.avu().getBannerListData().setFeedForumLiked(xVar.getFid(), xVar.isLike());
                }
                this.bko.RP();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    public void a(ErrorData errorData) {
        this.bko.cE(false);
        this.bko.cF(false);
        this.bko.cG(false);
        this.bko.RP();
        hideLoadingView(this.bko.getRootView());
        this.bko.RW();
        if (!this.bkn) {
            d.a Th = Rd().Th();
            if (!this.bka) {
                if (Th != null) {
                    if (this.bkB.Ti() != 0) {
                        this.bkB.Tq();
                        this.bko.RP();
                    } else if (Th.emO) {
                        if (340001 == Th.errorCode) {
                            showNetRefreshViewNoClick(this.bko.getRootView(), getPageContext().getResources().getString(t.j.net_error_text, Th.errorMsg, Integer.valueOf(Th.errorCode)), true);
                        } else {
                            showNetRefreshView(this.bko.getRootView(), getPageContext().getResources().getString(t.j.net_error_text, Th.errorMsg, Integer.valueOf(Th.errorCode)), true);
                        }
                    } else if (340001 == Th.errorCode) {
                        showNetRefreshViewNoClick(this.bko.getRootView(), Th.errorMsg, true);
                    } else {
                        showNetRefreshView(this.bko.getRootView(), Th.errorMsg, true);
                    }
                    this.bko.gO(8);
                }
            } else if (Th != null && Th.emO) {
                this.bko.gO(0);
                showToast(getPageContext().getResources().getString(t.j.net_error_text, Th.errorMsg, Integer.valueOf(Th.errorCode)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(int i) {
        fq fqVar = null;
        this.bkD.a(Rd().Tf(), this.bkq);
        this.bkD.hj(i);
        Qn();
        try {
            if (this.bkq != null) {
                this.bko.Mu();
                this.bkf = this.bkq.avu().getName();
                this.forumId = this.bkq.avu().getId();
                this.bko.setTitle(this.bkf);
                this.bko.a(null, 1, this.bkq, 0);
                this.bkD.hl(1);
                this.bko.RS();
                if (this.bkq.avC() == 1) {
                    this.bko.Sb().setFromCDN(true);
                } else {
                    this.bko.Sb().setFromCDN(false);
                }
                com.baidu.tieba.frs.tab.h a2 = a(this.bkD.TS(), this.bkq.aRY());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    fqVar = new fq();
                    fqVar.brs = a2.url;
                    fqVar.stType = a2.name;
                }
                this.bkB.a(this.bkq.aRY(), 0, fqVar);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private com.baidu.tieba.frs.tab.h a(TabData tabData, int i) {
        if (i < 0 || tabData == null || tabData.size() <= 0) {
            return null;
        }
        Iterator it = tabData.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.h hVar = (com.baidu.tieba.frs.tab.h) it.next();
            if (hVar != null && hVar.btZ == i) {
                return hVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.m mVar) {
        boolean z;
        int aRY;
        if (!this.bkO && mVar != null) {
            try {
                this.bkq.d(mVar);
                if (this.bkq.avC() == 1) {
                    this.bko.Sb().setFromCDN(true);
                } else {
                    this.bko.Sb().setFromCDN(false);
                }
                this.bkH = this.bkq.getPage().sq();
                this.bko.a(this.bkq.avu(), this.bkq.getUserData(), 0);
                if (this.bkq.aRP() == null) {
                    z = false;
                } else {
                    z = this.bkq.aRP().size() != 0;
                }
                this.bkD.a(this.bkq.aRE().aSa() == 1, this.bkq.getUserData().getIsMem(), this.bkq.avu().isLike(), z);
                this.bko.Mu();
                this.bkf = this.bkq.avu().getName();
                this.forumId = this.bkq.avu().getId();
                this.bko.setTitle(this.bkf);
                QO();
                this.bkq.aSk();
                this.bkq.aSq();
                if (!Rd().Tg()) {
                    if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        this.bkq.aSp();
                        this.bkq.aSo();
                        this.bkq.aSm();
                    }
                    this.bkq.aSn();
                }
                if (!this.bkq.aSt()) {
                    this.bkq.aSs();
                }
                if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                    this.bkq.aK(getPageContext().getPageActivity());
                    this.bkq.N(getPageContext().getPageActivity(), this.forumId);
                }
                this.bkq.aSj();
                com.baidu.tbadk.core.data.au top_notice_data = this.bkq.avu().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.getTitle() != null) {
                    com.baidu.tbadk.core.data.as asVar = new com.baidu.tbadk.core.data.as();
                    asVar.setTitle(top_notice_data.getTitle());
                    asVar.bW(2);
                    asVar.cu(top_notice_data.uc());
                    asVar.parser_title();
                    this.bkq.k(asVar);
                }
                if (this.bkB.btC && (aRY = mVar.aRY()) != 1) {
                    this.bka = true;
                    gC(aRY);
                    return;
                }
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bkq.getThreadList();
                if (threadList != null) {
                    ArrayList<com.baidu.adp.widget.ListView.u> a2 = this.bkG.a(true, threadList);
                    if (a2 != null) {
                        this.bkq.ao(a2);
                    }
                    this.bko.a(threadList, this.mPn, this.bkq, this.bkq.getPage().sq());
                    QX();
                    this.bkD.hl(this.mPn);
                    this.bkD.d(this.bkq);
                    this.bko.RS();
                }
                this.bkj = this.bkq.To();
                if (this.bkl != null) {
                    this.bkk = true;
                    this.bkl.pn(this.bkj);
                }
                this.bkD.cL(this.bkq.aRG());
                hideLoadingView(this.bko.getRootView());
                this.bko.gO(0);
                this.bko.RW();
                this.bka = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        bjW = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (intent != null) {
            this.bbg = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (intent.getData() != null) {
                Uri data = intent.getData();
                this.bkf = data.getQueryParameter("name");
                this.adH = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.bkf)) {
                    intent.putExtra("name", this.bkf);
                }
                if (!StringUtils.isNull(this.adH)) {
                    intent.putExtra("from", this.adH);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.bkf)) {
                this.bkf = h(intent);
                if (!StringUtils.isNull(this.bkf)) {
                    intent.putExtra("name", this.bkf);
                }
            }
        } else {
            this.bbg = System.currentTimeMillis();
        }
        this.Tq = System.currentTimeMillis();
        this.aBt = this.Tq - this.bbg;
        if (!cB(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.Tq;
            return;
        }
        super.onCreate(bundle);
        this.bkB = new com.baidu.tieba.frs.mc.a(this);
        this.bkB.a(this.bkJ);
        this.bkB.init();
        if (getIntent() != null) {
            this.bkB.c(getIntent().getExtras());
        } else if (bundle != null) {
            this.bkB.c(bundle);
        } else {
            this.bkB.c((Bundle) null);
        }
        Rd().oK();
        setContentView(t.h.frs_activity);
        this.bkC = new com.baidu.tieba.frs.c.o(this);
        this.bkE = new com.baidu.tieba.frs.c.l(this);
        this.bkD = new com.baidu.tieba.frs.c.a(this, this.bkC);
        this.bkC.oJ();
        if (getIntent() != null) {
            this.bkD.g(getIntent().getExtras());
        } else if (bundle != null) {
            this.bkD.g(bundle);
        } else {
            this.bkD.g((Bundle) null);
        }
        this.bja = getVoiceManager();
        this.bja.onCreate(getPageContext());
        pU();
        initData(bundle);
        this.bjd.setUniqueId(getUniqueId());
        this.bjd.registerListener();
        addGlobalLayoutListener();
        QG();
        registerListener(this.Rf);
        registerListener(this.mMemListener);
        registerListener(this.bkM);
        registerListener(this.ahA);
        registerListener(this.aOQ);
        registerListener(this.bhF);
        registerListener(this.bkN);
        registerListener(this.bkQ);
        registerListener(this.bkR);
        registerListener(this.bkX);
        registerListener(this.bkS);
        registerListener(this.bkL);
        this.bkT.eX().setSelfListener(true);
        this.bkT.eW().setSelfListener(true);
        this.bkT.setTag(getUniqueId());
        registerListener(this.bkT);
        this.bkG = new com.baidu.tieba.frs.loadmore.a(this);
        this.bkG.registerListener();
        this.bkl = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.epe);
        this.createTime = System.currentTimeMillis() - this.Tq;
        if (this.bko != null) {
            showLoadingView(this.bko.getRootView(), true);
            this.bko.RX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
        } else if (this.bkq != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null && this.bko != null) {
            com.baidu.tbadk.core.data.aa aaVar = new com.baidu.tbadk.core.data.aa();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(getMyPostResIdl.data.thread_info.author);
            a(metaData, getMyPostResIdl.data.user_info, getMyPostResIdl.data.thread_info.twzhibo_info);
            String userId = metaData.getUserId();
            if (userId != null && !userId.equals("0")) {
                hashMap.put(metaData.getUserId(), metaData);
            }
            aaVar.setUserMap(hashMap);
            aaVar.a(getMyPostResIdl.data.thread_info);
            this.bkB.a(aaVar);
            ArrayList<com.baidu.adp.widget.ListView.u> a2 = this.bkG.a(true, this.bkq.getThreadList());
            if (a2 != null) {
                this.bkq.ao(a2);
                this.bkq.aSj();
                this.bko.a(a2, this.mPn, this.bkq, this.bkH);
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

    private void QG() {
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
        this.bja = getVoiceManager();
        this.bja.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        QI();
        if (bundle != null) {
            this.bkf = bundle.getString("name");
            this.adH = bundle.getString("from");
            this.bkg = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bkf = intent.getStringExtra("name");
                this.adH = intent.getStringExtra("from");
                this.bkg = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.adH) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.adH)) {
            setSwipeBackEnabled(false);
        }
        this.bkr = new ei(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            QH();
            QJ();
        }
        this.bkD.g(bundle);
    }

    private String h(Intent intent) {
        int indexOf;
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (!StringUtils.isNull(dataString) && dataString.startsWith("tbfrs://")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10320").r("obj_locate", 2).r("obj_type", 1));
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (StringUtils.isNull(decode) || (indexOf = decode.indexOf("kw=")) < 0 || (length = indexOf + "kw=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public void QH() {
        if (this.bkr != null && this.bko != null) {
            if (FrsActivityStatic.blC || FrsActivityStatic.blD) {
                this.bkr.aC(com.baidu.tbadk.coreExtra.messageCenter.a.zp().getMsgReplyme());
                this.bkr.aB(com.baidu.tbadk.coreExtra.messageCenter.a.zp().getMsgAtme());
                this.bkr.aE(com.baidu.tbadk.coreExtra.messageCenter.a.zp().zw());
                this.bkr.aD(com.baidu.tbadk.coreExtra.messageCenter.a.zp().getMsgChat());
                this.bko.a(this.bkr);
                this.bkE.a(this.bkr);
            }
        }
    }

    private void QI() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.blc);
    }

    private void QJ() {
        registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.blc);
    }

    private boolean cB(boolean z) {
        if (z && com.baidu.tieba.frs.utils.a.F(getPageContext().getPageActivity(), getClass().getName())) {
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
        if (this.bkq != null && this.bkq.avu() != null) {
            fg.Sv().aG(com.baidu.adp.lib.h.b.c(this.bkq.avu().getId(), 0L));
        }
        if (this.bko != null) {
            this.bko.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.bky != null) {
                this.bky.onDestroy();
            }
            this.bko.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.bkB.onActivityDestroy();
        this.bkC.onActivityDestroy();
        this.bkD.onActivityDestroy();
        this.bja = getVoiceManager();
        this.bja.onDestory(getPageContext());
        if (this.bkz != null) {
            this.bkz.cancel(true);
            this.bkz = null;
        }
        if (this.bkB != null) {
            this.bkB.Qe();
        }
        if (this.bkE != null) {
            this.bkE.destroy();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.bkf);
        bundle.putString("from", this.adH);
        this.bkB.onSaveInstanceState(bundle);
        this.bja = getVoiceManager();
        if (this.bja != null) {
            this.bja.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.as nN;
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    gD(0);
                    return;
                case 11002:
                    this.bkD.oG();
                    return;
                case 11011:
                    d(this.bkp);
                    return;
                case 11012:
                    e(this.bks);
                    return;
                case 11014:
                    this.bkD.TO();
                    return;
                case 11016:
                    this.bko.RR();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    this.bkD.Rc();
                    return;
                case 13003:
                    if (intent != null && !Rd().Tg()) {
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
                    this.bko.Sb().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (nN = this.bkq.nN(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            nN.bX(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            nN.parser_title();
                            ck(6);
                            return;
                        } else if (intExtra == 0) {
                            this.bkq.l(nN);
                            this.bko.RS();
                            if (com.baidu.tieba.tbadkCore.c.aRC() != null) {
                                com.baidu.tieba.tbadkCore.c.aRC().J(this.bkf, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    QU();
                    return;
                case 23003:
                    if (intent != null && this.bkq != null) {
                        a(Rg(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    i(intent);
                    return;
                case 23013:
                    QV();
                    return;
                case 23019:
                    QW();
                    return;
                case 24002:
                    if (intent != null) {
                        int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                        int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                        int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                        int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                        if (intExtra2 == com.baidu.adp.lib.h.b.g(this.forumId, 0)) {
                            this.bkD.q(intExtra3, intExtra4, intExtra5);
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
        int Ti = this.bkB.Ti();
        if (ew.St().gR(1) == null) {
            Ti = 0;
        }
        if (Ti == 0 && postWriteCallBackData != null) {
            long c2 = com.baidu.adp.lib.h.b.c(postWriteCallBackData.getPostId(), 0L);
            long c3 = com.baidu.adp.lib.h.b.c(postWriteCallBackData.getThreadId(), 0L);
            long c4 = com.baidu.adp.lib.h.b.c(this.forumId, 0L);
            if (c2 != 0 && c3 != 0 && c4 != 0) {
                com.baidu.adp.lib.h.h.hx().postDelayed(new ab(this, c3, c2, c4), 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bkE.TW();
        this.bkD.a(this.bkK);
        this.biT = true;
        this.bkA = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.bko.nk();
        } else if (bkc) {
            bkc = false;
            this.bko.nk();
        } else {
            this.bja = getVoiceManager();
            this.bja.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            this.bko.Se();
            this.bkE.TX().setSlidingEnabled(true);
            refresh();
            return;
        }
        this.bko.Sd();
        this.bkE.TX().setSlidingEnabled(false);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.bkf = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.adH = intent.getStringExtra("from");
            }
            this.bki = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.bki) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    QK();
                } else {
                    QL();
                }
            }
        }
    }

    private void QK() {
        this.bko.nk();
        this.bkE.TX().showContent(false);
    }

    private void QL() {
        this.bko.nk();
        this.bkE.TX().showContent(false);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.adH)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            } else {
                com.baidu.tbadk.core.d.b.d(getPageContext().getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.adH)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        } else {
            com.baidu.tbadk.core.d.b.d(getPageContext().getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.adH)) {
            finish();
        }
    }

    private void pU() {
        this.bko.Sb().l(this.bkY);
        this.bko.Sb().m(this.bkZ);
        this.bko.Sb().n(this.bla);
        if (this.bkg == 0) {
            this.bko.setTitle(this.bkf);
        } else {
            this.bko.setTitle("");
            this.bkg = 1;
        }
        this.bkE.TX();
        this.bkD.t(this.bko.Mg());
        this.bko.a(this.bld);
        this.bko.a(this.blg);
        this.bko.o(this.ble);
        this.bko.q(this.blf);
        this.bko.setOnScrollListener(this.bjb);
        this.bko.a(this.IH);
        this.bko.a(this.bkU);
        this.bko.f(this.bit);
        this.bkE.TX().setOnOpenedListener(this.blh);
        this.bko.Sb().a(this.bkW);
        if (!this.mIsLogin) {
            this.bko.Sd();
            this.bkE.TX().setSlidingEnabled(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.bko.onChangeSkinType(i);
        this.bkE.a(getPageContext(), i);
        this.bkD.a(getPageContext(), i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> Qr() {
        if (this.bkt == null) {
            this.bkt = FrsCommonImageLayout.o(getPageContext().getPageActivity(), 12);
        }
        return this.bkt;
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
        /* renamed from: m */
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(com.baidu.tieba.frs.utils.a.G(FrsActivity.this.getPageContext().getPageActivity(), this.name));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                FrsActivity.this.showToast(t.j.shortcut_has_add);
            } else {
                FrsActivity.this.hG(this.name);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hG(String str) {
        Intent H;
        if (str != null && (H = com.baidu.tieba.frs.utils.a.H(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(t.j.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", H);
            BarImageView TN = this.bkD.TN();
            if (TN != null && TN.getBdImage() != null && TN.getBdImage().mK() != null) {
                Bitmap mK = TN.getBdImage().mK();
                Float valueOf = Float.valueOf(getResources().getDisplayMetrics().density);
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.d.iN().a(com.baidu.adp.lib.util.d.iN().resizeBitmap(mK, valueOf.intValue() * 48), valueOf.intValue() * 6));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), t.f.icon));
            }
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gD(int i) {
        if (!this.mIsLogin) {
            if (this.bkq != null && this.bkq.sf() != null) {
                this.bkq.sf().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.bkq != null) {
            if (i == 0) {
                if (!this.bkd) {
                    gE(0);
                    return;
                }
                TiebaStatic.log("c10152");
                gE(4);
                return;
            }
            this.bko.RR();
        }
    }

    private void gE(int i) {
        int i2 = 0;
        if (this.bkq.getUserData() != null) {
            i2 = this.bkq.getUserData().getIsMem();
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), i, this.bkq.avu().getId(), this.bkf, null, null, 0, this.bkq.sf(), 13003, false, false, null, false, false, null, null, this.bkq.avu().getPrefixData(), i2);
        if (ew.St().gR(1) != null) {
            writeActivityConfig.setCategroyId(this.bkB.Ti());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.as asVar) {
        boolean tS = asVar == null ? true : asVar.tS();
        this.bko.a(new ac(this, asVar));
        this.bko.a(asVar, tS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QM() {
        if (!this.mIsLogin) {
            skipToRegisterActivity();
            return;
        }
        boolean z = false;
        String str = "";
        if (this.bkq.avu() != null && this.bkq.avu().getAnchorPower() != null) {
            z = this.bkq.avu().getCanAddPhotoLivePost();
            str = this.bkq.avu().getAnchorPower().can_add_live_post_msg;
        }
        if (z) {
            this.bkd = true;
            gE(4);
            com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), true);
            return;
        }
        hH(str);
    }

    private void hH(String str) {
        JSONObject jSONObject = null;
        if (!StringUtils.isNull(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    jSONObject = jSONArray.optJSONObject(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (jSONObject != null) {
            String optString = jSONObject.optString(AddFriendActivityConfig.MSG);
            if (!StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("tid");
                if (!StringUtils.isNull(optString) && optString.contains("_")) {
                    optString = optString.replace("_", "");
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cC(optString);
                aVar.a(t.j.view, new ad(this, optString2));
                aVar.b(t.j.cancel, new ae(this));
                aVar.b(getPageContext()).up();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QN() {
        if (com.baidu.tbadk.core.util.bl.ad(getPageContext().getPageActivity())) {
            AntiData sf = this.bkq.sf();
            if (sf != null) {
                if (AntiHelper.f(sf) || AntiHelper.g(sf) || AntiHelper.h(sf)) {
                    sf.setBlock_forum_name(this.bkf);
                    sf.setBlock_forum_id(this.bkq.avu().getId());
                    sf.setUser_name(this.bkq.getUserData().getUserName());
                    sf.setUser_id(this.bkq.getUserData().getUserId());
                    if (AntiHelper.a(getPageContext().getPageActivity(), sf, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(sf.getPollMessage())) {
                    com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), sf.getPollMessage());
                    return;
                }
            }
            PostPrefixData postPrefixData = null;
            if (this.bkq.avu() != null) {
                postPrefixData = this.bkq.avu().getPrefixData();
            }
            int i = 0;
            if (this.bkq.getUserData() != null) {
                i = this.bkq.getUserData().getIsMem();
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVoteActivityConfig(getPageContext().getPageActivity(), this.bkq.avu().getId(), this.bkf, sf, 13003, postPrefixData, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.as asVar) {
        boolean tS = asVar == null ? true : asVar.tS();
        if (this.mThreadId != null) {
            if (!tS) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(asVar, this.bkf, null, 18003, true, true, this.bkm)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(asVar, this.bkf, null, 18003, false, false, this.bkm)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tbadk.core.data.as asVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(asVar, this.bkf, null, 18003, false, false, this.bkm)));
        }
    }

    public void refresh() {
        ck(3);
    }

    public void ck(int i) {
        this.bkO = false;
        this.bka = false;
        this.bkn = false;
        Qn();
        if (this.bkC != null && this.bkC.TY() != null) {
            this.bkC.TY().a(this.bkB.Tk(), this.bkB.Tl(), this.bkB.Tm());
        }
        Rd().j(i, true);
    }

    private void QO() {
        switch (this.bkg) {
            case 1:
                com.baidu.adp.lib.h.k.hy().c(new af(this));
                break;
        }
        this.bkg = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QP() {
        Qn();
        try {
            if (this.bkq != null) {
                this.bko.Mu();
                this.bkf = this.bkq.avu().getName();
                this.forumId = this.bkq.avu().getId();
                this.bko.setTitle(this.bkf);
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.bkq.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.bkq.getUserData().getBimg_end_time());
                QO();
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bkq.getThreadList();
                if (threadList != null) {
                    this.bko.a(threadList, this.mPn, this.bkq, this.bkq.getPage().sq());
                    QX();
                    this.bkD.hl(this.mPn);
                    this.bkD.d(this.bkq);
                    this.bko.RS();
                    if (this.bkq.avC() == 1) {
                        this.bko.Sb().setFromCDN(true);
                    } else {
                        this.bko.Sb().setFromCDN(false);
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.biT = false;
        this.bkA = false;
        this.bko.onPause();
        this.bja = getVoiceManager();
        this.bja.onPause(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Object c2;
        super.onStop();
        if (this.bkq != null && this.bkq.avu() != null) {
            com.baidu.tbadk.distribute.a.CR().b(getPageContext().getPageActivity(), "frs", this.bkq.avu().getId(), 0L);
        }
        this.bja = getVoiceManager();
        if (this.bja != null) {
            this.bja.onStop(getPageContext());
        }
        BdListView listView = getListView();
        if (listView != null && (c2 = com.baidu.adp.lib.a.a.a.c(listView, "mRecycler")) != null) {
            com.baidu.adp.lib.a.a.a.a("clear", c2, c2.getClass());
        }
        this.bkD.onActivityStop();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.bkh) {
            if (i == 4) {
                if (this.bkE.onBackPressed()) {
                    return true;
                }
                closeActivity();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void a(com.baidu.tbadk.core.data.c cVar, int i, boolean z) {
        String trim;
        if (cVar != null) {
            if (!com.baidu.adp.lib.util.i.iT()) {
                showToast(t.j.neterror);
            } else if (cVar.rm()) {
                com.baidu.tbadk.core.util.bg.wM().a(getPageContext(), new String[]{cVar.Sc}, true);
            } else if (cVar.rl()) {
                if (com.baidu.adp.lib.util.i.jf() && !com.baidu.adp.lib.util.i.jg()) {
                    trim = getPageContext().getString(t.j.frs_network_tips);
                } else if (TextUtils.isEmpty(cVar.Sn.Sx.trim())) {
                    trim = getPageContext().getString(t.j.confirm_download_app);
                } else {
                    trim = cVar.Sn.Sx.trim();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cC(trim);
                aVar.a(t.j.alert_yes_button, new ag(this, cVar, z, i));
                aVar.b(t.j.alert_no_button, new ai(this));
                aVar.b(getPageContext()).up();
            }
        }
    }

    public boolean d(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar == null) {
            return false;
        }
        if (!cVar.rk()) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), t.j.pb_app_error);
            return false;
        } else if (!com.baidu.tieba.tbadkCore.ag.p(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), t.j.write_external_storage_permission_denied_fun_disable);
            return false;
        } else {
            boolean a2 = com.baidu.tieba.tbadkCore.ag.a(getPageContext().getPageActivity(), cVar, i);
            if (a2) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", cVar.Se);
            }
            return a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QQ() {
        boolean z;
        if (this.bko != null) {
            if (this.bkq != null && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) && this.bkq.avu() != null && this.bkq.avu().getAnchorPower() != null && this.bkq.avu().getAnchorPower().can_add_live_post.intValue() != 2) {
                z = true;
            } else {
                z = false;
            }
            boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
            this.bkF = new com.baidu.tieba.frs.view.ac(getPageContext(), this.bko.getRootView(), new aj(this));
            this.bkF.j(z, showXiaoyingTool);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QR() {
        TiebaStatic.log("c10798");
        if (com.baidu.tbadk.core.util.bl.ad(getPageContext().getPageActivity())) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(getPageContext(), getResources().getString(t.j.plugin_video_not_active), getResources().getString(t.j.setup));
                    return;
                }
                AntiData sf = this.bkq.sf();
                if (sf != null && !StringUtils.isNull(sf.getVideo_message())) {
                    com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), sf.getVideo_message());
                    return;
                }
                boolean z = false;
                if (this.bkq != null && this.bkq.getUserData() != null && this.bkq.getUserData().getGodUserData() != null && (this.bkq.getUserData().getGodUserData().getType() == 2 || this.bkq.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (this.bkq != null && this.bkq.avu() != null) {
                    XiaoyingUtil.startXiaoying(getPageContext().getPageActivity(), z, this.bkq.avu().getId(), this.bkq.avu().getName());
                    return;
                }
                return;
            }
            XiaoyingUtil.showGoPluginDetailDialog(getPageContext(), getResources().getString(t.j.plugin_video_install_tips), getResources().getString(t.j.plugin_go_install));
        }
    }

    public boolean QS() {
        if (this.bkF == null) {
            return false;
        }
        return this.bkF.isShowing();
    }

    public void QT() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
        this.bkz = new a(this.bkf);
        this.bkz.setSelfExecute(true);
        this.bkz.execute(new String[0]);
    }

    public void QU() {
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.bkq.avu().getId(), true, true, true);
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.CR().a(getPageContext().getPageActivity(), cVar, str, "frs", this.bkq.avu().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.CR().a(cVar, this.forumId, 0L, "FRS", str, this.mPn);
    }

    public void QV() {
        if (checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10177").ac("fid", this.forumId));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(getPageContext().getPageActivity(), String.valueOf(getForumId()), false, 0)));
        }
    }

    public void QW() {
        if (checkUpIsLogin() && this.bke != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(getPageContext().getPageActivity()).createConfig(String.valueOf(getForumId()), this.bke.getTid(), 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gB(int i) {
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bkq.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.as) {
                    com.baidu.tbadk.core.data.as asVar = (com.baidu.tbadk.core.data.as) next;
                    if (asVar == this.bjZ) {
                        b(asVar, i);
                        this.bjZ = null;
                        break;
                    } else if (asVar.getId() != null && asVar.getId().equals(this.biU)) {
                        b(asVar, i);
                        this.biU = null;
                        break;
                    }
                }
            }
            this.bko.Sb().a(threadList, this.bkq);
            this.bko.Sb().notifyDataSetChanged();
        }
    }

    private void b(com.baidu.tbadk.core.data.as asVar, int i) {
        if (i == 1) {
            PraiseData praise = asVar.getPraise();
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
                    asVar.setPraise(praiseData);
                    return;
                }
                asVar.getPraise().getUser().add(0, metaData);
                asVar.getPraise().setNum(asVar.getPraise().getNum() + 1);
                asVar.getPraise().setIsLike(i);
            }
        } else if (asVar.getPraise() != null) {
            asVar.getPraise().setIsLike(i);
            asVar.getPraise().setNum(asVar.getPraise().getNum() - 1);
            ArrayList<MetaData> user = asVar.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        asVar.getPraise().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.tbadk.core.data.as asVar;
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bkq.getThreadList();
        if (threadList != null && updateAttentionMessage != null && updateAttentionMessage.getData() != null) {
            MetaData metaData = new MetaData();
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            MetaData metaData2 = metaData;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.u next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.as) && (asVar = (com.baidu.tbadk.core.data.as) next) != null && asVar.getAuthor() != null && asVar.getAuthor().getUserId() != null && asVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid) && !asVar.getAuthor().equals(metaData2)) {
                    a(asVar, updateAttentionMessage);
                    metaData2 = asVar.getAuthor();
                }
            }
            this.bko.Sb().a(threadList, this.bkq);
            this.bko.Sb().notifyDataSetChanged();
        }
    }

    private void a(com.baidu.tbadk.core.data.as asVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        int i2;
        if (asVar != null && asVar.getAuthor() != null && asVar.getAuthor().getUserId() != null && asVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = asVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
                i2 = 1;
            } else {
                i = fansNum - 1;
                i2 = 0;
            }
            asVar.getAuthor().setFansNum(i);
            if (asVar.getAuthor().getGodUserData() != null) {
                asVar.getAuthor().getGodUserData().setFollowed(i2);
                asVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }

    public void a(fs.a aVar, String str) {
        if (str != null) {
            Rd().aD(aVar.brQ, str);
            this.bkE.TV();
            this.bkf = str;
            if (this.bko != null) {
                this.bko.setTitle(this.bkf);
            }
            Qn();
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        private AppDownloadView blz;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.adp.lib.util.i.iT()) {
                FrsActivity.this.showToast(t.j.neterror);
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            com.baidu.adp.widget.ListView.u aF = FrsActivity.this.bko.Sb().aF(intValue);
            if (aF instanceof com.baidu.tbadk.core.data.c) {
                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aF;
                FrsActivity.this.a(cVar, false, FrsActivity.this.mPn);
                DownloadData downloadData = new DownloadData(cVar.Se);
                downloadData.setUrl(cVar.Sd);
                downloadData.setName(cVar.Sa);
                downloadData.setPosition(intValue);
                downloadData.setNotifyId(com.baidu.adp.lib.h.b.g(cVar.RZ, 0));
                switch (AppDownloadView.b(downloadData)) {
                    case 1:
                    case 5:
                        com.baidu.tbadk.download.b.CX().am(cVar.Sd, cVar.Se);
                        ((TextView) view).setText(t.j.frs_new_style_download_pause);
                        break;
                    case 3:
                        com.baidu.tieba.frs.utils.a.E(FrsActivity.this.getPageContext().getPageActivity(), cVar.Se);
                        break;
                    case 6:
                    case 7:
                        if (com.baidu.adp.lib.util.i.jf() && !com.baidu.adp.lib.util.i.jg()) {
                            FrsActivity.this.a(cVar, intValue, false);
                            break;
                        } else if (FrsActivity.this.d((com.baidu.tbadk.core.data.c) aF, intValue)) {
                            this.blz.setVisibility(0);
                            ((TextView) view).setText(t.j.downloading2);
                            FrsActivity.this.a(cVar, "btn_download");
                            break;
                        }
                        break;
                }
                TiebaStatic.eventStat(FrsActivity.this.getPageContext().getPageActivity(), "frs_tb_btc", "");
            }
        }

        public void b(AppDownloadView appDownloadView) {
            this.blz = appDownloadView;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.bja == null) {
            this.bja = VoiceManager.instance();
        }
        return this.bja;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: Mg */
    public BdListView getListView() {
        if (this.bko == null) {
            return null;
        }
        return this.bko.Mg();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void Qn() {
        this.bja = getVoiceManager();
        this.bja.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int xH() {
        if (this.bko == null) {
            return 0;
        }
        return this.bko.RV();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> xI() {
        if (this.ahC == null) {
            this.ahC = UserIconBox.e(getPageContext().getPageActivity(), 8);
        }
        return this.ahC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            int msgOfficialMerge = newsNotifyMessage.getMsgOfficialMerge();
            int msgStrangerChat = newsNotifyMessage.getMsgStrangerChat();
            if (this.bkr != null) {
                this.bkr.aC(msgReplyme);
                this.bkr.aB(msgAtme);
                this.bkr.aF(msgOfficialMerge);
                this.bkr.aD(msgChat);
                this.bkr.aE(msgStrangerChat);
                this.bko.a(this.bkr);
                this.bkE.a(this.bkr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        bh Sb;
        HashMap<Integer, com.baidu.tbadk.core.data.as> Rm;
        if (this.bkq != null && this.bko != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (Sb = this.bko.Sb()) != null && (Rm = Sb.Rm()) != null && Rm.size() > 0) {
            boolean z = false;
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    Iterator<Map.Entry<Integer, com.baidu.tbadk.core.data.as>> it = Rm.entrySet().iterator();
                    boolean z2 = z;
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        Map.Entry<Integer, com.baidu.tbadk.core.data.as> next = it.next();
                        int intValue = next.getKey().intValue();
                        com.baidu.tbadk.core.data.as value = next.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.c) && TextUtils.equals(((com.baidu.tbadk.core.data.c) value).Se, downloadData.getId())) {
                            if (!(Sb.aF(this.bkq.aSi() + intValue) instanceof com.baidu.tbadk.core.data.c)) {
                                z = z2;
                                break;
                            }
                            int status = downloadData.getStatus();
                            if (status == 3 || status == 0) {
                                z2 = true;
                            }
                        }
                    }
                }
            }
            if (!this.Km || z) {
                this.bko.RP();
            }
        }
    }

    private void QX() {
        HashMap<Integer, com.baidu.tbadk.core.data.as> Rm;
        if (this.bko != null && this.bko.Sb() != null && (Rm = this.bko.Sb().Rm()) != null) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.as> entry : Rm.entrySet()) {
                com.baidu.tbadk.core.data.as value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.c)) {
                    arrayList.add((com.baidu.tbadk.core.data.c) value);
                }
            }
            com.baidu.tbadk.download.b.CX().n(arrayList);
        }
    }

    public void QY() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    /* loaded from: classes.dex */
    class c implements com.baidu.adp.widget.ListView.v {
        c() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v35, resolved type: com.baidu.tieba.frs.FrsActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.v
        public void a(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RS.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RT.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RU.getId()) {
                    if (uVar == null || !(uVar instanceof com.baidu.tbadk.core.data.c)) {
                        return;
                    }
                    FrsActivity.this.a((com.baidu.tbadk.core.data.c) uVar, i, view.findViewById(t.g.frs_app_download), (AppDownloadView) view.findViewById(t.g.frs_app_download_view));
                } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.z.eoi.getId()) {
                    if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RV.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RW.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.RX.getId()) {
                        if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.c)) {
                            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) uVar;
                            if (!cVar.rl()) {
                                if (!cVar.rm()) {
                                    return;
                                }
                                FrsActivity.this.b(cVar);
                                return;
                            }
                            FrsActivity.this.a(cVar, i, view.findViewById(t.g.frs_app_download), (AppDownloadView) view.findViewById(t.g.frs_app_download_view));
                        }
                    } else if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.as)) {
                        com.baidu.tbadk.core.data.as asVar = (com.baidu.tbadk.core.data.as) uVar;
                        if (asVar.getAnchorInfoData() == null || asVar.getAnchorInfoData().getGroup_id() == 0 || FrsActivity.this.checkUpIsLogin()) {
                            if ((asVar.tI() != 1 && asVar.tI() != 2) || FrsActivity.this.checkUpIsLogin()) {
                                if (asVar.ty() != null) {
                                    if (FrsActivity.this.checkUpIsLogin()) {
                                        String ro = asVar.ty().ro();
                                        if (!StringUtils.isNull(ro) && com.baidu.adp.lib.util.k.jw()) {
                                            com.baidu.tbadk.browser.f.t(FrsActivity.this.getActivity(), ro);
                                        }
                                    }
                                } else if (asVar.tW() != null) {
                                    com.baidu.tbadk.core.data.k tW = asVar.tW();
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsActivity.this.getPageContext().getPageActivity(), tW.getCartoonId(), tW.getChapterId(), 2)));
                                } else {
                                    com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                                    if (readThreadHistory != null && !readThreadHistory.oh(asVar.getId())) {
                                        readThreadHistory.og(asVar.getId());
                                    }
                                    boolean z = false;
                                    String tt = asVar.tt();
                                    if (tt != null && !tt.equals("")) {
                                        z = true;
                                        new Thread(new aw(this, tt)).start();
                                    }
                                    boolean z2 = z;
                                    String tid = asVar.getTid();
                                    if (tid == null) {
                                        tid = "";
                                    }
                                    if (asVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                                        com.baidu.tbadk.core.util.bg wM = com.baidu.tbadk.core.util.bg.wM();
                                        TbPageContext<?> pageContext = FrsActivity.this.getPageContext();
                                        String[] strArr = new String[3];
                                        strArr[0] = tid;
                                        strArr[1] = "";
                                        wM.c(pageContext, strArr);
                                        return;
                                    }
                                    boolean z3 = false;
                                    if (asVar instanceof com.baidu.tbadk.core.data.r) {
                                        z3 = true;
                                        TiebaStatic.log("c10769");
                                    }
                                    if (asVar.getThreadType() == 33 || (asVar instanceof com.baidu.tbadk.core.data.af)) {
                                        if (!z3) {
                                            String str = asVar.getThreadType() == 33 ? "c10245" : "c10180";
                                            if (FrsActivity.this.bkB.Tk() == 5) {
                                                str = "c10387";
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aw(str).ac("fid", FrsActivity.this.forumId));
                                        }
                                        FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(FrsActivity.this.getPageContext().getPageActivity(), asVar.getTid()).cl("from_frs").bC(18003).qT()));
                                        return;
                                    }
                                    if (tid.startsWith("pb:")) {
                                        asVar.setId(tid.substring(3));
                                    }
                                    if (!z3 && FrsActivity.this.bkB.Tk() == 2) {
                                        com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10077");
                                        awVar.r("obj_source", FrsActivity.this.bkB.Tk());
                                        awVar.ac("tid", asVar.getId());
                                        awVar.ac("fid", FrsActivity.this.getForumId());
                                        TiebaStatic.log(awVar);
                                    }
                                    if (bdUniqueId.getId() == com.baidu.tbadk.core.data.as.VN.getId() && asVar.tG() == 2 && asVar.tg() != null) {
                                        String tf = asVar.tg().tf();
                                        if (StringUtils.isNull(tf)) {
                                            tf = asVar.tg().getTaskId();
                                        }
                                        com.baidu.tieba.tbadkCore.d.a.a("frs", null, "CLICK", asVar.tg().getForumId(), asVar.tg().getForumName(), asVar.tg().getThreadId(), null, "tieba.baidu.com/p/" + asVar.tg().getThreadId(), tf);
                                        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
                                            FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(FrsActivity.this.getPageContext().getPageActivity()).createNormalCfg(asVar.tg().getThreadId(), asVar.tg().getTaskId(), asVar.tg().getForumId(), asVar.tg().getForumName())));
                                            return;
                                        }
                                    }
                                    com.baidu.tbadk.core.util.aw ac = new com.baidu.tbadk.core.util.aw("c10806").r("obj_locate", 3).ac("tid", asVar.getId());
                                    if (asVar.getAuthor() != null && asVar.getAuthor().getGodInfo() != null) {
                                        TiebaStatic.log(ac);
                                    }
                                    if (asVar.getType() == com.baidu.tbadk.core.data.as.UX) {
                                        if (asVar.tV()) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10242").ac("fid", String.valueOf(asVar.getFid())).r("obj_type", 2));
                                        } else {
                                            com.baidu.tbadk.core.util.aw awVar2 = new com.baidu.tbadk.core.util.aw("c11100");
                                            awVar2.ac("tid", asVar.getId());
                                            awVar2.ac("fid", FrsActivity.this.forumId);
                                            TiebaStatic.log(awVar2);
                                        }
                                        if (asVar.getAuthor() != null && asVar.getAuthor().getGodUserData() != null && asVar.getAuthor().getGodUserData().getType() == 2) {
                                            TiebaStatic.log(ac);
                                        }
                                    }
                                    FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(FrsActivity.this.getPageContext().getPageActivity()).createFromThreadCfg(asVar, FrsActivity.this.bkf, null, 18003, true, false, z2)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.c cVar, int i, View view, AppDownloadView appDownloadView) {
        if (cVar != null) {
            a(cVar, true, this.mPn);
            DownloadData downloadData = new DownloadData(cVar.Se);
            downloadData.setUrl(cVar.Sd);
            downloadData.setName(cVar.Sa);
            downloadData.setPosition(i);
            downloadData.setNotifyId(com.baidu.adp.lib.h.b.g(cVar.RZ, 0));
            switch (AppDownloadView.b(downloadData)) {
                case 3:
                    com.baidu.tieba.frs.utils.a.E(getPageContext().getPageActivity(), cVar.Se);
                    break;
                case 6:
                case 7:
                    if (com.baidu.adp.lib.util.i.jf() && !com.baidu.adp.lib.util.i.jg()) {
                        a(cVar, i, true);
                        break;
                    } else if (cVar.rm()) {
                        com.baidu.tbadk.core.util.bg.wM().a(getPageContext(), new String[]{cVar.Sc}, true);
                        break;
                    } else if (cVar.rl() && d(cVar, i)) {
                        appDownloadView.setVisibility(0);
                        ((TextView) view).setText(t.j.downloading2);
                        a(cVar, "area_download");
                        break;
                    }
                    break;
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", cVar.Se);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.c cVar) {
        if (cVar != null) {
            a(cVar, true, this.mPn);
            com.baidu.tbadk.core.util.bg.wM().a(getPageContext(), new String[]{cVar.Sc}, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.bko.getRootView());
        showLoadingView(this.bko.getRootView(), true);
        this.bko.RX();
        this.bko.nk();
    }

    public com.baidu.tieba.tbadkCore.o QZ() {
        return this.bkq;
    }

    public boolean Ra() {
        return this.bko.Ra();
    }

    public void Rb() {
        FrsActivityStatic.blC = false;
        FrsActivityStatic.blD = false;
        QH();
    }

    public void Rc() {
        this.bkD.Rc();
    }

    public com.baidu.tieba.frs.mc.a Rd() {
        return this.bkB;
    }

    public void a(cs csVar) {
        this.bko = csVar;
    }

    public void hI(String str) {
        this.bkf = str;
    }

    public void setFrom(String str) {
        this.adH = str;
    }

    public String getFrom() {
        return this.adH;
    }

    public void setFlag(int i) {
        this.bkg = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    public void resetData() {
        this.bka = false;
        this.bkn = false;
        this.bkq = null;
        this.bko.setTitle(this.bkf);
        this.bkE.cN(false);
        this.bkE.setIsManager(false);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nm() {
        if (!com.baidu.adp.lib.util.k.jw()) {
            this.bko.Si();
        } else if (this.bkB.Tk() == 1) {
            Re();
            Qq();
        } else if (this.bkB.hasMore()) {
            Qq();
        }
    }

    public void hJ(String str) {
        Re();
        showToast(str);
    }

    public void B(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.u> a2;
        Re();
        if (arrayList != null && arrayList.size() != 0 && (a2 = this.bkG.a(false, arrayList, this.bkl)) != null) {
            this.bkq.ao(a2);
            this.bko.a(a2, this.mPn, this.bkq, 0);
        }
    }

    private void Re() {
        if (this.bkH == 0 && !this.bkG.ak(this.bkq.aRJ())) {
            if (this.bkq.getThreadList() == null || this.bkq.getThreadList().size() == 0) {
                this.bko.Si();
                return;
            } else {
                this.bko.Sh();
                return;
            }
        }
        this.bko.Sg();
    }

    public void Qq() {
        if (this.bkB.Tk() == 1) {
            if (!this.bkG.azx && !this.bkB.isLoading()) {
                if (this.bkG.ak(this.bkq.aRJ())) {
                    this.bko.a(this.bkG.SK(), this.mPn, this.bkq, 0);
                    this.bkG.a(com.baidu.adp.lib.h.b.c(this.forumId, 0L), this.bkq.aRJ(), this.bkf, this.mPn);
                } else if (this.bkH != 0) {
                    this.bko.a(this.bkG.SK(), this.mPn, this.bkq, 0);
                    this.mPn++;
                    this.bkB.gW(this.mPn);
                    this.bkG.bsm = false;
                    this.bkG.bsn = 0;
                }
            }
        } else if (!this.bkB.Tp()) {
            if (this.bkC.TY() != null) {
                this.bkC.TY().a(this.bkB.Tk(), this.bkB.Tl(), this.bkB.Tm());
            }
            this.bkB.Md();
        }
    }

    public void Rf() {
        String name;
        if (this.bkq != null && this.bkq.avu() != null) {
            if (this.bkq.avu().getName() == null) {
                showToast(getPageContext().getString(t.j.no_forum_data));
                return;
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String str = "http://tieba.baidu.com/f?kw=" + this.bkq.avu().getName();
            Uri parse = this.bkq.avu().getImage_url() == null ? null : Uri.parse(this.bkq.avu().getImage_url());
            String slogan = this.bkq.avu().getSlogan();
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = String.valueOf(name) + getPageContext().getString(t.j.forum);
            fVar.content = slogan;
            fVar.linkUrl = str;
            fVar.amW = true;
            fVar.extData = getForumId();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true);
            shareDialogConfig.addOutsideTextView(t.j.share_tieba_qunzu, t.f.icon_unite_share_qunzu, new ak(this));
            shareDialogConfig.addOutsideTextView(t.j.forum_friend, t.f.icon_unite_share_baf, new al(this));
            shareDialogConfig.setCopyLinkListener(new am(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private ShareFromFrsMsgData Rg() {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(this.bkq.avu().getImage_url());
        shareFromFrsMsgData.setName(this.bkq.avu().getName());
        shareFromFrsMsgData.setMemberNum(this.bkq.avu().getMember_num());
        shareFromFrsMsgData.setPostNum(this.bkq.avu().getPost_num());
        shareFromFrsMsgData.setContent(this.bkq.avu().getSlogan());
        return shareFromFrsMsgData;
    }

    private void i(Intent intent) {
        a(Rg(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromFrsMsgData shareFromFrsMsgData, long j, String str, String str2) {
        if (this.bkq != null && this.bkq.avu() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.t tVar = new com.baidu.tieba.frs.view.t(getPageContext().getPageActivity());
            tVar.setData(shareFromFrsMsgData);
            aVar.cc(1);
            aVar.z(tVar);
            aVar.a(t.j.share, new an(this, tVar, j, str, str2, shareFromFrsMsgData));
            aVar.b(t.j.alert_no_button, new ao(this, tVar));
            aVar.an(true);
            aVar.b(getPageContext()).up();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                tVar.y(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }

    private void a(ShareFromFrsMsgData shareFromFrsMsgData, int i, String str, long j) {
        if (this.bkq != null && this.bkq.avu() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.t tVar = new com.baidu.tieba.frs.view.t(getPageContext().getPageActivity());
            tVar.setData(shareFromFrsMsgData);
            aVar.cc(1);
            aVar.z(tVar);
            aVar.a(t.j.share, new ap(this, tVar, i, str, j, shareFromFrsMsgData));
            aVar.b(t.j.alert_no_button, new aq(this, tVar));
            aVar.an(true);
            aVar.b(getPageContext()).up();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                tVar.y(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.c cVar, boolean z, int i) {
        a(cVar, z ? "area_click" : "btn_click");
        b(cVar, "click");
        com.baidu.tieba.recapp.report.b.aLC().a(com.baidu.tieba.recapp.report.e.a(cVar, "click", i));
    }

    public void Rh() {
        if (!com.baidu.tbadk.core.util.ag.c(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.as.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a006";
    }

    @Override // com.baidu.a.a.a.InterfaceC0000a
    public void a(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ag.S(getApplicationContext())) {
                com.baidu.tbadk.core.util.as.c(getPageContext());
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
}
