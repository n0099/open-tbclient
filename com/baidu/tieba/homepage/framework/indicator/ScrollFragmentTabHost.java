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
import com.baidu.tbadk.util.s;
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
    private final e aQg;
    private View aXj;
    private CustomViewPager aeg;
    private NoNetworkView bgM;
    private PluginErrorTipView ckt;
    private View dgA;
    private HomeTabBarView dgB;
    private View dgC;
    private com.baidu.tieba.homepage.framework.indicator.a dgD;
    private a dgE;
    private c dgF;
    private com.baidu.tieba.homepage.framework.e dgG;
    private d dgH;
    private s dgy;
    private ObservedChangeLinearLayout dgz;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes.dex */
    public interface a {
        void lu(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.aQg = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dgD != null) {
                    ScrollFragmentTabHost.this.dgD.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dgF = new c();
        this.dgG = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void lk(int i) {
                ScrollFragmentTabHost.this.r(ScrollFragmentTabHost.this.dgD.lm(i), false);
                ScrollFragmentTabHost.this.dgD.lp(i);
            }
        };
        this.dgH = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void lj(int i) {
                ScrollFragmentTabHost.this.dgF.a(i, ScrollFragmentTabHost.this.dgG);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aQg = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dgD != null) {
                    ScrollFragmentTabHost.this.dgD.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dgF = new c();
        this.dgG = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void lk(int i) {
                ScrollFragmentTabHost.this.r(ScrollFragmentTabHost.this.dgD.lm(i), false);
                ScrollFragmentTabHost.this.dgD.lp(i);
            }
        };
        this.dgH = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void lj(int i) {
                ScrollFragmentTabHost.this.dgF.a(i, ScrollFragmentTabHost.this.dgG);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.dgz = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.dgA = findViewById(d.g.home_page_statebar_view);
        this.dgB = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.ckt = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.bgM = (NoNetworkView) findViewById(d.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.home_pager_container);
        this.aeg = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.dgC = findViewById(d.g.home_statebar_view);
        this.aXj = findViewById(d.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dgA.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.dgz.setOnSizeChangeListener(this.aQg);
        this.dgB.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.dgD.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.dgE != null) {
                    ScrollFragmentTabHost.this.dgE.lu(i);
                }
                if (ScrollFragmentTabHost.this.lt(i) == 3) {
                    ak akVar = new ak("c12478");
                    akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(akVar);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean arX = ScrollFragmentTabHost.this.arX();
                    TiebaStatic.log(new ak("c12350").r("obj_type", arX ? 1 : 0));
                    if (arX && ScrollFragmentTabHost.this.dgD != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.dgD.lo(0);
                    }
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.bgM.a(aVar);
    }

    public void notifyDataSetChanged() {
        if (this.dgD != null && !HomePageStatic.ddH) {
            this.aeg.setAdapter(this.dgD);
            this.dgB.notifyDataSetChanged();
            this.dgF.a(this.dgG);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dgD != null) {
            this.dgD.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dgD != null) {
            this.dgD.d(dataRes, z);
        }
    }

    public void arw() {
        if (this.dgD != null) {
            this.dgD.arw();
        }
        if (this.dgD != null && this.aeg != null && this.aeg.getCurrentItem() == 0) {
            this.dgD.arV();
        }
    }

    public void g(String str, int i, int i2) {
        if (this.aeg != null) {
            this.dgD.g(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        this.dgD = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar, aVar);
        this.dgD.setScrollFragmentTabHost(this);
        this.aeg.setOffscreenPageLimit(2);
        this.aeg.setAdapter(this.dgD);
        this.aeg.setCurrentItem(this.dgD.lm(HomePageStatic.ddH ? 0 : 1));
        this.dgB.setViewPager(this.aeg);
        if (this.dgy != null) {
            this.dgD.setRecommendFrsNavigationAnimDispatcher(this.dgy);
        }
    }

    public boolean arZ() {
        return this.dgD != null && this.dgD.getCount() > 0;
    }

    public void r(int i, boolean z) {
        if (i >= 0 && i < this.dgD.getCount()) {
            this.dgB.setTabItemClicked(z);
            this.dgD.lq(i);
            this.aeg.setCurrentItem(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dgB.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentItem() {
        return this.aeg.getCurrentItem();
    }

    public int getCurrentTabType() {
        return this.dgD.ll(this.aeg.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.aeg.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.dgD.ll(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int lt(int i) {
        return this.dgD.ll(i);
    }

    public ai getCurrentFragment() {
        return this.dgD.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        aj.k(this, d.C0080d.cp_bg_line_d);
        aj.k(this.dgA, d.C0080d.cp_bg_line_d);
        this.dgB.onChangeSkinType();
        if (this.mPageContext != null && this.bgM != null) {
            this.bgM.onChangeSkinType(this.mPageContext, i);
        }
        if (this.dgD != null) {
            this.dgD.dD(i);
        }
        if (this.mPageContext != null && this.ckt != null) {
            this.ckt.onChangeSkinType(this.mPageContext, i);
        }
        aj.k(this.dgC, d.C0080d.cp_bg_line_d);
        aj.k(this.aXj, d.C0080d.cp_bg_line_c);
    }

    public void arW() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.dgD != null) {
            this.dgD.arW();
        }
        if ((currentTabType == 1 || currentTabType == 3) && this.dgD != null) {
            this.dgD.arW();
        }
    }

    public void Pb() {
        this.dgD.Pb();
    }

    public String getCurrentPageKey() {
        if (this.dgD != null) {
            return this.dgD.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.aeg != null) {
            return this.aeg.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.dgD != null) {
            this.dgD.setPrimary(z);
        }
        if (this.bgM != null && z) {
            this.bgM.setVisibility(j.gV() ? 8 : 0);
        }
    }

    public void asa() {
        this.dgD.a(this.dgH);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dgE = aVar;
    }

    public void onDestroy() {
        if (this.dgy != null) {
            this.dgy.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.dgB != null && this.dgD.arU()) {
            this.dgB.setShowConcernRedTip(z);
        }
    }

    public boolean arX() {
        if (this.dgB == null || !this.dgD.arU()) {
            return false;
        }
        return this.dgB.arX();
    }

    public void setVideoThreadId(String str) {
        if (this.dgD != null) {
            this.dgD.setVideoThreadId(str);
        }
    }
}
