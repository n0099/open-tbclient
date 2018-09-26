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
    private PbListView bBr;
    private BaseActivity bsQ;
    private NoNetworkView cYm;
    private com.baidu.tieba.godSquare.a.a dYq;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.bsQ = baseActivity;
        this.bsQ.setContentView(e.h.god_square_activity);
        this.mRootView = this.bsQ.findViewById(e.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bsQ.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cYm = (NoNetworkView) this.bsQ.findViewById(e.g.view_no_network);
        this.bBr = new PbListView(this.bsQ.getPageContext().getPageActivity());
        this.bBr.ov();
        this.bBr.BI();
        this.mListView = (BdTypeListView) this.bsQ.findViewById(e.g.god_square_list_view);
        this.mPullView = new k(this.bsQ.getPageContext());
        if (this.bsQ instanceof j.b) {
            this.mPullView.a((j.b) this.bsQ);
        }
        if (this.bsQ instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bsQ);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.dYq = new com.baidu.tieba.godSquare.a.a(this.bsQ.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.dYq.auW());
        this.mListView.setNextPage(this.bBr);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bsQ.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bsQ.hideLoadingView(this.mRootView);
    }

    public void mR(String str) {
        this.mListView.setVisibility(8);
        this.bsQ.showNetRefreshView(this.mRootView, str, true);
    }

    public void Wa() {
        this.mListView.setVisibility(0);
        this.bsQ.hideNetRefreshView(this.mRootView);
    }

    public void bO(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.mListView;
    }

    public void notifyDataSetChanged() {
        this.dYq.notifyDataSetChanged();
    }

    public void aEW() {
        this.bBr.BI();
    }

    public void aEX() {
        this.bBr.setText(this.bsQ.getResources().getString(e.j.network_ungeilivable));
        this.bBr.BJ();
    }

    public void aEY() {
        this.bBr.setText(this.bsQ.getResources().getString(e.j.list_no_more));
        this.bBr.BJ();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bsQ.getPageContext(), i);
        this.bBr.dL(e.d.cp_bg_line_c);
        this.bBr.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bBr.dM(i);
        this.cYm.onChangeSkinType(this.bsQ.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.cYm.a(aVar);
        }
    }
}
