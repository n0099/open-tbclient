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
    private PbListView bKJ;
    private BaseActivity bxI;
    private NoNetworkView dhH;
    private com.baidu.tieba.godSquare.a.a ehE;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.bxI = baseActivity;
        this.bxI.setContentView(e.h.god_square_activity);
        this.mRootView = this.bxI.findViewById(e.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bxI.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dhH = (NoNetworkView) this.bxI.findViewById(e.g.view_no_network);
        this.bKJ = new PbListView(this.bxI.getPageContext().getPageActivity());
        this.bKJ.oE();
        this.bKJ.DY();
        this.mListView = (BdTypeListView) this.bxI.findViewById(e.g.god_square_list_view);
        this.mPullView = new k(this.bxI.getPageContext());
        if (this.bxI instanceof j.b) {
            this.mPullView.a((j.b) this.bxI);
        }
        if (this.bxI instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bxI);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.ehE = new com.baidu.tieba.godSquare.a.a(this.bxI.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.ehE.axQ());
        this.mListView.setNextPage(this.bKJ);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bxI.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bxI.hideLoadingView(this.mRootView);
    }

    public void nu(String str) {
        this.mListView.setVisibility(8);
        this.bxI.showNetRefreshView(this.mRootView, str, true);
    }

    public void ZS() {
        this.mListView.setVisibility(0);
        this.bxI.hideNetRefreshView(this.mRootView);
    }

    public void cc(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.mListView;
    }

    public void notifyDataSetChanged() {
        this.ehE.notifyDataSetChanged();
    }

    public void aHM() {
        this.bKJ.DY();
    }

    public void aHN() {
        this.bKJ.setText(this.bxI.getResources().getString(e.j.network_ungeilivable));
        this.bKJ.DZ();
    }

    public void aHO() {
        this.bKJ.setText(this.bxI.getResources().getString(e.j.list_no_more));
        this.bKJ.DZ();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bxI.getPageContext(), i);
        this.bKJ.ej(e.d.cp_bg_line_c);
        this.bKJ.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bKJ.ek(i);
        this.dhH.onChangeSkinType(this.bxI.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dhH.a(aVar);
        }
    }
}
