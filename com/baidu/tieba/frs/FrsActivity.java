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
import com.baidu.tieba.frs.eh;
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
    public static String aTL;
    private static final int aTM = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90);
    private static final int aTN = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds300);
    public static boolean aTR = false;
    public static volatile long aUj = 0;
    public static volatile long aUk = 0;
    public static volatile int aUl = 0;
    private static boolean isNeedRefreshOnResume = false;
    private boolean aSH;
    private String aSI;
    private com.baidu.tbadk.core.data.w aTO;
    private boolean aTS;
    private com.baidu.tbadk.core.data.w aTT;
    private com.baidu.tieba.tbadkCore.data.e aTZ;
    private dg aUf;
    private com.baidu.adp.lib.e.b<TbImageView> aUh;
    private a aUo;
    private com.baidu.tieba.frs.mc.a aUq;
    private com.baidu.tieba.frs.b.o aUr;
    private com.baidu.tieba.frs.b.a aUs;
    private com.baidu.tieba.frs.b.l aUt;
    private com.baidu.tieba.frs.loadmore.a aUu;
    private com.baidu.adp.lib.e.b<TbImageView> aeN;
    VoiceManager mVoiceManager;
    private boolean aTP = false;
    public boolean aTQ = false;
    public String aTU = null;
    public String mFrom = null;
    public int aTV = 0;
    private int mPn = 1;
    private boolean aTW = false;
    private boolean aTX = false;
    private String mThreadId = null;
    private String forumId = null;
    private int aTY = 0;
    private boolean aUa = false;
    private boolean aUb = false;
    private bs aUc = null;
    private final com.baidu.tbadk.core.data.w aUd = null;
    private com.baidu.tieba.tbadkCore.o aUe = new com.baidu.tieba.tbadkCore.o();
    private com.baidu.tbadk.core.data.w aUg = null;
    private boolean Jk = false;
    public long aLR = -1;
    public long awn = 0;
    public long createTime = 0;
    public long aUi = -1;
    private boolean aUm = false;
    public com.baidu.tbadk.performanceLog.e aUn = null;
    private boolean aUp = true;
    private int aUv = -1;
    private SparseArray<String> aUw = null;
    private ed aUx = new com.baidu.tieba.frs.a(this);
    private ec aUy = new l(this);
    private CustomMessageListener aSN = new x(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener aRu = new ai(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
    private CustomMessageListener aGt = new an(this, CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND);
    public final CustomMessageListener aUz = new ao(this, CmdConfigCustom.MSG_NEW);
    private CustomMessageListener aUA = new ap(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    private boolean aUB = false;
    public final com.baidu.tieba.tbadkCore.r aUC = new aq(this);
    private final CustomMessageListener Tt = new ar(this, CmdConfigCustom.CMD_REFRESH);
    private final CustomMessageListener mMemListener = new b(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private final com.baidu.adp.framework.listener.a aUD = new c(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    private final p.a aUE = new d(this);
    private final BdListView.g HF = new e(this);
    public final View.OnClickListener aUF = new f(this);
    private final AbsListView.OnScrollListener aSP = new g(this);
    private final bd aUG = new h(this);
    private final com.baidu.tieba.tbadkCore.ae aSR = new com.baidu.tieba.tbadkCore.ae(getPageContext(), new i(this));
    private final View.OnClickListener aUH = new j(this);
    private final View.OnClickListener aUI = new k(this);
    public final AdapterView.OnItemClickListener aUJ = new m(this);
    private final NoNetworkView.a aSi = new n(this);
    private final CustomMessageListener aUK = new o(this, 0);
    private com.baidu.adp.widget.ListView.v aUL = new p(this);
    private View.OnClickListener aUM = new r(this);
    private View.OnClickListener aUN = new s(this);
    private com.baidu.adp.widget.ListView.w aUO = new t(this);
    private final SlidingMenu.OnOpenedListener aUP = new u(this);
    public final com.baidu.adp.base.g aUQ = new v(this);
    public final com.baidu.adp.base.g aUR = new w(this);

    public String getForumId() {
        return this.forumId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.x xVar) {
        if (xVar != null) {
            boolean z = xVar.isLike() == 1;
            if (this.aUc != null && this.aUe != null && this.aUe.afg() != null) {
                this.aUe.afg().setLike(xVar.isLike());
                if (!StringUtils.isNULL(xVar.getLevelName())) {
                    this.aUe.afg().setLevelName(xVar.getLevelName());
                }
                if (xVar.auf() >= 0) {
                    this.aUe.afg().setUser_level(xVar.auf());
                }
                if (z) {
                    this.aUs.a(this.aUe, false);
                    this.aUt.cn(true);
                    TbadkCoreApplication.m411getInst().addLikeForum(this.aTU);
                    return;
                }
                com.baidu.tieba.tbadkCore.d.avW().H(this.aTU, false);
                this.aUe.afg().setLike(0);
                this.aUs.NN();
                this.aUt.cn(false);
                TbadkCoreApplication.m411getInst().delLikeForum(this.aTU);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    public void a(ErrorData errorData) {
        this.aUc.ce(false);
        this.aUc.cf(false);
        this.aUc.cg(false);
        this.aUc.Mc();
        hideLoadingView(this.aUc.getRootView());
        this.aUc.Mj();
        if (!this.aUb) {
            e.a Ns = Ly().Ns();
            if (!this.aTP) {
                if (Ns != null) {
                    if (this.aUq.Nt() != 0) {
                        this.aUq.NA();
                        this.aUc.Mc();
                    } else if (Ns.cYp) {
                        if (340001 == Ns.errorCode) {
                            showNetRefreshViewNoClick(this.aUc.getRootView(), getPageContext().getResources().getString(i.h.net_error_text, Ns.errorMsg, Integer.valueOf(Ns.errorCode)), true);
                        } else {
                            showNetRefreshView(this.aUc.getRootView(), getPageContext().getResources().getString(i.h.net_error_text, Ns.errorMsg, Integer.valueOf(Ns.errorCode)), true);
                        }
                    } else if (340001 == Ns.errorCode) {
                        showNetRefreshViewNoClick(this.aUc.getRootView(), Ns.errorMsg, true);
                    } else {
                        showNetRefreshView(this.aUc.getRootView(), Ns.errorMsg, true);
                    }
                    this.aUc.fI(8);
                }
            } else if (Ns != null && Ns.cYp) {
                this.aUc.fI(0);
                showToast(getPageContext().getResources().getString(i.h.net_error_text, Ns.errorMsg, Integer.valueOf(Ns.errorCode)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.m mVar) {
        boolean z;
        if (!this.aUB && mVar != null) {
            try {
                this.aUe.d(mVar);
                if (this.aUe.afm() == 1) {
                    this.aUc.Ml().setFromCDN(true);
                } else {
                    this.aUc.Ml().setFromCDN(false);
                }
                this.aUv = this.aUe.getPage().rK();
                this.aUc.a(this.aUe.afg(), this.aUe.getUserData(), 0);
                if (this.aUe.awj() == null) {
                    z = false;
                } else {
                    z = this.aUe.awj().size() != 0;
                }
                this.aUs.a(this.aUe.avX().awo() == 1, this.aUe.getUserData().getIsMem(), this.aUe.afg().isLike(), z);
                this.aUc.Mb();
                this.aTU = this.aUe.afg().getName();
                this.forumId = this.aUe.afg().getId();
                this.aUc.setTitle(this.aTU);
                Ll();
                this.aUe.awx();
                this.aUe.awB();
                if (!Ly().Nr() && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.aUe.awA();
                    this.aUe.awz();
                }
                if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                    this.aUe.aO(getPageContext().getPageActivity());
                }
                com.baidu.tbadk.core.data.y top_notice_data = this.aUe.afg().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.getTitle() != null) {
                    com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                    wVar.setTitle(top_notice_data.getTitle());
                    wVar.bA(2);
                    wVar.cm(top_notice_data.sK());
                    wVar.parser_title();
                    this.aUe.f(wVar);
                }
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aUe.getThreadList();
                if (threadList != null) {
                    ArrayList<com.baidu.adp.widget.ListView.u> a2 = this.aUu.a(true, threadList);
                    if (a2 != null) {
                        this.aUe.af(a2);
                    }
                    this.aUc.a(threadList, this.mPn, this.aUe, this.aUe.getPage().rK());
                    Lr();
                    this.aUs.gg(this.mPn);
                    this.aUs.c(this.aUe);
                    this.aUc.Mf();
                }
                this.aTY = this.aUe.Ny();
                this.aUs.cl(this.aUe.avZ());
                hideLoadingView(this.aUc.getRootView());
                this.aUc.fI(0);
                this.aUc.Mj();
                this.aTP = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        aTL = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (intent != null) {
            this.aLR = intent.getLongExtra("TibaStatic.StartTime", -1L);
            if (intent.getData() != null) {
                Uri data = intent.getData();
                this.aTU = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.aTU)) {
                    intent.putExtra("name", this.aTU);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.aTU)) {
                this.aTU = M(intent);
                if (!StringUtils.isNull(this.aTU)) {
                    intent.putExtra("name", this.aTU);
                }
            }
        } else {
            this.aLR = System.currentTimeMillis();
        }
        if (this.aLR != -1) {
            this.aUi = this.aLR;
        } else {
            this.aUi = System.currentTimeMillis();
        }
        if (!cb(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.aUi;
            return;
        }
        super.onCreate(bundle);
        this.aUq = new com.baidu.tieba.frs.mc.a(this);
        this.aUq.a(this.aUx);
        this.aUq.init();
        if (getIntent() != null) {
            this.aUq.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.aUq.f(bundle);
        } else {
            this.aUq.f(null);
        }
        Ly().oS();
        setContentView(i.g.frs_activity);
        this.aUr = new com.baidu.tieba.frs.b.o(this);
        this.aUt = new com.baidu.tieba.frs.b.l(this);
        this.aUs = new com.baidu.tieba.frs.b.a(this, this.aUr);
        this.aUr.oR();
        if (getIntent() != null) {
            this.aUs.h(getIntent().getExtras());
        } else if (bundle != null) {
            this.aUs.h(bundle);
        } else {
            this.aUs.h((Bundle) null);
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        this.aSR.setUniqueId(getUniqueId());
        this.aSR.registerListener();
        addGlobalLayoutListener();
        Lc();
        registerListener(this.Tt);
        registerListener(this.mMemListener);
        registerListener(this.aUz);
        registerListener(this.aSN);
        registerListener(this.aGt);
        registerListener(this.aRu);
        registerListener(this.aUA);
        this.aUD.getSocketMessageListener().setSelfListener(true);
        this.aUD.getHttpMessageListener().setSelfListener(true);
        this.aUD.setTag(getUniqueId());
        registerListener(this.aUD);
        this.aUu = new com.baidu.tieba.frs.loadmore.a(this);
        this.aUu.registerListener();
        this.aTZ = new com.baidu.tieba.tbadkCore.data.e("frs");
        this.createTime = System.currentTimeMillis() - this.aLR;
        if (this.aUc != null) {
            showLoadingView(this.aUc.getRootView(), true);
            this.aUc.Mk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
        } else if (this.aUe != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null && this.aUc != null) {
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
            this.aUq.a(mVar);
            ArrayList<com.baidu.adp.widget.ListView.u> a2 = this.aUu.a(true, this.aUe.getThreadList());
            if (a2 != null) {
                this.aUe.af(a2);
                this.aUc.a(a2, this.mPn, this.aUe, this.aUv);
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

    private void Lc() {
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
        Le();
        if (bundle != null) {
            this.aTU = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aTV = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.aTU = intent.getStringExtra("name");
                this.mFrom = intent.getStringExtra("from");
                this.aTV = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            setSwipeBackEnabled(false);
        }
        this.aUf = new dg(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            Ld();
            Lf();
        }
        this.aUs.h(bundle);
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

    public void Ld() {
        if (this.aUf != null && this.aUc != null) {
            if (FrsActivityStatic.aVi || FrsActivityStatic.aVj || FrsActivityStatic.aVk) {
                this.aUf.an(com.baidu.tbadk.coreExtra.messageCenter.a.wM().getMsgReplyme());
                this.aUf.am(com.baidu.tbadk.coreExtra.messageCenter.a.wM().getMsgAtme());
                int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.wM().getMsgChat();
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().xA() && !TbadkCoreApplication.m411getInst().isMIUIRom()) {
                    msgChat -= com.baidu.tbadk.coreExtra.messageCenter.a.wM().wT();
                }
                this.aUf.ao(msgChat);
                this.aUc.a(this.aUf);
                this.aUt.a(this.aUf);
            }
        }
    }

    private void Le() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.aUK);
    }

    private void Lf() {
        registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.aUK);
    }

    private boolean cb(boolean z) {
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
        if (this.aUc != null) {
            this.aUc.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.aUn != null) {
                this.aUn.onDestroy();
            }
            this.aUc.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.aUq.onActivityDestroy();
        this.aUr.onActivityDestroy();
        this.aUs.onActivityDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
        if (this.aUo != null) {
            this.aUo.cancel(true);
            this.aUo = null;
        }
        if (this.aUq != null) {
            this.aUq.KG();
        }
        if (this.aUt != null) {
            this.aUt.destroy();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aTU);
        bundle.putString("from", this.mFrom);
        this.aUq.onSaveInstanceState(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.w ly;
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    fy(0);
                    return;
                case 11002:
                    this.aUs.oO();
                    return;
                case 11011:
                    b(this.aUd);
                    return;
                case 11012:
                    c(this.aUg);
                    return;
                case 11014:
                    this.aUs.NY();
                    return;
                case 11016:
                    this.aUc.Me();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    this.aUs.Lx();
                    return;
                case 13003:
                    if (intent != null && !Ly().Nr()) {
                        try {
                            postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                        } catch (Exception e) {
                            postWriteCallBackData = null;
                        }
                        int Nt = this.aUq.Nt();
                        if (dn.MH().fN(1) == null) {
                            Nt = 0;
                        }
                        if (Nt == 0 && postWriteCallBackData != null) {
                            long c = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
                            long c2 = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
                            long c3 = com.baidu.adp.lib.g.b.c(this.forumId, 0L);
                            if (c != 0 && c2 != 0 && c3 != 0) {
                                com.baidu.adp.lib.g.h.hh().postDelayed(new y(this, c2, c, c3), 1000L);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 18003:
                    this.aUc.Ml().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (ly = this.aUe.ly(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            ly.bB(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            ly.parser_title();
                            refresh();
                            return;
                        } else if (intExtra == 0) {
                            this.aUe.g(ly);
                            this.aUc.Mf();
                            if (com.baidu.tieba.tbadkCore.d.avW() != null) {
                                com.baidu.tieba.tbadkCore.d.avW().H(this.aTU, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    Lo();
                    return;
                case 23003:
                    if (intent != null && this.aUe != null) {
                        a(LA(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    N(intent);
                    return;
                case 23013:
                    Lp();
                    return;
                case 23019:
                    Lq();
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
        this.aUt.Of();
        this.aUs.a(this.aUy);
        this.aSH = true;
        this.aUp = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.aUc.nx();
        } else if (aTR) {
            aTR = false;
            this.aUc.nx();
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
            this.aUc.Mo();
            this.aUt.Og().setSlidingEnabled(true);
            refresh();
            return;
        }
        this.aUc.Mn();
        this.aUt.Og().setSlidingEnabled(false);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.aTU = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.aTX = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aTX) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    Lg();
                } else {
                    Lh();
                }
            }
        }
    }

    private void Lg() {
        this.aUc.nx();
        this.aUt.Og().showContent(false);
    }

    private void Lh() {
        this.aUc.nx();
        this.aUt.Og().showContent(false);
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
        this.aUc.Ml().h(this.aUH);
        this.aUc.Ml().i(this.aUI);
        if (this.aTV == 0) {
            this.aUc.setTitle(this.aTU);
        } else {
            this.aUc.setTitle("");
            this.aTV = 1;
        }
        this.aUt.Og();
        this.aUs.t(this.aUc.getListView());
        this.aUc.a(this.aUL);
        this.aUc.a(this.aUO);
        this.aUc.j(this.aUM);
        this.aUc.l(this.aUN);
        this.aUc.setOnScrollListener(this.aSP);
        this.aUc.a(this.HF);
        this.aUc.a(this.aUE);
        this.aUc.g(this.aSi);
        this.aUt.Og().setOnOpenedListener(this.aUP);
        this.aUc.Ml().a(this.aUG);
        if (!this.mIsLogin) {
            this.aUc.Mn();
            this.aUt.Og().setSlidingEnabled(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.aUc.onChangeSkinType(i);
        this.aUt.a(getPageContext(), i);
        this.aUs.a(getPageContext(), i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> KP() {
        if (this.aUh == null) {
            this.aUh = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.aUh;
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
                FrsActivity.this.gO(this.name);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gO(String str) {
        Intent K;
        if (str != null && (K = com.baidu.tieba.frs.utils.a.K(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(i.h.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", K);
            BarImageView NX = this.aUs.NX();
            if (NX != null && NX.getBdImage() != null && NX.getBdImage().nb() != null) {
                Bitmap nb = NX.getBdImage().nb();
                Float valueOf = Float.valueOf(getResources().getDisplayMetrics().density);
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.d.iv().a(com.baidu.adp.lib.util.d.iv().d(nb, valueOf.intValue() * 48), valueOf.intValue() * 6));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), i.e.icon));
            }
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fy(int i) {
        if (!this.mIsLogin) {
            if (this.aUe != null && this.aUe.rE() != null) {
                this.aUe.rE().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.aUe != null) {
            if (i == 0) {
                if (!this.aTS) {
                    fz(0);
                    return;
                }
                TiebaStatic.log("c10152");
                fz(4);
                return;
            }
            this.aUc.Me();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fz(int i) {
        int i2 = 0;
        if (this.aUe.getUserData() != null) {
            i2 = this.aUe.getUserData().getIsMem();
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), i, this.aUe.afg().getId(), this.aTU, null, null, 0, this.aUe.rE(), 13003, false, false, null, false, false, null, null, this.aUe.afg().getPrefixData(), i2);
        if (dn.MH().fN(1) != null) {
            writeActivityConfig.setCategroyId(this.aUq.Nt());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.w wVar) {
        boolean sE = wVar == null ? true : wVar.sE();
        this.aUc.c(new z(this, wVar));
        this.aUc.a(wVar, sE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Li() {
        this.aUc.b(new aa(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lj() {
        this.aUc.a(new ab(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lk() {
        AntiData rE = this.aUe.rE();
        if (rE != null) {
            if (AntiHelper.e(rE) || AntiHelper.f(rE) || AntiHelper.g(rE)) {
                rE.setBlock_forum_name(this.aTU);
                rE.setBlock_forum_id(this.aUe.afg().getId());
                rE.setUser_name(this.aUe.getUserData().getUserName());
                rE.setUser_id(this.aUe.getUserData().getUserId());
                if (AntiHelper.a(getPageContext().getPageActivity(), rE, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                    return;
                }
            }
            if (!TextUtils.isEmpty(rE.getPollMessage())) {
                com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), rE.getPollMessage());
                return;
            }
        }
        PostPrefixData postPrefixData = null;
        if (this.aUe.afg() != null) {
            postPrefixData = this.aUe.afg().getPrefixData();
        }
        int i = 0;
        if (this.aUe.getUserData() != null) {
            i = this.aUe.getUserData().getIsMem();
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVoteActivityConfig(getPageContext().getPageActivity(), this.aUe.afg().getId(), this.aTU, rE, 13003, postPrefixData, i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.w wVar) {
        boolean sE = wVar == null ? true : wVar.sE();
        if (this.mThreadId != null) {
            if (!sE) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aTU, null, 18003, true, true, this.aUa)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aTU, null, 18003, false, false, this.aUa)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.w wVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aTU, null, 18003, false, false, this.aUa)));
        }
    }

    public void refresh() {
        this.aUB = false;
        this.aTP = false;
        this.aUb = false;
        stopVoice();
        if (this.aUr != null && this.aUr.Oh() != null) {
            this.aUr.Oh().a(this.aUq.Nv(), this.aUq.Nw(), this.aUq.Nx());
        }
        Ly().bD(true);
    }

    private void Ll() {
        switch (this.aTV) {
            case 1:
                com.baidu.adp.lib.g.k.hi().c(new ac(this));
                break;
        }
        this.aTV = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lm() {
        stopVoice();
        try {
            if (this.aUe != null) {
                this.aUc.Mb();
                this.aTU = this.aUe.afg().getName();
                this.forumId = this.aUe.afg().getId();
                this.aUc.setTitle(this.aTU);
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.aUe.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.aUe.getUserData().getBimg_end_time());
                Ll();
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aUe.getThreadList();
                if (threadList != null) {
                    this.aUc.a(threadList, this.mPn, this.aUe, this.aUe.getPage().rK());
                    Lr();
                    this.aUs.gg(this.mPn);
                    this.aUs.c(this.aUe);
                    this.aUc.Mf();
                    if (this.aUe.afm() == 1) {
                        this.aUc.Ml().setFromCDN(true);
                    } else {
                        this.aUc.Ml().setFromCDN(false);
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
        this.aSH = false;
        this.aUp = false;
        this.aUc.onPause();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Object c;
        super.onStop();
        if (this.aUe != null && this.aUe.afg() != null) {
            com.baidu.tbadk.distribute.a.Ai().a(getPageContext().getPageActivity(), "frs", this.aUe.afg().getId(), 0L);
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
        if (i != 82 || this.aTW) {
            if (i == 4) {
                if (this.aUt.onBackPressed()) {
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
            if (bVar.rp()) {
                com.baidu.tbadk.core.util.az.uX().b(getPageContext(), new String[]{bVar.TZ});
            } else if (bVar.ro()) {
                if (com.baidu.adp.lib.util.i.iN() && !com.baidu.adp.lib.util.i.iO()) {
                    trim = getPageContext().getString(i.h.frs_network_tips);
                } else if (TextUtils.isEmpty(bVar.Uk.Uq.trim())) {
                    trim = getPageContext().getString(i.h.confirm_download_app);
                } else {
                    trim = bVar.Uk.Uq.trim();
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
            if (!bVar.rn()) {
                com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), i.h.pb_app_error);
            } else if (com.baidu.adp.lib.util.i.iN()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", bVar.Ub);
                com.baidu.tbadk.download.b.Ap().a(bVar.Ub, bVar.Ua, bVar.TX, i, com.baidu.adp.lib.g.b.g(bVar.TW, 0));
            } else {
                showToast(i.h.neterror);
            }
        }
    }

    public void Ln() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
        this.aUo = new a(this.aTU);
        this.aUo.setSelfExecute(true);
        this.aUo.execute(new String[0]);
    }

    public void Lo() {
        com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.aUe.afg().getId(), true, true, true);
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Ai().a(getPageContext().getPageActivity(), bVar, str, "frs", this.aUe.afg().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Ai().a(bVar, this.forumId, 0L, "FRS", str, this.mPn);
    }

    public void Lp() {
        if (!fA(23013)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10177").ae(ImageViewerConfig.FORUM_ID, this.forumId));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(getPageContext().getPageActivity(), String.valueOf(getForumId()), false, 0)));
        }
    }

    public void Lq() {
        if (!fA(23019) && this.aTT != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(getPageContext().getPageActivity()).createConfig(String.valueOf(getForumId()), this.aTT.getTid(), 1)));
        }
    }

    private boolean fA(int i) {
        if (TbadkCoreApplication.isLogin()) {
            return false;
        }
        TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getResources().getString(i.h.login_to_use), true, i)));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(int i) {
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aUe.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.w) {
                    com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) next;
                    if (wVar == this.aTO) {
                        b(wVar, i);
                        this.aTO = null;
                        break;
                    } else if (wVar.getId() != null && wVar.getId().equals(this.aSI)) {
                        b(wVar, i);
                        this.aSI = null;
                        break;
                    }
                }
            }
            this.aUc.Ml().a(threadList, this.aUe);
            this.aUc.Ml().notifyDataSetChanged();
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

    public void a(eh.a aVar, String str) {
        if (str != null) {
            Ly().au(aVar.aZM, str);
            this.aUt.Oe();
            this.aTU = str;
            if (this.aUc != null) {
                this.aUc.setTitle(this.aTU);
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
        if (this.aUc == null) {
            return null;
        }
        return this.aUc.getListView();
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
    public int vE() {
        if (this.aUc == null) {
            return 0;
        }
        return this.aUc.Mi();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> vF() {
        if (this.aeN == null) {
            this.aeN = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.aeN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.aUf != null) {
                this.aUf.an(msgReplyme);
                this.aUf.am(msgAtme);
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xj().xA() && !TbadkCoreApplication.m411getInst().isMIUIRom()) {
                    this.aUf.ao((msgChat - newsNotifyMessage.getMsgPrivateChat()) - newsNotifyMessage.getMsgStrangerChat());
                } else {
                    this.aUf.ao(msgChat);
                }
                this.aUc.a(this.aUf);
                this.aUt.a(this.aUf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        bb Ml;
        HashMap<Integer, com.baidu.tbadk.core.data.w> LG;
        if (this.aUe != null && this.aUc != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (Ml = this.aUc.Ml()) != null && (LG = Ml.LG()) != null && LG.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.w> entry : LG.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.w value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.b) && TextUtils.equals(((com.baidu.tbadk.core.data.b) value).Ub, downloadData.getId())) {
                            int aww = this.aUe.aww();
                            if (Ml.aA(intValue + aww) instanceof com.baidu.tbadk.core.data.b) {
                                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) Ml.aA(aww + intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    bVar.TV = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!com.baidu.tbadk.core.util.as.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    bVar.TV = 0;
                                } else if (status == 1) {
                                    bVar.TV = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.aUc.Mc();
        }
    }

    private void Lr() {
        HashMap<Integer, com.baidu.tbadk.core.data.w> LG;
        if (this.aUc != null && this.aUc.Ml() != null && (LG = this.aUc.Ml().LG()) != null) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.w> entry : LG.entrySet()) {
                com.baidu.tbadk.core.data.w value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.b)) {
                    arrayList.add((com.baidu.tbadk.core.data.b) value);
                }
            }
            com.baidu.tbadk.download.b.Ap().o(arrayList);
        }
    }

    public void Ls() {
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
            com.baidu.tieba.recapp.report.b.aqi().a(com.baidu.tieba.recapp.report.e.a(bVar, "click", this.mPn));
            int i2 = bVar.TV;
            if (i2 == 0) {
                a(bVar, i);
            } else if (i2 == 2) {
                com.baidu.tieba.frs.utils.a.H(getPageContext().getPageActivity(), bVar.Ub);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", bVar.Ub);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.b bVar) {
        if (bVar != null) {
            a(bVar, "btn_click");
            b(bVar, "click");
            com.baidu.tieba.recapp.report.b.aqi().a(com.baidu.tieba.recapp.report.e.a(bVar, "click", this.mPn));
            com.baidu.tbadk.core.util.az.uX().b(getPageContext(), new String[]{bVar.TZ});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.aUc.getRootView());
        showLoadingView(this.aUc.getRootView(), true);
        this.aUc.Mk();
        this.aUc.nx();
    }

    public com.baidu.tieba.tbadkCore.o Lt() {
        return this.aUe;
    }

    public boolean Lu() {
        return this.aUc.Lu();
    }

    public void Lv() {
        FrsActivityStatic.aVi = false;
        FrsActivityStatic.aVk = false;
        Ld();
    }

    public void Lw() {
        FrsActivityStatic.aVi = false;
        FrsActivityStatic.aVj = false;
        Ld();
    }

    public void Lx() {
        this.aUs.Lx();
    }

    public com.baidu.tieba.frs.mc.a Ly() {
        return this.aUq;
    }

    public void a(bs bsVar) {
        this.aUc = bsVar;
    }

    public void gP(String str) {
        this.aTU = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFlag(int i) {
        this.aTV = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    public void resetData() {
        this.aTP = false;
        this.aUb = false;
        this.aUe = null;
        this.aUc.setTitle(this.aTU);
        this.aUt.cn(false);
        this.aUt.setIsManager(false);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.je()) {
            this.aUc.Ms();
        } else if (this.aUq.Nv() == 1) {
            Lz();
            loadMore();
        } else if (this.aUq.hasMore()) {
            loadMore();
        }
    }

    public void gQ(String str) {
        Lz();
        showToast(str);
    }

    public void B(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.u> a2;
        Lz();
        if (arrayList != null && arrayList.size() != 0 && (a2 = this.aUu.a(false, arrayList)) != null) {
            this.aUe.af(a2);
            this.aUc.a(a2, this.mPn, this.aUe, 0);
        }
    }

    private void Lz() {
        if (this.aUv == 0 && !this.aUu.ac(this.aUe.awc())) {
            if (this.aUe.getThreadList() == null || this.aUe.getThreadList().size() == 0) {
                this.aUc.Ms();
                return;
            } else {
                this.aUc.Mr();
                return;
            }
        }
        this.aUc.Mq();
    }

    public void loadMore() {
        if (this.aUq.Nv() == 1) {
            if (!this.aUu.auq && !this.aUq.isLoading()) {
                if (this.aUu.ac(this.aUe.awc())) {
                    this.aUc.a(this.aUu.MZ(), this.mPn, this.aUe, 0);
                    this.aUu.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.aUe.awc());
                } else if (this.aUv != 0) {
                    this.aUc.a(this.aUu.MZ(), this.mPn, this.aUe, 0);
                    this.mPn++;
                    this.aUq.fT(this.mPn);
                    this.aUu.bai = false;
                    this.aUu.baj = 0;
                }
            }
        } else if (!this.aUq.Nz()) {
            if (this.aUr.Oh() != null) {
                this.aUr.Oh().a(this.aUq.Nv(), this.aUq.Nw(), this.aUq.Nx());
            }
            this.aUq.Hg();
        }
    }

    public void showShareDialog() {
        String name;
        if (this.aUe != null && this.aUe.afg() != null) {
            if (this.aUe.afg().getName() == null) {
                showToast(getPageContext().getString(i.h.no_forum_data));
                return;
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String str = "http://tieba.baidu.com/f?kw=" + this.aUe.afg().getName();
            Uri parse = this.aUe.afg().getImage_url() == null ? null : Uri.parse(this.aUe.afg().getImage_url());
            String slogan = this.aUe.afg().getSlogan();
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = String.valueOf(name) + getPageContext().getString(i.h.forum);
            fVar.content = slogan;
            fVar.linkUrl = str;
            fVar.aiT = true;
            fVar.extData = getForumId();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true, qt());
            shareDialogConfig.addOutsideTextView(i.h.share_tieba_qunzu, i.e.icon_unite_share_qunzu, new af(this));
            shareDialogConfig.addOutsideTextView(i.h.forum_friend, i.e.icon_unite_share_baf, new ag(this));
            shareDialogConfig.setCopyLinkListener(new ah(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private SparseArray<String> qt() {
        if (this.aUw == null) {
            this.aUw = new SparseArray<>(7);
            this.aUw.put(2, "frs_wx_timeline");
            this.aUw.put(3, "frs_wx_friend");
            this.aUw.put(4, "frs_qq_zone");
            this.aUw.put(5, "frs_tencent_weibo");
            this.aUw.put(6, "frs_sina_weibo");
        }
        return this.aUw;
    }

    private ShareFromFrsMsgData LA() {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(this.aUe.afg().getImage_url());
        shareFromFrsMsgData.setName(this.aUe.afg().getName());
        shareFromFrsMsgData.setMemberNum(this.aUe.afg().getMember_num());
        shareFromFrsMsgData.setPostNum(this.aUe.afg().getPost_num());
        shareFromFrsMsgData.setContent(this.aUe.afg().getSlogan());
        return shareFromFrsMsgData;
    }

    private void N(Intent intent) {
        a(LA(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromFrsMsgData shareFromFrsMsgData, long j, String str, String str2) {
        if (this.aUe != null && this.aUe.afg() != null) {
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
        if (this.aUe != null && this.aUe.afg() != null) {
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
