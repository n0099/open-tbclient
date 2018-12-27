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
    public static final String eap = FrsFragment.class.getSimpleName();
    public static final String eaq = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String ear = FrsTabHostFragment.class.getSimpleName();
    private ad dNP;
    private FrsFragment dNQ;
    private i dNR;
    private int dNT;
    private FragmentAdapter eaA;
    private boolean eaB;
    private boolean eaC;
    private FrsActivity eas;
    private FrsLiteProgramListFragment eat;
    private FrsTabHostFragment eau;
    private ShareSuccessReplyToServerModel eax;
    private FrsBaseViewPager eaz;
    private String mForumName;
    private boolean eav = false;
    private final Handler mHandler = new Handler();
    private int dNS = 0;
    private boolean eay = false;
    private com.baidu.adp.framework.listener.a eaD = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            i iVar = null;
            if (!FrsTabController.this.eav && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    iVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    iVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (iVar != null) {
                    FrsTabController.this.eav = true;
                    FrsTabController.this.d(iVar);
                }
            }
        }
    };
    private CustomMessageListener eaE = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.eav && FrsTabController.this.dNR == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                i iVar = (i) customResponsedMessage.getData();
                if (iVar.bgT() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(iVar.bgT().getName())) {
                    FrsTabController.this.d(iVar);
                }
            }
        }
    };
    private CustomMessageListener eaF = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.aGm();
        }
    };
    private CustomMessageListener eaG = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int mw;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    mw = FrsTabController.this.mw(9);
                    if (mw == -1) {
                        mw = FrsTabController.this.mw(2);
                    }
                } else {
                    mw = FrsTabController.this.mw(intValue);
                }
                if (mw != -1 && FrsTabController.this.aGn() && FrsTabController.this.eau != null) {
                    FrsTabController.this.eau.setCurrentTab(mw);
                    if (FrsTabController.this.my(mw) != 1) {
                        FrsTabController.this.dNQ.gw(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener eaH = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.I(newNotifyData) && FrsTabController.this.eau != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.dNP.aDn().size(); i++) {
                                FragmentTabHost.b dy = FrsTabController.this.eau.dy(i);
                                if (dy != null && dy.mType != 99 && dy.mType != 1 && dy.mType != FrsTabController.this.eau.getCurrentTabType() && dy.mType == aVar.getTabId() && aVar.aGf() && dy.azy.ip(String.valueOf(dy.mType)) != null) {
                                    dy.azy.ip(String.valueOf(dy.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable eaI = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        @Override // java.lang.Runnable
        public void run() {
            e.jG().removeCallbacks(this);
            FrsTabController.this.aGl();
            e.jG().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private CustomMessageListener bQy = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.eay = true;
            }
        }
    };
    private CustomMessageListener eaJ = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!g.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.eaz != null && FrsTabController.this.eaA != null && FrsTabController.this.eaA.ow(FrsTabController.eaq) != null) {
                if (!j.kV()) {
                    FrsTabController.this.eas.showToast(FrsTabController.this.eas.getString(e.j.neterror));
                } else if ((FrsTabController.this.aAU().aBO().hmP == null || FrsTabController.this.aAU().aBO().hmP.size() != 1) && (FrsTabController.this.aAU().aBO().hmP != null || FrsTabController.this.aAU().aBO().hmQ == null)) {
                    FrsTabController.this.eaz.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.aAU().aBO().hmQ;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.u(smartApp.id, smartApp.link, "1191003700000000")) {
                        FrsTabController.this.eaz.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new am("c13274").aA(ImageViewerConfig.FORUM_ID, FrsTabController.this.aAU().getForumId()).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA("obj_name", FrsTabController.this.aAU().aBO().hmQ.name).aA(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.aAU().aBO().hmQ.id).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
                    }
                }
            }
        }
    };
    private CustomMessageListener eaK = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.eaz != null && FrsTabController.this.eaA != null && FrsTabController.this.eaA.ow(FrsTabController.eaq) != null) {
                FrsTabController.this.eaz.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener eaL = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.eaz != null && FrsTabController.this.eaA != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.eaB = aVar.aDk();
                FrsTabController.this.eaC = aVar.aDl();
            }
        }
    };
    private CustomMessageListener eaM = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.eaz != null && FrsTabController.this.eaA != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.eaz.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener eaN = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.aGg();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.eaC = false;
                    FrsTabController.this.eaz.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a eaO = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void aBi() {
            if (FrsTabController.this.eaz != null) {
                if (FrsTabController.this.eaz.getCurrentItem() == 0) {
                    FrsTabController.this.eaz.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.eaz.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean aBj() {
            SmartApp smartApp;
            if (FrsTabController.this.eaz.getCurrentItem() == 0) {
                if (FrsTabController.this.eaB && FrsTabController.this.eaC) {
                    FrsTabController.this.eaz.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.eaC) {
                    FrsTabController.this.eaz.setmDisallowSlip(true);
                }
                FrsTabController.this.eaz.setmDisallowSlip(true);
            } else {
                FrsTabController.this.eaz.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.aAU().aBO().hmP == null || FrsTabController.this.aAU().aBO().hmP.size() != 1) && (FrsTabController.this.aAU().aBO().hmP != null || FrsTabController.this.aAU().aBO().hmQ == null)) || (smartApp = FrsTabController.this.aAU().aBO().hmQ) == null || !com.baidu.tieba.aiapps.a.u(smartApp.id, smartApp.link, "1191003700000000")) {
                return true;
            }
            TiebaStatic.log(new am("c13274").aA(ImageViewerConfig.FORUM_ID, FrsTabController.this.aAU().getForumId()).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA("obj_name", FrsTabController.this.aAU().aBO().hmQ.name).aA(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.aAU().aBO().hmQ.id).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
            return false;
        }
    };
    private String eaw = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    /* JADX INFO: Access modifiers changed from: private */
    public void aGg() {
        if (this.eat != null && aAU() != null) {
            this.eat.edT = true;
            this.eat.clear();
            if (!j.kV()) {
                this.eat.oI(aAU().getForumId());
            } else if ((aAU().aBO().hmP != null && aAU().aBO().hmP.size() == 1) || (aAU().aBO().hmP == null && aAU().aBO().hmQ != null)) {
                SmartApp smartApp = aAU().aBO().hmQ;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.u(smartApp.id, smartApp.link, "1191003700000000")) {
                    String str = null;
                    if (aAU().aBO() != null && aAU().aBO().hmQ != null) {
                        str = aAU().aBO().hmQ.h5_url;
                    }
                    this.eat.oJ(str);
                }
                TiebaStatic.log(new am("c13274").aA(ImageViewerConfig.FORUM_ID, aAU().getForumId()).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA("obj_name", aAU().aBO().hmQ.name).aA(VideoPlayActivityConfig.OBJ_ID, aAU().aBO().hmQ.id).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
            } else {
                this.eat.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.eat;
                String forumId = aAU().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.eat;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.eat;
                frsLiteProgramListFragment.t(forumId, 1, 10);
                TiebaStatic.log(new am("c13273").aA(ImageViewerConfig.FORUM_ID, aAU().getForumId()).aA("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.eas = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.eas != null) {
            this.eas.setContentView(e.h.frs_base_layout);
            this.eaz = (FrsBaseViewPager) this.eas.findViewById(e.g.frs_base_viewpager);
            this.eaA = new FragmentAdapter(this.eas.getSupportFragmentManager());
            this.eaz.setAdapter(this.eaA);
            this.eaz.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.eaz.addOnPageChangeListener(this.eaN);
            this.eaz.setmDisallowSlip(true);
            this.eaz.setOnTouchEventListener(this.eaO);
            this.eas.registerListener(this.eaL);
            this.eas.registerListener(this.eaM);
            this.eas.registerListener(this.eaJ);
            this.eas.registerListener(this.eaK);
            this.eaD.getHttpMessageListener().setPriority(-1);
            this.eaD.getSocketMessageListener().setPriority(-1);
            this.eas.registerListener(this.eaE);
            this.eaG.setSelfListener(true);
            this.eas.registerListener(this.eaG);
            this.eaF.setSelfListener(true);
            this.eas.registerListener(this.eaF);
            this.eas.registerListener(this.bQy);
            if (bundle == null) {
                this.mForumName = this.eas.getIntent().getStringExtra("name");
                this.dNS = this.eas.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.dNS = bundle.getInt("default_tab_id", 0);
            }
            r(bundle);
            this.eaA.notifyDataSetChanged();
            this.eax = new ShareSuccessReplyToServerModel();
            this.eas.registerListener(this.eaD);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.dNS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.eaA != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.eaA.ow(eap);
                if (frsFragment == null) {
                    frsFragment = s(bundle);
                }
                if (!eap.equals(this.eaA.ng(0))) {
                    if (ear.equals(this.eaA.ng(0))) {
                        this.eaA.nf(0);
                    }
                    this.eaA.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(i iVar) {
        if (iVar != null && (iVar.hmQ != null || !v.I(iVar.hmP))) {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.eaA == null) {
                return false;
            }
            if (eaq.equals(this.eaA.ng(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.eaA.ow(eaq);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = aGi();
                }
                this.eaA.a(1, frsLiteProgramListFragment);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGh() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.eaA != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.eaA.ow(ear);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = aGj();
                }
                if (!ear.equals(this.eaA.ng(0))) {
                    if (eap.equals(this.eaA.ng(0))) {
                        this.eaA.nf(0);
                    }
                    this.eaA.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment s(Bundle bundle) {
        if (this.dNQ == null) {
            this.dNQ = new FrsFragment();
            this.dNQ.setArguments(bundle);
            this.dNQ.setBaseTag(eap);
        }
        this.dNQ.dKW = false;
        return this.dNQ;
    }

    private FrsLiteProgramListFragment aGi() {
        if (this.eat == null) {
            this.eat = new FrsLiteProgramListFragment();
            this.eat.setBaseTag(eaq);
        }
        return this.eat;
    }

    private FrsTabHostFragment aGj() {
        if (this.eau == null) {
            this.eau = new FrsTabHostFragment();
            this.eau.setBaseTag(ear);
        }
        return this.eau;
    }

    private FragmentManager getFragmentManager() {
        if (this.eas != null) {
            return this.eas.getSupportFragmentManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final i iVar) {
        if (v.H(iVar.bCL()) > 0) {
            this.dNR = iVar;
            if (!this.eas.isLoadingViewAttached() && !aGn()) {
                this.eas.showLoadingView(this.eas.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                @Override // java.lang.Runnable
                public void run() {
                    boolean c = FrsTabController.this.c(iVar);
                    FrsTabController.this.e(iVar);
                    boolean bL = FrsTabController.this.bL(FrsTabController.this.dNR.bCL());
                    if (c || bL) {
                        FrsTabController.this.eaA.notifyDataSetChanged();
                        if (bL && FrsTabController.this.eau != null) {
                            FrsTabController.this.eau.D(FrsTabController.this.dNQ);
                            FrsTabController.this.eau.a(FrsTabController.this.dNR, FrsTabController.this.dNP);
                        }
                    }
                }
            });
        } else if (aGn()) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                @Override // java.lang.Runnable
                public void run() {
                    FrsTabController.this.c(iVar);
                    FrsTabController.this.dNQ.dKW = true;
                    FrsTabController.this.r(FrsTabController.this.dNQ != null ? FrsTabController.this.dNQ.getArguments() : null);
                    FrsTabController.this.eaA.notifyDataSetChanged();
                    FrsTabController.this.e(iVar);
                    if (FrsTabController.this.dNQ instanceof NavigationBar.a) {
                        FrsTabController.this.dNQ.b((Pair<Integer, Integer>) null);
                    }
                }
            });
        } else if (iVar != null) {
            if (iVar.hmQ != null || !v.I(iVar.hmP)) {
                if (!this.eas.isLoadingViewAttached() && !aGo()) {
                    this.eas.showLoadingView(this.eas.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsTabController.this.c(iVar)) {
                            FrsTabController.this.e(iVar);
                            FrsTabController.this.eaA.notifyDataSetChanged();
                        }
                        if (FrsTabController.this.eas.isLoadingViewAttached()) {
                            FrsTabController.this.eas.hideLoadingView(FrsTabController.this.eas.findViewById(16908290));
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(i iVar) {
        if (iVar != null) {
            if (iVar.hmQ != null || !v.I(iVar.hmP)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bL(List<FrsTabInfo> list) {
        if (this.eas.isLoadingViewAttached()) {
            this.eas.hideLoadingView(this.eas.findViewById(16908290));
        }
        if (aGn()) {
            return false;
        }
        this.dNQ.dKW = true;
        aGk();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", true);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_game_login_tip", false);
        }
        bM(list);
        return true;
    }

    private void aGk() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.eas.registerListener(1021074, this.eaH);
    }

    private void bM(List<FrsTabInfo> list) {
        List list2;
        boolean z;
        if (!v.I(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(FrsTabController.this.eaw, true)) {
                            com.baidu.adp.lib.g.e.jG().post(FrsTabController.this.eaI);
                        }
                        FrsTabController.this.aGh();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.eas.registerListener(customMessageListener);
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
            builder.tab_name = this.eas.getResources().getString(e.j.send);
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
            this.dNP = new ad(this.eas.getActivity(), list2);
            if (aAU() != null) {
                this.dNP.setForumId(aAU().getForumId());
                this.dNP.setForumName(aAU().getForumName());
                if (aAU().aBO() != null && aAU().aBO().bgT() != null) {
                    ForumData bgT = aAU().aBO().bgT();
                    this.dNP.setForumGameLabel(bgT.getForumGameLabel());
                    this.dNP.og(bgT.getSpecialForumType());
                }
            }
            this.dNQ.dKW = false;
            new d(this.dNQ).a(this.dNP);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.dNP);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.eas.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGl() {
        if (this.dNP != null && !TextUtils.isEmpty(this.dNP.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.dNR.bgT().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar abW;
        if ((fragment instanceof ak) && this.dNR != null && this.dNR.bgT() != null && (abW = ((ak) fragment).abW()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dNR.bgT().getName(), 5, true, true) + this.eas.getActivity().getString(e.j.forum));
            abW.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dNQ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dNQ.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ht(int i) {
        if (this.dNQ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dNQ.ht(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dNQ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dNQ.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.dNQ != null) {
            this.dNQ.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!aGn()) {
            this.dNQ.setPrimary(true);
        } else if (this.eau != null) {
            Fragment currentFragment = this.eau.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.eay) {
            this.eay = false;
            if (this.dNQ != null) {
                this.dNQ.refresh();
            }
        }
    }

    public void onPause() {
        if (!aGn()) {
            this.dNQ.setPrimary(false);
        } else if (this.eau != null) {
            Fragment currentFragment = this.eau.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.dNQ != null) {
            this.dNQ.onChangeSkinType(i);
        }
        if (this.eau != null) {
            this.eau.onChangeSkinType(i);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.eat != null && this.eat.edT) {
                this.eat.edT = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            }
            if (aGn() && this.eau != null && this.eau.aDe()) {
                this.eau.aDf();
                UtilHelper.setNavigationBarBackground(this.eas, this.eau.gK(true));
            } else if (this.dNQ != null && this.dNQ.isAdded()) {
                if (this.dNQ.onKeyDown(i, keyEvent)) {
                    return true;
                }
                aGm();
            } else {
                return this.eas.b(i, keyEvent);
            }
            return false;
        }
        return this.eas.b(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGm() {
        if (this.dNT != this.dNS && aGn() && this.eau != null && !this.eau.aDa()) {
            this.eau.setCurrentTab(this.dNS);
            if (my(this.dNS) != 1) {
                this.dNQ.gw(false);
            }
            this.dNT = this.dNS;
            a(this.eau.getCurrentFragment(), this.dNS);
            return;
        }
        this.dNQ.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!aGn()) {
            this.dNQ.onActivityResult(i, i2, intent);
        } else if (this.eau != null) {
            if (99 == this.eau.getCurrentTabType() || 1 == this.eau.getCurrentTabType()) {
                this.dNQ.onActivityResult(i, i2, intent);
            } else {
                this.eau.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.buS().x(this.eas.getPageContext());
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.eax != null) {
                        this.eax.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void IZ() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.eas != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.eas.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.buS().x(this.eas.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!aGn()) {
            return this.dNQ.getVoiceManager();
        }
        if (this.eau == null) {
            return null;
        }
        Fragment currentFragment = this.eau.getCurrentFragment();
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
    public int mw(int i) {
        if (this.dNP == null) {
            return -1;
        }
        int H = v.H(this.dNP.aDn());
        for (int i2 = 0; i2 < H; i2++) {
            if (this.dNP.aDn().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int my(int i) {
        if (this.dNP != null && i < v.H(this.dNP.aDn())) {
            return this.dNP.aDn().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment aAU() {
        return this.dNQ;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aAV() {
        if (!aGn()) {
            if (this.dNQ instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.dNQ).aAV();
            }
        } else if (this.eau == null) {
            return null;
        } else {
            Fragment currentFragment = this.eau.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).aAV();
            }
        }
        return null;
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eas.isLoadingViewAttached()) {
            this.eas.hideLoadingView(this.eas.findViewById(16908290));
        }
        if (this.eaI != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.eaI);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.eaw, false);
        if (this.eax != null) {
            this.eax.cancelLoadData();
        }
        if (this.dNQ != null && this.dNQ.aBs() != null) {
            this.dNQ.aBs().onActivityDestroy();
        }
    }

    public FragmentTabHost aDd() {
        if (this.eau == null) {
            return null;
        }
        return this.eau.aDd();
    }

    public void gL(boolean z) {
        if (this.eau != null) {
            this.eau.gL(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aGn() {
        if (this.eaA == null) {
            return false;
        }
        return this.eaA.getItem(0) instanceof FrsTabHostFragment;
    }

    private boolean aGo() {
        if (this.eaA == null) {
            return false;
        }
        return this.eaA.getItem(1) instanceof FrsLiteProgramListFragment;
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
        /* renamed from: ne */
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

        public BaseFragment ow(String str) {
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

        public BaseFragment nf(int i) {
            return (BaseFragment) v.e(this.mFragments, i);
        }

        public String ng(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }
}
