package com.baidu.tieba.forumMember.member.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    private NoNetworkView gyk;
    private BdTypeListView gzp;
    private View jdA;
    private a jdB;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private g mPullView;
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
        this.mActivity.setNetRefreshViewTopMargin(BdListViewHelper.fMD);
        this.gyk = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.gzp = (BdTypeListView) this.mActivity.findViewById(R.id.forum_member_listview);
        this.mPullView = new g(this.mActivity.getPageContext());
        this.mPullView.setTag(this.mActivity.getUniqueId());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.gzp.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.gzp.setPullRefresh(this.mPullView);
        this.jdA = BdListViewHelper.a(this.mActivity.getPageContext().getPageActivity(), this.gzp, BdListViewHelper.HeadType.DEFAULT);
        this.jdB = new a(this.mActivity, this.gzp);
        this.gzp.addAdapters(this.jdB.bRK());
    }

    public void showLoadingView() {
        this.gzp.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.gzp.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Ka(String str) {
        this.gzp.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void WZ() {
        this.gzp.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void df(List<n> list) {
        if (list != null) {
            this.gzp.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.jdB.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.gzp.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.gzp.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.gyk.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.gyk.onChangeSkinType(this.mActivity.getPageContext(), i);
        notifyDataSetChanged();
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0204);
    }

    public void qo(boolean z) {
        BdListViewHelper.a(this.jdA, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.jdB.onDestroy();
    }
}
