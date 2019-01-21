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
    public static final String eaW = FrsFragment.class.getSimpleName();
    public static final String eaX = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String eaY = FrsTabHostFragment.class.getSimpleName();
    private FrsFragment dOA;
    private i dOB;
    private int dOD;
    private ad dOz;
    private FrsActivity eaZ;
    private FrsLiteProgramListFragment eba;
    private FrsTabHostFragment ebb;
    private ShareSuccessReplyToServerModel ebe;
    private FrsBaseViewPager ebg;
    private FragmentAdapter ebh;
    private boolean ebi;
    private boolean ebj;
    private String mForumName;
    private boolean ebc = false;
    private final Handler mHandler = new Handler();
    private int dOC = 0;
    private boolean ebf = false;
    private com.baidu.adp.framework.listener.a ebk = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            i iVar = null;
            if (!FrsTabController.this.ebc && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    iVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    iVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (iVar != null) {
                    FrsTabController.this.ebc = true;
                    FrsTabController.this.d(iVar);
                }
            }
        }
    };
    private CustomMessageListener ebl = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.ebc && FrsTabController.this.dOB == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                i iVar = (i) customResponsedMessage.getData();
                if (iVar.bhx() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(iVar.bhx().getName())) {
                    FrsTabController.this.d(iVar);
                }
            }
        }
    };
    private CustomMessageListener ebm = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.aGJ();
        }
    };
    private CustomMessageListener ebn = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int mx;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    mx = FrsTabController.this.mx(9);
                    if (mx == -1) {
                        mx = FrsTabController.this.mx(2);
                    }
                } else {
                    mx = FrsTabController.this.mx(intValue);
                }
                if (mx != -1 && FrsTabController.this.aGK() && FrsTabController.this.ebb != null) {
                    FrsTabController.this.ebb.setCurrentTab(mx);
                    if (FrsTabController.this.mz(mx) != 1) {
                        FrsTabController.this.dOA.gz(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener ebo = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.I(newNotifyData) && FrsTabController.this.ebb != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.dOz.aDK().size(); i++) {
                                FragmentTabHost.b dy = FrsTabController.this.ebb.dy(i);
                                if (dy != null && dy.mType != 99 && dy.mType != 1 && dy.mType != FrsTabController.this.ebb.getCurrentTabType() && dy.mType == aVar.getTabId() && aVar.aGC() && dy.aAb.iD(String.valueOf(dy.mType)) != null) {
                                    dy.aAb.iD(String.valueOf(dy.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable ebp = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        @Override // java.lang.Runnable
        public void run() {
            e.jG().removeCallbacks(this);
            FrsTabController.this.aGI();
            e.jG().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private CustomMessageListener bRk = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.ebf = true;
            }
        }
    };
    private CustomMessageListener ebq = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!g.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.ebg != null && FrsTabController.this.ebh != null && FrsTabController.this.ebh.oM(FrsTabController.eaX) != null) {
                if (!j.kV()) {
                    FrsTabController.this.eaZ.showToast(FrsTabController.this.eaZ.getString(e.j.neterror));
                } else if ((FrsTabController.this.aBr().aCl().hnV == null || FrsTabController.this.aBr().aCl().hnV.size() != 1) && (FrsTabController.this.aBr().aCl().hnV != null || FrsTabController.this.aBr().aCl().hnW == null)) {
                    FrsTabController.this.ebg.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.aBr().aCl().hnW;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.u(smartApp.id, smartApp.link, "1191003700000000")) {
                        FrsTabController.this.ebg.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new am("c13274").aB(ImageViewerConfig.FORUM_ID, FrsTabController.this.aBr().getForumId()).aB("uid", TbadkCoreApplication.getCurrentAccount()).aB("obj_name", FrsTabController.this.aBr().aCl().hnW.name).aB(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.aBr().aCl().hnW.id).aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
                    }
                }
            }
        }
    };
    private CustomMessageListener ebr = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.ebg != null && FrsTabController.this.ebh != null && FrsTabController.this.ebh.oM(FrsTabController.eaX) != null) {
                FrsTabController.this.ebg.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener ebs = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.ebg != null && FrsTabController.this.ebh != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.ebi = aVar.aDH();
                FrsTabController.this.ebj = aVar.aDI();
            }
        }
    };
    private CustomMessageListener ebt = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.ebg != null && FrsTabController.this.ebh != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.ebg.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener ebu = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.aGD();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.ebj = false;
                    FrsTabController.this.ebg.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a ebv = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void aBF() {
            if (FrsTabController.this.ebg != null) {
                if (FrsTabController.this.ebg.getCurrentItem() == 0) {
                    FrsTabController.this.ebg.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.ebg.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean aBG() {
            SmartApp smartApp;
            if (FrsTabController.this.ebg.getCurrentItem() == 0) {
                if (FrsTabController.this.ebi && FrsTabController.this.ebj) {
                    FrsTabController.this.ebg.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.ebj) {
                    FrsTabController.this.ebg.setmDisallowSlip(true);
                }
                FrsTabController.this.ebg.setmDisallowSlip(true);
            } else {
                FrsTabController.this.ebg.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.aBr().aCl().hnV == null || FrsTabController.this.aBr().aCl().hnV.size() != 1) && (FrsTabController.this.aBr().aCl().hnV != null || FrsTabController.this.aBr().aCl().hnW == null)) || (smartApp = FrsTabController.this.aBr().aCl().hnW) == null || !com.baidu.tieba.aiapps.a.u(smartApp.id, smartApp.link, "1191003700000000")) {
                return true;
            }
            TiebaStatic.log(new am("c13274").aB(ImageViewerConfig.FORUM_ID, FrsTabController.this.aBr().getForumId()).aB("uid", TbadkCoreApplication.getCurrentAccount()).aB("obj_name", FrsTabController.this.aBr().aCl().hnW.name).aB(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.aBr().aCl().hnW.id).aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
            return false;
        }
    };
    private String ebd = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    /* JADX INFO: Access modifiers changed from: private */
    public void aGD() {
        if (this.eba != null && aBr() != null) {
            this.eba.eeA = true;
            this.eba.clear();
            if (!j.kV()) {
                this.eba.oY(aBr().getForumId());
            } else if ((aBr().aCl().hnV != null && aBr().aCl().hnV.size() == 1) || (aBr().aCl().hnV == null && aBr().aCl().hnW != null)) {
                SmartApp smartApp = aBr().aCl().hnW;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.u(smartApp.id, smartApp.link, "1191003700000000")) {
                    String str = null;
                    if (aBr().aCl() != null && aBr().aCl().hnW != null) {
                        str = aBr().aCl().hnW.h5_url;
                    }
                    this.eba.oZ(str);
                }
                TiebaStatic.log(new am("c13274").aB(ImageViewerConfig.FORUM_ID, aBr().getForumId()).aB("uid", TbadkCoreApplication.getCurrentAccount()).aB("obj_name", aBr().aCl().hnW.name).aB(VideoPlayActivityConfig.OBJ_ID, aBr().aCl().hnW.id).aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
            } else {
                this.eba.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.eba;
                String forumId = aBr().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.eba;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.eba;
                frsLiteProgramListFragment.t(forumId, 1, 10);
                TiebaStatic.log(new am("c13273").aB(ImageViewerConfig.FORUM_ID, aBr().getForumId()).aB("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.eaZ = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.eaZ != null) {
            this.eaZ.setContentView(e.h.frs_base_layout);
            this.ebg = (FrsBaseViewPager) this.eaZ.findViewById(e.g.frs_base_viewpager);
            this.ebh = new FragmentAdapter(this.eaZ.getSupportFragmentManager());
            this.ebg.setAdapter(this.ebh);
            this.ebg.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.ebg.addOnPageChangeListener(this.ebu);
            this.ebg.setmDisallowSlip(true);
            this.ebg.setOnTouchEventListener(this.ebv);
            this.eaZ.registerListener(this.ebs);
            this.eaZ.registerListener(this.ebt);
            this.eaZ.registerListener(this.ebq);
            this.eaZ.registerListener(this.ebr);
            this.ebk.getHttpMessageListener().setPriority(-1);
            this.ebk.getSocketMessageListener().setPriority(-1);
            this.eaZ.registerListener(this.ebl);
            this.ebn.setSelfListener(true);
            this.eaZ.registerListener(this.ebn);
            this.ebm.setSelfListener(true);
            this.eaZ.registerListener(this.ebm);
            this.eaZ.registerListener(this.bRk);
            if (bundle == null) {
                this.mForumName = this.eaZ.getIntent().getStringExtra("name");
                this.dOC = this.eaZ.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.dOC = bundle.getInt("default_tab_id", 0);
            }
            r(bundle);
            this.ebh.notifyDataSetChanged();
            this.ebe = new ShareSuccessReplyToServerModel();
            this.eaZ.registerListener(this.ebk);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.dOC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.ebh != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.ebh.oM(eaW);
                if (frsFragment == null) {
                    frsFragment = s(bundle);
                }
                if (!eaW.equals(this.ebh.nh(0))) {
                    if (eaY.equals(this.ebh.nh(0))) {
                        this.ebh.ng(0);
                    }
                    this.ebh.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(i iVar) {
        if (iVar != null && (iVar.hnW != null || !v.I(iVar.hnV))) {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.ebh == null) {
                return false;
            }
            if (eaX.equals(this.ebh.nh(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.ebh.oM(eaX);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = aGF();
                }
                this.ebh.a(1, frsLiteProgramListFragment);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGE() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.ebh != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.ebh.oM(eaY);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = aGG();
                }
                if (!eaY.equals(this.ebh.nh(0))) {
                    if (eaW.equals(this.ebh.nh(0))) {
                        this.ebh.ng(0);
                    }
                    this.ebh.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment s(Bundle bundle) {
        if (this.dOA == null) {
            this.dOA = new FrsFragment();
            this.dOA.setArguments(bundle);
            this.dOA.setBaseTag(eaW);
        }
        this.dOA.dLG = false;
        return this.dOA;
    }

    private FrsLiteProgramListFragment aGF() {
        if (this.eba == null) {
            this.eba = new FrsLiteProgramListFragment();
            this.eba.setBaseTag(eaX);
        }
        return this.eba;
    }

    private FrsTabHostFragment aGG() {
        if (this.ebb == null) {
            this.ebb = new FrsTabHostFragment();
            this.ebb.setBaseTag(eaY);
        }
        return this.ebb;
    }

    private FragmentManager getFragmentManager() {
        if (this.eaZ != null) {
            return this.eaZ.getSupportFragmentManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final i iVar) {
        if (v.H(iVar.bDu()) > 0) {
            this.dOB = iVar;
            if (!this.eaZ.isLoadingViewAttached() && !aGK()) {
                this.eaZ.showLoadingView(this.eaZ.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                @Override // java.lang.Runnable
                public void run() {
                    boolean c = FrsTabController.this.c(iVar);
                    FrsTabController.this.e(iVar);
                    boolean bM = FrsTabController.this.bM(FrsTabController.this.dOB.bDu());
                    if (c || bM) {
                        FrsTabController.this.ebh.notifyDataSetChanged();
                        if (bM && FrsTabController.this.ebb != null) {
                            FrsTabController.this.ebb.D(FrsTabController.this.dOA);
                            FrsTabController.this.ebb.a(FrsTabController.this.dOB, FrsTabController.this.dOz);
                        }
                    }
                }
            });
        } else if (aGK()) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                @Override // java.lang.Runnable
                public void run() {
                    FrsTabController.this.c(iVar);
                    FrsTabController.this.dOA.dLG = true;
                    FrsTabController.this.r(FrsTabController.this.dOA != null ? FrsTabController.this.dOA.getArguments() : null);
                    FrsTabController.this.ebh.notifyDataSetChanged();
                    FrsTabController.this.e(iVar);
                    if (FrsTabController.this.dOA instanceof NavigationBar.a) {
                        FrsTabController.this.dOA.b((Pair<Integer, Integer>) null);
                    }
                }
            });
        } else if (iVar != null) {
            if (iVar.hnW != null || !v.I(iVar.hnV)) {
                if (!this.eaZ.isLoadingViewAttached() && !aGL()) {
                    this.eaZ.showLoadingView(this.eaZ.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsTabController.this.c(iVar)) {
                            FrsTabController.this.e(iVar);
                            FrsTabController.this.ebh.notifyDataSetChanged();
                        }
                        if (FrsTabController.this.eaZ.isLoadingViewAttached()) {
                            FrsTabController.this.eaZ.hideLoadingView(FrsTabController.this.eaZ.findViewById(16908290));
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(i iVar) {
        if (iVar != null) {
            if (iVar.hnW != null || !v.I(iVar.hnV)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bM(List<FrsTabInfo> list) {
        if (this.eaZ.isLoadingViewAttached()) {
            this.eaZ.hideLoadingView(this.eaZ.findViewById(16908290));
        }
        if (aGK()) {
            return false;
        }
        this.dOA.dLG = true;
        aGH();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", true);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_game_login_tip", false);
        }
        bN(list);
        return true;
    }

    private void aGH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.eaZ.registerListener(1021074, this.ebo);
    }

    private void bN(List<FrsTabInfo> list) {
        List list2;
        boolean z;
        if (!v.I(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(FrsTabController.this.ebd, true)) {
                            com.baidu.adp.lib.g.e.jG().post(FrsTabController.this.ebp);
                        }
                        FrsTabController.this.aGE();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.eaZ.registerListener(customMessageListener);
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
            builder.tab_name = this.eaZ.getResources().getString(e.j.send);
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
            this.dOz = new ad(this.eaZ.getActivity(), list2);
            if (aBr() != null) {
                this.dOz.setForumId(aBr().getForumId());
                this.dOz.setForumName(aBr().getForumName());
                if (aBr().aCl() != null && aBr().aCl().bhx() != null) {
                    ForumData bhx = aBr().aCl().bhx();
                    this.dOz.setForumGameLabel(bhx.getForumGameLabel());
                    this.dOz.ox(bhx.getSpecialForumType());
                }
            }
            this.dOA.dLG = false;
            new d(this.dOA).a(this.dOz);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.dOz);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.eaZ.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGI() {
        if (this.dOz != null && !TextUtils.isEmpty(this.dOz.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.dOB.bhx().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar act;
        if ((fragment instanceof ak) && this.dOB != null && this.dOB.bhx() != null && (act = ((ak) fragment).act()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dOB.bhx().getName(), 5, true, true) + this.eaZ.getActivity().getString(e.j.forum));
            act.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dOA instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dOA.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ht(int i) {
        if (this.dOA instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dOA.ht(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dOA instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dOA.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.dOA != null) {
            this.dOA.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!aGK()) {
            this.dOA.setPrimary(true);
        } else if (this.ebb != null) {
            Fragment currentFragment = this.ebb.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.ebf) {
            this.ebf = false;
            if (this.dOA != null) {
                this.dOA.refresh();
            }
        }
    }

    public void onPause() {
        if (!aGK()) {
            this.dOA.setPrimary(false);
        } else if (this.ebb != null) {
            Fragment currentFragment = this.ebb.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.dOA != null) {
            this.dOA.onChangeSkinType(i);
        }
        if (this.ebb != null) {
            this.ebb.onChangeSkinType(i);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.eba != null && this.eba.eeA) {
                this.eba.eeA = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            }
            if (aGK() && this.ebb != null && this.ebb.aDB()) {
                this.ebb.aDC();
                UtilHelper.setNavigationBarBackground(this.eaZ, this.ebb.gN(true));
            } else if (this.dOA != null && this.dOA.isAdded()) {
                if (this.dOA.onKeyDown(i, keyEvent)) {
                    return true;
                }
                aGJ();
            } else {
                return this.eaZ.b(i, keyEvent);
            }
            return false;
        }
        return this.eaZ.b(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGJ() {
        if (this.dOD != this.dOC && aGK() && this.ebb != null && !this.ebb.aDx()) {
            this.ebb.setCurrentTab(this.dOC);
            if (mz(this.dOC) != 1) {
                this.dOA.gz(false);
            }
            this.dOD = this.dOC;
            a(this.ebb.getCurrentFragment(), this.dOC);
            return;
        }
        this.dOA.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!aGK()) {
            this.dOA.onActivityResult(i, i2, intent);
        } else if (this.ebb != null) {
            if (99 == this.ebb.getCurrentTabType() || 1 == this.ebb.getCurrentTabType()) {
                this.dOA.onActivityResult(i, i2, intent);
            } else {
                this.ebb.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.bvB().x(this.eaZ.getPageContext());
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.ebe != null) {
                        this.ebe.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void Jo() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.eaZ != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.eaZ.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.bvB().x(this.eaZ.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!aGK()) {
            return this.dOA.getVoiceManager();
        }
        if (this.ebb == null) {
            return null;
        }
        Fragment currentFragment = this.ebb.getCurrentFragment();
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
    public int mx(int i) {
        if (this.dOz == null) {
            return -1;
        }
        int H = v.H(this.dOz.aDK());
        for (int i2 = 0; i2 < H; i2++) {
            if (this.dOz.aDK().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mz(int i) {
        if (this.dOz != null && i < v.H(this.dOz.aDK())) {
            return this.dOz.aDK().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment aBr() {
        return this.dOA;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aBs() {
        if (!aGK()) {
            if (this.dOA instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.dOA).aBs();
            }
        } else if (this.ebb == null) {
            return null;
        } else {
            Fragment currentFragment = this.ebb.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).aBs();
            }
        }
        return null;
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eaZ.isLoadingViewAttached()) {
            this.eaZ.hideLoadingView(this.eaZ.findViewById(16908290));
        }
        if (this.ebp != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ebp);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.ebd, false);
        if (this.ebe != null) {
            this.ebe.cancelLoadData();
        }
        if (this.dOA != null && this.dOA.aBP() != null) {
            this.dOA.aBP().onActivityDestroy();
        }
    }

    public FragmentTabHost aDA() {
        if (this.ebb == null) {
            return null;
        }
        return this.ebb.aDA();
    }

    public void gO(boolean z) {
        if (this.ebb != null) {
            this.ebb.gO(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aGK() {
        if (this.ebh == null) {
            return false;
        }
        return this.ebh.getItem(0) instanceof FrsTabHostFragment;
    }

    private boolean aGL() {
        if (this.ebh == null) {
            return false;
        }
        return this.ebh.getItem(1) instanceof FrsLiteProgramListFragment;
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
        /* renamed from: nf */
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

        public BaseFragment oM(String str) {
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

        public BaseFragment ng(int i) {
            return (BaseFragment) v.e(this.mFragments, i);
        }

        public String nh(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }
}
