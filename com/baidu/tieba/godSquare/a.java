package com.baidu.tieba.godSquare;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private BaseActivity bmZ;
    private PbListView bvA;
    private NoNetworkView cSy;
    private com.baidu.tieba.godSquare.a.a dRd;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private h mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.bmZ = baseActivity;
        this.bmZ.setContentView(d.h.god_square_activity);
        this.mRootView = this.bmZ.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bmZ.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.j.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cSy = (NoNetworkView) this.bmZ.findViewById(d.g.view_no_network);
        this.bvA = new PbListView(this.bmZ.getPageContext().getPageActivity());
        this.bvA.np();
        this.bvA.Ax();
        this.mListView = (BdTypeListView) this.bmZ.findViewById(d.g.god_square_list_view);
        this.mPullView = new h(this.bmZ.getPageContext());
        if (this.bmZ instanceof g.b) {
            this.mPullView.a((g.b) this.bmZ);
        }
        if (this.bmZ instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bmZ);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.dRd = new com.baidu.tieba.godSquare.a.a(this.bmZ.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.dRd.atj());
        this.mListView.setNextPage(this.bvA);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bmZ.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bmZ.hideLoadingView(this.mRootView);
    }

    public void mn(String str) {
        this.mListView.setVisibility(8);
        this.bmZ.showNetRefreshView(this.mRootView, str, true);
    }

    public void Uk() {
        this.mListView.setVisibility(0);
        this.bmZ.hideNetRefreshView(this.mRootView);
    }

    public void bN(List<com.baidu.adp.widget.ListView.h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.mListView;
    }

    public void notifyDataSetChanged() {
        this.dRd.notifyDataSetChanged();
    }

    public void aCM() {
        this.bvA.Ax();
    }

    public void aCN() {
        this.bvA.setText(this.bmZ.getResources().getString(d.j.network_ungeilivable));
        this.bvA.Ay();
    }

    public void aCO() {
        this.bvA.setText(this.bmZ.getResources().getString(d.j.list_no_more));
        this.bvA.Ay();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bmZ.getPageContext(), i);
        this.bvA.dB(d.C0140d.cp_bg_line_c);
        this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_d));
        this.bvA.dC(i);
        this.cSy.onChangeSkinType(this.bmZ.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.cSy.a(aVar);
        }
    }
}
