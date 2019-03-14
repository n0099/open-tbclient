package com.baidu.tieba.frs.gametab;

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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.i;
import com.baidu.tbadk.widget.FRSRefreshButton;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
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
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.j;
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
    private ab fco;
    private FrsFragment fcp;
    private j fcq;
    private int fcs;
    private FRSRefreshButton fcu;
    private FrsActivity foC;
    private FrsLiteProgramListFragment foD;
    private FrsTabHostFragment foE;
    private ShareSuccessReplyToServerModel foH;
    private FrsBaseViewPager foJ;
    private FragmentAdapter foK;
    private OvalActionButton foL;
    private boolean foM;
    private boolean foN;
    private String mForumName;
    public static final String foz = FrsFragment.class.getSimpleName();
    public static final String foA = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String foB = FrsTabHostFragment.class.getSimpleName();
    private boolean foF = false;
    private final Handler mHandler = new Handler();
    private int fcr = 0;
    private boolean foI = false;
    private com.baidu.adp.framework.listener.a foO = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            j jVar = null;
            if (!FrsTabController.this.foF && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    jVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    jVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (jVar != null) {
                    FrsTabController.this.foF = true;
                    FrsTabController.this.d(jVar);
                }
            }
        }
    };
    private CustomMessageListener foP = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.foF && FrsTabController.this.fcq == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof j)) {
                j jVar = (j) customResponsedMessage.getData();
                if (jVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(jVar.getForum().getName())) {
                    FrsTabController.this.d(jVar);
                }
            }
        }
    };
    private CustomMessageListener foQ = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.bhb();
        }
    };
    private CustomMessageListener foR = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int qj;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    qj = FrsTabController.this.qj(9);
                    if (qj == -1) {
                        qj = FrsTabController.this.qj(2);
                    }
                } else {
                    qj = FrsTabController.this.qj(intValue);
                }
                if (qj != -1 && FrsTabController.this.bhc() && FrsTabController.this.foE != null) {
                    FrsTabController.this.foE.setCurrentTab(qj);
                    if (FrsTabController.this.ql(qj) != 1) {
                        FrsTabController.this.fcp.iX(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener foS = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.T(newNotifyData) && FrsTabController.this.foE != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.fco.beq().size(); i++) {
                                FragmentTabHost.b ha = FrsTabController.this.foE.ha(i);
                                if (ha != null && ha.mType != 1 && ha.mType != FrsTabController.this.foE.getCurrentTabType() && ha.mType == aVar.getTabId() && aVar.bgU() && ha.bHV.pq(String.valueOf(ha.mType)) != null) {
                                    ha.bHV.pq(String.valueOf(ha.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable foT = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        @Override // java.lang.Runnable
        public void run() {
            e.jH().removeCallbacks(this);
            FrsTabController.this.bha();
            e.jH().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private CustomMessageListener dgx = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.foI = true;
            }
        }
    };
    private CustomMessageListener foU = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!i.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.foJ != null && FrsTabController.this.foK != null && FrsTabController.this.foK.vp(FrsTabController.foA) != null) {
                if (!com.baidu.adp.lib.util.j.kY()) {
                    FrsTabController.this.foC.showToast(FrsTabController.this.foC.getString(d.j.neterror));
                } else if ((FrsTabController.this.bbP().bcR().smartAppAvatar == null || FrsTabController.this.bbP().bcR().smartAppAvatar.size() != 1) && (FrsTabController.this.bbP().bcR().smartAppAvatar != null || FrsTabController.this.bbP().bcR().smartApp == null)) {
                    FrsTabController.this.foJ.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.bbP().bcR().smartApp;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.H(smartApp.id, smartApp.link, "1191003700000000")) {
                        FrsTabController.this.foJ.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new am("c13274").bJ(ImageViewerConfig.FORUM_ID, FrsTabController.this.bbP().getForumId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ("obj_name", FrsTabController.this.bbP().bcR().smartApp.name).bJ(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.bbP().bcR().smartApp.id).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
                    }
                }
            }
        }
    };
    private CustomMessageListener foV = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.foJ != null && FrsTabController.this.foK != null && FrsTabController.this.foK.vp(FrsTabController.foA) != null) {
                FrsTabController.this.foJ.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener foW = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.foJ != null && FrsTabController.this.foK != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.foM = aVar.ben();
                FrsTabController.this.foN = aVar.beo();
            }
        }
    };
    private CustomMessageListener foX = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.foJ != null && FrsTabController.this.foK != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.foJ.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener foY = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.fcp.bcP();
                FrsTabController.this.bgV();
                FrsTabController.this.foL.setVisibility(8);
                return;
            }
            FrsTabController.this.foL.setVisibility(0);
            FrsTabController.this.fcp.bcQ();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.foN = false;
                    FrsTabController.this.foJ.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a foZ = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void bce() {
            if (FrsTabController.this.foJ != null) {
                if (FrsTabController.this.foJ.getCurrentItem() == 0) {
                    FrsTabController.this.foJ.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.foJ.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean bcf() {
            SmartApp smartApp;
            if (FrsTabController.this.foJ.getCurrentItem() == 0) {
                if (FrsTabController.this.foM && FrsTabController.this.foN) {
                    FrsTabController.this.foJ.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.foN) {
                    FrsTabController.this.foJ.setmDisallowSlip(true);
                }
                FrsTabController.this.foJ.setmDisallowSlip(true);
            } else {
                FrsTabController.this.foJ.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.bbP().bcR().smartAppAvatar == null || FrsTabController.this.bbP().bcR().smartAppAvatar.size() != 1) && (FrsTabController.this.bbP().bcR().smartAppAvatar != null || FrsTabController.this.bbP().bcR().smartApp == null)) || (smartApp = FrsTabController.this.bbP().bcR().smartApp) == null || !com.baidu.tieba.aiapps.a.H(smartApp.id, smartApp.link, "1191003700000000")) {
                return true;
            }
            TiebaStatic.log(new am("c13274").bJ(ImageViewerConfig.FORUM_ID, FrsTabController.this.bbP().getForumId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ("obj_name", FrsTabController.this.bbP().bcR().smartApp.name).bJ(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.bbP().bcR().smartApp.id).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
            return false;
        }
    };
    private String foG = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    /* JADX INFO: Access modifiers changed from: private */
    public void bgV() {
        if (this.foD != null && bbP() != null) {
            this.foD.fsP = true;
            this.foD.clear();
            if (!com.baidu.adp.lib.util.j.kY()) {
                this.foD.vD(bbP().getForumId());
            } else if ((bbP().bcR().smartAppAvatar != null && bbP().bcR().smartAppAvatar.size() == 1) || (bbP().bcR().smartAppAvatar == null && bbP().bcR().smartApp != null)) {
                SmartApp smartApp = bbP().bcR().smartApp;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.H(smartApp.id, smartApp.link, "1191003700000000")) {
                    String str = null;
                    if (bbP().bcR() != null && bbP().bcR().smartApp != null) {
                        str = bbP().bcR().smartApp.h5_url;
                    }
                    this.foD.vE(str);
                }
                TiebaStatic.log(new am("c13274").bJ(ImageViewerConfig.FORUM_ID, bbP().getForumId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ("obj_name", bbP().bcR().smartApp.name).bJ(VideoPlayActivityConfig.OBJ_ID, bbP().bcR().smartApp.id).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
            } else {
                this.foD.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.foD;
                String forumId = bbP().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.foD;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.foD;
                frsLiteProgramListFragment.t(forumId, 1, 10);
                TiebaStatic.log(new am("c13273").bJ(ImageViewerConfig.FORUM_ID, bbP().getForumId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.foC = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.foC != null) {
            this.foC.setContentView(d.h.frs_base_layout);
            this.foJ = (FrsBaseViewPager) this.foC.findViewById(d.g.frs_base_viewpager);
            this.foK = new FragmentAdapter(this.foC.getSupportFragmentManager());
            this.foJ.setAdapter(this.foK);
            this.foJ.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.foJ.addOnPageChangeListener(this.foY);
            this.foJ.setmDisallowSlip(true);
            this.foJ.setOnTouchEventListener(this.foZ);
            this.foL = (OvalActionButton) this.foC.findViewById(d.g.frs_post_forum_button);
            this.fcu = (FRSRefreshButton) this.foC.findViewById(d.g.frs_refresh_forum_button);
            this.foC.registerListener(this.foW);
            this.foC.registerListener(this.foX);
            this.foC.registerListener(this.foU);
            this.foC.registerListener(this.foV);
            this.foO.getHttpMessageListener().setPriority(-1);
            this.foO.getSocketMessageListener().setPriority(-1);
            this.foC.registerListener(this.foP);
            this.foR.setSelfListener(true);
            this.foC.registerListener(this.foR);
            this.foQ.setSelfListener(true);
            this.foC.registerListener(this.foQ);
            this.foC.registerListener(this.dgx);
            if (bundle == null) {
                this.mForumName = this.foC.getIntent().getStringExtra("name");
                this.fcr = this.foC.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.fcr = bundle.getInt("default_tab_id", 0);
            }
            O(bundle);
            this.foK.notifyDataSetChanged();
            this.foH = new ShareSuccessReplyToServerModel();
            this.foC.registerListener(this.foO);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.fcr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.foK != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.foK.vp(foz);
                if (frsFragment == null) {
                    frsFragment = P(bundle);
                }
                frsFragment.b(this.foL);
                frsFragment.a(this.fcu);
                if (!foz.equals(this.foK.qV(0))) {
                    if (foB.equals(this.foK.qV(0))) {
                        this.foK.qU(0);
                    }
                    this.foK.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(j jVar) {
        if (jVar != null && (jVar.smartApp != null || !v.T(jVar.smartAppAvatar))) {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.foK == null) {
                return false;
            }
            if (foA.equals(this.foK.qV(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.foK.vp(foA);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = bgX();
                }
                this.foK.a(1, frsLiteProgramListFragment);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgW() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.foK != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.foK.vp(foB);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = bgY();
                }
                frsTabHostFragment.b(this.foL);
                frsTabHostFragment.b(this.fcu);
                if (!foB.equals(this.foK.qV(0))) {
                    if (foz.equals(this.foK.qV(0))) {
                        this.foK.qU(0);
                    }
                    this.foK.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment P(Bundle bundle) {
        if (this.fcp == null) {
            this.fcp = new FrsFragment();
            this.fcp.setArguments(bundle);
            this.fcp.setBaseTag(foz);
        }
        this.fcp.eZb = false;
        return this.fcp;
    }

    private FrsLiteProgramListFragment bgX() {
        if (this.foD == null) {
            this.foD = new FrsLiteProgramListFragment();
            this.foD.setBaseTag(foA);
        }
        return this.foD;
    }

    private FrsTabHostFragment bgY() {
        if (this.foE == null) {
            this.foE = new FrsTabHostFragment(this);
            this.foE.setBaseTag(foB);
            this.foE.qo(this.fcr);
        }
        return this.foE;
    }

    private FragmentManager getFragmentManager() {
        if (this.foC != null) {
            return this.foC.getSupportFragmentManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final j jVar) {
        ThemeElement themeElement;
        if (jVar != null && jVar.getForum() != null) {
            ThemeColorInfo themeColorInfo = jVar.getForum().getThemeColorInfo();
            if (themeColorInfo != null && themeColorInfo.day != null && themeColorInfo.night != null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    themeElement = themeColorInfo.night;
                } else {
                    themeElement = themeColorInfo.day;
                }
                this.foL.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
                this.fcu.setIconFade(d.f.icon_frs_refresh_n);
                this.fcu.setShadowColor(al.getColor(d.C0277d.cp_mask_g));
                this.fcu.setColor(al.getColor(d.C0277d.cp_bg_line_a));
            }
            if (v.S(jVar.getGameTabInfo()) > 0) {
                this.fcq = jVar;
                if (!this.foC.isLoadingViewAttached() && !bhc()) {
                    this.foC.showLoadingView(this.foC.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean c = FrsTabController.this.c(jVar);
                        FrsTabController.this.e(jVar);
                        boolean ca = FrsTabController.this.ca(FrsTabController.this.fcq.getGameTabInfo());
                        if (c || ca) {
                            FrsTabController.this.foK.notifyDataSetChanged();
                            if (ca && FrsTabController.this.foE != null) {
                                FrsTabController.this.foE.L(FrsTabController.this.fcp);
                                FrsTabController.this.foE.a(FrsTabController.this.fcq, FrsTabController.this.fco);
                            }
                        }
                    }
                });
            } else if (bhc()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.c(jVar);
                        FrsTabController.this.fcp.eZb = true;
                        if (FrsTabController.this.fcp != null) {
                            bundle = FrsTabController.this.fcp.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.O(bundle);
                        FrsTabController.this.foK.notifyDataSetChanged();
                        FrsTabController.this.e(jVar);
                    }
                });
            } else if (jVar != null) {
                if (jVar.smartApp != null || !v.T(jVar.smartAppAvatar)) {
                    if (!this.foC.isLoadingViewAttached() && !bhd()) {
                        this.foC.showLoadingView(this.foC.findViewById(16908290));
                    }
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (FrsTabController.this.c(jVar)) {
                                FrsTabController.this.e(jVar);
                                FrsTabController.this.foK.notifyDataSetChanged();
                            }
                            if (FrsTabController.this.foC.isLoadingViewAttached()) {
                                FrsTabController.this.foC.hideLoadingView(FrsTabController.this.foC.findViewById(16908290));
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(j jVar) {
        if (jVar != null) {
            if (jVar.smartApp != null || !v.T(jVar.smartAppAvatar)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ca(List<FrsTabInfo> list) {
        if (this.foC.isLoadingViewAttached()) {
            this.foC.hideLoadingView(this.foC.findViewById(16908290));
        }
        if (bhc()) {
            return false;
        }
        this.fcp.eZb = true;
        bgZ();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", true);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_game_login_tip", false);
        }
        cb(list);
        return true;
    }

    private void bgZ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.foC.registerListener(1021074, this.foS);
    }

    private void cb(List<FrsTabInfo> list) {
        boolean z;
        if (!v.T(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(FrsTabController.this.foG, true)) {
                            e.jH().post(FrsTabController.this.foT);
                        }
                        FrsTabController.this.bgW();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.foC.registerListener(customMessageListener);
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
            this.fco = new ab(this.foC.getActivity(), arrayList);
            if (bbP() != null) {
                this.fco.setForumId(bbP().getForumId());
                this.fco.setForumName(bbP().getForumName());
                if (bbP().bcR() != null && bbP().bcR().getForum() != null) {
                    ForumData forum = bbP().bcR().getForum();
                    this.fco.setForumGameLabel(forum.getForumGameLabel());
                    this.fco.va(forum.getSpecialForumType());
                }
            }
            this.fcp.eZb = false;
            new d(this.fcp).a(this.fco);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.fco);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.foC.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bha() {
        if (this.fco != null && !TextUtils.isEmpty(this.fco.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.fcq.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar aDp;
        if ((fragment instanceof ah) && this.fcq != null && this.fcq.getForum() != null && (aDp = ((ah) fragment).aDp()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.fcq.getForum().getName(), 5, true, true) + this.foC.getActivity().getString(d.j.forum));
            aDp.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.fcp instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fcp.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a lj(int i) {
        if (this.fcp instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.fcp.lj(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.fcp instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fcp.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.fcp != null) {
            this.fcp.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!bhc()) {
            this.fcp.setPrimary(true);
        } else if (this.foE != null) {
            Fragment currentFragment = this.foE.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.foI) {
            this.foI = false;
            if (this.fcp != null) {
                this.fcp.refresh();
            }
        }
    }

    public void onPause() {
        if (!bhc()) {
            this.fcp.setPrimary(false);
        } else if (this.foE != null) {
            Fragment currentFragment = this.foE.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.foC);
        if (this.fcp != null) {
            this.fcp.onChangeSkinType(i);
        }
        if (this.foE != null) {
            this.foE.onChangeSkinType(i);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.foD != null && this.foD.fsP) {
                this.foD.fsP = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            }
            if (bhc() && this.foE != null && this.foE.beh()) {
                this.foE.bei();
                UtilHelper.setNavigationBarBackground(this.foC, this.foE.bec());
            } else if (this.fcp != null && this.fcp.isAdded()) {
                if (this.fcp.onKeyDown(i, keyEvent)) {
                    return true;
                }
                bhb();
            } else {
                return this.foC.b(i, keyEvent);
            }
            return false;
        }
        return this.foC.b(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhb() {
        if (this.fcs != this.fcr && bhc()) {
            this.foE.setCurrentTab(this.fcr);
            if (ql(this.fcr) != 1) {
                this.fcp.iX(false);
            }
            this.fcs = this.fcr;
            a(this.foE.getCurrentFragment(), this.fcr);
            return;
        }
        this.fcp.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!bhc()) {
            this.fcp.onActivityResult(i, i2, intent);
        } else if (this.foE != null) {
            if (1 == this.foE.getCurrentTabType()) {
                this.fcp.onActivityResult(i, i2, intent);
            } else {
                this.foE.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.bWr().x(this.foC.getPageContext());
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.foH != null) {
                        this.foH.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void aiK() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.foC != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.foC.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.bWr().x(this.foC.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!bhc()) {
            return this.fcp.getVoiceManager();
        }
        if (this.foE == null) {
            return null;
        }
        Fragment currentFragment = this.foE.getCurrentFragment();
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
    public int qj(int i) {
        if (this.fco == null) {
            return -1;
        }
        int S = v.S(this.fco.beq());
        for (int i2 = 0; i2 < S; i2++) {
            if (this.fco.beq().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ql(int i) {
        if (this.fco != null && i < v.S(this.fco.beq())) {
            return this.fco.beq().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bbP() {
        return this.fcp;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> bbQ() {
        if (!bhc()) {
            if (this.fcp instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.fcp).bbQ();
            }
        } else if (this.foE == null) {
            return null;
        } else {
            Fragment currentFragment = this.foE.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).bbQ();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(n.fbL);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.foC.isLoadingViewAttached()) {
            this.foC.hideLoadingView(this.foC.findViewById(16908290));
        }
        if (this.foT != null) {
            e.jH().removeCallbacks(this.foT);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.foG, false);
        if (this.foH != null) {
            this.foH.cancelLoadData();
        }
        if (this.fcp != null && this.fcp.bcp() != null) {
            this.fcp.bcp().onActivityDestroy();
        }
    }

    public FragmentTabHost bef() {
        if (this.foE == null) {
            return null;
        }
        return this.foE.bef();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bhc() {
        if (this.foK == null) {
            return false;
        }
        return this.foK.getItem(0) instanceof FrsTabHostFragment;
    }

    private boolean bhd() {
        if (this.foK == null) {
            return false;
        }
        return this.foK.getItem(1) instanceof FrsLiteProgramListFragment;
    }

    public void qo(int i) {
        this.fcr = i;
    }

    public void qS(int i) {
        this.fcs = i;
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
        /* renamed from: qT */
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

        public BaseFragment vp(String str) {
            if (ap.isEmpty(str)) {
                return null;
            }
            for (BaseFragment baseFragment : this.mFragments) {
                if (baseFragment != null && str.equals(baseFragment.getBaseTag())) {
                    return baseFragment;
                }
            }
            return null;
        }

        public BaseFragment qU(int i) {
            return (BaseFragment) v.d(this.mFragments, i);
        }

        public String qV(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }
}
