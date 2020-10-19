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
    private TbPageContext<?> etO;
    private BdTypeListView fSo;
    private PbListView fTv;
    private g gcx;
    private h jOy;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.etO = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.fSo = new BdTypeListView(tbPageContext.getPageActivity());
        this.fSo.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.fSo.setSelector(17170445);
        this.fSo.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.etO);
        this.mPullView.setTag(this.etO.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.fSo.setOnSrollToBottomListener(cVar);
        this.fSo.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.fSo, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.fSo);
    }

    public void rx(boolean z) {
        if (this.mHeaderView != null && this.fSo != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void dW(List<com.baidu.adp.widget.ListView.a> list) {
        if (!y.isEmpty(list)) {
            this.fSo.addAdapters(list);
        }
    }

    public void dh(List<q> list) {
        if (list != null) {
            this.fSo.setData(list);
        }
    }

    public void completePullRefresh() {
        this.fSo.completePullRefreshPostDelayed(0L);
    }

    public void cCn() {
        cMS();
        this.fTv.startLoadData();
    }

    public void cCo() {
        cMS();
        this.fTv.setText(this.etO.getResources().getString(R.string.network_ungeilivable));
        this.fTv.endLoadData();
    }

    public void cCp() {
        cMS();
        this.fTv.setText(this.etO.getResources().getString(R.string.list_no_more));
        this.fTv.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.fSo, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fTv != null) {
            this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fTv.changeSkin(i);
        }
        if (this.jOy != null) {
            this.jOy.onChangeSkinType();
        }
        if (this.gcx != null) {
            this.gcx.onChangeSkinType();
        }
    }

    public void cMR() {
        if (this.fSo != null) {
            this.fSo.setNextPage(null);
            this.fTv = null;
        }
    }

    private void cMS() {
        if (this.fSo != null && this.fTv == null) {
            this.fTv = new PbListView(this.etO.getPageActivity());
            this.fTv.createView();
            this.fSo.setNextPage(this.fTv);
        }
    }

    public void showLoadingView() {
        if (this.gcx == null) {
            this.gcx = new g(this.etO.getPageActivity(), BdListViewHelper.fkb);
            this.gcx.onChangeSkinType();
        }
        if (!this.gcx.isViewAttached()) {
            this.fSo.setVisibility(8);
            this.gcx.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.gcx != null && this.gcx.isViewAttached()) {
            this.fSo.setVisibility(0);
            this.gcx.dettachView(this.mRootView);
        }
    }

    public void d(String str, View.OnClickListener onClickListener) {
        if (this.jOy == null) {
            this.jOy = new h(this.etO.getPageActivity(), onClickListener);
            this.jOy.setLayoutMargin(BdListViewHelper.fkb);
            this.jOy.onChangeSkinType();
        }
        if (!this.jOy.isViewAttached()) {
            this.fSo.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.etO.getString(R.string.invite_friend_no_data_now);
            }
            this.jOy.setTitle(str);
            this.jOy.attachView(this.mRootView, true);
            this.jOy.showRefreshButton();
        }
    }

    public void SK() {
        if (this.jOy != null && this.jOy.isViewAttached()) {
            this.fSo.setVisibility(0);
            this.jOy.dettachView(this.mRootView);
        }
    }
}
