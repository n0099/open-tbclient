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
import com.baidu.tbadk.core.util.al;
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
    private g dhX;
    private PbListView dlX;
    private h gBQ;
    private TbPageContext<?> mContext;
    private View mHeaderView;
    private BdTypeListView mListView;
    private i mPullView;
    private ViewGroup mRootView;

    public b(TbPageContext<?> tbPageContext, c cVar) {
        this.mContext = tbPageContext;
        this.mRootView = new FrameLayout(tbPageContext.getPageActivity());
        this.mRootView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mListView = new BdTypeListView(tbPageContext.getPageActivity());
        this.mListView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.mListView.setSelector(17170445);
        this.mListView.setDividerHeight(0);
        this.mPullView = new i(this.mContext);
        this.mPullView.setTag(this.mContext.getUniqueId());
        this.mPullView.setListPullRefreshListener(cVar);
        this.mListView.setOnSrollToBottomListener(cVar);
        this.mListView.setPullRefresh(this.mPullView);
        this.mHeaderView = BdListViewHelper.a(tbPageContext.getPageActivity(), this.mListView, BdListViewHelper.HeadType.HASTAB);
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, j.jS());
        this.mRootView.addView(this.mListView);
    }

    public void lX(boolean z) {
        if (this.mHeaderView != null && this.mListView != null) {
            BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.HASTAB, z);
        }
    }

    public void da(List<com.baidu.adp.widget.ListView.a> list) {
        if (!v.aa(list)) {
            this.mListView.addAdapters(list);
        }
    }

    public void cx(List<m> list) {
        if (list != null) {
            this.mListView.setData(list);
        }
    }

    public void completePullRefresh() {
        this.mListView.completePullRefreshPostDelayed(0L);
    }

    public void bsm() {
        bBd();
        this.dlX.ajy();
    }

    public void bsn() {
        bBd();
        this.dlX.setText(this.mContext.getResources().getString(R.string.network_ungeilivable));
        this.dlX.ajz();
    }

    public void bso() {
        bBd();
        this.dlX.setText(this.mContext.getResources().getString(R.string.list_no_more));
        this.dlX.ajz();
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onChangeSkinType(int i) {
        al.l(this.mListView, R.color.cp_bg_line_c);
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        if (this.dlX != null) {
            this.dlX.iO(R.color.cp_bg_line_c);
            this.dlX.setTextColor(al.getColor(R.color.cp_cont_d));
            this.dlX.iP(i);
        }
        if (this.gBQ != null) {
            this.gBQ.onChangeSkinType();
        }
        if (this.dhX != null) {
            this.dhX.onChangeSkinType();
        }
    }

    public void bBc() {
        if (this.mListView != null) {
            this.mListView.setNextPage(null);
            this.dlX = null;
        }
    }

    private void bBd() {
        if (this.mListView != null && this.dlX == null) {
            this.dlX = new PbListView(this.mContext.getPageActivity());
            this.dlX.nG();
            this.mListView.setNextPage(this.dlX);
        }
    }

    public void showLoadingView() {
        if (this.dhX == null) {
            this.dhX = new g(this.mContext.getPageActivity(), BdListViewHelper.cBh);
            this.dhX.onChangeSkinType();
        }
        if (!this.dhX.isViewAttached()) {
            this.mListView.setVisibility(8);
            this.dhX.attachView(this.mRootView, true);
        }
    }

    public void hideLoadingView() {
        if (this.dhX != null && this.dhX.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.dhX.dettachView(this.mRootView);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.gBQ == null) {
            this.gBQ = new h(this.mContext.getPageActivity(), onClickListener);
            this.gBQ.kE(BdListViewHelper.cBh);
            this.gBQ.onChangeSkinType();
        }
        if (!this.gBQ.isViewAttached()) {
            this.mListView.setVisibility(8);
            if (StringUtils.isNull(str)) {
                str = this.mContext.getString(R.string.invite_friend_no_data_now);
            }
            this.gBQ.setTitle(str);
            this.gBQ.attachView(this.mRootView, true);
            this.gBQ.asB();
        }
    }

    public void aHH() {
        if (this.gBQ != null && this.gBQ.isViewAttached()) {
            this.mListView.setVisibility(0);
            this.gBQ.dettachView(this.mRootView);
        }
    }
}
