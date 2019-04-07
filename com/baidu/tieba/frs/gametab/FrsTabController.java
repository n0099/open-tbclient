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
    public static final String fol = FrsFragment.class.getSimpleName();
    public static final String fom = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String fon = FrsTabHostFragment.class.getSimpleName();
    private ab fcb;
    private FrsFragment fcc;
    private j fcd;
    private int fcf;
    private FRSRefreshButton fch;
    private FrsActivity foo;
    private FrsLiteProgramListFragment fop;
    private FrsTabHostFragment foq;
    private ShareSuccessReplyToServerModel fot;
    private FrsBaseViewPager fov;
    private FragmentAdapter fow;
    private OvalActionButton fox;
    private boolean foy;
    private boolean foz;
    private String mForumName;

    /* renamed from: for  reason: not valid java name */
    private boolean f0for = false;
    private final Handler mHandler = new Handler();
    private int fce = 0;
    private boolean fou = false;
    private com.baidu.adp.framework.listener.a foA = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            j jVar = null;
            if (!FrsTabController.this.f0for && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    jVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    jVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (jVar != null) {
                    FrsTabController.this.f0for = true;
                    FrsTabController.this.d(jVar);
                }
            }
        }
    };
    private CustomMessageListener foB = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.f0for && FrsTabController.this.fcd == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof j)) {
                j jVar = (j) customResponsedMessage.getData();
                if (jVar.getForum() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(jVar.getForum().getName())) {
                    FrsTabController.this.d(jVar);
                }
            }
        }
    };
    private CustomMessageListener foC = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.bgZ();
        }
    };
    private CustomMessageListener foD = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int qf;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    qf = FrsTabController.this.qf(9);
                    if (qf == -1) {
                        qf = FrsTabController.this.qf(2);
                    }
                } else {
                    qf = FrsTabController.this.qf(intValue);
                }
                if (qf != -1 && FrsTabController.this.bha() && FrsTabController.this.foq != null) {
                    FrsTabController.this.foq.setCurrentTab(qf);
                    if (FrsTabController.this.qh(qf) != 1) {
                        FrsTabController.this.fcc.iX(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener foE = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.T(newNotifyData) && FrsTabController.this.foq != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.fcb.beo().size(); i++) {
                                FragmentTabHost.b gZ = FrsTabController.this.foq.gZ(i);
                                if (gZ != null && gZ.mType != 1 && gZ.mType != FrsTabController.this.foq.getCurrentTabType() && gZ.mType == aVar.getTabId() && aVar.bgS() && gZ.bHX.pr(String.valueOf(gZ.mType)) != null) {
                                    gZ.bHX.pr(String.valueOf(gZ.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable foF = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        @Override // java.lang.Runnable
        public void run() {
            e.jH().removeCallbacks(this);
            FrsTabController.this.bgY();
            e.jH().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private CustomMessageListener mAccountChangedListener = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.fou = true;
            }
        }
    };
    private CustomMessageListener foG = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!i.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.fov != null && FrsTabController.this.fow != null && FrsTabController.this.fow.vo(FrsTabController.fom) != null) {
                if (!com.baidu.adp.lib.util.j.kY()) {
                    FrsTabController.this.foo.showToast(FrsTabController.this.foo.getString(d.j.neterror));
                } else if ((FrsTabController.this.bbN().bcP().smartAppAvatar == null || FrsTabController.this.bbN().bcP().smartAppAvatar.size() != 1) && (FrsTabController.this.bbN().bcP().smartAppAvatar != null || FrsTabController.this.bbN().bcP().smartApp == null)) {
                    FrsTabController.this.fov.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.bbN().bcP().smartApp;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.H(smartApp.id, smartApp.link, "1191003700000000")) {
                        FrsTabController.this.fov.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new am("c13274").bJ(ImageViewerConfig.FORUM_ID, FrsTabController.this.bbN().getForumId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ("obj_name", FrsTabController.this.bbN().bcP().smartApp.name).bJ(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.bbN().bcP().smartApp.id).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
                    }
                }
            }
        }
    };
    private CustomMessageListener foH = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fov != null && FrsTabController.this.fow != null && FrsTabController.this.fow.vo(FrsTabController.fom) != null) {
                FrsTabController.this.fov.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener foI = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fov != null && FrsTabController.this.fow != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.foy = aVar.bel();
                FrsTabController.this.foz = aVar.bem();
            }
        }
    };
    private CustomMessageListener foJ = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.fov != null && FrsTabController.this.fow != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.fov.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener foK = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.fcc.bcN();
                FrsTabController.this.bgT();
                FrsTabController.this.fox.setVisibility(8);
                return;
            }
            FrsTabController.this.fox.setVisibility(0);
            FrsTabController.this.fcc.bcO();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.foz = false;
                    FrsTabController.this.fov.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a foL = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void bcc() {
            if (FrsTabController.this.fov != null) {
                if (FrsTabController.this.fov.getCurrentItem() == 0) {
                    FrsTabController.this.fov.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.fov.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean bcd() {
            SmartApp smartApp;
            if (FrsTabController.this.fov.getCurrentItem() == 0) {
                if (FrsTabController.this.foy && FrsTabController.this.foz) {
                    FrsTabController.this.fov.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.foz) {
                    FrsTabController.this.fov.setmDisallowSlip(true);
                }
                FrsTabController.this.fov.setmDisallowSlip(true);
            } else {
                FrsTabController.this.fov.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.bbN().bcP().smartAppAvatar == null || FrsTabController.this.bbN().bcP().smartAppAvatar.size() != 1) && (FrsTabController.this.bbN().bcP().smartAppAvatar != null || FrsTabController.this.bbN().bcP().smartApp == null)) || (smartApp = FrsTabController.this.bbN().bcP().smartApp) == null || !com.baidu.tieba.aiapps.a.H(smartApp.id, smartApp.link, "1191003700000000")) {
                return true;
            }
            TiebaStatic.log(new am("c13274").bJ(ImageViewerConfig.FORUM_ID, FrsTabController.this.bbN().getForumId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ("obj_name", FrsTabController.this.bbN().bcP().smartApp.name).bJ(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.bbN().bcP().smartApp.id).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
            return false;
        }
    };
    private String fos = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    /* JADX INFO: Access modifiers changed from: private */
    public void bgT() {
        if (this.fop != null && bbN() != null) {
            this.fop.fsB = true;
            this.fop.clear();
            if (!com.baidu.adp.lib.util.j.kY()) {
                this.fop.vC(bbN().getForumId());
            } else if ((bbN().bcP().smartAppAvatar != null && bbN().bcP().smartAppAvatar.size() == 1) || (bbN().bcP().smartAppAvatar == null && bbN().bcP().smartApp != null)) {
                SmartApp smartApp = bbN().bcP().smartApp;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.H(smartApp.id, smartApp.link, "1191003700000000")) {
                    String str = null;
                    if (bbN().bcP() != null && bbN().bcP().smartApp != null) {
                        str = bbN().bcP().smartApp.h5_url;
                    }
                    this.fop.vD(str);
                }
                TiebaStatic.log(new am("c13274").bJ(ImageViewerConfig.FORUM_ID, bbN().getForumId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ("obj_name", bbN().bcP().smartApp.name).bJ(VideoPlayActivityConfig.OBJ_ID, bbN().bcP().smartApp.id).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
            } else {
                this.fop.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.fop;
                String forumId = bbN().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.fop;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.fop;
                frsLiteProgramListFragment.t(forumId, 1, 10);
                TiebaStatic.log(new am("c13273").bJ(ImageViewerConfig.FORUM_ID, bbN().getForumId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.foo = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.foo != null) {
            this.foo.setContentView(d.h.frs_base_layout);
            this.fov = (FrsBaseViewPager) this.foo.findViewById(d.g.frs_base_viewpager);
            this.fow = new FragmentAdapter(this.foo.getSupportFragmentManager());
            this.fov.setAdapter(this.fow);
            this.fov.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.fov.addOnPageChangeListener(this.foK);
            this.fov.setmDisallowSlip(true);
            this.fov.setOnTouchEventListener(this.foL);
            this.fox = (OvalActionButton) this.foo.findViewById(d.g.frs_post_forum_button);
            this.fch = (FRSRefreshButton) this.foo.findViewById(d.g.frs_refresh_forum_button);
            this.foo.registerListener(this.foI);
            this.foo.registerListener(this.foJ);
            this.foo.registerListener(this.foG);
            this.foo.registerListener(this.foH);
            this.foA.getHttpMessageListener().setPriority(-1);
            this.foA.getSocketMessageListener().setPriority(-1);
            this.foo.registerListener(this.foB);
            this.foD.setSelfListener(true);
            this.foo.registerListener(this.foD);
            this.foC.setSelfListener(true);
            this.foo.registerListener(this.foC);
            this.foo.registerListener(this.mAccountChangedListener);
            if (bundle == null) {
                this.mForumName = this.foo.getIntent().getStringExtra("name");
                this.fce = this.foo.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.fce = bundle.getInt("default_tab_id", 0);
            }
            O(bundle);
            this.fow.notifyDataSetChanged();
            this.fot = new ShareSuccessReplyToServerModel();
            this.foo.registerListener(this.foA);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.fce);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.fow != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.fow.vo(fol);
                if (frsFragment == null) {
                    frsFragment = P(bundle);
                }
                frsFragment.b(this.fox);
                frsFragment.a(this.fch);
                if (!fol.equals(this.fow.qR(0))) {
                    if (fon.equals(this.fow.qR(0))) {
                        this.fow.qQ(0);
                    }
                    this.fow.a(0, frsFragment);
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
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.fow == null) {
                return false;
            }
            if (fom.equals(this.fow.qR(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.fow.vo(fom);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = bgV();
                }
                this.fow.a(1, frsLiteProgramListFragment);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgU() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.fow != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.fow.vo(fon);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = bgW();
                }
                frsTabHostFragment.b(this.fox);
                frsTabHostFragment.b(this.fch);
                if (!fon.equals(this.fow.qR(0))) {
                    if (fol.equals(this.fow.qR(0))) {
                        this.fow.qQ(0);
                    }
                    this.fow.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment P(Bundle bundle) {
        if (this.fcc == null) {
            this.fcc = new FrsFragment();
            this.fcc.setArguments(bundle);
            this.fcc.setBaseTag(fol);
        }
        this.fcc.eYN = false;
        return this.fcc;
    }

    private FrsLiteProgramListFragment bgV() {
        if (this.fop == null) {
            this.fop = new FrsLiteProgramListFragment();
            this.fop.setBaseTag(fom);
        }
        return this.fop;
    }

    private FrsTabHostFragment bgW() {
        if (this.foq == null) {
            this.foq = new FrsTabHostFragment(this);
            this.foq.setBaseTag(fon);
            this.foq.qk(this.fce);
        }
        return this.foq;
    }

    private FragmentManager getFragmentManager() {
        if (this.foo != null) {
            return this.foo.getSupportFragmentManager();
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
                this.fox.setStartAndEndColor(themeElement.light_color, themeElement.dark_color);
                this.fch.setIconFade(d.f.icon_frs_refresh_n);
                this.fch.setShadowColor(al.getColor(d.C0277d.cp_mask_g));
                this.fch.setColor(al.getColor(d.C0277d.cp_bg_line_a));
            }
            if (v.S(jVar.getGameTabInfo()) > 0) {
                this.fcd = jVar;
                if (!this.foo.isLoadingViewAttached() && !bha()) {
                    this.foo.showLoadingView(this.foo.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean c = FrsTabController.this.c(jVar);
                        FrsTabController.this.e(jVar);
                        boolean bX = FrsTabController.this.bX(FrsTabController.this.fcd.getGameTabInfo());
                        if (c || bX) {
                            FrsTabController.this.fow.notifyDataSetChanged();
                            if (bX && FrsTabController.this.foq != null) {
                                FrsTabController.this.foq.L(FrsTabController.this.fcc);
                                FrsTabController.this.foq.a(FrsTabController.this.fcd, FrsTabController.this.fcb);
                            }
                        }
                    }
                });
            } else if (bha()) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle bundle;
                        FrsTabController.this.c(jVar);
                        FrsTabController.this.fcc.eYN = true;
                        if (FrsTabController.this.fcc != null) {
                            bundle = FrsTabController.this.fcc.getArguments();
                        } else {
                            bundle = null;
                        }
                        FrsTabController.this.O(bundle);
                        FrsTabController.this.fow.notifyDataSetChanged();
                        FrsTabController.this.e(jVar);
                    }
                });
            } else if (jVar != null) {
                if (jVar.smartApp != null || !v.T(jVar.smartAppAvatar)) {
                    if (!this.foo.isLoadingViewAttached() && !bhb()) {
                        this.foo.showLoadingView(this.foo.findViewById(16908290));
                    }
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (FrsTabController.this.c(jVar)) {
                                FrsTabController.this.e(jVar);
                                FrsTabController.this.fow.notifyDataSetChanged();
                            }
                            if (FrsTabController.this.foo.isLoadingViewAttached()) {
                                FrsTabController.this.foo.hideLoadingView(FrsTabController.this.foo.findViewById(16908290));
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
    public boolean bX(List<FrsTabInfo> list) {
        if (this.foo.isLoadingViewAttached()) {
            this.foo.hideLoadingView(this.foo.findViewById(16908290));
        }
        if (bha()) {
            return false;
        }
        this.fcc.eYN = true;
        bgX();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", true);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_game_login_tip", false);
        }
        bY(list);
        return true;
    }

    private void bgX() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.foo.registerListener(1021074, this.foE);
    }

    private void bY(List<FrsTabInfo> list) {
        boolean z;
        if (!v.T(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(FrsTabController.this.fos, true)) {
                            e.jH().post(FrsTabController.this.foF);
                        }
                        FrsTabController.this.bgU();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.foo.registerListener(customMessageListener);
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
            this.fcb = new ab(this.foo.getActivity(), arrayList);
            if (bbN() != null) {
                this.fcb.setForumId(bbN().getForumId());
                this.fcb.setForumName(bbN().getForumName());
                if (bbN().bcP() != null && bbN().bcP().getForum() != null) {
                    ForumData forum = bbN().bcP().getForum();
                    this.fcb.setForumGameLabel(forum.getForumGameLabel());
                    this.fcb.uZ(forum.getSpecialForumType());
                }
            }
            this.fcc.eYN = false;
            new d(this.fcc).a(this.fcb);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.fcb);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.foo.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgY() {
        if (this.fcb != null && !TextUtils.isEmpty(this.fcb.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.fcd.getForum().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar aDm;
        if ((fragment instanceof ah) && this.fcd != null && this.fcd.getForum() != null && (aDm = ((ah) fragment).aDm()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.fcd.getForum().getName(), 5, true, true) + this.foo.getActivity().getString(d.j.forum));
            aDm.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.fcc instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fcc.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a li(int i) {
        if (this.fcc instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.fcc.li(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.fcc instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fcc.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.fcc != null) {
            this.fcc.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!bha()) {
            this.fcc.setPrimary(true);
        } else if (this.foq != null) {
            Fragment currentFragment = this.foq.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.fou) {
            this.fou = false;
            if (this.fcc != null) {
                this.fcc.refresh();
            }
        }
    }

    public void onPause() {
        if (!bha()) {
            this.fcc.setPrimary(false);
        } else if (this.foq != null) {
            Fragment currentFragment = this.foq.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        UtilHelper.changeStatusBarIconAndTextColor(true, this.foo);
        if (this.fcc != null) {
            this.fcc.onChangeSkinType(i);
        }
        if (this.foq != null) {
            this.foq.onChangeSkinType(i);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fop != null && this.fop.fsB) {
                this.fop.fsB = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            }
            if (bha() && this.foq != null && this.foq.bef()) {
                this.foq.beg();
                UtilHelper.setNavigationBarBackground(this.foo, this.foq.bea());
            } else if (this.fcc != null && this.fcc.isAdded()) {
                if (this.fcc.onKeyDown(i, keyEvent)) {
                    return true;
                }
                bgZ();
            } else {
                return this.foo.b(i, keyEvent);
            }
            return false;
        }
        return this.foo.b(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgZ() {
        if (this.fcf != this.fce && bha()) {
            this.foq.setCurrentTab(this.fce);
            if (qh(this.fce) != 1) {
                this.fcc.iX(false);
            }
            this.fcf = this.fce;
            a(this.foq.getCurrentFragment(), this.fce);
            return;
        }
        this.fcc.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!bha()) {
            this.fcc.onActivityResult(i, i2, intent);
        } else if (this.foq != null) {
            if (1 == this.foq.getCurrentTabType()) {
                this.fcc.onActivityResult(i, i2, intent);
            } else {
                this.foq.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.bWn().w(this.foo.getPageContext());
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.fot != null) {
                        this.fot.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void aiH() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.foo != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.foo.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.bWn().w(this.foo.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!bha()) {
            return this.fcc.getVoiceManager();
        }
        if (this.foq == null) {
            return null;
        }
        Fragment currentFragment = this.foq.getCurrentFragment();
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
    public int qf(int i) {
        if (this.fcb == null) {
            return -1;
        }
        int S = v.S(this.fcb.beo());
        for (int i2 = 0; i2 < S; i2++) {
            if (this.fcb.beo().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int qh(int i) {
        if (this.fcb != null && i < v.S(this.fcb.beo())) {
            return this.fcb.beo().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment bbN() {
        return this.fcc;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> bbO() {
        if (!bha()) {
            if (this.fcc instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.fcc).bbO();
            }
        } else if (this.foq == null) {
            return null;
        } else {
            Fragment currentFragment = this.foq.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).bbO();
            }
        }
        return null;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(n.fby);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.foo.isLoadingViewAttached()) {
            this.foo.hideLoadingView(this.foo.findViewById(16908290));
        }
        if (this.foF != null) {
            e.jH().removeCallbacks(this.foF);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.fos, false);
        if (this.fot != null) {
            this.fot.cancelLoadData();
        }
        if (this.fcc != null && this.fcc.bcn() != null) {
            this.fcc.bcn().onActivityDestroy();
        }
    }

    public FragmentTabHost bed() {
        if (this.foq == null) {
            return null;
        }
        return this.foq.bed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bha() {
        if (this.fow == null) {
            return false;
        }
        return this.fow.getItem(0) instanceof FrsTabHostFragment;
    }

    private boolean bhb() {
        if (this.fow == null) {
            return false;
        }
        return this.fow.getItem(1) instanceof FrsLiteProgramListFragment;
    }

    public void qk(int i) {
        this.fce = i;
    }

    public void qO(int i) {
        this.fcf = i;
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
        /* renamed from: qP */
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

        public BaseFragment vo(String str) {
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

        public BaseFragment qQ(int i) {
            return (BaseFragment) v.d(this.mFragments, i);
        }

        public String qR(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }
}
