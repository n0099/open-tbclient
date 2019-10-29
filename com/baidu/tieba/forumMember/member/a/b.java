package com.baidu.tieba.forumMember.member.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    private BdTypeListView dvB;
    private NoNetworkView fbw;
    private View fsM;
    private a fsN;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private i mPullView;
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
        this.fbw = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.dvB = (BdTypeListView) this.mActivity.findViewById(R.id.forum_member_listview);
        this.mPullView = new i(this.mActivity.getPageContext());
        this.mPullView.setTag(this.mActivity.getUniqueId());
        if (this.mActivity instanceof h.c) {
            this.mPullView.setListPullRefreshListener((h.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.dvB.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.dvB.setPullRefresh(this.mPullView);
        this.fsM = BdListViewHelper.a(this.mActivity.getPageContext().getPageActivity(), this.dvB, BdListViewHelper.HeadType.DEFAULT);
        this.fsN = new a(this.mActivity, this.dvB);
        this.dvB.addAdapters(this.fsN.aJs());
    }

    public void showLoadingView() {
        this.dvB.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.dvB.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void vG(String str) {
        this.dvB.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void aJo() {
        this.dvB.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void ci(List<m> list) {
        if (list != null) {
            this.dvB.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.fsN.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.dvB.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.dvB.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fbw.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fbw.onChangeSkinType(this.mActivity.getPageContext(), i);
        notifyDataSetChanged();
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
    }

    public void jx(boolean z) {
        BdListViewHelper.a(this.fsM, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.fsN.onDestroy();
    }
}
