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
/* loaded from: classes8.dex */
public class b {
    private BdTypeListView efW;
    private NoNetworkView fSu;
    private View gjB;
    private a gjC;
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
        this.fSu = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.efW = (BdTypeListView) this.mActivity.findViewById(R.id.forum_member_listview);
        this.mPullView = new h(this.mActivity.getPageContext());
        this.mPullView.setTag(this.mActivity.getUniqueId());
        if (this.mActivity instanceof g.c) {
            this.mPullView.setListPullRefreshListener((g.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.efW.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.efW.setPullRefresh(this.mPullView);
        this.gjB = BdListViewHelper.a(this.mActivity.getPageContext().getPageActivity(), this.efW, BdListViewHelper.HeadType.DEFAULT);
        this.gjC = new a(this.mActivity, this.efW);
        this.efW.addAdapters(this.gjC.ban());
    }

    public void showLoadingView() {
        this.efW.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.efW.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void AI(String str) {
        this.efW.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void baf() {
        this.efW.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void ce(List<m> list) {
        if (list != null) {
            this.efW.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.gjC.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.efW.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.efW.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fSu.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fSu.onChangeSkinType(this.mActivity.getPageContext(), i);
        notifyDataSetChanged();
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
    }

    public void kU(boolean z) {
        BdListViewHelper.a(this.gjB, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.gjC.onDestroy();
    }
}
