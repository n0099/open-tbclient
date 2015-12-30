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
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
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
import com.baidu.tbadk.core.view.r;
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
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
/* loaded from: classes.dex */
public class FrsActivity extends BaseActivity<FrsActivity> implements BdListView.e, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c {
    public static String bcV = "speed_icon_show";
    private static final int bcW = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds90);
    private static final int bcX = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds300);
    public static boolean bdb = false;
    public static volatile long bds = 0;
    public static volatile long bdt = 0;
    public static volatile int bdu = 0;
    private static boolean isNeedRefreshOnResume = false;
    private com.baidu.adp.lib.f.b<TbImageView> agI;
    private boolean bbV;
    private String bbW;
    private com.baidu.tbadk.core.data.z bcY;
    private com.baidu.tieba.frs.b.o bdA;
    private com.baidu.tieba.frs.b.a bdB;
    private com.baidu.tieba.frs.b.l bdC;
    private com.baidu.tieba.frs.loadmore.a bdD;
    private boolean bdc;
    private com.baidu.tbadk.core.data.z bdd;
    private com.baidu.tieba.tbadkCore.data.e bdj;
    private dw bdp;
    private com.baidu.adp.lib.f.b<TbImageView> bdr;
    private a bdx;
    private com.baidu.tieba.frs.mc.a bdz;
    VoiceManager mVoiceManager;
    private boolean bcZ = false;
    public boolean bda = false;
    public String bde = null;
    public String mFrom = null;
    public int bdf = 0;
    private int mPn = 1;
    private boolean bdg = false;
    private boolean bdh = false;
    private String mThreadId = null;
    private String forumId = null;
    private int bdi = 0;
    private boolean bdk = false;
    private boolean bdl = false;
    private cg bdm = null;
    private final com.baidu.tbadk.core.data.z bdn = null;
    private com.baidu.tieba.tbadkCore.p bdo = new com.baidu.tieba.tbadkCore.p();
    private com.baidu.tbadk.core.data.z bdq = null;
    private boolean JR = false;
    public long aUp = -1;
    public long azV = 0;
    public long createTime = 0;
    public long VP = -1;
    private boolean bdv = false;
    public com.baidu.tbadk.performanceLog.e bdw = null;
    private boolean bdy = true;
    private int bdE = -1;
    private SparseArray<String> bdF = null;
    private ev bdG = new com.baidu.tieba.frs.a(this);
    private eu bdH = new l(this);
    private CustomMessageListener agG = new w(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener baJ = new ah(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
    private CustomMessageListener aKQ = new ao(this, CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND);
    public final CustomMessageListener bdI = new ap(this, CmdConfigCustom.MSG_NEW);
    private CustomMessageListener bdJ = new aq(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    private boolean bdK = false;
    public final com.baidu.tieba.tbadkCore.s bdL = new ar(this);
    private final CustomMessageListener Uk = new as(this, CmdConfigCustom.CMD_REFRESH);
    private final CustomMessageListener mMemListener = new com.baidu.tieba.frs.b(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private CustomMessageListener bdM = new com.baidu.tieba.frs.c(this, CmdConfigCustom.CMD_FRS_VIDEO_GUIDE_WRITE_SUCCESS);
    private CustomMessageListener bdN = new d(this, CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE);
    private final com.baidu.adp.framework.listener.a bdO = new e(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    private final r.a bdP = new f(this);
    private final BdListView.g Im = new g(this);
    public final View.OnClickListener bdQ = new h(this);
    private final AbsListView.OnScrollListener bcc = new i(this);
    private final bf bdR = new j(this);
    private final com.baidu.tieba.tbadkCore.af bce = new com.baidu.tieba.tbadkCore.af(getPageContext(), new k(this));
    private final View.OnClickListener bdS = new m(this);
    private final View.OnClickListener bdT = new b();
    public final AdapterView.OnItemClickListener bdU = new n(this);
    private final NoNetworkView.a bbw = new o(this);
    private final CustomMessageListener bdV = new p(this, 0);
    private com.baidu.adp.widget.ListView.v bdW = new c();
    private View.OnClickListener bdX = new q(this);
    private View.OnClickListener bdY = new r(this);
    private com.baidu.adp.widget.ListView.w bdZ = new s(this);
    private final SlidingMenu.OnOpenedListener bea = new t(this);
    public final com.baidu.adp.base.g beb = new u(this);
    public final com.baidu.adp.base.g bec = new v(this);

    public String getForumId() {
        return this.forumId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.y yVar) {
        if (yVar != null) {
            boolean z = yVar.isLike() == 1;
            if (this.bdm != null && this.bdo != null && this.bdo.akG() != null && yVar.getFid() != null) {
                if (yVar.getFid().equals(this.bdo.akG().getId())) {
                    this.bdo.akG().setLike(yVar.isLike());
                    if (!StringUtils.isNULL(yVar.getLevelName())) {
                        this.bdo.akG().setLevelName(yVar.getLevelName());
                    }
                    if (yVar.Sa() >= 0) {
                        this.bdo.akG().setUser_level(yVar.Sa());
                    }
                    if (z) {
                        this.bdB.a(this.bdo, false);
                        this.bdC.cB(true);
                        TbadkCoreApplication.m411getInst().addLikeForum(this.bde);
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.aDI().I(this.bde, false);
                    this.bdo.akG().setLike(0);
                    this.bdB.PL();
                    this.bdC.cB(false);
                    TbadkCoreApplication.m411getInst().delLikeForum(this.bde);
                    return;
                }
                if (yVar.isLike() == 1) {
                    this.bdo.mj(yVar.getFid());
                    this.bdB.d(this.bdo);
                }
                if (this.bdo.akG().getBannerListData() != null) {
                    this.bdo.akG().getBannerListData().setFeedForumLiked(yVar.getFid(), yVar.isLike());
                }
                this.bdm.NW();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    public void a(ErrorData errorData) {
        this.bdm.cs(false);
        this.bdm.ct(false);
        this.bdm.cu(false);
        this.bdm.NW();
        hideLoadingView(this.bdm.getRootView());
        this.bdm.Od();
        if (!this.bdl) {
            e.a Pq = Nr().Pq();
            if (!this.bcZ) {
                if (Pq != null) {
                    if (this.bdz.Pr() != 0) {
                        this.bdz.Py();
                        this.bdm.NW();
                    } else if (Pq.dEt) {
                        if (340001 == Pq.errorCode) {
                            showNetRefreshViewNoClick(this.bdm.getRootView(), getPageContext().getResources().getString(n.j.net_error_text, Pq.errorMsg, Integer.valueOf(Pq.errorCode)), true);
                        } else {
                            showNetRefreshView(this.bdm.getRootView(), getPageContext().getResources().getString(n.j.net_error_text, Pq.errorMsg, Integer.valueOf(Pq.errorCode)), true);
                        }
                    } else if (340001 == Pq.errorCode) {
                        showNetRefreshViewNoClick(this.bdm.getRootView(), Pq.errorMsg, true);
                    } else {
                        showNetRefreshView(this.bdm.getRootView(), Pq.errorMsg, true);
                    }
                    this.bdm.ga(8);
                }
            } else if (Pq != null && Pq.dEt) {
                this.bdm.ga(0);
                showToast(getPageContext().getResources().getString(n.j.net_error_text, Pq.errorMsg, Integer.valueOf(Pq.errorCode)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.n nVar) {
        boolean z;
        if (!this.bdK && nVar != null) {
            try {
                this.bdo.d(nVar);
                if (this.bdo.akM() == 1) {
                    this.bdm.Of().setFromCDN(true);
                } else {
                    this.bdm.Of().setFromCDN(false);
                }
                this.bdE = this.bdo.getPage().rO();
                this.bdm.a(this.bdo.akG(), this.bdo.getUserData(), 0);
                if (this.bdo.aDW() == null) {
                    z = false;
                } else {
                    z = this.bdo.aDW().size() != 0;
                }
                this.bdB.a(this.bdo.aDK().aEe() == 1, this.bdo.getUserData().getIsMem(), this.bdo.akG().isLike(), z);
                this.bdm.NV();
                this.bde = this.bdo.akG().getName();
                this.forumId = this.bdo.akG().getId();
                this.bdm.setTitle(this.bde);
                Nf();
                this.bdo.aEn();
                this.bdo.aEs();
                if (!Nr().Pp() && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.bdo.aEr();
                    this.bdo.aEq();
                    this.bdo.aEp();
                }
                this.bdo.aEu();
                if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                    this.bdo.aO(getPageContext().getPageActivity());
                }
                com.baidu.tbadk.core.data.ab top_notice_data = this.bdo.akG().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.getTitle() != null) {
                    com.baidu.tbadk.core.data.z zVar = new com.baidu.tbadk.core.data.z();
                    zVar.setTitle(top_notice_data.getTitle());
                    zVar.bC(2);
                    zVar.cx(top_notice_data.sY());
                    zVar.parser_title();
                    this.bdo.i(zVar);
                }
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bdo.getThreadList();
                if (threadList != null) {
                    ArrayList<com.baidu.adp.widget.ListView.u> a2 = this.bdD.a(true, threadList);
                    if (a2 != null) {
                        this.bdo.am(a2);
                    }
                    this.bdm.a(threadList, this.mPn, this.bdo, this.bdo.getPage().rO());
                    Nl();
                    this.bdB.gv(this.mPn);
                    this.bdB.d(this.bdo);
                    this.bdm.NZ();
                }
                this.bdi = this.bdo.Pw();
                if (this.bdj != null) {
                    this.bdj.mU(this.bdi);
                }
                this.bdB.cz(this.bdo.aDM());
                hideLoadingView(this.bdm.getRootView());
                this.bdm.ga(0);
                this.bdm.Od();
                this.bcZ = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        bcV = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (intent != null) {
            this.aUp = intent.getLongExtra("TibaStatic.StartTime", -1L);
            if (intent.getData() != null) {
                Uri data = intent.getData();
                this.bde = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.bde)) {
                    intent.putExtra("name", this.bde);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.bde)) {
                this.bde = L(intent);
                if (!StringUtils.isNull(this.bde)) {
                    intent.putExtra("name", this.bde);
                }
            }
        } else {
            this.aUp = System.currentTimeMillis();
        }
        if (this.aUp != -1) {
            this.VP = this.aUp;
        } else {
            this.VP = System.currentTimeMillis();
        }
        if (!cp(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.VP;
            return;
        }
        super.onCreate(bundle);
        this.bdz = new com.baidu.tieba.frs.mc.a(this);
        this.bdz.a(this.bdG);
        this.bdz.init();
        if (getIntent() != null) {
            this.bdz.b(getIntent().getExtras());
        } else if (bundle != null) {
            this.bdz.b(bundle);
        } else {
            this.bdz.b((Bundle) null);
        }
        Nr().ow();
        setContentView(n.h.frs_activity);
        this.bdA = new com.baidu.tieba.frs.b.o(this);
        this.bdC = new com.baidu.tieba.frs.b.l(this);
        this.bdB = new com.baidu.tieba.frs.b.a(this, this.bdA);
        this.bdA.ov();
        if (getIntent() != null) {
            this.bdB.d(getIntent().getExtras());
        } else if (bundle != null) {
            this.bdB.d(bundle);
        } else {
            this.bdB.d((Bundle) null);
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        this.bce.setUniqueId(getUniqueId());
        this.bce.registerListener();
        addGlobalLayoutListener();
        MV();
        registerListener(this.Uk);
        registerListener(this.mMemListener);
        registerListener(this.bdI);
        registerListener(this.agG);
        registerListener(this.aKQ);
        registerListener(this.baJ);
        registerListener(this.bdJ);
        registerListener(this.bdM);
        registerListener(this.bdN);
        this.bdO.getSocketMessageListener().setSelfListener(true);
        this.bdO.getHttpMessageListener().setSelfListener(true);
        this.bdO.setTag(getUniqueId());
        registerListener(this.bdO);
        this.bdD = new com.baidu.tieba.frs.loadmore.a(this);
        this.bdD.registerListener();
        this.bdj = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.dGB);
        this.createTime = System.currentTimeMillis() - this.aUp;
        if (this.bdm != null) {
            showLoadingView(this.bdm.getRootView(), true);
            this.bdm.Oe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
        } else if (this.bdo != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null && this.bdm != null) {
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
            this.bdz.a(oVar);
            ArrayList<com.baidu.adp.widget.ListView.u> a2 = this.bdD.a(true, this.bdo.getThreadList());
            if (a2 != null) {
                this.bdo.am(a2);
                this.bdm.a(a2, this.mPn, this.bdo, this.bdE);
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

    private void MV() {
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
        MX();
        if (bundle != null) {
            this.bde = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.bdf = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bde = intent.getStringExtra("name");
                this.mFrom = intent.getStringExtra("from");
                this.bdf = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            setSwipeBackEnabled(false);
        }
        this.bdp = new dw(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            MW();
            MY();
        }
        this.bdB.d(bundle);
    }

    private String L(Intent intent) {
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

    public void MW() {
        if (this.bdp != null && this.bdm != null) {
            if (FrsActivityStatic.bex || FrsActivityStatic.bey) {
                this.bdp.aw(com.baidu.tbadk.coreExtra.messageCenter.a.xv().getMsgReplyme());
                this.bdp.av(com.baidu.tbadk.coreExtra.messageCenter.a.xv().getMsgAtme());
                this.bdp.ay(com.baidu.tbadk.coreExtra.messageCenter.a.xv().xC());
                this.bdp.ax(com.baidu.tbadk.coreExtra.messageCenter.a.xv().getMsgChat());
                this.bdm.a(this.bdp);
                this.bdC.a(this.bdp);
            }
        }
    }

    private void MX() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bdV);
    }

    private void MY() {
        registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.bdV);
    }

    private boolean cp(boolean z) {
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
        if (this.bdo != null && this.bdo.akG() != null) {
            em.Oz().az(com.baidu.adp.lib.h.b.c(this.bdo.akG().getId(), 0L));
        }
        if (this.bdm != null) {
            this.bdm.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.bdw != null) {
                this.bdw.onDestroy();
            }
            this.bdm.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.bdz.onActivityDestroy();
        this.bdA.onActivityDestroy();
        this.bdB.onActivityDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
        if (this.bdx != null) {
            this.bdx.cancel(true);
            this.bdx = null;
        }
        if (this.bdz != null) {
            this.bdz.My();
        }
        if (this.bdC != null) {
            this.bdC.destroy();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.bde);
        bundle.putString("from", this.mFrom);
        this.bdz.onSaveInstanceState(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.z ml;
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    fQ(0);
                    return;
                case 11002:
                    this.bdB.os();
                    return;
                case 11011:
                    d(this.bdn);
                    return;
                case 11012:
                    e(this.bdq);
                    return;
                case 11014:
                    this.bdB.PW();
                    return;
                case 11016:
                    this.bdm.NY();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    this.bdB.Nq();
                    return;
                case 13003:
                    if (intent != null && !Nr().Pp()) {
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
                    this.bdm.Of().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (ml = this.bdo.ml(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            ml.bD(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            ml.parser_title();
                            bP(6);
                            return;
                        } else if (intExtra == 0) {
                            this.bdo.j(ml);
                            this.bdm.NZ();
                            if (com.baidu.tieba.tbadkCore.d.aDI() != null) {
                                com.baidu.tieba.tbadkCore.d.aDI().I(this.bde, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    Ni();
                    return;
                case 23003:
                    if (intent != null && this.bdo != null) {
                        a(Nt(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    M(intent);
                    return;
                case 23013:
                    Nj();
                    return;
                case 23019:
                    Nk();
                    return;
                case 24002:
                    if (intent != null) {
                        int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                        int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                        int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                        int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                        if (intExtra2 == com.baidu.adp.lib.h.b.g(this.forumId, 0)) {
                            this.bdB.r(intExtra3, intExtra4, intExtra5);
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
        int Pr = this.bdz.Pr();
        if (ed.Ox().gc(1) == null) {
            Pr = 0;
        }
        if (Pr == 0 && postWriteCallBackData != null) {
            long c2 = com.baidu.adp.lib.h.b.c(postWriteCallBackData.getPostId(), 0L);
            long c3 = com.baidu.adp.lib.h.b.c(postWriteCallBackData.getThreadId(), 0L);
            long c4 = com.baidu.adp.lib.h.b.c(this.forumId, 0L);
            if (c2 != 0 && c3 != 0 && c4 != 0) {
                com.baidu.adp.lib.h.h.hj().postDelayed(new x(this, c3, c2, c4), 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bdC.Qd();
        this.bdB.a(this.bdH);
        this.bbV = true;
        this.bdy = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.bdm.nb();
        } else if (bdb) {
            bdb = false;
            this.bdm.nb();
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
            this.bdm.Oi();
            this.bdC.Qe().setSlidingEnabled(true);
            refresh();
            return;
        }
        this.bdm.Oh();
        this.bdC.Qe().setSlidingEnabled(false);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.bde = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.bdh = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.bdh) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    MZ();
                } else {
                    Na();
                }
            }
        }
    }

    private void MZ() {
        this.bdm.nb();
        this.bdC.Qe().showContent(false);
    }

    private void Na() {
        this.bdm.nb();
        this.bdC.Qe().showContent(false);
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
        this.bdm.Of().h(this.bdS);
        this.bdm.Of().i(this.bdT);
        if (this.bdf == 0) {
            this.bdm.setTitle(this.bde);
        } else {
            this.bdm.setTitle("");
            this.bdf = 1;
        }
        this.bdC.Qe();
        this.bdB.t(this.bdm.getListView());
        this.bdm.a(this.bdW);
        this.bdm.a(this.bdZ);
        this.bdm.j(this.bdX);
        this.bdm.l(this.bdY);
        this.bdm.setOnScrollListener(this.bcc);
        this.bdm.a(this.Im);
        this.bdm.a(this.bdP);
        this.bdm.f(this.bbw);
        this.bdC.Qe().setOnOpenedListener(this.bea);
        this.bdm.Of().a(this.bdR);
        if (!this.mIsLogin) {
            this.bdm.Oh();
            this.bdC.Qe().setSlidingEnabled(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.bdm.onChangeSkinType(i);
        this.bdC.a(getPageContext(), i);
        this.bdB.a(getPageContext(), i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> MH() {
        if (this.bdr == null) {
            this.bdr = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.bdr;
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
                FrsActivity.this.showToast(n.j.shortcut_has_add);
            } else {
                FrsActivity.this.hp(this.name);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hp(String str) {
        Intent K;
        if (str != null && (K = com.baidu.tieba.frs.utils.a.K(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(n.j.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", K);
            BarImageView PV = this.bdB.PV();
            if (PV != null && PV.getBdImage() != null && PV.getBdImage().mE() != null) {
                Bitmap mE = PV.getBdImage().mE();
                Float valueOf = Float.valueOf(getResources().getDisplayMetrics().density);
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.d.ix().a(com.baidu.adp.lib.util.d.ix().d(mE, valueOf.intValue() * 48), valueOf.intValue() * 6));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), n.f.icon));
            }
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fQ(int i) {
        if (!this.mIsLogin) {
            if (this.bdo != null && this.bdo.rI() != null) {
                this.bdo.rI().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.bdo != null) {
            if (i == 0) {
                if (!this.bdc) {
                    fR(0);
                    return;
                }
                TiebaStatic.log("c10152");
                fR(4);
                return;
            }
            this.bdm.NY();
        }
    }

    private void fR(int i) {
        int i2 = 0;
        if (this.bdo.getUserData() != null) {
            i2 = this.bdo.getUserData().getIsMem();
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), i, this.bdo.akG().getId(), this.bde, null, null, 0, this.bdo.rI(), 13003, false, false, null, false, false, null, null, this.bdo.akG().getPrefixData(), i2);
        if (ed.Ox().gc(1) != null) {
            writeActivityConfig.setCategroyId(this.bdz.Pr());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.z zVar) {
        boolean sP = zVar == null ? true : zVar.sP();
        this.bdm.c(new y(this, zVar));
        this.bdm.a(zVar, sP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nb() {
        this.bdm.b(new z(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nc() {
        this.bdm.a(new aa(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nd() {
        if (!this.mIsLogin) {
            skipToRegisterActivity();
            return;
        }
        boolean z = false;
        String str = "";
        if (this.bdo.akG() != null && this.bdo.akG().getAnchorPower() != null) {
            z = this.bdo.akG().getCanAddPhotoLivePost();
            str = this.bdo.akG().getAnchorPower().can_add_live_post_msg;
        }
        if (z) {
            this.bdc = true;
            fR(4);
            com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), true);
            return;
        }
        hq(str);
    }

    private void hq(String str) {
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
                aVar.cF(optString);
                aVar.a(n.j.view, new ab(this, optString2));
                aVar.b(n.j.cancel, new ac(this));
                aVar.b(getPageContext()).tf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ne() {
        if (com.baidu.tbadk.core.util.bj.ah(getPageContext().getPageActivity())) {
            AntiData rI = this.bdo.rI();
            if (rI != null) {
                if (AntiHelper.d(rI) || AntiHelper.e(rI) || AntiHelper.f(rI)) {
                    rI.setBlock_forum_name(this.bde);
                    rI.setBlock_forum_id(this.bdo.akG().getId());
                    rI.setUser_name(this.bdo.getUserData().getUserName());
                    rI.setUser_id(this.bdo.getUserData().getUserId());
                    if (AntiHelper.a(getPageContext().getPageActivity(), rI, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(rI.getPollMessage())) {
                    com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), rI.getPollMessage());
                    return;
                }
            }
            PostPrefixData postPrefixData = null;
            if (this.bdo.akG() != null) {
                postPrefixData = this.bdo.akG().getPrefixData();
            }
            int i = 0;
            if (this.bdo.getUserData() != null) {
                i = this.bdo.getUserData().getIsMem();
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVoteActivityConfig(getPageContext().getPageActivity(), this.bdo.akG().getId(), this.bde, rI, 13003, postPrefixData, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.z zVar) {
        boolean sP = zVar == null ? true : zVar.sP();
        if (this.mThreadId != null) {
            if (!sP) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.bde, null, 18003, true, true, this.bdk)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.bde, null, 18003, false, false, this.bdk)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tbadk.core.data.z zVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.bde, null, 18003, false, false, this.bdk)));
        }
    }

    public void refresh() {
        bP(3);
    }

    public void bP(int i) {
        this.bdK = false;
        this.bcZ = false;
        this.bdl = false;
        stopVoice();
        if (this.bdA != null && this.bdA.Qf() != null) {
            this.bdA.Qf().a(this.bdz.Pt(), this.bdz.Pu(), this.bdz.Pv());
        }
        Nr().j(i, true);
    }

    private void Nf() {
        switch (this.bdf) {
            case 1:
                com.baidu.adp.lib.h.k.hk().c(new ad(this));
                break;
        }
        this.bdf = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ng() {
        stopVoice();
        try {
            if (this.bdo != null) {
                this.bdm.NV();
                this.bde = this.bdo.akG().getName();
                this.forumId = this.bdo.akG().getId();
                this.bdm.setTitle(this.bde);
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.bdo.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.bdo.getUserData().getBimg_end_time());
                Nf();
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bdo.getThreadList();
                if (threadList != null) {
                    this.bdm.a(threadList, this.mPn, this.bdo, this.bdo.getPage().rO());
                    Nl();
                    this.bdB.gv(this.mPn);
                    this.bdB.d(this.bdo);
                    this.bdm.NZ();
                    if (this.bdo.akM() == 1) {
                        this.bdm.Of().setFromCDN(true);
                    } else {
                        this.bdm.Of().setFromCDN(false);
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
        this.bbV = false;
        this.bdy = false;
        this.bdm.onPause();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Object c2;
        super.onStop();
        if (this.bdo != null && this.bdo.akG() != null) {
            com.baidu.tbadk.distribute.a.AV().a(getPageContext().getPageActivity(), "frs", this.bdo.akG().getId(), 0L);
        }
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
        BdListView listView = getListView();
        if (listView != null && (c2 = com.baidu.adp.lib.a.a.a.c(listView, "mRecycler")) != null) {
            com.baidu.adp.lib.a.a.a.a("clear", c2, c2.getClass());
        }
        this.bdB.onActivityStop();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.bdg) {
            if (i == 4) {
                if (this.bdC.onBackPressed()) {
                    return true;
                }
                closeActivity();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void a(com.baidu.tbadk.core.data.b bVar, int i, boolean z) {
        String trim;
        if (bVar != null) {
            if (!com.baidu.adp.lib.util.i.iE()) {
                showToast(n.j.neterror);
            } else if (bVar.rm()) {
                com.baidu.tbadk.core.util.bf.vn().a(getPageContext(), new String[]{bVar.UQ}, true);
            } else if (bVar.rl()) {
                if (com.baidu.adp.lib.util.i.iQ() && !com.baidu.adp.lib.util.i.iR()) {
                    trim = getPageContext().getString(n.j.frs_network_tips);
                } else if (TextUtils.isEmpty(bVar.Vb.Vh.trim())) {
                    trim = getPageContext().getString(n.j.confirm_download_app);
                } else {
                    trim = bVar.Vb.Vh.trim();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cF(trim);
                aVar.a(n.j.alert_yes_button, new ae(this, bVar, z, i));
                aVar.b(n.j.alert_no_button, new af(this));
                aVar.b(getPageContext()).tf();
            }
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar, int i) {
        if (bVar != null) {
            if (!bVar.rk()) {
                com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), n.j.pb_app_error);
            } else if (com.baidu.tieba.tbadkCore.ah.a(getPageContext().getPageActivity(), bVar, i)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", bVar.US);
            }
        }
    }

    public void Nh() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
        this.bdx = new a(this.bde);
        this.bdx.setSelfExecute(true);
        this.bdx.execute(new String[0]);
    }

    public void Ni() {
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.bdo.akG().getId(), true, true, true);
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.AV().a(getPageContext().getPageActivity(), bVar, str, "frs", this.bdo.akG().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.AV().a(bVar, this.forumId, 0L, "FRS", str, this.mPn);
    }

    public void Nj() {
        if (checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10177").aa(ImageViewerConfig.FORUM_ID, this.forumId));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(getPageContext().getPageActivity(), String.valueOf(getForumId()), false, 0)));
        }
    }

    public void Nk() {
        if (checkUpIsLogin() && this.bdd != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(getPageContext().getPageActivity()).createConfig(String.valueOf(getForumId()), this.bdd.getTid(), 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(int i) {
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bdo.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.z) {
                    com.baidu.tbadk.core.data.z zVar = (com.baidu.tbadk.core.data.z) next;
                    if (zVar == this.bcY) {
                        b(zVar, i);
                        this.bcY = null;
                        break;
                    } else if (zVar.getId() != null && zVar.getId().equals(this.bbW)) {
                        b(zVar, i);
                        this.bbW = null;
                        break;
                    }
                }
            }
            this.bdm.Of().a(threadList, this.bdo);
            this.bdm.Of().notifyDataSetChanged();
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
            Nr().av(aVar.bjH, str);
            this.bdC.Qc();
            this.bde = str;
            if (this.bdm != null) {
                this.bdm.setTitle(this.bde);
            }
            stopVoice();
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        private AppDownloadView beu;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.adp.lib.util.i.iE()) {
                FrsActivity.this.showToast(n.j.neterror);
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            com.baidu.adp.widget.ListView.u au = FrsActivity.this.bdm.Of().au(intValue);
            if (au instanceof com.baidu.tbadk.core.data.b) {
                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) au;
                FrsActivity.this.a(bVar, false, FrsActivity.this.mPn);
                DownloadData downloadData = new DownloadData(bVar.US);
                downloadData.setUrl(bVar.UR);
                downloadData.setName(bVar.UN);
                downloadData.setPosition(intValue);
                downloadData.setNotifyId(com.baidu.adp.lib.h.b.g(bVar.UM, 0));
                switch (AppDownloadView.b(downloadData)) {
                    case 1:
                    case 5:
                        com.baidu.tbadk.download.b.Bb().ai(bVar.UR, bVar.US);
                        ((TextView) view).setText(n.j.frs_new_style_download_pause);
                        break;
                    case 3:
                        com.baidu.tieba.frs.utils.a.H(FrsActivity.this.getPageContext().getPageActivity(), bVar.US);
                        break;
                    case 6:
                        if (com.baidu.adp.lib.util.i.iQ() && !com.baidu.adp.lib.util.i.iR()) {
                            FrsActivity.this.a(bVar, intValue, false);
                            break;
                        } else {
                            this.beu.setVisibility(0);
                            ((TextView) view).setText(n.j.downloading2);
                            FrsActivity.this.a(bVar, "btn_download");
                            FrsActivity.this.a((com.baidu.tbadk.core.data.b) au, intValue);
                            break;
                        }
                        break;
                    case 7:
                        FrsActivity.this.a((com.baidu.tbadk.core.data.b) au, intValue);
                        ((TextView) view).setText(n.j.downloading2);
                        break;
                }
                TiebaStatic.eventStat(FrsActivity.this.getPageContext().getPageActivity(), "frs_tb_btc", "");
            }
        }

        public void b(AppDownloadView appDownloadView) {
            this.beu = appDownloadView;
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
        if (this.bdm == null) {
            return null;
        }
        return this.bdm.getListView();
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
    public int vU() {
        if (this.bdm == null) {
            return 0;
        }
        return this.bdm.Oc();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> vV() {
        if (this.agI == null) {
            this.agI = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.agI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            int msgStrangerChat = newsNotifyMessage.getMsgStrangerChat();
            if (this.bdp != null) {
                this.bdp.aw(msgReplyme);
                this.bdp.av(msgAtme);
                this.bdp.ax(msgChat);
                this.bdp.ay(msgStrangerChat);
                this.bdm.a(this.bdp);
                this.bdC.a(this.bdp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        bd Of;
        HashMap<Integer, com.baidu.tbadk.core.data.z> Nx;
        if (this.bdo != null && this.bdm != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (Of = this.bdm.Of()) != null && (Nx = Of.Nx()) != null && Nx.size() > 0) {
            boolean z = false;
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    Iterator<Map.Entry<Integer, com.baidu.tbadk.core.data.z>> it = Nx.entrySet().iterator();
                    boolean z2 = z;
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        Map.Entry<Integer, com.baidu.tbadk.core.data.z> next = it.next();
                        int intValue = next.getKey().intValue();
                        com.baidu.tbadk.core.data.z value = next.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.b) && TextUtils.equals(((com.baidu.tbadk.core.data.b) value).US, downloadData.getId())) {
                            if (!(Of.au(this.bdo.aEm() + intValue) instanceof com.baidu.tbadk.core.data.b)) {
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
            if (!this.JR || z) {
                this.bdm.NW();
            }
        }
    }

    private void Nl() {
        HashMap<Integer, com.baidu.tbadk.core.data.z> Nx;
        if (this.bdm != null && this.bdm.Of() != null && (Nx = this.bdm.Of().Nx()) != null) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.z> entry : Nx.entrySet()) {
                com.baidu.tbadk.core.data.z value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.b)) {
                    arrayList.add((com.baidu.tbadk.core.data.b) value);
                }
            }
            com.baidu.tbadk.download.b.Bb().p(arrayList);
        }
    }

    public void Nm() {
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
                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UF.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UG.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UH.getId()) {
                    if (uVar == null || !(uVar instanceof com.baidu.tbadk.core.data.b)) {
                        return;
                    }
                    FrsActivity.this.a((com.baidu.tbadk.core.data.b) uVar, i, view.findViewById(n.g.frs_app_download), (AppDownloadView) view.findViewById(n.g.frs_app_download_view));
                } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.aa.dFI.getId()) {
                    if (bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UI.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UJ.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.b.UK.getId()) {
                        if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.b)) {
                            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) uVar;
                            if (!bVar.rl()) {
                                if (!bVar.rm()) {
                                    return;
                                }
                                FrsActivity.this.b(bVar);
                                return;
                            }
                            FrsActivity.this.a(bVar, i, view.findViewById(n.g.frs_app_download), (AppDownloadView) view.findViewById(n.g.frs_app_download_view));
                        }
                    } else if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.z)) {
                        com.baidu.tbadk.core.data.z zVar = (com.baidu.tbadk.core.data.z) uVar;
                        if (zVar.getAnchorInfoData() == null || zVar.getAnchorInfoData().getGroup_id() == 0 || FrsActivity.this.checkUpIsLogin()) {
                            if ((zVar.sI() != 1 && zVar.sI() != 2) || FrsActivity.this.checkUpIsLogin()) {
                                com.baidu.tieba.tbadkCore.util.q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.mC(zVar.getId())) {
                                    readThreadHistory.mB(zVar.getId());
                                }
                                boolean z = false;
                                String sx = zVar.sx();
                                if (sx != null && !sx.equals("")) {
                                    z = true;
                                    new Thread(new at(this, sx)).start();
                                }
                                String tid = zVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (zVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.bf vn = com.baidu.tbadk.core.util.bf.vn();
                                    TbPageContext<?> pageContext = FrsActivity.this.getPageContext();
                                    String[] strArr = new String[3];
                                    strArr[0] = tid;
                                    strArr[1] = "";
                                    vn.b(pageContext, strArr);
                                    return;
                                }
                                boolean z2 = false;
                                if (zVar instanceof com.baidu.tbadk.core.data.k) {
                                    z2 = true;
                                    TiebaStatic.log("c10769");
                                }
                                if (zVar.getThreadType() == 33 || (zVar instanceof com.baidu.tbadk.core.data.t)) {
                                    if (!z2) {
                                        String str = zVar.getThreadType() == 33 ? "c10245" : "c10180";
                                        if (FrsActivity.this.bdz.Pt() == 5) {
                                            str = "c10387";
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.av(str).aa(ImageViewerConfig.FORUM_ID, FrsActivity.this.forumId));
                                    }
                                    FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(FrsActivity.this.getPageContext().getPageActivity(), zVar.getTid()).cp("from_frs").bo(18003).rf()));
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    zVar.setId(tid.substring(3));
                                }
                                if (!z2 && FrsActivity.this.bdz.Pt() == 2) {
                                    com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10077");
                                    avVar.r("obj_source", FrsActivity.this.bdz.Pt());
                                    avVar.aa("tid", zVar.getId());
                                    avVar.aa(ImageViewerConfig.FORUM_ID, FrsActivity.this.getForumId());
                                    TiebaStatic.log(avVar);
                                }
                                if (zVar.getAuthor() != null && zVar.getAuthor().getGodInfo() != null) {
                                    com.baidu.tbadk.core.util.av avVar2 = new com.baidu.tbadk.core.util.av("c10625");
                                    avVar2.aa("obj_id", zVar.getAuthor().getUserId());
                                    TiebaStatic.log(avVar2);
                                }
                                FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(FrsActivity.this.getPageContext().getPageActivity()).createFromThreadCfg(zVar, FrsActivity.this.bde, null, 18003, true, false, z)));
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
            a(bVar, true, this.mPn);
            DownloadData downloadData = new DownloadData(bVar.US);
            downloadData.setUrl(bVar.UR);
            downloadData.setName(bVar.UN);
            downloadData.setPosition(i);
            downloadData.setNotifyId(com.baidu.adp.lib.h.b.g(bVar.UM, 0));
            switch (AppDownloadView.b(downloadData)) {
                case 3:
                    com.baidu.tieba.frs.utils.a.H(getPageContext().getPageActivity(), bVar.US);
                    break;
                case 6:
                    if (com.baidu.adp.lib.util.i.iQ() && !com.baidu.adp.lib.util.i.iR()) {
                        a(bVar, i, true);
                        break;
                    } else if (bVar.rm()) {
                        com.baidu.tbadk.core.util.bf.vn().a(getPageContext(), new String[]{bVar.UQ}, true);
                        break;
                    } else if (bVar.rl()) {
                        appDownloadView.setVisibility(0);
                        ((TextView) view).setText(n.j.downloading2);
                        a(bVar, "area_download");
                        a(bVar, i);
                        break;
                    }
                    break;
                case 7:
                    a(bVar, i);
                    ((TextView) view).setText(n.j.downloading2);
                    break;
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", bVar.US);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.b bVar) {
        if (bVar != null) {
            a(bVar, true, this.mPn);
            com.baidu.tbadk.core.util.bf.vn().a(getPageContext(), new String[]{bVar.UQ}, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.bdm.getRootView());
        showLoadingView(this.bdm.getRootView(), true);
        this.bdm.Oe();
        this.bdm.nb();
    }

    public com.baidu.tieba.tbadkCore.p Nn() {
        return this.bdo;
    }

    public boolean No() {
        return this.bdm.No();
    }

    public void Np() {
        FrsActivityStatic.bex = false;
        FrsActivityStatic.bey = false;
        MW();
    }

    public void Nq() {
        this.bdB.Nq();
    }

    public com.baidu.tieba.frs.mc.a Nr() {
        return this.bdz;
    }

    public void a(cg cgVar) {
        this.bdm = cgVar;
    }

    public void hr(String str) {
        this.bde = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFlag(int i) {
        this.bdf = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    public void resetData() {
        this.bcZ = false;
        this.bdl = false;
        this.bdo = null;
        this.bdm.setTitle(this.bde);
        this.bdC.cB(false);
        this.bdC.setIsManager(false);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.jh()) {
            this.bdm.Om();
        } else if (this.bdz.Pt() == 1) {
            Ns();
            loadMore();
        } else if (this.bdz.hasMore()) {
            loadMore();
        }
    }

    public void hs(String str) {
        Ns();
        showToast(str);
    }

    public void C(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.u> a2;
        Ns();
        if (arrayList != null && arrayList.size() != 0 && (a2 = this.bdD.a(false, arrayList, this.bdj)) != null) {
            this.bdo.am(a2);
            this.bdm.a(a2, this.mPn, this.bdo, 0);
        }
    }

    private void Ns() {
        if (this.bdE == 0 && !this.bdD.ai(this.bdo.aDP())) {
            if (this.bdo.getThreadList() == null || this.bdo.getThreadList().size() == 0) {
                this.bdm.Om();
                return;
            } else {
                this.bdm.Ol();
                return;
            }
        }
        this.bdm.Ok();
    }

    public void loadMore() {
        if (this.bdz.Pt() == 1) {
            if (!this.bdD.axY && !this.bdz.isLoading()) {
                if (this.bdD.ai(this.bdo.aDP())) {
                    this.bdm.a(this.bdD.OT(), this.mPn, this.bdo, 0);
                    this.bdD.a(com.baidu.adp.lib.h.b.c(this.forumId, 0L), this.bdo.aDP(), this.bde, this.mPn);
                } else if (this.bdE != 0) {
                    this.bdm.a(this.bdD.OT(), this.mPn, this.bdo, 0);
                    this.mPn++;
                    this.bdz.gi(this.mPn);
                    this.bdD.bks = false;
                    this.bdD.bkt = 0;
                }
            }
        } else if (!this.bdz.Px()) {
            if (this.bdA.Qf() != null) {
                this.bdA.Qf().a(this.bdz.Pt(), this.bdz.Pu(), this.bdz.Pv());
            }
            this.bdz.IR();
        }
    }

    public void showShareDialog() {
        String name;
        if (this.bdo != null && this.bdo.akG() != null) {
            if (this.bdo.akG().getName() == null) {
                showToast(getPageContext().getString(n.j.no_forum_data));
                return;
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String str = "http://tieba.baidu.com/f?kw=" + this.bdo.akG().getName();
            Uri parse = this.bdo.akG().getImage_url() == null ? null : Uri.parse(this.bdo.akG().getImage_url());
            String slogan = this.bdo.akG().getSlogan();
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = String.valueOf(name) + getPageContext().getString(n.j.forum);
            fVar.content = slogan;
            fVar.linkUrl = str;
            fVar.alN = true;
            fVar.extData = getForumId();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true, qo());
            shareDialogConfig.addOutsideTextView(n.j.share_tieba_qunzu, n.f.icon_unite_share_qunzu, new ag(this));
            shareDialogConfig.addOutsideTextView(n.j.forum_friend, n.f.icon_unite_share_baf, new ai(this));
            shareDialogConfig.setCopyLinkListener(new aj(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private SparseArray<String> qo() {
        if (this.bdF == null) {
            this.bdF = new SparseArray<>(7);
            this.bdF.put(2, "frs_wx_timeline");
            this.bdF.put(3, "frs_wx_friend");
            this.bdF.put(4, "frs_qq_zone");
            this.bdF.put(5, "frs_tencent_weibo");
            this.bdF.put(6, "frs_sina_weibo");
        }
        return this.bdF;
    }

    private ShareFromFrsMsgData Nt() {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(this.bdo.akG().getImage_url());
        shareFromFrsMsgData.setName(this.bdo.akG().getName());
        shareFromFrsMsgData.setMemberNum(this.bdo.akG().getMember_num());
        shareFromFrsMsgData.setPostNum(this.bdo.akG().getPost_num());
        shareFromFrsMsgData.setContent(this.bdo.akG().getSlogan());
        return shareFromFrsMsgData;
    }

    private void M(Intent intent) {
        a(Nt(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromFrsMsgData shareFromFrsMsgData, long j, String str, String str2) {
        if (this.bdo != null && this.bdo.akG() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.p pVar = new com.baidu.tieba.frs.view.p(getPageContext().getPageActivity());
            pVar.setData(shareFromFrsMsgData);
            aVar.bI(1);
            aVar.m(pVar);
            aVar.a(n.j.share, new ak(this, pVar, j, str, str2, shareFromFrsMsgData));
            aVar.b(n.j.alert_no_button, new al(this, pVar));
            aVar.aj(true);
            aVar.b(getPageContext()).tf();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                pVar.x(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }

    private void a(ShareFromFrsMsgData shareFromFrsMsgData, int i, String str, long j) {
        if (this.bdo != null && this.bdo.akG() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.p pVar = new com.baidu.tieba.frs.view.p(getPageContext().getPageActivity());
            pVar.setData(shareFromFrsMsgData);
            aVar.bI(1);
            aVar.m(pVar);
            aVar.a(n.j.share, new am(this, pVar, i, str, j, shareFromFrsMsgData));
            aVar.b(n.j.alert_no_button, new an(this, pVar));
            aVar.aj(true);
            aVar.b(getPageContext()).tf();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                pVar.x(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.b bVar, boolean z, int i) {
        a(bVar, z ? "area_click" : "btn_click");
        b(bVar, "click");
        com.baidu.tieba.recapp.report.b.axN().a(com.baidu.tieba.recapp.report.e.a(bVar, "click", i));
    }
}
