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
    private TbPageContext<?> duG;
    private BdTypeListView eOe;
    private PbListView ePm;
    private g eYb;
    private h ind;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.h mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.duG = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.eOe = new BdTypeListView(tbPageContext.getPageActivity());
        this.eOe.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.eOe.setSelector(17170445);
        this.eOe.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.duG);
        this.mPullView.setTag(this.duG.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.eOe.setOnSrollToBottomListener(cVar);
        this.eOe.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.eOe, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.eOe);
    }

    public void oO(boolean z) {
        if (this.mHeaderView != null && this.eOe != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void dk(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.isEmpty(list)) {
            this.eOe.addAdapters(list);
        }
    }

    public void cK(List<m> list) {
        if (list != null) {
            this.eOe.setData(list);
        }
    }

    public void completePullRefresh() {
        this.eOe.completePullRefreshPostDelayed(0L);
    }

    public void bXq() {
        cgs();
        this.ePm.startLoadData();
    }

    public void bXr() {
        cgs();
        this.ePm.setText(this.duG.getResources().getString(R.string.network_ungeilivable));
        this.ePm.endLoadData();
    }

    public void bXs() {
        cgs();
        this.ePm.setText(this.duG.getResources().getString(R.string.list_no_more));
        this.ePm.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.eOe, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.ePm != null) {
            this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_d));
            this.ePm.changeSkin(i);
        }
        if (this.ind != null) {
            this.ind.onChangeSkinType();
        }
        if (this.eYb != null) {
            this.eYb.onChangeSkinType();
        }
    }

    public void cgr() {
        if (this.eOe != null) {
            this.eOe.setNextPage(null);
            this.ePm = null;
        }
    }

    private void cgs() {
        if (this.eOe != null && this.ePm == null) {
            this.ePm = new PbListView(this.duG.getPageActivity());
            this.ePm.createView();
            this.eOe.setNextPage(this.ePm);
        }
    }

    public void showLoadingView() {
        if (this.eYb == null) {
            this.eYb = new g(this.duG.getPageActivity(), BdListViewHelper.egw);
            this.eYb.onChangeSkinType();
        }
        if (!this.eYb.isViewAttached()) {
            this.eOe.setVisibility(8);
            this.eYb.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.eYb != null && this.eYb.isViewAttached()) {
            this.eOe.setVisibility(0);
            this.eYb.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.ind == null) {
            this.ind = new h(this.duG.getPageActivity(), onClickListener);
            this.ind.setLayoutMargin(BdListViewHelper.egw);
            this.ind.onChangeSkinType();
        }
        if (!this.ind.isViewAttached()) {
            this.eOe.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.duG.getString(R.string.invite_friend_no_data_now);
            }
            this.ind.setTitle(str);
            this.ind.attachView(this.mRootView, true);
            this.ind.showRefreshButton();
        }
    }

    public void blt() {
        if (this.ind != null && this.ind.isViewAttached()) {
            this.eOe.setVisibility(0);
            this.ind.dettachView(this.mRootView);
        }
    }
}
