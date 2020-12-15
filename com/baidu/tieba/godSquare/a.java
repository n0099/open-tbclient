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
    private BdTypeListView gpZ;
    private NoNetworkView gpw;
    private PbListView grg;
    private com.baidu.tieba.godSquare.a.a jHf;
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
        this.gpw = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.grg = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.grg.createView();
        this.grg.startLoadData();
        this.gpZ = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new g(this.mActivity.getPageContext());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.gpZ.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.gpZ.setPullRefresh(this.mPullView);
        this.jHf = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.gpZ);
        this.gpZ.addAdapters(this.jHf.bSo());
        this.gpZ.setNextPage(this.grg);
    }

    public void showLoadingView() {
        this.gpZ.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.gpZ.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void KC(String str) {
        this.gpZ.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void Yb() {
        this.gpZ.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void dH(List<q> list) {
        if (list != null) {
            this.gpZ.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.gpZ;
    }

    public void notifyDataSetChanged() {
        this.jHf.notifyDataSetChanged();
    }

    public void cMP() {
        this.grg.startLoadData();
    }

    public void cMQ() {
        this.grg.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.grg.endLoadData();
    }

    public void cMR() {
        this.grg.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.grg.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.grg.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.grg.changeSkin(i);
        this.gpw.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.gpZ.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.gpw.a(aVar);
        }
    }
}
