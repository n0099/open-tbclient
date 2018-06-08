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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private BaseActivity bkU;
    private PbListView btv;
    private NoNetworkView cRO;
    private com.baidu.tieba.godSquare.a.a dKZ;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private g mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.bkU = baseActivity;
        this.bkU.setContentView(d.i.god_square_activity);
        this.mRootView = this.bkU.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bkU.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(d.k.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cRO = (NoNetworkView) this.bkU.findViewById(d.g.view_no_network);
        this.btv = new PbListView(this.bkU.getPageContext().getPageActivity());
        this.btv.nn();
        this.btv.Ar();
        this.mListView = (BdTypeListView) this.bkU.findViewById(d.g.god_square_list_view);
        this.mPullView = new g(this.bkU.getPageContext());
        if (this.bkU instanceof f.b) {
            this.mPullView.a((f.b) this.bkU);
        }
        if (this.bkU instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bkU);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.dKZ = new com.baidu.tieba.godSquare.a.a(this.bkU.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.dKZ.asu());
        this.mListView.setNextPage(this.btv);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bkU.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bkU.hideLoadingView(this.mRootView);
    }

    public void mo(String str) {
        this.mListView.setVisibility(8);
        this.bkU.showNetRefreshView(this.mRootView, str, true);
    }

    public void TI() {
        this.mListView.setVisibility(0);
        this.bkU.hideNetRefreshView(this.mRootView);
    }

    public void bK(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.mListView;
    }

    public void notifyDataSetChanged() {
        this.dKZ.notifyDataSetChanged();
    }

    public void aBx() {
        this.btv.Ar();
    }

    public void aBy() {
        this.btv.setText(this.bkU.getResources().getString(d.k.network_ungeilivable));
        this.btv.As();
    }

    public void aBz() {
        this.btv.setText(this.bkU.getResources().getString(d.k.list_no_more));
        this.btv.As();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bkU.getPageContext(), i);
        this.btv.dx(d.C0141d.cp_bg_line_c);
        this.btv.setTextColor(al.getColor(d.C0141d.cp_cont_d));
        this.btv.dy(i);
        this.cRO.onChangeSkinType(this.bkU.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.cRO.a(aVar);
        }
    }
}
