package com.baidu.tieba.forumMember.member.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
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
    private BaseActivity bsQ;
    private NoNetworkView cYm;
    private View dpP;
    private a dpQ;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.bsQ = baseActivity;
        this.bsQ.setContentView(e.h.forum_member_activity);
        this.mRootView = this.bsQ.findViewById(e.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bsQ.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.bsQ.getString(e.j.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bsQ.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bsQ.setNetRefreshViewTopMargin(BdListViewHelper.aZy);
        this.cYm = (NoNetworkView) this.bsQ.findViewById(e.g.view_no_network);
        this.mListView = (BdTypeListView) this.bsQ.findViewById(e.g.forum_member_listview);
        this.mPullView = new k(this.bsQ.getPageContext());
        this.mPullView.setTag(this.bsQ.getUniqueId());
        if (this.bsQ instanceof j.b) {
            this.mPullView.a((j.b) this.bsQ);
        }
        if (this.bsQ instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bsQ);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.dpP = BdListViewHelper.a(this.bsQ.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dpQ = new a(this.bsQ, this.mListView);
        this.mListView.addAdapters(this.dpQ.auW());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bsQ.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bsQ.hideLoadingView(this.mRootView);
    }

    public void mR(String str) {
        this.mListView.setVisibility(8);
        this.bsQ.showNetRefreshView(this.mRootView, str, true);
    }

    public void Wa() {
        this.mListView.setVisibility(0);
        this.bsQ.hideNetRefreshView(this.mRootView);
    }

    public void bj(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.dpQ.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.cYm.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bsQ.getPageContext(), i);
        this.cYm.onChangeSkinType(this.bsQ.getPageContext(), i);
        notifyDataSetChanged();
        al.j(this.mRootView, e.d.cp_bg_line_c);
    }

    public void fJ(boolean z) {
        BdListViewHelper.a(this.dpP, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.dpQ.onDestroy();
    }
}
