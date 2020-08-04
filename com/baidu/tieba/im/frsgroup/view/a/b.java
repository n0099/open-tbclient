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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes17.dex */
public class b {
    private TbPageContext<?> dVN;
    private g fBv;
    private BdTypeListView frv;
    private PbListView fsC;
    private h jbT;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.dVN = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.frv = new BdTypeListView(tbPageContext.getPageActivity());
        this.frv.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.frv.setSelector(17170445);
        this.frv.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.dVN);
        this.mPullView.setTag(this.dVN.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.frv.setOnSrollToBottomListener(cVar);
        this.frv.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.frv, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.frv);
    }

    public void qb(boolean z) {
        if (this.mHeaderView != null && this.frv != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void dE(List<com.baidu.adp.widget.ListView.a> list) {
        if (!x.isEmpty(list)) {
            this.frv.addAdapters(list);
        }
    }

    public void cX(List<q> list) {
        if (list != null) {
            this.frv.setData(list);
        }
    }

    public void completePullRefresh() {
        this.frv.completePullRefreshPostDelayed(0L);
    }

    public void ckS() {
        cuL();
        this.fsC.startLoadData();
    }

    public void ckT() {
        cuL();
        this.fsC.setText(this.dVN.getResources().getString(R.string.network_ungeilivable));
        this.fsC.endLoadData();
    }

    public void ckU() {
        cuL();
        this.fsC.setText(this.dVN.getResources().getString(R.string.list_no_more));
        this.fsC.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.frv, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fsC != null) {
            this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_d));
            this.fsC.changeSkin(i);
        }
        if (this.jbT != null) {
            this.jbT.onChangeSkinType();
        }
        if (this.fBv != null) {
            this.fBv.onChangeSkinType();
        }
    }

    public void cuK() {
        if (this.frv != null) {
            this.frv.setNextPage(null);
            this.fsC = null;
        }
    }

    private void cuL() {
        if (this.frv != null && this.fsC == null) {
            this.fsC = new PbListView(this.dVN.getPageActivity());
            this.fsC.createView();
            this.frv.setNextPage(this.fsC);
        }
    }

    public void showLoadingView() {
        if (this.fBv == null) {
            this.fBv = new g(this.dVN.getPageActivity(), BdListViewHelper.eKp);
            this.fBv.onChangeSkinType();
        }
        if (!this.fBv.isViewAttached()) {
            this.frv.setVisibility(8);
            this.fBv.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.fBv != null && this.fBv.isViewAttached()) {
            this.frv.setVisibility(0);
            this.fBv.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.jbT == null) {
            this.jbT = new h(this.dVN.getPageActivity(), onClickListener);
            this.jbT.setLayoutMargin(BdListViewHelper.eKp);
            this.jbT.onChangeSkinType();
        }
        if (!this.jbT.isViewAttached()) {
            this.frv.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.dVN.getString(R.string.invite_friend_no_data_now);
            }
            this.jbT.setTitle(str);
            this.jbT.attachView(this.mRootView, true);
            this.jbT.showRefreshButton();
        }
    }

    public void bwX() {
        if (this.jbT != null && this.jbT.isViewAttached()) {
            this.frv.setVisibility(0);
            this.jbT.dettachView(this.mRootView);
        }
    }
}
