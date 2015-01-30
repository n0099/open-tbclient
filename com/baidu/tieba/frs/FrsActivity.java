package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.FRSPageRequestMessage;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class FrsActivity extends BaseActivity<FrsActivity> implements com.baidu.adp.widget.BdSwitchView.c, com.baidu.tbadk.core.view.as, com.baidu.tbadk.core.voice.o, com.baidu.tieba.tbadkCore.am, com.baidu.tieba.tbadkCore.n {
    public static String aCJ;
    private static boolean isNeedRefreshOnResume;
    private com.baidu.adp.lib.e.b<TbImageView> NY;
    private com.baidu.tieba.tbadkCore.location.d aBF;
    private boolean aBI;
    private String aBJ;
    private String aBK;
    private com.baidu.tieba.tbadkCore.f.a aBM;
    private com.baidu.tbadk.core.data.x aCL;
    private cy aDl;
    private com.baidu.adp.lib.e.b<TbImageView> aDn;
    private ax aDr;
    private com.baidu.tbadk.core.data.x aDt;
    VoiceManager mVoiceManager;
    private static boolean aCN = true;
    private static boolean aCO = true;
    private static boolean aCP = true;
    public static boolean aAb = false;
    private static volatile long aDc = 0;
    private static volatile long aDd = 0;
    private static volatile int aDe = 0;
    public static final CustomMessageListener aDD = new as(2012111);
    private static final CustomMessageListener aDE = new at(2012112);
    private boolean aBG = false;
    private boolean aCK = true;
    private boolean aCM = false;
    private int mType = 3;
    private String aCQ = null;
    private String KT = null;
    private int aCR = 0;
    private int aCS = 1;
    private boolean aCT = false;
    private boolean aCU = false;
    private boolean aCV = false;
    private String aCW = null;
    private String mThreadId = null;
    private String forumId = null;
    private boolean aCX = false;
    private bp aCY = null;
    private String aCZ = null;
    private String aDa = null;
    private final com.baidu.tbadk.core.data.x aDb = null;
    private long aDf = 0;
    private boolean aDg = false;
    private com.baidu.tieba.tbadkCore.d.a aDh = null;
    private com.baidu.tieba.tbadkCore.e aDi = null;
    private com.baidu.tieba.tbadkCore.ac zm = null;
    private com.baidu.tieba.tbadkCore.au aDj = null;
    private df aDk = null;
    private String mPageType = "normal_page";
    private com.baidu.tbadk.core.data.x aDm = null;
    private boolean aDo = false;
    private long aDp = -1;
    private long aDq = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private WriteData aDs = new WriteData();
    private boolean aDu = true;
    private long agS = 0;
    private long createTime = 0;
    private long agT = 0;
    private boolean aDv = false;
    private boolean aDw = false;
    private boolean aDx = false;
    private com.baidu.tbadk.performanceLog.h aDy = null;
    public long aDz = System.currentTimeMillis();
    private CustomMessageListener aBO = new a(this, 2004004);
    private CustomMessageListener aDA = new l(this, 2001273);
    private CustomMessageListener aDB = new x(this, 2001197);
    private final com.baidu.tieba.tbadkCore.f.c aDC = new ai(this);
    public final CustomMessageListener aDF = new au(this, 2012111);
    private final com.baidu.tieba.tbadkCore.x aDG = new av(this);
    private com.baidu.tieba.tbadkCore.location.i aBQ = new aw(this);
    private com.baidu.tieba.tbadkCore.location.j aBR = new b(this);
    private final CustomMessageListener CL = new c(this, 2003003);
    private final CustomMessageListener mMemListener = new d(this, 2001200);
    private final com.baidu.adp.widget.ListView.g aAa = new e(this);
    private final View.OnClickListener aDH = new f(this);
    private final AbsListView.OnScrollListener aBS = new g(this);
    private final SlidingMenu.OnClosedListener aDI = new h(this);
    private final az aDJ = new i(this);
    private final com.baidu.tieba.tbadkCore.ao aBU = new com.baidu.tieba.tbadkCore.ao(getPageContext(), new j(this));
    private final SlidingMenu.OnOpenedListener aDK = new k(this);
    private final View.OnClickListener aDL = new m(this);
    private final View.OnClickListener aDM = new n(this);
    private final AdapterView.OnItemClickListener aDN = new o(this);
    private final com.baidu.tbadk.core.view.ad aDO = new p(this);
    private final CustomMessageListener aDP = new q(this, 0);
    private final com.baidu.adp.framework.listener.e aDQ = new r(this, 301001);
    private final HttpMessageListener aDR = new s(this, CmdConfigHttp.FRS_HTTP_CMD);
    private com.baidu.adp.widget.ListView.an aDS = new t(this);
    private View.OnClickListener aDT = new v(this);
    private View.OnClickListener aDU = new w(this);
    private com.baidu.adp.widget.ListView.ao aDV = new y(this);

    static {
        FP();
        FQ();
        Cd();
        MessageManager.getInstance().registerListener(aDD);
        MessageManager.getInstance().registerListener(aDE);
        com.baidu.tieba.tbadkCore.a.a.a(301001, FRSPageSocketResponsedMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.O(TbConfig.FRS_ADDRESS, 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.location.d.aii();
        isNeedRefreshOnResume = false;
    }

    private static void FP() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003000, new z());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void FQ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003001, new aa());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Cd() {
        com.baidu.tbadk.core.util.bm.pV().a(new ab());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m255getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean FR() {
        return !TbadkCoreApplication.m255getInst().isMIUIRom() && TbadkCoreApplication.m255getInst().isFloatingWindowOpened() && TbadkCoreApplication.m255getInst().getChatFloatWindowLocked();
    }

    public void FS() {
        if (!this.aDv) {
            this.aDv = true;
            this.agT = System.currentTimeMillis() - this.aDq;
            com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
            wVar.dX(1000);
            wVar.agK = this.aDz;
            wVar.agM = this.createTime;
            wVar.agT = this.agT;
            wVar.zs();
        }
    }

    public void e(com.baidu.tbadk.performanceLog.w wVar) {
        if (wVar != null) {
            wVar.agM = this.createTime;
            this.createTime = 0L;
            wVar.agK = this.aDz;
            wVar.agS = this.agS;
            wVar.agT = this.agT == 0 ? System.currentTimeMillis() - this.aDq : this.agT;
            wVar.zt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fp() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Fq() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.z.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m255getInst().getLocationShared()) {
            Fr();
        } else if (this.aBF.aih()) {
            Fp();
        } else {
            this.aBF.eE(false);
            if (this.aCY.FF() != null) {
                this.aCY.FF().setLocationViewVisibility(0);
                this.aCY.FF().setLocationInfoViewState(1);
            }
            this.aBF.aif();
        }
    }

    private void Fr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.by(com.baidu.tieba.z.location_app_permission_prompt).a(com.baidu.tieba.z.isopen, new ac(this)).b(com.baidu.tieba.z.cancel, new ad(this)).b(getPageContext());
        aVar.nX();
    }

    private void Fs() {
        PbEditor FF = this.aCY.FF();
        if (FF != null) {
            if (this.aBF.aij()) {
                FF.setLocationViewVisibility(0);
                if (this.aBF.aih()) {
                    this.aBQ.a(com.baidu.tieba.tbadkCore.location.c.aic().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.l.isNetOk()) {
                    FF.setLocationInfoViewState(1);
                    this.aBF.aif();
                    return;
                } else {
                    FF.setLocationInfoViewState(0);
                    return;
                }
            }
            FF.setLocationViewVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.e eVar) {
        if (eVar != null && eVar.aeN() != null) {
            this.aCY.GL().D(eVar.aeN().getRecommendForumData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.e eVar) {
        if (eVar != null && eVar.aeN() != null && TbadkCoreApplication.m255getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            if (this.aDi != null) {
                this.aDi.a(eVar.aeN().getAnchorPower());
            }
            this.aCY.f(eVar);
            ArrayList<LiveCardData> aeL = eVar.aeL();
            ArrayList<com.baidu.adp.widget.ListView.am> aeO = eVar.aeO();
            if (aeL != null && aeL.size() > 0 && aeO != null && aeO.size() > 0) {
                int size = aeO.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!(aeO.get(i) instanceof com.baidu.tbadk.core.data.m)) {
                        i++;
                    } else {
                        aeO.remove(i);
                        break;
                    }
                }
                int aeR = eVar.aeR();
                com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
                mVar.o(aeL);
                eVar.aeO().add(aeR, mVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aCJ = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (bundle != null) {
            this.aCQ = bundle.getString("name");
            this.KT = bundle.getString("from");
            this.aCR = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (intent != null) {
            this.aCQ = intent.getStringExtra("name");
            this.KT = intent.getStringExtra("from");
            this.aCR = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (intent != null) {
            this.aDp = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aDp = System.currentTimeMillis();
        }
        if (this.aDp != -1) {
            this.aDq = this.aDp;
        } else {
            this.aDq = System.currentTimeMillis();
        }
        if (!bH(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.aDq;
            return;
        }
        registerListener(this.CL);
        registerListener(this.mMemListener);
        registerListener(this.aDQ);
        registerListener(this.aDR);
        registerListener(this.aDF);
        registerListener(this.aBO);
        registerListener(this.aDB);
        registerListener(this.aDA);
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        this.aCY.jJ();
        this.aBU.setUniqueId(getUniqueId());
        this.aBU.registerListener();
        addGlobalLayoutListener();
        this.createTime = System.currentTimeMillis() - this.aDp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.aCY != null && this.aCY.FF() != null) {
            this.aCY.FF().afP();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onStart(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.tbadkCore.e eVar) {
        if (eVar != null) {
            try {
                if (eVar.CH() == 1) {
                    this.aCY.Hl().setFromCDN(true);
                } else {
                    this.aCY.Hl().setFromCDN(false);
                }
                this.aCY.a(eVar.aeN(), eVar.getUserData());
                if (eVar.aeP().aeU() == 1) {
                    this.mPageType = "frs_page";
                    this.aCY.N(eVar.getUserData().getIsMem(), this.aDi.aeN().isLike());
                } else {
                    this.mPageType = "normal_page";
                    this.aCY.M(eVar.getUserData().getIsMem(), this.aDi.aeN().isLike());
                }
                this.aCY.GS();
                this.aCQ = eVar.aeN().getName();
                this.forumId = eVar.aeN().getId();
                this.aCY.setTitle(this.aCQ);
                Ga();
                eVar.aeS();
                eVar.av(getPageContext().getPageActivity());
                eVar.aeT();
                b(eVar);
                com.baidu.tbadk.core.data.z top_notice_data = eVar.aeN().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.getTitle() != null) {
                    com.baidu.tbadk.core.data.x xVar = new com.baidu.tbadk.core.data.x();
                    xVar.setTitle(top_notice_data.getTitle());
                    xVar.bu(2);
                    xVar.bQ(top_notice_data.nR());
                    xVar.parser_title();
                    eVar.d(xVar);
                }
                ArrayList<com.baidu.adp.widget.ListView.am> aeO = eVar.aeO();
                if (aeO != null) {
                    this.aCY.a(aeO, this.aCS, this.aDi, eVar.na().mY());
                    Gh();
                    this.aCY.eZ(this.aCS);
                    if (this.mPageType.equals("frs_page")) {
                        this.aCY.a(eVar.aeN(), eVar);
                    } else if (this.mPageType.equals("normal_page")) {
                        this.aCY.b(eVar.aeN(), eVar);
                    }
                    this.aCY.Hf();
                    this.aCY.eU(0);
                }
                if (eVar.aeM()) {
                    if (this.aCY.GQ() != null) {
                        this.aCY.GQ().HH();
                    }
                    if (this.aCY.GR() != null) {
                        this.aCY.GR().HH();
                    }
                } else {
                    if (this.aCY.GQ() != null) {
                        this.aCY.GQ().HG();
                    }
                    if (this.aCY.GR() != null) {
                        this.aCY.GR().HG();
                    }
                }
                hideLoadingView(this.aCY.getRootView());
                this.aCM = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void initData(Bundle bundle) {
        FW();
        this.aCV = TbadkCoreApplication.isLogin();
        if (bundle != null) {
            this.aCQ = bundle.getString("name");
            this.KT = bundle.getString("from");
            this.aCR = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            this.aCQ = intent.getStringExtra("name");
            this.KT = intent.getStringExtra("from");
            this.aCR = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            this.aDg = intent.getBooleanExtra(FrsActivityConfig.GOOD, false);
        }
        if (this.aCQ != null && this.aCQ.length() > 0) {
            if (this.KT == null || this.KT.length() <= 0) {
                this.KT = FrsActivityConfig.FRS_FROM_LIKE;
            }
            this.aCZ = this.KT;
            kC();
            FT();
            FU();
            this.aDl = new cy(getPageContext().getPageActivity());
            if (this.aCV) {
                FV();
                FX();
            }
            if (bundle != null) {
                this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
                this.aBK = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            this.writeImagesInfo.setMaxImagesAllowed(10);
            this.aBM = new com.baidu.tieba.tbadkCore.f.a(this);
            this.aBM.a(this.aDC);
            this.aBF = new com.baidu.tieba.tbadkCore.location.d(this);
            this.aBF.a(this.aBQ);
            this.aBF.a(this.aBR);
        }
    }

    private void kC() {
        this.zm = new com.baidu.tieba.tbadkCore.ac(getPageContext());
        this.zm.setLoadDataCallBack(new ae(this));
    }

    private void FT() {
        this.aDj = new com.baidu.tieba.tbadkCore.au();
        this.aDj.setFrom(PbActivityConfig.KEY_FROM_FRS);
        this.aDj.a(new af(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        new ag(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void FU() {
        this.aDk = new df(this);
        this.aDk.setLoadDataCallBack(new ah(this));
    }

    public void FV() {
        if (this.aDl != null && this.aCY != null) {
            if (aCN || aCO || aCP) {
                this.aDl.L(com.baidu.tbadk.coreExtra.messageCenter.a.rY().getMsgReplyme());
                this.aDl.K(com.baidu.tbadk.coreExtra.messageCenter.a.rY().getMsgAtme());
                int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.rY().getMsgChat();
                if (TbadkCoreApplication.m255getInst().getChatFloatWindowLocked() && !TbadkCoreApplication.m255getInst().isMIUIRom()) {
                    msgChat -= com.baidu.tbadk.coreExtra.messageCenter.a.rY().sf();
                }
                this.aDl.M(msgChat);
                this.aCY.a(this.aDl, aCN, aCO, aCP);
            }
        }
    }

    private void FW() {
        registerListener(2001122, this.aDP);
    }

    private void FX() {
        registerListener(2001124, this.aDP);
    }

    private boolean bH(boolean z) {
        if (z && com.baidu.tieba.frs.utils.a.G(getPageContext().getPageActivity(), getClass().getName())) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.aCY != null) {
            this.aCY.onDestroy();
        }
        if (this.aDy != null) {
            this.aDy.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.aDi != null) {
                this.aDi.clear();
            }
            if (this.zm != null) {
                this.zm.Hx();
            }
            if (this.aDk != null) {
                this.aDk.Hx();
            }
            if (this.aBM != null) {
                this.aBM.cancelLoadData();
            }
            this.aCY.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
        if (this.aDr != null) {
            this.aDr.cancel(true);
            this.aDr = null;
        }
        if (this.aDh != null) {
            this.aDh.destory();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aCQ);
        bundle.putString("from", this.KT);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aBK);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.x ib;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    eI(0);
                    return;
                case 11002:
                    kD();
                    return;
                case 11011:
                    b(this.aDb);
                    return;
                case 11012:
                    c(this.aDm);
                    return;
                case 11014:
                    Gf();
                    return;
                case 11016:
                    this.aCY.He();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    Ge();
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            K(intent);
                            return;
                        } else {
                            J(intent);
                            return;
                        }
                    }
                    return;
                case 12004:
                    ArrayList<String> W = com.baidu.tieba.tbadkCore.util.i.W(intent);
                    if (W != null) {
                        this.aCY.A(W);
                        return;
                    }
                    return;
                case 12006:
                    WriteData Ft = this.aBM.Ft();
                    if (Ft != null) {
                        Ft.deleteUploadedTempImages();
                    }
                    this.aDs.setIsBaobao(false);
                    this.aDs.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.aBM.c((WriteData) null);
                    this.aBM.eF(false);
                    this.aCY.bG(true);
                    if (this.aDt != null) {
                        com.baidu.tieba.tbadkCore.al.b(this.aDt.getTid(), (WriteData) null);
                        this.aDt.setReply_num(this.aDt.getReply_num() + 1);
                    }
                    if (this.writeImagesInfo != null) {
                        this.aCY.a(this.writeImagesInfo, true);
                    }
                    this.aCY.GT();
                    this.aCY.FH();
                    return;
                case 12012:
                    L(intent);
                    return;
                case 12013:
                    N(intent);
                    return;
                case 13003:
                    refresh();
                    return;
                case 18003:
                    this.aCY.Hl().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (ib = this.aDi.ib(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            ib.bv(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            ib.parser_title();
                            refresh();
                            return;
                        } else if (intExtra == 0) {
                            this.aDi.e(ib);
                            this.aCY.Hf();
                            if (com.baidu.tieba.tbadkCore.d.aeH() != null) {
                                com.baidu.tieba.tbadkCore.d.aeH().B(this.aCQ, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    Gd();
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    Fu();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        String stringExtra2 = intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID);
                        if (this.writeImagesInfo != null) {
                            this.writeImagesInfo.setLastAlbumId(stringExtra2);
                            return;
                        }
                        return;
                    }
                    return;
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
        this.mHandler.postDelayed(new aj(this), 10L);
        this.aBI = true;
        this.aDu = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.aCY.jJ();
        } else if (aAb) {
            aAb = false;
            this.aCY.jJ();
        } else {
            if (!this.aCV && TbadkCoreApplication.isLogin()) {
                this.aCV = true;
                if (this.aDi != null && this.aDi.mR() != null) {
                    this.aDi.mR().setIfpost(1);
                }
                refresh();
            }
            this.mVoiceManager = getVoiceManager();
            this.mVoiceManager.onResume(getPageContext());
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.aCQ = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.KT = intent.getStringExtra("from");
            }
            this.aCU = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aCU) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    FY();
                } else {
                    FZ();
                }
            }
        }
    }

    private void FY() {
        this.aCY.jJ();
        this.aCY.GM().showContent(false);
    }

    private void FZ() {
        this.aCY.jJ();
        this.aCY.GM().toggle(false);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.KT)) {
                sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            } else {
                com.baidu.tbadk.core.b.b.e(getPageContext().getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.KT)) {
            sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        } else {
            com.baidu.tbadk.core.b.b.e(getPageContext().getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.KT)) {
            finish();
        }
    }

    private void initUI() {
        this.aCS = 1;
        this.aDg = false;
        this.aDf = 0L;
        this.mType = 3;
        if (TextUtils.isEmpty(this.aCQ)) {
            this.aCQ = "";
        }
        if (TextUtils.isEmpty(this.KT)) {
            this.KT = "";
        }
        setContentView(com.baidu.tieba.x.frs_activity);
        this.aCY = new bp(this, this.aDH);
        this.aCY.Hl().i(this.aDL);
        this.aCY.Hl().j(this.aDM);
        if (this.aCR == 0) {
            this.aCY.setTitle(this.aCQ);
        } else {
            this.aCY.setTitle("");
            this.aCR = 1;
        }
        this.aCY.a(this.aDS);
        this.aCY.a(this.aDV);
        this.aCY.k(this.aDT);
        this.aCY.m(this.aDU);
        this.aCY.setOnScrollListener(this.aBS);
        this.aCY.a(this.aAa);
        this.aCY.a(this.aDI);
        this.aCY.a(this.aDK);
        this.aCY.f(this.aDO);
        this.aCY.Hl().a(this.aDJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aCY.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public com.baidu.adp.lib.e.b<TbImageView> Fw() {
        if (this.aDn == null) {
            this.aDn = FrsCommonImageLayout.k(getPageContext().getPageActivity(), 9);
        }
        return this.aDn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD(String str) {
        Intent I;
        com.baidu.tieba.frs.view.o GR;
        if (str != null && (I = com.baidu.tieba.frs.utils.a.I(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(com.baidu.tieba.z.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", I);
            BarImageView barImageView = null;
            if (this.mPageType.equals("normal_page")) {
                FrsHeaderView GQ = this.aCY.GQ();
                if (GQ != null) {
                    barImageView = GQ.HC();
                }
            } else if (this.mPageType.equals("frs_page") && (GR = this.aCY.GR()) != null) {
                barImageView = GR.HC();
            }
            if (barImageView != null && barImageView.getBdImage() != null && barImageView.getBdImage().jj() != null) {
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.c.eR().a(com.baidu.adp.lib.util.c.eR().d(barImageView.getBdImage().jj(), getResources().getDimensionPixelSize(com.baidu.tieba.u.ds100)), getResources().getDimensionPixelSize(com.baidu.tieba.u.ds32)));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), com.baidu.tieba.v.icon));
            }
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            if (this.aDi != null && this.aDi.mR() != null) {
                this.aDi.mR().setIfpost(1);
            }
            if (i == 0) {
                sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11001)));
            } else {
                sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11016)));
            }
        } else if (this.aDi != null) {
            if (i == 0) {
                AntiData mR = this.aDi.mR();
                if (AntiHelper.c(mR) || AntiHelper.d(mR) || AntiHelper.e(mR)) {
                    mR.setBlock_forum_name(this.aCQ);
                    mR.setBlock_forum_id(this.aDi.aeN().getId());
                    mR.setUser_name(this.aDi.getUserData().getUserName());
                    mR.setUser_id(this.aDi.getUserData().getUserId());
                    if (AntiHelper.a(getPageContext().getPageActivity(), mR, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (this.aDi.mR() != null && this.aDi.mR().getIfpost() == 0) {
                    com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), mR.getForbid_info());
                    return;
                }
                int i2 = 0;
                if (this.aDi.getUserData() != null) {
                    i2 = this.aDi.getUserData().getIsMem();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(getPageContext().getPageActivity(), 0, this.aDi.aeN().getId(), this.aCQ, null, null, 0, this.aDi.mR(), 13003, false, false, null, false, false, null, null, this.aDi.aeN().getPrefixData(), i2)));
                return;
            }
            this.aCY.He();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.x xVar) {
        boolean nM = xVar == null ? true : xVar.nM();
        this.aCY.a(new ak(this, xVar));
        this.aCY.a(xVar, nM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.x xVar) {
        boolean nM = xVar == null ? true : xVar.nM();
        if (this.mThreadId != null) {
            if (!nM) {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(xVar, this.aCQ, null, 18003, true, true, this.aCX)));
            } else {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(xVar, this.aCQ, null, 18003, false, false, this.aCX)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.x xVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(xVar, this.aCQ, null, 18003, false, false, this.aCX)));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aCY != null && z && this.aCK) {
            this.aCK = false;
            showLoadingView(this.aCY.getRootView(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        stopVoice();
        this.aCS = 1;
        eJ(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(int i) {
        boolean z = false;
        this.mType = i;
        switch (this.mType) {
            case 1:
                if (this.aCY.Hl().Go()) {
                    return;
                }
                break;
            case 2:
                if (this.aCY.Hl().Gp()) {
                    return;
                }
                break;
            case 3:
                if (this.aCY.GP()) {
                    return;
                }
                break;
        }
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(this.aCQ);
        fRSPageRequestMessage.setPn(this.aCS);
        if (this.aDi == null) {
            this.aDi = new com.baidu.tieba.tbadkCore.e();
        }
        fRSPageRequestMessage.setForumModel(this.aDi);
        if (com.baidu.tbadk.core.l.mc().mg()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        if (this.aDg) {
            fRSPageRequestMessage.setIsGood(1);
            fRSPageRequestMessage.setCid((int) this.aDf);
        }
        int M = com.baidu.adp.lib.util.l.M(getPageContext().getPageActivity());
        int N = com.baidu.adp.lib.util.l.N(getPageContext().getPageActivity());
        float f = M / 320.0f;
        int i2 = com.baidu.tbadk.core.util.bg.pI().pK() ? 2 : 1;
        fRSPageRequestMessage.setScrW(M);
        fRSPageRequestMessage.setScrH(N);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i2);
        fRSPageRequestMessage.setLastId(this.aCW);
        if (this.aCZ != null) {
            fRSPageRequestMessage.setStType(this.aCZ);
            if (this.aCZ.equalsIgnoreCase("sidebar")) {
                fRSPageRequestMessage.setStType(this.aDa);
            }
        }
        if (aDc != 0) {
            fRSPageRequestMessage.setCtime((int) aDc);
        }
        if (aDd != 0) {
            fRSPageRequestMessage.setDataSize((int) aDd);
        }
        if (aDe != 0) {
            fRSPageRequestMessage.setNetError(aDe);
        }
        this.aCY.bP(true);
        this.aCY.Hl().bK(false);
        this.aCY.Hl().bL(false);
        this.aCY.Hl().notifyDataSetChanged();
        if (this.aCS == 1 && ((this.mPageType.equals("normal_page") || this.mPageType.equals("frs_page")) && !this.aDg)) {
            z = true;
        }
        if (this.aDi == null) {
            this.aDi = new com.baidu.tieba.tbadkCore.e();
        }
        this.aDi.a(this.aDG);
        this.aDi.a(this, fRSPageRequestMessage, this.mType, z, this.aCQ);
        if (this.aDh == null) {
            this.aDh = new com.baidu.tieba.tbadkCore.d.a("frsStat");
            this.aDh.start();
        }
    }

    private void Ga() {
        switch (this.aCR) {
            case 1:
                com.baidu.adp.lib.g.l.ek().c(new al(this));
                break;
        }
        this.aCR = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gb() {
        stopVoice();
        try {
            if (this.aDi != null) {
                this.aCY.GS();
                this.aCQ = this.aDi.aeN().getName();
                this.forumId = this.aDi.aeN().getId();
                this.aCY.setTitle(this.aCQ);
                TbadkCoreApplication.m255getInst().setDefaultBubble(this.aDi.getUserData().getBimg_url());
                TbadkCoreApplication.m255getInst().setDefaultBubbleEndTime(this.aDi.getUserData().getBimg_end_time());
                Ga();
                ArrayList<com.baidu.adp.widget.ListView.am> aeO = this.aDi.aeO();
                if (aeO != null) {
                    this.aCY.a(aeO, this.aCS, this.aDi, this.aDi.na().mY());
                    Gh();
                    this.aCY.eZ(this.aCS);
                    if (this.mPageType.equals("frs_page")) {
                        Gc();
                    } else if (this.mPageType.equals("normal_page")) {
                        this.aCY.b(this.aDi.aeN(), this.aDi);
                    }
                    this.aCY.Hf();
                    if (this.aDi.CH() == 1) {
                        this.aCY.Hl().setFromCDN(true);
                    } else {
                        this.aCY.Hl().setFromCDN(false);
                    }
                    this.aCY.eU(L(this.mType, this.aCS));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int L(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aBI = false;
        this.aDu = false;
        this.aCY.onPause();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
        Fv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.distribute.a.uU().a(getPageContext().getPageActivity(), "frs", this.aDi.aeN().getId(), 0L);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.aCT) {
            if (i == 4) {
                if (this.aCY.GM().isMenuShowing()) {
                    this.aCY.GM().toggle(true);
                    if (this.aCY.GL().Hu()) {
                        this.aCY.GL().bX(false);
                        refresh();
                        return true;
                    }
                    return true;
                } else if (this.aCY.FF() != null && this.aCY.FF().isVisible()) {
                    this.aCY.FH();
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

    public void a(com.baidu.tbadk.core.data.c cVar, int i) {
        String trim;
        if (cVar != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            aVar.bx(com.baidu.tieba.z.anti_title);
            if (cVar.mw()) {
                com.baidu.tbadk.core.util.bm.pV().b(getPageContext(), new String[]{cVar.Dq});
            } else if (cVar.mv()) {
                if (com.baidu.adp.lib.util.i.ff() && !com.baidu.adp.lib.util.i.fg()) {
                    trim = getPageContext().getString(com.baidu.tieba.z.frs_network_tips);
                } else if (TextUtils.isEmpty(cVar.DB.DH.trim())) {
                    trim = getPageContext().getString(com.baidu.tieba.z.confirm_download_app);
                } else {
                    trim = cVar.DB.DH.trim();
                }
                aVar.bW(trim);
                aVar.a(com.baidu.tieba.z.alert_yes_button, new am(this, cVar, i));
                aVar.b(com.baidu.tieba.z.alert_no_button, new an(this));
                aVar.b(getPageContext()).nX();
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar != null) {
            if (!cVar.mu()) {
                com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), com.baidu.tieba.z.pb_app_error);
            } else if (UtilHelper.isNetOk()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", cVar.Ds);
                com.baidu.tbadk.download.b.vb().a(cVar.Ds, cVar.Dr, cVar.Do, i, com.baidu.adp.lib.g.c.toInt(cVar.Dn, 0));
            } else {
                showToast(com.baidu.tieba.z.neterror);
            }
        }
    }

    private void Gc() {
        this.aCY.a(this.aDi.aeN(), this.aDi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gd() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.aDi.aeN().getId(), true, true, false, true, true)));
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.uU().a(getPageContext().getPageActivity(), cVar, str, "frs", this.aDi.aeN().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.uU().a(cVar, this.forumId, 0L, "FRS", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kD() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11002)));
            return;
        }
        if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.KT)) {
            this.zm.setFrom(FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
        } else {
            this.zm.setFrom(PbActivityConfig.KEY_FROM_FRS);
        }
        this.zm.aQ(this.aDi.aeN().getName(), this.aDi.aeN().getId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ge() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
        builder.setMessage(getPageContext().getString(com.baidu.tieba.z.attention_cancel_info));
        builder.setTitle(getPageContext().getString(com.baidu.tieba.z.alert_title));
        builder.setPositiveButton(getPageContext().getString(com.baidu.tieba.z.attention_cancel), new ao(this));
        builder.setNegativeButton(getPageContext().getString(com.baidu.tieba.z.cancel), new ap(this));
        com.baidu.adp.lib.g.k.a(builder.create(), getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Gf() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11014)));
            return;
        }
        if (this.mPageType.equals("normal_page")) {
            this.aCY.GX();
        } else if (this.mPageType.equals("frs_page")) {
            this.aCY.GZ();
        }
        this.aDk.aq(this.aDi.aeN().getName(), this.aDi.aeN().getId());
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.aCY.GL().Ht()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TbadkCoreApplication.m255getInst().getSkinType() != 1) {
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_night_mode", "frsclick", 1, new Object[0]);
                    TbadkCoreApplication.m255getInst().setSkinType(1);
                    this.mSkinType = 1;
                    TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                } else {
                    return;
                }
            } else if (TbadkCoreApplication.m255getInst().getSkinType() != 0) {
                TbadkCoreApplication.m255getInst().setSkinType(0);
                this.mSkinType = 0;
            } else {
                return;
            }
            onChangeSkinType(this.mSkinType);
            com.baidu.tbadk.core.util.d.eS();
            TbadkCoreApplication.m255getInst().resetPbRecorder();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(int i) {
        ArrayList<com.baidu.adp.widget.ListView.am> aeO = this.aDi.aeO();
        if (aeO != null) {
            Iterator<com.baidu.adp.widget.ListView.am> it = aeO.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.am next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.x) {
                    com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) next;
                    if (xVar == this.aCL) {
                        a(xVar, i);
                        this.aCL = null;
                        break;
                    } else if (xVar.getId() != null && xVar.getId().equals(this.aBJ)) {
                        a(xVar, i);
                        this.aBJ = null;
                        break;
                    }
                }
            }
            this.aCY.Hl().a(aeO, this.aDi);
            this.aCY.Hl().notifyDataSetChanged();
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

    public void Gg() {
        if (this.aDi != null && this.aDi.aeN() != null && this.aDi.aeN().getBannerListData() != null) {
            String mB = this.aDi.aeN().getBannerListData().mB();
            if (!TextUtils.isEmpty(mB)) {
                this.aCW = mB;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE(String str) {
        if (str != null) {
            if (this.aCY.GM().isMenuShowing()) {
                this.aCY.GM().toggle(true);
            }
            this.aDg = false;
            this.aCQ = str;
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.voice.o
    public VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.as
    public BdListView getListView() {
        if (this.aCY == null) {
            return null;
        }
        return this.aCY.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVoice() {
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.as
    public int qO() {
        if (this.aCY == null) {
            return 0;
        }
        return this.aCY.Fn();
    }

    @Override // com.baidu.tbadk.core.view.as
    public com.baidu.adp.lib.e.b<TbImageView> qP() {
        if (this.NY == null) {
            this.NY = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.NY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.aDl != null) {
                this.aDl.L(msgReplyme);
                this.aDl.K(msgAtme);
                if (TbadkCoreApplication.m255getInst().getChatFloatWindowLocked() && !TbadkCoreApplication.m255getInst().isMIUIRom()) {
                    this.aDl.M((msgChat - newsNotifyMessage.getMsgPrivateChat()) - newsNotifyMessage.getMsgStrangerChat());
                } else {
                    this.aDl.M(msgChat);
                }
                this.aCY.a(this.aDl, aCN, aCO, aCP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        ay Hl;
        HashMap<Integer, com.baidu.tbadk.core.data.x> Gq;
        if (this.aDi != null && this.aCY != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (Hl = this.aCY.Hl()) != null && (Gq = Hl.Gq()) != null && Gq.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.x> entry : Gq.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.x value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.c) && TextUtils.equals(((com.baidu.tbadk.core.data.c) value).Ds, downloadData.getId())) {
                            if (Hl.aD(intValue) instanceof com.baidu.tbadk.core.data.c) {
                                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) Hl.aD(intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    cVar.Dm = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!com.baidu.tbadk.core.util.bf.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    cVar.Dm = 0;
                                } else if (status == 1) {
                                    cVar.Dm = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.aCY.GT();
        }
    }

    private void Gh() {
        HashMap<Integer, com.baidu.tbadk.core.data.x> Gq;
        if (this.aCY != null && this.aCY.Hl() != null && (Gq = this.aCY.Hl().Gq()) != null) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.x> entry : Gq.entrySet()) {
                com.baidu.tbadk.core.data.x value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.c)) {
                    arrayList.add((com.baidu.tbadk.core.data.c) value);
                }
            }
            com.baidu.tbadk.download.b.vb().v(arrayList);
        }
    }

    public void a(int i, com.baidu.tbadk.core.data.x xVar, int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 0)));
            return;
        }
        if (this.aDt != xVar && xVar != null) {
            Fv();
            this.aCY.fC(null);
            this.writeImagesInfo = new WriteImagesInfo();
            this.writeImagesInfo.setMaxImagesAllowed(10);
            this.aCY.a(this.writeImagesInfo, true);
            this.aBM.c((WriteData) null);
            this.aBM.eF(false);
            this.aCY.FN();
            com.baidu.tieba.tbadkCore.al.a(xVar.getTid(), this);
        }
        this.aDt = xVar;
        this.aCY.a(i, xVar, i2);
        Fs();
    }

    public void Gi() {
        if (this.aCY != null) {
            this.aCY.setOnActionListener(new aq(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Boolean bool) {
        this.aCY.bV(com.baidu.tieba.tbadkCore.aa.b(this.aDi.aeN().getName(), bool));
    }

    private void J(Intent intent) {
        a(intent, true);
    }

    private void K(Intent intent) {
        int size;
        if (this.writeImagesInfo != null) {
            M(intent);
            int size2 = this.writeImagesInfo.size() - 1;
            if (size2 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size2)));
            }
        }
    }

    private void M(Intent intent) {
        this.aBK = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        this.writeImagesInfo.addChooseFile(com.baidu.tieba.frs.utils.a.J(getPageContext().getPageActivity(), this.aBK));
        this.writeImagesInfo.updateQuality();
        this.aCY.a(this.writeImagesInfo, true);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0 && this.aCY.FF() != null) {
            this.aCY.FF().hQ(23);
        }
    }

    private void L(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    this.aCY.a(this.writeImagesInfo, z);
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0 && this.aCY.FF() != null) {
                this.aCY.FF().hQ(23);
            }
        }
    }

    private void Fu() {
        new ar(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(String str) {
        if (this.aBM.Ft() == null) {
            WriteData Ft = Ft();
            Ft.setWriteImagesInfo(this.writeImagesInfo);
            this.aBM.eF(this.writeImagesInfo.size() > 0);
            this.aBM.c(Ft);
        }
        if (this.aBM.Ft() != null) {
            if (this.aDs.getIsBaobao()) {
                this.aBM.Ft().setIsBaobao(true);
                this.aBM.Ft().setBaobaoContent(this.aDs.getBaobaoContent());
                this.aBM.Ft().setBaobaoImagesInfo(this.baobaoImagesInfo);
            } else {
                this.aBM.Ft().setIsBaobao(false);
                this.aBM.Ft().setBaobaoContent("");
                this.baobaoImagesInfo.clear();
            }
            if (this.aCY.FF() != null) {
                this.aBM.Ft().setHasLocationData(this.aCY.FF().getLocationInfoViewState() == 2);
            }
            VoiceData.VoiceModel audioData = this.aCY.getAudioData();
            this.aBM.Ft().setIsFrsReply(true);
            this.aBM.Ft().setContent(this.aCY.FM());
            this.aCY.FO();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.aBM.Ft().setVoice(audioData.getId());
                    this.aBM.Ft().setVoiceDuringTime(audioData.duration);
                } else {
                    this.aBM.Ft().setVoice(null);
                    this.aBM.Ft().setVoiceDuringTime(-1);
                }
            } else {
                this.aBM.Ft().setVoice(null);
                this.aBM.Ft().setVoiceDuringTime(-1);
            }
            if (!this.aBM.aiG()) {
                showToast(com.baidu.tieba.z.write_img_limit);
            } else if (this.aBM.aiF()) {
                showProgressBar();
            }
        }
    }

    private WriteData Ft() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.aDi.aeN().getId());
        writeData.setForumName(this.aDi.aeN().getName());
        writeData.setThreadId(this.aDt.getTid());
        writeData.setIsAd(false);
        writeData.setType(1);
        return writeData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.aDt.nu());
            antiData.setBlock_forum_id(this.aDi.aeN().getId());
            antiData.setUser_name(this.aDt.getAuthor().getUserName());
            antiData.setUser_id(this.aDt.getAuthor().getUserId());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, com.baidu.tieba.tbadkCore.f.f fVar) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.aDt.nu());
            antiData.setBlock_forum_id(this.aDi.aeN().getId());
            antiData.setUser_name(this.aDt.getAuthor().getUserName());
            antiData.setUser_id(this.aDt.getAuthor().getUserId());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.tieba.tbadkCore.f.g.d(getPageContext().getPageActivity(), fVar.getErrorString(), fVar.aiI(), fVar.aiJ());
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void a(WriteData writeData) {
        if (writeData != null && this.aDt != null && writeData.getThreadId().equals(this.aDt.getTid())) {
            if (!com.baidu.tbadk.core.util.bf.isEmpty(writeData.getContent()) && com.baidu.tbadk.core.util.bf.isEmpty(this.aCY.FM())) {
                this.aCY.fC(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                this.aCY.a(this.writeImagesInfo, true);
            }
            if (TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.aDs.setIsBaobao(writeData.getIsBaobao());
                this.aDs.setBaobaoContent(writeData.getBaobaoContent());
                this.aCY.setBaobaoUris(this.baobaoImagesInfo);
            }
        }
    }

    public void Gj() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    private void Fv() {
        if (this.aDt != null) {
            WriteData Ft = this.aBM.Ft();
            if (Ft == null) {
                Ft = new WriteData(1);
                Ft.setThreadId(this.aDt.getTid());
                Ft.setWriteImagesInfo(this.writeImagesInfo);
            }
            Ft.setContent(this.aCY.FM());
            if (this.aDs != null && this.aDs.getIsBaobao()) {
                Ft.setBaobaoContent(this.aDs.getBaobaoContent());
                Ft.setBaobaoImagesInfo(this.baobaoImagesInfo);
                Ft.setIsBaobao(true);
            }
            com.baidu.tieba.tbadkCore.al.b(this.aDt.getTid(), Ft);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    private void N(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            if (stringExtra != null && stringExtra2 != null) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(stringExtra);
                this.baobaoImagesInfo.clear();
                this.baobaoImagesInfo.addChooseFile(imageFileInfo);
                this.aCY.setBaobaoUris(this.baobaoImagesInfo);
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    if (this.aCY.FF() != null) {
                        this.aCY.FF().hQ(48);
                    }
                    this.aDs.setIsBaobao(true);
                    this.aDs.setBaobaoContent(stringExtra2);
                    this.aDs.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.aDs.setIsBaobao(false);
                this.aDs.setBaobaoContent("");
                this.aDs.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.aCY.getRootView());
        showLoadingView(this.aCY.getRootView(), true);
        this.aCY.jJ();
    }
}
