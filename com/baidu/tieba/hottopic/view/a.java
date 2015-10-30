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
    private NoNetworkView aMQ;
    private PbListView aWW;
    private TbPageContext<HotTopicActivity> bqh;
    private View bqi = null;
    private NavigationBar mNavigationBar = null;
    private BdTypeListView aVg = null;
    private r mPullView = null;
    private g bqj = null;
    private boolean mHasMore = true;
    private int aWX = 0;
    private NoNetworkView.a aSa = null;

    public a(TbPageContext<HotTopicActivity> tbPageContext) {
        this.bqh = tbPageContext;
        initView();
    }

    private void initView() {
        if (this.bqh != null) {
            this.bqh.getOrignalPage().setContentView(i.g.hot_topic_activity);
            this.bqi = this.bqh.getOrignalPage().findViewById(i.f.hot_topic_root_view);
            this.mNavigationBar = (NavigationBar) this.bqi.findViewById(i.f.view_navigation_bar);
            this.mNavigationBar.setVisibility(0);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(TbadkCoreApplication.m411getInst().getString(i.h.hot_topic_navigationbar_title));
            this.aMQ = (NoNetworkView) this.bqi.findViewById(i.f.view_no_network);
            this.aVg = (BdTypeListView) this.bqi.findViewById(i.f.hot_topic_list);
            this.aVg.setOnSrollToBottomListener(this.bqh.getOrignalPage());
            this.mPullView = new r(this.bqh);
            this.aVg.setPullRefresh(this.mPullView);
            this.bqj = new g(this.bqh.getOrignalPage(), this.aVg);
            this.aWW = new PbListView(this.bqh.getPageActivity());
            this.aWW.no();
            this.aWW.cM(i.c.cp_bg_line_c);
            QX();
        }
    }

    public void Ma() {
        if (this.aVg != null && this.aWW != null) {
            this.mHasMore = true;
            this.aVg.setNextPage(this.aWW);
            this.aWW.startLoadData();
        }
    }

    public void Mb() {
        if (this.aVg != null && this.aWW != null) {
            this.mHasMore = false;
            if (this.aWX > 0) {
                this.aWW.cO(this.aWX);
            }
            this.aVg.setNextPage(this.aWW);
            this.aWW.vv();
            this.aWW.setText(this.bqh.getResources().getString(i.h.list_no_more));
        }
    }

    public void Mc() {
        if (this.aVg != null && this.aWW != null) {
            this.mHasMore = false;
            this.aVg.setNextPage(null);
            this.aWW.vw();
        }
    }

    public View QW() {
        return this.bqi;
    }

    private void QX() {
        an.j(this.bqi, i.c.cp_bg_line_d);
        an.j(this.aVg, i.c.cp_bg_line_d);
        this.aVg.setDividerHeight(0);
        an.i(this.mNavigationBar, i.e.bg_no_network);
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.bqh, i);
        }
        if (this.aMQ != null) {
            this.aMQ.onChangeSkinType(this.bqh, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
        if (this.aWW != null) {
            this.aWW.cN(i);
        }
        this.bqh.getOrignalPage().getLayoutMode().ad(i == 1);
        this.bqh.getOrignalPage().getLayoutMode().k(this.bqi);
    }

    public void b(com.baidu.tieba.hottopic.data.b bVar) {
        if (bVar != null && this.bqj != null) {
            this.aVg.setVisibility(0);
            this.bqj.a(bVar);
        }
    }

    public void QY() {
        if (this.bqj != null) {
            this.bqj.notifyDataSetChanged();
        }
    }

    public BdTypeListView QZ() {
        return this.aVg;
    }

    public void Ra() {
        if (this.aVg != null) {
            this.aVg.completePullRefresh();
        }
    }

    public void Rb() {
        if (this.aVg != null) {
            this.aVg.nw();
        }
    }

    public void a(p.a aVar) {
        this.mPullView.a(aVar);
    }

    public void g(NoNetworkView.a aVar) {
        this.aSa = aVar;
        if (this.aMQ != null) {
            this.aMQ.a(this.aSa);
        }
    }

    public void Rc() {
        if (this.aMQ != null && this.aSa != null) {
            this.aMQ.b(this.aSa);
        }
    }

    public void Rd() {
        if (this.mPullView != null) {
            this.mPullView.a((p.a) null);
        }
    }
}
