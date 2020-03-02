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
    public static final String gEm = FrsFragment.class.getSimpleName();
    public static final String gEn = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String gEo = FrsTabHostFragment.class.getSimpleName();
    private boolean gEA;
    private NavigationBarCoverTip gEB;
    private FrsActivity gEp;
    private FrsLiteProgramListFragment gEq;
    private FrsTabHostFragment gEr;
    private ShareSuccessReplyToServerModel gEu;
    private FrsBaseViewPager gEw;
    private FragmentAdapter gEx;
    private OvalActionButton gEy;
    private boolean gEz;
    private ac grF;
    private FrsFragment grG;
    private l grH;
    private int grJ;
    private FRSRefreshButton grL;
    private String mForumName;
    private boolean gEs = false;
    private final Handler mHandler = new Handler();
    private int grI = 0;
    private boolean gEv = false;
    private boolean gEC = false;
    private com.baidu.adp.framework.listener.a gED = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            l lVar = null;
            if (!FrsTabController.this.gEs && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    lVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    lVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (lVar != null) {
                    FrsTabController.this.gEs = true;
                    FrsTabController.this.e(lVar);
                    if (lVar != null && lVar.getForum() != null && !StringUtils.isNull(lVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.aAa().co("2", lVar.getForum().getId());
                    }
                }
            }
        }
    };
    private CustomMessageListener gEE = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.gEs && FrsTabController.this.grH == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                l lVar = (l) customResponsedMessage.getData();
                if (lVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(lVar.getForum().getName())) {
                    FrsTabController.this.e(lVar);
                }
            }
        }
    };
    private CustomMessageListener gEF = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.bIy();
        }
    };
    private CustomMessageListener gEG = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
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
                if (sS != -1 && FrsTabController.this.bIz() && FrsTabController.this.gEr != null) {
                    FrsTabController.this.gEr.setCurrentTab(sS);
                    if (FrsTabController.this.sU(sS) != 1) {
                        FrsTabController.this.grG.lj(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener gEH = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.isEmpty(newNotifyData) && FrsTabController.this.gEr != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.grF.bDu().size(); i++) {
                                FragmentTabHost.b ko = FrsTabController.this.gEr.ko(i);
                                if (ko != null && ko.mType != 1 && ko.mType != FrsTabController.this.gEr.getCurrentTabType() && ko.mType == aVar.getTabId() && aVar.bIq() && ko.cYh.vz(String.valueOf(ko.mType)) != null) {
                                    ko.cYh.vz(String.valueOf(ko.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable gEI = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        @Override // java.lang.Runnable
        public void run() {
            e.gx().removeCallbacks(this);
            FrsTabController.this.bIx();
            e.gx().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.gEv = true;
            }
        }
    };
    private CustomMessageListener gEJ = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!k.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.gEw != null && FrsTabController.this.gEx != null && FrsTabController.this.gEx.Bs(FrsTabController.gEn) != null) {
                if (!j.isNetWorkAvailable()) {
                    FrsTabController.this.gEp.showToast(FrsTabController.this.gEp.getString(R.string.neterror));
                } else if ((FrsTabController.this.bDh().bEp().smartAppAvatar == null || FrsTabController.this.bDh().bEp().smartAppAvatar.size() != 1) && (FrsTabController.this.bDh().bEp().smartAppAvatar != null || FrsTabController.this.bDh().bEp().smartApp == null)) {
                    FrsTabController.this.gEw.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.bDh().bEp().smartApp;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                        FrsTabController.this.gEw.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new an("c13274").cy("fid", FrsTabController.this.bDh().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", FrsTabController.this.bDh().bEp().smartApp.name).s("obj_id", FrsTabController.this.bDh().bEp().smartApp.swan_app_id.longValue()).cy("obj_source", "frs_Bside").X("obj_param1", FrsTabController.this.bDh().bEp().smartApp.is_game.intValue()));
                    }
                }
            }
        }
    };
    private CustomMessageListener gEK = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.gEw != null && FrsTabController.this.gEx != null && FrsTabController.this.gEx.Bs(FrsTabController.gEn) != null) {
                FrsTabController.this.gEw.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener gEL = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.gEw != null && FrsTabController.this.gEx != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.gEz = aVar.bFH();
                FrsTabController.this.gEA = aVar.bFI();
            }
        }
    };
    private CustomMessageListener gEM = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.gEw != null && FrsTabController.this.gEx != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.gEw.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener gEN = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.grG.bEn();
                FrsTabController.this.bIr();
                if (FrsTabController.this.bDh() != null) {
                    FrsTabController.this.bDh().ld(true);
                }
                FrsTabController.this.gEy.setVisibility(8);
                return;
            }
            FrsTabController.this.gEy.setVisibility(0);
            if (FrsTabController.this.bDh() != null) {
                FrsTabController.this.bDh().ld(false);
            }
            FrsTabController.this.grG.bEo();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.gEA = false;
                    FrsTabController.this.gEw.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a gEO = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void bDx() {
            if (FrsTabController.this.gEw != null) {
                if (FrsTabController.this.gEw.getCurrentItem() == 0) {
                    FrsTabController.this.gEw.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.gEw.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean bDy() {
            SmartApp smartApp;
            if (FrsTabController.this.gEw.getCurrentItem() == 0) {
                if (FrsTabController.this.gEz && FrsTabController.this.gEA) {
                    FrsTabController.this.gEw.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.gEA) {
                    FrsTabController.this.gEw.setmDisallowSlip(true);
                }
                FrsTabController.this.gEw.setmDisallowSlip(true);
            } else {
                FrsTabController.this.gEw.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.bDh().bEp().smartAppAvatar == null || FrsTabController.this.bDh().bEp().smartAppAvatar.size() != 1) && (FrsTabController.this.bDh().bEp().smartAppAvatar != null || FrsTabController.this.bDh().bEp().smartApp == null)) || (smartApp = FrsTabController.this.bDh().bEp().smartApp) == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                return true;
            }
            TiebaStatic.log(new an("c13274").cy("fid", FrsTabController.this.bDh().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", FrsTabController.this.bDh().bEp().smartApp.name).s("obj_id", FrsTabController.this.bDh().bEp().smartApp.swan_app_id.longValue()).cy("obj_source", "frs_Bside").X("obj_param1", FrsTabController.this.bDh().bEp().smartApp.is_game.intValue()));
            return false;
        }
    };
    private String gEt = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    /* JADX INFO: Access modifiers changed from: private */
    public void bIr() {
        if (this.gEq != null && bDh() != null) {
            this.gEq.gIH = true;
            this.gEq.clear();
            if (!j.isNetWorkAvailable()) {
                this.gEq.BJ(bDh().getForumId());
            } else if ((bDh().bEp().smartAppAvatar != null && bDh().bEp().smartAppAvatar.size() == 1) || (bDh().bEp().smartAppAvatar == null && bDh().bEp().smartApp != null)) {
                SmartApp smartApp = bDh().bEp().smartApp;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                    String str = null;
                    if (bDh().bEp() != null && bDh().bEp().smartApp != null) {
                        str = bDh().bEp().smartApp.h5_url;
                    }
                    this.gEq.BK(str);
                }
                TiebaStatic.log(new an("c13274").cy("fid", bDh().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", bDh().bEp().smartApp.name).s("obj_id", bDh().bEp().smartApp.swan_app_id.longValue()).cy("obj_source", "frs_Bside").X("obj_param1", bDh().bEp().smartApp.is_game.intValue()));
            } else {
                this.gEq.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.gEq;
                String forumId = bDh().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.gEq;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.gEq;
                frsLiteProgramListFragment.u(forumId, 1, 10);
                TiebaStatic.log(new an("c13273").cy("fid", bDh().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.gEp = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.gEp != null) {
            this.gEp.setContentView(R.layout.frs_base_layout);
            this.gEw = (FrsBaseViewPager) this.gEp.findViewById(R.id.frs_base_viewpager);
            this.gEx = new FragmentAdapter(this.gEp.getSupportFragmentManager());
            this.gEw.setAdapter(this.gEx);
            this.gEw.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.gEw.addOnPageChangeListener(this.gEN);
            this.gEw.setmDisallowSlip(true);
            this.gEw.setOnTouchEventListener(this.gEO);
            this.gEy = (OvalActionButton) this.gEp.findViewById(R.id.frs_post_forum_button);
            this.gEy.setIsCircle(true);
            this.gEy.setHasShadow(false);
            this.grL = (FRSRefreshButton) this.gEp.findViewById(R.id.frs_refresh_forum_button);
            this.gEp.registerListener(this.gEL);
            this.gEp.registerListener(this.gEM);
            this.gEp.registerListener(this.gEJ);
            this.gEp.registerListener(this.gEK);
            this.gED.getHttpMessageListener().setPriority(-1);
            this.gED.getSocketMessageListener().setPriority(-1);
            this.gEp.registerListener(this.gEE);
            this.gEG.setSelfListener(true);
            this.gEp.registerListener(this.gEG);
            this.gEF.setSelfListener(true);
            this.gEp.registerListener(this.gEF);
            this.gEp.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.gEp.getIntent().getStringExtra("name");
                this.grI = this.gEp.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.grI = bundle.getInt("default_tab_id", 0);
            }
            ah(bundle);
            this.gEx.notifyDataSetChanged();
            this.gEu = new ShareSuccessReplyToServerModel();
            this.gEp.registerListener(this.gED);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.grI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.gEx != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.gEx.Bs(gEm);
                if (frsFragment == null) {
                    frsFragment = ai(bundle);
                }
                frsFragment.b(this.gEy);
                frsFragment.a(this.grL);
                if (!gEm.equals(this.gEx.tG(0))) {
                    if (gEo.equals(this.gEx.tG(0))) {
                        this.gEx.tF(0);
                    }
                    this.gEx.a(0, frsFragment);
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
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.gEx == null) {
                return false;
            }
            if (gEn.equals(this.gEx.tG(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.gEx.Bs(gEn);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = bIt();
                }
                this.gEx.a(1, frsLiteProgramListFragment);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIs() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.gEx != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.gEx.Bs(gEo);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = bIu();
                }
                frsTabHostFragment.b(this.gEy);
                frsTabHostFragment.b(this.grL);
                if (!gEo.equals(this.gEx.tG(0))) {
                    if (gEm.equals(this.gEx.tG(0))) {
                        this.gEx.tF(0);
                    }
                    this.gEx.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment ai(Bundle bundle) {
        if (this.grG == null) {
            this.grG = new FrsFragment();
            this.grG.setArguments(bundle);
            this.grG.setBaseTag(gEm);
        }
        this.grG.gou = false;
        return this.grG;
    }

    private FrsLiteProgramListFragment bIt() {
        if (this.gEq == null) {
            this.gEq = new FrsLiteProgramListFragment();
            this.gEq.setBaseTag(gEn);
        }
        return this.gEq;
    }

    private FrsTabHostFragment bIu() {
        if (this.gEr == null) {
            this.gEr = new FrsTabHostFragment(this);
            this.gEr.setBaseTag(gEo);
            this.gEr.sX(this.grI);
        }
        return this.gEr;
    }

    private FragmentManager getFragmentManager() {
        if (this.gEp != null) {
            return this.gEp.getSupportFragmentManager();
        }
        return null;
    }

    private void bIv() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.grH != null && (themeColorInfo = this.grH.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.gEy.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final l lVar) {
        if (lVar != null && lVar.getForum() != null) {
            if (lVar.getForum().getIsShowBawuTask()) {
                int i = com.baidu.tbadk.core.sharedPref.b.aFD().getInt("key_bawu_task_toast", 0);
                if (i >= 0 && i < 1 && !this.gEC) {
                    this.gEC = true;
                    e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsTabController.this.bIA();
                        }
                    }, 30000L);
                } else {
                    return;
                }
            }
            this.grH = lVar;
            if (this.gEp.getIntent() == null || this.gEp.getIntent().getParcelableExtra("key_uri") != null) {
            }
            if (v.getCount(lVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean d = FrsTabController.this.d(lVar);
                        FrsTabController.this.f(lVar);
                        boolean ck = FrsTabController.this.ck(FrsTabController.this.grH.getGameTabInfo());
                        if (d || ck) {
                            FrsTabController.this.gEx.notifyDataSetChanged();
                            if (ck && FrsTabController.this.gEr != null) {
                                FrsTabController.this.gEr.L(FrsTabController.this.grG);
                                FrsTabController.this.gEr.a(FrsTabController.this.grH, FrsTabController.this.grF);
                            }
                        }
                    }
                });
            } else if (bIz()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.d(lVar);
                        FrsTabController.this.grG.gou = true;
                        if (FrsTabController.this.grG != null) {
                            bundle = FrsTabController.this.grG.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.ah(bundle);
                        FrsTabController.this.gEx.notifyDataSetChanged();
                        FrsTabController.this.f(lVar);
                    }
                });
            } else if (lVar != null && (lVar.smartApp != null || !v.isEmpty(lVar.smartAppAvatar))) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsTabController.this.d(lVar)) {
                            FrsTabController.this.f(lVar);
                            FrsTabController.this.gEx.notifyDataSetChanged();
                        }
                        if (FrsTabController.this.gEp.isLoadingViewAttached()) {
                            FrsTabController.this.gEp.hideLoadingView(FrsTabController.this.gEp.findViewById(16908290));
                        }
                    }
                });
            }
            bIv();
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
        if (this.gEp.isLoadingViewAttached()) {
            this.gEp.hideLoadingView(this.gEp.findViewById(16908290));
        }
        if (bIz()) {
            return false;
        }
        this.grG.gou = true;
        bIw();
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("frs_game_login_tip", false);
        }
        cl(list);
        return true;
    }

    private void bIw() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.gEp.registerListener(1021074, this.gEH);
    }

    private void cl(List<FrsTabInfo> list) {
        boolean z;
        if (!v.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ac)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(FrsTabController.this.gEt, true)) {
                            e.gx().post(FrsTabController.this.gEI);
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
                                bundle.putString("name", FrsTabController.this.grG.getForumName());
                                bundle.putString("from", FrsTabController.this.grG.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.grG.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.grH.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.grH.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.grH.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.grH);
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
                        FrsTabController.this.bIs();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.gEp.registerListener(customMessageListener);
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
            this.grF = new ac(this.gEp.getActivity(), arrayList);
            if (bDh() != null) {
                this.grF.setForumId(bDh().getForumId());
                this.grF.setForumName(bDh().getForumName());
                if (bDh().bEp() != null && bDh().bEp().getForum() != null) {
                    ForumData forum = bDh().bEp().getForum();
                    this.grF.setForumGameLabel(forum.getForumGameLabel());
                    this.grF.Bg(forum.getSpecialForumType());
                }
            }
            this.grG.gou = false;
            new d(this.grG).a(this.grF);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.grF);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.gEp.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIx() {
        if (this.grF != null && !TextUtils.isEmpty(this.grF.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.grH.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar beL;
        if ((fragment instanceof ai) && this.grH != null && this.grH.getForum() != null && (beL = ((ai) fragment).beL()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.grH.getForum().getName(), 5, true, true) + this.gEp.getActivity().getString(R.string.forum));
            beL.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.grG instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.grG.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a nS(int i) {
        if (this.grG instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.grG.nS(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.grG instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.grG.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.grG != null) {
            this.grG.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!bIz()) {
            this.grG.setPrimary(true);
        } else if (this.gEr != null) {
            Fragment currentFragment = this.gEr.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.gEv) {
            this.gEv = false;
            if (this.grG != null) {
                this.grG.refresh();
            }
        }
    }

    public void onPause() {
        if (!bIz()) {
            this.grG.setPrimary(false);
        } else if (this.gEr != null) {
            Fragment currentFragment = this.gEr.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.gEp);
        if (this.grG != null) {
            this.grG.onChangeSkinType(i);
        }
        if (this.gEr != null) {
            this.gEr.onChangeSkinType(i);
        }
        bIv();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gEq != null && this.gEq.gIH) {
                this.gEq.gIH = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            } else if (bIz() && this.gEr != null && this.gEr.bFp()) {
                this.gEr.bFC();
                UtilHelper.setNavigationBarBackground(this.gEp, this.gEr.bFx());
            } else if (this.grG != null && this.grG.isAdded()) {
                if (this.grG.onKeyDown(i, keyEvent)) {
                    return true;
                }
                bIy();
            } else {
                return this.gEp.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.grG != null && this.grG.isAdded()) {
                return this.grG.onKeyDown(i, keyEvent);
            }
        } else {
            return this.gEp.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIy() {
        if (this.grJ != this.grI && bIz()) {
            this.gEr.setCurrentTab(this.grI);
            if (sU(this.grI) != 1) {
                this.grG.lj(false);
            }
            this.grJ = this.grI;
            a(this.gEr.getCurrentFragment(), this.grI);
            return;
        }
        this.grG.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!bIz()) {
            this.grG.onActivityResult(i, i2, intent);
        } else if (this.gEr != null) {
            if (1 == this.gEr.getCurrentTabType()) {
                this.grG.onActivityResult(i, i2, intent);
            } else {
                this.gEr.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.cCa().A(this.gEp.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.gEu != null) {
                        this.gEu.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void aLK() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.gEp != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.gEp.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.cCa().A(this.gEp.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!bIz()) {
            return this.grG.getVoiceManager();
        }
        if (this.gEr == null) {
            return null;
        }
        Fragment currentFragment = this.gEr.getCurrentFragment();
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
        if (this.grF == null) {
            return -1;
        }
        int count = v.getCount(this.grF.bDu());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.grF.bDu().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sU(int i) {
        if (this.grF != null && i < v.getCount(this.grF.bDu())) {
            return this.grF.bDu().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bDh() {
        return this.grG;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bDi() {
        if (!bIz()) {
            if (this.grG instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.grG).bDi();
            }
        } else if (this.gEr == null) {
            return null;
        } else {
            Fragment currentFragment = this.gEr.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).bDi();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(o.grc);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gEp.isLoadingViewAttached()) {
            this.gEp.hideLoadingView(this.gEp.findViewById(16908290));
        }
        if (this.gEI != null) {
            e.gx().removeCallbacks(this.gEI);
        }
        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(this.gEt, false);
        if (this.gEu != null) {
            this.gEu.cancelLoadData();
        }
        if (this.grG != null && this.grG.bDK() != null) {
            this.grG.bDK().aiI();
        }
        if (this.gEB != null) {
            this.gEB.onDestroy();
        }
    }

    public FragmentTabHost bFA() {
        if (this.gEr == null) {
            return null;
        }
        return this.gEr.bFA();
    }

    public boolean bIz() {
        if (this.gEx == null) {
            return false;
        }
        return this.gEx.getItem(0) instanceof FrsTabHostFragment;
    }

    public void sX(int i) {
        this.grI = i;
    }

    public void tD(int i) {
        this.grJ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIA() {
        if (this.gEp != null) {
            if (this.gEB == null) {
                this.gEB = (NavigationBarCoverTip) this.gEp.findViewById(R.id.navigation_cover_tip);
            }
            if (this.gEB != null) {
                View inflate = View.inflate(this.gEp, R.layout.write_thread_share_guide, null);
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
                am.setBackgroundColor(this.gEB, R.color.cp_link_tip_a_alpha95);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new an("c13439").aGz();
                        if (FrsTabController.this.bDh() != null && !TextUtils.isEmpty(FrsTabController.this.bDh().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.gEp != null) {
                            if (FrsTabController.this.gEB != null) {
                                FrsTabController.this.gEB.hideTip();
                            }
                            ba.aGG().b(FrsTabController.this.gEp.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.bDh().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.aFD().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.gEB.a(this.gEp, inflate, 30000);
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

        public BaseFragment Bs(String str) {
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
        if (!bIz()) {
            return this.grG.getTbPageTag();
        }
        if (this.gEr != null) {
            if (1 == this.gEr.getCurrentTabType()) {
                return this.grG.getTbPageTag();
            }
            Fragment currentFragment = this.gEr.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }
}
