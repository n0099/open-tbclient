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
    private BaseActivity bBi;
    private PbListView bOB;
    private NoNetworkView drf;
    private com.baidu.tieba.godSquare.a.a ero;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.bBi = baseActivity;
        this.bBi.setContentView(e.h.god_square_activity);
        this.mRootView = this.bBi.findViewById(e.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bBi.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.drf = (NoNetworkView) this.bBi.findViewById(e.g.view_no_network);
        this.bOB = new PbListView(this.bBi.getPageContext().getPageActivity());
        this.bOB.oD();
        this.bOB.Fc();
        this.mListView = (BdTypeListView) this.bBi.findViewById(e.g.god_square_list_view);
        this.mPullView = new k(this.bBi.getPageContext());
        if (this.bBi instanceof j.b) {
            this.mPullView.a((j.b) this.bBi);
        }
        if (this.bBi instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bBi);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.ero = new com.baidu.tieba.godSquare.a.a(this.bBi.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.ero.aAp());
        this.mListView.setNextPage(this.bOB);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bBi.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bBi.hideLoadingView(this.mRootView);
    }

    public void nW(String str) {
        this.mListView.setVisibility(8);
        this.bBi.showNetRefreshView(this.mRootView, str, true);
    }

    public void aba() {
        this.mListView.setVisibility(0);
        this.bBi.hideNetRefreshView(this.mRootView);
    }

    public void ch(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.mListView;
    }

    public void notifyDataSetChanged() {
        this.ero.notifyDataSetChanged();
    }

    public void aKs() {
        this.bOB.Fc();
    }

    public void aKt() {
        this.bOB.setText(this.bBi.getResources().getString(e.j.network_ungeilivable));
        this.bOB.Fd();
    }

    public void aKu() {
        this.bOB.setText(this.bBi.getResources().getString(e.j.list_no_more));
        this.bOB.Fd();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bBi.getPageContext(), i);
        this.bOB.ex(e.d.cp_bg_line_c);
        this.bOB.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bOB.ey(i);
        this.drf.onChangeSkinType(this.bBi.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.drf.a(aVar);
        }
    }
}
