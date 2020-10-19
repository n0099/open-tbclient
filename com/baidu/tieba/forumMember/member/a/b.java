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
    private NoNetworkView fRL;
    private BdTypeListView fSo;
    private View ilX;
    private a ilY;
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
        this.mActivity.setNetRefreshViewTopMargin(BdListViewHelper.fkb);
        this.fRL = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.fSo = (BdTypeListView) this.mActivity.findViewById(R.id.forum_member_listview);
        this.mPullView = new g(this.mActivity.getPageContext());
        this.mPullView.setTag(this.mActivity.getUniqueId());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.fSo.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.fSo.setPullRefresh(this.mPullView);
        this.ilX = BdListViewHelper.a(this.mActivity.getPageContext().getPageActivity(), this.fSo, BdListViewHelper.HeadType.DEFAULT);
        this.ilY = new a(this.mActivity, this.fSo);
        this.fSo.addAdapters(this.ilY.bKh());
    }

    public void showLoadingView() {
        this.fSo.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.fSo.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Jv(String str) {
        this.fSo.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void SK() {
        this.fSo.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cI(List<q> list) {
        if (list != null) {
            this.fSo.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.ilY.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.fSo.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.fSo.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fRL.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fRL.onChangeSkinType(this.mActivity.getPageContext(), i);
        notifyDataSetChanged();
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
    }

    public void oK(boolean z) {
        BdListViewHelper.a(this.ilX, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.ilY.onDestroy();
    }
}
