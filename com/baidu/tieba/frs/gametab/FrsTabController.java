package com.baidu.tieba.frs.gametab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
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
import com.baidu.adp.lib.util.j;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
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
import com.baidu.tieba.tbadkCore.l;
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
    public static final String fMi = FrsFragment.class.getSimpleName();
    public static final String fMj = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String fMk = FrsTabHostFragment.class.getSimpleName();
    private FrsActivity fMl;
    private FrsLiteProgramListFragment fMm;
    private FrsTabHostFragment fMn;
    private ShareSuccessReplyToServerModel fMq;
    private FrsBaseViewPager fMs;
    private FragmentAdapter fMt;
    private OvalActionButton fMu;
    private boolean fMv;
    private boolean fMw;
    private NavigationBarCoverTip fMx;
    private l fzA;
    private int fzC;
    private FRSRefreshButton fzE;
    private ab fzy;
    private FrsFragment fzz;
    private String mForumName;
    private boolean fMo = false;
    private final Handler mHandler = new Handler();
    private int fzB = 0;
    private boolean fMr = false;
    private boolean fMy = false;
    private com.baidu.adp.framework.listener.a fMz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            l lVar = null;
            if (!FrsTabController.this.fMo && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    lVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    lVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (lVar != null) {
                    FrsTabController.this.fMo = true;
                    FrsTabController.this.e(lVar);
                    if (lVar != null && lVar.getForum() != null && !StringUtils.isNull(lVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.acw().bB("2", lVar.getForum().getId());
                    }
                }
            }
        }
    };
    private CustomMessageListener fMA = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.fMo && FrsTabController.this.fzA == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                l lVar = (l) customResponsedMessage.getData();
                if (lVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(lVar.getForum().getName())) {
                    FrsTabController.this.e(lVar);
                }
            }
        }
    };
    private CustomMessageListener fMB = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.brt();
        }
    };
    private CustomMessageListener fMC = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int rJ;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    rJ = FrsTabController.this.rJ(9);
                    if (rJ == -1) {
                        rJ = FrsTabController.this.rJ(2);
                    }
                } else {
                    rJ = FrsTabController.this.rJ(intValue);
                }
                if (rJ != -1 && FrsTabController.this.bru() && FrsTabController.this.fMn != null) {
                    FrsTabController.this.fMn.setCurrentTab(rJ);
                    if (FrsTabController.this.rL(rJ) != 1) {
                        FrsTabController.this.fzz.jU(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener fMD = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.aa(newNotifyData) && FrsTabController.this.fMn != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.fzy.boF().size(); i++) {
                                FragmentTabHost.b hT = FrsTabController.this.fMn.hT(i);
                                if (hT != null && hT.mType != 1 && hT.mType != FrsTabController.this.fMn.getCurrentTabType() && hT.mType == aVar.getTabId() && aVar.brl() && hT.bRq.ra(String.valueOf(hT.mType)) != null) {
                                    hT.bRq.ra(String.valueOf(hT.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable fME = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        @Override // java.lang.Runnable
        public void run() {
            e.iK().removeCallbacks(this);
            FrsTabController.this.brs();
            e.iK().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.fMr = true;
            }
        }
    };
    private CustomMessageListener fMF = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!i.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.fMs != null && FrsTabController.this.fMt != null && FrsTabController.this.fMt.xL(FrsTabController.fMj) != null) {
                if (!j.kc()) {
                    FrsTabController.this.fMl.showToast(FrsTabController.this.fMl.getString(R.string.neterror));
                } else if ((FrsTabController.this.bmd().bnj().smartAppAvatar == null || FrsTabController.this.bmd().bnj().smartAppAvatar.size() != 1) && (FrsTabController.this.bmd().bnj().smartAppAvatar != null || FrsTabController.this.bmd().bnj().smartApp == null)) {
                    FrsTabController.this.fMs.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.bmd().bnj().smartApp;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                        FrsTabController.this.fMs.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new an("c13274").bT("fid", FrsTabController.this.bmd().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", FrsTabController.this.bmd().bnj().smartApp.name).n(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.bmd().bnj().smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside").P("obj_param1", FrsTabController.this.bmd().bnj().smartApp.is_game.intValue()));
                    }
                }
            }
        }
    };
    private CustomMessageListener fMG = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fMs != null && FrsTabController.this.fMt != null && FrsTabController.this.fMt.xL(FrsTabController.fMj) != null) {
                FrsTabController.this.fMs.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener fMH = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fMs != null && FrsTabController.this.fMt != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.fMv = aVar.boC();
                FrsTabController.this.fMw = aVar.boD();
            }
        }
    };
    private CustomMessageListener fMI = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fMs != null && FrsTabController.this.fMt != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.fMs.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener fMJ = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.fzz.bnh();
                FrsTabController.this.brm();
                if (FrsTabController.this.bmd() != null) {
                    FrsTabController.this.bmd().jO(true);
                }
                FrsTabController.this.fMu.setVisibility(8);
                return;
            }
            FrsTabController.this.fMu.setVisibility(0);
            if (FrsTabController.this.bmd() != null) {
                FrsTabController.this.bmd().jO(false);
            }
            FrsTabController.this.fzz.bni();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.fMw = false;
                    FrsTabController.this.fMs.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a fMK = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void bmt() {
            if (FrsTabController.this.fMs != null) {
                if (FrsTabController.this.fMs.getCurrentItem() == 0) {
                    FrsTabController.this.fMs.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.fMs.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean bmu() {
            SmartApp smartApp;
            if (FrsTabController.this.fMs.getCurrentItem() == 0) {
                if (FrsTabController.this.fMv && FrsTabController.this.fMw) {
                    FrsTabController.this.fMs.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.fMw) {
                    FrsTabController.this.fMs.setmDisallowSlip(true);
                }
                FrsTabController.this.fMs.setmDisallowSlip(true);
            } else {
                FrsTabController.this.fMs.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.bmd().bnj().smartAppAvatar == null || FrsTabController.this.bmd().bnj().smartAppAvatar.size() != 1) && (FrsTabController.this.bmd().bnj().smartAppAvatar != null || FrsTabController.this.bmd().bnj().smartApp == null)) || (smartApp = FrsTabController.this.bmd().bnj().smartApp) == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                return true;
            }
            TiebaStatic.log(new an("c13274").bT("fid", FrsTabController.this.bmd().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", FrsTabController.this.bmd().bnj().smartApp.name).n(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.bmd().bnj().smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside").P("obj_param1", FrsTabController.this.bmd().bnj().smartApp.is_game.intValue()));
            return false;
        }
    };
    private String fMp = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    /* JADX INFO: Access modifiers changed from: private */
    public void brm() {
        if (this.fMm != null && bmd() != null) {
            this.fMm.fQC = true;
            this.fMm.clear();
            if (!j.kc()) {
                this.fMm.yc(bmd().getForumId());
            } else if ((bmd().bnj().smartAppAvatar != null && bmd().bnj().smartAppAvatar.size() == 1) || (bmd().bnj().smartAppAvatar == null && bmd().bnj().smartApp != null)) {
                SmartApp smartApp = bmd().bnj().smartApp;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                    String str = null;
                    if (bmd().bnj() != null && bmd().bnj().smartApp != null) {
                        str = bmd().bnj().smartApp.h5_url;
                    }
                    this.fMm.yd(str);
                }
                TiebaStatic.log(new an("c13274").bT("fid", bmd().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", bmd().bnj().smartApp.name).n(VideoPlayActivityConfig.OBJ_ID, bmd().bnj().smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside").P("obj_param1", bmd().bnj().smartApp.is_game.intValue()));
            } else {
                this.fMm.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.fMm;
                String forumId = bmd().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.fMm;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.fMm;
                frsLiteProgramListFragment.t(forumId, 1, 10);
                TiebaStatic.log(new an("c13273").bT("fid", bmd().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.fMl = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.fMl != null) {
            this.fMl.setContentView(R.layout.frs_base_layout);
            this.fMs = (FrsBaseViewPager) this.fMl.findViewById(R.id.frs_base_viewpager);
            this.fMt = new FragmentAdapter(this.fMl.getSupportFragmentManager());
            this.fMs.setAdapter(this.fMt);
            this.fMs.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.fMs.addOnPageChangeListener(this.fMJ);
            this.fMs.setmDisallowSlip(true);
            this.fMs.setOnTouchEventListener(this.fMK);
            this.fMu = (OvalActionButton) this.fMl.findViewById(R.id.frs_post_forum_button);
            this.fzE = (FRSRefreshButton) this.fMl.findViewById(R.id.frs_refresh_forum_button);
            this.fMl.registerListener(this.fMH);
            this.fMl.registerListener(this.fMI);
            this.fMl.registerListener(this.fMF);
            this.fMl.registerListener(this.fMG);
            this.fMz.getHttpMessageListener().setPriority(-1);
            this.fMz.getSocketMessageListener().setPriority(-1);
            this.fMl.registerListener(this.fMA);
            this.fMC.setSelfListener(true);
            this.fMl.registerListener(this.fMC);
            this.fMB.setSelfListener(true);
            this.fMl.registerListener(this.fMB);
            this.fMl.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.fMl.getIntent().getStringExtra("name");
                this.fzB = this.fMl.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.fzB = bundle.getInt("default_tab_id", 0);
            }
            P(bundle);
            this.fMt.notifyDataSetChanged();
            this.fMq = new ShareSuccessReplyToServerModel();
            this.fMl.registerListener(this.fMz);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.fzB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.fMt != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.fMt.xL(fMi);
                if (frsFragment == null) {
                    frsFragment = Q(bundle);
                }
                frsFragment.b(this.fMu);
                frsFragment.a(this.fzE);
                if (!fMi.equals(this.fMt.sx(0))) {
                    if (fMk.equals(this.fMt.sx(0))) {
                        this.fMt.sw(0);
                    }
                    this.fMt.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(l lVar) {
        if (lVar != null && (lVar.smartApp != null || !v.aa(lVar.smartAppAvatar))) {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.fMt == null) {
                return false;
            }
            if (fMj.equals(this.fMt.sx(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.fMt.xL(fMj);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = bro();
                }
                this.fMt.a(1, frsLiteProgramListFragment);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brn() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.fMt != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.fMt.xL(fMk);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = brp();
                }
                frsTabHostFragment.b(this.fMu);
                frsTabHostFragment.b(this.fzE);
                if (!fMk.equals(this.fMt.sx(0))) {
                    if (fMi.equals(this.fMt.sx(0))) {
                        this.fMt.sw(0);
                    }
                    this.fMt.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment Q(Bundle bundle) {
        if (this.fzz == null) {
            this.fzz = new FrsFragment();
            this.fzz.setArguments(bundle);
            this.fzz.setBaseTag(fMi);
        }
        this.fzz.fwk = false;
        return this.fzz;
    }

    private FrsLiteProgramListFragment bro() {
        if (this.fMm == null) {
            this.fMm = new FrsLiteProgramListFragment();
            this.fMm.setBaseTag(fMj);
        }
        return this.fMm;
    }

    private FrsTabHostFragment brp() {
        if (this.fMn == null) {
            this.fMn = new FrsTabHostFragment(this);
            this.fMn.setBaseTag(fMk);
            this.fMn.rO(this.fzB);
        }
        return this.fMn;
    }

    private FragmentManager getFragmentManager() {
        if (this.fMl != null) {
            return this.fMl.getSupportFragmentManager();
        }
        return null;
    }

    private void brq() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fzA != null && (themeColorInfo = this.fzA.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1 || skinType == 4) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.fMu.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
            this.fzE.setIconFade(R.drawable.icon_frs_refresh_n);
            this.fzE.setShadowColor(am.getColor(R.color.cp_mask_c_alpha25));
            this.fzE.setColor(R.color.cp_bg_line_h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final l lVar) {
        if (lVar != null && lVar.getForum() != null) {
            if (lVar.getForum().getIsShowBawuTask()) {
                int i = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_bawu_task_toast", 0);
                if (i >= 0 && i < 1 && !this.fMy) {
                    this.fMy = true;
                    e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsTabController.this.brw();
                        }
                    }, StatisticConfig.MIN_UPLOAD_INTERVAL);
                } else {
                    return;
                }
            }
            this.fzA = lVar;
            if (v.Z(lVar.getGameTabInfo()) > 0) {
                if (!this.fMl.isLoadingViewAttached() && !bru()) {
                    this.fMl.showLoadingView(this.fMl.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean d = FrsTabController.this.d(lVar);
                        FrsTabController.this.f(lVar);
                        boolean cf = FrsTabController.this.cf(FrsTabController.this.fzA.getGameTabInfo());
                        if (d || cf) {
                            FrsTabController.this.fMt.notifyDataSetChanged();
                            if (cf && FrsTabController.this.fMn != null) {
                                FrsTabController.this.fMn.L(FrsTabController.this.fzz);
                                FrsTabController.this.fMn.a(FrsTabController.this.fzA, FrsTabController.this.fzy);
                            }
                        }
                    }
                });
            } else if (bru()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.d(lVar);
                        FrsTabController.this.fzz.fwk = true;
                        if (FrsTabController.this.fzz != null) {
                            bundle = FrsTabController.this.fzz.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.P(bundle);
                        FrsTabController.this.fMt.notifyDataSetChanged();
                        FrsTabController.this.f(lVar);
                    }
                });
            } else if (lVar != null && (lVar.smartApp != null || !v.aa(lVar.smartAppAvatar))) {
                if (!this.fMl.isLoadingViewAttached() && !brv()) {
                    this.fMl.showLoadingView(this.fMl.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsTabController.this.d(lVar)) {
                            FrsTabController.this.f(lVar);
                            FrsTabController.this.fMt.notifyDataSetChanged();
                        }
                        if (FrsTabController.this.fMl.isLoadingViewAttached()) {
                            FrsTabController.this.fMl.hideLoadingView(FrsTabController.this.fMl.findViewById(16908290));
                        }
                    }
                });
            }
            brq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(l lVar) {
        if (lVar != null) {
            if (lVar.smartApp != null || !v.aa(lVar.smartAppAvatar)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cf(List<FrsTabInfo> list) {
        if (this.fMl.isLoadingViewAttached()) {
            this.fMl.hideLoadingView(this.fMl.findViewById(16908290));
        }
        if (bru()) {
            return false;
        }
        this.fzz.fwk = true;
        brr();
        if (com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("frs_login_tip", true);
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("frs_game_login_tip", false);
        }
        cg(list);
        return true;
    }

    private void brr() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.fMl.registerListener(1021074, this.fMD);
    }

    private void cg(List<FrsTabInfo> list) {
        boolean z;
        if (!v.aa(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean(FrsTabController.this.fMp, true)) {
                            e.iK().post(FrsTabController.this.fME);
                        }
                        ((ab) customResponsedMessage.getData()).b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                            @Override // com.baidu.tbadk.mainTab.b
                            public boolean isAvailable() {
                                return true;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public com.baidu.tbadk.mainTab.c auf() {
                                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", FrsTabController.this.fzz.getForumName());
                                bundle.putString("from", FrsTabController.this.fzz.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.fzz.getForumId());
                                bundle.putInt(MyBookrackActivityConfig.TAB_ID, 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.fzA.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.fzA.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.fzA.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.fzA);
                                bundle.putSerializable("view_data", frsViewData);
                                frsSportsRecommendFragment.setArguments(bundle);
                                com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                                cVar.cyG = frsSportsRecommendFragment;
                                cVar.type = 25;
                                cVar.cyM = com.baidu.tbadk.mainTab.c.cyJ;
                                return cVar;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public TbFragmentTabIndicator cP(Context context) {
                                this.cys = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
                                this.cys.setTextSize(2.0f);
                                return this.cys;
                            }
                        });
                        FrsTabController.this.brn();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.fMl.registerListener(customMessageListener);
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
            this.fzy = new ab(this.fMl.getActivity(), arrayList);
            if (bmd() != null) {
                this.fzy.setForumId(bmd().getForumId());
                this.fzy.setForumName(bmd().getForumName());
                if (bmd().bnj() != null && bmd().bnj().getForum() != null) {
                    ForumData forum = bmd().bnj().getForum();
                    this.fzy.setForumGameLabel(forum.getForumGameLabel());
                    this.fzy.xx(forum.getSpecialForumType());
                }
            }
            this.fzz.fwk = false;
            new d(this.fzz).a(this.fzy);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.fzy);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.fMl.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brs() {
        if (this.fzy != null && !TextUtils.isEmpty(this.fzy.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.fzA.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar aLN;
        if ((fragment instanceof ah) && this.fzA != null && this.fzA.getForum() != null && (aLN = ((ah) fragment).aLN()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.fzA.getForum().getName(), 5, true, true) + this.fMl.getActivity().getString(R.string.forum));
            aLN.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.fzz instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fzz.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a mj(int i) {
        if (this.fzz instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.fzz.mj(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.fzz instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fzz.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.fzz != null) {
            this.fzz.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!bru()) {
            this.fzz.setPrimary(true);
        } else if (this.fMn != null) {
            Fragment currentFragment = this.fMn.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.fMr) {
            this.fMr = false;
            if (this.fzz != null) {
                this.fzz.refresh();
            }
        }
    }

    public void onPause() {
        if (!bru()) {
            this.fzz.setPrimary(false);
        } else if (this.fMn != null) {
            Fragment currentFragment = this.fMn.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.fMl);
        if (this.fzz != null) {
            this.fzz.onChangeSkinType(i);
        }
        if (this.fMn != null) {
            this.fMn.onChangeSkinType(i);
        }
        brq();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fMm != null && this.fMm.fQC) {
                this.fMm.fQC = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            } else if (bru() && this.fMn != null && this.fMn.bow()) {
                this.fMn.box();
                UtilHelper.setNavigationBarBackground(this.fMl, this.fMn.bor());
            } else if (this.fzz != null && this.fzz.isAdded()) {
                if (this.fzz.onKeyDown(i, keyEvent)) {
                    return true;
                }
                brt();
            } else {
                return this.fMl.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.fzz != null && this.fzz.isAdded()) {
                return this.fzz.onKeyDown(i, keyEvent);
            }
        } else {
            return this.fMl.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brt() {
        if (this.fzC != this.fzB && bru()) {
            this.fMn.setCurrentTab(this.fzB);
            if (rL(this.fzB) != 1) {
                this.fzz.jU(false);
            }
            this.fzC = this.fzB;
            a(this.fMn.getCurrentFragment(), this.fzB);
            return;
        }
        this.fzz.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!bru()) {
            this.fzz.onActivityResult(i, i2, intent);
        } else if (this.fMn != null) {
            if (1 == this.fMn.getCurrentTabType()) {
                this.fzz.onActivityResult(i, i2, intent);
            } else {
                this.fMn.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.cir().y(this.fMl.getPageContext());
                    com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.fMq != null) {
                        this.fMq.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void apb() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.fMl != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.fMl.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.cir().y(this.fMl.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!bru()) {
            return this.fzz.getVoiceManager();
        }
        if (this.fMn == null) {
            return null;
        }
        Fragment currentFragment = this.fMn.getCurrentFragment();
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
    public int rJ(int i) {
        if (this.fzy == null) {
            return -1;
        }
        int Z = v.Z(this.fzy.boF());
        for (int i2 = 0; i2 < Z; i2++) {
            if (this.fzy.boF().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rL(int i) {
        if (this.fzy != null && i < v.Z(this.fzy.boF())) {
            return this.fzy.boF().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bmd() {
        return this.fzz;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> bme() {
        if (!bru()) {
            if (this.fzz instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.fzz).bme();
            }
        } else if (this.fMn == null) {
            return null;
        } else {
            Fragment currentFragment = this.fMn.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).bme();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(n.fyX);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fMl.isLoadingViewAttached()) {
            this.fMl.hideLoadingView(this.fMl.findViewById(16908290));
        }
        if (this.fME != null) {
            e.iK().removeCallbacks(this.fME);
        }
        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean(this.fMp, false);
        if (this.fMq != null) {
            this.fMq.cancelLoadData();
        }
        if (this.fzz != null && this.fzz.bmE() != null) {
            this.fzz.bmE().aGu();
        }
        if (this.fMx != null) {
            this.fMx.onDestroy();
        }
    }

    public FragmentTabHost bou() {
        if (this.fMn == null) {
            return null;
        }
        return this.fMn.bou();
    }

    public boolean bru() {
        if (this.fMt == null) {
            return false;
        }
        return this.fMt.getItem(0) instanceof FrsTabHostFragment;
    }

    private boolean brv() {
        if (this.fMt == null) {
            return false;
        }
        return this.fMt.getItem(1) instanceof FrsLiteProgramListFragment;
    }

    public void rO(int i) {
        this.fzB = i;
    }

    public void su(int i) {
        this.fzC = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brw() {
        if (this.fMl != null) {
            if (this.fMx == null) {
                this.fMx = (NavigationBarCoverTip) this.fMl.findViewById(R.id.navigation_cover_tip);
            }
            if (this.fMx != null) {
                View inflate = View.inflate(this.fMl, R.layout.write_thread_share_guide, null);
                TextView textView = (TextView) inflate.findViewById(R.id.write_thread_success_tips);
                TextView textView2 = (TextView) inflate.findViewById(R.id.share_icon);
                if (TextUtils.isEmpty(this.mForumName)) {
                    textView.setText("吧主您好，本吧考核新制度上线啦");
                } else {
                    textView.setText(this.mForumName + "吧吧主您好，本吧考核新制度上线啦");
                }
                textView2.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.check_immediately));
                am.j(textView, R.color.cp_cont_a);
                am.j(textView2, R.color.cp_cont_a);
                am.k(textView2, R.drawable.share_now_bg);
                am.l(this.fMx, R.color.cp_link_tip_a_alpha95);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new an("c13439").ajq();
                        if (FrsTabController.this.bmd() != null && !TextUtils.isEmpty(FrsTabController.this.bmd().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.fMl != null) {
                            if (FrsTabController.this.fMx != null) {
                                FrsTabController.this.fMx.hideTip();
                            }
                            ba.ajK().c(FrsTabController.this.fMl.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.bmd().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.fMx.a(this.fMl, inflate, 30000);
                new an("c13438").ajq();
                int i = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.ahU().putInt("key_bawu_task_toast", i + 1);
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
        /* renamed from: sv */
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

        public BaseFragment xL(String str) {
            if (aq.isEmpty(str)) {
                return null;
            }
            for (BaseFragment baseFragment : this.mFragments) {
                if (baseFragment != null && str.equals(baseFragment.getBaseTag())) {
                    return baseFragment;
                }
            }
            return null;
        }

        public BaseFragment sw(int i) {
            return (BaseFragment) v.d(this.mFragments, i);
        }

        public String sx(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }
}
