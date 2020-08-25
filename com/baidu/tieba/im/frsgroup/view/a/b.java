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
    private TbPageContext<?> efn;
    private BdTypeListView fCP;
    private PbListView fDW;
    private g fMN;
    private h jqT;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.efn = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.fCP = new BdTypeListView(tbPageContext.getPageActivity());
        this.fCP.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.fCP.setSelector(17170445);
        this.fCP.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.efn);
        this.mPullView.setTag(this.efn.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.fCP.setOnSrollToBottomListener(cVar);
        this.fCP.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.fCP, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.fCP);
    }

    public void qH(boolean z) {
        if (this.mHeaderView != null && this.fCP != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void dL(List<com.baidu.adp.widget.ListView.a> list) {
        if (!y.isEmpty(list)) {
            this.fCP.addAdapters(list);
        }
    }

    public void cY(List<q> list) {
        if (list != null) {
            this.fCP.setData(list);
        }
    }

    public void completePullRefresh() {
        this.fCP.completePullRefreshPostDelayed(0L);
    }

    public void cvw() {
        cFC();
        this.fDW.startLoadData();
    }

    public void cvx() {
        cFC();
        this.fDW.setText(this.efn.getResources().getString(R.string.network_ungeilivable));
        this.fDW.endLoadData();
    }

    public void cvy() {
        cFC();
        this.fDW.setText(this.efn.getResources().getString(R.string.list_no_more));
        this.fDW.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.fCP, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fDW != null) {
            this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fDW.changeSkin(i);
        }
        if (this.jqT != null) {
            this.jqT.onChangeSkinType();
        }
        if (this.fMN != null) {
            this.fMN.onChangeSkinType();
        }
    }

    public void cFB() {
        if (this.fCP != null) {
            this.fCP.setNextPage(null);
            this.fDW = null;
        }
    }

    private void cFC() {
        if (this.fCP != null && this.fDW == null) {
            this.fDW = new PbListView(this.efn.getPageActivity());
            this.fDW.createView();
            this.fCP.setNextPage(this.fDW);
        }
    }

    public void showLoadingView() {
        if (this.fMN == null) {
            this.fMN = new g(this.efn.getPageActivity(), BdListViewHelper.eUU);
            this.fMN.onChangeSkinType();
        }
        if (!this.fMN.isViewAttached()) {
            this.fCP.setVisibility(8);
            this.fMN.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.fMN != null && this.fMN.isViewAttached()) {
            this.fCP.setVisibility(0);
            this.fMN.dettachView(this.mRootView);
        }
    }

    public void d(String str, View.OnClickListener onClickListener) {
        if (this.jqT == null) {
            this.jqT = new h(this.efn.getPageActivity(), onClickListener);
            this.jqT.setLayoutMargin(BdListViewHelper.eUU);
            this.jqT.onChangeSkinType();
        }
        if (!this.jqT.isViewAttached()) {
            this.fCP.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.efn.getString(R.string.invite_friend_no_data_now);
            }
            this.jqT.setTitle(str);
            this.jqT.attachView(this.mRootView, true);
            this.jqT.showRefreshButton();
        }
    }

    public void bFW() {
        if (this.jqT != null && this.jqT.isViewAttached()) {
            this.fCP.setVisibility(0);
            this.jqT.dettachView(this.mRootView);
        }
    }
}
