package com.baidu.tieba.frs;

import android.content.Intent;
import android.graphics.Bitmap;
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
public class FrsActivity extends MvcActivity<com.baidu.tieba.frs.c.n, com.baidu.tieba.frs.b.a, FrsActivity> implements com.baidu.adp.widget.ListView.x, com.baidu.tbadk.core.view.at, com.baidu.tbadk.core.voice.j, com.baidu.tieba.tbadkCore.n {
    public static String aKV;
    public static boolean aLa = false;
    public static volatile long aLr = 0;
    public static volatile long aLs = 0;
    public static volatile int aLt = 0;
    private static boolean isNeedRefreshOnResume = false;
    private boolean aJP;
    private String aJQ;
    private com.baidu.tbadk.core.data.w aKX;
    private com.baidu.tieba.frs.c.a aLA;
    private com.baidu.tieba.frs.c.k aLB;
    private com.baidu.tieba.frs.loadmore.a aLC;
    private ce aLn;
    private com.baidu.adp.lib.e.b<TbImageView> aLp;
    private ag aLw;
    private com.baidu.tieba.frs.b.a aLy;
    private com.baidu.tieba.frs.c.n aLz;
    private com.baidu.adp.lib.e.b<TbImageView> aaj;
    VoiceManager mVoiceManager;
    private boolean aKW = true;
    private boolean aKY = false;
    public boolean aKZ = false;
    private String aLb = null;
    private String mFrom = null;
    private int aLc = 0;
    private int aLd = 1;
    private boolean aLe = false;
    private boolean aLf = false;
    private String mThreadId = null;
    private String forumId = null;
    private boolean aLg = false;
    private boolean aLh = false;
    private bf aLi = null;
    private final com.baidu.tbadk.core.data.w aLj = null;
    private boolean aLk = false;
    private com.baidu.tieba.tbadkCore.w aLl = new com.baidu.tieba.tbadkCore.w();
    private com.baidu.tieba.tbadkCore.e aLm = null;
    private com.baidu.tbadk.core.data.w aLo = null;
    private boolean Jf = false;
    public long aEP = -1;
    public long aqD = 0;
    public long createTime = 0;
    public long aLq = -1;
    private boolean aLu = false;
    public com.baidu.tbadk.performanceLog.h aLv = null;
    private boolean aLx = true;
    private int aLD = -1;
    private CustomMessageListener aJV = new a(this, 2004004);
    private CustomMessageListener aLE = new l(this, 2001273);
    private CustomMessageListener aAM = new x(this, 2001197);
    public final CustomMessageListener aLF = new aa(this, 2012111);
    public final com.baidu.tieba.tbadkCore.aa aLG = new ab(this);
    private final CustomMessageListener OQ = new ac(this, 2003003);
    private final CustomMessageListener mMemListener = new ad(this, 2001200);
    private final com.baidu.adp.framework.listener.a aLH = new ae(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    private final com.baidu.tbadk.core.view.aj aLI = new af(this);
    private final com.baidu.adp.widget.ListView.z HC = new b(this);
    public final View.OnClickListener aLJ = new c(this);
    private final AbsListView.OnScrollListener aJZ = new d(this);
    private final an aLK = new e(this);
    private final com.baidu.tieba.tbadkCore.ar aKb = new com.baidu.tieba.tbadkCore.ar(getPageContext(), new f(this));
    private final View.OnClickListener aLL = new g(this);
    private final View.OnClickListener aLM = new h(this);
    public final AdapterView.OnItemClickListener aLN = new i(this);
    private final com.baidu.tbadk.core.view.ad aLO = new j(this);
    private final CustomMessageListener aLP = new k(this, 0);
    private com.baidu.adp.widget.ListView.aj aLQ = new m(this);
    private View.OnClickListener aLR = new o(this);
    private View.OnClickListener aLS = new p(this);
    private com.baidu.adp.widget.ListView.ak aLT = new q(this);
    private final SlidingMenu.OnOpenedListener aLU = new r(this);
    public final com.baidu.adp.base.i aLV = new s(this);
    public final com.baidu.adp.base.i aLW = new t(this);

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity
    protected void a(ErrorData errorData) {
        this.aLi.bY(false);
        this.aLi.bZ(false);
        this.aLi.ca(false);
        this.aLi.Ln();
        hideLoadingView(this.aLi.getRootView());
        this.aLi.Lu();
        if (!this.aLh) {
            com.baidu.tieba.tbadkCore.h LY = oy().LY();
            if (!this.aKY) {
                if (LY != null) {
                    if (LY.coH) {
                        if (340001 == LY.errorCode) {
                            showNetRefreshViewNoClick(this.aLi.getRootView(), getPageContext().getResources().getString(com.baidu.tieba.t.net_error_text, LY.errorMsg, Integer.valueOf(LY.errorCode)), true);
                        } else {
                            showNetRefreshView(this.aLi.getRootView(), getPageContext().getResources().getString(com.baidu.tieba.t.net_error_text, LY.errorMsg, Integer.valueOf(LY.errorCode)), true);
                        }
                    } else if (340001 == LY.errorCode) {
                        showNetRefreshViewNoClick(this.aLi.getRootView(), LY.errorMsg, true);
                    } else {
                        showNetRefreshView(this.aLi.getRootView(), LY.errorMsg, true);
                    }
                    this.aLi.fd(8);
                }
            } else if (LY != null && LY.coH) {
                this.aLi.fd(0);
                showToast(getPageContext().getResources().getString(com.baidu.tieba.t.net_error_text, LY.errorMsg, Integer.valueOf(LY.errorCode)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.u uVar) {
        if (uVar != null) {
            try {
                this.aKW = false;
                this.aLl.d(uVar);
                if (this.aLl.aaw() == 1) {
                    this.aLi.Lw().setFromCDN(true);
                } else {
                    this.aLi.Lw().setFromCDN(false);
                }
                this.aLD = this.aLl.Zp().qR();
                this.aLi.a(this.aLl.aar(), this.aLl.getUserData());
                this.aLA.f(this.aLl.amp().amz() == 1, this.aLl.getUserData().getIsMem(), this.aLl.aar().isLike());
                this.aLi.Lm();
                this.aLb = this.aLl.aar().getName();
                this.forumId = this.aLl.aar().getId();
                this.aLi.setTitle(this.aLb);
                Kz();
                this.aLl.amJ();
                this.aLl.aG(getPageContext().getPageActivity());
                this.aLl.amL();
                this.aLi.b(this.aLl);
                if (!oy().LW()) {
                    this.aLl.amK();
                }
                com.baidu.tbadk.core.data.y top_notice_data = this.aLl.aar().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.getTitle() != null) {
                    com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                    wVar.setTitle(top_notice_data.getTitle());
                    wVar.bq(2);
                    wVar.ch(top_notice_data.rE());
                    wVar.parser_title();
                    this.aLl.e(wVar);
                }
                ArrayList<com.baidu.adp.widget.ListView.ai> threadList = this.aLl.getThreadList();
                if (threadList != null) {
                    ArrayList<com.baidu.adp.widget.ListView.ai> a = this.aLC.a(true, threadList);
                    if (a != null) {
                        this.aLl.R(a);
                    }
                    this.aLi.a(threadList, this.aLd, this.aLl, this.aLl.Zp().qR());
                    KC();
                    this.aLA.fh(this.aLd);
                    this.aLA.c(this.aLl);
                    this.aLi.Lq();
                    this.aLi.fc(0);
                }
                this.aLA.cf(this.aLl.amq());
                hideLoadingView(this.aLi.getRootView());
                this.aLi.Lu();
                this.aKY = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        aKV = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (intent != null) {
            this.aEP = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aEP = System.currentTimeMillis();
        }
        if (this.aEP != -1) {
            this.aLq = this.aEP;
        } else {
            this.aLq = System.currentTimeMillis();
        }
        if (!bU(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.aLq;
            return;
        }
        super.onCreate(bundle);
        AL().addEventDelegate(this);
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        this.aKb.setUniqueId(getUniqueId());
        this.aKb.registerListener();
        addGlobalLayoutListener();
        Kt();
        registerListener(this.OQ);
        registerListener(this.mMemListener);
        registerListener(this.aLF);
        registerListener(this.aJV);
        registerListener(this.aAM);
        registerListener(this.aLE);
        this.aLH.eS().setSelfListener(true);
        this.aLH.eR().setSelfListener(true);
        this.aLH.setTag(getUniqueId());
        registerListener(this.aLH);
        this.aLC = new com.baidu.tieba.frs.loadmore.a(this);
        this.aLC.registerListener();
        this.createTime = System.currentTimeMillis() - this.aEP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
        } else if (this.aLl != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null && this.aLi != null) {
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
            this.aLl.a(oVar);
            ArrayList<com.baidu.adp.widget.ListView.ai> a = this.aLC.a(true, this.aLl.getThreadList());
            if (a != null) {
                this.aLl.R(a);
                this.aLi.a(a, this.aLd, this.aLl, this.aLD);
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

    private void Kt() {
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

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        Kv();
        if (bundle != null) {
            this.aLb = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aLc = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.aLb = intent.getStringExtra("name");
                this.mFrom = intent.getStringExtra("from");
                this.aLc = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            setSwipeBackEnabled(false);
        }
        this.aLn = new ce(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            Ku();
            Kw();
        }
        this.aLA.g(bundle);
    }

    public void Ku() {
        if (this.aLn != null && this.aLi != null) {
            if (FrsActivityStatic.aMf || FrsActivityStatic.aMg || FrsActivityStatic.aMh) {
                this.aLn.R(com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgReplyme());
                this.aLn.Q(com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgAtme());
                int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgChat();
                if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wx() && !TbadkCoreApplication.m411getInst().isMIUIRom()) {
                    msgChat -= com.baidu.tbadk.coreExtra.messageCenter.a.vJ().vQ();
                }
                this.aLn.S(msgChat);
                this.aLi.a(this.aLn);
                this.aLB.a(this.aLn);
            }
        }
    }

    private void Kv() {
        registerListener(2001122, this.aLP);
    }

    private void Kw() {
        registerListener(2001124, this.aLP);
    }

    private boolean bU(boolean z) {
        if (z && com.baidu.tieba.frs.utils.a.H(getPageContext().getPageActivity(), getClass().getName())) {
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
        if (this.aLi != null) {
            this.aLi.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.aLm != null) {
                this.aLm.clear();
            }
            if (this.aLv != null) {
                this.aLv.onDestroy();
            }
            this.aLi.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.aLA.onActivityDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
        if (this.aLw != null) {
            this.aLw.cancel(true);
            this.aLw = null;
        }
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aLb);
        bundle.putString("from", this.mFrom);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.w js;
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    eT(0);
                    return;
                case 11002:
                    this.aLA.oF();
                    return;
                case 11011:
                    b(this.aLj);
                    return;
                case 11012:
                    c(this.aLo);
                    return;
                case 11014:
                    this.aLA.Mu();
                    return;
                case 11016:
                    this.aLi.Lp();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    this.aLA.KK();
                    return;
                case 13003:
                    if (intent != null && !oy().LW()) {
                        try {
                            postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                        } catch (Exception e) {
                            postWriteCallBackData = null;
                        }
                        if (postWriteCallBackData != null) {
                            long c = com.baidu.adp.lib.g.c.c(postWriteCallBackData.getPostId(), 0L);
                            long c2 = com.baidu.adp.lib.g.c.c(postWriteCallBackData.getThreadId(), 0L);
                            long c3 = com.baidu.adp.lib.g.c.c(this.forumId, 0L);
                            if (c != 0 && c2 != 0 && c3 != 0) {
                                com.baidu.adp.lib.g.i.hs().postDelayed(new u(this, c2, c, c3), 1000L);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 18003:
                    this.aLi.Lw().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (js = this.aLl.js(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            js.br(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            js.parser_title();
                            refresh();
                            return;
                        } else if (intExtra == 0) {
                            this.aLl.f(js);
                            this.aLi.Lq();
                            if (com.baidu.tieba.tbadkCore.d.amo() != null) {
                                com.baidu.tieba.tbadkCore.d.amo().D(this.aLb, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    KB();
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
        this.aLB.My();
        this.aJP = true;
        this.aLx = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.aLi.no();
        } else if (aLa) {
            aLa = false;
            this.aLi.no();
        } else {
            this.mVoiceManager = getVoiceManager();
            this.mVoiceManager.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            this.aLi.Ly();
            this.aLB.getSlidingMenu().setSlidingEnabled(true);
            refresh();
            return;
        }
        this.aLi.Lx();
        this.aLB.getSlidingMenu().setSlidingEnabled(false);
        refresh();
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.aLb = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.aLf = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aLf) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    Kx();
                } else {
                    Ky();
                }
            }
        }
    }

    private void Kx() {
        this.aLi.no();
        this.aLB.getSlidingMenu().showContent(false);
    }

    private void Ky() {
        this.aLi.no();
        this.aLB.getSlidingMenu().showContent(false);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            } else {
                com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        } else {
            com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            finish();
        }
    }

    private void initUI() {
        this.aLi.Lw().h(this.aLL);
        this.aLi.Lw().i(this.aLM);
        if (this.aLc == 0) {
            this.aLi.setTitle(this.aLb);
        } else {
            this.aLi.setTitle("");
            this.aLc = 1;
        }
        this.aLB.getSlidingMenu();
        this.aLA.v(this.aLi.getListView());
        this.aLi.a(this.aLQ);
        this.aLi.a(this.aLT);
        this.aLi.j(this.aLR);
        this.aLi.l(this.aLS);
        this.aLi.setOnScrollListener(this.aJZ);
        this.aLi.a(this.HC);
        this.aLi.a(this.aLI);
        this.aLi.f(this.aLO);
        this.aLB.getSlidingMenu().setOnOpenedListener(this.aLU);
        this.aLi.Lw().a(this.aLK);
        if (!this.mIsLogin) {
            this.aLi.Lx();
            this.aLB.getSlidingMenu().setSlidingEnabled(false);
        }
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.aLi.onChangeSkinType(i);
        this.aLB.a(getPageContext(), i);
        this.aLA.a(getPageContext(), i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public com.baidu.adp.lib.e.b<TbImageView> JV() {
        if (this.aLp == null) {
            this.aLp = FrsCommonImageLayout.l(getPageContext().getPageActivity(), 12);
        }
        return this.aLp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gk(String str) {
        Intent J;
        if (str != null && (J = com.baidu.tieba.frs.utils.a.J(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(com.baidu.tieba.t.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", J);
            BarImageView Mt = this.aLA.Mt();
            if (Mt != null && Mt.getBdImage() != null && Mt.getBdImage().mS() != null) {
                Bitmap mS = Mt.getBdImage().mS();
                Float valueOf = Float.valueOf(getResources().getDisplayMetrics().density);
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.e.iK().a(com.baidu.adp.lib.util.e.iK().d(mS, valueOf.intValue() * 48), valueOf.intValue() * 6));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), com.baidu.tieba.p.icon));
            }
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eT(int i) {
        if (!this.mIsLogin) {
            if (this.aLl != null && this.aLl.qK() != null) {
                this.aLl.qK().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.aLl != null) {
            if (i == 0) {
                AntiData qK = this.aLl.qK();
                if (AntiHelper.c(qK) || AntiHelper.d(qK) || AntiHelper.e(qK)) {
                    qK.setBlock_forum_name(this.aLb);
                    qK.setBlock_forum_id(this.aLl.aar().getId());
                    qK.setUser_name(this.aLl.getUserData().getUserName());
                    qK.setUser_id(this.aLl.getUserData().getUserId());
                    if (AntiHelper.a(getPageContext().getPageActivity(), qK, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (this.aLl.qK() != null && this.aLl.qK().getIfpost() == 0) {
                    com.baidu.adp.lib.util.n.showToast(getPageContext().getPageActivity(), qK.getForbid_info());
                    return;
                }
                int i2 = 0;
                if (this.aLl.getUserData() != null) {
                    i2 = this.aLl.getUserData().getIsMem();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(getPageContext().getPageActivity(), 0, this.aLl.aar().getId(), this.aLb, null, null, 0, this.aLl.qK(), 13003, false, false, null, false, false, null, null, this.aLl.aar().getPrefixData(), i2)));
                return;
            }
            this.aLi.Lp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.w wVar) {
        boolean rz = wVar == null ? true : wVar.rz();
        this.aLi.a(new v(this, wVar));
        this.aLi.a(wVar, rz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.w wVar) {
        boolean rz = wVar == null ? true : wVar.rz();
        if (this.mThreadId != null) {
            if (!rz) {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aLb, null, 18003, true, true, this.aLg)));
            } else {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aLb, null, 18003, false, false, this.aLg)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.w wVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aLb, null, 18003, false, false, this.aLg)));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aLi != null && z && this.aKW) {
            this.aKW = false;
            showLoadingView(this.aLi.getRootView(), true);
            this.aLi.Lv();
        }
    }

    public void refresh() {
        stopVoice();
        oy().bb(true);
    }

    private void Kz() {
        switch (this.aLc) {
            case 1:
                com.baidu.adp.lib.g.l.ht().c(new w(this));
                break;
        }
        this.aLc = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KA() {
        stopVoice();
        try {
            if (this.aLl != null) {
                this.aLi.Lm();
                this.aLb = this.aLl.aar().getName();
                this.forumId = this.aLl.aar().getId();
                this.aLi.setTitle(this.aLb);
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.aLl.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.aLl.getUserData().getBimg_end_time());
                Kz();
                ArrayList<com.baidu.adp.widget.ListView.ai> threadList = this.aLl.getThreadList();
                if (threadList != null) {
                    this.aLi.a(threadList, this.aLd, this.aLl, this.aLl.Zp().qR());
                    KC();
                    this.aLA.fh(this.aLd);
                    this.aLA.c(this.aLl);
                    this.aLi.Lq();
                    if (this.aLl.aaw() == 1) {
                        this.aLi.Lw().setFromCDN(true);
                    } else {
                        this.aLi.Lw().setFromCDN(false);
                    }
                    this.aLi.fc(M(oy().getType(), this.aLd));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int M(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.aJP = false;
        this.aLx = false;
        this.aLi.onPause();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.aLl != null && this.aLl.aar() != null) {
            com.baidu.tbadk.distribute.a.yX().a(getPageContext().getPageActivity(), "frs", this.aLl.aar().getId(), 0L);
        }
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.aLe) {
            if (i == 4) {
                if (this.aLB.AX()) {
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
            if (cVar.qw()) {
                com.baidu.tbadk.core.util.bi.tO().b(getPageContext(), new String[]{cVar.Pv});
            } else if (cVar.qv()) {
                if (com.baidu.adp.lib.util.k.iX() && !com.baidu.adp.lib.util.k.iY()) {
                    trim = getPageContext().getString(com.baidu.tieba.t.frs_network_tips);
                } else if (TextUtils.isEmpty(cVar.PH.PN.trim())) {
                    trim = getPageContext().getString(com.baidu.tieba.t.confirm_download_app);
                } else {
                    trim = cVar.PH.PN.trim();
                }
                aVar.cn(trim);
                aVar.a(com.baidu.tieba.t.alert_yes_button, new y(this, cVar, i));
                aVar.b(com.baidu.tieba.t.alert_no_button, new z(this));
                aVar.b(getPageContext()).rL();
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar != null) {
            if (!cVar.qu()) {
                com.baidu.adp.lib.util.n.showToast(getPageContext().getPageActivity(), com.baidu.tieba.t.pb_app_error);
            } else if (UtilHelper.isNetOk()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", cVar.Px);
                com.baidu.tbadk.download.b.ze().a(cVar.Px, cVar.Pw, cVar.Pt, i, com.baidu.adp.lib.g.c.toInt(cVar.Ps, 0));
            } else {
                showToast(com.baidu.tieba.t.neterror);
            }
        }
    }

    public void KB() {
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.aLl.aar().getId(), true, true, true);
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.yX().a(getPageContext().getPageActivity(), cVar, str, "frs", this.aLl.aar().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.yX().a(cVar, this.forumId, 0L, "FRS", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eS(int i) {
        ArrayList<com.baidu.adp.widget.ListView.ai> threadList = this.aLl.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.ai> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.ai next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.w) {
                    com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) next;
                    if (wVar == this.aKX) {
                        a(wVar, i);
                        this.aKX = null;
                        break;
                    } else if (wVar.getId() != null && wVar.getId().equals(this.aJQ)) {
                        a(wVar, i);
                        this.aJQ = null;
                        break;
                    }
                }
            }
            this.aLi.Lw().a(threadList, this.aLl);
            this.aLi.Lw().notifyDataSetChanged();
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

    public void a(ck ckVar, String str) {
        if (str != null) {
            oy().av(ckVar.aPq, str);
            this.aLB.Mx();
            this.aLb = str;
            if (this.aLi != null) {
                this.aLi.setTitle(this.aLb);
            }
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
    @Override // com.baidu.tbadk.core.view.at
    public BdListView getListView() {
        if (this.aLi == null) {
            return null;
        }
        return this.aLi.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.j
    public com.baidu.tbadk.core.voice.i getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void stopVoice() {
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.at
    public int uB() {
        if (this.aLi == null) {
            return 0;
        }
        return this.aLi.Lt();
    }

    @Override // com.baidu.tbadk.core.view.at
    public com.baidu.adp.lib.e.b<TbImageView> uC() {
        if (this.aaj == null) {
            this.aaj = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.aaj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.aLn != null) {
                this.aLn.R(msgReplyme);
                this.aLn.Q(msgAtme);
                if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wx() && !TbadkCoreApplication.m411getInst().isMIUIRom()) {
                    this.aLn.S((msgChat - newsNotifyMessage.getMsgPrivateChat()) - newsNotifyMessage.getMsgStrangerChat());
                } else {
                    this.aLn.S(msgChat);
                }
                this.aLi.a(this.aLn);
                this.aLB.a(this.aLn);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        am Lw;
        HashMap<Integer, com.baidu.tbadk.core.data.w> KR;
        if (this.aLl != null && this.aLi != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (Lw = this.aLi.Lw()) != null && (KR = Lw.KR()) != null && KR.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.w> entry : KR.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.w value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.c) && TextUtils.equals(((com.baidu.tbadk.core.data.c) value).Px, downloadData.getId())) {
                            int amH = this.aLl.amH();
                            if (Lw.ay(intValue + amH) instanceof com.baidu.tbadk.core.data.c) {
                                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) Lw.ay(amH + intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    cVar.Pr = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!com.baidu.tbadk.core.util.bb.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    cVar.Pr = 0;
                                } else if (status == 1) {
                                    cVar.Pr = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.aLi.Ln();
        }
    }

    private void KC() {
        HashMap<Integer, com.baidu.tbadk.core.data.w> KR;
        if (this.aLi != null && this.aLi.Lw() != null && (KR = this.aLi.Lw().KR()) != null) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.w> entry : KR.entrySet()) {
                com.baidu.tbadk.core.data.w value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.c)) {
                    arrayList.add((com.baidu.tbadk.core.data.c) value);
                }
            }
            com.baidu.tbadk.download.b.ze().q(arrayList);
        }
    }

    public void KD() {
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
            int i2 = cVar.Pr;
            if (i2 == 0) {
                a(cVar, i);
            } else if (i2 == 2) {
                com.baidu.tieba.frs.utils.a.G(getPageContext().getPageActivity(), cVar.Px);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", cVar.Px);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.c cVar) {
        if (cVar != null) {
            a(cVar, "btn_click");
            b(cVar, "click");
            com.baidu.tbadk.core.util.bi.tO().b(getPageContext(), new String[]{cVar.Pv});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.aLi.getRootView());
        showLoadingView(this.aLi.getRootView(), true);
        this.aLi.Lv();
        this.aLi.no();
    }

    public com.baidu.tieba.tbadkCore.w KE() {
        return this.aLl;
    }

    public boolean KF() {
        return this.aLi.KF();
    }

    public boolean KG() {
        return this.Jf;
    }

    public void KH() {
        FrsActivityStatic.aMf = false;
        FrsActivityStatic.aMh = false;
        Ku();
    }

    public void KI() {
        FrsActivityStatic.aMf = false;
        FrsActivityStatic.aMg = false;
        Ku();
    }

    public com.baidu.tbadk.coreExtra.view.b KJ() {
        return this.aLi.aOh;
    }

    public void KK() {
        this.aLA.KK();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: KL */
    public com.baidu.tieba.frs.b.a oy() {
        if (this.aLy == null) {
            this.aLy = new com.baidu.tieba.frs.b.a(this);
        }
        return this.aLy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: KM */
    public com.baidu.tieba.frs.c.n oA() {
        if (this.aLz == null) {
            this.aLz = new com.baidu.tieba.frs.c.n(this);
            this.aLB = new com.baidu.tieba.frs.c.k(this);
            this.aLA = new com.baidu.tieba.frs.c.a(this);
        }
        return this.aLz;
    }

    public void a(bf bfVar) {
        this.aLi = bfVar;
    }

    public void gl(String str) {
        this.aLb = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFlag(int i) {
        this.aLc = i;
    }

    public void setPn(int i) {
        this.aLd = i;
    }

    public void resetData() {
        this.aKY = false;
        this.aLh = false;
        this.aLl = null;
        this.aLi.setTitle(this.aLb);
        this.aLB.cg(false);
        this.aLB.setIsManager(false);
        this.aLB.e(new com.baidu.tieba.tbadkCore.w());
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.n.isNetOk()) {
            this.aLi.LD();
            return;
        }
        KN();
        if (!this.aLC.aoe && !this.aLy.isLoading()) {
            if (this.aLC.Y(this.aLl.amt())) {
                this.aLi.a(this.aLC.LQ(), this.aLd, this.aLl, 0);
                this.aLC.a(com.baidu.adp.lib.g.c.c(this.forumId, 0L), this.aLl.amt());
            } else if (this.aLD != 0) {
                this.aLi.a(this.aLC.LQ(), this.aLd, this.aLl, 0);
                this.aLd++;
                this.aLy.fe(this.aLd);
                this.aLC.aPt = false;
                this.aLC.aPu = 0;
            }
        }
    }

    public void onFailed(String str) {
        KN();
        showToast(str);
    }

    public void v(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.ai> a;
        KN();
        if (arrayList != null && arrayList.size() != 0 && (a = this.aLC.a(false, arrayList)) != null) {
            this.aLl.R(a);
            this.aLi.a(a, this.aLd, this.aLl, 0);
        }
    }

    private void KN() {
        if (this.aLD == 0 && !this.aLC.Y(this.aLl.amt())) {
            if (this.aLl.getThreadList() == null || this.aLl.getThreadList().size() == 0) {
                this.aLi.LD();
                return;
            } else {
                this.aLi.LC();
                return;
            }
        }
        this.aLi.LB();
    }
}
