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
/* loaded from: classes7.dex */
public class b {
    private CustomViewPager eWN;
    private NoNetworkView gvm;
    private HotRanklistActivity koj;
    private com.baidu.tieba.hottopic.view.indicator.a kok;
    private ScrollFragmentAdapter kol;
    private FrameLayout kom;
    private com.baidu.tieba.hottopic.view.indicator.c kon;
    private ImageView kop;
    private View rootView;
    private int topHeight;
    private NavigationBar mNavigationBar = null;
    private ImageView jMm = null;
    public boolean koo = true;
    private NoNetworkView.a iXM = null;
    private View.OnClickListener koq = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cRv()) {
                b.this.bJR();
                view.setContentDescription("展开");
                return;
            }
            b.this.csv();
            view.setContentDescription("折叠");
        }
    };
    private final com.baidu.tbadk.widget.layout.e fSr = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.b.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void f(View view, int i, int i2, int i3, int i4) {
            b.this.topHeight = i2;
            if (b.this.kol != null) {
                b.this.kol.h(view, i, i2, i3, i4);
            }
            if (b.this.kon != null) {
                b.this.kon.Cl(i2);
            }
        }
    };
    private c.a kor = new c.a() { // from class: com.baidu.tieba.hottopic.view.b.3
        @Override // com.baidu.tieba.hottopic.view.indicator.c.a
        public void cRA() {
            if (b.this.kok != null) {
                b.this.kok.cRS();
            }
            if (b.this.kon != null) {
                b.this.kon.a((c.a) null);
                b.this.koo = true;
                b.this.kon = null;
            }
        }
    };

    public boolean cRv() {
        return this.kon != null && this.kon.isShowing();
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.koj = hotRanklistActivity;
        initView();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.koj.getPageContext(), i);
        ao.setImageResource(this.jMm, R.drawable.icon_nav_hot_share_selector);
        SvgManager.bsx().a(this.jMm, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.kok.onChangeSkinType(i);
        this.koj.getLayoutMode().setNightMode(i == 1);
        this.koj.getLayoutMode().onModeChanged(this.rootView);
        this.gvm.onChangeSkinType(this.koj.getPageContext(), i);
        this.kol.ek(null);
        ao.setBackgroundColor(this.kop, R.color.CAM_X0204);
        ao.setBackgroundColor(this.kom, R.color.CAM_X0201);
    }

    private void initView() {
        if (this.koj != null) {
            this.rootView = LayoutInflater.from(this.koj.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
            this.koj.setContentView(this.rootView);
            this.kom = (FrameLayout) this.koj.findViewById(R.id.topic_tab_widget_content_container);
            this.mNavigationBar = (NavigationBar) this.koj.findViewById(R.id.topic_fragment_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jMm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        b.this.koj.showToast(R.string.topic_share_no_network);
                    } else if (ShareSwitch.isOn() || bg.checkUpIsLogin(b.this.koj)) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dW("obj_param1", "6"));
                        b.this.koj.cQK();
                    }
                }
            });
            this.mNavigationBar.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
            this.gvm = (NoNetworkView) this.koj.findViewById(R.id.topic_view_no_network);
            this.kop = (ImageView) this.rootView.findViewById(R.id.topic_tab_bottom_line);
            this.kok = new com.baidu.tieba.hottopic.view.indicator.a(this.koj.getActivity(), this.koj.findViewById(R.id.topic_tab_container));
            this.kok.G(this.koq);
            ((ObservedChangeLinearLayout) this.koj.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.fSr);
            this.eWN = (CustomViewPager) this.koj.findViewById(R.id.topic_tab_widget_view_pager);
            this.kol = new ScrollFragmentAdapter(this.koj.getActivity());
            this.eWN.setAdapter(this.kol);
        }
    }

    public void cRw() {
        this.kok.setViewPager(this.eWN);
    }

    public int a(p pVar) {
        if (this.kol == null) {
            return -1;
        }
        return this.kol.b(pVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.kol.getCount()) {
            this.eWN.setCurrentItem(i, false);
        }
    }

    public int getCurrentTab() {
        return this.eWN.getCurrentItem();
    }

    public void csv() {
        com.baidu.tieba.hottopic.data.j jVar;
        if (this.kon == null) {
            this.kon = new com.baidu.tieba.hottopic.view.indicator.c(this.kom);
            this.kon.a(this.kor);
        }
        this.kon.Cm(this.topHeight);
        if (!this.kon.isShowing() && (jVar = (com.baidu.tieba.hottopic.data.j) x.getItem(this.kol.cRR(), 0)) != null) {
            this.kon.a(this.koj.getActivity(), jVar.kmN, this.eWN.getCurrentItem());
            if (this.kok != null) {
                this.kok.bkm();
            }
        }
    }

    public void bJR() {
        if (this.kon != null) {
            this.kon.gm(this.koj.getActivity());
        }
    }

    public void Ca(int i) {
        if (this.gvm != null) {
            this.gvm.setVisibility(i);
        }
    }

    public void g(NoNetworkView.a aVar) {
        this.iXM = aVar;
        if (this.gvm != null) {
            this.gvm.a(this.iXM);
        }
    }

    public View cRx() {
        return this.kom;
    }

    public void eo(List<com.baidu.tieba.hottopic.data.j> list) {
        this.kol.ek(list);
    }

    public void cRy() {
        if (this.gvm != null && this.iXM != null) {
            this.gvm.b(this.iXM);
        }
    }

    public void Cb(int i) {
        this.eWN.setVisibility(i);
    }

    public void Cc(int i) {
        if (this.kok != null) {
            this.kok.setVisibility(i);
        }
    }

    public void Vq() {
        this.kol.Vq();
    }

    public void showLoadingView() {
        this.kol.showLoadingView();
    }

    public void cRz() {
        this.kol.sk(false);
    }

    public boolean onKeyBack() {
        if (cRv()) {
            bJR();
            return true;
        }
        return false;
    }
}
