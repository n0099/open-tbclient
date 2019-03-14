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
    private BaseActivity cNa;
    private NoNetworkView eCt;
    private View eWw;
    private a eWx;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private i mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.cNa = baseActivity;
        this.cNa.setContentView(d.h.forum_member_activity);
        this.mRootView = this.cNa.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.cNa.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.cNa.getString(d.j.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cNa.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cNa.setNetRefreshViewTopMargin(BdListViewHelper.csV);
        this.eCt = (NoNetworkView) this.cNa.findViewById(d.g.view_no_network);
        this.mListView = (BdTypeListView) this.cNa.findViewById(d.g.forum_member_listview);
        this.mPullView = new i(this.cNa.getPageContext());
        this.mPullView.setTag(this.cNa.getUniqueId());
        if (this.cNa instanceof h.c) {
            this.mPullView.setListPullRefreshListener((h.c) this.cNa);
        }
        if (this.cNa instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.cNa);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.eWw = BdListViewHelper.a(this.cNa.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.eWx = new a(this.cNa, this.mListView);
        this.mListView.addAdapters(this.eWx.aBy());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.cNa.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.cNa.hideLoadingView(this.mRootView);
    }

    public void uR(String str) {
        this.mListView.setVisibility(8);
        this.cNa.showNetRefreshView(this.mRootView, str, true);
    }

    public void aBt() {
        this.mListView.setVisibility(0);
        this.cNa.hideNetRefreshView(this.mRootView);
    }

    public void bO(List<m> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.eWx.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.eCt.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cNa.getPageContext(), i);
        this.eCt.onChangeSkinType(this.cNa.getPageContext(), i);
        notifyDataSetChanged();
        al.l(this.mRootView, d.C0277d.cp_bg_line_c);
    }

    public void iO(boolean z) {
        BdListViewHelper.a(this.eWw, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.eWx.onDestroy();
    }
}
