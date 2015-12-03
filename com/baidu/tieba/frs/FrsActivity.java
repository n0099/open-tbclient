package com.baidu.tieba.frs;

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
import android.widget.TextView;
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
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
import com.baidu.tbadk.core.view.AppDownloadView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.ez;
import com.baidu.tieba.n;
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
    public static String aYZ = "speed_icon_show";
    private static final int aZa = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds90);
    private static final int aZb = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds300);
    public static boolean aZf = false;
    public static volatile long aZw = 0;
    public static volatile long aZx = 0;
    public static volatile int aZy = 0;
    private static boolean isNeedRefreshOnResume = false;
    private boolean aXV;
    private String aXW;
    private a aZB;
    private com.baidu.tieba.frs.mc.a aZD;
    private com.baidu.tieba.frs.b.o aZE;
    private com.baidu.tieba.frs.b.a aZF;
    private com.baidu.tieba.frs.b.l aZG;
    private com.baidu.tieba.frs.loadmore.a aZH;
    private com.baidu.tbadk.core.data.z aZc;
    private boolean aZg;
    private com.baidu.tbadk.core.data.z aZh;
    private com.baidu.tieba.tbadkCore.data.e aZn;
    private dw aZt;
    private com.baidu.adp.lib.f.b<TbImageView> aZv;
    private com.baidu.adp.lib.f.b<TbImageView> afK;
    VoiceManager mVoiceManager;
    private boolean aZd = false;
    public boolean aZe = false;
    public String aZi = null;
    public String mFrom = null;
    public int aZj = 0;
    private int mPn = 1;
    private boolean aZk = false;
    private boolean aZl = false;
    private String mThreadId = null;
    private String forumId = null;
    private int aZm = 0;
    private boolean aZo = false;
    private boolean aZp = false;
    private cd aZq = null;
    private final com.baidu.tbadk.core.data.z aZr = null;
    private com.baidu.tieba.tbadkCore.p aZs = new com.baidu.tieba.tbadkCore.p();
    private com.baidu.tbadk.core.data.z aZu = null;
    private boolean JB = false;
    public long aQy = -1;
    public long ays = 0;
    public long createTime = 0;
    public long Vp = -1;
    private boolean aZz = false;
    public com.baidu.tbadk.performanceLog.e aZA = null;
    private boolean aZC = true;
    private int aZI = -1;
    private SparseArray<String> aZJ = null;
    private eu aZK = new com.baidu.tieba.frs.a(this);
    private et aZL = new l(this);
    private CustomMessageListener aYb = new w(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener aWI = new ah(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
    private CustomMessageListener aJs = new al(this, CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND);
    public final CustomMessageListener aZM = new am(this, CmdConfigCustom.MSG_NEW);
    private CustomMessageListener aZN = new an(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    private boolean aZO = false;
    public final com.baidu.tieba.tbadkCore.s aZP = new ao(this);
    private final CustomMessageListener TI = new ap(this, CmdConfigCustom.CMD_REFRESH);
    private final CustomMessageListener mMemListener = new com.baidu.tieba.frs.b(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private CustomMessageListener aZQ = new com.baidu.tieba.frs.c(this, CmdConfigCustom.CMD_FRS_VIDEO_GUIDE_WRITE_SUCCESS);
    private final com.baidu.adp.framework.listener.a aZR = new d(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    private final q.a aZS = new e(this);
    private final BdListView.g HW = new f(this);
    public final View.OnClickListener aZT = new g(this);
    private final AbsListView.OnScrollListener aYd = new h(this);
    private final bc aZU = new i(this);
    private final com.baidu.tieba.tbadkCore.af aYf = new com.baidu.tieba.tbadkCore.af(getPageContext(), new j(this));
    private final View.OnClickListener aZV = new k(this);
    private final View.OnClickListener aZW = new b();
    public final AdapterView.OnItemClickListener aZX = new m(this);
    private final NoNetworkView.a aXw = new n(this);
    private final CustomMessageListener aZY = new o(this, 0);
    private com.baidu.adp.widget.ListView.v aZZ = new c();
    private View.OnClickListener baa = new p(this);
    private View.OnClickListener bab = new q(this);
    private com.baidu.adp.widget.ListView.w bac = new r(this);
    private final SlidingMenu.OnOpenedListener bad = new s(this);
    public final com.baidu.adp.base.g bae = new t(this);
    public final com.baidu.adp.base.g baf = new u(this);

    public String getForumId() {
        return this.forumId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.y yVar) {
        if (yVar != null) {
            boolean z = yVar.isLike() == 1;
            if (this.aZq != null && this.aZs != null && this.aZs.ajy() != null && yVar.getFid() != null) {
                if (yVar.getFid().equals(this.aZs.ajy().getId())) {
                    this.aZs.ajy().setLike(yVar.isLike());
                    if (!StringUtils.isNULL(yVar.getLevelName())) {
                        this.aZs.ajy().setLevelName(yVar.getLevelName());
                    }
                    if (yVar.RI() >= 0) {
                        this.aZs.ajy().setUser_level(yVar.RI());
                    }
                    if (z) {
                        this.aZF.a(this.aZs, false);
                        this.aZG.cA(true);
                        TbadkCoreApplication.m411getInst().addLikeForum(this.aZi);
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.aBA().J(this.aZi, false);
                    this.aZs.ajy().setLike(0);
                    this.aZF.Pt();
                    this.aZG.cA(false);
                    TbadkCoreApplication.m411getInst().delLikeForum(this.aZi);
                    return;
                }
                if (yVar.isLike() == 1) {
                    this.aZs.mm(yVar.getFid());
                    this.aZF.d(this.aZs);
                }
                if (this.aZs.ajy().getBannerListData() != null) {
                    this.aZs.ajy().getBannerListData().setFeedForumLiked(yVar.getFid(), yVar.isLike());
                }
                this.aZq.ND();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    public void a(ErrorData errorData) {
        this.aZq.cr(false);
        this.aZq.cs(false);
        this.aZq.ct(false);
        this.aZq.ND();
        hideLoadingView(this.aZq.getRootView());
        this.aZq.NK();
        if (!this.aZp) {
            e.a OY = MX().OY();
            if (!this.aZd) {
                if (OY != null) {
                    if (this.aZD.OZ() != 0) {
                        this.aZD.Pg();
                        this.aZq.ND();
                    } else if (OY.dwT) {
                        if (340001 == OY.errorCode) {
                            showNetRefreshViewNoClick(this.aZq.getRootView(), getPageContext().getResources().getString(n.i.net_error_text, OY.errorMsg, Integer.valueOf(OY.errorCode)), true);
                        } else {
                            showNetRefreshView(this.aZq.getRootView(), getPageContext().getResources().getString(n.i.net_error_text, OY.errorMsg, Integer.valueOf(OY.errorCode)), true);
                        }
                    } else if (340001 == OY.errorCode) {
                        showNetRefreshViewNoClick(this.aZq.getRootView(), OY.errorMsg, true);
                    } else {
                        showNetRefreshView(this.aZq.getRootView(), OY.errorMsg, true);
                    }
                    this.aZq.gf(8);
                }
            } else if (OY != null && OY.dwT) {
                this.aZq.gf(0);
                showToast(getPageContext().getResources().getString(n.i.net_error_text, OY.errorMsg, Integer.valueOf(OY.errorCode)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.n nVar) {
        boolean z;
        if (!this.aZO && nVar != null) {
            try {
                this.aZs.d(nVar);
                if (this.aZs.ajE() == 1) {
                    this.aZq.NM().setFromCDN(true);
                } else {
                    this.aZq.NM().setFromCDN(false);
                }
                this.aZI = this.aZs.getPage().sf();
                this.aZq.a(this.aZs.ajy(), this.aZs.getUserData(), 0);
                if (this.aZs.aBO() == null) {
                    z = false;
                } else {
                    z = this.aZs.aBO().size() != 0;
                }
                this.aZF.a(this.aZs.aBC().aBW() == 1, this.aZs.getUserData().getIsMem(), this.aZs.ajy().isLike(), z);
                this.aZq.NC();
                this.aZi = this.aZs.ajy().getName();
                this.forumId = this.aZs.ajy().getId();
                this.aZq.setTitle(this.aZi);
                ML();
                this.aZs.aCf();
                this.aZs.aCk();
                if (!MX().OX() && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.aZs.aCj();
                    this.aZs.aCi();
                    this.aZs.aCh();
                }
                this.aZs.aCm();
                if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                    this.aZs.aN(getPageContext().getPageActivity());
                }
                com.baidu.tbadk.core.data.ab top_notice_data = this.aZs.ajy().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.getTitle() != null) {
                    com.baidu.tbadk.core.data.z zVar = new com.baidu.tbadk.core.data.z();
                    zVar.setTitle(top_notice_data.getTitle());
                    zVar.bJ(2);
                    zVar.cu(top_notice_data.to());
                    zVar.parser_title();
                    this.aZs.f(zVar);
                }
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aZs.getThreadList();
                if (threadList != null) {
                    ArrayList<com.baidu.adp.widget.ListView.u> a2 = this.aZH.a(true, threadList);
                    if (a2 != null) {
                        this.aZs.am(a2);
                    }
                    this.aZq.a(threadList, this.mPn, this.aZs, this.aZs.getPage().sf());
                    MR();
                    this.aZF.gC(this.mPn);
                    this.aZF.d(this.aZs);
                    this.aZq.NG();
                }
                this.aZm = this.aZs.Pe();
                if (this.aZn != null) {
                    this.aZn.mt(this.aZm);
                }
                this.aZF.cy(this.aZs.aBE());
                hideLoadingView(this.aZq.getRootView());
                this.aZq.gf(0);
                this.aZq.NK();
                this.aZd = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        aYZ = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (intent != null) {
            this.aQy = intent.getLongExtra("TibaStatic.StartTime", -1L);
            if (intent.getData() != null) {
                Uri data = intent.getData();
                this.aZi = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.aZi)) {
                    intent.putExtra("name", this.aZi);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.aZi)) {
                this.aZi = M(intent);
                if (!StringUtils.isNull(this.aZi)) {
                    intent.putExtra("name", this.aZi);
                }
            }
        } else {
            this.aQy = System.currentTimeMillis();
        }
        if (this.aQy != -1) {
            this.Vp = this.aQy;
        } else {
            this.Vp = System.currentTimeMillis();
        }
        if (!co(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.Vp;
            return;
        }
        super.onCreate(bundle);
        this.aZD = new com.baidu.tieba.frs.mc.a(this);
        this.aZD.a(this.aZK);
        this.aZD.init();
        if (getIntent() != null) {
            this.aZD.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.aZD.f(bundle);
        } else {
            this.aZD.f(null);
        }
        MX().oY();
        setContentView(n.g.frs_activity);
        this.aZE = new com.baidu.tieba.frs.b.o(this);
        this.aZG = new com.baidu.tieba.frs.b.l(this);
        this.aZF = new com.baidu.tieba.frs.b.a(this, this.aZE);
        this.aZE.oX();
        if (getIntent() != null) {
            this.aZF.h(getIntent().getExtras());
        } else if (bundle != null) {
            this.aZF.h(bundle);
        } else {
            this.aZF.h((Bundle) null);
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        this.aYf.setUniqueId(getUniqueId());
        this.aYf.registerListener();
        addGlobalLayoutListener();
        MC();
        registerListener(this.TI);
        registerListener(this.mMemListener);
        registerListener(this.aZM);
        registerListener(this.aYb);
        registerListener(this.aJs);
        registerListener(this.aWI);
        registerListener(this.aZN);
        registerListener(this.aZQ);
        this.aZR.getSocketMessageListener().setSelfListener(true);
        this.aZR.getHttpMessageListener().setSelfListener(true);
        this.aZR.setTag(getUniqueId());
        registerListener(this.aZR);
        this.aZH = new com.baidu.tieba.frs.loadmore.a(this);
        this.aZH.registerListener();
        this.aZn = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.dzh);
        this.createTime = System.currentTimeMillis() - this.aQy;
        if (this.aZq != null) {
            showLoadingView(this.aZq.getRootView(), true);
            this.aZq.NL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
        } else if (this.aZs != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null && this.aZq != null) {
            com.baidu.tbadk.core.data.o oVar = new com.baidu.tbadk.core.data.o();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(getMyPostResIdl.data.thread_info.author);
            a(metaData, getMyPostResIdl.data.user_info);
            String userId = metaData.getUserId();
            if (userId != null && !userId.equals("0")) {
                hashMap.put(metaData.getUserId(), metaData);
            }
            oVar.setUserMap(hashMap);
            oVar.a(getMyPostResIdl.data.thread_info);
            this.aZD.a(oVar);
            ArrayList<com.baidu.adp.widget.ListView.u> a2 = this.aZH.a(true, this.aZs.getThreadList());
            if (a2 != null) {
                this.aZs.am(a2);
                this.aZq.a(a2, this.mPn, this.aZs, this.aZI);
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
            metaData.setGodInfo(user_Info.god_data);
        }
    }

    private void MC() {
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
        ME();
        if (bundle != null) {
            this.aZi = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aZj = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.aZi = intent.getStringExtra("name");
                this.mFrom = intent.getStringExtra("from");
                this.aZj = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            setSwipeBackEnabled(false);
        }
        this.aZt = new dw(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            MD();
            MF();
        }
        this.aZF.h(bundle);
    }

    private String M(Intent intent) {
        int indexOf;
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (!StringUtils.isNull(dataString) && dataString.startsWith("tbfrs://")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10320").r("obj_locate", 2).r("obj_type", 1));
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (StringUtils.isNull(decode) || (indexOf = decode.indexOf("kw=")) < 0 || (length = indexOf + "kw=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public void MD() {
        if (this.aZt != null && this.aZq != null) {
            if (FrsActivityStatic.bay || FrsActivityStatic.baz) {
                this.aZt.av(com.baidu.tbadk.coreExtra.messageCenter.a.xJ().getMsgReplyme());
                this.aZt.au(com.baidu.tbadk.coreExtra.messageCenter.a.xJ().getMsgAtme());
                this.aZt.ax(com.baidu.tbadk.coreExtra.messageCenter.a.xJ().xQ());
                this.aZt.aw(com.baidu.tbadk.coreExtra.messageCenter.a.xJ().getMsgChat());
                this.aZq.a(this.aZt);
                this.aZG.a(this.aZt);
            }
        }
    }

    private void ME() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.aZY);
    }

    private void MF() {
        registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.aZY);
    }

    private boolean co(boolean z) {
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
        if (this.aZs != null && this.aZs.ajy() != null) {
            em.Og().ay(com.baidu.adp.lib.h.b.c(this.aZs.ajy().getId(), 0L));
        }
        if (this.aZq != null) {
            this.aZq.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.aZA != null) {
                this.aZA.onDestroy();
            }
            this.aZq.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.aZD.onActivityDestroy();
        this.aZE.onActivityDestroy();
        this.aZF.onActivityDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
        if (this.aZB != null) {
            this.aZB.cancel(true);
            this.aZB = null;
        }
        if (this.aZD != null) {
            this.aZD.Mf();
        }
        if (this.aZG != null) {
            this.aZG.destroy();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aZi);
        bundle.putString("from", this.mFrom);
        this.aZD.onSaveInstanceState(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.z mo;
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    fV(0);
                    return;
                case 11002:
                    this.aZF.oU();
                    return;
                case 11011:
                    b(this.aZr);
                    return;
                case 11012:
                    c(this.aZu);
                    return;
                case 11014:
                    this.aZF.PE();
                    return;
                case 11016:
                    this.aZq.NF();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    this.aZF.MW();
                    return;
                case 13003:
                    if (intent != null && !MX().OX()) {
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
                    this.aZq.NM().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (mo = this.aZs.mo(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            mo.bK(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            mo.parser_title();
                            bW(6);
                            return;
                        } else if (intExtra == 0) {
                            this.aZs.g(mo);
                            this.aZq.NG();
                            if (com.baidu.tieba.tbadkCore.d.aBA() != null) {
                                com.baidu.tieba.tbadkCore.d.aBA().J(this.aZi, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    MO();
                    return;
                case 23003:
                    if (intent != null && this.aZs != null) {
                        a(MZ(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    N(intent);
                    return;
                case 23013:
                    MP();
                    return;
                case 23019:
                    MQ();
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
        int OZ = this.aZD.OZ();
        if (ed.Oe().gj(1) == null) {
            OZ = 0;
        }
        if (OZ == 0 && postWriteCallBackData != null) {
            long c2 = com.baidu.adp.lib.h.b.c(postWriteCallBackData.getPostId(), 0L);
            long c3 = com.baidu.adp.lib.h.b.c(postWriteCallBackData.getThreadId(), 0L);
            long c4 = com.baidu.adp.lib.h.b.c(this.forumId, 0L);
            if (c2 != 0 && c3 != 0 && c4 != 0) {
                com.baidu.adp.lib.h.h.hj().postDelayed(new v(this, c3, c2, c4), 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aZG.PL();
        this.aZF.a(this.aZL);
        this.aXV = true;
        this.aZC = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.aZq.nD();
        } else if (aZf) {
            aZf = false;
            this.aZq.nD();
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
            this.aZq.NP();
            this.aZG.PM().setSlidingEnabled(true);
            refresh();
            return;
        }
        this.aZq.NO();
        this.aZG.PM().setSlidingEnabled(false);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.aZi = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.aZl = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aZl) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    MG();
                } else {
                    MH();
                }
            }
        }
    }

    private void MG() {
        this.aZq.nD();
        this.aZG.PM().showContent(false);
    }

    private void MH() {
        this.aZq.nD();
        this.aZG.PM().showContent(false);
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
        this.aZq.NM().h(this.aZV);
        this.aZq.NM().i(this.aZW);
        if (this.aZj == 0) {
            this.aZq.setTitle(this.aZi);
        } else {
            this.aZq.setTitle("");
            this.aZj = 1;
        }
        this.aZG.PM();
        this.aZF.t(this.aZq.getListView());
        this.aZq.a(this.aZZ);
        this.aZq.a(this.bac);
        this.aZq.j(this.baa);
        this.aZq.l(this.bab);
        this.aZq.setOnScrollListener(this.aYd);
        this.aZq.a(this.HW);
        this.aZq.a(this.aZS);
        this.aZq.f(this.aXw);
        this.aZG.PM().setOnOpenedListener(this.bad);
        this.aZq.NM().a(this.aZU);
        if (!this.mIsLogin) {
            this.aZq.NO();
            this.aZG.PM().setSlidingEnabled(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.aZq.onChangeSkinType(i);
        this.aZG.a(getPageContext(), i);
        this.aZF.a(getPageContext(), i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> Mo() {
        if (this.aZv == null) {
            this.aZv = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.aZv;
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
                FrsActivity.this.showToast(n.i.shortcut_has_add);
            } else {
                FrsActivity.this.hf(this.name);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(String str) {
        Intent K;
        if (str != null && (K = com.baidu.tieba.frs.utils.a.K(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(n.i.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", K);
            BarImageView PD = this.aZF.PD();
            if (PD != null && PD.getBdImage() != null && PD.getBdImage().ng() != null) {
                Bitmap ng = PD.getBdImage().ng();
                Float valueOf = Float.valueOf(getResources().getDisplayMetrics().density);
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.d.ix().a(com.baidu.adp.lib.util.d.ix().d(ng, valueOf.intValue() * 48), valueOf.intValue() * 6));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), n.e.icon));
            }
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fV(int i) {
        if (!this.mIsLogin) {
            if (this.aZs != null && this.aZs.rZ() != null) {
                this.aZs.rZ().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.aZs != null) {
            if (i == 0) {
                if (!this.aZg) {
                    fW(0);
                    return;
                }
                TiebaStatic.log("c10152");
                fW(4);
                return;
            }
            this.aZq.NF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW(int i) {
        int i2 = 0;
        if (this.aZs.getUserData() != null) {
            i2 = this.aZs.getUserData().getIsMem();
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), i, this.aZs.ajy().getId(), this.aZi, null, null, 0, this.aZs.rZ(), 13003, false, false, null, false, false, null, null, this.aZs.ajy().getPrefixData(), i2);
        if (ed.Oe().gj(1) != null) {
            writeActivityConfig.setCategroyId(this.aZD.OZ());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.z zVar) {
        boolean tf = zVar == null ? true : zVar.tf();
        this.aZq.c(new x(this, zVar));
        this.aZq.a(zVar, tf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MI() {
        this.aZq.b(new y(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MJ() {
        this.aZq.a(new z(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MK() {
        if (com.baidu.tbadk.core.util.bj.ah(getPageContext().getPageActivity())) {
            AntiData rZ = this.aZs.rZ();
            if (rZ != null) {
                if (AntiHelper.d(rZ) || AntiHelper.e(rZ) || AntiHelper.f(rZ)) {
                    rZ.setBlock_forum_name(this.aZi);
                    rZ.setBlock_forum_id(this.aZs.ajy().getId());
                    rZ.setUser_name(this.aZs.getUserData().getUserName());
                    rZ.setUser_id(this.aZs.getUserData().getUserId());
                    if (AntiHelper.a(getPageContext().getPageActivity(), rZ, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(rZ.getPollMessage())) {
                    com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), rZ.getPollMessage());
                    return;
                }
            }
            PostPrefixData postPrefixData = null;
            if (this.aZs.ajy() != null) {
                postPrefixData = this.aZs.ajy().getPrefixData();
            }
            int i = 0;
            if (this.aZs.getUserData() != null) {
                i = this.aZs.getUserData().getIsMem();
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVoteActivityConfig(getPageContext().getPageActivity(), this.aZs.ajy().getId(), this.aZi, rZ, 13003, postPrefixData, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.z zVar) {
        boolean tf = zVar == null ? true : zVar.tf();
        if (this.mThreadId != null) {
            if (!tf) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.aZi, null, 18003, true, true, this.aZo)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.aZi, null, 18003, false, false, this.aZo)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.z zVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.aZi, null, 18003, false, false, this.aZo)));
        }
    }

    public void refresh() {
        bW(3);
    }

    public void bW(int i) {
        this.aZO = false;
        this.aZd = false;
        this.aZp = false;
        stopVoice();
        if (this.aZE != null && this.aZE.PN() != null) {
            this.aZE.PN().a(this.aZD.Pb(), this.aZD.Pc(), this.aZD.Pd());
        }
        MX().j(i, true);
    }

    private void ML() {
        switch (this.aZj) {
            case 1:
                com.baidu.adp.lib.h.k.hk().c(new aa(this));
                break;
        }
        this.aZj = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MM() {
        stopVoice();
        try {
            if (this.aZs != null) {
                this.aZq.NC();
                this.aZi = this.aZs.ajy().getName();
                this.forumId = this.aZs.ajy().getId();
                this.aZq.setTitle(this.aZi);
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.aZs.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.aZs.getUserData().getBimg_end_time());
                ML();
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aZs.getThreadList();
                if (threadList != null) {
                    this.aZq.a(threadList, this.mPn, this.aZs, this.aZs.getPage().sf());
                    MR();
                    this.aZF.gC(this.mPn);
                    this.aZF.d(this.aZs);
                    this.aZq.NG();
                    if (this.aZs.ajE() == 1) {
                        this.aZq.NM().setFromCDN(true);
                    } else {
                        this.aZq.NM().setFromCDN(false);
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
        this.aXV = false;
        this.aZC = false;
        this.aZq.onPause();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Object c2;
        super.onStop();
        if (this.aZs != null && this.aZs.ajy() != null) {
            com.baidu.tbadk.distribute.a.Bf().a(getPageContext().getPageActivity(), "frs", this.aZs.ajy().getId(), 0L);
        }
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
        BdListView listView = getListView();
        if (listView != null && (c2 = com.baidu.adp.lib.a.a.a.c(listView, "mRecycler")) != null) {
            com.baidu.adp.lib.a.a.a.a("clear", c2, c2.getClass());
        }
        this.aZF.onActivityStop();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.aZk) {
            if (i == 4) {
                if (this.aZG.onBackPressed()) {
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
            if (bVar.rD()) {
                com.baidu.tbadk.core.util.bf.vD().b(getPageContext(), new String[]{bVar.Up});
            } else if (bVar.rC()) {
                if (com.baidu.adp.lib.util.i.iP() && !com.baidu.adp.lib.util.i.iQ()) {
                    trim = getPageContext().getString(n.i.frs_network_tips);
                } else if (TextUtils.isEmpty(bVar.UA.UG.trim())) {
                    trim = getPageContext().getString(n.i.confirm_download_app);
                } else {
                    trim = bVar.UA.UG.trim();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cC(trim);
                aVar.a(n.i.alert_yes_button, new ab(this, bVar, i));
                aVar.b(n.i.alert_no_button, new ac(this));
                aVar.b(getPageContext()).tv();
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.b bVar, int i) {
        if (bVar != null) {
            if (!bVar.rB()) {
                com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), n.i.pb_app_error);
            } else if (com.baidu.adp.lib.util.i.iP()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", bVar.Ur);
                com.baidu.tbadk.download.b.Bm().a(bVar.Ur, bVar.Uq, bVar.Un, i, com.baidu.adp.lib.h.b.g(bVar.Um, 0));
            } else {
                showToast(n.i.neterror);
            }
        }
    }

    public void MN() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
        this.aZB = new a(this.aZi);
        this.aZB.setSelfExecute(true);
        this.aZB.execute(new String[0]);
    }

    public void MO() {
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.aZs.ajy().getId(), true, true, true);
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Bf().a(getPageContext().getPageActivity(), bVar, str, "frs", this.aZs.ajy().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Bf().a(bVar, this.forumId, 0L, "FRS", str, this.mPn);
    }

    public void MP() {
        if (checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10177").ab(ImageViewerConfig.FORUM_ID, this.forumId));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(getPageContext().getPageActivity(), String.valueOf(getForumId()), false, 0)));
        }
    }

    public void MQ() {
        if (checkUpIsLogin() && this.aZh != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(getPageContext().getPageActivity()).createConfig(String.valueOf(getForumId()), this.aZh.getTid(), 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fU(int i) {
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aZs.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.z) {
                    com.baidu.tbadk.core.data.z zVar = (com.baidu.tbadk.core.data.z) next;
                    if (zVar == this.aZc) {
                        b(zVar, i);
                        this.aZc = null;
                        break;
                    } else if (zVar.getId() != null && zVar.getId().equals(this.aXW)) {
                        b(zVar, i);
                        this.aXW = null;
                        break;
                    }
                }
            }
            this.aZq.NM().a(threadList, this.aZs);
            this.aZq.NM().notifyDataSetChanged();
        }
    }

    private void b(com.baidu.tbadk.core.data.z zVar, int i) {
        if (i == 1) {
            PraiseData praise = zVar.getPraise();
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
                    zVar.setPraise(praiseData);
                    return;
                }
                zVar.getPraise().getUser().add(0, metaData);
                zVar.getPraise().setNum(zVar.getPraise().getNum() + 1);
                zVar.getPraise().setIsLike(i);
            }
        } else if (zVar.getPraise() != null) {
            zVar.getPraise().setIsLike(i);
            zVar.getPraise().setNum(zVar.getPraise().getNum() - 1);
            ArrayList<MetaData> user = zVar.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        zVar.getPraise().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    public void a(ez.a aVar, String str) {
        if (str != null) {
            MX().ax(aVar.bfP, str);
            this.aZG.PK();
            this.aZi = str;
            if (this.aZq != null) {
                this.aZq.setTitle(this.aZi);
            }
            stopVoice();
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        private AppDownloadView bav;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            com.baidu.adp.widget.ListView.u aB = FrsActivity.this.aZq.NM().aB(intValue);
            if (aB instanceof com.baidu.tbadk.core.data.b) {
                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) aB;
                DownloadData downloadData = new DownloadData(bVar.Ur);
                downloadData.setUrl(bVar.Uq);
                downloadData.setName(bVar.Un);
                downloadData.setPosition(intValue);
                downloadData.setNotifyId(com.baidu.adp.lib.h.b.g(bVar.Um, 0));
                switch (AppDownloadView.b(downloadData)) {
                    case 1:
                    case 5:
                        com.baidu.tbadk.download.b.Bm().aj(bVar.Uq, bVar.Ur);
                        ((TextView) view).setText(n.i.frs_new_style_download_pause);
                        break;
                    case 3:
                        com.baidu.tieba.frs.utils.a.H(FrsActivity.this.getPageContext().getPageActivity(), bVar.Ur);
                        break;
                    case 6:
                        if (com.baidu.adp.lib.util.i.iP() && !com.baidu.adp.lib.util.i.iQ()) {
                            FrsActivity.this.a(bVar, intValue);
                            break;
                        } else {
                            this.bav.setVisibility(0);
                            ((TextView) view).setText(n.i.downloading2);
                            FrsActivity.this.a(bVar, "btn_download");
                            FrsActivity.this.b(bVar, "download");
                            FrsActivity.this.b((com.baidu.tbadk.core.data.b) aB, intValue);
                            break;
                        }
                    case 7:
                        FrsActivity.this.b((com.baidu.tbadk.core.data.b) aB, intValue);
                        ((TextView) view).setText(n.i.downloading2);
                        break;
                }
                TiebaStatic.eventStat(FrsActivity.this.getPageContext().getPageActivity(), "frs_tb_btc", "");
            }
        }

        public void b(AppDownloadView appDownloadView) {
            this.bav = appDownloadView;
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
        if (this.aZq == null) {
            return null;
        }
        return this.aZq.getListView();
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
    public int wk() {
        if (this.aZq == null) {
            return 0;
        }
        return this.aZq.NJ();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> wl() {
        if (this.afK == null) {
            this.afK = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.afK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            int msgStrangerChat = newsNotifyMessage.getMsgStrangerChat();
            if (this.aZt != null) {
                this.aZt.av(msgReplyme);
                this.aZt.au(msgAtme);
                this.aZt.aw(msgChat);
                this.aZt.ax(msgStrangerChat);
                this.aZq.a(this.aZt);
                this.aZG.a(this.aZt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        ba NM;
        HashMap<Integer, com.baidu.tbadk.core.data.z> Ne;
        if (this.aZs != null && this.aZq != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (NM = this.aZq.NM()) != null && (Ne = NM.Ne()) != null && Ne.size() > 0) {
            boolean z = false;
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    Iterator<Map.Entry<Integer, com.baidu.tbadk.core.data.z>> it = Ne.entrySet().iterator();
                    boolean z2 = z;
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        Map.Entry<Integer, com.baidu.tbadk.core.data.z> next = it.next();
                        int intValue = next.getKey().intValue();
                        com.baidu.tbadk.core.data.z value = next.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.b) && TextUtils.equals(((com.baidu.tbadk.core.data.b) value).Ur, downloadData.getId())) {
                            if (!(NM.aB(this.aZs.aCe() + intValue) instanceof com.baidu.tbadk.core.data.b)) {
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
            if (!this.JB || z) {
                this.aZq.ND();
            }
        }
    }

    private void MR() {
        HashMap<Integer, com.baidu.tbadk.core.data.z> Ne;
        if (this.aZq != null && this.aZq.NM() != null && (Ne = this.aZq.NM().Ne()) != null) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.z> entry : Ne.entrySet()) {
                com.baidu.tbadk.core.data.z value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.b)) {
                    arrayList.add((com.baidu.tbadk.core.data.b) value);
                }
            }
            com.baidu.tbadk.download.b.Bm().p(arrayList);
        }
    }

    public void MS() {
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v30, resolved type: com.baidu.tieba.frs.FrsActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.v
        public void a(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Uf.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Ug.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Uh.getId()) {
                    if (uVar == null || !(uVar instanceof com.baidu.tbadk.core.data.b)) {
                        return;
                    }
                    FrsActivity.this.a((com.baidu.tbadk.core.data.b) uVar, i, view.findViewById(n.f.frs_app_download), (AppDownloadView) view.findViewById(n.f.frs_app_download_view));
                } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.aa.dyo.getId()) {
                    if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Ui.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Uj.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.Uk.getId()) {
                        if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.b)) {
                            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) uVar;
                            if (!bVar.rC()) {
                                if (!bVar.rD()) {
                                    return;
                                }
                                FrsActivity.this.a(bVar);
                                return;
                            }
                            FrsActivity.this.a(bVar, i, view.findViewById(n.f.frs_app_download), (AppDownloadView) view.findViewById(n.f.frs_app_download_view));
                        }
                    } else if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.z)) {
                        com.baidu.tbadk.core.data.z zVar = (com.baidu.tbadk.core.data.z) uVar;
                        if (zVar.getAnchorInfoData() == null || zVar.getAnchorInfoData().getGroup_id() == 0 || FrsActivity.this.checkUpIsLogin()) {
                            if ((zVar.sY() != 1 && zVar.sY() != 2) || FrsActivity.this.checkUpIsLogin()) {
                                com.baidu.tieba.tbadkCore.util.p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.mF(zVar.getId())) {
                                    readThreadHistory.mE(zVar.getId());
                                }
                                boolean z = false;
                                String sN = zVar.sN();
                                if (sN != null && !sN.equals("")) {
                                    z = true;
                                    new Thread(new aq(this, sN)).start();
                                }
                                String tid = zVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (zVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.bf vD = com.baidu.tbadk.core.util.bf.vD();
                                    TbPageContext<?> pageContext = FrsActivity.this.getPageContext();
                                    String[] strArr = new String[3];
                                    strArr[0] = tid;
                                    strArr[1] = "";
                                    vD.b(pageContext, strArr);
                                    return;
                                }
                                boolean z2 = false;
                                if (zVar instanceof com.baidu.tbadk.core.data.k) {
                                    z2 = true;
                                    TiebaStatic.log("c10413");
                                }
                                if (zVar.getThreadType() == 33 || (zVar instanceof com.baidu.tbadk.core.data.t)) {
                                    if (!z2) {
                                        String str = zVar.getThreadType() == 33 ? "c10245" : "c10180";
                                        if (FrsActivity.this.aZD.Pb() == 5) {
                                            str = "c10387";
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.av(str).ab(ImageViewerConfig.FORUM_ID, FrsActivity.this.forumId));
                                    }
                                    FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(FrsActivity.this.getPageContext().getPageActivity(), zVar.getTid()).cn("from_frs").bv(18003).rw()));
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    zVar.setId(tid.substring(3));
                                }
                                if (!z2 && FrsActivity.this.aZD.Pb() == 2) {
                                    com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10077");
                                    avVar.r("obj_source", FrsActivity.this.aZD.Pb());
                                    avVar.ab("tid", zVar.getId());
                                    avVar.ab(ImageViewerConfig.FORUM_ID, FrsActivity.this.getForumId());
                                    TiebaStatic.log(avVar);
                                }
                                if (zVar.getAuthor() != null && zVar.getAuthor().getGodInfo() != null) {
                                    com.baidu.tbadk.core.util.av avVar2 = new com.baidu.tbadk.core.util.av("c10625");
                                    avVar2.ab("obj_id", zVar.getAuthor().getUserId());
                                    TiebaStatic.log(avVar2);
                                }
                                FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(FrsActivity.this.getPageContext().getPageActivity()).createFromThreadCfg(zVar, FrsActivity.this.aZi, null, 18003, true, false, z)));
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
            a(bVar, "area_click");
            b(bVar, "click");
            com.baidu.tieba.recapp.report.b.avU().a(com.baidu.tieba.recapp.report.e.a(bVar, "click", this.mPn));
            DownloadData downloadData = new DownloadData(bVar.Ur);
            downloadData.setUrl(bVar.Uq);
            downloadData.setName(bVar.Un);
            downloadData.setPosition(i);
            downloadData.setNotifyId(com.baidu.adp.lib.h.b.g(bVar.Um, 0));
            switch (AppDownloadView.b(downloadData)) {
                case 3:
                    com.baidu.tieba.frs.utils.a.H(getPageContext().getPageActivity(), bVar.Ur);
                    break;
                case 6:
                    if (com.baidu.adp.lib.util.i.iP() && !com.baidu.adp.lib.util.i.iQ()) {
                        a(bVar, i);
                        break;
                    } else if (bVar.rD()) {
                        com.baidu.tbadk.core.util.bf.vD().b(getPageContext(), new String[]{bVar.Up});
                        break;
                    } else if (bVar.rC()) {
                        appDownloadView.setVisibility(0);
                        ((TextView) view).setText(n.i.downloading2);
                        a(bVar, "area_download");
                        b(bVar, "download");
                        b(bVar, i);
                        break;
                    }
                    break;
                case 7:
                    b(bVar, i);
                    ((TextView) view).setText(n.i.downloading2);
                    break;
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", bVar.Ur);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.b bVar) {
        if (bVar != null) {
            a(bVar, "btn_click");
            b(bVar, "click");
            com.baidu.tieba.recapp.report.b.avU().a(com.baidu.tieba.recapp.report.e.a(bVar, "click", this.mPn));
            com.baidu.tbadk.core.util.bf.vD().b(getPageContext(), new String[]{bVar.Up});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.aZq.getRootView());
        showLoadingView(this.aZq.getRootView(), true);
        this.aZq.NL();
        this.aZq.nD();
    }

    public com.baidu.tieba.tbadkCore.p MT() {
        return this.aZs;
    }

    public boolean MU() {
        return this.aZq.MU();
    }

    public void MV() {
        FrsActivityStatic.bay = false;
        FrsActivityStatic.baz = false;
        MD();
    }

    public void MW() {
        this.aZF.MW();
    }

    public com.baidu.tieba.frs.mc.a MX() {
        return this.aZD;
    }

    public void a(cd cdVar) {
        this.aZq = cdVar;
    }

    public void hg(String str) {
        this.aZi = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFlag(int i) {
        this.aZj = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    public void resetData() {
        this.aZd = false;
        this.aZp = false;
        this.aZs = null;
        this.aZq.setTitle(this.aZi);
        this.aZG.cA(false);
        this.aZG.setIsManager(false);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.jg()) {
            this.aZq.NT();
        } else if (this.aZD.Pb() == 1) {
            MY();
            loadMore();
        } else if (this.aZD.hasMore()) {
            loadMore();
        }
    }

    public void hh(String str) {
        MY();
        showToast(str);
    }

    public void E(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.u> a2;
        MY();
        if (arrayList != null && arrayList.size() != 0 && (a2 = this.aZH.a(false, arrayList, this.aZn)) != null) {
            this.aZs.am(a2);
            this.aZq.a(a2, this.mPn, this.aZs, 0);
        }
    }

    private void MY() {
        if (this.aZI == 0 && !this.aZH.ai(this.aZs.aBH())) {
            if (this.aZs.getThreadList() == null || this.aZs.getThreadList().size() == 0) {
                this.aZq.NT();
                return;
            } else {
                this.aZq.NS();
                return;
            }
        }
        this.aZq.NR();
    }

    public void loadMore() {
        if (this.aZD.Pb() == 1) {
            if (!this.aZH.awu && !this.aZD.isLoading()) {
                if (this.aZH.ai(this.aZs.aBH())) {
                    this.aZq.a(this.aZH.OB(), this.mPn, this.aZs, 0);
                    this.aZH.a(com.baidu.adp.lib.h.b.c(this.forumId, 0L), this.aZs.aBH(), this.aZi, this.mPn);
                } else if (this.aZI != 0) {
                    this.aZq.a(this.aZH.OB(), this.mPn, this.aZs, 0);
                    this.mPn++;
                    this.aZD.gp(this.mPn);
                    this.aZH.bgB = false;
                    this.aZH.bgC = 0;
                }
            }
        } else if (!this.aZD.Pf()) {
            if (this.aZE.PN() != null) {
                this.aZE.PN().a(this.aZD.Pb(), this.aZD.Pc(), this.aZD.Pd());
            }
            this.aZD.Iz();
        }
    }

    public void showShareDialog() {
        String name;
        if (this.aZs != null && this.aZs.ajy() != null) {
            if (this.aZs.ajy().getName() == null) {
                showToast(getPageContext().getString(n.i.no_forum_data));
                return;
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String str = "http://tieba.baidu.com/f?kw=" + this.aZs.ajy().getName();
            Uri parse = this.aZs.ajy().getImage_url() == null ? null : Uri.parse(this.aZs.ajy().getImage_url());
            String slogan = this.aZs.ajy().getSlogan();
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = String.valueOf(name) + getPageContext().getString(n.i.forum);
            fVar.content = slogan;
            fVar.linkUrl = str;
            fVar.akH = true;
            fVar.extData = getForumId();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true, qF());
            shareDialogConfig.addOutsideTextView(n.i.share_tieba_qunzu, n.e.icon_unite_share_qunzu, new ad(this));
            shareDialogConfig.addOutsideTextView(n.i.forum_friend, n.e.icon_unite_share_baf, new ae(this));
            shareDialogConfig.setCopyLinkListener(new af(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private SparseArray<String> qF() {
        if (this.aZJ == null) {
            this.aZJ = new SparseArray<>(7);
            this.aZJ.put(2, "frs_wx_timeline");
            this.aZJ.put(3, "frs_wx_friend");
            this.aZJ.put(4, "frs_qq_zone");
            this.aZJ.put(5, "frs_tencent_weibo");
            this.aZJ.put(6, "frs_sina_weibo");
        }
        return this.aZJ;
    }

    private ShareFromFrsMsgData MZ() {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(this.aZs.ajy().getImage_url());
        shareFromFrsMsgData.setName(this.aZs.ajy().getName());
        shareFromFrsMsgData.setMemberNum(this.aZs.ajy().getMember_num());
        shareFromFrsMsgData.setPostNum(this.aZs.ajy().getPost_num());
        shareFromFrsMsgData.setContent(this.aZs.ajy().getSlogan());
        return shareFromFrsMsgData;
    }

    private void N(Intent intent) {
        a(MZ(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromFrsMsgData shareFromFrsMsgData, long j, String str, String str2) {
        if (this.aZs != null && this.aZs.ajy() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.p pVar = new com.baidu.tieba.frs.view.p(getPageContext().getPageActivity());
            pVar.setData(shareFromFrsMsgData);
            aVar.bP(1);
            aVar.m(pVar);
            aVar.a(n.i.share, new ag(this, pVar, j, str, str2, shareFromFrsMsgData));
            aVar.b(n.i.alert_no_button, new ai(this, pVar));
            aVar.am(false);
            aVar.b(getPageContext()).tv();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                pVar.x(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }

    private void a(ShareFromFrsMsgData shareFromFrsMsgData, int i, String str, long j) {
        if (this.aZs != null && this.aZs.ajy() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.p pVar = new com.baidu.tieba.frs.view.p(getPageContext().getPageActivity());
            pVar.setData(shareFromFrsMsgData);
            aVar.bP(1);
            aVar.m(pVar);
            aVar.a(n.i.share, new aj(this, pVar, i, str, j, shareFromFrsMsgData));
            aVar.b(n.i.alert_no_button, new ak(this, pVar));
            aVar.am(false);
            aVar.b(getPageContext()).tv();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                pVar.x(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }
}
