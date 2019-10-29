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
    public static final String fLC = FrsFragment.class.getSimpleName();
    public static final String fLD = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String fLE = FrsTabHostFragment.class.getSimpleName();
    private FrsActivity fLF;
    private FrsLiteProgramListFragment fLG;
    private FrsTabHostFragment fLH;
    private ShareSuccessReplyToServerModel fLK;
    private FrsBaseViewPager fLM;
    private FragmentAdapter fLN;
    private OvalActionButton fLO;
    private boolean fLP;
    private boolean fLQ;
    private NavigationBarCoverTip fLR;
    private ab fyN;
    private FrsFragment fyO;
    private l fyP;
    private int fyR;
    private FRSRefreshButton fyT;
    private String mForumName;
    private boolean fLI = false;
    private final Handler mHandler = new Handler();
    private int fyQ = 0;
    private boolean fLL = false;
    private boolean fLS = false;
    private com.baidu.adp.framework.listener.a fLT = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            l lVar = null;
            if (!FrsTabController.this.fLI && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    lVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    lVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (lVar != null) {
                    FrsTabController.this.fLI = true;
                    FrsTabController.this.e(lVar);
                    if (lVar != null && lVar.getForum() != null && !StringUtils.isNull(lVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.agC().bH("2", lVar.getForum().getId());
                    }
                }
            }
        }
    };
    private CustomMessageListener fLU = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.fLI && FrsTabController.this.fyP == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                l lVar = (l) customResponsedMessage.getData();
                if (lVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(lVar.getForum().getName())) {
                    FrsTabController.this.e(lVar);
                }
            }
        }
    };
    private CustomMessageListener fLV = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.box();
        }
    };
    private CustomMessageListener fLW = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int qC;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    qC = FrsTabController.this.qC(9);
                    if (qC == -1) {
                        qC = FrsTabController.this.qC(2);
                    }
                } else {
                    qC = FrsTabController.this.qC(intValue);
                }
                if (qC != -1 && FrsTabController.this.boy() && FrsTabController.this.fLH != null) {
                    FrsTabController.this.fLH.setCurrentTab(qC);
                    if (FrsTabController.this.qE(qC) != 1) {
                        FrsTabController.this.fyO.jI(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener fLX = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.isEmpty(newNotifyData) && FrsTabController.this.fLH != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.fyN.blJ().size(); i++) {
                                FragmentTabHost.b im = FrsTabController.this.fLH.im(i);
                                if (im != null && im.mType != 1 && im.mType != FrsTabController.this.fLH.getCurrentTabType() && im.mType == aVar.getTabId() && aVar.bop() && im.cim.qa(String.valueOf(im.mType)) != null) {
                                    im.cim.qa(String.valueOf(im.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable fLY = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        @Override // java.lang.Runnable
        public void run() {
            e.fZ().removeCallbacks(this);
            FrsTabController.this.bow();
            e.fZ().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.fLL = true;
            }
        }
    };
    private CustomMessageListener fLZ = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!i.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.fLM != null && FrsTabController.this.fLN != null && FrsTabController.this.fLN.wd(FrsTabController.fLD) != null) {
                if (!j.isNetWorkAvailable()) {
                    FrsTabController.this.fLF.showToast(FrsTabController.this.fLF.getString(R.string.neterror));
                } else if ((FrsTabController.this.bjj().bkp().smartAppAvatar == null || FrsTabController.this.bjj().bkp().smartAppAvatar.size() != 1) && (FrsTabController.this.bjj().bkp().smartAppAvatar != null || FrsTabController.this.bjj().bkp().smartApp == null)) {
                    FrsTabController.this.fLM.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.bjj().bkp().smartApp;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                        FrsTabController.this.fLM.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new an("c13274").bS("fid", FrsTabController.this.bjj().getForumId()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("obj_name", FrsTabController.this.bjj().bkp().smartApp.name).p("obj_id", FrsTabController.this.bjj().bkp().smartApp.swan_app_id.longValue()).bS("obj_source", "frs_Bside").O("obj_param1", FrsTabController.this.bjj().bkp().smartApp.is_game.intValue()));
                    }
                }
            }
        }
    };
    private CustomMessageListener fMa = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fLM != null && FrsTabController.this.fLN != null && FrsTabController.this.fLN.wd(FrsTabController.fLD) != null) {
                FrsTabController.this.fLM.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener fMb = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fLM != null && FrsTabController.this.fLN != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.fLP = aVar.blG();
                FrsTabController.this.fLQ = aVar.blH();
            }
        }
    };
    private CustomMessageListener fMc = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fLM != null && FrsTabController.this.fLN != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.fLM.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener fMd = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.fyO.bkn();
                FrsTabController.this.boq();
                if (FrsTabController.this.bjj() != null) {
                    FrsTabController.this.bjj().jC(true);
                }
                FrsTabController.this.fLO.setVisibility(8);
                return;
            }
            FrsTabController.this.fLO.setVisibility(0);
            if (FrsTabController.this.bjj() != null) {
                FrsTabController.this.bjj().jC(false);
            }
            FrsTabController.this.fyO.bko();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.fLQ = false;
                    FrsTabController.this.fLM.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a fMe = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void bjz() {
            if (FrsTabController.this.fLM != null) {
                if (FrsTabController.this.fLM.getCurrentItem() == 0) {
                    FrsTabController.this.fLM.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.fLM.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean bjA() {
            SmartApp smartApp;
            if (FrsTabController.this.fLM.getCurrentItem() == 0) {
                if (FrsTabController.this.fLP && FrsTabController.this.fLQ) {
                    FrsTabController.this.fLM.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.fLQ) {
                    FrsTabController.this.fLM.setmDisallowSlip(true);
                }
                FrsTabController.this.fLM.setmDisallowSlip(true);
            } else {
                FrsTabController.this.fLM.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.bjj().bkp().smartAppAvatar == null || FrsTabController.this.bjj().bkp().smartAppAvatar.size() != 1) && (FrsTabController.this.bjj().bkp().smartAppAvatar != null || FrsTabController.this.bjj().bkp().smartApp == null)) || (smartApp = FrsTabController.this.bjj().bkp().smartApp) == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                return true;
            }
            TiebaStatic.log(new an("c13274").bS("fid", FrsTabController.this.bjj().getForumId()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("obj_name", FrsTabController.this.bjj().bkp().smartApp.name).p("obj_id", FrsTabController.this.bjj().bkp().smartApp.swan_app_id.longValue()).bS("obj_source", "frs_Bside").O("obj_param1", FrsTabController.this.bjj().bkp().smartApp.is_game.intValue()));
            return false;
        }
    };
    private String fLJ = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    /* JADX INFO: Access modifiers changed from: private */
    public void boq() {
        if (this.fLG != null && bjj() != null) {
            this.fLG.fPV = true;
            this.fLG.clear();
            if (!j.isNetWorkAvailable()) {
                this.fLG.wu(bjj().getForumId());
            } else if ((bjj().bkp().smartAppAvatar != null && bjj().bkp().smartAppAvatar.size() == 1) || (bjj().bkp().smartAppAvatar == null && bjj().bkp().smartApp != null)) {
                SmartApp smartApp = bjj().bkp().smartApp;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                    String str = null;
                    if (bjj().bkp() != null && bjj().bkp().smartApp != null) {
                        str = bjj().bkp().smartApp.h5_url;
                    }
                    this.fLG.wv(str);
                }
                TiebaStatic.log(new an("c13274").bS("fid", bjj().getForumId()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("obj_name", bjj().bkp().smartApp.name).p("obj_id", bjj().bkp().smartApp.swan_app_id.longValue()).bS("obj_source", "frs_Bside").O("obj_param1", bjj().bkp().smartApp.is_game.intValue()));
            } else {
                this.fLG.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.fLG;
                String forumId = bjj().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.fLG;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.fLG;
                frsLiteProgramListFragment.s(forumId, 1, 10);
                TiebaStatic.log(new an("c13273").bS("fid", bjj().getForumId()).bS("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.fLF = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.fLF != null) {
            this.fLF.setContentView(R.layout.frs_base_layout);
            this.fLM = (FrsBaseViewPager) this.fLF.findViewById(R.id.frs_base_viewpager);
            this.fLN = new FragmentAdapter(this.fLF.getSupportFragmentManager());
            this.fLM.setAdapter(this.fLN);
            this.fLM.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.fLM.addOnPageChangeListener(this.fMd);
            this.fLM.setmDisallowSlip(true);
            this.fLM.setOnTouchEventListener(this.fMe);
            this.fLO = (OvalActionButton) this.fLF.findViewById(R.id.frs_post_forum_button);
            this.fyT = (FRSRefreshButton) this.fLF.findViewById(R.id.frs_refresh_forum_button);
            this.fLF.registerListener(this.fMb);
            this.fLF.registerListener(this.fMc);
            this.fLF.registerListener(this.fLZ);
            this.fLF.registerListener(this.fMa);
            this.fLT.getHttpMessageListener().setPriority(-1);
            this.fLT.getSocketMessageListener().setPriority(-1);
            this.fLF.registerListener(this.fLU);
            this.fLW.setSelfListener(true);
            this.fLF.registerListener(this.fLW);
            this.fLV.setSelfListener(true);
            this.fLF.registerListener(this.fLV);
            this.fLF.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.fLF.getIntent().getStringExtra("name");
                this.fyQ = this.fLF.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.fyQ = bundle.getInt("default_tab_id", 0);
            }
            O(bundle);
            this.fLN.notifyDataSetChanged();
            this.fLK = new ShareSuccessReplyToServerModel();
            this.fLF.registerListener(this.fLT);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.fyQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.fLN != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.fLN.wd(fLC);
                if (frsFragment == null) {
                    frsFragment = P(bundle);
                }
                frsFragment.b(this.fLO);
                frsFragment.a(this.fyT);
                if (!fLC.equals(this.fLN.rq(0))) {
                    if (fLE.equals(this.fLN.rq(0))) {
                        this.fLN.rp(0);
                    }
                    this.fLN.a(0, frsFragment);
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
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.fLN == null) {
                return false;
            }
            if (fLD.equals(this.fLN.rq(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.fLN.wd(fLD);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = bos();
                }
                this.fLN.a(1, frsLiteProgramListFragment);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bor() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.fLN != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.fLN.wd(fLE);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = bot();
                }
                frsTabHostFragment.b(this.fLO);
                frsTabHostFragment.b(this.fyT);
                if (!fLE.equals(this.fLN.rq(0))) {
                    if (fLC.equals(this.fLN.rq(0))) {
                        this.fLN.rp(0);
                    }
                    this.fLN.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment P(Bundle bundle) {
        if (this.fyO == null) {
            this.fyO = new FrsFragment();
            this.fyO.setArguments(bundle);
            this.fyO.setBaseTag(fLC);
        }
        this.fyO.fvx = false;
        return this.fyO;
    }

    private FrsLiteProgramListFragment bos() {
        if (this.fLG == null) {
            this.fLG = new FrsLiteProgramListFragment();
            this.fLG.setBaseTag(fLD);
        }
        return this.fLG;
    }

    private FrsTabHostFragment bot() {
        if (this.fLH == null) {
            this.fLH = new FrsTabHostFragment(this);
            this.fLH.setBaseTag(fLE);
            this.fLH.qH(this.fyQ);
        }
        return this.fLH;
    }

    private FragmentManager getFragmentManager() {
        if (this.fLF != null) {
            return this.fLF.getSupportFragmentManager();
        }
        return null;
    }

    private void bou() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fyP != null && (themeColorInfo = this.fyP.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1 || skinType == 4) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.fLO.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
            this.fyT.setIconFade(R.drawable.icon_frs_refresh_n);
            this.fyT.setShadowColor(am.getColor(R.color.cp_mask_c_alpha25));
            this.fyT.setColor(R.color.cp_bg_line_h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final l lVar) {
        if (lVar != null && lVar.getForum() != null) {
            if (lVar.getForum().getIsShowBawuTask()) {
                int i = com.baidu.tbadk.core.sharedPref.b.alR().getInt("key_bawu_task_toast", 0);
                if (i >= 0 && i < 1 && !this.fLS) {
                    this.fLS = true;
                    e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsTabController.this.boA();
                        }
                    }, StatisticConfig.MIN_UPLOAD_INTERVAL);
                } else {
                    return;
                }
            }
            this.fyP = lVar;
            if (v.getCount(lVar.getGameTabInfo()) > 0) {
                if (!this.fLF.isLoadingViewAttached() && !boy()) {
                    this.fLF.showLoadingView(this.fLF.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean d = FrsTabController.this.d(lVar);
                        FrsTabController.this.f(lVar);
                        boolean cs = FrsTabController.this.cs(FrsTabController.this.fyP.getGameTabInfo());
                        if (d || cs) {
                            FrsTabController.this.fLN.notifyDataSetChanged();
                            if (cs && FrsTabController.this.fLH != null) {
                                FrsTabController.this.fLH.L(FrsTabController.this.fyO);
                                FrsTabController.this.fLH.a(FrsTabController.this.fyP, FrsTabController.this.fyN);
                            }
                        }
                    }
                });
            } else if (boy()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.d(lVar);
                        FrsTabController.this.fyO.fvx = true;
                        if (FrsTabController.this.fyO != null) {
                            bundle = FrsTabController.this.fyO.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.O(bundle);
                        FrsTabController.this.fLN.notifyDataSetChanged();
                        FrsTabController.this.f(lVar);
                    }
                });
            } else if (lVar != null && (lVar.smartApp != null || !v.isEmpty(lVar.smartAppAvatar))) {
                if (!this.fLF.isLoadingViewAttached() && !boz()) {
                    this.fLF.showLoadingView(this.fLF.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsTabController.this.d(lVar)) {
                            FrsTabController.this.f(lVar);
                            FrsTabController.this.fLN.notifyDataSetChanged();
                        }
                        if (FrsTabController.this.fLF.isLoadingViewAttached()) {
                            FrsTabController.this.fLF.hideLoadingView(FrsTabController.this.fLF.findViewById(16908290));
                        }
                    }
                });
            }
            bou();
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
    public boolean cs(List<FrsTabInfo> list) {
        if (this.fLF.isLoadingViewAttached()) {
            this.fLF.hideLoadingView(this.fLF.findViewById(16908290));
        }
        if (boy()) {
            return false;
        }
        this.fyO.fvx = true;
        bov();
        if (com.baidu.tbadk.core.sharedPref.b.alR().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.alR().putBoolean("frs_game_login_tip", false);
        }
        ct(list);
        return true;
    }

    private void bov() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.fLF.registerListener(1021074, this.fLX);
    }

    private void ct(List<FrsTabInfo> list) {
        boolean z;
        if (!v.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(FrsTabController.this.fLJ, true)) {
                            e.fZ().post(FrsTabController.this.fLY);
                        }
                        ((ab) customResponsedMessage.getData()).b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                            @Override // com.baidu.tbadk.mainTab.b
                            public boolean isAvailable() {
                                return true;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public com.baidu.tbadk.mainTab.c avy() {
                                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", FrsTabController.this.fyO.getForumName());
                                bundle.putString("from", FrsTabController.this.fyO.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.fyO.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.fyP.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.fyP.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.fyP.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.fyP);
                                bundle.putSerializable("view_data", frsViewData);
                                frsSportsRecommendFragment.setArguments(bundle);
                                com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                                cVar.frag = frsSportsRecommendFragment;
                                cVar.type = 25;
                                cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                                return cVar;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public TbFragmentTabIndicator cB(Context context) {
                                this.cKb = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
                                this.cKb.setTextSize(2.0f);
                                return this.cKb;
                            }
                        });
                        FrsTabController.this.bor();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.fLF.registerListener(customMessageListener);
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
            this.fyN = new ab(this.fLF.getActivity(), arrayList);
            if (bjj() != null) {
                this.fyN.setForumId(bjj().getForumId());
                this.fyN.setForumName(bjj().getForumName());
                if (bjj().bkp() != null && bjj().bkp().getForum() != null) {
                    ForumData forum = bjj().bkp().getForum();
                    this.fyN.setForumGameLabel(forum.getForumGameLabel());
                    this.fyN.vP(forum.getSpecialForumType());
                }
            }
            this.fyO.fvx = false;
            new d(this.fyO).a(this.fyN);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.fyN);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.fLF.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bow() {
        if (this.fyN != null && !TextUtils.isEmpty(this.fyN.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.fyP.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar aKR;
        if ((fragment instanceof ah) && this.fyP != null && this.fyP.getForum() != null && (aKR = ((ah) fragment).aKR()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.fyP.getForum().getName(), 5, true, true) + this.fLF.getActivity().getString(R.string.forum));
            aKR.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.fyO instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fyO.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a lo(int i) {
        if (this.fyO instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.fyO.lo(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.fyO instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fyO.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.fyO != null) {
            this.fyO.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!boy()) {
            this.fyO.setPrimary(true);
        } else if (this.fLH != null) {
            Fragment currentFragment = this.fLH.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.fLL) {
            this.fLL = false;
            if (this.fyO != null) {
                this.fyO.refresh();
            }
        }
    }

    public void onPause() {
        if (!boy()) {
            this.fyO.setPrimary(false);
        } else if (this.fLH != null) {
            Fragment currentFragment = this.fLH.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.fLF);
        if (this.fyO != null) {
            this.fyO.onChangeSkinType(i);
        }
        if (this.fLH != null) {
            this.fLH.onChangeSkinType(i);
        }
        bou();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fLG != null && this.fLG.fPV) {
                this.fLG.fPV = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            } else if (boy() && this.fLH != null && this.fLH.blA()) {
                this.fLH.blB();
                UtilHelper.setNavigationBarBackground(this.fLF, this.fLH.blv());
            } else if (this.fyO != null && this.fyO.isAdded()) {
                if (this.fyO.onKeyDown(i, keyEvent)) {
                    return true;
                }
                box();
            } else {
                return this.fLF.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.fyO != null && this.fyO.isAdded()) {
                return this.fyO.onKeyDown(i, keyEvent);
            }
        } else {
            return this.fLF.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void box() {
        if (this.fyR != this.fyQ && boy()) {
            this.fLH.setCurrentTab(this.fyQ);
            if (qE(this.fyQ) != 1) {
                this.fyO.jI(false);
            }
            this.fyR = this.fyQ;
            a(this.fLH.getCurrentFragment(), this.fyQ);
            return;
        }
        this.fyO.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!boy()) {
            this.fyO.onActivityResult(i, i2, intent);
        } else if (this.fLH != null) {
            if (1 == this.fLH.getCurrentTabType()) {
                this.fyO.onActivityResult(i, i2, intent);
            } else {
                this.fLH.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.cfp().y(this.fLF.getPageContext());
                    com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.fLK != null) {
                        this.fLK.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void ary() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.fLF != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.fLF.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.cfp().y(this.fLF.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!boy()) {
            return this.fyO.getVoiceManager();
        }
        if (this.fLH == null) {
            return null;
        }
        Fragment currentFragment = this.fLH.getCurrentFragment();
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
    public int qC(int i) {
        if (this.fyN == null) {
            return -1;
        }
        int count = v.getCount(this.fyN.blJ());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.fyN.blJ().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qE(int i) {
        if (this.fyN != null && i < v.getCount(this.fyN.blJ())) {
            return this.fyN.blJ().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bjj() {
        return this.fyO;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> bjk() {
        if (!boy()) {
            if (this.fyO instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.fyO).bjk();
            }
        } else if (this.fLH == null) {
            return null;
        } else {
            Fragment currentFragment = this.fLH.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).bjk();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(n.fyk);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fLF.isLoadingViewAttached()) {
            this.fLF.hideLoadingView(this.fLF.findViewById(16908290));
        }
        if (this.fLY != null) {
            e.fZ().removeCallbacks(this.fLY);
        }
        com.baidu.tbadk.core.sharedPref.b.alR().putBoolean(this.fLJ, false);
        if (this.fLK != null) {
            this.fLK.cancelLoadData();
        }
        if (this.fyO != null && this.fyO.bjK() != null) {
            this.fyO.bjK().aGH();
        }
        if (this.fLR != null) {
            this.fLR.onDestroy();
        }
    }

    public FragmentTabHost bly() {
        if (this.fLH == null) {
            return null;
        }
        return this.fLH.bly();
    }

    public boolean boy() {
        if (this.fLN == null) {
            return false;
        }
        return this.fLN.getItem(0) instanceof FrsTabHostFragment;
    }

    private boolean boz() {
        if (this.fLN == null) {
            return false;
        }
        return this.fLN.getItem(1) instanceof FrsLiteProgramListFragment;
    }

    public void qH(int i) {
        this.fyQ = i;
    }

    public void rn(int i) {
        this.fyR = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boA() {
        if (this.fLF != null) {
            if (this.fLR == null) {
                this.fLR = (NavigationBarCoverTip) this.fLF.findViewById(R.id.navigation_cover_tip);
            }
            if (this.fLR != null) {
                View inflate = View.inflate(this.fLF, R.layout.write_thread_share_guide, null);
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
                am.setBackgroundColor(this.fLR, R.color.cp_link_tip_a_alpha95);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new an("c13439").amK();
                        if (FrsTabController.this.bjj() != null && !TextUtils.isEmpty(FrsTabController.this.bjj().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.fLF != null) {
                            if (FrsTabController.this.fLR != null) {
                                FrsTabController.this.fLR.hideTip();
                            }
                            ba.amQ().b(FrsTabController.this.fLF.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.bjj().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.alR().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.fLR.a(this.fLF, inflate, 30000);
                new an("c13438").amK();
                int i = com.baidu.tbadk.core.sharedPref.b.alR().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.alR().putInt("key_bawu_task_toast", i + 1);
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
        /* renamed from: ro */
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

        public BaseFragment wd(String str) {
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

        public BaseFragment rp(int i) {
            return (BaseFragment) v.remove(this.mFragments, i);
        }

        public String rq(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }
}
