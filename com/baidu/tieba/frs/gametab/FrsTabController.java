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
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment;
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
import tbclient.SmartApp;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes9.dex */
public class FrsTabController implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    public static final String gFw = FrsFragment.class.getSimpleName();
    public static final String gFx = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String gFy = FrsTabHostFragment.class.getSimpleName();
    private FrsLiteProgramListFragment gFA;
    private FrsTabHostFragment gFB;
    private ShareSuccessReplyToServerModel gFE;
    private FrsBaseViewPager gFG;
    private FragmentAdapter gFH;
    private OvalActionButton gFI;
    private boolean gFJ;
    private boolean gFK;
    private NavigationBarCoverTip gFL;
    private FrsActivity gFz;
    private ad gsC;
    private FrsFragment gsD;
    private m gsE;
    private int gsG;
    private FRSRefreshButton gsI;
    private String mForumName;
    private boolean gFC = false;
    private final Handler mHandler = new Handler();
    private int gsF = 0;
    private boolean gFF = false;
    private boolean gFM = false;
    private com.baidu.adp.framework.listener.a gFN = new com.baidu.adp.framework.listener.a(1001703, CmdConfigSocket.CMD_FRS_PAGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            m mVar = null;
            if (!FrsTabController.this.gFC && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    mVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    mVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (mVar != null) {
                    FrsTabController.this.gFC = true;
                    FrsTabController.this.f(mVar);
                    if (mVar != null && mVar.getForum() != null && !StringUtils.isNull(mVar.getForum().getId())) {
                        com.baidu.tbadk.core.business.a.aAd().cn("2", mVar.getForum().getId());
                    }
                }
            }
        }
    };
    private CustomMessageListener gFO = new CustomMessageListener(CmdConfigCustom.CMD_GET_FRS_PAGE_CACHE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.gFC && FrsTabController.this.gsE == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                m mVar = (m) customResponsedMessage.getData();
                if (mVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(mVar.getForum().getName())) {
                    FrsTabController.this.f(mVar);
                }
            }
        }
    };
    private CustomMessageListener gFP = new CustomMessageListener(CmdConfigCustom.CMD_CLICK_CLOSE_GAME_FRS_CONFIRM) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.bIL();
        }
    };
    private CustomMessageListener gFQ = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_TAB_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int sU;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    sU = FrsTabController.this.sU(9);
                    if (sU == -1) {
                        sU = FrsTabController.this.sU(2);
                    }
                } else {
                    sU = FrsTabController.this.sU(intValue);
                }
                if (sU != -1 && FrsTabController.this.bIM() && FrsTabController.this.gFB != null) {
                    FrsTabController.this.gFB.setCurrentTab(sU);
                    if (FrsTabController.this.sW(sU) != 1) {
                        FrsTabController.this.gsD.lp(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener gFR = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.isEmpty(newNotifyData) && FrsTabController.this.gFB != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.gsC.bDD().size(); i++) {
                                FragmentTabHost.b ko = FrsTabController.this.gFB.ko(i);
                                if (ko != null && ko.mType != 1 && ko.mType != FrsTabController.this.gFB.getCurrentTabType() && ko.mType == aVar.getTabId() && aVar.bID() && ko.cYv.vz(String.valueOf(ko.mType)) != null) {
                                    ko.cYv.vz(String.valueOf(ko.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable gFS = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        @Override // java.lang.Runnable
        public void run() {
            e.gx().removeCallbacks(this);
            FrsTabController.this.bIK();
            e.gx().postDelayed(this, 30000L);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.gFF = true;
            }
        }
    };
    private CustomMessageListener gFT = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!k.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.gFG != null && FrsTabController.this.gFH != null && FrsTabController.this.gFH.Bs(FrsTabController.gFx) != null) {
                if (!j.isNetWorkAvailable()) {
                    FrsTabController.this.gFz.showToast(FrsTabController.this.gFz.getString(R.string.neterror));
                } else if ((FrsTabController.this.bDq().bEz().smartAppAvatar == null || FrsTabController.this.bDq().bEz().smartAppAvatar.size() != 1) && (FrsTabController.this.bDq().bEz().smartAppAvatar != null || FrsTabController.this.bDq().bEz().smartApp == null)) {
                    FrsTabController.this.gFG.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.bDq().bEz().smartApp;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                        FrsTabController.this.gFG.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new an("c13274").cx("fid", FrsTabController.this.bDq().getForumId()).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx("obj_name", FrsTabController.this.bDq().bEz().smartApp.name).s("obj_id", FrsTabController.this.bDq().bEz().smartApp.swan_app_id.longValue()).cx("obj_source", "frs_Bside").X("obj_param1", FrsTabController.this.bDq().bEz().smartApp.is_game.intValue()));
                    }
                }
            }
        }
    };
    private CustomMessageListener gFU = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.gFG != null && FrsTabController.this.gFH != null && FrsTabController.this.gFH.Bs(FrsTabController.gFx) != null) {
                FrsTabController.this.gFG.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener gFV = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.gFG != null && FrsTabController.this.gFH != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.gFJ = aVar.bFS();
                FrsTabController.this.gFK = aVar.bFT();
            }
        }
    };
    private CustomMessageListener gFW = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.gFG != null && FrsTabController.this.gFH != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.gFG.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener gFX = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.gsD.bEx();
                FrsTabController.this.bIE();
                if (FrsTabController.this.bDq() != null) {
                    FrsTabController.this.bDq().lj(true);
                }
                FrsTabController.this.gFI.setVisibility(8);
                return;
            }
            FrsTabController.this.gFI.setVisibility(0);
            if (FrsTabController.this.bDq() != null) {
                FrsTabController.this.bDq().lj(false);
            }
            FrsTabController.this.gsD.bEy();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.gFK = false;
                    FrsTabController.this.gFG.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a gFY = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void bDG() {
            if (FrsTabController.this.gFG != null) {
                if (FrsTabController.this.gFG.getCurrentItem() == 0) {
                    FrsTabController.this.gFG.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.gFG.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean bDH() {
            SmartApp smartApp;
            if (FrsTabController.this.gFG.getCurrentItem() == 0) {
                if (FrsTabController.this.gFJ && FrsTabController.this.gFK) {
                    FrsTabController.this.gFG.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.gFK) {
                    FrsTabController.this.gFG.setmDisallowSlip(true);
                }
                FrsTabController.this.gFG.setmDisallowSlip(true);
            } else {
                FrsTabController.this.gFG.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.bDq().bEz().smartAppAvatar == null || FrsTabController.this.bDq().bEz().smartAppAvatar.size() != 1) && (FrsTabController.this.bDq().bEz().smartAppAvatar != null || FrsTabController.this.bDq().bEz().smartApp == null)) || (smartApp = FrsTabController.this.bDq().bEz().smartApp) == null || !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                return true;
            }
            TiebaStatic.log(new an("c13274").cx("fid", FrsTabController.this.bDq().getForumId()).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx("obj_name", FrsTabController.this.bDq().bEz().smartApp.name).s("obj_id", FrsTabController.this.bDq().bEz().smartApp.swan_app_id.longValue()).cx("obj_source", "frs_Bside").X("obj_param1", FrsTabController.this.bDq().bEz().smartApp.is_game.intValue()));
            return false;
        }
    };
    private String gFD = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.SHOW_GAME_FOREM_TAB_HOT_POINT);

    /* JADX INFO: Access modifiers changed from: private */
    public void bIE() {
        if (this.gFA != null && bDq() != null) {
            this.gFA.gJY = true;
            this.gFA.clear();
            if (!j.isNetWorkAvailable()) {
                this.gFA.BJ(bDq().getForumId());
            } else if ((bDq().bEz().smartAppAvatar != null && bDq().bEz().smartAppAvatar.size() == 1) || (bDq().bEz().smartAppAvatar == null && bDq().bEz().smartApp != null)) {
                SmartApp smartApp = bDq().bEz().smartApp;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.b(smartApp.id, smartApp.link, "1191003700000000", smartApp.is_game)) {
                    String str = null;
                    if (bDq().bEz() != null && bDq().bEz().smartApp != null) {
                        str = bDq().bEz().smartApp.h5_url;
                    }
                    this.gFA.BK(str);
                }
                TiebaStatic.log(new an("c13274").cx("fid", bDq().getForumId()).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx("obj_name", bDq().bEz().smartApp.name).s("obj_id", bDq().bEz().smartApp.swan_app_id.longValue()).cx("obj_source", "frs_Bside").X("obj_param1", bDq().bEz().smartApp.is_game.intValue()));
            } else {
                this.gFA.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.gFA;
                String forumId = bDq().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.gFA;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.gFA;
                frsLiteProgramListFragment.u(forumId, 1, 10);
                TiebaStatic.log(new an("c13273").cx("fid", bDq().getForumId()).cx("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.gFz = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.gFz != null) {
            this.gFz.setContentView(R.layout.frs_base_layout);
            this.gFG = (FrsBaseViewPager) this.gFz.findViewById(R.id.frs_base_viewpager);
            this.gFH = new FragmentAdapter(this.gFz.getSupportFragmentManager());
            this.gFG.setAdapter(this.gFH);
            this.gFG.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.gFG.addOnPageChangeListener(this.gFX);
            this.gFG.setmDisallowSlip(true);
            this.gFG.setOnTouchEventListener(this.gFY);
            this.gFI = (OvalActionButton) this.gFz.findViewById(R.id.frs_post_forum_button);
            this.gFI.setIsCircle(true);
            this.gFI.setHasShadow(false);
            this.gsI = (FRSRefreshButton) this.gFz.findViewById(R.id.frs_refresh_forum_button);
            this.gFz.registerListener(this.gFV);
            this.gFz.registerListener(this.gFW);
            this.gFz.registerListener(this.gFT);
            this.gFz.registerListener(this.gFU);
            this.gFN.getHttpMessageListener().setPriority(-1);
            this.gFN.getSocketMessageListener().setPriority(-1);
            this.gFz.registerListener(this.gFO);
            this.gFQ.setSelfListener(true);
            this.gFz.registerListener(this.gFQ);
            this.gFP.setSelfListener(true);
            this.gFz.registerListener(this.gFP);
            this.gFz.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.gFz.getIntent().getStringExtra("name");
                this.gsF = this.gFz.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.gsF = bundle.getInt("default_tab_id", 0);
            }
            ah(bundle);
            this.gFH.notifyDataSetChanged();
            this.gFE = new ShareSuccessReplyToServerModel();
            this.gFz.registerListener(this.gFN);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.gsF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.gFH != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.gFH.Bs(gFw);
                if (frsFragment == null) {
                    frsFragment = ai(bundle);
                }
                frsFragment.b(this.gFI);
                frsFragment.a(this.gsI);
                if (!gFw.equals(this.gFH.tM(0))) {
                    if (gFy.equals(this.gFH.tM(0))) {
                        this.gFH.tL(0);
                    }
                    this.gFH.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(m mVar) {
        if (mVar != null && (mVar.smartApp != null || !v.isEmpty(mVar.smartAppAvatar))) {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.gFH == null) {
                return false;
            }
            if (gFx.equals(this.gFH.tM(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.gFH.Bs(gFx);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = bIG();
                }
                this.gFH.a(1, frsLiteProgramListFragment);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIF() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.gFH != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.gFH.Bs(gFy);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = bIH();
                }
                frsTabHostFragment.b(this.gFI);
                frsTabHostFragment.b(this.gsI);
                if (!gFy.equals(this.gFH.tM(0))) {
                    if (gFw.equals(this.gFH.tM(0))) {
                        this.gFH.tL(0);
                    }
                    this.gFH.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment ai(Bundle bundle) {
        if (this.gsD == null) {
            this.gsD = new FrsFragment();
            this.gsD.setArguments(bundle);
            this.gsD.setBaseTag(gFw);
        }
        this.gsD.gpr = false;
        return this.gsD;
    }

    private FrsLiteProgramListFragment bIG() {
        if (this.gFA == null) {
            this.gFA = new FrsLiteProgramListFragment();
            this.gFA.setBaseTag(gFx);
        }
        return this.gFA;
    }

    private FrsTabHostFragment bIH() {
        if (this.gFB == null) {
            this.gFB = new FrsTabHostFragment(this);
            this.gFB.setBaseTag(gFy);
            this.gFB.sZ(this.gsF);
        }
        return this.gFB;
    }

    private FragmentManager getFragmentManager() {
        if (this.gFz != null) {
            return this.gFz.getSupportFragmentManager();
        }
        return null;
    }

    private void bII() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.gsE != null && (themeColorInfo = this.gsE.getForum().getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.gFI.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final m mVar) {
        if (mVar != null && mVar.getForum() != null) {
            if (mVar.getForum().getIsShowBawuTask()) {
                int i = com.baidu.tbadk.core.sharedPref.b.aFH().getInt("key_bawu_task_toast", 0);
                if (i >= 0 && i < 1 && !this.gFM) {
                    this.gFM = true;
                    e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FrsTabController.this.bIN();
                        }
                    }, 30000L);
                } else {
                    return;
                }
            }
            this.gsE = mVar;
            if (this.gFz.getIntent() == null || this.gFz.getIntent().getParcelableExtra("key_uri") != null) {
            }
            if (v.getCount(mVar.getGameTabInfo()) > 0) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean e = FrsTabController.this.e(mVar);
                        FrsTabController.this.g(mVar);
                        boolean ck = FrsTabController.this.ck(FrsTabController.this.gsE.getGameTabInfo());
                        if (e || ck) {
                            FrsTabController.this.gFH.notifyDataSetChanged();
                            if (ck && FrsTabController.this.gFB != null) {
                                FrsTabController.this.gFB.M(FrsTabController.this.gsD);
                                FrsTabController.this.gFB.a(FrsTabController.this.gsE, FrsTabController.this.gsC);
                            }
                        }
                        if (FrsTabController.this.gFz.isLoadingViewAttached()) {
                            FrsTabController.this.gFz.hideLoadingView(FrsTabController.this.gFz.findViewById(16908290));
                        }
                    }
                });
            } else if (bIM()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.e(mVar);
                        FrsTabController.this.gsD.gpr = true;
                        if (FrsTabController.this.gsD != null) {
                            bundle = FrsTabController.this.gsD.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.ah(bundle);
                        FrsTabController.this.gFH.notifyDataSetChanged();
                        FrsTabController.this.g(mVar);
                        if (FrsTabController.this.gFz.isLoadingViewAttached()) {
                            FrsTabController.this.gFz.hideLoadingView(FrsTabController.this.gFz.findViewById(16908290));
                        }
                    }
                });
            } else if (mVar != null && (mVar.smartApp != null || !v.isEmpty(mVar.smartAppAvatar))) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsTabController.this.e(mVar)) {
                            FrsTabController.this.g(mVar);
                            FrsTabController.this.gFH.notifyDataSetChanged();
                        }
                        if (FrsTabController.this.gFz.isLoadingViewAttached()) {
                            FrsTabController.this.gFz.hideLoadingView(FrsTabController.this.gFz.findViewById(16908290));
                        }
                    }
                });
            }
            bII();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(m mVar) {
        if (mVar != null) {
            if (mVar.smartApp != null || !v.isEmpty(mVar.smartAppAvatar)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ck(List<FrsTabInfo> list) {
        if (this.gFz.isLoadingViewAttached()) {
            this.gFz.hideLoadingView(this.gFz.findViewById(16908290));
        }
        if (bIM()) {
            return false;
        }
        this.gsD.gpr = true;
        bIJ();
        if (com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.FRS_LOGIN_TIP, true);
            com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean("frs_game_login_tip", false);
        }
        cl(list);
        return true;
    }

    private void bIJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.gFz.registerListener(1021074, this.gFR);
    }

    private void cl(List<FrsTabInfo> list) {
        boolean z;
        if (!v.isEmpty(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(FrsTabController.this.gFD, true)) {
                            e.gx().post(FrsTabController.this.gFS);
                        }
                        ((ad) customResponsedMessage.getData()).b(new com.baidu.tbadk.mainTab.b() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                            @Override // com.baidu.tbadk.mainTab.b
                            public boolean isAvailable() {
                                return true;
                            }

                            @Override // com.baidu.tbadk.mainTab.b
                            public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
                                FrsSportsRecommendFragment frsSportsRecommendFragment = new FrsSportsRecommendFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", FrsTabController.this.gsD.getForumName());
                                bundle.putString("from", FrsTabController.this.gsD.getFrom());
                                bundle.putString("forum_id", FrsTabController.this.gsD.getForumId());
                                bundle.putInt("tab_id", 503);
                                bundle.putBoolean("can_auto_play_video", FrsTabController.this.gsE.isFrsVideoAutoPlay);
                                bundle.putBoolean("need_log", FrsTabController.this.gsE.needLog == 1);
                                bundle.putBoolean("is_brand_forum", FrsTabController.this.gsE.isBrandForum);
                                FrsViewData frsViewData = new FrsViewData();
                                frsViewData.receiveData(FrsTabController.this.gsE);
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
                        FrsTabController.this.bIF();
                    }
                }
            };
            customMessageListener.setPriority(Integer.MAX_VALUE);
            customMessageListener.setSelfListener(true);
            this.gFz.registerListener(customMessageListener);
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
            this.gsC = new ad(this.gFz.getActivity(), arrayList);
            if (bDq() != null) {
                this.gsC.setForumId(bDq().getForumId());
                this.gsC.setForumName(bDq().getForumName());
                if (bDq().bEz() != null && bDq().bEz().getForum() != null) {
                    ForumData forum = bDq().bEz().getForum();
                    this.gsC.setForumGameLabel(forum.getForumGameLabel());
                    this.gsC.zF(forum.getSpecialForumType());
                }
            }
            this.gsD.gpr = false;
            new d(this.gsD).a(this.gsC);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB, this.gsC);
            CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB);
            customMessage.setTag(this.gFz.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIK() {
        if (this.gsC != null && !TextUtils.isEmpty(this.gsC.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.gsE.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar beR;
        if ((fragment instanceof aj) && this.gsE != null && this.gsE.getForum() != null && (beR = ((aj) fragment).beR()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.gsE.getForum().getName(), 5, true, true) + this.gFz.getActivity().getString(R.string.forum));
            beR.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.gsD instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.gsD.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a nU(int i) {
        if (this.gsD instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.gsD.nU(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.gsD instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.gsD.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.gsD != null) {
            this.gsD.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!bIM()) {
            this.gsD.setPrimary(true);
        } else if (this.gFB != null) {
            Fragment currentFragment = this.gFB.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.gFF) {
            this.gFF = false;
            if (this.gsD != null) {
                this.gsD.refresh();
            }
        }
    }

    public void onPause() {
        if (!bIM()) {
            this.gsD.setPrimary(false);
        } else if (this.gFB != null) {
            Fragment currentFragment = this.gFB.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.gFz);
        if (this.gsD != null) {
            this.gsD.onChangeSkinType(i);
        }
        if (this.gFB != null) {
            this.gFB.onChangeSkinType(i);
        }
        bII();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gFA != null && this.gFA.gJY) {
                this.gFA.gJY = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            } else if (bIM() && this.gFB != null && this.gFB.bFA()) {
                this.gFB.bFN();
                UtilHelper.setNavigationBarBackground(this.gFz, this.gFB.bFI());
            } else if (this.gsD != null && this.gsD.isAdded()) {
                if (this.gsD.onKeyDown(i, keyEvent)) {
                    return true;
                }
                bIL();
            } else {
                return this.gFz.b(i, keyEvent);
            }
        } else if (i == 24) {
            if (this.gsD != null && this.gsD.isAdded()) {
                return this.gsD.onKeyDown(i, keyEvent);
            }
        } else {
            return this.gFz.b(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIL() {
        if (this.gsG != this.gsF && bIM()) {
            this.gFB.setCurrentTab(this.gsF);
            if (sW(this.gsF) != 1) {
                this.gsD.lp(false);
            }
            this.gsG = this.gsF;
            a(this.gFB.getCurrentFragment(), this.gsF);
            return;
        }
        this.gsD.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!bIM()) {
            this.gsD.onActivityResult(i, i2, intent);
        } else if (this.gFB != null) {
            if (1 == this.gFB.getCurrentTabType()) {
                this.gsD.onActivityResult(i, i2, intent);
            } else {
                this.gFB.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.o.a.cCv().B(this.gFz.getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.gFE != null) {
                        this.gFE.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void aLP() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.gFz != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.gFz.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.o.a.cCv().B(this.gFz.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!bIM()) {
            return this.gsD.getVoiceManager();
        }
        if (this.gFB == null) {
            return null;
        }
        Fragment currentFragment = this.gFB.getCurrentFragment();
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
    public int sU(int i) {
        if (this.gsC == null) {
            return -1;
        }
        int count = v.getCount(this.gsC.bDD());
        for (int i2 = 0; i2 < count; i2++) {
            if (this.gsC.bDD().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sW(int i) {
        if (this.gsC != null && i < v.getCount(this.gsC.bDD())) {
            return this.gsC.bDD().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bDq() {
        return this.gsD;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bDr() {
        if (!bIM()) {
            if (this.gsD instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.gsD).bDr();
            }
        } else if (this.gFB == null) {
            return null;
        } else {
            Fragment currentFragment = this.gFB.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).bDr();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(p.grZ);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gFz.isLoadingViewAttached()) {
            this.gFz.hideLoadingView(this.gFz.findViewById(16908290));
        }
        if (this.gFS != null) {
            e.gx().removeCallbacks(this.gFS);
        }
        com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(this.gFD, false);
        if (this.gFE != null) {
            this.gFE.cancelLoadData();
        }
        if (this.gsD != null && this.gsD.bDT() != null) {
            this.gsD.bDT().aiL();
        }
        if (this.gFL != null) {
            this.gFL.onDestroy();
        }
    }

    public FragmentTabHost bFL() {
        if (this.gFB == null) {
            return null;
        }
        return this.gFB.bFL();
    }

    public boolean bIM() {
        if (this.gFH == null) {
            return false;
        }
        return this.gFH.getItem(0) instanceof FrsTabHostFragment;
    }

    public void sZ(int i) {
        this.gsF = i;
    }

    public void tJ(int i) {
        this.gsG = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIN() {
        if (this.gFz != null) {
            if (this.gFL == null) {
                this.gFL = (NavigationBarCoverTip) this.gFz.findViewById(R.id.navigation_cover_tip);
            }
            if (this.gFL != null) {
                View inflate = View.inflate(this.gFz, R.layout.write_thread_share_guide, null);
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
                am.setBackgroundColor(this.gFL, R.color.cp_link_tip_a_alpha95);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
                    /* JADX DEBUG: Multi-variable search result rejected for r4v9, resolved type: com.baidu.tieba.frs.FrsActivity */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new an("c13439").aGD();
                        if (FrsTabController.this.bDq() != null && !TextUtils.isEmpty(FrsTabController.this.bDq().getForumId()) && !TextUtils.isEmpty(FrsTabController.this.mForumName) && FrsTabController.this.gFz != null) {
                            if (FrsTabController.this.gFL != null) {
                                FrsTabController.this.gFL.hideTip();
                            }
                            ba.aGK().b(FrsTabController.this.gFz.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/bawutask?fid=" + FrsTabController.this.bDq().getForumId() + "&fn=" + FrsTabController.this.mForumName + "&noread=" + (com.baidu.tbadk.core.sharedPref.b.aFH().getInt("key_bawu_task_toast", 0) == -1 ? 1 : 0)});
                        }
                    }
                });
                this.gFL.a(this.gFz, inflate, 30000);
                new an("c13438").aGD();
                int i = com.baidu.tbadk.core.sharedPref.b.aFH().getInt("key_bawu_task_toast", 0);
                if (i >= 0) {
                    com.baidu.tbadk.core.sharedPref.b.aFH().putInt("key_bawu_task_toast", i + 1);
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
        /* renamed from: tK */
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

        public BaseFragment tL(int i) {
            return (BaseFragment) v.remove(this.mFragments, i);
        }

        public String tM(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }

    public TbPageTag getTbPageTag() {
        if (!bIM()) {
            return this.gsD.getTbPageTag();
        }
        if (this.gFB != null) {
            if (1 == this.gFB.getCurrentTabType()) {
                return this.gsD.getTbPageTag();
            }
            Fragment currentFragment = this.gFB.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                return ((BaseFragment) currentFragment).getTbPageTag();
            }
        }
        return null;
    }
}
