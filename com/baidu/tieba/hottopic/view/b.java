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
/* loaded from: classes20.dex */
public class b {
    private CustomViewPager ekP;
    private NoNetworkView fFC;
    private HotRanklistActivity jjS;
    private com.baidu.tieba.hottopic.view.indicator.a jjT;
    private ScrollFragmentAdapter jjU;
    private FrameLayout jjV;
    private com.baidu.tieba.hottopic.view.indicator.c jjW;
    private ImageView jjY;
    private View rootView;
    private int topHeight;
    private NavigationBar mNavigationBar = null;
    private ImageView jcB = null;
    public boolean jjX = true;
    private NoNetworkView.a hXf = null;
    private View.OnClickListener jjZ = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cDT()) {
                b.this.bBs();
                view.setContentDescription("展开");
                return;
            }
            b.this.cDV();
            view.setContentDescription("折叠");
        }
    };
    private final com.baidu.tbadk.widget.layout.e ffE = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.b.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            b.this.topHeight = i2;
            if (b.this.jjU != null) {
                b.this.jjU.f(view, i, i2, i3, i4);
            }
            if (b.this.jjW != null) {
                b.this.jjW.Be(i2);
            }
        }
    };
    private c.a jka = new c.a() { // from class: com.baidu.tieba.hottopic.view.b.3
        @Override // com.baidu.tieba.hottopic.view.indicator.c.a
        public void cDZ() {
            if (b.this.jjT != null) {
                b.this.jjT.cEr();
            }
            if (b.this.jjW != null) {
                b.this.jjW.a((c.a) null);
                b.this.jjX = true;
                b.this.jjW = null;
            }
        }
    };

    public boolean cDT() {
        return this.jjW != null && this.jjW.isShowing();
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.jjS = hotRanklistActivity;
        initView();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.jjS.getPageContext(), i);
        ap.setImageResource(this.jcB, R.drawable.icon_nav_hot_share_selector);
        SvgManager.bkl().a(this.jcB, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jjT.onChangeSkinType(i);
        this.jjS.getLayoutMode().setNightMode(i == 1);
        this.jjS.getLayoutMode().onModeChanged(this.rootView);
        this.fFC.onChangeSkinType(this.jjS.getPageContext(), i);
        this.jjU.dy(null);
        ap.setBackgroundColor(this.jjY, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.jjV, R.color.cp_bg_line_d);
    }

    private void initView() {
        if (this.jjS != null) {
            this.rootView = LayoutInflater.from(this.jjS.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
            this.jjS.setContentView(this.rootView);
            this.jjV = (FrameLayout) this.jjS.findViewById(R.id.topic_tab_widget_content_container);
            this.mNavigationBar = (NavigationBar) this.jjS.findViewById(R.id.topic_fragment_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jcB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        b.this.jjS.showToast(R.string.topic_share_no_network);
                    } else if (ShareSwitch.isOn() || bg.checkUpIsLogin(b.this.jjS)) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dF("obj_param1", "6"));
                        b.this.jjS.cDi();
                    }
                }
            });
            this.mNavigationBar.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
            this.fFC = (NoNetworkView) this.jjS.findViewById(R.id.topic_view_no_network);
            this.jjY = (ImageView) this.rootView.findViewById(R.id.topic_tab_bottom_line);
            this.jjT = new com.baidu.tieba.hottopic.view.indicator.a(this.jjS.getActivity(), this.jjS.findViewById(R.id.topic_tab_container));
            this.jjT.D(this.jjZ);
            ((ObservedChangeLinearLayout) this.jjS.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.ffE);
            this.ekP = (CustomViewPager) this.jjS.findViewById(R.id.topic_tab_widget_view_pager);
            this.jjU = new ScrollFragmentAdapter(this.jjS.getActivity());
            this.ekP.setAdapter(this.jjU);
        }
    }

    public void cDU() {
        this.jjT.setViewPager(this.ekP);
    }

    public int a(p pVar) {
        if (this.jjU == null) {
            return -1;
        }
        return this.jjU.b(pVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.jjU.getCount()) {
            this.ekP.setCurrentItem(i, false);
        }
    }

    public int getCurrentTab() {
        return this.ekP.getCurrentItem();
    }

    public void cDV() {
        com.baidu.tieba.hottopic.data.j jVar;
        if (this.jjW == null) {
            this.jjW = new com.baidu.tieba.hottopic.view.indicator.c(this.jjV);
            this.jjW.a(this.jka);
        }
        this.jjW.Bf(this.topHeight);
        if (!this.jjW.isShowing() && (jVar = (com.baidu.tieba.hottopic.data.j) y.getItem(this.jjU.cEq(), 0)) != null) {
            this.jjW.a(this.jjS.getActivity(), jVar.jiv, this.ekP.getCurrentItem());
            if (this.jjT != null) {
                this.jjT.bcr();
            }
        }
    }

    public void bBs() {
        if (this.jjW != null) {
            this.jjW.fi(this.jjS.getActivity());
        }
    }

    public void AT(int i) {
        if (this.fFC != null) {
            this.fFC.setVisibility(i);
        }
    }

    public void g(NoNetworkView.a aVar) {
        this.hXf = aVar;
        if (this.fFC != null) {
            this.fFC.a(this.hXf);
        }
    }

    public View cDW() {
        return this.jjV;
    }

    public void dC(List<com.baidu.tieba.hottopic.data.j> list) {
        this.jjU.dy(list);
    }

    public void cDX() {
        if (this.fFC != null && this.hXf != null) {
            this.fFC.b(this.hXf);
        }
    }

    public void AU(int i) {
        this.ekP.setVisibility(i);
    }

    public void AV(int i) {
        if (this.jjT != null) {
            this.jjT.setVisibility(i);
        }
    }

    public void bHn() {
        this.jjU.bHn();
    }

    public void showLoadingView() {
        this.jjU.showLoadingView();
    }

    public void cDY() {
        this.jjU.qf(false);
    }

    public boolean onKeyBack() {
        if (cDT()) {
            bBs();
            return true;
        }
        return false;
    }
}
