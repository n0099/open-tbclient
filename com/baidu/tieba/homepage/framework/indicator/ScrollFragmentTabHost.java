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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.f;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.e;
import com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private CustomViewPager anG;
    private final d bdr;
    private View bkJ;
    private NoNetworkView bvB;
    private PluginErrorTipView cSw;
    private b dWA;
    private e dWB;
    private com.baidu.tieba.homepage.framework.d dWC;
    private s dWp;
    private ObservedChangeLinearLayout dWq;
    private View dWr;
    private HomeTabBarView dWs;
    private View dWt;
    private NewScrollFragmentAdapter dWu;
    private a dWv;
    private com.baidu.tieba.c.d dWw;
    private boolean dWx;
    public CustomMessageListener dWy;
    public CustomMessageListener dWz;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void mQ(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.bdr = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dWu != null) {
                    ScrollFragmentTabHost.this.dWu.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dWy = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.dWq != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.dWq.animate().translationY(-ScrollFragmentTabHost.this.dWq.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.dWq.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.dWz = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.dWu != null) {
                    ScrollFragmentTabHost.this.dWu.aDN();
                }
                if (ScrollFragmentTabHost.this.dWs != null) {
                    ScrollFragmentTabHost.this.dWs.notifyDataSetChanged();
                }
            }
        };
        this.dWA = new b();
        this.dWB = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.e
            public void mG(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.dWu.mI(i), false);
                ScrollFragmentTabHost.this.dWu.mK(i);
            }
        };
        this.dWC = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.tieba.homepage.framework.d
            public void mF(int i) {
                ScrollFragmentTabHost.this.dWA.a(i, ScrollFragmentTabHost.this.dWB);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdr = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dWu != null) {
                    ScrollFragmentTabHost.this.dWu.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dWy = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.dWq != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.dWq.animate().translationY(-ScrollFragmentTabHost.this.dWq.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.dWq.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.dWz = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.dWu != null) {
                    ScrollFragmentTabHost.this.dWu.aDN();
                }
                if (ScrollFragmentTabHost.this.dWs != null) {
                    ScrollFragmentTabHost.this.dWs.notifyDataSetChanged();
                }
            }
        };
        this.dWA = new b();
        this.dWB = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.e
            public void mG(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.dWu.mI(i), false);
                ScrollFragmentTabHost.this.dWu.mK(i);
            }
        };
        this.dWC = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.7
            @Override // com.baidu.tieba.homepage.framework.d
            public void mF(int i) {
                ScrollFragmentTabHost.this.dWA.a(i, ScrollFragmentTabHost.this.dWB);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(f.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.dWq = (ObservedChangeLinearLayout) findViewById(f.g.home_page_fragment_tab_layout);
        this.dWr = findViewById(f.g.home_page_statebar_view);
        this.dWs = (HomeTabBarView) findViewById(f.g.home_tab_bar_view);
        this.cSw = (PluginErrorTipView) findViewById(f.g.view_plugin_error_tip);
        this.bvB = (NoNetworkView) findViewById(f.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(f.g.home_pager_container);
        this.anG = (CustomViewPager) findViewById(f.g.tab_widget_view_pager);
        this.dWt = findViewById(f.g.home_statebar_view);
        this.bkJ = findViewById(f.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dWr.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.dWq.setOnSizeChangeListener(this.bdr);
        this.dWs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.dWu.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.dWv != null) {
                    ScrollFragmentTabHost.this.dWv.mQ(i);
                }
                com.baidu.tbadk.core.bigday.b.tu().an(ScrollFragmentTabHost.this.dWu.mH(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.mP(i) == 3) {
                    an anVar = new an("c12478");
                    anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(anVar);
                }
                if (ScrollFragmentTabHost.this.mP(i) == 4) {
                    TiebaStatic.log(new an("c13172").r("obj_type", ScrollFragmentTabHost.this.dWx ? 2 : 1));
                    ScrollFragmentTabHost.this.dWx = false;
                }
                ScrollFragmentTabHost.this.aDY();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean aDT = ScrollFragmentTabHost.this.aDT();
                    TiebaStatic.log(new an("c12350").r("obj_type", aDT ? 1 : 0));
                    if (aDT && ScrollFragmentTabHost.this.dWu != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.dWu.aDR();
                        ScrollFragmentTabHost.this.dWu.notifyDataSetChanged();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
        this.dWs.setOnTabItemClickListener(new PagerSlidingTabStrip.a() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.indicator.PagerSlidingTabStrip.a
            public void r(View view, int i) {
                if (ScrollFragmentTabHost.this.anG.getCurrentItem() != i && ScrollFragmentTabHost.this.mP(i) == 4) {
                    ScrollFragmentTabHost.this.dWx = true;
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.bvB.a(aVar);
        MessageManager.getInstance().registerListener(this.dWy);
        MessageManager.getInstance().registerListener(this.dWz);
    }

    public void notifyDataSetChanged() {
        if (this.dWu != null && !HomePageStatic.dSr) {
            this.anG.setAdapter(this.dWu);
            this.dWs.notifyDataSetChanged();
            this.dWA.a(this.dWB);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dWu != null) {
            this.dWu.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dWu != null) {
            this.dWu.d(dataRes, z);
        }
    }

    public void aDQ() {
        if (this.dWu != null) {
            this.dWu.aDQ();
        }
    }

    public void o(String str, int i, int i2) {
        if (this.anG != null) {
            this.dWu.o(str, i, i2);
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
        this.dWu = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.dWu.setScrollFragmentTabHost(this);
        this.anG.setOffscreenPageLimit(2);
        this.anG.setAdapter(this.dWu);
        int aDM = this.dWu.aDM();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.dWu;
            if (HomePageStatic.dSr) {
                i = 0;
            }
            this.anG.setCurrentItem(newScrollFragmentAdapter.mI(i));
            this.dWs.setViewPager(this.anG);
            this.dWs.setConcernTabIndex(this.dWu.mI(0));
            if (this.dWp != null) {
                this.dWu.setRecommendFrsNavigationAnimDispatcher(this.dWp);
            }
            aDY();
        }
        i = aDM;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.dWu;
        if (HomePageStatic.dSr) {
        }
        this.anG.setCurrentItem(newScrollFragmentAdapter2.mI(i));
        this.dWs.setViewPager(this.anG);
        this.dWs.setConcernTabIndex(this.dWu.mI(0));
        if (this.dWp != null) {
        }
        aDY();
    }

    public boolean aDW() {
        return this.dWu != null && this.dWu.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.dWu.getCount()) {
            this.dWs.setTabItemClicked(z);
            this.dWu.mL(i);
            this.anG.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.dWu.mI(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dWs.setPageUniqueId(bdUniqueId);
        this.dWy.setTag(bdUniqueId);
        this.dWz.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentTabType() {
        return this.dWu.mH(this.anG.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.anG.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.dWu.mH(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int mP(int i) {
        return this.dWu.mH(i);
    }

    public void onChangeSkinType(int i) {
        am.j(this.dWr, f.d.cp_bg_line_d);
        this.dWs.onChangeSkinType();
        if (this.mPageContext != null && this.bvB != null) {
            this.bvB.onChangeSkinType(this.mPageContext, i);
        }
        if (this.dWu != null) {
            this.dWu.dF(i);
        }
        if (this.mPageContext != null && this.cSw != null) {
            this.cSw.onChangeSkinType(this.mPageContext, i);
        }
        am.j(this.dWt, f.d.cp_bg_line_d);
        am.j(this.bkJ, f.d.cp_bg_line_c);
    }

    public void aDS() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.dWu != null) {
            this.dWu.aDS();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4) && this.dWu != null) {
            this.dWu.aDS();
        }
    }

    public void Ul() {
        this.dWu.Ul();
    }

    public String getCurrentPageKey() {
        if (this.dWu != null) {
            return this.dWu.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.anG != null) {
            return this.anG.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.dWu != null) {
            this.dWu.setPrimary(z);
        }
        if (this.bvB != null && z) {
            this.bvB.setVisibility(j.js() ? 8 : 0);
        }
    }

    public void aDX() {
        this.dWu.a(this.dWC);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dWv = aVar;
    }

    public void onDestroy() {
        if (this.dWp != null) {
            this.dWp.onDestroy();
        }
        aEa();
    }

    public void aDY() {
        int i = 1;
        if (this.dWu != null) {
            int mH = this.dWu.mH(this.anG.getCurrentItem());
            if (mH == 0) {
                i = 0;
            } else if (mH != 1) {
                i = -1;
            }
            if (i != -1) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("home_remember_page_index", i);
            }
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.dWs != null && this.dWu.aDP()) {
            this.dWs.setShowConcernRedTip(z);
        }
    }

    public boolean aDT() {
        if (this.dWs == null || !this.dWu.aDP()) {
            return false;
        }
        return this.dWs.aDT();
    }

    public void setVideoThreadId(String str) {
        if (this.dWu != null) {
            this.dWu.setVideoThreadId(str);
        }
    }

    public void aDZ() {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int mI = this.dWu != null ? this.dWu.mI(0) : 0;
            if (this.dWw == null) {
                this.dWw = new com.baidu.tieba.c.d(this.mPageContext, this.dWs.mM(mI));
                this.dWw.jo(f.C0146f.bg_tip_blue_up);
                this.dWw.jn(32);
                this.dWw.eL(true);
                this.dWw.C(true);
                this.dWw.js(l.f(this.mContext, f.e.ds16));
                this.dWw.jp(4000);
            }
            this.dWw.g(this.mContext.getString(f.j.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void aEa() {
        if (this.dWw != null) {
            this.dWw.akO();
        }
    }

    public void onResume() {
        if (this.dWs != null) {
            this.dWs.onResume();
        }
    }
}
