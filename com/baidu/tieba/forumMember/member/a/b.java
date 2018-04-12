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
    private BaseActivity bcJ;
    private NoNetworkView cHB;
    private View cVa;
    private a cVb;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private f mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.bcJ = baseActivity;
        this.bcJ.setContentView(d.i.forum_member_activity);
        this.mRootView = this.bcJ.findViewById(d.g.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.bcJ.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.bcJ.getString(d.k.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.bcJ.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.bcJ.setNetRefreshViewTopMargin(BdListViewHelper.aNm);
        this.cHB = (NoNetworkView) this.bcJ.findViewById(d.g.view_no_network);
        this.mListView = (BdTypeListView) this.bcJ.findViewById(d.g.forum_member_listview);
        this.mPullView = new f(this.bcJ.getPageContext());
        this.mPullView.setTag(this.bcJ.getUniqueId());
        if (this.bcJ instanceof e.b) {
            this.mPullView.a((e.b) this.bcJ);
        }
        if (this.bcJ instanceof BdListView.e) {
            this.mListView.setOnSrollToBottomListener((BdListView.e) this.bcJ);
        }
        this.mListView.setPullRefresh(this.mPullView);
        this.cVa = BdListViewHelper.a(this.bcJ.getPageContext().getPageActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
        this.cVb = new a(this.bcJ, this.mListView);
        this.mListView.addAdapters(this.cVb.aoq());
    }

    public void showLoadingView() {
        this.mListView.setVisibility(8);
        this.bcJ.showLoadingView(this.mRootView, true);
    }

    public void Ou() {
        this.mListView.setVisibility(0);
        this.bcJ.hideLoadingView(this.mRootView);
    }

    public void lE(String str) {
        this.mListView.setVisibility(8);
        this.bcJ.showNetRefreshView(this.mRootView, str, true);
    }

    public void Qn() {
        this.mListView.setVisibility(0);
        this.bcJ.hideNetRefreshView(this.mRootView);
    }

    public void bc(List<h> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.cVb.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(2000L);
    }

    public void startPullRefresh() {
        this.mListView.startPullRefresh();
    }

    public void g(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.cHB.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bcJ.getPageContext(), i);
        this.cHB.onChangeSkinType(this.bcJ.getPageContext(), i);
        notifyDataSetChanged();
        ak.j(this.mRootView, d.C0126d.cp_bg_line_c);
    }

    public void fl(boolean z) {
        BdListViewHelper.a(this.cVa, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
