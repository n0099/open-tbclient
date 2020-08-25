package com.baidu.tieba.forumMember.member.a;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes17.dex */
public class b {
    private BdTypeListView fCP;
    private NoNetworkView fCm;
    private View hPS;
    private a hPT;
    private BaseActivity mActivity;
    private NavigationBar mNavigationBar;
    private g mPullView;
    private View mRootView;

    public b(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
        this.mActivity.setContentView(R.layout.forum_member_activity);
        this.mRootView = this.mActivity.findViewById(R.id.activity_root_view);
        this.mNavigationBar = (NavigationBar) this.mActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(this.mActivity.getString(R.string.forummember)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.a.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.mActivity.finish();
            }
        });
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mActivity.setNetRefreshViewTopMargin(BdListViewHelper.eUU);
        this.fCm = (NoNetworkView) this.mActivity.findViewById(R.id.view_no_network);
        this.fCP = (BdTypeListView) this.mActivity.findViewById(R.id.forum_member_listview);
        this.mPullView = new g(this.mActivity.getPageContext());
        this.mPullView.setTag(this.mActivity.getUniqueId());
        if (this.mActivity instanceof f.c) {
            this.mPullView.setListPullRefreshListener((f.c) this.mActivity);
        }
        if (this.mActivity instanceof BdListView.e) {
            this.fCP.setOnSrollToBottomListener((BdListView.e) this.mActivity);
        }
        this.fCP.setPullRefresh(this.mPullView);
        this.hPS = BdListViewHelper.a(this.mActivity.getPageContext().getPageActivity(), this.fCP, BdListViewHelper.HeadType.DEFAULT);
        this.hPT = new a(this.mActivity, this.fCP);
        this.fCP.addAdapters(this.hPT.bGe());
    }

    public void showLoadingView() {
        this.fCP.setVisibility(8);
        this.mActivity.showLoadingView(this.mRootView, true);
    }

    public void hideLoadingView() {
        this.fCP.setVisibility(0);
        this.mActivity.hideLoadingView(this.mRootView);
    }

    public void Ik(String str) {
        this.fCP.setVisibility(8);
        this.mActivity.showNetRefreshView(this.mRootView, str, true);
    }

    public void bFW() {
        this.fCP.setVisibility(0);
        this.mActivity.hideNetRefreshView(this.mRootView);
    }

    public void cz(List<q> list) {
        if (list != null) {
            this.fCP.setData(list);
        }
    }

    public void notifyDataSetChanged() {
        this.hPT.notifyDataSetChanged();
    }

    public void completePullRefresh() {
        this.fCP.completePullRefreshPostDelayed(0L);
    }

    public void startPullRefresh() {
        this.fCP.startPullRefresh();
    }

    public void f(NoNetworkView.a aVar) {
        if (aVar != null) {
            this.fCm.a(aVar);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.mActivity.getPageContext(), i);
        this.fCm.onChangeSkinType(this.mActivity.getPageContext(), i);
        notifyDataSetChanged();
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_c);
    }

    public void nX(boolean z) {
        BdListViewHelper.a(this.hPS, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void onDestroy() {
        this.hPT.onDestroy();
    }
}
