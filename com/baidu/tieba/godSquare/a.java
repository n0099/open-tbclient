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
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private BaseActivity cVq;
    private PbListView dlY;
    private NoNetworkView eRV;
    private com.baidu.tieba.godSquare.a.a fVh;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private i mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.cVq = baseActivity;
        this.cVq.setContentView(R.layout.god_square_activity);
        this.mRootView = this.cVq.findViewById(R.id.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.cVq.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eRV = (NoNetworkView) this.cVq.findViewById(R.id.view_no_network);
        this.dlY = new PbListView(this.cVq.getPageContext().getPageActivity());
        this.dlY.nG();
        this.dlY.ajy();
        this.mListView = (BdTypeListView) this.cVq.findViewById(R.id.god_square_list_view);
        this.mPullView = new i(this.cVq.getPageContext());
        if (this.cVq instanceof h.c) {
            this.mPullView.setListPullRefreshListener((h.c) this.cVq);
        }
        if (this.cVq instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.cVq);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.fVh = new com.baidu.tieba.godSquare.a.a(this.cVq.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.fVh.aHP());
        this.mListView.setNextPage(this.dlY);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.cVq.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.cVq.hideLoadingView(this.mRootView);
    }

    public void wj(String str) {
        this.mListView.setVisibility(8);
        this.cVq.showNetRefreshView(this.mRootView, str, true);
    }

    public void aHK() {
        this.mListView.setVisibility(0);
        this.cVq.hideNetRefreshView(this.mRootView);
    }

    public void cx(List<m> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.mListView;
    }

    public void notifyDataSetChanged() {
        this.fVh.notifyDataSetChanged();
    }

    public void bsr() {
        this.dlY.ajy();
    }

    public void bss() {
        this.dlY.setText(this.cVq.getResources().getString(R.string.network_ungeilivable));
        this.dlY.ajz();
    }

    public void bst() {
        this.dlY.setText(this.cVq.getResources().getString(R.string.list_no_more));
        this.dlY.ajz();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cVq.getPageContext(), i);
        this.dlY.iO(R.color.cp_bg_line_c);
        this.dlY.setTextColor(al.getColor(R.color.cp_cont_d));
        this.dlY.iP(i);
        this.eRV.onChangeSkinType(this.cVq.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.eRV.a(aVar);
        }
    }
}
