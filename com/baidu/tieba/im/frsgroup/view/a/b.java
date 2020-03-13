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
    private TbPageContext<?> cVi;
    private BdTypeListView eko;
    private PbListView elw;
    private g euk;
    private h hBO;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.h mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.cVi = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.eko = new BdTypeListView(tbPageContext.getPageActivity());
        this.eko.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.eko.setSelector(17170445);
        this.eko.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.cVi);
        this.mPullView.setTag(this.cVi.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.eko.setOnSrollToBottomListener(cVar);
        this.eko.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.eko, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.eko);
    }

    public void nE(boolean z) {
        if (this.mHeaderView != null && this.eko != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void cZ(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.isEmpty(list)) {
            this.eko.addAdapters(list);
        }
    }

    public void cz(List<m> list) {
        if (list != null) {
            this.eko.setData(list);
        }
    }

    public void completePullRefresh() {
        this.eko.completePullRefreshPostDelayed(0L);
    }

    public void bMB() {
        bVz();
        this.elw.startLoadData();
    }

    public void bMC() {
        bVz();
        this.elw.setText(this.cVi.getResources().getString(R.string.network_ungeilivable));
        this.elw.endLoadData();
    }

    public void bMD() {
        bVz();
        this.elw.setText(this.cVi.getResources().getString(R.string.list_no_more));
        this.elw.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.eko, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.elw != null) {
            this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.elw.setTextColor(am.getColor(R.color.cp_cont_d));
            this.elw.changeSkin(i);
        }
        if (this.hBO != null) {
            this.hBO.onChangeSkinType();
        }
        if (this.euk != null) {
            this.euk.onChangeSkinType();
        }
    }

    public void bVy() {
        if (this.eko != null) {
            this.eko.setNextPage(null);
            this.elw = null;
        }
    }

    private void bVz() {
        if (this.eko != null && this.elw == null) {
            this.elw = new PbListView(this.cVi.getPageActivity());
            this.elw.createView();
            this.eko.setNextPage(this.elw);
        }
    }

    public void showLoadingView() {
        if (this.euk == null) {
            this.euk = new g(this.cVi.getPageActivity(), BdListViewHelper.NET_RERESHNEW_TOP_MARGIN);
            this.euk.onChangeSkinType();
        }
        if (!this.euk.isViewAttached()) {
            this.eko.setVisibility(8);
            this.euk.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.euk != null && this.euk.isViewAttached()) {
            this.eko.setVisibility(0);
            this.euk.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.hBO == null) {
            this.hBO = new h(this.cVi.getPageActivity(), onClickListener);
            this.hBO.setLayoutMargin(BdListViewHelper.NET_RERESHNEW_TOP_MARGIN);
            this.hBO.onChangeSkinType();
        }
        if (!this.hBO.isViewAttached()) {
            this.eko.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.cVi.getString(R.string.invite_friend_no_data_now);
            }
            this.hBO.setTitle(str);
            this.hBO.attachView(this.mRootView, true);
            this.hBO.showRefreshButton();
        }
    }

    public void bcy() {
        if (this.hBO != null && this.hBO.isViewAttached()) {
            this.eko.setVisibility(0);
            this.hBO.dettachView(this.mRootView);
        }
    }
}
