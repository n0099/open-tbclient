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
/* loaded from: classes17.dex */
public class b {
    private TbPageContext<?> efr;
    private BdTypeListView fCT;
    private PbListView fEa;
    private g fMR;
    private h jqZ;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.efr = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.fCT = new BdTypeListView(tbPageContext.getPageActivity());
        this.fCT.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.fCT.setSelector(17170445);
        this.fCT.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.efr);
        this.mPullView.setTag(this.efr.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.fCT.setOnSrollToBottomListener(cVar);
        this.fCT.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.fCT, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.fCT);
    }

    public void qJ(boolean z) {
        if (this.mHeaderView != null && this.fCT != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void dL(List<com.baidu.adp.widget.ListView.a> list) {
        if (!y.isEmpty(list)) {
            this.fCT.addAdapters(list);
        }
    }

    public void cY(List<q> list) {
        if (list != null) {
            this.fCT.setData(list);
        }
    }

    public void completePullRefresh() {
        this.fCT.completePullRefreshPostDelayed(0L);
    }

    public void cvx() {
        cFD();
        this.fEa.startLoadData();
    }

    public void cvy() {
        cFD();
        this.fEa.setText(this.efr.getResources().getString(R.string.network_ungeilivable));
        this.fEa.endLoadData();
    }

    public void cvz() {
        cFD();
        this.fEa.setText(this.efr.getResources().getString(R.string.list_no_more));
        this.fEa.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.fCT, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fEa != null) {
            this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fEa.changeSkin(i);
        }
        if (this.jqZ != null) {
            this.jqZ.onChangeSkinType();
        }
        if (this.fMR != null) {
            this.fMR.onChangeSkinType();
        }
    }

    public void cFC() {
        if (this.fCT != null) {
            this.fCT.setNextPage(null);
            this.fEa = null;
        }
    }

    private void cFD() {
        if (this.fCT != null && this.fEa == null) {
            this.fEa = new PbListView(this.efr.getPageActivity());
            this.fEa.createView();
            this.fCT.setNextPage(this.fEa);
        }
    }

    public void showLoadingView() {
        if (this.fMR == null) {
            this.fMR = new g(this.efr.getPageActivity(), BdListViewHelper.eUY);
            this.fMR.onChangeSkinType();
        }
        if (!this.fMR.isViewAttached()) {
            this.fCT.setVisibility(8);
            this.fMR.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.fMR != null && this.fMR.isViewAttached()) {
            this.fCT.setVisibility(0);
            this.fMR.dettachView(this.mRootView);
        }
    }

    public void d(String str, View.OnClickListener onClickListener) {
        if (this.jqZ == null) {
            this.jqZ = new h(this.efr.getPageActivity(), onClickListener);
            this.jqZ.setLayoutMargin(BdListViewHelper.eUY);
            this.jqZ.onChangeSkinType();
        }
        if (!this.jqZ.isViewAttached()) {
            this.fCT.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.efr.getString(R.string.invite_friend_no_data_now);
            }
            this.jqZ.setTitle(str);
            this.jqZ.attachView(this.mRootView, true);
            this.jqZ.showRefreshButton();
        }
    }

    public void bFX() {
        if (this.jqZ != null && this.jqZ.isViewAttached()) {
            this.fCT.setVisibility(0);
            this.jqZ.dettachView(this.mRootView);
        }
    }
}
