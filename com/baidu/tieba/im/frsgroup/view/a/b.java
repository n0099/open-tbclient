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
    private g gAg;
    private BdTypeListView gpZ;
    private PbListView grg;
    private h kvd;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.eNx = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.gpZ = new BdTypeListView(tbPageContext.getPageActivity());
        this.gpZ.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.gpZ.setSelector(17170445);
        this.gpZ.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.eNx);
        this.mPullView.setTag(this.eNx.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.gpZ.setOnSrollToBottomListener(cVar);
        this.gpZ.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.gpZ, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.gpZ);
    }

    public void sD(boolean z) {
        if (this.mHeaderView != null && this.gpZ != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void ey(List<com.baidu.adp.widget.ListView.a> list) {
        if (!y.isEmpty(list)) {
            this.gpZ.addAdapters(list);
        }
    }

    public void dH(List<q> list) {
        if (list != null) {
            this.gpZ.setData(list);
        }
    }

    public void completePullRefresh() {
        this.gpZ.completePullRefreshPostDelayed(0L);
    }

    public void cMP() {
        cXt();
        this.grg.startLoadData();
    }

    public void cMQ() {
        cXt();
        this.grg.setText(this.eNx.getResources().getString(R.string.network_ungeilivable));
        this.grg.endLoadData();
    }

    public void cMR() {
        cXt();
        this.grg.setText(this.eNx.getResources().getString(R.string.list_no_more));
        this.grg.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.gpZ, R.color.CAM_X0204);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.grg != null) {
            this.grg.setContainerBackgroundColorResId(R.color.CAM_X0204);
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.grg.changeSkin(i);
        }
        if (this.kvd != null) {
            this.kvd.onChangeSkinType();
        }
        if (this.gAg != null) {
            this.gAg.onChangeSkinType();
        }
    }

    public void cXs() {
        if (this.gpZ != null) {
            this.gpZ.setNextPage(null);
            this.grg = null;
        }
    }

    private void cXt() {
        if (this.gpZ != null && this.grg == null) {
            this.grg = new PbListView(this.eNx.getPageActivity());
            this.grg.createView();
            this.gpZ.setNextPage(this.grg);
        }
    }

    public void showLoadingView() {
        if (this.gAg == null) {
            this.gAg = new g(this.eNx.getPageActivity(), BdListViewHelper.fFw);
            this.gAg.onChangeSkinType();
        }
        if (!this.gAg.isViewAttached()) {
            this.gpZ.setVisibility(8);
            this.gAg.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.gAg != null && this.gAg.isViewAttached()) {
            this.gpZ.setVisibility(0);
            this.gAg.dettachView(this.mRootView);
        }
    }

    public void d(String str, View.OnClickListener onClickListener) {
        if (this.kvd == null) {
            this.kvd = new h(this.eNx.getPageActivity(), onClickListener);
            this.kvd.setLayoutMargin(BdListViewHelper.fFw);
            this.kvd.onChangeSkinType();
        }
        if (!this.kvd.isViewAttached()) {
            this.gpZ.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.eNx.getString(R.string.invite_friend_no_data_now);
            }
            this.kvd.setTitle(str);
            this.kvd.attachView(this.mRootView, true);
            this.kvd.showRefreshButton();
        }
    }

    public void Yb() {
        if (this.kvd != null && this.kvd.isViewAttached()) {
            this.gpZ.setVisibility(0);
            this.kvd.dettachView(this.mRootView);
        }
    }
}
