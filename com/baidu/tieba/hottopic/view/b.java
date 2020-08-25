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
    private CustomViewPager eiw;
    private NoNetworkView fCm;
    private HotRanklistActivity jbg;
    private com.baidu.tieba.hottopic.view.indicator.a jbh;
    private ScrollFragmentAdapter jbi;
    private FrameLayout jbj;
    private com.baidu.tieba.hottopic.view.indicator.c jbk;
    private ImageView jbm;
    private View rootView;
    private int topHeight;
    private NavigationBar mNavigationBar = null;
    private ImageView iTP = null;
    public boolean jbl = true;
    private NoNetworkView.a hPZ = null;
    private View.OnClickListener jbn = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cAl()) {
                b.this.bAi();
                view.setContentDescription("展开");
                return;
            }
            b.this.cAn();
            view.setContentDescription("折叠");
        }
    };
    private final com.baidu.tbadk.widget.layout.e fcI = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.b.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            b.this.topHeight = i2;
            if (b.this.jbi != null) {
                b.this.jbi.f(view, i, i2, i3, i4);
            }
            if (b.this.jbk != null) {
                b.this.jbk.AD(i2);
            }
        }
    };
    private c.a jbo = new c.a() { // from class: com.baidu.tieba.hottopic.view.b.3
        @Override // com.baidu.tieba.hottopic.view.indicator.c.a
        public void cAr() {
            if (b.this.jbh != null) {
                b.this.jbh.cAJ();
            }
            if (b.this.jbk != null) {
                b.this.jbk.a((c.a) null);
                b.this.jbl = true;
                b.this.jbk = null;
            }
        }
    };

    public boolean cAl() {
        return this.jbk != null && this.jbk.isShowing();
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.jbg = hotRanklistActivity;
        initView();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.jbg.getPageContext(), i);
        ap.setImageResource(this.iTP, R.drawable.icon_nav_hot_share_selector);
        SvgManager.bjq().a(this.iTP, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jbh.onChangeSkinType(i);
        this.jbg.getLayoutMode().setNightMode(i == 1);
        this.jbg.getLayoutMode().onModeChanged(this.rootView);
        this.fCm.onChangeSkinType(this.jbg.getPageContext(), i);
        this.jbi.dq(null);
        ap.setBackgroundColor(this.jbm, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.jbj, R.color.cp_bg_line_d);
    }

    private void initView() {
        if (this.jbg != null) {
            this.rootView = LayoutInflater.from(this.jbg.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
            this.jbg.setContentView(this.rootView);
            this.jbj = (FrameLayout) this.jbg.findViewById(R.id.topic_tab_widget_content_container);
            this.mNavigationBar = (NavigationBar) this.jbg.findViewById(R.id.topic_fragment_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.iTP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        b.this.jbg.showToast(R.string.topic_share_no_network);
                    } else if (ShareSwitch.isOn() || bg.checkUpIsLogin(b.this.jbg)) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dD("obj_param1", "6"));
                        b.this.jbg.czA();
                    }
                }
            });
            this.mNavigationBar.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
            this.fCm = (NoNetworkView) this.jbg.findViewById(R.id.topic_view_no_network);
            this.jbm = (ImageView) this.rootView.findViewById(R.id.topic_tab_bottom_line);
            this.jbh = new com.baidu.tieba.hottopic.view.indicator.a(this.jbg.getActivity(), this.jbg.findViewById(R.id.topic_tab_container));
            this.jbh.D(this.jbn);
            ((ObservedChangeLinearLayout) this.jbg.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.fcI);
            this.eiw = (CustomViewPager) this.jbg.findViewById(R.id.topic_tab_widget_view_pager);
            this.jbi = new ScrollFragmentAdapter(this.jbg.getActivity());
            this.eiw.setAdapter(this.jbi);
        }
    }

    public void cAm() {
        this.jbh.setViewPager(this.eiw);
    }

    public int a(p pVar) {
        if (this.jbi == null) {
            return -1;
        }
        return this.jbi.b(pVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.jbi.getCount()) {
            this.eiw.setCurrentItem(i, false);
        }
    }

    public int getCurrentTab() {
        return this.eiw.getCurrentItem();
    }

    public void cAn() {
        com.baidu.tieba.hottopic.data.j jVar;
        if (this.jbk == null) {
            this.jbk = new com.baidu.tieba.hottopic.view.indicator.c(this.jbj);
            this.jbk.a(this.jbo);
        }
        this.jbk.AE(this.topHeight);
        if (!this.jbk.isShowing() && (jVar = (com.baidu.tieba.hottopic.data.j) y.getItem(this.jbi.cAI(), 0)) != null) {
            this.jbk.a(this.jbg.getActivity(), jVar.iZJ, this.eiw.getCurrentItem());
            if (this.jbh != null) {
                this.jbh.bbx();
            }
        }
    }

    public void bAi() {
        if (this.jbk != null) {
            this.jbk.fc(this.jbg.getActivity());
        }
    }

    public void As(int i) {
        if (this.fCm != null) {
            this.fCm.setVisibility(i);
        }
    }

    public void g(NoNetworkView.a aVar) {
        this.hPZ = aVar;
        if (this.fCm != null) {
            this.fCm.a(this.hPZ);
        }
    }

    public View cAo() {
        return this.jbj;
    }

    public void du(List<com.baidu.tieba.hottopic.data.j> list) {
        this.jbi.dq(list);
    }

    public void cAp() {
        if (this.fCm != null && this.hPZ != null) {
            this.fCm.b(this.hPZ);
        }
    }

    public void At(int i) {
        this.eiw.setVisibility(i);
    }

    public void Au(int i) {
        if (this.jbh != null) {
            this.jbh.setVisibility(i);
        }
    }

    public void bFW() {
        this.jbi.bFW();
    }

    public void showLoadingView() {
        this.jbi.showLoadingView();
    }

    public void cAq() {
        this.jbi.pV(false);
    }

    public boolean onKeyBack() {
        if (cAl()) {
            bAi();
            return true;
        }
        return false;
    }
}
