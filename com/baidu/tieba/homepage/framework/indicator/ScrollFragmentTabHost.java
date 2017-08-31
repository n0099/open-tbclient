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
    private final e aPf;
    private CustomViewPager aey;
    private NoNetworkView bep;
    private PluginErrorTipView cbZ;
    private r daE;
    private ObservedChangeLinearLayout daF;
    private View daG;
    private HomeTabBarView daH;
    private View daI;
    private com.baidu.tieba.homepage.framework.indicator.a daJ;
    private List<com.baidu.tieba.homepage.b.a.a> daK;
    private a daL;
    private c daM;
    private com.baidu.tieba.homepage.framework.e daN;
    private d daO;
    private Context mContext;
    private TbPageContext mF;
    private FrameLayout mFrameLayout;

    /* loaded from: classes.dex */
    public interface a {
        void lg(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.aPf = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.daJ != null) {
                    ScrollFragmentTabHost.this.daJ.b(view, i, i2, i3, i4);
                }
            }
        };
        this.daM = new c();
        this.daN = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void kV(int i) {
                ScrollFragmentTabHost.this.r(ScrollFragmentTabHost.this.daJ.kY(i), false);
                ScrollFragmentTabHost.this.daJ.lb(i);
            }
        };
        this.daO = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void kU(int i) {
                ScrollFragmentTabHost.this.daM.a(i, ScrollFragmentTabHost.this.daN);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aPf = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.daJ != null) {
                    ScrollFragmentTabHost.this.daJ.b(view, i, i2, i3, i4);
                }
            }
        };
        this.daM = new c();
        this.daN = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void kV(int i) {
                ScrollFragmentTabHost.this.r(ScrollFragmentTabHost.this.daJ.kY(i), false);
                ScrollFragmentTabHost.this.daJ.lb(i);
            }
        };
        this.daO = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void kU(int i) {
                ScrollFragmentTabHost.this.daM.a(i, ScrollFragmentTabHost.this.daN);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.j.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.daF = (ObservedChangeLinearLayout) findViewById(d.h.home_page_fragment_tab_layout);
        this.daG = findViewById(d.h.home_page_statebar_view);
        this.daH = (HomeTabBarView) findViewById(d.h.home_tab_bar_view);
        this.cbZ = (PluginErrorTipView) findViewById(d.h.view_plugin_error_tip);
        this.bep = (NoNetworkView) findViewById(d.h.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.h.home_pager_container);
        this.aey = (CustomViewPager) findViewById(d.h.tab_widget_view_pager);
        this.daI = findViewById(d.h.home_statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.daG.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.daF.setOnSizeChangeListener(this.aPf);
        this.daH.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.daJ.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.daL != null) {
                    ScrollFragmentTabHost.this.daL.lg(i);
                }
                if (ScrollFragmentTabHost.this.daK != null && ScrollFragmentTabHost.this.daK.size() > i && ScrollFragmentTabHost.this.daK.get(i) != null) {
                    if (((com.baidu.tieba.homepage.b.a.a) ScrollFragmentTabHost.this.daK.get(i)).ddS == -2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, true));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, false));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean aqv = ScrollFragmentTabHost.this.aqv();
                    TiebaStatic.log(new ak("c12350").r("obj_type", aqv ? 1 : 0));
                    if (aqv && ScrollFragmentTabHost.this.daJ != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.daJ.la(0);
                    }
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mF = tbPageContext;
        this.bep.a(aVar);
    }

    public boolean aqx() {
        return v.u(this.daK) <= 0;
    }

    public void by(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (list != null && list.size() > 0) {
            this.daK = list;
            notifyDataSetChanged();
        }
    }

    public List<com.baidu.tieba.homepage.b.a.a> getTagList() {
        return this.daK;
    }

    public void notifyDataSetChanged() {
        if (this.daJ != null && !HomePageStatic.cXu) {
            this.daJ.bx(this.daK);
            this.aey.setAdapter(this.daJ);
            this.daH.notifyDataSetChanged();
            this.daM.a(this.daN);
        }
    }

    public void O(String str, int i) {
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.daJ != null) {
            this.daJ.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.daJ != null) {
            this.daJ.d(dataRes, z);
        }
    }

    public void apX() {
        if (this.daJ != null) {
            this.daJ.apX();
        }
    }

    public void h(String str, int i, int i2) {
        if (this.aey != null) {
            this.daJ.h(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        this.daJ = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar, aVar);
        this.daJ.setScrollFragmentTabHost(this);
        this.aey.setOffscreenPageLimit(2);
        this.aey.setAdapter(this.daJ);
        this.aey.setCurrentItem(this.daJ.kY(HomePageStatic.cXu ? 0 : 1));
        this.daH.setViewPager(this.aey);
        if (this.daE != null) {
            this.daJ.setRecommendFrsNavigationAnimDispatcher(this.daE);
        }
    }

    public boolean aqy() {
        return this.daJ != null && this.daJ.getCount() > 0;
    }

    public void r(int i, boolean z) {
        if (i >= 0 && i < this.daJ.getCount()) {
            this.daH.setTabItemClicked(z);
            this.daJ.lc(i);
            this.aey.setCurrentItem(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.daH.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentItem() {
        return this.aey.getCurrentItem();
    }

    public int getCurrentTabType() {
        return this.daJ.kX(this.aey.getCurrentItem());
    }

    public int lf(int i) {
        return this.daJ.kX(i);
    }

    public ah getCurrentFragment() {
        return this.daJ.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        aj.k(this, d.e.cp_bg_line_d);
        aj.k(this.daG, d.e.cp_bg_line_d);
        this.daH.onChangeSkinType();
        if (this.mF != null && this.bep != null) {
            this.bep.onChangeSkinType(this.mF, i);
        }
        if (this.daJ != null) {
            this.daJ.du(i);
        }
        if (this.mF != null && this.cbZ != null) {
            this.cbZ.onChangeSkinType(this.mF, i);
        }
        aj.k(this.daI, d.e.cp_bg_line_d);
    }

    public void aqu() {
        int currentTabType = getCurrentTabType();
        if ((currentTabType == 0 || currentTabType == 1) && this.daJ != null) {
            this.daJ.aqu();
        }
    }

    public void apW() {
        this.daJ.apW();
    }

    public String getCurrentPageKey() {
        if (this.daJ != null) {
            return this.daJ.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.aey != null) {
            return this.aey.getCurrentItem();
        }
        return -1;
    }

    public boolean bz(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (v.v(list) || v.v(this.daK) || v.u(list) != v.u(this.daK)) {
            return false;
        }
        for (int i = 0; i < v.u(list); i++) {
            com.baidu.tieba.homepage.b.a.a aVar = (com.baidu.tieba.homepage.b.a.a) v.c(this.daK, i);
            com.baidu.tieba.homepage.b.a.a aVar2 = (com.baidu.tieba.homepage.b.a.a) v.c(list, i);
            if (aVar != null && aVar2 != null) {
                if (aVar.ddR == null || aVar2.ddR == null) {
                    return true;
                }
                if (!aVar.ddR.equals(aVar2.ddR)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setPrimary(boolean z) {
        if (this.daJ != null) {
            this.daJ.setPrimary(z);
        }
        if (this.bep != null && z) {
            this.bep.setVisibility(i.gW() ? 8 : 0);
        }
    }

    public void aqz() {
        this.daJ.a(this.daO);
    }

    public void aqA() {
        this.daM.b(this.daN);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.daL = aVar;
    }

    public void onDestroy() {
        if (this.daE != null) {
            this.daE.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.daH != null && this.daJ.aqt()) {
            this.daH.setShowConcernRedTip(z);
        }
    }

    public boolean aqv() {
        if (this.daH == null || !this.daJ.aqt()) {
            return false;
        }
        return this.daH.aqv();
    }
}
