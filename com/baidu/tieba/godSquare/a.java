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
    private BaseActivity bBV;
    private PbListView bPm;
    private NoNetworkView drO;
    private com.baidu.tieba.godSquare.a.a erV;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.bBV = baseActivity;
        this.bBV.setContentView(e.h.god_square_activity);
        this.mRootView = this.bBV.findViewById(e.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bBV.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(e.j.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.drO = (NoNetworkView) this.bBV.findViewById(e.g.view_no_network);
        this.bPm = new PbListView(this.bBV.getPageContext().getPageActivity());
        this.bPm.oH();
        this.bPm.Fp();
        this.mListView = (BdTypeListView) this.bBV.findViewById(e.g.god_square_list_view);
        this.mPullView = new k(this.bBV.getPageContext());
        if (this.bBV instanceof j.b) {
            this.mPullView.a((j.b) this.bBV);
        }
        if (this.bBV instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bBV);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.erV = new com.baidu.tieba.godSquare.a.a(this.bBV.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.erV.aAM());
        this.mListView.setNextPage(this.bPm);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bBV.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bBV.hideLoadingView(this.mRootView);
    }

    public void oo(String str) {
        this.mListView.setVisibility(8);
        this.bBV.showNetRefreshView(this.mRootView, str, true);
    }

    public void abx() {
        this.mListView.setVisibility(0);
        this.bBV.hideNetRefreshView(this.mRootView);
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
        this.erV.notifyDataSetChanged();
    }

    public void aKQ() {
        this.bPm.Fp();
    }

    public void aKR() {
        this.bPm.setText(this.bBV.getResources().getString(e.j.network_ungeilivable));
        this.bPm.Fq();
    }

    public void aKS() {
        this.bPm.setText(this.bBV.getResources().getString(e.j.list_no_more));
        this.bPm.Fq();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bBV.getPageContext(), i);
        this.bPm.ex(e.d.cp_bg_line_c);
        this.bPm.setTextColor(al.getColor(e.d.cp_cont_d));
        this.bPm.ey(i);
        this.drO.onChangeSkinType(this.bBV.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.drO.a(aVar);
        }
    }
}
