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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes15.dex */
public class b {
    private CustomViewPager dYQ;
    private NoNetworkView fqQ;
    private HotRanklistActivity iMg;
    private com.baidu.tieba.hottopic.view.indicator.a iMh;
    private ScrollFragmentAdapter iMi;
    private FrameLayout iMj;
    private com.baidu.tieba.hottopic.view.indicator.c iMk;
    private ImageView iMm;
    private View rootView;
    private int topHeight;
    private NavigationBar mNavigationBar = null;
    private ImageView iEP = null;
    public boolean iMl = true;
    private NoNetworkView.a hCK = null;
    private View.OnClickListener iMn = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cps()) {
                b.this.brl();
                view.setContentDescription("展开");
                return;
            }
            b.this.cpu();
            view.setContentDescription("折叠");
        }
    };
    private final com.baidu.tbadk.widget.layout.e eSb = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.b.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            b.this.topHeight = i2;
            if (b.this.iMi != null) {
                b.this.iMi.f(view, i, i2, i3, i4);
            }
            if (b.this.iMk != null) {
                b.this.iMk.yj(i2);
            }
        }
    };
    private c.a iMo = new c.a() { // from class: com.baidu.tieba.hottopic.view.b.3
        @Override // com.baidu.tieba.hottopic.view.indicator.c.a
        public void cpz() {
            if (b.this.iMh != null) {
                b.this.iMh.cpR();
            }
            if (b.this.iMk != null) {
                b.this.iMk.a((c.a) null);
                b.this.iMl = true;
                b.this.iMk = null;
            }
        }
    };

    public boolean cps() {
        return this.iMk != null && this.iMk.isShowing();
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.iMg = hotRanklistActivity;
        initView();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.iMg.getPageContext(), i);
        ao.setImageResource(this.iEP, R.drawable.icon_nav_hot_share_selector);
        SvgManager.baR().a(this.iEP, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iMh.onChangeSkinType(i);
        this.iMg.getLayoutMode().setNightMode(i == 1);
        this.iMg.getLayoutMode().onModeChanged(this.rootView);
        this.fqQ.onChangeSkinType(this.iMg.getPageContext(), i);
        this.iMi.dj(null);
        ao.setBackgroundColor(this.iMm, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.iMj, R.color.cp_bg_line_d);
    }

    private void initView() {
        if (this.iMg != null) {
            this.rootView = LayoutInflater.from(this.iMg.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
            this.iMg.setContentView(this.rootView);
            this.iMj = (FrameLayout) this.iMg.findViewById(R.id.topic_tab_widget_content_container);
            this.mNavigationBar = (NavigationBar) this.iMg.findViewById(R.id.topic_fragment_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iEP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        b.this.iMg.showToast(R.string.topic_share_no_network);
                    } else if (ShareSwitch.isOn() || bf.checkUpIsLogin(b.this.iMg)) {
                        TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dn("obj_param1", "6"));
                        b.this.iMg.coH();
                    }
                }
            });
            this.mNavigationBar.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
            this.fqQ = (NoNetworkView) this.iMg.findViewById(R.id.topic_view_no_network);
            this.iMm = (ImageView) this.rootView.findViewById(R.id.topic_tab_bottom_line);
            this.iMh = new com.baidu.tieba.hottopic.view.indicator.a(this.iMg.getActivity(), this.iMg.findViewById(R.id.topic_tab_container));
            this.iMh.C(this.iMn);
            ((ObservedChangeLinearLayout) this.iMg.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.eSb);
            this.dYQ = (CustomViewPager) this.iMg.findViewById(R.id.topic_tab_widget_view_pager);
            this.iMi = new ScrollFragmentAdapter(this.iMg.getActivity());
            this.dYQ.setAdapter(this.iMi);
        }
    }

    public void cpt() {
        this.iMh.setViewPager(this.dYQ);
    }

    public int a(p pVar) {
        if (this.iMi == null) {
            return -1;
        }
        return this.iMi.b(pVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.iMi.getCount()) {
            this.dYQ.setCurrentItem(i, false);
        }
    }

    public int getCurrentTab() {
        return this.dYQ.getCurrentItem();
    }

    public void cpu() {
        com.baidu.tieba.hottopic.data.j jVar;
        if (this.iMk == null) {
            this.iMk = new com.baidu.tieba.hottopic.view.indicator.c(this.iMj);
            this.iMk.a(this.iMo);
        }
        this.iMk.yk(this.topHeight);
        if (!this.iMk.isShowing() && (jVar = (com.baidu.tieba.hottopic.data.j) x.getItem(this.iMi.cpQ(), 0)) != null) {
            this.iMk.a(this.iMg.getActivity(), jVar.iKJ, this.dYQ.getCurrentItem());
            if (this.iMh != null) {
                this.iMh.aTg();
            }
        }
    }

    public void brl() {
        if (this.iMk != null) {
            this.iMk.eQ(this.iMg.getActivity());
        }
    }

    public void xY(int i) {
        if (this.fqQ != null) {
            this.fqQ.setVisibility(i);
        }
    }

    public void g(NoNetworkView.a aVar) {
        this.hCK = aVar;
        if (this.fqQ != null) {
            this.fqQ.a(this.hCK);
        }
    }

    public View cpv() {
        return this.iMj;
    }

    public void dn(List<com.baidu.tieba.hottopic.data.j> list) {
        this.iMi.dj(list);
    }

    public void cpw() {
        if (this.fqQ != null && this.hCK != null) {
            this.fqQ.b(this.hCK);
        }
    }

    public void xZ(int i) {
        this.dYQ.setVisibility(i);
    }

    public void ya(int i) {
        if (this.iMh != null) {
            this.iMh.setVisibility(i);
        }
    }

    public void bwX() {
        this.iMi.bwX();
    }

    public void showLoadingView() {
        this.iMi.showLoadingView();
    }

    public void cpx() {
        this.iMi.pp(false);
    }

    public boolean cpy() {
        if (cps()) {
            brl();
            return true;
        }
        return false;
    }
}
