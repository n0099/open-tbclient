package com.baidu.tieba.godSquare;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private BaseActivity cNd;
    private PbListView dbs;
    private NoNetworkView eCf;
    private com.baidu.tieba.godSquare.a.a fEh;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private i mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.cNd = baseActivity;
        this.cNd.setContentView(d.h.god_square_activity);
        this.mRootView = this.cNd.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.cNd.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eCf = (NoNetworkView) this.cNd.findViewById(d.g.view_no_network);
        this.dbs = new PbListView(this.cNd.getPageContext().getPageActivity());
        this.dbs.oM();
        this.dbs.aez();
        this.mListView = (BdTypeListView) this.cNd.findViewById(d.g.god_square_list_view);
        this.mPullView = new i(this.cNd.getPageContext());
        if (this.cNd instanceof h.c) {
            this.mPullView.setListPullRefreshListener((h.c) this.cNd);
        }
        if (this.cNd instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.cNd);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.fEh = new com.baidu.tieba.godSquare.a.a(this.cNd.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.fEh.aBv());
        this.mListView.setNextPage(this.dbs);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.cNd.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.cNd.hideLoadingView(this.mRootView);
    }

    public void uQ(String str) {
        this.mListView.setVisibility(8);
        this.cNd.showNetRefreshView(this.mRootView, str, true);
    }

    public void aBq() {
        this.mListView.setVisibility(0);
        this.cNd.hideNetRefreshView(this.mRootView);
    }

    public void cp(List<m> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.mListView;
    }

    public void notifyDataSetChanged() {
        this.fEh.notifyDataSetChanged();
    }

    public void bkU() {
        this.dbs.aez();
    }

    public void bkV() {
        this.dbs.setText(this.cNd.getResources().getString(d.j.network_ungeilivable));
        this.dbs.aeA();
    }

    public void bkW() {
        this.dbs.setText(this.cNd.getResources().getString(d.j.list_no_more));
        this.dbs.aeA();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cNd.getPageContext(), i);
        this.dbs.ia(d.C0277d.cp_bg_line_c);
        this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_d));
        this.dbs.ib(i);
        this.eCf.onChangeSkinType(this.cNd.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.eCf.a(aVar);
        }
    }
}
