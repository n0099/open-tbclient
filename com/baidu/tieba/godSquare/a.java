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
/* loaded from: classes24.dex */
public class a {
    private BdTypeListView gpX;
    private NoNetworkView gpu;
    private PbListView gre;
    private com.baidu.tieba.godSquare.a.a jHd;
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
        this.gpu = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.gre = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.gre.createView();
        this.gre.startLoadData();
        this.gpX = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new g(this.mActivity.getPageContext());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.gpX.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.gpX.setPullRefresh(this.mPullView);
        this.jHd = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.gpX);
        this.gpX.addAdapters(this.jHd.bSn());
        this.gpX.setNextPage(this.gre);
    }

    public void showLoadingView() {
        this.gpX.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.gpX.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void KC(String str) {
        this.gpX.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void Yb() {
        this.gpX.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void dH(List<q> list) {
        if (list != null) {
            this.gpX.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.gpX;
    }

    public void notifyDataSetChanged() {
        this.jHd.notifyDataSetChanged();
    }

    public void cMO() {
        this.gre.startLoadData();
    }

    public void cMP() {
        this.gre.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.gre.endLoadData();
    }

    public void cMQ() {
        this.gre.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.gre.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.gre.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gre.changeSkin(i);
        this.gpu.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.gpX.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.gpu.a(aVar);
        }
    }
}
