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
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.layout.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.homepage.framework.d;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private CustomViewPager aUh;
    private final e bJh;
    private View bQq;
    private NoNetworkView cba;
    private PluginErrorTipView dpm;
    private c eiA;
    private com.baidu.tieba.homepage.framework.e eiB;
    private d eiC;
    private s eit;
    private ObservedChangeLinearLayout eiu;
    private View eiv;
    private HomeTabBarView eiw;
    private View eix;
    private com.baidu.tieba.homepage.framework.indicator.a eiy;
    private a eiz;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void oL(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.bJh = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.eiy != null) {
                    ScrollFragmentTabHost.this.eiy.e(view, i, i2, i3, i4);
                }
            }
        };
        this.eiA = new c();
        this.eiB = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void oB(int i) {
                ScrollFragmentTabHost.this.H(ScrollFragmentTabHost.this.eiy.oD(i), false);
                ScrollFragmentTabHost.this.eiy.oG(i);
            }
        };
        this.eiC = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void oA(int i) {
                ScrollFragmentTabHost.this.eiA.a(i, ScrollFragmentTabHost.this.eiB);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bJh = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.eiy != null) {
                    ScrollFragmentTabHost.this.eiy.e(view, i, i2, i3, i4);
                }
            }
        };
        this.eiA = new c();
        this.eiB = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void oB(int i) {
                ScrollFragmentTabHost.this.H(ScrollFragmentTabHost.this.eiy.oD(i), false);
                ScrollFragmentTabHost.this.eiy.oG(i);
            }
        };
        this.eiC = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void oA(int i) {
                ScrollFragmentTabHost.this.eiA.a(i, ScrollFragmentTabHost.this.eiB);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.eiu = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.eiv = findViewById(d.g.home_page_statebar_view);
        this.eiw = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.dpm = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.cba = (NoNetworkView) findViewById(d.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.home_pager_container);
        this.aUh = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.eix = findViewById(d.g.home_statebar_view);
        this.bQq = findViewById(d.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.eiv.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.eiu.setOnSizeChangeListener(this.bJh);
        this.eiw.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.eiy.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.eiz != null) {
                    ScrollFragmentTabHost.this.eiz.oL(i);
                }
                if (ScrollFragmentTabHost.this.oK(i) == 3) {
                    ak akVar = new ak("c12478");
                    akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(akVar);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean aCD = ScrollFragmentTabHost.this.aCD();
                    TiebaStatic.log(new ak("c12350").s("obj_type", aCD ? 1 : 0));
                    if (aCD && ScrollFragmentTabHost.this.eiy != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.eiy.oF(0);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.cba.a(aVar);
    }

    public void notifyDataSetChanged() {
        if (this.eiy != null && !HomePageStatic.efz) {
            this.aUh.setAdapter(this.eiy);
            this.eiw.notifyDataSetChanged();
            this.eiA.a(this.eiB);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.eiy != null) {
            this.eiy.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.eiy != null) {
            this.eiy.d(dataRes, z);
        }
    }

    public void aCe() {
        if (this.eiy != null) {
            this.eiy.aCe();
        }
        if (this.eiy != null && this.aUh != null && this.aUh.getCurrentItem() == 0) {
            this.eiy.aCB();
        }
    }

    public void n(String str, int i, int i2) {
        if (this.aUh != null) {
            this.eiy.n(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        this.eiy = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar, aVar);
        this.eiy.setScrollFragmentTabHost(this);
        this.aUh.setOffscreenPageLimit(2);
        this.aUh.setAdapter(this.eiy);
        this.aUh.setCurrentItem(this.eiy.oD(HomePageStatic.efz ? 0 : 1));
        this.eiw.setViewPager(this.aUh);
        if (this.eit != null) {
            this.eiy.setRecommendFrsNavigationAnimDispatcher(this.eit);
        }
    }

    public boolean aCF() {
        return this.eiy != null && this.eiy.getCount() > 0;
    }

    public void H(int i, boolean z) {
        if (i >= 0 && i < this.eiy.getCount()) {
            this.eiw.setTabItemClicked(z);
            this.eiy.oH(i);
            this.aUh.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        H(this.eiy.oD(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eiw.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentItem() {
        return this.aUh.getCurrentItem();
    }

    public int getCurrentTabType() {
        return this.eiy.oC(this.aUh.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.aUh.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.eiy.oC(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int oK(int i) {
        return this.eiy.oC(i);
    }

    public aj getCurrentFragment() {
        return this.eiy.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.util.aj.t(this, d.C0141d.cp_bg_line_d);
        com.baidu.tbadk.core.util.aj.t(this.eiv, d.C0141d.cp_bg_line_d);
        this.eiw.onChangeSkinType();
        if (this.mPageContext != null && this.cba != null) {
            this.cba.onChangeSkinType(this.mPageContext, i);
        }
        if (this.eiy != null) {
            this.eiy.gB(i);
        }
        if (this.mPageContext != null && this.dpm != null) {
            this.dpm.onChangeSkinType(this.mPageContext, i);
        }
        com.baidu.tbadk.core.util.aj.t(this.eix, d.C0141d.cp_bg_line_d);
        com.baidu.tbadk.core.util.aj.t(this.bQq, d.C0141d.cp_bg_line_c);
    }

    public void aCC() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.eiy != null) {
            this.eiy.aCC();
        }
        if ((currentTabType == 1 || currentTabType == 3) && this.eiy != null) {
            this.eiy.aCC();
        }
    }

    public void XL() {
        this.eiy.XL();
    }

    public String getCurrentPageKey() {
        if (this.eiy != null) {
            return this.eiy.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.aUh != null) {
            return this.aUh.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.eiy != null) {
            this.eiy.setPrimary(z);
        }
        if (this.cba != null && z) {
            this.cba.setVisibility(j.ox() ? 8 : 0);
        }
    }

    public void aCG() {
        this.eiy.a(this.eiC);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.eiz = aVar;
    }

    public void onDestroy() {
        if (this.eit != null) {
            this.eit.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.eiw != null && this.eiy.aCA()) {
            this.eiw.setShowConcernRedTip(z);
        }
    }

    public boolean aCD() {
        if (this.eiw == null || !this.eiy.aCA()) {
            return false;
        }
        return this.eiw.aCD();
    }

    public void setVideoThreadId(String str) {
        if (this.eiy != null) {
            this.eiy.setVideoThreadId(str);
        }
    }
}
