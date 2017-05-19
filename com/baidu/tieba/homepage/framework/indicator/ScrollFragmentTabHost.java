package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.homepage.framework.u;
import com.baidu.tieba.homepage.framework.v;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import com.baidu.tieba.w;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private final com.baidu.tbadk.widget.layout.h aLK;
    private NoNetworkView aSi;
    private CustomViewPager acU;
    private TbPageContext ajr;
    private PluginErrorTipView bGG;
    private t ctO;
    private ObservedChangeLinearLayout ctP;
    private View ctQ;
    private HomeTabBarView ctR;
    private FrameLayout ctS;
    private View ctT;
    private com.baidu.tieba.homepage.framework.indicator.a ctU;
    private List<com.baidu.tieba.homepage.b.a.a> ctV;
    private a ctW;
    private l ctX;
    private v ctY;
    private u ctZ;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void jL(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.aLK = new h(this);
        this.ctX = new l();
        this.ctY = new i(this);
        this.ctZ = new j(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLK = new h(this);
        this.ctX = new l();
        this.ctY = new i(this);
        this.ctZ = new j(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(w.j.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.ctP = (ObservedChangeLinearLayout) findViewById(w.h.home_page_fragment_tab_layout);
        this.ctQ = findViewById(w.h.home_page_statebar_view);
        this.ctR = (HomeTabBarView) findViewById(w.h.home_tab_bar_view);
        this.bGG = (PluginErrorTipView) findViewById(w.h.view_plugin_error_tip);
        this.aSi = (NoNetworkView) findViewById(w.h.view_no_network);
        this.ctS = (FrameLayout) findViewById(w.h.home_pager_container);
        this.acU = (CustomViewPager) findViewById(w.h.tab_widget_view_pager);
        this.ctT = findViewById(w.h.home_statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.ctQ.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.ctP.setOnSizeChangeListener(this.aLK);
        this.ctR.setOnPageChangeListener(new k(this));
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.ajr = tbPageContext;
        this.aSi.a(aVar);
    }

    public boolean ahn() {
        return x.q(this.ctV) <= 0;
    }

    public void aS(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (list != null && list.size() > 0) {
            this.ctV = list;
            notifyDataSetChanged();
        }
    }

    public List<com.baidu.tieba.homepage.b.a.a> getTagList() {
        return this.ctV;
    }

    public void notifyDataSetChanged() {
        if (this.ctU != null) {
            this.ctU.aR(this.ctV);
            this.acU.setAdapter(this.ctU);
            this.ctR.notifyDataSetChanged();
            this.ctX.a(this.ctY);
        }
    }

    public void N(String str, int i) {
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.ctU != null) {
            this.ctU.c(dataRes, z, z2);
        }
    }

    public void ahj() {
        if (this.ctU != null) {
            this.ctU.ahj();
        }
    }

    public void M(String str, int i) {
        if (this.acU != null) {
            this.ctU.M(str, i);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar) {
        this.ctU = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar);
        this.ctU.setScrollFragmentTabHost(this);
        this.acU.setOffscreenPageLimit(0);
        this.acU.setAdapter(this.ctU);
        this.ctR.setViewPager(this.acU);
        if (this.ctO != null) {
            this.ctU.setRecommendFrsNavigationAnimDispatcher(this.ctO);
        }
    }

    public boolean aho() {
        return this.ctU != null && this.ctU.getCount() > 0;
    }

    public void g(int i, boolean z) {
        if (i >= 0 && i < this.ctU.getCount()) {
            this.ctR.setTabItemClicked(z);
            this.ctU.jJ(i);
            this.acU.setCurrentItem(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ctR.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.ctS;
    }

    public int getCurrentItem() {
        return this.acU.getCurrentItem();
    }

    public bw getCurrentFragment() {
        return this.ctU.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        aq.k(this, w.e.cp_bg_line_d);
        aq.k(this.ctQ, w.e.cp_bg_line_d);
        this.ctR.onChangeSkinType();
        if (this.ajr != null && this.aSi != null) {
            this.aSi.onChangeSkinType(this.ajr, i);
        }
        if (this.ctU != null) {
            this.ctU.dm(i);
        }
        if (this.ajr != null && this.bGG != null) {
            this.bGG.onChangeSkinType(this.ajr, i);
        }
        aq.k(this.ctT, w.e.cp_bg_line_d);
    }

    public void ahk() {
        if (this.ctU != null && this.acU.getCurrentItem() == 0) {
            this.ctU.ahk();
        }
    }

    public void ahl() {
        this.ctU.ahl();
    }

    public String getCurrentPageKey() {
        if (this.ctU != null) {
            return this.ctU.getCurrentPageKey();
        }
        return null;
    }

    public boolean aT(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (x.r(list) || x.r(this.ctV) || x.q(list) != x.q(this.ctV)) {
            return false;
        }
        for (int i = 0; i < x.q(list); i++) {
            com.baidu.tieba.homepage.b.a.a aVar = (com.baidu.tieba.homepage.b.a.a) x.c(this.ctV, i);
            com.baidu.tieba.homepage.b.a.a aVar2 = (com.baidu.tieba.homepage.b.a.a) x.c(list, i);
            if (aVar != null && aVar2 != null) {
                if (aVar.cxa == null || aVar2.cxa == null) {
                    return true;
                }
                if (!aVar.cxa.equals(aVar2.cxa)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setPrimary(boolean z) {
        if (this.ctU != null) {
            this.ctU.setPrimary(z);
        }
        if (this.aSi != null && z) {
            this.aSi.setVisibility(com.baidu.adp.lib.util.i.gY() ? 8 : 0);
        }
    }

    public void ahp() {
        this.ctU.a(this.ctZ);
    }

    public void ahq() {
        this.ctX.b(this.ctY);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.ctW = aVar;
    }

    public void onDestroy() {
        if (this.ctO != null) {
            this.ctO.onDestroy();
        }
    }
}
