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
public class FrsActivity extends BaseActivity<FrsActivity> implements com.baidu.adp.widget.BdSwitchView.c, com.baidu.tbadk.core.view.ar, com.baidu.tbadk.core.voice.o, com.baidu.tieba.tbadkCore.am, com.baidu.tieba.tbadkCore.n {
    public static String aBI;
    private static boolean isNeedRefreshOnResume;
    private com.baidu.adp.lib.e.b<TbImageView> Ny;
    private com.baidu.tieba.tbadkCore.location.d aAD;
    private boolean aAG;
    private String aAH;
    private String aAI;
    private com.baidu.tieba.tbadkCore.f.a aAK;
    private com.baidu.tbadk.core.data.w aBK;
    private cx aCk;
    private com.baidu.adp.lib.e.b<TbImageView> aCm;
    private ay aCq;
    private com.baidu.tbadk.core.data.w aCs;
    VoiceManager mVoiceManager;
    private static boolean aBM = true;
    private static boolean aBN = true;
    private static boolean aBO = true;
    public static boolean azb = false;
    private static volatile long aCb = 0;
    private static volatile long aCc = 0;
    private static volatile int aCd = 0;
    public static final CustomMessageListener aCC = new at(2012111);
    private static final CustomMessageListener aCD = new au(2012112);
    private boolean aAE = false;
    private boolean aBJ = true;
    private boolean aBL = false;
    private int mType = 3;
    private String aBP = null;
    private String mFrom = null;
    private int aBQ = 0;
    private int aBR = 1;
    private boolean aBS = false;
    private boolean aBT = false;
    private boolean aBU = false;
    private String aBV = null;
    private String mThreadId = null;
    private String forumId = null;
    private boolean aBW = false;
    private bq aBX = null;
    private String aBY = null;
    private String aBZ = null;
    private final com.baidu.tbadk.core.data.w aCa = null;
    private long aCe = 0;
    private boolean aCf = false;
    private com.baidu.tieba.tbadkCore.d.a aCg = null;
    private com.baidu.tieba.tbadkCore.e aCh = null;
    private com.baidu.tieba.tbadkCore.ac zm = null;
    private com.baidu.tieba.tbadkCore.au aCi = null;
    private de aCj = null;
    private String mPageType = "normal_page";
    private com.baidu.tbadk.core.data.w aCl = null;
    private boolean aCn = false;
    private long aCo = -1;
    private long aCp = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private WriteData aCr = new WriteData();
    private boolean aCt = true;
    private long agu = 0;
    private long createTime = 0;
    private long agv = 0;
    private boolean aCu = false;
    private boolean aCv = false;
    private boolean aCw = false;
    private com.baidu.tbadk.performanceLog.h aCx = null;
    public long aCy = System.currentTimeMillis();
    private CustomMessageListener aAM = new a(this, 2004004);
    private CustomMessageListener aCz = new l(this, 2001273);
    private CustomMessageListener aCA = new x(this, 2001197);
    private final com.baidu.tieba.tbadkCore.f.c aCB = new ai(this);
    public final CustomMessageListener aCE = new av(this, 2012111);
    private final com.baidu.tieba.tbadkCore.x aCF = new aw(this);
    private com.baidu.tieba.tbadkCore.location.i aAO = new ax(this);
    private com.baidu.tieba.tbadkCore.location.j aAP = new b(this);
    private final CustomMessageListener CL = new c(this, 2003003);
    private final CustomMessageListener mMemListener = new d(this, 2001200);
    private final com.baidu.adp.widget.ListView.g aza = new e(this);
    private final View.OnClickListener aCG = new f(this);
    private final AbsListView.OnScrollListener aAQ = new g(this);
    private final SlidingMenu.OnClosedListener aCH = new h(this);
    private final ba aCI = new i(this);
    private final com.baidu.tieba.tbadkCore.ao aAT = new com.baidu.tieba.tbadkCore.ao(getPageContext(), new j(this));
    private final SlidingMenu.OnOpenedListener aCJ = new k(this);
    private final View.OnClickListener aCK = new m(this);
    private final View.OnClickListener aCL = new n(this);
    private final AdapterView.OnItemClickListener aCM = new o(this);
    private final com.baidu.tbadk.core.view.ad aCN = new p(this);
    private final CustomMessageListener aCO = new q(this, 0);
    private AlertDialog aAR = null;
    private final com.baidu.adp.framework.listener.e aCP = new r(this, 301001);
    private final HttpMessageListener aCQ = new s(this, CmdConfigHttp.FRS_HTTP_CMD);
    private com.baidu.adp.widget.ListView.an aCR = new t(this);
    private View.OnClickListener aCS = new v(this);
    private View.OnClickListener aCT = new w(this);
    private com.baidu.adp.widget.ListView.ao aCU = new y(this);

