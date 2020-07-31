package com.baidu.tieba.forumMember.member.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes17.dex */
public class b {
    private NoNetworkView fqQ;
    private BdTypeListView frv;
    private View hCD;
    private a hCE;
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
        this.mActivity.setNetRefreshViewTopMargin(BdListViewHelper.eKp);
        this.fqQ = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.frv = (BdTypeListView) this.mActivity.findViewById(R.id.forum_member_listview);
        this.mPullView = new g(this.mActivity.getPageContext());
        this.mPullView.setTag(this.mActivity.getUniqueId());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.frv.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.frv.setPullRefresh(this.mPullView);
        this.hCD = BdListViewHelper.a(this.mActivity.getPageContext().getPageActivity(), this.frv, BdListViewHelper.HeadType.DEFAULT);
        this.hCE = new a(this.mActivity, this.frv);
        this.frv.addAdapters(this.hCE.bxf());
    }

    public void showLoadingView() {
        this.frv.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.frv.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void FJ(String str) {
        this.frv.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void bwX() {
        this.frv.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cx(List<q> list) {
        if (list != null) {
            this.frv.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.hCE.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.frv.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.frv.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fqQ.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fqQ.onChangeSkinType(this.mActivity.getPageContext(), i);
        notifyDataSetChanged();
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
    }

    public void nt(boolean z) {
        BdListViewHelper.a(this.hCD, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.hCE.onDestroy();
    }
}
