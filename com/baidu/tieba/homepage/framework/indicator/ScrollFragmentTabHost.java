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
/* loaded from: classes2.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private CustomViewPager aSK;
    private final e bGW;
    private View bOc;
    private NoNetworkView bYJ;
    private PluginErrorTipView dhI;
    private HomeTabBarView ecA;
    private View ecB;
    private com.baidu.tieba.homepage.framework.indicator.a ecC;
    private a ecD;
    private c ecE;
    private com.baidu.tieba.homepage.framework.e ecF;
    private d ecG;
    private s ecx;
    private ObservedChangeLinearLayout ecy;
    private View ecz;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void oQ(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.bGW = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.ecC != null) {
                    ScrollFragmentTabHost.this.ecC.e(view, i, i2, i3, i4);
                }
            }
        };
        this.ecE = new c();
        this.ecF = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void oG(int i) {
                ScrollFragmentTabHost.this.C(ScrollFragmentTabHost.this.ecC.oI(i), false);
                ScrollFragmentTabHost.this.ecC.oL(i);
            }
        };
        this.ecG = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void oF(int i) {
                ScrollFragmentTabHost.this.ecE.a(i, ScrollFragmentTabHost.this.ecF);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGW = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.ecC != null) {
                    ScrollFragmentTabHost.this.ecC.e(view, i, i2, i3, i4);
                }
            }
        };
        this.ecE = new c();
        this.ecF = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void oG(int i) {
                ScrollFragmentTabHost.this.C(ScrollFragmentTabHost.this.ecC.oI(i), false);
                ScrollFragmentTabHost.this.ecC.oL(i);
            }
        };
        this.ecG = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void oF(int i) {
                ScrollFragmentTabHost.this.ecE.a(i, ScrollFragmentTabHost.this.ecF);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.ecy = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.ecz = findViewById(d.g.home_page_statebar_view);
        this.ecA = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.dhI = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.bYJ = (NoNetworkView) findViewById(d.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.home_pager_container);
        this.aSK = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.ecB = findViewById(d.g.home_statebar_view);
        this.bOc = findViewById(d.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.ecz.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.ecy.setOnSizeChangeListener(this.bGW);
        this.ecA.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.ecC.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.ecD != null) {
                    ScrollFragmentTabHost.this.ecD.oQ(i);
                }
                if (ScrollFragmentTabHost.this.oP(i) == 3) {
                    ak akVar = new ak("c12478");
                    akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(akVar);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean aBc = ScrollFragmentTabHost.this.aBc();
                    TiebaStatic.log(new ak("c12350").s("obj_type", aBc ? 1 : 0));
                    if (aBc && ScrollFragmentTabHost.this.ecC != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.ecC.oK(0);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.bYJ.a(aVar);
    }

    public void notifyDataSetChanged() {
        if (this.ecC != null && !HomePageStatic.dZD) {
            this.aSK.setAdapter(this.ecC);
            this.ecA.notifyDataSetChanged();
            this.ecE.a(this.ecF);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.ecC != null) {
            this.ecC.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.ecC != null) {
            this.ecC.d(dataRes, z);
        }
    }

    public void aAD() {
        if (this.ecC != null) {
            this.ecC.aAD();
        }
        if (this.ecC != null && this.aSK != null && this.aSK.getCurrentItem() == 0) {
            this.ecC.aBa();
        }
    }

    public void l(String str, int i, int i2) {
        if (this.aSK != null) {
            this.ecC.l(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        this.ecC = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar, aVar);
        this.ecC.setScrollFragmentTabHost(this);
        this.aSK.setOffscreenPageLimit(2);
        this.aSK.setAdapter(this.ecC);
        this.aSK.setCurrentItem(this.ecC.oI(HomePageStatic.dZD ? 0 : 1));
        this.ecA.setViewPager(this.aSK);
        if (this.ecx != null) {
            this.ecC.setRecommendFrsNavigationAnimDispatcher(this.ecx);
        }
    }

    public boolean aBe() {
        return this.ecC != null && this.ecC.getCount() > 0;
    }

    public void C(int i, boolean z) {
        if (i >= 0 && i < this.ecC.getCount()) {
            this.ecA.setTabItemClicked(z);
            this.ecC.oM(i);
            this.aSK.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        C(this.ecC.oI(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ecA.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentItem() {
        return this.aSK.getCurrentItem();
    }

    public int getCurrentTabType() {
        return this.ecC.oH(this.aSK.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.aSK.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.ecC.oH(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int oP(int i) {
        return this.ecC.oH(i);
    }

    public aj getCurrentFragment() {
        return this.ecC.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.util.aj.t(this, d.C0108d.cp_bg_line_d);
        com.baidu.tbadk.core.util.aj.t(this.ecz, d.C0108d.cp_bg_line_d);
        this.ecA.onChangeSkinType();
        if (this.mPageContext != null && this.bYJ != null) {
            this.bYJ.onChangeSkinType(this.mPageContext, i);
        }
        if (this.ecC != null) {
            this.ecC.gC(i);
        }
        if (this.mPageContext != null && this.dhI != null) {
            this.dhI.onChangeSkinType(this.mPageContext, i);
        }
        com.baidu.tbadk.core.util.aj.t(this.ecB, d.C0108d.cp_bg_line_d);
        com.baidu.tbadk.core.util.aj.t(this.bOc, d.C0108d.cp_bg_line_c);
    }

    public void aBb() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.ecC != null) {
            this.ecC.aBb();
        }
        if ((currentTabType == 1 || currentTabType == 3) && this.ecC != null) {
            this.ecC.aBb();
        }
    }

    public void XM() {
        this.ecC.XM();
    }

    public String getCurrentPageKey() {
        if (this.ecC != null) {
            return this.ecC.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.aSK != null) {
            return this.aSK.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.ecC != null) {
            this.ecC.setPrimary(z);
        }
        if (this.bYJ != null && z) {
            this.bYJ.setVisibility(j.ow() ? 8 : 0);
        }
    }

    public void aBf() {
        this.ecC.a(this.ecG);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.ecD = aVar;
    }

    public void onDestroy() {
        if (this.ecx != null) {
            this.ecx.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.ecA != null && this.ecC.aAZ()) {
            this.ecA.setShowConcernRedTip(z);
        }
    }

    public boolean aBc() {
        if (this.ecA == null || !this.ecC.aAZ()) {
            return false;
        }
        return this.ecA.aBc();
    }

    public void setVideoThreadId(String str) {
        if (this.ecC != null) {
            this.ecC.setVideoThreadId(str);
        }
    }
}
