package com.baidu.tieba.godSquare;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private BaseActivity cWM;
    private PbListView dnG;
    private NoNetworkView eWV;
    private com.baidu.tieba.godSquare.a.a gae;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private i mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.cWM = baseActivity;
        this.cWM.setContentView(R.layout.god_square_activity);
        this.mRootView = this.cWM.findViewById(R.id.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.cWM.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eWV = (NoNetworkView) this.cWM.findViewById(R.id.view_no_network);
        this.dnG = new PbListView(this.cWM.getPageContext().getPageActivity());
        this.dnG.nZ();
        this.dnG.akD();
        this.mListView = (BdTypeListView) this.cWM.findViewById(R.id.god_square_list_view);
        this.mPullView = new i(this.cWM.getPageContext());
        if (this.cWM instanceof h.c) {
            this.mPullView.setListPullRefreshListener((h.c) this.cWM);
        }
        if (this.cWM instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.cWM);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.gae = new com.baidu.tieba.godSquare.a.a(this.cWM.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.gae.aJm());
        this.mListView.setNextPage(this.dnG);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.cWM.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.cWM.hideLoadingView(this.mRootView);
    }

    public void wO(String str) {
        this.mListView.setVisibility(8);
        this.cWM.showNetRefreshView(this.mRootView, str, true);
    }

    public void aJh() {
        this.mListView.setVisibility(0);
        this.cWM.hideNetRefreshView(this.mRootView);
    }

    public void cy(List<m> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.mListView;
    }

    public void notifyDataSetChanged() {
        this.gae.notifyDataSetChanged();
    }

    public void bus() {
        this.dnG.akD();
    }

    public void but() {
        this.dnG.setText(this.cWM.getResources().getString(R.string.network_ungeilivable));
        this.dnG.akE();
    }

    public void buu() {
        this.dnG.setText(this.cWM.getResources().getString(R.string.list_no_more));
        this.dnG.akE();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cWM.getPageContext(), i);
        this.dnG.iU(R.color.cp_bg_line_c);
        this.dnG.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dnG.iV(i);
        this.eWV.onChangeSkinType(this.cWM.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.eWV.a(aVar);
        }
    }
}
