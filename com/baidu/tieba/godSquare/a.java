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
    private BdTypeListView eka;
    private PbListView eli;
    private NoNetworkView fUO;
    private com.baidu.tieba.godSquare.a.a gUQ;
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
        this.fUO = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.eli = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.eli.createView();
        this.eli.startLoadData();
        this.eka = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new h(this.mActivity.getPageContext());
        if (this.mActivity instanceof g.c) {
            this.mPullView.setListPullRefreshListener((g.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.eka.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.eka.setPullRefresh(this.mPullView);
        this.gUQ = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.eka);
        this.eka.addAdapters(this.gUQ.bcC());
        this.eka.setNextPage(this.eli);
    }

    public void showLoadingView() {
        this.eka.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.eka.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void AY(String str) {
        this.eka.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void bcv() {
        this.eka.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cz(List<m> list) {
        if (list != null) {
            this.eka.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.eka;
    }

    public void notifyDataSetChanged() {
        this.gUQ.notifyDataSetChanged();
    }

    public void bMy() {
        this.eli.startLoadData();
    }

    public void bMz() {
        this.eli.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.eli.endLoadData();
    }

    public void bMA() {
        this.eli.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.eli.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.eli.setTextColor(am.getColor(R.color.cp_cont_d));
        this.eli.changeSkin(i);
        this.fUO.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.eka.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fUO.a(aVar);
        }
    }
}
