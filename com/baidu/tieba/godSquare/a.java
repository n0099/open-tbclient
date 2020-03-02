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
    private BdTypeListView ekb;
    private PbListView elj;
    private NoNetworkView fUQ;
    private com.baidu.tieba.godSquare.a.a gUS;
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
        this.fUQ = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.elj = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.elj.createView();
        this.elj.startLoadData();
        this.ekb = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new h(this.mActivity.getPageContext());
        if (this.mActivity instanceof g.c) {
            this.mPullView.setListPullRefreshListener((g.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.ekb.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.ekb.setPullRefresh(this.mPullView);
        this.gUS = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.ekb);
        this.ekb.addAdapters(this.gUS.bcE());
        this.ekb.setNextPage(this.elj);
    }

    public void showLoadingView() {
        this.ekb.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.ekb.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void AY(String str) {
        this.ekb.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void bcx() {
        this.ekb.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cz(List<m> list) {
        if (list != null) {
            this.ekb.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.ekb;
    }

    public void notifyDataSetChanged() {
        this.gUS.notifyDataSetChanged();
    }

    public void bMA() {
        this.elj.startLoadData();
    }

    public void bMB() {
        this.elj.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.elj.endLoadData();
    }

    public void bMC() {
        this.elj.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.elj.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.elj.setTextColor(am.getColor(R.color.cp_cont_d));
        this.elj.changeSkin(i);
        this.fUQ.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.ekb.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fUQ.a(aVar);
        }
    }
}
