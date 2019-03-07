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
    public static final String foA = FrsFragment.class.getSimpleName();
    public static final String foB = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String foC = FrsTabHostFragment.class.getSimpleName();
    private ab fcp;
    private FrsFragment fcq;
    private j fcr;
    private int fct;
    private FRSRefreshButton fcv;
    private FrsActivity foD;
    private FrsLiteProgramListFragment foE;
    private FrsTabHostFragment foF;
    private ShareSuccessReplyToServerModel foI;
    private FrsBaseViewPager foK;
    private FragmentAdapter foL;
    private OvalActionButton foM;
    private boolean foN;
    private boolean foO;
    private String mForumName;
    private boolean foG = false;
    private final Handler mHandler = new Handler();
    private int fcs = 0;
    private boolean foJ = false;
    private com.baidu.adp.framework.listener.a foP = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            j jVar = null;
            if (!FrsTabController.this.foG && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    jVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    jVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (jVar != null) {
                    FrsTabController.this.foG = true;
                    FrsTabController.this.d(jVar);
                }
            }
        }
    };
    private CustomMessageListener foQ = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.foG && FrsTabController.this.fcr == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof j)) {
                j jVar = (j) customResponsedMessage.getData();
                if (jVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(jVar.getForum().getName())) {
                    FrsTabController.this.d(jVar);
                }
            }
        }
    };
    private CustomMessageListener foR = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.bhb();
        }
    };
    private CustomMessageListener foS = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
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
                if (qj != -1 && FrsTabController.this.bhc() && FrsTabController.this.foF != null) {
                    FrsTabController.this.foF.setCurrentTab(qj);
                    if (FrsTabController.this.ql(qj) != 1) {
                        FrsTabController.this.fcq.iX(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener foT = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.T(newNotifyData) && FrsTabController.this.foF != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.fcp.beq().size(); i++) {
                                FragmentTabHost.b ha = FrsTabController.this.foF.ha(i);
                                if (ha != null && ha.mType != 1 && ha.mType != FrsTabController.this.foF.getCurrentTabType() && ha.mType == aVar.getTabId() && aVar.bgU() && ha.bHU.pq(String.valueOf(ha.mType)) != null) {
                                    ha.bHU.pq(String.valueOf(ha.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable foU = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        @Override // java.lang.Runnable
        public void run() {
            e.jH().removeCallbacks(this);
            FrsTabController.this.bha();
            e.jH().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private CustomMessageListener dgB = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.foJ = true;
            }
        }
    };
    private CustomMessageListener foV = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!i.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.foK != null && FrsTabController.this.foL != null && FrsTabController.this.foL.vq(FrsTabController.foB) != null) {
                if (!com.baidu.adp.lib.util.j.kY()) {
                    FrsTabController.this.foD.showToast(FrsTabController.this.foD.getString(d.j.neterror));
                } else if ((FrsTabController.this.bbP().bcR().smartAppAvatar == null || FrsTabController.this.bbP().bcR().smartAppAvatar.size() != 1) && (FrsTabController.this.bbP().bcR().smartAppAvatar != null || FrsTabController.this.bbP().bcR().smartApp == null)) {
                    FrsTabController.this.foK.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.bbP().bcR().smartApp;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.H(smartApp.id, smartApp.link, "1191003700000000")) {
                        FrsTabController.this.foK.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new am("c13274").bJ(ImageViewerConfig.FORUM_ID, FrsTabController.this.bbP().getForumId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ("obj_name", FrsTabController.this.bbP().bcR().smartApp.name).bJ(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.bbP().bcR().smartApp.id).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
                    }
                }
            }
        }
    };
    private CustomMessageListener foW = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.foK != null && FrsTabController.this.foL != null && FrsTabController.this.foL.vq(FrsTabController.foB) != null) {
                FrsTabController.this.foK.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener foX = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.foK != null && FrsTabController.this.foL != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.foN = aVar.ben();
                FrsTabController.this.foO = aVar.beo();
            }
        }
    };
    private CustomMessageListener foY = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.foK != null && FrsTabController.this.foL != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.foK.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener foZ = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.fcq.bcP();
                FrsTabController.this.bgV();
                FrsTabController.this.foM.setVisibility(8);
                return;
            }
            FrsTabController.this.foM.setVisibility(0);
            FrsTabController.this.fcq.bcQ();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.foO = false;
                    FrsTabController.this.foK.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a fpa = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void bce() {
            if (FrsTabController.this.foK != null) {
                if (FrsTabController.this.foK.getCurrentItem() == 0) {
                    FrsTabController.this.foK.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.foK.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean bcf() {
            SmartApp smartApp;
            if (FrsTabController.this.foK.getCurrentItem() == 0) {
                if (FrsTabController.this.foN && FrsTabController.this.foO) {
                    FrsTabController.this.foK.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.foO) {
                    FrsTabController.this.foK.setmDisallowSlip(true);
                }
                FrsTabController.this.foK.setmDisallowSlip(true);
            } else {
                FrsTabController.this.foK.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.bbP().bcR().smartAppAvatar == null || FrsTabController.this.bbP().bcR().smartAppAvatar.size() != 1) && (FrsTabController.this.bbP().bcR().smartAppAvatar != null || FrsTabController.this.bbP().bcR().smartApp == null)) || (smartApp = FrsTabController.this.bbP().bcR().smartApp) == null || !com.baidu.tieba.aiapps.a.H(smartApp.id, smartApp.link, "1191003700000000")) {
                return true;
            }
            TiebaStatic.log(new am("c13274").bJ(ImageViewerConfig.FORUM_ID, FrsTabController.this.bbP().getForumId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ("obj_name", FrsTabController.this.bbP().bcR().smartApp.name).bJ(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.bbP().bcR().smartApp.id).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
            return false;
        }
    };
    private String foH = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    /* JADX INFO: Access modifiers changed from: private */
    public void bgV() {
        if (this.foE != null && bbP() != null) {
            this.foE.fsQ = true;
            this.foE.clear();
            if (!com.baidu.adp.lib.util.j.kY()) {
                this.foE.vE(bbP().getForumId());
            } else if ((bbP().bcR().smartAppAvatar != null && bbP().bcR().smartAppAvatar.size() == 1) || (bbP().bcR().smartAppAvatar == null && bbP().bcR().smartApp != null)) {
                SmartApp smartApp = bbP().bcR().smartApp;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.H(smartApp.id, smartApp.link, "1191003700000000")) {
                    String str = null;
                    if (bbP().bcR() != null && bbP().bcR().smartApp != null) {
                        str = bbP().bcR().smartApp.h5_url;
                    }
                    this.foE.vF(str);
                }
                TiebaStatic.log(new am("c13274").bJ(ImageViewerConfig.FORUM_ID, bbP().getForumId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ("obj_name", bbP().bcR().smartApp.name).bJ(VideoPlayActivityConfig.OBJ_ID, bbP().bcR().smartApp.id).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
            } else {
                this.foE.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.foE;
                String forumId = bbP().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.foE;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.foE;
                frsLiteProgramListFragment.t(forumId, 1, 10);
                TiebaStatic.log(new am("c13273").bJ(ImageViewerConfig.FORUM_ID, bbP().getForumId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.foD = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.foD != null) {
            this.foD.setContentView(d.h.frs_base_layout);
            this.foK = (FrsBaseViewPager) this.foD.findViewById(d.g.frs_base_viewpager);
            this.foL = new FragmentAdapter(this.foD.getSupportFragmentManager());
            this.foK.setAdapter(this.foL);
            this.foK.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.foK.addOnPageChangeListener(this.foZ);
            this.foK.setmDisallowSlip(true);
            this.foK.setOnTouchEventListener(this.fpa);
            this.foM = (OvalActionButton) this.foD.findViewById(d.g.frs_post_forum_button);
            this.fcv = (FRSRefreshButton) this.foD.findViewById(d.g.frs_refresh_forum_button);
            this.foD.registerListener(this.foX);
            this.foD.registerListener(this.foY);
            this.foD.registerListener(this.foV);
            this.foD.registerListener(this.foW);
            this.foP.getHttpMessageListener().setPriority(-1);
            this.foP.getSocketMessageListener().setPriority(-1);
            this.foD.registerListener(this.foQ);
            this.foS.setSelfListener(true);
            this.foD.registerListener(this.foS);
            this.foR.setSelfListener(true);
            this.foD.registerListener(this.foR);
            this.foD.registerListener(this.dgB);
            if (bundle == null) {
                this.mForumName = this.foD.getIntent().getStringExtra("name");
                this.fcs = this.foD.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.fcs = bundle.getInt("default_tab_id", 0);
            }
            O(bundle);
            this.foL.notifyDataSetChanged();
            this.foI = new ShareSuccessReplyToServerModel();
            this.foD.registerListener(this.foP);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.fcs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.foL != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.foL.vq(foA);
                if (frsFragment == null) {
                    frsFragment = P(bundle);
                }
                frsFragment.b(this.foM);
                frsFragment.a(this.fcv);
                if (!foA.equals(this.foL.qV(0))) {
                    if (foC.equals(this.foL.qV(0))) {
                        this.foL.qU(0);
                    }
                    this.foL.a(0, frsFragment);
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
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.foL == null) {
                return false;
            }
            if (foB.equals(this.foL.qV(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.foL.vq(foB);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = bgX();
                }
                this.foL.a(1, frsLiteProgramListFragment);
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
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.foL != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.foL.vq(foC);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = bgY();
                }
                frsTabHostFragment.b(this.foM);
                frsTabHostFragment.b(this.fcv);
                if (!foC.equals(this.foL.qV(0))) {
                    if (foA.equals(this.foL.qV(0))) {
                        this.foL.qU(0);
                    }
                    this.foL.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment P(Bundle bundle) {
        if (this.fcq == null) {
            this.fcq = new FrsFragment();
            this.fcq.setArguments(bundle);
            this.fcq.setBaseTag(foA);
        }
        this.fcq.eZc = false;
        return this.fcq;
    }

    private FrsLiteProgramListFragment bgX() {
        if (this.foE == null) {
            this.foE = new FrsLiteProgramListFragment();
            this.foE.setBaseTag(foB);
        }
        return this.foE;
    }

    private FrsTabHostFragment bgY() {
        if (this.foF == null) {
            this.foF = new FrsTabHostFragment(this);
            this.foF.setBaseTag(foC);
            this.foF.qo(this.fcs);
        }
        return this.foF;
    }

    private FragmentManager getFragmentManager() {
        if (this.foD != null) {
            return this.foD.getSupportFragmentManager();
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
                this.foM.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
                this.fcv.setIconFade(d.f.icon_frs_refresh_n);
                this.fcv.setShadowColor(al.getColor(d.C0236d.cp_mask_g));
                this.fcv.setColor(al.getColor(d.C0236d.cp_bg_line_a));
            }
            if (v.S(jVar.getGameTabInfo()) > 0) {
                this.fcr = jVar;
                if (!this.foD.isLoadingViewAttached() && !bhc()) {
                    this.foD.showLoadingView(this.foD.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean c = FrsTabController.this.c(jVar);
                        FrsTabController.this.e(jVar);
                        boolean ca = FrsTabController.this.ca(FrsTabController.this.fcr.getGameTabInfo());
                        if (c || ca) {
                            FrsTabController.this.foL.notifyDataSetChanged();
                            if (ca && FrsTabController.this.foF != null) {
                                FrsTabController.this.foF.L(FrsTabController.this.fcq);
                                FrsTabController.this.foF.a(FrsTabController.this.fcr, FrsTabController.this.fcp);
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
                        FrsTabController.this.fcq.eZc = true;
                        if (FrsTabController.this.fcq != null) {
                            bundle = FrsTabController.this.fcq.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.O(bundle);
                        FrsTabController.this.foL.notifyDataSetChanged();
                        FrsTabController.this.e(jVar);
                    }
                });
            } else if (jVar != null) {
                if (jVar.smartApp != null || !v.T(jVar.smartAppAvatar)) {
                    if (!this.foD.isLoadingViewAttached() && !bhd()) {
                        this.foD.showLoadingView(this.foD.findViewById(16908290));
                    }
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (FrsTabController.this.c(jVar)) {
                                FrsTabController.this.e(jVar);
                                FrsTabController.this.foL.notifyDataSetChanged();
                            }
                            if (FrsTabController.this.foD.isLoadingViewAttached()) {
                                FrsTabController.this.foD.hideLoadingView(FrsTabController.this.foD.findViewById(16908290));
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
        if (this.foD.isLoadingViewAttached()) {
            this.foD.hideLoadingView(this.foD.findViewById(16908290));
        }
        if (bhc()) {
            return false;
        }
        this.fcq.eZc = true;
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
        this.foD.registerListener(1021074, this.foT);
    }

    private void cb(List<FrsTabInfo> list) {
        boolean z;
        if (!v.T(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(FrsTabController.this.foH, true)) {
                            e.jH().post(FrsTabController.this.foU);
                        }
                        FrsTabController.this.bgW();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.foD.registerListener(customMessageListener);
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
            this.fcp = new ab(this.foD.getActivity(), arrayList);
            if (bbP() != null) {
                this.fcp.setForumId(bbP().getForumId());
                this.fcp.setForumName(bbP().getForumName());
                if (bbP().bcR() != null && bbP().bcR().getForum() != null) {
                    ForumData forum = bbP().bcR().getForum();
                    this.fcp.setForumGameLabel(forum.getForumGameLabel());
                    this.fcp.vb(forum.getSpecialForumType());
                }
            }
            this.fcq.eZc = false;
            new d(this.fcq).a(this.fcp);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.fcp);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.foD.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bha() {
        if (this.fcp != null && !TextUtils.isEmpty(this.fcp.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.fcr.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar aDp;
        if ((fragment instanceof ah) && this.fcr != null && this.fcr.getForum() != null && (aDp = ((ah) fragment).aDp()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.fcr.getForum().getName(), 5, true, true) + this.foD.getActivity().getString(d.j.forum));
            aDp.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.fcq instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fcq.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a lj(int i) {
        if (this.fcq instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.fcq.lj(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.fcq instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fcq.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.fcq != null) {
            this.fcq.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!bhc()) {
            this.fcq.setPrimary(true);
        } else if (this.foF != null) {
            Fragment currentFragment = this.foF.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.foJ) {
            this.foJ = false;
            if (this.fcq != null) {
                this.fcq.refresh();
            }
        }
    }

    public void onPause() {
        if (!bhc()) {
            this.fcq.setPrimary(false);
        } else if (this.foF != null) {
            Fragment currentFragment = this.foF.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.foD);
        if (this.fcq != null) {
            this.fcq.onChangeSkinType(i);
        }
        if (this.foF != null) {
            this.foF.onChangeSkinType(i);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.foE != null && this.foE.fsQ) {
                this.foE.fsQ = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            }
            if (bhc() && this.foF != null && this.foF.beh()) {
                this.foF.bei();
                UtilHelper.setNavigationBarBackground(this.foD, this.foF.bec());
            } else if (this.fcq != null && this.fcq.isAdded()) {
                if (this.fcq.onKeyDown(i, keyEvent)) {
                    return true;
                }
                bhb();
            } else {
                return this.foD.b(i, keyEvent);
            }
            return false;
        }
        return this.foD.b(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhb() {
        if (this.fct != this.fcs && bhc()) {
            this.foF.setCurrentTab(this.fcs);
            if (ql(this.fcs) != 1) {
                this.fcq.iX(false);
            }
            this.fct = this.fcs;
            a(this.foF.getCurrentFragment(), this.fcs);
            return;
        }
        this.fcq.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!bhc()) {
            this.fcq.onActivityResult(i, i2, intent);
        } else if (this.foF != null) {
            if (1 == this.foF.getCurrentTabType()) {
                this.fcq.onActivityResult(i, i2, intent);
            } else {
                this.foF.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.bWo().x(this.foD.getPageContext());
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.foI != null) {
                        this.foI.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void aiK() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.foD != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.foD.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.bWo().x(this.foD.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!bhc()) {
            return this.fcq.getVoiceManager();
        }
        if (this.foF == null) {
            return null;
        }
        Fragment currentFragment = this.foF.getCurrentFragment();
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
        if (this.fcp == null) {
            return -1;
        }
        int S = v.S(this.fcp.beq());
        for (int i2 = 0; i2 < S; i2++) {
            if (this.fcp.beq().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ql(int i) {
        if (this.fcp != null && i < v.S(this.fcp.beq())) {
            return this.fcp.beq().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bbP() {
        return this.fcq;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> bbQ() {
        if (!bhc()) {
            if (this.fcq instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.fcq).bbQ();
            }
        } else if (this.foF == null) {
            return null;
        } else {
            Fragment currentFragment = this.foF.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).bbQ();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(n.fbM);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.foD.isLoadingViewAttached()) {
            this.foD.hideLoadingView(this.foD.findViewById(16908290));
        }
        if (this.foU != null) {
            e.jH().removeCallbacks(this.foU);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.foH, false);
        if (this.foI != null) {
            this.foI.cancelLoadData();
        }
        if (this.fcq != null && this.fcq.bcp() != null) {
            this.fcq.bcp().onActivityDestroy();
        }
    }

    public FragmentTabHost bef() {
        if (this.foF == null) {
            return null;
        }
        return this.foF.bef();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bhc() {
        if (this.foL == null) {
            return false;
        }
        return this.foL.getItem(0) instanceof FrsTabHostFragment;
    }

    private boolean bhd() {
        if (this.foL == null) {
            return false;
        }
        return this.foL.getItem(1) instanceof FrsLiteProgramListFragment;
    }

    public void qo(int i) {
        this.fcs = i;
    }

    public void qS(int i) {
        this.fct = i;
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

        public BaseFragment vq(String str) {
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
