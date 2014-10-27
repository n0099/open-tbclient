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
    private static boolean aAU;
    public static String aAh;
    private com.baidu.adp.lib.e.b<TbImageView> Iu;
    private cz aAH;
    private com.baidu.adp.lib.e.b<TbImageView> aAI;
    private bc aAL;
    private com.baidu.tbadk.core.data.q aAN;
    private com.baidu.tbadk.core.data.q aAi;
    VoiceManager ayo;
    private com.baidu.tieba.location.d ays;
    private boolean ayv;
    private String ayw;
    private String ayx;
    private com.baidu.tieba.model.ar ayz;
    private static boolean aAk = true;
    private static boolean aAl = true;
    private static boolean aAm = true;
    public static boolean avK = false;
    private static volatile long aAz = 0;
    private static volatile long aAA = 0;
    private static volatile int aAB = 0;
    public static final CustomMessageListener aAQ = new ao(2012111);
    private static final CustomMessageListener aAR = new ax(2012112);
    private boolean ayt = false;
    private boolean aAj = false;
    private int mType = 3;
    private String aAn = null;
    private String Go = null;
    private int aAo = 0;
    private int aAp = 1;
    private boolean aAq = false;
    private boolean aAr = false;
    private boolean aAs = false;
    private String aAt = null;
    private String mThreadId = null;
    private String forumId = null;
    private boolean aAu = false;
    private bu aAv = null;
    private String aAw = null;
    private String aAx = null;
    private final com.baidu.tbadk.core.data.q aAy = null;
    private long aAC = 0;
    private boolean aAD = false;
    private com.baidu.tieba.b.a aAE = null;
    private b azE = null;
    private com.baidu.tieba.model.ag avr = null;
    private com.baidu.tieba.model.bc aAF = null;
    private com.baidu.tieba.model.ay aAG = null;
    private String mPageType = "normal_page";
    private com.baidu.tbadk.core.data.q amB = null;
    private boolean aAJ = false;
    private long aAK = -1;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private WriteData aAM = new WriteData();
    private boolean aAO = true;
    private CustomMessageListener ayB = new g(this, 2004004);
    private CustomMessageListener aAP = new r(this, 2001197);
    private final com.baidu.tieba.model.as ayC = new ad(this);
    public final CustomMessageListener aAS = new ay(this, 2012111);
    private final dd aAT = new az(this);
    private com.baidu.tieba.location.i ayD = new ba(this);
    private com.baidu.tieba.location.j ayE = new bb(this);
    private final CustomMessageListener Sc = new h(this, 2003003);
    private final CustomMessageListener mMemListener = new i(this, 2001200);
    private final com.baidu.adp.widget.ListView.f avJ = new j(this);
    private final View.OnClickListener aAV = new k(this);
    private final AbsListView.OnScrollListener ayF = new l(this);
    private final SlidingMenu.OnClosedListener aAW = new m(this);
    private final be aAX = new n(this);
    private final df ayI = new df(this, new o(this));
    private final SlidingMenu.OnOpenedListener aAY = new p(this);
    private final View.OnClickListener aAZ = new q(this);
    private final View.OnClickListener aBa = new s(this);
    private final AdapterView.OnItemClickListener aBb = new t(this);
    private final com.baidu.tbadk.core.view.u aBc = new u(this);
    private final CustomMessageListener aBd = new v(this, 0);
    private AlertDialog ayG = null;
    private final com.baidu.adp.framework.listener.e aBe = new w(this, 301001);
    private final HttpMessageListener aBf = new x(this, CmdConfigHttp.FRS_HTTP_CMD);
    private com.baidu.adp.widget.ListView.am aBg = new y(this);
    private View.OnClickListener aBh = new aa(this);
    private View.OnClickListener aBi = new ab(this);
    private com.baidu.adp.widget.ListView.an aBj = new ac(this);

    static {
        Fk();
        Fl();
        Fm();
        MessageManager.getInstance().registerListener(aAQ);
        MessageManager.getInstance().registerListener(aAR);
        com.baidu.tieba.ai.a(301001, FRSPageSocketResponsedMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.FRS_HTTP_CMD, com.baidu.tieba.ai.s("c/f/frs/page", 301001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(FrsPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.tieba.location.d.Su();
        aAU = false;
    }

    private static void Fk() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003000, new ae());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Fl() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003001, new af());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Fm() {
        com.baidu.tbadk.core.util.bf.mR().a(new ag());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m251getInst().isGpuOpen();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ew() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this)));
    }

    public void Ex() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this)) {
            showToast(com.baidu.tieba.y.location_system_permission_prompt);
        } else if (!TbadkApplication.m251getInst().getLocationShared()) {
            Ey();
        } else if (this.ays.St()) {
            Ew();
        } else {
            this.ays.dx(false);
            if (this.aAv.EO() != null) {
                this.aAv.EO().setLocationViewVisibility(0);
                this.aAv.EO().setLocationInfoViewState(1);
            }
            this.ays.Sr();
        }
    }

    private void Ey() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.aX(com.baidu.tieba.y.location_app_permission_prompt).a(com.baidu.tieba.y.isopen, new ah(this)).b(com.baidu.tieba.y.cancel, new ai(this)).kT();
        aVar.kW();
    }

    private void Ez() {
        PbEditor EO = this.aAv.EO();
        if (EO != null) {
            if (this.ays.Sv()) {
                EO.setLocationViewVisibility(0);
                if (this.ays.St()) {
                    this.ayD.a(com.baidu.tieba.location.c.So().getLocationData());
                    return;
                } else if (com.baidu.adp.lib.util.m.isNetOk()) {
                    EO.setLocationInfoViewState(1);
                    this.ays.Sr();
                    return;
                } else {
                    EO.setLocationInfoViewState(0);
                    return;
                }
            }
            EO.setLocationViewVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(b bVar) {
        if (bVar != null && bVar.zJ() != null) {
            this.aAv.Gi().t(bVar.zJ().getRecommendForumData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(b bVar) {
        if (bVar != null && bVar.zJ() != null) {
            if (this.azE != null) {
                this.azE.a(bVar.zJ().getAnchorPower());
            }
            this.aAv.i(bVar);
            ArrayList<LiveCardData> EY = bVar.EY();
            ArrayList<com.baidu.adp.widget.ListView.al> Fe = bVar.Fe();
            if (EY != null && EY.size() > 0 && Fe != null && Fe.size() > 0) {
                int size = Fe.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!(Fe.get(i) instanceof com.baidu.tbadk.core.data.i)) {
                        i++;
                    } else {
                        Fe.remove(i);
                        break;
                    }
                }
                int Fh = bVar.Fh();
                com.baidu.tbadk.core.data.i iVar = new com.baidu.tbadk.core.data.i();
                iVar.g(EY);
                bVar.Fe().add(Fh, iVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aAh = "speed_icon_show" + TbadkApplication.getCurrentAccount();
        Intent intent = getIntent();
        if (bundle != null) {
            this.aAn = bundle.getString("name");
            this.Go = bundle.getString("from");
            this.aAo = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else if (intent != null) {
            this.aAn = intent.getStringExtra("name");
            this.Go = intent.getStringExtra("from");
            this.aAo = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
        }
        if (intent != null) {
            this.aAK = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.aAK = System.currentTimeMillis();
        }
        if (bS(getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) && !xf()) {
            registerListener(this.Sc);
            registerListener(this.mMemListener);
            registerListener(this.aBe);
            registerListener(this.aBf);
            registerListener(this.aAS);
            registerListener(this.ayB);
            registerListener(this.aAP);
            this.ayo = getVoiceManager();
            this.ayo.onCreate(this);
            initUI();
            d(bundle);
            this.aAv.hO();
            this.ayI.setUniqueId(getUniqueId());
            this.ayI.registerListener();
            showLoadingView(this.aAv.getRootView(), true);
            addGlobalLayoutListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.aAv != null && this.aAv.EO() != null) {
            this.aAv.EO().BE();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.ayo = getVoiceManager();
        this.ayo.onStart(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(b bVar) {
        if (bVar != null) {
            try {
                if (bVar.yU() == 1) {
                    this.aAv.GH().setFromCDN(true);
                } else {
                    this.aAv.GH().setFromCDN(false);
                }
                this.aAv.a(bVar.zJ(), bVar.getUserData());
                if (bVar.Ff().zg() == 1) {
                    this.mPageType = "frs_page";
                    this.aAv.L(bVar.getUserData().getIsMem(), this.azE.zJ().isLike());
                } else {
                    this.mPageType = "normal_page";
                    this.aAv.K(bVar.getUserData().getIsMem(), this.azE.zJ().isLike());
                }
                this.aAv.Go();
                this.aAn = bVar.zJ().getName();
                this.forumId = bVar.zJ().getId();
                this.aAv.setTitle(this.aAn);
                Fv();
                bVar.Fi();
                bVar.U(this);
                bVar.Fj();
                e(bVar);
                com.baidu.tbadk.core.data.s top_notice_data = bVar.zJ().getTop_notice_data();
                if (top_notice_data != null && top_notice_data.getTitle() != null) {
                    com.baidu.tbadk.core.data.q qVar = new com.baidu.tbadk.core.data.q();
                    qVar.setTitle(top_notice_data.getTitle());
                    qVar.aT(2);
                    qVar.ba(top_notice_data.kO());
                    qVar.parser_title();
                    bVar.b(qVar);
                }
                ArrayList<com.baidu.adp.widget.ListView.al> Fe = bVar.Fe();
                if (Fe != null) {
                    this.aAv.a(Fe, this.aAp, this.azE, bVar.zM().kh());
                    FD();
                    this.aAv.eV(this.aAp);
                    if (this.mPageType.equals("frs_page")) {
                        this.aAv.a(bVar.zJ(), bVar);
                    } else if (this.mPageType.equals("normal_page")) {
                        this.aAv.b(bVar.zJ(), bVar);
                    }
                    this.aAv.GB();
                    this.aAv.eQ(0);
                }
                if (bVar.Fd()) {
                    if (this.aAv.Gm() != null) {
                        this.aAv.Gm().GZ();
                    }
                    if (this.aAv.Gn() != null) {
                        this.aAv.Gn().GZ();
                    }
                } else {
                    if (this.aAv.Gm() != null) {
                        this.aAv.Gm().GY();
                    }
                    if (this.aAv.Gn() != null) {
                        this.aAv.Gn().GY();
                    }
                }
                hideLoadingView(this.aAv.getRootView());
                this.aAj = true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private void d(Bundle bundle) {
        Fr();
        this.aAs = TbadkApplication.isLogin();
        if (bundle != null) {
            this.aAn = bundle.getString("name");
            this.Go = bundle.getString("from");
            this.aAo = bundle.getInt(FrsActivityConfig.FLAG, 0);
        } else {
            Intent intent = getIntent();
            this.aAn = intent.getStringExtra("name");
            this.Go = intent.getStringExtra("from");
            this.aAo = intent.getIntExtra(FrsActivityConfig.FLAG, 0);
            this.aAD = intent.getBooleanExtra(FrsActivityConfig.GOOD, false);
        }
        if (this.aAn != null && this.aAn.length() > 0) {
            if (this.Go == null || this.Go.length() <= 0) {
                this.Go = FrsActivityConfig.FRS_FROM_LIKE;
            }
            this.aAw = this.Go;
            Fn();
            Fo();
            Fp();
            this.aAH = new cz(this);
            if (this.aAs) {
                Fq();
                Fs();
            }
            if (bundle != null) {
                this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
                this.ayx = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            }
            this.writeImagesInfo.setMaxImagesAllowed(10);
            this.ayz = new com.baidu.tieba.model.ar(this);
            this.ayz.a(this.ayC);
            this.ays = new com.baidu.tieba.location.d(this);
            this.ays.a(this.ayD);
            this.ays.a(this.ayE);
        }
    }

    private void Fn() {
        this.avr = new com.baidu.tieba.model.ag(this);
        this.avr.setLoadDataCallBack(new aj(this));
    }

    private void Fo() {
        this.aAF = new com.baidu.tieba.model.bc();
        this.aAF.setFrom(PbActivityConfig.KEY_FROM_FRS);
        this.aAF.a(new ak(this));
    }

    private void Fp() {
        this.aAG = new com.baidu.tieba.model.ay(this);
        this.aAG.setLoadDataCallBack(new al(this));
    }

    public void Fq() {
        if (this.aAH != null && this.aAv != null) {
            if (aAk || aAl || aAm) {
                this.aAH.A(com.baidu.tbadk.coreExtra.messageCenter.a.oB().getMsgReplyme());
                this.aAH.z(com.baidu.tbadk.coreExtra.messageCenter.a.oB().getMsgAtme());
                this.aAH.B(com.baidu.tbadk.coreExtra.messageCenter.a.oB().getMsgChat());
                this.aAv.a(this.aAH, aAk, aAl, aAm);
            }
        }
    }

    private void Fr() {
        registerListener(2001122, this.aBd);
    }

    private void Fs() {
        registerListener(2001124, this.aBd);
    }

    private boolean xf() {
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
        if (this.aAv != null) {
            this.aAv.onDestroy();
        }
        super.onDestroy();
        try {
            if (this.azE != null) {
                this.azE.clear();
            }
            if (this.avr != null) {
                this.avr.TF();
            }
            if (this.aAG != null) {
                this.aAG.TF();
            }
            if (this.ayz != null) {
                this.ayz.cancelLoadData();
            }
            this.aAv.release();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        this.ayo = getVoiceManager();
        this.ayo.onDestory(this);
        com.baidu.tieba.aj.wk().wR();
        if (this.aAL != null) {
            this.aAL.cancel(true);
            this.aAL = null;
        }
        if (this.aAE != null) {
            this.aAE.xY();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.aAn);
        bundle.putString("from", this.Go);
        this.ayo = getVoiceManager();
        if (this.ayo != null) {
            this.ayo.onSaveInstanceState(this);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.ayx);
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
                    Fz();
                    return;
                case 11011:
                    e(this.aAy);
                    return;
                case 11012:
                    f(this.amB);
                    return;
                case 11014:
                    FB();
                    return;
                case 11016:
                    this.aAv.GA();
                    return;
                case 11033:
                default:
                    return;
                case 11036:
                    FA();
                    return;
                case 12001:
                    if (this.writeImagesInfo != null) {
                        FF();
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
                        this.aAv.o(p);
                        return;
                    }
                    return;
                case 12006:
                    WriteData EC = this.ayz.EC();
                    if (EC != null) {
                        EC.deleteUploadedTempImages();
                    }
                    this.aAM.setIsBaobao(false);
                    this.aAM.setBaobaoContent(null);
                    this.baobaoImagesInfo.clear();
                    this.ayz.b((WriteData) null);
                    this.ayz.dI(false);
                    this.aAv.bQ(true);
                    if (this.aAN != null) {
                        com.baidu.tieba.util.l.b(this.aAN.getTid(), (WriteData) null);
                        this.aAN.setReply_num(this.aAN.getReply_num() + 1);
                    }
                    if (this.writeImagesInfo != null) {
                        this.aAv.a(this.writeImagesInfo, true);
                    }
                    this.aAv.Gp();
                    this.aAv.EP();
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
                    this.aAv.GH().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (fe = this.azE.fe(stringExtra)) != null) {
                        int intExtra = intent.getIntExtra("type", 0);
                        if (intExtra == 2) {
                            fe.aU(intent.getIntExtra(PbActivityConfig.KEY_INTENT_GOOD_DATA, 0));
                            fe.parser_title();
                            refresh();
                            return;
                        } else if (intExtra == 0) {
                            this.azE.c(fe);
                            this.aAv.GB();
                            if (a.EV() != null) {
                                a.EV().u(this.aAn, false);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 18004:
                    Fy();
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    ED();
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
        this.ayv = true;
        this.aAO = true;
        if (aAU) {
            aAU = false;
            this.aAv.hO();
        } else if (avK) {
            avK = false;
            this.aAv.hO();
        } else {
            if (!this.aAs && TbadkApplication.isLogin()) {
                this.aAs = true;
                if (this.azE != null && this.azE.jZ() != null) {
                    this.azE.jZ().setIfpost(1);
                }
                refresh();
            }
            this.ayo = getVoiceManager();
            this.ayo.onResume(this);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (!TextUtils.isEmpty(intent.getStringExtra("name"))) {
                this.aAn = intent.getStringExtra("name");
            }
            if (!TextUtils.isEmpty(intent.getStringExtra("from"))) {
                this.Go = intent.getStringExtra("from");
            }
            this.aAr = intent.getBooleanExtra(FrsActivityConfig.KEY_REFRESH, false);
            if (this.aAr) {
                if (intent.getBooleanExtra(FrsActivityConfig.CONTENT_SHOW, false)) {
                    Ft();
                } else {
                    Fu();
                }
            }
        }
    }

    private void Ft() {
        this.aAv.hO();
        this.aAv.getSlidingMenu().showContent(false);
    }

    private void Fu() {
        this.aAv.hO();
        this.aAv.getSlidingMenu().toggle(false);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            com.baidu.tbadk.core.b.b.d(this, 1);
        } else {
            com.baidu.tbadk.core.b.b.d(this, 2);
        }
    }

    private void initUI() {
        this.aAp = 1;
        this.aAD = false;
        this.aAC = 0L;
        this.mType = 3;
        if (TextUtils.isEmpty(this.aAn)) {
            this.aAn = "";
        }
        if (TextUtils.isEmpty(this.Go)) {
            this.Go = "";
        }
        setContentView(com.baidu.tieba.w.frs_activity);
        this.aAv = new bu(this, this.aAV);
        this.aAv.GH().i(this.aAZ);
        this.aAv.GH().j(this.aBa);
        if (this.aAo == 0) {
            this.aAv.setTitle(this.aAn);
        } else {
            this.aAv.setTitle("");
            this.aAo = 1;
        }
        this.aAv.a(this.aBg);
        this.aAv.a(this.aBj);
        this.aAv.k(this.aBh);
        this.aAv.m(this.aBi);
        this.aAv.setOnScrollListener(this.ayF);
        this.aAv.a(this.avJ);
        this.aAv.a(this.aAW);
        this.aAv.a(this.aAY);
        this.aAv.f(this.aBc);
        this.aAv.GH().a(this.aAX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aAv.onChangeSkinType(i);
    }

    @Override // com.baidu.tieba.view.q
    public com.baidu.adp.lib.e.b<TbImageView> EF() {
        if (this.aAI == null) {
            this.aAI = FrsCommonImageLayout.l(this, 6);
        }
        return this.aAI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ff(String str) {
        Intent A;
        com.baidu.tieba.frs.view.r Gn;
        if (str != null && (A = com.baidu.tieba.frs.a.a.A(this, str)) != null) {
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("duplicate", false);
            intent.putExtra("android.intent.extra.shortcut.NAME", String.valueOf(str) + getString(com.baidu.tieba.y.bar));
            intent.putExtra("android.intent.extra.shortcut.INTENT", A);
            BarImageView barImageView = null;
            if (this.mPageType.equals("normal_page")) {
                FrsHeaderView Gm = this.aAv.Gm();
                if (Gm != null) {
                    barImageView = Gm.GV();
                }
            } else if (this.mPageType.equals("frs_page") && (Gn = this.aAv.Gn()) != null) {
                barImageView = Gn.GV();
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
            if (this.azE != null && this.azE.jZ() != null) {
                this.azE.jZ().setIfpost(1);
            }
            if (i == 0) {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11001);
            } else {
                LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11016);
            }
        } else if (this.azE != null) {
            if (i == 0) {
                AntiData jZ = this.azE.jZ();
                if (AntiHelper.c(jZ) || AntiHelper.d(jZ) || AntiHelper.e(jZ)) {
                    jZ.setBlock_forum_name(this.aAn);
                    jZ.setBlock_forum_id(this.azE.zJ().getId());
                    jZ.setUser_name(this.azE.getUserData().getUserName());
                    jZ.setUser_id(this.azE.getUserData().getUserId());
                    if (AntiHelper.a(this, jZ, AntiHelper.OperationType.CREATE_THREAD, AntiHelper.PageType.FRS)) {
                        return;
                    }
                }
                if (this.azE.jZ() != null && this.azE.jZ().getIfpost() == 0) {
                    com.baidu.adp.lib.util.m.showToast(this, jZ.getForbid_info());
                    return;
                }
                int i2 = 0;
                if (this.azE.getUserData() != null) {
                    i2 = this.azE.getUserData().getIsMem();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(this, 0, this.azE.zJ().getId(), this.aAn, null, null, 0, this.azE.jZ(), 13003, false, false, null, false, false, null, null, this.azE.zJ().getPrefixData(), i2)));
                return;
            }
            this.aAv.GA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.core.data.q qVar) {
        boolean kI = qVar == null ? true : qVar.kI();
        this.aAv.a(new an(this, qVar));
        this.aAv.a(qVar, kI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tbadk.core.data.q qVar) {
        boolean kI = qVar == null ? true : qVar.kI();
        if (this.mThreadId != null) {
            if (!kI) {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(this).createFromThreadCfg(qVar, this.aAn, null, 18003, true, true, this.aAu)));
            } else {
                sendMessage(new CustomMessage(2004001, new PbActivityConfig(this).createFromThreadCfg(qVar, this.aAn, null, 18003, false, false, this.aAu)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tbadk.core.data.q qVar) {
        if (this.mThreadId != null) {
            sendMessage(new CustomMessage(2004001, new PbActivityConfig(this).createFromThreadCfg(qVar, this.aAn, null, 18003, false, false, this.aAu)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        EA();
        this.aAp = 1;
        eF(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eF(int i) {
        boolean z = false;
        this.mType = i;
        switch (this.mType) {
            case 1:
                if (this.aAv.GH().FK()) {
                    return;
                }
                break;
            case 2:
                if (this.aAv.GH().FL()) {
                    return;
                }
                break;
            case 3:
                if (this.aAv.Gl()) {
                    return;
                }
                break;
        }
        FRSPageRequestMessage fRSPageRequestMessage = new FRSPageRequestMessage();
        fRSPageRequestMessage.setKw(this.aAn);
        fRSPageRequestMessage.setPn(this.aAp);
        if (this.azE == null) {
            this.azE = new b();
        }
        fRSPageRequestMessage.setForumModel(this.azE);
        if (com.baidu.tbadk.core.k.js().jw()) {
            fRSPageRequestMessage.setRn(35);
        } else {
            fRSPageRequestMessage.setRn(50);
        }
        fRSPageRequestMessage.setWithGroup(1);
        if (this.aAD) {
            fRSPageRequestMessage.setIsGood(1);
            fRSPageRequestMessage.setCid((int) this.aAC);
        }
        int n = com.baidu.adp.lib.util.m.n(this);
        int o = com.baidu.adp.lib.util.m.o(this);
        float f = n / 320.0f;
        int i2 = com.baidu.tbadk.core.util.az.mD().mF() ? 2 : 1;
        fRSPageRequestMessage.setScrW(n);
        fRSPageRequestMessage.setScrH(o);
        fRSPageRequestMessage.setScrDip(f);
        fRSPageRequestMessage.setqType(i2);
        fRSPageRequestMessage.setLastId(this.aAt);
        if (this.aAw != null) {
            fRSPageRequestMessage.setStType(this.aAw);
            if (this.aAw.equalsIgnoreCase("sidebar")) {
                fRSPageRequestMessage.setStType(this.aAx);
            }
        }
        if (aAz != 0) {
            fRSPageRequestMessage.setCtime((int) aAz);
        }
        if (aAA != 0) {
            fRSPageRequestMessage.setDataSize((int) aAA);
        }
        if (aAB != 0) {
            fRSPageRequestMessage.setNetError(aAB);
        }
        this.aAv.cb(true);
        this.aAv.GH().bW(false);
        this.aAv.GH().bX(false);
        this.aAv.GH().notifyDataSetChanged();
        if (this.aAp == 1 && ((this.mPageType.equals("normal_page") || this.mPageType.equals("frs_page")) && !this.aAD)) {
            z = true;
        }
        if (this.azE == null) {
            this.azE = new b();
        }
        this.azE.a(this.aAT);
        this.azE.a(this, fRSPageRequestMessage, this.mType, z, this.aAn);
        if (this.aAE == null) {
            this.aAE = new com.baidu.tieba.b.a("frsStat");
            this.aAE.start();
        }
    }

    private void Fv() {
        switch (this.aAo) {
            case 1:
                com.baidu.adp.lib.g.k.el().b(new ap(this));
                break;
        }
        this.aAo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fw() {
        EA();
        try {
            if (this.azE != null) {
                this.aAv.Go();
                this.aAn = this.azE.zJ().getName();
                this.forumId = this.azE.zJ().getId();
                this.aAv.setTitle(this.aAn);
                TbadkApplication.m251getInst().setDefaultBubble(this.azE.getUserData().getBimg_url());
                TbadkApplication.m251getInst().setDefaultBubbleEndTime(this.azE.getUserData().getBimg_end_time());
                Fv();
                ArrayList<com.baidu.adp.widget.ListView.al> Fe = this.azE.Fe();
                if (Fe != null) {
                    this.aAv.a(Fe, this.aAp, this.azE, this.azE.zM().kh());
                    FD();
                    this.aAv.eV(this.aAp);
                    if (this.mPageType.equals("frs_page")) {
                        Fx();
                    } else if (this.mPageType.equals("normal_page")) {
                        this.aAv.b(this.azE.zJ(), this.azE);
                    }
                    this.aAv.GB();
                    if (this.azE.yU() == 1) {
                        this.aAv.GH().setFromCDN(true);
                    } else {
                        this.aAv.GH().setFromCDN(false);
                    }
                    this.aAv.eQ(J(this.mType, this.aAp));
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
        this.ayv = false;
        this.aAO = false;
        this.aAv.onPause();
        this.ayo = getVoiceManager();
        this.ayo.onPause(this);
        EE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        com.baidu.tbadk.distribute.a.ra().a(this, "frs", this.azE.zJ().getId(), 0L);
        this.ayo = getVoiceManager();
        if (this.ayo != null) {
            this.ayo.onStop(this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82 || this.aAq) {
            if (i == 4) {
                if (this.aAv.getSlidingMenu().isMenuShowing()) {
                    this.aAv.getSlidingMenu().toggle(true);
                    if (this.aAv.Gi().GO()) {
                        this.aAv.Gi().ch(false);
                        refresh();
                        return true;
                    }
                    return true;
                } else if (this.aAv.EO() != null && this.aAv.EO().isVisible()) {
                    this.aAv.EP();
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
                com.baidu.tbadk.core.util.bf.mR().b(this, new String[]{aVar.zj});
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
                com.baidu.tbadk.download.b.rh().a(aVar.zl, aVar.zk, aVar.zh, i);
            } else {
                showToast(com.baidu.tieba.y.neterror);
            }
        }
    }

    private void Fx() {
        this.aAv.a(this.azE.zJ(), this.azE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fy() {
        com.baidu.tbadk.browser.a.i(this, String.valueOf(TbConfig.SERVER_ADDRESS) + "mo/q/fudaiindex?fid=" + this.azE.zJ().getId());
    }

    public void a(com.baidu.tbadk.core.data.a aVar, String str) {
        com.baidu.tbadk.distribute.a.ra().a(this, aVar, str, "frs", this.azE.zJ().getId(), 0L);
    }

    public void b(com.baidu.tbadk.core.data.a aVar, String str) {
        com.baidu.tbadk.distribute.a.ra().a(aVar, this.forumId, 0L, "FRS", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Fz() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11002);
            return;
        }
        this.avr.setFrom(PbActivityConfig.KEY_FROM_FRS);
        this.avr.ay(this.azE.zJ().getName(), this.azE.zJ().getId());
    }

    protected void FA() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(com.baidu.tieba.y.attention_cancel_info));
        builder.setTitle(getString(com.baidu.tieba.y.alert_title));
        builder.setPositiveButton(getString(com.baidu.tieba.y.attention_cancel), new as(this));
        builder.setNegativeButton(getString(com.baidu.tieba.y.cancel), new at(this));
        com.baidu.adp.lib.g.j.a(builder.create(), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void FB() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 11014);
            return;
        }
        if (this.mPageType.equals("normal_page")) {
            this.aAv.Gt();
        } else if (this.mPageType.equals("frs_page")) {
            this.aAv.Gv();
        }
        this.aAG.az(this.azE.zJ().getName(), this.azE.zJ().getId());
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.aAv.Gi().GN()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (!PluginCenter.getInstance().checkPluginInstalled(PluginNameList.NAME_NIGHT_RESOURCE)) {
                    this.aAv.Gi().GN().B(false);
                    showToast(com.baidu.tieba.y.plugin_night_resource_init_doing);
                    return;
                } else if (TbadkApplication.m251getInst().getSkinType() != 1) {
                    TiebaStatic.eventStat(this, "frs_night_mode", "frsclick", 1, new Object[0]);
                    com.baidu.tieba.aj.wk().setSkinType(1);
                    this.mSkinType = 1;
                    TiebaStatic.eventStat(TbadkApplication.m251getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                } else {
                    return;
                }
            } else if (TbadkApplication.m251getInst().getSkinType() != 0) {
                com.baidu.tieba.aj.wk().setSkinType(0);
                this.mSkinType = 0;
            } else {
                return;
            }
            onChangeSkinType(this.mSkinType);
            com.baidu.tbadk.core.util.d.lp();
            com.baidu.tieba.pb.main.bs.WZ().reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eD(int i) {
        ArrayList<com.baidu.adp.widget.ListView.al> Fe = this.azE.Fe();
        if (Fe != null) {
            Iterator<com.baidu.adp.widget.ListView.al> it = Fe.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.al next = it.next();
                if (next instanceof com.baidu.tbadk.core.data.q) {
                    com.baidu.tbadk.core.data.q qVar = (com.baidu.tbadk.core.data.q) next;
                    if (qVar == this.aAi) {
                        a(qVar, i);
                        this.aAi = null;
                        break;
                    } else if (qVar.getId() != null && qVar.getId().equals(this.ayw)) {
                        a(qVar, i);
                        this.ayw = null;
                        break;
                    }
                }
            }
            this.aAv.GH().a(Fe, this.azE);
            this.aAv.GH().notifyDataSetChanged();
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

    public void FC() {
        if (this.azE != null && this.azE.zJ() != null && this.azE.zJ().getBannerListData() != null) {
            String jM = this.azE.zJ().getBannerListData().jM();
            if (!TextUtils.isEmpty(jM)) {
                this.aAt = jM;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fg(String str) {
        if (str != null) {
            if (this.aAv.getSlidingMenu().isMenuShowing()) {
                this.aAv.getSlidingMenu().toggle(true);
            }
            this.aAD = false;
            this.aAn = str;
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.voice.o
    public VoiceManager getVoiceManager() {
        if (this.ayo == null) {
            this.ayo = VoiceManager.instance();
        }
        return this.ayo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.ae
    /* renamed from: ud */
    public BdListView getListView() {
        if (this.aAv == null) {
            return null;
        }
        return this.aAv.ud();
    }

    @Override // com.baidu.tbadk.core.voice.o
    public com.baidu.tbadk.core.voice.m b(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EA() {
        this.ayo = getVoiceManager();
        this.ayo.stopPlay();
    }

    @Override // com.baidu.tbadk.core.view.ae
    public int nC() {
        if (this.aAv == null) {
            return 0;
        }
        return this.aAv.Eu();
    }

    @Override // com.baidu.tbadk.core.view.ae
    public com.baidu.adp.lib.e.b<TbImageView> nD() {
        if (this.Iu == null) {
            this.Iu = UserIconBox.f(this, 8);
        }
        return this.Iu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
            int msgReplyme = newsNotifyMessage.getMsgReplyme();
            int msgAtme = newsNotifyMessage.getMsgAtme();
            int msgChat = newsNotifyMessage.getMsgChat();
            if (this.aAH != null) {
                this.aAH.A(msgReplyme);
                this.aAH.z(msgAtme);
                this.aAH.B(msgChat);
                this.aAv.a(this.aAH, aAk, aAl, aAm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ResponsedMessage<?> responsedMessage) {
        List<DownloadData> data;
        bd GH;
        HashMap<Integer, com.baidu.tbadk.core.data.q> FM;
        if (this.azE != null && this.aAv != null && (responsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) responsedMessage).getData()) != null && (GH = this.aAv.GH()) != null && (FM = GH.FM()) != null && FM.size() > 0) {
            for (DownloadData downloadData : data) {
                if (downloadData != null) {
                    for (Map.Entry<Integer, com.baidu.tbadk.core.data.q> entry : FM.entrySet()) {
                        int intValue = entry.getKey().intValue();
                        com.baidu.tbadk.core.data.q value = entry.getValue();
                        if (value != null && (value instanceof com.baidu.tbadk.core.data.a) && TextUtils.equals(((com.baidu.tbadk.core.data.a) value).zl, downloadData.getId())) {
                            if (GH.ai(intValue) instanceof com.baidu.tbadk.core.data.a) {
                                com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) GH.ai(intValue);
                                int status = downloadData.getStatus();
                                if (status == 3 || status == 0) {
                                    aVar.zf = 2;
                                } else if (status == 2 || status == 4) {
                                    if (!com.baidu.tbadk.core.util.ay.aA(downloadData.getStatusMsg())) {
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
            this.aAv.Gp();
        }
    }

    private void FD() {
        HashMap<Integer, com.baidu.tbadk.core.data.q> FM;
        if (this.aAv != null && this.aAv.GH() != null && (FM = this.aAv.GH().FM()) != null) {
            ArrayList<com.baidu.tbadk.core.data.a> arrayList = new ArrayList<>();
            for (Map.Entry<Integer, com.baidu.tbadk.core.data.q> entry : FM.entrySet()) {
                com.baidu.tbadk.core.data.q value = entry.getValue();
                if (value != null && (value instanceof com.baidu.tbadk.core.data.a)) {
                    arrayList.add((com.baidu.tbadk.core.data.a) value);
                }
            }
            com.baidu.tbadk.download.b.rh().j(arrayList);
        }
    }

    public void a(int i, com.baidu.tbadk.core.data.q qVar, int i2) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, 0);
            return;
        }
        if (this.aAN != qVar && qVar != null) {
            EE();
            this.aAv.fc(null);
            this.writeImagesInfo = new WriteImagesInfo();
            this.writeImagesInfo.setMaxImagesAllowed(10);
            this.aAv.a(this.writeImagesInfo, true);
            this.ayz.b((WriteData) null);
            this.ayz.dI(false);
            this.aAv.BP();
            com.baidu.tieba.util.l.a(qVar.getTid(), this);
        }
        this.aAN = qVar;
        this.aAv.a(i, qVar, i2);
        Ez();
    }

    public void FE() {
        if (this.aAv != null) {
            this.aAv.setOnActionListener(new au(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Boolean bool) {
        this.aAv.cg(com.baidu.tieba.e.b.b(this.azE.zJ().getName(), bool));
    }

    private void e(Intent intent) {
        a(intent, true);
    }

    private void FF() {
        this.writeImagesInfo.addChooseFile(com.baidu.tieba.frs.a.a.B(this, this.ayx));
        this.writeImagesInfo.updateQuality();
        this.aAv.a(this.writeImagesInfo, true);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0 && this.aAv.EO() != null) {
            this.aAv.EO().er(23);
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
                    this.aAv.a(this.writeImagesInfo, z);
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0 && this.aAv.EO() != null) {
                this.aAv.EO().er(23);
            }
        }
    }

    private void ED() {
        new av(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void EB() {
        if (this.ayG == null) {
            String[] strArr = {getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.y.operation));
            builder.setItems(strArr, new aw(this));
            this.ayG = builder.create();
            this.ayG.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(String str) {
        if (this.ayz.EC() == null) {
            WriteData EC = EC();
            EC.setWriteImagesInfo(this.writeImagesInfo);
            this.ayz.dI(this.writeImagesInfo.size() > 0);
            this.ayz.b(EC);
        }
        if (this.ayz.EC() != null) {
            if (this.aAM.getIsBaobao()) {
                this.ayz.EC().setIsBaobao(true);
                this.ayz.EC().setBaobaoContent(this.aAM.getBaobaoContent());
                this.ayz.EC().setBaobaoImagesInfo(this.baobaoImagesInfo);
            } else {
                this.ayz.EC().setIsBaobao(false);
                this.ayz.EC().setBaobaoContent("");
                this.baobaoImagesInfo.clear();
            }
            if (this.aAv.EO() != null) {
                this.ayz.EC().setHasLocationData(this.aAv.EO().getLocationInfoViewState() == 2);
            }
            VoiceData.VoiceModel audioData = this.aAv.getAudioData();
            this.ayz.EC().setIsFrsReply(true);
            this.ayz.EC().setContent(this.aAv.EU());
            this.aAv.BQ();
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.ayz.EC().setVoice(audioData.getId());
                    this.ayz.EC().setVoiceDuringTime(audioData.duration);
                } else {
                    this.ayz.EC().setVoice(null);
                    this.ayz.EC().setVoiceDuringTime(-1);
                }
            } else {
                this.ayz.EC().setVoice(null);
                this.ayz.EC().setVoiceDuringTime(-1);
            }
            if (!this.ayz.TS()) {
                showToast(com.baidu.tieba.y.write_img_limit);
            } else if (this.ayz.TR()) {
                showProgressBar();
            }
        }
    }

    private WriteData EC() {
        WriteData writeData = new WriteData();
        writeData.setForumId(this.azE.zJ().getId());
        writeData.setForumName(this.azE.zJ().getName());
        writeData.setThreadId(this.aAN.getTid());
        writeData.setIsAd(false);
        writeData.setType(1);
        return writeData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.aAN.ky());
            antiData.setBlock_forum_id(this.azE.zJ().getId());
            antiData.setUser_name(this.aAN.getAuthor().getUserName());
            antiData.setUser_id(this.aAN.getAuthor().getUserId());
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        com.baidu.adp.lib.util.m.showToast(this, str);
    }

    @Override // com.baidu.tieba.util.m
    public void a(WriteData writeData) {
        if (writeData != null && this.aAN != null && writeData.getThreadId().equals(this.aAN.getTid())) {
            if (!com.baidu.tbadk.core.util.ay.aA(writeData.getContent()) && com.baidu.tbadk.core.util.ay.aA(this.aAv.EU())) {
                this.aAv.fc(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo.copyFrom(writeData.getWriteImagesInfo());
                this.aAv.a(this.writeImagesInfo, true);
            }
            if (TbadkApplication.m251getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                this.aAM.setIsBaobao(writeData.getIsBaobao());
                this.aAM.setBaobaoContent(writeData.getBaobaoContent());
                this.aAv.setBaobaoUris(this.baobaoImagesInfo);
            }
        }
    }

    public void FG() {
        if (getCurrentFocus() != null) {
            com.baidu.adp.lib.util.m.b(this, getCurrentFocus());
        }
    }

    private void EE() {
        if (this.aAN != null) {
            WriteData EC = this.ayz.EC();
            if (EC == null) {
                EC = new WriteData(1);
                EC.setThreadId(this.aAN.getTid());
                EC.setWriteImagesInfo(this.writeImagesInfo);
            }
            EC.setContent(this.aAv.EU());
            if (this.aAM != null && this.aAM.getIsBaobao()) {
                EC.setBaobaoContent(this.aAM.getBaobaoContent());
                EC.setBaobaoImagesInfo(this.baobaoImagesInfo);
                EC.setIsBaobao(true);
            }
            com.baidu.tieba.util.l.b(this.aAN.getTid(), EC);
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
                this.aAv.setBaobaoUris(this.baobaoImagesInfo);
                if (this.baobaoImagesInfo.getChosedFiles() != null && this.baobaoImagesInfo.getChosedFiles().size() > 0) {
                    if (this.aAv.EO() != null) {
                        this.aAv.EO().er(48);
                    }
                    this.aAM.setIsBaobao(true);
                    this.aAM.setBaobaoContent(stringExtra2);
                    this.aAM.setBaobaoImagesInfo(this.baobaoImagesInfo);
                    return;
                }
                this.aAM.setIsBaobao(false);
                this.aAM.setBaobaoContent("");
                this.aAM.setBaobaoImagesInfo(this.baobaoImagesInfo);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.aAv.getRootView());
        showLoadingView(this.aAv.getRootView(), true);
        this.aAv.hO();
    }
}
