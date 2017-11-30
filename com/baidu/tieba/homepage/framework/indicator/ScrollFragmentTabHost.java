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
    private final e aTd;
    private CustomViewPager aeB;
    private View bam;
    private NoNetworkView blt;
    private PluginErrorTipView csX;
    private s dpe;
    private ObservedChangeLinearLayout dpf;
    private View dpg;
    private HomeTabBarView dph;
    private View dpi;
    private com.baidu.tieba.homepage.framework.indicator.a dpj;
    private a dpk;
    private c dpl;
    private com.baidu.tieba.homepage.framework.e dpm;
    private d dpn;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes.dex */
    public interface a {
        void lS(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.aTd = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dpj != null) {
                    ScrollFragmentTabHost.this.dpj.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dpl = new c();
        this.dpm = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void lI(int i) {
                ScrollFragmentTabHost.this.q(ScrollFragmentTabHost.this.dpj.lK(i), false);
                ScrollFragmentTabHost.this.dpj.lN(i);
            }
        };
        this.dpn = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void lH(int i) {
                ScrollFragmentTabHost.this.dpl.a(i, ScrollFragmentTabHost.this.dpm);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aTd = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dpj != null) {
                    ScrollFragmentTabHost.this.dpj.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dpl = new c();
        this.dpm = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void lI(int i) {
                ScrollFragmentTabHost.this.q(ScrollFragmentTabHost.this.dpj.lK(i), false);
                ScrollFragmentTabHost.this.dpj.lN(i);
            }
        };
        this.dpn = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void lH(int i) {
                ScrollFragmentTabHost.this.dpl.a(i, ScrollFragmentTabHost.this.dpm);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.dpf = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.dpg = findViewById(d.g.home_page_statebar_view);
        this.dph = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.csX = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.blt = (NoNetworkView) findViewById(d.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.home_pager_container);
        this.aeB = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.dpi = findViewById(d.g.home_statebar_view);
        this.bam = findViewById(d.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dpg.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.dpf.setOnSizeChangeListener(this.aTd);
        this.dph.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.dpj.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.dpk != null) {
                    ScrollFragmentTabHost.this.dpk.lS(i);
                }
                if (ScrollFragmentTabHost.this.lR(i) == 3) {
                    ak akVar = new ak("c12478");
                    akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(akVar);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean atQ = ScrollFragmentTabHost.this.atQ();
                    TiebaStatic.log(new ak("c12350").r("obj_type", atQ ? 1 : 0));
                    if (atQ && ScrollFragmentTabHost.this.dpj != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.dpj.lM(0);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.blt.a(aVar);
    }

    public void notifyDataSetChanged() {
        if (this.dpj != null && !HomePageStatic.dmm) {
            this.aeB.setAdapter(this.dpj);
            this.dph.notifyDataSetChanged();
            this.dpl.a(this.dpm);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dpj != null) {
            this.dpj.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dpj != null) {
            this.dpj.d(dataRes, z);
        }
    }

    public void atp() {
        if (this.dpj != null) {
            this.dpj.atp();
        }
        if (this.dpj != null && this.aeB != null && this.aeB.getCurrentItem() == 0) {
            this.dpj.atO();
        }
    }

    public void g(String str, int i, int i2) {
        if (this.aeB != null) {
            this.dpj.g(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        this.dpj = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar, aVar);
        this.dpj.setScrollFragmentTabHost(this);
        this.aeB.setOffscreenPageLimit(2);
        this.aeB.setAdapter(this.dpj);
        this.aeB.setCurrentItem(this.dpj.lK(HomePageStatic.dmm ? 0 : 1));
        this.dph.setViewPager(this.aeB);
        if (this.dpe != null) {
            this.dpj.setRecommendFrsNavigationAnimDispatcher(this.dpe);
        }
    }

    public boolean atS() {
        return this.dpj != null && this.dpj.getCount() > 0;
    }

    public void q(int i, boolean z) {
        if (i >= 0 && i < this.dpj.getCount()) {
            this.dph.setTabItemClicked(z);
            this.dpj.lO(i);
            this.aeB.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        q(this.dpj.lK(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dph.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentItem() {
        return this.aeB.getCurrentItem();
    }

    public int getCurrentTabType() {
        return this.dpj.lJ(this.aeB.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.aeB.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.dpj.lJ(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int lR(int i) {
        return this.dpj.lJ(i);
    }

    public ai getCurrentFragment() {
        return this.dpj.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        aj.k(this, d.C0082d.cp_bg_line_d);
        aj.k(this.dpg, d.C0082d.cp_bg_line_d);
        this.dph.onChangeSkinType();
        if (this.mPageContext != null && this.blt != null) {
            this.blt.onChangeSkinType(this.mPageContext, i);
        }
        if (this.dpj != null) {
            this.dpj.dE(i);
        }
        if (this.mPageContext != null && this.csX != null) {
            this.csX.onChangeSkinType(this.mPageContext, i);
        }
        aj.k(this.dpi, d.C0082d.cp_bg_line_d);
        aj.k(this.bam, d.C0082d.cp_bg_line_c);
    }

    public void atP() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.dpj != null) {
            this.dpj.atP();
        }
        if ((currentTabType == 1 || currentTabType == 3) && this.dpj != null) {
            this.dpj.atP();
        }
    }

    public void Qo() {
        this.dpj.Qo();
    }

    public String getCurrentPageKey() {
        if (this.dpj != null) {
            return this.dpj.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.aeB != null) {
            return this.aeB.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.dpj != null) {
            this.dpj.setPrimary(z);
        }
        if (this.blt != null && z) {
            this.blt.setVisibility(j.gV() ? 8 : 0);
        }
    }

    public void atT() {
        this.dpj.a(this.dpn);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dpk = aVar;
    }

    public void onDestroy() {
        if (this.dpe != null) {
            this.dpe.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.dph != null && this.dpj.atN()) {
            this.dph.setShowConcernRedTip(z);
        }
    }

    public boolean atQ() {
        if (this.dph == null || !this.dpj.atN()) {
            return false;
        }
        return this.dph.atQ();
    }

    public void setVideoThreadId(String str) {
        if (this.dpj != null) {
            this.dpj.setVideoThreadId(str);
        }
    }
}
