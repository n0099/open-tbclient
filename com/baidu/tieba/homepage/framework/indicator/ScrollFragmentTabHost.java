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
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private final e aTg;
    private CustomViewPager aev;
    private View ban;
    private NoNetworkView blu;
    private PluginErrorTipView ctg;
    private s dqj;
    private ObservedChangeLinearLayout dqk;
    private View dql;
    private HomeTabBarView dqm;
    private View dqn;
    private com.baidu.tieba.homepage.framework.indicator.a dqo;
    private a dqp;
    private c dqq;
    private com.baidu.tieba.homepage.framework.e dqr;
    private d dqs;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes.dex */
    public interface a {
        void lZ(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.aTg = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dqo != null) {
                    ScrollFragmentTabHost.this.dqo.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dqq = new c();
        this.dqr = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void lP(int i) {
                ScrollFragmentTabHost.this.q(ScrollFragmentTabHost.this.dqo.lR(i), false);
                ScrollFragmentTabHost.this.dqo.lU(i);
            }
        };
        this.dqs = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void lO(int i) {
                ScrollFragmentTabHost.this.dqq.a(i, ScrollFragmentTabHost.this.dqr);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aTg = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dqo != null) {
                    ScrollFragmentTabHost.this.dqo.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dqq = new c();
        this.dqr = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void lP(int i) {
                ScrollFragmentTabHost.this.q(ScrollFragmentTabHost.this.dqo.lR(i), false);
                ScrollFragmentTabHost.this.dqo.lU(i);
            }
        };
        this.dqs = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void lO(int i) {
                ScrollFragmentTabHost.this.dqq.a(i, ScrollFragmentTabHost.this.dqr);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.dqk = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.dql = findViewById(d.g.home_page_statebar_view);
        this.dqm = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.ctg = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.blu = (NoNetworkView) findViewById(d.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.home_pager_container);
        this.aev = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.dqn = findViewById(d.g.home_statebar_view);
        this.ban = findViewById(d.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dql.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.dqk.setOnSizeChangeListener(this.aTg);
        this.dqm.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.dqo.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.dqp != null) {
                    ScrollFragmentTabHost.this.dqp.lZ(i);
                }
                if (ScrollFragmentTabHost.this.lY(i) == 3) {
                    ak akVar = new ak("c12478");
                    akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(akVar);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean atZ = ScrollFragmentTabHost.this.atZ();
                    TiebaStatic.log(new ak("c12350").r("obj_type", atZ ? 1 : 0));
                    if (atZ && ScrollFragmentTabHost.this.dqo != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.dqo.lT(0);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.blu.a(aVar);
    }

    public void notifyDataSetChanged() {
        if (this.dqo != null && !HomePageStatic.dnr) {
            this.aev.setAdapter(this.dqo);
            this.dqm.notifyDataSetChanged();
            this.dqq.a(this.dqr);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dqo != null) {
            this.dqo.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dqo != null) {
            this.dqo.d(dataRes, z);
        }
    }

    public void aty() {
        if (this.dqo != null) {
            this.dqo.aty();
        }
        if (this.dqo != null && this.aev != null && this.aev.getCurrentItem() == 0) {
            this.dqo.atX();
        }
    }

    public void g(String str, int i, int i2) {
        if (this.aev != null) {
            this.dqo.g(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        this.dqo = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar, aVar);
        this.dqo.setScrollFragmentTabHost(this);
        this.aev.setOffscreenPageLimit(2);
        this.aev.setAdapter(this.dqo);
        this.aev.setCurrentItem(this.dqo.lR(HomePageStatic.dnr ? 0 : 1));
        this.dqm.setViewPager(this.aev);
        if (this.dqj != null) {
            this.dqo.setRecommendFrsNavigationAnimDispatcher(this.dqj);
        }
    }

    public boolean aub() {
        return this.dqo != null && this.dqo.getCount() > 0;
    }

    public void q(int i, boolean z) {
        if (i >= 0 && i < this.dqo.getCount()) {
            this.dqm.setTabItemClicked(z);
            this.dqo.lV(i);
            this.aev.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        q(this.dqo.lR(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dqm.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentItem() {
        return this.aev.getCurrentItem();
    }

    public int getCurrentTabType() {
        return this.dqo.lQ(this.aev.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.aev.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.dqo.lQ(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int lY(int i) {
        return this.dqo.lQ(i);
    }

    public aj getCurrentFragment() {
        return this.dqo.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.util.aj.k(this, d.C0096d.cp_bg_line_d);
        com.baidu.tbadk.core.util.aj.k(this.dql, d.C0096d.cp_bg_line_d);
        this.dqm.onChangeSkinType();
        if (this.mPageContext != null && this.blu != null) {
            this.blu.onChangeSkinType(this.mPageContext, i);
        }
        if (this.dqo != null) {
            this.dqo.dE(i);
        }
        if (this.mPageContext != null && this.ctg != null) {
            this.ctg.onChangeSkinType(this.mPageContext, i);
        }
        com.baidu.tbadk.core.util.aj.k(this.dqn, d.C0096d.cp_bg_line_d);
        com.baidu.tbadk.core.util.aj.k(this.ban, d.C0096d.cp_bg_line_c);
    }

    public void atY() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.dqo != null) {
            this.dqo.atY();
        }
        if ((currentTabType == 1 || currentTabType == 3) && this.dqo != null) {
            this.dqo.atY();
        }
    }

    public void Qo() {
        this.dqo.Qo();
    }

    public String getCurrentPageKey() {
        if (this.dqo != null) {
            return this.dqo.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.aev != null) {
            return this.aev.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.dqo != null) {
            this.dqo.setPrimary(z);
        }
        if (this.blu != null && z) {
            this.blu.setVisibility(j.gV() ? 8 : 0);
        }
    }

    public void auc() {
        this.dqo.a(this.dqs);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dqp = aVar;
    }

    public void onDestroy() {
        if (this.dqj != null) {
            this.dqj.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.dqm != null && this.dqo.atW()) {
            this.dqm.setShowConcernRedTip(z);
        }
    }

    public boolean atZ() {
        if (this.dqm == null || !this.dqo.atW()) {
            return false;
        }
        return this.dqm.atZ();
    }

    public void setVideoThreadId(String str) {
        if (this.dqo != null) {
            this.dqo.setVideoThreadId(str);
        }
    }
}
