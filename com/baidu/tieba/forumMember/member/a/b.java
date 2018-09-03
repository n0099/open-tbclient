package com.baidu.tieba.forumMember.member.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BaseActivity bnc;
    private NoNetworkView cSv;
    private View djW;
    private a djX;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private h mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.bnc = baseActivity;
        this.bnc.setContentView(f.h.forum_member_activity);
        this.mRootView = this.bnc.findViewById(f.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bnc.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.bnc.getString(f.j.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bnc.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bnc.setNetRefreshViewTopMargin(BdListViewHelper.aWi);
        this.cSv = (NoNetworkView) this.bnc.findViewById(f.g.view_no_network);
        this.mListView = (BdTypeListView) this.bnc.findViewById(f.g.forum_member_listview);
        this.mPullView = new h(this.bnc.getPageContext());
        this.mPullView.setTag(this.bnc.getUniqueId());
        if (this.bnc instanceof g.b) {
            this.mPullView.a((g.b) this.bnc);
        }
        if (this.bnc instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bnc);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.djW = BdListViewHelper.a(this.bnc.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.djX = new a(this.bnc, this.mListView);
        this.mListView.addAdapters(this.djX.ati());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bnc.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bnc.hideLoadingView(this.mRootView);
    }

    public void mp(String str) {
        this.mListView.setVisibility(8);
        this.bnc.showNetRefreshView(this.mRootView, str, true);
    }

    public void Un() {
        this.mListView.setVisibility(0);
        this.bnc.hideNetRefreshView(this.mRootView);
    }

    public void bi(List<com.baidu.adp.widget.ListView.h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.djX.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.cSv.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bnc.getPageContext(), i);
        this.cSv.onChangeSkinType(this.bnc.getPageContext(), i);
        notifyDataSetChanged();
        am.j(this.mRootView, f.d.cp_bg_line_c);
    }

    public void fs(boolean z) {
        BdListViewHelper.a(this.djW, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.djX.onDestroy();
    }
}
