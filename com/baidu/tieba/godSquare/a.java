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
    private BdTypeListView duK;
    private PbListView dvS;
    private NoNetworkView faF;
    private com.baidu.tieba.godSquare.a.a gbs;
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
        this.faF = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.dvS = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.dvS.createView();
        this.dvS.startLoadData();
        this.duK = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new i(this.mActivity.getPageContext());
        if (this.mActivity instanceof h.c) {
            this.mPullView.setListPullRefreshListener((h.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.duK.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.duK.setPullRefresh(this.mPullView);
        this.gbs = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.duK);
        this.duK.addAdapters(this.gbs.aJq());
        this.duK.setNextPage(this.dvS);
    }

    public void showLoadingView() {
        this.duK.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.duK.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void vG(String str) {
        this.duK.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void aJm() {
        this.duK.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cK(List<m> list) {
        if (list != null) {
            this.duK.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.duK;
    }

    public void notifyDataSetChanged() {
        this.gbs.notifyDataSetChanged();
    }

    public void bsw() {
        this.dvS.startLoadData();
    }

    public void bsx() {
        this.dvS.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.dvS.endLoadData();
    }

    public void bsy() {
        this.dvS.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.dvS.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.dvS.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dvS.changeSkin(i);
        this.faF.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.duK.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.faF.a(aVar);
        }
    }
}
