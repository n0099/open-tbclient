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
    private NoNetworkView gbO;
    private BdTypeListView gcr;
    private PbListView gdy;
    private com.baidu.tieba.godSquare.a.a jmZ;
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
        this.gbO = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.gdy = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.gdy.createView();
        this.gdy.startLoadData();
        this.gcr = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new g(this.mActivity.getPageContext());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.gcr.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.gcr.setPullRefresh(this.mPullView);
        this.jmZ = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.gcr);
        this.gcr.addAdapters(this.jmZ.bMJ());
        this.gcr.setNextPage(this.gdy);
    }

    public void showLoadingView() {
        this.gcr.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.gcr.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void JU(String str) {
        this.gcr.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void TK() {
        this.gcr.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void dq(List<q> list) {
        if (list != null) {
            this.gcr.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.gcr;
    }

    public void notifyDataSetChanged() {
        this.jmZ.notifyDataSetChanged();
    }

    public void cFu() {
        this.gdy.startLoadData();
    }

    public void cFv() {
        this.gdy.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.gdy.endLoadData();
    }

    public void cFw() {
        this.gdy.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.gdy.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.gdy.changeSkin(i);
        this.gbO.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.gcr.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.gbO.a(aVar);
        }
    }
}
