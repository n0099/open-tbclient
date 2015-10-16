package com.baidu.tieba.frs;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
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
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveHeadlineActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
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
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.ef;
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
    public static String aTD;
    private static final int aTE = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90);
    private static final int aTF = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds300);
    public static boolean aTJ = false;
    public static volatile long aUb = 0;
    public static volatile long aUc = 0;
    public static volatile int aUd = 0;
    private static boolean isNeedRefreshOnResume = false;
    private String aSA;
    private boolean aSz;
    private com.baidu.tbadk.core.data.w aTG;
    private boolean aTK;
    private com.baidu.tbadk.core.data.w aTL;
    private com.baidu.tieba.tbadkCore.data.b aTR;
    private dg aTX;
    private com.baidu.adp.lib.e.b<TbImageView> aTZ;
    private a aUg;
    private com.baidu.tieba.frs.mc.a aUi;
    private com.baidu.tieba.frs.b.o aUj;
    private com.baidu.tieba.frs.b.a aUk;
    private com.baidu.tieba.frs.b.k aUl;
    private com.baidu.tieba.frs.loadmore.a aUm;
    private com.baidu.adp.lib.e.b<TbImageView> aeI;
    VoiceManager mVoiceManager;
    private boolean aTH = false;
    public boolean aTI = false;
    public String aTM = null;
    public String mFrom = null;
    public int aTN = 0;
    private int mPn = 1;
    private boolean aTO = false;
    private boolean aTP = false;
    private String mThreadId = null;
    private String forumId = null;
    private int aTQ = 0;
    private boolean aTS = false;
    private boolean aTT = false;
    private bs aTU = null;
    private final com.baidu.tbadk.core.data.w aTV = null;
    private com.baidu.tieba.tbadkCore.o aTW = new com.baidu.tieba.tbadkCore.o();
    private com.baidu.tbadk.core.data.w aTY = null;
    private boolean Jj = false;
    public long aLJ = -1;
    public long axy = 0;
    public long createTime = 0;
    public long aUa = -1;
    private boolean aUe = false;
    public com.baidu.tbadk.performanceLog.e aUf = null;
    private boolean aUh = true;
    private int aUn = -1;
    private SparseArray<String> aUo = null;
    private eb aUp = new com.baidu.tieba.frs.a(this);
    private ea aUq = new l(this);
    private CustomMessageListener aSF = new x(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener aRm = new ai(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
    private CustomMessageListener aHz = new an(this, CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND);
    public final CustomMessageListener aUr = new ao(this, CmdConfigCustom.MSG_NEW);
    private CustomMessageListener aUs = new ap(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    private boolean aUt = false;
    public final com.baidu.tieba.tbadkCore.r aUu = new aq(this);
    private final CustomMessageListener Ts = new ar(this, CmdConfigCustom.CMD_REFRESH);
    private final CustomMessageListener mMemListener = new b(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private final com.baidu.adp.framework.listener.a aUv = new c(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    private final p.a aUw = new d(this);
    private final BdListView.g HE = new e(this);
    public final View.OnClickListener aUx = new f(this);
    private final AbsListView.OnScrollListener aSH = new g(this);
    private final bd aUy = new h(this);
    private final com.baidu.tieba.tbadkCore.ae aSJ = new com.baidu.tieba.tbadkCore.ae(getPageContext(), new i(this));
    private final View.OnClickListener aUz = new j(this);
    private final View.OnClickListener aUA = new k(this);
    public final AdapterView.OnItemClickListener aUB = new m(this);
    private final NoNetworkView.a aSa = new n(this);
    private final CustomMessageListener aUC = new o(this, 0);
    private com.baidu.adp.widget.ListView.v aUD = new p(this);
    private View.OnClickListener aUE = new r(this);
    private View.OnClickListener aUF = new s(this);
    private com.baidu.adp.widget.ListView.w aUG = new t(this);
    private final SlidingMenu.OnOpenedListener aUH = new u(this);
    public final com.baidu.adp.base.g aUI = new v(this);
    public final com.baidu.adp.base.g aUJ = new w(this);

    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    public void a(ErrorData errorData) {
        this.aTU.cc(false);
        this.aTU.cd(false);
        this.aTU.ce(false);
        this.aTU.LQ();
        hideLoadingView(this.aTU.getRootView());
        this.aTU.LX();
        if (!this.aTT) {
            e.a Ne = Lm().Ne();
            if (!this.aTH) {
                if (Ne != null) {
                    if (Ne.cWT) {
                        if (340001 == Ne.errorCode) {
                            showNetRefreshViewNoClick(this.aTU.getRootView(), getPageContext().getResources().getString(i.h.net_error_text, Ne.errorMsg, Integer.valueOf(Ne.errorCode)), true);
                        } else {
                            showNetRefreshView(this.aTU.getRootView(), getPageContext().getResources().getString(i.h.net_error_text, Ne.errorMsg, Integer.valueOf(Ne.errorCode)), true);
                        }
                    } else if (340001 == Ne.errorCode) {
                        showNetRefreshViewNoClick(this.aTU.getRootView(), Ne.errorMsg, true);
                    } else {
                        showNetRefreshView(this.aTU.getRootView(), Ne.errorMsg, true);
                    }
                    this.aTU.fA(8);
                }
            } else if (Ne != null && Ne.cWT) {
                this.aTU.fA(0);
                showToast(getPageContext().getResources().getString(i.h.net_error_text, Ne.errorMsg, Integer.valueOf(Ne.errorCode)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.m mVar) {
        boolean z;
        if (!this.aUt && mVar != null) {
            try {
                this.aTW.d(mVar);
                if (this.aTW.aeT() == 1) {
                    this.aTU.LZ().setFromCDN(true);
                } else {
                    this.aTU.LZ().setFromCDN(false);
                }
                this.aUn = this.aTW.getPage().rL();
                this.aTU.b(this.aTW.aeN(), this.aTW.getUserData());
                if (this.aTW.avG() == null) {
                    z = false;
                } else {
                    z = this.aTW.avG().size() != 0;
                }
                this.aUk.a(this.aTW.avu().avK() == 1, this.aTW.getUserData().getIsMem(), this.aTW.aeN().isLike(), z);
                this.aTU.LP();
                this.aTM = this.aTW.aeN().getName();
                this.forumId = this.aTW.aeN().getId();
                this.aTU.setTitle(this.aTM);
                KZ();
                this.aTW.avT();
                this.aTW.avX();
                if (!Lm().Nd() && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.aTW.avW();
                    this.aTW.avV();
                }
                if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                    this.aTW.aP(getPageContext().getPageActivity());
                }
                com.baidu.tbadk.core.data.y top_notice_data = this.aTW.aeN().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.getTitle() != null) {
                    com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                    wVar.setTitle(top_notice_data.getTitle());
                    wVar.bA(2);
                    wVar.cn(top_notice_data.sK());
                    wVar.parser_title();
                    this.aTW.f(wVar);
                }
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aTW.getThreadList();
                if (threadList != null) {
                    ArrayList<com.baidu.adp.widget.ListView.u> a2 = this.aUm.a(true, threadList);
                    if (a2 != null) {
                        this.aTW.af(a2);
                    }
                    this.aTU.a(threadList, this.mPn, this.aTW, this.aTW.getPage().rL());
                    Lf();
                    this.aUk.fU(this.mPn);
                    this.aUk.c(this.aTW);
                    this.aTU.LT();
                    this.aTU.fz(0);
                }
                this.aTQ = this.aTW.Nj();
                this.aUk.cj(this.aTW.avw());
                hideLoadingView(this.aTU.getRootView());
                this.aTU.fA(0);
                this.aTU.LX();
                this.aTH = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        aTD = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (intent != null) {
            this.aLJ = intent.getLongExtra("TibaStatic.StartTime", -1L);
            if (intent.getData() != null) {
                Uri data = intent.getData();
                this.aTM = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.aTM)) {
                    intent.putExtra("name", this.aTM);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.aTM)) {
                this.aTM = M(intent);
                if (!StringUtils.isNull(this.aTM)) {
                    intent.putExtra("name", this.aTM);
                }
            }
        } else {
            this.aLJ = System.currentTimeMillis();
        }
        if (this.aLJ != -1) {
            this.aUa = this.aLJ;
        } else {
            this.aUa = System.currentTimeMillis();
        }
        if (!bZ(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.aUa;
            return;
        }
        super.onCreate(bundle);
        this.aUi = new com.baidu.tieba.frs.mc.a(this);
        this.aUi.a(this.aUp);
        this.aUi.init();
        if (getIntent() != null) {
            this.aUi.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.aUi.f(bundle);
        } else {
            this.aUi.f(null);
        }
        Lm().oR();
        setContentView(i.g.frs_activity);
        this.aUj = new com.baidu.tieba.frs.b.o(this);
        this.aUl = new com.baidu.tieba.frs.b.k(this);
        this.aUk = new com.baidu.tieba.frs.b.a(this, this.aUj);
        this.aUj.oQ();
        if (getIntent() != null) {
            this.aUk.h(getIntent().getExtras());
        } else if (bundle != null) {
            this.aUk.h(bundle);
        } else {
            this.aUk.h((Bundle) null);
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        this.aSJ.setUniqueId(getUniqueId());
        this.aSJ.registerListener();
        addGlobalLayoutListener();
        KQ();
        registerListener(this.Ts);
        registerListener(this.mMemListener);
        registerListener(this.aUr);
        registerListener(this.aSF);
        registerListener(this.aHz);
        registerListener(this.aRm);
        registerListener(this.aUs);
        this.aUv.getSocketMessageListener().setSelfListener(true);
        this.aUv.getHttpMessageListener().setSelfListener(true);
        this.aUv.setTag(getUniqueId());
        registerListener(this.aUv);
        this.aUm = new com.baidu.tieba.frs.loadmore.a(this);
        this.aUm.registerListener();
        this.aTR = new com.baidu.tieba.tbadkCore.data.b("frs");
        this.createTime = System.currentTimeMillis() - this.aLJ;
        if (this.aTU != null) {
            showLoadingView(this.aTU.getRootView(), true);
            this.aTU.LY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
        } else if (this.aTW != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null && this.aTU != null) {
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
            this.aUi.a(mVar);
            ArrayList<com.baidu.adp.widget.ListView.u> a2 = this.aUm.a(true, this.aTW.getThreadList());
            if (a2 != null) {
                this.aTW.af(a2);
                this.aTU.a(a2, this.mPn, this.aTW, this.aUn);
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

    private void KQ() {
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
        KS();
        if (bundle != null) {
            this.aTM = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aTN = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.aTM = intent.getStringExtra("name");
                this.mFrom = intent.getStringExtra("from");
                this.aTN = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            setSwipeBackEnabled(false);
        }
        this.aTX = new dg(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            KR();
            KT();
        }
        this.aUk.h(bundle);
    }

    private String M(Intent intent) {
        int indexOf;
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (!StringUtils.isNull(dataString) && dataString.startsWith("tbfrs://")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10320").r("obj_locate", 2).r("obj_type", 1));
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (StringUtils.isNull(decode) || (indexOf = decode.indexOf("kw=")) < 0 || (length = indexOf + "kw=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public void KR() {
        if (this.aTX != null && this.aTU != null) {
            if (FrsActivityStatic.aVa || FrsActivityStatic.aVb || FrsActivityStatic.aVc) {
                this.aTX.ap(com.baidu.tbadk.coreExtra.messageCenter.a.wK().getMsgReplyme());
                this.aTX.ao(com.baidu.tbadk.coreExtra.messageCenter.a.wK().getMsgAtme());
                int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.wK().getMsgChat();
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xy() && !TbadkCoreApplication.m411getInst().isMIUIRom()) {
                    msgChat -= com.baidu.tbadk.coreExtra.messageCenter.a.wK().wR();
                }
                this.aTX.aq(msgChat);
                this.aTU.a(this.aTX);
                this.aUl.a(this.aTX);
            }
        }
    }

    private void KS() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.aUC);
    }

    private void KT() {
        registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.aUC);
    }

    private boolean bZ(boolean z) {
        if (z && com.baidu.tieba.frs.utils.a.I(getPageContext().getPageActivity(), getClass().getName())) {
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
        if (this.aTU != null) {
            this.aTU.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.aUf != null) {
                this.aUf.onDestroy();
            }
            this.aTU.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.aUi.onActivityDestroy();
        this.aUj.onActivityDestroy();
        this.aUk.onActivityDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
        if (this.aUg != null) {
            this.aUg.cancel(true);
            this.aUg = null;
        }
        if (this.aUi != null) {
            this.aUi.Ku();
        }
        if (this.aUl != null) {
            this.aUl.destroy();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aTM);
        bundle.putString("from", this.mFrom);
        this.aUi.onSaveInstanceState(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.w lu;
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    fq(0);
                    return;
                case 11002:
                    this.aUk.oN();
                    return;
                case 11011:
                    b(this.aTV);
                    return;
                case 11012:
                    c(this.aTY);
                    return;
                case 11014:
                    this.aUk.NG();
                    return;
                case 11016:
                    this.aTU.LS();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    this.aUk.Ll();
                    return;
                case 13003:
                    if (intent != null && !Lm().Nd()) {
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
                                com.baidu.adp.lib.g.h.hg().postDelayed(new y(this, c2, c, c3), 1000L);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 18003:
                    this.aTU.LZ().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (lu = this.aTW.lu(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            lu.bB(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            lu.parser_title();
                            refresh();
                            return;
                        } else if (intExtra == 0) {
                            this.aTW.g(lu);
                            this.aTU.LT();
                            if (com.baidu.tieba.tbadkCore.d.avt() != null) {
                                com.baidu.tieba.tbadkCore.d.avt().H(this.aTM, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    Lc();
                    return;
                case 23003:
                    if (intent != null && this.aTW != null) {
                        a(Lo(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    N(intent);
                    return;
                case 23013:
                    Ld();
                    return;
                case 23019:
                    Le();
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
        this.aUl.NN();
        this.aUk.a(this.aUq);
        this.aSz = true;
        this.aUh = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.aTU.nw();
        } else if (aTJ) {
            aTJ = false;
            this.aTU.nw();
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
            this.aTU.Mc();
            this.aUl.NO().setSlidingEnabled(true);
            refresh();
            return;
        }
        this.aTU.Mb();
        this.aUl.NO().setSlidingEnabled(false);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.aTM = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.aTP = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aTP) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    KU();
                } else {
                    KV();
                }
            }
        }
    }

    private void KU() {
        this.aTU.nw();
        this.aUl.NO().showContent(false);
    }

    private void KV() {
        this.aTU.nw();
        this.aUl.NO().showContent(false);
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
        this.aTU.LZ().h(this.aUz);
        this.aTU.LZ().i(this.aUA);
        if (this.aTN == 0) {
            this.aTU.setTitle(this.aTM);
        } else {
            this.aTU.setTitle("");
            this.aTN = 1;
        }
        this.aUl.NO();
        this.aUk.t(this.aTU.getListView());
        this.aTU.a(this.aUD);
        this.aTU.a(this.aUG);
        this.aTU.j(this.aUE);
        this.aTU.l(this.aUF);
        this.aTU.setOnScrollListener(this.aSH);
        this.aTU.a(this.HE);
        this.aTU.a(this.aUw);
        this.aTU.g(this.aSa);
        this.aUl.NO().setOnOpenedListener(this.aUH);
        this.aTU.LZ().a(this.aUy);
        if (!this.mIsLogin) {
            this.aTU.Mb();
            this.aUl.NO().setSlidingEnabled(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.aTU.onChangeSkinType(i);
        this.aUl.a(getPageContext(), i);
        this.aUk.a(getPageContext(), i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> KD() {
        if (this.aTZ == null) {
            this.aTZ = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.aTZ;
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
            return Boolean.valueOf(com.baidu.tieba.frs.utils.a.J(FrsActivity.this.getPageContext().getPageActivity(), this.name));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                FrsActivity.this.showToast(i.h.shortcut_has_add);
            } else {
                FrsActivity.this.gM(this.name);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gM(String str) {
        Intent K;
        if (str != null && (K = com.baidu.tieba.frs.utils.a.K(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(i.h.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", K);
            BarImageView NF = this.aUk.NF();
            if (NF != null && NF.getBdImage() != null && NF.getBdImage().na() != null) {
                Bitmap na = NF.getBdImage().na();
                Float valueOf = Float.valueOf(getResources().getDisplayMetrics().density);
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.d.iu().a(com.baidu.adp.lib.util.d.iu().d(na, valueOf.intValue() * 48), valueOf.intValue() * 6));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), i.e.icon));
            }
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fq(int i) {
        if (!this.mIsLogin) {
            if (this.aTW != null && this.aTW.rF() != null) {
                this.aTW.rF().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.aTW != null) {
            if (i == 0) {
                if (!this.aTK) {
                    fr(0);
                    return;
                }
                TiebaStatic.log("c10152");
                fr(4);
                return;
            }
            this.aTU.LS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fr(int i) {
        int i2 = 0;
        if (this.aTW.getUserData() != null) {
            i2 = this.aTW.getUserData().getIsMem();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(getPageContext().getPageActivity(), i, this.aTW.aeN().getId(), this.aTM, null, null, 0, this.aTW.rF(), 13003, false, false, null, false, false, null, null, this.aTW.aeN().getPrefixData(), i2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.w wVar) {
        boolean sE = wVar == null ? true : wVar.sE();
        this.aTU.c(new z(this, wVar));
        this.aTU.a(wVar, sE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KW() {
        this.aTU.b(new aa(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KX() {
        this.aTU.a(new ab(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KY() {
        AntiData rF = this.aTW.rF();
        if (rF != null) {
            if (AntiHelper.e(rF) || AntiHelper.f(rF) || AntiHelper.g(rF)) {
                rF.setBlock_forum_name(this.aTM);
                rF.setBlock_forum_id(this.aTW.aeN().getId());
                rF.setUser_name(this.aTW.getUserData().getUserName());
                rF.setUser_id(this.aTW.getUserData().getUserId());
                if (AntiHelper.a(getPageContext().getPageActivity(), rF, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!TextUtils.isEmpty(rF.getPollMessage())) {
                com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), rF.getPollMessage());
                return;
            }
        }
        PostPrefixData postPrefixData = null;
        if (this.aTW.aeN() != null) {
            postPrefixData = this.aTW.aeN().getPrefixData();
        }
        int i = 0;
        if (this.aTW.getUserData() != null) {
            i = this.aTW.getUserData().getIsMem();
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVoteActivityConfig(getPageContext().getPageActivity(), this.aTW.aeN().getId(), this.aTM, rF, 13003, postPrefixData, i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.w wVar) {
        boolean sE = wVar == null ? true : wVar.sE();
        if (this.mThreadId != null) {
            if (!sE) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aTM, null, 18003, true, true, this.aTS)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aTM, null, 18003, false, false, this.aTS)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.w wVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aTM, null, 18003, false, false, this.aTS)));
        }
    }

    public void refresh() {
        stopVoice();
        if (this.aUj != null && this.aUj.NP() != null) {
            this.aUj.NP().a(this.aUi.Ng(), this.aUi.Nh(), this.aUi.Ni());
        }
        Lm().bB(true);
    }

    private void KZ() {
        switch (this.aTN) {
            case 1:
                com.baidu.adp.lib.g.k.hh().c(new ac(this));
                break;
        }
        this.aTN = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void La() {
        stopVoice();
        try {
            if (this.aTW != null) {
                this.aTU.LP();
                this.aTM = this.aTW.aeN().getName();
                this.forumId = this.aTW.aeN().getId();
                this.aTU.setTitle(this.aTM);
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.aTW.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.aTW.getUserData().getBimg_end_time());
                KZ();
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aTW.getThreadList();
                if (threadList != null) {
                    this.aTU.a(threadList, this.mPn, this.aTW, this.aTW.getPage().rL());
                    Lf();
                    this.aUk.fU(this.mPn);
                    this.aUk.c(this.aTW);
                    this.aTU.LT();
                    if (this.aTW.aeT() == 1) {
                        this.aTU.LZ().setFromCDN(true);
                    } else {
                        this.aTU.LZ().setFromCDN(false);
                    }
                    this.aTU.fz(V(Lm().getType(), this.mPn));
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
        this.aSz = false;
        this.aUh = false;
        this.aTU.onPause();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Object c;
        super.onStop();
        if (this.aTW != null && this.aTW.aeN() != null) {
            com.baidu.tbadk.distribute.a.Ag().a(getPageContext().getPageActivity(), "frs", this.aTW.aeN().getId(), 0L);
        }
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
        BdListView listView = getListView();
        if (listView != null && (c = com.baidu.adp.lib.a.a.a.c(listView, "mRecycler")) != null) {
            com.baidu.adp.lib.a.a.a.a("clear", c, c.getClass());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.aTO) {
            if (i == 4) {
                if (this.aUl.onBackPressed()) {
                    return true;
                }
                closeActivity();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void a(com.baidu.tbadk.core.data.b bVar, int i) {
        String trim;
        if (bVar != null) {
            if (bVar.rr()) {
                com.baidu.tbadk.core.util.az.uW().b(getPageContext(), new String[]{bVar.TY});
            } else if (bVar.rq()) {
                if (com.baidu.adp.lib.util.i.iM() && !com.baidu.adp.lib.util.i.iN()) {
                    trim = getPageContext().getString(i.h.frs_network_tips);
                } else if (TextUtils.isEmpty(bVar.Uj.Up.trim())) {
                    trim = getPageContext().getString(i.h.confirm_download_app);
                } else {
                    trim = bVar.Uj.Up.trim();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cu(trim);
                aVar.a(i.h.alert_yes_button, new ad(this, bVar, i));
                aVar.b(i.h.alert_no_button, new ae(this));
                aVar.b(getPageContext()).sR();
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.b bVar, int i) {
        if (bVar != null) {
            if (!bVar.rp()) {
                com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), i.h.pb_app_error);
            } else if (com.baidu.adp.lib.util.i.iM()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", bVar.Ua);
                com.baidu.tbadk.download.b.An().a(bVar.Ua, bVar.TZ, bVar.TW, i, com.baidu.adp.lib.g.b.g(bVar.TV, 0));
            } else {
                showToast(i.h.neterror);
            }
        }
    }

    public void Lb() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
        this.aUg = new a(this.aTM);
        this.aUg.setSelfExecute(true);
        this.aUg.execute(new String[0]);
    }

    public void Lc() {
        com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.aTW.aeN().getId(), true, true, true);
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Ag().a(getPageContext().getPageActivity(), bVar, str, "frs", this.aTW.aeN().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Ag().a(bVar, this.forumId, 0L, "FRS", str, this.mPn);
    }

    public void Ld() {
        if (!fs(23013)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10177").ae(ImageViewerConfig.FORUM_ID, this.forumId));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(getPageContext().getPageActivity(), String.valueOf(getForumId()), false, 0)));
        }
    }

    public void Le() {
        if (!fs(23019) && this.aTL != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(getPageContext().getPageActivity()).createConfig(String.valueOf(getForumId()), this.aTL.getTid(), 1)));
        }
    }

    private boolean fs(int i) {
        if (TbadkCoreApplication.isLogin()) {
            return false;
        }
        TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getResources().getString(i.h.login_to_use), true, i)));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(int i) {
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aTW.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.w) {
                    com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) next;
                    if (wVar == this.aTG) {
                        b(wVar, i);
                        this.aTG = null;
                        break;
                    } else if (wVar.getId() != null && wVar.getId().equals(this.aSA)) {
                        b(wVar, i);
                        this.aSA = null;
                        break;
                    }
                }
            }
            this.aTU.LZ().a(threadList, this.aTW);
            this.aTU.LZ().notifyDataSetChanged();
        }
    }

    private void b(com.baidu.tbadk.core.data.w wVar, int i) {
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

    public void a(ef.a aVar, String str) {
        if (str != null) {
            Lm().av(aVar.aZA, str);
            this.aUl.NM();
            this.aTM = str;
            if (this.aTU != null) {
                this.aTU.setTitle(this.aTM);
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
        if (this.aTU == null) {
            return null;
        }
        return this.aTU.getListView();
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
    public int vD() {
        if (this.aTU == null) {
            return 0;
        }
        return this.aTU.LW();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> vE() {
        if (this.aeI == null) {
            this.aeI = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.aeI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.aTX != null) {
                this.aTX.ap(msgReplyme);
                this.aTX.ao(msgAtme);
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xy() && !TbadkCoreApplication.m411getInst().isMIUIRom()) {
                    this.aTX.aq((msgChat - newsNotifyMessage.getMsgPrivateChat()) - newsNotifyMessage.getMsgStrangerChat());
                } else {
                    this.aTX.aq(msgChat);
                }
                this.aTU.a(this.aTX);
                this.aUl.a(this.aTX);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        bb LZ;
        HashMap<Integer, com.baidu.tbadk.core.data.w> Lu;
        if (this.aTW != null && this.aTU != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (LZ = this.aTU.LZ()) != null && (Lu = LZ.Lu()) != null && Lu.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.w> entry : Lu.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.w value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.b) && TextUtils.equals(((com.baidu.tbadk.core.data.b) value).Ua, downloadData.getId())) {
                            int avS = this.aTW.avS();
                            if (LZ.aA(intValue + avS) instanceof com.baidu.tbadk.core.data.b) {
                                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) LZ.aA(avS + intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    bVar.TU = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!com.baidu.tbadk.core.util.as.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    bVar.TU = 0;
                                } else if (status == 1) {
                                    bVar.TU = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.aTU.LQ();
        }
    }

    private void Lf() {
        HashMap<Integer, com.baidu.tbadk.core.data.w> Lu;
        if (this.aTU != null && this.aTU.LZ() != null && (Lu = this.aTU.LZ().Lu()) != null) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.w> entry : Lu.entrySet()) {
                com.baidu.tbadk.core.data.w value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.b)) {
                    arrayList.add((com.baidu.tbadk.core.data.b) value);
                }
            }
            com.baidu.tbadk.download.b.An().o(arrayList);
        }
    }

    public void Lg() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.b bVar, int i) {
        if (bVar != null) {
            a(bVar, "area_click");
            b(bVar, "click");
            com.baidu.tieba.recapp.report.b.apG().a(com.baidu.tieba.recapp.report.e.a(bVar, "click", this.mPn));
            int i2 = bVar.TU;
            if (i2 == 0) {
                a(bVar, i);
            } else if (i2 == 2) {
                com.baidu.tieba.frs.utils.a.H(getPageContext().getPageActivity(), bVar.Ua);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", bVar.Ua);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.b bVar) {
        if (bVar != null) {
            a(bVar, "btn_click");
            b(bVar, "click");
            com.baidu.tieba.recapp.report.b.apG().a(com.baidu.tieba.recapp.report.e.a(bVar, "click", this.mPn));
            com.baidu.tbadk.core.util.az.uW().b(getPageContext(), new String[]{bVar.TY});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.aTU.getRootView());
        showLoadingView(this.aTU.getRootView(), true);
        this.aTU.LY();
        this.aTU.nw();
    }

    public com.baidu.tieba.tbadkCore.o Lh() {
        return this.aTW;
    }

    public boolean Li() {
        return this.aTU.Li();
    }

    public void Lj() {
        FrsActivityStatic.aVa = false;
        FrsActivityStatic.aVc = false;
        KR();
    }

    public void Lk() {
        FrsActivityStatic.aVa = false;
        FrsActivityStatic.aVb = false;
        KR();
    }

    public void Ll() {
        this.aUk.Ll();
    }

    public com.baidu.tieba.frs.mc.a Lm() {
        return this.aUi;
    }

    public void a(bs bsVar) {
        this.aTU = bsVar;
    }

    public void gN(String str) {
        this.aTM = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFlag(int i) {
        this.aTN = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    public void resetData() {
        this.aTH = false;
        this.aTT = false;
        this.aTW = null;
        this.aTU.setTitle(this.aTM);
        this.aUl.cl(false);
        this.aUl.setIsManager(false);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.jd()) {
            this.aTU.Mg();
        } else if (this.aUi.Ng() == 1) {
            Ln();
            loadMore();
        } else if (this.aUi.hasMore()) {
            loadMore();
        }
    }

    public void gO(String str) {
        Ln();
        showToast(str);
    }

    public void B(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.u> a2;
        Ln();
        if (arrayList != null && arrayList.size() != 0 && (a2 = this.aUm.a(false, arrayList)) != null) {
            this.aTW.af(a2);
            this.aTU.a(a2, this.mPn, this.aTW, 0);
        }
    }

    private void Ln() {
        if (this.aUn == 0 && !this.aUm.Z(this.aTW.avz())) {
            if (this.aTW.getThreadList() == null || this.aTW.getThreadList().size() == 0) {
                this.aTU.Mg();
                return;
            } else {
                this.aTU.Mf();
                return;
            }
        }
        this.aTU.Me();
    }

    public void loadMore() {
        if (this.aUi.Ng() == 1) {
            if (!this.aUm.avC && !this.aUi.isLoading()) {
                if (this.aUm.Z(this.aTW.avz())) {
                    this.aTU.a(this.aUm.MM(), this.mPn, this.aTW, 0);
                    this.aUm.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.aTW.avz());
                } else if (this.aUn != 0) {
                    this.aTU.a(this.aUm.MM(), this.mPn, this.aTW, 0);
                    this.mPn++;
                    this.aUi.fK(this.mPn);
                    this.aUm.aZP = false;
                    this.aUm.aZQ = 0;
                }
            }
        } else if (!this.aUi.Nk()) {
            if (this.aUj.NP() != null) {
                this.aUj.NP().a(this.aUi.Ng(), this.aUi.Nh(), this.aUi.Ni());
            }
            this.aUi.Hn();
        }
    }

    public void showShareDialog() {
        String name;
        if (this.aTW != null && this.aTW.aeN() != null) {
            if (this.aTW.aeN().getName() == null) {
                showToast(getPageContext().getString(i.h.no_forum_data));
                return;
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String str = "http://tieba.baidu.com/f?kw=" + this.aTW.aeN().getName();
            Uri parse = this.aTW.aeN().getImage_url() == null ? null : Uri.parse(this.aTW.aeN().getImage_url());
            String slogan = this.aTW.aeN().getSlogan();
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = String.valueOf(name) + getPageContext().getString(i.h.forum);
            fVar.content = slogan;
            fVar.linkUrl = str;
            fVar.aiO = true;
            fVar.extData = getForumId();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true, qv());
            shareDialogConfig.addOutsideTextView(i.h.share_tieba_qunzu, i.e.icon_unite_share_qunzu, new af(this));
            shareDialogConfig.addOutsideTextView(i.h.forum_friend, i.e.icon_unite_share_baf, new ag(this));
            shareDialogConfig.setCopyLinkListener(new ah(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private SparseArray<String> qv() {
        if (this.aUo == null) {
            this.aUo = new SparseArray<>(7);
            this.aUo.put(2, "frs_wx_timeline");
            this.aUo.put(3, "frs_wx_friend");
            this.aUo.put(4, "frs_qq_zone");
            this.aUo.put(5, "frs_tencent_weibo");
            this.aUo.put(6, "frs_sina_weibo");
        }
        return this.aUo;
    }

    private ShareFromFrsMsgData Lo() {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(this.aTW.aeN().getImage_url());
        shareFromFrsMsgData.setName(this.aTW.aeN().getName());
        shareFromFrsMsgData.setMemberNum(this.aTW.aeN().getMember_num());
        shareFromFrsMsgData.setPostNum(this.aTW.aeN().getPost_num());
        shareFromFrsMsgData.setContent(this.aTW.aeN().getSlogan());
        return shareFromFrsMsgData;
    }

    private void N(Intent intent) {
        a(Lo(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromFrsMsgData shareFromFrsMsgData, long j, String str, String str2) {
        if (this.aTW != null && this.aTW.aeN() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.p pVar = new com.baidu.tieba.frs.view.p(getPageContext().getPageActivity());
            pVar.setData(shareFromFrsMsgData);
            aVar.bH(1);
            aVar.m(pVar);
            aVar.a(i.h.share, new aj(this, pVar, j, str, str2, shareFromFrsMsgData));
            aVar.b(i.h.alert_no_button, new ak(this, pVar));
            aVar.ak(false);
            aVar.b(getPageContext()).sR();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                pVar.w(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }

    private void a(ShareFromFrsMsgData shareFromFrsMsgData, int i, String str, long j) {
        if (this.aTW != null && this.aTW.aeN() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.p pVar = new com.baidu.tieba.frs.view.p(getPageContext().getPageActivity());
            pVar.setData(shareFromFrsMsgData);
            aVar.bH(1);
            aVar.m(pVar);
            aVar.a(i.h.share, new al(this, pVar, i, str, j, shareFromFrsMsgData));
            aVar.b(i.h.alert_no_button, new am(this, pVar));
            aVar.ak(false);
            aVar.b(getPageContext()).sR();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                pVar.w(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }
}