    static {
        Fr();
        Fs();
        BA();
        MessageManager.getInstance().registerListener(aCC);
        MessageManager.getInstance().registerListener(aCD);
        com.baidu.tieba.tbadkCore.a.a.a(301001, FRSPageSocketResponsedMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.O(TbConfig.FRS_ADDRESS, 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.location.d.ahE();
        isNeedRefreshOnResume = false;
    }

    private static void Fr() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003000, new z());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Fs() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003001, new aa());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void BA() {
        com.baidu.tbadk.core.util.bh.pK().a(new ab());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m255getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Ft() {
        return !TbadkCoreApplication.m255getInst().isMIUIRom() && TbadkCoreApplication.m255getInst().isFloatingWindowOpened() && TbadkCoreApplication.m255getInst().getChatFloatWindowLocked();
    }

    public void Fu() {
        if (!this.aCu) {
            this.aCu = true;
            this.agv = System.currentTimeMillis() - this.aCp;
            com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
            wVar.dR(1000);
            wVar.agm = this.aCy;
            wVar.ago = this.createTime;
            wVar.agv = this.agv;
            wVar.zb();
        }
    }

    public void e(com.baidu.tbadk.performanceLog.w wVar) {
        if (wVar != null) {
            wVar.ago = this.createTime;
            this.createTime = 0L;
            wVar.agm = this.aCy;
            wVar.agu = this.agu;
            wVar.agv = this.agv == 0 ? System.currentTimeMillis() - this.aCp : this.agv;
            wVar.zc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EQ() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void ER() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.z.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m255getInst().getLocationShared()) {
            ES();
        } else if (this.aAD.ahD()) {
            EQ();
        } else {
            this.aAD.ex(false);
            if (this.aBX.Fh() != null) {
                this.aBX.Fh().setLocationViewVisibility(0);
                this.aBX.Fh().setLocationInfoViewState(1);
            }
            this.aAD.ahB();
        }
    }

    private void ES() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bt(com.baidu.tieba.z.location_app_permission_prompt).a(com.baidu.tieba.z.isopen, new ac(this)).b(com.baidu.tieba.z.cancel, new ad(this)).b(getPageContext());
        aVar.nU();
    }

