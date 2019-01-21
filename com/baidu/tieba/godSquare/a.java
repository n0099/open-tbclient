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
    private BaseActivity bBW;
    private PbListView bPn;
    private NoNetworkView drP;
    private com.baidu.tieba.godSquare.a.a erW;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.bBW = baseActivity;
        this.bBW.setContentView(e.h.god_square_activity);
        this.mRootView = this.bBW.findViewById(e.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bBW.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.drP = (NoNetworkView) this.bBW.findViewById(e.g.view_no_network);
        this.bPn = new PbListView(this.bBW.getPageContext().getPageActivity());
        this.bPn.oH();
        this.bPn.Fp();
        this.mListView = (BdTypeListView) this.bBW.findViewById(e.g.god_square_list_view);
        this.mPullView = new k(this.bBW.getPageContext());
        if (this.bBW instanceof j.b) {
            this.mPullView.a((j.b) this.bBW);
        }
        if (this.bBW instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bBW);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.erW = new com.baidu.tieba.godSquare.a.a(this.bBW.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.erW.aAM());
        this.mListView.setNextPage(this.bPn);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bBW.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bBW.hideLoadingView(this.mRootView);
    }

    public void oo(String str) {
        this.mListView.setVisibility(8);
        this.bBW.showNetRefreshView(this.mRootView, str, true);
    }

    public void abx() {
        this.mListView.setVisibility(0);
        this.bBW.hideNetRefreshView(this.mRootView);
    }

    public void ci(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.mListView;
    }

    public void notifyDataSetChanged() {
        this.erW.notifyDataSetChanged();
    }

    public void aKQ() {
        this.bPn.Fp();
    }

    public void aKR() {
        this.bPn.setText(this.bBW.getResources().getString(e.j.network_ungeilivable));
        this.bPn.Fq();
    }

    public void aKS() {
        this.bPn.setText(this.bBW.getResources().getString(e.j.list_no_more));
        this.bPn.Fq();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bBW.getPageContext(), i);
        this.bPn.ex(e.d.cp_bg_line_c);
        this.bPn.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bPn.ey(i);
        this.drP.onChangeSkinType(this.bBW.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.drP.a(aVar);
        }
    }
}
