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
    private BaseActivity bBV;
    private View dJf;
    private a dJg;
    private NoNetworkView drO;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.bBV = baseActivity;
        this.bBV.setContentView(e.h.forum_member_activity);
        this.mRootView = this.bBV.findViewById(e.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bBV.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.bBV.getString(e.j.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bBV.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bBV.setNetRefreshViewTopMargin(BdListViewHelper.bja);
        this.drO = (NoNetworkView) this.bBV.findViewById(e.g.view_no_network);
        this.mListView = (BdTypeListView) this.bBV.findViewById(e.g.forum_member_listview);
        this.mPullView = new k(this.bBV.getPageContext());
        this.mPullView.setTag(this.bBV.getUniqueId());
        if (this.bBV instanceof j.b) {
            this.mPullView.a((j.b) this.bBV);
        }
        if (this.bBV instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bBV);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.dJf = BdListViewHelper.a(this.bBV.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dJg = new a(this.bBV, this.mListView);
        this.mListView.addAdapters(this.dJg.aAM());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bBV.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bBV.hideLoadingView(this.mRootView);
    }

    public void oo(String str) {
        this.mListView.setVisibility(8);
        this.bBV.showNetRefreshView(this.mRootView, str, true);
    }

    public void abx() {
        this.mListView.setVisibility(0);
        this.bBV.hideNetRefreshView(this.mRootView);
    }

    public void bB(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.dJg.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.drO.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bBV.getPageContext(), i);
        this.drO.onChangeSkinType(this.bBV.getPageContext(), i);
        notifyDataSetChanged();
        al.j(this.mRootView, e.d.cp_bg_line_c);
    }

    public void gr(boolean z) {
        BdListViewHelper.a(this.dJf, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.dJg.onDestroy();
    }
}
