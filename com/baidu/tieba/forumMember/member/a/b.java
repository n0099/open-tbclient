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
    private BaseActivity bBW;
    private View dJg;
    private a dJh;
    private NoNetworkView drP;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.bBW = baseActivity;
        this.bBW.setContentView(e.h.forum_member_activity);
        this.mRootView = this.bBW.findViewById(e.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bBW.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.bBW.getString(e.j.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bBW.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bBW.setNetRefreshViewTopMargin(BdListViewHelper.bjb);
        this.drP = (NoNetworkView) this.bBW.findViewById(e.g.view_no_network);
        this.mListView = (BdTypeListView) this.bBW.findViewById(e.g.forum_member_listview);
        this.mPullView = new k(this.bBW.getPageContext());
        this.mPullView.setTag(this.bBW.getUniqueId());
        if (this.bBW instanceof j.b) {
            this.mPullView.a((j.b) this.bBW);
        }
        if (this.bBW instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bBW);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.dJg = BdListViewHelper.a(this.bBW.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dJh = new a(this.bBW, this.mListView);
        this.mListView.addAdapters(this.dJh.aAM());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bBW.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bBW.hideLoadingView(this.mRootView);
    }

    public void oo(String str) {
        this.mListView.setVisibility(8);
        this.bBW.showNetRefreshView(this.mRootView, str, true);
    }

    public void abx() {
        this.mListView.setVisibility(0);
        this.bBW.hideNetRefreshView(this.mRootView);
    }

    public void bB(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.dJh.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.drP.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bBW.getPageContext(), i);
        this.drP.onChangeSkinType(this.bBW.getPageContext(), i);
        notifyDataSetChanged();
        al.j(this.mRootView, e.d.cp_bg_line_c);
    }

    public void gr(boolean z) {
        BdListViewHelper.a(this.dJg, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.dJh.onDestroy();
    }
}
