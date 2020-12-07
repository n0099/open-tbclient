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
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes23.dex */
public class b {
    private TbPageContext<?> eNx;
    private g gAe;
    private BdTypeListView gpX;
    private PbListView gre;
    private h kvb;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.eNx = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.gpX = new BdTypeListView(tbPageContext.getPageActivity());
        this.gpX.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.gpX.setSelector(17170445);
        this.gpX.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.eNx);
        this.mPullView.setTag(this.eNx.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.gpX.setOnSrollToBottomListener(cVar);
        this.gpX.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.gpX, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.gpX);
    }

    public void sD(boolean z) {
        if (this.mHeaderView != null && this.gpX != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void ey(List<com.baidu.adp.widget.ListView.a> list) {
        if (!y.isEmpty(list)) {
            this.gpX.addAdapters(list);
        }
    }

    public void dH(List<q> list) {
        if (list != null) {
            this.gpX.setData(list);
        }
    }

    public void completePullRefresh() {
        this.gpX.completePullRefreshPostDelayed(0L);
    }

    public void cMO() {
        cXs();
        this.gre.startLoadData();
    }

    public void cMP() {
        cXs();
        this.gre.setText(this.eNx.getResources().getString(R.string.network_ungeilivable));
        this.gre.endLoadData();
    }

    public void cMQ() {
        cXs();
        this.gre.setText(this.eNx.getResources().getString(R.string.list_no_more));
        this.gre.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.gpX, R.color.CAM_X0204);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gre != null) {
            this.gre.setContainerBackgroundColorResId(R.color.CAM_X0204);
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gre.changeSkin(i);
        }
        if (this.kvb != null) {
            this.kvb.onChangeSkinType();
        }
        if (this.gAe != null) {
            this.gAe.onChangeSkinType();
        }
    }

    public void cXr() {
        if (this.gpX != null) {
            this.gpX.setNextPage(null);
            this.gre = null;
        }
    }

    private void cXs() {
        if (this.gpX != null && this.gre == null) {
            this.gre = new PbListView(this.eNx.getPageActivity());
            this.gre.createView();
            this.gpX.setNextPage(this.gre);
        }
    }

    public void showLoadingView() {
        if (this.gAe == null) {
            this.gAe = new g(this.eNx.getPageActivity(), BdListViewHelper.fFw);
            this.gAe.onChangeSkinType();
        }
        if (!this.gAe.isViewAttached()) {
            this.gpX.setVisibility(8);
            this.gAe.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.gAe != null && this.gAe.isViewAttached()) {
            this.gpX.setVisibility(0);
            this.gAe.dettachView(this.mRootView);
        }
    }

    public void d(String str, View.OnClickListener onClickListener) {
        if (this.kvb == null) {
            this.kvb = new h(this.eNx.getPageActivity(), onClickListener);
            this.kvb.setLayoutMargin(BdListViewHelper.fFw);
            this.kvb.onChangeSkinType();
        }
        if (!this.kvb.isViewAttached()) {
            this.gpX.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.eNx.getString(R.string.invite_friend_no_data_now);
            }
            this.kvb.setTitle(str);
            this.kvb.attachView(this.mRootView, true);
            this.kvb.showRefreshButton();
        }
    }

    public void Yb() {
        if (this.kvb != null && this.kvb.isViewAttached()) {
            this.gpX.setVisibility(0);
            this.kvb.dettachView(this.mRootView);
        }
    }
}
