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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.task.TbHttpMessageTask;
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
    public static final String hoS = FrsFragment.class.getSimpleName();
    public static final String hoT = FrsTabHostFragment.class.getSimpleName();
    private ag hbO;
    private FrsFragment hbP;
    private m hbQ;
    private int hbS;
    private FRSRefreshButton hbU;
    private FrsActivity hoU;
    private FrsTabHostFragment hoV;
    private ShareSuccessReplyToServerModel hoY;
    private FrsBaseViewPager hpa;
    private FragmentAdapter hpb;
    private OvalActionButton hpc;
    private boolean hpd;
    private boolean hpe;
    private NavigationBarCoverTip hpf;
    private String mForumName;
    private boolean hoW = false;
    private final Handler mHandler = new Handler();
    private int hbR = 0;
    private boolean hoZ = false;
    private boolean hpg = false;
    private boolean hph = false;
    private com.baidu.adp.framework.listener.a hpi = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            if (!FrsTabController.this.hoW && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (mVar != null) {
                    FrsTabController.this.hoW = true;
                    FrsTabController.this.a(mVar, true);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.aIq().cy("2", mVar.getForum().getId());
                    }
                }
            }
        }
    };
    private CustomMessageListener hpj = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.hoW && FrsTabController.this.hbQ == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false);
                }
            }
        }
    };
    private CustomMessageListener hpk = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.bTi();
        }
    };
    private CustomMessageListener hpl = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int tt;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    tt = FrsTabController.this.tt(9);
                    if (tt == -1) {
                        tt = FrsTabController.this.tt(2);
                    }
                } else {
                    tt = FrsTabController.this.tt(intValue);
                }
                if (tt != -1 && FrsTabController.this.bTj() && FrsTabController.this.hoV != null) {
                    FrsTabController.this.hoV.setCurrentTab(tt);
                    if (FrsTabController.this.tv(tt) != 1) {
                        FrsTabController.this.hbP.mt(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener hpm = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.isEmpty(newNotifyData) && FrsTabController.this.hoV != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.hbO.bOb().size(); i++) {
                                FragmentTabHost.b kv = FrsTabController.this.hoV.kv(i);
                                if (kv != null && kv.mType != 1 && kv.mType != FrsTabController.this.hoV.getCurrentTabType() && kv.mType == aVar.getTabId() && aVar.bTc() && kv.dxF.wP(String.valueOf(kv.mType)) != null) {
                                    kv.dxF.wP(String.valueOf(kv.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable hpn = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        @Override // java.lang.Runnable
        public void run() {
            e.lb().removeCallbacks(this);
            FrsTabController.this.bTh();
            e.lb().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.hoZ = true;
            }
        }
    };
    private CustomMessageListener hpo = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.hpa != null && FrsTabController.this.hpb != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.hpd = aVar.bQu();
                FrsTabController.this.hpe = aVar.bQv();
            }
        }
    };
    private CustomMessageListener hpp = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.hpa != null && FrsTabController.this.hpb != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.hpa.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener hpq = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.hpc.setVisibility(0);
                if (FrsTabController.this.bNO() != null) {
                    FrsTabController.this.bNO().mn(false);
                }
                FrsTabController.this.hbP.bOX();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.hpe = false;
                    FrsTabController.this.hpa.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a hpr = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void bOf() {
            if (FrsTabController.this.hpa != null) {
                if (FrsTabController.this.hpa.getCurrentItem() == 0) {
                    FrsTabController.this.hpa.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.hpa.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean bOg() {
            if (FrsTabController.this.hpa.getCurrentItem() == 0) {
                if (FrsTabController.this.hpd && FrsTabController.this.hpe) {
                    FrsTabController.this.hpa.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.hpe) {
                    FrsTabController.this.hpa.setmDisallowSlip(true);
                }
                FrsTabController.this.hpa.setmDisallowSlip(true);
            } else {
                FrsTabController.this.hpa.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String hoX = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.hoU = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.hoU != null) {
            this.hoU.setContentView(R.layout.frs_base_layout);
            this.hpa = (FrsBaseViewPager) this.hoU.findViewById(R.id.frs_base_viewpager);
            this.hpb = new FragmentAdapter(this.hoU.getSupportFragmentManager());
            this.hpa.setAdapter(this.hpb);
            this.hpa.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.hpa.addOnPageChangeListener(this.hpq);
            this.hpa.setmDisallowSlip(true);
            this.hpa.setOnTouchEventListener(this.hpr);
            this.hpc = (OvalActionButton) this.hoU.findViewById(R.id.frs_post_forum_button);
            this.hpc.setIsCircle(true);
            this.hpc.setHasShadow(false);
            this.hbU = (FRSRefreshButton) this.hoU.findViewById(R.id.frs_refresh_forum_button);
            this.hoU.registerListener(this.hpo);
            this.hoU.registerListener(this.hpp);
            this.hpi.getHttpMessageListener().setPriority(-1);
            this.hpi.getSocketMessageListener().setPriority(-1);
            this.hoU.registerListener(this.hpj);
            this.hpl.setSelfListener(true);
            this.hoU.registerListener(this.hpl);
            this.hpk.setSelfListener(true);
            this.hoU.registerListener(this.hpk);
            this.hoU.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.hoU.getIntent().getStringExtra("name");
                this.hbR = this.hoU.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.hbR = bundle.getInt("default_tab_id", 0);
            }
            ah(bundle);
            this.hpb.notifyDataSetChanged();
            this.hoY = new ShareSuccessReplyToServerModel();
            this.hoU.registerListener(this.hpi);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.hbR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.hpb != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.hpb.Dd(hoS);
                if (frsFragment == null) {
                    frsFragment = ai(bundle);
                }
                frsFragment.b(this.hpc);
                frsFragment.a(this.hbU);
                if (!hoS.equals(this.hpb.uk(0))) {
                    if (hoT.equals(this.hpb.uk(0))) {
                        this.hpb.uj(0);
                    }
                    this.hpb.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTd() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.hpb != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.hpb.Dd(hoT);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = bTe();
                }
                frsTabHostFragment.b(this.hpc);
                frsTabHostFragment.b(this.hbU);
                if (!hoT.equals(this.hpb.uk(0))) {
                    if (hoS.equals(this.hpb.uk(0))) {
                        this.hpb.uj(0);
                    }
                    this.hpb.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment ai(Bundle bundle) {
        if (this.hbP == null) {
            this.hbP = new FrsFragment();
            this.hbP.setArguments(bundle);
            this.hbP.setBaseTag(hoS);
        }
        this.hbP.gYy = false;
        return this.hbP;
    }

    private FrsTabHostFragment bTe() {
        if (this.hoV == null) {
            this.hoV = new FrsTabHostFragment(this);
            this.hoV.setBaseTag(hoT);
            this.hoV.tx(this.hbR);
        }
        return this.hoV;
    }

    private FragmentManager getFragmentManager() {
        if (this.hoU != null) {
            return this.hoU.getSupportFragmentManager();
        }
        return null;
    }

    private void bTf() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.hbQ != null && (themeColorInfo = this.hbQ.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.hpc.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z) {
        if (mVar != null && mVar.getForum() != null) {
            ForumData forum = mVar.getForum();
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.aNV().getInt("key_bawu_task_toast", 0) == 0 && !this.hpg) {
                this.hpg = true;
                e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.bTk();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.hph && z) {
                j.a(this.hoU.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.hph = true;
            }
            this.hbQ = mVar;
            if (this.hoU.getIntent() == null || this.hoU.getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null) {
            }
            if (v.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean cw = FrsTabController.this.cw(FrsTabController.this.hbQ.getGameTabInfo());
                        if (cw) {
                            FrsTabController.this.hpb.notifyDataSetChanged();
                            if (cw && FrsTabController.this.hoV != null) {
                                FrsTabController.this.hoV.L(FrsTabController.this.hbP);
                                FrsTabController.this.hoV.a(FrsTabController.this.hbQ, FrsTabController.this.hbO);
                            }
                        }
                        if (FrsTabController.this.hoU.isLoadingViewAttached()) {
                            FrsTabController.this.hoU.hideLoadingView(FrsTabController.this.hoU.findViewById(16908290));
                        }
                    }
                });
            } else if (bTj()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.hbP.gYy = true;
                        if (FrsTabController.this.hbP != null) {
                            bundle = FrsTabController.this.hbP.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.ah(bundle);
                        FrsTabController.this.hpb.notifyDataSetChanged();
                        if (FrsTabController.this.hoU.isLoadingViewAttached()) {
                            FrsTabController.this.hoU.hideLoadingView(FrsTabController.this.hoU.findViewById(16908290));
                        }
                    }
                });
            }
            bTf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cw(List<FrsTabInfo> list) {
        if (this.hoU.isLoadingViewAttached()) {
            this.hoU.hideLoadingView(this.hoU.findViewById(16908290));
        }
        if (bTj()) {
            return false;
        }
        this.hbP.gYy = true;
        bTg();
        if (com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("frs_game_login_tip", false);
        }
        cx(list);
        return true;
    }

    private void bTg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hoU.registerListener(1021074, this.hpm);
    }

    private void cx(List<FrsTabInfo> list) {
        boolean z;
        if (!v.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ag)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(FrsTabController.this.hoX, true)) {
                            e.lb().post(FrsTabController.this.hpn);
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
                                bundle.putString("name", FrsTabController.this.hbP.getForumName());
                                bundle.putString("from", FrsTabController.this.hbP.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.hbP.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.hbQ.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.hbQ.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.hbQ.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.hbQ);
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
                        FrsTabController.this.bTd();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.hoU.registerListener(customMessageListener);
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
            this.hbO = new ag(this.hoU.getActivity(), arrayList);
            if (bNO() != null) {
                this.hbO.setForumId(bNO().getForumId());
                this.hbO.setForumName(bNO().getForumName());
                if (bNO().bOY() != null && bNO().bOY().getForum() != null) {
                    ForumData forum = bNO().bOY().getForum();
                    this.hbO.setForumGameLabel(forum.getForumGameLabel());
                    this.hbO.Bl(forum.getSpecialForumType());
                }
            }
            this.hbP.gYy = false;
            new d(this.hbP).a(this.hbO);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.hbO);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.hoU.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTh() {
        if (this.hbO != null && !TextUtils.isEmpty(this.hbO.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.hbQ.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar boh;
        if ((fragment instanceof am) && this.hbQ != null && this.hbQ.getForum() != null && (boh = ((am) fragment).boh()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.hbQ.getForum().getName(), 5, true, true) + this.hoU.getActivity().getString(R.string.forum));
            boh.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.hbP instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hbP.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a oh(int i) {
        if (this.hbP instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.hbP.oh(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.hbP instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hbP.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.hbP != null) {
            this.hbP.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!bTj()) {
            this.hbP.setPrimary(true);
        } else if (this.hoV != null) {
            Fragment currentFragment = this.hoV.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.hoZ) {
            this.hoZ = false;
            if (this.hbP != null) {
                this.hbP.refresh();
            }
        }
    }

    public void onPause() {
        if (!bTj()) {
            this.hbP.setPrimary(false);
        } else if (this.hoV != null) {
            Fragment currentFragment = this.hoV.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.hoU);
        if (this.hbP != null) {
            this.hbP.onChangeSkinType(i);
        }
        if (this.hoV != null) {
            this.hoV.onChangeSkinType(i);
        }
        bTf();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (bTj() && this.hoV != null && this.hoV.bQb()) {
                this.hoV.bQp();
                UtilHelper.setNavigationBarBackground(this.hoU, this.hoV.bQk());
            } else if (this.hbP != null && this.hbP.isAdded()) {
                if (this.hbP.onKeyDown(i, keyEvent)) {
                    return true;
                }
                bTi();
            } else {
                return this.hoU.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.hbP != null && this.hbP.isAdded()) {
                return this.hbP.onKeyDown(i, keyEvent);
            }
        } else {
            return this.hoU.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTi() {
        if (this.hbS != this.hbR && bTj()) {
            this.hoV.setCurrentTab(this.hbR);
            if (tv(this.hbR) != 1) {
                this.hbP.mt(false);
            }
            this.hbS = this.hbR;
            a(this.hoV.getCurrentFragment(), this.hbR);
            return;
        }
        this.hbP.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!bTj()) {
            this.hbP.onActivityResult(i, i2, intent);
        } else if (this.hoV != null) {
            if (1 == this.hoV.getCurrentTabType()) {
                this.hbP.onActivityResult(i, i2, intent);
            } else {
                this.hoV.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.cMU().D(this.hoU.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.hoY != null) {
                        this.hoY.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void aUm() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.hoU != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.hoU.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.cMU().D(this.hoU.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!bTj()) {
            return this.hbP.getVoiceManager();
        }
        if (this.hoV == null) {
            return null;
        }
        Fragment currentFragment = this.hoV.getCurrentFragment();
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
    public int tt(int i) {
        if (this.hbO == null) {
            return -1;
        }
        int count = v.getCount(this.hbO.bOb());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.hbO.bOb().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int tv(int i) {
        if (this.hbO != null && i < v.getCount(this.hbO.bOb())) {
            return this.hbO.bOb().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bNO() {
        return this.hbP;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bNP() {
        if (!bTj()) {
            if (this.hbP instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.hbP).bNP();
            }
        } else if (this.hoV == null) {
            return null;
        } else {
            Fragment currentFragment = this.hoV.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).bNP();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(q.hbl);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hoU.isLoadingViewAttached()) {
            this.hoU.hideLoadingView(this.hoU.findViewById(16908290));
        }
        if (this.hpn != null) {
            e.lb().removeCallbacks(this.hpn);
        }
        com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(this.hoX, false);
        if (this.hoY != null) {
            this.hoY.cancelLoadData();
        }
        if (this.hbP != null && this.hbP.bOs() != null) {
            this.hbP.bOs().aqT();
        }
        if (this.hpf != null) {
            this.hpf.onDestroy();
        }
    }

    public FragmentTabHost bQn() {
        if (this.hoV == null) {
            return null;
        }
        return this.hoV.bQn();
    }

    public boolean bTj() {
        if (this.hpb == null) {
            return false;
        }
        return this.hpb.getItem(0) instanceof FrsTabHostFragment;
    }

    public void tx(int i) {
        this.hbR = i;
    }

    public void uh(int i) {
        this.hbS = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTk() {
        if (this.hoU != null) {
            if (this.hpf == null) {
                this.hpf = (NavigationBarCoverTip) this.hoU.findViewById(R.id.navigation_cover_tip);
            }
            if (this.hpf != null) {
                View inflate = View.inflate(this.hoU, R.layout.write_thread_share_guide, null);
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
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.hpf, R.color.cp_link_tip_a_alpha95);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new an("c13439").aOR();
                        if (FrsTabController.this.bNO() != null && !TextUtils.isEmpty(FrsTabController.this.bNO().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.hoU != null) {
                            if (FrsTabController.this.hpf != null) {
                                FrsTabController.this.hpf.hideTip();
                            }
                            ba.aOY().b(FrsTabController.this.hoU.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.bNO().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.aNV().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.hpf.a(this.hoU, inflate, 30000);
                new an("c13438").aOR();
                int i = com.baidu.tbadk.core.sharedPref.b.aNV().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.aNV().putInt("key_bawu_task_toast", i + 1);
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
        /* renamed from: ui */
        public BaseFragment getItem(int i) {
            return (BaseFragment) v.getItem(this.mFragments, i);
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
            return v.add(this.mFragments, i, baseFragment);
        }

        public BaseFragment Dd(String str) {
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

        public BaseFragment uj(int i) {
            return (BaseFragment) v.remove(this.mFragments, i);
        }

        public String uk(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!bTj()) {
            return this.hbP.getTbPageTag();
        }
        if (this.hoV != null) {
            if (1 == this.hoV.getCurrentTabType()) {
                return this.hbP.getTbPageTag();
            }
            Fragment currentFragment = this.hoV.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }
}
