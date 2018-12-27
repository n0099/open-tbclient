package com.baidu.tieba.forumMember.member.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BaseActivity bBi;
    private View dIw;
    private a dIx;
    private NoNetworkView drf;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.bBi = baseActivity;
        this.bBi.setContentView(e.h.forum_member_activity);
        this.mRootView = this.bBi.findViewById(e.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bBi.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.bBi.getString(e.j.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bBi.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bBi.setNetRefreshViewTopMargin(BdListViewHelper.bir);
        this.drf = (NoNetworkView) this.bBi.findViewById(e.g.view_no_network);
        this.mListView = (BdTypeListView) this.bBi.findViewById(e.g.forum_member_listview);
        this.mPullView = new k(this.bBi.getPageContext());
        this.mPullView.setTag(this.bBi.getUniqueId());
        if (this.bBi instanceof j.b) {
            this.mPullView.a((j.b) this.bBi);
        }
        if (this.bBi instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bBi);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.dIw = BdListViewHelper.a(this.bBi.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dIx = new a(this.bBi, this.mListView);
        this.mListView.addAdapters(this.dIx.aAp());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bBi.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bBi.hideLoadingView(this.mRootView);
    }

    public void nW(String str) {
        this.mListView.setVisibility(8);
        this.bBi.showNetRefreshView(this.mRootView, str, true);
    }

    public void aba() {
        this.mListView.setVisibility(0);
        this.bBi.hideNetRefreshView(this.mRootView);
    }

    public void bA(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.dIx.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.drf.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bBi.getPageContext(), i);
        this.drf.onChangeSkinType(this.bBi.getPageContext(), i);
        notifyDataSetChanged();
        al.j(this.mRootView, e.d.cp_bg_line_c);
    }

    public void go(boolean z) {
        BdListViewHelper.a(this.dIw, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.dIx.onDestroy();
    }
}
