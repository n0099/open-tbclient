package com.baidu.tieba.forumMember.member.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes23.dex */
public class b {
    private BdTypeListView gpZ;
    private NoNetworkView gpw;
    private View iQa;
    private a iQb;
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
        this.mActivity.setNetRefreshViewTopMargin(BdListViewHelper.fFw);
        this.gpw = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.gpZ = (BdTypeListView) this.mActivity.findViewById(R.id.forum_member_listview);
        this.mPullView = new g(this.mActivity.getPageContext());
        this.mPullView.setTag(this.mActivity.getUniqueId());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.gpZ.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.gpZ.setPullRefresh(this.mPullView);
        this.iQa = BdListViewHelper.a(this.mActivity.getPageContext().getPageActivity(), this.gpZ, BdListViewHelper.HeadType.DEFAULT);
        this.iQb = new a(this.mActivity, this.gpZ);
        this.gpZ.addAdapters(this.iQb.bSo());
    }

    public void showLoadingView() {
        this.gpZ.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.gpZ.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void KC(String str) {
        this.gpZ.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void Yb() {
        this.gpZ.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void dd(List<q> list) {
        if (list != null) {
            this.gpZ.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.iQb.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.gpZ.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.gpZ.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.gpw.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.gpw.onChangeSkinType(this.mActivity.getPageContext(), i);
        notifyDataSetChanged();
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0204);
    }

    public void pL(boolean z) {
        BdListViewHelper.a(this.iQa, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.iQb.onDestroy();
    }
}
