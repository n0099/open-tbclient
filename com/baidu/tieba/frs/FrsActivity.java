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
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
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
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.fj;
import com.baidu.tieba.t;
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
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
/* loaded from: classes.dex */
public class FrsActivity extends BaseActivity<FrsActivity> implements BdListView.e, UserIconBox.b, VoiceManager.c, FrsCommonImageLayout.c {
    private com.baidu.adp.lib.f.b<TbImageView> ahx;
    private boolean beg;
    private String beh;
    VoiceManager ben;
    private com.baidu.tieba.tbadkCore.data.e bfA;
    private eb bfG;
    private com.baidu.adp.lib.f.b<TbImageView> bfI;
    private a bfO;
    private com.baidu.tieba.frs.mc.a bfQ;
    private com.baidu.tieba.frs.c.o bfR;
    private com.baidu.tieba.frs.c.a bfS;
    private com.baidu.tieba.frs.c.l bfT;
    private com.baidu.tieba.frs.view.ab bfU;
    private com.baidu.tieba.frs.loadmore.a bfV;
    private com.baidu.tbadk.core.data.ah bfp;
    private boolean bft;
    private com.baidu.tbadk.core.data.ah bfu;
    public static String bfm = "speed_icon_show";
    private static final int bfn = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds90);
    private static final int bfo = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds300);
    public static boolean bfs = false;
    public static volatile long bfJ = 0;
    public static volatile long bfK = 0;
    public static volatile int bfL = 0;
    private static boolean isNeedRefreshOnResume = false;
    private boolean bfq = false;
    public boolean bfr = false;
    public String bfv = null;
    public String aer = null;
    public int bfw = 0;
    private int mPn = 1;
    private boolean bfx = false;
    private boolean bfy = false;
    private String mThreadId = null;
    private String forumId = null;
    private int bfz = 0;
    private boolean bfB = false;
    private boolean bfC = false;
    private cn bfD = null;
    private final com.baidu.tbadk.core.data.ah bfE = null;
    private com.baidu.tieba.tbadkCore.o bfF = new com.baidu.tieba.tbadkCore.o();
    private com.baidu.tbadk.core.data.ah bfH = null;
    private boolean Kg = false;
    public long aWx = -1;
    public long aAK = 0;
    public long createTime = 0;
    public long VB = -1;
    private boolean bfM = false;
    public com.baidu.tbadk.performanceLog.e bfN = null;
    private boolean bfP = true;
    private int bfW = -1;
    private SparseArray<String> bfX = null;
    private ff bfY = new com.baidu.tieba.frs.a(this);
    private fe bfZ = new l(this);
    private CustomMessageListener ahv = new w(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener bcU = new ah(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
    private CustomMessageListener aLV = new aq(this, CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND);
    public final CustomMessageListener bga = new ar(this, CmdConfigCustom.MSG_NEW);
    private CustomMessageListener bgb = new as(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    private boolean bgc = false;
    public final com.baidu.tieba.tbadkCore.r bgd = new at(this);
    private final CustomMessageListener TI = new au(this, CmdConfigCustom.CMD_REFRESH);
    private final CustomMessageListener mMemListener = new com.baidu.tieba.frs.b(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private CustomMessageListener bge = new com.baidu.tieba.frs.c(this, CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS);
    private CustomMessageListener bgf = new d(this, CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE);
    private CustomMessageListener bgg = new e(this, CmdConfigCustom.CMD_AD_KILLER_SUBMIT_SUCCESS);
    private final com.baidu.adp.framework.listener.a bgh = new f(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    private final r.a bgi = new g(this);
    private final BdListView.g Iz = new h(this);
    public final View.OnClickListener bgj = new i(this);
    private final AbsListView.OnScrollListener beo = new j(this);
    private final bh bgk = new k(this);
    private final com.baidu.tieba.tbadkCore.ae beq = new com.baidu.tieba.tbadkCore.ae(getPageContext(), new m(this));
    private CustomMessageListener bgl = new n(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private final View.OnClickListener bgm = new o(this);
    private final View.OnClickListener bgn = new b();
    private final View.OnClickListener bgo = new p(this);
    public final AdapterView.OnItemClickListener bgp = new q(this);
    private final NoNetworkView.a bdG = new r(this);
    private final CustomMessageListener bgq = new s(this, 0);
    private com.baidu.adp.widget.ListView.v bgr = new c();
    private View.OnClickListener bgt = new t(this);
    private View.OnClickListener bgu = new u(this);
    private com.baidu.adp.widget.ListView.w bgv = new v(this);
    private final SlidingMenu.OnOpenedListener bgw = new x(this);
    public final com.baidu.adp.base.g bgx = new y(this);
    public final com.baidu.adp.base.g bgy = new z(this);

    public String getForumId() {
        return this.forumId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.x xVar) {
        if (xVar != null) {
            boolean z = xVar.isLike() == 1;
            if (this.bfD != null && this.bfF != null && this.bfF.aoE() != null && xVar.getFid() != null) {
                if (xVar.getFid().equals(this.bfF.aoE().getId())) {
                    this.bfF.aoE().setLike(xVar.isLike());
                    if (!StringUtils.isNULL(xVar.getLevelName())) {
                        this.bfF.aoE().setLevelName(xVar.getLevelName());
                    }
                    if (xVar.getUserLevel() >= 0) {
                        this.bfF.aoE().setUser_level(xVar.getUserLevel());
                    }
                    if (z) {
                        this.bfS.a(this.bfF, false);
                        this.bfT.cB(true);
                        TbadkCoreApplication.m411getInst().addLikeForum(this.bfv);
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.aKN().I(this.bfv, false);
                    this.bfF.aoE().setLike(0);
                    this.bfS.RP();
                    this.bfT.cB(false);
                    TbadkCoreApplication.m411getInst().delLikeForum(this.bfv);
                    return;
                }
                if (xVar.isLike() == 1) {
                    this.bfF.mA(xVar.getFid());
                    this.bfS.d(this.bfF);
                }
                if (this.bfF.aoE().getBannerListData() != null) {
                    this.bfF.aoE().getBannerListData().setFeedForumLiked(xVar.getFid(), xVar.isLike());
                }
                this.bfD.PW();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    public void a(ErrorData errorData) {
        this.bfD.cs(false);
        this.bfD.ct(false);
        this.bfD.cu(false);
        this.bfD.PW();
        hideLoadingView(this.bfD.getRootView());
        this.bfD.Qd();
        if (!this.bfC) {
            d.a Ru = Po().Ru();
            if (!this.bfq) {
                if (Ru != null) {
                    if (this.bfQ.Rv() != 0) {
                        this.bfQ.RC();
                        this.bfD.PW();
                    } else if (Ru.dUo) {
                        if (340001 == Ru.errorCode) {
                            showNetRefreshViewNoClick(this.bfD.getRootView(), getPageContext().getResources().getString(t.j.net_error_text, Ru.errorMsg, Integer.valueOf(Ru.errorCode)), true);
                        } else {
                            showNetRefreshView(this.bfD.getRootView(), getPageContext().getResources().getString(t.j.net_error_text, Ru.errorMsg, Integer.valueOf(Ru.errorCode)), true);
                        }
                    } else if (340001 == Ru.errorCode) {
                        showNetRefreshViewNoClick(this.bfD.getRootView(), Ru.errorMsg, true);
                    } else {
                        showNetRefreshView(this.bfD.getRootView(), Ru.errorMsg, true);
                    }
                    this.bfD.gx(8);
                }
            } else if (Ru != null && Ru.dUo) {
                this.bfD.gx(0);
                showToast(getPageContext().getResources().getString(t.j.net_error_text, Ru.errorMsg, Integer.valueOf(Ru.errorCode)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.m mVar) {
        boolean z;
        if (!this.bgc && mVar != null) {
            try {
                this.bfF.d(mVar);
                if (this.bfF.aoK() == 1) {
                    this.bfD.Qi().setFromCDN(true);
                } else {
                    this.bfD.Qi().setFromCDN(false);
                }
                this.bfW = this.bfF.getPage().sv();
                this.bfD.a(this.bfF.aoE(), this.bfF.getUserData(), 0);
                if (this.bfF.aLa() == null) {
                    z = false;
                } else {
                    z = this.bfF.aLa().size() != 0;
                }
                this.bfS.a(this.bfF.aKP().aLi() == 1, this.bfF.getUserData().getIsMem(), this.bfF.aoE().isLike(), z);
                this.bfD.KZ();
                this.bfv = this.bfF.aoE().getName();
                this.forumId = this.bfF.aoE().getId();
                this.bfD.setTitle(this.bfv);
                OZ();
                this.bfF.aLs();
                this.bfF.aLx();
                if (!Po().Rt() && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.bfF.aLw();
                    this.bfF.aLv();
                    this.bfF.aLu();
                }
                if (!this.bfF.aLA()) {
                    this.bfF.aLz();
                }
                if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                    this.bfF.aQ(getPageContext().getPageActivity());
                    this.bfF.W(getPageContext().getPageActivity(), this.forumId);
                }
                this.bfF.aLr();
                com.baidu.tbadk.core.data.aj top_notice_data = this.bfF.aoE().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.getTitle() != null) {
                    com.baidu.tbadk.core.data.ah ahVar = new com.baidu.tbadk.core.data.ah();
                    ahVar.setTitle(top_notice_data.getTitle());
                    ahVar.bU(2);
                    ahVar.cw(top_notice_data.tW());
                    ahVar.parser_title();
                    this.bfF.j(ahVar);
                }
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bfF.getThreadList();
                if (threadList != null) {
                    ArrayList<com.baidu.adp.widget.ListView.u> a2 = this.bfV.a(true, threadList);
                    if (a2 != null) {
                        this.bfF.an(a2);
                    }
                    this.bfD.a(threadList, this.mPn, this.bfF, this.bfF.getPage().sv());
                    Pi();
                    this.bfS.gS(this.mPn);
                    this.bfS.d(this.bfF);
                    this.bfD.PZ();
                }
                this.bfz = this.bfF.RA();
                if (this.bfA != null) {
                    this.bfA.oe(this.bfz);
                }
                this.bfS.cz(this.bfF.aKR());
                hideLoadingView(this.bfD.getRootView());
                this.bfD.gx(0);
                this.bfD.Qd();
                this.bfq = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        bfm = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (intent != null) {
            this.aWx = intent.getLongExtra("TibaStatic.StartTime", -1L);
            if (intent.getData() != null) {
                Uri data = intent.getData();
                this.bfv = data.getQueryParameter("name");
                this.aer = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.bfv)) {
                    intent.putExtra("name", this.bfv);
                }
                if (!StringUtils.isNull(this.aer)) {
                    intent.putExtra("from", this.aer);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.bfv)) {
                this.bfv = L(intent);
                if (!StringUtils.isNull(this.bfv)) {
                    intent.putExtra("name", this.bfv);
                }
            }
        } else {
            this.aWx = System.currentTimeMillis();
        }
        if (this.aWx != -1) {
            this.VB = this.aWx;
        } else {
            this.VB = System.currentTimeMillis();
        }
        if (!cp(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.VB;
            return;
        }
        super.onCreate(bundle);
        this.bfQ = new com.baidu.tieba.frs.mc.a(this);
        this.bfQ.a(this.bfY);
        this.bfQ.init();
        if (getIntent() != null) {
            this.bfQ.c(getIntent().getExtras());
        } else if (bundle != null) {
            this.bfQ.c(bundle);
        } else {
            this.bfQ.c((Bundle) null);
        }
        Po().oR();
        setContentView(t.h.frs_activity);
        this.bfR = new com.baidu.tieba.frs.c.o(this);
        this.bfT = new com.baidu.tieba.frs.c.l(this);
        this.bfS = new com.baidu.tieba.frs.c.a(this, this.bfR);
        this.bfR.oQ();
        if (getIntent() != null) {
            this.bfS.e(getIntent().getExtras());
        } else if (bundle != null) {
            this.bfS.e(bundle);
        } else {
            this.bfS.e((Bundle) null);
        }
        this.ben = getVoiceManager();
        this.ben.onCreate(getPageContext());
        qD();
        initData(bundle);
        this.beq.setUniqueId(getUniqueId());
        this.beq.registerListener();
        addGlobalLayoutListener();
        OR();
        registerListener(this.TI);
        registerListener(this.mMemListener);
        registerListener(this.bga);
        registerListener(this.ahv);
        registerListener(this.aLV);
        registerListener(this.bcU);
        registerListener(this.bgb);
        registerListener(this.bge);
        registerListener(this.bgf);
        registerListener(this.bgl);
        registerListener(this.bgg);
        this.bgh.eW().setSelfListener(true);
        this.bgh.eV().setSelfListener(true);
        this.bgh.setTag(getUniqueId());
        registerListener(this.bgh);
        this.bfV = new com.baidu.tieba.frs.loadmore.a(this);
        this.bfV.registerListener();
        this.bfA = new com.baidu.tieba.tbadkCore.data.e("frs", com.baidu.tieba.tbadkCore.data.e.dWw);
        this.createTime = System.currentTimeMillis() - this.aWx;
        if (this.bfD != null) {
            showLoadingView(this.bfD.getRootView(), true);
            this.bfD.Qe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
        } else if (this.bfF != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null && this.bfD != null) {
            com.baidu.tbadk.core.data.s sVar = new com.baidu.tbadk.core.data.s();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(getMyPostResIdl.data.thread_info.author);
            a(metaData, getMyPostResIdl.data.user_info);
            String userId = metaData.getUserId();
            if (userId != null && !userId.equals("0")) {
                hashMap.put(metaData.getUserId(), metaData);
            }
            sVar.setUserMap(hashMap);
            sVar.a(getMyPostResIdl.data.thread_info);
            this.bfQ.a(sVar);
            ArrayList<com.baidu.adp.widget.ListView.u> a2 = this.bfV.a(true, this.bfF.getThreadList());
            if (a2 != null) {
                this.bfF.an(a2);
                this.bfF.aLr();
                this.bfD.a(a2, this.mPn, this.bfF, this.bfW);
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
            metaData.getGodUserData().parserProtobuf(user_Info.god_data);
            metaData.setFansNum(user_Info.fans_num.intValue());
        }
    }

    private void OR() {
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
        this.ben = getVoiceManager();
        this.ben.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        OT();
        if (bundle != null) {
            this.bfv = bundle.getString("name");
            this.aer = bundle.getString("from");
            this.bfw = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bfv = intent.getStringExtra("name");
                this.aer = intent.getStringExtra("from");
                this.bfw = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.aer) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aer)) {
            setSwipeBackEnabled(false);
        }
        this.bfG = new eb(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            OS();
            OU();
        }
        this.bfS.e(bundle);
    }

    private String L(Intent intent) {
        int indexOf;
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (!StringUtils.isNull(dataString) && dataString.startsWith("tbfrs://")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10320").r("obj_locate", 2).r("obj_type", 1));
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (StringUtils.isNull(decode) || (indexOf = decode.indexOf("kw=")) < 0 || (length = indexOf + "kw=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public void OS() {
        if (this.bfG != null && this.bfD != null) {
            if (FrsActivityStatic.bgR || FrsActivityStatic.bgS) {
                this.bfG.ay(com.baidu.tbadk.coreExtra.messageCenter.a.yN().getMsgReplyme());
                this.bfG.ax(com.baidu.tbadk.coreExtra.messageCenter.a.yN().getMsgAtme());
                this.bfG.aA(com.baidu.tbadk.coreExtra.messageCenter.a.yN().yU());
                this.bfG.az(com.baidu.tbadk.coreExtra.messageCenter.a.yN().getMsgChat());
                this.bfD.a(this.bfG);
                this.bfT.a(this.bfG);
            }
        }
    }

    private void OT() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bgq);
    }

    private void OU() {
        registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.bgq);
    }

    private boolean cp(boolean z) {
        if (z && com.baidu.tieba.frs.utils.a.O(getPageContext().getPageActivity(), getClass().getName())) {
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
        if (this.bfF != null && this.bfF.aoE() != null) {
            ex.QB().aB(com.baidu.adp.lib.h.b.c(this.bfF.aoE().getId(), 0L));
        }
        if (this.bfD != null) {
            this.bfD.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.bfN != null) {
                this.bfN.onDestroy();
            }
            this.bfD.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.bfQ.onActivityDestroy();
        this.bfR.onActivityDestroy();
        this.bfS.onActivityDestroy();
        this.ben = getVoiceManager();
        this.ben.onDestory(getPageContext());
        if (this.bfO != null) {
            this.bfO.cancel(true);
            this.bfO = null;
        }
        if (this.bfQ != null) {
            this.bfQ.Op();
        }
        if (this.bfT != null) {
            this.bfT.destroy();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.bfv);
        bundle.putString("from", this.aer);
        this.bfQ.onSaveInstanceState(bundle);
        this.ben = getVoiceManager();
        if (this.ben != null) {
            this.ben.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.ah mC;
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    gm(0);
                    return;
                case 11002:
                    this.bfS.oN();
                    return;
                case 11011:
                    d(this.bfE);
                    return;
                case 11012:
                    e(this.bfH);
                    return;
                case 11014:
                    this.bfS.Sa();
                    return;
                case 11016:
                    this.bfD.PY();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    this.bfS.Pn();
                    return;
                case 13003:
                    if (intent != null && !Po().Rt()) {
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
                    this.bfD.Qi().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (mC = this.bfF.mC(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            mC.bV(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            mC.parser_title();
                            ci(6);
                            return;
                        } else if (intExtra == 0) {
                            this.bfF.k(mC);
                            this.bfD.PZ();
                            if (com.baidu.tieba.tbadkCore.c.aKN() != null) {
                                com.baidu.tieba.tbadkCore.c.aKN().I(this.bfv, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    Pf();
                    return;
                case 23003:
                    if (intent != null && this.bfF != null) {
                        a(Pr(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    M(intent);
                    return;
                case 23013:
                    Pg();
                    return;
                case 23019:
                    Ph();
                    return;
                case 24002:
                    if (intent != null) {
                        int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                        int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                        int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                        int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                        if (intExtra2 == com.baidu.adp.lib.h.b.g(this.forumId, 0)) {
                            this.bfS.q(intExtra3, intExtra4, intExtra5);
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
        int Rv = this.bfQ.Rv();
        if (eo.Qz().gz(1) == null) {
            Rv = 0;
        }
        if (Rv == 0 && postWriteCallBackData != null) {
            long c2 = com.baidu.adp.lib.h.b.c(postWriteCallBackData.getPostId(), 0L);
            long c3 = com.baidu.adp.lib.h.b.c(postWriteCallBackData.getThreadId(), 0L);
            long c4 = com.baidu.adp.lib.h.b.c(this.forumId, 0L);
            if (c2 != 0 && c3 != 0 && c4 != 0) {
                com.baidu.adp.lib.h.h.hr().postDelayed(new aa(this, c3, c2, c4), 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bfT.Sh();
        this.bfS.a(this.bfZ);
        this.beg = true;
        this.bfP = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.bfD.ns();
        } else if (bfs) {
            bfs = false;
            this.bfD.ns();
        } else {
            this.ben = getVoiceManager();
            this.ben.onResume(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            this.bfD.Ql();
            this.bfT.Si().setSlidingEnabled(true);
            refresh();
            return;
        }
        this.bfD.Qk();
        this.bfT.Si().setSlidingEnabled(false);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.bfv = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.aer = intent.getStringExtra("from");
            }
            this.bfy = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.bfy) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    OV();
                } else {
                    OW();
                }
            }
        }
    }

    private void OV() {
        this.bfD.ns();
        this.bfT.Si().showContent(false);
    }

    private void OW() {
        this.bfD.ns();
        this.bfT.Si().showContent(false);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aer)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            } else {
                com.baidu.tbadk.core.c.b.d(getPageContext().getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aer)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        } else {
            com.baidu.tbadk.core.c.b.d(getPageContext().getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.aer)) {
            finish();
        }
    }

    private void qD() {
        this.bfD.Qi().l(this.bgm);
        this.bfD.Qi().m(this.bgn);
        this.bfD.Qi().n(this.bgo);
        if (this.bfw == 0) {
            this.bfD.setTitle(this.bfv);
        } else {
            this.bfD.setTitle("");
            this.bfw = 1;
        }
        this.bfT.Si();
        this.bfS.t(this.bfD.KM());
        this.bfD.a(this.bgr);
        this.bfD.a(this.bgv);
        this.bfD.o(this.bgt);
        this.bfD.q(this.bgu);
        this.bfD.setOnScrollListener(this.beo);
        this.bfD.a(this.Iz);
        this.bfD.a(this.bgi);
        this.bfD.f(this.bdG);
        this.bfT.Si().setOnOpenedListener(this.bgw);
        this.bfD.Qi().a(this.bgk);
        if (!this.mIsLogin) {
            this.bfD.Qk();
            this.bfT.Si().setSlidingEnabled(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.bfD.onChangeSkinType(i);
        this.bfT.a(getPageContext(), i);
        this.bfS.a(getPageContext(), i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> OC() {
        if (this.bfI == null) {
            this.bfI = FrsCommonImageLayout.l(getPageContext().getPageActivity(), 12);
        }
        return this.bfI;
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
        /* renamed from: m */
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(com.baidu.tieba.frs.utils.a.P(FrsActivity.this.getPageContext().getPageActivity(), this.name));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                FrsActivity.this.showToast(t.j.shortcut_has_add);
            } else {
                FrsActivity.this.hq(this.name);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hq(String str) {
        Intent Q;
        if (str != null && (Q = com.baidu.tieba.frs.utils.a.Q(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(t.j.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", Q);
            BarImageView RZ = this.bfS.RZ();
            if (RZ != null && RZ.getBdImage() != null && RZ.getBdImage().mS() != null) {
                Bitmap mS = RZ.getBdImage().mS();
                Float valueOf = Float.valueOf(getResources().getDisplayMetrics().density);
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.d.iH().a(com.baidu.adp.lib.util.d.iH().resizeBitmap(mS, valueOf.intValue() * 48), valueOf.intValue() * 6));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), t.f.icon));
            }
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gm(int i) {
        if (!this.mIsLogin) {
            if (this.bfF != null && this.bfF.so() != null) {
                this.bfF.so().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.bfF != null) {
            if (i == 0) {
                if (!this.bft) {
                    gn(0);
                    return;
                }
                TiebaStatic.log("c10152");
                gn(4);
                return;
            }
            this.bfD.PY();
        }
    }

    private void gn(int i) {
        int i2 = 0;
        if (this.bfF.getUserData() != null) {
            i2 = this.bfF.getUserData().getIsMem();
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), i, this.bfF.aoE().getId(), this.bfv, null, null, 0, this.bfF.so(), 13003, false, false, null, false, false, null, null, this.bfF.aoE().getPrefixData(), i2);
        if (eo.Qz().gz(1) != null) {
            writeActivityConfig.setCategroyId(this.bfQ.Rv());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.ah ahVar) {
        boolean tM = ahVar == null ? true : ahVar.tM();
        this.bfD.a(new ab(this, ahVar));
        this.bfD.a(ahVar, tM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OX() {
        if (!this.mIsLogin) {
            skipToRegisterActivity();
            return;
        }
        boolean z = false;
        String str = "";
        if (this.bfF.aoE() != null && this.bfF.aoE().getAnchorPower() != null) {
            z = this.bfF.aoE().getCanAddPhotoLivePost();
            str = this.bfF.aoE().getAnchorPower().can_add_live_post_msg;
        }
        if (z) {
            this.bft = true;
            gn(4);
            com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), true);
            return;
        }
        hr(str);
    }

    private void hr(String str) {
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
                aVar.cE(optString);
                aVar.a(t.j.view, new ac(this, optString2));
                aVar.b(t.j.cancel, new ad(this));
                aVar.b(getPageContext()).uj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OY() {
        if (com.baidu.tbadk.core.util.bi.ah(getPageContext().getPageActivity())) {
            AntiData so = this.bfF.so();
            if (so != null) {
                if (AntiHelper.f(so) || AntiHelper.g(so) || AntiHelper.h(so)) {
                    so.setBlock_forum_name(this.bfv);
                    so.setBlock_forum_id(this.bfF.aoE().getId());
                    so.setUser_name(this.bfF.getUserData().getUserName());
                    so.setUser_id(this.bfF.getUserData().getUserId());
                    if (AntiHelper.a(getPageContext().getPageActivity(), so, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(so.getPollMessage())) {
                    com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), so.getPollMessage());
                    return;
                }
            }
            PostPrefixData postPrefixData = null;
            if (this.bfF.aoE() != null) {
                postPrefixData = this.bfF.aoE().getPrefixData();
            }
            int i = 0;
            if (this.bfF.getUserData() != null) {
                i = this.bfF.getUserData().getIsMem();
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVoteActivityConfig(getPageContext().getPageActivity(), this.bfF.aoE().getId(), this.bfv, so, 13003, postPrefixData, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.ah ahVar) {
        boolean tM = ahVar == null ? true : ahVar.tM();
        if (this.mThreadId != null) {
            if (!tM) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(ahVar, this.bfv, null, 18003, true, true, this.bfB)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(ahVar, this.bfv, null, 18003, false, false, this.bfB)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tbadk.core.data.ah ahVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(ahVar, this.bfv, null, 18003, false, false, this.bfB)));
        }
    }

    public void refresh() {
        ci(3);
    }

    public void ci(int i) {
        this.bgc = false;
        this.bfq = false;
        this.bfC = false;
        Oy();
        if (this.bfR != null && this.bfR.Sj() != null) {
            this.bfR.Sj().a(this.bfQ.Rx(), this.bfQ.Ry(), this.bfQ.Rz());
        }
        Po().j(i, true);
    }

    private void OZ() {
        switch (this.bfw) {
            case 1:
                com.baidu.adp.lib.h.k.hs().c(new ae(this));
                break;
        }
        this.bfw = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pa() {
        Oy();
        try {
            if (this.bfF != null) {
                this.bfD.KZ();
                this.bfv = this.bfF.aoE().getName();
                this.forumId = this.bfF.aoE().getId();
                this.bfD.setTitle(this.bfv);
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.bfF.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.bfF.getUserData().getBimg_end_time());
                OZ();
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bfF.getThreadList();
                if (threadList != null) {
                    this.bfD.a(threadList, this.mPn, this.bfF, this.bfF.getPage().sv());
                    Pi();
                    this.bfS.gS(this.mPn);
                    this.bfS.d(this.bfF);
                    this.bfD.PZ();
                    if (this.bfF.aoK() == 1) {
                        this.bfD.Qi().setFromCDN(true);
                    } else {
                        this.bfD.Qi().setFromCDN(false);
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
        this.beg = false;
        this.bfP = false;
        this.bfD.onPause();
        this.ben = getVoiceManager();
        this.ben.onPause(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Object c2;
        super.onStop();
        if (this.bfF != null && this.bfF.aoE() != null) {
            com.baidu.tbadk.distribute.a.Cl().b(getPageContext().getPageActivity(), "frs", this.bfF.aoE().getId(), 0L);
        }
        this.ben = getVoiceManager();
        if (this.ben != null) {
            this.ben.onStop(getPageContext());
        }
        BdListView listView = getListView();
        if (listView != null && (c2 = com.baidu.adp.lib.a.a.a.c(listView, "mRecycler")) != null) {
            com.baidu.adp.lib.a.a.a.a("clear", c2, c2.getClass());
        }
        this.bfS.onActivityStop();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.bfx) {
            if (i == 4) {
                if (this.bfT.onBackPressed()) {
                    return true;
                }
                closeActivity();
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void a(com.baidu.tbadk.core.data.c cVar, int i, boolean z) {
        String trim;
        if (cVar != null) {
            if (!com.baidu.adp.lib.util.i.iN()) {
                showToast(t.j.neterror);
            } else if (cVar.rO()) {
                com.baidu.tbadk.core.util.be.wt().a(getPageContext(), new String[]{cVar.Uw}, true);
            } else if (cVar.rN()) {
                if (com.baidu.adp.lib.util.i.iZ() && !com.baidu.adp.lib.util.i.ja()) {
                    trim = getPageContext().getString(t.j.frs_network_tips);
                } else if (TextUtils.isEmpty(cVar.UI.UT.trim())) {
                    trim = getPageContext().getString(t.j.confirm_download_app);
                } else {
                    trim = cVar.UI.UT.trim();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cE(trim);
                aVar.a(t.j.alert_yes_button, new af(this, cVar, z, i));
                aVar.b(t.j.alert_no_button, new ag(this));
                aVar.b(getPageContext()).uj();
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar != null) {
            if (!cVar.rM()) {
                com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), t.j.pb_app_error);
            } else if (com.baidu.tieba.tbadkCore.ag.a(getPageContext().getPageActivity(), cVar, i)) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", cVar.Uy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pb() {
        boolean z;
        if (this.bfD != null) {
            if (this.bfF != null && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) && this.bfF.aoE() != null && this.bfF.aoE().getAnchorPower() != null && this.bfF.aoE().getAnchorPower().can_add_live_post.intValue() != 2) {
                z = true;
            } else {
                z = false;
            }
            boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
            this.bfU = new com.baidu.tieba.frs.view.ab(getPageContext(), this.bfD.getRootView(), new ai(this));
            this.bfU.h(z, showXiaoyingTool);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pc() {
        TiebaStatic.log("c10798");
        if (com.baidu.tbadk.core.util.bi.ah(getPageContext().getPageActivity())) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(getPageContext(), getResources().getString(t.j.plugin_video_not_active), getResources().getString(t.j.setup));
                    return;
                }
                boolean z = false;
                if (this.bfF != null && this.bfF.getUserData() != null && this.bfF.getUserData().getGodUserData() != null && (this.bfF.getUserData().getGodUserData().getType() == 2 || this.bfF.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (this.bfF != null && this.bfF.aoE() != null) {
                    XiaoyingUtil.startXiaoying(getPageContext().getPageActivity(), z, this.bfF.aoE().getId(), this.bfF.aoE().getName());
                    return;
                }
                return;
            }
            XiaoyingUtil.showGoPluginDetailDialog(getPageContext(), getResources().getString(t.j.plugin_video_install_tips), getResources().getString(t.j.plugin_go_install));
        }
    }

    public boolean Pd() {
        if (this.bfU == null) {
            return false;
        }
        return this.bfU.isShowing();
    }

    public void Pe() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
        this.bfO = new a(this.bfv);
        this.bfO.setSelfExecute(true);
        this.bfO.execute(new String[0]);
    }

    public void Pf() {
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.bfF.aoE().getId(), true, true, true);
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.Cl().a(getPageContext().getPageActivity(), cVar, str, "frs", this.bfF.aoE().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.Cl().a(cVar, this.forumId, 0L, "FRS", str, this.mPn);
    }

    public void Pg() {
        if (checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10177").aa(ImageViewerConfig.FORUM_ID, this.forumId));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(getPageContext().getPageActivity(), String.valueOf(getForumId()), false, 0)));
        }
    }

    public void Ph() {
        if (checkUpIsLogin() && this.bfu != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(getPageContext().getPageActivity()).createConfig(String.valueOf(getForumId()), this.bfu.getTid(), 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gl(int i) {
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bfF.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.ah) {
                    com.baidu.tbadk.core.data.ah ahVar = (com.baidu.tbadk.core.data.ah) next;
                    if (ahVar == this.bfp) {
                        b(ahVar, i);
                        this.bfp = null;
                        break;
                    } else if (ahVar.getId() != null && ahVar.getId().equals(this.beh)) {
                        b(ahVar, i);
                        this.beh = null;
                        break;
                    }
                }
            }
            this.bfD.Qi().a(threadList, this.bfF);
            this.bfD.Qi().notifyDataSetChanged();
        }
    }

    private void b(com.baidu.tbadk.core.data.ah ahVar, int i) {
        if (i == 1) {
            PraiseData praise = ahVar.getPraise();
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
                    ahVar.setPraise(praiseData);
                    return;
                }
                ahVar.getPraise().getUser().add(0, metaData);
                ahVar.getPraise().setNum(ahVar.getPraise().getNum() + 1);
                ahVar.getPraise().setIsLike(i);
            }
        } else if (ahVar.getPraise() != null) {
            ahVar.getPraise().setIsLike(i);
            ahVar.getPraise().setNum(ahVar.getPraise().getNum() - 1);
            ArrayList<MetaData> user = ahVar.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        ahVar.getPraise().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.tbadk.core.data.ah ahVar;
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.bfF.getThreadList();
        if (threadList != null && updateAttentionMessage != null && updateAttentionMessage.getData() != null) {
            MetaData metaData = new MetaData();
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            MetaData metaData2 = metaData;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.u next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.ah) && (ahVar = (com.baidu.tbadk.core.data.ah) next) != null && ahVar.getAuthor() != null && ahVar.getAuthor().getUserId() != null && ahVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid) && !ahVar.getAuthor().equals(metaData2)) {
                    a(ahVar, updateAttentionMessage);
                    metaData2 = ahVar.getAuthor();
                }
            }
            this.bfD.Qi().a(threadList, this.bfF);
            this.bfD.Qi().notifyDataSetChanged();
        }
    }

    private void a(com.baidu.tbadk.core.data.ah ahVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        int i2;
        if (ahVar != null && ahVar.getAuthor() != null && ahVar.getAuthor().getUserId() != null && ahVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = ahVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
                i2 = 1;
            } else {
                i = fansNum - 1;
                i2 = 0;
            }
            ahVar.getAuthor().setFansNum(i);
            if (ahVar.getAuthor().getGodUserData() != null) {
                ahVar.getAuthor().getGodUserData().setFollowed(i2);
                ahVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }

    public void a(fj.a aVar, String str) {
        if (str != null) {
            Po().av(aVar.bmD, str);
            this.bfT.Sg();
            this.bfv = str;
            if (this.bfD != null) {
                this.bfD.setTitle(this.bfv);
            }
            Oy();
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        private AppDownloadView bgO;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!com.baidu.adp.lib.util.i.iN()) {
                FrsActivity.this.showToast(t.j.neterror);
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            com.baidu.adp.widget.ListView.u aG = FrsActivity.this.bfD.Qi().aG(intValue);
            if (aG instanceof com.baidu.tbadk.core.data.c) {
                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aG;
                FrsActivity.this.a(cVar, false, FrsActivity.this.mPn);
                DownloadData downloadData = new DownloadData(cVar.Uy);
                downloadData.setUrl(cVar.Ux);
                downloadData.setName(cVar.Uu);
                downloadData.setPosition(intValue);
                downloadData.setNotifyId(com.baidu.adp.lib.h.b.g(cVar.Ut, 0));
                switch (AppDownloadView.b(downloadData)) {
                    case 1:
                    case 5:
                        com.baidu.tbadk.download.b.Cr().ai(cVar.Ux, cVar.Uy);
                        ((TextView) view).setText(t.j.frs_new_style_download_pause);
                        break;
                    case 3:
                        com.baidu.tieba.frs.utils.a.N(FrsActivity.this.getPageContext().getPageActivity(), cVar.Uy);
                        break;
                    case 6:
                        if (com.baidu.adp.lib.util.i.iZ() && !com.baidu.adp.lib.util.i.ja()) {
                            FrsActivity.this.a(cVar, intValue, false);
                            break;
                        } else {
                            this.bgO.setVisibility(0);
                            ((TextView) view).setText(t.j.downloading2);
                            FrsActivity.this.a(cVar, "btn_download");
                            FrsActivity.this.b((com.baidu.tbadk.core.data.c) aG, intValue);
                            break;
                        }
                        break;
                    case 7:
                        FrsActivity.this.b((com.baidu.tbadk.core.data.c) aG, intValue);
                        ((TextView) view).setText(t.j.downloading2);
                        break;
                }
                TiebaStatic.eventStat(FrsActivity.this.getPageContext().getPageActivity(), "frs_tb_btc", "");
            }
        }

        public void b(AppDownloadView appDownloadView) {
            this.bgO = appDownloadView;
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.ben == null) {
            this.ben = VoiceManager.instance();
        }
        return this.ben;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: KM */
    public BdListView getListView() {
        if (this.bfD == null) {
            return null;
        }
        return this.bfD.KM();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void Oy() {
        this.ben = getVoiceManager();
        this.ben.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int xi() {
        if (this.bfD == null) {
            return 0;
        }
        return this.bfD.Qc();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> xj() {
        if (this.ahx == null) {
            this.ahx = UserIconBox.e(getPageContext().getPageActivity(), 8);
        }
        return this.ahx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            int msgStrangerChat = newsNotifyMessage.getMsgStrangerChat();
            if (this.bfG != null) {
                this.bfG.ay(msgReplyme);
                this.bfG.ax(msgAtme);
                this.bfG.az(msgChat);
                this.bfG.aA(msgStrangerChat);
                this.bfD.a(this.bfG);
                this.bfT.a(this.bfG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        bf Qi;
        HashMap<Integer, com.baidu.tbadk.core.data.ah> Px;
        if (this.bfF != null && this.bfD != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (Qi = this.bfD.Qi()) != null && (Px = Qi.Px()) != null && Px.size() > 0) {
            boolean z = false;
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    Iterator<Map.Entry<Integer, com.baidu.tbadk.core.data.ah>> it = Px.entrySet().iterator();
                    boolean z2 = z;
                    while (true) {
                        if (!it.hasNext()) {
                            z = z2;
                            break;
                        }
                        Map.Entry<Integer, com.baidu.tbadk.core.data.ah> next = it.next();
                        int intValue = next.getKey().intValue();
                        com.baidu.tbadk.core.data.ah value = next.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.c) && TextUtils.equals(((com.baidu.tbadk.core.data.c) value).Uy, downloadData.getId())) {
                            if (!(Qi.aG(this.bfF.aLq() + intValue) instanceof com.baidu.tbadk.core.data.c)) {
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
            if (!this.Kg || z) {
                this.bfD.PW();
            }
        }
    }

    private void Pi() {
        HashMap<Integer, com.baidu.tbadk.core.data.ah> Px;
        if (this.bfD != null && this.bfD.Qi() != null && (Px = this.bfD.Qi().Px()) != null) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.ah> entry : Px.entrySet()) {
                com.baidu.tbadk.core.data.ah value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.c)) {
                    arrayList.add((com.baidu.tbadk.core.data.c) value);
                }
            }
            com.baidu.tbadk.download.b.Cr().q(arrayList);
        }
    }

    public void Pj() {
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v31, resolved type: com.baidu.tieba.frs.FrsActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.v
        public void a(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Um.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Un.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Uo.getId()) {
                    if (uVar == null || !(uVar instanceof com.baidu.tbadk.core.data.c)) {
                        return;
                    }
                    FrsActivity.this.a((com.baidu.tbadk.core.data.c) uVar, i, view.findViewById(t.g.frs_app_download), (AppDownloadView) view.findViewById(t.g.frs_app_download_view));
                } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.z.dVD.getId()) {
                    if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Up.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Uq.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Ur.getId()) {
                        if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.c)) {
                            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) uVar;
                            if (!cVar.rN()) {
                                if (!cVar.rO()) {
                                    return;
                                }
                                FrsActivity.this.b(cVar);
                                return;
                            }
                            FrsActivity.this.a(cVar, i, view.findViewById(t.g.frs_app_download), (AppDownloadView) view.findViewById(t.g.frs_app_download_view));
                        }
                    } else if (uVar != null && (uVar instanceof com.baidu.tbadk.core.data.ah)) {
                        com.baidu.tbadk.core.data.ah ahVar = (com.baidu.tbadk.core.data.ah) uVar;
                        if (ahVar.getAnchorInfoData() == null || ahVar.getAnchorInfoData().getGroup_id() == 0 || FrsActivity.this.checkUpIsLogin()) {
                            if ((ahVar.tE() != 1 && ahVar.tE() != 2) || FrsActivity.this.checkUpIsLogin()) {
                                if (ahVar.tv() != null) {
                                    if (FrsActivity.this.checkUpIsLogin()) {
                                        String rQ = ahVar.tv().rQ();
                                        if (!StringUtils.isNull(rQ) && com.baidu.adp.lib.util.k.jq()) {
                                            com.baidu.tbadk.browser.f.C(FrsActivity.this.getActivity(), rQ);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                com.baidu.tieba.tbadkCore.util.r readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
                                if (readThreadHistory != null && !readThreadHistory.mU(ahVar.getId())) {
                                    readThreadHistory.mT(ahVar.getId());
                                }
                                boolean z = false;
                                String tq = ahVar.tq();
                                if (tq != null && !tq.equals("")) {
                                    z = true;
                                    new Thread(new av(this, tq)).start();
                                }
                                boolean z2 = z;
                                String tid = ahVar.getTid();
                                if (tid == null) {
                                    tid = "";
                                }
                                if (ahVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                                    com.baidu.tbadk.core.util.be wt = com.baidu.tbadk.core.util.be.wt();
                                    TbPageContext<?> pageContext = FrsActivity.this.getPageContext();
                                    String[] strArr = new String[3];
                                    strArr[0] = tid;
                                    strArr[1] = "";
                                    wt.c(pageContext, strArr);
                                    return;
                                }
                                boolean z3 = false;
                                if (ahVar instanceof com.baidu.tbadk.core.data.n) {
                                    z3 = true;
                                    TiebaStatic.log("c10769");
                                }
                                if (ahVar.getThreadType() == 33 || (ahVar instanceof com.baidu.tbadk.core.data.x)) {
                                    if (!z3) {
                                        String str = ahVar.getThreadType() == 33 ? "c10245" : "c10180";
                                        if (FrsActivity.this.bfQ.Rx() == 5) {
                                            str = "c10387";
                                        }
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.au(str).aa(ImageViewerConfig.FORUM_ID, FrsActivity.this.forumId));
                                    }
                                    FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(FrsActivity.this.getPageContext().getPageActivity(), ahVar.getTid()).co("from_frs").bD(18003).rC()));
                                    return;
                                }
                                if (tid.startsWith("pb:")) {
                                    ahVar.setId(tid.substring(3));
                                }
                                if (!z3 && FrsActivity.this.bfQ.Rx() == 2) {
                                    com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10077");
                                    auVar.r("obj_source", FrsActivity.this.bfQ.Rx());
                                    auVar.aa("tid", ahVar.getId());
                                    auVar.aa(ImageViewerConfig.FORUM_ID, FrsActivity.this.getForumId());
                                    TiebaStatic.log(auVar);
                                }
                                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.ah.Xw.getId() && ahVar.tC() == 2 && ahVar.te() != null) {
                                    com.baidu.tieba.tbadkCore.d.a.a("frs", null, "CLICK", ahVar.te().getForumId(), ahVar.te().getForumName(), ahVar.te().getThreadId(), null, "tieba.baidu.com/p/" + ahVar.te().getThreadId());
                                    if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
                                        FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(FrsActivity.this.getPageContext().getPageActivity()).createNormalCfg(ahVar.te().getThreadId(), ahVar.te().getTaskId(), ahVar.te().getForumId(), ahVar.te().getForumName())));
                                        return;
                                    }
                                }
                                com.baidu.tbadk.core.util.au aa = new com.baidu.tbadk.core.util.au(com.baidu.tieba.card.b.a.aSX).r("obj_locate", com.baidu.tieba.card.b.a.aSV).aa("tid", ahVar.getId());
                                if (ahVar.getAuthor() != null && ahVar.getAuthor().getGodInfo() != null) {
                                    TiebaStatic.log(aa);
                                }
                                if (ahVar.getType() == com.baidu.tbadk.core.data.ah.WH) {
                                    com.baidu.tbadk.core.util.au auVar2 = new com.baidu.tbadk.core.util.au("c10734");
                                    auVar2.aa("tid", ahVar.getId());
                                    auVar2.aa(ImageViewerConfig.FORUM_ID, FrsActivity.this.forumId);
                                    TiebaStatic.log(auVar2);
                                    if (ahVar.getAuthor() != null && ahVar.getAuthor().getGodUserData() != null && ahVar.getAuthor().getGodUserData().getType() == 2) {
                                        TiebaStatic.log(aa);
                                    }
                                }
                                FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(FrsActivity.this.getPageContext().getPageActivity()).createFromThreadCfg(ahVar, FrsActivity.this.bfv, null, 18003, true, false, z2)));
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.c cVar, int i, View view, AppDownloadView appDownloadView) {
        if (cVar != null) {
            a(cVar, true, this.mPn);
            DownloadData downloadData = new DownloadData(cVar.Uy);
            downloadData.setUrl(cVar.Ux);
            downloadData.setName(cVar.Uu);
            downloadData.setPosition(i);
            downloadData.setNotifyId(com.baidu.adp.lib.h.b.g(cVar.Ut, 0));
            switch (AppDownloadView.b(downloadData)) {
                case 3:
                    com.baidu.tieba.frs.utils.a.N(getPageContext().getPageActivity(), cVar.Uy);
                    break;
                case 6:
                    if (com.baidu.adp.lib.util.i.iZ() && !com.baidu.adp.lib.util.i.ja()) {
                        a(cVar, i, true);
                        break;
                    } else if (cVar.rO()) {
                        com.baidu.tbadk.core.util.be.wt().a(getPageContext(), new String[]{cVar.Uw}, true);
                        break;
                    } else if (cVar.rN()) {
                        appDownloadView.setVisibility(0);
                        ((TextView) view).setText(t.j.downloading2);
                        a(cVar, "area_download");
                        b(cVar, i);
                        break;
                    }
                    break;
                case 7:
                    b(cVar, i);
                    ((TextView) view).setText(t.j.downloading2);
                    break;
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", cVar.Uy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.c cVar) {
        if (cVar != null) {
            a(cVar, true, this.mPn);
            com.baidu.tbadk.core.util.be.wt().a(getPageContext(), new String[]{cVar.Uw}, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.bfD.getRootView());
        showLoadingView(this.bfD.getRootView(), true);
        this.bfD.Qe();
        this.bfD.ns();
    }

    public com.baidu.tieba.tbadkCore.o Pk() {
        return this.bfF;
    }

    public boolean Pl() {
        return this.bfD.Pl();
    }

    public void Pm() {
        FrsActivityStatic.bgR = false;
        FrsActivityStatic.bgS = false;
        OS();
    }

    public void Pn() {
        this.bfS.Pn();
    }

    public com.baidu.tieba.frs.mc.a Po() {
        return this.bfQ;
    }

    public void a(cn cnVar) {
        this.bfD = cnVar;
    }

    public void hs(String str) {
        this.bfv = str;
    }

    public void setFrom(String str) {
        this.aer = str;
    }

    public String getFrom() {
        return this.aer;
    }

    public void setFlag(int i) {
        this.bfw = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    public void resetData() {
        this.bfq = false;
        this.bfC = false;
        this.bfF = null;
        this.bfD.setTitle(this.bfv);
        this.bfT.cB(false);
        this.bfT.setIsManager(false);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nv() {
        if (!com.baidu.adp.lib.util.k.jq()) {
            this.bfD.Qp();
        } else if (this.bfQ.Rx() == 1) {
            Pp();
            OB();
        } else if (this.bfQ.hasMore()) {
            OB();
        }
    }

    public void ht(String str) {
        Pp();
        showToast(str);
    }

    public void E(ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.u> a2;
        Pp();
        if (arrayList != null && arrayList.size() != 0 && (a2 = this.bfV.a(false, arrayList, this.bfA)) != null) {
            this.bfF.an(a2);
            this.bfD.a(a2, this.mPn, this.bfF, 0);
        }
    }

    private void Pp() {
        if (this.bfW == 0 && !this.bfV.ag(this.bfF.aKU())) {
            if (this.bfF.getThreadList() == null || this.bfF.getThreadList().size() == 0) {
                this.bfD.Qp();
                return;
            } else {
                this.bfD.Qo();
                return;
            }
        }
        this.bfD.Qn();
    }

    public void OB() {
        if (this.bfQ.Rx() == 1) {
            if (!this.bfV.ayQ && !this.bfQ.isLoading()) {
                if (this.bfV.ag(this.bfF.aKU())) {
                    this.bfD.a(this.bfV.QW(), this.mPn, this.bfF, 0);
                    this.bfV.a(com.baidu.adp.lib.h.b.c(this.forumId, 0L), this.bfF.aKU(), this.bfv, this.mPn);
                } else if (this.bfW != 0) {
                    this.bfD.a(this.bfV.QW(), this.mPn, this.bfF, 0);
                    this.mPn++;
                    this.bfQ.gF(this.mPn);
                    this.bfV.bnp = false;
                    this.bfV.bnq = 0;
                }
            }
        } else if (!this.bfQ.RB()) {
            if (this.bfR.Sj() != null) {
                this.bfR.Sj().a(this.bfQ.Rx(), this.bfQ.Ry(), this.bfQ.Rz());
            }
            this.bfQ.KJ();
        }
    }

    public void Pq() {
        String name;
        if (this.bfF != null && this.bfF.aoE() != null) {
            if (this.bfF.aoE().getName() == null) {
                showToast(getPageContext().getString(t.j.no_forum_data));
                return;
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String str = "http://tieba.baidu.com/f?kw=" + this.bfF.aoE().getName();
            Uri parse = this.bfF.aoE().getImage_url() == null ? null : Uri.parse(this.bfF.aoE().getImage_url());
            String slogan = this.bfF.aoE().getSlogan();
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = String.valueOf(name) + getPageContext().getString(t.j.forum);
            fVar.content = slogan;
            fVar.linkUrl = str;
            fVar.amF = true;
            fVar.extData = getForumId();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true, qJ());
            shareDialogConfig.addOutsideTextView(t.j.share_tieba_qunzu, t.f.icon_unite_share_qunzu, new aj(this));
            shareDialogConfig.addOutsideTextView(t.j.forum_friend, t.f.icon_unite_share_baf, new ak(this));
            shareDialogConfig.setCopyLinkListener(new al(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private SparseArray<String> qJ() {
        if (this.bfX == null) {
            this.bfX = new SparseArray<>(7);
            this.bfX.put(2, "frs_wx_timeline");
            this.bfX.put(3, "frs_wx_friend");
            this.bfX.put(4, "frs_qq_zone");
            this.bfX.put(5, "frs_tencent_weibo");
            this.bfX.put(6, "frs_sina_weibo");
        }
        return this.bfX;
    }

    private ShareFromFrsMsgData Pr() {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(this.bfF.aoE().getImage_url());
        shareFromFrsMsgData.setName(this.bfF.aoE().getName());
        shareFromFrsMsgData.setMemberNum(this.bfF.aoE().getMember_num());
        shareFromFrsMsgData.setPostNum(this.bfF.aoE().getPost_num());
        shareFromFrsMsgData.setContent(this.bfF.aoE().getSlogan());
        return shareFromFrsMsgData;
    }

    private void M(Intent intent) {
        a(Pr(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromFrsMsgData shareFromFrsMsgData, long j, String str, String str2) {
        if (this.bfF != null && this.bfF.aoE() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.s sVar = new com.baidu.tieba.frs.view.s(getPageContext().getPageActivity());
            sVar.setData(shareFromFrsMsgData);
            aVar.ca(1);
            aVar.z(sVar);
            aVar.a(t.j.share, new am(this, sVar, j, str, str2, shareFromFrsMsgData));
            aVar.b(t.j.alert_no_button, new an(this, sVar));
            aVar.ak(true);
            aVar.b(getPageContext()).uj();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                sVar.x(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }

    private void a(ShareFromFrsMsgData shareFromFrsMsgData, int i, String str, long j) {
        if (this.bfF != null && this.bfF.aoE() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.s sVar = new com.baidu.tieba.frs.view.s(getPageContext().getPageActivity());
            sVar.setData(shareFromFrsMsgData);
            aVar.ca(1);
            aVar.z(sVar);
            aVar.a(t.j.share, new ao(this, sVar, i, str, j, shareFromFrsMsgData));
            aVar.b(t.j.alert_no_button, new ap(this, sVar));
            aVar.ak(true);
            aVar.b(getPageContext()).uj();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                sVar.x(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.c cVar, boolean z, int i) {
        a(cVar, z ? "area_click" : "btn_click");
        b(cVar, "click");
        com.baidu.tieba.recapp.report.b.aEK().a(com.baidu.tieba.recapp.report.e.a(cVar, "click", i));
    }
}
