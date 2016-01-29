package com.baidu.tieba.hottopic.view;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c {
    private NoNetworkView aWk;
    private PbListView aXw;
    private TbPageContext<HotTopicActivity> bME;
    private ImageView bMH;
    private LinearLayout bMI;
    private TextView bMJ;
    private View bMK;
    private AnimationDrawable bML;
    private Animation bMM;
    private Animation bMN;
    private Animation bMO;
    private Animation bMP;
    private View bMF = null;
    private NavigationBar mNavigationBar = null;
    private ImageView bMG = null;
    private boolean bMQ = false;
    private int index = -1;
    private BdTypeListView aXu = null;
    private t mPullView = null;
    private com.baidu.tieba.hottopic.a.g bMR = null;
    private boolean mHasMore = true;
    private int bjN = 0;
    private NoNetworkView.a bdG = null;

    public c(TbPageContext<HotTopicActivity> tbPageContext) {
        this.bME = tbPageContext;
        initView();
    }

    private void initView() {
        if (this.bME != null) {
            this.bME.getOrignalPage().setContentView(t.h.hot_topic_activity);
            this.bMF = this.bME.getOrignalPage().findViewById(t.g.hot_topic_root_view);
            this.mNavigationBar = (NavigationBar) this.bME.getOrignalPage().findViewById(t.g.view_navigation_bar);
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.bMG = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.hot_topic_share, new d(this));
            this.mNavigationBar.setTitleText(TbadkCoreApplication.m411getInst().getString(t.j.hot_topic));
            this.aWk = (NoNetworkView) this.bMF.findViewById(t.g.view_no_network);
            this.bMH = (ImageView) this.bMF.findViewById(t.g.gif_image);
            this.bMI = (LinearLayout) this.bMF.findViewById(t.g.gif_group);
            this.bMJ = (TextView) this.bMF.findViewById(t.g.git_desc);
            this.bMK = this.bMF.findViewById(t.g.gif_clikc_view);
            this.aXu = (BdTypeListView) this.bMF.findViewById(t.g.hot_topic_list);
            this.aXu.setOnSrollToBottomListener(this.bME.getOrignalPage());
            this.mPullView = new com.baidu.tbadk.core.view.t(this.bME);
            this.aXu.setPullRefresh(this.mPullView);
            this.bMR = new com.baidu.tieba.hottopic.a.g(this.bME.getOrignalPage(), this.aXu);
            this.aXw = new PbListView(this.bME.getPageActivity());
            this.aXw.ni();
            this.aXw.df(t.d.cp_bg_line_c);
            Yf();
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.bMI.setVisibility(i);
        if (i != 8) {
            this.bMJ.setText(aw.z(j));
            this.bMQ = z;
            if (this.bMQ) {
                if (i2 == 1) {
                    this.bMJ.setVisibility(0);
                    ar.c(this.bMH, t.f.bless_gif);
                } else {
                    this.bMJ.setVisibility(8);
                    ar.c(this.bMH, t.f.pic_float_zhufu);
                }
                ((LinearLayout.LayoutParams) this.bMJ.getLayoutParams()).setMargins(this.bME.getResources().getDimensionPixelSize(t.e.bless_magin_left), 0, 0, this.bME.getResources().getDimensionPixelSize(t.e.bless_magin_bottom));
                ar.b(this.bMJ, t.d.topic_bless_text, 1);
                ar.k(this.bMJ, t.f.pic_float_zhufu_num_b);
            } else {
                if (i2 == 1) {
                    this.bMJ.setVisibility(0);
                    ar.c(this.bMH, t.f.candle_gif);
                } else {
                    this.bMJ.setVisibility(8);
                    ar.c(this.bMH, t.f.pic_float_qifu);
                }
                ((LinearLayout.LayoutParams) this.bMJ.getLayoutParams()).setMargins(this.bME.getResources().getDimensionPixelSize(t.e.candle_magin_left), 0, 0, this.bME.getResources().getDimensionPixelSize(t.e.candle_magin_bottom));
                ar.b(this.bMJ, t.d.topic_candle_text, 1);
                ar.k(this.bMJ, t.f.pic_float_qifu_num_b);
            }
            if (i2 == 1) {
                this.bMI.clearAnimation();
                this.bML = (AnimationDrawable) this.bMH.getDrawable();
                this.bML.start();
            } else {
                this.bMK.setOnClickListener(new e(this));
                this.bMI.setOnClickListener(new f(this, j));
            }
            this.aXu.setOnScrollListener(new h(this));
            this.bMM = AnimationUtils.loadAnimation(this.bME.getPageActivity(), t.a.gifview_rotate);
            this.bMN = AnimationUtils.loadAnimation(this.bME.getPageActivity(), t.a.gifview_rotate_out);
            this.bMO = AnimationUtils.loadAnimation(this.bME.getPageActivity(), t.a.gifview_alpha);
            this.bMP = AnimationUtils.loadAnimation(this.bME.getPageActivity(), t.a.gifview_alpha_visible);
        }
    }

    public void Qn() {
        if (this.aXu != null && this.aXw != null) {
            this.mHasMore = true;
            this.aXu.setNextPage(this.aXw);
            this.aXw.xb();
        }
    }

    public void Qo() {
        if (this.aXu != null && this.aXw != null) {
            this.mHasMore = false;
            if (this.bjN > 0) {
                this.aXw.dh(this.bjN);
            }
            this.aXu.setNextPage(this.aXw);
            this.aXw.xc();
            this.aXw.setText(this.bME.getResources().getString(t.j.list_no_more));
        }
    }

    public void Qp() {
        if (this.aXu != null && this.aXw != null) {
            this.mHasMore = false;
            this.aXu.setNextPage(null);
            this.aXw.xd();
        }
    }

    public View Yb() {
        return this.bMF;
    }

    private void Yf() {
        ar.l(this.bMF, t.d.cp_bg_line_d);
        ar.l(this.aXu, t.d.cp_bg_line_d);
        ar.c(this.bMG, t.f.icon_nav_share_selector);
        this.aXu.setDividerHeight(0);
        ar.k(this.mNavigationBar, t.f.bg_no_network);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bME, i);
        }
        if (this.aWk != null) {
            this.aWk.onChangeSkinType(this.bME, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dg(i);
        }
        if (this.aXw != null) {
            this.aXw.dg(i);
        }
        this.bME.getOrignalPage().getLayoutMode().ac(i == 1);
        this.bME.getOrignalPage().getLayoutMode().x(this.bMF);
    }

    public void iA(int i) {
        if (this.aWk != null) {
            this.aWk.setVisibility(i);
        }
    }

    public void c(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar != null && this.bMR != null) {
            this.aXu.setVisibility(0);
            this.bMR.setFromCDN(eVar.XV());
            this.bMR.a(eVar);
        }
    }

    public void Yc() {
        if (this.bMR != null) {
            this.bMR.notifyDataSetChanged();
        }
    }

    public BdTypeListView Yg() {
        return this.aXu;
    }

    public void Ya() {
        if (this.aXu != null) {
            this.aXu.nr();
        }
    }

    public void XZ() {
        if (this.aXu != null) {
            this.aXu.ns();
        }
    }

    public void a(r.a aVar) {
        this.mPullView.a(aVar);
    }

    public void f(NoNetworkView.a aVar) {
        this.bdG = aVar;
        if (this.aWk != null) {
            this.aWk.a(this.bdG);
        }
    }

    public void Yd() {
        if (this.aWk != null && this.bdG != null) {
            this.aWk.b(this.bdG);
        }
    }

    public void Ye() {
        if (this.mPullView != null) {
            this.mPullView.a((r.a) null);
        }
    }

    public void clearAnimation() {
        this.bMH.clearAnimation();
        this.bMI.clearAnimation();
        if (this.bMM != null) {
            this.bMM.cancel();
        }
        if (this.bMN != null) {
            this.bMN.cancel();
        }
        if (this.bMO != null) {
            this.bMO.cancel();
        }
        if (this.bMP != null) {
            this.bMP.cancel();
        }
        if (this.bML != null) {
            this.bML.stop();
        }
    }
}
