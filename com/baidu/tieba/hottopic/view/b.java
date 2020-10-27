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
    private CustomViewPager eFw;
    private NoNetworkView gbO;
    private HotRanklistActivity jLp;
    private com.baidu.tieba.hottopic.view.indicator.a jLq;
    private ScrollFragmentAdapter jLr;
    private FrameLayout jLs;
    private com.baidu.tieba.hottopic.view.indicator.c jLt;
    private ImageView jLv;
    private View rootView;
    private int topHeight;
    private NavigationBar mNavigationBar = null;
    private ImageView jEa = null;
    public boolean jLu = true;
    private NoNetworkView.a iyC = null;
    private View.OnClickListener jLw = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cKJ()) {
                b.this.bFX();
                view.setContentDescription("展开");
                return;
            }
            b.this.cKL();
            view.setContentDescription("折叠");
        }
    };
    private final com.baidu.tbadk.widget.layout.e fAq = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.b.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            b.this.topHeight = i2;
            if (b.this.jLr != null) {
                b.this.jLr.f(view, i, i2, i3, i4);
            }
            if (b.this.jLt != null) {
                b.this.jLt.Cd(i2);
            }
        }
    };
    private c.a jLx = new c.a() { // from class: com.baidu.tieba.hottopic.view.b.3
        @Override // com.baidu.tieba.hottopic.view.indicator.c.a
        public void cKP() {
            if (b.this.jLq != null) {
                b.this.jLq.cLh();
            }
            if (b.this.jLt != null) {
                b.this.jLt.a((c.a) null);
                b.this.jLu = true;
                b.this.jLt = null;
            }
        }
    };

    public boolean cKJ() {
        return this.jLt != null && this.jLt.isShowing();
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.jLp = hotRanklistActivity;
        initView();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.jLp.getPageContext(), i);
        ap.setImageResource(this.jEa, R.drawable.icon_nav_hot_share_selector);
        SvgManager.boN().a(this.jEa, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jLq.onChangeSkinType(i);
        this.jLp.getLayoutMode().setNightMode(i == 1);
        this.jLp.getLayoutMode().onModeChanged(this.rootView);
        this.gbO.onChangeSkinType(this.jLp.getPageContext(), i);
        this.jLr.dK(null);
        ap.setBackgroundColor(this.jLv, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.jLs, R.color.cp_bg_line_d);
    }

    private void initView() {
        if (this.jLp != null) {
            this.rootView = LayoutInflater.from(this.jLp.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
            this.jLp.setContentView(this.rootView);
            this.jLs = (FrameLayout) this.jLp.findViewById(R.id.topic_tab_widget_content_container);
            this.mNavigationBar = (NavigationBar) this.jLp.findViewById(R.id.topic_fragment_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jEa = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        b.this.jLp.showToast(R.string.topic_share_no_network);
                    } else if (ShareSwitch.isOn() || bg.checkUpIsLogin(b.this.jLp)) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("obj_param1", "6"));
                        b.this.jLp.cJY();
                    }
                }
            });
            this.mNavigationBar.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
            this.gbO = (NoNetworkView) this.jLp.findViewById(R.id.topic_view_no_network);
            this.jLv = (ImageView) this.rootView.findViewById(R.id.topic_tab_bottom_line);
            this.jLq = new com.baidu.tieba.hottopic.view.indicator.a(this.jLp.getActivity(), this.jLp.findViewById(R.id.topic_tab_container));
            this.jLq.D(this.jLw);
            ((ObservedChangeLinearLayout) this.jLp.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.fAq);
            this.eFw = (CustomViewPager) this.jLp.findViewById(R.id.topic_tab_widget_view_pager);
            this.jLr = new ScrollFragmentAdapter(this.jLp.getActivity());
            this.eFw.setAdapter(this.jLr);
        }
    }

    public void cKK() {
        this.jLq.setViewPager(this.eFw);
    }

    public int a(p pVar) {
        if (this.jLr == null) {
            return -1;
        }
        return this.jLr.b(pVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.jLr.getCount()) {
            this.eFw.setCurrentItem(i, false);
        }
    }

    public int getCurrentTab() {
        return this.eFw.getCurrentItem();
    }

    public void cKL() {
        com.baidu.tieba.hottopic.data.j jVar;
        if (this.jLt == null) {
            this.jLt = new com.baidu.tieba.hottopic.view.indicator.c(this.jLs);
            this.jLt.a(this.jLx);
        }
        this.jLt.Ce(this.topHeight);
        if (!this.jLt.isShowing() && (jVar = (com.baidu.tieba.hottopic.data.j) y.getItem(this.jLr.cLg(), 0)) != null) {
            this.jLt.a(this.jLp.getActivity(), jVar.jJS, this.eFw.getCurrentItem());
            if (this.jLq != null) {
                this.jLq.bgS();
            }
        }
    }

    public void bFX() {
        if (this.jLt != null) {
            this.jLt.fq(this.jLp.getActivity());
        }
    }

    public void BS(int i) {
        if (this.gbO != null) {
            this.gbO.setVisibility(i);
        }
    }

    public void g(NoNetworkView.a aVar) {
        this.iyC = aVar;
        if (this.gbO != null) {
            this.gbO.a(this.iyC);
        }
    }

    public View cKM() {
        return this.jLs;
    }

    public void dO(List<com.baidu.tieba.hottopic.data.j> list) {
        this.jLr.dK(list);
    }

    public void cKN() {
        if (this.gbO != null && this.iyC != null) {
            this.gbO.b(this.iyC);
        }
    }

    public void BT(int i) {
        this.eFw.setVisibility(i);
    }

    public void BU(int i) {
        if (this.jLq != null) {
            this.jLq.setVisibility(i);
        }
    }

    public void TK() {
        this.jLr.TK();
    }

    public void showLoadingView() {
        this.jLr.showLoadingView();
    }

    public void cKO() {
        this.jLr.rd(false);
    }

    public boolean onKeyBack() {
        if (cKJ()) {
            bFX();
            return true;
        }
        return false;
    }
}
