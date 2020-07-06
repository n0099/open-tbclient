package com.baidu.tieba.godSquare;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private NoNetworkView flI;
    private BdTypeListView fml;
    private PbListView fnt;
    private com.baidu.tieba.godSquare.a.a ikc;
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
        this.flI = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.fnt = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.fnt.createView();
        this.fnt.startLoadData();
        this.fml = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new g(this.mActivity.getPageContext());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.fml.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.fml.setPullRefresh(this.mPullView);
        this.ikc = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.fml);
        this.fml.addAdapters(this.ikc.btW());
        this.fml.setNextPage(this.fnt);
    }

    public void showLoadingView() {
        this.fml.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.fml.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void EY(String str) {
        this.fml.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void btO() {
        this.fml.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cS(List<q> list) {
        if (list != null) {
            this.fml.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.fml;
    }

    public void notifyDataSetChanged() {
        this.ikc.notifyDataSetChanged();
    }

    public void cht() {
        this.fnt.startLoadData();
    }

    public void chu() {
        this.fnt.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.fnt.endLoadData();
    }

    public void chv() {
        this.fnt.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.fnt.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_d));
        this.fnt.changeSkin(i);
        this.flI.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.fml.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.flI.a(aVar);
        }
    }
}
