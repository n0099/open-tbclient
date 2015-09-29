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
    public static String aTs;
    private boolean aSo;
    private String aSp;
    private com.baidu.tbadk.core.data.v aTA;
    private com.baidu.tieba.tbadkCore.data.b aTG;
    private dg aTM;
    private com.baidu.adp.lib.e.b<TbImageView> aTO;
    private a aTV;
    private com.baidu.tieba.frs.mc.a aTX;
    private com.baidu.tieba.frs.b.o aTY;
    private com.baidu.tieba.frs.b.a aTZ;
    private com.baidu.tbadk.core.data.v aTv;
    private boolean aTz;
    private com.baidu.tieba.frs.b.k aUa;
    private com.baidu.tieba.frs.loadmore.a aUb;
    private com.baidu.adp.lib.e.b<TbImageView> aeH;
    VoiceManager mVoiceManager;
    private static final int aTt = (com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds100)) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds90);
    private static final int aTu = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds300);
    public static boolean aTy = false;
    public static volatile long aTQ = 0;
    public static volatile long aTR = 0;
    public static volatile int aTS = 0;
    private static boolean isNeedRefreshOnResume = false;
    private boolean aTw = false;
    public boolean aTx = false;
    public String aTB = null;
    public String mFrom = null;
    public int aTC = 0;
    private int mPn = 1;
    private boolean aTD = false;
    private boolean aTE = false;
    private String mThreadId = null;
    private String forumId = null;
    private int aTF = 0;
    private boolean aTH = false;
    private boolean aTI = false;
    private bs aTJ = null;
    private final com.baidu.tbadk.core.data.v aTK = null;
    private com.baidu.tieba.tbadkCore.o aTL = new com.baidu.tieba.tbadkCore.o();
    private com.baidu.tbadk.core.data.v aTN = null;
    private boolean Ji = false;
    public long aLy = -1;
    public long axx = 0;
    public long createTime = 0;
    public long aTP = -1;
    private boolean aTT = false;
    public com.baidu.tbadk.performanceLog.e aTU = null;
    private boolean aTW = true;
    private int aUc = -1;
    private SparseArray<String> aUd = null;
    private eb aUe = new com.baidu.tieba.frs.a(this);
    private ea aUf = new l(this);
    private CustomMessageListener aSu = new x(this, CmdConfigCustom.PB_ACTION_PRAISE);
    private CustomMessageListener aRb = new ai(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
    private CustomMessageListener aHo = new an(this, CmdConfigCustom.CMD_RESPONSE_ADD_FRIEND);
    public final CustomMessageListener aUg = new ao(this, CmdConfigCustom.MSG_NEW);
    private CustomMessageListener aUh = new ap(this, CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP);
    private boolean aUi = false;
    public final com.baidu.tieba.tbadkCore.r aUj = new aq(this);
    private final CustomMessageListener Tr = new ar(this, CmdConfigCustom.CMD_REFRESH);
    private final CustomMessageListener mMemListener = new b(this, CmdConfigCustom.CMD_RESPONSE_MEM);
    private final com.baidu.adp.framework.listener.a aUk = new c(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
    private final p.a aUl = new d(this);
    private final BdListView.g HD = new e(this);
    public final View.OnClickListener aUm = new f(this);
    private final AbsListView.OnScrollListener aSw = new g(this);
    private final bd aUn = new h(this);
    private final com.baidu.tieba.tbadkCore.ae aSy = new com.baidu.tieba.tbadkCore.ae(getPageContext(), new i(this));
    private final View.OnClickListener aUo = new j(this);
    private final View.OnClickListener aUp = new k(this);
    public final AdapterView.OnItemClickListener aUq = new m(this);
    private final NoNetworkView.a aRP = new n(this);
    private final CustomMessageListener aUr = new o(this, 0);
    private com.baidu.adp.widget.ListView.v aUs = new p(this);
    private View.OnClickListener aUt = new r(this);
    private View.OnClickListener aUu = new s(this);
    private com.baidu.adp.widget.ListView.w aUv = new t(this);
    private final SlidingMenu.OnOpenedListener aUw = new u(this);
    public final com.baidu.adp.base.g aUx = new v(this);
    public final com.baidu.adp.base.g aUy = new w(this);

    public String getForumId() {
        return this.forumId;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m411getInst().isGpuOpen();
    }

    public void a(ErrorData errorData) {
        this.aTJ.cc(false);
        this.aTJ.cd(false);
        this.aTJ.ce(false);
        this.aTJ.LQ();
        hideLoadingView(this.aTJ.getRootView());
        this.aTJ.LX();
        if (!this.aTI) {
            e.a Ne = Lm().Ne();
            if (!this.aTw) {
                if (Ne != null) {
                    if (Ne.cWu) {
                        if (340001 == Ne.errorCode) {
                            showNetRefreshViewNoClick(this.aTJ.getRootView(), getPageContext().getResources().getString(i.h.net_error_text, Ne.errorMsg, Integer.valueOf(Ne.errorCode)), true);
                        } else {
                            showNetRefreshView(this.aTJ.getRootView(), getPageContext().getResources().getString(i.h.net_error_text, Ne.errorMsg, Integer.valueOf(Ne.errorCode)), true);
                        }
                    } else if (340001 == Ne.errorCode) {
                        showNetRefreshViewNoClick(this.aTJ.getRootView(), Ne.errorMsg, true);
                    } else {
                        showNetRefreshView(this.aTJ.getRootView(), Ne.errorMsg, true);
                    }
                    this.aTJ.fA(8);
                }
            } else if (Ne != null && Ne.cWu) {
                this.aTJ.fA(0);
                showToast(getPageContext().getResources().getString(i.h.net_error_text, Ne.errorMsg, Integer.valueOf(Ne.errorCode)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.m mVar) {
        boolean z;
        if (!this.aUi && mVar != null) {
            try {
                this.aTL.d(mVar);
                if (this.aTL.aeT() == 1) {
                    this.aTJ.LZ().setFromCDN(true);
                } else {
                    this.aTJ.LZ().setFromCDN(false);
                }
                this.aUc = this.aTL.getPage().rL();
                this.aTJ.b(this.aTL.aeN(), this.aTL.getUserData());
                if (this.aTL.avA() == null) {
                    z = false;
                } else {
                    z = this.aTL.avA().size() != 0;
                }
                this.aTZ.a(this.aTL.avo().avE() == 1, this.aTL.getUserData().getIsMem(), this.aTL.aeN().isLike(), z);
                this.aTJ.LP();
                this.aTB = this.aTL.aeN().getName();
                this.forumId = this.aTL.aeN().getId();
                this.aTJ.setTitle(this.aTB);
                KZ();
                this.aTL.avL();
                this.aTL.aP(getPageContext().getPageActivity());
                this.aTL.avP();
                if (!Lm().Nd() && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    this.aTL.avO();
                    this.aTL.avN();
                }
                com.baidu.tbadk.core.data.x top_notice_data = this.aTL.aeN().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.getTitle() != null) {
                    com.baidu.tbadk.core.data.v vVar = new com.baidu.tbadk.core.data.v();
                    vVar.setTitle(top_notice_data.getTitle());
                    vVar.bA(2);
                    vVar.cm(top_notice_data.sK());
                    vVar.parser_title();
                    this.aTL.f(vVar);
                }
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aTL.getThreadList();
                if (threadList != null) {
                    ArrayList<com.baidu.adp.widget.ListView.u> a2 = this.aUb.a(true, threadList);
                    if (a2 != null) {
                        this.aTL.af(a2);
                    }
                    this.aTJ.a(threadList, this.mPn, this.aTL, this.aTL.getPage().rL());
                    Lf();
                    this.aTZ.fU(this.mPn);
                    this.aTZ.c(this.aTL);
                    this.aTJ.LT();
                    this.aTJ.fz(0);
                }
                this.aTZ.cj(this.aTL.avq());
                hideLoadingView(this.aTJ.getRootView());
                this.aTJ.fA(0);
                this.aTJ.LX();
                this.aTw = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        aTs = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (intent != null) {
            this.aLy = intent.getLongExtra("TibaStatic.StartTime", -1L);
            if (intent.getData() != null) {
                Uri data = intent.getData();
                this.aTB = data.getQueryParameter("name");
                this.mFrom = data.getQueryParameter("from");
                if (!StringUtils.isNull(this.aTB)) {
                    intent.putExtra("name", this.aTB);
                }
                if (!StringUtils.isNull(this.mFrom)) {
                    intent.putExtra("from", this.mFrom);
                }
                TiebaStatic.log("c10105");
            }
            if (StringUtils.isNull(this.aTB)) {
                this.aTB = M(intent);
                if (!StringUtils.isNull(this.aTB)) {
                    intent.putExtra("name", this.aTB);
                }
            }
        } else {
            this.aLy = System.currentTimeMillis();
        }
        if (this.aLy != -1) {
            this.aTP = this.aLy;
        } else {
            this.aTP = System.currentTimeMillis();
        }
        if (!bZ(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.aTP;
            return;
        }
        super.onCreate(bundle);
        this.aTX = new com.baidu.tieba.frs.mc.a(this);
        this.aTX.a(this.aUe);
        this.aTX.init();
        if (getIntent() != null) {
            this.aTX.f(getIntent().getExtras());
        } else if (bundle != null) {
            this.aTX.f(bundle);
        } else {
            this.aTX.f(null);
        }
        Lm().oR();
        setContentView(i.g.frs_activity);
        this.aTY = new com.baidu.tieba.frs.b.o(this);
        this.aUa = new com.baidu.tieba.frs.b.k(this);
        this.aTZ = new com.baidu.tieba.frs.b.a(this, this.aTY);
        this.aTY.oQ();
        if (getIntent() != null) {
            this.aTZ.h(getIntent().getExtras());
        } else if (bundle != null) {
            this.aTZ.h(bundle);
        } else {
            this.aTZ.h((Bundle) null);
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        this.aSy.setUniqueId(getUniqueId());
        this.aSy.registerListener();
        addGlobalLayoutListener();
        KQ();
        registerListener(this.Tr);
        registerListener(this.mMemListener);
        registerListener(this.aUg);
        registerListener(this.aSu);
        registerListener(this.aHo);
        registerListener(this.aRb);
        registerListener(this.aUh);
        this.aUk.getSocketMessageListener().setSelfListener(true);
        this.aUk.getHttpMessageListener().setSelfListener(true);
        this.aUk.setTag(getUniqueId());
        registerListener(this.aUk);
        this.aUb = new com.baidu.tieba.frs.loadmore.a(this);
        this.aUb.registerListener();
        this.aTG = new com.baidu.tieba.tbadkCore.data.b("frs");
        this.createTime = System.currentTimeMillis() - this.aLy;
        if (this.aTJ != null) {
            showLoadingView(this.aTJ.getRootView(), true);
            this.aTJ.LY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0) {
            showToast(str);
        } else if (this.aTL != null && getMyPostResIdl != null && getMyPostResIdl.data != null && getMyPostResIdl.data.thread_info != null && this.aTJ != null) {
            com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(getMyPostResIdl.data.thread_info.author);
            a(metaData, getMyPostResIdl.data.user_info);
            String userId = metaData.getUserId();
            if (userId != null && !userId.equals("0")) {
                hashMap.put(metaData.getUserId(), metaData);
            }
            lVar.setUserMap(hashMap);
            lVar.a(getMyPostResIdl.data.thread_info);
            this.aTX.a(lVar);
            ArrayList<com.baidu.adp.widget.ListView.u> a2 = this.aUb.a(true, this.aTL.getThreadList());
            if (a2 != null) {
                this.aTL.af(a2);
                this.aTJ.a(a2, this.mPn, this.aTL, this.aUc);
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
            this.aTB = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aTC = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.aTB = intent.getStringExtra("name");
                this.mFrom = intent.getStringExtra("from");
                this.aTC = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            setSwipeBackEnabled(false);
        }
        this.aTM = new dg(getPageContext().getPageActivity());
        if (this.mIsLogin) {
            KR();
            KT();
        }
        this.aTZ.h(bundle);
    }

    private String M(Intent intent) {
        int indexOf;
        int length;
        if (intent == null || intent.getData() == null) {
            return null;
        }
        String dataString = intent.getDataString();
        if (!StringUtils.isNull(dataString) && dataString.startsWith("tbfrs://")) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10320").r("obj_locate", 2).r("obj_type", 1));
        }
        String decode = Uri.decode(intent.getData().getEncodedPath());
        if (StringUtils.isNull(decode) || (indexOf = decode.indexOf("kw=")) < 0 || (length = indexOf + "kw=".length()) > decode.length()) {
            return null;
        }
        return decode.substring(length);
    }

    public void KR() {
        if (this.aTM != null && this.aTJ != null) {
            if (FrsActivityStatic.aUP || FrsActivityStatic.aUQ || FrsActivityStatic.aUR) {
                this.aTM.af(com.baidu.tbadk.coreExtra.messageCenter.a.wK().getMsgReplyme());
                this.aTM.ae(com.baidu.tbadk.coreExtra.messageCenter.a.wK().getMsgAtme());
                int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.wK().getMsgChat();
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xy() && !TbadkCoreApplication.m411getInst().isMIUIRom()) {
                    msgChat -= com.baidu.tbadk.coreExtra.messageCenter.a.wK().wR();
                }
                this.aTM.ag(msgChat);
                this.aTJ.a(this.aTM);
                this.aUa.a(this.aTM);
            }
        }
    }

    private void KS() {
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.aUr);
    }

    private void KT() {
        registerListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL, this.aUr);
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
        if (this.aTJ != null) {
            this.aTJ.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.aTU != null) {
                this.aTU.onDestroy();
            }
            this.aTJ.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.aTX.onActivityDestroy();
        this.aTY.onActivityDestroy();
        this.aTZ.onActivityDestroy();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
        if (this.aTV != null) {
            this.aTV.cancel(true);
            this.aTV = null;
        }
        if (this.aTX != null) {
            this.aTX.Ku();
        }
        if (this.aUa != null) {
            this.aUa.destroy();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aTB);
        bundle.putString("from", this.mFrom);
        this.aTX.onSaveInstanceState(bundle);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.v lr;
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    fq(0);
                    return;
                case 11002:
                    this.aTZ.oN();
                    return;
                case 11011:
                    b(this.aTK);
                    return;
                case 11012:
                    c(this.aTN);
                    return;
                case 11014:
                    this.aTZ.NG();
                    return;
                case 11016:
                    this.aTJ.LS();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    this.aTZ.Ll();
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
                    this.aTJ.LZ().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (lr = this.aTL.lr(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            lr.bB(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            lr.parser_title();
                            refresh();
                            return;
                        } else if (intExtra == 0) {
                            this.aTL.g(lr);
                            this.aTJ.LT();
                            if (com.baidu.tieba.tbadkCore.d.avn() != null) {
                                com.baidu.tieba.tbadkCore.d.avn().H(this.aTB, false);
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
                    if (intent != null && this.aTL != null) {
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
        this.aUa.NN();
        this.aTZ.a(this.aUf);
        this.aSo = true;
        this.aTW = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.aTJ.nw();
        } else if (aTy) {
            aTy = false;
            this.aTJ.nw();
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
            this.aTJ.Mc();
            this.aUa.NO().setSlidingEnabled(true);
            refresh();
            return;
        }
        this.aTJ.Mb();
        this.aUa.NO().setSlidingEnabled(false);
        refresh();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.aTB = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.aTE = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aTE) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    KU();
                } else {
                    KV();
                }
            }
        }
    }

    private void KU() {
        this.aTJ.nw();
        this.aUa.NO().showContent(false);
    }

    private void KV() {
        this.aTJ.nw();
        this.aUa.NO().showContent(false);
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
        this.aTJ.LZ().h(this.aUo);
        this.aTJ.LZ().i(this.aUp);
        if (this.aTC == 0) {
            this.aTJ.setTitle(this.aTB);
        } else {
            this.aTJ.setTitle("");
            this.aTC = 1;
        }
        this.aUa.NO();
        this.aTZ.t(this.aTJ.getListView());
        this.aTJ.a(this.aUs);
        this.aTJ.a(this.aUv);
        this.aTJ.j(this.aUt);
        this.aTJ.l(this.aUu);
        this.aTJ.setOnScrollListener(this.aSw);
        this.aTJ.a(this.HD);
        this.aTJ.a(this.aUl);
        this.aTJ.g(this.aRP);
        this.aUa.NO().setOnOpenedListener(this.aUw);
        this.aTJ.LZ().a(this.aUn);
        if (!this.mIsLogin) {
            this.aTJ.Mb();
            this.aUa.NO().setSlidingEnabled(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        super.onChangeSkinType(i);
        this.aTJ.onChangeSkinType(i);
        this.aUa.a(getPageContext(), i);
        this.aTZ.a(getPageContext(), i);
        changeSwipeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> KD() {
        if (this.aTO == null) {
            this.aTO = FrsCommonImageLayout.n(getPageContext().getPageActivity(), 12);
        }
        return this.aTO;
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
            BarImageView NF = this.aTZ.NF();
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
            if (this.aTL != null && this.aTL.rF() != null) {
                this.aTL.rF().setIfpost(1);
            }
            if (i == 0) {
                skipToRegisterActivity();
            }
        } else if (this.aTL != null) {
            if (i == 0) {
                if (!this.aTz) {
                    fr(0);
                    return;
                }
                TiebaStatic.log("c10152");
                fr(4);
                return;
            }
            this.aTJ.LS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fr(int i) {
        int i2 = 0;
        if (this.aTL.getUserData() != null) {
            i2 = this.aTL.getUserData().getIsMem();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(getPageContext().getPageActivity(), i, this.aTL.aeN().getId(), this.aTB, null, null, 0, this.aTL.rF(), 13003, false, false, null, false, false, null, null, this.aTL.aeN().getPrefixData(), i2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.v vVar) {
        boolean sE = vVar == null ? true : vVar.sE();
        this.aTJ.c(new z(this, vVar));
        this.aTJ.a(vVar, sE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KW() {
        this.aTJ.b(new aa(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KX() {
        this.aTJ.a(new ab(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KY() {
        AntiData rF = this.aTL.rF();
        if (rF != null) {
            if (AntiHelper.e(rF) || AntiHelper.f(rF) || AntiHelper.g(rF)) {
                rF.setBlock_forum_name(this.aTB);
                rF.setBlock_forum_id(this.aTL.aeN().getId());
                rF.setUser_name(this.aTL.getUserData().getUserName());
                rF.setUser_id(this.aTL.getUserData().getUserId());
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
        if (this.aTL.aeN() != null) {
            postPrefixData = this.aTL.aeN().getPrefixData();
        }
        int i = 0;
        if (this.aTL.getUserData() != null) {
            i = this.aTL.getUserData().getIsMem();
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteVoteActivityConfig(getPageContext().getPageActivity(), this.aTL.aeN().getId(), this.aTB, rF, 13003, postPrefixData, i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.v vVar) {
        boolean sE = vVar == null ? true : vVar.sE();
        if (this.mThreadId != null) {
            if (!sE) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(vVar, this.aTB, null, 18003, true, true, this.aTH)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(vVar, this.aTB, null, 18003, false, false, this.aTH)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.v vVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(vVar, this.aTB, null, 18003, false, false, this.aTH)));
        }
    }

    public void refresh() {
        stopVoice();
        if (this.aTY != null && this.aTY.NP() != null) {
            this.aTY.NP().a(this.aTX.Ng(), this.aTX.Nh(), this.aTX.Ni());
        }
        Lm().bB(true);
    }

    private void KZ() {
        switch (this.aTC) {
            case 1:
                com.baidu.adp.lib.g.k.hh().c(new ac(this));
                break;
        }
        this.aTC = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void La() {
        stopVoice();
        try {
            if (this.aTL != null) {
                this.aTJ.LP();
                this.aTB = this.aTL.aeN().getName();
                this.forumId = this.aTL.aeN().getId();
                this.aTJ.setTitle(this.aTB);
                TbadkCoreApplication.m411getInst().setDefaultBubble(this.aTL.getUserData().getBimg_url());
                TbadkCoreApplication.m411getInst().setDefaultBubbleEndTime(this.aTL.getUserData().getBimg_end_time());
                KZ();
                ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aTL.getThreadList();
                if (threadList != null) {
                    this.aTJ.a(threadList, this.mPn, this.aTL, this.aTL.getPage().rL());
                    Lf();
                    this.aTZ.fU(this.mPn);
                    this.aTZ.c(this.aTL);
                    this.aTJ.LT();
                    if (this.aTL.aeT() == 1) {
                        this.aTJ.LZ().setFromCDN(true);
                    } else {
                        this.aTJ.LZ().setFromCDN(false);
                    }
                    this.aTJ.fz(V(Lm().getType(), this.mPn));
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
        this.aSo = false;
        this.aTW = false;
        this.aTJ.onPause();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Object c;
        super.onStop();
        if (this.aTL != null && this.aTL.aeN() != null) {
            com.baidu.tbadk.distribute.a.Ag().a(getPageContext().getPageActivity(), "frs", this.aTL.aeN().getId(), 0L);
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
        if (i != 82 || this.aTD) {
            if (i == 4) {
                if (this.aUa.onBackPressed()) {
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
                com.baidu.tbadk.core.util.ay.uV().b(getPageContext(), new String[]{bVar.TX});
            } else if (bVar.rq()) {
                if (com.baidu.adp.lib.util.i.iN()) {
                    a(bVar, "area_download");
                    b(bVar, "download");
                    b(bVar, i);
                    return;
                }
                if (com.baidu.adp.lib.util.i.iM()) {
                    trim = getPageContext().getString(i.h.frs_network_tips);
                } else if (TextUtils.isEmpty(bVar.Ui.Uo.trim())) {
                    trim = getPageContext().getString(i.h.confirm_download_app);
                } else {
                    trim = bVar.Ui.Uo.trim();
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.ct(trim);
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
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", bVar.TZ);
                com.baidu.tbadk.download.b.An().a(bVar.TZ, bVar.TY, bVar.TV, i, com.baidu.adp.lib.g.b.g(bVar.TU, 0));
            } else {
                showToast(i.h.neterror);
            }
        }
    }

    public void Lb() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
        this.aTV = new a(this.aTB);
        this.aTV.setSelfExecute(true);
        this.aTV.execute(new String[0]);
    }

    public void Lc() {
        com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.aTL.aeN().getId(), true, true, true);
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Ag().a(getPageContext().getPageActivity(), bVar, str, "frs", this.aTL.aeN().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.b bVar, String str) {
        com.baidu.tbadk.distribute.a.Ag().a(bVar, this.forumId, 0L, "FRS", str);
    }

    public void Ld() {
        if (!fs(23013)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10177").ae(ImageViewerConfig.FORUM_ID, this.forumId));
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveListActivityConfig(getPageContext().getPageActivity(), String.valueOf(getForumId()), false, 0)));
        }
    }

    public void Le() {
        if (!fs(23019) && this.aTA != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveHeadlineActivityConfig(getPageContext().getPageActivity()).createConfig(String.valueOf(getForumId()), this.aTA.getTid(), 1)));
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
        ArrayList<com.baidu.adp.widget.ListView.u> threadList = this.aTL.getThreadList();
        if (threadList != null) {
            Iterator<com.baidu.adp.widget.ListView.u> it = threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.u next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.v) {
                    com.baidu.tbadk.core.data.v vVar = (com.baidu.tbadk.core.data.v) next;
                    if (vVar == this.aTv) {
                        b(vVar, i);
                        this.aTv = null;
                        break;
                    } else if (vVar.getId() != null && vVar.getId().equals(this.aSp)) {
                        b(vVar, i);
                        this.aSp = null;
                        break;
                    }
                }
            }
            this.aTJ.LZ().a(threadList, this.aTL);
            this.aTJ.LZ().notifyDataSetChanged();
        }
    }

    private void b(com.baidu.tbadk.core.data.v vVar, int i) {
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

    public void a(ef.a aVar, String str) {
        if (str != null) {
            Lm().av(aVar.aZp, str);
            this.aUa.NM();
            this.aTB = str;
            if (this.aTJ != null) {
                this.aTJ.setTitle(this.aTB);
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
        if (this.aTJ == null) {
            return null;
        }
        return this.aTJ.getListView();
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
        if (this.aTJ == null) {
            return 0;
        }
        return this.aTJ.LW();
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> vE() {
        if (this.aeH == null) {
            this.aeH = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.aeH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.aTM != null) {
                this.aTM.af(msgReplyme);
                this.aTM.ae(msgAtme);
                if (com.baidu.tbadk.coreExtra.messageCenter.c.xh().xy() && !TbadkCoreApplication.m411getInst().isMIUIRom()) {
                    this.aTM.ag((msgChat - newsNotifyMessage.getMsgPrivateChat()) - newsNotifyMessage.getMsgStrangerChat());
                } else {
                    this.aTM.ag(msgChat);
                }
                this.aTJ.a(this.aTM);
                this.aUa.a(this.aTM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        bb LZ;
        HashMap<Integer, com.baidu.tbadk.core.data.v> Lu;
        if (this.aTL != null && this.aTJ != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (LZ = this.aTJ.LZ()) != null && (Lu = LZ.Lu()) != null && Lu.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.v> entry : Lu.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.v value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.b) && TextUtils.equals(((com.baidu.tbadk.core.data.b) value).TZ, downloadData.getId())) {
                            int avK = this.aTL.avK();
                            if (LZ.aA(intValue + avK) instanceof com.baidu.tbadk.core.data.b) {
                                com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) LZ.aA(avK + intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    bVar.TT = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!com.baidu.tbadk.core.util.ar.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    bVar.TT = 0;
                                } else if (status == 1) {
                                    bVar.TT = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.aTJ.LQ();
        }
    }

    private void Lf() {
        HashMap<Integer, com.baidu.tbadk.core.data.v> Lu;
        if (this.aTJ != null && this.aTJ.LZ() != null && (Lu = this.aTJ.LZ().Lu()) != null) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.v> entry : Lu.entrySet()) {
                com.baidu.tbadk.core.data.v value = entry.getValue();
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
            int i2 = bVar.TT;
            if (i2 == 0) {
                a(bVar, i);
            } else if (i2 == 2) {
                com.baidu.tieba.frs.utils.a.H(getPageContext().getPageActivity(), bVar.TZ);
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_ck_app", null, 1, "app_name", bVar.TZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.b bVar) {
        if (bVar != null) {
            a(bVar, "btn_click");
            b(bVar, "click");
            com.baidu.tbadk.core.util.ay.uV().b(getPageContext(), new String[]{bVar.TX});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.aTJ.getRootView());
        showLoadingView(this.aTJ.getRootView(), true);
        this.aTJ.LY();
        this.aTJ.nw();
    }

    public com.baidu.tieba.tbadkCore.o Lh() {
        return this.aTL;
    }

    public boolean Li() {
        return this.aTJ.Li();
    }

    public void Lj() {
        FrsActivityStatic.aUP = false;
        FrsActivityStatic.aUR = false;
        KR();
    }

    public void Lk() {
        FrsActivityStatic.aUP = false;
        FrsActivityStatic.aUQ = false;
        KR();
    }

    public void Ll() {
        this.aTZ.Ll();
    }

    public com.baidu.tieba.frs.mc.a Lm() {
        return this.aTX;
    }

    public void a(bs bsVar) {
        this.aTJ = bsVar;
    }

    public void gN(String str) {
        this.aTB = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFlag(int i) {
        this.aTC = i;
    }

    public void setPn(int i) {
        this.mPn = i;
    }

    public void resetData() {
        this.aTw = false;
        this.aTI = false;
        this.aTL = null;
        this.aTJ.setTitle(this.aTB);
        this.aUa.cl(false);
        this.aUa.setIsManager(false);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (!com.baidu.adp.lib.util.k.jd()) {
            this.aTJ.Mg();
        } else if (this.aTX.Ng() == 1) {
            Ln();
            loadMore();
        } else if (this.aTX.hasMore()) {
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
        if (arrayList != null && arrayList.size() != 0 && (a2 = this.aUb.a(false, arrayList)) != null) {
            this.aTL.af(a2);
            this.aTJ.a(a2, this.mPn, this.aTL, 0);
        }
    }

    private void Ln() {
        if (this.aUc == 0 && !this.aUb.Z(this.aTL.avt())) {
            if (this.aTL.getThreadList() == null || this.aTL.getThreadList().size() == 0) {
                this.aTJ.Mg();
                return;
            } else {
                this.aTJ.Mf();
                return;
            }
        }
        this.aTJ.Me();
    }

    public void loadMore() {
        if (this.aTX.Ng() == 1) {
            if (!this.aUb.avB && !this.aTX.isLoading()) {
                if (this.aUb.Z(this.aTL.avt())) {
                    this.aTJ.a(this.aUb.MM(), this.mPn, this.aTL, 0);
                    this.aUb.a(com.baidu.adp.lib.g.b.c(this.forumId, 0L), this.aTL.avt());
                } else if (this.aUc != 0) {
                    this.aTJ.a(this.aUb.MM(), this.mPn, this.aTL, 0);
                    this.mPn++;
                    this.aTX.fK(this.mPn);
                    this.aUb.aZE = false;
                    this.aUb.aZF = 0;
                }
            }
        } else if (!this.aTX.Nk()) {
            if (this.aTY.NP() != null) {
                this.aTY.NP().a(this.aTX.Ng(), this.aTX.Nh(), this.aTX.Ni());
            }
            this.aTX.Hn();
        }
    }

    public void showShareDialog() {
        String name;
        if (this.aTL != null && this.aTL.aeN() != null) {
            if (this.aTL.aeN().getName() == null) {
                showToast(getPageContext().getString(i.h.no_forum_data));
                return;
            }
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String str = "http://tieba.baidu.com/f?kw=" + this.aTL.aeN().getName();
            Uri parse = this.aTL.aeN().getImage_url() == null ? null : Uri.parse(this.aTL.aeN().getImage_url());
            String slogan = this.aTL.aeN().getSlogan();
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = String.valueOf(name) + getPageContext().getString(i.h.forum);
            fVar.content = slogan;
            fVar.linkUrl = str;
            fVar.aiN = true;
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
        if (this.aUd == null) {
            this.aUd = new SparseArray<>(7);
            this.aUd.put(2, "frs_wx_timeline");
            this.aUd.put(3, "frs_wx_friend");
            this.aUd.put(4, "frs_qq_zone");
            this.aUd.put(5, "frs_tencent_weibo");
            this.aUd.put(6, "frs_sina_weibo");
        }
        return this.aUd;
    }

    private ShareFromFrsMsgData Lo() {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(this.aTL.aeN().getImage_url());
        shareFromFrsMsgData.setName(this.aTL.aeN().getName());
        shareFromFrsMsgData.setMemberNum(this.aTL.aeN().getMember_num());
        shareFromFrsMsgData.setPostNum(this.aTL.aeN().getPost_num());
        shareFromFrsMsgData.setContent(this.aTL.aeN().getSlogan());
        return shareFromFrsMsgData;
    }

    private void N(Intent intent) {
        a(Lo(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromFrsMsgData shareFromFrsMsgData, long j, String str, String str2) {
        if (this.aTL != null && this.aTL.aeN() != null) {
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
        if (this.aTL != null && this.aTL.aeN() != null) {
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
