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
    public static final String eaV = FrsFragment.class.getSimpleName();
    public static final String eaW = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String eaX = FrsTabHostFragment.class.getSimpleName();
    private i dOA;
    private int dOC;
    private ad dOy;
    private FrsFragment dOz;
    private FrsActivity eaY;
    private FrsLiteProgramListFragment eaZ;
    private FrsTabHostFragment eba;
    private ShareSuccessReplyToServerModel ebd;
    private FrsBaseViewPager ebf;
    private FragmentAdapter ebg;
    private boolean ebh;
    private boolean ebi;
    private String mForumName;
    private boolean ebb = false;
    private final Handler mHandler = new Handler();
    private int dOB = 0;
    private boolean ebe = false;
    private com.baidu.adp.framework.listener.a ebj = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            i iVar = null;
            if (!FrsTabController.this.ebb && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    iVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    iVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (iVar != null) {
                    FrsTabController.this.ebb = true;
                    FrsTabController.this.d(iVar);
                }
            }
        }
    };
    private CustomMessageListener ebk = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.ebb && FrsTabController.this.dOA == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                i iVar = (i) customResponsedMessage.getData();
                if (iVar.bhx() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(iVar.bhx().getName())) {
                    FrsTabController.this.d(iVar);
                }
            }
        }
    };
    private CustomMessageListener ebl = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.aGJ();
        }
    };
    private CustomMessageListener ebm = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
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
                if (mx != -1 && FrsTabController.this.aGK() && FrsTabController.this.eba != null) {
                    FrsTabController.this.eba.setCurrentTab(mx);
                    if (FrsTabController.this.mz(mx) != 1) {
                        FrsTabController.this.dOz.gz(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener ebn = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.I(newNotifyData) && FrsTabController.this.eba != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.dOy.aDK().size(); i++) {
                                FragmentTabHost.b dy = FrsTabController.this.eba.dy(i);
                                if (dy != null && dy.mType != 99 && dy.mType != 1 && dy.mType != FrsTabController.this.eba.getCurrentTabType() && dy.mType == aVar.getTabId() && aVar.aGC() && dy.aAa.iD(String.valueOf(dy.mType)) != null) {
                                    dy.aAa.iD(String.valueOf(dy.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable ebo = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        @Override // java.lang.Runnable
        public void run() {
            e.jG().removeCallbacks(this);
            FrsTabController.this.aGI();
            e.jG().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private CustomMessageListener bRj = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.ebe = true;
            }
        }
    };
    private CustomMessageListener ebp = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!g.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.ebf != null && FrsTabController.this.ebg != null && FrsTabController.this.ebg.oM(FrsTabController.eaW) != null) {
                if (!j.kV()) {
                    FrsTabController.this.eaY.showToast(FrsTabController.this.eaY.getString(e.j.neterror));
                } else if ((FrsTabController.this.aBr().aCl().hnU == null || FrsTabController.this.aBr().aCl().hnU.size() != 1) && (FrsTabController.this.aBr().aCl().hnU != null || FrsTabController.this.aBr().aCl().hnV == null)) {
                    FrsTabController.this.ebf.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.aBr().aCl().hnV;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.u(smartApp.id, smartApp.link, "1191003700000000")) {
                        FrsTabController.this.ebf.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new am("c13274").aB(ImageViewerConfig.FORUM_ID, FrsTabController.this.aBr().getForumId()).aB("uid", TbadkCoreApplication.getCurrentAccount()).aB("obj_name", FrsTabController.this.aBr().aCl().hnV.name).aB(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.aBr().aCl().hnV.id).aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
                    }
                }
            }
        }
    };
    private CustomMessageListener ebq = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.ebf != null && FrsTabController.this.ebg != null && FrsTabController.this.ebg.oM(FrsTabController.eaW) != null) {
                FrsTabController.this.ebf.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener ebr = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.ebf != null && FrsTabController.this.ebg != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.ebh = aVar.aDH();
                FrsTabController.this.ebi = aVar.aDI();
            }
        }
    };
    private CustomMessageListener ebs = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.ebf != null && FrsTabController.this.ebg != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.ebf.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener ebt = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
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
                    FrsTabController.this.ebi = false;
                    FrsTabController.this.ebf.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a ebu = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void aBF() {
            if (FrsTabController.this.ebf != null) {
                if (FrsTabController.this.ebf.getCurrentItem() == 0) {
                    FrsTabController.this.ebf.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.ebf.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean aBG() {
            SmartApp smartApp;
            if (FrsTabController.this.ebf.getCurrentItem() == 0) {
                if (FrsTabController.this.ebh && FrsTabController.this.ebi) {
                    FrsTabController.this.ebf.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.ebi) {
                    FrsTabController.this.ebf.setmDisallowSlip(true);
                }
                FrsTabController.this.ebf.setmDisallowSlip(true);
            } else {
                FrsTabController.this.ebf.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.aBr().aCl().hnU == null || FrsTabController.this.aBr().aCl().hnU.size() != 1) && (FrsTabController.this.aBr().aCl().hnU != null || FrsTabController.this.aBr().aCl().hnV == null)) || (smartApp = FrsTabController.this.aBr().aCl().hnV) == null || !com.baidu.tieba.aiapps.a.u(smartApp.id, smartApp.link, "1191003700000000")) {
                return true;
            }
            TiebaStatic.log(new am("c13274").aB(ImageViewerConfig.FORUM_ID, FrsTabController.this.aBr().getForumId()).aB("uid", TbadkCoreApplication.getCurrentAccount()).aB("obj_name", FrsTabController.this.aBr().aCl().hnV.name).aB(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.aBr().aCl().hnV.id).aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
            return false;
        }
    };
    private String ebc = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    /* JADX INFO: Access modifiers changed from: private */
    public void aGD() {
        if (this.eaZ != null && aBr() != null) {
            this.eaZ.eez = true;
            this.eaZ.clear();
            if (!j.kV()) {
                this.eaZ.oY(aBr().getForumId());
            } else if ((aBr().aCl().hnU != null && aBr().aCl().hnU.size() == 1) || (aBr().aCl().hnU == null && aBr().aCl().hnV != null)) {
                SmartApp smartApp = aBr().aCl().hnV;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.u(smartApp.id, smartApp.link, "1191003700000000")) {
                    String str = null;
                    if (aBr().aCl() != null && aBr().aCl().hnV != null) {
                        str = aBr().aCl().hnV.h5_url;
                    }
                    this.eaZ.oZ(str);
                }
                TiebaStatic.log(new am("c13274").aB(ImageViewerConfig.FORUM_ID, aBr().getForumId()).aB("uid", TbadkCoreApplication.getCurrentAccount()).aB("obj_name", aBr().aCl().hnV.name).aB(VideoPlayActivityConfig.OBJ_ID, aBr().aCl().hnV.id).aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
            } else {
                this.eaZ.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.eaZ;
                String forumId = aBr().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.eaZ;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.eaZ;
                frsLiteProgramListFragment.t(forumId, 1, 10);
                TiebaStatic.log(new am("c13273").aB(ImageViewerConfig.FORUM_ID, aBr().getForumId()).aB("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.eaY = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.eaY != null) {
            this.eaY.setContentView(e.h.frs_base_layout);
            this.ebf = (FrsBaseViewPager) this.eaY.findViewById(e.g.frs_base_viewpager);
            this.ebg = new FragmentAdapter(this.eaY.getSupportFragmentManager());
            this.ebf.setAdapter(this.ebg);
            this.ebf.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.ebf.addOnPageChangeListener(this.ebt);
            this.ebf.setmDisallowSlip(true);
            this.ebf.setOnTouchEventListener(this.ebu);
            this.eaY.registerListener(this.ebr);
            this.eaY.registerListener(this.ebs);
            this.eaY.registerListener(this.ebp);
            this.eaY.registerListener(this.ebq);
            this.ebj.getHttpMessageListener().setPriority(-1);
            this.ebj.getSocketMessageListener().setPriority(-1);
            this.eaY.registerListener(this.ebk);
            this.ebm.setSelfListener(true);
            this.eaY.registerListener(this.ebm);
            this.ebl.setSelfListener(true);
            this.eaY.registerListener(this.ebl);
            this.eaY.registerListener(this.bRj);
            if (bundle == null) {
                this.mForumName = this.eaY.getIntent().getStringExtra("name");
                this.dOB = this.eaY.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.dOB = bundle.getInt("default_tab_id", 0);
            }
            r(bundle);
            this.ebg.notifyDataSetChanged();
            this.ebd = new ShareSuccessReplyToServerModel();
            this.eaY.registerListener(this.ebj);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.dOB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.ebg != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.ebg.oM(eaV);
                if (frsFragment == null) {
                    frsFragment = s(bundle);
                }
                if (!eaV.equals(this.ebg.nh(0))) {
                    if (eaX.equals(this.ebg.nh(0))) {
                        this.ebg.ng(0);
                    }
                    this.ebg.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(i iVar) {
        if (iVar != null && (iVar.hnV != null || !v.I(iVar.hnU))) {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.ebg == null) {
                return false;
            }
            if (eaW.equals(this.ebg.nh(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.ebg.oM(eaW);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = aGF();
                }
                this.ebg.a(1, frsLiteProgramListFragment);
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
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.ebg != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.ebg.oM(eaX);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = aGG();
                }
                if (!eaX.equals(this.ebg.nh(0))) {
                    if (eaV.equals(this.ebg.nh(0))) {
                        this.ebg.ng(0);
                    }
                    this.ebg.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment s(Bundle bundle) {
        if (this.dOz == null) {
            this.dOz = new FrsFragment();
            this.dOz.setArguments(bundle);
            this.dOz.setBaseTag(eaV);
        }
        this.dOz.dLF = false;
        return this.dOz;
    }

    private FrsLiteProgramListFragment aGF() {
        if (this.eaZ == null) {
            this.eaZ = new FrsLiteProgramListFragment();
            this.eaZ.setBaseTag(eaW);
        }
        return this.eaZ;
    }

    private FrsTabHostFragment aGG() {
        if (this.eba == null) {
            this.eba = new FrsTabHostFragment();
            this.eba.setBaseTag(eaX);
        }
        return this.eba;
    }

    private FragmentManager getFragmentManager() {
        if (this.eaY != null) {
            return this.eaY.getSupportFragmentManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final i iVar) {
        if (v.H(iVar.bDu()) > 0) {
            this.dOA = iVar;
            if (!this.eaY.isLoadingViewAttached() && !aGK()) {
                this.eaY.showLoadingView(this.eaY.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                @Override // java.lang.Runnable
                public void run() {
                    boolean c = FrsTabController.this.c(iVar);
                    FrsTabController.this.e(iVar);
                    boolean bM = FrsTabController.this.bM(FrsTabController.this.dOA.bDu());
                    if (c || bM) {
                        FrsTabController.this.ebg.notifyDataSetChanged();
                        if (bM && FrsTabController.this.eba != null) {
                            FrsTabController.this.eba.D(FrsTabController.this.dOz);
                            FrsTabController.this.eba.a(FrsTabController.this.dOA, FrsTabController.this.dOy);
                        }
                    }
                }
            });
        } else if (aGK()) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                @Override // java.lang.Runnable
                public void run() {
                    FrsTabController.this.c(iVar);
                    FrsTabController.this.dOz.dLF = true;
                    FrsTabController.this.r(FrsTabController.this.dOz != null ? FrsTabController.this.dOz.getArguments() : null);
                    FrsTabController.this.ebg.notifyDataSetChanged();
                    FrsTabController.this.e(iVar);
                    if (FrsTabController.this.dOz instanceof NavigationBar.a) {
                        FrsTabController.this.dOz.b((Pair<Integer, Integer>) null);
                    }
                }
            });
        } else if (iVar != null) {
            if (iVar.hnV != null || !v.I(iVar.hnU)) {
                if (!this.eaY.isLoadingViewAttached() && !aGL()) {
                    this.eaY.showLoadingView(this.eaY.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsTabController.this.c(iVar)) {
                            FrsTabController.this.e(iVar);
                            FrsTabController.this.ebg.notifyDataSetChanged();
                        }
                        if (FrsTabController.this.eaY.isLoadingViewAttached()) {
                            FrsTabController.this.eaY.hideLoadingView(FrsTabController.this.eaY.findViewById(16908290));
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(i iVar) {
        if (iVar != null) {
            if (iVar.hnV != null || !v.I(iVar.hnU)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bM(List<FrsTabInfo> list) {
        if (this.eaY.isLoadingViewAttached()) {
            this.eaY.hideLoadingView(this.eaY.findViewById(16908290));
        }
        if (aGK()) {
            return false;
        }
        this.dOz.dLF = true;
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
        this.eaY.registerListener(1021074, this.ebn);
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
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(FrsTabController.this.ebc, true)) {
                            com.baidu.adp.lib.g.e.jG().post(FrsTabController.this.ebo);
                        }
                        FrsTabController.this.aGE();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.eaY.registerListener(customMessageListener);
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
            builder.tab_name = this.eaY.getResources().getString(e.j.send);
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
            this.dOy = new ad(this.eaY.getActivity(), list2);
            if (aBr() != null) {
                this.dOy.setForumId(aBr().getForumId());
                this.dOy.setForumName(aBr().getForumName());
                if (aBr().aCl() != null && aBr().aCl().bhx() != null) {
                    ForumData bhx = aBr().aCl().bhx();
                    this.dOy.setForumGameLabel(bhx.getForumGameLabel());
                    this.dOy.ox(bhx.getSpecialForumType());
                }
            }
            this.dOz.dLF = false;
            new d(this.dOz).a(this.dOy);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.dOy);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.eaY.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGI() {
        if (this.dOy != null && !TextUtils.isEmpty(this.dOy.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.dOA.bhx().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar act;
        if ((fragment instanceof ak) && this.dOA != null && this.dOA.bhx() != null && (act = ((ak) fragment).act()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dOA.bhx().getName(), 5, true, true) + this.eaY.getActivity().getString(e.j.forum));
            act.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dOz instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dOz.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ht(int i) {
        if (this.dOz instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dOz.ht(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dOz instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dOz.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.dOz != null) {
            this.dOz.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!aGK()) {
            this.dOz.setPrimary(true);
        } else if (this.eba != null) {
            Fragment currentFragment = this.eba.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.ebe) {
            this.ebe = false;
            if (this.dOz != null) {
                this.dOz.refresh();
            }
        }
    }

    public void onPause() {
        if (!aGK()) {
            this.dOz.setPrimary(false);
        } else if (this.eba != null) {
            Fragment currentFragment = this.eba.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.dOz != null) {
            this.dOz.onChangeSkinType(i);
        }
        if (this.eba != null) {
            this.eba.onChangeSkinType(i);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.eaZ != null && this.eaZ.eez) {
                this.eaZ.eez = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            }
            if (aGK() && this.eba != null && this.eba.aDB()) {
                this.eba.aDC();
                UtilHelper.setNavigationBarBackground(this.eaY, this.eba.gN(true));
            } else if (this.dOz != null && this.dOz.isAdded()) {
                if (this.dOz.onKeyDown(i, keyEvent)) {
                    return true;
                }
                aGJ();
            } else {
                return this.eaY.b(i, keyEvent);
            }
            return false;
        }
        return this.eaY.b(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGJ() {
        if (this.dOC != this.dOB && aGK() && this.eba != null && !this.eba.aDx()) {
            this.eba.setCurrentTab(this.dOB);
            if (mz(this.dOB) != 1) {
                this.dOz.gz(false);
            }
            this.dOC = this.dOB;
            a(this.eba.getCurrentFragment(), this.dOB);
            return;
        }
        this.dOz.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!aGK()) {
            this.dOz.onActivityResult(i, i2, intent);
        } else if (this.eba != null) {
            if (99 == this.eba.getCurrentTabType() || 1 == this.eba.getCurrentTabType()) {
                this.dOz.onActivityResult(i, i2, intent);
            } else {
                this.eba.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.bvB().x(this.eaY.getPageContext());
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.ebd != null) {
                        this.ebd.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void Jo() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.eaY != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.eaY.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.bvB().x(this.eaY.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!aGK()) {
            return this.dOz.getVoiceManager();
        }
        if (this.eba == null) {
            return null;
        }
        Fragment currentFragment = this.eba.getCurrentFragment();
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
        if (this.dOy == null) {
            return -1;
        }
        int H = v.H(this.dOy.aDK());
        for (int i2 = 0; i2 < H; i2++) {
            if (this.dOy.aDK().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mz(int i) {
        if (this.dOy != null && i < v.H(this.dOy.aDK())) {
            return this.dOy.aDK().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment aBr() {
        return this.dOz;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aBs() {
        if (!aGK()) {
            if (this.dOz instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.dOz).aBs();
            }
        } else if (this.eba == null) {
            return null;
        } else {
            Fragment currentFragment = this.eba.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).aBs();
            }
        }
        return null;
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eaY.isLoadingViewAttached()) {
            this.eaY.hideLoadingView(this.eaY.findViewById(16908290));
        }
        if (this.ebo != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ebo);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.ebc, false);
        if (this.ebd != null) {
            this.ebd.cancelLoadData();
        }
        if (this.dOz != null && this.dOz.aBP() != null) {
            this.dOz.aBP().onActivityDestroy();
        }
    }

    public FragmentTabHost aDA() {
        if (this.eba == null) {
            return null;
        }
        return this.eba.aDA();
    }

    public void gO(boolean z) {
        if (this.eba != null) {
            this.eba.gO(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aGK() {
        if (this.ebg == null) {
            return false;
        }
        return this.ebg.getItem(0) instanceof FrsTabHostFragment;
    }

    private boolean aGL() {
        if (this.ebg == null) {
            return false;
        }
        return this.ebg.getItem(1) instanceof FrsLiteProgramListFragment;
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
