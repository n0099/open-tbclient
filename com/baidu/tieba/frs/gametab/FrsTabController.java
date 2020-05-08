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
    public static final String hoY = FrsFragment.class.getSimpleName();
    public static final String hoZ = FrsTabHostFragment.class.getSimpleName();
    private ag hbU;
    private FrsFragment hbV;
    private m hbW;
    private int hbY;
    private FRSRefreshButton hca;
    private FrsActivity hpa;
    private FrsTabHostFragment hpb;
    private ShareSuccessReplyToServerModel hpe;
    private FrsBaseViewPager hpg;
    private FragmentAdapter hph;
    private OvalActionButton hpi;
    private boolean hpj;
    private boolean hpk;
    private NavigationBarCoverTip hpl;
    private String mForumName;
    private boolean hpc = false;
    private final Handler mHandler = new Handler();
    private int hbX = 0;
    private boolean hpf = false;
    private boolean hpm = false;
    private boolean hpn = false;
    private com.baidu.adp.framework.listener.a hpo = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            if (!FrsTabController.this.hpc && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (mVar != null) {
                    FrsTabController.this.hpc = true;
                    FrsTabController.this.a(mVar, true);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.aIo().cy("2", mVar.getForum().getId());
                    }
                }
            }
        }
    };
    private CustomMessageListener hpp = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.hpc && FrsTabController.this.hbW == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.a(mVar, false);
                }
            }
        }
    };
    private CustomMessageListener hpq = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.bTg();
        }
    };
    private CustomMessageListener hpr = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
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
                if (tt != -1 && FrsTabController.this.bTh() && FrsTabController.this.hpb != null) {
                    FrsTabController.this.hpb.setCurrentTab(tt);
                    if (FrsTabController.this.tv(tt) != 1) {
                        FrsTabController.this.hbV.mt(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener hps = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.isEmpty(newNotifyData) && FrsTabController.this.hpb != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.hbU.bNZ().size(); i++) {
                                FragmentTabHost.b kv = FrsTabController.this.hpb.kv(i);
                                if (kv != null && kv.mType != 1 && kv.mType != FrsTabController.this.hpb.getCurrentTabType() && kv.mType == aVar.getTabId() && aVar.bTa() && kv.dxJ.wS(String.valueOf(kv.mType)) != null) {
                                    kv.dxJ.wS(String.valueOf(kv.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable hpt = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        @Override // java.lang.Runnable
        public void run() {
            e.lb().removeCallbacks(this);
            FrsTabController.this.bTf();
            e.lb().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.hpf = true;
            }
        }
    };
    private CustomMessageListener hpu = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.hpg != null && FrsTabController.this.hph != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.hpj = aVar.bQs();
                FrsTabController.this.hpk = aVar.bQt();
            }
        }
    };
    private CustomMessageListener hpv = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.hpg != null && FrsTabController.this.hph != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.hpg.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener hpw = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 1) {
                FrsTabController.this.hpi.setVisibility(0);
                if (FrsTabController.this.bNM() != null) {
                    FrsTabController.this.bNM().mn(false);
                }
                FrsTabController.this.hbV.bOV();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.hpk = false;
                    FrsTabController.this.hpg.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a hpx = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void bOd() {
            if (FrsTabController.this.hpg != null) {
                if (FrsTabController.this.hpg.getCurrentItem() == 0) {
                    FrsTabController.this.hpg.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.hpg.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean bOe() {
            if (FrsTabController.this.hpg.getCurrentItem() == 0) {
                if (FrsTabController.this.hpj && FrsTabController.this.hpk) {
                    FrsTabController.this.hpg.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.hpk) {
                    FrsTabController.this.hpg.setmDisallowSlip(true);
                }
                FrsTabController.this.hpg.setmDisallowSlip(true);
            } else {
                FrsTabController.this.hpg.setmDisallowSlip(true);
            }
            return true;
        }
    };
    private String hpd = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    public FrsTabController(FrsActivity frsActivity) {
        this.hpa = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.hpa != null) {
            this.hpa.setContentView(R.layout.frs_base_layout);
            this.hpg = (FrsBaseViewPager) this.hpa.findViewById(R.id.frs_base_viewpager);
            this.hph = new FragmentAdapter(this.hpa.getSupportFragmentManager());
            this.hpg.setAdapter(this.hph);
            this.hpg.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.hpg.addOnPageChangeListener(this.hpw);
            this.hpg.setmDisallowSlip(true);
            this.hpg.setOnTouchEventListener(this.hpx);
            this.hpi = (OvalActionButton) this.hpa.findViewById(R.id.frs_post_forum_button);
            this.hpi.setIsCircle(true);
            this.hpi.setHasShadow(false);
            this.hca = (FRSRefreshButton) this.hpa.findViewById(R.id.frs_refresh_forum_button);
            this.hpa.registerListener(this.hpu);
            this.hpa.registerListener(this.hpv);
            this.hpo.getHttpMessageListener().setPriority(-1);
            this.hpo.getSocketMessageListener().setPriority(-1);
            this.hpa.registerListener(this.hpp);
            this.hpr.setSelfListener(true);
            this.hpa.registerListener(this.hpr);
            this.hpq.setSelfListener(true);
            this.hpa.registerListener(this.hpq);
            this.hpa.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.hpa.getIntent().getStringExtra("name");
                this.hbX = this.hpa.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.hbX = bundle.getInt("default_tab_id", 0);
            }
            ah(bundle);
            this.hph.notifyDataSetChanged();
            this.hpe = new ShareSuccessReplyToServerModel();
            this.hpa.registerListener(this.hpo);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.hbX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.hph != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.hph.Dg(hoY);
                if (frsFragment == null) {
                    frsFragment = ai(bundle);
                }
                frsFragment.b(this.hpi);
                frsFragment.a(this.hca);
                if (!hoY.equals(this.hph.uk(0))) {
                    if (hoZ.equals(this.hph.uk(0))) {
                        this.hph.uj(0);
                    }
                    this.hph.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTb() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.hph != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.hph.Dg(hoZ);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = bTc();
                }
                frsTabHostFragment.b(this.hpi);
                frsTabHostFragment.b(this.hca);
                if (!hoZ.equals(this.hph.uk(0))) {
                    if (hoY.equals(this.hph.uk(0))) {
                        this.hph.uj(0);
                    }
                    this.hph.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment ai(Bundle bundle) {
        if (this.hbV == null) {
            this.hbV = new FrsFragment();
            this.hbV.setArguments(bundle);
            this.hbV.setBaseTag(hoY);
        }
        this.hbV.gYE = false;
        return this.hbV;
    }

    private FrsTabHostFragment bTc() {
        if (this.hpb == null) {
            this.hpb = new FrsTabHostFragment(this);
            this.hpb.setBaseTag(hoZ);
            this.hpb.tx(this.hbX);
        }
        return this.hpb;
    }

    private FragmentManager getFragmentManager() {
        if (this.hpa != null) {
            return this.hpa.getSupportFragmentManager();
        }
        return null;
    }

    private void bTd() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.hbW != null && (themeColorInfo = this.hbW.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.hpi.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, boolean z) {
        if (mVar != null && mVar.getForum() != null) {
            ForumData forum = mVar.getForum();
            if (forum.getIsShowBawuTask() && com.baidu.tbadk.core.sharedPref.b.aNT().getInt("key_bawu_task_toast", 0) == 0 && !this.hpm) {
                this.hpm = true;
                e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.bTi();
                    }
                }, 30000L);
            }
            if (mVar.bazhuExam != null && !this.hpn && z) {
                j.a(this.hpa.getPageContext(), mVar.bazhuExam, forum.getId(), forum.getName());
                this.hpn = true;
            }
            this.hbW = mVar;
            if (this.hpa.getIntent() == null || this.hpa.getIntent().getParcelableExtra(IntentConfig.KEY_URI) != null) {
            }
            if (v.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean cw = FrsTabController.this.cw(FrsTabController.this.hbW.getGameTabInfo());
                        if (cw) {
                            FrsTabController.this.hph.notifyDataSetChanged();
                            if (cw && FrsTabController.this.hpb != null) {
                                FrsTabController.this.hpb.L(FrsTabController.this.hbV);
                                FrsTabController.this.hpb.a(FrsTabController.this.hbW, FrsTabController.this.hbU);
                            }
                        }
                        if (FrsTabController.this.hpa.isLoadingViewAttached()) {
                            FrsTabController.this.hpa.hideLoadingView(FrsTabController.this.hpa.findViewById(16908290));
                        }
                    }
                });
            } else if (bTh()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.hbV.gYE = true;
                        if (FrsTabController.this.hbV != null) {
                            bundle = FrsTabController.this.hbV.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.ah(bundle);
                        FrsTabController.this.hph.notifyDataSetChanged();
                        if (FrsTabController.this.hpa.isLoadingViewAttached()) {
                            FrsTabController.this.hpa.hideLoadingView(FrsTabController.this.hpa.findViewById(16908290));
                        }
                    }
                });
            }
            bTd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cw(List<FrsTabInfo> list) {
        if (this.hpa.isLoadingViewAttached()) {
            this.hpa.hideLoadingView(this.hpa.findViewById(16908290));
        }
        if (bTh()) {
            return false;
        }
        this.hbV.gYE = true;
        bTe();
        if (com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean("frs_game_login_tip", false);
        }
        cx(list);
        return true;
    }

    private void bTe() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hpa.registerListener(1021074, this.hps);
    }

    private void cx(List<FrsTabInfo> list) {
        boolean z;
        if (!v.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ag)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(FrsTabController.this.hpd, true)) {
                            e.lb().post(FrsTabController.this.hpt);
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
                                bundle.putString("name", FrsTabController.this.hbV.getForumName());
                                bundle.putString("from", FrsTabController.this.hbV.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.hbV.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.hbW.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.hbW.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.hbW.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.hbW);
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
                        FrsTabController.this.bTb();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.hpa.registerListener(customMessageListener);
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
            this.hbU = new ag(this.hpa.getActivity(), arrayList);
            if (bNM() != null) {
                this.hbU.setForumId(bNM().getForumId());
                this.hbU.setForumName(bNM().getForumName());
                if (bNM().bOW() != null && bNM().bOW().getForum() != null) {
                    ForumData forum = bNM().bOW().getForum();
                    this.hbU.setForumGameLabel(forum.getForumGameLabel());
                    this.hbU.Bo(forum.getSpecialForumType());
                }
            }
            this.hbV.gYE = false;
            new d(this.hbV).a(this.hbU);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.hbU);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.hpa.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTf() {
        if (this.hbU != null && !TextUtils.isEmpty(this.hbU.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.hbW.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bof;
        if ((fragment instanceof am) && this.hbW != null && this.hbW.getForum() != null && (bof = ((am) fragment).bof()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.hbW.getForum().getName(), 5, true, true) + this.hpa.getActivity().getString(R.string.forum));
            bof.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.hbV instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hbV.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a oh(int i) {
        if (this.hbV instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.hbV.oh(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.hbV instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hbV.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.hbV != null) {
            this.hbV.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!bTh()) {
            this.hbV.setPrimary(true);
        } else if (this.hpb != null) {
            Fragment currentFragment = this.hpb.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.hpf) {
            this.hpf = false;
            if (this.hbV != null) {
                this.hbV.refresh();
            }
        }
    }

    public void onPause() {
        if (!bTh()) {
            this.hbV.setPrimary(false);
        } else if (this.hpb != null) {
            Fragment currentFragment = this.hpb.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.hpa);
        if (this.hbV != null) {
            this.hbV.onChangeSkinType(i);
        }
        if (this.hpb != null) {
            this.hpb.onChangeSkinType(i);
        }
        bTd();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (bTh() && this.hpb != null && this.hpb.bPZ()) {
                this.hpb.bQn();
                UtilHelper.setNavigationBarBackground(this.hpa, this.hpb.bQi());
            } else if (this.hbV != null && this.hbV.isAdded()) {
                if (this.hbV.onKeyDown(i, keyEvent)) {
                    return true;
                }
                bTg();
            } else {
                return this.hpa.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.hbV != null && this.hbV.isAdded()) {
                return this.hbV.onKeyDown(i, keyEvent);
            }
        } else {
            return this.hpa.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTg() {
        if (this.hbY != this.hbX && bTh()) {
            this.hpb.setCurrentTab(this.hbX);
            if (tv(this.hbX) != 1) {
                this.hbV.mt(false);
            }
            this.hbY = this.hbX;
            a(this.hpb.getCurrentFragment(), this.hbX);
            return;
        }
        this.hbV.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!bTh()) {
            this.hbV.onActivityResult(i, i2, intent);
        } else if (this.hpb != null) {
            if (1 == this.hpb.getCurrentTabType()) {
                this.hbV.onActivityResult(i, i2, intent);
            } else {
                this.hpb.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.cMR().D(this.hpa.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.hpe != null) {
                        this.hpe.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void aUk() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.hpa != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.hpa.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.cMR().D(this.hpa.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!bTh()) {
            return this.hbV.getVoiceManager();
        }
        if (this.hpb == null) {
            return null;
        }
        Fragment currentFragment = this.hpb.getCurrentFragment();
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
        if (this.hbU == null) {
            return -1;
        }
        int count = v.getCount(this.hbU.bNZ());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.hbU.bNZ().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int tv(int i) {
        if (this.hbU != null && i < v.getCount(this.hbU.bNZ())) {
            return this.hbU.bNZ().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bNM() {
        return this.hbV;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bNN() {
        if (!bTh()) {
            if (this.hbV instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.hbV).bNN();
            }
        } else if (this.hpb == null) {
            return null;
        } else {
            Fragment currentFragment = this.hpb.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).bNN();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(q.hbr);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hpa.isLoadingViewAttached()) {
            this.hpa.hideLoadingView(this.hpa.findViewById(16908290));
        }
        if (this.hpt != null) {
            e.lb().removeCallbacks(this.hpt);
        }
        com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(this.hpd, false);
        if (this.hpe != null) {
            this.hpe.cancelLoadData();
        }
        if (this.hbV != null && this.hbV.bOq() != null) {
            this.hbV.bOq().aqS();
        }
        if (this.hpl != null) {
            this.hpl.onDestroy();
        }
    }

    public FragmentTabHost bQl() {
        if (this.hpb == null) {
            return null;
        }
        return this.hpb.bQl();
    }

    public boolean bTh() {
        if (this.hph == null) {
            return false;
        }
        return this.hph.getItem(0) instanceof FrsTabHostFragment;
    }

    public void tx(int i) {
        this.hbX = i;
    }

    public void uh(int i) {
        this.hbY = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTi() {
        if (this.hpa != null) {
            if (this.hpl == null) {
                this.hpl = (NavigationBarCoverTip) this.hpa.findViewById(R.id.navigation_cover_tip);
            }
            if (this.hpl != null) {
                View inflate = View.inflate(this.hpa, R.layout.write_thread_share_guide, null);
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
                com.baidu.tbadk.core.util.am.setBackgroundColor(this.hpl, R.color.cp_link_tip_a_alpha95);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new an("c13439").aOO();
                        if (FrsTabController.this.bNM() != null && !TextUtils.isEmpty(FrsTabController.this.bNM().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.hpa != null) {
                            if (FrsTabController.this.hpl != null) {
                                FrsTabController.this.hpl.hideTip();
                            }
                            ba.aOV().b(FrsTabController.this.hpa.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.bNM().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.aNT().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.hpl.a(this.hpa, inflate, 30000);
                new an("c13438").aOO();
                int i = com.baidu.tbadk.core.sharedPref.b.aNT().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.aNT().putInt("key_bawu_task_toast", i + 1);
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

        public BaseFragment Dg(String str) {
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
        if (!bTh()) {
            return this.hbV.getTbPageTag();
        }
        if (this.hpb != null) {
            if (1 == this.hpb.getCurrentTabType()) {
                return this.hbV.getTbPageTag();
            }
            Fragment currentFragment = this.hpb.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }
}
