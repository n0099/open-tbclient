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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a {
    private NoNetworkView aUd;
    private PbListView aVj;
    private TbPageContext<HotTopicActivity> bIX;
    private ImageView bJa;
    private LinearLayout bJb;
    private TextView bJc;
    private View bJd;
    private AnimationDrawable bJe;
    private Animation bJf;
    private Animation bJg;
    private Animation bJh;
    private Animation bJi;
    private View bIY = null;
    private NavigationBar mNavigationBar = null;
    private ImageView bIZ = null;
    private boolean bJj = false;
    private int index = -1;
    private BdTypeListView aVi = null;
    private t mPullView = null;
    private com.baidu.tieba.hottopic.a.g bJk = null;
    private boolean mHasMore = true;
    private int bgZ = 0;
    private NoNetworkView.a bbw = null;

    public a(TbPageContext<HotTopicActivity> tbPageContext) {
        this.bIX = tbPageContext;
        initView();
    }

    private void initView() {
        if (this.bIX != null) {
            this.bIX.getOrignalPage().setContentView(n.h.hot_topic_activity);
            this.bIY = this.bIX.getOrignalPage().findViewById(n.g.hot_topic_root_view);
            this.mNavigationBar = (NavigationBar) this.bIX.getOrignalPage().findViewById(n.g.view_navigation_bar);
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.bIZ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.hot_topic_share, new b(this));
            this.mNavigationBar.setTitleText(TbadkCoreApplication.m411getInst().getString(n.j.hot_topic_navigationbar_title));
            this.aUd = (NoNetworkView) this.bIY.findViewById(n.g.view_no_network);
            this.bJa = (ImageView) this.bIY.findViewById(n.g.gif_image);
            this.bJb = (LinearLayout) this.bIY.findViewById(n.g.gif_group);
            this.bJc = (TextView) this.bIY.findViewById(n.g.git_desc);
            this.bJd = this.bIY.findViewById(n.g.gif_clikc_view);
            this.aVi = (BdTypeListView) this.bIY.findViewById(n.g.hot_topic_list);
            this.aVi.setOnSrollToBottomListener(this.bIX.getOrignalPage());
            this.mPullView = new t(this.bIX);
            this.aVi.setPullRefresh(this.mPullView);
            this.bJk = new com.baidu.tieba.hottopic.a.g(this.bIX.getOrignalPage(), this.aVi);
            this.aVj = new PbListView(this.bIX.getPageActivity());
            this.aVj.mT();
            this.aVj.cO(n.d.cp_bg_line_c);
            VG();
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.bJb.setVisibility(i);
        if (i != 8) {
            this.bJc.setText(ax.y(j));
            this.bJj = z;
            if (this.bJj) {
                if (i2 == 1) {
                    this.bJc.setVisibility(0);
                    as.c(this.bJa, n.f.bless_gif);
                } else {
                    this.bJc.setVisibility(8);
                    as.c(this.bJa, n.f.pic_float_zhufu);
                }
                ((LinearLayout.LayoutParams) this.bJc.getLayoutParams()).setMargins(this.bIX.getResources().getDimensionPixelSize(n.e.bless_magin_left), 0, 0, this.bIX.getResources().getDimensionPixelSize(n.e.bless_magin_bottom));
                as.b(this.bJc, n.d.topic_bless_text, 1);
                as.i((View) this.bJc, n.f.pic_float_zhufu_num_b);
            } else {
                if (i2 == 1) {
                    this.bJc.setVisibility(0);
                    as.c(this.bJa, n.f.candle_gif);
                } else {
                    this.bJc.setVisibility(8);
                    as.c(this.bJa, n.f.pic_float_qifu);
                }
                ((LinearLayout.LayoutParams) this.bJc.getLayoutParams()).setMargins(this.bIX.getResources().getDimensionPixelSize(n.e.candle_magin_left), 0, 0, this.bIX.getResources().getDimensionPixelSize(n.e.candle_magin_bottom));
                as.b(this.bJc, n.d.topic_candle_text, 1);
                as.i((View) this.bJc, n.f.pic_float_qifu_num_b);
            }
            if (i2 == 1) {
                this.bJb.clearAnimation();
                this.bJe = (AnimationDrawable) this.bJa.getDrawable();
                this.bJe.start();
            } else {
                this.bJd.setOnClickListener(new c(this));
                this.bJb.setOnClickListener(new d(this, j));
            }
            this.aVi.setOnScrollListener(new f(this));
            this.bJf = AnimationUtils.loadAnimation(this.bIX.getPageActivity(), n.a.gifview_rotate);
            this.bJg = AnimationUtils.loadAnimation(this.bIX.getPageActivity(), n.a.gifview_rotate_out);
            this.bJh = AnimationUtils.loadAnimation(this.bIX.getPageActivity(), n.a.gifview_alpha);
            this.bJi = AnimationUtils.loadAnimation(this.bIX.getPageActivity(), n.a.gifview_alpha_visible);
        }
    }

    public void Ok() {
        if (this.aVi != null && this.aVj != null) {
            this.mHasMore = true;
            this.aVi.setNextPage(this.aVj);
            this.aVj.startLoadData();
        }
    }

    public void Ol() {
        if (this.aVi != null && this.aVj != null) {
            this.mHasMore = false;
            if (this.bgZ > 0) {
                this.aVj.cQ(this.bgZ);
            }
            this.aVi.setNextPage(this.aVj);
            this.aVj.vP();
            this.aVj.setText(this.bIX.getResources().getString(n.j.list_no_more));
        }
    }

    public void Om() {
        if (this.aVi != null && this.aVj != null) {
            this.mHasMore = false;
            this.aVi.setNextPage(null);
            this.aVj.vQ();
        }
    }

    public View VF() {
        return this.bIY;
    }

    private void VG() {
        as.j(this.bIY, n.d.cp_bg_line_d);
        as.j(this.aVi, n.d.cp_bg_line_d);
        as.c(this.bIZ, n.f.icon_nav_share_selector);
        this.aVi.setDividerHeight(0);
        as.i(this.mNavigationBar, n.f.bg_no_network);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bIX, i);
        }
        if (this.aUd != null) {
            this.aUd.onChangeSkinType(this.bIX, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cP(i);
        }
        if (this.aVj != null) {
            this.aVj.cP(i);
        }
        this.bIX.getOrignalPage().getLayoutMode().ac(i == 1);
        this.bIX.getOrignalPage().getLayoutMode().k(this.bIY);
    }

    public void ic(int i) {
        if (this.aUd != null) {
            this.aUd.setVisibility(i);
        }
    }

    public void c(com.baidu.tieba.hottopic.data.c cVar) {
        if (cVar != null && this.bJk != null) {
            this.aVi.setVisibility(0);
            this.bJk.a(cVar);
        }
    }

    public void VH() {
        if (this.bJk != null) {
            this.bJk.notifyDataSetChanged();
        }
    }

    public BdTypeListView VI() {
        return this.aVi;
    }

    public void VJ() {
        if (this.aVi != null) {
            this.aVi.completePullRefresh();
        }
    }

    public void VK() {
        if (this.aVi != null) {
            this.aVi.nb();
        }
    }

    public void a(r.a aVar) {
        this.mPullView.a(aVar);
    }

    public void f(NoNetworkView.a aVar) {
        this.bbw = aVar;
        if (this.aUd != null) {
            this.aUd.a(this.bbw);
        }
    }

    public void VL() {
        if (this.aUd != null && this.bbw != null) {
            this.aUd.b(this.bbw);
        }
    }

    public void VM() {
        if (this.mPullView != null) {
            this.mPullView.a((r.a) null);
        }
    }

    public void clearAnimation() {
        this.bJa.clearAnimation();
        this.bJb.clearAnimation();
        if (this.bJf != null) {
            this.bJf.cancel();
        }
        if (this.bJg != null) {
            this.bJg.cancel();
        }
        if (this.bJh != null) {
            this.bJh.cancel();
        }
        if (this.bJi != null) {
            this.bJi.cancel();
        }
        if (this.bJe != null) {
            this.bJe.stop();
        }
    }
}
