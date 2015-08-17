package com.baidu.tieba.frs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.dg;
import com.baidu.tieba.i;
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
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
/* loaded from: classes.dex */
public class FrsActivity extends BaseActivity<FrsActivity> implements BdListView.e, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c {
    public static String aUi;
    private boolean aTe;
    private String aTf;
    private com.baidu.adp.lib.e.b<TbImageView> aUB;
    private a aUI;
    private com.baidu.tieba.frs.b.a aUK;
    private com.baidu.tieba.frs.c.n aUL;
    private com.baidu.tieba.frs.c.a aUM;
    private com.baidu.tieba.frs.c.k aUN;
    private com.baidu.tieba.frs.loadmore.a aUO;
    private b aUQ;
    private com.baidu.tbadk.core.data.v aUl;
    private boolean aUp;
    private cn aUz;
    private com.baidu.adp.lib.e.b<TbImageView> afk;
    VoiceManager mVoiceManager;
    private static final int aUj = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90);
    private static final int aUk = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds300);
    public static boolean aUo = false;
    public static volatile long aUD = 0;
    public static volatile long aUE = 0;
    public static volatile int aUF = 0;
    private static boolean isNeedRefreshOnResume = false;
    private boolean aUm = false;
    public boolean aUn = false;
    public String aUq = null;
    public String mFrom = null;
    public int aUr = 0;
    private int mPn = 1;
    private boolean aUs = false;
    private boolean aUt = false;
    private String mThreadId = null;
    private String forumId = null;
    private boolean aUu = false;
    private boolean aUv = false;
    private bl aUw = null;
    private final com.baidu.tbadk.core.data.v aUx = null;
    private com.baidu.tieba.tbadkCore.n aUy = new com.baidu.tieba.tbadkCore.n();
    private com.baidu.tbadk.core.data.v aUA = null;
    private boolean Ji = false;
    public long aMq = -1;
    public long axq = 0;
    public long createTime = 0;
    public long aUC = -1;
    private boolean aUG = false;
    public com.baidu.tbadk.performanceLog.e aUH = null;
    private boolean aUJ = true;
    private int aUP = -1;
    private dc aUR = new com.baidu.tieba.frs.a(this);
    private db aUS = new l(this);
    private CustomMessageListener aTk = new x(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener aRR = new ad(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
    private CustomMessageListener aIi = new ae(this, CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND);
    public final CustomMessageListener aUT = new af(this, CmdConfigCustom.MSG_NEW);
    private CustomMessageListener aUU = new ag(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    public final com.baidu.tieba.tbadkCore.q aUV = new ah(this);
    private final CustomMessageListener TE = new ai(this, CmdConfigCustom.CMD_REFRESH);
    private final CustomMessageListener mMemListener = new com.baidu.tieba.frs.b(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private final com.baidu.adp.framework.listener.a aUW = new c(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    private final x.a aUX = new d(this);
    private final BdListView.g HD = new e(this);
    public final View.OnClickListener aUY = new f(this);
    private final AbsListView.OnScrollListener aTm = new g(this);
    private final au aUZ = new h(this);
    private final com.baidu.tieba.tbadkCore.ad aTo = new com.baidu.tieba.tbadkCore.ad(getPageContext(), new i(this));
    private final View.OnClickListener aVa = new j(this);
    private final View.OnClickListener aVb = new k(this);
    public final AdapterView.OnItemClickListener aVc = new m(this);
    private final NoNetworkView.a aSF = new n(this);
    private final CustomMessageListener aVd = new o(this, 0);
    private com.baidu.adp.widget.ListView.v aVe = new p(this);
    private View.OnClickListener aVf = new r(this);
    private View.OnClickListener aVg = new s(this);
    private com.baidu.adp.widget.ListView.w aVh = new t(this);
    private final SlidingMenu.OnOpenedListener aVi = new u(this);
    public final com.baidu.adp.base.g aVj = new v(this);
    public final com.baidu.adp.base.g aVk = new w(this);

    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    public void a(ErrorData errorData) {
        this.aUw.ca(false);
        this.aUw.cb(false);
        this.aUw.cc(false);
        this.aUw.Ma();
        hideLoadingView(this.aUw.getRootView());
        this.aUw.Mh();
        if (!this.aUv) {
            d.a Ne = Lz().Ne();
            if (!this.aUm) {
                if (Ne != null) {
                    if (Ne.cGF) {
                        if (340001 == Ne.errorCode) {
                            showNetRefreshViewNoClick(this.aUw.getRootView(), getPageContext().getResources().getString(i.C0057i.net_error_text, Ne.errorMsg, Integer.valueOf(Ne.errorCode)), true);
                        } else {
                            showNetRefreshView(this.aUw.getRootView(), getPageContext().getResources().getString(i.C0057i.net_error_text, Ne.errorMsg, Integer.valueOf(Ne.errorCode)), true);
                        }
                    } else if (340001 == Ne.errorCode) {
                        showNetRefreshViewNoClick(this.aUw.getRootView(), Ne.errorMsg, true);
                    } else {
                        showNetRefreshView(this.aUw.getRootView(), Ne.errorMsg, true);
                    }
                    this.aUw.fq(8);
                }
            } else if (Ne != null && Ne.cGF) {
                this.aUw.fq(0);
                showToast(getPageContext().getResources().getString(i.C0057i.net_error_text, Ne.errorMsg, Integer.valueOf(Ne.errorCode)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.l lVar) {
        boolean z;
        if (lVar != null) {
            try {
                this.aUy.d(lVar);
                if (this.aUy.acL() == 1) {
                    this.aUw.Mj().setFromCDN(true);
                } else {
                    this.aUw.Mj().setFromCDN(false);
                }
                this.aUP = this.aUy.getPage().rT();
                this.aUw.b(this.aUy.acG(), this.aUy.getUserData());
                if (this.aUy.apc() == null) {
                    z = false;
                } else {
                    z = this.aUy.apc().size() != 0;
                }
                this.aUM.a(this.aUy.aoR().apd() == 1, this.aUy.getUserData().getIsMem(), this.aUy.acG().isLike(), z);
                this.aUw.LZ();
                this.aUq = this.aUy.acG().getName();
                this.forumId = this.aUy.acG().getId();
                this.aUw.setTitle(this.aUq);
                Lo();
                this.aUy.apk();
                this.aUy.aN(getPageContext().getPageActivity());
                this.aUy.apm();
                this.aUw.b(this.aUy);
                if (!Lz().Nd()) {
                    this.aUy.apl();
                }
                com.baidu.tbadk.core.data.x top_notice_data = this.aUy.acG().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.getTitle() != null) {
                    com.baidu.tbadk.core.data.v vVar = new com.baidu.tbadk.core.data.v();
                    vVar.setTitle(top_notice_data.getTitle());
                    vVar.bz(2);
                    vVar.ch(top_notice_data.sI());
                    vVar.parser_title();
                    this.aUy.e(vVar);
                }
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aUy.getThreadList();
                if (threadList != null) {
                    ArrayList<com.baidu.adp.widget.ListView.u> a2 = this.aUO.a(true, threadList);
                    if (a2 != null) {
                        this.aUy.X(a2);
                    }
                    this.aUw.a(threadList, this.mPn, this.aUy, this.aUy.getPage().rT());
                    Ls();
                    this.aUM.fG(this.mPn);
                    this.aUM.d(this.aUy);
                    this.aUw.Md();
                    this.aUw.fp(0);
                }
                this.aUM.ch(this.aUy.aoT());
                hideLoadingView(this.aUw.getRootView());
                this.aUw.Mh();
                this.aUm = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        aUi = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (intent != null) {
            this.aMq = intent.getLongExtra("TibaStatic.StartTime", -1L);
            if (intent.getData() != null) {
                Uri data = intent.getData();
                this.aUq = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.aUq)) {
                    intent.putExtra("name", this.aUq);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
        } else {
            this.aMq = System.currentTimeMillis();
        }
        if (this.aMq != -1) {
            this.aUC = this.aMq;
        } else {
            this.aUC = System.currentTimeMillis();
        }
        if (!bX(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.aUC;
            return;
        }
        super.onCreate(bundle);
        setContentView(i.g.frs_activity);
        this.aUK = new com.baidu.tieba.frs.b.a(this);
        this.aUK.a(this.aUR);
        this.aUK.init();
        this.aUL = new com.baidu.tieba.frs.c.n(this);
        this.aUN = new com.baidu.tieba.frs.c.k(this);
        this.aUM = new com.baidu.tieba.frs.c.a(this, this.aUL);
        this.aUL.oS();
        if (getIntent() != null) {
            this.aUK.f(getIntent().getExtras());
            this.aUM.h(getIntent().getExtras());
        } else if (bundle != null) {
            this.aUK.f(bundle);
            this.aUM.h(bundle);
        } else {
            this.aUK.f(null);
            this.aUM.h((Bundle) null);
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        this.aTo.setUniqueId(getUniqueId());
        this.aTo.registerListener();
        addGlobalLayoutListener();
        Li();
        registerListener(this.TE);
        registerListener(this.mMemListener);
        registerListener(this.aUT);
        registerListener(this.aTk);
        registerListener(this.aIi);
        registerListener(this.aRR);
        registerListener(this.aUU);
        this.aUW.eT().setSelfListener(true);
        this.aUW.eS().setSelfListener(true);
        this.aUW.setTag(getUniqueId());
        registerListener(this.aUW);
        this.aUO = new com.baidu.tieba.frs.loadmore.a(this);
        this.aUO.registerListener();
        Lz().oT();
        this.createTime = System.currentTimeMillis() - this.aMq;
        if (this.aUw != null) {
            showLoadingView(this.aUw.getRootView(), true);
            this.aUw.Mi();
        }
        this.aUQ = new b(this, null);
        registerReceiver(this.aUQ, new IntentFilter("com.android.launcher.action.INSTALL_SHORTCUT"));
    }

    /* loaded from: classes.dex */
    private class b extends BroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(FrsActivity frsActivity, b bVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!StringUtils.isNULL(action) && "com.android.launcher.action.INSTALL_SHORTCUT".equals(action)) {
                String str = Build.MODEL;
                if (!TextUtils.isEmpty(str) && str.startsWith("MI")) {
                    FrsActivity.this.showToast(String.format(FrsActivity.this.getPageContext().getString(i.C0057i.shortcut_add_str), new StringBuilder(String.valueOf(intent.getStringExtra("android.intent.extra.shortcut.NAME"))).toString()));
                    return;
                }
            }
            FrsActivity.this.showToast(FrsActivity.this.getPageContext().getString(i.C0057i.shortcut_add_fail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
        } else if (this.aUy != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null && this.aUw != null) {
            com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(getMyPostResIdl.data.thread_info.author);
            a(metaData, getMyPostResIdl.data.user_info);
            String userId = metaData.getUserId();
            if (userId != null && !userId.equals("0")) {
                hashMap.put(metaData.getUserId(), metaData);
            }
            nVar.setUserMap(hashMap);
            nVar.a(getMyPostResIdl.data.thread_info);
            this.aUK.a(nVar);
            ArrayList<com.baidu.adp.widget.ListView.u> a2 = this.aUO.a(true, this.aUy.getThreadList());
            if (a2 != null) {
                this.aUy.X(a2);
                this.aUw.a(a2, this.mPn, this.aUy, this.aUP);
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0008: IGET  (r1v0 java.lang.Long A[REMOVE]) = (r4v0 tbclient.GetMyPost.User_Info) tbclient.GetMyPost.User_Info.id java.lang.Long)] */
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

    private void Li() {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        Lk();
        if (bundle != null) {
            this.aUq = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aUr = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.aUq = intent.getStringExtra("name");
                this.mFrom = intent.getStringExtra("from");
                this.aUr = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            setSwipeBackEnabled(false);
        }
        this.aUz = new cn(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            Lj();
            Ll();
        }
        this.aUM.h(bundle);
    }

    public void Lj() {
        if (this.aUz != null && this.aUw != null) {
            if (FrsActivityStatic.aVs || FrsActivityStatic.aVt || FrsActivityStatic.aVu) {
                this.aUz.V(com.baidu.tbadk.coreExtra.messageCenter.a.wT().getMsgReplyme());
                this.aUz.U(com.baidu.tbadk.coreExtra.messageCenter.a.wT().getMsgAtme());
                int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.wT().getMsgChat();
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().xH() && !TbadkCoreApplication.m411getInst().isMIUIRom()) {
                    msgChat -= com.baidu.tbadk.coreExtra.messageCenter.a.wT().xa();
                }
                this.aUz.W(msgChat);
                this.aUw.a(this.aUz);
                this.aUN.a(this.aUz);
            }
        }
    }

    private void Lk() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.aVd);
    }

    private void Ll() {
        registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.aVd);
    }

    private boolean bX(boolean z) {
        if (z && com.baidu.tieba.frs.utils.a.J(getPageContext().getPageActivity(), getClass().getName())) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
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
        if (this.aUw != null) {
            this.aUw.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.aUH != null) {
                this.aUH.onDestroy();
            }
            this.aUw.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.aUK.onActivityDestroy();
        this.aUL.onActivityDestroy();
        this.aUM.onActivityDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
        if (this.aUI != null) {
            this.aUI.cancel(true);
            this.aUI = null;
        }
        if (this.aUK != null) {
            this.aUK.KL();
        }
        if (this.aUN != null) {
            this.aUN.destroy();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aUq);
        bundle.putString("from", this.mFrom);
        this.aUK.onSaveInstanceState(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.v ko;
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    fe(0);
                    return;
                case 11002:
                    this.aUM.oP();
                    return;
                case 11011:
                    b(this.aUx);
                    return;
                case 11012:
                    c(this.aUA);
                    return;
                case 11014:
                    this.aUM.NF();
                    return;
                case 11016:
                    this.aUw.Mc();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    this.aUM.Ly();
                    return;
                case 13003:
                    if (intent != null && !Lz().Nd()) {
                        try {
                            postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                        } catch (Exception e) {
                            postWriteCallBackData = null;
                        }
                        if (postWriteCallBackData != null) {
                            long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                            long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                            long c3 = com.baidu.adp.lib.g.b.c(this.forumId, 0L);
                            if (c != 0 && c2 != 0 && c3 != 0) {
                                com.baidu.adp.lib.g.h.hi().postDelayed(new y(this, c2, c, c3), 1000L);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 18003:
                    this.aUw.Mj().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (ko = this.aUy.ko(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            ko.bA(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            ko.parser_title();
                            refresh();
                            return;
                        } else if (intExtra == 0) {
                            this.aUy.f(ko);
                            this.aUw.Md();
                            if (com.baidu.tieba.tbadkCore.c.aoQ() != null) {
                                com.baidu.tieba.tbadkCore.c.aoQ().E(this.aUq, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    Lr();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aUN.NM();
        this.aUM.a(this.aUS);
        this.aTe = true;
        this.aUJ = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.aUw.ny();
        } else if (aUo) {
            aUo = false;
            this.aUw.ny();
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
            this.aUw.Mm();
            this.aUN.NN().setSlidingEnabled(true);
            refresh();
            return;
        }
        this.aUw.Ml();
        this.aUN.NN().setSlidingEnabled(false);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.aUq = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.aUt = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aUt) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    Lm();
                } else {
                    Ln();
                }
            }
        }
    }

    private void Lm() {
        this.aUw.ny();
        this.aUN.NN().showContent(false);
    }

    private void Ln() {
        this.aUw.ny();
        this.aUN.NN().showContent(false);
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
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            } else {
                com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        } else {
            com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            finish();
        }
    }

    private void initUI() {
        this.aUw.Mj().h(this.aVa);
        this.aUw.Mj().i(this.aVb);
        if (this.aUr == 0) {
            this.aUw.setTitle(this.aUq);
        } else {
            this.aUw.setTitle("");
            this.aUr = 1;
        }
        this.aUN.NN();
        this.aUM.t(this.aUw.getListView());
        this.aUw.a(this.aVe);
        this.aUw.a(this.aVh);
        this.aUw.j(this.aVf);
        this.aUw.l(this.aVg);
        this.aUw.setOnScrollListener(this.aTm);
        this.aUw.a(this.HD);
        this.aUw.a(this.aUX);
        this.aUw.g(this.aSF);
        this.aUN.NN().setOnOpenedListener(this.aVi);
        this.aUw.Mj().a(this.aUZ);
        if (!this.mIsLogin) {
            this.aUw.Ml();
            this.aUN.NN().setSlidingEnabled(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.aUw.onChangeSkinType(i);
        this.aUN.a(getPageContext(), i);
        this.aUM.a(getPageContext(), i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> KU() {
        if (this.aUB == null) {
            this.aUB = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.aUB;
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
        /* renamed from: f */
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(com.baidu.tieba.frs.utils.a.K(FrsActivity.this.getPageContext().getPageActivity(), this.name));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                FrsActivity.this.showToast(i.C0057i.shortcut_has_add);
            } else {
                FrsActivity.this.gC(this.name);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC(String str) {
        Intent L;
        if (str != null && (L = com.baidu.tieba.frs.utils.a.L(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent();
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(i.C0057i.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", L);
            BarImageView NE = this.aUM.NE();
            if (NE != null && NE.getBdImage() != null && NE.getBdImage().nc() != null) {
                Bitmap nc = NE.getBdImage().nc();
                Float valueOf = Float.valueOf(getResources().getDisplayMetrics().density);
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.d.iw().a(com.baidu.adp.lib.util.d.iw().d(nc, valueOf.intValue() * 48), valueOf.intValue() * 6));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), i.e.icon));
            }
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fe(int i) {
        if (!this.mIsLogin) {
            if (this.aUy != null && this.aUy.rM() != null) {
                this.aUy.rM().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.aUy != null) {
            if (i == 0) {
                AntiData rM = this.aUy.rM();
                if (AntiHelper.d(rM) || AntiHelper.e(rM) || AntiHelper.f(rM)) {
                    rM.setBlock_forum_name(this.aUq);
                    rM.setBlock_forum_id(this.aUy.acG().getId());
                    rM.setUser_name(this.aUy.getUserData().getUserName());
                    rM.setUser_id(this.aUy.getUserData().getUserId());
                    if (AntiHelper.a(getPageContext().getPageActivity(), rM, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (this.aUy.rM() != null && this.aUy.rM().getIfpost() == 0) {
                    com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), rM.getForbid_info());
                    return;
                } else if (this.aUp) {
                    ff(4);
                    return;
                } else {
                    ff(0);
                    return;
                }
            }
            this.aUw.Mc();
        }
    }

    private void ff(int i) {
        int i2 = 0;
        if (this.aUy.getUserData() != null) {
            i2 = this.aUy.getUserData().getIsMem();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(getPageContext().getPageActivity(), i, this.aUy.acG().getId(), this.aUq, null, null, 0, this.aUy.rM(), 13003, false, false, null, false, false, null, null, this.aUy.acG().getPrefixData(), i2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.v vVar) {
        boolean sD = vVar == null ? true : vVar.sD();
        this.aUw.a(new z(this, vVar));
        this.aUw.a(vVar, sD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.v vVar) {
        boolean sD = vVar == null ? true : vVar.sD();
        if (this.mThreadId != null) {
            if (!sD) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(vVar, this.aUq, null, 18003, true, true, this.aUu)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(vVar, this.aUq, null, 18003, false, false, this.aUu)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.v vVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(vVar, this.aUq, null, 18003, false, false, this.aUu)));
        }
    }

    public void refresh() {
        stopVoice();
        if (this.aUL != null && this.aUL.NO() != null) {
            this.aUL.NO().a(this.aUK.Ng(), this.aUK.Nh(), this.aUK.Ni());
        }
        Lz().bz(true);
    }

    private void Lo() {
        switch (this.aUr) {
            case 1:
                com.baidu.adp.lib.g.k.hj().c(new aa(this));
                break;
        }
        this.aUr = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lp() {
        stopVoice();
        try {
            if (this.aUy != null) {
                this.aUw.LZ();
                this.aUq = this.aUy.acG().getName();
                this.forumId = this.aUy.acG().getId();
                this.aUw.setTitle(this.aUq);
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.aUy.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.aUy.getUserData().getBimg_end_time());
                Lo();
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aUy.getThreadList();
                if (threadList != null) {
                    this.aUw.a(threadList, this.mPn, this.aUy, this.aUy.getPage().rT());
                    Ls();
                    this.aUM.fG(this.mPn);
                    this.aUM.d(this.aUy);
                    this.aUw.Md();
                    if (this.aUy.acL() == 1) {
                        this.aUw.Mj().setFromCDN(true);
                    } else {
                        this.aUw.Mj().setFromCDN(false);
                    }
                    this.aUw.fp(V(Lz().getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int V(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aTe = false;
        this.aUJ = false;
        this.aUw.onPause();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.aUy != null && this.aUy.acG() != null) {
            com.baidu.tbadk.distribute.a.Ai().a(getPageContext().getPageActivity(), "frs", this.aUy.acG().getId(), 0L);
        }
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.aUs) {
            if (i == 4) {
                if (this.aUN.onBackPressed()) {
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
            if (cVar.rx()) {
                com.baidu.tbadk.core.util.ax.uR().b(getPageContext(), new String[]{cVar.Uk});
            } else if (cVar.rw()) {
                if (com.baidu.adp.lib.util.i.iP()) {
                    a(cVar, "area_download");
                    b(cVar, "download");
                    b(cVar, i);
                    return;
                }
                if (com.baidu.adp.lib.util.i.iO()) {
                    trim = getPageContext().getString(i.C0057i.frs_network_tips);
                } else if (TextUtils.isEmpty(cVar.Uv.UA.trim())) {
                    trim = getPageContext().getString(i.C0057i.confirm_download_app);
                } else {
                    trim = cVar.Uv.UA.trim();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cn(trim);
                aVar.a(i.C0057i.alert_yes_button, new ab(this, cVar, i));
                aVar.b(i.C0057i.alert_no_button, new ac(this));
                aVar.b(getPageContext()).sP();
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar != null) {
            if (!cVar.rv()) {
                com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), i.C0057i.pb_app_error);
            } else if (com.baidu.adp.lib.util.i.iO()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", cVar.Um);
                com.baidu.tbadk.download.b.Ap().a(cVar.Um, cVar.Ul, cVar.Ui, i, com.baidu.adp.lib.g.b.g(cVar.Uh, 0));
            } else {
                showToast(i.C0057i.neterror);
            }
        }
    }

    public void Lq() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
        this.aUI = new a(this.aUq);
        this.aUI.setSelfExecute(true);
        this.aUI.execute(new String[0]);
    }

    public void Lr() {
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.aUy.acG().getId(), true, true, true);
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.Ai().a(getPageContext().getPageActivity(), cVar, str, "frs", this.aUy.acG().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.Ai().a(cVar, this.forumId, 0L, "FRS", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd(int i) {
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aUy.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.v) {
                    com.baidu.tbadk.core.data.v vVar = (com.baidu.tbadk.core.data.v) next;
                    if (vVar == this.aUl) {
                        a(vVar, i);
                        this.aUl = null;
                        break;
                    } else if (vVar.getId() != null && vVar.getId().equals(this.aTf)) {
                        a(vVar, i);
                        this.aTf = null;
                        break;
                    }
                }
            }
            this.aUw.Mj().a(threadList, this.aUy);
            this.aUw.Mj().notifyDataSetChanged();
        }
    }

    private void a(com.baidu.tbadk.core.data.v vVar, int i) {
        if (i == 1) {
            PraiseData praise = vVar.getPraise();
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
                    vVar.setPraise(praiseData);
                    return;
                }
                vVar.getPraise().getUser().add(0, metaData);
                vVar.getPraise().setNum(vVar.getPraise().getNum() + 1);
                vVar.getPraise().setIsLike(i);
            }
        } else if (vVar.getPraise() != null) {
            vVar.getPraise().setIsLike(i);
            vVar.getPraise().setNum(vVar.getPraise().getNum() - 1);
            ArrayList<MetaData> user = vVar.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        vVar.getPraise().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    public void a(dg.a aVar, String str) {
        if (str != null) {
            Lz().av(aVar.aZg, str);
            this.aUN.NL();
            this.aUq = str;
            if (this.aUw != null) {
                this.aUw.setTitle(this.aUq);
            }
            stopVoice();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public BdListView getListView() {
        if (this.aUw == null) {
            return null;
        }
        return this.aUw.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void stopVoice() {
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vG() {
        if (this.aUw == null) {
            return 0;
        }
        return this.aUw.Mg();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> vH() {
        if (this.afk == null) {
            this.afk = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.afk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.aUz != null) {
                this.aUz.V(msgReplyme);
                this.aUz.U(msgAtme);
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xq().xH() && !TbadkCoreApplication.m411getInst().isMIUIRom()) {
                    this.aUz.W((msgChat - newsNotifyMessage.getMsgPrivateChat()) - newsNotifyMessage.getMsgStrangerChat());
                } else {
                    this.aUz.W(msgChat);
                }
                this.aUw.a(this.aUz);
                this.aUN.a(this.aUz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        as Mj;
        HashMap<Integer, com.baidu.tbadk.core.data.v> LF;
        if (this.aUy != null && this.aUw != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (Mj = this.aUw.Mj()) != null && (LF = Mj.LF()) != null && LF.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.v> entry : LF.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.v value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.c) && TextUtils.equals(((com.baidu.tbadk.core.data.c) value).Um, downloadData.getId())) {
                            int apj = this.aUy.apj();
                            if (Mj.aA(intValue + apj) instanceof com.baidu.tbadk.core.data.c) {
                                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) Mj.aA(apj + intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    cVar.Ug = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!com.baidu.tbadk.core.util.aq.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    cVar.Ug = 0;
                                } else if (status == 1) {
                                    cVar.Ug = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.aUw.Ma();
        }
    }

    private void Ls() {
        HashMap<Integer, com.baidu.tbadk.core.data.v> LF;
        if (this.aUw != null && this.aUw.Mj() != null && (LF = this.aUw.Mj().LF()) != null) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.v> entry : LF.entrySet()) {
                com.baidu.tbadk.core.data.v value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.c)) {
                    arrayList.add((com.baidu.tbadk.core.data.c) value);
                }
            }
            com.baidu.tbadk.download.b.Ap().p(arrayList);
        }
    }

    public void Lt() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), getCurrentFocus());
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
            int i2 = cVar.Ug;
            if (i2 == 0) {
                a(cVar, i);
            } else if (i2 == 2) {
                com.baidu.tieba.frs.utils.a.I(getPageContext().getPageActivity(), cVar.Um);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", cVar.Um);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.c cVar) {
        if (cVar != null) {
            a(cVar, "btn_click");
            b(cVar, "click");
            com.baidu.tbadk.core.util.ax.uR().b(getPageContext(), new String[]{cVar.Uk});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.aUw.getRootView());
        showLoadingView(this.aUw.getRootView(), true);
        this.aUw.Mi();
        this.aUw.ny();
    }

    public com.baidu.tieba.tbadkCore.n Lu() {
        return this.aUy;
    }

    public boolean Lv() {
        return this.aUw.Lv();
    }

    public void Lw() {
        FrsActivityStatic.aVs = false;
        FrsActivityStatic.aVu = false;
        Lj();
    }

    public void Lx() {
        FrsActivityStatic.aVs = false;
        FrsActivityStatic.aVt = false;
        Lj();
    }

    public void Ly() {
        this.aUM.Ly();
    }

    public com.baidu.tieba.frs.b.a Lz() {
        return this.aUK;
    }

    public void a(bl blVar) {
        this.aUw = blVar;
    }

    public void gD(String str) {
        this.aUq = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFlag(int i) {
        this.aUr = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    public void resetData() {
        this.aUm = false;
        this.aUv = false;
        this.aUy = null;
        this.aUw.setTitle(this.aUq);
        this.aUN.cj(false);
        this.aUN.setIsManager(false);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.jf()) {
            this.aUw.Mq();
        } else if (this.aUK.Ng() == 1) {
            LA();
            loadMore();
        } else if (this.aUK.hasMore()) {
            loadMore();
        }
    }

    public void gE(String str) {
        LA();
        showToast(str);
    }

    public void C(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.u> a2;
        LA();
        if (arrayList != null && arrayList.size() != 0 && (a2 = this.aUO.a(false, arrayList)) != null) {
            this.aUy.X(a2);
            this.aUw.a(a2, this.mPn, this.aUy, 0);
        }
    }

    private void LA() {
        if (this.aUP == 0 && !this.aUO.Y(this.aUy.aoW())) {
            if (this.aUy.getThreadList() == null || this.aUy.getThreadList().size() == 0) {
                this.aUw.Mq();
                return;
            } else {
                this.aUw.Mp();
                return;
            }
        }
        this.aUw.Mo();
    }

    public void loadMore() {
        if (this.aUK.Ng() == 1) {
            if (!this.aUO.avu && !this.aUK.isLoading()) {
                if (this.aUO.Y(this.aUy.aoW())) {
                    this.aUw.a(this.aUO.MN(), this.mPn, this.aUy, 0);
                    this.aUO.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.aUy.aoW());
                } else if (this.aUP != 0) {
                    this.aUw.a(this.aUO.MN(), this.mPn, this.aUy, 0);
                    this.mPn++;
                    this.aUK.fw(this.mPn);
                    this.aUO.aZs = false;
                    this.aUO.aZt = 0;
                }
            }
        } else if (!this.aUK.Nk()) {
            if (this.aUL.NO() != null) {
                this.aUL.NO().a(this.aUK.Ng(), this.aUK.Nh(), this.aUK.Ni());
            }
            this.aUK.HF();
        }
    }
}
