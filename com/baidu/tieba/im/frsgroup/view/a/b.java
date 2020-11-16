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
/* loaded from: classes22.dex */
public class b {
    private TbPageContext<?> eGu;
    private BdTypeListView ghN;
    private PbListView giV;
    private g grV;
    private h khE;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.eGu = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.ghN = new BdTypeListView(tbPageContext.getPageActivity());
        this.ghN.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.ghN.setSelector(17170445);
        this.ghN.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.g(this.eGu);
        this.mPullView.setTag(this.eGu.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.ghN.setOnSrollToBottomListener(cVar);
        this.ghN.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.ghN, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.ghN);
    }

    public void sb(boolean z) {
        if (this.mHeaderView != null && this.ghN != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void en(List<com.baidu.adp.widget.ListView.a> list) {
        if (!y.isEmpty(list)) {
            this.ghN.addAdapters(list);
        }
    }

    public void dy(List<q> list) {
        if (list != null) {
            this.ghN.setData(list);
        }
    }

    public void completePullRefresh() {
        this.ghN.completePullRefreshPostDelayed(0L);
    }

    public void cHA() {
        cSg();
        this.giV.startLoadData();
    }

    public void cHB() {
        cSg();
        this.giV.setText(this.eGu.getResources().getString(R.string.network_ungeilivable));
        this.giV.endLoadData();
    }

    public void cHC() {
        cSg();
        this.giV.setText(this.eGu.getResources().getString(R.string.list_no_more));
        this.giV.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.ghN, R.color.CAM_X0204);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.giV != null) {
            this.giV.setContainerBackgroundColorResId(R.color.CAM_X0204);
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.giV.changeSkin(i);
        }
        if (this.khE != null) {
            this.khE.onChangeSkinType();
        }
        if (this.grV != null) {
            this.grV.onChangeSkinType();
        }
    }

    public void cSf() {
        if (this.ghN != null) {
            this.ghN.setNextPage(null);
            this.giV = null;
        }
    }

    private void cSg() {
        if (this.ghN != null && this.giV == null) {
            this.giV = new PbListView(this.eGu.getPageActivity());
            this.giV.createView();
            this.ghN.setNextPage(this.giV);
        }
    }

    public void showLoadingView() {
        if (this.grV == null) {
            this.grV = new g(this.eGu.getPageActivity(), BdListViewHelper.fxH);
            this.grV.onChangeSkinType();
        }
        if (!this.grV.isViewAttached()) {
            this.ghN.setVisibility(8);
            this.grV.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.grV != null && this.grV.isViewAttached()) {
            this.ghN.setVisibility(0);
            this.grV.dettachView(this.mRootView);
        }
    }

    public void d(String str, View.OnClickListener onClickListener) {
        if (this.khE == null) {
            this.khE = new h(this.eGu.getPageActivity(), onClickListener);
            this.khE.setLayoutMargin(BdListViewHelper.fxH);
            this.khE.onChangeSkinType();
        }
        if (!this.khE.isViewAttached()) {
            this.ghN.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.eGu.getString(R.string.invite_friend_no_data_now);
            }
            this.khE.setTitle(str);
            this.khE.attachView(this.mRootView, true);
            this.khE.showRefreshButton();
        }
    }

    public void VB() {
        if (this.khE != null && this.khE.isViewAttached()) {
            this.ghN.setVisibility(0);
            this.khE.dettachView(this.mRootView);
        }
    }
}
