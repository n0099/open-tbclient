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
/* loaded from: classes23.dex */
public class a {
    private NoNetworkView fFC;
    private BdTypeListView fGf;
    private PbListView fHm;
    private com.baidu.tieba.godSquare.a.a iLM;
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
        this.fFC = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.fHm = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.fHm.createView();
        this.fHm.startLoadData();
        this.fGf = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new g(this.mActivity.getPageContext());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.fGf.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.fGf.setPullRefresh(this.mPullView);
        this.iLM = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.fGf);
        this.fGf.addAdapters(this.iLM.bHv());
        this.fGf.setNextPage(this.fHm);
    }

    public void showLoadingView() {
        this.fGf.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.fGf.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void II(String str) {
        this.fGf.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void bHn() {
        this.fGf.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void de(List<q> list) {
        if (list != null) {
            this.fGf.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.fGf;
    }

    public void notifyDataSetChanged() {
        this.iLM.notifyDataSetChanged();
    }

    public void cyQ() {
        this.fHm.startLoadData();
    }

    public void cyR() {
        this.fHm.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.fHm.endLoadData();
    }

    public void cyS() {
        this.fHm.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.fHm.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fHm.changeSkin(i);
        this.fFC.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.fGf.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fFC.a(aVar);
        }
    }
}
