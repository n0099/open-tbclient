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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.frs.by;
import com.baidu.tieba.homepage.framework.v;
import com.baidu.tieba.homepage.personalize.view.HomeTabBarView;
import com.baidu.tieba.w;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class ScrollFragmentTabHost extends FrameLayout {
    private final com.baidu.tbadk.widget.layout.h aMX;
    private CustomViewPager adw;
    private TbPageContext ajP;
    private PluginErrorTipView bSV;
    private NoNetworkView bbO;
    private u cHS;
    private ObservedChangeLinearLayout cHT;
    private View cHU;
    private HomeTabBarView cHV;
    private FrameLayout cHW;
    private View cHX;
    private com.baidu.tieba.homepage.framework.indicator.a cHY;
    private List<com.baidu.tieba.homepage.b.a.a> cHZ;
    private a cIa;
    private l cIb;
    private v cIc;
    private com.baidu.tieba.homepage.framework.u cId;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void kv(int i);
    }

    public ScrollFragmentTabHost(Context context) {
        super(context);
        this.aMX = new h(this);
        this.cIb = new l();
        this.cIc = new i(this);
        this.cId = new j(this);
        init(context);
    }

    public ScrollFragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aMX = new h(this);
        this.cIb = new l();
        this.cIc = new i(this);
        this.cId = new j(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(w.j.scroll_fragment_tabhost, (ViewGroup) this, true);
        this.cHT = (ObservedChangeLinearLayout) findViewById(w.h.home_page_fragment_tab_layout);
        this.cHU = findViewById(w.h.home_page_statebar_view);
        this.cHV = (HomeTabBarView) findViewById(w.h.home_tab_bar_view);
        this.bSV = (PluginErrorTipView) findViewById(w.h.view_plugin_error_tip);
        this.bbO = (NoNetworkView) findViewById(w.h.view_no_network);
        this.cHW = (FrameLayout) findViewById(w.h.home_pager_container);
        this.adw = (CustomViewPager) findViewById(w.h.tab_widget_view_pager);
        this.cHX = findViewById(w.h.home_statebar_view);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cHU.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        this.cHT.setOnSizeChangeListener(this.aMX);
        this.cHV.setOnPageChangeListener(new k(this));
    }

    public void a(TbPageContext tbPageContext, NoNetworkView.a aVar) {
        this.ajP = tbPageContext;
        this.bbO.a(aVar);
    }

    public boolean amn() {
        return z.s(this.cHZ) <= 0;
    }

    public void bb(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (list != null && list.size() > 0) {
            this.cHZ = list;
            notifyDataSetChanged();
        }
    }

    public List<com.baidu.tieba.homepage.b.a.a> getTagList() {
        return this.cHZ;
    }

    public void notifyDataSetChanged() {
        if (this.cHY != null) {
            this.cHY.ba(this.cHZ);
            this.adw.setAdapter(this.cHY);
            this.cHV.notifyDataSetChanged();
            this.cIb.a(this.cIc);
        }
    }

    public void P(String str, int i) {
    }

    public void c(DataRes dataRes, boolean z, boolean z2) {
        if (this.cHY != null) {
            this.cHY.c(dataRes, z, z2);
        }
    }

    public void amj() {
        if (this.cHY != null) {
            this.cHY.amj();
        }
    }

    public void O(String str, int i) {
        if (this.adw != null) {
            this.cHY.O(str, i);
        }
    }

    public void a(FragmentManager fragmentManager, com.baidu.tieba.homepage.framework.b bVar) {
        this.cHY = new com.baidu.tieba.homepage.framework.indicator.a(this.mContext, fragmentManager, bVar);
        this.cHY.setScrollFragmentTabHost(this);
        this.adw.setOffscreenPageLimit(0);
        this.adw.setAdapter(this.cHY);
        this.cHV.setViewPager(this.adw);
        if (this.cHS != null) {
            this.cHY.setRecommendFrsNavigationAnimDispatcher(this.cHS);
        }
    }

    public boolean amo() {
        return this.cHY != null && this.cHY.getCount() > 0;
    }

    public void g(int i, boolean z) {
        if (i >= 0 && i < this.cHY.getCount()) {
            this.cHV.setTabItemClicked(z);
            this.cHY.kt(i);
            this.adw.setCurrentItem(i);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cHV.setMessageListener(bdUniqueId);
    }

    public FrameLayout getFrameLayout() {
        return this.cHW;
    }

    public int getCurrentItem() {
        return this.adw.getCurrentItem();
    }

    public by getCurrentFragment() {
        return this.cHY.getCurrentFragment();
    }

    public void onChangeSkinType(int i) {
        as.k(this, w.e.cp_bg_line_d);
        as.k(this.cHU, w.e.cp_bg_line_d);
        this.cHV.onChangeSkinType();
        if (this.ajP != null && this.bbO != null) {
            this.bbO.onChangeSkinType(this.ajP, i);
        }
        if (this.cHY != null) {
            this.cHY.dp(i);
        }
        if (this.ajP != null && this.bSV != null) {
            this.bSV.onChangeSkinType(this.ajP, i);
        }
        as.k(this.cHX, w.e.cp_bg_line_d);
    }

    public void amk() {
        if (this.cHY != null && this.adw.getCurrentItem() == 0) {
            this.cHY.amk();
        }
    }

    public void aml() {
        this.cHY.aml();
    }

    public String getCurrentPageKey() {
        if (this.cHY != null) {
            return this.cHY.getCurrentPageKey();
        }
        return null;
    }

    public boolean bc(List<com.baidu.tieba.homepage.b.a.a> list) {
        if (z.t(list) || z.t(this.cHZ) || z.s(list) != z.s(this.cHZ)) {
            return false;
        }
        for (int i = 0; i < z.s(list); i++) {
            com.baidu.tieba.homepage.b.a.a aVar = (com.baidu.tieba.homepage.b.a.a) z.c(this.cHZ, i);
            com.baidu.tieba.homepage.b.a.a aVar2 = (com.baidu.tieba.homepage.b.a.a) z.c(list, i);
            if (aVar != null && aVar2 != null) {
                if (aVar.cLo == null || aVar2.cLo == null) {
                    return true;
                }
                if (!aVar.cLo.equals(aVar2.cLo)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setPrimary(boolean z) {
        if (this.cHY != null) {
            this.cHY.setPrimary(z);
        }
        if (this.bbO != null && z) {
            this.bbO.setVisibility(com.baidu.adp.lib.util.i.gX() ? 8 : 0);
        }
    }

    public void amp() {
        this.cHY.a(this.cId);
    }

    public void amq() {
        this.cIb.b(this.cIc);
    }

    public void setOnTabSelectedListener(a aVar) {
        this.cIa = aVar;
    }

    public void onDestroy() {
        if (this.cHS != null) {
            this.cHS.onDestroy();
        }
    }
}
