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
    private BaseActivity cWM;
    private NoNetworkView eWV;
    private View frm;
    private a frn;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private i mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.cWM = baseActivity;
        this.cWM.setContentView(R.layout.forum_member_activity);
        this.mRootView = this.cWM.findViewById(R.id.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.cWM.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.cWM.getString(R.string.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cWM.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cWM.setNetRefreshViewTopMargin(BdListViewHelper.cCz);
        this.eWV = (NoNetworkView) this.cWM.findViewById(R.id.view_no_network);
        this.mListView = (BdTypeListView) this.cWM.findViewById(R.id.forum_member_listview);
        this.mPullView = new i(this.cWM.getPageContext());
        this.mPullView.setTag(this.cWM.getUniqueId());
        if (this.cWM instanceof h.c) {
            this.mPullView.setListPullRefreshListener((h.c) this.cWM);
        }
        if (this.cWM instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.cWM);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.frm = BdListViewHelper.a(this.cWM.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.frn = new a(this.cWM, this.mListView);
        this.mListView.addAdapters(this.frn.aJm());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.cWM.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.cWM.hideLoadingView(this.mRootView);
    }

    public void wO(String str) {
        this.mListView.setVisibility(8);
        this.cWM.showNetRefreshView(this.mRootView, str, true);
    }

    public void aJh() {
        this.mListView.setVisibility(0);
        this.cWM.hideNetRefreshView(this.mRootView);
    }

    public void bV(List<m> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.frn.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.eWV.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cWM.getPageContext(), i);
        this.eWV.onChangeSkinType(this.cWM.getPageContext(), i);
        notifyDataSetChanged();
        am.l(this.mRootView, R.color.cp_bg_line_c);
    }

    public void jG(boolean z) {
        BdListViewHelper.a(this.frm, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.frn.onDestroy();
    }
}
