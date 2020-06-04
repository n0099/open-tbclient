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
    private NoNetworkView fay;
    private BdTypeListView fbb;
    private PbListView fcj;
    private com.baidu.tieba.godSquare.a.a hVH;
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
        this.fay = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.fcj = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.fcj.createView();
        this.fcj.startLoadData();
        this.fbb = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new g(this.mActivity.getPageContext());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.fbb.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.fbb.setPullRefresh(this.mPullView);
        this.hVH = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.fbb);
        this.fbb.addAdapters(this.hVH.bqY());
        this.fbb.setNextPage(this.fcj);
    }

    public void showLoadingView() {
        this.fbb.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.fbb.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Ex(String str) {
        this.fbb.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void bqQ() {
        this.fbb.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cI(List<o> list) {
        if (list != null) {
            this.fbb.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.fbb;
    }

    public void notifyDataSetChanged() {
        this.hVH.notifyDataSetChanged();
    }

    public void cdV() {
        this.fcj.startLoadData();
    }

    public void cdW() {
        this.fcj.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.fcj.endLoadData();
    }

    public void cdX() {
        this.fcj.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.fcj.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.fcj.setTextColor(am.getColor(R.color.cp_cont_d));
        this.fcj.changeSkin(i);
        this.fay.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.fbb.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fay.a(aVar);
        }
    }
}
