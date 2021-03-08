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
/* loaded from: classes7.dex */
public class b {
    private CustomViewPager faC;
    private NoNetworkView gzT;
    private HotRanklistActivity kyG;
    private com.baidu.tieba.hottopic.view.indicator.a kyH;
    private ScrollFragmentAdapter kyI;
    private FrameLayout kyJ;
    private com.baidu.tieba.hottopic.view.indicator.c kyK;
    private ImageView kyM;
    private View rootView;
    private int topHeight;
    private NavigationBar mNavigationBar = null;
    private ImageView jVU = null;
    public boolean kyL = true;
    private NoNetworkView.a jfq = null;
    private View.OnClickListener kyN = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cTI()) {
                b.this.bKu();
                view.setContentDescription("展开");
                return;
            }
            b.this.ctU();
            view.setContentDescription("折叠");
        }
    };
    private final com.baidu.tbadk.widget.layout.e fWg = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.b.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void f(View view, int i, int i2, int i3, int i4) {
            b.this.topHeight = i2;
            if (b.this.kyI != null) {
                b.this.kyI.h(view, i, i2, i3, i4);
            }
            if (b.this.kyK != null) {
                b.this.kyK.CF(i2);
            }
        }
    };
    private c.a kyO = new c.a() { // from class: com.baidu.tieba.hottopic.view.b.3
        @Override // com.baidu.tieba.hottopic.view.indicator.c.a
        public void cTN() {
            if (b.this.kyH != null) {
                b.this.kyH.cUf();
            }
            if (b.this.kyK != null) {
                b.this.kyK.a((c.a) null);
                b.this.kyL = true;
                b.this.kyK = null;
            }
        }
    };

    public boolean cTI() {
        return this.kyK != null && this.kyK.isShowing();
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.kyG = hotRanklistActivity;
        initView();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.kyG.getPageContext(), i);
        ap.setImageResource(this.jVU, R.drawable.icon_nav_hot_share_selector);
        SvgManager.bsU().a(this.jVU, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.kyH.onChangeSkinType(i);
        this.kyG.getLayoutMode().setNightMode(i == 1);
        this.kyG.getLayoutMode().onModeChanged(this.rootView);
        this.gzT.onChangeSkinType(this.kyG.getPageContext(), i);
        this.kyI.ei(null);
        ap.setBackgroundColor(this.kyM, R.color.CAM_X0204);
        ap.setBackgroundColor(this.kyJ, R.color.CAM_X0201);
    }

    private void initView() {
        if (this.kyG != null) {
            this.rootView = LayoutInflater.from(this.kyG.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
            this.kyG.setContentView(this.rootView);
            this.kyJ = (FrameLayout) this.kyG.findViewById(R.id.topic_tab_widget_content_container);
            this.mNavigationBar = (NavigationBar) this.kyG.findViewById(R.id.topic_fragment_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jVU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        b.this.kyG.showToast(R.string.topic_share_no_network);
                    } else if (ShareSwitch.isOn() || bh.checkUpIsLogin(b.this.kyG)) {
                        TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("obj_param1", "6"));
                        b.this.kyG.cSX();
                    }
                }
            });
            this.mNavigationBar.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
            this.gzT = (NoNetworkView) this.kyG.findViewById(R.id.topic_view_no_network);
            this.kyM = (ImageView) this.rootView.findViewById(R.id.topic_tab_bottom_line);
            this.kyH = new com.baidu.tieba.hottopic.view.indicator.a(this.kyG.getActivity(), this.kyG.findViewById(R.id.topic_tab_container));
            this.kyH.H(this.kyN);
            ((ObservedChangeLinearLayout) this.kyG.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.fWg);
            this.faC = (CustomViewPager) this.kyG.findViewById(R.id.topic_tab_widget_view_pager);
            this.kyI = new ScrollFragmentAdapter(this.kyG.getActivity());
            this.faC.setAdapter(this.kyI);
        }
    }

    public void cTJ() {
        this.kyH.setViewPager(this.faC);
    }

    public int a(p pVar) {
        if (this.kyI == null) {
            return -1;
        }
        return this.kyI.b(pVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.kyI.getCount()) {
            this.faC.setCurrentItem(i, false);
        }
    }

    public int getCurrentTab() {
        return this.faC.getCurrentItem();
    }

    public void ctU() {
        com.baidu.tieba.hottopic.data.j jVar;
        if (this.kyK == null) {
            this.kyK = new com.baidu.tieba.hottopic.view.indicator.c(this.kyJ);
            this.kyK.a(this.kyO);
        }
        this.kyK.CG(this.topHeight);
        if (!this.kyK.isShowing() && (jVar = (com.baidu.tieba.hottopic.data.j) y.getItem(this.kyI.cUe(), 0)) != null) {
            this.kyK.a(this.kyG.getActivity(), jVar.kxk, this.faC.getCurrentItem());
            if (this.kyH != null) {
                this.kyH.bkG();
            }
        }
    }

    public void bKu() {
        if (this.kyK != null) {
            this.kyK.gm(this.kyG.getActivity());
        }
    }

    public void Cu(int i) {
        if (this.gzT != null) {
            this.gzT.setVisibility(i);
        }
    }

    public void g(NoNetworkView.a aVar) {
        this.jfq = aVar;
        if (this.gzT != null) {
            this.gzT.a(this.jfq);
        }
    }

    public View cTK() {
        return this.kyJ;
    }

    public void em(List<com.baidu.tieba.hottopic.data.j> list) {
        this.kyI.ei(list);
    }

    public void cTL() {
        if (this.gzT != null && this.jfq != null) {
            this.gzT.b(this.jfq);
        }
    }

    public void Cv(int i) {
        this.faC.setVisibility(i);
    }

    public void Cw(int i) {
        if (this.kyH != null) {
            this.kyH.setVisibility(i);
        }
    }

    public void Xc() {
        this.kyI.Xc();
    }

    public void showLoadingView() {
        this.kyI.showLoadingView();
    }

    public void cTM() {
        this.kyI.sx(false);
    }

    public boolean onKeyBack() {
        if (cTI()) {
            bKu();
            return true;
        }
        return false;
    }
}
