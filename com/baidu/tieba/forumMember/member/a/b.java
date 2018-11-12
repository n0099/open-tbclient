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
    private BaseActivity bxI;
    private NoNetworkView dhH;
    private View dzj;
    private a dzk;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.bxI = baseActivity;
        this.bxI.setContentView(e.h.forum_member_activity);
        this.mRootView = this.bxI.findViewById(e.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bxI.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.bxI.getString(e.j.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bxI.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bxI.setNetRefreshViewTopMargin(BdListViewHelper.beN);
        this.dhH = (NoNetworkView) this.bxI.findViewById(e.g.view_no_network);
        this.mListView = (BdTypeListView) this.bxI.findViewById(e.g.forum_member_listview);
        this.mPullView = new k(this.bxI.getPageContext());
        this.mPullView.setTag(this.bxI.getUniqueId());
        if (this.bxI instanceof j.b) {
            this.mPullView.a((j.b) this.bxI);
        }
        if (this.bxI instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bxI);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.dzj = BdListViewHelper.a(this.bxI.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dzk = new a(this.bxI, this.mListView);
        this.mListView.addAdapters(this.dzk.axQ());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bxI.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bxI.hideLoadingView(this.mRootView);
    }

    public void nu(String str) {
        this.mListView.setVisibility(8);
        this.bxI.showNetRefreshView(this.mRootView, str, true);
    }

    public void ZS() {
        this.mListView.setVisibility(0);
        this.bxI.hideNetRefreshView(this.mRootView);
    }

    public void bx(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.dzk.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dhH.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bxI.getPageContext(), i);
        this.dhH.onChangeSkinType(this.bxI.getPageContext(), i);
        notifyDataSetChanged();
        al.j(this.mRootView, e.d.cp_bg_line_c);
    }

    public void gl(boolean z) {
        BdListViewHelper.a(this.dzj, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.dzk.onDestroy();
    }
}
