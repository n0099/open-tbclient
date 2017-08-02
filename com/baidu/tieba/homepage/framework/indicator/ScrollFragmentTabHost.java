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
    private final e aOg;
    private CustomViewPager adS;
    private TbPageContext ako;
    private PluginErrorTipView bXj;
    private NoNetworkView bdg;
    private r cQI;
    private ObservedChangeLinearLayout cQJ;
    private View cQK;
    private HomeTabBarView cQL;
    private FrameLayout cQM;
    private View cQN;
    private com.baidu.tieba.homepage.framework.indicator.a cQO;
    private List<com.baidu.tieba.homepage.b.a.a> cQP;
    private a cQQ;
    private b cQR;
    private com.baidu.tieba.homepage.framework.e cQS;
    private d cQT;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void kF(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.aOg = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.cQO != null) {
                    ScrollFragmentTabHost.this.cQO.b(view, i, i2, i3, i4);
                }
            }
        };
        this.cQR = new b();
        this.cQS = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void ky(int i) {
                ScrollFragmentTabHost.this.h(i, false);
                ScrollFragmentTabHost.this.cQO.kC(i);
            }
        };
        this.cQT = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void kx(int i) {
                ScrollFragmentTabHost.this.cQR.a(i, ScrollFragmentTabHost.this.cQS);
            }
        };
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOg = new e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.1
            @Override // com.baidu.tbadk.widget.layout.e
            public void a(View view, int i, int i2, int i3, int i4) {
                if (ScrollFragmentTabHost.this.cQO != null) {
                    ScrollFragmentTabHost.this.cQO.b(view, i, i2, i3, i4);
                }
            }
        };
        this.cQR = new b();
        this.cQS = new com.baidu.tieba.homepage.framework.e() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.3
            @Override // com.baidu.tieba.homepage.framework.e
            public void ky(int i) {
                ScrollFragmentTabHost.this.h(i, false);
                ScrollFragmentTabHost.this.cQO.kC(i);
            }
        };
        this.cQT = new d() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.4
            @Override // com.baidu.tieba.homepage.framework.d
            public void kx(int i) {
                ScrollFragmentTabHost.this.cQR.a(i, ScrollFragmentTabHost.this.cQS);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.j.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.cQJ = (ObservedChangeLinearLayout) findViewById(d.h.home_page_fragment_tab_layout);
        this.cQK = findViewById(d.h.home_page_statebar_view);
        this.cQL = (HomeTabBarView) findViewById(d.h.home_tab_bar_view);
        this.bXj = (PluginErrorTipView) findViewById(d.h.view_plugin_error_tip);
        this.bdg = (NoNetworkView) findViewById(d.h.view_no_network);
        this.cQM = (FrameLayout) findViewById(d.h.home_pager_container);
        this.adS = (CustomViewPager) findViewById(d.h.tab_widget_view_pager);
        this.cQN = findViewById(d.h.home_statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cQK.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.cQJ.setOnSizeChangeListener(this.aOg);
        this.cQL.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                ScrollFragmentTabHost.this.cQO.onPageScrolled(i, f, i2);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (ScrollFragmentTabHost.this.cQQ != null) {
                    ScrollFragmentTabHost.this.cQQ.kF(i);
                }
                if (ScrollFragmentTabHost.this.cQP != null && ScrollFragmentTabHost.this.cQP.size() > i && ScrollFragmentTabHost.this.cQP.get(i) != null) {
                    if (((com.baidu.tieba.homepage.b.a.a) ScrollFragmentTabHost.this.cQP.get(i)).cTT == -2) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, true));
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ENTER_LEAVE_DISCOVER_PAGE, false));
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0 && ScrollFragmentTabHost.this.getCurrentItem() == com.baidu.tieba.homepage.framework.indicator.a.cQy) {
                    boolean anZ = ScrollFragmentTabHost.this.anZ();
                    TiebaStatic.log(new aj("c12350").r("obj_type", anZ ? 1 : 0));
                    if (anZ && ScrollFragmentTabHost.this.cQO != null) {
                        ScrollFragmentTabHost.this.setShowConcernRedTip(false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RECOMMEND_FRS_TIP_SHOW, 0));
                        ScrollFragmentTabHost.this.cQO.kB(com.baidu.tieba.homepage.framework.indicator.a.cQy);
                    }
                }
            }
        });
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.ako = tbPageContext;
        this.bdg.a(aVar);
    }

    public boolean aoa() {
        return u.u(this.cQP) <= 0;
    }

    public void br(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (list != null && list.size() > 0) {
            this.cQP = list;
            notifyDataSetChanged();
        }
    }

    public List<com.baidu.tieba.homepage.b.a.a> getTagList() {
        return this.cQP;
    }

    public void notifyDataSetChanged() {
        if (this.cQO != null) {
            this.cQO.bq(this.cQP);
            this.adS.setAdapter(this.cQO);
            this.cQL.notifyDataSetChanged();
            this.cQR.a(this.cQS);
        }
    }

    public void O(String str, int i) {
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.cQO != null) {
            this.cQO.c(dataRes, z, z2);
        }
    }

    public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
        if (this.cQO != null) {
            this.cQO.d(dataRes, z);
        }
    }

    public void anB() {
        if (this.cQO != null) {
            this.cQO.anB();
        }
    }

    public void g(String str, int i, int i2) {
        if (this.adS != null) {
            this.cQO.g(str, i, i2);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar, c.a aVar) {
        this.cQO = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar, aVar);
        this.cQO.setScrollFragmentTabHost(this);
        this.adS.setOffscreenPageLimit(0);
        this.adS.setAdapter(this.cQO);
        this.adS.setCurrentItem(com.baidu.tieba.homepage.framework.indicator.a.cQB);
        this.cQL.setViewPager(this.adS);
        if (this.cQI != null) {
            this.cQO.setRecommendFrsNavigationAnimDispatcher(this.cQI);
        }
    }

    public boolean aob() {
        return this.cQO != null && this.cQO.getCount() > 0;
    }

    public void h(int i, boolean z) {
        if (i >= 0 && i < this.cQO.getCount()) {
            this.cQL.setTabItemClicked(z);
            this.cQO.kD(i);
            this.adS.setCurrentItem(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cQL.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.cQM;
    }

    public int getCurrentItem() {
        return this.adS.getCurrentItem();
    }

    public ah getCurrentFragment() {
        return this.cQO.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        ai.k(this, d.e.cp_bg_line_d);
        ai.k(this.cQK, d.e.cp_bg_line_d);
        this.cQL.onChangeSkinType();
        if (this.ako != null && this.bdg != null) {
            this.bdg.onChangeSkinType(this.ako, i);
        }
        if (this.cQO != null) {
            this.cQO.dr(i);
        }
        if (this.ako != null && this.bXj != null) {
            this.bXj.onChangeSkinType(this.ako, i);
        }
        ai.k(this.cQN, d.e.cp_bg_line_d);
    }

    public void anY() {
        if (this.cQO != null) {
            if (this.adS.getCurrentItem() == com.baidu.tieba.homepage.framework.indicator.a.cQz || this.adS.getCurrentItem() == com.baidu.tieba.homepage.framework.indicator.a.cQy) {
                this.cQO.anY();
            }
        }
    }

    public void anA() {
        this.cQO.anA();
    }

    public String getCurrentPageKey() {
        if (this.cQO != null) {
            return this.cQO.getCurrentPageKey();
        }
        return null;
    }

    public int getCurrentIndex() {
        if (this.adS != null) {
            return this.adS.getCurrentItem();
        }
        return -1;
    }

    public boolean bs(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (u.v(list) || u.v(this.cQP) || u.u(list) != u.u(this.cQP)) {
            return false;
        }
        for (int i = 0; i < u.u(list); i++) {
            com.baidu.tieba.homepage.b.a.a aVar = (com.baidu.tieba.homepage.b.a.a) u.c(this.cQP, i);
            com.baidu.tieba.homepage.b.a.a aVar2 = (com.baidu.tieba.homepage.b.a.a) u.c(list, i);
            if (aVar != null && aVar2 != null) {
                if (aVar.cTS == null || aVar2.cTS == null) {
                    return true;
                }
                if (!aVar.cTS.equals(aVar2.cTS)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setPrimary(boolean z) {
        if (this.cQO != null) {
            this.cQO.setPrimary(z);
        }
        if (this.bdg != null && z) {
            this.bdg.setVisibility(i.gV() ? 8 : 0);
        }
    }

    public void aoc() {
        this.cQO.a(this.cQT);
    }

    public void aod() {
        this.cQR.b(this.cQS);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cQQ = aVar;
    }

    public void onDestroy() {
        if (this.cQI != null) {
            this.cQI.onDestroy();
        }
    }

    public void setShowConcernRedTip(boolean z) {
        if (this.cQL != null) {
            this.cQL.setShowConcernRedTip(z);
        }
    }

    public boolean anZ() {
        if (this.cQL != null) {
            return this.cQL.anZ();
        }
        return false;
    }
}
