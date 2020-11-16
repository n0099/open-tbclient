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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bh;
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
/* loaded from: classes20.dex */
public class b {
    private CustomViewPager eKk;
    private NoNetworkView ghk;
    private HotRanklistActivity jRW;
    private com.baidu.tieba.hottopic.view.indicator.a jRX;
    private ScrollFragmentAdapter jRY;
    private FrameLayout jRZ;
    private com.baidu.tieba.hottopic.view.indicator.c jSa;
    private ImageView jSc;
    private View rootView;
    private int topHeight;
    private NavigationBar mNavigationBar = null;
    private ImageView jKJ = null;
    public boolean jSb = true;
    private NoNetworkView.a iFn = null;
    private View.OnClickListener jSd = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cMR()) {
                b.this.bHP();
                view.setContentDescription("展开");
                return;
            }
            b.this.cpe();
            view.setContentDescription("折叠");
        }
    };
    private final com.baidu.tbadk.widget.layout.e fFI = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.b.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            b.this.topHeight = i2;
            if (b.this.jRY != null) {
                b.this.jRY.f(view, i, i2, i3, i4);
            }
            if (b.this.jSa != null) {
                b.this.jSa.CO(i2);
            }
        }
    };
    private c.a jSe = new c.a() { // from class: com.baidu.tieba.hottopic.view.b.3
        @Override // com.baidu.tieba.hottopic.view.indicator.c.a
        public void cMW() {
            if (b.this.jRX != null) {
                b.this.jRX.cNo();
            }
            if (b.this.jSa != null) {
                b.this.jSa.a((c.a) null);
                b.this.jSb = true;
                b.this.jSa = null;
            }
        }
    };

    public boolean cMR() {
        return this.jSa != null && this.jSa.isShowing();
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.jRW = hotRanklistActivity;
        initView();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.jRW.getPageContext(), i);
        ap.setImageResource(this.jKJ, R.drawable.icon_nav_hot_share_selector);
        SvgManager.bqB().a(this.jKJ, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jRX.onChangeSkinType(i);
        this.jRW.getLayoutMode().setNightMode(i == 1);
        this.jRW.getLayoutMode().onModeChanged(this.rootView);
        this.ghk.onChangeSkinType(this.jRW.getPageContext(), i);
        this.jRY.dS(null);
        ap.setBackgroundColor(this.jSc, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jRZ, R.color.CAM_X0201);
    }

    private void initView() {
        if (this.jRW != null) {
            this.rootView = LayoutInflater.from(this.jRW.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
            this.jRW.setContentView(this.rootView);
            this.jRZ = (FrameLayout) this.jRW.findViewById(R.id.topic_tab_widget_content_container);
            this.mNavigationBar = (NavigationBar) this.jRW.findViewById(R.id.topic_fragment_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jKJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        b.this.jRW.showToast(R.string.topic_share_no_network);
                    } else if (ShareSwitch.isOn() || bh.checkUpIsLogin(b.this.jRW)) {
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("obj_param1", "6"));
                        b.this.jRW.cMg();
                    }
                }
            });
            this.mNavigationBar.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
            this.ghk = (NoNetworkView) this.jRW.findViewById(R.id.topic_view_no_network);
            this.jSc = (ImageView) this.rootView.findViewById(R.id.topic_tab_bottom_line);
            this.jRX = new com.baidu.tieba.hottopic.view.indicator.a(this.jRW.getActivity(), this.jRW.findViewById(R.id.topic_tab_container));
            this.jRX.E(this.jSd);
            ((ObservedChangeLinearLayout) this.jRW.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.fFI);
            this.eKk = (CustomViewPager) this.jRW.findViewById(R.id.topic_tab_widget_view_pager);
            this.jRY = new ScrollFragmentAdapter(this.jRW.getActivity());
            this.eKk.setAdapter(this.jRY);
        }
    }

    public void cMS() {
        this.jRX.setViewPager(this.eKk);
    }

    public int a(p pVar) {
        if (this.jRY == null) {
            return -1;
        }
        return this.jRY.b(pVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.jRY.getCount()) {
            this.eKk.setCurrentItem(i, false);
        }
    }

    public int getCurrentTab() {
        return this.eKk.getCurrentItem();
    }

    public void cpe() {
        com.baidu.tieba.hottopic.data.j jVar;
        if (this.jSa == null) {
            this.jSa = new com.baidu.tieba.hottopic.view.indicator.c(this.jRZ);
            this.jSa.a(this.jSe);
        }
        this.jSa.CP(this.topHeight);
        if (!this.jSa.isShowing() && (jVar = (com.baidu.tieba.hottopic.data.j) y.getItem(this.jRY.cNn(), 0)) != null) {
            this.jSa.a(this.jRW.getActivity(), jVar.jQA, this.eKk.getCurrentItem());
            if (this.jRX != null) {
                this.jRX.biw();
            }
        }
    }

    public void bHP() {
        if (this.jSa != null) {
            this.jSa.fp(this.jRW.getActivity());
        }
    }

    public void CD(int i) {
        if (this.ghk != null) {
            this.ghk.setVisibility(i);
        }
    }

    public void g(NoNetworkView.a aVar) {
        this.iFn = aVar;
        if (this.ghk != null) {
            this.ghk.a(this.iFn);
        }
    }

    public View cMT() {
        return this.jRZ;
    }

    public void dW(List<com.baidu.tieba.hottopic.data.j> list) {
        this.jRY.dS(list);
    }

    public void cMU() {
        if (this.ghk != null && this.iFn != null) {
            this.ghk.b(this.iFn);
        }
    }

    public void CE(int i) {
        this.eKk.setVisibility(i);
    }

    public void CF(int i) {
        if (this.jRX != null) {
            this.jRX.setVisibility(i);
        }
    }

    public void VB() {
        this.jRY.VB();
    }

    public void showLoadingView() {
        this.jRY.showLoadingView();
    }

    public void cMV() {
        this.jRY.rp(false);
    }

    public boolean onKeyBack() {
        if (cMR()) {
            bHP();
            return true;
        }
        return false;
    }
}
