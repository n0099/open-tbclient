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
/* loaded from: classes8.dex */
public class b {
    private CustomViewPager eZd;
    private NoNetworkView gxW;
    private HotRanklistActivity kwq;
    private com.baidu.tieba.hottopic.view.indicator.a kwr;
    private ScrollFragmentAdapter kws;
    private FrameLayout kwt;
    private com.baidu.tieba.hottopic.view.indicator.c kwu;
    private ImageView kww;
    private View rootView;
    private int topHeight;
    private NavigationBar mNavigationBar = null;
    private ImageView jTp = null;
    public boolean kwv = true;
    private NoNetworkView.a jdt = null;
    private View.OnClickListener kwx = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cTu()) {
                b.this.bKl();
                view.setContentDescription("展开");
                return;
            }
            b.this.ctH();
            view.setContentDescription("折叠");
        }
    };
    private final com.baidu.tbadk.widget.layout.e fUG = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.b.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void f(View view, int i, int i2, int i3, int i4) {
            b.this.topHeight = i2;
            if (b.this.kws != null) {
                b.this.kws.h(view, i, i2, i3, i4);
            }
            if (b.this.kwu != null) {
                b.this.kwu.CC(i2);
            }
        }
    };
    private c.a kwy = new c.a() { // from class: com.baidu.tieba.hottopic.view.b.3
        @Override // com.baidu.tieba.hottopic.view.indicator.c.a
        public void cTz() {
            if (b.this.kwr != null) {
                b.this.kwr.cTR();
            }
            if (b.this.kwu != null) {
                b.this.kwu.a((c.a) null);
                b.this.kwv = true;
                b.this.kwu = null;
            }
        }
    };

    public boolean cTu() {
        return this.kwu != null && this.kwu.isShowing();
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.kwq = hotRanklistActivity;
        initView();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.kwq.getPageContext(), i);
        ap.setImageResource(this.jTp, R.drawable.icon_nav_hot_share_selector);
        SvgManager.bsR().a(this.jTp, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.kwr.onChangeSkinType(i);
        this.kwq.getLayoutMode().setNightMode(i == 1);
        this.kwq.getLayoutMode().onModeChanged(this.rootView);
        this.gxW.onChangeSkinType(this.kwq.getPageContext(), i);
        this.kws.ei(null);
        ap.setBackgroundColor(this.kww, R.color.CAM_X0204);
        ap.setBackgroundColor(this.kwt, R.color.CAM_X0201);
    }

    private void initView() {
        if (this.kwq != null) {
            this.rootView = LayoutInflater.from(this.kwq.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
            this.kwq.setContentView(this.rootView);
            this.kwt = (FrameLayout) this.kwq.findViewById(R.id.topic_tab_widget_content_container);
            this.mNavigationBar = (NavigationBar) this.kwq.findViewById(R.id.topic_fragment_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jTp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        b.this.kwq.showToast(R.string.topic_share_no_network);
                    } else if (ShareSwitch.isOn() || bh.checkUpIsLogin(b.this.kwq)) {
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("obj_param1", "6"));
                        b.this.kwq.cSJ();
                    }
                }
            });
            this.mNavigationBar.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
            this.gxW = (NoNetworkView) this.kwq.findViewById(R.id.topic_view_no_network);
            this.kww = (ImageView) this.rootView.findViewById(R.id.topic_tab_bottom_line);
            this.kwr = new com.baidu.tieba.hottopic.view.indicator.a(this.kwq.getActivity(), this.kwq.findViewById(R.id.topic_tab_container));
            this.kwr.G(this.kwx);
            ((ObservedChangeLinearLayout) this.kwq.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.fUG);
            this.eZd = (CustomViewPager) this.kwq.findViewById(R.id.topic_tab_widget_view_pager);
            this.kws = new ScrollFragmentAdapter(this.kwq.getActivity());
            this.eZd.setAdapter(this.kws);
        }
    }

    public void cTv() {
        this.kwr.setViewPager(this.eZd);
    }

    public int a(p pVar) {
        if (this.kws == null) {
            return -1;
        }
        return this.kws.b(pVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.kws.getCount()) {
            this.eZd.setCurrentItem(i, false);
        }
    }

    public int getCurrentTab() {
        return this.eZd.getCurrentItem();
    }

    public void ctH() {
        com.baidu.tieba.hottopic.data.j jVar;
        if (this.kwu == null) {
            this.kwu = new com.baidu.tieba.hottopic.view.indicator.c(this.kwt);
            this.kwu.a(this.kwy);
        }
        this.kwu.CD(this.topHeight);
        if (!this.kwu.isShowing() && (jVar = (com.baidu.tieba.hottopic.data.j) y.getItem(this.kws.cTQ(), 0)) != null) {
            this.kwu.a(this.kwq.getActivity(), jVar.kuU, this.eZd.getCurrentItem());
            if (this.kwr != null) {
                this.kwr.bkE();
            }
        }
    }

    public void bKl() {
        if (this.kwu != null) {
            this.kwu.gn(this.kwq.getActivity());
        }
    }

    public void Cr(int i) {
        if (this.gxW != null) {
            this.gxW.setVisibility(i);
        }
    }

    public void g(NoNetworkView.a aVar) {
        this.jdt = aVar;
        if (this.gxW != null) {
            this.gxW.a(this.jdt);
        }
    }

    public View cTw() {
        return this.kwt;
    }

    public void em(List<com.baidu.tieba.hottopic.data.j> list) {
        this.kws.ei(list);
    }

    public void cTx() {
        if (this.gxW != null && this.jdt != null) {
            this.gxW.b(this.jdt);
        }
    }

    public void Cs(int i) {
        this.eZd.setVisibility(i);
    }

    public void Ct(int i) {
        if (this.kwr != null) {
            this.kwr.setVisibility(i);
        }
    }

    public void WZ() {
        this.kws.WZ();
    }

    public void showLoadingView() {
        this.kws.showLoadingView();
    }

    public void cTy() {
        this.kws.sx(false);
    }

    public boolean onKeyBack() {
        if (cTu()) {
            bKl();
            return true;
        }
        return false;
    }
}
