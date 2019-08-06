package com.baidu.tieba.forumMember.member.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    private BaseActivity cWT;
    private NoNetworkView eXf;
    private View frM;
    private a frN;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private i mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.cWT = baseActivity;
        this.cWT.setContentView(R.layout.forum_member_activity);
        this.mRootView = this.cWT.findViewById(R.id.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.cWT.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.cWT.getString(R.string.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cWT.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cWT.setNetRefreshViewTopMargin(BdListViewHelper.cCG);
        this.eXf = (NoNetworkView) this.cWT.findViewById(R.id.view_no_network);
        this.mListView = (BdTypeListView) this.cWT.findViewById(R.id.forum_member_listview);
        this.mPullView = new i(this.cWT.getPageContext());
        this.mPullView.setTag(this.cWT.getUniqueId());
        if (this.cWT instanceof h.c) {
            this.mPullView.setListPullRefreshListener((h.c) this.cWT);
        }
        if (this.cWT instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.cWT);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.frM = BdListViewHelper.a(this.cWT.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.frN = new a(this.cWT, this.mListView);
        this.mListView.addAdapters(this.frN.aJo());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.cWT.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.cWT.hideLoadingView(this.mRootView);
    }

    public void wP(String str) {
        this.mListView.setVisibility(8);
        this.cWT.showNetRefreshView(this.mRootView, str, true);
    }

    public void aJj() {
        this.mListView.setVisibility(0);
        this.cWT.hideNetRefreshView(this.mRootView);
    }

    public void bV(List<m> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.frN.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.eXf.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cWT.getPageContext(), i);
        this.eXf.onChangeSkinType(this.cWT.getPageContext(), i);
        notifyDataSetChanged();
        am.l(this.mRootView, R.color.cp_bg_line_c);
    }

    public void jG(boolean z) {
        BdListViewHelper.a(this.frM, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.frN.onDestroy();
    }
}
