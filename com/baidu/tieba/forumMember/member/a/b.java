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
/* loaded from: classes7.dex */
public class b {
    private BdTypeListView gAY;
    private NoNetworkView gzT;
    private View jfj;
    private a jfk;
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
        this.mActivity.setNetRefreshViewTopMargin(BdListViewHelper.fOd);
        this.gzT = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.gAY = (BdTypeListView) this.mActivity.findViewById(R.id.forum_member_listview);
        this.mPullView = new g(this.mActivity.getPageContext());
        this.mPullView.setTag(this.mActivity.getUniqueId());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.gAY.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.gAY.setPullRefresh(this.mPullView);
        this.jfj = BdListViewHelper.a(this.mActivity.getPageContext().getPageActivity(), this.gAY, BdListViewHelper.HeadType.DEFAULT);
        this.jfk = new a(this.mActivity, this.gAY);
        this.gAY.addAdapters(this.jfk.bRQ());
    }

    public void showLoadingView() {
        this.gAY.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.gAY.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Kj(String str) {
        this.gAY.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void Xc() {
        this.gAY.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void df(List<n> list) {
        if (list != null) {
            this.gAY.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.jfk.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.gAY.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.gAY.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.gzT.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.gzT.onChangeSkinType(this.mActivity.getPageContext(), i);
        notifyDataSetChanged();
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0204);
    }

    public void qo(boolean z) {
        BdListViewHelper.a(this.jfj, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.jfk.onDestroy();
    }
}
