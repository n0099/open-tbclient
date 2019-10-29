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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private BdTypeListView dvB;
    private PbListView dwJ;
    private NoNetworkView fbw;
    private com.baidu.tieba.godSquare.a.a gcj;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private i mPullView;
    private View mRootView;

    public a(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
        this.mActivity.setContentView(R.layout.god_square_activity);
        this.mRootView = this.mActivity.findViewById(R.id.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(R.string.god_square);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fbw = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.dwJ = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.dwJ.createView();
        this.dwJ.startLoadData();
        this.dvB = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new i(this.mActivity.getPageContext());
        if (this.mActivity instanceof h.c) {
            this.mPullView.setListPullRefreshListener((h.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.dvB.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.dvB.setPullRefresh(this.mPullView);
        this.gcj = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.dvB);
        this.dvB.addAdapters(this.gcj.aJs());
        this.dvB.setNextPage(this.dwJ);
    }

    public void showLoadingView() {
        this.dvB.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.dvB.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void vG(String str) {
        this.dvB.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void aJo() {
        this.dvB.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cK(List<m> list) {
        if (list != null) {
            this.dvB.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.dvB;
    }

    public void notifyDataSetChanged() {
        this.gcj.notifyDataSetChanged();
    }

    public void bsy() {
        this.dwJ.startLoadData();
    }

    public void bsz() {
        this.dwJ.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.dwJ.endLoadData();
    }

    public void bsA() {
        this.dwJ.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.dwJ.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.dwJ.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dwJ.changeSkin(i);
        this.fbw.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.dvB.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fbw.a(aVar);
        }
    }
}
