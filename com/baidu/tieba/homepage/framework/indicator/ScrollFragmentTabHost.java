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
import com.baidu.tbadk.util.q;
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
    private final e aPU;
    private View aWK;
    private CustomViewPager adJ;
    private NoNetworkView bfM;
    private q cXM;
    private ObservedChangeLinearLayout cXN;
    private View cXO;
    private HomeTabBarView cXP;
    private View cXQ;
    private com.baidu.tieba.homepage.framework.indicator.a cXR;
    private a cXS;
    private c cXT;
    private com.baidu.tieba.homepage.framework.e cXU;
    private d cXV;
    private PluginErrorTipView ccG;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mH;

    /* loaded from: classes.dex */
    public interface a {
        void lc(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.aPU = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.cXR != null) {
                    ScrollFragmentTabHost.this.cXR.b(view, i, i2, i3, i4);
                }
            }
        };
        this.cXT = new c();
        this.cXU = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void kS(int i) {
                ScrollFragmentTabHost.this.p(ScrollFragmentTabHost.this.cXR.kU(i), false);
                ScrollFragmentTabHost.this.cXR.kX(i);
            }
        };
        this.cXV = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void kR(int i) {
                ScrollFragmentTabHost.this.cXT.a(i, ScrollFragmentTabHost.this.cXU);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aPU = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.cXR != null) {
                    ScrollFragmentTabHost.this.cXR.b(view, i, i2, i3, i4);
                }
            }
        };
        this.cXT = new c();
        this.cXU = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void kS(int i) {
                ScrollFragmentTabHost.this.p(ScrollFragmentTabHost.this.cXR.kU(i), false);
                ScrollFragmentTabHost.this.cXR.kX(i);
            }
        };
        this.cXV = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void kR(int i) {
                ScrollFragmentTabHost.this.cXT.a(i, ScrollFragmentTabHost.this.cXU);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.j.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.cXN = (ObservedChangeLinearLayout) findViewById(d.h.home_page_fragment_tab_layout);
        this.cXO = findViewById(d.h.home_page_statebar_view);
        this.cXP = (HomeTabBarView) findViewById(d.h.home_tab_bar_view);
        this.ccG = (PluginErrorTipView) findViewById(d.h.view_plugin_error_tip);
        this.bfM = (NoNetworkView) findViewById(d.h.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.h.home_pager_container);
        this.adJ = (CustomViewPager) findViewById(d.h.tab_widget_view_pager);
        this.cXQ = findViewById(d.h.home_statebar_view);
        this.aWK = findViewById(d.h.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cXO.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.cXN.setOnSizeChangeListener(this.aPU);
        this.cXP.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.cXR.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.cXS != null) {
                    ScrollFragmentTabHost.this.cXS.lc(i);
                }
                if (ScrollFragmentTabHost.this.lb(i) == 3) {
                    ak akVar = new ak("c12478");
                    akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(akVar);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean api = ScrollFragmentTabHost.this.api();
                    TiebaStatic.log(new ak("c12350").r("obj_type", api ? 1 : 0));
                    if (api && ScrollFragmentTabHost.this.cXR != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.cXR.kW(0);
                    }
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mH = tbPageContext;
        this.bfM.a(aVar);
    }

    public void notifyDataSetChanged() {
        if (this.cXR != null && !HomePageStatic.cUu) {
            this.adJ.setAdapter(this.cXR);
            this.cXP.notifyDataSetChanged();
            this.cXT.a(this.cXU);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.cXR != null) {
            this.cXR.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.cXR != null) {
            this.cXR.d(dataRes, z);
        }
    }

    public void aoG() {
        if (this.cXR != null) {
            this.cXR.aoG();
        }
        if (this.cXR != null && this.adJ != null && this.adJ.getCurrentItem() == 0) {
            this.cXR.apg();
        }
    }

    public void g(String str, int i, int i2) {
        if (this.adJ != null) {
            this.cXR.g(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        this.cXR = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar, aVar);
        this.cXR.setScrollFragmentTabHost(this);
        this.adJ.setOffscreenPageLimit(2);
        this.adJ.setAdapter(this.cXR);
        this.adJ.setCurrentItem(this.cXR.kU(HomePageStatic.cUu ? 0 : 1));
        this.cXP.setViewPager(this.adJ);
        if (this.cXM != null) {
            this.cXR.setRecommendFrsNavigationAnimDispatcher(this.cXM);
        }
    }

    public boolean apk() {
        return this.cXR != null && this.cXR.getCount() > 0;
    }

    public void p(int i, boolean z) {
        if (i >= 0 && i < this.cXR.getCount()) {
            this.cXP.setTabItemClicked(z);
            this.cXR.kY(i);
            this.adJ.setCurrentItem(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cXP.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentItem() {
        return this.adJ.getCurrentItem();
    }

    public int getCurrentTabType() {
        return this.cXR.kT(this.adJ.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.adJ.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.cXR.kT(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int lb(int i) {
        return this.cXR.kT(i);
    }

    public ai getCurrentFragment() {
        return this.cXR.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        aj.k(this, d.e.cp_bg_line_d);
        aj.k(this.cXO, d.e.cp_bg_line_d);
        this.cXP.onChangeSkinType();
        if (this.mH != null && this.bfM != null) {
            this.bfM.onChangeSkinType(this.mH, i);
        }
        if (this.cXR != null) {
            this.cXR.dD(i);
        }
        if (this.mH != null && this.ccG != null) {
            this.ccG.onChangeSkinType(this.mH, i);
        }
        aj.k(this.cXQ, d.e.cp_bg_line_d);
        aj.k(this.aWK, d.e.cp_bg_line_c);
    }

    public void aph() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.cXR != null) {
            this.cXR.aph();
        }
        if ((currentTabType == 1 || currentTabType == 3) && this.cXR != null) {
            this.cXR.aph();
        }
    }

    public void aoF() {
        this.cXR.aoF();
    }

    public String getCurrentPageKey() {
        if (this.cXR != null) {
            return this.cXR.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.adJ != null) {
            return this.adJ.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.cXR != null) {
            this.cXR.setPrimary(z);
        }
        if (this.bfM != null && z) {
            this.bfM.setVisibility(j.gV() ? 8 : 0);
        }
    }

    public void apl() {
        this.cXR.a(this.cXV);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cXS = aVar;
    }

    public void onDestroy() {
        if (this.cXM != null) {
            this.cXM.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.cXP != null && this.cXR.apf()) {
            this.cXP.setShowConcernRedTip(z);
        }
    }

    public boolean api() {
        if (this.cXP == null || !this.cXR.apf()) {
            return false;
        }
        return this.cXP.api();
    }

    public void setVideoThreadId(String str) {
        if (this.cXR != null) {
            this.cXR.setVideoThreadId(str);
        }
    }
}
