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
    private NoNetworkView gyk;
    private HotRanklistActivity kwE;
    private com.baidu.tieba.hottopic.view.indicator.a kwF;
    private ScrollFragmentAdapter kwG;
    private FrameLayout kwH;
    private com.baidu.tieba.hottopic.view.indicator.c kwI;
    private ImageView kwK;
    private View rootView;
    private int topHeight;
    private NavigationBar mNavigationBar = null;
    private ImageView jTD = null;
    public boolean kwJ = true;
    private NoNetworkView.a jdH = null;
    private View.OnClickListener kwL = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cTB()) {
                b.this.bKq();
                view.setContentDescription("展开");
                return;
            }
            b.this.ctO();
            view.setContentDescription("折叠");
        }
    };
    private final com.baidu.tbadk.widget.layout.e fUG = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.b.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void f(View view, int i, int i2, int i3, int i4) {
            b.this.topHeight = i2;
            if (b.this.kwG != null) {
                b.this.kwG.h(view, i, i2, i3, i4);
            }
            if (b.this.kwI != null) {
                b.this.kwI.CC(i2);
            }
        }
    };
    private c.a kwM = new c.a() { // from class: com.baidu.tieba.hottopic.view.b.3
        @Override // com.baidu.tieba.hottopic.view.indicator.c.a
        public void cTG() {
            if (b.this.kwF != null) {
                b.this.kwF.cTY();
            }
            if (b.this.kwI != null) {
                b.this.kwI.a((c.a) null);
                b.this.kwJ = true;
                b.this.kwI = null;
            }
        }
    };

    public boolean cTB() {
        return this.kwI != null && this.kwI.isShowing();
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.kwE = hotRanklistActivity;
        initView();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.kwE.getPageContext(), i);
        ap.setImageResource(this.jTD, R.drawable.icon_nav_hot_share_selector);
        SvgManager.bsR().a(this.jTD, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.kwF.onChangeSkinType(i);
        this.kwE.getLayoutMode().setNightMode(i == 1);
        this.kwE.getLayoutMode().onModeChanged(this.rootView);
        this.gyk.onChangeSkinType(this.kwE.getPageContext(), i);
        this.kwG.ei(null);
        ap.setBackgroundColor(this.kwK, R.color.CAM_X0204);
        ap.setBackgroundColor(this.kwH, R.color.CAM_X0201);
    }

    private void initView() {
        if (this.kwE != null) {
            this.rootView = LayoutInflater.from(this.kwE.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
            this.kwE.setContentView(this.rootView);
            this.kwH = (FrameLayout) this.kwE.findViewById(R.id.topic_tab_widget_content_container);
            this.mNavigationBar = (NavigationBar) this.kwE.findViewById(R.id.topic_fragment_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jTD = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        b.this.kwE.showToast(R.string.topic_share_no_network);
                    } else if (ShareSwitch.isOn() || bh.checkUpIsLogin(b.this.kwE)) {
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("obj_param1", "6"));
                        b.this.kwE.cSQ();
                    }
                }
            });
            this.mNavigationBar.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
            this.gyk = (NoNetworkView) this.kwE.findViewById(R.id.topic_view_no_network);
            this.kwK = (ImageView) this.rootView.findViewById(R.id.topic_tab_bottom_line);
            this.kwF = new com.baidu.tieba.hottopic.view.indicator.a(this.kwE.getActivity(), this.kwE.findViewById(R.id.topic_tab_container));
            this.kwF.G(this.kwL);
            ((ObservedChangeLinearLayout) this.kwE.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.fUG);
            this.eZd = (CustomViewPager) this.kwE.findViewById(R.id.topic_tab_widget_view_pager);
            this.kwG = new ScrollFragmentAdapter(this.kwE.getActivity());
            this.eZd.setAdapter(this.kwG);
        }
    }

    public void cTC() {
        this.kwF.setViewPager(this.eZd);
    }

    public int a(p pVar) {
        if (this.kwG == null) {
            return -1;
        }
        return this.kwG.b(pVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.kwG.getCount()) {
            this.eZd.setCurrentItem(i, false);
        }
    }

    public int getCurrentTab() {
        return this.eZd.getCurrentItem();
    }

    public void ctO() {
        com.baidu.tieba.hottopic.data.j jVar;
        if (this.kwI == null) {
            this.kwI = new com.baidu.tieba.hottopic.view.indicator.c(this.kwH);
            this.kwI.a(this.kwM);
        }
        this.kwI.CD(this.topHeight);
        if (!this.kwI.isShowing() && (jVar = (com.baidu.tieba.hottopic.data.j) y.getItem(this.kwG.cTX(), 0)) != null) {
            this.kwI.a(this.kwE.getActivity(), jVar.kvi, this.eZd.getCurrentItem());
            if (this.kwF != null) {
                this.kwF.bkE();
            }
        }
    }

    public void bKq() {
        if (this.kwI != null) {
            this.kwI.gn(this.kwE.getActivity());
        }
    }

    public void Cr(int i) {
        if (this.gyk != null) {
            this.gyk.setVisibility(i);
        }
    }

    public void g(NoNetworkView.a aVar) {
        this.jdH = aVar;
        if (this.gyk != null) {
            this.gyk.a(this.jdH);
        }
    }

    public View cTD() {
        return this.kwH;
    }

    public void em(List<com.baidu.tieba.hottopic.data.j> list) {
        this.kwG.ei(list);
    }

    public void cTE() {
        if (this.gyk != null && this.jdH != null) {
            this.gyk.b(this.jdH);
        }
    }

    public void Cs(int i) {
        this.eZd.setVisibility(i);
    }

    public void Ct(int i) {
        if (this.kwF != null) {
            this.kwF.setVisibility(i);
        }
    }

    public void WZ() {
        this.kwG.WZ();
    }

    public void showLoadingView() {
        this.kwG.showLoadingView();
    }

    public void cTF() {
        this.kwG.sx(false);
    }

    public boolean onKeyBack() {
        if (cTB()) {
            bKq();
            return true;
        }
        return false;
    }
}
