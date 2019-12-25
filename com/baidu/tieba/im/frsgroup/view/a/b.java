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
/* loaded from: classes7.dex */
public class b {
    private TbPageContext<?> cQU;
    private BdTypeListView efM;
    private PbListView egU;
    private g eoy;
    private h hvY;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.h mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.cQU = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.efM = new BdTypeListView(tbPageContext.getPageActivity());
        this.efM.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.efM.setSelector(17170445);
        this.efM.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.cQU);
        this.mPullView.setTag(this.cQU.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.efM.setOnSrollToBottomListener(cVar);
        this.efM.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.efM, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.efM);
    }

    public void nq(boolean z) {
        if (this.mHeaderView != null && this.efM != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void dd(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.isEmpty(list)) {
            this.efM.addAdapters(list);
        }
    }

    public void cD(List<m> list) {
        if (list != null) {
            this.efM.setData(list);
        }
    }

    public void completePullRefresh() {
        this.efM.completePullRefreshPostDelayed(0L);
    }

    public void bJR() {
        bSM();
        this.egU.startLoadData();
    }

    public void bJS() {
        bSM();
        this.egU.setText(this.cQU.getResources().getString(R.string.network_ungeilivable));
        this.egU.endLoadData();
    }

    public void bJT() {
        bSM();
        this.egU.setText(this.cQU.getResources().getString(R.string.list_no_more));
        this.egU.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.efM, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.egU != null) {
            this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.egU.setTextColor(am.getColor(R.color.cp_cont_d));
            this.egU.changeSkin(i);
        }
        if (this.hvY != null) {
            this.hvY.onChangeSkinType();
        }
        if (this.eoy != null) {
            this.eoy.onChangeSkinType();
        }
    }

    public void bSL() {
        if (this.efM != null) {
            this.efM.setNextPage(null);
            this.egU = null;
        }
    }

    private void bSM() {
        if (this.efM != null && this.egU == null) {
            this.egU = new PbListView(this.cQU.getPageActivity());
            this.egU.createView();
            this.efM.setNextPage(this.egU);
        }
    }

    public void showLoadingView() {
        if (this.eoy == null) {
            this.eoy = new g(this.cQU.getPageActivity(), BdListViewHelper.NET_RERESHNEW_TOP_MARGIN);
            this.eoy.onChangeSkinType();
        }
        if (!this.eoy.isViewAttached()) {
            this.efM.setVisibility(8);
            this.eoy.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.eoy != null && this.eoy.isViewAttached()) {
            this.efM.setVisibility(0);
            this.eoy.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.hvY == null) {
            this.hvY = new h(this.cQU.getPageActivity(), onClickListener);
            this.hvY.setLayoutMargin(BdListViewHelper.NET_RERESHNEW_TOP_MARGIN);
            this.hvY.onChangeSkinType();
        }
        if (!this.hvY.isViewAttached()) {
            this.efM.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.cQU.getString(R.string.invite_friend_no_data_now);
            }
            this.hvY.setTitle(str);
            this.hvY.attachView(this.mRootView, true);
            this.hvY.showRefreshButton();
        }
    }

    public void aZK() {
        if (this.hvY != null && this.hvY.isViewAttached()) {
            this.efM.setVisibility(0);
            this.hvY.dettachView(this.mRootView);
        }
    }
}
