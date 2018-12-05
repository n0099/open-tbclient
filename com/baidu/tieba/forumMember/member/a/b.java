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
    private BaseActivity bBf;
    private View dFI;
    private a dFJ;
    private NoNetworkView dop;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.bBf = baseActivity;
        this.bBf.setContentView(e.h.forum_member_activity);
        this.mRootView = this.bBf.findViewById(e.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bBf.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.bBf.getString(e.j.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bBf.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bBf.setNetRefreshViewTopMargin(BdListViewHelper.bio);
        this.dop = (NoNetworkView) this.bBf.findViewById(e.g.view_no_network);
        this.mListView = (BdTypeListView) this.bBf.findViewById(e.g.forum_member_listview);
        this.mPullView = new k(this.bBf.getPageContext());
        this.mPullView.setTag(this.bBf.getUniqueId());
        if (this.bBf instanceof j.b) {
            this.mPullView.a((j.b) this.bBf);
        }
        if (this.bBf instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bBf);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.dFI = BdListViewHelper.a(this.bBf.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dFJ = new a(this.bBf, this.mListView);
        this.mListView.addAdapters(this.dFJ.azA());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bBf.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bBf.hideLoadingView(this.mRootView);
    }

    public void nT(String str) {
        this.mListView.setVisibility(8);
        this.bBf.showNetRefreshView(this.mRootView, str, true);
    }

    public void aaY() {
        this.mListView.setVisibility(0);
        this.bBf.hideNetRefreshView(this.mRootView);
    }

    public void bz(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.dFJ.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dop.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bBf.getPageContext(), i);
        this.dop.onChangeSkinType(this.bBf.getPageContext(), i);
        notifyDataSetChanged();
        al.j(this.mRootView, e.d.cp_bg_line_c);
    }

    public void gm(boolean z) {
        BdListViewHelper.a(this.dFI, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.dFJ.onDestroy();
    }
}
