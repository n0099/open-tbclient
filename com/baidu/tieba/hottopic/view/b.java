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
    private CustomViewPager ewX;
    private NoNetworkView fRL;
    private HotRanklistActivity jyQ;
    private com.baidu.tieba.hottopic.view.indicator.a jyR;
    private ScrollFragmentAdapter jyS;
    private FrameLayout jyT;
    private com.baidu.tieba.hottopic.view.indicator.c jyU;
    private ImageView jyW;
    private View rootView;
    private int topHeight;
    private NavigationBar mNavigationBar = null;
    private ImageView jrA = null;
    public boolean jyV = true;
    private NoNetworkView.a ime = null;
    private View.OnClickListener jyX = new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.cHC()) {
                b.this.bEe();
                view.setContentDescription("展开");
                return;
            }
            b.this.cHE();
            view.setContentDescription("折叠");
        }
    };
    private final com.baidu.tbadk.widget.layout.e frT = new com.baidu.tbadk.widget.layout.e() { // from class: com.baidu.tieba.hottopic.view.b.2
        @Override // com.baidu.tbadk.widget.layout.e
        public void d(View view, int i, int i2, int i3, int i4) {
            b.this.topHeight = i2;
            if (b.this.jyS != null) {
                b.this.jyS.f(view, i, i2, i3, i4);
            }
            if (b.this.jyU != null) {
                b.this.jyU.BK(i2);
            }
        }
    };
    private c.a jyY = new c.a() { // from class: com.baidu.tieba.hottopic.view.b.3
        @Override // com.baidu.tieba.hottopic.view.indicator.c.a
        public void cHI() {
            if (b.this.jyR != null) {
                b.this.jyR.cIa();
            }
            if (b.this.jyU != null) {
                b.this.jyU.a((c.a) null);
                b.this.jyV = true;
                b.this.jyU = null;
            }
        }
    };

    public boolean cHC() {
        return this.jyU != null && this.jyU.isShowing();
    }

    public b(HotRanklistActivity hotRanklistActivity) {
        this.jyQ = hotRanklistActivity;
        initView();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.jyQ.getPageContext(), i);
        ap.setImageResource(this.jrA, R.drawable.icon_nav_hot_share_selector);
        SvgManager.bmU().a(this.jrA, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jyR.onChangeSkinType(i);
        this.jyQ.getLayoutMode().setNightMode(i == 1);
        this.jyQ.getLayoutMode().onModeChanged(this.rootView);
        this.fRL.onChangeSkinType(this.jyQ.getPageContext(), i);
        this.jyS.dB(null);
        ap.setBackgroundColor(this.jyW, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.jyT, R.color.cp_bg_line_d);
    }

    private void initView() {
        if (this.jyQ != null) {
            this.rootView = LayoutInflater.from(this.jyQ.getActivity()).inflate(R.layout.topic_scroll_fragment_tabhost, (ViewGroup) null);
            this.jyQ.setContentView(this.rootView);
            this.jyT = (FrameLayout) this.jyQ.findViewById(R.id.topic_tab_widget_content_container);
            this.mNavigationBar = (NavigationBar) this.jyQ.findViewById(R.id.topic_fragment_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jrA = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.hot_topic_share, new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!j.isNetWorkAvailable()) {
                        b.this.jyQ.showToast(R.string.topic_share_no_network);
                    } else if (ShareSwitch.isOn() || bg.checkUpIsLogin(b.this.jyQ)) {
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dK("obj_param1", "6"));
                        b.this.jyQ.cGR();
                    }
                }
            });
            this.mNavigationBar.setCenterTextTitle(TbadkCoreApplication.getInst().getString(R.string.hot_topic_card_title));
            this.fRL = (NoNetworkView) this.jyQ.findViewById(R.id.topic_view_no_network);
            this.jyW = (ImageView) this.rootView.findViewById(R.id.topic_tab_bottom_line);
            this.jyR = new com.baidu.tieba.hottopic.view.indicator.a(this.jyQ.getActivity(), this.jyQ.findViewById(R.id.topic_tab_container));
            this.jyR.D(this.jyX);
            ((ObservedChangeLinearLayout) this.jyQ.findViewById(R.id.topic_fragment_tab_layout)).setOnSizeChangeListener(this.frT);
            this.ewX = (CustomViewPager) this.jyQ.findViewById(R.id.topic_tab_widget_view_pager);
            this.jyS = new ScrollFragmentAdapter(this.jyQ.getActivity());
            this.ewX.setAdapter(this.jyS);
        }
    }

    public void cHD() {
        this.jyR.setViewPager(this.ewX);
    }

    public int a(p pVar) {
        if (this.jyS == null) {
            return -1;
        }
        return this.jyS.b(pVar);
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.jyS.getCount()) {
            this.ewX.setCurrentItem(i, false);
        }
    }

    public int getCurrentTab() {
        return this.ewX.getCurrentItem();
    }

    public void cHE() {
        com.baidu.tieba.hottopic.data.j jVar;
        if (this.jyU == null) {
            this.jyU = new com.baidu.tieba.hottopic.view.indicator.c(this.jyT);
            this.jyU.a(this.jyY);
        }
        this.jyU.BL(this.topHeight);
        if (!this.jyU.isShowing() && (jVar = (com.baidu.tieba.hottopic.data.j) y.getItem(this.jyS.cHZ(), 0)) != null) {
            this.jyU.a(this.jyQ.getActivity(), jVar.jxt, this.ewX.getCurrentItem());
            if (this.jyR != null) {
                this.jyR.beZ();
            }
        }
    }

    public void bEe() {
        if (this.jyU != null) {
            this.jyU.fp(this.jyQ.getActivity());
        }
    }

    public void Bz(int i) {
        if (this.fRL != null) {
            this.fRL.setVisibility(i);
        }
    }

    public void g(NoNetworkView.a aVar) {
        this.ime = aVar;
        if (this.fRL != null) {
            this.fRL.a(this.ime);
        }
    }

    public View cHF() {
        return this.jyT;
    }

    public void dF(List<com.baidu.tieba.hottopic.data.j> list) {
        this.jyS.dB(list);
    }

    public void cHG() {
        if (this.fRL != null && this.ime != null) {
            this.fRL.b(this.ime);
        }
    }

    public void BA(int i) {
        this.ewX.setVisibility(i);
    }

    public void BB(int i) {
        if (this.jyR != null) {
            this.jyR.setVisibility(i);
        }
    }

    public void SK() {
        this.jyS.SK();
    }

    public void showLoadingView() {
        this.jyS.showLoadingView();
    }

    public void cHH() {
        this.jyS.qL(false);
    }

    public boolean onKeyBack() {
        if (cHC()) {
            bEe();
            return true;
        }
        return false;
    }
}
