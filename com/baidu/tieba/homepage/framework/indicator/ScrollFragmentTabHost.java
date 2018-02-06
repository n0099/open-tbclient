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
    private CustomViewPager aUr;
    private final e bJr;
    private View bQA;
    private NoNetworkView cbj;
    private PluginErrorTipView dpv;
    private s eip;
    private ObservedChangeLinearLayout eiq;
    private View eir;
    private HomeTabBarView eis;
    private View eit;
    private com.baidu.tieba.homepage.framework.indicator.a eiu;
    private a eiv;
    private c eiw;
    private com.baidu.tieba.homepage.framework.e eix;
    private d eiy;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void oK(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.bJr = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.eiu != null) {
                    ScrollFragmentTabHost.this.eiu.e(view, i, i2, i3, i4);
                }
            }
        };
        this.eiw = new c();
        this.eix = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void oA(int i) {
                ScrollFragmentTabHost.this.H(ScrollFragmentTabHost.this.eiu.oC(i), false);
                ScrollFragmentTabHost.this.eiu.oF(i);
            }
        };
        this.eiy = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void oz(int i) {
                ScrollFragmentTabHost.this.eiw.a(i, ScrollFragmentTabHost.this.eix);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bJr = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.eiu != null) {
                    ScrollFragmentTabHost.this.eiu.e(view, i, i2, i3, i4);
                }
            }
        };
        this.eiw = new c();
        this.eix = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void oA(int i) {
                ScrollFragmentTabHost.this.H(ScrollFragmentTabHost.this.eiu.oC(i), false);
                ScrollFragmentTabHost.this.eiu.oF(i);
            }
        };
        this.eiy = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void oz(int i) {
                ScrollFragmentTabHost.this.eiw.a(i, ScrollFragmentTabHost.this.eix);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.eiq = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.eir = findViewById(d.g.home_page_statebar_view);
        this.eis = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.dpv = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.cbj = (NoNetworkView) findViewById(d.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.home_pager_container);
        this.aUr = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.eit = findViewById(d.g.home_statebar_view);
        this.bQA = findViewById(d.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.eir.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.eiq.setOnSizeChangeListener(this.bJr);
        this.eis.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.eiu.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.eiv != null) {
                    ScrollFragmentTabHost.this.eiv.oK(i);
                }
                if (ScrollFragmentTabHost.this.oJ(i) == 3) {
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
                    if (aCD && ScrollFragmentTabHost.this.eiu != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.eiu.oE(0);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.cbj.a(aVar);
    }

    public void notifyDataSetChanged() {
        if (this.eiu != null && !HomePageStatic.efv) {
            this.aUr.setAdapter(this.eiu);
            this.eis.notifyDataSetChanged();
            this.eiw.a(this.eix);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.eiu != null) {
            this.eiu.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.eiu != null) {
            this.eiu.d(dataRes, z);
        }
    }

    public void aCe() {
        if (this.eiu != null) {
            this.eiu.aCe();
        }
        if (this.eiu != null && this.aUr != null && this.aUr.getCurrentItem() == 0) {
            this.eiu.aCB();
        }
    }

    public void n(String str, int i, int i2) {
        if (this.aUr != null) {
            this.eiu.n(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        this.eiu = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar, aVar);
        this.eiu.setScrollFragmentTabHost(this);
        this.aUr.setOffscreenPageLimit(2);
        this.aUr.setAdapter(this.eiu);
        this.aUr.setCurrentItem(this.eiu.oC(HomePageStatic.efv ? 0 : 1));
        this.eis.setViewPager(this.aUr);
        if (this.eip != null) {
            this.eiu.setRecommendFrsNavigationAnimDispatcher(this.eip);
        }
    }

    public boolean aCF() {
        return this.eiu != null && this.eiu.getCount() > 0;
    }

    public void H(int i, boolean z) {
        if (i >= 0 && i < this.eiu.getCount()) {
            this.eis.setTabItemClicked(z);
            this.eiu.oG(i);
            this.aUr.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        H(this.eiu.oC(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eis.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentItem() {
        return this.aUr.getCurrentItem();
    }

    public int getCurrentTabType() {
        return this.eiu.oB(this.aUr.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.aUr.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.eiu.oB(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int oJ(int i) {
        return this.eiu.oB(i);
    }

    public aj getCurrentFragment() {
        return this.eiu.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.util.aj.t(this, d.C0140d.cp_bg_line_d);
        com.baidu.tbadk.core.util.aj.t(this.eir, d.C0140d.cp_bg_line_d);
        this.eis.onChangeSkinType();
        if (this.mPageContext != null && this.cbj != null) {
            this.cbj.onChangeSkinType(this.mPageContext, i);
        }
        if (this.eiu != null) {
            this.eiu.gB(i);
        }
        if (this.mPageContext != null && this.dpv != null) {
            this.dpv.onChangeSkinType(this.mPageContext, i);
        }
        com.baidu.tbadk.core.util.aj.t(this.eit, d.C0140d.cp_bg_line_d);
        com.baidu.tbadk.core.util.aj.t(this.bQA, d.C0140d.cp_bg_line_c);
    }

    public void aCC() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.eiu != null) {
            this.eiu.aCC();
        }
        if ((currentTabType == 1 || currentTabType == 3) && this.eiu != null) {
            this.eiu.aCC();
        }
    }

    public void XL() {
        this.eiu.XL();
    }

    public String getCurrentPageKey() {
        if (this.eiu != null) {
            return this.eiu.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.aUr != null) {
            return this.aUr.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.eiu != null) {
            this.eiu.setPrimary(z);
        }
        if (this.cbj != null && z) {
            this.cbj.setVisibility(j.ox() ? 8 : 0);
        }
    }

    public void aCG() {
        this.eiu.a(this.eiy);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.eiv = aVar;
    }

    public void onDestroy() {
        if (this.eip != null) {
            this.eip.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.eis != null && this.eiu.aCA()) {
            this.eis.setShowConcernRedTip(z);
        }
    }

    public boolean aCD() {
        if (this.eis == null || !this.eiu.aCA()) {
            return false;
        }
        return this.eis.aCD();
    }

    public void setVideoThreadId(String str) {
        if (this.eiu != null) {
            this.eiu.setVideoThreadId(str);
        }
    }
}