    private void ET() {
        PbEditor Fh = this.aBX.Fh();
        if (Fh != null) {
            if (this.aAD.ahF()) {
                Fh.setLocationViewVisibility(0);
                if (this.aAD.ahD()) {
                    this.aAO.a(com.baidu.tieba.tbadkCore.location.c.ahy().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.l.isNetOk()) {
                    Fh.setLocationInfoViewState(1);
                    this.aAD.ahB();
                    return;
                } else {
                    Fh.setLocationInfoViewState(0);
                    return;
                }
            }
            Fh.setLocationViewVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.e eVar) {
        if (eVar != null && eVar.aej() != null) {
            this.aBX.Go().C(eVar.aej().getRecommendForumData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.e eVar) {
        if (eVar != null && eVar.aej() != null && TbadkCoreApplication.m255getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            if (this.aCh != null) {
                this.aCh.a(eVar.aej().getAnchorPower());
            }
            this.aBX.f(eVar);
            ArrayList<LiveCardData> aeh = eVar.aeh();
            ArrayList<com.baidu.adp.widget.ListView.am> aek = eVar.aek();
            if (aeh != null && aeh.size() > 0 && aek != null && aek.size() > 0) {
                int size = aek.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!(aek.get(i) instanceof com.baidu.tbadk.core.data.l)) {
                        i++;
                    } else {
                        aek.remove(i);
                        break;
                    }
                }
                int aen = eVar.aen();
                com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
                lVar.o(aeh);
                eVar.aek().add(aen, lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aBI = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (bundle != null) {
            this.aBP = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aBQ = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (intent != null) {
            this.aBP = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.aBQ = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (intent != null) {
            this.aCo = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aCo = System.currentTimeMillis();
        }
        if (this.aCo != -1) {
            this.aCp = this.aCo;
        } else {
            this.aCp = System.currentTimeMillis();
        }
        if (!bE(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.aCp;
        } else if (AA()) {
            this.createTime = System.currentTimeMillis() - this.aCp;
        } else {
            registerListener(this.CL);
            registerListener(this.mMemListener);
            registerListener(this.aCP);
            registerListener(this.aCQ);
            registerListener(this.aCE);
            registerListener(this.aAM);
            registerListener(this.aCA);
            registerListener(this.aCz);
            this.mVoiceManager = getVoiceManager();
            this.mVoiceManager.onCreate(getPageContext());
            initUI();
            initData(bundle);
            this.aBX.jK();
            this.aAT.setUniqueId(getUniqueId());
            this.aAT.registerListener();
            addGlobalLayoutListener();
            this.createTime = System.currentTimeMillis() - this.aCo;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.aBX != null && this.aBX.Fh() != null) {
            this.aBX.Fh().afl();
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
                if (eVar.Ci() == 1) {
                    this.aBX.GO().setFromCDN(true);
                } else {
                    this.aBX.GO().setFromCDN(false);
                }
                this.aBX.a(eVar.aej(), eVar.getUserData());
                if (eVar.ael().aeq() == 1) {
                    this.mPageType = "frs_page";
                    this.aBX.M(eVar.getUserData().getIsMem(), this.aCh.aej().isLike());
                } else {
                    this.mPageType = "normal_page";
                    this.aBX.L(eVar.getUserData().getIsMem(), this.aCh.aej().isLike());
                }
                this.aBX.Gv();
                this.aBP = eVar.aej().getName();
                this.forumId = eVar.aej().getId();
                this.aBX.setTitle(this.aBP);
                FC();
                eVar.aeo();
                eVar.au(getPageContext().getPageActivity());
                eVar.aep();
                b(eVar);
                com.baidu.tbadk.core.data.y top_notice_data = eVar.aej().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.getTitle() != null) {
                    com.baidu.tbadk.core.data.w wVar = new com.baidu.tbadk.core.data.w();
                    wVar.setTitle(top_notice_data.getTitle());
                    wVar.bp(2);
                    wVar.bS(top_notice_data.nO());
                    wVar.parser_title();
                    eVar.d(wVar);
                }
                ArrayList<com.baidu.adp.widget.ListView.am> aek = eVar.aek();
                if (aek != null) {
                    this.aBX.a(aek, this.aBR, this.aCh, eVar.mY().mW());
                    FJ();
                    this.aBX.eT(this.aBR);
                    if (this.mPageType.equals("frs_page")) {
                        this.aBX.a(eVar.aej(), eVar);
                    } else if (this.mPageType.equals("normal_page")) {
                        this.aBX.b(eVar.aej(), eVar);
                    }
                    this.aBX.GI();
                    this.aBX.eO(0);
                }
                if (eVar.aei()) {
                    if (this.aBX.Gt() != null) {
                        this.aBX.Gt().Hj();
                    }
                    if (this.aBX.Gu() != null) {
                        this.aBX.Gu().Hj();
                    }
                } else {
                    if (this.aBX.Gt() != null) {
                        this.aBX.Gt().Hi();
                    }
                    if (this.aBX.Gu() != null) {
                        this.aBX.Gu().Hi();
                    }
                }
                hideLoadingView(this.aBX.getRootView());
                this.aBL = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void initData(Bundle bundle) {
        Fy();
        this.aBU = TbadkCoreApplication.isLogin();
        if (bundle != null) {
            this.aBP = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.aBQ = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            this.aBP = intent.getStringExtra("name");
            this.mFrom = intent.getStringExtra("from");
            this.aBQ = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            this.aCf = intent.getBooleanExtra(FrsActivityConfig.GOOD, false);
        }
        if (this.aBP != null && this.aBP.length() > 0) {
            if (this.mFrom == null || this.mFrom.length() <= 0) {
                this.mFrom = FrsActivityConfig.FRS_FROM_LIKE;
            }
            this.aBY = this.mFrom;
            kC();
            Fv();
            Fw();
            this.aCk = new cx(getPageContext().getPageActivity());
            if (this.aBU) {
                Fx();
                Fz();
            }
            if (bundle != null) {
                this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
                this.aAI = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            this.writeImagesInfo.setMaxImagesAllowed(10);
            this.aAK = new com.baidu.tieba.tbadkCore.f.a(this);
            this.aAK.a(this.aCB);
            this.aAD = new com.baidu.tieba.tbadkCore.location.d(this);
            this.aAD.a(this.aAO);
            this.aAD.a(this.aAP);
        }
    }

    private void kC() {
        this.zm = new com.baidu.tieba.tbadkCore.ac(getPageContext());
        this.zm.setLoadDataCallBack(new ae(this));
    }

    private void Fv() {
        this.aCi = new com.baidu.tieba.tbadkCore.au();
        this.aCi.setFrom(PbActivityConfig.KEY_FROM_FRS);
        this.aCi.a(new af(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        new ag(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void Fw() {
        this.aCj = new de(this);
        this.aCj.setLoadDataCallBack(new ah(this));
    }

    public void Fx() {
        if (this.aCk != null && this.aBX != null) {
            if (aBM || aBN || aBO) {
                this.aCk.L(com.baidu.tbadk.coreExtra.messageCenter.a.rI().getMsgReplyme());
                this.aCk.K(com.baidu.tbadk.coreExtra.messageCenter.a.rI().getMsgAtme());
                int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.rI().getMsgChat();
                if (TbadkCoreApplication.m255getInst().getChatFloatWindowLocked() && !TbadkCoreApplication.m255getInst().isMIUIRom()) {
                    msgChat -= com.baidu.tbadk.coreExtra.messageCenter.a.rI().rP();
                }
                this.aCk.M(msgChat);
                this.aBX.a(this.aCk, aBM, aBN, aBO);
            }
        }
    }

    private void Fy() {
        registerListener(2001122, this.aCO);
    }

    private void Fz() {
        registerListener(2001124, this.aCO);
    }

    private boolean AA() {
        if ("from_hao123".equals(getIntent().getStringExtra("from")) && UtilHelper.FirstStartActivity(getPageContext().getPageActivity())) {
            Intent intent = new Intent();
            intent.putExtra("class", 2);
            intent.putExtra(ImageViewerConfig.FORUM_NAME, getIntent().getStringExtra("name"));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LogoActivityConfig(getPageContext().getPageActivity(), intent)));
            finish();
            return true;
        }
        return false;
    }

    private boolean bE(boolean z) {
        if (z && com.baidu.tieba.frs.utils.a.H(getPageContext().getPageActivity(), getClass().getName())) {
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
        if (this.aBX != null) {
            this.aBX.onDestroy();
        }
        if (this.aCx != null) {
            this.aCx.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.aCh != null) {
                this.aCh.clear();
            }
            if (this.zm != null) {
                this.zm.GZ();
            }
            if (this.aCj != null) {
                this.aCj.GZ();
            }
            if (this.aAK != null) {
                this.aAK.cancelLoadData();
            }
            this.aBX.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
        if (this.aCq != null) {
            this.aCq.cancel(true);
            this.aCq = null;
        }
        if (this.aCg != null) {
            this.aCg.destory();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aBP);
        bundle.putString("from", this.mFrom);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aAI);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int size;
        com.baidu.tbadk.core.data.w hU;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    eC(0);
                    return;
                case 11002:
                    kD();
                    return;
                case 11011:
                    b(this.aCa);
                    return;
                case 11012:
                    c(this.aCl);
                    return;
                case 11014:
                    FH();
                    return;
                case 11016:
                    this.aBX.GH();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    FG();
                    return;
                case 12001:
                    if (this.writeImagesInfo != null) {
                        FL();
                        int size2 = this.writeImagesInfo.size() - 1;
                        if (size2 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size2)));
                            return;
                        }
                        return;
                    }
                    return;
                case 12002:
                    J(intent);
                    return;
                case 12004:
                    ArrayList<String> T = com.baidu.tieba.tbadkCore.util.i.T(intent);
                    if (T != null) {
                        this.aBX.z(T);
                        return;
                    }
                    return;
                case 12006:
                    WriteData EV = this.aAK.EV();
                    if (EV != null) {
                        EV.deleteUploadedTempImages();
                    }
                    this.aCr.setIsBaobao(false);
                    this.aCr.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.aAK.c((WriteData) null);
                    this.aAK.ey(false);
                    this.aBX.bD(true);
                    if (this.aCs != null) {
                        com.baidu.tieba.tbadkCore.al.b(this.aCs.getTid(), (WriteData) null);
                        this.aCs.setReply_num(this.aCs.getReply_num() + 1);
                    }
                    if (this.writeImagesInfo != null) {
                        this.aBX.a(this.writeImagesInfo, true);
                    }
                    this.aBX.Gw();
                    this.aBX.Fj();
                    return;
                case 12012:
                    K(intent);
                    return;
                case 12013:
                    M(intent);
                    return;
                case 13003:
                    refresh();
                    return;
                case 18003:
                    this.aBX.GO().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (hU = this.aCh.hU(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            hU.bq(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            hU.parser_title();
                            refresh();
                            return;
                        } else if (intExtra == 0) {
                            this.aCh.e(hU);
                            this.aBX.GI();
                            if (com.baidu.tieba.tbadkCore.d.aed() != null) {
                                com.baidu.tieba.tbadkCore.d.aed().C(this.aBP, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    FF();
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    EW();
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
        this.aAG = true;
        this.aCt = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.aBX.jK();
        } else if (azb) {
            azb = false;
            this.aBX.jK();
        } else {
            if (!this.aBU && TbadkCoreApplication.isLogin()) {
                this.aBU = true;
                if (this.aCh != null && this.aCh.mP() != null) {
                    this.aCh.mP().setIfpost(1);
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
                this.aBP = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.mFrom = intent.getStringExtra("from");
            }
            this.aBT = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aBT) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    FA();
                } else {
                    FB();
                }
            }
        }
    }

    private void FA() {
        this.aBX.jK();
        this.aBX.Gp().showContent(false);
    }

    private void FB() {
        this.aBX.jK();
        this.aBX.Gp().toggle(false);
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
                sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            } else {
                com.baidu.tbadk.core.b.b.e(getPageContext().getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        } else {
            com.baidu.tbadk.core.b.b.e(getPageContext().getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            finish();
        }
    }

    private void initUI() {
        this.aBR = 1;
        this.aCf = false;
        this.aCe = 0L;
        this.mType = 3;
        if (TextUtils.isEmpty(this.aBP)) {
            this.aBP = "";
        }
        if (TextUtils.isEmpty(this.mFrom)) {
            this.mFrom = "";
        }
        setContentView(com.baidu.tieba.x.frs_activity);
        this.aBX = new bq(this, this.aCG);
        this.aBX.GO().h(this.aCK);
        this.aBX.GO().i(this.aCL);
        if (this.aBQ == 0) {
            this.aBX.setTitle(this.aBP);
        } else {
            this.aBX.setTitle("");
            this.aBQ = 1;
        }
        this.aBX.a(this.aCR);
        this.aBX.a(this.aCU);
        this.aBX.j(this.aCS);
        this.aBX.l(this.aCT);
        this.aBX.setOnScrollListener(this.aAQ);
        this.aBX.a(this.aza);
        this.aBX.a(this.aCH);
        this.aBX.a(this.aCJ);
        this.aBX.f(this.aCN);
        this.aBX.GO().a(this.aCI);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aBX.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public com.baidu.adp.lib.e.b<TbImageView> EY() {
        if (this.aCm == null) {
            this.aCm = FrsCommonImageLayout.l(getPageContext().getPageActivity(), 6);
        }
        return this.aCm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fy(String str) {
        Intent J;
        com.baidu.tieba.frs.view.o Gu;
        if (str != null && (J = com.baidu.tieba.frs.utils.a.J(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(com.baidu.tieba.z.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", J);
            BarImageView barImageView = null;
            if (this.mPageType.equals("normal_page")) {
                FrsHeaderView Gt = this.aBX.Gt();
                if (Gt != null) {
                    barImageView = Gt.He();
                }
            } else if (this.mPageType.equals("frs_page") && (Gu = this.aBX.Gu()) != null) {
                barImageView = Gu.He();
            }
            if (barImageView != null && barImageView.getBdImage() != null && barImageView.getBdImage().ji() != null) {
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.c.eS().a(com.baidu.adp.lib.util.c.eS().d(barImageView.getBdImage().ji(), getResources().getDimensionPixelSize(com.baidu.tieba.u.ds100)), getResources().getDimensionPixelSize(com.baidu.tieba.u.ds32)));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getPageContext().getPageActivity(), com.baidu.tieba.v.icon));
            }
            getPageContext().getPageActivity().sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eC(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            if (this.aCh != null && this.aCh.mP() != null) {
                this.aCh.mP().setIfpost(1);
            }
            if (i == 0) {
                sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11001)));
            } else {
                sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11016)));
            }
        } else if (this.aCh != null) {
            if (i == 0) {
                AntiData mP = this.aCh.mP();
                if (AntiHelper.c(mP) || AntiHelper.d(mP) || AntiHelper.e(mP)) {
                    mP.setBlock_forum_name(this.aBP);
                    mP.setBlock_forum_id(this.aCh.aej().getId());
                    mP.setUser_name(this.aCh.getUserData().getUserName());
                    mP.setUser_id(this.aCh.getUserData().getUserId());
                    if (AntiHelper.a(getPageContext().getPageActivity(), mP, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (this.aCh.mP() != null && this.aCh.mP().getIfpost() == 0) {
                    com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), mP.getForbid_info());
                    return;
                }
                int i2 = 0;
                if (this.aCh.getUserData() != null) {
                    i2 = this.aCh.getUserData().getIsMem();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(getPageContext().getPageActivity(), 0, this.aCh.aej().getId(), this.aBP, null, null, 0, this.aCh.mP(), 13003, false, false, null, false, false, null, null, this.aCh.aej().getPrefixData(), i2)));
                return;
            }
            this.aBX.GH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.w wVar) {
        boolean nK = wVar == null ? true : wVar.nK();
        this.aBX.a(new ak(this, wVar));
        this.aBX.a(wVar, nK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.w wVar) {
        boolean nK = wVar == null ? true : wVar.nK();
        if (this.mThreadId != null) {
            if (!nK) {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aBP, null, 18003, true, true, this.aBW)));
            } else {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aBP, null, 18003, false, false, this.aBW)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.w wVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aBP, null, 18003, false, false, this.aBW)));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aBX != null) {
            if (z) {
                if (this.aBJ) {
                    this.aBJ = false;
                    showLoadingView(this.aBX.getRootView(), true);
                    return;
                }
                return;
            }
            hideLoadingView(this.aBX.getRootView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        stopVoice();
        this.aBR = 1;
        eD(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eD(int i) {
        boolean z = false;
        this.mType = i;
        switch (this.mType) {
            case 1:
                if (this.aBX.GO().FR()) {
                    return;
                }
                break;
            case 2:
                if (this.aBX.GO().FS()) {
                    return;
                }
                break;
            case 3:
                if (this.aBX.Gs()) {
                    return;
                }
                break;
        }
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(this.aBP);
        fRSPageRequestMessage.setPn(this.aBR);
        if (this.aCh == null) {
            this.aCh = new com.baidu.tieba.tbadkCore.e();
        }
        fRSPageRequestMessage.setForumModel(this.aCh);
        if (com.baidu.tbadk.core.l.mc().mg()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        if (this.aCf) {
            fRSPageRequestMessage.setIsGood(1);
            fRSPageRequestMessage.setCid((int) this.aCe);
        }
        int M = com.baidu.adp.lib.util.l.M(getPageContext().getPageActivity());
        int N = com.baidu.adp.lib.util.l.N(getPageContext().getPageActivity());
        float f = M / 320.0f;
        int i2 = com.baidu.tbadk.core.util.bb.px().pz() ? 2 : 1;
        fRSPageRequestMessage.setScrW(M);
        fRSPageRequestMessage.setScrH(N);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i2);
        fRSPageRequestMessage.setLastId(this.aBV);
        if (this.aBY != null) {
            fRSPageRequestMessage.setStType(this.aBY);
            if (this.aBY.equalsIgnoreCase("sidebar")) {
                fRSPageRequestMessage.setStType(this.aBZ);
            }
        }
        if (aCb != 0) {
            fRSPageRequestMessage.setCtime((int) aCb);
        }
        if (aCc != 0) {
            fRSPageRequestMessage.setDataSize((int) aCc);
        }
        if (aCd != 0) {
            fRSPageRequestMessage.setNetError(aCd);
        }
        this.aBX.bM(true);
        this.aBX.GO().bH(false);
        this.aBX.GO().bI(false);
        this.aBX.GO().notifyDataSetChanged();
        if (this.aBR == 1 && ((this.mPageType.equals("normal_page") || this.mPageType.equals("frs_page")) && !this.aCf)) {
            z = true;
        }
        if (this.aCh == null) {
            this.aCh = new com.baidu.tieba.tbadkCore.e();
        }
        this.aCh.a(this.aCF);
        this.aCh.a(this, fRSPageRequestMessage, this.mType, z, this.aBP);
        if (this.aCg == null) {
            this.aCg = new com.baidu.tieba.tbadkCore.d.a("frsStat");
            this.aCg.start();
        }
    }

    private void FC() {
        switch (this.aBQ) {
            case 1:
                com.baidu.adp.lib.g.l.em().c(new al(this));
                break;
        }
        this.aBQ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FD() {
        stopVoice();
        try {
            if (this.aCh != null) {
                this.aBX.Gv();
                this.aBP = this.aCh.aej().getName();
                this.forumId = this.aCh.aej().getId();
                this.aBX.setTitle(this.aBP);
                TbadkCoreApplication.m255getInst().setDefaultBubble(this.aCh.getUserData().getBimg_url());
                TbadkCoreApplication.m255getInst().setDefaultBubbleEndTime(this.aCh.getUserData().getBimg_end_time());
                FC();
                ArrayList<com.baidu.adp.widget.ListView.am> aek = this.aCh.aek();
                if (aek != null) {
                    this.aBX.a(aek, this.aBR, this.aCh, this.aCh.mY().mW());
                    FJ();
                    this.aBX.eT(this.aBR);
                    if (this.mPageType.equals("frs_page")) {
                        FE();
                    } else if (this.mPageType.equals("normal_page")) {
                        this.aBX.b(this.aCh.aej(), this.aCh);
                    }
                    this.aBX.GI();
                    if (this.aCh.Ci() == 1) {
                        this.aBX.GO().setFromCDN(true);
                    } else {
                        this.aBX.GO().setFromCDN(false);
                    }
                    this.aBX.eO(K(this.mType, this.aBR));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int K(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aAG = false;
        this.aCt = false;
        this.aBX.onPause();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
        EX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.distribute.a.uD().a(getPageContext().getPageActivity(), "frs", this.aCh.aej().getId(), 0L);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.aBS) {
            if (i == 4) {
                if (this.aBX.Gp().isMenuShowing()) {
                    this.aBX.Gp().toggle(true);
                    if (this.aBX.Go().GW()) {
                        this.aBX.Go().bU(false);
                        refresh();
                        return true;
                    }
                    return true;
                } else if (this.aBX.Fh() != null && this.aBX.Fh().isVisible()) {
                    this.aBX.Fj();
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
            aVar.bs(com.baidu.tieba.z.anti_title);
            if (cVar.mw()) {
                com.baidu.tbadk.core.util.bh.pK().b(getPageContext(), new String[]{cVar.Do});
            } else if (cVar.mv()) {
                if (com.baidu.adp.lib.util.i.fg() && !com.baidu.adp.lib.util.i.fh()) {
                    trim = getPageContext().getString(com.baidu.tieba.z.frs_network_tips);
                } else if (TextUtils.isEmpty(cVar.Dz.DF.trim())) {
                    trim = getPageContext().getString(com.baidu.tieba.z.confirm_download_app);
                } else {
                    trim = cVar.Dz.DF.trim();
                }
                aVar.bY(trim);
                aVar.a(com.baidu.tieba.z.alert_yes_button, new am(this, cVar, i));
                aVar.b(com.baidu.tieba.z.alert_no_button, new an(this));
                aVar.b(getPageContext()).nU();
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar != null) {
            if (!cVar.mu()) {
                com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), com.baidu.tieba.z.pb_app_error);
            } else if (UtilHelper.isNetOk()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", cVar.Dq);
                com.baidu.tbadk.download.b.uK().a(cVar.Dq, cVar.Dp, cVar.Dm, i, com.baidu.adp.lib.g.c.toInt(cVar.Dl, 0));
            } else {
                showToast(com.baidu.tieba.z.neterror);
            }
        }
    }

    private void FE() {
        this.aBX.a(this.aCh.aej(), this.aCh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FF() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.aCh.aej().getId(), true, true, false, true, true)));
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.uD().a(getPageContext().getPageActivity(), cVar, str, "frs", this.aCh.aej().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.uD().a(cVar, this.forumId, 0L, "FRS", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kD() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11002)));
            return;
        }
        this.zm.setFrom(PbActivityConfig.KEY_FROM_FRS);
        this.zm.aN(this.aCh.aej().getName(), this.aCh.aej().getId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FG() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
        builder.setMessage(getPageContext().getString(com.baidu.tieba.z.attention_cancel_info));
        builder.setTitle(getPageContext().getString(com.baidu.tieba.z.alert_title));
        builder.setPositiveButton(getPageContext().getString(com.baidu.tieba.z.attention_cancel), new ao(this));
        builder.setNegativeButton(getPageContext().getString(com.baidu.tieba.z.cancel), new ap(this));
        com.baidu.adp.lib.g.k.a(builder.create(), getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FH() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11014)));
            return;
        }
        if (this.mPageType.equals("normal_page")) {
            this.aBX.GA();
        } else if (this.mPageType.equals("frs_page")) {
            this.aBX.GC();
        }
        this.aCj.an(this.aCh.aej().getName(), this.aCh.aej().getId());
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.aBX.Go().GV()) {
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
            com.baidu.tbadk.core.util.d.eT();
            TbadkCoreApplication.m255getInst().resetPbRecorder();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eB(int i) {
        ArrayList<com.baidu.adp.widget.ListView.am> aek = this.aCh.aek();
        if (aek != null) {
            Iterator<com.baidu.adp.widget.ListView.am> it = aek.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.am next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.w) {
                    com.baidu.tbadk.core.data.w wVar = (com.baidu.tbadk.core.data.w) next;
                    if (wVar == this.aBK) {
                        a(wVar, i);
                        this.aBK = null;
                        break;
                    } else if (wVar.getId() != null && wVar.getId().equals(this.aAH)) {
                        a(wVar, i);
                        this.aAH = null;
                        break;
                    }
                }
            }
            this.aBX.GO().a(aek, this.aCh);
            this.aBX.GO().notifyDataSetChanged();
        }
    }

    private void a(com.baidu.tbadk.core.data.w wVar, int i) {
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

    public void FI() {
        if (this.aCh != null && this.aCh.aej() != null && this.aCh.aej().getBannerListData() != null) {
            String mB = this.aCh.aej().getBannerListData().mB();
            if (!TextUtils.isEmpty(mB)) {
                this.aBV = mB;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fz(String str) {
        if (str != null) {
            if (this.aBX.Gp().isMenuShowing()) {
                this.aBX.Gp().toggle(true);
            }
            this.aCf = false;
            this.aBP = str;
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
    @Override // com.baidu.tbadk.core.view.ar
    public BdListView getListView() {
        if (this.aBX == null) {
            return null;
        }
        return this.aBX.getListView();
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

    @Override // com.baidu.tbadk.core.view.ar
    public int qD() {
        if (this.aBX == null) {
            return 0;
        }
        return this.aBX.EO();
    }

    @Override // com.baidu.tbadk.core.view.ar
    public com.baidu.adp.lib.e.b<TbImageView> qE() {
        if (this.Ny == null) {
            this.Ny = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.Ny;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.aCk != null) {
                this.aCk.L(msgReplyme);
                this.aCk.K(msgAtme);
                if (TbadkCoreApplication.m255getInst().getChatFloatWindowLocked() && !TbadkCoreApplication.m255getInst().isMIUIRom()) {
                    this.aCk.M((msgChat - newsNotifyMessage.getMsgPrivateChat()) - newsNotifyMessage.getMsgStrangerChat());
                } else {
                    this.aCk.M(msgChat);
                }
                this.aBX.a(this.aCk, aBM, aBN, aBO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        az GO;
        HashMap<Integer, com.baidu.tbadk.core.data.w> FT;
        if (this.aCh != null && this.aBX != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (GO = this.aBX.GO()) != null && (FT = GO.FT()) != null && FT.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.w> entry : FT.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.w value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.c) && TextUtils.equals(((com.baidu.tbadk.core.data.c) value).Dq, downloadData.getId())) {
                            if (GO.ay(intValue) instanceof com.baidu.tbadk.core.data.c) {
                                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) GO.ay(intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    cVar.Dk = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!com.baidu.tbadk.core.util.ba.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    cVar.Dk = 0;
                                } else if (status == 1) {
                                    cVar.Dk = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.aBX.Gw();
        }
    }

    private void FJ() {
        HashMap<Integer, com.baidu.tbadk.core.data.w> FT;
        if (this.aBX != null && this.aBX.GO() != null && (FT = this.aBX.GO().FT()) != null) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.w> entry : FT.entrySet()) {
                com.baidu.tbadk.core.data.w value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.c)) {
                    arrayList.add((com.baidu.tbadk.core.data.c) value);
                }
            }
            com.baidu.tbadk.download.b.uK().u(arrayList);
        }
    }

    public void a(int i, com.baidu.tbadk.core.data.w wVar, int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 0)));
            return;
        }
        if (this.aCs != wVar && wVar != null) {
            EX();
            this.aBX.fx(null);
            this.writeImagesInfo = new WriteImagesInfo();
            this.writeImagesInfo.setMaxImagesAllowed(10);
            this.aBX.a(this.writeImagesInfo, true);
            this.aAK.c((WriteData) null);
            this.aAK.ey(false);
            this.aBX.Fp();
            com.baidu.tieba.tbadkCore.al.a(wVar.getTid(), this);
        }
        this.aCs = wVar;
        this.aBX.a(i, wVar, i2);
        ET();
    }

    public void FK() {
        if (this.aBX != null) {
            this.aBX.setOnActionListener(new aq(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Boolean bool) {
        this.aBX.bS(com.baidu.tieba.tbadkCore.aa.b(this.aCh.aej().getName(), bool));
    }

    private void J(Intent intent) {
        a(intent, true);
    }

    private void FL() {
        this.writeImagesInfo.addChooseFile(com.baidu.tieba.frs.utils.a.K(getPageContext().getPageActivity(), this.aAI));
        this.writeImagesInfo.updateQuality();
        this.aBX.a(this.writeImagesInfo, true);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0 && this.aBX.Fh() != null) {
            this.aBX.Fh().hH(23);
        }
    }

    private void K(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    this.aBX.a(this.writeImagesInfo, z);
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0 && this.aBX.Fh() != null) {
                this.aBX.Fh().hH(23);
            }
        }
    }

    private void EW() {
        new ar(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EU() {
        if (this.aAR == null) {
            String[] strArr = {getPageContext().getString(com.baidu.tieba.z.take_photo), getPageContext().getString(com.baidu.tieba.z.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
            builder.setTitle(getPageContext().getString(com.baidu.tieba.z.operation));
            builder.setItems(strArr, new as(this));
            this.aAR = builder.create();
            this.aAR.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(String str) {
        if (this.aAK.EV() == null) {
            WriteData EV = EV();
            EV.setWriteImagesInfo(this.writeImagesInfo);
            this.aAK.ey(this.writeImagesInfo.size() > 0);
            this.aAK.c(EV);
        }
        if (this.aAK.EV() != null) {
            if (this.aCr.getIsBaobao()) {
                this.aAK.EV().setIsBaobao(true);
                this.aAK.EV().setBaobaoContent(this.aCr.getBaobaoContent());
                this.aAK.EV().setBaobaoImagesInfo(this.baobaoImagesInfo);
            } else {
                this.aAK.EV().setIsBaobao(false);
                this.aAK.EV().setBaobaoContent("");
                this.baobaoImagesInfo.clear();
            }
            if (this.aBX.Fh() != null) {
                this.aAK.EV().setHasLocationData(this.aBX.Fh().getLocationInfoViewState() == 2);
            }
            VoiceData.VoiceModel audioData = this.aBX.getAudioData();
            this.aAK.EV().setIsFrsReply(true);
            this.aAK.EV().setContent(this.aBX.Fo());
            this.aBX.Fq();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.aAK.EV().setVoice(audioData.getId());
                    this.aAK.EV().setVoiceDuringTime(audioData.duration);
                } else {
                    this.aAK.EV().setVoice(null);
                    this.aAK.EV().setVoiceDuringTime(-1);
                }
            } else {
                this.aAK.EV().setVoice(null);
                this.aAK.EV().setVoiceDuringTime(-1);
            }
            if (!this.aAK.aic()) {
                showToast(com.baidu.tieba.z.write_img_limit);
            } else if (this.aAK.aib()) {
                showProgressBar();
            }
        }
    }

    private WriteData EV() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.aCh.aej().getId());
        writeData.setForumName(this.aCh.aej().getName());
        writeData.setThreadId(this.aCs.getTid());
        writeData.setIsAd(false);
        writeData.setType(1);
        return writeData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.aCs.ns());
            antiData.setBlock_forum_id(this.aCh.aej().getId());
            antiData.setUser_name(this.aCs.getAuthor().getUserName());
            antiData.setUser_id(this.aCs.getAuthor().getUserId());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, com.baidu.tieba.tbadkCore.f.f fVar) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.aCs.ns());
            antiData.setBlock_forum_id(this.aCh.aej().getId());
            antiData.setUser_name(this.aCs.getAuthor().getUserName());
            antiData.setUser_id(this.aCs.getAuthor().getUserId());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.tieba.tbadkCore.f.g.d(getPageContext().getPageActivity(), fVar.getErrorString(), fVar.aie(), fVar.aif());
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void a(WriteData writeData) {
        if (writeData != null && this.aCs != null && writeData.getThreadId().equals(this.aCs.getTid())) {
            if (!com.baidu.tbadk.core.util.ba.isEmpty(writeData.getContent()) && com.baidu.tbadk.core.util.ba.isEmpty(this.aBX.Fo())) {
                this.aBX.fx(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                this.aBX.a(this.writeImagesInfo, true);
            }
            if (TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.aCr.setIsBaobao(writeData.getIsBaobao());
                this.aCr.setBaobaoContent(writeData.getBaobaoContent());
                this.aBX.setBaobaoUris(this.baobaoImagesInfo);
            }
        }
    }

    public void FM() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    private void EX() {
        if (this.aCs != null) {
            WriteData EV = this.aAK.EV();
            if (EV == null) {
                EV = new WriteData(1);
                EV.setThreadId(this.aCs.getTid());
                EV.setWriteImagesInfo(this.writeImagesInfo);
            }
            EV.setContent(this.aBX.Fo());
            if (this.aCr != null && this.aCr.getIsBaobao()) {
                EV.setBaobaoContent(this.aCr.getBaobaoContent());
                EV.setBaobaoImagesInfo(this.baobaoImagesInfo);
                EV.setIsBaobao(true);
            }
            com.baidu.tieba.tbadkCore.al.b(this.aCs.getTid(), EV);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    private void M(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            if (stringExtra != null && stringExtra2 != null) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(stringExtra);
                this.baobaoImagesInfo.clear();
                this.baobaoImagesInfo.addChooseFile(imageFileInfo);
                this.aBX.setBaobaoUris(this.baobaoImagesInfo);
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    if (this.aBX.Fh() != null) {
                        this.aBX.Fh().hH(48);
                    }
                    this.aCr.setIsBaobao(true);
                    this.aCr.setBaobaoContent(stringExtra2);
                    this.aCr.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.aCr.setIsBaobao(false);
                this.aCr.setBaobaoContent("");
                this.aCr.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.aBX.getRootView());
        showLoadingView(this.aBX.getRootView(), true);
        this.aBX.jK();
    }
}
