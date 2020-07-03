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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
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
    private CustomViewPager dSy;
    private NoNetworkView flI;
    private HotRanklistActivity iGb;
    private com.baidu.tieba.hottopic.view.indicator.a iGc;
    private ScrollFragmentAdapter iGd;
    private FrameLayout iGe;
    private com.baidu.tieba.hottopic.view.indicator.c iGf;
    private ImageView iGh;
    private View rootView;
    private int topHeight;
    private NavigationBar mNavigationBar = null;
    private ImageView iyL = null;
    public boolean iGg = true;
    private NoNetworkView.a hwW = null;
    private View.OnClickListener iGi = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.clR()) {
                b.this.bnp();
                view.setContentDescription("展开");
                return;
            }
            b.this.clT();
            view.setContentDescription("折叠");
        }
    };
    private final com.baidu.tbadk.widget.layout.e eLG = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.b.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            b.this.topHeight = i2;
            if (b.this.iGd != null) {
                b.this.iGd.f(view, i, i2, i3, i4);
            }
            if (b.this.iGf != null) {
                b.this.iGf.xR(i2);
            }
        }
    };
    private c.a iGj = new c.a() { // from class: com.baidu.tieba.hottopic.view.b.3
        @Override // com.baidu.tieba.hottopic.view.indicator.c.a
        public void clY() {
            if (b.this.iGc != null) {
                b.this.iGc.cmq();
            }
            if (b.this.iGf != null) {
                b.this.iGf.a((c.a) null);
                b.this.iGg = true;
                b.this.iGf = null;
            }
        }
    };

    public boolean clR() {
        return this.iGf != null && this.iGf.isShowing();
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.iGb = hotRanklistActivity;
        initView();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.iGb.getPageContext(), i);
        an.setImageResource(this.iyL, R.drawable.icon_nav_hot_share_selector);
        SvgManager.aWQ().a(this.iyL, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iGc.onChangeSkinType(i);
        this.iGb.getLayoutMode().setNightMode(i == 1);
        this.iGb.getLayoutMode().onModeChanged(this.rootView);
        this.flI.onChangeSkinType(this.iGb.getPageContext(), i);
        this.iGd.de(null);
        an.setBackgroundColor(this.iGh, R.color.cp_bg_line_c);
        an.setBackgroundColor(this.iGe, R.color.cp_bg_line_d);
    }

    private void initView() {
        if (this.iGb != null) {
            this.rootView = LayoutInflater.from(this.iGb.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
            this.iGb.setContentView(this.rootView);
            this.iGe = (FrameLayout) this.iGb.findViewById(R.id.topic_tab_widget_content_container);
            this.mNavigationBar = (NavigationBar) this.iGb.findViewById(R.id.topic_fragment_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iyL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        b.this.iGb.showToast(R.string.topic_share_no_network);
                    } else if (ShareSwitch.isOn() || be.checkUpIsLogin(b.this.iGb)) {
                        TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dk("obj_param1", "6"));
                        b.this.iGb.clg();
                    }
                }
            });
            this.mNavigationBar.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
            this.flI = (NoNetworkView) this.iGb.findViewById(R.id.topic_view_no_network);
            this.iGh = (ImageView) this.rootView.findViewById(R.id.topic_tab_bottom_line);
            this.iGc = new com.baidu.tieba.hottopic.view.indicator.a(this.iGb.getActivity(), this.iGb.findViewById(R.id.topic_tab_container));
            this.iGc.C(this.iGi);
            ((ObservedChangeLinearLayout) this.iGb.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.eLG);
            this.dSy = (CustomViewPager) this.iGb.findViewById(R.id.topic_tab_widget_view_pager);
            this.iGd = new ScrollFragmentAdapter(this.iGb.getActivity());
            this.dSy.setAdapter(this.iGd);
        }
    }

    public void clS() {
        this.iGc.setViewPager(this.dSy);
    }

    public int a(p pVar) {
        if (this.iGd == null) {
            return -1;
        }
        return this.iGd.b(pVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.iGd.getCount()) {
            this.dSy.setCurrentItem(i, false);
        }
    }

    public int getCurrentTab() {
        return this.dSy.getCurrentItem();
    }

    public void clT() {
        com.baidu.tieba.hottopic.data.j jVar;
        if (this.iGf == null) {
            this.iGf = new com.baidu.tieba.hottopic.view.indicator.c(this.iGe);
            this.iGf.a(this.iGj);
        }
        this.iGf.xS(this.topHeight);
        if (!this.iGf.isShowing() && (jVar = (com.baidu.tieba.hottopic.data.j) w.getItem(this.iGd.cmp(), 0)) != null) {
            this.iGf.a(this.iGb.getActivity(), jVar.iEF, this.dSy.getCurrentItem());
            if (this.iGc != null) {
                this.iGc.aPl();
            }
        }
    }

    public void bnp() {
        if (this.iGf != null) {
            this.iGf.eM(this.iGb.getActivity());
        }
    }

    public void xG(int i) {
        if (this.flI != null) {
            this.flI.setVisibility(i);
        }
    }

    public void g(NoNetworkView.a aVar) {
        this.hwW = aVar;
        if (this.flI != null) {
            this.flI.a(this.hwW);
        }
    }

    public View clU() {
        return this.iGe;
    }

    public void di(List<com.baidu.tieba.hottopic.data.j> list) {
        this.iGd.de(list);
    }

    public void clV() {
        if (this.flI != null && this.hwW != null) {
            this.flI.b(this.hwW);
        }
    }

    public void xH(int i) {
        this.dSy.setVisibility(i);
    }

    public void xI(int i) {
        if (this.iGc != null) {
            this.iGc.setVisibility(i);
        }
    }

    public void btN() {
        this.iGd.btN();
    }

    public void showLoadingView() {
        this.iGd.showLoadingView();
    }

    public void clW() {
        this.iGd.oK(false);
    }

    public boolean clX() {
        if (clR()) {
            bnp();
            return true;
        }
        return false;
    }
}
