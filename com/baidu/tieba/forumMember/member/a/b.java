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
/* loaded from: classes7.dex */
public class b {
    private BdTypeListView efM;
    private NoNetworkView fPl;
    private View ggr;
    private a ggs;
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
        this.fPl = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.efM = (BdTypeListView) this.mActivity.findViewById(R.id.forum_member_listview);
        this.mPullView = new h(this.mActivity.getPageContext());
        this.mPullView.setTag(this.mActivity.getUniqueId());
        if (this.mActivity instanceof g.c) {
            this.mPullView.setListPullRefreshListener((g.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.efM.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.efM.setPullRefresh(this.mPullView);
        this.ggr = BdListViewHelper.a(this.mActivity.getPageContext().getPageActivity(), this.efM, BdListViewHelper.HeadType.DEFAULT);
        this.ggs = new a(this.mActivity, this.efM);
        this.efM.addAdapters(this.ggs.aZO());
    }

    public void showLoadingView() {
        this.efM.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.efM.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Ay(String str) {
        this.efM.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void aZK() {
        this.efM.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void ce(List<m> list) {
        if (list != null) {
            this.efM.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.ggs.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.efM.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.efM.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fPl.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fPl.onChangeSkinType(this.mActivity.getPageContext(), i);
        notifyDataSetChanged();
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
    }

    public void kJ(boolean z) {
        BdListViewHelper.a(this.ggr, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.ggs.onDestroy();
    }
}
