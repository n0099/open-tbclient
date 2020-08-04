package com.baidu.tieba.godSquare;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes18.dex */
public class a {
    private NoNetworkView fqQ;
    private BdTypeListView frv;
    private PbListView fsC;
    private com.baidu.tieba.godSquare.a.a iqh;
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
        this.fqQ = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.fsC = new PbListView(this.mActivity.getPageContext().getPageActivity());
        this.fsC.createView();
        this.fsC.startLoadData();
        this.frv = (BdTypeListView) this.mActivity.findViewById(R.id.god_square_list_view);
        this.mPullView = new g(this.mActivity.getPageContext());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.frv.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.frv.setPullRefresh(this.mPullView);
        this.iqh = new com.baidu.tieba.godSquare.a.a(this.mActivity.getPageContext(), this.frv);
        this.frv.addAdapters(this.iqh.bxf());
        this.frv.setNextPage(this.fsC);
    }

    public void showLoadingView() {
        this.frv.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.frv.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void FJ(String str) {
        this.frv.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void bwX() {
        this.frv.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cX(List<q> list) {
        if (list != null) {
            this.frv.setData(list);
        }
    }

    public BdTypeListView getListView() {
        return this.frv;
    }

    public void notifyDataSetChanged() {
        this.iqh.notifyDataSetChanged();
    }

    public void ckS() {
        this.fsC.startLoadData();
    }

    public void ckT() {
        this.fsC.setText(this.mActivity.getResources().getString(R.string.network_ungeilivable));
        this.fsC.endLoadData();
    }

    public void ckU() {
        this.fsC.setText(this.mActivity.getResources().getString(R.string.list_no_more));
        this.fsC.endLoadData();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_d));
        this.fsC.changeSkin(i);
        this.fqQ.onChangeSkinType(this.mActivity.getPageContext(), i);
    }

    public void startPullRefresh() {
        this.frv.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fqQ.a(aVar);
        }
    }
}
