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
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a {
    private NoNetworkView aQl;
    private PbListView aRt;
    private Animation bFA;
    private Animation bFB;
    private TbPageContext<HotTopicActivity> bFq;
    private ImageView bFt;
    private LinearLayout bFu;
    private TextView bFv;
    private View bFw;
    private AnimationDrawable bFx;
    private Animation bFy;
    private Animation bFz;
    private View bFr = null;
    private NavigationBar mNavigationBar = null;
    private ImageView bFs = null;
    private boolean bFC = false;
    private int index = -1;
    private BdTypeListView aRs = null;
    private s mPullView = null;
    private com.baidu.tieba.hottopic.a.g bFD = null;
    private boolean mHasMore = true;
    private int bcZ = 0;
    private NoNetworkView.a aXw = null;

    public a(TbPageContext<HotTopicActivity> tbPageContext) {
        this.bFq = tbPageContext;
        initView();
    }

    private void initView() {
        if (this.bFq != null) {
            this.bFq.getOrignalPage().setContentView(n.g.hot_topic_activity);
            this.bFr = this.bFq.getOrignalPage().findViewById(n.f.hot_topic_root_view);
            this.mNavigationBar = (NavigationBar) this.bFq.getOrignalPage().findViewById(n.f.view_navigation_bar);
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.bFs = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.hot_topic_share, new b(this));
            this.mNavigationBar.setTitleText(TbadkCoreApplication.m411getInst().getString(n.i.hot_topic_navigationbar_title));
            this.aQl = (NoNetworkView) this.bFr.findViewById(n.f.view_no_network);
            this.bFt = (ImageView) this.bFr.findViewById(n.f.gif_image);
            this.bFu = (LinearLayout) this.bFr.findViewById(n.f.gif_group);
            this.bFv = (TextView) this.bFr.findViewById(n.f.git_desc);
            this.bFw = this.bFr.findViewById(n.f.gif_clikc_view);
            this.aRs = (BdTypeListView) this.bFr.findViewById(n.f.hot_topic_list);
            this.aRs.setOnSrollToBottomListener(this.bFq.getOrignalPage());
            this.mPullView = new s(this.bFq);
            this.aRs.setPullRefresh(this.mPullView);
            this.bFD = new com.baidu.tieba.hottopic.a.g(this.bFq.getOrignalPage(), this.aRs);
            this.aRt = new PbListView(this.bFq.getPageActivity());
            this.aRt.nv();
            this.aRt.cU(n.c.cp_bg_line_c);
            wz();
        }
    }

    public void a(int i, boolean z, long j, int i2) {
        this.bFu.setVisibility(i);
        if (i != 8) {
            this.bFv.setText(ax.x(j));
            this.bFC = z;
            if (this.bFC) {
                if (i2 == 1) {
                    this.bFv.setVisibility(0);
                    as.c(this.bFt, n.e.bless_gif);
                } else {
                    this.bFv.setVisibility(8);
                    as.c(this.bFt, n.e.pic_float_zhufu);
                }
                ((LinearLayout.LayoutParams) this.bFv.getLayoutParams()).setMargins(this.bFq.getResources().getDimensionPixelSize(n.d.bless_magin_left), 0, 0, this.bFq.getResources().getDimensionPixelSize(n.d.bless_magin_bottom));
                as.b(this.bFv, n.c.topic_bless_text, 1);
                as.i((View) this.bFv, n.e.pic_float_zhufu_num_b);
            } else {
                if (i2 == 1) {
                    this.bFv.setVisibility(0);
                    as.c(this.bFt, n.e.candle_gif);
                } else {
                    this.bFv.setVisibility(8);
                    as.c(this.bFt, n.e.pic_float_qifu);
                }
                ((LinearLayout.LayoutParams) this.bFv.getLayoutParams()).setMargins(this.bFq.getResources().getDimensionPixelSize(n.d.candle_magin_left), 0, 0, this.bFq.getResources().getDimensionPixelSize(n.d.candle_magin_bottom));
                as.b(this.bFv, n.c.topic_candle_text, 1);
                as.i((View) this.bFv, n.e.pic_float_qifu_num_b);
            }
            if (i2 == 1) {
                this.bFu.clearAnimation();
                this.bFx = (AnimationDrawable) this.bFt.getDrawable();
                this.bFx.start();
            } else {
                this.bFw.setOnClickListener(new c(this));
                this.bFu.setOnClickListener(new d(this, j));
            }
            this.aRs.setOnScrollListener(new f(this));
            this.bFy = AnimationUtils.loadAnimation(this.bFq.getPageActivity(), n.a.gifview_rotate);
            this.bFz = AnimationUtils.loadAnimation(this.bFq.getPageActivity(), n.a.gifview_rotate_out);
            this.bFA = AnimationUtils.loadAnimation(this.bFq.getPageActivity(), n.a.gifview_alpha);
            this.bFB = AnimationUtils.loadAnimation(this.bFq.getPageActivity(), n.a.gifview_alpha_visible);
        }
    }

    public void NR() {
        if (this.aRs != null && this.aRt != null) {
            this.mHasMore = true;
            this.aRs.setNextPage(this.aRt);
            this.aRt.startLoadData();
        }
    }

    public void NS() {
        if (this.aRs != null && this.aRt != null) {
            this.mHasMore = false;
            if (this.bcZ > 0) {
                this.aRt.cW(this.bcZ);
            }
            this.aRs.setNextPage(this.aRt);
            this.aRt.wf();
            this.aRt.setText(this.bFq.getResources().getString(n.i.list_no_more));
        }
    }

    public void NT() {
        if (this.aRs != null && this.aRt != null) {
            this.mHasMore = false;
            this.aRs.setNextPage(null);
            this.aRt.wg();
        }
    }

    public View UC() {
        return this.bFr;
    }

    private void wz() {
        as.j(this.bFr, n.c.cp_bg_line_d);
        as.j(this.aRs, n.c.cp_bg_line_d);
        as.c(this.bFs, n.e.icon_nav_share_selector);
        this.aRs.setDividerHeight(0);
        as.i(this.mNavigationBar, n.e.bg_no_network);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bFq, i);
        }
        if (this.aQl != null) {
            this.aQl.onChangeSkinType(this.bFq, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cV(i);
        }
        if (this.aRt != null) {
            this.aRt.cV(i);
        }
        this.bFq.getOrignalPage().getLayoutMode().af(i == 1);
        this.bFq.getOrignalPage().getLayoutMode().k(this.bFr);
    }

    public void hD(int i) {
        if (this.aQl != null) {
            this.aQl.setVisibility(i);
        }
    }

    public void c(com.baidu.tieba.hottopic.data.c cVar) {
        if (cVar != null && this.bFD != null) {
            this.aRs.setVisibility(0);
            this.bFD.a(cVar);
        }
    }

    public void UD() {
        if (this.bFD != null) {
            this.bFD.notifyDataSetChanged();
        }
    }

    public BdTypeListView UE() {
        return this.aRs;
    }

    public void TT() {
        if (this.aRs != null) {
            this.aRs.completePullRefresh();
        }
    }

    public void TU() {
        if (this.aRs != null) {
            this.aRs.nD();
        }
    }

    public void a(q.a aVar) {
        this.mPullView.a(aVar);
    }

    public void f(NoNetworkView.a aVar) {
        this.aXw = aVar;
        if (this.aQl != null) {
            this.aQl.a(this.aXw);
        }
    }

    public void UF() {
        if (this.aQl != null && this.aXw != null) {
            this.aQl.b(this.aXw);
        }
    }

    public void UG() {
        if (this.mPullView != null) {
            this.mPullView.a((q.a) null);
        }
    }

    public void clearAnimation() {
        this.bFt.clearAnimation();
        this.bFu.clearAnimation();
        if (this.bFy != null) {
            this.bFy.cancel();
        }
        if (this.bFz != null) {
            this.bFz.cancel();
        }
        if (this.bFA != null) {
            this.bFA.cancel();
        }
        if (this.bFB != null) {
            this.bFB.cancel();
        }
        if (this.bFx != null) {
            this.bFx.stop();
        }
    }
}
