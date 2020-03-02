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
    private BdTypeListView ekb;
    private NoNetworkView fUQ;
    private View glE;
    private a glF;
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
        this.fUQ = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.ekb = (BdTypeListView) this.mActivity.findViewById(R.id.forum_member_listview);
        this.mPullView = new h(this.mActivity.getPageContext());
        this.mPullView.setTag(this.mActivity.getUniqueId());
        if (this.mActivity instanceof g.c) {
            this.mPullView.setListPullRefreshListener((g.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.ekb.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.ekb.setPullRefresh(this.mPullView);
        this.glE = BdListViewHelper.a(this.mActivity.getPageContext().getPageActivity(), this.ekb, BdListViewHelper.HeadType.DEFAULT);
        this.glF = new a(this.mActivity, this.ekb);
        this.ekb.addAdapters(this.glF.bcE());
    }

    public void showLoadingView() {
        this.ekb.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.ekb.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void AY(String str) {
        this.ekb.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void bcx() {
        this.ekb.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void ca(List<m> list) {
        if (list != null) {
            this.ekb.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.glF.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.ekb.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.ekb.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fUQ.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fUQ.onChangeSkinType(this.mActivity.getPageContext(), i);
        notifyDataSetChanged();
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
    }

    public void kY(boolean z) {
        BdListViewHelper.a(this.glE, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.glF.onDestroy();
    }
}
