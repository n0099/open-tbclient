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
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    private BaseActivity cVp;
    private NoNetworkView eRV;
    private View fmo;
    private a fmp;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private i mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.cVp = baseActivity;
        this.cVp.setContentView(R.layout.forum_member_activity);
        this.mRootView = this.cVp.findViewById(R.id.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.cVp.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.cVp.getString(R.string.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cVp.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cVp.setNetRefreshViewTopMargin(BdListViewHelper.cBh);
        this.eRV = (NoNetworkView) this.cVp.findViewById(R.id.view_no_network);
        this.mListView = (BdTypeListView) this.cVp.findViewById(R.id.forum_member_listview);
        this.mPullView = new i(this.cVp.getPageContext());
        this.mPullView.setTag(this.cVp.getUniqueId());
        if (this.cVp instanceof h.c) {
            this.mPullView.setListPullRefreshListener((h.c) this.cVp);
        }
        if (this.cVp instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.cVp);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.fmo = BdListViewHelper.a(this.cVp.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.fmp = new a(this.cVp, this.mListView);
        this.mListView.addAdapters(this.fmp.aHP());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.cVp.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.cVp.hideLoadingView(this.mRootView);
    }

    public void wk(String str) {
        this.mListView.setVisibility(8);
        this.cVp.showNetRefreshView(this.mRootView, str, true);
    }

    public void aHK() {
        this.mListView.setVisibility(0);
        this.cVp.hideNetRefreshView(this.mRootView);
    }

    public void bU(List<m> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.fmp.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.eRV.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cVp.getPageContext(), i);
        this.eRV.onChangeSkinType(this.cVp.getPageContext(), i);
        notifyDataSetChanged();
        al.l(this.mRootView, R.color.cp_bg_line_c);
    }

    public void jw(boolean z) {
        BdListViewHelper.a(this.fmo, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.fmp.onDestroy();
    }
}
