package com.baidu.tieba.forumMember.member.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    private NoNetworkView gvm;
    private BdTypeListView gwr;
    private View iXF;
    private a iXG;
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
        this.mActivity.setNetRefreshViewTopMargin(BdListViewHelper.fKs);
        this.gvm = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.gwr = (BdTypeListView) this.mActivity.findViewById(R.id.forum_member_listview);
        this.mPullView = new g(this.mActivity.getPageContext());
        this.mPullView.setTag(this.mActivity.getUniqueId());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.gwr.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.gwr.setPullRefresh(this.mPullView);
        this.iXF = BdListViewHelper.a(this.mActivity.getPageContext().getPageActivity(), this.gwr, BdListViewHelper.HeadType.DEFAULT);
        this.iXG = new a(this.mActivity, this.gwr);
        this.gwr.addAdapters(this.iXG.bQZ());
    }

    public void showLoadingView() {
        this.gwr.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.gwr.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Jo(String str) {
        this.gwr.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void Vq() {
        this.gwr.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void dk(List<n> list) {
        if (list != null) {
            this.gwr.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.iXG.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.gwr.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.gwr.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.gvm.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.gvm.onChangeSkinType(this.mActivity.getPageContext(), i);
        notifyDataSetChanged();
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0204);
    }

    public void qe(boolean z) {
        BdListViewHelper.a(this.iXF, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.iXG.onDestroy();
    }
}
