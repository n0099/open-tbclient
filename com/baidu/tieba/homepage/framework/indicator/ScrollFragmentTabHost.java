package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.e;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private CustomViewPager avd;
    private NoNetworkView bJX;
    private final d blb;
    private View buH;
    private PluginErrorTipView dgD;
    private u elA;
    private ObservedChangeLinearLayout elB;
    private View elC;
    private HomeTabBarView elD;
    private View elE;
    private NewScrollFragmentAdapter elF;
    private a elG;
    private com.baidu.tieba.c.d elH;
    private boolean elI;
    public CustomMessageListener elJ;
    public CustomMessageListener elK;
    private b elL;
    private e elM;
    private com.baidu.tieba.homepage.framework.d elN;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes6.dex */
    public interface a {
        void nS(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.blb = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.elF != null) {
                    ScrollFragmentTabHost.this.elF.b(view, i, i2, i3, i4);
                }
            }
        };
        this.elJ = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.elB != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.elB.animate().translationY(-ScrollFragmentTabHost.this.elB.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.elB.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.elK = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.elF != null) {
                    ScrollFragmentTabHost.this.elF.aJs();
                }
                if (ScrollFragmentTabHost.this.elD != null) {
                    ScrollFragmentTabHost.this.elD.notifyDataSetChanged();
                }
            }
        };
        this.elL = new b();
        this.elM = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.e
            public void nI(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.elF.nK(i), false);
                ScrollFragmentTabHost.this.elF.nM(i);
            }
        };
        this.elN = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.tieba.homepage.framework.d
            public void nH(int i) {
                ScrollFragmentTabHost.this.elL.a(i, ScrollFragmentTabHost.this.elM);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.blb = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.elF != null) {
                    ScrollFragmentTabHost.this.elF.b(view, i, i2, i3, i4);
                }
            }
        };
        this.elJ = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.elB != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.elB.animate().translationY(-ScrollFragmentTabHost.this.elB.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.elB.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.elK = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.elF != null) {
                    ScrollFragmentTabHost.this.elF.aJs();
                }
                if (ScrollFragmentTabHost.this.elD != null) {
                    ScrollFragmentTabHost.this.elD.notifyDataSetChanged();
                }
            }
        };
        this.elL = new b();
        this.elM = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.e
            public void nI(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.elF.nK(i), false);
                ScrollFragmentTabHost.this.elF.nM(i);
            }
        };
        this.elN = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.tieba.homepage.framework.d
            public void nH(int i) {
                ScrollFragmentTabHost.this.elL.a(i, ScrollFragmentTabHost.this.elM);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.elB = (ObservedChangeLinearLayout) findViewById(e.g.home_page_fragment_tab_layout);
        this.elC = findViewById(e.g.home_page_statebar_view);
        this.elD = (HomeTabBarView) findViewById(e.g.home_tab_bar_view);
        this.dgD = (PluginErrorTipView) findViewById(e.g.view_plugin_error_tip);
        this.bJX = (NoNetworkView) findViewById(e.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(e.g.home_pager_container);
        this.avd = (CustomViewPager) findViewById(e.g.tab_widget_view_pager);
        this.elE = findViewById(e.g.home_statebar_view);
        this.buH = findViewById(e.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.elC.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.elB.setOnSizeChangeListener(this.blb);
        this.elD.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.elF.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.elG != null) {
                    ScrollFragmentTabHost.this.elG.nS(i);
                }
                com.baidu.tbadk.core.bigday.b.wG().aG(ScrollFragmentTabHost.this.elF.nJ(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.nR(i) == 3) {
                    am amVar = new am("c12478");
                    amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(amVar);
                }
                if (ScrollFragmentTabHost.this.nR(i) == 4) {
                    TiebaStatic.log(new am("c13172").x("obj_type", ScrollFragmentTabHost.this.elI ? 2 : 1));
                    ScrollFragmentTabHost.this.elI = false;
                }
                ScrollFragmentTabHost.this.aJD();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean aJy = ScrollFragmentTabHost.this.aJy();
                    TiebaStatic.log(new am("c12350").x("obj_type", aJy ? 1 : 0));
                    if (aJy && ScrollFragmentTabHost.this.elF != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.elF.aJw();
                        ScrollFragmentTabHost.this.elF.notifyDataSetChanged();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
        this.elD.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void r(View view, int i) {
                if (ScrollFragmentTabHost.this.avd.getCurrentItem() != i && ScrollFragmentTabHost.this.nR(i) == 4) {
                    ScrollFragmentTabHost.this.elI = true;
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.bJX.a(aVar);
        MessageManager.getInstance().registerListener(this.elJ);
        MessageManager.getInstance().registerListener(this.elK);
    }

    public void notifyDataSetChanged() {
        if (this.elF != null && !HomePageStatic.ehB) {
            this.avd.setAdapter(this.elF);
            this.elD.notifyDataSetChanged();
            this.elL.a(this.elM);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.elF != null) {
            this.elF.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.elF != null) {
            this.elF.d(dataRes, z);
        }
    }

    public void aJv() {
        if (this.elF != null) {
            this.elF.aJv();
        }
    }

    public void u(String str, int i, int i2) {
        if (this.avd != null) {
            this.elF.u(str, i, i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0070, code lost:
        if (r3 != 1) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        int i = 1;
        this.elF = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.elF.setScrollFragmentTabHost(this);
        this.avd.setOffscreenPageLimit(2);
        this.avd.setAdapter(this.elF);
        int aJr = this.elF.aJr();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.elF;
            if (HomePageStatic.ehB) {
                i = 0;
            }
            this.avd.setCurrentItem(newScrollFragmentAdapter.nK(i));
            this.elD.setViewPager(this.avd);
            this.elD.setConcernTabIndex(this.elF.nK(0));
            if (this.elA != null) {
                this.elF.setRecommendFrsNavigationAnimDispatcher(this.elA);
            }
            aJD();
        }
        i = aJr;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.elF;
        if (HomePageStatic.ehB) {
        }
        this.avd.setCurrentItem(newScrollFragmentAdapter2.nK(i));
        this.elD.setViewPager(this.avd);
        this.elD.setConcernTabIndex(this.elF.nK(0));
        if (this.elA != null) {
        }
        aJD();
    }

    public boolean aJB() {
        return this.elF != null && this.elF.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.elF.getCount()) {
            this.elD.setTabItemClicked(z);
            this.elF.nN(i);
            this.avd.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.elF.nK(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.elD.setPageUniqueId(bdUniqueId);
        this.elJ.setTag(bdUniqueId);
        this.elK.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentTabType() {
        return this.elF.nJ(this.avd.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.avd.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.elF.nJ(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int nR(int i) {
        return this.elF.nJ(i);
    }

    public void onChangeSkinType(int i) {
        al.j(this.elC, e.d.cp_bg_line_d);
        this.elD.onChangeSkinType();
        if (this.mPageContext != null && this.bJX != null) {
            this.bJX.onChangeSkinType(this.mPageContext, i);
        }
        if (this.elF != null) {
            this.elF.ea(i);
        }
        if (this.mPageContext != null && this.dgD != null) {
            this.dgD.onChangeSkinType(this.mPageContext, i);
        }
        al.j(this.elE, e.d.cp_bg_line_d);
        al.j(this.buH, e.d.cp_bg_line_c);
    }

    public void aJx() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.elF != null) {
            this.elF.aJx();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4) && this.elF != null) {
            this.elF.aJx();
        }
    }

    public void ZF() {
        this.elF.ZF();
    }

    public String getCurrentPageKey() {
        if (this.elF != null) {
            return this.elF.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.avd != null) {
            return this.avd.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.elF != null) {
            this.elF.setPrimary(z);
        }
        if (this.bJX != null && z) {
            this.bJX.setVisibility(j.kM() ? 8 : 0);
        }
    }

    public void aJC() {
        this.elF.a(this.elN);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.elG = aVar;
    }

    public void onDestroy() {
        if (this.elA != null) {
            this.elA.onDestroy();
        }
        aJF();
    }

    public void aJD() {
        int i = 1;
        if (this.elF != null) {
            int nJ = this.elF.nJ(this.avd.getCurrentItem());
            if (nJ == 0) {
                i = 0;
            } else if (nJ != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.elD != null && this.elF.aJu()) {
            this.elD.setShowConcernRedTip(z);
        }
    }

    public boolean aJy() {
        if (this.elD == null || !this.elF.aJu()) {
            return false;
        }
        return this.elD.aJy();
    }

    public void setVideoThreadId(String str) {
        if (this.elF != null) {
            this.elF.setVideoThreadId(str);
        }
    }

    public void aJE() {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int nK = this.elF != null ? this.elF.nK(0) : 0;
            if (this.elH == null) {
                this.elH = new com.baidu.tieba.c.d(this.mPageContext, this.elD.nO(nK));
                this.elH.kl(e.f.bg_tip_blue_up);
                this.elH.kk(32);
                this.elH.fu(true);
                this.elH.M(true);
                this.elH.kp(l.h(this.mContext, e.C0175e.ds16));
                this.elH.km(4000);
            }
            this.elH.h(this.mContext.getString(e.j.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void aJF() {
        if (this.elH != null) {
            this.elH.apY();
        }
    }

    public void onResume() {
        if (this.elD != null) {
            this.elD.onResume();
        }
    }
}
