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
    private BaseActivity cXM;
    private PbListView dpz;
    private NoNetworkView eYL;
    private com.baidu.tieba.godSquare.a.a gcL;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private i mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.cXM = baseActivity;
        this.cXM.setContentView(R.layout.god_square_activity);
        this.mRootView = this.cXM.findViewById(R.id.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.cXM.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eYL = (NoNetworkView) this.cXM.findViewById(R.id.view_no_network);
        this.dpz = new PbListView(this.cXM.getPageContext().getPageActivity());
        this.dpz.nZ();
        this.dpz.akR();
        this.mListView = (BdTypeListView) this.cXM.findViewById(R.id.god_square_list_view);
        this.mPullView = new i(this.cXM.getPageContext());
        if (this.cXM instanceof h.c) {
            this.mPullView.setListPullRefreshListener((h.c) this.cXM);
        }
        if (this.cXM instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.cXM);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.gcL = new com.baidu.tieba.godSquare.a.a(this.cXM.getPageContext(), this.mListView);
        this.mListView.addAdapters(this.gcL.aJS());
        this.mListView.setNextPage(this.dpz);
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.cXM.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.cXM.hideLoadingView(this.mRootView);
    }

    public void xo(String str) {
        this.mListView.setVisibility(8);
        this.cXM.showNetRefreshView(this.mRootView, str, true);
    }

    public void aJN() {
        this.mListView.setVisibility(0);
        this.cXM.hideNetRefreshView(this.mRootView);
    }

    public void cx(List<m> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.mListView;
    }

    public void notifyDataSetChanged() {
        this.gcL.notifyDataSetChanged();
    }

    public void bvt() {
        this.dpz.akR();
    }

    public void bvu() {
        this.dpz.setText(this.cXM.getResources().getString(R.string.network_ungeilivable));
        this.dpz.akS();
    }

    public void bvv() {
        this.dpz.setText(this.cXM.getResources().getString(R.string.list_no_more));
        this.dpz.akS();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cXM.getPageContext(), i);
        this.dpz.iX(R.color.cp_bg_line_c);
        this.dpz.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dpz.iY(i);
        this.eYL.onChangeSkinType(this.cXM.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.eYL.a(aVar);
        }
    }
}
