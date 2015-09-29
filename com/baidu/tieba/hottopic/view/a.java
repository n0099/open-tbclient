package com.baidu.tieba.hottopic.view;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
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
    private NoNetworkView aMF;
    private PbListView aWL;
    private TbPageContext<HotTopicActivity> bpW;
    private View bpX = null;
    private NavigationBar mNavigationBar = null;
    private BdTypeListView aUV = null;
    private r mPullView = null;
    private g bpY = null;
    private boolean mHasMore = true;
    private int aWM = 0;
    private NoNetworkView.a aRP = null;

    public a(TbPageContext<HotTopicActivity> tbPageContext) {
        this.bpW = tbPageContext;
        initView();
    }

    private void initView() {
        if (this.bpW != null) {
            this.bpW.getOrignalPage().setContentView(i.g.hot_topic_activity);
            this.bpX = this.bpW.getOrignalPage().findViewById(i.f.hot_topic_root_view);
            this.mNavigationBar = (NavigationBar) this.bpX.findViewById(i.f.view_navigation_bar);
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(TbadkCoreApplication.m411getInst().getString(i.h.hot_topic_navigationbar_title));
            this.aMF = (NoNetworkView) this.bpX.findViewById(i.f.view_no_network);
            this.aUV = (BdTypeListView) this.bpX.findViewById(i.f.hot_topic_list);
            this.aUV.setOnSrollToBottomListener(this.bpW.getOrignalPage());
            this.mPullView = new r(this.bpW);
            this.aUV.setPullRefresh(this.mPullView);
            this.bpY = new g(this.bpW.getOrignalPage(), this.aUV);
            this.aWL = new PbListView(this.bpW.getPageActivity());
            this.aWL.no();
            this.aWL.cM(i.c.cp_bg_line_c);
            Rb();
        }
    }

    public void Me() {
        if (this.aUV != null && this.aWL != null) {
            this.mHasMore = true;
            this.aUV.setNextPage(this.aWL);
            this.aWL.startLoadData();
        }
    }

    public void Mf() {
        if (this.aUV != null && this.aWL != null) {
            this.mHasMore = false;
            if (this.aWM > 0) {
                this.aWL.cO(this.aWM);
            }
            this.aUV.setNextPage(this.aWL);
            this.aWL.vy();
            this.aWL.setText(this.bpW.getResources().getString(i.h.list_no_more));
        }
    }

    public void Mg() {
        if (this.aUV != null && this.aWL != null) {
            this.mHasMore = false;
            this.aUV.setNextPage(null);
            this.aWL.vz();
        }
    }

    public View Ra() {
        return this.bpX;
    }

    private void Rb() {
        am.j(this.bpX, i.c.cp_bg_line_d);
        am.j(this.aUV, i.c.cp_bg_line_d);
        this.aUV.setDividerHeight(0);
        am.i(this.mNavigationBar, i.e.bg_no_network);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bpW, i);
        }
        if (this.aMF != null) {
            this.aMF.onChangeSkinType(this.bpW, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
        if (this.aWL != null) {
            this.aWL.cN(i);
        }
        this.bpW.getOrignalPage().getLayoutMode().ad(i == 1);
        this.bpW.getOrignalPage().getLayoutMode().k(this.bpX);
    }

    public void b(com.baidu.tieba.hottopic.data.b bVar) {
        if (bVar != null && this.bpY != null) {
            this.aUV.setVisibility(0);
            this.bpY.a(bVar);
        }
    }

    public void Rc() {
        if (this.bpY != null) {
            this.bpY.notifyDataSetChanged();
        }
    }

    public BdTypeListView Rd() {
        return this.aUV;
    }

    public void Re() {
        if (this.aUV != null) {
            this.aUV.completePullRefresh();
        }
    }

    public void Rf() {
        if (this.aUV != null) {
            this.aUV.nw();
        }
    }

    public void a(p.a aVar) {
        this.mPullView.a(aVar);
    }

    public void g(NoNetworkView.a aVar) {
        this.aRP = aVar;
        if (this.aMF != null) {
            this.aMF.a(this.aRP);
        }
    }

    public void Rg() {
        if (this.aMF != null && this.aRP != null) {
            this.aMF.b(this.aRP);
        }
    }

    public void Rh() {
        if (this.mPullView != null) {
            this.mPullView.a((p.a) null);
        }
    }
}
