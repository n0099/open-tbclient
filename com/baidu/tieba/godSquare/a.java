package com.baidu.tieba.godSquare;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private BdTypeListView gAY;
    private PbListView gCf;
    private NoNetworkView gzT;
    private com.baidu.tieba.godSquare.adapter.a jZK;
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
        this.gzT = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.gCf = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.gCf.createView();
        this.gCf.startLoadData();
        this.gAY = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new g(this.mActivity.getPageContext());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.gAY.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.gAY.setPullRefresh(this.mPullView);
        this.jZK = new com.baidu.tieba.godSquare.adapter.a(this.mActivity.getPageContext(), this.gAY);
        this.gAY.addAdapters(this.jZK.bRQ());
        this.gAY.setNextPage(this.gCf);
    }

    public void showLoadingView() {
        this.gAY.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.gAY.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Kj(String str) {
        this.gAY.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void Xc() {
        this.gAY.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void dM(List<n> list) {
        if (list != null) {
            this.gAY.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.gAY;
    }

    public void notifyDataSetChanged() {
        this.jZK.notifyDataSetChanged();
    }

    public void cOw() {
        this.gCf.startLoadData();
    }

    public void cOx() {
        this.gCf.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.gCf.endLoadData();
    }

    public void cOy() {
        this.gCf.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.gCf.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gCf.changeSkin(i);
        this.gzT.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.gAY.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.gzT.a(aVar);
        }
    }
}
