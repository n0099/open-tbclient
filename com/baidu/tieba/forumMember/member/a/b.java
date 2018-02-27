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
    private BaseActivity bSC;
    private View dCl;
    private a dCm;
    private NoNetworkView dpi;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.bSC = baseActivity;
        this.bSC.setContentView(d.h.forum_member_activity);
        this.mRootView = this.bSC.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bSC.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.bSC.getString(d.j.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bSC.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bSC.setNetRefreshViewTopMargin(BdListViewHelper.bCJ);
        this.dpi = (NoNetworkView) this.bSC.findViewById(d.g.view_no_network);
        this.mListView = (BdTypeListView) this.bSC.findViewById(d.g.forum_member_listview);
        this.mPullView = new k(this.bSC.getPageContext());
        this.mPullView.setTag(this.bSC.getUniqueId());
        if (this.bSC instanceof j.b) {
            this.mPullView.a((j.b) this.bSC);
        }
        if (this.bSC instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bSC);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.dCl = BdListViewHelper.a(this.bSC.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dCm = new a(this.bSC, this.mListView);
        this.mListView.addAdapters(this.dCm.aua());
    }

    public void VT() {
        this.mListView.setVisibility(8);
        this.bSC.showLoadingView(this.mRootView, true);
    }

    public void VU() {
        this.mListView.setVisibility(0);
        this.bSC.hideLoadingView(this.mRootView);
    }

    public void lB(String str) {
        this.mListView.setVisibility(8);
        this.bSC.showNetRefreshView(this.mRootView, str, true);
    }

    public void XM() {
        this.mListView.setVisibility(0);
        this.bSC.hideNetRefreshView(this.mRootView);
    }

    public void bi(List<i> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.dCm.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dpi.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bSC.getPageContext(), i);
        this.dpi.onChangeSkinType(this.bSC.getPageContext(), i);
        notifyDataSetChanged();
        aj.t(this.mRootView, d.C0141d.cp_bg_line_c);
    }

    public void fG(boolean z) {
        BdListViewHelper.a(this.dCl, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
