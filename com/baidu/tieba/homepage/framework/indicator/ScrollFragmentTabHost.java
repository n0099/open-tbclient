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
    private CustomViewPager aSM;
    private final e bHm;
    private View bOs;
    private NoNetworkView bYY;
    private PluginErrorTipView dmE;
    private s eed;
    private ObservedChangeLinearLayout eee;
    private View eef;
    private HomeTabBarView eeg;
    private View eeh;
    private com.baidu.tieba.homepage.framework.indicator.a eei;
    private a eej;
    private c eek;
    private com.baidu.tieba.homepage.framework.e eel;
    private d eem;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void oJ(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.bHm = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.eei != null) {
                    ScrollFragmentTabHost.this.eei.e(view, i, i2, i3, i4);
                }
            }
        };
        this.eek = new c();
        this.eel = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void oz(int i) {
                ScrollFragmentTabHost.this.C(ScrollFragmentTabHost.this.eei.oB(i), false);
                ScrollFragmentTabHost.this.eei.oE(i);
            }
        };
        this.eem = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void oy(int i) {
                ScrollFragmentTabHost.this.eek.a(i, ScrollFragmentTabHost.this.eel);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHm = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.eei != null) {
                    ScrollFragmentTabHost.this.eei.e(view, i, i2, i3, i4);
                }
            }
        };
        this.eek = new c();
        this.eel = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void oz(int i) {
                ScrollFragmentTabHost.this.C(ScrollFragmentTabHost.this.eei.oB(i), false);
                ScrollFragmentTabHost.this.eei.oE(i);
            }
        };
        this.eem = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void oy(int i) {
                ScrollFragmentTabHost.this.eek.a(i, ScrollFragmentTabHost.this.eel);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.eee = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.eef = findViewById(d.g.home_page_statebar_view);
        this.eeg = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.dmE = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.bYY = (NoNetworkView) findViewById(d.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.home_pager_container);
        this.aSM = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.eeh = findViewById(d.g.home_statebar_view);
        this.bOs = findViewById(d.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.eef.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.eee.setOnSizeChangeListener(this.bHm);
        this.eeg.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.eei.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.eej != null) {
                    ScrollFragmentTabHost.this.eej.oJ(i);
                }
                if (ScrollFragmentTabHost.this.oI(i) == 3) {
                    ak akVar = new ak("c12478");
                    akVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(akVar);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean aBj = ScrollFragmentTabHost.this.aBj();
                    TiebaStatic.log(new ak("c12350").s("obj_type", aBj ? 1 : 0));
                    if (aBj && ScrollFragmentTabHost.this.eei != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.eei.oD(0);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.bYY.a(aVar);
    }

    public void notifyDataSetChanged() {
        if (this.eei != null && !HomePageStatic.ebj) {
            this.aSM.setAdapter(this.eei);
            this.eeg.notifyDataSetChanged();
            this.eek.a(this.eel);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.eei != null) {
            this.eei.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.eei != null) {
            this.eei.d(dataRes, z);
        }
    }

    public void aAK() {
        if (this.eei != null) {
            this.eei.aAK();
        }
        if (this.eei != null && this.aSM != null && this.aSM.getCurrentItem() == 0) {
            this.eei.aBh();
        }
    }

    public void l(String str, int i, int i2) {
        if (this.aSM != null) {
            this.eei.l(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        this.eei = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar, aVar);
        this.eei.setScrollFragmentTabHost(this);
        this.aSM.setOffscreenPageLimit(2);
        this.aSM.setAdapter(this.eei);
        this.aSM.setCurrentItem(this.eei.oB(HomePageStatic.ebj ? 0 : 1));
        this.eeg.setViewPager(this.aSM);
        if (this.eed != null) {
            this.eei.setRecommendFrsNavigationAnimDispatcher(this.eed);
        }
    }

    public boolean aBl() {
        return this.eei != null && this.eei.getCount() > 0;
    }

    public void C(int i, boolean z) {
        if (i >= 0 && i < this.eei.getCount()) {
            this.eeg.setTabItemClicked(z);
            this.eei.oF(i);
            this.aSM.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        C(this.eei.oB(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eeg.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentItem() {
        return this.aSM.getCurrentItem();
    }

    public int getCurrentTabType() {
        return this.eei.oA(this.aSM.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.aSM.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.eei.oA(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int oI(int i) {
        return this.eei.oA(i);
    }

    public aj getCurrentFragment() {
        return this.eei.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.util.aj.t(this, d.C0108d.cp_bg_line_d);
        com.baidu.tbadk.core.util.aj.t(this.eef, d.C0108d.cp_bg_line_d);
        this.eeg.onChangeSkinType();
        if (this.mPageContext != null && this.bYY != null) {
            this.bYY.onChangeSkinType(this.mPageContext, i);
        }
        if (this.eei != null) {
            this.eei.gz(i);
        }
        if (this.mPageContext != null && this.dmE != null) {
            this.dmE.onChangeSkinType(this.mPageContext, i);
        }
        com.baidu.tbadk.core.util.aj.t(this.eeh, d.C0108d.cp_bg_line_d);
        com.baidu.tbadk.core.util.aj.t(this.bOs, d.C0108d.cp_bg_line_c);
    }

    public void aBi() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.eei != null) {
            this.eei.aBi();
        }
        if ((currentTabType == 1 || currentTabType == 3) && this.eei != null) {
            this.eei.aBi();
        }
    }

    public void XC() {
        this.eei.XC();
    }

    public String getCurrentPageKey() {
        if (this.eei != null) {
            return this.eei.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.aSM != null) {
            return this.aSM.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.eei != null) {
            this.eei.setPrimary(z);
        }
        if (this.bYY != null && z) {
            this.bYY.setVisibility(j.ox() ? 8 : 0);
        }
    }

    public void aBm() {
        this.eei.a(this.eem);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.eej = aVar;
    }

    public void onDestroy() {
        if (this.eed != null) {
            this.eed.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.eeg != null && this.eei.aBg()) {
            this.eeg.setShowConcernRedTip(z);
        }
    }

    public boolean aBj() {
        if (this.eeg == null || !this.eei.aBg()) {
            return false;
        }
        return this.eeg.aBj();
    }

    public void setVideoThreadId(String str) {
        if (this.eei != null) {
            this.eei.setVideoThreadId(str);
        }
    }
}
