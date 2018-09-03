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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
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
    private FrameLayout bvp;
    private FrsActivity dBl;
    private FrsFragment dBm;
    private com.baidu.tieba.write.c dBn;
    private ImageView dBo;
    private i dBp;
    private ad dBq;
    private int dBu;
    private ShareSuccessReplyToServerModel dBv;
    private com.baidu.tieba.ueg.c dBw;
    private Pair<Integer, Integer> dmt;
    private String mForumName;
    private FragmentTabHost mTabHost;
    private boolean dBr = false;
    private final Handler mHandler = new Handler();
    private int dBs = 0;
    private boolean dBx = false;
    private com.baidu.adp.framework.listener.a dBy = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            i iVar = null;
            if (!c.this.dBr && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    iVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    iVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (iVar != null) {
                    c.this.dBr = true;
                    c.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dBz = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!c.this.dBr && c.this.dBp == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                i iVar = (i) customResponsedMessage.getData();
                if (iVar.aZg() != null && c.this.mForumName != null && c.this.mForumName.equals(iVar.aZg().getName())) {
                    c.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dBA = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.ayN();
        }
    };
    private CustomMessageListener dBB = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int lk;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (10001 == intValue) {
                    lk = c.this.lk(9);
                    if (lk == -1) {
                        lk = c.this.lk(2);
                    }
                } else {
                    lk = c.this.lk(intValue);
                }
                if (lk != -1 && c.this.mTabHost != null) {
                    c.this.mTabHost.setCurrentTab(lk);
                    if (c.this.lm(lk) != 1) {
                        c.this.dBm.fz(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener dBC = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.c.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!w.z(newNotifyData)) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < c.this.dBq.avK().size(); i++) {
                                FragmentTabHost.b cC = c.this.mTabHost.cC(i);
                                if (cC != null && cC.mType != 99 && cC.mType != 1 && cC.mType != c.this.mTabHost.getCurrentTabType() && cC.mType == aVar.getTabId() && aVar.ayB() && cC.anO.hl(String.valueOf(cC.mType)) != null) {
                                    cC.anO.hl(String.valueOf(cC.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener bxA = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.frs.gametab.c.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                c.this.dBx = true;
            }
        }
    };
    private Runnable dBD = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.12
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this);
            c.this.ayF();
            com.baidu.adp.lib.g.e.in().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                c.this.ayO();
                if (c.this.mTabHost != null) {
                    if (c.this.dBp != null && c.this.dBp.aZg() != null) {
                        str = c.this.dBp.aZg().getId();
                    }
                    c.this.a(c.this.mTabHost.cC(c.this.mTabHost.getCurrentTabIndex()), str);
                    c.this.mM(str);
                }
            }
        }
    };
    private String dBt = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    public c(FrsActivity frsActivity) {
        this.dBl = frsActivity;
    }

    public void init(Bundle bundle) {
        this.dBy.getHttpMessageListener().setPriority(-1);
        this.dBy.getSocketMessageListener().setPriority(-1);
        this.dBl.registerListener(this.dBz);
        this.dBB.setSelfListener(true);
        this.dBl.registerListener(this.dBB);
        this.dBA.setSelfListener(true);
        this.dBl.registerListener(this.dBA);
        this.dBl.registerListener(this.bxA);
        if (bundle == null) {
            this.mForumName = this.dBl.getIntent().getStringExtra("name");
            this.dBs = this.dBl.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.mForumName = bundle.getString("name");
            this.dBs = bundle.getInt("default_tab_id", 0);
        }
        k(bundle);
        this.dBv = new ShareSuccessReplyToServerModel();
        this.dBl.registerListener(this.dBy);
        this.dBw = new com.baidu.tieba.ueg.c(this.dBl.getPageContext());
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.dBs);
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
        if (this.dBm == null) {
            this.dBm = new FrsFragment();
            this.dBm.setArguments(bundle);
        }
        this.dBm.dmu = false;
        return this.dBm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(i iVar) {
        if (w.y(iVar.buJ()) > 0) {
            this.dBp = iVar;
            if (!this.dBl.isLoadingViewAttached() && this.mTabHost == null) {
                this.dBl.showLoadingView(this.dBl.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.13
                @Override // java.lang.Runnable
                public void run() {
                    c.this.bt(c.this.dBp.buJ());
                }
            });
        } else if (this.mTabHost != null) {
            this.bvp.removeView(this.mTabHost);
            this.mTabHost = null;
            this.dBq = null;
            if (this.dBo != null && this.dBo.getParent() != null) {
                ((ViewGroup) this.dBo.getParent()).removeView(this.dBo);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.14
                @Override // java.lang.Runnable
                public void run() {
                    c.this.ayC();
                    c.this.k(c.this.dBm != null ? c.this.dBm.getArguments() : null);
                    if (c.this.dBm instanceof NavigationBar.a) {
                        c.this.dBm.b((Pair<Integer, Integer>) null);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayC() {
        try {
            this.dBm.dmu = true;
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStackImmediate((String) null, 1);
            fragmentManager.beginTransaction().remove(this.dBm).commit();
            fragmentManager.executePendingTransactions();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private FragmentManager getFragmentManager() {
        if (this.dBl != null) {
            return this.dBl.getSupportFragmentManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(List<FrsTabInfo> list) {
        if (this.dBl.isLoadingViewAttached()) {
            this.dBl.hideLoadingView(this.dBl.findViewById(16908290));
        }
        if (this.mTabHost == null && ayC()) {
            ayD();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_game_login_tip", true)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_game_login_tip", false);
            }
            bu(list);
        }
    }

    private void ayD() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dBl.registerListener(1021074, this.dBC);
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
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(c.this.dBt, true)) {
                            com.baidu.adp.lib.g.e.in().post(c.this.dBD);
                        }
                        c.this.ayH();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.dBl.registerListener(customMessageListener);
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
            builder.tab_name = this.dBl.getResources().getString(f.j.send);
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
            this.dBq = new ad(this.dBl.getActivity(), list2);
            if (atK() != null) {
                this.dBq.setForumId(atK().getForumId());
                this.dBq.setForumName(atK().getForumName());
                if (atK().auC() != null && atK().auC().aZg() != null) {
                    ForumData aZg = atK().auC().aZg();
                    this.dBq.setForumGameLabel(aZg.getForumGameLabel());
                    this.dBq.mx(aZg.getSpecialForumType());
                }
            }
            this.dBm.dmu = false;
            new e(this.dBm).a(this.dBq);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.dBq);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.dBl.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    private void ayE() {
        int ayQ = ayQ();
        if (ayQ >= 0) {
            a(this.dBm, ayQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayF() {
        if (this.dBq != null && !TextUtils.isEmpty(this.dBq.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.dBp.aZg().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private FragmentTabHost.a ayG() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.gametab.c.3
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void onTabSelectionChanged(int i, boolean z) {
                c.this.a(c.this.mTabHost.getCurrentFragment(), i);
                if (c.this.lm(i) != 1) {
                    c.this.dBm.fz(false);
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r4v15, resolved type: com.baidu.tieba.frs.FrsActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean onPreTabSelectionChange(int i, boolean z) {
                String str = null;
                FrsTabInfo ll = c.this.ll(i);
                if (ll == null || ll.tab_type.intValue() != 11) {
                    FragmentTabHost.b cC = c.this.mTabHost.cC(i);
                    if (c.this.dBp != null && c.this.dBp.aZg() != null) {
                        str = c.this.dBp.aZg().getId();
                    }
                    c.this.a(cC, str);
                    if (cC.mType == 99) {
                        c.this.ayO();
                        c.this.mM(str);
                        return false;
                    } else if (cC.mType == 5 && !TbadkCoreApplication.isLogin()) {
                        bb.aT(c.this.dBl.getPageContext().getPageActivity());
                        return false;
                    } else {
                        if (cC.anO != null) {
                            cC.anO.Jp();
                        }
                        if (cC.anO.hl(String.valueOf(cC.mType)) != null) {
                            if (!(cC.anO.hl(String.valueOf(cC.mType)).view.getVisibility() == 0)) {
                                if (c.this.dBu == i) {
                                    c.this.b(cC);
                                }
                            } else {
                                cC.anO.hl(String.valueOf(cC.mType)).view.setVisibility(8);
                                c.this.b(cC);
                            }
                        }
                        c.this.dBu = i;
                        return true;
                    }
                }
                az.zI().a(c.this.dBl.getPageContext(), new String[]{ll.tab_url}, true);
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mM(String str) {
        if (!ayK() && this.mTabHost != null) {
            TiebaStatic.log(new an("c12342").r("obj_locate", c(this.mTabHost.cC(this.mTabHost.getCurrentTabIndex()))).ae(ImageViewerConfig.FORUM_ID, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FragmentTabHost.b bVar, String str) {
        if (ayK()) {
            com.baidu.tieba.frs.worldcup.c.b(bVar, str);
        } else {
            TiebaStatic.log(new an("c12334").r("obj_locate", c(bVar)).ae(ImageViewerConfig.FORUM_ID, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayH() {
        List<TabSkin> list;
        TabSkin tabSkin;
        if (this.dBq != null) {
            this.dBq.avL();
            if (!w.z(this.dBq.atW())) {
                ayE();
                if (this.mTabHost == null) {
                    this.mTabHost = new FragmentTabHost(this.dBl.getActivity());
                    this.mTabHost.setClipChildren(false);
                    this.mTabHost.setClipToPadding(false);
                    this.mTabHost.setup(this.dBl.getSupportFragmentManager());
                    this.mTabHost.getFragmentTabWidget().setAbsoluteWeight(true);
                    this.bvp = new FrameLayout(this.dBl.getActivity());
                    this.bvp.setClipChildren(false);
                    this.bvp.setClipToPadding(false);
                    this.bvp.addView(this.mTabHost);
                    this.dBl.setContentView(this.bvp);
                    this.mTabHost.setOnTabSelectionListener(ayG());
                } else {
                    this.mTabHost.reset();
                }
                List<com.baidu.tbadk.mainTab.b> atW = this.dBq.atW();
                List<FrsTabInfo> avK = this.dBq.avK();
                this.dmt = null;
                if (this.dBp != null && this.dBp.buP() != null) {
                    WorldcupSkin buP = this.dBp.buP();
                    List<TabSkin> list2 = buP.tab_skin;
                    this.dmt = new Pair<>(Integer.valueOf(com.baidu.tieba.frs.worldcup.b.nh(buP.worldcup_top)), Integer.valueOf(com.baidu.tieba.frs.worldcup.b.nh(buP.worldcup_top_night)));
                    int f = l.f(this.dBl.getActivity(), f.e.ds10);
                    this.mTabHost.setTabWidgetViewPadding(0, f, 0, f);
                    this.mTabHost.setTabWidgetViewHeight(l.f(this.dBl.getActivity(), f.e.tbds188));
                    this.mTabHost.setNeedShowThemeStyle(false);
                    this.mTabHost.setShouldDrawDividerLine(false);
                    this.mTabHost.setShouldDrawIndicatorLine(false);
                    this.mTabHost.setShouldDrawTopLine(false);
                    this.mTabHost.aG(false);
                    list = list2;
                } else {
                    this.mTabHost.setTabWidgetViewPadding(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds10), 0, 0);
                    this.mTabHost.aH(true);
                    this.mTabHost.setShouldDrawDividerLine(false);
                    this.mTabHost.setShouldDrawIndicatorLine(false);
                    this.mTabHost.setShouldDrawTopLine(false);
                    this.mTabHost.aG(false);
                    this.mTabHost.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    list = null;
                }
                if (avK.size() == atW.size()) {
                    int size = avK.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = atW.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = avK.get(i);
                            if (list != null) {
                                tabSkin = com.baidu.tieba.frs.worldcup.b.j(list, frsTabInfo.tab_id.intValue());
                                Fragment fragment = bVar.Jo().aRI;
                                if (fragment != null && (fragment instanceof NavigationBar.a)) {
                                    ((NavigationBar.a) fragment).b(this.dmt);
                                }
                            } else {
                                tabSkin = null;
                            }
                            a(bVar, bVar.Jo(), bVar.bd(this.dBl.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "", tabSkin);
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : atW) {
                        a(bVar2, bVar2.Jo(), bVar2.bd(this.dBl.getActivity()), null, null);
                    }
                }
                this.mTabHost.cA(2);
                this.mTabHost.setViewPagerScrollable(false);
                int lk = lk(this.dBs);
                if (lk < 0) {
                    lk = lk(this.dBp.buK());
                }
                if (lk < 0) {
                    lk = ayQ();
                }
                if (lk < 0) {
                    lk = 0;
                }
                this.dBs = lk;
                this.dBu = lk;
                this.mTabHost.setCurrentTab(lk);
                if (lm(lk) != 1) {
                    this.dBm.fz(false);
                }
                lj(lk);
                if (!ayI()) {
                    ayM();
                }
                this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                ayL();
            }
        }
    }

    private void lj(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.4
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (c.this.mTabHost != null) {
                    c.this.a(c.this.mTabHost.getCurrentFragment(), i);
                    if (c.this.dBp != null && c.this.dBp.aZg() != null) {
                        str = c.this.dBp.aZg().getId();
                    }
                    c.this.a(c.this.mTabHost.cC(c.this.mTabHost.getCurrentTabIndex()), str);
                }
            }
        });
    }

    private int gg(boolean z) {
        if (z && this.dmt != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                return ((Integer) this.dmt.second).intValue();
            }
            return ((Integer) this.dmt.first).intValue();
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            return this.dBl.getResources().getColor(f.d.cp_bg_line_d_1);
        } else {
            return this.dBl.getResources().getColor(f.d.cp_bg_line_d);
        }
    }

    private boolean ayI() {
        return (this.dBp == null || this.dBp.buP() == null) ? false : true;
    }

    private boolean ayJ() {
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

    private boolean ayK() {
        if (this.dBp == null || this.dBp.aZg() == null) {
            return false;
        }
        return "worldcup".equals(this.dBp.aZg().getSpecialForumType());
    }

    private void ayL() {
        if (this.dBp != null && this.dBp.buP() != null && this.mTabHost != null) {
            WorldcupSkin buP = this.dBp.buP();
            this.mTabHost.setTabWidgetBackgroundImageUrl(new Pair<>(buP.worldcup_bottom, buP.worldcup_bottom_night));
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

    private void ayM() {
        if (this.mTabHost != null && this.mTabHost.cD(99) != null) {
            if (this.dBo == null || this.dBo.getParent() == null) {
                if (this.dBo == null) {
                    this.dBo = new ImageView(this.dBl.getActivity());
                }
                int f = l.f(this.dBl.getActivity(), f.e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f, f);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = l.f(this.dBl.getActivity(), f.e.ds5);
                this.dBo.setLayoutParams(layoutParams);
                am.c(this.dBo, f.C0146f.icon_tabbar_add_n);
                am.i(this.dBo, f.C0146f.icon_tabbar_chaticon_n);
                this.dBo.setOnClickListener(this.mOnClickListener);
                if (this.dBo.getParent() == null && this.bvp != null) {
                    this.bvp.addView(this.dBo);
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
        NavigationBar Vj;
        if ((fragment instanceof ak) && this.dBp != null && this.dBp.aZg() != null && (Vj = ((ak) fragment).Vj()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dBp.aZg().getName(), 5, true, true) + this.dBl.getActivity().getString(f.j.forum));
            Vj.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str, TabSkin tabSkin) {
        boolean z = true;
        if (cVar != null && this.dBp != null && this.dBp.aZg() != null) {
            ForumData aZg = this.dBp.aZg();
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mType = cVar.type;
            bVar2.anP = cVar.aRI;
            if (bVar2.anP.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", aZg.getName());
                bundle.putString("from", aZg.getSpecialForumType());
                bundle.putString(ImageViewerConfig.FORUM_ID, aZg.getId());
                bundle.putString(ImageViewerConfig.FORUM_NAME, aZg.getName());
                bundle.putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
                bVar2.anP.setArguments(bundle);
            } else {
                bVar2.anP.getArguments().putString(ImageViewerConfig.FORUM_ID, aZg.getId());
                bVar2.anP.getArguments().putString(ImageViewerConfig.FORUM_NAME, aZg.getName());
                bVar2.anP.getArguments().putBoolean(FrsActivityConfig.FRS_CREATE_WITH_GAME, true);
            }
            if (tabSkin != null) {
                tbFragmentTabIndicator.setAnimationResId(f.a.frs_tab_indicator_anim);
                tbFragmentTabIndicator.setContentTvTopMargin(l.f(this.dBl, f.e.tbds8));
                tbFragmentTabIndicator.setTextColorResId(f.d.skin_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, l.f(this.dBl.getActivity(), f.e.fontsize26));
                tbFragmentTabIndicator.ap(tabSkin.icon, tabSkin.icon_night);
                if (cVar.aRQ == com.baidu.tbadk.mainTab.c.aRM && cVar.type == 99) {
                    int f = l.f(this.dBl, f.e.tbds144);
                    tbFragmentTabIndicator.setIconResourceId(f.C0146f.icon_frs_worldcup_morenc_n);
                    tbFragmentTabIndicator.setIconViewWithoutText(f, l.f(this.dBl.getActivity(), f.e.tbds8));
                } else {
                    int f2 = l.f(this.dBl, f.e.tbds114);
                    tbFragmentTabIndicator.setIconResourceId(f.C0146f.icon_frs_worldcup_moren_n);
                    tbFragmentTabIndicator.setIconViewWithText(f2, 0);
                }
            } else {
                tbFragmentTabIndicator.setContentTvTopMargin(l.f(this.dBl, f.e.tbds2));
                tbFragmentTabIndicator.setIconResourceId(cVar.aRK);
                tbFragmentTabIndicator.setTextColorResId(f.d.s_game_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, l.f(this.dBl.getActivity(), f.e.fontsize30));
                if (cVar.aRQ == com.baidu.tbadk.mainTab.c.aRM && cVar.type == 99) {
                    tbFragmentTabIndicator.setIconViewWithoutText(l.f(this.dBl, f.e.ds96), l.f(this.dBl.getActivity(), f.e.tbds12));
                }
            }
            if (!TextUtils.isEmpty(str)) {
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.aRJ);
            }
            tbFragmentTabIndicator.dF(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(false);
            if (cVar.aRQ != com.baidu.tbadk.mainTab.c.aRM || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.anO = tbFragmentTabIndicator;
            bVar2.anQ = bVar;
            this.mTabHost.a(bVar2);
        }
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.dBl.getResources().getDimensionPixelSize(f.e.ds12);
        ImageView imageView = new ImageView(this.dBl);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(f.C0146f.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.dBl.getResources().getDimensionPixelSize(f.e.ds12));
        aVar.aSf = fragmentTabIndicator;
        aVar.yX = this.dBl.getResources().getDimensionPixelSize(f.e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dBm instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dBm.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gh(int i) {
        if (this.dBm instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dBm.gh(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dBm instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dBm.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.dBm != null) {
            this.dBm.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.mTabHost == null) {
            this.dBm.setPrimary(true);
        } else {
            Fragment currentFragment = this.mTabHost.getCurrentFragment();
            if (currentFragment instanceof BaseFragment) {
                ((BaseFragment) currentFragment).setPrimary(true);
            }
        }
        if (this.dBx) {
            this.dBx = false;
            if (this.dBm != null) {
                this.dBm.refresh();
            }
        }
    }

    public void onPause() {
        if (this.mTabHost == null) {
            this.dBm.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.mTabHost.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mTabHost == null) {
            this.dBm.onChangeSkinType(i);
        } else {
            this.mTabHost.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            ayL();
        }
        if (this.dBo != null) {
            am.c(this.dBo, f.C0146f.icon_tabbar_add_n);
            am.i(this.dBo, f.C0146f.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.mTabHost != null && this.dBn != null && this.dBn.isShowing()) {
                this.dBn.bFv();
                UtilHelper.setNavigationBarBackground(this.dBl, gg(true));
            } else if (this.dBm != null && this.dBm.isAdded()) {
                if (this.dBm.onKeyDown(i, keyEvent)) {
                    return true;
                }
                ayN();
            } else {
                return this.dBl.b(i, keyEvent);
            }
            return false;
        }
        return this.dBl.b(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayN() {
        if (this.dBu != this.dBs && this.mTabHost != null && !ayJ()) {
            this.mTabHost.setCurrentTab(this.dBs);
            if (lm(this.dBs) != 1) {
                this.dBm.fz(false);
            }
            this.dBu = this.dBs;
            a(this.mTabHost.getCurrentFragment(), this.dBs);
            return;
        }
        this.dBm.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.mTabHost == null) {
            this.dBm.onActivityResult(i, i2, intent);
        } else if (99 == this.mTabHost.getCurrentTabType() || 1 == this.mTabHost.getCurrentTabType()) {
            this.dBm.onActivityResult(i, i2, intent);
        } else {
            this.mTabHost.getCurrentFragment().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.bmW().x(this.dBl.getPageContext());
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.dBv != null) {
                        this.dBv.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.c.6
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void Es() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.6.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (c.this.dBl != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(c.this.dBl.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.bmW().x(this.dBl.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.mTabHost == null) {
            return this.dBm.getVoiceManager();
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

    public void ayO() {
        if (bb.aU(this.dBl) && !this.dBw.bzM() && !ayP()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            if (this.dBn == null) {
                this.dBn = new com.baidu.tieba.write.c(this.dBl.getPageContext(), this.bvp, "frs");
                this.dBn.vB("2");
            }
            this.dBn.a(this.dBm.auF());
            this.dBn.vk(gg(true));
            UtilHelper.setNavigationBarBackground(this.dBl, gg(false));
            this.dBn.np(false);
        }
    }

    public boolean ayP() {
        if (this.dBm != null && this.dBm.isAdded() && this.dBm.getPageContext() != null) {
            d.a(this.dBm.getPageContext(), this.dBm.auC());
        }
        return false;
    }

    private int ayQ() {
        if (this.dBq == null) {
            return -1;
        }
        int y = w.y(this.dBq.avK());
        for (int i = 0; i < y; i++) {
            if (this.dBq.avK().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lk(int i) {
        if (this.dBq == null) {
            return -1;
        }
        int y = w.y(this.dBq.avK());
        for (int i2 = 0; i2 < y; i2++) {
            if (this.dBq.avK().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrsTabInfo ll(int i) {
        if (this.dBq == null || i >= w.y(this.dBq.avK())) {
            return null;
        }
        return this.dBq.avK().get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int lm(int i) {
        if (this.dBq != null && i < w.y(this.dBq.avK())) {
            return this.dBq.avK().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment atK() {
        return this.dBm;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> atL() {
        if (this.mTabHost == null) {
            if (this.dBm instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.dBm).atL();
            }
        } else {
            Fragment currentFragment = this.mTabHost.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).atL();
            }
        }
        return null;
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.dBl.isLoadingViewAttached()) {
            this.dBl.hideLoadingView(this.dBl.findViewById(16908290));
        }
        if (this.dBD != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.dBD);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.dBt, false);
        if (this.dBv != null) {
            this.dBv.cancelLoadData();
        }
    }

    public FragmentTabHost ayR() {
        return this.mTabHost;
    }

    public void gh(boolean z) {
        if (this.dBo != null) {
            this.dBo.setVisibility(z ? 0 : 8);
        }
    }
}
