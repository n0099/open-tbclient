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
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.homepage.framework.u;
import com.baidu.tieba.homepage.framework.v;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import com.baidu.tieba.w;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private final com.baidu.tbadk.widget.layout.h aLH;
    private NoNetworkView aZX;
    private CustomViewPager acM;
    private TbPageContext ajh;
    private PluginErrorTipView bMu;
    private t cAg;
    private ObservedChangeLinearLayout cAh;
    private View cAi;
    private HomeTabBarView cAj;
    private FrameLayout cAk;
    private View cAl;
    private com.baidu.tieba.homepage.framework.indicator.a cAm;
    private List<com.baidu.tieba.homepage.b.a.a> cAn;
    private a cAo;
    private l cAp;
    private v cAq;
    private u cAr;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void kk(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.aLH = new h(this);
        this.cAp = new l();
        this.cAq = new i(this);
        this.cAr = new j(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLH = new h(this);
        this.cAp = new l();
        this.cAq = new i(this);
        this.cAr = new j(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(w.j.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.cAh = (ObservedChangeLinearLayout) findViewById(w.h.home_page_fragment_tab_layout);
        this.cAi = findViewById(w.h.home_page_statebar_view);
        this.cAj = (HomeTabBarView) findViewById(w.h.home_tab_bar_view);
        this.bMu = (PluginErrorTipView) findViewById(w.h.view_plugin_error_tip);
        this.aZX = (NoNetworkView) findViewById(w.h.view_no_network);
        this.cAk = (FrameLayout) findViewById(w.h.home_pager_container);
        this.acM = (CustomViewPager) findViewById(w.h.tab_widget_view_pager);
        this.cAl = findViewById(w.h.home_statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cAi.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.cAh.setOnSizeChangeListener(this.aLH);
        this.cAj.setOnPageChangeListener(new k(this));
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.ajh = tbPageContext;
        this.aZX.a(aVar);
    }

    public boolean aiC() {
        return x.q(this.cAn) <= 0;
    }

    public void aS(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (list != null && list.size() > 0) {
            this.cAn = list;
            notifyDataSetChanged();
        }
    }

    public List<com.baidu.tieba.homepage.b.a.a> getTagList() {
        return this.cAn;
    }

    public void notifyDataSetChanged() {
        if (this.cAm != null) {
            this.cAm.aR(this.cAn);
            this.acM.setAdapter(this.cAm);
            this.cAj.notifyDataSetChanged();
            this.cAp.a(this.cAq);
        }
    }

    public void N(String str, int i) {
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.cAm != null) {
            this.cAm.c(dataRes, z, z2);
        }
    }

    public void aiy() {
        if (this.cAm != null) {
            this.cAm.aiy();
        }
    }

    public void M(String str, int i) {
        if (this.acM != null) {
            this.cAm.M(str, i);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar) {
        this.cAm = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar);
        this.cAm.setScrollFragmentTabHost(this);
        this.acM.setOffscreenPageLimit(0);
        this.acM.setAdapter(this.cAm);
        this.cAj.setViewPager(this.acM);
        if (this.cAg != null) {
            this.cAm.setRecommendFrsNavigationAnimDispatcher(this.cAg);
        }
    }

    public boolean aiD() {
        return this.cAm != null && this.cAm.getCount() > 0;
    }

    public void g(int i, boolean z) {
        if (i >= 0 && i < this.cAm.getCount()) {
            this.cAj.setTabItemClicked(z);
            this.cAm.ki(i);
            this.acM.setCurrentItem(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cAj.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.cAk;
    }

    public int getCurrentItem() {
        return this.acM.getCurrentItem();
    }

    public bx getCurrentFragment() {
        return this.cAm.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        aq.k(this, w.e.cp_bg_line_d);
        aq.k(this.cAi, w.e.cp_bg_line_d);
        this.cAj.onChangeSkinType();
        if (this.ajh != null && this.aZX != null) {
            this.aZX.onChangeSkinType(this.ajh, i);
        }
        if (this.cAm != null) {
            this.cAm.dn(i);
        }
        if (this.ajh != null && this.bMu != null) {
            this.bMu.onChangeSkinType(this.ajh, i);
        }
        aq.k(this.cAl, w.e.cp_bg_line_d);
    }

    public void aiz() {
        if (this.cAm != null && this.acM.getCurrentItem() == 0) {
            this.cAm.aiz();
        }
    }

    public void aiA() {
        this.cAm.aiA();
    }

    public String getCurrentPageKey() {
        if (this.cAm != null) {
            return this.cAm.getCurrentPageKey();
        }
        return null;
    }

    public boolean aT(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (x.r(list) || x.r(this.cAn) || x.q(list) != x.q(this.cAn)) {
            return false;
        }
        for (int i = 0; i < x.q(list); i++) {
            com.baidu.tieba.homepage.b.a.a aVar = (com.baidu.tieba.homepage.b.a.a) x.c(this.cAn, i);
            com.baidu.tieba.homepage.b.a.a aVar2 = (com.baidu.tieba.homepage.b.a.a) x.c(list, i);
            if (aVar != null && aVar2 != null) {
                if (aVar.cDr == null || aVar2.cDr == null) {
                    return true;
                }
                if (!aVar.cDr.equals(aVar2.cDr)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setPrimary(boolean z) {
        if (this.cAm != null) {
            this.cAm.setPrimary(z);
        }
        if (this.aZX != null && z) {
            this.aZX.setVisibility(com.baidu.adp.lib.util.i.gY() ? 8 : 0);
        }
    }

    public void aiE() {
        this.cAm.a(this.cAr);
    }

    public void aiF() {
        this.cAp.b(this.cAq);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cAo = aVar;
    }

    public void onDestroy() {
        if (this.cAg != null) {
            this.cAg.onDestroy();
        }
    }
}
