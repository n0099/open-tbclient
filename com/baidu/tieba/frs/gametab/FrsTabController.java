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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.v;
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
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes9.dex */
public class FrsTabController implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    private FrsActivity hEB;
    private FrsTabHostFragment hEC;
    private ShareSuccessReplyToServerModel hEF;
    private FrsBaseViewPager hEH;
    private FragmentAdapter hEI;
    private OvalActionButton hEJ;
    private boolean hEK;
    private boolean hEL;
    private NavigationBarCoverTip hEM;
    private ag hqT;
    private FrsFragment hqU;
    private m hqV;
    private int hqX;
    private FRSRefreshButton hqZ;
    private String mForumName;
    public static final String hEz = FrsFragment.class.getSimpleName();
    public static final String hEA = FrsTabHostFragment.class.getSimpleName();
    private boolean hED = false;
    private final Handler mHandler = new Handler();
    private int hqW = 0;
    private boolean hEG = false;
    private boolean hEN = false;
    private boolean hEO = false;
    private com.baidu.adp.framework.listener.a hEP = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            if (!FrsTabController.this.hED && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (mVar != null) {
                    FrsTabController.this.hED = true;
                    FrsTabController.this.a(mVar, true);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.aOc().cX("2", mVar.getForum().getId());
                    }
                }
                if (mVar != null && mVar.getUserData() != null && mVar.getUserData().getNewGodData() != null) {
                    if (mVar.getForum() != null) {
                        v.bgH().setFid(mVar.getForum().getId());
                    }
                    v.bgH().b(2, mVar.getUserData().getNewGodData());
                }
            }
        }
    };
    private CustomMessageListener hEQ = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.hED && FrsTabController.this.hqV == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false);
                }
            }
        }
    };
    private CustomMessageListener hER = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.bZK();
        }
    };
    private CustomMessageListener hES = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int ua;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    ua = FrsTabController.this.ua(9);
                    if (ua == -1) {
                        ua = FrsTabController.this.ua(2);
                    }
                } else {
                    ua = FrsTabController.this.ua(intValue);
                }
                if (ua != -1 && FrsTabController.this.bZL() && FrsTabController.this.hEC != null) {
                    FrsTabController.this.hEC.setCurrentTab(ua);
                    if (FrsTabController.this.uc(ua) != 1) {
                        FrsTabController.this.hqU.mO(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener hET = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!com.baidu.tbadk.core.util.v.isEmpty(newNotifyData) && FrsTabController.this.hEC != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.hqT.bUx().size(); i++) {
                                FragmentTabHost.b kX = FrsTabController.this.hEC.kX(i);
                                if (kX != null && kX.mType != 1 && kX.mType != FrsTabController.this.hEC.getCurrentTabType() && kX.mType == aVar.getTabId() && aVar.bZE() && kX.dLP.yy(String.valueOf(kX.mType)) != null) {
                                    kX.dLP.yy(String.valueOf(kX.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable hEU = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        @Override // java.lang.Runnable
        public void run() {
            e.ld().removeCallbacks(this);
            FrsTabController.this.bZJ();
            e.ld().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.hEG = true;
            }
        }
    };
    private CustomMessageListener hEV = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.hEH != null && FrsTabController.this.hEI != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.hEK = aVar.bWR();
                FrsTabController.this.hEL = aVar.bWS();
            }
        }
    };
    private CustomMessageListener hEW = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.hEH != null && FrsTabController.this.hEI != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.hEH.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener hEX = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.hEJ.setVisibility(0);
                if (FrsTabController.this.bUk() != null) {
                    FrsTabController.this.bUk().mI(false);
                }
                FrsTabController.this.hqU.bVt();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.hEL = false;
                    FrsTabController.this.hEH.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a hEY = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void bUB() {
            if (FrsTabController.this.hEH != null) {
                if (FrsTabController.this.hEH.getCurrentItem() == 0) {
                    FrsTabController.this.hEH.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.hEH.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean bUC() {
            if (FrsTabController.this.hEH.getCurrentItem() == 0) {
                if (FrsTabController.this.hEK && FrsTabController.this.hEL) {
                    FrsTabController.this.hEH.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.hEL) {
                    FrsTabController.this.hEH.setmDisallowSlip(true);
                }
                FrsTabController.this.hEH.setmDisallowSlip(true);
            } else {
                FrsTabController.this.hEH.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String hEE = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.hEB = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.hEB != null) {
            this.hEB.setContentView(R.layout.frs_base_layout);
            this.hEH = (FrsBaseViewPager) this.hEB.findViewById(R.id.frs_base_viewpager);
            this.hEI = new FragmentAdapter(this.hEB.getSupportFragmentManager());
            this.hEH.setAdapter(this.hEI);
            this.hEH.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.hEH.addOnPageChangeListener(this.hEX);
            this.hEH.setmDisallowSlip(true);
            this.hEH.setOnTouchEventListener(this.hEY);
            this.hEJ = (OvalActionButton) this.hEB.findViewById(R.id.frs_post_forum_button);
            this.hEJ.setIsCircle(true);
            this.hEJ.setHasShadow(false);
            this.hqZ = (FRSRefreshButton) this.hEB.findViewById(R.id.frs_refresh_forum_button);
            this.hEB.registerListener(this.hEV);
            this.hEB.registerListener(this.hEW);
            this.hEP.getHttpMessageListener().setPriority(-1);
            this.hEP.getSocketMessageListener().setPriority(-1);
            this.hEB.registerListener(this.hEQ);
            this.hES.setSelfListener(true);
            this.hEB.registerListener(this.hES);
            this.hER.setSelfListener(true);
            this.hEB.registerListener(this.hER);
            this.hEB.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.hEB.getIntent().getStringExtra("name");
                this.hqW = this.hEB.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.hqW = bundle.getInt("default_tab_id", 0);
            }
            an(bundle);
            this.hEI.notifyDataSetChanged();
            this.hEF = new ShareSuccessReplyToServerModel();
            this.hEB.registerListener(this.hEP);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.hqW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.hEI != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.hEI.EP(hEz);
                if (frsFragment == null) {
                    frsFragment = ao(bundle);
                }
                frsFragment.b(this.hEJ);
                frsFragment.a(this.hqZ);
                if (!hEz.equals(this.hEI.uR(0))) {
                    if (hEA.equals(this.hEI.uR(0))) {
                        this.hEI.uQ(0);
                    }
                    this.hEI.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZF() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.hEI != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.hEI.EP(hEA);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = bZG();
                }
                frsTabHostFragment.b(this.hEJ);
                frsTabHostFragment.b(this.hqZ);
                if (!hEA.equals(this.hEI.uR(0))) {
                    if (hEz.equals(this.hEI.uR(0))) {
                        this.hEI.uQ(0);
                    }
                    this.hEI.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment ao(Bundle bundle) {
        if (this.hqU == null) {
            this.hqU = new FrsFragment();
            this.hqU.setArguments(bundle);
            this.hqU.setBaseTag(hEz);
        }
        this.hqU.hnB = false;
        return this.hqU;
    }

    private FrsTabHostFragment bZG() {
        if (this.hEC == null) {
            this.hEC = new FrsTabHostFragment(this);
            this.hEC.setBaseTag(hEA);
            this.hEC.ue(this.hqW);
        }
        return this.hEC;
    }

    private FragmentManager getFragmentManager() {
        if (this.hEB != null) {
            return this.hEB.getSupportFragmentManager();
        }
        return null;
    }

    private void bZH() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.hqV != null && (themeColorInfo = this.hqV.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.hEJ.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z) {
        if (mVar != null && mVar.getForum() != null) {
            ForumData forum = mVar.getForum();
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_bawu_task_toast", 0) == 0 && !this.hEN) {
                this.hEN = true;
                e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.bZM();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.hEO && z) {
                j.a(this.hEB.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.hEO = true;
            }
            this.hqV = mVar;
            if (this.hEB.getIntent() == null || this.hEB.getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null) {
            }
            if (com.baidu.tbadk.core.util.v.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean cu = FrsTabController.this.cu(FrsTabController.this.hqV.getGameTabInfo());
                        if (cu) {
                            FrsTabController.this.hEI.notifyDataSetChanged();
                            if (cu && FrsTabController.this.hEC != null) {
                                FrsTabController.this.hEC.N(FrsTabController.this.hqU);
                                FrsTabController.this.hEC.a(FrsTabController.this.hqV, FrsTabController.this.hqT);
                            }
                        }
                        if (FrsTabController.this.hEB.isLoadingViewAttached()) {
                            FrsTabController.this.hEB.hideLoadingView(FrsTabController.this.hEB.findViewById(16908290));
                        }
                    }
                });
            } else if (bZL()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.hqU.hnB = true;
                        if (FrsTabController.this.hqU != null) {
                            bundle = FrsTabController.this.hqU.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.an(bundle);
                        FrsTabController.this.hEI.notifyDataSetChanged();
                        if (FrsTabController.this.hEB.isLoadingViewAttached()) {
                            FrsTabController.this.hEB.hideLoadingView(FrsTabController.this.hEB.findViewById(16908290));
                        }
                    }
                });
            }
            bZH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cu(List<FrsTabInfo> list) {
        if (this.hEB.isLoadingViewAttached()) {
            this.hEB.hideLoadingView(this.hEB.findViewById(16908290));
        }
        if (bZL()) {
            return false;
        }
        this.hqU.hnB = true;
        bZI();
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("frs_game_login_tip", false);
        }
        cv(list);
        return true;
    }

    private void bZI() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hEB.registerListener(1021074, this.hET);
    }

    private void cv(List<FrsTabInfo> list) {
        boolean z;
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ag)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(FrsTabController.this.hEE, true)) {
                            e.ld().post(FrsTabController.this.hEU);
                        }
                        ((ag) customResponsedMessage.getData()).b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7.1
                            @Override // com.baidu.tbadk.mainTab.b
                            public boolean isAvailable() {
                                return true;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", FrsTabController.this.hqU.getForumName());
                                bundle.putString("from", FrsTabController.this.hqU.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.hqU.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.hqV.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.hqV.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.hqV.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.hqV);
                                bundle.putSerializable("view_data", frsViewData);
                                frsSportsRecommendFragment.setArguments(bundle);
                                com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                                cVar.frag = frsSportsRecommendFragment;
                                cVar.type = 25;
                                cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                                return cVar;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public TbFragmentTabIndicator getTabIndicator(Context context) {
                                this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
                                this.mIndicator.setTextSize(2.0f);
                                return this.mIndicator;
                            }
                        });
                        FrsTabController.this.bZF();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.hEB.registerListener(customMessageListener);
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
            this.hqT = new ag(this.hEB.getActivity(), arrayList);
            if (bUk() != null) {
                this.hqT.setForumId(bUk().getForumId());
                this.hqT.setForumName(bUk().getForumName());
                if (bUk().bVu() != null && bUk().bVu().getForum() != null) {
                    ForumData forum = bUk().bVu().getForum();
                    this.hqT.setForumGameLabel(forum.getForumGameLabel());
                    this.hqT.CX(forum.getSpecialForumType());
                }
            }
            this.hqU.hnB = false;
            new d(this.hqU).a(this.hqT);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.hqT);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.hEB.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZJ() {
        if (this.hqT != null && !TextUtils.isEmpty(this.hqT.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.hqV.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bua;
        if ((fragment instanceof am) && this.hqV != null && this.hqV.getForum() != null && (bua = ((am) fragment).bua()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.hqV.getForum().getName(), 5, true, true) + this.hEB.getActivity().getString(R.string.forum));
            bua.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.hqU instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hqU.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a oO(int i) {
        if (this.hqU instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.hqU.oO(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.hqU instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hqU.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.hqU != null) {
            this.hqU.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!bZL()) {
            this.hqU.setPrimary(true);
        } else if (this.hEC != null) {
            Fragment currentFragment = this.hEC.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.hEG) {
            this.hEG = false;
            if (this.hqU != null) {
                this.hqU.refresh();
            }
        }
        if (this.hqV != null && this.hqV.getUserData() != null && this.hqV.getUserData().getNewGodData() != null) {
            if (this.hqV.getForum() != null) {
                v.bgH().setFid(this.hqV.getForum().getId());
            }
            v.bgH().b(2, this.hqV.getUserData().getNewGodData());
        }
    }

    public void onPause() {
        if (!bZL()) {
            this.hqU.setPrimary(false);
        } else if (this.hEC != null) {
            Fragment currentFragment = this.hEC.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
        v.bgH().removeCallbacks();
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.hEB);
        if (this.hqU != null) {
            this.hqU.onChangeSkinType(i);
        }
        if (this.hEC != null) {
            this.hEC.onChangeSkinType(i);
        }
        bZH();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (bZL() && this.hEC != null && this.hEC.bWy()) {
                this.hEC.bWM();
                UtilHelper.setNavigationBarBackground(this.hEB, this.hEC.bWH());
            } else if (this.hqU != null && this.hqU.isAdded()) {
                if (this.hqU.onKeyDown(i, keyEvent)) {
                    return true;
                }
                bZK();
            } else {
                return this.hEB.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.hqU != null && this.hqU.isAdded()) {
                return this.hqU.onKeyDown(i, keyEvent);
            }
        } else {
            return this.hEB.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZK() {
        if (this.hqX != this.hqW && bZL()) {
            this.hEC.setCurrentTab(this.hqW);
            if (uc(this.hqW) != 1) {
                this.hqU.mO(false);
            }
            this.hqX = this.hqW;
            a(this.hEC.getCurrentFragment(), this.hqW);
            return;
        }
        this.hqU.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!bZL()) {
            this.hqU.onActivityResult(i, i2, intent);
        } else if (this.hEC != null) {
            if (1 == this.hEC.getCurrentTabType()) {
                this.hqU.onActivityResult(i, i2, intent);
            } else {
                this.hEC.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.cUi().D(this.hEB.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.hEF != null) {
                        this.hEF.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void bas() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.hEB != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.hEB.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.cUi().D(this.hEB.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!bZL()) {
            return this.hqU.getVoiceManager();
        }
        if (this.hEC == null) {
            return null;
        }
        Fragment currentFragment = this.hEC.getCurrentFragment();
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
    public int ua(int i) {
        if (this.hqT == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.hqT.bUx());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.hqT.bUx().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int uc(int i) {
        if (this.hqT != null && i < com.baidu.tbadk.core.util.v.getCount(this.hqT.bUx())) {
            return this.hqT.bUx().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bUk() {
        return this.hqU;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bUl() {
        if (!bZL()) {
            if (this.hqU instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.hqU).bUl();
            }
        } else if (this.hEC == null) {
            return null;
        } else {
            Fragment currentFragment = this.hEC.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).bUl();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(q.hqq);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hEB.isLoadingViewAttached()) {
            this.hEB.hideLoadingView(this.hEB.findViewById(16908290));
        }
        if (this.hEU != null) {
            e.ld().removeCallbacks(this.hEU);
        }
        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(this.hEE, false);
        if (this.hEF != null) {
            this.hEF.cancelLoadData();
        }
        if (this.hqU != null && this.hqU.bUO() != null) {
            this.hqU.bUO().bZX();
        }
        if (this.hEM != null) {
            this.hEM.onDestroy();
        }
    }

    public FragmentTabHost bWK() {
        if (this.hEC == null) {
            return null;
        }
        return this.hEC.bWK();
    }

    public boolean bZL() {
        if (this.hEI == null) {
            return false;
        }
        return this.hEI.getItem(0) instanceof FrsTabHostFragment;
    }

    public void ue(int i) {
        this.hqW = i;
    }

    public void uO(int i) {
        this.hqX = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZM() {
        if (this.hEB != null) {
            if (this.hEM == null) {
                this.hEM = (NavigationBarCoverTip) this.hEB.findViewById(R.id.navigation_cover_tip);
            }
            if (this.hEM != null) {
                View inflate = View.inflate(this.hEB, R.layout.write_thread_share_guide, null);
                TextView textView = (TextView) inflate.findViewById(R.id.write_thread_success_tips);
                TextView textView2 = (TextView) inflate.findViewById(R.id.share_icon);
                if (TextUtils.isEmpty(this.mForumName)) {
                    textView.setText("吧主您好，本吧考核新制度上线啦");
                } else {
                    textView.setText(this.mForumName + "吧吧主您好，本吧考核新制度上线啦");
                }
                textView2.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.check_immediately));
                com.baidu.tbadk.core.util.am.setViewTextColor(textView, (int) R.color.cp_cont_a);
                com.baidu.tbadk.core.util.am.setViewTextColor(textView2, (int) R.color.cp_cont_a);
                com.baidu.tbadk.core.util.am.setBackgroundResource(textView2, R.drawable.share_now_bg);
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.hEM, R.color.cp_link_tip_a_alpha95);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new an("c13439").aUT();
                        if (FrsTabController.this.bUk() != null && !TextUtils.isEmpty(FrsTabController.this.bUk().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.hEB != null) {
                            if (FrsTabController.this.hEM != null) {
                                FrsTabController.this.hEM.hideTip();
                            }
                            ba.aVa().b(FrsTabController.this.hEB.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.bUk().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.hEM.a(this.hEB, inflate, 30000);
                new an("c13438").aUT();
                int i = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<BaseFragment> mFragments;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mFragments = new ArrayList(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v4.app.FragmentStatePagerAdapter
        /* renamed from: uP */
        public BaseFragment getItem(int i) {
            return (BaseFragment) com.baidu.tbadk.core.util.v.getItem(this.mFragments, i);
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
            return com.baidu.tbadk.core.util.v.add(this.mFragments, i, baseFragment);
        }

        public BaseFragment EP(String str) {
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

        public BaseFragment uQ(int i) {
            return (BaseFragment) com.baidu.tbadk.core.util.v.remove(this.mFragments, i);
        }

        public String uR(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!bZL()) {
            return this.hqU.getTbPageTag();
        }
        if (this.hEC != null) {
            if (1 == this.hEC.getCurrentTabType()) {
                return this.hqU.getTbPageTag();
            }
            Fragment currentFragment = this.hEC.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }
}
