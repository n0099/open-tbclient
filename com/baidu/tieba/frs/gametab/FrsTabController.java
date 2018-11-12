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
import android.util.Pair;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.j;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.CubeOutViewPagerTransformer;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsBaseViewPager;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabHostFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.smartapp.FrsLiteProgramListFragment;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.i;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SmartApp;
/* loaded from: classes6.dex */
public class FrsTabController implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    public static final String dQW = FrsFragment.class.getSimpleName();
    public static final String dQX = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String dQY = FrsTabHostFragment.class.getSimpleName();
    private ad dEC;
    private FrsFragment dED;
    private i dEE;
    private int dEG;
    private FrsActivity dQZ;
    private FrsLiteProgramListFragment dRa;
    private FrsTabHostFragment dRb;
    private ShareSuccessReplyToServerModel dRe;
    private FrsBaseViewPager dRg;
    private FragmentAdapter dRh;
    private boolean dRi;
    private boolean dRj;
    private String mForumName;
    private boolean dRc = false;
    private final Handler mHandler = new Handler();
    private int dEF = 0;
    private boolean dRf = false;
    private com.baidu.adp.framework.listener.a dRk = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            i iVar = null;
            if (!FrsTabController.this.dRc && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    iVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    iVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (iVar != null) {
                    FrsTabController.this.dRc = true;
                    FrsTabController.this.d(iVar);
                }
            }
        }
    };
    private CustomMessageListener dRl = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.dRc && FrsTabController.this.dEE == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                i iVar = (i) customResponsedMessage.getData();
                if (iVar.ber() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(iVar.ber().getName())) {
                    FrsTabController.this.d(iVar);
                }
            }
        }
    };
    private CustomMessageListener dRm = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.aDL();
        }
    };
    private CustomMessageListener dRn = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int lT;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    lT = FrsTabController.this.lT(9);
                    if (lT == -1) {
                        lT = FrsTabController.this.lT(2);
                    }
                } else {
                    lT = FrsTabController.this.lT(intValue);
                }
                if (lT != -1 && FrsTabController.this.aDM() && FrsTabController.this.dRb != null) {
                    FrsTabController.this.dRb.setCurrentTab(lT);
                    if (FrsTabController.this.lV(lT) != 1) {
                        FrsTabController.this.dED.gs(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener dRo = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.I(newNotifyData) && FrsTabController.this.dRb != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.dEC.aAO().size(); i++) {
                                FragmentTabHost.b dk = FrsTabController.this.dRb.dk(i);
                                if (dk != null && dk.mType != 99 && dk.mType != 1 && dk.mType != FrsTabController.this.dRb.getCurrentTabType() && dk.mType == aVar.getTabId() && aVar.aDE() && dk.avY.hW(String.valueOf(dk.mType)) != null) {
                                    dk.avY.hW(String.valueOf(dk.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable dRp = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        @Override // java.lang.Runnable
        public void run() {
            e.jG().removeCallbacks(this);
            FrsTabController.this.aDK();
            e.jG().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private CustomMessageListener bMF = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.dRf = true;
            }
        }
    };
    private CustomMessageListener dRq = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!g.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.dRg != null && FrsTabController.this.dRh != null && FrsTabController.this.dRh.nS(FrsTabController.dQX) != null) {
                if (!j.kV()) {
                    FrsTabController.this.dQZ.showToast(FrsTabController.this.dQZ.getString(e.j.neterror));
                } else if ((FrsTabController.this.ayv().azp().hcL == null || FrsTabController.this.ayv().azp().hcL.size() != 1) && (FrsTabController.this.ayv().azp().hcL != null || FrsTabController.this.ayv().azp().hcM == null)) {
                    FrsTabController.this.dRg.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.ayv().azp().hcM;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.u(smartApp.id, smartApp.link, "9101")) {
                        FrsTabController.this.dRg.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new am("c13274").ax(ImageViewerConfig.FORUM_ID, FrsTabController.this.ayv().getForumId()).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax("obj_name", FrsTabController.this.ayv().azp().hcM.name).ax(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.ayv().azp().hcM.id).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
                    }
                }
            }
        }
    };
    private CustomMessageListener dRr = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.dRg != null && FrsTabController.this.dRh != null && FrsTabController.this.dRh.nS(FrsTabController.dQX) != null) {
                FrsTabController.this.dRg.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener dRs = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.dRg != null && FrsTabController.this.dRh != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.dRi = aVar.aAL();
                FrsTabController.this.dRj = aVar.aAM();
            }
        }
    };
    private CustomMessageListener dRt = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.dRg != null && FrsTabController.this.dRh != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.dRg.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener dRu = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.aDF();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.dRj = false;
                    FrsTabController.this.dRg.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a dRv = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void ayJ() {
            if (FrsTabController.this.dRg != null) {
                if (FrsTabController.this.dRg.getCurrentItem() == 0) {
                    FrsTabController.this.dRg.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.dRg.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean ayK() {
            SmartApp smartApp;
            if (FrsTabController.this.dRg.getCurrentItem() == 0) {
                if (FrsTabController.this.dRi && FrsTabController.this.dRj) {
                    FrsTabController.this.dRg.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.dRj) {
                    FrsTabController.this.dRg.setmDisallowSlip(true);
                }
                FrsTabController.this.dRg.setmDisallowSlip(true);
            } else {
                FrsTabController.this.dRg.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.ayv().azp().hcL == null || FrsTabController.this.ayv().azp().hcL.size() != 1) && (FrsTabController.this.ayv().azp().hcL != null || FrsTabController.this.ayv().azp().hcM == null)) || (smartApp = FrsTabController.this.ayv().azp().hcM) == null || !com.baidu.tieba.aiapps.a.u(smartApp.id, smartApp.link, "9101")) {
                return true;
            }
            TiebaStatic.log(new am("c13274").ax(ImageViewerConfig.FORUM_ID, FrsTabController.this.ayv().getForumId()).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax("obj_name", FrsTabController.this.ayv().azp().hcM.name).ax(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.ayv().azp().hcM.id).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
            return false;
        }
    };
    private String dRd = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    /* JADX INFO: Access modifiers changed from: private */
    public void aDF() {
        if (this.dRa != null && ayv() != null) {
            this.dRa.dUz = true;
            this.dRa.clear();
            if (!j.kV()) {
                this.dRa.oe(ayv().getForumId());
            } else if ((ayv().azp().hcL != null && ayv().azp().hcL.size() == 1) || (ayv().azp().hcL == null && ayv().azp().hcM != null)) {
                SmartApp smartApp = ayv().azp().hcM;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.u(smartApp.id, smartApp.link, "9101")) {
                    String str = null;
                    if (ayv().azp() != null && ayv().azp().hcM != null) {
                        str = ayv().azp().hcM.h5_url;
                    }
                    this.dRa.og(str);
                }
                TiebaStatic.log(new am("c13274").ax(ImageViewerConfig.FORUM_ID, ayv().getForumId()).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax("obj_name", ayv().azp().hcM.name).ax(VideoPlayActivityConfig.OBJ_ID, ayv().azp().hcM.id).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
            } else {
                this.dRa.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.dRa;
                String forumId = ayv().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.dRa;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.dRa;
                frsLiteProgramListFragment.r(forumId, 1, 10);
                TiebaStatic.log(new am("c13273").ax(ImageViewerConfig.FORUM_ID, ayv().getForumId()).ax("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.dQZ = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.dQZ != null) {
            this.dQZ.setContentView(e.h.frs_base_layout);
            this.dRg = (FrsBaseViewPager) this.dQZ.findViewById(e.g.frs_base_viewpager);
            this.dRh = new FragmentAdapter(this.dQZ.getSupportFragmentManager());
            this.dRg.setAdapter(this.dRh);
            this.dRg.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.dRg.addOnPageChangeListener(this.dRu);
            this.dRg.setmDisallowSlip(true);
            this.dRg.setOnTouchEventListener(this.dRv);
            this.dQZ.registerListener(this.dRs);
            this.dQZ.registerListener(this.dRt);
            this.dQZ.registerListener(this.dRq);
            this.dQZ.registerListener(this.dRr);
            this.dRk.getHttpMessageListener().setPriority(-1);
            this.dRk.getSocketMessageListener().setPriority(-1);
            this.dQZ.registerListener(this.dRl);
            this.dRn.setSelfListener(true);
            this.dQZ.registerListener(this.dRn);
            this.dRm.setSelfListener(true);
            this.dQZ.registerListener(this.dRm);
            this.dQZ.registerListener(this.bMF);
            if (bundle == null) {
                this.mForumName = this.dQZ.getIntent().getStringExtra("name");
                this.dEF = this.dQZ.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.dEF = bundle.getInt("default_tab_id", 0);
            }
            o(bundle);
            this.dRh.notifyDataSetChanged();
            this.dRe = new ShareSuccessReplyToServerModel();
            this.dQZ.registerListener(this.dRk);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.dEF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.dRh != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.dRh.nS(dQW);
                if (frsFragment == null) {
                    frsFragment = p(bundle);
                }
                if (!dQW.equals(this.dRh.mD(0))) {
                    if (dQY.equals(this.dRh.mD(0))) {
                        this.dRh.mC(0);
                    }
                    this.dRh.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(i iVar) {
        if (iVar != null && (iVar.hcM != null || !v.I(iVar.hcL))) {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.dRh == null) {
                return false;
            }
            if (dQX.equals(this.dRh.mD(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.dRh.nS(dQX);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = aDH();
                }
                this.dRh.a(1, frsLiteProgramListFragment);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDG() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.dRh != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.dRh.nS(dQY);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = aDI();
                }
                if (!dQY.equals(this.dRh.mD(0))) {
                    if (dQW.equals(this.dRh.mD(0))) {
                        this.dRh.mC(0);
                    }
                    this.dRh.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment p(Bundle bundle) {
        if (this.dED == null) {
            this.dED = new FrsFragment();
            this.dED.setArguments(bundle);
            this.dED.setBaseTag(dQW);
        }
        this.dED.dBJ = false;
        return this.dED;
    }

    private FrsLiteProgramListFragment aDH() {
        if (this.dRa == null) {
            this.dRa = new FrsLiteProgramListFragment();
            this.dRa.setBaseTag(dQX);
        }
        return this.dRa;
    }

    private FrsTabHostFragment aDI() {
        if (this.dRb == null) {
            this.dRb = new FrsTabHostFragment();
            this.dRb.setBaseTag(dQY);
        }
        return this.dRb;
    }

    private FragmentManager getFragmentManager() {
        if (this.dQZ != null) {
            return this.dQZ.getSupportFragmentManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final i iVar) {
        if (v.H(iVar.bAa()) > 0) {
            this.dEE = iVar;
            if (!this.dQZ.isLoadingViewAttached() && !aDM()) {
                this.dQZ.showLoadingView(this.dQZ.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                @Override // java.lang.Runnable
                public void run() {
                    boolean c = FrsTabController.this.c(iVar);
                    FrsTabController.this.e(iVar);
                    boolean bI = FrsTabController.this.bI(FrsTabController.this.dEE.bAa());
                    if (c || bI) {
                        FrsTabController.this.dRh.notifyDataSetChanged();
                        if (bI && FrsTabController.this.dRb != null) {
                            FrsTabController.this.dRb.C(FrsTabController.this.dED);
                            FrsTabController.this.dRb.a(FrsTabController.this.dEE, FrsTabController.this.dEC);
                        }
                    }
                }
            });
        } else if (aDM()) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                @Override // java.lang.Runnable
                public void run() {
                    FrsTabController.this.c(iVar);
                    FrsTabController.this.dED.dBJ = true;
                    FrsTabController.this.o(FrsTabController.this.dED != null ? FrsTabController.this.dED.getArguments() : null);
                    FrsTabController.this.dRh.notifyDataSetChanged();
                    FrsTabController.this.e(iVar);
                    if (FrsTabController.this.dED instanceof NavigationBar.a) {
                        FrsTabController.this.dED.b((Pair<Integer, Integer>) null);
                    }
                }
            });
        } else if (iVar != null) {
            if (iVar.hcM != null || !v.I(iVar.hcL)) {
                if (!this.dQZ.isLoadingViewAttached() && !aDN()) {
                    this.dQZ.showLoadingView(this.dQZ.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsTabController.this.c(iVar)) {
                            FrsTabController.this.e(iVar);
                            FrsTabController.this.dRh.notifyDataSetChanged();
                        }
                        if (FrsTabController.this.dQZ.isLoadingViewAttached()) {
                            FrsTabController.this.dQZ.hideLoadingView(FrsTabController.this.dQZ.findViewById(16908290));
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(i iVar) {
        if (iVar != null) {
            if (iVar.hcM != null || !v.I(iVar.hcL)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bI(List<FrsTabInfo> list) {
        if (this.dQZ.isLoadingViewAttached()) {
            this.dQZ.hideLoadingView(this.dQZ.findViewById(16908290));
        }
        if (aDM()) {
            return false;
        }
        this.dED.dBJ = true;
        aDJ();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", true);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_game_login_tip", false);
        }
        bJ(list);
        return true;
    }

    private void aDJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dQZ.registerListener(1021074, this.dRo);
    }

    private void bJ(List<FrsTabInfo> list) {
        List list2;
        boolean z;
        if (!v.I(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(FrsTabController.this.dRd, true)) {
                            com.baidu.adp.lib.g.e.jG().post(FrsTabController.this.dRp);
                        }
                        FrsTabController.this.aDG();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.dQZ.registerListener(customMessageListener);
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
            FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
            builder.tab_id = 99;
            builder.tab_name = this.dQZ.getResources().getString(e.j.send);
            builder.tab_type = 0;
            int H = v.H(arrayList);
            if (H > 4) {
                list2 = arrayList.subList(0, 4);
                list2.add(2, builder.build(false));
            } else if (H < 2) {
                arrayList.add(builder.build(false));
                list2 = arrayList;
            } else {
                arrayList.add(H / 2, builder.build(false));
                list2 = arrayList;
            }
            this.dEC = new ad(this.dQZ.getActivity(), list2);
            if (ayv() != null) {
                this.dEC.setForumId(ayv().getForumId());
                this.dEC.setForumName(ayv().getForumName());
                if (ayv().azp() != null && ayv().azp().ber() != null) {
                    ForumData ber = ayv().azp().ber();
                    this.dEC.setForumGameLabel(ber.getForumGameLabel());
                    this.dEC.nD(ber.getSpecialForumType());
                }
            }
            this.dED.dBJ = false;
            new d(this.dED).a(this.dEC);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.dEC);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.dQZ.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDK() {
        if (this.dEC != null && !TextUtils.isEmpty(this.dEC.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.dEE.ber().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar aaO;
        if ((fragment instanceof ak) && this.dEE != null && this.dEE.ber() != null && (aaO = ((ak) fragment).aaO()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dEE.ber().getName(), 5, true, true) + this.dQZ.getActivity().getString(e.j.forum));
            aaO.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dED instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dED.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a he(int i) {
        if (this.dED instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dED.he(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dED instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dED.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.dED != null) {
            this.dED.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!aDM()) {
            this.dED.setPrimary(true);
        } else if (this.dRb != null) {
            Fragment currentFragment = this.dRb.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.dRf) {
            this.dRf = false;
            if (this.dED != null) {
                this.dED.refresh();
            }
        }
    }

    public void onPause() {
        if (!aDM()) {
            this.dED.setPrimary(false);
        } else if (this.dRb != null) {
            Fragment currentFragment = this.dRb.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.dED != null) {
            this.dED.onChangeSkinType(i);
        }
        if (this.dRb != null) {
            this.dRb.onChangeSkinType(i);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.dRa != null && this.dRa.dUz) {
                this.dRa.dUz = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            }
            if (aDM() && this.dRb != null && this.dRb.aAF()) {
                this.dRb.aAG();
                UtilHelper.setNavigationBarBackground(this.dQZ, this.dRb.gG(true));
            } else if (this.dED != null && this.dED.isAdded()) {
                if (this.dED.onKeyDown(i, keyEvent)) {
                    return true;
                }
                aDL();
            } else {
                return this.dQZ.b(i, keyEvent);
            }
            return false;
        }
        return this.dQZ.b(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDL() {
        if (this.dEG != this.dEF && aDM() && this.dRb != null && !this.dRb.aAB()) {
            this.dRb.setCurrentTab(this.dEF);
            if (lV(this.dEF) != 1) {
                this.dED.gs(false);
            }
            this.dEG = this.dEF;
            a(this.dRb.getCurrentFragment(), this.dEF);
            return;
        }
        this.dED.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!aDM()) {
            this.dED.onActivityResult(i, i2, intent);
        } else if (this.dRb != null) {
            if (99 == this.dRb.getCurrentTabType() || 1 == this.dRb.getCurrentTabType()) {
                this.dED.onActivityResult(i, i2, intent);
            } else {
                this.dRb.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.bso().x(this.dQZ.getPageContext());
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.dRe != null) {
                        this.dRe.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void HU() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.dQZ != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.dQZ.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.bso().x(this.dQZ.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!aDM()) {
            return this.dED.getVoiceManager();
        }
        if (this.dRb == null) {
            return null;
        }
        Fragment currentFragment = this.dRb.getCurrentFragment();
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
    public int lT(int i) {
        if (this.dEC == null) {
            return -1;
        }
        int H = v.H(this.dEC.aAO());
        for (int i2 = 0; i2 < H; i2++) {
            if (this.dEC.aAO().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lV(int i) {
        if (this.dEC != null && i < v.H(this.dEC.aAO())) {
            return this.dEC.aAO().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment ayv() {
        return this.dED;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> ayw() {
        if (!aDM()) {
            if (this.dED instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.dED).ayw();
            }
        } else if (this.dRb == null) {
            return null;
        } else {
            Fragment currentFragment = this.dRb.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).ayw();
            }
        }
        return null;
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.dQZ.isLoadingViewAttached()) {
            this.dQZ.hideLoadingView(this.dQZ.findViewById(16908290));
        }
        if (this.dRp != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dRp);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.dRd, false);
        if (this.dRe != null) {
            this.dRe.cancelLoadData();
        }
    }

    public FragmentTabHost aAE() {
        if (this.dRb == null) {
            return null;
        }
        return this.dRb.aAE();
    }

    public void gH(boolean z) {
        if (this.dRb != null) {
            this.dRb.gH(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aDM() {
        if (this.dRh == null) {
            return false;
        }
        return this.dRh.getItem(0) instanceof FrsTabHostFragment;
    }

    private boolean aDN() {
        if (this.dRh == null) {
            return false;
        }
        return this.dRh.getItem(1) instanceof FrsLiteProgramListFragment;
    }

    /* loaded from: classes6.dex */
    public class FragmentAdapter extends FragmentStatePagerAdapter {
        private List<BaseFragment> mFragments;

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.mFragments = new ArrayList(2);
        }

        @Override // android.support.v4.app.FragmentStatePagerAdapter, android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            try {
                return super.instantiateItem(viewGroup, i);
            } catch (Exception e) {
                return v.d(this.mFragments, i);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v4.app.FragmentStatePagerAdapter
        /* renamed from: mB */
        public BaseFragment getItem(int i) {
            return (BaseFragment) v.d(this.mFragments, i);
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

        public BaseFragment nS(String str) {
            if (ao.isEmpty(str)) {
                return null;
            }
            for (BaseFragment baseFragment : this.mFragments) {
                if (baseFragment != null && str.equals(baseFragment.getBaseTag())) {
                    return baseFragment;
                }
            }
            return null;
        }

        public BaseFragment mC(int i) {
            return (BaseFragment) v.e(this.mFragments, i);
        }

        public String mD(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }
}
