package com.baidu.tieba.frs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.mvc.core.MvcActivity;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
/* loaded from: classes.dex */
public class FrsActivity extends MvcActivity<com.baidu.tieba.frs.c.n, com.baidu.tieba.frs.b.a, FrsActivity> implements com.baidu.tbadk.core.view.ao, com.baidu.tbadk.core.voice.j, com.baidu.tieba.tbadkCore.n {
    public static String aIF;
    public static boolean aIJ = false;
    public static volatile long aJb = 0;
    public static volatile long aJc = 0;
    public static volatile int aJd = 0;
    private static boolean isNeedRefreshOnResume = false;
    private com.baidu.adp.lib.e.b<TbImageView> Zg;
    private boolean aHy;
    private String aHz;
    private com.baidu.tbadk.core.data.w aIH;
    private cf aIX;
    private com.baidu.adp.lib.e.b<TbImageView> aIZ;
    private ag aJg;
    private com.baidu.tieba.frs.b.a aJj;
    private com.baidu.tieba.frs.c.n aJk;
    private com.baidu.tieba.frs.c.a aJl;
    private com.baidu.tieba.frs.c.k aJm;
    VoiceManager mVoiceManager;
    private boolean aIG = true;
    private boolean aII = false;
    private String aIK = null;
    private String Ws = null;
    private int aIL = 0;
    private int aIM = 1;
    private boolean aIN = false;
    private boolean aIO = false;
    private boolean aIP = false;
    private String mThreadId = null;
    private String forumId = null;
    private boolean aIQ = false;
    private boolean aIR = false;
    private bf aIS = null;
    private final com.baidu.tbadk.core.data.w aIT = null;
    private boolean aIU = false;
    private com.baidu.tieba.tbadkCore.w aIV = new com.baidu.tieba.tbadkCore.w();
    private com.baidu.tieba.tbadkCore.e aIW = null;
    private com.baidu.tbadk.core.data.w aIY = null;
    private boolean Jm = false;
    public long aCG = -1;
    public long apt = 0;
    public long createTime = 0;
    public long aJa = -1;
    private boolean aJe = false;
    public com.baidu.tbadk.performanceLog.h aJf = null;
    private boolean aJh = true;
    public long aJi = System.currentTimeMillis();
    private CustomMessageListener aHF = new a(this, 2004004);
    private CustomMessageListener aJn = new l(this, 2001273);
    private CustomMessageListener ayT = new x(this, 2001197);
    public final CustomMessageListener aJo = new aa(this, 2012111);
    public final com.baidu.tieba.tbadkCore.aa aJp = new ab(this);
    private final CustomMessageListener Os = new ac(this, 2003003);
    private final CustomMessageListener mMemListener = new ad(this, 2001200);
    private final com.baidu.adp.framework.listener.a aJq = new ae(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    private final com.baidu.tbadk.core.view.ae aJr = new af(this);
    private final com.baidu.adp.widget.ListView.z HK = new b(this);
    public final View.OnClickListener aJs = new c(this);
    private final AbsListView.OnScrollListener aHJ = new d(this);
    private final an aJt = new e(this);
    private final com.baidu.tieba.tbadkCore.ar aHL = new com.baidu.tieba.tbadkCore.ar(getPageContext(), new f(this));
    private final View.OnClickListener aJu = new g(this);
    private final View.OnClickListener aJv = new h(this);
    public final AdapterView.OnItemClickListener aJw = new i(this);
    private final com.baidu.tbadk.core.view.y aJx = new j(this);
    private final CustomMessageListener aJy = new k(this, 0);
    private com.baidu.adp.widget.ListView.aj aJz = new m(this);
    private View.OnClickListener aJA = new o(this);
    private View.OnClickListener aJB = new p(this);
    private com.baidu.adp.widget.ListView.ak aJC = new q(this);
    private final SlidingMenu.OnOpenedListener aJD = new r(this);
    public final com.baidu.adp.base.i aJE = new s(this);
    public final com.baidu.adp.base.i aJF = new t(this);

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity
    protected void a(ErrorData errorData) {
        this.aIS.bR(false);
        this.aIS.bS(false);
        this.aIS.bT(false);
        this.aIS.Kb();
        hideLoadingView(this.aIS.getRootView());
        this.aIS.Ki();
        if (!this.aIR) {
            com.baidu.tieba.tbadkCore.h KH = oi().KH();
            if (!this.aII) {
                if (KH != null) {
                    if (KH.ckr) {
                        if (340001 == KH.errorCode) {
                            showNetRefreshViewNoClick(this.aIS.Kl(), getPageContext().getResources().getString(com.baidu.tieba.y.net_error_text, KH.errorMsg, Integer.valueOf(KH.errorCode)), false);
                        } else {
                            showNetRefreshView(this.aIS.Kl(), getPageContext().getResources().getString(com.baidu.tieba.y.net_error_text, KH.errorMsg, Integer.valueOf(KH.errorCode)), false);
                        }
                    } else if (340001 == KH.errorCode) {
                        showNetRefreshViewNoClick(this.aIS.Kl(), KH.errorMsg, false);
                    } else {
                        showNetRefreshView(this.aIS.Kl(), KH.errorMsg, false);
                    }
                    this.aIS.eP(8);
                }
            } else if (KH != null && KH.ckr) {
                this.aIS.eP(0);
                showToast(getPageContext().getResources().getString(com.baidu.tieba.y.net_error_text, KH.errorMsg, Integer.valueOf(KH.errorCode)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.u uVar) {
        if (uVar != null) {
            try {
                this.aIV.d(uVar);
                if (this.aIV.YT() == 1) {
                    this.aIS.Kk().setFromCDN(true);
                } else {
                    this.aIS.Kk().setFromCDN(false);
                }
                this.aIS.a(this.aIV.YO(), this.aIV.getUserData());
                this.aJl.f(this.aIV.akq().akz() == 1, this.aIV.getUserData().getIsMem(), this.aIV.YO().isLike());
                this.aIS.Ka();
                this.aIK = this.aIV.YO().getName();
                this.forumId = this.aIV.YO().getId();
                this.aIS.setTitle(this.aIK);
                Jp();
                this.aIV.akJ();
                this.aIV.aB(getPageContext().getPageActivity());
                this.aIV.akL();
                this.aIS.b(this.aIV);
                if (!oi().KF()) {
                    this.aIV.akK();
                }
                com.baidu.tbadk.core.data.y top_notice_data = this.aIV.YO().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.getTitle() != null) {
                    com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                    wVar.setTitle(top_notice_data.getTitle());
                    wVar.bt(2);
                    wVar.bU(top_notice_data.qY());
                    wVar.parser_title();
                    this.aIV.e(wVar);
                }
                ArrayList<com.baidu.adp.widget.ListView.ai> akp = this.aIV.akp();
                if (akp != null) {
                    this.aIS.a(akp, this.aIM, this.aIV, this.aIV.XE().ql());
                    Js();
                    this.aJl.eS(this.aIM);
                    this.aJl.c(this.aIV);
                    this.aIS.Ke();
                    this.aIS.eO(0);
                }
                this.aJl.bY(this.aIV.akr());
                hideLoadingView(this.aIS.getRootView());
                this.aIS.Ki();
                this.aII = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        aIF = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (intent != null) {
            this.aCG = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aCG = System.currentTimeMillis();
        }
        if (this.aCG != -1) {
            this.aJa = this.aCG;
        } else {
            this.aJa = System.currentTimeMillis();
        }
        if (!bL(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.aJa;
            return;
        }
        super.onCreate(bundle);
        zT().addEventDelegate(this);
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        this.aHL.setUniqueId(getUniqueId());
        this.aHL.registerListener();
        addGlobalLayoutListener();
        Jj();
        registerListener(this.Os);
        registerListener(this.mMemListener);
        registerListener(this.aJo);
        registerListener(this.aHF);
        registerListener(this.ayT);
        registerListener(this.aJn);
        this.aJq.eP().setSelfListener(true);
        this.aJq.eO().setSelfListener(true);
        this.aJq.setTag(getUniqueId());
        registerListener(this.aJq);
        this.createTime = System.currentTimeMillis() - this.aCG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
        } else if (this.aIV != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null && this.aIS != null) {
            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(getMyPostResIdl.data.thread_info.author);
            a(metaData, getMyPostResIdl.data.user_info);
            String userId = metaData.getUserId();
            if (userId != null && !userId.equals(GameInfoData.NOT_FROM_DETAIL)) {
                hashMap.put(metaData.getUserId(), metaData);
            }
            oVar.setUserMap(hashMap);
            oVar.a(getMyPostResIdl.data.thread_info);
            this.aIV.a(oVar);
            this.aIS.Kb();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0008: IGET  (r1v0 java.lang.Integer A[REMOVE]) = (r4v0 tbclient.GetMyPost.User_Info) tbclient.GetMyPost.User_Info.id java.lang.Integer)] */
    private void a(MetaData metaData, User_Info user_Info) {
        if (user_Info != null) {
            metaData.setUserId(new StringBuilder().append(user_Info.id).toString());
            metaData.setGender(user_Info.gender.intValue());
            metaData.setType(user_Info.type.intValue());
            metaData.setUserName(user_Info.name);
            metaData.setName_show(user_Info.name_show);
            metaData.setPortrait(user_Info.portrait);
        }
    }

    private void Jj() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MY_POST, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_MY_POST + "?cmd=303111");
        tbHttpMessageTask.setResponsedClass(GetMyPostHttpResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(303111);
        bVar.setResponsedClass(GetMyPostSocketResponseMessage.class);
        bVar.i(true);
        bVar.j(false);
        bVar.a(SocketMessageTask.DupLicateMode.NONE);
        messageManager.registerTask(bVar);
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        Jl();
        this.aIP = TbadkCoreApplication.isLogin();
        if (bundle != null) {
            this.aIK = bundle.getString("name");
            this.Ws = bundle.getString("from");
            this.aIL = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.aIK = intent.getStringExtra("name");
                this.Ws = intent.getStringExtra("from");
                this.aIL = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.Ws) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.Ws)) {
            setSwipeBackEnabled(false);
        }
        this.aIX = new cf(getPageContext().getPageActivity());
        if (this.aIP) {
            Jk();
            Jm();
        }
        this.aJl.g(bundle);
    }

    public void Jk() {
        if (this.aIX != null && this.aIS != null) {
            if (FrsActivityStatic.aJO || FrsActivityStatic.aJP || FrsActivityStatic.aJQ) {
                this.aIX.Q(com.baidu.tbadk.coreExtra.messageCenter.a.uT().getMsgReplyme());
                this.aIX.P(com.baidu.tbadk.coreExtra.messageCenter.a.uT().getMsgAtme());
                int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.uT().getMsgChat();
                if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vH() && !TbadkCoreApplication.m411getInst().isMIUIRom()) {
                    msgChat -= com.baidu.tbadk.coreExtra.messageCenter.a.uT().va();
                }
                this.aIX.R(msgChat);
                this.aIS.a(this.aIX);
                this.aJm.a(this.aIX);
            }
        }
    }

    private void Jl() {
        registerListener(2001122, this.aJy);
    }

    private void Jm() {
        registerListener(2001124, this.aJy);
    }

    private boolean bL(boolean z) {
        if (z && com.baidu.tieba.frs.utils.a.G(getPageContext().getPageActivity(), getClass().getName())) {
            Intent intent = new Intent();
            intent.putExtra("class", 2);
            intent.putExtra(ImageViewerConfig.FORUM_NAME, getIntent().getStringExtra("name"));
            intent.putExtra("from", "short_cut");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LogoActivityConfig(getPageContext().getPageActivity(), intent)));
            finish();
            return false;
        }
        return true;
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.aIS != null) {
            this.aIS.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.aIW != null) {
                this.aIW.clear();
            }
            if (this.aJf != null) {
                this.aJf.onDestroy();
            }
            this.aIS.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.aJl.onActivityDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
        if (this.aJg != null) {
            this.aJg.cancel(true);
            this.aJg = null;
        }
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aIK);
        bundle.putString("from", this.Ws);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.w iw;
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    eF(0);
                    return;
                case 11002:
                    this.aJl.op();
                    return;
                case 11011:
                    b(this.aIT);
                    return;
                case 11012:
                    c(this.aIY);
                    return;
                case 11014:
                    this.aJl.Ld();
                    return;
                case 11016:
                    this.aIS.Kd();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    this.aJl.JA();
                    return;
                case 13003:
                    if (intent != null && !oi().KF()) {
                        try {
                            postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                        } catch (Exception e) {
                            postWriteCallBackData = null;
                        }
                        if (postWriteCallBackData != null) {
                            long a = com.baidu.adp.lib.g.c.a(postWriteCallBackData.getPostId(), 0L);
                            long a2 = com.baidu.adp.lib.g.c.a(postWriteCallBackData.getThreadId(), 0L);
                            long a3 = com.baidu.adp.lib.g.c.a(this.forumId, 0L);
                            if (a != 0 && a2 != 0 && a3 != 0) {
                                com.baidu.adp.lib.g.i.hI().postDelayed(new u(this, a2, a, a3), 1000L);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 18003:
                    this.aIS.Kk().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (iw = this.aIV.iw(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            iw.bu(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            iw.parser_title();
                            refresh();
                            return;
                        } else if (intExtra == 0) {
                            this.aIV.f(iw);
                            this.aIS.Ke();
                            if (com.baidu.tieba.tbadkCore.d.ako() != null) {
                                com.baidu.tieba.tbadkCore.d.ako().D(this.aIK, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    Jr();
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

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.aJm.Lh();
        this.aHy = true;
        this.aJh = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.aIS.mX();
        } else if (aIJ) {
            aIJ = false;
            this.aIS.mX();
        } else {
            if (!this.aIP && TbadkCoreApplication.isLogin()) {
                this.aIP = true;
                if (this.aIV != null && this.aIV.qe() != null) {
                    this.aIV.qe().setIfpost(1);
                }
                refresh();
            }
            this.mVoiceManager = getVoiceManager();
            this.mVoiceManager.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.aIK = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.Ws = intent.getStringExtra("from");
            }
            this.aIO = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aIO) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    Jn();
                } else {
                    Jo();
                }
            }
        }
    }

    private void Jn() {
        this.aIS.mX();
        this.aJm.getSlidingMenu().showContent(false);
    }

    public boolean isMenuShowing() {
        return this.aJm.getSlidingMenu().isMenuShowing();
    }

    private void Jo() {
        this.aIS.mX();
        this.aJm.getSlidingMenu().showContent(false);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.Ws)) {
                sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            } else {
                com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.Ws)) {
            sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        } else {
            com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.Ws)) {
            finish();
        }
    }

    private void initUI() {
        this.aIS.Kk().h(this.aJu);
        this.aIS.Kk().i(this.aJv);
        if (this.aIL == 0) {
            this.aIS.setTitle(this.aIK);
        } else {
            this.aIS.setTitle("");
            this.aIL = 1;
        }
        this.aJm.getSlidingMenu();
        this.aJl.v(this.aIS.getListView());
        this.aIS.a(this.aJz);
        this.aIS.a(this.aJC);
        this.aIS.j(this.aJA);
        this.aIS.l(this.aJB);
        this.aIS.setOnScrollListener(this.aHJ);
        this.aIS.a(this.HK);
        this.aIS.a(this.aJr);
        this.aIS.f(this.aJx);
        this.aJm.getSlidingMenu().setOnOpenedListener(this.aJD);
        this.aIS.Kk().a(this.aJt);
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.aIS.onChangeSkinType(i);
        this.aJm.a(getPageContext(), i);
        this.aJl.a(getPageContext(), i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public com.baidu.adp.lib.e.b<TbImageView> IP() {
        if (this.aIZ == null) {
            this.aIZ = FrsCommonImageLayout.l(getPageContext().getPageActivity(), 12);
        }
        return this.aIZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fH(String str) {
        Intent I;
        if (str != null && (I = com.baidu.tieba.frs.utils.a.I(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(com.baidu.tieba.y.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", I);
            BarImageView Lc = this.aJl.Lc();
            if (Lc != null && Lc.getBdImage() != null && Lc.getBdImage().mz() != null) {
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.e.it().a(com.baidu.adp.lib.util.e.it().d(Lc.getBdImage().mz(), getResources().getDimensionPixelSize(com.baidu.tieba.t.ds100)), getResources().getDimensionPixelSize(com.baidu.tieba.t.ds32)));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), com.baidu.tieba.u.icon));
            }
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eF(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            if (this.aIV != null && this.aIV.qe() != null) {
                this.aIV.qe().setIfpost(1);
            }
            if (i == 0) {
                sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.y.login_to_use), true, 11001)));
            } else {
                sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.y.login_to_use), true, 11016)));
            }
        } else if (this.aIV != null) {
            if (i == 0) {
                AntiData qe = this.aIV.qe();
                if (AntiHelper.c(qe) || AntiHelper.d(qe) || AntiHelper.e(qe)) {
                    qe.setBlock_forum_name(this.aIK);
                    qe.setBlock_forum_id(this.aIV.YO().getId());
                    qe.setUser_name(this.aIV.getUserData().getUserName());
                    qe.setUser_id(this.aIV.getUserData().getUserId());
                    if (AntiHelper.a(getPageContext().getPageActivity(), qe, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (this.aIV.qe() != null && this.aIV.qe().getIfpost() == 0) {
                    com.baidu.adp.lib.util.n.showToast(getPageContext().getPageActivity(), qe.getForbid_info());
                    return;
                }
                int i2 = 0;
                if (this.aIV.getUserData() != null) {
                    i2 = this.aIV.getUserData().getIsMem();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(getPageContext().getPageActivity(), 0, this.aIV.YO().getId(), this.aIK, null, null, 0, this.aIV.qe(), 13003, false, false, null, false, false, null, null, this.aIV.YO().getPrefixData(), i2)));
                return;
            }
            this.aIS.Kd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.w wVar) {
        boolean qT = wVar == null ? true : wVar.qT();
        this.aIS.a(new v(this, wVar));
        this.aIS.a(wVar, qT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.w wVar) {
        boolean qT = wVar == null ? true : wVar.qT();
        if (this.mThreadId != null) {
            if (!qT) {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aIK, null, 18003, true, true, this.aIQ)));
            } else {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aIK, null, 18003, false, false, this.aIQ)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.w wVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aIK, null, 18003, false, false, this.aIQ)));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aIS != null && z && this.aIG) {
            this.aIG = false;
            showLoadingView(this.aIS.getRootView(), true);
            this.aIS.Kj();
        }
    }

    public void refresh() {
        stopVoice();
        oi().aU(true);
    }

    private void Jp() {
        switch (this.aIL) {
            case 1:
                com.baidu.adp.lib.g.l.hJ().c(new w(this));
                break;
        }
        this.aIL = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jq() {
        stopVoice();
        try {
            if (this.aIV != null) {
                this.aIS.Ka();
                this.aIK = this.aIV.YO().getName();
                this.forumId = this.aIV.YO().getId();
                this.aIS.setTitle(this.aIK);
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.aIV.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.aIV.getUserData().getBimg_end_time());
                Jp();
                ArrayList<com.baidu.adp.widget.ListView.ai> akp = this.aIV.akp();
                if (akp != null) {
                    this.aIS.a(akp, this.aIM, this.aIV, this.aIV.XE().ql());
                    Js();
                    this.aJl.eS(this.aIM);
                    this.aJl.c(this.aIV);
                    this.aIS.Ke();
                    if (this.aIV.YT() == 1) {
                        this.aIS.Kk().setFromCDN(true);
                    } else {
                        this.aIS.Kk().setFromCDN(false);
                    }
                    this.aIS.eO(L(oi().getType(), this.aIM));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int L(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.aHy = false;
        this.aJh = false;
        this.aIS.onPause();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.aIV != null && this.aIV.YO() != null) {
            com.baidu.tbadk.distribute.a.ye().a(getPageContext().getPageActivity(), "frs", this.aIV.YO().getId(), 0L);
        }
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.aIN) {
            if (i == 4) {
                if (this.aJm.Af()) {
                    return true;
                }
                closeActivity();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void a(com.baidu.tbadk.core.data.c cVar, int i) {
        String trim;
        if (cVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bw(com.baidu.tieba.y.anti_title);
            if (cVar.pQ()) {
                com.baidu.tbadk.core.util.bk.tl().b(getPageContext(), new String[]{cVar.OZ});
            } else if (cVar.pP()) {
                if (com.baidu.adp.lib.util.k.iH() && !com.baidu.adp.lib.util.k.iI()) {
                    trim = getPageContext().getString(com.baidu.tieba.y.frs_network_tips);
                } else if (TextUtils.isEmpty(cVar.Pk.Pp.trim())) {
                    trim = getPageContext().getString(com.baidu.tieba.y.confirm_download_app);
                } else {
                    trim = cVar.Pk.Pp.trim();
                }
                aVar.ca(trim);
                aVar.a(com.baidu.tieba.y.alert_yes_button, new y(this, cVar, i));
                aVar.b(com.baidu.tieba.y.alert_no_button, new z(this));
                aVar.b(getPageContext()).re();
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar != null) {
            if (!cVar.pO()) {
                com.baidu.adp.lib.util.n.showToast(getPageContext().getPageActivity(), com.baidu.tieba.y.pb_app_error);
            } else if (UtilHelper.isNetOk()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", cVar.Pb);
                com.baidu.tbadk.download.b.yl().a(cVar.Pb, cVar.Pa, cVar.OX, i, com.baidu.adp.lib.g.c.toInt(cVar.OW, 0));
            } else {
                showToast(com.baidu.tieba.y.neterror);
            }
        }
    }

    public void Jr() {
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.aIV.YO().getId(), true, true, true);
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.ye().a(getPageContext().getPageActivity(), cVar, str, "frs", this.aIV.YO().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.ye().a(cVar, this.forumId, 0L, "FRS", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(int i) {
        ArrayList<com.baidu.adp.widget.ListView.ai> akp = this.aIV.akp();
        if (akp != null) {
            Iterator<com.baidu.adp.widget.ListView.ai> it = akp.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.ai next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.w) {
                    com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) next;
                    if (wVar == this.aIH) {
                        a(wVar, i);
                        this.aIH = null;
                        break;
                    } else if (wVar.getId() != null && wVar.getId().equals(this.aHz)) {
                        a(wVar, i);
                        this.aHz = null;
                        break;
                    }
                }
            }
            this.aIS.Kk().a(akp, this.aIV);
            this.aIS.Kk().notifyDataSetChanged();
        }
    }

    private void a(com.baidu.tbadk.core.data.w wVar, int i) {
        if (i == 1) {
            PraiseData praise = wVar.getPraise();
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
                    wVar.setPraise(praiseData);
                    return;
                }
                wVar.getPraise().getUser().add(0, metaData);
                wVar.getPraise().setNum(wVar.getPraise().getNum() + 1);
                wVar.getPraise().setIsLike(i);
            }
        } else if (wVar.getPraise() != null) {
            wVar.getPraise().setIsLike(i);
            wVar.getPraise().setNum(wVar.getPraise().getNum() - 1);
            ArrayList<MetaData> user = wVar.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        wVar.getPraise().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    public void a(cl clVar, String str) {
        if (str != null) {
            oi().aq(clVar.aMT, str);
            this.aJm.Lg();
            this.aIK = str;
            stopVoice();
        }
    }

    @Override // com.baidu.tbadk.core.voice.j
    public VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.ao
    public BdListView getListView() {
        if (this.aIS == null) {
            return null;
        }
        return this.aIS.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.j
    public com.baidu.tbadk.core.voice.i getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void stopVoice() {
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.ao
    public int tS() {
        if (this.aIS == null) {
            return 0;
        }
        return this.aIS.Kh();
    }

    @Override // com.baidu.tbadk.core.view.ao
    public com.baidu.adp.lib.e.b<TbImageView> tT() {
        if (this.Zg == null) {
            this.Zg = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.Zg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.aIX != null) {
                this.aIX.Q(msgReplyme);
                this.aIX.P(msgAtme);
                if (com.baidu.tbadk.coreExtra.messageCenter.c.vq().vH() && !TbadkCoreApplication.m411getInst().isMIUIRom()) {
                    this.aIX.R((msgChat - newsNotifyMessage.getMsgPrivateChat()) - newsNotifyMessage.getMsgStrangerChat());
                } else {
                    this.aIX.R(msgChat);
                }
                this.aIS.a(this.aIX);
                this.aJm.a(this.aIX);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        am Kk;
        HashMap<Integer, com.baidu.tbadk.core.data.w> JG;
        if (this.aIV != null && this.aIS != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (Kk = this.aIS.Kk()) != null && (JG = Kk.JG()) != null && JG.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.w> entry : JG.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.w value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.c) && TextUtils.equals(((com.baidu.tbadk.core.data.c) value).Pb, downloadData.getId())) {
                            int akH = this.aIV.akH();
                            if (Kk.aA(intValue + akH) instanceof com.baidu.tbadk.core.data.c) {
                                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) Kk.aA(akH + intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    cVar.OV = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!com.baidu.tbadk.core.util.bd.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    cVar.OV = 0;
                                } else if (status == 1) {
                                    cVar.OV = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.aIS.Kb();
        }
    }

    private void Js() {
        HashMap<Integer, com.baidu.tbadk.core.data.w> JG;
        if (this.aIS != null && this.aIS.Kk() != null && (JG = this.aIS.Kk().JG()) != null) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.w> entry : JG.entrySet()) {
                com.baidu.tbadk.core.data.w value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.c)) {
                    arrayList.add((com.baidu.tbadk.core.data.c) value);
                }
            }
            com.baidu.tbadk.download.b.yl().s(arrayList);
        }
    }

    public void Jt() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.n.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar != null) {
            a(cVar, "area_click");
            b(cVar, "click");
            int i2 = cVar.OV;
            if (i2 == 0) {
                a(cVar, i);
            } else if (i2 == 2) {
                com.baidu.tieba.frs.utils.a.F(getPageContext().getPageActivity(), cVar.Pb);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", cVar.Pb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.c cVar) {
        if (cVar != null) {
            a(cVar, "btn_click");
            b(cVar, "click");
            com.baidu.tbadk.core.util.bk.tl().b(getPageContext(), new String[]{cVar.OZ});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.aIS.Kl());
        showLoadingView(this.aIS.getRootView(), true);
        this.aIS.Kj();
        this.aIS.mX();
    }

    public com.baidu.tieba.tbadkCore.w Ju() {
        return this.aIV;
    }

    public boolean Jv() {
        return this.aIS.Jv();
    }

    public boolean Jw() {
        return this.Jm;
    }

    public void Jx() {
        FrsActivityStatic.aJO = false;
        FrsActivityStatic.aJQ = false;
        Jk();
    }

    public void Jy() {
        FrsActivityStatic.aJO = false;
        FrsActivityStatic.aJP = false;
        Jk();
    }

    public com.baidu.tbadk.coreExtra.view.b Jz() {
        return this.aIS.aLM;
    }

    public void JA() {
        this.aJl.JA();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: JB */
    public com.baidu.tieba.frs.b.a oi() {
        if (this.aJj == null) {
            this.aJj = new com.baidu.tieba.frs.b.a(this);
        }
        return this.aJj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: JC */
    public com.baidu.tieba.frs.c.n ok() {
        if (this.aJk == null) {
            this.aJk = new com.baidu.tieba.frs.c.n(this);
            this.aJm = new com.baidu.tieba.frs.c.k(this);
            this.aJl = new com.baidu.tieba.frs.c.a(this);
        }
        return this.aJk;
    }

    public void a(bf bfVar) {
        this.aIS = bfVar;
    }

    public void fI(String str) {
        this.aIK = str;
    }

    public void setFrom(String str) {
        this.Ws = str;
    }

    public String getFrom() {
        return this.Ws;
    }

    public void setFlag(int i) {
        this.aIL = i;
    }

    public void setPn(int i) {
        this.aIM = i;
    }

    public void resetData() {
        this.aII = false;
        this.aIR = false;
        this.aIV = null;
        this.aIS.setTitle(this.aIK);
        this.aJm.bZ(false);
        this.aJm.setIsManager(false);
        this.aJm.e(new com.baidu.tieba.tbadkCore.w());
    }
}
