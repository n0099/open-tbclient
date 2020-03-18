package com.baidu.tieba.forumMember.member.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    private BdTypeListView ekE;
    private NoNetworkView fVM;
    private a gmA;
    private View gmz;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private h mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
        this.mActivity.setContentView(R.layout.forum_member_activity);
        this.mRootView = this.mActivity.findViewById(R.id.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.mActivity.getString(R.string.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.mActivity.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mActivity.setNetRefreshViewTopMargin(BdListViewHelper.NET_RERESHNEW_TOP_MARGIN);
        this.fVM = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.ekE = (BdTypeListView) this.mActivity.findViewById(R.id.forum_member_listview);
        this.mPullView = new h(this.mActivity.getPageContext());
        this.mPullView.setTag(this.mActivity.getUniqueId());
        if (this.mActivity instanceof g.c) {
            this.mPullView.setListPullRefreshListener((g.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.ekE.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.ekE.setPullRefresh(this.mPullView);
        this.gmz = BdListViewHelper.a(this.mActivity.getPageContext().getPageActivity(), this.ekE, BdListViewHelper.HeadType.DEFAULT);
        this.gmA = new a(this.mActivity, this.ekE);
        this.ekE.addAdapters(this.gmA.bcJ());
    }

    public void showLoadingView() {
        this.ekE.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.ekE.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Ba(String str) {
        this.ekE.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void bcC() {
        this.ekE.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void ca(List<m> list) {
        if (list != null) {
            this.ekE.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.gmA.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.ekE.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.ekE.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fVM.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fVM.onChangeSkinType(this.mActivity.getPageContext(), i);
        notifyDataSetChanged();
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
    }

    public void ld(boolean z) {
        BdListViewHelper.a(this.gmz, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.gmA.onDestroy();
    }
}
