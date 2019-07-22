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
import com.baidu.tieba.tbadkCore.j;
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
    public static final String fJF = FrsFragment.class.getSimpleName();
    public static final String fJG = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String fJH = FrsTabHostFragment.class.getSimpleName();
    private FrsActivity fJI;
    private FrsLiteProgramListFragment fJJ;
    private FrsTabHostFragment fJK;
    private ShareSuccessReplyToServerModel fJN;
    private FrsBaseViewPager fJP;
    private FragmentAdapter fJQ;
    private OvalActionButton fJR;
    private boolean fJS;
    private boolean fJT;
    private NavigationBarCoverTip fJU;
    private ab fxm;
    private FrsFragment fxn;
    private j fxo;
    private int fxq;
    private FRSRefreshButton fxs;
    private String mForumName;
    private boolean fJL = false;
    private final Handler mHandler = new Handler();
    private int fxp = 0;
    private boolean fJO = false;
    private boolean fJV = false;
    private com.baidu.adp.framework.listener.a fJW = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            j jVar = null;
            if (!FrsTabController.this.fJL && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    jVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    jVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (jVar != null) {
                    FrsTabController.this.fJL = true;
                    FrsTabController.this.d(jVar);
                    if (jVar != null && jVar.getForum() != null && !StringUtils.isNull(jVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.acs().bB("2", jVar.getForum().getId());
                    }
                }
            }
        }
    };
    private CustomMessageListener fJX = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.fJL && FrsTabController.this.fxo == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof j)) {
                j jVar = (j) customResponsedMessage.getData();
                if (jVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(jVar.getForum().getName())) {
                    FrsTabController.this.d(jVar);
                }
            }
        }
    };
    private CustomMessageListener fJY = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.bqv();
        }
    };
    private CustomMessageListener fJZ = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int rE;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    rE = FrsTabController.this.rE(9);
                    if (rE == -1) {
                        rE = FrsTabController.this.rE(2);
                    }
                } else {
                    rE = FrsTabController.this.rE(intValue);
                }
                if (rE != -1 && FrsTabController.this.bqw() && FrsTabController.this.fJK != null) {
                    FrsTabController.this.fJK.setCurrentTab(rE);
                    if (FrsTabController.this.rG(rE) != 1) {
                        FrsTabController.this.fxn.jR(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener fKa = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.aa(newNotifyData) && FrsTabController.this.fJK != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.fxm.bnK().size(); i++) {
                                FragmentTabHost.b hT = FrsTabController.this.fJK.hT(i);
                                if (hT != null && hT.mType != 1 && hT.mType != FrsTabController.this.fJK.getCurrentTabType() && hT.mType == aVar.getTabId() && aVar.bqn() && hT.bQJ.qP(String.valueOf(hT.mType)) != null) {
                                    hT.bQJ.qP(String.valueOf(hT.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable fKb = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        @Override // java.lang.Runnable
        public void run() {
            e.iK().removeCallbacks(this);
            FrsTabController.this.bqu();
            e.iK().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.fJO = true;
            }
        }
    };
    private CustomMessageListener fKc = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!i.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.fJP != null && FrsTabController.this.fJQ != null && FrsTabController.this.fJQ.xl(FrsTabController.fJG) != null) {
                if (!com.baidu.adp.lib.util.j.kc()) {
                    FrsTabController.this.fJI.showToast(FrsTabController.this.fJI.getString(R.string.neterror));
                } else if ((FrsTabController.this.bll().bmo().smartAppAvatar == null || FrsTabController.this.bll().bmo().smartAppAvatar.size() != 1) && (FrsTabController.this.bll().bmo().smartAppAvatar != null || FrsTabController.this.bll().bmo().smartApp == null)) {
                    FrsTabController.this.fJP.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.bll().bmo().smartApp;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                        FrsTabController.this.fJP.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new an("c13274").bT("fid", FrsTabController.this.bll().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", FrsTabController.this.bll().bmo().smartApp.name).l(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.bll().bmo().smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside").P("obj_param1", FrsTabController.this.bll().bmo().smartApp.is_game.intValue()));
                    }
                }
            }
        }
    };
    private CustomMessageListener fKd = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fJP != null && FrsTabController.this.fJQ != null && FrsTabController.this.fJQ.xl(FrsTabController.fJG) != null) {
                FrsTabController.this.fJP.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener fKe = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fJP != null && FrsTabController.this.fJQ != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.fJS = aVar.bnH();
                FrsTabController.this.fJT = aVar.bnI();
            }
        }
    };
    private CustomMessageListener fKf = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fJP != null && FrsTabController.this.fJQ != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.fJP.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener fKg = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.fxn.bmm();
                FrsTabController.this.bqo();
                if (FrsTabController.this.bll() != null) {
                    FrsTabController.this.bll().jL(true);
                }
                FrsTabController.this.fJR.setVisibility(8);
                return;
            }
            FrsTabController.this.fJR.setVisibility(0);
            if (FrsTabController.this.bll() != null) {
                FrsTabController.this.bll().jL(false);
            }
            FrsTabController.this.fxn.bmn();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.fJT = false;
                    FrsTabController.this.fJP.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a fKh = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void blB() {
            if (FrsTabController.this.fJP != null) {
                if (FrsTabController.this.fJP.getCurrentItem() == 0) {
                    FrsTabController.this.fJP.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.fJP.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean blC() {
            SmartApp smartApp;
            if (FrsTabController.this.fJP.getCurrentItem() == 0) {
                if (FrsTabController.this.fJS && FrsTabController.this.fJT) {
                    FrsTabController.this.fJP.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.fJT) {
                    FrsTabController.this.fJP.setmDisallowSlip(true);
                }
                FrsTabController.this.fJP.setmDisallowSlip(true);
            } else {
                FrsTabController.this.fJP.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.bll().bmo().smartAppAvatar == null || FrsTabController.this.bll().bmo().smartAppAvatar.size() != 1) && (FrsTabController.this.bll().bmo().smartAppAvatar != null || FrsTabController.this.bll().bmo().smartApp == null)) || (smartApp = FrsTabController.this.bll().bmo().smartApp) == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                return true;
            }
            TiebaStatic.log(new an("c13274").bT("fid", FrsTabController.this.bll().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", FrsTabController.this.bll().bmo().smartApp.name).l(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.bll().bmo().smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside").P("obj_param1", FrsTabController.this.bll().bmo().smartApp.is_game.intValue()));
            return false;
        }
    };
    private String fJM = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    /* JADX INFO: Access modifiers changed from: private */
    public void bqo() {
        if (this.fJJ != null && bll() != null) {
            this.fJJ.fNY = true;
            this.fJJ.clear();
            if (!com.baidu.adp.lib.util.j.kc()) {
                this.fJJ.xC(bll().getForumId());
            } else if ((bll().bmo().smartAppAvatar != null && bll().bmo().smartAppAvatar.size() == 1) || (bll().bmo().smartAppAvatar == null && bll().bmo().smartApp != null)) {
                SmartApp smartApp = bll().bmo().smartApp;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                    String str = null;
                    if (bll().bmo() != null && bll().bmo().smartApp != null) {
                        str = bll().bmo().smartApp.h5_url;
                    }
                    this.fJJ.xD(str);
                }
                TiebaStatic.log(new an("c13274").bT("fid", bll().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_name", bll().bmo().smartApp.name).l(VideoPlayActivityConfig.OBJ_ID, bll().bmo().smartApp.swan_app_id.longValue()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside").P("obj_param1", bll().bmo().smartApp.is_game.intValue()));
            } else {
                this.fJJ.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.fJJ;
                String forumId = bll().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.fJJ;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.fJJ;
                frsLiteProgramListFragment.t(forumId, 1, 10);
                TiebaStatic.log(new an("c13273").bT("fid", bll().getForumId()).bT("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.fJI = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.fJI != null) {
            this.fJI.setContentView(R.layout.frs_base_layout);
            this.fJP = (FrsBaseViewPager) this.fJI.findViewById(R.id.frs_base_viewpager);
            this.fJQ = new FragmentAdapter(this.fJI.getSupportFragmentManager());
            this.fJP.setAdapter(this.fJQ);
            this.fJP.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.fJP.addOnPageChangeListener(this.fKg);
            this.fJP.setmDisallowSlip(true);
            this.fJP.setOnTouchEventListener(this.fKh);
            this.fJR = (OvalActionButton) this.fJI.findViewById(R.id.frs_post_forum_button);
            this.fxs = (FRSRefreshButton) this.fJI.findViewById(R.id.frs_refresh_forum_button);
            this.fJI.registerListener(this.fKe);
            this.fJI.registerListener(this.fKf);
            this.fJI.registerListener(this.fKc);
            this.fJI.registerListener(this.fKd);
            this.fJW.getHttpMessageListener().setPriority(-1);
            this.fJW.getSocketMessageListener().setPriority(-1);
            this.fJI.registerListener(this.fJX);
            this.fJZ.setSelfListener(true);
            this.fJI.registerListener(this.fJZ);
            this.fJY.setSelfListener(true);
            this.fJI.registerListener(this.fJY);
            this.fJI.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.fJI.getIntent().getStringExtra("name");
                this.fxp = this.fJI.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.fxp = bundle.getInt("default_tab_id", 0);
            }
            P(bundle);
            this.fJQ.notifyDataSetChanged();
            this.fJN = new ShareSuccessReplyToServerModel();
            this.fJI.registerListener(this.fJW);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.fxp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.fJQ != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.fJQ.xl(fJF);
                if (frsFragment == null) {
                    frsFragment = Q(bundle);
                }
                frsFragment.b(this.fJR);
                frsFragment.a(this.fxs);
                if (!fJF.equals(this.fJQ.sr(0))) {
                    if (fJH.equals(this.fJQ.sr(0))) {
                        this.fJQ.sq(0);
                    }
                    this.fJQ.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(j jVar) {
        if (jVar != null && (jVar.smartApp != null || !v.aa(jVar.smartAppAvatar))) {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.fJQ == null) {
                return false;
            }
            if (fJG.equals(this.fJQ.sr(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.fJQ.xl(fJG);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = bqq();
                }
                this.fJQ.a(1, frsLiteProgramListFragment);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqp() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.fJQ != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.fJQ.xl(fJH);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = bqr();
                }
                frsTabHostFragment.b(this.fJR);
                frsTabHostFragment.b(this.fxs);
                if (!fJH.equals(this.fJQ.sr(0))) {
                    if (fJF.equals(this.fJQ.sr(0))) {
                        this.fJQ.sq(0);
                    }
                    this.fJQ.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment Q(Bundle bundle) {
        if (this.fxn == null) {
            this.fxn = new FrsFragment();
            this.fxn.setArguments(bundle);
            this.fxn.setBaseTag(fJF);
        }
        this.fxn.ftY = false;
        return this.fxn;
    }

    private FrsLiteProgramListFragment bqq() {
        if (this.fJJ == null) {
            this.fJJ = new FrsLiteProgramListFragment();
            this.fJJ.setBaseTag(fJG);
        }
        return this.fJJ;
    }

    private FrsTabHostFragment bqr() {
        if (this.fJK == null) {
            this.fJK = new FrsTabHostFragment(this);
            this.fJK.setBaseTag(fJH);
            this.fJK.rJ(this.fxp);
        }
        return this.fJK;
    }

    private FragmentManager getFragmentManager() {
        if (this.fJI != null) {
            return this.fJI.getSupportFragmentManager();
        }
        return null;
    }

    private void bqs() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fxo != null && (themeColorInfo = this.fxo.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.fJR.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
            this.fxs.setIconFade(R.drawable.icon_frs_refresh_n);
            this.fxs.setShadowColor(am.getColor(R.color.cp_mask_g));
            this.fxs.setColor(am.getColor(R.color.cp_bg_line_a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final j jVar) {
        if (jVar != null && jVar.getForum() != null) {
            if (jVar.getForum().getIsShowBawuTask()) {
                int i = com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_bawu_task_toast", 0);
                if (i >= 0 && i < 1 && !this.fJV) {
                    this.fJV = true;
                    e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsTabController.this.bqy();
                        }
                    }, StatisticConfig.MIN_UPLOAD_INTERVAL);
                } else {
                    return;
                }
            }
            this.fxo = jVar;
            if (v.Z(jVar.getGameTabInfo()) > 0) {
                if (!this.fJI.isLoadingViewAttached() && !bqw()) {
                    this.fJI.showLoadingView(this.fJI.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean c = FrsTabController.this.c(jVar);
                        FrsTabController.this.e(jVar);
                        boolean cg = FrsTabController.this.cg(FrsTabController.this.fxo.getGameTabInfo());
                        if (c || cg) {
                            FrsTabController.this.fJQ.notifyDataSetChanged();
                            if (cg && FrsTabController.this.fJK != null) {
                                FrsTabController.this.fJK.L(FrsTabController.this.fxn);
                                FrsTabController.this.fJK.a(FrsTabController.this.fxo, FrsTabController.this.fxm);
                            }
                        }
                    }
                });
            } else if (bqw()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.c(jVar);
                        FrsTabController.this.fxn.ftY = true;
                        if (FrsTabController.this.fxn != null) {
                            bundle = FrsTabController.this.fxn.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.P(bundle);
                        FrsTabController.this.fJQ.notifyDataSetChanged();
                        FrsTabController.this.e(jVar);
                    }
                });
            } else if (jVar != null && (jVar.smartApp != null || !v.aa(jVar.smartAppAvatar))) {
                if (!this.fJI.isLoadingViewAttached() && !bqx()) {
                    this.fJI.showLoadingView(this.fJI.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsTabController.this.c(jVar)) {
                            FrsTabController.this.e(jVar);
                            FrsTabController.this.fJQ.notifyDataSetChanged();
                        }
                        if (FrsTabController.this.fJI.isLoadingViewAttached()) {
                            FrsTabController.this.fJI.hideLoadingView(FrsTabController.this.fJI.findViewById(16908290));
                        }
                    }
                });
            }
            bqs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(j jVar) {
        if (jVar != null) {
            if (jVar.smartApp != null || !v.aa(jVar.smartAppAvatar)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cg(List<FrsTabInfo> list) {
        if (this.fJI.isLoadingViewAttached()) {
            this.fJI.hideLoadingView(this.fJI.findViewById(16908290));
        }
        if (bqw()) {
            return false;
        }
        this.fxn.ftY = true;
        bqt();
        if (com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("frs_login_tip", true);
            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("frs_game_login_tip", false);
        }
        ch(list);
        return true;
    }

    private void bqt() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.fJI.registerListener(1021074, this.fKa);
    }

    private void ch(List<FrsTabInfo> list) {
        boolean z;
        if (!v.aa(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean(FrsTabController.this.fJM, true)) {
                            e.iK().post(FrsTabController.this.fKb);
                        }
                        ((ab) customResponsedMessage.getData()).b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                            @Override // com.baidu.tbadk.mainTab.b
                            public boolean isAvailable() {
                                return true;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public com.baidu.tbadk.mainTab.c atR() {
                                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", FrsTabController.this.fxn.getForumName());
                                bundle.putString("from", FrsTabController.this.fxn.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.fxn.getForumId());
                                bundle.putInt(MyBookrackActivityConfig.TAB_ID, 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.fxo.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.fxo.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.fxo.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.fxo);
                                bundle.putSerializable("view_data", frsViewData);
                                frsSportsRecommendFragment.setArguments(bundle);
                                com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                                cVar.cxD = frsSportsRecommendFragment;
                                cVar.type = 25;
                                cVar.cxJ = com.baidu.tbadk.mainTab.c.cxG;
                                return cVar;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public TbFragmentTabIndicator cP(Context context) {
                                this.cxp = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
                                this.cxp.setTextSize(2.0f);
                                return this.cxp;
                            }
                        });
                        FrsTabController.this.bqp();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.fJI.registerListener(customMessageListener);
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
            this.fxm = new ab(this.fJI.getActivity(), arrayList);
            if (bll() != null) {
                this.fxm.setForumId(bll().getForumId());
                this.fxm.setForumName(bll().getForumName());
                if (bll().bmo() != null && bll().bmo().getForum() != null) {
                    ForumData forum = bll().bmo().getForum();
                    this.fxm.setForumGameLabel(forum.getForumGameLabel());
                    this.fxm.wX(forum.getSpecialForumType());
                }
            }
            this.fxn.ftY = false;
            new d(this.fxn).a(this.fxm);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.fxm);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.fJI.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqu() {
        if (this.fxm != null && !TextUtils.isEmpty(this.fxm.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.fxo.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar aLh;
        if ((fragment instanceof ah) && this.fxo != null && this.fxo.getForum() != null && (aLh = ((ah) fragment).aLh()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.fxo.getForum().getName(), 5, true, true) + this.fJI.getActivity().getString(R.string.forum));
            aLh.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.fxn instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fxn.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a me(int i) {
        if (this.fxn instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.fxn.me(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.fxn instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fxn.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.fxn != null) {
            this.fxn.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!bqw()) {
            this.fxn.setPrimary(true);
        } else if (this.fJK != null) {
            Fragment currentFragment = this.fJK.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.fJO) {
            this.fJO = false;
            if (this.fxn != null) {
                this.fxn.refresh();
            }
        }
    }

    public void onPause() {
        if (!bqw()) {
            this.fxn.setPrimary(false);
        } else if (this.fJK != null) {
            Fragment currentFragment = this.fJK.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.fJI);
        if (this.fxn != null) {
            this.fxn.onChangeSkinType(i);
        }
        if (this.fJK != null) {
            this.fJK.onChangeSkinType(i);
        }
        bqs();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fJJ != null && this.fJJ.fNY) {
                this.fJJ.fNY = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            } else if (bqw() && this.fJK != null && this.fJK.bnB()) {
                this.fJK.bnC();
                UtilHelper.setNavigationBarBackground(this.fJI, this.fJK.bnw());
            } else if (this.fxn != null && this.fxn.isAdded()) {
                if (this.fxn.onKeyDown(i, keyEvent)) {
                    return true;
                }
                bqv();
            } else {
                return this.fJI.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.fxn != null && this.fxn.isAdded()) {
                return this.fxn.onKeyDown(i, keyEvent);
            }
        } else {
            return this.fJI.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqv() {
        if (this.fxq != this.fxp && bqw()) {
            this.fJK.setCurrentTab(this.fxp);
            if (rG(this.fxp) != 1) {
                this.fxn.jR(false);
            }
            this.fxq = this.fxp;
            a(this.fJK.getCurrentFragment(), this.fxp);
            return;
        }
        this.fxn.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!bqw()) {
            this.fxn.onActivityResult(i, i2, intent);
        } else if (this.fJK != null) {
            if (1 == this.fJK.getCurrentTabType()) {
                this.fxn.onActivityResult(i, i2, intent);
            } else {
                this.fJK.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.chl().y(this.fJI.getPageContext());
                    com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.fJN != null) {
                        this.fJN.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void aoN() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.fJI != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.fJI.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.chl().y(this.fJI.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!bqw()) {
            return this.fxn.getVoiceManager();
        }
        if (this.fJK == null) {
            return null;
        }
        Fragment currentFragment = this.fJK.getCurrentFragment();
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
    public int rE(int i) {
        if (this.fxm == null) {
            return -1;
        }
        int Z = v.Z(this.fxm.bnK());
        for (int i2 = 0; i2 < Z; i2++) {
            if (this.fxm.bnK().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int rG(int i) {
        if (this.fxm != null && i < v.Z(this.fxm.bnK())) {
            return this.fxm.bnK().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bll() {
        return this.fxn;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> blm() {
        if (!bqw()) {
            if (this.fxn instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.fxn).blm();
            }
        } else if (this.fJK == null) {
            return null;
        } else {
            Fragment currentFragment = this.fJK.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).blm();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(n.fwL);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fJI.isLoadingViewAttached()) {
            this.fJI.hideLoadingView(this.fJI.findViewById(16908290));
        }
        if (this.fKb != null) {
            e.iK().removeCallbacks(this.fKb);
        }
        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean(this.fJM, false);
        if (this.fJN != null) {
            this.fJN.cancelLoadData();
        }
        if (this.fxn != null && this.fxn.blM() != null) {
            this.fxn.blM().aFO();
        }
        if (this.fJU != null) {
            this.fJU.onDestroy();
        }
    }

    public FragmentTabHost bnz() {
        if (this.fJK == null) {
            return null;
        }
        return this.fJK.bnz();
    }

    public boolean bqw() {
        if (this.fJQ == null) {
            return false;
        }
        return this.fJQ.getItem(0) instanceof FrsTabHostFragment;
    }

    private boolean bqx() {
        if (this.fJQ == null) {
            return false;
        }
        return this.fJQ.getItem(1) instanceof FrsLiteProgramListFragment;
    }

    public void rJ(int i) {
        this.fxp = i;
    }

    public void so(int i) {
        this.fxq = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqy() {
        if (this.fJI != null) {
            if (this.fJU == null) {
                this.fJU = (NavigationBarCoverTip) this.fJI.findViewById(R.id.navigation_cover_tip);
            }
            if (this.fJU != null) {
                View inflate = View.inflate(this.fJI, R.layout.write_thread_share_guide, null);
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
                am.l(this.fJU, R.color.cp_link_tip_a_alpha95);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new an("c13439").aji();
                        if (FrsTabController.this.bll() != null && !TextUtils.isEmpty(FrsTabController.this.bll().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.fJI != null) {
                            if (FrsTabController.this.fJU != null) {
                                FrsTabController.this.fJU.hideTip();
                            }
                            bb.ajC().c(FrsTabController.this.fJI.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.bll().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.fJU.a(this.fJI, inflate, 30000);
                new an("c13438").aji();
                int i = com.baidu.tbadk.core.sharedPref.b.ahO().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.ahO().putInt("key_bawu_task_toast", i + 1);
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
        /* renamed from: sp */
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

        public BaseFragment xl(String str) {
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

        public BaseFragment sq(int i) {
            return (BaseFragment) v.d(this.mFragments, i);
        }

        public String sr(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }
}
