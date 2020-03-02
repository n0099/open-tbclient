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
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    private TbPageContext<?> cVh;
    private BdTypeListView ekb;
    private PbListView elj;
    private g etX;
    private h hBC;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.h mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.cVh = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.ekb = new BdTypeListView(tbPageContext.getPageActivity());
        this.ekb.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.ekb.setSelector(17170445);
        this.ekb.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.cVh);
        this.mPullView.setTag(this.cVh.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.ekb.setOnSrollToBottomListener(cVar);
        this.ekb.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.ekb, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.ekb);
    }

    public void nE(boolean z) {
        if (this.mHeaderView != null && this.ekb != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void cZ(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.isEmpty(list)) {
            this.ekb.addAdapters(list);
        }
    }

    public void cz(List<m> list) {
        if (list != null) {
            this.ekb.setData(list);
        }
    }

    public void completePullRefresh() {
        this.ekb.completePullRefreshPostDelayed(0L);
    }

    public void bMA() {
        bVy();
        this.elj.startLoadData();
    }

    public void bMB() {
        bVy();
        this.elj.setText(this.cVh.getResources().getString(R.string.network_ungeilivable));
        this.elj.endLoadData();
    }

    public void bMC() {
        bVy();
        this.elj.setText(this.cVh.getResources().getString(R.string.list_no_more));
        this.elj.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.ekb, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.elj != null) {
            this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.elj.setTextColor(am.getColor(R.color.cp_cont_d));
            this.elj.changeSkin(i);
        }
        if (this.hBC != null) {
            this.hBC.onChangeSkinType();
        }
        if (this.etX != null) {
            this.etX.onChangeSkinType();
        }
    }

    public void bVx() {
        if (this.ekb != null) {
            this.ekb.setNextPage(null);
            this.elj = null;
        }
    }

    private void bVy() {
        if (this.ekb != null && this.elj == null) {
            this.elj = new PbListView(this.cVh.getPageActivity());
            this.elj.createView();
            this.ekb.setNextPage(this.elj);
        }
    }

    public void showLoadingView() {
        if (this.etX == null) {
            this.etX = new g(this.cVh.getPageActivity(), BdListViewHelper.NET_RERESHNEW_TOP_MARGIN);
            this.etX.onChangeSkinType();
        }
        if (!this.etX.isViewAttached()) {
            this.ekb.setVisibility(8);
            this.etX.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.etX != null && this.etX.isViewAttached()) {
            this.ekb.setVisibility(0);
            this.etX.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.hBC == null) {
            this.hBC = new h(this.cVh.getPageActivity(), onClickListener);
            this.hBC.setLayoutMargin(BdListViewHelper.NET_RERESHNEW_TOP_MARGIN);
            this.hBC.onChangeSkinType();
        }
        if (!this.hBC.isViewAttached()) {
            this.ekb.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.cVh.getString(R.string.invite_friend_no_data_now);
            }
            this.hBC.setTitle(str);
            this.hBC.attachView(this.mRootView, true);
            this.hBC.showRefreshButton();
        }
    }

    public void bcx() {
        if (this.hBC != null && this.hBC.isViewAttached()) {
            this.ekb.setVisibility(0);
            this.hBC.dettachView(this.mRootView);
        }
    }
}
