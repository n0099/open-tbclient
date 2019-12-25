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
/* loaded from: classes8.dex */
public class a {
    private BdTypeListView efM;
    private PbListView egU;
    private NoNetworkView fPl;
    private com.baidu.tieba.godSquare.a.a gPw;
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
        this.fPl = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.egU = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.egU.createView();
        this.egU.startLoadData();
        this.efM = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new h(this.mActivity.getPageContext());
        if (this.mActivity instanceof g.c) {
            this.mPullView.setListPullRefreshListener((g.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.efM.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.efM.setPullRefresh(this.mPullView);
        this.gPw = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.efM);
        this.efM.addAdapters(this.gPw.aZO());
        this.efM.setNextPage(this.egU);
    }

    public void showLoadingView() {
        this.efM.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.efM.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Ay(String str) {
        this.efM.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void aZK() {
        this.efM.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cD(List<m> list) {
        if (list != null) {
            this.efM.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.efM;
    }

    public void notifyDataSetChanged() {
        this.gPw.notifyDataSetChanged();
    }

    public void bJR() {
        this.egU.startLoadData();
    }

    public void bJS() {
        this.egU.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.egU.endLoadData();
    }

    public void bJT() {
        this.egU.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.egU.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.egU.setTextColor(am.getColor(R.color.cp_cont_d));
        this.egU.changeSkin(i);
        this.fPl.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.efM.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fPl.a(aVar);
        }
    }
}
