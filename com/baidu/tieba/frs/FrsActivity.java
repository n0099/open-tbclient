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
    public static String aCG;
    private static boolean isNeedRefreshOnResume;
    private com.baidu.adp.lib.e.b<TbImageView> NV;
    private com.baidu.tieba.tbadkCore.location.d aBC;
    private boolean aBF;
    private String aBG;
    private String aBH;
    private com.baidu.tieba.tbadkCore.f.a aBJ;
    private com.baidu.tbadk.core.data.x aCI;
    private cy aDi;
    private com.baidu.adp.lib.e.b<TbImageView> aDk;
    private ax aDo;
    private com.baidu.tbadk.core.data.x aDq;
    VoiceManager mVoiceManager;
    private static boolean aCK = true;
    private static boolean aCL = true;
    private static boolean aCM = true;
    public static boolean azY = false;
    private static volatile long aCZ = 0;
    private static volatile long aDa = 0;
    private static volatile int aDb = 0;
    public static final CustomMessageListener aDA = new as(2012111);
    private static final CustomMessageListener aDB = new at(2012112);
    private boolean aBD = false;
    private boolean aCH = true;
    private boolean aCJ = false;
    private int mType = 3;
    private String aCN = null;
    private String KQ = null;
    private int aCO = 0;
    private int aCP = 1;
    private boolean aCQ = false;
    private boolean aCR = false;
    private boolean aCS = false;
    private String aCT = null;
    private String mThreadId = null;
    private String forumId = null;
    private boolean aCU = false;
    private bp aCV = null;
    private String aCW = null;
    private String aCX = null;
    private final com.baidu.tbadk.core.data.x aCY = null;
    private long aDc = 0;
    private boolean aDd = false;
    private com.baidu.tieba.tbadkCore.d.a aDe = null;
    private com.baidu.tieba.tbadkCore.e aDf = null;
    private com.baidu.tieba.tbadkCore.ac zj = null;
    private com.baidu.tieba.tbadkCore.au aDg = null;
    private df aDh = null;
    private String mPageType = "normal_page";
    private com.baidu.tbadk.core.data.x aDj = null;
    private boolean aDl = false;
    private long aDm = -1;
    private long aDn = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private WriteData aDp = new WriteData();
    private boolean aDr = true;
    private long agP = 0;
    private long createTime = 0;
    private long agQ = 0;
    private boolean aDs = false;
    private boolean aDt = false;
    private boolean aDu = false;
    private com.baidu.tbadk.performanceLog.h aDv = null;
    public long aDw = System.currentTimeMillis();
    private CustomMessageListener aBL = new a(this, 2004004);
    private CustomMessageListener aDx = new l(this, 2001273);
    private CustomMessageListener aDy = new x(this, 2001197);
    private final com.baidu.tieba.tbadkCore.f.c aDz = new ai(this);
    public final CustomMessageListener aDC = new au(this, 2012111);
    private final com.baidu.tieba.tbadkCore.x aDD = new av(this);
    private com.baidu.tieba.tbadkCore.location.i aBN = new aw(this);
    private com.baidu.tieba.tbadkCore.location.j aBO = new b(this);
    private final CustomMessageListener CI = new c(this, 2003003);
    private final CustomMessageListener mMemListener = new d(this, 2001200);
    private final com.baidu.adp.widget.ListView.g azX = new e(this);
    private final View.OnClickListener aDE = new f(this);
    private final AbsListView.OnScrollListener aBP = new g(this);
    private final SlidingMenu.OnClosedListener aDF = new h(this);
    private final az aDG = new i(this);
    private final com.baidu.tieba.tbadkCore.ao aBR = new com.baidu.tieba.tbadkCore.ao(getPageContext(), new j(this));
    private final SlidingMenu.OnOpenedListener aDH = new k(this);
    private final View.OnClickListener aDI = new m(this);
    private final View.OnClickListener aDJ = new n(this);
    private final AdapterView.OnItemClickListener aDK = new o(this);
    private final com.baidu.tbadk.core.view.ad aDL = new p(this);
    private final CustomMessageListener aDM = new q(this, 0);
    private final com.baidu.adp.framework.listener.e aDN = new r(this, 301001);
    private final HttpMessageListener aDO = new s(this, CmdConfigHttp.FRS_HTTP_CMD);
    private com.baidu.adp.widget.ListView.an aDP = new t(this);
    private View.OnClickListener aDQ = new v(this);
    private View.OnClickListener aDR = new w(this);
    private com.baidu.adp.widget.ListView.ao aDS = new y(this);

    static {
        FJ();
        FK();
        BX();
        MessageManager.getInstance().registerListener(aDA);
        MessageManager.getInstance().registerListener(aDB);
        com.baidu.tieba.tbadkCore.a.a.a(301001, FRSPageSocketResponsedMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, com.baidu.tieba.tbadkCore.a.a.O(TbConfig.FRS_ADDRESS, 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.tbadkCore.location.d.aid();
        isNeedRefreshOnResume = false;
    }

    private static void FJ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003000, new z());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void FK() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003001, new aa());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void BX() {
        com.baidu.tbadk.core.util.bm.pO().a(new ab());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m255getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean FL() {
        return !TbadkCoreApplication.m255getInst().isMIUIRom() && TbadkCoreApplication.m255getInst().isFloatingWindowOpened() && TbadkCoreApplication.m255getInst().getChatFloatWindowLocked();
    }

    public void FM() {
        if (!this.aDs) {
            this.aDs = true;
            this.agQ = System.currentTimeMillis() - this.aDn;
            com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
            wVar.dX(1000);
            wVar.agH = this.aDw;
            wVar.agJ = this.createTime;
            wVar.agQ = this.agQ;
            wVar.zm();
        }
    }

    public void e(com.baidu.tbadk.performanceLog.w wVar) {
        if (wVar != null) {
            wVar.agJ = this.createTime;
            this.createTime = 0L;
            wVar.agH = this.aDw;
            wVar.agP = this.agP;
            wVar.agQ = this.agQ == 0 ? System.currentTimeMillis() - this.aDn : this.agQ;
            wVar.zn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fj() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Fk() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.z.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.m255getInst().getLocationShared()) {
            Fl();
        } else if (this.aBC.aic()) {
            Fj();
        } else {
            this.aBC.eE(false);
            if (this.aCV.Fz() != null) {
                this.aCV.Fz().setLocationViewVisibility(0);
                this.aCV.Fz().setLocationInfoViewState(1);
            }
            this.aBC.aia();
        }
    }

    private void Fl() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.by(com.baidu.tieba.z.location_app_permission_prompt).a(com.baidu.tieba.z.isopen, new ac(this)).b(com.baidu.tieba.z.cancel, new ad(this)).b(getPageContext());
        aVar.nQ();
    }

    private void Fm() {
        PbEditor Fz = this.aCV.Fz();
        if (Fz != null) {
            if (this.aBC.aie()) {
                Fz.setLocationViewVisibility(0);
                if (this.aBC.aic()) {
                    this.aBN.a(com.baidu.tieba.tbadkCore.location.c.ahX().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.l.isNetOk()) {
                    Fz.setLocationInfoViewState(1);
                    this.aBC.aia();
                    return;
                } else {
                    Fz.setLocationInfoViewState(0);
                    return;
                }
            }
            Fz.setLocationViewVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.tbadkCore.e eVar) {
        if (eVar != null && eVar.aeI() != null) {
            this.aCV.GF().D(eVar.aeI().getRecommendForumData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.e eVar) {
        if (eVar != null && eVar.aeI() != null && TbadkCoreApplication.m255getInst().appResponseToIntentClass(LiveRoomEntranceActivityConfig.class)) {
            if (this.aDf != null) {
                this.aDf.a(eVar.aeI().getAnchorPower());
            }
            this.aCV.f(eVar);
            ArrayList<LiveCardData> aeG = eVar.aeG();
            ArrayList<com.baidu.adp.widget.ListView.am> aeJ = eVar.aeJ();
            if (aeG != null && aeG.size() > 0 && aeJ != null && aeJ.size() > 0) {
                int size = aeJ.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!(aeJ.get(i) instanceof com.baidu.tbadk.core.data.m)) {
                        i++;
                    } else {
                        aeJ.remove(i);
                        break;
                    }
                }
                int aeM = eVar.aeM();
                com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
                mVar.o(aeG);
                eVar.aeJ().add(aeM, mVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aCG = "speed_icon_show" + TbadkCoreApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (bundle != null) {
            this.aCN = bundle.getString("name");
            this.KQ = bundle.getString("from");
            this.aCO = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (intent != null) {
            this.aCN = intent.getStringExtra("name");
            this.KQ = intent.getStringExtra("from");
            this.aCO = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (intent != null) {
            this.aDm = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aDm = System.currentTimeMillis();
        }
        if (this.aDm != -1) {
            this.aDn = this.aDm;
        } else {
            this.aDn = System.currentTimeMillis();
        }
        if (!bH(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false))) {
            this.createTime = System.currentTimeMillis() - this.aDn;
            return;
        }
        registerListener(this.CI);
        registerListener(this.mMemListener);
        registerListener(this.aDN);
        registerListener(this.aDO);
        registerListener(this.aDC);
        registerListener(this.aBL);
        registerListener(this.aDy);
        registerListener(this.aDx);
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        initUI();
        initData(bundle);
        this.aCV.jC();
        this.aBR.setUniqueId(getUniqueId());
        this.aBR.registerListener();
        addGlobalLayoutListener();
        this.createTime = System.currentTimeMillis() - this.aDm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.aCV != null && this.aCV.Fz() != null) {
            this.aCV.Fz().afK();
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
                if (eVar.CB() == 1) {
                    this.aCV.Hf().setFromCDN(true);
                } else {
                    this.aCV.Hf().setFromCDN(false);
                }
                this.aCV.a(eVar.aeI(), eVar.getUserData());
                if (eVar.aeK().aeP() == 1) {
                    this.mPageType = "frs_page";
                    this.aCV.O(eVar.getUserData().getIsMem(), this.aDf.aeI().isLike());
                } else {
                    this.mPageType = "normal_page";
                    this.aCV.N(eVar.getUserData().getIsMem(), this.aDf.aeI().isLike());
                }
                this.aCV.GM();
                this.aCN = eVar.aeI().getName();
                this.forumId = eVar.aeI().getId();
                this.aCV.setTitle(this.aCN);
                FU();
                eVar.aeN();
                eVar.av(getPageContext().getPageActivity());
                eVar.aeO();
                b(eVar);
                com.baidu.tbadk.core.data.z top_notice_data = eVar.aeI().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.getTitle() != null) {
                    com.baidu.tbadk.core.data.x xVar = new com.baidu.tbadk.core.data.x();
                    xVar.setTitle(top_notice_data.getTitle());
                    xVar.bu(2);
                    xVar.bN(top_notice_data.nK());
                    xVar.parser_title();
                    eVar.d(xVar);
                }
                ArrayList<com.baidu.adp.widget.ListView.am> aeJ = eVar.aeJ();
                if (aeJ != null) {
                    this.aCV.a(aeJ, this.aCP, this.aDf, eVar.mT().mR());
                    Gb();
                    this.aCV.eZ(this.aCP);
                    if (this.mPageType.equals("frs_page")) {
                        this.aCV.a(eVar.aeI(), eVar);
                    } else if (this.mPageType.equals("normal_page")) {
                        this.aCV.b(eVar.aeI(), eVar);
                    }
                    this.aCV.GZ();
                    this.aCV.eU(0);
                }
                if (eVar.aeH()) {
                    if (this.aCV.GK() != null) {
                        this.aCV.GK().HB();
                    }
                    if (this.aCV.GL() != null) {
                        this.aCV.GL().HB();
                    }
                } else {
                    if (this.aCV.GK() != null) {
                        this.aCV.GK().HA();
                    }
                    if (this.aCV.GL() != null) {
                        this.aCV.GL().HA();
                    }
                }
                hideLoadingView(this.aCV.getRootView());
                this.aCJ = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void initData(Bundle bundle) {
        FQ();
        this.aCS = TbadkCoreApplication.isLogin();
        if (bundle != null) {
            this.aCN = bundle.getString("name");
            this.KQ = bundle.getString("from");
            this.aCO = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            this.aCN = intent.getStringExtra("name");
            this.KQ = intent.getStringExtra("from");
            this.aCO = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            this.aDd = intent.getBooleanExtra(FrsActivityConfig.GOOD, false);
        }
        if (this.aCN != null && this.aCN.length() > 0) {
            if (this.KQ == null || this.KQ.length() <= 0) {
                this.KQ = FrsActivityConfig.FRS_FROM_LIKE;
            }
            this.aCW = this.KQ;
            kv();
            FN();
            FO();
            this.aDi = new cy(getPageContext().getPageActivity());
            if (this.aCS) {
                FP();
                FR();
            }
            if (bundle != null) {
                this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
                this.aBH = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            this.writeImagesInfo.setMaxImagesAllowed(10);
            this.aBJ = new com.baidu.tieba.tbadkCore.f.a(this);
            this.aBJ.a(this.aDz);
            this.aBC = new com.baidu.tieba.tbadkCore.location.d(this);
            this.aBC.a(this.aBN);
            this.aBC.a(this.aBO);
        }
    }

    private void kv() {
        this.zj = new com.baidu.tieba.tbadkCore.ac(getPageContext());
        this.zj.setLoadDataCallBack(new ae(this));
    }

    private void FN() {
        this.aDg = new com.baidu.tieba.tbadkCore.au();
        this.aDg.setFrom(PbActivityConfig.KEY_FROM_FRS);
        this.aDg.a(new af(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        new ag(this, str, z).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    private void FO() {
        this.aDh = new df(this);
        this.aDh.setLoadDataCallBack(new ah(this));
    }

    public void FP() {
        if (this.aDi != null && this.aCV != null) {
            if (aCK || aCL || aCM) {
                this.aDi.L(com.baidu.tbadk.coreExtra.messageCenter.a.rS().getMsgReplyme());
                this.aDi.K(com.baidu.tbadk.coreExtra.messageCenter.a.rS().getMsgAtme());
                int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.rS().getMsgChat();
                if (TbadkCoreApplication.m255getInst().getChatFloatWindowLocked() && !TbadkCoreApplication.m255getInst().isMIUIRom()) {
                    msgChat -= com.baidu.tbadk.coreExtra.messageCenter.a.rS().rZ();
                }
                this.aDi.M(msgChat);
                this.aCV.a(this.aDi, aCK, aCL, aCM);
            }
        }
    }

    private void FQ() {
        registerListener(2001122, this.aDM);
    }

    private void FR() {
        registerListener(2001124, this.aDM);
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
        if (this.aCV != null) {
            this.aCV.onDestroy();
        }
        if (this.aDv != null) {
            this.aDv.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.aDf != null) {
                this.aDf.clear();
            }
            if (this.zj != null) {
                this.zj.Hr();
            }
            if (this.aDh != null) {
                this.aDh.Hr();
            }
            if (this.aBJ != null) {
                this.aBJ.cancelLoadData();
            }
            this.aCV.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onDestory(getPageContext());
        if (this.aDo != null) {
            this.aDo.cancel(true);
            this.aDo = null;
        }
        if (this.aDe != null) {
            this.aDe.destory();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aCN);
        bundle.putString("from", this.KQ);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onSaveInstanceState(getPageContext().getPageActivity());
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aBH);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        com.baidu.tbadk.core.data.x hZ;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    eI(0);
                    return;
                case 11002:
                    kw();
                    return;
                case 11011:
                    b(this.aCY);
                    return;
                case 11012:
                    c(this.aDj);
                    return;
                case 11014:
                    FZ();
                    return;
                case 11016:
                    this.aCV.GY();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    FY();
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
                        this.aCV.A(W);
                        return;
                    }
                    return;
                case 12006:
                    WriteData Fn = this.aBJ.Fn();
                    if (Fn != null) {
                        Fn.deleteUploadedTempImages();
                    }
                    this.aDp.setIsBaobao(false);
                    this.aDp.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.aBJ.c((WriteData) null);
                    this.aBJ.eF(false);
                    this.aCV.bG(true);
                    if (this.aDq != null) {
                        com.baidu.tieba.tbadkCore.al.b(this.aDq.getTid(), (WriteData) null);
                        this.aDq.setReply_num(this.aDq.getReply_num() + 1);
                    }
                    if (this.writeImagesInfo != null) {
                        this.aCV.a(this.writeImagesInfo, true);
                    }
                    this.aCV.GN();
                    this.aCV.FB();
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
                    this.aCV.Hf().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (hZ = this.aDf.hZ(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            hZ.bv(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            hZ.parser_title();
                            refresh();
                            return;
                        } else if (intExtra == 0) {
                            this.aDf.e(hZ);
                            this.aCV.GZ();
                            if (com.baidu.tieba.tbadkCore.d.aeC() != null) {
                                com.baidu.tieba.tbadkCore.d.aeC().B(this.aCN, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    FX();
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    Fo();
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
        this.aBF = true;
        this.aDr = true;
        if (isNeedRefreshOnResume) {
            isNeedRefreshOnResume = false;
            this.aCV.jC();
        } else if (azY) {
            azY = false;
            this.aCV.jC();
        } else {
            if (!this.aCS && TbadkCoreApplication.isLogin()) {
                this.aCS = true;
                if (this.aDf != null && this.aDf.mK() != null) {
                    this.aDf.mK().setIfpost(1);
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
                this.aCN = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.KQ = intent.getStringExtra("from");
            }
            this.aCR = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aCR) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    FS();
                } else {
                    FT();
                }
            }
        }
    }

    private void FS() {
        this.aCV.jC();
        this.aCV.GG().showContent(false);
    }

    private void FT() {
        this.aCV.jC();
        this.aCV.GG().toggle(false);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.KQ)) {
                sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            } else {
                com.baidu.tbadk.core.b.b.e(getPageContext().getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.KQ)) {
            sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        } else {
            com.baidu.tbadk.core.b.b.e(getPageContext().getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.KQ)) {
            finish();
        }
    }

    private void initUI() {
        this.aCP = 1;
        this.aDd = false;
        this.aDc = 0L;
        this.mType = 3;
        if (TextUtils.isEmpty(this.aCN)) {
            this.aCN = "";
        }
        if (TextUtils.isEmpty(this.KQ)) {
            this.KQ = "";
        }
        setContentView(com.baidu.tieba.x.frs_activity);
        this.aCV = new bp(this, this.aDE);
        this.aCV.Hf().i(this.aDI);
        this.aCV.Hf().j(this.aDJ);
        if (this.aCO == 0) {
            this.aCV.setTitle(this.aCN);
        } else {
            this.aCV.setTitle("");
            this.aCO = 1;
        }
        this.aCV.a(this.aDP);
        this.aCV.a(this.aDS);
        this.aCV.k(this.aDQ);
        this.aCV.m(this.aDR);
        this.aCV.setOnScrollListener(this.aBP);
        this.aCV.a(this.azX);
        this.aCV.a(this.aDF);
        this.aCV.a(this.aDH);
        this.aCV.f(this.aDL);
        this.aCV.Hf().a(this.aDG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aCV.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public com.baidu.adp.lib.e.b<TbImageView> Fq() {
        if (this.aDk == null) {
            this.aDk = FrsCommonImageLayout.k(getPageContext().getPageActivity(), 9);
        }
        return this.aDk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fA(String str) {
        Intent I;
        com.baidu.tieba.frs.view.o GL;
        if (str != null && (I = com.baidu.tieba.frs.utils.a.I(getPageContext().getPageActivity(), str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getPageContext().getString(com.baidu.tieba.z.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", I);
            BarImageView barImageView = null;
            if (this.mPageType.equals("normal_page")) {
                FrsHeaderView GK = this.aCV.GK();
                if (GK != null) {
                    barImageView = GK.Hw();
                }
            } else if (this.mPageType.equals("frs_page") && (GL = this.aCV.GL()) != null) {
                barImageView = GL.Hw();
            }
            if (barImageView != null && barImageView.getBdImage() != null && barImageView.getBdImage().jc() != null) {
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.c.eR().a(com.baidu.adp.lib.util.c.eR().d(barImageView.getBdImage().jc(), getResources().getDimensionPixelSize(com.baidu.tieba.u.ds100)), getResources().getDimensionPixelSize(com.baidu.tieba.u.ds32)));
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
            if (this.aDf != null && this.aDf.mK() != null) {
                this.aDf.mK().setIfpost(1);
            }
            if (i == 0) {
                sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11001)));
            } else {
                sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11016)));
            }
        } else if (this.aDf != null) {
            if (i == 0) {
                AntiData mK = this.aDf.mK();
                if (AntiHelper.c(mK) || AntiHelper.d(mK) || AntiHelper.e(mK)) {
                    mK.setBlock_forum_name(this.aCN);
                    mK.setBlock_forum_id(this.aDf.aeI().getId());
                    mK.setUser_name(this.aDf.getUserData().getUserName());
                    mK.setUser_id(this.aDf.getUserData().getUserId());
                    if (AntiHelper.a(getPageContext().getPageActivity(), mK, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (this.aDf.mK() != null && this.aDf.mK().getIfpost() == 0) {
                    com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), mK.getForbid_info());
                    return;
                }
                int i2 = 0;
                if (this.aDf.getUserData() != null) {
                    i2 = this.aDf.getUserData().getIsMem();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(getPageContext().getPageActivity(), 0, this.aDf.aeI().getId(), this.aCN, null, null, 0, this.aDf.mK(), 13003, false, false, null, false, false, null, null, this.aDf.aeI().getPrefixData(), i2)));
                return;
            }
            this.aCV.GY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.x xVar) {
        boolean nF = xVar == null ? true : xVar.nF();
        this.aCV.a(new ak(this, xVar));
        this.aCV.a(xVar, nF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.x xVar) {
        boolean nF = xVar == null ? true : xVar.nF();
        if (this.mThreadId != null) {
            if (!nF) {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(xVar, this.aCN, null, 18003, true, true, this.aCU)));
            } else {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(xVar, this.aCN, null, 18003, false, false, this.aCU)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.core.data.x xVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage(2004001, new PbActivityConfig(getPageContext().getPageActivity()).createFromThreadCfg(xVar, this.aCN, null, 18003, false, false, this.aCU)));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.aCV != null && z && this.aCH) {
            this.aCH = false;
            showLoadingView(this.aCV.getRootView(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        stopVoice();
        this.aCP = 1;
        eJ(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(int i) {
        boolean z = false;
        this.mType = i;
        switch (this.mType) {
            case 1:
                if (this.aCV.Hf().Gi()) {
                    return;
                }
                break;
            case 2:
                if (this.aCV.Hf().Gj()) {
                    return;
                }
                break;
            case 3:
                if (this.aCV.GJ()) {
                    return;
                }
                break;
        }
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(this.aCN);
        fRSPageRequestMessage.setPn(this.aCP);
        if (this.aDf == null) {
            this.aDf = new com.baidu.tieba.tbadkCore.e();
        }
        fRSPageRequestMessage.setForumModel(this.aDf);
        if (com.baidu.tbadk.core.l.lV().lZ()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        if (this.aDd) {
            fRSPageRequestMessage.setIsGood(1);
            fRSPageRequestMessage.setCid((int) this.aDc);
        }
        int M = com.baidu.adp.lib.util.l.M(getPageContext().getPageActivity());
        int N = com.baidu.adp.lib.util.l.N(getPageContext().getPageActivity());
        float f = M / 320.0f;
        int i2 = com.baidu.tbadk.core.util.bg.pB().pD() ? 2 : 1;
        fRSPageRequestMessage.setScrW(M);
        fRSPageRequestMessage.setScrH(N);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i2);
        fRSPageRequestMessage.setLastId(this.aCT);
        if (this.aCW != null) {
            fRSPageRequestMessage.setStType(this.aCW);
            if (this.aCW.equalsIgnoreCase("sidebar")) {
                fRSPageRequestMessage.setStType(this.aCX);
            }
        }
        if (aCZ != 0) {
            fRSPageRequestMessage.setCtime((int) aCZ);
        }
        if (aDa != 0) {
            fRSPageRequestMessage.setDataSize((int) aDa);
        }
        if (aDb != 0) {
            fRSPageRequestMessage.setNetError(aDb);
        }
        this.aCV.bP(true);
        this.aCV.Hf().bK(false);
        this.aCV.Hf().bL(false);
        this.aCV.Hf().notifyDataSetChanged();
        if (this.aCP == 1 && ((this.mPageType.equals("normal_page") || this.mPageType.equals("frs_page")) && !this.aDd)) {
            z = true;
        }
        if (this.aDf == null) {
            this.aDf = new com.baidu.tieba.tbadkCore.e();
        }
        this.aDf.a(this.aDD);
        this.aDf.a(this, fRSPageRequestMessage, this.mType, z, this.aCN);
        if (this.aDe == null) {
            this.aDe = new com.baidu.tieba.tbadkCore.d.a("frsStat");
            this.aDe.start();
        }
    }

    private void FU() {
        switch (this.aCO) {
            case 1:
                com.baidu.adp.lib.g.l.ek().c(new al(this));
                break;
        }
        this.aCO = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FV() {
        stopVoice();
        try {
            if (this.aDf != null) {
                this.aCV.GM();
                this.aCN = this.aDf.aeI().getName();
                this.forumId = this.aDf.aeI().getId();
                this.aCV.setTitle(this.aCN);
                TbadkCoreApplication.m255getInst().setDefaultBubble(this.aDf.getUserData().getBimg_url());
                TbadkCoreApplication.m255getInst().setDefaultBubbleEndTime(this.aDf.getUserData().getBimg_end_time());
                FU();
                ArrayList<com.baidu.adp.widget.ListView.am> aeJ = this.aDf.aeJ();
                if (aeJ != null) {
                    this.aCV.a(aeJ, this.aCP, this.aDf, this.aDf.mT().mR());
                    Gb();
                    this.aCV.eZ(this.aCP);
                    if (this.mPageType.equals("frs_page")) {
                        FW();
                    } else if (this.mPageType.equals("normal_page")) {
                        this.aCV.b(this.aDf.aeI(), this.aDf);
                    }
                    this.aCV.GZ();
                    if (this.aDf.CB() == 1) {
                        this.aCV.Hf().setFromCDN(true);
                    } else {
                        this.aCV.Hf().setFromCDN(false);
                    }
                    this.aCV.eU(M(this.mType, this.aCP));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int M(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.aBF = false;
        this.aDr = false;
        this.aCV.onPause();
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.onPause(getPageContext());
        Fp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.distribute.a.uO().a(getPageContext().getPageActivity(), "frs", this.aDf.aeI().getId(), 0L);
        this.mVoiceManager = getVoiceManager();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.aCQ) {
            if (i == 4) {
                if (this.aCV.GG().isMenuShowing()) {
                    this.aCV.GG().toggle(true);
                    if (this.aCV.GF().Ho()) {
                        this.aCV.GF().bX(false);
                        refresh();
                        return true;
                    }
                    return true;
                } else if (this.aCV.Fz() != null && this.aCV.Fz().isVisible()) {
                    this.aCV.FB();
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
            if (cVar.mp()) {
                com.baidu.tbadk.core.util.bm.pO().b(getPageContext(), new String[]{cVar.Dn});
            } else if (cVar.mo()) {
                if (com.baidu.adp.lib.util.i.ff() && !com.baidu.adp.lib.util.i.fg()) {
                    trim = getPageContext().getString(com.baidu.tieba.z.frs_network_tips);
                } else if (TextUtils.isEmpty(cVar.Dy.DE.trim())) {
                    trim = getPageContext().getString(com.baidu.tieba.z.confirm_download_app);
                } else {
                    trim = cVar.Dy.DE.trim();
                }
                aVar.bT(trim);
                aVar.a(com.baidu.tieba.z.alert_yes_button, new am(this, cVar, i));
                aVar.b(com.baidu.tieba.z.alert_no_button, new an(this));
                aVar.b(getPageContext()).nQ();
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.c cVar, int i) {
        if (cVar != null) {
            if (!cVar.mn()) {
                com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), com.baidu.tieba.z.pb_app_error);
            } else if (UtilHelper.isNetOk()) {
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "frs_dl_app", null, 1, "app_name", cVar.Dp);
                com.baidu.tbadk.download.b.uV().a(cVar.Dp, cVar.Do, cVar.Dl, i, com.baidu.adp.lib.g.c.toInt(cVar.Dk, 0));
            } else {
                showToast(com.baidu.tieba.z.neterror);
            }
        }
    }

    private void FW() {
        this.aCV.a(this.aDf.aeI(), this.aDf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FX() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), "福袋", String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.FORTUNE_ADDRESS + "?fid=" + this.aDf.aeI().getId(), true, true, false, true, true)));
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.uO().a(getPageContext().getPageActivity(), cVar, str, "frs", this.aDf.aeI().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.c cVar, String str) {
        com.baidu.tbadk.distribute.a.uO().a(cVar, this.forumId, 0L, "FRS", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kw() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11002)));
            return;
        }
        if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.KQ)) {
            this.zj.setFrom(FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND);
        } else {
            this.zj.setFrom(PbActivityConfig.KEY_FROM_FRS);
        }
        this.zj.aQ(this.aDf.aeI().getName(), this.aDf.aeI().getId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FY() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
        builder.setMessage(getPageContext().getString(com.baidu.tieba.z.attention_cancel_info));
        builder.setTitle(getPageContext().getString(com.baidu.tieba.z.alert_title));
        builder.setPositiveButton(getPageContext().getString(com.baidu.tieba.z.attention_cancel), new ao(this));
        builder.setNegativeButton(getPageContext().getString(com.baidu.tieba.z.cancel), new ap(this));
        com.baidu.adp.lib.g.k.a(builder.create(), getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FZ() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 11014)));
            return;
        }
        if (this.mPageType.equals("normal_page")) {
            this.aCV.GR();
        } else if (this.mPageType.equals("frs_page")) {
            this.aCV.GT();
        }
        this.aDh.aq(this.aDf.aeI().getName(), this.aDf.aeI().getId());
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.aCV.GF().Hn()) {
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
        ArrayList<com.baidu.adp.widget.ListView.am> aeJ = this.aDf.aeJ();
        if (aeJ != null) {
            Iterator<com.baidu.adp.widget.ListView.am> it = aeJ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.am next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.x) {
                    com.baidu.tbadk.core.data.x xVar = (com.baidu.tbadk.core.data.x) next;
                    if (xVar == this.aCI) {
                        a(xVar, i);
                        this.aCI = null;
                        break;
                    } else if (xVar.getId() != null && xVar.getId().equals(this.aBG)) {
                        a(xVar, i);
                        this.aBG = null;
                        break;
                    }
                }
            }
            this.aCV.Hf().a(aeJ, this.aDf);
            this.aCV.Hf().notifyDataSetChanged();
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

    public void Ga() {
        if (this.aDf != null && this.aDf.aeI() != null && this.aDf.aeI().getBannerListData() != null) {
            String mu = this.aDf.aeI().getBannerListData().mu();
            if (!TextUtils.isEmpty(mu)) {
                this.aCT = mu;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fB(String str) {
        if (str != null) {
            if (this.aCV.GG().isMenuShowing()) {
                this.aCV.GG().toggle(true);
            }
            this.aDd = false;
            this.aCN = str;
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
        if (this.aCV == null) {
            return null;
        }
        return this.aCV.getListView();
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
    public int qI() {
        if (this.aCV == null) {
            return 0;
        }
        return this.aCV.Fh();
    }

    @Override // com.baidu.tbadk.core.view.as
    public com.baidu.adp.lib.e.b<TbImageView> qJ() {
        if (this.NV == null) {
            this.NV = UserIconBox.g(getPageContext().getPageActivity(), 8);
        }
        return this.NV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.aDi != null) {
                this.aDi.L(msgReplyme);
                this.aDi.K(msgAtme);
                if (TbadkCoreApplication.m255getInst().getChatFloatWindowLocked() && !TbadkCoreApplication.m255getInst().isMIUIRom()) {
                    this.aDi.M((msgChat - newsNotifyMessage.getMsgPrivateChat()) - newsNotifyMessage.getMsgStrangerChat());
                } else {
                    this.aDi.M(msgChat);
                }
                this.aCV.a(this.aDi, aCK, aCL, aCM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        ay Hf;
        HashMap<Integer, com.baidu.tbadk.core.data.x> Gk;
        if (this.aDf != null && this.aCV != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (Hf = this.aCV.Hf()) != null && (Gk = Hf.Gk()) != null && Gk.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.x> entry : Gk.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.x value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.c) && TextUtils.equals(((com.baidu.tbadk.core.data.c) value).Dp, downloadData.getId())) {
                            if (Hf.aD(intValue) instanceof com.baidu.tbadk.core.data.c) {
                                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) Hf.aD(intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    cVar.Dj = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!com.baidu.tbadk.core.util.bf.isEmpty(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    cVar.Dj = 0;
                                } else if (status == 1) {
                                    cVar.Dj = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.aCV.GN();
        }
    }

    private void Gb() {
        HashMap<Integer, com.baidu.tbadk.core.data.x> Gk;
        if (this.aCV != null && this.aCV.Hf() != null && (Gk = this.aCV.Hf().Gk()) != null) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.x> entry : Gk.entrySet()) {
                com.baidu.tbadk.core.data.x value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.c)) {
                    arrayList.add((com.baidu.tbadk.core.data.c) value);
                }
            }
            com.baidu.tbadk.download.b.uV().v(arrayList);
        }
    }

    public void a(int i, com.baidu.tbadk.core.data.x xVar, int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), getPageContext().getString(com.baidu.tieba.z.login_to_use), true, 0)));
            return;
        }
        if (this.aDq != xVar && xVar != null) {
            Fp();
            this.aCV.fz(null);
            this.writeImagesInfo = new WriteImagesInfo();
            this.writeImagesInfo.setMaxImagesAllowed(10);
            this.aCV.a(this.writeImagesInfo, true);
            this.aBJ.c((WriteData) null);
            this.aBJ.eF(false);
            this.aCV.FH();
            com.baidu.tieba.tbadkCore.al.a(xVar.getTid(), this);
        }
        this.aDq = xVar;
        this.aCV.a(i, xVar, i2);
        Fm();
    }

    public void Gc() {
        if (this.aCV != null) {
            this.aCV.setOnActionListener(new aq(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Boolean bool) {
        this.aCV.bV(com.baidu.tieba.tbadkCore.aa.b(this.aDf.aeI().getName(), bool));
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
        this.aBH = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        this.writeImagesInfo.addChooseFile(com.baidu.tieba.frs.utils.a.J(getPageContext().getPageActivity(), this.aBH));
        this.writeImagesInfo.updateQuality();
        this.aCV.a(this.writeImagesInfo, true);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0 && this.aCV.Fz() != null) {
            this.aCV.Fz().hQ(23);
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
                    this.aCV.a(this.writeImagesInfo, z);
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0 && this.aCV.Fz() != null) {
                this.aCV.Fz().hQ(23);
            }
        }
    }

    private void Fo() {
        new ar(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fu(String str) {
        if (this.aBJ.Fn() == null) {
            WriteData Fn = Fn();
            Fn.setWriteImagesInfo(this.writeImagesInfo);
            this.aBJ.eF(this.writeImagesInfo.size() > 0);
            this.aBJ.c(Fn);
        }
        if (this.aBJ.Fn() != null) {
            if (this.aDp.getIsBaobao()) {
                this.aBJ.Fn().setIsBaobao(true);
                this.aBJ.Fn().setBaobaoContent(this.aDp.getBaobaoContent());
                this.aBJ.Fn().setBaobaoImagesInfo(this.baobaoImagesInfo);
            } else {
                this.aBJ.Fn().setIsBaobao(false);
                this.aBJ.Fn().setBaobaoContent("");
                this.baobaoImagesInfo.clear();
            }
            if (this.aCV.Fz() != null) {
                this.aBJ.Fn().setHasLocationData(this.aCV.Fz().getLocationInfoViewState() == 2);
            }
            VoiceData.VoiceModel audioData = this.aCV.getAudioData();
            this.aBJ.Fn().setIsFrsReply(true);
            this.aBJ.Fn().setContent(this.aCV.FG());
            this.aCV.FI();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.aBJ.Fn().setVoice(audioData.getId());
                    this.aBJ.Fn().setVoiceDuringTime(audioData.duration);
                } else {
                    this.aBJ.Fn().setVoice(null);
                    this.aBJ.Fn().setVoiceDuringTime(-1);
                }
            } else {
                this.aBJ.Fn().setVoice(null);
                this.aBJ.Fn().setVoiceDuringTime(-1);
            }
            if (!this.aBJ.aiB()) {
                showToast(com.baidu.tieba.z.write_img_limit);
            } else if (this.aBJ.aiA()) {
                showProgressBar();
            }
        }
    }

    private WriteData Fn() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.aDf.aeI().getId());
        writeData.setForumName(this.aDf.aeI().getName());
        writeData.setThreadId(this.aDq.getTid());
        writeData.setIsAd(false);
        writeData.setType(1);
        return writeData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.aDq.nn());
            antiData.setBlock_forum_id(this.aDf.aeI().getId());
            antiData.setUser_name(this.aDq.getAuthor().getUserName());
            antiData.setUser_id(this.aDq.getAuthor().getUserId());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.l.showToast(getPageContext().getPageActivity(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, com.baidu.tieba.tbadkCore.f.f fVar) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.aDq.nn());
            antiData.setBlock_forum_id(this.aDf.aeI().getId());
            antiData.setUser_name(this.aDq.getAuthor().getUserName());
            antiData.setUser_id(this.aDq.getAuthor().getUserId());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
            return;
        }
        com.baidu.tieba.tbadkCore.f.g.d(getPageContext().getPageActivity(), fVar.getErrorString(), fVar.aiD(), fVar.aiE());
    }

    @Override // com.baidu.tieba.tbadkCore.am
    public void a(WriteData writeData) {
        if (writeData != null && this.aDq != null && writeData.getThreadId().equals(this.aDq.getTid())) {
            if (!com.baidu.tbadk.core.util.bf.isEmpty(writeData.getContent()) && com.baidu.tbadk.core.util.bf.isEmpty(this.aCV.FG())) {
                this.aCV.fz(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                this.aCV.a(this.writeImagesInfo, true);
            }
            if (TbadkCoreApplication.m255getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.aDp.setIsBaobao(writeData.getIsBaobao());
                this.aDp.setBaobaoContent(writeData.getBaobaoContent());
                this.aCV.setBaobaoUris(this.baobaoImagesInfo);
            }
        }
    }

    public void Gd() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.l.c(getPageContext().getPageActivity(), getCurrentFocus());
        }
    }

    private void Fp() {
        if (this.aDq != null) {
            WriteData Fn = this.aBJ.Fn();
            if (Fn == null) {
                Fn = new WriteData(1);
                Fn.setThreadId(this.aDq.getTid());
                Fn.setWriteImagesInfo(this.writeImagesInfo);
            }
            Fn.setContent(this.aCV.FG());
            if (this.aDp != null && this.aDp.getIsBaobao()) {
                Fn.setBaobaoContent(this.aDp.getBaobaoContent());
                Fn.setBaobaoImagesInfo(this.baobaoImagesInfo);
                Fn.setIsBaobao(true);
            }
            com.baidu.tieba.tbadkCore.al.b(this.aDq.getTid(), Fn);
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
                this.aCV.setBaobaoUris(this.baobaoImagesInfo);
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    if (this.aCV.Fz() != null) {
                        this.aCV.Fz().hQ(48);
                    }
                    this.aDp.setIsBaobao(true);
                    this.aDp.setBaobaoContent(stringExtra2);
                    this.aDp.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.aDp.setIsBaobao(false);
                this.aDp.setBaobaoContent("");
                this.aDp.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.aCV.getRootView());
        showLoadingView(this.aCV.getRootView(), true);
        this.aCV.jC();
    }
}
