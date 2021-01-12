package com.baidu.tieba.godSquare;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private NoNetworkView gvm;
    private BdTypeListView gwr;
    private PbListView gxy;
    private com.baidu.tieba.godSquare.adapter.a jPS;
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
        this.gvm = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.gxy = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.gxy.createView();
        this.gxy.startLoadData();
        this.gwr = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new g(this.mActivity.getPageContext());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.gwr.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.gwr.setPullRefresh(this.mPullView);
        this.jPS = new com.baidu.tieba.godSquare.adapter.a(this.mActivity.getPageContext(), this.gwr);
        this.gwr.addAdapters(this.jPS.bQZ());
        this.gwr.setNextPage(this.gxy);
    }

    public void showLoadingView() {
        this.gwr.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.gwr.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Jo(String str) {
        this.gwr.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void Vq() {
        this.gwr.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void dP(List<n> list) {
        if (list != null) {
            this.gwr.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.gwr;
    }

    public void notifyDataSetChanged() {
        this.jPS.notifyDataSetChanged();
    }

    public void cMl() {
        this.gxy.startLoadData();
    }

    public void cMm() {
        this.gxy.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.gxy.endLoadData();
    }

    public void cMn() {
        this.gxy.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.gxy.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.gxy.changeSkin(i);
        this.gvm.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.gwr.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.gvm.a(aVar);
        }
    }
}
