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
    private PbListView gAi;
    private NoNetworkView gxW;
    private BdTypeListView gzb;
    private com.baidu.tieba.godSquare.adapter.a jXu;
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
        this.gxW = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.gAi = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.gAi.createView();
        this.gAi.startLoadData();
        this.gzb = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new g(this.mActivity.getPageContext());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.gzb.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.gzb.setPullRefresh(this.mPullView);
        this.jXu = new com.baidu.tieba.godSquare.adapter.a(this.mActivity.getPageContext(), this.gzb);
        this.gzb.addAdapters(this.jXu.bRD());
        this.gzb.setNextPage(this.gAi);
    }

    public void showLoadingView() {
        this.gzb.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.gzb.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void JZ(String str) {
        this.gzb.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void WZ() {
        this.gzb.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void dM(List<n> list) {
        if (list != null) {
            this.gzb.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.gzb;
    }

    public void notifyDataSetChanged() {
        this.jXu.notifyDataSetChanged();
    }

    public void cOi() {
        this.gAi.startLoadData();
    }

    public void cOj() {
        this.gAi.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.gAi.endLoadData();
    }

    public void cOk() {
        this.gAi.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.gAi.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0204);
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.gAi.changeSkin(i);
        this.gxW.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.gzb.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.gxW.a(aVar);
        }
    }
}
