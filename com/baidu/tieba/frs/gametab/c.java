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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.g;
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
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.ai;
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
    private FragmentTabHost aoi;
    private FrameLayout btg;
    private Pair<Integer, Integer> dhH;
    private int dvC;
    private ShareSuccessReplyToServerModel dvD;
    private com.baidu.tieba.s.b dvE;
    private FrsActivity dvt;
    private FrsFragment dvu;
    private com.baidu.tieba.write.c dvv;
    private ImageView dvw;
    private i dvx;
    private ab dvy;
    private String mForumName;
    private boolean dvz = false;
    private final Handler mHandler = new Handler();
    private int dvA = 0;
    private com.baidu.adp.framework.listener.a dvF = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_HTTP_CMD, 301001) { // from class: com.baidu.tieba.frs.gametab.c.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            i iVar = null;
            if (!c.this.dvz && !responsedMessage.hasError()) {
                if (responsedMessage instanceof FrsPageHttpResponseMessage) {
                    iVar = ((FrsPageHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof FRSPageSocketResponsedMessage) {
                    iVar = ((FRSPageSocketResponsedMessage) responsedMessage).getResponseData();
                }
                if (iVar != null) {
                    c.this.dvz = true;
                    c.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dvG = new CustomMessageListener(2001615) { // from class: com.baidu.tieba.frs.gametab.c.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!c.this.dvz && c.this.dvx == null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                i iVar = (i) customResponsedMessage.getData();
                if (iVar.bam() != null && c.this.mForumName != null && c.this.mForumName.equals(iVar.bam().getName())) {
                    c.this.c(iVar);
                }
            }
        }
    };
    private CustomMessageListener dvH = new CustomMessageListener(2921342) { // from class: com.baidu.tieba.frs.gametab.c.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.axG();
        }
    };
    private CustomMessageListener dvI = new CustomMessageListener(2001627) { // from class: com.baidu.tieba.frs.gametab.c.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
                int kT = c.this.kT(((Integer) customResponsedMessage.getData()).intValue());
                if (kT != -1 && c.this.aoi != null) {
                    c.this.aoi.setCurrentTab(kT);
                    if (c.this.kU(kT) != 1) {
                        c.this.dvu.fv(false);
                    }
                }
            }
        }
    };
    private HttpMessageListener dvJ = new HttpMessageListener(0) { // from class: com.baidu.tieba.frs.gametab.c.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && 1021074 == httpResponsedMessage.getCmd() && (httpResponsedMessage instanceof AlaGameTabGetNewNotifyResponsedMessage)) {
                List<a> newNotifyData = ((AlaGameTabGetNewNotifyResponsedMessage) httpResponsedMessage).getNewNotifyData();
                if (!w.z(newNotifyData)) {
                    for (a aVar : newNotifyData) {
                        if (aVar != null) {
                            for (int i = 0; i < c.this.dvy.auM().size(); i++) {
                                FragmentTabHost.b cz = c.this.aoi.cz(i);
                                if (cz != null && cz.mType != 99 && cz.mType != 1 && cz.mType != c.this.aoi.getCurrentTabType() && cz.mType == aVar.getTabId() && aVar.axu() && cz.anM.hk(String.valueOf(cz.mType)) != null) {
                                    cz.anM.hk(String.valueOf(cz.mType)).view.setVisibility(0);
                                }
                            }
                        }
                    }
                }
            }
        }
    };
    private Runnable dvK = new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.10
        @Override // java.lang.Runnable
        public void run() {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this);
            c.this.axy();
            com.baidu.adp.lib.g.e.im().postDelayed(this, StatisticConfig.MIN_UPLOAD_INTERVAL);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.gametab.c.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = null;
            if (view != null) {
                c.this.axH();
                if (c.this.aoi != null) {
                    if (c.this.dvx != null && c.this.dvx.bam() != null) {
                        str = c.this.dvx.bam().getId();
                    }
                    c.this.a(c.this.aoi.cz(c.this.aoi.getCurrentTabIndex()), str);
                    c.this.mL(str);
                }
            }
        }
    };
    private String dvB = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("show_game_forem_tab_hot_point");

    public c(FrsActivity frsActivity) {
        this.dvt = frsActivity;
    }

    public void init(Bundle bundle) {
        this.dvF.getHttpMessageListener().setPriority(-1);
        this.dvF.getSocketMessageListener().setPriority(-1);
        this.dvt.registerListener(this.dvG);
        this.dvI.setSelfListener(true);
        this.dvt.registerListener(this.dvI);
        this.dvH.setSelfListener(true);
        this.dvt.registerListener(this.dvH);
        if (bundle == null) {
            this.mForumName = this.dvt.getIntent().getStringExtra("name");
            this.dvA = this.dvt.getIntent().getIntExtra(FrsActivityConfig.FRS_GAME_DEFAULT_TAB_ID, 0);
        } else {
            this.mForumName = bundle.getString("name");
            this.dvA = bundle.getInt("default_tab_id", 0);
        }
        k(bundle);
        this.dvD = new ShareSuccessReplyToServerModel();
        this.dvt.registerListener(this.dvF);
        this.dvE = new com.baidu.tieba.s.b(this.dvt.getPageContext());
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("name", this.mForumName);
        bundle.putInt("default_tab_id", this.dvA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed() && ((FrsFragment) fragmentManager.findFragmentByTag("frsFragment")) == null) {
            fragmentManager.beginTransaction().add(16908290, l(bundle), "frsFragment").commitAllowingStateLoss();
        }
    }

    private FrsFragment l(Bundle bundle) {
        if (this.dvu == null) {
            this.dvu = new FrsFragment();
            this.dvu.setArguments(bundle);
        }
        this.dvu.dhI = false;
        return this.dvu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(i iVar) {
        if (w.y(iVar.bvE()) > 0) {
            this.dvx = iVar;
            if (!this.dvt.isLoadingViewAttached() && this.aoi == null) {
                this.dvt.showLoadingView(this.dvt.findViewById(16908290));
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.11
                @Override // java.lang.Runnable
                public void run() {
                    c.this.br(c.this.dvx.bvE());
                }
            });
        } else if (this.aoi != null) {
            this.btg.removeView(this.aoi);
            this.aoi = null;
            this.dvy = null;
            if (this.dvw != null && this.dvw.getParent() != null) {
                ((ViewGroup) this.dvw.getParent()).removeView(this.dvw);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.12
                @Override // java.lang.Runnable
                public void run() {
                    c.this.axv();
                    c.this.k(c.this.dvu != null ? c.this.dvu.getArguments() : null);
                    if (c.this.dvu instanceof NavigationBar.a) {
                        c.this.dvu.b((Pair<Integer, Integer>) null);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axv() {
        try {
            this.dvu.dhI = true;
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStackImmediate((String) null, 1);
            fragmentManager.beginTransaction().remove(this.dvu).commit();
            fragmentManager.executePendingTransactions();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private FragmentManager getFragmentManager() {
        if (this.dvt != null) {
            return this.dvt.getSupportFragmentManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(List<FrsTabInfo> list) {
        if (this.dvt.isLoadingViewAttached()) {
            this.dvt.hideLoadingView(this.dvt.findViewById(16908290));
        }
        if (this.aoi == null && axv()) {
            axw();
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("frs_game_login_tip", true)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_login_tip", true);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_game_login_tip", false);
            }
            bs(list);
        }
    }

    private void axw() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021074, TbConfig.SERVER_ADDRESS + "game/forum/getNewNotify");
        tbHttpMessageTask.setResponsedClass(AlaGameTabGetNewNotifyResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.dvt.registerListener(1021074, this.dvJ);
    }

    private void bs(List<FrsTabInfo> list) {
        List list2;
        boolean z;
        if (!w.z(list)) {
            CustomMessageListener customMessageListener = new CustomMessageListener(2001616) { // from class: com.baidu.tieba.frs.gametab.c.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab)) {
                        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean(c.this.dvB, true)) {
                            com.baidu.adp.lib.g.e.im().post(c.this.dvK);
                        }
                        c.this.axA();
                    }
                }
            };
            customMessageListener.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            customMessageListener.setSelfListener(true);
            this.dvt.registerListener(customMessageListener);
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
            builder.tab_name = this.dvt.getResources().getString(d.k.send);
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
            this.dvy = new ab(this.dvt.getActivity(), list2);
            if (asQ() != null) {
                this.dvy.setForumId(asQ().getForumId());
                this.dvy.setForumName(asQ().getForumName());
                if (asQ().atI() != null && asQ().atI().bam() != null) {
                    ForumData bam = asQ().atI().bam();
                    this.dvy.setForumGameLabel(bam.getForumGameLabel());
                    this.dvy.mw(bam.getSpecialForumType());
                }
            }
            this.dvu.dhI = false;
            new e(this.dvu).a(this.dvy);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001616, this.dvy);
            CustomMessage customMessage = new CustomMessage(2001616);
            customMessage.setTag(this.dvt.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    private void axx() {
        int axJ = axJ();
        if (axJ >= 0) {
            a(this.dvu, axJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axy() {
        if (this.dvy != null && !TextUtils.isEmpty(this.dvy.getForumId())) {
            HttpMessage httpMessage = new HttpMessage(1021074);
            httpMessage.addParam("forum_id", this.dvx.bam().getId());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    private FragmentTabHost.a axz() {
        return new FragmentTabHost.a() { // from class: com.baidu.tieba.frs.gametab.c.2
            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public void i(int i, boolean z) {
                c.this.a(c.this.aoi.getCurrentFragment(), i);
                if (c.this.kU(i) != 1) {
                    c.this.dvu.fv(false);
                }
            }

            @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
            public boolean j(int i, boolean z) {
                String str = null;
                FragmentTabHost.b cz = c.this.aoi.cz(i);
                if (c.this.dvx != null && c.this.dvx.bam() != null) {
                    str = c.this.dvx.bam().getId();
                }
                c.this.a(cz, str);
                if (cz.mType == 99) {
                    c.this.axH();
                    c.this.mL(str);
                    return false;
                } else if (cz.mType == 5 && !TbadkCoreApplication.isLogin()) {
                    ba.aT(c.this.dvt.getPageContext().getPageActivity());
                    return false;
                } else {
                    if (cz.anM != null) {
                        cz.anM.Jc();
                    }
                    if (cz.anM.hk(String.valueOf(cz.mType)) != null) {
                        if (!(cz.anM.hk(String.valueOf(cz.mType)).view.getVisibility() == 0)) {
                            if (c.this.dvC == i) {
                                c.this.b(cz);
                            }
                        } else {
                            cz.anM.hk(String.valueOf(cz.mType)).view.setVisibility(8);
                            c.this.b(cz);
                        }
                    }
                    c.this.dvC = i;
                    return true;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mL(String str) {
        if (!axD() && this.aoi != null) {
            TiebaStatic.log(new am("c12342").r("obj_locate", c(this.aoi.cz(this.aoi.getCurrentTabIndex()))).ah(ImageViewerConfig.FORUM_ID, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FragmentTabHost.b bVar, String str) {
        if (axD()) {
            com.baidu.tieba.frs.worldcup.c.b(bVar, str);
        } else {
            TiebaStatic.log(new am("c12334").r("obj_locate", c(bVar)).ah(ImageViewerConfig.FORUM_ID, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axA() {
        List<TabSkin> list;
        TabSkin tabSkin;
        if (this.dvy != null) {
            this.dvy.auN();
            if (!w.z(this.dvy.atc())) {
                axx();
                if (this.aoi == null) {
                    this.aoi = new FragmentTabHost(this.dvt.getActivity());
                    this.aoi.setClipChildren(false);
                    this.aoi.setClipToPadding(false);
                    this.aoi.setup(this.dvt.getSupportFragmentManager());
                    this.aoi.getFragmentTabWidget().setAbsoluteWeight(true);
                    this.btg = new FrameLayout(this.dvt.getActivity());
                    this.btg.setClipChildren(false);
                    this.btg.setClipToPadding(false);
                    this.btg.addView(this.aoi);
                    this.dvt.setContentView(this.btg);
                    this.aoi.setOnTabSelectionListener(axz());
                } else {
                    this.aoi.reset();
                }
                List<com.baidu.tbadk.mainTab.b> atc = this.dvy.atc();
                List<FrsTabInfo> auM = this.dvy.auM();
                this.dhH = null;
                if (this.dvx != null && this.dvx.bvK() != null) {
                    WorldcupSkin bvK = this.dvx.bvK();
                    List<TabSkin> list2 = bvK.tab_skin;
                    this.dhH = new Pair<>(Integer.valueOf(com.baidu.tieba.frs.worldcup.b.nf(bvK.worldcup_top)), Integer.valueOf(com.baidu.tieba.frs.worldcup.b.nf(bvK.worldcup_top_night)));
                    int e = l.e(this.dvt.getActivity(), d.e.ds10);
                    this.aoi.setTabWidgetViewPadding(0, e, 0, e);
                    this.aoi.setTabWidgetViewHeight(l.e(this.dvt.getActivity(), d.e.tbds188));
                    this.aoi.setNeedShowThemeStyle(false);
                    this.aoi.setShouldDrawDividerLine(false);
                    this.aoi.setShouldDrawIndicatorLine(false);
                    this.aoi.setShouldDrawTopLine(false);
                    this.aoi.aF(false);
                    list = list2;
                } else {
                    this.aoi.setTabWidgetViewPadding(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds10), 0, 0);
                    this.aoi.aG(true);
                    this.aoi.setShouldDrawDividerLine(false);
                    this.aoi.setShouldDrawIndicatorLine(false);
                    this.aoi.setShouldDrawTopLine(true);
                    this.aoi.aF(true);
                    this.aoi.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    list = null;
                }
                if (auM.size() == atc.size()) {
                    int size = auM.size();
                    for (int i = 0; i < size; i++) {
                        com.baidu.tbadk.mainTab.b bVar = atc.get(i);
                        if (bVar != null) {
                            FrsTabInfo frsTabInfo = auM.get(i);
                            if (list != null) {
                                tabSkin = com.baidu.tieba.frs.worldcup.b.i(list, frsTabInfo.tab_id.intValue());
                                Fragment fragment = bVar.Jb().aQP;
                                if (fragment != null && (fragment instanceof NavigationBar.a)) {
                                    ((NavigationBar.a) fragment).b(this.dhH);
                                }
                            } else {
                                tabSkin = null;
                            }
                            a(bVar, bVar.Jb(), bVar.bd(this.dvt.getActivity()), frsTabInfo != null ? frsTabInfo.tab_name : "", tabSkin);
                        }
                    }
                } else {
                    for (com.baidu.tbadk.mainTab.b bVar2 : atc) {
                        a(bVar2, bVar2.Jb(), bVar2.bd(this.dvt.getActivity()), null, null);
                    }
                }
                this.aoi.cx(2);
                this.aoi.setViewPagerScrollable(false);
                int kT = kT(this.dvA);
                if (kT < 0) {
                    kT = kT(this.dvx.bvF());
                }
                if (kT < 0) {
                    kT = axJ();
                }
                if (kT < 0) {
                    kT = 0;
                }
                this.dvA = kT;
                this.dvC = kT;
                this.aoi.setCurrentTab(kT);
                if (kU(kT) != 1) {
                    this.dvu.fv(false);
                }
                kS(kT);
                if (!axB()) {
                    axF();
                }
                this.aoi.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                axE();
            }
        }
    }

    private void kS(final int i) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.3
            @Override // java.lang.Runnable
            public void run() {
                String str = null;
                if (c.this.aoi != null) {
                    c.this.a(c.this.aoi.getCurrentFragment(), i);
                    if (c.this.dvx != null && c.this.dvx.bam() != null) {
                        str = c.this.dvx.bam().getId();
                    }
                    c.this.a(c.this.aoi.cz(c.this.aoi.getCurrentTabIndex()), str);
                }
            }
        });
    }

    private int fW(boolean z) {
        if (z && this.dhH != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                return ((Integer) this.dhH.second).intValue();
            }
            return ((Integer) this.dhH.first).intValue();
        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            return this.dvt.getResources().getColor(d.C0141d.cp_bg_line_d_1);
        } else {
            return this.dvt.getResources().getColor(d.C0141d.cp_bg_line_d);
        }
    }

    private boolean axB() {
        return (this.dvx == null || this.dvx.bvK() == null) ? false : true;
    }

    private boolean axC() {
        if (this.aoi == null) {
            return false;
        }
        switch (this.aoi.getCurrentTabType()) {
            case 12:
            case 102:
            case 103:
                return true;
            default:
                return false;
        }
    }

    private boolean axD() {
        if (this.dvx == null || this.dvx.bam() == null) {
            return false;
        }
        return "worldcup".equals(this.dvx.bam().getSpecialForumType());
    }

    private void axE() {
        if (this.dvx != null && this.dvx.bvK() != null && this.aoi != null) {
            WorldcupSkin bvK = this.dvx.bvK();
            this.aoi.setTabWidgetBackgroundImageUrl(new Pair<>(bvK.worldcup_bottom, bvK.worldcup_bottom_night));
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

    private void axF() {
        if (this.aoi != null && this.aoi.cA(99) != null) {
            if (this.dvw == null || this.dvw.getParent() == null) {
                if (this.dvw == null) {
                    this.dvw = new ImageView(this.dvt.getActivity());
                }
                int e = l.e(this.dvt.getActivity(), d.e.ds80);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(e, e);
                layoutParams.gravity = 81;
                layoutParams.bottomMargin = l.e(this.dvt.getActivity(), d.e.ds5);
                this.dvw.setLayoutParams(layoutParams);
                al.c(this.dvw, d.f.icon_tabbar_add_n);
                al.i(this.dvw, d.f.icon_tabbar_chaticon_n);
                this.dvw.setOnClickListener(this.mOnClickListener);
                if (this.dvw.getParent() == null && this.btg != null) {
                    this.btg.addView(this.dvw);
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
        NavigationBar UB;
        if ((fragment instanceof ai) && this.dvx != null && this.dvx.bam() != null && (UB = ((ai) fragment).UB()) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.dvx.bam().getName(), 5, true, true) + this.dvt.getActivity().getString(d.k.forum));
            UB.setCenterTextTitle(sb.toString());
        }
    }

    private void a(com.baidu.tbadk.mainTab.b bVar, com.baidu.tbadk.mainTab.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator, String str, TabSkin tabSkin) {
        boolean z = true;
        if (cVar != null && this.dvx != null && this.dvx.bam() != null) {
            ForumData bam = this.dvx.bam();
            FragmentTabHost.b bVar2 = new FragmentTabHost.b();
            bVar2.mType = cVar.type;
            bVar2.anN = cVar.aQP;
            if (bVar2.anN.getArguments() == null) {
                Bundle bundle = new Bundle();
                bundle.putString("name", bam.getName());
                bundle.putString("from", bam.getSpecialForumType());
                bundle.putString(ImageViewerConfig.FORUM_ID, bam.getId());
                bundle.putString(ImageViewerConfig.FORUM_NAME, bam.getName());
                bVar2.anN.setArguments(bundle);
            } else {
                bVar2.anN.getArguments().putString(ImageViewerConfig.FORUM_ID, bam.getId());
                bVar2.anN.getArguments().putString(ImageViewerConfig.FORUM_NAME, bam.getName());
            }
            if (tabSkin != null) {
                tbFragmentTabIndicator.setAnimationResId(d.a.frs_tab_indicator_anim);
                tbFragmentTabIndicator.setContentTvTopMargin(l.e(this.dvt, d.e.tbds8));
                tbFragmentTabIndicator.setTextColorResId(d.C0141d.skin_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, l.e(this.dvt.getActivity(), d.e.fontsize26));
                tbFragmentTabIndicator.au(tabSkin.icon, tabSkin.icon_night);
                if (cVar.aQW == com.baidu.tbadk.mainTab.c.aQT && cVar.type == 99) {
                    int e = l.e(this.dvt, d.e.tbds144);
                    tbFragmentTabIndicator.setIconResourceId(d.f.icon_frs_worldcup_morenc_n);
                    tbFragmentTabIndicator.setIconViewWithoutText(e, l.e(this.dvt.getActivity(), d.e.tbds8));
                } else {
                    int e2 = l.e(this.dvt, d.e.tbds114);
                    tbFragmentTabIndicator.setIconResourceId(d.f.icon_frs_worldcup_moren_n);
                    tbFragmentTabIndicator.setIconViewWithText(e2, 0);
                }
            } else {
                tbFragmentTabIndicator.setContentTvTopMargin(l.e(this.dvt, d.e.tbds2));
                tbFragmentTabIndicator.setIconResourceId(cVar.aQR);
                tbFragmentTabIndicator.setTextColorResId(d.C0141d.s_game_frs_tabbar_text_color);
                tbFragmentTabIndicator.setTextSize(0, l.e(this.dvt.getActivity(), d.e.fontsize30));
                if (cVar.aQW == com.baidu.tbadk.mainTab.c.aQT && cVar.type == 99) {
                    tbFragmentTabIndicator.setIconViewWithoutText(l.e(this.dvt, d.e.ds96), l.e(this.dvt.getActivity(), d.e.tbds12));
                }
            }
            if (!TextUtils.isEmpty(str)) {
                tbFragmentTabIndicator.setText(str);
            } else {
                tbFragmentTabIndicator.setText(cVar.aQQ);
            }
            tbFragmentTabIndicator.dC(TbadkCoreApplication.getInst().getSkinType());
            tbFragmentTabIndicator.setTipPosType(1);
            tbFragmentTabIndicator.setIsContentSelectBold(false);
            if (cVar.aQW != com.baidu.tbadk.mainTab.c.aQT || cVar.type != 99) {
                z = false;
            }
            if (!z && (tbFragmentTabIndicator instanceof FragmentTabIndicator)) {
                tbFragmentTabIndicator.a(String.valueOf(bVar2.mType), c((FragmentTabIndicator) tbFragmentTabIndicator));
            }
            bVar2.anM = tbFragmentTabIndicator;
            bVar2.anO = bVar;
            this.aoi.a(bVar2);
        }
    }

    private TbFragmentTabIndicator.a c(FragmentTabIndicator fragmentTabIndicator) {
        int dimensionPixelSize = this.dvt.getResources().getDimensionPixelSize(d.e.ds12);
        ImageView imageView = new ImageView(this.dvt);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        imageView.setImageResource(d.f.icon_frs_tab_new_notify_red_point);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        fragmentTabIndicator.setTipPosType(1);
        fragmentTabIndicator.setTipTopMargin(this.dvt.getResources().getDimensionPixelSize(d.e.ds12));
        aVar.aRj = fragmentTabIndicator;
        aVar.zd = this.dvt.getResources().getDimensionPixelSize(d.e.ds12);
        aVar.view = imageView;
        aVar.view.setVisibility(8);
        return aVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dvu instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dvu.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gc(int i) {
        if (this.dvu instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dvu.gc(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dvu instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dvu.a(bVar);
        }
    }

    public void onNewIntent(Intent intent) {
        if (this.dvu != null) {
            this.dvu.onNewIntent(intent);
        }
    }

    public void onResume() {
        if (this.aoi == null) {
            this.dvu.setPrimary(true);
            return;
        }
        Fragment currentFragment = this.aoi.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(true);
        }
    }

    public void onPause() {
        if (this.aoi == null) {
            this.dvu.setPrimary(false);
            return;
        }
        Fragment currentFragment = this.aoi.getCurrentFragment();
        if (currentFragment instanceof BaseFragment) {
            ((BaseFragment) currentFragment).setPrimary(false);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aoi == null) {
            this.dvu.onChangeSkinType(i);
        } else {
            this.aoi.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            axE();
        }
        if (this.dvw != null) {
            al.c(this.dvw, d.f.icon_tabbar_add_n);
            al.i(this.dvw, d.f.icon_tabbar_chaticon_n);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aoi != null && this.dvv != null && this.dvv.isShowing()) {
                this.dvv.bGf();
                if (g.ya()) {
                    this.dvt.getWindow().setNavigationBarColor(fW(true));
                }
            } else if (this.dvu != null && this.dvu.isAdded()) {
                if (this.dvu.onKeyDown(i, keyEvent)) {
                    return true;
                }
                axG();
            } else {
                return this.dvt.b(i, keyEvent);
            }
            return false;
        }
        return this.dvt.b(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axG() {
        if (this.dvC != this.dvA && this.aoi != null && !axC()) {
            this.aoi.setCurrentTab(this.dvA);
            if (kU(this.dvA) != 1) {
                this.dvu.fv(false);
            }
            this.dvC = this.dvA;
            a(this.aoi.getCurrentFragment(), this.dvA);
            return;
        }
        this.dvu.closeActivity();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.aoi == null) {
            this.dvu.onActivityResult(i, i2, intent);
        } else if (99 == this.aoi.getCurrentTabType() || 1 == this.aoi.getCurrentTabType()) {
            this.dvu.onActivityResult(i, i2, intent);
        } else {
            this.aoi.getCurrentFragment().onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            if (i == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    com.baidu.tieba.n.a.bnR().x(this.dvt.getPageContext());
                    com.baidu.tbadk.coreExtra.c.d shareItem = TbadkCoreApplication.getInst().getShareItem();
                    if (shareItem != null && shareItem.linkUrl != null && this.dvD != null) {
                        this.dvD.a(shareItem.linkUrl, intExtra2, new ShareSuccessReplyToServerModel.a() { // from class: com.baidu.tieba.frs.gametab.c.5
                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void Ee() {
                            }

                            @Override // com.baidu.tbadk.coreExtra.model.ShareSuccessReplyToServerModel.a
                            public void a(final CustomDialogData customDialogData) {
                                com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.gametab.c.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (c.this.dvt != null) {
                                            com.baidu.tieba.pb.interactionpopupwindow.c.a(c.this.dvt.getPageContext(), customDialogData).show();
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            } else if (i == 13011) {
                com.baidu.tieba.n.a.bnR().x(this.dvt.getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.aoi == null) {
            return this.dvu.getVoiceManager();
        }
        Fragment currentFragment = this.aoi.getCurrentFragment();
        if (currentFragment instanceof VoiceManager.c) {
            return ((VoiceManager.c) currentFragment).getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public void axH() {
        if (ba.aU(this.dvt) && !this.dvE.bAI() && !axI()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921032));
            if (this.dvv == null) {
                this.dvv = new com.baidu.tieba.write.c(this.dvt.getPageContext(), this.btg, "frs");
                this.dvv.vA("2");
            }
            this.dvv.a(this.dvu.atL());
            if (g.ya()) {
                this.dvv.vc(fW(true));
                this.dvt.getWindow().setNavigationBarColor(fW(false));
            }
            this.dvv.nt(false);
        }
    }

    public boolean axI() {
        if (this.dvu != null && this.dvu.isAdded() && this.dvu.getPageContext() != null) {
            d.a(this.dvu.getPageContext(), this.dvu.atI());
        }
        return false;
    }

    private int axJ() {
        if (this.dvy == null) {
            return -1;
        }
        int y = w.y(this.dvy.auM());
        for (int i = 0; i < y; i++) {
            if (this.dvy.auM().get(i).tab_id.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int kT(int i) {
        if (this.dvy == null) {
            return -1;
        }
        int y = w.y(this.dvy.auM());
        for (int i2 = 0; i2 < y; i2++) {
            if (this.dvy.auM().get(i2).tab_id.intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int kU(int i) {
        if (this.dvy != null && i < w.y(this.dvy.auM())) {
            return this.dvy.auM().get(i).tab_id.intValue();
        }
        return -1;
    }

    public FrsFragment asQ() {
        return this.dvu;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> asR() {
        if (this.aoi == null) {
            if (this.dvu instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) this.dvu).asR();
            }
        } else {
            Fragment currentFragment = this.aoi.getCurrentFragment();
            if (currentFragment instanceof FrsCommonImageLayout.c) {
                return ((FrsCommonImageLayout.c) currentFragment).asR();
            }
        }
        return null;
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.dvt.isLoadingViewAttached()) {
            this.dvt.hideLoadingView(this.dvt.findViewById(16908290));
        }
        if (this.dvK != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.dvK);
        }
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(this.dvB, false);
        if (this.dvD != null) {
            this.dvD.cancelLoadData();
        }
    }
}
