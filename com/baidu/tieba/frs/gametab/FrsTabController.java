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
    public static final String fKL = FrsFragment.class.getSimpleName();
    public static final String fKM = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String fKN = FrsTabHostFragment.class.getSimpleName();
    private FrsActivity fKO;
    private FrsLiteProgramListFragment fKP;
    private FrsTabHostFragment fKQ;
    private ShareSuccessReplyToServerModel fKT;
    private FrsBaseViewPager fKV;
    private FragmentAdapter fKW;
    private OvalActionButton fKX;
    private boolean fKY;
    private boolean fKZ;
    private NavigationBarCoverTip fLa;
    private ab fxW;
    private FrsFragment fxX;
    private l fxY;
    private int fya;
    private FRSRefreshButton fyc;
    private String mForumName;
    private boolean fKR = false;
    private final Handler mHandler = new Handler();
    private int fxZ = 0;
    private boolean fKU = false;
    private boolean fLb = false;
    private com.baidu.adp.framework.listener.a fLc = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            l lVar = null;
            if (!FrsTabController.this.fKR && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    lVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    lVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (lVar != null) {
                    FrsTabController.this.fKR = true;
                    FrsTabController.this.e(lVar);
                    if (lVar != null && lVar.getForum() != null && !StringUtils.isNull(lVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.agA().bH("2", lVar.getForum().getId());
                    }
                }
            }
        }
    };
    private CustomMessageListener fLd = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.fKR && FrsTabController.this.fxY == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                l lVar = (l) customResponsedMessage.getData();
                if (lVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(lVar.getForum().getName())) {
                    FrsTabController.this.e(lVar);
                }
            }
        }
    };
    private CustomMessageListener fLe = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.bov();
        }
    };
    private CustomMessageListener fLf = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int qB;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    qB = FrsTabController.this.qB(9);
                    if (qB == -1) {
                        qB = FrsTabController.this.qB(2);
                    }
                } else {
                    qB = FrsTabController.this.qB(intValue);
                }
                if (qB != -1 && FrsTabController.this.bow() && FrsTabController.this.fKQ != null) {
                    FrsTabController.this.fKQ.setCurrentTab(qB);
                    if (FrsTabController.this.qD(qB) != 1) {
                        FrsTabController.this.fxX.jI(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener fLg = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.isEmpty(newNotifyData) && FrsTabController.this.fKQ != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.fxW.blH().size(); i++) {
                                FragmentTabHost.b il = FrsTabController.this.fKQ.il(i);
                                if (il != null && il.mType != 1 && il.mType != FrsTabController.this.fKQ.getCurrentTabType() && il.mType == aVar.getTabId() && aVar.bon() && il.chu.qa(String.valueOf(il.mType)) != null) {
                                    il.chu.qa(String.valueOf(il.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable fLh = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        @Override // java.lang.Runnable
        public void run() {
            e.fZ().removeCallbacks(this);
            FrsTabController.this.bou();
            e.fZ().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.fKU = true;
            }
        }
    };
    private CustomMessageListener fLi = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!i.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.fKV != null && FrsTabController.this.fKW != null && FrsTabController.this.fKW.wd(FrsTabController.fKM) != null) {
                if (!j.isNetWorkAvailable()) {
                    FrsTabController.this.fKO.showToast(FrsTabController.this.fKO.getString(R.string.neterror));
                } else if ((FrsTabController.this.bjh().bkn().smartAppAvatar == null || FrsTabController.this.bjh().bkn().smartAppAvatar.size() != 1) && (FrsTabController.this.bjh().bkn().smartAppAvatar != null || FrsTabController.this.bjh().bkn().smartApp == null)) {
                    FrsTabController.this.fKV.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.bjh().bkn().smartApp;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                        FrsTabController.this.fKV.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new an("c13274").bS("fid", FrsTabController.this.bjh().getForumId()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("obj_name", FrsTabController.this.bjh().bkn().smartApp.name).p("obj_id", FrsTabController.this.bjh().bkn().smartApp.swan_app_id.longValue()).bS("obj_source", "frs_Bside").O("obj_param1", FrsTabController.this.bjh().bkn().smartApp.is_game.intValue()));
                    }
                }
            }
        }
    };
    private CustomMessageListener fLj = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fKV != null && FrsTabController.this.fKW != null && FrsTabController.this.fKW.wd(FrsTabController.fKM) != null) {
                FrsTabController.this.fKV.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener fLk = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fKV != null && FrsTabController.this.fKW != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.fKY = aVar.blE();
                FrsTabController.this.fKZ = aVar.blF();
            }
        }
    };
    private CustomMessageListener fLl = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fKV != null && FrsTabController.this.fKW != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.fKV.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener fLm = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.fxX.bkl();
                FrsTabController.this.boo();
                if (FrsTabController.this.bjh() != null) {
                    FrsTabController.this.bjh().jC(true);
                }
                FrsTabController.this.fKX.setVisibility(8);
                return;
            }
            FrsTabController.this.fKX.setVisibility(0);
            if (FrsTabController.this.bjh() != null) {
                FrsTabController.this.bjh().jC(false);
            }
            FrsTabController.this.fxX.bkm();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.fKZ = false;
                    FrsTabController.this.fKV.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a fLn = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void bjx() {
            if (FrsTabController.this.fKV != null) {
                if (FrsTabController.this.fKV.getCurrentItem() == 0) {
                    FrsTabController.this.fKV.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.fKV.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean bjy() {
            SmartApp smartApp;
            if (FrsTabController.this.fKV.getCurrentItem() == 0) {
                if (FrsTabController.this.fKY && FrsTabController.this.fKZ) {
                    FrsTabController.this.fKV.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.fKZ) {
                    FrsTabController.this.fKV.setmDisallowSlip(true);
                }
                FrsTabController.this.fKV.setmDisallowSlip(true);
            } else {
                FrsTabController.this.fKV.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.bjh().bkn().smartAppAvatar == null || FrsTabController.this.bjh().bkn().smartAppAvatar.size() != 1) && (FrsTabController.this.bjh().bkn().smartAppAvatar != null || FrsTabController.this.bjh().bkn().smartApp == null)) || (smartApp = FrsTabController.this.bjh().bkn().smartApp) == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                return true;
            }
            TiebaStatic.log(new an("c13274").bS("fid", FrsTabController.this.bjh().getForumId()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("obj_name", FrsTabController.this.bjh().bkn().smartApp.name).p("obj_id", FrsTabController.this.bjh().bkn().smartApp.swan_app_id.longValue()).bS("obj_source", "frs_Bside").O("obj_param1", FrsTabController.this.bjh().bkn().smartApp.is_game.intValue()));
            return false;
        }
    };
    private String fKS = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    /* JADX INFO: Access modifiers changed from: private */
    public void boo() {
        if (this.fKP != null && bjh() != null) {
            this.fKP.fPe = true;
            this.fKP.clear();
            if (!j.isNetWorkAvailable()) {
                this.fKP.wu(bjh().getForumId());
            } else if ((bjh().bkn().smartAppAvatar != null && bjh().bkn().smartAppAvatar.size() == 1) || (bjh().bkn().smartAppAvatar == null && bjh().bkn().smartApp != null)) {
                SmartApp smartApp = bjh().bkn().smartApp;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                    String str = null;
                    if (bjh().bkn() != null && bjh().bkn().smartApp != null) {
                        str = bjh().bkn().smartApp.h5_url;
                    }
                    this.fKP.wv(str);
                }
                TiebaStatic.log(new an("c13274").bS("fid", bjh().getForumId()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("obj_name", bjh().bkn().smartApp.name).p("obj_id", bjh().bkn().smartApp.swan_app_id.longValue()).bS("obj_source", "frs_Bside").O("obj_param1", bjh().bkn().smartApp.is_game.intValue()));
            } else {
                this.fKP.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.fKP;
                String forumId = bjh().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.fKP;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.fKP;
                frsLiteProgramListFragment.s(forumId, 1, 10);
                TiebaStatic.log(new an("c13273").bS("fid", bjh().getForumId()).bS("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.fKO = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.fKO != null) {
            this.fKO.setContentView(R.layout.frs_base_layout);
            this.fKV = (FrsBaseViewPager) this.fKO.findViewById(R.id.frs_base_viewpager);
            this.fKW = new FragmentAdapter(this.fKO.getSupportFragmentManager());
            this.fKV.setAdapter(this.fKW);
            this.fKV.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.fKV.addOnPageChangeListener(this.fLm);
            this.fKV.setmDisallowSlip(true);
            this.fKV.setOnTouchEventListener(this.fLn);
            this.fKX = (OvalActionButton) this.fKO.findViewById(R.id.frs_post_forum_button);
            this.fyc = (FRSRefreshButton) this.fKO.findViewById(R.id.frs_refresh_forum_button);
            this.fKO.registerListener(this.fLk);
            this.fKO.registerListener(this.fLl);
            this.fKO.registerListener(this.fLi);
            this.fKO.registerListener(this.fLj);
            this.fLc.getHttpMessageListener().setPriority(-1);
            this.fLc.getSocketMessageListener().setPriority(-1);
            this.fKO.registerListener(this.fLd);
            this.fLf.setSelfListener(true);
            this.fKO.registerListener(this.fLf);
            this.fLe.setSelfListener(true);
            this.fKO.registerListener(this.fLe);
            this.fKO.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.fKO.getIntent().getStringExtra("name");
                this.fxZ = this.fKO.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.fxZ = bundle.getInt("default_tab_id", 0);
            }
            O(bundle);
            this.fKW.notifyDataSetChanged();
            this.fKT = new ShareSuccessReplyToServerModel();
            this.fKO.registerListener(this.fLc);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.fxZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.fKW != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.fKW.wd(fKL);
                if (frsFragment == null) {
                    frsFragment = P(bundle);
                }
                frsFragment.b(this.fKX);
                frsFragment.a(this.fyc);
                if (!fKL.equals(this.fKW.rp(0))) {
                    if (fKN.equals(this.fKW.rp(0))) {
                        this.fKW.ro(0);
                    }
                    this.fKW.a(0, frsFragment);
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
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.fKW == null) {
                return false;
            }
            if (fKM.equals(this.fKW.rp(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.fKW.wd(fKM);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = boq();
                }
                this.fKW.a(1, frsLiteProgramListFragment);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bop() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.fKW != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.fKW.wd(fKN);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = bor();
                }
                frsTabHostFragment.b(this.fKX);
                frsTabHostFragment.b(this.fyc);
                if (!fKN.equals(this.fKW.rp(0))) {
                    if (fKL.equals(this.fKW.rp(0))) {
                        this.fKW.ro(0);
                    }
                    this.fKW.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment P(Bundle bundle) {
        if (this.fxX == null) {
            this.fxX = new FrsFragment();
            this.fxX.setArguments(bundle);
            this.fxX.setBaseTag(fKL);
        }
        this.fxX.fuG = false;
        return this.fxX;
    }

    private FrsLiteProgramListFragment boq() {
        if (this.fKP == null) {
            this.fKP = new FrsLiteProgramListFragment();
            this.fKP.setBaseTag(fKM);
        }
        return this.fKP;
    }

    private FrsTabHostFragment bor() {
        if (this.fKQ == null) {
            this.fKQ = new FrsTabHostFragment(this);
            this.fKQ.setBaseTag(fKN);
            this.fKQ.qG(this.fxZ);
        }
        return this.fKQ;
    }

    private FragmentManager getFragmentManager() {
        if (this.fKO != null) {
            return this.fKO.getSupportFragmentManager();
        }
        return null;
    }

    private void bos() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fxY != null && (themeColorInfo = this.fxY.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1 || skinType == 4) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.fKX.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
            this.fyc.setIconFade(R.drawable.icon_frs_refresh_n);
            this.fyc.setShadowColor(am.getColor(R.color.cp_mask_c_alpha25));
            this.fyc.setColor(R.color.cp_bg_line_h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final l lVar) {
        if (lVar != null && lVar.getForum() != null) {
            if (lVar.getForum().getIsShowBawuTask()) {
                int i = com.baidu.tbadk.core.sharedPref.b.alP().getInt("key_bawu_task_toast", 0);
                if (i >= 0 && i < 1 && !this.fLb) {
                    this.fLb = true;
                    e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsTabController.this.boy();
                        }
                    }, StatisticConfig.MIN_UPLOAD_INTERVAL);
                } else {
                    return;
                }
            }
            this.fxY = lVar;
            if (v.getCount(lVar.getGameTabInfo()) > 0) {
                if (!this.fKO.isLoadingViewAttached() && !bow()) {
                    this.fKO.showLoadingView(this.fKO.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean d = FrsTabController.this.d(lVar);
                        FrsTabController.this.f(lVar);
                        boolean cs = FrsTabController.this.cs(FrsTabController.this.fxY.getGameTabInfo());
                        if (d || cs) {
                            FrsTabController.this.fKW.notifyDataSetChanged();
                            if (cs && FrsTabController.this.fKQ != null) {
                                FrsTabController.this.fKQ.L(FrsTabController.this.fxX);
                                FrsTabController.this.fKQ.a(FrsTabController.this.fxY, FrsTabController.this.fxW);
                            }
                        }
                    }
                });
            } else if (bow()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.d(lVar);
                        FrsTabController.this.fxX.fuG = true;
                        if (FrsTabController.this.fxX != null) {
                            bundle = FrsTabController.this.fxX.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.O(bundle);
                        FrsTabController.this.fKW.notifyDataSetChanged();
                        FrsTabController.this.f(lVar);
                    }
                });
            } else if (lVar != null && (lVar.smartApp != null || !v.isEmpty(lVar.smartAppAvatar))) {
                if (!this.fKO.isLoadingViewAttached() && !box()) {
                    this.fKO.showLoadingView(this.fKO.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsTabController.this.d(lVar)) {
                            FrsTabController.this.f(lVar);
                            FrsTabController.this.fKW.notifyDataSetChanged();
                        }
                        if (FrsTabController.this.fKO.isLoadingViewAttached()) {
                            FrsTabController.this.fKO.hideLoadingView(FrsTabController.this.fKO.findViewById(16908290));
                        }
                    }
                });
            }
            bos();
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
        if (this.fKO.isLoadingViewAttached()) {
            this.fKO.hideLoadingView(this.fKO.findViewById(16908290));
        }
        if (bow()) {
            return false;
        }
        this.fxX.fuG = true;
        bot();
        if (com.baidu.tbadk.core.sharedPref.b.alP().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean("frs_game_login_tip", false);
        }
        ct(list);
        return true;
    }

    private void bot() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.fKO.registerListener(1021074, this.fLg);
    }

    private void ct(List<FrsTabInfo> list) {
        boolean z;
        if (!v.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(FrsTabController.this.fKS, true)) {
                            e.fZ().post(FrsTabController.this.fLh);
                        }
                        ((ab) customResponsedMessage.getData()).b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                            @Override // com.baidu.tbadk.mainTab.b
                            public boolean isAvailable() {
                                return true;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public com.baidu.tbadk.mainTab.c avw() {
                                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", FrsTabController.this.fxX.getForumName());
                                bundle.putString("from", FrsTabController.this.fxX.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.fxX.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.fxY.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.fxY.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.fxY.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.fxY);
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
                                this.cJk = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
                                this.cJk.setTextSize(2.0f);
                                return this.cJk;
                            }
                        });
                        FrsTabController.this.bop();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.fKO.registerListener(customMessageListener);
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
            this.fxW = new ab(this.fKO.getActivity(), arrayList);
            if (bjh() != null) {
                this.fxW.setForumId(bjh().getForumId());
                this.fxW.setForumName(bjh().getForumName());
                if (bjh().bkn() != null && bjh().bkn().getForum() != null) {
                    ForumData forum = bjh().bkn().getForum();
                    this.fxW.setForumGameLabel(forum.getForumGameLabel());
                    this.fxW.vP(forum.getSpecialForumType());
                }
            }
            this.fxX.fuG = false;
            new d(this.fxX).a(this.fxW);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.fxW);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.fKO.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bou() {
        if (this.fxW != null && !TextUtils.isEmpty(this.fxW.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.fxY.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar aKP;
        if ((fragment instanceof ah) && this.fxY != null && this.fxY.getForum() != null && (aKP = ((ah) fragment).aKP()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.fxY.getForum().getName(), 5, true, true) + this.fKO.getActivity().getString(R.string.forum));
            aKP.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.fxX instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fxX.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ln(int i) {
        if (this.fxX instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.fxX.ln(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.fxX instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fxX.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.fxX != null) {
            this.fxX.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!bow()) {
            this.fxX.setPrimary(true);
        } else if (this.fKQ != null) {
            Fragment currentFragment = this.fKQ.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.fKU) {
            this.fKU = false;
            if (this.fxX != null) {
                this.fxX.refresh();
            }
        }
    }

    public void onPause() {
        if (!bow()) {
            this.fxX.setPrimary(false);
        } else if (this.fKQ != null) {
            Fragment currentFragment = this.fKQ.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.fKO);
        if (this.fxX != null) {
            this.fxX.onChangeSkinType(i);
        }
        if (this.fKQ != null) {
            this.fKQ.onChangeSkinType(i);
        }
        bos();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fKP != null && this.fKP.fPe) {
                this.fKP.fPe = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            } else if (bow() && this.fKQ != null && this.fKQ.bly()) {
                this.fKQ.blz();
                UtilHelper.setNavigationBarBackground(this.fKO, this.fKQ.blt());
            } else if (this.fxX != null && this.fxX.isAdded()) {
                if (this.fxX.onKeyDown(i, keyEvent)) {
                    return true;
                }
                bov();
            } else {
                return this.fKO.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.fxX != null && this.fxX.isAdded()) {
                return this.fxX.onKeyDown(i, keyEvent);
            }
        } else {
            return this.fKO.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bov() {
        if (this.fya != this.fxZ && bow()) {
            this.fKQ.setCurrentTab(this.fxZ);
            if (qD(this.fxZ) != 1) {
                this.fxX.jI(false);
            }
            this.fya = this.fxZ;
            a(this.fKQ.getCurrentFragment(), this.fxZ);
            return;
        }
        this.fxX.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!bow()) {
            this.fxX.onActivityResult(i, i2, intent);
        } else if (this.fKQ != null) {
            if (1 == this.fKQ.getCurrentTabType()) {
                this.fxX.onActivityResult(i, i2, intent);
            } else {
                this.fKQ.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.cfn().y(this.fKO.getPageContext());
                    com.baidu.tbadk.coreExtra.c.e shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.fKT != null) {
                        this.fKT.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void arw() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.fKO != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.fKO.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.cfn().y(this.fKO.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!bow()) {
            return this.fxX.getVoiceManager();
        }
        if (this.fKQ == null) {
            return null;
        }
        Fragment currentFragment = this.fKQ.getCurrentFragment();
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
    public int qB(int i) {
        if (this.fxW == null) {
            return -1;
        }
        int count = v.getCount(this.fxW.blH());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.fxW.blH().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qD(int i) {
        if (this.fxW != null && i < v.getCount(this.fxW.blH())) {
            return this.fxW.blH().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bjh() {
        return this.fxX;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> bji() {
        if (!bow()) {
            if (this.fxX instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.fxX).bji();
            }
        } else if (this.fKQ == null) {
            return null;
        } else {
            Fragment currentFragment = this.fKQ.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).bji();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(n.fxt);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fKO.isLoadingViewAttached()) {
            this.fKO.hideLoadingView(this.fKO.findViewById(16908290));
        }
        if (this.fLh != null) {
            e.fZ().removeCallbacks(this.fLh);
        }
        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(this.fKS, false);
        if (this.fKT != null) {
            this.fKT.cancelLoadData();
        }
        if (this.fxX != null && this.fxX.bjI() != null) {
            this.fxX.bjI().aGF();
        }
        if (this.fLa != null) {
            this.fLa.onDestroy();
        }
    }

    public FragmentTabHost blw() {
        if (this.fKQ == null) {
            return null;
        }
        return this.fKQ.blw();
    }

    public boolean bow() {
        if (this.fKW == null) {
            return false;
        }
        return this.fKW.getItem(0) instanceof FrsTabHostFragment;
    }

    private boolean box() {
        if (this.fKW == null) {
            return false;
        }
        return this.fKW.getItem(1) instanceof FrsLiteProgramListFragment;
    }

    public void qG(int i) {
        this.fxZ = i;
    }

    public void rm(int i) {
        this.fya = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boy() {
        if (this.fKO != null) {
            if (this.fLa == null) {
                this.fLa = (NavigationBarCoverTip) this.fKO.findViewById(R.id.navigation_cover_tip);
            }
            if (this.fLa != null) {
                View inflate = View.inflate(this.fKO, R.layout.write_thread_share_guide, null);
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
                am.setBackgroundColor(this.fLa, R.color.cp_link_tip_a_alpha95);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new an("c13439").amI();
                        if (FrsTabController.this.bjh() != null && !TextUtils.isEmpty(FrsTabController.this.bjh().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.fKO != null) {
                            if (FrsTabController.this.fLa != null) {
                                FrsTabController.this.fLa.hideTip();
                            }
                            ba.amO().b(FrsTabController.this.fKO.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.bjh().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.alP().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.fLa.a(this.fKO, inflate, 30000);
                new an("c13438").amI();
                int i = com.baidu.tbadk.core.sharedPref.b.alP().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.alP().putInt("key_bawu_task_toast", i + 1);
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
        /* renamed from: rn */
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

        public BaseFragment ro(int i) {
            return (BaseFragment) v.remove(this.mFragments, i);
        }

        public String rp(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }
}
