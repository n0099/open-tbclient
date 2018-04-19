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
    private PluginErrorTipView cHC;
    private s dCZ;
    private ObservedChangeLinearLayout dDa;
    private View dDb;
    private HomeTabBarView dDc;
    private View dDd;
    private NewScrollFragmentAdapter dDe;
    private a dDf;
    private b dDg;
    private e dDh;
    private com.baidu.tieba.homepage.framework.d dDi;
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
                if (ScrollFragmentTabHost.this.dDe != null) {
                    ScrollFragmentTabHost.this.dDe.b(view2, i, i2, i3, i4);
                }
            }
        };
        this.dDg = new b();
        this.dDh = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void ma(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.dDe.mc(i), false);
                ScrollFragmentTabHost.this.dDe.me(i);
            }
        };
        this.dDi = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void lZ(int i) {
                ScrollFragmentTabHost.this.dDg.a(i, ScrollFragmentTabHost.this.dDh);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aTZ = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view2, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dDe != null) {
                    ScrollFragmentTabHost.this.dDe.b(view2, i, i2, i3, i4);
                }
            }
        };
        this.dDg = new b();
        this.dDh = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void ma(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.dDe.mc(i), false);
                ScrollFragmentTabHost.this.dDe.me(i);
            }
        };
        this.dDi = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void lZ(int i) {
                ScrollFragmentTabHost.this.dDg.a(i, ScrollFragmentTabHost.this.dDh);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.i.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.dDa = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.dDb = findViewById(d.g.home_page_statebar_view);
        this.dDc = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.cHC = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.bla = (NoNetworkView) findViewById(d.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.home_pager_container);
        this.afB = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.dDd = findViewById(d.g.home_statebar_view);
        this.bam = findViewById(d.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dDb.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.dDa.setOnSizeChangeListener(this.aTZ);
        this.dDc.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.dDe.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.dDf != null) {
                    ScrollFragmentTabHost.this.dDf.mj(i);
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
                    if (axB && ScrollFragmentTabHost.this.dDe != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.dDe.axz();
                        ScrollFragmentTabHost.this.dDe.notifyDataSetChanged();
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
        if (this.dDe != null && !HomePageStatic.dAf) {
            this.afB.setAdapter(this.dDe);
            this.dDc.notifyDataSetChanged();
            this.dDg.a(this.dDh);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dDe != null) {
            this.dDe.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dDe != null) {
            this.dDe.d(dataRes, z);
        }
    }

    public void axa() {
        if (this.dDe != null) {
            this.dDe.axa();
        }
        if (this.dDe != null && this.afB != null && this.afB.getCurrentItem() == 0) {
            this.dDe.axy();
        }
    }

    public void o(String str, int i, int i2) {
        if (this.afB != null) {
            this.dDe.o(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.dDe = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.dDe.setScrollFragmentTabHost(this);
        this.afB.setOffscreenPageLimit(2);
        this.afB.setAdapter(this.dDe);
        this.afB.setCurrentItem(this.dDe.mc(HomePageStatic.dAf ? 0 : 1));
        this.dDc.setViewPager(this.afB);
        if (this.dCZ != null) {
            this.dDe.setRecommendFrsNavigationAnimDispatcher(this.dCZ);
        }
    }

    public boolean axD() {
        return this.dDe != null && this.dDe.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.dDe.getCount()) {
            this.dDc.setTabItemClicked(z);
            this.dDe.mf(i);
            this.afB.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.dDe.mc(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dDc.setPageUniqueId(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentItem() {
        return this.afB.getCurrentItem();
    }

    public int getCurrentTabType() {
        return this.dDe.mb(this.afB.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.afB.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.dDe.mb(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int mi(int i) {
        return this.dDe.mb(i);
    }

    public af getCurrentFragment() {
        return this.dDe.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        ak.j(this, d.C0126d.cp_bg_line_d);
        ak.j(this.dDb, d.C0126d.cp_bg_line_d);
        this.dDc.onChangeSkinType();
        if (this.mPageContext != null && this.bla != null) {
            this.bla.onChangeSkinType(this.mPageContext, i);
        }
        if (this.dDe != null) {
            this.dDe.dz(i);
        }
        if (this.mPageContext != null && this.cHC != null) {
            this.cHC.onChangeSkinType(this.mPageContext, i);
        }
        ak.j(this.dDd, d.C0126d.cp_bg_line_d);
        ak.j(this.bam, d.C0126d.cp_bg_line_c);
    }

    public void axA() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.dDe != null) {
            this.dDe.axA();
        }
        if ((currentTabType == 1 || currentTabType == 3) && this.dDe != null) {
            this.dDe.axA();
        }
    }

    public void Ql() {
        this.dDe.Ql();
    }

    public String getCurrentPageKey() {
        if (this.dDe != null) {
            return this.dDe.getCurrentPageKey();
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
        if (this.dDe != null) {
            this.dDe.setPrimary(z);
        }
        if (this.bla != null && z) {
            this.bla.setVisibility(j.gD() ? 8 : 0);
        }
    }

    public void axE() {
        this.dDe.a(this.dDi);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dDf = aVar;
    }

    public void onDestroy() {
        if (this.dCZ != null) {
            this.dCZ.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.dDc != null && this.dDe.axx()) {
            this.dDc.setShowConcernRedTip(z);
        }
    }

    public boolean axB() {
        if (this.dDc == null || !this.dDe.axx()) {
            return false;
        }
        return this.dDc.axB();
    }

    public void setVideoThreadId(String str) {
        if (this.dDe != null) {
            this.dDe.setVideoThreadId(str);
        }
    }
}
