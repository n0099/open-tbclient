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
/* loaded from: classes9.dex */
public class a {
    private BdTypeListView efW;
    private PbListView ehe;
    private NoNetworkView fSu;
    private com.baidu.tieba.godSquare.a.a gSQ;
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
        this.fSu = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.ehe = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.ehe.createView();
        this.ehe.startLoadData();
        this.efW = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new h(this.mActivity.getPageContext());
        if (this.mActivity instanceof g.c) {
            this.mPullView.setListPullRefreshListener((g.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.efW.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.efW.setPullRefresh(this.mPullView);
        this.gSQ = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.efW);
        this.efW.addAdapters(this.gSQ.ban());
        this.efW.setNextPage(this.ehe);
    }

    public void showLoadingView() {
        this.efW.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.efW.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void AI(String str) {
        this.efW.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void baf() {
        this.efW.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cD(List<m> list) {
        if (list != null) {
            this.efW.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.efW;
    }

    public void notifyDataSetChanged() {
        this.gSQ.notifyDataSetChanged();
    }

    public void bKW() {
        this.ehe.startLoadData();
    }

    public void bKX() {
        this.ehe.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.ehe.endLoadData();
    }

    public void bKY() {
        this.ehe.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.ehe.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.ehe.setTextColor(am.getColor(R.color.cp_cont_d));
        this.ehe.changeSkin(i);
        this.fSu.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.efW.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fSu.a(aVar);
        }
    }
}
