package com.baidu.tieba.im.frsgroup.view.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private TbPageContext<?> ehG;
    private BdTypeListView fGf;
    private PbListView fHm;
    private g fQf;
    private h jzB;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.ehG = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.fGf = new BdTypeListView(tbPageContext.getPageActivity());
        this.fGf.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.fGf.setSelector(17170445);
        this.fGf.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.ehG);
        this.mPullView.setTag(this.ehG.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.fGf.setOnSrollToBottomListener(cVar);
        this.fGf.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.fGf, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.fGf);
    }

    public void qR(boolean z) {
        if (this.mHeaderView != null && this.fGf != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void dT(List<com.baidu.adp.widget.ListView.a> list) {
        if (!y.isEmpty(list)) {
            this.fGf.addAdapters(list);
        }
    }

    public void de(List<q> list) {
        if (list != null) {
            this.fGf.setData(list);
        }
    }

    public void completePullRefresh() {
        this.fGf.completePullRefreshPostDelayed(0L);
    }

    public void cyQ() {
        cJj();
        this.fHm.startLoadData();
    }

    public void cyR() {
        cJj();
        this.fHm.setText(this.ehG.getResources().getString(R.string.network_ungeilivable));
        this.fHm.endLoadData();
    }

    public void cyS() {
        cJj();
        this.fHm.setText(this.ehG.getResources().getString(R.string.list_no_more));
        this.fHm.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.fGf, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fHm != null) {
            this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fHm.changeSkin(i);
        }
        if (this.jzB != null) {
            this.jzB.onChangeSkinType();
        }
        if (this.fQf != null) {
            this.fQf.onChangeSkinType();
        }
    }

    public void cJi() {
        if (this.fGf != null) {
            this.fGf.setNextPage(null);
            this.fHm = null;
        }
    }

    private void cJj() {
        if (this.fGf != null && this.fHm == null) {
            this.fHm = new PbListView(this.ehG.getPageActivity());
            this.fHm.createView();
            this.fGf.setNextPage(this.fHm);
        }
    }

    public void showLoadingView() {
        if (this.fQf == null) {
            this.fQf = new g(this.ehG.getPageActivity(), BdListViewHelper.eXP);
            this.fQf.onChangeSkinType();
        }
        if (!this.fQf.isViewAttached()) {
            this.fGf.setVisibility(8);
            this.fQf.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.fQf != null && this.fQf.isViewAttached()) {
            this.fGf.setVisibility(0);
            this.fQf.dettachView(this.mRootView);
        }
    }

    public void d(String str, View.OnClickListener onClickListener) {
        if (this.jzB == null) {
            this.jzB = new h(this.ehG.getPageActivity(), onClickListener);
            this.jzB.setLayoutMargin(BdListViewHelper.eXP);
            this.jzB.onChangeSkinType();
        }
        if (!this.jzB.isViewAttached()) {
            this.fGf.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.ehG.getString(R.string.invite_friend_no_data_now);
            }
            this.jzB.setTitle(str);
            this.jzB.attachView(this.mRootView, true);
            this.jzB.showRefreshButton();
        }
    }

    public void bHn() {
        if (this.jzB != null && this.jzB.isViewAttached()) {
            this.fGf.setVisibility(0);
            this.jzB.dettachView(this.mRootView);
        }
    }
}
