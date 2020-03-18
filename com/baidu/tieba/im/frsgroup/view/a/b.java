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
    private TbPageContext<?> cVv;
    private BdTypeListView ekE;
    private PbListView elM;
    private g euG;
    private h hDo;
    private View mHeaderView;
    private com.baidu.tbadk.core.view.h mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.cVv = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.ekE = new BdTypeListView(tbPageContext.getPageActivity());
        this.ekE.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.ekE.setSelector(17170445);
        this.ekE.setDividerHeight(0);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.cVv);
        this.mPullView.setTag(this.cVv.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.ekE.setOnSrollToBottomListener(cVar);
        this.ekE.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.ekE, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.isNetWorkAvailable());
        this.mRootView.addView(this.ekE);
    }

    public void nK(boolean z) {
        if (this.mHeaderView != null && this.ekE != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void cZ(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.isEmpty(list)) {
            this.ekE.addAdapters(list);
        }
    }

    public void cz(List<m> list) {
        if (list != null) {
            this.ekE.setData(list);
        }
    }

    public void completePullRefresh() {
        this.ekE.completePullRefreshPostDelayed(0L);
    }

    public void bMP() {
        bVR();
        this.elM.startLoadData();
    }

    public void bMQ() {
        bVR();
        this.elM.setText(this.cVv.getResources().getString(R.string.network_ungeilivable));
        this.elM.endLoadData();
    }

    public void bMR() {
        bVR();
        this.elM.setText(this.cVv.getResources().getString(R.string.list_no_more));
        this.elM.endLoadData();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.ekE, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.elM != null) {
            this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_c);
            this.elM.setTextColor(am.getColor(R.color.cp_cont_d));
            this.elM.changeSkin(i);
        }
        if (this.hDo != null) {
            this.hDo.onChangeSkinType();
        }
        if (this.euG != null) {
            this.euG.onChangeSkinType();
        }
    }

    public void bVQ() {
        if (this.ekE != null) {
            this.ekE.setNextPage(null);
            this.elM = null;
        }
    }

    private void bVR() {
        if (this.ekE != null && this.elM == null) {
            this.elM = new PbListView(this.cVv.getPageActivity());
            this.elM.createView();
            this.ekE.setNextPage(this.elM);
        }
    }

    public void showLoadingView() {
        if (this.euG == null) {
            this.euG = new g(this.cVv.getPageActivity(), BdListViewHelper.NET_RERESHNEW_TOP_MARGIN);
            this.euG.onChangeSkinType();
        }
        if (!this.euG.isViewAttached()) {
            this.ekE.setVisibility(8);
            this.euG.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.euG != null && this.euG.isViewAttached()) {
            this.ekE.setVisibility(0);
            this.euG.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.hDo == null) {
            this.hDo = new h(this.cVv.getPageActivity(), onClickListener);
            this.hDo.setLayoutMargin(BdListViewHelper.NET_RERESHNEW_TOP_MARGIN);
            this.hDo.onChangeSkinType();
        }
        if (!this.hDo.isViewAttached()) {
            this.ekE.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.cVv.getString(R.string.invite_friend_no_data_now);
            }
            this.hDo.setTitle(str);
            this.hDo.attachView(this.mRootView, true);
            this.hDo.showRefreshButton();
        }
    }

    public void bcC() {
        if (this.hDo != null && this.hDo.isViewAttached()) {
            this.ekE.setVisibility(0);
            this.hDo.dettachView(this.mRootView);
        }
    }
}
