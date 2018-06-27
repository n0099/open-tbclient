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
    private BaseActivity bmt;
    private PbListView buU;
    private NoNetworkView cPM;
    private com.baidu.tieba.godSquare.a.a dOq;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private h mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.bmt = baseActivity;
        this.bmt.setContentView(d.i.god_square_activity);
        this.mRootView = this.bmt.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bmt.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.k.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cPM = (NoNetworkView) this.bmt.findViewById(d.g.view_no_network);
        this.buU = new PbListView(this.bmt.getPageContext().getPageActivity());
        this.buU.nn();
        this.buU.AH();
        this.mListView = (BdTypeListView) this.bmt.findViewById(d.g.god_square_list_view);
        this.mPullView = new h(this.bmt.getPageContext());
        if (this.bmt instanceof g.b) {
            this.mPullView.a((g.b) this.bmt);
        }
        if (this.bmt instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bmt);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.dOq = new com.baidu.tieba.godSquare.a.a(this.bmt.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.dOq.asF());
        this.mListView.setNextPage(this.buU);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bmt.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bmt.hideLoadingView(this.mRootView);
    }

    public void mo(String str) {
        this.mListView.setVisibility(8);
        this.bmt.showNetRefreshView(this.mRootView, str, true);
    }

    public void Uc() {
        this.mListView.setVisibility(0);
        this.bmt.hideNetRefreshView(this.mRootView);
    }

    public void bO(List<com.baidu.adp.widget.ListView.h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.mListView;
    }

    public void notifyDataSetChanged() {
        this.dOq.notifyDataSetChanged();
    }

    public void aCd() {
        this.buU.AH();
    }

    public void aCe() {
        this.buU.setText(this.bmt.getResources().getString(d.k.network_ungeilivable));
        this.buU.AI();
    }

    public void aCf() {
        this.buU.setText(this.bmt.getResources().getString(d.k.list_no_more));
        this.buU.AI();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bmt.getPageContext(), i);
        this.buU.dy(d.C0142d.cp_bg_line_c);
        this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_d));
        this.buU.dz(i);
        this.cPM.onChangeSkinType(this.bmt.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.cPM.a(aVar);
        }
    }
}
