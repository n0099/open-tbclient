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
    private final e aPY;
    private View aXa;
    private CustomViewPager aeg;
    private NoNetworkView bgD;
    private PluginErrorTipView ckc;
    private s dge;
    private ObservedChangeLinearLayout dgf;
    private View dgg;
    private HomeTabBarView dgh;
    private View dgi;
    private com.baidu.tieba.homepage.framework.indicator.a dgj;
    private a dgk;
    private c dgl;
    private com.baidu.tieba.homepage.framework.e dgm;
    private d dgn;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes.dex */
    public interface a {
        void lu(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.aPY = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dgj != null) {
                    ScrollFragmentTabHost.this.dgj.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dgl = new c();
        this.dgm = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void lk(int i) {
                ScrollFragmentTabHost.this.q(ScrollFragmentTabHost.this.dgj.lm(i), false);
                ScrollFragmentTabHost.this.dgj.lp(i);
            }
        };
        this.dgn = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void lj(int i) {
                ScrollFragmentTabHost.this.dgl.a(i, ScrollFragmentTabHost.this.dgm);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aPY = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dgj != null) {
                    ScrollFragmentTabHost.this.dgj.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dgl = new c();
        this.dgm = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void lk(int i) {
                ScrollFragmentTabHost.this.q(ScrollFragmentTabHost.this.dgj.lm(i), false);
                ScrollFragmentTabHost.this.dgj.lp(i);
            }
        };
        this.dgn = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void lj(int i) {
                ScrollFragmentTabHost.this.dgl.a(i, ScrollFragmentTabHost.this.dgm);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.dgf = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.dgg = findViewById(d.g.home_page_statebar_view);
        this.dgh = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.ckc = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.bgD = (NoNetworkView) findViewById(d.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.home_pager_container);
        this.aeg = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.dgi = findViewById(d.g.home_statebar_view);
        this.aXa = findViewById(d.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dgg.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.dgf.setOnSizeChangeListener(this.aPY);
        this.dgh.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.dgj.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.dgk != null) {
                    ScrollFragmentTabHost.this.dgk.lu(i);
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
                    boolean arH = ScrollFragmentTabHost.this.arH();
                    TiebaStatic.log(new ak("c12350").r("obj_type", arH ? 1 : 0));
                    if (arH && ScrollFragmentTabHost.this.dgj != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.dgj.lo(0);
                    }
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.bgD.a(aVar);
    }

    public void notifyDataSetChanged() {
        if (this.dgj != null && !HomePageStatic.ddm) {
            this.aeg.setAdapter(this.dgj);
            this.dgh.notifyDataSetChanged();
            this.dgl.a(this.dgm);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dgj != null) {
            this.dgj.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dgj != null) {
            this.dgj.d(dataRes, z);
        }
    }

    public void arg() {
        if (this.dgj != null) {
            this.dgj.arg();
        }
        if (this.dgj != null && this.aeg != null && this.aeg.getCurrentItem() == 0) {
            this.dgj.arF();
        }
    }

    public void g(String str, int i, int i2) {
        if (this.aeg != null) {
            this.dgj.g(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        this.dgj = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar, aVar);
        this.dgj.setScrollFragmentTabHost(this);
        this.aeg.setOffscreenPageLimit(2);
        this.aeg.setAdapter(this.dgj);
        this.aeg.setCurrentItem(this.dgj.lm(HomePageStatic.ddm ? 0 : 1));
        this.dgh.setViewPager(this.aeg);
        if (this.dge != null) {
            this.dgj.setRecommendFrsNavigationAnimDispatcher(this.dge);
        }
    }

    public boolean arJ() {
        return this.dgj != null && this.dgj.getCount() > 0;
    }

    public void q(int i, boolean z) {
        if (i >= 0 && i < this.dgj.getCount()) {
            this.dgh.setTabItemClicked(z);
            this.dgj.lq(i);
            this.aeg.setCurrentItem(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dgh.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentItem() {
        return this.aeg.getCurrentItem();
    }

    public int getCurrentTabType() {
        return this.dgj.ll(this.aeg.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.aeg.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.dgj.ll(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int lt(int i) {
        return this.dgj.ll(i);
    }

    public ai getCurrentFragment() {
        return this.dgj.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        aj.k(this, d.C0080d.cp_bg_line_d);
        aj.k(this.dgg, d.C0080d.cp_bg_line_d);
        this.dgh.onChangeSkinType();
        if (this.mPageContext != null && this.bgD != null) {
            this.bgD.onChangeSkinType(this.mPageContext, i);
        }
        if (this.dgj != null) {
            this.dgj.dE(i);
        }
        if (this.mPageContext != null && this.ckc != null) {
            this.ckc.onChangeSkinType(this.mPageContext, i);
        }
        aj.k(this.dgi, d.C0080d.cp_bg_line_d);
        aj.k(this.aXa, d.C0080d.cp_bg_line_c);
    }

    public void arG() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.dgj != null) {
            this.dgj.arG();
        }
        if ((currentTabType == 1 || currentTabType == 3) && this.dgj != null) {
            this.dgj.arG();
        }
    }

    public void OQ() {
        this.dgj.OQ();
    }

    public String getCurrentPageKey() {
        if (this.dgj != null) {
            return this.dgj.getCurrentPageKey();
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
        if (this.dgj != null) {
            this.dgj.setPrimary(z);
        }
        if (this.bgD != null && z) {
            this.bgD.setVisibility(j.gV() ? 8 : 0);
        }
    }

    public void arK() {
        this.dgj.a(this.dgn);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dgk = aVar;
    }

    public void onDestroy() {
        if (this.dge != null) {
            this.dge.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.dgh != null && this.dgj.arE()) {
            this.dgh.setShowConcernRedTip(z);
        }
    }

    public boolean arH() {
        if (this.dgh == null || !this.dgj.arE()) {
            return false;
        }
        return this.dgh.arH();
    }

    public void setVideoThreadId(String str) {
        if (this.dgj != null) {
            this.dgj.setVideoThreadId(str);
        }
    }
}
