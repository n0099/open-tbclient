package com.baidu.tieba.frs.gametab;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsPageHttpResponseMessage;
import com.baidu.tieba.tbadkCore.i;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsPage.TabSkin;
import tbclient.FrsPage.WorldcupSkin;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class c implements VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    private FrameLayout buH;
    private Pair<Integer, Integer> djF;
    private FrsActivity dyC;
    private FrsFragment dyD;
    private com.baidu.tieba.write.c dyE;
    private ImageView dyF;
    private i dyG;
    private ad dyH;
    private int dyL;
    private ShareSuccessReplyToServerModel dyM;
    private com.baidu.tieba.s.b dyN;
    private String mForumName;
    private FragmentTabHost mTabHost;
    private boolean dyI = false;
    private final Handler mHandler = new Handler();
    private int dyJ = 0;
    private boolean dyO = false;
    private com.baidu.adp.framework.listener.a dyP = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            i iVar = null;
            if (!c.this.dyI && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    iVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    iVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (iVar != null) {
                    c.this.dyI = true;
                    c.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dyQ = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!c.this.dyI && c.this.dyG == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                i iVar = (i) customResponsedMessage.getData();
                if (iVar.baT() != null && c.this.mForumName != null && c.this.mForumName.equals(iVar.baT().getName())) {
                    c.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dyR = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.ayk();
        }
    };
    private CustomMessageListener dyS = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int la;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    la = c.this.la(9);
                    if (la == -1) {
                        la = c.this.la(2);
                    }
                } else {
                    la = c.this.la(intValue);
                }
                if (la != -1 && c.this.mTabHost != null) {
                    c.this.mTabHost.setCurrentTab(la);
                    if (c.this.lb(la) != 1) {
                        c.this.dyD.fx(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener dyT = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.c.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!w.A(newNotifyData)) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < c.this.dyH.avg().size(); i++) {
                                FragmentTabHost.b cA = c.this.mTabHost.cA(i);
                                if (cA != null && cA.mType != 99 && cA.mType != 1 && cA.mType != c.this.mTabHost.getCurrentTabType() && cA.mType == aVar.getTabId() && aVar.axY() && cA.aom.ho(String.valueOf(cA.mType)) != null) {
                                    cA.aom.ho(String.valueOf(cA.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener bwT = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametab.c.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.dyO = true;
            }
        }
    };
    private Runnable dyU = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.12
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this);
            c.this.ayc();
            com.baidu.adp.lib.g.e.im().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                c.this.ayl();
                if (c.this.mTabHost != null) {
                    if (c.this.dyG != null && c.this.dyG.baT() != null) {
                        str = c.this.dyG.baT().getId();
                    }
                    c.this.a(c.this.mTabHost.cA(c.this.mTabHost.getCurrentTabIndex()), str);
                    c.this.mL(str);
                }
            }
        }
    };
    private String dyK = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    public c(FrsActivity frsActivity) {
        this.dyC = frsActivity;
    }

    public void init(Bundle bundle) {
        this.dyP.getHttpMessageListener().setPriority(-1);
        this.dyP.getSocketMessageListener().setPriority(-1);
        this.dyC.registerListener(this.dyQ);
        this.dyS.setSelfListener(true);
        this.dyC.registerListener(this.dyS);
        this.dyR.setSelfListener(true);
        this.dyC.registerListener(this.dyR);
        this.dyC.registerListener(this.bwT);
        if (bundle == null) {
            this.mForumName = this.dyC.getIntent().getStringExtra("name");
            this.dyJ = this.dyC.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.mForumName = bundle.getString("name");
            this.dyJ = bundle.getInt("default_tab_id", 0);
        }
        k(bundle);
        this.dyM = new ShareSuccessReplyToServerModel();
        this.dyC.registerListener(this.dyP);
        this.dyN = new com.baidu.tieba.s.b(this.dyC.getPageContext());
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.dyJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed()) {
            try {
                if (((FrsFragment) fragmentManager.findFragmentByTag("frsFragment")) == null) {
                    fragmentManager.beginTransaction().add(16908290, l(bundle), "frsFragment").commitAllowingStateLoss();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FrsFragment l(Bundle bundle) {
        if (this.dyD == null) {
            this.dyD = new FrsFragment();
            this.dyD.setArguments(bundle);
        }
        this.dyD.djG = false;
        return this.dyD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(i iVar) {
        if (w.z(iVar.bwe()) > 0) {
            this.dyG = iVar;
            if (!this.dyC.isLoadingViewAttached() && this.mTabHost == null) {
                this.dyC.showLoadingView(this.dyC.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.13
                @Override // java.lang.Runnable
                public void run() {
                    c.this.bu(c.this.dyG.bwe());
                }
            });
        } else if (this.mTabHost != null) {
            this.buH.removeView(this.mTabHost);
            this.mTabHost = null;
            this.dyH = null;
            if (this.dyF != null && this.dyF.getParent() != null) {
                ((ViewGroup) this.dyF.getParent()).removeView(this.dyF);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.14
                @Override // java.lang.Runnable
                public void run() {
                    c.this.axZ();
                    c.this.k(c.this.dyD != null ? c.this.dyD.getArguments() : null);
                    if (c.this.dyD instanceof NavigationBar.a) {
                        c.this.dyD.b((Pair<Integer, Integer>) null);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axZ() {
        try {
            this.dyD.djG = true;
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStackImmediate((String) null, 1);
            fragmentManager.beginTransaction().remove(this.dyD).commit();
            fragmentManager.executePendingTransactions();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private FragmentManager getFragmentManager() {
        if (this.dyC != null) {
            return this.dyC.getSupportFragmentManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(List<FrsTabInfo> list) {
        if (this.dyC.isLoadingViewAttached()) {
            this.dyC.hideLoadingView(this.dyC.findViewById(16908290));
        }
        if (this.mTabHost == null && axZ()) {
            aya();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_game_login_tip", true)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_game_login_tip", false);
            }
            bv(list);
        }
    }

    private void aya() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dyC.registerListener(1021074, this.dyT);
    }

    private void bv(List<FrsTabInfo> list) {
        List list2;
        boolean z;
        if (!w.A(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(c.this.dyK, true)) {
                            com.baidu.adp.lib.g.e.im().post(c.this.dyU);
                        }
                        c.this.aye();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.dyC.registerListener(customMessageListener);
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
            builder.tab_name = this.dyC.getResources().getString(d.k.send);
            builder.tab_type = 0;
            int z2 = w.z(arrayList);
            if (z2 > 4) {
                list2 = arrayList.subList(0, 4);
                list2.add(2, builder.build(false));
            } else if (z2 < 2) {
                arrayList.add(builder.build(false));
                list2 = arrayList;
            } else {
                arrayList.add(z2 / 2, builder.build(false));
                list2 = arrayList;
            }
            this.dyH = new ad(this.dyC.getActivity(), list2);
            if (ath() != null) {
                this.dyH.setForumId(ath().getForumId());
                this.dyH.setForumName(ath().getForumName());
                if (ath().atZ() != null && ath().atZ().baT() != null) {
                    ForumData baT = ath().atZ().baT();
                    this.dyH.setForumGameLabel(baT.getForumGameLabel());
                    this.dyH.mw(baT.getSpecialForumType());
                }
            }
            this.dyD.djG = false;
            new e(this.dyD).a(this.dyH);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.dyH);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.dyC.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    private void ayb() {
        int ayn = ayn();
        if (ayn >= 0) {
            a(this.dyD, ayn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayc() {
        if (this.dyH != null && !TextUtils.isEmpty(this.dyH.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.dyG.baT().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private FragmentTabHost.a ayd() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.gametab.c.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                c.this.a(c.this.mTabHost.getCurrentFragment(), i);
                if (c.this.lb(i) != 1) {
                    c.this.dyD.fx(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FragmentTabHost.b cA = c.this.mTabHost.cA(i);
                if (c.this.dyG != null && c.this.dyG.baT() != null) {
                    str = c.this.dyG.baT().getId();
                }
                c.this.a(cA, str);
                if (cA.mType == 99) {
                    c.this.ayl();
                    c.this.mL(str);
                    return false;
                } else if (cA.mType == 5 && !TbadkCoreApplication.isLogin()) {
                    bb.aT(c.this.dyC.getPageContext().getPageActivity());
                    return false;
                } else {
                    if (cA.aom != null) {
                        cA.aom.Ju();
                    }
                    if (cA.aom.ho(String.valueOf(cA.mType)) != null) {
                        if (!(cA.aom.ho(String.valueOf(cA.mType)).view.getVisibility() == 0)) {
                            if (c.this.dyL == i) {
                                c.this.b(cA);
                            }
                        } else {
                            cA.aom.ho(String.valueOf(cA.mType)).view.setVisibility(8);
                            c.this.b(cA);
                        }
                    }
                    c.this.dyL = i;
                    return true;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mL(String str) {
        if (!ayh() && this.mTabHost != null) {
            TiebaStatic.log(new an("c12342").r("obj_locate", c(this.mTabHost.cA(this.mTabHost.getCurrentTabIndex()))).ah(ImageViewerConfig.FORUM_ID, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FragmentTabHost.b bVar, String str) {
        if (ayh()) {
            com.baidu.tieba.frs.worldcup.c.b(bVar, str);
        } else {
            TiebaStatic.log(new an("c12334").r("obj_locate", c(bVar)).ah(ImageViewerConfig.FORUM_ID, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aye() {
        List<TabSkin> list;
        TabSkin tabSkin;
        if (this.dyH != null) {
            this.dyH.avh();
            if (!w.A(this.dyH.att())) {
                ayb();
                if (this.mTabHost == null) {
                    this.mTabHost = new FragmentTabHost(this.dyC.getActivity());
                    this.mTabHost.setClipChildren(false);
                    this.mTabHost.setClipToPadding(false);
                    this.mTabHost.setup(this.dyC.getSupportFragmentManager());
                    this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
                    this.buH = new FrameLayout(this.dyC.getActivity());
                    this.buH.setClipChildren(false);
                    this.buH.setClipToPadding(false);
                    this.buH.addView(this.mTabHost);
                    this.dyC.setContentView(this.buH);
                    this.mTabHost.setOnTabSelectionListener(ayd());
                } else {
                    this.mTabHost.reset();
                }
                List<com.baidu.tbadk.mainTab.b> att = this.dyH.att();
                List<FrsTabInfo> avg = this.dyH.avg();
                this.djF = null;
                if (this.dyG != null && this.dyG.bwk() != null) {
                    WorldcupSkin bwk = this.dyG.bwk();
                    List<TabSkin> list2 = bwk.tab_skin;
                    this.djF = new Pair<>(Integer.valueOf(com.baidu.tieba.frs.worldcup.b.ng(bwk.worldcup_top)), Integer.valueOf(com.baidu.tieba.frs.worldcup.b.ng(bwk.worldcup_top_night)));
                    int e = l.e(this.dyC.getActivity(), d.e.ds10);
                    this.mTabHost.setTabWidgetViewPadding(0, e, 0, e);
                    this.mTabHost.setTabWidgetViewHeight(l.e(this.dyC.getActivity(), d.e.tbds188));
                    this.mTabHost.setNeedShowThemeStyle(false);
                    this.mTabHost.setShouldDrawDividerLine(false);
                    this.mTabHost.setShouldDrawIndicatorLine(false);
                    this.mTabHost.setShouldDrawTopLine(false);
                    this.mTabHost.aH(false);
                    list = list2;
                } else {
                    this.mTabHost.setTabWidgetViewPadding(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
                    this.mTabHost.aI(true);
                    this.mTabHost.setShouldDrawDividerLine(false);
                    this.mTabHost.setShouldDrawIndicatorLine(false);
                    this.mTabHost.setShouldDrawTopLine(false);
                    this.mTabHost.aH(false);
                    this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    list = null;
                }
                if (avg.size() == att.size()) {
                    int size = avg.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = att.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = avg.get(i);
                            if (list != null) {
                                tabSkin = com.baidu.tieba.frs.worldcup.b.j(list, frsTabInfo.tab_id.intValue());
                                Fragment fragment = bVar.Jt().aRL;
                                if (fragment != null && (fragment instanceof NavigationBar.a)) {
                                    ((NavigationBar.a) fragment).b(this.djF);
                                }
                            } else {
                                tabSkin = null;
                            }
                            a(bVar, bVar.Jt(), bVar.bd(this.dyC.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "", tabSkin);
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : att) {
                        a(bVar2, bVar2.Jt(), bVar2.bd(this.dyC.getActivity()), null, null);
                    }
                }
                this.mTabHost.cy(2);
                this.mTabHost.setViewPagerScrollable(false);
                int la = la(this.dyJ);
                if (la < 0) {
                    la = la(this.dyG.bwf());
                }
                if (la < 0) {
                    la = ayn();
                }
                if (la < 0) {
                    la = 0;
                }
                this.dyJ = la;
                this.dyL = la;
                this.mTabHost.setCurrentTab(la);
                if (lb(la) != 1) {
                    this.dyD.fx(false);
                }
                kZ(la);
                if (!ayf()) {
                    ayj();
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                ayi();
            }
        }
    }

    private void kZ(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.4
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (c.this.mTabHost != null) {
                    c.this.a(c.this.mTabHost.getCurrentFragment(), i);
                    if (c.this.dyG != null && c.this.dyG.baT() != null) {
                        str = c.this.dyG.baT().getId();
                    }
                    c.this.a(c.this.mTabHost.cA(c.this.mTabHost.getCurrentTabIndex()), str);
                }
            }
        });
    }

    private int ge(boolean z) {
        if (z && this.djF != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                return ((Integer) this.djF.second).intValue();
            }
            return ((Integer) this.djF.first).intValue();
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            return this.dyC.getResources().getColor(d.C0142d.cp_bg_line_d_1);
        } else {
            return this.dyC.getResources().getColor(d.C0142d.cp_bg_line_d);
        }
    }

    private boolean ayf() {
        return (this.dyG == null || this.dyG.bwk() == null) ? false : true;
    }

    private boolean ayg() {
        if (this.mTabHost == null) {
            return false;
        }
        switch (this.mTabHost.getCurrentTabType()) {
            case 12:
            case 102:
            case 103:
                return true;
            default:
                return false;
        }
    }

    private boolean ayh() {
        if (this.dyG == null || this.dyG.baT() == null) {
            return false;
        }
        return "worldcup".equals(this.dyG.baT().getSpecialForumType());
    }

    private void ayi() {
        if (this.dyG != null && this.dyG.bwk() != null && this.mTabHost != null) {
            WorldcupSkin bwk = this.dyG.bwk();
            this.mTabHost.setTabWidgetBackgroundImageUrl(new Pair<>(bwk.worldcup_bottom, bwk.worldcup_bottom_night));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(FragmentTabHost.b bVar) {
        if (bVar.mType == 2) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_2"));
        } else if (bVar.mType == 3) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGoodsTab_3"));
        } else if (bVar.mType == 101) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsInfoTab_101"));
        } else if (bVar.mType == 305) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsRankList_305"));
        } else if (bVar.mType == 4) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsLiveLive_4"));
        } else if (bVar.mType == 1) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_1"));
        } else if (bVar.mType == 5) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsLivePersonal_5"));
        } else if (bVar.mType == 8) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_8"));
        } else if (bVar.mType == 9) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameLive_9"));
        } else if (bVar.mType == 11) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsGameRecommend_11"));
        } else if (bVar.mType == 12) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001446, "FrsTalkBallTab_12"));
        }
    }

    private void ayj() {
        if (this.mTabHost != null && this.mTabHost.cB(99) != null) {
            if (this.dyF == null || this.dyF.getParent() == null) {
                if (this.dyF == null) {
                    this.dyF = new ImageView(this.dyC.getActivity());
                }
                int e = l.e(this.dyC.getActivity(), d.e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(e, e);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = l.e(this.dyC.getActivity(), d.e.ds5);
                this.dyF.setLayoutParams(layoutParams);
                am.c(this.dyF, d.f.icon_tabbar_add_n);
                am.i(this.dyF, d.f.icon_tabbar_chaticon_n);
                this.dyF.setOnClickListener(this.mOnClickListener);
                if (this.dyF.getParent() == null && this.buH != null) {
                    this.buH.addView(this.dyF);
                }
            }
        }
    }

    private int c(FragmentTabHost.b bVar) {
        if (bVar.mType == 101) {
            return 1;
        }
        if (bVar.mType == 1) {
            return 2;
        }
        if (bVar.mType == 2) {
            return 3;
        }
        if (bVar.mType == 3) {
            return 4;
        }
        if (bVar.mType == 99) {
            return 5;
        }
        if (bVar.mType == 4) {
            return 6;
        }
        if (bVar.mType == 305) {
            return 7;
        }
        if (bVar.mType == 5) {
            return 8;
        }
        if (bVar.mType == 11) {
            return 11;
        }
        if (bVar.mType == 9) {
            return 9;
        }
        return bVar.mType == 8 ? 10 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Fragment fragment, int i) {
        NavigationBar UW;
        if ((fragment instanceof ak) && this.dyG != null && this.dyG.baT() != null && (UW = ((ak) fragment).UW()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dyG.baT().getName(), 5, true, true) + this.dyC.getActivity().getString(d.k.forum));
            UW.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str, TabSkin tabSkin) {
        boolean z = true;
        if (cVar != null && this.dyG != null && this.dyG.baT() != null) {
            ForumData baT = this.dyG.baT();
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mType = cVar.type;
            bVar2.aon = cVar.aRL;
            if (bVar2.aon.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", baT.getName());
                bundle.putString("from", baT.getSpecialForumType());
                bundle.putString(ImageViewerConfig.FORUM_ID, baT.getId());
                bundle.putString(ImageViewerConfig.FORUM_NAME, baT.getName());
                bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
                bVar2.aon.setArguments(bundle);
            } else {
                bVar2.aon.getArguments().putString(ImageViewerConfig.FORUM_ID, baT.getId());
                bVar2.aon.getArguments().putString(ImageViewerConfig.FORUM_NAME, baT.getName());
                bVar2.aon.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            }
            if (tabSkin != null) {
                tbFragmentTabIndicator.setAnimationResId(d.a.frs_tab_indicator_anim);
                tbFragmentTabIndicator.setContentTvTopMargin(l.e(this.dyC, d.e.tbds8));
                tbFragmentTabIndicator.setTextColorResId(d.C0142d.skin_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, l.e(this.dyC.getActivity(), d.e.fontsize26));
                tbFragmentTabIndicator.au(tabSkin.icon, tabSkin.icon_night);
                if (cVar.aRS == com.baidu.tbadk.mainTab.c.aRP && cVar.type == 99) {
                    int e = l.e(this.dyC, d.e.tbds144);
                    tbFragmentTabIndicator.setIconResourceId(d.f.icon_frs_worldcup_morenc_n);
                    tbFragmentTabIndicator.setIconViewWithoutText(e, l.e(this.dyC.getActivity(), d.e.tbds8));
                } else {
                    int e2 = l.e(this.dyC, d.e.tbds114);
                    tbFragmentTabIndicator.setIconResourceId(d.f.icon_frs_worldcup_moren_n);
                    tbFragmentTabIndicator.setIconViewWithText(e2, 0);
                }
            } else {
                tbFragmentTabIndicator.setContentTvTopMargin(l.e(this.dyC, d.e.tbds2));
                tbFragmentTabIndicator.setIconResourceId(cVar.aRN);
                tbFragmentTabIndicator.setTextColorResId(d.C0142d.s_game_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, l.e(this.dyC.getActivity(), d.e.fontsize30));
                if (cVar.aRS == com.baidu.tbadk.mainTab.c.aRP && cVar.type == 99) {
                    tbFragmentTabIndicator.setIconViewWithoutText(l.e(this.dyC, d.e.ds96), l.e(this.dyC.getActivity(), d.e.tbds12));
                }
            }
            if (!TextUtils.isEmpty(str)) {
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.aRM);
            }
            tbFragmentTabIndicator.dD(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(false);
            if (cVar.aRS != com.baidu.tbadk.mainTab.c.aRP || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.aom = tbFragmentTabIndicator;
            bVar2.aoo = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.dyC.getResources().getDimensionPixelSize(d.e.ds12);
        ImageView imageView = new ImageView(this.dyC);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(d.f.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.dyC.getResources().getDimensionPixelSize(d.e.ds12));
        aVar.aSf = fragmentTabIndicator;
        aVar.zb = this.dyC.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dyD instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dyD.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gd(int i) {
        if (this.dyD instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dyD.gd(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dyD instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dyD.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.dyD != null) {
            this.dyD.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.mTabHost == null) {
            this.dyD.setPrimary(true);
        } else {
            Fragment currentFragment = this.mTabHost.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.dyO) {
            this.dyO = false;
            if (this.dyD != null) {
                this.dyD.refresh();
            }
        }
    }

    public void onPause() {
        if (this.mTabHost == null) {
            this.dyD.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.mTabHost.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTabHost == null) {
            this.dyD.onChangeSkinType(i);
        } else {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            ayi();
        }
        if (this.dyF != null) {
            am.c(this.dyF, d.f.icon_tabbar_add_n);
            am.i(this.dyF, d.f.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mTabHost != null && this.dyE != null && this.dyE.isShowing()) {
                this.dyE.bGG();
                UtilHelper.setNavigationBarBackground(this.dyC, ge(true));
            } else if (this.dyD != null && this.dyD.isAdded()) {
                if (this.dyD.onKeyDown(i, keyEvent)) {
                    return true;
                }
                ayk();
            } else {
                return this.dyC.b(i, keyEvent);
            }
            return false;
        }
        return this.dyC.b(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayk() {
        if (this.dyL != this.dyJ && this.mTabHost != null && !ayg()) {
            this.mTabHost.setCurrentTab(this.dyJ);
            if (lb(this.dyJ) != 1) {
                this.dyD.fx(false);
            }
            this.dyL = this.dyJ;
            a(this.mTabHost.getCurrentFragment(), this.dyJ);
            return;
        }
        this.dyD.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.mTabHost == null) {
            this.dyD.onActivityResult(i, i2, intent);
        } else if (99 == this.mTabHost.getCurrentTabType() || 1 == this.mTabHost.getCurrentTabType()) {
            this.dyD.onActivityResult(i, i2, intent);
        } else {
            this.mTabHost.getCurrentFragment().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.bor().x(this.dyC.getPageContext());
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.dyM != null) {
                        this.dyM.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.c.6
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void Ew() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.6.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (c.this.dyC != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(c.this.dyC.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.bor().x(this.dyC.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.mTabHost == null) {
            return this.dyD.getVoiceManager();
        }
        Fragment currentFragment = this.mTabHost.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void ayl() {
        if (bb.aU(this.dyC) && !this.dyN.bBi() && !aym()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            if (this.dyE == null) {
                this.dyE = new com.baidu.tieba.write.c(this.dyC.getPageContext(), this.buH, "frs");
                this.dyE.vw("2");
            }
            this.dyE.a(this.dyD.auc());
            this.dyE.vl(ge(true));
            UtilHelper.setNavigationBarBackground(this.dyC, ge(false));
            this.dyE.nB(false);
        }
    }

    public boolean aym() {
        if (this.dyD != null && this.dyD.isAdded() && this.dyD.getPageContext() != null) {
            d.a(this.dyD.getPageContext(), this.dyD.atZ());
        }
        return false;
    }

    private int ayn() {
        if (this.dyH == null) {
            return -1;
        }
        int z = w.z(this.dyH.avg());
        for (int i = 0; i < z; i++) {
            if (this.dyH.avg().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int la(int i) {
        if (this.dyH == null) {
            return -1;
        }
        int z = w.z(this.dyH.avg());
        for (int i2 = 0; i2 < z; i2++) {
            if (this.dyH.avg().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lb(int i) {
        if (this.dyH != null && i < w.z(this.dyH.avg())) {
            return this.dyH.avg().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment ath() {
        return this.dyD;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> ati() {
        if (this.mTabHost == null) {
            if (this.dyD instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.dyD).ati();
            }
        } else {
            Fragment currentFragment = this.mTabHost.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).ati();
            }
        }
        return null;
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.dyC.isLoadingViewAttached()) {
            this.dyC.hideLoadingView(this.dyC.findViewById(16908290));
        }
        if (this.dyU != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.dyU);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.dyK, false);
        if (this.dyM != null) {
            this.dyM.cancelLoadData();
        }
    }

    public FragmentTabHost ayo() {
        return this.mTabHost;
    }

    public void gf(boolean z) {
        if (this.dyF != null) {
            this.dyF.setVisibility(z ? 0 : 8);
        }
    }
}
