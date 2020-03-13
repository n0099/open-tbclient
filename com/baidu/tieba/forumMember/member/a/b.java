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
    private BdTypeListView eko;
    private NoNetworkView fVd;
    private View glR;
    private a glS;
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
        this.fVd = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.eko = (BdTypeListView) this.mActivity.findViewById(R.id.forum_member_listview);
        this.mPullView = new h(this.mActivity.getPageContext());
        this.mPullView.setTag(this.mActivity.getUniqueId());
        if (this.mActivity instanceof g.c) {
            this.mPullView.setListPullRefreshListener((g.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.eko.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.eko.setPullRefresh(this.mPullView);
        this.glR = BdListViewHelper.a(this.mActivity.getPageContext().getPageActivity(), this.eko, BdListViewHelper.HeadType.DEFAULT);
        this.glS = new a(this.mActivity, this.eko);
        this.eko.addAdapters(this.glS.bcF());
    }

    public void showLoadingView() {
        this.eko.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.eko.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void AZ(String str) {
        this.eko.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void bcy() {
        this.eko.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void ca(List<m> list) {
        if (list != null) {
            this.eko.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.glS.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.eko.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.eko.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fVd.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fVd.onChangeSkinType(this.mActivity.getPageContext(), i);
        notifyDataSetChanged();
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
    }

    public void kY(boolean z) {
        BdListViewHelper.a(this.glR, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.glS.onDestroy();
    }
}
