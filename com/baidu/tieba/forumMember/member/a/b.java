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
/* loaded from: classes22.dex */
public class b {
    private NoNetworkView fFC;
    private BdTypeListView fGf;
    private View hWY;
    private a hWZ;
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
        this.mActivity.setNetRefreshViewTopMargin(BdListViewHelper.eXP);
        this.fFC = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.fGf = (BdTypeListView) this.mActivity.findViewById(R.id.forum_member_listview);
        this.mPullView = new g(this.mActivity.getPageContext());
        this.mPullView.setTag(this.mActivity.getUniqueId());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.fGf.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.fGf.setPullRefresh(this.mPullView);
        this.hWY = BdListViewHelper.a(this.mActivity.getPageContext().getPageActivity(), this.fGf, BdListViewHelper.HeadType.DEFAULT);
        this.hWZ = new a(this.mActivity, this.fGf);
        this.fGf.addAdapters(this.hWZ.bHv());
    }

    public void showLoadingView() {
        this.fGf.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.fGf.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void II(String str) {
        this.fGf.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void bHn() {
        this.fGf.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cF(List<q> list) {
        if (list != null) {
            this.fGf.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.hWZ.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.fGf.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.fGf.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fFC.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fFC.onChangeSkinType(this.mActivity.getPageContext(), i);
        notifyDataSetChanged();
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
    }

    public void of(boolean z) {
        BdListViewHelper.a(this.hWY, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.hWZ.onDestroy();
    }
}
