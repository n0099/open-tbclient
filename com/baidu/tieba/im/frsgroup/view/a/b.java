package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    private TbPageContext<?> cfl;
    private g dEq;
    private BdTypeListView dvB;
    private PbListView dwJ;
    private h gIL;
    private View mHeaderView;
    private i mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.cfl = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.dvB = new BdTypeListView(tbPageContext.getPageActivity());
        this.dvB.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.dvB.setSelector(17170445);
        this.dvB.setDividerHeight(0);
        this.mPullView = new i(this.cfl);
        this.mPullView.setTag(this.cfl.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.dvB.setOnSrollToBottomListener(cVar);
        this.dvB.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.dvB, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.dvB);
    }

    public void md(boolean z) {
        if (this.mHeaderView != null && this.dvB != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m25do(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.isEmpty(list)) {
            this.dvB.addAdapters(list);
        }
    }

    public void cK(List<m> list) {
        if (list != null) {
            this.dvB.setData(list);
        }
    }

    public void completePullRefresh() {
        this.dvB.completePullRefreshPostDelayed(0L);
    }

    public void bsy() {
        bBB();
        this.dwJ.startLoadData();
    }

    public void bsz() {
        bBB();
        this.dwJ.setText(this.cfl.getResources().getString(R.string.network_ungeilivable));
        this.dwJ.endLoadData();
    }

    public void bsA() {
        bBB();
        this.dwJ.setText(this.cfl.getResources().getString(R.string.list_no_more));
        this.dwJ.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.dvB, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.dwJ != null) {
            this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.dwJ.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dwJ.changeSkin(i);
        }
        if (this.gIL != null) {
            this.gIL.onChangeSkinType();
        }
        if (this.dEq != null) {
            this.dEq.onChangeSkinType();
        }
    }

    public void bBA() {
        if (this.dvB != null) {
            this.dvB.setNextPage(null);
            this.dwJ = null;
        }
    }

    private void bBB() {
        if (this.dvB != null && this.dwJ == null) {
            this.dwJ = new PbListView(this.cfl.getPageActivity());
            this.dwJ.createView();
            this.dvB.setNextPage(this.dwJ);
        }
    }

    public void showLoadingView() {
        if (this.dEq == null) {
            this.dEq = new g(this.cfl.getPageActivity(), BdListViewHelper.NET_RERESHNEW_TOP_MARGIN);
            this.dEq.onChangeSkinType();
        }
        if (!this.dEq.isViewAttached()) {
            this.dvB.setVisibility(8);
            this.dEq.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.dEq != null && this.dEq.isViewAttached()) {
            this.dvB.setVisibility(0);
            this.dEq.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.gIL == null) {
            this.gIL = new h(this.cfl.getPageActivity(), onClickListener);
            this.gIL.setLayoutMargin(BdListViewHelper.NET_RERESHNEW_TOP_MARGIN);
            this.gIL.onChangeSkinType();
        }
        if (!this.gIL.isViewAttached()) {
            this.dvB.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.cfl.getString(R.string.invite_friend_no_data_now);
            }
            this.gIL.setTitle(str);
            this.gIL.attachView(this.mRootView, true);
            this.gIL.showRefreshButton();
        }
    }

    public void aJo() {
        if (this.gIL != null && this.gIL.isViewAttached()) {
            this.dvB.setVisibility(0);
            this.gIL.dettachView(this.mRootView);
        }
    }
}
