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
    public static final String gEk = FrsFragment.class.getSimpleName();
    public static final String gEl = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String gEm = FrsTabHostFragment.class.getSimpleName();
    private FrsActivity gEn;
    private FrsLiteProgramListFragment gEo;
    private FrsTabHostFragment gEp;
    private ShareSuccessReplyToServerModel gEs;
    private FrsBaseViewPager gEu;
    private FragmentAdapter gEv;
    private OvalActionButton gEw;
    private boolean gEx;
    private boolean gEy;
    private NavigationBarCoverTip gEz;
    private ac grD;
    private FrsFragment grE;
    private l grF;
    private int grH;
    private FRSRefreshButton grJ;
    private String mForumName;
    private boolean gEq = false;
    private final Handler mHandler = new Handler();
    private int grG = 0;
    private boolean gEt = false;
    private boolean gEA = false;
    private com.baidu.adp.framework.listener.a gEB = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            l lVar = null;
            if (!FrsTabController.this.gEq && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    lVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    lVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (lVar != null) {
                    FrsTabController.this.gEq = true;
                    FrsTabController.this.e(lVar);
                    if (lVar != null && lVar.getForum() != null && !StringUtils.isNull(lVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.azY().co("2", lVar.getForum().getId());
                    }
                }
            }
        }
    };
    private CustomMessageListener gEC = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.gEq && FrsTabController.this.grF == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                l lVar = (l) customResponsedMessage.getData();
                if (lVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(lVar.getForum().getName())) {
                    FrsTabController.this.e(lVar);
                }
            }
        }
    };
    private CustomMessageListener gED = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.bIw();
        }
    };
    private CustomMessageListener gEE = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
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
                if (sS != -1 && FrsTabController.this.bIx() && FrsTabController.this.gEp != null) {
                    FrsTabController.this.gEp.setCurrentTab(sS);
                    if (FrsTabController.this.sU(sS) != 1) {
                        FrsTabController.this.grE.lj(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener gEF = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.isEmpty(newNotifyData) && FrsTabController.this.gEp != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.grD.bDs().size(); i++) {
                                FragmentTabHost.b ko = FrsTabController.this.gEp.ko(i);
                                if (ko != null && ko.mType != 1 && ko.mType != FrsTabController.this.gEp.getCurrentTabType() && ko.mType == aVar.getTabId() && aVar.bIo() && ko.cYg.vz(String.valueOf(ko.mType)) != null) {
                                    ko.cYg.vz(String.valueOf(ko.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable gEG = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        @Override // java.lang.Runnable
        public void run() {
            e.gx().removeCallbacks(this);
            FrsTabController.this.bIv();
            e.gx().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.gEt = true;
            }
        }
    };
    private CustomMessageListener gEH = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!k.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.gEu != null && FrsTabController.this.gEv != null && FrsTabController.this.gEv.Bs(FrsTabController.gEl) != null) {
                if (!j.isNetWorkAvailable()) {
                    FrsTabController.this.gEn.showToast(FrsTabController.this.gEn.getString(R.string.neterror));
                } else if ((FrsTabController.this.bDf().bEn().smartAppAvatar == null || FrsTabController.this.bDf().bEn().smartAppAvatar.size() != 1) && (FrsTabController.this.bDf().bEn().smartAppAvatar != null || FrsTabController.this.bDf().bEn().smartApp == null)) {
                    FrsTabController.this.gEu.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.bDf().bEn().smartApp;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                        FrsTabController.this.gEu.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new an("c13274").cy("fid", FrsTabController.this.bDf().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", FrsTabController.this.bDf().bEn().smartApp.name).s("obj_id", FrsTabController.this.bDf().bEn().smartApp.swan_app_id.longValue()).cy("obj_source", "frs_Bside").X("obj_param1", FrsTabController.this.bDf().bEn().smartApp.is_game.intValue()));
                    }
                }
            }
        }
    };
    private CustomMessageListener gEI = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.gEu != null && FrsTabController.this.gEv != null && FrsTabController.this.gEv.Bs(FrsTabController.gEl) != null) {
                FrsTabController.this.gEu.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener gEJ = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.gEu != null && FrsTabController.this.gEv != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.gEx = aVar.bFF();
                FrsTabController.this.gEy = aVar.bFG();
            }
        }
    };
    private CustomMessageListener gEK = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.gEu != null && FrsTabController.this.gEv != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.gEu.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener gEL = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.grE.bEl();
                FrsTabController.this.bIp();
                if (FrsTabController.this.bDf() != null) {
                    FrsTabController.this.bDf().ld(true);
                }
                FrsTabController.this.gEw.setVisibility(8);
                return;
            }
            FrsTabController.this.gEw.setVisibility(0);
            if (FrsTabController.this.bDf() != null) {
                FrsTabController.this.bDf().ld(false);
            }
            FrsTabController.this.grE.bEm();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.gEy = false;
                    FrsTabController.this.gEu.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a gEM = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void bDv() {
            if (FrsTabController.this.gEu != null) {
                if (FrsTabController.this.gEu.getCurrentItem() == 0) {
                    FrsTabController.this.gEu.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.gEu.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean bDw() {
            SmartApp smartApp;
            if (FrsTabController.this.gEu.getCurrentItem() == 0) {
                if (FrsTabController.this.gEx && FrsTabController.this.gEy) {
                    FrsTabController.this.gEu.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.gEy) {
                    FrsTabController.this.gEu.setmDisallowSlip(true);
                }
                FrsTabController.this.gEu.setmDisallowSlip(true);
            } else {
                FrsTabController.this.gEu.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.bDf().bEn().smartAppAvatar == null || FrsTabController.this.bDf().bEn().smartAppAvatar.size() != 1) && (FrsTabController.this.bDf().bEn().smartAppAvatar != null || FrsTabController.this.bDf().bEn().smartApp == null)) || (smartApp = FrsTabController.this.bDf().bEn().smartApp) == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                return true;
            }
            TiebaStatic.log(new an("c13274").cy("fid", FrsTabController.this.bDf().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", FrsTabController.this.bDf().bEn().smartApp.name).s("obj_id", FrsTabController.this.bDf().bEn().smartApp.swan_app_id.longValue()).cy("obj_source", "frs_Bside").X("obj_param1", FrsTabController.this.bDf().bEn().smartApp.is_game.intValue()));
            return false;
        }
    };
    private String gEr = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    /* JADX INFO: Access modifiers changed from: private */
    public void bIp() {
        if (this.gEo != null && bDf() != null) {
            this.gEo.gIF = true;
            this.gEo.clear();
            if (!j.isNetWorkAvailable()) {
                this.gEo.BJ(bDf().getForumId());
            } else if ((bDf().bEn().smartAppAvatar != null && bDf().bEn().smartAppAvatar.size() == 1) || (bDf().bEn().smartAppAvatar == null && bDf().bEn().smartApp != null)) {
                SmartApp smartApp = bDf().bEn().smartApp;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                    String str = null;
                    if (bDf().bEn() != null && bDf().bEn().smartApp != null) {
                        str = bDf().bEn().smartApp.h5_url;
                    }
                    this.gEo.BK(str);
                }
                TiebaStatic.log(new an("c13274").cy("fid", bDf().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", bDf().bEn().smartApp.name).s("obj_id", bDf().bEn().smartApp.swan_app_id.longValue()).cy("obj_source", "frs_Bside").X("obj_param1", bDf().bEn().smartApp.is_game.intValue()));
            } else {
                this.gEo.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.gEo;
                String forumId = bDf().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.gEo;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.gEo;
                frsLiteProgramListFragment.u(forumId, 1, 10);
                TiebaStatic.log(new an("c13273").cy("fid", bDf().getForumId()).cy("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.gEn = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.gEn != null) {
            this.gEn.setContentView(R.layout.frs_base_layout);
            this.gEu = (FrsBaseViewPager) this.gEn.findViewById(R.id.frs_base_viewpager);
            this.gEv = new FragmentAdapter(this.gEn.getSupportFragmentManager());
            this.gEu.setAdapter(this.gEv);
            this.gEu.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.gEu.addOnPageChangeListener(this.gEL);
            this.gEu.setmDisallowSlip(true);
            this.gEu.setOnTouchEventListener(this.gEM);
            this.gEw = (OvalActionButton) this.gEn.findViewById(R.id.frs_post_forum_button);
            this.gEw.setIsCircle(true);
            this.gEw.setHasShadow(false);
            this.grJ = (FRSRefreshButton) this.gEn.findViewById(R.id.frs_refresh_forum_button);
            this.gEn.registerListener(this.gEJ);
            this.gEn.registerListener(this.gEK);
            this.gEn.registerListener(this.gEH);
            this.gEn.registerListener(this.gEI);
            this.gEB.getHttpMessageListener().setPriority(-1);
            this.gEB.getSocketMessageListener().setPriority(-1);
            this.gEn.registerListener(this.gEC);
            this.gEE.setSelfListener(true);
            this.gEn.registerListener(this.gEE);
            this.gED.setSelfListener(true);
            this.gEn.registerListener(this.gED);
            this.gEn.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.gEn.getIntent().getStringExtra("name");
                this.grG = this.gEn.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.grG = bundle.getInt("default_tab_id", 0);
            }
            ah(bundle);
            this.gEv.notifyDataSetChanged();
            this.gEs = new ShareSuccessReplyToServerModel();
            this.gEn.registerListener(this.gEB);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.grG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.gEv != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.gEv.Bs(gEk);
                if (frsFragment == null) {
                    frsFragment = ai(bundle);
                }
                frsFragment.b(this.gEw);
                frsFragment.a(this.grJ);
                if (!gEk.equals(this.gEv.tG(0))) {
                    if (gEm.equals(this.gEv.tG(0))) {
                        this.gEv.tF(0);
                    }
                    this.gEv.a(0, frsFragment);
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
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.gEv == null) {
                return false;
            }
            if (gEl.equals(this.gEv.tG(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.gEv.Bs(gEl);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = bIr();
                }
                this.gEv.a(1, frsLiteProgramListFragment);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIq() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.gEv != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.gEv.Bs(gEm);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = bIs();
                }
                frsTabHostFragment.b(this.gEw);
                frsTabHostFragment.b(this.grJ);
                if (!gEm.equals(this.gEv.tG(0))) {
                    if (gEk.equals(this.gEv.tG(0))) {
                        this.gEv.tF(0);
                    }
                    this.gEv.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment ai(Bundle bundle) {
        if (this.grE == null) {
            this.grE = new FrsFragment();
            this.grE.setArguments(bundle);
            this.grE.setBaseTag(gEk);
        }
        this.grE.gos = false;
        return this.grE;
    }

    private FrsLiteProgramListFragment bIr() {
        if (this.gEo == null) {
            this.gEo = new FrsLiteProgramListFragment();
            this.gEo.setBaseTag(gEl);
        }
        return this.gEo;
    }

    private FrsTabHostFragment bIs() {
        if (this.gEp == null) {
            this.gEp = new FrsTabHostFragment(this);
            this.gEp.setBaseTag(gEm);
            this.gEp.sX(this.grG);
        }
        return this.gEp;
    }

    private FragmentManager getFragmentManager() {
        if (this.gEn != null) {
            return this.gEn.getSupportFragmentManager();
        }
        return null;
    }

    private void bIt() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.grF != null && (themeColorInfo = this.grF.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.gEw.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final l lVar) {
        if (lVar != null && lVar.getForum() != null) {
            if (lVar.getForum().getIsShowBawuTask()) {
                int i = com.baidu.tbadk.core.sharedPref.b.aFB().getInt("key_bawu_task_toast", 0);
                if (i >= 0 && i < 1 && !this.gEA) {
                    this.gEA = true;
                    e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsTabController.this.bIy();
                        }
                    }, 30000L);
                } else {
                    return;
                }
            }
            this.grF = lVar;
            if (this.gEn.getIntent() == null || this.gEn.getIntent().getParcelableExtra("key_uri") != null) {
            }
            if (v.getCount(lVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean d = FrsTabController.this.d(lVar);
                        FrsTabController.this.f(lVar);
                        boolean ck = FrsTabController.this.ck(FrsTabController.this.grF.getGameTabInfo());
                        if (d || ck) {
                            FrsTabController.this.gEv.notifyDataSetChanged();
                            if (ck && FrsTabController.this.gEp != null) {
                                FrsTabController.this.gEp.L(FrsTabController.this.grE);
                                FrsTabController.this.gEp.a(FrsTabController.this.grF, FrsTabController.this.grD);
                            }
                        }
                    }
                });
            } else if (bIx()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.d(lVar);
                        FrsTabController.this.grE.gos = true;
                        if (FrsTabController.this.grE != null) {
                            bundle = FrsTabController.this.grE.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.ah(bundle);
                        FrsTabController.this.gEv.notifyDataSetChanged();
                        FrsTabController.this.f(lVar);
                    }
                });
            } else if (lVar != null && (lVar.smartApp != null || !v.isEmpty(lVar.smartAppAvatar))) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsTabController.this.d(lVar)) {
                            FrsTabController.this.f(lVar);
                            FrsTabController.this.gEv.notifyDataSetChanged();
                        }
                        if (FrsTabController.this.gEn.isLoadingViewAttached()) {
                            FrsTabController.this.gEn.hideLoadingView(FrsTabController.this.gEn.findViewById(16908290));
                        }
                    }
                });
            }
            bIt();
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
        if (this.gEn.isLoadingViewAttached()) {
            this.gEn.hideLoadingView(this.gEn.findViewById(16908290));
        }
        if (bIx()) {
            return false;
        }
        this.grE.gos = true;
        bIu();
        if (com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean("frs_game_login_tip", false);
        }
        cl(list);
        return true;
    }

    private void bIu() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.gEn.registerListener(1021074, this.gEF);
    }

    private void cl(List<FrsTabInfo> list) {
        boolean z;
        if (!v.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ac)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(FrsTabController.this.gEr, true)) {
                            e.gx().post(FrsTabController.this.gEG);
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
                                bundle.putString("name", FrsTabController.this.grE.getForumName());
                                bundle.putString("from", FrsTabController.this.grE.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.grE.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.grF.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.grF.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.grF.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.grF);
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
                        FrsTabController.this.bIq();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.gEn.registerListener(customMessageListener);
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
            this.grD = new ac(this.gEn.getActivity(), arrayList);
            if (bDf() != null) {
                this.grD.setForumId(bDf().getForumId());
                this.grD.setForumName(bDf().getForumName());
                if (bDf().bEn() != null && bDf().bEn().getForum() != null) {
                    ForumData forum = bDf().bEn().getForum();
                    this.grD.setForumGameLabel(forum.getForumGameLabel());
                    this.grD.Bg(forum.getSpecialForumType());
                }
            }
            this.grE.gos = false;
            new d(this.grE).a(this.grD);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.grD);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.gEn.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIv() {
        if (this.grD != null && !TextUtils.isEmpty(this.grD.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.grF.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar beJ;
        if ((fragment instanceof ai) && this.grF != null && this.grF.getForum() != null && (beJ = ((ai) fragment).beJ()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.grF.getForum().getName(), 5, true, true) + this.gEn.getActivity().getString(R.string.forum));
            beJ.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.grE instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.grE.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a nS(int i) {
        if (this.grE instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.grE.nS(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.grE instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.grE.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.grE != null) {
            this.grE.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!bIx()) {
            this.grE.setPrimary(true);
        } else if (this.gEp != null) {
            Fragment currentFragment = this.gEp.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.gEt) {
            this.gEt = false;
            if (this.grE != null) {
                this.grE.refresh();
            }
        }
    }

    public void onPause() {
        if (!bIx()) {
            this.grE.setPrimary(false);
        } else if (this.gEp != null) {
            Fragment currentFragment = this.gEp.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.gEn);
        if (this.grE != null) {
            this.grE.onChangeSkinType(i);
        }
        if (this.gEp != null) {
            this.gEp.onChangeSkinType(i);
        }
        bIt();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gEo != null && this.gEo.gIF) {
                this.gEo.gIF = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            } else if (bIx() && this.gEp != null && this.gEp.bFn()) {
                this.gEp.bFA();
                UtilHelper.setNavigationBarBackground(this.gEn, this.gEp.bFv());
            } else if (this.grE != null && this.grE.isAdded()) {
                if (this.grE.onKeyDown(i, keyEvent)) {
                    return true;
                }
                bIw();
            } else {
                return this.gEn.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.grE != null && this.grE.isAdded()) {
                return this.grE.onKeyDown(i, keyEvent);
            }
        } else {
            return this.gEn.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIw() {
        if (this.grH != this.grG && bIx()) {
            this.gEp.setCurrentTab(this.grG);
            if (sU(this.grG) != 1) {
                this.grE.lj(false);
            }
            this.grH = this.grG;
            a(this.gEp.getCurrentFragment(), this.grG);
            return;
        }
        this.grE.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!bIx()) {
            this.grE.onActivityResult(i, i2, intent);
        } else if (this.gEp != null) {
            if (1 == this.gEp.getCurrentTabType()) {
                this.grE.onActivityResult(i, i2, intent);
            } else {
                this.gEp.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.cBY().A(this.gEn.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.gEs != null) {
                        this.gEs.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void aLI() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.gEn != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.gEn.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.cBY().A(this.gEn.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!bIx()) {
            return this.grE.getVoiceManager();
        }
        if (this.gEp == null) {
            return null;
        }
        Fragment currentFragment = this.gEp.getCurrentFragment();
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
        if (this.grD == null) {
            return -1;
        }
        int count = v.getCount(this.grD.bDs());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.grD.bDs().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sU(int i) {
        if (this.grD != null && i < v.getCount(this.grD.bDs())) {
            return this.grD.bDs().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bDf() {
        return this.grE;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bDg() {
        if (!bIx()) {
            if (this.grE instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.grE).bDg();
            }
        } else if (this.gEp == null) {
            return null;
        } else {
            Fragment currentFragment = this.gEp.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).bDg();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(o.gra);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gEn.isLoadingViewAttached()) {
            this.gEn.hideLoadingView(this.gEn.findViewById(16908290));
        }
        if (this.gEG != null) {
            e.gx().removeCallbacks(this.gEG);
        }
        com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean(this.gEr, false);
        if (this.gEs != null) {
            this.gEs.cancelLoadData();
        }
        if (this.grE != null && this.grE.bDI() != null) {
            this.grE.bDI().aiG();
        }
        if (this.gEz != null) {
            this.gEz.onDestroy();
        }
    }

    public FragmentTabHost bFy() {
        if (this.gEp == null) {
            return null;
        }
        return this.gEp.bFy();
    }

    public boolean bIx() {
        if (this.gEv == null) {
            return false;
        }
        return this.gEv.getItem(0) instanceof FrsTabHostFragment;
    }

    public void sX(int i) {
        this.grG = i;
    }

    public void tD(int i) {
        this.grH = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIy() {
        if (this.gEn != null) {
            if (this.gEz == null) {
                this.gEz = (NavigationBarCoverTip) this.gEn.findViewById(R.id.navigation_cover_tip);
            }
            if (this.gEz != null) {
                View inflate = View.inflate(this.gEn, R.layout.write_thread_share_guide, null);
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
                am.setBackgroundColor(this.gEz, R.color.cp_link_tip_a_alpha95);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new an("c13439").aGx();
                        if (FrsTabController.this.bDf() != null && !TextUtils.isEmpty(FrsTabController.this.bDf().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.gEn != null) {
                            if (FrsTabController.this.gEz != null) {
                                FrsTabController.this.gEz.hideTip();
                            }
                            ba.aGE().b(FrsTabController.this.gEn.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.bDf().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.aFB().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.gEz.a(this.gEn, inflate, 30000);
                new an("c13438").aGx();
                int i = com.baidu.tbadk.core.sharedPref.b.aFB().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.aFB().putInt("key_bawu_task_toast", i + 1);
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
        if (!bIx()) {
            return this.grE.getTbPageTag();
        }
        if (this.gEp != null) {
            if (1 == this.gEp.getCurrentTabType()) {
                return this.grE.getTbPageTag();
            }
            Fragment currentFragment = this.gEp.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }
}
