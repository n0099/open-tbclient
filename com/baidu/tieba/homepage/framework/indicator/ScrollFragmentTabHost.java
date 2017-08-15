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
    private final e aPv;
    private CustomViewPager afp;
    private PluginErrorTipView bZb;
    private NoNetworkView ber;
    private r cUa;
    private ObservedChangeLinearLayout cUb;
    private View cUc;
    private HomeTabBarView cUd;
    private FrameLayout cUe;
    private View cUf;
    private com.baidu.tieba.homepage.framework.indicator.a cUg;
    private List<com.baidu.tieba.homepage.b.a.a> cUh;
    private a cUi;
    private b cUj;
    private com.baidu.tieba.homepage.framework.e cUk;
    private d cUl;
    private Context mContext;
    private TbPageContext oV;

    /* loaded from: classes.dex */
    public interface a {
        void kO(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.aPv = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.cUg != null) {
                    ScrollFragmentTabHost.this.cUg.b(view, i, i2, i3, i4);
                }
            }
        };
        this.cUj = new b();
        this.cUk = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void kH(int i) {
                ScrollFragmentTabHost.this.h(i, false);
                ScrollFragmentTabHost.this.cUg.kL(i);
            }
        };
        this.cUl = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void kG(int i) {
                ScrollFragmentTabHost.this.cUj.a(i, ScrollFragmentTabHost.this.cUk);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aPv = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.cUg != null) {
                    ScrollFragmentTabHost.this.cUg.b(view, i, i2, i3, i4);
                }
            }
        };
        this.cUj = new b();
        this.cUk = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void kH(int i) {
                ScrollFragmentTabHost.this.h(i, false);
                ScrollFragmentTabHost.this.cUg.kL(i);
            }
        };
        this.cUl = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void kG(int i) {
                ScrollFragmentTabHost.this.cUj.a(i, ScrollFragmentTabHost.this.cUk);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.j.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.cUb = (ObservedChangeLinearLayout) findViewById(d.h.home_page_fragment_tab_layout);
        this.cUc = findViewById(d.h.home_page_statebar_view);
        this.cUd = (HomeTabBarView) findViewById(d.h.home_tab_bar_view);
        this.bZb = (PluginErrorTipView) findViewById(d.h.view_plugin_error_tip);
        this.ber = (NoNetworkView) findViewById(d.h.view_no_network);
        this.cUe = (FrameLayout) findViewById(d.h.home_pager_container);
        this.afp = (CustomViewPager) findViewById(d.h.tab_widget_view_pager);
        this.cUf = findViewById(d.h.home_statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cUc.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.cUb.setOnSizeChangeListener(this.aPv);
        this.cUd.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.cUg.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.cUi != null) {
                    ScrollFragmentTabHost.this.cUi.kO(i);
                }
                if (ScrollFragmentTabHost.this.cUh != null && ScrollFragmentTabHost.this.cUh.size() > i && ScrollFragmentTabHost.this.cUh.get(i) != null) {
                    if (((com.baidu.tieba.homepage.b.a.a) ScrollFragmentTabHost.this.cUh.get(i)).cXl == -2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, true));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, false));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentItem() == com.baidu.tieba.homepage.framework.indicator.a.cTQ) {
                    boolean aoS = ScrollFragmentTabHost.this.aoS();
                    TiebaStatic.log(new aj("c12350").r("obj_type", aoS ? 1 : 0));
                    if (aoS && ScrollFragmentTabHost.this.cUg != null) {
                        ScrollFragmentTabHost.this.setShowConcernRedTip(false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        ScrollFragmentTabHost.this.cUg.kK(com.baidu.tieba.homepage.framework.indicator.a.cTQ);
                    }
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.oV = tbPageContext;
        this.ber.a(aVar);
    }

    public boolean aoT() {
        return u.u(this.cUh) <= 0;
    }

    public void bu(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (list != null && list.size() > 0) {
            this.cUh = list;
            notifyDataSetChanged();
        }
    }

    public List<com.baidu.tieba.homepage.b.a.a> getTagList() {
        return this.cUh;
    }

    public void notifyDataSetChanged() {
        if (this.cUg != null) {
            this.cUg.bt(this.cUh);
            this.afp.setAdapter(this.cUg);
            this.cUd.notifyDataSetChanged();
            this.cUj.a(this.cUk);
        }
    }

    public void O(String str, int i) {
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.cUg != null) {
            this.cUg.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.cUg != null) {
            this.cUg.d(dataRes, z);
        }
    }

    public void aou() {
        if (this.cUg != null) {
            this.cUg.aou();
        }
    }

    public void g(String str, int i, int i2) {
        if (this.afp != null) {
            this.cUg.g(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        this.cUg = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar, aVar);
        this.cUg.setScrollFragmentTabHost(this);
        this.afp.setOffscreenPageLimit(0);
        this.afp.setAdapter(this.cUg);
        this.afp.setCurrentItem(com.baidu.tieba.homepage.framework.indicator.a.cTT);
        this.cUd.setViewPager(this.afp);
        if (this.cUa != null) {
            this.cUg.setRecommendFrsNavigationAnimDispatcher(this.cUa);
        }
    }

    public boolean aoU() {
        return this.cUg != null && this.cUg.getCount() > 0;
    }

    public void h(int i, boolean z) {
        if (i >= 0 && i < this.cUg.getCount()) {
            this.cUd.setTabItemClicked(z);
            this.cUg.kM(i);
            this.afp.setCurrentItem(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cUd.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.cUe;
    }

    public int getCurrentItem() {
        return this.afp.getCurrentItem();
    }

    public ah getCurrentFragment() {
        return this.cUg.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        ai.k(this, d.e.cp_bg_line_d);
        ai.k(this.cUc, d.e.cp_bg_line_d);
        this.cUd.onChangeSkinType();
        if (this.oV != null && this.ber != null) {
            this.ber.onChangeSkinType(this.oV, i);
        }
        if (this.cUg != null) {
            this.cUg.dt(i);
        }
        if (this.oV != null && this.bZb != null) {
            this.bZb.onChangeSkinType(this.oV, i);
        }
        ai.k(this.cUf, d.e.cp_bg_line_d);
    }

    public void aoR() {
        if (this.cUg != null) {
            if (this.afp.getCurrentItem() == com.baidu.tieba.homepage.framework.indicator.a.cTR || this.afp.getCurrentItem() == com.baidu.tieba.homepage.framework.indicator.a.cTQ) {
                this.cUg.aoR();
            }
        }
    }

    public void aot() {
        this.cUg.aot();
    }

    public String getCurrentPageKey() {
        if (this.cUg != null) {
            return this.cUg.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.afp != null) {
            return this.afp.getCurrentItem();
        }
        return -1;
    }

    public boolean bv(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (u.v(list) || u.v(this.cUh) || u.u(list) != u.u(this.cUh)) {
            return false;
        }
        for (int i = 0; i < u.u(list); i++) {
            com.baidu.tieba.homepage.b.a.a aVar = (com.baidu.tieba.homepage.b.a.a) u.c(this.cUh, i);
            com.baidu.tieba.homepage.b.a.a aVar2 = (com.baidu.tieba.homepage.b.a.a) u.c(list, i);
            if (aVar != null && aVar2 != null) {
                if (aVar.cXk == null || aVar2.cXk == null) {
                    return true;
                }
                if (!aVar.cXk.equals(aVar2.cXk)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setPrimary(boolean z) {
        if (this.cUg != null) {
            this.cUg.setPrimary(z);
        }
        if (this.ber != null && z) {
            this.ber.setVisibility(i.hf() ? 8 : 0);
        }
    }

    public void aoV() {
        this.cUg.a(this.cUl);
    }

    public void aoW() {
        this.cUj.b(this.cUk);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cUi = aVar;
    }

    public void onDestroy() {
        if (this.cUa != null) {
            this.cUa.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.cUd != null) {
            this.cUd.setShowConcernRedTip(z);
        }
    }

    public boolean aoS() {
        if (this.cUd != null) {
            return this.cUd.aoS();
        }
        return false;
    }
}
