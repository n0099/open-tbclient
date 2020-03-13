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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
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
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.k;
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
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment;
import com.baidu.tieba.frs.sportspage.FrsSportsRecommendFragment;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SmartApp;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes9.dex */
public class FrsTabController implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    private FrsActivity gEB;
    private FrsLiteProgramListFragment gEC;
    private FrsTabHostFragment gED;
    private ShareSuccessReplyToServerModel gEG;
    private FrsBaseViewPager gEI;
    private FragmentAdapter gEJ;
    private OvalActionButton gEK;
    private boolean gEL;
    private boolean gEM;
    private NavigationBarCoverTip gEN;
    private ac grS;
    private FrsFragment grT;
    private l grU;
    private int grW;
    private FRSRefreshButton grY;
    private String mForumName;
    public static final String gEy = FrsFragment.class.getSimpleName();
    public static final String gEz = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String gEA = FrsTabHostFragment.class.getSimpleName();
    private boolean gEE = false;
    private final Handler mHandler = new Handler();
    private int grV = 0;
    private boolean gEH = false;
    private boolean gEO = false;
    private com.baidu.adp.framework.listener.a gEP = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            l lVar = null;
            if (!FrsTabController.this.gEE && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    lVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    lVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (lVar != null) {
                    FrsTabController.this.gEE = true;
                    FrsTabController.this.e(lVar);
                    if (lVar != null && lVar.getForum() != null && !StringUtils.isNull(lVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.aAa().co("2", lVar.getForum().getId());
                    }
                }
            }
        }
    };
    private CustomMessageListener gEQ = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.gEE && FrsTabController.this.grU == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                l lVar = (l) customResponsedMessage.getData();
                if (lVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(lVar.getForum().getName())) {
                    FrsTabController.this.e(lVar);
                }
            }
        }
    };
    private CustomMessageListener gER = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.bIz();
        }
    };
    private CustomMessageListener gES = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int sS;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    sS = FrsTabController.this.sS(9);
                    if (sS == -1) {
                        sS = FrsTabController.this.sS(2);
                    }
                } else {
                    sS = FrsTabController.this.sS(intValue);
                }
                if (sS != -1 && FrsTabController.this.bIA() && FrsTabController.this.gED != null) {
                    FrsTabController.this.gED.setCurrentTab(sS);
                    if (FrsTabController.this.sU(sS) != 1) {
                        FrsTabController.this.grT.lj(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener gET = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.isEmpty(newNotifyData) && FrsTabController.this.gED != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.grS.bDv().size(); i++) {
                                FragmentTabHost.b ko = FrsTabController.this.gED.ko(i);
                                if (ko != null && ko.mType != 1 && ko.mType != FrsTabController.this.gED.getCurrentTabType() && ko.mType == aVar.getTabId() && aVar.bIr() && ko.cYi.vA(String.valueOf(ko.mType)) != null) {
                                    ko.cYi.vA(String.valueOf(ko.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable gEU = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        @Override // java.lang.Runnable
        public void run() {
            e.gx().removeCallbacks(this);
            FrsTabController.this.bIy();
            e.gx().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.gEH = true;
            }
        }
    };
    private CustomMessageListener gEV = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!k.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.gEI != null && FrsTabController.this.gEJ != null && FrsTabController.this.gEJ.Bt(FrsTabController.gEz) != null) {
                if (!j.isNetWorkAvailable()) {
                    FrsTabController.this.gEB.showToast(FrsTabController.this.gEB.getString(R.string.neterror));
                } else if ((FrsTabController.this.bDi().bEq().smartAppAvatar == null || FrsTabController.this.bDi().bEq().smartAppAvatar.size() != 1) && (FrsTabController.this.bDi().bEq().smartAppAvatar != null || FrsTabController.this.bDi().bEq().smartApp == null)) {
                    FrsTabController.this.gEI.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.bDi().bEq().smartApp;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                        FrsTabController.this.gEI.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new an("c13274").cy("fid", FrsTabController.this.bDi().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", FrsTabController.this.bDi().bEq().smartApp.name).s("obj_id", FrsTabController.this.bDi().bEq().smartApp.swan_app_id.longValue()).cy("obj_source", "frs_Bside").X("obj_param1", FrsTabController.this.bDi().bEq().smartApp.is_game.intValue()));
                    }
                }
            }
        }
    };
    private CustomMessageListener gEW = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.gEI != null && FrsTabController.this.gEJ != null && FrsTabController.this.gEJ.Bt(FrsTabController.gEz) != null) {
                FrsTabController.this.gEI.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener gEX = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.gEI != null && FrsTabController.this.gEJ != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.gEL = aVar.bFI();
                FrsTabController.this.gEM = aVar.bFJ();
            }
        }
    };
    private CustomMessageListener gEY = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.gEI != null && FrsTabController.this.gEJ != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.gEI.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener gEZ = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.grT.bEo();
                FrsTabController.this.bIs();
                if (FrsTabController.this.bDi() != null) {
                    FrsTabController.this.bDi().ld(true);
                }
                FrsTabController.this.gEK.setVisibility(8);
                return;
            }
            FrsTabController.this.gEK.setVisibility(0);
            if (FrsTabController.this.bDi() != null) {
                FrsTabController.this.bDi().ld(false);
            }
            FrsTabController.this.grT.bEp();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.gEM = false;
                    FrsTabController.this.gEI.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a gFa = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void bDy() {
            if (FrsTabController.this.gEI != null) {
                if (FrsTabController.this.gEI.getCurrentItem() == 0) {
                    FrsTabController.this.gEI.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.gEI.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean bDz() {
            SmartApp smartApp;
            if (FrsTabController.this.gEI.getCurrentItem() == 0) {
                if (FrsTabController.this.gEL && FrsTabController.this.gEM) {
                    FrsTabController.this.gEI.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.gEM) {
                    FrsTabController.this.gEI.setmDisallowSlip(true);
                }
                FrsTabController.this.gEI.setmDisallowSlip(true);
            } else {
                FrsTabController.this.gEI.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.bDi().bEq().smartAppAvatar == null || FrsTabController.this.bDi().bEq().smartAppAvatar.size() != 1) && (FrsTabController.this.bDi().bEq().smartAppAvatar != null || FrsTabController.this.bDi().bEq().smartApp == null)) || (smartApp = FrsTabController.this.bDi().bEq().smartApp) == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                return true;
            }
            TiebaStatic.log(new an("c13274").cy("fid", FrsTabController.this.bDi().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", FrsTabController.this.bDi().bEq().smartApp.name).s("obj_id", FrsTabController.this.bDi().bEq().smartApp.swan_app_id.longValue()).cy("obj_source", "frs_Bside").X("obj_param1", FrsTabController.this.bDi().bEq().smartApp.is_game.intValue()));
            return false;
        }
    };
    private String gEF = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    /* JADX INFO: Access modifiers changed from: private */
    public void bIs() {
        if (this.gEC != null && bDi() != null) {
            this.gEC.gIT = true;
            this.gEC.clear();
            if (!j.isNetWorkAvailable()) {
                this.gEC.BK(bDi().getForumId());
            } else if ((bDi().bEq().smartAppAvatar != null && bDi().bEq().smartAppAvatar.size() == 1) || (bDi().bEq().smartAppAvatar == null && bDi().bEq().smartApp != null)) {
                SmartApp smartApp = bDi().bEq().smartApp;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                    String str = null;
                    if (bDi().bEq() != null && bDi().bEq().smartApp != null) {
                        str = bDi().bEq().smartApp.h5_url;
                    }
                    this.gEC.BL(str);
                }
                TiebaStatic.log(new an("c13274").cy("fid", bDi().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", bDi().bEq().smartApp.name).s("obj_id", bDi().bEq().smartApp.swan_app_id.longValue()).cy("obj_source", "frs_Bside").X("obj_param1", bDi().bEq().smartApp.is_game.intValue()));
            } else {
                this.gEC.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.gEC;
                String forumId = bDi().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.gEC;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.gEC;
                frsLiteProgramListFragment.u(forumId, 1, 10);
                TiebaStatic.log(new an("c13273").cy("fid", bDi().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.gEB = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.gEB != null) {
            this.gEB.setContentView(R.layout.frs_base_layout);
            this.gEI = (FrsBaseViewPager) this.gEB.findViewById(R.id.frs_base_viewpager);
            this.gEJ = new FragmentAdapter(this.gEB.getSupportFragmentManager());
            this.gEI.setAdapter(this.gEJ);
            this.gEI.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.gEI.addOnPageChangeListener(this.gEZ);
            this.gEI.setmDisallowSlip(true);
            this.gEI.setOnTouchEventListener(this.gFa);
            this.gEK = (OvalActionButton) this.gEB.findViewById(R.id.frs_post_forum_button);
            this.gEK.setIsCircle(true);
            this.gEK.setHasShadow(false);
            this.grY = (FRSRefreshButton) this.gEB.findViewById(R.id.frs_refresh_forum_button);
            this.gEB.registerListener(this.gEX);
            this.gEB.registerListener(this.gEY);
            this.gEB.registerListener(this.gEV);
            this.gEB.registerListener(this.gEW);
            this.gEP.getHttpMessageListener().setPriority(-1);
            this.gEP.getSocketMessageListener().setPriority(-1);
            this.gEB.registerListener(this.gEQ);
            this.gES.setSelfListener(true);
            this.gEB.registerListener(this.gES);
            this.gER.setSelfListener(true);
            this.gEB.registerListener(this.gER);
            this.gEB.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.gEB.getIntent().getStringExtra("name");
                this.grV = this.gEB.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.grV = bundle.getInt("default_tab_id", 0);
            }
            ah(bundle);
            this.gEJ.notifyDataSetChanged();
            this.gEG = new ShareSuccessReplyToServerModel();
            this.gEB.registerListener(this.gEP);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.grV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.gEJ != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.gEJ.Bt(gEy);
                if (frsFragment == null) {
                    frsFragment = ai(bundle);
                }
                frsFragment.b(this.gEK);
                frsFragment.a(this.grY);
                if (!gEy.equals(this.gEJ.tG(0))) {
                    if (gEA.equals(this.gEJ.tG(0))) {
                        this.gEJ.tF(0);
                    }
                    this.gEJ.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(l lVar) {
        if (lVar != null && (lVar.smartApp != null || !v.isEmpty(lVar.smartAppAvatar))) {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.gEJ == null) {
                return false;
            }
            if (gEz.equals(this.gEJ.tG(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.gEJ.Bt(gEz);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = bIu();
                }
                this.gEJ.a(1, frsLiteProgramListFragment);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIt() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.gEJ != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.gEJ.Bt(gEA);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = bIv();
                }
                frsTabHostFragment.b(this.gEK);
                frsTabHostFragment.b(this.grY);
                if (!gEA.equals(this.gEJ.tG(0))) {
                    if (gEy.equals(this.gEJ.tG(0))) {
                        this.gEJ.tF(0);
                    }
                    this.gEJ.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment ai(Bundle bundle) {
        if (this.grT == null) {
            this.grT = new FrsFragment();
            this.grT.setArguments(bundle);
            this.grT.setBaseTag(gEy);
        }
        this.grT.goH = false;
        return this.grT;
    }

    private FrsLiteProgramListFragment bIu() {
        if (this.gEC == null) {
            this.gEC = new FrsLiteProgramListFragment();
            this.gEC.setBaseTag(gEz);
        }
        return this.gEC;
    }

    private FrsTabHostFragment bIv() {
        if (this.gED == null) {
            this.gED = new FrsTabHostFragment(this);
            this.gED.setBaseTag(gEA);
            this.gED.sX(this.grV);
        }
        return this.gED;
    }

    private FragmentManager getFragmentManager() {
        if (this.gEB != null) {
            return this.gEB.getSupportFragmentManager();
        }
        return null;
    }

    private void bIw() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.grU != null && (themeColorInfo = this.grU.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.gEK.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final l lVar) {
        if (lVar != null && lVar.getForum() != null) {
            if (lVar.getForum().getIsShowBawuTask()) {
                int i = com.baidu.tbadk.core.sharedPref.b.aFD().getInt("key_bawu_task_toast", 0);
                if (i >= 0 && i < 1 && !this.gEO) {
                    this.gEO = true;
                    e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsTabController.this.bIB();
                        }
                    }, 30000L);
                } else {
                    return;
                }
            }
            this.grU = lVar;
            if (this.gEB.getIntent() == null || this.gEB.getIntent().getParcelableExtra("key_uri") != null) {
            }
            if (v.getCount(lVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean d = FrsTabController.this.d(lVar);
                        FrsTabController.this.f(lVar);
                        boolean ck = FrsTabController.this.ck(FrsTabController.this.grU.getGameTabInfo());
                        if (d || ck) {
                            FrsTabController.this.gEJ.notifyDataSetChanged();
                            if (ck && FrsTabController.this.gED != null) {
                                FrsTabController.this.gED.L(FrsTabController.this.grT);
                                FrsTabController.this.gED.a(FrsTabController.this.grU, FrsTabController.this.grS);
                            }
                        }
                    }
                });
            } else if (bIA()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.d(lVar);
                        FrsTabController.this.grT.goH = true;
                        if (FrsTabController.this.grT != null) {
                            bundle = FrsTabController.this.grT.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.ah(bundle);
                        FrsTabController.this.gEJ.notifyDataSetChanged();
                        FrsTabController.this.f(lVar);
                    }
                });
            } else if (lVar != null && (lVar.smartApp != null || !v.isEmpty(lVar.smartAppAvatar))) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsTabController.this.d(lVar)) {
                            FrsTabController.this.f(lVar);
                            FrsTabController.this.gEJ.notifyDataSetChanged();
                        }
                        if (FrsTabController.this.gEB.isLoadingViewAttached()) {
                            FrsTabController.this.gEB.hideLoadingView(FrsTabController.this.gEB.findViewById(16908290));
                        }
                    }
                });
            }
            bIw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(l lVar) {
        if (lVar != null) {
            if (lVar.smartApp != null || !v.isEmpty(lVar.smartAppAvatar)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ck(List<FrsTabInfo> list) {
        if (this.gEB.isLoadingViewAttached()) {
            this.gEB.hideLoadingView(this.gEB.findViewById(16908290));
        }
        if (bIA()) {
            return false;
        }
        this.grT.goH = true;
        bIx();
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("frs_game_login_tip", false);
        }
        cl(list);
        return true;
    }

    private void bIx() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.gEB.registerListener(1021074, this.gET);
    }

    private void cl(List<FrsTabInfo> list) {
        boolean z;
        if (!v.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ac)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(FrsTabController.this.gEF, true)) {
                            e.gx().post(FrsTabController.this.gEU);
                        }
                        ((ac) customResponsedMessage.getData()).b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                            @Override // com.baidu.tbadk.mainTab.b
                            public boolean isAvailable() {
                                return true;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", FrsTabController.this.grT.getForumName());
                                bundle.putString("from", FrsTabController.this.grT.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.grT.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.grU.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.grU.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.grU.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.grU);
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
                        FrsTabController.this.bIt();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.gEB.registerListener(customMessageListener);
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
            this.grS = new ac(this.gEB.getActivity(), arrayList);
            if (bDi() != null) {
                this.grS.setForumId(bDi().getForumId());
                this.grS.setForumName(bDi().getForumName());
                if (bDi().bEq() != null && bDi().bEq().getForum() != null) {
                    ForumData forum = bDi().bEq().getForum();
                    this.grS.setForumGameLabel(forum.getForumGameLabel());
                    this.grS.Bh(forum.getSpecialForumType());
                }
            }
            this.grT.goH = false;
            new d(this.grT).a(this.grS);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.grS);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.gEB.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIy() {
        if (this.grS != null && !TextUtils.isEmpty(this.grS.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.grU.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar beM;
        if ((fragment instanceof ai) && this.grU != null && this.grU.getForum() != null && (beM = ((ai) fragment).beM()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.grU.getForum().getName(), 5, true, true) + this.gEB.getActivity().getString(R.string.forum));
            beM.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.grT instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.grT.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a nS(int i) {
        if (this.grT instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.grT.nS(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.grT instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.grT.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.grT != null) {
            this.grT.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!bIA()) {
            this.grT.setPrimary(true);
        } else if (this.gED != null) {
            Fragment currentFragment = this.gED.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.gEH) {
            this.gEH = false;
            if (this.grT != null) {
                this.grT.refresh();
            }
        }
    }

    public void onPause() {
        if (!bIA()) {
            this.grT.setPrimary(false);
        } else if (this.gED != null) {
            Fragment currentFragment = this.gED.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.gEB);
        if (this.grT != null) {
            this.grT.onChangeSkinType(i);
        }
        if (this.gED != null) {
            this.gED.onChangeSkinType(i);
        }
        bIw();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gEC != null && this.gEC.gIT) {
                this.gEC.gIT = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            } else if (bIA() && this.gED != null && this.gED.bFq()) {
                this.gED.bFD();
                UtilHelper.setNavigationBarBackground(this.gEB, this.gED.bFy());
            } else if (this.grT != null && this.grT.isAdded()) {
                if (this.grT.onKeyDown(i, keyEvent)) {
                    return true;
                }
                bIz();
            } else {
                return this.gEB.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.grT != null && this.grT.isAdded()) {
                return this.grT.onKeyDown(i, keyEvent);
            }
        } else {
            return this.gEB.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIz() {
        if (this.grW != this.grV && bIA()) {
            this.gED.setCurrentTab(this.grV);
            if (sU(this.grV) != 1) {
                this.grT.lj(false);
            }
            this.grW = this.grV;
            a(this.gED.getCurrentFragment(), this.grV);
            return;
        }
        this.grT.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!bIA()) {
            this.grT.onActivityResult(i, i2, intent);
        } else if (this.gED != null) {
            if (1 == this.gED.getCurrentTabType()) {
                this.grT.onActivityResult(i, i2, intent);
            } else {
                this.gED.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.cCb().A(this.gEB.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.gEG != null) {
                        this.gEG.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void aLL() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.gEB != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.gEB.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.cCb().A(this.gEB.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!bIA()) {
            return this.grT.getVoiceManager();
        }
        if (this.gED == null) {
            return null;
        }
        Fragment currentFragment = this.gED.getCurrentFragment();
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
    public int sS(int i) {
        if (this.grS == null) {
            return -1;
        }
        int count = v.getCount(this.grS.bDv());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.grS.bDv().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sU(int i) {
        if (this.grS != null && i < v.getCount(this.grS.bDv())) {
            return this.grS.bDv().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bDi() {
        return this.grT;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bDj() {
        if (!bIA()) {
            if (this.grT instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.grT).bDj();
            }
        } else if (this.gED == null) {
            return null;
        } else {
            Fragment currentFragment = this.gED.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).bDj();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(o.grp);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gEB.isLoadingViewAttached()) {
            this.gEB.hideLoadingView(this.gEB.findViewById(16908290));
        }
        if (this.gEU != null) {
            e.gx().removeCallbacks(this.gEU);
        }
        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(this.gEF, false);
        if (this.gEG != null) {
            this.gEG.cancelLoadData();
        }
        if (this.grT != null && this.grT.bDL() != null) {
            this.grT.bDL().aiI();
        }
        if (this.gEN != null) {
            this.gEN.onDestroy();
        }
    }

    public FragmentTabHost bFB() {
        if (this.gED == null) {
            return null;
        }
        return this.gED.bFB();
    }

    public boolean bIA() {
        if (this.gEJ == null) {
            return false;
        }
        return this.gEJ.getItem(0) instanceof FrsTabHostFragment;
    }

    public void sX(int i) {
        this.grV = i;
    }

    public void tD(int i) {
        this.grW = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIB() {
        if (this.gEB != null) {
            if (this.gEN == null) {
                this.gEN = (NavigationBarCoverTip) this.gEB.findViewById(R.id.navigation_cover_tip);
            }
            if (this.gEN != null) {
                View inflate = View.inflate(this.gEB, R.layout.write_thread_share_guide, null);
                TextView textView = (TextView) inflate.findViewById(R.id.write_thread_success_tips);
                TextView textView2 = (TextView) inflate.findViewById(R.id.share_icon);
                if (TextUtils.isEmpty(this.mForumName)) {
                    textView.setText("吧主您好，本吧考核新制度上线啦");
                } else {
                    textView.setText(this.mForumName + "吧吧主您好，本吧考核新制度上线啦");
                }
                textView2.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.check_immediately));
                am.setViewTextColor(textView, (int) R.color.cp_cont_a);
                am.setViewTextColor(textView2, (int) R.color.cp_cont_a);
                am.setBackgroundResource(textView2, R.drawable.share_now_bg);
                am.setBackgroundColor(this.gEN, R.color.cp_link_tip_a_alpha95);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new an("c13439").aGz();
                        if (FrsTabController.this.bDi() != null && !TextUtils.isEmpty(FrsTabController.this.bDi().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.gEB != null) {
                            if (FrsTabController.this.gEN != null) {
                                FrsTabController.this.gEN.hideTip();
                            }
                            ba.aGG().b(FrsTabController.this.gEB.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.bDi().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.aFD().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.gEN.a(this.gEB, inflate, 30000);
                new an("c13438").aGz();
                int i = com.baidu.tbadk.core.sharedPref.b.aFD().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_bawu_task_toast", i + 1);
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
        /* renamed from: tE */
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

        public BaseFragment Bt(String str) {
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

        public BaseFragment tF(int i) {
            return (BaseFragment) v.remove(this.mFragments, i);
        }

        public String tG(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!bIA()) {
            return this.grT.getTbPageTag();
        }
        if (this.gED != null) {
            if (1 == this.gED.getCurrentTabType()) {
                return this.grT.getTbPageTag();
            }
            Fragment currentFragment = this.gED.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }
}
