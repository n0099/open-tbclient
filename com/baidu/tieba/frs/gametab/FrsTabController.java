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
/* loaded from: classes6.dex */
public class FrsTabController implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    public static final String gza = FrsFragment.class.getSimpleName();
    public static final String gzb = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String gzc = FrsTabHostFragment.class.getSimpleName();
    private ac gmt;
    private FrsFragment gmu;
    private l gmv;
    private int gmx;
    private FRSRefreshButton gmz;
    private FrsActivity gzd;
    private FrsLiteProgramListFragment gze;
    private FrsTabHostFragment gzf;
    private ShareSuccessReplyToServerModel gzi;
    private FrsBaseViewPager gzk;
    private FragmentAdapter gzl;
    private OvalActionButton gzm;
    private boolean gzn;
    private boolean gzo;
    private NavigationBarCoverTip gzp;
    private String mForumName;
    private boolean gzg = false;
    private final Handler mHandler = new Handler();
    private int gmw = 0;
    private boolean gzj = false;
    private boolean gzq = false;
    private com.baidu.adp.framework.listener.a gzr = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            l lVar = null;
            if (!FrsTabController.this.gzg && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    lVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    lVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (lVar != null) {
                    FrsTabController.this.gzg = true;
                    FrsTabController.this.e(lVar);
                    if (lVar != null && lVar.getForum() != null && !StringUtils.isNull(lVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.axr().cf("2", lVar.getForum().getId());
                    }
                }
            }
        }
    };
    private CustomMessageListener gzs = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.gzg && FrsTabController.this.gmv == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                l lVar = (l) customResponsedMessage.getData();
                if (lVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(lVar.getForum().getName())) {
                    FrsTabController.this.e(lVar);
                }
            }
        }
    };
    private CustomMessageListener gzt = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.bFS();
        }
    };
    private CustomMessageListener gzu = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int sH;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    sH = FrsTabController.this.sH(9);
                    if (sH == -1) {
                        sH = FrsTabController.this.sH(2);
                    }
                } else {
                    sH = FrsTabController.this.sH(intValue);
                }
                if (sH != -1 && FrsTabController.this.bFT() && FrsTabController.this.gzf != null) {
                    FrsTabController.this.gzf.setCurrentTab(sH);
                    if (FrsTabController.this.sJ(sH) != 1) {
                        FrsTabController.this.gmu.kU(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener gzv = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.isEmpty(newNotifyData) && FrsTabController.this.gzf != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.gmt.bDd().size(); i++) {
                                FragmentTabHost.b jX = FrsTabController.this.gzf.jX(i);
                                if (jX != null && jX.mType != 1 && jX.mType != FrsTabController.this.gzf.getCurrentTabType() && jX.mType == aVar.getTabId() && aVar.bFK() && jX.cTU.vd(String.valueOf(jX.mType)) != null) {
                                    jX.cTU.vd(String.valueOf(jX.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable gzw = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        @Override // java.lang.Runnable
        public void run() {
            e.gy().removeCallbacks(this);
            FrsTabController.this.bFR();
            e.gy().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.gzj = true;
            }
        }
    };
    private CustomMessageListener gzx = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!k.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.gzk != null && FrsTabController.this.gzl != null && FrsTabController.this.gzl.AS(FrsTabController.gzb) != null) {
                if (!j.isNetWorkAvailable()) {
                    FrsTabController.this.gzd.showToast(FrsTabController.this.gzd.getString(R.string.neterror));
                } else if ((FrsTabController.this.bAB().bBI().smartAppAvatar == null || FrsTabController.this.bAB().bBI().smartAppAvatar.size() != 1) && (FrsTabController.this.bAB().bBI().smartAppAvatar != null || FrsTabController.this.bAB().bBI().smartApp == null)) {
                    FrsTabController.this.gzk.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.bAB().bBI().smartApp;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                        FrsTabController.this.gzk.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new an("c13274").cp("fid", FrsTabController.this.bAB().getForumId()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_name", FrsTabController.this.bAB().bBI().smartApp.name).s("obj_id", FrsTabController.this.bAB().bBI().smartApp.swan_app_id.longValue()).cp("obj_source", "frs_Bside").Z("obj_param1", FrsTabController.this.bAB().bBI().smartApp.is_game.intValue()));
                    }
                }
            }
        }
    };
    private CustomMessageListener gzy = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.gzk != null && FrsTabController.this.gzl != null && FrsTabController.this.gzl.AS(FrsTabController.gzb) != null) {
                FrsTabController.this.gzk.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener gzz = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.gzk != null && FrsTabController.this.gzl != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.gzn = aVar.bDa();
                FrsTabController.this.gzo = aVar.bDb();
            }
        }
    };
    private CustomMessageListener gzA = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.gzk != null && FrsTabController.this.gzl != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.gzk.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener gzB = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.gmu.bBG();
                FrsTabController.this.bFL();
                if (FrsTabController.this.bAB() != null) {
                    FrsTabController.this.bAB().kO(true);
                }
                FrsTabController.this.gzm.setVisibility(8);
                return;
            }
            FrsTabController.this.gzm.setVisibility(0);
            if (FrsTabController.this.bAB() != null) {
                FrsTabController.this.bAB().kO(false);
            }
            FrsTabController.this.gmu.bBH();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.gzo = false;
                    FrsTabController.this.gzk.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a gzC = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void bAQ() {
            if (FrsTabController.this.gzk != null) {
                if (FrsTabController.this.gzk.getCurrentItem() == 0) {
                    FrsTabController.this.gzk.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.gzk.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean bAR() {
            SmartApp smartApp;
            if (FrsTabController.this.gzk.getCurrentItem() == 0) {
                if (FrsTabController.this.gzn && FrsTabController.this.gzo) {
                    FrsTabController.this.gzk.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.gzo) {
                    FrsTabController.this.gzk.setmDisallowSlip(true);
                }
                FrsTabController.this.gzk.setmDisallowSlip(true);
            } else {
                FrsTabController.this.gzk.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.bAB().bBI().smartAppAvatar == null || FrsTabController.this.bAB().bBI().smartAppAvatar.size() != 1) && (FrsTabController.this.bAB().bBI().smartAppAvatar != null || FrsTabController.this.bAB().bBI().smartApp == null)) || (smartApp = FrsTabController.this.bAB().bBI().smartApp) == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                return true;
            }
            TiebaStatic.log(new an("c13274").cp("fid", FrsTabController.this.bAB().getForumId()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_name", FrsTabController.this.bAB().bBI().smartApp.name).s("obj_id", FrsTabController.this.bAB().bBI().smartApp.swan_app_id.longValue()).cp("obj_source", "frs_Bside").Z("obj_param1", FrsTabController.this.bAB().bBI().smartApp.is_game.intValue()));
            return false;
        }
    };
    private String gzh = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    /* JADX INFO: Access modifiers changed from: private */
    public void bFL() {
        if (this.gze != null && bAB() != null) {
            this.gze.gDr = true;
            this.gze.clear();
            if (!j.isNetWorkAvailable()) {
                this.gze.Bj(bAB().getForumId());
            } else if ((bAB().bBI().smartAppAvatar != null && bAB().bBI().smartAppAvatar.size() == 1) || (bAB().bBI().smartAppAvatar == null && bAB().bBI().smartApp != null)) {
                SmartApp smartApp = bAB().bBI().smartApp;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                    String str = null;
                    if (bAB().bBI() != null && bAB().bBI().smartApp != null) {
                        str = bAB().bBI().smartApp.h5_url;
                    }
                    this.gze.Bk(str);
                }
                TiebaStatic.log(new an("c13274").cp("fid", bAB().getForumId()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("obj_name", bAB().bBI().smartApp.name).s("obj_id", bAB().bBI().smartApp.swan_app_id.longValue()).cp("obj_source", "frs_Bside").Z("obj_param1", bAB().bBI().smartApp.is_game.intValue()));
            } else {
                this.gze.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.gze;
                String forumId = bAB().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.gze;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.gze;
                frsLiteProgramListFragment.u(forumId, 1, 10);
                TiebaStatic.log(new an("c13273").cp("fid", bAB().getForumId()).cp("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.gzd = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.gzd != null) {
            this.gzd.setContentView(R.layout.frs_base_layout);
            this.gzk = (FrsBaseViewPager) this.gzd.findViewById(R.id.frs_base_viewpager);
            this.gzl = new FragmentAdapter(this.gzd.getSupportFragmentManager());
            this.gzk.setAdapter(this.gzl);
            this.gzk.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.gzk.addOnPageChangeListener(this.gzB);
            this.gzk.setmDisallowSlip(true);
            this.gzk.setOnTouchEventListener(this.gzC);
            this.gzm = (OvalActionButton) this.gzd.findViewById(R.id.frs_post_forum_button);
            this.gzm.setIsCircle(true);
            this.gmz = (FRSRefreshButton) this.gzd.findViewById(R.id.frs_refresh_forum_button);
            this.gzd.registerListener(this.gzz);
            this.gzd.registerListener(this.gzA);
            this.gzd.registerListener(this.gzx);
            this.gzd.registerListener(this.gzy);
            this.gzr.getHttpMessageListener().setPriority(-1);
            this.gzr.getSocketMessageListener().setPriority(-1);
            this.gzd.registerListener(this.gzs);
            this.gzu.setSelfListener(true);
            this.gzd.registerListener(this.gzu);
            this.gzt.setSelfListener(true);
            this.gzd.registerListener(this.gzt);
            this.gzd.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.gzd.getIntent().getStringExtra("name");
                this.gmw = this.gzd.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.gmw = bundle.getInt("default_tab_id", 0);
            }
            ah(bundle);
            this.gzl.notifyDataSetChanged();
            this.gzi = new ShareSuccessReplyToServerModel();
            this.gzd.registerListener(this.gzr);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.gmw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.gzl != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.gzl.AS(gza);
                if (frsFragment == null) {
                    frsFragment = ai(bundle);
                }
                frsFragment.b(this.gzm);
                frsFragment.a(this.gmz);
                if (!gza.equals(this.gzl.tv(0))) {
                    if (gzc.equals(this.gzl.tv(0))) {
                        this.gzl.tu(0);
                    }
                    this.gzl.a(0, frsFragment);
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
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.gzl == null) {
                return false;
            }
            if (gzb.equals(this.gzl.tv(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.gzl.AS(gzb);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = bFN();
                }
                this.gzl.a(1, frsLiteProgramListFragment);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFM() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.gzl != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.gzl.AS(gzc);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = bFO();
                }
                frsTabHostFragment.b(this.gzm);
                frsTabHostFragment.b(this.gmz);
                if (!gzc.equals(this.gzl.tv(0))) {
                    if (gza.equals(this.gzl.tv(0))) {
                        this.gzl.tu(0);
                    }
                    this.gzl.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment ai(Bundle bundle) {
        if (this.gmu == null) {
            this.gmu = new FrsFragment();
            this.gmu.setArguments(bundle);
            this.gmu.setBaseTag(gza);
        }
        this.gmu.gjh = false;
        return this.gmu;
    }

    private FrsLiteProgramListFragment bFN() {
        if (this.gze == null) {
            this.gze = new FrsLiteProgramListFragment();
            this.gze.setBaseTag(gzb);
        }
        return this.gze;
    }

    private FrsTabHostFragment bFO() {
        if (this.gzf == null) {
            this.gzf = new FrsTabHostFragment(this);
            this.gzf.setBaseTag(gzc);
            this.gzf.sM(this.gmw);
        }
        return this.gzf;
    }

    private FragmentManager getFragmentManager() {
        if (this.gzd != null) {
            return this.gzd.getSupportFragmentManager();
        }
        return null;
    }

    private void bFP() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.gmv != null && (themeColorInfo = this.gmv.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.gzm.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final l lVar) {
        if (lVar != null && lVar.getForum() != null) {
            if (lVar.getForum().getIsShowBawuTask()) {
                int i = com.baidu.tbadk.core.sharedPref.b.aCY().getInt("key_bawu_task_toast", 0);
                if (i >= 0 && i < 1 && !this.gzq) {
                    this.gzq = true;
                    e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsTabController.this.bFV();
                        }
                    }, 30000L);
                } else {
                    return;
                }
            }
            this.gmv = lVar;
            if (v.getCount(lVar.getGameTabInfo()) > 0) {
                if (!this.gzd.isLoadingViewAttached() && !bFT()) {
                    this.gzd.showLoadingView(this.gzd.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean d = FrsTabController.this.d(lVar);
                        FrsTabController.this.f(lVar);
                        boolean co = FrsTabController.this.co(FrsTabController.this.gmv.getGameTabInfo());
                        if (d || co) {
                            FrsTabController.this.gzl.notifyDataSetChanged();
                            if (co && FrsTabController.this.gzf != null) {
                                FrsTabController.this.gzf.N(FrsTabController.this.gmu);
                                FrsTabController.this.gzf.a(FrsTabController.this.gmv, FrsTabController.this.gmt);
                            }
                        }
                    }
                });
            } else if (bFT()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.d(lVar);
                        FrsTabController.this.gmu.gjh = true;
                        if (FrsTabController.this.gmu != null) {
                            bundle = FrsTabController.this.gmu.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.ah(bundle);
                        FrsTabController.this.gzl.notifyDataSetChanged();
                        FrsTabController.this.f(lVar);
                    }
                });
            } else if (lVar != null && (lVar.smartApp != null || !v.isEmpty(lVar.smartAppAvatar))) {
                if (!this.gzd.isLoadingViewAttached() && !bFU()) {
                    this.gzd.showLoadingView(this.gzd.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsTabController.this.d(lVar)) {
                            FrsTabController.this.f(lVar);
                            FrsTabController.this.gzl.notifyDataSetChanged();
                        }
                        if (FrsTabController.this.gzd.isLoadingViewAttached()) {
                            FrsTabController.this.gzd.hideLoadingView(FrsTabController.this.gzd.findViewById(16908290));
                        }
                    }
                });
            }
            bFP();
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
    public boolean co(List<FrsTabInfo> list) {
        if (this.gzd.isLoadingViewAttached()) {
            this.gzd.hideLoadingView(this.gzd.findViewById(16908290));
        }
        if (bFT()) {
            return false;
        }
        this.gmu.gjh = true;
        bFQ();
        if (com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean("frs_game_login_tip", false);
        }
        cp(list);
        return true;
    }

    private void bFQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.gzd.registerListener(1021074, this.gzv);
    }

    private void cp(List<FrsTabInfo> list) {
        boolean z;
        if (!v.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ac)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(FrsTabController.this.gzh, true)) {
                            e.gy().post(FrsTabController.this.gzw);
                        }
                        ((ac) customResponsedMessage.getData()).b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                            @Override // com.baidu.tbadk.mainTab.b
                            public boolean isAvailable() {
                                return true;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public com.baidu.tbadk.mainTab.c aNe() {
                                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", FrsTabController.this.gmu.getForumName());
                                bundle.putString("from", FrsTabController.this.gmu.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.gmu.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.gmv.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.gmv.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.gmv.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.gmv);
                                bundle.putSerializable("view_data", frsViewData);
                                frsSportsRecommendFragment.setArguments(bundle);
                                com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
                                cVar.frag = frsSportsRecommendFragment;
                                cVar.type = 25;
                                cVar.showIconType = com.baidu.tbadk.mainTab.c.SHOWTEXT;
                                return cVar;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public TbFragmentTabIndicator dW(Context context) {
                                this.dwU = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
                                this.dwU.setTextSize(2.0f);
                                return this.dwU;
                            }
                        });
                        FrsTabController.this.bFM();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.gzd.registerListener(customMessageListener);
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
            this.gmt = new ac(this.gzd.getActivity(), arrayList);
            if (bAB() != null) {
                this.gmt.setForumId(bAB().getForumId());
                this.gmt.setForumName(bAB().getForumName());
                if (bAB().bBI() != null && bAB().bBI().getForum() != null) {
                    ForumData forum = bAB().bBI().getForum();
                    this.gmt.setForumGameLabel(forum.getForumGameLabel());
                    this.gmt.AG(forum.getSpecialForumType());
                }
            }
            this.gmu.gjh = false;
            new d(this.gmu).a(this.gmt);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.gmt);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.gzd.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFR() {
        if (this.gmt != null && !TextUtils.isEmpty(this.gmt.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.gmv.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar bcb;
        if ((fragment instanceof ai) && this.gmv != null && this.gmv.getForum() != null && (bcb = ((ai) fragment).bcb()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.gmv.getForum().getName(), 5, true, true) + this.gzd.getActivity().getString(R.string.forum));
            bcb.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.gmu instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.gmu.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a nB(int i) {
        if (this.gmu instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.gmu.nB(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.gmu instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.gmu.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.gmu != null) {
            this.gmu.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!bFT()) {
            this.gmu.setPrimary(true);
        } else if (this.gzf != null) {
            Fragment currentFragment = this.gzf.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.gzj) {
            this.gzj = false;
            if (this.gmu != null) {
                this.gmu.refresh();
            }
        }
    }

    public void onPause() {
        if (!bFT()) {
            this.gmu.setPrimary(false);
        } else if (this.gzf != null) {
            Fragment currentFragment = this.gzf.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.gzd);
        if (this.gmu != null) {
            this.gmu.onChangeSkinType(i);
        }
        if (this.gzf != null) {
            this.gzf.onChangeSkinType(i);
        }
        bFP();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gze != null && this.gze.gDr) {
                this.gze.gDr = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            } else if (bFT() && this.gzf != null && this.gzf.bCI()) {
                this.gzf.bCV();
                UtilHelper.setNavigationBarBackground(this.gzd, this.gzf.bCQ());
            } else if (this.gmu != null && this.gmu.isAdded()) {
                if (this.gmu.onKeyDown(i, keyEvent)) {
                    return true;
                }
                bFS();
            } else {
                return this.gzd.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.gmu != null && this.gmu.isAdded()) {
                return this.gmu.onKeyDown(i, keyEvent);
            }
        } else {
            return this.gzd.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFS() {
        if (this.gmx != this.gmw && bFT()) {
            this.gzf.setCurrentTab(this.gmw);
            if (sJ(this.gmw) != 1) {
                this.gmu.kU(false);
            }
            this.gmx = this.gmw;
            a(this.gzf.getCurrentFragment(), this.gmw);
            return;
        }
        this.gmu.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!bFT()) {
            this.gmu.onActivityResult(i, i2, intent);
        } else if (this.gzf != null) {
            if (1 == this.gzf.getCurrentTabType()) {
                this.gmu.onActivityResult(i, i2, intent);
            } else {
                this.gzf.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.czt().A(this.gzd.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.gzi != null) {
                        this.gzi.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void aIV() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.gzd != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.gzd.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.czt().A(this.gzd.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!bFT()) {
            return this.gmu.getVoiceManager();
        }
        if (this.gzf == null) {
            return null;
        }
        Fragment currentFragment = this.gzf.getCurrentFragment();
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
    public int sH(int i) {
        if (this.gmt == null) {
            return -1;
        }
        int count = v.getCount(this.gmt.bDd());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.gmt.bDd().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sJ(int i) {
        if (this.gmt != null && i < v.getCount(this.gmt.bDd())) {
            return this.gmt.bDd().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bAB() {
        return this.gmu;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bAC() {
        if (!bFT()) {
            if (this.gmu instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.gmu).bAC();
            }
        } else if (this.gzf == null) {
            return null;
        } else {
            Fragment currentFragment = this.gzf.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).bAC();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(o.glQ);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gzd.isLoadingViewAttached()) {
            this.gzd.hideLoadingView(this.gzd.findViewById(16908290));
        }
        if (this.gzw != null) {
            e.gy().removeCallbacks(this.gzw);
        }
        com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean(this.gzh, false);
        if (this.gzi != null) {
            this.gzi.cancelLoadData();
        }
        if (this.gmu != null && this.gmu.bBd() != null) {
            this.gmu.bBd().afZ();
        }
        if (this.gzp != null) {
            this.gzp.onDestroy();
        }
    }

    public FragmentTabHost bCT() {
        if (this.gzf == null) {
            return null;
        }
        return this.gzf.bCT();
    }

    public boolean bFT() {
        if (this.gzl == null) {
            return false;
        }
        return this.gzl.getItem(0) instanceof FrsTabHostFragment;
    }

    private boolean bFU() {
        if (this.gzl == null) {
            return false;
        }
        return this.gzl.getItem(1) instanceof FrsLiteProgramListFragment;
    }

    public void sM(int i) {
        this.gmw = i;
    }

    public void ts(int i) {
        this.gmx = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFV() {
        if (this.gzd != null) {
            if (this.gzp == null) {
                this.gzp = (NavigationBarCoverTip) this.gzd.findViewById(R.id.navigation_cover_tip);
            }
            if (this.gzp != null) {
                View inflate = View.inflate(this.gzd, R.layout.write_thread_share_guide, null);
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
                am.setBackgroundColor(this.gzp, R.color.cp_link_tip_a_alpha95);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new an("c13439").aDT();
                        if (FrsTabController.this.bAB() != null && !TextUtils.isEmpty(FrsTabController.this.bAB().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.gzd != null) {
                            if (FrsTabController.this.gzp != null) {
                                FrsTabController.this.gzp.hideTip();
                            }
                            ba.aEa().b(FrsTabController.this.gzd.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.bAB().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.aCY().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.gzp.a(this.gzd, inflate, 30000);
                new an("c13438").aDT();
                int i = com.baidu.tbadk.core.sharedPref.b.aCY().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.aCY().putInt("key_bawu_task_toast", i + 1);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<BaseFragment> mFragments;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mFragments = new ArrayList(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v4.app.FragmentStatePagerAdapter
        /* renamed from: tt */
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

        public BaseFragment AS(String str) {
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

        public BaseFragment tu(int i) {
            return (BaseFragment) v.remove(this.mFragments, i);
        }

        public String tv(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!bFT()) {
            return this.gmu.getTbPageTag();
        }
        if (this.gzf != null) {
            if (1 == this.gzf.getCurrentTabType()) {
                return this.gmu.getTbPageTag();
            }
            Fragment currentFragment = this.gzf.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }
}
