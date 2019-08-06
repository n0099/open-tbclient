package com.baidu.tieba.godSquare;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private BaseActivity cWT;
    private PbListView dnN;
    private NoNetworkView eXf;
    private com.baidu.tieba.godSquare.a.a gaU;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private i mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.cWT = baseActivity;
        this.cWT.setContentView(R.layout.god_square_activity);
        this.mRootView = this.cWT.findViewById(R.id.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.cWT.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eXf = (NoNetworkView) this.cWT.findViewById(R.id.view_no_network);
        this.dnN = new PbListView(this.cWT.getPageContext().getPageActivity());
        this.dnN.nZ();
        this.dnN.akF();
        this.mListView = (BdTypeListView) this.cWT.findViewById(R.id.god_square_list_view);
        this.mPullView = new i(this.cWT.getPageContext());
        if (this.cWT instanceof h.c) {
            this.mPullView.setListPullRefreshListener((h.c) this.cWT);
        }
        if (this.cWT instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.cWT);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.gaU = new com.baidu.tieba.godSquare.a.a(this.cWT.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.gaU.aJo());
        this.mListView.setNextPage(this.dnN);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.cWT.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.cWT.hideLoadingView(this.mRootView);
    }

    public void wP(String str) {
        this.mListView.setVisibility(8);
        this.cWT.showNetRefreshView(this.mRootView, str, true);
    }

    public void aJj() {
        this.mListView.setVisibility(0);
        this.cWT.hideNetRefreshView(this.mRootView);
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
        this.gaU.notifyDataSetChanged();
    }

    public void buF() {
        this.dnN.akF();
    }

    public void buG() {
        this.dnN.setText(this.cWT.getResources().getString(R.string.network_ungeilivable));
        this.dnN.akG();
    }

    public void buH() {
        this.dnN.setText(this.cWT.getResources().getString(R.string.list_no_more));
        this.dnN.akG();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cWT.getPageContext(), i);
        this.dnN.iU(R.color.cp_bg_line_c);
        this.dnN.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dnN.iV(i);
        this.eXf.onChangeSkinType(this.cWT.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.eXf.a(aVar);
        }
    }
}
