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
    private TbPageContext<?> cVg;
    private BdTypeListView eka;
    private PbListView eli;
    private g etW;
    private h hBA;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.h mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.cVg = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.eka = new BdTypeListView(tbPageContext.getPageActivity());
        this.eka.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.eka.setSelector(17170445);
        this.eka.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.cVg);
        this.mPullView.setTag(this.cVg.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.eka.setOnSrollToBottomListener(cVar);
        this.eka.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.eka, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.eka);
    }

    public void nE(boolean z) {
        if (this.mHeaderView != null && this.eka != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void cZ(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.isEmpty(list)) {
            this.eka.addAdapters(list);
        }
    }

    public void cz(List<m> list) {
        if (list != null) {
            this.eka.setData(list);
        }
    }

    public void completePullRefresh() {
        this.eka.completePullRefreshPostDelayed(0L);
    }

    public void bMy() {
        bVw();
        this.eli.startLoadData();
    }

    public void bMz() {
        bVw();
        this.eli.setText(this.cVg.getResources().getString(R.string.network_ungeilivable));
        this.eli.endLoadData();
    }

    public void bMA() {
        bVw();
        this.eli.setText(this.cVg.getResources().getString(R.string.list_no_more));
        this.eli.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.eka, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.eli != null) {
            this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.eli.setTextColor(am.getColor(R.color.cp_cont_d));
            this.eli.changeSkin(i);
        }
        if (this.hBA != null) {
            this.hBA.onChangeSkinType();
        }
        if (this.etW != null) {
            this.etW.onChangeSkinType();
        }
    }

    public void bVv() {
        if (this.eka != null) {
            this.eka.setNextPage(null);
            this.eli = null;
        }
    }

    private void bVw() {
        if (this.eka != null && this.eli == null) {
            this.eli = new PbListView(this.cVg.getPageActivity());
            this.eli.createView();
            this.eka.setNextPage(this.eli);
        }
    }

    public void showLoadingView() {
        if (this.etW == null) {
            this.etW = new g(this.cVg.getPageActivity(), BdListViewHelper.NET_RERESHNEW_TOP_MARGIN);
            this.etW.onChangeSkinType();
        }
        if (!this.etW.isViewAttached()) {
            this.eka.setVisibility(8);
            this.etW.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.etW != null && this.etW.isViewAttached()) {
            this.eka.setVisibility(0);
            this.etW.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.hBA == null) {
            this.hBA = new h(this.cVg.getPageActivity(), onClickListener);
            this.hBA.setLayoutMargin(BdListViewHelper.NET_RERESHNEW_TOP_MARGIN);
            this.hBA.onChangeSkinType();
        }
        if (!this.hBA.isViewAttached()) {
            this.eka.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.cVg.getString(R.string.invite_friend_no_data_now);
            }
            this.hBA.setTitle(str);
            this.hBA.attachView(this.mRootView, true);
            this.hBA.showRefreshButton();
        }
    }

    public void bcv() {
        if (this.hBA != null && this.hBA.isViewAttached()) {
            this.eka.setVisibility(0);
            this.hBA.dettachView(this.mRootView);
        }
    }
}
