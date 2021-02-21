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
/* loaded from: classes8.dex */
public class a {
    private PbListView gAw;
    private NoNetworkView gyk;
    private BdTypeListView gzp;
    private com.baidu.tieba.godSquare.adapter.a jXI;
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
        this.gyk = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.gAw = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.gAw.createView();
        this.gAw.startLoadData();
        this.gzp = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new g(this.mActivity.getPageContext());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.gzp.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.gzp.setPullRefresh(this.mPullView);
        this.jXI = new com.baidu.tieba.godSquare.adapter.a(this.mActivity.getPageContext(), this.gzp);
        this.gzp.addAdapters(this.jXI.bRK());
        this.gzp.setNextPage(this.gAw);
    }

    public void showLoadingView() {
        this.gzp.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.gzp.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Ka(String str) {
        this.gzp.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void WZ() {
        this.gzp.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void dM(List<n> list) {
        if (list != null) {
            this.gzp.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.gzp;
    }

    public void notifyDataSetChanged() {
        this.jXI.notifyDataSetChanged();
    }

    public void cOp() {
        this.gAw.startLoadData();
    }

    public void cOq() {
        this.gAw.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.gAw.endLoadData();
    }

    public void cOr() {
        this.gAw.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.gAw.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gAw.changeSkin(i);
        this.gyk.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.gzp.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.gyk.a(aVar);
        }
    }
}
