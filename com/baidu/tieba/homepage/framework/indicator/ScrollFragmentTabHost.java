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
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.e;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private FrameLayout alf;
    private CustomViewPager anF;
    private final d bdr;
    private View bkE;
    private NoNetworkView bvz;
    private PluginErrorTipView cSz;
    private com.baidu.tieba.c.d dWA;
    public CustomMessageListener dWB;
    public CustomMessageListener dWC;
    private b dWD;
    private e dWE;
    private com.baidu.tieba.homepage.framework.d dWF;
    private s dWt;
    private ObservedChangeLinearLayout dWu;
    private View dWv;
    private HomeTabBarView dWw;
    private View dWx;
    private NewScrollFragmentAdapter dWy;
    private a dWz;
    private Context mContext;
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
                if (ScrollFragmentTabHost.this.dWy != null) {
                    ScrollFragmentTabHost.this.dWy.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dWB = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.dWu != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.dWu.animate().translationY(-ScrollFragmentTabHost.this.dWu.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.dWu.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.dWC = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.dWy != null) {
                    ScrollFragmentTabHost.this.dWy.aDQ();
                }
                if (ScrollFragmentTabHost.this.dWw != null) {
                    ScrollFragmentTabHost.this.dWw.notifyDataSetChanged();
                }
            }
        };
        this.dWD = new b();
        this.dWE = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.e
            public void mG(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.dWy.mI(i), false);
                ScrollFragmentTabHost.this.dWy.mK(i);
            }
        };
        this.dWF = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.d
            public void mF(int i) {
                ScrollFragmentTabHost.this.dWD.a(i, ScrollFragmentTabHost.this.dWE);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdr = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dWy != null) {
                    ScrollFragmentTabHost.this.dWy.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dWB = new CustomMessageListener(2921348) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && ScrollFragmentTabHost.this.dWu != null) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        ScrollFragmentTabHost.this.dWu.animate().translationY(-ScrollFragmentTabHost.this.dWu.getHeight()).setDuration(200L).start();
                    } else {
                        ScrollFragmentTabHost.this.dWu.animate().translationY(0.0f).setDuration(400L).start();
                    }
                }
            }
        };
        this.dWC = new CustomMessageListener(2921353) { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ScrollFragmentTabHost.this.dWy != null) {
                    ScrollFragmentTabHost.this.dWy.aDQ();
                }
                if (ScrollFragmentTabHost.this.dWw != null) {
                    ScrollFragmentTabHost.this.dWw.notifyDataSetChanged();
                }
            }
        };
        this.dWD = new b();
        this.dWE = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.5
            @Override // com.baidu.tieba.homepage.framework.e
            public void mG(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.dWy.mI(i), false);
                ScrollFragmentTabHost.this.dWy.mK(i);
            }
        };
        this.dWF = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.6
            @Override // com.baidu.tieba.homepage.framework.d
            public void mF(int i) {
                ScrollFragmentTabHost.this.dWD.a(i, ScrollFragmentTabHost.this.dWE);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.dWu = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.dWv = findViewById(d.g.home_page_statebar_view);
        this.dWw = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.cSz = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.bvz = (NoNetworkView) findViewById(d.g.view_no_network);
        this.alf = (FrameLayout) findViewById(d.g.home_pager_container);
        this.anF = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.dWx = findViewById(d.g.home_statebar_view);
        this.bkE = findViewById(d.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dWv.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.dWu.setOnSizeChangeListener(this.bdr);
        this.dWw.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.dWy.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.dWz != null) {
                    ScrollFragmentTabHost.this.dWz.mQ(i);
                }
                com.baidu.tbadk.core.bigday.b.tv().am(ScrollFragmentTabHost.this.dWy.mH(i) == 1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
                if (ScrollFragmentTabHost.this.mP(i) == 3) {
                    an anVar = new an("c12478");
                    anVar.af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(anVar);
                }
                ScrollFragmentTabHost.this.aEb();
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean aDW = ScrollFragmentTabHost.this.aDW();
                    TiebaStatic.log(new an("c12350").r("obj_type", aDW ? 1 : 0));
                    if (aDW && ScrollFragmentTabHost.this.dWy != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.dWy.aDU();
                        ScrollFragmentTabHost.this.dWy.notifyDataSetChanged();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.bvz.a(aVar);
        MessageManager.getInstance().registerListener(this.dWB);
        MessageManager.getInstance().registerListener(this.dWC);
    }

    public void notifyDataSetChanged() {
        if (this.dWy != null && !HomePageStatic.dSw) {
            this.anF.setAdapter(this.dWy);
            this.dWw.notifyDataSetChanged();
            this.dWD.a(this.dWE);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dWy != null) {
            this.dWy.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dWy != null) {
            this.dWy.d(dataRes, z);
        }
    }

    public void aDT() {
        if (this.dWy != null) {
            this.dWy.aDT();
        }
    }

    public void o(String str, int i, int i2) {
        if (this.anF != null) {
            this.dWy.o(str, i, i2);
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
        this.dWy = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.dWy.setScrollFragmentTabHost(this);
        this.anF.setOffscreenPageLimit(2);
        this.anF.setAdapter(this.dWy);
        int aDP = this.dWy.aDP();
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page", 0) == 1) {
            int i2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("home_remember_page_index", -1);
            if (i2 == 0) {
                i = 0;
            }
            NewScrollFragmentAdapter newScrollFragmentAdapter = this.dWy;
            if (HomePageStatic.dSw) {
                i = 0;
            }
            this.anF.setCurrentItem(newScrollFragmentAdapter.mI(i));
            this.dWw.setViewPager(this.anF);
            this.dWw.setConcernTabIndex(this.dWy.mI(0));
            if (this.dWt != null) {
                this.dWy.setRecommendFrsNavigationAnimDispatcher(this.dWt);
            }
            aEb();
        }
        i = aDP;
        NewScrollFragmentAdapter newScrollFragmentAdapter2 = this.dWy;
        if (HomePageStatic.dSw) {
        }
        this.anF.setCurrentItem(newScrollFragmentAdapter2.mI(i));
        this.dWw.setViewPager(this.anF);
        this.dWw.setConcernTabIndex(this.dWy.mI(0));
        if (this.dWt != null) {
        }
        aEb();
    }

    public boolean aDZ() {
        return this.dWy != null && this.dWy.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.dWy.getCount()) {
            this.dWw.setTabItemClicked(z);
            this.dWy.mL(i);
            this.anF.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.dWy.mI(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dWw.setPageUniqueId(bdUniqueId);
        this.dWB.setTag(bdUniqueId);
        this.dWC.setTag(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.alf;
    }

    public int getCurrentTabType() {
        return this.dWy.mH(this.anF.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.anF.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.dWy.mH(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int mP(int i) {
        return this.dWy.mH(i);
    }

    public void onChangeSkinType(int i) {
        am.j(this.dWv, d.C0140d.cp_bg_line_d);
        this.dWw.onChangeSkinType();
        if (this.mPageContext != null && this.bvz != null) {
            this.bvz.onChangeSkinType(this.mPageContext, i);
        }
        if (this.dWy != null) {
            this.dWy.dG(i);
        }
        if (this.mPageContext != null && this.cSz != null) {
            this.cSz.onChangeSkinType(this.mPageContext, i);
        }
        am.j(this.dWx, d.C0140d.cp_bg_line_d);
        am.j(this.bkE, d.C0140d.cp_bg_line_c);
    }

    public void aDV() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.dWy != null) {
            this.dWy.aDV();
        }
        if ((currentTabType == 1 || currentTabType == 3 || currentTabType == 4) && this.dWy != null) {
            this.dWy.aDV();
        }
    }

    public void Ui() {
        this.dWy.Ui();
    }

    public String getCurrentPageKey() {
        if (this.dWy != null) {
            return this.dWy.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.anF != null) {
            return this.anF.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.dWy != null) {
            this.dWy.setPrimary(z);
        }
        if (this.bvz != null && z) {
            this.bvz.setVisibility(j.js() ? 8 : 0);
        }
    }

    public void aEa() {
        this.dWy.a(this.dWF);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dWz = aVar;
    }

    public void onDestroy() {
        if (this.dWt != null) {
            this.dWt.onDestroy();
        }
        aEd();
    }

    public void aEb() {
        int i = 1;
        if (this.dWy != null) {
            int mH = this.dWy.mH(this.anF.getCurrentItem());
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
        if (this.dWw != null && this.dWy.aDS()) {
            this.dWw.setShowConcernRedTip(z);
        }
    }

    public boolean aDW() {
        if (this.dWw == null || !this.dWy.aDS()) {
            return false;
        }
        return this.dWw.aDW();
    }

    public void setVideoThreadId(String str) {
        if (this.dWy != null) {
            this.dWy.setVideoThreadId(str);
        }
    }

    public void aEc() {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int mI = this.dWy != null ? this.dWy.mI(0) : 0;
            if (this.dWA == null) {
                this.dWA = new com.baidu.tieba.c.d(this.mPageContext, this.dWw.mM(mI));
                this.dWA.jp(d.f.bg_tip_blue_up);
                this.dWA.jo(32);
                this.dWA.eL(true);
                this.dWA.C(true);
                this.dWA.jt(l.f(this.mContext, d.e.ds16));
                this.dWA.jq(4000);
            }
            this.dWA.g(this.mContext.getString(d.j.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void aEd() {
        if (this.dWA != null) {
            this.dWA.akM();
        }
    }

    public void onResume() {
        if (this.dWw != null) {
            this.dWw.onResume();
        }
    }
}
