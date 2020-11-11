package com.baidu.tieba.hottopic.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.data.p;
import com.baidu.tieba.hottopic.view.indicator.ScrollFragmentAdapter;
import com.baidu.tieba.hottopic.view.indicator.c;
import java.util.List;
/* loaded from: classes21.dex */
public class b {
    private CustomViewPager eLl;
    private NoNetworkView ghD;
    private HotRanklistActivity jRm;
    private com.baidu.tieba.hottopic.view.indicator.a jRn;
    private ScrollFragmentAdapter jRo;
    private FrameLayout jRp;
    private com.baidu.tieba.hottopic.view.indicator.c jRq;
    private ImageView jRs;
    private View rootView;
    private int topHeight;
    private NavigationBar mNavigationBar = null;
    private ImageView jJY = null;
    public boolean jRr = true;
    private NoNetworkView.a iEz = null;
    private View.OnClickListener jRt = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cNk()) {
                b.this.bIw();
                view.setContentDescription("展开");
                return;
            }
            b.this.cNm();
            view.setContentDescription("折叠");
        }
    };
    private final com.baidu.tbadk.widget.layout.e fGg = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.b.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            b.this.topHeight = i2;
            if (b.this.jRo != null) {
                b.this.jRo.f(view, i, i2, i3, i4);
            }
            if (b.this.jRq != null) {
                b.this.jRq.Cq(i2);
            }
        }
    };
    private c.a jRu = new c.a() { // from class: com.baidu.tieba.hottopic.view.b.3
        @Override // com.baidu.tieba.hottopic.view.indicator.c.a
        public void cNq() {
            if (b.this.jRn != null) {
                b.this.jRn.cNI();
            }
            if (b.this.jRq != null) {
                b.this.jRq.a((c.a) null);
                b.this.jRr = true;
                b.this.jRq = null;
            }
        }
    };

    public boolean cNk() {
        return this.jRq != null && this.jRq.isShowing();
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.jRm = hotRanklistActivity;
        initView();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.jRm.getPageContext(), i);
        ap.setImageResource(this.jJY, R.drawable.icon_nav_hot_share_selector);
        SvgManager.brn().a(this.jJY, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jRn.onChangeSkinType(i);
        this.jRm.getLayoutMode().setNightMode(i == 1);
        this.jRm.getLayoutMode().onModeChanged(this.rootView);
        this.ghD.onChangeSkinType(this.jRm.getPageContext(), i);
        this.jRo.dS(null);
        ap.setBackgroundColor(this.jRs, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.jRp, R.color.cp_bg_line_d);
    }

    private void initView() {
        if (this.jRm != null) {
            this.rootView = LayoutInflater.from(this.jRm.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
            this.jRm.setContentView(this.rootView);
            this.jRp = (FrameLayout) this.jRm.findViewById(R.id.topic_tab_widget_content_container);
            this.mNavigationBar = (NavigationBar) this.jRm.findViewById(R.id.topic_fragment_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jJY = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        b.this.jRm.showToast(R.string.topic_share_no_network);
                    } else if (ShareSwitch.isOn() || bg.checkUpIsLogin(b.this.jRm)) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("obj_param1", "6"));
                        b.this.jRm.cMz();
                    }
                }
            });
            this.mNavigationBar.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
            this.ghD = (NoNetworkView) this.jRm.findViewById(R.id.topic_view_no_network);
            this.jRs = (ImageView) this.rootView.findViewById(R.id.topic_tab_bottom_line);
            this.jRn = new com.baidu.tieba.hottopic.view.indicator.a(this.jRm.getActivity(), this.jRm.findViewById(R.id.topic_tab_container));
            this.jRn.E(this.jRt);
            ((ObservedChangeLinearLayout) this.jRm.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.fGg);
            this.eLl = (CustomViewPager) this.jRm.findViewById(R.id.topic_tab_widget_view_pager);
            this.jRo = new ScrollFragmentAdapter(this.jRm.getActivity());
            this.eLl.setAdapter(this.jRo);
        }
    }

    public void cNl() {
        this.jRn.setViewPager(this.eLl);
    }

    public int a(p pVar) {
        if (this.jRo == null) {
            return -1;
        }
        return this.jRo.b(pVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.jRo.getCount()) {
            this.eLl.setCurrentItem(i, false);
        }
    }

    public int getCurrentTab() {
        return this.eLl.getCurrentItem();
    }

    public void cNm() {
        com.baidu.tieba.hottopic.data.j jVar;
        if (this.jRq == null) {
            this.jRq = new com.baidu.tieba.hottopic.view.indicator.c(this.jRp);
            this.jRq.a(this.jRu);
        }
        this.jRq.Cr(this.topHeight);
        if (!this.jRq.isShowing() && (jVar = (com.baidu.tieba.hottopic.data.j) y.getItem(this.jRo.cNH(), 0)) != null) {
            this.jRq.a(this.jRm.getActivity(), jVar.jPQ, this.eLl.getCurrentItem());
            if (this.jRn != null) {
                this.jRn.bjs();
            }
        }
    }

    public void bIw() {
        if (this.jRq != null) {
            this.jRq.fq(this.jRm.getActivity());
        }
    }

    public void Cf(int i) {
        if (this.ghD != null) {
            this.ghD.setVisibility(i);
        }
    }

    public void g(NoNetworkView.a aVar) {
        this.iEz = aVar;
        if (this.ghD != null) {
            this.ghD.a(this.iEz);
        }
    }

    public View cNn() {
        return this.jRp;
    }

    public void dW(List<com.baidu.tieba.hottopic.data.j> list) {
        this.jRo.dS(list);
    }

    public void cNo() {
        if (this.ghD != null && this.iEz != null) {
            this.ghD.b(this.iEz);
        }
    }

    public void Cg(int i) {
        this.eLl.setVisibility(i);
    }

    public void Ch(int i) {
        if (this.jRn != null) {
            this.jRn.setVisibility(i);
        }
    }

    public void Wk() {
        this.jRo.Wk();
    }

    public void showLoadingView() {
        this.jRo.showLoadingView();
    }

    public void cNp() {
        this.jRo.rm(false);
    }

    public boolean onKeyBack() {
        if (cNk()) {
            bIw();
            return true;
        }
        return false;
    }
}
