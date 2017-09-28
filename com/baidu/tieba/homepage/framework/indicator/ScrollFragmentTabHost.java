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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.util.q;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.layout.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.homepage.framework.d;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private final e aQh;
    private View aWX;
    private CustomViewPager adV;
    private NoNetworkView bga;
    private q cXY;
    private ObservedChangeLinearLayout cXZ;
    private View cYa;
    private HomeTabBarView cYb;
    private View cYc;
    private com.baidu.tieba.homepage.framework.indicator.a cYd;
    private a cYe;
    private c cYf;
    private com.baidu.tieba.homepage.framework.e cYg;
    private d cYh;
    private PluginErrorTipView ccS;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mG;

    /* loaded from: classes.dex */
    public interface a {
        void ld(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.aQh = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.cYd != null) {
                    ScrollFragmentTabHost.this.cYd.b(view, i, i2, i3, i4);
                }
            }
        };
        this.cYf = new c();
        this.cYg = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void kT(int i) {
                ScrollFragmentTabHost.this.p(ScrollFragmentTabHost.this.cYd.kV(i), false);
                ScrollFragmentTabHost.this.cYd.kY(i);
            }
        };
        this.cYh = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void kS(int i) {
                ScrollFragmentTabHost.this.cYf.a(i, ScrollFragmentTabHost.this.cYg);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aQh = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.cYd != null) {
                    ScrollFragmentTabHost.this.cYd.b(view, i, i2, i3, i4);
                }
            }
        };
        this.cYf = new c();
        this.cYg = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void kT(int i) {
                ScrollFragmentTabHost.this.p(ScrollFragmentTabHost.this.cYd.kV(i), false);
                ScrollFragmentTabHost.this.cYd.kY(i);
            }
        };
        this.cYh = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void kS(int i) {
                ScrollFragmentTabHost.this.cYf.a(i, ScrollFragmentTabHost.this.cYg);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.j.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.cXZ = (ObservedChangeLinearLayout) findViewById(d.h.home_page_fragment_tab_layout);
        this.cYa = findViewById(d.h.home_page_statebar_view);
        this.cYb = (HomeTabBarView) findViewById(d.h.home_tab_bar_view);
        this.ccS = (PluginErrorTipView) findViewById(d.h.view_plugin_error_tip);
        this.bga = (NoNetworkView) findViewById(d.h.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.h.home_pager_container);
        this.adV = (CustomViewPager) findViewById(d.h.tab_widget_view_pager);
        this.cYc = findViewById(d.h.home_statebar_view);
        this.aWX = findViewById(d.h.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cYa.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.cXZ.setOnSizeChangeListener(this.aQh);
        this.cYb.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.cYd.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.cYe != null) {
                    ScrollFragmentTabHost.this.cYe.ld(i);
                }
                if (ScrollFragmentTabHost.this.lc(i) == 3) {
                    ak akVar = new ak("c12478");
                    akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(akVar);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean apn = ScrollFragmentTabHost.this.apn();
                    TiebaStatic.log(new ak("c12350").r("obj_type", apn ? 1 : 0));
                    if (apn && ScrollFragmentTabHost.this.cYd != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.cYd.kX(0);
                    }
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mG = tbPageContext;
        this.bga.a(aVar);
    }

    public void notifyDataSetChanged() {
        if (this.cYd != null && !HomePageStatic.cUG) {
            this.adV.setAdapter(this.cYd);
            this.cYb.notifyDataSetChanged();
            this.cYf.a(this.cYg);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.cYd != null) {
            this.cYd.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.cYd != null) {
            this.cYd.d(dataRes, z);
        }
    }

    public void aoL() {
        if (this.cYd != null) {
            this.cYd.aoL();
        }
        if (this.cYd != null && this.adV != null && this.adV.getCurrentItem() == 0) {
            this.cYd.apl();
        }
    }

    public void g(String str, int i, int i2) {
        if (this.adV != null) {
            this.cYd.g(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        this.cYd = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar, aVar);
        this.cYd.setScrollFragmentTabHost(this);
        this.adV.setOffscreenPageLimit(2);
        this.adV.setAdapter(this.cYd);
        this.adV.setCurrentItem(this.cYd.kV(HomePageStatic.cUG ? 0 : 1));
        this.cYb.setViewPager(this.adV);
        if (this.cXY != null) {
            this.cYd.setRecommendFrsNavigationAnimDispatcher(this.cXY);
        }
    }

    public boolean app() {
        return this.cYd != null && this.cYd.getCount() > 0;
    }

    public void p(int i, boolean z) {
        if (i >= 0 && i < this.cYd.getCount()) {
            this.cYb.setTabItemClicked(z);
            this.cYd.kZ(i);
            this.adV.setCurrentItem(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cYb.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentItem() {
        return this.adV.getCurrentItem();
    }

    public int getCurrentTabType() {
        return this.cYd.kU(this.adV.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.adV.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.cYd.kU(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int lc(int i) {
        return this.cYd.kU(i);
    }

    public ai getCurrentFragment() {
        return this.cYd.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        aj.k(this, d.e.cp_bg_line_d);
        aj.k(this.cYa, d.e.cp_bg_line_d);
        this.cYb.onChangeSkinType();
        if (this.mG != null && this.bga != null) {
            this.bga.onChangeSkinType(this.mG, i);
        }
        if (this.cYd != null) {
            this.cYd.dE(i);
        }
        if (this.mG != null && this.ccS != null) {
            this.ccS.onChangeSkinType(this.mG, i);
        }
        aj.k(this.cYc, d.e.cp_bg_line_d);
        aj.k(this.aWX, d.e.cp_bg_line_c);
    }

    public void apm() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.cYd != null) {
            this.cYd.apm();
        }
        if ((currentTabType == 1 || currentTabType == 3) && this.cYd != null) {
            this.cYd.apm();
        }
    }

    public void aoK() {
        this.cYd.aoK();
    }

    public String getCurrentPageKey() {
        if (this.cYd != null) {
            return this.cYd.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.adV != null) {
            return this.adV.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.cYd != null) {
            this.cYd.setPrimary(z);
        }
        if (this.bga != null && z) {
            this.bga.setVisibility(j.gV() ? 8 : 0);
        }
    }

    public void apq() {
        this.cYd.a(this.cYh);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cYe = aVar;
    }

    public void onDestroy() {
        if (this.cXY != null) {
            this.cXY.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.cYb != null && this.cYd.apk()) {
            this.cYb.setShowConcernRedTip(z);
        }
    }

    public boolean apn() {
        if (this.cYb == null || !this.cYd.apk()) {
            return false;
        }
        return this.cYb.apn();
    }

    public void setVideoThreadId(String str) {
        if (this.cYd != null) {
            this.cYd.setVideoThreadId(str);
        }
    }
}
