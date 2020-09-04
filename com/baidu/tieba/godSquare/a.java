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
/* loaded from: classes18.dex */
public class a {
    private BdTypeListView fCT;
    private NoNetworkView fCq;
    private PbListView fEa;
    private com.baidu.tieba.godSquare.a.a iEr;
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
        this.fCq = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.fEa = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.fEa.createView();
        this.fEa.startLoadData();
        this.fCT = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new g(this.mActivity.getPageContext());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.fCT.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.fCT.setPullRefresh(this.mPullView);
        this.iEr = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.fCT);
        this.fCT.addAdapters(this.iEr.bGf());
        this.fCT.setNextPage(this.fEa);
    }

    public void showLoadingView() {
        this.fCT.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.fCT.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Il(String str) {
        this.fCT.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void bFX() {
        this.fCT.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cY(List<q> list) {
        if (list != null) {
            this.fCT.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.fCT;
    }

    public void notifyDataSetChanged() {
        this.iEr.notifyDataSetChanged();
    }

    public void cvx() {
        this.fEa.startLoadData();
    }

    public void cvy() {
        this.fEa.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.fEa.endLoadData();
    }

    public void cvz() {
        this.fEa.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.fEa.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fEa.changeSkin(i);
        this.fCq.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.fCT.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fCq.a(aVar);
        }
    }
}
