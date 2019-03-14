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
    private BaseActivity cNa;
    private PbListView dbn;
    private NoNetworkView eCt;
    private com.baidu.tieba.godSquare.a.a fEt;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private i mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.cNa = baseActivity;
        this.cNa.setContentView(d.h.god_square_activity);
        this.mRootView = this.cNa.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.cNa.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eCt = (NoNetworkView) this.cNa.findViewById(d.g.view_no_network);
        this.dbn = new PbListView(this.cNa.getPageContext().getPageActivity());
        this.dbn.oM();
        this.dbn.aeC();
        this.mListView = (BdTypeListView) this.cNa.findViewById(d.g.god_square_list_view);
        this.mPullView = new i(this.cNa.getPageContext());
        if (this.cNa instanceof h.c) {
            this.mPullView.setListPullRefreshListener((h.c) this.cNa);
        }
        if (this.cNa instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.cNa);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.fEt = new com.baidu.tieba.godSquare.a.a(this.cNa.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.fEt.aBy());
        this.mListView.setNextPage(this.dbn);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.cNa.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.cNa.hideLoadingView(this.mRootView);
    }

    public void uR(String str) {
        this.mListView.setVisibility(8);
        this.cNa.showNetRefreshView(this.mRootView, str, true);
    }

    public void aBt() {
        this.mListView.setVisibility(0);
        this.cNa.hideNetRefreshView(this.mRootView);
    }

    public void cs(List<m> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.mListView;
    }

    public void notifyDataSetChanged() {
        this.fEt.notifyDataSetChanged();
    }

    public void bkX() {
        this.dbn.aeC();
    }

    public void bkY() {
        this.dbn.setText(this.cNa.getResources().getString(d.j.network_ungeilivable));
        this.dbn.aeD();
    }

    public void bkZ() {
        this.dbn.setText(this.cNa.getResources().getString(d.j.list_no_more));
        this.dbn.aeD();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cNa.getPageContext(), i);
        this.dbn.ib(d.C0277d.cp_bg_line_c);
        this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_d));
        this.dbn.ic(i);
        this.eCt.onChangeSkinType(this.cNa.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.eCt.a(aVar);
        }
    }
}
