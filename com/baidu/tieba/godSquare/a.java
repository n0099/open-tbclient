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
    private BaseActivity bBf;
    private PbListView bOy;
    private NoNetworkView dop;
    private com.baidu.tieba.godSquare.a.a eoy;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.bBf = baseActivity;
        this.bBf.setContentView(e.h.god_square_activity);
        this.mRootView = this.bBf.findViewById(e.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bBf.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dop = (NoNetworkView) this.bBf.findViewById(e.g.view_no_network);
        this.bOy = new PbListView(this.bBf.getPageContext().getPageActivity());
        this.bOy.oD();
        this.bOy.Fc();
        this.mListView = (BdTypeListView) this.bBf.findViewById(e.g.god_square_list_view);
        this.mPullView = new k(this.bBf.getPageContext());
        if (this.bBf instanceof j.b) {
            this.mPullView.a((j.b) this.bBf);
        }
        if (this.bBf instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bBf);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.eoy = new com.baidu.tieba.godSquare.a.a(this.bBf.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.eoy.azA());
        this.mListView.setNextPage(this.bOy);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bBf.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bBf.hideLoadingView(this.mRootView);
    }

    public void nT(String str) {
        this.mListView.setVisibility(8);
        this.bBf.showNetRefreshView(this.mRootView, str, true);
    }

    public void aaY() {
        this.mListView.setVisibility(0);
        this.bBf.hideNetRefreshView(this.mRootView);
    }

    public void cg(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.mListView;
    }

    public void notifyDataSetChanged() {
        this.eoy.notifyDataSetChanged();
    }

    public void aJD() {
        this.bOy.Fc();
    }

    public void aJE() {
        this.bOy.setText(this.bBf.getResources().getString(e.j.network_ungeilivable));
        this.bOy.Fd();
    }

    public void aJF() {
        this.bOy.setText(this.bBf.getResources().getString(e.j.list_no_more));
        this.bOy.Fd();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bBf.getPageContext(), i);
        this.bOy.ex(e.d.cp_bg_line_c);
        this.bOy.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bOy.ey(i);
        this.dop.onChangeSkinType(this.bBf.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dop.a(aVar);
        }
    }
}
