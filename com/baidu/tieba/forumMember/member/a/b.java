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
    private BaseActivity bwX;
    private NoNetworkView dgC;
    private View dxR;
    private a dxS;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.bwX = baseActivity;
        this.bwX.setContentView(e.h.forum_member_activity);
        this.mRootView = this.bwX.findViewById(e.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bwX.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.bwX.getString(e.j.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bwX.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bwX.setNetRefreshViewTopMargin(BdListViewHelper.bdY);
        this.dgC = (NoNetworkView) this.bwX.findViewById(e.g.view_no_network);
        this.mListView = (BdTypeListView) this.bwX.findViewById(e.g.forum_member_listview);
        this.mPullView = new k(this.bwX.getPageContext());
        this.mPullView.setTag(this.bwX.getUniqueId());
        if (this.bwX instanceof j.b) {
            this.mPullView.a((j.b) this.bwX);
        }
        if (this.bwX instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bwX);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.dxR = BdListViewHelper.a(this.bwX.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dxS = new a(this.bwX, this.mListView);
        this.mListView.addAdapters(this.dxS.ays());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bwX.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bwX.hideLoadingView(this.mRootView);
    }

    public void nt(String str) {
        this.mListView.setVisibility(8);
        this.bwX.showNetRefreshView(this.mRootView, str, true);
    }

    public void ZH() {
        this.mListView.setVisibility(0);
        this.bwX.hideNetRefreshView(this.mRootView);
    }

    public void bz(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.dxS.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dgC.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bwX.getPageContext(), i);
        this.dgC.onChangeSkinType(this.bwX.getPageContext(), i);
        notifyDataSetChanged();
        al.j(this.mRootView, e.d.cp_bg_line_c);
    }

    public void gb(boolean z) {
        BdListViewHelper.a(this.dxR, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.dxS.onDestroy();
    }
}
