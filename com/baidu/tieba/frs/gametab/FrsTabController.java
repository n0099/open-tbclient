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
import com.baidu.tbadk.core.util.bb;
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
    public static final String fKt = FrsFragment.class.getSimpleName();
    public static final String fKu = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String fKv = FrsTabHostFragment.class.getSimpleName();
    private ShareSuccessReplyToServerModel fKB;
    private FrsBaseViewPager fKD;
    private FragmentAdapter fKE;
    private OvalActionButton fKF;
    private boolean fKG;
    private boolean fKH;
    private NavigationBarCoverTip fKI;
    private FrsActivity fKw;
    private FrsLiteProgramListFragment fKx;
    private FrsTabHostFragment fKy;
    private ab fxL;
    private FrsFragment fxM;
    private l fxN;
    private int fxP;
    private FRSRefreshButton fxR;
    private String mForumName;
    private boolean fKz = false;
    private final Handler mHandler = new Handler();
    private int fxO = 0;
    private boolean fKC = false;
    private boolean fKJ = false;
    private com.baidu.adp.framework.listener.a fKK = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            l lVar = null;
            if (!FrsTabController.this.fKz && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    lVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    lVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (lVar != null) {
                    FrsTabController.this.fKz = true;
                    FrsTabController.this.e(lVar);
                    if (lVar != null && lVar.getForum() != null && !StringUtils.isNull(lVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.acs().bB("2", lVar.getForum().getId());
                    }
                }
            }
        }
    };
    private CustomMessageListener fKL = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.fKz && FrsTabController.this.fxN == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                l lVar = (l) customResponsedMessage.getData();
                if (lVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(lVar.getForum().getName())) {
                    FrsTabController.this.e(lVar);
                }
            }
        }
    };
    private CustomMessageListener fKM = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.bqI();
        }
    };
    private CustomMessageListener fKN = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int rG;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    rG = FrsTabController.this.rG(9);
                    if (rG == -1) {
                        rG = FrsTabController.this.rG(2);
                    }
                } else {
                    rG = FrsTabController.this.rG(intValue);
                }
                if (rG != -1 && FrsTabController.this.bqJ() && FrsTabController.this.fKy != null) {
                    FrsTabController.this.fKy.setCurrentTab(rG);
                    if (FrsTabController.this.rI(rG) != 1) {
                        FrsTabController.this.fxM.jR(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener fKO = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.aa(newNotifyData) && FrsTabController.this.fKy != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.fxL.bnU().size(); i++) {
                                FragmentTabHost.b hT = FrsTabController.this.fKy.hT(i);
                                if (hT != null && hT.mType != 1 && hT.mType != FrsTabController.this.fKy.getCurrentTabType() && hT.mType == aVar.getTabId() && aVar.bqA() && hT.bQP.qP(String.valueOf(hT.mType)) != null) {
                                    hT.bQP.qP(String.valueOf(hT.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable fKP = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        @Override // java.lang.Runnable
        public void run() {
            e.iK().removeCallbacks(this);
            FrsTabController.this.bqH();
            e.iK().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.fKC = true;
            }
        }
    };
    private CustomMessageListener fKQ = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!i.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.fKD != null && FrsTabController.this.fKE != null && FrsTabController.this.fKE.xm(FrsTabController.fKu) != null) {
                if (!j.kc()) {
                    FrsTabController.this.fKw.showToast(FrsTabController.this.fKw.getString(R.string.neterror));
                } else if ((FrsTabController.this.bls().bmy().smartAppAvatar == null || FrsTabController.this.bls().bmy().smartAppAvatar.size() != 1) && (FrsTabController.this.bls().bmy().smartAppAvatar != null || FrsTabController.this.bls().bmy().smartApp == null)) {
                    FrsTabController.this.fKD.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.bls().bmy().smartApp;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                        FrsTabController.this.fKD.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new an("c13274").bT("fid", FrsTabController.this.bls().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", FrsTabController.this.bls().bmy().smartApp.name).l(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.bls().bmy().smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside").P("obj_param1", FrsTabController.this.bls().bmy().smartApp.is_game.intValue()));
                    }
                }
            }
        }
    };
    private CustomMessageListener fKR = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fKD != null && FrsTabController.this.fKE != null && FrsTabController.this.fKE.xm(FrsTabController.fKu) != null) {
                FrsTabController.this.fKD.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener fKS = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fKD != null && FrsTabController.this.fKE != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.fKG = aVar.bnR();
                FrsTabController.this.fKH = aVar.bnS();
            }
        }
    };
    private CustomMessageListener fKT = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fKD != null && FrsTabController.this.fKE != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.fKD.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener fKU = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.fxM.bmw();
                FrsTabController.this.bqB();
                if (FrsTabController.this.bls() != null) {
                    FrsTabController.this.bls().jL(true);
                }
                FrsTabController.this.fKF.setVisibility(8);
                return;
            }
            FrsTabController.this.fKF.setVisibility(0);
            if (FrsTabController.this.bls() != null) {
                FrsTabController.this.bls().jL(false);
            }
            FrsTabController.this.fxM.bmx();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.fKH = false;
                    FrsTabController.this.fKD.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a fKV = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void blI() {
            if (FrsTabController.this.fKD != null) {
                if (FrsTabController.this.fKD.getCurrentItem() == 0) {
                    FrsTabController.this.fKD.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.fKD.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean blJ() {
            SmartApp smartApp;
            if (FrsTabController.this.fKD.getCurrentItem() == 0) {
                if (FrsTabController.this.fKG && FrsTabController.this.fKH) {
                    FrsTabController.this.fKD.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.fKH) {
                    FrsTabController.this.fKD.setmDisallowSlip(true);
                }
                FrsTabController.this.fKD.setmDisallowSlip(true);
            } else {
                FrsTabController.this.fKD.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.bls().bmy().smartAppAvatar == null || FrsTabController.this.bls().bmy().smartAppAvatar.size() != 1) && (FrsTabController.this.bls().bmy().smartAppAvatar != null || FrsTabController.this.bls().bmy().smartApp == null)) || (smartApp = FrsTabController.this.bls().bmy().smartApp) == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                return true;
            }
            TiebaStatic.log(new an("c13274").bT("fid", FrsTabController.this.bls().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", FrsTabController.this.bls().bmy().smartApp.name).l(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.bls().bmy().smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside").P("obj_param1", FrsTabController.this.bls().bmy().smartApp.is_game.intValue()));
            return false;
        }
    };
    private String fKA = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    /* JADX INFO: Access modifiers changed from: private */
    public void bqB() {
        if (this.fKx != null && bls() != null) {
            this.fKx.fOM = true;
            this.fKx.clear();
            if (!j.kc()) {
                this.fKx.xD(bls().getForumId());
            } else if ((bls().bmy().smartAppAvatar != null && bls().bmy().smartAppAvatar.size() == 1) || (bls().bmy().smartAppAvatar == null && bls().bmy().smartApp != null)) {
                SmartApp smartApp = bls().bmy().smartApp;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                    String str = null;
                    if (bls().bmy() != null && bls().bmy().smartApp != null) {
                        str = bls().bmy().smartApp.h5_url;
                    }
                    this.fKx.xE(str);
                }
                TiebaStatic.log(new an("c13274").bT("fid", bls().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", bls().bmy().smartApp.name).l(VideoPlayActivityConfig.OBJ_ID, bls().bmy().smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside").P("obj_param1", bls().bmy().smartApp.is_game.intValue()));
            } else {
                this.fKx.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.fKx;
                String forumId = bls().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.fKx;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.fKx;
                frsLiteProgramListFragment.t(forumId, 1, 10);
                TiebaStatic.log(new an("c13273").bT("fid", bls().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.fKw = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.fKw != null) {
            this.fKw.setContentView(R.layout.frs_base_layout);
            this.fKD = (FrsBaseViewPager) this.fKw.findViewById(R.id.frs_base_viewpager);
            this.fKE = new FragmentAdapter(this.fKw.getSupportFragmentManager());
            this.fKD.setAdapter(this.fKE);
            this.fKD.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.fKD.addOnPageChangeListener(this.fKU);
            this.fKD.setmDisallowSlip(true);
            this.fKD.setOnTouchEventListener(this.fKV);
            this.fKF = (OvalActionButton) this.fKw.findViewById(R.id.frs_post_forum_button);
            this.fxR = (FRSRefreshButton) this.fKw.findViewById(R.id.frs_refresh_forum_button);
            this.fKw.registerListener(this.fKS);
            this.fKw.registerListener(this.fKT);
            this.fKw.registerListener(this.fKQ);
            this.fKw.registerListener(this.fKR);
            this.fKK.getHttpMessageListener().setPriority(-1);
            this.fKK.getSocketMessageListener().setPriority(-1);
            this.fKw.registerListener(this.fKL);
            this.fKN.setSelfListener(true);
            this.fKw.registerListener(this.fKN);
            this.fKM.setSelfListener(true);
            this.fKw.registerListener(this.fKM);
            this.fKw.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.fKw.getIntent().getStringExtra("name");
                this.fxO = this.fKw.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.fxO = bundle.getInt("default_tab_id", 0);
            }
            P(bundle);
            this.fKE.notifyDataSetChanged();
            this.fKB = new ShareSuccessReplyToServerModel();
            this.fKw.registerListener(this.fKK);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.fxO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.fKE != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.fKE.xm(fKt);
                if (frsFragment == null) {
                    frsFragment = Q(bundle);
                }
                frsFragment.b(this.fKF);
                frsFragment.a(this.fxR);
                if (!fKt.equals(this.fKE.st(0))) {
                    if (fKv.equals(this.fKE.st(0))) {
                        this.fKE.ss(0);
                    }
                    this.fKE.a(0, frsFragment);
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
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.fKE == null) {
                return false;
            }
            if (fKu.equals(this.fKE.st(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.fKE.xm(fKu);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = bqD();
                }
                this.fKE.a(1, frsLiteProgramListFragment);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqC() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.fKE != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.fKE.xm(fKv);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = bqE();
                }
                frsTabHostFragment.b(this.fKF);
                frsTabHostFragment.b(this.fxR);
                if (!fKv.equals(this.fKE.st(0))) {
                    if (fKt.equals(this.fKE.st(0))) {
                        this.fKE.ss(0);
                    }
                    this.fKE.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment Q(Bundle bundle) {
        if (this.fxM == null) {
            this.fxM = new FrsFragment();
            this.fxM.setArguments(bundle);
            this.fxM.setBaseTag(fKt);
        }
        this.fxM.fux = false;
        return this.fxM;
    }

    private FrsLiteProgramListFragment bqD() {
        if (this.fKx == null) {
            this.fKx = new FrsLiteProgramListFragment();
            this.fKx.setBaseTag(fKu);
        }
        return this.fKx;
    }

    private FrsTabHostFragment bqE() {
        if (this.fKy == null) {
            this.fKy = new FrsTabHostFragment(this);
            this.fKy.setBaseTag(fKv);
            this.fKy.rL(this.fxO);
        }
        return this.fKy;
    }

    private FragmentManager getFragmentManager() {
        if (this.fKw != null) {
            return this.fKw.getSupportFragmentManager();
        }
        return null;
    }

    private void bqF() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fxN != null && (themeColorInfo = this.fxN.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.fKF.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
            this.fxR.setIconFade(R.drawable.icon_frs_refresh_n);
            this.fxR.setShadowColor(am.getColor(R.color.cp_mask_g));
            this.fxR.setColor(am.getColor(R.color.cp_bg_line_a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final l lVar) {
        if (lVar != null && lVar.getForum() != null) {
            if (lVar.getForum().getIsShowBawuTask()) {
                int i = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_bawu_task_toast", 0);
                if (i >= 0 && i < 1 && !this.fKJ) {
                    this.fKJ = true;
                    e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsTabController.this.bqL();
                        }
                    }, StatisticConfig.MIN_UPLOAD_INTERVAL);
                } else {
                    return;
                }
            }
            this.fxN = lVar;
            if (v.Z(lVar.getGameTabInfo()) > 0) {
                if (!this.fKw.isLoadingViewAttached() && !bqJ()) {
                    this.fKw.showLoadingView(this.fKw.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean d = FrsTabController.this.d(lVar);
                        FrsTabController.this.f(lVar);
                        boolean cf = FrsTabController.this.cf(FrsTabController.this.fxN.getGameTabInfo());
                        if (d || cf) {
                            FrsTabController.this.fKE.notifyDataSetChanged();
                            if (cf && FrsTabController.this.fKy != null) {
                                FrsTabController.this.fKy.L(FrsTabController.this.fxM);
                                FrsTabController.this.fKy.a(FrsTabController.this.fxN, FrsTabController.this.fxL);
                            }
                        }
                    }
                });
            } else if (bqJ()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.d(lVar);
                        FrsTabController.this.fxM.fux = true;
                        if (FrsTabController.this.fxM != null) {
                            bundle = FrsTabController.this.fxM.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.P(bundle);
                        FrsTabController.this.fKE.notifyDataSetChanged();
                        FrsTabController.this.f(lVar);
                    }
                });
            } else if (lVar != null && (lVar.smartApp != null || !v.aa(lVar.smartAppAvatar))) {
                if (!this.fKw.isLoadingViewAttached() && !bqK()) {
                    this.fKw.showLoadingView(this.fKw.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsTabController.this.d(lVar)) {
                            FrsTabController.this.f(lVar);
                            FrsTabController.this.fKE.notifyDataSetChanged();
                        }
                        if (FrsTabController.this.fKw.isLoadingViewAttached()) {
                            FrsTabController.this.fKw.hideLoadingView(FrsTabController.this.fKw.findViewById(16908290));
                        }
                    }
                });
            }
            bqF();
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
        if (this.fKw.isLoadingViewAttached()) {
            this.fKw.hideLoadingView(this.fKw.findViewById(16908290));
        }
        if (bqJ()) {
            return false;
        }
        this.fxM.fux = true;
        bqG();
        if (com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("frs_login_tip", true);
            com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("frs_game_login_tip", false);
        }
        cg(list);
        return true;
    }

    private void bqG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.fKw.registerListener(1021074, this.fKO);
    }

    private void cg(List<FrsTabInfo> list) {
        boolean z;
        if (!v.aa(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean(FrsTabController.this.fKA, true)) {
                            e.iK().post(FrsTabController.this.fKP);
                        }
                        ((ab) customResponsedMessage.getData()).b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                            @Override // com.baidu.tbadk.mainTab.b
                            public boolean isAvailable() {
                                return true;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public com.baidu.tbadk.mainTab.c atT() {
                                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", FrsTabController.this.fxM.getForumName());
                                bundle.putString("from", FrsTabController.this.fxM.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.fxM.getForumId());
                                bundle.putInt(MyBookrackActivityConfig.TAB_ID, 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.fxN.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.fxN.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.fxN.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.fxN);
                                bundle.putSerializable("view_data", frsViewData);
                                frsSportsRecommendFragment.setArguments(bundle);
                                com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                                cVar.cxK = frsSportsRecommendFragment;
                                cVar.type = 25;
                                cVar.cxQ = com.baidu.tbadk.mainTab.c.cxN;
                                return cVar;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public TbFragmentTabIndicator cP(Context context) {
                                this.cxw = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
                                this.cxw.setTextSize(2.0f);
                                return this.cxw;
                            }
                        });
                        FrsTabController.this.bqC();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.fKw.registerListener(customMessageListener);
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
            this.fxL = new ab(this.fKw.getActivity(), arrayList);
            if (bls() != null) {
                this.fxL.setForumId(bls().getForumId());
                this.fxL.setForumName(bls().getForumName());
                if (bls().bmy() != null && bls().bmy().getForum() != null) {
                    ForumData forum = bls().bmy().getForum();
                    this.fxL.setForumGameLabel(forum.getForumGameLabel());
                    this.fxL.wY(forum.getSpecialForumType());
                }
            }
            this.fxM.fux = false;
            new d(this.fxM).a(this.fxL);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.fxL);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.fKw.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqH() {
        if (this.fxL != null && !TextUtils.isEmpty(this.fxL.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.fxN.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar aLj;
        if ((fragment instanceof ah) && this.fxN != null && this.fxN.getForum() != null && (aLj = ((ah) fragment).aLj()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.fxN.getForum().getName(), 5, true, true) + this.fKw.getActivity().getString(R.string.forum));
            aLj.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.fxM instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fxM.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a mf(int i) {
        if (this.fxM instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.fxM.mf(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.fxM instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fxM.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.fxM != null) {
            this.fxM.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!bqJ()) {
            this.fxM.setPrimary(true);
        } else if (this.fKy != null) {
            Fragment currentFragment = this.fKy.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.fKC) {
            this.fKC = false;
            if (this.fxM != null) {
                this.fxM.refresh();
            }
        }
    }

    public void onPause() {
        if (!bqJ()) {
            this.fxM.setPrimary(false);
        } else if (this.fKy != null) {
            Fragment currentFragment = this.fKy.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.fKw);
        if (this.fxM != null) {
            this.fxM.onChangeSkinType(i);
        }
        if (this.fKy != null) {
            this.fKy.onChangeSkinType(i);
        }
        bqF();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fKx != null && this.fKx.fOM) {
                this.fKx.fOM = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            } else if (bqJ() && this.fKy != null && this.fKy.bnL()) {
                this.fKy.bnM();
                UtilHelper.setNavigationBarBackground(this.fKw, this.fKy.bnG());
            } else if (this.fxM != null && this.fxM.isAdded()) {
                if (this.fxM.onKeyDown(i, keyEvent)) {
                    return true;
                }
                bqI();
            } else {
                return this.fKw.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.fxM != null && this.fxM.isAdded()) {
                return this.fxM.onKeyDown(i, keyEvent);
            }
        } else {
            return this.fKw.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqI() {
        if (this.fxP != this.fxO && bqJ()) {
            this.fKy.setCurrentTab(this.fxO);
            if (rI(this.fxO) != 1) {
                this.fxM.jR(false);
            }
            this.fxP = this.fxO;
            a(this.fKy.getCurrentFragment(), this.fxO);
            return;
        }
        this.fxM.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!bqJ()) {
            this.fxM.onActivityResult(i, i2, intent);
        } else if (this.fKy != null) {
            if (1 == this.fKy.getCurrentTabType()) {
                this.fxM.onActivityResult(i, i2, intent);
            } else {
                this.fKy.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.chD().y(this.fKw.getPageContext());
                    com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.fKB != null) {
                        this.fKB.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void aoP() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.fKw != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.fKw.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.chD().y(this.fKw.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!bqJ()) {
            return this.fxM.getVoiceManager();
        }
        if (this.fKy == null) {
            return null;
        }
        Fragment currentFragment = this.fKy.getCurrentFragment();
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
    public int rG(int i) {
        if (this.fxL == null) {
            return -1;
        }
        int Z = v.Z(this.fxL.bnU());
        for (int i2 = 0; i2 < Z; i2++) {
            if (this.fxL.bnU().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rI(int i) {
        if (this.fxL != null && i < v.Z(this.fxL.bnU())) {
            return this.fxL.bnU().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bls() {
        return this.fxM;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> blt() {
        if (!bqJ()) {
            if (this.fxM instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.fxM).blt();
            }
        } else if (this.fKy == null) {
            return null;
        } else {
            Fragment currentFragment = this.fKy.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).blt();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(n.fxk);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fKw.isLoadingViewAttached()) {
            this.fKw.hideLoadingView(this.fKw.findViewById(16908290));
        }
        if (this.fKP != null) {
            e.iK().removeCallbacks(this.fKP);
        }
        com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean(this.fKA, false);
        if (this.fKB != null) {
            this.fKB.cancelLoadData();
        }
        if (this.fxM != null && this.fxM.blT() != null) {
            this.fxM.blT().aFQ();
        }
        if (this.fKI != null) {
            this.fKI.onDestroy();
        }
    }

    public FragmentTabHost bnJ() {
        if (this.fKy == null) {
            return null;
        }
        return this.fKy.bnJ();
    }

    public boolean bqJ() {
        if (this.fKE == null) {
            return false;
        }
        return this.fKE.getItem(0) instanceof FrsTabHostFragment;
    }

    private boolean bqK() {
        if (this.fKE == null) {
            return false;
        }
        return this.fKE.getItem(1) instanceof FrsLiteProgramListFragment;
    }

    public void rL(int i) {
        this.fxO = i;
    }

    public void sq(int i) {
        this.fxP = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqL() {
        if (this.fKw != null) {
            if (this.fKI == null) {
                this.fKI = (NavigationBarCoverTip) this.fKw.findViewById(R.id.navigation_cover_tip);
            }
            if (this.fKI != null) {
                View inflate = View.inflate(this.fKw, R.layout.write_thread_share_guide, null);
                TextView textView = (TextView) inflate.findViewById(R.id.write_thread_success_tips);
                TextView textView2 = (TextView) inflate.findViewById(R.id.share_icon);
                if (TextUtils.isEmpty(this.mForumName)) {
                    textView.setText("吧主您好，本吧考核新制度上线啦");
                } else {
                    textView.setText(this.mForumName + "吧吧主您好，本吧考核新制度上线啦");
                }
                textView2.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.check_immediately));
                am.j(textView, R.color.cp_btn_a);
                am.j(textView2, R.color.cp_btn_a);
                am.k(textView2, R.drawable.share_now_bg);
                am.l(this.fKI, R.color.cp_link_tip_a_alpha95);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new an("c13439").ajk();
                        if (FrsTabController.this.bls() != null && !TextUtils.isEmpty(FrsTabController.this.bls().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.fKw != null) {
                            if (FrsTabController.this.fKI != null) {
                                FrsTabController.this.fKI.hideTip();
                            }
                            bb.ajE().c(FrsTabController.this.fKw.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.bls().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.fKI.a(this.fKw, inflate, 30000);
                new an("c13438").ajk();
                int i = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("key_bawu_task_toast", i + 1);
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
        /* renamed from: sr */
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

        public BaseFragment xm(String str) {
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

        public BaseFragment ss(int i) {
            return (BaseFragment) v.d(this.mFragments, i);
        }

        public String st(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }
}
