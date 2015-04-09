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
public class FrsActivity extends MvcActivity<com.baidu.tieba.frs.c.n, com.baidu.tieba.frs.b.a, FrsActivity> implements com.baidu.adp.widget.ListView.x, com.baidu.tbadk.core.view.ao, com.baidu.tbadk.core.voice.j, com.baidu.tieba.tbadkCore.n {
    public static String aIN;
    public static boolean aIR = false;
    public static volatile long aJj = 0;
    public static volatile long aJk = 0;
    public static volatile int aJl = 0;
    private static boolean isNeedRefreshOnResume = false;
    private com.baidu.adp.lib.e.b<TbImageView> Zi;
    private boolean aHG;
    private String aHH;
    private com.baidu.tbadk.core.data.w aIP;
    private cf aJf;
    private com.baidu.adp.lib.e.b<TbImageView> aJh;
    private ag aJo;
    private com.baidu.tieba.frs.b.a aJr;
    private com.baidu.tieba.frs.c.n aJs;
    private com.baidu.tieba.frs.c.a aJt;
    private com.baidu.tieba.frs.c.k aJu;
    private com.baidu.tieba.frs.loadmore.a aJv;
    VoiceManager mVoiceManager;
    private boolean aIO = true;
    private boolean aIQ = false;
    private String aIS = null;
    private String Wu = null;
    private int aIT = 0;
    private int aIU = 1;
    private boolean aIV = false;
    private boolean aIW = false;
    private boolean aIX = false;
    private String mThreadId = null;
    private String forumId = null;
    private boolean aIY = false;
    private boolean aIZ = false;
    private bf aJa = null;
    private final com.baidu.tbadk.core.data.w aJb = null;
    private boolean aJc = false;
    private com.baidu.tieba.tbadkCore.w aJd = new com.baidu.tieba.tbadkCore.w();
    private com.baidu.tieba.tbadkCore.e aJe = null;
    private com.baidu.tbadk.core.data.w aJg = null;
    private boolean Jo = false;
    public long aCO = -1;
    public long apB = 0;
    public long createTime = 0;
    public long aJi = -1;
    private boolean aJm = false;
    public com.baidu.tbadk.performanceLog.h aJn = null;
    private boolean aJp = true;
    public long aJq = System.currentTimeMillis();
    private int aJw = -1;
    private CustomMessageListener aHN = new a(this, 2004004);
    private CustomMessageListener aJx = new l(this, 2001273);
    private CustomMessageListener azb = new x(this, 2001197);
    public final CustomMessageListener aJy = new aa(this, 2012111);
    public final com.baidu.tieba.tbadkCore.aa aJz = new ab(this);
    private final CustomMessageListener Ou = new ac(this, 2003003);
    private final CustomMessageListener mMemListener = new ad(this, 2001200);
    private final com.baidu.adp.framework.listener.a aJA = new ae(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    private final com.baidu.tbadk.core.view.ae aJB = new af(this);
    private final com.baidu.adp.widget.ListView.z HM = new b(this);
    public final View.OnClickListener aJC = new c(this);
    private final AbsListView.OnScrollListener aHR = new d(this);
    private final an aJD = new e(this);
    private final com.baidu.tieba.tbadkCore.ar aHT = new com.baidu.tieba.tbadkCore.ar(getPageContext(), new f(this));
    private final View.OnClickListener aJE = new g(this);
    private final View.OnClickListener aJF = new h(this);
    public final AdapterView.OnItemClickListener aJG = new i(this);
    private final com.baidu.tbadk.core.view.y aJH = new j(this);
    private final CustomMessageListener aJI = new k(this, 0);
    private com.baidu.adp.widget.ListView.aj aJJ = new m(this);
    private View.OnClickListener aJK = new o(this);
    private View.OnClickListener aJL = new p(this);
    private com.baidu.adp.widget.ListView.ak aJM = new q(this);
    private final SlidingMenu.OnOpenedListener aJN = new r(this);
    public final com.baidu.adp.base.i aJO = new s(this);
    public final com.baidu.adp.base.i aJP = new t(this);

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity
    protected void a(ErrorData errorData) {
        this.aJa.bP(false);
        this.aJa.bQ(false);
        this.aJa.bR(false);
        this.aJa.Ki();
        hideLoadingView(this.aJa.getRootView());
        this.aJa.Kp();
        if (!this.aIZ) {
            com.baidu.tieba.tbadkCore.h KT = oi().KT();
            if (!this.aIQ) {
                if (KT != null) {
                    if (KT.ckH) {
                        if (340001 == KT.errorCode) {
                            showNetRefreshViewNoClick(this.aJa.Ks(), getPageContext().getResources().getString(com.baidu.tieba.y.net_error_text, KT.errorMsg, Integer.valueOf(KT.errorCode)), false);
                        } else {
                            showNetRefreshView(this.aJa.Ks(), getPageContext().getResources().getString(com.baidu.tieba.y.net_error_text, KT.errorMsg, Integer.valueOf(KT.errorCode)), false);
                        }
                    } else if (340001 == KT.errorCode) {
                        showNetRefreshViewNoClick(this.aJa.Ks(), KT.errorMsg, false);
                    } else {
                        showNetRefreshView(this.aJa.Ks(), KT.errorMsg, false);
                    }
                    this.aJa.eP(8);
                }
            } else if (KT != null && KT.ckH) {
                this.aJa.eP(0);
                showToast(getPageContext().getResources().getString(com.baidu.tieba.y.net_error_text, KT.errorMsg, Integer.valueOf(KT.errorCode)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.u uVar) {
        if (uVar != null) {
            try {
                this.aJd.d(uVar);
                if (this.aJd.Zf() == 1) {
                    this.aJa.Kr().setFromCDN(true);
                } else {
                    this.aJa.Kr().setFromCDN(false);
                }
                this.aJw = this.aJd.XQ().ql();
                this.aJa.a(this.aJd.Za(), this.aJd.getUserData());
                this.aJt.f(this.aJd.akF().akO() == 1, this.aJd.getUserData().getIsMem(), this.aJd.Za().isLike());
                this.aJa.Kh();
                this.aIS = this.aJd.Za().getName();
                this.forumId = this.aJd.Za().getId();
                this.aJa.setTitle(this.aIS);
                Jv();
                this.aJd.akY();
                this.aJd.aB(getPageContext().getPageActivity());
                this.aJd.ala();
                this.aJa.b(this.aJd);
                if (!oi().KR()) {
                    this.aJd.akZ();
                }
                com.baidu.tbadk.core.data.y top_notice_data = this.aJd.Za().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.getTitle() != null) {
                    com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                    wVar.setTitle(top_notice_data.getTitle());
                    wVar.bt(2);
                    wVar.bU(top_notice_data.qY());
                    wVar.parser_title();
                    this.aJd.e(wVar);
                }
                ArrayList<com.baidu.adp.widget.ListView.ai> threadList = this.aJd.getThreadList();
                if (threadList != null) {
                    ArrayList<com.baidu.adp.widget.ListView.ai> a = this.aJv.a(true, threadList);
                    if (a != null) {
                        this.aJd.V(a);
                    }
                    this.aJa.a(threadList, this.aIU, this.aJd, this.aJd.XQ().ql());
                    Jy();
                    this.aJt.eT(this.aIU);
                    this.aJt.c(this.aJd);
                    this.aJa.Kl();
                    this.aJa.eO(0);
                }
                this.aJt.bW(this.aJd.akG());
                hideLoadingView(this.aJa.getRootView());
                this.aJa.Kp();
                this.aIQ = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        aIN = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (intent != null) {
            this.aCO = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aCO = System.currentTimeMillis();
        }
        if (this.aCO != -1) {
            this.aJi = this.aCO;
        } else {
            this.aJi = System.currentTimeMillis();
        }
        if (!bL(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.aJi;
            return;
        }
        super.onCreate(bundle);
        zZ().addEventDelegate(this);
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        this.aHT.setUniqueId(getUniqueId());
        this.aHT.registerListener();
        addGlobalLayoutListener();
        Jp();
        registerListener(this.Ou);
        registerListener(this.mMemListener);
        registerListener(this.aJy);
        registerListener(this.aHN);
        registerListener(this.azb);
        registerListener(this.aJx);
        this.aJA.eP().setSelfListener(true);
        this.aJA.eO().setSelfListener(true);
        this.aJA.setTag(getUniqueId());
        registerListener(this.aJA);
        this.aJv = new com.baidu.tieba.frs.loadmore.a(this);
        this.aJv.registerListener();
        this.createTime = System.currentTimeMillis() - this.aCO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
        } else if (this.aJd != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null && this.aJa != null) {
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
            this.aJd.a(oVar);
            ArrayList<com.baidu.adp.widget.ListView.ai> a = this.aJv.a(true, this.aJd.getThreadList());
            if (a != null) {
                this.aJd.V(a);
                this.aJa.a(a, this.aIU, this.aJd, this.aJw);
            }
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

    private void Jp() {
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
        Jr();
        this.aIX = TbadkCoreApplication.isLogin();
        if (bundle != null) {
            this.aIS = bundle.getString("name");
            this.Wu = bundle.getString("from");
            this.aIT = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.aIS = intent.getStringExtra("name");
                this.Wu = intent.getStringExtra("from");
                this.aIT = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.Wu) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.Wu)) {
            setSwipeBackEnabled(false);
        }
        this.aJf = new cf(getPageContext().getPageActivity());
        if (this.aIX) {
            Jq();
            Js();
        }
        this.aJt.g(bundle);
    }

    public void Jq() {
        if (this.aJf != null && this.aJa != null) {
            if (FrsActivityStatic.aJY || FrsActivityStatic.aJZ || FrsActivityStatic.aKa) {
                this.aJf.Q(com.baidu.tbadk.coreExtra.messageCenter.a.uZ().getMsgReplyme());
                this.aJf.P(com.baidu.tbadk.coreExtra.messageCenter.a.uZ().getMsgAtme());
                int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.uZ().getMsgChat();
                if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().vN() && !TbadkCoreApplication.m411getInst().isMIUIRom()) {
                    msgChat -= com.baidu.tbadk.coreExtra.messageCenter.a.uZ().vg();
                }
                this.aJf.R(msgChat);
                this.aJa.a(this.aJf);
                this.aJu.a(this.aJf);
            }
        }
    }

    private void Jr() {
        registerListener(2001122, this.aJI);
    }

    private void Js() {
        registerListener(2001124, this.aJI);
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
        if (this.aJa != null) {
            this.aJa.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.aJe != null) {
                this.aJe.clear();
            }
            if (this.aJn != null) {
                this.aJn.onDestroy();
            }
            this.aJa.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.aJt.onActivityDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
        if (this.aJo != null) {
            this.aJo.cancel(true);
            this.aJo = null;
        }
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aIS);
        bundle.putString("from", this.Wu);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.w iz;
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    eF(0);
                    return;
                case 11002:
                    this.aJt.op();
                    return;
                case 11011:
                    b(this.aJb);
                    return;
                case 11012:
                    c(this.aJg);
                    return;
                case 11014:
                    this.aJt.Lp();
                    return;
                case 11016:
                    this.aJa.Kk();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    this.aJt.JG();
                    return;
                case 13003:
                    if (intent != null && !oi().KR()) {
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
                    this.aJa.Kr().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (iz = this.aJd.iz(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            iz.bu(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            iz.parser_title();
                            refresh();
                            return;
                        } else if (intExtra == 0) {
                            this.aJd.f(iz);
                            this.aJa.Kl();
                            if (com.baidu.tieba.tbadkCore.d.akD() != null) {
                                com.baidu.tieba.tbadkCore.d.akD().D(this.aIS, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    Jx();
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
        this.aJu.Lt();
        this.aHG = true;
        this.aJp = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.aJa.mX();
        } else if (aIR) {
            aIR = false;
            this.aJa.mX();
        } else {
            if (!this.aIX && TbadkCoreApplication.isLogin()) {
                this.aIX = true;
                if (this.aJd != null && this.aJd.qe() != null) {
                    this.aJd.qe().setIfpost(1);
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
                this.aIS = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.Wu = intent.getStringExtra("from");
            }
            this.aIW = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aIW) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    Jt();
                } else {
                    Ju();
                }
            }
        }
    }

    private void Jt() {
        this.aJa.mX();
        this.aJu.getSlidingMenu().showContent(false);
    }

    public boolean isMenuShowing() {
        return this.aJu.getSlidingMenu().isMenuShowing();
    }

    private void Ju() {
        this.aJa.mX();
        this.aJu.getSlidingMenu().showContent(false);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.Wu)) {
                sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            } else {
                com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.Wu)) {
            sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        } else {
            com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.Wu)) {
            finish();
        }
    }

    private void initUI() {
        this.aJa.Kr().h(this.aJE);
        this.aJa.Kr().i(this.aJF);
        if (this.aIT == 0) {
            this.aJa.setTitle(this.aIS);
        } else {
            this.aJa.setTitle("");
            this.aIT = 1;
        }
        this.aJu.getSlidingMenu();
        this.aJt.v(this.aJa.getListView());
        this.aJa.a(this.aJJ);
        this.aJa.a(this.aJM);
        this.aJa.j(this.aJK);
        this.aJa.l(this.aJL);
        this.aJa.setOnScrollListener(this.aHR);
        this.aJa.a(this.HM);
        this.aJa.a(this.aJB);
        this.aJa.f(this.aJH);
        this.aJu.getSlidingMenu().setOnOpenedListener(this.aJN);
        this.aJa.Kr().a(this.aJD);
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.aJa.onChangeSkinType(i);
        this.aJu.a(getPageContext(), i);
        this.aJt.a(getPageContext(), i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public com.baidu.adp.lib.e.b<TbImageView> IV() {
        if (this.aJh == null) {
            this.aJh = FrsCommonImageLayout.l(getPageContext().getPageActivity(), 12);
        }
        return this.aJh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK(String str) {
        Intent I;
        if (str != null && (I = com.baidu.tieba.frs.utils.a.I(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(com.baidu.tieba.y.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", I);
            BarImageView Lo = this.aJt.Lo();
            if (Lo != null && Lo.getBdImage() != null && Lo.getBdImage().mz() != null) {
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.e.it().a(com.baidu.adp.lib.util.e.it().d(Lo.getBdImage().mz(), getResources().getDimensionPixelSize(com.baidu.tieba.t.ds100)), getResources().getDimensionPixelSize(com.baidu.tieba.t.ds32)));
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
            if (this.aJd != null && this.aJd.qe() != null) {
                this.aJd.qe().setIfpost(1);
            }
            if (i == 0) {
                sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.y.login_to_use), true, 11001)));
            } else {
                sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.y.login_to_use), true, 11016)));
            }
        } else if (this.aJd != null) {
            if (i == 0) {
                AntiData qe = this.aJd.qe();
                if (AntiHelper.c(qe) || AntiHelper.d(qe) || AntiHelper.e(qe)) {
                    qe.setBlock_forum_name(this.aIS);
                    qe.setBlock_forum_id(this.aJd.Za().getId());
                    qe.setUser_name(this.aJd.getUserData().getUserName());
                    qe.setUser_id(this.aJd.getUserData().getUserId());
                    if (AntiHelper.a(getPageContext().getPageActivity(), qe, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (this.aJd.qe() != null && this.aJd.qe().getIfpost() == 0) {
                    com.baidu.adp.lib.util.n.showToast(getPageContext().getPageActivity(), qe.getForbid_info());
                    return;
                }
                int i2 = 0;
                if (this.aJd.getUserData() != null) {
                    i2 = this.aJd.getUserData().getIsMem();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(getPageContext().getPageActivity(), 0, this.aJd.Za().getId(), this.aIS, null, null, 0, this.aJd.qe(), 13003, false, false, null, false, false, null, null, this.aJd.Za().getPrefixData(), i2)));
                return;
            }
            this.aJa.Kk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.w wVar) {
        boolean qT = wVar == null ? true : wVar.qT();
        this.aJa.a(new v(this, wVar));
        this.aJa.a(wVar, qT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.w wVar) {
        boolean qT = wVar == null ? true : wVar.qT();
        if (this.mThreadId != null) {
            if (!qT) {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aIS, null, 18003, true, true, this.aIY)));
            } else {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aIS, null, 18003, false, false, this.aIY)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.w wVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aIS, null, 18003, false, false, this.aIY)));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aJa != null && z && this.aIO) {
            this.aIO = false;
            showLoadingView(this.aJa.getRootView(), true);
            this.aJa.Kq();
        }
    }

    public void refresh() {
        stopVoice();
        oi().aU(true);
    }

    private void Jv() {
        switch (this.aIT) {
            case 1:
                com.baidu.adp.lib.g.l.hJ().c(new w(this));
                break;
        }
        this.aIT = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jw() {
        stopVoice();
        try {
            if (this.aJd != null) {
                this.aJa.Kh();
                this.aIS = this.aJd.Za().getName();
                this.forumId = this.aJd.Za().getId();
                this.aJa.setTitle(this.aIS);
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.aJd.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.aJd.getUserData().getBimg_end_time());
                Jv();
                ArrayList<com.baidu.adp.widget.ListView.ai> threadList = this.aJd.getThreadList();
                if (threadList != null) {
                    this.aJa.a(threadList, this.aIU, this.aJd, this.aJd.XQ().ql());
                    Jy();
                    this.aJt.eT(this.aIU);
                    this.aJt.c(this.aJd);
                    this.aJa.Kl();
                    if (this.aJd.Zf() == 1) {
                        this.aJa.Kr().setFromCDN(true);
                    } else {
                        this.aJa.Kr().setFromCDN(false);
                    }
                    this.aJa.eO(L(oi().getType(), this.aIU));
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
        this.aHG = false;
        this.aJp = false;
        this.aJa.onPause();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.aJd != null && this.aJd.Za() != null) {
            com.baidu.tbadk.distribute.a.yk().a(getPageContext().getPageActivity(), "frs", this.aJd.Za().getId(), 0L);
        }
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.aIV) {
            if (i == 4) {
                if (this.aJu.Al()) {
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
                com.baidu.tbadk.core.util.bk.tl().b(getPageContext(), new String[]{cVar.Pb});
            } else if (cVar.pP()) {
                if (com.baidu.adp.lib.util.k.iH() && !com.baidu.adp.lib.util.k.iI()) {
                    trim = getPageContext().getString(com.baidu.tieba.y.frs_network_tips);
                } else if (TextUtils.isEmpty(cVar.Pm.Pr.trim())) {
                    trim = getPageContext().getString(com.baidu.tieba.y.confirm_download_app);
                } else {
                    trim = cVar.Pm.Pr.trim();
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
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", cVar.Pd);
                com.baidu.tbadk.download.b.yr().a(cVar.Pd, cVar.Pc, cVar.OZ, i, com.baidu.adp.lib.g.c.toInt(cVar.OY, 0));
            } else {
                showToast(com.baidu.tieba.y.neterror);
            }
        }
    }

    public void Jx() {
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.aJd.Za().getId(), true, true, true);
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.yk().a(getPageContext().getPageActivity(), cVar, str, "frs", this.aJd.Za().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.yk().a(cVar, this.forumId, 0L, "FRS", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(int i) {
        ArrayList<com.baidu.adp.widget.ListView.ai> threadList = this.aJd.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.ai> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.ai next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.w) {
                    com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) next;
                    if (wVar == this.aIP) {
                        a(wVar, i);
                        this.aIP = null;
                        break;
                    } else if (wVar.getId() != null && wVar.getId().equals(this.aHH)) {
                        a(wVar, i);
                        this.aHH = null;
                        break;
                    }
                }
            }
            this.aJa.Kr().a(threadList, this.aJd);
            this.aJa.Kr().notifyDataSetChanged();
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
            oi().aq(clVar.aNe, str);
            this.aJu.Ls();
            this.aIS = str;
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
        if (this.aJa == null) {
            return null;
        }
        return this.aJa.getListView();
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
        if (this.aJa == null) {
            return 0;
        }
        return this.aJa.Ko();
    }

    @Override // com.baidu.tbadk.core.view.ao
    public com.baidu.adp.lib.e.b<TbImageView> tT() {
        if (this.Zi == null) {
            this.Zi = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.Zi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.aJf != null) {
                this.aJf.Q(msgReplyme);
                this.aJf.P(msgAtme);
                if (com.baidu.tbadk.coreExtra.messageCenter.c.vw().vN() && !TbadkCoreApplication.m411getInst().isMIUIRom()) {
                    this.aJf.R((msgChat - newsNotifyMessage.getMsgPrivateChat()) - newsNotifyMessage.getMsgStrangerChat());
                } else {
                    this.aJf.R(msgChat);
                }
                this.aJa.a(this.aJf);
                this.aJu.a(this.aJf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        am Kr;
        HashMap<Integer, com.baidu.tbadk.core.data.w> JN;
        if (this.aJd != null && this.aJa != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (Kr = this.aJa.Kr()) != null && (JN = Kr.JN()) != null && JN.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.w> entry : JN.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.w value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.c) && TextUtils.equals(((com.baidu.tbadk.core.data.c) value).Pd, downloadData.getId())) {
                            int akW = this.aJd.akW();
                            if (Kr.aA(intValue + akW) instanceof com.baidu.tbadk.core.data.c) {
                                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) Kr.aA(akW + intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    cVar.OX = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!com.baidu.tbadk.core.util.bd.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    cVar.OX = 0;
                                } else if (status == 1) {
                                    cVar.OX = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.aJa.Ki();
        }
    }

    private void Jy() {
        HashMap<Integer, com.baidu.tbadk.core.data.w> JN;
        if (this.aJa != null && this.aJa.Kr() != null && (JN = this.aJa.Kr().JN()) != null) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.w> entry : JN.entrySet()) {
                com.baidu.tbadk.core.data.w value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.c)) {
                    arrayList.add((com.baidu.tbadk.core.data.c) value);
                }
            }
            com.baidu.tbadk.download.b.yr().s(arrayList);
        }
    }

    public void Jz() {
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
            int i2 = cVar.OX;
            if (i2 == 0) {
                a(cVar, i);
            } else if (i2 == 2) {
                com.baidu.tieba.frs.utils.a.F(getPageContext().getPageActivity(), cVar.Pd);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", cVar.Pd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.c cVar) {
        if (cVar != null) {
            a(cVar, "btn_click");
            b(cVar, "click");
            com.baidu.tbadk.core.util.bk.tl().b(getPageContext(), new String[]{cVar.Pb});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.aJa.Ks());
        showLoadingView(this.aJa.getRootView(), true);
        this.aJa.Kq();
        this.aJa.mX();
    }

    public com.baidu.tieba.tbadkCore.w JA() {
        return this.aJd;
    }

    public boolean JB() {
        return this.aJa.JB();
    }

    public boolean JC() {
        return this.Jo;
    }

    public void JD() {
        FrsActivityStatic.aJY = false;
        FrsActivityStatic.aKa = false;
        Jq();
    }

    public void JE() {
        FrsActivityStatic.aJY = false;
        FrsActivityStatic.aJZ = false;
        Jq();
    }

    public com.baidu.tbadk.coreExtra.view.b JF() {
        return this.aJa.aLX;
    }

    public void JG() {
        this.aJt.JG();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: JH */
    public com.baidu.tieba.frs.b.a oi() {
        if (this.aJr == null) {
            this.aJr = new com.baidu.tieba.frs.b.a(this);
        }
        return this.aJr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: JI */
    public com.baidu.tieba.frs.c.n ok() {
        if (this.aJs == null) {
            this.aJs = new com.baidu.tieba.frs.c.n(this);
            this.aJu = new com.baidu.tieba.frs.c.k(this);
            this.aJt = new com.baidu.tieba.frs.c.a(this);
        }
        return this.aJs;
    }

    public void a(bf bfVar) {
        this.aJa = bfVar;
    }

    public void fL(String str) {
        this.aIS = str;
    }

    public void setFrom(String str) {
        this.Wu = str;
    }

    public String getFrom() {
        return this.Wu;
    }

    public void setFlag(int i) {
        this.aIT = i;
    }

    public void setPn(int i) {
        this.aIU = i;
    }

    public void resetData() {
        this.aIQ = false;
        this.aIZ = false;
        this.aJd = null;
        this.aJa.setTitle(this.aIS);
        this.aJu.bX(false);
        this.aJu.setIsManager(false);
        this.aJu.e(new com.baidu.tieba.tbadkCore.w());
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.n.isNetOk()) {
            this.aJa.Ky();
            return;
        }
        JJ();
        if (!this.aJv.anb && !this.aJr.isLoading()) {
            if (this.aJv.V(this.aJd.akE())) {
                this.aJa.a(this.aJv.KL(), this.aIU, this.aJd, 0);
                this.aJv.a(com.baidu.adp.lib.g.c.a(this.forumId, 0L), this.aJd.akE());
            } else if (this.aJw != 0) {
                this.aJa.a(this.aJv.KL(), this.aIU, this.aJd, 0);
                this.aIU++;
                this.aJr.eQ(this.aIU);
                this.aJv.aNh = false;
                this.aJv.aNi = 0;
            }
        }
    }

    public void onFailed(String str) {
        JJ();
        showToast(str);
    }

    public void w(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.ai> a;
        JJ();
        if (arrayList != null && arrayList.size() != 0 && (a = this.aJv.a(false, arrayList)) != null) {
            this.aJd.V(a);
            this.aJa.a(a, this.aIU, this.aJd, 0);
        }
    }

    private void JJ() {
        if (this.aJw == 0 && !this.aJv.V(this.aJd.akE())) {
            if (this.aJd.getThreadList() == null || this.aJd.getThreadList().size() == 0) {
                this.aJa.Ky();
                return;
            } else {
                this.aJa.Kx();
                return;
            }
        }
        this.aJa.Kw();
    }
}
