package com.baidu.tieba.forumMember.member.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BaseActivity bSO;
    private View dCx;
    private a dCy;
    private NoNetworkView dpu;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.bSO = baseActivity;
        this.bSO.setContentView(d.h.forum_member_activity);
        this.mRootView = this.bSO.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bSO.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.bSO.getString(d.j.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bSO.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bSO.setNetRefreshViewTopMargin(BdListViewHelper.bCW);
        this.dpu = (NoNetworkView) this.bSO.findViewById(d.g.view_no_network);
        this.mListView = (BdTypeListView) this.bSO.findViewById(d.g.forum_member_listview);
        this.mPullView = new k(this.bSO.getPageContext());
        this.mPullView.setTag(this.bSO.getUniqueId());
        if (this.bSO instanceof j.b) {
            this.mPullView.a((j.b) this.bSO);
        }
        if (this.bSO instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bSO);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.dCx = BdListViewHelper.a(this.bSO.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dCy = new a(this.bSO, this.mListView);
        this.mListView.addAdapters(this.dCy.aub());
    }

    public void VU() {
        this.mListView.setVisibility(8);
        this.bSO.showLoadingView(this.mRootView, true);
    }

    public void VV() {
        this.mListView.setVisibility(0);
        this.bSO.hideLoadingView(this.mRootView);
    }

    public void lB(String str) {
        this.mListView.setVisibility(8);
        this.bSO.showNetRefreshView(this.mRootView, str, true);
    }

    public void XN() {
        this.mListView.setVisibility(0);
        this.bSO.hideNetRefreshView(this.mRootView);
    }

    public void bi(List<i> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.dCy.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dpu.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bSO.getPageContext(), i);
        this.dpu.onChangeSkinType(this.bSO.getPageContext(), i);
        notifyDataSetChanged();
        aj.t(this.mRootView, d.C0140d.cp_bg_line_c);
    }

    public void fG(boolean z) {
        BdListViewHelper.a(this.dCx, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
