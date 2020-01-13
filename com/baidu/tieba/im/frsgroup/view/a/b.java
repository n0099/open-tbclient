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
/* loaded from: classes8.dex */
public class b {
    private TbPageContext<?> cRe;
    private BdTypeListView efW;
    private PbListView ehe;
    private g epL;
    private h hzB;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.h mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.cRe = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.efW = new BdTypeListView(tbPageContext.getPageActivity());
        this.efW.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.efW.setSelector(17170445);
        this.efW.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.cRe);
        this.mPullView.setTag(this.cRe.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.efW.setOnSrollToBottomListener(cVar);
        this.efW.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.efW, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.efW);
    }

    public void nC(boolean z) {
        if (this.mHeaderView != null && this.efW != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void dd(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.isEmpty(list)) {
            this.efW.addAdapters(list);
        }
    }

    public void cD(List<m> list) {
        if (list != null) {
            this.efW.setData(list);
        }
    }

    public void completePullRefresh() {
        this.efW.completePullRefreshPostDelayed(0L);
    }

    public void bKW() {
        bTV();
        this.ehe.startLoadData();
    }

    public void bKX() {
        bTV();
        this.ehe.setText(this.cRe.getResources().getString(R.string.network_ungeilivable));
        this.ehe.endLoadData();
    }

    public void bKY() {
        bTV();
        this.ehe.setText(this.cRe.getResources().getString(R.string.list_no_more));
        this.ehe.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.efW, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.ehe != null) {
            this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.ehe.setTextColor(am.getColor(R.color.cp_cont_d));
            this.ehe.changeSkin(i);
        }
        if (this.hzB != null) {
            this.hzB.onChangeSkinType();
        }
        if (this.epL != null) {
            this.epL.onChangeSkinType();
        }
    }

    public void bTU() {
        if (this.efW != null) {
            this.efW.setNextPage(null);
            this.ehe = null;
        }
    }

    private void bTV() {
        if (this.efW != null && this.ehe == null) {
            this.ehe = new PbListView(this.cRe.getPageActivity());
            this.ehe.createView();
            this.efW.setNextPage(this.ehe);
        }
    }

    public void showLoadingView() {
        if (this.epL == null) {
            this.epL = new g(this.cRe.getPageActivity(), BdListViewHelper.NET_RERESHNEW_TOP_MARGIN);
            this.epL.onChangeSkinType();
        }
        if (!this.epL.isViewAttached()) {
            this.efW.setVisibility(8);
            this.epL.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.epL != null && this.epL.isViewAttached()) {
            this.efW.setVisibility(0);
            this.epL.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.hzB == null) {
            this.hzB = new h(this.cRe.getPageActivity(), onClickListener);
            this.hzB.setLayoutMargin(BdListViewHelper.NET_RERESHNEW_TOP_MARGIN);
            this.hzB.onChangeSkinType();
        }
        if (!this.hzB.isViewAttached()) {
            this.efW.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.cRe.getString(R.string.invite_friend_no_data_now);
            }
            this.hzB.setTitle(str);
            this.hzB.attachView(this.mRootView, true);
            this.hzB.showRefreshButton();
        }
    }

    public void baf() {
        if (this.hzB != null && this.hzB.isViewAttached()) {
            this.efW.setVisibility(0);
            this.hzB.dettachView(this.mRootView);
        }
    }
}
