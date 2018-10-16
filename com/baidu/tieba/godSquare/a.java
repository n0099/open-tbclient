package com.baidu.tieba.godSquare;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private PbListView bJY;
    private BaseActivity bwX;
    private NoNetworkView dgC;
    private com.baidu.tieba.godSquare.a.a egj;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.bwX = baseActivity;
        this.bwX.setContentView(e.h.god_square_activity);
        this.mRootView = this.bwX.findViewById(e.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bwX.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dgC = (NoNetworkView) this.bwX.findViewById(e.g.view_no_network);
        this.bJY = new PbListView(this.bwX.getPageContext().getPageActivity());
        this.bJY.oG();
        this.bJY.DO();
        this.mListView = (BdTypeListView) this.bwX.findViewById(e.g.god_square_list_view);
        this.mPullView = new k(this.bwX.getPageContext());
        if (this.bwX instanceof j.b) {
            this.mPullView.a((j.b) this.bwX);
        }
        if (this.bwX instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bwX);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.egj = new com.baidu.tieba.godSquare.a.a(this.bwX.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.egj.ays());
        this.mListView.setNextPage(this.bJY);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bwX.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bwX.hideLoadingView(this.mRootView);
    }

    public void nt(String str) {
        this.mListView.setVisibility(8);
        this.bwX.showNetRefreshView(this.mRootView, str, true);
    }

    public void ZH() {
        this.mListView.setVisibility(0);
        this.bwX.hideNetRefreshView(this.mRootView);
    }

    public void ce(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.mListView;
    }

    public void notifyDataSetChanged() {
        this.egj.notifyDataSetChanged();
    }

    public void aIo() {
        this.bJY.DO();
    }

    public void aIp() {
        this.bJY.setText(this.bwX.getResources().getString(e.j.network_ungeilivable));
        this.bJY.DP();
    }

    public void aIq() {
        this.bJY.setText(this.bwX.getResources().getString(e.j.list_no_more));
        this.bJY.DP();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bwX.getPageContext(), i);
        this.bJY.dV(e.d.cp_bg_line_c);
        this.bJY.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bJY.dW(i);
        this.dgC.onChangeSkinType(this.bwX.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dgC.a(aVar);
        }
    }
}
