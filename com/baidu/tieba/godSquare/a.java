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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private BdTypeListView ekE;
    private PbListView elM;
    private NoNetworkView fVM;
    private com.baidu.tieba.godSquare.a.a gWl;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private h mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
        this.mActivity.setContentView(R.layout.god_square_activity);
        this.mRootView = this.mActivity.findViewById(R.id.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fVM = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.elM = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.elM.createView();
        this.elM.startLoadData();
        this.ekE = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new h(this.mActivity.getPageContext());
        if (this.mActivity instanceof g.c) {
            this.mPullView.setListPullRefreshListener((g.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.ekE.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.ekE.setPullRefresh(this.mPullView);
        this.gWl = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.ekE);
        this.ekE.addAdapters(this.gWl.bcJ());
        this.ekE.setNextPage(this.elM);
    }

    public void showLoadingView() {
        this.ekE.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.ekE.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Ba(String str) {
        this.ekE.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void bcC() {
        this.ekE.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cz(List<m> list) {
        if (list != null) {
            this.ekE.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.ekE;
    }

    public void notifyDataSetChanged() {
        this.gWl.notifyDataSetChanged();
    }

    public void bMP() {
        this.elM.startLoadData();
    }

    public void bMQ() {
        this.elM.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.elM.endLoadData();
    }

    public void bMR() {
        this.elM.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.elM.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.elM.setTextColor(am.getColor(R.color.cp_cont_d));
        this.elM.changeSkin(i);
        this.fVM.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.ekE.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fVM.a(aVar);
        }
    }
}
