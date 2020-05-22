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
    public static final String hDM = FrsFragment.class.getSimpleName();
    public static final String hDN = FrsTabHostFragment.class.getSimpleName();
    private FrsActivity hDO;
    private FrsTabHostFragment hDP;
    private ShareSuccessReplyToServerModel hDS;
    private FrsBaseViewPager hDU;
    private FragmentAdapter hDV;
    private OvalActionButton hDW;
    private boolean hDX;
    private boolean hDY;
    private NavigationBarCoverTip hDZ;
    private ag hqI;
    private FrsFragment hqJ;
    private m hqK;
    private int hqM;
    private FRSRefreshButton hqO;
    private String mForumName;
    private boolean hDQ = false;
    private final Handler mHandler = new Handler();
    private int hqL = 0;
    private boolean hDT = false;
    private boolean hEa = false;
    private boolean hEb = false;
    private com.baidu.adp.framework.listener.a hEc = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            if (!FrsTabController.this.hDQ && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (mVar != null) {
                    FrsTabController.this.hDQ = true;
                    FrsTabController.this.a(mVar, true);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.aOc().cX("2", mVar.getForum().getId());
                    }
                }
                if (mVar != null && mVar.getUserData() != null && mVar.getUserData().getNewGodData() != null) {
                    if (mVar.getForum() != null) {
                        v.bgG().setFid(mVar.getForum().getId());
                    }
                    v.bgG().b(2, mVar.getUserData().getNewGodData());
                }
            }
        }
    };
    private CustomMessageListener hEd = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.hDQ && FrsTabController.this.hqK == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false);
                }
            }
        }
    };
    private CustomMessageListener hEe = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.bZC();
        }
    };
    private CustomMessageListener hEf = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int tY;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    tY = FrsTabController.this.tY(9);
                    if (tY == -1) {
                        tY = FrsTabController.this.tY(2);
                    }
                } else {
                    tY = FrsTabController.this.tY(intValue);
                }
                if (tY != -1 && FrsTabController.this.bZD() && FrsTabController.this.hDP != null) {
                    FrsTabController.this.hDP.setCurrentTab(tY);
                    if (FrsTabController.this.ua(tY) != 1) {
                        FrsTabController.this.hqJ.mO(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener hEg = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!com.baidu.tbadk.core.util.v.isEmpty(newNotifyData) && FrsTabController.this.hDP != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.hqI.bUv().size(); i++) {
                                FragmentTabHost.b kV = FrsTabController.this.hDP.kV(i);
                                if (kV != null && kV.mType != 1 && kV.mType != FrsTabController.this.hDP.getCurrentTabType() && kV.mType == aVar.getTabId() && aVar.bZw() && kV.dLP.yy(String.valueOf(kV.mType)) != null) {
                                    kV.dLP.yy(String.valueOf(kV.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable hEh = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        @Override // java.lang.Runnable
        public void run() {
            e.ld().removeCallbacks(this);
            FrsTabController.this.bZB();
            e.ld().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.hDT = true;
            }
        }
    };
    private CustomMessageListener hEi = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.hDU != null && FrsTabController.this.hDV != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.hDX = aVar.bWP();
                FrsTabController.this.hDY = aVar.bWQ();
            }
        }
    };
    private CustomMessageListener hEj = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.hDU != null && FrsTabController.this.hDV != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.hDU.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener hEk = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.hDW.setVisibility(0);
                if (FrsTabController.this.bUi() != null) {
                    FrsTabController.this.bUi().mI(false);
                }
                FrsTabController.this.hqJ.bVr();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.hDY = false;
                    FrsTabController.this.hDU.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a hEl = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void bUz() {
            if (FrsTabController.this.hDU != null) {
                if (FrsTabController.this.hDU.getCurrentItem() == 0) {
                    FrsTabController.this.hDU.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.hDU.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean bUA() {
            if (FrsTabController.this.hDU.getCurrentItem() == 0) {
                if (FrsTabController.this.hDX && FrsTabController.this.hDY) {
                    FrsTabController.this.hDU.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.hDY) {
                    FrsTabController.this.hDU.setmDisallowSlip(true);
                }
                FrsTabController.this.hDU.setmDisallowSlip(true);
            } else {
                FrsTabController.this.hDU.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String hDR = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.hDO = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.hDO != null) {
            this.hDO.setContentView(R.layout.frs_base_layout);
            this.hDU = (FrsBaseViewPager) this.hDO.findViewById(R.id.frs_base_viewpager);
            this.hDV = new FragmentAdapter(this.hDO.getSupportFragmentManager());
            this.hDU.setAdapter(this.hDV);
            this.hDU.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.hDU.addOnPageChangeListener(this.hEk);
            this.hDU.setmDisallowSlip(true);
            this.hDU.setOnTouchEventListener(this.hEl);
            this.hDW = (OvalActionButton) this.hDO.findViewById(R.id.frs_post_forum_button);
            this.hDW.setIsCircle(true);
            this.hDW.setHasShadow(false);
            this.hqO = (FRSRefreshButton) this.hDO.findViewById(R.id.frs_refresh_forum_button);
            this.hDO.registerListener(this.hEi);
            this.hDO.registerListener(this.hEj);
            this.hEc.getHttpMessageListener().setPriority(-1);
            this.hEc.getSocketMessageListener().setPriority(-1);
            this.hDO.registerListener(this.hEd);
            this.hEf.setSelfListener(true);
            this.hDO.registerListener(this.hEf);
            this.hEe.setSelfListener(true);
            this.hDO.registerListener(this.hEe);
            this.hDO.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.hDO.getIntent().getStringExtra("name");
                this.hqL = this.hDO.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.hqL = bundle.getInt("default_tab_id", 0);
            }
            an(bundle);
            this.hDV.notifyDataSetChanged();
            this.hDS = new ShareSuccessReplyToServerModel();
            this.hDO.registerListener(this.hEc);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.hqL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.hDV != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.hDV.EP(hDM);
                if (frsFragment == null) {
                    frsFragment = ao(bundle);
                }
                frsFragment.b(this.hDW);
                frsFragment.a(this.hqO);
                if (!hDM.equals(this.hDV.uP(0))) {
                    if (hDN.equals(this.hDV.uP(0))) {
                        this.hDV.uO(0);
                    }
                    this.hDV.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZx() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.hDV != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.hDV.EP(hDN);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = bZy();
                }
                frsTabHostFragment.b(this.hDW);
                frsTabHostFragment.b(this.hqO);
                if (!hDN.equals(this.hDV.uP(0))) {
                    if (hDM.equals(this.hDV.uP(0))) {
                        this.hDV.uO(0);
                    }
                    this.hDV.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment ao(Bundle bundle) {
        if (this.hqJ == null) {
            this.hqJ = new FrsFragment();
            this.hqJ.setArguments(bundle);
            this.hqJ.setBaseTag(hDM);
        }
        this.hqJ.hnq = false;
        return this.hqJ;
    }

    private FrsTabHostFragment bZy() {
        if (this.hDP == null) {
            this.hDP = new FrsTabHostFragment(this);
            this.hDP.setBaseTag(hDN);
            this.hDP.uc(this.hqL);
        }
        return this.hDP;
    }

    private FragmentManager getFragmentManager() {
        if (this.hDO != null) {
            return this.hDO.getSupportFragmentManager();
        }
        return null;
    }

    private void bZz() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.hqK != null && (themeColorInfo = this.hqK.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.hDW.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z) {
        if (mVar != null && mVar.getForum() != null) {
            ForumData forum = mVar.getForum();
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_bawu_task_toast", 0) == 0 && !this.hEa) {
                this.hEa = true;
                e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.bZE();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.hEb && z) {
                j.a(this.hDO.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.hEb = true;
            }
            this.hqK = mVar;
            if (this.hDO.getIntent() == null || this.hDO.getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null) {
            }
            if (com.baidu.tbadk.core.util.v.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean ct = FrsTabController.this.ct(FrsTabController.this.hqK.getGameTabInfo());
                        if (ct) {
                            FrsTabController.this.hDV.notifyDataSetChanged();
                            if (ct && FrsTabController.this.hDP != null) {
                                FrsTabController.this.hDP.N(FrsTabController.this.hqJ);
                                FrsTabController.this.hDP.a(FrsTabController.this.hqK, FrsTabController.this.hqI);
                            }
                        }
                        if (FrsTabController.this.hDO.isLoadingViewAttached()) {
                            FrsTabController.this.hDO.hideLoadingView(FrsTabController.this.hDO.findViewById(16908290));
                        }
                    }
                });
            } else if (bZD()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.hqJ.hnq = true;
                        if (FrsTabController.this.hqJ != null) {
                            bundle = FrsTabController.this.hqJ.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.an(bundle);
                        FrsTabController.this.hDV.notifyDataSetChanged();
                        if (FrsTabController.this.hDO.isLoadingViewAttached()) {
                            FrsTabController.this.hDO.hideLoadingView(FrsTabController.this.hDO.findViewById(16908290));
                        }
                    }
                });
            }
            bZz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ct(List<FrsTabInfo> list) {
        if (this.hDO.isLoadingViewAttached()) {
            this.hDO.hideLoadingView(this.hDO.findViewById(16908290));
        }
        if (bZD()) {
            return false;
        }
        this.hqJ.hnq = true;
        bZA();
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("frs_game_login_tip", false);
        }
        cu(list);
        return true;
    }

    private void bZA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hDO.registerListener(1021074, this.hEg);
    }

    private void cu(List<FrsTabInfo> list) {
        boolean z;
        if (!com.baidu.tbadk.core.util.v.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ag)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(FrsTabController.this.hDR, true)) {
                            e.ld().post(FrsTabController.this.hEh);
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
                                bundle.putString("name", FrsTabController.this.hqJ.getForumName());
                                bundle.putString("from", FrsTabController.this.hqJ.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.hqJ.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.hqK.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.hqK.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.hqK.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.hqK);
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
                        FrsTabController.this.bZx();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.hDO.registerListener(customMessageListener);
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
            this.hqI = new ag(this.hDO.getActivity(), arrayList);
            if (bUi() != null) {
                this.hqI.setForumId(bUi().getForumId());
                this.hqI.setForumName(bUi().getForumName());
                if (bUi().bVs() != null && bUi().bVs().getForum() != null) {
                    ForumData forum = bUi().bVs().getForum();
                    this.hqI.setForumGameLabel(forum.getForumGameLabel());
                    this.hqI.CX(forum.getSpecialForumType());
                }
            }
            this.hqJ.hnq = false;
            new d(this.hqJ).a(this.hqI);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.hqI);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.hDO.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZB() {
        if (this.hqI != null && !TextUtils.isEmpty(this.hqI.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.hqK.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar btY;
        if ((fragment instanceof am) && this.hqK != null && this.hqK.getForum() != null && (btY = ((am) fragment).btY()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.hqK.getForum().getName(), 5, true, true) + this.hDO.getActivity().getString(R.string.forum));
            btY.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.hqJ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hqJ.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a oM(int i) {
        if (this.hqJ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.hqJ.oM(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.hqJ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hqJ.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.hqJ != null) {
            this.hqJ.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!bZD()) {
            this.hqJ.setPrimary(true);
        } else if (this.hDP != null) {
            Fragment currentFragment = this.hDP.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.hDT) {
            this.hDT = false;
            if (this.hqJ != null) {
                this.hqJ.refresh();
            }
        }
        if (this.hqK != null && this.hqK.getUserData() != null && this.hqK.getUserData().getNewGodData() != null) {
            if (this.hqK.getForum() != null) {
                v.bgG().setFid(this.hqK.getForum().getId());
            }
            v.bgG().b(2, this.hqK.getUserData().getNewGodData());
        }
    }

    public void onPause() {
        if (!bZD()) {
            this.hqJ.setPrimary(false);
        } else if (this.hDP != null) {
            Fragment currentFragment = this.hDP.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
        v.bgG().removeCallbacks();
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.hDO);
        if (this.hqJ != null) {
            this.hqJ.onChangeSkinType(i);
        }
        if (this.hDP != null) {
            this.hDP.onChangeSkinType(i);
        }
        bZz();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (bZD() && this.hDP != null && this.hDP.bWw()) {
                this.hDP.bWK();
                UtilHelper.setNavigationBarBackground(this.hDO, this.hDP.bWF());
            } else if (this.hqJ != null && this.hqJ.isAdded()) {
                if (this.hqJ.onKeyDown(i, keyEvent)) {
                    return true;
                }
                bZC();
            } else {
                return this.hDO.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.hqJ != null && this.hqJ.isAdded()) {
                return this.hqJ.onKeyDown(i, keyEvent);
            }
        } else {
            return this.hDO.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZC() {
        if (this.hqM != this.hqL && bZD()) {
            this.hDP.setCurrentTab(this.hqL);
            if (ua(this.hqL) != 1) {
                this.hqJ.mO(false);
            }
            this.hqM = this.hqL;
            a(this.hDP.getCurrentFragment(), this.hqL);
            return;
        }
        this.hqJ.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!bZD()) {
            this.hqJ.onActivityResult(i, i2, intent);
        } else if (this.hDP != null) {
            if (1 == this.hDP.getCurrentTabType()) {
                this.hqJ.onActivityResult(i, i2, intent);
            } else {
                this.hDP.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.cTS().D(this.hDO.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.hDS != null) {
                        this.hDS.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void bar() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.hDO != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.hDO.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.cTS().D(this.hDO.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!bZD()) {
            return this.hqJ.getVoiceManager();
        }
        if (this.hDP == null) {
            return null;
        }
        Fragment currentFragment = this.hDP.getCurrentFragment();
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
    public int tY(int i) {
        if (this.hqI == null) {
            return -1;
        }
        int count = com.baidu.tbadk.core.util.v.getCount(this.hqI.bUv());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.hqI.bUv().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ua(int i) {
        if (this.hqI != null && i < com.baidu.tbadk.core.util.v.getCount(this.hqI.bUv())) {
            return this.hqI.bUv().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bUi() {
        return this.hqJ;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bUj() {
        if (!bZD()) {
            if (this.hqJ instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.hqJ).bUj();
            }
        } else if (this.hDP == null) {
            return null;
        } else {
            Fragment currentFragment = this.hDP.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).bUj();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(q.hqf);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hDO.isLoadingViewAttached()) {
            this.hDO.hideLoadingView(this.hDO.findViewById(16908290));
        }
        if (this.hEh != null) {
            e.ld().removeCallbacks(this.hEh);
        }
        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(this.hDR, false);
        if (this.hDS != null) {
            this.hDS.cancelLoadData();
        }
        if (this.hqJ != null && this.hqJ.bUM() != null) {
            this.hqJ.bUM().bZP();
        }
        if (this.hDZ != null) {
            this.hDZ.onDestroy();
        }
    }

    public FragmentTabHost bWI() {
        if (this.hDP == null) {
            return null;
        }
        return this.hDP.bWI();
    }

    public boolean bZD() {
        if (this.hDV == null) {
            return false;
        }
        return this.hDV.getItem(0) instanceof FrsTabHostFragment;
    }

    public void uc(int i) {
        this.hqL = i;
    }

    public void uM(int i) {
        this.hqM = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZE() {
        if (this.hDO != null) {
            if (this.hDZ == null) {
                this.hDZ = (NavigationBarCoverTip) this.hDO.findViewById(R.id.navigation_cover_tip);
            }
            if (this.hDZ != null) {
                View inflate = View.inflate(this.hDO, R.layout.write_thread_share_guide, null);
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
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.hDZ, R.color.cp_link_tip_a_alpha95);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new an("c13439").aUS();
                        if (FrsTabController.this.bUi() != null && !TextUtils.isEmpty(FrsTabController.this.bUi().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.hDO != null) {
                            if (FrsTabController.this.hDZ != null) {
                                FrsTabController.this.hDZ.hideTip();
                            }
                            ba.aUZ().b(FrsTabController.this.hDO.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.bUi().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.hDZ.a(this.hDO, inflate, 30000);
                new an("c13438").aUS();
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
        /* renamed from: uN */
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

        public BaseFragment uO(int i) {
            return (BaseFragment) com.baidu.tbadk.core.util.v.remove(this.mFragments, i);
        }

        public String uP(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!bZD()) {
            return this.hqJ.getTbPageTag();
        }
        if (this.hDP != null) {
            if (1 == this.hDP.getCurrentTabType()) {
                return this.hqJ.getTbPageTag();
            }
            Fragment currentFragment = this.hDP.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }
}
