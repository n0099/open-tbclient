package com.baidu.tieba.frs;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
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
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveHeadlineActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveListActivityConfig;
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
import com.baidu.tieba.frs.dm;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.e;
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
    public static String aUw;
    private boolean aTs;
    private String aTt;
    private boolean aUD;
    private com.baidu.tbadk.core.data.x aUE;
    private cr aUO;
    private com.baidu.adp.lib.e.b<TbImageView> aUQ;
    private a aUX;
    private com.baidu.tieba.frs.b.a aUZ;
    private com.baidu.tbadk.core.data.x aUz;
    private com.baidu.tieba.frs.c.n aVa;
    private com.baidu.tieba.frs.c.a aVb;
    private com.baidu.tieba.frs.c.k aVc;
    private com.baidu.tieba.frs.loadmore.a aVd;
    private com.baidu.adp.lib.e.b<TbImageView> afu;
    VoiceManager mVoiceManager;
    private static final int aUx = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90);
    private static final int aUy = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds300);
    public static boolean aUC = false;
    public static volatile long aUS = 0;
    public static volatile long aUT = 0;
    public static volatile int aUU = 0;
    private static boolean isNeedRefreshOnResume = false;
    private boolean aUA = false;
    public boolean aUB = false;
    public String aUF = null;
    public String mFrom = null;
    public int aUG = 0;
    private int mPn = 1;
    private boolean aUH = false;
    private boolean aUI = false;
    private String mThreadId = null;
    private String forumId = null;
    private boolean aUJ = false;
    private boolean aUK = false;
    private bi aUL = null;
    private final com.baidu.tbadk.core.data.x aUM = null;
    private com.baidu.tieba.tbadkCore.o aUN = new com.baidu.tieba.tbadkCore.o();
    private com.baidu.tbadk.core.data.x aUP = null;
    private boolean Ji = false;
    public long aMD = -1;
    public long ayY = 0;
    public long createTime = 0;
    public long aUR = -1;
    private boolean aUV = false;
    public com.baidu.tbadk.performanceLog.e aUW = null;
    private boolean aUY = true;
    private int aVe = -1;
    private di aVf = new com.baidu.tieba.frs.a(this);
    private dh aVg = new l(this);
    private CustomMessageListener aTy = new x(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener aSf = new ae(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
    private CustomMessageListener aIv = new af(this, CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND);
    public final CustomMessageListener aVh = new ag(this, CmdConfigCustom.MSG_NEW);
    private CustomMessageListener aVi = new ah(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    public final com.baidu.tieba.tbadkCore.r aVj = new ai(this);
    private final CustomMessageListener TF = new aj(this, CmdConfigCustom.CMD_REFRESH);
    private final CustomMessageListener mMemListener = new b(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private final com.baidu.adp.framework.listener.a aVk = new c(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    private final x.a aVl = new d(this);
    private final BdListView.g HD = new e(this);
    public final View.OnClickListener aVm = new f(this);
    private final AbsListView.OnScrollListener aTA = new g(this);
    private final av aVn = new h(this);
    private final com.baidu.tieba.tbadkCore.ae aTC = new com.baidu.tieba.tbadkCore.ae(getPageContext(), new i(this));
    private final View.OnClickListener aVo = new j(this);
    private final View.OnClickListener aVp = new k(this);
    public final AdapterView.OnItemClickListener aVq = new m(this);
    private final NoNetworkView.a aST = new n(this);
    private final CustomMessageListener aVr = new o(this, 0);
    private com.baidu.adp.widget.ListView.v aVs = new p(this);
    private View.OnClickListener aVt = new r(this);
    private View.OnClickListener aVu = new s(this);
    private com.baidu.adp.widget.ListView.w aVv = new t(this);
    private final SlidingMenu.OnOpenedListener aVw = new u(this);
    public final com.baidu.adp.base.g aVx = new v(this);
    public final com.baidu.adp.base.g aVy = new w(this);

    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    public void a(ErrorData errorData) {
        this.aUL.cf(false);
        this.aUL.cg(false);
        this.aUL.ch(false);
        this.aUL.LR();
        hideLoadingView(this.aUL.getRootView());
        this.aUL.LY();
        if (!this.aUK) {
            e.a Nf = Lq().Nf();
            if (!this.aUA) {
                if (Nf != null) {
                    if (Nf.cPd) {
                        if (340001 == Nf.errorCode) {
                            showNetRefreshViewNoClick(this.aUL.getRootView(), getPageContext().getResources().getString(i.h.net_error_text, Nf.errorMsg, Integer.valueOf(Nf.errorCode)), true);
                        } else {
                            showNetRefreshView(this.aUL.getRootView(), getPageContext().getResources().getString(i.h.net_error_text, Nf.errorMsg, Integer.valueOf(Nf.errorCode)), true);
                        }
                    } else if (340001 == Nf.errorCode) {
                        showNetRefreshViewNoClick(this.aUL.getRootView(), Nf.errorMsg, true);
                    } else {
                        showNetRefreshView(this.aUL.getRootView(), Nf.errorMsg, true);
                    }
                    this.aUL.fv(8);
                }
            } else if (Nf != null && Nf.cPd) {
                this.aUL.fv(0);
                showToast(getPageContext().getResources().getString(i.h.net_error_text, Nf.errorMsg, Integer.valueOf(Nf.errorCode)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.m mVar) {
        boolean z;
        if (mVar != null) {
            try {
                this.aUN.d(mVar);
                if (this.aUN.acV() == 1) {
                    this.aUL.Ma().setFromCDN(true);
                } else {
                    this.aUL.Ma().setFromCDN(false);
                }
                this.aVe = this.aUN.getPage().rQ();
                this.aUL.b(this.aUN.acP(), this.aUN.getUserData());
                if (this.aUN.atk() == null) {
                    z = false;
                } else {
                    z = this.aUN.atk().size() != 0;
                }
                this.aVb.a(this.aUN.asY().ato() == 1, this.aUN.getUserData().getIsMem(), this.aUN.acP().isLike(), z);
                this.aUL.LQ();
                this.aUF = this.aUN.acP().getName();
                this.forumId = this.aUN.acP().getId();
                this.aUL.setTitle(this.aUF);
                Ld();
                this.aUN.atv();
                this.aUN.aQ(getPageContext().getPageActivity());
                this.aUN.atz();
                if (!Lq().Ne() && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.aUN.aty();
                    this.aUN.atx();
                }
                com.baidu.tbadk.core.data.z top_notice_data = this.aUN.acP().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.getTitle() != null) {
                    com.baidu.tbadk.core.data.x xVar = new com.baidu.tbadk.core.data.x();
                    xVar.setTitle(top_notice_data.getTitle());
                    xVar.bA(2);
                    xVar.cm(top_notice_data.sN());
                    xVar.parser_title();
                    this.aUN.f(xVar);
                }
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aUN.getThreadList();
                if (threadList != null) {
                    ArrayList<com.baidu.adp.widget.ListView.u> a2 = this.aVd.a(true, threadList);
                    if (a2 != null) {
                        this.aUN.ad(a2);
                    }
                    this.aUL.a(threadList, this.mPn, this.aUN, this.aUN.getPage().rQ());
                    Lj();
                    this.aVb.fP(this.mPn);
                    this.aVb.c(this.aUN);
                    this.aUL.LU();
                    this.aUL.fu(0);
                }
                this.aVb.cm(this.aUN.ata());
                hideLoadingView(this.aUL.getRootView());
                this.aUL.LY();
                this.aUA = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        aUw = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (intent != null) {
            this.aMD = intent.getLongExtra("TibaStatic.StartTime", -1L);
            if (intent.getData() != null) {
                Uri data = intent.getData();
                this.aUF = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.aUF)) {
                    intent.putExtra("name", this.aUF);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.aUF)) {
                this.aUF = N(intent);
                if (!StringUtils.isNull(this.aUF)) {
                    intent.putExtra("name", this.aUF);
                }
            }
        } else {
            this.aMD = System.currentTimeMillis();
        }
        if (this.aMD != -1) {
            this.aUR = this.aMD;
        } else {
            this.aUR = System.currentTimeMillis();
        }
        if (!cc(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.aUR;
            return;
        }
        super.onCreate(bundle);
        setContentView(i.g.frs_activity);
        this.aUZ = new com.baidu.tieba.frs.b.a(this);
        this.aUZ.a(this.aVf);
        this.aUZ.init();
        this.aVa = new com.baidu.tieba.frs.c.n(this);
        this.aVc = new com.baidu.tieba.frs.c.k(this);
        this.aVb = new com.baidu.tieba.frs.c.a(this, this.aVa);
        this.aVa.oP();
        if (getIntent() != null) {
            this.aUZ.f(getIntent().getExtras());
            this.aVb.h(getIntent().getExtras());
        } else if (bundle != null) {
            this.aUZ.f(bundle);
            this.aVb.h(bundle);
        } else {
            this.aUZ.f(null);
            this.aVb.h((Bundle) null);
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        this.aTC.setUniqueId(getUniqueId());
        this.aTC.registerListener();
        addGlobalLayoutListener();
        KW();
        registerListener(this.TF);
        registerListener(this.mMemListener);
        registerListener(this.aVh);
        registerListener(this.aTy);
        registerListener(this.aIv);
        registerListener(this.aSf);
        registerListener(this.aVi);
        this.aVk.getSocketMessageListener().setSelfListener(true);
        this.aVk.getHttpMessageListener().setSelfListener(true);
        this.aVk.setTag(getUniqueId());
        registerListener(this.aVk);
        this.aVd = new com.baidu.tieba.frs.loadmore.a(this);
        this.aVd.registerListener();
        Lq().oQ();
        this.createTime = System.currentTimeMillis() - this.aMD;
        if (this.aUL != null) {
            showLoadingView(this.aUL.getRootView(), true);
            this.aUL.LZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
        } else if (this.aUN != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null && this.aUL != null) {
            com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(getMyPostResIdl.data.thread_info.author);
            a(metaData, getMyPostResIdl.data.user_info);
            String userId = metaData.getUserId();
            if (userId != null && !userId.equals("0")) {
                hashMap.put(metaData.getUserId(), metaData);
            }
            mVar.setUserMap(hashMap);
            mVar.a(getMyPostResIdl.data.thread_info);
            this.aUZ.a(mVar);
            ArrayList<com.baidu.adp.widget.ListView.u> a2 = this.aVd.a(true, this.aUN.getThreadList());
            if (a2 != null) {
                this.aUN.ad(a2);
                this.aUL.a(a2, this.mPn, this.aUN, this.aVe);
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

    private void KW() {
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
        KY();
        if (bundle != null) {
            this.aUF = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aUG = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.aUF = intent.getStringExtra("name");
                this.mFrom = intent.getStringExtra("from");
                this.aUG = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            setSwipeBackEnabled(false);
        }
        this.aUO = new cr(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            KX();
            KZ();
        }
        this.aVb.h(bundle);
    }

    private String N(Intent intent) {
        int indexOf;
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (!StringUtils.isNull(dataString) && dataString.startsWith("tbfrs://")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10320").r("obj_locate", 2).r("obj_type", 1));
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (StringUtils.isNull(decode) || (indexOf = decode.indexOf("kw=")) < 0 || (length = indexOf + "kw=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public void KX() {
        if (this.aUO != null && this.aUL != null) {
            if (FrsActivityStatic.aVH || FrsActivityStatic.aVI || FrsActivityStatic.aVJ) {
                this.aUO.W(com.baidu.tbadk.coreExtra.messageCenter.a.wZ().getMsgReplyme());
                this.aUO.V(com.baidu.tbadk.coreExtra.messageCenter.a.wZ().getMsgAtme());
                int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.wZ().getMsgChat();
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().xN() && !TbadkCoreApplication.m411getInst().isMIUIRom()) {
                    msgChat -= com.baidu.tbadk.coreExtra.messageCenter.a.wZ().xg();
                }
                this.aUO.X(msgChat);
                this.aUL.a(this.aUO);
                this.aVc.a(this.aUO);
            }
        }
    }

    private void KY() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.aVr);
    }

    private void KZ() {
        registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.aVr);
    }

    private boolean cc(boolean z) {
        if (z && com.baidu.tieba.frs.utils.a.J(getPageContext().getPageActivity(), getClass().getName())) {
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
        if (this.aUL != null) {
            this.aUL.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.aUW != null) {
                this.aUW.onDestroy();
            }
            this.aUL.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.aUZ.onActivityDestroy();
        this.aVa.onActivityDestroy();
        this.aVb.onActivityDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
        if (this.aUX != null) {
            this.aUX.cancel(true);
            this.aUX = null;
        }
        if (this.aUZ != null) {
            this.aUZ.Kz();
        }
        if (this.aVc != null) {
            this.aVc.destroy();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aUF);
        bundle.putString("from", this.mFrom);
        this.aUZ.onSaveInstanceState(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.x kT;
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    fl(0);
                    return;
                case 11002:
                    this.aVb.oM();
                    return;
                case 11011:
                    c(this.aUM);
                    return;
                case 11012:
                    d(this.aUP);
                    return;
                case 11014:
                    this.aVb.NG();
                    return;
                case 11016:
                    this.aUL.LT();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    this.aVb.Lp();
                    return;
                case 13003:
                    if (intent != null && !Lq().Ne()) {
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
                                com.baidu.adp.lib.g.h.hf().postDelayed(new y(this, c2, c, c3), 1000L);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 18003:
                    this.aUL.Ma().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (kT = this.aUN.kT(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            kT.bB(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            kT.parser_title();
                            refresh();
                            return;
                        } else if (intExtra == 0) {
                            this.aUN.g(kT);
                            this.aUL.LU();
                            if (com.baidu.tieba.tbadkCore.d.asX() != null) {
                                com.baidu.tieba.tbadkCore.d.asX().G(this.aUF, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    Lg();
                    return;
                case 23013:
                    Lh();
                    return;
                case 23019:
                    Li();
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
        this.aVc.NN();
        this.aVb.a(this.aVg);
        this.aTs = true;
        this.aUY = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.aUL.nv();
        } else if (aUC) {
            aUC = false;
            this.aUL.nv();
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
            this.aUL.Md();
            this.aVc.NO().setSlidingEnabled(true);
            refresh();
            return;
        }
        this.aUL.Mc();
        this.aVc.NO().setSlidingEnabled(false);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.aUF = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.aUI = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aUI) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    La();
                } else {
                    Lb();
                }
            }
        }
    }

    private void La() {
        this.aUL.nv();
        this.aVc.NO().showContent(false);
    }

    private void Lb() {
        this.aUL.nv();
        this.aVc.NO().showContent(false);
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
        this.aUL.Ma().h(this.aVo);
        this.aUL.Ma().i(this.aVp);
        if (this.aUG == 0) {
            this.aUL.setTitle(this.aUF);
        } else {
            this.aUL.setTitle("");
            this.aUG = 1;
        }
        this.aVc.NO();
        this.aVb.t(this.aUL.getListView());
        this.aUL.a(this.aVs);
        this.aUL.a(this.aVv);
        this.aUL.j(this.aVt);
        this.aUL.l(this.aVu);
        this.aUL.setOnScrollListener(this.aTA);
        this.aUL.a(this.HD);
        this.aUL.a(this.aVl);
        this.aUL.g(this.aST);
        this.aVc.NO().setOnOpenedListener(this.aVw);
        this.aUL.Ma().a(this.aVn);
        if (!this.mIsLogin) {
            this.aUL.Mc();
            this.aVc.NO().setSlidingEnabled(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.aUL.onChangeSkinType(i);
        this.aVc.a(getPageContext(), i);
        this.aVb.a(getPageContext(), i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> KI() {
        if (this.aUQ == null) {
            this.aUQ = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.aUQ;
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
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(com.baidu.tieba.frs.utils.a.K(FrsActivity.this.getPageContext().getPageActivity(), this.name));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                FrsActivity.this.showToast(i.h.shortcut_has_add);
            } else {
                FrsActivity.this.gJ(this.name);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ(String str) {
        Intent L;
        if (str != null && (L = com.baidu.tieba.frs.utils.a.L(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(i.h.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", L);
            BarImageView NF = this.aVb.NF();
            if (NF != null && NF.getBdImage() != null && NF.getBdImage().mZ() != null) {
                Bitmap mZ = NF.getBdImage().mZ();
                Float valueOf = Float.valueOf(getResources().getDisplayMetrics().density);
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.d.it().a(com.baidu.adp.lib.util.d.it().d(mZ, valueOf.intValue() * 48), valueOf.intValue() * 6));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), i.e.icon));
            }
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fl(int i) {
        if (!this.mIsLogin) {
            if (this.aUN != null && this.aUN.rK() != null) {
                this.aUN.rK().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.aUN != null) {
            if (i == 0) {
                if (!this.aUD) {
                    AntiData rK = this.aUN.rK();
                    if (AntiHelper.d(rK) || AntiHelper.e(rK) || AntiHelper.f(rK)) {
                        rK.setBlock_forum_name(this.aUF);
                        rK.setBlock_forum_id(this.aUN.acP().getId());
                        rK.setUser_name(this.aUN.getUserData().getUserName());
                        rK.setUser_id(this.aUN.getUserData().getUserId());
                        if (AntiHelper.a(getPageContext().getPageActivity(), rK, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                            return;
                        }
                    }
                    if (this.aUN.rK() != null && this.aUN.rK().getIfpost() == 0) {
                        com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), rK.getForbid_info());
                        return;
                    } else {
                        fm(0);
                        return;
                    }
                }
                TiebaStatic.log("c10152");
                fm(4);
                return;
            }
            this.aUL.LT();
        }
    }

    private void fm(int i) {
        int i2 = 0;
        if (this.aUN.getUserData() != null) {
            i2 = this.aUN.getUserData().getIsMem();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(getPageContext().getPageActivity(), i, this.aUN.acP().getId(), this.aUF, null, null, 0, this.aUN.rK(), 13003, false, false, null, false, false, null, null, this.aUN.acP().getPrefixData(), i2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.x xVar) {
        boolean sH = xVar == null ? true : xVar.sH();
        this.aUL.b(new z(this, xVar));
        this.aUL.a(xVar, sH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lc() {
        this.aUL.a(new aa(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.x xVar) {
        boolean sH = xVar == null ? true : xVar.sH();
        if (this.mThreadId != null) {
            if (!sH) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(xVar, this.aUF, null, 18003, true, true, this.aUJ)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(xVar, this.aUF, null, 18003, false, false, this.aUJ)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.x xVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(xVar, this.aUF, null, 18003, false, false, this.aUJ)));
        }
    }

    public void refresh() {
        stopVoice();
        if (this.aVa != null && this.aVa.NP() != null) {
            this.aVa.NP().a(this.aUZ.Nh(), this.aUZ.Ni(), this.aUZ.Nj());
        }
        Lq().bE(true);
    }

    private void Ld() {
        switch (this.aUG) {
            case 1:
                com.baidu.adp.lib.g.k.hg().c(new ab(this));
                break;
        }
        this.aUG = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Le() {
        stopVoice();
        try {
            if (this.aUN != null) {
                this.aUL.LQ();
                this.aUF = this.aUN.acP().getName();
                this.forumId = this.aUN.acP().getId();
                this.aUL.setTitle(this.aUF);
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.aUN.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.aUN.getUserData().getBimg_end_time());
                Ld();
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aUN.getThreadList();
                if (threadList != null) {
                    this.aUL.a(threadList, this.mPn, this.aUN, this.aUN.getPage().rQ());
                    Lj();
                    this.aVb.fP(this.mPn);
                    this.aVb.c(this.aUN);
                    this.aUL.LU();
                    if (this.aUN.acV() == 1) {
                        this.aUL.Ma().setFromCDN(true);
                    } else {
                        this.aUL.Ma().setFromCDN(false);
                    }
                    this.aUL.fu(V(Lq().getType(), this.mPn));
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
        this.aTs = false;
        this.aUY = false;
        this.aUL.onPause();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.aUN != null && this.aUN.acP() != null) {
            com.baidu.tbadk.distribute.a.Av().a(getPageContext().getPageActivity(), "frs", this.aUN.acP().getId(), 0L);
        }
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.aUH) {
            if (i == 4) {
                if (this.aVc.onBackPressed()) {
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
            if (cVar.rw()) {
                com.baidu.tbadk.core.util.ax.uX().b(getPageContext(), new String[]{cVar.Ul});
            } else if (cVar.rv()) {
                if (com.baidu.adp.lib.util.i.iM()) {
                    a(cVar, "area_download");
                    b(cVar, "download");
                    b(cVar, i);
                    return;
                }
                if (com.baidu.adp.lib.util.i.iL()) {
                    trim = getPageContext().getString(i.h.frs_network_tips);
                } else if (TextUtils.isEmpty(cVar.Uw.UB.trim())) {
                    trim = getPageContext().getString(i.h.confirm_download_app);
                } else {
                    trim = cVar.Uw.UB.trim();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.ct(trim);
                aVar.a(i.h.alert_yes_button, new ac(this, cVar, i));
                aVar.b(i.h.alert_no_button, new ad(this));
                aVar.b(getPageContext()).sU();
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar != null) {
            if (!cVar.ru()) {
                com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), i.h.pb_app_error);
            } else if (com.baidu.adp.lib.util.i.iL()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", cVar.Un);
                com.baidu.tbadk.download.b.AC().a(cVar.Un, cVar.Um, cVar.Uj, i, com.baidu.adp.lib.g.b.g(cVar.Ui, 0));
            } else {
                showToast(i.h.neterror);
            }
        }
    }

    public void Lf() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
        this.aUX = new a(this.aUF);
        this.aUX.setSelfExecute(true);
        this.aUX.execute(new String[0]);
    }

    public void Lg() {
        com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.aUN.acP().getId(), true, true, true);
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.Av().a(getPageContext().getPageActivity(), cVar, str, "frs", this.aUN.acP().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.Av().a(cVar, this.forumId, 0L, "FRS", str);
    }

    public void Lh() {
        if (!fn(23013)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10249").af(ImageViewerConfig.FORUM_ID, this.forumId));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(getPageContext().getPageActivity(), String.valueOf(getForumId()), false, 0)));
        }
    }

    public void Li() {
        if (!fn(23019) && this.aUE != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(getPageContext().getPageActivity()).createConfig(String.valueOf(getForumId()), this.aUE.getTid(), 1)));
        }
    }

    private boolean fn(int i) {
        if (TbadkCoreApplication.isLogin()) {
            return false;
        }
        TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getResources().getString(i.h.login_to_use), true, i)));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fk(int i) {
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aUN.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.x) {
                    com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) next;
                    if (xVar == this.aUz) {
                        a(xVar, i);
                        this.aUz = null;
                        break;
                    } else if (xVar.getId() != null && xVar.getId().equals(this.aTt)) {
                        a(xVar, i);
                        this.aTt = null;
                        break;
                    }
                }
            }
            this.aUL.Ma().a(threadList, this.aUN);
            this.aUL.Ma().notifyDataSetChanged();
        }
    }

    private void a(com.baidu.tbadk.core.data.x xVar, int i) {
        if (i == 1) {
            PraiseData praise = xVar.getPraise();
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
                    xVar.setPraise(praiseData);
                    return;
                }
                xVar.getPraise().getUser().add(0, metaData);
                xVar.getPraise().setNum(xVar.getPraise().getNum() + 1);
                xVar.getPraise().setIsLike(i);
            }
        } else if (xVar.getPraise() != null) {
            xVar.getPraise().setIsLike(i);
            xVar.getPraise().setNum(xVar.getPraise().getNum() - 1);
            ArrayList<MetaData> user = xVar.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        xVar.getPraise().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    public void a(dm.a aVar, String str) {
        if (str != null) {
            Lq().aw(aVar.aZz, str);
            this.aVc.NM();
            this.aUF = str;
            if (this.aUL != null) {
                this.aUL.setTitle(this.aUF);
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
        if (this.aUL == null) {
            return null;
        }
        return this.aUL.getListView();
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
    public int vL() {
        if (this.aUL == null) {
            return 0;
        }
        return this.aUL.LX();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> vM() {
        if (this.afu == null) {
            this.afu = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.afu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.aUO != null) {
                this.aUO.W(msgReplyme);
                this.aUO.V(msgAtme);
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xw().xN() && !TbadkCoreApplication.m411getInst().isMIUIRom()) {
                    this.aUO.X((msgChat - newsNotifyMessage.getMsgPrivateChat()) - newsNotifyMessage.getMsgStrangerChat());
                } else {
                    this.aUO.X(msgChat);
                }
                this.aUL.a(this.aUO);
                this.aVc.a(this.aUO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        at Ma;
        HashMap<Integer, com.baidu.tbadk.core.data.x> Lw;
        if (this.aUN != null && this.aUL != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (Ma = this.aUL.Ma()) != null && (Lw = Ma.Lw()) != null && Lw.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.x> entry : Lw.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.x value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.c) && TextUtils.equals(((com.baidu.tbadk.core.data.c) value).Un, downloadData.getId())) {
                            int atu = this.aUN.atu();
                            if (Ma.aA(intValue + atu) instanceof com.baidu.tbadk.core.data.c) {
                                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) Ma.aA(atu + intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    cVar.Uh = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!com.baidu.tbadk.core.util.aq.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    cVar.Uh = 0;
                                } else if (status == 1) {
                                    cVar.Uh = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.aUL.LR();
        }
    }

    private void Lj() {
        HashMap<Integer, com.baidu.tbadk.core.data.x> Lw;
        if (this.aUL != null && this.aUL.Ma() != null && (Lw = this.aUL.Ma().Lw()) != null) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.x> entry : Lw.entrySet()) {
                com.baidu.tbadk.core.data.x value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.c)) {
                    arrayList.add((com.baidu.tbadk.core.data.c) value);
                }
            }
            com.baidu.tbadk.download.b.AC().o(arrayList);
        }
    }

    public void Lk() {
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
            int i2 = cVar.Uh;
            if (i2 == 0) {
                a(cVar, i);
            } else if (i2 == 2) {
                com.baidu.tieba.frs.utils.a.I(getPageContext().getPageActivity(), cVar.Un);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", cVar.Un);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.c cVar) {
        if (cVar != null) {
            a(cVar, "btn_click");
            b(cVar, "click");
            com.baidu.tbadk.core.util.ax.uX().b(getPageContext(), new String[]{cVar.Ul});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.aUL.getRootView());
        showLoadingView(this.aUL.getRootView(), true);
        this.aUL.LZ();
        this.aUL.nv();
    }

    public com.baidu.tieba.tbadkCore.o Ll() {
        return this.aUN;
    }

    public boolean Lm() {
        return this.aUL.Lm();
    }

    public void Ln() {
        FrsActivityStatic.aVH = false;
        FrsActivityStatic.aVJ = false;
        KX();
    }

    public void Lo() {
        FrsActivityStatic.aVH = false;
        FrsActivityStatic.aVI = false;
        KX();
    }

    public void Lp() {
        this.aVb.Lp();
    }

    public com.baidu.tieba.frs.b.a Lq() {
        return this.aUZ;
    }

    public void a(bi biVar) {
        this.aUL = biVar;
    }

    public void gK(String str) {
        this.aUF = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFlag(int i) {
        this.aUG = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    public void resetData() {
        this.aUA = false;
        this.aUK = false;
        this.aUN = null;
        this.aUL.setTitle(this.aUF);
        this.aVc.co(false);
        this.aVc.setIsManager(false);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.jc()) {
            this.aUL.Mh();
        } else if (this.aUZ.Nh() == 1) {
            Lr();
            loadMore();
        } else if (this.aUZ.hasMore()) {
            loadMore();
        }
    }

    public void gL(String str) {
        Lr();
        showToast(str);
    }

    public void B(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.u> a2;
        Lr();
        if (arrayList != null && arrayList.size() != 0 && (a2 = this.aVd.a(false, arrayList)) != null) {
            this.aUN.ad(a2);
            this.aUL.a(a2, this.mPn, this.aUN, 0);
        }
    }

    private void Lr() {
        if (this.aVe == 0 && !this.aVd.Y(this.aUN.atd())) {
            if (this.aUN.getThreadList() == null || this.aUN.getThreadList().size() == 0) {
                this.aUL.Mh();
                return;
            } else {
                this.aUL.Mg();
                return;
            }
        }
        this.aUL.Mf();
    }

    public void loadMore() {
        if (this.aUZ.Nh() == 1) {
            if (!this.aVd.axc && !this.aUZ.isLoading()) {
                if (this.aVd.Y(this.aUN.atd())) {
                    this.aUL.a(this.aVd.MN(), this.mPn, this.aUN, 0);
                    this.aVd.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.aUN.atd());
                } else if (this.aVe != 0) {
                    this.aUL.a(this.aVd.MN(), this.mPn, this.aUN, 0);
                    this.mPn++;
                    this.aUZ.fF(this.mPn);
                    this.aVd.aZL = false;
                    this.aVd.aZM = 0;
                }
            }
        } else if (!this.aUZ.Nl()) {
            if (this.aVa.NP() != null) {
                this.aVa.NP().a(this.aUZ.Nh(), this.aUZ.Ni(), this.aUZ.Nj());
            }
            this.aUZ.Ht();
        }
    }
}
