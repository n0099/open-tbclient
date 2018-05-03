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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.layout.d;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.e;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private final d aTZ;
    private CustomViewPager afB;
    private View bam;
    private NoNetworkView bla;
    private PluginErrorTipView cHz;
    private s dCW;
    private ObservedChangeLinearLayout dCX;
    private View dCY;
    private HomeTabBarView dCZ;
    private View dDa;
    private NewScrollFragmentAdapter dDb;
    private a dDc;
    private b dDd;
    private e dDe;
    private com.baidu.tieba.homepage.framework.d dDf;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void mj(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.aTZ = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view2, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dDb != null) {
                    ScrollFragmentTabHost.this.dDb.b(view2, i, i2, i3, i4);
                }
            }
        };
        this.dDd = new b();
        this.dDe = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void ma(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.dDb.mc(i), false);
                ScrollFragmentTabHost.this.dDb.me(i);
            }
        };
        this.dDf = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void lZ(int i) {
                ScrollFragmentTabHost.this.dDd.a(i, ScrollFragmentTabHost.this.dDe);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aTZ = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view2, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dDb != null) {
                    ScrollFragmentTabHost.this.dDb.b(view2, i, i2, i3, i4);
                }
            }
        };
        this.dDd = new b();
        this.dDe = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void ma(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.dDb.mc(i), false);
                ScrollFragmentTabHost.this.dDb.me(i);
            }
        };
        this.dDf = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void lZ(int i) {
                ScrollFragmentTabHost.this.dDd.a(i, ScrollFragmentTabHost.this.dDe);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.i.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.dCX = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.dCY = findViewById(d.g.home_page_statebar_view);
        this.dCZ = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.cHz = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.bla = (NoNetworkView) findViewById(d.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.home_pager_container);
        this.afB = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.dDa = findViewById(d.g.home_statebar_view);
        this.bam = findViewById(d.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dCY.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.dCX.setOnSizeChangeListener(this.aTZ);
        this.dCZ.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.dDb.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.dDc != null) {
                    ScrollFragmentTabHost.this.dDc.mj(i);
                }
                if (ScrollFragmentTabHost.this.mi(i) == 3) {
                    al alVar = new al("c12478");
                    alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(alVar);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean axB = ScrollFragmentTabHost.this.axB();
                    TiebaStatic.log(new al("c12350").r("obj_type", axB ? 1 : 0));
                    if (axB && ScrollFragmentTabHost.this.dDb != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.dDb.axz();
                        ScrollFragmentTabHost.this.dDb.notifyDataSetChanged();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.bla.a(aVar);
    }

    public void notifyDataSetChanged() {
        if (this.dDb != null && !HomePageStatic.dAc) {
            this.afB.setAdapter(this.dDb);
            this.dCZ.notifyDataSetChanged();
            this.dDd.a(this.dDe);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dDb != null) {
            this.dDb.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dDb != null) {
            this.dDb.d(dataRes, z);
        }
    }

    public void axa() {
        if (this.dDb != null) {
            this.dDb.axa();
        }
        if (this.dDb != null && this.afB != null && this.afB.getCurrentItem() == 0) {
            this.dDb.axy();
        }
    }

    public void o(String str, int i, int i2) {
        if (this.afB != null) {
            this.dDb.o(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.dDb = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.dDb.setScrollFragmentTabHost(this);
        this.afB.setOffscreenPageLimit(2);
        this.afB.setAdapter(this.dDb);
        this.afB.setCurrentItem(this.dDb.mc(HomePageStatic.dAc ? 0 : 1));
        this.dCZ.setViewPager(this.afB);
        if (this.dCW != null) {
            this.dDb.setRecommendFrsNavigationAnimDispatcher(this.dCW);
        }
    }

    public boolean axD() {
        return this.dDb != null && this.dDb.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.dDb.getCount()) {
            this.dCZ.setTabItemClicked(z);
            this.dDb.mf(i);
            this.afB.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.dDb.mc(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dCZ.setPageUniqueId(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentItem() {
        return this.afB.getCurrentItem();
    }

    public int getCurrentTabType() {
        return this.dDb.mb(this.afB.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.afB.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.dDb.mb(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int mi(int i) {
        return this.dDb.mb(i);
    }

    public af getCurrentFragment() {
        return this.dDb.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        ak.j(this, d.C0126d.cp_bg_line_d);
        ak.j(this.dCY, d.C0126d.cp_bg_line_d);
        this.dCZ.onChangeSkinType();
        if (this.mPageContext != null && this.bla != null) {
            this.bla.onChangeSkinType(this.mPageContext, i);
        }
        if (this.dDb != null) {
            this.dDb.dz(i);
        }
        if (this.mPageContext != null && this.cHz != null) {
            this.cHz.onChangeSkinType(this.mPageContext, i);
        }
        ak.j(this.dDa, d.C0126d.cp_bg_line_d);
        ak.j(this.bam, d.C0126d.cp_bg_line_c);
    }

    public void axA() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.dDb != null) {
            this.dDb.axA();
        }
        if ((currentTabType == 1 || currentTabType == 3) && this.dDb != null) {
            this.dDb.axA();
        }
    }

    public void Ql() {
        this.dDb.Ql();
    }

    public String getCurrentPageKey() {
        if (this.dDb != null) {
            return this.dDb.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.afB != null) {
            return this.afB.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.dDb != null) {
            this.dDb.setPrimary(z);
        }
        if (this.bla != null && z) {
            this.bla.setVisibility(j.gD() ? 8 : 0);
        }
    }

    public void axE() {
        this.dDb.a(this.dDf);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dDc = aVar;
    }

    public void onDestroy() {
        if (this.dCW != null) {
            this.dCW.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.dCZ != null && this.dDb.axx()) {
            this.dCZ.setShowConcernRedTip(z);
        }
    }

    public boolean axB() {
        if (this.dCZ == null || !this.dDb.axx()) {
            return false;
        }
        return this.dCZ.axB();
    }

    public void setVideoThreadId(String str) {
        if (this.dDb != null) {
            this.dDb.setVideoThreadId(str);
        }
    }
}
