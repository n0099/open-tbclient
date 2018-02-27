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
    private CustomViewPager aUf;
    private final e bJe;
    private View bQn;
    private NoNetworkView caX;
    private PluginErrorTipView dpj;
    private s eid;
    private ObservedChangeLinearLayout eie;
    private View eif;
    private HomeTabBarView eig;
    private View eih;
    private com.baidu.tieba.homepage.framework.indicator.a eii;
    private a eij;
    private c eik;
    private com.baidu.tieba.homepage.framework.e eil;
    private d eim;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void oK(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.bJe = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.eii != null) {
                    ScrollFragmentTabHost.this.eii.e(view, i, i2, i3, i4);
                }
            }
        };
        this.eik = new c();
        this.eil = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void oA(int i) {
                ScrollFragmentTabHost.this.H(ScrollFragmentTabHost.this.eii.oC(i), false);
                ScrollFragmentTabHost.this.eii.oF(i);
            }
        };
        this.eim = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void oz(int i) {
                ScrollFragmentTabHost.this.eik.a(i, ScrollFragmentTabHost.this.eil);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bJe = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.eii != null) {
                    ScrollFragmentTabHost.this.eii.e(view, i, i2, i3, i4);
                }
            }
        };
        this.eik = new c();
        this.eil = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void oA(int i) {
                ScrollFragmentTabHost.this.H(ScrollFragmentTabHost.this.eii.oC(i), false);
                ScrollFragmentTabHost.this.eii.oF(i);
            }
        };
        this.eim = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void oz(int i) {
                ScrollFragmentTabHost.this.eik.a(i, ScrollFragmentTabHost.this.eil);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.eie = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.eif = findViewById(d.g.home_page_statebar_view);
        this.eig = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.dpj = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.caX = (NoNetworkView) findViewById(d.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.home_pager_container);
        this.aUf = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.eih = findViewById(d.g.home_statebar_view);
        this.bQn = findViewById(d.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.eif.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.eie.setOnSizeChangeListener(this.bJe);
        this.eig.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.eii.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.eij != null) {
                    ScrollFragmentTabHost.this.eij.oK(i);
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
                    boolean aCC = ScrollFragmentTabHost.this.aCC();
                    TiebaStatic.log(new ak("c12350").s("obj_type", aCC ? 1 : 0));
                    if (aCC && ScrollFragmentTabHost.this.eii != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.eii.oE(0);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.caX.a(aVar);
    }

    public void notifyDataSetChanged() {
        if (this.eii != null && !HomePageStatic.efj) {
            this.aUf.setAdapter(this.eii);
            this.eig.notifyDataSetChanged();
            this.eik.a(this.eil);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.eii != null) {
            this.eii.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.eii != null) {
            this.eii.d(dataRes, z);
        }
    }

    public void aCd() {
        if (this.eii != null) {
            this.eii.aCd();
        }
        if (this.eii != null && this.aUf != null && this.aUf.getCurrentItem() == 0) {
            this.eii.aCA();
        }
    }

    public void n(String str, int i, int i2) {
        if (this.aUf != null) {
            this.eii.n(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        this.eii = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar, aVar);
        this.eii.setScrollFragmentTabHost(this);
        this.aUf.setOffscreenPageLimit(2);
        this.aUf.setAdapter(this.eii);
        this.aUf.setCurrentItem(this.eii.oC(HomePageStatic.efj ? 0 : 1));
        this.eig.setViewPager(this.aUf);
        if (this.eid != null) {
            this.eii.setRecommendFrsNavigationAnimDispatcher(this.eid);
        }
    }

    public boolean aCE() {
        return this.eii != null && this.eii.getCount() > 0;
    }

    public void H(int i, boolean z) {
        if (i >= 0 && i < this.eii.getCount()) {
            this.eig.setTabItemClicked(z);
            this.eii.oG(i);
            this.aUf.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        H(this.eii.oC(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eig.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentItem() {
        return this.aUf.getCurrentItem();
    }

    public int getCurrentTabType() {
        return this.eii.oB(this.aUf.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.aUf.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.eii.oB(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int oJ(int i) {
        return this.eii.oB(i);
    }

    public aj getCurrentFragment() {
        return this.eii.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.util.aj.t(this, d.C0141d.cp_bg_line_d);
        com.baidu.tbadk.core.util.aj.t(this.eif, d.C0141d.cp_bg_line_d);
        this.eig.onChangeSkinType();
        if (this.mPageContext != null && this.caX != null) {
            this.caX.onChangeSkinType(this.mPageContext, i);
        }
        if (this.eii != null) {
            this.eii.gB(i);
        }
        if (this.mPageContext != null && this.dpj != null) {
            this.dpj.onChangeSkinType(this.mPageContext, i);
        }
        com.baidu.tbadk.core.util.aj.t(this.eih, d.C0141d.cp_bg_line_d);
        com.baidu.tbadk.core.util.aj.t(this.bQn, d.C0141d.cp_bg_line_c);
    }

    public void aCB() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.eii != null) {
            this.eii.aCB();
        }
        if ((currentTabType == 1 || currentTabType == 3) && this.eii != null) {
            this.eii.aCB();
        }
    }

    public void XK() {
        this.eii.XK();
    }

    public String getCurrentPageKey() {
        if (this.eii != null) {
            return this.eii.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.aUf != null) {
            return this.aUf.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.eii != null) {
            this.eii.setPrimary(z);
        }
        if (this.caX != null && z) {
            this.caX.setVisibility(j.ox() ? 8 : 0);
        }
    }

    public void aCF() {
        this.eii.a(this.eim);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.eij = aVar;
    }

    public void onDestroy() {
        if (this.eid != null) {
            this.eid.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.eig != null && this.eii.aCz()) {
            this.eig.setShowConcernRedTip(z);
        }
    }

    public boolean aCC() {
        if (this.eig == null || !this.eii.aCz()) {
            return false;
        }
        return this.eig.aCC();
    }

    public void setVideoThreadId(String str) {
        if (this.eii != null) {
            this.eii.setVideoThreadId(str);
        }
    }
}
