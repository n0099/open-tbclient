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
    private final e aTj;
    private CustomViewPager aey;
    private View bas;
    private NoNetworkView bly;
    private PluginErrorTipView ctk;
    private s dqn;
    private ObservedChangeLinearLayout dqo;
    private View dqp;
    private HomeTabBarView dqq;
    private View dqr;
    private com.baidu.tieba.homepage.framework.indicator.a dqs;
    private a dqt;
    private c dqu;
    private com.baidu.tieba.homepage.framework.e dqv;
    private d dqw;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes.dex */
    public interface a {
        void lZ(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.aTj = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dqs != null) {
                    ScrollFragmentTabHost.this.dqs.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dqu = new c();
        this.dqv = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void lP(int i) {
                ScrollFragmentTabHost.this.q(ScrollFragmentTabHost.this.dqs.lR(i), false);
                ScrollFragmentTabHost.this.dqs.lU(i);
            }
        };
        this.dqw = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void lO(int i) {
                ScrollFragmentTabHost.this.dqu.a(i, ScrollFragmentTabHost.this.dqv);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aTj = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dqs != null) {
                    ScrollFragmentTabHost.this.dqs.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dqu = new c();
        this.dqv = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void lP(int i) {
                ScrollFragmentTabHost.this.q(ScrollFragmentTabHost.this.dqs.lR(i), false);
                ScrollFragmentTabHost.this.dqs.lU(i);
            }
        };
        this.dqw = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void lO(int i) {
                ScrollFragmentTabHost.this.dqu.a(i, ScrollFragmentTabHost.this.dqv);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.dqo = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.dqp = findViewById(d.g.home_page_statebar_view);
        this.dqq = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.ctk = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.bly = (NoNetworkView) findViewById(d.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.home_pager_container);
        this.aey = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.dqr = findViewById(d.g.home_statebar_view);
        this.bas = findViewById(d.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dqp.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.dqo.setOnSizeChangeListener(this.aTj);
        this.dqq.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.dqs.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.dqt != null) {
                    ScrollFragmentTabHost.this.dqt.lZ(i);
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
                    if (atZ && ScrollFragmentTabHost.this.dqs != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.dqs.lT(0);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.bly.a(aVar);
    }

    public void notifyDataSetChanged() {
        if (this.dqs != null && !HomePageStatic.dnv) {
            this.aey.setAdapter(this.dqs);
            this.dqq.notifyDataSetChanged();
            this.dqu.a(this.dqv);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dqs != null) {
            this.dqs.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dqs != null) {
            this.dqs.d(dataRes, z);
        }
    }

    public void aty() {
        if (this.dqs != null) {
            this.dqs.aty();
        }
        if (this.dqs != null && this.aey != null && this.aey.getCurrentItem() == 0) {
            this.dqs.atX();
        }
    }

    public void g(String str, int i, int i2) {
        if (this.aey != null) {
            this.dqs.g(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        this.dqs = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar, aVar);
        this.dqs.setScrollFragmentTabHost(this);
        this.aey.setOffscreenPageLimit(2);
        this.aey.setAdapter(this.dqs);
        this.aey.setCurrentItem(this.dqs.lR(HomePageStatic.dnv ? 0 : 1));
        this.dqq.setViewPager(this.aey);
        if (this.dqn != null) {
            this.dqs.setRecommendFrsNavigationAnimDispatcher(this.dqn);
        }
    }

    public boolean aub() {
        return this.dqs != null && this.dqs.getCount() > 0;
    }

    public void q(int i, boolean z) {
        if (i >= 0 && i < this.dqs.getCount()) {
            this.dqq.setTabItemClicked(z);
            this.dqs.lV(i);
            this.aey.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        q(this.dqs.lR(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dqq.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentItem() {
        return this.aey.getCurrentItem();
    }

    public int getCurrentTabType() {
        return this.dqs.lQ(this.aey.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.aey.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.dqs.lQ(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int lY(int i) {
        return this.dqs.lQ(i);
    }

    public aj getCurrentFragment() {
        return this.dqs.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.util.aj.k(this, d.C0095d.cp_bg_line_d);
        com.baidu.tbadk.core.util.aj.k(this.dqp, d.C0095d.cp_bg_line_d);
        this.dqq.onChangeSkinType();
        if (this.mPageContext != null && this.bly != null) {
            this.bly.onChangeSkinType(this.mPageContext, i);
        }
        if (this.dqs != null) {
            this.dqs.dE(i);
        }
        if (this.mPageContext != null && this.ctk != null) {
            this.ctk.onChangeSkinType(this.mPageContext, i);
        }
        com.baidu.tbadk.core.util.aj.k(this.dqr, d.C0095d.cp_bg_line_d);
        com.baidu.tbadk.core.util.aj.k(this.bas, d.C0095d.cp_bg_line_c);
    }

    public void atY() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.dqs != null) {
            this.dqs.atY();
        }
        if ((currentTabType == 1 || currentTabType == 3) && this.dqs != null) {
            this.dqs.atY();
        }
    }

    public void Qo() {
        this.dqs.Qo();
    }

    public String getCurrentPageKey() {
        if (this.dqs != null) {
            return this.dqs.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.aey != null) {
            return this.aey.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.dqs != null) {
            this.dqs.setPrimary(z);
        }
        if (this.bly != null && z) {
            this.bly.setVisibility(j.gV() ? 8 : 0);
        }
    }

    public void auc() {
        this.dqs.a(this.dqw);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dqt = aVar;
    }

    public void onDestroy() {
        if (this.dqn != null) {
            this.dqn.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.dqq != null && this.dqs.atW()) {
            this.dqq.setShowConcernRedTip(z);
        }
    }

    public boolean atZ() {
        if (this.dqq == null || !this.dqs.atW()) {
            return false;
        }
        return this.dqq.atZ();
    }

    public void setVideoThreadId(String str) {
        if (this.dqs != null) {
            this.dqs.setVideoThreadId(str);
        }
    }
}
