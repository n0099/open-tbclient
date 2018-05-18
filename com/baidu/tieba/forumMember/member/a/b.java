package com.baidu.tieba.forumMember.member.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BaseActivity bcK;
    private NoNetworkView cIH;
    private View cWe;
    private a cWf;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private f mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.bcK = baseActivity;
        this.bcK.setContentView(d.i.forum_member_activity);
        this.mRootView = this.bcK.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bcK.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.bcK.getString(d.k.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.bcK.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bcK.setNetRefreshViewTopMargin(BdListViewHelper.aNn);
        this.cIH = (NoNetworkView) this.bcK.findViewById(d.g.view_no_network);
        this.mListView = (BdTypeListView) this.bcK.findViewById(d.g.forum_member_listview);
        this.mPullView = new f(this.bcK.getPageContext());
        this.mPullView.setTag(this.bcK.getUniqueId());
        if (this.bcK instanceof e.b) {
            this.mPullView.a((e.b) this.bcK);
        }
        if (this.bcK instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bcK);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.cWe = BdListViewHelper.a(this.bcK.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.cWf = new a(this.bcK, this.mListView);
        this.mListView.addAdapters(this.cWf.aop());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bcK.showLoadingView(this.mRootView, true);
    }

    public void Os() {
        this.mListView.setVisibility(0);
        this.bcK.hideLoadingView(this.mRootView);
    }

    public void lH(String str) {
        this.mListView.setVisibility(8);
        this.bcK.showNetRefreshView(this.mRootView, str, true);
    }

    public void Qk() {
        this.mListView.setVisibility(0);
        this.bcK.hideNetRefreshView(this.mRootView);
    }

    public void bf(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.cWf.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.cIH.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bcK.getPageContext(), i);
        this.cIH.onChangeSkinType(this.bcK.getPageContext(), i);
        notifyDataSetChanged();
        ak.j(this.mRootView, d.C0126d.cp_bg_line_c);
    }

    public void fm(boolean z) {
        BdListViewHelper.a(this.cWe, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
