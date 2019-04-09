package com.baidu.tieba.forumMember.member.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    private BaseActivity cNd;
    private NoNetworkView eCf;
    private View eWj;
    private a eWk;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private i mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.cNd = baseActivity;
        this.cNd.setContentView(d.h.forum_member_activity);
        this.mRootView = this.cNd.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.cNd.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.cNd.getString(d.j.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cNd.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cNd.setNetRefreshViewTopMargin(BdListViewHelper.csY);
        this.eCf = (NoNetworkView) this.cNd.findViewById(d.g.view_no_network);
        this.mListView = (BdTypeListView) this.cNd.findViewById(d.g.forum_member_listview);
        this.mPullView = new i(this.cNd.getPageContext());
        this.mPullView.setTag(this.cNd.getUniqueId());
        if (this.cNd instanceof h.c) {
            this.mPullView.setListPullRefreshListener((h.c) this.cNd);
        }
        if (this.cNd instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.cNd);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.eWj = BdListViewHelper.a(this.cNd.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.eWk = new a(this.cNd, this.mListView);
        this.mListView.addAdapters(this.eWk.aBv());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.cNd.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.cNd.hideLoadingView(this.mRootView);
    }

    public void uQ(String str) {
        this.mListView.setVisibility(8);
        this.cNd.showNetRefreshView(this.mRootView, str, true);
    }

    public void aBq() {
        this.mListView.setVisibility(0);
        this.cNd.hideNetRefreshView(this.mRootView);
    }

    public void bM(List<m> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.eWk.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.eCf.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cNd.getPageContext(), i);
        this.eCf.onChangeSkinType(this.cNd.getPageContext(), i);
        notifyDataSetChanged();
        al.l(this.mRootView, d.C0277d.cp_bg_line_c);
    }

    public void iO(boolean z) {
        BdListViewHelper.a(this.eWj, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.eWk.onDestroy();
    }
}
