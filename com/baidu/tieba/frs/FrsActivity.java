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
    public static String aKW;
    public static boolean aLb = false;
    public static volatile long aLs = 0;
    public static volatile long aLt = 0;
    public static volatile int aLu = 0;
    private static boolean isNeedRefreshOnResume = false;
    private boolean aJQ;
    private String aJR;
    private com.baidu.tbadk.core.data.w aKY;
    private com.baidu.tieba.frs.c.n aLA;
    private com.baidu.tieba.frs.c.a aLB;
    private com.baidu.tieba.frs.c.k aLC;
    private com.baidu.tieba.frs.loadmore.a aLD;
    private ce aLo;
    private com.baidu.adp.lib.e.b<TbImageView> aLq;
    private ag aLx;
    private com.baidu.tieba.frs.b.a aLz;
    private com.baidu.adp.lib.e.b<TbImageView> aaj;
    VoiceManager mVoiceManager;
    private boolean aKX = true;
    private boolean aKZ = false;
    public boolean aLa = false;
    private String aLc = null;
    private String mFrom = null;
    private int aLd = 0;
    private int aLe = 1;
    private boolean aLf = false;
    private boolean aLg = false;
    private String mThreadId = null;
    private String forumId = null;
    private boolean aLh = false;
    private boolean aLi = false;
    private bf aLj = null;
    private final com.baidu.tbadk.core.data.w aLk = null;
    private boolean aLl = false;
    private com.baidu.tieba.tbadkCore.w aLm = new com.baidu.tieba.tbadkCore.w();
    private com.baidu.tieba.tbadkCore.e aLn = null;
    private com.baidu.tbadk.core.data.w aLp = null;
    private boolean Jf = false;
    public long aEQ = -1;
    public long aqD = 0;
    public long createTime = 0;
    public long aLr = -1;
    private boolean aLv = false;
    public com.baidu.tbadk.performanceLog.h aLw = null;
    private boolean aLy = true;
    private int aLE = -1;
    private CustomMessageListener aJW = new a(this, 2004004);
    private CustomMessageListener aLF = new l(this, 2001273);
    private CustomMessageListener aAN = new x(this, 2001197);
    public final CustomMessageListener aLG = new aa(this, 2012111);
    public final com.baidu.tieba.tbadkCore.aa aLH = new ab(this);
    private final CustomMessageListener OQ = new ac(this, 2003003);
    private final CustomMessageListener mMemListener = new ad(this, 2001200);
    private final com.baidu.adp.framework.listener.a aLI = new ae(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    private final com.baidu.tbadk.core.view.aj aLJ = new af(this);
    private final com.baidu.adp.widget.ListView.z HC = new b(this);
    public final View.OnClickListener aLK = new c(this);
    private final AbsListView.OnScrollListener aKa = new d(this);
    private final an aLL = new e(this);
    private final com.baidu.tieba.tbadkCore.ar aKc = new com.baidu.tieba.tbadkCore.ar(getPageContext(), new f(this));
    private final View.OnClickListener aLM = new g(this);
    private final View.OnClickListener aLN = new h(this);
    public final AdapterView.OnItemClickListener aLO = new i(this);
    private final com.baidu.tbadk.core.view.ad aLP = new j(this);
    private final CustomMessageListener aLQ = new k(this, 0);
    private com.baidu.adp.widget.ListView.aj aLR = new m(this);
    private View.OnClickListener aLS = new o(this);
    private View.OnClickListener aLT = new p(this);
    private com.baidu.adp.widget.ListView.ak aLU = new q(this);
    private final SlidingMenu.OnOpenedListener aLV = new r(this);
    public final com.baidu.adp.base.i aLW = new s(this);
    public final com.baidu.adp.base.i aLX = new t(this);

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity
    protected void a(ErrorData errorData) {
        this.aLj.bY(false);
        this.aLj.bZ(false);
        this.aLj.ca(false);
        this.aLj.Lo();
        hideLoadingView(this.aLj.getRootView());
        this.aLj.Lv();
        if (!this.aLi) {
            com.baidu.tieba.tbadkCore.h LZ = oy().LZ();
            if (!this.aKZ) {
                if (LZ != null) {
                    if (LZ.coI) {
                        if (340001 == LZ.errorCode) {
                            showNetRefreshViewNoClick(this.aLj.getRootView(), getPageContext().getResources().getString(com.baidu.tieba.t.net_error_text, LZ.errorMsg, Integer.valueOf(LZ.errorCode)), true);
                        } else {
                            showNetRefreshView(this.aLj.getRootView(), getPageContext().getResources().getString(com.baidu.tieba.t.net_error_text, LZ.errorMsg, Integer.valueOf(LZ.errorCode)), true);
                        }
                    } else if (340001 == LZ.errorCode) {
                        showNetRefreshViewNoClick(this.aLj.getRootView(), LZ.errorMsg, true);
                    } else {
                        showNetRefreshView(this.aLj.getRootView(), LZ.errorMsg, true);
                    }
                    this.aLj.fd(8);
                }
            } else if (LZ != null && LZ.coI) {
                this.aLj.fd(0);
                showToast(getPageContext().getResources().getString(com.baidu.tieba.t.net_error_text, LZ.errorMsg, Integer.valueOf(LZ.errorCode)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.u uVar) {
        if (uVar != null) {
            try {
                this.aKX = false;
                this.aLm.d(uVar);
                if (this.aLm.aax() == 1) {
                    this.aLj.Lx().setFromCDN(true);
                } else {
                    this.aLj.Lx().setFromCDN(false);
                }
                this.aLE = this.aLm.Zq().qR();
                this.aLj.a(this.aLm.aas(), this.aLm.getUserData());
                this.aLB.f(this.aLm.amq().amA() == 1, this.aLm.getUserData().getIsMem(), this.aLm.aas().isLike());
                this.aLj.Ln();
                this.aLc = this.aLm.aas().getName();
                this.forumId = this.aLm.aas().getId();
                this.aLj.setTitle(this.aLc);
                KA();
                this.aLm.amK();
                this.aLm.aG(getPageContext().getPageActivity());
                this.aLm.amM();
                this.aLj.b(this.aLm);
                if (!oy().LX()) {
                    this.aLm.amL();
                }
                com.baidu.tbadk.core.data.y top_notice_data = this.aLm.aas().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.getTitle() != null) {
                    com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                    wVar.setTitle(top_notice_data.getTitle());
                    wVar.bq(2);
                    wVar.ch(top_notice_data.rE());
                    wVar.parser_title();
                    this.aLm.e(wVar);
                }
                ArrayList<com.baidu.adp.widget.ListView.ai> threadList = this.aLm.getThreadList();
                if (threadList != null) {
                    ArrayList<com.baidu.adp.widget.ListView.ai> a = this.aLD.a(true, threadList);
                    if (a != null) {
                        this.aLm.R(a);
                    }
                    this.aLj.a(threadList, this.aLe, this.aLm, this.aLm.Zq().qR());
                    KD();
                    this.aLB.fh(this.aLe);
                    this.aLB.c(this.aLm);
                    this.aLj.Lr();
                    this.aLj.fc(0);
                }
                this.aLB.cf(this.aLm.amr());
                hideLoadingView(this.aLj.getRootView());
                this.aLj.Lv();
                this.aKZ = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        aKW = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (intent != null) {
            this.aEQ = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aEQ = System.currentTimeMillis();
        }
        if (this.aEQ != -1) {
            this.aLr = this.aEQ;
        } else {
            this.aLr = System.currentTimeMillis();
        }
        if (!bU(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.aLr;
            return;
        }
        super.onCreate(bundle);
        AM().addEventDelegate(this);
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        this.aKc.setUniqueId(getUniqueId());
        this.aKc.registerListener();
        addGlobalLayoutListener();
        Ku();
        registerListener(this.OQ);
        registerListener(this.mMemListener);
        registerListener(this.aLG);
        registerListener(this.aJW);
        registerListener(this.aAN);
        registerListener(this.aLF);
        this.aLI.eS().setSelfListener(true);
        this.aLI.eR().setSelfListener(true);
        this.aLI.setTag(getUniqueId());
        registerListener(this.aLI);
        this.aLD = new com.baidu.tieba.frs.loadmore.a(this);
        this.aLD.registerListener();
        this.createTime = System.currentTimeMillis() - this.aEQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
        } else if (this.aLm != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null && this.aLj != null) {
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
            this.aLm.a(oVar);
            ArrayList<com.baidu.adp.widget.ListView.ai> a = this.aLD.a(true, this.aLm.getThreadList());
            if (a != null) {
                this.aLm.R(a);
                this.aLj.a(a, this.aLe, this.aLm, this.aLE);
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

    private void Ku() {
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
        Kw();
        if (bundle != null) {
            this.aLc = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aLd = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.aLc = intent.getStringExtra("name");
                this.mFrom = intent.getStringExtra("from");
                this.aLd = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            setSwipeBackEnabled(false);
        }
        this.aLo = new ce(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            Kv();
            Kx();
        }
        this.aLB.g(bundle);
    }

    public void Kv() {
        if (this.aLo != null && this.aLj != null) {
            if (FrsActivityStatic.aMg || FrsActivityStatic.aMh || FrsActivityStatic.aMi) {
                this.aLo.R(com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgReplyme());
                this.aLo.Q(com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgAtme());
                int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.vJ().getMsgChat();
                if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wx() && !TbadkCoreApplication.m411getInst().isMIUIRom()) {
                    msgChat -= com.baidu.tbadk.coreExtra.messageCenter.a.vJ().vQ();
                }
                this.aLo.S(msgChat);
                this.aLj.a(this.aLo);
                this.aLC.a(this.aLo);
            }
        }
    }

    private void Kw() {
        registerListener(2001122, this.aLQ);
    }

    private void Kx() {
        registerListener(2001124, this.aLQ);
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
        if (this.aLj != null) {
            this.aLj.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.aLn != null) {
                this.aLn.clear();
            }
            if (this.aLw != null) {
                this.aLw.onDestroy();
            }
            this.aLj.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.aLB.onActivityDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
        if (this.aLx != null) {
            this.aLx.cancel(true);
            this.aLx = null;
        }
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aLc);
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
                    this.aLB.oF();
                    return;
                case 11011:
                    b(this.aLk);
                    return;
                case 11012:
                    c(this.aLp);
                    return;
                case 11014:
                    this.aLB.Mv();
                    return;
                case 11016:
                    this.aLj.Lq();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    this.aLB.KL();
                    return;
                case 13003:
                    if (intent != null && !oy().LX()) {
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
                    this.aLj.Lx().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (js = this.aLm.js(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            js.br(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            js.parser_title();
                            refresh();
                            return;
                        } else if (intExtra == 0) {
                            this.aLm.f(js);
                            this.aLj.Lr();
                            if (com.baidu.tieba.tbadkCore.d.amp() != null) {
                                com.baidu.tieba.tbadkCore.d.amp().D(this.aLc, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    KC();
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
        this.aLC.Mz();
        this.aJQ = true;
        this.aLy = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.aLj.no();
        } else if (aLb) {
            aLb = false;
            this.aLj.no();
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
            this.aLj.Lz();
            this.aLC.getSlidingMenu().setSlidingEnabled(true);
            refresh();
            return;
        }
        this.aLj.Ly();
        this.aLC.getSlidingMenu().setSlidingEnabled(false);
        refresh();
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.aLc = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.aLg = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aLg) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    Ky();
                } else {
                    Kz();
                }
            }
        }
    }

    private void Ky() {
        this.aLj.no();
        this.aLC.getSlidingMenu().showContent(false);
    }

    private void Kz() {
        this.aLj.no();
        this.aLC.getSlidingMenu().showContent(false);
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
        this.aLj.Lx().h(this.aLM);
        this.aLj.Lx().i(this.aLN);
        if (this.aLd == 0) {
            this.aLj.setTitle(this.aLc);
        } else {
            this.aLj.setTitle("");
            this.aLd = 1;
        }
        this.aLC.getSlidingMenu();
        this.aLB.v(this.aLj.getListView());
        this.aLj.a(this.aLR);
        this.aLj.a(this.aLU);
        this.aLj.j(this.aLS);
        this.aLj.l(this.aLT);
        this.aLj.setOnScrollListener(this.aKa);
        this.aLj.a(this.HC);
        this.aLj.a(this.aLJ);
        this.aLj.f(this.aLP);
        this.aLC.getSlidingMenu().setOnOpenedListener(this.aLV);
        this.aLj.Lx().a(this.aLL);
        if (!this.mIsLogin) {
            this.aLj.Ly();
            this.aLC.getSlidingMenu().setSlidingEnabled(false);
        }
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.aLj.onChangeSkinType(i);
        this.aLC.a(getPageContext(), i);
        this.aLB.a(getPageContext(), i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public com.baidu.adp.lib.e.b<TbImageView> JW() {
        if (this.aLq == null) {
            this.aLq = FrsCommonImageLayout.l(getPageContext().getPageActivity(), 12);
        }
        return this.aLq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gk(String str) {
        Intent J;
        if (str != null && (J = com.baidu.tieba.frs.utils.a.J(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(com.baidu.tieba.t.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", J);
            BarImageView Mu = this.aLB.Mu();
            if (Mu != null && Mu.getBdImage() != null && Mu.getBdImage().mS() != null) {
                Bitmap mS = Mu.getBdImage().mS();
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
            if (this.aLm != null && this.aLm.qK() != null) {
                this.aLm.qK().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.aLm != null) {
            if (i == 0) {
                AntiData qK = this.aLm.qK();
                if (AntiHelper.c(qK) || AntiHelper.d(qK) || AntiHelper.e(qK)) {
                    qK.setBlock_forum_name(this.aLc);
                    qK.setBlock_forum_id(this.aLm.aas().getId());
                    qK.setUser_name(this.aLm.getUserData().getUserName());
                    qK.setUser_id(this.aLm.getUserData().getUserId());
                    if (AntiHelper.a(getPageContext().getPageActivity(), qK, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (this.aLm.qK() != null && this.aLm.qK().getIfpost() == 0) {
                    com.baidu.adp.lib.util.n.showToast(getPageContext().getPageActivity(), qK.getForbid_info());
                    return;
                }
                int i2 = 0;
                if (this.aLm.getUserData() != null) {
                    i2 = this.aLm.getUserData().getIsMem();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(getPageContext().getPageActivity(), 0, this.aLm.aas().getId(), this.aLc, null, null, 0, this.aLm.qK(), 13003, false, false, null, false, false, null, null, this.aLm.aas().getPrefixData(), i2)));
                return;
            }
            this.aLj.Lq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.w wVar) {
        boolean rz = wVar == null ? true : wVar.rz();
        this.aLj.a(new v(this, wVar));
        this.aLj.a(wVar, rz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.w wVar) {
        boolean rz = wVar == null ? true : wVar.rz();
        if (this.mThreadId != null) {
            if (!rz) {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aLc, null, 18003, true, true, this.aLh)));
            } else {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aLc, null, 18003, false, false, this.aLh)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.w wVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aLc, null, 18003, false, false, this.aLh)));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aLj != null && z && this.aKX) {
            this.aKX = false;
            showLoadingView(this.aLj.getRootView(), true);
            this.aLj.Lw();
        }
    }

    public void refresh() {
        stopVoice();
        oy().bb(true);
    }

    private void KA() {
        switch (this.aLd) {
            case 1:
                com.baidu.adp.lib.g.l.ht().c(new w(this));
                break;
        }
        this.aLd = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KB() {
        stopVoice();
        try {
            if (this.aLm != null) {
                this.aLj.Ln();
                this.aLc = this.aLm.aas().getName();
                this.forumId = this.aLm.aas().getId();
                this.aLj.setTitle(this.aLc);
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.aLm.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.aLm.getUserData().getBimg_end_time());
                KA();
                ArrayList<com.baidu.adp.widget.ListView.ai> threadList = this.aLm.getThreadList();
                if (threadList != null) {
                    this.aLj.a(threadList, this.aLe, this.aLm, this.aLm.Zq().qR());
                    KD();
                    this.aLB.fh(this.aLe);
                    this.aLB.c(this.aLm);
                    this.aLj.Lr();
                    if (this.aLm.aax() == 1) {
                        this.aLj.Lx().setFromCDN(true);
                    } else {
                        this.aLj.Lx().setFromCDN(false);
                    }
                    this.aLj.fc(M(oy().getType(), this.aLe));
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
        this.aJQ = false;
        this.aLy = false;
        this.aLj.onPause();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
    }

    @Override // com.baidu.tbadk.mvc.core.MvcActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.aLm != null && this.aLm.aas() != null) {
            com.baidu.tbadk.distribute.a.yY().a(getPageContext().getPageActivity(), "frs", this.aLm.aas().getId(), 0L);
        }
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.aLf) {
            if (i == 4) {
                if (this.aLC.AY()) {
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
                com.baidu.tbadk.download.b.zf().a(cVar.Px, cVar.Pw, cVar.Pt, i, com.baidu.adp.lib.g.c.toInt(cVar.Ps, 0));
            } else {
                showToast(com.baidu.tieba.t.neterror);
            }
        }
    }

    public void KC() {
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.aLm.aas().getId(), true, true, true);
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.yY().a(getPageContext().getPageActivity(), cVar, str, "frs", this.aLm.aas().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.yY().a(cVar, this.forumId, 0L, "FRS", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eS(int i) {
        ArrayList<com.baidu.adp.widget.ListView.ai> threadList = this.aLm.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.ai> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.ai next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.w) {
                    com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) next;
                    if (wVar == this.aKY) {
                        a(wVar, i);
                        this.aKY = null;
                        break;
                    } else if (wVar.getId() != null && wVar.getId().equals(this.aJR)) {
                        a(wVar, i);
                        this.aJR = null;
                        break;
                    }
                }
            }
            this.aLj.Lx().a(threadList, this.aLm);
            this.aLj.Lx().notifyDataSetChanged();
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
            oy().av(ckVar.aPr, str);
            this.aLC.My();
            this.aLc = str;
            if (this.aLj != null) {
                this.aLj.setTitle(this.aLc);
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
        if (this.aLj == null) {
            return null;
        }
        return this.aLj.getListView();
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
        if (this.aLj == null) {
            return 0;
        }
        return this.aLj.Lu();
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
            if (this.aLo != null) {
                this.aLo.R(msgReplyme);
                this.aLo.Q(msgAtme);
                if (com.baidu.tbadk.coreExtra.messageCenter.c.wg().wx() && !TbadkCoreApplication.m411getInst().isMIUIRom()) {
                    this.aLo.S((msgChat - newsNotifyMessage.getMsgPrivateChat()) - newsNotifyMessage.getMsgStrangerChat());
                } else {
                    this.aLo.S(msgChat);
                }
                this.aLj.a(this.aLo);
                this.aLC.a(this.aLo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        am Lx;
        HashMap<Integer, com.baidu.tbadk.core.data.w> KS;
        if (this.aLm != null && this.aLj != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (Lx = this.aLj.Lx()) != null && (KS = Lx.KS()) != null && KS.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.w> entry : KS.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.w value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.c) && TextUtils.equals(((com.baidu.tbadk.core.data.c) value).Px, downloadData.getId())) {
                            int amI = this.aLm.amI();
                            if (Lx.ay(intValue + amI) instanceof com.baidu.tbadk.core.data.c) {
                                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) Lx.ay(amI + intValue);
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
            this.aLj.Lo();
        }
    }

    private void KD() {
        HashMap<Integer, com.baidu.tbadk.core.data.w> KS;
        if (this.aLj != null && this.aLj.Lx() != null && (KS = this.aLj.Lx().KS()) != null) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.w> entry : KS.entrySet()) {
                com.baidu.tbadk.core.data.w value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.c)) {
                    arrayList.add((com.baidu.tbadk.core.data.c) value);
                }
            }
            com.baidu.tbadk.download.b.zf().q(arrayList);
        }
    }

    public void KE() {
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
        hideNetRefreshView(this.aLj.getRootView());
        showLoadingView(this.aLj.getRootView(), true);
        this.aLj.Lw();
        this.aLj.no();
    }

    public com.baidu.tieba.tbadkCore.w KF() {
        return this.aLm;
    }

    public boolean KG() {
        return this.aLj.KG();
    }

    public boolean KH() {
        return this.Jf;
    }

    public void KI() {
        FrsActivityStatic.aMg = false;
        FrsActivityStatic.aMi = false;
        Kv();
    }

    public void KJ() {
        FrsActivityStatic.aMg = false;
        FrsActivityStatic.aMh = false;
        Kv();
    }

    public com.baidu.tbadk.coreExtra.view.b KK() {
        return this.aLj.aOi;
    }

    public void KL() {
        this.aLB.KL();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: KM */
    public com.baidu.tieba.frs.b.a oy() {
        if (this.aLz == null) {
            this.aLz = new com.baidu.tieba.frs.b.a(this);
        }
        return this.aLz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.core.e
    /* renamed from: KN */
    public com.baidu.tieba.frs.c.n oA() {
        if (this.aLA == null) {
            this.aLA = new com.baidu.tieba.frs.c.n(this);
            this.aLC = new com.baidu.tieba.frs.c.k(this);
            this.aLB = new com.baidu.tieba.frs.c.a(this);
        }
        return this.aLA;
    }

    public void a(bf bfVar) {
        this.aLj = bfVar;
    }

    public void gl(String str) {
        this.aLc = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFlag(int i) {
        this.aLd = i;
    }

    public void setPn(int i) {
        this.aLe = i;
    }

    public void resetData() {
        this.aKZ = false;
        this.aLi = false;
        this.aLm = null;
        this.aLj.setTitle(this.aLc);
        this.aLC.cg(false);
        this.aLC.setIsManager(false);
        this.aLC.e(new com.baidu.tieba.tbadkCore.w());
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.n.isNetOk()) {
            this.aLj.LE();
            return;
        }
        KO();
        if (!this.aLD.aoe && !this.aLz.isLoading()) {
            if (this.aLD.Y(this.aLm.amu())) {
                this.aLj.a(this.aLD.LR(), this.aLe, this.aLm, 0);
                this.aLD.a(com.baidu.adp.lib.g.c.c(this.forumId, 0L), this.aLm.amu());
            } else if (this.aLE != 0) {
                this.aLj.a(this.aLD.LR(), this.aLe, this.aLm, 0);
                this.aLe++;
                this.aLz.fe(this.aLe);
                this.aLD.aPu = false;
                this.aLD.aPv = 0;
            }
        }
    }

    public void onFailed(String str) {
        KO();
        showToast(str);
    }

    public void v(ArrayList<com.baidu.adp.widget.ListView.ai> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.ai> a;
        KO();
        if (arrayList != null && arrayList.size() != 0 && (a = this.aLD.a(false, arrayList)) != null) {
            this.aLm.R(a);
            this.aLj.a(a, this.aLe, this.aLm, 0);
        }
    }

    private void KO() {
        if (this.aLE == 0 && !this.aLD.Y(this.aLm.amu())) {
            if (this.aLm.getThreadList() == null || this.aLm.getThreadList().size() == 0) {
                this.aLj.LE();
                return;
            } else {
                this.aLj.LD();
                return;
            }
        }
        this.aLj.LC();
    }
}
