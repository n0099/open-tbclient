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
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.layout.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.homepage.framework.d;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private final e aPu;
    private CustomViewPager afn;
    private TbPageContext alI;
    private PluginErrorTipView bYp;
    private NoNetworkView beq;
    private r cSb;
    private ObservedChangeLinearLayout cSc;
    private View cSd;
    private HomeTabBarView cSe;
    private FrameLayout cSf;
    private View cSg;
    private com.baidu.tieba.homepage.framework.indicator.a cSh;
    private List<com.baidu.tieba.homepage.b.a.a> cSi;
    private a cSj;
    private b cSk;
    private com.baidu.tieba.homepage.framework.e cSl;
    private d cSm;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void kE(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.aPu = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.cSh != null) {
                    ScrollFragmentTabHost.this.cSh.b(view, i, i2, i3, i4);
                }
            }
        };
        this.cSk = new b();
        this.cSl = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void kx(int i) {
                ScrollFragmentTabHost.this.h(i, false);
                ScrollFragmentTabHost.this.cSh.kB(i);
            }
        };
        this.cSm = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void kw(int i) {
                ScrollFragmentTabHost.this.cSk.a(i, ScrollFragmentTabHost.this.cSl);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aPu = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.cSh != null) {
                    ScrollFragmentTabHost.this.cSh.b(view, i, i2, i3, i4);
                }
            }
        };
        this.cSk = new b();
        this.cSl = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void kx(int i) {
                ScrollFragmentTabHost.this.h(i, false);
                ScrollFragmentTabHost.this.cSh.kB(i);
            }
        };
        this.cSm = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void kw(int i) {
                ScrollFragmentTabHost.this.cSk.a(i, ScrollFragmentTabHost.this.cSl);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.j.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.cSc = (ObservedChangeLinearLayout) findViewById(d.h.home_page_fragment_tab_layout);
        this.cSd = findViewById(d.h.home_page_statebar_view);
        this.cSe = (HomeTabBarView) findViewById(d.h.home_tab_bar_view);
        this.bYp = (PluginErrorTipView) findViewById(d.h.view_plugin_error_tip);
        this.beq = (NoNetworkView) findViewById(d.h.view_no_network);
        this.cSf = (FrameLayout) findViewById(d.h.home_pager_container);
        this.afn = (CustomViewPager) findViewById(d.h.tab_widget_view_pager);
        this.cSg = findViewById(d.h.home_statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cSd.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.cSc.setOnSizeChangeListener(this.aPu);
        this.cSe.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.cSh.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.cSj != null) {
                    ScrollFragmentTabHost.this.cSj.kE(i);
                }
                if (ScrollFragmentTabHost.this.cSi != null && ScrollFragmentTabHost.this.cSi.size() > i && ScrollFragmentTabHost.this.cSi.get(i) != null) {
                    if (((com.baidu.tieba.homepage.b.a.a) ScrollFragmentTabHost.this.cSi.get(i)).cVm == -2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, true));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, false));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentItem() == com.baidu.tieba.homepage.framework.indicator.a.cRR) {
                    boolean aol = ScrollFragmentTabHost.this.aol();
                    TiebaStatic.log(new aj("c12350").r("obj_type", aol ? 1 : 0));
                    if (aol && ScrollFragmentTabHost.this.cSh != null) {
                        ScrollFragmentTabHost.this.setShowConcernRedTip(false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        ScrollFragmentTabHost.this.cSh.kA(com.baidu.tieba.homepage.framework.indicator.a.cRR);
                    }
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.alI = tbPageContext;
        this.beq.a(aVar);
    }

    public boolean aom() {
        return u.u(this.cSi) <= 0;
    }

    public void br(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (list != null && list.size() > 0) {
            this.cSi = list;
            notifyDataSetChanged();
        }
    }

    public List<com.baidu.tieba.homepage.b.a.a> getTagList() {
        return this.cSi;
    }

    public void notifyDataSetChanged() {
        if (this.cSh != null) {
            this.cSh.bq(this.cSi);
            this.afn.setAdapter(this.cSh);
            this.cSe.notifyDataSetChanged();
            this.cSk.a(this.cSl);
        }
    }

    public void O(String str, int i) {
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.cSh != null) {
            this.cSh.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.cSh != null) {
            this.cSh.d(dataRes, z);
        }
    }

    public void anO() {
        if (this.cSh != null) {
            this.cSh.anO();
        }
    }

    public void g(String str, int i, int i2) {
        if (this.afn != null) {
            this.cSh.g(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        this.cSh = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar, aVar);
        this.cSh.setScrollFragmentTabHost(this);
        this.afn.setOffscreenPageLimit(0);
        this.afn.setAdapter(this.cSh);
        this.afn.setCurrentItem(com.baidu.tieba.homepage.framework.indicator.a.cRU);
        this.cSe.setViewPager(this.afn);
        if (this.cSb != null) {
            this.cSh.setRecommendFrsNavigationAnimDispatcher(this.cSb);
        }
    }

    public boolean aon() {
        return this.cSh != null && this.cSh.getCount() > 0;
    }

    public void h(int i, boolean z) {
        if (i >= 0 && i < this.cSh.getCount()) {
            this.cSe.setTabItemClicked(z);
            this.cSh.kC(i);
            this.afn.setCurrentItem(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cSe.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.cSf;
    }

    public int getCurrentItem() {
        return this.afn.getCurrentItem();
    }

    public ah getCurrentFragment() {
        return this.cSh.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        ai.k(this, d.e.cp_bg_line_d);
        ai.k(this.cSd, d.e.cp_bg_line_d);
        this.cSe.onChangeSkinType();
        if (this.alI != null && this.beq != null) {
            this.beq.onChangeSkinType(this.alI, i);
        }
        if (this.cSh != null) {
            this.cSh.dt(i);
        }
        if (this.alI != null && this.bYp != null) {
            this.bYp.onChangeSkinType(this.alI, i);
        }
        ai.k(this.cSg, d.e.cp_bg_line_d);
    }

    public void aok() {
        if (this.cSh != null) {
            if (this.afn.getCurrentItem() == com.baidu.tieba.homepage.framework.indicator.a.cRS || this.afn.getCurrentItem() == com.baidu.tieba.homepage.framework.indicator.a.cRR) {
                this.cSh.aok();
            }
        }
    }

    public void anN() {
        this.cSh.anN();
    }

    public String getCurrentPageKey() {
        if (this.cSh != null) {
            return this.cSh.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.afn != null) {
            return this.afn.getCurrentItem();
        }
        return -1;
    }

    public boolean bs(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (u.v(list) || u.v(this.cSi) || u.u(list) != u.u(this.cSi)) {
            return false;
        }
        for (int i = 0; i < u.u(list); i++) {
            com.baidu.tieba.homepage.b.a.a aVar = (com.baidu.tieba.homepage.b.a.a) u.c(this.cSi, i);
            com.baidu.tieba.homepage.b.a.a aVar2 = (com.baidu.tieba.homepage.b.a.a) u.c(list, i);
            if (aVar != null && aVar2 != null) {
                if (aVar.cVl == null || aVar2.cVl == null) {
                    return true;
                }
                if (!aVar.cVl.equals(aVar2.cVl)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setPrimary(boolean z) {
        if (this.cSh != null) {
            this.cSh.setPrimary(z);
        }
        if (this.beq != null && z) {
            this.beq.setVisibility(i.hf() ? 8 : 0);
        }
    }

    public void aoo() {
        this.cSh.a(this.cSm);
    }

    public void aop() {
        this.cSk.b(this.cSl);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cSj = aVar;
    }

    public void onDestroy() {
        if (this.cSb != null) {
            this.cSb.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.cSe != null) {
            this.cSe.setShowConcernRedTip(z);
        }
    }

    public boolean aol() {
        if (this.cSe != null) {
            return this.cSe.aol();
        }
        return false;
    }
}
