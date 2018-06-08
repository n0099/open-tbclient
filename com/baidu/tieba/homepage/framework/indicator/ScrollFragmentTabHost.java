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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.util.t;
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
    private CustomViewPager anE;
    private final d bbU;
    private View biz;
    private NoNetworkView btu;
    private PluginErrorTipView cRP;
    private t dPm;
    private ObservedChangeLinearLayout dPn;
    private View dPo;
    private HomeTabBarView dPp;
    private View dPq;
    private NewScrollFragmentAdapter dPr;
    private a dPs;
    private com.baidu.tieba.c.d dPt;
    private b dPu;
    private e dPv;
    private com.baidu.tieba.homepage.framework.d dPw;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void mv(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.bbU = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dPr != null) {
                    ScrollFragmentTabHost.this.dPr.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dPu = new b();
        this.dPv = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void ml(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.dPr.mn(i), false);
                ScrollFragmentTabHost.this.dPr.mp(i);
            }
        };
        this.dPw = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void mk(int i) {
                ScrollFragmentTabHost.this.dPu.a(i, ScrollFragmentTabHost.this.dPv);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbU = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.d
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dPr != null) {
                    ScrollFragmentTabHost.this.dPr.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dPu = new b();
        this.dPv = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void ml(int i) {
                ScrollFragmentTabHost.this.setCurrentTab(ScrollFragmentTabHost.this.dPr.mn(i), false);
                ScrollFragmentTabHost.this.dPr.mp(i);
            }
        };
        this.dPw = new com.baidu.tieba.homepage.framework.d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void mk(int i) {
                ScrollFragmentTabHost.this.dPu.a(i, ScrollFragmentTabHost.this.dPv);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.i.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.dPn = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.dPo = findViewById(d.g.home_page_statebar_view);
        this.dPp = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.cRP = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.btu = (NoNetworkView) findViewById(d.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.home_pager_container);
        this.anE = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.dPq = findViewById(d.g.home_statebar_view);
        this.biz = findViewById(d.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dPo.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.dPn.setOnSizeChangeListener(this.bbU);
        this.dPp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.dPr.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.dPs != null) {
                    ScrollFragmentTabHost.this.dPs.mv(i);
                }
                if (ScrollFragmentTabHost.this.mu(i) == 3) {
                    am amVar = new am("c12478");
                    amVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(amVar);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean aCu = ScrollFragmentTabHost.this.aCu();
                    TiebaStatic.log(new am("c12350").r("obj_type", aCu ? 1 : 0));
                    if (aCu && ScrollFragmentTabHost.this.dPr != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921058));
                        ScrollFragmentTabHost.this.dPr.aCs();
                        ScrollFragmentTabHost.this.dPr.notifyDataSetChanged();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921064));
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.btu.a(aVar);
    }

    public void notifyDataSetChanged() {
        if (this.dPr != null && !HomePageStatic.dMt) {
            this.anE.setAdapter(this.dPr);
            this.dPp.notifyDataSetChanged();
            this.dPu.a(this.dPv);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dPr != null) {
            this.dPr.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dPr != null) {
            this.dPr.d(dataRes, z);
        }
    }

    public void aBR() {
        if (this.dPr != null) {
            this.dPr.aBR();
        }
        if (this.dPr != null && this.anE != null && this.anE.getCurrentItem() == 0) {
            this.dPr.aCr();
        }
    }

    public void o(String str, int i, int i2) {
        if (this.anE != null) {
            this.dPr.o(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, ConcernPageView.a aVar) {
        this.dPr = new NewScrollFragmentAdapter(this.mContext, fragmentManager, bVar, aVar);
        this.dPr.setScrollFragmentTabHost(this);
        this.anE.setOffscreenPageLimit(2);
        this.anE.setAdapter(this.dPr);
        this.anE.setCurrentItem(this.dPr.mn(HomePageStatic.dMt ? 0 : 1));
        this.dPp.setViewPager(this.anE);
        if (this.dPm != null) {
            this.dPr.setRecommendFrsNavigationAnimDispatcher(this.dPm);
        }
    }

    public boolean aCw() {
        return this.dPr != null && this.dPr.getCount() > 0;
    }

    public void setCurrentTab(int i, boolean z) {
        if (i >= 0 && i < this.dPr.getCount()) {
            this.dPp.setTabItemClicked(z);
            this.dPr.mq(i);
            this.anE.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        setCurrentTab(this.dPr.mn(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dPp.setPageUniqueId(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentTabType() {
        return this.dPr.mm(this.anE.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.anE.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.dPr.mm(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int mu(int i) {
        return this.dPr.mm(i);
    }

    public void onChangeSkinType(int i) {
        al.j(this, d.C0141d.cp_bg_line_d);
        al.j(this.dPo, d.C0141d.cp_bg_line_d);
        this.dPp.onChangeSkinType();
        if (this.mPageContext != null && this.btu != null) {
            this.btu.onChangeSkinType(this.mPageContext, i);
        }
        if (this.dPr != null) {
            this.dPr.dC(i);
        }
        if (this.mPageContext != null && this.cRP != null) {
            this.cRP.onChangeSkinType(this.mPageContext, i);
        }
        al.j(this.dPq, d.C0141d.cp_bg_line_d);
        al.j(this.biz, d.C0141d.cp_bg_line_c);
    }

    public void aCt() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.dPr != null) {
            this.dPr.aCt();
        }
        if ((currentTabType == 1 || currentTabType == 3) && this.dPr != null) {
            this.dPr.aCt();
        }
    }

    public void TG() {
        this.dPr.TG();
    }

    public String getCurrentPageKey() {
        if (this.dPr != null) {
            return this.dPr.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.anE != null) {
            return this.anE.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.dPr != null) {
            this.dPr.setPrimary(z);
        }
        if (this.btu != null && z) {
            this.btu.setVisibility(j.jr() ? 8 : 0);
        }
    }

    public void aCx() {
        this.dPr.a(this.dPw);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dPs = aVar;
    }

    public void onDestroy() {
        if (this.dPm != null) {
            this.dPm.onDestroy();
        }
        aCz();
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.dPp != null && this.dPr.aCq()) {
            this.dPp.setShowConcernRedTip(z);
        }
    }

    public boolean aCu() {
        if (this.dPp == null || !this.dPr.aCq()) {
            return false;
        }
        return this.dPp.aCu();
    }

    public void setVideoThreadId(String str) {
        if (this.dPr != null) {
            this.dPr.setVideoThreadId(str);
        }
    }

    public void aCy() {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_concern_tab_tips_switch", 0) != 0) {
            int mn = this.dPr != null ? this.dPr.mn(0) : 0;
            if (this.dPt == null) {
                this.dPt = new com.baidu.tieba.c.d(this.mPageContext, this.dPp.mr(mn));
                this.dPt.jf(d.f.bg_tip_blue_up);
                this.dPt.je(32);
                this.dPt.eK(true);
                this.dPt.D(true);
                this.dPt.jj(l.e(this.mContext, d.e.ds16));
                this.dPt.jg(4000);
            }
            this.dPt.h(this.mContext.getString(d.k.concern_tab_thread_tips), "key_concern_tab_tips", true);
        }
    }

    public void aCz() {
        if (this.dPt != null) {
            this.dPt.akT();
        }
    }
}
