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
    private CustomViewPager aSJ;
    private final e bHe;
    private View bOk;
    private NoNetworkView bYQ;
    private PluginErrorTipView dmj;
    private s edI;
    private ObservedChangeLinearLayout edJ;
    private View edK;
    private HomeTabBarView edL;
    private View edM;
    private com.baidu.tieba.homepage.framework.indicator.a edN;
    private a edO;
    private c edP;
    private com.baidu.tieba.homepage.framework.e edQ;
    private d edR;
    private Context mContext;
    private FrameLayout mFrameLayout;
    private TbPageContext mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void oJ(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.bHe = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.edN != null) {
                    ScrollFragmentTabHost.this.edN.e(view, i, i2, i3, i4);
                }
            }
        };
        this.edP = new c();
        this.edQ = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void oz(int i) {
                ScrollFragmentTabHost.this.C(ScrollFragmentTabHost.this.edN.oB(i), false);
                ScrollFragmentTabHost.this.edN.oE(i);
            }
        };
        this.edR = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void oy(int i) {
                ScrollFragmentTabHost.this.edP.a(i, ScrollFragmentTabHost.this.edQ);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHe = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void d(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.edN != null) {
                    ScrollFragmentTabHost.this.edN.e(view, i, i2, i3, i4);
                }
            }
        };
        this.edP = new c();
        this.edQ = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void oz(int i) {
                ScrollFragmentTabHost.this.C(ScrollFragmentTabHost.this.edN.oB(i), false);
                ScrollFragmentTabHost.this.edN.oE(i);
            }
        };
        this.edR = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void oy(int i) {
                ScrollFragmentTabHost.this.edP.a(i, ScrollFragmentTabHost.this.edQ);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.edJ = (ObservedChangeLinearLayout) findViewById(d.g.home_page_fragment_tab_layout);
        this.edK = findViewById(d.g.home_page_statebar_view);
        this.edL = (HomeTabBarView) findViewById(d.g.home_tab_bar_view);
        this.dmj = (PluginErrorTipView) findViewById(d.g.view_plugin_error_tip);
        this.bYQ = (NoNetworkView) findViewById(d.g.view_no_network);
        this.mFrameLayout = (FrameLayout) findViewById(d.g.home_pager_container);
        this.aSJ = (CustomViewPager) findViewById(d.g.tab_widget_view_pager);
        this.edM = findViewById(d.g.home_statebar_view);
        this.bOk = findViewById(d.g.divider_line);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.edK.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.edJ.setOnSizeChangeListener(this.bHe);
        this.edL.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.edN.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.edO != null) {
                    ScrollFragmentTabHost.this.edO.oJ(i);
                }
                if (ScrollFragmentTabHost.this.oI(i) == 3) {
                    ak akVar = new ak("c12478");
                    akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "0");
                    TiebaStatic.log(akVar);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentTabType() == 0) {
                    boolean aBe = ScrollFragmentTabHost.this.aBe();
                    TiebaStatic.log(new ak("c12350").s("obj_type", aBe ? 1 : 0));
                    if (aBe && ScrollFragmentTabHost.this.edN != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CONCERN_RED_TIP_SHOW));
                        ScrollFragmentTabHost.this.edN.oD(0);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_JUMP_TO_CONCERN_TAB));
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.mPageContext = tbPageContext;
        this.bYQ.a(aVar);
    }

    public void notifyDataSetChanged() {
        if (this.edN != null && !HomePageStatic.eaO) {
            this.aSJ.setAdapter(this.edN);
            this.edL.notifyDataSetChanged();
            this.edP.a(this.edQ);
        }
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.edN != null) {
            this.edN.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.edN != null) {
            this.edN.d(dataRes, z);
        }
    }

    public void aAF() {
        if (this.edN != null) {
            this.edN.aAF();
        }
        if (this.edN != null && this.aSJ != null && this.aSJ.getCurrentItem() == 0) {
            this.edN.aBc();
        }
    }

    public void l(String str, int i, int i2) {
        if (this.aSJ != null) {
            this.edN.l(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        this.edN = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar, aVar);
        this.edN.setScrollFragmentTabHost(this);
        this.aSJ.setOffscreenPageLimit(2);
        this.aSJ.setAdapter(this.edN);
        this.aSJ.setCurrentItem(this.edN.oB(HomePageStatic.eaO ? 0 : 1));
        this.edL.setViewPager(this.aSJ);
        if (this.edI != null) {
            this.edN.setRecommendFrsNavigationAnimDispatcher(this.edI);
        }
    }

    public boolean aBg() {
        return this.edN != null && this.edN.getCount() > 0;
    }

    public void C(int i, boolean z) {
        if (i >= 0 && i < this.edN.getCount()) {
            this.edL.setTabItemClicked(z);
            this.edN.oF(i);
            this.aSJ.setCurrentItem(i);
        }
    }

    public void setCurrentTab(int i) {
        C(this.edN.oB(i), false);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.edL.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.mFrameLayout;
    }

    public int getCurrentItem() {
        return this.aSJ.getCurrentItem();
    }

    public int getCurrentTabType() {
        return this.edN.oA(this.aSJ.getCurrentItem());
    }

    public int getVideoRecommendIndex() {
        int count = this.aSJ.getAdapter().getCount();
        for (int i = 0; i < count; i++) {
            if (this.edN.oA(i) == 3) {
                return i;
            }
        }
        return -1;
    }

    public int oI(int i) {
        return this.edN.oA(i);
    }

    public aj getCurrentFragment() {
        return this.edN.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.util.aj.t(this, d.C0107d.cp_bg_line_d);
        com.baidu.tbadk.core.util.aj.t(this.edK, d.C0107d.cp_bg_line_d);
        this.edL.onChangeSkinType();
        if (this.mPageContext != null && this.bYQ != null) {
            this.bYQ.onChangeSkinType(this.mPageContext, i);
        }
        if (this.edN != null) {
            this.edN.gz(i);
        }
        if (this.mPageContext != null && this.dmj != null) {
            this.dmj.onChangeSkinType(this.mPageContext, i);
        }
        com.baidu.tbadk.core.util.aj.t(this.edM, d.C0107d.cp_bg_line_d);
        com.baidu.tbadk.core.util.aj.t(this.bOk, d.C0107d.cp_bg_line_c);
    }

    public void aBd() {
        int currentTabType = getCurrentTabType();
        if (currentTabType == 0 && TbadkCoreApplication.isLogin() && this.edN != null) {
            this.edN.aBd();
        }
        if ((currentTabType == 1 || currentTabType == 3) && this.edN != null) {
            this.edN.aBd();
        }
    }

    public void XA() {
        this.edN.XA();
    }

    public String getCurrentPageKey() {
        if (this.edN != null) {
            return this.edN.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.aSJ != null) {
            return this.aSJ.getCurrentItem();
        }
        return -1;
    }

    public void setPrimary(boolean z) {
        if (this.edN != null) {
            this.edN.setPrimary(z);
        }
        if (this.bYQ != null && z) {
            this.bYQ.setVisibility(j.ow() ? 8 : 0);
        }
    }

    public void aBh() {
        this.edN.a(this.edR);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.edO = aVar;
    }

    public void onDestroy() {
        if (this.edI != null) {
            this.edI.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.edL != null && this.edN.aBb()) {
            this.edL.setShowConcernRedTip(z);
        }
    }

    public boolean aBe() {
        if (this.edL == null || !this.edN.aBb()) {
            return false;
        }
        return this.edL.aBe();
    }

    public void setVideoThreadId(String str) {
        if (this.edN != null) {
            this.edN.setVideoThreadId(str);
        }
    }
}
