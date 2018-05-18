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
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.ConcernPageView;
import com.baidu.tieba.homepage.framework.e;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private final d aUa;
    private CustomViewPager afB;
    private View ban;
    private NoNetworkView blp;
    private PluginErrorTipView cII;
    private s dEc;
    private ObservedChangeLinearLayout dEd;
    private View dEe;
    private HomeTabBarView dEf;
    private View dEg;
    private NewScrollFragmentAdapter dEh;
    private a dEi;
    private b dEj;
    private e dEk;
    private com.baidu.tieba.homepage.framework.d dEl;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void mi(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.aUa = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view2, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dEh != null) {
                    ScrollFragmentTabHost.this.dEh.b(view2, i, i2, i3, i4);
                }
            }
        };
        this.dEj = new b();
        this.dEk = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void lZ(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.dEh.mb(i), false);
                ScrollFragmentTabHost.this.dEh.md(i);
            }
        };
        this.dEl = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void lY(int i) {
                ScrollFragmentTabHost.this.dEj.a(i, ScrollFragmentTabHost.this.dEk);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aUa = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view2, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dEh != null) {
                    ScrollFragmentTabHost.this.dEh.b(view2, i, i2, i3, i4);
                }
            }
        };
        this.dEj = new b();
        this.dEk = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void lZ(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.dEh.mb(i), false);
                ScrollFragmentTabHost.this.dEh.md(i);
            }
        };
        this.dEl = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void lY(int i) {
                ScrollFragmentTabHost.this.dEj.a(i, ScrollFragmentTabHost.this.dEk);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.i.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.dEd = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.dEe = findViewById(d.g.home_page_statebar_view);
        this.dEf = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.cII = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.blp = (NoNetworkView) findViewById(d.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.home_pager_container);
        this.afB = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.dEg = findViewById(d.g.home_statebar_view);
        this.ban = findViewById(d.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dEe.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.dEd.setOnSizeChangeListener(this.aUa);
        this.dEf.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.dEh.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.dEi != null) {
                    ScrollFragmentTabHost.this.dEi.mi(i);
                }
                if (ScrollFragmentTabHost.this.mh(i) == 3) {
                    al alVar = new al("c12478");
                    alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(alVar);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean axz = ScrollFragmentTabHost.this.axz();
                    TiebaStatic.log(new al("c12350").r("obj_type", axz ? 1 : 0));
                    if (axz && ScrollFragmentTabHost.this.dEh != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.dEh.axx();
                        ScrollFragmentTabHost.this.dEh.notifyDataSetChanged();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.blp.a(aVar);
    }

    public void notifyDataSetChanged() {
        if (this.dEh != null && !HomePageStatic.dBj) {
            this.afB.setAdapter(this.dEh);
            this.dEf.notifyDataSetChanged();
            this.dEj.a(this.dEk);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dEh != null) {
            this.dEh.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dEh != null) {
            this.dEh.d(dataRes, z);
        }
    }

    public void awZ() {
        if (this.dEh != null) {
            this.dEh.awZ();
        }
        if (this.dEh != null && this.afB != null && this.afB.getCurrentItem() == 0) {
            this.dEh.axw();
        }
    }

    public void o(String str, int i, int i2) {
        if (this.afB != null) {
            this.dEh.o(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.dEh = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.dEh.setScrollFragmentTabHost(this);
        this.afB.setOffscreenPageLimit(2);
        this.afB.setAdapter(this.dEh);
        this.afB.setCurrentItem(this.dEh.mb(HomePageStatic.dBj ? 0 : 1));
        this.dEf.setViewPager(this.afB);
        if (this.dEc != null) {
            this.dEh.setRecommendFrsNavigationAnimDispatcher(this.dEc);
        }
    }

    public boolean axB() {
        return this.dEh != null && this.dEh.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.dEh.getCount()) {
            this.dEf.setTabItemClicked(z);
            this.dEh.me(i);
            this.afB.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.dEh.mb(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dEf.setPageUniqueId(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentTabType() {
        return this.dEh.ma(this.afB.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.afB.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.dEh.ma(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int mh(int i) {
        return this.dEh.ma(i);
    }

    public void onChangeSkinType(int i) {
        ak.j(this, d.C0126d.cp_bg_line_d);
        ak.j(this.dEe, d.C0126d.cp_bg_line_d);
        this.dEf.onChangeSkinType();
        if (this.mPageContext != null && this.blp != null) {
            this.blp.onChangeSkinType(this.mPageContext, i);
        }
        if (this.dEh != null) {
            this.dEh.dA(i);
        }
        if (this.mPageContext != null && this.cII != null) {
            this.cII.onChangeSkinType(this.mPageContext, i);
        }
        ak.j(this.dEg, d.C0126d.cp_bg_line_d);
        ak.j(this.ban, d.C0126d.cp_bg_line_c);
    }

    public void axy() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.dEh != null) {
            this.dEh.axy();
        }
        if ((currentTabType == 1 || currentTabType == 3) && this.dEh != null) {
            this.dEh.axy();
        }
    }

    public void Qi() {
        this.dEh.Qi();
    }

    public String getCurrentPageKey() {
        if (this.dEh != null) {
            return this.dEh.getCurrentPageKey();
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
        if (this.dEh != null) {
            this.dEh.setPrimary(z);
        }
        if (this.blp != null && z) {
            this.blp.setVisibility(j.gD() ? 8 : 0);
        }
    }

    public void axC() {
        this.dEh.a(this.dEl);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dEi = aVar;
    }

    public void onDestroy() {
        if (this.dEc != null) {
            this.dEc.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.dEf != null && this.dEh.axv()) {
            this.dEf.setShowConcernRedTip(z);
        }
    }

    public boolean axz() {
        if (this.dEf == null || !this.dEh.axv()) {
            return false;
        }
        return this.dEf.axz();
    }

    public void setVideoThreadId(String str) {
        if (this.dEh != null) {
            this.dEh.setVideoThreadId(str);
        }
    }
}
