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
    private BaseActivity cNc;
    private PbListView dbr;
    private NoNetworkView eCe;
    private com.baidu.tieba.godSquare.a.a fEh;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private i mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.cNc = baseActivity;
        this.cNc.setContentView(d.h.god_square_activity);
        this.mRootView = this.cNc.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.cNc.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eCe = (NoNetworkView) this.cNc.findViewById(d.g.view_no_network);
        this.dbr = new PbListView(this.cNc.getPageContext().getPageActivity());
        this.dbr.oM();
        this.dbr.aez();
        this.mListView = (BdTypeListView) this.cNc.findViewById(d.g.god_square_list_view);
        this.mPullView = new i(this.cNc.getPageContext());
        if (this.cNc instanceof h.c) {
            this.mPullView.setListPullRefreshListener((h.c) this.cNc);
        }
        if (this.cNc instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.cNc);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.fEh = new com.baidu.tieba.godSquare.a.a(this.cNc.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.fEh.aBv());
        this.mListView.setNextPage(this.dbr);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.cNc.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.cNc.hideLoadingView(this.mRootView);
    }

    public void uQ(String str) {
        this.mListView.setVisibility(8);
        this.cNc.showNetRefreshView(this.mRootView, str, true);
    }

    public void aBq() {
        this.mListView.setVisibility(0);
        this.cNc.hideNetRefreshView(this.mRootView);
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
        this.dbr.aez();
    }

    public void bkV() {
        this.dbr.setText(this.cNc.getResources().getString(d.j.network_ungeilivable));
        this.dbr.aeA();
    }

    public void bkW() {
        this.dbr.setText(this.cNc.getResources().getString(d.j.list_no_more));
        this.dbr.aeA();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cNc.getPageContext(), i);
        this.dbr.ia(d.C0277d.cp_bg_line_c);
        this.dbr.setTextColor(al.getColor(d.C0277d.cp_cont_d));
        this.dbr.ib(i);
        this.eCe.onChangeSkinType(this.cNc.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.eCe.a(aVar);
        }
    }
}
