package com.baidu.tieba.frs;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;
import com.baidu.a.a.a;
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
import com.baidu.adp.widget.f;
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
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
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
import com.baidu.tieba.c.c;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.BdExpandListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class FrsActivity extends BaseActivity<FrsActivity> implements a.InterfaceC0000a, BdListView.e, f.b, UserIconBox.b, VoiceManager.c, fj, FrsCommonImageLayout.c {
    public static String bfV = "speed_icon_show";
    private static final int bfW = (com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m11getInst()) - TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds100)) - TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds90);
    private static final int bfX = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds300);
    public static boolean bgc = false;
    public static volatile long bgv = 0;
    public static volatile long bgw = 0;
    public static volatile int bgx = 0;
    private static boolean isNeedRefreshOnResume = false;
    private com.baidu.adp.lib.f.b<TbImageView> adv;
    private boolean beS;
    private String beT;
    VoiceManager beZ;
    private com.baidu.tbadk.core.data.ax bfY;
    private a bgA;
    private com.baidu.tieba.frs.e.a bgC;
    private com.baidu.tieba.frs.h.aa bgD;
    private com.baidu.tieba.frs.h.m bgE;
    private com.baidu.tieba.frs.h.y bgF;
    private com.baidu.tieba.frs.h.w bgG;
    private com.baidu.tieba.frs.view.x bgH;
    private com.baidu.tieba.frs.entelechy.b.d bgI;
    private com.baidu.tieba.c.c bgJ;
    private fk bgK;
    private com.baidu.tieba.frs.loadmore.a bgL;
    private com.baidu.tieba.frs.entelechy.b.b bgN;
    private com.baidu.tieba.frs.entelechy.b.a bga;
    private boolean bgd;
    private com.baidu.tbadk.core.data.ax bge;
    private com.baidu.tieba.tbadkCore.data.f bgl;
    private ed bgr;
    private com.baidu.adp.lib.f.b<TbImageView> bgu;
    private boolean bfZ = false;
    public boolean bgb = false;
    public String bgf = null;
    public String Zf = null;
    public int bgg = 0;
    private int mPn = 1;
    private boolean bgh = false;
    private boolean bgi = false;
    private String mThreadId = null;
    private String forumId = null;
    private int bgj = 0;
    private boolean bgk = false;
    private boolean bgm = false;
    private boolean bgn = false;
    private cn bgo = null;
    private final com.baidu.tbadk.core.data.ax bgp = null;
    private com.baidu.tieba.tbadkCore.o bgq = new com.baidu.tieba.tbadkCore.o();
    private com.baidu.tbadk.core.data.ax bgt = null;
    private boolean AD = false;
    public long aXp = -1;
    public long axE = 0;
    public long axw = 0;
    public long createTime = 0;
    public long Oe = -1;
    private boolean bgy = false;
    public com.baidu.tbadk.performanceLog.e bgz = null;
    private boolean bgB = true;
    private int bgM = -1;
    private fi bgO = new c(this);
    private fg bgP = new n(this);
    private CustomMessageListener adt = new z(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener bdA = new ak(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
    private CustomMessageListener bgQ = new as(this, CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE);
    private CustomMessageListener aLa = new at(this, CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND);
    public final CustomMessageListener bgR = new au(this, CmdConfigCustom.MSG_NEW);
    private CustomMessageListener bgS = new av(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    private boolean bgT = false;
    public final com.baidu.tieba.tbadkCore.r bgU = new aw(this);
    private final CustomMessageListener LV = new d(this, CmdConfigCustom.CMD_REFRESH);
    private final CustomMessageListener mMemListener = new e(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private CustomMessageListener bgV = new f(this, CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS);
    public View.OnTouchListener aFz = new g(this);
    private c.InterfaceC0053c aVi = new h(this);
    private CustomMessageListener bgW = new i(this, CmdConfigCustom.CMD_GOTOLIVE_HOST_UPGRADE);
    private CustomMessageListener bgX = new j(this, CmdConfigCustom.CMD_AD_KILLER_SUBMIT_SUCCESS);
    private final com.baidu.adp.framework.listener.a bgY = new k(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    private final BdExpandListView.a bgZ = new l(this);
    public final View.OnClickListener bha = new m(this);
    private final AbsListView.OnScrollListener bfa = new o(this);
    private final bi bhb = new q(this);
    private final com.baidu.tieba.tbadkCore.af bfd = new com.baidu.tieba.tbadkCore.af(getPageContext(), new r(this));
    private CustomMessageListener bhc = new s(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private final View.OnClickListener bhd = new t(this);
    private final View.OnClickListener bhe = new u(this);
    private final View.OnClickListener bhf = new v(this);
    private final NoNetworkView.a bes = new w(this);
    private final CustomMessageListener bhg = new x(this, 0);
    private com.baidu.adp.widget.ListView.w bhh = new b();
    private com.baidu.adp.widget.ListView.x bhi = new y(this);
    public final com.baidu.adp.base.g bhj = new aa(this);
    public final com.baidu.adp.base.g bhk = new ab(this);

    @Override // com.baidu.tieba.frs.fj
    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tieba.frs.fj
    public String getForumName() {
        return this.bgf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.y yVar) {
        if (yVar != null) {
            boolean z = yVar.isLike() == 1;
            if (this.bgo != null && this.bgq != null && this.bgq.avD() != null && yVar.getFid() != null) {
                if (yVar.getFid().equals(this.bgq.avD().getId())) {
                    this.bgq.avD().setLike(yVar.isLike());
                    if (!StringUtils.isNULL(yVar.getLevelName())) {
                        this.bgq.avD().setLevelName(yVar.getLevelName());
                    }
                    if (yVar.getUserLevel() >= 0) {
                        this.bgq.avD().setUser_level(yVar.getUserLevel());
                    }
                    if (z) {
                        this.bgE.a(this.bgq, false);
                        this.bgF.dn(true);
                        TbadkCoreApplication.m11getInst().addLikeForum(this.bgf);
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.aRZ().L(this.bgf, false);
                    this.bgq.avD().setLike(0);
                    this.bgE.TQ();
                    this.bgF.dn(false);
                    TbadkCoreApplication.m11getInst().delLikeForum(this.bgf);
                    return;
                }
                if (yVar.isLike() == 1) {
                    this.bgq.nK(yVar.getFid());
                    this.bgE.e(this.bgq);
                    this.bgI.a(this.bgo.QR(), this.bgq);
                }
                if (this.bgq.avD().getBannerListData() != null) {
                    this.bgq.avD().getBannerListData().setFeedForumLiked(yVar.getFid(), yVar.isLike());
                }
                this.bgo.QO();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m11getInst().isGpuOpen();
    }

    public void a(ErrorData errorData) {
        this.bgo.cQ(false);
        this.bgo.QO();
        hideLoadingView(this.bgo.getRootView());
        this.bgo.cS(false);
        this.bgo.QV();
        if (!this.bgn) {
            d.a Tp = Qd().Tp();
            if (!this.bfZ) {
                if (Tp != null) {
                    if (this.bgC.Tr() != 0) {
                        this.bgC.Tw();
                        this.bgo.QO();
                    } else {
                        if (Tp.eqd) {
                            if (340001 == Tp.errorCode) {
                                showNetRefreshViewNoClick(this.bgo.getRootView(), getPageContext().getResources().getString(t.j.net_error_text, Tp.errorMsg, Integer.valueOf(Tp.errorCode)), true);
                            } else {
                                showNetRefreshView(this.bgo.getRootView(), getPageContext().getResources().getString(t.j.net_error_text, Tp.errorMsg, Integer.valueOf(Tp.errorCode)), true);
                            }
                        } else if (340001 == Tp.errorCode) {
                            showNetRefreshViewNoClick(this.bgo.getRootView(), Tp.errorMsg, true);
                        } else {
                            showNetRefreshView(this.bgo.getRootView(), Tp.errorMsg, true);
                        }
                        setNetRefreshViewEmotionDefMarginTop();
                    }
                    this.bgo.i(false, false);
                    this.bgo.gp(8);
                }
            } else if (Tp != null && Tp.eqd) {
                this.bgo.i(true, false);
                this.bgo.gp(0);
                showToast(getPageContext().getResources().getString(t.j.net_error_text, Tp.errorMsg, Integer.valueOf(Tp.errorCode)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean PF() {
        if (this.bgI != null && this.bgo != null) {
            this.bgI.u(this.bgo.QR());
        }
        if (this.bgE != null && Qd() != null) {
            this.bgE.a(Qd().JR(), this.bgq);
        }
        boolean z = false;
        if (this.bgq != null) {
            z = this.bgq.aSY();
        }
        cL(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh(int i) {
        fo foVar = null;
        PF();
        Pm();
        try {
            if (this.bgq != null) {
                this.bgo.a(null, 1, this.bgq, 0);
                this.bgE.gQ(1);
                this.bgo.QS();
                this.bgI.a(this.bgo.QR(), this.bgq);
                com.baidu.tieba.frs.tab.i a2 = a(this.bgI.SD(), this.bgq.aSx());
                if (a2 != null && !TextUtils.isEmpty(a2.url)) {
                    foVar = new fo();
                    foVar.bmS = a2.url;
                    foVar.stType = a2.name;
                }
                this.bgC.a(this.bgq.aSx(), 0, foVar);
                this.bgI.de(false);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private com.baidu.tieba.frs.tab.i a(TabData tabData, int i) {
        if (i < 0 || tabData == null || tabData.size() <= 0) {
            return null;
        }
        Iterator it = tabData.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.frs.tab.i iVar = (com.baidu.tieba.frs.tab.i) it.next();
            if (iVar != null && iVar.aYo == i) {
                return iVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.m mVar) {
        int aSx;
        if (!this.bgT && mVar != null) {
            try {
                if (this.bgq != null) {
                    this.bgq.d(mVar);
                    PO();
                    this.bgM = this.bgq.getPage().pK();
                    this.bgI.u(this.bgo.QR());
                    boolean aSY = this.bgq.aSY();
                    this.bgE.e(com.baidu.tieba.frs.h.m.g(this.bgq), this.bgq.getUserData().getIsMem(), this.bgq.avD().isLike());
                    cL(aSY);
                    if (this.bgN != null) {
                        this.bgN.a(this.bgE, this.bgq);
                    }
                    this.bgo.Lf();
                    this.bgf = this.bgq.avD().getName();
                    this.forumId = this.bgq.avD().getId();
                    this.bgo.setTitle(this.bgf);
                    PM();
                    this.bgq.aSL();
                    this.bgq.aSM();
                    this.bgq.aSS();
                    if (!Qd().Tq()) {
                        if (TbadkCoreApplication.m11getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            this.bgq.aSR();
                            this.bgq.aSQ();
                            this.bgq.aSO();
                        }
                        this.bgq.aSP();
                    }
                    if (!this.bgq.aSV()) {
                        this.bgq.aSU();
                    }
                    if (TbadkCoreApplication.m11getInst().isRecAppExist()) {
                        this.bgq.aQ(getPageContext().getPageActivity());
                        this.bgq.N(getPageContext().getPageActivity(), this.forumId);
                    }
                    this.bgq.aSK();
                    com.baidu.tbadk.core.data.ba top_notice_data = this.bgq.avD().getTop_notice_data();
                    if (top_notice_data != null && top_notice_data.getTitle() != null) {
                        com.baidu.tbadk.core.data.ax axVar = new com.baidu.tbadk.core.data.ax();
                        axVar.setTitle(top_notice_data.getTitle());
                        axVar.bH(2);
                        axVar.cr(top_notice_data.rI());
                        axVar.parser_title();
                        this.bgq.p(axVar);
                    }
                    this.bgq.aSW();
                    if (this.bgC.bsq && (aSx = mVar.aSx()) != 1) {
                        this.bfZ = true;
                        gh(aSx);
                        return;
                    }
                    ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bgq.getThreadList();
                    if (threadList != null) {
                        ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bgL.a(true, threadList);
                        if (a2 != null) {
                            this.bgq.an(a2);
                        }
                        this.bgo.a(threadList, this.mPn, this.bgq, this.bgq.getPage().pK());
                        PX();
                        this.bgE.gQ(this.mPn);
                        this.bgE.e(this.bgq);
                        this.bgI.a(this.bgo.QR(), this.bgq);
                        this.bgo.QS();
                    }
                    this.bgj = this.bgq.Tu();
                    if (this.bgl != null) {
                        this.bgk = true;
                        this.bgl.pi(this.bgj);
                    }
                    this.bgE.dm(this.bgq.aSf());
                    hideLoadingView(this.bgo.getRootView());
                    this.bgo.cO(true);
                    this.bgo.gp(0);
                    this.bgo.cS(false);
                    this.bfZ = true;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void cL(boolean z) {
        if (this.bgN != null) {
            this.bgN.a(z, this.bgI, this.bgE, this.bgo, this.bgq);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        bfV = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (intent != null) {
            this.aXp = intent.getLongExtra("TibaStatic.StartTime", System.currentTimeMillis());
            if (intent.getData() != null) {
                Uri data = intent.getData();
                this.bgf = data.getQueryParameter("name");
                this.Zf = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.bgf)) {
                    intent.putExtra("name", this.bgf);
                }
                if (!StringUtils.isNull(this.Zf)) {
                    intent.putExtra("from", this.Zf);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.bgf)) {
                this.bgf = h(intent);
                if (!StringUtils.isNull(this.bgf)) {
                    intent.putExtra("name", this.bgf);
                }
            }
        } else {
            this.aXp = System.currentTimeMillis();
        }
        this.Oe = System.currentTimeMillis();
        this.axw = this.Oe - this.aXp;
        if (!cM(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.Oe;
            return;
        }
        super.onCreate(bundle);
        this.bgC = new com.baidu.tieba.frs.e.a(this);
        this.bgC.a(this.bgO);
        this.bgC.init();
        if (getIntent() != null) {
            this.bgC.c(getIntent().getExtras());
        } else if (bundle != null) {
            this.bgC.c(bundle);
        } else {
            this.bgC.c((Bundle) null);
        }
        Qd().m(3, true);
        this.bga = new com.baidu.tieba.frs.entelechy.c();
        this.bgN = this.bga.Sh();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(t.h.frs_activity, (ViewGroup) null);
        this.bgG = new com.baidu.tieba.frs.h.w(this, this.bga.Sg());
        this.bgD = new com.baidu.tieba.frs.h.aa(this);
        this.bgF = new com.baidu.tieba.frs.h.y(this);
        this.bgG.a(getPageContext().getPageActivity(), inflate, this.bgF.Ub().getView());
        this.bgE = new com.baidu.tieba.frs.h.m(this, this.bgD, this.bga);
        this.bgI = this.bga.L(this);
        this.bgD.b(this.bga);
        this.bgI.ae(this.bgD.getRootView());
        if (getIntent() != null) {
            this.bgE.h(getIntent().getExtras());
        } else if (bundle != null) {
            this.bgE.h(bundle);
        } else {
            this.bgE.h((Bundle) null);
        }
        this.beZ = getVoiceManager();
        this.beZ.onCreate(getPageContext());
        nq();
        initData(bundle);
        this.bfd.setUniqueId(getUniqueId());
        this.bfd.registerListener();
        addGlobalLayoutListener();
        PG();
        registerListener(this.LV);
        registerListener(this.mMemListener);
        registerListener(this.bgR);
        registerListener(this.adt);
        registerListener(this.aLa);
        registerListener(this.bdA);
        registerListener(this.bgS);
        registerListener(this.bgV);
        registerListener(this.bgW);
        registerListener(this.bhc);
        registerListener(this.bgX);
        registerListener(this.bgQ);
        this.bgY.bn().setSelfListener(true);
        this.bgY.bm().setSelfListener(true);
        this.bgY.setTag(getUniqueId());
        registerListener(this.bgY);
        this.bgL = new com.baidu.tieba.frs.loadmore.a(this);
        this.bgL.registerListener();
        this.bgl = new com.baidu.tieba.tbadkCore.data.f("frs", com.baidu.tieba.tbadkCore.data.f.eso);
        this.createTime = System.currentTimeMillis() - this.Oe;
        if (this.bgo != null) {
            showLoadingView(this.bgo.getRootView(), true);
            this.bgo.cT(false);
        }
        this.bgK = new fk(getActivity(), this.bgo, this.bgE);
        this.bgK.cY(true);
        this.bgJ = new com.baidu.tieba.c.c(getActivity());
        this.bgJ.a(this.aVi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
        } else if (this.bgq != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null && this.bgo != null) {
            com.baidu.tbadk.core.data.ab abVar = new com.baidu.tbadk.core.data.ab();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(getMyPostResIdl.data.thread_info.author);
            a(metaData, getMyPostResIdl.data.user_info, getMyPostResIdl.data.thread_info.twzhibo_info);
            String userId = metaData.getUserId();
            if (userId != null && !userId.equals("0")) {
                hashMap.put(metaData.getUserId(), metaData);
            }
            abVar.setUserMap(hashMap);
            abVar.a(getMyPostResIdl.data.thread_info);
            this.bgC.a(abVar);
            ArrayList<com.baidu.adp.widget.ListView.v> a2 = this.bgL.a(true, this.bgq.getThreadList());
            if (a2 != null) {
                this.bgq.an(a2);
                this.bgq.aSK();
                this.bgo.a(a2, this.mPn, this.bgq, this.bgM);
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0008: IGET  (r1v0 java.lang.Long A[REMOVE]) = (r4v0 tbclient.GetMyPost.User_Info) tbclient.GetMyPost.User_Info.id java.lang.Long)] */
    private void a(MetaData metaData, User_Info user_Info, ZhiBoInfoTW zhiBoInfoTW) {
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
            if (zhiBoInfoTW != null && zhiBoInfoTW.user != null) {
                String str = zhiBoInfoTW.user.fans_nickname;
                if (StringUtils.isNull(str)) {
                    str = getPageContext().getResources().getString(t.j.fans_default_name);
                }
                metaData.setFansNickName(str);
            }
        }
    }

    private void PG() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MY_POST, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.GET_MY_POST + "?cmd=303111");
        tbHttpMessageTask.setResponsedClass(GetMyPostHttpResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(303111);
        bVar.setResponsedClass(GetMyPostSocketResponseMessage.class);
        bVar.h(true);
        bVar.i(false);
        bVar.a(SocketMessageTask.DupLicateMode.NONE);
        messageManager.registerTask(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.beZ = getVoiceManager();
        this.beZ.onStart(getPageContext());
    }

    private void initData(Bundle bundle) {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.bhg);
        if (bundle != null) {
            this.bgf = bundle.getString("name");
            this.Zf = bundle.getString("from");
            this.bgg = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.bgf = intent.getStringExtra("name");
                this.Zf = intent.getStringExtra("from");
                this.bgg = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.Zf) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.Zf)) {
            setSwipeBackEnabled(false);
        }
        this.bgr = new ed(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            PH();
            registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.bhg);
        }
        this.bgE.h(bundle);
    }

    private String h(Intent intent) {
        int indexOf;
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (!StringUtils.isNull(dataString) && dataString.startsWith("tbfrs://")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10320").s("obj_locate", 2).s("obj_type", 1));
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (StringUtils.isNull(decode) || (indexOf = decode.indexOf("kw=")) < 0 || (length = indexOf + "kw=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public void PH() {
        if (this.bgr != null && this.bgo != null) {
            if (FrsActivityStatic.bhF || FrsActivityStatic.bhG) {
                this.bgr.aC(com.baidu.tbadk.coreExtra.messageCenter.a.xj().getMsgReplyme());
                this.bgr.aB(com.baidu.tbadk.coreExtra.messageCenter.a.xj().getMsgAtme());
                this.bgr.aE(com.baidu.tbadk.coreExtra.messageCenter.a.xj().xq());
                this.bgr.aD(com.baidu.tbadk.coreExtra.messageCenter.a.xj().getMsgChat());
                this.bgo.a(this.bgr);
                this.bgF.a(this.bgr);
            }
        }
    }

    private boolean cM(boolean z) {
        if (z && com.baidu.tieba.frs.utils.a.G(getPageContext().getPageActivity(), getClass().getName())) {
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
        if (this.bgq != null && this.bgq.avD() != null) {
            ex.RE().aG(com.baidu.adp.lib.h.b.c(this.bgq.avD().getId(), 0L));
        }
        if (this.bgo != null) {
            this.bgo.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.bgz != null) {
                this.bgz.onDestroy();
            }
            this.bgo.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.bgC.onActivityDestroy();
        this.bgD.onActivityDestroy();
        this.bgE.onActivityDestroy();
        this.beZ = getVoiceManager();
        this.beZ.onDestory(getPageContext());
        if (this.bgA != null) {
            this.bgA.cancel(true);
            this.bgA = null;
        }
        if (this.bgC != null) {
            this.bgC.Pa();
        }
        if (this.bgF != null) {
            this.bgF.destroy();
        }
        if (this.bgK != null) {
            this.bgK.RP();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.bgf);
        bundle.putString("from", this.Zf);
        this.bgC.onSaveInstanceState(bundle);
        this.beZ = getVoiceManager();
        if (this.beZ != null) {
            this.beZ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.ax nM;
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    gi(0);
                    return;
                case 11002:
                    this.bgE.kT();
                    return;
                case 11011:
                    d(this.bgp);
                    return;
                case 11012:
                    e(this.bgt);
                    return;
                case 11014:
                    this.bgE.TX();
                    return;
                case 11016:
                    this.bgo.QQ();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    this.bgE.Qc();
                    return;
                case 12016:
                    i(intent);
                    return;
                case 13003:
                    if (intent != null) {
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
                    this.bgo.Ra().notifyDataSetChanged();
                    if (this.bgE != null) {
                        this.bgE.Sf();
                    }
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (nM = this.bgq.nM(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", -1);
                        if (intExtra == 2) {
                            nM.bI(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            nM.parser_title();
                            bU(6);
                            return;
                        } else if (intExtra == 0) {
                            this.bgq.q(nM);
                            this.bgo.QS();
                            if (com.baidu.tieba.tbadkCore.c.aRZ() != null) {
                                com.baidu.tieba.tbadkCore.c.aRZ().L(this.bgf, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    PU();
                    return;
                case 23003:
                    if (intent != null && this.bgq != null) {
                        a(Qh(), intent.getIntExtra("group_id", 0), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L));
                        return;
                    }
                    return;
                case 23007:
                    j(intent);
                    return;
                case 23013:
                    PV();
                    return;
                case 23019:
                    PW();
                    return;
                case 24002:
                    if (intent != null) {
                        int intExtra2 = intent.getIntExtra(SupplementSignActivityConfig.FORUM_ID, 0);
                        int intExtra3 = intent.getIntExtra(SupplementSignActivityConfig.CONTINUOUS_SIGN_ALL_DAYS, 0);
                        int intExtra4 = intent.getIntExtra(SupplementSignActivityConfig.SUPPLEMENT_SIGN_DAYS, 0);
                        int intExtra5 = intent.getIntExtra(SupplementSignActivityConfig.SIGN_BONUS_POINT, 0);
                        if (intExtra2 == com.baidu.adp.lib.h.b.g(this.forumId, 0)) {
                            this.bgE.p(intExtra3, intExtra4, intExtra5);
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

    private void i(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(WriteActivityConfig.TOGETHERHI_DATA);
            if (!TextUtils.isEmpty(stringExtra)) {
                int i = 0;
                if (this.bgq.getUserData() != null) {
                    i = this.bgq.getUserData().getIsMem();
                }
                WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), 0, this.bgq.avD().getId(), this.bgf, null, null, 0, this.bgq.pz(), 13003, false, false, null, false, false, null, null, this.bgq.avD().getPrefixData(), i);
                if (en.RC().gs(1) != null) {
                    writeActivityConfig.setCategroyId(this.bgC.Tr());
                }
                boolean Fc = com.baidu.tbadk.plugins.g.Fc();
                if (!this.bgq.getUserData().canPostHi()) {
                    Fc = false;
                }
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.TOGETHERHI_SHOW, Fc);
                writeActivityConfig.getIntent().putExtra(WriteActivityConfig.TOGETHERHI_DATA, stringExtra);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostWriteCallBackData postWriteCallBackData) {
        if (this.bgC != null) {
            if (this.bgC.Tx() == 2 || this.bgC.Tx() == 3) {
                int Tr = this.bgC.Tr();
                if (en.RC().gs(1) == null) {
                    Tr = 0;
                }
                if (Tr == 0 && postWriteCallBackData != null) {
                    long c = com.baidu.adp.lib.h.b.c(postWriteCallBackData.getPostId(), 0L);
                    long c2 = com.baidu.adp.lib.h.b.c(postWriteCallBackData.getThreadId(), 0L);
                    long c3 = com.baidu.adp.lib.h.b.c(this.forumId, 0L);
                    if (c != 0 && c2 != 0 && c3 != 0) {
                        com.baidu.adp.lib.h.h.dL().postDelayed(new ac(this, c2, c, c3), 1000L);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bgo != null) {
            this.bgo.QO();
        }
        this.bgI.a(this.bgP);
        this.beS = true;
        this.bgB = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.bgo.jy();
        } else if (bgc) {
            bgc = false;
            this.bgo.jy();
        } else {
            this.beZ = getVoiceManager();
            this.beZ.onResume(getPageContext());
            this.bgo.cU(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (z) {
            this.bgo.Rd();
            this.bgG.df(true);
            refresh();
            return;
        }
        this.bgo.Rc();
        this.bgG.df(false);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.bgf = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.Zf = intent.getStringExtra("from");
            }
            this.bgi = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.bgi) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    PI();
                } else {
                    PJ();
                }
            }
        }
    }

    private void PI() {
        this.bgo.jy();
        this.bgG.showContent(false);
    }

    private void PJ() {
        this.bgo.jy();
        this.bgG.showContent(false);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.Zf)) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            } else {
                com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.Zf)) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        } else {
            com.baidu.tbadk.core.e.b.d(getPageContext().getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.Zf)) {
            finish();
        }
    }

    private void nq() {
        this.bgo.Ra().l(this.bhd);
        this.bgo.Ra().m(this.bhe);
        this.bgo.Ra().n(this.bhf);
        if (this.bgg == 0) {
            this.bgo.setTitle(this.bgf);
        } else {
            this.bgo.setTitle("");
            this.bgg = 1;
        }
        this.bgE.a(this.bgo.QR());
        this.bgo.a(this.bhh);
        this.bgo.a(this.bhi);
        this.bgo.setOnScrollListener(this.bfa);
        this.bgo.a(this.bgZ);
        this.bgo.g(this.bes);
        this.bgo.Ra().a(this.bhb);
        if (!this.mIsLogin) {
            this.bgo.Rc();
            this.bgG.df(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.bgo.onChangeSkinType(i);
        this.bgF.a(getPageContext(), i);
        this.bgE.a(getPageContext(), i);
        this.bgI.onChangeSkinType(i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.f.b<TbImageView> Pq() {
        if (this.bgu == null) {
            this.bgu = FrsCommonImageLayout.o(getPageContext().getPageActivity(), 12);
        }
        return this.bgu;
    }

    @Override // com.baidu.adp.widget.f.b
    public void kg() {
        setSwipeBackEnabled(true);
    }

    @Override // com.baidu.adp.widget.f.b
    public void kh() {
        setSwipeBackEnabled(false);
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
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            return Boolean.valueOf(com.baidu.tieba.frs.utils.a.H(FrsActivity.this.getPageContext().getPageActivity(), this.name));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                FrsActivity.this.showToast(t.j.shortcut_has_add);
            } else {
                FrsActivity.this.hH(this.name);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hH(String str) {
        Intent I;
        if (str != null && (I = com.baidu.tieba.frs.utils.a.I(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(t.j.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", I);
            BarImageView TW = this.bgE.TW();
            if (TW != null && TW.getBdImage() != null && TW.getBdImage().iY() != null) {
                Bitmap iY = TW.getBdImage().iY();
                Float valueOf = Float.valueOf(getResources().getDisplayMetrics().density);
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.d.eY().a(com.baidu.adp.lib.util.d.eY().resizeBitmap(iY, valueOf.intValue() * 48), valueOf.intValue() * 6));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), t.f.icon));
            }
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gi(int i) {
        if (!this.mIsLogin) {
            if (this.bgq != null && this.bgq.pz() != null) {
                this.bgq.pz().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.bgq != null) {
            if (i == 0) {
                if (!this.bgd) {
                    gj(0);
                    return;
                }
                TiebaStatic.log("c10152");
                gj(4);
                return;
            }
            this.bgo.QQ();
        }
    }

    private void gj(int i) {
        int i2 = 0;
        if (this.bgq.getUserData() != null) {
            i2 = this.bgq.getUserData().getIsMem();
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(getPageContext().getPageActivity(), i, this.bgq.avD().getId(), this.bgf, null, null, 0, this.bgq.pz(), 13003, false, false, null, false, false, null, null, this.bgq.avD().getPrefixData(), i2);
        if (en.RC().gs(1) != null) {
            writeActivityConfig.setCategroyId(this.bgC.Tr());
        }
        boolean Fc = com.baidu.tbadk.plugins.g.Fc();
        if (!this.bgq.getUserData().canPostHi()) {
            Fc = false;
        }
        writeActivityConfig.getIntent().putExtra(WriteActivityConfig.TOGETHERHI_SHOW, Fc);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.ax axVar) {
        boolean rr = axVar == null ? true : axVar.rr();
        this.bgo.a(new ad(this, axVar));
        this.bgo.a(axVar, rr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PK() {
        if (!this.mIsLogin) {
            skipToRegisterActivity();
            return;
        }
        boolean z = false;
        String str = "";
        if (this.bgq.avD() != null && this.bgq.avD().getAnchorPower() != null) {
            z = this.bgq.avD().getCanAddPhotoLivePost();
            str = this.bgq.avD().getAnchorPower().can_add_live_post_msg;
        }
        if (z) {
            this.bgd = true;
            gj(4);
            com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("isAlreadyShowIcon" + TbadkCoreApplication.getCurrentAccount(), true);
            return;
        }
        hI(str);
    }

    private void hI(String str) {
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
                aVar.cA(optString);
                aVar.a(t.j.view, new ae(this, optString2));
                aVar.b(t.j.cancel, new af(this));
                aVar.b(getPageContext()).rV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PL() {
        if (com.baidu.tbadk.core.util.bl.ac(getPageContext().getPageActivity())) {
            AntiData pz = this.bgq.pz();
            if (pz != null) {
                if (AntiHelper.e(pz) || AntiHelper.f(pz) || AntiHelper.g(pz)) {
                    pz.setBlock_forum_name(this.bgf);
                    pz.setBlock_forum_id(this.bgq.avD().getId());
                    pz.setUser_name(this.bgq.getUserData().getUserName());
                    pz.setUser_id(this.bgq.getUserData().getUserId());
                    if (AntiHelper.a(getPageContext().getPageActivity(), pz, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(pz.getPollMessage())) {
                    com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), pz.getPollMessage());
                    return;
                }
            }
            PostPrefixData postPrefixData = null;
            if (this.bgq.avD() != null) {
                postPrefixData = this.bgq.avD().getPrefixData();
            }
            int i = 0;
            if (this.bgq.getUserData() != null) {
                i = this.bgq.getUserData().getIsMem();
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVoteActivityConfig(getPageContext().getPageActivity(), this.bgq.avD().getId(), this.bgf, pz, 13003, postPrefixData, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.ax axVar) {
        boolean rr = axVar == null ? true : axVar.rr();
        if (this.mThreadId != null) {
            if (!rr) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(axVar, this.bgf, null, 18003, true, true, this.bgm)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(axVar, this.bgf, null, 18003, false, false, this.bgm)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tbadk.core.data.ax axVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(axVar, this.bgf, null, 18003, false, false, this.bgm)));
        }
    }

    public void refresh() {
        bU(3);
    }

    public void bU(int i) {
        this.bgT = false;
        this.bfZ = false;
        this.bgn = false;
        Pm();
        Qd().m(i, true);
    }

    private void PM() {
        switch (this.bgg) {
            case 1:
                com.baidu.adp.lib.h.k.dM().c(new ag(this));
                break;
        }
        this.bgg = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PN() {
        Pm();
        try {
            if (this.bgq != null) {
                this.bgo.Lf();
                this.bgo.QE();
                this.bgo.cO(true);
                if (com.baidu.tieba.frs.h.m.g(this.bgq)) {
                    this.bgo.Rn();
                }
                this.bgf = this.bgq.avD().getName();
                this.forumId = this.bgq.avD().getId();
                this.bgo.setTitle(this.bgf);
                TbadkCoreApplication.m11getInst().setDefaultBubble(this.bgq.getUserData().getBimg_url());
                TbadkCoreApplication.m11getInst().setDefaultBubbleEndTime(this.bgq.getUserData().getBimg_end_time());
                PM();
                ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bgq.getThreadList();
                if (threadList != null) {
                    this.bgo.a(threadList, this.mPn, this.bgq, this.bgq.getPage().pK());
                    PX();
                    this.bgE.gQ(this.mPn);
                    this.bgE.e(this.bgq);
                    this.bgI.a(this.bgo.QR(), this.bgq);
                    this.bgo.QS();
                    PO();
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private void PO() {
        if (this.bgq != null) {
            if (this.bgq.avL() == 1) {
                this.bgo.Ra().setFromCDN(true);
            } else {
                this.bgo.Ra().setFromCDN(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.beS = false;
        this.bgB = false;
        this.bgo.onPause();
        this.beZ = getVoiceManager();
        this.beZ.onPause(getPageContext());
        this.bgo.cU(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Object c;
        super.onStop();
        if (this.bgq != null && this.bgq.avD() != null) {
            com.baidu.tbadk.distribute.a.AL().b(getPageContext().getPageActivity(), "frs", this.bgq.avD().getId(), 0L);
        }
        this.beZ = getVoiceManager();
        if (this.beZ != null) {
            this.beZ.onStop(getPageContext());
        }
        BdListView listView = getListView();
        if (listView != null && (c = com.baidu.adp.lib.a.a.a.c(listView, "mRecycler")) != null) {
            com.baidu.adp.lib.a.a.a.a("clear", c, c.getClass());
        }
        this.bgE.onActivityStop();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.bgh) {
            if (i == 4) {
                if (this.bgG.isMenuShowing()) {
                    this.bgG.toggle(true);
                    if (this.bgF.Ub().RX()) {
                        this.bgF.Ub().db(false);
                        refresh();
                        return true;
                    }
                    return true;
                } else if (this.bgo.QM()) {
                    return true;
                } else {
                    closeActivity();
                    return true;
                }
            }
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void a(com.baidu.tbadk.core.data.c cVar, int i, boolean z) {
        String trim;
        if (cVar != null) {
            if (!com.baidu.adp.lib.util.i.fe()) {
                showToast(t.j.neterror);
            } else if (cVar.oH()) {
                com.baidu.tbadk.core.util.bg.ut().a(getPageContext(), new String[]{cVar.MQ}, true);
            } else if (cVar.oG()) {
                if (com.baidu.adp.lib.util.i.fq() && !com.baidu.adp.lib.util.i.fr()) {
                    trim = getPageContext().getString(t.j.frs_network_tips);
                } else if (TextUtils.isEmpty(cVar.Nb.Nl.trim())) {
                    trim = getPageContext().getString(t.j.confirm_download_app);
                } else {
                    trim = cVar.Nb.Nl.trim();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.cA(trim);
                aVar.a(t.j.alert_yes_button, new ah(this, cVar, z, i));
                aVar.b(t.j.alert_no_button, new ai(this));
                aVar.b(getPageContext()).rV();
            }
        }
    }

    public boolean d(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar == null) {
            return false;
        }
        if (!cVar.oF()) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), t.j.pb_app_error);
            return false;
        } else if (!com.baidu.tieba.tbadkCore.ah.q(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), t.j.write_external_storage_permission_denied_fun_disable);
            return false;
        } else {
            boolean a2 = com.baidu.tieba.tbadkCore.ah.a(getPageContext().getPageActivity(), cVar, i);
            if (a2) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", cVar.MS);
            }
            return a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PP() {
        boolean z = false;
        if (this.bgo != null) {
            boolean z2 = (this.bgq == null || !TbadkCoreApplication.m11getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class) || this.bgq.avD() == null || this.bgq.avD().getAnchorPower() == null || this.bgq.avD().getAnchorPower().can_add_live_post.intValue() == 2) ? false : true;
            boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
            boolean Fc = com.baidu.tbadk.plugins.g.Fc();
            if (this.bgq != null && this.bgq.getUserData().canPostHi()) {
                z = Fc;
            }
            this.bgH = new com.baidu.tieba.frs.view.x(getPageContext(), this.bgo.getRootView(), new aj(this));
            this.bgH.d(z2, showXiaoyingTool, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PQ() {
        TiebaStatic.log("c10798");
        if (com.baidu.tbadk.core.util.bl.ac(getPageContext().getPageActivity())) {
            if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(getPageContext(), getResources().getString(t.j.plugin_video_not_active), getResources().getString(t.j.setup));
                    return;
                }
                AntiData pz = this.bgq.pz();
                if (pz != null && !StringUtils.isNull(pz.getVideo_message())) {
                    com.baidu.adp.lib.util.k.showToast(getPageContext().getPageActivity(), pz.getVideo_message());
                    return;
                }
                boolean z = false;
                if (this.bgq != null && this.bgq.getUserData() != null && this.bgq.getUserData().getGodUserData() != null && (this.bgq.getUserData().getGodUserData().getType() == 2 || this.bgq.getUserData().getGodUserData().getType() == 1)) {
                    z = true;
                }
                if (this.bgq != null && this.bgq.avD() != null) {
                    XiaoyingUtil.startXiaoying(getPageContext().getPageActivity(), z, this.bgq.avD().getId(), this.bgq.avD().getName());
                    return;
                }
                return;
            }
            XiaoyingUtil.showGoPluginDetailDialog(getPageContext(), getResources().getString(t.j.plugin_video_install_tips), getResources().getString(t.j.plugin_go_install));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PR() {
        if (com.baidu.tbadk.core.util.bl.ac(getPageContext().getPageActivity()) && com.baidu.tbadk.plugins.g.f(getPageContext()) && this.bgq != null && this.bgq.avD() != null) {
            if (this.bgq.getUserData() != null) {
                this.bgq.getUserData().getIsMem();
            }
            if (en.RC().gs(1) != null) {
                this.bgC.Tr();
            }
            com.baidu.tbadk.plugins.g.g(getPageContext().getPageActivity(), 12016);
        }
    }

    public boolean PS() {
        if (this.bgH == null) {
            return false;
        }
        return this.bgH.isShowing();
    }

    public void PT() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
        this.bgA = new a(this.bgf);
        this.bgA.setSelfExecute(true);
        this.bgA.execute(new String[0]);
    }

    public void PU() {
        com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.bgq.avD().getId(), true, true, true);
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.AL().a(getPageContext().getPageActivity(), cVar, str, "frs", this.bgq.avD().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.AL().a(cVar, this.forumId, 0L, "FRS", str, this.mPn);
    }

    public int getPn() {
        return this.mPn;
    }

    public void PV() {
        if (checkUpIsLogin()) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10177").ac("fid", this.forumId));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(getPageContext().getPageActivity(), String.valueOf(getForumId()), false, 0)));
        }
    }

    public void PW() {
        if (checkUpIsLogin() && this.bge != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(getPageContext().getPageActivity()).createConfig(String.valueOf(getForumId()), this.bge.getTid(), 1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gg(int i) {
        ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bgq.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.v next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.ax) {
                    com.baidu.tbadk.core.data.ax axVar = (com.baidu.tbadk.core.data.ax) next;
                    if (axVar == this.bfY) {
                        c(axVar, i);
                        this.bfY = null;
                        break;
                    } else if (axVar.getId() != null && axVar.getId().equals(this.beT)) {
                        c(axVar, i);
                        this.beT = null;
                        break;
                    }
                }
            }
            this.bgo.Ra().a(threadList, this.bgq);
            this.bgo.Ra().notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tbadk.core.data.ax axVar, int i) {
        if (i == 1) {
            PraiseData praise = axVar.getPraise();
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
                    axVar.setPraise(praiseData);
                    return;
                }
                axVar.getPraise().getUser().add(0, metaData);
                axVar.getPraise().setNum(axVar.getPraise().getNum() + 1);
                axVar.getPraise().setIsLike(i);
            }
        } else if (axVar.getPraise() != null) {
            axVar.getPraise().setIsLike(i);
            axVar.getPraise().setNum(axVar.getPraise().getNum() - 1);
            ArrayList<MetaData> user = axVar.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        axVar.getPraise().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdateAttentionMessage updateAttentionMessage) {
        com.baidu.tbadk.core.data.ax axVar;
        ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bgq.getThreadList();
        if (threadList != null && updateAttentionMessage != null && updateAttentionMessage.getData() != null) {
            MetaData metaData = new MetaData();
            Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
            MetaData metaData2 = metaData;
            while (it.hasNext()) {
                com.baidu.adp.widget.ListView.v next = it.next();
                if ((next instanceof com.baidu.tbadk.core.data.ax) && (axVar = (com.baidu.tbadk.core.data.ax) next) != null && axVar.getAuthor() != null && axVar.getAuthor().getUserId() != null && axVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid) && !axVar.getAuthor().equals(metaData2)) {
                    a(axVar, updateAttentionMessage);
                    metaData2 = axVar.getAuthor();
                }
            }
            this.bgo.Ra().a(threadList, this.bgq);
            this.bgo.Ra().notifyDataSetChanged();
        }
    }

    private void a(com.baidu.tbadk.core.data.ax axVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        int i2;
        if (axVar != null && axVar.getAuthor() != null && axVar.getAuthor().getUserId() != null && axVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = axVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
                i2 = 1;
            } else {
                i = fansNum - 1;
                i2 = 0;
            }
            axVar.getAuthor().setFansNum(i);
            if (axVar.getAuthor().getGodUserData() != null) {
                axVar.getAuthor().getGodUserData().setFollowed(i2);
                axVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.beZ == null) {
            this.beZ = VoiceManager.instance();
        }
        return this.beZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: KR */
    public BdListView getListView() {
        if (this.bgo == null) {
            return null;
        }
        return this.bgo.QR();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void Pm() {
        this.beZ = getVoiceManager();
        this.beZ.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public int vy() {
        if (this.bgo == null) {
            return 0;
        }
        return this.bgo.QW();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.f.b<TbImageView> vz() {
        if (this.adv == null) {
            this.adv = UserIconBox.e(getPageContext().getPageActivity(), 8);
        }
        return this.adv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            int msgOfficialMerge = newsNotifyMessage.getMsgOfficialMerge();
            int msgStrangerChat = newsNotifyMessage.getMsgStrangerChat();
            if (this.bgr != null) {
                this.bgr.aC(msgReplyme);
                this.bgr.aB(msgAtme);
                this.bgr.aF(msgOfficialMerge);
                this.bgr.aD(msgChat);
                this.bgr.aE(msgStrangerChat);
                this.bgo.a(this.bgr);
                this.bgF.a(this.bgr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        boolean z;
        if (this.bgq != null && this.bgo != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null) {
            Iterator<DownloadData> it = data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().getStatus() == 0) {
                    z = true;
                    break;
                }
            }
            if (z) {
                this.bgo.QO();
            }
        }
    }

    private void PX() {
        HashMap<Integer, com.baidu.tbadk.core.data.ax> Sv;
        if (this.bgo != null && this.bgo.Ra() != null && (Sv = this.bgo.Ra().Sv()) != null) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.ax> entry : Sv.entrySet()) {
                com.baidu.tbadk.core.data.ax value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.c)) {
                    arrayList.add((com.baidu.tbadk.core.data.c) value);
                }
            }
            com.baidu.tbadk.download.b.AR().n(arrayList);
        }
    }

    public void PY() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.k.a(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    /* loaded from: classes.dex */
    class b implements com.baidu.adp.widget.ListView.w {
        b() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v27, resolved type: com.baidu.tieba.frs.FrsActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, com.baidu.adp.widget.ListView.v vVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
            if (bdUniqueId != null) {
                if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.MG.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.MH.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.MI.getId()) {
                    if (vVar == null || !(vVar instanceof com.baidu.tbadk.core.data.c)) {
                        return;
                    }
                    FrsActivity.this.a((com.baidu.tbadk.core.data.c) vVar, i, view.findViewById(t.g.frs_app_download), (AppDownloadView) view.findViewById(t.g.frs_app_download_view));
                } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.aa.erz.getId()) {
                    if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.MJ.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.MK.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.ML.getId()) {
                        if (vVar != null && (vVar instanceof com.baidu.tbadk.core.data.c)) {
                            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) vVar;
                            if (!cVar.oG()) {
                                if (!cVar.oH()) {
                                    return;
                                }
                                FrsActivity.this.b(cVar);
                                return;
                            }
                            FrsActivity.this.a(cVar, i, view.findViewById(t.g.frs_app_download), (AppDownloadView) view.findViewById(t.g.frs_app_download_view));
                        }
                    } else if (vVar != null && (vVar instanceof com.baidu.tbadk.core.data.ax)) {
                        com.baidu.tbadk.core.data.ax axVar = (com.baidu.tbadk.core.data.ax) vVar;
                        if (axVar.getAnchorInfoData() == null || axVar.getAnchorInfoData().getGroup_id() == 0 || FrsActivity.this.checkUpIsLogin()) {
                            if ((axVar.rh() != 1 && axVar.rh() != 2) || FrsActivity.this.checkUpIsLogin()) {
                                if (axVar.qX() != null) {
                                    if (FrsActivity.this.checkUpIsLogin()) {
                                        String postUrl = axVar.qX().getPostUrl();
                                        if (!StringUtils.isNull(postUrl) && com.baidu.adp.lib.util.k.fH()) {
                                            com.baidu.tbadk.browser.f.u(FrsActivity.this.getActivity(), postUrl);
                                        }
                                    }
                                } else if (axVar.rv() != null) {
                                    com.baidu.tbadk.core.data.k rv = axVar.rv();
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaBrowserActivityConfig(FrsActivity.this.getPageContext().getPageActivity(), rv.getCartoonId(), rv.getChapterId(), 2)));
                                } else {
                                    com.baidu.tieba.tbadkCore.util.s readThreadHistory = TbadkCoreApplication.m11getInst().getReadThreadHistory();
                                    if (readThreadHistory != null && !readThreadHistory.od(axVar.getId())) {
                                        readThreadHistory.oc(axVar.getId());
                                    }
                                    boolean z = false;
                                    String qS = axVar.qS();
                                    if (qS != null && !qS.equals("")) {
                                        z = true;
                                        new Thread(new ax(this, qS)).start();
                                    }
                                    boolean z2 = z;
                                    String tid = axVar.getTid();
                                    if (tid == null) {
                                        tid = "";
                                    }
                                    if (axVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                                        com.baidu.tbadk.core.util.bg ut = com.baidu.tbadk.core.util.bg.ut();
                                        TbPageContext<?> pageContext = FrsActivity.this.getPageContext();
                                        String[] strArr = new String[3];
                                        strArr[0] = tid;
                                        strArr[1] = "";
                                        ut.c(pageContext, strArr);
                                        return;
                                    }
                                    boolean z3 = false;
                                    if (axVar instanceof com.baidu.tbadk.core.data.r) {
                                        z3 = true;
                                        TiebaStatic.log("c10769");
                                    }
                                    if (axVar.getThreadType() == 33 || (axVar instanceof com.baidu.tbadk.core.data.ah)) {
                                        if (!z3) {
                                            String str = axVar.getThreadType() == 33 ? "c10245" : "c10180";
                                            if (FrsActivity.this.bgC.Tt() == 5) {
                                                str = "c10387";
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.aw(str).ac("fid", FrsActivity.this.forumId));
                                        }
                                        FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(FrsActivity.this.getPageContext().getPageActivity(), axVar.getTid()).cj("from_frs").bo(18003).oq()));
                                        return;
                                    }
                                    if (tid.startsWith("pb:")) {
                                        axVar.setId(tid.substring(3));
                                    }
                                    if (!z3 && FrsActivity.this.bgC.Tt() == 2) {
                                        com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10077");
                                        awVar.s("obj_source", FrsActivity.this.bgC.Tt());
                                        awVar.ac("tid", axVar.getId());
                                        awVar.ac("fid", FrsActivity.this.getForumId());
                                        TiebaStatic.log(awVar);
                                    }
                                    if (bdUniqueId.getId() == com.baidu.tbadk.core.data.ax.QO.getId() && axVar.rf() == 2 && axVar.qF() != null) {
                                        String qE = axVar.qF().qE();
                                        if (StringUtils.isNull(qE)) {
                                            qE = axVar.qF().getTaskId();
                                        }
                                        com.baidu.tieba.tbadkCore.d.a.a("frs", null, "CLICK", FrsActivity.this.getForumId(), FrsActivity.this.getForumName(), axVar.qF().getThreadId(), null, "tieba.baidu.com/p/" + axVar.qF().getThreadId(), qE);
                                        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
                                            FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new InterviewLiveActivityConfig(FrsActivity.this.getPageContext().getPageActivity()).createNormalCfg(axVar.qF().getThreadId(), axVar.qF().getTaskId(), axVar.qF().getForumId(), axVar.qF().getForumName())));
                                            return;
                                        }
                                    }
                                    com.baidu.tbadk.core.util.aw ac = new com.baidu.tbadk.core.util.aw("c10806").s("obj_locate", 3).ac("tid", axVar.getId());
                                    if (axVar.getAuthor() != null && axVar.getAuthor().getGodInfo() != null) {
                                        TiebaStatic.log(ac);
                                    }
                                    FrsActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(FrsActivity.this.getPageContext().getPageActivity()).createFromThreadCfg(axVar, FrsActivity.this.bgf, null, 18003, true, false, z2)));
                                }
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
            DownloadData downloadData = new DownloadData(cVar.MS);
            downloadData.setUrl(cVar.MR);
            downloadData.setName(cVar.MO);
            downloadData.setPosition(i);
            downloadData.setNotifyId(com.baidu.adp.lib.h.b.g(cVar.MN, 0));
            switch (AppDownloadView.b(downloadData)) {
                case 3:
                    com.baidu.tieba.frs.utils.a.F(getPageContext().getPageActivity(), cVar.MS);
                    break;
                case 6:
                case 7:
                    if (com.baidu.adp.lib.util.i.fq() && !com.baidu.adp.lib.util.i.fr()) {
                        a(cVar, i, true);
                        break;
                    } else if (cVar.oH()) {
                        com.baidu.tbadk.core.util.bg.ut().a(getPageContext(), new String[]{cVar.MQ}, true);
                        break;
                    } else if (cVar.oG() && d(cVar, i)) {
                        if (appDownloadView != null) {
                            appDownloadView.setVisibility(0);
                        }
                        if (view instanceof TextView) {
                            ((TextView) view).setText(t.j.downloading2);
                        }
                        a(cVar, "area_download");
                        break;
                    }
                    break;
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", cVar.MS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.c cVar) {
        if (cVar != null) {
            a(cVar, true, this.mPn);
            com.baidu.tbadk.core.util.bg.ut().a(getPageContext(), new String[]{cVar.MQ}, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.k.fH()) {
            hideNetRefreshView(this.bgo.getRootView());
            showLoadingView(this.bgo.getRootView(), true);
            this.bgo.cT(false);
            this.bgo.jy();
        }
    }

    public com.baidu.tieba.tbadkCore.o PZ() {
        return this.bgq;
    }

    public boolean Qa() {
        return this.bgo.Qa();
    }

    public void Qb() {
        FrsActivityStatic.bhF = false;
        FrsActivityStatic.bhG = false;
        PH();
    }

    public void Qc() {
        this.bgE.Qc();
    }

    public com.baidu.tieba.frs.e.a Qd() {
        return this.bgC;
    }

    public com.baidu.tieba.frs.h.aa Qe() {
        return this.bgD;
    }

    public void a(cn cnVar) {
        this.bgo = cnVar;
    }

    public void hJ(String str) {
        this.bgf = str;
    }

    public void setFrom(String str) {
        this.Zf = str;
    }

    public String getFrom() {
        return this.Zf;
    }

    public void setFlag(int i) {
        this.bgg = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jA() {
        if (!com.baidu.adp.lib.util.k.fH()) {
            this.bgo.Ri();
        } else if (this.bgC.Tt() == 1) {
            Qf();
            Pp();
        } else if (this.bgC.hasMore()) {
            Pp();
        }
    }

    public void hK(String str) {
        Qf();
        showToast(str);
    }

    public void B(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        ArrayList<com.baidu.adp.widget.ListView.v> a2;
        Qf();
        if (arrayList != null && arrayList.size() != 0 && (a2 = this.bgL.a(false, arrayList, this.bgl)) != null) {
            this.bgq.an(a2);
            this.bgo.a(a2, this.mPn, this.bgq, 0);
        }
    }

    private void Qf() {
        if (this.bgM == 0 && !this.bgL.ai(this.bgq.aSi())) {
            if (this.bgq.getThreadList() == null || this.bgq.getThreadList().size() == 0) {
                this.bgo.Ri();
                return;
            } else {
                this.bgo.Rh();
                return;
            }
        }
        this.bgo.Rg();
    }

    public void Pp() {
        if (this.bgC.Tt() == 1) {
            if (!this.bgL.avz && !this.bgC.isLoading()) {
                if (this.bgL.ai(this.bgq.aSi())) {
                    this.bgo.a(this.bgL.SX(), this.mPn, this.bgq, 0);
                    this.bgL.a(com.baidu.adp.lib.h.b.c(this.forumId, 0L), this.bgq.aSi(), this.bgf, this.mPn);
                } else if (this.bgM != 0) {
                    this.bgo.a(this.bgL.SX(), this.mPn, this.bgq, 0);
                    this.mPn++;
                    this.bgC.gE(this.mPn);
                    this.bgL.bqQ = false;
                    this.bgL.bqR = 0;
                }
            }
        } else if (!this.bgC.Tv()) {
            this.bgC.KO();
        }
    }

    public void Qg() {
        String name;
        if (this.bgq != null && this.bgq.avD() != null) {
            if (this.bgq.avD().getName() == null) {
                showToast(getPageContext().getString(t.j.no_forum_data));
                return;
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String str = "http://tieba.baidu.com/f?kw=" + this.bgq.avD().getName();
            Uri parse = this.bgq.avD().getImage_url() == null ? null : Uri.parse(this.bgq.avD().getImage_url());
            String slogan = this.bgq.avD().getSlogan();
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = String.valueOf(name) + getPageContext().getString(t.j.forum);
            fVar.content = slogan;
            fVar.linkUrl = str;
            fVar.aiJ = true;
            fVar.extData = getForumId();
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getPageContext().getPageActivity(), fVar, true);
            shareDialogConfig.addOutsideTextView(t.j.share_tieba_qunzu, t.f.icon_unite_share_qunzu, new al(this));
            shareDialogConfig.addOutsideTextView(t.j.forum_friend, t.f.icon_unite_share_baf, new am(this));
            shareDialogConfig.setCopyLinkListener(new an(this, fVar));
            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    private ShareFromFrsMsgData Qh() {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(this.bgq.avD().getImage_url());
        shareFromFrsMsgData.setName(this.bgq.avD().getName());
        shareFromFrsMsgData.setMemberNum(this.bgq.avD().getMember_num());
        shareFromFrsMsgData.setPostNum(this.bgq.avD().getPost_num());
        shareFromFrsMsgData.setContent(this.bgq.avD().getSlogan());
        return shareFromFrsMsgData;
    }

    private void j(Intent intent) {
        a(Qh(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromFrsMsgData shareFromFrsMsgData, long j, String str, String str2) {
        if (this.bgq != null && this.bgq.avD() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.v vVar = new com.baidu.tieba.frs.view.v(getPageContext().getPageActivity());
            vVar.setData(shareFromFrsMsgData);
            aVar.bN(1);
            aVar.z(vVar);
            aVar.a(t.j.share, new ao(this, vVar, j, str, str2, shareFromFrsMsgData));
            aVar.b(t.j.alert_no_button, new ap(this, vVar));
            aVar.aq(true);
            aVar.b(getPageContext()).rV();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                vVar.z(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }

    private void a(ShareFromFrsMsgData shareFromFrsMsgData, int i, String str, long j) {
        if (this.bgq != null && this.bgq.avD() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.v vVar = new com.baidu.tieba.frs.view.v(getPageContext().getPageActivity());
            vVar.setData(shareFromFrsMsgData);
            aVar.bN(1);
            aVar.z(vVar);
            aVar.a(t.j.share, new aq(this, vVar, i, str, j, shareFromFrsMsgData));
            aVar.b(t.j.alert_no_button, new ar(this, vVar));
            aVar.aq(true);
            aVar.b(getPageContext()).rV();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                vVar.z(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.c cVar, boolean z, int i) {
        a(cVar, z ? "area_click" : "btn_click");
        b(cVar, "click");
        com.baidu.tieba.recapp.report.b.aLJ().a(com.baidu.tieba.recapp.report.e.a(cVar, "click", i));
    }

    public boolean Qi() {
        return this.bgF.Ub().RX();
    }

    public void cN(boolean z) {
        this.bgF.Ub().db(z);
    }

    public void Qj() {
        if (!com.baidu.tbadk.core.util.ag.b(getPageContext().getPageActivity(), 1)) {
            com.baidu.tbadk.core.util.as.c(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a006";
    }

    @Override // com.baidu.a.a.a.InterfaceC0000a
    public void a(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (com.baidu.tbadk.core.util.ag.R(getApplicationContext())) {
                com.baidu.tbadk.core.util.as.c(getPageContext());
            } else {
                showToast(t.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a2 = com.baidu.tbadk.core.util.ag.a(strArr, iArr);
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(t.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(getForumId(), 0L));
        }
        return pageStayDurationItem;
    }

    public com.baidu.adp.widget.ListView.w Qk() {
        return this.bhh;
    }

    public com.baidu.adp.widget.ListView.x Ql() {
        return this.bhi;
    }

    public com.baidu.tieba.frs.entelechy.b.b Qm() {
        return this.bgN;
    }

    public cn Qn() {
        return this.bgo;
    }
}
