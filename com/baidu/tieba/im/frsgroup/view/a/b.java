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
/* loaded from: classes23.dex */
public class b {
    private TbPageContext<?> eCn;
    private BdTypeListView gcr;
    private PbListView gdy;
    private g gmB;
    private h kaX;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.eCn = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.gcr = new BdTypeListView(tbPageContext.getPageActivity());
        this.gcr.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.gcr.setSelector(17170445);
        this.gcr.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.eCn);
        this.mPullView.setTag(this.eCn.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.gcr.setOnSrollToBottomListener(cVar);
        this.gcr.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.gcr, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.gcr);
    }

    public void rP(boolean z) {
        if (this.mHeaderView != null && this.gcr != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void ef(List<com.baidu.adp.widget.ListView.a> list) {
        if (!y.isEmpty(list)) {
            this.gcr.addAdapters(list);
        }
    }

    public void dq(List<q> list) {
        if (list != null) {
            this.gcr.setData(list);
        }
    }

    public void completePullRefresh() {
        this.gcr.completePullRefreshPostDelayed(0L);
    }

    public void cFu() {
        cPZ();
        this.gdy.startLoadData();
    }

    public void cFv() {
        cPZ();
        this.gdy.setText(this.eCn.getResources().getString(R.string.network_ungeilivable));
        this.gdy.endLoadData();
    }

    public void cFw() {
        cPZ();
        this.gdy.setText(this.eCn.getResources().getString(R.string.list_no_more));
        this.gdy.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.gcr, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gdy != null) {
            this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gdy.changeSkin(i);
        }
        if (this.kaX != null) {
            this.kaX.onChangeSkinType();
        }
        if (this.gmB != null) {
            this.gmB.onChangeSkinType();
        }
    }

    public void cPY() {
        if (this.gcr != null) {
            this.gcr.setNextPage(null);
            this.gdy = null;
        }
    }

    private void cPZ() {
        if (this.gcr != null && this.gdy == null) {
            this.gdy = new PbListView(this.eCn.getPageActivity());
            this.gdy.createView();
            this.gcr.setNextPage(this.gdy);
        }
    }

    public void showLoadingView() {
        if (this.gmB == null) {
            this.gmB = new g(this.eCn.getPageActivity(), BdListViewHelper.fsA);
            this.gmB.onChangeSkinType();
        }
        if (!this.gmB.isViewAttached()) {
            this.gcr.setVisibility(8);
            this.gmB.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.gmB != null && this.gmB.isViewAttached()) {
            this.gcr.setVisibility(0);
            this.gmB.dettachView(this.mRootView);
        }
    }

    public void d(String str, View.OnClickListener onClickListener) {
        if (this.kaX == null) {
            this.kaX = new h(this.eCn.getPageActivity(), onClickListener);
            this.kaX.setLayoutMargin(BdListViewHelper.fsA);
            this.kaX.onChangeSkinType();
        }
        if (!this.kaX.isViewAttached()) {
            this.gcr.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.eCn.getString(R.string.invite_friend_no_data_now);
            }
            this.kaX.setTitle(str);
            this.kaX.attachView(this.mRootView, true);
            this.kaX.showRefreshButton();
        }
    }

    public void TK() {
        if (this.kaX != null && this.kaX.isViewAttached()) {
            this.gcr.setVisibility(0);
            this.kaX.dettachView(this.mRootView);
        }
    }
}
