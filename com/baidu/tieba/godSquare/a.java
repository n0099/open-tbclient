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
    private BdTypeListView eko;
    private PbListView elw;
    private NoNetworkView fVd;
    private com.baidu.tieba.godSquare.a.a gVe;
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
        this.fVd = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.elw = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.elw.createView();
        this.elw.startLoadData();
        this.eko = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new h(this.mActivity.getPageContext());
        if (this.mActivity instanceof g.c) {
            this.mPullView.setListPullRefreshListener((g.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.eko.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.eko.setPullRefresh(this.mPullView);
        this.gVe = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.eko);
        this.eko.addAdapters(this.gVe.bcF());
        this.eko.setNextPage(this.elw);
    }

    public void showLoadingView() {
        this.eko.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.eko.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void AZ(String str) {
        this.eko.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void bcy() {
        this.eko.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cz(List<m> list) {
        if (list != null) {
            this.eko.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.eko;
    }

    public void notifyDataSetChanged() {
        this.gVe.notifyDataSetChanged();
    }

    public void bMB() {
        this.elw.startLoadData();
    }

    public void bMC() {
        this.elw.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.elw.endLoadData();
    }

    public void bMD() {
        this.elw.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.elw.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.elw.setTextColor(am.getColor(R.color.cp_cont_d));
        this.elw.changeSkin(i);
        this.fVd.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.eko.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fVd.a(aVar);
        }
    }
}
