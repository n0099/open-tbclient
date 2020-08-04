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
    private HotRanklistActivity iMi;
    private com.baidu.tieba.hottopic.view.indicator.a iMj;
    private ScrollFragmentAdapter iMk;
    private FrameLayout iMl;
    private com.baidu.tieba.hottopic.view.indicator.c iMm;
    private ImageView iMo;
    private View rootView;
    private int topHeight;
    private NavigationBar mNavigationBar = null;
    private ImageView iER = null;
    public boolean iMn = true;
    private NoNetworkView.a hCK = null;
    private View.OnClickListener iMp = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.1
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
            if (b.this.iMk != null) {
                b.this.iMk.f(view, i, i2, i3, i4);
            }
            if (b.this.iMm != null) {
                b.this.iMm.yj(i2);
            }
        }
    };
    private c.a iMq = new c.a() { // from class: com.baidu.tieba.hottopic.view.b.3
        @Override // com.baidu.tieba.hottopic.view.indicator.c.a
        public void cpz() {
            if (b.this.iMj != null) {
                b.this.iMj.cpR();
            }
            if (b.this.iMm != null) {
                b.this.iMm.a((c.a) null);
                b.this.iMn = true;
                b.this.iMm = null;
            }
        }
    };

    public boolean cps() {
        return this.iMm != null && this.iMm.isShowing();
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.iMi = hotRanklistActivity;
        initView();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.iMi.getPageContext(), i);
        ao.setImageResource(this.iER, R.drawable.icon_nav_hot_share_selector);
        SvgManager.baR().a(this.iER, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iMj.onChangeSkinType(i);
        this.iMi.getLayoutMode().setNightMode(i == 1);
        this.iMi.getLayoutMode().onModeChanged(this.rootView);
        this.fqQ.onChangeSkinType(this.iMi.getPageContext(), i);
        this.iMk.dj(null);
        ao.setBackgroundColor(this.iMo, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this.iMl, R.color.cp_bg_line_d);
    }

    private void initView() {
        if (this.iMi != null) {
            this.rootView = LayoutInflater.from(this.iMi.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
            this.iMi.setContentView(this.rootView);
            this.iMl = (FrameLayout) this.iMi.findViewById(R.id.topic_tab_widget_content_container);
            this.mNavigationBar = (NavigationBar) this.iMi.findViewById(R.id.topic_fragment_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iER = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        b.this.iMi.showToast(R.string.topic_share_no_network);
                    } else if (ShareSwitch.isOn() || bf.checkUpIsLogin(b.this.iMi)) {
                        TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dn("obj_param1", "6"));
                        b.this.iMi.coH();
                    }
                }
            });
            this.mNavigationBar.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
            this.fqQ = (NoNetworkView) this.iMi.findViewById(R.id.topic_view_no_network);
            this.iMo = (ImageView) this.rootView.findViewById(R.id.topic_tab_bottom_line);
            this.iMj = new com.baidu.tieba.hottopic.view.indicator.a(this.iMi.getActivity(), this.iMi.findViewById(R.id.topic_tab_container));
            this.iMj.C(this.iMp);
            ((ObservedChangeLinearLayout) this.iMi.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.eSb);
            this.dYQ = (CustomViewPager) this.iMi.findViewById(R.id.topic_tab_widget_view_pager);
            this.iMk = new ScrollFragmentAdapter(this.iMi.getActivity());
            this.dYQ.setAdapter(this.iMk);
        }
    }

    public void cpt() {
        this.iMj.setViewPager(this.dYQ);
    }

    public int a(p pVar) {
        if (this.iMk == null) {
            return -1;
        }
        return this.iMk.b(pVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.iMk.getCount()) {
            this.dYQ.setCurrentItem(i, false);
        }
    }

    public int getCurrentTab() {
        return this.dYQ.getCurrentItem();
    }

    public void cpu() {
        com.baidu.tieba.hottopic.data.j jVar;
        if (this.iMm == null) {
            this.iMm = new com.baidu.tieba.hottopic.view.indicator.c(this.iMl);
            this.iMm.a(this.iMq);
        }
        this.iMm.yk(this.topHeight);
        if (!this.iMm.isShowing() && (jVar = (com.baidu.tieba.hottopic.data.j) x.getItem(this.iMk.cpQ(), 0)) != null) {
            this.iMm.a(this.iMi.getActivity(), jVar.iKL, this.dYQ.getCurrentItem());
            if (this.iMj != null) {
                this.iMj.aTg();
            }
        }
    }

    public void brl() {
        if (this.iMm != null) {
            this.iMm.eQ(this.iMi.getActivity());
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
        return this.iMl;
    }

    public void dn(List<com.baidu.tieba.hottopic.data.j> list) {
        this.iMk.dj(list);
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
        if (this.iMj != null) {
            this.iMj.setVisibility(i);
        }
    }

    public void bwX() {
        this.iMk.bwX();
    }

    public void showLoadingView() {
        this.iMk.showLoadingView();
    }

    public void cpx() {
        this.iMk.pp(false);
    }

    public boolean cpy() {
        if (cps()) {
            brl();
            return true;
        }
        return false;
    }
}
