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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BaseActivity bmt;
    private NoNetworkView cPM;
    private View dhi;
    private a dhj;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private h mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.bmt = baseActivity;
        this.bmt.setContentView(d.i.forum_member_activity);
        this.mRootView = this.bmt.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bmt.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.bmt.getString(d.k.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bmt.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bmt.setNetRefreshViewTopMargin(BdListViewHelper.aWg);
        this.cPM = (NoNetworkView) this.bmt.findViewById(d.g.view_no_network);
        this.mListView = (BdTypeListView) this.bmt.findViewById(d.g.forum_member_listview);
        this.mPullView = new h(this.bmt.getPageContext());
        this.mPullView.setTag(this.bmt.getUniqueId());
        if (this.bmt instanceof g.b) {
            this.mPullView.a((g.b) this.bmt);
        }
        if (this.bmt instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bmt);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.dhi = BdListViewHelper.a(this.bmt.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dhj = new a(this.bmt, this.mListView);
        this.mListView.addAdapters(this.dhj.asF());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bmt.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bmt.hideLoadingView(this.mRootView);
    }

    public void mo(String str) {
        this.mListView.setVisibility(8);
        this.bmt.showNetRefreshView(this.mRootView, str, true);
    }

    public void Uc() {
        this.mListView.setVisibility(0);
        this.bmt.hideNetRefreshView(this.mRootView);
    }

    public void bj(List<com.baidu.adp.widget.ListView.h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.dhj.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.cPM.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bmt.getPageContext(), i);
        this.cPM.onChangeSkinType(this.bmt.getPageContext(), i);
        notifyDataSetChanged();
        am.j(this.mRootView, d.C0142d.cp_bg_line_c);
    }

    public void fr(boolean z) {
        BdListViewHelper.a(this.dhi, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.dhj.onDestroy();
    }
}
