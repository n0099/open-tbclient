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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
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
    private CustomViewPager fbv;
    private NoNetworkView gzT;
    private HotRanklistActivity ksO;
    private com.baidu.tieba.hottopic.view.indicator.a ksP;
    private ScrollFragmentAdapter ksQ;
    private FrameLayout ksR;
    private com.baidu.tieba.hottopic.view.indicator.c ksS;
    private ImageView ksU;
    private View rootView;
    private int topHeight;
    private NavigationBar mNavigationBar = null;
    private ImageView jQR = null;
    public boolean ksT = true;
    private NoNetworkView.a jct = null;
    private View.OnClickListener ksV = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cVm()) {
                b.this.bNI();
                view.setContentDescription("展开");
                return;
            }
            b.this.cwm();
            view.setContentDescription("折叠");
        }
    };
    private final com.baidu.tbadk.widget.layout.e fWY = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.b.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void f(View view, int i, int i2, int i3, int i4) {
            b.this.topHeight = i2;
            if (b.this.ksQ != null) {
                b.this.ksQ.h(view, i, i2, i3, i4);
            }
            if (b.this.ksS != null) {
                b.this.ksS.DR(i2);
            }
        }
    };
    private c.a ksW = new c.a() { // from class: com.baidu.tieba.hottopic.view.b.3
        @Override // com.baidu.tieba.hottopic.view.indicator.c.a
        public void cVr() {
            if (b.this.ksP != null) {
                b.this.ksP.cVJ();
            }
            if (b.this.ksS != null) {
                b.this.ksS.a((c.a) null);
                b.this.ksT = true;
                b.this.ksS = null;
            }
        }
    };

    public boolean cVm() {
        return this.ksS != null && this.ksS.isShowing();
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.ksO = hotRanklistActivity;
        initView();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.ksO.getPageContext(), i);
        ao.setImageResource(this.jQR, R.drawable.icon_nav_hot_share_selector);
        SvgManager.bwq().a(this.jQR, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.ksP.onChangeSkinType(i);
        this.ksO.getLayoutMode().setNightMode(i == 1);
        this.ksO.getLayoutMode().onModeChanged(this.rootView);
        this.gzT.onChangeSkinType(this.ksO.getPageContext(), i);
        this.ksQ.ek(null);
        ao.setBackgroundColor(this.ksU, R.color.CAM_X0204);
        ao.setBackgroundColor(this.ksR, R.color.CAM_X0201);
    }

    private void initView() {
        if (this.ksO != null) {
            this.rootView = LayoutInflater.from(this.ksO.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
            this.ksO.setContentView(this.rootView);
            this.ksR = (FrameLayout) this.ksO.findViewById(R.id.topic_tab_widget_content_container);
            this.mNavigationBar = (NavigationBar) this.ksO.findViewById(R.id.topic_fragment_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jQR = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        b.this.ksO.showToast(R.string.topic_share_no_network);
                    } else if (ShareSwitch.isOn() || bg.checkUpIsLogin(b.this.ksO)) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dX("obj_param1", "6"));
                        b.this.ksO.cUB();
                    }
                }
            });
            this.mNavigationBar.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
            this.gzT = (NoNetworkView) this.ksO.findViewById(R.id.topic_view_no_network);
            this.ksU = (ImageView) this.rootView.findViewById(R.id.topic_tab_bottom_line);
            this.ksP = new com.baidu.tieba.hottopic.view.indicator.a(this.ksO.getActivity(), this.ksO.findViewById(R.id.topic_tab_container));
            this.ksP.G(this.ksV);
            ((ObservedChangeLinearLayout) this.ksO.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.fWY);
            this.fbv = (CustomViewPager) this.ksO.findViewById(R.id.topic_tab_widget_view_pager);
            this.ksQ = new ScrollFragmentAdapter(this.ksO.getActivity());
            this.fbv.setAdapter(this.ksQ);
        }
    }

    public void cVn() {
        this.ksP.setViewPager(this.fbv);
    }

    public int a(p pVar) {
        if (this.ksQ == null) {
            return -1;
        }
        return this.ksQ.b(pVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.ksQ.getCount()) {
            this.fbv.setCurrentItem(i, false);
        }
    }

    public int getCurrentTab() {
        return this.fbv.getCurrentItem();
    }

    public void cwm() {
        com.baidu.tieba.hottopic.data.j jVar;
        if (this.ksS == null) {
            this.ksS = new com.baidu.tieba.hottopic.view.indicator.c(this.ksR);
            this.ksS.a(this.ksW);
        }
        this.ksS.DS(this.topHeight);
        if (!this.ksS.isShowing() && (jVar = (com.baidu.tieba.hottopic.data.j) x.getItem(this.ksQ.cVI(), 0)) != null) {
            this.ksS.a(this.ksO.getActivity(), jVar.krs, this.fbv.getCurrentItem());
            if (this.ksP != null) {
                this.ksP.bof();
            }
        }
    }

    public void bNI() {
        if (this.ksS != null) {
            this.ksS.go(this.ksO.getActivity());
        }
    }

    public void DG(int i) {
        if (this.gzT != null) {
            this.gzT.setVisibility(i);
        }
    }

    public void g(NoNetworkView.a aVar) {
        this.jct = aVar;
        if (this.gzT != null) {
            this.gzT.a(this.jct);
        }
    }

    public View cVo() {
        return this.ksR;
    }

    public void eo(List<com.baidu.tieba.hottopic.data.j> list) {
        this.ksQ.ek(list);
    }

    public void cVp() {
        if (this.gzT != null && this.jct != null) {
            this.gzT.b(this.jct);
        }
    }

    public void DH(int i) {
        this.fbv.setVisibility(i);
    }

    public void DI(int i) {
        if (this.ksP != null) {
            this.ksP.setVisibility(i);
        }
    }

    public void Zi() {
        this.ksQ.Zi();
    }

    public void showLoadingView() {
        this.ksQ.showLoadingView();
    }

    public void cVq() {
        this.ksQ.so(false);
    }

    public boolean onKeyBack() {
        if (cVm()) {
            bNI();
            return true;
        }
        return false;
    }
}
