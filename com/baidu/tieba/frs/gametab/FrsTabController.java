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
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
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
/* loaded from: classes2.dex */
public class FrsTabController implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    public static final String dHV = FrsFragment.class.getSimpleName();
    public static final String dHW = FrsLiteProgramListFragment.class.getSimpleName();
    public static final String dHX = FrsTabHostFragment.class.getSimpleName();
    private FrsActivity dHY;
    private FrsLiteProgramListFragment dHZ;
    private FrsTabHostFragment dIa;
    private ShareSuccessReplyToServerModel dId;
    private FrsBaseViewPager dIf;
    private FragmentAdapter dIg;
    private boolean dIh;
    private boolean dIi;
    private ad dvl;
    private FrsFragment dvm;
    private i dvn;
    private int dvp;
    private String mForumName;
    private boolean dIb = false;
    private final Handler mHandler = new Handler();
    private int dvo = 0;
    private boolean dIe = false;
    private com.baidu.adp.framework.listener.a dIj = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            i iVar = null;
            if (!FrsTabController.this.dIb && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    iVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    iVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (iVar != null) {
                    FrsTabController.this.dIb = true;
                    FrsTabController.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dIk = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!FrsTabController.this.dIb && FrsTabController.this.dvn == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                i iVar = (i) customResponsedMessage.getData();
                if (iVar.bbH() != null && FrsTabController.this.mForumName != null && FrsTabController.this.mForumName.equals(iVar.bbH().getName())) {
                    FrsTabController.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dIl = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsTabController.this.aAY();
        }
    };
    private CustomMessageListener dIm = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int ld;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    ld = FrsTabController.this.ld(9);
                    if (ld == -1) {
                        ld = FrsTabController.this.ld(2);
                    }
                } else {
                    ld = FrsTabController.this.ld(intValue);
                }
                if (ld != -1 && FrsTabController.this.aAZ() && FrsTabController.this.dIa != null) {
                    FrsTabController.this.dIa.setCurrentTab(ld);
                    if (FrsTabController.this.lf(ld) != 1) {
                        FrsTabController.this.dvm.fQ(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener dIn = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!v.z(newNotifyData) && FrsTabController.this.dIa != null) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < FrsTabController.this.dvl.axV().size(); i++) {
                                FragmentTabHost.b cM = FrsTabController.this.dIa.cM(i);
                                if (cM != null && cM.mType != 99 && cM.mType != 1 && cM.mType != FrsTabController.this.dIa.getCurrentTabType() && cM.mType == aVar.getTabId() && aVar.aAQ() && cM.aqu.hH(String.valueOf(cM.mType)) != null) {
                                    cM.aqu.hH(String.valueOf(cM.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable dIo = new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.15
        @Override // java.lang.Runnable
        public void run() {
            e.jt().removeCallbacks(this);
            FrsTabController.this.aAX();
            e.jt().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private CustomMessageListener bDp = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                FrsTabController.this.dIe = true;
            }
        }
    };
    private CustomMessageListener dIp = new CustomMessageListener(2921363) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!g.isFastDoubleClick() && customResponsedMessage != null && FrsTabController.this.dIf != null && FrsTabController.this.dIg != null && FrsTabController.this.dIg.np(FrsTabController.dHW) != null) {
                FrsTabController.this.dIf.setCurrentItem(1);
            }
        }
    };
    private CustomMessageListener dIq = new CustomMessageListener(2921366) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.dIf != null && FrsTabController.this.dIg != null && FrsTabController.this.dIg.np(FrsTabController.dHW) != null) {
                FrsTabController.this.dIf.setCurrentItem(0);
            }
        }
    };
    private CustomMessageListener dIr = new CustomMessageListener(2921361) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.dIf != null && FrsTabController.this.dIg != null && (customResponsedMessage.getData() instanceof FrsTabViewPager.a)) {
                FrsTabViewPager.a aVar = (FrsTabViewPager.a) customResponsedMessage.getData();
                FrsTabController.this.dIh = aVar.axS();
                FrsTabController.this.dIi = aVar.axT();
            }
        }
    };
    private CustomMessageListener dIs = new CustomMessageListener(2921362) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsTabController.this.dIf != null && FrsTabController.this.dIg != null && (customResponsedMessage.getData() instanceof Boolean)) {
                FrsTabController.this.dIf.setForceIntercept(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private ViewPager.OnPageChangeListener dIt = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.4
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                FrsTabController.this.aAR();
            }
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            switch (i) {
                case 0:
                    FrsTabController.this.dIi = false;
                    FrsTabController.this.dIf.setForceIntercept(false);
                    return;
                default:
                    return;
            }
        }
    };
    private FrsBaseViewPager.a dIu = new FrsBaseViewPager.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.5
        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void avP() {
            if (FrsTabController.this.dIf != null) {
                if (FrsTabController.this.dIf.getCurrentItem() == 0) {
                    if (FrsTabController.this.dIh) {
                        FrsTabController.this.dIf.setmDisallowSlip(false);
                        return;
                    } else {
                        FrsTabController.this.dIf.setmDisallowSlip(true);
                        return;
                    }
                }
                FrsTabController.this.dIf.setmDisallowSlip(false);
            }
        }

        @Override // com.baidu.tieba.frs.FrsBaseViewPager.a
        public void avQ() {
            if (FrsTabController.this.dIf.getCurrentItem() == 0) {
                if (FrsTabController.this.dIh && FrsTabController.this.dIi) {
                    FrsTabController.this.dIf.setmDisallowSlip(false);
                }
                if (!FrsTabController.this.dIi) {
                    FrsTabController.this.dIf.setmDisallowSlip(true);
                    return;
                }
                return;
            }
            FrsTabController.this.dIf.setmDisallowSlip(false);
        }
    };
    private String dIc = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    /* JADX INFO: Access modifiers changed from: private */
    public void aAR() {
        if (this.dHZ != null && avB() != null) {
            this.dHZ.dLw = true;
            this.dHZ.clear();
            if (!j.kK()) {
                this.dHZ.nB(avB().getForumId());
            } else if ((avB().awv().gTS != null && avB().awv().gTS.size() == 1) || (avB().awv().gTS == null && avB().awv().gTT != null)) {
                String str = null;
                if (avB().awv() != null && avB().awv().gTT != null) {
                    str = avB().awv().gTT.h5_url;
                }
                this.dHZ.nC(str);
            } else {
                this.dHZ.showLoadingView();
                FrsLiteProgramListFragment frsLiteProgramListFragment = this.dHZ;
                String forumId = avB().getForumId();
                FrsLiteProgramListFragment frsLiteProgramListFragment2 = this.dHZ;
                FrsLiteProgramListFragment frsLiteProgramListFragment3 = this.dHZ;
                frsLiteProgramListFragment.r(forumId, 1, 10);
                TiebaStatic.log(new am("c13273").al(ImageViewerConfig.FORUM_ID, avB().getForumId()).al("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public FrsTabController(FrsActivity frsActivity) {
        this.dHY = frsActivity;
    }

    public void init(Bundle bundle) {
        if (this.dHY != null) {
            this.dHY.setContentView(e.h.frs_base_layout);
            this.dIf = (FrsBaseViewPager) this.dHY.findViewById(e.g.frs_base_viewpager);
            this.dIg = new FragmentAdapter(this.dHY.getSupportFragmentManager());
            this.dIf.setAdapter(this.dIg);
            this.dIf.setPageTransformer(true, new CubeOutViewPagerTransformer());
            this.dIf.addOnPageChangeListener(this.dIt);
            this.dIf.setmDisallowSlip(true);
            this.dIf.setOnTouchEventListener(this.dIu);
            this.dHY.registerListener(this.dIr);
            this.dHY.registerListener(this.dIs);
            this.dHY.registerListener(this.dIp);
            this.dHY.registerListener(this.dIq);
            this.dIj.getHttpMessageListener().setPriority(-1);
            this.dIj.getSocketMessageListener().setPriority(-1);
            this.dHY.registerListener(this.dIk);
            this.dIm.setSelfListener(true);
            this.dHY.registerListener(this.dIm);
            this.dIl.setSelfListener(true);
            this.dHY.registerListener(this.dIl);
            this.dHY.registerListener(this.bDp);
            if (bundle == null) {
                this.mForumName = this.dHY.getIntent().getStringExtra("name");
                this.dvo = this.dHY.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
            } else {
                this.mForumName = bundle.getString("name");
                this.dvo = bundle.getInt("default_tab_id", 0);
            }
            k(bundle);
            this.dIg.notifyDataSetChanged();
            this.dId = new ShareSuccessReplyToServerModel();
            this.dHY.registerListener(this.dIj);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.dvo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.dIg != null) {
            try {
                FrsFragment frsFragment = (FrsFragment) this.dIg.np(dHV);
                if (frsFragment == null) {
                    frsFragment = l(bundle);
                }
                if (!dHV.equals(this.dIg.lO(0))) {
                    if (dHX.equals(this.dIg.lO(0))) {
                        this.dIg.lN(0);
                    }
                    this.dIg.a(0, frsFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAS() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.dIg != null) {
            try {
                FrsLiteProgramListFragment frsLiteProgramListFragment = (FrsLiteProgramListFragment) this.dIg.np(dHW);
                if (frsLiteProgramListFragment == null) {
                    frsLiteProgramListFragment = aAU();
                }
                if (!dHW.equals(this.dIg.lO(1))) {
                    this.dIg.a(1, frsLiteProgramListFragment);
                    this.dIg.notifyDataSetChanged();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAT() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && this.dIg != null) {
            try {
                FrsTabHostFragment frsTabHostFragment = (FrsTabHostFragment) this.dIg.np(dHX);
                if (frsTabHostFragment == null) {
                    frsTabHostFragment = aAV();
                }
                if (!dHX.equals(this.dIg.lO(0))) {
                    if (dHV.equals(this.dIg.lO(0))) {
                        this.dIg.lN(0);
                    }
                    this.dIg.a(0, frsTabHostFragment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment l(Bundle bundle) {
        if (this.dvm == null) {
            this.dvm = new FrsFragment();
            this.dvm.setArguments(bundle);
            this.dvm.setBaseTag(dHV);
        }
        this.dvm.dsr = false;
        return this.dvm;
    }

    private FrsLiteProgramListFragment aAU() {
        if (this.dHZ == null) {
            this.dHZ = new FrsLiteProgramListFragment();
            this.dHZ.setBaseTag(dHW);
        }
        return this.dHZ;
    }

    private FrsTabHostFragment aAV() {
        if (this.dIa == null) {
            this.dIa = new FrsTabHostFragment();
            this.dIa.setBaseTag(dHX);
        }
        return this.dIa;
    }

    private FragmentManager getFragmentManager() {
        if (this.dHY != null) {
            return this.dHY.getSupportFragmentManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(i iVar) {
        if (iVar.gTT != null || !v.z(iVar.gTS)) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.6
                @Override // java.lang.Runnable
                public void run() {
                    FrsTabController.this.aAS();
                }
            });
        }
        if (v.y(iVar.bxp()) > 0) {
            this.dvn = iVar;
            if (!this.dHY.isLoadingViewAttached() && !aAZ()) {
                this.dHY.showLoadingView(this.dHY.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.7
                @Override // java.lang.Runnable
                public void run() {
                    FrsTabController.this.bu(FrsTabController.this.dvn.bxp());
                }
            });
        } else if (aAZ()) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.8
                @Override // java.lang.Runnable
                public void run() {
                    FrsTabController.this.dvm.dsr = true;
                    FrsTabController.this.k(FrsTabController.this.dvm != null ? FrsTabController.this.dvm.getArguments() : null);
                    FrsTabController.this.dIg.notifyDataSetChanged();
                    if (FrsTabController.this.dvm instanceof NavigationBar.a) {
                        FrsTabController.this.dvm.b((Pair<Integer, Integer>) null);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(List<FrsTabInfo> list) {
        if (this.dHY.isLoadingViewAttached()) {
            this.dHY.hideLoadingView(this.dHY.findViewById(16908290));
        }
        if (!aAZ()) {
            this.dvm.dsr = true;
            aAW();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_game_login_tip", true)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_game_login_tip", false);
            }
            bv(list);
        }
    }

    private void aAW() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dHY.registerListener(1021074, this.dIn);
    }

    private void bv(List<FrsTabInfo> list) {
        List list2;
        boolean z;
        if (!v.z(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.FrsTabController.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(FrsTabController.this.dIc, true)) {
                            com.baidu.adp.lib.g.e.jt().post(FrsTabController.this.dIo);
                        }
                        FrsTabController.this.aAT();
                        FrsTabController.this.dIg.notifyDataSetChanged();
                        if (FrsTabController.this.dIa != null) {
                            FrsTabController.this.dIa.C(FrsTabController.this.dvm);
                            FrsTabController.this.dIa.a(FrsTabController.this.dvn, FrsTabController.this.dvl);
                        }
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.dHY.registerListener(customMessageListener);
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
            builder.tab_name = this.dHY.getResources().getString(e.j.send);
            builder.tab_type = 0;
            int y = v.y(arrayList);
            if (y > 4) {
                list2 = arrayList.subList(0, 4);
                list2.add(2, builder.build(false));
            } else if (y < 2) {
                arrayList.add(builder.build(false));
                list2 = arrayList;
            } else {
                arrayList.add(y / 2, builder.build(false));
                list2 = arrayList;
            }
            this.dvl = new ad(this.dHY.getActivity(), list2);
            if (avB() != null) {
                this.dvl.setForumId(avB().getForumId());
                this.dvl.setForumName(avB().getForumName());
                if (avB().awv() != null && avB().awv().bbH() != null) {
                    ForumData bbH = avB().awv().bbH();
                    this.dvl.setForumGameLabel(bbH.getForumGameLabel());
                    this.dvl.na(bbH.getSpecialForumType());
                }
            }
            this.dvm.dsr = false;
            new d(this.dvm).a(this.dvl);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.dvl);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.dHY.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAX() {
        if (this.dvl != null && !TextUtils.isEmpty(this.dvl.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.dvn.bbH().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private void a(Fragment fragment, int i) {
        NavigationBar WW;
        if ((fragment instanceof ak) && this.dvn != null && this.dvn.bbH() != null && (WW = ((ak) fragment).WW()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dvn.bbH().getName(), 5, true, true) + this.dHY.getActivity().getString(e.j.forum));
            WW.setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dvm instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dvm.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gI(int i) {
        if (this.dvm instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dvm.gI(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dvm instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dvm.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.dvm != null) {
            this.dvm.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (!aAZ()) {
            this.dvm.setPrimary(true);
        } else if (this.dIa != null) {
            Fragment currentFragment = this.dIa.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.dIe) {
            this.dIe = false;
            if (this.dvm != null) {
                this.dvm.refresh();
            }
        }
    }

    public void onPause() {
        if (!aAZ()) {
            this.dvm.setPrimary(false);
        } else if (this.dIa != null) {
            Fragment currentFragment = this.dIa.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(false);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.dvm != null) {
            this.dvm.onChangeSkinType(i);
        }
        if (this.dIa != null) {
            this.dIa.onChangeSkinType(i);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.dHZ != null && this.dHZ.dLw) {
                this.dHZ.dLw = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921366));
                return true;
            }
            if (aAZ() && this.dIa != null && this.dIa.axM()) {
                this.dIa.axN();
                UtilHelper.setNavigationBarBackground(this.dHY, this.dIa.ge(true));
            } else if (this.dvm != null && this.dvm.isAdded()) {
                if (this.dvm.onKeyDown(i, keyEvent)) {
                    return true;
                }
                aAY();
            } else {
                return this.dHY.b(i, keyEvent);
            }
            return false;
        }
        return this.dHY.b(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAY() {
        if (this.dvp != this.dvo && aAZ() && this.dIa != null && !this.dIa.axI()) {
            this.dIa.setCurrentTab(this.dvo);
            if (lf(this.dvo) != 1) {
                this.dvm.fQ(false);
            }
            this.dvp = this.dvo;
            a(this.dIa.getCurrentFragment(), this.dvo);
            return;
        }
        this.dvm.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!aAZ()) {
            this.dvm.onActivityResult(i, i2, intent);
        } else if (this.dIa != null) {
            if (99 == this.dIa.getCurrentTabType() || 1 == this.dIa.getCurrentTabType()) {
                this.dvm.onActivityResult(i, i2, intent);
            } else {
                this.dIa.getCurrentFragment().onActivityResult(i, i2, intent);
            }
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.bpD().x(this.dHY.getPageContext());
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.dId != null) {
                        this.dId.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void FH() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.FrsTabController.10.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (FrsTabController.this.dHY != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(FrsTabController.this.dHY.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.bpD().x(this.dHY.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (!aAZ()) {
            return this.dvm.getVoiceManager();
        }
        if (this.dIa == null) {
            return null;
        }
        Fragment currentFragment = this.dIa.getCurrentFragment();
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
    public int ld(int i) {
        if (this.dvl == null) {
            return -1;
        }
        int y = v.y(this.dvl.axV());
        for (int i2 = 0; i2 < y; i2++) {
            if (this.dvl.axV().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lf(int i) {
        if (this.dvl != null && i < v.y(this.dvl.axV())) {
            return this.dvl.axV().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment avB() {
        return this.dvm;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> avC() {
        if (!aAZ()) {
            if (this.dvm instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.dvm).avC();
            }
        } else if (this.dIa == null) {
            return null;
        } else {
            Fragment currentFragment = this.dIa.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).avC();
            }
        }
        return null;
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.dHY.isLoadingViewAttached()) {
            this.dHY.hideLoadingView(this.dHY.findViewById(16908290));
        }
        if (this.dIo != null) {
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.dIo);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.dIc, false);
        if (this.dId != null) {
            this.dId.cancelLoadData();
        }
    }

    public FragmentTabHost axL() {
        if (this.dIa == null) {
            return null;
        }
        return this.dIa.axL();
    }

    public void gf(boolean z) {
        if (this.dIa != null) {
            this.dIa.gf(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAZ() {
        if (this.dIg == null) {
            return false;
        }
        return this.dIg.getItem(0) instanceof FrsTabHostFragment;
    }

    /* loaded from: classes2.dex */
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
        /* renamed from: lM */
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

        public BaseFragment np(String str) {
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

        public BaseFragment lN(int i) {
            return (BaseFragment) v.e(this.mFragments, i);
        }

        public String lO(int i) {
            if (getItem(i) != null) {
                return getItem(i).getBaseTag();
            }
            return null;
        }
    }
}
