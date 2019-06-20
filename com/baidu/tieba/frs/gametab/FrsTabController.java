package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.i;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.CubeOutViewPagerTransformer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsBaseViewPager;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabHostFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.j;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SmartApp;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class FrsTabController implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    public static final String fEH = FrsFragment.class.getSimpleName();
    public static final String fEI = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String fEJ = FrsTabHostFragment.class.getSimpleName();
    private FrsActivity fEK;
    private FrsLiteProgramListFragment fEL;
    private FrsTabHostFragment fEM;
    private ShareSuccessReplyToServerModel fEP;
    private FrsBaseViewPager fER;
    private FragmentAdapter fES;
    private OvalActionButton fET;
    private boolean fEU;
    private boolean fEV;
    private NavigationBarCoverTip fEW;
    private ab fsq;
    private FrsFragment fsr;
    private j fss;
    private int fsu;
    private FRSRefreshButton fsw;
    private String mForumName;
    private boolean fEN = false;
    private final Handler mHandler = new Handler();
    private int fst = 0;
    private boolean fEQ = false;
    private boolean fEX = false;
    private com.baidu.adp.framework.listener.a fEY = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            j jVar = null;
            if (!FrsTabController.this.fEN && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    jVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    jVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (jVar != null) {
                    FrsTabController.this.fEN = true;
                    FrsTabController.this.d(jVar);
                    if (jVar != null && jVar.getForum() != null && !StringUtils.isNull(jVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.abt().bB("2", jVar.getForum().getId());
                    }
                }
            }
        }
    };
    private CustomMessageListener fEZ = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.fEN && FrsTabController.this.fss == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof j)) {
                j jVar = (j) customResponsedMessage.getData();
                if (jVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(jVar.getForum().getName())) {
                    FrsTabController.this.d(jVar);
                }
            }
        }
    };
    private CustomMessageListener fFa = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.bou();
        }
    };
    private CustomMessageListener fFb = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int rm;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    rm = FrsTabController.this.rm(9);
                    if (rm == -1) {
                        rm = FrsTabController.this.rm(2);
                    }
                } else {
                    rm = FrsTabController.this.rm(intValue);
                }
                if (rm != -1 && FrsTabController.this.bov() && FrsTabController.this.fEM != null) {
                    FrsTabController.this.fEM.setCurrentTab(rm);
                    if (FrsTabController.this.ro(rm) != 1) {
                        FrsTabController.this.fsr.jH(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener fFc = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.aa(newNotifyData) && FrsTabController.this.fEM != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.fsq.blJ().size(); i++) {
                                FragmentTabHost.b hN = FrsTabController.this.fEM.hN(i);
                                if (hN != null && hN.mType != 1 && hN.mType != FrsTabController.this.fEM.getCurrentTabType() && hN.mType == aVar.getTabId() && aVar.bom() && hN.bPJ.qy(String.valueOf(hN.mType)) != null) {
                                    hN.bPJ.qy(String.valueOf(hN.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable fFd = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        @Override // java.lang.Runnable
        public void run() {
            e.iB().removeCallbacks(this);
            FrsTabController.this.bot();
            e.iB().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.fEQ = true;
            }
        }
    };
    private CustomMessageListener fFe = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!i.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.fER != null && FrsTabController.this.fES != null && FrsTabController.this.fES.wG(FrsTabController.fEI) != null) {
                if (!com.baidu.adp.lib.util.j.jS()) {
                    FrsTabController.this.fEK.showToast(FrsTabController.this.fEK.getString(R.string.neterror));
                } else if ((FrsTabController.this.bjj().bkm().smartAppAvatar == null || FrsTabController.this.bjj().bkm().smartAppAvatar.size() != 1) && (FrsTabController.this.bjj().bkm().smartAppAvatar != null || FrsTabController.this.bjj().bkm().smartApp == null)) {
                    FrsTabController.this.fER.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.bjj().bkm().smartApp;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                        FrsTabController.this.fER.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new am("c13274").bT("fid", FrsTabController.this.bjj().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", FrsTabController.this.bjj().bkm().smartApp.name).l(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.bjj().bkm().smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside").P("obj_param1", FrsTabController.this.bjj().bkm().smartApp.is_game.intValue()));
                    }
                }
            }
        }
    };
    private CustomMessageListener fFf = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fER != null && FrsTabController.this.fES != null && FrsTabController.this.fES.wG(FrsTabController.fEI) != null) {
                FrsTabController.this.fER.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener fFg = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fER != null && FrsTabController.this.fES != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.fEU = aVar.blG();
                FrsTabController.this.fEV = aVar.blH();
            }
        }
    };
    private CustomMessageListener fFh = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fER != null && FrsTabController.this.fES != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.fER.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener fFi = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.fsr.bkk();
                FrsTabController.this.bon();
                if (FrsTabController.this.bjj() != null) {
                    FrsTabController.this.bjj().jB(true);
                }
                FrsTabController.this.fET.setVisibility(8);
                return;
            }
            FrsTabController.this.fET.setVisibility(0);
            if (FrsTabController.this.bjj() != null) {
                FrsTabController.this.bjj().jB(false);
            }
            FrsTabController.this.fsr.bkl();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.fEV = false;
                    FrsTabController.this.fER.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a fFj = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void bjz() {
            if (FrsTabController.this.fER != null) {
                if (FrsTabController.this.fER.getCurrentItem() == 0) {
                    FrsTabController.this.fER.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.fER.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean bjA() {
            SmartApp smartApp;
            if (FrsTabController.this.fER.getCurrentItem() == 0) {
                if (FrsTabController.this.fEU && FrsTabController.this.fEV) {
                    FrsTabController.this.fER.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.fEV) {
                    FrsTabController.this.fER.setmDisallowSlip(true);
                }
                FrsTabController.this.fER.setmDisallowSlip(true);
            } else {
                FrsTabController.this.fER.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.bjj().bkm().smartAppAvatar == null || FrsTabController.this.bjj().bkm().smartAppAvatar.size() != 1) && (FrsTabController.this.bjj().bkm().smartAppAvatar != null || FrsTabController.this.bjj().bkm().smartApp == null)) || (smartApp = FrsTabController.this.bjj().bkm().smartApp) == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                return true;
            }
            TiebaStatic.log(new am("c13274").bT("fid", FrsTabController.this.bjj().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", FrsTabController.this.bjj().bkm().smartApp.name).l(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.bjj().bkm().smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside").P("obj_param1", FrsTabController.this.bjj().bkm().smartApp.is_game.intValue()));
            return false;
        }
    };
    private String fEO = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    /* JADX INFO: Access modifiers changed from: private */
    public void bon() {
        if (this.fEL != null && bjj() != null) {
            this.fEL.fJa = true;
            this.fEL.clear();
            if (!com.baidu.adp.lib.util.j.jS()) {
                this.fEL.wX(bjj().getForumId());
            } else if ((bjj().bkm().smartAppAvatar != null && bjj().bkm().smartAppAvatar.size() == 1) || (bjj().bkm().smartAppAvatar == null && bjj().bkm().smartApp != null)) {
                SmartApp smartApp = bjj().bkm().smartApp;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                    String str = null;
                    if (bjj().bkm() != null && bjj().bkm().smartApp != null) {
                        str = bjj().bkm().smartApp.h5_url;
                    }
                    this.fEL.wY(str);
                }
                TiebaStatic.log(new am("c13274").bT("fid", bjj().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", bjj().bkm().smartApp.name).l(VideoPlayActivityConfig.OBJ_ID, bjj().bkm().smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside").P("obj_param1", bjj().bkm().smartApp.is_game.intValue()));
            } else {
                this.fEL.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.fEL;
                String forumId = bjj().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.fEL;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.fEL;
                frsLiteProgramListFragment.t(forumId, 1, 10);
                TiebaStatic.log(new am("c13273").bT("fid", bjj().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.fEK = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.fEK != null) {
            this.fEK.setContentView(R.layout.frs_base_layout);
            this.fER = (FrsBaseViewPager) this.fEK.findViewById(R.id.frs_base_viewpager);
            this.fES = new FragmentAdapter(this.fEK.getSupportFragmentManager());
            this.fER.setAdapter(this.fES);
            this.fER.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.fER.addOnPageChangeListener(this.fFi);
            this.fER.setmDisallowSlip(true);
            this.fER.setOnTouchEventListener(this.fFj);
            this.fET = (OvalActionButton) this.fEK.findViewById(R.id.frs_post_forum_button);
            this.fsw = (FRSRefreshButton) this.fEK.findViewById(R.id.frs_refresh_forum_button);
            this.fEK.registerListener(this.fFg);
            this.fEK.registerListener(this.fFh);
            this.fEK.registerListener(this.fFe);
            this.fEK.registerListener(this.fFf);
            this.fEY.getHttpMessageListener().setPriority(-1);
            this.fEY.getSocketMessageListener().setPriority(-1);
            this.fEK.registerListener(this.fEZ);
            this.fFb.setSelfListener(true);
            this.fEK.registerListener(this.fFb);
            this.fFa.setSelfListener(true);
            this.fEK.registerListener(this.fFa);
            this.fEK.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.fEK.getIntent().getStringExtra("name");
                this.fst = this.fEK.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.fst = bundle.getInt("default_tab_id", 0);
            }
            P(bundle);
            this.fES.notifyDataSetChanged();
            this.fEP = new ShareSuccessReplyToServerModel();
            this.fEK.registerListener(this.fEY);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.fst);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.fES != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.fES.wG(fEH);
                if (frsFragment == null) {
                    frsFragment = Q(bundle);
                }
                frsFragment.b(this.fET);
                frsFragment.a(this.fsw);
                if (!fEH.equals(this.fES.rZ(0))) {
                    if (fEJ.equals(this.fES.rZ(0))) {
                        this.fES.rY(0);
                    }
                    this.fES.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(j jVar) {
        if (jVar != null && (jVar.smartApp != null || !v.aa(jVar.smartAppAvatar))) {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.fES == null) {
                return false;
            }
            if (fEI.equals(this.fES.rZ(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.fES.wG(fEI);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = bop();
                }
                this.fES.a(1, frsLiteProgramListFragment);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boo() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.fES != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.fES.wG(fEJ);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = boq();
                }
                frsTabHostFragment.b(this.fET);
                frsTabHostFragment.b(this.fsw);
                if (!fEJ.equals(this.fES.rZ(0))) {
                    if (fEH.equals(this.fES.rZ(0))) {
                        this.fES.rY(0);
                    }
                    this.fES.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment Q(Bundle bundle) {
        if (this.fsr == null) {
            this.fsr = new FrsFragment();
            this.fsr.setArguments(bundle);
            this.fsr.setBaseTag(fEH);
        }
        this.fsr.foZ = false;
        return this.fsr;
    }

    private FrsLiteProgramListFragment bop() {
        if (this.fEL == null) {
            this.fEL = new FrsLiteProgramListFragment();
            this.fEL.setBaseTag(fEI);
        }
        return this.fEL;
    }

    private FrsTabHostFragment boq() {
        if (this.fEM == null) {
            this.fEM = new FrsTabHostFragment(this);
            this.fEM.setBaseTag(fEJ);
            this.fEM.rr(this.fst);
        }
        return this.fEM;
    }

    private FragmentManager getFragmentManager() {
        if (this.fEK != null) {
            return this.fEK.getSupportFragmentManager();
        }
        return null;
    }

    private void bor() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fss != null && (themeColorInfo = this.fss.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.fET.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
            this.fsw.setIconFade(R.drawable.icon_frs_refresh_n);
            this.fsw.setShadowColor(al.getColor(R.color.cp_mask_g));
            this.fsw.setColor(al.getColor(R.color.cp_bg_line_a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final j jVar) {
        if (jVar != null && jVar.getForum() != null) {
            if (jVar.getForum().getIsShowBawuTask()) {
                int i = com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_bawu_task_toast", 0);
                if (i >= 0 && i < 1 && !this.fEX) {
                    this.fEX = true;
                    e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsTabController.this.box();
                        }
                    }, StatisticConfig.MIN_UPLOAD_INTERVAL);
                } else {
                    return;
                }
            }
            this.fss = jVar;
            if (v.Z(jVar.getGameTabInfo()) > 0) {
                if (!this.fEK.isLoadingViewAttached() && !bov()) {
                    this.fEK.showLoadingView(this.fEK.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean c = FrsTabController.this.c(jVar);
                        FrsTabController.this.e(jVar);
                        boolean cf = FrsTabController.this.cf(FrsTabController.this.fss.getGameTabInfo());
                        if (c || cf) {
                            FrsTabController.this.fES.notifyDataSetChanged();
                            if (cf && FrsTabController.this.fEM != null) {
                                FrsTabController.this.fEM.L(FrsTabController.this.fsr);
                                FrsTabController.this.fEM.a(FrsTabController.this.fss, FrsTabController.this.fsq);
                            }
                        }
                    }
                });
            } else if (bov()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.c(jVar);
                        FrsTabController.this.fsr.foZ = true;
                        if (FrsTabController.this.fsr != null) {
                            bundle = FrsTabController.this.fsr.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.P(bundle);
                        FrsTabController.this.fES.notifyDataSetChanged();
                        FrsTabController.this.e(jVar);
                    }
                });
            } else if (jVar != null && (jVar.smartApp != null || !v.aa(jVar.smartAppAvatar))) {
                if (!this.fEK.isLoadingViewAttached() && !bow()) {
                    this.fEK.showLoadingView(this.fEK.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsTabController.this.c(jVar)) {
                            FrsTabController.this.e(jVar);
                            FrsTabController.this.fES.notifyDataSetChanged();
                        }
                        if (FrsTabController.this.fEK.isLoadingViewAttached()) {
                            FrsTabController.this.fEK.hideLoadingView(FrsTabController.this.fEK.findViewById(16908290));
                        }
                    }
                });
            }
            bor();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(j jVar) {
        if (jVar != null) {
            if (jVar.smartApp != null || !v.aa(jVar.smartAppAvatar)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cf(List<FrsTabInfo> list) {
        if (this.fEK.isLoadingViewAttached()) {
            this.fEK.hideLoadingView(this.fEK.findViewById(16908290));
        }
        if (bov()) {
            return false;
        }
        this.fsr.foZ = true;
        bos();
        if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("frs_login_tip", true);
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("frs_game_login_tip", false);
        }
        cg(list);
        return true;
    }

    private void bos() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.fEK.registerListener(1021074, this.fFc);
    }

    private void cg(List<FrsTabInfo> list) {
        boolean z;
        if (!v.aa(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean(FrsTabController.this.fEO, true)) {
                            e.iB().post(FrsTabController.this.fFd);
                        }
                        ((ab) customResponsedMessage.getData()).b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                            @Override // com.baidu.tbadk.mainTab.b
                            public boolean isAvailable() {
                                return true;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public com.baidu.tbadk.mainTab.c asJ() {
                                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", FrsTabController.this.fsr.getForumName());
                                bundle.putString("from", FrsTabController.this.fsr.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.fsr.getForumId());
                                bundle.putInt(MyBookrackActivityConfig.TAB_ID, 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.fss.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.fss.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.fss.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.fss);
                                bundle.putSerializable("view_data", frsViewData);
                                frsSportsRecommendFragment.setArguments(bundle);
                                com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                                cVar.cwo = frsSportsRecommendFragment;
                                cVar.type = 25;
                                cVar.cwu = com.baidu.tbadk.mainTab.c.cwr;
                                return cVar;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public TbFragmentTabIndicator cO(Context context) {
                                this.cwa = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
                                this.cwa.setTextSize(2.0f);
                                return this.cwa;
                            }
                        });
                        FrsTabController.this.boo();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.fEK.registerListener(customMessageListener);
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : list) {
                if (frsTabInfo != null) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        FrsTabInfo frsTabInfo2 = (FrsTabInfo) it.next();
                        if (frsTabInfo2 != null && frsTabInfo2.tab_id == frsTabInfo.tab_id) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        arrayList.add(frsTabInfo);
                    }
                }
            }
            this.fsq = new ab(this.fEK.getActivity(), arrayList);
            if (bjj() != null) {
                this.fsq.setForumId(bjj().getForumId());
                this.fsq.setForumName(bjj().getForumName());
                if (bjj().bkm() != null && bjj().bkm().getForum() != null) {
                    ForumData forum = bjj().bkm().getForum();
                    this.fsq.setForumGameLabel(forum.getForumGameLabel());
                    this.fsq.ws(forum.getSpecialForumType());
                }
            }
            this.fsr.foZ = false;
            new d(this.fsr).a(this.fsq);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.fsq);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.fEK.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bot() {
        if (this.fsq != null && !TextUtils.isEmpty(this.fsq.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.fss.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar aJC;
        if ((fragment instanceof ah) && this.fss != null && this.fss.getForum() != null && (aJC = ((ah) fragment).aJC()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.fss.getForum().getName(), 5, true, true) + this.fEK.getActivity().getString(R.string.forum));
            aJC.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.fsr instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fsr.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a lX(int i) {
        if (this.fsr instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.fsr.lX(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.fsr instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fsr.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.fsr != null) {
            this.fsr.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!bov()) {
            this.fsr.setPrimary(true);
        } else if (this.fEM != null) {
            Fragment currentFragment = this.fEM.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.fEQ) {
            this.fEQ = false;
            if (this.fsr != null) {
                this.fsr.refresh();
            }
        }
    }

    public void onPause() {
        if (!bov()) {
            this.fsr.setPrimary(false);
        } else if (this.fEM != null) {
            Fragment currentFragment = this.fEM.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.fEK);
        if (this.fsr != null) {
            this.fsr.onChangeSkinType(i);
        }
        if (this.fEM != null) {
            this.fEM.onChangeSkinType(i);
        }
        bor();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fEL != null && this.fEL.fJa) {
                this.fEL.fJa = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            } else if (bov() && this.fEM != null && this.fEM.blA()) {
                this.fEM.blB();
                UtilHelper.setNavigationBarBackground(this.fEK, this.fEM.blv());
            } else if (this.fsr != null && this.fsr.isAdded()) {
                if (this.fsr.onKeyDown(i, keyEvent)) {
                    return true;
                }
                bou();
            } else {
                return this.fEK.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.fsr != null && this.fsr.isAdded()) {
                return this.fsr.onKeyDown(i, keyEvent);
            }
        } else {
            return this.fEK.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bou() {
        if (this.fsu != this.fst && bov()) {
            this.fEM.setCurrentTab(this.fst);
            if (ro(this.fst) != 1) {
                this.fsr.jH(false);
            }
            this.fsu = this.fst;
            a(this.fEM.getCurrentFragment(), this.fst);
            return;
        }
        this.fsr.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!bov()) {
            this.fsr.onActivityResult(i, i2, intent);
        } else if (this.fEM != null) {
            if (1 == this.fEM.getCurrentTabType()) {
                this.fsr.onActivityResult(i, i2, intent);
            } else {
                this.fEM.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.ceu().w(this.fEK.getPageContext());
                    com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.fEP != null) {
                        this.fEP.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void anI() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.fEK != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.fEK.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.ceu().w(this.fEK.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!bov()) {
            return this.fsr.getVoiceManager();
        }
        if (this.fEM == null) {
            return null;
        }
        Fragment currentFragment = this.fEM.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rm(int i) {
        if (this.fsq == null) {
            return -1;
        }
        int Z = v.Z(this.fsq.blJ());
        for (int i2 = 0; i2 < Z; i2++) {
            if (this.fsq.blJ().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ro(int i) {
        if (this.fsq != null && i < v.Z(this.fsq.blJ())) {
            return this.fsq.blJ().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bjj() {
        return this.fsr;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> bjk() {
        if (!bov()) {
            if (this.fsr instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.fsr).bjk();
            }
        } else if (this.fEM == null) {
            return null;
        } else {
            Fragment currentFragment = this.fEM.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).bjk();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(n.frO);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fEK.isLoadingViewAttached()) {
            this.fEK.hideLoadingView(this.fEK.findViewById(16908290));
        }
        if (this.fFd != null) {
            e.iB().removeCallbacks(this.fFd);
        }
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean(this.fEO, false);
        if (this.fEP != null) {
            this.fEP.cancelLoadData();
        }
        if (this.fsr != null && this.fsr.bjK() != null) {
            this.fsr.bjK().onActivityDestroy();
        }
        if (this.fEW != null) {
            this.fEW.onDestroy();
        }
    }

    public FragmentTabHost bly() {
        if (this.fEM == null) {
            return null;
        }
        return this.fEM.bly();
    }

    public boolean bov() {
        if (this.fES == null) {
            return false;
        }
        return this.fES.getItem(0) instanceof FrsTabHostFragment;
    }

    private boolean bow() {
        if (this.fES == null) {
            return false;
        }
        return this.fES.getItem(1) instanceof FrsLiteProgramListFragment;
    }

    public void rr(int i) {
        this.fst = i;
    }

    public void rW(int i) {
        this.fsu = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void box() {
        if (this.fEK != null) {
            if (this.fEW == null) {
                this.fEW = (NavigationBarCoverTip) this.fEK.findViewById(R.id.navigation_cover_tip);
            }
            if (this.fEW != null) {
                View inflate = View.inflate(this.fEK, R.layout.write_thread_share_guide, null);
                TextView textView = (TextView) inflate.findViewById(R.id.write_thread_success_tips);
                TextView textView2 = (TextView) inflate.findViewById(R.id.share_icon);
                if (TextUtils.isEmpty(this.mForumName)) {
                    textView.setText("吧主您好，本吧考核新制度上线啦");
                } else {
                    textView.setText(this.mForumName + "吧吧主您好，本吧考核新制度上线啦");
                }
                textView2.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.check_immediately));
                al.j(textView, R.color.cp_btn_a);
                al.j(textView2, R.color.cp_btn_a);
                al.k(textView2, R.drawable.share_now_bg);
                al.l(this.fEW, R.color.cp_link_tip_a_alpha95);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new am("c13439").aif();
                        if (FrsTabController.this.bjj() != null && !TextUtils.isEmpty(FrsTabController.this.bjj().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.fEK != null) {
                            if (FrsTabController.this.fEW != null) {
                                FrsTabController.this.fEW.hideTip();
                            }
                            ba.aiz().c(FrsTabController.this.fEK.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.bjj().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.fEW.a(this.fEK, inflate, 30000);
                new am("c13438").aif();
                int i = com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_bawu_task_toast", 0);
                if (i > 0) {
                    com.baidu.tbadk.core.sharedPref.b.agM().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<BaseFragment> mFragments;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mFragments = new ArrayList(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v4.app.FragmentStatePagerAdapter
        /* renamed from: rX */
        public BaseFragment getItem(int i) {
            return (BaseFragment) v.c(this.mFragments, i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return this.mFragments.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        public boolean a(int i, BaseFragment baseFragment) {
            return v.a(this.mFragments, i, baseFragment);
        }

        public BaseFragment wG(String str) {
            if (ap.isEmpty(str)) {
                return null;
            }
            for (BaseFragment baseFragment : this.mFragments) {
                if (baseFragment != null && str.equals(baseFragment.getBaseTag())) {
                    return baseFragment;
                }
            }
            return null;
        }

        public BaseFragment rY(int i) {
            return (BaseFragment) v.d(this.mFragments, i);
        }

        public String rZ(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }
}
