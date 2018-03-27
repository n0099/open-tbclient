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
    private BaseActivity bSF;
    private View dCo;
    private a dCp;
    private NoNetworkView dpl;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private k mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.bSF = baseActivity;
        this.bSF.setContentView(d.h.forum_member_activity);
        this.mRootView = this.bSF.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bSF.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.bSF.getString(d.j.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bSF.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bSF.setNetRefreshViewTopMargin(BdListViewHelper.bCM);
        this.dpl = (NoNetworkView) this.bSF.findViewById(d.g.view_no_network);
        this.mListView = (BdTypeListView) this.bSF.findViewById(d.g.forum_member_listview);
        this.mPullView = new k(this.bSF.getPageContext());
        this.mPullView.setTag(this.bSF.getUniqueId());
        if (this.bSF instanceof j.b) {
            this.mPullView.a((j.b) this.bSF);
        }
        if (this.bSF instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bSF);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.dCo = BdListViewHelper.a(this.bSF.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.dCp = new a(this.bSF, this.mListView);
        this.mListView.addAdapters(this.dCp.aub());
    }

    public void VU() {
        this.mListView.setVisibility(8);
        this.bSF.showLoadingView(this.mRootView, true);
    }

    public void VV() {
        this.mListView.setVisibility(0);
        this.bSF.hideLoadingView(this.mRootView);
    }

    public void lB(String str) {
        this.mListView.setVisibility(8);
        this.bSF.showNetRefreshView(this.mRootView, str, true);
    }

    public void XN() {
        this.mListView.setVisibility(0);
        this.bSF.hideNetRefreshView(this.mRootView);
    }

    public void bi(List<i> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.dCp.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.dpl.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bSF.getPageContext(), i);
        this.dpl.onChangeSkinType(this.bSF.getPageContext(), i);
        notifyDataSetChanged();
        aj.t(this.mRootView, d.C0141d.cp_bg_line_c);
    }

    public void fG(boolean z) {
        BdListViewHelper.a(this.dCo, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
