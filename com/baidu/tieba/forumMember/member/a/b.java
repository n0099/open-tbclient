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
    private BaseActivity bmZ;
    private NoNetworkView cSy;
    private View djY;
    private a djZ;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private h mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.bmZ = baseActivity;
        this.bmZ.setContentView(d.h.forum_member_activity);
        this.mRootView = this.bmZ.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bmZ.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.bmZ.getString(d.j.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bmZ.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bmZ.setNetRefreshViewTopMargin(BdListViewHelper.aWi);
        this.cSy = (NoNetworkView) this.bmZ.findViewById(d.g.view_no_network);
        this.mListView = (BdTypeListView) this.bmZ.findViewById(d.g.forum_member_listview);
        this.mPullView = new h(this.bmZ.getPageContext());
        this.mPullView.setTag(this.bmZ.getUniqueId());
        if (this.bmZ instanceof g.b) {
            this.mPullView.a((g.b) this.bmZ);
        }
        if (this.bmZ instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bmZ);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.djY = BdListViewHelper.a(this.bmZ.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.djZ = new a(this.bmZ, this.mListView);
        this.mListView.addAdapters(this.djZ.atj());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bmZ.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.bmZ.hideLoadingView(this.mRootView);
    }

    public void mn(String str) {
        this.mListView.setVisibility(8);
        this.bmZ.showNetRefreshView(this.mRootView, str, true);
    }

    public void Uk() {
        this.mListView.setVisibility(0);
        this.bmZ.hideNetRefreshView(this.mRootView);
    }

    public void bi(List<com.baidu.adp.widget.ListView.h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.djZ.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.cSy.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bmZ.getPageContext(), i);
        this.cSy.onChangeSkinType(this.bmZ.getPageContext(), i);
        notifyDataSetChanged();
        am.j(this.mRootView, d.C0140d.cp_bg_line_c);
    }

    public void fs(boolean z) {
        BdListViewHelper.a(this.djY, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.djZ.onDestroy();
    }
}
