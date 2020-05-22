package com.baidu.tieba.godSquare;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private BdTypeListView faQ;
    private NoNetworkView fan;
    private PbListView fbY;
    private com.baidu.tieba.godSquare.a.a hUU;
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
        this.fan = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.fbY = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.fbY.createView();
        this.fbY.startLoadData();
        this.faQ = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new g(this.mActivity.getPageContext());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.faQ.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.faQ.setPullRefresh(this.mPullView);
        this.hUU = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.faQ);
        this.faQ.addAdapters(this.hUU.bqW());
        this.faQ.setNextPage(this.fbY);
    }

    public void showLoadingView() {
        this.faQ.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.faQ.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Ex(String str) {
        this.faQ.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void bqO() {
        this.faQ.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cH(List<o> list) {
        if (list != null) {
            this.faQ.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.faQ;
    }

    public void notifyDataSetChanged() {
        this.hUU.notifyDataSetChanged();
    }

    public void cdN() {
        this.fbY.startLoadData();
    }

    public void cdO() {
        this.fbY.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.fbY.endLoadData();
    }

    public void cdP() {
        this.fbY.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.fbY.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_d));
        this.fbY.changeSkin(i);
        this.fan.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.faQ.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fan.a(aVar);
        }
    }
}
