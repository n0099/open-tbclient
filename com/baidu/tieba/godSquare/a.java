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
/* loaded from: classes18.dex */
public class a {
    private BdTypeListView fCP;
    private NoNetworkView fCm;
    private PbListView fDW;
    private com.baidu.tieba.godSquare.a.a iEl;
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
        this.fCm = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.fDW = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.fDW.createView();
        this.fDW.startLoadData();
        this.fCP = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new g(this.mActivity.getPageContext());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.fCP.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.fCP.setPullRefresh(this.mPullView);
        this.iEl = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.fCP);
        this.fCP.addAdapters(this.iEl.bGe());
        this.fCP.setNextPage(this.fDW);
    }

    public void showLoadingView() {
        this.fCP.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.fCP.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Ik(String str) {
        this.fCP.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void bFW() {
        this.fCP.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cY(List<q> list) {
        if (list != null) {
            this.fCP.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.fCP;
    }

    public void notifyDataSetChanged() {
        this.iEl.notifyDataSetChanged();
    }

    public void cvw() {
        this.fDW.startLoadData();
    }

    public void cvx() {
        this.fDW.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.fDW.endLoadData();
    }

    public void cvy() {
        this.fDW.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.fDW.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.fDW.changeSkin(i);
        this.fCm.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.fCP.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fCm.a(aVar);
        }
    }
}
