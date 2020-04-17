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
    private BdTypeListView eOe;
    private PbListView ePm;
    private NoNetworkView gAG;
    private com.baidu.tieba.godSquare.a.a hGc;
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
        this.gAG = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.ePm = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.ePm.createView();
        this.ePm.startLoadData();
        this.eOe = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new h(this.mActivity.getPageContext());
        if (this.mActivity instanceof g.c) {
            this.mPullView.setListPullRefreshListener((g.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.eOe.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.eOe.setPullRefresh(this.mPullView);
        this.hGc = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.eOe);
        this.eOe.addAdapters(this.hGc.blA());
        this.eOe.setNextPage(this.ePm);
    }

    public void showLoadingView() {
        this.eOe.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.eOe.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void CL(String str) {
        this.eOe.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void blt() {
        this.eOe.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cK(List<m> list) {
        if (list != null) {
            this.eOe.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.eOe;
    }

    public void notifyDataSetChanged() {
        this.hGc.notifyDataSetChanged();
    }

    public void bXq() {
        this.ePm.startLoadData();
    }

    public void bXr() {
        this.ePm.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.ePm.endLoadData();
    }

    public void bXs() {
        this.ePm.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.ePm.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_d));
        this.ePm.changeSkin(i);
        this.gAG.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.eOe.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.gAG.a(aVar);
        }
    }
}
