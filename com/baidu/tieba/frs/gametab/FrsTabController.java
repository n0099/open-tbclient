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
    public static final String fEG = FrsFragment.class.getSimpleName();
    public static final String fEH = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String fEI = FrsTabHostFragment.class.getSimpleName();
    private FrsActivity fEJ;
    private FrsLiteProgramListFragment fEK;
    private FrsTabHostFragment fEL;
    private ShareSuccessReplyToServerModel fEO;
    private FrsBaseViewPager fEQ;
    private FragmentAdapter fER;
    private OvalActionButton fES;
    private boolean fET;
    private boolean fEU;
    private NavigationBarCoverTip fEV;
    private ab fsp;
    private FrsFragment fsq;
    private j fsr;
    private int fst;
    private FRSRefreshButton fsv;
    private String mForumName;
    private boolean fEM = false;
    private final Handler mHandler = new Handler();
    private int fss = 0;
    private boolean fEP = false;
    private boolean fEW = false;
    private com.baidu.adp.framework.listener.a fEX = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            j jVar = null;
            if (!FrsTabController.this.fEM && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    jVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    jVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (jVar != null) {
                    FrsTabController.this.fEM = true;
                    FrsTabController.this.d(jVar);
                    if (jVar != null && jVar.getForum() != null && !StringUtils.isNull(jVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.abt().bB("2", jVar.getForum().getId());
                    }
                }
            }
        }
    };
    private CustomMessageListener fEY = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.fEM && FrsTabController.this.fsr == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof j)) {
                j jVar = (j) customResponsedMessage.getData();
                if (jVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(jVar.getForum().getName())) {
                    FrsTabController.this.d(jVar);
                }
            }
        }
    };
    private CustomMessageListener fEZ = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.bor();
        }
    };
    private CustomMessageListener fFa = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
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
                if (rm != -1 && FrsTabController.this.bos() && FrsTabController.this.fEL != null) {
                    FrsTabController.this.fEL.setCurrentTab(rm);
                    if (FrsTabController.this.ro(rm) != 1) {
                        FrsTabController.this.fsq.jH(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener fFb = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.aa(newNotifyData) && FrsTabController.this.fEL != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.fsp.blG().size(); i++) {
                                FragmentTabHost.b hN = FrsTabController.this.fEL.hN(i);
                                if (hN != null && hN.mType != 1 && hN.mType != FrsTabController.this.fEL.getCurrentTabType() && hN.mType == aVar.getTabId() && aVar.boj() && hN.bPI.qz(String.valueOf(hN.mType)) != null) {
                                    hN.bPI.qz(String.valueOf(hN.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable fFc = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        @Override // java.lang.Runnable
        public void run() {
            e.iB().removeCallbacks(this);
            FrsTabController.this.boq();
            e.iB().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.fEP = true;
            }
        }
    };
    private CustomMessageListener fFd = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!i.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.fEQ != null && FrsTabController.this.fER != null && FrsTabController.this.fER.wH(FrsTabController.fEH) != null) {
                if (!com.baidu.adp.lib.util.j.jS()) {
                    FrsTabController.this.fEJ.showToast(FrsTabController.this.fEJ.getString(R.string.neterror));
                } else if ((FrsTabController.this.bjg().bkj().smartAppAvatar == null || FrsTabController.this.bjg().bkj().smartAppAvatar.size() != 1) && (FrsTabController.this.bjg().bkj().smartAppAvatar != null || FrsTabController.this.bjg().bkj().smartApp == null)) {
                    FrsTabController.this.fEQ.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.bjg().bkj().smartApp;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                        FrsTabController.this.fEQ.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new am("c13274").bT("fid", FrsTabController.this.bjg().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", FrsTabController.this.bjg().bkj().smartApp.name).l(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.bjg().bkj().smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside").P("obj_param1", FrsTabController.this.bjg().bkj().smartApp.is_game.intValue()));
                    }
                }
            }
        }
    };
    private CustomMessageListener fFe = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fEQ != null && FrsTabController.this.fER != null && FrsTabController.this.fER.wH(FrsTabController.fEH) != null) {
                FrsTabController.this.fEQ.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener fFf = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fEQ != null && FrsTabController.this.fER != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.fET = aVar.blD();
                FrsTabController.this.fEU = aVar.blE();
            }
        }
    };
    private CustomMessageListener fFg = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fEQ != null && FrsTabController.this.fER != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.fEQ.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener fFh = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.fsq.bkh();
                FrsTabController.this.bok();
                if (FrsTabController.this.bjg() != null) {
                    FrsTabController.this.bjg().jB(true);
                }
                FrsTabController.this.fES.setVisibility(8);
                return;
            }
            FrsTabController.this.fES.setVisibility(0);
            if (FrsTabController.this.bjg() != null) {
                FrsTabController.this.bjg().jB(false);
            }
            FrsTabController.this.fsq.bki();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.fEU = false;
                    FrsTabController.this.fEQ.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a fFi = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void bjw() {
            if (FrsTabController.this.fEQ != null) {
                if (FrsTabController.this.fEQ.getCurrentItem() == 0) {
                    FrsTabController.this.fEQ.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.fEQ.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean bjx() {
            SmartApp smartApp;
            if (FrsTabController.this.fEQ.getCurrentItem() == 0) {
                if (FrsTabController.this.fET && FrsTabController.this.fEU) {
                    FrsTabController.this.fEQ.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.fEU) {
                    FrsTabController.this.fEQ.setmDisallowSlip(true);
                }
                FrsTabController.this.fEQ.setmDisallowSlip(true);
            } else {
                FrsTabController.this.fEQ.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.bjg().bkj().smartAppAvatar == null || FrsTabController.this.bjg().bkj().smartAppAvatar.size() != 1) && (FrsTabController.this.bjg().bkj().smartAppAvatar != null || FrsTabController.this.bjg().bkj().smartApp == null)) || (smartApp = FrsTabController.this.bjg().bkj().smartApp) == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                return true;
            }
            TiebaStatic.log(new am("c13274").bT("fid", FrsTabController.this.bjg().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", FrsTabController.this.bjg().bkj().smartApp.name).l(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.bjg().bkj().smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside").P("obj_param1", FrsTabController.this.bjg().bkj().smartApp.is_game.intValue()));
            return false;
        }
    };
    private String fEN = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    /* JADX INFO: Access modifiers changed from: private */
    public void bok() {
        if (this.fEK != null && bjg() != null) {
            this.fEK.fIX = true;
            this.fEK.clear();
            if (!com.baidu.adp.lib.util.j.jS()) {
                this.fEK.wV(bjg().getForumId());
            } else if ((bjg().bkj().smartAppAvatar != null && bjg().bkj().smartAppAvatar.size() == 1) || (bjg().bkj().smartAppAvatar == null && bjg().bkj().smartApp != null)) {
                SmartApp smartApp = bjg().bkj().smartApp;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                    String str = null;
                    if (bjg().bkj() != null && bjg().bkj().smartApp != null) {
                        str = bjg().bkj().smartApp.h5_url;
                    }
                    this.fEK.wW(str);
                }
                TiebaStatic.log(new am("c13274").bT("fid", bjg().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", bjg().bkj().smartApp.name).l(VideoPlayActivityConfig.OBJ_ID, bjg().bkj().smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside").P("obj_param1", bjg().bkj().smartApp.is_game.intValue()));
            } else {
                this.fEK.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.fEK;
                String forumId = bjg().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.fEK;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.fEK;
                frsLiteProgramListFragment.t(forumId, 1, 10);
                TiebaStatic.log(new am("c13273").bT("fid", bjg().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.fEJ = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.fEJ != null) {
            this.fEJ.setContentView(R.layout.frs_base_layout);
            this.fEQ = (FrsBaseViewPager) this.fEJ.findViewById(R.id.frs_base_viewpager);
            this.fER = new FragmentAdapter(this.fEJ.getSupportFragmentManager());
            this.fEQ.setAdapter(this.fER);
            this.fEQ.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.fEQ.addOnPageChangeListener(this.fFh);
            this.fEQ.setmDisallowSlip(true);
            this.fEQ.setOnTouchEventListener(this.fFi);
            this.fES = (OvalActionButton) this.fEJ.findViewById(R.id.frs_post_forum_button);
            this.fsv = (FRSRefreshButton) this.fEJ.findViewById(R.id.frs_refresh_forum_button);
            this.fEJ.registerListener(this.fFf);
            this.fEJ.registerListener(this.fFg);
            this.fEJ.registerListener(this.fFd);
            this.fEJ.registerListener(this.fFe);
            this.fEX.getHttpMessageListener().setPriority(-1);
            this.fEX.getSocketMessageListener().setPriority(-1);
            this.fEJ.registerListener(this.fEY);
            this.fFa.setSelfListener(true);
            this.fEJ.registerListener(this.fFa);
            this.fEZ.setSelfListener(true);
            this.fEJ.registerListener(this.fEZ);
            this.fEJ.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.fEJ.getIntent().getStringExtra("name");
                this.fss = this.fEJ.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.fss = bundle.getInt("default_tab_id", 0);
            }
            P(bundle);
            this.fER.notifyDataSetChanged();
            this.fEO = new ShareSuccessReplyToServerModel();
            this.fEJ.registerListener(this.fEX);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.fss);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.fER != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.fER.wH(fEG);
                if (frsFragment == null) {
                    frsFragment = Q(bundle);
                }
                frsFragment.b(this.fES);
                frsFragment.a(this.fsv);
                if (!fEG.equals(this.fER.rZ(0))) {
                    if (fEI.equals(this.fER.rZ(0))) {
                        this.fER.rY(0);
                    }
                    this.fER.a(0, frsFragment);
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
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.fER == null) {
                return false;
            }
            if (fEH.equals(this.fER.rZ(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.fER.wH(fEH);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = bom();
                }
                this.fER.a(1, frsLiteProgramListFragment);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bol() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.fER != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.fER.wH(fEI);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = bon();
                }
                frsTabHostFragment.b(this.fES);
                frsTabHostFragment.b(this.fsv);
                if (!fEI.equals(this.fER.rZ(0))) {
                    if (fEG.equals(this.fER.rZ(0))) {
                        this.fER.rY(0);
                    }
                    this.fER.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment Q(Bundle bundle) {
        if (this.fsq == null) {
            this.fsq = new FrsFragment();
            this.fsq.setArguments(bundle);
            this.fsq.setBaseTag(fEG);
        }
        this.fsq.foY = false;
        return this.fsq;
    }

    private FrsLiteProgramListFragment bom() {
        if (this.fEK == null) {
            this.fEK = new FrsLiteProgramListFragment();
            this.fEK.setBaseTag(fEH);
        }
        return this.fEK;
    }

    private FrsTabHostFragment bon() {
        if (this.fEL == null) {
            this.fEL = new FrsTabHostFragment(this);
            this.fEL.setBaseTag(fEI);
            this.fEL.rr(this.fss);
        }
        return this.fEL;
    }

    private FragmentManager getFragmentManager() {
        if (this.fEJ != null) {
            return this.fEJ.getSupportFragmentManager();
        }
        return null;
    }

    private void boo() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fsr != null && (themeColorInfo = this.fsr.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.fES.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
            this.fsv.setIconFade(R.drawable.icon_frs_refresh_n);
            this.fsv.setShadowColor(al.getColor(R.color.cp_mask_g));
            this.fsv.setColor(al.getColor(R.color.cp_bg_line_a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final j jVar) {
        if (jVar != null && jVar.getForum() != null) {
            if (jVar.getForum().getIsShowBawuTask()) {
                int i = com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_bawu_task_toast", 0);
                if (i >= 0 && i < 1 && !this.fEW) {
                    this.fEW = true;
                    e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsTabController.this.bou();
                        }
                    }, StatisticConfig.MIN_UPLOAD_INTERVAL);
                } else {
                    return;
                }
            }
            this.fsr = jVar;
            if (v.Z(jVar.getGameTabInfo()) > 0) {
                if (!this.fEJ.isLoadingViewAttached() && !bos()) {
                    this.fEJ.showLoadingView(this.fEJ.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean c = FrsTabController.this.c(jVar);
                        FrsTabController.this.e(jVar);
                        boolean cf = FrsTabController.this.cf(FrsTabController.this.fsr.getGameTabInfo());
                        if (c || cf) {
                            FrsTabController.this.fER.notifyDataSetChanged();
                            if (cf && FrsTabController.this.fEL != null) {
                                FrsTabController.this.fEL.L(FrsTabController.this.fsq);
                                FrsTabController.this.fEL.a(FrsTabController.this.fsr, FrsTabController.this.fsp);
                            }
                        }
                    }
                });
            } else if (bos()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.c(jVar);
                        FrsTabController.this.fsq.foY = true;
                        if (FrsTabController.this.fsq != null) {
                            bundle = FrsTabController.this.fsq.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.P(bundle);
                        FrsTabController.this.fER.notifyDataSetChanged();
                        FrsTabController.this.e(jVar);
                    }
                });
            } else if (jVar != null && (jVar.smartApp != null || !v.aa(jVar.smartAppAvatar))) {
                if (!this.fEJ.isLoadingViewAttached() && !bot()) {
                    this.fEJ.showLoadingView(this.fEJ.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsTabController.this.c(jVar)) {
                            FrsTabController.this.e(jVar);
                            FrsTabController.this.fER.notifyDataSetChanged();
                        }
                        if (FrsTabController.this.fEJ.isLoadingViewAttached()) {
                            FrsTabController.this.fEJ.hideLoadingView(FrsTabController.this.fEJ.findViewById(16908290));
                        }
                    }
                });
            }
            boo();
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
        if (this.fEJ.isLoadingViewAttached()) {
            this.fEJ.hideLoadingView(this.fEJ.findViewById(16908290));
        }
        if (bos()) {
            return false;
        }
        this.fsq.foY = true;
        bop();
        if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("frs_login_tip", true);
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("frs_game_login_tip", false);
        }
        cg(list);
        return true;
    }

    private void bop() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.fEJ.registerListener(1021074, this.fFb);
    }

    private void cg(List<FrsTabInfo> list) {
        boolean z;
        if (!v.aa(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean(FrsTabController.this.fEN, true)) {
                            e.iB().post(FrsTabController.this.fFc);
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
                                bundle.putString("name", FrsTabController.this.fsq.getForumName());
                                bundle.putString("from", FrsTabController.this.fsq.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.fsq.getForumId());
                                bundle.putInt(MyBookrackActivityConfig.TAB_ID, 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.fsr.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.fsr.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.fsr.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.fsr);
                                bundle.putSerializable("view_data", frsViewData);
                                frsSportsRecommendFragment.setArguments(bundle);
                                com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                                cVar.cwn = frsSportsRecommendFragment;
                                cVar.type = 25;
                                cVar.cwt = com.baidu.tbadk.mainTab.c.cwq;
                                return cVar;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public TbFragmentTabIndicator cO(Context context) {
                                this.cvZ = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
                                this.cvZ.setTextSize(2.0f);
                                return this.cvZ;
                            }
                        });
                        FrsTabController.this.bol();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.fEJ.registerListener(customMessageListener);
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
            this.fsp = new ab(this.fEJ.getActivity(), arrayList);
            if (bjg() != null) {
                this.fsp.setForumId(bjg().getForumId());
                this.fsp.setForumName(bjg().getForumName());
                if (bjg().bkj() != null && bjg().bkj().getForum() != null) {
                    ForumData forum = bjg().bkj().getForum();
                    this.fsp.setForumGameLabel(forum.getForumGameLabel());
                    this.fsp.wt(forum.getSpecialForumType());
                }
            }
            this.fsq.foY = false;
            new d(this.fsq).a(this.fsp);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.fsp);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.fEJ.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boq() {
        if (this.fsp != null && !TextUtils.isEmpty(this.fsp.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.fsr.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar aJz;
        if ((fragment instanceof ah) && this.fsr != null && this.fsr.getForum() != null && (aJz = ((ah) fragment).aJz()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.fsr.getForum().getName(), 5, true, true) + this.fEJ.getActivity().getString(R.string.forum));
            aJz.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.fsq instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fsq.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a lX(int i) {
        if (this.fsq instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.fsq.lX(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.fsq instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fsq.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.fsq != null) {
            this.fsq.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!bos()) {
            this.fsq.setPrimary(true);
        } else if (this.fEL != null) {
            Fragment currentFragment = this.fEL.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.fEP) {
            this.fEP = false;
            if (this.fsq != null) {
                this.fsq.refresh();
            }
        }
    }

    public void onPause() {
        if (!bos()) {
            this.fsq.setPrimary(false);
        } else if (this.fEL != null) {
            Fragment currentFragment = this.fEL.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.fEJ);
        if (this.fsq != null) {
            this.fsq.onChangeSkinType(i);
        }
        if (this.fEL != null) {
            this.fEL.onChangeSkinType(i);
        }
        boo();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fEK != null && this.fEK.fIX) {
                this.fEK.fIX = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            } else if (bos() && this.fEL != null && this.fEL.blx()) {
                this.fEL.bly();
                UtilHelper.setNavigationBarBackground(this.fEJ, this.fEL.bls());
            } else if (this.fsq != null && this.fsq.isAdded()) {
                if (this.fsq.onKeyDown(i, keyEvent)) {
                    return true;
                }
                bor();
            } else {
                return this.fEJ.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.fsq != null && this.fsq.isAdded()) {
                return this.fsq.onKeyDown(i, keyEvent);
            }
        } else {
            return this.fEJ.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bor() {
        if (this.fst != this.fss && bos()) {
            this.fEL.setCurrentTab(this.fss);
            if (ro(this.fss) != 1) {
                this.fsq.jH(false);
            }
            this.fst = this.fss;
            a(this.fEL.getCurrentFragment(), this.fss);
            return;
        }
        this.fsq.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!bos()) {
            this.fsq.onActivityResult(i, i2, intent);
        } else if (this.fEL != null) {
            if (1 == this.fEL.getCurrentTabType()) {
                this.fsq.onActivityResult(i, i2, intent);
            } else {
                this.fEL.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.cer().w(this.fEJ.getPageContext());
                    com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.fEO != null) {
                        this.fEO.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void anI() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.fEJ != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.fEJ.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.cer().w(this.fEJ.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!bos()) {
            return this.fsq.getVoiceManager();
        }
        if (this.fEL == null) {
            return null;
        }
        Fragment currentFragment = this.fEL.getCurrentFragment();
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
        if (this.fsp == null) {
            return -1;
        }
        int Z = v.Z(this.fsp.blG());
        for (int i2 = 0; i2 < Z; i2++) {
            if (this.fsp.blG().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ro(int i) {
        if (this.fsp != null && i < v.Z(this.fsp.blG())) {
            return this.fsp.blG().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bjg() {
        return this.fsq;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> bjh() {
        if (!bos()) {
            if (this.fsq instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.fsq).bjh();
            }
        } else if (this.fEL == null) {
            return null;
        } else {
            Fragment currentFragment = this.fEL.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).bjh();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(n.frN);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fEJ.isLoadingViewAttached()) {
            this.fEJ.hideLoadingView(this.fEJ.findViewById(16908290));
        }
        if (this.fFc != null) {
            e.iB().removeCallbacks(this.fFc);
        }
        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean(this.fEN, false);
        if (this.fEO != null) {
            this.fEO.cancelLoadData();
        }
        if (this.fsq != null && this.fsq.bjH() != null) {
            this.fsq.bjH().onActivityDestroy();
        }
        if (this.fEV != null) {
            this.fEV.onDestroy();
        }
    }

    public FragmentTabHost blv() {
        if (this.fEL == null) {
            return null;
        }
        return this.fEL.blv();
    }

    public boolean bos() {
        if (this.fER == null) {
            return false;
        }
        return this.fER.getItem(0) instanceof FrsTabHostFragment;
    }

    private boolean bot() {
        if (this.fER == null) {
            return false;
        }
        return this.fER.getItem(1) instanceof FrsLiteProgramListFragment;
    }

    public void rr(int i) {
        this.fss = i;
    }

    public void rW(int i) {
        this.fst = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bou() {
        if (this.fEJ != null) {
            if (this.fEV == null) {
                this.fEV = (NavigationBarCoverTip) this.fEJ.findViewById(R.id.navigation_cover_tip);
            }
            if (this.fEV != null) {
                View inflate = View.inflate(this.fEJ, R.layout.write_thread_share_guide, null);
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
                al.l(this.fEV, R.color.cp_link_tip_a_alpha95);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new am("c13439").aif();
                        if (FrsTabController.this.bjg() != null && !TextUtils.isEmpty(FrsTabController.this.bjg().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.fEJ != null) {
                            if (FrsTabController.this.fEV != null) {
                                FrsTabController.this.fEV.hideTip();
                            }
                            ba.aiz().c(FrsTabController.this.fEJ.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.bjg().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.agM().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.fEV.a(this.fEJ, inflate, 30000);
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

        public BaseFragment wH(String str) {
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
