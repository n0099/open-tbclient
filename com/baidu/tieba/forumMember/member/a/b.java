package com.baidu.tieba.forumMember.member.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    private BdTypeListView faQ;
    private NoNetworkView fan;
    private View hkx;
    private a hky;
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
        this.mActivity.setNetRefreshViewTopMargin(BdListViewHelper.euP);
        this.fan = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.faQ = (BdTypeListView) this.mActivity.findViewById(R.id.forum_member_listview);
        this.mPullView = new g(this.mActivity.getPageContext());
        this.mPullView.setTag(this.mActivity.getUniqueId());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.faQ.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.faQ.setPullRefresh(this.mPullView);
        this.hkx = BdListViewHelper.a(this.mActivity.getPageContext().getPageActivity(), this.faQ, BdListViewHelper.HeadType.DEFAULT);
        this.hky = new a(this.mActivity, this.faQ);
        this.faQ.addAdapters(this.hky.bqW());
    }

    public void showLoadingView() {
        this.faQ.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.faQ.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Ex(String str) {
        this.faQ.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void bqO() {
        this.faQ.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cj(List<o> list) {
        if (list != null) {
            this.faQ.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.hky.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.faQ.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.faQ.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fan.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fan.onChangeSkinType(this.mActivity.getPageContext(), i);
        notifyDataSetChanged();
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
    }

    public void mD(boolean z) {
        BdListViewHelper.a(this.hkx, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.hky.onDestroy();
    }
}
