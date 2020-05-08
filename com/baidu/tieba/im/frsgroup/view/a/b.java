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
    private TbPageContext<?> duK;
    private BdTypeListView eOj;
    private PbListView ePr;
    private g eYg;
    private h inj;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.h mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.duK = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.eOj = new BdTypeListView(tbPageContext.getPageActivity());
        this.eOj.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.eOj.setSelector(17170445);
        this.eOj.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.duK);
        this.mPullView.setTag(this.duK.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.eOj.setOnSrollToBottomListener(cVar);
        this.eOj.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.eOj, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.eOj);
    }

    public void oO(boolean z) {
        if (this.mHeaderView != null && this.eOj != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void dk(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.isEmpty(list)) {
            this.eOj.addAdapters(list);
        }
    }

    public void cK(List<m> list) {
        if (list != null) {
            this.eOj.setData(list);
        }
    }

    public void completePullRefresh() {
        this.eOj.completePullRefreshPostDelayed(0L);
    }

    public void bXo() {
        cgq();
        this.ePr.startLoadData();
    }

    public void bXp() {
        cgq();
        this.ePr.setText(this.duK.getResources().getString(R.string.network_ungeilivable));
        this.ePr.endLoadData();
    }

    public void bXq() {
        cgq();
        this.ePr.setText(this.duK.getResources().getString(R.string.list_no_more));
        this.ePr.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.eOj, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.ePr != null) {
            this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.ePr.setTextColor(am.getColor(R.color.cp_cont_d));
            this.ePr.changeSkin(i);
        }
        if (this.inj != null) {
            this.inj.onChangeSkinType();
        }
        if (this.eYg != null) {
            this.eYg.onChangeSkinType();
        }
    }

    public void cgp() {
        if (this.eOj != null) {
            this.eOj.setNextPage(null);
            this.ePr = null;
        }
    }

    private void cgq() {
        if (this.eOj != null && this.ePr == null) {
            this.ePr = new PbListView(this.duK.getPageActivity());
            this.ePr.createView();
            this.eOj.setNextPage(this.ePr);
        }
    }

    public void showLoadingView() {
        if (this.eYg == null) {
            this.eYg = new g(this.duK.getPageActivity(), BdListViewHelper.egB);
            this.eYg.onChangeSkinType();
        }
        if (!this.eYg.isViewAttached()) {
            this.eOj.setVisibility(8);
            this.eYg.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.eYg != null && this.eYg.isViewAttached()) {
            this.eOj.setVisibility(0);
            this.eYg.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.inj == null) {
            this.inj = new h(this.duK.getPageActivity(), onClickListener);
            this.inj.setLayoutMargin(BdListViewHelper.egB);
            this.inj.onChangeSkinType();
        }
        if (!this.inj.isViewAttached()) {
            this.eOj.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.duK.getString(R.string.invite_friend_no_data_now);
            }
            this.inj.setTitle(str);
            this.inj.attachView(this.mRootView, true);
            this.inj.showRefreshButton();
        }
    }

    public void blr() {
        if (this.inj != null && this.inj.isViewAttached()) {
            this.eOj.setVisibility(0);
            this.inj.dettachView(this.mRootView);
        }
    }
}
