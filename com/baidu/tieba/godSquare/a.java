package com.baidu.tieba.godSquare;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes23.dex */
public class a {
    private BdTypeListView ghN;
    private NoNetworkView ghk;
    private PbListView giV;
    private com.baidu.tieba.godSquare.a.a jtD;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private g mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
        this.mActivity.setContentView(R.layout.god_square_activity);
        this.mRootView = this.mActivity.findViewById(R.id.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ghk = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.giV = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.giV.createView();
        this.giV.startLoadData();
        this.ghN = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new g(this.mActivity.getPageContext());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.ghN.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.ghN.setPullRefresh(this.mPullView);
        this.jtD = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.ghN);
        this.ghN.addAdapters(this.jtD.bOC());
        this.ghN.setNextPage(this.giV);
    }

    public void showLoadingView() {
        this.ghN.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.ghN.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void JM(String str) {
        this.ghN.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void VB() {
        this.ghN.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void dy(List<q> list) {
        if (list != null) {
            this.ghN.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.ghN;
    }

    public void notifyDataSetChanged() {
        this.jtD.notifyDataSetChanged();
    }

    public void cHA() {
        this.giV.startLoadData();
    }

    public void cHB() {
        this.giV.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.giV.endLoadData();
    }

    public void cHC() {
        this.giV.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.giV.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.giV.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.giV.changeSkin(i);
        this.ghk.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.ghN.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.ghk.a(aVar);
        }
    }
}
