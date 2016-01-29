package com.baidu.tieba.hottopic.view;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b {
    private NoNetworkView aWk;
    private HotRanklistActivity bMC;
    private NavigationBar mNavigationBar = null;
    private View mRootView = null;
    private BdTypeListView aXu = null;
    private com.baidu.tieba.hottopic.a.a bMD = null;
    private t mPullView = null;
    private NoNetworkView.a bdG = null;

    public b(HotRanklistActivity hotRanklistActivity) {
        this.bMC = hotRanklistActivity;
        initView();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bMC.getPageContext(), i);
        this.bMC.getLayoutMode().ac(i == 1);
        this.bMC.getLayoutMode().x(this.mRootView);
        this.aWk.onChangeSkinType(this.bMC.getPageContext(), i);
    }

    private void initView() {
        if (this.bMC != null) {
            this.bMC.setContentView(t.h.hot_topic_ranklist_activity);
        }
        this.mRootView = this.bMC.findViewById(t.g.topic_list_root_view);
        this.mNavigationBar = (NavigationBar) this.bMC.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(t.j.hot_topic);
        this.aWk = (NoNetworkView) this.bMC.findViewById(t.g.view_no_network);
        this.aXu = (BdTypeListView) this.bMC.findViewById(t.g.hot_topic_ranklist);
        View view = new View(this.bMC.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, this.bMC.getResources().getDimensionPixelSize(t.e.frs_header_ticket_icon_gap)));
        this.aXu.addFooterView(view);
        this.mPullView = new com.baidu.tbadk.core.view.t(this.bMC.getPageContext());
        this.aXu.setPullRefresh(this.mPullView);
        this.bMD = new com.baidu.tieba.hottopic.a.a(this.bMC, this.aXu);
    }

    public void iA(int i) {
        if (this.aWk != null) {
            this.aWk.setVisibility(i);
        }
    }

    public void f(NoNetworkView.a aVar) {
        this.bdG = aVar;
        if (this.aWk != null) {
            this.aWk.a(this.bdG);
        }
    }

    public void XZ() {
        if (this.aXu != null) {
            this.aXu.ns();
        }
    }

    public void Ya() {
        if (this.aXu != null) {
            this.aXu.nr();
        }
    }

    public View Yb() {
        return this.mRootView;
    }

    public void a(r.a aVar) {
        this.mPullView.a(aVar);
    }

    public void b(com.baidu.tieba.hottopic.data.i iVar) {
        if (iVar != null && this.bMD != null) {
            this.aXu.setVisibility(0);
            this.bMD.a(iVar);
        }
    }

    public void Yc() {
        if (this.bMD != null) {
            this.bMD.notifyDataSetChanged();
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
}
