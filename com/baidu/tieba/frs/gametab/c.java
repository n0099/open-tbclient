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
import com.baidu.tbadk.core.util.ba;
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
    private FrameLayout bvn;
    private FrsActivity dBo;
    private FrsFragment dBp;
    private com.baidu.tieba.write.c dBq;
    private ImageView dBr;
    private i dBs;
    private ad dBt;
    private int dBx;
    private ShareSuccessReplyToServerModel dBy;
    private com.baidu.tieba.ueg.c dBz;
    private Pair<Integer, Integer> dmv;
    private String mForumName;
    private FragmentTabHost mTabHost;
    private boolean dBu = false;
    private final Handler mHandler = new Handler();
    private int dBv = 0;
    private boolean dBA = false;
    private com.baidu.adp.framework.listener.a dBB = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            i iVar = null;
            if (!c.this.dBu && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    iVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    iVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (iVar != null) {
                    c.this.dBu = true;
                    c.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dBC = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!c.this.dBu && c.this.dBs == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                i iVar = (i) customResponsedMessage.getData();
                if (iVar.aZl() != null && c.this.mForumName != null && c.this.mForumName.equals(iVar.aZl().getName())) {
                    c.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dBD = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.ayP();
        }
    };
    private CustomMessageListener dBE = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int ll;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    ll = c.this.ll(9);
                    if (ll == -1) {
                        ll = c.this.ll(2);
                    }
                } else {
                    ll = c.this.ll(intValue);
                }
                if (ll != -1 && c.this.mTabHost != null) {
                    c.this.mTabHost.setCurrentTab(ll);
                    if (c.this.lm(ll) != 1) {
                        c.this.dBp.fz(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener dBF = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.c.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!w.z(newNotifyData)) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < c.this.dBt.avL().size(); i++) {
                                FragmentTabHost.b cC = c.this.mTabHost.cC(i);
                                if (cC != null && cC.mType != 99 && cC.mType != 1 && cC.mType != c.this.mTabHost.getCurrentTabType() && cC.mType == aVar.getTabId() && aVar.ayD() && cC.anN.hl(String.valueOf(cC.mType)) != null) {
                                    cC.anN.hl(String.valueOf(cC.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener bxy = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametab.c.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.dBA = true;
            }
        }
    };
    private Runnable dBG = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.12
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this);
            c.this.ayH();
            com.baidu.adp.lib.g.e.in().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                c.this.ayQ();
                if (c.this.mTabHost != null) {
                    if (c.this.dBs != null && c.this.dBs.aZl() != null) {
                        str = c.this.dBs.aZl().getId();
                    }
                    c.this.a(c.this.mTabHost.cC(c.this.mTabHost.getCurrentTabIndex()), str);
                    c.this.mK(str);
                }
            }
        }
    };
    private String dBw = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    public c(FrsActivity frsActivity) {
        this.dBo = frsActivity;
    }

    public void init(Bundle bundle) {
        this.dBB.getHttpMessageListener().setPriority(-1);
        this.dBB.getSocketMessageListener().setPriority(-1);
        this.dBo.registerListener(this.dBC);
        this.dBE.setSelfListener(true);
        this.dBo.registerListener(this.dBE);
        this.dBD.setSelfListener(true);
        this.dBo.registerListener(this.dBD);
        this.dBo.registerListener(this.bxy);
        if (bundle == null) {
            this.mForumName = this.dBo.getIntent().getStringExtra("name");
            this.dBv = this.dBo.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.mForumName = bundle.getString("name");
            this.dBv = bundle.getInt("default_tab_id", 0);
        }
        k(bundle);
        this.dBy = new ShareSuccessReplyToServerModel();
        this.dBo.registerListener(this.dBB);
        this.dBz = new com.baidu.tieba.ueg.c(this.dBo.getPageContext());
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.dBv);
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
        if (this.dBp == null) {
            this.dBp = new FrsFragment();
            this.dBp.setArguments(bundle);
        }
        this.dBp.dmw = false;
        return this.dBp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(i iVar) {
        if (w.y(iVar.buI()) > 0) {
            this.dBs = iVar;
            if (!this.dBo.isLoadingViewAttached() && this.mTabHost == null) {
                this.dBo.showLoadingView(this.dBo.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.13
                @Override // java.lang.Runnable
                public void run() {
                    c.this.bt(c.this.dBs.buI());
                }
            });
        } else if (this.mTabHost != null) {
            this.bvn.removeView(this.mTabHost);
            this.mTabHost = null;
            this.dBt = null;
            if (this.dBr != null && this.dBr.getParent() != null) {
                ((ViewGroup) this.dBr.getParent()).removeView(this.dBr);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.14
                @Override // java.lang.Runnable
                public void run() {
                    c.this.ayE();
                    c.this.k(c.this.dBp != null ? c.this.dBp.getArguments() : null);
                    if (c.this.dBp instanceof NavigationBar.a) {
                        c.this.dBp.b((Pair<Integer, Integer>) null);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayE() {
        try {
            this.dBp.dmw = true;
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStackImmediate((String) null, 1);
            fragmentManager.beginTransaction().remove(this.dBp).commit();
            fragmentManager.executePendingTransactions();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private FragmentManager getFragmentManager() {
        if (this.dBo != null) {
            return this.dBo.getSupportFragmentManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(List<FrsTabInfo> list) {
        if (this.dBo.isLoadingViewAttached()) {
            this.dBo.hideLoadingView(this.dBo.findViewById(16908290));
        }
        if (this.mTabHost == null && ayE()) {
            ayF();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_game_login_tip", true)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_game_login_tip", false);
            }
            bu(list);
        }
    }

    private void ayF() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dBo.registerListener(1021074, this.dBF);
    }

    private void bu(List<FrsTabInfo> list) {
        List list2;
        boolean z;
        if (!w.z(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.c.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ad)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(c.this.dBw, true)) {
                            com.baidu.adp.lib.g.e.in().post(c.this.dBG);
                        }
                        c.this.ayJ();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.dBo.registerListener(customMessageListener);
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
            builder.tab_name = this.dBo.getResources().getString(d.j.send);
            builder.tab_type = 0;
            int y = w.y(arrayList);
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
            this.dBt = new ad(this.dBo.getActivity(), list2);
            if (atL() != null) {
                this.dBt.setForumId(atL().getForumId());
                this.dBt.setForumName(atL().getForumName());
                if (atL().auD() != null && atL().auD().aZl() != null) {
                    ForumData aZl = atL().auD().aZl();
                    this.dBt.setForumGameLabel(aZl.getForumGameLabel());
                    this.dBt.mv(aZl.getSpecialForumType());
                }
            }
            this.dBp.dmw = false;
            new e(this.dBp).a(this.dBt);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.dBt);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.dBo.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    private void ayG() {
        int ayS = ayS();
        if (ayS >= 0) {
            a(this.dBp, ayS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayH() {
        if (this.dBt != null && !TextUtils.isEmpty(this.dBt.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.dBs.aZl().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private FragmentTabHost.a ayI() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.gametab.c.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                c.this.a(c.this.mTabHost.getCurrentFragment(), i);
                if (c.this.lm(i) != 1) {
                    c.this.dBp.fz(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FragmentTabHost.b cC = c.this.mTabHost.cC(i);
                if (c.this.dBs != null && c.this.dBs.aZl() != null) {
                    str = c.this.dBs.aZl().getId();
                }
                c.this.a(cC, str);
                if (cC.mType == 99) {
                    c.this.ayQ();
                    c.this.mK(str);
                    return false;
                } else if (cC.mType == 5 && !TbadkCoreApplication.isLogin()) {
                    ba.aU(c.this.dBo.getPageContext().getPageActivity());
                    return false;
                } else {
                    if (cC.anN != null) {
                        cC.anN.Jp();
                    }
                    if (cC.anN.hl(String.valueOf(cC.mType)) != null) {
                        if (!(cC.anN.hl(String.valueOf(cC.mType)).view.getVisibility() == 0)) {
                            if (c.this.dBx == i) {
                                c.this.b(cC);
                            }
                        } else {
                            cC.anN.hl(String.valueOf(cC.mType)).view.setVisibility(8);
                            c.this.b(cC);
                        }
                    }
                    c.this.dBx = i;
                    return true;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mK(String str) {
        if (!ayM() && this.mTabHost != null) {
            TiebaStatic.log(new an("c12342").r("obj_locate", c(this.mTabHost.cC(this.mTabHost.getCurrentTabIndex()))).af(ImageViewerConfig.FORUM_ID, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FragmentTabHost.b bVar, String str) {
        if (ayM()) {
            com.baidu.tieba.frs.worldcup.c.b(bVar, str);
        } else {
            TiebaStatic.log(new an("c12334").r("obj_locate", c(bVar)).af(ImageViewerConfig.FORUM_ID, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayJ() {
        List<TabSkin> list;
        TabSkin tabSkin;
        if (this.dBt != null) {
            this.dBt.avM();
            if (!w.z(this.dBt.atX())) {
                ayG();
                if (this.mTabHost == null) {
                    this.mTabHost = new FragmentTabHost(this.dBo.getActivity());
                    this.mTabHost.setClipChildren(false);
                    this.mTabHost.setClipToPadding(false);
                    this.mTabHost.setup(this.dBo.getSupportFragmentManager());
                    this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
                    this.bvn = new FrameLayout(this.dBo.getActivity());
                    this.bvn.setClipChildren(false);
                    this.bvn.setClipToPadding(false);
                    this.bvn.addView(this.mTabHost);
                    this.dBo.setContentView(this.bvn);
                    this.mTabHost.setOnTabSelectionListener(ayI());
                } else {
                    this.mTabHost.reset();
                }
                List<com.baidu.tbadk.mainTab.b> atX = this.dBt.atX();
                List<FrsTabInfo> avL = this.dBt.avL();
                this.dmv = null;
                if (this.dBs != null && this.dBs.buO() != null) {
                    WorldcupSkin buO = this.dBs.buO();
                    List<TabSkin> list2 = buO.tab_skin;
                    this.dmv = new Pair<>(Integer.valueOf(com.baidu.tieba.frs.worldcup.b.nf(buO.worldcup_top)), Integer.valueOf(com.baidu.tieba.frs.worldcup.b.nf(buO.worldcup_top_night)));
                    int f = l.f(this.dBo.getActivity(), d.e.ds10);
                    this.mTabHost.setTabWidgetViewPadding(0, f, 0, f);
                    this.mTabHost.setTabWidgetViewHeight(l.f(this.dBo.getActivity(), d.e.tbds188));
                    this.mTabHost.setNeedShowThemeStyle(false);
                    this.mTabHost.setShouldDrawDividerLine(false);
                    this.mTabHost.setShouldDrawIndicatorLine(false);
                    this.mTabHost.setShouldDrawTopLine(false);
                    this.mTabHost.aF(false);
                    list = list2;
                } else {
                    this.mTabHost.setTabWidgetViewPadding(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
                    this.mTabHost.aG(true);
                    this.mTabHost.setShouldDrawDividerLine(false);
                    this.mTabHost.setShouldDrawIndicatorLine(false);
                    this.mTabHost.setShouldDrawTopLine(false);
                    this.mTabHost.aF(false);
                    this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    list = null;
                }
                if (avL.size() == atX.size()) {
                    int size = avL.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = atX.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = avL.get(i);
                            if (list != null) {
                                tabSkin = com.baidu.tieba.frs.worldcup.b.j(list, frsTabInfo.tab_id.intValue());
                                Fragment fragment = bVar.Jo().aRL;
                                if (fragment != null && (fragment instanceof NavigationBar.a)) {
                                    ((NavigationBar.a) fragment).b(this.dmv);
                                }
                            } else {
                                tabSkin = null;
                            }
                            a(bVar, bVar.Jo(), bVar.be(this.dBo.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "", tabSkin);
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : atX) {
                        a(bVar2, bVar2.Jo(), bVar2.be(this.dBo.getActivity()), null, null);
                    }
                }
                this.mTabHost.cA(2);
                this.mTabHost.setViewPagerScrollable(false);
                int ll = ll(this.dBv);
                if (ll < 0) {
                    ll = ll(this.dBs.buJ());
                }
                if (ll < 0) {
                    ll = ayS();
                }
                if (ll < 0) {
                    ll = 0;
                }
                this.dBv = ll;
                this.dBx = ll;
                this.mTabHost.setCurrentTab(ll);
                if (lm(ll) != 1) {
                    this.dBp.fz(false);
                }
                lk(ll);
                if (!ayK()) {
                    ayO();
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                ayN();
            }
        }
    }

    private void lk(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.4
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (c.this.mTabHost != null) {
                    c.this.a(c.this.mTabHost.getCurrentFragment(), i);
                    if (c.this.dBs != null && c.this.dBs.aZl() != null) {
                        str = c.this.dBs.aZl().getId();
                    }
                    c.this.a(c.this.mTabHost.cC(c.this.mTabHost.getCurrentTabIndex()), str);
                }
            }
        });
    }

    private int gg(boolean z) {
        if (z && this.dmv != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                return ((Integer) this.dmv.second).intValue();
            }
            return ((Integer) this.dmv.first).intValue();
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            return this.dBo.getResources().getColor(d.C0140d.cp_bg_line_d_1);
        } else {
            return this.dBo.getResources().getColor(d.C0140d.cp_bg_line_d);
        }
    }

    private boolean ayK() {
        return (this.dBs == null || this.dBs.buO() == null) ? false : true;
    }

    private boolean ayL() {
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

    private boolean ayM() {
        if (this.dBs == null || this.dBs.aZl() == null) {
            return false;
        }
        return "worldcup".equals(this.dBs.aZl().getSpecialForumType());
    }

    private void ayN() {
        if (this.dBs != null && this.dBs.buO() != null && this.mTabHost != null) {
            WorldcupSkin buO = this.dBs.buO();
            this.mTabHost.setTabWidgetBackgroundImageUrl(new Pair<>(buO.worldcup_bottom, buO.worldcup_bottom_night));
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

    private void ayO() {
        if (this.mTabHost != null && this.mTabHost.cD(99) != null) {
            if (this.dBr == null || this.dBr.getParent() == null) {
                if (this.dBr == null) {
                    this.dBr = new ImageView(this.dBo.getActivity());
                }
                int f = l.f(this.dBo.getActivity(), d.e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f, f);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = l.f(this.dBo.getActivity(), d.e.ds5);
                this.dBr.setLayoutParams(layoutParams);
                am.c(this.dBr, d.f.icon_tabbar_add_n);
                am.i(this.dBr, d.f.icon_tabbar_chaticon_n);
                this.dBr.setOnClickListener(this.mOnClickListener);
                if (this.dBr.getParent() == null && this.bvn != null) {
                    this.bvn.addView(this.dBr);
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
        NavigationBar Vf;
        if ((fragment instanceof ak) && this.dBs != null && this.dBs.aZl() != null && (Vf = ((ak) fragment).Vf()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dBs.aZl().getName(), 5, true, true) + this.dBo.getActivity().getString(d.j.forum));
            Vf.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str, TabSkin tabSkin) {
        boolean z = true;
        if (cVar != null && this.dBs != null && this.dBs.aZl() != null) {
            ForumData aZl = this.dBs.aZl();
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mType = cVar.type;
            bVar2.anO = cVar.aRL;
            if (bVar2.anO.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", aZl.getName());
                bundle.putString("from", aZl.getSpecialForumType());
                bundle.putString(ImageViewerConfig.FORUM_ID, aZl.getId());
                bundle.putString(ImageViewerConfig.FORUM_NAME, aZl.getName());
                bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
                bVar2.anO.setArguments(bundle);
            } else {
                bVar2.anO.getArguments().putString(ImageViewerConfig.FORUM_ID, aZl.getId());
                bVar2.anO.getArguments().putString(ImageViewerConfig.FORUM_NAME, aZl.getName());
                bVar2.anO.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            }
            if (tabSkin != null) {
                tbFragmentTabIndicator.setAnimationResId(d.a.frs_tab_indicator_anim);
                tbFragmentTabIndicator.setContentTvTopMargin(l.f(this.dBo, d.e.tbds8));
                tbFragmentTabIndicator.setTextColorResId(d.C0140d.skin_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, l.f(this.dBo.getActivity(), d.e.fontsize26));
                tbFragmentTabIndicator.aq(tabSkin.icon, tabSkin.icon_night);
                if (cVar.aRS == com.baidu.tbadk.mainTab.c.aRP && cVar.type == 99) {
                    int f = l.f(this.dBo, d.e.tbds144);
                    tbFragmentTabIndicator.setIconResourceId(d.f.icon_frs_worldcup_morenc_n);
                    tbFragmentTabIndicator.setIconViewWithoutText(f, l.f(this.dBo.getActivity(), d.e.tbds8));
                } else {
                    int f2 = l.f(this.dBo, d.e.tbds114);
                    tbFragmentTabIndicator.setIconResourceId(d.f.icon_frs_worldcup_moren_n);
                    tbFragmentTabIndicator.setIconViewWithText(f2, 0);
                }
            } else {
                tbFragmentTabIndicator.setContentTvTopMargin(l.f(this.dBo, d.e.tbds2));
                tbFragmentTabIndicator.setIconResourceId(cVar.aRN);
                tbFragmentTabIndicator.setTextColorResId(d.C0140d.s_game_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, l.f(this.dBo.getActivity(), d.e.fontsize30));
                if (cVar.aRS == com.baidu.tbadk.mainTab.c.aRP && cVar.type == 99) {
                    tbFragmentTabIndicator.setIconViewWithoutText(l.f(this.dBo, d.e.ds96), l.f(this.dBo.getActivity(), d.e.tbds12));
                }
            }
            if (!TextUtils.isEmpty(str)) {
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.aRM);
            }
            tbFragmentTabIndicator.dG(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(false);
            if (cVar.aRS != com.baidu.tbadk.mainTab.c.aRP || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.anN = tbFragmentTabIndicator;
            bVar2.anP = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.dBo.getResources().getDimensionPixelSize(d.e.ds12);
        ImageView imageView = new ImageView(this.dBo);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(d.f.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.dBo.getResources().getDimensionPixelSize(d.e.ds12));
        aVar.aSf = fragmentTabIndicator;
        aVar.yW = this.dBo.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dBp instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dBp.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gi(int i) {
        if (this.dBp instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dBp.gi(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dBp instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dBp.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.dBp != null) {
            this.dBp.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.mTabHost == null) {
            this.dBp.setPrimary(true);
        } else {
            Fragment currentFragment = this.mTabHost.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.dBA) {
            this.dBA = false;
            if (this.dBp != null) {
                this.dBp.refresh();
            }
        }
    }

    public void onPause() {
        if (this.mTabHost == null) {
            this.dBp.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.mTabHost.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTabHost == null) {
            this.dBp.onChangeSkinType(i);
        } else {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            ayN();
        }
        if (this.dBr != null) {
            am.c(this.dBr, d.f.icon_tabbar_add_n);
            am.i(this.dBr, d.f.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mTabHost != null && this.dBq != null && this.dBq.isShowing()) {
                this.dBq.bFr();
                UtilHelper.setNavigationBarBackground(this.dBo, gg(true));
            } else if (this.dBp != null && this.dBp.isAdded()) {
                if (this.dBp.onKeyDown(i, keyEvent)) {
                    return true;
                }
                ayP();
            } else {
                return this.dBo.b(i, keyEvent);
            }
            return false;
        }
        return this.dBo.b(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayP() {
        if (this.dBx != this.dBv && this.mTabHost != null && !ayL()) {
            this.mTabHost.setCurrentTab(this.dBv);
            if (lm(this.dBv) != 1) {
                this.dBp.fz(false);
            }
            this.dBx = this.dBv;
            a(this.mTabHost.getCurrentFragment(), this.dBv);
            return;
        }
        this.dBp.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.mTabHost == null) {
            this.dBp.onActivityResult(i, i2, intent);
        } else if (99 == this.mTabHost.getCurrentTabType() || 1 == this.mTabHost.getCurrentTabType()) {
            this.dBp.onActivityResult(i, i2, intent);
        } else {
            this.mTabHost.getCurrentFragment().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.bmV().x(this.dBo.getPageContext());
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.dBy != null) {
                        this.dBy.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.c.6
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void Es() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.6.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (c.this.dBo != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(c.this.dBo.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.bmV().x(this.dBo.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.mTabHost == null) {
            return this.dBp.getVoiceManager();
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

    public void ayQ() {
        if (ba.aV(this.dBo) && !this.dBz.bzK() && !ayR()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            if (this.dBq == null) {
                this.dBq = new com.baidu.tieba.write.c(this.dBo.getPageContext(), this.bvn, "frs");
                this.dBq.vx("2");
            }
            this.dBq.a(this.dBp.auG());
            this.dBq.vk(gg(true));
            UtilHelper.setNavigationBarBackground(this.dBo, gg(false));
            this.dBq.np(false);
        }
    }

    public boolean ayR() {
        if (this.dBp != null && this.dBp.isAdded() && this.dBp.getPageContext() != null) {
            d.a(this.dBp.getPageContext(), this.dBp.auD());
        }
        return false;
    }

    private int ayS() {
        if (this.dBt == null) {
            return -1;
        }
        int y = w.y(this.dBt.avL());
        for (int i = 0; i < y; i++) {
            if (this.dBt.avL().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ll(int i) {
        if (this.dBt == null) {
            return -1;
        }
        int y = w.y(this.dBt.avL());
        for (int i2 = 0; i2 < y; i2++) {
            if (this.dBt.avL().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lm(int i) {
        if (this.dBt != null && i < w.y(this.dBt.avL())) {
            return this.dBt.avL().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment atL() {
        return this.dBp;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> atM() {
        if (this.mTabHost == null) {
            if (this.dBp instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.dBp).atM();
            }
        } else {
            Fragment currentFragment = this.mTabHost.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).atM();
            }
        }
        return null;
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.dBo.isLoadingViewAttached()) {
            this.dBo.hideLoadingView(this.dBo.findViewById(16908290));
        }
        if (this.dBG != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.dBG);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.dBw, false);
        if (this.dBy != null) {
            this.dBy.cancelLoadData();
        }
    }

    public FragmentTabHost ayT() {
        return this.mTabHost;
    }

    public void gh(boolean z) {
        if (this.dBr != null) {
            this.dBr.setVisibility(z ? 0 : 8);
        }
    }
}
