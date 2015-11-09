package com.baidu.tieba.hottopic.view;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.hottopic.a.g;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class a {
    private NoNetworkView aMY;
    private PbListView aXe;
    private TbPageContext<HotTopicActivity> bqL;
    private View bqM = null;
    private NavigationBar mNavigationBar = null;
    private BdTypeListView aVo = null;
    private r mPullView = null;
    private g bqN = null;
    private boolean mHasMore = true;
    private int aXf = 0;
    private NoNetworkView.a aSi = null;

    public a(TbPageContext<HotTopicActivity> tbPageContext) {
        this.bqL = tbPageContext;
        initView();
    }

    private void initView() {
        if (this.bqL != null) {
            this.bqL.getOrignalPage().setContentView(i.g.hot_topic_activity);
            this.bqM = this.bqL.getOrignalPage().findViewById(i.f.hot_topic_root_view);
            this.mNavigationBar = (NavigationBar) this.bqM.findViewById(i.f.view_navigation_bar);
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(TbadkCoreApplication.m411getInst().getString(i.h.hot_topic_navigationbar_title));
            this.aMY = (NoNetworkView) this.bqM.findViewById(i.f.view_no_network);
            this.aVo = (BdTypeListView) this.bqM.findViewById(i.f.hot_topic_list);
            this.aVo.setOnSrollToBottomListener(this.bqL.getOrignalPage());
            this.mPullView = new r(this.bqL);
            this.aVo.setPullRefresh(this.mPullView);
            this.bqN = new g(this.bqL.getOrignalPage(), this.aVo);
            this.aXe = new PbListView(this.bqL.getPageActivity());
            this.aXe.np();
            this.aXe.cM(i.c.cp_bg_line_c);
            Rt();
        }
    }

    public void Mq() {
        if (this.aVo != null && this.aXe != null) {
            this.mHasMore = true;
            this.aVo.setNextPage(this.aXe);
            this.aXe.startLoadData();
        }
    }

    public void Mr() {
        if (this.aVo != null && this.aXe != null) {
            this.mHasMore = false;
            if (this.aXf > 0) {
                this.aXe.cO(this.aXf);
            }
            this.aVo.setNextPage(this.aXe);
            this.aXe.vz();
            this.aXe.setText(this.bqL.getResources().getString(i.h.list_no_more));
        }
    }

    public void Ms() {
        if (this.aVo != null && this.aXe != null) {
            this.mHasMore = false;
            this.aVo.setNextPage(null);
            this.aXe.vA();
        }
    }

    public View Rs() {
        return this.bqM;
    }

    private void Rt() {
        an.j(this.bqM, i.c.cp_bg_line_d);
        an.j(this.aVo, i.c.cp_bg_line_d);
        this.aVo.setDividerHeight(0);
        an.i(this.mNavigationBar, i.e.bg_no_network);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bqL, i);
        }
        if (this.aMY != null) {
            this.aMY.onChangeSkinType(this.bqL, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
        if (this.aXe != null) {
            this.aXe.cN(i);
        }
        this.bqL.getOrignalPage().getLayoutMode().ad(i == 1);
        this.bqL.getOrignalPage().getLayoutMode().k(this.bqM);
    }

    public void b(com.baidu.tieba.hottopic.data.b bVar) {
        if (bVar != null && this.bqN != null) {
            this.aVo.setVisibility(0);
            this.bqN.a(bVar);
        }
    }

    public void Ru() {
        if (this.bqN != null) {
            this.bqN.notifyDataSetChanged();
        }
    }

    public BdTypeListView Rv() {
        return this.aVo;
    }

    public void Rw() {
        if (this.aVo != null) {
            this.aVo.completePullRefresh();
        }
    }

    public void Rx() {
        if (this.aVo != null) {
            this.aVo.nx();
        }
    }

    public void a(p.a aVar) {
        this.mPullView.a(aVar);
    }

    public void g(NoNetworkView.a aVar) {
        this.aSi = aVar;
        if (this.aMY != null) {
            this.aMY.a(this.aSi);
        }
    }

    public void Ry() {
        if (this.aMY != null && this.aSi != null) {
            this.aMY.b(this.aSi);
        }
    }

    public void Rz() {
        if (this.mPullView != null) {
            this.mPullView.a((p.a) null);
        }
    }
}
