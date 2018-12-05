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
    private ad dLb;
    private FrsFragment dLc;
    private i dLd;
    private int dLf;
    private FrsActivity dXB;
    private FrsLiteProgramListFragment dXC;
    private FrsTabHostFragment dXD;
    private ShareSuccessReplyToServerModel dXG;
    private FrsBaseViewPager dXI;
    private FragmentAdapter dXJ;
    private boolean dXK;
    private boolean dXL;
    private String mForumName;
    public static final String dXy = FrsFragment.class.getSimpleName();
    public static final String dXz = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String dXA = FrsTabHostFragment.class.getSimpleName();
    private boolean dXE = false;
    private final Handler mHandler = new Handler();
    private int dLe = 0;
    private boolean dXH = false;
    private com.baidu.adp.framework.listener.a dXM = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            i iVar = null;
            if (!FrsTabController.this.dXE && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    iVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    iVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (iVar != null) {
                    FrsTabController.this.dXE = true;
                    FrsTabController.this.d(iVar);
                }
            }
        }
    };
    private CustomMessageListener dXN = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.dXE && FrsTabController.this.dLd == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                i iVar = (i) customResponsedMessage.getData();
                if (iVar.bgi() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(iVar.bgi().getName())) {
                    FrsTabController.this.d(iVar);
                }
            }
        }
    };
    private CustomMessageListener dXO = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.aFx();
        }
    };
    private CustomMessageListener dXP = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int mj;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    mj = FrsTabController.this.mj(9);
                    if (mj == -1) {
                        mj = FrsTabController.this.mj(2);
                    }
                } else {
                    mj = FrsTabController.this.mj(intValue);
                }
                if (mj != -1 && FrsTabController.this.aFy() && FrsTabController.this.dXD != null) {
                    FrsTabController.this.dXD.setCurrentTab(mj);
                    if (FrsTabController.this.ml(mj) != 1) {
                        FrsTabController.this.dLc.gt(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener dXQ = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.I(newNotifyData) && FrsTabController.this.dXD != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.dLb.aCy().size(); i++) {
                                FragmentTabHost.b dy = FrsTabController.this.dXD.dy(i);
                                if (dy != null && dy.mType != 99 && dy.mType != 1 && dy.mType != FrsTabController.this.dXD.getCurrentTabType() && dy.mType == aVar.getTabId() && aVar.aFq() && dy.azy.io(String.valueOf(dy.mType)) != null) {
                                    dy.azy.io(String.valueOf(dy.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable dXR = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        @Override // java.lang.Runnable
        public void run() {
            e.jG().removeCallbacks(this);
            FrsTabController.this.aFw();
            e.jG().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private CustomMessageListener bQv = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.dXH = true;
            }
        }
    };
    private CustomMessageListener dXS = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!g.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.dXI != null && FrsTabController.this.dXJ != null && FrsTabController.this.dXJ.ot(FrsTabController.dXz) != null) {
                if (!j.kV()) {
                    FrsTabController.this.dXB.showToast(FrsTabController.this.dXB.getString(e.j.neterror));
                } else if ((FrsTabController.this.aAf().aAZ().hjE == null || FrsTabController.this.aAf().aAZ().hjE.size() != 1) && (FrsTabController.this.aAf().aAZ().hjE != null || FrsTabController.this.aAf().aAZ().hjF == null)) {
                    FrsTabController.this.dXI.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.aAf().aAZ().hjF;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.u(smartApp.id, smartApp.link, "9101")) {
                        FrsTabController.this.dXI.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new am("c13274").aA(ImageViewerConfig.FORUM_ID, FrsTabController.this.aAf().getForumId()).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA("obj_name", FrsTabController.this.aAf().aAZ().hjF.name).aA(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.aAf().aAZ().hjF.id).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
                    }
                }
            }
        }
    };
    private CustomMessageListener dXT = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.dXI != null && FrsTabController.this.dXJ != null && FrsTabController.this.dXJ.ot(FrsTabController.dXz) != null) {
                FrsTabController.this.dXI.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener dXU = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.dXI != null && FrsTabController.this.dXJ != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.dXK = aVar.aCv();
                FrsTabController.this.dXL = aVar.aCw();
            }
        }
    };
    private CustomMessageListener dXV = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.dXI != null && FrsTabController.this.dXJ != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.dXI.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener dXW = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.aFr();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.dXL = false;
                    FrsTabController.this.dXI.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a dXX = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void aAt() {
            if (FrsTabController.this.dXI != null) {
                if (FrsTabController.this.dXI.getCurrentItem() == 0) {
                    FrsTabController.this.dXI.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.dXI.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean aAu() {
            SmartApp smartApp;
            if (FrsTabController.this.dXI.getCurrentItem() == 0) {
                if (FrsTabController.this.dXK && FrsTabController.this.dXL) {
                    FrsTabController.this.dXI.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.dXL) {
                    FrsTabController.this.dXI.setmDisallowSlip(true);
                }
                FrsTabController.this.dXI.setmDisallowSlip(true);
            } else {
                FrsTabController.this.dXI.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.aAf().aAZ().hjE == null || FrsTabController.this.aAf().aAZ().hjE.size() != 1) && (FrsTabController.this.aAf().aAZ().hjE != null || FrsTabController.this.aAf().aAZ().hjF == null)) || (smartApp = FrsTabController.this.aAf().aAZ().hjF) == null || !com.baidu.tieba.aiapps.a.u(smartApp.id, smartApp.link, "9101")) {
                return true;
            }
            TiebaStatic.log(new am("c13274").aA(ImageViewerConfig.FORUM_ID, FrsTabController.this.aAf().getForumId()).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA("obj_name", FrsTabController.this.aAf().aAZ().hjF.name).aA(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.aAf().aAZ().hjF.id).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
            return false;
        }
    };
    private String dXF = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    /* JADX INFO: Access modifiers changed from: private */
    public void aFr() {
        if (this.dXC != null && aAf() != null) {
            this.dXC.ebc = true;
            this.dXC.clear();
            if (!j.kV()) {
                this.dXC.oF(aAf().getForumId());
            } else if ((aAf().aAZ().hjE != null && aAf().aAZ().hjE.size() == 1) || (aAf().aAZ().hjE == null && aAf().aAZ().hjF != null)) {
                SmartApp smartApp = aAf().aAZ().hjF;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.u(smartApp.id, smartApp.link, "9101")) {
                    String str = null;
                    if (aAf().aAZ() != null && aAf().aAZ().hjF != null) {
                        str = aAf().aAZ().hjF.h5_url;
                    }
                    this.dXC.oG(str);
                }
                TiebaStatic.log(new am("c13274").aA(ImageViewerConfig.FORUM_ID, aAf().getForumId()).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA("obj_name", aAf().aAZ().hjF.name).aA(VideoPlayActivityConfig.OBJ_ID, aAf().aAZ().hjF.id).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
            } else {
                this.dXC.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.dXC;
                String forumId = aAf().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.dXC;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.dXC;
                frsLiteProgramListFragment.t(forumId, 1, 10);
                TiebaStatic.log(new am("c13273").aA(ImageViewerConfig.FORUM_ID, aAf().getForumId()).aA("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.dXB = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.dXB != null) {
            this.dXB.setContentView(e.h.frs_base_layout);
            this.dXI = (FrsBaseViewPager) this.dXB.findViewById(e.g.frs_base_viewpager);
            this.dXJ = new FragmentAdapter(this.dXB.getSupportFragmentManager());
            this.dXI.setAdapter(this.dXJ);
            this.dXI.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.dXI.addOnPageChangeListener(this.dXW);
            this.dXI.setmDisallowSlip(true);
            this.dXI.setOnTouchEventListener(this.dXX);
            this.dXB.registerListener(this.dXU);
            this.dXB.registerListener(this.dXV);
            this.dXB.registerListener(this.dXS);
            this.dXB.registerListener(this.dXT);
            this.dXM.getHttpMessageListener().setPriority(-1);
            this.dXM.getSocketMessageListener().setPriority(-1);
            this.dXB.registerListener(this.dXN);
            this.dXP.setSelfListener(true);
            this.dXB.registerListener(this.dXP);
            this.dXO.setSelfListener(true);
            this.dXB.registerListener(this.dXO);
            this.dXB.registerListener(this.bQv);
            if (bundle == null) {
                this.mForumName = this.dXB.getIntent().getStringExtra("name");
                this.dLe = this.dXB.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.dLe = bundle.getInt("default_tab_id", 0);
            }
            r(bundle);
            this.dXJ.notifyDataSetChanged();
            this.dXG = new ShareSuccessReplyToServerModel();
            this.dXB.registerListener(this.dXM);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.dLe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.dXJ != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.dXJ.ot(dXy);
                if (frsFragment == null) {
                    frsFragment = s(bundle);
                }
                if (!dXy.equals(this.dXJ.mT(0))) {
                    if (dXA.equals(this.dXJ.mT(0))) {
                        this.dXJ.mS(0);
                    }
                    this.dXJ.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(i iVar) {
        if (iVar != null && (iVar.hjF != null || !v.I(iVar.hjE))) {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager == null || fragmentManager.isDestroyed() || this.dXJ == null) {
                return false;
            }
            if (dXz.equals(this.dXJ.mT(1))) {
                return false;
            }
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.dXJ.ot(dXz);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = aFt();
                }
                this.dXJ.a(1, frsLiteProgramListFragment);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFs() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.dXJ != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.dXJ.ot(dXA);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = aFu();
                }
                if (!dXA.equals(this.dXJ.mT(0))) {
                    if (dXy.equals(this.dXJ.mT(0))) {
                        this.dXJ.mS(0);
                    }
                    this.dXJ.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment s(Bundle bundle) {
        if (this.dLc == null) {
            this.dLc = new FrsFragment();
            this.dLc.setArguments(bundle);
            this.dLc.setBaseTag(dXy);
        }
        this.dLc.dIi = false;
        return this.dLc;
    }

    private FrsLiteProgramListFragment aFt() {
        if (this.dXC == null) {
            this.dXC = new FrsLiteProgramListFragment();
            this.dXC.setBaseTag(dXz);
        }
        return this.dXC;
    }

    private FrsTabHostFragment aFu() {
        if (this.dXD == null) {
            this.dXD = new FrsTabHostFragment();
            this.dXD.setBaseTag(dXA);
        }
        return this.dXD;
    }

    private FragmentManager getFragmentManager() {
        if (this.dXB != null) {
            return this.dXB.getSupportFragmentManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final i iVar) {
        if (v.H(iVar.bBU()) > 0) {
            this.dLd = iVar;
            if (!this.dXB.isLoadingViewAttached() && !aFy()) {
                this.dXB.showLoadingView(this.dXB.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                @Override // java.lang.Runnable
                public void run() {
                    boolean c = FrsTabController.this.c(iVar);
                    FrsTabController.this.e(iVar);
                    boolean bK = FrsTabController.this.bK(FrsTabController.this.dLd.bBU());
                    if (c || bK) {
                        FrsTabController.this.dXJ.notifyDataSetChanged();
                        if (bK && FrsTabController.this.dXD != null) {
                            FrsTabController.this.dXD.D(FrsTabController.this.dLc);
                            FrsTabController.this.dXD.a(FrsTabController.this.dLd, FrsTabController.this.dLb);
                        }
                    }
                }
            });
        } else if (aFy()) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                @Override // java.lang.Runnable
                public void run() {
                    FrsTabController.this.c(iVar);
                    FrsTabController.this.dLc.dIi = true;
                    FrsTabController.this.r(FrsTabController.this.dLc != null ? FrsTabController.this.dLc.getArguments() : null);
                    FrsTabController.this.dXJ.notifyDataSetChanged();
                    FrsTabController.this.e(iVar);
                    if (FrsTabController.this.dLc instanceof NavigationBar.a) {
                        FrsTabController.this.dLc.b((Pair<Integer, Integer>) null);
                    }
                }
            });
        } else if (iVar != null) {
            if (iVar.hjF != null || !v.I(iVar.hjE)) {
                if (!this.dXB.isLoadingViewAttached() && !aFz()) {
                    this.dXB.showLoadingView(this.dXB.findViewById(16908290));
                }
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FrsTabController.this.c(iVar)) {
                            FrsTabController.this.e(iVar);
                            FrsTabController.this.dXJ.notifyDataSetChanged();
                        }
                        if (FrsTabController.this.dXB.isLoadingViewAttached()) {
                            FrsTabController.this.dXB.hideLoadingView(FrsTabController.this.dXB.findViewById(16908290));
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(i iVar) {
        if (iVar != null) {
            if (iVar.hjF != null || !v.I(iVar.hjE)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bK(List<FrsTabInfo> list) {
        if (this.dXB.isLoadingViewAttached()) {
            this.dXB.hideLoadingView(this.dXB.findViewById(16908290));
        }
        if (aFy()) {
            return false;
        }
        this.dLc.dIi = true;
        aFv();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_game_login_tip", true)) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", true);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_game_login_tip", false);
        }
        bL(list);
        return true;
    }

    private void aFv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dXB.registerListener(1021074, this.dXQ);
    }

    private void bL(List<FrsTabInfo> list) {
        List list2;
        boolean z;
        if (!v.I(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(FrsTabController.this.dXF, true)) {
                            com.baidu.adp.lib.g.e.jG().post(FrsTabController.this.dXR);
                        }
                        FrsTabController.this.aFs();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.dXB.registerListener(customMessageListener);
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
            builder.tab_name = this.dXB.getResources().getString(e.j.send);
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
            this.dLb = new ad(this.dXB.getActivity(), list2);
            if (aAf() != null) {
                this.dLb.setForumId(aAf().getForumId());
                this.dLb.setForumName(aAf().getForumName());
                if (aAf().aAZ() != null && aAf().aAZ().bgi() != null) {
                    ForumData bgi = aAf().aAZ().bgi();
                    this.dLb.setForumGameLabel(bgi.getForumGameLabel());
                    this.dLb.oc(bgi.getSpecialForumType());
                }
            }
            this.dLc.dIi = false;
            new d(this.dLc).a(this.dLb);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.dLb);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.dXB.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFw() {
        if (this.dLb != null && !TextUtils.isEmpty(this.dLb.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.dLd.bgi().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar abU;
        if ((fragment instanceof ak) && this.dLd != null && this.dLd.bgi() != null && (abU = ((ak) fragment).abU()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dLd.bgi().getName(), 5, true, true) + this.dXB.getActivity().getString(e.j.forum));
            abU.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dLc instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dLc.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a hs(int i) {
        if (this.dLc instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dLc.hs(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dLc instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dLc.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.dLc != null) {
            this.dLc.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!aFy()) {
            this.dLc.setPrimary(true);
        } else if (this.dXD != null) {
            Fragment currentFragment = this.dXD.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.dXH) {
            this.dXH = false;
            if (this.dLc != null) {
                this.dLc.refresh();
            }
        }
    }

    public void onPause() {
        if (!aFy()) {
            this.dLc.setPrimary(false);
        } else if (this.dXD != null) {
            Fragment currentFragment = this.dXD.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.dLc != null) {
            this.dLc.onChangeSkinType(i);
        }
        if (this.dXD != null) {
            this.dXD.onChangeSkinType(i);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.dXC != null && this.dXC.ebc) {
                this.dXC.ebc = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            }
            if (aFy() && this.dXD != null && this.dXD.aCp()) {
                this.dXD.aCq();
                UtilHelper.setNavigationBarBackground(this.dXB, this.dXD.gH(true));
            } else if (this.dLc != null && this.dLc.isAdded()) {
                if (this.dLc.onKeyDown(i, keyEvent)) {
                    return true;
                }
                aFx();
            } else {
                return this.dXB.b(i, keyEvent);
            }
            return false;
        }
        return this.dXB.b(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFx() {
        if (this.dLf != this.dLe && aFy() && this.dXD != null && !this.dXD.aCl()) {
            this.dXD.setCurrentTab(this.dLe);
            if (ml(this.dLe) != 1) {
                this.dLc.gt(false);
            }
            this.dLf = this.dLe;
            a(this.dXD.getCurrentFragment(), this.dLe);
            return;
        }
        this.dLc.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!aFy()) {
            this.dLc.onActivityResult(i, i2, intent);
        } else if (this.dXD != null) {
            if (99 == this.dXD.getCurrentTabType() || 1 == this.dXD.getCurrentTabType()) {
                this.dLc.onActivityResult(i, i2, intent);
            } else {
                this.dXD.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.buh().x(this.dXB.getPageContext());
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.dXG != null) {
                        this.dXG.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void IY() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.dXB != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.dXB.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.buh().x(this.dXB.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!aFy()) {
            return this.dLc.getVoiceManager();
        }
        if (this.dXD == null) {
            return null;
        }
        Fragment currentFragment = this.dXD.getCurrentFragment();
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
    public int mj(int i) {
        if (this.dLb == null) {
            return -1;
        }
        int H = v.H(this.dLb.aCy());
        for (int i2 = 0; i2 < H; i2++) {
            if (this.dLb.aCy().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ml(int i) {
        if (this.dLb != null && i < v.H(this.dLb.aCy())) {
            return this.dLb.aCy().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment aAf() {
        return this.dLc;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aAg() {
        if (!aFy()) {
            if (this.dLc instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.dLc).aAg();
            }
        } else if (this.dXD == null) {
            return null;
        } else {
            Fragment currentFragment = this.dXD.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).aAg();
            }
        }
        return null;
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.dXB.isLoadingViewAttached()) {
            this.dXB.hideLoadingView(this.dXB.findViewById(16908290));
        }
        if (this.dXR != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.dXR);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.dXF, false);
        if (this.dXG != null) {
            this.dXG.cancelLoadData();
        }
        if (this.dLc != null && this.dLc.aAD() != null) {
            this.dLc.aAD().onActivityDestroy();
        }
    }

    public FragmentTabHost aCo() {
        if (this.dXD == null) {
            return null;
        }
        return this.dXD.aCo();
    }

    public void gI(boolean z) {
        if (this.dXD != null) {
            this.dXD.gI(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aFy() {
        if (this.dXJ == null) {
            return false;
        }
        return this.dXJ.getItem(0) instanceof FrsTabHostFragment;
    }

    private boolean aFz() {
        if (this.dXJ == null) {
            return false;
        }
        return this.dXJ.getItem(1) instanceof FrsLiteProgramListFragment;
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
        /* renamed from: mR */
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

        public BaseFragment ot(String str) {
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

        public BaseFragment mS(int i) {
            return (BaseFragment) v.e(this.mFragments, i);
        }

        public String mT(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }
}
