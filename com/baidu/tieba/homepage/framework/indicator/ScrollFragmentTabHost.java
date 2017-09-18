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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.util.r;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tbadk.widget.layout.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.concern.c;
import com.baidu.tieba.homepage.framework.d;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private final e aPc;
    private CustomViewPager aey;
    private NoNetworkView bem;
    private PluginErrorTipView ccR;
    private View dbA;
    private HomeTabBarView dbB;
    private View dbC;
    private com.baidu.tieba.homepage.framework.indicator.a dbD;
    private List<com.baidu.tieba.homepage.b.a.a> dbE;
    private a dbF;
    private c dbG;
    private com.baidu.tieba.homepage.framework.e dbH;
    private d dbI;
    private r dby;
    private ObservedChangeLinearLayout dbz;
    private Context mContext;
    private TbPageContext mF;
    private FrameLayout mFrameLayout;

    /* loaded from: classes.dex */
    public interface a {
        void li(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.aPc = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dbD != null) {
                    ScrollFragmentTabHost.this.dbD.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dbG = new c();
        this.dbH = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void kX(int i) {
                ScrollFragmentTabHost.this.r(ScrollFragmentTabHost.this.dbD.la(i), false);
                ScrollFragmentTabHost.this.dbD.ld(i);
            }
        };
        this.dbI = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void kW(int i) {
                ScrollFragmentTabHost.this.dbG.a(i, ScrollFragmentTabHost.this.dbH);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aPc = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.dbD != null) {
                    ScrollFragmentTabHost.this.dbD.b(view, i, i2, i3, i4);
                }
            }
        };
        this.dbG = new c();
        this.dbH = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void kX(int i) {
                ScrollFragmentTabHost.this.r(ScrollFragmentTabHost.this.dbD.la(i), false);
                ScrollFragmentTabHost.this.dbD.ld(i);
            }
        };
        this.dbI = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void kW(int i) {
                ScrollFragmentTabHost.this.dbG.a(i, ScrollFragmentTabHost.this.dbH);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.j.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.dbz = (ObservedChangeLinearLayout) findViewById(d.h.home_page_fragment_tab_layout);
        this.dbA = findViewById(d.h.home_page_statebar_view);
        this.dbB = (HomeTabBarView) findViewById(d.h.home_tab_bar_view);
        this.ccR = (PluginErrorTipView) findViewById(d.h.view_plugin_error_tip);
        this.bem = (NoNetworkView) findViewById(d.h.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.h.home_pager_container);
        this.aey = (CustomViewPager) findViewById(d.h.tab_widget_view_pager);
        this.dbC = findViewById(d.h.home_statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dbA.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.dbz.setOnSizeChangeListener(this.aPc);
        this.dbB.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.dbD.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.dbF != null) {
                    ScrollFragmentTabHost.this.dbF.li(i);
                }
                if (ScrollFragmentTabHost.this.dbE != null && ScrollFragmentTabHost.this.dbE.size() > i && ScrollFragmentTabHost.this.dbE.get(i) != null) {
                    if (((com.baidu.tieba.homepage.b.a.a) ScrollFragmentTabHost.this.dbE.get(i)).deO == -2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, true));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, false));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean aqG = ScrollFragmentTabHost.this.aqG();
                    TiebaStatic.log(new ak("c12350").r("obj_type", aqG ? 1 : 0));
                    if (aqG && ScrollFragmentTabHost.this.dbD != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.dbD.lc(0);
                    }
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mF = tbPageContext;
        this.bem.a(aVar);
    }

    public boolean aqI() {
        return v.u(this.dbE) <= 0;
    }

    public void bz(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (list != null && list.size() > 0) {
            this.dbE = list;
            notifyDataSetChanged();
        }
    }

    public List<com.baidu.tieba.homepage.b.a.a> getTagList() {
        return this.dbE;
    }

    public void notifyDataSetChanged() {
        if (this.dbD != null && !HomePageStatic.cYo) {
            this.dbD.by(this.dbE);
            this.aey.setAdapter(this.dbD);
            this.dbB.notifyDataSetChanged();
            this.dbG.a(this.dbH);
        }
    }

    public void O(String str, int i) {
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.dbD != null) {
            this.dbD.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.dbD != null) {
            this.dbD.d(dataRes, z);
        }
    }

    public void aqi() {
        if (this.dbD != null) {
            this.dbD.aqi();
        }
    }

    public void h(String str, int i, int i2) {
        if (this.aey != null) {
            this.dbD.h(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        this.dbD = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar, aVar);
        this.dbD.setScrollFragmentTabHost(this);
        this.aey.setOffscreenPageLimit(2);
        this.aey.setAdapter(this.dbD);
        this.aey.setCurrentItem(this.dbD.la(HomePageStatic.cYo ? 0 : 1));
        this.dbB.setViewPager(this.aey);
        if (this.dby != null) {
            this.dbD.setRecommendFrsNavigationAnimDispatcher(this.dby);
        }
    }

    public boolean aqJ() {
        return this.dbD != null && this.dbD.getCount() > 0;
    }

    public void r(int i, boolean z) {
        if (i >= 0 && i < this.dbD.getCount()) {
            this.dbB.setTabItemClicked(z);
            this.dbD.le(i);
            this.aey.setCurrentItem(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dbB.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentItem() {
        return this.aey.getCurrentItem();
    }

    public int getCurrentTabType() {
        return this.dbD.kZ(this.aey.getCurrentItem());
    }

    public int lh(int i) {
        return this.dbD.kZ(i);
    }

    public ah getCurrentFragment() {
        return this.dbD.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        aj.k(this, d.e.cp_bg_line_d);
        aj.k(this.dbA, d.e.cp_bg_line_d);
        this.dbB.onChangeSkinType();
        if (this.mF != null && this.bem != null) {
            this.bem.onChangeSkinType(this.mF, i);
        }
        if (this.dbD != null) {
            this.dbD.du(i);
        }
        if (this.mF != null && this.ccR != null) {
            this.ccR.onChangeSkinType(this.mF, i);
        }
        aj.k(this.dbC, d.e.cp_bg_line_d);
    }

    public void aqF() {
        int currentTabType = getCurrentTabType();
        if ((currentTabType == 0 || currentTabType == 1) && this.dbD != null) {
            this.dbD.aqF();
        }
    }

    public void aqh() {
        this.dbD.aqh();
    }

    public String getCurrentPageKey() {
        if (this.dbD != null) {
            return this.dbD.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.aey != null) {
            return this.aey.getCurrentItem();
        }
        return -1;
    }

    public boolean bA(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (v.v(list) || v.v(this.dbE) || v.u(list) != v.u(this.dbE)) {
            return false;
        }
        for (int i = 0; i < v.u(list); i++) {
            com.baidu.tieba.homepage.b.a.a aVar = (com.baidu.tieba.homepage.b.a.a) v.c(this.dbE, i);
            com.baidu.tieba.homepage.b.a.a aVar2 = (com.baidu.tieba.homepage.b.a.a) v.c(list, i);
            if (aVar != null && aVar2 != null) {
                if (aVar.deN == null || aVar2.deN == null) {
                    return true;
                }
                if (!aVar.deN.equals(aVar2.deN)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setPrimary(boolean z) {
        if (this.dbD != null) {
            this.dbD.setPrimary(z);
        }
        if (this.bem != null && z) {
            this.bem.setVisibility(i.gW() ? 8 : 0);
        }
    }

    public void aqK() {
        this.dbD.a(this.dbI);
    }

    public void aqL() {
        this.dbG.b(this.dbH);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.dbF = aVar;
    }

    public void onDestroy() {
        if (this.dby != null) {
            this.dby.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.dbB != null && this.dbD.aqE()) {
            this.dbB.setShowConcernRedTip(z);
        }
    }

    public boolean aqG() {
        if (this.dbB == null || !this.dbD.aqE()) {
            return false;
        }
        return this.dbB.aqG();
    }
}
