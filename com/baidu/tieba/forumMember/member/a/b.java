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
    private BaseActivity cVo;
    private NoNetworkView eRU;
    private View fmn;
    private a fmo;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private i mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.cVo = baseActivity;
        this.cVo.setContentView(R.layout.forum_member_activity);
        this.mRootView = this.cVo.findViewById(R.id.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.cVo.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.cVo.getString(R.string.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cVo.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cVo.setNetRefreshViewTopMargin(BdListViewHelper.cBh);
        this.eRU = (NoNetworkView) this.cVo.findViewById(R.id.view_no_network);
        this.mListView = (BdTypeListView) this.cVo.findViewById(R.id.forum_member_listview);
        this.mPullView = new i(this.cVo.getPageContext());
        this.mPullView.setTag(this.cVo.getUniqueId());
        if (this.cVo instanceof h.c) {
            this.mPullView.setListPullRefreshListener((h.c) this.cVo);
        }
        if (this.cVo instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.cVo);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.fmn = BdListViewHelper.a(this.cVo.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.fmo = new a(this.cVo, this.mListView);
        this.mListView.addAdapters(this.fmo.aHM());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.cVo.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.mListView.setVisibility(0);
        this.cVo.hideLoadingView(this.mRootView);
    }

    public void wk(String str) {
        this.mListView.setVisibility(8);
        this.cVo.showNetRefreshView(this.mRootView, str, true);
    }

    public void aHH() {
        this.mListView.setVisibility(0);
        this.cVo.hideNetRefreshView(this.mRootView);
    }

    public void bU(List<m> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.fmo.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.eRU.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cVo.getPageContext(), i);
        this.eRU.onChangeSkinType(this.cVo.getPageContext(), i);
        notifyDataSetChanged();
        al.l(this.mRootView, R.color.cp_bg_line_c);
    }

    public void jw(boolean z) {
        BdListViewHelper.a(this.fmn, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.fmo.onDestroy();
    }
}
