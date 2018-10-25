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
    public static final String dPT = FrsFragment.class.getSimpleName();
    public static final String dPU = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String dPV = FrsTabHostFragment.class.getSimpleName();
    private ad dDm;
    private FrsFragment dDn;
    private i dDo;
    private int dDq;
    private FrsActivity dPW;
    private FrsLiteProgramListFragment dPX;
    private FrsTabHostFragment dPY;
    private ShareSuccessReplyToServerModel dQb;
    private FrsBaseViewPager dQd;
    private FragmentAdapter dQe;
    private boolean dQf;
    private boolean dQg;
    private String mForumName;
    private boolean dPZ = false;
    private final Handler mHandler = new Handler();
    private int dDp = 0;
    private boolean dQc = false;
    private com.baidu.adp.framework.listener.a dQh = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            i iVar = null;
            if (!FrsTabController.this.dPZ && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    iVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    iVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (iVar != null) {
                    FrsTabController.this.dPZ = true;
                    FrsTabController.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dQi = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.dPZ && FrsTabController.this.dDo == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                i iVar = (i) customResponsedMessage.getData();
                if (iVar.beT() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(iVar.beT().getName())) {
                    FrsTabController.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dQj = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.aEr();
        }
    };
    private CustomMessageListener dQk = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int lB;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    lB = FrsTabController.this.lB(9);
                    if (lB == -1) {
                        lB = FrsTabController.this.lB(2);
                    }
                } else {
                    lB = FrsTabController.this.lB(intValue);
                }
                if (lB != -1 && FrsTabController.this.aEs() && FrsTabController.this.dPY != null) {
                    FrsTabController.this.dPY.setCurrentTab(lB);
                    if (FrsTabController.this.lD(lB) != 1) {
                        FrsTabController.this.dDn.gi(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener dQl = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.J(newNotifyData) && FrsTabController.this.dPY != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.dDm.aBr().size(); i++) {
                                FragmentTabHost.b cW = FrsTabController.this.dPY.cW(i);
                                if (cW != null && cW.mType != 99 && cW.mType != 1 && cW.mType != FrsTabController.this.dPY.getCurrentTabType() && cW.mType == aVar.getTabId() && aVar.aEk() && cW.avl.hV(String.valueOf(cW.mType)) != null) {
                                    cW.avl.hV(String.valueOf(cW.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable dQm = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        @Override // java.lang.Runnable
        public void run() {
            e.jI().removeCallbacks(this);
            FrsTabController.this.aEq();
            e.jI().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private CustomMessageListener bLU = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.dQc = true;
            }
        }
    };
    private CustomMessageListener dQn = new CustomMessageListener(2921371) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!g.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.dQd != null && FrsTabController.this.dQe != null && FrsTabController.this.dQe.nR(FrsTabController.dPU) != null) {
                if (!j.kX()) {
                    FrsTabController.this.dPW.showToast(FrsTabController.this.dPW.getString(e.j.neterror));
                } else if ((FrsTabController.this.ayY().azS().hbo == null || FrsTabController.this.ayY().azS().hbo.size() != 1) && (FrsTabController.this.ayY().azS().hbo != null || FrsTabController.this.ayY().azS().hbp == null)) {
                    FrsTabController.this.dQd.setCurrentItem(1);
                } else {
                    SmartApp smartApp = FrsTabController.this.ayY().azS().hbp;
                    if (smartApp == null || !com.baidu.tieba.aiapps.a.u(smartApp.id, smartApp.link, "9101")) {
                        FrsTabController.this.dQd.setCurrentItem(1);
                    } else {
                        TiebaStatic.log(new am("c13274").ax(ImageViewerConfig.FORUM_ID, FrsTabController.this.ayY().getForumId()).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax("obj_name", FrsTabController.this.ayY().azS().hbp.name).ax(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.ayY().azS().hbp.id).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
                    }
                }
            }
        }
    };
    private CustomMessageListener dQo = new CustomMessageListener(2921374) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.dQd != null && FrsTabController.this.dQe != null && FrsTabController.this.dQe.nR(FrsTabController.dPU) != null) {
                FrsTabController.this.dQd.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener dQp = new CustomMessageListener(2921369) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.dQd != null && FrsTabController.this.dQe != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.dQf = aVar.aBo();
                FrsTabController.this.dQg = aVar.aBp();
            }
        }
    };
    private CustomMessageListener dQq = new CustomMessageListener(2921370) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.dQd != null && FrsTabController.this.dQe != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.dQd.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener dQr = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.aEl();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.dQg = false;
                    FrsTabController.this.dQd.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a dQs = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void azm() {
            if (FrsTabController.this.dQd != null) {
                if (FrsTabController.this.dQd.getCurrentItem() == 0) {
                    FrsTabController.this.dQd.setmDisallowSlip(true);
                } else {
                    FrsTabController.this.dQd.setmDisallowSlip(false);
                }
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public boolean azn() {
            SmartApp smartApp;
            if (FrsTabController.this.dQd.getCurrentItem() == 0) {
                if (FrsTabController.this.dQf && FrsTabController.this.dQg) {
                    FrsTabController.this.dQd.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.dQg) {
                    FrsTabController.this.dQd.setmDisallowSlip(true);
                }
                FrsTabController.this.dQd.setmDisallowSlip(true);
            } else {
                FrsTabController.this.dQd.setmDisallowSlip(true);
            }
            if (((FrsTabController.this.ayY().azS().hbo == null || FrsTabController.this.ayY().azS().hbo.size() != 1) && (FrsTabController.this.ayY().azS().hbo != null || FrsTabController.this.ayY().azS().hbp == null)) || (smartApp = FrsTabController.this.ayY().azS().hbp) == null || !com.baidu.tieba.aiapps.a.u(smartApp.id, smartApp.link, "9101")) {
                return true;
            }
            TiebaStatic.log(new am("c13274").ax(ImageViewerConfig.FORUM_ID, FrsTabController.this.ayY().getForumId()).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax("obj_name", FrsTabController.this.ayY().azS().hbp.name).ax(VideoPlayActivityConfig.OBJ_ID, FrsTabController.this.ayY().azS().hbp.id).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
            return false;
        }
    };
    private String dQa = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    /* JADX INFO: Access modifiers changed from: private */
    public void aEl() {
        if (this.dPX != null && ayY() != null) {
            this.dPX.dTt = true;
            this.dPX.clear();
            if (!j.kX()) {
                this.dPX.od(ayY().getForumId());
            } else if ((ayY().azS().hbo != null && ayY().azS().hbo.size() == 1) || (ayY().azS().hbo == null && ayY().azS().hbp != null)) {
                SmartApp smartApp = ayY().azS().hbp;
                if (smartApp != null && !com.baidu.tieba.aiapps.a.u(smartApp.id, smartApp.link, "9101")) {
                    String str = null;
                    if (ayY().azS() != null && ayY().azS().hbp != null) {
                        str = ayY().azS().hbp.h5_url;
                    }
                    this.dPX.oe(str);
                }
                TiebaStatic.log(new am("c13274").ax(ImageViewerConfig.FORUM_ID, ayY().getForumId()).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax("obj_name", ayY().azS().hbp.name).ax(VideoPlayActivityConfig.OBJ_ID, ayY().azS().hbp.id).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "frs_Bside"));
            } else {
                this.dPX.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.dPX;
                String forumId = ayY().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.dPX;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.dPX;
                frsLiteProgramListFragment.r(forumId, 1, 10);
                TiebaStatic.log(new am("c13273").ax(ImageViewerConfig.FORUM_ID, ayY().getForumId()).ax("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.dPW = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.dPW != null) {
            this.dPW.setContentView(e.h.frs_base_layout);
            this.dQd = (FrsBaseViewPager) this.dPW.findViewById(e.g.frs_base_viewpager);
            this.dQe = new FragmentAdapter(this.dPW.getSupportFragmentManager());
            this.dQd.setAdapter(this.dQe);
            this.dQd.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.dQd.addOnPageChangeListener(this.dQr);
            this.dQd.setmDisallowSlip(true);
            this.dQd.setOnTouchEventListener(this.dQs);
            this.dPW.registerListener(this.dQp);
            this.dPW.registerListener(this.dQq);
            this.dPW.registerListener(this.dQn);
            this.dPW.registerListener(this.dQo);
            this.dQh.getHttpMessageListener().setPriority(-1);
            this.dQh.getSocketMessageListener().setPriority(-1);
            this.dPW.registerListener(this.dQi);
            this.dQk.setSelfListener(true);
            this.dPW.registerListener(this.dQk);
            this.dQj.setSelfListener(true);
            this.dPW.registerListener(this.dQj);
            this.dPW.registerListener(this.bLU);
            if (bundle == null) {
                this.mForumName = this.dPW.getIntent().getStringExtra("name");
                this.dDp = this.dPW.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.dDp = bundle.getInt("default_tab_id", 0);
            }
            l(bundle);
            this.dQe.notifyDataSetChanged();
            this.dQb = new ShareSuccessReplyToServerModel();
            this.dPW.registerListener(this.dQh);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.dDp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.dQe != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.dQe.nR(dPT);
                if (frsFragment == null) {
                    frsFragment = m(bundle);
                }
                if (!dPT.equals(this.dQe.mm(0))) {
                    if (dPV.equals(this.dQe.mm(0))) {
                        this.dQe.ml(0);
                    }
                    this.dQe.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar, boolean z) {
        FragmentManager fragmentManager;
        if (iVar != null) {
            if ((iVar.hbp != null || !v.J(iVar.hbo)) && (fragmentManager = getFragmentManager()) != null && !fragmentManager.isDestroyed() && this.dQe != null) {
                try {
                    FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.dQe.nR(dPU);
                    if (frsLiteProgramListFragment == null) {
                        frsLiteProgramListFragment = aEn();
                    }
                    if (!dPU.equals(this.dQe.mm(1))) {
                        this.dQe.a(1, frsLiteProgramListFragment);
                        if (z) {
                            this.dQe.notifyDataSetChanged();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEm() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.dQe != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.dQe.nR(dPV);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = aEo();
                }
                if (!dPV.equals(this.dQe.mm(0))) {
                    if (dPT.equals(this.dQe.mm(0))) {
                        this.dQe.ml(0);
                    }
                    this.dQe.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment m(Bundle bundle) {
        if (this.dDn == null) {
            this.dDn = new FrsFragment();
            this.dDn.setArguments(bundle);
            this.dDn.setBaseTag(dPT);
        }
        this.dDn.dAs = false;
        return this.dDn;
    }

    private FrsLiteProgramListFragment aEn() {
        if (this.dPX == null) {
            this.dPX = new FrsLiteProgramListFragment();
            this.dPX.setBaseTag(dPU);
        }
        return this.dPX;
    }

    private FrsTabHostFragment aEo() {
        if (this.dPY == null) {
            this.dPY = new FrsTabHostFragment();
            this.dPY.setBaseTag(dPV);
        }
        return this.dPY;
    }

    private FragmentManager getFragmentManager() {
        if (this.dPW != null) {
            return this.dPW.getSupportFragmentManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final i iVar) {
        if (v.I(iVar.bAE()) > 0) {
            this.dDo = iVar;
            if (!this.dPW.isLoadingViewAttached() && !aEs()) {
                this.dPW.showLoadingView(this.dPW.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                @Override // java.lang.Runnable
                public void run() {
                    FrsTabController.this.a(iVar, true);
                    FrsTabController.this.d(iVar);
                    FrsTabController.this.bK(FrsTabController.this.dDo.bAE());
                }
            });
        } else if (aEs()) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                @Override // java.lang.Runnable
                public void run() {
                    FrsTabController.this.a(iVar, false);
                    FrsTabController.this.dDn.dAs = true;
                    FrsTabController.this.l(FrsTabController.this.dDn != null ? FrsTabController.this.dDn.getArguments() : null);
                    FrsTabController.this.dQe.notifyDataSetChanged();
                    FrsTabController.this.d(iVar);
                    if (FrsTabController.this.dDn instanceof NavigationBar.a) {
                        FrsTabController.this.dDn.b((Pair<Integer, Integer>) null);
                    }
                }
            });
        } else if (iVar != null) {
            if (iVar.hbp != null || !v.J(iVar.hbo)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                    @Override // java.lang.Runnable
                    public void run() {
                        FrsTabController.this.a(iVar, true);
                        FrsTabController.this.d(iVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(i iVar) {
        if (iVar != null) {
            if (iVar.hbp != null || !v.J(iVar.hbo)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(List<FrsTabInfo> list) {
        if (this.dPW.isLoadingViewAttached()) {
            this.dPW.hideLoadingView(this.dPW.findViewById(16908290));
        }
        if (!aEs()) {
            this.dDn.dAs = true;
            aEp();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_game_login_tip", true)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_game_login_tip", false);
            }
            bL(list);
        }
    }

    private void aEp() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dPW.registerListener(1021074, this.dQl);
    }

    private void bL(List<FrsTabInfo> list) {
        List list2;
        boolean z;
        if (!v.J(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(FrsTabController.this.dQa, true)) {
                            com.baidu.adp.lib.g.e.jI().post(FrsTabController.this.dQm);
                        }
                        FrsTabController.this.aEm();
                        FrsTabController.this.dQe.notifyDataSetChanged();
                        if (FrsTabController.this.dPY != null) {
                            FrsTabController.this.dPY.C(FrsTabController.this.dDn);
                            FrsTabController.this.dPY.a(FrsTabController.this.dDo, FrsTabController.this.dDm);
                        }
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.dPW.registerListener(customMessageListener);
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
            builder.tab_name = this.dPW.getResources().getString(e.j.send);
            builder.tab_type = 0;
            int I = v.I(arrayList);
            if (I > 4) {
                list2 = arrayList.subList(0, 4);
                list2.add(2, builder.build(false));
            } else if (I < 2) {
                arrayList.add(builder.build(false));
                list2 = arrayList;
            } else {
                arrayList.add(I / 2, builder.build(false));
                list2 = arrayList;
            }
            this.dDm = new ad(this.dPW.getActivity(), list2);
            if (ayY() != null) {
                this.dDm.setForumId(ayY().getForumId());
                this.dDm.setForumName(ayY().getForumName());
                if (ayY().azS() != null && ayY().azS().beT() != null) {
                    ForumData beT = ayY().azS().beT();
                    this.dDm.setForumGameLabel(beT.getForumGameLabel());
                    this.dDm.nC(beT.getSpecialForumType());
                }
            }
            this.dDn.dAs = false;
            new d(this.dDn).a(this.dDm);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.dDm);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.dPW.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEq() {
        if (this.dDm != null && !TextUtils.isEmpty(this.dDm.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.dDo.beT().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar aaE;
        if ((fragment instanceof ak) && this.dDo != null && this.dDo.beT() != null && (aaE = ((ak) fragment).aaE()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dDo.beT().getName(), 5, true, true) + this.dPW.getActivity().getString(e.j.forum));
            aaE.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dDn instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dDn.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gQ(int i) {
        if (this.dDn instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dDn.gQ(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dDn instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dDn.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.dDn != null) {
            this.dDn.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!aEs()) {
            this.dDn.setPrimary(true);
        } else if (this.dPY != null) {
            Fragment currentFragment = this.dPY.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.dQc) {
            this.dQc = false;
            if (this.dDn != null) {
                this.dDn.refresh();
            }
        }
    }

    public void onPause() {
        if (!aEs()) {
            this.dDn.setPrimary(false);
        } else if (this.dPY != null) {
            Fragment currentFragment = this.dPY.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.dDn != null) {
            this.dDn.onChangeSkinType(i);
        }
        if (this.dPY != null) {
            this.dPY.onChangeSkinType(i);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.dPX != null && this.dPX.dTt) {
                this.dPX.dTt = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921374));
                return true;
            }
            if (aEs() && this.dPY != null && this.dPY.aBi()) {
                this.dPY.aBj();
                UtilHelper.setNavigationBarBackground(this.dPW, this.dPY.gw(true));
            } else if (this.dDn != null && this.dDn.isAdded()) {
                if (this.dDn.onKeyDown(i, keyEvent)) {
                    return true;
                }
                aEr();
            } else {
                return this.dPW.b(i, keyEvent);
            }
            return false;
        }
        return this.dPW.b(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEr() {
        if (this.dDq != this.dDp && aEs() && this.dPY != null && !this.dPY.aBe()) {
            this.dPY.setCurrentTab(this.dDp);
            if (lD(this.dDp) != 1) {
                this.dDn.gi(false);
            }
            this.dDq = this.dDp;
            a(this.dPY.getCurrentFragment(), this.dDp);
            return;
        }
        this.dDn.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!aEs()) {
            this.dDn.onActivityResult(i, i2, intent);
        } else if (this.dPY != null) {
            if (99 == this.dPY.getCurrentTabType() || 1 == this.dPY.getCurrentTabType()) {
                this.dDn.onActivityResult(i, i2, intent);
            } else {
                this.dPY.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.bsS().x(this.dPW.getPageContext());
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.dQb != null) {
                        this.dQb.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void HI() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.dPW != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.dPW.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.bsS().x(this.dPW.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!aEs()) {
            return this.dDn.getVoiceManager();
        }
        if (this.dPY == null) {
            return null;
        }
        Fragment currentFragment = this.dPY.getCurrentFragment();
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
    public int lB(int i) {
        if (this.dDm == null) {
            return -1;
        }
        int I = v.I(this.dDm.aBr());
        for (int i2 = 0; i2 < I; i2++) {
            if (this.dDm.aBr().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lD(int i) {
        if (this.dDm != null && i < v.I(this.dDm.aBr())) {
            return this.dDm.aBr().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment ayY() {
        return this.dDn;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> ayZ() {
        if (!aEs()) {
            if (this.dDn instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.dDn).ayZ();
            }
        } else if (this.dPY == null) {
            return null;
        } else {
            Fragment currentFragment = this.dPY.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).ayZ();
            }
        }
        return null;
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.dPW.isLoadingViewAttached()) {
            this.dPW.hideLoadingView(this.dPW.findViewById(16908290));
        }
        if (this.dQm != null) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.dQm);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.dQa, false);
        if (this.dQb != null) {
            this.dQb.cancelLoadData();
        }
    }

    public FragmentTabHost aBh() {
        if (this.dPY == null) {
            return null;
        }
        return this.dPY.aBh();
    }

    public void gx(boolean z) {
        if (this.dPY != null) {
            this.dPY.gx(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEs() {
        if (this.dQe == null) {
            return false;
        }
        return this.dQe.getItem(0) instanceof FrsTabHostFragment;
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
        /* renamed from: mk */
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

        public BaseFragment nR(String str) {
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

        public BaseFragment ml(int i) {
            return (BaseFragment) v.e(this.mFragments, i);
        }

        public String mm(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }
}
