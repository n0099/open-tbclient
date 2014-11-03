package com.baidu.tieba.frs;

import android.app.Activity;
import android.app.AlertDialog;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
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
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.BaobaoSdkDelegate;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.view.FrsCommonImageLayout;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class FrsActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c, com.baidu.tbadk.core.view.ae, com.baidu.tbadk.core.voice.o, com.baidu.tieba.util.m, com.baidu.tieba.view.q {
    public static String aAq;
    private static boolean aBe;
    private com.baidu.adp.lib.e.b<TbImageView> Iv;
    private cz aAR;
    private com.baidu.adp.lib.e.b<TbImageView> aAS;
    private bc aAV;
    private com.baidu.tbadk.core.data.q aAX;
    private com.baidu.tbadk.core.data.q aAs;
    private com.baidu.tieba.location.d ayB;
    private boolean ayE;
    private String ayF;
    private String ayG;
    private com.baidu.tieba.model.ar ayI;
    VoiceManager ayx;
    private static boolean aAu = true;
    private static boolean aAv = true;
    private static boolean aAw = true;
    public static boolean avT = false;
    private static volatile long aAJ = 0;
    private static volatile long aAK = 0;
    private static volatile int aAL = 0;
    public static final CustomMessageListener aBa = new ao(2012111);
    private static final CustomMessageListener aBb = new ax(2012112);
    private boolean ayC = false;
    private boolean aAr = true;
    private boolean aAt = false;
    private int mType = 3;
    private String aAx = null;
    private String Gp = null;
    private int aAy = 0;
    private int aAz = 1;
    private boolean aAA = false;
    private boolean aAB = false;
    private boolean aAC = false;
    private String aAD = null;
    private String mThreadId = null;
    private String forumId = null;
    private boolean aAE = false;
    private bu aAF = null;
    private String aAG = null;
    private String aAH = null;
    private final com.baidu.tbadk.core.data.q aAI = null;
    private long aAM = 0;
    private boolean aAN = false;
    private com.baidu.tieba.b.a aAO = null;
    private b azN = null;
    private com.baidu.tieba.model.ag avA = null;
    private com.baidu.tieba.model.bc aAP = null;
    private com.baidu.tieba.model.ay aAQ = null;
    private String mPageType = "normal_page";
    private com.baidu.tbadk.core.data.q amK = null;
    private boolean aAT = false;
    private long aAU = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private WriteData aAW = new WriteData();
    private boolean aAY = true;
    private CustomMessageListener ayK = new g(this, 2004004);
    private CustomMessageListener aAZ = new r(this, 2001197);
    private final com.baidu.tieba.model.as ayL = new ad(this);
    public final CustomMessageListener aBc = new ay(this, 2012111);
    private final dd aBd = new az(this);
    private com.baidu.tieba.location.i ayM = new ba(this);
    private com.baidu.tieba.location.j ayN = new bb(this);
    private final CustomMessageListener Sg = new h(this, 2003003);
    private final CustomMessageListener mMemListener = new i(this, 2001200);
    private final com.baidu.adp.widget.ListView.f avS = new j(this);
    private final View.OnClickListener aBf = new k(this);
    private final AbsListView.OnScrollListener ayO = new l(this);
    private final SlidingMenu.OnClosedListener aBg = new m(this);
    private final be aBh = new n(this);
    private final df ayR = new df(this, new o(this));
    private final SlidingMenu.OnOpenedListener aBi = new p(this);
    private final View.OnClickListener aBj = new q(this);
    private final View.OnClickListener aBk = new s(this);
    private final AdapterView.OnItemClickListener aBl = new t(this);
    private final com.baidu.tbadk.core.view.u aBm = new u(this);
    private final CustomMessageListener aBn = new v(this, 0);
    private AlertDialog ayP = null;
    private final com.baidu.adp.framework.listener.e aBo = new w(this, 301001);
    private final HttpMessageListener aBp = new x(this, CmdConfigHttp.FRS_HTTP_CMD);
    private com.baidu.adp.widget.ListView.am aBq = new y(this);
    private View.OnClickListener aBr = new aa(this);
    private View.OnClickListener aBs = new ab(this);
    private com.baidu.adp.widget.ListView.an aBt = new ac(this);

    static {
        Fm();
        Fn();
        Fo();
        MessageManager.getInstance().registerListener(aBa);
        MessageManager.getInstance().registerListener(aBb);
        com.baidu.tieba.ai.a(301001, FRSPageSocketResponsedMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, com.baidu.tieba.ai.s("c/f/frs/page", 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.location.d.Sx();
        aBe = false;
    }

    private static void Fm() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003000, new ae());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Fn() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003001, new af());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Fo() {
        com.baidu.tbadk.core.util.bg.mR().a(new ag());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m251getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ey() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this)));
    }

    public void Ez() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this)) {
            showToast(com.baidu.tieba.y.location_system_permission_prompt);
        } else if (!TbadkApplication.m251getInst().getLocationShared()) {
            EA();
        } else if (this.ayB.Sw()) {
            Ey();
        } else {
            this.ayB.dx(false);
            if (this.aAF.EQ() != null) {
                this.aAF.EQ().setLocationViewVisibility(0);
                this.aAF.EQ().setLocationInfoViewState(1);
            }
            this.ayB.Su();
        }
    }

    private void EA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.aX(com.baidu.tieba.y.location_app_permission_prompt).a(com.baidu.tieba.y.isopen, new ah(this)).b(com.baidu.tieba.y.cancel, new ai(this)).kT();
        aVar.kW();
    }

    private void EB() {
        PbEditor EQ = this.aAF.EQ();
        if (EQ != null) {
            if (this.ayB.Sy()) {
                EQ.setLocationViewVisibility(0);
                if (this.ayB.Sw()) {
                    this.ayM.a(com.baidu.tieba.location.c.Sr().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.m.isNetOk()) {
                    EQ.setLocationInfoViewState(1);
                    this.ayB.Su();
                    return;
                } else {
                    EQ.setLocationInfoViewState(0);
                    return;
                }
            }
            EQ.setLocationViewVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(b bVar) {
        if (bVar != null && bVar.zL() != null) {
            this.aAF.Gk().u(bVar.zL().getRecommendForumData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(b bVar) {
        if (bVar != null && bVar.zL() != null) {
            if (this.azN != null) {
                this.azN.a(bVar.zL().getAnchorPower());
            }
            this.aAF.i(bVar);
            ArrayList<LiveCardData> Fa = bVar.Fa();
            ArrayList<com.baidu.adp.widget.ListView.al> Fg = bVar.Fg();
            if (Fa != null && Fa.size() > 0 && Fg != null && Fg.size() > 0) {
                int size = Fg.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!(Fg.get(i) instanceof com.baidu.tbadk.core.data.i)) {
                        i++;
                    } else {
                        Fg.remove(i);
                        break;
                    }
                }
                int Fj = bVar.Fj();
                com.baidu.tbadk.core.data.i iVar = new com.baidu.tbadk.core.data.i();
                iVar.g(Fa);
                bVar.Fg().add(Fj, iVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aAq = "speed_icon_show" + TbadkApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (bundle != null) {
            this.aAx = bundle.getString("name");
            this.Gp = bundle.getString("from");
            this.aAy = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (intent != null) {
            this.aAx = intent.getStringExtra("name");
            this.Gp = intent.getStringExtra("from");
            this.aAy = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (intent != null) {
            this.aAU = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aAU = System.currentTimeMillis();
        }
        if (bS(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && !xh()) {
            registerListener(this.Sg);
            registerListener(this.mMemListener);
            registerListener(this.aBo);
            registerListener(this.aBp);
            registerListener(this.aBc);
            registerListener(this.ayK);
            registerListener(this.aAZ);
            this.ayx = getVoiceManager();
            this.ayx.onCreate(this);
            initUI();
            d(bundle);
            this.aAF.hO();
            this.ayR.setUniqueId(getUniqueId());
            this.ayR.registerListener();
            addGlobalLayoutListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.aAF != null && this.aAF.EQ() != null) {
            this.aAF.EQ().BG();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.ayx = getVoiceManager();
        this.ayx.onStart(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(b bVar) {
        if (bVar != null) {
            try {
                if (bVar.yW() == 1) {
                    this.aAF.GJ().setFromCDN(true);
                } else {
                    this.aAF.GJ().setFromCDN(false);
                }
                this.aAF.a(bVar.zL(), bVar.getUserData());
                if (bVar.Fh().zi() == 1) {
                    this.mPageType = "frs_page";
                    this.aAF.L(bVar.getUserData().getIsMem(), this.azN.zL().isLike());
                } else {
                    this.mPageType = "normal_page";
                    this.aAF.K(bVar.getUserData().getIsMem(), this.azN.zL().isLike());
                }
                this.aAF.Gq();
                this.aAx = bVar.zL().getName();
                this.forumId = bVar.zL().getId();
                this.aAF.setTitle(this.aAx);
                Fx();
                bVar.Fk();
                bVar.U(this);
                bVar.Fl();
                e(bVar);
                com.baidu.tbadk.core.data.s top_notice_data = bVar.zL().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.getTitle() != null) {
                    com.baidu.tbadk.core.data.q qVar = new com.baidu.tbadk.core.data.q();
                    qVar.setTitle(top_notice_data.getTitle());
                    qVar.aT(2);
                    qVar.ba(top_notice_data.kO());
                    qVar.parser_title();
                    bVar.b(qVar);
                }
                ArrayList<com.baidu.adp.widget.ListView.al> Fg = bVar.Fg();
                if (Fg != null) {
                    this.aAF.a(Fg, this.aAz, this.azN, bVar.zO().kh());
                    FF();
                    this.aAF.eV(this.aAz);
                    if (this.mPageType.equals("frs_page")) {
                        this.aAF.a(bVar.zL(), bVar);
                    } else if (this.mPageType.equals("normal_page")) {
                        this.aAF.b(bVar.zL(), bVar);
                    }
                    this.aAF.GD();
                    this.aAF.eQ(0);
                }
                if (bVar.Ff()) {
                    if (this.aAF.Go() != null) {
                        this.aAF.Go().Hb();
                    }
                    if (this.aAF.Gp() != null) {
                        this.aAF.Gp().Hb();
                    }
                } else {
                    if (this.aAF.Go() != null) {
                        this.aAF.Go().Ha();
                    }
                    if (this.aAF.Gp() != null) {
                        this.aAF.Gp().Ha();
                    }
                }
                hideLoadingView(this.aAF.getRootView());
                this.aAt = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void d(Bundle bundle) {
        Ft();
        this.aAC = TbadkApplication.isLogin();
        if (bundle != null) {
            this.aAx = bundle.getString("name");
            this.Gp = bundle.getString("from");
            this.aAy = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            this.aAx = intent.getStringExtra("name");
            this.Gp = intent.getStringExtra("from");
            this.aAy = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            this.aAN = intent.getBooleanExtra(FrsActivityConfig.GOOD, false);
        }
        if (this.aAx != null && this.aAx.length() > 0) {
            if (this.Gp == null || this.Gp.length() <= 0) {
                this.Gp = FrsActivityConfig.FRS_FROM_LIKE;
            }
            this.aAG = this.Gp;
            Fp();
            Fq();
            Fr();
            this.aAR = new cz(this);
            if (this.aAC) {
                Fs();
                Fu();
            }
            if (bundle != null) {
                this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
                this.ayG = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            this.writeImagesInfo.setMaxImagesAllowed(10);
            this.ayI = new com.baidu.tieba.model.ar(this);
            this.ayI.a(this.ayL);
            this.ayB = new com.baidu.tieba.location.d(this);
            this.ayB.a(this.ayM);
            this.ayB.a(this.ayN);
        }
    }

    private void Fp() {
        this.avA = new com.baidu.tieba.model.ag(this);
        this.avA.setLoadDataCallBack(new aj(this));
    }

    private void Fq() {
        this.aAP = new com.baidu.tieba.model.bc();
        this.aAP.setFrom(PbActivityConfig.KEY_FROM_FRS);
        this.aAP.a(new ak(this));
    }

    private void Fr() {
        this.aAQ = new com.baidu.tieba.model.ay(this);
        this.aAQ.setLoadDataCallBack(new al(this));
    }

    public void Fs() {
        if (this.aAR != null && this.aAF != null) {
            if (aAu || aAv || aAw) {
                this.aAR.A(com.baidu.tbadk.coreExtra.messageCenter.a.oD().getMsgReplyme());
                this.aAR.z(com.baidu.tbadk.coreExtra.messageCenter.a.oD().getMsgAtme());
                this.aAR.B(com.baidu.tbadk.coreExtra.messageCenter.a.oD().getMsgChat());
                this.aAF.a(this.aAR, aAu, aAv, aAw);
            }
        }
    }

    private void Ft() {
        registerListener(2001122, this.aBn);
    }

    private void Fu() {
        registerListener(2001124, this.aBn);
    }

    private boolean xh() {
        if ("from_hao123".equals(getIntent().getStringExtra("from")) && com.baidu.tieba.util.q.l(this)) {
            Intent intent = new Intent();
            intent.putExtra("class", 2);
            intent.putExtra(ImageViewerConfig.FORUM_NAME, getIntent().getStringExtra("name"));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LogoActivityConfig(this, intent)));
            finish();
            return true;
        }
        return false;
    }

    private boolean bS(boolean z) {
        if (z && com.baidu.tieba.frs.a.a.y(this, getClass().getName())) {
            Intent intent = new Intent();
            intent.putExtra("class", 2);
            intent.putExtra(ImageViewerConfig.FORUM_NAME, getIntent().getStringExtra("name"));
            intent.putExtra("from", "short_cut");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LogoActivityConfig(this, intent)));
            finish();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.aAF != null) {
            this.aAF.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.azN != null) {
                this.azN.clear();
            }
            if (this.avA != null) {
                this.avA.TI();
            }
            if (this.aAQ != null) {
                this.aAQ.TI();
            }
            if (this.ayI != null) {
                this.ayI.cancelLoadData();
            }
            this.aAF.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.ayx = getVoiceManager();
        this.ayx.onDestory(this);
        com.baidu.tieba.aj.wm().wT();
        if (this.aAV != null) {
            this.aAV.cancel(true);
            this.aAV = null;
        }
        if (this.aAO != null) {
            this.aAO.ya();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aAx);
        bundle.putString("from", this.Gp);
        this.ayx = getVoiceManager();
        if (this.ayx != null) {
            this.ayx.onSaveInstanceState(this);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ayG);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int size;
        com.baidu.tbadk.core.data.q fe;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    eE(0);
                    return;
                case 11002:
                    FB();
                    return;
                case 11011:
                    e(this.aAI);
                    return;
                case 11012:
                    f(this.amK);
                    return;
                case 11014:
                    FD();
                    return;
                case 11016:
                    this.aAF.GC();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    FC();
                    return;
                case 12001:
                    if (this.writeImagesInfo != null) {
                        FH();
                        int size2 = this.writeImagesInfo.size() - 1;
                        if (size2 > -1 && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this, 12012, this.writeImagesInfo, size2)));
                            return;
                        }
                        return;
                    }
                    return;
                case 12002:
                    e(intent);
                    return;
                case 12004:
                    ArrayList<String> p = com.baidu.tieba.util.i.p(intent);
                    if (p != null) {
                        this.aAF.p(p);
                        return;
                    }
                    return;
                case 12006:
                    WriteData EE = this.ayI.EE();
                    if (EE != null) {
                        EE.deleteUploadedTempImages();
                    }
                    this.aAW.setIsBaobao(false);
                    this.aAW.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.ayI.b((WriteData) null);
                    this.ayI.dI(false);
                    this.aAF.bQ(true);
                    if (this.aAX != null) {
                        com.baidu.tieba.util.l.b(this.aAX.getTid(), (WriteData) null);
                        this.aAX.setReply_num(this.aAX.getReply_num() + 1);
                    }
                    if (this.writeImagesInfo != null) {
                        this.aAF.a(this.writeImagesInfo, true);
                    }
                    this.aAF.Gr();
                    this.aAF.ER();
                    return;
                case 12012:
                    f(intent);
                    return;
                case 12013:
                    h(intent);
                    return;
                case 13003:
                    refresh();
                    return;
                case 18003:
                    this.aAF.GJ().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (fe = this.azN.fe(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            fe.aU(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            fe.parser_title();
                            refresh();
                            return;
                        } else if (intExtra == 0) {
                            this.azN.c(fe);
                            this.aAF.GD();
                            if (a.EX() != null) {
                                a.EX().u(this.aAx, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    FA();
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    EF();
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
        this.mHandler.postDelayed(new am(this), 10L);
        this.ayE = true;
        this.aAY = true;
        if (aBe) {
            aBe = false;
            this.aAF.hO();
        } else if (avT) {
            avT = false;
            this.aAF.hO();
        } else {
            if (!this.aAC && TbadkApplication.isLogin()) {
                this.aAC = true;
                if (this.azN != null && this.azN.jZ() != null) {
                    this.azN.jZ().setIfpost(1);
                }
                refresh();
            }
            this.ayx = getVoiceManager();
            this.ayx.onResume(this);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.aAx = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.Gp = intent.getStringExtra("from");
            }
            this.aAB = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aAB) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    Fv();
                } else {
                    Fw();
                }
            }
        }
    }

    private void Fv() {
        this.aAF.hO();
        this.aAF.getSlidingMenu().showContent(false);
    }

    private void Fw() {
        this.aAF.hO();
        this.aAF.getSlidingMenu().toggle(false);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.Gp)) {
                sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(this).createNormalCfg(1)));
            } else {
                com.baidu.tbadk.core.b.b.d(this, 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.Gp)) {
            sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(this).createNormalCfg(2)));
        } else {
            com.baidu.tbadk.core.b.b.d(this, 2);
        }
    }

    private void initUI() {
        this.aAz = 1;
        this.aAN = false;
        this.aAM = 0L;
        this.mType = 3;
        if (TextUtils.isEmpty(this.aAx)) {
            this.aAx = "";
        }
        if (TextUtils.isEmpty(this.Gp)) {
            this.Gp = "";
        }
        setContentView(com.baidu.tieba.w.frs_activity);
        this.aAF = new bu(this, this.aBf);
        this.aAF.GJ().i(this.aBj);
        this.aAF.GJ().j(this.aBk);
        if (this.aAy == 0) {
            this.aAF.setTitle(this.aAx);
        } else {
            this.aAF.setTitle("");
            this.aAy = 1;
        }
        this.aAF.a(this.aBq);
        this.aAF.a(this.aBt);
        this.aAF.k(this.aBr);
        this.aAF.m(this.aBs);
        this.aAF.setOnScrollListener(this.ayO);
        this.aAF.a(this.avS);
        this.aAF.a(this.aBg);
        this.aAF.a(this.aBi);
        this.aAF.f(this.aBm);
        this.aAF.GJ().a(this.aBh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aAF.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.view.q
    public com.baidu.adp.lib.e.b<TbImageView> EH() {
        if (this.aAS == null) {
            this.aAS = FrsCommonImageLayout.l(this, 6);
        }
        return this.aAS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ff(String str) {
        Intent A;
        com.baidu.tieba.frs.view.r Gp;
        if (str != null && (A = com.baidu.tieba.frs.a.a.A(this, str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getString(com.baidu.tieba.y.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", A);
            BarImageView barImageView = null;
            if (this.mPageType.equals("normal_page")) {
                FrsHeaderView Go = this.aAF.Go();
                if (Go != null) {
                    barImageView = Go.GX();
                }
            } else if (this.mPageType.equals("frs_page") && (Gp = this.aAF.Gp()) != null) {
                barImageView = Gp.GX();
            }
            if (barImageView != null && barImageView.getBdImage() != null && barImageView.getBdImage().hl() != null) {
                intent.putExtra("android.intent.extra.shortcut.ICON", com.baidu.adp.lib.util.c.eS().a(com.baidu.adp.lib.util.c.eS().a(barImageView.getBdImage().hl(), getResources().getDimensionPixelSize(com.baidu.tieba.t.ds100)), getResources().getDimensionPixelSize(com.baidu.tieba.t.ds32)));
            } else {
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, com.baidu.tieba.u.icon));
            }
            sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(int i) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            if (this.azN != null && this.azN.jZ() != null) {
                this.azN.jZ().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11016);
            }
        } else if (this.azN != null) {
            if (i == 0) {
                AntiData jZ = this.azN.jZ();
                if (AntiHelper.c(jZ) || AntiHelper.d(jZ) || AntiHelper.e(jZ)) {
                    jZ.setBlock_forum_name(this.aAx);
                    jZ.setBlock_forum_id(this.azN.zL().getId());
                    jZ.setUser_name(this.azN.getUserData().getUserName());
                    jZ.setUser_id(this.azN.getUserData().getUserId());
                    if (AntiHelper.a(this, jZ, AntiHelper.OperationType.CREATE_THREAD, AntiHelper.PageType.FRS)) {
                        return;
                    }
                }
                if (this.azN.jZ() != null && this.azN.jZ().getIfpost() == 0) {
                    com.baidu.adp.lib.util.m.showToast(this, jZ.getForbid_info());
                    return;
                }
                int i2 = 0;
                if (this.azN.getUserData() != null) {
                    i2 = this.azN.getUserData().getIsMem();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(this, 0, this.azN.zL().getId(), this.aAx, null, null, 0, this.azN.jZ(), 13003, false, false, null, false, false, null, null, this.azN.zL().getPrefixData(), i2)));
                return;
            }
            this.aAF.GC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.q qVar) {
        boolean kI = qVar == null ? true : qVar.kI();
        this.aAF.a(new an(this, qVar));
        this.aAF.a(qVar, kI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tbadk.core.data.q qVar) {
        boolean kI = qVar == null ? true : qVar.kI();
        if (this.mThreadId != null) {
            if (!kI) {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(this).createFromThreadCfg(qVar, this.aAx, null, 18003, true, true, this.aAE)));
            } else {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(this).createFromThreadCfg(qVar, this.aAx, null, 18003, false, false, this.aAE)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.core.data.q qVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage(2004001, new PbActivityConfig(this).createFromThreadCfg(qVar, this.aAx, null, 18003, false, false, this.aAE)));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            if (this.aAr) {
                this.aAr = false;
                showLoadingView(this.aAF.getRootView(), true);
                return;
            }
            return;
        }
        hideLoadingView(this.aAF.getRootView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        EC();
        this.aAz = 1;
        eF(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eF(int i) {
        boolean z = false;
        this.mType = i;
        switch (this.mType) {
            case 1:
                if (this.aAF.GJ().FM()) {
                    return;
                }
                break;
            case 2:
                if (this.aAF.GJ().FN()) {
                    return;
                }
                break;
            case 3:
                if (this.aAF.Gn()) {
                    return;
                }
                break;
        }
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(this.aAx);
        fRSPageRequestMessage.setPn(this.aAz);
        if (this.azN == null) {
            this.azN = new b();
        }
        fRSPageRequestMessage.setForumModel(this.azN);
        if (com.baidu.tbadk.core.l.js().jw()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        if (this.aAN) {
            fRSPageRequestMessage.setIsGood(1);
            fRSPageRequestMessage.setCid((int) this.aAM);
        }
        int n = com.baidu.adp.lib.util.m.n(this);
        int o = com.baidu.adp.lib.util.m.o(this);
        float f = n / 320.0f;
        int i2 = com.baidu.tbadk.core.util.ba.mD().mF() ? 2 : 1;
        fRSPageRequestMessage.setScrW(n);
        fRSPageRequestMessage.setScrH(o);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i2);
        fRSPageRequestMessage.setLastId(this.aAD);
        if (this.aAG != null) {
            fRSPageRequestMessage.setStType(this.aAG);
            if (this.aAG.equalsIgnoreCase("sidebar")) {
                fRSPageRequestMessage.setStType(this.aAH);
            }
        }
        if (aAJ != 0) {
            fRSPageRequestMessage.setCtime((int) aAJ);
        }
        if (aAK != 0) {
            fRSPageRequestMessage.setDataSize((int) aAK);
        }
        if (aAL != 0) {
            fRSPageRequestMessage.setNetError(aAL);
        }
        this.aAF.cb(true);
        this.aAF.GJ().bW(false);
        this.aAF.GJ().bX(false);
        this.aAF.GJ().notifyDataSetChanged();
        if (this.aAz == 1 && ((this.mPageType.equals("normal_page") || this.mPageType.equals("frs_page")) && !this.aAN)) {
            z = true;
        }
        if (this.azN == null) {
            this.azN = new b();
        }
        this.azN.a(this.aBd);
        this.azN.a(this, fRSPageRequestMessage, this.mType, z, this.aAx);
        if (this.aAO == null) {
            this.aAO = new com.baidu.tieba.b.a("frsStat");
            this.aAO.start();
        }
    }

    private void Fx() {
        switch (this.aAy) {
            case 1:
                com.baidu.adp.lib.g.k.el().b(new ap(this));
                break;
        }
        this.aAy = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fy() {
        EC();
        try {
            if (this.azN != null) {
                this.aAF.Gq();
                this.aAx = this.azN.zL().getName();
                this.forumId = this.azN.zL().getId();
                this.aAF.setTitle(this.aAx);
                TbadkApplication.m251getInst().setDefaultBubble(this.azN.getUserData().getBimg_url());
                TbadkApplication.m251getInst().setDefaultBubbleEndTime(this.azN.getUserData().getBimg_end_time());
                Fx();
                ArrayList<com.baidu.adp.widget.ListView.al> Fg = this.azN.Fg();
                if (Fg != null) {
                    this.aAF.a(Fg, this.aAz, this.azN, this.azN.zO().kh());
                    FF();
                    this.aAF.eV(this.aAz);
                    if (this.mPageType.equals("frs_page")) {
                        Fz();
                    } else if (this.mPageType.equals("normal_page")) {
                        this.aAF.b(this.azN.zL(), this.azN);
                    }
                    this.aAF.GD();
                    if (this.azN.yW() == 1) {
                        this.aAF.GJ().setFromCDN(true);
                    } else {
                        this.aAF.GJ().setFromCDN(false);
                    }
                    this.aAF.eQ(J(this.mType, this.aAz));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int J(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.ayE = false;
        this.aAY = false;
        this.aAF.onPause();
        this.ayx = getVoiceManager();
        this.ayx.onPause(this);
        EG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.distribute.a.rc().a(this, "frs", this.azN.zL().getId(), 0L);
        this.ayx = getVoiceManager();
        if (this.ayx != null) {
            this.ayx.onStop(this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.aAA) {
            if (i == 4) {
                if (this.aAF.getSlidingMenu().isMenuShowing()) {
                    this.aAF.getSlidingMenu().toggle(true);
                    if (this.aAF.Gk().GQ()) {
                        this.aAF.Gk().ch(false);
                        refresh();
                        return true;
                    }
                    return true;
                } else if (this.aAF.EQ() != null && this.aAF.EQ().isVisible()) {
                    this.aAF.ER();
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

    public void a(com.baidu.tbadk.core.data.a aVar, int i) {
        String trim;
        if (aVar != null) {
            com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(this);
            aVar2.aW(com.baidu.tieba.y.anti_title);
            if (aVar.jH()) {
                com.baidu.tbadk.core.util.bg.mR().b(this, new String[]{aVar.zj});
            } else if (aVar.jG()) {
                if (com.baidu.adp.lib.util.j.fh() && !com.baidu.adp.lib.util.j.fi()) {
                    trim = getString(com.baidu.tieba.y.frs_network_tips);
                } else if (TextUtils.isEmpty(aVar.zu.zz.trim())) {
                    trim = getString(com.baidu.tieba.y.confirm_download_app);
                } else {
                    trim = aVar.zu.zz.trim();
                }
                aVar2.bg(trim);
                aVar2.a(com.baidu.tieba.y.alert_yes_button, new aq(this, aVar, i));
                aVar2.b(com.baidu.tieba.y.alert_no_button, new ar(this));
                aVar2.kT().kW();
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.a aVar, int i) {
        if (aVar != null) {
            if (!aVar.jF()) {
                com.baidu.adp.lib.util.m.showToast(this, com.baidu.tieba.y.pb_app_error);
            } else if (UtilHelper.isNetOk()) {
                TiebaStatic.eventStat(this, "frs_dl_app", null, 1, "app_name", aVar.zl);
                com.baidu.tbadk.download.b.rj().a(aVar.zl, aVar.zk, aVar.zh, i);
            } else {
                showToast(com.baidu.tieba.y.neterror);
            }
        }
    }

    private void Fz() {
        this.aAF.a(this.azN.zL(), this.azN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FA() {
        com.baidu.tbadk.browser.a.i(this, String.valueOf(TbConfig.SERVER_ADDRESS) + "mo/q/fudaiindex?fid=" + this.azN.zL().getId());
    }

    public void a(com.baidu.tbadk.core.data.a aVar, String str) {
        com.baidu.tbadk.distribute.a.rc().a(this, aVar, str, "frs", this.azN.zL().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.a aVar, String str) {
        com.baidu.tbadk.distribute.a.rc().a(aVar, this.forumId, 0L, "FRS", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FB() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11002);
            return;
        }
        this.avA.setFrom(PbActivityConfig.KEY_FROM_FRS);
        this.avA.ay(this.azN.zL().getName(), this.azN.zL().getId());
    }

    protected void FC() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(com.baidu.tieba.y.attention_cancel_info));
        builder.setTitle(getString(com.baidu.tieba.y.alert_title));
        builder.setPositiveButton(getString(com.baidu.tieba.y.attention_cancel), new as(this));
        builder.setNegativeButton(getString(com.baidu.tieba.y.cancel), new at(this));
        com.baidu.adp.lib.g.j.a(builder.create(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FD() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11014);
            return;
        }
        if (this.mPageType.equals("normal_page")) {
            this.aAF.Gv();
        } else if (this.mPageType.equals("frs_page")) {
            this.aAF.Gx();
        }
        this.aAQ.az(this.azN.zL().getName(), this.azN.zL().getId());
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.aAF.Gk().GP()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (!PluginCenter.getInstance().checkPluginInstalled(PluginNameList.NAME_NIGHT_RESOURCE)) {
                    this.aAF.Gk().GP().B(false);
                    showToast(com.baidu.tieba.y.plugin_night_resource_init_doing);
                    return;
                } else if (TbadkApplication.m251getInst().getSkinType() != 1) {
                    TiebaStatic.eventStat(this, "frs_night_mode", "frsclick", 1, new Object[0]);
                    com.baidu.tieba.aj.wm().setSkinType(1);
                    this.mSkinType = 1;
                    TiebaStatic.eventStat(TbadkApplication.m251getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                } else {
                    return;
                }
            } else if (TbadkApplication.m251getInst().getSkinType() != 0) {
                com.baidu.tieba.aj.wm().setSkinType(0);
                this.mSkinType = 0;
            } else {
                return;
            }
            onChangeSkinType(this.mSkinType);
            com.baidu.tbadk.core.util.d.lp();
            com.baidu.tieba.pb.main.bs.Xc().reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eD(int i) {
        ArrayList<com.baidu.adp.widget.ListView.al> Fg = this.azN.Fg();
        if (Fg != null) {
            Iterator<com.baidu.adp.widget.ListView.al> it = Fg.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.al next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.q) {
                    com.baidu.tbadk.core.data.q qVar = (com.baidu.tbadk.core.data.q) next;
                    if (qVar == this.aAs) {
                        a(qVar, i);
                        this.aAs = null;
                        break;
                    } else if (qVar.getId() != null && qVar.getId().equals(this.ayF)) {
                        a(qVar, i);
                        this.ayF = null;
                        break;
                    }
                }
            }
            this.aAF.GJ().a(Fg, this.azN);
            this.aAF.GJ().notifyDataSetChanged();
        }
    }

    private void a(com.baidu.tbadk.core.data.q qVar, int i) {
        if (i == 1) {
            PraiseData praise = qVar.getPraise();
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
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
                    qVar.setPraise(praiseData);
                    return;
                }
                qVar.getPraise().getUser().add(0, metaData);
                qVar.getPraise().setNum(qVar.getPraise().getNum() + 1);
                qVar.getPraise().setIsLike(i);
            }
        } else if (qVar.getPraise() != null) {
            qVar.getPraise().setIsLike(i);
            qVar.getPraise().setNum(qVar.getPraise().getNum() - 1);
            ArrayList<MetaData> user = qVar.getPraise().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkApplication.getCurrentAccountObj().getID())) {
                        qVar.getPraise().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    public void FE() {
        if (this.azN != null && this.azN.zL() != null && this.azN.zL().getBannerListData() != null) {
            String jM = this.azN.zL().getBannerListData().jM();
            if (!TextUtils.isEmpty(jM)) {
                this.aAD = jM;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fg(String str) {
        if (str != null) {
            if (this.aAF.getSlidingMenu().isMenuShowing()) {
                this.aAF.getSlidingMenu().toggle(true);
            }
            this.aAN = false;
            this.aAx = str;
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.voice.o
    public VoiceManager getVoiceManager() {
        if (this.ayx == null) {
            this.ayx = VoiceManager.instance();
        }
        return this.ayx;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.ae
    /* renamed from: uf */
    public BdListView getListView() {
        if (this.aAF == null) {
            return null;
        }
        return this.aAF.uf();
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m b(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EC() {
        this.ayx = getVoiceManager();
        this.ayx.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.ae
    public int nC() {
        if (this.aAF == null) {
            return 0;
        }
        return this.aAF.Ew();
    }

    @Override // com.baidu.tbadk.core.view.ae
    public com.baidu.adp.lib.e.b<TbImageView> nD() {
        if (this.Iv == null) {
            this.Iv = UserIconBox.f(this, 8);
        }
        return this.Iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.aAR != null) {
                this.aAR.A(msgReplyme);
                this.aAR.z(msgAtme);
                this.aAR.B(msgChat);
                this.aAF.a(this.aAR, aAu, aAv, aAw);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        bd GJ;
        HashMap<Integer, com.baidu.tbadk.core.data.q> FO;
        if (this.azN != null && this.aAF != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (GJ = this.aAF.GJ()) != null && (FO = GJ.FO()) != null && FO.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.q> entry : FO.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.q value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.a) && TextUtils.equals(((com.baidu.tbadk.core.data.a) value).zl, downloadData.getId())) {
                            if (GJ.ai(intValue) instanceof com.baidu.tbadk.core.data.a) {
                                com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) GJ.ai(intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    aVar.zf = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!com.baidu.tbadk.core.util.az.aA(downloadData.getStatusMsg())) {
                                        showToast(downloadData.getStatusMsg());
                                    }
                                    aVar.zf = 0;
                                } else if (status == 1) {
                                    aVar.zf = 1;
                                }
                            }
                        }
                    }
                }
            }
            this.aAF.Gr();
        }
    }

    private void FF() {
        HashMap<Integer, com.baidu.tbadk.core.data.q> FO;
        if (this.aAF != null && this.aAF.GJ() != null && (FO = this.aAF.GJ().FO()) != null) {
            ArrayList<com.baidu.tbadk.core.data.a> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.q> entry : FO.entrySet()) {
                com.baidu.tbadk.core.data.q value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.a)) {
                    arrayList.add((com.baidu.tbadk.core.data.a) value);
                }
            }
            com.baidu.tbadk.download.b.rj().k(arrayList);
        }
    }

    public void a(int i, com.baidu.tbadk.core.data.q qVar, int i2) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 0);
            return;
        }
        if (this.aAX != qVar && qVar != null) {
            EG();
            this.aAF.fc(null);
            this.writeImagesInfo = new WriteImagesInfo();
            this.writeImagesInfo.setMaxImagesAllowed(10);
            this.aAF.a(this.writeImagesInfo, true);
            this.ayI.b((WriteData) null);
            this.ayI.dI(false);
            this.aAF.BR();
            com.baidu.tieba.util.l.a(qVar.getTid(), this);
        }
        this.aAX = qVar;
        this.aAF.a(i, qVar, i2);
        EB();
    }

    public void FG() {
        if (this.aAF != null) {
            this.aAF.setOnActionListener(new au(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Boolean bool) {
        this.aAF.cg(com.baidu.tieba.e.b.b(this.azN.zL().getName(), bool));
    }

    private void e(Intent intent) {
        a(intent, true);
    }

    private void FH() {
        this.writeImagesInfo.addChooseFile(com.baidu.tieba.frs.a.a.B(this, this.ayG));
        this.writeImagesInfo.updateQuality();
        this.aAF.a(this.writeImagesInfo, true);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0 && this.aAF.EQ() != null) {
            this.aAF.EQ().er(23);
        }
    }

    private void f(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    this.aAF.a(this.writeImagesInfo, z);
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0 && this.aAF.EQ() != null) {
                this.aAF.EQ().er(23);
            }
        }
    }

    private void EF() {
        new av(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ED() {
        if (this.ayP == null) {
            String[] strArr = {getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.y.operation));
            builder.setItems(strArr, new aw(this));
            this.ayP = builder.create();
            this.ayP.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(String str) {
        if (this.ayI.EE() == null) {
            WriteData EE = EE();
            EE.setWriteImagesInfo(this.writeImagesInfo);
            this.ayI.dI(this.writeImagesInfo.size() > 0);
            this.ayI.b(EE);
        }
        if (this.ayI.EE() != null) {
            if (this.aAW.getIsBaobao()) {
                this.ayI.EE().setIsBaobao(true);
                this.ayI.EE().setBaobaoContent(this.aAW.getBaobaoContent());
                this.ayI.EE().setBaobaoImagesInfo(this.baobaoImagesInfo);
            } else {
                this.ayI.EE().setIsBaobao(false);
                this.ayI.EE().setBaobaoContent("");
                this.baobaoImagesInfo.clear();
            }
            if (this.aAF.EQ() != null) {
                this.ayI.EE().setHasLocationData(this.aAF.EQ().getLocationInfoViewState() == 2);
            }
            VoiceData.VoiceModel audioData = this.aAF.getAudioData();
            this.ayI.EE().setIsFrsReply(true);
            this.ayI.EE().setContent(this.aAF.EW());
            this.aAF.BS();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.ayI.EE().setVoice(audioData.getId());
                    this.ayI.EE().setVoiceDuringTime(audioData.duration);
                } else {
                    this.ayI.EE().setVoice(null);
                    this.ayI.EE().setVoiceDuringTime(-1);
                }
            } else {
                this.ayI.EE().setVoice(null);
                this.ayI.EE().setVoiceDuringTime(-1);
            }
            if (!this.ayI.TV()) {
                showToast(com.baidu.tieba.y.write_img_limit);
            } else if (this.ayI.TU()) {
                showProgressBar();
            }
        }
    }

    private WriteData EE() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.azN.zL().getId());
        writeData.setForumName(this.azN.zL().getName());
        writeData.setThreadId(this.aAX.getTid());
        writeData.setIsAd(false);
        writeData.setType(1);
        return writeData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.aAX.ky());
            antiData.setBlock_forum_id(this.azN.zL().getId());
            antiData.setUser_name(this.aAX.getAuthor().getUserName());
            antiData.setUser_id(this.aAX.getAuthor().getUserId());
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.m.showToast(this, str);
    }

    @Override // com.baidu.tieba.util.m
    public void a(WriteData writeData) {
        if (writeData != null && this.aAX != null && writeData.getThreadId().equals(this.aAX.getTid())) {
            if (!com.baidu.tbadk.core.util.az.aA(writeData.getContent()) && com.baidu.tbadk.core.util.az.aA(this.aAF.EW())) {
                this.aAF.fc(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                this.aAF.a(this.writeImagesInfo, true);
            }
            if (TbadkApplication.m251getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.aAW.setIsBaobao(writeData.getIsBaobao());
                this.aAW.setBaobaoContent(writeData.getBaobaoContent());
                this.aAF.setBaobaoUris(this.baobaoImagesInfo);
            }
        }
    }

    public void FI() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.m.b(this, getCurrentFocus());
        }
    }

    private void EG() {
        if (this.aAX != null) {
            WriteData EE = this.ayI.EE();
            if (EE == null) {
                EE = new WriteData(1);
                EE.setThreadId(this.aAX.getTid());
                EE.setWriteImagesInfo(this.writeImagesInfo);
            }
            EE.setContent(this.aAF.EW());
            if (this.aAW != null && this.aAW.getIsBaobao()) {
                EE.setBaobaoContent(this.aAW.getBaobaoContent());
                EE.setBaobaoImagesInfo(this.baobaoImagesInfo);
                EE.setIsBaobao(true);
            }
            com.baidu.tieba.util.l.b(this.aAX.getTid(), EE);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return getListView();
    }

    private void h(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(BaobaoSdkDelegate.KEY_BITMAPPATH);
            String stringExtra2 = intent.getStringExtra(BaobaoSdkDelegate.KEY_CONTENT);
            if (stringExtra != null && stringExtra2 != null) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(stringExtra);
                this.baobaoImagesInfo.clear();
                this.baobaoImagesInfo.addChooseFile(imageFileInfo);
                this.aAF.setBaobaoUris(this.baobaoImagesInfo);
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    if (this.aAF.EQ() != null) {
                        this.aAF.EQ().er(48);
                    }
                    this.aAW.setIsBaobao(true);
                    this.aAW.setBaobaoContent(stringExtra2);
                    this.aAW.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.aAW.setIsBaobao(false);
                this.aAW.setBaobaoContent("");
                this.aAW.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.aAF.getRootView());
        showLoadingView(this.aAF.getRootView(), true);
        this.aAF.hO();
    }
}
