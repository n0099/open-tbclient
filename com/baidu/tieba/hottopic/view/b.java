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
/* loaded from: classes21.dex */
public class b {
    private CustomViewPager eRw;
    private NoNetworkView gpu;
    private HotRanklistActivity kfA;
    private com.baidu.tieba.hottopic.view.indicator.a kfB;
    private ScrollFragmentAdapter kfC;
    private FrameLayout kfD;
    private com.baidu.tieba.hottopic.view.indicator.c kfE;
    private ImageView kfG;
    private View rootView;
    private int topHeight;
    private NavigationBar mNavigationBar = null;
    private ImageView jYm = null;
    public boolean kfF = true;
    private NoNetworkView.a iQf = null;
    private View.OnClickListener kfH = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cSf()) {
                b.this.bLp();
                view.setContentDescription("展开");
                return;
            }
            b.this.cts();
            view.setContentDescription("折叠");
        }
    };
    private final com.baidu.tbadk.widget.layout.e fNu = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.b.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            b.this.topHeight = i2;
            if (b.this.kfC != null) {
                b.this.kfC.f(view, i, i2, i3, i4);
            }
            if (b.this.kfE != null) {
                b.this.kfE.DD(i2);
            }
        }
    };
    private c.a kfI = new c.a() { // from class: com.baidu.tieba.hottopic.view.b.3
        @Override // com.baidu.tieba.hottopic.view.indicator.c.a
        public void cSk() {
            if (b.this.kfB != null) {
                b.this.kfB.cSC();
            }
            if (b.this.kfE != null) {
                b.this.kfE.a((c.a) null);
                b.this.kfF = true;
                b.this.kfE = null;
            }
        }
    };

    public boolean cSf() {
        return this.kfE != null && this.kfE.isShowing();
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.kfA = hotRanklistActivity;
        initView();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.kfA.getPageContext(), i);
        ap.setImageResource(this.jYm, R.drawable.icon_nav_hot_share_selector);
        SvgManager.btW().a(this.jYm, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.kfB.onChangeSkinType(i);
        this.kfA.getLayoutMode().setNightMode(i == 1);
        this.kfA.getLayoutMode().onModeChanged(this.rootView);
        this.gpu.onChangeSkinType(this.kfA.getPageContext(), i);
        this.kfC.ed(null);
        ap.setBackgroundColor(this.kfG, R.color.CAM_X0204);
        ap.setBackgroundColor(this.kfD, R.color.CAM_X0201);
    }

    private void initView() {
        if (this.kfA != null) {
            this.rootView = LayoutInflater.from(this.kfA.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
            this.kfA.setContentView(this.rootView);
            this.kfD = (FrameLayout) this.kfA.findViewById(R.id.topic_tab_widget_content_container);
            this.mNavigationBar = (NavigationBar) this.kfA.findViewById(R.id.topic_fragment_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jYm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        b.this.kfA.showToast(R.string.topic_share_no_network);
                    } else if (ShareSwitch.isOn() || bh.checkUpIsLogin(b.this.kfA)) {
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dY("obj_param1", "6"));
                        b.this.kfA.cRu();
                    }
                }
            });
            this.mNavigationBar.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
            this.gpu = (NoNetworkView) this.kfA.findViewById(R.id.topic_view_no_network);
            this.kfG = (ImageView) this.rootView.findViewById(R.id.topic_tab_bottom_line);
            this.kfB = new com.baidu.tieba.hottopic.view.indicator.a(this.kfA.getActivity(), this.kfA.findViewById(R.id.topic_tab_container));
            this.kfB.E(this.kfH);
            ((ObservedChangeLinearLayout) this.kfA.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.fNu);
            this.eRw = (CustomViewPager) this.kfA.findViewById(R.id.topic_tab_widget_view_pager);
            this.kfC = new ScrollFragmentAdapter(this.kfA.getActivity());
            this.eRw.setAdapter(this.kfC);
        }
    }

    public void cSg() {
        this.kfB.setViewPager(this.eRw);
    }

    public int a(p pVar) {
        if (this.kfC == null) {
            return -1;
        }
        return this.kfC.b(pVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.kfC.getCount()) {
            this.eRw.setCurrentItem(i, false);
        }
    }

    public int getCurrentTab() {
        return this.eRw.getCurrentItem();
    }

    public void cts() {
        com.baidu.tieba.hottopic.data.j jVar;
        if (this.kfE == null) {
            this.kfE = new com.baidu.tieba.hottopic.view.indicator.c(this.kfD);
            this.kfE.a(this.kfI);
        }
        this.kfE.DE(this.topHeight);
        if (!this.kfE.isShowing() && (jVar = (com.baidu.tieba.hottopic.data.j) y.getItem(this.kfC.cSB(), 0)) != null) {
            this.kfE.a(this.kfA.getActivity(), jVar.ked, this.eRw.getCurrentItem());
            if (this.kfB != null) {
                this.kfB.blG();
            }
        }
    }

    public void bLp() {
        if (this.kfE != null) {
            this.kfE.fV(this.kfA.getActivity());
        }
    }

    public void Ds(int i) {
        if (this.gpu != null) {
            this.gpu.setVisibility(i);
        }
    }

    public void g(NoNetworkView.a aVar) {
        this.iQf = aVar;
        if (this.gpu != null) {
            this.gpu.a(this.iQf);
        }
    }

    public View cSh() {
        return this.kfD;
    }

    public void eh(List<com.baidu.tieba.hottopic.data.j> list) {
        this.kfC.ed(list);
    }

    public void cSi() {
        if (this.gpu != null && this.iQf != null) {
            this.gpu.b(this.iQf);
        }
    }

    public void Dt(int i) {
        this.eRw.setVisibility(i);
    }

    public void Du(int i) {
        if (this.kfB != null) {
            this.kfB.setVisibility(i);
        }
    }

    public void Yb() {
        this.kfC.Yb();
    }

    public void showLoadingView() {
        this.kfC.showLoadingView();
    }

    public void cSj() {
        this.kfC.rR(false);
    }

    public boolean onKeyBack() {
        if (cSf()) {
            bLp();
            return true;
        }
        return false;
    }
}
