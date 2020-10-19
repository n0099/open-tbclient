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
    private NoNetworkView fRL;
    private BdTypeListView fSo;
    private PbListView fTv;
    private com.baidu.tieba.godSquare.a.a jaE;
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
        this.fRL = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.fTv = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.fTv.createView();
        this.fTv.startLoadData();
        this.fSo = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new g(this.mActivity.getPageContext());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.fSo.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.fSo.setPullRefresh(this.mPullView);
        this.jaE = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.fSo);
        this.fSo.addAdapters(this.jaE.bKh());
        this.fSo.setNextPage(this.fTv);
    }

    public void showLoadingView() {
        this.fSo.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.fSo.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Jv(String str) {
        this.fSo.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void SK() {
        this.fSo.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void dh(List<q> list) {
        if (list != null) {
            this.fSo.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.fSo;
    }

    public void notifyDataSetChanged() {
        this.jaE.notifyDataSetChanged();
    }

    public void cCn() {
        this.fTv.startLoadData();
    }

    public void cCo() {
        this.fTv.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.fTv.endLoadData();
    }

    public void cCp() {
        this.fTv.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.fTv.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fTv.changeSkin(i);
        this.fRL.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.fSo.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fRL.a(aVar);
        }
    }
}
