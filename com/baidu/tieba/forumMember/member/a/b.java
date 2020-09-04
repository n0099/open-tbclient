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
/* loaded from: classes17.dex */
public class b {
    private BdTypeListView fCT;
    private NoNetworkView fCq;
    private View hPY;
    private a hPZ;
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
        this.mActivity.setNetRefreshViewTopMargin(BdListViewHelper.eUY);
        this.fCq = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.fCT = (BdTypeListView) this.mActivity.findViewById(R.id.forum_member_listview);
        this.mPullView = new g(this.mActivity.getPageContext());
        this.mPullView.setTag(this.mActivity.getUniqueId());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.fCT.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.fCT.setPullRefresh(this.mPullView);
        this.hPY = BdListViewHelper.a(this.mActivity.getPageContext().getPageActivity(), this.fCT, BdListViewHelper.HeadType.DEFAULT);
        this.hPZ = new a(this.mActivity, this.fCT);
        this.fCT.addAdapters(this.hPZ.bGf());
    }

    public void showLoadingView() {
        this.fCT.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.fCT.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Il(String str) {
        this.fCT.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void bFX() {
        this.fCT.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cz(List<q> list) {
        if (list != null) {
            this.fCT.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.hPZ.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.fCT.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.fCT.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fCq.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fCq.onChangeSkinType(this.mActivity.getPageContext(), i);
        notifyDataSetChanged();
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
    }

    public void nZ(boolean z) {
        BdListViewHelper.a(this.hPY, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.hPZ.onDestroy();
    }
}
