package com.baidu.tieba.forumMember.member.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    private BaseActivity cNc;
    private NoNetworkView eCe;
    private View eWi;
    private a eWj;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private i mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.cNc = baseActivity;
        this.cNc.setContentView(d.h.forum_member_activity);
        this.mRootView = this.cNc.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.cNc.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.cNc.getString(d.j.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cNc.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cNc.setNetRefreshViewTopMargin(BdListViewHelper.csX);
        this.eCe = (NoNetworkView) this.cNc.findViewById(d.g.view_no_network);
        this.mListView = (BdTypeListView) this.cNc.findViewById(d.g.forum_member_listview);
        this.mPullView = new i(this.cNc.getPageContext());
        this.mPullView.setTag(this.cNc.getUniqueId());
        if (this.cNc instanceof h.c) {
            this.mPullView.setListPullRefreshListener((h.c) this.cNc);
        }
        if (this.cNc instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.cNc);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.eWi = BdListViewHelper.a(this.cNc.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.eWj = new a(this.cNc, this.mListView);
        this.mListView.addAdapters(this.eWj.aBv());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.cNc.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.cNc.hideLoadingView(this.mRootView);
    }

    public void uQ(String str) {
        this.mListView.setVisibility(8);
        this.cNc.showNetRefreshView(this.mRootView, str, true);
    }

    public void aBq() {
        this.mListView.setVisibility(0);
        this.cNc.hideNetRefreshView(this.mRootView);
    }

    public void bM(List<m> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.eWj.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.eCe.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cNc.getPageContext(), i);
        this.eCe.onChangeSkinType(this.cNc.getPageContext(), i);
        notifyDataSetChanged();
        al.l(this.mRootView, d.C0277d.cp_bg_line_c);
    }

    public void iO(boolean z) {
        BdListViewHelper.a(this.eWi, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.eWj.onDestroy();
    }
}
