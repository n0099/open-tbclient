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
    private NoNetworkView gpw;
    private HotRanklistActivity kfC;
    private com.baidu.tieba.hottopic.view.indicator.a kfD;
    private ScrollFragmentAdapter kfE;
    private FrameLayout kfF;
    private com.baidu.tieba.hottopic.view.indicator.c kfG;
    private ImageView kfI;
    private View rootView;
    private int topHeight;
    private NavigationBar mNavigationBar = null;
    private ImageView jYo = null;
    public boolean kfH = true;
    private NoNetworkView.a iQh = null;
    private View.OnClickListener kfJ = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cSg()) {
                b.this.bLq();
                view.setContentDescription("展开");
                return;
            }
            b.this.ctt();
            view.setContentDescription("折叠");
        }
    };
    private final com.baidu.tbadk.widget.layout.e fNu = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.b.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            b.this.topHeight = i2;
            if (b.this.kfE != null) {
                b.this.kfE.f(view, i, i2, i3, i4);
            }
            if (b.this.kfG != null) {
                b.this.kfG.DD(i2);
            }
        }
    };
    private c.a kfK = new c.a() { // from class: com.baidu.tieba.hottopic.view.b.3
        @Override // com.baidu.tieba.hottopic.view.indicator.c.a
        public void cSl() {
            if (b.this.kfD != null) {
                b.this.kfD.cSD();
            }
            if (b.this.kfG != null) {
                b.this.kfG.a((c.a) null);
                b.this.kfH = true;
                b.this.kfG = null;
            }
        }
    };

    public boolean cSg() {
        return this.kfG != null && this.kfG.isShowing();
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.kfC = hotRanklistActivity;
        initView();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.kfC.getPageContext(), i);
        ap.setImageResource(this.jYo, R.drawable.icon_nav_hot_share_selector);
        SvgManager.btW().a(this.jYo, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.kfD.onChangeSkinType(i);
        this.kfC.getLayoutMode().setNightMode(i == 1);
        this.kfC.getLayoutMode().onModeChanged(this.rootView);
        this.gpw.onChangeSkinType(this.kfC.getPageContext(), i);
        this.kfE.ed(null);
        ap.setBackgroundColor(this.kfI, R.color.CAM_X0204);
        ap.setBackgroundColor(this.kfF, R.color.CAM_X0201);
    }

    private void initView() {
        if (this.kfC != null) {
            this.rootView = LayoutInflater.from(this.kfC.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
            this.kfC.setContentView(this.rootView);
            this.kfF = (FrameLayout) this.kfC.findViewById(R.id.topic_tab_widget_content_container);
            this.mNavigationBar = (NavigationBar) this.kfC.findViewById(R.id.topic_fragment_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jYo = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        b.this.kfC.showToast(R.string.topic_share_no_network);
                    } else if (ShareSwitch.isOn() || bh.checkUpIsLogin(b.this.kfC)) {
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dY("obj_param1", "6"));
                        b.this.kfC.cRv();
                    }
                }
            });
            this.mNavigationBar.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
            this.gpw = (NoNetworkView) this.kfC.findViewById(R.id.topic_view_no_network);
            this.kfI = (ImageView) this.rootView.findViewById(R.id.topic_tab_bottom_line);
            this.kfD = new com.baidu.tieba.hottopic.view.indicator.a(this.kfC.getActivity(), this.kfC.findViewById(R.id.topic_tab_container));
            this.kfD.E(this.kfJ);
            ((ObservedChangeLinearLayout) this.kfC.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.fNu);
            this.eRw = (CustomViewPager) this.kfC.findViewById(R.id.topic_tab_widget_view_pager);
            this.kfE = new ScrollFragmentAdapter(this.kfC.getActivity());
            this.eRw.setAdapter(this.kfE);
        }
    }

    public void cSh() {
        this.kfD.setViewPager(this.eRw);
    }

    public int a(p pVar) {
        if (this.kfE == null) {
            return -1;
        }
        return this.kfE.b(pVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.kfE.getCount()) {
            this.eRw.setCurrentItem(i, false);
        }
    }

    public int getCurrentTab() {
        return this.eRw.getCurrentItem();
    }

    public void ctt() {
        com.baidu.tieba.hottopic.data.j jVar;
        if (this.kfG == null) {
            this.kfG = new com.baidu.tieba.hottopic.view.indicator.c(this.kfF);
            this.kfG.a(this.kfK);
        }
        this.kfG.DE(this.topHeight);
        if (!this.kfG.isShowing() && (jVar = (com.baidu.tieba.hottopic.data.j) y.getItem(this.kfE.cSC(), 0)) != null) {
            this.kfG.a(this.kfC.getActivity(), jVar.kef, this.eRw.getCurrentItem());
            if (this.kfD != null) {
                this.kfD.blG();
            }
        }
    }

    public void bLq() {
        if (this.kfG != null) {
            this.kfG.fV(this.kfC.getActivity());
        }
    }

    public void Ds(int i) {
        if (this.gpw != null) {
            this.gpw.setVisibility(i);
        }
    }

    public void g(NoNetworkView.a aVar) {
        this.iQh = aVar;
        if (this.gpw != null) {
            this.gpw.a(this.iQh);
        }
    }

    public View cSi() {
        return this.kfF;
    }

    public void eh(List<com.baidu.tieba.hottopic.data.j> list) {
        this.kfE.ed(list);
    }

    public void cSj() {
        if (this.gpw != null && this.iQh != null) {
            this.gpw.b(this.iQh);
        }
    }

    public void Dt(int i) {
        this.eRw.setVisibility(i);
    }

    public void Du(int i) {
        if (this.kfD != null) {
            this.kfD.setVisibility(i);
        }
    }

    public void Yb() {
        this.kfE.Yb();
    }

    public void showLoadingView() {
        this.kfE.showLoadingView();
    }

    public void cSk() {
        this.kfE.rR(false);
    }

    public boolean onKeyBack() {
        if (cSg()) {
            bLq();
            return true;
        }
        return false;
    }
}
