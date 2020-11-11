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
    private NoNetworkView ghD;
    private BdTypeListView gih;
    private PbListView gjo;
    private com.baidu.tieba.godSquare.a.a jsW;
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
        this.ghD = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.gjo = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.gjo.createView();
        this.gjo.startLoadData();
        this.gih = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new g(this.mActivity.getPageContext());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.gih.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.gih.setPullRefresh(this.mPullView);
        this.jsW = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.gih);
        this.gih.addAdapters(this.jsW.bPj());
        this.gih.setNextPage(this.gjo);
    }

    public void showLoadingView() {
        this.gih.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.gih.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Kl(String str) {
        this.gih.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void Wk() {
        this.gih.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void dy(List<q> list) {
        if (list != null) {
            this.gih.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.gih;
    }

    public void notifyDataSetChanged() {
        this.jsW.notifyDataSetChanged();
    }

    public void cHV() {
        this.gjo.startLoadData();
    }

    public void cHW() {
        this.gjo.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.gjo.endLoadData();
    }

    public void cHX() {
        this.gjo.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.gjo.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.gjo.changeSkin(i);
        this.ghD.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.gih.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.ghD.a(aVar);
        }
    }
}
