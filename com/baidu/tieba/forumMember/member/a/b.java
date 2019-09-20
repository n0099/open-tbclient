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
    private BaseActivity cXM;
    private NoNetworkView eYL;
    private a ftA;
    private View ftz;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private i mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.cXM = baseActivity;
        this.cXM.setContentView(R.layout.forum_member_activity);
        this.mRootView = this.cXM.findViewById(R.id.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.cXM.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.cXM.getString(R.string.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cXM.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cXM.setNetRefreshViewTopMargin(BdListViewHelper.cDC);
        this.eYL = (NoNetworkView) this.cXM.findViewById(R.id.view_no_network);
        this.mListView = (BdTypeListView) this.cXM.findViewById(R.id.forum_member_listview);
        this.mPullView = new i(this.cXM.getPageContext());
        this.mPullView.setTag(this.cXM.getUniqueId());
        if (this.cXM instanceof h.c) {
            this.mPullView.setListPullRefreshListener((h.c) this.cXM);
        }
        if (this.cXM instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.cXM);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.ftz = BdListViewHelper.a(this.cXM.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.ftA = new a(this.cXM, this.mListView);
        this.mListView.addAdapters(this.ftA.aJS());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.cXM.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.cXM.hideLoadingView(this.mRootView);
    }

    public void xo(String str) {
        this.mListView.setVisibility(8);
        this.cXM.showNetRefreshView(this.mRootView, str, true);
    }

    public void aJN() {
        this.mListView.setVisibility(0);
        this.cXM.hideNetRefreshView(this.mRootView);
    }

    public void bV(List<m> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.ftA.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.eYL.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cXM.getPageContext(), i);
        this.eYL.onChangeSkinType(this.cXM.getPageContext(), i);
        notifyDataSetChanged();
        am.l(this.mRootView, R.color.cp_bg_line_c);
    }

    public void jJ(boolean z) {
        BdListViewHelper.a(this.ftz, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.ftA.onDestroy();
    }
}
