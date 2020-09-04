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
/* loaded from: classes15.dex */
public class b {
    private CustomViewPager eiA;
    private NoNetworkView fCq;
    private HotRanklistActivity jbm;
    private com.baidu.tieba.hottopic.view.indicator.a jbn;
    private ScrollFragmentAdapter jbo;
    private FrameLayout jbp;
    private com.baidu.tieba.hottopic.view.indicator.c jbq;
    private ImageView jbs;
    private View rootView;
    private int topHeight;
    private NavigationBar mNavigationBar = null;
    private ImageView iTV = null;
    public boolean jbr = true;
    private NoNetworkView.a hQf = null;
    private View.OnClickListener jbt = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cAm()) {
                b.this.bAj();
                view.setContentDescription("展开");
                return;
            }
            b.this.cAo();
            view.setContentDescription("折叠");
        }
    };
    private final com.baidu.tbadk.widget.layout.e fcM = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.b.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            b.this.topHeight = i2;
            if (b.this.jbo != null) {
                b.this.jbo.f(view, i, i2, i3, i4);
            }
            if (b.this.jbq != null) {
                b.this.jbq.AD(i2);
            }
        }
    };
    private c.a jbu = new c.a() { // from class: com.baidu.tieba.hottopic.view.b.3
        @Override // com.baidu.tieba.hottopic.view.indicator.c.a
        public void cAs() {
            if (b.this.jbn != null) {
                b.this.jbn.cAK();
            }
            if (b.this.jbq != null) {
                b.this.jbq.a((c.a) null);
                b.this.jbr = true;
                b.this.jbq = null;
            }
        }
    };

    public boolean cAm() {
        return this.jbq != null && this.jbq.isShowing();
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.jbm = hotRanklistActivity;
        initView();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.jbm.getPageContext(), i);
        ap.setImageResource(this.iTV, R.drawable.icon_nav_hot_share_selector);
        SvgManager.bjq().a(this.iTV, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jbn.onChangeSkinType(i);
        this.jbm.getLayoutMode().setNightMode(i == 1);
        this.jbm.getLayoutMode().onModeChanged(this.rootView);
        this.fCq.onChangeSkinType(this.jbm.getPageContext(), i);
        this.jbo.dq(null);
        ap.setBackgroundColor(this.jbs, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.jbp, R.color.cp_bg_line_d);
    }

    private void initView() {
        if (this.jbm != null) {
            this.rootView = LayoutInflater.from(this.jbm.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
            this.jbm.setContentView(this.rootView);
            this.jbp = (FrameLayout) this.jbm.findViewById(R.id.topic_tab_widget_content_container);
            this.mNavigationBar = (NavigationBar) this.jbm.findViewById(R.id.topic_fragment_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iTV = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        b.this.jbm.showToast(R.string.topic_share_no_network);
                    } else if (ShareSwitch.isOn() || bg.checkUpIsLogin(b.this.jbm)) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dD("obj_param1", "6"));
                        b.this.jbm.czB();
                    }
                }
            });
            this.mNavigationBar.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
            this.fCq = (NoNetworkView) this.jbm.findViewById(R.id.topic_view_no_network);
            this.jbs = (ImageView) this.rootView.findViewById(R.id.topic_tab_bottom_line);
            this.jbn = new com.baidu.tieba.hottopic.view.indicator.a(this.jbm.getActivity(), this.jbm.findViewById(R.id.topic_tab_container));
            this.jbn.D(this.jbt);
            ((ObservedChangeLinearLayout) this.jbm.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.fcM);
            this.eiA = (CustomViewPager) this.jbm.findViewById(R.id.topic_tab_widget_view_pager);
            this.jbo = new ScrollFragmentAdapter(this.jbm.getActivity());
            this.eiA.setAdapter(this.jbo);
        }
    }

    public void cAn() {
        this.jbn.setViewPager(this.eiA);
    }

    public int a(p pVar) {
        if (this.jbo == null) {
            return -1;
        }
        return this.jbo.b(pVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.jbo.getCount()) {
            this.eiA.setCurrentItem(i, false);
        }
    }

    public int getCurrentTab() {
        return this.eiA.getCurrentItem();
    }

    public void cAo() {
        com.baidu.tieba.hottopic.data.j jVar;
        if (this.jbq == null) {
            this.jbq = new com.baidu.tieba.hottopic.view.indicator.c(this.jbp);
            this.jbq.a(this.jbu);
        }
        this.jbq.AE(this.topHeight);
        if (!this.jbq.isShowing() && (jVar = (com.baidu.tieba.hottopic.data.j) y.getItem(this.jbo.cAJ(), 0)) != null) {
            this.jbq.a(this.jbm.getActivity(), jVar.iZP, this.eiA.getCurrentItem());
            if (this.jbn != null) {
                this.jbn.bbx();
            }
        }
    }

    public void bAj() {
        if (this.jbq != null) {
            this.jbq.fc(this.jbm.getActivity());
        }
    }

    public void As(int i) {
        if (this.fCq != null) {
            this.fCq.setVisibility(i);
        }
    }

    public void g(NoNetworkView.a aVar) {
        this.hQf = aVar;
        if (this.fCq != null) {
            this.fCq.a(this.hQf);
        }
    }

    public View cAp() {
        return this.jbp;
    }

    public void du(List<com.baidu.tieba.hottopic.data.j> list) {
        this.jbo.dq(list);
    }

    public void cAq() {
        if (this.fCq != null && this.hQf != null) {
            this.fCq.b(this.hQf);
        }
    }

    public void At(int i) {
        this.eiA.setVisibility(i);
    }

    public void Au(int i) {
        if (this.jbn != null) {
            this.jbn.setVisibility(i);
        }
    }

    public void bFX() {
        this.jbo.bFX();
    }

    public void showLoadingView() {
        this.jbo.showLoadingView();
    }

    public void cAr() {
        this.jbo.pX(false);
    }

    public boolean onKeyBack() {
        if (cAm()) {
            bAj();
            return true;
        }
        return false;
    }
}
