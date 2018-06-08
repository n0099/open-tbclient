package com.baidu.tieba.forumMember.member.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BaseActivity bkU;
    private NoNetworkView cRO;
    private View dfr;
    private a dfs;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private g mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.bkU = baseActivity;
        this.bkU.setContentView(d.i.forum_member_activity);
        this.mRootView = this.bkU.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bkU.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.bkU.getString(d.k.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bkU.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bkU.setNetRefreshViewTopMargin(BdListViewHelper.aVl);
        this.cRO = (NoNetworkView) this.bkU.findViewById(d.g.view_no_network);
        this.mListView = (BdTypeListView) this.bkU.findViewById(d.g.forum_member_listview);
        this.mPullView = new g(this.bkU.getPageContext());
        this.mPullView.setTag(this.bkU.getUniqueId());
        if (this.bkU instanceof f.b) {
            this.mPullView.a((f.b) this.bkU);
        }
        if (this.bkU instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bkU);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.dfr = BdListViewHelper.a(this.bkU.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dfs = new a(this.bkU, this.mListView);
        this.mListView.addAdapters(this.dfs.asu());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bkU.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bkU.hideLoadingView(this.mRootView);
    }

    public void mo(String str) {
        this.mListView.setVisibility(8);
        this.bkU.showNetRefreshView(this.mRootView, str, true);
    }

    public void TI() {
        this.mListView.setVisibility(0);
        this.bkU.hideNetRefreshView(this.mRootView);
    }

    public void bi(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.dfs.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.cRO.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bkU.getPageContext(), i);
        this.cRO.onChangeSkinType(this.bkU.getPageContext(), i);
        notifyDataSetChanged();
        al.j(this.mRootView, d.C0141d.cp_bg_line_c);
    }

    public void fq(boolean z) {
        BdListViewHelper.a(this.dfr, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.dfs.onDestroy();
    }
}
