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
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private BaseActivity bnc;
    private PbListView bvC;
    private NoNetworkView cSv;
    private com.baidu.tieba.godSquare.a.a dQY;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private h mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.bnc = baseActivity;
        this.bnc.setContentView(f.h.god_square_activity);
        this.mRootView = this.bnc.findViewById(f.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bnc.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(f.j.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cSv = (NoNetworkView) this.bnc.findViewById(f.g.view_no_network);
        this.bvC = new PbListView(this.bnc.getPageContext().getPageActivity());
        this.bvC.np();
        this.bvC.Av();
        this.mListView = (BdTypeListView) this.bnc.findViewById(f.g.god_square_list_view);
        this.mPullView = new h(this.bnc.getPageContext());
        if (this.bnc instanceof g.b) {
            this.mPullView.a((g.b) this.bnc);
        }
        if (this.bnc instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bnc);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.dQY = new com.baidu.tieba.godSquare.a.a(this.bnc.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.dQY.ati());
        this.mListView.setNextPage(this.bvC);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bnc.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bnc.hideLoadingView(this.mRootView);
    }

    public void mp(String str) {
        this.mListView.setVisibility(8);
        this.bnc.showNetRefreshView(this.mRootView, str, true);
    }

    public void Un() {
        this.mListView.setVisibility(0);
        this.bnc.hideNetRefreshView(this.mRootView);
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
        this.dQY.notifyDataSetChanged();
    }

    public void aCJ() {
        this.bvC.Av();
    }

    public void aCK() {
        this.bvC.setText(this.bnc.getResources().getString(f.j.network_ungeilivable));
        this.bvC.Aw();
    }

    public void aCL() {
        this.bvC.setText(this.bnc.getResources().getString(f.j.list_no_more));
        this.bvC.Aw();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bnc.getPageContext(), i);
        this.bvC.dA(f.d.cp_bg_line_c);
        this.bvC.setTextColor(am.getColor(f.d.cp_cont_d));
        this.bvC.dB(i);
        this.cSv.onChangeSkinType(this.bnc.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.cSv.a(aVar);
        }
    }
}
