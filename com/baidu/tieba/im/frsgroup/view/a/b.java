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
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    private TbPageContext<?> ceu;
    private g dDz;
    private BdTypeListView duK;
    private PbListView dvS;
    private h gHU;
    private View mHeaderView;
    private i mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.ceu = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.duK = new BdTypeListView(tbPageContext.getPageActivity());
        this.duK.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.duK.setSelector(17170445);
        this.duK.setDividerHeight(0);
        this.mPullView = new i(this.ceu);
        this.mPullView.setTag(this.ceu.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.duK.setOnSrollToBottomListener(cVar);
        this.duK.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.duK, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.duK);
    }

    public void md(boolean z) {
        if (this.mHeaderView != null && this.duK != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m25do(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.isEmpty(list)) {
            this.duK.addAdapters(list);
        }
    }

    public void cK(List<m> list) {
        if (list != null) {
            this.duK.setData(list);
        }
    }

    public void completePullRefresh() {
        this.duK.completePullRefreshPostDelayed(0L);
    }

    public void bsw() {
        bBz();
        this.dvS.startLoadData();
    }

    public void bsx() {
        bBz();
        this.dvS.setText(this.ceu.getResources().getString(R.string.network_ungeilivable));
        this.dvS.endLoadData();
    }

    public void bsy() {
        bBz();
        this.dvS.setText(this.ceu.getResources().getString(R.string.list_no_more));
        this.dvS.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.duK, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.dvS != null) {
            this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.dvS.setTextColor(am.getColor(R.color.cp_cont_d));
            this.dvS.changeSkin(i);
        }
        if (this.gHU != null) {
            this.gHU.onChangeSkinType();
        }
        if (this.dDz != null) {
            this.dDz.onChangeSkinType();
        }
    }

    public void bBy() {
        if (this.duK != null) {
            this.duK.setNextPage(null);
            this.dvS = null;
        }
    }

    private void bBz() {
        if (this.duK != null && this.dvS == null) {
            this.dvS = new PbListView(this.ceu.getPageActivity());
            this.dvS.createView();
            this.duK.setNextPage(this.dvS);
        }
    }

    public void showLoadingView() {
        if (this.dDz == null) {
            this.dDz = new g(this.ceu.getPageActivity(), BdListViewHelper.NET_RERESHNEW_TOP_MARGIN);
            this.dDz.onChangeSkinType();
        }
        if (!this.dDz.isViewAttached()) {
            this.duK.setVisibility(8);
            this.dDz.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.dDz != null && this.dDz.isViewAttached()) {
            this.duK.setVisibility(0);
            this.dDz.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.gHU == null) {
            this.gHU = new h(this.ceu.getPageActivity(), onClickListener);
            this.gHU.setLayoutMargin(BdListViewHelper.NET_RERESHNEW_TOP_MARGIN);
            this.gHU.onChangeSkinType();
        }
        if (!this.gHU.isViewAttached()) {
            this.duK.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.ceu.getString(R.string.invite_friend_no_data_now);
            }
            this.gHU.setTitle(str);
            this.gHU.attachView(this.mRootView, true);
            this.gHU.showRefreshButton();
        }
    }

    public void aJm() {
        if (this.gHU != null && this.gHU.isViewAttached()) {
            this.duK.setVisibility(0);
            this.gHU.dettachView(this.mRootView);
        }
    }
}
